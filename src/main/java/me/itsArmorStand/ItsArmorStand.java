package me.itsArmorStand;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ItsArmorStand extends JavaPlugin {

    private static ItsArmorStand plugin;

    public static HashMap<Player, ArmorStand> stands = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("itsas").setExecutor(new ArmorStandCommand());
        getServer().getPluginManager().registerEvents(new ArmorStandListener(), this);
    }

    public static ItsArmorStand getPlugin() {
        return plugin;
    }
}
