package pink.core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.Bukkit.getServer;

public class announceCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("announce")) return false;

        if (!sender.hasPermission("pink.announce")) {
            sender.sendMessage("§cYou do not have permission to use this command.");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage("Usage: /" + label + " <message>");
            return true;
        }

        String message = String.join(" ", args);
        getServer().broadcastMessage(" ");
        getServer().broadcastMessage("§c[ALERT] §f" + message);
        getServer().broadcastMessage(" ");
        return true;

    }
}
