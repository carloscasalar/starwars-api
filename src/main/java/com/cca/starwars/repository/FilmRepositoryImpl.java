package com.cca.starwars.repository;


import com.cca.starwars.model.Film;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@ConfigurationProperties(prefix="my.sample")
public class FilmRepositoryImpl implements CustomFilmRepository{

    @Getter @Setter
    private String property;

    @Override
    public void logFilm(Film film) {
        log.info("Film log Film: " + film.getTitle(), film);
        log.warn("Custom propety: " + property);
    }
}
