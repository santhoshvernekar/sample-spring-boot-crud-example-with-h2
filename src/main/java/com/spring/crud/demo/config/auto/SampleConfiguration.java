package com.spring.crud.demo.config.auto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "owner")
@Data
@Validated
public class SampleConfiguration {
    private boolean enabled = true;
    private OwnerDetails ownerDetails= new OwnerDetails();
}
