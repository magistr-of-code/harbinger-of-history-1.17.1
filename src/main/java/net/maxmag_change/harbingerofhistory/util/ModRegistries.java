package net.maxmag_change.harbingerofhistory.util;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.maxmag_change.harbingerofhistory.command.MoneyCommand;
import net.maxmag_change.harbingerofhistory.command.SpawnCommand;

public class ModRegistries {

    public static void registerModStuffs() {
        registerCommands();

    }
    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(MoneyCommand::register);
        CommandRegistrationCallback.EVENT.register(SpawnCommand::register);
    }


}

