package com.example.FlightTicketBookingSystem.Flight.Model;


import javax.persistence.*;

@Entity
@Table(name = "flight_status")
public class FlightStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer remainingEconomySeats;
    private Integer remainingPremiumSeats;
    private Integer remainingBusinessSeats;

    public FlightStatus() {

    }

    public FlightStatus(Integer remainingEconomySeats, Integer remainingPremiumSeats, Integer remainingBusinessSeats) {
        this.remainingEconomySeats = remainingEconomySeats;
        this.remainingPremiumSeats = remainingPremiumSeats;
        this.remainingBusinessSeats = remainingBusinessSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRemainingEconomySeats() {
        return remainingEconomySeats;
    }

    public void setRemainingEconomySeats(Integer remainingEconomySeats) {
        this.remainingEconomySeats = remainingEconomySeats;
    }

    public Integer getRemainingPremiumSeats() {
        return remainingPremiumSeats;
    }

    public void setRemainingPremiumSeats(Integer remainingPremiumSeats) {
        this.remainingPremiumSeats = remainingPremiumSeats;
    }

    public Integer getRemainingBusinessSeats() {
        return remainingBusinessSeats;
    }

    public void setRemainingBusinessSeats(Integer remainingBusinessSeats) {
        this.remainingBusinessSeats = remainingBusinessSeats;
    }
}
