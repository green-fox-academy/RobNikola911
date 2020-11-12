package com.greenfox.orientationmentors.models.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfox.orientationmentors.models.ClassName;
import com.greenfox.orientationmentors.models.Mentor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorDTO {

    @JsonIgnore
    private Long id;
    private String name;
    @JsonIgnore
    private String className;
    @JsonIgnore
    private ClassName clasName;


    public MentorDTO(Mentor mentor) {
        this.name = mentor.getName();
        this.id = mentor.getId();
        this.clasName = mentor.getClassName();
    }

    public MentorDTO(String name, String className) {
        this.name = name;
        this.className = className;
    }
}