package com.exercise.foxclub.services;

import com.exercise.foxclub.models.character.Fox;
import com.exercise.foxclub.models.user.User;

import java.util.List;

public interface FoxService {

    List<Fox> findAll();

    Fox getActiveFox(int activeFoxIndex);

    Fox findById(long id);

    void save(Fox fox);

    void update(Fox fox);

    Fox findFoxByName(String name);

    boolean checkFoxExists(String name);

    Fox findFoxByOwner(User owner);
}