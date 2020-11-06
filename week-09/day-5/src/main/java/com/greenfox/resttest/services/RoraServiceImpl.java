package com.greenfox.resttest.services;

import com.greenfox.resttest.models.Rora;
import org.springframework.stereotype.Service;

@Service
public class RoraServiceImpl implements RoraService{

    Rora rora = new Rora();

    @Override
    public void fillCargo(String caliber, Integer amount) {
        rora.fillCargo(caliber, amount);
    }

    @Override
    public String getShipStatus() {
        return rora.updateShipStatus();
    }

    @Override
    public Rora getRora() {
        return rora;
    }
}
