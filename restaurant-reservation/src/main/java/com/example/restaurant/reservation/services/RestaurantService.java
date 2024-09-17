package com.example.restaurant.reservation.services;

import com.example.restaurant.reservation.DTO.RestaurantDTO;
import com.example.restaurant.reservation.entities.Restaurant;
import com.example.restaurant.reservation.repositories.RestaurantRepository;
import com.example.restaurant.reservation.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository repository;

    @Transactional
    public List<RestaurantDTO> findAll() {
        List<Restaurant> list = repository.findAll();
        return list.stream().map(RestaurantDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public RestaurantDTO findById(Long id) {
        Optional<Restaurant> obj = repository.findById(id);
        Restaurant entity = obj.orElseThrow(() -> new ResourceNotFoundException(("Entity not found")));
        return new RestaurantDTO(entity);
    }

    @Transactional
    public RestaurantDTO insert(RestaurantDTO dto) {
        Restaurant entity = new Restaurant();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setFoodType(dto.getFoodType());
        repository.save(entity);
        return new RestaurantDTO(entity);
    }

    @Transactional
    public RestaurantDTO update(Long id, RestaurantDTO dto) {
        try{
            Restaurant entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity.setLocation(dto.getLocation());
            entity.setFoodType(dto.getFoodType());
            entity = repository.save(entity);
            return new RestaurantDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(("Restaurant not found" + dto.name));
        }
    }
}

