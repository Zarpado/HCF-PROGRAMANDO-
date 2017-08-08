package ChatSystem;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_7_R4.World;

public class ChatSystem implements CommandExecutor{
	
	public boolean chatDisabled = false;
	public ArrayList<String> worlds = new ArrayList<String>();
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		World w = (World) p.getWorld();
		String world = w.toString();
		
		if (((chatDisabled) || (worlds.contains(world))) && (!p.hasPermission("zhcf.chatbypass"))) {
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Sorry, chat is disabled");
			return;
		}
	}
	
	public boolean onCommand(CommandSender s, Command cmd, String label,String[] arg){
		String noPerms = ChatColor.RED + "No have permissions";
		
		if(cmd.getName().equalsIgnoreCase("disablechat")) {
			if(s.hasPermission("zhcf.disablechat")) {
				chatDisabled = true;
				
				s.sendMessage(ChatColor.GOLD + "Disabled chat!");
				Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "Chat Disabled!");
				return true;
			}else {
				s.sendMessage(ChatColor.RED + noPerms);
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("enablechat")) {
			if (s.hasPermission("zhcf.enablechat")) {
				worlds.removeAll(worlds);
				chatDisabled = false;
				
				s.sendMessage(ChatColor.DARK_AQUA + "Chat enabled!");
				Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Chat enabled!");
			}else {
				s.sendMessage(ChatColor.RED + noPerms);
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("chatclear")) {
			if (s.hasPermission("zhcf.chatclear")) {
				for (int i = 0; i<54; i++) {
					Bukkit.broadcastMessage(" ");
				}
			}else {
				s.sendMessage(ChatColor.RED + noPerms);
				return true;
			}
		}
		return true;
	}

}
