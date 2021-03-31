package be.garagepoort.tubingexample.common;

import be.garagepoort.mcioc.IocBean;
import org.bukkit.command.CommandSender;

import static org.bukkit.ChatColor.translateAlternateColorCodes;

@IocBean
public class MessageService {

    public void sendMessage(CommandSender player, String message) {
        player.sendMessage(translateAlternateColorCodes('&', message));
    }
}
