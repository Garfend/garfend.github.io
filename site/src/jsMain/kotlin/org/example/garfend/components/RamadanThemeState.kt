package org.example.garfend.components

import androidx.compose.runtime.*
import kotlinx.browser.localStorage
import org.w3c.dom.get
import org.w3c.dom.set

private const val RAMADAN_THEME_KEY = "ramadanThemeEnabled"

@Composable
fun rememberRamadanTheme(): MutableState<Boolean> {
    val isRamadanSeason = remember { isCurrentlyRamadanSeason() }

    val initialValue = remember {
        localStorage[RAMADAN_THEME_KEY]?.toBoolean() ?: isRamadanSeason
    }

    val ramadanEnabled = remember { mutableStateOf(initialValue) }

    LaunchedEffect(ramadanEnabled.value) {
        localStorage[RAMADAN_THEME_KEY] = ramadanEnabled.value.toString()
    }

    return ramadanEnabled
}


private fun isCurrentlyRamadanSeason(): Boolean {
    return false
}