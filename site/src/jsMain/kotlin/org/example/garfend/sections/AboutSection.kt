package org.example.garfend.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.components.LocalLanguage
import org.example.garfend.components.sectionTitle
import org.example.garfend.components.stringResource
import org.example.garfend.models.Language
import org.example.garfend.models.Section
import org.example.garfend.models.Theme
import org.example.garfend.styles.AboutTextStyle
import org.example.garfend.styles.StatsGridStyle
import org.example.garfend.util.Constants
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun aboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 120.px),
        contentAlignment = Alignment.Center
    ) {
        aboutMe()
    }
}

@Composable
fun aboutMe() {
    val breakpoint = rememberBreakpoint()
    val isWide = breakpoint >= Breakpoint.MD
    val language = LocalLanguage.current
    Column(
        modifier = Modifier.fillMaxWidth(if (isWide) 90.percent else 92.percent),
        horizontalAlignment = Alignment.Start
    ) {
        sectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 48.px),
            section = Section.About,
            eyebrow = stringResource("eyebrow_about"),
            mainTitle = stringResource("main_title_about"),
            alignment = Alignment.Start
        )

        if (isWide) {
            // Desktop: 2-column grid (text | stats)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Left — about text
                Column(
                    modifier = Modifier
                        .fillMaxWidth(100.percent)
                        .padding(
                            left = if (language.isRTL) 60.px else 0.px,
                            right = if (language.isRTL) 0.px else 60.px,
                        )
                ) {
                    aboutText()
                }
                // Right — stats 2×2 grid
                Box(modifier = Modifier.fillMaxWidth(50.percent)) {
                    statsGrid()
                }
            }
        } else {
            // Mobile: stacked
            aboutText()
            Box(modifier = Modifier.fillMaxWidth().margin(top = 40.px)) {
                statsGrid()
            }
        }
    }
}

@Composable
private fun aboutText() {
    P(
        attrs = AboutTextStyle.toModifier()
            .fillMaxWidth()
            .margin(topBottom = 0.px)
            .fontFamily(*FONT_FAMILY)
            .fontSize(17.px)
            .fontWeight(FontWeight.Normal)
            .color(Theme.Secondary.rgb)
            .textAlign(TextAlign.Start)
            .styleModifier { property("line-height", "1.75") }
            .toAttrs()
    ) {
        Text(stringResource("about_me_text"))
    }
}

@Composable
private fun statsGrid() {
    SimpleGrid(
        modifier = StatsGridStyle.toModifier()
            .fillMaxWidth()
            .styleModifier { property("gap", "16px") },
        numColumns = numColumns(base = 2)
    ) {
        statCard(number = "${Constants.projectsCompleted}+", label = stringResource("stat_label_apps_shipped"))
        statCard(number = "${Constants.YOE}+", label = stringResource("stat_label_years_building"))
        statCard(number = "${Constants.trainingPrograms}",  label = stringResource("stat_label_training"))
        statCard(number = "∞",  label = stringResource("stat_label_curiosity"))
        statCard(number = "${Constants.happyClients}",  label = stringResource("state_label_happy_clients"))

    }
}

@Composable
private fun statCard(number: String, label: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 22.px)
            .styleModifier {
                property("background", "rgba(20,23,28,0.55)")
                property("backdrop-filter", "blur(20px) saturate(160%)")
                property("-webkit-backdrop-filter", "blur(20px) saturate(160%)")
                property("border", "1px solid rgba(255,255,255,0.08)")
                property("border-radius", "14px")
                property("box-shadow",
                    "inset 0 1px 0 rgba(255,255,255,0.14), " +
                    "inset 0 -1px 0 rgba(0,0,0,0.25), " +
                    "0 16px 32px -20px rgba(0,0,0,0.6)")
            }
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .margin(bottom = 6.px)
                .fontFamily(*FONT_FAMILY)
                .fontWeight(FontWeight.Bold)
                .color(Theme.LightRed.rgb)
                .styleModifier {
                    property("font-size", "32px")
                    property("letter-spacing", "-0.02em")
                    property("line-height", "1")
                }
                .toAttrs()
        ) { Text(number) }

        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(13.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Gray.rgb)
                .toAttrs()
        ) { Text(label) }
    }
}
