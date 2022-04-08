package com.example.FlightTicketBookingSystem.User.Repository;

import com.example.FlightTicketBookingSystem.User.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
