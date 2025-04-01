package com.pepinho.ad.suzukiviolin.converters;

import com.pepinho.ad.suzukiviolin.entities.MusicGenre;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MusicGenreConverter implements AttributeConverter<MusicGenre, String> {

    @Override
    public String convertToDatabaseColumn(MusicGenre musicGenre) {
        if (musicGenre == null) {
            return null;
        }

        String name = musicGenre.name();
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    @Override
    public MusicGenre convertToEntityAttribute(String dbDataString) {
        if (dbDataString == null || dbDataString.isEmpty()) {
            return null;
        }

        return MusicGenre.valueOf(dbDataString.toUpperCase());
    }
}
