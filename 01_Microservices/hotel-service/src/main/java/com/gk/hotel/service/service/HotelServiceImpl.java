package com.gk.hotel.service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.hotel.service.entity.Hotel;
import com.gk.hotel.service.repo.HotelRepository;
import com.gk.user.service.exception.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		String randomUserId = UUID.randomUUID().toString();
		hotel.setId(randomUserId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel Not Found with id" + hotelId));
	}

}
