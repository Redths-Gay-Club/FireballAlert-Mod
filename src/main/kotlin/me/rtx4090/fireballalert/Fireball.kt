package me.rtx4090.fireballalert

import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.utils.dsl.mc
import me.rtx4090.fireballalert.config.PolyConfig
import net.minecraft.client.audio.PositionedSoundRecord
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityFireball
import net.minecraft.util.ResourceLocation
import java.util.WeakHashMap

object Fireball {
    val fireballShooter = WeakHashMap<Entity, Entity>()

    fun isFireballNearby(): Boolean {
        val radius = PolyConfig.fireballAlertRange.toDouble()
        val fb = find<EntityFireball>(mc.thePlayer, radius) ?: return false
        val p = find<EntityPlayer>(fb, radius) ?: return false

        if (!fireballShooter.containsKey(fb)) fireballShooter[fb] = p
        if (fireballShooter[fb] == mc.thePlayer) return false
        return true
    }

    private inline fun <reified T : Entity> find(entity: Entity, radius: Double) =
        mc.theWorld.findNearestEntityWithinAABB(
            T::class.java,
            entity.entityBoundingBox.expand(radius, radius, radius),
            entity
        ) as? T

    @Subscribe
    fun onTick(event: TickEvent) {
if (!PolyConfig.fireballAlert) return
        if (event.stage != Stage.START) return
        if (!isFireballNearby()) return
        val sound = PositionedSoundRecord.create(ResourceLocation("note.pling"))
        mc.soundHandler.playSound(sound)
    }
}