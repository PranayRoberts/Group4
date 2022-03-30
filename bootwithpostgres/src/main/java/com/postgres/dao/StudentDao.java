package com.postgres.dao;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
//DAO-data access object , a data access object (DAO) is a pattern that provides an abstract interface to some type of database or other persistence mechanism.
public class StudentDao {
//The @Autowired annotation marks a Constructor, Setter method, Properties and Config() method as to be autowired that is ‘injecting beans'(Objects) at runtime by Spring Dependency Injection mechanism
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Creating the table
    public void createTable(){
        var query="CREATE TABLE student(id SERIAL PRIMARY KEY, name varchar(255) NOT NULL, city VARCHAR(255))";
        int update= this.jdbcTemplate.update(query);
        System.out.println(update);
    }


    //Deleting the table
    public void deleteTable(){
        var query="DROP TABLE student";
        int update= this.jdbcTemplate.update(query);
        System.out.println(update);
    }

    //Insert Data into Database
    public void insertData(String name, String city){
        String q="insert into student(name,city) values(?,?)";
        int update= this.jdbcTemplate.update(q,name,city);
        System.out.println(update+ "rows added");
    }

  //  Selecting Data from the table
    public List<String> getNames() {

        String q = "SELECT name FROM student";
        List<String> students = this.jdbcTemplate.queryForList(q, String.class);

        return students;    }
}
