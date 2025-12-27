package me.EthanBilbrey.WaterAndLavaSight;

import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WaterManager implements Listener
{
	public static Player player;
	public static Block lastBlock;
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) 
	{
		if(WaterManager.player != null && e.getPlayer().equals(WaterManager.player)) 
		{
			
			if(lastBlock != null 
					&& !lastBlock.getType().equals(Material.AIR) 
					&& !lastBlock.getType().equals(Material.END_PORTAL_FRAME) 
					&& !lastBlock.getType().equals(Material.DRAGON_EGG)
					&& !lastBlock.equals(WaterManager.player.getTargetBlock((Set<Material>) null, 30))) 
			{
				lastBlock.setType(Material.WATER);
				lastBlock = WaterManager.player.getTargetBlock((Set<Material>) null, 30);
			}
			else 
			{
				lastBlock = WaterManager.player.getTargetBlock((Set<Material>) null, 30);
			}
		}
	}
}
