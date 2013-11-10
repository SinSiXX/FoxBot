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

import co.foxdev.foxbot.permissions.PermissionManager;
import org.pircbotx.PircBotX;
import org.slf4j.Logger;

public abstract class FoxBot
{
    protected static PircBotX instance;
    protected static PermissionManager permissionManager;

    /**
     * Gets the actual instance of PircBotX that this bot is running
     *
     * @return PircBotX object
     */
    public static PircBotX getInstance()
    {
        return instance;
    }

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

    /**
     * Gets the current bots logger
     *
     * @return Current bot logger
     */
    public static PermissionManager getPermissionManager()
    {
        return permissionManager;
    }
}
