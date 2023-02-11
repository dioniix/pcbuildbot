package me.zifya.commands;

import me.zifya.main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static me.zifya.files.ReadFile.*;

public class GiveLists extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split(" ");
        User author = event.getMessage().getAuthor();

        if (args[0].equalsIgnoreCase(Main.prefix + "lists")) {
            if (HaveLists(author.getName()) == true) {
                EmbedBuilder reply = new EmbedBuilder();
                reply.setTitle("All Available PC Lists");
                reply.setColor(Color.BLUE);
                reply.setThumbnail(author.getAvatarUrl());
                reply.setDescription("Created by " + author.getName());

                for (int i = 0 ; i < names(author.getName()).size(); i++) {
                    String value;
                    try {
                        value = returnNameValue(author.getName(), names(author.getName()).get(i).toString().replace(".properties", ""));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    reply.addField(value, names(author.getName()).get(i).toString().replace(".properties", " "), false);
                }

                event.getChannel().sendMessageEmbeds(reply.build()).queue();

            } else {
                event.getChannel().sendMessage("You have not created any lists. Try creating one by doing ?create ").queue();
            }
        }
    }
}
