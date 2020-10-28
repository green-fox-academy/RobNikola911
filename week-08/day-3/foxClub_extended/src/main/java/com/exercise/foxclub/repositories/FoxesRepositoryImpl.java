package com.exercise.foxclub.repositories;

import com.exercise.foxclub.models.Fox;
import com.exercise.foxclub.models.Gender;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoxesRepositoryImpl implements FoxesRepository {

    List<Fox> foxes;

    public FoxesRepositoryImpl() {
        this.foxes = new ArrayList<>();
    }

    @Override
    public List<Fox> getAllFoxes() {
        return foxes;
    }

    @Override
    public Fox getFox(String name) {
        Optional<Fox> fox = foxes.stream()
                .filter(obj -> obj.getName().equals(name))
                .findAny();
        return fox.orElse(null);
    }

    @Override
    public void addFox(String name, Gender gender) {
        if(!foxes.stream().anyMatch(fox -> fox.getName().equals(name))) {
            foxes.add(new Fox(name, gender));
        }
    }
}