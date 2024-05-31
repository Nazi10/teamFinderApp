package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.dto.EmailConfigurationDto;
import com.fullsecurity.fullsecurity.dto.mapper.EmailConfigurationMapper;
import com.fullsecurity.fullsecurity.models.EmailConfiguration;
import com.fullsecurity.fullsecurity.repository.EmailConfigurationRepository;
import com.fullsecurity.fullsecurity.security.services.UserDetailsImpl;
import com.fullsecurity.fullsecurity.services.EmailConfigurationService;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigurationImpl implements EmailConfigurationService {

    private final EmailConfigurationMapper emailConfigurationMapper;

    private final EmailConfigurationRepository emailConfigurationRepository;

    public EmailConfigurationImpl(EmailConfigurationMapper emailConfigurationMapper, EmailConfigurationRepository emailConfigurationRepository) {
        this.emailConfigurationMapper = emailConfigurationMapper;
        this.emailConfigurationRepository = emailConfigurationRepository;
    }

    @Override
    public void addEmailConfiguration(String email) {
        EmailConfiguration emailConfiguration = this.emailConfigurationRepository.findAllByUserId(UserDetailsImpl.getCurrentId());
        if(emailConfiguration == null) {
            emailConfiguration = new EmailConfiguration(null, email, UserDetailsImpl.getCurrentId(), true);
        } else {
            emailConfiguration.setEmail(email);
        }
        this.emailConfigurationRepository.save(emailConfiguration);
    }

    @Override
    public String getEmailConfiguration() {
        EmailConfiguration emailConfiguration = this.emailConfigurationRepository.findAllByUserId(UserDetailsImpl.getCurrentId());
        if(emailConfiguration != null) {
            return emailConfiguration.getEmail();
        } else {
            return null;
        }
    }
}
