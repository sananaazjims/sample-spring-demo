package com.SpringBootDemo.Springboot.tutorial.service;

import com.SpringBootDemo.Springboot.tutorial.entity.Department;
import com.SpringBootDemo.Springboot.tutorial.repository.DepartmentRepository;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department =
                Department.builder()
                        .departmentName("stats-3")
                        .departmentAddress("hyderabad")
                        .departmentCode("stats-03")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("stats-3"))
                .thenReturn(department);

    }

    //in this we are calling the name of the department and the particular method
    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){

        String departmentName = "stats-3";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}