package com.example.restaurant.reservation.repositories;

import com.example.restaurant.reservation.DTO.RestaurantDTO;
import com.example.restaurant.reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByReservationDateAndRestaurant(LocalDate reservationDate, RestaurantDTO restaurant);
}
