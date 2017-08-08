package commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OresCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ores"))
    {
      if (args.length == 0)
      {
        sender.sendMessage("§7§m------§6§m*§7§m----§a " + player.getName() + "§7§m----§6§m*§7§m------");
        sender.sendMessage("§eYou have mined §a" + String.valueOf(new StringBuilder(String.valueOf(player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE))).append(" diamonds§e.").toString()));
        sender.sendMessage("§eYou have mined §a" + String.valueOf(new StringBuilder(String.valueOf(player.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE))).append(" iron ingots§e.").toString()));
        sender.sendMessage("§eYou have mined §a" + String.valueOf(new StringBuilder(String.valueOf(player.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE))).append(" gold ingots§e.").toString()));
        sender.sendMessage("§eYou have mined §a" + String.valueOf(new StringBuilder(String.valueOf(player.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE))).append(" redstone§e.").toString()));
        sender.sendMessage("§eYou have mined §a" + String.valueOf(new StringBuilder(String.valueOf(player.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE))).append(" lapis§e.").toString()));
        sender.sendMessage("§7§m------§6§m*§7§m-----------------§6§m*§7§m------");
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        
        sender.sendMessage("§7§m------§6§m*§7§m----§a " + target.getName() + "§7§m----§6§m*§7§m------");
        sender.sendMessage("§a " + target.getName() + "§e has mined §a" + String.valueOf(new StringBuilder(String.valueOf(target.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE))).append(" diamonds§e.").toString()));
        sender.sendMessage("§a " + target.getName() + "§e has mined §a" + String.valueOf(new StringBuilder(String.valueOf(target.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE))).append(" iron ingots§e.").toString()));
        sender.sendMessage("§a " + target.getName() + "§e has mined §a" + String.valueOf(new StringBuilder(String.valueOf(target.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE))).append(" gold ingots§e.").toString()));
        sender.sendMessage("§a " + target.getName() + "§e has mined §a" + String.valueOf(new StringBuilder(String.valueOf(target.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE))).append(" redstone§e.").toString()));
        sender.sendMessage("§a " + target.getName() + "§e has mined §a" + String.valueOf(new StringBuilder(String.valueOf(target.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE))).append(" lapis§e.").toString()));
        sender.sendMessage("§7§m------§6§m*§7§m-----------------§6§m*§7§m------");
      }
    }
    return false;
  }
}