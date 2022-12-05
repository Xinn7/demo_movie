package com.example.demo_movie.service.ifs;

import com.example.demo_movie.vo.MovieReq;
import com.example.demo_movie.vo.MovieRes;

public interface MovieService {

	public MovieRes createMovieInfo(MovieReq movieReq);
	
	public MovieRes reviseMovieInfo(MovieReq movieReq);
	
	public MovieRes deleteMovieInfo(MovieReq movieReq);
	
	public MovieRes findMovieByMovieName(MovieReq movieReq);
	
	public MovieRes findMovieByType(MovieReq movieReq);
	
	public MovieRes createCustomerAndBuy(MovieReq movieReq);
	
	public MovieRes reviseCustomerAndBuy(MovieReq movieReq);
	
	public MovieRes deleteCustomerAndBuy(MovieReq movieReq);
	
	public MovieRes findAllMovieByName(MovieReq movieReq);
}
