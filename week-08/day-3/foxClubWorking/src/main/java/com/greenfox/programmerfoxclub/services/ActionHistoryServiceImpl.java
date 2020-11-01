package com.greenfox.programmerfoxclub.services;

import com.greenfox.programmerfoxclub.models.Drink;
import com.greenfox.programmerfoxclub.models.Food;
import com.greenfox.programmerfoxclub.models.Trick;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        String date = df.format(today);
        return date;
    }
}