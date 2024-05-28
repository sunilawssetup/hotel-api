package com.app.hotel.util;

import com.app.hotel.dto.HotelDto;
import com.app.hotel.model.Hotel;

public class HotelMapper {
    public static Hotel hotelDtoMapByHotel(HotelDto hotelDto){
        Hotel hotel=new Hotel();
        hotel.setHotelId(hotelDto.getHotelId());
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setDescription(hotelDto.getDescription());
        return hotel;
    }
    public static HotelDto hotelMapByHotelDto(Hotel hotel){
        HotelDto hotelDto=new HotelDto();
        hotelDto.setHotelId(hotel.getHotelId());
        hotelDto.setHotelName(hotel.getHotelName());
        hotelDto.setDescription(hotel.getDescription());
        return  hotelDto;
    }
}
