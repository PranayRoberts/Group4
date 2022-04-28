package com.example.FlightTicketBookingSystem.Flight.Model.Repository;

import com.example.FlightTicketBookingSystem.Flight.Model.Flight;
import com.example.FlightTicketBookingSystem.Flight.Model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightStatustReposiory extends JpaRepository<FlightStatus, Integer> {

}

