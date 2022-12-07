package com.gk.hotel.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.hotel.service.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
