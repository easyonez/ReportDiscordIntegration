package commands;

import me.EasyOn.reportDiscordIntegration.ReportDiscordIntegration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FlagCommand implements CommandExecutor {

    ReportDiscordIntegration reportDiscordIntegration;

    public FlagCommand(ReportDiscordIntegration reportDiscordIntegration) {
        this.reportDiscordIntegration = reportDiscordIntegration;

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
