package ru.aplk.management.tables.positions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.aplk.management.tables.departments.Department;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PositionIsFull {
    private Long id;
    private String name;
    private Department department;
}
