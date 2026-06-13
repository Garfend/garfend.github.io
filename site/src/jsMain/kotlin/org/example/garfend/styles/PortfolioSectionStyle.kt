package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.example.garfend.models.Theme
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val PortfolioSectionStyle = CssStyle {
    // Overlay starts hidden (0 width), expands on hover
    cssRule(" > #columnParent > #boxParent > #greenOverlay") {
        Modifier
            .width(0.px)
            .transition(Transition.of(property = "width", duration = 500.ms))
    }
    cssRule(":hover > #columnParent > #boxParent > #greenOverlay") {
        Modifier.width(300.px)
    }

    // Link icon: hide/show
    cssRule(" > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Hidden)
    }
    cssRule(":hover > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Visible)
    }

    // Card-level hover: lift + amber glow
    cssRule(":hover") {
        Modifier.styleModifier {
            property("transform", "translateY(-4px)")
            property("border-color", "rgba(240,168,104,0.55)")
            property("box-shadow",
                "inset 0 1px 0 rgba(255,255,255,0.18), " +
                "inset 0 -1px 0 rgba(0,0,0,0.22), " +
                "0 30px 60px -22px rgba(0,0,0,0.7), " +
                "0 0 0 1px rgba(240,168,104,0.35)"
            )
        }
    }

    // Title color + translate transition
    cssRule(" > #columnParent > #portfolioTitle") {
        Modifier
            .color(Theme.Primary.rgb)
            .translateX(0.percent)
            .transition(
                Transition.of(property = "color", duration = 200.ms),
                Transition.of(property = "translate", duration = 200.ms)
            )
    }
    cssRule(":hover > #columnParent > #portfolioTitle") {
        Modifier
            .color(Theme.LightRed.rgb)
            .translateX(4.percent)
    }
}

val PortfolioArrowIconStyle = CssStyle {
    base {
        Modifier
            .color(Theme.Gray.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier.color(Theme.LightRed.rgb)
    }
}
