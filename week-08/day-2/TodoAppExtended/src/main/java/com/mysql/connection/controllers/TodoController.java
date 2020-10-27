package com.mysql.connection.controllers;

import com.mysql.connection.models.Todo;
import com.mysql.connection.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
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
    public String addTodo() {
        return "view";
    }

    @PostMapping("/add")
    public String addingTodo(@ModelAttribute Todo todo) {
        todoService.add(todo);
        return "redirect:/todo/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        //delete item by id
        todoService.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("/{id}/edit")
    public String editTodoByIdPage(@PathVariable long id, Model model) {
        model.addAttribute("todo", todoService.getById(id));
        return "edit";
        }

    @PostMapping("/edit")
    public String editTodoById(@ModelAttribute Todo todo) {
         todoService.edit(todo);
        return "redirect:/todo/list";
    }

    @PostMapping("/search")
    public String searchBy(@RequestParam(name = "search_term", required = false) String searchTerm,
                           @RequestParam("search_by") String searchBy, Model model) {
        model.addAttribute("todos", todoService.listAllBy(searchTerm, searchBy));
        return "todolist";
    }
}
