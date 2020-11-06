package com.greenfox.resttest.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.greenfox.resttest.models.Rora;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoraDTO {

    @JsonProperty("shipstatus")
    private String shipStatus;
    private Boolean ready;
    private String received;
    private Integer amount;
    private String error;

/*    public CargoDto(Cargo cargo) {
        this.caliber25 = cargo.getCaliber25();
        this.caliber30 = cargo.getCaliber30();
        this.caliber50 = cargo.getCaliber50();
        this.shipStatus = cargo.getShipStatus();
        this.ready = cargo.isReady();
    }*/

    public RoraDTO(Rora rora, String caliber, Integer amount) {
        this.received = caliber;
        this.amount = amount;
        this.shipStatus = rora.updateShipStatus();
        this.ready = rora.isReady();
    }

    public RoraDTO() {
        this.error = "pls fill params";
        this.received = null;
        this.amount = null;
        this.shipStatus = null;
        this.ready = null;
    }
}