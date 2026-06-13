package org.example.garfend.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.example.garfend.styles.BackButtonStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Text

@Composable
fun BackButton() {
    Link(
        path = "/#portfolio",
        modifier = BackButtonStyle.toModifier()
            .margin(bottom = 40.px)
    ) {
        Row(
            modifier = Modifier.gap(10.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            I(attrs = Modifier
                .fontSize(13.px)
                .toAttrs {
                    classes("fas", "fa-arrow-left")
                }
            )
            Text("Back to Portfolio")
        }
    }
}
