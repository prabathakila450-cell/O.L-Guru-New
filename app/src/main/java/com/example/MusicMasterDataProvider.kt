package com.example

import androidx.compose.ui.graphics.Color

// ============================================================================
// DATA MODELS FOR GRADE 10 & 11 ORIENTAL MUSIC (සංගීතය) MASTER HUB
// ============================================================================

enum class MusicGradeTab(val labelSinhala: String, val badge: String) {
  ALL("සියල්ල (10 & 11)", "O/L සම්පූර්ණ"),
  GRADE_10("10 ශ්‍රේණිය", "මූලික රාග & තාල"),
  GRADE_11("11 ශ්‍රේණිය", "උසස් රාග & ප්‍රායෝගික")
}

enum class MusicSectionCategory(
  val id: String,
  val titleSinhala: String,
  val subtitle: String,
  val emoji: String,
  val themeColor: Color
) {
  RAGAS_AND_SWARAS("ragas", "රාග & ස්වර පද්ධතිය", "භූපාලි, බිලාවල්, කාෆි, ඛමාජ්, යමන්, භෛරව්...", "🎵", Color(0xFFC026D3)),
  THALAS_AND_LAYA("thalas", "තාල පද්ධතිය & ලයකාරි", "ත්‍රිතාල, ඛහර්වා, දාද්‍රා, රූපක්, ඣප්තාල...", "🥁", Color(0xFF0284C7)),
  FOLK_AND_THEATRE("folk", "දේශීය ජන සංගීතය & නාට්‍ය ගී", "පැල්, කරත්ත, පතල්, ගොයම්, නූර්ති, මනමේ", "🌾", Color(0xFF059669)),
  INSTRUMENTS_AND_VOICE("instruments", "පෙරදිග & දේශීය වාද්‍ය භාණ්ඩ", "තත, සුසිර, ආවනද්ධ, ඝන, තබ්ලාව, තම්බුරාව", "🪕", Color(0xFFD97706)),
  EMINENT_MUSICIANS("musicians", "ප්‍රවීණ සංගීතඥයන් & ඉතිහාසය", "තාන්සේන්, භාත්ඛණ්ඩේ, අමරදේව, සුනිල් ශාන්ත", "🎻", Color(0xFF7C3AED)),
  PRACTICAL_AND_VIVA("practical", "ප්‍රායෝගික පරීක්ෂණ & Viva මාර්ගෝපදේශය", "රාග ගායන, තාල තැබීම, ස්වර හඳුනාගැනීම", "🎙️", Color(0xFFE11D48)),
  EXAM_MCQ_AND_ESSAYS("exams", "O/L MCQs & ආදර්ශ රචනා", "විවරණ සහ නිල ලකුණු පටිපාටි", "🎯", Color(0xFFDC2626)),
  LESSONS_AND_NOTES("lessons", "10 & 11 විෂය නිර්දේශ ඒකක සටහන්", "සම්පූර්ණ කෙටි සටහන් සංග්‍රහය", "📚", Color(0xFF4F46E5)),
  MUSIC_HISTORY_FEATURES("music_history", "සංගීත ඉතිහාස විශේෂාංග", "ඓතිහාසික ශ්‍රවණ, ස්වර ලිපි, ප්‍රසංග...", "📜", Color(0xFF6D28D9))
}

data class RagaItem(
  val id: String,
  val grade: String, // "10" or "11"
  val nameSinhala: String,
  val nameEnglish: String,
  val thaatSinhala: String,
  val jatiSinhala: String, // e.g., "ඕඩව - ඕඩව (5-5)", "සම්පූර්ණ - සම්පූර්ණ (7-7)"
  val arohana: String,
  val avarohana: String,
  val vadiSwara: String,
  val samvadiSwara: String,
  val varjithaSwaras: String,
  val gayanSamaya: String,
  val pakad: String,
  val descriptionAndRasa: String,
  val sampleBandisOrLakshan: String
)

data class ThalaItem(
  val id: String,
  val nameSinhala: String,
  val totalMatras: Int,
  val vibhagDivision: String, // e.g., "4 + 4 + 4 + 4"
  val thaliPositions: String, // e.g., "1, 5, 13 වන මාත්‍රා"
  val khaliPositions: String, // e.g., "9 වන මාත්‍රාව (0)"
  val thekaBols: String,
  val dugunBols: String,
  val chaugunBols: String,
  val usageAndInstruments: String
)

data class FolkTheatreItem(
  val id: String,
  val category: String, // "ජන ගී", "නූර්ති ගී", "නාඩගම් ගී", "නූතන නාට්‍ය ගී"
  val titleSinhala: String,
  val socialContext: String,
  val musicalCharacteristics: List<String>,
  val sampleLyrics: String,
  val historicalSignificance: String
)

data class MusicInstrumentItem(
  val id: String,
  val category: String, // "තත (තන්තු)", "සුසිර (සුළං)", "ආවනද්ධ (සම්)", "ඝන (ලෝහ)"
  val titleSinhala: String,
  val constructionMaterials: String,
  val partsAndTuning: List<String>,
  val playingTechnique: String,
  val roleInPerformance: String
)

data class MusicMusicianItem(
  val id: String,
  val eraOrTradition: String, // "භාරතීය සම්භාව්‍ය", "දේශීය සරල ගී හා ජන සංගීතය"
  val nameSinhala: String,
  val titleOrRole: String,
  val majorContributions: List<String>,
  val famousWorksOrBooks: String,
  val historicalImpact: String
)

data class MusicPracticalVivaItem(
  val id: String,
  val practicalCategory: String, // "රාග ගායනය", "තාල තැබීම", "ස්වර හඳුනාගැනීම", "Viva ප්‍රශ්නෝත්තර"
  val titleSinhala: String,
  val marksWeightage: String,
  val keyTechniques: List<String>,
  val examinerExpectations: String,
  val commonMistakesToAvoid: String,
  val sampleQuestionAndAnswer: String? = null
)

data class MusicMcqQuestion(
  val id: Int,
  val grade: String,
  val categoryTag: String,
  val questionText: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanation: String
)

data class MusicModelEssay(
  val id: String,
  val grade: String,
  val unitName: String,
  val questionTitle: String,
  val scenarioOrStem: String,
  val subQuestions: List<MusicEssaySubQuestion>
)

data class MusicEssaySubQuestion(
  val numberText: String,
  val questionText: String,
  val marks: Int,
  val markingSchemePoints: List<String>
)

data class MusicLessonNote(
  val id: String,
  val grade: String,
  val unitNumber: Int,
  val unitTitle: String,
  val coreConcepts: List<String>,
  val summaryText: String,
  val examFocusPoints: List<String>
)

// ============================================================================
// MUSIC MASTER DATA REPOSITORY
// ============================================================================

object MusicMasterDataProvider {

  // 1. O/L 10 & 11 ප්‍රධාන රාග 8
  val ragas: List<RagaItem> = listOf(
    RagaItem(
      id = "raga_bhoopali",
      grade = "10",
      nameSinhala = "භූපාලි රාගය (Raga Bhoopali)",
      nameEnglish = "Raga Bhoopali",
      thaatSinhala = "කල්‍යාණ් ථාටය (Kalyan Thaat)",
      jatiSinhala = "ඕඩව - ඕඩව (ස්වර 5 - 5)",
      arohana = "ස රි ග ප ධ සඃ (S R G P D S')",
      avarohana = "සඃ ධ ප ග රි ස (S' D P G R S)",
      vadiSwara = "ගාන්ධාරය (ග - G)",
      samvadiSwara = "ධෛවතය (ධ - D)",
      varjithaSwaras = "මධ්‍යමය (ම) සහ නිෂාදය (නි) වර්ජිතයි (ස්වර දෙකම නොයෙදේ)",
      gayanSamaya = "රාත්‍රී පළමු ප්‍රහරය (සවස 6.00 - රාත්‍රී 9.00)",
      pakad = "ග රි ස ධ̣ , ස රි ග , ප ග , ධ ප ග රි ස",
      descriptionAndRasa = "සියලුම ස්වර ශුද්ධ ස්වර වේ. ඉතා ප්‍රශාන්ත, භක්තිමත් සහ සන්සුන් මනෝභාවයක් මතු කරයි. මූලික රාග අතරින් ඉතාම ජනප්‍රිය රාගයකි.",
      sampleBandisOrLakshan = "බණ්ඩිස්: 'සෙලී සුගන්ධ දින රාත්' (ත්‍රිතාලයෙන්) • ස්වරූපය: ග රි ප ග, ධ ප ග රි ස"
    ),
    RagaItem(
      id = "raga_bilawal",
      grade = "10",
      nameSinhala = "බිලාවල් රාගය (Raga Bilawal / Alhaiya Bilawal)",
      nameEnglish = "Raga Bilawal",
      thaatSinhala = "බිලාවල් ථාටය (Bilawal Thaat)",
      jatiSinhala = "සම්පූර්ණ - සම්පූර්ණ (ස්වර 7 - 7)",
      arohana = "ස රි ග ම ප ධ නි සඃ (S R G M P D N S')",
      avarohana = "සඃ නි ධ ප ම ග රි ස (S' N D P M G R S)",
      vadiSwara = "ධෛවතය (ධ - D)",
      samvadiSwara = "ගාන්ධාරය (ග - G)",
      varjithaSwaras = "වර්ජිත ස්වර නැත (ස්වර 7ම යෙදේ)",
      gayanSamaya = "උදෑසන පළමු ප්‍රහරය (දිනෙහි ප්‍රථම ප්‍රහරය)",
      pakad = "ග ප ධ නි සඃ , ධ ප , ම ග , ම රි ස",
      descriptionAndRasa = "භාරතීය සංගීතයේ මූලික ශුද්ධ සප්තකය නියෝජනය කරන රාගයයි. ප්‍රීතිමත්, ප්‍රබෝධවත් හා ශාන්ත රසය උපදවයි.",
      sampleBandisOrLakshan = "ලක්ෂණ ගීතය: 'සප්ත ස්වර ගුන ගායේ' (ත්‍රිතාලයෙන්)"
    ),
    RagaItem(
      id = "raga_kafi",
      grade = "10",
      nameSinhala = "කාෆි රාගය (Raga Kafi)",
      nameEnglish = "Raga Kafi",
      thaatSinhala = "කාෆි ථාටය (Kafi Thaat)",
      jatiSinhala = "සම්පූර්ණ - සම්පූර්ණ (ස්වර 7 - 7)",
      arohana = "ස රි ග̱ ම ප ධ නි̱ සඃ (ග සහ නි කෝමලයි)",
      avarohana = "සඃ නි̱ ධ ප ම ග̱ රි ස (ග සහ නි කෝමලයි)",
      vadiSwara = "පංචමය (ප - P)",
      samvadiSwara = "ෂඩ්ජය (ස - S)",
      varjithaSwaras = "වර්ජිත ස්වර නැත (ගාන්ධාරය සහ නිෂාදය කෝමල වේ)",
      gayanSamaya = "මධ්‍යම රාත්‍රිය (රාත්‍රී තෙවන ප්‍රහරය)",
      pakad = "ස රි රි ග̱ ම ප , ම ප ධ ම ප , ග̱ රි",
      descriptionAndRasa = "ශෘංගාර හා චපල රසය මතු කරයි. හෝලි උත්සව, ධමාර්, ටප්පා සහ දේශීය ජන ගී සඳහා බහුලව ආභාසය ලබා ඇත.",
      sampleBandisOrLakshan = "බණ්ඩිස්: 'ඇයි හෝරි ධූම් මචී' (දෙස් වර්ණනා)"
    ),
    RagaItem(
      id = "raga_khamaj",
      grade = "10",
      nameSinhala = "ඛමාජ් රාගය (Raga Khamaj)",
      nameEnglish = "Raga Khamaj",
      thaatSinhala = "ඛමාජ් ථාටය (Khamaj Thaat)",
      jatiSinhala = "ෂාඩව - සම්පූර්ණ (ආරෝහණයේ 6, අවරෝහණයේ 7)",
      arohana = "ස ග ම ප ධ නි සඃ (ආරෝහණයේ රිෂභය වර්ජිතයි, නිෂාදය ශුද්ධයි)",
      avarohana = "සඃ නි̱ ධ ප ම ග රි ස (අවරෝහණයේ නිෂාදය කෝමලයි)",
      vadiSwara = "ගාන්ධාරය (ග - G)",
      samvadiSwara = "නිෂාදය (නි - N)",
      varjithaSwaras = "ආරෝහණයේදී රිෂභය (රි) වර්ජිත වේ",
      gayanSamaya = "රාත්‍රී දෙවන ප්‍රහරය (රාත්‍රී 9.00 - 12.00)",
      pakad = "නි̱ ධ , ම ප ධ , ම ග",
      descriptionAndRasa = "ශුද්ධ නිෂාදය සහ කෝමල නිෂාදය යන නිෂාද දෙකම යෙදෙන සුවිශේෂී රාගයකි. ශෘංගාර, සෙනෙහස සහ ආදරණීය රසය මවයි.",
      sampleBandisOrLakshan = "බණ්ඩිස්: 'කෝයලියා බොලේ අම්බුවා කී ඩාල' (ත්‍රිතාලයෙන්)"
    ),
    RagaItem(
      id = "raga_yaman",
      grade = "11",
      nameSinhala = "යමන් රාගය (Raga Yaman / Kalyan)",
      nameEnglish = "Raga Yaman",
      thaatSinhala = "කල්‍යාණ් ථාටය (Kalyan Thaat)",
      jatiSinhala = "සම්පූර්ණ - සම්පූර්ණ (නිරෝධයකින් තොරව සප්තකයම)",
      arohana = "නි̣ රි ග ම් ප ධ නි සඃ (මධ්‍යමය තීව්‍ර වේ - ම්)",
      avarohana = "සඃ නි ධ ප ම් ග රි ස (මධ්‍යමය තීව්‍ර වේ - ම්)",
      vadiSwara = "ගාන්ධාරය (ග - G)",
      samvadiSwara = "නිෂාදය (නි - N)",
      varjithaSwaras = "වර්ජිත ස්වර නැත (මධ්‍යමය තීව්‍ර ස්වරයකි - 'ම්')",
      gayanSamaya = "රාත්‍රී ප්‍රථම ප්‍රහරය (සන්ධ්‍යා කාලය)",
      pakad = "නි̣ රි ග රි ස , ප ම් ග රි , නි̣ රි ස",
      descriptionAndRasa = "ඉතා ගාම්භීර, ප්‍රණීත සහ ප්‍රශංසාත්මක රාගයකි. සාමාන්‍යයෙන් ආරෝහණය ආරම්භ වන්නේ මන්ද්‍ර නිෂාදයෙන් (නි̣) වීම විශේෂ ලක්ෂණයකි.",
      sampleBandisOrLakshan = "බණ්ඩිස්: 'ඒරි ආලී පියා බින්' (ත්‍රිතාලයෙන් මධ්‍ය ලය)"
    ),
    RagaItem(
      id = "raga_bhairav",
      grade = "11",
      nameSinhala = "භෛරව් රාගය (Raga Bhairav)",
      nameEnglish = "Raga Bhairav",
      thaatSinhala = "භෛරව් ථාටය (Bhairav Thaat)",
      jatiSinhala = "සම්පූර්ණ - සම්පූර්ණ (ස්වර 7 - 7)",
      arohana = "ස රි̱ ග ම ප ධ̱ නි සඃ (රිෂභය හා ධෛවතය කෝමලයි)",
      avarohana = "සඃ නි ධ̱ ප ම ග රි̱ ස (රිෂභය හා ධෛවතය කෝමලයි)",
      vadiSwara = "ධෛවතය (ධ̱ - D flat)",
      samvadiSwara = "රිෂභය (රි̱ - R flat)",
      varjithaSwaras = "වර්ජිත ස්වර නැත (රි සහ ධ කෝමල වේ, අන්දෝලිත ස්වරයි)",
      gayanSamaya = "පාන්දර අරුණෝදය (ප්‍රභාත කාලය - සවස 4.00 - 7.00 උදෑසන)",
      pakad = "ග ම ධ̱ ධ̱ ප , ම ප ග ම රි̱ රි̱ ස (රි සහ ධ ස්වර දෙදරුම් සහිතව ගායනය)",
      descriptionAndRasa = "ශාන්ත, භක්ති සහ ගාම්භීර රසය මතු කරයි. කෝමල රිෂභය සහ කෝමල ධෛවතය මත කෙරෙන 'අන්දෝලනය' (වෙව්ලීම) රාගයේ ජීවයයි.",
      sampleBandisOrLakshan = "බණ්ඩිස්: 'ජාගෝ මෝහන් ප්‍යාරේ' (උදෑසන අවදිවීමේ භක්ති ගීතය)"
    ),
    RagaItem(
      id = "raga_asavari",
      grade = "11",
      nameSinhala = "අසාවරී රාගය (Raga Asavari)",
      nameEnglish = "Raga Asavari",
      thaatSinhala = "අසාවරී ථාටය (Asavari Thaat)",
      jatiSinhala = "ඕඩව - සම්පූර්ණ (ආරෝහණයේ 5, අවරෝහණයේ 7)",
      arohana = "ස රි ම ප ධ̱ සඃ (ග සහ නි ආරෝහණයේ වර්ජිතයි, ධ කෝමලයි)",
      avarohana = "සඃ නි̱ ධ̱ ප ම ග̱ රි ස (ග, ධ, නි තිදෙනාම කෝමලයි)",
      vadiSwara = "ධෛවතය (ධ̱ - D flat)",
      samvadiSwara = "ගාන්ධාරය (ග̱ - G flat)",
      varjithaSwaras = "ආරෝහණයේදී ගාන්ධාරය (ග) සහ නිෂාදය (නි) වර්ජිත වේ",
      gayanSamaya = "උදෑසන දෙවන ප්‍රහරය (පෙරවරු 9.00 - 12.00)",
      pakad = "ම ප ධ̱ - ප , ම ප ග̱ - රි ස",
      descriptionAndRasa = "කරුණා සහ ශෝකී රසය ප්‍රමුඛ වේ. හදවත කම්පා කරවන ගැඹුරු මනෝභාවයක් ජනනය කරයි.",
      sampleBandisOrLakshan = "ලක්ෂණ ගීතය: 'අසාවරී සුර කෝමල ග ධ නි' (ත්‍රිතාලයෙන්)"
    ),
    RagaItem(
      id = "raga_bageshri",
      grade = "11",
      nameSinhala = "බාගේශ්‍රී රාගය (Raga Bageshri)",
      nameEnglish = "Raga Bageshri",
      thaatSinhala = "කාෆි ථාටය (Kafi Thaat)",
      jatiSinhala = "ඕඩව - සම්පූර්ණ (ආරෝහණයේ 5, අවරෝහණයේ 7)",
      arohana = "ස ග̱ ම ධ නි̱ සඃ (රි සහ ප ආරෝහණයේ වර්ජිතයි, ග සහ නි කෝමලයි)",
      avarohana = "සඃ නි̱ ධ ම ප ධ ග̱ , ම ග̱ රි ස (ග සහ නි කෝමලයි)",
      vadiSwara = "මධ්‍යමය (ම - M)",
      samvadiSwara = "ෂඩ්ජය (ස - S)",
      varjithaSwaras = "ආරෝහණයේදී රිෂභය (රි) සහ පංචමය (ප) වර්ජිත වේ",
      gayanSamaya = "මධ්‍යම රාත්‍රිය (රාත්‍රී තෙවන ප්‍රහරය)",
      pakad = "ස නි̱ ධ̣ ස , ම , ම ප ධ ග̱ ම",
      descriptionAndRasa = "පෙම්වතා එනතුරු බලා සිටින පෙම්වතියගේ විරහ වේදනාව හා ශෘංගාරය නිරූපණය කරන ඉතා මියුරු රාගයකි.",
      sampleBandisOrLakshan = "බණ්ඩිස්: 'කෞන් කරත තෝරි බින්තී' (ද්‍රුත ත්‍රිතාලයෙන්)"
    )
  )

  // 2. තාල පද්ධතිය සහ ලයකාරි
  val thalas: List<ThalaItem> = listOf(
    ThalaItem(
      id = "teental",
      nameSinhala = "ත්‍රිතාලය (Teental)",
      totalMatras = 16,
      vibhagDivision = "4 + 4 + 4 + 4 (අංග 4කි, මාත්‍රා 4 බැගින්)",
      thaliPositions = "1, 5 සහ 13 වන මාත්‍රා (තාලි 3කි)",
      khaliPositions = "9 වන මාත්‍රාව (ඛාලි 1කි - '0')",
      thekaBols = "ධා ධින් ධින් ධා | ධා ධින් ධින් ධා | ධා තින් තින් තා | තා ධින් ධින් ධා",
      dugunBols = "ධාධින් ධින්ධා | ධාධින් ධින්ධා | ධාතින් තින්තා | තාධින් ධින්ධා (එක් මාත්‍රාවකට අක්ෂර 2 බැගින්)",
      chaugunBols = "ධාධින්ධින්ධා ධාධින්ධින්ධා | ධාතින්තින්තා තාධින්ධින්ධා (එක් මාත්‍රාවකට අක්ෂර 4 බැගින්)",
      usageAndInstruments = "උත්තර භාරතීය සංගීතයේ මූලිකම හා ප්‍රධානතම තාලයයි. බණ්ඩිස්, ගීත හා තබ්ලා තනි වාදන සඳහා යොදයි."
    ),
    ThalaItem(
      id = "keherwa",
      nameSinhala = "ඛහර්වා තාලය (Keherwa Thala)",
      totalMatras = 8,
      vibhagDivision = "4 + 4 (අංග 2කි, මාත්‍රා 4 බැගින්)",
      thaliPositions = "1 වන මාත්‍රාව (සම / තාලිය)",
      khaliPositions = "5 වන මාත්‍රාව (ඛාලිය - '0')",
      thekaBols = "ධා ගේ න තිං | න ක ධින් නා",
      dugunBols = "ධාගේ නතිං | නක ධින්නා | ධාගේ නතිං | නක ධින්නා",
      chaugunBols = "ධාගේනතිං නකධින්නා ධාගේනතිං නකධින්නා",
      usageAndInstruments = "සරල ගී, ජන ගී, භජන්, ගසල් සහ නාට්‍ය ගීත සඳහා ලංකාවේ හා ඉන්දියාවේ බහුලවම භාවිත වන රිද්මයයි."
    ),
    ThalaItem(
      id = "dadra",
      nameSinhala = "දාද්‍රා තාලය (Dadra Thala)",
      totalMatras = 6,
      vibhagDivision = "3 + 3 (අංග 2කි, මාත්‍රා 3 බැගින්)",
      thaliPositions = "1 වන මාත්‍රාව (සම / තාලිය)",
      khaliPositions = "4 වන මාත්‍රාව (ඛාලිය - '0')",
      thekaBols = "ධා ධී නා | ධා තී නා",
      dugunBols = "ධාධී නාධා | තීනා ධාධී | නාධා තීනා",
      chaugunBols = "ධාධීනාධා තීනාධාධී නාධාතීනා ධාධීනාධා",
      usageAndInstruments = "තිශ්‍ර ජාතියේ මෘදු, ලාලිත්‍යවත් තාලයකි. සරල ගීත, ප්‍රේම ගීත හා දේශීය කෙළි ගීත සඳහා යොදනු ලැබේ."
    ),
    ThalaItem(
      id = "roopak",
      nameSinhala = "රූපක් තාලය (Roopak Thala)",
      totalMatras = 7,
      vibhagDivision = "3 + 2 + 2 (අංග 3කි)",
      thaliPositions = "4 සහ 6 වන මාත්‍රා (තාලි 2කි)",
      khaliPositions = "1 වන මාත්‍රාව (සම මතම ඛාලිය පිහිටන සුවිශේෂී තාලයයි - '0')",
      thekaBols = "තින් තින් නා | ධී නා | ධී නා",
      dugunBols = "තින්තින් නාධී | නාධී නාතින් | තින්නා ධීනා",
      chaugunBols = "තින්තින්නාධී නාධීනාතින් තින්නාධීනා තින්තින්නාධී",
      usageAndInstruments = "සම මත ඛාලිය වැටෙන එකම තාලයයි. භාවපූර්ණ ගීත, ගසල්, භජන් හා සිතාර් වාදන සඳහා භාවිත වේ."
    ),
    ThalaItem(
      id = "jhaptal",
      nameSinhala = "ඣප්තාලය (Jhaptal)",
      totalMatras = 10,
      vibhagDivision = "2 + 3 + 2 + 3 (අංග 4කි)",
      thaliPositions = "1, 3 සහ 8 වන මාත්‍රා (තාලි 3කි)",
      khaliPositions = "6 වන මාත්‍රාව (ඛාලිය - '0')",
      thekaBols = "ධී නා | ධී ධී නා | තී නා | ධී ධී නා",
      dugunBols = "ධීනා ධීධී | නාතී නාධී | ධීනා ධීනා | ධීධී නාතී | නාධී ධීනා",
      chaugunBols = "ධීනාධීධී නාතීනාධී ධීනාධීනා ධීධීනාතී",
      usageAndInstruments = "ඛණ්ඩ ජාතියට අයත් ගාම්භීර තාලයකි. මධ්‍ය ලය ඛයාල් ගායනය සහ සිතාර්, සරෝද් වාදනයට යොදයි."
    ),
    ThalaItem(
      id = "ektal",
      nameSinhala = "ඒක්තාලය (Ektal)",
      totalMatras = 12,
      vibhagDivision = "2 + 2 + 2 + 2 + 2 + 2 (අංග 6කි, මාත්‍රා 2 බැගින්)",
      thaliPositions = "1, 5, 9, 11 වන මාත්‍රා (තාලි 4කි)",
      khaliPositions = "3 සහ 7 වන මාත්‍රා (ඛාලි 2කි)",
      thekaBols = "ධින් ධින් | ධාගේ තිරිකිට | තූ නා | කත් තා | ධාගේ තිරිකිට | ධී නා",
      dugunBols = "ධින්ධින් ධාගේ | තිරිකිටතූ නා | කත්තා ධාගේ | තිරිකිටධී නා",
      chaugunBols = "ධින්ධින්ධාගේතිරිකිටතූනා කත්තාධාගේතිරිකිටධීනා",
      usageAndInstruments = "විලම්බිත ඛයාල් (මන්දගාමී උසස් ශාස්ත්‍රීය ගායනා) සහ ද්‍රුත තාරානා සඳහා යොදාගන්නා සම්භාව්‍ය තාලයකි."
    )
  )

  // 3. දේශීය ජන සංගීතය සහ නාට්‍ය ගීත කලාව
  val folkAndTheatre: List<FolkTheatreItem> = listOf(
    FolkTheatreItem(
      id = "pel_kavi",
      category = "ජන ගී",
      titleSinhala = "පැල් කවි (Pel Kavi)",
      socialContext = "වන සතුන්ගෙන් ගොයම ආරක්ෂා කර ගැනීම සඳහා රාත්‍රී කාලයේ පැලට වී නිදි වර්ජිතව සිටි ගැමියා තනිකම හා බිය දුරු කර ගැනීමට ගැයූ කවි.",
      musicalCharacteristics = listOf(
        "ස්වර 3ක් හෝ 4ක් අතර දෝලනය වන සරල තනු නිර්මාණය",
        "දීර්ඝ ඇදීම් (Melismatic singing) සහ රාත්‍රී නිශ්චලතාව බිඳින උස් හඬ",
        "කරුණා හා විරහ රසය මතු වීම",
        "මාත්‍රා තාල රහිතව (අනියත රිද්මයෙන්) නිදහසේ ගායනා කිරීම"
      ),
      sampleLyrics = "පැලේ පැලී පැල්පත් වල ලගින්නා\nමලේ මලී රොන් ගෙන බැඳ තබන්නා\nබලේ බලී ගොන් බැඳලා මඩින්නා\nදුලේ දුලී සිරිපතුල වඳින්නා...",
      historicalSignificance = "ගැමි ජන ජීවිතයේ දුෂ්කරතාවය හා ආගමික භක්තිය මුසු වූ අව්‍යාජ නිර්මාණයකි."
    ),
    FolkTheatreItem(
      id = "karattha_kavi",
      category = "ජන ගී",
      titleSinhala = "කරත්ත කවි (Karattha Kavi)",
      socialContext = "ඈත දුෂ්කර ප්‍රදේශවල සිට භාණ්ඩ ප්‍රවාහනය කළ කරත්තකරුවන් මහා මග තනිකම, මහන්සිය හා ගවයන්ගේ විඩාව සමනය කිරීමට ගැයූ කවි.",
      musicalCharacteristics = listOf(
        "කරත්තයේ රෝදය කැරකෙන රිද්මයට සහ ගව කුර හඬට අනුගත වූ ඇදෙනසුළු ගායන විලාසය",
        "දීර්ඝ ස්වර ඇදීම (ස්වරය අගට 'ඒ... ඉ...' ආදී අක්ෂර එක් කිරීම)",
        "ගවයා කෙරෙහි උපන් අනුකම්පාව හා ජීවන අරගලය තේමා වීම"
      ),
      sampleLyrics = "තණ්ඩලේ දෙන්නා දෙපලේ බැඳලා\nකටුකැලේ ගාලේ නොලිහා බැඳලා\nපිටබැඳි ගෝනි දෙපලේ හෙලලා\nසක්වල ගලක් වාගෙයි මට ගාල දැකලා...",
      historicalSignificance = "ලාංකේය ප්‍රවාහන ඉතිහාසය සහ ගැමියාගේ පාරිසරික බැඳීම විදහා දක්වයි."
    ),
    FolkTheatreItem(
      id = "nurthi_geetha",
      category = "නූර්ති ගී",
      titleSinhala = "නූර්ති ගීත කලාව (Nurthi Geetha)",
      socialContext = "19 වන සියවසේ අගභාගයේ ඉන්දියාවෙන් පැමිණි පාර්සි නාට්‍ය කණ්ඩායම් ආභාසයෙන් නීතිඥ ජෝන් ද සිල්වා මැතිඳුන් විසින් ආරම්භ කරන ලද නාට්‍ය ගීත සම්ප්‍රදාය.",
      musicalCharacteristics = listOf(
        "උත්තර භාරතීය රාගධාරී තනු ආශ්‍රයෙන් නිර්මාණය වීම (විශ්වනාත් ලෞජි සංගීතඥයාගේ දායකත්වය)",
        "දේශානුරාගය, බෞද්ධ ඉතිහාසය හා ආගමික භක්තිය තේමා වීම",
        "හාමෝනියම් හා තබ්ලා වාදනය මූලික වීම",
        "පැහැදිලි ස්වර ලිපි සහ තාල රටා සහිත වීම"
      ),
      sampleLyrics = "දන්නෝ බුදුන්ගේ ශ්‍රී ධර්මස්කන්ධා\nපේවී රකිති සොඳ සීලෙ නිබන්දා\nක්ලේශ මලාදී කෙලෙසުން දුරැන්දා\nනමදිති මුනිඳුගෙ පාද අරවින්දා... (සිරිසඟබෝ නාට්‍යය)",
      historicalSignificance = "සිංහල නාට්‍ය සංගීතයේ ශාස්ත්‍රීය යුගයක ආරම්භය සනිටුහන් කළ අතර ජාතික පුනරුදයට මහා බලපෑමක් කළේය."
    ),
    FolkTheatreItem(
      id = "nadagam_geetha",
      category = "නාඩගම් ගී",
      titleSinhala = "නාඩගම් ගීත සහ සින්දු (Nadagam Geetha)",
      socialContext = "දකුණු ඉන්දීය 'තෙරුක්කුත්තු' ආභාසයෙන් දහඅට වන සියවසේදී පිලිප්පු සිංඤෝ ආදී ශිල්පීන් විසින් බිහිකළ මුල්ම දේශීය නාට්‍ය විශේෂය.",
      musicalCharacteristics = listOf(
        "මද්දල (Maddala) වාද්‍ය භාණ්ඩය සහ හොරණෑව මූලික වීම",
        "පොතේ ගුරු විසින් කථාව ඉදිරිපත් කිරීම සහ චරිත පැමිණෙන විට 'සින්දු' ගායනා කිරීම",
        "කර්ණාටක සංගීතයේ තාල හා රාග ආභාසය",
        "විශේෂිත ආරම්භක ස්වරූපය: 'ඉලංදාරියා, අන්න බලන් සකි...'"
      ),
      sampleLyrics = "බාල ගිරිරාජ යස තේජා සිරින්නා\nලෝක ගුරු පාද මම නමස්කාර පෙම්නා...",
      historicalSignificance = "සිංහල නාට්‍ය කලාවේ පළමු මුද්‍රා නාට්‍යමය පදනම වූ අතර මනමේ නාට්‍යයට පදනම සැපයීය."
    )
  )

  // 4. පෙරදිග සහ දේශීය වාද්‍ය භාණ්ඩ
  val instruments: List<MusicInstrumentItem> = listOf(
    MusicInstrumentItem(
      id = "tanpura",
      category = "තත (තන්තු)",
      titleSinhala = "තම්බුරාව (Tanpura / Tambura)",
      constructionMaterials = "ලබු ගෙඩිය (Toomba), තේක්ක හෝ තුන් ලී කඳ, ලෝකඩ හා යකඩ තන්තු 4ක්.",
      partsAndTuning = listOf(
        "පළමු තන්තුව (මන්ද්‍ර ස්වරය): 'ප' ස්වරයට (පංචමයට) සුසර කෙරේ. (පංචමය වර්ජිත රාගවලදී 'ම' හෝ 'නි' ට සුසර කරයි)",
        "දෙවන හා තෙවන තන්තු (ජෝඩ් තන්තු): මධ්‍ය 'ස' ස්වරයට සුසර කෙරේ.",
        "සිව්වන තන්තුව (ඝන තන්තුව): මන්ද්‍ර 'ස' ස්වරයට සුසර කෙරේ.",
        "ජවාරි (Javari): තන්තු සහ පාලම අතර නූල් කැබැල්ලක් තබා ධ්වනි නාදය (Buzzing tone) ලබා ගැනීම."
      ),
      playingTechnique = "දකුණු අතේ ඇඟිලි තුඩුවලින් තන්තු 1, 2, 3, 4 පිළිවෙළින් මෘදුව පහළට පිරිමැදීමෙන් අඛණ්ඩ නාද පසුබිමක් (Drone) මවයි.",
      roleInPerformance = "ගායකයාට හෝ වාදකයාට තම ස්වර ශ්‍රැතිය (Pitch) ස්ථාවරව රඳවා ගැනීමට අවශ්‍ය පදනම් නාදය සපයයි."
    ),
    MusicInstrumentItem(
      id = "tabla",
      category = "ආවනද්ධ (සම්)",
      titleSinhala = "තබ්ලාව (Tabla - දායා සහ බායා)",
      constructionMaterials = "දායා (දකුණු බෙරය): සිසූ හෝ රෝස්වුඩ් ලීයෙන් තනයි. බායා (වම් ඩග්ගාව): මැටි හෝ තඹ/පිත්තල ලෝහයෙන් තනයි.",
      partsAndTuning = listOf(
        "සියාහි (Siyahi): බෙර ඇස මැද ඇති කළු පාට තට්ටුව (යකඩ කුඩු හා බත් මුසු මිශ්‍රණය) - නාදය මධුර කරයි.",
        "මෛදාන් (Maidan): සියාහිය සහ චාන්ටිය අතර ඇති හිස් සම් කොටස.",
        "චාන්ටි / කිනාර් (Chati): බෙර ඇසේ පිටත දාරය.",
        "බද්දි (Baddi): හම් පටි සහ ගට්ටා (ලී කුට්ටි) - තබ්ලාව 'ස' ස්වරයට සුසර කිරීමට මිටියෙන් තට්ටු කරයි."
      ),
      playingTechnique = "දෑතේ ඇඟිලි සහ අත්ල මනාව හසුරුවමින් 'ධා, ධින්, තින්, තා, නා, තිට්, ත්‍රක' ආදී අක්ෂර නංවයි.",
      roleInPerformance = "උත්තර භාරතීය සංගීතයේ ප්‍රධානතම රිද්ම වාද්‍ය භාණ්ඩය වන අතර ගායන, වාදන හා නර්තන සඳහා සහය වේ."
    ),
    MusicInstrumentItem(
      id = "sitar",
      category = "තත (තන්තු)",
      titleSinhala = "සිතාරය (Sitar)",
      constructionMaterials = "වියළි ලබු කබල, තේක්ක ලී දණ්ඩ, පිත්තල පර්දා (Frets) 16-24, තන්තු 18-21.",
      partsAndTuning = listOf(
        "බාජ් තන්තුව (ප්‍රධාන වාදන තන්තුව): මන්ද්‍ර 'ම' ස්වරයට සුසර කරයි.",
        "ජෝඩ් හා ඛරජ් තන්තු: 'ස' සහ 'ප' ස්වරවලට.",
        "චිකාරී තන්තු (ඉහළ ශබ්දය): තාර 'ස' ස්වරයට.",
        "තරබ් තන්තු (අනුනාද තන්තු 11-13): වාදනය වන රාගයේ ස්වරවලට අනුනාද වේ."
      ),
      playingTechnique = "දකුණු අතේ දබරැඟිල්ලට මිස්රාබ් (Mizrab) නම් ලෝහ කටුව දමා තන්තු පීඩනය කරමින් 'මීර්ඩ්' (ස්වර ඇදීම) ගනී.",
      roleInPerformance = "ලෝකයේ අතිශය ජනප්‍රියම භාරතීය තන්තු වාද්‍ය භාණ්ඩයයි. පණ්ඩිත් රවි ශංකර් විසින් ජාත්‍යන්තරයට ගෙන යන ලදී."
    ),
    MusicInstrumentItem(
      id = "bansuri",
      category = "සුසිර (සුළං)",
      titleSinhala = "බන්සූරිය / උණ බටනලාව (Bansuri)",
      constructionMaterials = "සුවිශේෂී උණ බම්බු විශේෂයකින් (Assam Bamboo) සාදනු ලබයි.",
      partsAndTuning = listOf(
        "පිඹින සිදුර (Blow hole / Embouchure)",
        "ස්වර සිදුරු 6ක් හෝ 7ක් (Finger holes)",
        "බටයේ දිග හා විශ්කම්භය අනුව ශ්‍රැතිය (C, D, E ආදී) තීරණය වේ."
      ),
      playingTechnique = "තොල් මගින් සුළං ධාරාව සිදුර දෙසට කෝණිකව යොමු කරමින් ඇඟිලි තුඩුවලින් සිදුරු අර්ධ වශයෙන් හෝ පූර්ණව වසා ස්වර නංවයි.",
      roleInPerformance = "ශ්‍රී ක්‍රිෂ්ණ දෙවියන්ගේ පූජනීය වාද්‍ය භාණ්ඩය ලෙස සැලකෙන අතර ප්‍රශාන්ත, ස්වාභාවික නාදයක් ලබාදෙයි."
    )
  )

  // 5. ප්‍රවීණ සංගීතඥයන් සහ සංගීත ඉතිහාසය
  val musicians: List<MusicMusicianItem> = listOf(
    MusicMusicianItem(
      id = "pandit_amaradeva",
      eraOrTradition = "දේශීය සරල ගී හා නූතන සංගීතය",
      nameSinhala = "පණ්ඩිත් ඩබ්ලිව්. ඩී. අමරදේව (Pandit W. D. Amaradeva, 1927 - 2016)",
      titleOrRole = "ශ්‍රී ලංකාවේ අසහාය සංගීත කලාපති / හෙළයේ මහා ගාන්ධර්වයා",
      majorContributions = listOf(
        "උත්තර භාරතීය රාගධාරී සංගීතය සහ ලාංකේය ජන නාද රටා සුසංයෝග කර දේශීය සරල ගී සම්ප්‍රදායක් බිහි කිරීම",
        "භාත්ඛණ්ඩේ සංගීත විද්‍යාපීඨයෙන් 'සංගීත විශාරද' සහ 'සංගීත වාද්‍ය විශාරද' (වයලීන) සම්මාන ලැබීම",
        "මහාචාර්ය එදිරිවීර සරච්චන්ද්‍රයන්ගේ 'මනමේ' නාට්‍යයේ සංගීතයට සහය වීම",
        "ජාත්‍යන්තර මැග්සේසේ සම්මානය සහ පද්මශ්‍රී සම්මානයෙන් පිදුම් ලැබීම"
      ),
      famousWorksOrBooks = "ගීත: 'සන්නාලියනේ', 'ශාන්ත මේ රෑ යාමේ', 'කුමාරියක පා සළඹ සැලුනා', 'පිලේ පැදුර', 'රත්නදීප ජන්මභූමි'",
      historicalImpact = "ශ්‍රී ලාංකේය අනන්‍යතාවයෙන් යුත් ශාස්ත්‍රීය හා සරල සංගීත යුගයක නිර්මාතෘවරයාය."
    ),
    MusicMusicianItem(
      id = "miyan_tansen",
      eraOrTradition = "භාරතීය සම්භාව්‍ය සංගීතය (මෝගල් යුගය)",
      nameSinhala = "මියාන් තාන්සේන් (Miyan Tansen, 1506 - 1589)",
      titleOrRole = "අක්බර් අධිරාජ්‍යයාගේ සභාවේ සිටි 'නවරත්න' වලින් එකක් වූ ශ්‍රේෂ්ඨ සංගීතඥයා",
      majorContributions = listOf(
        "ධෲපද් (Dhrupad) ගායන සම්ප්‍රදායේ මුදුන්මල්කඩ වීම",
        "නව රාග නිර්මාණය කිරීම (දර්බාරි කානඩා, මියාන් කි තෝඩි, මියාන් කි මල්හාර්, මියාන් කි සාරං)",
        "රාග දීපක් ගයා පහන් දැල්වූ බවත්, රාග මේඝ මල්හාර් ගයා වැසි වැස්සවූ බවත් සඳහන් ජනප්‍රවාද"
      ),
      famousWorksOrBooks = "සංගීත සාර, රාග මාලා ග්‍රන්ථ",
      historicalImpact = "උත්තර භාරතීය සංගීතයේ තාක්ෂණික හා ගායන පදනම දැමූ පීතෘවරයෙකි."
    ),
    MusicMusicianItem(
      id = "pandit_bhatkhande",
      eraOrTradition = "භාරතීය සංගීත ශාස්ත්‍රය (20 වන සියවස)",
      nameSinhala = "පණ්ඩිත් විෂ්ණු නාරායන භාත්ඛණ්ඩේ (Pandit V. N. Bhatkhande, 1860 - 1936)",
      titleOrRole = "නූතන උත්තර භාරතීය සංගීත න්‍යාය සංවිධානය කළ මහා පඬිවරයා",
      majorContributions = listOf(
        "උත්තර භාරතීය රාග සිය ගණනක් 'ථාට 10ක්' යටතට වර්ගීකරණය කිරීම (බිලාවල්, කල්‍යාණ්, ඛමාජ්, කාෆි, භෛරව්, භෛරවී, අසාවරී, තෝඩි, පූර්වී, මාරවා)",
        "භාත්ඛණ්ඩේ ස්වර ලිපි ක්‍රමය (Notation system) හඳුන්වා දීම",
        "ලක්නව්හි 'මොරිස් කොලීජිය' (වර්තමාන භාත්ඛණ්ඩේ සංස්කෘති විශ්වවිද්‍යාලය) පිහිටුවීම"
      ),
      famousWorksOrBooks = "ක්‍රමික් පුස්තක් මාලිකා (වෙළුම් 6), ශ්‍රීමන් ලක්ෂ්‍ය සංගීතම්",
      historicalImpact = "ශ්‍රී ලංකාවේ පාසල් හා විශ්වවිද්‍යාල සංගීත විෂය නිර්දේශයේ පදනම භාත්ඛණ්ඩේ පද්ධතියයි."
    ),
    MusicMusicianItem(
      id = "sunil_santha",
      eraOrTradition = "දේශීය හෙළ ගීත කලාව",
      nameSinhala = "සුනිල් ශාන්ත (Sunil Santha, 1915 - 1981)",
      titleOrRole = "ස්වතන්ත්‍ර දේශීය සංගීත සම්ප්‍රදායක පුරෝගාමියා",
      majorContributions = listOf(
        "ශාන්තිනිකේතනයෙන් සහ භාත්ඛණ්ඩේ විද්‍යාපීඨයෙන් සංගීතය හදාරා පැමිණ උත්තර භාරතීය අනුකරණයෙන් මිදී හෙළ බසට ගැලපෙන ස්වාභාවික ගීත කලාවක් බිහි කිරීම",
        "ස්වර 3-4 ආශ්‍රයෙන් අතිශය මියුරු සරල තනු නිර්මාණය කිරීම",
        "හෙළ හවුලේ මුනිදාස කුමාරතුංගයන් සමග එක්ව සිංහල භාෂාවේ මාධුර්යය ඉස්මතු කිරීම"
      ),
      famousWorksOrBooks = "ගීත: 'ඕලු පිපීලා', 'හඳපානේ වැලි තලා', 'මිහිකත නලවාලා', 'දකුණ නැගෙනහිර', 'බෝවිටියා දං'",
      historicalImpact = "ලක්දිව ස්වතන්ත්‍ර ගීත සම්ප්‍රදායක නිර්භීත ආරම්භකයා ලෙස ඉතිහාසගත වේ."
    )
  )

  // 6. O/L ප්‍රායෝගික පරීක්ෂණ සහ Viva Voce මාර්ගෝපදේශය
  val practicalVivaGuides: List<MusicPracticalVivaItem> = listOf(
    MusicPracticalVivaItem(
      id = "raga_singing_technique",
      practicalCategory = "රාග ගායනය",
      titleSinhala = "රාග ගායනය හා වාදනය (Raga Performance)",
      marksWeightage = "ලකුණු 25 - 30 (ප්‍රධාන ප්‍රායෝගික අංශය)",
      keyTechniques = listOf(
        "තම්බුරාවේ 'ස' ශ්‍රැතියට තම කටහඬ නිවැරදිව මුසු කිරීම (Pitch matching)",
        "ආරෝහණ සහ අවරෝහණ ස්වර ශුද්ධව හා කෝමල/තීව්‍ර ලක්ෂණ සහිතව ගැයීම",
        "රාගයේ පකඩ (Pakad) හෙවත් ප්‍රධාන ස්වරූපය මතු වන සේ අලාප ගැයීම",
        "තෝරාගත් බණ්ඩිසයේ ස්ථාවරය සහ අන්තරාව තාලයට (උදා: ත්‍රිතාලයට) ගායනා කිරීම",
        "තාන් 2ක් හෝ 3ක් නිවැරදි ලයෙන් ඉදිරිපත් කර සමට ('X') පැමිණීම"
      ),
      examinerExpectations = "ස්වර ශ්‍රැතියෙන් බැහැර නොවීම (අපස්වර නොවීම), තාලය නොකැඩීම, රාගයේ නිවැරදි මනෝභාවය මුහුණෙන් හා හඬින් මතු කිරීම.",
      commonMistakesToAvoid = "කෝමල ස්වර ශුද්ධ ස්වර ලෙස ගැයීම (උදා: කාෆි රාගයේ 'ග' සහ 'නි' ශුද්ධ වීම), බණ්ඩිසයේ අන්තරාව අමතක වීම, සම ලකුණු කිරීමට අසමත් වීම."
    ),
    MusicPracticalVivaItem(
      id = "thala_keeping",
      practicalCategory = "තාල තැබීම",
      titleSinhala = "අත්පුඩි හා ඛාලි මගින් තාල තැබීම (Thala Demonstration)",
      marksWeightage = "ලකුණු 15 - 20",
      keyTechniques = listOf(
        "තාලයේ සම ('X'), තාලි (අත්පුඩි) සහ ඛාලි (අත පැත්තට දැමීම) නිවැරදි මාත්‍රාවලදී පෙන්වීම",
        "මුඛයෙන් තාල බෝල් පැහැදිලිව උච්චාරණය කරමින් අත්පුඩි ගැසීම",
        "තනි ගුණය (ථහ්) සහ දෙගුණය (දුගුන්) එකම ලයකින් (Steady tempo) පවත්වා ගැනීම",
        "රූපක් තාලයේදී 1 වන මාත්‍රාව ඛාලියෙන් පෙන්වීම"
      ),
      examinerExpectations = "අත්පුඩි ගැසීමේ නිශ්චිතභාවය, ලය වෙනස් නොවී තබා ගැනීම, තාල බෝල් නිවැරදිව කටපාඩමින් කීම.",
      commonMistakesToAvoid = "දෙගුණය (දුගුන්) කියන විට අත්පුඩි වේගවත් කිරීම (අත්පුඩි ලය නොවෙනස්ව තබා ගත යුතුය, බෝල් පමණක් දෙගුණ වේ)."
    ),
    MusicPracticalVivaItem(
      id = "swara_identification",
      practicalCategory = "ස්වර හඳුනාගැනීම",
      titleSinhala = "ශ්‍රවණය මගින් ස්වර හා රාග හඳුනාගැනීම (Ear Training)",
      marksWeightage = "ලකුණු 10 - 15",
      keyTechniques = listOf(
        "පරීක්ෂකවරයා හාමෝනියම් හෝ වයලීනයෙන් වයන ස්වර ඛණ්ඩයක ස්වර නිවැරදිව හඳුනා ගැනීම (උදා: ස රි ග, ප ධ සඃ)",
        "වාදනය වන ස්වර රටාව ඇසුරෙන් අදාළ රාගය නම් කිරීම (උදා: 'ග රි ප ග' ඇසුණු විට භූපාලි බව හඳුනා ගැනීම)",
        "තීව්‍ර මධ්‍යමය (ම්) සහ කෝමල ස්වර ශ්‍රවණයෙන් වෙන් කර හඳුනාගැනීම"
      ),
      examinerExpectations = "ස්වර ස්ථාන පිළිබඳ මනා ශ්‍රවණ පුහුණුවක් (Aural skills) පැවතීම.",
      commonMistakesToAvoid = "කලබල වී ඉක්මනින් වැරදි ස්වර පැවසීම, සාපේක්ෂ ස්වර පරතරය කෙරෙහි අවධානය යොමු නොකිරීම."
    ),
    MusicPracticalVivaItem(
      id = "viva_qa_bank",
      practicalCategory = "Viva ප්‍රශ්නෝත්තර",
      titleSinhala = "ප්‍රායෝගික විභාග මණ්ඩලයේදී (Viva Voce) නිතර අසන ප්‍රශ්න 10ක්",
      marksWeightage = "ලකුණු 15 - 20",
      keyTechniques = listOf(
        "ප්‍රශ්නයට කෙටි, නිශ්චිත හා පැහැදිලි පිළිතුරක් දීම",
        "සංගීත පාරිභාෂික වචන (වාදී, සංවාදී, ථාටය, පකඩ, ජවාරි) නිවැරදිව භාවිත කිරීම",
        "විශ්වාසවන්ත හා ගෞරවනීය ඉරියව්වකින් විභාග මණ්ඩලයට මුහුණ දීම"
      ),
      examinerExpectations = "විෂය නිර්දේශයේ න්‍යාය කරුණු ප්‍රායෝගික සංගීතය සමග සම්බන්ධ කර තේරුම් ගෙන තිබේදැයි විමසීම.",
      commonMistakesToAvoid = "නොදන්නා කරුණු අනුමාන කර වැරදි තොරතුරු දීම.",
      sampleQuestionAndAnswer = "ප්‍රශ්නය: 'භූපාලි රාගයේ වාදී සහ සංවාදී ස්වර මොනවාද?'\nපිළිතුර: 'වාදී ස්වරය ගාන්ධාරය (ග) වන අතර සංවාදී ස්වරය ධෛවතය (ධ) වේ.'"
    )
  )

  // 7. O/L විභාග බහුවරණ (MCQs)
  val mcqQuestions: List<MusicMcqQuestion> = listOf(
    MusicMcqQuestion(
      id = 1,
      grade = "10",
      categoryTag = "රාග න්‍යාය",
      questionText = "භූපාලි රාගයේ වර්ජිත වන ස්වර යුගලය කුමක්ද?",
      options = listOf("රිෂභය සහ ධෛවතය", "මධ්‍යමය සහ නිෂාදය", "ගාන්ධාරය සහ නිෂාදය", "මධ්‍යමය සහ පංචමය"),
      correctOptionIndex = 1,
      explanation = "භූපාලි රාගයේ ආරෝහණයේදී මෙන්ම අවරෝහණයේදී ද මධ්‍යමය (ම) සහ නිෂාදය (නි) යන ස්වර දෙකම වර්ජිත වේ (ඕඩව - ඕඩව ජාතිය)."
    ),
    MusicMcqQuestion(
      id = 2,
      grade = "10",
      categoryTag = "තාල පද්ධතිය",
      questionText = "මාත්‍රා 16කින් සමන්විත වන අතර 9 වන මාත්‍රාවෙහි ඛාලිය පිහිටන ප්‍රධාන උත්තර භාරතීය තාලය කුමක්ද?",
      options = listOf("ඒක්තාලය", "ඛහර්වා තාලය", "ත්‍රිතාලය (Teental)", "ඣප්තාලය"),
      correctOptionIndex = 2,
      explanation = "ත්‍රිතාලය (Teental) මාත්‍රා 16කින්, මාත්‍රා 4 බැගින් වූ අංග 4කින් යුක්ත වන අතර 1, 5, 13 මාත්‍රාවල තාලි ද 9 වන මාත්‍රාවේ ඛාලිය ද පිහිටයි."
    ),
    MusicMcqQuestion(
      id = 3,
      grade = "11",
      categoryTag = "ස්වර න්‍යාය",
      questionText = "යමන් (කල්‍යාණ්) රාගයේ යෙදෙන එකම විකෘති ස්වරය කුමක්ද?",
      options = listOf("කෝමල රිෂභය", "තීව්‍ර මධ්‍යමය (ම්)", "කෝමල ගාන්ධාරය", "කෝමල නිෂාදය"),
      correctOptionIndex = 1,
      explanation = "යමන් රාගයේ අනෙක් සියලුම ස්වර ශුද්ධ වන අතර මධ්‍යමය (ම) පමණක් 'තීව්‍ර මධ්‍යමය' (ම් - Tivra Madhyam) ලෙස යෙදේ."
    ),
    MusicMcqQuestion(
      id = 4,
      grade = "10",
      categoryTag = "ජන සංගීතය",
      questionText = "'තණ්ඩලේ දෙන්නා දෙපලේ බැඳලා' යනුවෙන් ආරම්භ වන ජන කවි අයත් වන්නේ කවර ජන ගී කාණ්ඩයටද?",
      options = listOf("පැල් කවි", "ගොයම් කවි", "කරත්ත කවි", "පතල් කවි"),
      correctOptionIndex = 2,
      explanation = "ගවයන් බැඳ කරත්ත දක්කමින් දුෂ්කර මග ගමන් ගත් ගැමියන් ගැයූ සුප්‍රකට කවියක් ලෙස 'කරත්ත කවි' හැඳින්වේ."
    ),
    MusicMcqQuestion(
      id = 5,
      grade = "11",
      categoryTag = "තාල පද්ධතිය",
      questionText = "සම ('X') මතම ඛාලිය ('0') පිහිටන සුවිශේෂී උත්තර භාරතීය තාලය කුමක්ද?",
      options = listOf("දාද්‍රා තාලය", "රූපක් තාලය", "ඛහර්වා තාලය", "ත්‍රිතාලය"),
      correctOptionIndex = 1,
      explanation = "රූපක් තාලය (මාත්‍රා 7) ආරම්භ වන්නේම ඛාලියෙනි (1 වන මාත්‍රාව ඛාලිය වන අතර 4 සහ 6 මාත්‍රාවල තාලි පිහිටයි)."
    ),
    MusicMcqQuestion(
      id = 6,
      grade = "10",
      categoryTag = "වාද්‍ය භාණ්ඩ",
      questionText = "තම්බුරාවේ පළමු තන්තුව සාමාන්‍යයෙන් සුසර කරනු ලබන්නේ කවර ස්වරයටද?",
      options = listOf("මධ්‍ය ස", "මන්ද්‍ර ප (පංචමය)", "තාර ස", "මධ්‍ය ග"),
      correctOptionIndex = 1,
      explanation = "තම්බුරාවේ 1 වන තන්තුව මන්ද්‍ර 'ප' (පංචමයට) ද, 2 සහ 3 ජෝඩ් තන්තු මධ්‍ය 'ස' ට ද, 4 වන තන්තුව මන්ද්‍ර 'ස' ට ද සුසර කෙරේ."
    ),
    MusicMcqQuestion(
      id = 7,
      grade = "11",
      categoryTag = "ප්‍රවීණ සංගීතඥයන්",
      questionText = "උත්තර භාරතීය රාග සියල්ල ථාට 10ක් යටතට ක්‍රමවත්ව වර්ගීකරණය කළ මහා සංගීත පඬිවරයා කවුද?",
      options = listOf("මියාන් තාන්සේන්", "පණ්ඩිත් විෂ්ණු නාරායන භාත්ඛණ්ඩේ", "පණ්ඩිත් රවි ශංකර්", "අමීර් ඛුස්රෝ"),
      correctOptionIndex = 1,
      explanation = "පණ්ඩිත් විෂ්ණු නාරායන භාත්ඛණ්ඩේ මැතිඳුන් විසින් උත්තර භාරතීය රාග ථාට 10ක් (බිලාවල්, කල්‍යාණ්, ඛමාජ් ආදී) යටතට වර්ග කර ස්වර ලිපි ක්‍රමය හඳුන්වා දෙන ලදී."
    ),
    MusicMcqQuestion(
      id = 8,
      grade = "10",
      categoryTag = "නූර්ති ගී",
      questionText = "'දන්නෝ බුදුන්ගේ ශ්‍රී ධර්මස්කන්ධා' නූර්ති ගීතය ඇතුළත් වන්නේ නීතිඥ ජෝන් ද සිල්වා මැතිඳුන්ගේ කවර නාට්‍යයේද?",
      options = listOf("වෙස්සන්තර නාට්‍යය", "සිරිසඟබෝ නාට්‍යය", "මනමේ නාට්‍යය", "දුටුගැමුණු නාට්‍යය"),
      correctOptionIndex = 1,
      explanation = "'දන්නෝ බුදුන්ගේ' ගීතය ජෝන් ද සිල්වා මැතිඳුන්ගේ 'සිරිසඟබෝ' නූර්ති නාට්‍යය සඳහා විශ්වනාත් ලෞජි විසින් තනු නිර්මාණය කරන ලද්දකි."
    )
  )

  // 8. O/L විභාග ආදර්ශ රචනා සහ ලකුණු පටිපාටි
  val modelEssays: List<MusicModelEssay> = listOf(
    MusicModelEssay(
      id = "essay_raga_comparison",
      grade = "10 & 11",
      unitName = "රාගධාරී සංගීත න්‍යාය සහ රාග සංසන්දනය",
      questionTitle = "භූපාලි රාගය සහ යමන් රාගය සංසන්දනාත්මකව විග්‍රහ කිරීම",
      scenarioOrStem = "භූපාලි සහ යමන් යන රාග ද්විත්වයම කල්‍යාණ් ථාටයට අයත් වුවද, ඒවායේ ජාතිය, ස්වර භාවිතය සහ ගායන විලාසය අනුව එකිනෙකට හාත්පසින්ම වෙනස් කලාත්මක ස්වරූපයක් ගනී.",
      subQuestions = listOf(
        MusicEssaySubQuestion(
          numberText = "(i)",
          questionText = "භූපාලි රාගයේ සහ යමන් රාගයේ ථාටය, ජාතිය, වාදී සහ සංවාදී ස්වර වගුවකින් දක්වන්න.",
          marks = 4,
          markingSchemePoints = listOf(
            "භූපාලි: කල්‍යාණ් ථාටය • ඕඩව-ඕඩව ජාතිය • වාදී 'ග' • සංවාදී 'ධ' (ලකුණු 2)",
            "යමන්: කල්‍යාණ් ථාටය • සම්පූර්ණ-සම්පූර්ණ ජාතිය • වාදී 'ග' • සංවාදී 'නි' (ලකුණු 2)"
          )
        ),
        MusicEssaySubQuestion(
          numberText = "(ii)",
          questionText = "මෙම රාග දෙකෙහි ආරෝහණ, අවරෝහණ සහ යෙදෙන ස්වරවල ඇති වෙනස්කම් පැහැදිලි කරන්න.",
          marks = 6,
          markingSchemePoints = listOf(
            "භූපාලි: ස රි ග ප ධ සඃ / සඃ ධ ප ග රි ස (ම සහ නි වර්ජිතයි, සියලු ස්වර ශුද්ධයි). (ලකුණු 3)",
            "යමන්: නි̣ රි ග ම් ප ධ නි සඃ / සඃ නි ධ ප ම් ග රි ස (මධ්‍යමය තීව්‍ර 'ම්' වේ, ස්වර 7ම යෙදේ, ආරෝහණය මන්ද්‍ර නිෂාදයෙන් පටන් ගනී). (ලකුණු 3)"
          )
        ),
        MusicEssaySubQuestion(
          numberText = "(iii)",
          questionText = "රාගයක 'වාදී' සහ 'සංවාදී' ස්වර යනු මොනවාදැයි අර්ථ දක්වා ඒවායේ වැදගත්කම සඳහන් කරන්න.",
          marks = 5,
          markingSchemePoints = listOf(
            "වාදී ස්වරය (රජු වැනි ස්වරය): රාගයක නිතරම යෙදෙන, වැඩිම අවධානයක් ගන්නා ප්‍රධානතම ස්වරයයි. (ලකුණු 2.5)",
            "සංවාදී ස්වරය (ඇමති වැනි ස්වරය): වාදී ස්වරයට පමණක් දෙවැනි වන, රාගයට සහය දෙන දෙවන ප්‍රධාන ස්වරයයි. (ලකුණු 2.5)"
          )
        )
      )
    ),
    MusicModelEssay(
      id = "essay_thala_system",
      grade = "10 & 11",
      unitName = "තාල පද්ධතිය, ලය සහ තබ්ලා වාදනය",
      questionTitle = "ත්‍රිතාලය සහ ඛහර්වා තාලයේ අංග, බෝල් සහ ලයකාරි විග්‍රහය",
      scenarioOrStem = "සංගීතයේ කාලය මනින ඒකකය තාලයයි. තාලය මත පදනම්ව ගායකයා සහ වාදකයා අතර මනා රිද්ම සමමුහුර්තතාවක් ගොඩනැගේ.",
      subQuestions = listOf(
        MusicEssaySubQuestion(
          numberText = "(i)",
          questionText = "ත්‍රිතාලයේ මාත්‍රා සංඛ්‍යාව, අංග බෙදීම, තාලි සහ ඛාලි පිහිටන ස්ථාන විස්තර කරන්න.",
          marks = 4,
          markingSchemePoints = listOf(
            "මාත්‍රා 16කි • අංග 4කි (4+4+4+4). (ලකුණු 2)",
            "තාලි 3කි (1, 5, 13 වන මාත්‍රාවල) • ඛාලි 1කි (9 වන මාත්‍රාවේ). (ලකුණු 2)"
          )
        ),
        MusicEssaySubQuestion(
          numberText = "(ii)",
          questionText = "ඛහර්වා තාලයේ ඨේකා බෝල් (Theka) ලියා, එහි තනිගුණය (ථහ්) සහ දෙගුණය (දුගුන්) ස්වර ලිපි ක්‍රමයට දක්වන්න.",
          marks = 6,
          markingSchemePoints = listOf(
            "ඨේකා බෝල්: ධා ගේ න තිං | න ක ධින් නා (මාත්‍රා 8). (ලකුණු 2)",
            "තනිගුණය: 1=ධා, 2=ගේ, 3=න, 4=තිං | 5=න, 6=ක, 7=ධින්, 8=නා. (ලකුණු 2)",
            "දෙගුණය (දුගුන්): එක් මාත්‍රාවකට අක්ෂර 2 බැගින් (ධාගේ නතිං නක ධින්නා). (ලකුණු 2)"
          )
        ),
        MusicEssaySubQuestion(
          numberText = "(iii)",
          questionText = "තබ්ලාවේ දායා සහ බායා හි 'සියාහි' (Siyahi) කොටසෙහි වැදගත්කම සහ සුසර කිරීමේ ක්‍රමය පැහැදිලි කරන්න.",
          marks = 5,
          markingSchemePoints = listOf(
            "සියාහි (කළු තට්ටුව): යකඩ කුඩු, මැලියම් හා බත් මිශ්‍රණයකින් සාදනු ලබන අතර නාදයේ ගම්භීරත්වය හා ශ්‍රැතිය මධුර කිරීමට උපකාරී වේ. (ලකුණු 2.5)",
            "සුසර කිරීම: ගට්ටා (ලී කුට්ටි) වලට හා ගජරා දාරයට පිත්තල මිටියකින් තට්ටු කරමින් ගායකයාගේ 'ස' ස්වරයට සුසර කරයි. (ලකුණු 2.5)"
          )
        )
      )
    )
  )

  // 9. විෂය නිර්දේශ ඒකක සටහන් (10 & 11 ශ්‍රේණි)
  val lessonNotes: List<MusicLessonNote> = listOf(
    MusicLessonNote(
      id = "music_lesson_gr10_01",
      grade = "10",
      unitNumber = 1,
      unitTitle = "නාදය, ස්වර න්‍යාය, ශ්‍රැති සහ සප්තක පද්ධතිය",
      coreConcepts = listOf(
        "නාදය: ආහත (පහරදීමෙන් හටගන්නා) සහ අනාහත (ස්වභාවික නිහඬ) නාදය",
        "ශ්‍රැති 22 සහ ශුද්ධ ස්වර 7, විකෘති ස්වර 5 (කෝමල 4, තීව්‍ර 1)",
        "සප්තක 3: මන්ද්‍ර (යටි තිත්), මධ්‍ය (තිත් රහිත), තාර (උඩි තිත්)",
        "ථාට 10 පද්ධතිය සහ රාග ජනක න්‍යාය"
      ),
      summaryText = "සංගීතයේ භෞතික හා කලාත්මක පදනම නාදයයි. සංගීතයට යොදාගන්නා නාදය 'ස්වර' වන අතර සප්තකය තුළින් රාග දහස් ගණනක් බිහි වේ.",
      examFocusPoints = listOf(
        "කෝමල සහ තීව්‍ර ස්වර ලකුණු කරන ආකාරය",
        "නාදයේ ප්‍රධාන ලක්ෂණ 3 (උස-පහත් බව, ප්‍රබල-දුබල බව, ගුණාංගය)"
      )
    ),
    MusicLessonNote(
      id = "music_lesson_gr10_02",
      grade = "10",
      unitNumber = 2,
      unitTitle = "10 ශ්‍රේණියේ රාග 4: භූපාලි, බිලාවල්, කාෆි, ඛමාජ්",
      coreConcepts = listOf(
        "භූපාලි: කල්‍යාණ් ථාටය, ඕඩව-ඕඩව, ම සහ නි වර්ජිතයි, වාදී ග, සංවාදී ධ",
        "බිලාවල්: බිලාවල් ථාටය, සම්පූර්ණ-සම්පූර්ණ, සියලු ස්වර ශුද්ධයි",
        "කාෆි: කාෆි ථාටය, ග සහ නි කෝමලයි, වාදී ප, සංවාදී ස",
        "ඛමාජ්: ඛමාජ් ථාටය, ආරෝහණයේ රි වර්ජිතයි, අවරෝහණයේ නි කෝමලයි"
      ),
      summaryText = "මෙම රාග 4 අධ්‍යයනයෙන් ශිල්පියාට ශුද්ධ ස්වර මෙන්ම කෝමල ස්වර නිවැරදිව භාවිත කිරීමේ මූලික ශික්ෂණය ලැබේ.",
      examFocusPoints = listOf(
        "රාග 4 හි වාදී සහ සංවාදී ස්වර වගුව",
        "පකඩ ඇසුරෙන් රාගය හඳුනාගැනීම"
      )
    ),
    MusicLessonNote(
      id = "music_lesson_gr11_01",
      grade = "11",
      unitNumber = 1,
      unitTitle = "11 ශ්‍රේණියේ උසස් රාග 4: යමන්, භෛරව්, අසාවරී, බාගේශ්‍රී",
      coreConcepts = listOf(
        "යමන්: තීව්‍ර මධ්‍යමය (ම්), සන්ධ්‍යා කාලයේ ගායනය",
        "භෛරව්: රි සහ ධ කෝමලයි, ප්‍රභාත (පාන්දර) කාලය, අන්දෝලිත ස්වර",
        "අසාවරී: ග, ධ, නි කෝමලයි, කරුණා රසය, උදෑසන ගායනය",
        "බාගේශ්‍රී: ග සහ නි කෝමලයි, මධ්‍යම රාත්‍රී ගායනය, වාදී ම, සංවාදී ස"
      ),
      summaryText = "11 ශ්‍රේණියේ රාග විකෘති ස්වර සංකලනයෙන් වඩාත් සංකීර්ණ හා ගැඹුරු රස ජනනය කරන උසස් ශාස්ත්‍රීය රාගයන් වේ.",
      examFocusPoints = listOf(
        "යමන් සහ භූපාලි අතර වෙනස්කම්",
        "භෛරව් රාගයේ අන්දෝලනය"
      )
    ),
    MusicLessonNote(
      id = "music_lesson_gr11_02",
      grade = "11",
      unitNumber = 2,
      unitTitle = "දේශීය ජන සංගීතය, නූර්ති/නාඩගම් සහ ශ්‍රී ලාංකේය සංගීත ඉතිහාසය",
      coreConcepts = listOf(
        "පැල්, කරත්ත, පතල්, ගොයම් කවිවල තනු හා සමාජ පසුබිම",
        "නූර්ති ගී (ජෝන් ද සිල්වා, විශ්වනාත් ලෞජි) සහ නාඩගම් සින්දු",
        "පණ්ඩිත් අමරදේව සහ සුනිල් ශාන්තයන්ගේ දායකත්වය",
        "තම්බුරාව සහ තබ්ලාව වාදනය හා සුසර කිරීම"
      ),
      summaryText = "ශ්‍රී ලංකාවේ සංගීතය ජන කවියේ සිට රාගධාරී නූර්තිය දක්වාත්, එතැනින් නූතන දේශීය සරල ගීතය දක්වාත් විකාශනය වූ අයුරු විග්‍රහ කෙරේ.",
      examFocusPoints = listOf(
        "ජන ගීවල සංගීතමය ලක්ෂණ",
        "පණ්ඩිත් අමරදේවයන්ගේ මෙහෙවර"
      )
    )
  )
}
