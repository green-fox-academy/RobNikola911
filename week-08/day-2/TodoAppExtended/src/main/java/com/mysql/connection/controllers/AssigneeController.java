package com.mysql.connection.controllers;

import com.mysql.connection.models.Assignee;
import com.mysql.connection.repositories.AssigneeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assignee")
public class AssigneeController {

    private final AssigneeRepository assigneeRepository;

    public AssigneeController(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    @GetMapping({"", "/", "/list"})
    public String list(Model model) {
        model.addAttribute("assignees", assigneeRepository.findAll());
        return "assignees-list";
    }

    @GetMapping("/add")
    public String addPage() {
        return "add-assignee";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Assignee assignee) {
        assigneeRepository.save(assignee);
        return "redirect:/assignee";
    }

    @GetMapping("/{id}/delete")
    public String deleteAssigneeById(@PathVariable long id) {
        assigneeRepository.deleteById(id);
        return "redirect:/assignee/list";
    }

    @GetMapping("/{id}/edit")
    public String editAssigneeByIdPage(@PathVariable long id, Model model) {
        model.addAttribute("assignee", assigneeRepository.findById(id).get());
        return "edit-assignee";
    }

    @PostMapping("/edit")
    public String editAssigneeById(@ModelAttribute Assignee assignee) {
        assigneeRepository.save(assignee);
        return "redirect:/assignee/list";
    }
}
