package com.insurance.claimsprocessor.listener;

import com.insurance.claimsprocessor.model.InsuranceClaim;
import com.insurance.claimsprocessor.processor.ClaimProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Consumer;
@Slf4j
@Configuration
@RequiredArgsConstructor
public class ClaimListener {
    private final ClaimProcessor claimProcessor;
    @Bean
    public Consumer<InsuranceClaim> processClaims() {
        return claim -> {
            try {
                log.info("Received claim for processing: {}", claim.getClaimId());
                claimProcessor.processClaim(claim);
            } catch (Exception e) {
                log.error("Error processing claim: {}", claim.getClaimId(), e);
            }
        };
    }
}