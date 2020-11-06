package com.greenfox.resttest.services;

import com.greenfox.resttest.models.Rora;
import org.springframework.stereotype.Service;

@Service
public class RoraServiceImpl implements RoraService{
    Rora rora = new Rora();

    @Override
    public void fillCargo(String caliber, Integer amount) {
        if (caliber.equals(".50")){
            rora.setCaliber50(amount);
        } else if (caliber.equals(".25")){
            rora.setCaliber25(amount);
        } else if (caliber.equals(".30")){
            rora.setCaliber30(amount);
        }

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
