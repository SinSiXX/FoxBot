package co.foxdev.foxbot;

import co.foxdev.foxbot.listeners.MessageListener;
import org.pircbotx.PircBotX;

public class Bot extends FoxBot
{
    private PircBotX instance;

    public Bot()
    {
        this.start();
    }

    protected void start()
    {
        getLogger().info("Starting FoxBot " + getVersion());
        getLogger().debug("Running from " + this.getClass().getName());
        new MessageListener(this);
    }

    public PircBotX getInstance()
    {
        return instance;
    }
}
