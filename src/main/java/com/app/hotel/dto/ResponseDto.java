package com.app.hotel.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@Data
@Builder
public class ResponseDto {
    String message;
    HttpStatus httpStatus;
}
