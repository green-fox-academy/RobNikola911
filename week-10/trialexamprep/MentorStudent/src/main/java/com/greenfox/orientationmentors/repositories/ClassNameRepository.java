package com.greenfox.orientationmentors.repositories;

import com.greenfox.orientationmentors.models.ClassName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassNameRepository extends CrudRepository<ClassName, Long> {

    List<ClassName> findAll();

    Optional<ClassName> findByName(String className);

    Boolean existsClassByName(String className);

    @Query(value = "SELECT id FROM class_names where name=?",nativeQuery = true)
    Long findClassIdByClassName(String className);
}
