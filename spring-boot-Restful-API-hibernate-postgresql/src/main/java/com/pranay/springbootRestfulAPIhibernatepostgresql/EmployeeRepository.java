package com.pranay.springbootRestfulAPIhibernatepostgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository //This annotation indicates that the class or interface is completely dedicated to performing all sorts of CRUD Operations such as Create, update, read, or delete the data from the database.
   public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
    		//In the angular bracket <> we have to mention the entity class name and the data type of the primary key. 
    	 //Since in our case, the Entity class name is EmployeeEntity and the primary key is employeeId having of Integer type.
	}
