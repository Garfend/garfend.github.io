package org.example.garfend.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import org.example.garfend.components.LocalLanguage
import org.example.garfend.components.backToTopButton
import org.example.garfend.components.overflowMenu
import org.example.garfend.models.Theme
import org.example.garfend.sections.*


@Page
@Composable
fun homePage() {
    val language = LocalLanguage.current
    var menuOpened by remember { mutableStateOf(false) }

    // Force recomposition when language changes using key()
    key(language) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.LightGrayBg.rgb)
                .styleModifier {
                    property("direction", if (language.isRTL) "rtl" else "ltr")
                }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                mainSection(onMenuClicked = { menuOpened = true })
                aboutSection()
                serviceSection()
                portfolioSection()
                experienceSection()
//              contactSection()
                footerSection()
            }
            backToTopButton()
            if (menuOpened) {
                overflowMenu(onMenuClosed = { menuOpened = false })
            }
        }
    }
}
