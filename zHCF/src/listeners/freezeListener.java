package listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import commands.FreezeCommand;

public class freezeListener implements Listener {
	
	FreezeCommand frozen = new FreezeCommand();
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (FreezeCommand.ss.contains(p.getName())) {
			Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getBlockZ());
			frozen.frozen(p);
			p.teleport(loc);
			e.setTo(e.getFrom());
		}
	}

}
