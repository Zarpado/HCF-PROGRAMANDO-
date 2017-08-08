package listeners;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FurnaceSmeltSpeederListener
  implements Listener
{
  @EventHandler(ignoreCancelled=false, priority=EventPriority.MONITOR)
  public void onPlayerInteract(PlayerInteractEvent event)
  {
    if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
    {
      Block block = event.getClickedBlock();
      BlockState state = block.getState();
      if ((state instanceof Furnace)) {
        ((Furnace)state).setCookTime((short) 10.0D);
      }
    }
  }
}