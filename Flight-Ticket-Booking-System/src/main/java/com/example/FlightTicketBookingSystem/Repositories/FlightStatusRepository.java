package com.example.FlightTicketBookingSystem.Repositories;

import com.example.FlightTicketBookingSystem.Flight.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightStatusRepository extends JpaRepository<FlightStatus, Integer> {

}
