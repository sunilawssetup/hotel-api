package com.app.hotel.controller;

import com.app.hotel.dto.HotelDto;
import com.app.hotel.dto.OrderIteamDto;
import com.app.hotel.dto.ResponseDto;
import com.app.hotel.service.IHotelService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel-api")
@Tag(
        name = "HOTEL-API",
        description = "this is a Hotel api"
)
public class HotelController {

    @Autowired
    IHotelService hotelServiceImpl;

    @Operation(
            summary = "view hotel",
            description = "view the Hotel all hotel"
    )
    @ApiResponse(
            responseCode = "200",
            description = "this view the hotels"
    )
    @GetMapping("/view-hotel")
    public List<HotelDto> viewHotel() {
        return hotelServiceImpl.viewHotel();
    }

    @Operation(
            summary = "Add Hotel",
            description = "adding in hotel api"
    )
    @ApiResponse(
            responseCode = "201",
            description = "this add hotel"
    )
    @PostMapping("/addHotel")
    public ResponseEntity<ResponseDto> addHotel(@RequestBody HotelDto hotelDto) {
        if (hotelServiceImpl.addHotel(hotelDto)) {
            return new ResponseEntity<>(ResponseDto.builder().message("hotel added").httpStatus(HttpStatus.CREATED).build(), HttpStatus.CREATED);
        }
        return null;
    }

    @Operation(
            summary = "Get Order",
            description = "her we get the order"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP status code 200"
    )
    @GetMapping("/getAllOrders")
    @CircuitBreaker(name = "getAllOrder", fallbackMethod = "getAllOrderFallBack")
    public List<OrderIteamDto> getAllOrders() {
        return hotelServiceImpl.getAllOrders();
    }

    @Operation(
            summary = "updateOrderStatus",
            description = "here we are update the order status"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP status code 200"
    )
    @PostMapping("/updateOrderStatus/{orderId}")
    @CircuitBreaker(name = "updateOrderStatus", fallbackMethod = "updateOrderStatusFallback")
    public OrderIteamDto updateOrderStatus(@PathVariable("orderId") Long orderId, @RequestParam("orderStatus") String orderStatus) {
        return hotelServiceImpl.updateOrderStatus(orderId, orderStatus);
    }


    public OrderIteamDto updateOrderStatusFallback(Long orderId, String orderStatus) {
        return OrderIteamDto.builder()
                .paymentStatus("DUMMY_DONE")
                .orderStatus("DUMMY_DONE")
                .orderId(0L)
                .qty(0L)
                .customerId(0L)
                .hotelId(0L)
                .menuId(0L)
                .build();
    }

    public List<OrderIteamDto> getAllOrderFallBack() {

        return List.of(OrderIteamDto.builder()
                .orderId(0l)
                .hotelId(0l)
                .menuId(0l)
                .qty(0l)
                .paymentStatus("DUMMY_DONE")
                .orderStatus("DUMMY_DONE")
                .build());
    }


}
