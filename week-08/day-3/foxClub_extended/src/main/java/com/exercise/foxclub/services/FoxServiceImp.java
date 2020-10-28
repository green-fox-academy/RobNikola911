package com.exercise.foxclub.services;

import com.exercise.foxclub.models.character.Fox;
import com.exercise.foxclub.models.user.User;
import com.exercise.foxclub.repositories.IFoxRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Setter
@Getter
public class FoxServiceImp implements FoxService {
    private IFoxRepository foxRepository;

    public FoxServiceImp(IFoxRepository foxRepository) {
        this.foxRepository = foxRepository;
    }

    @Override
    public List<Fox> findAll() {
        List<Fox> foxList = new ArrayList<>();
        foxRepository.findAll().forEach(foxList::add);
        return foxList;
    }

    @Override
    public Fox getActiveFox(int activeFoxIndex) {
        List<Fox> foxList = findAll();
        return foxList.get(activeFoxIndex);
    }

    @Override
    public Fox findById(long id) {
        return foxRepository.findById(id).get();
    }

    @Override
    public void save(Fox fox) {
        foxRepository.save(fox);
    }

    @Override
    public void update(Fox fox) {
        foxRepository.save(fox);
    }

    @Override
    public Fox findFoxByName(String name) {
        return foxRepository.findByName(name);
    }

    @Override
    public boolean checkFoxExists(String name) {
        if (foxRepository.countAllByName(name) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Fox findFoxByOwner(User owner) {
        return foxRepository.findByOwner(owner);
    }
}