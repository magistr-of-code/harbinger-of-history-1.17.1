package net.maxmag_change.harbingerofhistory.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.maxmag_change.harbingerofhistory.util.IEntityDataSaver;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class MoneyCommand {

    private static final String MONEY = "massage.harbingerofhistory.money_output";

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("money").executes(MoneyCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        for (ServerPlayerEntity player : context.getSource().getServer().getPlayerManager().getPlayerList()) {
            context.getSource().getPlayer().sendMessage(Text.of(new TranslatableText(MONEY).getString() + ((IEntityDataSaver) player).getPersistentData().getInt("money")).copy().fillStyle(Style.EMPTY.withColor(Formatting.AQUA)),true);

        }
        return 1;
    }
}