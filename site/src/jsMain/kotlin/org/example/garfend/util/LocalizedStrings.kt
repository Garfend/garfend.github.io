package org.example.garfend.util

import org.example.garfend.models.Language

object Strings {
    private val translations = mapOf(
        Language.ENGLISH to mapOf(
            // Main Section
            "hello_im" to "Hello, I'm",
            "name" to "Abdelrahman Abdelwahab",
            "hero_first_name" to "Abdelrahman",
            "hero_last_name" to "Abdelwahab.",
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

            // Section Eyebrows (numbered labels)
            "eyebrow_about" to "01 — About me",
            "eyebrow_service" to "02 — Service",
            "eyebrow_portfolio" to "03 — Portfolio",
            "eyebrow_experience" to "04 — Experience",
            "eyebrow_contact" to "05 — Contact me",

            // Section Main Titles
            "main_title_about" to "Engineering precision.\nCreative design.",
            "main_title_service" to "What I do.",
            "main_title_portfolio" to "Selected work.",
            "main_title_experience" to "Track record.",

            // About Stats
            "stat_label_apps_shipped" to "Production apps shipped",
            "stat_label_years_building" to "Years building mobile",
            "stat_label_training" to "Training programs completed",
            "stat_label_curiosity" to "Curiosity for new tech",
            "state_label_happy_clients" to "Happy clients",

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

            // Portfolio Card - Cross-platform overlay & alts
            "alt_app_store" to "App Store",
            "alt_google_play" to "Google Play",
            "platform_label_ios" to "iOS",
            "platform_label_android" to "Android",
            "link_view_case_study" to "View Project →",

            // Portfolio Card - Chip labels (LinkType)
            "chip_link_app_store" to "iOS",
            "chip_link_play_store" to "Android",
            "chip_link_github" to "GitHub",
            "chip_link_website" to "Live preview",
            "chip_link_figma" to "Figma",
            "chip_link_other" to "View",

            // Portfolio Card - Dev status title suffix
            "dev_status_in_dev_suffix" to " (In dev)",
            "dev_status_in_testing_suffix" to " (In testing)",

            // Portfolio Detail - Section headings
            "heading_about_app" to "About this app",
            "heading_app_information" to "App information",

            // Portfolio Detail - App Store loading/error states
            "app_store_loading" to "Loading app data from App Store...",
            "app_store_load_failed" to "⚠ Failed to load app data from App Store",
            "app_store_description_loading" to "Loading description from App Store...",
            "app_store_description_failed" to "⚠ Failed to load description from App Store. Please try again later.",
            "loading_short" to "Loading...",
            "app_store_fetching" to "Fetching from App Store...",
            "app_store_data_label" to "App Store Data",
            "failed_to_load_short" to "⚠ Failed to load",

            // Portfolio Detail - "Version" label under rating block
            "label_version" to "Version",

            // Portfolio Detail - Info row labels
            "label_developer" to "Developer",
            "label_category" to "Category",
            "label_platform" to "Platform",
            "label_status" to "Status",
            "label_details" to "Details",
            "label_rating" to "Rating",
            "label_price" to "Price",
            "label_size" to "Size",
            "label_requires_ios" to "Requires iOS",
            "label_age_rating" to "Age Rating",
            "label_genres" to "Genres",
            "requires_ios_suffix" to " or later",

            // Portfolio Detail - Platform values
            "platform_ios_android" to "iOS & Android",
            "platform_android" to "Android",
            "platform_ios" to "iOS",
            "platform_web" to "Web",
            "platform_open_source" to "Open Source",
            "platform_design" to "Design",
            "platform_other" to "Other",

            // Portfolio Detail - Status values
            "status_available" to "Available",
            "status_in_development_label" to "In Development",
            "status_in_testing_label" to "In Testing",

            // Footer
            "footer_copyright" to "© 2026 — Abdelrahman Abdelwahab",

            // Experience - intro + training label
            "exp_intro" to "A few years of building, rescuing, and scaling production mobile apps — from healthcare platforms to cross-market client work.",
            "exp_training_label" to "Training & certifications",

            // Experience - Job Positions
            "exp_mobile_engineer" to "Mobile Engineer",
            "exp_mobile_developer" to "Mobile Developer",
            "exp_iti_track" to "Front-end & Cross-platform Development",
            "exp_depi_track" to "Android & Cross-platform Development",
            "exp_chance_track" to "Android App Development",

            // Experience - Companies
            "exp_company_cob" to "COB Solution",
            "exp_company_freelancing" to "Freelancing",
            "exp_company_ebda3" to "Ebda3 Tech",
            "exp_company_iti" to "ITI",
            "exp_company_depi" to "DEPI",
            "exp_company_chance" to "The Chance Bootcamp",

            // Experience - Dates
            "exp_date_mar_2026" to "Mar 2026",
            "exp_date_may_2025" to "May 2025",
            "exp_date_feb_2025" to "Feb 2025",
            "exp_date_aug_2025" to "Aug 2025",
            "exp_date_apr_2024" to "Apr 2024",
            "exp_date_oct_2024" to "Oct 2024",
            "exp_date_feb_2023" to "Feb 2023",
            "exp_date_jul_2023" to "Jul 2023",
            "exp_date_2026" to "2026",
            "exp_date_present" to "Present",

            // Experience - Job Descriptions
            "exp_desc_cob" to "Building mobile apps for a US healthcare RCM platform serving clinics, labs, and pharmacies. HIPAA-conscious flows with secure auth, encrypted storage, and EHR-integrated billing APIs.",
            "exp_desc_freelance" to "Full mobile ownership for client apps across MENA and USA — scalable Flutter architecture, full-stack Firebase, Stripe payments, and push automation. Rescued stalled projects and mentored junior developers.",
            "exp_desc_ebda3" to "Built production Flutter apps for multinational clients with Clean Architecture, optimizing performance and shipping stable App Store / Google Play releases.",
            "exp_desc_iti" to "Comprehensive training in Front-end and Cross-Platform development.\nUsing React, Next, and React Native for front-end and Java-based cross-platform development.\nUsing the Flutter framework and Dart programming language for mobile app development.",
            "exp_desc_depi" to "Developed advanced Android apps using Kotlin and Jetpack Compose.\nDemonstrated proficiency in Android frameworks and applied development best practices,\napplying clean code and clean architecture.",
            "exp_desc_chance" to "Intense training in Android frameworks such as Kotlin, XML, Jetpack Compose and CMP.\nBuilding Android projects from scratch using various technologies in the process.",

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
            "about_me_text" to "Hi, I'm Abdelrahman Abdelwahab a Mobile Application Developer who believes great apps are built at the intersection of engineering precision and creative design. With a Computer Engineering background, I bring a strong problem-solving approach to mobile development that goes beyond just writing code.\n\nSpecializing in Android (Kotlin, Jetpack Compose) and Flutter, I craft production-ready applications that serve real users across healthcare, e-commerce, and lifestyle sectors. I'm passionate about clean architecture, maintainable code, and building apps that not only work flawlessly but also delight users with intuitive, responsive interfaces.\n\nWhether it's architecting scalable mobile solutions, integrating complex backend systems (Firebase, Supabase, GraphQL), or designing pixel-perfect UIs, I handle every phase of development from initial concept to App Store deployment. I value transparent communication and treat every project as a partnership, ensuring we stay aligned from start to finish.\n\nCurrently, I'm working as a Freelance Mobile Developer, continuously expanding my skills in Kotlin Multiplatform and modern development practices. Let's build something exceptional together."
        ),
        Language.ARABIC to mapOf(
            // Main Section
            "hello_im" to "مرحباً، أنا",
            "name" to "عبدالرحمن عبدالوهاب",
            "hero_first_name" to "عبدالرحمن",
            "hero_last_name" to "عبدالوهاب.",
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

            // Section Eyebrows (numbered labels)
            "eyebrow_about" to "01 — نبذة عني",
            "eyebrow_service" to "02 — الخدمات",
            "eyebrow_portfolio" to "03 — معرض الأعمال",
            "eyebrow_experience" to "04 — الخبرة",
            "eyebrow_contact" to "05 — تواصل معي",

            // Section Main Titles
            "main_title_about" to "هندسة دقيقة.\nتصميم إبداعي.",
            "main_title_service" to "ما أقوم به.",
            "main_title_portfolio" to "أعمال مختارة.",
            "main_title_experience" to "سجل الإنجازات.",

            // About Stats
            "stat_label_apps_shipped" to "تطبيقات تم إطلاقها",
            "stat_label_years_building" to "سنوات في تطوير الموبايل",
            "stat_label_training" to "برامج تدريبية مكتملة",
            "stat_label_curiosity" to "شغف بالتقنيات الجديدة",
            "state_label_happy_clients" to "عملاء سعداء",

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

            // Portfolio Card - Cross-platform overlay & alts
            "alt_app_store" to "App Store",
            "alt_google_play" to "Google Play",
            "platform_label_ios" to "iOS",
            "platform_label_android" to "Android",
            "link_view_case_study" to "عرض المشروع ←",

            // Portfolio Card - Chip labels (LinkType)
            "chip_link_app_store" to "iOS",
            "chip_link_play_store" to "Android",
            "chip_link_github" to "GitHub",
            "chip_link_website" to "معاينة مباشرة",
            "chip_link_figma" to "Figma",
            "chip_link_other" to "عرض",

            // Portfolio Card - Dev status title suffix
            "dev_status_in_dev_suffix" to " (قيد التطوير)",
            "dev_status_in_testing_suffix" to " (قيد الاختبار)",

            // Portfolio Detail - Section headings
            "heading_about_app" to "حول هذا التطبيق",
            "heading_app_information" to "معلومات التطبيق",

            // Portfolio Detail - App Store loading/error states
            "app_store_loading" to "جاري تحميل بيانات التطبيق من App Store...",
            "app_store_load_failed" to "⚠ فشل تحميل بيانات التطبيق من App Store",
            "app_store_description_loading" to "جاري تحميل الوصف من App Store...",
            "app_store_description_failed" to "⚠ فشل تحميل الوصف من App Store. يرجى المحاولة مرة أخرى لاحقاً.",
            "loading_short" to "جاري التحميل...",
            "app_store_fetching" to "جاري الجلب من App Store...",
            "app_store_data_label" to "بيانات App Store",
            "failed_to_load_short" to "⚠ فشل التحميل",

            // Portfolio Detail - "Version" label under rating block
            "label_version" to "الإصدار",

            // Portfolio Detail - Info row labels
            "label_developer" to "المطور",
            "label_category" to "الفئة",
            "label_platform" to "المنصة",
            "label_status" to "الحالة",
            "label_details" to "التفاصيل",
            "label_rating" to "التقييم",
            "label_price" to "السعر",
            "label_size" to "الحجم",
            "label_requires_ios" to "يتطلب iOS",
            "label_age_rating" to "التصنيف العمري",
            "label_genres" to "الأنواع",
            "requires_ios_suffix" to " أو أحدث",

            // Portfolio Detail - Platform values
            "platform_ios_android" to "iOS و Android",
            "platform_android" to "Android",
            "platform_ios" to "iOS",
            "platform_web" to "ويب",
            "platform_open_source" to "مفتوح المصدر",
            "platform_design" to "تصميم",
            "platform_other" to "أخرى",

            // Portfolio Detail - Status values
            "status_available" to "متاح",
            "status_in_development_label" to "قيد التطوير",
            "status_in_testing_label" to "قيد الاختبار",

            // Footer
            "footer_copyright" to "© 2026 — عبدالرحمن عبدالوهاب",

            // Experience - intro + training label
            "exp_intro" to "سنوات من بناء وإنقاذ وتوسيع تطبيقات الموبايل الإنتاجية — من منصات الرعاية الصحية إلى مشاريع العملاء عبر الأسواق.",
            "exp_training_label" to "التدريب والشهادات",

            // Experience - Job Positions
            "exp_mobile_engineer" to "مهندس موبايل",
            "exp_mobile_developer" to "مطور موبايل",
            "exp_iti_track" to "تطوير الواجهة الأمامية ومتعدد المنصات",
            "exp_depi_track" to "تطوير Android ومتعدد المنصات",
            "exp_chance_track" to "تطوير تطبيقات Android",

            // Experience - Companies
            "exp_company_cob" to "COB Solution",
            "exp_company_freelancing" to "عمل حر",
            "exp_company_ebda3" to "Ebda3 Tech",
            "exp_company_iti" to "ITI",
            "exp_company_depi" to "DEPI",
            "exp_company_chance" to "The Chance Bootcamp",

            // Experience - Dates
            "exp_date_mar_2026" to "مارس 2026",
            "exp_date_may_2025" to "مايو 2025",
            "exp_date_feb_2025" to "فبراير 2025",
            "exp_date_aug_2025" to "أغسطس 2025",
            "exp_date_apr_2024" to "أبريل 2024",
            "exp_date_oct_2024" to "أكتوبر 2024",
            "exp_date_feb_2023" to "فبراير 2023",
            "exp_date_jul_2023" to "يوليو 2023",
            "exp_date_2026" to "2026",
            "exp_date_present" to "الآن",

            // Experience - Job Descriptions
            "exp_desc_cob" to "بناء تطبيقات موبايل لمنصة رعاية صحية أمريكية (RCM) تخدم العيادات والمعامل والصيدليات. تدفقات متوافقة مع HIPAA مع مصادقة آمنة وتخزين مشفّر وواجهات فوترة متكاملة مع EHR.",
            "exp_desc_freelance" to "ملكية كاملة لتطبيقات العملاء عبر أسواق MENA وUSA — معمارية Flutter قابلة للتوسع، وحلول Firebase متكاملة، ومدفوعات Stripe، وأتمتة الإشعارات. إنقاذ مشاريع متعثرة وإرشاد المطورين المبتدئين.",
            "exp_desc_ebda3" to "بناء تطبيقات Flutter إنتاجية لعملاء متعددي الجنسيات بمعمارية نظيفة، مع تحسين الأداء وإصدارات مستقرة على App Store / Google Play.",
            "exp_desc_iti" to "تدريب شامل في تطوير الواجهة الأمامية ومتعدد المنصات.\nباستخدام React وNext وReact Native للواجهة الأمامية والتطوير متعدد المنصات القائم على Java.\nباستخدام إطار عمل Flutter ولغة Dart لتطوير تطبيقات الموبايل.",
            "exp_desc_depi" to "تطوير تطبيقات Android متقدمة باستخدام Kotlin وJetpack Compose.\nإظهار الكفاءة في أطر عمل Android وتطبيق أفضل ممارسات التطوير،\nمع تطبيق الكود النظيف والمعمارية النظيفة.",
            "exp_desc_chance" to "تدريب مكثف في أطر عمل Android مثل Kotlin وXML وJetpack Compose وCMP.\nبناء مشاريع Android من الصفر باستخدام تقنيات مختلفة في العملية.",

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
            "about_me_text" to "مرحباً، أنا عبدالرحمن عبدالوهاب مطور تطبيقات محمولة أؤمن بأن التطبيقات الرائعة تُبنى عند تقاطع الدقة الهندسية والتصميم الإبداعي. بخلفية في هندسة الحاسوب، أقدم منهجاً قوياً في حل المشكلات لتطوير تطبيقات الهاتف المحمول يتجاوز مجرد كتابة الكود.\n\nمتخصص في Android (Kotlin، Jetpack Compose) و Flutter، أصمم تطبيقات جاهزة للإنتاج تخدم مستخدمين حقيقيين عبر قطاعات الرعاية الصحية، التجارة الإلكترونية، ونمط الحياة. أنا شغوف بالبنية المعمارية النظيفة، الكود القابل للصيانة، وبناء تطبيقات لا تعمل بشكل لا تشوبه شائبة فحسب، بل تُسعد المستخدمين أيضاً بواجهات بديهية ومتجاوبة.\n\nسواء كان الأمر يتعلق بتصميم حلول محمولة قابلة للتوسع، دمج أنظمة الواجهة الخلفية المعقدة (Firebase، Supabase، GraphQL)، أو تصميم واجهات مستخدم مثالية، أتعامل مع كل مرحلة من مراحل التطوير من المفهوم الأولي إلى النشر على متجر التطبيقات. أقدر التواصل الشفاف وأعامل كل مشروع كشراكة، لضمان أننا متوافقون من البداية إلى النهاية.\n\nحالياً، أعمل كمطور محمول مستقل، أوسع مهاراتي باستمرار في Kotlin Multiplatform وممارسات التطوير الحديثة. دعونا نبني شيئاً استثنائياً معاً."
        )
    )

    fun get(key: String, language: Language): String {
        return translations[language]?.get(key) ?: key
    }
}
