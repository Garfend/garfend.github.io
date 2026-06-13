package org.example.garfend.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.models.LinkType
import org.example.garfend.models.Portfolio
import org.example.garfend.models.Theme
import org.example.garfend.services.AppStoreMetadata
import org.example.garfend.services.AppStoreService
import org.example.garfend.styles.AppStoreButtonStyle
import org.example.garfend.styles.AppStorePrimaryButtonStyle
import org.example.garfend.styles.InfoSectionStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

private val AmberAccent = "rgb(240,168,104)"
private val ErrorRed = argb(a = 1f, r = 220, g = 38, b = 38)

@Composable
fun PortfolioDetailContent(portfolio: Portfolio) {
    val breakpoint = rememberBreakpoint()

    var appStoreData by remember { mutableStateOf<AppStoreMetadata?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    var fetchError by remember { mutableStateOf(false) }

    val shouldFetchFromAppStore = portfolio.links.appStore != null

    LaunchedEffect(portfolio) {
        if (shouldFetchFromAppStore) {
            isLoading = true
            fetchError = false

            val metadata = AppStoreService.fetchAppMetadata(portfolio.links.appStore!!)
            if (metadata != null) {
                appStoreData = metadata
                console.log("Successfully fetched App Store data for ${portfolio.title}")
            } else {
                fetchError = true
                console.error("Failed to fetch App Store data for ${portfolio.title}")
            }
            isLoading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(28.px),
        horizontalAlignment = Alignment.Start
    ) {
        DownloadSection(
            portfolio = portfolio,
            breakpoint = breakpoint,
            appStoreData = appStoreData,
            isLoading = isLoading,
            fetchError = fetchError,
            shouldFetchFromAppStore = shouldFetchFromAppStore
        )

        AboutSection(
            portfolio = portfolio,
            appStoreData = appStoreData,
            isLoading = isLoading,
            fetchError = fetchError,
            shouldFetchFromAppStore = shouldFetchFromAppStore
        )

        AppInfoSection(
            portfolio = portfolio,
            appStoreData = appStoreData,
            isLoading = isLoading,
            fetchError = fetchError,
            shouldFetchFromAppStore = shouldFetchFromAppStore
        )
    }
}

@Composable
private fun SectionEyebrow(number: String, label: String) {
    Row(
        modifier = Modifier.margin(bottom = 14.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Span(
            attrs = Modifier
                .styleModifier {
                    property("display", "inline-block")
                    property("width", "24px")
                    property("height", "1px")
                    property("background", AmberAccent)
                    property("margin-right", "10px")
                    property("flex-shrink", "0")
                }
                .toAttrs()
        ) {}
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily("JetBrains Mono", "monospace")
                .fontSize(12.px)
                .color(Theme.LightRed.rgb)
                .styleModifier {
                    property("letter-spacing", "0.10em")
                    property("text-transform", "uppercase")
                }
                .toAttrs()
        ) {
            Text("$number — $label")
        }
    }
}

@Composable
private fun DownloadSection(
    portfolio: Portfolio,
    breakpoint: Breakpoint,
    appStoreData: AppStoreMetadata?,
    isLoading: Boolean,
    fetchError: Boolean,
    shouldFetchFromAppStore: Boolean
) {
    Column(
        modifier = InfoSectionStyle.toModifier()
            .fillMaxWidth()
            .gap(24.px)
    ) {
        SectionEyebrow(number = "01", label = "Get it")

        // Rating / version display
        if (shouldFetchFromAppStore) {
            if (isLoading || appStoreData != null || fetchError) {
                Row(
                    modifier = Modifier
                        .gap(28.px)
                        .padding(leftRight = 22.px, topBottom = 18.px)
                        .borderRadius(14.px)
                        .styleModifier {
                            property("background", "rgba(27,31,38,0.55)")
                            property("border", "1px solid rgba(255,255,255,0.08)")
                            property("backdrop-filter", "blur(18px) saturate(160%)")
                            property("-webkit-backdrop-filter", "blur(18px) saturate(160%)")
                            property("box-shadow", "inset 0 1px 0 rgba(255,255,255,0.10), inset 0 -1px 0 rgba(0,0,0,0.18)")
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    when {
                        isLoading -> {
                            Span(
                                attrs = Modifier
                                    .fontSize(14.px)
                                    .color(Theme.Gray.rgb)
                                    .fontFamily("JetBrains Mono", "monospace")
                                    .toAttrs()
                            ) {
                                Text(stringResource("app_store_loading"))
                            }
                        }
                        fetchError -> {
                            Span(
                                attrs = Modifier
                                    .fontSize(14.px)
                                    .color(ErrorRed)
                                    .fontFamily("Inter", "sans-serif")
                                    .toAttrs()
                            ) {
                                Text(stringResource("app_store_load_failed"))
                            }
                        }
                        appStoreData != null -> {
                            val rating = AppStoreService.formatRating(appStoreData.averageUserRating)
                            val version = appStoreData.version
                            val ratingCount = appStoreData.userRatingCount

                            if (rating != "N/A" && rating != "0.0") {
                                StatPill(
                                    bigValue = rating,
                                    sub = if (ratingCount > 0) "★★★★★ (${AppStoreService.formatRatingCount(ratingCount)})" else "★★★★★",
                                    breakpoint = breakpoint
                                )
                                Divider()
                            }

                            StatPill(
                                bigValue = version,
                                sub = stringResource("label_version"),
                                breakpoint = breakpoint,
                                small = true
                            )
                        }
                    }
                }
            }
        } else if (portfolio.rating != "N/A") {
            Row(
                modifier = Modifier
                    .gap(28.px)
                    .padding(leftRight = 22.px, topBottom = 18.px)
                    .borderRadius(14.px)
                    .styleModifier {
                        property("background", "rgba(27,31,38,0.55)")
                        property("border", "1px solid rgba(255,255,255,0.08)")
                        property("backdrop-filter", "blur(18px) saturate(160%)")
                        property("-webkit-backdrop-filter", "blur(18px) saturate(160%)")
                        property("box-shadow", "inset 0 1px 0 rgba(255,255,255,0.10), inset 0 -1px 0 rgba(0,0,0,0.18)")
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                StatPill(
                    bigValue = portfolio.rating,
                    sub = "★★★★★",
                    breakpoint = breakpoint
                )
                Divider()
                StatPill(
                    bigValue = portfolio.version,
                    sub = "Version",
                    breakpoint = breakpoint,
                    small = true
                )
            }
        }

        // Download buttons — first is primary (amber), rest are glass
        if (portfolio.links.hasLinks()) {
            val allLinks = portfolio.links.getAllLinks()
            SimpleGrid(
                numColumns = numColumns(base = 1, sm = allLinks.size.coerceAtMost(2)),
                modifier = Modifier
                    .fillMaxWidth()
                    .gap(12.px)
            ) {
                allLinks.forEachIndexed { index, (linkType, url) ->
                    DownloadButton(linkType = linkType, url = url, primary = index == 0)
                }
            }
        }
    }
}

@Composable
private fun StatPill(bigValue: String, sub: String, breakpoint: Breakpoint, small: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.gap(6.px)
    ) {
        Span(
            attrs = Modifier
                .fontSize(
                    if (small) (if (breakpoint >= Breakpoint.MD) 22.px else 18.px)
                    else (if (breakpoint >= Breakpoint.MD) 44.px else 32.px)
                )
                .fontWeight(FontWeight.Bold)
                .color(Theme.LightRed.rgb)
                .fontFamily("Inter", "sans-serif")
                .styleModifier {
                    property("letter-spacing", "-0.02em")
                    property("line-height", "1")
                }
                .toAttrs()
        ) {
            Text(bigValue)
        }
        Span(
            attrs = Modifier
                .fontSize(11.px)
                .color(Theme.Gray.rgb)
                .fontFamily("JetBrains Mono", "monospace")
                .styleModifier {
                    property("letter-spacing", "0.08em")
                    property("text-transform", "uppercase")
                }
                .toAttrs()
        ) {
            Text(sub)
        }
    }
}

@Composable
private fun Divider() {
    org.jetbrains.compose.web.dom.Div(
        attrs = Modifier
            .width(1.px)
            .height(48.px)
            .styleModifier {
                property("background", "rgba(255,255,255,0.08)")
            }
            .toAttrs()
    )
}

@Composable
private fun DownloadButton(linkType: LinkType, url: String, primary: Boolean) {
    val style = if (primary) AppStorePrimaryButtonStyle else AppStoreButtonStyle
    val color = if (primary) argb(a = 1f, r = 26, g = 18, b = 8) else Theme.Primary.rgb

    Link(
        path = url,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        modifier = style.toModifier().fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .gap(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            I(attrs = Modifier
                .fontSize(20.px)
                .color(color)
                .toAttrs {
                    linkType.icon.split(" ").forEach { classes(it) }
                }
            )
            Span(
                attrs = Modifier
                    .fontSize(15.px)
                    .fontWeight(FontWeight.SemiBold)
                    .color(color)
                    .fontFamily("Inter", "sans-serif")
                    .toAttrs()
            ) {
                Text(linkType.label)
            }
        }
    }
}

@Composable
private fun AboutSection(
    portfolio: Portfolio,
    appStoreData: AppStoreMetadata?,
    isLoading: Boolean,
    fetchError: Boolean,
    shouldFetchFromAppStore: Boolean
) {
    Column(
        modifier = InfoSectionStyle.toModifier()
            .fillMaxWidth()
            .gap(16.px)
    ) {
        SectionEyebrow(number = "02", label = "About this app")

        H2(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontSize(28.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .fontFamily("Inter", "sans-serif")
                .styleModifier {
                    property("letter-spacing", "-0.02em")
                    property("line-height", "1.15")
                }
                .toAttrs()
        ) {
            Text(stringResource("heading_about_app"))
        }

        when {
            shouldFetchFromAppStore && isLoading -> {
                AboutText(text = stringResource("app_store_description_loading"), muted = true)
            }
            shouldFetchFromAppStore && fetchError -> {
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontSize(16.px)
                        .lineHeight(1.7)
                        .color(ErrorRed)
                        .fontFamily("Inter", "sans-serif")
                        .toAttrs()
                ) {
                    Text(stringResource("app_store_description_failed"))
                }
            }
            shouldFetchFromAppStore && appStoreData != null -> {
                AboutText(text = appStoreData.description)
            }
            !shouldFetchFromAppStore && portfolio.appDescription.isNotEmpty() -> {
                AboutText(text = portfolio.appDescription)
            }
        }
    }
}

@Composable
private fun AboutText(text: String, muted: Boolean = false) {
    P(
        attrs = Modifier
            .margin(topBottom = 0.px)
            .fontSize(16.px)
            .lineHeight(1.7)
            .color(if (muted) Theme.Gray.rgb else Theme.Secondary.rgb)
            .fontFamily("Inter", "sans-serif")
            .toAttrs()
    ) {
        Text(text)
    }
}


@Composable
private fun AppInfoSection(
    portfolio: Portfolio,
    appStoreData: AppStoreMetadata?,
    isLoading: Boolean,
    fetchError: Boolean,
    shouldFetchFromAppStore: Boolean
) {
    Column(
        modifier = InfoSectionStyle.toModifier()
            .fillMaxWidth()
            .gap(4.px)
    ) {
        SectionEyebrow(number = "03", label = "App information")

        H2(
            attrs = Modifier
                .margin(top = 0.px, bottom = 18.px)
                .fontSize(28.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .fontFamily("Inter", "sans-serif")
                .styleModifier {
                    property("letter-spacing", "-0.02em")
                    property("line-height", "1.15")
                }
                .toAttrs()
        ) {
            Text(stringResource("heading_app_information"))
        }

        InfoRow(label = stringResource("label_developer"), value = portfolio.developer)
        InfoRow(label = stringResource("label_category"), value = stringResource(portfolio.description.titleKey))

        val platform = when {
            portfolio.links.isCrossPlatform() -> stringResource("platform_ios_android")
            portfolio.links.playStore != null -> stringResource("platform_android")
            portfolio.links.appStore != null -> stringResource("platform_ios")
            portfolio.links.website != null -> stringResource("platform_web")
            portfolio.links.github != null -> stringResource("platform_open_source")
            portfolio.links.figma != null -> stringResource("platform_design")
            else -> stringResource("platform_other")
        }
        InfoRow(label = stringResource("label_platform"), value = platform)

        val statusText = when (portfolio.status) {
            org.example.garfend.models.DevelopmentStatus.PRODUCTION -> stringResource("status_available")
            org.example.garfend.models.DevelopmentStatus.IN_DEVELOPMENT -> stringResource("status_in_development_label")
            org.example.garfend.models.DevelopmentStatus.IN_TESTING -> stringResource("status_in_testing_label")
        }
        InfoRow(label = stringResource("label_status"), value = statusText)

        if (shouldFetchFromAppStore) {
            when {
                isLoading -> {
                    InfoRow(label = stringResource("label_version"), value = stringResource("loading_short"))
                    InfoRow(label = stringResource("label_rating"), value = stringResource("loading_short"))
                    InfoRow(label = stringResource("label_details"), value = stringResource("app_store_fetching"))
                }
                fetchError -> {
                    InfoRow(
                        label = stringResource("app_store_data_label"),
                        value = stringResource("failed_to_load_short"),
                        isError = true
                    )
                }
                appStoreData != null -> {
                    InfoRow(label = stringResource("label_version"), value = appStoreData.version)

                    val rating = AppStoreService.formatRating(appStoreData.averageUserRating)
                    if (rating != "N/A" && rating != "0.0") {
                        val ratingText = if (appStoreData.userRatingCount > 0) {
                            "$rating/5.0 (${AppStoreService.formatRatingCount(appStoreData.userRatingCount)} ratings)"
                        } else {
                            "$rating/5.0"
                        }
                        InfoRow(label = stringResource("label_rating"), value = ratingText)
                    }

                    val priceText = AppStoreService.formatPrice(appStoreData.price, appStoreData.formattedPrice)
                    InfoRow(label = stringResource("label_price"), value = priceText)

                    if (appStoreData.fileSizeBytes.isNotEmpty()) {
                        InfoRow(label = stringResource("label_size"), value = AppStoreService.formatFileSize(appStoreData.fileSizeBytes))
                    }

                    if (appStoreData.minimumOsVersion.isNotEmpty()) {
                        InfoRow(label = stringResource("label_requires_ios"), value = "${appStoreData.minimumOsVersion}${stringResource("requires_ios_suffix")}")
                    }

                    if (appStoreData.contentAdvisoryRating.isNotEmpty()) {
                        InfoRow(label = stringResource("label_age_rating"), value = appStoreData.contentAdvisoryRating)
                    }

                    if (appStoreData.genres.isNotEmpty()) {
                        InfoRow(label = stringResource("label_genres"), value = appStoreData.genres.joinToString(", "))
                    }
                }
            }
        } else {
            if (portfolio.version.isNotEmpty()) {
                InfoRow(label = stringResource("label_version"), value = portfolio.version)
            }
            if (portfolio.rating != "N/A") {
                InfoRow(label = stringResource("label_rating"), value = "${portfolio.rating}/5.0")
            }
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String, isError: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(topBottom = 14.px)
            .styleModifier {
                property("border-top", "1px solid rgba(255,255,255,0.06)")
            },
        verticalAlignment = Alignment.Top
    ) {
        Span(
            attrs = Modifier
                .fontSize(11.px)
                .color(Theme.Gray.rgb)
                .fontFamily("JetBrains Mono", "monospace")
                .minWidth(140.px)
                .styleModifier {
                    property("letter-spacing", "0.10em")
                    property("text-transform", "uppercase")
                    property("padding-top", "2px")
                }
                .toAttrs()
        ) {
            Text(label)
        }

        Span(
            attrs = Modifier
                .fontSize(15.px)
                .color(if (isError) ErrorRed else Theme.Primary.rgb)
                .fontFamily("Inter", "sans-serif")
                .toAttrs()
        ) {
            Text(value)
        }
    }
}
