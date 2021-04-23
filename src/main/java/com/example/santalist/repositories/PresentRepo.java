package com.example.santalist.repositories;

import com.example.santalist.models.Capital;
import com.example.santalist.models.Present;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresentRepo extends JpaRepository<Present, Long> {

    Present findByName(String name);
}
