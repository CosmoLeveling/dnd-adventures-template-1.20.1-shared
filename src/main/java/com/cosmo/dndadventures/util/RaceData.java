package com.cosmo.dndadventures.util;

import net.minecraft.nbt.NbtCompound;

public class RaceData {
    public static void setRace(EntityDataSaver player, String racebeingset) {
        NbtCompound nbt = player.getPersistentData();
        String race = nbt.getString("race");
        if (race.equals("")) {
            race = racebeingset;
        }else{
            race = race;
        }
        nbt.putString("race", race);
        // sync the data
    }

    public static void resetRace(EntityDataSaver player) {
        NbtCompound nbt = player.getPersistentData();
        String race = nbt.getString("race");
        race = "";

        nbt.putString("race", race);
        // sync the data
    }
}
