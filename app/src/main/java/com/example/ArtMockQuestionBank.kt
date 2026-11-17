package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.normalizeOption
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * Art (චිත්‍ර කලාව) Question Bank for Live Exam Hall (Grades 10 & 11 O/L).
 * Combines ArtMasterDataProvider (MCQs + Heritage + World Art + Elements + Practicals),
 * QuizBankApplied art (10), curated Color Theory/Sri Lankan Sculptures/World Renaissance MCQs,
 * SubjectMasterArt (1,500+ multi-angle), and ShortAnswer Art (400 G10+G11).
 */
object ArtMockQuestionBank {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2600)

    // 1. ArtMasterDataProvider MCQs
    for (mcq in ArtMasterDataProvider.mcqQuestions) {
      val opts = mcq.options.map { normalizeOption(it) }
      if (opts.size >= 4) {
        val idx = mcq.correctOptionIndex.coerceIn(0, opts.lastIndex)
        raw.add(
          QSpec(
            topic = mcq.categoryTag,
            questionText = mcq.questionText,
            correct = opts[idx],
            distractors = opts.filterIndexed { i, _ -> i != idx },
            explanation = mcq.explanation
          )
        )
      }
    }

    // 2. Derived QSpecs from heritageItems, worldArtItems, elementsAndRules, practicalGuides
    val heritage = ArtMasterDataProvider.heritageItems
    if (heritage.size >= 4) {
      for ((i, h) in heritage.withIndex()) {
        raw.add(
          QSpec(
            topic = "දේශීය කලා උරුමය - ${h.eraOrSchool}",
            questionText = "${h.titleSinhala} නිර්මාණය අයත් වන කලා යුගය හෝ සම්ප්‍රදාය කුමක්ද?",
            correct = h.eraOrSchool,
            distractors = listOf(
              heritage[(i + 1) % heritage.size].eraOrSchool,
              heritage[(i + 2) % heritage.size].eraOrSchool,
              heritage[(i + 3) % heritage.size].eraOrSchool
            ),
            explanation = "${h.titleSinhala} (${h.location}) — ${h.artisticSignificance}"
          )
        )
        raw.add(
          QSpec(
            topic = "දේශීය කලා උරුමය",
            questionText = "'${h.titleSinhala}' කලා නිර්මාණය පිහිටා ඇති ස්ථානය කුමක්ද?",
            correct = h.location,
            distractors = listOf(
              heritage[(i + 1) % heritage.size].location,
              heritage[(i + 2) % heritage.size].location,
              heritage[(i + 3) % heritage.size].location
            ),
            explanation = "මාධ්‍යය: ${h.mediumAndTechnique} — අනුග්‍රහය: ${h.historicalPatronage}"
          )
        )
        raw.add(
          QSpec(
            topic = "දේශීය කලා ශිල්පීය මාධ්‍ය",
            questionText = "${h.titleSinhala} නිර්මාණයේදී භාවිත කළ ප්‍රධාන මාධ්‍යය හා ශිල්පීය ක්‍රමය කුමක්ද?",
            correct = h.mediumAndTechnique,
            distractors = listOf(
              heritage[(i + 1) % heritage.size].mediumAndTechnique,
              heritage[(i + 2) % heritage.size].mediumAndTechnique,
              heritage[(i + 3) % heritage.size].mediumAndTechnique
            ),
            explanation = h.artisticSignificance
          )
        )
      }
    }

    val worldArt = ArtMasterDataProvider.worldArtItems
    if (worldArt.size >= 4) {
      for ((i, w) in worldArt.withIndex()) {
        val sampleWork = w.famousArtworks.firstOrNull().orEmpty()
        if (sampleWork.isNotBlank()) {
          raw.add(
            QSpec(
              topic = "ලෝක කලා ඉතිහාසය - ${w.movementOrEra}",
              questionText = "'$sampleWork' යන සුප්‍රකට කලා නිර්මාණය සමග සෘජුවම සම්බන්ධ ශිල්පියා හෝ ස්ථානය කවුද/කුමක්ද?",
              correct = w.artistOrMonument,
              distractors = listOf(
                worldArt[(i + 1) % worldArt.size].artistOrMonument,
                worldArt[(i + 2) % worldArt.size].artistOrMonument,
                worldArt[(i + 3) % worldArt.size].artistOrMonument
              ),
              explanation = "${w.movementOrEra} — ${w.historicalImpact}"
            )
          )
        }
        raw.add(
          QSpec(
            topic = "ලෝක කලා ප්‍රවණතා",
            questionText = "${w.artistOrMonument} අයත් වන ලෝක කලා යුගය හෝ කලා ව්‍යාපාරය කුමක්ද?",
            correct = w.movementOrEra,
            distractors = listOf(
              worldArt[(i + 1) % worldArt.size].movementOrEra,
              worldArt[(i + 2) % worldArt.size].movementOrEra,
              worldArt[(i + 3) % worldArt.size].movementOrEra
            ),
            explanation = "ශෛලිය: ${w.styleAndTechnique}"
          )
        )
      }
    }

    val elemList = ArtMasterDataProvider.elementsAndRules
    if (elemList.size >= 4) {
      for ((i, el) in elemList.withIndex()) {
        raw.add(
          QSpec(
            topic = el.category,
            questionText = "චිත්‍ර කලාවේදී \"${el.definition}\" යනුවෙන් අර්ථ දක්වන මූලිකාංගය හෝ මූලධර්මය කුමක්ද?",
            correct = el.titleSinhala,
            distractors = listOf(
              elemList[(i + 1) % elemList.size].titleSinhala,
              elemList[(i + 2) % elemList.size].titleSinhala,
              elemList[(i + 3) % elemList.size].titleSinhala
            ),
            explanation = "${el.titleSinhala} (${el.titleEnglish}) — ${el.examTip}"
          )
        )
      }
    }

    val pracList = ArtMasterDataProvider.practicalGuides
    if (pracList.size >= 4) {
      for ((i, pg) in pracList.withIndex()) {
        raw.add(
          QSpec(
            topic = pg.topic,
            questionText = "'${pg.titleSinhala}' ප්‍රායෝගික නිර්මාණයේදී අනුගමනය කළ යුතු නිවැරදි අනුපාතය හෝ රීතිය කුමක්ද?",
            correct = pg.proportionsOrRules,
            distractors = listOf(
              pracList[(i + 1) % pracList.size].proportionsOrRules,
              pracList[(i + 2) % pracList.size].proportionsOrRules,
              pracList[(i + 3) % pracList.size].proportionsOrRules
            ),
            explanation = "භාවිත ද්‍රව්‍ය: ${pg.materialsUsed}"
          )
        )
      }
    }

    // 3. QuizBankApplied art 10 MCQs (note getElectiveQuestion switches on qIdx 1..10 only)
    for (qIdx in 1..10) {
      val qq = QuizBankApplied.getElectiveQuestion("art", "10", "චිත්‍ර කලාව", 1, qIdx, qIdx, "චිත්‍ර කලාව")
      raw.add(quizQuestionToSpec("චිත්‍ර කලාව - O/L මූලික", qq))
    }

    // 4. Curated Color Theory, Temple Murals, Sculpture & Artists MCQs
    raw.addAll(buildCuratedArtFacts())

    // 5. SubjectMasterRepository Art multi-angle pool (~1,500+ specs)
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterArt20x20.getCategories(),
        subjectLabel = "චිත්‍ර කලාව",
        seedBase = 91
      )
    )

    // 6. ShortAnswerMasterRepository Grade 10 & Grade 11 Art (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("චිත්‍ර කලාව"))

    return dedupPool(raw)
  }

  private fun buildCuratedArtFacts(): List<QSpec> {
    val facts = listOf(
      Triple("රතු + කහ සමානව මිශ්‍ර කිරීම", "තැඹිලි (Orange)", "තැඹිලි යනු රතු හා කහ ප්‍රාථමික වර්ණ මිශ්‍රණයෙන් සෑදෙන ද්විතීයික වර්ණයකි."),
      Triple("කහ + නිල් සමානව මිශ්‍ර කිරීම", "කොළ (Green)", "කොළ යනු කහ සහ නිල් මිශ්‍ර කිරීමෙන් සෑදෙන සිසිල් ද්විතීයික වර්ණයකි."),
      Triple("රතු + නිල් සමානව මිශ්‍ර කිරීම", "දම් (Violet / Purple)", "දම් යනු රතු හා නිල් මිශ්‍රණයෙන් ලැබෙන ද්විතීයික වර්ණයයි."),
      Triple("වර්ණ චක්‍රයේ රතු වර්ණයට ප්‍රතිවිරුද්ධ පූරක වර්ණය", "කොළ (Green)", "රතු සහ කොළ එකිනෙකට මුහුණලා පිහිටි පූරක (Complementary) වර්ණ යුගලයයි."),
      Triple("වර්ණ චක්‍රයේ කහ වර්ණයට ප්‍රතිවිරුද්ධ පූරක වර්ණය", "දම් (Violet)", "කහ සහ දම් පූරක වර්ණ යුගලයක් ලෙස ඉහළ වර්ණ තීව්‍රතාවක් ඇති කරයි."),
      Triple("වර්ණ චක්‍රයේ නිල් වර්ණයට ප්‍රතිවිරුද්ධ පූරක වර්ණය", "තැඹිලි (Orange)", "නිල් සහ තැඹිලි ප්‍රතිවිරුද්ධ පූරක වර්ණ වේ."),
      Triple("උණුසුම් වර්ණ (Warm Colors)", "රතු, තැඹිලි සහ කහ", "ගින්න හා සූර්යාලෝකය සිහිගන්වන උණුසුම් වර්ණ සිතුවමේ ඉදිරියට පෙනෙන ගතියක් දෙයි."),
      Triple("සිසිල් වර්ණ (Cool Colors)", "නිල්, කොළ සහ නිල්-දම්", "ජලය හා අහස සිහිගන්වන සිසිල් වර්ණ ඈත බව හා සන්සුන් බව දක්වයි."),
      Triple("ඒකවර්ණ සංයෝජනය (Monochromatic)", "තනි වර්ණයකට සුදු (Tint) හෝ කළු (Shade) මිශ්‍ර කර ලබාගන්නා ප්‍රභේද", "තනි වර්ණ පවුලක ලා හා තද ප්‍රභේද යෙදීම ඒකවර්ණ සංයෝජනයයි."),
      Triple("සාමාන්‍යයෙන් දැඩි (Hard) හා ලා ඉරි ඇඳීමට සුදුසු පැන්සල්", "2H හෝ H පැන්සල්", "H ශ්‍රේණියේ පැන්සල් දෘඪ ග්‍රැෆයිට් සහිත බැවින් සියුම් රේඛා සඳහා සුදුසුය."),
      Triple("ගැඹුරු අඳුරු සෙවණැලි (Shading) සඳහා සුදුසු මෘදු පැන්සල්", "4B සහ 6B පැන්සල්", "B ශ්‍රේණියේ ඉහළ අංක පැන්සල් මෘදු හා තද කළු පැහැති සෙවණැලි ලබාදෙයි."),
      Triple("අනුරාධපුර අවුකන බුද්ධ ප්‍රතිමාව", "අසිමූර්ති / කලුගල් මත නෙළූ හිටි පිළිමය (අභය හා ආශිර්වාද ඉරියව් සමග දෙවෙනි සිවුර)", "ධාතුසේන රජ සමයේ නෙළූ උසස්තම ශෛලමය බුද්ධ ප්‍රතිමාවකි."),
      Triple("අනුරාධපුර සමාධි බුද්ධ ප්‍රතිමාව", "මහමෙව්නා උයනේ පිහිටි ධ්‍යාන මුද්‍රාව සහිත හිඳි පිළිමය", "ගුප්ත හා දේශීය කලා ආභාසයෙන් මහා කරුණාව විදහා දක්වයි."),
      Triple("ඉසුරුමුණිය පෙම් යුවළ කැටයම", "අනුරාධපුර යුගයේ ශෘංගාර හා ගුප්ත කලා ශෛලිය", "රළු කළුගල් පුවරුවේ සියුම් මානව හැඟීම් නිරූපණය කළ අද්විතීය කැටයමකි."),
      Triple("පොළොන්නරුව ගල් විහාරය", "මහා පරාක්‍රමබාහු රජු කරවූ හිඳි, හිටි සහ සැතපෙන ප්‍රතිමා", "තනි කළුගල් පර්වතයක නෙළූ උත්තරාරාම ප්‍රතිමා සමූහයකි."),
      Triple("මහනුවර යුගයේ ප්‍රකට තීරු සිතුවම් ක්‍රමය", "අඛණ්ඩ කථන ක්‍රමය (Continuous Narration)", "රතු පසුබිමක කහ, සුදු, කළු ස්වාභාවික වර්ණ යොදා තීරුවල ජාතක කතා ඇඳ ඇත."),
      Triple("දඹුල්ල හා දෙගල්දොරුව බිතුසිතුවම්", "මහනුවර සම්ප්‍රදායේ කීර්ති ශ්‍රී රාජසිංහ රජ සමයේ කලා නිර්මාණ", "දේවෙන්ද්‍ර මූලාචාරී ඇතුළු සිත්තරුන්ගේ උසස් නිර්මාණ වේ."),
      Triple("මූලකලා කණ්ඩායම - 43 Group (1943)", "ලයනල් වෙන්ඩ්ට්, ජෝර්ජ් කීට්, අයිවන් පීරිස්, හැරී පීරිස්", "ශ්‍රී ලංකාවේ නූතන චිත්‍ර කලාවට යුරෝපීය හා පෙරදිග නව මුහුණුවරක් එක් කළහ."),
      Triple("කැලණිය විහාරයේ නව බිතුසිතුවම් ශිල්පියා", "සෝලියස් මෙන්ඩිස් මහතා", "අජන්තා හා සීගිරි ආභාසයෙන් ඓතිහාසික හා බෞද්ධ සිතුවම් නිර්මාණය කළේය."),
      Triple("මහනුවර ඇම්බැක්කේ දේවාලය", "ගම්පොළ යුගයේ අද්විතීය ලී කැටයම් කලාව (හංස පූට්ටුව, ලියවැල්)", "ලී කුළුණු 500 කට අධික ප්‍රමාණයක සියුම් කැටයම් දක්නට ලැබේ."),
      Triple("දකුණු ඉන්දියාවේ අජන්තා ලෙන් සිතුවම්", "ටෙම්පරා (Tempera) ශිල්පීය ක්‍රමයෙන් ඇඳි බෞද්ධ බිතුසිතුවම්", "සීගිරි සිතුවම් හා කැලණි සිතුවම් කෙරෙහි ප්‍රබල ආභාසයක් එල්ල කළේය."),
      Triple("ඉතාලි පුනරුදයේ (Renaissance) ප්‍රධාන ත්‍රිත්වය", "ලියනාඩෝ ඩා වින්චි, මයිකල් ඇන්ජලෝ සහ රෆායල්", "මානව ව්‍යුහ විද්‍යාව, පර්යාවලෝකනය සහ ස්වාභාවික ත්‍රිමාණ බව මතු කළහ."),
      Triple("ඝනවාදය (Cubism) හඳුන්වා දුන් කලාකරුවන්", "පැබ්ලෝ පිකාසෝ සහ ජෝර්ජ් බ්‍රාක්", "වස්තූන් ජ්‍යාමිතික හැඩතල හා බහු දෘෂ්ටිකෝණවලින් නිරූපණය කළහ."),
      Triple("උපස්ථිතිවාදය (Impressionism)", "ක්ලෝඩ් මොනේ (Claude Monet) - ආලෝකයේ ක්ෂණික වෙනස්වීම් ඇඳීම", "වර්ණ තිතෙන් තිත තබා ස්වාභාවික ආලෝකය සිතුවමට නැගූහ.")
    )
    val out = ArrayList<QSpec>(facts.size * 2)
    for ((i, f) in facts.withIndex()) {
      out.add(
        QSpec(
          topic = "චිත්‍ර කලා න්‍යාය හා ඉතිහාසය",
          questionText = "චිත්‍ර කලා විෂයෙහිදී '${f.first}' සමග සෘජුවම සම්බන්ධ වන පිළිතුර කුමක්ද?",
          correct = f.second,
          distractors = listOf(
            facts[(i + 2) % facts.size].second,
            facts[(i + 5) % facts.size].second,
            facts[(i + 8) % facts.size].second
          ),
          explanation = f.third
        )
      )
      out.add(
        QSpec(
          topic = "චිත්‍ර කලා ඉතිහාසය හා ශිල්ප",
          questionText = "\"${f.third}\" යන විස්තරයට අදාළ ප්‍රධාන කලා මූලධර්මය හෝ නිර්මාණය කුමක්ද?",
          correct = f.first,
          distractors = listOf(
            facts[(i + 1) % facts.size].first,
            facts[(i + 4) % facts.size].first,
            facts[(i + 7) % facts.size].first
          ),
          explanation = "${f.first} -> ${f.second}"
        )
      )
    }
    return out
  }
}
