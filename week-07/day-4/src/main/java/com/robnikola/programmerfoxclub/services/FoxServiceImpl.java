package com.robnikola.programmerfoxclub.services;

import com.robnikola.programmerfoxclub.models.Drink;
import com.robnikola.programmerfoxclub.models.Food;
import com.robnikola.programmerfoxclub.models.Fox;
import com.robnikola.programmerfoxclub.models.Trick;
import com.robnikola.programmerfoxclub.repositories.FoxRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public void setTrick(String name, Trick trick) {
//      getFoxByName(name).removeTrick(trick);
        getFoxByName(name).addTrick(trick);
    }

    @Override
    public List<Trick> getPossibleTricksToLearn(String name) {
        List<Trick> foxTricks =  getFoxByName(name).getTricks();
        List<Trick> filteredTricks = Arrays.stream(Trick.values())
                .filter(t -> !(foxTricks.contains(t)))
                .collect(Collectors.toList());
        return filteredTricks;
    }

    @Override
    public boolean learnedAll(String name) {
        if (getPossibleTricksToLearn(name).isEmpty()){
            return true;
        } return false;
    }
}