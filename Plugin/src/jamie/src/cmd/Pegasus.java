package jamie.src.cmd;

import org.bukkit.entity.Player;

public class Pegasus extends SubCommand{

	@Override
	public void onCommand(Player p, String[] args) {
		// TODO When Right clicks with a feather FLY also needs to broadcast a message to the game saying "Notice a pegasus is approaching he is not fly hacking"
		
	}

	@Override
	public String name() {
		return "Pegasus";
	}

	@Override
	public String info() {
		return "Pegasus";
	}

	@Override
	public String[] aliases() {
return null;
	}

}
