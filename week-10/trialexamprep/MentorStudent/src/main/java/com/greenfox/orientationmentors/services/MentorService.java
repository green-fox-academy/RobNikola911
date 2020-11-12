package com.greenfox.orientationmentors.services;

import com.greenfox.orientationmentors.models.DTOs.MentorDTO;
import com.greenfox.orientationmentors.models.DTOs.MentorUpdateDTO;
import com.greenfox.orientationmentors.models.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorService {

    List<Mentor> listMentors();
    boolean isNameAlreadyTaken(String name);

    Long saveNewMentorWithClassNameAndGetItsId(MentorDTO mentor);

    Optional<Mentor> findMentorById(Long id);

    void deleteMentor(Long id);

    void updateMentor(Long mentorId, MentorUpdateDTO mentorUpdateDTO);

    Mentor getMentorByID(Long mentorId);
}
