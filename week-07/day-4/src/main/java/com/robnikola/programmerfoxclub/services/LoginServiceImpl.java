package com.robnikola.programmerfoxclub.services;

import com.robnikola.programmerfoxclub.models.Fox;
import com.robnikola.programmerfoxclub.repositories.FoxRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{

    private final FoxRepository foxRepository;

    public LoginServiceImpl(FoxRepository foxRepository) {
        this.foxRepository = foxRepository;
    }

    @Override
    public void addFox(String name) {
        Optional<Fox> optionalName = foxRepository.getFoxes().stream()
                .filter(fox -> fox.getName().toLowerCase().equalsIgnoreCase(name))
                .findAny();
        if (optionalName.isEmpty()) {
            foxRepository.addFox(name);
        }
    }
}
