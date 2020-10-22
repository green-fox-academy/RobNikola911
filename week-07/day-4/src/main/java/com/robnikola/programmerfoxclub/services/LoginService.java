package com.robnikola.programmerfoxclub.services;

import com.robnikola.programmerfoxclub.models.Fox;

import java.util.List;

public interface LoginService {
    void addFox(String name);
    Fox getFox(String name);
}
