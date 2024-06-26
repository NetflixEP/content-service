package com.polytech.aps.viewvoyage.movie_service.core.content.db.converter;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.AgeRestriction;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class AgeRestrictionConverter implements AttributeConverter<AgeRestriction, String> {
    @Override
    public String convertToDatabaseColumn(AgeRestriction ageRestriction) {
        if (ageRestriction == null) {
            return null;
        }

        return ageRestriction.getRestriction();
    }

    @Override
    public AgeRestriction convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(AgeRestriction.values())
                .filter(c -> c.getRestriction().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
