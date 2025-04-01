package com.pepinho.ad.suzukiviolin.converters;


import com.pepinho.ad.suzukiviolin.entities.PlayListType;
import jakarta.persistence.AttributeConverter;

public class PlayListTypeConverter implements AttributeConverter<PlayListType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PlayListType playListType) {
        return 0;
    }

    @Override
    public PlayListType convertToEntityAttribute(Integer integer) {
        return null;
    }
}
