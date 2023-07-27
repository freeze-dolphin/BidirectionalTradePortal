package io.sn.bdtportal.events

import org.bukkit.entity.Item
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList
import org.bukkit.event.entity.EntityEvent
import org.bukkit.inventory.ItemStack
import javax.annotation.Nonnull


class ItemTradeEvent(private val item: Item) : EntityEvent(item), Cancellable {

    private var isCancelled = false

    override fun getEntity(): Item = item

    fun getItemStack(): ItemStack = item.itemStack

    @Nonnull
    override fun getHandlers(): HandlerList {
        return handlerList
    }

    override fun isCancelled(): Boolean {
        return isCancelled
    }

    override fun setCancelled(b: Boolean) {
        isCancelled = b
    }

    companion object {
        val handlerList = HandlerList()
    }
}