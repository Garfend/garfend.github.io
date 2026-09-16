package org.example.garfend.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.components.certificateCard
import org.example.garfend.components.sectionTitle
import org.example.garfend.components.stringResource
import org.example.garfend.models.Certificate
import org.example.garfend.models.Section
import org.example.garfend.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun certificatesSection() {
    Box(
        modifier = Modifier
            .id(Section.Certificates.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        certificatesContent()
    }
}

@Composable
fun certificatesContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent else 92.percent),
        horizontalAlignment = Alignment.Start
    ) {
        sectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 40.px),
            section = Section.Certificates,
            eyebrow = stringResource("eyebrow_certificates"),
            mainTitle = stringResource("main_title_certificates"),
            alignment = Alignment.Start
        )
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth()
                .styleModifier { property("gap", "20px") },
            numColumns = numColumns(base = 1, sm = 2, lg = 4)
        ) {
            Certificate.entries.forEach { certificate ->
                certificateCard(certificate = certificate)
            }
        }
    }
}
