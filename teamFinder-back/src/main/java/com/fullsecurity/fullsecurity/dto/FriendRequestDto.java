package com.fullsecurity.fullsecurity.dto;

import com.fullsecurity.fullsecurity.models.UserProfile;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FriendRequestDto {
    private Long id;

    private Boolean status;

    private Boolean isAccepted;

    private UserProfile sender;

    private UserProfile receiver;

    private LocalDateTime timestamp;
}
