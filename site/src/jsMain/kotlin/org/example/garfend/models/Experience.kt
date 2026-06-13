package org.example.garfend.models


/**
 * Career history.
 *
 * [isTraining] separates short bootcamp / certification programs from real
 * professional roles so the UI can present them differently — actual roles
 * as the main timeline, training as a small de-emphasized strip.
 */
enum class Experience(
    val number: String,
    val active: Boolean = false,
    val isTraining: Boolean = false,
    val jobPositionKey: String,
    val descriptionKey: String,
    val companyKey: String,
    val fromKey: String,
    val toKey: String
) {
    // ---- Actual professional experience (most recent first) ----
    Cob(
        number = "01",
        active = true,
        jobPositionKey = "exp_mobile_engineer",
        descriptionKey = "exp_desc_cob",
        companyKey = "exp_company_cob",
        fromKey = "exp_date_mar_2026",
        toKey = "exp_date_present"
    ),
    Freelancing(
        number = "02",
        active = true,
        jobPositionKey = "exp_mobile_engineer",
        descriptionKey = "exp_desc_freelance",
        companyKey = "exp_company_freelancing",
        fromKey = "exp_date_apr_2024",
        toKey = "exp_date_present"
    ),
    Ebda3(
        number = "03",
        jobPositionKey = "exp_mobile_developer",
        descriptionKey = "exp_desc_ebda3",
        companyKey = "exp_company_ebda3",
        fromKey = "exp_date_may_2025",
        toKey = "exp_date_2026"
    ),

    // ---- Training programs / certifications (de-emphasized) ----
    Iti(
        number = "T1",
        isTraining = true,
        jobPositionKey = "exp_iti_track",
        descriptionKey = "exp_desc_iti",
        companyKey = "exp_company_iti",
        fromKey = "exp_date_feb_2025",
        toKey = "exp_date_aug_2025"
    ),
    Depi(
        number = "T2",
        isTraining = true,
        jobPositionKey = "exp_depi_track",
        descriptionKey = "exp_desc_depi",
        companyKey = "exp_company_depi",
        fromKey = "exp_date_apr_2024",
        toKey = "exp_date_oct_2024"
    ),
    Chance(
        number = "T3",
        isTraining = true,
        jobPositionKey = "exp_chance_track",
        descriptionKey = "exp_desc_chance",
        companyKey = "exp_company_chance",
        fromKey = "exp_date_feb_2023",
        toKey = "exp_date_jul_2023"
    );

    companion object {
        val professional get() = entries.filter { !it.isTraining }
        val training get() = entries.filter { it.isTraining }
    }
}
