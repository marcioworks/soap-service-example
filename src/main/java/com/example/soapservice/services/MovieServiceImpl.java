package com.example.soapservice.services;

import com.example.soapservice.entities.Movie;
import com.example.soapservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

    private MovieRepository repository;

    public MovieServiceImpl(){}

    @Autowired
    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }
    @Override
    public Movie getEntityById(long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Movie getEntityByTitle(String title) {
        return this.repository.findByTitle(title);
    }

    @Override
    public List<Movie> getAllEntities() {
        List < Movie > list = new ArrayList< >();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Movie addEntity(Movie entity) {
        try {
            return this.repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateEntity(Movie entity) {
        try {
            this.repository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEntityById(long id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
