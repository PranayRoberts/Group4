package com.example.FlightTicketBookingSystem.Admin.Controller;

import com.example.FlightTicketBookingSystem.Admin.Services.AdminService;
import com.example.FlightTicketBookingSystem.Flight.Fare;
import com.example.FlightTicketBookingSystem.Flight.Fleet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "admin/")
public class AdminController {
    AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping(path = "register_fleet/")
    public Fleet registerfleet(@RequestBody Fleet fleet) {
        return service.registerFleet(fleet);
    }

    @PutMapping(path = "update_fleet/")
    public Fleet updatefleet(@RequestParam(required = true) Integer id,
                             @RequestBody(required = true) Fleet fleet){
        return service.UpdateFleet(id,fleet);
    }

    @PostMapping(path = "register_fare/")
    public Fare registerfare(@RequestBody Fare fare) {
        return service.registerFare(fare);
    }

    @PutMapping(path = "update_fare/")
    public Fare updatefare(@RequestParam(required = true) Integer id,
                           @RequestBody(required = true) Fare fare){
        return service.UpdateFare(id,fare);
    }




}
