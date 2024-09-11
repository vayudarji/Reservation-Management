package com.hotelbooking.HotelBooking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hotelbooking.HotelBooking.entity.Booking;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private long id;
    private String name;
    private String email;
    private String phonenumber;
    private String role;
    private List<BookingDTO> bookings = new ArrayList<>();
}
