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
import joptsimple.*;
import org.slf4j.Logger;
import org.slf4j.impl.SimpleLogger;
import org.slf4j.impl.SimpleLoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main
{
    // Get the build version from the manifest.
    protected static final String VERSION = Main.class.getPackage().getImplementationVersion();
    protected static Logger logger;
    private static boolean debug = false;
	private static FoxBot foxBot;
	protected static Config botConfig;

    public static void main(String[] args)
    {
	    OptionParser parser = new OptionParser() {
		    {
			    acceptsAll(asList("h", "help"), "Prints help dialogue");
			    acceptsAll(asList("d", "debug"), "Enables finer logging");

			    acceptsAll(asList("s", "server"), "Server hostname")
			    .withRequiredArg()
			    .ofType(String.class)
			    .describedAs("host");

			    acceptsAll(asList("p", "port"), "Server port. Use + for SSL.")
			    .withRequiredArg()
			    .ofType(String.class)
			    .defaultsTo("6667")
			    .describedAs("[+]port");

			    acceptsAll(asList("n", "nick"), "Bot nick")
			    .withRequiredArg()
			    .ofType(String.class)
			    .defaultsTo("FoxBot")
			    .describedAs("nick");

			    acceptsAll(asList("i", "ident"), "Bot ident")
			    .withRequiredArg()
			    .ofType(String.class)
			    .defaultsTo("bot")
			    .describedAs("ident");

			    acceptsAll(asList("r", "realname"), "Bot realname")
			    .withRequiredArg()
			    .ofType(String.class)
			    .defaultsTo("FoxBot")
			    .describedAs("realname");
		    }
	    };

	    OptionSet options = null;

	    try
	    {
		    options = parser.parse(args);
	    }
	    catch (OptionException ex)
	    {
	    }

	    if (options == null || options.has("h"))
	    {
		    try
		    {
			    parser.printHelpOn(System.out);
		    }
		    catch (IOException ex)
		    {
			    ex.printStackTrace();
		    }
		    return;
	    }

	    if (options.has("s"))
	    {
	    }

	    if (options.has("d"))
	    {
		    debug = true;
	    }

        // Set logger properties.
        System.setProperty(SimpleLogger.SHOW_DATE_TIME_KEY, "true");
        System.setProperty(SimpleLogger.DATE_TIME_FORMAT_KEY, "[HH:mm:ss]");
        System.setProperty(SimpleLogger.SHOW_THREAD_NAME_KEY, "false");
        System.setProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
        System.setProperty(SimpleLogger.SHOW_LOG_NAME_KEY, "false");

        if (debug)
        {
            System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
        }

        // Initialise logger.
        logger = new SimpleLoggerFactory().getLogger(Main.class.getName());
	    // Create config
	    botConfig = new Config();
	    // Start bot
	    new FoxBot(null);
    }

	public static Logger getLogger()
	{
		return logger;
	}

	// Thanks Bukkit
	private static List<String> asList(String... params)
	{
		return Arrays.asList(params);
	}
}