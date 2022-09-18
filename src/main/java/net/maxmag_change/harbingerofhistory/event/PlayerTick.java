package net.maxmag_change.harbingerofhistory.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import net.maxmag_change.harbingerofhistory.util.IEntityDataSaver;
import net.maxmag_change.harbingerofhistory.util.MoneyData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;

import net.minecraft.text.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerTick implements ServerTickEvents.StartTick {
    @Override
    public void onStartTick(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.sendMessage(Text.of("money: " + ((IEntityDataSaver) player).getPersistentData().getInt("money")).copy().fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);
        //   if(new Random().nextFloat() <= 0.005f) {
                    // Only server
        //           MoneyData.addMoney(((IEntityDataSaver) player), 1);
                    //output message
        //            System.out.println("its working");
        //
        //    }
        }

    }
}

