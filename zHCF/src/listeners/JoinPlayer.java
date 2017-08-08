package listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import us.imarco.zhcf.Main;

public class JoinPlayer implements Listener {
	
	public static Main plugin;
	
	public void onJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		for(String joincmd : Main.getInstance().config.getStringList("join-message")){
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', joincmd));
		e.setJoinMessage(null);
		}
	}
}
