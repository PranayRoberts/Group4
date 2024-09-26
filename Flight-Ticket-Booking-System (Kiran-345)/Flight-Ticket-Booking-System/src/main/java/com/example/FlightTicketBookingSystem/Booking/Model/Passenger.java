package com.example.FlightTicketBookingSystem.Booking.Model;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Character gender;
    private String psssportNo;
    private String mealPref;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, Integer age, Character gender, String psssportNo, String mealPref) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.psssportNo = psssportNo;
        this.mealPref = mealPref;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getPsssportNo() {
        return psssportNo;
    }

    public void setPsssportNo(String psssportNo) {
        this.psssportNo = psssportNo;
    }

    public String getMealPref() {
        return mealPref;
    }

    public void setMealPref(String mealPref) {
        this.mealPref = mealPref;
    }
}
