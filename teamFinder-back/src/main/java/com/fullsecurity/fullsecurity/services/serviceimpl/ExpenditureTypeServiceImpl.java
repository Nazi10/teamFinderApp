package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.dto.ExpenditureTypeDto;
import com.fullsecurity.fullsecurity.dto.mapper.ExpenditureTypeMapper;
import com.fullsecurity.fullsecurity.models.Expenditure;
import com.fullsecurity.fullsecurity.models.ExpenditureType;
import com.fullsecurity.fullsecurity.repository.ExpenditureRepository;
import com.fullsecurity.fullsecurity.repository.ExpenditureTypeRepository;
import com.fullsecurity.fullsecurity.services.ExpenditureTypeService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureTypeServiceImpl implements ExpenditureTypeService {

    private final ExpenditureTypeRepository expenditureTypeRepository;
    private final ExpenditureTypeMapper expenditureTypeMapper;

    private final ExpenditureRepository expenditureRepository;

    public ExpenditureTypeServiceImpl(ExpenditureTypeRepository expenditureTypeRepository, ExpenditureTypeMapper expenditureTypeMapper, ExpenditureRepository expenditureRepository) {
        this.expenditureTypeRepository = expenditureTypeRepository;
        this.expenditureTypeMapper = expenditureTypeMapper;
        this.expenditureRepository = expenditureRepository;
    }

    @Override
    public String addExpenditureType(ExpenditureTypeDto expenditureTypeDto) {
        ExpenditureType expenditureType = this.expenditureTypeMapper.toEntity(expenditureTypeDto);
        this.expenditureTypeRepository.save(expenditureType);
        return "Expenditure Type added successfully!";
    }

    @Override
    public List<ExpenditureTypeDto> getAllExpenditureTypes() {
        return this.expenditureTypeMapper.toDto(this.expenditureTypeRepository.findAll());
    }

    @Override
    public String deleteExpenseType(Long id) throws BadRequestException {
        if(id != null) {
            ExpenditureType expenditureType = this.expenditureTypeRepository.findById(id).get();
            List<Expenditure> allExpenditures = this.expenditureRepository.findAllExpendsByExpenditureTypeId(id);
            if(allExpenditures.isEmpty()) {
                expenditureType.setStatus(false);
                this.expenditureTypeRepository.save(expenditureType);
                return "Kategoria e shpenzimit u fshi me sukses";
            } else {
                 throw new BadRequestException("Kategoria nuk mund të fshihet sepse ka shpenzime të lidhura me këtë kategori");
            }

        } else {
            return "Nuk u gjet kategori shpenzimi me këtë ID";
        }
    }

    @Override
    public void editExpenditureType(ExpenditureTypeDto expenditureTypeDto) {
            ExpenditureType expenditureType = this.expenditureTypeRepository.findById(expenditureTypeDto.getId()).get();
            expenditureType.setIcon(expenditureTypeDto.getIcon());
            expenditureType.setName(expenditureTypeDto.getName());
            this.expenditureTypeRepository.save(expenditureType);
    }

}
