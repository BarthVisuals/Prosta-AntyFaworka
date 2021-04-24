package pl.barthvisuals.antyfaworyzacja;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Uruchamiam plugin...");
        getServer().getPluginManager().registerEvents(this, this);

    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("antyfaworka.check") || p.isOp()){
            Item DropedItem = e.getItemDrop();
            ItemStack item = DropedItem.getItemStack();
            ItemMeta meta = item.getItemMeta();
            meta.setLore(Arrays.asList("Przedmiot otrzymany od administratora:", p.getName()));
            item.setItemMeta(meta);
        }
    }

}
