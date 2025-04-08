package com.cws.hotel.services;

import com.cws.hotel.entites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getSingleHotel(String hotelId);
}
