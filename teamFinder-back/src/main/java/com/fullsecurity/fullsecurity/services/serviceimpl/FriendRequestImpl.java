package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.dto.FriendRequestDto;
import com.fullsecurity.fullsecurity.dto.mapper.FriendRequestMapper;
import com.fullsecurity.fullsecurity.models.FriendRequest;
import com.fullsecurity.fullsecurity.models.FriendsList;
import com.fullsecurity.fullsecurity.models.UserProfile;
import com.fullsecurity.fullsecurity.repository.FriendRequestRepository;
import com.fullsecurity.fullsecurity.repository.FriendsListRepository;
import com.fullsecurity.fullsecurity.repository.UserProfileRepository;
import com.fullsecurity.fullsecurity.security.services.UserDetailsImpl;
import com.fullsecurity.fullsecurity.services.FriendRequestService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class FriendRequestImpl implements FriendRequestService {

    private final FriendRequestRepository friendRequestRepository;

    private final UserProfileRepository userProfileRepository;

    private final FriendRequestMapper friendRequestMapper;

    private final FriendsListRepository friendsListRepository;

    public FriendRequestImpl(FriendRequestRepository friendRequestRepository, UserProfileRepository userProfileRepository, FriendRequestMapper friendRequestMapper, FriendsListRepository friendsListRepository) {
        this.friendRequestRepository = friendRequestRepository;
        this.userProfileRepository = userProfileRepository;
        this.friendRequestMapper = friendRequestMapper;
        this.friendsListRepository = friendsListRepository;
    }

    @Override
    public void addFriendRequest(Long userId) {
        UserProfile receiverProfile = this.userProfileRepository.findById(userId).get();
        UserProfile senderProfile = this.userProfileRepository.findUserProfileByLoggedInUser(UserDetailsImpl.getCurrentId());
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setStatus(true);
        friendRequest.setSender(senderProfile);
        friendRequest.setIsAccepted(null);
        friendRequest.setReceiver(receiverProfile);
        friendRequest.setTimestamp(LocalDateTime.now());
        this.friendRequestRepository.save(friendRequest);

    }

    @Override
    public void acceptOrRejectFriendRequest(Boolean status, Long requestId) {
        FriendRequest friendRequest = friendRequestRepository.findById(requestId).get();
        friendRequest.setIsAccepted(status);
        friendRequestRepository.save(friendRequest);
        if (status) {
//             reciever
            FriendsList friendsList = new FriendsList();
            friendsList.setLoggedInUser(UserDetailsImpl.getCurrentId());
            friendsList.setFriend(friendRequest.getSender());

            //            sender
            FriendsList senderList = new FriendsList();
            senderList.setLoggedInUser(friendRequest.getSender().getLoggedInUser());
            senderList.setFriend(friendRequest.getReceiver());

            friendsListRepository.save(friendsList);
            friendsListRepository.save(senderList);
        }

    }

    @Override
    public List<FriendRequestDto> getAllRequests() {
        UserProfile userProfile = this.userProfileRepository.findUserProfileByLoggedInUser(UserDetailsImpl.getCurrentId());
        List<FriendRequest> friendRequests = this.friendRequestRepository.findAllByIsAcceptedAndReceiverId(null, userProfile.getId());
        return this.friendRequestMapper.toDto(friendRequests);
    }
}
