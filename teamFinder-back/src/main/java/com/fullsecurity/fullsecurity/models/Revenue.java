package com.fullsecurity.fullsecurity.models;

import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "revenue")
@SQLRestriction("status = true")
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double revenue;

    @Size(max = 300)
    private String revenueName;

    private LocalDate dateOfRevenue;

    private Boolean status;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "revenueType_id", referencedColumnName = "id")
    private RevenueType revenueType;
}
