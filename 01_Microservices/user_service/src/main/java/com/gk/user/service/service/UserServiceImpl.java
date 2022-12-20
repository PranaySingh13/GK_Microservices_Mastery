package com.gk.user.service.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gk.user.service.entity.Hotel;
import com.gk.user.service.entity.Rating;
import com.gk.user.service.entity.User;
import com.gk.user.service.exception.ResourceNotFoundException;
import com.gk.user.service.externalServices.HotelService;
import com.gk.user.service.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// Implement rating service for all users

		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id" + userId));

		// fetch rating of the above user from rating service
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/api/ratings/user/" + userId,
				Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());

		List<Rating> ratingList = ratings.stream().map(rating -> {

			// api call to hotel service to get the hotel
			// http://localhost:8082/api/hotels/hotel/59db9bc3-9eb4-4f11-b6fe-c91d6078cb6d
			/*
			 * ResponseEntity<Hotel> forEntity = restTemplate
			 * .getForEntity("http://HOTEL-SERVICE/api/hotels/hotel/" + rating.getHotelId(),
			 * Hotel.class);
			 * 
			 * Hotel hotel = forEntity.getBody();
			 * 
			 * logger.info("Response status code {}", forEntity.getStatusCode());
			 */
			Hotel hotel = hotelService.getHotel(rating.getHotelId());

			// set the hotel to rating
			rating.setHotel(hotel);

			// return the rating
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);
		return user;
	}

}
