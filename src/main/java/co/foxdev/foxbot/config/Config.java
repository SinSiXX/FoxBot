package co.foxdev.foxbot.config;

import co.foxdev.foxbot.FoxBot;
import co.foxdev.foxbot.Main;
import com.notoriousdev.yamlconfig.YamlConfig;

import java.io.File;

public class Config
{
	private YamlConfig config;

	public Config()
	{
		loadConfig();
	}

	private void loadConfig()
	{
		// FoxBot isn't initialised yet
		Main.getLogger().debug("Loading config...");

		config = new YamlConfig("config.yml");

		if (!config.getConfigFile().exists())
		{
			// Bot class isn't initialised yet
			Main.getLogger().warn("Config not found. Creating a new one.");
			config.saveDefaultConfig();
		}
	}
}