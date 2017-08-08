package us.imarco.zhcf;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ChatSystem.ChatSystem;
import commands.BroadcastCommand;
import commands.CoordsCommand;
import commands.FreezeCommand;
import commands.HelpCommand;
import commands.LffCommand;
import commands.MessageCommand;
import commands.OresCommand;
import commands.ReplyCommand;
import commands.ReportCommand;
import commands.RulesCommand;
import commands.StoreCommand;
import commands.TeamspeakCommand;
import commands.WebsiteCommand;
import commands.zhcfCommand;
import listeners.AutoSmeltOreListener;
import listeners.FurnaceSmeltSpeederListener;
import listeners.SpawnerShopListener;
import listeners.freezeListener;
import utils.Color;

public class Main extends JavaPlugin implements  Listener{
	
	private static Main instance;
	public static FileConfiguration config;
	public static File conf;
	public static HashMap<Player, Player> lastmsg = new HashMap<Player, Player>();
	
	public void onEnable(){
		System.out.println("§czHCF Enable");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new freezeListener(), this);
		getServer().getPluginManager().registerEvents(new FurnaceSmeltSpeederListener(), this);
		getServer().getPluginManager().registerEvents(new SpawnerShopListener(), this);
		getServer().getPluginManager().registerEvents(new AutoSmeltOreListener(), this);
		instance = this;
		
		config = getConfig();
		config.options().copyDefaults(true);
		conf = new File(getDataFolder(), "config.yml");
		saveConfig();
		saveDefaultConfig();
		
		register();
	}
	
	public void onDisable(){
	    Bukkit.getConsoleSender().sendMessage(Color.translate("&7---------------------- &azHCF&7 ----------------------"));
	    Bukkit.getConsoleSender().sendMessage(Color.translate("&7* &eVersion: &a" + getDescription().getVersion() + "&e."));
	    Bukkit.getConsoleSender().sendMessage(Color.translate("&7* &ePlugin Status: &aActivated&e."));
	    Bukkit.getConsoleSender().sendMessage(Color.translate("&7---------------------------------------------------------"));
	}
	
	
	public void register(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		getCommand("zhcf").setExecutor(new zhcfCommand());
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("rules").setExecutor(new RulesCommand());
		getCommand("coords").setExecutor(new CoordsCommand());
		getCommand("teamspeak").setExecutor(new TeamspeakCommand());
		getCommand("store").setExecutor(new StoreCommand());
		getCommand("ores").setExecutor(new OresCommand());
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("disablechat").setExecutor(new ChatSystem());
		getCommand("enablechat").setExecutor(new ChatSystem());
		getCommand("chatclear").setExecutor(new ChatSystem());
		getCommand("msg").setExecutor(new MessageCommand());
		getCommand("r").setExecutor(new ReplyCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("freeze").setExecutor(new FreezeCommand());
		getCommand("lff").setExecutor(new LffCommand());
		getCommand("website").setExecutor(new WebsiteCommand());
	}
	
	public static Main getInstance(){
		return instance;
	}
}
