package com.example.projection.service;

import com.example.projection.entity.*;
import com.example.projection.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository er;

    @Mock
    private DepartmentRepository dr;

    @InjectMocks
    private EmployeeService es;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee e = new Employee();
        e.setFName("Test");
        when(er.findAll()).thenReturn(List.of(e));

        List<Employee> employees = es.getAllEmployees();
        assertThat(employees).hasSize(1);
        assertThat(employees.get(0).getFName()).isEqualTo("Test");
        verify(er, times(1)).findAll();
    }

    @Test
    void testSaveDepartment() {
        Department d = new Department();
        d.setName("IT");
        when(dr.save(d)).thenReturn(d);

        Department saved = es.saveDepartment(d);
        assertThat(saved.getName()).isEqualTo("IT");
        verify(dr, times(1)).save(d);
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(er).deleteById(1L);
        es.deleteEmployee(1L);
        verify(er, times(1)).deleteById(1L);
    }
}
