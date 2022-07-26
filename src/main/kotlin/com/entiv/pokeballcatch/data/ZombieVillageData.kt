package com.entiv.pokeballcatch.data

import com.entiv.pokeballcatch.data.VillageData.translate
import de.tr7zw.nbtapi.NBTCompound
import net.kyori.adventure.text.Component
import org.bukkit.entity.Villager
import org.bukkit.entity.Zombie
import org.bukkit.entity.ZombieVillager

object ZombieVillageData : DataWrapper<ZombieVillager>(ZombieVillager::class) {
    override fun entityWriteToNbt(entity: ZombieVillager, compound: NBTCompound) {
        compound.setString("Profession", entity.villagerProfession?.name)
        compound.setString("VillagerType", entity.villagerType.name)
    }

    override fun nbtWriteToEntity(compound: NBTCompound, entity: ZombieVillager) {
        entity.villagerProfession = Villager.Profession.valueOf(compound.getString("Profession"))
        entity.villagerType = Villager.Type.valueOf(compound.getString("VillagerType"))
    }

    override fun entityWriteToComponent(entity: ZombieVillager, components: MutableList<Component>) {
        addComponent(components, "职业", entity.villagerProfession.translate())
        addComponent(components, "群系", entity.villagerType.translate())
    }

}