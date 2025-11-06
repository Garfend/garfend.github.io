package org.example.garfend.sections


import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.example.garfend.components.LocalLanguage
import org.example.garfend.components.portfolioCard
import org.example.garfend.components.sectionTitle
import org.example.garfend.models.Portfolio
import org.example.garfend.models.Section
import org.example.garfend.models.Theme
import org.example.garfend.styles.PortfolioArrowIconStyle
import org.example.garfend.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun portfolioSection() {
    Box(
        modifier = Modifier
            .id(Section.Portfolio.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(Theme.LightGrayBg.rgb),
        contentAlignment = Alignment.Center
    ) {
        portfolioContent()
    }
}

@Composable
fun portfolioContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        sectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 25.px),
            section = Section.Portfolio
        )
        portfolioCards(breakpoint = breakpoint)
        portfolioNavigation()
    }
}

@Composable
fun portfolioCards(breakpoint: Breakpoint) {

    Row(
        modifier = Modifier
            .id("scrollableContainer")
            .fillMaxWidth()
            .margin(bottom = 25.px)
            .maxWidth(
                if (breakpoint > Breakpoint.MD) 950.px
                else if (breakpoint > Breakpoint.SM) 625.px
                else 300.px
            )
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth)
    ) {
        Portfolio.entries.forEach { portfolio ->
            portfolioCard(
                modifier = Modifier.styleModifier {
                    // Use logical property for RTL-aware spacing
                    if (portfolio != Portfolio.entries.last()) {
                        property("margin-inline-end", 25.px.toString())
                    }
                },
                portfolio = portfolio,
            )
        }
    }
}

@Composable
fun portfolioNavigation() {
    val language = LocalLanguage.current

    // In RTL: left arrow scrolls right (+325), right arrow scrolls left (-325)
    // In LTR: left arrow scrolls left (-325), right arrow scrolls right (+325)
    val leftArrowScroll = if (language.isRTL) 325.0 else -325.0
    val rightArrowScroll = if (language.isRTL) -325.0 else 325.0

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        // First arrow: In LTR shows left arrow, in RTL shows right arrow
        if (language.isRTL) {
            FaArrowRight(
                modifier = PortfolioArrowIconStyle.toModifier()
                    .styleModifier {
                        property("margin-inline-end", 40.px.toString())
                    }
                    .cursor(Cursor.Pointer)
                    .onClick {
                        document.getElementById("scrollableContainer")
                            ?.scrollBy(x = leftArrowScroll, y = 0.0)
                    },
                size = IconSize.LG
            )
        } else {
            FaArrowLeft(
                modifier = PortfolioArrowIconStyle.toModifier()
                    .styleModifier {
                        property("margin-inline-end", 40.px.toString())
                    }
                    .cursor(Cursor.Pointer)
                    .onClick {
                        document.getElementById("scrollableContainer")
                            ?.scrollBy(x = leftArrowScroll, y = 0.0)
                    },
                size = IconSize.LG
            )
        }

        // Second arrow: In LTR shows right arrow, in RTL shows left arrow
        if (language.isRTL) {
            FaArrowLeft(
                modifier = PortfolioArrowIconStyle.toModifier()
                    .cursor(Cursor.Pointer)
                    .onClick {
                        document.getElementById("scrollableContainer")
                            ?.scrollBy(x = rightArrowScroll, y = 0.0)
                    },
                size = IconSize.LG
            )
        } else {
            FaArrowRight(
                modifier = PortfolioArrowIconStyle.toModifier()
                    .cursor(Cursor.Pointer)
                    .onClick {
                        document.getElementById("scrollableContainer")
                            ?.scrollBy(x = rightArrowScroll, y = 0.0)
                    },
                size = IconSize.LG
            )
        }
    }
}