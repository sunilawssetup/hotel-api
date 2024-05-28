package com.app.hotel.repo;

import com.app.hotel.dto.MenuDto;
import com.app.hotel.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepo extends JpaRepository<Menu,Long> {
    List<Menu> findByHotelId(Long hotelId);
}
