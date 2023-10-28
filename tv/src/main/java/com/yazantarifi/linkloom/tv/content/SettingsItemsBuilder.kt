package com.yazantarifi.linkloom.tv.content

import android.content.Context
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.models.SettingsItem

object SettingsItemsBuilder {

    fun getItems(context: Context): List<SettingsItem> {
        return arrayListOf(
            SettingsItem("accounts", context.getString(R.string.accounts)),
            SettingsItem("privacy", context.getString(R.string.pp)),
            SettingsItem("terms", context.getString(R.string.tc)),
            SettingsItem("about", context.getString(R.string.about)),
            SettingsItem("report", context.getString(R.string.report)),
            SettingsItem("request", context.getString(R.string.request)),
            SettingsItem("", ""),
        )
    }

    fun getTermsAndConditions(): String {
        return "<html lang=\"en\"><head>\n" +
                "<title>Terms and Conditions for Link Loom - FreePrivacyPolicy.com</title>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"/public/livelink/css/livelink.css\">\n" +
                "<meta name=\"robots\" content=\"noindex\">\n" +
                "<meta property=\"og:title\" content=\"Terms and Conditions for Link Loom - FreePrivacyPolicy.com\">\n" +
                "<meta property=\"og:image\" content=\"https://www.freeprivacypolicy.com/public/images/meta_og_image_livelink.png\">\n" +
                "<meta property=\"og:image:width\" content=\"1280\">\n" +
                "<meta property=\"og:image:height\" content=\"720\">\n" +
                "<meta property=\"og:url\" content=\"https://www.freeprivacypolicy.com/live/6592d7cc-8499-4af1-86da-974b9c10fcd2\">\n" +
                "<meta property=\"og:site_name\" content=\"FreePrivacyPolicy.com\">\n" +
                "<link rel=\"canonical\" href=\"https://www.freeprivacypolicy.com/live/6592d7cc-8499-4af1-86da-974b9c10fcd2\">\n" +
                "<script async=\"\" src=\"https://www.googletagmanager.com/gtag/js?id=G-QSMNQ8CKJG\"></script>\n" +
                "<script>\n" +
                "    window.dataLayer = window.dataLayer || [];\n" +
                "    function gtag(){dataLayer.push(arguments);}\n" +
                "    gtag('js', new Date());\n" +
                "    gtag('config', 'G-QSMNQ8CKJG');\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"page\">\n" +
                "<div class=\"header\">\n" +
                "<div class=\"container\">\n" +
                "<p class=\"title\">Terms and Conditions for Link Loom</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"translations-content-container\">\n" +
                "<div class=\"container\">\n" +
                "<div class=\"tab-content translations-content-item en visible\" id=\"en\">\n" +
                "<h2>Terms and Conditions</h2>\n" +
                "<p>Last updated: October 27, 2023</p>\n" +
                "<p>Please read these terms and conditions carefully before using Our Service.</p>\n" +
                "<h2>Interpretation and Definitions</h2>\n" +
                "<h3>Interpretation</h3>\n" +
                "<p>The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.</p>\n" +
                "<h3>Definitions</h3>\n" +
                "<p>For the purposes of these Terms and Conditions:</p>\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><strong>Application</strong> means the software program provided by the Company downloaded by You on any electronic device, named Link Loom</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Application Store</strong> means the digital distribution service operated and developed by Apple Inc. (Apple App Store) or Google Inc. (Google Play Store) in which the Application has been downloaded.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Affiliate</strong> means an entity that controls, is controlled by or is under common control with a party, where \"control\" means ownership of 50% or more of the shares, equity interest or other securities entitled to vote for election of directors or other managing authority.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Country</strong> refers to: Localhost</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Company</strong> (referred to as either \"the Company\", \"We\", \"Us\" or \"Our\" in this Agreement) refers to Link Loom.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Device</strong> means any device that can access the Service such as a computer, a cellphone or a digital tablet.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Service</strong> refers to the Application.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Terms and Conditions</strong> (also referred as \"Terms\") mean these Terms and Conditions that form the entire agreement between You and the Company regarding the use of the Service. This Terms and Conditions agreement has been created with the help of the <a href=\"https://www.freeprivacypolicy.com/free-terms-and-conditions-generator/\" target=\"_blank\">Free Terms and Conditions Generator</a>.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Third-party Social Media Service</strong> means any services or content (including data, information, products or services) provided by a third-party that may be displayed, included or made available by the Service.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>You</strong> means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "<h2>Acknowledgment</h2>\n" +
                "<p>These are the Terms and Conditions governing the use of this Service and the agreement that operates between You and the Company. These Terms and Conditions set out the rights and obligations of all users regarding the use of the Service.</p>\n" +
                "<p>Your access to and use of the Service is conditioned on Your acceptance of and compliance with these Terms and Conditions. These Terms and Conditions apply to all visitors, users and others who access or use the Service.</p>\n" +
                "<p>By accessing or using the Service You agree to be bound by these Terms and Conditions. If You disagree with any part of these Terms and Conditions then You may not access the Service.</p>\n" +
                "<p>You represent that you are over the age of 18. The Company does not permit those under 18 to use the Service.</p>\n" +
                "<p>Your access to and use of the Service is also conditioned on Your acceptance of and compliance with the Privacy Policy of the Company. Our Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your personal information when You use the Application or the Website and tells You about Your privacy rights and how the law protects You. Please read Our Privacy Policy carefully before using Our Service.</p>\n" +
                "<h2>Links to Other Websites</h2>\n" +
                "<p>Our Service may contain links to third-party web sites or services that are not owned or controlled by the Company.</p>\n" +
                "<p>The Company has no control over, and assumes no responsibility for, the content, privacy policies, or practices of any third party web sites or services. You further acknowledge and agree that the Company shall not be responsible or liable, directly or indirectly, for any damage or loss caused or alleged to be caused by or in connection with the use of or reliance on any such content, goods or services available on or through any such web sites or services.</p>\n" +
                "<p>We strongly advise You to read the terms and conditions and privacy policies of any third-party web sites or services that You visit.</p>\n" +
                "<h2>Termination</h2>\n" +
                "<p>We may terminate or suspend Your access immediately, without prior notice or liability, for any reason whatsoever, including without limitation if You breach these Terms and Conditions.</p>\n" +
                "<p>Upon termination, Your right to use the Service will cease immediately.</p>\n" +
                "<h2>Limitation of Liability</h2>\n" +
                "<p>Notwithstanding any damages that You might incur, the entire liability of the Company and any of its suppliers under any provision of this Terms and Your exclusive remedy for all of the foregoing shall be limited to the amount actually paid by You through the Service or 100 USD if You haven't purchased anything through the Service.</p>\n" +
                "<p>To the maximum extent permitted by applicable law, in no event shall the Company or its suppliers be liable for any special, incidental, indirect, or consequential damages whatsoever (including, but not limited to, damages for loss of profits, loss of data or other information, for business interruption, for personal injury, loss of privacy arising out of or in any way related to the use of or inability to use the Service, third-party software and/or third-party hardware used with the Service, or otherwise in connection with any provision of this Terms), even if the Company or any supplier has been advised of the possibility of such damages and even if the remedy fails of its essential purpose.</p>\n" +
                "<p>Some states do not allow the exclusion of implied warranties or limitation of liability for incidental or consequential damages, which means that some of the above limitations may not apply. In these states, each party's liability will be limited to the greatest extent permitted by law.</p>\n" +
                "<h2>\"AS IS\" and \"AS AVAILABLE\" Disclaimer</h2>\n" +
                "<p>The Service is provided to You \"AS IS\" and \"AS AVAILABLE\" and with all faults and defects without warranty of any kind. To the maximum extent permitted under applicable law, the Company, on its own behalf and on behalf of its Affiliates and its and their respective licensors and service providers, expressly disclaims all warranties, whether express, implied, statutory or otherwise, with respect to the Service, including all implied warranties of merchantability, fitness for a particular purpose, title and non-infringement, and warranties that may arise out of course of dealing, course of performance, usage or trade practice. Without limitation to the foregoing, the Company provides no warranty or undertaking, and makes no representation of any kind that the Service will meet Your requirements, achieve any intended results, be compatible or work with any other software, applications, systems or services, operate without interruption, meet any performance or reliability standards or be error free or that any errors or defects can or will be corrected.</p>\n" +
                "<p>Without limiting the foregoing, neither the Company nor any of the company's provider makes any representation or warranty of any kind, express or implied: (i) as to the operation or availability of the Service, or the information, content, and materials or products included thereon; (ii) that the Service will be uninterrupted or error-free; (iii) as to the accuracy, reliability, or currency of any information or content provided through the Service; or (iv) that the Service, its servers, the content, or e-mails sent from or on behalf of the Company are free of viruses, scripts, trojan horses, worms, malware, timebombs or other harmful components.</p>\n" +
                "<p>Some jurisdictions do not allow the exclusion of certain types of warranties or limitations on applicable statutory rights of a consumer, so some or all of the above exclusions and limitations may not apply to You. But in such a case the exclusions and limitations set forth in this section shall be applied to the greatest extent enforceable under applicable law.</p>\n" +
                "<h2>Governing Law</h2>\n" +
                "<p>The laws of the Country, excluding its conflicts of law rules, shall govern this Terms and Your use of the Service. Your use of the Application may also be subject to other local, state, national, or international laws.</p>\n" +
                "<h2>Disputes Resolution</h2>\n" +
                "<p>If You have any concern or dispute about the Service, You agree to first try to resolve the dispute informally by contacting the Company.</p>\n" +
                "<h2>For European Union (EU) Users</h2>\n" +
                "<p>If You are a European Union consumer, you will benefit from any mandatory provisions of the law of the country in which you are resident in.</p>\n" +
                "<h2>United States Legal Compliance</h2>\n" +
                "<p>You represent and warrant that (i) You are not located in a country that is subject to the United States government embargo, or that has been designated by the United States government as a \"terrorist supporting\" country, and (ii) You are not listed on any United States government list of prohibited or restricted parties.</p>\n" +
                "<h2>Severability and Waiver</h2>\n" +
                "<h3>Severability</h3>\n" +
                "<p>If any provision of these Terms is held to be unenforceable or invalid, such provision will be changed and interpreted to accomplish the objectives of such provision to the greatest extent possible under applicable law and the remaining provisions will continue in full force and effect.</p>\n" +
                "<h3>Waiver</h3>\n" +
                "<p>Except as provided herein, the failure to exercise a right or to require performance of an obligation under these Terms shall not effect a party's ability to exercise such right or require such performance at any time thereafter nor shall the waiver of a breach constitute a waiver of any subsequent breach.</p>\n" +
                "<h2>Translation Interpretation</h2>\n" +
                "<p>These Terms and Conditions may have been translated if We have made them available to You on our Service.\n" +
                "You agree that the original English text shall prevail in the case of a dispute.</p>\n" +
                "<h2>Changes to These Terms and Conditions</h2>\n" +
                "<p>We reserve the right, at Our sole discretion, to modify or replace these Terms at any time. If a revision is material We will make reasonable efforts to provide at least 30 days' notice prior to any new terms taking effect. What constitutes a material change will be determined at Our sole discretion.</p>\n" +
                "<p>By continuing to access or use Our Service after those revisions become effective, You agree to be bound by the revised terms. If You do not agree to the new terms, in whole or in part, please stop using the website and the Service.</p>\n" +
                "<h2>Contact Us</h2>\n" +
                "<p>If you have any questions about these Terms and Conditions, You can contact us:</p>\n" +
                "<ul>\n" +
                "<li>By visiting this page on our website: <a href=\"https://github.com/Yazan98/LinkLoomTv\" rel=\"external nofollow noopener\" target=\"_blank\">https://github.com/Yazan98/LinkLoomTv</a></li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"footer\">\n" +
                "<div class=\"container\">\n" +
                "<p>Generated using <a href=\"https://www.freeprivacypolicy.com/free-privacy-policy-generator/\" target=\"_blank\">Free Privacy Policy Generator</a></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<script type=\"text/javascript\">\n" +
                "    const tabLinks = Array.from(document.querySelectorAll(\".tab-link\"));\n" +
                "    const tabContents = document.querySelectorAll(\".tab-content\");\n" +
                "    \n" +
                "    tabLinks.forEach(function(tabLink) {\n" +
                "        tabLink.addEventListener(\"click\", toggleTab);\n" +
                "    });\n" +
                "    \n" +
                "    let priorActiveTab = null;\n" +
                "    \n" +
                "    function toggleTab(event) {\n" +
                "        tabLinks.forEach(function(tabLink, index){\n" +
                "            tabLink.classList.remove(\"active\");\n" +
                "            tabLink.classList.add(\"inactive\");\n" +
                "        \n" +
                "            tabContents[index].classList.remove(\"visible\");\n" +
                "            tabContents[index].classList.add(\"hidden\");\n" +
                "        });\n" +
                "\n" +
                "        if(priorActiveTab === this) {\n" +
                "            this.classList.remove(\"active\");\n" +
                "            this.classList.add(\"inactive\");\n" +
                "\n" +
                "            tabContents[tabLinks.indexOf(this)].classList.remove(\"visible\");\n" +
                "            tabContents[tabLinks.indexOf(this)].classList.add(\"hidden\");\n" +
                "\n" +
                "            priorActiveTab = null;\n" +
                "        } else {\n" +
                "            this.classList.remove(\"inactive\");\n" +
                "            this.classList.add(\"active\");\n" +
                "        \n" +
                "            tabContents[tabLinks.indexOf(this)].classList.remove(\"hidden\");\n" +
                "            tabContents[tabLinks.indexOf(this)].classList.add(\"visible\");\n" +
                "        \n" +
                "            priorActiveTab = this;\n" +
                "        }\n" +
                "        \n" +
                "        if (priorActiveTab === null) {\n" +
                "            this.classList.remove(\"inactive\");\n" +
                "            this.classList.add(\"active\");\n" +
                "        \n" +
                "            tabContents[tabLinks.indexOf(this)].classList.remove(\"hidden\");\n" +
                "            tabContents[tabLinks.indexOf(this)].classList.add(\"visible\");\n" +
                "        }\n" +
                "      \n" +
                "        event.preventDefault();\n" +
                "    }\n" +
                "</script>\n" +
                "<script defer=\"\" data-domain=\"freeprivacypolicy-livelink--production\" data-api=\"/plausible/event\" src=\"/plausible/script.js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "    \"use strict\";\n" +
                "    window.LCG_TRACKING_APPLICATION = \"freeprivacypolicy-livelink\";\n" +
                "    window.LCG_TRACKING_ENVIRONMENT = \"production\";\n" +
                "    window.LCG_TRACKING_EPOCH = \"2020-e01\";\n" +
                "</script>\n" +
                "<script src=\"/track/v1/r/js-code\" type=\"text/javascript\" async=\"true\"></script>\n" +
                "<script src=\"/track/v1/r/js-data\" type=\"text/javascript\" async=\"true\"></script>\n" +
                "<img src=\"/track/v1/px\" style=\"position:fixed;right:0px;bottom:0px;display:none;\">\n" +
                "<script defer=\"\" src=\"https://static.cloudflareinsights.com/beacon.min.js/v84a3a4012de94ce1a686ba8c167c359c1696973893317\" integrity=\"sha512-euoFGowhlaLqXsPWQ48qSkBSCFs3DPRyiwVu3FjR96cMPx+Fr+gpWRhIafcHwqwCqWS42RZhIudOvEI+Ckf6MA==\" data-cf-beacon=\"{&quot;rayId&quot;:&quot;81ced8cffed2bbaf&quot;,&quot;version&quot;:&quot;2023.10.0&quot;,&quot;token&quot;:&quot;dd281d4ac6a447be928fcee1746ec801&quot;}\" crossorigin=\"anonymous\"></script>\n" +
                "\n" +
                "</body></html>"
    }

    fun getPrivacyPolicy(): String {
        return "<html lang=\"en\"><head>\n" +
                "<title>Privacy Policy for Link Loom - FreePrivacyPolicy.com</title>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"/public/livelink/css/livelink.css\">\n" +
                "<meta name=\"robots\" content=\"noindex\">\n" +
                "<meta property=\"og:title\" content=\"Privacy Policy for Link Loom - FreePrivacyPolicy.com\">\n" +
                "<meta property=\"og:image\" content=\"https://www.freeprivacypolicy.com/public/images/meta_og_image_livelink.png\">\n" +
                "<meta property=\"og:image:width\" content=\"1280\">\n" +
                "<meta property=\"og:image:height\" content=\"720\">\n" +
                "<meta property=\"og:url\" content=\"https://www.freeprivacypolicy.com/live/7ddb00d1-4294-49fe-99b7-900ed74d5491\">\n" +
                "<meta property=\"og:site_name\" content=\"FreePrivacyPolicy.com\">\n" +
                "<link rel=\"canonical\" href=\"https://www.freeprivacypolicy.com/live/7ddb00d1-4294-49fe-99b7-900ed74d5491\">\n" +
                "<script async=\"\" src=\"https://www.googletagmanager.com/gtag/js?id=G-QSMNQ8CKJG\"></script>\n" +
                "<script>\n" +
                "    window.dataLayer = window.dataLayer || [];\n" +
                "    function gtag(){dataLayer.push(arguments);}\n" +
                "    gtag('js', new Date());\n" +
                "    gtag('config', 'G-QSMNQ8CKJG');\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"page\">\n" +
                "<div class=\"header\">\n" +
                "<div class=\"container\">\n" +
                "<p class=\"title\">Privacy Policy for Link Loom</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"translations-content-container\">\n" +
                "<div class=\"container\">\n" +
                "<div class=\"tab-content translations-content-item en visible\" id=\"en\">\n" +
                "<h1>Privacy Policy</h1>\n" +
                "<p>Last updated: October 27, 2023</p>\n" +
                "<p>This Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your information when You use the Service and tells You about Your privacy rights and how the law protects You.</p>\n" +
                "<p>We use Your Personal data to provide and improve the Service. By using the Service, You agree to the collection and use of information in accordance with this Privacy Policy. This Privacy Policy has been created with the help of the <a href=\"https://www.freeprivacypolicy.com/free-privacy-policy-generator/\" target=\"_blank\">Free Privacy Policy Generator</a>.</p>\n" +
                "<h2>Interpretation and Definitions</h2>\n" +
                "<h3>Interpretation</h3>\n" +
                "<p>The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.</p>\n" +
                "<h3>Definitions</h3>\n" +
                "<p>For the purposes of this Privacy Policy:</p>\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><strong>Account</strong> means a unique account created for You to access our Service or parts of our Service.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Affiliate</strong> means an entity that controls, is controlled by or is under common control with a party, where \"control\" means ownership of 50% or more of the shares, equity interest or other securities entitled to vote for election of directors or other managing authority.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Application</strong> refers to Link Loom, the software program provided by the Company.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Company</strong> (referred to as either \"the Company\", \"We\", \"Us\" or \"Our\" in this Agreement) refers to Link Loom.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Country</strong> refers to: Localhost</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Device</strong> means any device that can access the Service such as a computer, a cellphone or a digital tablet.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Personal Data</strong> is any information that relates to an identified or identifiable individual.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Service</strong> refers to the Application.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Service Provider</strong> means any natural or legal person who processes the data on behalf of the Company. It refers to third-party companies or individuals employed by the Company to facilitate the Service, to provide the Service on behalf of the Company, to perform services related to the Service or to assist the Company in analyzing how the Service is used.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>Usage Data</strong> refers to data collected automatically, either generated by the use of the Service or from the Service infrastructure itself (for example, the duration of a page visit).</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>You</strong> means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "<h2>Collecting and Using Your Personal Data</h2>\n" +
                "<h3>Types of Data Collected</h3>\n" +
                "<h4>Personal Data</h4>\n" +
                "<p>While using Our Service, We may ask You to provide Us with certain personally identifiable information that can be used to contact or identify You. Personally identifiable information may include, but is not limited to:</p>\n" +
                "<ul>\n" +
                "<li>Usage Data</li>\n" +
                "</ul>\n" +
                "<h4>Usage Data</h4>\n" +
                "<p>Usage Data is collected automatically when using the Service.</p>\n" +
                "<p>Usage Data may include information such as Your Device's Internet Protocol address (e.g. IP address), browser type, browser version, the pages of our Service that You visit, the time and date of Your visit, the time spent on those pages, unique device identifiers and other diagnostic data.</p>\n" +
                "<p>When You access the Service by or through a mobile device, We may collect certain information automatically, including, but not limited to, the type of mobile device You use, Your mobile device unique ID, the IP address of Your mobile device, Your mobile operating system, the type of mobile Internet browser You use, unique device identifiers and other diagnostic data.</p>\n" +
                "<p>We may also collect information that Your browser sends whenever You visit our Service or when You access the Service by or through a mobile device.</p>\n" +
                "<h3>Use of Your Personal Data</h3>\n" +
                "<p>The Company may use Personal Data for the following purposes:</p>\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><strong>To provide and maintain our Service</strong>, including to monitor the usage of our Service.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>To manage Your Account:</strong> to manage Your registration as a user of the Service. The Personal Data You provide can give You access to different functionalities of the Service that are available to You as a registered user.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>For the performance of a contract:</strong> the development, compliance and undertaking of the purchase contract for the products, items or services You have purchased or of any other contract with Us through the Service.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>To contact You:</strong> To contact You by email, telephone calls, SMS, or other equivalent forms of electronic communication, such as a mobile application's push notifications regarding updates or informative communications related to the functionalities, products or contracted services, including the security updates, when necessary or reasonable for their implementation.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>To provide You</strong> with news, special offers and general information about other goods, services and events which we offer that are similar to those that you have already purchased or enquired about unless You have opted not to receive such information.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>To manage Your requests:</strong> To attend and manage Your requests to Us.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>For business transfers:</strong> We may use Your information to evaluate or conduct a merger, divestiture, restructuring, reorganization, dissolution, or other sale or transfer of some or all of Our assets, whether as a going concern or as part of bankruptcy, liquidation, or similar proceeding, in which Personal Data held by Us about our Service users is among the assets transferred.</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><strong>For other purposes</strong>: We may use Your information for other purposes, such as data analysis, identifying usage trends, determining the effectiveness of our promotional campaigns and to evaluate and improve our Service, products, services, marketing and your experience.</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "<p>We may share Your personal information in the following situations:</p>\n" +
                "<ul>\n" +
                "<li><strong>With Service Providers:</strong> We may share Your personal information with Service Providers to monitor and analyze the use of our Service, to contact You.</li>\n" +
                "<li><strong>For business transfers:</strong> We may share or transfer Your personal information in connection with, or during negotiations of, any merger, sale of Company assets, financing, or acquisition of all or a portion of Our business to another company.</li>\n" +
                "<li><strong>With Affiliates:</strong> We may share Your information with Our affiliates, in which case we will require those affiliates to honor this Privacy Policy. Affiliates include Our parent company and any other subsidiaries, joint venture partners or other companies that We control or that are under common control with Us.</li>\n" +
                "<li><strong>With business partners:</strong> We may share Your information with Our business partners to offer You certain products, services or promotions.</li>\n" +
                "<li><strong>With other users:</strong> when You share personal information or otherwise interact in the public areas with other users, such information may be viewed by all users and may be publicly distributed outside.</li>\n" +
                "<li><strong>With Your consent</strong>: We may disclose Your personal information for any other purpose with Your consent.</li>\n" +
                "</ul>\n" +
                "<h3>Retention of Your Personal Data</h3>\n" +
                "<p>The Company will retain Your Personal Data only for as long as is necessary for the purposes set out in this Privacy Policy. We will retain and use Your Personal Data to the extent necessary to comply with our legal obligations (for example, if we are required to retain your data to comply with applicable laws), resolve disputes, and enforce our legal agreements and policies.</p>\n" +
                "<p>The Company will also retain Usage Data for internal analysis purposes. Usage Data is generally retained for a shorter period of time, except when this data is used to strengthen the security or to improve the functionality of Our Service, or We are legally obligated to retain this data for longer time periods.</p>\n" +
                "<h3>Transfer of Your Personal Data</h3>\n" +
                "<p>Your information, including Personal Data, is processed at the Company's operating offices and in any other places where the parties involved in the processing are located. It means that this information may be transferred to — and maintained on — computers located outside of Your state, province, country or other governmental jurisdiction where the data protection laws may differ than those from Your jurisdiction.</p>\n" +
                "<p>Your consent to this Privacy Policy followed by Your submission of such information represents Your agreement to that transfer.</p>\n" +
                "<p>The Company will take all steps reasonably necessary to ensure that Your data is treated securely and in accordance with this Privacy Policy and no transfer of Your Personal Data will take place to an organization or a country unless there are adequate controls in place including the security of Your data and other personal information.</p>\n" +
                "<h3>Delete Your Personal Data</h3>\n" +
                "<p>You have the right to delete or request that We assist in deleting the Personal Data that We have collected about You.</p>\n" +
                "<p>Our Service may give You the ability to delete certain information about You from within the Service.</p>\n" +
                "<p>You may update, amend, or delete Your information at any time by signing in to Your Account, if you have one, and visiting the account settings section that allows you to manage Your personal information. You may also contact Us to request access to, correct, or delete any personal information that You have provided to Us.</p>\n" +
                "<p>Please note, however, that We may need to retain certain information when we have a legal obligation or lawful basis to do so.</p>\n" +
                "<h3>Disclosure of Your Personal Data</h3>\n" +
                "<h4>Business Transactions</h4>\n" +
                "<p>If the Company is involved in a merger, acquisition or asset sale, Your Personal Data may be transferred. We will provide notice before Your Personal Data is transferred and becomes subject to a different Privacy Policy.</p>\n" +
                "<h4>Law enforcement</h4>\n" +
                "<p>Under certain circumstances, the Company may be required to disclose Your Personal Data if required to do so by law or in response to valid requests by public authorities (e.g. a court or a government agency).</p>\n" +
                "<h4>Other legal requirements</h4>\n" +
                "<p>The Company may disclose Your Personal Data in the good faith belief that such action is necessary to:</p>\n" +
                "<ul>\n" +
                "<li>Comply with a legal obligation</li>\n" +
                "<li>Protect and defend the rights or property of the Company</li>\n" +
                "<li>Prevent or investigate possible wrongdoing in connection with the Service</li>\n" +
                "<li>Protect the personal safety of Users of the Service or the public</li>\n" +
                "<li>Protect against legal liability</li>\n" +
                "</ul>\n" +
                "<h3>Security of Your Personal Data</h3>\n" +
                "<p>The security of Your Personal Data is important to Us, but remember that no method of transmission over the Internet, or method of electronic storage is 100% secure. While We strive to use commercially acceptable means to protect Your Personal Data, We cannot guarantee its absolute security.</p>\n" +
                "<h2>Children's Privacy</h2>\n" +
                "<p>Our Service does not address anyone under the age of 13. We do not knowingly collect personally identifiable information from anyone under the age of 13. If You are a parent or guardian and You are aware that Your child has provided Us with Personal Data, please contact Us. If We become aware that We have collected Personal Data from anyone under the age of 13 without verification of parental consent, We take steps to remove that information from Our servers.</p>\n" +
                "<p>If We need to rely on consent as a legal basis for processing Your information and Your country requires consent from a parent, We may require Your parent's consent before We collect and use that information.</p>\n" +
                "<h2>Links to Other Websites</h2>\n" +
                "<p>Our Service may contain links to other websites that are not operated by Us. If You click on a third party link, You will be directed to that third party's site. We strongly advise You to review the Privacy Policy of every site You visit.</p>\n" +
                "<p>We have no control over and assume no responsibility for the content, privacy policies or practices of any third party sites or services.</p>\n" +
                "<h2>Changes to this Privacy Policy</h2>\n" +
                "<p>We may update Our Privacy Policy from time to time. We will notify You of any changes by posting the new Privacy Policy on this page.</p>\n" +
                "<p>We will let You know via email and/or a prominent notice on Our Service, prior to the change becoming effective and update the \"Last updated\" date at the top of this Privacy Policy.</p>\n" +
                "<p>You are advised to review this Privacy Policy periodically for any changes. Changes to this Privacy Policy are effective when they are posted on this page.</p>\n" +
                "<h2>Contact Us</h2>\n" +
                "<p>If you have any questions about this Privacy Policy, You can contact us:</p>\n" +
                "<ul>\n" +
                "<li>By visiting this page on our website: <a href=\"https://github.com/Yazan98/LinkLoomTv\" rel=\"external nofollow noopener\" target=\"_blank\">https://github.com/Yazan98/LinkLoomTv</a></li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"footer\">\n" +
                "<div class=\"container\">\n" +
                "<p>Generated using <a href=\"https://www.freeprivacypolicy.com/free-privacy-policy-generator/\" target=\"_blank\">Free Privacy Policy Generator</a></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<script type=\"text/javascript\">\n" +
                "    const tabLinks = Array.from(document.querySelectorAll(\".tab-link\"));\n" +
                "    const tabContents = document.querySelectorAll(\".tab-content\");\n" +
                "    \n" +
                "    tabLinks.forEach(function(tabLink) {\n" +
                "        tabLink.addEventListener(\"click\", toggleTab);\n" +
                "    });\n" +
                "    \n" +
                "    let priorActiveTab = null;\n" +
                "    \n" +
                "    function toggleTab(event) {\n" +
                "        tabLinks.forEach(function(tabLink, index){\n" +
                "            tabLink.classList.remove(\"active\");\n" +
                "            tabLink.classList.add(\"inactive\");\n" +
                "        \n" +
                "            tabContents[index].classList.remove(\"visible\");\n" +
                "            tabContents[index].classList.add(\"hidden\");\n" +
                "        });\n" +
                "\n" +
                "        if(priorActiveTab === this) {\n" +
                "            this.classList.remove(\"active\");\n" +
                "            this.classList.add(\"inactive\");\n" +
                "\n" +
                "            tabContents[tabLinks.indexOf(this)].classList.remove(\"visible\");\n" +
                "            tabContents[tabLinks.indexOf(this)].classList.add(\"hidden\");\n" +
                "\n" +
                "            priorActiveTab = null;\n" +
                "        } else {\n" +
                "            this.classList.remove(\"inactive\");\n" +
                "            this.classList.add(\"active\");\n" +
                "        \n" +
                "            tabContents[tabLinks.indexOf(this)].classList.remove(\"hidden\");\n" +
                "            tabContents[tabLinks.indexOf(this)].classList.add(\"visible\");\n" +
                "        \n" +
                "            priorActiveTab = this;\n" +
                "        }\n" +
                "        \n" +
                "        if (priorActiveTab === null) {\n" +
                "            this.classList.remove(\"inactive\");\n" +
                "            this.classList.add(\"active\");\n" +
                "        \n" +
                "            tabContents[tabLinks.indexOf(this)].classList.remove(\"hidden\");\n" +
                "            tabContents[tabLinks.indexOf(this)].classList.add(\"visible\");\n" +
                "        }\n" +
                "      \n" +
                "        event.preventDefault();\n" +
                "    }\n" +
                "</script>\n" +
                "<script defer=\"\" data-domain=\"freeprivacypolicy-livelink--production\" data-api=\"/plausible/event\" src=\"/plausible/script.js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "    \"use strict\";\n" +
                "    window.LCG_TRACKING_APPLICATION = \"freeprivacypolicy-livelink\";\n" +
                "    window.LCG_TRACKING_ENVIRONMENT = \"production\";\n" +
                "    window.LCG_TRACKING_EPOCH = \"2020-e01\";\n" +
                "</script>\n" +
                "<script src=\"/track/v1/r/js-code\" type=\"text/javascript\" async=\"true\"></script>\n" +
                "<script src=\"/track/v1/r/js-data\" type=\"text/javascript\" async=\"true\"></script>\n" +
                "<img src=\"/track/v1/px\" style=\"position:fixed;right:0px;bottom:0px;display:none;\">\n" +
                "<script defer=\"\" src=\"https://static.cloudflareinsights.com/beacon.min.js/v84a3a4012de94ce1a686ba8c167c359c1696973893317\" integrity=\"sha512-euoFGowhlaLqXsPWQ48qSkBSCFs3DPRyiwVu3FjR96cMPx+Fr+gpWRhIafcHwqwCqWS42RZhIudOvEI+Ckf6MA==\" data-cf-beacon=\"{&quot;rayId&quot;:&quot;81cedd690fdd5b92&quot;,&quot;version&quot;:&quot;2023.10.0&quot;,&quot;token&quot;:&quot;dd281d4ac6a447be928fcee1746ec801&quot;}\" crossorigin=\"anonymous\"></script>\n" +
                "\n" +
                "</body></html>"
    }

}
