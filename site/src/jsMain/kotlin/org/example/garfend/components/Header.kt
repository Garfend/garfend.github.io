package org.example.garfend.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaChevronDown
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.models.Section
import org.example.garfend.styles.NavigationItemStyle
import org.example.garfend.styles.LinkOverrideStyle
import org.example.garfend.styles.HeaderContainerStyle
import org.example.garfend.styles.HeaderNavShellStyle
import org.example.garfend.styles.HeaderShellStyle
import org.example.garfend.styles.ActiveHeaderLinkStyle
import org.example.garfend.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb
import com.varabyte.kobweb.compose.ui.toAttrs
import org.example.garfend.models.Language
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import kotlinx.browser.window

@Composable
fun LanguageSwitchButton(
    modifier: Modifier = Modifier,
    showBackground: Boolean = true,
    textColor: CSSColorValue = Colors.White
) {
    val languageState = LocalLanguageState.current

    Button(
        attrs = modifier
            .padding(left = if (showBackground) 20.px else 0.px)
            .color(textColor)
            .cursor(Cursor.Pointer)
            .fontFamily(*FONT_FAMILY)
            .border(width = 0.px, color = Colors.Transparent)
            .backgroundColor(color = Colors.Transparent)
            .fontSize(14.px)
            .onClick {
                val newLanguage = if (languageState.value == Language.ENGLISH) {
                    Language.ARABIC
                } else {
                    Language.ENGLISH
                }
                languageState.value = newLanguage
                saveLanguage(newLanguage)
            }
            .toAttrs()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(languageState.value.displayName)
            FaChevronDown(
                modifier = Modifier
                    .margin(left = 6.px)
                    .color(textColor),
                size = IconSize.SM
            )
        }
    }
}

@Composable
fun header(onMenuClicked: () -> Unit, isMenuOpen: Boolean) {
    val breakpoint = rememberBreakpoint()
    Row(
        modifier = HeaderContainerStyle.toModifier()
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 90.percent else 95.percent)
            .maxWidth(1200.px),
        horizontalArrangement = if (breakpoint > Breakpoint.MD) Arrangement.Center else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint > Breakpoint.MD) {
            rightSide()
        } else {
            leftSide(
                breakpoint = breakpoint,
                onMenuClicked = onMenuClicked,
                isMenuOpen = isMenuOpen
            )
        }
    }
}

@Composable
fun leftSide(
    breakpoint: Breakpoint,
    onMenuClicked: () -> Unit,
    isMenuOpen: Boolean
) {
    Row(
        modifier = (
            if (breakpoint <= Breakpoint.MD && isMenuOpen) Modifier else HeaderShellStyle.toModifier()
        )
            .padding(topBottom = 14.px, leftRight = 20.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD && !isMenuOpen) {
            FaBars(
                modifier = Modifier
                    .margin(top = 8.px, bottom = 8.px)
                    .color(Colors.White)
                    .onClick {
                        onMenuClicked()
                    },
                size = IconSize.XL
            )
        }

    }
}

@Composable
fun rightSide() {
    // Track the current active section
    var activeSection by remember { mutableStateOf("#home") }

    // Setup scroll detection to determine which section is currently visible
    LaunchedEffect(Unit) {
        val sections = Section.entries.toTypedArray().take(6)

        // Scroll listener to detect which section is in view
        val scrollListener: (dynamic) -> Unit = { _ ->
            sections.forEach { section ->
                val element = window.document.getElementById(section.id)
                if (element != null) {
                    val rect = element.getBoundingClientRect()
                    // Check if section is in viewport (considering header offset)
                    if (rect.top <= 150 && rect.bottom >= 150) {
                        activeSection = section.path
                    }
                }
            }
        }

        // Hash change listener (for when clicking navigation)
        val hashChangeListener: (dynamic) -> Unit = { _ ->
            val hash = window.location.hash.ifEmpty { "#home" }
            activeSection = hash
        }

        window.addEventListener("scroll", scrollListener)
        window.addEventListener("hashchange", hashChangeListener)

        // Initial check
        scrollListener(null)
    }

    Row(
        modifier = HeaderNavShellStyle.toModifier()
            .padding(topBottom = 16.px, leftRight = 34.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Section.entries.toTypedArray().take(6).forEach { section ->
                val linkModifier = NavigationItemStyle.toModifier()
                    .then(LinkOverrideStyle.toModifier())
                    .padding(right = 25.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Medium)
                    .textDecorationLine(TextDecorationLine.None)
                val activeModifier = linkModifier.then(ActiveHeaderLinkStyle.toModifier())
                Link(
                    modifier = if (activeSection == section.path) {
                        activeModifier
                    } else {
                        linkModifier
                    },
                    path = section.path,
                    text = stringResource(section.titleKey)
                )
            }
        }
        LanguageSwitchButton(
            showBackground = false,
            textColor = rgb(170, 170, 170)
        )
    }
}
