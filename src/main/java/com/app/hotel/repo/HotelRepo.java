package com.app.hotel.repo;

import com.app.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,Long> {
}
