package com.SpringBootDemo.Springboot.tutorial.repository;

import com.SpringBootDemo.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
//here in this we are testing the repo without doing any changes to the database
    //the data in this will no added to the database.
    @Autowired
    private  DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Computer science")
                        .departmentAddress("Delhi")
                        .departmentCode("cs-01")
                        .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Computer science");
    }
}