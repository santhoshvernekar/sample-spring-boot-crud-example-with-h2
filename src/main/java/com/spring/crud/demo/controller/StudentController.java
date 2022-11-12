package com.spring.crud.demo.controller;

import com.spring.crud.demo.model.Student;
import com.spring.crud.demo.model.StudentList;
import com.spring.crud.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/say")
    public String sayHello() {
        return "Hello Spring boot";
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{rollNo}")
    public Student getStudentById(@PathVariable int rollNo) {
        return studentService.getStudentById(rollNo);
    }

    @GetMapping("/all/first-names/{firstName}")
    public StudentList getStudentByName(@PathVariable String firstName) {
        StudentList studentList = new StudentList();
        studentList.items = studentService.getStudentByFirstName(firstName);
        return studentList;
    }

    // get Student by first name (equals())
    @GetMapping("/one/first-names/{firstName}")
    public Student getOneStudentByFirstName(@PathVariable String firstName) {
        return studentService.getOneStudentByFirstName(firstName);
    }

    @GetMapping("/one/last-names/{lastName}")
    public Student getStudentBylName(@PathVariable String lastName) {
        return studentService.getStudentByLastName(lastName);
    }


    @GetMapping("/all/marks/{marksGreaterThan}")
    public StudentList getStudentByMarksGreaterThan(@PathVariable int marksGreaterThan) {
        StudentList studentList = new StudentList();
        studentList.items = studentService.getStudentByMarksGreaterThan(marksGreaterThan);
        return studentList;
    }

    @PostMapping("/all/conditions/")
    public StudentList getStudentByCondition(@RequestBody Student student) {
        StudentList studentList = new StudentList();
        studentList.items = studentService.getStudentByCondition(student);
        return studentList;
    }
}




