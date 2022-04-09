package com.example.FlightTicketBookingSystem.Booking.Repository;


import com.example.FlightTicketBookingSystem.Booking.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengersRepository extends JpaRepository<Passenger,Integer> {
}
