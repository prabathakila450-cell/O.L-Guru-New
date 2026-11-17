package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.normalizeOption
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * Sri Lankan & Classical Dancing (නර්තනය) Question Bank for Live Exam Hall (Grades 10 & 11 O/L).
 * Combines DancingMasterDataProvider (MCQs + Traditions + 18 Vannams + Abhinayas + 9 Rasas + Mudras + Costumes),
 * QuizBankApplied dance (10), curated Mudra/Shanthikarma/Drums MCQs,
 * SubjectMasterOtherSubjects Dancing (1,500+ multi-angle), and ShortAnswer Dancing (400 G10+G11).
 */
object DancingMockQuestionBank {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2600)

    // 1. DancingMasterDataProvider MCQs
    for (mcq in DancingMasterDataProvider.mcqQuestions) {
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

    // 2. Derived QSpecs from traditions (Kandyan, Low Country, Sabaragamuwa, Classical)
    val trs = DancingMasterDataProvider.traditions
    if (trs.size >= 3) {
      val extraDrums = listOf("තබ්ලාව", "මෘදංගය")
      val extraRituals = listOf("පත්තිනි මඩුව", "බලි යාගය")
      val extraCostumes = listOf("පන්තේරු ඇඳුම", "සවරං ඇඳුම")
      for ((i, tr) in trs.withIndex()) {
        raw.add(
          QSpec(
            topic = "නර්තන සම්ප්‍රදාය - ${tr.nameSinhala}",
            questionText = "${tr.nameSinhala} සම්ප්‍රදායේ ප්‍රධානතම බෙරය / වාද්‍ය භාණ්ඩය කුමක්ද?",
            correct = tr.primaryDrum,
            distractors = listOf(
              trs[(i + 1) % trs.size].primaryDrum,
              trs[(i + 2) % trs.size].primaryDrum,
              extraDrums[i % extraDrums.size]
            ),
            explanation = "${tr.nameSinhala} (${tr.region}) — ${tr.drumCharacteristics}"
          )
        )
        raw.add(
          QSpec(
            topic = "නර්තන සම්ප්‍රදාය - ශාන්තිකර්ම",
            questionText = "${tr.nameSinhala} සම්ප්‍රදායට අයත් ප්‍රධානම ශාන්තිකර්මය කුමක්ද?",
            correct = tr.sacredShanthikarma,
            distractors = listOf(
              trs[(i + 1) % trs.size].sacredShanthikarma,
              trs[(i + 2) % trs.size].sacredShanthikarma,
              extraRituals[i % extraRituals.size]
            ),
            explanation = "${tr.sacredShanthikarma} — ආරක්ෂක දෙවිවරු: ${tr.guardianDeities}"
          )
        )
        raw.add(
          QSpec(
            topic = "නර්තන ඇඳුම් පැළඳුම්",
            questionText = "${tr.nameSinhala} සම්ප්‍රදායේ ප්‍රධාන සම්ප්‍රදායික ඇඳුම් කට්ටලය කුමක්ද?",
            correct = tr.mainCostume,
            distractors = listOf(
              trs[(i + 1) % trs.size].mainCostume,
              trs[(i + 2) % trs.size].mainCostume,
              extraCostumes[i % extraCostumes.size]
            ),
            explanation = tr.historicalOrigin
          )
        )
      }
    }

    // 3. Derived QSpecs from all 18 Vannams (3 angles each = 54 QSpecs)
    val vannams = DancingMasterDataProvider.vannams
    if (vannams.size >= 4) {
      for ((i, vn) in vannams.withIndex()) {
        raw.add(
          QSpec(
            topic = "උඩරට වන්නම් 18",
            questionText = "'${vn.nameSinhala}' මගින් නිරූපණය කරනු ලබන ප්‍රධාන සත්වයා හෝ තේමාව කුමක්ද?",
            correct = vn.animalOrTheme,
            distractors = listOf(
              vannams[(i + 2) % vannams.size].animalOrTheme,
              vannams[(i + 5) % vannams.size].animalOrTheme,
              vannams[(i + 9) % vannams.size].animalOrTheme
            ),
            explanation = "${vn.nameSinhala} (අංක ${vn.number}) — ${vn.meaningAndBhava}"
          )
        )
        raw.add(
          QSpec(
            topic = "වන්නම් හා තාල විග්‍රහය",
            questionText = "'${vn.nameSinhala}' ගැයෙන සහ නටනු ලබන තාලය සහ මාත්‍රා ගණන නිවැරදිව දක්වන්නේ කුමක්ද?",
            correct = "${vn.thalaType} (මාත්‍රා: ${vn.matraCount})",
            distractors = listOf(
              "${vannams[(i + 1) % vannams.size].thalaType} (මාත්‍රා: ${vannams[(i + 1) % vannams.size].matraCount})",
              "${vannams[(i + 4) % vannams.size].thalaType} (මාත්‍රා: ${vannams[(i + 4) % vannams.size].matraCount})",
              "${vannams[(i + 7) % vannams.size].thalaType} (මාත්‍රා: ${vannams[(i + 7) % vannams.size].matraCount})"
            ),
            explanation = "${vn.nameSinhala} — ${vn.thalaType} (${vn.matraCount})"
          )
        )
      }
    }

    // 4. Derived QSpecs from all 9 Rasas
    val rasas = DancingMasterDataProvider.rasas
    if (rasas.size >= 4) {
      for ((i, rs) in rasas.withIndex()) {
        raw.add(
          QSpec(
            topic = "නව රස විග්‍රහය",
            questionText = "නව රස අතුරින් '${rs.rasaSinhala}' රසයට අදාළ ස්ථායී භාවය (Sthayi Bhava) කුමක්ද?",
            correct = rs.sthayiBhavaSinhala,
            distractors = listOf(
              rasas[(i + 1) % rasas.size].sthayiBhavaSinhala,
              rasas[(i + 2) % rasas.size].sthayiBhavaSinhala,
              rasas[(i + 3) % rasas.size].sthayiBhavaSinhala
            ),
            explanation = "වර්ණය: ${rs.colorAssociation} | අධිපති දෙවියා: ${rs.presidingDeity} — ${rs.description}"
          )
        )
        raw.add(
          QSpec(
            topic = "නව රස - වර්ණ හා අධිපති දෙවිවරු",
            questionText = "${rs.rasaSinhala} රසය සංකේතවත් කරන සම්ප්‍රදායික වර්ණය කුමක්ද?",
            correct = rs.colorAssociation,
            distractors = listOf(
              rasas[(i + 1) % rasas.size].colorAssociation,
              rasas[(i + 3) % rasas.size].colorAssociation,
              rasas[(i + 5) % rasas.size].colorAssociation
            ),
            explanation = "${rs.rasaSinhala} (${rs.sthayiBhavaSinhala}) — ${rs.description}"
          )
        )
      }
    }

    // 5. Abhinayas, Mudras & InstrumentsAndCostumes
    val abhs = DancingMasterDataProvider.abhinayas
    if (abhs.size >= 4) {
      for ((i, ab) in abhs.withIndex()) {
        raw.add(
          QSpec(
            topic = "චතුර්විධ අභිනය",
            questionText = "නර්තන කලාවේදී \"${ab.definition}\" යන්නෙන් හඳුන්වනු ලබන්නේ කුමන අභිනයද?",
            correct = ab.nameSinhala,
            distractors = listOf(
              abhs[(i + 1) % abhs.size].nameSinhala,
              abhs[(i + 2) % abhs.size].nameSinhala,
              abhs[(i + 3) % abhs.size].nameSinhala
            ),
            explanation = ab.practicalApplication
          )
        )
      }
    }

    val mudras = DancingMasterDataProvider.mudras
    if (mudras.size >= 4) {
      for ((i, md) in mudras.withIndex()) {
        val rep = md.representations.firstOrNull().orEmpty()
        raw.add(
          QSpec(
            topic = "හස්ත මුද්‍රා - ${md.type}",
            questionText = "\"${md.handShapeDescription}\" යන අත් හැඩයෙන් යුත් මුද්‍රාව කුමක්ද?",
            correct = md.nameSinhala,
            distractors = listOf(
              mudras[(i + 1) % mudras.size].nameSinhala,
              mudras[(i + 2) % mudras.size].nameSinhala,
              mudras[(i + 3) % mudras.size].nameSinhala
            ),
            explanation = "${md.nameSinhala} (${md.type}) — නිරූපණය: $rep"
          )
        )
      }
    }

    val instCostumes = DancingMasterDataProvider.instrumentsAndCostumes
    if (instCostumes.size >= 4) {
      for ((i, ic) in instCostumes.withIndex()) {
        raw.add(
          QSpec(
            topic = ic.category,
            questionText = "නර්තන සම්ප්‍රදායේ එන '${ic.titleSinhala}' නිර්මාණය සඳහා යොදාගන්නා ප්‍රධාන ද්‍රව්‍ය මොනවාද?",
            correct = ic.rawMaterials,
            distractors = listOf(
              instCostumes[(i + 1) % instCostumes.size].rawMaterials,
              instCostumes[(i + 2) % instCostumes.size].rawMaterials,
              instCostumes[(i + 3) % instCostumes.size].rawMaterials
            ),
            explanation = "${ic.classification} — ${ic.ritualSignificance}"
          )
        )
      }
    }

    // 6. QuizBankApplied dance 10 MCQs
    for (qIdx in 1..10) {
      val qq = QuizBankApplied.getElectiveQuestion("dance", "10", "නර්තනය", 1, qIdx, qIdx, "නර්තනය")
      raw.add(quizQuestionToSpec("නර්තනය - මූලික සිද්ධාන්ත", qq))
    }

    // 7. Curated Drums, Shanthikarma, Sanni, Classical Indian Dances & Hasta Mudras MCQs
    raw.addAll(buildCuratedDanceFacts())

    // 8. SubjectMasterOtherSubjects Dancing multi-angle pool (~1,500+ specs)
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterOtherSubjects20x20.getDancingCategories(),
        subjectLabel = "නර්තනය",
        seedBase = 101
      )
    )

    // 9. ShortAnswerMasterRepository Grade 10 & Grade 11 Dancing (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("නර්තනය"))

    return dedupPool(raw)
  }

  private fun buildCuratedDanceFacts(): List<QSpec> {
    val facts = listOf(
      Triple("පංචතූර්ය නාද වර්ග 5", "ආතත, විතත, විතතාතත, ඝන සහ සුසිර", "ශ්‍රී ලාංකේය සම්ප්‍රදායික වාද්‍ය භාණ්ඩ වර්ගීකරණ ක්‍රමයයි."),
      Triple("අවනද්ධ (සම්) භාණ්ඩවල උපකාරක දැව", "කොස්, කොහොඹ, ඇහැල හා කිතුල් ලී කඳන්", "ගැටබෙරයේ දකුණු ඇස වඳුරු සමෙන්ද වම් ඇස හරක් සමෙන්ද නිමවයි."),
      Triple("කොහොඹා කංකාරියේ පුරාවෘත්තය", "පඬුවස්දෙව් රජුගේ දිවිදෝෂය සුව කිරීමට පැවැත්වූ ප්‍රථම යාගය", "මලය රජු ඇතුළු සොහොයුරන් විසින් ලක්දිවට ගෙන ආ උඩරට ප්‍රධාන ශාන්තිකර්මයයි."),
      Triple("දහඅට සන්නිය හා කෝලාභ", "රෝග සන්නි 18 ක් සමනය කරන පහතරට වෙස්මුහුණු යාගය", "මරු සන්නිය, කෝල සන්නිය, බිහිරි සන්නිය ආදිය මෙහිදී රඟ දැක්වේ."),
      Triple("දෙවොල් මඩුව හා ගම්මඩුව", "පත්තිනි මෑණියන් හා දෙවොල් දෙවියන් උදෙසා පහතරට පවත්වන ශාන්තිකර්ම", "පහන්මඩු, ගිනි පෑගීම සහ තොරන් බැඳීම මෙහි ප්‍රධාන අංග වේ."),
      Triple("රට යකුම හෙවත් රිද්දි යාගය", "ගැබිනි මව්වරුන්ගේ හා දරුවන්ගේ ආරක්ෂාව පතා කරන පහතරට යාගය", "කළු යකා සහ රිද්දි බිසවුන් හත්දෙනාගේ පුවත රඟ දැක්වේ."),
      Triple("හත්පද පාලිය හා සූනියම් කැපිල්ල", "වින දෝෂ දුරු කර ආශිර්වාද ගෙනෙන පහතරට ශාන්තිකර්ම", "සමන්, විෂ්ණු, කතරගම ආදී දේව ආශිර්වාදය පතනු ලැබේ."),
      Triple("සබරගමු ගමන් පද හා මඩු පුරය", "සමන් දෙවියන් පිදීම උදෙසා පවත්වන සබරගමු ශාන්තිකර්ම", "දිගු දවුල හා තම්මැට්ටම හේවිසි වාදනයෙන් අලංකාර වේ."),
      Triple("තෙල්මේ නැටුම", "පහතරට නර්තන සම්ප්‍රදායේ ප්‍රධාන සමූහ දේව නැටුම් අංගය", "වන්නම් හා දේව ආශිර්වාද නැටුම් සඳහා ප්‍රසිද්ධය."),
      Triple("පොල් අඩව්ව හා සවරං නැටුම", "ගැමි සෞන්දර්ය නිරූපණය කරන ජන හා සරඹ නැටුම් විශේෂ", "පහතරට හා උඩරට උත්සව අවස්ථාවලදී ඉදිරිපත් කෙරේ."),
      Triple("කලගෙඩි හා රබන් නැටුම්", "ගැමි කාන්තාවන් අලුත් අවුරුදු හා උත්සවවල නටන ජන නැටුම්", "දිය ගෙන ඒම හා ප්‍රීතිය ජන නැටුමින් නිරූපණය වේ."),
      Triple("උඩරට පා සරඹ 12 සහ ගොඩ සරඹ", "දණ්ඩියම් කඳ අල්ලාගෙන මණ්ඩි ඉරියව්වෙන් පුහුණු වන මූලික සරඹ", "දෙපා ශක්තිමත් කිරීමට හා තාල අවබෝධයට උඩරට නැට්ටුවා පුහුණු වේ."),
      Triple("මූලික උඩරට මණ්ඩි ඉරියව්ව", "දෙපා දෙපසට විහිදා දණහිස් නමා සිටින සමතුලිත ඉරියව්ව", "උඩරට නර්තනයේ සියලු පියවර ආරම්භ වන මූලික ඉරියව්වයි."),
      Triple("පතක හස්තය (අසංයුත මුද්‍රා 28 න් පළමුවැන්න)", "සියලු ඇඟිලි දිගු කර මහපටැඟිල්ල නවා තබන හස්ත මුද්‍රාව", "නැටුමේ ආරම්භය, ආශිර්වාදය, වලාකුළු හා ගංගා දැක්වීමට යොදයි."),
      Triple("අංජලී හස්තය (සංයුත මුද්‍රා 24 න් පළමුවැන්න)", "පතක හස්ත දෙකම එකට එක් කර වැඳීමේ ඉරියව්ව", "දෙවියන්, ගුරුවරුන් සහ ප්‍රේක්ෂකයන්ට ආචාර කිරීමට භාවිත කෙරේ."),
      Triple("භරත නාට්‍යම් හි 'අලාරිප්පු' අංගය", "ප්‍රසංගයක ආරම්භක පිළිගැනීමේ හා ශරීරය සූදානම් කිරීමේ නර්තනය", "දකුණු ඉන්දීය කර්ණාටක තාලයට අනුව ඉදිරිපත් කරයි."),
      Triple("කථක් (Kathak) නර්තන සම්ප්‍රදාය", "උතුරු ඉන්දියාවේ කතාන්දර කීම ඇසුරෙන් බිහිවූ ශාස්ත්‍රීය නැටුම", "වේගවත් කැරකීම් (Chakkars) හා පාද චලන (Tatkar) සඳහා ප්‍රසිද්ධය."),
      Triple("කථකලි (Kathakali) නර්තන සම්ප්‍රදාය", "කේරළයේ විචිත්‍ර මුහුණු පින්තාරු හා මුද්‍රා සහිත නැටුම් නාට්‍යය", "රාමායණය හා මහාභාරතය කථා වස්තු වේ.")
    )
    val out = ArrayList<QSpec>(facts.size * 2)
    for ((i, f) in facts.withIndex()) {
      out.add(
        QSpec(
          topic = "නර්තන විද්‍යාව හා සම්ප්‍රදාය",
          questionText = "නර්තන විෂයෙහිදී '${f.first}' යන්න පිළිබඳ නිවැරදිම හැඳින්වීම කුමක්ද?",
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
          topic = "නර්තන සම්ප්‍රදාය හා මූලාශ්‍ර",
          questionText = "\"${f.third}\" යන විස්තරයට වඩාත්ම ගැළපෙන නර්තන අංගය හෝ සංකල්පය කුමක්ද?",
          correct = f.first,
          distractors = listOf(
            facts[(i + 1) % facts.size].first,
            facts[(i + 4) % facts.size].first,
            facts[(i + 7) % facts.size].first
          ),
          explanation = "${f.first} — ${f.second}"
        )
      )
    }
    return out
  }
}
