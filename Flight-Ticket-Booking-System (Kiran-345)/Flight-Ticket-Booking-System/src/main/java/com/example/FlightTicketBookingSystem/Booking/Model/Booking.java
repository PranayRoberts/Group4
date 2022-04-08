package com.example.FlightTicketBookingSystem.Booking.Model;

import com.example.FlightTicketBookingSystem.Flight.Model.Flight;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private long bookingNumber;
    private Date bookingDate;
    private Date travelDate;

    private double totalCost;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "flight_booked")
//    private Flight flightBooked;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_details")
    private Passenger passenger;


    public Booking() {
    }

    public Booking(long bookingNumber, Date bookingDate, Date travelDate, double totalCost, Passenger passenger) {
        this.bookingNumber = bookingNumber;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.totalCost = totalCost;
        this.passenger = passenger;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(long bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
