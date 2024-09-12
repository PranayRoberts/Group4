package com.example.FlightTicketBookingSystem.Booking.Model.Service;

import com.example.FlightTicketBookingSystem.Booking.Model.Booking;
import com.example.FlightTicketBookingSystem.Booking.Model.Passenger;
import com.example.FlightTicketBookingSystem.Booking.Model.Repository.BookingRepository;
import com.example.FlightTicketBookingSystem.Booking.Model.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    BookingRepository bookingRepository;
    PassengerRepository passengerRepository;

    public BookingService() {
    }

    @Autowired
    public BookingService(BookingRepository bookingRepository,PassengerRepository passengerRepository) {
        this.bookingRepository = bookingRepository;
        this.passengerRepository=passengerRepository;
    }

    public List<Booking> getBook() {
        return bookingRepository.findAll();
    }

    public Booking bookFlight(Booking booking){
        return bookingRepository.save(booking);
    }

    public Passenger pBookFlight(Passenger passenger){
        return passengerRepository.save(passenger);
    }
}