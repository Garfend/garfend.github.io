package org.example.garfend.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.components.SocialIconButton
import org.example.garfend.components.contactForm
import org.example.garfend.components.sectionTitle
import org.example.garfend.models.Section
import org.example.garfend.models.Theme
import org.example.garfend.util.Constants.CONTACT_PHONE
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun contactSection() {
    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(Theme.LightGrayBg.rgb),
        contentAlignment = Alignment.Center
    ) {
        contactContent()
    }
}

@Composable
fun contactContent() {
    val breakpoint = rememberBreakpoint()
    val isWide = breakpoint >= Breakpoint.MD

    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        sectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 25.px)
                .transition(Transition.of(property = "transform", duration = 500.ms)),
            section = Section.Contact,
            alignment = Alignment.CenterHorizontally
        )

        if (isWide) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.px),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                ContactInfoBlock()
                Box(modifier = Modifier.width(50.percent)) {
                    contactForm(breakpoint = breakpoint)
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.px),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ContactInfoBlock()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .margin(top = 20.px)
                ) {
                    contactForm(breakpoint = breakpoint)
                }
            }
        }
    }
}

@Composable
private fun ContactInfoBlock() {
    Column(
        modifier = Modifier
            .width( if (rememberBreakpoint() >= Breakpoint.MD) 40.percent else 100.percent)
            .margin(bottom = 20.px),
        horizontalAlignment = Alignment.Start
    ) {
        P(
            attrs = Modifier
                .margin(bottom = 12.px, top = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(28.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) { Text("Contact Me") }
        P(
            attrs = Modifier
                .margin(bottom = 16.px, top = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(15.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text("Please reach out with your name, email, subject, and message. I'm available for freelance work and collaborations.")
        }
        P(
            attrs = Modifier
                .margin(bottom = 10.px, top = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(15.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) { Text("Phone: $CONTACT_PHONE") }

        Row(horizontalArrangement = Arrangement.spacedBy(16.px)) {
            SocialIconButton(href = "https://github.com/Garfend") { FaGithub(size = IconSize.LG) }
            SocialIconButton(href = "https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/") { FaLinkedin(size = IconSize.LG) }
        }
    }
}
