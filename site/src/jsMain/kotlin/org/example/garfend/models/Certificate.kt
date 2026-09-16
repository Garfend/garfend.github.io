package org.example.garfend.models

/**
 * A completed training certificate, shown in the Certificates section and linked to the PDF
 * that lives under `resources/public/certificates/`.
 *
 * @param file        path of the PDF, served from the site root
 * @param credentialId the issuer's certificate number, so a reader can verify it
 */
enum class Certificate(
    val titleKey: String,
    val descriptionKey: String,
    val issuerKey: String,
    val dateKey: String,
    val file: String,
    val credentialId: String
) {
    HipaaPrivacy(
        titleKey = "certificate_hipaa_privacy",
        descriptionKey = "certificate_hipaa_privacy_desc",
        issuerKey = "certificate_issuer_hcp",
        dateKey = "certificate_date_may_2026",
        file = "/certificates/hipaa-privacy.pdf",
        credentialId = "3757817-193318-18508101"
    ),
    HipaaSecurity(
        titleKey = "certificate_hipaa_security",
        descriptionKey = "certificate_hipaa_security_desc",
        issuerKey = "certificate_issuer_hcp",
        dateKey = "certificate_date_may_2026",
        file = "/certificates/hipaa-security.pdf",
        credentialId = "3757817-193320-18508101"
    ),
    CodeOfConduct(
        titleKey = "certificate_code_of_conduct",
        descriptionKey = "certificate_code_of_conduct_desc",
        issuerKey = "certificate_issuer_hcp",
        dateKey = "certificate_date_may_2026",
        file = "/certificates/code-of-conduct-compliance.pdf",
        credentialId = "3757817-193322-18508101"
    ),
    OshaSafety(
        titleKey = "certificate_osha_safety",
        descriptionKey = "certificate_osha_safety_desc",
        issuerKey = "certificate_issuer_hcp",
        dateKey = "certificate_date_may_2026",
        file = "/certificates/osha-safety-bloodborne-pathogens.pdf",
        credentialId = "3757817-193324-18508101"
    )
}
