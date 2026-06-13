package org.example.garfend.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import org.example.garfend.models.Service
import org.example.garfend.models.Theme
import org.example.garfend.styles.ServiceCardStyle
import org.example.garfend.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun serviceCard(service: Service) {
    Column(
        modifier = ServiceCardStyle.toModifier()
            .fillMaxWidth()
            .padding(all = 32.px)
            .styleModifier {
                property("background", "linear-gradient(180deg, rgba(20,23,28,0.55) 0%, rgba(20,23,28,0.75) 100%)")
                property("backdrop-filter", "blur(22px) saturate(170%)")
                property("-webkit-backdrop-filter", "blur(22px) saturate(170%)")
                property("border", "1px solid rgba(255,255,255,0.08)")
                property("border-radius", "14px")
                property("box-shadow", "inset 0 1px 0 rgba(255,255,255,0.14), inset 0 -1px 0 rgba(0,0,0,0.25), 0 20px 40px -20px rgba(0,0,0,0.55)")
            }
    ) {
        // Icon box: 56×56, rounded 14px, amber-tinted background
        Box(
            modifier = Modifier
                .id("iconBox")
                .size(56.px)
                .borderRadius(14.px)
                .margin(bottom = 24.px)
                .styleModifier {
                    property("background", "rgba(240,168,104,0.14)")
                    property("color", "rgb(240,168,104)")
                    property("display", "flex")
                    property("align-items", "center")
                    property("justify-content", "center")
                    property("flex-shrink", "0")
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(28.px),
                src = service.icon,
                alt = stringResource(service.imageDescKey)
            )
        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 12.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(22.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .styleModifier { property("letter-spacing", "-0.01em") }
                .toAttrs()
        ) {
            Text(stringResource(service.titleKey))
        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(15.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .styleModifier { property("line-height", "1.65") }
                .toAttrs()
        ) {
            Text(stringResource(service.descriptionKey))
        }
    }
}
