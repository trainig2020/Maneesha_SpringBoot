package com.spring.moviecatalogservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.moviecatalogservice.model.CatalogItem;
import com.spring.moviecatalogservice.model.Movie;
import com.spring.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		
		
		
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/rating/user/"+userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(), Movie.class);
			
			
			return new CatalogItem(movie.getName(), "Test", rating.getRating());
		})
				.collect(Collectors.toList());
		
	}

}

/*
 * webClientBuilder.build() .get()
 * .uri("http://localhost:8082/movie/"+rating.getMovieId())
 * .bodyToMono(Movie.class) .build();
 */

