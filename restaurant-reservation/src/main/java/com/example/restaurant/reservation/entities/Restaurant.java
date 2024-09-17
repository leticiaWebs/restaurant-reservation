package com.example.restaurant.reservation.entities;

import com.example.restaurant.reservation.domain.Enums.FoodType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "tb_restaurant")
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JoinColumn(name = "tb_location")
    private Location location;
    @Enumerated(EnumType.STRING)
    private  FoodType foodType;

}
