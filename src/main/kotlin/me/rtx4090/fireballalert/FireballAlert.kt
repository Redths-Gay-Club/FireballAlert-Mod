package me.rtx4090.fireballalert

import cc.polyfrost.oneconfig.events.EventManager
import me.rtx4090.fireballalert.config.PolyConfig
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = FireballAlert.MODID, name = FireballAlert.NAME, version = FireballAlert.VERSION, modLanguageAdapter = "cc.polyfrost.oneconfig.utils.KotlinLanguageAdapter")
object FireballAlert {
    const val MODID = "@ID@"
    const val NAME = "@NAME@"
    const val VERSION = "@VER@"

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        PolyConfig.initialize()
        EventManager.INSTANCE.register(Fireball)
    }
}