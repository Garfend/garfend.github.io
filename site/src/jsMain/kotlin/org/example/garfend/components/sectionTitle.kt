package org.example.garfend.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.example.garfend.models.Section
import org.example.garfend.models.Theme
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.observeViewportEntered
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Section title with eyebrow label and large heading, matching the design system.
 *
 * @param eyebrow   e.g. "01 — About me"  (mono, amber, uppercase)
 * @param mainTitle e.g. "Engineering precision."  (large bold heading)
 */
@Composable
fun sectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    eyebrow: String = "",
    mainTitle: String = "",
    alignment: Alignment.Horizontal = Alignment.Start
) {
    var visible by remember { mutableStateOf(false) }

    observeViewportEntered(
        sectionId = section.id,
        distanceFromTop = 700.0,
        onViewportEntered = { visible = true }
    )

    val textAlign = when (alignment) {
        Alignment.CenterHorizontally -> TextAlign.Center
        Alignment.End -> TextAlign.End
        else -> TextAlign.Start
    }

    val eyebrowText = eyebrow.ifEmpty { stringResource(section.titleKey) }

    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        // Eyebrow: ── 01 — About me
        Row(
            modifier = Modifier
                .margin(bottom = 18.px)
                .styleModifier {
                    property("opacity", if (visible) "1" else "0")
                    property("transform", if (visible) "translateY(0)" else "translateY(12px)")
                    property("transition", "opacity 0.4s ease, transform 0.4s ease")
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Leading dash line
            if (alignment != Alignment.CenterHorizontally) {
                org.jetbrains.compose.web.dom.Span(
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
            }
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily("JetBrains Mono", "monospace")
                    .fontSize(13.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.LightRed.rgb)
                    .textAlign(textAlign)
                    .styleModifier {
                        property("letter-spacing", "0.08em")
                        property("text-transform", "uppercase")
                    }
                    .toAttrs()
            ) {
                Text(eyebrowText)
            }
        }

        // Main title (large bold heading)
        if (mainTitle.isNotEmpty()) {
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .textAlign(textAlign)
                    .styleModifier {
                        property("font-size", "clamp(36px, 5vw, 52px)")
                        property("letter-spacing", "-0.02em")
                        property("line-height", "1.05")
                        property("opacity", if (visible) "1" else "0")
                        property("transform", if (visible) "translateY(0)" else "translateY(12px)")
                        property("transition", "opacity 0.5s ease 0.08s, transform 0.5s ease 0.08s")
                    }
                    .toAttrs()
            ) {
                Text(mainTitle)
            }
        }
    }
}
