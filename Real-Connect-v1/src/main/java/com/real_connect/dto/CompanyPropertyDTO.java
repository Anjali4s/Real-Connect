package com.real_connect.dto;

import com.real_connect.entity.Property;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyPropertyDTO {
    private Property property;
    private int viewCount;
    private int inquiryCount;
}
