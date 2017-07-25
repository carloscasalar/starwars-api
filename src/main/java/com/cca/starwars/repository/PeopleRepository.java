package com.cca.starwars.repository;

import com.cca.starwars.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path="persons")
public interface PeopleRepository extends JpaRepository<People,Long> {
    /*People findByNameIgnoreCase(String name);

    List<People> findByHeightGreaterThan(String heigth);

    List<People> findByEyeColorIn(Collection<String> eyeColors);*/

    List<People> findFirst20ByOrderByMassDesc();

    People findByPeopleId(Long id);

   /* List<People> findByEyeColorInOrOrderByNameAsc(Collection<String> eyesColor);

    @Query(value="select  p from People p where name like 'S%'", nativeQuery = true)
    List<People> findByNameStartingWith();*/
}