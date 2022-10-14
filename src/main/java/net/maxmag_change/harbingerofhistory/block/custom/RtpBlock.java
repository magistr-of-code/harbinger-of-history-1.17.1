package net.maxmag_change.harbingerofhistory.block.custom;

import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.maxmag_change.harbingerofhistory.world.dimension.ModDimensions;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class RtpBlock extends Block {
    public RtpBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(entity instanceof LivingEntity player) {
            MinecraftServer server = world.getServer();
            if (!world.isClient) {
                if (world.getRegistryKey() == ModDimensions.SPAWN_DIMENSION_KEY) {
                    ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                    ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                    int RandowZ = getRandom(10000, 1);
                    int RandowX = getRandom(10000, 1);

                    serverPlayer.teleport(overWorld,RandowX,100,RandowZ,serverPlayer.bodyYaw, serverPlayer.prevPitch);
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 70, 255));
                    serverPlayer.changeGameMode(GameMode.SURVIVAL);
                }
                else {
                    ServerWorld spawn = server.getWorld(ModDimensions.SPAWN_DIMENSION_KEY);
                    ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                    serverPlayer.changeGameMode(GameMode.ADVENTURE);
                    serverPlayer.teleport(spawn,0,108,0,serverPlayer.bodyYaw, serverPlayer.prevPitch);
                }
            }
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    private int getRandom(int max, int min) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;

    }

    private boolean isValuableBlock (Block block) {
        return block == Blocks.AIR;
    }
}