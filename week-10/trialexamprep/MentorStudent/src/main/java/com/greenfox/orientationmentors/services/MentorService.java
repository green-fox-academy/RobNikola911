package com.greenfox.orientationmentors.services;

import com.greenfox.orientationmentors.models.DTOs.MentorDTO;
import com.greenfox.orientationmentors.models.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorService {

    List<Mentor> listMentors();
    boolean isNameAlreadyTaken(String name);

    Long saveNewMentorWithClassNameAndGetItsId(MentorDTO mentor);

    Optional<Mentor> findMentorById(Long id);
}
