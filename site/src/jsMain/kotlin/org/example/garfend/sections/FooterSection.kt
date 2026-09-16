package org.example.garfend.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.components.stringResource
import org.example.garfend.models.Section
import org.example.garfend.models.Theme
import org.example.garfend.styles.FooterLinkStyle
import org.example.garfend.styles.FooterMonoLinkStyle
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun footerSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .styleModifier {
                property("border-top", "1px solid rgba(255,255,255,0.06)")
            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .maxWidth(SECTION_WIDTH.px)
                .padding(topBottom = 60.px),
            contentAlignment = Alignment.Center
        ) {
            footerContent()
        }
    }
}

@Composable
private fun footerContent() {
    val breakpoint = rememberBreakpoint()
    val isWide = breakpoint >= Breakpoint.MD

    Column(
        modifier = Modifier
            .fillMaxWidth(if (isWide) 100.percent else 90.percent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.px)
    ) {
        // Nav links row / column
        if (isWide) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                footerNavLinks(row = true)
            }
        } else {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.px)
            ) {
                footerNavLinks(row = false)
            }
        }

        // Social / code links row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            footerSocialLinks()
        }

        // Copyright line
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily("JetBrains Mono", "monospace")
                .fontSize(12.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Gray.rgb)
                .toAttrs()
        ) {
            Text(stringResource("footer_copyright"))
        }
    }
}

@Composable
private fun footerNavLinks(row: Boolean) {
    Section.navEntries.forEach { section ->
        Link(
            modifier = FooterLinkStyle.toModifier()
                .fontFamily(*FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .padding(topBottom = 6.px, leftRight = 14.px)
                .textDecorationLine(TextDecorationLine.None),
            path = section.path,
            text = stringResource(section.titleKey)
        )
    }
}

@Composable
private fun footerSocialLinks() {
    Link(
        modifier = FooterMonoLinkStyle.toModifier()
            .fontFamily("JetBrains Mono", "monospace")
            .fontSize(12.px)
            .fontWeight(FontWeight.Normal)
            .margin(right = 24.px)
            .textDecorationLine(TextDecorationLine.None),
        path = "https://github.com/Garfend",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        text = "github.com/Garfend"
    )
    Link(
        modifier = FooterMonoLinkStyle.toModifier()
            .fontFamily("JetBrains Mono", "monospace")
            .fontSize(12.px)
            .fontWeight(FontWeight.Normal)
            .textDecorationLine(TextDecorationLine.None),
        path = "https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        text = "linkedin.com/in/abdelrahman-abdelwahab"
    )
}
