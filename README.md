# sample-spring-boot-crud-example-with-h2 example
Demo project for spring-boot-crud operation using JPA with h2 in-memory database

[![Build Status](https://dev.azure.com/santoshmv121/sample-project/_apis/build/status%2Fsanthoshvernekar.sample-spring-boot-crud-example-with-h2?branchName=main)](https://dev.azure.com/santoshmv121/sample-project/_build/latest?definitionId=3&branchName=main)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=san-test&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=san-test)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=san-test&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=san-test)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=san-test&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=san-test)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=san-test&metric=bugs)](https://sonarcloud.io/summary/new_code?id=san-test)
[![Technical Debit](https://sonarcloud.io/api/project_badges/measure?project=san-test&metric=sqale_index)](https://sonarcloud.io/summary?id=san-test)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=san-test&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=san-test)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=san-test&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=san-test)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=san-test&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=san-test)

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=san-test)](https://sonarcloud.io/summary/new_code?id=san-test)
[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/summary/new_code?id=san-test)

This project explains CRUD (**C**reate, **R**ead, **U**pdate, **D**elete) operations using spring boot and H2 in-memory database.
In this app we are using Spring Data JPA for built-in methods to do CRUD operations.     
`@EnableJpaRepositories` annotation is used on main class to Enable H2 DB related configuration, which will read properties from `application.properties` file.

Also, recently added **Spring Reactive programming** support with the help of **Spring Webflux** in this application. All reactive classes/interfaces are added with prefix as `Reactive*`.



## Prerequisites 
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)
- [Jacoco](https://www.eclemma.org/jacoco/)
- [Azure Dev Ops](https://dev.azure.com/)

## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Maven
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)


- Swagger can be launched in Browser: http://localhost:9010/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config 

![image](https://user-images.githubusercontent.com/59571096/201428459-36b454b3-4d7b-42bc-8420-ad81ad80d63d.png)

- H2 Console On Browser: http://localhost:9010/h2-console

![image](https://user-images.githubusercontent.com/59571096/201428389-a9428d53-fefb-4122-9138-16160b105610.png)

- Code Coverage: After building the projects you can find code coverage in the target path :- /sample-spring-boot-crud-example-with-h2/target/site/jacoco/index.html

For Ex: Code Coverage of StudentController looks like this:

![image](https://user-images.githubusercontent.com/59571096/201474585-c6608eec-65ea-433d-8295-1a3608474d86.png)



<br/>


###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/sample-spring-boot-crud-example-with-h2**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-sample-spring-boot-crud-example-with-h2/target/sample-spring-boot-crud-example-with-h2-1.0.0-SNAPSHOT```**

Or
> run main method from `SpringBootH2CRUDApplication.java` as spring boot application.  


||
|  ---------    |
| **_Note_** : In `SpringBootH2CRUDApplication.java` class we have autowired both SportsIcon, Student and Employee repositories. <br/>If there is no record present in DB for any one of that module class (SportsIcon, Student and Employee), static data is getting inserted in DB from `UtilityHelper.java` class when we are starting the app for the first time.| 



### Code Snippets
1. #### Maven Dependencies
    Need to add below dependencies to enable H2 DB related config in **pom.xml**. Lombok's dependency is to get rid of boiler-plate code.   
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
   
    <!-- update -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>
   
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
   
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```
   
   Added Reactive spring support with below dependencies in this application.
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>
   
    <dependency>
        <groupId>io.projectreactor</groupId>
        <artifactId>reactor-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```
    
   
   
2. #### Properties file
    Reading H2 DB related properties from **application.properties** file and configuring JPA connection factory for H2 database.  

    **src/main/resources/application.properties**
     ```
     server.port=9010
    
     spring.datasource.url=jdbc:h2:mem:sampledb
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=password
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    
     spring.h2.console.enabled=true
    
     #spring.data.rest.base-path=/phone
     spring.data.rest.base-default-page-size=10
     spring.data.rest.base-max-page-size=20
    
     springdoc.version=1.0.0
     springdoc.swagger-ui.path=/swagger-ui-custom.html 
     ```

Swagger can be launched in Browser: http://localhost:9010/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config   

H2 Console On Browser: http://localhost:9010/h2-console

3. #### Jacoco Configuration
    Jacoco plugin is used for getting Code coverage Report, Offcial Documentation [Jacoco](https://www.eclemma.org/jacoco/)  

    **pom.xml**
     ```
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.5</version>
                <configuration>
                    <rules>
                        <rule implementation="org.jacoco.maven.RuleConfiguration">
                            <element>BUNDLE</element>
                            <limits>
                                <limit implementation="org.jacoco.report.check.Limit">
                                    <counter>INSTRUCTION</counter>
                                    <value>COVEREDRATION</value>
                                    <minimun>0.80</minimun>

                                </limit>
                            </limits>
                        </rule>
                    </rules>
                </configuration>
                <executions>
                    <execution>
                        <id>default-prepare-agent</id>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>default-report</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
     ```


   
4. #### Model class
    Below are the model classes which we will store in H2 DB and perform CRUD operations.  
    **SportsIcon.java**  
    ```
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Entity
    @Table
    public class SportsIcon implements Serializable {
    
        @Id
        @GeneratedValue
        private int id;
    
        private String name;
        private String specialName;
        private String profession;
        private int age;
        private boolean olampian;
    
        // Constructor, Getter and Setter
    }
    ```
   
    **Student.java**
    ```
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Entity
    @Table
    public class Student implements Serializable {
    
    	@Id
    	@GeneratedValue
    	private int id;
    
    	private int rollNo;
    	private String firstName;
    	private String lastName;
    	private float marks;
    	
    }
    ```
    
    **Employee.java**  
    
    ```
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table
    public class Employee implements Serializable {
    
        @Id
        @GeneratedValue
        private int id;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        private int age;
    
        @Column(name = "no_of_childrens")
        private int noOfChildrens;
        private boolean spouse;
    
        @JsonManagedReference
        @OneToOne(cascade = { 
                     CascadeType.MERGE,
                     CascadeType.PERSIST,
                     CascadeType.REMOVE
        })
        @JoinColumn(name="address")
        private Address address;
    
    
        @JsonManagedReference
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", 
            cascade = { 
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
        })
        private List<PhoneNumber> phoneNumbers;
    
    
    
        @ElementCollection
        @CollectionTable(name="hobbies", joinColumns=@JoinColumn(name="id"))
        @Column(name="hobby")
        private List<String> hobbies = new ArrayList<>();
    
    }
    ```
   
    **Address.java**
    
    ```
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table
    public class Address implements Serializable {
    
        @Id
        @GeneratedValue
        private int id;
    
        @Column(name = "street_address")
        private String streetAddress;
        private String city;
        private String state;
        private String country;
    
        @Column(name = "postal_address")
        private String postalCode;
    
        @JsonBackReference
        @OneToOne(mappedBy="address", 
                cascade = { 
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REMOVE
                })
        private Employee employee;
    }
    ```
   
    **PhoneNumber.java**
    
    ```
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table
    public class PhoneNumber implements Serializable {
    
        @Id
        @GeneratedValue
        private int id;
        private String type;
        private String number;
    
    
        @JsonBackReference
        @ManyToOne(cascade= { CascadeType.ALL})
        @JoinColumn(name="employee_id")
        private Employee employee;
    
    }
    ```
 
    #    
    #### **Update**: New annotations are added in this application to print log smartly with the help of Aspect (LoggerAspect class from aop package).
    **@LogObjectBefore** - annotation created to print log before method execution <br/>
    **@LogObjectAfter** - annotation created to print the returned value from method
    #   
   
   
5. #### CRUD operation for Sports Icon

    In **SportsIconController.java** class, 
    we have exposed 5 endpoints for basic CRUD operations
    - GET All Sports Manes
    - GET by ID
    - POST to store Sports Icon in DB
    - PUT to update Sports Icon
    - DELETE by ID
    
    ```
    @RestController
    @RequestMapping("/sports-icons")
    public class SportsIconController {
        
        @LogObjectAfter
        @GetMapping
        public ResponseEntity<SportsIconList> findAll();
    
        @LogObjectAfter
        @GetMapping("/{id}")
        public ResponseEntity<SportsIcon> findById(@PathVariable String id);
    
        @LogObjectBefore
        @LogObjectAfter
        @PostMapping
        public ResponseEntity<SportsIcon> save(@RequestBody SportsIcon sportsIcon);
    
        @LogObjectBefore
        @LogObjectAfter
        @PutMapping("/{id}")
        public ResponseEntity<SportsIcon> update(@PathVariable int id, @RequestBody SportsIcon sportsIcon);
    
        @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable String id);
    }
    ```
   
   In **SportsIconServiceImpl.java**, we are autowiring above interface using `@Autowired` annotation and doing CRUD operation.
    
    <br/>
    <br/>
    
    In **ReactiveSportsIconController.java** class, 
    we have exposed 5 endpoints for basic CRUD operations with spring reactive feature
    - GET All Sports Manes
    - GET by ID
    - POST to store Sports Icon in DB
    - PUT to update Sports Icon
    - DELETE by ID
       
    ```
    @RestController
    @RequestMapping("/reactive/sports-icon")
    public class ReactiveSportsIconController {
           
        @GetMapping(path = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
        public ResponseEntity<Flux<?>> findAll();
       
        @GetMapping("/{id}")
        public ResponseEntity<SportsIcon> findById(@PathVariable String id);
       
        @PostMapping
        public ResponseEntity<SportsIcon> save(@RequestBody SportsIcon sportsIcon);
       
        @PutMapping("/{id}")
        public ResponseEntity<SportsIcon> update(@PathVariable int id, @RequestBody SportsIcon sportsIcon);
       
        @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable String id);
    }
    ```



   
    In **SportsIconRepository.java**, we are extending `JpaRepository<Class, ID>` interface which enables CRUD related methods.
    
   ```
   public interface SportsIconRepository extends JpaRepository<SportsIcon, String> {
   }
   ```
    
   

   In **EmployeeController.java** class, 
   we have exposed 5 endpoints for basic CRUD operations
   - GET All Employee
   - GET by ID
   - POST to store Employee in DB
   - PUT to update Employee
   - DELETE by ID
    
   ```
   @RestController
   @RequestMapping("/employees")
   public class EmployeeController {
        
       @LogObjectAfter
       @GetMapping
       public ResponseEntity<EmployeeList> findAll();
    
       @LogObjectAfter
       @GetMapping("/{id}")
       public ResponseEntity<Employee> findById(@PathVariable int id);
    
       @LogObjectBefore
       @LogObjectAfter
       @PostMapping
       public ResponseEntity<Employee> save(@RequestBody Employee employee);
    
       @LogObjectBefore
       @LogObjectAfter
       @PutMapping("/{id}")
       public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee);
    
       @DeleteMapping("/{id}")
       public ResponseEntity<String> delete(@PathVariable int id);
   }
   ```
   
   In **EmployeeRepository.java**, we are extending `JpaRepository<Class, ID>` interface which enables CRUD related methods.  
    
   ```
   public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   }
   ```
   
   In **SportsIconServiceImpl.java**, we are autowiring above interface using `@Autowired` annotation and doing CRUD operation.






6. #### JPA And Query operation for Employee
    In **StudentController.java** class JPA related operations.
    
 
 
    
### API Endpoints

- #### Sports Man CRUD Operations
    > **GET Mapping** http://localhost:9010/sports-icon  - Get all Sports Manes
    
    > **GET Mapping** http://localhost:9010/sports-icon/1  - Get Sports Man by ID
       
    > **POST Mapping** http://localhost:9010/sports-icon  - Add new Sports Man in DB  
    
     Request Body  
     ```
        {
            "name": "Kohli",
            "specialName": "King Kohli",
            "profession": "Cricket",
            "age": 33,
            "olampian": false
        }
     ```
    
    > **PUT Mapping** http://localhost:9010/sports-icon/3  - Update existing Sports Man for given ID 
                                                       
     Request Body  
     ```
        {
            "id": "3"
            "name": "Kohli",
            "specialName": "King Kohli",
            "profession": "Cricket",
            "age": 33,
            "olampian": false
        }
     ```
    
    > **DELETE Mapping** http://localhost:9010/sports-icon/4  - Delete Sports Man by ID

- #### Reactive Sports Man CRUD Operations
    > ###### **GET Mapping** http://localhost:9010/reactive/sports-icon  - Get all Sports Manes 
    
     ## **(Try above endpoint in Chrome to see magic, Postman currently not supporting reactive programming)**
    
    > **GET Mapping** http://localhost:9010/reactive/sports-icons/1  - Get Sports Icon by ID
       
    > **POST Mapping** http://localhost:9010/reactive/sports-icons - Add new Sports Icon in DB  
    
     Request Body  
     ```
        {
             "name": "Kohli",
             "specialName": "King Kohli",
             "profession": "Cricket",
             "age": 33,
             "olampian": false
        }
     ```
    
    > **PUT Mapping** http://localhost:9010/reactive/sports-icons/3  - Update existing Sports Man for given ID 
                                                       
     Request Body  
     ```
        {
            "id": "3"
            "name": "Kohli",
            "specialName": "King Kohli",
            "profession": "Cricket",
            "age": 33,
            "olampian": false
        }
     ```
    
    > **DELETE Mapping** http://localhost:9010/reactive/sports-icons/4  - Delete Sports Man by ID


- #### Student Get Operations using JPA
    > **GET Mapping** http://localhost:9010/students  - Get all Employees 
    
    > **GET Mapping** http://localhost:9010/students/2  - Get Student by ID
    

                                                           
    Request Body  
    ```
    {
        "rollNo": 20,
        "firstName": "Santhosh",
        "lastName": "M V",
        "marks": 1000
    }
    ``` 

