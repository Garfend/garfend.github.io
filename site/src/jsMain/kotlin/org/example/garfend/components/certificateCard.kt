package org.example.garfend.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.example.garfend.models.Certificate
import org.example.garfend.models.Theme
import org.example.garfend.styles.ServiceCardStyle
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Res
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * One certificate: badge, title, what it covers, issuer + date, and a link that opens the
 * original PDF in a new tab.
 *
 * Shares [ServiceCardStyle] with the service cards so the hover lift and glow stay identical.
 */
@Composable
fun certificateCard(certificate: Certificate) {
    Column(
        modifier = ServiceCardStyle.toModifier()
            .fillMaxWidth()
            .padding(all = 28.px)
            .styleModifier {
                property("background", "linear-gradient(180deg, rgba(20,23,28,0.55) 0%, rgba(20,23,28,0.75) 100%)")
                property("backdrop-filter", "blur(22px) saturate(170%)")
                property("-webkit-backdrop-filter", "blur(22px) saturate(170%)")
                property("border", "1px solid rgba(255,255,255,0.08)")
                property("border-radius", "14px")
                property("box-shadow", "inset 0 1px 0 rgba(255,255,255,0.14), inset 0 -1px 0 rgba(0,0,0,0.25), 0 20px 40px -20px rgba(0,0,0,0.55)")
                property("height", "100%")
                property("box-sizing", "border-box")
            }
    ) {
        Box(
            modifier = Modifier
                .size(48.px)
                .borderRadius(12.px)
                .margin(bottom = 20.px)
                .styleModifier {
                    property("background", "rgba(240,168,104,0.14)")
                    property("display", "flex")
                    property("align-items", "center")
                    property("justify-content", "center")
                    property("flex-shrink", "0")
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(24.px),
                src = Res.Icon.shield,
                alt = stringResource("certificate_badge_alt")
            )
        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 10.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(19.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .styleModifier { property("letter-spacing", "-0.01em") }
                .toAttrs()
        ) {
            Text(stringResource(certificate.titleKey))
        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 16.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(14.px)
                .color(Theme.Secondary.rgb)
                .styleModifier { property("line-height", "1.6") }
                .toAttrs()
        ) {
            Text(stringResource(certificate.descriptionKey))
        }

        // Issuer · date · credential id — mono, matching the portfolio card meta line.
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 6.px)
                .fontFamily("JetBrains Mono", "monospace")
                .fontSize(12.px)
                .color(Theme.Gray.rgb)
                .toAttrs()
        ) {
            Text("${stringResource(certificate.issuerKey)} · ${stringResource(certificate.dateKey)}")
        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 18.px)
                .fontFamily("JetBrains Mono", "monospace")
                .fontSize(11.px)
                .color(Theme.Gray.rgb)
                .styleModifier { property("opacity", "0.75"); property("word-break", "break-all") }
                .toAttrs()
        ) {
            Text("${stringResource("certificate_id_label")} ")
            // The id is hyphen-separated digits, which bidi reorders into nonsense under RTL
            // ("-193318-3757817"). Isolating it keeps the number exactly as the issuer wrote it.
            Span(
                attrs = Modifier
                    .styleModifier {
                        property("direction", "ltr")
                        property("unicode-bidi", "isolate")
                    }
                    .toAttrs()
            ) {
                Text(certificate.credentialId)
            }
        }

        Row(
            modifier = Modifier.styleModifier { property("margin-top", "auto") }
        ) {
            Link(
                path = certificate.file,
                openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                modifier = Modifier
                    .textDecorationLine(TextDecorationLine.None)
                    .styleModifier {
                        property("display", "inline-flex")
                        property("align-items", "center")
                        property("gap", "6px")
                        property("font-size", "13px")
                        property("color", "rgb(240,168,104)")
                        property("transition", "gap 0.2s ease")
                        property("font-family", "Inter, sans-serif")
                    }
            ) {
                Text(stringResource("certificate_view_link"))
            }
        }
    }
}
