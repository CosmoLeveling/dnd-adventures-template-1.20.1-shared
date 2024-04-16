package com.cosmo.dndadventures.datagen;

import com.cosmo.dndadventures.races.Races;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;


public class RaceGenerator extends FabricCodecDataProvider<Races> {


    public RaceGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(dataOutput, DataOutput.OutputType.DATA_PACK, "dndadventure/races" , Races.CODEC);
    }

    @Override
    public String getName() {
        return "tree";
    }


    @Override
    protected void configure(BiConsumer<Identifier, Races> provider) {
        provider.accept(new Identifier("dndadventures:tiefling"),new Races(10,10,10));
    }
}