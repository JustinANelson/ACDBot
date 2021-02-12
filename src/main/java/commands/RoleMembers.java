package commands;

import acd.ConfigVars;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.Objects;

public class RoleMembers extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s");
        if (args[0].equalsIgnoreCase(ConfigVars.getPrefix() + "rm")) {
            StringBuilder strBNames = new StringBuilder();
            List<Role> guildRole = event.getGuild().getRolesByName(args[1], true);
            if (!guildRole.isEmpty()) {
                List<Member> members = event.getGuild().getMembersWithRoles(guildRole);
                strBNames.append("__" + args[1] + "__" + "\n");
                if (members.size() == 0) {
                    event.getChannel().sendMessage("No members with that role.");
                    return;
                }
                for (int x = 0; x < members.size(); x++) {
                    if (x == members.size() - 1) {
                        strBNames.append(members.get(x).getAsMention());
                    } else {
                        strBNames.append(members.get(x).getAsMention() + ", ");
                    }
                }
                event.getChannel().sendMessage(Objects.requireNonNull(strBNames)).queue();
            }
        }
    }
}
