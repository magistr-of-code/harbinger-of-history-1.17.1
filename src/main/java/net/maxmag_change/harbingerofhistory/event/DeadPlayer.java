package net.maxmag_change.harbingerofhistory.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;

public class DeadPlayer implements ServerPlayerEvents.AllowDeath {
    @Override
    public boolean allowDeath(ServerPlayerEntity player, DamageSource damageSource, float damageAmount) {
        ClientPlayNetworking.send(ModMessages.DEATH_ID, PacketByteBufs.create());
        return false;
    }
}
