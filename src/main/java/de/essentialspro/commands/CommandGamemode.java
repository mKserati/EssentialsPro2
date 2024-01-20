package de.essentialspro.commands;

import de.essentialspro.EssentialsPro;
import de.essentialspro.utils.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) {
            if(!(args.length != 2)) {
                commandSender.sendMessage("Benutze: gamemode [Spieler] [0/1/2/3]");
                return false;
            }

            String name = args[0];

            if(Bukkit.getPlayerExact(name) == null) {
                commandSender.sendMessage("Spieler nicht online");
                return false;
            }

            String gArgument = args[1];
            if(gArgument.equalsIgnoreCase("0") || gArgument.equalsIgnoreCase("survival") ||
                    gArgument.equalsIgnoreCase("1") || gArgument.equalsIgnoreCase("creative") ||
                    gArgument.equalsIgnoreCase("2") || gArgument.equalsIgnoreCase("adventure") ||
                    gArgument.equalsIgnoreCase("3") || gArgument.equalsIgnoreCase("spectator")) {
                gArgument = gArgument.replace("1", "creative").replace("2", "adventure").replace("3", "spectator").replace("0", "survival");
                GameMode gameMode = GameMode.valueOf(gArgument);
                Player target = Bukkit.getPlayerExact(name);
                target.setGameMode(gameMode);
                target.sendMessage(EssentialsPro.getUtilities().getPrefix() + "Dein §eSpielmodus §7hat sich verändert!");
                commandSender.sendMessage("Spielmodus von " + name + " verändert!");
            } else {
                commandSender.sendMessage("Folgende Gamemodes verfügbar: 0/1/2/3 | survival,creative,adventure,spectator");
            }
        }

        return false;
    }
}
