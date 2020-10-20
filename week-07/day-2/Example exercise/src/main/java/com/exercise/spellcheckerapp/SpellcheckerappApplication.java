package com.exercise.spellcheckerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpellcheckerappApplication implements CommandLineRunner {

    private SpellChecker checker;

    @Autowired
    SpellcheckerappApplication(SpellChecker checker) {
        this.checker = checker;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpellcheckerappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        checker.checkSpelling();
    }
}