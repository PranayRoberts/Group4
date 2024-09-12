package com.example.FlightTicketBookingSystem.Repositories;

import com.example.FlightTicketBookingSystem.Flight.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FleetRepository extends JpaRepository<Fleet,Integer> {

}