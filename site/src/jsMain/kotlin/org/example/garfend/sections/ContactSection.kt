package org.example.garfend.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.components.ContactIcons
import org.example.garfend.components.sectionTitle
import org.example.garfend.components.stringResource
import org.example.garfend.models.Section
import org.example.garfend.models.Theme
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Constants.SECTION_WIDTH
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
            .padding(topBottom = 100.px),
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
            .fillMaxWidth(if (isWide) 90.percent else 92.percent),
        horizontalAlignment = Alignment.Start
    ) {
        // Eyebrow only (headline is inside the wrap)
        sectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 32.px),
            section = Section.Contact,
            eyebrow = stringResource("eyebrow_contact"),
            mainTitle = "",
            alignment = Alignment.Start
        )

        // Glass wrap container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .styleModifier {
                    property("background",
                        "radial-gradient(80% 100% at 0% 0%, rgba(240,168,104,0.16), transparent 60%), " +
                        "linear-gradient(180deg, rgba(20,23,28,0.55) 0%, rgba(20,23,28,0.75) 100%)")
                    property("backdrop-filter", "blur(28px) saturate(170%)")
                    property("-webkit-backdrop-filter", "blur(28px) saturate(170%)")
                    property("border", "1px solid rgba(255,255,255,0.10)")
                    property("border-radius", "22px")
                    property("padding", "clamp(40px, 6vw, 72px)")
                    property("box-shadow",
                        "inset 0 1px 0 rgba(255,255,255,0.16), " +
                        "inset 0 -1px 0 rgba(0,0,0,0.25), " +
                        "0 30px 60px -30px rgba(0,0,0,0.70)")
                }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                // Headline
                P(
                    attrs = Modifier
                        .fillMaxWidth()
                        .margin(top = 0.px, bottom = 14.px)
                        .fontFamily(*FONT_FAMILY)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .styleModifier {
                            property("font-size", "clamp(32px, 4vw, 48px)")
                            property("letter-spacing", "-0.02em")
                            property("line-height", "1.1")
                        }
                        .toAttrs()
                ) { Text(stringResource("contact_title")) }

                // Blurb
                P(
                    attrs = Modifier
                        .margin(top = 0.px, bottom = 40.px)
                        .fontFamily(*FONT_FAMILY)
                        .fontSize(17.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .styleModifier {
                            property("max-width", "540px")
                            property("line-height", "1.65")
                        }
                        .toAttrs()
                ) { Text(stringResource("contact_description")) }

                // Contact cards
                ContactIcons()
            }
        }
    }
}
