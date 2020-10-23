package com.robnikola.programmerfoxclub.services;

import com.robnikola.programmerfoxclub.models.*;
import com.robnikola.programmerfoxclub.repositories.FoxRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoxServiceImpl implements FoxService{

    List<Action> actionList = new ArrayList<>();

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
        Fox currentFox = getFoxByName(name);
        Food before = currentFox.getFood();
        currentFox.setFood(food);
        Food after = currentFox.getFood();
        Action action = new Action(new Date(),currentFox,
                "Food has been changed from: "+before+ " to "+after);

        actionList.add(action);

    }

    @Override
    public void setDrink(String name, Drink drink) {
        Fox currentFox = getFoxByName(name);
        Drink before = currentFox.getDrink();
        currentFox.setDrink(drink);
        Drink after = currentFox.getDrink();
        Action action = new Action(new Date(),currentFox,
                "Drink has been changed from: "+before+ " to "+after);

        actionList.add(action);
    }

    @Override
    public void setTrick(String name, Trick trick) {
        Fox currentFox = getFoxByName(name);
        currentFox.addTrick(trick);
        Action action = new Action(new Date(),currentFox,
                "Learned: "+ trick);

        actionList.add(action);
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

    public List<Action> getActionList (Fox name) {
        actionList.stream()
                .filter(action -> (action.getFox().getName().equals(name.getName())))
                .collect(Collectors.toList());
        return actionList;
    }
}
