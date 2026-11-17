package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.normalizeOption
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool
import java.util.Locale

/**
 * Curated + Parametric Health & Physical Education (සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය) Question Pool.
 * Combines HealthMasterDataProvider (MCQs + First Aid + Sports Rules + Practicals + Ayurveda),
 * QuizBankApplied Health (100), 180 parametric BMI/Heart-Rate/Tournament calculations + Nutrition/Body facts,
 * SubjectMasterHealth (1,500+ multi-angle), and ShortAnswer Health (400 G10+G11).
 */
object HealthMockPoolHelper {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2600)

    // 1. HealthMasterDataProvider authentic MCQs
    for (mcq in HealthMasterDataProvider.mcqQuestions) {
      val opts = mcq.options.map { normalizeOption(it) }
      if (opts.size >= 4) {
        val idx = mcq.correctOptionIndex.coerceIn(0, opts.lastIndex)
        raw.add(
          QSpec(
            topic = mcq.unitName,
            questionText = mcq.questionText,
            correct = opts[idx],
            distractors = opts.filterIndexed { i, _ -> i != idx },
            explanation = mcq.explanation
          )
        )
      }
    }

    // 2. Derived structured QSpecs from HealthMasterDataProvider guides & rules
    val firstAidList = HealthMasterDataProvider.firstAidGuides
    for ((i, fa) in firstAidList.withIndex()) {
      if (fa.immediateSteps.isNotEmpty() && firstAidList.size >= 4) {
        val d1 = firstAidList[(i + 1) % firstAidList.size].immediateSteps.firstOrNull().orEmpty()
        val d2 = firstAidList[(i + 2) % firstAidList.size].immediateSteps.firstOrNull().orEmpty()
        val d3 = firstAidList[(i + 3) % firstAidList.size].immediateSteps.firstOrNull().orEmpty()
        raw.add(
          QSpec(
            topic = "ප්‍රථමාධාර - ${fa.injuryType}",
            questionText = "'${fa.title}' (${fa.injuryType}) ආපදා තත්ත්වයකදී ලබාදිය යුතු ක්ෂණික ප්‍රථමාධාර පියවරක් වන්නේ කුමක්ද?",
            correct = fa.immediateSteps.first(),
            distractors = listOf(d1, d2, d3),
            explanation = "${fa.title} — ${fa.warningNote}"
          )
        )
      }
    }

    val sportsList = HealthMasterDataProvider.sportsRules
    for ((i, sp) in sportsList.withIndex()) {
      if (sportsList.size >= 4) {
        raw.add(
          QSpec(
            topic = "ක්‍රීඩා නීති - ${sp.sportName}",
            questionText = "${sp.sportName} ක්‍රීඩාව සඳහා නියමිත ක්‍රීඩා පිටියේ ප්‍රමාණය (Court Dimensions) කුමක්ද?",
            correct = sp.courtDimensions,
            distractors = listOf(
              sportsList[(i + 1) % sportsList.size].courtDimensions,
              sportsList[(i + 2) % sportsList.size].courtDimensions,
              sportsList[(i + 3) % sportsList.size].courtDimensions
            ),
            explanation = "${sp.sportName} — ${sp.examTip}"
          )
        )
        raw.add(
          QSpec(
            topic = "ක්‍රීඩා නීති - ${sp.sportName}",
            questionText = "${sp.sportName} ක්‍රීඩාවේ කණ්ඩායමක ක්‍රීඩක සංඛ්‍යාව නිවැරදිව දක්වා ඇත්තේ කුමක්ද?",
            correct = sp.teamMembers,
            distractors = listOf(
              sportsList[(i + 1) % sportsList.size].teamMembers,
              sportsList[(i + 2) % sportsList.size].teamMembers,
              sportsList[(i + 3) % sportsList.size].teamMembers
            ),
            explanation = "${sp.sportName} — ක්‍රීඩකයන්: ${sp.teamMembers}"
          )
        )
      }
    }

    val ayurvedaList = HealthMasterDataProvider.ayurvedaCards
    for ((i, ay) in ayurvedaList.withIndex()) {
      if (ayurvedaList.size >= 4) {
        raw.add(
          QSpec(
            topic = "දේශීය වෙදකම හා ඔසු",
            questionText = "හෙළ වෙදකමේදී '${ay.plantOrConceptName}' මගින් සැලසෙන ප්‍රධාන ඖෂධීය ගුණය කුමක්ද?",
            correct = ay.medicinalValue,
            distractors = listOf(
              ayurvedaList[(i + 1) % ayurvedaList.size].medicinalValue,
              ayurvedaList[(i + 2) % ayurvedaList.size].medicinalValue,
              ayurvedaList[(i + 3) % ayurvedaList.size].medicinalValue
            ),
            explanation = "භාවිත කොටස: ${ay.usedPart} — ${ay.examTip}"
          )
        )
      }
    }

    // 3. 100 Curated QuizBankApplied Health MCQs
    for (setIdx in 1..10) {
      for (qIdx in 1..10) {
        val qq = QuizBankApplied.getHealthQuestion("10", setIdx, qIdx, qIdx, "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය")
        raw.add(quizQuestionToSpec("සෞඛ්‍යය - ඒකකය $setIdx", qq))
      }
    }

    // 4. Parametric BMI, Target Heart Rate, Knockout & League Tournaments, Nutrition & Systems
    raw.addAll(buildParametricAndCuratedHealth())

    // 5. SubjectMasterRepository Health multi-angle pool (~1,500+ specs)
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterRepository.getCategoriesForSubject("සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය"),
        subjectLabel = "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
        seedBase = 71
      )
    )

    // 6. ShortAnswerMasterRepository Grade 10 & Grade 11 Health (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය"))

    return ExamQuestionHelper.distributeProportionallyAcrossTopics(dedupPool(raw))
  }

  private fun buildParametricAndCuratedHealth(): List<QSpec> {
    val list = ArrayList<QSpec>(260)

    // A. BMI calculations (45 problems)
    val heightsCm = listOf(150, 155, 160, 165, 170, 175, 180, 162, 168)
    val weightsKg = listOf(45, 52, 60, 68, 75)
    for (hCm in heightsCm) {
      for (wKg in weightsKg) {
        val hM = hCm / 100.0
        val bmi = wKg / (hM * hM)
        val bmiStr = String.format(Locale.US, "%.1f", bmi)
        val category = when {
          bmi < 18.5 -> "අඩු බර (Underweight)"
          bmi <= 24.9 -> "නිරෝගී බර (Normal)"
          bmi <= 29.9 -> "වැඩි බර (Overweight)"
          else -> "ස්ථූලතාව (Obese)"
        }
        val d1 = String.format(Locale.US, "%.1f", bmi + 3.2)
        val d2 = String.format(Locale.US, "%.1f", (bmi - 2.8).coerceAtLeast(10.0))
        val d3 = String.format(Locale.US, "%.1f", bmi + 5.7)
        list.add(
          QSpec(
            topic = "ශරීර ස්කන්ධ දර්ශකය (BMI)",
            questionText = "බර $wKg kg සහ උස $hCm cm (${String.format(Locale.US, "%.2f", hM)} m) වූ අයෙකුගේ BMI අගය කොපමණද?",
            correct = "$bmiStr kg/m² ($category)",
            distractors = listOf("$d1 kg/m²", "$d2 kg/m²", "$d3 kg/m²"),
            explanation = "BMI = $wKg / (${String.format(Locale.US, "%.2f", hM)})² = $bmiStr kg/m² -> $category"
          )
        )
      }
    }

    // B. Knockout & League Tournament Match Count calculations (45 problems)
    for (n in 5..24) {
      val knockoutMatches = n - 1
      list.add(
        QSpec(
          topic = "තරගාවලි සංවිධානය - Knockout",
          questionText = "කණ්ඩායම් $n ක් සහභාගී වන පිළිමළුන් පිටුදැකීමේ (Knockout) තරගාවලියක ශූරයා තේරීමට පැවැත්විය යුතු මුළු තරග ගණන කීයද?",
          correct = "තරග $knockoutMatches කි",
          distractors = listOf("තරග $n කි", "තරග ${n + 1} කි", "තරග ${n * 2} කි"),
          explanation = "Knockout තරගාවලියක මුළු තරග ගණන = N - 1 = $n - 1 = $knockoutMatches."
        )
      )
    }
    for (n in 4..18) {
      val leagueMatches = n * (n - 1) / 2
      list.add(
        QSpec(
          topic = "තරගාවලි සංවිධානය - League",
          questionText = "කණ්ඩායම් $n ක් සහභාගී වන තනි වටයේ ලීග් (Single League) තරගාවලියක මුළු තරග ගණන කීයද?",
          correct = "තරග $leagueMatches කි",
          distractors = listOf("තරග ${n - 1} කි", "තරග ${n * 2} කි", "තරග ${leagueMatches + n} කි"),
          explanation = "තනි ලීග් තරග ගණන = N(N - 1) / 2 = $n × ${n - 1} / 2 = $leagueMatches."
        )
      )
    }

    // C. Maximum Heart Rate (220 - Age) & Training Zone (30 problems)
    for (age in 12..26) {
      val maxHr = 220 - age
      val modLow = (maxHr * 0.6).toInt()
      list.add(
        QSpec(
          topic = "ශාරීරික යෝග්‍යතාව හා හෘද ස්පන්දනය",
          questionText = "වයස අවුරුදු $age ක් වූ ක්‍රීඩකයෙකුගේ උපරිම හෘද ස්පන්දන වේගය (MHR = 220 - වයස) විනාඩියකට කීයද?",
          correct = "වාර $maxHr කි",
          distractors = listOf("වාර ${maxHr - 15} කි", "වාර ${maxHr + 12} කි", "වාර $modLow කි"),
          explanation = "උපරිම හෘද ස්පන්දන වේගය = 220 - $age = $maxHr bpm."
        )
      )
    }

    // D. Vitamin Deficiency & Organ Systems (30 curated MCQs)
    val microFacts = listOf(
      Triple("විටමින් A (රෙටිනෝල්)", "රාත්‍රී අන්ධතාව හා බිටෝ ලප", "කැරට්, ගස්ලබු, කොළ පැහැති පලා වර්ගවල බහුලව අඩංගු වේ."),
      Triple("විටමින් B1 (තයමින්)", "බෙරිබෙරි රෝගය හා ස්නායු දුර්වලතා", "කුරුට්ට සහිත ධාන්‍ය හා නිවුඩු සහල්වලින් ලැබේ."),
      Triple("විටමින් C (ඇස්කෝබික් අම්ලය)", "ස්කර්වි (විදුරුමස්වලින් රුධිරය ගැලීම)", "නෙල්ලි, පේර, දොඩම් සහ දෙහි වැනි ඇඹුල් පලතුරුවල බහුලය."),
      Triple("විටමින් D (කැල්සිෆෙරෝල්)", "රිකට්ස් (අස්ථි විකෘති වීම)", "උදෑසන හිරු එළිය හා මාළු තෙල් මගින් ශරීරයට සැපයේ."),
      Triple("විටමින් K", "රුධිරය කැටි ගැසීම ප්‍රමාද වීම", "කොළ පැහැති පලා හා අක්මාවේ සංශ්ලේෂණය මගින් ලැබේ."),
      Triple("යකඩ (Iron)", "රක්තහීනතාව (Anaemia)", "හිමොග්ලොබින් නිපදවීමට අත්‍යවශ්‍ය වේ."),
      Triple("අයඩීන් (Iodine)", "ගලගණ්ඩය (Goitre) හා බුද්ධි වර්ධන අඩුවීම", "තයිරොයිඩ් ග්‍රන්ථියේ තයිරොක්සින් හෝමෝනයට අවශ්‍ය වේ."),
      Triple("කැල්සියම් (Calcium)", "ඔස්ටියෝපොරෝසිස් හා අස්ථි බිඳෙනසුලු බව", "අස්ථි හා දත් ශක්තිමත් කිරීමට අත්‍යවශ්‍ය ඛනිජයකි."),
      Triple("ප්‍රෝටීන (දැඩි ඌනතාව)", "ක්වාෂියෝකෝර් (Kwashiorkor) - උදරය ඉදිමීම", "සෛල වර්ධනයට හා පටක අලුත්වැඩියාවට උපකාරී වේ."),
      Triple("ප්‍රෝටීන + ශක්ති ඌනතාව", "මැරස්මස් (Marasmus) - අධික කෙට්ටු බව", "කුඩා දරුවන් තුළ දක්නට ලැබෙන දරුණු පෝෂණ ඌනතාවකි.")
    )
    for ((idx, item) in microFacts.withIndex()) {
      val (nutrient, disease, note) = item
      val d1 = microFacts[(idx + 2) % microFacts.size].second
      val d2 = microFacts[(idx + 4) % microFacts.size].second
      val d3 = microFacts[(idx + 6) % microFacts.size].second
      list.add(
        QSpec(
          topic = "පෝෂණ ඌනතා රෝග",
          questionText = "මිනිස් සිරුරේ '$nutrient' ඌන වීම නිසා ප්‍රධාන වශයෙන් වැළඳෙන රෝග තත්ත්වය කුමක්ද?",
          correct = disease,
          distractors = listOf(d1, d2, d3),
          explanation = "$nutrient ඌනතාව නිසා $disease හටගනී. $note"
        )
      )
    }

    val athleticsFacts = listOf(
      Triple("මීටර් 100 කෙටි දුර ධාවනය", "පහළ ආරම්භය (Crouch Start) සහ Starting Blocks", "මීටර් 100, 200, 400 කෙටි දුර ධාවන ඉසව් සඳහා Crouch Start භාවිත කෙරේ."),
      Triple("මීටර් 4 × 100 සහය දිවීම", "මීටර් 30 ක යෂ්ටි හුවමාරු කලාපය (Takeover Zone)", "නව ලෝක මලල ක්‍රීඩා නීති අනුව මීටර් 4×100 හි යෂ්ටි හුවමාරු කලාපය මීටර් 30 කි."),
      Triple("උස පැනීම (High Jump)", "ෆොස්බරි ෆ්ලොප් (Fosbury Flop) ශිල්පීය ක්‍රමය", "පිටුපසින් හරස් පොල්ල පැන යන නවීනතම උස පැනීමේ ක්‍රමයයි."),
      Triple("දුර පැනීම (Long Jump)", "පිම්මේ පියවර (Approach), Take-off, පියාසර හා පතිත වීම", "Take-off පුවරුවේ ප්ලාස්ටිසීන් තීරුවට පාදය ගැටීම වරදකි."),
      Triple("යගුලිය විසි කිරීම (Shot Put)", "O'Brien (Glide) හෝ Rotational ක්‍රමය", "විෂ්කම්භය 2.135 m කවය තුළ සිට Stop Board ඉක්මවා නොයා විසිකළ යුතුය."),
      Triple("හෙල්ල විසි කිරීම (Javelin Throw)", "මීටර් 4 ක අරය සහිත විසි කිරීමේ චාපය", "හෙල්ලයේ තියුණු තුඩ පළමුව බිම ගැටීම නීත්‍යානුකූල වීමට අනිවාර්ය වේ."),
      Triple("කවපෙත්ත විසි කිරීම (Discus)", "විෂ්කම්භය 2.50 m කවය හා අංශක 34.92 ගොඩබෑමේ කෝණය", "කවය තුළ කැරකෙමින් ගම්‍යතාව උපදවා විසි කරයි."),
      Triple("මැරතන් ධාවනය (Marathon)", "කිලෝමීටර් 42.195 (සැතපුම් 26 යාර 385)", "දිගු දුර මාර්ග ධාවන ඉසව්වක් වන අතර ඉහළ විඳදරාගැනීමක් අවශ්‍ය වේ."),
      Triple("මීටර් 110 / 100 කඩුලු මතින් දිවීම", "කඩුලු 10 ක් පැනීම", "කෙටි දුර හා රිද්මය මත පදනම් වූ කඩුලු පැනීමේ ඉසව්වකි."),
      Triple("වොලිබෝල් ක්‍රීඩාව", "මීටර් 18 × 9 පිටිය හා ක්‍රීඩකයන් 6 දෙනෙක්", "කණ්ඩායමකට උපරිම පහර 3 කින් බෝලය ප්‍රතිවාදී පිලට යැවිය යුතුය."),
      Triple("දැල්පන්දු (Netball) ක්‍රීඩාව", "තත්පර 3 නීතිය හා GA, GS යන ක්‍රීඩිකාවන් පමණක් ගෝල විදීම", "පන්දුව අතැතිව ඇවිදීම (Footwork violation) තහනම් වේ."),
      Triple("පාපන්දු (Football) ක්‍රීඩාව", "පිටියේ ක්‍රීඩකයන් 11 ක් සහ විනාඩි 45 බැගින් අර්ධ 2 ක්", "ගෝල රකින්නාට පමණක් දඬුවම් කොටුව තුළ පන්දුව අතින් ඇල්ලිය හැක.")
    )
    for ((idx, item) in athleticsFacts.withIndex()) {
      val (ev, rule, note) = item
      val d1 = athleticsFacts[(idx + 2) % athleticsFacts.size].second
      val d2 = athleticsFacts[(idx + 5) % athleticsFacts.size].second
      val d3 = athleticsFacts[(idx + 8) % athleticsFacts.size].second
      list.add(
        QSpec(
          topic = "මලල ක්‍රීඩා හා කණ්ඩායම් ක්‍රීඩා",
          questionText = "$ev සම්බන්ධයෙන් නිවැරදි තාක්ෂණික කරුණ හෝ නීතිය කුමක්ද?",
          correct = rule,
          distractors = listOf(d1, d2, d3),
          explanation = "$ev — $note"
        )
      )
    }

    return list
  }
}
