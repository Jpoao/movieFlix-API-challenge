package com.devsuperior.movieflix.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired 
	private MovieRepository movieRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional
	public ReviewDTO InsertUserReview(String text, Long movieId) {
		
		User authenticatedUser = authService.authenticated();
		
		Review review = new Review();
		review.setMovie(movieRepository.getOne(movieId));
		review.setText(text);
		review.setUser(authenticatedUser);
		reviewRepository.save(review);
		
		return new ReviewDTO(review, authenticatedUser);
	}
}
