# Group4
Project from Group4 | CapG



spring.datasource.url : It represents the exact location of your database. It contains three things SQL driver name, database server URL, and database name. So in our case.
sql driver name: jdbc:postgresql
database server URL: localhost:5432
database name: postgres
So, in short, we are giving the instruction to spring boot to connect with the PostgreSQL database whose name is postgres.

 spring.datasource.username: Here you have to mention the username to access the database.

 spring.datasource.password: Mention the password for database.

spring.jpa.show-sql=true: This will show all the queries which Hibernate executed or run in the log output.

spring.jpa.properties.hibernate.dialect: It helps hibernate to generate the SQL properly for the mentioned database.

spring.jpa.hibernate.ddl-auto = update. It means whenever you start the server Hibernate can only able to update at that point in time. We can also assign value to create. It means every time it will create the table when the server start, we really not recommended for production-based application.

@Entity: It represents the Entity class in Spring Boot. If any class tagged with Entity annotation then it representing or mapped with some table present in the database.

@Table: It indicates which table of the database is mapped with Entity class, in our case employee table is mapped with EmployeeEntity class.

@Id: This annotation tagged with that variable or parameter which used to represent the primary key column in the database table, in our case employeeId representing the primary key.

@Column: The parameter or variable tagged with Column annotation to represent the table column.

JpaRepository<EmployeeEntity, Integer>: In the angular bracket <> we have to mention the entity class name and the data type of the primary key. Since in our case, the Entity class name is EmployeeEntity and the primary key is employeeId having of Integer type.

@Repository: This annotation indicates that the class or interface is completely dedicated to performing all sorts of CRUD Operations such as Create, update, read, or delete the data from the database.

@PathVariable: It is used to take the value from URL and assigned or mapped to the class variable or parameter. In our case, we are taking id from /get-employee/{id} and assigned to the employeeId.


POST: http://localhost:8080/api/employee/create-employees

{
    "employeeId":34,
    "name":"John",
    "location":"USA",
    "emailId":"abcbhghg@gmail.com"
}



GET: http://localhost:8080/api/employee/get-all-employees
	http://localhost:8080/api/employee/get-employee/{id}


PUT: http://localhost:8080/api/employee/update-employees/{id}

DELETE: http://localhost:8080/api/employee//delete-employees/{id}
