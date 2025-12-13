package org.example.garfend.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignContent
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.pointerEvents
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun mainBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .styleModifier {
                property(
                    "background",
                    "radial-gradient(circle, rgba(255,255,255,0.03) 1px, transparent 1px)," +
                            "radial-gradient(circle at 90% 50%, rgba(220, 20, 60, 0.25) 0%, transparent 50%)," +
                            "radial-gradient(circle at 10% 20%, rgba(0, 100, 255, 0.15) 0%, transparent 45%)," +
                            "#05080f"
                )
                property(
                    "background-size",
                    "30px 30px, 100% 100%, 100% 100%, 100% 100%"
                )
            }
            .pointerEvents(PointerEvents.None)
    )
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(50.percent)
            .alignContent(alignContent = AlignContent.Center)
            .styleModifier {
                property(
                    "background",
                    "repeating-linear-gradient(0deg, transparent, transparent 40px, rgba(220, 20, 60, 0.05) 41px)"
                )
            }
            .pointerEvents(PointerEvents.None)
    )
}
