package com.example

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class EssayQuestion(
    val id: String,
    val subject: String,
    val categoryNumber: Int, // 1 to 10
    val questionNumber: Int, // 1 to 10 (Total 100 per subject)
    val lessonName: String,  // Separate lesson name
    val title: String,
    val questionText: String,
    val markingScheme: List<String>,
    val modelAnswer: String
)

object ComprehensiveEssayDataBank {
    val subjects = listOf(
        "විද්‍යාව (Science)",
        "ගණිතය (Mathematics)",
        "ඉතිහාසය (History)",
        "බුද්ධ ධර්මය (Buddhism)",
        "සිංහල (Sinhala)",
        "ඉංග්‍රීසි (English)",
        "සෞඛ්‍ය (Health)",
        "කෘෂිකර්මය (Agriculture)",
        "ව්‍යාපාර අධ්‍යනය (Commerce)",
        "භූගෝලය (Geography)",
        "පුරවැසි අධ්‍යාපනය (Civics)",
        "ICT (Information Tech)"
    )

    private val scienceTopics = listOf(
        "ජීවීන්ගේ විවිධත්වය හා සෛල ව්‍යුහය",
        "පදාර්ථයේ ව්‍යුහය හා පරමාණුක ආකෘති",
        "බලය, චලිතය හා නිව්ටන් නියම",
        "ශාක හා සත්ත්ව පටක වර්ග",
        "ආලෝකය (පරාවර්තනය, වර්තනය හා කාච)",
        "රසායනික බන්ධන හා මවුල සංකල්පය",
        "ප්‍රභාසංශ්ලේෂණය සහ ශාක පෝෂණය",
        "ධාරා විද්‍යුතය සහ ඕම්ගේ නියමය",
        "මිනිසාගේ ශරීර පද්ධති (ශ්වසන, රුධිර සංසරණ)",
        "පරිසරය, බලශක්තිය හා තිරසාර සංවර්ධනය"
    )

    private val mathsTopics = listOf(
        "භාග, දශම හා ප්‍රතිශත ගැටලු",
        "බීජීය ප්‍රකාශන ප්‍රසාරණය හා සාධක",
        "රේඛීය සමීකරණ හා සමගාමී සමීකරණ",
        "පරිමිතිය, වර්ගඵලය සහ ජ්‍යාමිතික මිනුම්",
        "දර්ශක හා ලඝුගණක නීති",
        "වර්ගජ සමීකරණ විසඳීම",
        "ත්‍රිකෝණමිතිය (උන්නතාංශ හා අවනතාංශ කෝණ)",
        "වෘත්ත ප්‍රමේය හා ජ්‍යාමිතික කෝණ",
        "සංඛ්‍යානය (මධ්‍යන්‍යය, මාතය, මධ්‍යස්ථය)",
        "සම්භාවිතාව හා කුලක සංකල්ප"
    )

    private val historyTopics = listOf(
        "ඉතිහාසය හැදෑරීමේ පුරාවිද්‍යා හා සාහිත්‍ය මූලාශ්‍ර",
        "ශ්‍රී ලංකාවේ ප්‍රාග් ඓතිහාසික මානව ජනාවාස",
        "අනුරාධපුර රාජධානියේ වාරි තාක්ෂණය හා වැව් පද්ධති",
        "බුදුදහම මෙරටට පැමිණීම හා සංස්කෘතික පිබිදීම",
        "දුටුගැමුණු, වළගම්බා හා ධාතුසේන රජවරුන්ගේ සේවය",
        "පොළොන්නරු යුගයේ මහා පරාක්‍රමබාහු රාජ්‍ය සමය",
        "දඹදෙණිය, යාපහුව සහ ගම්පොළ රාජධානි",
        "කෝට්ටේ යුගයේ සාහිත්‍ය හා විදේශීය ආගමනය",
        "උඩරට රාජධානිය සහ 1815 උඩරට ගිවිසුම",
        "1818 සහ 1848 නිදහස් සටන් හා ජාතික පුනරුදය"
    )

    private val buddhismTopics = listOf(
        "සිද්ධාර්ථ කුමරුගේ උපත සහ බෝධිසත්ව චරිතය",
        "බුද්ධත්වයට පත්වීම සහ මජ්ඣිම පටිපදා (මධ්‍යම ප්‍රතිපදාව)",
        "බුදුරජාණන් වහන්සේගේ ධර්ම දේශනා ක්‍රමවේදය",
        "ආර්ය අෂ්ටාංගික මාර්ගය සහ චතුරාර්ය සත්‍යය",
        "ත්‍රිපිටක සාහිත්‍යය සහ බෞද්ධ සංස්කෘතිය",
        "පංච ශීලය සහ බෞද්ධ සමාජ ආචාරධර්ම",
        "බෞද්ධ භාවනා ක්‍රම (සමථ හා විපස්සනා)",
        "ධම්මපදය හා බෞද්ධ ජීවන දර්ශනය",
        "ලෝකයේ පහළ වූ ශ්‍රේෂ්ඨ ශාස්තෘවරුන්ගේ ඉගැන්වීම්",
        "බුදුරජාණන් වහන්සේගේ සමාජ හා ආර්ථික අනුශාසනා"
    )

    private val sinhalaTopics = listOf(
        "සිංහල ව්‍යාකරණ (සන්ධි, සමාස සහ නාමපද)",
        "වාක්‍ය රචනය සහ වාක්‍ය විග්‍රහය",
        "පදගත අර්ථ සහ පරිකථා විමර්ශනය",
        "සන්දේශ කාව්‍ය සහ සාහිත්‍ය විචාරය",
        "කෙටිකතා හා නවකතා සාහිත්‍ය විශ්ලේෂණය",
        "නාට්‍ය හා පද්‍ය සාහිත්‍ය රසවින්දනය",
        "වාර්තා ලිවීම, රචනා හා සංක්ෂිප්ත ලිවීම",
        "භාෂා ශෛලිය හා ප්‍රකාශන ධාරිතාව",
        "ප්‍රශස්ත සිංහල ශබ්දකෝෂ හා වාක්‍ය රටා",
        "O/L විභාග සිංහල ප්‍රශ්න පත්‍ර ව්‍යුහය"
    )

    private val englishTopics = listOf(
        "English Tenses (Present, Past, Future Active & Passive)",
        "Active and Passive Voice Mastery",
        "Direct and Indirect Speech Conversion",
        "Reading Comprehension & Information Extraction",
        "Formal and Informal Letter Writing",
        "Essay and Paragraph Writing",
        "Conditional Sentences & Relative Clauses",
        "Prepositions and Conjunctions Usage",
        "Reported Speech & Dialogues",
        "O/L English Model Grammar Practice"
    )

    private val healthTopics = listOf(
        "ශාරීරික සෞඛ්‍යය සහ පෝෂණ මූලධර්ම",
        "මානසික සෞඛ්‍යය සහ ආතති කළමනාකරණය",
        "බෝවන සහ බෝනොවන රෝග (NCDs)",
        "ප්‍රජනක සෞඛ්‍යය සහ නව යොවුන් විය",
        "ප්‍රථමාධාර සහ හදිසි අනතුරු කළමනාකරණය",
        "මත්ද්‍රව්‍ය නිවාරණය සහ සෞඛ්‍ය සම්පන්න පුරුදු",
        "ක්‍රීඩා සෞඛ්‍යය සහ ශාරීරික යෝග්‍යතාවය",
        "පාරිසරික සෞඛ්‍යය සහ පවිත්‍රතාවය",
        "පවුල් සෞඛ්‍යය සහ මාතෘ සත්කාර",
        "ප්‍රජා සෞඛ්‍ය සේවා සහ ආරක්ෂාව"
    )

    private val agricultureTopics = listOf(
        "ශ්‍රී ලංකාවේ කෘෂිකාර්මික පසුබිම සහ වැදගත්කම",
        "පස් වර්ග, පස් සංරක්ෂණය සහ පෝෂක කළමනාකරණය",
        "බෝග වගා ක්‍රමවේද සහ නඩත්තුව",
        "වාරි තාක්ෂණය සහ ජල කළමනාකරණය",
        "පලිබෝධ සහ රෝග පාලන ක්‍රම",
        "ගෘහස්ථ හා වාණිජ උද්‍යාන වගාව",
        "සත්ත්ව පාලනය (කුකුළන්, ගවයන් සහ එළුවන්)",
        "කාබනික කෘෂිකර්මය සහ කොම්පෝස්ට් නිෂ්පාදනය",
        "කෘෂි ව්‍යවසායකත්වය සහ අස්වනු නෙළීමෙන් පසු තාක්ෂණය",
        "තිරසාර කෘෂිකාර්මික සංවර්ධනය"
    )

    private val commerceTopics = listOf(
        "ව්‍යාපාරයක මූලික සංකල්ප හා අරමුණු",
        "ව්‍යාපාරික පරිසරය හා ව්‍යාපාර වර්ගීකරණය",
        "ද්වි-නාම ක්‍රමය හා මූල්‍ය ගිණුම්කරණය",
        "ජර්නලය, ලෙජරය සහ ශේෂ පත්‍ර සකස් කිරීම",
        "බැංකු කටයුතු හා මූල්‍ය සේවා ආයතන",
        "අලෙවිකරණය (Marketing) සහ වෙළඳ දැන්වීම්",
        "මානව සම්පත් කළමනාකරණය",
        "ආනයන හා අපනයන වෙළඳ ක්‍රියාවලි",
        "මූල්‍ය ප්‍රකාශන (ලාභ අලාභ ගිණුම සහ ශේෂ පත්‍රය)",
        "ව්‍යාපාර සැලසුම්කරණය හා ව්‍යවසායකත්වය"
    )

    private val geographyTopics = listOf(
        "පෘථිවි ස්වරූපය සහ භූගෝලීය පිහිටීම",
        "වායුගෝලය සහ කාලගුණ විපර්යාස",
        "ජල සම්පත, ගංගා ද්‍රෝಣಿ සහ සාගර",
        "ශ්‍රී ලංකාවේ භූමිකම්පා, කඳු සහ භූ ලක්ෂණ",
        "ජනගහන ව්‍යාප්තිය සහ ජනවිකಾಸය",
        "කෘෂිකාර්මික හා කාර්මික කලාප",
        "ප්‍රවාහන හා සන්නිවේදන ජාල",
        "ස්වභාවික විපත් සහ කළමනාකරණය",
        "පරිසර පද්ධති සහ සංරක්ෂණය",
        "ශ්‍රී ලංකාවේ සහ ලෝකයේ ආර්ථික භූගෝල විද්‍යාව"
    )

    private val civicsTopics = listOf(
        "ප්‍රජාතන්ත්‍රවාදී පාලන ක්‍රමය හා මූලධර්ම",
        "ශ්‍රී ලංකා ආණ්ඩුක්‍රම ව්‍යවස්ථාව හා රාජ්‍ය බලය",
        "මූලික මිනිස් අයිතිවාසිකම් සහ නීතියේ ආධිපත්‍යය",
        "පළාත් පාලන ආයතන හා ප්‍රාදේශීය පරිපාලනය",
        "රාජ්‍ය මූල්‍ය කළමනාකරණය හා අයවැය ක්‍රියාවලිය",
        "ජාත්‍යන්තර සංවිධාන සහ එක්සත් ජාතීන්ගේ සංවිධානය",
        "පාරිභෝගික අයිතිවාසිකම් හා ආරක්ෂණය",
        "සාමකාමී සහජීවනය හා ගැටලු නිරාකරණය",
        "යහපාලනය, විනිවිදභාවය සහ වගවීම",
        "තිරසාර සංවර්ධනය හා පරිසර සංරක්ෂණය"
    )

    private val ictTopics = listOf(
        "පරිගණක පද්ධතියක මූලික අංග (CPU, Memory, Peripherals)",
        "ද්විමය අංක ක්‍රමය සහ දත්ත නිරූපණය",
        "තාර්කික ද්වාර (Logic Gates) සහ බූලීය වීජ ගණිතය",
        "මෙහෙයුම් පද්ධති (Operating Systems) සහ ගොනු කළමනාකරණය",
        "පැතුරුම්පත් මෘදුකාංග (Spreadsheets) සහ සූත්‍ර",
        "සම්බන්ධතා දත්ත සමුදා (Relational Databases & DBMS)",
        "පරිගණක ජාලකරණය (Networking & Topologies)",
        "HTML වෙබ් අඩවි නිර්මාණය",
        "ඇල්ගොරිතම සහ වැඩසටහන්කරණ මූලධර්ම",
        "තොරතුරු හා සන්නිවේදන තාක්ෂණයේ සදාචාරාත්මක භාවිතය"
    )

    fun getQuestionsForSubjectAndCategory(subject: String, category: Int): List<EssayQuestion> {
        val list = mutableListOf<EssayQuestion>()
        val topicList = when {
            subject.contains("විද්‍යාව") -> scienceTopics
            subject.contains("ගණිතය") -> mathsTopics
            subject.contains("ඉතිහාසය") -> historyTopics
            subject.contains("බුද්ධ ධර්මය") -> buddhismTopics
            subject.contains("සිංහල") -> sinhalaTopics
            subject.contains("ඉංග්‍රීසි") || subject.contains("English") -> englishTopics
            subject.contains("සෞඛ්‍ය") -> healthTopics
            subject.contains("කෘෂිකර්මය") -> agricultureTopics
            subject.contains("ව්‍යාපාර") || subject.contains("Commerce") -> commerceTopics
            subject.contains("භූගෝල") -> geographyTopics
            subject.contains("පුරවැසි") -> civicsTopics
            else -> ictTopics
        }
        val topicName = topicList.getOrElse(category - 1) { "O/L විභාග පුහුණු ඒකකය" }

        for (qNum in 1..10) {
            val globalIndex = (category - 1) * 10 + qNum
            val title = "ප්‍රශ්න අංක $globalIndex (කොටස $qNum)"
            
            val (qText, markingScheme, modelAnswer) = when {
                subject.contains("ඉතිහාසය") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L ඉතිහාසය විෂය නිර්දේශයට අනුව '$topicName' යන පාඩම් මාතෘකාවට අදාළව, ඓතිහාසික සාධක, මූලාශ්‍ර සහ සමාජ-දේශපාලන බලපෑම් විග්‍රහ කර සවිස්තරාත්මකව පිළිතුරු ලියන්න."
                    val ms = listOf(
                        "🟢 (i) ඓතිහාසික පසුබිම සහ මූලාශ්‍ර හැඳින්වීම - ලකුණු 03",
                        "🔵 (ii) ප්‍රධාන සිදුවීම්, පාලකයන් සහ සංස්කෘතික දායකත්වය විස්තර කිරීම - ලකුණු 03",
                        "🟠 (iii) සමාජීය හා ආර්ථික බලපෑම් ගැඹුරින් විශ්ලේෂණය කිරීම - ලකුණු 02",
                        "🟣 (iv) සමස්ත ඓතිහාසික යුගයේ වැදගත්කම සාරාංශ කිරීම - ලකුණු 02"
                    )
                    val ans = "✨ [ඉතිහාසය O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. ඓතිහාසික පසුබිම හා මූලාශ්‍ර:\n   • අදාළ යුගයට අදාළ පුරාවිද්‍යාත්මක සහ සාහිත්‍ය මූලාශ්‍ර (මහාවංශය, ශිලා ලිපි) පදනම් කරගනිමින් පසුබිම විස්තර කර ඇත.\n\n" +
                        "2. ප්‍රධාන සිදුවීම් හා පාලකයන්:\n   • රජවරුන්ගේ දේශපාලන ක්‍රියාමාර්ග, වාරි කර්මාන්ත සංවර්ධනය සහ ආගමික මෙහෙවර පැහැදිලි කර ඇත.\n\n" +
                        "3. සමාජ-ආර්ථික විග්‍රහය:\n   • ස්වයංපෝෂිත ගැමියාගේ ආර්ථික රටාව සහ අන්තර්ජාතික වෙළඳ සබඳතා සාකච්ඡා කර ඇත.\n\n" +
                        "4. නිගමනය:\n   • ශ්‍රී ලංකා ඉතිහාසයේ එම සංධිස්ථානය ජාතික අනන්‍යතාවයට දායක වූ ආකාරය නිගමනය කර ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("බුද්ධ ධර්මය") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L බුද්ධ ධර්මය විෂය නිර්දේශයට අනුව '$topicName' යන පාඩම් මාතෘකාවට අදාළ ධර්ම කරුණු, බෞද්ධ දර්ශනය සහ ප්‍රායෝගික ජීවන රටාව විස්තර කරන්න."
                    val ms = listOf(
                        "🟢 (i) මූලික ධර්ම කරුණු සහ සංකල්ප නිවැරදිව හඳුනාගැනීම - ලකුණු 03",
                        "🔵 (ii) බුදුරජාණන් වහන්සේගේ දේශනා හෝ ත්‍රිපිටක සාක්ෂි උපුටා දැක්වීම - ලකුණු 03",
                        "🟠 (iii) දිනපතා ජීවිතයට ධර්මය ගැළපෙන ආකාරය පැහැදිලි කිරීම - ලකුණු 02",
                        "🟣 (iv) බෞද්ධ ජීවන දර්ශනය මත පදනම් වූ නිගමනය - ලකුණු 02"
                    )
                    val ans = "✨ [බුද්ධ ධර්මය O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. මූලික ධර්ම සංකල්ප:\n   • '$topicName' යටතේ එන බෞද්ධ ඉගැන්වීම් සහ මූලධර්ම පැහැදිලි කර ඇත.\n\n" +
                        "2. ත්‍රිපිටක සාක්ෂි හා දේශනා:\n   • අදාළ සූත්‍ර දේශනා සහ ගාථා/ප්‍රකාශ උපුටා දක්වා අර්ථ නිරූපණය කර ඇත.\n\n" +
                        "3. ප්‍රායෝගික ජීවන යෙදුම:\n   • පංචශීලය, ආර්ය අෂ්ටාංගික මාර්ගය හෝ භාවනා ක්‍රම දෛනික ජීවිතයට යොදාගන්නා අයුරු විග්‍රහ කර ඇත.\n\n" +
                        "4. නිගමනය:\n   • සංවරශීලී හා සාමකාමී සමාජයක් ගොඩනැගීමට මෙහි ඇති වැදගත්කම දක්වා ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("සිංහල") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L සිංහල භාෂාව හා සාහිත්‍යය විෂය නිර්දේශයට අනුව '$topicName' පාඩම් මාතෘකාව යටතේ එන ව්‍යාකරණ, සාහිත්‍ය හෝ රචනා ගැටලුවට නිවැරදි පිළිතුර සපයන්න."
                    val ms = listOf(
                        "🟢 (i) භාෂා රීති, සන්ධි/සමාස හෝ සාහිත්‍ය සංකල්ප හඳුනාගැනීම - ලකුණු 03",
                        "🔵 (ii) උචිත පාරිභාෂික යෙදුම් සහ ව්‍යාකරණානුකූල නීති යෙදීම - ලකුණු 03",
                        "🟠 (iii) අර්ථ රසය සහ රචනා ශෛලිය මනාව ඉදිරිපත් කිරීම - ලකුණු 02",
                        "🟣 (iv) පිරිසිදු සිංහල අක්ෂර වින්‍යාසයෙන් යුත් නිගමනය - ලකුණු 02"
                    )
                    val ans = "✨ [සිංහල O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. භාෂා හා සාහිත්‍ය හැඳින්වීම:\n   • අදාළ සිංහල ව්‍යාකරණ නීතිය හෝ සාහිත්‍ය ග්‍රන්ථය පිළිබඳ විස්තර කර ඇත.\n\n" +
                        "2. පදගත අර්ථ හා විග්‍රහය:\n   • කාව්‍ය අංග, පද බෙදීම සහ අර්ථ නිරූපණය පියවරෙන් පියවර දක්වා ඇත.\n\n" +
                        "3. රසවින්දනය හා ශෛලිය:\n   • කතුවරයාගේ අදහස් සහ භාෂා හැසිරවීමේ කුසලතාව විශ්ලේෂණය කර ඇත.\n\n" +
                        "4. නිගමනය:\n   • සම්මත සිංහල ව්‍යාකරණ රීතිවලට අනුකූලව පිළිතුර සාරාංශ කර ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("ඉංග්‍රීසි") || subject.contains("English") -> {
                    val text = "Grade 10 & 11 O/L English Syllabus: '$topicName' (Part $qNum). Provide accurate grammar transformation, active/passive structure, or detailed writing response."
                    val ms = listOf(
                        "🟢 (i) Correct grammar rule identification and tense/voice structure - Marks 03",
                        "🔵 (ii) Accurate application of syntax and vocabulary - Marks 03",
                        "🟠 (iii) Logical sentence flow and paragraph coherence - Marks 02",
                        "🟣 (iv) Final polished answer with correct spelling and punctuation - Marks 02"
                    )
                    val ans = "✨ [English O/L Official Model Answer - Question No. $globalIndex]\n\n" +
                        "1. Grammar & Concept Overview:\n   • Applied correct rules related to '$topicName' with clear examples.\n\n" +
                        "2. Step-by-Step Execution:\n   • Transformed sentences or structured paragraphs following O/L evaluation standards.\n\n" +
                        "3. Contextual Usage:\n   • Ensured proper punctuation, active/passive voice, or direct/indirect speech conversion.\n\n" +
                        "4. Final Summary:\n   • Complete accurate output meeting all curriculum criteria."
                    Triple(text, ms, ans)
                }
                subject.contains("සෞඛ්‍ය") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය විෂය නිර්දේශයට අනුව '$topicName' පාඩම ආශ්‍රිතව සෞඛ්‍යාරක්ෂිත ක්‍රමවේද සහ මූලධර්ම විස්තර කරන්න."
                    val ms = listOf(
                        "🟢 (i) සෞඛ්‍ය සංකල්ප සහ පෝෂණ/රෝග මූලධර්ම හැඳින්වීම - ලකුණු 03",
                        "🔵 (ii) ප්‍රායෝගික සෞඛ්‍ය පුරුදු සහ නිවාරණ ක්‍රම විස්තර කිරීම - ලකුණු 03",
                        "🟠 (iii) මානසික හා ශාරීරික යෝග්‍යතාවය පවත්වා ගන්නා අයුරු - ලකුණු 02",
                        "🟣 (iv) සෞඛ්‍ය සම්පන්න සමාජයක් පිළිබඳ නිගමනය - ලකුණු 02"
                    )
                    val ans = "✨ [සෞඛ්‍ය O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. සෞඛ්‍ය මූලධර්ම:\n   • '$topicName' යටතේ ශාරීරික හා මානසික සෞඛ්‍යයට බලපාන ප්‍රධාන සාධක විස්තර කර ඇත.\n\n" +
                        "2. රෝග නිවාරණය හා පෝෂණය:\n   • සමබර ආහාර වේලක වැදගත්කම සහ බෝවන/බෝනොවන රෝගවලින් වැළකෙන ක්‍රම දක්වා ඇත.\n\n" +
                        "3. ප්‍රායෝගික හැසිරීම:\n   • සෞඛ්‍යාරක්ෂිත පුරුදු දෛනික ජීවිතයට අනුගත කරගැනීම පැහැදිලි කර ඇත.\n\n" +
                        "4. නිගමනය:\n   • නිරෝගී ජීවිතයක් සඳහා අත්‍යවශ්‍ය සෞඛ්‍ය මාර්ගෝපදේශ සාරාංශ කර ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("කෘෂිකර්මය") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L කෘෂිකර්ම විෂය නිර්දේශයට අනුව '$topicName' පාඩම් මාතෘකාව යටතේ කෘෂිකාර්මික ක්‍රමවේද, පස් කළමනාකරණය සහ වගා තාක්ෂණය විස්තර කරන්න."
                    val ms = listOf(
                        "🟢 (i) කෘෂිකාර්මික සංකල්ප සහ අමුද්‍රව්‍ය හැඳින්වීම - ලකුණු 03",
                        "🔵 (ii) වගා ක්‍රමවේද, පස් වර්ග සහ ජල කළමනාකරණය - ලකුණු 03",
                        "🟠 (iii) පලිබෝධ පාලනය සහ අස්වනු නෙළීමේ තාක්ෂණය - ලකුණු 02",
                        "🟣 (iv) තිරසාර කෘෂිකර්මාන්තය පිළිබඳ නිගමනය - ලකුණු 02"
                    )
                    val ans = "✨ [කෘෂිකර්මය O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. කෘෂිකාර්මික හැඳින්වීම:\n   • '$topicName' යටතේ වගාවට අවශ්‍ය පස, ජලය සහ පෝෂක මූලධර්ම විස්තර කර ඇත.\n\n" +
                        "2. වගා කළමනාකරණය:\n   • බෝග නඩත්තුව, කොම්පෝස්ට් නිෂ්පාදනය සහ කාබනික පොහොර භාවිතය පැහැදිලි කර ඇත.\n\n" +
                        "3. පලිබෝධ පාලනය:\n   • රෝගවලින් බෝග ආරක්ෂා කරගැනීමේ විද්‍යාත්මක ක්‍රම දක්වා ඇත.\n\n" +
                        "4. නිගමනය:\n   • ලාභදායී සහ තිරසාර කෘෂි ව්‍යවසායකත්ව ප්‍රවේශය සාරාංශ කර ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("ව්‍යාපාර") || subject.contains("Commerce") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L ව්‍යාපාර හා ගිණුම්කරණය විෂය නිර්දේශයට අනුව '$topicName' පාඩමට අදාළව ව්‍යාපාරික පරිසරය, මූල්‍ය වාර්තාකරණය හෝ ගිණුම්කරණ සමීකරණය විසඳන්න."
                    val ms = listOf(
                        "🟢 (i) ව්‍යාපාරික සංකල්පය හෝ මූල්‍ය සමීකරණය හැඳින්වීම - ලකුණු 03",
                        "🔵 (ii) ජර්නල්, ලෙජර හෝ මූල්‍ය ප්‍රකාශන නිවැරදිව සකස් කිරීම - ලකුණු 03",
                        "🟠 (iii) හර සහ බැරු පැති තුල්‍ය කිරීම - ලකුණු 02",
                        "🟣 (iv) ව්‍යාපාරික තීන්දු ගැනීමේදී මූල්‍ය දත්ත අර්ථකථනය - ලකුණු 02"
                    )
                    val ans = "✨ [ව්‍යාපාර අධ්‍යනය O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. මූලික සංකල්ප:\n   • ව්‍යාපාරික ගනුදෙනු විශ්ලේෂණය කර අදාළ ගිණුම් වර්ග කර ඇත.\n\n" +
                        "2. මූල්‍ය සටහන්කරණය:\n   • හර සහ බැරු නීති අනුගමනය කරමින් ජර්නල් සහ ලෙජර් සටහන් සකස් කර ඇත.\n\n" +
                        "3. වාර්තාකරණය:\n   • ලාභ අලාභ ගිණුම සහ ශේෂ පත්‍රය නිවැරදිව තුල්‍ය කර ඇත.\n\n" +
                        "4. නිගමනය:\n   • ව්‍යාපාරයේ මූල්‍ය ස්ථාවරත්වය සහ ලාභදායීතාවය තක්සේරු කර ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("භූගෝල") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L භූගෝල විද්‍යාව විෂය නිර්දේශයට අනුව '$topicName' පාඩම් මාතෘකාව යටතේ භූගෝලීය ලක්ෂණ, කාලගුණය සහ ආර්ථික කලාප විශ්ලේෂණය කරන්න."
                    val ms = listOf(
                        "🟢 (i) භූගෝලීය සංකල්ප සහ පිහිටීම හැඳින්වීම - ලකුණු 03",
                        "🔵 (ii) වායුගෝලීය, ජල විද්‍යාත්මක හෝ ජනගහන දත්ත විස්තර කිරීම - ලකුණු 03",
                        "🟠 (iii) ආර්ථික හා පාරිසරික බලපෑම් විශ්ලේෂණය - ලකුණු 02",
                        "🟣 (iv) තිරසාර භූමි භාවිතය පිළිබඳ නිගමනය - ලකුණු 02"
                    )
                    val ans = "✨ [භූගෝලය O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. භූගෝලීය හැඳින්වීම:\n   • '$topicName' යටතේ පෘථිවි ස්වරූපය, දේශගුණය හෝ ජනගහන ව්‍යාප්තිය විස්තර කර ඇත.\n\n" +
                        "2. දත්ත විශ්ලේෂණය:\n   • ගංගා ද්‍රෝಣಿ, කෘෂිකාර්මික කලාප හෝ ස්වභාවික විපත්වල ස්වභාවය පෙන්වා දී ඇත.\n\n" +
                        "3. ආර්ථික වැදගත්කම:\n   • රටක සංවර්ධනයට භූගෝලීය සාධක දායක වන අයුරු විග්‍රහ කර ඇත.\n\n" +
                        "4. නිගමනය:\n   • ස්වභාවික සම්පත් සංරක්ෂණය සහ තිරසාර කළමනාකරණය සාරාංශ කර ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("පුරවැසි") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L පුරවැසි අධ්‍යාපනය විෂය නිර්දේශයට අනුව '$topicName' පාඩම යටතේ ප්‍රජාතන්ත්‍රවාදී වටිනාකම්, නීතියේ ආධිපත්‍යය සහ පුරවැසි වගකීම් විස්තර කරන්න."
                    val ms = listOf(
                        "🟢 (i) ප්‍රජාතන්ත්‍රවාදී මූලධර්ම සහ ව්‍යවස්ථාපිත සංකල්ප - ලකුණු 03",
                        "🔵 (ii) ආණ්ඩුක්‍රම ව්‍යවස්ථා ප්‍රතිපාදන සහ ආයතන ව්‍යුහය - ලකුණු 03",
                        "🟠 (iii) පුරවැසි අයිතිවාසිකම් සහ ප්‍රායෝගික ගැටලු විසඳීම - ලකුණු 02",
                        "🟣 (iv) යහපාලනය සහ සාමකාමී සමාජයක් පිළිබඳ නිගමනය - ලකුණු 02"
                    )
                    val ans = "✨ [පුරවැසි අධ්‍යාපනය O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. ප්‍රජාතන්ත්‍රවාදී හැඳින්වීම:\n   • '$topicName' යටතේ ආණ්ඩුක්‍රම ව්‍යවස්ථාවේ මූලික නීති සහ ප්‍රතිපාදන විස්තර කර ඇත.\n\n" +
                        "2. ආයතනික ක්‍රියාකාරීත්වය:\n   • පාර්ලිමේන්තුව, අධිකරණය සහ පළාත් පාලන ආයතනවල වගවීම සාකච්ඡා කර ඇත.\n\n" +
                        "3. පුරවැසි කාර්යභාරය:\n   • ක්‍රියාකාරී පුරවැසියකු ලෙස සමාජ සංවර්ධනයට දායක වන ආකාරය දක්වා ඇත.\n\n" +
                        "4. නිගමනය:\n   • නීතියේ ආධිපත්‍යය රකින සාධාරණ සමාජයක් බිහි කිරීමේ වැදගත්කම සාරාංශ කර ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("විද්‍යාව") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L විද්‍යාව විෂය නිර්දේශයට අනුව '$topicName' පාඩම යටතේ එන විද්‍යාත්මක සිද්ධාන්ත, පර්යේෂණ ඇටවුම් හෝ රසායනික සමීකරණ පියවරෙන් පියවර පැහැදිලි කරන්න."
                    val ms = listOf(
                        "🟢 (i) මූලික විද්‍යාත්මක සංකල්පය සහ පාරිභාෂික යෙදුම් - ලකුණු 03",
                        "🔵 (ii) අදාළ සමීකරණ හෝ ප්‍රායෝගික ඇටවුම් නම් කිරීම - ලකුණු 03",
                        "🟠 (iii) ක්‍රමික තාර්කික විශ්ලේෂණය සහ දත්ත සැකසීම - ලකුණු 02",
                        "🟣 (iv) SI ඒකක සහිත අවසන් නිගමනය දැක්වීම - ලකුණු 02"
                    )
                    val ans = "✨ [විද්‍යාව O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. විද්‍යාත්මක හැඳින්වීම:\n   • '$topicName' යටතේ ප්‍රධාන විද්‍යාත්මක මූලධර්මය නිරවුල්ව දක්වා ඇත.\n\n" +
                        "2. පර්යේෂණ පියවර හා සමීකරණ:\n   • පාලිත විචල්‍යයන් යොදා ගනිමින් සිදු කරන පරීක්ෂණ ක්‍රමවේදය සහ තුලිත රසායනික සමීකරණ ලියා ඇත.\n\n" +
                        "3. දත්ත විශ්ලේෂණය:\n   • ගණනය කිරීම් සහ SI ඒකක නිවැරදිව යොදා ගනිමින් ප්‍රතිඵල පෙන්වා ඇත.\n\n" +
                        "4. නිගමනය:\n   • විද්‍යාත්මක සංසිද්ධිය තහවුරු කරමින් නිගමනය කර ඇත."
                    Triple(text, ms, ans)
                }
                subject.contains("ගණිතය") -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L ගණිතය විෂය නිර්දේශයට අනුව '$topicName' පාඩම යටතේ එන ගැටළුවක් සඳහා න්‍යායාත්මක සූත්‍ර හා ක්‍රමික පියවර අනුගමනය කරමින් සම්පූර්ණ පිළිතුර ලබාදෙන්න."
                    val ms = listOf(
                        "🟢 (i) දත්ත ලැයිස්තුගත කිරීම හා ගැළපෙන සූත්‍රය තෝරාගැනීම - ලකුණු 03",
                        "🔵 (ii) සංඛ්‍යාත්මක අගයන් නිවැරදිව සූත්‍රයට ආදේශ කිරීම - ලකුණු 03",
                        "🟠 (iii) අනුක්‍රමිකව සුළු කිරීමේ පියවර පෙන්වීම - ලකුණු 02",
                        "🟣 (iv) සම්මත ඒකක සහිත අවසන් නිවැරදි අගය ලබාගැනීම - ලකුණු 02"
                    )
                    val ans = "✨ [ගණිතය O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. දත්ත හා සූත්‍ර:\n   • ප්‍රශ්නයේ දී ඇති දත්ත සටහන් කර අදාළ ගණිතමය සූත්‍රය හෝ ප්‍රමේයය ලියා ඇත.\n\n" +
                        "2. ආදේශනය හා සුළු කිරීම:\n   • සූත්‍රයට අගයන් ආදේශ කර පියවරෙන් පියවර ගණනය කර ඇත.\n\n" +
                        "3. ක්‍රමික පියවර:\n   • වීජීය සාධක හෝ ජ්‍යාමිතික සාධන පියවර නිවැරදිව අනුගමනය කර ඇත.\n\n" +
                        "4. අවසන් පිළිතුර:\n   • නිවැරදි සංඛ්‍යාත්මක අගය සහ ඒකක සමඟ පිළිතුර දක්වා ඇත."
                    Triple(text, ms, ans)
                }
                else -> {
                    val text = "10 සහ 11 ශ්‍රේණි O/L ICT විෂය නිර්දේශයට අනුව '$topicName' පාඩම් මාතෘකාවට අදාළ න්‍යායාත්මක සහ ප්‍රායෝගික තොරතුරු තාක්ෂණ සංකල්ප විස්තර කරන්න."
                    val ms = listOf(
                        "🟢 (i) ICT මූලික සංකල්ප සහ පාරිභාෂික යෙදුම් - ලකුණු 03",
                        "🔵 (ii) දත්ත හැසිරවීම, ඇල්ගොරිතම හෝ වැඩසටහන් කේත - ලකුණු 03",
                        "🟠 (iii) ජාලකරණ හෝ දත්ත සමුදා ව්‍යුහය පැහැදිලි කිරීම - ලකුණු 02",
                        "🟣 (iv) තොරතුරු තාක්ෂණයේ සදාචාරාත්මක භාවිතය පිළිබඳ නිගමනය - ලකුණු 02"
                    )
                    val ans = "✨ [ICT O/L නිල ආදර්ශ පිළිතුර - ප්‍රශ්න අංක $globalIndex]\n\n" +
                        "1. තාක්ෂණික හැඳින්වීම:\n   • '$topicName' යටතේ පරිගණක පද්ධති, ද්විමය ක්‍රම හෝ මෘදුකාංග සංකල්ප විස්තර කර ඇත.\n\n" +
                        "2. ප්‍රායෝගික ක්‍රියාකාරීත්වය:\n   • පැතුරුම්පත් සූත්‍ර, දත්ත සමුදා යතුරු හෝ HTML ටැග නිවැරදිව යොදා ගන්නා ආකාරය දක්වා ඇත.\n\n" +
                        "3. ජාලකරණ විග්‍රහය:\n   • ජාල ස්ථල විද්‍යා සහ ආරක්ෂණ විධිවිධාන සාකච්ඡා කර ඇත.\n\n" +
                        "4. නිගමනය:\n   • තොරතුරු තාක්ෂණය කාර්යක්ෂමව හා ආරක්ෂාකාරීව භාවිත කිරීම සාරාංශ කර ඇත."
                    Triple(text, ms, ans)
                }
            }

            list.add(
                EssayQuestion(
                    id = "${subject}_c${category}_q${qNum}",
                    subject = subject,
                    categoryNumber = category,
                    questionNumber = qNum,
                    lessonName = topicName,
                    title = title,
                    questionText = qText,
                    markingScheme = markingScheme,
                    modelAnswer = modelAnswer
                )
            )
        }
        return list
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StructuredEssayAssessmentHub(onBack: () -> Unit) {
    var selectedSubject by remember { mutableStateOf(ComprehensiveEssayDataBank.subjects[0]) }
    var selectedCategory by remember { mutableStateOf(1) } // 1 to 10
    var selectedQuestion by remember { mutableStateOf<EssayQuestion?>(null) }
    var studentAnswer by remember { mutableStateOf("") }
    var showMarkingScheme by remember { mutableStateOf(false) }

    val currentQuestions = remember(selectedSubject, selectedCategory) {
        ComprehensiveEssayDataBank.getQuestionsForSubjectAndCategory(selectedSubject, selectedCategory)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("රචනා පුහුණුව • ප්‍රශ්න 100 (කාණ්ඩ 10)", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = {
                        if (selectedQuestion != null) {
                            selectedQuestion = null
                            showMarkingScheme = false
                            studentAnswer = ""
                        } else {
                            onBack()
                        }
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize().background(Color(0xFFF8FAFC))) {
            if (selectedQuestion == null) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        item {
                            Text("විෂයක් සහ කාණ්ඩයක් (සෑම කාණ්ඩයකටම ප්‍රශ්න 10 බැගින්, විෂයකට මුළු ප්‍රශ්න 100ක්) තෝරන්න:", fontSize = 12.5.sp, color = Color(0xFF475569), fontWeight = FontWeight.SemiBold)
                            Spacer(modifier = Modifier.height(10.dp))

                            // Subject Selector
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                ComprehensiveEssayDataBank.subjects.forEach { subj ->
                                    FilterChip(
                                        selected = selectedSubject == subj,
                                        onClick = { selectedSubject = subj },
                                        label = { Text(subj, fontSize = 11.5.sp, fontWeight = FontWeight.Bold) },
                                        colors = FilterChipDefaults.filterChipColors(
                                            selectedContainerColor = Color(0xFF0284C7),
                                            selectedLabelColor = Color.White
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // Category Selector (1 to 10)
                            Text("අධ්‍යයන කාණ්ඩය (Category 1 - 10):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E293B))
                            Spacer(modifier = Modifier.height(6.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                for (cat in 1..10) {
                                    FilterChip(
                                        selected = selectedCategory == cat,
                                        onClick = { selectedCategory = cat },
                                        label = { Text("කාණ්ඩය $cat", fontSize = 11.sp) },
                                        colors = FilterChipDefaults.filterChipColors(
                                            selectedContainerColor = Color(0xFF10B981),
                                            selectedLabelColor = Color.White
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(14.dp))
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(0xFFEFF6FF),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFBFDBFE)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "📚 $selectedSubject • කාණ්ඩය $selectedCategory (ප්‍රශ්න 10)",
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1D4ED8),
                                    fontSize = 12.5.sp,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                        items(currentQuestions) { q ->
                            Card(
                                modifier = Modifier.fillMaxWidth().clickable { selectedQuestion = q },
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE2E8F0))
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = Color(0xFFFEF3C7)
                                        ) {
                                            Text(
                                                text = "ප්‍රශ්න අංක ${q.questionNumber}",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFFB45309),
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                        Text("මුළු ලකුණු: 10", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF059669))
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = Color(0xFFEFF6FF)
                                    ) {
                                        Text(
                                            text = "📚 පාඩම: ${q.lessonName}",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF1D4ED8),
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(q.title, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF0F172A))
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(q.questionText, fontSize = 12.5.sp, color = Color(0xFF475569), maxLines = 2)
                                }
                            }
                        }
                    }
            } else {
                val q = selectedQuestion!!
                LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    item {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFFEFF6FF),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text("📚 පාඩම (Lesson): ${q.lessonName}", fontSize = 13.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1D4ED8))
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(q.title, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFCBD5E1))
                        ) {
                            Text(q.questionText, modifier = Modifier.padding(16.dp), fontSize = 14.sp, color = Color(0xFF1E293B), lineHeight = 20.sp)
                        }
                    }
                    item {
                        Text("ඔබේ පිළිතුර මෙහි ලියන්න (Submit after writing):", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color(0xFF334155))
                        Spacer(modifier = Modifier.height(6.dp))
                        OutlinedTextField(
                            value = studentAnswer,
                            onValueChange = { studentAnswer = it },
                            modifier = Modifier.fillMaxWidth().height(150.dp),
                            placeholder = { Text("මෙහි පිළිතුර ලියන්න...") },
                            shape = RoundedCornerShape(10.dp)
                        )
                    }
                    item {
                        Button(
                            onClick = { if (studentAnswer.isNotBlank()) showMarkingScheme = true },
                            modifier = Modifier.fillMaxWidth().height(48.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = if (studentAnswer.isNotBlank()) Color(0xFF0284C7) else Color(0xFF94A3B8)),
                            shape = RoundedCornerShape(10.dp),
                            enabled = studentAnswer.isNotBlank()
                        ) {
                            Icon(Icons.Default.RateReview, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("පිළිතුර ඉදිරිපත් කර ලකුණු බලන්න", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                    if (showMarkingScheme) {
                        item {
                            Card(
                                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FDF4)),
                                border = androidx.compose.foundation.BorderStroke(1.5.dp, Color(0xFF86EFAC))
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF16A34A), modifier = Modifier.size(20.dp))
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text("ලකුණු ලබා දීමේ ක්‍රියාපටිපාටිය සහ ආදර්ශ පිළිතුර:", fontWeight = FontWeight.Bold, fontSize = 13.5.sp, color = Color(0xFF166534))
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    q.markingScheme.forEach { rule ->
                                        Text("• $rule", fontSize = 13.sp, color = Color(0xFF14532D), fontWeight = FontWeight.Medium, modifier = Modifier.padding(vertical = 2.dp))
                                    }
                                    Spacer(modifier = Modifier.height(14.dp))
                                    HorizontalDivider(color = Color(0xFFBBF7D0))
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(q.modelAnswer, fontSize = 13.sp, color = Color(0xFF14532D), lineHeight = 19.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
