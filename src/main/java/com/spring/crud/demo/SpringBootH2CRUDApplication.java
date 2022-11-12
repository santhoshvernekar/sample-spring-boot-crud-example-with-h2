package com.spring.crud.demo;

import com.spring.crud.demo.model.SportsIcon;
import com.spring.crud.demo.model.Student;
import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.repository.EmployeeRepository;
import com.spring.crud.demo.repository.SportsIconRepository;
import com.spring.crud.demo.repository.StudentRepository;
import com.spring.crud.demo.utils.UtilityHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootH2CRUDApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2CRUDApplication.class, args);
	}



	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SportsIconRepository sportsIconRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Student> students = studentRepository.findAll();
				if (students.isEmpty()) {
					log.info("******* Inserting Students to DB *******");
					studentRepository.saveAll(UtilityHelper.studentSupplier.get());
				} else {
					log.info("******* Students stored in DB Size :: {}", students.size());
					log.info("******* Students stored in DB :: {}", students);
				}

			List<SportsIcon> sportsMEN = sportsIconRepository.findAll();
			if (sportsMEN.isEmpty()) {
				log.info("******* Inserting Sports Manes to DB *******");
				sportsIconRepository.saveAll(UtilityHelper.sportIconsSupplier.get());
			} else {
				log.info("******* Sports Manes stored in DB Size :: {}", sportsMEN.size());
				log.info("******* Sports Manes stored in DB :: {}", sportsMEN);
			}


			List<Employee> employees = employeeRepository.findAll();
			if (employees.isEmpty()) {
				log.info("******* Inserting Employees to DB *******");
				employeeRepository.saveAll(UtilityHelper.employeeSupplier.get());
			} else {
				log.info("******* Employees stored in DB Size :: {}", employees.size());
				log.info("******* Employees stored in DB :: {}", employees);
			}
		};
	}

}
