package com.exercise.foxclub.services;

import com.exercise.foxclub.models.Fox;
import com.exercise.foxclub.models.Gender;
import com.exercise.foxclub.repositories.FoxesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxServiceImpl implements FoxService{

    private FoxesRepository foxesRepository;

    public FoxServiceImpl(FoxesRepository foxesRepository) {
        this.foxesRepository = foxesRepository;
    }

    @Override
    public List<Fox> getFoxes() {
        return foxesRepository.getAllFoxes();
    }

    @Override
    public Fox getFoxByName(String name) {
        return foxesRepository.getFox(name);
    }

    @Override
    public void addFox(String name, Gender gender) {
        foxesRepository.addFox(name, gender);
    }

    @Override
    public boolean isFoxPresent(String name) {
        return foxesRepository.getAllFoxes().stream()
                .anyMatch(fox -> fox.getName().equals(name));
    }
}
