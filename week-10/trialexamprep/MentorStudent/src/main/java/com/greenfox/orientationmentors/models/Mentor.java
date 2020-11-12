package com.greenfox.orientationmentors.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mentors")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    private ClassName className;

    public Mentor(String name) {
        this.name = name;
    }

    public Mentor(String name, ClassName className) {
        this.name = name;
        this.className = className;
    }
}
