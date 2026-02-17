package org.example.garfend.util

import org.example.garfend.models.Language

object Strings {
    private val translations = mapOf(
        Language.ENGLISH to mapOf(
            // Main Section
            "hello_im" to "Hello, I'm",
            "name" to "Abdelrahman Abdelwahab",
            "job_title" to "Mobile Developer/Designer",
            "hire_me" to "Hire me",

            // Social Links
            "github_link" to "Abdelrahman Abdelwahab github",
            "linkedin_link" to "Abdelrahman Abdelwahab linkedin",

            // Section Titles
            "section_home" to "Home",
            "section_about" to "About me",
            "section_service" to "Service",
            "section_portfolio" to "Portfolio",
            "section_experience" to "Experience",
            "section_contact" to "Contact me",
            "section_testimonial" to "Testimonial",
            "section_achievements" to "Achievements",

            // Section Subtitles
            "subtitle_about" to "About me",
            "subtitle_service" to "I'm Good at",
            "subtitle_portfolio" to "My Work",
            "subtitle_experience" to "Work Experience",
            "subtitle_contact" to "Get in Touch",
            "subtitle_testimonial" to "Happy Customers",
            "subtitle_achievements" to "Personal Achievements",

            // Service Titles
            "service_mobile_dev_title" to "Mobile App Development",
            "service_ui_ux_title" to "UX/UI Design",
            "service_cross_platform_title" to "Cross-Platform Development (Flutter)",

            // Service Descriptions
            "service_mobile_dev_desc" to "building scalable, high-performance mobile apps using Kotlin, Java, and Flutter. From concept to deployment, I deliver robust solutions tailored to your needs.",
            "service_ui_ux_desc" to "creating user-friendly, visually stunning interfaces for Android and iOS apps. My designs focus on functionality, aesthetics, and exceptional user experiences.",
            "service_cross_platform_desc" to "creating seamless, cross-platform mobile experiences using Flutter. From UI/UX design to backend integration, I ensure your app stands out in the competitive market.",

            // Service Image Descriptions
            "service_android_icon" to "Android Icon",
            "service_pen_icon" to "Pen Icon",
            "service_flutter_icon" to "Flutter Icon",

            // Portfolio Titles
            "portfolio_kn_lybia" to "KN lybia",
            "portfolio_fromscratch" to "FromScratch",
            "portfolio_dawaa_link" to "Dawaa Link",
            "portfolio_musemagic" to "MuseMagic",
            "portfolio_dabdoub" to "Dabdoub Butchery",
            "portfolio_titanium_gym" to "Titanuim gym",
            "portfolio_orderk" to "Orderk",
            "portfolio_serinekamal" to "Serine Kamal",
            // Portfolio Categories
            "portfolio_cat_mobile_kotlin" to "Android App - jetpack compose",
            "portfolio_cat_mobile_cmp" to "Mobile App - Compose Multiplatform",
            "portfolio_cat_mobile_flutter" to "Mobile App - flutter",
            "portfolio_cat_ui_ux" to "UI/UX Design",

            // Portfolio Alt Text
            "portfolio_image_alt" to "Portfolio Image",
            "portfolio_link_icon_alt" to "Link Icon",

            // Portfolio Status
            "status_production" to "",
            "status_in_development" to "In development",
            "status_in_testing" to "In testing",

            // Experience - Job Positions
            "exp_mobile_app_developer" to "Mobile App Developer",
            "exp_flutter_developer" to "Flutter Developer",
            "exp_android_trainee" to "Android App Development Trainee",
            "exp_frontend_trainee" to "Front-end and cross-platform development trainee",
            "exp_android_cross_trainee" to "Android and Cross-platform development trainee",

            // Experience - Companies
            "exp_company_freelancing" to "freelancing",
            "exp_company_ebda3" to "Ebda3 Tech",
            "exp_company_chance" to "The chance bootcamp",
            "exp_company_iti" to "ITI",
            "exp_company_depi" to "DEPI",

            // Experience - Dates
            "exp_date_november_2024" to "November 2024",
            "exp_date_may_2025" to "May 2025",
            "exp_date_july_2023" to "July 2023",
            "exp_date_february_2023" to "February 2023",
            "exp_date_feb_2025" to "Feb 2025",
            "exp_date_aug_2025" to "Aug 2025",
            "exp_date_apr_2024" to "Apr 2024",
            "exp_date_oct_2024" to "Oct 2024",
            "exp_date_now" to "NOW",

            // Experience - Job Descriptions
            "exp_desc_1" to "Developing innovative user-centered mobile applications. \n With expertise in Mobile development using Kotlin and Java for Android, \n and Flutter for cross-platform.",
            "exp_desc_2" to "Building and maintaining scalable, high-performance mobile apps using Flutter framework.\n",
            "exp_desc_3" to "intense training in android frameworks such as kotlin, xml, jetpack compose and cmp.\nbuilding android projects from scratch using various techs in the process.",
            "exp_desc_4" to "comprehensive training in program in Frontend and Cross-Platform development.\nusing React, Next, React Native for Front end and cross-platform development java based.\nusing Flutter framework and Dart programming language for mobile app development.\n",
            "exp_desc_5" to "Developed advanced Android apps using Kotlin and jetpack compose, \nDemonstrated proficiency in Android frameworks \nApplied development best practices \nand applying clean code and clean architecture\n",

            // Achievements
            "achievement_completed" to "Completed Projects",
            "achievement_active" to "Active Projects",
            "achievement_satisfied" to "Satisfied Clients",
            "achievement_team" to "Team Members",

            // Contact Section
            "contact_title" to "Let's Connect",
            "contact_description" to "I'm available for freelance work and collaborations. Reach out through any of these platforms:",
            "contact_linkedin_label" to "LinkedIn",
            "contact_linkedin_desc" to "Connect professionally",
            "contact_upwork_label" to "Upwork",
            "contact_upwork_desc" to "Hire me for projects",
            "contact_email_label" to "Email",
            "contact_email_desc" to "Send me a message",

            // Contact Form
            "form_label_name" to "Name",
            "form_placeholder_name" to "Full Name",
            "form_label_email" to "Email",
            "form_placeholder_email" to "Email Address",
            "form_label_message" to "Message",
            "form_placeholder_message" to "Your Message",
            "form_button_submit" to "Submit",

            // About Section
            "about_me_text" to "Hello, I am Abdelrahman Abdelwahab, I am a Mobile App Developer with a strong background in creating innovative, user-centered mobile applications. With expertise in Mobile development using Kotlin and Java for Android, and Flutter for cross-platform, I build apps that are not only just functional but also visually engaging and responsive, Full project management from start to finish, Regular communication is important to me, so let's keep in touch."
        ),
        Language.ARABIC to mapOf(
            // Main Section
            "hello_im" to "مرحباً، أنا",
            "name" to "عبدالرحمن عبدالوهاب",
            "job_title" to "مطور تطبيقات محمولة/مصمم",
            "hire_me" to "وظفني",

            // Social Links
            "github_link" to "جيت هاب عبدالرحمن عبدالوهاب",
            "linkedin_link" to "لينكد إن عبدالرحمن عبدالوهاب",

            // Section Titles
            "section_home" to "الرئيسية",
            "section_about" to "نبذة عني",
            "section_service" to "الخدمات",
            "section_portfolio" to "معرض الأعمال",
            "section_experience" to "الخبرة",
            "section_contact" to "تواصل معي",
            "section_testimonial" to "الشهادات",
            "section_achievements" to "الإنجازات",

            // Section Subtitles
            "subtitle_about" to "نبذة عني",
            "subtitle_service" to "ما أجيده",
            "subtitle_portfolio" to "أعمالي",
            "subtitle_experience" to "الخبرة العملية",
            "subtitle_contact" to "ابق على تواصل",
            "subtitle_testimonial" to "عملاء سعداء",
            "subtitle_achievements" to "الإنجازات الشخصية",

            // Service Titles
            "service_mobile_dev_title" to "تطوير تطبيقات الموبايل",
            "service_ui_ux_title" to "تصميم واجهات المستخدم",
            "service_cross_platform_title" to "التطوير متعدد المنصات (Flutter)",

            // Service Descriptions
            "service_mobile_dev_desc" to "بناء تطبيقات محمولة قابلة للتوسع وعالية الأداء باستخدام Kotlin و Java و Flutter. من الفكرة إلى النشر، أقدم حلولاً قوية مصممة خصيصاً لاحتياجاتك.",
            "service_ui_ux_desc" to "إنشاء واجهات سهلة الاستخدام ومذهلة بصرياً لتطبيقات Android و iOS. تركز تصاميمي على الوظائف والجماليات وتجارب المستخدم الاستثنائية.",
            "service_cross_platform_desc" to "إنشاء تجارب محمولة سلسة متعددة المنصات باستخدام Flutter. من تصميم UI/UX إلى دمج الواجهة الخلفية، أضمن أن يتميز تطبيقك في السوق التنافسي.",

            // Service Image Descriptions
            "service_android_icon" to "أيقونة Android",
            "service_pen_icon" to "أيقونة القلم",
            "service_flutter_icon" to "أيقونة Flutter",

            // Portfolio Titles
            "portfolio_kn_lybia" to "KN ليبيا",
            "portfolio_fromscratch" to "FromScratch",
            "portfolio_dawaa_link" to "دواء لينك",
            "portfolio_musemagic" to "MuseMagic",
            "portfolio_dabdoub" to "جزاره دبدوب",
            "portfolio_titanium_gym" to "تيتانيوم جيم",
            "portfolio_orderk" to "اوردرك",
            "portfolio_serinekamal" to "سيرين كمال",

            // Portfolio Categories
            "portfolio_cat_mobile_kotlin" to "تطبيق Android - Jetpack Compose",
            "portfolio_cat_mobile_cmp" to "تطبيق محمول - Compose Multiplatform",
            "portfolio_cat_mobile_flutter" to "تطبيق محمول - Flutter",
            "portfolio_cat_ui_ux" to "تصميم UI/UX",

            // Portfolio Alt Text
            "portfolio_image_alt" to "صورة المشروع",
            "portfolio_link_icon_alt" to "أيقونة الرابط",

            // Portfolio Status
            "status_production" to "",
            "status_in_development" to "قيد التطوير",
            "status_in_testing" to "قيد الاختبار",

            // Experience - Job Positions
            "exp_mobile_app_developer" to "مطور تطبيقات محمولة",
            "exp_flutter_developer" to "مطور Flutter",
            "exp_android_trainee" to "متدرب تطوير Android",
            "exp_frontend_trainee" to "متدرب تطوير الواجهة الأمامية ومتعدد المنصات",
            "exp_android_cross_trainee" to "متدرب تطوير Android ومتعدد المنصات",

            // Experience - Companies
            "exp_company_freelancing" to "عمل حر",
            "exp_company_ebda3" to "Ebda3 Tech",
            "exp_company_chance" to "The chance bootcamp",
            "exp_company_iti" to "ITI",
            "exp_company_depi" to "DEPI",

            // Experience - Dates
            "exp_date_november_2024" to "نوفمبر 2024",
            "exp_date_may_2025" to "مايو 2025",
            "exp_date_july_2023" to "يوليو 2023",
            "exp_date_february_2023" to "فبراير 2023",
            "exp_date_feb_2025" to "فبراير 2025",
            "exp_date_aug_2025" to "أغسطس 2025",
            "exp_date_apr_2024" to "أبريل 2024",
            "exp_date_oct_2024" to "أكتوبر 2024",
            "exp_date_now" to "الآن",

            // Experience - Job Descriptions
            "exp_desc_1" to "تطوير تطبيقات محمولة مبتكرة تركز على المستخدم. \n مع خبرة في تطوير تطبيقات الموبايل باستخدام Kotlin و Java لـ Android، \n و Flutter لتطوير متعدد المنصات.",
            "exp_desc_2" to "بناء وصيانة تطبيقات محمولة قابلة للتوسع وعالية الأداء باستخدام إطار عمل Flutter.\n",
            "exp_desc_3" to "تدريب مكثف في أطر عمل Android مثل kotlin و xml و jetpack compose و cmp.\nبناء مشاريع Android من الصفر باستخدام تقنيات مختلفة في العملية.",
            "exp_desc_4" to "تدريب شامل في برنامج تطوير الواجهة الأمامية ومتعدد المنصات.\nباستخدام React و Next و React Native للواجهة الأمامية والتطوير متعدد المنصات القائم على Java.\nباستخدام إطار عمل Flutter ولغة برمجة Dart لتطوير تطبيقات الموبايل.\n",
            "exp_desc_5" to "تطوير تطبيقات Android متقدمة باستخدام Kotlin و Jetpack Compose، \nإظهار الكفاءة في أطر عمل Android \nتطبيق أفضل ممارسات التطوير \nوتطبيق الكود النظيف والبنية المعمارية النظيفة\n",

            // Achievements
            "achievement_completed" to "المشاريع المكتملة",
            "achievement_active" to "المشاريع النشطة",
            "achievement_satisfied" to "العملاء الراضون",
            "achievement_team" to "أعضاء الفريق",

            // Contact Section
            "contact_title" to "لنتواصل",
            "contact_description" to "أنا متاح للعمل الحر والتعاون. تواصل معي عبر أي من هذه المنصات:",
            "contact_linkedin_label" to "لينكد إن",
            "contact_linkedin_desc" to "تواصل بشكل احترافي",
            "contact_upwork_label" to "أب ورك",
            "contact_upwork_desc" to "وظفني للمشاريع",
            "contact_email_label" to "البريد الإلكتروني",
            "contact_email_desc" to "أرسل لي رسالة",

            // Contact Form
            "form_label_name" to "الاسم",
            "form_placeholder_name" to "الاسم الكامل",
            "form_label_email" to "البريد الإلكتروني",
            "form_placeholder_email" to "عنوان البريد الإلكتروني",
            "form_label_message" to "الرسالة",
            "form_placeholder_message" to "رسالتك",
            "form_button_submit" to "إرسال",

            // About Section
            "about_me_text" to "مرحباً، أنا عبدالرحمن عبدالوهاب، مطور تطبيقات محمولة مع خلفية قوية في إنشاء تطبيقات محمولة مبتكرة تركز على المستخدم. مع خبرة في تطوير تطبيقات الموبايل باستخدام Kotlin و Java لـ Android، و Flutter للتطوير متعدد المنصات، أقوم ببناء تطبيقات ليست وظيفية فحسب، بل أيضاً جذابة بصرياً ومتجاوبة، إدارة كاملة للمشروع من البداية إلى النهاية، التواصل المنتظم مهم بالنسبة لي، لذا دعونا نبقى على تواصل."
        )
    )

    fun get(key: String, language: Language): String {
        return translations[language]?.get(key) ?: key
    }
}
