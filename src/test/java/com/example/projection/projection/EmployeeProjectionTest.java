package com.example.projection.projection;

import com.example.projection.entity.Department;
import com.example.projection.entity.Employee;
import com.example.projection.repository.DepartmentRepository;
import com.example.projection.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeProjectionTest {

    @Autowired
    private EmployeeRepository er;

    @Autowired
    private DepartmentRepository dr;

    @BeforeEach
    void setup() {

        er.deleteAll();
        dr.deleteAll();

        Department it = new Department();
        it.setName("IT");
        Department hr = new Department();
        hr.setName("HR");
        dr.saveAll(List.of(it, hr));

        Employee emp1 = new Employee();
        emp1.setFName("Test");
        emp1.setLName("Test");
        emp1.setPos("Dev");
        emp1.setSal(50.00);
        emp1.setDep(it);

        Employee emp2 = new Employee();
        emp2.setFName("Test");
        emp2.setLName("Rest");
        emp2.setPos("Manager");
        emp2.setSal(45.00);
        emp2.setDep(hr);

        er.saveAll(List.of(emp1, emp2));
    }

    @Test
    void testEmployeeProjections() {

        List<EmployeeProjection> proj = er.findAllProjected();

        assertThat(proj).hasSize(2);

        EmployeeProjection emp1 = proj.get(0);
        assertThat(emp1.getFullName()).isEqualTo("Test Test");
        assertThat(emp1.getPosition()).isEqualTo("Dev");
        assertThat(emp1.getDepartmentName()).isEqualTo("IT");

        EmployeeProjection secondEmployee = proj.get(1);
        assertThat(secondEmployee.getFullName()).isEqualTo("Test Rest");
        assertThat(secondEmployee.getPosition()).isEqualTo("Manager");
        assertThat(secondEmployee.getDepartmentName()).isEqualTo("HR");
    }
}
