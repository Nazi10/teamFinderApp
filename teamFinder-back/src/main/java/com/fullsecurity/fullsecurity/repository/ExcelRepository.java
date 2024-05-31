package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.ExcelTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelRepository extends JpaRepository<ExcelTest, Long> {
}
