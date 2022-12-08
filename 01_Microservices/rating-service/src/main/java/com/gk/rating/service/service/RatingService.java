package com.gk.rating.service.service;

import java.util.List;

import com.gk.rating.service.entity.Rating;

public interface RatingService {

	// create
	Rating create(Rating rating);

	// get all ratings
	List<Rating> getRatings();

	// get all rating by userId
	List<Rating> getRatingByUserId(String userId);

	// get all rating by hotelId
	List<Rating> getRatingByHotelId(String hotelId);

}
