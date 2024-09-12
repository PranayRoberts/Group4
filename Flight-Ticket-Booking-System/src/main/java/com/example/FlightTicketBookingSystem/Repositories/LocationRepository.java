package com.example.FlightTicketBookingSystem.Repositories;

import com.example.FlightTicketBookingSystem.Flight.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
