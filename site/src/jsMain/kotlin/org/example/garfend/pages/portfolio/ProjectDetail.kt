package org.example.garfend.pages.portfolio

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import org.example.garfend.components.BackButton
import org.example.garfend.components.PortfolioDetailContent
import org.example.garfend.components.PortfolioDetailHeader
import org.example.garfend.models.Portfolio
import org.example.garfend.models.Theme
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page("/portfolio/{project}")
@Composable
fun ProjectDetailPage() {
    val ctx = rememberPageContext()
    val projectId = ctx.route.params["project"] ?: ""

    val portfolioItem = remember(projectId) {
        Portfolio.entries.firstOrNull {
            it.urlId.equals(projectId, ignoreCase = true)
        }
    }

    if (portfolioItem != null) {
        PortfolioDetailPageContent(portfolio = portfolioItem)
    } else {
        ProjectNotFound()
    }
}

@Composable
private fun PortfolioDetailPageContent(portfolio: Portfolio) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .minHeight(100.percent)
            .styleModifier { property("background", "transparent") },
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .maxWidth(1100.px)
                .padding(topBottom = 100.px),
            horizontalAlignment = Alignment.Start
        ) {
            BackButton()
            PortfolioDetailHeader(portfolio = portfolio)
            PortfolioDetailContent(portfolio = portfolio)
        }
    }
}

@Composable
private fun ProjectNotFound() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .minHeight(100.percent)
            .styleModifier { property("background", "transparent") },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.gap(20.px)
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily("Inter", "sans-serif")
                    .fontSize(28.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Project not found")
            }
            BackButton()
        }
    }
}
