package com.exercise.foxclub.services;

import com.exercise.foxclub.models.trick.Trick;

import java.util.List;

public interface TrickService {
    List<Trick> findAll();
}