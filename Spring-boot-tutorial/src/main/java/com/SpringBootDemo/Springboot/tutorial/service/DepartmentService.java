package com.SpringBootDemo.Springboot.tutorial.service;

import com.SpringBootDemo.Springboot.tutorial.entity.Department;
import com.SpringBootDemo.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

  public  Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);
}
