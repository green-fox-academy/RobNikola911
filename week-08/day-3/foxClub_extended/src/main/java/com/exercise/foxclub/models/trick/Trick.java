package com.exercise.foxclub.models.trick;

import com.exercise.foxclub.models.character.Fox;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Trick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "trick_list")
    private List<Fox> fox;

    public Trick() {
        fox = new ArrayList<>();
        name = "hunting";
    }
}