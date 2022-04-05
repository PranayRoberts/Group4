package com.example.FlightTicketBookingSystem.Admin;

import com.example.FlightTicketBookingSystem.Flight.Fare;
import com.example.FlightTicketBookingSystem.Flight.Fleet;
import com.example.FlightTicketBookingSystem.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "admin/")
public class adminController {
    adminService service;

    @Autowired
    public adminController(adminService service) {
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
