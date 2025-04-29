package com.real_connect.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InquiryResponseDTO {
	private Long inquiryId;
    private Long propertyId;
    private String propertyName;
    private String message;
    private String response;
    private String status;
    private LocalDateTime createdAt;
}
