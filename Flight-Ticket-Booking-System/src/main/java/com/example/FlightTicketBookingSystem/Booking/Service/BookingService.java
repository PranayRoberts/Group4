package com.example.FlightTicketBookingSystem.Booking.Service;

import com.example.FlightTicketBookingSystem.Booking.Model.Passenger;
import com.example.FlightTicketBookingSystem.Booking.Repository.BookingRepository;
import com.example.FlightTicketBookingSystem.Booking.Repository.PassengersRepository;
import com.example.FlightTicketBookingSystem.Flight.Model.Flight;
import com.example.FlightTicketBookingSystem.Flight.Repository.FlightRepository;
import com.example.FlightTicketBookingSystem.Flight.Repository.FlightStatustReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    BookingRepository bookingRepository;
    FlightRepository flightRepository;
    FlightStatustReposiory flightStatustReposiory;
    PassengersRepository passengersRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository,
                          FlightRepository flightRepository,
                          FlightStatustReposiory flightStatustReposiory,
                          PassengersRepository passengersRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.flightStatustReposiory = flightStatustReposiory;
        this.passengersRepository = passengersRepository;
    }

    public void bookTickets(Integer id, Flight flight, List<Passenger> passengers){
        if(id==null){
            throw new IllegalStateException("please login");
        }
        passengersRepository.saveAll(passengers);
    }
}
