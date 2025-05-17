package com.real_connect.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDashboardDTO {
	 private int totalProperties;
	    private List<PropertyDTO> properties;
	    private List<InquiryDTO> inquiries;
}

