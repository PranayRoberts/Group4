package com.example.FlightTicketBookingSystem.Flight.Model;

import javax.persistence.*;

@Entity
@Table(name = "fare")
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double economyFare;
    private Double premiumFare;
    private Double businessFare;

    public Fare() {
    }

    public Fare(Double economyFare, Double premiumFare, Double businessFare) {
        this.economyFare = economyFare;
        this.premiumFare = premiumFare;
        this.businessFare = businessFare;
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
        return businessFare;
    }

    public void setBusinessFare(Double businessFare) {
        this.businessFare = businessFare;
    }
}
