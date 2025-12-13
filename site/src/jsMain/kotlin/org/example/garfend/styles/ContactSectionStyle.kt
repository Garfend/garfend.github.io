package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.focus
import com.varabyte.kobweb.silk.style.selectors.hover
import org.example.garfend.models.Theme
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

val InputStyle = CssStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.LightGray.rgb
            )
            .borderRadius(10.px)
            .padding(12.px)
            .backgroundColor(rgba(255, 255, 255, 0.05))
            .color(Theme.Secondary.rgb)
            .transition(
                Transition.of(property = "border", duration = 200.ms),
                Transition.of(property = "background-color", duration = 200.ms)
            )
    }
    focus {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.LightRed.rgb
        ).backgroundColor(rgba(255, 59, 92, 0.08))
    }
    hover {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.LightRed.rgb
        ).backgroundColor(rgba(255, 59, 92, 0.06))
    }
}
