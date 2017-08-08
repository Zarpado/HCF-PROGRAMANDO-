package listeners;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import utils.Color;

public class SpawnerShopListener implements Listener
{
  public static Inventory spawnerShop = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Spawner Shop");
  
  static
  {
    ItemStack zSpawner = new ItemStack(Material.MOB_SPAWNER);
    ItemMeta zSpawnerMeta = zSpawner.getItemMeta();
    zSpawnerMeta.setDisplayName(Color.translate("&aZombie Spawner"));
    ArrayList<String> zLore = new ArrayList();
    zLore.add(Color.translate("&7&m-------------------------"));
    zLore.add(Color.translate("&eRight click here"));
    zLore.add(Color.translate("&eTo buy a &aZombie Spawner&e."));
    zLore.add(Color.translate("&eIt costs: &a45 Emerald Blocks&e."));
    zLore.add(Color.translate("&7&m-------------------------"));
    zSpawnerMeta.setLore(zLore);
    zSpawner.setItemMeta(zSpawnerMeta);
    
    ItemStack sSpawner = new ItemStack(Material.MOB_SPAWNER);
    ItemMeta sSpawnerMeta = sSpawner.getItemMeta();
    sSpawnerMeta.setDisplayName(Color.translate("&aSkeleton Spawner"));
    ArrayList<String> sLore = new ArrayList();
    sLore.add(Color.translate("&7&m-------------------------"));
    sLore.add(Color.translate("&eRight click here"));
    sLore.add(Color.translate("&eTo buy a &aSkeleton Spawner&e."));
    sLore.add(Color.translate("&eIt costs: &a45 Emerald Blocks&e."));
    sLore.add(Color.translate("&7&m-------------------------"));
    sSpawnerMeta.setLore(sLore);
    sSpawner.setItemMeta(sSpawnerMeta);
    
    ItemStack spSpawner = new ItemStack(Material.MOB_SPAWNER);
    ItemMeta spSpawnerMeta = spSpawner.getItemMeta();
    spSpawnerMeta.setDisplayName(Color.translate("&aSpider Spawner"));
    ArrayList<String> spLore = new ArrayList();
    spLore.add(Color.translate("&7&m-------------------------"));
    spLore.add(Color.translate("&eRight click here"));
    spLore.add(Color.translate("&eTo buy a &aSpider Spawner&e."));
    spLore.add(Color.translate("&eIt costs: &a45 Emerald Blocks&e."));
    spLore.add(Color.translate("&7&m-------------------------"));
    spSpawnerMeta.setLore(spLore);
    spSpawner.setItemMeta(spSpawnerMeta);
    
    spawnerShop.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(2, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(6, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(9, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(10, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(11, zSpawner);
    spawnerShop.setItem(12, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(13, sSpawner);
    spawnerShop.setItem(14, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(15, spSpawner);
    spawnerShop.setItem(16, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(17, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(18, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(19, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(20, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(21, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(22, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(23, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(24, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(25, new ItemStack(Material.STAINED_GLASS_PANE));
    spawnerShop.setItem(26, new ItemStack(Material.STAINED_GLASS_PANE));
  }
  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
    Player player = (Player)event.getWhoClicked();
    ItemStack clicked = event.getCurrentItem();
    Inventory inventory = event.getInventory();
    if (inventory.getName().equals(spawnerShop.getName()))
    {
      if (clicked == null) {
        return;
      }
      if (clicked.getType() == Material.STAINED_GLASS_PANE)
      {
        event.setCancelled(true);
        return;
      }
      if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Zombie Spawner")) {
        if (player.getInventory().contains(Material.EMERALD_BLOCK, 45))
        {
          ItemStack spSpawner = new ItemStack(Material.MOB_SPAWNER);
          ItemMeta spSpawnerMeta = spSpawner.getItemMeta();
          spSpawnerMeta.setDisplayName(Color.translate("&aSpawner"));
          ArrayList<String> spLore = new ArrayList();
          spLore.add(Color.translate("&fZombie"));
          spSpawnerMeta.setLore(spLore);
          spSpawner.setItemMeta(spSpawnerMeta);
          
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().addItem(new ItemStack[] { spSpawner });
          player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.EMERALD_BLOCK, 45) });
        }
        else
        {
          player.sendMessage(Color.translate("&cYou don't have enough emeralds."));
          event.setCancelled(true);
          player.closeInventory();
        }
      }
      if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Skeleton Spawner")) {
        if (player.getInventory().contains(Material.EMERALD_BLOCK, 45))
        {
          ItemStack spSpawner = new ItemStack(Material.MOB_SPAWNER);
          ItemMeta spSpawnerMeta = spSpawner.getItemMeta();
          spSpawnerMeta.setDisplayName(Color.translate("&aSpawner"));
          ArrayList<String> spLore = new ArrayList();
          spLore.add(Color.translate("&fSkeleton"));
          spSpawnerMeta.setLore(spLore);
          spSpawner.setItemMeta(spSpawnerMeta);
          
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().addItem(new ItemStack[] { spSpawner });
          player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.EMERALD_BLOCK, 45) });
        }
        else
        {
          player.sendMessage(Color.translate("&cYou don't have enough emeralds."));
          event.setCancelled(true);
          player.closeInventory();
        }
      }
      if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Spider Spawner")) {
        if (player.getInventory().contains(Material.EMERALD_BLOCK, 45))
        {
          ItemStack spSpawner = new ItemStack(Material.MOB_SPAWNER);
          ItemMeta spSpawnerMeta = spSpawner.getItemMeta();
          spSpawnerMeta.setDisplayName(Color.translate("&aSpawner"));
          ArrayList<String> spLore = new ArrayList();
          spLore.add(Color.translate("&fSpider"));
          spSpawnerMeta.setLore(spLore);
          spSpawner.setItemMeta(spSpawnerMeta);
          
          event.setCancelled(true);
          player.closeInventory();
          player.getInventory().addItem(new ItemStack[] { spSpawner });
          player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.EMERALD_BLOCK, 45) });
        }
        else
        {
          player.sendMessage(Color.translate("&cYou don't have enough emeralds."));
          event.setCancelled(true);
          player.closeInventory();
        }
      }
    }
  }
  
  @EventHandler(ignoreCancelled=false, priority=EventPriority.HIGH)
  public void onPlayerInteract(PlayerInteractEvent event)
  {
    if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) && 
      ((event.getClickedBlock().getState() instanceof Sign)))
    {
      Block block = event.getClickedBlock();
      BlockState state = block.getState();
      Sign sign = (Sign)state;
      String[] lines = sign.getLines();
      if (lines[1].contains(ChatColor.GREEN + "Spawner")) {
        event.getPlayer().openInventory(spawnerShop);
      }
    }
  }
}
