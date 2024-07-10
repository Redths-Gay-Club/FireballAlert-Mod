package me.rtx4090.fireballalert.config

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.*
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import me.rtx4090.fireballalert.FireballAlert
import me.rtx4090.fireballalert.hud.IncHud

object PolyConfig : Config(Mod(FireballAlert.NAME, ModType.UTIL_QOL), FireballAlert.MODID + ".json") {

    @HUD(
        name = "Incoming HUD"
    )
    var hud = IncHud()

    @Switch(
        name = "Fireball Alert"
    )
    var fireballAlert = true

    @Slider(
        name = "Fireball Alert Range",
        min = 10f,
        max = 100f
    )
    var fireballAlertRange = 30

}