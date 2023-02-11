package me.zifya.main;

import me.zifya.commands.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static final String prefix = "?";

    public static void main(String[] args) throws LoginException {
        JDABuilder jda = JDABuilder.createDefault("MTA2NzA4NTk5ODUyMzE3MDg1Nw.GRWitN.dN2r9QNgyWqgw4Cruz88322xLc2jEtMgzwqprQ");
        jda.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        jda.addEventListeners(new CreateCommand());
        jda.addEventListeners(new SetPartsCommand());
        jda.addEventListeners(new GiveLists());
        jda.addEventListeners(new DeleteCommand());
        jda.addEventListeners(new GiveList());
        jda.build();


    }
}
