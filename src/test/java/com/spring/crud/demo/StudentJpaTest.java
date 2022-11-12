package com.spring.crud.demo;

import com.spring.crud.demo.model.Student;
import com.spring.crud.demo.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class StudentJpaTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindByFirstNameMethod_usingEntityManager() {
        Student student = new Student(100, "San", "Mv", 20);
        entityManager.persist(student);
        Student assertStudent = studentRepository.findByFirstName("San");
        assertThat(assertStudent).isEqualTo(student);
    }

    @Test
    public void testFindAllMethod() {
        Student student = new Student(100, "San", "Mv", 20);
         studentRepository.save(student);
        List<Student> assertStudent = studentRepository.findAll();
        assertThat(assertStudent.isEmpty()).isEqualTo(false);
        assertThat(assertStudent.get(assertStudent.size()-1)).isEqualTo(student);

    }
}
