package org.example.garfend.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.example.garfend.components.GlowingButton
import org.example.garfend.components.LocalLanguage
import org.example.garfend.components.SocialIconButton
import org.example.garfend.components.header
import org.example.garfend.components.stringResource
import org.example.garfend.models.Section
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun mainSection(onMenuClicked: () -> Unit, isMenuOpen: Boolean = false) {
    Box(
        modifier = Modifier
            .id(Section.Home.id)
            .fillMaxWidth(100.percent)
            .maxWidth(SECTION_WIDTH.px)
            .minHeight(100.vh)
            .maxHeight(100.percent)
            .position(Position.Relative),
        contentAlignment = Alignment.Center
    ) {
//        mainBackground()
        mainContent(onMenuClicked = onMenuClicked, isMenuOpen = isMenuOpen)
    }
}


@Composable
fun mainContent(onMenuClicked: () -> Unit, isMenuOpen: Boolean) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        header(onMenuClicked = onMenuClicked, isMenuOpen = isMenuOpen)
        mainText(breakpoint = breakpoint)
    }
}

@Composable
fun mainText(breakpoint: Breakpoint) {
    val isWide = breakpoint > Breakpoint.MD
    val topPadding = if (isWide) 80.px else 100.px
    val containerModifier = Modifier
        .fillMaxWidth(if (isWide) 90.percent else 95.percent)
        .maxWidth(1200.px)
        .padding(leftRight = 20.px)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = topPadding, bottom = 40.px),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = containerModifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeroTextBlock(breakpoint = breakpoint, alignStart = true)
//            if (!isWide) {
//                HeroImage(breakpoint = breakpoint, alignEnd = false, overlay = false)
//            }
        }
//        if (isWide) {
//            HeroImage(breakpoint = breakpoint, alignEnd = true, overlay = true)
//        }
    }
}

@Composable
private fun HeroTextBlock(breakpoint: Breakpoint, alignStart: Boolean) {
    val language = LocalLanguage.current
    val introSize = if (breakpoint >= Breakpoint.LG) 24.px else 18.px
    val nameSize = if (breakpoint >= Breakpoint.LG) 56.px else 36.px
    val roleSize = if (breakpoint >= Breakpoint.LG) 20.px else 16.px
    val textAlign = if (alignStart) TextAlign.Left else TextAlign.Center
    val alignment = if (alignStart) Alignment.Start else Alignment.CenterHorizontally

    Column(
        modifier = Modifier
            .width(90.percent)
            .maxWidth(1100.px),
        horizontalAlignment = alignment
    ) {
        P(
            attrs = Modifier
                .margin(bottom = 5.px, top = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(introSize)
                .fontWeight(FontWeight.Normal)
                .color(Colors.White)
                .textAlign(textAlign)
                .toAttrs()
        ) {
            Text(stringResource("hello_im"))
        }
        P(
            attrs = Modifier
                .margin(top = 8.px, bottom = 10.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(nameSize)
                .fontWeight(FontWeight.Bold)
                .color(Colors.White)
                .textAlign(if(language.isRTL) TextAlign.Right else textAlign)
                .toAttrs()
        ) {
            Text(stringResource("name"))
        }
        P(
            attrs = Modifier
                .margin(top = 0.px, bottom = 30.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(roleSize)
                .fontWeight(FontWeight.Normal)
                .color(rgb(204, 204, 204))
                .textAlign(textAlign)
                .toAttrs()
        ) {
            Text(stringResource("job_title"))
        }
        ActionArea(alignStart = alignStart)
    }
}

@Composable
private fun ActionArea(alignStart: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (alignStart) Arrangement.Start else Arrangement.Center
    ) {
        GlowingButton(
            text = stringResource("hire_me"),
            onClick = { window.open("https://www.upwork.com/freelancers/~018456b0decc0006b0", "_blank") }
        )
        Box(modifier = Modifier.width(16.px))
        SocialIcons()
    }
}

@Composable
private fun SocialIcons() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialIconButton(
            href = "https://github.com/Garfend"
        ) { FaGithub(size = IconSize.XL) }
        Box(modifier = Modifier.width(16.px))
        SocialIconButton(
            href = "https://www.linkedin.com/in/abdelrahman-abdelwahab-abo-ibrahim-91a01a214/"
        ) { FaLinkedin(size = IconSize.XL) }
    }
}

//@Composable
//private fun HeroImage(breakpoint: Breakpoint, alignEnd: Boolean, overlay: Boolean) {
//    val imageWidth = if (breakpoint >= Breakpoint.LG) 450.px else 300.px
//    val baseAlignment = if (alignEnd) Alignment.CenterEnd else Alignment.Center
//    var modifier = Modifier
//        .maxWidth(imageWidth)
//        .margin(bottom = if (overlay) 0.px else 30.px)
//        .styleModifier {
//            property("filter", "drop-shadow(0 0 20px rgba(0,0,0,0.5))")
//            property("mask-image", "linear-gradient(to bottom, black 80%, transparent 100%)")
//        }
//
//    modifier = if (overlay) {
//        modifier
//            .position(Position.Absolute)
//            .alignContent(alignContent = AlignContent.Start)
//            .pointerEvents(PointerEvents.None)
//            .padding(bottom = 40.px)
//    } else {
//        modifier
//            .width(if (alignEnd) 50.percent else 100.percent)
//    }
//
//    Box(
//        modifier = Modifier.then(
//            if (overlay) Modifier.fillMaxSize() else Modifier.width(if (alignEnd) 50.percent else 100.percent)
//        ),
//        contentAlignment = baseAlignment
//    ) {
//        Image(
//            modifier = MainImageStyle.toModifier()
//                .then(modifier),
//            src = Res.Image.serineKamal,
//            alt = "Abdelrahman Portrait"
//        )
//    }
//}
