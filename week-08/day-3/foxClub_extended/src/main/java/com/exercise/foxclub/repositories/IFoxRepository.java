package com.exercise.foxclub.repositories;

import com.exercise.foxclub.models.character.Fox;
import com.exercise.foxclub.models.user.User;
import org.springframework.data.repository.CrudRepository;


public interface IFoxRepository extends CrudRepository<Fox, Long> {
    Fox findByName(String name);

    int countAllByName(String name);

    Fox findByOwner(User owner);
}
