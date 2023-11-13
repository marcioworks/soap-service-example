package com.example.soapservice.services;

import com.example.soapservice.entities.Movie;

import java.util.List;

public interface MovieService {
    public Movie getEntityById(long id);
    public Movie getEntityByTitle(String title);
    public List<Movie> getAllEntities();
    public Movie addEntity(Movie entity);
    public boolean updateEntity(Movie entity);
    public boolean deleteEntityById(long id);
}
