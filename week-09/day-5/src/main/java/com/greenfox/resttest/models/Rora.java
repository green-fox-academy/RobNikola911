package com.greenfox.resttest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rora {

    private  Integer caliber25;
    private  Integer caliber30;
    private  Integer caliber50;
    private Shipstatus shipstatus;
    private Boolean ready;
    private String received;


    public Rora() {
        this.caliber25 = 0;
        this.caliber30 = 0;
        this.caliber50 = 0;
        this.shipstatus = Shipstatus.EMPTY;
        this.ready = false;
    }



    public Integer getCaliber25() {
        return caliber25;
    }

    public void setCaliber25(Integer caliber25) {
        this.caliber25 = caliber25;
    }

    public Integer getCaliber30() {
        return caliber30;
    }

    public void setCaliber30(Integer caliber30) {
        this.caliber30 = caliber30;
    }

    public Integer getCaliber50() {
        return caliber50;
    }

    public void setCaliber50(Integer caliber50) {
        this.caliber50 = caliber50;
    }

    public Shipstatus getShipstatus() {
        return shipstatus;
    }

    public void setShipstatus(Shipstatus shipstatus) {
        this.shipstatus = shipstatus;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }
}

