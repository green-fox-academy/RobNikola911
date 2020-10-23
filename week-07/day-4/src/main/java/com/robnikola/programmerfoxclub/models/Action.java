package com.robnikola.programmerfoxclub.models;

import java.util.Date;

public class Action {
    Date date;
    Fox fox;
    String description;

    public Action(Date date, Fox fox, String description) {
        this.date = date;
        this.fox = fox;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Fox getFox() {
        return fox;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
