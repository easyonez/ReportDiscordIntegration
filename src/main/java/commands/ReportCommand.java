package commands;

import me.EasyOn.reportDiscordIntegration.ReportDiscordIntegration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class ReportCommand implements CommandExecutor {

    ReportDiscordIntegration plugin;

    public ReportCommand(ReportDiscordIntegration reportDiscordIntegration) {
        this.plugin = reportDiscordIntegration;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player) {
            if(!player.hasPermission("rdi.report.send")) {
               player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            }
            if(strings.length == 0) {
                player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Usage: /report <player> <reason>");
                return true;
            }
            else if (strings.length == 1) {
                player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Specify the reason of your report.");
                return true;
            } else {
                if(Bukkit.getPlayer(strings[0]) == null) {
                    player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Player not found.");
                    return true;
                } else if (Objects.requireNonNull(Bukkit.getPlayer(strings[0])).getName().equals(player.getName())) {
                    player.sendMessage(plugin.getPrefix() + ChatColor.RED + "You can't report yourself.");
                } else {
                    player.sendMessage(plugin.getPrefix() + ChatColor.GREEN + "Report sent!");

                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        if (onlinePlayer.hasPermission("rdi.report.receive")) {
                            onlinePlayer.sendMessage(plugin.getPrefix() + ChatColor.RED + "New report:");
                            onlinePlayer.sendMessage(plugin.getPrefix() + ChatColor.RED + "Player: " + ChatColor.YELLOW + strings[0]);
                            StringBuilder report = new StringBuilder();
                            for (int i = 1; i < strings.length; i++) {
                                report.append(strings[i]).append(" ");
                            }
                            String reason = report.toString().stripTrailing();
                            onlinePlayer.sendMessage(plugin.getPrefix() + ChatColor.RED + "Reason: " + ChatColor.YELLOW + reason);
                        }
                    }
                }
            }
        }
        return true;
    }
}
