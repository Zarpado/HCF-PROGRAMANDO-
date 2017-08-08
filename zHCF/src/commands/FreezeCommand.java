package commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.imarco.zhcf.Main;

public class FreezeCommand implements CommandExecutor {
	
	public static ArrayList<String> ss = new ArrayList<> ();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)  sender;
		if (cmd.getName().equalsIgnoreCase("freeze") && (sender.hasPermission("zhcf.freeze"))) {
			if (args.length == 0) {
				p.sendMessage("§c» §aEspecifica el jugador");
				return true;
			}
			
			Player t = Bukkit.getServer().getPlayer(args[0]);
			
			if (t == null) {
				p.sendMessage("§cEste jugador no esta §4Online!");
				return true;
			}
			
			//if (t.equals(sender)) {
				//p.sendMessage("§cNo te puedes freezear ati mismo!");
				//return true;
			//}
			
			if (ss.contains(t.getName())) {
				ss.remove(t.getName());
				p.sendMessage("§c " + t.getName() + " fue un-frozeado!");
				frozen(p);
				return true;
			} else {
				ss.add(t.getName());
				p.sendMessage("§c " + t.getName() + " fue frozeado!");
				return true;
			}
			
		}
		return false;
	}
	
	public void frozen (Player player) {
		for(String freezecmd : Main.getInstance().config.getStringList("freeze")){
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', freezecmd));
	}
}

}
