package com.cosmo.dndadventures;

import com.cosmo.dndadventures.networking.ModMessages;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cosmo.dndadventures.ModRegisteryKeys.RACES_KEY;

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

		ServerLifecycleEvents.SERVER_STARTED.register(server->{
			server.getRegistryManager()
					.getOptional(RACES_KEY)
					.ifPresent(registry->{
						registry
								.streamEntries()
								.forEach(entry->{
									System.out.println(entry.registryKey()
											.getValue()
											.toString()
									);
								});
					});
		});
	}
}