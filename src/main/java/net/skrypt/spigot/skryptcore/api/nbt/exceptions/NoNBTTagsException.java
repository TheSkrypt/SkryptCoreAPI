package net.skrypt.spigot.skryptcore.api.nbt.exceptions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;

/**
 * Created by lukas on 16/06/2017.
 */
public class NoNBTTagsException extends NBTException {
	
	public static final String message = "This NBTItemStack instance does not contain any NBT Tags! Either this item is a regular ItemStack or the NBT Tags were not saved successfully!";
	
	/**
	 * Returns a Human-Readable message (for the server owner) with instructions what to do with this kind of exceptions.
	 * @return String - a human-readable message describing the error.
	 */
	public String getMessage() {
		return message;
	}
	
	public void printUserFriendlyMessage() {
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(ChatColor.GOLD + message);
	}
	
	public void disablePlugin(Plugin plugin) {
		Bukkit.getServer().getPluginManager().disablePlugin(plugin);
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(ChatColor.RED + "The plugin was disabled automatically to avoid further critical errors.");
	}
	
	@Override
	public void printStackTrace() {
		printUserFriendlyMessage();
		super.printStackTrace();
	}
}
