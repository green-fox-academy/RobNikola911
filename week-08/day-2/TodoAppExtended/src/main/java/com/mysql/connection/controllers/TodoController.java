package com.mysql.connection.controllers;

import com.mysql.connection.models.Todo;
import com.mysql.connection.repositories.TodoRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping({"/", "/list"})
    public String list(Model model, @RequestParam(required = false) Boolean isActive) {
        List<Todo> todos;
        if (isActive == null){
            todos = todoRepository.findAll();
        } else {
            todos = todoRepository.findAll().stream()
                    .filter(n -> n.getDone() != isActive)
                    .collect(Collectors.toList());
        }
        model.addAttribute("todos", todos);
        return "todolist";
    }

    @GetMapping("/add")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "view";
    }

    @PostMapping("/add")
    public String addingTodo(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todo/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        //delete item by id
        todoRepository.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("/{id}/edit")
    public String editTodoByIdPage(@PathVariable long id, Model model) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
        model.addAttribute("todo", todo.get());
        return "edit";
        }
        return "redirect:/todo/list";
    }

    @PostMapping("/edit")
    public String editTodoById(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todo/list";
    }
}
