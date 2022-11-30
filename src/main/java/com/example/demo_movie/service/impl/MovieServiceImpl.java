package com.example.demo_movie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_movie.constants.MovieRtnCode;
import com.example.demo_movie.entity.Movie;
import com.example.demo_movie.repository.MovieDao;
import com.example.demo_movie.service.ifs.MovieService;
import com.example.demo_movie.vo.MovieReq;
import com.example.demo_movie.vo.MovieRes;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	@Override
	public MovieRes createMovieInfo(MovieReq movieReq) {
		Optional<Movie> movieOp = movieDao.findById(movieReq.getMovieCode());
		if (movieOp.isPresent()) {
			return new MovieRes(MovieRtnCode.MOVIE_CODE_IS_EXISTS.getMessage());
		}

		Movie movie = new Movie(movieReq.getMovieCode(), movieReq.getMovieName(), movieReq.getDay(), 
				movieReq.getStartTime(), movieReq.getPrice(), movieReq.getType(), movieReq.getTotalTicket(), 
				movieReq.getTicketBalance());
		movieDao.save(movie);

		return new MovieRes(movie, MovieRtnCode.SUCCESSFUL.getMessage());
	}

}
