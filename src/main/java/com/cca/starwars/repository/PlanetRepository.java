package com.cca.starwars.repository;

import com.cca.starwars.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Secured("ADMIN") // old, only let you specify roles
@PreAuthorize(value = "hasRole('ADMIN')") // lets you use expressions
// @PostAuthorize() // lets you use expressions
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Planet findByPlanetId(Long id);

    Planet findByName(String name);

    List<Planet> findByNameContaining(String name);

    Page<Planet> findAll(Pageable pageRequest);

/*
    List<Planet> findAllByOrOrderByNameDesc();


    List<Planet> findByPopulationGreaterThan(Long populationThreshold);

    List<Planet> findByPopulationBetween(Long min, Long max);

    List<Planet> findTop10ByOrderByPopulationAsc();

    List<Planet> findTop10ByOrderByPopulationDesc();
    */
}
