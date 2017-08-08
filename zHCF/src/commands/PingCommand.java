package commands;

import java.util.Collections;
import java.util.List;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import utils.Color;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand
  implements CommandExecutor, TabCompleter
{
  public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
  {
    if (arguments.length > 1)
    {
      sender.sendMessage(Color.translate("&cUsage: /" + label + " <playerName>"));
      return true;
    }
    if (arguments.length == 0) {
      if ((sender instanceof Player)) {
        sender.sendMessage(Color.translate(new StringBuilder("&a").append(sender.getName()).append("'s ping is ").append(((CraftPlayer)sender).getHandle().ping).toString()) + "ms.");
      } else {
        sender.sendMessage(Color.translate("&cYou can not execute this command on console."));
      }
    }
    if (arguments.length == 1)
    {
      Player target = Bukkit.getServer().getPlayerExact(arguments[0]);
      if (target == null) {
        sender.sendMessage(Color.translate("&cPlayer named '" + arguments[0] + "' not found."));
      } else {
        sender.sendMessage(Color.translate(new StringBuilder("&a").append(target.getName()).append("'s ping is ").append(((CraftPlayer)target).getHandle().ping).toString()) + "ms.");
      }
    }
    return true;
  }
  
  public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] arguments)
  {
    if (arguments.length > 1) {
      return Collections.emptyList();
    }
    return null;
  }
}
