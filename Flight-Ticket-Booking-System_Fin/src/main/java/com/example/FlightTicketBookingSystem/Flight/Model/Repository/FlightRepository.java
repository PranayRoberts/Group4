package com.example.FlightTicketBookingSystem.Flight.Model.Repository;

import com.example.FlightTicketBookingSystem.Flight.Model.Flight;
import com.example.FlightTicketBookingSystem.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByArrivalLocation(String arrivalLocation);
    Optional<Flight> findByDepartureLocation(String departureLocation);
    Optional<Flight> findByArrivalTime(Date arrivalTime);
    Optional<Flight> findByDepartureTime(Date departureTime);
    List<Flight> findAllByDepartureLocation(String departureLocation);

}
