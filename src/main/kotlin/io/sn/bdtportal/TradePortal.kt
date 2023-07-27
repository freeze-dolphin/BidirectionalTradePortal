package io.sn.bdtportal

import io.sn.bdtportal.events.ItemTradeEvent
import io.sn.bdtportal.listeners.PortalItemListener
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.plugin.java.JavaPlugin

class TradePortal : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(PortalItemListener(this), this)
        server.scheduler.runTaskTimer(this, Runnable {
            server.worlds.forEach { wrd ->
                wrd.entities.forEach { ety ->
                    if (ety.type == EntityType.DROPPED_ITEM) {
                        val itm = ety as Item
                        if (itm.location.block.equals(Material.NETHER_PORTAL)) {
                            println("calling")
                            server.pluginManager.callEvent(ItemTradeEvent(itm))
                        }
                    }
                }
            }
        }, 0L, 10L)
    }

}
