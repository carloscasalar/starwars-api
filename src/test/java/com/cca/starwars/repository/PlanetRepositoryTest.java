package com.cca.starwars.repository;

import com.cca.starwars.model.Planet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.jvm.hotspot.utilities.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
// @AllArgsConstructor // thanks to @AllArgsConstructor planetRepository is injected (better than autowired)
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Test
    public void should_find_a_planet_by_name(){
        Planet alderaan = planetRepository.findByName("Alderaan");
        Assert.that(alderaan.getName().equals("Alderaan"), "Name should be Alderaan");
    }

    @Test
    public void should_have_two_rows_in_first_page_paginating_at_two_rows_per_page(){
        PageRequest pageRequest = new PageRequest(0,2);
        Page<Planet> planetsPage = planetRepository.findAll(pageRequest);
        Assert.that(planetsPage.getNumberOfElements()==2, "first page should have two elements");
    }
}
