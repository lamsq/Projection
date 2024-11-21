package com.example.projection.repository;

import com.example.projection.entity.Employee;
import com.example.projection.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("""
        select fName || ' ' || lName as fullName, pos AS position,
        dep.name AS departmentName from Employee
    """)
    List<EmployeeProjection> findAllProjected();
}
