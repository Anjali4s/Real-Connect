package com.real_connect.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.real_connect.dto.PropertyPublicDTO;
import com.real_connect.entity.ClientInterest;
import com.real_connect.entity.Property;
import com.real_connect.entity.User;

@Repository
public interface ClientInterestRepository extends JpaRepository<ClientInterest, Long> {
	List<ClientInterest> findByClient_UserId(Long clientId);

//	long countByUserId(Long userId);
//
//	long countInquiriesByUserId(Long userId);
//
//	Collection<PropertyPublicDTO> findSavedPropertiesByUserId(Long userId);
//
//	Collection<PropertyPublicDTO> findInquiriesByUserId(Long userId);
    void deleteByClient_UserIdAndProperty_Id(Long clientId, Long propertyId);
//
//	long countByUserId(Long userId);
//
//	long countInquiriesByUserId(Long userId);
}
