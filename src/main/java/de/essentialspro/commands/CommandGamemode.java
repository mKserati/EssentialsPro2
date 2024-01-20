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
            if(!(args.length != 1)) {
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
                GameMode gameMode = GameMode.valueOf(gArgument.toUpperCase());
                Player target = Bukkit.getPlayerExact(name);
                target.setGameMode(gameMode);
                target.sendMessage(EssentialsPro.getUtilities().getPrefix() + "Dein §eSpielmodus §7hat sich verändert!");
                commandSender.sendMessage("Spielmodus von " + name + " verändert!");
            } else {
                commandSender.sendMessage("Folgende Gamemodes verfügbar: 0/1/2/3 | survival,creative,adventure,spectator");
            }
        }

        Player player = (Player) commandSender;

        if(!(player.hasPermission("essentials.gamemode"))) {
            player.sendMessage(EssentialsPro.getUtilities().getPrefix() + "§cDu hast keine Berechtigung!");
            return false;
        }

        if(args.length == 1) {
            String gArgument = args[0];
            if(gArgument.equalsIgnoreCase("0") || gArgument.equalsIgnoreCase("survival") ||
                    gArgument.equalsIgnoreCase("1") || gArgument.equalsIgnoreCase("creative") ||
                    gArgument.equalsIgnoreCase("2") || gArgument.equalsIgnoreCase("adventure") ||
                    gArgument.equalsIgnoreCase("3") || gArgument.equalsIgnoreCase("spectator")) {
                gArgument = gArgument.replace("1", "creative").replace("2", "adventure").replace("3", "spectator").replace("0", "survival");
                GameMode gameMode = GameMode.valueOf(gArgument.toUpperCase());
                player.setGameMode(gameMode);
                player.sendMessage(EssentialsPro.getUtilities().getPrefix() + "Du hast deinen §eSpielmodus §7verändert!");
            } else {
                player.sendMessage(EssentialsPro.getUtilities().getPrefix() + "Folgende Gamemodes verfügbar: 0/1/2/3 | survival,creative,adventure,spectator");
            }
        } else if(args.length == 2){
            String gArgument = args[0];
            String name = args[1];
            System.out.println(args[0] + " : " + args[1]);
            if(Bukkit.getPlayerExact(name) != null) {
                Player target = Bukkit.getPlayerExact(name);
                if (gArgument.equalsIgnoreCase("0") || gArgument.equalsIgnoreCase("survival") ||
                        gArgument.equalsIgnoreCase("1") || gArgument.equalsIgnoreCase("creative") ||
                        gArgument.equalsIgnoreCase("2") || gArgument.equalsIgnoreCase("adventure") ||
                        gArgument.equalsIgnoreCase("3") || gArgument.equalsIgnoreCase("spectator")) {
                    gArgument = gArgument.replace("1", "creative").replace("2", "adventure").replace("3", "spectator").replace("0", "survival");
                    GameMode gameMode = GameMode.valueOf(gArgument.toUpperCase());
                    target.setGameMode(gameMode);
                    target.sendMessage(EssentialsPro.getUtilities().getPrefix() + "Dein §eSpielmodus §7wurde verändert!");
                    player.sendMessage(EssentialsPro.getUtilities().getPrefix() + "Du hast den §eSpielmodus §7 von §e" + name + " §7verändert!");
                } else {
                    player.sendMessage(EssentialsPro.getUtilities().getPrefix() + "Folgende Gamemodes verfügbar: 0/1/2/3 | survival,creative,adventure,spectator");
                }
            } else {
                player.sendMessage(EssentialsPro.getUtilities().getPrefix() + "§cSpieler ist nicht Online!");
            }
        } else {
            player.sendMessage(EssentialsPro.getUtilities().getPrefix() + "Verwende: /gm <0,1,2,3> <Spieler>");
            return false;
        }

        return false;
    }
}
