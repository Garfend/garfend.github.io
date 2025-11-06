package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import org.example.garfend.models.Theme
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

/**
 * Style for cross-platform portfolio cards with smooth bidirectional animations
 * Uses opacity instead of visibility for smooth fade in/out
 */
val PortfolioCrossPlatformStyle = CssStyle {
    // Green overlay: starts at 0px width, transitions to 300px on hover
    cssRule(" > #columnParent > #boxParent > #greenOverlay") {
        Modifier
            .width(0.px)
            .transition(Transition.of(property = "width", duration = 500.ms))
    }

    cssRule(":hover > #columnParent > #boxParent > #greenOverlay") {
        Modifier.width(300.px)
    }

    // Link icon content: uses opacity for smooth fade in/out (not visibility)
    cssRule(" > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier
            .opacity(0)
            .transition(Transition.of(property = "opacity", duration = 500.ms))
    }

    cssRule(":hover > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.opacity(1)
    }

    // Portfolio title animation
    cssRule(" > #columnParent > #portfolioTitle") {
        Modifier
            .color(Theme.Secondary.rgb)
            .translateX(0.percent)
            .transition(
                Transition.of(property = "color", duration = 200.ms),
                Transition.of(property = "translate", duration = 200.ms)
            )
    }

    cssRule(":hover > #columnParent > #portfolioTitle") {
        Modifier
            .color(Theme.Primary.rgb)
            .translateX(5.percent)
    }

    // Portfolio description animation
    cssRule(" > #columnParent > #portfolioDesc") {
        Modifier
            .translateX(0.percent)
            .transition(Transition.of(property = "translate", duration = 200.ms))
    }

    cssRule(":hover > #columnParent > #portfolioDesc") {
        Modifier.translateX(5.percent)
    }
}
