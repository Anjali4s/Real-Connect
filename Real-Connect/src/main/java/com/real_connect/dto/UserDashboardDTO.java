package com.real_connect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDashboardDTO {
    private long totalSavedProperties;
    private long totalInquiries;
    private long totalAvailableProperties;
}