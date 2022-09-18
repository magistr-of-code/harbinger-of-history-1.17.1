package net.maxmag_change.harbingerofhistory.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.maxmag_change.harbingerofhistory.util.IEntityDataSaver;
import net.maxmag_change.harbingerofhistory.util.MoneyData;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Timer;
import java.util.TimerTask;

public class MoneyC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player,
                               ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        // Only server
        MoneyData.addMoney(((IEntityDataSaver) player), 1);
        //output message
        System.out.println("receive");
    }

    public static void killedEntity(MinecraftServer server, ServerPlayerEntity player,
                               ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        // Only server
        MoneyData.addMoney(((IEntityDataSaver) player), 20);
        //output message
        System.out.println("money for kill for: " + player.getName());
    }

    public static void killedMonsterEntity(MinecraftServer server, ServerPlayerEntity player,
                                    ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        // Only server
        MoneyData.addMoney(((IEntityDataSaver) player), 40);
        //output message
        System.out.println("money for kill for: " + player.getName());
    }
    public static void killedWitherEntity(MinecraftServer server, ServerPlayerEntity player,
                                           ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        // Only server
        MoneyData.addMoney(((IEntityDataSaver) player), 200);
        //output message
        System.out.println("money for kill for: " + player.getName());
    }
    public static void killedEnderDragonEntity(MinecraftServer server, ServerPlayerEntity player,
                                           ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        // Only server
        MoneyData.addMoney(((IEntityDataSaver) player), 320);
        //output message
        System.out.println("money for kill for: " + player.getName());
    }

    public static void killedWoodBoss(MinecraftServer server, ServerPlayerEntity player,
                                    ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        // Only server
        MoneyData.addMoney(((IEntityDataSaver) player), 180);
        //output message
        System.out.println("money for boss for: " + player.getName());
    }

}

