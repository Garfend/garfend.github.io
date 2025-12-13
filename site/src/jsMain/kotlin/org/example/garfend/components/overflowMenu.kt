package org.example.garfend.components
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.browser.document
import org.w3c.dom.HTMLElement
import org.example.garfend.models.Section
import org.example.garfend.styles.LinkOverrideStyle
import org.example.garfend.styles.NavigationItemStyle
import org.example.garfend.styles.SideMenuShellStyle
import org.example.garfend.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun overflowMenu(onMenuClosed: () -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    val language = LocalLanguage.current

    // In RTL, slide from right (100%), in LTR slide from left (-100%)
    val hiddenPosition = if (language.isRTL) 100.percent else (-100).percent
    var translateX by remember { mutableStateOf(hiddenPosition) }
    var opacity by remember { mutableStateOf(0.percent) }

    DisposableEffect(Unit) {
        val html = document.documentElement as? HTMLElement
        val body = document.body as? HTMLElement
        val previousHtmlOverflow = html?.style?.getPropertyValue("overflow") ?: ""
        val previousBodyOverflow = body?.style?.getPropertyValue("overflow") ?: ""

        html?.style?.setProperty("overflow", "hidden")
        body?.style?.setProperty("overflow", "hidden")

        onDispose {
            if (html != null) html.style.setProperty("overflow", previousHtmlOverflow)
            if (body != null) body.style.setProperty("overflow", previousBodyOverflow)
        }
    }

    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if (breakpoint > Breakpoint.MD) {
            scope.launch {
                translateX = hiddenPosition
                opacity = 0.percent
                delay(100)
                onMenuClosed()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(2)
            .opacity(opacity)
            .transition(Transition.of(property = "opacity", duration = 500.ms))
            .styleModifier {
                property("top", "0")
                property("left", "0")
                property("right", "0")
                property("bottom", "0")
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .backgroundColor(argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f))
                .onClick {
                    scope.launch {
                        translateX = hiddenPosition
                        opacity = 0.percent
                        delay(100)
                        onMenuClosed()
                    }
                }
                .styleModifier {
                    property("position", "absolute")
                    property("top", "0")
                    property("left", "0")
                    property("right", "0")
                    property("bottom", "0")
                }
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(all = 25.px)
                .width(if (breakpoint < Breakpoint.MD) 50.percent else 25.percent)
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .styleModifier {
                    property("overscroll-behavior", "contain")
                    property("position", "relative")
                    property("z-index", "1")
                }
                .then(SideMenuShellStyle.toModifier())
                .styleModifier {
                    if (language.isRTL) {
                        property("border-top-left-radius", "32px")
                        property("border-bottom-left-radius", "32px")
                        property("border-top-right-radius", "0px")
                        property("border-bottom-right-radius", "0px")
                    } else {
                        property("border-top-left-radius", "0px")
                        property("border-bottom-left-radius", "0px")
                        property("border-top-right-radius", "32px")
                        property("border-bottom-right-radius", "32px")
                    }
                }

                .translateX(tx = translateX)
                .transition(Transition.of(property = "translate", duration = 500.ms))
        ) {
            Row(
                modifier = Modifier.margin(bottom = 25.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaXmark(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .styleModifier {
                            property("margin-inline-end", 20.px.toString())
                        }
                        .color(Colors.White)
                        .onClick {
                            scope.launch {
                                translateX = hiddenPosition
                                opacity = 0.percent
                                delay(100)
                                onMenuClosed()
                            }
                        },
                    size = IconSize.LG
                )
            }
            Row(
                modifier = Modifier.margin(bottom = 20.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LanguageSwitchButton(
                    modifier = Modifier.fontSize(16.px),
                    showBackground = false
                )
            }
            Section.entries.toTypedArray().take(6).forEach { section ->
                Link(
                    modifier = NavigationItemStyle.toModifier()
                        .then(LinkOverrideStyle.toModifier())
                        .margin(bottom = 10.px)
                        .fontFamily(*FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Normal)
                        .textDecorationLine(TextDecorationLine.None)
                        .onClick {
                            scope.launch {
                                translateX = hiddenPosition
                                opacity = 0.percent
                                delay(100)
                                onMenuClosed()
                            }
                        },
                    path = section.path,
                    text = stringResource(section.titleKey),
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                )
            }
        }
    }
}
