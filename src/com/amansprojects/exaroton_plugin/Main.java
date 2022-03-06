package com.amansprojects.exaroton_plugin;

import com.exaroton.api.APIException;
import com.exaroton.api.ExarotonClient;
import com.exaroton.api.server.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    ExarotonClient exarotonClient;
    Server server;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        exarotonClient = new ExarotonClient(getConfig().getString("token"));
        server = exarotonClient.getCurrentServer();
        try { server.get(); } catch (APIException e) { e.printStackTrace(); }
        CommandHandler commandHandler = new CommandHandler(exarotonClient, server);
        getCommand("credits").setExecutor(commandHandler);
        getCommand("port").setExecutor(commandHandler);
        getCommand("dynip").setExecutor(commandHandler);
        getCommand("publishlog").setExecutor(commandHandler);
        getLogger().info("The UNOFFICIAL exaroton plugin has successfully loaded!");
    }
}
