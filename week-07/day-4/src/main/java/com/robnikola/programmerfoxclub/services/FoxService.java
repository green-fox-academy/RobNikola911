package com.robnikola.programmerfoxclub.services;

import com.robnikola.programmerfoxclub.models.Fox;

import java.util.List;

public interface FoxService {
    Fox getFoxByName(String name);
    List<Fox> getAllFoxes();
}
