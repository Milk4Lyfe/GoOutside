package org.milk4lyfe.goOutside.commands;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.milk4lyfe.goOutside.GoOutside;



public class enableCommand implements CommandExecutor {
    GoOutside plugin;
    public enableCommand(GoOutside plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        new BukkitRunnable() {

            @Override
            public void run() {
                if (player.getLocation().getBlock().getState().getLightLevel() <= 5) {
                    player.setHealth(0);
                }
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(String.valueOf(player.getLocation().getBlock().getState().getLightLevel())));
            }
        }.runTaskTimer(plugin, 0L, 20L); // Runs every tick (1L = 1 tick)

        return true;

    }
}
