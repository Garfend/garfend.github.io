package org.example.garfend.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.example.garfend.components.LocalLanguage
import org.example.garfend.models.Language
import org.example.garfend.models.Theme
import org.example.garfend.styles.AboutTextStyle
import org.example.garfend.styles.NavigationItemStyle
import org.example.garfend.styles.SocialLinkStyle
import org.example.garfend.styles.LinkOverrideStyle
import org.example.garfend.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun socialBar(row: Boolean = false, title: Boolean = false, breakpoint: Breakpoint) {
    if (row) {
        Row(
            modifier = Modifier
                .margin(top = 25.px)
                .padding(leftRight = 25.px)
                .minHeight(40.px)
                .borderRadius(r = 20.px)
                .backgroundColor(Theme.LightGrayBg.rgb),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            socialLinks(row = true, title = title, breakpoint = breakpoint)
        }
    } else {
        Column(
            modifier = Modifier
                .margin(right = 25.px)
                .padding(topBottom = 25.px)
                .minWidth(40.px)
                .borderRadius(r = 20.px)
                .backgroundColor(Theme.LightGrayBg.rgb),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            socialLinks(title = title, breakpoint = breakpoint)
        }
    }
}

@Composable
private fun socialLinks(
    row: Boolean = false,
    title: Boolean = false,
    breakpoint: Breakpoint
) {
    Row {
        Link(
            path = "https://github.com/Garfend",
            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
        ) {
            FaGithub(
                modifier = SocialLinkStyle.toModifier()
                    .margin(
                        bottom = if (row) 0.px else 40.px,
                        right = if (row) 40.px else 0.px
                    ),
                size = IconSize.LG
            )
        }
        if (
            title
        ) {
            P(
                attrs = NavigationItemStyle.toModifier()
                    .margin(leftRight = 16.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .textAlign(textAlign = if (breakpoint > Breakpoint.MD) TextAlign.Center else TextAlign.Left)
                    .toAttrs()
            ) {

                Link(
                    path = "https://github.com/Garfend",
                    openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                    modifier = LinkOverrideStyle.toModifier()
                        .then(Modifier.textDecorationLine(TextDecorationLine.None))
                ) {
                    Text("Abdelrahman Abdelwahab github")
                }
            }
        }

    }
    if (LocalLanguage.current == Language.ARABIC) {
        if (row) {
            Box(modifier = Modifier.padding(leftRight = 8.px))
        }
    }
    Row {
        Link(
            path = "https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/",
            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,

            ) {
            FaLinkedin(
                modifier = SocialLinkStyle.toModifier(),
                size = IconSize.LG
            )
        }
        if (
            title
        ) {
            P(
                attrs = NavigationItemStyle.toModifier()
                    .margin(leftRight = 16.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .textAlign(textAlign = if (breakpoint > Breakpoint.MD) TextAlign.Center else TextAlign.Left)
                    .toAttrs()
            ) {

                Link(
                    path = "https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/",
                    openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                    modifier = LinkOverrideStyle.toModifier()
                        .then(Modifier.textDecorationLine(TextDecorationLine.None))
                ) {
                    Text("Abdelrahman Abdelwahab linkedin")
                }
            }

        }
    }
}