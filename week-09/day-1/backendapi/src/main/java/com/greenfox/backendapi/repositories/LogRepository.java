package com.greenfox.backendapi.repositories;

import com.greenfox.backendapi.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    @Override
    List<Log> findAll();
}
