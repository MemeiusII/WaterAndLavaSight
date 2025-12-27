package me.EthanBilbrey.WaterAndLavaSight;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements CommandExecutor
{
	@Override
	public void onEnable() 
	{
		this.getCommand("setwater").setExecutor(this);
		this.getCommand("setlava").setExecutor(this);
		this.getCommand("setoff").setExecutor(this);
		getServer().getPluginManager().registerEvents(new WaterManager(), this);
		getServer().getPluginManager().registerEvents(new LavaManager(), this);
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player) 
		{
			Player player = (Player) sender;
			if(command.getName().equals("setwater")) 
			{
				if(LavaManager.player != null && LavaManager.player.equals(player)) 
				{
					LavaManager.player = null;
					WaterManager.player = player;
					player.sendMessage(ChatColor.BOLD + "Player set as water");
				}
				else 
				{
					WaterManager.player = player;
					player.sendMessage(ChatColor.BOLD + "Player set as water");
				}
			}
			else if(command.getName().equals("setlava")) 
			{
				if(WaterManager.player != null && WaterManager.player.equals(player)) 
				{
					WaterManager.player = null;
					LavaManager.player = player;
					player.sendMessage(ChatColor.BOLD + "Player set as lava");
				}
				else 
				{
					LavaManager.player = player;
					player.sendMessage(ChatColor.BOLD + "Player set as lava");
				}
			}
			else if(command.getName().equals("setoff")) 
			{
				WaterManager.player = null;
				LavaManager.player = null;
				player.sendMessage(ChatColor.BOLD + "Plugin turned off");
			}
		}
		
		return true;
	}
}
