package com.entiv.pokeballcatch.data

import de.tr7zw.nbtapi.NBTCompound
import net.kyori.adventure.text.Component
import org.bukkit.entity.Axolotl
import org.bukkit.entity.Axolotl.Variant

object AxolotlData : DataWrapper<Axolotl>(Axolotl::class) {
    override fun entityWriteToNbt(entity: Axolotl, compound: NBTCompound) {
        compound.setString("variant", entity.variant.name)
    }

    override fun nbtWriteToEntity(compound: NBTCompound, entity: Axolotl) {
        entity.variant = Variant.valueOf(compound.getString("variant"))
    }

    override fun entityWriteToComponent(entity: Axolotl, components: MutableList<Component>) {
        addComponent(components, "颜色", entity.variant.translate())
    }

    fun Variant.translate(): String {
        return when (this) {
            Variant.LUCY -> "粉红色"
            Variant.WILD -> "棕色"
            Variant.GOLD -> "金色"
            Variant.CYAN -> "青色"
            Variant.BLUE -> "蓝色"
        }
    }
}