package com.real_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real_connect.dto.InquiryDTO;
import com.real_connect.dto.InquiryResponseDTO;
import com.real_connect.entity.Property;
import com.real_connect.service.ClientInterestService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/client-interest")
@RequiredArgsConstructor
public class ClientInterestController {
    @Autowired
    private ClientInterestService interestService;

    @GetMapping("/saved/{clientId}")
    public ResponseEntity<List<Property>> getSavedProperties(@PathVariable Long clientId) {
        return ResponseEntity.ok(interestService.getSavedProperties(clientId));
    }

    @PostMapping("/save/{clientId}/{propertyId}")
    public ResponseEntity<Void> saveProperty(
            @PathVariable Long clientId,
            @PathVariable Long propertyId) {
        interestService.saveProperty(clientId, propertyId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{clientId}/{propertyId}")
    public ResponseEntity<Void> removeSavedProperty(
            @PathVariable Long clientId,
            @PathVariable Long propertyId) {
        interestService.removeSavedProperty(clientId, propertyId);
        return ResponseEntity.ok().build();
    }
    
 // 1. Get all inquiries by client
    @GetMapping("/inquiries/{clientId}")
    public ResponseEntity<List<InquiryResponseDTO>> getClientInquiries(@PathVariable Long clientId) {
        return ResponseEntity.ok(interestService.getInquiryHistory(clientId));
    }

    
    @PostMapping("/send-inquiry")
    public ResponseEntity<String> sendOrUpdateInquiry(@RequestBody InquiryDTO dto) {
        interestService.sendOrUpdateInquiry(dto);
        return ResponseEntity.ok("Inquiry sent successfully!!");
    }


}
