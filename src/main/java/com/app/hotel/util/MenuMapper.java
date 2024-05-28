package com.app.hotel.util;

import com.app.hotel.dto.MenuDto;
import com.app.hotel.model.Menu;

public class MenuMapper {
    public static Menu menueMapByMenuDto(MenuDto menuDto){
        Menu menu=new Menu();
        menu.setMenueId(menuDto.getMenueId());
        menu.setName(menuDto.getName());
        menu.setType(menuDto.isType());
        menu.setDescription(menuDto.getDescription());
        menu.setPrice(menuDto.getPrice());
        menu.setHotelId(menuDto.getHotelId());
        return menu;
    }
    public static MenuDto menueDtoMapByMenu(Menu menu){
        MenuDto menuDto =new MenuDto();
        menuDto.setMenueId(menu.getMenueId());
        menuDto.setName(menu.getName());
        menuDto.setType(menu.isType());
        menuDto.setDescription(menu.getDescription());
        menuDto.setPrice(menu.getPrice());
        menuDto.setHotelId(menu.getHotelId());
        return menuDto;
    }
}
