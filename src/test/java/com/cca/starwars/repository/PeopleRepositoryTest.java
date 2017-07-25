package com.cca.starwars.repository;

import com.cca.starwars.model.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;


    @Test
    public void should_find_top_20_heigth_people(){
        List<People> peopleList = peopleRepository.findFirst20ByOrderByMassDesc();
        assertNotNull(peopleList);

    }

    @Test
    public void shoul_be_able_to_find_all(){
        List<People> peopleList = peopleRepository.findAll();
        assertNotNull(peopleList);
    }
}
