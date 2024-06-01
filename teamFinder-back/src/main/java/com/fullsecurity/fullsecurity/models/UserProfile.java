package com.fullsecurity.fullsecurity.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fullsecurity.fullsecurity.models.enumeration.TimeAvailability;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private Long loggedInUser;

    //    @OneToMany(mappedBy = "receiver")
//    private List<ViewerNotification> receivedNotifications;
//
//    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<FriendRequest> sentFriendRequests = new HashSet<>();
//
//    @OneToMany(mappedBy = "friend")
//    private List<FriendsList> friendsLists;

    @Override
    public String toString() {
        return String.format("UserProfile{id=%d, name='%s', email='%s', skills=[%s]}",
                id, name, email, skills.stream().map(Skills::getName).collect(Collectors.joining(", ")));
    }

}
