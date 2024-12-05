package com.briefs.hunters_league.converter;

import com.briefs.hunters_league.domain.enums.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        return role != null ? role.name() : null;
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return dbData != null ? Role.valueOf(dbData) : null;
    }
}