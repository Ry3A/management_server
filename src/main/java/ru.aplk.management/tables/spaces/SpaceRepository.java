package ru.aplk.management.tables.spaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {
    Optional<Space> findByName(String name);
}
