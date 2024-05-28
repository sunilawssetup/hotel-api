package com.app.hotel.service;

import com.app.hotel.dto.HotelDto;
import com.app.hotel.model.Hotel;

import java.util.List;

public interface IHotelService {
    public boolean addHotel(HotelDto hotel);
    public List<HotelDto> viewHotel();

}
