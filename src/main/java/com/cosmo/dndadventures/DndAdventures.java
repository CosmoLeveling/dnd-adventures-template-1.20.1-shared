package com.cosmo.dndadventures;

import com.cosmo.dndadventures.networking.ModMessages;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DndAdventures implements ModInitializer {
	public static String MOD_ID = "dnd-adventures";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello I'm your neighbor!");
		LOGGER.info("train");
		ModRegistries.registerDynamicRegistries();
		DndAdventures.LOGGER.info(DndAdventures.MOD_ID + " resources registered!");
		ModMessages.registerC2SPackets();
		ModMessages.registerS2CPackets();
	}
}