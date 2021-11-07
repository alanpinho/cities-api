package com.github.alanpinho.citiesapi.states.repository;

import com.github.alanpinho.citiesapi.states.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
