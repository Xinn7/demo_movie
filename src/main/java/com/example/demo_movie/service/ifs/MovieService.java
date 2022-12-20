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
	
	//findMovieByMovieName �M findMovieByType ���G�X�@�j�M
	public MovieRes findMovieByMovieNameOrType(String typeOrMovieName);
	
	//�R��
	public MovieRes createCustomerAndBuy(MovieReq movieReq);
	
	//�ק�
	public MovieRes reviseCustomerAndBuy(MovieReq movieReq);
	
	//�R��
	public MovieRes deleteCustomerAndBuy(MovieReq movieReq);
	
	//�̫Ȥ�W�٬d�߭q��
	public MovieRes findAllMovieByName(MovieReq movieReq);
	
	//�̫Ȥ�q��N�X�d�߭q��
	public MovieRes findByCustomerId(MovieReq movieReq);
	
	//�������Ҫ��A
	public void reviseStatus(MovieReq req);
	
}
