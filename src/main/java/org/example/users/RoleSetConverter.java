package org.example.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.constants.Roles;
import java.util.Set;

@Converter
public class RoleSetConverter implements AttributeConverter<Set<Roles>, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Set<Roles> roles) {
        try {
            return objectMapper.writeValueAsString(roles);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting roles to JSON", e);
        }
    }

    @Override
    public Set<Roles> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<Set<Roles>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to roles", e);
        }
    }
}
