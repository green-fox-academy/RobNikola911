package com.exercise.greenfoxclass.controllers;

import com.exercise.greenfoxclass.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/gfa")
    public String gfaMain(){
        return "index";
    }

    @GetMapping("/gfa/list")
    public String gfaStudents(Model model){
        model.addAttribute("students", studentService.findAll());
        return "index";
    }

}
