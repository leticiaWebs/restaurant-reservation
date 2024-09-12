package com.example.restaurant.reservation.repositories;

import com.example.restaurant.reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
