package com.greenfox.resttest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rora {

    private Integer caliber25;
    private Integer caliber30;
    private Integer caliber50;
    @JsonProperty("shipstatus")
    private String shipStatus;
    private Boolean ready;
    private String received;


    public Rora() {
        this.caliber25 = 0;
        this.caliber30 = 0;
        this.caliber50 = 0;
        this.shipStatus = Shipstatus.EMPTY.label;
        this.ready = false;
    }

    public String updateShipStatus() {
        int totalAmount = caliber25 + caliber30 + caliber50;
        int shipMaxHold = 12500;
        double shipStatusValue = (totalAmount / (double) shipMaxHold) * 100;

        if (totalAmount == 0) {
            return "empty";
        } else if (totalAmount == shipMaxHold) {
            this.ready = true;
            return "full";
        } else if (totalAmount > shipMaxHold) {
            return "overloaded";
        } else {
            return shipStatusValue + "%";
        }
    }

    public void fillCargo(String caliber, Integer amount) {
        if (caliber.equals("0.25")) {
            this.caliber25 += amount;
        } else if (caliber.equals("0.30")) {
            this.caliber30 += amount;
        }else if (caliber.equals("0.50")) {
            this.caliber50 += amount;
        }
    }
}