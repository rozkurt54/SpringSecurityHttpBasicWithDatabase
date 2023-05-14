package com.rozkurt.ss_2022_c2_e1.repositories;

import com.rozkurt.ss_2022_c2_e1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
