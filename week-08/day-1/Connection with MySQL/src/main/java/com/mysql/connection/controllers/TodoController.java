package com.mysql.connection.controllers;

import com.mysql.connection.models.Todo;
import com.mysql.connection.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/todo")
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
    public String addTodo() {
        return "view";
    }

    @PostMapping("/add")
    public String addingTodo(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/list";
    }
}
