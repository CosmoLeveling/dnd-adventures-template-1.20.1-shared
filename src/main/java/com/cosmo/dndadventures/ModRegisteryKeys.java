package com.cosmo.dndadventures;

import com.cosmo.dndadventures.races.Races;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModRegisteryKeys {
    public static final RegistryKey<Registry<Races>> RACES_KEY = RegistryKey.ofRegistry(new Identifier("dndadventures","races"));

}
