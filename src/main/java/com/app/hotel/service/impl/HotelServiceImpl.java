package com.app.hotel.service.impl;

import com.app.hotel.dto.HotelDto;
import com.app.hotel.dto.OrderIteamDto;
import com.app.hotel.model.Hotel;
import com.app.hotel.model.Menu;
import com.app.hotel.repo.HotelRepo;
import com.app.hotel.repo.MenuRepo;
import com.app.hotel.service.IHotelService;
import com.app.hotel.service.client.OrderFeign;
import com.app.hotel.util.HotelMapper;
import com.app.hotel.util.MenuMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements IHotelService {


    Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private OrderFeign orderFeign;

    @Override
    public boolean addHotel(HotelDto hotel) {

        Hotel hotel1 = HotelMapper.hotelDtoMapByHotel(hotel);
        logger.info("Hotel {}",hotel1);
       Hotel hotel2= hotelRepo.save(hotel1);
        if (Objects.nonNull(hotel2)) {
            List<Menu> collectMenu = hotel.getItems().stream().map(menuDto -> {
                menuDto.setHotelId(hotel2.getHotelId());
                logger.info("Menu Dto{}"+menuDto);
                return MenuMapper.menueMapByMenuDto(menuDto);

            }).collect(Collectors.toList());
            logger.info("list info{}",collectMenu);
            menuRepo.saveAll(collectMenu);

            return true;
        }
        return false;
    }

    @Override
    public List<HotelDto> viewHotel() {
        List<HotelDto> collect = hotelRepo.findAll().stream().map(hotel -> HotelMapper.hotelMapByHotelDto(hotel)).collect(Collectors.toList());

        List<HotelDto> collect1 = collect.stream().map(hotelDto -> {
            hotelDto.setItems(menuRepo.findByHotelId(hotelDto.getHotelId())
                    .stream()
                    .map(menu -> MenuMapper.menueDtoMapByMenu(menu))
                    .collect(Collectors.toList()));
            return hotelDto;

        }).collect(Collectors.toList());

        return collect1;
    }

    @Override
    public List<OrderIteamDto> getAllOrders() {
        return orderFeign.getAllOrders();
    }

    @Override
    public OrderIteamDto updateOrderStatus(Long orderId, String orderStatus) {
        return orderFeign.updateOrderStatus(orderId,orderStatus);
    }
}
