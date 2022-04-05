package com.example.FlightTicketBookingSystem.Admin.Services;



import com.example.FlightTicketBookingSystem.Admin.Repositories.FareRepository;
import com.example.FlightTicketBookingSystem.Admin.Repositories.FleetRepository;
import com.example.FlightTicketBookingSystem.Flight.Fare;
import com.example.FlightTicketBookingSystem.Flight.Fleet;
import com.example.FlightTicketBookingSystem.User.Model.Contact;
import com.example.FlightTicketBookingSystem.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AdminService {
    FleetRepository fleetRepository;
    FareRepository fareRepository;

    public AdminService() {
    }

    @Autowired
    public AdminService(FleetRepository fleetRepository, FareRepository fareRepository) {
        this.fleetRepository = fleetRepository;
        this.fareRepository = fareRepository;
    }

    //create a fleet
    public Fleet registerFleet(Fleet fleet) {
        return fleetRepository.save(fleet);
    }


    //update the fleet
    @Transactional
    public Fleet UpdateFleet(Integer id, Fleet fleet){
        Optional<Fleet> u = fleetRepository.findById(id);
        u.get().setCode(fleet.getCode());
        u.get().setModel(fleet.getModel());
        u.get().setTotalEconomySeats(fleet.getTotalEconomySeats());
        u.get().setTotalBusinessSeats(fleet.getTotalBusinessSeats());
        u.get().setTotalPremiumSeats(fleet.getTotalPremiumSeats());
        return u.get();
    }

    //Get the fare
    public Fare registerFare(Fare fare) {
        return fareRepository.save(fare);
    }

    //update the fare
    @Transactional
    public Fare UpdateFare(Integer id, Fare fare){
        Optional<Fare> w = fareRepository.findById(id);
        w.get().setEconomyFare(fare.getEconomyFare());
        w.get().setPremiumFare(fare.getPremiumFare());
        w.get().setBusinessFare(fare.getBusinessFare());
        return w.get();
    }

}

