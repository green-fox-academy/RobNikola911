package com.thymeleaf.exercise.models;


public class BankAccount {
    protected String name;
    protected double balance;
    protected String animalType;
    protected boolean isKing;
    GoodBad goodBad;


    public BankAccount(String name, double balance, String animalType) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.goodBad = GoodBad.GOOD_GUY;
    }

//    public BankAccount() {
//    }

    public GoodBad getGoodBad() {
        if (this.name.equalsIgnoreCase("Scar")) {
            return GoodBad.BAD_GUY;
        }
        return GoodBad.GOOD_GUY;
    }

    public void setGoodBad(GoodBad goodBad) {
        this.goodBad = goodBad;
    }

    public boolean isKing() {
        return name.equals("Mufasa") || name.equals("Scar");
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
