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


    protected RaceGenerator (FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(dataOutput, DataOutput.OutputType.DATA_PACK, "dndadventure/races" , Races.CODEC);
    }

    @Override
    public String getName() {
        return "tree";
    }


    @Override
    protected void configure(BiConsumer<Identifier, Races> provider) {
        provider.accept(Identifier. ,"Race");
    }
}