package org.example.garfend.components
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.example.garfend.models.Portfolio
import org.example.garfend.models.Theme
import org.example.garfend.styles.PortfolioSectionStyle
import org.example.garfend.styles.PortfolioCrossPlatformStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun portfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
) {
    // Check if this is a cross-platform app (has both store links)
    if (portfolio.links.isCrossPlatform()) {
        crossPlatformCard(modifier, portfolio)
    } else {
        singleLinkCard(modifier, portfolio)
    }
}

/**
 * Portfolio card for cross-platform apps with 2 icons (Apple & Android)
 * Uses smooth opacity transitions for bidirectional animation
 */
// kotlin
@Composable
private fun crossPlatformCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
) {
    // track hovered platform: "ios", "android", or null
    var hovered by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = PortfolioCrossPlatformStyle.toModifier()
            .styleModifier {
                property("display", "inline-block")
            }
            .textDecorationLine(TextDecorationLine.None)
    ) {
        Column(
            modifier = modifier
                .id("columnParent")
                .width(Width.MaxContent)
        ) {
            Box(
                modifier = Modifier
                    .id("boxParent")
                    .fillMaxWidth()
                    .maxWidth(300.px)
                    .margin(bottom = 20.px)
            ) {
                Image(
                    modifier = Modifier
                        .size(300.px)
                        .objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    alt = stringResource("portfolio_image_alt")
                )

                // Overlay with split iOS/Android sections
                Box(
                    modifier = Modifier
                        .id("greenOverlay")
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    // Wrapper with #linkIcon for CSS visibility animation
                    Column(
                        modifier = Modifier
                            .id("linkIcon")
                            .fillMaxSize()
                    ) {
                        // iOS Section (Top Half) - Gray background
                        Link(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.px)
                                .backgroundColor(argb(a = 0.85f, r = 128, g = 128, b = 128))
                                .textDecorationLine(TextDecorationLine.None)
                                .onMouseEnter { hovered = "ios" }
                                .onMouseLeave { hovered = null }
                                .opacity(
                                    when (hovered) {
                                        null -> 100.percent
                                        "ios" -> 100.percent
                                        else -> 40.percent
                                    }
                                ),
                            path = portfolio.links.appStore ?: "",
                            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(leftRight = 40.px),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = com.varabyte.kobweb.compose.foundation.layout.Arrangement.SpaceBetween
                            ) {
                                Image(
                                    modifier = Modifier.size(64.px),
                                    src = Res.Icon.apple,
                                    alt = "Apple Logo"
                                )
                                P(
                                    attrs = Modifier
                                        .margin(0.px)
                                        .textAlign(TextAlign.Center)
                                        .fontFamily(FONT_FAMILY)
                                        .fontSize(28.px)
                                        .fontWeight(FontWeight.Bold)
                                        .color(Theme.Secondary.rgb)
                                        .toAttrs()
                                ) { Text("IOS") }
                                Box(modifier = Modifier.padding(all = 0.px))
                            }
                        }

                        // Android Section (Bottom Half) - Green background
                        Link(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.px)
                                .backgroundColor(argb(a = 0.85f, r = 0, g = 100, b = 80))
                                .textDecorationLine(TextDecorationLine.None)
                                .onMouseEnter { hovered = "android" }
                                .onMouseLeave { hovered = null }
                                .opacity(
                                    when (hovered) {
                                        null -> 100.percent
                                        "android" -> 100.percent
                                        else -> 40.percent
                                    }
                                ),
                            path = portfolio.links.playStore ?: "",
                            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(leftRight = 40.px),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = com.varabyte.kobweb.compose.foundation.layout.Arrangement.SpaceBetween
                            ) {
                                Image(
                                    modifier = Modifier.size(64.px),
                                    src = Res.Icon.android,
                                    alt = "Android Logo"
                                )
                                P(
                                    attrs = Modifier
                                        .margin(0.px)
                                        .textAlign(TextAlign.Center)
                                        .fontFamily(FONT_FAMILY)
                                        .fontSize(28.px)
                                        .fontWeight(FontWeight.Bold)
                                        .color(Theme.Secondary.rgb)
                                        .toAttrs()
                                ) { Text("Android") }
                                Box(modifier = Modifier.padding(all = 0.px))
                            }
                        }
                    }
                }
            }
            P(
                attrs = Modifier
                    .id("portfolioTitle")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(stringResource(portfolio.titleKey))
            }
            P(
                attrs = Modifier
                    .id("portfolioDesc")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(stringResource(portfolio.description.titleKey))
            }
        }
    }
}


/**
 * Portfolio card for single-link projects with green overlay hover
 */
@Composable
private fun singleLinkCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
) {
    Link(
        modifier = PortfolioSectionStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None),
        path = portfolio.links.getPrimaryLink() ?: "",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(
            modifier = modifier
                .id("columnParent")
                .width(Width.MaxContent)
        ) {
            Box(
                modifier = Modifier
                    .id("boxParent")
                    .fillMaxWidth()
                    .maxWidth(300.px)
                    .margin(bottom = 20.px)
            ) {
                Image(
                    modifier = Modifier
                        .size(300.px)
                        .objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    alt = stringResource("portfolio_image_alt")
                )
                Box(
                    modifier = Modifier
                        .id("greenOverlay")
                        .fillMaxHeight()
                        .backgroundColor(argb(a = 0.5f, r = 0, g = 167, b = 142)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .id("linkIcon")
                            .size(32.px),
                        src = Res.Icon.link,
                        alt = stringResource("portfolio_link_icon_alt")
                    )
                }
            }
            P(
                attrs = Modifier
                    .id("portfolioTitle")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(stringResource(portfolio.titleKey))
            }
            P(
                attrs = Modifier
                    .id("portfolioDesc")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(stringResource(portfolio.description.titleKey))
            }
        }
    }
}