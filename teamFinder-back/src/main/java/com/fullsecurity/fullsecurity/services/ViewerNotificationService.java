package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.models.UserProfile;

public interface ViewerNotificationService {

    void sendProfileViewNotification(UserProfile sender, UserProfile receiver);
}
