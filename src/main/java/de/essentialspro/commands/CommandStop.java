package de.essentialspro.commands;

import de.essentialspro.EssentialsPro;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) {
            String reason = "";
            for (int i = 0; i < args.length; i++){
                reason += args[i] + " ";
            }

            if(reason != "") {
                String finalReason = reason;
                Bukkit.getOnlinePlayers().forEach(all -> all.kickPlayer("§c§lSERVER STOP\n\n§7Grund: §e" + finalReason));
                Bukkit.shutdown();
            } else {
                Bukkit.getOnlinePlayers().forEach(all -> all.kickPlayer("§c§lDer Server wurde gestoppt!"));
                Bukkit.shutdown();
            }
            return false;
        }

        Player player = (Player) commandSender;

        if(!(player.hasPermission("essentials.stop"))) {
            player.sendMessage(EssentialsPro.getUtilities().getPrefix() + "§cDu hast keine Berechtigung!");
            return false;
        }

        String reason = "";
        for (int i = 0; i < args.length; i++){
            reason += args[i] + " ";
        }

        if(reason != "") {
            String finalReason = reason;
            Bukkit.getOnlinePlayers().forEach(all -> all.kickPlayer("§c§lSERVER STOP\n\n§7Grund: §e" + finalReason));
            Bukkit.shutdown();
        } else {
            Bukkit.getOnlinePlayers().forEach(all -> all.kickPlayer("§c§lDer Server wurde gestoppt!"));
            Bukkit.shutdown();
        }
        return false;

    }
}
