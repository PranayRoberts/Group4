package com.example.FlightTicketBookingSystem.Flight.Model.Repository;

import com.example.FlightTicketBookingSystem.Flight.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findAdminByUserName(String userValue);
}
