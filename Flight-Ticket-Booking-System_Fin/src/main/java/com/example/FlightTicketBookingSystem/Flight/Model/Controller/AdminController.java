package com.example.FlightTicketBookingSystem.Flight.Model.Controller;

import com.example.FlightTicketBookingSystem.Flight.Model.*;
import com.example.FlightTicketBookingSystem.Flight.Model.Service.AdminService;
import com.example.FlightTicketBookingSystem.User.Model.User;
import com.example.FlightTicketBookingSystem.User.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.jsf.FacesContextUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "admin/")
public class AdminController {
    AdminService adminService;

    @Autowired
    public AdminController(AdminService service) {
        this.adminService = service;
    }



    @PostMapping(path = "register_admin/")
    public Admin registerAdmin(@RequestBody Admin person) {
        return adminService.registerAdmin(person);
    }

    @PostMapping(path = "login_admin/")
    public Admin loginUser(@RequestParam(required = true) String userValue,
                           @RequestBody(required = true) String password) {
        return adminService.loginAdmin(userValue, password);
    }

    @PostMapping(path = "create_flight/")
    public Flight createFlight(@RequestBody Flight flight) {
        return adminService.createFlight(flight);
    }

    @PutMapping(path = "update_flight/")
    public Flight UpdateFlight(@RequestParam(required = true) Integer id,
                               @RequestBody(required = true) Flight flight){
        return adminService.UpdateFlight(id,flight);
    }

    @PostMapping(path = "create_fleet/")
    public Fleet createFleet(@RequestBody Fleet fleet) {
        return adminService.createFleet(fleet);
    }

    @PutMapping(path = "update_fleet/")
    public Fleet UpdateFleet(@RequestParam(required = true) Integer id,
                             @RequestBody(required = true) Fleet fleet){
        return adminService.UpdateFleet(id,fleet);
    }

    @PostMapping(path = "register_fare/")
    public Fare addFare(@RequestBody Fare fare) {
        return adminService.addFare(fare);
    }

    @PutMapping(path = "update_fare/")
    public Fare UpdateFare(@RequestParam(required = true) Integer id,
                           @RequestBody(required = true) Fare fare){
        return adminService.UpdateFare(id,fare);
    }


    @PostMapping(path = "add_location/")
    public Location addLocation(@RequestBody Location location) {
        return adminService.createLocation(location);
    }

    @PutMapping(path = "update_location/")
    public Location UpdateLocation(@RequestParam(required = true) Integer id,
                                   @RequestBody(required = true) Location location){
        return adminService.UpdateLocation(id,location);
    }

    @PostMapping(path = "add_status/")
    public FlightStatus addStatus(@RequestBody FlightStatus flightStatus) {
        return adminService.addStatus(flightStatus);
    }

    @PutMapping(path = "update_status/")
    public FlightStatus UpdateStatus(@RequestParam(required = true) Integer id,
                                   @RequestBody(required = true) FlightStatus flightStatus){
        return adminService.UpdateStatus(id,flightStatus);
    }


    @GetMapping(path = "get_Flights/")
    public List<Flight> getValue() {
        return adminService.getFlight();
    }

    @GetMapping(path = "get_Flight/{id}")
    public Flight getValueById(@PathVariable Integer id) {
        return adminService.getFlightById(id);
    }


    @GetMapping("search_flights/")
    public ResponseEntity<List<Flight>> searchFlight(@RequestParam("departureLocation") String departure, @RequestParam("arrivalLocation") String arrival){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/search_flights/").toUriString());
        return ResponseEntity.created(uri).body(adminService.searchFlight(departure,arrival));
    }

//    @PostMapping(path = "search_flights/")
//    public List<Flight> searchFlight(@RequestParam(required = true) String departureLocation,
//                                     @RequestParam(required = true) String arrivalLocation){
//        return adminService.searchFlight(departureLocation,arrivalLocation);
//    }

    @PostMapping(path = "advanced_search/")
    public Flight advancedSearch(@RequestParam(required = true) String searchParameter,
                                 @RequestParam(required = true) String searchValue) throws ParseException {
        return  adminService.advancedSearch(searchParameter,searchValue);
    }

}
