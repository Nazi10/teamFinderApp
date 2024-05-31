package com.fullsecurity.fullsecurity.controllers;

import com.fullsecurity.fullsecurity.dto.RevenueDto;
import com.fullsecurity.fullsecurity.payload.response.ApiResponse;
import com.fullsecurity.fullsecurity.payload.response.MessageResponse;
import com.fullsecurity.fullsecurity.services.RevenueService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/revenue")
@SecurityRequirement(name = "bearerAuth")
public class RevenueController {

    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> addRevenue(@RequestBody RevenueDto revenueDto) {
        try {
            this.revenueService.addRevenue(revenueDto);
            return ResponseEntity.ok(new MessageResponse("Të ardhurat u ruajtën me sukses!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ka ndodhur një problem në server"));
        }
    }

    @GetMapping("/get-todays-revenue")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Double> getTodaysRevenue() {
        try {
            return ResponseEntity.ok( this.revenueService.getTodaysRevenue());
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-monthly-revenue")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Double> getMonthlyRevenue() {
        try {
            return ResponseEntity.ok(this.revenueService.getMonthlyRevenue());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
