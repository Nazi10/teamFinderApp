package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.models.FriendsList;
import com.fullsecurity.fullsecurity.repository.FriendsListRepository;
import com.fullsecurity.fullsecurity.security.services.UserDetailsImpl;
import com.fullsecurity.fullsecurity.services.FriendListService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FriendListImpl implements FriendListService {

    private final FriendsListRepository friendsListRepository;

    public FriendListImpl(FriendsListRepository friendsListRepository) {
        this.friendsListRepository = friendsListRepository;
    }

    @Override
    public List<FriendsList> friendsList() {
        return this.friendsListRepository.findAllByLoggedInUser(UserDetailsImpl.getCurrentId());
    }
}
