package org.example.garfend.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.*
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
import org.example.garfend.models.DevelopmentStatus
import org.example.garfend.models.LinkType
import org.example.garfend.models.Portfolio
import org.example.garfend.models.Theme
import org.example.garfend.styles.PortfolioCrossPlatformStyle
import org.example.garfend.styles.PortfolioSectionStyle
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Res
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun portfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
    appearDelayMs: Int = 0
) {
    if (portfolio.links.isCrossPlatform()) {
        crossPlatformCard(modifier, portfolio, appearDelayMs)
    } else {
        singleLinkCard(modifier, portfolio, appearDelayMs)
    }
}

// ──────────────────────────────────────────────────────────────────
// Cross-platform card: iOS & Android split-panel hover animation
// ──────────────────────────────────────────────────────────────────
@Composable
private fun crossPlatformCard(
    modifier: Modifier,
    portfolio: Portfolio,
    appearDelayMs: Int
) {
    var hovered by remember { mutableStateOf<String?>(null) }
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    Box(
        modifier = PortfolioCrossPlatformStyle.toModifier()
            .then(modifier)
            .styleModifier {
                property("display", "inline-flex")
                property("flex-direction", "column")
                property("background", "linear-gradient(180deg, rgba(20,23,28,0.55) 0%, rgba(20,23,28,0.75) 100%)")
                property("backdrop-filter", "blur(22px) saturate(170%)")
                property("-webkit-backdrop-filter", "blur(22px) saturate(170%)")
                property("border", "1px solid rgba(255,255,255,0.08)")
                property("border-radius", "14px")
                property("overflow", "hidden")
                property("box-shadow", "inset 0 1px 0 rgba(255,255,255,0.14), inset 0 -1px 0 rgba(0,0,0,0.22), 0 22px 50px -22px rgba(0,0,0,0.6)")
                property("transform", if (visible) "translateY(0)" else "translateY(25px)")
                property("opacity", if (visible) "1" else "0")
                property("transition",
                    "transform 450ms ease ${appearDelayMs}ms, " +
                    "opacity 450ms ease ${appearDelayMs}ms"
                )
            }
    ) {
        Column(
            modifier = Modifier
                .id("columnParent")
                // A definite 300px (the cover image's width), shrinking only when the grid cell
                // is narrower. It must NOT be max-content: under content sizing the text below
                // sets the width, so a wider font — or the fallback one, before the webfont
                // loads — pushes the meta line past the cap and the right padding disappears.
                .width(300.px)
                .maxWidth(100.percent)
        ) {
            // ── Cover image with iOS/Android hover overlay ──
            Box(
                modifier = Modifier
                    .id("boxParent")
                    .fillMaxWidth()
                    .maxWidth(300.px)
                    .overflow(Overflow.Hidden)
            ) {
                Image(
                    modifier = Modifier
                        .size(300.px)
                        .objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    alt = stringResource("portfolio_image_alt")
                )

                statusPill(portfolio.status)

                // Animated overlay (iOS / Android split panel)
                Box(
                    modifier = Modifier
                        .id("greenOverlay")
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .id("linkIcon")
                            .fillMaxSize()
                    ) {
                        // iOS section (top half)
                        Link(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.percent)
                                .textDecorationLine(TextDecorationLine.None)
                                .onMouseEnter { hovered = "ios" }
                                .onMouseLeave { hovered = null }
                                .opacity(
                                    when (hovered) {
                                        null -> 100.percent
                                        "ios" -> 100.percent
                                        else -> 40.percent
                                    }
                                )
                                .styleModifier {
                                    property("background", "rgba(20,23,28,0.82)")
                                    property("backdrop-filter", "blur(8px)")
                                },
                            path = portfolio.links.appStore ?: "",
                            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(leftRight = 32.px),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(
                                    modifier = Modifier.size(48.px),
                                    src = Res.Icon.apple,
                                    alt = stringResource("alt_app_store")
                                )
                                P(
                                    attrs = Modifier
                                        .margin(0.px)
                                        .fontFamily(*FONT_FAMILY)
                                        .fontSize(22.px)
                                        .fontWeight(FontWeight.Bold)
                                        .color(Theme.Primary.rgb)
                                        .toAttrs()
                                ) { Text(stringResource("platform_label_ios")) }
                                Box(modifier = Modifier.size(48.px))
                            }
                        }

                        // Android section (bottom half)
                        Link(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.percent)
                                .textDecorationLine(TextDecorationLine.None)
                                .onMouseEnter { hovered = "android" }
                                .onMouseLeave { hovered = null }
                                .opacity(
                                    when (hovered) {
                                        null -> 100.percent
                                        "android" -> 100.percent
                                        else -> 40.percent
                                    }
                                )
                                .styleModifier {
                                    property("background", "rgba(10,40,32,0.85)")
                                    property("backdrop-filter", "blur(8px)")
                                },
                            path = portfolio.links.playStore ?: "",
                            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(leftRight = 32.px),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(
                                    modifier = Modifier.size(48.px),
                                    src = Res.Icon.android,
                                    alt = stringResource("alt_google_play")
                                )
                                P(
                                    attrs = Modifier
                                        .margin(0.px)
                                        .fontFamily(*FONT_FAMILY)
                                        .fontSize(22.px)
                                        .fontWeight(FontWeight.Bold)
                                        .color(Theme.Primary.rgb)
                                        .toAttrs()
                                ) { Text(stringResource("platform_label_android")) }
                                Box(modifier = Modifier.size(48.px))
                            }
                        }
                    }
                }
            }

            // ── Card body ──
            cardBody(portfolio)
        }
    }
}

// ──────────────────────────────────────────────────────────────────
// Single-link card: amber overlay with link icon on hover
// ──────────────────────────────────────────────────────────────────
@Composable
private fun singleLinkCard(
    modifier: Modifier,
    portfolio: Portfolio,
    appearDelayMs: Int
) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    Box(
        modifier = PortfolioSectionStyle.toModifier()
            .then(modifier)
            .styleModifier {
                property("display", "inline-flex")
                property("flex-direction", "column")
                property("background", "linear-gradient(180deg, rgba(20,23,28,0.55) 0%, rgba(20,23,28,0.75) 100%)")
                property("backdrop-filter", "blur(22px) saturate(170%)")
                property("-webkit-backdrop-filter", "blur(22px) saturate(170%)")
                property("border", "1px solid rgba(255,255,255,0.08)")
                property("border-radius", "14px")
                property("overflow", "hidden")
                property("box-shadow", "inset 0 1px 0 rgba(255,255,255,0.14), inset 0 -1px 0 rgba(0,0,0,0.22), 0 22px 50px -22px rgba(0,0,0,0.6)")
                property("transform", if (visible) "translateY(0)" else "translateY(25px)")
                property("opacity", if (visible) "1" else "0")
                property("transition",
                    "transform 450ms ease ${appearDelayMs}ms, " +
                    "opacity 450ms ease ${appearDelayMs}ms"
                )
            }
    ) {
        Column(
            modifier = Modifier
                .id("columnParent")
                // Same sizing rule as the cross-platform card — see the note there.
                .width(300.px)
                .maxWidth(100.percent)
        ) {
            // ── Cover image with amber overlay on hover ──
            Box(
                modifier = Modifier
                    .id("boxParent")
                    .fillMaxWidth()
                    .maxWidth(300.px)
                    .overflow(Overflow.Hidden)
            ) {
                Image(
                    modifier = Modifier
                        .size(300.px)
                        .objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    alt = stringResource("portfolio_image_alt")
                )

                statusPill(portfolio.status)

                Box(
                    modifier = Modifier
                        .id("greenOverlay")
                        .fillMaxHeight()
                        .backgroundColor(argb(a = 0.55f, r = 240, g = 168, b = 104)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .id("linkIcon")
                            .size(36.px),
                        src = Res.Icon.link,
                        alt = stringResource("portfolio_link_icon_alt")
                    )
                }
            }

            // ── Card body ──
            cardBody(portfolio)
        }
    }
}

// ──────────────────────────────────────────────────────────────────
// Shared card body (store chips + title + meta + CTA)
// ──────────────────────────────────────────────────────────────────
@Composable
private fun cardBody(portfolio: Portfolio) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 22.px)
            .styleModifier {
                property("gap", "12px")
                property("flex", "1")
                // Without this a long child can refuse to shrink below its own content width.
                property("min-width", "0")
            }
    ) {
        // Store chips
        val links = portfolio.links.getAllLinks()
        if (links.isNotEmpty()) {
            Row(
                modifier = Modifier.styleModifier { property("gap", "8px"); property("flex-wrap", "wrap") }
            ) {
                links.forEach { (type, url) ->
                    storeChip(label = chipLabel(type), url = url)
                }
            }
        }

        // Title
        Link(
            path = "/portfolio/${portfolio.urlId}",
            modifier = Modifier
                .fillMaxWidth()
                .textDecorationLine(TextDecorationLine.None)
                .styleModifier { property("transition", "color 0.2s ease") }
        ) {
            P(
                attrs = Modifier
                    .id("portfolioTitle")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .styleModifier {
                        property("letter-spacing", "-0.01em")
                        property("min-width", "0")
                        // One line, always: a wrapped title would make this card taller than the
                        // rest of its row. The status moved onto the cover art for the same
                        // reason, which is what keeps every real title short enough to fit.
                        property("white-space", "nowrap")
                        property("overflow", "hidden")
                        property("text-overflow", "ellipsis")
                    }
                    .toAttrs()
            ) {
                Text(stringResource(portfolio.titleKey))
            }
        }

        // Meta: category
        val categoryLabel = stringResource(portfolio.description.titleKey)
        P(
            attrs = Modifier
                .id("portfolioDesc")
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontFamily("JetBrains Mono", "monospace")
                .fontSize(12.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Gray.rgb)
                .styleModifier {
                    // Ellipsis rather than wrap: the fix for an over-long category must not make
                    // this card taller than its neighbours.
                    property("min-width", "0")
                    property("white-space", "nowrap")
                    property("overflow", "hidden")
                    property("text-overflow", "ellipsis")
                }
                // Truncated labels stay readable on hover.
                .toAttrs { attr("title", categoryLabel) }
        ) {
            Text(categoryLabel)
        }

        // View case study CTA
        Link(
            path = "/portfolio/${portfolio.urlId}",
            modifier = Modifier
                .textDecorationLine(TextDecorationLine.None)
                .styleModifier {
                    property("display", "inline-flex")
                    property("align-items", "center")
                    property("gap", "6px")
                    property("font-size", "13px")
                    property("color", "rgb(240,168,104)")
                    property("margin-top", "auto")
                    property("transition", "gap 0.2s ease")
                    property("font-family", "Inter, sans-serif")
                }
        ) {
            Text(stringResource("link_view_case_study"))
        }
    }
}

@Composable
private fun storeChip(label: String, url: String) {
    Link(
        path = url,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        modifier = Modifier
            .textDecorationLine(TextDecorationLine.None)
            .styleModifier {
                property("display", "inline-flex")
                property("align-items", "center")
                property("gap", "6px")
                property("font-size", "12px")
                property("padding", "5px 12px")
                property("border-radius", "999px")
                property("border", "1px solid rgba(255,255,255,0.10)")
                property("background", "rgba(27,31,38,0.55)")
                property("backdrop-filter", "blur(14px)")
                property("color", "rgb(182,186,195)")
                property("transition", "color 0.2s ease, border-color 0.2s ease")
                property("font-family", "Inter, sans-serif")
            }
    ) {
        Text(label)
    }
}

@Composable
private fun chipLabel(type: LinkType): String = when (type) {
    LinkType.APP_STORE  -> stringResource("chip_link_app_store")
    LinkType.PLAY_STORE -> stringResource("chip_link_play_store")
    LinkType.GITHUB     -> stringResource("chip_link_github")
    LinkType.WEBSITE    -> stringResource("chip_link_website")
    LinkType.FIGMA      -> stringResource("chip_link_figma")
    LinkType.OTHER      -> stringResource("chip_link_other")
}

/**
 * Development status, drawn over the top-right of the cover art.
 *
 * It used to be appended to the title ("NOURISH Durham (In testing)"), which wrapped to a second
 * line and made that one card taller than every other card in its row. Here it costs no layout
 * height at all, and the title stays whole.
 */
@Composable
private fun BoxScope.statusPill(status: DevelopmentStatus) {
    val label = when (status) {
        DevelopmentStatus.IN_DEVELOPMENT -> stringResource("status_in_development")
        DevelopmentStatus.IN_TESTING     -> stringResource("status_in_testing")
        DevelopmentStatus.PRODUCTION     -> return
    }

    Box(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .margin(12.px)
            .styleModifier {
                property("padding", "5px 11px")
                property("border-radius", "999px")
                property("background", "rgba(20,23,28,0.82)")
                property("border", "1px solid rgba(240,168,104,0.45)")
                property("backdrop-filter", "blur(10px)")
                property("-webkit-backdrop-filter", "blur(10px)")
                // The cross-platform card puts its iOS/Android links under this corner.
                property("pointer-events", "none")
            }
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily("JetBrains Mono", "monospace")
                .fontSize(11.px)
                .color(org.example.garfend.models.Theme.LightRed.rgb)
                .styleModifier {
                    property("letter-spacing", "0.06em")
                    property("white-space", "nowrap")
                }
                .toAttrs()
        ) {
            Text(label)
        }
    }
}
