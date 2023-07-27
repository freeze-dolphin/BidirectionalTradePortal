package io.sn.bdtportal.listeners

import io.sn.bdtportal.TradePortal
import io.sn.bdtportal.events.ItemTradeEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class PortalItemListener(plug: TradePortal) : Listener {

    @EventHandler
    fun onInput(evt: ItemTradeEvent) {
        println(evt.getItemStack().type.toString())
    }

}
