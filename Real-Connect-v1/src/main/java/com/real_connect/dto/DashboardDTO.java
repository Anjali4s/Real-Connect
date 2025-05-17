package com.real_connect.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {
    private int totalProperties;
    private List<PropertyDTO> properties;
    private List<InquiryDTO> inquiries;
}
