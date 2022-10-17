package net.maxmag_change.harbingerofhistory.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.maxmag_change.harbingerofhistory.util.IEntityDataSaver;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class MoneyCommand {

    private static final String MONEY = "massage.harbingerofhistory.money_output";
    private static final String DONTHAVE = "massage.harbingerofhistory.dont_have_money";

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("money").executes(MoneyCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        for (ServerPlayerEntity player : context.getSource().getServer().getPlayerManager().getPlayerList()) {
            if(((IEntityDataSaver) player).getPersistentData().getInt("money") != 0) {
                context.getSource().getPlayer().sendMessage(Text.of(new TranslatableText(MONEY).getString() + ((IEntityDataSaver) player).getPersistentData().getInt("money")).copy().fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);
            }else {
                context.getSource().getPlayer().sendMessage(Text.of(new TranslatableText(DONTHAVE).getString()).copy().fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);
            }


        }
        return 1;
    }
}