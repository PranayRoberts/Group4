package com.example.FlightTicketBookingSystem.Flight.Model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fleet")
public class Fleet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String model;
    private Integer totalEconomySeats;
    private Integer totalPremiumSeats;
    private Integer totalBusinessSeats;

    public Fleet() {
    }

    public Fleet(String code, String model, Integer totalEconomySeats, Integer totalPremiumSeats, Integer totalBusinessSeats) {
        this.code = code;
        this.model = model;
        this.totalEconomySeats = totalEconomySeats;
        this.totalPremiumSeats = totalPremiumSeats;
        this.totalBusinessSeats = totalBusinessSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTotalEconomySeats() {
        return totalEconomySeats;
    }

    public void setTotalEconomySeats(Integer totalEconomySeats) {
        this.totalEconomySeats = totalEconomySeats;
    }

    public Integer getTotalPremiumSeats() {
        return totalPremiumSeats;
    }

    public void setTotalPremiumSeats(Integer totalPremiumSeats) {
        this.totalPremiumSeats = totalPremiumSeats;
    }

    public Integer getTotalBusinessSeats() {
        return totalBusinessSeats;
    }

    public void setTotalBusinessSeats(Integer totalBusinessSeats) {
        this.totalBusinessSeats = totalBusinessSeats;
    }
}
