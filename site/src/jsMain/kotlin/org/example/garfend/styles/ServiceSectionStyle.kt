package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms

val ServiceCardStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.of(property = "transform", duration = 300.ms),
                Transition.of(property = "box-shadow", duration = 300.ms),
                Transition.of(property = "border-color", duration = 300.ms)
            )
    }
    hover {
        Modifier.styleModifier {
            property("transform", "translateY(-8px)")
            property("border-color", "rgba(240,168,104,0.55) !important")
            property("box-shadow",
                "0 0 12px rgba(240,168,104,0.40), " +
                "0 0 30px rgba(240,168,104,0.20), " +
                "0 0 60px rgba(240,168,104,0.10), " +
                "inset 0 0 20px rgba(240,168,104,0.05)")
        }
    }

    // Icon box animation on hover
    cssRule(" > #iconBox") {
        Modifier.styleModifier {
            property("transition", "transform 300ms ease")
        }
    }
    cssRule(":hover > #iconBox") {
        Modifier.styleModifier {
            property("transform", "scale(1.08) rotate(-5deg)")
        }
    }

    cssRule(" > #iconBox img") {
        Modifier.styleModifier {
            property("filter", "drop-shadow(0 0 6px rgba(240,168,104,0.30))")
            property("transition", "filter 300ms ease")
        }
    }
    cssRule(":hover > #iconBox img") {
        Modifier.styleModifier {
            property("filter", "drop-shadow(0 0 12px rgba(240,168,104,0.65))")
        }
    }

    cssRule(" > p") {
        Modifier
            .color(Colors.White)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    cssRule(":hover > p") {
        Modifier.color(Colors.White)
    }
}
