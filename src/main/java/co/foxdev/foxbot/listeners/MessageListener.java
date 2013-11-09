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
