package net.bosh.arpglootmod.Events;

import net.bosh.arpglootmod.Logic.ItemGenerator;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

public class EntityDeathHandler implements ServerEntityCombatEvents.AfterKilledOtherEntity{
    @Override
    public void afterKilledOtherEntity(ServerWorld world, Entity entity, LivingEntity killedEntity) {
        if (killedEntity instanceof Monster && entity instanceof PlayerEntity) {

            ItemGenerator IG = new ItemGenerator();
            ItemStack drop = IG.generateDrop();

            killedEntity.dropStack(drop);

        }
    }
}
