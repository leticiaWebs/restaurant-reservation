package com.example.restaurant.reservation.controller;

import com.example.restaurant.reservation.DTO.ReservationDTO;
import com.example.restaurant.reservation.DTO.RestaurantDTO;
import com.example.restaurant.reservation.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>>  findALL(){
        List<RestaurantDTO> dto = service.findAll();
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestaurantDTO> findById(@PathVariable Long id){
        RestaurantDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity<RestaurantDTO> insert (@RequestBody RestaurantDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
