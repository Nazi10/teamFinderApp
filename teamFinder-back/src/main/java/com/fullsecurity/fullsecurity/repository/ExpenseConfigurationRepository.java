package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.ExpenseConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseConfigurationRepository extends JpaRepository<ExpenseConfiguration, Long> {

    ExpenseConfiguration findAllByUserId(Long userId);
}
