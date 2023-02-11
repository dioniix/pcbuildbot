package me.zifya.commands;

import me.zifya.files.CreateFile;
import me.zifya.main.Main;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CreateCommand extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        User author = event.getMessage().getAuthor();

        if (!event.getMessage().isFromGuild()) return;
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (event.getMessage().getMember().getUser().isBot()) {
            return;
        }

        if (args[0].equalsIgnoreCase(Main.prefix + "hello")) {
            event.getChannel().sendMessage("yo").queue();
        }

        if (args[0].equalsIgnoreCase(Main.prefix + "create")) {
            if (args.length > 2 && args[1].equalsIgnoreCase("list")) {
                String gamebuild = null;
                for (int i = 2; i < args.length; i++) {
                    gamebuild = sb.append(args[i] + " ").toString();
                }
                int uniqueID = r.nextInt(9999);
                event.getChannel().sendMessage("Your new PC Build called: " + "**" + gamebuild + "**" + "[ID: " + uniqueID + "]" + " has been created").queue();
                try {
                    CreateFile.CreateFile(author.getName(), uniqueID, gamebuild, author.getIdLong());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                event.getChannel().sendMessage("What the fuck are you trying to create anyway").queue();
            }
        }


    }
}
