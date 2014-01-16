package co.foxdev.foxbot.exceptions;

public class InviteOnlyException extends Exception
{
	/** Thrown when attempting to join an invite only channel */
	public InviteOnlyException()
	{
		super("Channel is invite only!");
	}

	public InviteOnlyException(String message)
	{
		super(message);
	}

	public InviteOnlyException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public InviteOnlyException(Throwable cause)
	{
		super(cause);
	}
}