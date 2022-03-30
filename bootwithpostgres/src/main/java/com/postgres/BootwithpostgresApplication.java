package com.postgres;

import com.postgres.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BootwithpostgresApplication implements CommandLineRunner {

	@Autowired
	StudentDao studentDao;
	public static void main(String[] args) {

		SpringApplication.run(BootwithpostgresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//this.studentDao.createTable();
	//this.studentDao.insertData("Group",  "4");
		// this.studentDao.deleteTable();
		System.out.println(this.studentDao.getNames());


	}
}
