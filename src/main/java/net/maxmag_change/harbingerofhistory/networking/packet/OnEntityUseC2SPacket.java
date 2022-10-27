package net.maxmag_change.harbingerofhistory.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.maxmag_change.harbingerofhistory.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import java.util.concurrent.ThreadLocalRandom;

public class OnEntityUseC2SPacket {

    private static final String COOKER_DIALOG = "massage.harbingerofhistory.cook_dialog";
    private static final String SON_PLAYER = "massage.harbingerofhistory.sweetness_or_nastiness_player";
    private static final String SON_ENTITY = "massage.harbingerofhistory.sweetness_or_nastiness_entity";

    public static void dialog(MinecraftServer server, ServerPlayerEntity player,
                              ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        // Only server
        player.sendMessage(new TranslatableText(COOKER_DIALOG).fillStyle(Style.EMPTY.withColor(Formatting.WHITE)), false);

        player.giveItemStack(Items.BREAD.getDefaultStack());
        //output message
        System.out.println("dialog_start");
    }

    public static void candyCollection(MinecraftServer server, ServerPlayerEntity player,
                                       ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        // Only server
        player.sendMessage(new TranslatableText(SON_PLAYER).fillStyle(Style.EMPTY.withColor(Formatting.WHITE)), false);
        player.sendMessage(new TranslatableText(SON_ENTITY).fillStyle(Style.EMPTY.withColor(Formatting.WHITE)), false);
        if (getRandom(4, 0) == 3) {
            player.giveItemStack(ModItems.BLUE_CANDY_CANE.getDefaultStack());
        } else if (getRandom(4, 0) <= 2) {
            player.giveItemStack(ModItems.RED_CANDY_CANE.getDefaultStack());
        } else if (getRandom(5, 0) >= 4) {
            player.giveItemStack(ModItems.PURPLE_CANDY_CANE.getDefaultStack());
        } else if (getRandom(6, 0) == 6) {
            player.giveItemStack(Items.GLOW_BERRIES.getDefaultStack());
            player.giveItemStack(Items.GLOW_BERRIES.getDefaultStack());
        }
        else {
            player.giveItemStack(ModItems.CANDY_CORN.getDefaultStack());
        }
        //output message
        System.out.println("dialog_start");
    }

    private static int getRandom(int max, int min) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }
}
