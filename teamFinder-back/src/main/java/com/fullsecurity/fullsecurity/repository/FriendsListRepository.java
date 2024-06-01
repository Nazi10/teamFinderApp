package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.FriendsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsListRepository extends JpaRepository<FriendsList, Long> {
    FriendsList findByFriendIdAndLoggedInUser(Long friendId, Long loggedInUser);

    List<FriendsList> findAllByLoggedInUser(Long id);
}
