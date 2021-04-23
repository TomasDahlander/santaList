package com.example.santalist.repositories;

import com.example.santalist.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepo extends JpaRepository<Child, Long> {
    Child findByName(String childP);
}
