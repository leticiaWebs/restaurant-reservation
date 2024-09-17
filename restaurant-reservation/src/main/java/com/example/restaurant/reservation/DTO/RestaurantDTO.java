package com.example.restaurant.reservation.DTO;

import com.example.restaurant.reservation.domain.Enums.FoodType;
import com.example.restaurant.reservation.entities.Location;
import com.example.restaurant.reservation.entities.Restaurant;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RestaurantDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Location location;
    public FoodType foodType;


    public RestaurantDTO(Restaurant entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.location = entity.getLocation();
        this.foodType = entity.getFoodType();
    }

}
