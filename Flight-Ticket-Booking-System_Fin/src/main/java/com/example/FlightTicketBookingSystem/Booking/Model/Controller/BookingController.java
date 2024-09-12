package com.example.FlightTicketBookingSystem.Booking.Model.Controller;

import com.example.FlightTicketBookingSystem.Booking.Model.Booking;
import com.example.FlightTicketBookingSystem.Booking.Model.Passenger;
import com.example.FlightTicketBookingSystem.Booking.Model.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "booking/")
public class BookingController {

    BookingService bookingService;

    @Autowired
    public BookingController(BookingService service ) {
        this.bookingService = service;
    }

    @PostMapping(path = "book/")
    public Booking bookFlight(@RequestBody(required = false) Booking booking){
        return bookingService.bookFlight(booking);
    }

    @GetMapping(path = "getbook/")
    public List<Booking> getValue() {return bookingService.getBook();
    }
    @PostMapping(path = "pbook/")
    public Passenger pBookFlight(Passenger passenger){
        return bookingService.pBookFlight(passenger);
    }



}