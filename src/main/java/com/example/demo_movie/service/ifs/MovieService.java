package com.example.demo_movie.service.ifs;

//import com.example.demo_movie.entity.Movie;
import com.example.demo_movie.vo.MovieReq;
import com.example.demo_movie.vo.MovieRes;

public interface MovieService {

	public MovieRes createMovieInfo(MovieReq movieReq);
	
	public MovieRes reviseMovieInfo(MovieReq movieReq);
	
	public MovieRes deleteMovieInfo(MovieReq movieReq);
	
//	public List<Movie> findMovieByMovieName(String movieName);
//	
//	public List<Movie> findMovieByType(String type);
	
	//findMovieByMovieName 和 findMovieByType 的二合一搜尋
	public MovieRes findMovieByMovieNameOrType(String typeOrMovieName);
	
	//買票
	public MovieRes createCustomerAndBuy(MovieReq movieReq);
	
	//修改
	public MovieRes reviseCustomerAndBuy(MovieReq movieReq);
	
	//刪除
	public MovieRes deleteCustomerAndBuy(MovieReq movieReq);
	
	//依客戶名稱查詢訂單
	public MovieRes findAllMovieByName(MovieReq movieReq);
	
	//依客戶訂單代碼查詢訂單
	public MovieRes findByCustomerId(MovieReq movieReq);
	
	//改變驗證狀態
	public void reviseStatus(MovieReq req);
	
}
