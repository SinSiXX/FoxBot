package co.foxdev.foxbot;

import org.slf4j.Logger;

public abstract class FoxBot
{
    /**
     * Gets the version of this bot instance
     *
     * @return Current bot version
     */
    public static String getVersion()
    {
        return Main.VERSION;
    }

    /**
     * Gets the current bots logger
     *
     * @return Current bot logger
     */
    public static Logger getLogger()
    {
        return Main.logger;
    }
}
