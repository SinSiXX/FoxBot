/*
 * This file is part of FoxBot.
 *
 *     FoxBot is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     FoxBot is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with FoxBot.  If not, see <http://www.gnu.org/licenses/>.
 */

package co.foxdev.foxbot;

import co.foxdev.foxbot.listeners.MessageListener;
import co.foxdev.foxbot.permissions.PermissionManager;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.slf4j.Logger;

import java.awt.*;

public class FoxBot extends PircBotX
{
	private static PermissionManager permissionManager;
	private static FoxBot instance;

    public FoxBot(Configuration<? extends PircBotX> configuration)
    {
	    super(configuration);
	    instance = this;
        getLogger().debug("Instantiated " + this.getClass().getName());
    }

    public void start()
    {
        getLogger().info("Starting FoxBot " + getVersion());
        getLogger().debug("Running from " + this.getClass().getName());
        // Create a new permission manager
        permissionManager = new PermissionManager(this);
        // Create a new message listener.
        new MessageListener(this);

        _connect();
    }

    // Connect the bot
    private void _connect()
    {
        getLogger().warn("Server connection is not yet implemented!");
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
	 * Gets the bot's logger
	 *
	 * @return Bot logger
	 */
	public Logger getLogger()
	{
		return Main.logger;
	}

	/**
	 * Gets the bot permissions manager
	 *
	 * @return Permissions manager
	 */
	public PermissionManager getPermissionManager()
	{
		return permissionManager;
	}

	/**
	 * Gets the bot
	 *
	 * @return bot
	 */
	public static FoxBot getInstance()
	{
		return instance;
	}
}