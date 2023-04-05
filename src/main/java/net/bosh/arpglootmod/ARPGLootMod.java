package net.bosh.arpglootmod;

import net.bosh.arpglootmod.Config.ConfigLoader;
import net.bosh.arpglootmod.Events.EntityDeathHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARPGLootMod implements ModInitializer {
	public static final String MOD_ID = "arpglootmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize()	{
		ConfigLoader.registerConfigs();
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(new EntityDeathHandler());
	}
}
