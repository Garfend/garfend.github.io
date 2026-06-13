package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.rgb

private val AccentColor = rgb(r = 240, g = 168, b = 104)
private val MutedLinkColor = rgb(r = 126, g = 130, b = 140)

val NavigationItemStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                property("--bs-link-color", MutedLinkColor)
                property("--silk-link-default-color", MutedLinkColor)
                property("--silk-link-visited-color", MutedLinkColor)
                property("color", "$MutedLinkColor !important")
            }
            .color(MutedLinkColor)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .styleModifier {
                property("--bs-link-hover-color", Colors.White)
                property("--silk-link-default-color", Colors.White)
                property("--silk-link-visited-color", Colors.White)
                property("color", "${Colors.White} !important")
            }
            .color(Colors.White)
    }
}

val LogoStyle = CssStyle {
    base {
        Modifier
            .transform { rotate(0.deg) }
            .transition(Transition.of(property = "transform", duration = 200.ms))
    }
    hover {
        Modifier
            .transform { rotate((-10).deg) }
    }
}

val SocialLinkStyle = CssStyle {
    base {
        Modifier
            .color(Colors.White)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier.color(AccentColor)
    }
}

val SocialIconButtonStyle = CssStyle {
    base {
        Modifier
            .border(width = 1.px, style = LineStyle.Solid, color = rgba(255, 255, 255, 0.15))
            .borderRadius(50.percent)
            .transition(
                Transition.of(property = "transform", duration = 200.ms),
                Transition.of(property = "border-color", duration = 200.ms),
                Transition.of(property = "color", duration = 200.ms)
            )
            .color(Colors.White)
    }
    hover {
        Modifier
            .border(width = 1.px, style = LineStyle.Solid, color = AccentColor)
            .transform { scale(1.08) }
            .color(AccentColor)
    }
}

val MainButtonStyle = CssStyle {
    base {
        Modifier
            .width(100.px)
            .transition(Transition.of(property = "width", duration = 200.ms))
    }
    hover {
        Modifier.width(120.px)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val LinkOverrideStyle = CssStyle {
    base {
        Modifier.styleModifier {
            // Override Silk link variables and use important to override all defaults
            property("--silk-link-default-color", "$MutedLinkColor !important")
            property("--silk-link-visited-color", "$MutedLinkColor !important")
            property("color", "$MutedLinkColor !important")
            property("text-decoration", "none !important")
        }
    }
    hover {
        Modifier.styleModifier {
            property("--silk-link-default-color", "${Colors.White} !important")
            property("--silk-link-visited-color", "${Colors.White} !important")
            property("color", "${Colors.White} !important")
            property("text-decoration", "none !important")
        }
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val MainImageStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.of(property = "transform", duration = 300.ms)
            )
    }
    hover {
        Modifier.transform { scale(1.02) }
    }
}

val FooterLinkStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                property("--silk-link-default-color", "$MutedLinkColor !important")
                property("--silk-link-visited-color", "$MutedLinkColor !important")
                property("color", "$MutedLinkColor !important")
                property("text-decoration", "none !important")
            }
            .color(MutedLinkColor)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .styleModifier {
                property("--silk-link-default-color", "$AccentColor !important")
                property("--silk-link-visited-color", "$AccentColor !important")
                property("color", "$AccentColor !important")
                property("text-decoration", "none !important")
            }
            .color(AccentColor)
    }
}

val FooterMonoLinkStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                property("--silk-link-default-color", "$MutedLinkColor !important")
                property("--silk-link-visited-color", "$MutedLinkColor !important")
                property("color", "$MutedLinkColor !important")
                property("text-decoration", "none !important")
            }
            .color(MutedLinkColor)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .styleModifier {
                property("--silk-link-default-color", "$AccentColor !important")
                property("--silk-link-visited-color", "$AccentColor !important")
                property("color", "$AccentColor !important")
                property("text-decoration", "none !important")
            }
            .color(AccentColor)
    }
}
