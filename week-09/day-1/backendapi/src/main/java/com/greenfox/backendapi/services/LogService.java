package com.greenfox.backendapi.services;

import com.greenfox.backendapi.models.Log;
import com.greenfox.backendapi.repositories.LogRepository;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void save (Log entity) {
        logRepository.save(entity);
    }
}
