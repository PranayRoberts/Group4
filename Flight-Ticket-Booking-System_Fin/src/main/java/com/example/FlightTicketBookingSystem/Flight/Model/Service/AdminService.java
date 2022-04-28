package com.example.FlightTicketBookingSystem.Flight.Model.Service;

import com.example.FlightTicketBookingSystem.Flight.Model.*;
import com.example.FlightTicketBookingSystem.Flight.Model.Repository.*;

import com.example.FlightTicketBookingSystem.User.Model.User;

import com.example.FlightTicketBookingSystem.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    LocationRepository locationRepository;
    FleetRepository fleetRepository;
    FlightStatustReposiory flightStatustReposiory;
    FareRepository fareRepository;
    AdminRepository adminRepository;
    FlightRepository flightRepository;

    public AdminService() {
    }

        @Autowired
    public AdminService(LocationRepository locationRepository, FleetRepository fleetRepository, FlightStatustReposiory flightStatustReposiory, FareRepository fareRepository, FlightRepository flightRepository, AdminRepository adminRepository) {
            this.locationRepository = locationRepository;
            this.fleetRepository = fleetRepository;
            this.fareRepository = fareRepository;
            this.flightStatustReposiory = flightStatustReposiory;
            this.flightRepository = flightRepository;
            this.adminRepository = adminRepository;
        }

    public Admin registerAdmin(Admin admin) {
        Optional<Admin> userName = adminRepository.findAdminByUserName(admin.getUserName());
        if (userName.isPresent())
            throw new IllegalStateException("Username already exists!");
        else
            return adminRepository.save(admin);

    }

            public Admin loginAdmin(String userValue, String password) {

        Optional<Admin> userName = adminRepository.findAdminByUserName(userValue);
                if (userName.isPresent()) {
                    if (userName.get().getPassword().equals(password))
                        return userName.get();
                    else
                        throw new IllegalStateException("please enter valid username and password");
                }
                else
                    throw new IllegalStateException("admin doesn't exists!");
            }

    public Flight createFlight(Flight flight) {
        Flight flight1 = flightRepository.save(flight);
        return flight1;
    }

    @Transactional
    public Flight UpdateFlight(Integer id,Flight flight){
        Optional<Flight> f = flightRepository.findById(id);
        f.get().setDepartureLocation(flight.getDepartureLocation());
        f.get().setArrivalLocation(flight.getArrivalLocation());
        f.get().setArrivalTime(flight.getArrivalTime());
        f.get().setDepartureTime(flight.getDepartureTime());

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


    public FlightStatus addStatus(FlightStatus status){
        return flightStatustReposiory.save(status);
    }

    @Transactional
    public FlightStatus UpdateStatus(Integer id, FlightStatus status){
        Optional<FlightStatus> fs = flightStatustReposiory.findById(id);
        fs.get().setRemainingEconomySeats(status.getRemainingEconomySeats());
        fs.get().setRemainingPremiumSeats(status.getRemainingPremiumSeats());
        fs.get().setRemainingBusinessSeats(status.getRemainingBusinessSeats());

        return fs.get();
    }


    public List<Flight> getFlight(){
       return flightRepository.findAll();
    }


    public Flight getFlightById(Integer id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()){
            return flight.get();
        }
        else throw new IllegalStateException("User doesn't exists, Register User!!");
    }


    public List<Flight> searchFlight(String departure, String arrival) {
        List<Flight> allByDepartureLocation = flightRepository.findAllByDepartureLocation(departure);
        if (allByDepartureLocation.isEmpty()) {
            throw new IllegalStateException("No flights for this route");
        } else {
            List<Flight> result = new ArrayList<>();
            for(Flight flight:allByDepartureLocation){
                if (flight.getArrivalLocation().equals(arrival)){
                    result.add(flight);
                }
            }
            return result;
        }
    }

//    public List<Flight> searchFlight(String departureLocation, String arrivalLocation) {
//        int x=0;
//        List<Flight> l = new ArrayList<>();
//        Optional<Flight> arrivalocation = flightRepository.findByArrivalLocation(arrivalLocation);
//        if (arrivalocation.isPresent()) {
//            if (arrivalocation.get().getDepartureLocation().equals(departureLocation) && arrivalocation.get().getArrivalLocation().equals(arrivalLocation)) {
//                l.add(arrivalocation.get());
//                x+=1;
//            }
//        }
//        if (x>0) {
//            return l;
//        }
//        else {
//            throw new IllegalStateException("No such flight found");
//        }
//    }

    public Flight advancedSearch(String searchParameter, String searchValue) throws ParseException {
        if(searchParameter.equals("arrivalLocation")) {
            Optional<Flight> arrivalCity = flightRepository.findByArrivalLocation(searchValue);
            return arrivalCity.get();
        }

        else if(searchParameter.equals("departureLocation")) {
            Optional<Flight> departureCity = flightRepository.findByDepartureLocation(searchValue);
            return departureCity.get();
        }

        else if(searchParameter.equals("arrivalTime")) {
            Date at=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(searchValue);

            Optional<Flight> arrivalTime = flightRepository.findByArrivalTime(at);
            return arrivalTime.get();
        }

        else if(searchParameter.equals("departureTime")) {
            Date dt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(searchValue);

            Optional<Flight> departureTime = flightRepository.findByDepartureTime(dt);
            return departureTime.get();
        }


        else if(searchParameter.equals("flightNumber")){
            Optional<Flight> flightNumber = flightRepository.findById(Integer.parseInt(searchValue));
                return flightNumber.get();
        }
        else{
            throw new IllegalStateException("Enter valid search parameter");
        }
    }
}
