package com.fullsecurity.fullsecurity.models;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.Date;


@Entity(name = "refreshtoken")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;
}
