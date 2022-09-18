package net.maxmag_change.harbingerofhistory.util;

import net.minecraft.nbt.NbtCompound;

public class MoneyData {
    public static int addMoney(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("money");
        if(thirst + amount >= 1000000000) {
            thirst = 1000000000;

        } else {
            thirst += amount;
        }

        nbt.putInt("money", thirst);

        return thirst;


    }

    public static int removeMoney(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("money");
        if(thirst - amount < 0) {
            thirst = 0;
        } else {
            thirst -= amount;
        }

        nbt.putInt("money", thirst);
        // syncThirst(thirst, (ServerPlayerEntity) player);
        return thirst;
    }

}
