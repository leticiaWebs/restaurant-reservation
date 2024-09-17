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
    private Long id;
    private LocalDate reservationDate;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private int capacity;
    private LocalTime schedules;
    private Set<Integer> reservedTables = new HashSet<>();

    public ReservationDTO(Reservation entity){
        this.id = entity.getId();
        this.reservationDate = entity.getReservationDate();
        this.openingTime = entity.getOpeningTime();
        this.closingTime = entity.getClosingTime();
        this.capacity = entity.getCapacity();
        this.schedules = entity.getSchedules();
        this.reservedTables = entity.getReservedTables();
    }
}
