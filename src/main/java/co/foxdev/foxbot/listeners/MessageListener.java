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

import co.foxdev.foxbot.FoxBot;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class MessageListener extends ListenerAdapter<FoxBot>
{
    private final FoxBot foxbot;

    public MessageListener(FoxBot instance)
    {
        this.foxbot = instance;

        foxbot.getLogger().debug("Instantiated " + this.getClass().getName());
        // Register with the foxBot's ListenerManager.
	    foxbot.getConfiguration().getListenerManager().addListener(this);
	    foxbot.getLogger().debug("Registered " + this.getClass().getName() + " as a listener");
    }

    @Override
    public void onMessage(MessageEvent<FoxBot> event)
    {
	    foxbot.getLogger().debug("Received message: " + event.toString());
    }
}