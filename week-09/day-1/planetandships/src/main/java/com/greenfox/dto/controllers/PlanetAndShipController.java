package com.greenfox.dto.controllers;

import com.greenfox.dto.models.Planet;
import com.greenfox.dto.models.PlanetAndShipDTO;
import com.greenfox.dto.models.Spaceship;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetAndShipController {

    @GetMapping("/api/planetandship")
    public ResponseEntity<PlanetAndShipDTO> getPlanetNameAndShipCapacity() {
        Planet planets = service.getPlanet();
        Spaceship spaceship = service.getShip();

        if(spaceship == null) {
            return new ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

        PlanetAndShipDTO planetAndShipDTO = new PlanetAndShipDTO(planet.getName(), ship.getCapacity());
        return new ResponseEntity.status(HttpStatus.OK).body(planetAndShipDTO);
    }
}
