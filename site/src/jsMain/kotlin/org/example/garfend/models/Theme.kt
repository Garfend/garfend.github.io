package org.example.garfend.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(hex = "#e8eaee", rgb = rgb(r = 232, g = 234, b = 238)),
    Secondary(hex = "#b6bac3", rgb = rgb(r = 182, g = 186, b = 195)),
    Gray(hex = "#7e828c", rgb = rgb(r = 126, g = 130, b = 140)),
    LightGray(hex = "#14171c", rgb = rgb(r = 20, g = 23, b = 28)),
    LighterGray(hex = "#1b1f26", rgb = rgb(r = 27, g = 31, b = 38)),
    LightGrayBg(hex = "#0d0f12", rgb = rgb(r = 13, g = 15, b = 18)),
    LightRed(hex = "#f0a868", rgb = rgb(r = 240, g = 168, b = 104)),
    LighterRed(hex = "#f7c89a", rgb = rgb(r = 247, g = 200, b = 154)),
    DarkRed(hex = "#d4874a", rgb = rgb(r = 212, g = 135, b = 74)),
}
