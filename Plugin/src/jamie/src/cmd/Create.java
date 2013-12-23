package jamie.src.cmd;

import java.util.List;

import jamie.src.hungergames.ArenaManager;
import jamie.src.hungergames.MessageManager;

import org.bukkit.entity.Player;

public class Create extends SubCommand {

	public void onCommand(Player p, String[] args) {
		if (!(p.isOp())) return;
		int id = jamie.src.hungergames.ArenaManager.getInstance().getArenas().size() + 1;
		
		jamie.src.hungergames.SettingsManager.getInstance().createConfigurationSection(id + "");
		List<Integer> ids = jamie.src.hungergames.SettingsManager.getInstance().<List<Integer>>get("ids");
		ids.add(id);
		jamie.src.hungergames.SettingsManager.getInstance().set("ids", ids);
		
		MessageManager.getInstance().good(p, "Created Arena " + id + "!");
		
		ArenaManager.getInstance().setup();
	}
	
	public String name() {
		return "create";
	}
	
	public String info() {
		return "Create an arena.";
	}
	
	public String[] aliases() {
		return new String[] { "c" };
	}
}