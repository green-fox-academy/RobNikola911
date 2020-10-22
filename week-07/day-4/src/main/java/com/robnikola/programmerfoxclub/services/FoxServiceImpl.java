package com.robnikola.programmerfoxclub.services;

import com.robnikola.programmerfoxclub.models.Drink;
import com.robnikola.programmerfoxclub.models.Food;
import com.robnikola.programmerfoxclub.models.Fox;
import com.robnikola.programmerfoxclub.repositories.FoxRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoxServiceImpl implements FoxService{

    private final FoxRepository foxRepository;

    public FoxServiceImpl(FoxRepository foxRepository) {
        this.foxRepository = foxRepository;
    }

    @Override
    public Fox getFoxByName(String name) {
        Optional<Fox> optionalFox = foxRepository.getFoxes().stream()
                .filter(fox -> fox.getName().equals(name))
                .findAny();

        return optionalFox.orElse(null);
    }

    @Override
    public List<Fox> getAllFoxes() {
        return foxRepository.getFoxes();
    }

    @Override
    public boolean checkFox(String name) {
        Optional<Fox> stringOptional = foxRepository.getFoxes().stream()
                .filter(fox -> fox.getName().equalsIgnoreCase(name))
                .findAny();
        return stringOptional.isPresent();
    }

    @Override
    public void setFood(String name, Food food) {
        getFoxByName(name).setFood(food);
    }

    @Override
    public void setDrink(String name, Drink drink) {
        getFoxByName(name).setDrink(drink);
    }
}