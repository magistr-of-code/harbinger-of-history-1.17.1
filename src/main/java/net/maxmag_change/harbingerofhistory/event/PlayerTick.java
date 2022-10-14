package net.maxmag_change.harbingerofhistory.event;

import com.mojang.brigadier.LiteralMessage;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import net.maxmag_change.harbingerofhistory.util.IEntityDataSaver;
import net.maxmag_change.harbingerofhistory.util.MoneyData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import net.minecraft.text.Text;
import software.bernie.geckolib3.geo.raw.pojo.Converter;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerTick implements ServerTickEvents.StartTick {

    private static final String MASSAGE = "massage.harbingerofhistory.money_output";

    @Override
    public void onStartTick(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

            }
        }

    }

