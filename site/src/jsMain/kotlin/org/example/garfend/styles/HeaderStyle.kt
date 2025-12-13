package org.example.garfend.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.percent

private fun Modifier.glassBase() = this
    .borderRadius(r = 50.px)
    .styleModifier {
        property("background", "rgba(255, 255, 255, 0.08)")
        property("backdrop-filter", "blur(16px) saturate(180%)")
        property("border", "1px solid rgba(255, 255, 255, 0.18)")
        property("box-shadow", "0 12px 40px rgba(0, 0, 0, 0.30)")
    }

val HeaderContainerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .zIndex(100)
            .styleModifier {
                property("top", "30px")
                property("left", "50%")
                property("transform", "translateX(-50%)")
            }
    }
}

val HeaderShellStyle = CssStyle {
    base { Modifier.glassBase() }
}

val HeaderNavShellStyle = CssStyle {
    base {
        Modifier
            .glassBase()
            .styleModifier {
                property("gap", "30px")
            }
    }
}

val SideMenuShellStyle = CssStyle {
    base {
        Modifier
            .glassBase()
//            .styleModifier {
//                property("border-top-left-radius", "0px")
//                property("border-bottom-left-radius", "0px")
//                property("border-top-right-radius", "32px")
//                property("border-bottom-right-radius", "32px")
//                property("height", "100%")
//            }
    }
}

val ActiveHeaderLinkStyle = CssStyle {
    base {
        Modifier.styleModifier {
            property("--silk-link-default-color", "rgb(255, 59, 92) !important")
            property("--silk-link-visited-color", "rgb(255, 59, 92) !important")
            property("color", "rgb(255, 59, 92) !important")
        }
    }
}
