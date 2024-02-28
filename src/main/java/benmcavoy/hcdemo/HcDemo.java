package benmcavoy.hcdemo;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HcDemo implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("hcdemo");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("HCD initialized!");
	}
}