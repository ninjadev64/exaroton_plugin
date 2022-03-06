package com.amansprojects.exaroton_plugin;

import com.exaroton.api.APIException;
import com.exaroton.api.ExarotonClient;
import com.exaroton.api.server.Server;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {
    ExarotonClient exarotonClient;
    Server server;
    public CommandHandler(ExarotonClient client, Server constructorServer) {
        exarotonClient = client;
        server = constructorServer;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("credits")) {
            try {
                sender.sendMessage(ChatColor.GREEN + "There are " + exarotonClient.getAccount().getCredits() + " credits in the server owner's account!");
                return true;
            } catch (APIException e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + "An error occurred! Check the server console for more details.");
            }
        }
        else if (label.equalsIgnoreCase("port")) {
            sender.sendMessage((ChatColor.GREEN + "The server port is " + server.getPort() + "!"));
            return true;
        }
        else if (label.equalsIgnoreCase("publishlog")) {
            try {
                sender.sendMessage(ChatColor.GREEN + "Your server log is shared at " + server.shareLog().getUrl() + "!");
                return true;
            } catch (APIException e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + "An error occurred! Check the server console for more details.");
            }
        }
        return false;
    }
}
