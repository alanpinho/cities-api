package com.github.alanpinho.citiesapi.countries.repository;

import com.github.alanpinho.citiesapi.countries.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
