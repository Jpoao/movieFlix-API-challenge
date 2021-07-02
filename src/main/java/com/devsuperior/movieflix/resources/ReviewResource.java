package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewResource {

	@Autowired
	private ReviewService service;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<ReviewDTO> InsertNewReview(@RequestBody ReviewDTO review){
		ReviewDTO result = service.InsertUserReview(review.getText(), review.getMovieId());
		return ResponseEntity.ok(result);
		
	}
}
