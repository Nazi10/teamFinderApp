package com.fullsecurity.fullsecurity.controllers;

import com.fullsecurity.fullsecurity.dto.RevenueTypeDto;
import com.fullsecurity.fullsecurity.payload.response.ApiResponse;
import com.fullsecurity.fullsecurity.services.RevenueTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/revenue-type")
@SecurityRequirement(name = "bearerAuth")
public class RevenueTypeController {

    private static final Logger logger = LoggerFactory.getLogger(RevenueTypeController.class);

    private final RevenueTypeService revenueTypeService;


    public RevenueTypeController(RevenueTypeService revenueTypeService) {
        this.revenueTypeService = revenueTypeService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> addRevenueType(@RequestBody RevenueTypeDto revenueTypeDto) {
        logger.info("Request to add revenue type");
        try {
            this.revenueTypeService.addRevenueType(revenueTypeDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(HttpStatus.OK, "Kategoria e të ardhurave u shtua me sukses!"));
        } catch (Exception e) {
            logger.error("Error: {} ", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ka ndodhur një problem në server!"));
        }
    }


}
