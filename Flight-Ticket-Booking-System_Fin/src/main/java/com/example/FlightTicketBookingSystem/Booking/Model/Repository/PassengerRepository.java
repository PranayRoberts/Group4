package com.example.FlightTicketBookingSystem.Booking.Model.Repository;

import com.example.FlightTicketBookingSystem.Booking.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
