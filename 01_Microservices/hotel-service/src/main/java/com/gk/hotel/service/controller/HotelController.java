package com.gk.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.hotel.service.entity.Hotel;
import com.gk.hotel.service.service.HotelService;

@RestController
@RequestMapping("/api/hotels/")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping("/save")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel createdHotel = hotelService.create(hotel);
		return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId) {
		Hotel hotel = hotelService.get(hotelId);
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> hotels = hotelService.getAll();
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}

}
