package com.entiv.pokeballcatch.data

import de.tr7zw.nbtapi.NBTCompound
import net.kyori.adventure.text.Component
import org.bukkit.entity.Sheep

object SheepData : DataWrapper<Sheep>(Sheep::class) {
    override fun entityWriteToNbt(entity: Sheep, compound: NBTCompound) {
        compound.setBoolean("Sheared", entity.isSheared)
    }

    override fun nbtWriteToEntity(compound: NBTCompound, entity: Sheep) {
        entity.isSheared = compound.getBoolean("Sheared")
    }

    override fun entityWriteToComponent(entity: Sheep, components: MutableList<Component>) {
        addComponent(components, "被剪毛", if (entity.isSheared) "是" else "否")
    }

}