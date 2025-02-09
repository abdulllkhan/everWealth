package com.project.everWealth.risk.entity;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;

public class InvestmentOptionsConverter implements AttributeConverter<List<String>, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> investmentOptions) {
        try {
            return objectMapper.writeValueAsString(investmentOptions);
        } catch (Exception e) {
            throw new RuntimeException("Error converting investment options list to JSON: ", e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String dbJson) {
        try {
            return objectMapper.readValue(dbJson, new TypeReference<List<String>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to investment options list: ", e);
        }
    }
    
}
