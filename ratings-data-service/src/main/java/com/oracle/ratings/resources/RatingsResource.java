package com.oracle.ratings.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.ratings.models.Rating;
import com.oracle.ratings.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	public RatingsResource() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/movies/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId")String movieId) {
		return new Rating(movieId, 3);
	}
	
	@RequestMapping("/user/{userId}")
	public UserRating getUserRatings(@PathVariable("userId")String userId) {
		UserRating userRating = new UserRating();
		userRating.initData(userId);
		return userRating;
		
	}
}
