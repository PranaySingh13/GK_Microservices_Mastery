package com.gk.hotel.service.service;

import java.util.List;

import com.gk.hotel.service.entity.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);

	List<Hotel> getAll();

	Hotel get(String hotelId);

}
