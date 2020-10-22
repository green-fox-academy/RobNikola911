package com.robnikola.programmerfoxclub.repositories;

import com.robnikola.programmerfoxclub.models.Fox;
import com.robnikola.programmerfoxclub.models.Tricks;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FoxRepositoryImpl implements FoxRepository {

    private final List<Fox> foxes;

    public FoxRepositoryImpl() {
        foxes = new ArrayList<>();
        foxes.add(new Fox("Rix", new ArrayList<>(Arrays.asList(Tricks.JAVA, Tricks.HTML)),"Pizza","Lemonde"));
        foxes.add(new Fox("Rog", new ArrayList<>(Arrays.asList(Tricks.CPP, Tricks.CSS)),"Beef","Orange"));
        foxes.add(new Fox("Mix", new ArrayList<>(Arrays.asList(Tricks.CSHARP, Tricks.DOTNET)),"Chicken","Beer"));
        foxes.add(new Fox("Rob", new ArrayList<>(Arrays.asList(Tricks.AWS, Tricks.NODEJS)),"Salade","Wine"));
        foxes.add(new Fox("Dodge", new ArrayList<>(Arrays.asList(Tricks.PYTHON, Tricks.JAVASCRIPT)),"Spinach","Vodka"));
    }

    @Override
    public List<Fox> getFoxes() {
        return foxes;
    }

    @Override
    public void addFox(String name) {
        foxes.add(new Fox(name));
    }
}
