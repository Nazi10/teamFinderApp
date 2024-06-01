package com.fullsecurity.fullsecurity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "job_position")
@SQLRestriction("status = true")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Boolean status;

    @ManyToMany
    @JoinTable(name = "job_position_skills",
            joinColumns = @JoinColumn(name = "job_position_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id"))
    private List<Skills> skills;

    private LocalDate postedDate;

    @ManyToOne
    private Startup startup;
}
