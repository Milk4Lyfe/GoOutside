package org.milk4lyfe.goOutside;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import org.milk4lyfe.goOutside.commands.enableCommand;

public final class GoOutside extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("goOutside").setExecutor(new enableCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
