package com.polytech.aps.viewvoyage.movie_service.core.content.db.converter;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Quality;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class QualityConverter implements AttributeConverter<Quality, String> {
    @Override
    public String convertToDatabaseColumn(Quality quality) {
        if (quality == null) {
            return null;
        }

        return quality.getQuality();
    }

    @Override
    public Quality convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Quality.values())
                .filter(c -> c.getQuality().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
