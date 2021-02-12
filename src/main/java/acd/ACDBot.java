package acd;

import com.mongodb.client.MongoDatabase;
import commands.*;
import events.GuildMemberJoin;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import util.activitytracker.AddPoints;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ACDBot {
    public static JDA jda;
    public static MongoDatabase database;
    public static void main(String[] args) throws Exception {
        String str = connect();
        jda = new JDABuilder(AccountType.BOT).setToken(str).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("Atheist Discord"));
        //database = dbConnect();
        registerListeners();
    }
    public static String connect() throws Exception {
        String path = ACDBot.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(path);
        File file = new File("config.dat");
        System.out.println(file.getAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(file));
        return br.readLine();
    }
    public static void registerListeners() {
        //Register Commands
        jda.addEventListener(new Clear());
        jda.addEventListener(new GetMemberInfo());
        jda.addEventListener(new PingPong());
        jda.addEventListener(new RoleMembers());
        jda.addEventListener(new Time());
        //Register Events
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new AddPoints());
    }
}
