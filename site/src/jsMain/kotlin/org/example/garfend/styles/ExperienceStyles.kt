package org.example.garfend.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier

fun Modifier.experienceDescriptionStyle(active: Boolean) = this.styleModifier {
    property("background", if (active) "rgba(255,59,92,0.14)" else "rgba(255,255,255,0.05)")
    property("border", if (active) "1px solid rgba(255,59,92,0.4)" else "1px solid rgba(255,255,255,0.08)")
    property("border-radius", "14px")
    property(
        "box-shadow",
        if (active) "0 0 14px rgba(255,59,92,0.4), 0 12px 28px rgba(0,0,0,0.35)"
        else "0 10px 22px rgba(0,0,0,0.25)"
    )
    property("backdrop-filter", "blur(12px)")
    property("-webkit-backdrop-filter", "blur(12px)")
}

fun Modifier.experienceNumberBarStyle() = this.styleModifier {
    property("background", " rgba(255,59,92,0.65)")
    property("box-shadow", "0 0 10px rgba(255,59,92,0.5)")
    property("border-radius", "999px")
}

fun Modifier.experienceNumberCircleStyle(active: Boolean) = this.styleModifier {
    property("box-shadow", if (active) "0 0 14px rgba(255,59,92,0.7)" else "0 0 8px rgba(255,59,92,0.45)")
}
