package com.cws.hotel.services.impl;

import com.cws.hotel.Repository.HotelRepository;
import com.cws.hotel.entites.Hotel;
import com.cws.hotel.exception.ResourceNotFoundException;
import com.cws.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        Hotel hotel1 = hotelRepository.save(hotel);
        return hotel1;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getSingleHotel(String hotelId) {

        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found"));
        return hotel;
    }
}
