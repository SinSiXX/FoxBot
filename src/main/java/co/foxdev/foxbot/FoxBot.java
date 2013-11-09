package co.foxdev.foxbot;

import org.pircbotx.PircBotX;
import org.slf4j.Logger;

public abstract class FoxBot
{
    protected PircBotX instance;

    /**
     * Gets the actual instance of PircBotX that this bot is running
     *
     * @return PircBotX object
     */
    public PircBotX getInstance()
    {
        return instance;
    }

    /**
     * Gets the version of this bot instance
     *
     * @return Current bot version
     */
    public String getVersion()
    {
        return Main.VERSION;
    }

    /**
     * Gets the current bots logger
     *
     * @return Current bot logger
     */
    public Logger getLogger()
    {
        return Main.logger;
    }
}
