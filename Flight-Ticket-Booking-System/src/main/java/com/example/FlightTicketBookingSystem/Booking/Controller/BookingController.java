package com.example.FlightTicketBookingSystem.Booking.Controller;

import com.example.FlightTicketBookingSystem.Booking.Model.Passenger;
import com.example.FlightTicketBookingSystem.Booking.Service.BookingService;
import com.example.FlightTicketBookingSystem.Flight.Model.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/booking/")
public class BookingController {

    BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping(path = "book_ticket/")
    public void bookTickets(@RequestParam(value = "id",required = false) Integer id, Flight flight, List<Passenger> passengers){
        service.bookTickets(id,flight,passengers);
    }
}
