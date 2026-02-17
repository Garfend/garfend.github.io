package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.example.garfend.models.Theme
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ContactCardStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                property("background", "rgba(255, 255, 255, 0.03)")
                property("backdrop-filter", "blur(18px)")
                property("-webkit-backdrop-filter", "blur(18px)")
                property("border", "1px solid rgba(255, 255, 255, 0.08)")
                property("box-shadow", "inset 0 0 0 0 rgba(255, 255, 255, 0)")
                property("cursor", "pointer")
            }
            .borderRadius(20.px)
            .transition(
                Transition.of(property = "transform", duration = 300.ms),
                Transition.of(property = "box-shadow", duration = 300.ms),
                Transition.of(property = "border", duration = 300.ms)
            )
    }
    hover {
        Modifier
            .styleModifier {
                property("transform", "translateY(-10px)")
                property("border", "1px solid ${Theme.LightRed.rgb}")
                property(
                    "box-shadow",
                    "0 0 10px rgba(255,59,92,0.6), 0 0 20px rgba(255,59,92,0.4), 0 0 60px rgba(255,59,92,0.2), inset 0 0 20px rgba(255,59,92,0.1)"
                )
            }
    }

    cssRule(" > #iconBox") {
        Modifier.styleModifier {
            property("transition", "transform 300ms ease")
            property("display", "inline-flex")
            property("align-items", "center")
            property("justify-content", "center")
        }
    }

    cssRule(":hover > #iconBox") {
        Modifier.styleModifier {
            property("transform", "scale(1.08)")
        }
    }

    cssRule(" > #iconBox > div") {
        Modifier.styleModifier {
            property("transition", "all 300ms ease")
        }
    }

    cssRule(":hover > #iconBox > div") {
        Modifier.styleModifier {
            property("box-shadow", "0 0 20px rgba(255,59,92,0.5)")
        }
    }

    cssRule(" p") {
        Modifier
            .color(Colors.White)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }

    cssRule(":hover p") {
        Modifier.color(Colors.White)
    }
}
