package com.real_connect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.real_connect.dto.InquiryDTO;
import com.real_connect.dto.PropertyPublicDTO;
import com.real_connect.dto.UserDashboardDTO;
import com.real_connect.entity.Property;
import com.real_connect.repository.ClientInterestRepository;
import com.real_connect.repository.PropertyRepository;
import com.real_connect.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDashboardService {

//    private final ClientInterestRepository interestRepository;
//    private final PropertyRepository propertyRepository;
//    private final UserRepository userRepository;
//
//    public UserDashboardDTO getDashboard(Long userId) {
//        long savedCount = interestRepository.countByUserId(userId);
//        long inquiriesCount = interestRepository.countInquiriesByUserId(userId); // or use same table with filtering
//        long totalProperties = propertyRepository.count();
//
//        return new UserDashboardDTO(savedCount, inquiriesCount, totalProperties);
//    }
//
//    public List<PropertyPublicDTO> getSavedProperties(Long userId) {
//        return interestRepository.findSavedPropertiesByUserId(userId)
//                .stream()
//                .map(this::convertToPropertyPublicDTO)
//                .collect(Collectors.toList());
//    }
//
//    public List<InquiryDTO> getUserInquiries(Long userId) {
//        return interestRepository.findInquiriesByUserId(userId)
//                .stream()
//                .map(inquiry -> new InquiryDTO(inquiry))
//                .collect(Collectors.toList());
//    }
//
//    private PropertyPublicDTO convertToPropertyPublicDTO(Property property) {
//        PropertyPublicDTO dto = new PropertyPublicDTO();
//        dto.setName(property.getName());
//        dto.setLocation(property.getLocation());
//        dto.setPrice(property.getPrice());
//        dto.setType(property.getType());
//        dto.setOfferType(property.getOfferType());
//        dto.setPostedDate(property.getPostedDate().toString()); // format as needed
//
//        dto.setRooms(property.getRooms());
//        dto.setDeposit(property.getDeposit());
//        dto.setStatus(property.getStatus());
//        dto.setBedroom(property.getBedroom());
//        dto.setBathroom(property.getBathroom());
//        dto.setBalcony(property.getBalcony());
//
//        dto.setCarpetArea(property.getCarpetArea());
//        dto.setAge(property.getAge());
//        dto.setRoomFloor(property.getRoomFloor());
//        dto.setTotalFloors(property.getTotalFloors());
//        dto.setFurnished(property.getFurnished());
//        dto.setLoan(property.getLoan());
//
//        dto.setDescription(property.getDescription());
//
//        dto.setLifts(property.isLifts());
//        dto.setSecurityGuards(property.isSecurityGuards());
//        dto.setPlayGround(property.isPlayGround());
//        dto.setGardens(property.isGardens());
//        dto.setWaterSupply(property.isWaterSupply());
//        dto.setPowerBackup(property.isPowerBackup());
//        dto.setParkingArea(property.isParkingArea());
//        dto.setGym(property.isGym());
//        dto.setShoppingMall(property.isShoppingMall());
//        dto.setHospital(property.isHospital());
//        dto.setSchools(property.isSchools());
//        dto.setMarketArea(property.isMarketArea());
//
//        dto.setBigImage(property.getBigImage());
//        dto.setSmallImages(property.getSmallImages());
//
//        return dto;
//    }
}
