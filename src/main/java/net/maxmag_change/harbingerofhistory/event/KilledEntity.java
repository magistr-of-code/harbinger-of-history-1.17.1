package net.maxmag_change.harbingerofhistory.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.maxmag_change.harbingerofhistory.entity.custom.WoodMonster;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.minecraft.client.render.entity.EnderDragonEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.server.world.ServerWorld;

public class KilledEntity implements ServerEntityCombatEvents.AfterKilledOtherEntity {
    int EntityKills = 0;
    @Override
    public void afterKilledOtherEntity(ServerWorld world, Entity entity, LivingEntity killedEntity) {
        EntityKills += 1;
        if (EntityKills >= 1 && !world.isClient) {
            if (killedEntity instanceof WoodMonster) {
                ClientPlayNetworking.send(ModMessages.WOOD_BOSS_MONEY_ID, PacketByteBufs.create());
                EntityKills = EntityKills - 1;
            } else if (killedEntity instanceof Monster) {
                ClientPlayNetworking.send(ModMessages.MONSTER_ENTITY_MONEY_ID, PacketByteBufs.create());
                EntityKills = EntityKills - 1;
            } else if (killedEntity instanceof WitherEntity) {
                ClientPlayNetworking.send(ModMessages.WITHER_ENTITY_MONEY_ID, PacketByteBufs.create());
                EntityKills = EntityKills - 1;
            } else if(killedEntity instanceof EnderDragonEntity) {
                ClientPlayNetworking.send(ModMessages.DRAGON_ENTITY_MONEY_ID, PacketByteBufs.create());
                EntityKills = EntityKills - 1;
            } else {
                ClientPlayNetworking.send(ModMessages.ENTITY_MONEY_ID, PacketByteBufs.create());
                EntityKills = EntityKills - 1;
            }
        }
    }
}




