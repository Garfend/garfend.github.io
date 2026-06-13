package org.example.garfend.components.experience

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.components.stringResource
import org.example.garfend.models.Experience
import org.example.garfend.models.Theme
import org.example.garfend.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/* ------------------------------------------------------------------ */
/*  Professional experience — vertical glowing timeline               */
/* ------------------------------------------------------------------ */

@Composable
fun professionalTimeline() {
    val breakpoint = rememberBreakpoint()
    val isDesktop = breakpoint >= Breakpoint.MD
    val railPad = if (isDesktop) 60.px else 42.px

    Box(modifier = Modifier.fillMaxWidth().styleModifier { property("position", "relative") }) {
        // continuous spine
        Div(
            attrs = Modifier.styleModifier {
                property("position", "absolute")
                property("top", "10px"); property("bottom", "14px")
                property("left", if (isDesktop) "21px" else "15px")
                property("width", "2px"); property("border-radius", "999px")
                property("background", "linear-gradient(180deg, ${Amber.A60}, ${Amber.A12} 70%, rgba(240,168,104,0))")
                property("box-shadow", "0 0 12px ${Amber.A40}")
            }.toAttrs()
        ) {}

        Column(modifier = Modifier.fillMaxWidth().padding(left = railPad)) {
            Experience.professional.forEach { exp -> timelineRow(exp, isDesktop, railPad.value.toInt()) }
        }
    }
}

@Composable
private fun timelineRow(exp: Experience, isDesktop: Boolean, railPad: Int) {
    var hover by remember { mutableStateOf(false) }
    val lit = exp.active || hover
    val dotCenter = if (isDesktop) 22 else 16
    val dotSize = 16
    val dotLeft = dotCenter - dotSize / 2 - railPad

    Box(modifier = Modifier.fillMaxWidth().margin(bottom = 16.px).styleModifier { property("position", "relative") }) {
        // node
        Div(attrs = Modifier.styleModifier {
            property("position", "absolute"); property("top", "8px"); property("left", "${dotLeft}px")
            property("width", "${dotSize}px"); property("height", "${dotSize}px"); property("border-radius", "999px")
            property("background", if (lit) Amber.SOLID else "rgba(20,23,28,0.95)")
            property("border", "2px solid ${if (lit) Amber.SOLID else Amber.A40}")
            property("box-shadow", if (lit) "0 0 16px ${Amber.A60}" else "0 0 6px ${Amber.A25}")
            property("transition", "all 0.3s ease")
        }.toAttrs()) {}

        Column(
            modifier = Modifier.fillMaxWidth().padding(all = if (isDesktop) 20.px else 16.px)
                .cursor(Cursor.Default)
                .onMouseEnter { hover = true }.onMouseLeave { hover = false }
                .styleModifier {
                    property("background", if (exp.active) Amber.A06 else Amber.CARD_BG)
                    property("backdrop-filter", "blur(20px)"); property("-webkit-backdrop-filter", "blur(20px)")
                    property("border", "1px solid ${if (lit) Amber.A40 else Amber.HAIRLINE}")
                    property("border-radius", "14px")
                    property("box-shadow", if (hover) "${Amber.GLOW}, ${Amber.INSET}" else Amber.INSET)
                    property("transform", if (hover) "translateX(6px)" else "translateX(0)")
                    property("transition", "transform 0.3s ease, border-color 0.3s ease, box-shadow 0.3s ease")
                }
        ) {
            // header line: number + dates
            Div(attrs = Modifier.fillMaxWidth().styleModifier {
                property("display", "flex"); property("justify-content", "space-between")
                property("align-items", "baseline"); property("gap", "12px"); property("margin-bottom", "5px")
            }.toAttrs()) {
                P(attrs = Modifier.margin(topBottom = 0.px).fontFamily(*MONO).fontSize(13.px)
                    .fontWeight(FontWeight.Bold).color(Theme.LightRed.rgb).toAttrs()) { Text(exp.number) }
                P(attrs = Modifier.margin(topBottom = 0.px).fontFamily(*MONO).fontSize(12.px)
                    .color(Theme.Gray.rgb).toAttrs()) {
                    Text("${stringResource(exp.fromKey)} – ${stringResource(exp.toKey)}")
                }
            }
            P(attrs = Modifier.margin(topBottom = 0.px).margin(bottom = 2.px).fontFamily(*FONT_FAMILY)
                .fontSize(if (isDesktop) 19.px else 17.px).fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb).toAttrs()) { Text(stringResource(exp.jobPositionKey)) }
            P(attrs = Modifier.margin(topBottom = 0.px).margin(bottom = 9.px).fontFamily(*FONT_FAMILY)
                .fontSize(14.px).color(Theme.LightRed.rgb).styleModifier {
                    property("display", "flex"); property("align-items", "center"); property("gap", "8px")
                }.toAttrs()) {
                if (exp.active) {
                    Span(attrs = Modifier.styleModifier {
                        property("width", "7px"); property("height", "7px"); property("border-radius", "999px")
                        property("background", Amber.SOLID); property("box-shadow", "0 0 8px ${Amber.A60}")
                        property("flex-shrink", "0")
                    }.toAttrs()) {}
                }
                Span { Text(stringResource(exp.companyKey)) }
            }
            P(attrs = Modifier.margin(topBottom = 0.px).fontFamily(*FONT_FAMILY).fontSize(14.px)
                .lineHeight(1.7).color(Theme.Secondary.rgb).toAttrs()) {
                Text(stringResource(exp.descriptionKey))
            }
        }
    }
}

/* ------------------------------------------------------------------ */
/*  Training / certifications — compact, de-emphasized mini tabs       */
/* ------------------------------------------------------------------ */

@Composable
fun trainingStrip() {
    val entries = Experience.training
    if (entries.isEmpty()) return
    var selected by remember { mutableStateOf(0) }
    val current = entries[selected]

    Column(modifier = Modifier.fillMaxWidth().styleModifier { property("max-width", "640px") }) {
        // muted label
        P(attrs = Modifier.margin(topBottom = 0.px).margin(bottom = 12.px).fontFamily(*MONO)
            .fontSize(12.px).color(Theme.Gray.rgb).styleModifier {
                property("letter-spacing", "0.08em"); property("text-transform", "uppercase")
            }.toAttrs()) { Text(stringResource("exp_training_label")) }

        // single de-emphasized card: tabs on top, description underneath
        Column(
            modifier = Modifier.fillMaxWidth().styleModifier {
                property("background", "rgba(20,23,28,0.40)")
                property("border", "1px solid ${Amber.HAIRLINE}")
                property("border-radius", "14px")
                property("overflow", "hidden")
            }
        ) {
            // tab row — horizontally scrollable when it overflows the card
            Div(
                attrs = Modifier.fillMaxWidth().styleModifier {
                    property("display", "flex"); property("gap", "8px")
                    property("padding", "10px"); property("flex-wrap", "nowrap")
                    property("overflow-x", "auto")
                    property("border-bottom", "1px solid ${Amber.HAIRLINE}")
                    // slim scrollbar
                    property("scrollbar-width", "thin")
                    property("scrollbar-color", "${Amber.A25} transparent")
                }.toAttrs()
            ) {
                entries.forEachIndexed { i, exp ->
                    val active = i == selected
                    Div(attrs = Modifier.cursor(Cursor.Pointer).onClick { selected = i }.styleModifier {
                        property("flex", "0 0 auto")
                        property("padding", "6px 14px"); property("border-radius", "999px")
                        property("font-family", FONT_FAMILY.joinToString(",")); property("font-size", "13px")
                        property("font-weight", "600"); property("white-space", "nowrap")
                        property("color", if (active) "rgb(240,168,104)" else "rgb(126,130,140)")
                        property("background", if (active) Amber.A10 else "transparent")
                        property("border", "1px solid ${if (active) Amber.A25 else "transparent"}")
                        property("transition", "all 0.2s ease")
                    }.toAttrs()) { Text(stringResource(exp.companyKey)) }
                }
            }

            // description area for the selected program
            Column(modifier = Modifier.fillMaxWidth().padding(all = 16.px)) {
                Div(attrs = Modifier.fillMaxWidth().margin(bottom = 8.px).styleModifier {
                    property("display", "flex"); property("justify-content", "space-between")
                    property("align-items", "baseline"); property("gap", "12px"); property("flex-wrap", "wrap")
                }.toAttrs()) {
                    P(attrs = Modifier.margin(topBottom = 0.px).fontFamily(*FONT_FAMILY).fontSize(15.px)
                        .fontWeight(FontWeight.Bold).color(Theme.Primary.rgb).toAttrs()) {
                        Text(stringResource(current.jobPositionKey))
                    }
                    Span(attrs = Modifier.fontFamily(*MONO).fontSize(11.px).color(Theme.Gray.rgb).styleModifier {
                        property("white-space", "nowrap")
                    }.toAttrs()) {
                        Text("${stringResource(current.fromKey)} – ${stringResource(current.toKey)}")
                    }
                }
                P(attrs = Modifier.margin(topBottom = 0.px).fontFamily(*FONT_FAMILY).fontSize(13.px)
                    .lineHeight(1.7).color(Theme.Secondary.rgb).styleModifier {
                        property("white-space", "pre-line")
                    }.toAttrs()) {
                    Text(stringResource(current.descriptionKey))
                }
            }
        }
    }
}
