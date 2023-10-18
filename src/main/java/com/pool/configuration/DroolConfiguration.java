package com.pool.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "drool")
@Data
public class DroolConfiguration {
    private String template;
    private String droolDomineName;
    private String title;
    private String navName;
    private String headerTitle;
    private String addCondition;
}
