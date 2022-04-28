package com.example.flightticketbookingsystem.flight.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Fleet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String model;
    private Double totalEconomySeats;
    private Double totalPremiumSeats;
    private Double totalBusinessSeats;

    public Fleet(String code, String model, Double totalEconomySeats, Double totalPremiumSeats, Double totalBusinessSeats) {
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

    public Double getTotalEconomySeats() {
        return totalEconomySeats;
    }

    public void setTotalEconomySeats(Double totalEconomySeats) {
        this.totalEconomySeats = totalEconomySeats;
    }

    public Double getTotalPremiumSeats() {
        return totalPremiumSeats;
    }

    public void setTotalPremiumSeats(Double totalPremiumSeats) {
        this.totalPremiumSeats = totalPremiumSeats;
    }

    public Double getTotalBusinessSeats() {
        return totalBusinessSeats;
    }

    public void setTotalBusinessSeats(Double totalBusinessSeats) {
        this.totalBusinessSeats = totalBusinessSeats;
    }
}
