package com.cosmo.dndadventures.races;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class RaceGenerator extends FabricCodecDataProvider<Races> {

    public static final Codec<Races> CODEC = RecordCodecBuilder.create(instance->instance.group(
            Codec.INT.fieldOf("color").forGetter(CodecClass::)
    ).apply(instance, Races::new));

    protected RaceGenerator (FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(dataOutput, registriesFuture, DataOutput.OutputType.DATA_PACK, , CODEC);
    }

    @Override
    public String getName() {
        return RaceGenerator;
    }

    @Override
    protected void configure(BiConsumer<Identifier, > provider, RegistryWrapper.WrapperLookup lookup) {
        provider.accept(Identifier.,"AN_OBJECT_OF_YOUR_TYPE");
    }

    @Override
    protected void configure(BiConsumer<Identifier, Races> provider) {
        provider.accept();
    }
}