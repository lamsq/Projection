package com.example.projection.controller;

import com.example.projection.entity.Department;
import com.example.projection.entity.Employee;
import com.example.projection.projection.EmployeeProjection;
import com.example.projection.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RequestMapping("/api")
@RestController
public class EmployeeController {

    private final EmployeeService es;

    public EmployeeController(EmployeeService es) {
        this.es =es;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(es.getAllEmployees());
    }

    @GetMapping("/employees/projections")
    public ResponseEntity<List<EmployeeProjection>> getAllEmployeeProjections() {
        return ResponseEntity.ok(es.getAllEmployeeProjections());
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee e) {
        return ResponseEntity.ok(es.saveEmployee(e));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        es.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department dep) {
        return ResponseEntity.ok(es.saveDepartment(dep));
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(es.getAllDepartments());
    }
}
