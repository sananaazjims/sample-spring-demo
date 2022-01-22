package com.SpringBootDemo.Springboot.tutorial.repository;

import com.SpringBootDemo.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //we are extending jpa repo here because it gives lots of methods to the entity (here entity is department and we are passing the primary key data type which is long)
    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
