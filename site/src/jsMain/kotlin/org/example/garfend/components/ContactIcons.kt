package org.example.garfend.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaBriefcase
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.FaU
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
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContactIcons() {
    val breakpoint = rememberBreakpoint()
    val isWide = breakpoint >= Breakpoint.MD

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.px),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        P(
            attrs = Modifier
                .margin(bottom = 30.px, top = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(if (isWide) 28.px else 24.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text(stringResource("contact_title"))
        }

        P(
            attrs = Modifier
                .margin(bottom = 40.px, top = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(if (isWide) 18.px else 16.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .textAlign(TextAlign.Center)
                .fillMaxWidth(if (isWide) 70.percent else 90.percent)
                .toAttrs()
        ) {
            Text(stringResource("contact_description"))
        }

        if (isWide) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ContactIconCard(
                    icon = { FaLinkedin(size = IconSize.XXL) },
                    labelKey = "contact_linkedin_label",
                    descriptionKey = "contact_linkedin_desc",
                    onClick = { window.open("https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/", "_blank") }
                )
                Box(modifier = Modifier.size(24.px))
                ContactIconCard(
                    icon = { FaUpwork(size = IconSize.XXL) },
                    labelKey = "contact_upwork_label",
                    descriptionKey = "contact_upwork_desc",
                    onClick = { window.open("https://www.upwork.com/freelancers/~018456b0decc0006b0", "_blank") }
                )
                Box(modifier = Modifier.size(24.px))
                ContactIconCard(
                    icon = { FaEnvelope(size = IconSize.XXL) },
                    labelKey = "contact_email_label",
                    descriptionKey = "contact_email_desc",
                    onClick = { window.location.href = "mailto:$CONTACT_EMAIL" }
                )
            }
        } else {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ContactIconCard(
                    icon = { FaLinkedin(size = IconSize.XXL) },
                    labelKey = "contact_linkedin_label",
                    descriptionKey = "contact_linkedin_desc",
                    onClick = { window.open("https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/", "_blank") },
                    fullWidth = true
                )
                Box(modifier = Modifier.size(16.px))
                ContactIconCard(
                    icon = { FaUpwork(size = IconSize.XXL) },
                    labelKey = "contact_upwork_label",
                    descriptionKey = "contact_upwork_desc",
                    onClick = { window.open("https://www.upwork.com/freelancers/~018456b0decc0006b0", "_blank") },
                    fullWidth = true
                )
                Box(modifier = Modifier.size(16.px))
                ContactIconCard(
                    icon = { FaEnvelope(size = IconSize.XXL) },
                    labelKey = "contact_email_label",
                    descriptionKey = "contact_email_desc",
                    onClick = { window.location.href = "mailto:$CONTACT_EMAIL" },
                    fullWidth = true
                )
            }
        }
    }
}

@Composable
private fun ContactIconCard(
    icon: @Composable () -> Unit,
    labelKey: String,
    descriptionKey: String,
    onClick: () -> Unit,
    fullWidth: Boolean = false
) {
    Column(
        modifier = ContactCardStyle.toModifier()
            .fillMaxWidth(if (fullWidth) 90.percent else 30.percent)
            .minHeight(240.px)
            .padding(all = 30.px)
            .onClick { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .id("iconBox")
                .margin(bottom = 20.px)
        ) {
            Box(
                modifier = Modifier
                    .size(80.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .borderRadius(50.percent)
                    .padding(20.px),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }
        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 10.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text(stringResource(labelKey))
        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Gray.rgb)
                .textAlign(TextAlign.Center)
                .styleModifier {
                    property("line-height", "1.5")
                    property("word-wrap", "break-word")
                    property("overflow-wrap", "break-word")
                }
                .toAttrs()
        ) {
            Text(stringResource(descriptionKey))
        }
    }
}
