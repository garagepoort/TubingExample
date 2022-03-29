package be.garagepoort.tubingexample.broadcasting.gui;

import be.garagepoort.mcioc.IocCommandHandler;
import be.garagepoort.mcioc.configuration.ConfigProperty;
import be.garagepoort.mcioc.tubinggui.GuiActionService;
import be.garagepoort.tubingexample.broadcasting.BroadcastingService;
import be.garagepoort.tubingexample.common.JavaUtils;
import be.garagepoort.tubingexample.common.MessageService;
import be.garagepoort.tubingexample.common.exceptions.BusinessException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@IocCommandHandler("broadcast")
public class BroadcastCmd implements CommandExecutor {

    @ConfigProperty("tubing-example.broadcast-messages")
    private List<String> predefinedMessages;

    private final MessageService messageService;
    private final BroadcastingService broadcastingService;
    private final GuiActionService guiActionService;

    public BroadcastCmd(MessageService messageService, BroadcastingService broadcastingService, GuiActionService guiActionService) {
        this.messageService = messageService;
        this.broadcastingService = broadcastingService;
        this.guiActionService = guiActionService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        try {
            if (args.length < 1) {
                if (predefinedMessages.isEmpty() || !(sender instanceof Player)) {
                    throw new BusinessException("Invalid arguments given for broadcast. Must provide a message");
                } else {
                    guiActionService.executeAction((Player) sender, "broadcast/message-select");
                    return true;
                }
            }

            String message = JavaUtils.compileWords(args, 0);
            broadcastingService.broadcast(sender, message);
            return true;
        } catch (BusinessException e) {
            messageService.sendMessage(sender, "&6[Broadcasts] &C" + e.getMessage());
            return false;
        }
    }
}
