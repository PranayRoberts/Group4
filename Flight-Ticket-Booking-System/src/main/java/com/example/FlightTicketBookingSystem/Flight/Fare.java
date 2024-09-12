package com.example.FlightTicketBookingSystem.Flight;

import javax.persistence.*;

@Entity
@Table(name = "fare")
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double economyFare;
    private Double premiumFare;
    private Double BusinessFare;

    public Fare() {
    }

    public Fare(Double economyFare, Double premiumFare, Double businessFare) {
        this.economyFare = economyFare;
        this.premiumFare = premiumFare;
        BusinessFare = businessFare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getEconomyFare() {
        return economyFare;
    }

    public void setEconomyFare(Double economyFare) {
        this.economyFare = economyFare;
    }

    public Double getPremiumFare() {
        return premiumFare;
    }

    public void setPremiumFare(Double premiumFare) {
        this.premiumFare = premiumFare;
    }

    public Double getBusinessFare() {
        return BusinessFare;
    }

    public void setBusinessFare(Double businessFare) {
        BusinessFare = businessFare;
    }
}
