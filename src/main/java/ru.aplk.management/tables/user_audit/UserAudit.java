package ru.aplk.management.tables.user_audit;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "user_audit")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UserAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String name;
    public Long user_id;
    private String email;
    private String firstname;
    private String lastname;
    private Long position_id;
    private Timestamp change_time;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getUser_id() {
        return user_id;
    }
}


