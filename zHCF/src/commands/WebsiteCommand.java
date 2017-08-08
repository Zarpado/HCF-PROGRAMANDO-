package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.imarco.zhcf.Main;

public class WebsiteCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(!sender.hasPermission("zhcf.website")){
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().config.getString("messages.nopermission")));
			return true;
		}
		for(String websitecmd : Main.getInstance().config.getStringList("website")){
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', websitecmd));
		}
		return false;
	}
}

