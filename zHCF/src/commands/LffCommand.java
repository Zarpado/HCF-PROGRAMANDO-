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

public class LffCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
	  {
		  Player player = (Player)sender;
	    if (sender.hasPermission("zhcf.lff"))
	    {
	      if (arguments.length == 0)
	      {
	        sender.sendMessage("§cUsage: /lff (Razón)");
	      }
	      else
	      {
	        for (Player player1 : Bukkit.getServer().getOnlinePlayers()) {
	          player1.playSound(player1.getLocation(), Sound.NOTE_PIANO, 1.0F, 3.0F);
	        }
	        Bukkit.getServer().broadcastMessage("§6§m---------------------------------------------------------");
	        Bukkit.getServer().broadcastMessage("§b§l" + player.getName() + " §eEsta buscando faction");
	        Bukkit.getServer().broadcastMessage("§6§m---------------------------------------------------------");
	      }
	    }
	    else {
	    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().config.getString("messages.nopermission")));
	    }
	    return true;
	  }
}
