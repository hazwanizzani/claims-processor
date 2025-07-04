package com.insurance.claimsprocessor.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceClaim {
    private String claimId;
    private String policyNumber;
    private String customerName;
    private String claimType;
    private Double claimAmount;
    private String status;
    private String description;
}