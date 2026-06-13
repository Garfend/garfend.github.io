package org.example.garfend.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ContactCardStyle = CssStyle {
    base {
        Modifier
            .borderRadius(14.px)
            .transition(
                Transition.of(property = "transform", duration = 200.ms),
                Transition.of(property = "box-shadow", duration = 200.ms),
                Transition.of(property = "border-color", duration = 200.ms),
                Transition.of(property = "background", duration = 200.ms)
            )
            .styleModifier {
                property("cursor", "pointer")
            }
    }
    hover {
        Modifier
            .styleModifier {
                property("transform", "translateY(-3px)")
                property("border-color", "rgba(240,168,104,0.6)")
                property(
                    "box-shadow",
                    "0 8px 24px -8px rgba(240,168,104,0.35), 0 20px 40px -16px rgba(0,0,0,0.5)"
                )
            }
    }

    // Arrow icon inside the card: gray by default, transitions to amber and
    // nudges up-right on hover. Scoped to the arrow only so the platform icon
    // (a Font Awesome <span>) is not affected.
    cssRule(" .contact-arrow") {
        Modifier.styleModifier {
            property("color", "rgb(126,130,140)")
            property("transition", "transform 0.2s ease, color 0.2s ease")
        }
    }

    cssRule(":hover .contact-arrow") {
        Modifier.styleModifier {
            property("transform", "translate(4px, -4px)")
            property("color", "rgb(240,168,104)")
        }
    }
}
