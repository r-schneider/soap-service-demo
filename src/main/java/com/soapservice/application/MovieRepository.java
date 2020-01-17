package com.soapservice.application;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Movie;

@Component
public class MovieRepository {

    private static final Map<String, Movie> movies = new HashMap<>();

  @PostConstruct
  public void initData() {
    
    Movie movie1 = new Movie();
    movie1.setTitle("Who knows");
    movie1.setYear("2016");
    movie1.setGenre("Romance");
    movie1.setSynopsis("Stranger falls in love");
    movies.put(movie1.getTitle().toLowerCase(), movie1);

    Movie movie2 = new Movie();
    movie2.setTitle("Damn Robots");
    movie2.setYear("2011");
    movie2.setGenre("Sci-fi");
    movie2.setSynopsis("Dystopia");
    movies.put(movie2.getTitle().toLowerCase(), movie2);

    Movie movie3 = new Movie();
    movie3.setTitle("I am Briar");
    movie3.setYear("2019");
    movie3.setGenre("Action");
    movie3.setSynopsis("Full of blasts");
    movies.put(movie3.getTitle().toLowerCase(), movie3);

    Movie movie4 = new Movie();
    movie4.setTitle("Cat pawns");
    movie4.setYear("2010");
    movie4.setGenre("Comedy");
    movie4.setSynopsis("Bad Dealers");
    movies.put(movie4.getTitle().toLowerCase(), movie4);

    Movie movie5 = new Movie();
    movie5.setTitle("Pixelated");
    movie5.setYear("2013");
    movie5.setGenre("Drama");
    movie5.setSynopsis("person is dying");
    movies.put(movie5.getTitle().toLowerCase(), movie5);
  }

  public Movie findMovie(String title) {
    Assert.notNull(title, "The movie's name must not be null");
    return movies.get(title);
  }
}