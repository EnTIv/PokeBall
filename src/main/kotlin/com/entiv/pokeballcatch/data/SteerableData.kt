package com.entiv.pokeballcatch.data

import de.tr7zw.nbtapi.NBTCompound
import net.kyori.adventure.text.Component
import org.bukkit.entity.Steerable

object SteerableData : DataWrapper<Steerable>(Steerable::class) {
    override fun entityWriteToNbt(entity: Steerable, compound: NBTCompound) {
        compound.setBoolean("hasSaddle", entity.hasSaddle())
    }

    override fun nbtWriteToEntity(compound: NBTCompound, entity: Steerable) {
        entity.setSaddle(compound.getBoolean("hasSaddle"))
    }

    override fun entityWriteToComponent(entity: Steerable, components: MutableList<Component>) {
        addComponent(components, "鞍", if (entity.hasSaddle()) "有" else "无")
    }
}