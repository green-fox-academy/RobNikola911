package com.exercise.foxclub.services;

import com.exercise.foxclub.models.trick.Trick;
import com.exercise.foxclub.repositories.TrickRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrickServiceImp implements TrickService {
    private TrickRepository trickRepository;

    public TrickServiceImp(TrickRepository trickRepository) {
        this.trickRepository = trickRepository;
    }

    @Override
    public List<Trick> findAll() {
        List<Trick> trickList = new ArrayList<>();
        trickRepository.findAll().forEach(trickList::add);
        return trickList;
    }
}