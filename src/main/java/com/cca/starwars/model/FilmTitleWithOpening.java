package com.cca.starwars.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name="filmTitleWithOpening", types=Film.class)
public interface FilmTitleWithOpening {
    String getTitle();
    String getOpeningCrawl();

    List<PeopleWithNoPersonalInfo> getPeople();
}
