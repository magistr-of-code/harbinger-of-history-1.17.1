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

public class DeathC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player,
                               ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        int haveMoney = ((IEntityDataSaver) player).getPersistentData().getInt("money");
        // Only server
        MoneyData.removeMoney(((IEntityDataSaver) player), haveMoney);
        //output message
        System.out.println("its working");
        player.sendMessage(Text.of("Money taken for death").copy().fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);
    }
}
