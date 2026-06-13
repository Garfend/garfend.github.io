package org.example.garfend.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGFillType
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineCap
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineJoin
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeType
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.FaUpwork
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.example.garfend.models.Theme
import org.example.garfend.styles.ContactCardStyle
import org.example.garfend.util.Constants.CONTACT_EMAIL
import org.example.garfend.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContactIcons() {
    val breakpoint = rememberBreakpoint()
    val isWide = breakpoint >= Breakpoint.MD

    if (isWide) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.px),
            horizontalArrangement = Arrangement.spacedBy(20.px),
            verticalAlignment = Alignment.Top
        ) {
            ContactIconCard(
                modifier = Modifier.weight(1f),
                icon = { FaLinkedin(size = IconSize.LG) },
                labelKey = "contact_linkedin_label",
                descriptionKey = "contact_linkedin_desc",
                onClick = {
                    window.open(
                        "https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/",
                        "_blank"
                    )
                }
            )
            ContactIconCard(
                modifier = Modifier.weight(1f),
                icon = { FaUpwork(size = IconSize.LG) },
                labelKey = "contact_upwork_label",
                descriptionKey = "contact_upwork_desc",
                onClick = {
                    window.open(
                        "https://www.upwork.com/freelancers/~018456b0decc0006b0",
                        "_blank"
                    )
                }
            )
            ContactIconCard(
                modifier = Modifier.weight(1f),
                icon = { FaEnvelope(size = IconSize.LG) },
                labelKey = "contact_email_label",
                descriptionKey = "contact_email_desc",
                onClick = { window.location.href = "mailto:$CONTACT_EMAIL" }
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.px),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.px)
        ) {
            ContactIconCard(
                modifier = Modifier.fillMaxWidth(),
                icon = { FaLinkedin(size = IconSize.LG) },
                labelKey = "contact_linkedin_label",
                descriptionKey = "contact_linkedin_desc",
                onClick = {
                    window.open(
                        "https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/",
                        "_blank"
                    )
                }
            )
            ContactIconCard(
                modifier = Modifier.fillMaxWidth(),
                icon = { FaUpwork(size = IconSize.LG) },
                labelKey = "contact_upwork_label",
                descriptionKey = "contact_upwork_desc",
                onClick = {
                    window.open(
                        "https://www.upwork.com/freelancers/~018456b0decc0006b0",
                        "_blank"
                    )
                }
            )
            ContactIconCard(
                modifier = Modifier.fillMaxWidth(),
                icon = { FaEnvelope(size = IconSize.LG) },
                labelKey = "contact_email_label",
                descriptionKey = "contact_email_desc",
                onClick = { window.location.href = "mailto:$CONTACT_EMAIL" }
            )
        }
    }
}

@Composable
private fun ContactIconCard(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    labelKey: String,
    descriptionKey: String,
    onClick: () -> Unit
) {
    Column(
        modifier = ContactCardStyle.toModifier()
            .then(modifier)
            .padding(all = 24.px)
            .onClick { onClick() }
            .styleModifier {
                property("background", "rgba(27,31,38,0.5)")
                property("backdrop-filter", "blur(20px)")
                property("-webkit-backdrop-filter", "blur(20px)")
                property("border", "1px solid rgba(255,255,255,0.10)")
                property("border-radius", "14px")
                property("cursor", "pointer")
                property("transition", "all 0.2s ease")
            },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // Icon box: 40×40, amber-tinted background, centered icon, amber icon color
        Box(
            modifier = Modifier
                .size(40.px)
                .margin(bottom = 16.px)
                .borderRadius(10.px)
                .styleModifier {
                    property("background", "rgba(240,168,104,0.14)")
                    property("color", "rgb(240,168,104)")
                    property("display", "flex")
                    property("align-items", "center")
                    property("justify-content", "center")
                },
            contentAlignment = Alignment.Center
        ) {
            icon()
        }

        // Title
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 6.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(17.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .textAlign(TextAlign.Start)
                .toAttrs()
        ) {
            Text(stringResource(labelKey))
        }

        // Subtitle / description
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Gray.rgb)
                .textAlign(TextAlign.Start)
                .styleModifier {
                    property("line-height", "1.5")
                    property("word-wrap", "break-word")
                    property("overflow-wrap", "break-word")
                }
                .toAttrs()
        ) {
            Text(stringResource(descriptionKey))
        }

        // Arrow ↗ (up-right), bottom-right — animates on hover via CSS (parent hover drives transform)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 16.px),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Svg(attrs = {
                classes("contact-arrow")
                width(18)
                height(18)
                viewBox(0, 0, 24, 24)
                fill(SVGFillType.None)
                stroke(SVGStrokeType.CurrentColor)
                strokeWidth(2)
            }) {
                Path {
                    d("M7 17 17 7M7 7h10v10")
                    strokeLineCap(SVGStrokeLineCap.Round)
                    strokeLineJoin(SVGStrokeLineJoin.Round)
                }
            }
        }
    }
}
