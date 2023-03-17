package com.msvc.hotel.service;

import com.msvc.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);
    List<Hotel> getAll();
    Hotel getHotel(String id);

}
