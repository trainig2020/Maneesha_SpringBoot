package com.spring.Rating_Data_Service.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Rating_Data_Service.model.Rating;
import com.spring.Rating_Data_Service.model.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingResource {
	
	@RequestMapping("{movieId}")
	public Rating getmovieRating(@PathVariable String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable String userId){
		
		List<Rating> ratings = Arrays.asList(new Rating("1", 5),
				new Rating("2", 4));
		 UserRating userRating = new UserRating();
		 userRating.setUserRating(ratings);
		 return userRating;
		
	}

}
