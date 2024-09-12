package com.example.restaurant.reservation.services;

import com.example.restaurant.reservation.DTO.ReservationDTO;
import com.example.restaurant.reservation.DTO.RestaurantDTO;
import com.example.restaurant.reservation.entities.Reservation;
import com.example.restaurant.reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    private List<ReservationDTO> reservations = new ArrayList<>();

           @Transactional
           public boolean makeReservation (RestaurantDTO restaurant, ReservationDTO reservation, LocalTime schedule){
               if (schedule.isBefore(restaurant.getOpeningTime()) || schedule.isAfter(restaurant.getClosingTime()))
                   return false;


               int availableTables = restaurant.getCapacity() - reservation.getReservedTables().size();
               if (availableTables <= 0) {
                   return false;
               }
               if (reservations.contains(reservation)) {
                   return false;
               }
               List<LocalDate> next20Days = getNext20Days();
               if (!next20Days.contains(reservation.getReservationDate())) {
                   return false;
               }

               reservations.add(reservation);
               return true;
           }
           private List<LocalDate> getNext20Days () {
               List<LocalDate> calendar = new ArrayList<>();
               LocalDate today = LocalDate.now();
               for (int i = 0; i < 20; i++) {
                   calendar.add(today.plusDays(i));
               }
               return calendar;
           }

       }
