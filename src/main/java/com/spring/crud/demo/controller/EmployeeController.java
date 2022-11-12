package com.spring.crud.demo.controller;

import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.annotation.LogObjectBefore;
import com.spring.crud.demo.model.EmployeeList;
import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @LogObjectAfter
    @GetMapping
    public ResponseEntity<EmployeeList> findAll() {
        EmployeeList employeeList = new EmployeeList();
        employeeList.items = service.findAll();
        return ResponseEntity.ok().body(employeeList);
    }


    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id) {
        Employee employee = service.findById(id);
        return ResponseEntity.ok().body(employee);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        Employee savedEmployee = service.save(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEmployee);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedEmployee = service.update(id, employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}

