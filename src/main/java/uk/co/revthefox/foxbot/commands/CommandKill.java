package uk.co.revthefox.foxbot.commands;

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.events.MessageEvent;
import uk.co.revthefox.foxbot.FoxBot;

public class CommandKill extends Command
{

    private FoxBot foxbot;

    public CommandKill(FoxBot foxbot)
    {
        super("kill", "command.kill");
        this.foxbot = foxbot;
    }

    @Override
    public void execute(final MessageEvent event, final String[] args)
    {
        User sender = event.getUser();
        PircBotX bot = foxbot.getBot();

        if (args.length != 0)
        {
            bot.sendNotice(sender, String.format("Wrong number of args! Use %skill", foxbot.getConfig().getCommandPrefix()));
            return;
        }

        for (Channel botChannel : bot.getChannels())
        {
            bot.partChannel(botChannel, "Killed by " + sender.getNick());
        }

        foxbot.getDatabase().disconnect();
        bot.disconnect();
    }
}
