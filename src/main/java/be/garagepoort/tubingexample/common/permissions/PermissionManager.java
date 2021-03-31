package be.garagepoort.tubingexample.common.permissions;

import be.garagepoort.mcioc.IocBean;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@IocBean
public class PermissionManager {

    public void validatePermission(CommandSender player, String permission) {
        if (!has(player, permission)) {
            throw new NoPermissionException();
        }
    }

    private boolean has(CommandSender player, String permission) {
        if (!(player instanceof Player)) {
            return true;
        }

        return player.hasPermission(permission) || player.isOp();
    }
}