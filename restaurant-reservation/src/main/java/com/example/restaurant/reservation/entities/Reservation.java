package com.example.restaurant.reservation.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Embeddable
public class Reservation {

    private LocalDate reservationDate;
    private LocalTime schedules;
    @ElementCollection
    private Set<Integer> reservedTables = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "tb_restaurant")
    private Restaurant restaurant;
}