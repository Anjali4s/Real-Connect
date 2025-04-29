package com.real_connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real_connect.dto.DashboardDTO;
import com.real_connect.service.ClientInterestService;
import com.real_connect.service.CompanyDashboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyDashboardController {

    private final CompanyDashboardService dashboardService;
    @Autowired
    private ClientInterestService interestService;

    @GetMapping("/{companyUserId}/dashboard")
    public ResponseEntity<DashboardDTO> getDashboard(@PathVariable Long companyUserId) {
        DashboardDTO dashboard = dashboardService.getDashboard(companyUserId);
        return ResponseEntity.ok(dashboard);
    }
    @PutMapping("/{inquiryId}/response")
    public ResponseEntity<String> respondToInquiry(@PathVariable Long inquiryId, @RequestBody String responseMessage) {
        try {
            // Call the service method to handle the response
            interestService.respondToInquiry(inquiryId, responseMessage);

            // Return a success message
            return ResponseEntity.ok("Response sent successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inquiry not found");
        }
    }
}
