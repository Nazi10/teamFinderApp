package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.ViewerNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewerNotificationRepository extends JpaRepository<ViewerNotification, Long> {
}
