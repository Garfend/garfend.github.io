package org.example.garfend.components
import androidx.compose.runtime.Composable
import org.example.garfend.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.example.garfend.models.Experience
import org.example.garfend.models.Language
import org.example.garfend.models.Theme
import org.example.garfend.components.LocalLanguage
import org.example.garfend.styles.experienceDescriptionStyle
import org.example.garfend.styles.experienceNumberBarStyle
import org.example.garfend.styles.experienceNumberCircleStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun experienceCard(
    breakpoint: Breakpoint,
    active: Boolean = false,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(
                if (breakpoint >= Breakpoint.MD) 60.percent
                else 90.percent
            ),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        experienceDescription(
            active = active,
            descriptionKey = experience.descriptionKey
        )
        experienceDetails(
            breakpoint = breakpoint,
            active = active,
            experience = experience,
            animatedMargin = animatedMargin
        )
    }
}

@Composable
fun experienceDescription(
    active: Boolean,
    descriptionKey: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .margin(topBottom = 14.px)
            .padding(all = 14.px)
            .experienceDescriptionStyle(active)
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(14.px)
                .lineHeight(1.6)
                .fontWeight(FontWeight.Normal)
                .color(Colors.White)
                .toAttrs()
        ) {
            Text(stringResource(descriptionKey))
        }
    }
}

@Composable
fun experienceDetails(
    breakpoint: Breakpoint,
    active: Boolean,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(left = if (breakpoint >= Breakpoint.MD) 20.px else 0.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint >= Breakpoint.MD) {
            experienceNumber(active = active, experience = experience)
            if (LocalLanguage.current == Language.ARABIC) {
                Box(modifier = Modifier.padding(leftRight = 32.px))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .margin(left = if(breakpoint <= Breakpoint.SM) 8.px else animatedMargin)
                .transition(
                    Transition.of(
                        property = "margin",
                        duration = 500.ms,
                        delay = experience.ordinal * 100.ms
                    )
                )
            ,
            verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(stringResource(experience.jobPositionKey))
            }
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("${stringResource(experience.fromKey)} - ${stringResource(experience.toKey)}")
            }
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(stringResource(experience.companyKey))
            }
        }
    }
}

@Composable
fun experienceNumber(
    active: Boolean,
    experience: Experience
) {
    Box(
        modifier = Modifier
            .margin(right = 14.px)
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(3.px)
                .experienceNumberBarStyle()
        )
        Box(
            modifier = Modifier
                .size(40.px)
                .border(
                    width = 3.px,
                    style = LineStyle.Solid,
                    color = Theme.LightRed.rgb
                )
                .backgroundColor(if (active) Theme.LightRed.rgb else Colors.White)
                .borderRadius(50.percent)
                .experienceNumberCircleStyle(active),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Bold)
                    .color(if (active) Colors.White else Theme.LightRed.rgb)
                    .toAttrs()
            ) {
                Text(experience.number)
            }
        }
    }
}
