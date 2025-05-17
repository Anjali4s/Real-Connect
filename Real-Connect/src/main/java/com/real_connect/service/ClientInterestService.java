package com.real_connect.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real_connect.dto.InquiryDTO;
import com.real_connect.dto.InquiryResponseDTO;
import com.real_connect.entity.ClientInterest;
import com.real_connect.entity.Inquiry;
import com.real_connect.entity.Property;
import com.real_connect.entity.User;
import com.real_connect.repository.ClientInterestRepository;
import com.real_connect.repository.InquiryRepository;
import com.real_connect.repository.PropertyRepository;
import com.real_connect.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientInterestService {
    @Autowired
    private ClientInterestRepository interestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private InquiryRepository inquiryRepository;

    public List<Property> getSavedProperties(Long clientId) {
        return interestRepository.findByClient_UserId(clientId)
                .stream()
                .map(ClientInterest::getProperty)
                .collect(Collectors.toList());
    }

    public void saveProperty(Long clientId, Long propertyId) {
        User client = userRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        ClientInterest interest = new ClientInterest();
        interest.setClient(client);
        interest.setProperty(property);

        interestRepository.save(interest);
    }
    @Transactional
    public void removeSavedProperty(Long clientId, Long propertyId) {
        interestRepository.deleteByClient_UserIdAndProperty_Id(clientId, propertyId);
    }
    
    public void sendOrUpdateInquiry(InquiryDTO dto) {
        User client = userRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Property property = propertyRepository.findById(dto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        Inquiry inquiry = inquiryRepository
                .findByClient_UserIdAndProperty_Id(dto.getClientId(), dto.getPropertyId())
                .orElse(new Inquiry());

        inquiry.setClient(client);
        inquiry.setProperty(property);
        inquiry.setMessage("Client is interested in this property.");
        inquiry.setCreatedAt(LocalDateTime.now());
        inquiryRepository.save(inquiry);
    }

    public List<InquiryResponseDTO> getInquiryHistory(Long clientId) {
        List<Inquiry> inquiries = inquiryRepository.findByClient_UserId(clientId);

        return inquiries.stream().map(inquiry -> {
            String status = inquiry.getResponse() == null ? "Pending" : "Answered";
            return new InquiryResponseDTO(
                    inquiry.getInquiryId(),
                    inquiry.getProperty().getId(),
                    inquiry.getProperty().getName(),
                    inquiry.getMessage(),
                    inquiry.getResponse(),
                    status,
                    inquiry.getCreatedAt()
            );
        }).collect(Collectors.toList());
    }
    
    public void respondToInquiry(Long inquiryId, String responseMessage) {
        // Find the inquiry by its ID
        Inquiry inquiry = inquiryRepository.findById(inquiryId).orElseThrow(() -> new RuntimeException("Inquiry not found"));

        // Update the response and status
        inquiry.setResponse("Responded");
        //inquiry.setStatus("Responded");  // Mark the inquiry as "Responded"

        // Save the updated inquiry
        inquiryRepository.save(inquiry);
    }


}
