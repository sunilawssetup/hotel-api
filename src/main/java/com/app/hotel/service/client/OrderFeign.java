package com.app.hotel.service.client;


import com.app.hotel.dto.OrderIteamDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("ORDER-API")
public interface OrderFeign {
    @GetMapping("/order/getALlOrders")
    public List<OrderIteamDto> getAllOrders();

    @PostMapping("/order/updateOrderStatus/{orderId}")
    public OrderIteamDto updateOrderStatus(@PathVariable("orderId") Long orderId, @RequestParam("orderStatus") String orderStatus);
}
