package com.greenfox.orientationmentors.services;

import com.greenfox.orientationmentors.models.ClassName;
import com.greenfox.orientationmentors.models.DTOs.NameDTO;
import com.greenfox.orientationmentors.models.Mentor;
import com.greenfox.orientationmentors.repositories.ClassNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassNameServiceImpl implements ClassNameService {

    private final ClassNameRepository classNameRepository;

    @Autowired
    public ClassNameServiceImpl(ClassNameRepository classNameRepository) {
        this.classNameRepository = classNameRepository;
    }

    @Override
    public List<ClassName> listClassNames() {
        return classNameRepository.findAll();
    }

    @Override
    public Optional<ClassName> findClassByName(String className) {
        return classNameRepository.findByName(className);
    }

    @Override
    public List<NameDTO> listMentorsNames(List<Mentor> mentors) {
        List<NameDTO> names = new ArrayList<>();
        for (Mentor mentor : mentors) {
            names.add(new NameDTO(mentor.getName()));
        }
        return names;
    }

    @Override
    public Boolean isClassExist(String className) {
        return classNameRepository.existsClassByName(className);
    }
}
