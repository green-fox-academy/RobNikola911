package com.exercise.greenfoxclass.controllers;

import com.exercise.greenfoxclass.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/gfa")
    public String gfaMain(Model model){
        model.addAttribute("count", studentService.count());
        return "index";
    }

    @GetMapping("/gfa/list")
    public String gfaStudents(Model model){
        model.addAttribute("count", studentService.count());
        model.addAttribute("students", studentService.findAll());
        return "index";
    }

    @GetMapping("gfa/add")
    public String addStudent(Model model) {
        model.addAttribute("count", studentService.count());
        return "add-student";
    }

    @PostMapping("gfa/save")
    public String saveStudent(Model model, @RequestParam(required = true) String name) {
        studentService.save(name);
        return "redirect:/gfa/list";
    }

    @GetMapping("gfa/check")
    public String checkStudent(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("count", studentService.count());
        model.addAttribute("check", studentService.checker(name));
        return "check";
    }

    @PostMapping("gfa/check")
    public String displayStudent(Model model, @RequestParam String name) {
        model.addAttribute("checked",  studentService.checker(name));
        model.addAttribute("name", name);
        return "check";
    }

}
