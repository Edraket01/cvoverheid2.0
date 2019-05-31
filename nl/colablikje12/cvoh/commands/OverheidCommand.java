package nl.colablikje12.cvoh.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.myzelyam.api.vanish.VanishAPI;
import nl.colablikje12.cvoh.CVOverheid;
import nl.colablikje12.cvoh.utils.Common;

public class OverheidCommand extends PlayerCommand{

	public OverheidCommand() {
		super("overheid");
		setAliases(Arrays.asList("oh"));
		setDescription("This is an example command.");
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void run (Player player, String[] args) {
		for (final Player p: Bukkit.getServer().getOnlinePlayers()) {
			final boolean isVanished = VanishAPI.isInvisible(p);

			if (p.hasPermission("cv.overheid.gemeente")) {
				if (isVanished == false)
				CVOverheid.gemeente.add(p.getName());
			}

			if (p.hasPermission("cv.overheid.bouwbedrijf")) {
				if (isVanished == false)
				CVOverheid.bouwbedrijf.add(p.getName());
			}

			if (p.hasPermission("cv.overheid.secret")) {
				if (isVanished == false)
				CVOverheid.secret.add(p.getName());
			}

			if (p.hasPermission("cv.overheid.politie")) {
				if (isVanished == false)
				CVOverheid.politie.add(p.getName());
			}

			if (p.hasPermission("cv.overheid.tech")) {
				if (isVanished == false)
				CVOverheid.tech.add(p.getName());
			}

			if (p.hasPermission("cv.overheid.belastingdienst")) {
				if (isVanished == false)
				CVOverheid.belastingdienst.add(p.getName());
			}

			if (p.hasPermission("cv.overheid.inkoop")) {
				if (isVanished == false)
				CVOverheid.inkoop.add(p.getName());
			}

			if (CVOverheid.inkoop.size() == 0)
				CVOverheid.inkoop.add("<geen>");

			if (CVOverheid.gemeente.size() == 0)
				CVOverheid.gemeente.add("<geen>");

			if (CVOverheid.tech.size() == 0)
				CVOverheid.tech.add("<geen>");

			if (CVOverheid.secret.size() == 0)
				CVOverheid.secret.add("<geen>");

			if (CVOverheid.politie.size() == 0)
				CVOverheid.politie.add("<geen>");

			if (CVOverheid.belastingdienst.size() == 0)
				CVOverheid.belastingdienst.add("<geen>");

			if (CVOverheid.bouwbedrijf.size() == 0)
				CVOverheid.bouwbedrijf.add("<geen>");


		}
		player.sendMessage(Common.colorize("&6&m---------------------------------------"));
		player.sendMessage(Common.colorize("&f&lOverheid lijst"));
		player.sendMessage(Common.colorize("&6Gemeente: &f" + CVOverheid.gemeente.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
		player.sendMessage(Common.colorize("&6Bouwbedrijf: &f" + CVOverheid.bouwbedrijf.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
		player.sendMessage(Common.colorize("&6Tech: &f" + CVOverheid.tech.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
		player.sendMessage(Common.colorize("&6Politie: &f" + CVOverheid.politie.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
		player.sendMessage(Common.colorize("&6Secret Service: &f" + CVOverheid.secret.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
		player.sendMessage(Common.colorize("&6Inkoop: &f" + CVOverheid.inkoop.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
		player.sendMessage(Common.colorize("&6Belastingdienst: &f" + CVOverheid.belastingdienst.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
		player.sendMessage(Common.colorize("&6&m---------------------------------------"));

		CVOverheid.gemeente.clear();
		CVOverheid.tech.clear();
		CVOverheid.inkoop.clear();
		CVOverheid.politie.clear();
		CVOverheid.belastingdienst.clear();
		CVOverheid.secret.clear();
		CVOverheid.bouwbedrijf.clear();




	}

}
