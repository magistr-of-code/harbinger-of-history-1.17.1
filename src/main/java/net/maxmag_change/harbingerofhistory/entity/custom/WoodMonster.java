package net.maxmag_change.harbingerofhistory.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.concurrent.ThreadLocalRandom;

public class WoodMonster extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public WoodMonster(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 120.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20.5f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.5)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 3D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 50f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.09f);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        boolean idle = false;
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wood_monster.walk", true));
            idle = false;
            return PlayState.CONTINUE;
        }
        if (idle == true) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wood_monster.super_idle", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wood_monster.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.handSwinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            if (getRandom(4, 0) == 3) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wood_monster.low_chance_attack", false));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wood_monster.attack", false));
        }
    }

            this.handSwinging = false;
        return PlayState.CONTINUE;
        }



    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        animationData.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }


    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PIG_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15f, 1.0f);
    }

    private int getRandom(int max, int min) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;

    }

}

