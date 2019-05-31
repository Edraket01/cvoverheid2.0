package nl.colablikje12.cvoh;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import nl.colablikje12.cvoh.commands.OverheidCommand;
import nl.colablikje12.cvoh.utils.Common;

public class CVOverheid extends JavaPlugin{

	public static ArrayList<String> gemeente = new ArrayList<String>();
	public static ArrayList<String> bouwbedrijf = new ArrayList<String>();
	public static ArrayList<String> politie = new ArrayList<String>();
	public static ArrayList<String> tech = new ArrayList<String>();
	public static ArrayList<String> inkoop = new ArrayList<String>();
	public static ArrayList<String> secret = new ArrayList<String>();
	public static ArrayList<String> belastingdienst = new ArrayList<String>();

	private static CVOverheid instance;

	@Override
	public void onEnable() {
		instance = this;

		// console
		Common.log("--------------------------------------");
		Common.log("             CVOverheid               ");
		Common.log("--------------------------------------");
		Common.log("Voorbereiden");
		Common.log("Bijna klaar");

		//supervanish
		if (!Bukkit.getPluginManager().isPluginEnabled("SuperVanish")) {
			Common.log("Error!");
			Common.log("Supervanish niet geinstalleerd");
			Common.log("Installeer SuperVanish: https://www.spigotmc.org/resources/supervanish-be-invisible.1331/");
			return;
		}

		Common.log("Klaar, Veel plezier!");;

		// register
		Common.registerCommand(new OverheidCommand());
	}

	@Override
	public void onDisable() {
		instance = null;
	}

	public static CVOverheid getInstance() {
		return instance;
	}


}
