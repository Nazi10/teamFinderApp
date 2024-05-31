package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.EmailConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailConfigurationRepository extends JpaRepository<EmailConfiguration, Long> {

    EmailConfiguration findAllByUserId(Long id);
}
