package net.maxmag_change.harbingerofhistory.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class SpawnCommand {

    private static final String MASSAGE_FALSE = "massage.harbingerofhistory.spawn_command_false";
    private static final String MASSAGE_TRUE = "massage.harbingerofhistory.spawn_command_true";
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("spawn").executes(SpawnCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        if (context.getSource().getPlayer().getServerWorld().getRegistryKey() == ServerWorld.OVERWORLD) {
            context.getSource().getPlayer().requestTeleport(0, 255, 0);
            context.getSource().getPlayer().sendMessage(Text.of(new  TranslatableText(MASSAGE_TRUE).getString()).copy().fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), false);
            return 1;
        } else {
            context.getSource().getPlayer().sendMessage(Text.of(new TranslatableText(MASSAGE_FALSE).getString()).copy().fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);
            return 0;
        }
    }
}