package org.example.garfend.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px

@Composable
fun RamadanFooterDecorations() {
    val breakpoint = rememberBreakpoint()

    // Fixed position - appears above footer, overlaying the contact section
    Box(
        modifier = Modifier
            .position(Position.Fixed)
            .bottom(40.px) // Position above the footer (adjust based on footer height)
            .left(50.px)
            .zIndex(100)
            .styleModifier {
                property("animation", "fadeIn 1s ease-in-out")
                property("pointer-events", "none") // Allow clicking through the animation
            }
    ) {
        // Animation: moon_animation.json
        LottieAnimation(
            path = "/ramadan/moon_animation.json",
            modifier = Modifier,
            width = if (breakpoint > Breakpoint.MD) 250.px else 150.px,
            height = if (breakpoint > Breakpoint.MD) 250.px else 150.px,
            loop = true,
            autoplay = true,
            yoyo = true
        )
    }
}