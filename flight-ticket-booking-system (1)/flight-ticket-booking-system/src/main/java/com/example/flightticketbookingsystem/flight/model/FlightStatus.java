package com.example.flightticketbookingsystem.flight.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FlightStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double remainingEconomySeats;
    private Double remainingPremiumSeats;
    private Double remainingBusinessSeats;

    public FlightStatus(Double remainingEconomySeats, Double remainingPremiumSeats, Double remainingBusinessSeats) {
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

    public Double getRemainingEconomySeats() {
        return remainingEconomySeats;
    }

    public void setRemainingEconomySeats(Double remainingEconomySeats) {
        this.remainingEconomySeats = remainingEconomySeats;
    }

    public Double getRemainingPremiumSeats() {
        return remainingPremiumSeats;
    }

    public void setRemainingPremiumSeats(Double remainingPremiumSeats) {
        this.remainingPremiumSeats = remainingPremiumSeats;
    }

    public Double getRemainingBusinessSeats() {
        return remainingBusinessSeats;
    }

    public void setRemainingBusinessSeats(Double remainingBusinessSeats) {
        this.remainingBusinessSeats = remainingBusinessSeats;
    }
}
