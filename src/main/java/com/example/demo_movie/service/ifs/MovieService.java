package com.example.demo_movie.service.ifs;

import java.util.List;

import com.example.demo_movie.entity.Movie;
import com.example.demo_movie.vo.MovieReq;
import com.example.demo_movie.vo.MovieRes;

public interface MovieService {

	public MovieRes createMovieInfo(MovieReq movieReq);
	
	public MovieRes reviseMovieInfo(MovieReq movieReq);
	
	public MovieRes deleteMovieInfo(MovieReq movieReq);
	
	public List<Movie> findMovieByMovieName(String movieName);
	
	public List<Movie> findMovieByType(String type);
	
	public MovieRes createCustomerAndBuy(MovieReq movieReq);
	
	public MovieRes reviseCustomerAndBuy(MovieReq movieReq);
	
	public MovieRes deleteCustomerAndBuy(MovieReq movieReq);
	
	public MovieRes findAllMovieByName(MovieReq movieReq);

}
