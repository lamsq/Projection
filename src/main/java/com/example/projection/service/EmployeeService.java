package com.example.projection.service;

import com.example.projection.entity.Department;
import com.example.projection.entity.Employee;
import com.example.projection.projection.EmployeeProjection;
import com.example.projection.repository.DepartmentRepository;
import com.example.projection.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository er;
    private final DepartmentRepository dr;

    public EmployeeService(EmployeeRepository er, DepartmentRepository dr) {
        this.er = er;
        this.dr = dr;
    }

    public List<Employee> getAllEmployees() {
        return er.findAll();
    }

    public List<EmployeeProjection> getAllEmployeeProjections() {
        return er.findAllProjected();
    }

    public Employee saveEmployee(Employee e) {
        return er.save(e);
    }

    public void deleteEmployee(Long id) {
        er.deleteById(id);
    }

    public Department saveDepartment(Department dep) {
        return dr.save(dep);
    }

    public List<Department> getAllDepartments() {
        return dr.findAll();
    }
}
