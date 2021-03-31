package be.garagepoort.tubingexample.broadcasting.gui;

import be.garagepoort.mcioc.IocBean;
import be.garagepoort.mcioc.IocCommandHandler;
import be.garagepoort.tubingexample.broadcasting.BroadcastingService;
import be.garagepoort.tubingexample.common.JavaUtils;
import be.garagepoort.tubingexample.common.MessageService;
import be.garagepoort.tubingexample.common.exceptions.BusinessException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

@IocBean
@IocCommandHandler("broadcast")
public class BroadcastCmd implements CommandExecutor {

    private final MessageService messageService;
    private final BroadcastingService broadcastingService;

    public BroadcastCmd(MessageService messageService, BroadcastingService broadcastingService) {
        this.messageService = messageService;
        this.broadcastingService = broadcastingService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        try {
            if(args.length < 1) {
                throw new BusinessException("Invalid arguments given for broadcast. Must provide a message");
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
