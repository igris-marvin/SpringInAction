package com.foundationalspring.partone.configurationprts.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("name.manager")
public class SizeProp {
    
    private int size = 20;
}
