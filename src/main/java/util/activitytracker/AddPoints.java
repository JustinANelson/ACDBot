package util.activitytracker;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AddPoints extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        //get user, guild, guildmember
        Guild guild = new Guild();
        guild.id = event.getMessage().getGuild().getIdLong();
        System.out.println(guild.id);
    }

}
