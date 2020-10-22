package com.robnikola.programmerfoxclub.repositories;

import com.robnikola.programmerfoxclub.models.Drink;
import com.robnikola.programmerfoxclub.models.Food;
import com.robnikola.programmerfoxclub.models.Fox;
import com.robnikola.programmerfoxclub.models.Trick;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FoxRepositoryImpl implements FoxRepository {

    private List<Fox> foxes;

    public FoxRepositoryImpl() {
        foxes = new ArrayList<>();
        foxes.add(new Fox("Rix", new ArrayList<>(Arrays.asList(Trick.JAVA, Trick.HTML)), Food.APPLE, Drink.CHAMPAGNE));
        foxes.add(new Fox("Rog", new ArrayList<>(Arrays.asList(Trick.CPP, Trick.CSS)),Food.BANANA,Drink.COLA));
        foxes.add(new Fox("Mix", new ArrayList<>(Arrays.asList(Trick.CSHARP, Trick.DOTNET)),Food.CHOCOLATE,Drink.FANTA));
        foxes.add(new Fox("Rob", new ArrayList<>(Arrays.asList(Trick.AWS, Trick.NODEJS)),Food.GRILLED_CHICKEN,Drink.VODKA));
        foxes.add(new Fox("Dodge", new ArrayList<>(Arrays.asList(Trick.PYTHON, Trick.JAVASCRIPT)),Food.LASAGNE,Drink.LEMONADE));
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
