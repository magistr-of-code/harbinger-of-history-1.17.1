package net.maxmag_change.harbingerofhistory.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.server.ServerStartCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.maxmag_change.harbingerofhistory.networking.packet.ExampleC2SPacket;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

public class ServerStated implements ServerStartCallback {
    @Override
    public void onStartServer(MinecraftServer server) {
    }
}
