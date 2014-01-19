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

import co.foxdev.foxbot.config.Config;
import co.foxdev.foxbot.exceptions.InviteOnlyException;
import co.foxdev.foxbot.listeners.MessageListener;
import co.foxdev.foxbot.permissions.PermissionManager;
import org.pircbotx.*;
import org.slf4j.Logger;

public class FoxBot extends PircBotX
{
	private static PermissionManager permissionManager;
	private static FoxBot foxbot;

    public FoxBot(Configuration<? extends PircBotX> configuration)
    {
	    super(configuration);
	    foxbot = this;
        getLogger().debug("Instantiated " + this.getClass().getName());
	    start();
    }

    private void start()
    {
        getLogger().info("Starting FoxBot " + getVersion());
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
		return Main.getLogger();
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
	 * Gets the bot configuration
	 *
	 * @return bot config
	 */
	public Config getConfig()
	{
		return Main.botConfig;
	}

	/**
	 * Attempts to join a specified channel
	 *
	 * @param channel The channel to join
	 * @throws InviteOnlyException
	 */
	public void join(String channel) throws InviteOnlyException
	{
		join(getUserChannelDao().getChannel(channel));
	}

	/**
	 * Attempts to join a specified channel
	 *
	 * @param channel The channel to join
	 * @throws InviteOnlyException
	 */
	public void join(Channel channel) throws InviteOnlyException
	{
		if (channel.isInviteOnly())
		{
			throw new InviteOnlyException(channel.getName() + " is invite only!");
		}
		getLogger().info("Joining " + channel);
		sendIRC().joinChannel(channel.getName());
	}

	// Reimplemented so I have control over logging.

	/**
	 * Leaves a channel
	 *
	 * @param channel channel to leave
	 */
	public void part(String channel)
	{
		part(getUserChannelDao().getChannel(channel));
	}

	/**
	 * Leaves a channel
	 *
	 * @param channel channel to leave
	 */
	public void part(Channel channel)
	{
		if (getUserBot().getChannels().contains(channel))
		{
			getLogger().info("Parting " + channel.getName());
			sendRaw().rawLineNow("PART " + channel.getName());
		}
	}

	/**
	 * Rapidly leaves and then joins a channel
	 *
	 * @param channel channel to cycle
	 */
	public void cycle(Channel channel)
	{
		cycle(channel.getName());
	}

	/**
	 * Rapidly leaves and then joins a channel
	 *
	 * @param channel channel to cycle
	 */
	public void cycle(String channel)
	{
		if (getUserBot().getChannels().contains(getUserChannelDao().getChannel(channel)))
		{
			getLogger().info("Attempting to cycle " + channel);
			part(channel);

			try
			{
				join(channel);
			}
			catch (InviteOnlyException ex)
			{
				getLogger().warn(channel + " is invite only, cannot rejoin!");
			}
		}
	}

	/**
	 * Gets the bot
	 *
	 * @return bot
	 */
	public static FoxBot getInstance()
	{
		return foxbot;
	}
}