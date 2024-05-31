package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.Revenue;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    List<Revenue> findAllByDateOfRevenue(LocalDate date);

    List<Revenue> findAllByDateOfRevenueIsBetweenOrderByDateOfRevenueDesc(LocalDate startDate, LocalDate endDate);
}
