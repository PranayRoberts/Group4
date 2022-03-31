package com.pranay.springbootRestfulAPIhibernatepostgresql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity //It represents the Entity class in Spring Boot. If any class tagged with Entity annotation then it representing or mapped with some table present in the database.
@Table(name = "employees") //It indicates which table of the database is mapped with Entity class, in our case employee table is mapped with EmployeeEntity class.
public class EmployeeEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	    private Integer employeeId;
	    
	    @Column(name = "name", nullable = false)
	    private String name;
	    
	    @Column(name = "location", nullable = false)
	    private String location;
	    
	    @Column(name = "email_address", nullable = false)
	    private String emailId;
	 
	    public EmployeeEntity() {
	  
	    }
	 
	    public EmployeeEntity(String name, String location, String emailId) {
	         this.name = name;
	         this.location = location;
	         this.emailId = emailId;
	    }
	 
	   
	        public Integer getEmployeeId() {
	        return employeeId;
	    }
	    public void setId(Integer employeeId) {
	        this.employeeId = employeeId;
	    }
	 
	   	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	   
	    public String getLocation() {
	        return location;
	    }
	    public void setLocation(String location) {
	        this.location = location;
	    }
	 
	   
	    public String getEmailId() {
	        return emailId;
	    }
	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }

	    @Override
	    public String toString() {
	        return "Employee [employeeId=" + employeeId + ", name=" + name + ", emailId=" + emailId
	       + "]";
	    }
	 
	}
