package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.RevenueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueTypeRepository extends JpaRepository<RevenueType, Long> {
}
