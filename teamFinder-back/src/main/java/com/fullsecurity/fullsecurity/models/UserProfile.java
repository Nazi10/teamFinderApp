package com.fullsecurity.fullsecurity.models;

import com.fullsecurity.fullsecurity.models.enumeration.TimeAvailability;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_profile")
@SQLRestriction("status = true")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean status;

    private Boolean isProfileCompleted;

    private String name;

    private String lastName;

    private LocalDate birthday;

    private String phoneNumber;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @ManyToMany
    @JoinTable(name = "user_profile_skills",
            joinColumns = @JoinColumn(name = "user_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id"))
    private List<Skills> skills;

    @Enumerated(EnumType.STRING)
    private TimeAvailability timeAvailability;

    // id e userit te loguar
    private Long userId;

    @OneToMany(mappedBy = "receiver")
    private List<ViewerNotification> receivedNotifications;

    @OneToMany(mappedBy = "receiver")
    private List<FriendRequest> friendRequests;

    @OneToMany(mappedBy = "friend")
    private List<FriendsList> friendsLists;

}
