package net.bosh.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	ItemGenerator IG = new ItemGenerator();

	@Override
	public void onInitialize() {
//This is what happens when the SheepShearCallback EVENT actually happens
		SheepShearCallback.EVENT.register((player, sheep) -> {
			sheep.setSheared(true);

			// create diamond item entity at sheep position

			ItemStack stack = IG.generateDrop();
			ItemEntity itemEntity = new ItemEntity(player.world, sheep.getX(), sheep.getY(), sheep.getZ(), stack);
			player.world.spawnEntity(itemEntity);

			return ActionResult.FAIL;
		});

	}
}
