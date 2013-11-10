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

import co.foxdev.foxbot.Bot;
import org.pircbotx.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermissionManager
{
    private Bot bot;
    private HashMap<User, List<String>> userPermissions = new HashMap<>();

    public PermissionManager(Bot instance)
    {
        this.bot = instance;
        bot.getLogger().debug("Instantiated " + this.getClass().getName());
    }

    public void setPermission(User user, String permission, boolean authorized)
    {
        if (authorized)
        {
            if (!userPermissions.containsKey(user))
            {
                // Add a new list of permissions for the user.
                userPermissions.put(user, new ArrayList<String>());
                userPermissions.get(user).add(permission);
                return;
            }
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
            {
                userPermissions.remove(user);
            }
        }
    }

    // Checks whether or not a user has access to a permission.
    public boolean hasPermission(User user, String permission)
    {
        boolean result = userPermissions.containsKey(user) && userPermissions.get(user).contains(permission);
        bot.getLogger().debug(String.format("Permission check on %s for %s returned %s", permission, user.getNick(), result));
        return userPermissions.containsKey(user) && userPermissions.get(user).contains(permission);
    }
}
