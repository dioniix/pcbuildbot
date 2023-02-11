package me.zifya.commands;

import me.zifya.files.ModifyFile;
import me.zifya.main.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;

public class SetPartsCommand extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event ) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        StringBuffer sb = new StringBuffer();
        String Name = event.getMessage().getAuthor().getName();

        if (args[0].equalsIgnoreCase(Main.prefix + "set")) {
            if (args.length > 1) {
                String ID = args[1];
                if (ModifyFile.DoesFileExist(Name, ID) == true) {
                    if (args[2].equalsIgnoreCase("ram")) {
                        String wholeram = null;
                        for (int i = 3; i < args.length; i++) {
                            wholeram = sb.append(args[i] + " ").toString();
                        }
                        try {
                            ModifyFile.ModifyFile(Name, ID, "RAM", wholeram);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        event.getChannel().sendMessage("Successfully set RAM to " + wholeram).queue();

                    } else if (args[2].equalsIgnoreCase("cpu")) {
                        String wholecpu = null;
                        for (int i = 3; i < args.length; i++) {
                            wholecpu = sb.append(args[i] + " ").toString();
                        }
                        try {
                            ModifyFile.ModifyFile(Name, ID, "CPU", wholecpu);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        event.getChannel().sendMessage("Successfully set CPU to " + wholecpu).queue();

                    } else if(args[2].equalsIgnoreCase("gpu")) {
                        String wholegpu = null;
                        for (int i = 3; i < args.length; i++) {
                            wholegpu = sb.append(args[i] + " ").toString();
                        }
                        try {
                            ModifyFile.ModifyFile(Name, ID, "GPU", wholegpu);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        event.getChannel().sendMessage("Successfully set GPU to " + wholegpu).queue();

                    } else {
                        event.getChannel().sendMessage("Unrecognized command").queue();
                    }
                } else {
                    event.getChannel().sendMessage("There is no such list with ID " + ID).queue();
                }
            } else {
                event.getChannel().sendMessage("Please provide arguements.").queue();
            }
        }
    }
}
