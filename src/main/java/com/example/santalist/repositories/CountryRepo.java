package com.example.santalist.repositories;

import com.example.santalist.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
    Country findByName(String countryName);
}
