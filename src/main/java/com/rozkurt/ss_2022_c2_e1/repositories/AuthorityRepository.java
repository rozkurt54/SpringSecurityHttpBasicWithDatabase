package com.rozkurt.ss_2022_c2_e1.repositories;

import com.rozkurt.ss_2022_c2_e1.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Boolean existsByNameIgnoreCase(String name);

    Optional<Authority> findByNameIgnoreCase(String name);

}
