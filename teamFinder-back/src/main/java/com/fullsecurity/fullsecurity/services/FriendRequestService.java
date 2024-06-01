package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.dto.FriendRequestDto;

import java.util.List;

public interface FriendRequestService {
    void addFriendRequest(Long userId);

    void acceptOrRejectFriendRequest(Boolean status, Long requestId);

    List<FriendRequestDto> getAllRequests();
}
