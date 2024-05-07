package ru.aplk.management.tables.spaces;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "freeSpace")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int footage;
    private int ante;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getFootage(){return footage;}
    public int getAnte(){return ante;}
}
