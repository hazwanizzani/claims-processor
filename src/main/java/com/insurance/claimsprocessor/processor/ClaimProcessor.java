package com.insurance.claimsprocessor.processor;

import com.insurance.claimsprocessor.model.InsuranceClaim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClaimProcessor {
    public void processClaim(InsuranceClaim claim) {
        log.info("Processing claim: {} for customer: {} amount: ${}",
                claim.getClaimId(), claim.getCustomerName(),
                claim.getClaimAmount());
// Simulate processing time
        try {
            Thread.sleep(2000); // 2 seconds processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
// Simple business logic
        String result = evaluateClaim(claim);
        log.info("Claim {} processed with result: {}", claim.getClaimId(), result);
    }

    private String evaluateClaim(InsuranceClaim claim) {
        if (claim.getClaimAmount() > 10000) {
            return "REQUIRES_MANUAL_REVIEW";
        } else if (claim.getClaimAmount() < 100) {
            return "REJECTED - Amount too small";
        } else {
            return "APPROVED";
        }
    }
}