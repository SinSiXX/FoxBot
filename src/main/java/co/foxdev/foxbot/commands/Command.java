package co.foxdev.foxbot.commands;

import com.google.common.base.Preconditions;
import lombok.*;
import org.pircbotx.hooks.events.MessageEvent;

@Data
@RequiredArgsConstructor(access = AccessLevel.NONE)
public abstract class Command
{
	private final String name;
	private final String permission;
	private final String[] aliases;

	public Command(String name)
	{
		this(name, null);
	}

	public Command(String name, String permission, String... aliases)
	{
		Preconditions.checkArgument(name != null, "name");
		this.name = name;
		this.permission = permission;
		this.aliases = aliases;
	}

	public abstract void execute(final MessageEvent event, final String[] args);
}