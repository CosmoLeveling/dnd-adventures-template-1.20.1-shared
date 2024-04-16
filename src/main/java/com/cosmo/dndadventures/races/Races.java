package com.cosmo.dndadventures.races;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.ArrayList;

public record Races(int strength, int dexterity, int constitution) {
    public static final Codec<Races> CODEC = RecordCodecBuilder.create(instance->instance.group(
            Codec.INT.optionalFieldOf("strength", 0).forGetter(Races::strength),
            Codec.INT.optionalFieldOf("dexterity", 0).forGetter(Races::dexterity),
            Codec.INT.optionalFieldOf("constitution", 0).forGetter(Races::constitution)
    ).apply(instance, Races::new));
}