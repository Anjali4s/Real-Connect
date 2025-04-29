package com.real_connect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InquiryDTO {
    private Long interestId;
    private Long propertyId;
    private Long clientId;
    private String clientName;
    private String clientEmail;
}