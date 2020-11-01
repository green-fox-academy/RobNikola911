package com.greenfox.dto.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanetAndShipDTO {

    private String planetName;
    private int shipCapacity;

    public PlanetAndShipDTO() {}

    public PlanetAndShipDTO(String planetName, int shipCapacity) {
        this.planetName = planetName;
        this.shipCapacity = shipCapacity;
    }

}