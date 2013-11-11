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

package co.foxdev.foxbot.irc;

import co.foxdev.foxbot.FoxBot;
import co.foxdev.foxbot.common.Utils;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.UserChannelDao;

import java.util.List;

public class IUser extends User
{
    protected IUser(PircBotX bot, UserChannelDao<? extends User, ? extends Channel> dao, String nick)
    {
        super(bot, dao, nick);
    }

    /**
     * Checks whether or not the user has a permission
     *
     * @param permission The permission to check for
     * @return Whether or not the user has the permission
     */
    public boolean hasPermission(String permission)
    {
        return FoxBot.getPermissionManager().hasPermission(this, permission);
    }

    /**
     * Grants/denies a user access to a permission
     *
     * @param permission The permission to set
     * @param authorized Whether or not the user should have the permission
     */
    public void setPermission(String permission, boolean authorized)
    {
        FoxBot.getPermissionManager().setPermission(this, permission, authorized);
    }

    /**
     * Gets the user's prefix based on their channel mode
     *
     * @param channel The channel to get the prefix for
     * @return user's prefix
     */
    public String getPrefix(Channel channel)
    {
        return Utils.getPrefix(channel, this);
    }

     /**
     * Gets the user's permissions
     *
     * @return user's permissions
     */
    public List<String> getPermissions()
    {
        return FoxBot.getPermissionManager().getPermissions(this);
    }
}