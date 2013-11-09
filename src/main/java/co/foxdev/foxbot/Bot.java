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
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;


public class Bot extends FoxBot
{
    private Configuration.Builder<PircBotX> configBuilder;

    public Bot()
    {
        this.start();
    }

    protected void start()
    {
        getLogger().info("Starting FoxBot " + getVersion());
        getLogger().debug("Running from " + this.getClass().getName());
        // Create a new message listener.
        new MessageListener(this);
        // Set up the bot.
        setup();
        // Start the bot.
        connect();
    }

    // Sets the bot up ready for connection.
    private void setup()
    {
        getLogger().warn("Bot setup is not yet implemented!");
    }

    // Connects the bot to a server.
    private void connect()
    {
        getLogger().warn("Server connection is not yet implemented!");
    }
}
