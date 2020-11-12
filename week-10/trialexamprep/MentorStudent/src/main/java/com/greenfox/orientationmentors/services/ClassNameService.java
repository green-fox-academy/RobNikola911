package com.greenfox.orientationmentors.services;

import com.greenfox.orientationmentors.models.ClassName;
import com.greenfox.orientationmentors.models.DTOs.NameDTO;
import com.greenfox.orientationmentors.models.Mentor;

import java.util.List;
import java.util.Optional;


public interface ClassNameService {

    List<ClassName> listClassNames();

    Optional<ClassName> findClassByName(String className);

    List<NameDTO> listMentorsNames(List<Mentor> mentors);

    Boolean isClassExist(String className);
}
