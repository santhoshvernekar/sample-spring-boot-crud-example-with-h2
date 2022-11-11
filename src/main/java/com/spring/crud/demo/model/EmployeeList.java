package com.spring.crud.demo.model;

import com.spring.crud.demo.model.emp.Employee;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class EmployeeList {
    public List<Employee> items= new ArrayList<Employee>();
}
