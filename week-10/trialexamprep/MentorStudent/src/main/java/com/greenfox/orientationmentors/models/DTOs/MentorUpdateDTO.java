package com.greenfox.orientationmentors.models.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfox.orientationmentors.models.ClassName;
import com.greenfox.orientationmentors.models.Mentor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentorUpdateDTO {
    private String name;
    private String className;


    public MentorUpdateDTO() {
    }

    public MentorUpdateDTO(Mentor mentor) {
        this.name = mentor.getName();
        this.className = mentor.getClassName().getName();
    }

    public MentorUpdateDTO(String name, String className) {
        this.name = name;
        this.className = className;
    }
}