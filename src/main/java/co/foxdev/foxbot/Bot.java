package co.foxdev.foxbot;

import co.foxdev.foxbot.listeners.MessageListener;

public class Bot extends FoxBot
{
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
}
