package com.example.FlightTicketBookingSystem.Repositories;

import com.example.FlightTicketBookingSystem.Flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight,Integer> {

    Optional<Flight> findFlightByDepartureLocation(String departureLocation);
    Optional<Flight> findFlightByArrivalLocation(String arrivalLocation);
}
