package com.spring.Movie_Info_Service.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Movie_Info_Service.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieResource {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		return new Movie("1", "Mersal");
	}

}
