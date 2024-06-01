package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {

    List<FriendRequest> findAllByIsAcceptedAndReceiverId(Boolean isAccepted, Long receiverId);
}
