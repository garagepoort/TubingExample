package be.garagepoort.tubingexample.broadcasting;

import be.garagepoort.mcioc.IocBean;
import be.garagepoort.tubingexample.common.permissions.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

@IocBean
public class BroadcastingService {

    private static final String BROADCAST_PERMISSION = "tubing-example.broadcast";
    private final PermissionManager permissionManager;

    public BroadcastingService(PermissionManager permissionManager) {
        this.permissionManager = permissionManager;
    }

    public void broadcast(CommandSender player, String message) {
        permissionManager.validatePermission(player, BROADCAST_PERMISSION);
        UUID uuid = player instanceof Player ? ((Player) player).getUniqueId() : UUID.randomUUID();
        BroadcastedMessage broadcastedMessage = new BroadcastedMessage(uuid, player.getName(), message);
        Bukkit.getPluginManager().callEvent(new MessageBroadcastedEvent(broadcastedMessage));
    }
}
