package me.zifya.commands;

import me.zifya.files.DeleteFile;
import me.zifya.main.Main;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DeleteCommand extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event ) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        User author = event.getMessage().getAuthor();

        if (args[0].equalsIgnoreCase(Main.prefix + "remove")) {
            if (args.length == 2) {
                String ID = args[1];
                if (DeleteFile.DoesFileExist(author.getName(), ID)) {
                    DeleteFile.removefile(author.getName(), ID);
                    event.getChannel().sendMessage("List " + ID + " has successfully been deleted").queue();
                    event.getChannel().sendMessage(ID).queue();
                } else {
                    event.getChannel().sendMessage("No such Build exists").queue();
                }
            } else {
                event.getChannel().sendMessage("Please supply the correct arguments").queue();
            }
        }
    }
}
