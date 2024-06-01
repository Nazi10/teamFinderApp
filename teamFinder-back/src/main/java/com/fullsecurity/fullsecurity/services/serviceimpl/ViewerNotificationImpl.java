package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.models.UserProfile;
import com.fullsecurity.fullsecurity.models.ViewerNotification;
import com.fullsecurity.fullsecurity.repository.ViewerNotificationRepository;
import com.fullsecurity.fullsecurity.services.ViewerNotificationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional
public class ViewerNotificationImpl implements ViewerNotificationService {

    private final ViewerNotificationRepository viewerRepository;

    public ViewerNotificationImpl(ViewerNotificationRepository viewerRepository) {
        this.viewerRepository = viewerRepository;
    }


    @Override
    public void sendProfileViewNotification(UserProfile sender, UserProfile receiver) {
        ViewerNotification viewerNotification = new ViewerNotification();
        viewerNotification.setReceiver(receiver);
        viewerNotification.setSender(sender);
        viewerNotification.setStatus(true);
        viewerNotification.setTimestamp(LocalDateTime.now());
        viewerNotification.setIsRead(false);
        viewerNotification.setMessage(sender.getName()+" "+sender.getLastName()+" has viewed your profile!");
        viewerRepository.save(viewerNotification);
    }
}
