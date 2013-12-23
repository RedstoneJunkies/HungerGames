package jamie.src.cmd;

import jamie.src.hungergames.Arena;
import jamie.src.hungergames.ArenaManager;
import jamie.src.hungergames.MessageManager;
import jamie.src.hungergames.SettingsManager;

import org.bukkit.entity.Player;

public class Delete extends SubCommand {

	public void onCommand(Player p, String[] args) {
		if (!(p.isOp())) return;
		if (args.length == 0) {
			MessageManager.getInstance().severe(p, "You must specify an arena number!");
			return;
		}
		
		int id = -1;
		
		try { id = Integer.parseInt(args[0]); }
		catch (Exception e) {
			MessageManager.getInstance().severe(p, args[0] + " is not a valid number!");
			return;
		}
		
		Arena a = ArenaManager.getInstance().getArena(id);
		
		if (a == null) {
			MessageManager.getInstance().severe(p, "There is no arena with ID " + id + "!");
			return;
		}
		
		if (a.isStarted()) {
			MessageManager.getInstance().severe(p, "Arena " + id + " is ingame!");
			return;
		}
		
		SettingsManager.getInstance().set(id + "", null);
		
		//TODO: Stop all games and broadcast!
		ArenaManager.getInstance().setup();
	}
	
	public String name() {
		return "delete";
	}
	
	public String info() {
		return "Delete an arena.";
	}
	
	public String[] aliases() {
		return new String[] { "d" };
	}
}