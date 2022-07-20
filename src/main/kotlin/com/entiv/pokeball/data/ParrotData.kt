package com.entiv.pokeball.data

import de.tr7zw.nbtapi.NBTCompound
import net.kyori.adventure.text.Component
import org.bukkit.entity.Parrot

class ParrotData(
    val variant: Parrot.Variant
) : EntityData<Parrot>() {
    override fun applyCompound(nbtCompound: NBTCompound) {
        nbtCompound.setString("Variant", variant.name)
    }

    override fun applyComponent(components: MutableList<Component>) {
        //TODO 汉化
        loreComponent("品种", variant.name).also { components.add(it) }
    }

    override fun applyEntity(entity: Parrot) {
        entity.variant = variant
    }

    companion object : DataCreator<Parrot>() {
        override val dataEntityClass = Parrot::class.java

        override fun getEntityData(nbtCompound: NBTCompound): EntityData<*> {
            val variant = Parrot.Variant.valueOf(nbtCompound.getString("Variant"))
            return ParrotData(variant)
        }

        override fun getEntityData(entity: Parrot): EntityData<*> {
            val variant = entity.variant
            return ParrotData(variant)
        }

    }

}