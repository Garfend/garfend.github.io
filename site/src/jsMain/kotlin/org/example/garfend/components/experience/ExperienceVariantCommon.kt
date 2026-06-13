package org.example.garfend.components.experience

/**
 * Shared tokens for the experience-section design variants.
 * Keeps every variant locked to the same amber-glassmorphism theme
 * used across the rest of the site.
 */
internal val MONO = arrayOf("JetBrains Mono", "ui-monospace", "SF Mono", "Menlo", "monospace")

internal object Amber {
    const val SOLID = "rgb(240,168,104)"
    const val A06 = "rgba(240,168,104,0.06)"
    const val A10 = "rgba(240,168,104,0.10)"
    const val A12 = "rgba(240,168,104,0.12)"
    const val A25 = "rgba(240,168,104,0.25)"
    const val A40 = "rgba(240,168,104,0.40)"
    const val A60 = "rgba(240,168,104,0.60)"

    const val CARD_BG = "rgba(20,23,28,0.55)"
    const val CARD_BG_SOLID = "rgba(20,23,28,0.85)"
    const val HAIRLINE = "rgba(255,255,255,0.08)"
    const val INSET = "inset 0 1px 0 rgba(255,255,255,0.12), 0 16px 32px -20px rgba(0,0,0,0.5)"
    const val GLOW = "0 0 22px rgba(240,168,104,0.30)"
}
