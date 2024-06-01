package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {
}
