package me.rtx4090.fireballalert.hud

import cc.polyfrost.oneconfig.hud.SingleTextHud
import me.rtx4090.fireballalert.Fireball

class IncHud : SingleTextHud("", false) {
    override fun getText(example: Boolean) =
        if (Fireball.isFireballNearby()) "INC!" else "Safe"

}