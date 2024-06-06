package com.app.hotel.service;

import com.app.hotel.dto.HotelDto;
import com.app.hotel.dto.OrderIteamDto;
import com.app.hotel.model.Hotel;

import java.util.List;

public interface IHotelService {
    public boolean addHotel(HotelDto hotel);

    public List<HotelDto> viewHotel();

    public List<OrderIteamDto> getAllOrders();

    public OrderIteamDto updateOrderStatus(Long orderId, String orderStatus);
}
