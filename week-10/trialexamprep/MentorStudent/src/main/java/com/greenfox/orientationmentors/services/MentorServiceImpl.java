package com.greenfox.orientationmentors.services;

import com.greenfox.orientationmentors.exceptions.LinkNotFoundException;
import com.greenfox.orientationmentors.models.ClassName;
import com.greenfox.orientationmentors.models.DTOs.MentorDTO;
import com.greenfox.orientationmentors.models.DTOs.MentorUpdateDTO;
import com.greenfox.orientationmentors.models.Mentor;
import com.greenfox.orientationmentors.repositories.ClassNameRepository;
import com.greenfox.orientationmentors.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void deleteMentor(Long id) {
        Mentor mentor = mentorRepository.findById(id).orElseThrow(LinkNotFoundException::new);
        mentorRepository.deleteById(id);
    }

    @Override
    public void updateMentor(Long mentorId, MentorUpdateDTO mentorUpdateDTO) {
        Optional<Mentor> optionalMentor = mentorRepository.findById(mentorId);

        if (optionalMentor.isPresent()) {
            Mentor mentor = optionalMentor.get();
            mentor.setName(mentorUpdateDTO.getName());
            mentor.getClassName().setName(mentorUpdateDTO.getClassName());
            mentorRepository.save(mentor);
        }
    }

    @Override
    public Mentor getMentorByID(Long mentorId) {
        Optional<Mentor> optionalMentor = mentorRepository.findById(mentorId);
        if (optionalMentor.isPresent()) {
            Mentor mentor = optionalMentor.get();
            return mentor;
        } else {
            return null;
        }
    }

    @Override
    public List<MentorDTO> getAllMentorsNamesInClass(String className) {
        Long id = classNameRepository.findClassIdByClassName(className);

        var mentors = mentorRepository.findAll();

        List<MentorDTO> mentorDtoList = mentors.stream()
                .map(mentor -> new MentorDTO(mentor))
                .collect(Collectors.toList());

        List<MentorDTO> list = mentorDtoList.stream()
                .filter(mentorDto1 -> mentorDto1.getClasName().getId() == id)
                .collect(Collectors.toList());
        return list;
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
