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
        super(dataOutput, DataOutput.OutputType.DATA_PACK, "dndadventures/races" , Races.CODEC);
    }

    @Override
    public String getName() {
        return "tree";
    }


    @Override
    protected void configure(BiConsumer<Identifier, Races> provider) {
        provider.accept(new Identifier("dndadventures:human"),new Races(10,10,10,"Human"));
        provider.accept(new Identifier("dndadventures:tiefling"),new Races(10,10,10,"Tiefling"));
        provider.accept(new Identifier("dndadventures:dragonborn"),new Races(12,12,12,"Dragonborn"));
        provider.accept(new Identifier("dndadventures:dwarf"),new Races(12,12,12,"Dwarf"));
        provider.accept(new Identifier("dndadventures:elf"),new Races(10,10,10,"Elf"));
        provider.accept(new Identifier("dndadventures:halfling"),new Races(12,12,12,"Halfling"));
        provider.accept(new Identifier("dndadventures:gnome"),new Races(10,10,10,"Gnome"));
        provider.accept(new Identifier("dndadventures:half-elf"),new Races(12,12,12,"Half-Elf"));
        provider.accept(new Identifier("dndadventures:half-orc"),new Races(10,10,10,"Half-Orc"));
    }
}