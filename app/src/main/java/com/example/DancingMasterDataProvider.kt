package com.example

import androidx.compose.ui.graphics.Color

// ============================================================================
// DATA MODELS FOR GRADE 10 & 11 DANCING (නර්තනය) MASTER HUB
// ============================================================================

enum class DancingGradeTab(val labelSinhala: String, val badge: String) {
  ALL("සියල්ල (10 & 11)", "O/L සම්පූර්ණ"),
  GRADE_10("10 ශ්‍රේණිය", "මූලික න්‍යාය & සරඹ"),
  GRADE_11("11 ශ්‍රේණිය", "ශාන්තිකර්ම & අභිනය")
}

enum class DancingSectionCategory(
  val id: String,
  val titleSinhala: String,
  val subtitle: String,
  val emoji: String,
  val themeColor: Color
) {
  TRADITIONS_AND_DRUMS("traditions", "ත්‍රිවිධ දේශීය සම්ප්‍රදාය & බෙර වාදන", "උඩරට, පහතරට සහ සබරගමු", "💃", Color(0xFFE11D48)),
  VANNAM_18("vannam", "උඩරට වන්නම් 18 & තාල විවරණ", "කවි, තානම්, කස්තිරම්, අඩව්", "🦚", Color(0xFF0284C7)),
  ABHINAYA_AND_MUDRAS("abhinaya", "චතුර්විධ අභිනය, නවරස & මුද්‍රා", "අසංයුත 28 & සංයුත 24 හස්ත", "🖐️", Color(0xFF7C3AED)),
  INSTRUMENTS_AND_COSTUMES("instruments", "පංචතූර්ය, වාද්‍ය භාණ්ඩ & ඇඳුම්", "වෙස් ඇඳුම්, දෙවොල් & වෙස්මුහුණු", "🥁", Color(0xFFD97706)),
  PRACTICAL_AND_VIVA("practical", "ප්‍රායෝගික පරීක්ෂණ & Viva මාර්ගෝපදේශය", "පා සරඹ, ගායන, වාදන & වාචික", "🎙️", Color(0xFF059669)),
  EXAM_MCQ_AND_ESSAYS("exams", "O/L MCQs & ආදර්ශ රචනා", "විවරණ සහ නිල ලකුණු පටිපාටි", "🎯", Color(0xFFDC2626)),
  LESSONS_AND_NOTES("lessons", "10 & 11 විෂය නිර්දේශ ඒකක සටහන්", "සම්පූර්ණ කෙටි සටහන් සංග්‍රහය", "📚", Color(0xFF4F46E5))
}

data class DanceTradition(
  val id: String,
  val nameSinhala: String,
  val nameEnglish: String,
  val region: String,
  val primaryDrum: String,
  val drumCharacteristics: String,
  val drumSyllables: String,
  val sacredShanthikarma: String,
  val mainCostume: String,
  val costumeJewelry: List<String>,
  val guardianDeities: String,
  val keyExercises: List<String>,
  val specialFeatures: String,
  val historicalOrigin: String
)

data class VannamItem(
  val number: Int,
  val nameSinhala: String,
  val animalOrTheme: String,
  val matraCount: String,
  val thalaType: String,
  val poemSinhala: String,
  val thanamaSinhala: String,
  val kastiramaSinhala: String,
  val seerumaruwaSinhala: String,
  val adawwaSinhala: String,
  val meaningAndBhava: String
)

data class AbhinayaItem(
  val id: String,
  val nameSinhala: String,
  val nameSanskrit: String,
  val definition: String,
  val components: List<String>,
  val practicalApplication: String
)

data class RasaItem(
  val number: Int,
  val rasaSinhala: String,
  val sthayiBhavaSinhala: String,
  val colorAssociation: String,
  val presidingDeity: String,
  val description: String,
  val danceExpressionTip: String
)

data class MudraItem(
  val id: String,
  val nameSinhala: String,
  val type: String, // "අසංයුත (තනි අතින්)" or "සංයුත (දෑතින්)"
  val handShapeDescription: String,
  val representations: List<String>, // What it depicts (meaning)
  val shlokaReference: String
)

data class InstrumentCostumeItem(
  val id: String,
  val category: String, // "පංචතූර්ය භාණ්ඩ", "ඇඳුම් ආයිත්තම්", "වෙස් මුහුණු"
  val titleSinhala: String,
  val classification: String,
  val rawMaterials: String,
  val detailsSinhala: String,
  val ritualSignificance: String
)

data class PracticalVivaItem(
  val id: String,
  val category: String, // "ප්‍රායෝගික සරඹ", "වන්නම් නර්තන", "බෙර වාදන", "Viva වාචික ප්‍රශ්න"
  val titleSinhala: String,
  val marksWeightage: String,
  val keyTechniques: List<String>,
  val examinerExpectations: String,
  val commonMistakesToAvoid: String,
  val sampleQuestionAndAnswer: String? = null
)

data class DanceMcqQuestion(
  val id: Int,
  val grade: String,
  val categoryTag: String,
  val questionText: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanation: String
)

data class DanceModelEssay(
  val id: String,
  val grade: String,
  val unitName: String,
  val questionTitle: String,
  val scenarioOrStem: String,
  val subQuestions: List<DanceEssaySubQuestion>
)

data class DanceEssaySubQuestion(
  val numberText: String,
  val questionText: String,
  val marks: Int,
  val markingSchemePoints: List<String>
)

data class DanceLessonNote(
  val id: String,
  val grade: String,
  val unitNumber: Int,
  val unitTitle: String,
  val coreConcepts: List<String>,
  val summaryText: String,
  val examFocusPoints: List<String>
)

// ============================================================================
// DANCING MASTER DATA REPOSITORY
// ============================================================================

object DancingMasterDataProvider {

  // 1. ත්‍රිවිධ දේශීය සම්ප්‍රදායන්
  val traditions: List<DanceTradition> = listOf(
    DanceTradition(
      id = "kandyan",
      nameSinhala = "උඩරට නර්තන සම්ප්‍රදාය (Kandyan Tradition)",
      nameEnglish = "Kandyan Dance System",
      region = "මධ්‍යම කඳුකරය (සෙංකඩගල, මාතලේ, කෑගල්ල හා නුවරඑළිය උඩරට ප්‍රදේශ)",
      primaryDrum = "ගැටබෙරය (Geta Beraya / මංගල බෙරය)",
      drumCharacteristics = "මැද මහත දෙකෙළවර සිහින් හැඩය. දිග අඟල් 27-28 පමණ වේ. දකුණු ඇසට වඳුරු හම් ද, වම් ඇසට ගව හම් ද යොදනු ලබයි. කඳ කොහොඹ, ඇහැළ හෝ මිල්ල ලීයෙන් සාදයි. වරපට මී හරක් හම් වේ.",
      drumSyllables = "තනත් තම්දෙන තානත් තෙයිද තත් තෙයි • ජිං තොං නං තත් තෙයි • කුකුඳ ගජිං ගජිං තොං",
      sacredShanthikarma = "කොහොඹා කංකාරිය (Kohomba Kankariya - පණ්ඩුකාභය/විජය යුගයේ විජය රජුට වැළඳුනු දිවිදෝස සමනයට පැවැත්වූ ප්‍රථම ශාන්තිකර්මය)",
      mainCostume = "වෙස් ඇඳුම් කට්ටලය (Ves Costume) - ආභරණ 64කින් සමන්විත වූවද වර්තමානයේ ප්‍රධාන ආභරණ කට්ටලය පළඳියි.",
      costumeJewelry = listOf(
        "වෙස් තට්ටුව (ශීර්ෂාභරණය - සූර්ය මණ්ඩලය හා ජටාව සහිතයි)",
        "තොඩෝඩු (කන් ආභරණ)",
        "නෙற்றிමාලය (නළල් පටිය)",
        "අවුල්හැරය (උරහිස් සහ ළය ආවරණය වන මාලය)",
        "කරපටිය (බෙල්ල වටා පළඳින පටිය)",
        "දේවකරණය / ඊලංගය (උරහිස් පලඳනා)",
        "බඳපටිය සහ ඉන හැට්ටය",
        "හංගලාව සහ දෙවඟලාව (සුදු රෙදි කඩ)",
        "නෙරිය (ඉණ වටා රැලි කළ රෙදි ආවරණය)",
        "සිලම්බු (පාදවල පළඳින ගෙජ්ජි වළලු)"
      ),
      guardianDeities = "මහ කොහොඹා, කඩවර දෙවියන්, මංගර, නාථ, විෂ්ණු, කතරගම, පත්තිනි",
      keyExercises = listOf(
        "මණ්ඩිය (මූලික ඉරියව්ව - දණහිස් දෙපසට නවා පාද අඩ සඳ හැඩයෙන් තැබීම)",
        "පා සරඹ 12 (පාද චලන අභ්‍යාස)",
        "ගොඩ සරඹ 12 (අත් හා පාද සංකලනය)",
        "දණ්ඩ සරඹ (බාහු හා ශරීර නම්‍යශීලීතා අභ්‍යාස)",
        "බෙර සරඹ 12 (ගැටබෙර මූලික වාදන අභ්‍යාස)"
      ),
      specialFeatures = "වීර හා රෞද්‍ර රසයන් මූලික වේ. පුරුෂ පාර්ශවය සඳහාම වෙන්ව පැවති තාණ්ඩව ලක්ෂණ සහිත රාජකීය උරුමයකි.",
      historicalOrigin = "මලේ රජුගේ පැමිණීම සහ කොහොඹා දෙවියන්ගේ ආශිර්වාදය හා සබැඳි පුරාවෘත්තය. මහනුවර දළදා පෙරහැරේ ප්‍රධාන නර්තන අංගයයි."
    ),
    DanceTradition(
      id = "low_country",
      nameSinhala = "පහතරට නර්තන සම්ප්‍රදාය (Ruhunu / Low Country)",
      nameEnglish = "Ruhunu / Low Country Dance System",
      region = "දකුණු සහ බස්නාහිර මුහුදුබඩ ප්‍රදේශ (ගාල්ල, මාතර, හම්බන්තොට, කළුතර, කොළඹ)",
      primaryDrum = "යක්බෙරය (Yak Beraya / දෙවොල් බෙරය / ඝෝෂක බෙරය / රුහුණු බෙරය)",
      drumCharacteristics = "සිලින්ඩරාකාර හැඩය. දිග අඟල් 28-30 පමණ වේ. දෙපසම රවුම් මුහුණත් දෙකකි. ඇස සඳහා මව් එළදෙනගේ බඩවැල් පටලය හෝ වහු හම යොදයි. ගැඹුරු ඝෝෂාකාරී නාදයක් නංවයි.",
      drumSyllables = "දෙන් දෙං ජිං කුඳ • තරිඟු කුඳ තරිඟු කුඳ ජිං කුඳ • තක්කිට තක්කිට ජිං කුඳ",
      sacredShanthikarma = "ගම්මඩුව / දෙවොල් මඩුව (පත්තිනි දේවිය උදෙසා) සහ පහතරට තොවිල්: දහඅට සන්නිය (සන්නි යකුම), මහාසෝහොන් සමයම, රීරී යකා සමයම",
      mainCostume = "දෙවොල් ඇඳුම / නාඩගම් සහ කෝලම් ඇඳුම් / සන්නි වෙස්මුහුණු",
      costumeJewelry = listOf(
        "වෙස් මුහුණ (වෙල්කදුරු දැවයෙන් කැටයම් කළ)",
        "කඩතුරාව සහ රතු හැට්ටය",
        "බඳපටිය සහ රතු රෙදි ලඟිංචිය",
        "කරමාලය සහ පබළු ආභරණ",
        "පාදවල පළඳින ගෙජ්ජි සහ පාද පට",
        "දෙවොල් නර්තනයේ මල් කිරුළ"
      ),
      guardianDeities = "පත්තිනි දේවිය, දෙවොල් දෙවියන්, කතරගම දෙවියන්",
      keyExercises = listOf(
        "පහතරට මණ්ඩිය (උකුල් ඇට අස්ථියෙන් පහතට නැමෙන ඉරියව්ව)",
        "පහතරට පා සරඹ 12",
        "පහතරට ගොඩ සරඹ 12",
        "වේග රිද්ම භ්‍රමණ (කැරකිලි) අභ්‍යාස",
        "යක්බෙර වාදන අභ්‍යාස"
      ),
      specialFeatures = "හාස්‍ය, භයානක සහ බීභත්ස රස බහුලව උපදවයි. වෙස්මුහුණු පැළඳීම හා දෙබස් භාවිතය (නාට්‍යමය ලක්ෂණ) ඉතා ඉහළය.",
      historicalOrigin = "විසාලා මහනුවර තුන්බිය දුරු කිරීමට බුදුරජාණන් වහන්සේ රතන සූත්‍රය දේශනා කිරීමත් සමග සන්නි යකුන් පළවා හැරීමේ ශාන්තිකර්ම සම්ප්‍රදාය බිහිවූ බව විශ්වාස කෙරේ."
    ),
    DanceTradition(
      id = "sabaragamuwa",
      nameSinhala = "සබරගමු නර්තන සම්ප්‍රදාය (Sabaragamuwa Tradition)",
      nameEnglish = "Sabaragamuwa Dance System",
      region = "සබරගමු පළාත (රත්නපුරය, පැල්මඩුල්ල, බලංගොඩ, කෑගල්ල ආශ්‍රිත ප්‍රදේශ)",
      primaryDrum = "දවුල (Dawula / හේවිසි බෙරය)",
      drumCharacteristics = "සිලින්ඩරාකාර නමුත් යක්බෙරයට වඩා කෙටි මහත හැඩය. දිග අඟල් 18-20 පමණ වේ. දකුණු ඇස කඩිප්පුවෙන් ද වම් ඇස අතින් ද වාදනය කෙරේ. තද පිත්තල හෝ ලෝකඩ වළලු සහිතය.",
      drumSyllables = "දොං ජිං ගත දොං • ගත ජිං ගත දොං • තිරිකිට තක දොං • තෙයි තෙයි ගත දොං",
      sacredShanthikarma = "පහන් මඩුව (Pahan Maduwa - සුමන සමන් දෙවියන් සහ පත්තිනි දේවිය උදෙසා) සහ දොළහ පෙළපාලිය",
      mainCostume = "සබරගමු සාම්ප්‍රදායික නර්තන ඇඳුම (Sabaragamuwa Costume)",
      costumeJewelry = listOf(
        "මාත්‍රය (හිස් ආභරණය)",
        "කරපටිය සහ පබළු පටි",
        "ඉනහැට්ටය සහ පබළු දැල",
        "රතු සහ සුදු උඩරට-පහතරට මිශ්‍රිත ලක්ෂණ සහිත රෙදි කට්ටලය",
        "කන්පති සහ බාහුබන්දන",
        "දවුල් පටිය (වාදකයා සඳහා)"
      ),
      guardianDeities = "සුමන සමන් දෙවියන්, පත්තිනි දේවිය, දැඩිමුණ්ඩ දෙවියන්",
      keyExercises = listOf(
        "සබරගමු මණ්ඩිය (මධ්‍යස්ථ මණ්ඩම් ඉරියව්ව)",
        "සබරගමු පා සරඹ 12",
        "සබරගමු මාත්‍රා සහ අලංකාර අභ්‍යාස",
        "දවුල් වාදන අභ්‍යාස සහ කඩිප්පු හැසිරවීම"
      ),
      specialFeatures = "උඩරට සහ පහතරට සම්ප්‍රදායන් දෙකෙහිම සුසංයෝගයක් දක්නට ලැබේ. භක්ති රසය හා ශාන්ත රසය ප්‍රමුඛ වේ.",
      historicalOrigin = "ශ්‍රී පාදස්ථානය සහ සබරගමු මහ සමන් දේවාලය කේන්ද්‍ර කරගනිමින් පූජා චාරිත්‍ර ලෙස විකාශනය විය."
    )
  )

  // 2. උඩරට වන්නම් 18
  val vannams: List<VannamItem> = listOf(
    VannamItem(
      number = 1,
      nameSinhala = "ගජගා වන්නම (Gajaga Vannama)",
      animalOrTheme = "ඓරාවණ ඇතුගේ මනහර ගමන හා විලාසය",
      matraCount = "මාත්‍රා 4 (චතුරශ්‍ර ජාතිය)",
      thalaType = "තත්තෙයි තොංනං රිද්මය",
      poemSinhala = "සැරදෙ සිරි ධන රඳනා - බැබළි සව් සිරි සදනා\nපවර සුරපුර වදනා - එසිරි ගජගා වන්නම දනිනා...",
      thanamaSinhala = "තන තන තම්දෙන තානත් තෙයිද තත් තෙයි • තන තන තම්දෙන තානත් තෙයිද තත් තෙයි",
      kastiramaSinhala = "ජිං තොං නං තත් තෙයි • කුකුඳ ගජිං ගජිං තොං",
      seerumaruwaSinhala = "තකිට තකිට තිරිකිට කුඳ තත් තෙයි",
      adawwaSinhala = "තෙයි තෙයි තත් තෙයි • ජිං ජිං තොං තෙයි • ගජිං ගජිං තොං",
      meaningAndBhava = "විසල් සිරුරක් ඇති ඇතෙකු වන ලැහැබ මැදින් හෙමින් පා තබමින්, හොඬවැල වනමින්, ජලය ඉසිමින් ගමන් කරන විලාසය නිරූපණය කෙරේ. වීර සහ ගාම්භීර භාවය ප්‍රකට කරයි."
    ),
    VannamItem(
      number = 2,
      nameSinhala = "තුරඟා වන්නම (Thuranga Vannama)",
      animalOrTheme = "සිද්ධාර්ථ කුමරු ගිහිගෙය හැර ගිය කන්තක අශ්වයාගේ වේගවත් ගමන",
      matraCount = "මාත්‍රා 4 (චතුරශ්‍ර ජාතිය)",
      thalaType = "ද්‍රුත ලය (වේග රිද්මය)",
      poemSinhala = "කන්තක නම් අසු පිටිනා - සිද්ධාර්ථ කුමරුන් වඩිනා\nරන්කඳ සේ දිලිසෙමිනා - තුරඟා වන්නම මෙලෙසිනා...",
      thanamaSinhala = "තාන තෙනම් තෙන තම්දෙන තානත් තෙනා • තාන තෙනම් තෙන තම්දෙන තානත් තෙනා",
      kastiramaSinhala = "තරිකිට තකිට තක ජිං තොං",
      seerumaruwaSinhala = "කුකුඳ තකිට දොං ගත තත් තෙයි",
      adawwaSinhala = "දොං තරිකිට තක ජිං • තොං තරිකිට තක ජිං • තෙයි තෙයි තත් තෙයි",
      meaningAndBhava = "අශ්වයා කුර තබමින්, හිස වනමින්, පැන පැන වේගයෙන් දුවන ආකාරය පෙන්වයි. කුතුහලය සහ උද්වේගකර වීර භාවය මතු කරයි."
    ),
    VannamItem(
      number = 3,
      nameSinhala = "මයුරා වන්නම (Mayura Vannama)",
      animalOrTheme = "කතරගම දෙවියන්ගේ වාහනය වූ මොණරාගේ නැටුම",
      matraCount = "මාත්‍රා 3 (තිශ්‍ර ජාතිය)",
      thalaType = "නැටුම් ලාලිත්‍යය සහිත රිද්මය",
      poemSinhala = "කතරගම දෙවි සාමිනේ - රන් මොණරා පිට වඩිනේ\nපිල් විදහා නටමිනේ - මයුරා වන්නම කියමිනේ...",
      thanamaSinhala = "තෙන තෙන තත් තෙයි තෙනම් දෙනා • තෙන තෙන තත් තෙයි තෙනම් දෙනා",
      kastiramaSinhala = "කුඳ තකිට තත් තෙයි",
      seerumaruwaSinhala = "ජිං ගත තකිට තෙයි",
      adawwaSinhala = "තත් තෙයි තත් තෙයි • ජිං ජිං තොං • මයුරා නටනා රිද්මයෙන්",
      meaningAndBhava = "මොණරා පිල් විදහා නටන, ගෙල හරවන, අහස බලන සුන්දර ඉරියව් නිරූපණය වේ. ශෘංගාර සහ අද්භූත රසය ජනනය කරයි."
    ),
    VannamItem(
      number = 4,
      nameSinhala = "නෛඅඩි වන්නම (Naiyadi Vannama)",
      animalOrTheme = "නයා සහ නයි නැටුම (භූරිදත්ත ජාතක කතාව)",
      matraCount = "මාත්‍රා 4 (චතුරශ්‍ර ජාතිය)",
      thalaType = "මන්දගාමී හා මධ්‍ය ලය",
      poemSinhala = "භූරිදත්ත නම් නා රජුනා - පෙණ විදහා නටන ලෙසිනා\nනළඟන නෙත් වශී වෙනා - නෛඅඩි වන්නම සොඳිනා...",
      thanamaSinhala = "තාන තාන තම්දෙන තානත් තෙයි • තාන තාන තම්දෙන තානත් තෙයි",
      kastiramaSinhala = "තකිට තිරිකිට කුඳ ජිං",
      seerumaruwaSinhala = "දොං ගත තකිට තත් තෙයි",
      adawwaSinhala = "තත් තෙයි ජිං කුඳ • තත් තෙයි ජිං කුඳ • නාග බන්ධනයෙන් අඩව්ව",
      meaningAndBhava = "සර්පයා පෙණ විදහා පැද්දෙන, ඇඹරෙන හා ක්ෂණිකව පහර දෙන විලාසය හස්ත මුද්‍රා (සර්පශීර්ෂ) මගින් පෙන්වයි. භයානක හා විස්මය රසය මවයි."
    ),
    VannamItem(
      number = 5,
      nameSinhala = "හංසා වන්නම (Hansa Vannama)",
      animalOrTheme = "විල් තෙර පිහිනන හංස ධේනුවගේ ලාලිත්‍යය",
      matraCount = "මාත්‍රා 3 (තිශ්‍ර ජාතිය)",
      thalaType = "ලලිත මෘදු රිද්මය (ලාස්‍ය)",
      poemSinhala = "පියුම් විලේ පිනවන හංසිනී - තුඩින් නෙළුම් මල් ගෙන රඟනී\nපියාපත් සල සලා රැඳෙනී - හංසා වන්නම සිත දිනනී...",
      thanamaSinhala = "තාන තෙනම් දෙන තානත් තෙයි • තාන තෙනම් දෙන තානත් තෙයි",
      kastiramaSinhala = "තක තෙයි කුඳ තත්",
      seerumaruwaSinhala = "ජිං තොං තකිට තෙයි",
      adawwaSinhala = "තෙයි තෙයි තත් තෙයි • හංස පක්ෂ මුද්‍රාවෙන් පියාසැරිය",
      meaningAndBhava = "ජලයේ පාවෙන, පියාපත් සලන, සියුමැලි හංසයන්ගේ සුන්දරත්වය දක්වයි. ශෘංගාර සහ ශාන්ත රසය ප්‍රමුඛ වේ."
    ),
    VannamItem(
      number = 6,
      nameSinhala = "සිංහරාජ වන්නම (Sinharaja Vannama)",
      animalOrTheme = "වන රජු වූ සිංහයාගේ තේජස සහ ගර්ජනාව",
      matraCount = "මාත්‍රා 4",
      thalaType = "ගම්භීර තාලය",
      poemSinhala = "කැලේ රජු සිංහ තේජසිනා - ගුහාවෙන් නික්ම එනා ලෙසිනා\nගර්ජනා කර දෙදරුම් කවනා - සිංහරාජ වන්නම දනිනා...",
      thanamaSinhala = "තන තන තම්දෙන තානත් තෙනා • ගිගුම් දෙමින් වයනා තානම",
      kastiramaSinhala = "කුකුඳ ගජිං ගජිං තොං",
      seerumaruwaSinhala = "තරිකිට තකිට තක ජිං",
      adawwaSinhala = "සිංහ මුඛ මුද්‍රාව සහිත පැනුම් අඩව්ව",
      meaningAndBhava = "කේශර විදහා බිය නැතිව ඇවිදින, දඩයමට සැරසෙන සිංහයාගේ පෞරුෂය. රෞද්‍ර සහ වීර රසය දනවයි."
    ),
    VannamItem(
      number = 7,
      nameSinhala = "උකුසා වන්නම (Ukusa Vannama)",
      animalOrTheme = "අහසේ රවුම් ගසමින් ගොදුරු සොයන උකුස්සා",
      matraCount = "මාත්‍රා 4",
      thalaType = "වේගවත් චලන රිද්මය",
      poemSinhala = "අහස් කුසේ පියාඹනා - ඇස තියුණු ලෙස යොමනා\nඋකුසු රජු සේ නටනා - උකුසා වන්නම සොබනා...",
      thanamaSinhala = "තාන තෙනම් තෙන තානත් තෙයි",
      kastiramaSinhala = "තකිට තිරිකිට කුඳ ජිං",
      seerumaruwaSinhala = "ජිං තොං නං තත් තෙයි",
      adawwaSinhala = "උකුසු පියාපත් චලන අඩව්ව",
      meaningAndBhava = "ක්ෂණිකව පහතට කිමිදෙන, නිය විදහා ගොදුරු ඩැහැගන්නා විලාසය. භයානක හා චංචල භාවය."
    ),
    VannamItem(
      number = 8,
      nameSinhala = "වෛරෝඩි වන්නම (Vairodi Vannama)",
      animalOrTheme = "ඊශ්වර දෙවියන්ගේ වෛරෝඩි මාණික්‍යය හා නැටුම",
      matraCount = "මාත්‍රා 4",
      thalaType = "චතුරශ්‍ර තාලය",
      poemSinhala = "වෛරෝඩි මැණිකක් සේ දිලිසෙන්නේ - ඊශ්වර දෙවිඳුන් රඟ දෙන්නේ\nසකල ලෝ සතුන් පුබුදුවන්නේ - වෛරෝඩි වන්නම පවසන්නේ...",
      thanamaSinhala = "තාන තෙනම් දෙන තානත් තෙයිද තත් තෙයි",
      kastiramaSinhala = "කුකුඳ තකිට දොං ගත තත්",
      seerumaruwaSinhala = "තකිට තකිට ජිං තොං",
      adawwaSinhala = "ඊශ්වර තාණ්ඩව පියවර අඩව්ව",
      meaningAndBhava = "මැණික් කාන්තියෙන් දිලෙන දිව්‍යමය ස්වභාවය සහ ශිව තාණ්ඩවයේ ආනුභාවය. අද්භූත රසය."
    ),
    VannamItem(
      number = 9,
      nameSinhala = "මුසලඩි වන්නම (Musiladi Vannama)",
      animalOrTheme = "සාවාගේ හැසිරීම් (ශශ ජාතකය)",
      matraCount = "මාත්‍රා 3",
      thalaType = "මෘදු පැනුම් රිද්මය",
      poemSinhala = "සාවා පිනුම් ගසනා - තණ කොළ බුදිමින් හිඳිනා\nසඳ මඬලෙහි රුව ඇඳෙනා - මුසලඩි වන්නම දනිනා...",
      thanamaSinhala = "තෙන තෙන තත් තෙයි තෙනම් දෙනා",
      kastiramaSinhala = "කුඳ තකිට තත් තෙයි",
      seerumaruwaSinhala = "ජිං ගත තකිට තෙයි",
      adawwaSinhala = "සාවා පනින රිද්ම අඩව්ව",
      meaningAndBhava = "කන් සොලවමින්, බියෙන් වටපිට බලමින් පනින සාවාගේ අහිංසක සුරතල් විලාසය. හාස්‍ය හා කරුණා රසය."
    ),
    VannamItem(
      number = 10,
      nameSinhala = "ඊරඩිය වන්නම (Eeradiya Vannama)",
      animalOrTheme = "දුනු හී රැගෙන යුධ බිමට වදින සෙබළ විලාසය",
      matraCount = "මාත්‍රා 4",
      thalaType = "යුද රිද්මය",
      poemSinhala = "දුන්නෙන් විදි ඊතලය ලෙසිනා - වේගෙන් සතුරන් වනසමිනා\nවික්‍රම පානා රණබිමිනා - ඊරඩිය වන්නම ගයමිනා...",
      thanamaSinhala = "තාන තෙනම් තෙන තම්දෙන තානත් තෙනා",
      kastiramaSinhala = "තරිකිට තකිට තක ජිං තොං",
      seerumaruwaSinhala = "කුකුඳ තකිට දොං ගත තත් තෙයි",
      adawwaSinhala = "දුන්න අදින හස්ත මුද්‍රා අඩව්ව",
      meaningAndBhava = "දුන්න නමා හී විදින, කඩුව වනන සෙබළුන්ගේ ධෛර්යය. වීර සහ රෞද්‍ර රසය."
    ),
    VannamItem(
      number = 11,
      nameSinhala = "ඌරඟා වන්නම (Uranga Vannama)",
      animalOrTheme = "බිම බඩගා යන උරගයන්ගේ (කටුස්සා/ගෙම්බා/සර්ප) ගමන",
      matraCount = "මාත්‍රා 4",
      thalaType = "මන්දගාමී තාලය",
      poemSinhala = "බඩගා යන උරගුන් සෙයිනා - හිස ඔසවා බිය කරවමිනා\nවිකාර රූපෙන් නටමිනා - ඌරඟා වන්නම සසඳමිනා...",
      thanamaSinhala = "තාන තාන තම්දෙන තානත් තෙයි",
      kastiramaSinhala = "තකිට තිරිකිට කුඳ ජිං",
      seerumaruwaSinhala = "දොං ගත තකිට තත් තෙයි",
      adawwaSinhala = "උරග ඇඹරුම් සහිත පහත් අඩව්ව",
      meaningAndBhava = "ශරීරය බිමට පහත් කර පාද හා කොඳු ඇටය නම්‍යශීලීව හසුරුවන අපූර්ව නර්තනයකි."
    ),
    VannamItem(
      number = 12,
      nameSinhala = "ගනපති වන්නම (Ganapathi Vannama)",
      animalOrTheme = "ගණ දෙවියන් උදෙසා කෙරෙන නමස්කාරය හා ප්‍රශංසාව",
      matraCount = "මාත්‍රා 4",
      thalaType = "භක්ති රිද්මය",
      poemSinhala = "ගණපති දෙවිඳුගෙ පාද නමා - නුවණ වඩන්නට වඳිමු පෙමා\nවිඝ්න දුරු කර සෙත සදමා - ගනපති වන්නම ගයමු තමා...",
      thanamaSinhala = "තාන තෙනම් දෙන තානත් තෙයිද තත් තෙයි",
      kastiramaSinhala = "කුකුඳ තකිට දොං ගත තත්",
      seerumaruwaSinhala = "ජිං තොං නං තත් තෙයි",
      adawwaSinhala = "අංජලී මුද්‍රා සහිත පූජා අඩව්ව",
      meaningAndBhava = "නැණ ගුණ වඩන, බාධක දුරු කරන ගණ දෙවියන්ට බැති සිතින් කරන වැඳුම. ශාන්ත හා භක්ති රසය."
    ),
    VannamItem(
      number = 13,
      nameSinhala = "කොවුලා වන්නම (Kovula Vannama)",
      animalOrTheme = "අවුරුදු සමයේ ගී ගයන කොහා (කොවුලා)",
      matraCount = "මාත්‍රා 3",
      thalaType = "මියුරු ලලිත තාලය",
      poemSinhala = "කොහෝ කොහෝ නද පතුරවනා - ගස් අතු අග පිල් විදහාලා\nවසන්තයේ සිරි ගෙන එන්නා - කොවුලා වන්නම මෙලෙසින්නා...",
      thanamaSinhala = "තෙන තෙන තත් තෙයි තෙනම් දෙනා",
      kastiramaSinhala = "කුඳ තකිට තත් තෙයි",
      seerumaruwaSinhala = "ජිං ගත තකිට තෙයි",
      adawwaSinhala = "කොවුල් තුඩ මුද්‍රා අඩව්ව",
      meaningAndBhava = "මියුරු හඬින් ගයමින් ගසින් ගසට පියාඹන කොවුලාගේ සොඳුරු බව. ශෘංගාර රසය."
    ),
    VannamItem(
      number = 14,
      nameSinhala = "සැවුලා වන්නම (Seula Vannama)",
      animalOrTheme = "කතරගම දෙවිඳුන්ගේ ධජයේ සිටින සැවුලා (කුකුළා)",
      matraCount = "මාත්‍රා 4",
      thalaType = "චංචල වේග තාලය",
      poemSinhala = "කතරගම දෙවි කොඩියෙ රැඳී - සැවුලා අඬලයි පාන්දරේදී\nකරමල් සොලවා නටන සැටී - සැවුලා වන්නම පවසමි මෙහිදී...",
      thanamaSinhala = "තාන තෙනම් තෙන තානත් තෙයි",
      kastiramaSinhala = "තකිට තිරිකිට කුඳ ජිං",
      seerumaruwaSinhala = "ජිං තොං නං තත් තෙයි",
      adawwaSinhala = "තාම්‍රචූඩ මුද්‍රාව සහිත පැනුම් අඩව්ව",
      meaningAndBhava = "කරමල ගසමින්, පියාපත් ගසමින්, උදෑසන හඬලන කුකුළාගේ ඉරියව්. හාස්‍ය හා වීර රසය."
    ),
    VannamItem(
      number = 15,
      nameSinhala = "සුරපති වන්නම (Surapathi Vannama)",
      animalOrTheme = "ශක්‍ර දේවේන්ද්‍රයා සහ සුරපුර සිරි විඳීම",
      matraCount = "මාත්‍රා 4",
      thalaType = "රාජකීය උත්සව තාලය",
      poemSinhala = "සුරපති සක් දෙවිඳුන් වඩිනා - සුරඟන නළඟන පිරිවරානා\nදිව්‍ය සභාවෙහි රඟ දෙවනා - සුරපති වන්නම සිත සදනා...",
      thanamaSinhala = "තාන තෙනම් දෙන තානත් තෙයිද තත් තෙයි",
      kastiramaSinhala = "කුකුඳ තකිට දොං ගත තත්",
      seerumaruwaSinhala = "තරිකිට තකිට තක ජිං",
      adawwaSinhala = "දේව සභා ගම්භීර අඩව්ව",
      meaningAndBhava = "දෙව් රජුගේ මහේශාක්‍ය ලීලාව සහ දිව්‍ය නර්තනයේ අසිරිය. අද්භූත හා ශෘංගාර රසය."
    ),
    VannamItem(
      number = 16,
      nameSinhala = "අසදෘශ වන්නම (Asadrusha Vannama)",
      animalOrTheme = "අසමසම වූ බුදුරජාණන් වහන්සේගේ අනන්ත ගුණ සමුදාය",
      matraCount = "මාත්‍රා 4",
      thalaType = "පාරිශුද්ධ ශාන්ත තාලය",
      poemSinhala = "අසමසම බුදු ගුණ සිතමින්නේ - දෙතිස් මහා පුරිස් ලකුණින්නේ\nලෝ සත සසරින් මුදවන්නේ - අසදෘශ වන්නම පවසන්නේ...",
      thanamaSinhala = "තාන තෙනම් දෙන තානත් තෙයිද තත් තෙයි",
      kastiramaSinhala = "කුකුඳ තකිට දොං ගත තත්",
      seerumaruwaSinhala = "ජිං තොං නං තත් තෙයි",
      adawwaSinhala = "ධර්ම චක්‍ර මුද්‍රා ශාන්ත අඩව්ව",
      meaningAndBhava = "දෙතිස් මහා පුරුෂ ලක්ෂණ සහ බුදුගුණ සිහිපත් කරමින් කෙරෙන ගෞරවනීය නමස්කාරය. ශාන්ත රසය."
    ),
    VannamItem(
      number = 17,
      nameSinhala = "කිරලා වන්නම (Kirala Vannama)",
      animalOrTheme = "බිත්තර රකින කිරල්ලා සහ කිරල් ධේනුව",
      matraCount = "මාත්‍රා 3",
      thalaType = "චංචල රිද්මය",
      poemSinhala = "කිරල්ලා කිරි කිරි නද දෙනවා - බිත්තර රැකගෙන ලතැවෙනවා\nඅහසට පැන පැන කරදර පානා - කිරලා වන්නම මෙලෙසින්නා...",
      thanamaSinhala = "තෙන තෙන තත් තෙයි තෙනම් දෙනා",
      kastiramaSinhala = "කුඳ තකිට තත් තෙයි",
      seerumaruwaSinhala = "ජිං ගත තකිට තෙයි",
      adawwaSinhala = "කිරල් පියාසැරි අඩව්ව",
      meaningAndBhava = "තම බිත්තර ආරක්ෂා කර ගැනීමට විලාප නගමින් සතුරන් මුළා කරන මව් සෙනෙහස. කරුණා හා හාස්‍ය රසය."
    ),
    VannamItem(
      number = 18,
      nameSinhala = "උදාර වන්නම (Udara Vannama)",
      animalOrTheme = "රජුගේ තේජස, කීර්තිය සහ රාජකීය උදාරත්වය",
      matraCount = "මාත්‍රා 4",
      thalaType = "මංගල ධ්වනි තාලය",
      poemSinhala = "උදාර ගුණ ඇති නිරිඳුන්ගේ - යස තේජස ලොව පැතිරෙන්නේ\nජය මංගල සිරි අත්වන්නේ - උදාර වන්නම නිමවන්නේ...",
      thanamaSinhala = "තාන තෙනම් දෙන තානත් තෙයිද තත් තෙයි",
      kastiramaSinhala = "කුකුඳ ගජිං ගජිං තොං",
      seerumaruwaSinhala = "තරිකිට තකිට තක ජිං",
      adawwaSinhala = "ජයග්‍රාහී මංගල මහා අඩව්ව",
      meaningAndBhava = "සෙංකඩගල රජුගේ පාරම්පරික කීර්තිය හා ශ්‍රී විභූතිය වර්ණනා කිරීම. වීර සහ ශෘංගාර රසය."
    )
  )

  // 3. චතුර්විධ අභිනය
  val abhinayas: List<AbhinayaItem> = listOf(
    AbhinayaItem(
      id = "angika",
      nameSinhala = "ආංගික අභිනය (Angika Abhinaya)",
      nameSanskrit = "आङ्गिक अभिनय",
      definition = "නර්තන ශිල්පියාගේ ශරීර අවයව, අංග, ප්‍රත්‍යංග සහ උපාංග චලනය කිරීම මගින් අදහස් හා භාව ප්‍රකාශ කිරීම.",
      components = listOf(
        "අංග (Anga): ප්‍රධාන ශරීර කොටස් 6යි (හිස, දෑත්, ළය, ඉණ, දෙපස, දෙපා)",
        "ප්‍රත්‍යංග (Pratyanga): අනු ශරීර කොටස් 6යි (බෙල්ල, උරහිස්, බඩ, පිට, කලවා, දණහිස්)",
        "උපාංග (Upanga): සියුම් මුහුණේ කොටස් 12යි (ඇස්, ඇහිබැම, ඇහිපිය, නාසය, දෙතොල්, කම්මුල්, නිකට, දත්, දිව ආදිය)"
      ),
      practicalApplication = "මණ්ඩිය පිහිටුවීම, පා සරඹ තැබීම, හස්ත මුද්‍රා දැක්වීම, බැල්ම (දෘෂ්ටි භේද) හැසිරවීම."
    ),
    AbhinayaItem(
      id = "vachika",
      nameSinhala = "වාචික අභිනය (Vachika Abhinaya)",
      nameSanskrit = "वाचिक अभिनय",
      definition = "කටහඬ, ගායනය, කථනය, සාහිත්‍යමය පද්‍ය, තානම් හා දෙබස් උපයෝගී කරගනිමින් භාව ප්‍රකාශ කිරීම.",
      components = listOf(
        "වන්නම් කවි ගායනය සහ තානම ගැයීම",
        "ප්‍රශස්ති සහ අස්නෙ ගායනා",
        "කෝලම් සහ සන්නි යකුමේ එන කවි, සංවාද හා උපහාසාත්මක දෙබස්",
        "ශාන්තිකර්ම යාතිකා සහ ආවැන්දුම්"
      ),
      practicalApplication = "උච්චාරණ පැහැදිලි බව, තාලානුකූල ගායනය, ශෝකය හෝ වීරත්වය මතුවන ලෙස ස්වරය වෙනස් කිරීම."
    ),
    AbhinayaItem(
      id = "aharya",
      nameSinhala = "ආහාර්‍ය අභිනය (Aharya Abhinaya)",
      nameSanskrit = "आहार्य अभिनय",
      definition = "ඇඳුම් පැළඳුම්, ආභරණ, වේශ නිරූපණය, වෙස් මුහුණු සහ රංග භාණ්ඩ මගින් චරිතය නිරූපණය කිරීම.",
      components = listOf(
        "වෙස් ඇඳුම් කට්ටලය (උඩරට සාම්ප්‍රදායික රාජකීය පූජා ඇඳුම)",
        "දෙවොල් ඇඳුම සහ සබරගමු ඇඳුම් කට්ටලය",
        "වෙස් මුහුණු (කෝලම්, සන්නි 18, මහාසෝහොන් වෙස්මුහුණු)",
        "ස්වාභාවික වර්ණ ගැන්වීම් සහ වේශ නිරූපණ ද්‍රව්‍ය (හිරිගල්, සාදිලිංගම්, අඟුරු, රණවරා)",
        "රංග භාණ්ඩ (කඩු, පලිහ, දුනු ඊතල, මල් වට්ටි, තැලි)"
      ),
      practicalApplication = "චරිතයේ ස්වභාවය (රාජකීය, දේව, රාක්ෂ, දුගී) ප්‍රේක්ෂකයාට පළමු බැල්මෙන්ම සන්නිවේදනය කිරීම."
    ),
    AbhinayaItem(
      id = "sattvika",
      nameSinhala = "සාත්ත්වික අභිනය (Sattvika Abhinaya)",
      nameSanskrit = "सात्त्विक अभिनय",
      definition = "බාහිර අංග චලනයකින් තොරව ශිල්පියාගේ මනස තුළ උපදින අව්‍යාජ හැඟීම් හා චිත්තවේග නිසා ශරීරයේ ඉබේ සිදුවන භෞතික වෙනස්වීම් මගින් කෙරෙන අභිනයයි.",
      components = listOf(
        "ස්වේද (දහඩිය දැමීම - බිය හෝ මහන්සිය නිසා)",
        "ස්තම්භ (ගල් ගැසීම / අක්‍රිය වීම - දැඩි කම්පනය නිසා)",
        "වේපථු (වෙව්ලීම - අධික ශීතල, කෝපය හෝ භීතිය නිසා)",
        "අශ්‍රැ (ඇස්වලින් කඳුළු ගැලීම - දැඩි ශෝකය හෝ අධික සතුට නිසා)",
        "වෛවර්ණ්‍ය (මුහුණ සුදුමැලි වීම හෝ රතු වීම)",
        "රෝමාංච (මයිල් කෙළින් වීම - අද්භූත බව හෝ විස්මය නිසා)",
        "ස්වර භේද (කටහඬ බිඳී යාම)",
        "ප්‍රලය (සිහිසුන් වීම / ක්ලාන්ත වීම)"
      ),
      practicalApplication = "උසස්ම මට්ටමේ රංගනයක් බිහිවන්නේ සාත්ත්වික අභිනය චරිතයට මුසු වූ විටය."
    )
  )

  // 4. නවරස සහ ස්ථායී භාව
  val rasas: List<RasaItem> = listOf(
    RasaItem(
      number = 1,
      rasaSinhala = "ශෘංගාර රසය (Shringara)",
      sthayiBhavaSinhala = "රති භාවය (ප්‍රේමය, සෙනෙහස, අලංකාරය)",
      colorAssociation = "ලා කොළ පැහැය (Dark Blue / Green)",
      presidingDeity = "විෂ්ණු දෙවියන්",
      description = "ස්ත්‍රී පුරුෂ ආදරය, ස්වභාව සෞන්දර්යය හා ලාලිත්‍යය ප්‍රකට කරයි. නර්තනයේ මෘදු ලාලිත්‍යය (ලාස්‍ය) බහුලව යොදා ගැනේ.",
      danceExpressionTip = "නෙළුම් මල් නෙළන විලාසය, සිනාමුසු බැල්ම, මෘදු අංග චලන."
    ),
    RasaItem(
      number = 2,
      rasaSinhala = "හාස්‍ය රසය (Hasya)",
      sthayiBhavaSinhala = "හාස භාවය (සිනහව, විහිළුව)",
      colorAssociation = "සුදු පැහැය (White)",
      presidingDeity = "ප්‍රමථ දෙවියන්",
      description = "අවිධිමත් ඇඳුම්, අංග විකාර, නොගැලපෙන කථා සහ විහිළු මගින් සිනහව උපදවයි. පහතරට කෝලම් නැටුම්වල (නොංචි, ජස, දික්පිටියා) ප්‍රධාන රසයයි.",
      danceExpressionTip = "ඇස් කුඩා කිරීම, දෙතොල් විසල් කර සිනාසීම, කකුල් පැටලෙන සේ ගමන් කිරීම."
    ),
    RasaItem(
      number = 3,
      rasaSinhala = "කරුණා රසය (Karuna)",
      sthayiBhavaSinhala = "ශෝක භාවය (දුක, දයාව, අනුකම්පාව)",
      colorAssociation = "අළු පැහැය (Grey)",
      presidingDeity = "යම රජු",
      description = "ආදරණීයයන් වෙන්වීම, විපතට පත්වීම හෝ මරණය නිසා හටගන්නා වේදනාව හා අනුකම්පාව නිරූපණය කෙරේ.",
      danceExpressionTip = "හිස පහත් කිරීම, දෑස් බිමට යොමු කිරීම, ළය අතගෑම, හුස්ම හෙළීම."
    ),
    RasaItem(
      number = 4,
      rasaSinhala = "රෞද්‍ර රසය (Raudra)",
      sthayiBhavaSinhala = "ක්‍රෝධ භාවය (කෝපය, කේන්තිය, පළිගැනීම)",
      colorAssociation = "රතු පැහැය (Red)",
      presidingDeity = "රුද්‍ර (ශිව) දෙවියන්",
      description = "අපහාස, පරාජය හෝ අසාධාරණය නිසා උපදින දැඩි කෝපය. යක්ෂ, අසුර චරිතවල ප්‍රධාන රසයයි.",
      danceExpressionTip = "දෑස් විශාල කර රතු කර ගැනීම, දත් මිටි කෑම, අත් මිට මොළවා ගැසීම, පාද තදින් බිම ගැසීම."
    ),
    RasaItem(
      number = 5,
      rasaSinhala = "වීර රසය (Veera)",
      sthayiBhavaSinhala = "උත්සාහ භාවය (නිර්භීතකම, ධෛර්යය, අධිෂ්ඨානය)",
      colorAssociation = "රන්වන් / තැඹිලි පැහැය (Golden Orange)",
      presidingDeity = "ඉන්ද්‍ර දෙවියන්",
      description = "යුධ බිම ජය ගැනීම, දානය දීම (දාන වීර), ධර්මය රැකීම (ධර්ම වීර) සඳහා වන අභීත පෞරුෂය. උඩරට නැටුමේ මූලික රසයකි.",
      danceExpressionTip = "පපුව ඉදිරියට නෙරා තැබීම, ඍජු තියුණු බැල්ම, වේගවත් හා ශක්තිමත් පියවර."
    ),
    RasaItem(
      number = 6,
      rasaSinhala = "භයානක රසය (Bhayanaka)",
      sthayiBhavaSinhala = "භය භාවය (බිය, භීතිය, තැතිගැන්ම)",
      colorAssociation = "කළු පැහැය (Black)",
      presidingDeity = "කාල දෙවියන්",
      description = "භයානක සතුන්, යක්ෂයන්, මරණය හෝ අනතුරු දුටු විට ඇතිවන චකිතය.",
      danceExpressionTip = "දෑස් එහා මෙහා කරකැවීම, වෙව්ලන අත්, පස්සට පැනීම, ශරීරය හැකිළීම."
    ),
    RasaItem(
      number = 7,
      rasaSinhala = "බීභත්ස රසය (Bibhatsa)",
      sthayiBhavaSinhala = "ජුගුප්සා භාවය (පිළිකුල, අප්‍රසන්න බව)",
      colorAssociation = "නිල් පැහැය (Blue)",
      presidingDeity = "මහාකාල",
      description = "කුණු වූ දේ, ලේ සැරව, අශූචි හෝ අශෝභන දේ දුටු විට සිතේ උපදින පිළිකුල් සහගත බව. දහඅට සන්නියේ ඇතැම් සන්නි වල දැක්වේ.",
      danceExpressionTip = "නාසය හැකිළීම, මුහුණ පැත්තකට හැරවීම, කෙළ ගැසීම වැනි අභිනය."
    ),
    RasaItem(
      number = 8,
      rasaSinhala = "අද්භූත රසය (Adbhuta)",
      sthayiBhavaSinhala = "විස්මය භාවය (පුදුමය, විශ්මයජනක බව)",
      colorAssociation = "කහ පැහැය (Yellow)",
      presidingDeity = "බ්‍රහ්ම දෙවියන්",
      description = "අපූර්ව මායාකාරී සිදුවීම්, දිව්‍යමය දර්ශන හෝ අදහාගත නොහැකි දස්කම් දුටු විට හටගන්නා පුදුමය.",
      danceExpressionTip = "ඇස් විසල් කර උඩ බැලීම, කට මදක් ඇරීම, ඇහිබැම ඉහළට එසවීම."
    ),
    RasaItem(
      number = 9,
      rasaSinhala = "ශාන්ත රසය (Shanta)",
      sthayiBhavaSinhala = "ශම භාවය (මනසේ නිශ්චලතාව, උපශාන්ත බව)",
      colorAssociation = "සුදු සඳුන් පැහැය (Jasmine White)",
      presidingDeity = "නාරායන / බුදුන් වහන්සේ",
      description = "කෙලෙස් සංසිඳී ගිය, සන්සුන්, භාවනානුයෝගී මනසේ පවතින උතුම් නිහඬතාව.",
      danceExpressionTip = "අඩවන් දෑස්, සන්සුන් ශරීර ඉරියව්, මනාව පාලනය වූ හුස්ම ගැනීම."
    )
  )

  // 5. හස්ත මුද්‍රා (අසංයුත සහ සංයුත)
  val mudras: List<MudraItem> = listOf(
    MudraItem(
      id = "pataka",
      nameSinhala = "පතාක හස්තය (Pataka)",
      type = "අසංයුත (තනි අතින්)",
      handShapeDescription = "මාපටැඟිල්ල අත්ල දෙසට මදක් නවා අනෙක් ඇඟිලි හතර එකට තදින් ඍජුව තබා ගැනීම.",
      representations = listOf("කොඩිය", "වනාන්තරය", "ගඟ", "නැවතුම", "ආශීර්වාදය", "සුළඟ", "රාත්‍රිය"),
      shlokaReference = "අභිනය දර්පණයේ ප්‍රථම හස්තයයි."
    ),
    MudraItem(
      id = "tripataka",
      nameSinhala = "ත්‍රිපතාක හස්තය (Tripataka)",
      type = "අසංයුත (තනි අතින්)",
      handShapeDescription = "පතාක හස්තයේ වෙදැඟිල්ල (තුන්වන ඇඟිල්ල) පමණක් ඉදිරියට නැවීම.",
      representations = listOf("කිරුළ (ඔටුන්න)", "ගස", "වජ්‍රායුධය", "ඊතලය", "ගිනි සිළුව"),
      shlokaReference = "දෙවිවරුන් සහ රජවරුන් දැක්වීමට යොදයි."
    ),
    MudraItem(
      id = "mayura",
      nameSinhala = "මයූර හස්තය (Mayura)",
      type = "අසංයුත (තනි අතින්)",
      handShapeDescription = "වෙදැඟිල්ලේ අග මාපටැඟිල්ලේ අගට ස්පර්ශ කර අනෙක් ඇඟිලි විහිදා තැබීම.",
      representations = listOf("මොණරාගේ ගෙල හා පිල්", "ලියුම් ලිවීම", "තිලකය තැබීම", "ලස්සන දේ"),
      shlokaReference = "මයුරා වන්නමේ ප්‍රධාන හස්තයයි."
    ),
    MudraItem(
      id = "sarpashirsha",
      nameSinhala = "සර්පශීර්ෂ හස්තය (Sarpashirsha)",
      type = "අසංයුත (තනි අතින්)",
      handShapeDescription = "පතාක හස්තයේ අත්ල මදක් වළගැසී ඇඟිලි තුඩු ඉදිරියට නමා නාග පෙණයක හැඩය ගැනීම.",
      representations = listOf("නයාගේ පෙණය", "දිය ඉසීම", "ඇත් කුම්භය", "සඳුන් ආලේපය"),
      shlokaReference = "නෛඅඩි වන්නමට හා නාග නැටුමට අත්‍යවශ්‍යයි."
    ),
    MudraItem(
      id = "mushti",
      nameSinhala = "මුෂ්ටි හස්තය (Mushti)",
      type = "අසංයුත (තනි අතින්)",
      handShapeDescription = "ඇඟිලි සතර අත්ල දෙසට තදින් මිට මොළවා ඒ මතින් මාපටැඟිල්ල තැබීම (මිට මෙළවීම).",
      representations = listOf("ගැසීම (පහරදීම)", "කඩුව ඇල්ලීම", "ස්ථිර බව", "ධෛර්යය"),
      shlokaReference = "යුද පෙරමුණ හා වීර රසයට භාවිත වේ."
    ),
    MudraItem(
      id = "shikhara",
      nameSinhala = "ශිඛර හස්තය (Shikhara)",
      type = "අසංයුත (තනි අතින්)",
      handShapeDescription = "මුෂ්ටි හස්තයේ මාපටැඟිල්ල පමණක් ඉහළට ඍජුව එසවීම.",
      representations = listOf("දුන්න ඇදීම", "ප්‍රේම දෙවියා (අනංගයා)", "ශිඛරය (කඳු මුදුන)", "නැතැයි කීම"),
      shlokaReference = "ඊරඩිය වන්නමේ දුන්න දැක්වීමට යොදයි."
    ),
    MudraItem(
      id = "hamsasya",
      nameSinhala = "හංසාස්‍ය හස්තය (Hamsasya)",
      type = "අසංයුත (තනි අතින්)",
      handShapeDescription = "දබරැඟිල්ල, මැදැඟිල්ල සහ මාපටැඟිල්ලේ තුඩු එකට එකතු කර අනෙක් ඇඟිලි දෙක විහිදීම.",
      representations = listOf("හංසයාගේ තුඩ", "නූල ඇදීම", "පබළු ඇමිණීම", "ප්‍රඥාව"),
      shlokaReference = "සියුම් ක්‍රියා දැක්වීමට යොදයි."
    ),
    MudraItem(
      id = "tamrachuda",
      nameSinhala = "තාම්‍රචූඩ හස්තය (Tamrachuda)",
      type = "අසංයුත (තනි අතින්)",
      handShapeDescription = "මුෂ්ටි හස්තයේ දබරැඟිල්ල පමණක් කොක්කක හැඩයට ඉදිරියට නවා තැබීම.",
      representations = listOf("කුකුළාගේ කරමල", "කපුටා", "පක්ෂි තුඩ", "ලියුම් කඩදාසි"),
      shlokaReference = "සැවුලා වන්නමේ කුකුළා පෙන්වීමට යොදයි."
    ),
    MudraItem(
      id = "anjali",
      nameSinhala = "අංජලී හස්තය (Anjali)",
      type = "සංයුත (දෑතින්)",
      handShapeDescription = "පතාක හස්ත දෙකෙහි අත්ල එකිනෙකට තබා ළය මත, නළල මත හෝ හිස මුදුන මත තැබීම.",
      representations = listOf("දෙවියන්ට වැඳීම (හිස මත)", "ගුරුවරුන්ට වැඳීම (මුහුණ ඉදිරියේ)", "මිතුරන්ට ආචාර කිරීම (ළය මත)"),
      shlokaReference = "සියලු ප්‍රසංග ආරම්භයේ හා අවසානයේ නමස්කාරයට භාවිත වේ."
    ),
    MudraItem(
      id = "garuda",
      nameSinhala = "ගරුඩ හස්තය (Garuda)",
      type = "සංයුත (දෑතින්)",
      handShapeDescription = "අත්ල පිටුපස එකිනෙක ස්පර්ශ වන සේ තබා මාපටැඟිලි දෙක එකිනෙක පටලවා අනෙක් ඇඟිලි පියාපත් සේ විහිදීම.",
      representations = listOf("ගුරුළු පක්ෂියා", "විෂ්ණු වාහනය", "විශාල පක්ෂීන්ගේ පියාසැරිය"),
      shlokaReference = "ගුරුළු රාක්ෂ කෝලමට යොදයි."
    )
  )

  // 6. පංචතූර්ය සහ වාද්‍ය භාණ්ඩ
  val instrumentsAndCostumes: List<InstrumentCostumeItem> = listOf(
    InstrumentCostumeItem(
      id = "atatha",
      category = "පංචතූර්ය භාණ්ඩ",
      titleSinhala = "1. ආතත (Athatha)",
      classification = "එක් පැත්තක් පමණක් සම් ආවරණය වූ වාද්‍ය භාණ්ඩ",
      rawMaterials = "ගව හම්, රිදී/පිත්තල බඳ, ලී කඳ",
      detailsSinhala = "තම්මැට්ටම (Tammettama) සහ බුම්මැ Bekkiya (Bummadiya) මෙයට අයත් වේ. තම්මැට්ටමේ දකුණු බෙරය 'මන්දම' (ශබ්දය මෘදුයි) වන අතර වම් බෙරය 'ජිංගිය' (ශබ්දය තීව්‍රයි). කඩිප්පු දෙකකින් වාදනය කෙරේ.",
      ritualSignificance = "පෙරහැරේ හේවිසි පූජාවට සහ පන්සල් චාරිත්‍රවලට අත්‍යවශ්‍ය වේ."
    ),
    InstrumentCostumeItem(
      id = "vithatha",
      category = "පංචතූර්ය භාණ්ඩ",
      titleSinhala = "2. විතත (Vithatha)",
      classification = "දෙපැත්තම සම්වලින් ආවරණය වූ වාද්‍ය භාණ්ඩ",
      rawMaterials = "මී හරක් හම්, වඳුරු හම්, එළු හම්, කොහොඹ ලී",
      detailsSinhala = "ගැටබෙරය (උඩරට), යක්බෙරය (පහතරට) සහ දවුල (සබරගමු) මූලික වේ. දෙපසින්ම නාදය නංවන බැවින් විතත නම් වේ.",
      ritualSignificance = "ත්‍රිවිධ නර්තන සම්ප්‍රදායන්ගේ මූලික රිද්ම භාණ්ඩයි."
    ),
    InstrumentCostumeItem(
      id = "atatha_vithatha",
      category = "පංචතූර්ය භාණ්ඩ",
      titleSinhala = "3. ආතත-විතත (Athatha-Vithatha)",
      classification = "වරපට හෝ නූලෙන් බැඳ අතින් සහ කඩිප්පුවෙන් වාදනය කරන බෙර",
      rawMaterials = "හම්, ලී කඳ, ලෝකඩ වළලු",
      detailsSinhala = "දවුල මෙයට ද අයත් වේ. දකුණු ඇස කඩිප්පුවෙන් ද වම් ඇස අතින් ද වයයි. බෙර ඇස වටා වරපටින් තද කර සුසර කරනු ලබයි.",
      ritualSignificance = "හේවිසි වාදනය, සබරගමු පහන් මඩුව සහ ආගමික පෙරහැර සඳහා භාවිත වේ."
    ),
    InstrumentCostumeItem(
      id = "ghana",
      category = "පංචතූර්ය භාණ්ඩ",
      titleSinhala = "4. ඝන (Ghana)",
      classification = "ලෝහයෙන් නිමවන ලද ඝන වාද්‍ය භාණ්ඩ",
      rawMaterials = "පිත්තල, ලෝකඩ, රිදී",
      detailsSinhala = "තාලම්පට (Thalampata), කයිතාලම්, ඝණ්ඨාර සහ සිලම්බු (ගෙජ්ජි). තාලම්පට මගින් නර්තනයේ කාලය (තාලය) නිවැරදිව පාලනය කරනු ලබයි.",
      ritualSignificance = "නර්තනයේ මූලික රිද්ම තාලය රඳවා තබා ගැනීමට ශිල්පියාට සහ ගායකයාට මගපෙන්වයි."
    ),
    InstrumentCostumeItem(
      id = "susira",
      category = "පංචතූර්ය භාණ්ඩ",
      titleSinhala = "5. සුසිර (Susira)",
      classification = "සුළං පිඹීමෙන් නාදය නංවන සුසිර භාණ්ඩ",
      rawMaterials = "ලෝකඩ, රිදී, උණ බම්බු, හක්බෙල්ලන්",
      detailsSinhala = "හොරණෑව (Horanawa), හක්ගෙඩිය (Hakgediya) සහ වස්දණ්ඩ (Flute). හොරණෑවේ පිත්තල බටය, නලලිය සහ තාලි තහඩුවෙන් සමන්විත වන අතර උපරිම ධ්වනි බලයක් උපදවයි.",
      ritualSignificance = "පෙරහැර ආරම්භය, මංගල පූජා සහ දේව ආරාධනා සඳහා යොදයි."
    ),
    InstrumentCostumeItem(
      id = "ves_costume",
      category = "ඇඳුම් ආයිත්තම්",
      titleSinhala = "උඩරට වෙස් ඇඳුම් කට්ටලය (Ves Costume)",
      classification = "ශාක්‍ය වංශික රාජකීය පූජා ඇඳුම",
      rawMaterials = "රිදී, පිත්තල, පබළු, සුදු සහ රතු කපු රෙදි",
      detailsSinhala = "ශීර්ෂයේ සිට පාදය දක්වා ආවරණය වන ප්‍රධාන ආභරණ: වෙස් තට්ටුව, ජටාව, නෙற்றிමාලය, තොඩෝඩු, අවුල්හැරය, කරපටිය, දේවකරණය, බඳපටිය, හංගලාව, දෙවඟලාව, නෙරිය, කයිමාත්‍ර, සිලම්බු. මුලින් කොහොඹා කංකාරියේ යක්ඇදුමන් සඳහා පමණක් සීමා වී තිබුණි.",
      ritualSignificance = "වෙස් බැඳීමේ මංගල්‍යය (Ves Netuma) මගින් සදාචාර සම්පන්න ශිල්පියෙකු ලෙස සමාජගත කිරීමේ පාරිශුද්ධ සංකේතයයි."
    )
  )

  // 7. ප්‍රායෝගික පරීක්ෂණ සහ Viva Voce මාර්ගෝපදේශය
  val practicalVivaGuides: List<PracticalVivaItem> = listOf(
    PracticalVivaItem(
      id = "mandiya_posture",
      category = "ප්‍රායෝගික සරඹ",
      titleSinhala = "මණ්ඩිය ඉරියව්ව (Mandiya Posture) සහ පා සරඹ",
      marksWeightage = "ලකුණු 15 - 20 (පදනම් කුසලතාව)",
      keyTechniques = listOf(
        "දෙපා අඩ සඳ හැඩයට තබා විලුඹ දෙක අතර අඟල් 4-6ක පරතරයක් තැබීම",
        "දණහිස් දෙපසට මනාව නවා උකුල් ඇට මට්ටමින් ශරීරය පහත් කිරීම",
        "කොඳු ඇට පෙළ ඍජුව තබා පපුව මදක් ඉදිරියට නෙරා හිස සමබරව තබා ගැනීම",
        "දෑත් වැලමිටෙන් නවා පපුව මට්ටමින් මුෂ්ටි හෝ පතාක හස්තයෙන් තැබීම"
      ),
      examinerExpectations = "නැටුම පුරාම මණ්ඩිය ලිහිල් නොවී නොකඩවා පවත්වා ගැනීම, පාද බිම තැබීමේ තාලානුකූල ශබ්දය සහ ශරීර සමබරතාවය.",
      commonMistakesToAvoid = "දණහිස් ඉදිරියට නැවීම (දෙපසට නොනැමීම), කොන්ද නැමීම, පාදවල විලුඹ බිම නොතබා ඇඟිලි තුඩුවලින් පමණක් සිටීම."
    ),
    PracticalVivaItem(
      id = "vannam_performance",
      category = "වන්නම් නර්තන",
      titleSinhala = "වන්නම් ගායනය, තාලය සහ නර්තන රංගනය",
      marksWeightage = "ලකුණු 25 - 30",
      keyTechniques = listOf(
        "වන්නම් කවිය ශ්‍රැතියට හා තාලයට ගැයීම",
        "තානම ගයමින් පියවර තැබීම (තානමට පා තැබීම)",
        "කස්තිරම නිවැරදි තාල රිද්මයෙන් අවසන් කිරීම",
        "සීරුමාරුවේ අලංකාර පා චලන හා භ්‍රමණ",
        "අඩව්වේ අවසන් තීන්දුව (දිමි ත තෙයි තත් තෙයි) නිවැරදිව පෑම"
      ),
      examinerExpectations = "තෝරාගත් වන්නමේ චරිත ලක්ෂණ (උදා: ගජගා නම් ඇතෙකුගේ ගාම්භීරත්වය, මයුරා නම් මොණරෙකුගේ ලාලිත්‍යය) මුහුණෙන් සහ ශරීරයෙන් මතු කිරීම.",
      commonMistakesToAvoid = "කවිය කටපාඩම් නොමැති වීම, තාලය ඉක්මවා වේගවත් වීම, අඩව්ව අවසානයේ මණ්ඩිය අතහැරීම."
    ),
    PracticalVivaItem(
      id = "drum_playing",
      category = "බෙර වාදන",
      titleSinhala = "ගැටබෙර / යක්බෙර / දවුල් වාදනය",
      marksWeightage = "ලකුණු 20",
      keyTechniques = listOf(
        "බෙරය ඉණෙහි නිවැරදි මට්ටමින් බැඳ ගැනීම",
        "ඇස මත ඇඟිලි හසුරුවන නිවැරදි අක්ෂර ශබ්ද (තත්, තෙයි, තොං, නං, ජිං, කුඳ, දොං)",
        "සරඹ වාදනය සහ මාත්‍රා තාල රටා වාදනය",
        "ගීතයකට හෝ නර්තන පියවරකට සහය වාදනය සැපයීම"
      ),
      examinerExpectations = "පිරිසිදු නාදය (Sound Clarity), අත් දෙකෙහි සමබරතාවය, තාලය නොකැඩී පවත්වා ගැනීම.",
      commonMistakesToAvoid = "බෙර ඇස මැදින් නොගසා දාරයට වැදීම, අත් තද කරගෙන වාදනය කිරීම, වේගය පාලනය කරගත නොහැකි වීම."
    ),
    PracticalVivaItem(
      id = "viva_questions",
      category = "Viva වාචික ප්‍රශ්න",
      titleSinhala = "වාචික පරීක්ෂණයේ (Viva Voce) නිතර අසන ප්‍රශ්න 10ක්",
      marksWeightage = "ලකුණු 15 - 20",
      keyTechniques = listOf(
        "ප්‍රශ්නයට පැහැදිලි සිංහලෙන් කෙටි හා නිශ්චිත පිළිතුරක් දීම",
        "පාරිභාෂික වචන (මණ්ඩිය, අඩව්ව, කස්තිරම, ආභරණ) නිවැරදිව උච්චාරණය කිරීම",
        "ශාන්ත හා ආත්මවිශ්වාසී පෞරුෂයකින් විභාග මණ්ඩලයට මුහුණ දීම"
      ),
      examinerExpectations = "විෂය නිර්දේශයේ න්‍යායාත්මක කරුණු ප්‍රායෝගිකව තේරුම් ගෙන තිබේදැයි පරීක්ෂා කිරීම.",
      commonMistakesToAvoid = "නොදන්නා කරුණු අනුමානයෙන් පැවසීම, ප්‍රශ්නය අවසන් වීමට පෙර පිළිතුරු දීම.",
      sampleQuestionAndAnswer = "ප්‍රශ්නය: 'කොහොඹා කංකාරියේ ප්‍රධාන අරමුණ කුමක්ද?'\nපිළිතුර: 'විජය රජුට වැළඳුනු දිවිදෝස (කුවේණියගේ ශාපය නිසා ඇති වූ මානසික හා ශාරීරික රෝගය) සමනය කර රටට සෙත් පැතීමයි.'"
    )
  )

  // 8. O/L විභාග MCQ ප්‍රශ්න (විවරණ සහිතව)
  val mcqQuestions: List<DanceMcqQuestion> = listOf(
    DanceMcqQuestion(
      id = 1,
      grade = "10",
      categoryTag = "සම්ප්‍රදායන් & බෙර",
      questionText = "උඩරට නර්තන සම්ප්‍රදායේ ප්‍රධාන වාද්‍ය භාණ්ඩය වන ගැටබෙරයේ දකුණු ඇස සඳහා යොදාගන්නා හම් වර්ගය කුමක්ද?",
      options = listOf("ගව හම", "වඳුරු හම", "මී හරක් හම", "එළු හම"),
      correctOptionIndex = 1,
      explanation = "ගැටබෙරයේ දකුණු ඇසට (තීව්‍ර නාදය ලබාගැනීමට) වඳුරු හම් යොදන අතර, වම් ඇසට (ගැඹුරු මන්ද්‍ර නාදය ලබාගැනීමට) ගව හම් යොදයි. වරපට සඳහා මී හරක් හම් භාවිත කෙරේ."
    ),
    DanceMcqQuestion(
      id = 2,
      grade = "10",
      categoryTag = "වන්නම් 18",
      questionText = "කන්තක අශ්වයා පිට නැගී සිද්ධාර්ථ කුමරුන් ගිහිගෙය හැර යාමේ පුවත ඇසුරෙන් නිර්මාණය වී ඇති වන්නම කුමක්ද?",
      options = listOf("ගජගා වන්නම", "තුරඟා වන්නම", "සිංහරාජ වන්නම", "අසදෘශ වන්නම"),
      correctOptionIndex = 1,
      explanation = "තුරඟා වන්නම නිර්මාණය වී ඇත්තේ අශ්වයාගේ වේගවත් ගමන සහ කන්තක අශ්වයා පිටින් සිද්ධාර්ථ කුමරුන් අභිනිෂ්ක්‍රමණය කළ ඓතිහාසික සිදුවීම ඇසුරෙනි."
    ),
    DanceMcqQuestion(
      id = 3,
      grade = "11",
      categoryTag = "අභිනය & රස",
      questionText = "භරත මුනිවරයාගේ නාට්‍ය ශාස්ත්‍රයට අනුව 'රති' ස්ථායී භාවයෙන් උපදින ප්‍රධාන රසය කුමක්ද?",
      options = listOf("හාස්‍ය රසය", "ශෘංගාර රසය", "වීර රසය", "කරුණා රසය"),
      correctOptionIndex = 1,
      explanation = "රති භාවය (ප්‍රේමය, ලාලිත්‍යය) මගින් ශෘංගාර රසය උපදී. හාස භාවයෙන් හාස්‍ය රසය ද, උත්සාහ භාවයෙන් වීර රසය ද, ශෝක භාවයෙන් කරුණා රසය ද උපදී."
    ),
    DanceMcqQuestion(
      id = 4,
      grade = "10",
      categoryTag = "හස්ත මුද්‍රා",
      questionText = "පතාක හස්තයේ වෙදැඟිල්ල පමණක් ඉදිරියට නවා තැබීමෙන් සෑදෙන අසංයුත හස්තය කුමක්ද?",
      options = listOf("ත්‍රිපතාක හස්තය", "අර්ධපතාක හස්තය", "මයූර හස්තය", "කර්තරීමුඛ හස්තය"),
      correctOptionIndex = 0,
      explanation = "පතාක හස්තයේ වෙදැඟිල්ල (3 වන ඇඟිල්ල) නැමූ විට 'ත්‍රිපතාක' හස්තය ලැබේ. එයින් ඔටුන්න, ගස, ගිනිසිළුව සහ වජ්‍රායුධය නිරූපණය කෙරේ."
    ),
    DanceMcqQuestion(
      id = 5,
      grade = "11",
      categoryTag = "ශාන්තිකර්ම",
      questionText = "පහතරට ශාන්තිකර්ම සම්ප්‍රදායේ එන 'දහඅට සන්නිය' ශාන්තිකර්මය ප්‍රධාන වශයෙන් පවත්වනු ලබන්නේ කවර අරමුණක් උදෙසාද?",
      options = listOf(
        "ගොවිතැන් සරුසාර කර වැසි ලබා ගැනීමට",
        "ශරීරගත විවිධ රෝගාබාධ ও තුන්දොස් කිපීම් සමනය කර සුවපත් වීමට",
        "යුධ ජයග්‍රහණ සැමරීමට",
        "නව නිවාස ඉදිකිරීමේදී වාස්තු දෝෂ නැති කිරීමට"
      ),
      correctOptionIndex = 1,
      explanation = "දහඅට සන්නිය (කෝල සන්නිය, පිත් සන්නිය, වාත සන්නිය, දෙවොල් සන්නිය ආදී සන්නි 18) පවත්වන්නේ මිනිසාට වැළඳෙන විවිධ ලෙඩ රෝග, යක්ෂ දෝෂ සහ තුන්දොස් සමනය කර සෙත සැලසීමටයි."
    ),
    DanceMcqQuestion(
      id = 6,
      grade = "10",
      categoryTag = "පංචතූර්ය",
      questionText = "පංචතූර්ය වර්ගීකරණයට අනුව තාලම්පට, කයිතාලම් සහ සිලම්බු අයත් වන්නේ කවර වාද්‍ය කාණ්ඩයටද?",
      options = listOf("ආතත", "විතත", "ඝන", "සුසිර"),
      correctOptionIndex = 2,
      explanation = "ලෝහයෙන් තනා තට්ටු කිරීමෙන් හෝ ගැටීමෙන් ශබ්දය නංවන තාලම්පට, කයිතාලම්, ඝණ්ඨාර සහ සිලම්බු 'ඝන' භාණ්ඩ ගණයට අයත් වේ."
    ),
    DanceMcqQuestion(
      id = 7,
      grade = "11",
      categoryTag = "සබරගමු සම්ප්‍රදාය",
      questionText = "සබරගමු නර්තන සම්ප්‍රදායේ ප්‍රධාන ශාන්තිකර්මය වන පහන් මඩුව පවත්වනු ලබන්නේ ප්‍රධාන වශයෙන් කවර දෙවිවරුන් උදෙසාද?",
      options = listOf(
        "සුමන සමන් දෙවියන් සහ පත්තිනි දේවිය",
        "කතරගම දෙවියන් සහ දැඩිමුණ්ඩ දෙවියන්",
        "විෂ්ණු දෙවියන් සහ නාථ දෙවියන්",
        "මහ කොහොඹා දෙවියන්"
      ),
      correctOptionIndex = 0,
      explanation = "සබරගමු පහන් මඩුව ප්‍රධාන වශයෙන් සුමන සමන් දෙවියන් සහ පත්තිනි දේවිය උදෙසා පැවැත්වෙන පාරම්පරික ශාන්තිකර්මයකි."
    ),
    DanceMcqQuestion(
      id = 8,
      grade = "10",
      categoryTag = "ඇඳුම් ආයිත්තම්",
      questionText = "උඩරට වෙස් ඇඳුම් කට්ටලයේ උරහිස් සහ ළය ආවරණය වන සේ පළඳින මනහර පබළු ආභරණය කුමක්ද?",
      options = listOf("කරපටිය", "අවුල්හැරය", "බඳපටිය", "තොඩෝඩු"),
      correctOptionIndex = 1,
      explanation = "අවුල්හැරය යනු උරහිස සහ පපුව වටා වැටෙන සේ පබළු හා රිදී ආභරණවලින් වියන ලද සුවිශේෂී වෙස් ආභරණයකි."
    )
  )

  // 9. O/L විභාග ආදර්ශ රචනා සහ ලකුණු පටිපාටි
  val modelEssays: List<DanceModelEssay> = listOf(
    DanceModelEssay(
      id = "essay_traditions_comparison",
      grade = "10 & 11",
      unitName = "දේශීය නර්තන සම්ප්‍රදායන් සංසන්දනය",
      questionTitle = "ශ්‍රී ලංකාවේ ත්‍රිවිධ දේශීය නර්තන සම්ප්‍රදායන් සහ ඒවායේ සුවිශේෂී අනන්‍යතාව",
      scenarioOrStem = "ශ්‍රී ලංකාවේ පාරම්පරික දේශීය නර්තන කලාව උඩරට, පහතරට සහ සබරගමු යනුවෙන් ත්‍රිවිධ සම්ප්‍රදායකට බෙදී පවතී. මෙම සම්ප්‍රදායන් එකිනෙකට වෙනස් වූ ප්‍රාදේශීය, වාද්‍ය, ඇඳුම් සහ ශාන්තිකර්ම ලක්ෂණවලින් සමන්විතය.",
      subQuestions = listOf(
        DanceEssaySubQuestion(
          numberText = "(i)",
          questionText = "ත්‍රිවිධ නර්තන සම්ප්‍රදායන්ට අයත් ප්‍රධාන බෙර වර්ග තුන සහ ඒවායේ බඳ හැඩයන් නම් කරන්න.",
          marks = 4,
          markingSchemePoints = listOf(
            "උඩරට සම්ප්‍රදාය - ගැටබෙරය (මැද මහත දෙකෙළවර සිහින් බැරල් හැඩය) (ලකුණු 1.5)",
            "පහතරට සම්ප්‍රදාය - යක්බෙරය / දෙවොල් බෙරය (සෘජු සිලින්ඩරාකාර දිගටි හැඩය) (ලකුණු 1.5)",
            "සබරගමු සම්ප්‍රදාය - දවුල (කෙටි මහත සිලින්ඩරාකාර හැඩය) (ලකුණු 1)"
          )
        ),
        DanceEssaySubQuestion(
          numberText = "(ii)",
          questionText = "උඩරට නර්තන සම්ප්‍රදායේ ප්‍රධාන ශාන්තිකර්මය වන කොහොඹා කංකාරියේ ඓතිහාසික පසුබිම හා ප්‍රධාන අංග 3ක් විස්තර කරන්න.",
          marks = 6,
          markingSchemePoints = listOf(
            "ඓතිහාසික පසුබිම: විජය රජුට කුවේණියගේ ශාපයෙන් හටගත් දිවිදෝස සුවපත් කිරීම සඳහා මලේ රජු ලංකාවට ගෙන්වා ප්‍රථම වරට පැවැත්වීම. (ලකුණු 2)",
            "යක්ඇඳුම් පෙළපාලිය - ශාන්තිකර්මයේ පූජනීය ආරම්භය සහ ආවතේව (ලකුණු 1.5)",
            "මලපැනීම - පූජනීය මල් යහන මතින් පැන ශාන්ති පැතීම (ලකුණු 1.5)",
            "මහා කොහොඹා උපත සහ අස්නෙ - සාහිත්‍යමය ගායනා හා පූජා විධි (ලකුණු 1)"
          )
        ),
        DanceEssaySubQuestion(
          numberText = "(iii)",
          questionText = "පහතරට කෝලම් නාට්‍ය සම්ප්‍රදායේ වෙස් මුහුණු භාවිතය සහ එහි අරමුණු පැහැදිලි කරන්න.",
          marks = 5,
          markingSchemePoints = listOf(
            "වෙල්කදුරු ලීයෙන් කැටයම් කර ස්වාභාවික වර්ණ ගන්වා වෙස් මුහුණු තැනීම. (ලකුණු 1.5)",
            "චරිත නිරූපණය පහසු කිරීම (රාක්ෂ, සත්ව, සමාජ හාස්‍ය චරිත - ජස, ලෙන්චිනා, නොංචි). (ලකුණු 1.5)",
            "සමාජ විවේචනය, හාස්‍යය ජනනය කිරීම සහ ප්‍රේක්ෂකයා තුළ විනෝදය ඇති කිරීම. (ලකුණු 2)"
          )
        )
      )
    ),
    DanceModelEssay(
      id = "essay_vannam_system",
      grade = "10 & 11",
      unitName = "උඩරට වන්නම් පද්ධතිය හා නර්තන අංග",
      questionTitle = "උඩරට වන්නම් 18 බිහිවීම, ව්‍යුහය සහ නර්තන අංග විග්‍රහය",
      scenarioOrStem = "මහනුවර යුගයේ ශ්‍රී වීරපරාක්‍රම නරේන්ද්‍රසිංහ රජු දවස ගණිතාලංකාර පඬිවරයා විසින් වන්නම් 18 රචනා කළ බව ජනප්‍රවාදයේ සඳහන් වේ.",
      subQuestions = listOf(
        DanceEssaySubQuestion(
          numberText = "(i)",
          questionText = "උඩරට වන්නමක අන්තර්ගත වන ප්‍රධාන අංග 5 පිළිවෙළින් නම් කර කෙටියෙන් අර්ථ දක්වන්න.",
          marks = 5,
          markingSchemePoints = listOf(
            "1. කවිය (Poem) - වන්නමට පාදක වූ තේමාව හෝ පුරාවෘත්තය ගායනා කිරීම.",
            "2. තානම (Thanama) - 'තන තෙනම් දෙන...' ආදී අක්ෂරවලින් තාලානුකූලව ගැයීම හා පියවර තැබීම.",
            "3. කස්තිරම (Kastirama) - තානමෙන් පසු රිද්මය තීව්‍ර කරන කෙටි තාල කොටස.",
            "4. සීරුමාරුව (Seerumaruwa) - අලංකාර කැරකිලි හා ශරීර ඉරියව්වලින් පියවර මාරු කිරීම.",
            "5. අඩව්ව (Adawwa) - වන්නම අවසන් කරන වේගවත් ප්‍රබල නර්තන හා වාදන පියවර."
          )
        ),
        DanceEssaySubQuestion(
          numberText = "(ii)",
          questionText = "සත්ව ගමන් විලාස පාදක කරගත් වන්නම් 4ක් නම් කර, ඒවායේ නිරූපණය වන සත්ව හැසිරීම් දක්වන්න.",
          marks = 6,
          markingSchemePoints = listOf(
            "ගජගා වන්නම - ඇතුගේ මනහර ගාම්භීර ගමන හා හොඬවැල වැනීම.",
            "තුරඟා වන්නම - අශ්වයා කුර ගසමින් වේගයෙන් දිව යාම.",
            "මයුරා වන්නම - මොණරා පිල් විදහා නටන ලාලිත්‍යය.",
            "නෛඅඩි වන්නම - නයා පෙණ විදහා නළියන සර්ප විලාසය."
          )
        ),
        DanceEssaySubQuestion(
          numberText = "(iii)",
          questionText = "වන්නම් නර්තනයේදී ශිල්පියා සතු විය යුතු ශාරීරික හා මානසික නිපුණතා 4ක් දක්වන්න.",
          marks = 4,
          markingSchemePoints = listOf(
            "මණ්ඩිය නොකඩවා පවත්වා ගැනීමේ ශාරීරික ශක්තිය (Stamina).",
            "කවිය හා තානම තාලයට ගැයීමේ ස්වර නිපුණතාව.",
            "භාව ප්‍රකාශනය (මුහුණේ ඉරියව් හා අභිනය මගින් සත්ව ලක්ෂණ මතු කිරීම).",
            "බෙර වාදකයා සමග මනා රිද්ම සමමුහුර්තතාව (Rhythm synchronization)."
          )
        )
      )
    )
  )

  // 10. විෂය නිර්දේශ ඒකක සටහන් (10 & 11 ශ්‍රේණි)
  val lessonNotes: List<DanceLessonNote> = listOf(
    DanceLessonNote(
      id = "lesson_gr10_01",
      grade = "10",
      unitNumber = 1,
      unitTitle = "දේශීය නර්තන කලාවේ ඓතිහාසික විකාශනය හා පසුබිම",
      coreConcepts = listOf(
        "ප්‍රාග් ඓතිහාසික යුගයේ දඩයම් හා යාග නැටුම්",
        "විජය රජුගේ පැමිණීම සහ කුවේණියගේ කපු කැටීම",
        "දේවානම්පියතිස්ස රජ දවස සංඝමිත්තා තෙරණිය සමග 18 කුලයක ශිල්පීන් පැමිණීම",
        "මහනුවර යුගයේ දළදා පෙරහැර සහ නර්තනයේ ස්වර්ණමය යුගය"
      ),
      summaryText = "ලක්දිව නර්තන කලාව ආගමික වතාවත්, ගොවිතැන හා ශාන්තිකර්ම සමග බද්ධ වෙමින් විකාශනය විය. දළදා පෙරහැර ආරම්භ වීමත් සමග උඩරට, පහතරට සහ සබරගමු සම්ප්‍රදායන්ට රාජ්‍ය අනුග්‍රහය හිමි විය.",
      examFocusPoints = listOf(
        "සංඝමිත්තා තෙරණිය සමග පැමිණි නළාකරුවන් සහ බෙරකරුවන්",
        "මහනුවර යුගයේ රජවරුන් නර්තනයට දැක්වූ අනුග්‍රහය"
      )
    ),
    DanceLessonNote(
      id = "lesson_gr10_02",
      grade = "10",
      unitNumber = 2,
      unitTitle = "මූලික අභ්‍යාස, මණ්ඩිය සහ සරඹ පද්ධතිය",
      coreConcepts = listOf(
        "මණ්ඩිය - නර්තනයේ මව් ඉරියව්ව (Mother posture)",
        "පා සරඹ 12 - පාදවල නම්‍යශීලී බව හා රිද්මය",
        "ගොඩ සරඹ 12 - අත් පා සුසංයෝගය",
        "දණ්ඩ සරඹ සහ කරණම්"
      ),
      summaryText = "නර්තන ශිල්පියෙකු වීමට මූලික පදනම වැටෙන්නේ මණ්ඩිය සහ සරඹ පුහුණුවෙනි. උඩරට, පහතරට සහ සබරගමු යන සම්ප්‍රදායන් ත්‍රිත්වයේම අනන්‍ය වූ සරඹ 12 බැගින් පවතී.",
      examFocusPoints = listOf(
        "මණ්ඩිය නිවැරදිව තබන ආකාරය සහ අංශක",
        "පළමු පා සරඹයේ සහ ගොඩ සරඹයේ තාල රූප"
      )
    ),
    DanceLessonNote(
      id = "lesson_gr11_01",
      grade = "11",
      unitNumber = 1,
      unitTitle = "ශාන්තිකර්ම සාහිත්‍යය, සමාජ කාර්යභාරය හා කොහොඹා කංකාරිය",
      coreConcepts = listOf(
        "ශාන්තිකර්මයක මනෝවිද්‍යාත්මක හා සමාජයීය අරමුණු",
        "කොහොඹා කංකාරියේ යාග මණ්ඩපය, අයිලේ සහ මල් යහන්",
        "යක්ඇඳුම් පෙළපාලිය සහ වෙස් බැඳීමේ චාරිත්‍රය",
        "ගම්මඩුව සහ පහන් මඩුව සංසන්දනය"
      ),
      summaryText = "ශාන්තිකර්ම යනු හුදු නැටුමක් නොව ආයුර්වේදය, මනෝචිකිත්සාව, සාහිත්‍යය, සංගීතය හා සමාජ එකමුතුකම මුසු වූ පූර්ණ සංස්කෘතික මංගල්‍යයකි.",
      examFocusPoints = listOf(
        "කොහොඹා කංකාරියේ ප්‍රධාන පෙළපාලි සහ කතා පුවත්",
        "ශාන්තිකර්මයකින් සමාජයට සිදුවන යහපත"
      )
    ),
    DanceLessonNote(
      id = "lesson_gr11_02",
      grade = "11",
      unitNumber = 2,
      unitTitle = "චතුර්විධ අභිනය, නවරස සහ භරත නාට්‍ය ශාස්ත්‍රය",
      coreConcepts = listOf(
        "ආංගික, වාචික, ආහාර්‍ය සහ සාත්ත්වික අභිනය",
        "නවරස සහ ස්ථායී භාව 9",
        "අසංයුත හස්ත 28 සහ සංයුත හස්ත 24",
        "තාණ්ඩව (පුරුෂ) සහ ලාස්‍ය (ස්ත්‍රී) රංග ලක්ෂණ"
      ),
      summaryText = "නර්තනයේ ආත්මය අභිනයයි. නළු-නිළියන් තම අංග චලනය, කටහඬ, ඇඳුම් සහ අභ්‍යන්තර චිත්තවේග මගින් ප්‍රේක්ෂකයා තුළ රස නිෂ්පත්තිය සිදු කරයි.",
      examFocusPoints = listOf(
        "චතුර්විධ අභිනය උදාහරණ සහිතව විස්තර කිරීම",
        "නවරසවලට අදාළ වර්ණ සහ දෙවිවරුන්"
      )
    )
  )
}
