package abeln8r.plugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.PluginManager;


public class Abeln8rsPlugins extends JavaPlugin
{
    
    public void onEnable()
    {
    }
 
    public void onDisable()
    {
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = null;
	if(sender instanceof Player) 
	{
		player = (Player)sender;
	}
        if(player == null) 
	{
            sender.sendMessage("Sorry, only Players can use such commands!");
            return true;
        }else
        if(cmd.getName().equalsIgnoreCase("tk"))
        {
            if(args.length < 2 || !hasAdminAccess(sender))
            {
                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);
            String message = args[1];
            for(Player players: getServer().getOnlinePlayers()) 
            {    
                if(target.isOnline())
                {
                    String s;
                    if(target.isOp())
                    {
                        String pname = ChatColor.DARK_RED + target.getDisplayName();
                        s = "["+target.getWorld().getName()+"]<" + pname + ChatColor.WHITE + "> " + message;
                        players.sendMessage(s);
                    }else
                    {
                        s = "["+target.getWorld().getName()+"]<" + target.getDisplayName() + "> " + message;
                        players.sendMessage(s);
                    }
                    return true;
                }else
                {
                    players.sendMessage("[world]<" + args[0] + "> " + message);
                    return true;
                }
            }
        }  
        return false;
    }
    private boolean hasAdminAccess(CommandSender sender)
    {
        return sender.getName().equalsIgnoreCase("abeln8r") || sender.getName().equalsIgnoreCase("yomasta");
    }
}