package net.maxmag_change.harbingerofhistory.block.custom;

import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.concurrent.ThreadLocalRandom;

public class RtpBlock extends Block {
    public RtpBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
             int RandowZ = getRandom(10000, 1);
             int RandowX = getRandom(10000, 1);

             livingEntity.teleport(RandowX,100,RandowZ);
             livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 70, 255));

        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private int getRandom(int max, int min) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;

    }

    private boolean isValuableBlock (Block block) {
        return block == Blocks.AIR;
    }
}