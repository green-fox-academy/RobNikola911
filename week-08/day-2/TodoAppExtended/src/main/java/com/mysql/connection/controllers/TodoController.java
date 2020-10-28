package com.mysql.connection.controllers;

import com.mysql.connection.models.Todo;
import com.mysql.connection.repositories.AssigneeRepository;
import com.mysql.connection.services.TodoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/todo")
public class TodoController implements CommandLineRunner {

    private final TodoService todoService;
    private final AssigneeRepository assigneeRepository;

    public TodoController(TodoService todoService, AssigneeRepository assigneeRepository) {
        this.todoService = todoService;
        this.assigneeRepository = assigneeRepository;
    }


    @GetMapping({"", "/", "/list"})
    public String list(Model model, @RequestParam(required = false) Boolean isActive) {
        List<Todo> todos;
        if (isActive == null){
            todos = todoService.listAll();
        } else {
            todos = todoService.listByDone(!isActive);
        }
        model.addAttribute("todos", todos);
        return "todolist";
    }

    @GetMapping("/add")
    public String addTodo(Model model) {
        model.addAttribute("assignees", assigneeRepository.findAll());
        return "view";
    }

    @PostMapping("/add")
    public String addingTodo(@ModelAttribute("title") String title,
                             @ModelAttribute("description") String description,
                             @ModelAttribute("dueDate") String dueDateString,
                             @ModelAttribute("urgent") String urgent,
                             @ModelAttribute("assignee") Long assigneeId) {
        boolean urgentBoolean = (urgent.equals("true"))? true: false;
        LocalDate dueDate = LocalDate.parse(dueDateString);
        todoService.add(new Todo(title, description, dueDate,
                urgentBoolean, assigneeRepository.findById(assigneeId).get()));
        return "redirect:/todo/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        todoService.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("/{id}/edit")
    public String editTodoByIdPage(@PathVariable long id, Model model) {
        model.addAttribute("todo", todoService.getById(id));
        model.addAttribute("assignees", assigneeRepository.findAll());
        return "edit";
    }

    @ModelAttribute
    LocalDate initLocalDate() {
        return LocalDate.now();
    }

    @PostMapping("/edit")
    public String editTodoById(@ModelAttribute("id") long id,
                                @ModelAttribute("title") String title,
                               @ModelAttribute("description") String description,
                               @ModelAttribute("dueDate") String dueDateString,
                               @ModelAttribute("urgent") String urgent,
                               @ModelAttribute("done") String done,
                               @ModelAttribute("assignee") Long assigneeId) {
        boolean urgentBoolean = (urgent.equals("true"))? true: false;
        boolean doneBoolean = (done.equals("true"))? true: false;
        LocalDate dueDate = LocalDate.parse(dueDateString);
        todoService.add(new Todo(id, title, description, todoService.getById(id).getCreationDate(), dueDate,
                urgentBoolean, doneBoolean, assigneeRepository.findById(assigneeId).get()));
        return "redirect:/todo/list";
    }

    @PostMapping("/search-title")
    public String searchByTitle(@RequestParam(name = "search_term", required = false) String searchTerm
                            , Model model) {
        model.addAttribute("todos", todoService.listAllBy(searchTerm));
        return "todolist";
    }

    @PostMapping("/search-creation-date")
    public String searchByCreationDate(Model model, @RequestParam String dateSearch) {
        if(dateSearch.length() > 0) {
            model.addAttribute("todos", todoService.findAllByCreationDate(LocalDate.parse(dateSearch)));
        } else {
            model.addAttribute("todos", todoService.listAll());
        }

        return "todolist";
    }

    @PostMapping("/search-due-date")
    public String searchByDueDate(Model model, @RequestParam String dateSearch) {
        if(dateSearch.length() > 0) {
            model.addAttribute("todos", todoService.findAllByDueDate(LocalDate.parse(dateSearch)));
        } else {
            model.addAttribute("todos", todoService.listAll());
        }
        return "todolist";
    }

    @PostMapping("/search-assignee")
    public String searchByAssignee(Model model, @RequestParam String assigneeSearch) {
        model.addAttribute("todos", todoService.findByAssigneeName(assigneeSearch));
        return "todolist";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("assignee") Long id) {
        model.addAttribute("todos", todoService.findAllByAssignee_Id(id));
        return "todolist";
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
