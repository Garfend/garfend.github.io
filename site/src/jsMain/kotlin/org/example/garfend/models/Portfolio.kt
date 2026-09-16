package org.example.garfend.models

import org.example.garfend.util.Constants
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

/**
 * Development status for portfolio items.
 * Used to indicate the current phase of a project.
 */
enum class DevelopmentStatus(val titleKey: String) {
    PRODUCTION("status_production"),           // No suffix shown
    IN_DEVELOPMENT("status_in_development"),   // Shows "(In development)"
    IN_TESTING("status_in_testing")            // Shows "(In testing)"
}

enum class Portfolio(
    val image: String,
    val title: String,
    val description: PortfolioCategory,
    val links: PortfolioLinks,
    val titleKey: String,
    val status: DevelopmentStatus = DevelopmentStatus.PRODUCTION,
    val appDescription: String = "",
    val developer: String = Constants.devName,
    val version: String = "1.0.0",
    val rating: String = "4.5",
    val urlId: String = "",
    /**
     * Overrides the platform shown on the detail page. It is normally inferred from which links
     * exist, which cannot describe an app that ships to both stores privately (no public links).
     */
    val platformKey: String? = null
) {

    MABooks(
        image = Res.Image.mabooks,
        title = "MA Books",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.ma_books",
            appStore = "https://apps.apple.com/eg/app/ma-books/id6751820149"
        ),
        titleKey = "M.A. Books",
        appDescription = "MA Books is a comprehensive digital library and book reading platform that brings thousands of books to your fingertips. Discover, read, and manage your favorite books with an intuitive interface designed for book lovers.",
        version = "1.0.0",
        rating = "4.5",
        urlId = "ma-books"
    ),

    FromScratch(
        image = Res.Image.fromscratch,
        title = "FromScratch",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.fromscratch.app",
            appStore = "https://apps.apple.com/sa/app/fromscratch/id6754660941?l=ar"
        ),
        titleKey = "portfolio_fromscratch",
        appDescription = "FromScratch is a comprehensive recipe and cooking app that helps users discover, save, and create delicious recipes from scratch. Whether you're a beginner cook or a seasoned chef, FromScratch provides step-by-step instructions, ingredient lists, and helpful cooking tips to make every meal a success.",
        version = "1.2.0",
        rating = "4.6",
        urlId = "fromscratch"
    ),

    KNLibya(
        image = Res.Image.background,
        title = "KN Libya",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.alkafaa.alkafaa_user",
            appStore = "https://apps.apple.com/sa/app/kn/id6443600127?l"
        ),
        titleKey = "portfolio_kn_lybia",
        appDescription = "KN Libya is a modern e-commerce platform bringing quality products and convenient shopping to Libyan customers. Browse thousands of products, enjoy secure payments, and get fast delivery right to your doorstep. Shop with confidence and ease.",
        version = "2.1.3",
        rating = "4.7",
        urlId = "kn-libya"
    ),

    NourishDurham(
        image = Res.Image.nourishdurham,
        title = "NOURISH Durham",
        description = PortfolioCategory.CrossPlatformCmp,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.nourishdurham.app",
            appStore = "https://apps.apple.com/eg/app/nourish-durham/id6801828352",
            website = "https://nourishdurham.com"
        ),
        titleKey = "portfolio_nourish_durham",
        appDescription = "NOURISH Durham is a community nutrition platform built as a single Kotlin Multiplatform codebase spanning Android, iOS, and the web. Residents find free produce distributions on a calendar, list, or map, log their daily fruit and vegetable servings, browse recipes matched to the next drop-off, RSVP to community events, and take program surveys. Program staff manage the whole operation from a companion Compose Multiplatform web dashboard with role-based Super Admin controls, covering distributions, events, nutrition content, recipes, notifications, surveys, support, and audit logging.",
        version = "1.0.0",
        rating = "N/A",
        urlId = "nourish-durham"
    ),

    TopMedia(
        image = Res.Image.topmedia,
        title = "TopMedia",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.topmedia.app",
            appStore = "https://apps.apple.com/us/app/top-media-app/id6737759369"
        ),
        titleKey = "portfolio_topmedia",
        appDescription = "TopMedia is a social platform for sharing posts, photos, and video reels with friends, family, and communities. Follow the people you care about, reply to individual comments in threaded conversations, translate posts into your own language, and watch reels in a smooth full-screen player built for fast scrolling.",
        version = "2.0.1",
        rating = "N/A",
        urlId = "topmedia"
    ),

    DabdoubButchery(
        image = Res.Image.dabdoub,
        title = "Dabdoub Butchery",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.dabdoub.butchery&hl=en",
            appStore = "https://apps.apple.com/us/app/dabdoub-butchery-grills/id6754414950?l"
        ),
        titleKey = "portfolio_dabdoub",
        appDescription = "Dabdoub Butchery offers premium quality meats and grilling products delivered fresh to your door. Order from our selection of halal meats, specialty cuts, and BBQ essentials. Experience exceptional quality and service with every order.",
        version = "1.5.2",
        rating = "4.8",
        urlId = "dabdoub-butchery"
    ),
    SKFurniture(
        image = Res.Image.serineKamal,
        title = "SK Furniture",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.essam.serinekamal",
            appStore = "https://apps.apple.com/eg/app/serinekamal/id6755937638?l=ar"
        ),
        titleKey = "portfolio_serinekamal",
        appDescription = "SK Furniture brings elegant and affordable furniture shopping to your fingertips. Browse our curated collection of modern and classic furniture pieces, visualize them in your space, and enjoy hassle-free delivery and setup services.",
        version = "1.3.1",
        rating = "4.5",
        urlId = "sk-furniture"
    ),
    Orderk(
        image = Res.Image.orderk,
        title = "Orderk",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.orderk.shop",
            appStore = "https://apps.apple.com/eg/app/orderk-%D8%A7%D9%88%D8%B1%D8%AF%D8%B1%D8%A7%D9%83/id6753081872"
        ),
        titleKey = "portfolio_orderk",
        appDescription = "Orderk is your one-stop shop for online shopping in Egypt. Discover thousands of products across multiple categories including electronics, fashion, home goods, and more. Enjoy competitive prices, secure payments, and reliable delivery service.",
        version = "2.0.5",
        rating = "4.6",
        urlId = "orderk"
    ),

    OrderkShop(
        image = Res.Image.orderkshopIcon,
        title = "OrderkShop",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            playStore = "https://play.google.com/store/apps/details?id=com.orderk.orderkshop",
            appStore = "https://apps.apple.com/eg/app/orderkshop/id6758918373"
        ),
        titleKey = "portfolio_orderkshop",
        appDescription = "OrderkShop is the B2C side of the Orderk platform, bringing supermarket goods and fresh produce to your door. Browse thousands of products, take advantage of daily offers, track your order live on the map, pay with a digital wallet or local methods, and collect rewards as you shop.",
        version = "1.0.1",
        rating = "N/A",
        urlId = "orderkshop"
    ),

    // Internal fleet app for Orderk's own drivers — not publicly listed, so it carries no store
    // links and no product detail beyond authorship. Deliberate: see the site owner's note.
    OrderkShopDelivery(
        image = Res.Image.orderkshopIcon,
        title = "OrderkShop Delivery",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(),
        titleKey = "portfolio_orderkshop_delivery",
        appDescription = "Internal driver app for the OrderkShop delivery fleet, built and maintained by me. It is a private company application and is not publicly distributed, so no further details are listed here.",
        version = "—",
        rating = "N/A",
        urlId = "orderkshop-delivery",
        platformKey = "platform_ios_android"
    ),

    MuseMagic(
        image = Res.Image.musemagic,
        title = "MuseMagic",
        description = PortfolioCategory.MobileKotlin,
        links = PortfolioLinks(
            github = "https://github.com/Garfend/HistoryVerse"
        ),
        titleKey = "portfolio_musemagic",
        appDescription = "MuseMagic is an interactive history exploration app that brings the past to life through immersive storytelling and rich multimedia content. Discover historical events, explore ancient civilizations, and learn about fascinating historical figures through an engaging and educational experience.",
        version = "1.0.0",
        rating = "4.4",
        urlId = "musemagic"
    ),
    DawaaLink(
        image = Res.Image.dawaalink2,
        title = "Dawaa Link",
        description = PortfolioCategory.MobileFlutter,
        links = PortfolioLinks(
            website = "https://dawaalink.vercel.app/"
        ),
        titleKey = "portfolio_dawaa_link",
        status = DevelopmentStatus.IN_DEVELOPMENT,
        appDescription = "Dawaa Link connects patients with pharmacies and healthcare providers for convenient medication ordering and health consultations. Get your prescriptions delivered, find nearby pharmacies, and access healthcare information all in one place.",
        version = "0.9.0 Beta",
        rating = "4.2",
        urlId = "dawaa-link"
    ),
    TitaniumGym(
        image = Res.Image.titanumgym,
        title = "Titanium Gym",
        description = PortfolioCategory.UiUx,
        links = PortfolioLinks(
            figma = "https://www.figma.com/design/CdmOjyxgnziOM7jJso5zZ4/Titanium-Gym?t=tzsjDlRk7ZkYtHiQ-0"
        ),
        titleKey = "portfolio_titanium_gym",
        appDescription = "Titanium Gym is a comprehensive fitness management app design that helps gym members track workouts, book classes, manage memberships, and connect with personal trainers. This UI/UX design showcases a modern approach to fitness app experiences.",
        version = "Design Concept",
        rating = "N/A",
        urlId = "titanium-gym"
    )
}

enum class PortfolioCategory(
    val title: String,
    val titleKey: String
) {
    MobileKotlin("Android App - jetpack compose", "portfolio_cat_mobile_kotlin"),
    MobileCmp("Mobile App - Compose Multiplatform", "portfolio_cat_mobile_cmp"),
    CrossPlatformCmp(
        "Compose Multiplatform - Mobile/Web",
        "portfolio_cat_cross_platform_cmp"
    ),
    MobileFlutter("Mobile App - flutter", "portfolio_cat_mobile_flutter"),
    UiUx("UI/UX Design", "portfolio_cat_ui_ux")
}