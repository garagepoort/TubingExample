<#assign URLEncoder=statics['java.net.URLEncoder']>
<TubingGui size="54" id="broadcast-message-select">
    <title class="gui-title">Select message to broadcast</title>

    <#list messages as message >
        <GuiItem id="broadcast-message-${message?index}"
                 class="broadcast-message"
                 slot="${message?index}"
                 material="PAPER"
                 onLeftClick="broadcast/send-message?message=${URLEncoder.encode(message)}">
            <name class="item-name">${message}</name>
        </GuiItem>
    </#list>
</TubingGui>
