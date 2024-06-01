package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    @Query("SELECT u FROM UserProfile u JOIN FETCH u.skills WHERE u.status = true")
    List<UserProfile> findAllActiveUserProfiles();

    UserProfile findUserProfileByLoggedInUser(Long id);
}
