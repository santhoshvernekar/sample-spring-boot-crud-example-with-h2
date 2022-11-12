package com.spring.crud.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crud.demo.controller.StudentController;
import com.spring.crud.demo.model.Student;
import com.spring.crud.demo.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest(classes = StudentControllerTest.class, webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)  - Doesn't Work
public class StudentControllerTest {
    @Mock
    StudentService studentService;

    private MockMvc resource;
    private final ObjectMapper mapper = new ObjectMapper();
    private static  final Logger log = LoggerFactory.getLogger(StudentControllerTest.class);

    @Before
    public void setup() {
        StudentController studentController = new StudentController(studentService);
        resource = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void should_get_Students_List() throws Exception {
        String target = "/students";
        resource.perform(get(target)).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void should_get_SayHi() throws Exception {
        String target = "/students/say";
        resource.perform(get(target)).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void should_get_Student_ByRollNo() throws Exception {
        String target = "/students/1";
        resource.perform(get(target)).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void should_get_Student_ById() throws Exception {
        String target = "/students";
        resource.perform(get(target).param("rollNo", "1")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void should_get_StudentList_ByFirstName() throws Exception {
        String target = "/students/all/first-names/Santhosh";
        MvcResult result = resource.perform(get(target)).andExpect(status().is2xxSuccessful())
                .andReturn();
        log.info("The Output is : {}", result);
    }

    @Test
    public void should_get_Student_ByFirstName() throws Exception {
        String target = "/students/one/first-names/Santhosh";
        MvcResult result = resource.perform(get(target)).andExpect(status().is2xxSuccessful())
                .andReturn();
        log.info("The Output is : {}", result);
    }

    @Test
    public void should_get_Student_ByLastName() throws Exception {
        String target = "/students/one/last-names/Vernekar";
        MvcResult result = resource.perform(get(target)).andExpect(status().is2xxSuccessful())
                .andReturn();
        log.info("The Output is : {}", result);
    }

    @Test
    public void should_get_Student_ByMarks() throws Exception {
        String target = "/students/all/marks/700";
        MvcResult result = resource.perform(get(target)).andExpect(status().is2xxSuccessful())
                .andReturn();
        log.info("The Output is : {}", result);
    }
    @Test
    public void should_get_Student_ByConditions() throws Exception {
        String target = "/students//all/conditions/";
        Student student = new Student(100, "San", "Mv", 20);
        MvcResult result = resource.perform(post(target).content(mapper.writeValueAsBytes(student)).
                contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().is2xxSuccessful()).andDo(print())
                .andReturn();
        log.info("The Output is : {}", result);
    }

}
