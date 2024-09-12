package com.example.restaurant.reservation.DTO;

import com.example.restaurant.reservation.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private LocalDate reservationDate;
    private LocalTime schedules;
    private Set<Integer> reservedTables = new HashSet<>();

    public ReservationDTO(Reservation reservation){
        this.reservationDate = reservation.getReservationDate();
        this.schedules = reservation.getSchedules();
        this.reservedTables = reservation.getReservedTables();
    }
}
