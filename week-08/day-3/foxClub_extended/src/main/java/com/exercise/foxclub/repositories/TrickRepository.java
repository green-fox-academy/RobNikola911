package com.exercise.foxclub.repositories;

import com.exercise.foxclub.models.trick.Trick;
import org.springframework.data.repository.CrudRepository;

public interface TrickRepository extends CrudRepository<Trick, Long> {
    Trick findTrickById(long id);
}
