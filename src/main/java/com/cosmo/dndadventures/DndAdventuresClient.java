package com.cosmo.dndadventures;

import com.cosmo.dndadventures.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class DndAdventuresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
