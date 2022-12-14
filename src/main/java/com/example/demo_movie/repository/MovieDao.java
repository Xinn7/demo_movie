package com.example.demo_movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_movie.entity.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, String> {

	public List<Movie> findMovieByMovieName(String movieName);

	public List<Movie> findMovieByType(String type);
}
