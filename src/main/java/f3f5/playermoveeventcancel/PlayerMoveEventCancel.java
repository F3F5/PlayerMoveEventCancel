package f3f5.playermoveeventcancel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerMoveEventCancel extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName().toLowerCase().contains("world")) {
//             if(player.getLocation().getBlockY() < 900){
//                 player.teleport(new Location(player.getWorld(), 0, 1000, 0));
            }
//            player.setWalkSpeed(0F);
            player.setFlySpeed(0F);
            player.setAllowFlight(true);
            player.setFlying(true);
        }
    }
    @EventHandler
    public void onTp(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        player.setHealth(player.getMaxHealth());
//        player.setWalkSpeed(0.2F);
    }
     @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
            if(event.getEntity().getWorld().getName().toLowerCase().contains("world")) {
                event.setCancelled(true);
//     }
//     @EventHandler
//     public void onJoin(PlayerJoinEvent event) {
//         Bukkit.getScheduler().scheduleSyncDelayedTask(this, ()  -> event.getPlayer().teleport(new Location(Bukkit.getWorld("world"), 0, 70, 27)), 100);
    }
}
