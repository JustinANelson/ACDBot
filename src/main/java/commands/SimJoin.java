package commands;

import acd.ConfigVars;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.requests.WebSocketClient;

import static acd.ACDBot.jda;

public class SimJoin extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s");
        if (args[0].equalsIgnoreCase(ConfigVars.getPrefix() + "simjoin")) {
            Guild guild = event.getGuild();
        }
    }
}