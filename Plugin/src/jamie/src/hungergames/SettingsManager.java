package jamie.src.hungergames;
import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingsManager {

	private SettingsManager() { }
	
	private static SettingsManager instance = new SettingsManager();
	
	public static SettingsManager getInstance() {
		return instance;
	}
	
	private Plugin p;
	private FileConfiguration arenas;
	private File afile;
	private File cfile;
	private Plugin plugin;
	private FileConfiguration lobby;
	
	public void setup(Plugin p) {
		this.p = p;
		
		if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();
		
		afile = new File(p.getDataFolder(), "arenas.yml");
		
		boolean n = false;
		
		if (!afile.exists()) {
			try { afile.createNewFile(); n = true; }
			catch (Exception e) { e.printStackTrace(); }
		}
		
		arenas = YamlConfiguration.loadConfiguration(afile);
		
		if (n) set("ids", new ArrayList<String>());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String path) {
		return (T) arenas.get(path);
	}
	
	public void set(String path, Object value) {
		arenas.set(path, value);
		save();
	}
	
	public ConfigurationSection createConfigurationSection(String path) {
		ConfigurationSection s = arenas.createSection(path);
		save();
		return s;
	}
	
	private void save() {
		try { arenas.save(afile); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public Plugin getPlugin() {
		return p;
	}
	// Now this is the Lobbies
	public void setup1(Plugin plugin) {
		this.plugin = plugin;
		
		if (!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdir();
		
		cfile = new File(p.getDataFolder(), "Lobby.yml");
		
		boolean n = false;
		
		if (!cfile.exists()) {
			try { cfile.createNewFile(); n = true; }
			catch (Exception e) { e.printStackTrace(); }
		}
		
		arenas = YamlConfiguration.loadConfiguration(afile);
		
		if (n) set("lobbies", new ArrayList<String>());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get1(String path) {
		return (T) lobby.get(path);
	}
	
	public void set1(String path, Object value) {
		lobby.set(path, value);
		save();
	}
	
	public ConfigurationSection createConfigurationSection1(String path) {
		ConfigurationSection s = lobby.createSection(path);
		save();
		return s;
	}
	
	@SuppressWarnings("unused")
	private void save1() {
		try { lobby.save(cfile); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public Plugin getPlugin1() {
		return plugin;
	}
}