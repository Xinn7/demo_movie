package com.example.demo_movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_movie.constants.MovieRtnCode;
import com.example.demo_movie.entity.Movie;
import com.example.demo_movie.service.ifs.MovieService;
import com.example.demo_movie.vo.MovieReq;
import com.example.demo_movie.vo.MovieRes;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping(value = "/api/createMovieInfo")
	public MovieRes createMovieInfo(@RequestBody MovieReq movieReq) {
		if (!StringUtils.hasText(movieReq.getMovieCode()) || !StringUtils.hasText(movieReq.getMovieName())
				|| !StringUtils.hasText(movieReq.getDay()) || !StringUtils.hasText(movieReq.getType())) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}

		return movieService.createMovieInfo(movieReq);
	}

	public MovieRes reviseMovieInfo(MovieReq movieReq) {
		return null;
		// TODO
	}

	@PostMapping(value = "/api/deleteMovieInfo")
	public MovieRes deleteMovieInfo(@RequestBody MovieReq movieReq) {
		if (!StringUtils.hasText(movieReq.getMovieCode())) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		return movieService.deleteMovieInfo(movieReq);
	}
	
	@PostMapping(value = "/api/findMovieByMovieName")
	public MovieRes findMovieByMovieName(@RequestBody MovieReq req) {
		//�P�_�d�ߤ��e�O�_����
		if(!StringUtils.hasText(req.getMovieName())) {
			return new MovieRes(MovieRtnCode.MOVIE_EMPTY.getMessage());
		}
		List<Movie> movieList = movieService.findMovieByMovieName(req.getMovieName());
		
		//�ӹq�v�Y���s�b�A�h�^�Ǥ��s�b���T��
		if(movieList == null) {
			return new MovieRes(MovieRtnCode.MOVIE_NOT_EXISTS.getMessage());
		}
		//��d�ߦ��\����ܸӳ��q�v���Ҧ����
		MovieRes movieRes = new MovieRes(MovieRtnCode.SUCCESSFUL.getMessage(),movieList);
		return movieRes;
	}
	
	@PostMapping(value = "/api/findMovieByType")
	public MovieRes findMovieByType(@RequestBody MovieReq req) {
		//�P�_�d�ߤ��e�O�_����
		if(!StringUtils.hasText(req.getType())) {
			return new MovieRes(MovieRtnCode.TYPE_EMPTY.getMessage());
		}
		List<Movie> movieList = movieService.findMovieByType(req.getType());
		//�p�G�q�v���s�b�A�h�^�Ǥ��s�b���T��
		if(movieList == null) {
			return new MovieRes(MovieRtnCode.TYPE_EXIST.getMessage());
		}
		
		MovieRes movieRes = new MovieRes(MovieRtnCode.SUCCESSFUL.getMessage(),movieList);
		return movieRes;
	}
	
	

	@PostMapping(value = "/api/createCustomerAndBuy")
	public MovieRes createCustomerAndBuy(@RequestBody MovieReq movieReq) {
		if (!StringUtils.hasText(movieReq.getCustomerName()) || !StringUtils.hasText(movieReq.getMovieCode())
				|| movieReq.getTicketQuantity() <= 0) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		return movieService.createCustomerAndBuy(movieReq);
	}
	
	@PostMapping(value = "/api/findAllMovieByName")
	public MovieRes findAllMovieByName(@RequestBody MovieReq movieReq) {
		if (!StringUtils.hasText(movieReq.getCustomerName())){
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		return movieService.findAllMovieByName(movieReq);
	}
}
