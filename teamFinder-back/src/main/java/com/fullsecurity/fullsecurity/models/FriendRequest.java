package com.fullsecurity.fullsecurity.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "friend_request")
@SQLRestriction("status = true")
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean status;

    private Boolean isAccepted;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private UserProfile sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private UserProfile receiver;

    private LocalDateTime timestamp;

}
