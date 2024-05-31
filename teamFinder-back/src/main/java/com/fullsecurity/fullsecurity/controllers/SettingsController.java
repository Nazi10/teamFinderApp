package com.fullsecurity.fullsecurity.controllers;

import com.fullsecurity.fullsecurity.dto.EmailConfigurationDto;
import com.fullsecurity.fullsecurity.dto.ExpenseConfigurationDto;
import com.fullsecurity.fullsecurity.payload.response.ApiResponse;
import com.fullsecurity.fullsecurity.services.EmailConfigurationService;
import com.fullsecurity.fullsecurity.services.ExpenseConfigurationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/settings")
@SecurityRequirement(name = "bearerAuth")
public class SettingsController {

    private final Logger log = LoggerFactory.getLogger(SettingsController.class);

    private final ExpenseConfigurationService expenseConfigurationService;
    private final EmailConfigurationService emailConfigurationService;

    public SettingsController(ExpenseConfigurationService expenseConfigurationService, EmailConfigurationService emailConfigurationService) {
        this.expenseConfigurationService = expenseConfigurationService;
        this.emailConfigurationService = emailConfigurationService;
    }

    @PostMapping("/add-expense-daily-limit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Double> addExpensesDailyLimit(@RequestParam Double expenseLimit, @RequestParam String currency) {
        log.debug("Rest request to save an Expense Daily Limit");
        try {
            Double response = expenseConfigurationService.saveDailyExpenseLimit(expenseLimit, currency);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error occurred while saving daily expense limit", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get-expense-configuration")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ExpenseConfigurationDto> getExpenseConfig() {
        log.debug("Rest request to get Expense Config");
        ExpenseConfigurationDto expenseConfigurationDto = null;
        try {
             expenseConfigurationDto = expenseConfigurationService.getExpenseDailyConfig();
        } catch (Exception e) {
            log.error("Error: {}", e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok().body(expenseConfigurationDto);
    }

    @PostMapping("/add-email-configuration")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> addEmailConfiguration(@RequestParam String email) {
        log.debug("Rest request to add email config");
        try {
            emailConfigurationService.addEmailConfiguration(email);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, "Konfigurimi u ruajt me sukses"));
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return ResponseEntity.internalServerError().body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ka ndodhur një problem në server!"));
        }
    }

    @GetMapping("/get-email-configuration")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmailConfigurationDto> getEmailConfiguration() {
        log.info("Rest request to get email config");
        try {
            return ResponseEntity.ok().body(new EmailConfigurationDto(emailConfigurationService.getEmailConfiguration(), true));
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
