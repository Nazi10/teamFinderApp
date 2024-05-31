package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.dto.ExpenditureDto;
import com.fullsecurity.fullsecurity.dto.mapper.ExpenditureMapper;
import com.fullsecurity.fullsecurity.models.Expenditure;
import com.fullsecurity.fullsecurity.repository.ExpenditureRepository;
import com.fullsecurity.fullsecurity.services.ExpenditureService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenditureServiceImpl implements ExpenditureService {

    private final ExpenditureRepository expenditureRepository;
    private final ExpenditureMapper expenditureMapper;

    public ExpenditureServiceImpl(ExpenditureRepository expenditureRepository, ExpenditureMapper expenditureMapper) {
        this.expenditureRepository = expenditureRepository;
        this.expenditureMapper = expenditureMapper;
    }

    @Override
    public String addExpenditure(ExpenditureDto expenditureDto) {
            Expenditure expenditure = this.expenditureMapper.toEntity(expenditureDto);
            this.expenditureRepository.save(expenditure);
            return "Expenses were added successfully";
    }

    @Override
    public List<ExpenditureDto> allExpenditureInAMonth() {
        return this.expenditureMapper.toDto(this.expenditureRepository.findAllByDateOfExpendIsBetweenOrderByDateOfExpendDesc(LocalDate.now().minusMonths(1), LocalDate.now()));
    }

    @Override
    public boolean deleteExpenditureById(Long id) {
        Optional<Expenditure> expenditure = this.expenditureRepository.findById(id);
        if(expenditure.isPresent()) {
           Expenditure expenditure1 = expenditure.get();
           expenditure1.setStatus(false);
           this.expenditureRepository.save(expenditure1);
           return true;
        }
        return false;
    }

    @Override
    public Double totalExpendsInADay(LocalDate date) {
        List<Expenditure> expenditures = this.expenditureRepository.findAllByDateOfExpend(date);
        double totalExpend = 0.0;
        if(!expenditures.isEmpty()) {
            totalExpend = expenditures.stream().mapToDouble(Expenditure::getExpends).sum();
        }
        return totalExpend;
    }

    @Override
    public Double getMonthlyExpends() {
        List<Expenditure> expenditures = this.expenditureRepository.findAllByDateOfExpendIsBetweenOrderByDateOfExpendAsc
                (LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1), LocalDate.now());
        double total = 0.0;
        if(!expenditures.isEmpty()) {
            total = expenditures.stream().mapToDouble(Expenditure::getExpends).sum();
        }
        return total;
    }

    @Override
    public String editExpenditure(ExpenditureDto expenditureDto) {
        if(expenditureDto.getId() != null) {
            Expenditure expenditureToSave = this.expenditureMapper.toEntity(expenditureDto);
            Expenditure expenditure = this.expenditureRepository.findById(expenditureDto.getId()).get();
            expenditure.setCurrency(expenditureToSave.getCurrency());
            expenditure.setExpenditureType(expenditureToSave.getExpenditureType());
            expenditure.setExpends(expenditureToSave.getExpends());
            expenditure.setComment(expenditureToSave.getComment());
            expenditure.setDateOfExpend(expenditureToSave.getDateOfExpend());
            this.expenditureRepository.save(expenditure);
            return "Shpenzimi u ruajt me sukses";
        } else {
            return "Ka ndodhur një problem në server";
        }
    }

    @Override
    public List<ExpenditureDto> expenditureStartToEndDate(String fromDate, String toDate) {
        return this.expenditureMapper.toDto(this.expenditureRepository.findAllByDateOfExpendIsBetweenOrderByDateOfExpendAsc(LocalDate.parse(fromDate), LocalDate.parse(toDate)));
    }
}
