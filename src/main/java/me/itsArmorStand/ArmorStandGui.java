package me.itsArmorStand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ArmorStandGui {


    public Inventory guiPrincipal(Player player) {

        Inventory inventory = Bukkit.createInventory(player, 9, "§lItsArmorStand");

        ItemStack create = new ItemStack(Material.ARMOR_STAND, 1);
        ItemMeta createMeta = create.getItemMeta();
        createMeta.setDisplayName("§a§lCriar");
        List<String> createLore = new ArrayList<>();
        createLore.add("§7Abre uma gui para a criação de armor stands");
        createMeta.setLore(createLore);
        create.setItemMeta(createMeta);
        inventory.setItem(0, create);

        ItemStack cancel = new ItemStack(Material.RED_WOOL);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName("§c§lCancelar");
        cancel.setItemMeta(cancelMeta);
        inventory.setItem(8, cancel);
        return inventory;
    }

    public Inventory guiDeCriacao(Player player) {
        Inventory creationGui = Bukkit.createInventory(player, 9, "§lItsCreationGui");
        ItemStack arms = new ItemStack(Material.ARMOR_STAND);
        ItemMeta arms_meta = arms.getItemMeta();
        arms_meta.setDisplayName("§7§lArms");
        arms.setItemMeta(arms_meta);
        ItemStack glow = new ItemStack(Material.BEACON);
        ItemMeta glow_meta = glow.getItemMeta();
        glow_meta.setDisplayName("§9§lGlow");
        glow.setItemMeta(glow_meta);
        ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta armor_meta = armor.getItemMeta();
        armor_meta.setDisplayName("§e§lArmor");
        armor.setItemMeta(armor_meta);
        ItemStack invecibility = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta invencibility_meta = invecibility.getItemMeta();
        invencibility_meta.setDisplayName("§9§lInvencibility");
        invecibility.setItemMeta(invencibility_meta);
        ItemStack green = new ItemStack(Material.GREEN_WOOL);
        ItemMeta green_meta = green.getItemMeta();
        green_meta.setDisplayName("§a§lCriar");
        green.setItemMeta(green_meta);
        ItemStack red = new ItemStack(Material.RED_WOOL);
        ItemMeta red_meta = red.getItemMeta();
        red_meta.setDisplayName("§c§lCancelar");
        red.setItemMeta(red_meta);

        creationGui.setItem(0, arms);
        creationGui.setItem(1, glow);
        creationGui.setItem(2, armor);
        creationGui.setItem(3, invecibility);
        creationGui.setItem(7, green);
        creationGui.setItem(8, red);

        return creationGui;
    }

    Inventory createDisableAndEnable(Player player, Material material, String materialName) {
        Inventory disableAndEnableGui = Bukkit.createInventory(player, 54, "§lDisable&Enable");
        ItemStack green = new ItemStack(Material.GREEN_WOOL);
        ItemMeta green_meta = green.getItemMeta();
        green_meta.setDisplayName("§a§lAceitar");
        green.setItemMeta(green_meta);
        ItemStack red = new ItemStack(Material.RED_WOOL);
        ItemMeta red_meta = red.getItemMeta();
        red_meta.setDisplayName("§c§lCancelar");
        red.setItemMeta(red_meta);
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(materialName);
        itemStack.setItemMeta(itemMeta);
        disableAndEnableGui.setItem(13, itemStack);
        disableAndEnableGui.setItem(30, green);
        disableAndEnableGui.setItem(32, red);
        return disableAndEnableGui;
    }

    Inventory armorGui(Player player) {
        Inventory armorGui = Bukkit.createInventory(player, 54, "§lItsArmorGui");
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack done = new ItemStack(Material.GREEN_WOOL);
        ItemMeta done_Meta = done.getItemMeta();
        done_Meta.setDisplayName("§a§lAceitar");
        done.setItemMeta(done_Meta);
        armorGui.setItem(11, helmet);
        armorGui.setItem(12, chest);
        armorGui.setItem(14, leggings);
        armorGui.setItem(15, boots);
        armorGui.setItem(49,done);
        return armorGui;
    }


}
