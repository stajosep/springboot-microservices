package com.oracle.catalog.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.oracle.catalog.models.CatalogItem;
import com.oracle.catalog.models.UserRating;
import com.oracle.catalog.services.MovieInfo;
import com.oracle.catalog.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	public CatalogResource() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
//	@RequestMapping("/{userId}")
//	@HystrixCommand(fallbackMethod="getFallbackCatalog")
//	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//		UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/"+userId, UserRating.class);
//	
//		return userRating.getRatings().stream()
//				.map(rating -> {
//					Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
//					return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());	
//				}).collect(Collectors.toList());
//	}
//	
//	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
//		return Arrays.asList(new CatalogItem("No Movie at this time - SERVER IS GETTING UPGRADED", "", 0));
//	}
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating userRating = userRatingInfo.getUserRating(userId);
		return userRating.getRatings().stream()
				.map(rating -> movieInfo.getCatalogItem(rating))
				.collect(Collectors.toList());

	}
}
