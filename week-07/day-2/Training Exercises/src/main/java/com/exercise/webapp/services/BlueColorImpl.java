package com.exercise.webapp.services;

import org.springframework.stereotype.Service;

@Service
public class BlueColorImpl implements MyColor {

    @Override
    public void printColor() {
        System.out.println("It is blue in color...");
    }
}
