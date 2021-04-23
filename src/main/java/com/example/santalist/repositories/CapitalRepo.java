package com.example.santalist.repositories;

import com.example.santalist.models.Capital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapitalRepo extends JpaRepository<Capital, Long> {
    Capital findByName(String name);
}
