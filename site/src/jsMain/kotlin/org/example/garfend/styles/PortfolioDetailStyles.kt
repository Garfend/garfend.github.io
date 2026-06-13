package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.example.garfend.models.Theme
import org.jetbrains.compose.web.css.px

// Back Button — glass pill matching the rest of the design
val BackButtonStyle = CssStyle {
    base {
        Modifier
            .padding(leftRight = 20.px, topBottom = 12.px)
            .borderRadius(999.px)
            .fontSize(13.px)
            .fontWeight(FontWeight.Medium)
            .color(Theme.Secondary.rgb)
            .fontFamily("Inter", "sans-serif")
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("background", "rgba(20,23,28,0.55)")
                property("border", "1px solid rgba(255,255,255,0.10)")
                property("backdrop-filter", "blur(16px) saturate(160%)")
                property("-webkit-backdrop-filter", "blur(16px) saturate(160%)")
                property("box-shadow", "inset 0 1px 0 rgba(255,255,255,0.12), inset 0 -1px 0 rgba(0,0,0,0.22)")
                property("text-decoration", "none")
                property("transition", "color 0.2s ease, border-color 0.2s ease, transform 0.2s ease")
            }
    }

    hover {
        Modifier
            .color(Theme.Primary.rgb)
            .styleModifier {
                property("border-color", "rgba(240,168,104,0.40)")
                property("transform", "translateY(-1px)")
            }
    }
}

// App Icon — rounded square with subtle amber-tinted edge
val AppIconStyle = CssStyle {
    base {
        Modifier
            .borderRadius(22.px)
            .styleModifier {
                property("border", "1px solid rgba(255,255,255,0.10)")
                property("box-shadow", "0 20px 40px -20px rgba(0,0,0,0.6), inset 0 1px 0 rgba(255,255,255,0.10)")
            }
    }
}

// Glass card container — reused by About / App Information sections
val InfoSectionStyle = CssStyle {
    base {
        Modifier
            .borderRadius(14.px)
            .padding(all = 28.px)
            .styleModifier {
                property("background", "linear-gradient(180deg, rgba(20,23,28,0.55) 0%, rgba(20,23,28,0.75) 100%)")
                property("backdrop-filter", "blur(22px) saturate(170%)")
                property("-webkit-backdrop-filter", "blur(22px) saturate(170%)")
                property("border", "1px solid rgba(255,255,255,0.08)")
                property(
                    "box-shadow",
                    "inset 0 1px 0 rgba(255,255,255,0.14), inset 0 -1px 0 rgba(0,0,0,0.22), 0 20px 40px -20px rgba(0,0,0,0.55)"
                )
            }
    }
}

// Secondary (glass) download button
val AppStoreButtonStyle = CssStyle {
    base {
        Modifier
            .padding(leftRight = 22.px, topBottom = 14.px)
            .borderRadius(999.px)
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("background", "rgba(27,31,38,0.55)")
                property("border", "1px solid rgba(255,255,255,0.12)")
                property("backdrop-filter", "blur(16px) saturate(160%)")
                property("-webkit-backdrop-filter", "blur(16px) saturate(160%)")
                property("box-shadow", "inset 0 1px 0 rgba(255,255,255,0.14)")
                property("text-decoration", "none")
                property("transition", "transform 0.2s ease, border-color 0.2s ease, background 0.2s ease")
            }
    }

    hover {
        Modifier
            .styleModifier {
                property("background", "rgba(27,31,38,0.75)")
                property("border-color", "rgba(240,168,104,0.40)")
                property("transform", "translateY(-2px)")
            }
    }
}

// Primary (amber) download button
val AppStorePrimaryButtonStyle = CssStyle {
    base {
        Modifier
            .padding(leftRight = 22.px, topBottom = 14.px)
            .borderRadius(999.px)
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("background", "rgb(240,168,104)")
                property("color", "#1a1208")
                property("border", "1px solid rgba(240,168,104,0.0)")
                property("text-decoration", "none")
                property("transition", "transform 0.2s ease, box-shadow 0.2s ease")
                property("box-shadow", "0 12px 24px -12px rgba(240,168,104,0.55)")
            }
    }

    hover {
        Modifier
            .styleModifier {
                property("transform", "translateY(-2px)")
                property("box-shadow", "0 18px 32px -14px rgba(240,168,104,0.65)")
            }
    }
}
