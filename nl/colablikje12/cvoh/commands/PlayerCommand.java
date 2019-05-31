package nl.colablikje12.cvoh.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.colablikje12.cvoh.utils.Common;

public abstract class PlayerCommand extends Command {

	protected PlayerCommand(String name) {
		super(name);
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			Common.tell(sender, "&4You must be a player to execute this command!");
			return false;
		}

		if (!sender.hasPermission("your.cool.plugin")) {
			Common.tell(sender, "&4You don't have permission to execute this command!");
			return false;
		}

		run((Player) sender, args);
		return true;
	}

	protected abstract void run(Player player, String[] args);

}

