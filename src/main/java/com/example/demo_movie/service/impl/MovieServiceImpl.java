package com.example.demo_movie.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_movie.constants.MovieRtnCode;
import com.example.demo_movie.entity.Customers;
import com.example.demo_movie.entity.Movie;
import com.example.demo_movie.repository.CustomersDao;
import com.example.demo_movie.repository.MovieDao;
import com.example.demo_movie.service.ifs.MovieService;
import com.example.demo_movie.vo.MovieReq;
import com.example.demo_movie.vo.MovieRes;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	@Autowired
	private CustomersDao customersDao;

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

	@Override
	public MovieRes reviseMovieInfo(MovieReq movieReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieRes deleteMovieInfo(MovieReq movieReq) {
		Optional<Movie> movieOp = movieDao.findById(movieReq.getMovieCode());
		if (!movieOp.isPresent()) {
			return new MovieRes(MovieRtnCode.MOVIE_NOT_EXISTS.getMessage());
		}
		movieDao.deleteById(movieReq.getMovieCode());
		return new MovieRes(MovieRtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public MovieRes findMovieByMovieName(MovieReq movieReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieRes findMovieByType(MovieReq movieReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieRes createCustomerAndBuy(MovieReq movieReq) {
		Optional<Customers> customerOp = customersDao.findById(movieReq.getId());
		Customers customer = new Customers();
		if (!customerOp.isPresent()) {
			customer = new Customers(movieReq.getCustomerName(), movieReq.getMovieCode(),
					movieReq.getTicketQuantity());
		}

		customer.setMovieCode(movieReq.getMovieCode());
		
		customer.setTicketQuantity(movieReq.getTicketQuantity());
		
		Optional<Movie> movieOp = movieDao.findById(movieReq.getMovieCode());
		if (!movieOp.isPresent()) {
			return new MovieRes(MovieRtnCode.MOVIE_NOT_EXISTS.getMessage());
		}
		Movie movie = movieOp.get();
		
		if(movieReq.getTicketQuantity() > movie.getTicketBalance()) {
			return new MovieRes(MovieRtnCode.TICKET_QUANTITY_ERROR.getMessage());
		}
		
		movie.setTicketBalance(movie.getTicketBalance()-movieReq.getTicketQuantity());
		movieDao.save(movie);
		
		customer.setOrderDate(LocalDateTime.now());
		
		int moviePrice = movie.getPrice();
		customer.setTotalPrice(moviePrice * movieReq.getTicketQuantity());

		customersDao.save(customer);
		return new MovieRes(customer, MovieRtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public MovieRes reviseCustomerAndBuy(MovieReq movieReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieRes deleteCustomerAndBuy(MovieReq movieReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieRes findAllMovieByName(MovieReq movieReq) {
		List<Customers> customerOrderList = customersDao.findByCustomerName(movieReq.getCustomerName());
		
		if(customerOrderList.isEmpty()) {
			return new MovieRes(MovieRtnCode.ORDER_LIST_IS_EMPTY.getMessage());
		}
		
		return new MovieRes(customerOrderList, MovieRtnCode.SUCCESSFUL.getMessage());
	}

}
