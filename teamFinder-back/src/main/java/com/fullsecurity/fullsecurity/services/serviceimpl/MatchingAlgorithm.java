package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.models.FriendsList;
import com.fullsecurity.fullsecurity.models.UserProfile;
import com.fullsecurity.fullsecurity.repository.FriendsListRepository;
import com.fullsecurity.fullsecurity.repository.UserProfileRepository;
import com.fullsecurity.fullsecurity.security.services.UserDetailsImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchingAlgorithm {

    private final UserProfileRepository userProfileRepository;

    private final FriendsListRepository friendsListRepository;

    public MatchingAlgorithm(UserProfileRepository userProfileRepository, FriendsListRepository friendsListRepository) {
        this.userProfileRepository = userProfileRepository;
        this.friendsListRepository = friendsListRepository;
    }

    public List<UserProfile> findMatches(Long loggedInUserId, Map<UserProfile, List<String>> userSkillsMap) {
        Map<UserProfile, List<UserProfile>> matches = new HashMap<>();
        UserProfile loggedInUser = userProfileRepository.findUserProfileByLoggedInUser(loggedInUserId); // Assuming you have a method to get the user by ID

        List<String> skills1 = userSkillsMap.get(loggedInUser);
        List<UserProfile> similarUsers = new ArrayList<>();

        for (UserProfile user2 : userSkillsMap.keySet()) {
            if (!loggedInUser.equals(user2)) {
                List<String> skills2 = userSkillsMap.get(user2);
                double similarity = calculateSimilarity(skills1, skills2);
                System.out.printf("Similarity between %s and %s: %.2f%n", loggedInUser, user2, similarity);
                if (similarity > 0.1) {  // Adjusted Threshold for testing
                    similarUsers.add(user2);
                }
            }
        }
//        matches.put(loggedInUser, similarUsers);
        // return similarUsers;
        return this.checkIfIsOnFriendsList(similarUsers);
    }

    public List<UserProfile> checkIfIsOnFriendsList(List<UserProfile> userProfiles) {
        List<UserProfile> responseToSend = new ArrayList<>();
        for(UserProfile userProfile : userProfiles) {
            FriendsList friendsList = friendsListRepository.findByFriendIdAndLoggedInUser(userProfile.getId(), UserDetailsImpl.getCurrentId());
            if(friendsList == null) {
                responseToSend.add(userProfile);
            }
        }
        return responseToSend;
    }

    private double calculateSimilarity(List<String> skills1, List<String> skills2) {
        Set<String> allSkills = new HashSet<>(skills1);
        allSkills.addAll(skills2);

        int[] vector1 = new int[allSkills.size()];
        int[] vector2 = new int[allSkills.size()];

        int i = 0;
        for (String skill : allSkills) {
            vector1[i] = skills1.contains(skill) ? 1 : 0;
            vector2[i] = skills2.contains(skill) ? 1 : 0;
            i++;
        }

        return cosineSimilarity(vector1, vector2);
    }

    private double cosineSimilarity(int[] vector1, int[] vector2) {
        int dotProduct = 0;
        int norm1 = 0;
        int norm2 = 0;

        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
            norm1 += vector1[i] * vector1[i];
            norm2 += vector2[i] * vector2[i];
        }

        return (norm1 == 0 || norm2 == 0) ? 0 : dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
}
