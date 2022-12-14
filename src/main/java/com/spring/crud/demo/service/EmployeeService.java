package com.spring.crud.demo.service;

import com.spring.crud.demo.model.emp.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee sportsIcon);

	Employee update(int id, Employee employee);

    void delete(int id);

}
