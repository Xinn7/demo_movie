package com.example.demo_movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_movie.constants.MovieRtnCode;
import com.example.demo_movie.service.ifs.MovieService;
import com.example.demo_movie.vo.MovieReq;
import com.example.demo_movie.vo.MovieRes;

@CrossOrigin
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
		if (movieReq.getPrice() <= 0 ) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		return movieService.createMovieInfo(movieReq);
	}

	@PostMapping(value = "/api/reviseMovieInfo")
	public MovieRes reviseMovieInfo(@RequestBody MovieReq movieReq) {
		if (!StringUtils.hasText(movieReq.getMovieCode()) || !StringUtils.hasText(movieReq.getMovieName())
				|| !StringUtils.hasText(movieReq.getDay()) || !StringUtils.hasText(movieReq.getType())) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		if (movieReq.getPrice() <= 0 ) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		
		
		return movieService.reviseMovieInfo(movieReq);
	}

	@PostMapping(value = "/api/deleteMovieInfo")
	public MovieRes deleteMovieInfo(@RequestBody MovieReq movieReq) {
		if (!StringUtils.hasText(movieReq.getMovieCode())) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		return movieService.deleteMovieInfo(movieReq);
	}
	
//	@PostMapping(value = "/api/findMovieByMovieName")
//	public MovieRes findMovieByMovieName(@RequestBody MovieReq req) {
//		//?P?_?d?????e?O?_????
//		if(!StringUtils.hasText(req.getMovieName())) {
//			return new MovieRes(MovieRtnCode.MOVIE_EMPTY.getMessage());
//		}
//		List<Movie> movieList = movieService.findMovieByMovieName(req.getMovieName());
//		
//		//???q?v?Y???s?b?A?h?^?????s?b???T??
//		if(movieList == null) {
//			return new MovieRes(MovieRtnCode.MOVIE_NOT_EXISTS.getMessage());
//		}
//		//???d?????\???????????q?v??????????
//		MovieRes movieRes = new MovieRes(MovieRtnCode.SUCCESSFUL.getMessage(),movieList);
//		return movieRes;
//	}
//	
//	@PostMapping(value = "/api/findMovieByType")
//	public MovieRes findMovieByType(@RequestBody MovieReq req) {
//		//?P?_?d?????e?O?_????
//		if(!StringUtils.hasText(req.getType())) {
//			return new MovieRes(MovieRtnCode.TYPE_EMPTY.getMessage());
//		}
//		List<Movie> movieList = movieService.findMovieByType(req.getType());
//		//?p?G?q?v???s?b?A?h?^?????s?b???T??
//		if(movieList == null) {
//			return new MovieRes(MovieRtnCode.TYPE_EXIST.getMessage());
//		}
//		
//		MovieRes movieRes = new MovieRes(MovieRtnCode.SUCCESSFUL.getMessage(),movieList);
//		return movieRes;
//	}
	
	@PostMapping(value = "/api/findMovieByMovieNameOrType")
	public MovieRes findMovieByMovieNameOrType(@RequestBody MovieReq req) {

		if(req.getTypeOrMovieName().isEmpty()) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		
		MovieRes movieList = movieService.findMovieByMovieNameOrType(req.getTypeOrMovieName());
		if(movieList.getMovieCode() == null) {
			return new MovieRes(MovieRtnCode.TYPE_EXIST.getMessage());
		}
		
		MovieRes movieRes = new MovieRes(movieList, MovieRtnCode.SUCCESSFUL.getMessage());
		
		return movieRes;
	}

	@PostMapping(value = "/api/createCustomerAndBuy")
	public MovieRes createCustomerAndBuy(@RequestBody MovieReq movieReq) {
		return movieService.createCustomerAndBuy(movieReq);
	}

	@PostMapping(value = "/api/reviseCustomerAndBuy")
	public MovieRes reviseCustomerAndBuy(@RequestBody MovieReq req) {
		return movieService.reviseCustomerAndBuy(req);
	}

//	@Modifying 
//	@Transactional
	@PostMapping(value = "/api/deleteCustomerAndBuy")
	public MovieRes deleteCustomerAndBuy(@RequestBody MovieReq req) {
		return movieService.deleteCustomerAndBuy(req);
	}

	@PostMapping(value = "/api/findAllMovieByName")
	public MovieRes findAllMovieByName(@RequestBody MovieReq movieReq) {
		if (!StringUtils.hasText(movieReq.getCustomerName())) {
			return new MovieRes(MovieRtnCode.PARAMS_ERROR.getMessage());
		}
		return movieService.findAllMovieByName(movieReq);
	}
	
	@PostMapping(value = "/api/findByCustomerId")
	public MovieRes findByCustomerId(@RequestBody MovieReq movieReq) {
		return movieService.findByCustomerId(movieReq);
	}
	
	//?????D?S???n?o?e?????e?A?????Y?i???|?????C?????N?z?i???|?????s?????????s???w?s?????Y?C
	@ResponseStatus(value = HttpStatus.NO_CONTENT) //???wHttpStatus???^204???A?ANO_CONTENT???L???e??Response
	@PostMapping(value = "/api/reviseVerify")
	public void reviseVerify(@RequestBody MovieReq req) {
		movieService.reviseStatus(req);
	}
	
}
