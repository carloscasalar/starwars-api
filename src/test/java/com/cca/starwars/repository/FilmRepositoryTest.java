package com.cca.starwars.repository;


import com.cca.starwars.model.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmRepositoryTest {
    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void should_find_by_order_by_EpisodeId(){
        List<Film> films = filmRepository.findAllByOrderByEpisodeIdAsc();
        filmRepository.logFilm(films.get(0));
        assertNotNull(films);
    }
}
