package com.real_connect.mapper;

import com.real_connect.dto.PropertyPublicDTO;
import com.real_connect.entity.Property;

public class PropertyMapper {

    public static PropertyPublicDTO toPublicDTO(Property property) {
        PropertyPublicDTO dto = new PropertyPublicDTO();
        dto.setId(property.getId());
        dto.setName(property.getName());
        dto.setLocation(property.getLocation());
        dto.setPrice(property.getPrice());
        dto.setType(property.getType());
        dto.setOfferType(property.getOfferType());
        dto.setPostedDate(property.getPostedDate());

        dto.setRooms(property.getRooms());
        dto.setDeposit(property.getDeposit());
        dto.setStatus(property.getStatus());
        dto.setBedroom(property.getBedroom());
        dto.setBathroom(property.getBathroom());
        dto.setBalcony(property.getBalcony());

        dto.setCarpetArea(property.getCarpetArea());
        dto.setAge(property.getAge());
        dto.setRoomFloor(property.getRoomFloor());
        dto.setTotalFloors(property.getTotalFloors());
        dto.setFurnished(property.getFurnished());
        dto.setLoan(property.getLoan());

        dto.setDescription(property.getDescription());

        dto.setLifts(property.isLifts());
        dto.setSecurityGuards(property.isSecurityGuards());
        dto.setPlayGround(property.isPlayGround());
        dto.setGardens(property.isGardens());
        dto.setWaterSupply(property.isWaterSupply());
        dto.setPowerBackup(property.isPowerBackup());
        dto.setParkingArea(property.isParkingArea());
        dto.setGym(property.isGym());
        dto.setShoppingMall(property.isShoppingMall());
        dto.setHospital(property.isHospital());
        dto.setSchools(property.isSchools());
        dto.setMarketArea(property.isMarketArea());

        dto.setBigImage(property.getBigImage());
        dto.setSmallImages(property.getSmallImages());
        return dto;
    }
}
