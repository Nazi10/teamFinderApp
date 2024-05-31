package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.CurrencyConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConfigurationRepository extends JpaRepository<CurrencyConfiguration, Long> {
    CurrencyConfiguration findAllByUserId(Long userId);
}
