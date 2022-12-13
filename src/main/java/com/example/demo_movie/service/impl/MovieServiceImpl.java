package com.example.demo_movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

		Optional<Movie> movieOp = movieDao.findById(movieReq.getMovieCode());

		if (!movieOp.isPresent()) {
			return new MovieRes(MovieRtnCode.MOVIE_NOT_EXISTS.getMessage());
		}

		Movie movie = new Movie(movieReq.getMovieCode(), movieReq.getMovieName(), movieReq.getDay(),
				movieReq.getStartTime(), movieReq.getPrice(), movieReq.getType(), movieReq.getTotalTicket(),
				movieReq.getTicketBalance());
		movieDao.save(movie);
		
		return new MovieRes(movie, MovieRtnCode.SUCCESSFUL.getMessage());
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
	public MovieRes findMovieByMovieNameOrType(String typeOrMovieName) {
		List<MovieRes> movieResList = new ArrayList<>();
		MovieRes movieRes = new MovieRes();

		if (!movieDao.findMovieByMovieName(typeOrMovieName).isEmpty()) {
			List<Movie> movieNameList = movieDao.findMovieByMovieName(typeOrMovieName);
			if(movieNameList.isEmpty()) {
				return null;
			}
			for (Movie movie : movieNameList) {
				MovieRes moviesRes = new MovieRes(movie.getMovieCode(), movie.getMovieName(), movie.getDay(),
						movie.getType(), movie.getStartTime(), movie.getPrice());
				movieResList.add(moviesRes);
			}
			movieRes.setMovieList(movieNameList);
			return movieRes;

		} else if (movieDao.findMovieByType(typeOrMovieName).isEmpty()) {
			List<Movie> movieTypeList = movieDao.findMovieByType(typeOrMovieName);
			if(movieTypeList.isEmpty()) {
				return null;
			}
			for (Movie movie : movieTypeList) {
				MovieRes moviesRes = new MovieRes(movie.getMovieCode(), movie.getMovieName(), movie.getDay(),
						movie.getType(), movie.getStartTime(), movie.getPrice());
				movieResList.add(moviesRes);
			}
			movieRes.setMovieList(movieTypeList);
			return movieRes;
		}
		return movieRes;
	}
	
	@Override
	public MovieRes createCustomerAndBuy(MovieReq movieReq) {
		MovieRes res = new MovieRes();
		if (!StringUtils.hasText(movieReq.getMovieCode())) {
			res.setMessage(MovieRtnCode.MOVIE_CODE_NOT_EXSIST.getMessage());
			return res;
		}
		Optional<Movie> movieOp = movieDao.findById(movieReq.getMovieCode());
		if (movieOp.isEmpty()) {
			res.setMessage(MovieRtnCode.MOVIE_CODE_NOT_EXSIST.getMessage());
			return res;
		}
		// §ó·s³Ñ¾l²¼¼Æ
		Movie movie = movieOp.get();
		movie.setTicketBalance(movie.getTicketBalance() - movieReq.getTicketQuantity());
		// ÀË¬d³Ñ¾l²¼¼Æ
		if (movie.getTicketBalance() == 0) {
			res.setMessage(MovieRtnCode.TICKET_SOLD_OUT.getMessage());
			return res;
		}
		if (movieReq.getTicketQuantity() > movie.getTicketBalance()) {
			res.setMessage(MovieRtnCode.TICKET_NOT_ENOUGH.getMessage());
			return res;
		}
		movieDao.save(movie);
		// ¦s¶iDB
		Customers customer = new Customers();
		customer.setCustomerName(movieReq.getCustomerName());
		customer.setMovieCode(movieReq.getMovieCode());
		customer.setTicketQuantity(movieReq.getTicketQuantity());
		customer.setTotalPrice(movie.getPrice() * movieReq.getTicketQuantity());
		customersDao.save(customer);
		// ©¹res³]­È
		res.setCustomerId(customer.getId());
		res.setCustomerName(customer.getCustomerName());
		res.setBuyMovieCode(customer.getMovieCode());
		res.setTicketQuantity(customer.getTicketQuantity());
		res.setTotalPrice(customer.getTotalPrice());
		res.setVerify(false);
		res.setMessage(MovieRtnCode.SUCCESSFUL.getMessage());
		return res;
	}

	@Override
	public MovieRes reviseCustomerAndBuy(MovieReq movieReq) {
		MovieRes res = new MovieRes();
		if (movieReq.getCustomerId() == null) {
			res.setMessage(MovieRtnCode.CUSTOMERID_NOT_EXSIST.getMessage());
			return res;
		}
		Optional<Customers> customerOp = customersDao.findById(movieReq.getCustomerId());
		if (customerOp.isEmpty()) {
			res.setMessage(MovieRtnCode.CUSTOMERID_NOT_EXSIST.getMessage());
			return res;
		}
		// ¦s¶iDB
		Customers customer = customerOp.get();
		customer.setTicketQuantity(movieReq.getTicketQuantity());
		// 修改
		// Movie movie = new Movie();
		Movie movie = movieDao.findById(customer.getMovieCode()).get();
		if (movie.getTicketBalance() == 0) {
			res.setMessage(MovieRtnCode.TICKET_SOLD_OUT.getMessage());
			return res;
		}
		if (movieReq.getTicketQuantity() > movie.getTicketBalance()) {
			res.setMessage(MovieRtnCode.TICKET_NOT_ENOUGH.getMessage());
			return res;
		}
		customersDao.save(customer);
		// ©¹res³]­È
		res.setCustomerId(customer.getId());
		res.setCustomerName(customer.getCustomerName());
		res.setBuyMovieCode(customer.getMovieCode());
		res.setTicketQuantity(customer.getTicketQuantity());
		res.setTotalPrice(customer.getTotalPrice());
		res.setMessage(MovieRtnCode.SUCCESSFUL.getMessage());
		return res;
	}

	@Override
	public MovieRes deleteCustomerAndBuy(MovieReq movieReq) {
		MovieRes res = new MovieRes();
		if (movieReq.getCustomerId() == null) {
			res.setMessage(MovieRtnCode.CUSTOMERID_NOT_EXSIST.getMessage());
			return res;
		}
		Optional<Customers> customerOp = customersDao.findById(movieReq.getCustomerId());
		if (customerOp.isPresent()) {
			customersDao.deleteById(movieReq.getCustomerId());
			res.setMessage(MovieRtnCode.SUCCESSFUL.getMessage());
		} else {
			res.setMessage(MovieRtnCode.CUSTOMERID_NOT_EXSIST.getMessage());
		}
		Customers customer = customerOp.get();
		Optional<Movie> movieOp = movieDao.findById(customer.getMovieCode());
		Movie movie = movieOp.get();
		movie.setTotalTicket(movie.getTotalTicket() + customer.getTicketQuantity());
		return res;
	}

	@Override
	public MovieRes findAllMovieByName(MovieReq movieReq) {
		List<Customers> customerOrderList = customersDao.findByCustomerName(movieReq.getCustomerName());

		if (customerOrderList.isEmpty()) {
			return new MovieRes(MovieRtnCode.ORDER_LIST_IS_EMPTY.getMessage());
		}

		return new MovieRes(customerOrderList, MovieRtnCode.SUCCESSFUL.getMessage());
	}

}
