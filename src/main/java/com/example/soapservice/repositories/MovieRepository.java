package com.example.soapservice.repositories;

import com.example.soapservice.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {
    public Movie findByTitle(String title);
}
