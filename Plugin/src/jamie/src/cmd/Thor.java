package jamie.src.cmd;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Thor extends SubCommand{
	@Override
	public void onCommand(Player p, String[] args) {
		// Make it so that when player hits ground with wooden axe lightning happens
		
	}
public String name() {
	return "Archer";
}

public String info() {
	return "Skilled Arhcers Rule The Battlefield From The Hills";
}

@Override
public String[] aliases() {
return null;
}








}

