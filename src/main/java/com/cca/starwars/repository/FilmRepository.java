package com.cca.starwars.repository;

import com.cca.starwars.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long>, CustomFilmRepository{
    List<Film> findAllByOrderByEpisodeIdAsc();
    List<Film> findAllByReleaseDateGreaterThan(Date releaseDate);

    /*@Query("select f from Film f where f.people.size = (select max(f2.people.size) from Film f2)")
    List<Film> findAllByMaxPeople();*/

    /*@Query("select f from Film f where f.planet.size = (select max(f2.planet.size) from Film f2)")
    List<Film> findAllByMinPlanets();*/

    @Query("select f from Film f join f.people p where p.name = :name")
    List<Film> findAllByPeopleContaining(@Param("name") String name);

    List<Film> findAllByReleaseDateGreaterThanEqual(@Param("releaseDate") Date releaseDate);

    @Override
    @RestResource(exported=false)
    void delete(Film film);

    @Override
    @RestResource(exported=false)
    Film save(Film film);
}
