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

package co.foxdev.foxbot.permissions;

import co.foxdev.foxbot.FoxBot;
import org.pircbotx.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PermissionManager
{
    private FoxBot foxbot;
    private HashMap<User, List<String>> userPermissions = new HashMap<>();

    public PermissionManager(FoxBot instance)
    {
        this.foxbot = instance;
        foxbot.getLogger().debug("Instantiated " + this.getClass().getName());
    }

	/**
	 * Sets a user's access to a permission
	 *
	 * @param user The user to set the permission for
	 * @param permission The permission to set
	 * @param authorized State of the permission. True to set, false to unset.
	 */
	public void setPermission(String user, String permission, boolean authorized)
	{
		setPermission(foxbot.getUserChannelDao().getUser(user), permission, authorized);
	}

	/**
	 * Sets a user's access to a permission
	 *
	 * @param user The user to set the permission for
	 * @param permission The permission to set
	 * @param authorized State of the permission. True to set, false to unset.
	 */
    public void setPermission(User user, String permission, boolean authorized)
    {
        if (authorized)
        {
            // Add a new list of permissions for the user.
            if (!userPermissions.containsKey(user))
                userPermissions.put(user, Arrays.asList(permission));

            // Prevent duplicates.
            if (!userPermissions.get(user).contains(permission))
                userPermissions.get(user).add(permission);
            return;
        }
        // Authorized is false.
        if (userPermissions.containsKey(user))
        {
            // Remove the user's access to the permission.
            if (userPermissions.get(user).contains(permission))
                userPermissions.get(user).remove(permission);

            // Remove the user if they have no permissions.
            if (userPermissions.get(user).isEmpty())
                userPermissions.remove(user);
        }
    }

	/**
	 * Checks whether a user has access to a permission
	 *
	 * @param user The user to check permission for
	 * @param permission The permission to check for
	 * @return whether the user has the permission
	 */
	public boolean hasPermission(String user, String permission)
	{
		return hasPermission(foxbot.getUserChannelDao().getUser(user), permission);
	}

	/**
	 * Checks whether a user has access to a permission
	 *
	 * @param user The user to check permission for
	 * @param permission The permission to check for
	 * @return whether the user has the permission
	 */
    public boolean hasPermission(User user, String permission)
    {
        boolean result = userPermissions.containsKey(user) && userPermissions.get(user).contains(permission);

        foxbot.getLogger().debug(String.format("Permission check on %s for %s returned %s", permission, user.getNick(), result));
        return result;
    }

	/**
	 * Gets a list of permissions a user has
	 *
	 * @param user The user to get permissions for
	 * @return list of permissions
	 */
	public List<String> getPermissions(String user)
	{
		return getPermissions(foxbot.getUserChannelDao().getUser(user));
	}

	/**
	 * Gets a list of permissions a user has
	 *
	 * @param user The user to get permissions for
	 * @return list of permissions
	 */
    public List<String> getPermissions(User user)
    {
        return userPermissions.get(user);
    }
}