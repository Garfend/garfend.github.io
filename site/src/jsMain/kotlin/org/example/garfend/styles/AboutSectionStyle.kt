package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent

val AboutTextStyle = CssStyle {
    base {
        Modifier
            .opacity(50.percent)
            .transition(Transition.of(property = "opacity", duration = 200.ms))
    }
    hover {
        Modifier.opacity(100.percent)
    }
}

val StatsGridStyle = CssStyle {
    cssRule(" > *:last-child:nth-child(odd)") {
        Modifier.styleModifier {
            property("grid-column", "1 / -1")
        }
    }
}