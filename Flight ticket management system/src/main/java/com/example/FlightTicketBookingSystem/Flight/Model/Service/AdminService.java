package com.example.FlightTicketBookingSystem.Flight.Model.Service;

import com.example.FlightTicketBookingSystem.Flight.Model.*;
import com.example.FlightTicketBookingSystem.Flight.Model.Repository.*;

import com.example.FlightTicketBookingSystem.User.Model.User;

import com.example.FlightTicketBookingSystem.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AdminService {
    LocationRepository locationRepository;
    FleetRepository fleetRepository;
    FlightStatustReposiory flightStatustReposiory;
    FareRepository fareRepository;
    UserRepository userRepository;
    FlightRepository flightRepository;

    public AdminService() {
    }

        @Autowired
    public AdminService(LocationRepository locationRepository, FleetRepository fleetRepository, FlightStatustReposiory flightStatustReposiory, FareRepository fareRepository, FlightRepository flightRepository) {
            this.locationRepository = locationRepository;
            this.fleetRepository = fleetRepository;
            this.fareRepository = fareRepository;
            this.flightStatustReposiory = flightStatustReposiory;
            this.flightRepository = flightRepository;
        }
            public User loginAdmin(String userValue, String password) {

                Optional<User> userName = userRepository.findUserByUserName(userValue);
                Optional<User> email = userRepository.findUserByEmail(userValue);

                //checking for username and password
                if (userName.isPresent()) {
                    if (userName.get().getPassword().equals(password))
                        return userName.get();
                    else
                        throw new IllegalStateException("please check username and password");
                }
                
                //checking for email and password
                else if (email.isPresent()) {
                    if (email.get().getPassword().equals(password))
                        return email.get();
                    else
                        throw new IllegalStateException("please check email and password");
                }
                else
                    throw new IllegalStateException("admin doesn't exists!");
            }

    public Flight createFlight(Flight flight) {
        Flight flight1 = flightRepository.save(flight);
        System.out.println(flight1.getStatus());

        return flight1;
    }
    @Transactional
    public Flight UpdateFlight(Integer id,Flight flight){
        Optional<Flight> f = flightRepository.findById(id);
        f.get().setDepartureLocation(flight.getDepartureLocation());
        f.get().setArrivalLocation(flight.getArrivalLocation());
//        f.get().setFleet(flight.getFleet());
        f.get().setArrivalTime(flight.getArrivalTime());
        f.get().setDepartureTime(flight.getDepartureTime());
//        f.get().setStatus(flight.getStatus());
//        f.get().setFare(flight.getFare());

        Fleet fleet = fleetRepository.getById(f.get().getFleet().getId());
        fleet.setCode(flight.getFleet().getCode());
        fleet.setModel(flight.getFleet().getModel());
        fleet.setTotalBusinessSeats(flight.getFleet().getTotalBusinessSeats());
        fleet.setTotalEconomySeats(flight.getFleet().getTotalEconomySeats());
        fleet.setTotalPremiumSeats(flight.getFleet().getTotalPremiumSeats());

        FlightStatus flightStatus = flightStatustReposiory.getById(f.get().getStatus().getId());
        flightStatus.setRemainingBusinessSeats(flight.getStatus().getRemainingBusinessSeats());
        flightStatus.setRemainingEconomySeats(flight.getStatus().getRemainingEconomySeats());
        flightStatus.setRemainingPremiumSeats(flight.getStatus().getRemainingPremiumSeats());

        Fare fare = fareRepository.getById(f.get().getFare().getId());
        fare.setBusinessFare(flight.getFare().getBusinessFare());
        fare.setEconomyFare(flight.getFare().getEconomyFare());
        fare.setPremiumFare(flight.getFare().getPremiumFare());

        return f.get();
    }
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Transactional
    public Location UpdateLocation(Integer id,Location location){
        Optional<Location> l = locationRepository.findById(id);
        l.get().setCode(location.getCode());
        l.get().setCountry(location.getCountry());
        l.get().setAirportName(location.getAirportName());
        l.get().setName(location.getName());
        return l.get();
    }

    @Transactional
    public Fleet UpdateFleet(Integer id, Fleet fleet){
        Optional<Fleet> fl = fleetRepository.findById(id);
        fl.get().setCode(fleet.getCode());
        fl.get().setModel(fleet.getModel());
        fl.get().setTotalBusinessSeats(fleet.getTotalBusinessSeats());
        fl.get().setTotalEconomySeats(fleet.getTotalEconomySeats());
        fl.get().setTotalPremiumSeats(fleet.getTotalPremiumSeats());
        return fl.get();
    }

    public Fleet createFleet(Fleet fleet) {
        return fleetRepository.save(fleet);
    }

    public Fare addFare(Fare fare){
        return fareRepository.save(fare);
    }
    @Transactional
    public Fare UpdateFare(Integer id, Fare fare){
        Optional<Fare> fa = fareRepository.findById(id);
        fa.get().setBusinessFare(fare.getBusinessFare());
        fa.get().setEconomyFare(fare.getEconomyFare());
        fa.get().setPremiumFare(fare.getPremiumFare());

        return fa.get();
    }





}
