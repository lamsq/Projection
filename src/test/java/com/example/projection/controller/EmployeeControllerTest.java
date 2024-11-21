package com.example.projection.controller;

import com.example.projection.entity.*;
import com.example.projection.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void testGetAllDepartments() throws Exception {
        Department d = new Department();
        d.setId(1L);
        d.setName("IT");

        when(employeeService.getAllDepartments()).thenReturn(List.of(d));
        mockMvc.perform(get("/api/departments").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("IT"));
    }

    @Test
    void testCreateEmployee() throws Exception {
        Employee e = new Employee();
        e.setId(1L);
        e.setFName("Test");
        e.setLName("Test");
        e.setPos("Dev");

        when(employeeService.saveEmployee(any(Employee.class))).thenReturn(e);
        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {"firstName": "Test",
                            "lastName": "Test",
                            "position": "Dev",
                            "salary": 5000,
                            "department": {"id": 1}}
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Test"))
                .andExpect(jsonPath("$.position").value("Dev"));
    }
}
