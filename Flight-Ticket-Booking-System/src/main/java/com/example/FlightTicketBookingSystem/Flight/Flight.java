package com.example.FlightTicketBookingSystem.Flight;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String departureLocation;
    private String arrivalLocation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fleet_ID")
    private Fleet fleet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private FlightStatus status;
    private Date departureTime;
    private Date arrivalTime;

    @OneToOne
    @JoinColumn(name = "fare_id")
    private Fare fare;

    public FlightStatus getStatus() {
        return status;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public Flight() {
    }

    public Flight(String departureLocation, String arrivalLocation, Fleet fleet, FlightStatus status, Date departureTime, Date arrivalTime, Fare fare) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.fleet = fleet;
        this.status = status;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fare = fare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }
}