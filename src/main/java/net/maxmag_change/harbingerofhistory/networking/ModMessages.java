package net.maxmag_change.harbingerofhistory.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.event.OnEntityUse;
import net.maxmag_change.harbingerofhistory.networking.packet.*;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier MONEY_ID = new Identifier(HarbingerOfHistory.MOD_ID, "money");
    public static final Identifier MONSTER_ENTITY_MONEY_ID = new Identifier(HarbingerOfHistory.MOD_ID, "monstermoney");
    public static final Identifier DRAGON_ENTITY_MONEY_ID = new Identifier(HarbingerOfHistory.MOD_ID, "dragonmoney");
    public static final Identifier WITHER_ENTITY_MONEY_ID = new Identifier(HarbingerOfHistory.MOD_ID, "withermoney");
    public static final Identifier ENTITY_MONEY_ID = new Identifier(HarbingerOfHistory.MOD_ID, "entitymoney");
    public static final Identifier WOOD_BOSS_MONEY_ID = new Identifier(HarbingerOfHistory.MOD_ID, "woodbossmoney");
    public static final Identifier DIALOG_ID = new Identifier(HarbingerOfHistory.MOD_ID, "dialog");

    public static final Identifier CANDY_COLLECTION_ID = new Identifier(HarbingerOfHistory.MOD_ID, "candycollection");

    public static final Identifier EXAMPLE_ID = new Identifier(HarbingerOfHistory.MOD_ID, "example");

    public static final Identifier DEATH_ID = new Identifier(HarbingerOfHistory.MOD_ID, "death");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(MONEY_ID, MoneyC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(WOOD_BOSS_MONEY_ID, MoneyC2SPacket::killedWoodBoss);
        ServerPlayNetworking.registerGlobalReceiver(ENTITY_MONEY_ID, MoneyC2SPacket::killedEntity);
        ServerPlayNetworking.registerGlobalReceiver(MONSTER_ENTITY_MONEY_ID, MoneyC2SPacket::killedMonsterEntity);
        ServerPlayNetworking.registerGlobalReceiver(DRAGON_ENTITY_MONEY_ID, MoneyC2SPacket::killedEnderDragonEntity);
        ServerPlayNetworking.registerGlobalReceiver(WITHER_ENTITY_MONEY_ID, MoneyC2SPacket::killedWitherEntity);
        ServerPlayNetworking.registerGlobalReceiver(DEATH_ID, DeathC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(DIALOG_ID, OnEntityUseC2SPacket::dialog);
        ServerPlayNetworking.registerGlobalReceiver(CANDY_COLLECTION_ID, OnEntityUseC2SPacket::candyCollection);
    }

    public static void registerS2CPackets() {

    }
}
