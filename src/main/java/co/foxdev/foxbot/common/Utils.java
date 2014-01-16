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

package co.foxdev.foxbot.common;

import co.foxdev.foxbot.FoxBot;
import org.pircbotx.Channel;
import org.pircbotx.User;

public class Utils
{
	/**
	 * Gets a user's IRC prefix based on channel mode
	 *
	 * @param channel The channel used to check the user mode
	 * @param user The user to get the prefix for
	 * @return user's prefix
	 */
	public static String getPrefix(String channel, User user)
	{
		return getPrefix(FoxBot.getInstance().getUserChannelDao().getChannel(channel.startsWith("#") ? channel : "#" + channel), user);
	}

	/**
	 * Gets a user's IRC prefix based on channel mode
	 *
	 * @param channel The channel used to check the user mode
	 * @param user The user to get the prefix for
	 * @return user's prefix
	 */
    public static String getPrefix(Channel channel, User user)
    {
        if (channel.isOwner(user))
            return "~";
        if (channel.isSuperOp(user))
            return "&";
        if (channel.isOp(user))
            return "@";
        if (channel.isHalfOp(user))
            return "%";
        if (channel.hasVoice(user))
            return "+";
        return "";
    }
}