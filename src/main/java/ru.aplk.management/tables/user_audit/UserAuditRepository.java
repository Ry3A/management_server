package ru.aplk.management.tables.user_audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuditRepository extends JpaRepository<UserAudit, Long> {
    Optional<UserAudit> findByName(String name);
}
