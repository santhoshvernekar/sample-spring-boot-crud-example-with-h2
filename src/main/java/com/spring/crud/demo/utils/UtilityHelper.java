package com.spring.crud.demo.utils;

import com.spring.crud.demo.model.SportsIcon;
import com.spring.crud.demo.model.Student;
import com.spring.crud.demo.model.emp.Address;
import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.model.emp.PhoneNumber;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class UtilityHelper {

    private UtilityHelper() {
    }

    public static Supplier<List<Student>> studentSupplier = () ->
            Arrays.asList(
		            Student.builder().rollNo(1).firstName("Santhosh").lastName("Vernekar").marks(300.0f).build(),
		            Student.builder().rollNo(2).firstName("Ram").lastName("A").marks(950.0f).build(),
		            Student.builder().rollNo(3).firstName("Raj").lastName("Kumar").marks(500.0f).build(),
		            Student.builder().rollNo(4).firstName("Vishnu").lastName("Vardhan").marks(600.0f).build(),
					Student.builder().rollNo(3).firstName("Rashmika").lastName("S").marks(500.0f).build(),
					Student.builder().rollNo(4).firstName("Aditi").lastName("P").marks(600.0f).build(),
		            Student.builder().rollNo(5).firstName("Salman").lastName("Khan").marks(700.0f).build(),
		            Student.builder().rollNo(6).firstName("Shahrukh").lastName("Khan").marks(800.0f).build(),
		            Student.builder().rollNo(7).firstName("Yash").lastName("Kumar").marks(900.0f).build(),
		            Student.builder().rollNo(8).firstName("Rakshit").lastName("Shetty").marks(800.0f).build(),
		            Student.builder().rollNo(9).firstName("Sudeep").lastName("Kumar").marks(900.0f).build(),
		            Student.builder().rollNo(10).firstName("Rishab").lastName("Shetty").marks(800.0f).build()
            );



    public static Supplier<List<SportsIcon>> sportIconsSupplier = () ->
            Arrays.asList(
                    SportsIcon.builder().name("Virat").specialName("King Kohli").sports("Cricketer").age(33).olampian(false).build(),
					SportsIcon.builder().name("Neeraj").specialName("Chopra").sports("Javelin").age(25).olampian(true).build(),
					SportsIcon.builder().name("Marry").specialName("Kom").sports("Boxing").age(35).olampian(false).build(),
                    SportsIcon.builder().name("Lionel").specialName("Messi").sports("Footballer").age(35).olampian(false).build(),
                    SportsIcon.builder().name("Roger").specialName("Federer").sports("TennisPlayer").age(36).olampian(true).build(),
                    SportsIcon.builder().name("Tiger").specialName("Tiger Woods").sports("Golf").age(40).olampian(true).build(),
                    SportsIcon.builder().name("PV Sindhu").specialName("Queen").sports("Badminton").age(27).olampian(true).build()
            );




	public static Supplier<List<Employee>> employeeSupplier = () -> {

		Employee santhosh = Employee.builder()
				.id(1)
				.firstName("Santhosh")
				.lastName("Vernekar")
				.age(30)
				.noOfChildren(0)
				.spouse(true)
				.address(Address.builder()
						.id(1)
						.streetAddress("WhiteField")
						.city("Bengaluru")
						.state("Karnataka")
						.country("India")
						.postalCode("560010")
						.build()
				)
				.hobbies(Arrays.asList("Travelling", "Sports"))
				.build();

		PhoneNumber santhoshNumber = PhoneNumber.builder()
				.id(1)
				.type("Mobile")
				.number("1234567890")
				.employee(santhosh)
				.build();

		santhosh.setPhoneNumbers(Arrays.asList(santhoshNumber));






		Employee virat = Employee.builder()
				.id(1)
				.firstName("Virat")
				.lastName("Kohli")
				.age(28)
				.noOfChildren(0)
				.spouse(true)
				.address(Address.builder()
						.id(1)
						.streetAddress("Delhi Road")
						.city("Bangalore")
						.state("Karnataka")
						.country("India")
						.postalCode("560010")
						.build()
				)
				.hobbies(Arrays.asList("Dancing", "Cricket"))
				.build();

		PhoneNumber aryansNumber = PhoneNumber.builder()
				.id(1)
				.type("Mobile")
				.number("1234555555")
				.employee(virat)
				.build();

		virat.setPhoneNumbers(Arrays.asList(aryansNumber));


		return Arrays.asList(santhosh, virat);
	};
}
