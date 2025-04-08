package com.cws.hotel.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;

}
