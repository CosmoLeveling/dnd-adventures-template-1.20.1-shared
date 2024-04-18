package com.cosmo.dndadventures.races;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

import static com.cosmo.dndadventures.ModRegisteryKeys.RACES_KEY;

public record Races(int strength, int dexterity, int constitution,String name) {
    public static final Codec<Races> CODEC = RecordCodecBuilder.create(instance->instance.group(
            Codec.INT.optionalFieldOf("strength", 0).forGetter(Races::strength),
            Codec.INT.optionalFieldOf("dexterity", 0).forGetter(Races::dexterity),
            Codec.INT.optionalFieldOf("constitution", 0).forGetter(Races::constitution),
            Codec.STRING.optionalFieldOf("race","human").forGetter(Races::name)
    ).apply(instance, Races::new));
    public static Races getRaceById(DynamicRegistryManager manager, Identifier id) {
        return manager.getOptional(RACES_KEY).map(registry->registry.get(id)).orElse(null);
    }
}