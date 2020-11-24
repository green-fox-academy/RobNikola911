package com.spring.security.repositories;

import com.spring.security.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Boolean existsById(Integer id);

}
