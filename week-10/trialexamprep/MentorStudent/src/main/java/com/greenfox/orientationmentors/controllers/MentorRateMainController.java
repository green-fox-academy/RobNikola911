package com.greenfox.orientationmentors.controllers;

import com.greenfox.orientationmentors.models.ClassName;
import com.greenfox.orientationmentors.models.DTOs.MentorDTO;
import com.greenfox.orientationmentors.models.DTOs.MentorUpdateDTO;
import com.greenfox.orientationmentors.models.DTOs.NameDTO;
import com.greenfox.orientationmentors.models.Mentor;
import com.greenfox.orientationmentors.services.ClassNameService;
import com.greenfox.orientationmentors.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MentorRateMainController {

    private final MentorService mentorService;
    private final ClassNameService classNameService;

    @Autowired
    public MentorRateMainController(MentorService mentorService, ClassNameService classNameService) {
        this.mentorService = mentorService;
        this.classNameService = classNameService;
    }


    @GetMapping("/")
    public String renderMainPage(Model model) {
        model.addAttribute("mentors", mentorService.listMentors());
        model.addAttribute("schoolClasses", classNameService.listClassNames());
        return "index";
    }

    @PostMapping("/mentor")
    public String saveNewMentor(@ModelAttribute MentorDTO mentor) {
        if (mentorService.isNameAlreadyTaken(mentor.getName())) {
            return "redirect:/err?error=taken-name";
        } else {
            return "redirect:/mentor/" + mentorService.saveNewMentorWithClassNameAndGetItsId(mentor);
        }
    }

    @GetMapping("/err")
    public String renderErrorPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            switch (error) {
                case "taken-name":
                    model.addAttribute("error", "The mentor already exists in the database.");
                    break;
                case "invalid-mentor":
                    model.addAttribute("error", "The mentor with the given ID does not exist.");
                    break;
                default:
                    model.addAttribute("error", "Unkown error.");
            }
        }
        return "error";
    }

    @GetMapping("/mentor/{id}")
    public String renderMentorPage(Model model, @PathVariable(name = "id") Long id) {
        Optional<Mentor> inputMentor = mentorService.findMentorById(id);
        if (inputMentor.isPresent()) {
            model.addAttribute("mentor", inputMentor.get());
            return "mentor";
        } else {
            return "redirect:/err?error=invalid-mentor";
        }
    }

    @GetMapping("/api/mentors")
    @ResponseBody   //needs finish
    public ResponseEntity<List<MentorDTO>> listMentorsToClassName(@RequestParam String className) {
        return ResponseEntity.ok().body(mentorService.getAllMentorsNamesInClass(className));
    }

    @PutMapping("/api/mentors/{mentorId}")
    @ResponseBody
    public ResponseEntity<Object> updateMentor(@PathVariable Long mentorId, @RequestBody MentorUpdateDTO mentorUpdateDTO) {
        Mentor mentor = mentorService.getMentorByID(mentorId);
        Boolean isClassNameExist = classNameService.isClassExist(mentorUpdateDTO.getClassName());
        if (mentor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (isClassNameExist) {
            mentorService.updateMentor(mentorId, mentorUpdateDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/api/mentors/{mentorId}")
    @ResponseBody
    public ResponseEntity<Object> deleteMentor(@PathVariable Long mentorId) {
        mentorService.deleteMentor(mentorId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
