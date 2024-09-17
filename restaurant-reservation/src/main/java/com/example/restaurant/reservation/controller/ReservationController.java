package com.example.restaurant.reservation.controller;

import com.example.restaurant.reservation.DTO.ReservationDTO;
import com.example.restaurant.reservation.DTO.RestaurantDTO;
import com.example.restaurant.reservation.services.ReservationService;
import com.example.restaurant.reservation.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    RestaurantService restaurantService;
    @Autowired
    ReservationService reservationService;

  @PostMapping
    public ResponseEntity<String>makeReservation(@RequestBody ReservationDTO reservationDTO){
      RestaurantDTO restaurant = restaurantService.findById(reservationDTO.getId());
      LocalTime schedule = reservationDTO.getSchedules();
      boolean success = reservationService.makeReservation(restaurant,reservationDTO, schedule);
      if(success){
          return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created successfully");
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reservation failed");
  }

}