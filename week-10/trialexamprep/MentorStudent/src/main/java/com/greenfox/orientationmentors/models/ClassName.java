package com.greenfox.orientationmentors.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "class_names")
public class ClassName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    //    @OneToMany(mappedBy = "className", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @OneToMany
    private List<Mentor> mentors;

    public ClassName() {
        this.mentors = new ArrayList<>();
    }

    public ClassName(String name) {
        this();
        this.name = name;
    }

    public ClassName(String name, List<Mentor> mentors) {
        this.name = name;
        this.mentors = mentors;
    }
}
