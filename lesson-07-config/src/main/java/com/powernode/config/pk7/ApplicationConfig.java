package com.powernode.config.pk7;

import com.powernode.config.pk6.Security;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @ConfigurationProperties(prefix = "security")
    @Bean
    public Security createSecurity() {
        return new Security();
    }
}
