package com.example.FlightTicketBookingSystem.Repositories;


import com.example.FlightTicketBookingSystem.Flight.Fare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FareRepository extends JpaRepository<Fare,Integer> {

}