package com.greenfox.programmerfoxclub.services;

import com.greenfox.programmerfoxclub.models.Fox;
import com.greenfox.programmerfoxclub.models.Gender;
import com.greenfox.programmerfoxclub.repositories.FoxesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxServiceImpl implements FoxService {

    private FoxesRepository foxesRepository;

    @Autowired
    public FoxServiceImpl(FoxesRepository foxesRepository) {
        this.foxesRepository = foxesRepository;
    }

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

    public boolean isFoxPresent(String name) {
        return foxesRepository.getAllFoxes().stream()
                .anyMatch(fox -> fox.getName().equals(name));
    }

}