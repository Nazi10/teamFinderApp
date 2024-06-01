package com.fullsecurity.fullsecurity.dto;

import com.fullsecurity.fullsecurity.models.FriendRequest;
import com.fullsecurity.fullsecurity.models.FriendsList;
import com.fullsecurity.fullsecurity.models.Skills;
import com.fullsecurity.fullsecurity.models.ViewerNotification;
import com.fullsecurity.fullsecurity.models.enumeration.TimeAvailability;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserProfileDto {

    private Long id;

    private Boolean status;

    private Boolean isProfileCompleted;

    private String name;

    private String lastName;

    private LocalDate birthday;

    private String phoneNumber;

    private String email;

    private List<SkillsDto> skills;

    private TimeAvailability timeAvailability;

    // id e userit te loguar
    private Long loggedInUser;

//
//    private List<ViewerNotification> receivedNotifications;
//
//    private List<FriendRequestDto> friendRequests;
//
//    private List<FriendsList> friendsLists;
}
