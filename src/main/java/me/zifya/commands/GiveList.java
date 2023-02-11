package me.zifya.commands;

import me.zifya.files.ModifyFile;
import me.zifya.files.ReadFile;
import me.zifya.main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.IOException;

public class GiveList extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String ID;
        User author = event.getMessage().getAuthor();

        if (args[0].equalsIgnoreCase(Main.prefix + "show")) {
            if (args.length == 2 ) {
                ID = args[1];
                if (ModifyFile.DoesFileExist(author.getName(), ID)) {
                    EmbedBuilder reply = new EmbedBuilder();
                    try {
                        reply.setTitle(ReadFile.returnNameValue(author.getName(), ID));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    reply.setDescription(ID);
                    try {
                        reply.addField("RAM", ReadFile.returnRAM(author.getName(), ID), false);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        reply.addField("CPU", ReadFile.returnCPU(author.getName(), ID), false);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        reply.addField("GPU", ReadFile.returnGPU(author.getName(), ID), false);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    reply.setColor(Color.BLUE);
                    reply.setThumbnail(author.getAvatarUrl());
                    event.getChannel().sendMessageEmbeds(reply.build()).queue();
                } else {
                    event.getChannel().sendMessage("Such list does not exist. Try creating one by doing ?create list ").queue();
                }
            } else {
                event.getChannel().sendMessage("Not enough arguments").queue();
            }
        }
    }
}
