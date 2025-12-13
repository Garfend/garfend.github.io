package org.example.garfend.components
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.browser.uri.encodeURIComponent
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.example.garfend.styles.InputStyle
import org.example.garfend.util.Constants.CONTACT_EMAIL
import org.example.garfend.util.Constants.CONTACT_PHONE
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.TextArea

@Composable
fun contactForm(breakpoint: Breakpoint) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val formPlaceholderName = stringResource("form_placeholder_name")
    val formPlaceholderEmail = stringResource("form_placeholder_email")
    val formPlaceholderMessage = stringResource("form_placeholder_message")
    val formButtonSubmit = stringResource("form_button_submit")

    val isWideRow = breakpoint >= Breakpoint.MD

    val inputModifier = InputStyle.toModifier()
        .fillMaxWidth()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Input(
            type = InputType.Text,
            attrs = inputModifier
                .margin(bottom = 14.px)
                .toAttrs {
                    attr("placeholder", formPlaceholderName)
                    value(name)
                    onInput { event -> name = event.value }
                }
        )

        if (isWideRow) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.px)
            ) {
                Input(
                    type = InputType.Email,
                    attrs = inputModifier
                        .weight(1f)
                        .toAttrs {
                            attr("placeholder", formPlaceholderEmail)
                            value(email)
                            onInput { event -> email = event.value }
                        }
                )
                Input(
                    type = InputType.Text,
                    attrs = inputModifier
                        .weight(1f)
                        .toAttrs {
                            attr("placeholder", "Subject")
                            value(subject)
                            onInput { event -> subject = event.value }
                        }
                )
                }
        } else {
            Input(
                type = InputType.Email,
                attrs = inputModifier
                    .margin(bottom = 14.px)
                    .toAttrs {
                        attr("placeholder", formPlaceholderEmail)
                        value(email)
                        onInput { event -> email = event.value }
                    }
            )
            Input(
                type = InputType.Text,
                attrs = inputModifier
                    .margin(bottom = 14.px)
                    .toAttrs {
                        attr("placeholder", "Subject")
                        value(subject)
                        onInput { event -> subject = event.value }
                    }
            )
        }

        TextArea(
            attrs = inputModifier
                .height(120.px)
                .margin(top = 12.px)
                .toAttrs {
                    attr("placeholder", formPlaceholderMessage)
                    value(message)
                    onInput { event -> message = event.value }
                }
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            GlowingButton(
                text = formButtonSubmit,
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 16.px),
                onClick = {
                    val target = CONTACT_EMAIL
                    val safeSubject = encodeURIComponent(subject.ifBlank { "Portfolio Contact" })
                    val safeBody = encodeURIComponent(
                        """
                        Name: $name
                        Email: $email
                        Phone: $CONTACT_PHONE

                        $message
                        """.trimIndent()
                    )
                    window.location.href = "mailto:$target?subject=$safeSubject&body=$safeBody"
                }
            )
        }
    }
}
