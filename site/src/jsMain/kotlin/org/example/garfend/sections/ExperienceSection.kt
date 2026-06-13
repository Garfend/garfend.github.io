package org.example.garfend.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.components.experience.professionalTimeline
import org.example.garfend.components.experience.trainingStrip
import org.example.garfend.components.sectionTitle
import org.example.garfend.components.stringResource
import org.example.garfend.models.Section
import org.example.garfend.models.Theme
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun experienceSection() {
    Box(
        modifier = Modifier
            .id(Section.Experience.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        experienceContent()
    }
}

@Composable
fun experienceContent() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent else 92.percent),
        horizontalAlignment = Alignment.Start
    ) {
        sectionTitle(
            modifier = Modifier.fillMaxWidth().margin(bottom = 28.px),
            section = Section.Experience,
            eyebrow = stringResource("eyebrow_experience"),
            mainTitle = stringResource("main_title_experience"),
            alignment = Alignment.Start
        )

        // Intro paragraph
        P(
            attrs = Modifier
                .margin(top = 0.px, bottom = 40.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(17.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .styleModifier {
                    property("max-width", "620px")
                    property("line-height", "1.7")
                }
                .toAttrs()
        ) {
            Text(stringResource("exp_intro"))
        }

        // Keep the experience compact — it is not text-heavy, so cap the width
        Column(
            modifier = Modifier.fillMaxWidth().styleModifier { property("max-width", "790px") },
            horizontalAlignment = Alignment.Start
        ) {
            professionalTimeline()

            // Training / certifications — small, de-emphasized
            Box(modifier = Modifier.fillMaxWidth().margin(top = 32.px)) {
                trainingStrip()
            }
        }
    }
}
