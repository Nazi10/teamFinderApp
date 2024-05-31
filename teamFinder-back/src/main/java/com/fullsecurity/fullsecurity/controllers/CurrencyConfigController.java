package com.fullsecurity.fullsecurity.controllers;

import com.fullsecurity.fullsecurity.dto.CurrencyConfigurationDto;
import com.fullsecurity.fullsecurity.payload.response.MessageResponse;
import com.fullsecurity.fullsecurity.security.jwt.AuthEntryPointJwt;
import com.fullsecurity.fullsecurity.services.CurrencyConfigurationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/currencyConfig")
@SecurityRequirement(name = "bearerAuth")
public class CurrencyConfigController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyConfigController.class);

    private final CurrencyConfigurationService currencyConfigurationService;

    public CurrencyConfigController(CurrencyConfigurationService currencyConfigurationService) {
        this.currencyConfigurationService = currencyConfigurationService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> addCurrencyConfig(@RequestBody CurrencyConfigurationDto currencyConfigurationDto) {
        logger.debug("Adding Currency Configuration");
        try {
            this.currencyConfigurationService.addCurrencyConfiguration(currencyConfigurationDto);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Konfigurimi u ruajt me sukses!"));

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ka ndodhur një problem në server!"));
        }
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Double> getCurrencyConfig() {
        logger.debug("Getting current currency config");
        return ResponseEntity.ok(this.currencyConfigurationService.getCurrencyConfiguration());
    }
}
