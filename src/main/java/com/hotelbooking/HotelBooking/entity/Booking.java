package com.hotelbooking.HotelBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Check In date is required")
    private LocalDate checkInDate;
    @Future(message = "Check Out date can not be in the future")
    private LocalDate checkOutDate;

    @Min(value=1,message = "Number of Abults cannot be less then 1")
    private int numberOfAdults;
    @Min(value=0,message = "Number of children cannot be less then 0")
    private int numberOfChildren;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void calculateTotalNumOfGuest() {
        this.totalNumOfGuest = this.numberOfAdults + this.numberOfChildren;

    }

    public void setNumberOfAdults(@Min(value = 1, message = "Number of Abults cannot be less then 1") int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
        calculateTotalNumOfGuest();
    }

    public void setNumberOfChildren(@Min(value = 0, message = "Number of children cannot be less then 0") int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
        calculateTotalNumOfGuest();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfAdults=" + numberOfAdults +
                ", numberOfChildren=" + numberOfChildren +
                ", totalNumOfGuest=" + totalNumOfGuest +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                '}';
    }
}
