package commands;

import me.EasyOn.reportDiscordIntegration.ReportDiscordIntegration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlagCommand implements CommandExecutor {

    ReportDiscordIntegration plugin;

    public FlagCommand(ReportDiscordIntegration reportDiscordIntegration) {
        this.plugin = reportDiscordIntegration;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Check if the sender is a player
        if(sender instanceof Player) {
            Player player =  (Player) sender;
            if(args.length != 1) {  //Check if there is the good number of arguments after the command
                player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Usage: /flag [true | false]");
            } else {
                if(args[0].equalsIgnoreCase("true")) {
                    if(plugin.getConfig().getBoolean("PluginEnabled") == true) {
                        player.sendMessage(plugin.getPrefix() + ChatColor.RED + "It's already enabled.");
                    } else {
                        plugin.setItEnabledFlag(true);
                        plugin.getConfig().set("PluginEnabled", true);
                        plugin.saveConfig();
                        player.sendMessage(plugin.getPrefix() + ChatColor.GREEN + "You have set the plugin HelloMessagePlugin to true.");
                    }
                } else if(args[0].equalsIgnoreCase("false")) {
                    if(plugin.getConfig().getBoolean("PluginEnabled") == false) {
                        player.sendMessage(plugin.getPrefix() + ChatColor.RED + "It's already disabled.");
                    } else {
                        plugin.setItEnabledFlag(false);
                        plugin.getConfig().set("PluginEnabled", false);
                        plugin.saveConfig();
                        player.sendMessage(plugin.getPrefix() + ChatColor.RED + "You have set the plugin HelloMessagePlugin to false.");
                    }
                } else {
                    player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Usage: /flag [true | false]");
                }
            }
        }
        else { //If sender is not a player
            if(args.length != 1) { //Check if there is the good number of arguments after the command
                System.out.println(plugin.getPrefix() + "Usage: /flag [true | false]");
            } else {
                if(args[0].equalsIgnoreCase("true")) {
                    if(plugin.getConfig().get("itEnabledFlag") == "true") {

                    }
                    plugin.setItEnabledFlag(true);
                    plugin.getConfig().set("itEnabledFlag", true);
                    plugin.saveConfig();
                    System.out.println(plugin.getPrefix() + "You have set the plugin HelloMessagePlugin to true.");
                } else if(args[0].equalsIgnoreCase("false")) {
                    plugin.setItEnabledFlag(false);
                    plugin.getConfig().set("itEnabledFlag", false);
                    plugin.saveConfig();
                    System.out.println(plugin.getPrefix() + "You have set the plugin HelloMessagePlugin to false.");
                } else {
                    System.out.println(plugin.getPrefix() + "Usage: /flag [true | false]");
                }
            }
        }
        return true;
    }
}