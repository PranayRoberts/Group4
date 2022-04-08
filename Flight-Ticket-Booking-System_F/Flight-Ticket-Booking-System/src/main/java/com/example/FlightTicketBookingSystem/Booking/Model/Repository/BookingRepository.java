package com.example.FlightTicketBookingSystem.Booking.Model.Repository;

import com.example.FlightTicketBookingSystem.Booking.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
