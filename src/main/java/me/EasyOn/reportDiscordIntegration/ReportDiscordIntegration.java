package me.EasyOn.reportDiscordIntegration;

import commands.FlagCommand;
import commands.ReportCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ReportDiscordIntegration extends JavaPlugin {

    private boolean isItEnabledFlag; //Flag that is loaded from file (or changed in-game by command /flag "boolean")
    private String prefix = ChatColor.WHITE + "[" + ChatColor.GREEN + "RDI" + ChatColor.WHITE + "] ";

    public String getPrefix() {
        return prefix;
    }
    public void setItEnabledFlag(boolean itEnabledFlag) {
        this.isItEnabledFlag = itEnabledFlag;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        setItEnabledFlag(getConfig().getBoolean("PluginEnabled"));
        Objects.requireNonNull(getCommand("flag-rdi")).setExecutor(new FlagCommand(this));   //Registers flag-rdi command
        Objects.requireNonNull(getCommand("report")).setExecutor(new ReportCommand(this));   //Registers report command
    }

    @Override
    public void onDisable() {
    }
}
