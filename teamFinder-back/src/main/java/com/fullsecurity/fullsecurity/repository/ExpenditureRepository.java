package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.Expenditure;
import com.fullsecurity.fullsecurity.models.ExpenditureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    List<Expenditure> findAllByDateOfExpendIsBetweenOrderByDateOfExpendDesc(LocalDate startDate, LocalDate endDate);
    List<Expenditure> findAllByDateOfExpendIsBetweenOrderByDateOfExpendAsc(LocalDate startDate, LocalDate endDate);

    List<Expenditure> findAllByDateOfExpend(LocalDate date);

    List<Expenditure> findAllExpendsByExpenditureTypeId(Long id);
}
