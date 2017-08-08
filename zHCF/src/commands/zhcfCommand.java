package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import us.imarco.zhcf.Main;

public class zhcfCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(!sender.hasPermission("zhcf.zhcf")){
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().config.getString("messages.nopermission")));
			return true;
		}
		if(args.length == 0){
			p.sendMessage("§3§l-----------------------------------");
			p.sendMessage("§b§l[zHCF]§3§lAuthor iMarco");
			p.sendMessage("§b§l[zHCF]§3§lVersion 0.1");
			p.sendMessage("§3§l-----------------------------------");
		}else
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("author")){
					p.sendMessage("§3§lAuthor: iMarco");
				}
				if(args[0].equalsIgnoreCase("Version")){
					p.sendMessage("§3§lVersion: 0.1-RELEASE");
				}	
			}
		return false;
	}
}
