package com.app.hotel.dto;

import com.app.hotel.model.Menu;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class HotelDto {
    private Long hotelId;
    private String hotelName;
    private String description;
    List<MenuDto> items;
}
