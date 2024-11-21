package com.example.projection.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EntityTest {

    @Test
    void testDepartmentEntity() {
        Department d = new Department();
        d.setId(1L);
        d.setName("IT");

        assertThat(d.getId()).isEqualTo(1L);
        assertThat(d.getName()).isEqualTo("IT");
    }

    @Test
    void testEmployeeEntity() {
        Employee e = new Employee();
        e.setId(1L);
        e.setFName("Test");
        e.setLName("Test");
        e.setPos("Dev");
        e.setSal(50.00);

        assertThat(e.getId()).isEqualTo(1L);
        assertThat(e.getFName()).isEqualTo("Test");
        assertThat(e.getLName()).isEqualTo("Test");
        assertThat(e.getPos()).isEqualTo("Dev");
        assertThat(e.getSal()).isEqualTo(50.00);
    }
}
