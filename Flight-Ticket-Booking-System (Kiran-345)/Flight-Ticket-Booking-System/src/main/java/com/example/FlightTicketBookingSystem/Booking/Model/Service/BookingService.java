package com.example.FlightTicketBookingSystem.Booking.Model.Service;

import com.example.FlightTicketBookingSystem.Booking.Model.Booking;
import com.example.FlightTicketBookingSystem.Booking.Model.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    BookingRepository bookingRepository;

    public BookingService() {
    }
    @Autowired

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
     public Booking bookFlight(Booking booking){
        return bookingRepository.save(booking);
     }
}
