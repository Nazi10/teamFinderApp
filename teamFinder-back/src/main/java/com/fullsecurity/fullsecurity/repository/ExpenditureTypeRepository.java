package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.ExpenditureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureTypeRepository extends JpaRepository<ExpenditureType, Long> {

}
