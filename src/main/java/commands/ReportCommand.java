package commands;

import me.EasyOn.reportDiscordIntegration.ReportDiscordIntegration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReportCommand implements CommandExecutor {

    ReportDiscordIntegration reportDiscordIntegration;

    public ReportCommand(ReportDiscordIntegration reportDiscordIntegration) {
        this.reportDiscordIntegration = reportDiscordIntegration;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
