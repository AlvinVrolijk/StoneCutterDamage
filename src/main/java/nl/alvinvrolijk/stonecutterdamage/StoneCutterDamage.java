package nl.alvinvrolijk.stonecutterdamage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class StoneCutterDamage extends JavaPlugin implements Listener {

    public Logger logger = Logger.getLogger(getDescription().getName());

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                checkForPlayer(player);
            }
        }, 10L, 5L);

        logger.info("Plugin enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("Plugin disabled");
    }

    public void checkForPlayer(Player player) {
        if (player.getLocation().getBlock().getType().equals(Material.STONECUTTER)) {
            player.damage(1.5);
        }
    }
}
