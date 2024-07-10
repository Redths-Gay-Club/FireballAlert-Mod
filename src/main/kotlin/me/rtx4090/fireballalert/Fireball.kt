package me.rtx4090.fireballalert

import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.utils.dsl.mc
import me.rtx4090.fireballalert.config.PolyConfig
import net.minecraft.client.audio.PositionedSoundRecord
import net.minecraft.entity.projectile.EntityFireball
import net.minecraft.util.ResourceLocation

object Fireball {

    fun isFireballNearby(): Boolean {
        val radius = PolyConfig.fireballAlertRange.toDouble()
        return mc.theWorld.findNearestEntityWithinAABB(EntityFireball::class.java, mc.thePlayer.entityBoundingBox.expand(radius, radius, radius), mc.thePlayer) != null
    }

    @Subscribe
    fun onTick(event: TickEvent) {
        if (!PolyConfig.fireballAlert) return
        if (event.stage != Stage.START) return
        if (!isFireballNearby()) return

        val sound = PositionedSoundRecord.create(ResourceLocation("note.pling"))
        mc.soundHandler.playSound(sound)
    }
}