package commands;

import static org.bukkit.ChatColor.DARK_BLUE;
import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor{
	
	public static String prefix = RED + "[Report] ";
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
        if(cmd.getName().equalsIgnoreCase("report")){
                if(!(sender instanceof Player)){
                        sender.sendMessage(prefix + "Only players can use this command!");
                        return true;
                }
                if(args.length >= 2){
                        Player target = sender.getServer().getPlayer(args[0]);
                        if(target == null){
                                sender.sendMessage(prefix + "Player " + args[0] + " §cnot found!");
                        }else{
                                String reason = "";
                                int x = 0;
                                for (String a : args){
                                        if(x == 0){
                                                x++;
                                                continue;
                                        }
                                        reason = reason + " " + a;
                                }
                                reason = reason.trim();
                                sender.sendMessage(prefix + "§8Report sent!");
                                for (Player p : Bukkit.getServer().getOnlinePlayers()){
                                        if(p.hasPermission("zhcf.report.see")){
                                                p.sendMessage(prefix + sender.getName() + " §chas reported " + target.getName() + " §cfor the reason: " + reason);
                                        }
                                }
                        }
                }else{
                        sender.sendMessage(prefix + "§cUsage: /report <player> <reason>");
                }
        }
        return true;
}
}

