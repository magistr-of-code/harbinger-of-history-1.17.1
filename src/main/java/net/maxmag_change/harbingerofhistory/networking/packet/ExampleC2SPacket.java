package net.maxmag_change.harbingerofhistory.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.maxmag_change.harbingerofhistory.entity.ModEntity;
import net.maxmag_change.harbingerofhistory.entity.custom.Player;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import static net.maxmag_change.harbingerofhistory.entity.ModEntity.COOK;


public class ExampleC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player,
                               ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {

        // Only server
        EntityType.COW.spawn(((ServerWorld) player.world), null,null,
                player, player.getBlockPos(), SpawnReason.TRIGGERED, true, false);
    }

}
