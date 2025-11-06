package org.example.garfend.models

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String,
    val titleKey: String,
    val subtitleKey: String
) {
    Home(
        id = "home",
        title = "Home",
        subtitle = "",
        path = "#home",
        titleKey = "section_home",
        subtitleKey = ""
    ),
    About(
        id = "about",
        title = "About me",
        subtitle = "About me",
        path = "#about",
        titleKey = "section_about",
        subtitleKey = "subtitle_about"
    ),
    Service(
        id = "service",
        title = "Service",
        subtitle = "I'm Good at",
        path = "#service",
        titleKey = "section_service",
        subtitleKey = "subtitle_service"
    ),
    Portfolio(
        id = "portfolio",
        title = "Portfolio",
        subtitle = "My Work",
        path = "#portfolio",
        titleKey = "section_portfolio",
        subtitleKey = "subtitle_portfolio"
    ),
    Experience(
        id = "experience",
        title = "Experience",
        subtitle = "Work Experience",
        path = "#experience",
        titleKey = "section_experience",
        subtitleKey = "subtitle_experience"
    ),
    Contact(
        id = "contact",
        title = "Contact me",
        subtitle = "Get in Touch",
        path = "#contact",
        titleKey = "section_contact",
        subtitleKey = "subtitle_contact"
    ),
    Testimonial(
        id = "testimonial",
        title = "Testimonial",
        subtitle = "Happy Customers",
        path = "#testimonial",
        titleKey = "section_testimonial",
        subtitleKey = "subtitle_testimonial"
    ),
    Achievements(
        id = "achievements",
        title = "Achievements",
        subtitle = "Personal Achievements",
        path = "#achievements",
        titleKey = "section_achievements",
        subtitleKey = "subtitle_achievements"
    )
}