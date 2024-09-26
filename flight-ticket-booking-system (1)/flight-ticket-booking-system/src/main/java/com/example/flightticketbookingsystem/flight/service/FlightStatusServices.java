package com.example.flightticketbookingsystem.flight.service;

import com.example.flightticketbookingsystem.flight.model.Fleet;
import com.example.flightticketbookingsystem.flight.model.FlightStatus;
import com.example.flightticketbookingsystem.flight.repository.FleetRepo;
import com.example.flightticketbookingsystem.flight.repository.FlightStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class FlightStatusServices {

    FlightStatusRepo flightStatusRepo;
    FleetRepo fleetRepo;

    @Autowired

    public FlightStatusServices(FlightStatusRepo flightStatusRepo, FleetRepo fleetRepo) {
        this.flightStatusRepo = flightStatusRepo;
        this.fleetRepo = fleetRepo;
    }

    public void UpdateStatus(FlightStatus flightStatus, Fleet fleet){
    Optional<FlightStatus> flightStatus1 = flightStatusRepo.findById(flightStatus.getId());
        Optional<Fleet> fleet1 = fleetRepo.findById(fleet.getId());
    if(flightStatus1.isPresent()) {
        flightStatus1.get().setRemainingBusinessSeats(fleet1.get().getTotalBusinessSeats() - 10);
        flightStatus1.get().setRemainingPremiumSeats(fleet1.get().getTotalPremiumSeats() - 10);
        flightStatus1.get().setRemainingEconomySeats(fleet1.get().getTotalEconomySeats() - 10);
    }
    }
}




