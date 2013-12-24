package jamie.src.cmd;

import org.bukkit.entity.Player;

public class Logger extends SubCommand {

	@Override
	public void onCommand(Player p, String[] args) {
		// TODO Chop Down tree's with one chop at the bottom
		
	}

	@Override
	public String name() {
		return "Logger";
	}

	@Override
	public String info() {
		return "Chop Trees With one mighty blow";
	}

	@Override
	public String[] aliases() {
	
		return null;
	}

}
