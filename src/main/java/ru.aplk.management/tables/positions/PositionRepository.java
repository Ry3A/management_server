package ru.aplk.management.tables.positions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> findByName(String title);
    List<Position> findAllByDepartmentId(Long departmentId);
    @Query("" +
            "SELECT p, d " +
            "FROM Position p " +
            "JOIN Position d on p.departmentId = d.id " +
            "WHERE p.name = :title"
    )
    List<Object[]> findByNameWithJoin(@Param("title") String title);
    @Query("" +
            "SELECT p, d " +
            "FROM Position p " +
            "JOIN Position d on p.departmentId = d.id " +
            "WHERE p.id = :id"
    )
    List<Object[]> findByIdWithJoin(@Param("id") Long id);

}
