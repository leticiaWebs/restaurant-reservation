package com.example.restaurant.reservation.services;

import com.example.restaurant.reservation.DTO.ReservationDTO;
import com.example.restaurant.reservation.DTO.RestaurantDTO;
import com.example.restaurant.reservation.entities.Reservation;
import com.example.restaurant.reservation.entities.Restaurant;
import com.example.restaurant.reservation.repositories.ReservationRepository;
import com.example.restaurant.reservation.repositories.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
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
    private RestaurantRepository restaurantRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Transactional
    public boolean makeReservation(RestaurantDTO restaurantId, ReservationDTO reservationDTO, LocalTime schedule) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));

        if (schedule.isBefore(reservationDTO.getOpeningTime()) || schedule.isAfter(reservationDTO.getClosingTime())) {
            return false;
        }
        int availableTables = reservationDTO.getCapacity() - reservationDTO.getReservedTables().size();
        if (availableTables <= 0) {
            return false;
        }
        if (reservationRepository.existsByReservationDateAndRestaurant(reservationDTO.getReservationDate(), restaurant)) {
            return false;
        }
        List<LocalDate> next20Days = getNext20Days();
        if (!next20Days.contains(reservationDTO.getReservationDate())) {
            return false;
        }

        Reservation reservation = new Reservation();
        reservation.setReservationDate(reservationDTO.getReservationDate());
        reservation.setSchedules(schedule);
        reservation.setClosingTime(reservationDTO.getClosingTime());
        reservation.setOpeningTime(reservationDTO.getOpeningTime());
        reservation.setCapacity(reservationDTO.getCapacity());
        reservation.setReservedTables(reservationDTO.getReservedTables());
        reservation.setRestaurant(restaurant);

        reservationRepository.save(reservation);

        return true;
    }

    private List<LocalDate> getNext20Days() {
        List<LocalDate> calendar = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 20; i++) {
            calendar.add(today.plusDays(i));
        }
        return calendar;
    }
}