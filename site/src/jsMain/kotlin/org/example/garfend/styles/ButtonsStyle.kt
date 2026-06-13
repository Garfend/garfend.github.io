package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.example.garfend.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb

val GlowingButtonStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(rgb(240, 168, 104))
            .borderRadius(999.px)
            .border(0.px)
            .padding(topBottom = 14.px, leftRight = 28.px)
            .fontFamily(*FONT_FAMILY)
            .fontSize(15.px)
            .fontWeight(600)
            .color(rgb(26, 18, 8))
            .styleModifier {
                property("box-shadow", "0 12px 30px -12px rgba(240,168,104,0.65)")
                property("letter-spacing", "0.01em")
            }
            .transition(
                Transition.of(property = "background-color", duration = 200.ms),
                Transition.of(property = "transform", duration = 200.ms),
                Transition.of(property = "box-shadow", duration = 200.ms)
            )
    }
    hover {
        Modifier
            .backgroundColor(rgb(212, 135, 74))
            .transform { translateY((-2).px) }
            .styleModifier {
                property("box-shadow", "0 16px 36px -12px rgba(240,168,104,0.75)")
            }
    }
}
