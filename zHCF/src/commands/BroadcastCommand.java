package commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.imarco.zhcf.Main;

public class BroadcastCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
  {
    if (sender.hasPermission("zhcf.broadcast"))
    {
      if (arguments.length == 0)
      {
        sender.sendMessage("§cUsage: /" + label + " <message...>");
      }
      else
      {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
          player.playSound(player.getLocation(), Sound.NOTE_PIANO, 1.0F, 3.0F);
        }
        Bukkit.getServer().broadcastMessage("§3§m---------------------------------------------------------");
        Bukkit.getServer().broadcastMessage("§c§lAlert:");
        Bukkit.getServer().broadcastMessage("  §b" + StringUtils.join(arguments, ' '));
        Bukkit.getServer().broadcastMessage("§3§m---------------------------------------------------------");
      }
    }
    else {
    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().config.getString("messages.nopermission")));
    }
    return true;
  }
}
