package com.fullsecurity.fullsecurity.controllers;

import com.fullsecurity.fullsecurity.dto.ExpenditureDto;
import com.fullsecurity.fullsecurity.payload.response.MessageResponse;
import com.fullsecurity.fullsecurity.services.ExpenditureService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/expenditure")
@SecurityRequirement(name = "bearerAuth")
public class ExpenditureController {

    private final ExpenditureService expenditureService;

    public ExpenditureController(ExpenditureService expenditureService) {
        this.expenditureService = expenditureService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> addExpenditure(@RequestBody ExpenditureDto expenditureDto) {
        try {
            this.expenditureService.addExpenditure(expenditureDto);
            return ResponseEntity.ok(new MessageResponse("Shpenzimi u ruajt me sukses"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ka ndodhur një problem në server!"));
        }
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ExpenditureDto>> allExpenditureInAMonth() {
        return ResponseEntity.ok(this.expenditureService.allExpenditureInAMonth());
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> deleteExpenditureById(@RequestParam Long id) {
        if (this.expenditureService.deleteExpenditureById(id)) {
            return ResponseEntity.ok().body(new MessageResponse("Expenditure was deleted successfully!"));
        } else {
            return ResponseEntity.ok().body(new MessageResponse("Couldnt find a expenditure with given info!"));
        }
    }

    @GetMapping("/todaysExpends")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Double> allExpendituresToday() {
        return ResponseEntity.ok(this.expenditureService.totalExpendsInADay(LocalDate.now()));
    }

    @GetMapping("/get-monthly-expends")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Double> getMonthlyExpends() {
        return ResponseEntity.ok(this.expenditureService.getMonthlyExpends());
    }

    @PostMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> editExpenditure(@RequestBody ExpenditureDto expenditureDto) {
        try {
            return ResponseEntity.ok(new MessageResponse(this.expenditureService.editExpenditure(expenditureDto)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ka ndodhur një problem në server!"));
        }
    }

    @GetMapping("/expenditureStartToEndDate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ExpenditureDto>> expenditureStartToEndDate(@RequestParam String fromDate, @RequestParam String toDate) {
        return ResponseEntity.ok(this.expenditureService.expenditureStartToEndDate(fromDate, toDate));
    }

}
