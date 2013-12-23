package jamie.src.hungergames;


import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin{
	
	 public void onEnable(){
			CommandManager cm = new CommandManager();
			cm.setup();
			getCommand("kit").setExecutor(cm);
	    }
	 
	    @Override
	    public void onDisable() {
	       
	    }
	
	  
	 
	    }
	    

