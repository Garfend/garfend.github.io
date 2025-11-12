package org.example.garfend.models

import org.example.garfend.util.Res

/**
 * Data class to hold multiple links for a portfolio item.
 * Makes it easy to support projects with different link types.
 *
 * Usage examples:
 * - Flutter app with both stores: PortfolioLinks(playStore = "...", appStore = "...")
 * - Native Android app: PortfolioLinks(playStore = "...")
 * - Website: PortfolioLinks(website = "...")
 * - GitHub project: PortfolioLinks(github = "...")
 */
data class PortfolioLinks(
    val playStore: String? = null,
    val appStore: String? = null,
    val website: String? = null,
    val github: String? = null,
    val figma: String? = null,
    val other: String? = null
) {
    /**
     * Returns a list of all available links with their labels.
     * Format: List<Pair<LinkType, URL>>
     */
    fun getAllLinks(): List<Pair<LinkType, String>> {
        val links = mutableListOf<Pair<LinkType, String>>()
        playStore?.let { links.add(LinkType.PLAY_STORE to it) }
        appStore?.let { links.add(LinkType.APP_STORE to it) }
        website?.let { links.add(LinkType.WEBSITE to it) }
        github?.let { links.add(LinkType.GITHUB to it) }
        figma?.let { links.add(LinkType.FIGMA to it) }
        other?.let { links.add(LinkType.OTHER to it) }
        return links
    }

    /**
     * Checks if this portfolio item has any links.
     */
    fun hasLinks(): Boolean = getAllLinks().isNotEmpty()

    /**
     * Returns the primary link (first available link).
     */
    fun getPrimaryLink(): String? = getAllLinks().firstOrNull()?.second

    /**
     * Checks if this is a cross-platform app (has both Play Store and App Store links).
     */
    fun isCrossPlatform(): Boolean = playStore != null && appStore != null
}

/**
 * Link types for portfolio items with display labels.
 */
enum class LinkType(val label: String, val icon: String) {
    PLAY_STORE("Google Play", "fab fa-google-play"),
    APP_STORE("App Store", "fab fa-app-store-ios"),
    WEBSITE("Website", "fas fa-globe"),
    GITHUB("GitHub", "fab fa-github"),
    FIGMA("Figma", "fab fa-figma"),
    OTHER("View", "fas fa-link")
}

enum class Portfolio(
    val image: String,
    val title: String,
    val description: PortfolioCategory,
    val links: PortfolioLinks,
    val titleKey: String
) {

    One(
        image = Res.Image.fromscratch,
        title = "FromScratch",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.fromscratch.app",
            appStore = "https://apps.apple.com/sa/app/fromscratch/id6754660941?l=ar"
        ),
        titleKey = "portfolio_fromscratch"
    ),

    Two(
        image = Res.Image.background,
        title = "KN lybia",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.alkafaa.alkafaa_user",
            appStore = "https://apps.apple.com/sa/app/kn/id6443600127?l"
        ),
        titleKey = "portfolio_kn_lybia"
    ),

    Three(
        image = Res.Image.dabdoub,
        title = "Dabdoub Butchery",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.dabdoub.butchery&hl=en",
            appStore = "https://apps.apple.com/us/app/dabdoub-butchery-grills/id6754414950?l"
        ),
        titleKey = "portfolio_dabdoub"
    ),
    Four(
        image = Res.Image.orderk,
        title = "Orderk (Testing phase)",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            // playStore = "https://play.google.com/store/apps/details?id=com.dabdoub.butchery&hl=en"
            // appStore = "https://apps.apple.com/sa/app/fromscratch/id6754660941?l=ar"
        ),
        titleKey = "portfolio_orderk"
    ),


    Five(
        image = Res.Image.musemagic,
        title = "MuseMagic",
        description = PortfolioCategory.MobileKotlin,
        links = PortfolioLinks(
            github = "https://github.com/Garfend/HistoryVerse"
        ),
        titleKey = "portfolio_musemagic"
    ),

    Six(
        image = Res.Image.dawaalink2,
        title = "Dawaa Link",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            website = "https://dawaalink.vercel.app/"
        ),
        titleKey = "portfolio_dawaa_link"
    ),

    Seven(
        image = Res.Image.titanumgym,
        title = "Titanuim gym",
        description = PortfolioCategory.UiUx,
        links = PortfolioLinks(
            figma = "https://www.figma.com/design/CdmOjyxgnziOM7jJso5zZ4/Titanium-Gym?t=tzsjDlRk7ZkYtHiQ-0"
        ),
        titleKey = "portfolio_titanium_gym"
    )
}

enum class PortfolioCategory(
    val title: String,
    val titleKey: String
) {
    MobileKotlin("Android App - jetpack compose", "portfolio_cat_mobile_kotlin"),
    MobileCmp("Mobile App - Compose Multiplatform", "portfolio_cat_mobile_cmp"),
    MobileFlutter("Mobile App - flutter", "portfolio_cat_mobile_flutter"),
    UiUx("UI/UX Design", "portfolio_cat_ui_ux")
}