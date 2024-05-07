package ru.aplk.management.tables.positions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "position")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int salary;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    @Column(name = "department_id")
    private Long departmentId;
}
