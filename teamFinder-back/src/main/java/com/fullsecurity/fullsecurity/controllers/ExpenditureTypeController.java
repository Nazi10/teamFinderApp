package com.fullsecurity.fullsecurity.controllers;

import com.fullsecurity.fullsecurity.dto.ExpenditureTypeDto;
import com.fullsecurity.fullsecurity.payload.response.ApiResponse;
import com.fullsecurity.fullsecurity.payload.response.MessageResponse;
import com.fullsecurity.fullsecurity.services.ExpenditureTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/expenditure-type")
@SecurityRequirement(name = "bearerAuth")
public class ExpenditureTypeController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenditureTypeController.class);

    private final ExpenditureTypeService expenditureTypeService;

    public ExpenditureTypeController(ExpenditureTypeService expenditureTypeService) {
        this.expenditureTypeService = expenditureTypeService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> addExpenditureType(@RequestBody ExpenditureTypeDto expenditureTypeDto) {
        logger.debug("Request to add Expenditure Type");
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(HttpStatus.OK, this.expenditureTypeService.addExpenditureType(expenditureTypeDto)));
        } catch (Exception e) {
            logger.error("Error: {} ", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ka ndodhur një problem në server!"));
        }

    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ExpenditureTypeDto>> getAllExpendituresTypes() {
        logger.debug("Request to get Expenditure Type");
        return new ResponseEntity<>(this.expenditureTypeService.getAllExpenditureTypes(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> deleteExpenditureType(@RequestParam Long id) {
        logger.debug("Request to delete Expenditure Type");
        try {
            return ResponseEntity.ok(new MessageResponse(this.expenditureTypeService.deleteExpenseType(id)));
        } catch (BadRequestException b) {
            logger.error("Bad Request Error: {}", b.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Kategoria nuk mund të fshihet sepse ka shpenzime të lidhura me këtë kategori"));
        } catch (NoSuchElementException noSuchElementException) {
            logger.error("No such element: {}", noSuchElementException.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Nuk u gjet kategori shpenzimi me këtë ID"));
        } catch (Exception e) {
            logger.error("Error: {}", e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ka ndodhur një problem në server"));
        }
    }

    @PostMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> editExpenditureType(@RequestBody ExpenditureTypeDto expenditureTypeDto) {
        logger.debug("Request to edit Expenditure Type");
        try {
            this.expenditureTypeService.editExpenditureType(expenditureTypeDto);
            return ResponseEntity.ok(new MessageResponse("Kategoria e shpenzimit u modifikua me sukses!"));
        } catch (Exception ex) {
            logger.error("Error: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ka ndodhur një problem në server!"));
        }
    }
}
