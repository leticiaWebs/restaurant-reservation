package com.example.restaurant.reservation.repositories;

import com.example.restaurant.reservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
