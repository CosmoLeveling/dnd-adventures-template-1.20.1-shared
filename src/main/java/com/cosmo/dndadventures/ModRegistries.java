package com.cosmo.dndadventures;


import com.cosmo.dndadventures.races.Races;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;

public class ModRegistries {
    public static void registerDynamicRegistries() {
        DynamicRegistries.register(ModRegisteryKeys.RACES_KEY, Races.CODEC);

    }
}
