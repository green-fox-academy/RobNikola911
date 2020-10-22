package com.robnikola.programmerfoxclub.repositories;

import com.robnikola.programmerfoxclub.models.Fox;

import java.util.List;

public interface FoxRepository {
    List<Fox> getFoxes();
    void addFox(String name);
}
