package com.real_connect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.real_connect.dto.DashboardDTO;
import com.real_connect.dto.InquiryDTO;
import com.real_connect.dto.PropertyDTO;
import com.real_connect.entity.ClientInterest;
import com.real_connect.entity.Property;
import com.real_connect.repository.ClientInterestRepository;
import com.real_connect.repository.PropertyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyDashboardService {

    private final PropertyRepository propertyRepository;
    private final ClientInterestRepository clientInterestRepository;
    

    public DashboardDTO getDashboard(Long companyUserId) {
        // Assuming companyUserId is used to find properties owned by this user
//        List<Property> properties = propertyRepository.findAll()
//            .stream()
//            .filter(p -> p.getOwnerName().equalsIgnoreCase("Company #" + companyUserId)) // placeholder logic
//            .collect(Collectors.toList());
    	List<Property> properties = propertyRepository.findAll(); // No filtering


        List<PropertyDTO> propertyDTOs = properties.stream().map(p -> new PropertyDTO(
                p.getId(), p.getName(), p.getLocation(), p.getPrice()
        )).collect(Collectors.toList());

        List<ClientInterest> interests = clientInterestRepository.findAll()
            .stream()
            .filter(ci -> properties.contains(ci.getProperty()))
            .collect(Collectors.toList());

        List<InquiryDTO> inquiryDTOs = interests.stream().map(ci -> {
            InquiryDTO dto = new InquiryDTO();
            dto.setInterestId(ci.getInterestId());
            dto.setPropertyId(ci.getProperty().getId());
            dto.setClientId(ci.getClient().getUserId());
            dto.setClientName(ci.getClient().getName());
            dto.setClientEmail(ci.getClient().getEmail());
            return dto;
        }).collect(Collectors.toList());

        return new DashboardDTO(properties.size(), propertyDTOs, inquiryDTOs);
    }
   
}