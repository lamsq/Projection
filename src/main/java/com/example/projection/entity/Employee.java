package com.example.projection.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String fName;

    @Column(nullable=false)
    private String lName;

    @Column(nullable=false)
    private String pos;

    @Column(nullable=false)
    private Double sal;

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department dep;
}
