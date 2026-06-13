package org.example.garfend.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.models.Portfolio
import org.example.garfend.models.Theme
import org.example.garfend.styles.AppIconStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PortfolioDetailHeader(portfolio: Portfolio) {
    val breakpoint = rememberBreakpoint()
    val isDesktop = breakpoint >= Breakpoint.MD

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(bottom = 28.px)
            .padding(all = if (isDesktop) 32.px else 22.px)
            .borderRadius(14.px)
            .gap(if (isDesktop) 28.px else 18.px)
            .styleModifier {
                property("background", "linear-gradient(180deg, rgba(20,23,28,0.55) 0%, rgba(20,23,28,0.75) 100%)")
                property("backdrop-filter", "blur(22px) saturate(170%)")
                property("-webkit-backdrop-filter", "blur(22px) saturate(170%)")
                property("border", "1px solid rgba(255,255,255,0.08)")
                property(
                    "box-shadow",
                    "inset 0 1px 0 rgba(255,255,255,0.14), inset 0 -1px 0 rgba(0,0,0,0.22), 0 20px 40px -20px rgba(0,0,0,0.55)"
                )
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // App Icon
        Image(
            modifier = AppIconStyle.toModifier()
                .size(if (isDesktop) 128.px else 88.px)
                .objectFit(ObjectFit.Cover),
            src = portfolio.image,
            alt = stringResource("portfolio_image_alt")
        )

        // App Info
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            // Eyebrow: ── PROJECT // Category (mono, amber)
            Row(
                modifier = Modifier.margin(bottom = 14.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Span(
                    attrs = Modifier
                        .styleModifier {
                            property("display", "inline-block")
                            property("width", "28px")
                            property("height", "1px")
                            property("background", "rgb(240,168,104)")
                            property("margin-right", "10px")
                            property("flex-shrink", "0")
                        }
                        .toAttrs()
                ) {}
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily("JetBrains Mono", "monospace")
                        .fontSize(12.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.LightRed.rgb)
                        .styleModifier {
                            property("letter-spacing", "0.10em")
                            property("text-transform", "uppercase")
                        }
                        .toAttrs()
                ) {
                    Text("Project // ${stringResource(portfolio.description.titleKey)}")
                }
            }

            // App Name (large)
            H1(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily("Inter", "sans-serif")
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .styleModifier {
                        property("font-size", if (isDesktop) "clamp(36px, 5vw, 56px)" else "32px")
                        property("letter-spacing", "-0.02em")
                        property("line-height", "1.05")
                    }
                    .toAttrs()
            ) {
                Text(stringResource(portfolio.titleKey))
            }

            // Developer
            P(
                attrs = Modifier
                    .margin(top = 10.px, bottom = 0.px)
                    .fontFamily("JetBrains Mono", "monospace")
                    .fontSize(13.px)
                    .color(Theme.Gray.rgb)
                    .toAttrs()
            ) {
                Text("by ${portfolio.developer}")
            }
        }
    }
}
