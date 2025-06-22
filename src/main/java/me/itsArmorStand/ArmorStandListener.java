package me.itsArmorStand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ArmorStandListener implements Listener {

    ArmorStandGui armorStandGui = new ArmorStandGui();

    @EventHandler
    void onClickEvent(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();
        if (inventoryClickEvent.getView().getTitle().equals("§lItsArmorStand")) {
            ItemStack currentItem = inventoryClickEvent.getCurrentItem();
            if (currentItem != null && currentItem.getType() != Material.AIR) {
                inventoryClickEvent.setCancelled(true);
                switch (inventoryClickEvent.getCurrentItem().getType()) {
                    case ARMOR_STAND:
                        player.openInventory(armorStandGui.guiDeCriacao(player));
                        if (!ItsArmorStand.stands.containsKey(player)) {
                            ArmorStand playerStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                            ItsArmorStand.stands.put(player, playerStand);
                        }
                        ItsArmorStand.stands.get(player).setVisible(false);
                        break;
                    case RED_WOOL:
                        Bukkit.getScheduler().runTask(ItsArmorStand.getPlugin(), () -> player.closeInventory());
                        break;
                }
            }
        } else if (inventoryClickEvent.getView().getTitle().equalsIgnoreCase("§lItsCreationGui")) {
            ItemStack currentItem = inventoryClickEvent.getCurrentItem();
            if (currentItem != null && currentItem.getType() != Material.AIR) {
                inventoryClickEvent.setCancelled(true);

                switch (currentItem.getType()) {

                    case ARMOR_STAND:
                        player.openInventory(armorStandGui.createDisableAndEnable(player, Material.ARMOR_STAND, "§lDo you want to put arms?"));
                        break;
                    case BEACON:
                        player.openInventory(armorStandGui.createDisableAndEnable(player, Material.BEACON, "§lDo you want to make it shine?"));
                        break;
                    case LEATHER_CHESTPLATE:
                        player.openInventory(armorStandGui.armorGui(player));
                        break;
                    case DIAMOND_CHESTPLATE:
                        player.openInventory(armorStandGui.createDisableAndEnable(player, Material.DIAMOND_CHESTPLATE, "§lDo you want to make it invisible?"));
                        break;
                    case GREEN_WOOL:
                        ItsArmorStand.stands.get(player).setVisible(true);
                        ItsArmorStand.stands.remove(player);
                        player.closeInventory();
                        break;
                    case RED_WOOL:
                        ItsArmorStand.stands.get(player).remove();
                        ItsArmorStand.stands.remove(player);
                        player.closeInventory();
                        break;
                }


            }
        } else if (inventoryClickEvent.getView().getTitle().equalsIgnoreCase("§lDisable&Enable")) {
            ItemStack currentItem = inventoryClickEvent.getCurrentItem();
            if (currentItem != null && currentItem.getType() != Material.AIR) {
                Inventory inventory = inventoryClickEvent.getClickedInventory();
                inventoryClickEvent.setCancelled(true);
                switch (currentItem.getType()) {
                    case GREEN_WOOL:
                        if (inventory.contains(Material.ARMOR_STAND)) {
                            ItsArmorStand.stands.get(player).setArms(true);
                            player.openInventory(armorStandGui.guiDeCriacao(player));
                        } else if (inventory.contains(Material.BEACON)) {
                            ItsArmorStand.stands.get(player).setGlowing(true);
                            player.openInventory(armorStandGui.guiDeCriacao(player));
                        } else if (inventory.contains(Material.DIAMOND_CHESTPLATE)) {
                            ItsArmorStand.stands.get(player).setInvulnerable(true);
                            player.openInventory(armorStandGui.guiDeCriacao(player));
                        }
                        break;
                    case RED_WOOL:
                        if (inventory.contains(Material.ARMOR_STAND)) {
                            ItsArmorStand.stands.get(player).setArms(false);
                            player.openInventory(armorStandGui.guiDeCriacao(player));
                        } else if (inventory.contains(Material.BEACON)) {
                            ItsArmorStand.stands.get(player).setGlowing(false);
                            player.openInventory(armorStandGui.guiDeCriacao(player));
                        } else if (inventory.contains(Material.DIAMOND_CHESTPLATE)) {
                            ItsArmorStand.stands.get(player).setInvulnerable(false);
                            player.openInventory(armorStandGui.guiDeCriacao(player));
                        }
                        break;
                }
            }
        } else if (inventoryClickEvent.getView().getTitle().equalsIgnoreCase("§lItsArmorGui")) {
            ItemStack currentItem = inventoryClickEvent.getCurrentItem();
            if (currentItem != null && currentItem.getType() != Material.AIR) {
                inventoryClickEvent.setCancelled(true);
                switch (currentItem.getType()) {
                    case DIAMOND_HELMET:
                        if (ItsArmorStand.stands.get(player).getHelmet().getType() == Material.DIAMOND_HELMET) {
                            ItsArmorStand.stands.get(player).setHelmet(null);
                        } else {
                            ItsArmorStand.stands.get(player).setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                        }
                        break;
                    case DIAMOND_CHESTPLATE:
                        if (ItsArmorStand.stands.get(player).getChestplate().getType() == Material.DIAMOND_CHESTPLATE) {
                            ItsArmorStand.stands.get(player).setChestplate(null);
                        } else {
                            ItsArmorStand.stands.get(player).setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                        }
                        break;
                    case DIAMOND_LEGGINGS:
                        if (ItsArmorStand.stands.get(player).getLeggings().getType() == Material.DIAMOND_LEGGINGS) {
                            ItsArmorStand.stands.get(player).setLeggings(null);
                        } else {
                            ItsArmorStand.stands.get(player).setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                        }
                        break;
                    case DIAMOND_BOOTS:
                        if (ItsArmorStand.stands.get(player).getBoots().getType() == Material.DIAMOND_BOOTS) {
                            ItsArmorStand.stands.get(player).setBoots(null);
                        } else {
                            ItsArmorStand.stands.get(player).setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                        }
                        break;
                    case GREEN_WOOL:
                        player.openInventory(armorStandGui.guiDeCriacao(player));

                }

            }
        }
    }
}
