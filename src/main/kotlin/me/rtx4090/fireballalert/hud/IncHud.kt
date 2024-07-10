package me.rtx4090.fireballalert.hud

import cc.polyfrost.oneconfig.hud.SingleTextHud
import me.rtx4090.fireballalert.Fireball

class IncHud : SingleTextHud("", true) {

    override fun getText(example: Boolean): String {
        if (Fireball.isFireballNearby()) {
            return "INC"
        }
        return "Safe"
    }
}