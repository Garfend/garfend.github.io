package org.example.garfend.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.garfend.models.Theme
import org.example.garfend.util.Constants.FONT_FAMILY
import org.example.garfend.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

private data class Commit(
    val hash: String,
    val refs: List<Pair<String, RefKind>>,
    val date: String,
    val role: String,
    val org: String,
    val body: String,
    val tags: List<String>
)

private enum class RefKind { Head, Branch, Tag }

private val MONO = arrayOf("JetBrains Mono", "ui-monospace", "SF Mono", "Menlo", "monospace")

private val COMMITS = listOf(
    Commit(
        hash = "a91c4d2",
        refs = listOf("HEAD" to RefKind.Head, "main" to RefKind.Branch),
        date = "Nov 2024 — Now",
        role = "Mobile App Developer",
        org = "Freelancing",
        body = "Building and maintaining scalable, high-performance mobile apps using the Flutter framework. Direct client engagements end-to-end — discovery, architecture, ship.",
        tags = listOf("Flutter", "Dart", "Firebase", "Supabase", "GraphQL")
    ),
    Commit(
        hash = "f3e8b71",
        refs = listOf("origin/training" to RefKind.Branch),
        date = "May 2025 — Now",
        role = "Flutter Developer",
        org = "Ebda3 Tech",
        body = "Intense training in Android frameworks — Kotlin, XML, Jetpack Compose and Compose Multiplatform. Building Android projects from scratch with modern stacks.",
        tags = listOf("Kotlin", "Jetpack Compose", "CMP", "Android")
    ),
    Commit(
        hash = "2c8f5e9",
        refs = listOf("tag: v3.0" to RefKind.Tag),
        date = "Feb 2025 — Aug 2025",
        role = "Front-end & Cross-platform Trainee",
        org = "ITI",
        body = "Advanced Android using Kotlin and Jetpack Compose. Demonstrated proficiency across Android frameworks with clean code, clean architecture and best practices.",
        tags = listOf("Kotlin", "Compose", "Clean Architecture")
    ),
    Commit(
        hash = "7b04ace",
        refs = listOf("tag: v2.0" to RefKind.Tag),
        date = "Apr 2024 — Oct 2024",
        role = "Android & Cross-platform Trainee",
        org = "DEPI",
        body = "Foundational training in Android and cross-platform development, building hands-on projects with industry tooling and clean-architecture patterns.",
        tags = listOf("Android", "Flutter", "Dart")
    ),
    Commit(
        hash = "d61920f",
        refs = listOf("tag: v1.0" to RefKind.Tag),
        date = "Jul 2023 — Feb 2024",
        role = "Android App Development Trainee",
        org = "The Chance Bootcamp",
        body = "Comprehensive program in front-end and cross-platform development. React, Next.js and React Native for web/cross-platform; Flutter and Dart for mobile.",
        tags = listOf("React", "Next.js", "React Native", "Flutter")
    )
)

@Composable
fun experienceGitLogSection() {
    Box(
        modifier = Modifier
            .id("experience-gitlog")
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        experienceGitLogContent()
    }
}

@Composable
private fun experienceGitLogContent() {
    val breakpoint = rememberBreakpoint()
    val isDesktop = breakpoint >= Breakpoint.MD

    Column(
        modifier = Modifier
            .fillMaxWidth(if (isDesktop) 90.percent else 92.percent),
        horizontalAlignment = Alignment.Start
    ) {
        // Eyebrow + main title (rendered inline so we don't bind to Section.Experience.id)
        Row(
            modifier = Modifier.margin(bottom = 18.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Span(
                attrs = Modifier
                    .styleModifier {
                        property("display", "inline-block")
                        property("width", "28px")
                        property("height", "1px")
                        property("background", "rgb(240,168,104)")
                        property("margin-right", "10px")
                        property("flex-shrink", "0")
                    }
                    .toAttrs()
            ) {}
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(*MONO)
                    .fontSize(13.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.LightRed.rgb)
                    .styleModifier {
                        property("letter-spacing", "0.08em")
                        property("text-transform", "uppercase")
                    }
                    .toAttrs()
            ) {
                Text("04 — Experience (git log preview)")
            }
        }

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontFamily(*FONT_FAMILY)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .styleModifier {
                    property("font-size", "clamp(36px, 5vw, 52px)")
                    property("letter-spacing", "-0.02em")
                    property("line-height", "1.05")
                }
                .toAttrs()
        ) {
            Text("Track record.")
        }

        // Intro paragraph
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 24.px, bottom = 32.px)
                .fontFamily(*FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .styleModifier {
                    property("max-width", "640px")
                    property("line-height", "1.7")
                }
                .toAttrs()
        ) {
            Text("A commit log of where I've shipped, what I learned, and where I'm pointed next.")
        }

        // Terminal card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .styleModifier {
                    property("border", "1px solid rgba(255,255,255,0.10)")
                    property("border-radius", "14px")
                    property(
                        "background",
                        "linear-gradient(180deg, rgba(10,12,16,0.80), rgba(10,12,16,0.95))"
                    )
                    property("backdrop-filter", "blur(20px) saturate(160%)")
                    property("-webkit-backdrop-filter", "blur(20px) saturate(160%)")
                    property("overflow", "hidden")
                    property(
                        "box-shadow",
                        "inset 0 1px 0 rgba(255,255,255,0.12), inset 0 -1px 0 rgba(0,0,0,0.30), 0 30px 60px -30px rgba(0,0,0,0.7)"
                    )
                    property("font-family", MONO.joinToString(","))
                }
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                terminalBar(isDesktop)
                terminalCommand()
                terminalLog(isDesktop)
            }
        }
    }
}

@Composable
private fun terminalBar(isDesktop: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(topBottom = 12.px, leftRight = 16.px)
            .styleModifier {
                property("border-bottom", "1px solid rgba(255,255,255,0.06)")
                property("background", "rgba(0,0,0,0.30)")
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        terminalDot("#ef5f56")
        Box(modifier = Modifier.width(10.px)) {}
        terminalDot("#f5bd4f")
        Box(modifier = Modifier.width(10.px)) {}
        terminalDot("#5dc35a")
        if (isDesktop) {
            P(
                attrs = Modifier
                    .fontFamily(*MONO)
                    .fontSize(12.px)
                    .color(Theme.Gray.rgb)
                    .margin(topBottom =  0.px, leftRight = 14.px)
                    .toAttrs()
            ) {
                Text("~/career/abdelrahman — git log --oneline --decorate")
            }
        }
    }
}

@Composable
private fun terminalDot(color: String) {
    Box(
        modifier = Modifier
            .size(10.px)
            .styleModifier {
                property("border-radius", "50%")
                property("background", color)
                property("flex-shrink", "0")
            }
    ) {}
}

@Composable
private fun terminalCommand() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 22.px, bottom = 12.px, leftRight = 26.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Span(
            attrs = Modifier
                .fontFamily(*MONO)
                .fontSize(13.px)
                .color(Theme.LightRed.rgb)
                .toAttrs()
        ) {
            Text("➜ ")
        }
        Span(
            attrs = Modifier
                .fontFamily(*MONO)
                .fontSize(13.px)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text("git log --graph --pretty=track-record")
        }
    }
}

@Composable
private fun terminalLog(isDesktop: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.px, bottom = 28.px, leftRight = if (isDesktop) 26.px else 18.px),
    ) {
        COMMITS.forEach { commit ->
            commitRow(commit, isDesktop)
        }
    }
}

@Composable
private fun commitRow(commit: Commit, isDesktop: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.px, bottom = 18.px, left = 38.px)
            .margin(left = 8.px)
            .styleModifier {
                property("position", "relative")
                property("border-left", "1px solid rgba(255,255,255,0.08)")
            }
    ) {
        // The commit dot on the rail
        Box(
            modifier = Modifier
                .size(12.px)
                .styleModifier {
                    property("position", "absolute")
                    property("left", "-24.5px")
                    property("top", "24px")
                    property("border-radius", "50%")
                    property("background", "#0d0f12")
                    property("border", "2px solid rgb(240,168,104)")
                    property("box-shadow", "0 0 0 3px rgba(240,168,104,0.18)")
                }
        ) {}

        Column(modifier = Modifier.fillMaxWidth()) {
            // Meta row: hash, refs, author/date
            commitMeta(commit, isDesktop)

            // Title: Role @ Org
            H3(
                attrs = Modifier
                    .margin(top = 4.px, bottom = 6.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontSize(17.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .styleModifier {
                        property("letter-spacing", "-0.005em")
                    }
                    .toAttrs()
            ) {
                Text("${commit.role} @ ${commit.org}")
            }

            // Body
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(*FONT_FAMILY)
                    .fontSize(13.px)
                    .color(Theme.Secondary.rgb)
                    .styleModifier {
                        property("line-height", "1.65")
                        property("max-width", "720px")
                    }
                    .toAttrs()
            ) {
                Text(commit.body)
            }

            // Tags
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 10.px)
                    .styleModifier {
                        property("flex-wrap", "wrap")
                        property("gap", "6px")
                    },
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                commit.tags.forEach { tag ->
                    Span(
                        attrs = Modifier
                            .padding(top = 3.px, bottom = 3.px, leftRight = 8.px)
                            .fontFamily(*MONO)
                            .fontSize(11.px)
                            .color(Theme.LighterRed.rgb)
                            .styleModifier {
                                property("border-radius", "4px")
                                property("background", "rgba(240,168,104,0.12)")
                                property("border", "1px solid rgba(240,168,104,0.25)")
                            }
                            .toAttrs()
                    ) {
                        Text(tag)
                    }
                }
            }
        }
    }
}

@Composable
private fun commitMeta(commit: Commit, isDesktop: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(bottom = 6.px)
            .styleModifier {
                property("flex-wrap", "wrap")
                property("gap", "8px")
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Span(
            attrs = Modifier
                .fontFamily(*MONO)
                .fontSize(12.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.LightRed.rgb)
                .toAttrs()
        ) {
            Text(commit.hash)
        }

        // refs in parentheses
        Span(
            attrs = Modifier
                .fontFamily(*MONO)
                .fontSize(12.px)
                .color(Theme.Gray.rgb)
                .toAttrs()
        ) {
            Text("(")
            commit.refs.forEachIndexed { i, (label, kind) ->
                val refColor = when (kind) {
                    RefKind.Head -> "#8dd2ff"
                    RefKind.Branch -> "#f7c89a"
                    RefKind.Tag -> "#f7c89a"
                }
                Span(
                    attrs = Modifier
                        .styleModifier {
                            property("color", refColor)
                        }
                        .toAttrs()
                ) {
                    Text(label)
                }
                if (i < commit.refs.size - 1) {
                    Text(", ")
                }
            }
            Text(")")
        }

        // Author / date — pushed to the right on desktop via margin-left: auto
        Span(
            attrs = Modifier
                .fontFamily(*MONO)
                .fontSize(11.px)
                .color(Theme.Gray.rgb)
                .styleModifier {
                    if (isDesktop) property("margin-left", "auto")
                }
                .toAttrs()
        ) {
            Text("— ${commit.date}")
        }
    }
}
