package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.normalizeOption
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * Oriental & Applied Music (සංගීතය) Question Bank for Live Exam Hall (Grades 10 & 11 O/L).
 * Combines MusicMasterDataProvider (MCQs + Ragas + Thalas + Folk/Theatre + Instruments + Musicians),
 * QuizBankApplied music (10), curated Bhatkhande 10 Thaats / Swara / Matra / Notation MCQs,
 * SubjectMasterMusicFull (1,500+ multi-angle), and ShortAnswer Music (400 G10+G11).
 */
object MusicMockQuestionBank {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2600)

    // 1. MusicMasterDataProvider MCQs
    for (mcq in MusicMasterDataProvider.mcqQuestions) {
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

    // 2. Derived QSpecs from Ragas (each raga -> 5 distinct QSpecs!)
    val ragas = MusicMasterDataProvider.ragas
    if (ragas.size >= 4) {
      for ((i, r) in ragas.withIndex()) {
        raw.add(
          QSpec(
            topic = "රාග විද්‍යාව - ${r.nameSinhala}",
            questionText = "'${r.nameSinhala}' රාගය අයත් වන මූලික ථාටය (Thaat) කුමක්ද?",
            correct = r.thaatSinhala,
            distractors = listOf(
              ragas[(i + 1) % ragas.size].thaatSinhala,
              ragas[(i + 2) % ragas.size].thaatSinhala,
              ragas[(i + 3) % ragas.size].thaatSinhala
            ),
            explanation = "${r.nameSinhala} රාගය ${r.thaatSinhala} ට අයත් වේ — ${r.descriptionAndRasa}"
          )
        )
        raw.add(
          QSpec(
            topic = "රාග විද්‍යාව - ${r.nameSinhala}",
            questionText = "${r.nameSinhala} රාගයේ ජාතිය (Jati - ස්වර ගණන අනුව) නිවැරදිව දක්වන්නේ කුමක්ද?",
            correct = r.jatiSinhala,
            distractors = listOf(
              ragas[(i + 1) % ragas.size].jatiSinhala,
              ragas[(i + 2) % ragas.size].jatiSinhala,
              ragas[(i + 3) % ragas.size].jatiSinhala
            ),
            explanation = "ආරෝහණ: ${r.arohana} / අවරෝහණ: ${r.avarohana}"
          )
        )
        raw.add(
          QSpec(
            topic = "රාග විද්‍යාව - ${r.nameSinhala}",
            questionText = "${r.nameSinhala} රාගයේ වාදී ස්වරය (Vadi) හා සංවාදී ස්වරය (Samvadi) පිළිවෙළින් කුමක්ද?",
            correct = "වාදී: ${r.vadiSwara} | සංවාදී: ${r.samvadiSwara}",
            distractors = listOf(
              "වාදී: ${ragas[(i + 1) % ragas.size].vadiSwara} | සංවාදී: ${ragas[(i + 1) % ragas.size].samvadiSwara}",
              "වාදී: ${ragas[(i + 2) % ragas.size].vadiSwara} | සංවාදී: ${ragas[(i + 2) % ragas.size].samvadiSwara}",
              "වාදී: ${ragas[(i + 3) % ragas.size].vadiSwara} | සංවාදී: ${ragas[(i + 3) % ragas.size].samvadiSwara}"
            ),
            explanation = "${r.nameSinhala} රාගයේ ප්‍රධාන ස්වරය ${r.vadiSwara} වන අතර දෙවන ප්‍රධාන ස්වරය ${r.samvadiSwara} වේ."
          )
        )
        raw.add(
          QSpec(
            topic = "රාග විද්‍යාව - ${r.nameSinhala}",
            questionText = "${r.nameSinhala} රාගයේ ගායන සමය (Gayan Samaya) කවදාද?",
            correct = r.gayanSamaya,
            distractors = listOf(
              ragas[(i + 1) % ragas.size].gayanSamaya,
              ragas[(i + 2) % ragas.size].gayanSamaya,
              ragas[(i + 3) % ragas.size].gayanSamaya
            ),
            explanation = "${r.nameSinhala} රාගය ගයනු ලබන ප්‍රශස්ත වේලාව ${r.gayanSamaya} වේ."
          )
        )
        raw.add(
          QSpec(
            topic = "රාග විද්‍යාව - ආරෝහණ හා අවරෝහණ",
            questionText = "\"${r.arohana}\" යන ආරෝහණ ස්වර සංයෝජනය අයත් වන්නේ කුමන රාගයටද?",
            correct = r.nameSinhala,
            distractors = listOf(
              ragas[(i + 1) % ragas.size].nameSinhala,
              ragas[(i + 2) % ragas.size].nameSinhala,
              ragas[(i + 3) % ragas.size].nameSinhala
            ),
            explanation = "වර්ජිත ස්වර: ${r.varjithaSwaras}"
          )
        )
      }
    }

    // 3. Derived QSpecs from Thalas
    val thalas = MusicMasterDataProvider.thalas
    if (thalas.size >= 4) {
      for ((i, th) in thalas.withIndex()) {
        raw.add(
          QSpec(
            topic = "තාල විද්‍යාව - ${th.nameSinhala}",
            questionText = "'${th.nameSinhala}' තාලයේ මුළු මාත්‍රා ගණන සහ විභාග බෙදීම කුමක්ද?",
            correct = "මාත්‍රා ${th.totalMatras} (${th.vibhagDivision})",
            distractors = listOf(
              "මාත්‍රා ${thalas[(i + 1) % thalas.size].totalMatras} (${thalas[(i + 1) % thalas.size].vibhagDivision})",
              "මාත්‍රා ${thalas[(i + 2) % thalas.size].totalMatras} (${thalas[(i + 2) % thalas.size].vibhagDivision})",
              "මාත්‍රා ${thalas[(i + 3) % thalas.size].totalMatras} (${thalas[(i + 3) % thalas.size].vibhagDivision})"
            ),
            explanation = "${th.nameSinhala} තාලයේ තාලි: ${th.thaliPositions}, ඛාලි: ${th.khaliPositions}"
          )
        )
        raw.add(
          QSpec(
            topic = "තාල විද්‍යාව - ඨේකා බෝල්",
            questionText = "\"${th.thekaBols}\" යන ඨේකා බෝල් පද මාලාව අයත් වන තාලය කුමක්ද?",
            correct = th.nameSinhala,
            distractors = listOf(
              thalas[(i + 1) % thalas.size].nameSinhala,
              thalas[(i + 2) % thalas.size].nameSinhala,
              thalas[(i + 3) % thalas.size].nameSinhala
            ),
            explanation = "${th.nameSinhala} — ${th.usageAndInstruments}"
          )
        )
      }
    }

    // 4. Folk & Theatre, Instruments, Musicians
    val folk = MusicMasterDataProvider.folkAndTheatre
    if (folk.size >= 4) {
      for ((i, fk) in folk.withIndex()) {
        raw.add(
          QSpec(
            topic = fk.category,
            questionText = "ශ්‍රී ලාංකේය සංගීතයේ '${fk.titleSinhala}' නිර්මාණයේ ප්‍රධාන සමාජ පසුබිම කුමක්ද?",
            correct = fk.socialContext,
            distractors = listOf(
              folk[(i + 1) % folk.size].socialContext,
              folk[(i + 2) % folk.size].socialContext,
              folk[(i + 3) % folk.size].socialContext
            ),
            explanation = fk.historicalSignificance
          )
        )
      }
    }

    val insts = MusicMasterDataProvider.instruments
    if (insts.size >= 4) {
      for ((i, ins) in insts.withIndex()) {
        raw.add(
          QSpec(
            topic = "වාද්‍ය භාණ්ඩ වර්ගීකරණය",
            questionText = "'${ins.titleSinhala}' අයත් වන සංගීත භාණ්ඩ වර්ගීකරණය හා ප්‍රධාන කාර්යභාරය කුමක්ද?",
            correct = "${ins.category} — ${ins.roleInPerformance}",
            distractors = listOf(
              "${insts[(i + 1) % insts.size].category} — ${insts[(i + 1) % insts.size].roleInPerformance}",
              "${insts[(i + 2) % insts.size].category} — ${insts[(i + 2) % insts.size].roleInPerformance}",
              "${insts[(i + 3) % insts.size].category} — ${insts[(i + 3) % insts.size].roleInPerformance}"
            ),
            explanation = "නිමැවුම් ද්‍රව්‍ය: ${ins.constructionMaterials}"
          )
        )
      }
    }

    val mus = MusicMasterDataProvider.musicians
    if (mus.size >= 4) {
      for ((i, m) in mus.withIndex()) {
        raw.add(
          QSpec(
            topic = "සංගීත ඉතිහාසය - ${m.eraOrTradition}",
            questionText = "'${m.famousWorksOrBooks}' වැනි කෘති හෝ නිර්මාණ සඳහා ප්‍රසිද්ධ සංගීතවේදියා කවුද?",
            correct = m.nameSinhala,
            distractors = listOf(
              mus[(i + 1) % mus.size].nameSinhala,
              mus[(i + 2) % mus.size].nameSinhala,
              mus[(i + 3) % mus.size].nameSinhala
            ),
            explanation = "${m.titleOrRole} — ${m.historicalImpact}"
          )
        )
      }
    }

    // 5. QuizBankApplied music 10 MCQs
    for (qIdx in 1..10) {
      val qq = QuizBankApplied.getElectiveQuestion("music", "10", "සංගීතය", 1, qIdx, qIdx, "සංගීතය")
      raw.add(quizQuestionToSpec("සංගීතය - මූලික සිද්ධාන්ත", qq))
    }

    // 6. Curated Bhatkhande Thaats, Shrutis, Notation & Sri Lankan Folk Songs MCQs
    raw.addAll(buildCuratedMusicFacts())

    // 7. SubjectMasterMusicFull multi-angle pool
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterMusicFull.getCategories(),
        subjectLabel = "සංගීතය",
        seedBase = 97
      )
    )

    // 8. ShortAnswerMasterRepository Grade 10 & Grade 11 Music (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("සංගීතය"))

    return dedupPool(raw)
  }

  private fun buildCuratedMusicFacts(): List<QSpec> {
    val facts = listOf(
      Triple("බිලාවල් ථාටය", "සියලුම ස්වර 7 ශුද්ධ ස්වර ලෙස යෙදෙන ථාටය", "භාරතීය ශුද්ධ සප්තකය බිලාවල් ථාටය මත පදනම් වේ."),
      Triple("කල්‍යාණ ථාටය", "ත්‍රීව්‍ර මධ්‍යම (M̄) පමණක් විකෘත වී අනෙක් සියලු ස්වර ශුද්ධ වන ථාටය", "යමන්, භූපාලී ආදී රාග හා සම්බන්ධ ථාටයකි."),
      Triple("ඛමාජ් ථාටය", "කෝමල නිෂාද (n) පමණක් විකෘත වන ථාටය", "ඛමාජ්, දේශ් වැනි රාග මේ ථාටයෙන් උපදී."),
      Triple("කාෆි ථාටය", "කෝමල ගන්ධාර (g) සහ කෝමල නිෂාද (n) යෙදෙන ථාටය", "කාෆි, භීම්පලාසි රාග මේ ථාටයට අයත් වේ."),
      Triple("භෛරව ථාටය", "කෝමල රිෂභ (r) සහ කෝමල ධෛවත (d) යෙදෙන ථාටය", "ප්‍රභාත රාගයක් වන භෛරව් රාගයේ ථාටයයි."),
      Triple("පූර්වි ථාටය", "කෝමල රිෂභ (r), කෝමල ධෛවත (d) සහ ත්‍රීව්‍ර මධ්‍යම (M̄) යෙදෙන ථාටය", "සන්ධ්‍යා ප්‍රහරයේ රාග බිහි කරන ථාටයකි."),
      Triple("මාරවා ථාටය", "කෝමල රිෂභ (r) සහ ත්‍රීව්‍ර මධ්‍යම (M̄) යෙදෙන ථාටය", "සූර්ය බැස යන සවස් කාලීන රාග සඳහා යොදයි."),
      Triple("අසාවරි ථාටය", "කෝමල ග (g), කෝමල ධ (d) සහ කෝමල නි (n) යෙදෙන ථාටය", "ජෞන්පුරි සහ දර්බාරි කානඩා රාග මෙයින් උපදී."),
      Triple("භෛරවී ථාටය", "කෝමල රි (r), කෝමල ග (g), කෝමල ධ (d) සහ කෝමල නි (n) යෙදෙන ථාටය", "සම්පූර්ණ වේලාවන් සඳහා උචිත ශෝක හා භක්ති රසැති ථාටයයි."),
      Triple("තෝඩි ථාටය", "කෝමල r, g, d සහ ත්‍රීව්‍ර M̄ යෙදෙන ථාටය", "මියා කී තෝඩි වැනි උදෑසන රාග උපදවයි."),
      Triple("අචල ස්වර (වෙනස් නොවන ස්වර)", "ෂඩ්ජ (ස) සහ පංචම (ප)", "ස සහ ප ස්වර දෙක කිසි විටෙක කෝමල හෝ ත්‍රීව්‍ර නොවේ."),
      Triple("ශ්‍රැති (Shruti) ගණන", "සප්තකයක සියුම් ශ්‍රැති 22 ක් ඇත", "භාරතීය සංගීතයේ කනට වෙන්කර හඳුනාගත හැකි සියුම් ස්වර ස්ථාන 22 කි."),
      Triple("ගාන්ධර්ව සංගීත විභාගයේ සම (Sam) සංකේතය", "භාත්ඛණ්ඩේ ක්‍රමයේදී 'X' කතිර ලකුණ", "තාලයේ පළමු හා ප්‍රධානම මාත්‍රාව සම වේ."),
      Triple("ඛාලි (Khali) සංකේතය", "භාත්ඛණ්ඩේ ස්වරලිපි ක්‍රමයේදී '0' (ශුන්‍යය)", "අත ඉවතට විවෘත කර හිස්ව දක්වන තාල ස්ථානයයි."),
      Triple("මන්ද්‍ර සප්තකයේ සංකේතය", "ස්වරයට යටින් තබන තිත (.) - පහළ සප්තකය", "සාමාන්‍ය මධ්‍ය සප්තකයට වඩා ගැඹුරු පහළ ස්වර දක්වයි."),
      Triple("තාර සප්තකයේ සංකේතය", "ස්වරයට ඉහළින් තබන තිත (˙) - ඉහළ සප්තකය", "මධ්‍ය සප්තකයට වඩා දෙගුණයක් සංඛ්‍යාතයෙන් වැඩි ඉහළ ස්වර දක්වයි."),
      Triple("මහාචාර්ය එදිරිවීර සරච්චන්ද්‍රයන්ගේ 'මනමේ' (1956)", "නාඩගම් ගී ආර ඇසුරෙන් නිපදවූ සිංහල ශෛලිගත ගීත නාටකය", "දේශීය නාට්‍ය හා රංග සංගීතයේ නව යුගයක් ඇරඹීය."),
      Triple("ජෝන් ද සිල්වාගේ 'සිරිසඟබෝ' නූර්තිය", "'දන්නෝ බුදුන්ගේ ශ්‍රී ධර්මස්කන්ධා' නූර්ති ගීතය", "විශ්වනාත් ලවුජි තනු නිර්මාණය කළ ප්‍රකට උත්තර භාරතීය ආභාස ගීතයකි."),
      Triple("සිංහල සරල ගීතයේ පියා (ආනන්ද සමරකෝන්)", "'එන්නද මැණිකේ', 'පොඩි මල් එතනෝ' හා ජාතික ගීය", "1940 දශකයේදී දේශීය ස්වර රටා ඇසුරෙන් ශ්‍රී ලාංකික සරල ගීය බිහි කළේය."),
      Triple("මහාචාර්ය සුනිල් සාන්තයන්", "'ඕලු පිපීලා', 'හඳපානේ', 'කෝකිලයන්ගේ'", "හෙළ හවුල හා එක්ව හෙළ සුගම සංගීතය පෝෂණය කළේය.")
    )
    val out = ArrayList<QSpec>(facts.size * 2)
    for ((i, f) in facts.withIndex()) {
      out.add(
        QSpec(
          topic = "සංගීත න්‍යාය හා ඉතිහාසය",
          questionText = "සංගීත විද්‍යාවේදී \"${f.second}\" යන්නෙන් හැඳින්වෙන්නේ කුමක්ද?",
          correct = f.first,
          distractors = listOf(
            facts[(i + 2) % facts.size].first,
            facts[(i + 5) % facts.size].first,
            facts[(i + 9) % facts.size].first
          ),
          explanation = f.third
        )
      )
      out.add(
        QSpec(
          topic = "සංගීත න්‍යාය හා ලක්ෂණ",
          questionText = "'${f.first}' පිළිබඳ නිවැරදිම සංගීතමය කරුණ කුමක්ද?",
          correct = f.second,
          distractors = listOf(
            facts[(i + 1) % facts.size].second,
            facts[(i + 4) % facts.size].second,
            facts[(i + 7) % facts.size].second
          ),
          explanation = f.third
        )
      )
    }
    return out
  }
}
