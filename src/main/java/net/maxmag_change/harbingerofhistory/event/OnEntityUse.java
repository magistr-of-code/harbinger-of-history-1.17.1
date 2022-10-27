package net.maxmag_change.harbingerofhistory.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.maxmag_change.harbingerofhistory.entity.ModEntity;
import net.maxmag_change.harbingerofhistory.entity.custom.Player;
import net.maxmag_change.harbingerofhistory.item.ModItems;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OnEntityUse implements UseEntityCallback {
    int start = 0;
    boolean food = false;

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (entity.getType() == ModEntity.COOK && start == 3 &&
                player.getInventory().getMainHandStack().getItem() == Items.AIR && food == false) {
            food = true;
            start = 1;
           ClientPlayNetworking.send(ModMessages.DIALOG_ID, PacketByteBufs.create());
        }
        if (entity.getType() == ModEntity.PLAYER || entity.getType() == ModEntity.COOK
                || entity.getType() == ModEntity.MAN || entity.getType() == ModEntity.CITIZEN
                && start == 3 && player.getInventory().getMainHandStack().getItem() == ModItems.CANDY_LAIN) {
            start = 1;
            ClientPlayNetworking.send(ModMessages.CANDY_COLLECTION_ID, PacketByteBufs.create());
        }
        else if(start <= 3) {
            System.out.println("wrong umber");
            start += 1;
        }  else if(start >= 4) {
            System.out.println("set number to new");
            start = 1;
        }else {
            System.out.println("not much");
        }
        return ActionResult.PASS;
    }
}
