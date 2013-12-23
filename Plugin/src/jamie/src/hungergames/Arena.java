package jamie.src.hungergames;

import java.util.ArrayList;
import jamie.src.hungergames.ArenaManager.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class Arena implements Listener{

	private int id;
	private boolean started = false;
	private boolean cd = false;
	@SuppressWarnings("unused")
	private boolean test = false;
	@SuppressWarnings("unused")
	private boolean bluewin = false;
	@SuppressWarnings("unused")
	private boolean redwin = false;
	@SuppressWarnings("unused")
	private boolean remove = false;
	private Location redspawn, bluespawn;
	private ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	
	private Scoreboard sb;
	private Objective o;
	private Score red, blue;
	
	
	public Arena(int id) {
		this.id = id;
		
		ConfigurationSection conf = SettingsManager.getInstance().get(id + "");
		
		this.redspawn = getLocation(conf.getConfigurationSection("redspawn"));
		this.bluespawn = getLocation(conf.getConfigurationSection("bluespawn"));
		
		sb = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
		o = sb.registerNewObjective("Team Scores", "dummy");
		red = o.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.RED + "Red"));
		blue = o.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.BLUE + "Blue"));
	}
	
	private Location getLocation(ConfigurationSection path) {
		return new Location(
				Bukkit.getServer().getWorld(path.getString("world")),
				path.getDouble("x"),
				path.getDouble("y"),
				path.getDouble("z")
				);
	}
	
	public int getID() {
		return id;
	}
	
	public boolean isStarted() {
		return started;
	}
	
	public void setStarted(boolean started) {
		this.started = started;
	}
	
	public Location getSpawn(Team team) {
		switch(team) {
		case RED: return redspawn;
		case BLUE: return bluespawn;
		default: return null;
		}
	}
	
	public Team getTeam(Player p) {
		return getData(p).getTeam();
	}
	
	public void addPlayer(Player p) {
		players.add(new PlayerData(p.getName(), getTeamWithLessPlayers(), p.getInventory().getContents(), p.getInventory().getArmorContents(), p.getLocation()));
		
		p.getInventory().clear();
		p.getInventory().setHelmet(new Wool(DyeColor.valueOf(getData(p).getTeam().toString())).toItemStack(1));
		// Could add colored armor.
		
		p.teleport(getSpawn(getData(p).getTeam()));
		
		p.setScoreboard(sb);
		
		p.setGameMode(GameMode.ADVENTURE);
		p.setFlying(false);
		
		MessageManager.getInstance().info(p, "You have joined arena " + getID() + " and are on the " + ChatColor.valueOf(getData(p).getTeam().toString()) + getData(p).getTeam().toString().toLowerCase() + ChatColor.YELLOW + " team!");
		
		if (players.size() >= 2 && !cd) start();
		if (players.size() >= 3 && !cd) start();
		if (players.size() >= 4 && !cd) start();
		if (players.size() >= 5 && !cd) start();
		if (players.size() >= 6 && !cd) start();
		if (players.size() >= 7 && !cd) start();
		if (players.size() >= 8 && !cd) start();
		if (players.size() >= 9 && !cd) start();
		if (players.size() >= 10 && !cd) start();
		if (players.size() >= 11 && !cd) start();
		if (players.size() >= 12 && !cd) start();
		if (players.size() >= 13 && !cd) start();
		if (players.size() >= 14 && !cd) start();
		if (players.size() >= 15 && !cd) start();
		if (players.size() >= 16 && !cd) start();
		if (players.size() >= 17 && !cd) start();
		if (players.size() >= 18 && !cd) start();
		if (players.size() >= 19 && !cd) start();
		if (players.size() >= 20 && !cd) start();
		if (players.size() >= 21 && !cd) start();
		if (players.size() >= 22 && !cd) start();
		if (players.size() >= 23 && !cd) start();
		if (players.size() >= 24 && !cd) start();
		if (players.size() >= 0 && !cd) stop(null);
		if (test = true){
			p.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 16));
		}
	}
	public void removeTeam(Team team, boolean lost){
		if (red.getScore() == 100) {
			Arena.this.redwin = true;
			stop(null);
		}
		if (blue.getScore() == 100) {
			Arena.this.bluewin = true;
			stop(null);
		}
		removeTeam(team, true);
	}
	public void redwin(Player p, boolean redwin) {
		if (redwin = false){
			PlayerData pd = getData(p);
			
			p.getInventory().clear();
			for (ItemStack i : pd.getContents()) if (i != null) p.getInventory().addItem(i);
			p.getInventory().setArmorContents(pd.getArmorContents());
			
			p.teleport(pd.getLocation());
			
			p.setScoreboard(sb);
			
			players.remove(pd);
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Red has won a game find the open arena!");
		}
	}
		public void bluewin(Player p, boolean bluewin) {
			if (bluewin = true){
				PlayerData pd = getData(p);
				
				p.getInventory().clear();
				for (ItemStack i : pd.getContents()) if (i != null) p.getInventory().addItem(i);
				p.getInventory().setArmorContents(pd.getArmorContents());
				
				p.teleport(pd.getLocation());
				
				p.setScoreboard(null);
				
				players.remove(pd);
				Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Blue has won a game find the open arena!");
			}
	}
public void redewin(Player p, boolean redwin) {
	if (redwin = true){
		PlayerData pd = getData(p);
		
		p.getInventory().clear();
		for (ItemStack i : pd.getContents()) if (i != null) p.getInventory().addItem(i);
		p.getInventory().setArmorContents(pd.getArmorContents());
		
		p.teleport(pd.getLocation());
		
		p.setScoreboard(null);
		
		players.remove(pd);
		Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Blue has won a game find the open arena!");
	}
}
	
	public void removePlayer(Player p, boolean leave) {
		PlayerData pd = getData(p);
		
		p.getInventory().clear();
		for (ItemStack i : pd.getContents()) if (i != null) p.getInventory().addItem(i);
		p.getInventory().setArmorContents(pd.getArmorContents());
		
		p.teleport(pd.getLocation());
		
		p.setScoreboard(sb);
		
		players.remove(pd);
		
		if (leave) {
			MessageManager.getInstance().info(p, "You left the game!");
		}
	}
	
	public void start() {
		cd = true;
		msg("Game starting in 30 seconds!");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SettingsManager.getInstance().getPlugin(), new Runnable() {
			public void run() {
				msg("May The Games Begin!");
				Arena.this.started = true;
				Arena.this.cd = false;
				Arena.this.test = true;
			}
		}, 30 * 20);
	}
	
	public void stop(Player winner) {
		for (PlayerData pd : players) {
			Player p = Bukkit.getServer().getPlayer(pd.getPlayerName());
			Arena.this.started = false;
			Arena.this.test = false;
			removeTeam(getData(p).getTeam(), true);
		}
	}
	
	public void addDeath(Player p) {
		Team t = getTeam(p);
		if (t == Team.RED) blue.setScore(blue.getScore() + 1);
		else red.setScore(red.getScore() + 1);
	}
	
	private void msg(String msg) {
		for (PlayerData pd : players) {
			Player p = Bukkit.getServer().getPlayer(pd.getPlayerName());
			MessageManager.getInstance().info(p, msg);
		}
	}
	
	private Team getTeamWithLessPlayers() {
		int red = 0, blue = 0;
		for (PlayerData pd : players) {
			if (pd.getTeam() == Team.RED) red++;
			else blue++;
		}
		if (red > blue) return Team.BLUE;
		else return Team.RED;
	}
	
	public boolean containsPlayer(Player p) {
		return getData(p) != null;
	}
	
	private PlayerData getData(Player p) {
		for (PlayerData pd : players) {
			if (pd.getPlayerName().equalsIgnoreCase(p.getName())) return pd;
		}
		return null;
	}
		
}