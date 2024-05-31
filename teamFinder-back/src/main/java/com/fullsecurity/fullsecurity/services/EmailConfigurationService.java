package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.dto.EmailConfigurationDto;

public interface EmailConfigurationService {

    void addEmailConfiguration(String email);

    String getEmailConfiguration();
}
