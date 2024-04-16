package com.cosmo.dndadventures.races;

import java.util.ArrayList;

public record Races(String race, int speed) {
    public static ArrayList<String> test = new ArrayList<>();
    public static ArrayList<Integer> sped = new ArrayList<>();
    public void addTest() {
        Races.test.add(race);
    }
    public void addSped() {
        Races.sped.add(speed);
    }
    public static void setTest() {
        Races.test.add("Tiefling");
        Races.test.add("Dwarf");
        Races.test.add("Dragonborn");
        Races.test.add("Halfling");
        Races.test.add("Elf");
        Races.test.add("Half-Elf");
        Races.test.add("Half-Orc");
        Races.test.add("Gnome");
        Races.test.add("Human");
    }
    public static void setSped() {
        Races.sped.add(10);
        Races.sped.add(10);
        Races.sped.add(10);
        Races.sped.add(10);
        Races.sped.add(10);
        Races.sped.add(10);
        Races.sped.add(10);
        Races.sped.add(10);
        Races.sped.add(10);
    }
}
