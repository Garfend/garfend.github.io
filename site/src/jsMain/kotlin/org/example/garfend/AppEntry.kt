package org.example.garfend

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.garfend.components.LocalizationProvider
import org.example.garfend.components.rememberLanguage
import org.jetbrains.compose.web.css.*
import kotlinx.browser.document
import org.w3c.dom.HTMLLinkElement
import org.w3c.dom.HTMLStyleElement

@InitSilk
fun updateTheme(ctx: InitSilkContext) {
    ctx.config.initialColorMode = ColorMode.DARK
}
@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    EnsureGlobalFonts()
    val languageState = rememberLanguage()

    SilkApp {
        LocalizationProvider() {
            Surface(
                SmoothColorStyle.toModifier()
                    .minHeight(100.vh)
                    .styleModifier {
                        property("background", "transparent")
                    }
            ) {
                content()
            }
        }

    }
}

@Composable
private fun EnsureGlobalFonts() {
    DisposableEffect(Unit) {
        val head = document.head

        val existing = head?.querySelector("#global-fonts") as? HTMLLinkElement
        if (existing == null) {
            val link = document.createElement("link") as HTMLLinkElement
            link.id = "global-fonts"
            link.rel = "stylesheet"
            link.href =
                "https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&family=JetBrains+Mono:wght@400;500&display=swap"
            head?.appendChild(link)
        }

        if (head?.querySelector("#ambient-styles") == null) {
            val style = document.createElement("style") as HTMLStyleElement
            style.id = "ambient-styles"
            style.textContent = """
                html {
                    scrollbar-gutter: stable;
                }
                html, body {
                    background: #0d0f12 !important;
                    color: #e8eaee;
                    font-family: 'Inter', sans-serif;
                    -webkit-text-size-adjust: 100%;
                    text-size-adjust: 100%;
                }
                body::before {
                    content: "";
                    position: fixed;
                    inset: 0;
                    z-index: 0;
                    pointer-events: none;
                    background:
                        radial-gradient(50% 40% at 12% 8%, rgba(240,168,104,0.18), transparent 70%),
                        radial-gradient(45% 35% at 88% 18%, rgba(106,166,255,0.14), transparent 70%),
                        radial-gradient(55% 45% at 70% 70%, rgba(201,124,240,0.11), transparent 70%),
                        radial-gradient(45% 40% at 18% 95%, rgba(74,215,193,0.10), transparent 70%);
                    filter: saturate(130%);
                }
                body > * { position: relative; z-index: 1; }
            """.trimIndent()
            head?.appendChild(style)
        }

        onDispose { }
    }
}
