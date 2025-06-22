package me.itsArmorStand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArmorStandCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            ArmorStandGui armorStandGui = new ArmorStandGui();
            player.openInventory(armorStandGui.guiPrincipal(player));
            return true;
        } else {
            Bukkit.getConsoleSender().sendMessage("Eu deixei? Apenas players!");
        }
        return false;
    }
}
