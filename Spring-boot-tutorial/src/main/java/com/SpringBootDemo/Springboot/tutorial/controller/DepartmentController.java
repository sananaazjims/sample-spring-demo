package com.SpringBootDemo.Springboot.tutorial.controller;

import com.SpringBootDemo.Springboot.tutorial.entity.Department;
import com.SpringBootDemo.Springboot.tutorial.error.DepartmentNotFoundException;
import com.SpringBootDemo.Springboot.tutorial.service.DepartmentService;
import com.SpringBootDemo.Springboot.tutorial.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //to add logger
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    //to save the department we need
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("inside the saveDepartment of DepartmentController");
       return departmentService.saveDepartment(department);
    }
    //here we are creating a method that it will allow to get all the database

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }
    //Fetching data by ID
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
    //DELETING DATA
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "department deleted successfully!!";
    }
    //update function

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){

        return departmentService.updateDepartment(departmentId, department);
    }
    //FETCH DATA BY NAME
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return  departmentService.fetchDepartmentByName(departmentName);
    }
}
