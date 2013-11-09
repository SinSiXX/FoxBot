package co.foxdev.foxbot.listeners;

import co.foxdev.foxbot.Bot;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class MessageListener extends ListenerAdapter
{
    private final Bot bot;

    public MessageListener(Bot instance)
    {
        this.bot = instance;
        bot.getLogger().debug("Instantiated " + this.getClass().getName());
        // Register with the bot's ListenerManager.
        bot.getInstance().getConfiguration().getListenerManager().addListener(this);
        bot.getLogger().debug("Registered " + this.getClass().getName() + " as a listener");
    }

    @Override
    public void onMessage(MessageEvent event)
    {
        bot.getLogger().debug("Recieved message");
    }
}
