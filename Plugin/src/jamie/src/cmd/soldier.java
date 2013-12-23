package jamie.src.cmd;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class soldier extends SubCommand{

	public void onCommand(Player p, String[] args) {
	      PlayerInventory pi = (PlayerInventory) p.getInventory();
	        if (!(p.hasPermission("soldier")));
	        pi.addItem(new ItemStack(Material.STONE_SWORD));

	}
	
	public String name() {
		return "Soldier";
	}
	
	public String info() {
		return "Soldier Class";
	}
	
	public String[] aliases() {
		return new String[] { "SC" };
	}
}

