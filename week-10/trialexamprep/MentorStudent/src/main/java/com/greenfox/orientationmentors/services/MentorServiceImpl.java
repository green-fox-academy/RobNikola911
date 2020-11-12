package com.greenfox.orientationmentors.services;

import com.greenfox.orientationmentors.models.ClassName;
import com.greenfox.orientationmentors.models.DTOs.MentorDTO;
import com.greenfox.orientationmentors.models.Mentor;
import com.greenfox.orientationmentors.repositories.ClassNameRepository;
import com.greenfox.orientationmentors.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;
    private final ClassNameRepository classNameRepository;

    @Autowired
    public MentorServiceImpl(MentorRepository mentorRepository, ClassNameRepository classNameRepository) {
        this.mentorRepository = mentorRepository;
        this.classNameRepository = classNameRepository;
    }

    @Override
    public List<Mentor> listMentors() {
        return mentorRepository.findAll();
    }

    @Override
    public boolean isNameAlreadyTaken(String name) {
        return mentorRepository.findByName(name).isPresent();
    }

    @Override
    public Optional<Mentor> findMentorById(Long id) {
        return mentorRepository.findById(id);
    }

    @Override
    public Long saveNewMentorWithClassNameAndGetItsId(MentorDTO mentor) {
        Mentor newMentor = new Mentor(mentor.getName());
        Optional<ClassName> optionalClassName = classNameRepository.findByName(mentor.getClassName());
        if (optionalClassName.isPresent()){
            ClassName inputClassName = optionalClassName.get();
            newMentor.setClassName(inputClassName);
            mentorRepository.save(newMentor);
        }
        return newMentor.getId();
    }

}
