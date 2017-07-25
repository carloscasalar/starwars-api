package com.cca.starwars.rest;

import com.cca.starwars.model.Film;
import com.cca.starwars.repository.FilmRepository;
import jdk.nashorn.internal.runtime.URIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@RepositoryRestController
@AllArgsConstructor
@Slf4j
public class FilmCustomRespositoryEndPoints {
    private FilmRepository filmRepository;

    @RequestMapping(method= RequestMethod.GET, value="films/search/findAllByReleaseDateGreaterThanEqual")
    public @ResponseBody
    ResponseEntity<List<Film>> findAllByReleaseDateGreaterThanEqual(@RequestParam("releaseDate") @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm:ss") Date releaseDate){
     List<Film> films = filmRepository.findAllByReleaseDateGreaterThanEqual(releaseDate);
     films.forEach(film -> {
         String queryString = null;
         try {
             queryString = URLEncoder.encode(film.getTitle(),"UTF-8");
             Link imdbLink = new Link("http://www.omdbapi.com/?t=" + queryString);
             film.add(imdbLink.withRel("imdb"));
         } catch (UnsupportedEncodingException e) {
             log.error("Unable to get imdb link for film "+film.getTitle(), e);
         }
     });

     return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
    }
}
