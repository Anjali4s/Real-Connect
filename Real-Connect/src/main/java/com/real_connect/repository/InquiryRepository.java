package com.real_connect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.real_connect.entity.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByClient_UserId(Long clientId);
    Optional<Inquiry> findByClient_UserIdAndProperty_Id(Long clientId, Long propertyId);
}

