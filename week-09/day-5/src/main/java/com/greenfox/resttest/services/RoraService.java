package com.greenfox.resttest.services;

import com.greenfox.resttest.models.Rora;
import org.springframework.stereotype.Service;


public interface RoraService {

    void fillCargo(String caliber, Integer amount);
    String getShipStatus ();
    public Rora getRora();

}
