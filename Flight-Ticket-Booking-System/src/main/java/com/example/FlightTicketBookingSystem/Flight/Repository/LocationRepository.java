package com.example.FlightTicketBookingSystem.Flight.Repository;

import com.example.FlightTicketBookingSystem.Flight.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
