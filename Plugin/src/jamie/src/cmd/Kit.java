package jamie.src.cmd;

import jamie.src.hungergames.MessageManager;


import org.bukkit.entity.Player;


public class Kit extends SubCommand{
	
	

	public void onCommand(Player p, String[] args) {

	}
	
	
	
	public String name() {
		return "kit";
	}
	
	public String info() {
		return "Choose a kit.";
	}
	
	public String[] aliases() {
		return new String[] { "k" };
	}



}
