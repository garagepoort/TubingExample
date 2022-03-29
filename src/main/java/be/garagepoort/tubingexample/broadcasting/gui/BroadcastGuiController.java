package be.garagepoort.tubingexample.broadcasting.gui;

import be.garagepoort.mcioc.configuration.ConfigProperty;
import be.garagepoort.mcioc.tubinggui.GuiAction;
import be.garagepoort.mcioc.tubinggui.GuiController;
import be.garagepoort.mcioc.tubinggui.GuiParam;
import be.garagepoort.mcioc.tubinggui.templates.GuiTemplate;
import be.garagepoort.tubingexample.broadcasting.BroadcastingService;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

import static be.garagepoort.mcioc.tubinggui.templates.GuiTemplate.template;

@GuiController
public class BroadcastGuiController {

    @ConfigProperty("tubing-example.broadcast-messages")
    private List<String> predefinedMessages;

    private final BroadcastingService broadcastingService;

    public BroadcastGuiController(BroadcastingService broadcastingService) {
        this.broadcastingService = broadcastingService;
    }

    @GuiAction("broadcast/message-select")
    public GuiTemplate viewMessageSelect() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("messages", predefinedMessages);
        return template("gui/broadcast/message-select.ftl", params);
    }

    @GuiAction("broadcast/send-message")
    public void sendMessage(Player player, @GuiParam("message") String message) {
        broadcastingService.broadcast(player, message);
    }
}
