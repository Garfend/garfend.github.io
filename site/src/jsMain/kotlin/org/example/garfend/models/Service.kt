package org.example.garfend.models

import org.example.garfend.util.Constants.ANDROID_DEV
import org.example.garfend.util.Constants.UI_UX
import org.example.garfend.util.Constants.MOBILE_DEV
import org.example.garfend.util.Res

enum class Service(
    val icon: String,
    val imageDesc: String,
    val title: String,
    val description: String,
    val imageDescKey: String,
    val titleKey: String,
    val descriptionKey: String
) {
    Android(
        icon = Res.Icon.android,
        imageDesc = "Android Icon",
        title = "Mobile App Development",
        description = ANDROID_DEV,
        imageDescKey = "service_android_icon",
        titleKey = "service_mobile_dev_title",
        descriptionKey = "service_mobile_dev_desc"
    ),
    Design(
        icon = Res.Icon.design,
        imageDesc = "Pen Icon",
        title = "UX/UI Design",
        description = UI_UX,
        imageDescKey = "service_pen_icon",
        titleKey = "service_ui_ux_title",
        descriptionKey = "service_ui_ux_desc"
    ),
    Mobile(
        icon = Res.Icon.flutter,
        imageDesc = "Flutter Icon",
        title = "Cross-Platform Development (Flutter)",
        description = MOBILE_DEV,
        imageDescKey = "service_flutter_icon",
        titleKey = "service_cross_platform_title",
        descriptionKey = "service_cross_platform_desc"
    )
}