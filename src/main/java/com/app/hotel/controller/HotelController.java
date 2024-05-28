package com.app.hotel.controller;

import com.app.hotel.dto.HotelDto;
import com.app.hotel.dto.ResponseDto;
import com.app.hotel.service.IHotelService;
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
    public ResponseEntity<ResponseDto> addHotel(@RequestBody  HotelDto hotelDto) {
        if (hotelServiceImpl.addHotel(hotelDto)) {
            return new ResponseEntity<>(ResponseDto.builder().message("hotel added").httpStatus(HttpStatus.CREATED).build(), HttpStatus.CREATED);
        }
        return null;
    }


}
