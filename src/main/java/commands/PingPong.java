package commands;

import acd.ConfigVars;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingPong extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s");
        if (args[0].equalsIgnoreCase(ConfigVars.getPrefix() + "ping")) {
            if (!event.getAuthor().isBot()) {
                long time = System.currentTimeMillis();
                event.getChannel().sendMessage("Pong").queue(response ->
                        response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue());
            }
        }
    }
}