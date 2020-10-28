package com.exercise.foxclub.services;

import com.exercise.foxclub.models.Drink;
import com.exercise.foxclub.models.Food;
import com.exercise.foxclub.models.Trick;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActionHistoryServiceImpl implements ActionHistoryService {

    List<String> actionHistory;

    public ActionHistoryServiceImpl() {
        this.actionHistory = new ArrayList<>();
    }

    @Override
    public void foodChangeRecord(Food previous, Food current) {
        actionHistory.add(getDate() +" : Food has been changed from: " + previous.label + " to: " + current.label);
    }

    @Override
    public void drinkChangeRecord(Drink previous, Drink current) {
        actionHistory.add(getDate() +" : Drink has been changed from: " + previous.label + " to: " + current.label);
    }

    @Override
    public void learnedTrickRecord(Trick trick) {
        actionHistory.add(getDate() +" : Learned to: " + trick.label);
    }

    @Override
    public void loginPet(String name) {
        actionHistory.add(getDate() +" : Logged in for: " + name);
    }

    @Override
    public List<String> getHistory() {
        return actionHistory;
    }

    @Override
    public List<String> getRecentHistory() {
        return actionHistory.subList(Math.max(actionHistory.size()-5, 0), actionHistory.size());
    }

    @Override
    public String getDate() {
        LocalDateTime date = LocalDateTime.now();
        date.getYear();
        date.getMonth();
        date.getSecond();
        return "" + date.getYear() + ". " + date.getMonth().name().toLowerCase() + " " + date.getDayOfMonth() + ". " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond();
    }
}
