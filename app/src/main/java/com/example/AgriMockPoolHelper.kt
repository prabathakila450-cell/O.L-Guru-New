package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool
import java.util.Locale

/**
 * Curated + Parametric Agriculture Science (කෘෂි විද්‍යාව) Question Pool (Grades 10 & 11 O/L).
 * - Filters out meta-exam-advice tips so 100% of MCQs test authentic Grade 10 & 11 Agriculture syllabus content.
 * - Produces 6,500+ strictly unique, non-repeating Agriculture MCQs spanning soil science, agro-climatic zones,
 *   plant nutrition & fertilizer math, tillage & machinery, seed tech & propagation, irrigation, IPM & weed control,
 *   protected/hydroponic culture, livestock/dairy/poultry/beekeeping/aquaculture, post-harvest tech & agribusiness.
 */
object AgriMockPoolHelper {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getPoolSize(): Int = pool.size

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(8000)

    // 1. 100 Curated QuizBankApplied Agriculture MCQs (with clean descriptive topic names)
    val unitNames = listOf(
      "පාංශු විද්‍යාව හා සංරක්ෂණය",
      "ශාක පෝෂණය හා පොහොර",
      "බීජ තාක්ෂණය හා ප්‍රචාරණය",
      "වාරිමාර්ග හා ජල කළමනාකරණය",
      "ඒකාබද්ධ පළිබෝධ පාලනය (IPM)",
      "කාබනික හා පරිසර හිතකාමී ගොවිතැන",
      "සත්ත්ව පාලනය හා පශු සම්පත්",
      "පශ්චාත් අස්වනු තාක්ෂණය",
      "ආරක්ෂිත ගෘහ හා නවීන කෘෂි තාක්ෂණය",
      "කෘෂි ව්‍යවසායකත්වය හා අලෙවිකරණය"
    )
    for (setIdx in 1..10) {
      val topicLabel = unitNames[(setIdx - 1) % unitNames.size]
      for (qIdx in 1..10) {
        val qq = QuizBankApplied.getAgriQuestion("10", setIdx, qIdx, qIdx, "කෘෂි විද්‍යාව")
        raw.add(quizQuestionToSpec(topicLabel, qq))
      }
    }

    // 2. 1,400+ Parametric & Curated Grade 10 & 11 Agriculture Problems across 15+ Syllabus Topics
    raw.addAll(buildParametricAndCuratedAgri())

    // 3. Purified SubjectMasterAgriculture20x20 multi-angle pool (all 20 syllabus categories)
    val syllabusCategories = SubjectMasterAgriculture20x20.getCategories()

    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = syllabusCategories,
        subjectLabel = "කෘෂි විද්‍යාව",
        seedBase = 83
      )
    )

    // 4. ShortAnswerMasterRepository + Matching + Flashcards for Grade 10 & Grade 11 Agriculture (~1,600 specs)
    raw.addAll(buildPoolFromShortAnswers("කෘෂි විද්‍යාව"))

    val metaTipDenyList = listOf(
      "අත් අකුරු සහ ඉදිරිපත් කිරීම",
      "ශරීර සෞඛ්‍යය සහ විභාග මනෝභාවය",
      "ප්‍රශ්න පත්‍රය ලැබුණු පසු",
      "අසම්පූර්ණ ප්‍රශ්න නොතැබීම",
      "ගුරු උපදෙස් පිළිපැදීම",
      "රචනා ප්‍රශ්න ලිවීමේ කලාව"
    )

    val cleaned = raw.mapNotNull { spec ->
      val cleanExp = spec.explanation.replace("විභාග උපදෙස: ", "").trim()
      val cleanQ = spec.questionText.replace("විභාග උපදෙස: ", "").trim()
      val cleanC = spec.correct.replace("විභාග උපදෙස: ", "").trim()
      val cleanD = spec.distractors.map { it.replace("විභාග උපදෙස: ", "").trim() }
      val allText = "$cleanQ | $cleanC | ${cleanD.joinToString(" | ")} | $cleanExp"
      if (metaTipDenyList.any { allText.contains(it) }) {
        null
      } else {
        spec.copy(
          questionText = cleanQ,
          correct = cleanC,
          distractors = cleanD,
          explanation = cleanExp
        )
      }
    }

    val deduped = dedupPool(cleaned)
    return distributeProportionallyAcrossTopics(deduped)
  }

  /**
   * Distributes every topic bucket proportionally over [0.0, 1.0) so that both Grade 10 (front slices)
   * and Grade 11 (back slices) receive a balanced cross-section of 30+ Agriculture topics in every paper.
   */
  private fun distributeProportionallyAcrossTopics(specs: List<QSpec>): List<QSpec> {
    if (specs.size <= 1) return specs
    val byTopic = LinkedHashMap<String, ArrayList<QSpec>>()
    for (s in specs) {
      byTopic.getOrPut(s.topic) { ArrayList() }.add(s)
    }
    data class Positioned(val pos: Double, val topicIdx: Int, val spec: QSpec)
    val positioned = ArrayList<Positioned>(specs.size)
    var tIdx = 0
    for ((topic, list) in byTopic) {
      val m = list.size
      val phaseOffset = ((topic.hashCode() and 0xFF) / 256.0) * 0.35
      for (k in 0 until m) {
        val pos = (k + 0.5 + phaseOffset) / m.toDouble()
        positioned.add(Positioned(pos, tIdx, list[k]))
      }
      tIdx++
    }
    positioned.sortWith(compareBy<Positioned> { it.pos }.thenBy { it.topicIdx })
    return positioned.map { it.spec }
  }

  private fun buildParametricAndCuratedAgri(): List<QSpec> {
    val list = ArrayList<QSpec>(1600)

    // A. Urea (46% N) active Nitrogen & required Urea calculations (90 items)
    for (i in 1..45) {
      val bags = 1 + i
      val totalKg = bags * 50
      val activeN = totalKg * 0.46
      val nStr = String.format(Locale.US, "%.1f", activeN)
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "නයිට්‍රජන් 46% ක් අඩංගු යූරියා (Urea) කිලෝග්‍රෑම් 50 මලු $bags ක (මුළු $totalKg kg) ඇති ශුද්ධ නයිට්‍රජන් (N) ප්‍රමාණය කොපමණද?",
          correct = "$nStr kg",
          distractors = listOf(
            "${String.format(Locale.US, "%.1f", totalKg * 0.60)} kg",
            "${String.format(Locale.US, "%.1f", totalKg * 0.24)} kg",
            "${String.format(Locale.US, "%.1f", activeN + 12.5)} kg"
          ),
          explanation = "ශුද්ධ නයිට්‍රජන් = $totalKg kg × (46 / 100) = $nStr kg."
        )
      )
    }
    for (i in 1..45) {
      val reqN = 23 * i // clean multiple so ureaKg is exact integer * 50
      val ureaKg = reqN * 100 / 46
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "වගාවකට ශුද්ධ නයිට්‍රජන් (N) $reqN kg ක් සැපයීම සඳහා යෙදිය යුතු යූරියා (46% N) පොහොර ප්‍රමාණය කීයද?",
          correct = "$ureaKg kg",
          distractors = listOf(
            "${ureaKg + 25} kg",
            "${(ureaKg / 2).coerceAtLeast(10)} kg",
            "${(reqN * 0.46).toInt()} kg"
          ),
          explanation = "අවශ්‍ය යූරියා ප්‍රමාණය = ($reqN × 100) / 46 = $ureaKg kg."
        )
      )
    }

    // B. MOP (60% K₂O) Potassium calculations - forward & reverse (80 items)
    for (i in 1..40) {
      val totalKg = 25 * i
      val activeK = totalKg * 0.60
      val kStr = String.format(Locale.US, "%.1f", activeK)
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "පොටෑසියම් ඔක්සයිඩ් (K₂O) 60% ක් අඩංගු මියුරියේට් ඔෆ් පොටෑෂ් (MOP) $totalKg kg ක ඇති ශුද්ධ පොටෑෂ් ප්‍රමාණය කීයද?",
          correct = "$kStr kg",
          distractors = listOf(
            "${String.format(Locale.US, "%.1f", totalKg * 0.46)} kg",
            "${String.format(Locale.US, "%.1f", totalKg * 0.30)} kg",
            "${String.format(Locale.US, "%.1f", activeK + 8.0)} kg"
          ),
          explanation = "K₂O ප්‍රමාණය = $totalKg kg × 60% = $kStr kg."
        )
      )
    }
    for (i in 1..40) {
      val reqK = 15 * i
      val mopKg = reqK * 100 / 60
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "බෝග ක්ෂේත්‍රයකට K₂O පෝෂකය $reqK kg ක් ලබාදීමට අවශ්‍ය මියුරියේට් ඔෆ් පොටෑෂ් (MOP — 60% K₂O) ප්‍රමාණය කොපමණද?",
          correct = "$mopKg kg",
          distractors = listOf(
            "${mopKg + 15} kg",
            "${(reqK * 60 / 100)} kg",
            "${mopKg * 2} kg"
          ),
          explanation = "අවශ්‍ය MOP ප්‍රමාණය = ($reqK × 100) / 60 = $mopKg kg."
        )
      )
    }

    // C. TSP (46% P₂O₅) & ERP (28% P₂O₅) Phosphorus calculations (80 items)
    for (i in 1..40) {
      val totalKg = 10 + 10 * i
      val activeP = totalKg * 0.46
      val pStr = String.format(Locale.US, "%.1f", activeP)
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "P₂O₅ 46% ක් අඩංගු ත්‍රිත්ව සුපර් පොස්පේට් (TSP) පොහොර $totalKg kg ක අඩංගු පොස්පරස් පෙන්ටොක්සයිඩ් ප්‍රමාණය කීයද?",
          correct = "$pStr kg",
          distractors = listOf(
            "${String.format(Locale.US, "%.1f", totalKg * 0.21)} kg",
            "${String.format(Locale.US, "%.1f", totalKg * 0.60)} kg",
            "${String.format(Locale.US, "%.1f", activeP + 5.5)} kg"
          ),
          explanation = "TSP හි P₂O₅ අගය 46% බැවින් $totalKg × 0.46 = $pStr kg."
        )
      )
    }
    for (i in 1..40) {
      val erpKg = 25 * i
      val activeP = erpKg * 0.28
      val pStr = String.format(Locale.US, "%.1f", activeP)
      list.add(
        QSpec(
          topic = "ශාක පෝෂණය හා පොහොර ගණනය",
          questionText = "P₂O₅ 28% ක් අඩංගු එප්පාවල රොක් පොස්පේට් (ERP) පොහොර $erpKg kg ක ඇති මුළු පොස්පරස් පෙන්ටොක්සයිඩ් ප්‍රමාණය කීයද?",
          correct = "$pStr kg",
          distractors = listOf(
            "${String.format(Locale.US, "%.1f", erpKg * 0.46)} kg",
            "${String.format(Locale.US, "%.1f", erpKg * 0.60)} kg",
            "${String.format(Locale.US, "%.1f", activeP + 9.0)} kg"
          ),
          explanation = "එප්පාවල රොක් පොස්පේට් (ERP) හි 28% P₂O₅ අඩංගු බැවින් $erpKg × 0.28 = $pStr kg."
        )
      )
    }

    // D. Seed Germination % & Pure Live Seed (PLS %) calculations (100 items)
    val testedCounts = listOf(100, 150, 200, 250, 400, 500)
    for (tested in testedCounts) {
      for (step in 1..10) {
        val rate = 45 + step * 5 // 50%..95%
        val germinated = tested * rate / 100
        list.add(
          QSpec(
            topic = "බීජ තාක්ෂණය හා ප්‍රරෝහණ පරීක්ෂණය",
            questionText = "බීජ ප්‍රරෝහණ පරීක්ෂණයකදී පරීක්ෂා කළ බීජ $tested කින් බීජ $germinated ක් පැළ වූයේ නම් ප්‍රරෝහණ ප්‍රතිශතය කීයද?",
            correct = "$rate%",
            distractors = listOf("${rate - 10}%", "${(rate + 7).coerceAtMost(100)}%", "${rate / 2}%"),
            explanation = "ප්‍රරෝහණ % = ($germinated / $tested) × 100 = $rate%."
          )
        )
      }
    }
    for (purity in listOf(80, 85, 90, 95, 98)) {
      for (germ in listOf(70, 75, 80, 85, 90, 92, 95, 96)) {
        val pls = String.format(Locale.US, "%.1f", (purity * germ) / 100.0)
        list.add(
          QSpec(
            topic = "බීජ තාක්ෂණය හා ප්‍රරෝහණ පරීක්ෂණය",
            questionText = "බීජ තොගයක භෞතික පිරිසිදුතාව $purity% ක් හා ප්‍රරෝහණ ප්‍රතිශතය $germ% ක් නම් එහි සැබෑ ජීව්‍ය බීජ ප්‍රතිශතය (PLS %) කීයද?",
            correct = "$pls%",
            distractors = listOf(
              "${String.format(Locale.US, "%.1f", (purity + germ) / 2.0)}%",
              "${String.format(Locale.US, "%.1f", ((purity * germ) / 100.0) + 6.5)}%",
              "${String.format(Locale.US, "%.1f", ((purity * germ) / 100.0) - 8.0)}%"
            ),
            explanation = "PLS % = (පිරිසිදුතාව × ප්‍රරෝහණ %) / 100 = ($purity × $germ) / 100 = $pls%."
          )
        )
      }
    }

    // E. Plant Population per Hectare (10,000 m² / spacing) (96 items)
    val spacings = listOf(
      Triple(20, 20, 250000), Triple(25, 20, 200000), Triple(25, 25, 160000),
      Triple(40, 25, 100000), Triple(50, 20, 100000), Triple(50, 25, 80000),
      Triple(50, 40, 50000), Triple(50, 50, 40000), Triple(100, 25, 40000),
      Triple(100, 40, 25000), Triple(100, 50, 20000), Triple(100, 100, 10000)
    )
    val hectares = listOf(1, 2, 3, 4, 5, 6, 8, 10)
    for (ha in hectares) {
      for ((rCm, cCm, perHa) in spacings) {
        val total = ha * perHa
        list.add(
          QSpec(
            topic = "බෝග සංස්ථාපනය හා පැළ ඝනත්වය",
            questionText = "පේළි අතර ${rCm} cm සහ පැළ අතර ${cCm} cm පරතරය ඇතිව හෙක්ටයාර $ha ක (හෙක්. 1 = 10,000 m²) සිටුවිය හැකි මුළු පැළ ගණන කීයද?",
            correct = "පැළ $total",
            distractors = listOf("පැළ ${total / 2}", "පැළ ${total * 2}", "පැළ ${total + 5000}"),
            explanation = "පැළ 1 කට ඉඩ = ${(rCm / 100.0)} × ${(cCm / 100.0)} m²; හෙක්. $ha කට = (${ha * 10000}) / (${(rCm * cCm) / 10000.0}) = $total."
          )
        )
      }
    }

    // F. Soil Moisture %, Soil Bulk Density & Soil Porosity % calculations (115 items)
    for (dryG in listOf(40, 50, 80, 100, 120)) {
      for (pct in listOf(10, 15, 20, 25, 30, 35, 40, 45, 50, 60)) {
        val waterG = dryG * pct / 100
        val wetG = dryG + waterG
        list.add(
          QSpec(
            topic = "පාංශු භෞතික විද්‍යාව හා තෙතමනය",
            questionText = "තෙත පස් නියැදියක බර $wetG g වන අතර උඳුන් වියළි බර $dryG g නම් වියළි බර අනුව පාංශු තෙතමන ප්‍රතිශතය කීයද?",
            correct = "$pct%",
            distractors = listOf("${pct + 8}%", "${(pct - 5).coerceAtLeast(2)}%", "${pct * 2}%"),
            explanation = "ජල බර = $wetG - $dryG = $waterG g; තෙතමන % = ($waterG / $dryG) × 100 = $pct%."
          )
        )
      }
    }
    for (vol in listOf(50, 80, 100, 150, 200)) {
      for (bdTimes10 in listOf(11, 12, 13, 14, 15, 16, 17)) {
        val bd = bdTimes10 / 10.0
        val dryMass = (vol * bd).toInt()
        val bdStr = String.format(Locale.US, "%.1f g/cm³", bd)
        list.add(
          QSpec(
            topic = "පාංශු භෞතික විද්‍යාව හා තෙතමනය",
            questionText = "පරිමාව $vol cm³ ක් වූ නොකැළඹුණු පස් නියැදියක උඳුන් වියළි ස්කන්ධය $dryMass g නම් පසෙහි තොග ඝනත්වය (Bulk Density) කීයද?",
            correct = bdStr,
            distractors = listOf(
              String.format(Locale.US, "%.1f g/cm³", bd + 0.4),
              String.format(Locale.US, "%.1f g/cm³", (bd - 0.3).coerceAtLeast(0.4)),
              String.format(Locale.US, "%.1f g/cm³", bd * 2.0)
            ),
            explanation = "තොග ඝනත්වය = වියළි ස්කන්ධය / මුළු පරිමාව = $dryMass / $vol = $bdStr."
          )
        )
      }
    }
    // Soil porosity % = (1 - BulkDensity / ParticleDensity) * 100 (Particle Density = 2.65 g/cm³)
    val soilDensityPairs = listOf(
      Pair("1.06", "60%"), Pair("1.19", "55%"), Pair("1.325", "50%"),
      Pair("1.46", "45%"), Pair("1.59", "40%"), Pair("1.72", "35%"),
      Pair("0.93", "65%"), Pair("1.855", "30%"), Pair("1.10", "58%"),
      Pair("1.25", "53%"), Pair("1.40", "47%"), Pair("1.50", "43%")
    )
    for ((bdStr, porStr) in soilDensityPairs) {
      val porVal = porStr.removeSuffix("%").toInt()
      list.add(
        QSpec(
          topic = "පාංශු භෞතික විද්‍යාව හා තෙතමනය",
          questionText = "පසක තොග ඝනත්වය $bdStr g/cm³ සහ අංශු ඝනත්වය (Particle Density) 2.65 g/cm³ නම් එම පසෙහි සවිවරභාවය (Porosity) ආසන්න වශයෙන් කීයද?",
          correct = porStr,
          distractors = listOf("${porVal - 12}%", "${(porVal + 14).coerceAtMost(95)}%", "${100 - porVal}%"),
          explanation = "සවිවරභාවය % = (1 - $bdStr / 2.65) × 100 ≈ $porStr."
        )
      )
    }

    // G. Poultry FCR (Feed Conversion Ratio) & Agribusiness Cost/Profit/BEP calculations (130 items)
    for (wtKg in listOf(2, 3, 4, 5, 10)) {
      for (fcr10 in listOf(15, 16, 17, 18, 19, 20, 22, 25)) {
        val feedKg = (wtKg * fcr10) / 10.0
        val fcr = fcr10 / 10.0
        val feedStr = if (feedKg == feedKg.toInt().toDouble()) "${feedKg.toInt()}" else String.format(Locale.US, "%.1f", feedKg)
        val fcrStr = String.format(Locale.US, "%.1f", fcr)
        list.add(
          QSpec(
            topic = "සත්ත්ව පාලනය හා පශු සම්පත්",
            questionText = "බ්‍රොයිලර් කුකුළු පැටවෙකු ශරීර බර $wtKg kg ක් ලබා ගැනීමට ආහාර $feedStr kg ක් පරිභෝජනය කළේ නම් එහි ආහාර පරිවර්තන අනුපාතය (FCR) කීයද?",
            correct = fcrStr,
            distractors = listOf(
              String.format(Locale.US, "%.1f", fcr + 0.5),
              String.format(Locale.US, "%.1f", (fcr - 0.4).coerceAtLeast(0.5)),
              String.format(Locale.US, "%.1f", 1.0 / fcr)
            ),
            explanation = "FCR = පරිභෝජනය කළ ආහාර බර / ලබාගත් ශරීර බර = $feedStr / $wtKg = $fcrStr."
          )
        )
      }
    }
    for (qty in listOf(100, 150, 200, 250, 300)) {
      for (price in listOf(120, 150, 180, 200, 250)) {
        val varPerUnit = price / 2
        val fixedCost = 5000 + (qty * 10)
        val totalCost = fixedCost + qty * varPerUnit
        val revenue = qty * price
        val profit = revenue - totalCost
        list.add(
          QSpec(
            topic = "කෘෂි ව්‍යවසායකත්වය හා අලෙවිකරණය",
            questionText = "එළවළු නිෂ්පාදන ඒකක $qty ක් ඒකකයක් රු. $price බැගින් විකුණූ ගොවියෙකුගේ ස්ථාවර පිරිවැය රු. $fixedCost ක් හා ඒකක විචල්‍ය පිරිවැය රු. $varPerUnit ක් නම් ශුද්ධ ලාභය කීයද?",
            correct = "රු. $profit",
            distractors = listOf("රු. $revenue", "රු. ${profit + fixedCost}", "රු. ${(profit / 2)}"),
            explanation = "මුළු ආදායම = රු. $revenue; මුළු පිරිවැය = $fixedCost + ($qty × $varPerUnit) = රු. $totalCost; ශුද්ධ ලාභය = රු. $profit."
          )
        )
      }
    }
    // Break-Even Point (BEP) calculations (25 items)
    for (fc in listOf(10000, 15000, 20000, 25000, 30000)) {
      for (margin in listOf(20, 25, 40, 50, 100)) {
        val vc = 60
        val sp = vc + margin
        val bep = fc / margin
        list.add(
          QSpec(
            topic = "කෘෂි ව්‍යවසායකත්වය හා අලෙවිකරණය",
            questionText = "කෘෂි ව්‍යාපාරයක ස්ථාවර පිරිවැය රු. $fc ක්, ඒකක විචල්‍ය පිරිවැය රු. $vc ක් සහ ඒකක විකුණුම් මිල රු. $sp ක් නම් සමච්ඡේද ලක්ෂ්‍යය (BEP) කොපමණද?",
            correct = "ඒකක $bep",
            distractors = listOf("ඒකක ${bep / 2}", "ඒකක ${bep * 2}", "ඒකක ${fc / sp}"),
            explanation = "BEP = ස්ථාවර පිරිවැය / (ඒකක මිල - ඒකක විචල්‍ය පිරිවැය) = $fc / ($sp - $vc) = ඒකක $bep."
          )
        )
      }
    }

    // H. Comprehensive Topic-Bucketed Grade 10 & 11 Curated Concept Bank (10 Topics × ~22 Facts × 2 Angles = 440+ MCQs)
    val topicFactBank: List<Triple<String, List<Triple<String, String, String>>, String>> = listOf(
      Triple(
        "ශ්‍රී ලංකාවේ කෘෂි දේශගුණික කලාප හා වගා රටා",
        listOf(
          Triple("තෙත් කලාපය (Wet Zone)", "වාර්ෂික වර්ෂාපතනය 2,500 mm ට වැඩි වන නිරිතදිග කලාපය (තේ, රබර්, පොල්, කුළුබඩු)", "WL, WM සහ WU ලෙස උන්නතාංශ කලාප 3 කට බෙදේ."),
          Triple("වියළි කලාපය (Dry Zone)", "වාර්ෂික වර්ෂාපතනය 1,750 mm ට අඩු වැව් වාරි ජලයෙන් වී හා අතිරේක බෝග වවන කලාපය", "රතු-දුඹුරු පස් (RBE) ප්‍රධාන පස් වර්ගයයි."),
          Triple("අතරමැදි කලාපය (Intermediate Zone)", "වාර්ෂික වර්ෂාපතනය 1,750 - 2,500 mm අතර පවතින කලාපය (පොල්, ගම්මිරිස්, කෙසෙල්)", "තෙත් හා වියළි කලාප අතර සංක්‍රාන්ති ප්‍රදේශයයි."),
          Triple("උප කෘෂි දේශගුණික කලාප 46", "වර්ෂාපතනය, උන්නතාංශය සහ පාංශු ලක්ෂණ අනුව ශ්‍රී ලංකාව බෙදා ඇති කෘෂි උප කලාප ගණන", "බෝග නිර්දේශ ලබාදීමේදී භාවිත කෙරේ."),
          Triple("මහ කන්නය (Maha Season)", "ඊසානදිග මෝසමෙන් ඔක්තෝබර් සිට මාර්තු දක්වා වැඩිම වර්ෂාපතනය ලැබෙන ප්‍රධාන වගා කන්නය", "දිවයින පුරා වැඩිම වී වපසරියක් වගා කරන කන්නයයි."),
          Triple("යල කන්නය (Yala Season)", "නිරිතදිග මෝසමෙන් අප්‍රේල් සිට සැප්තැම්බර් දක්වා ක්‍රියාත්මක වන කෙටි වගා කන්නය", "වියළි කලාපයේ වාරි ජලය හා අතිරේක බෝග සඳහා වැදගත් වේ."),
          Triple("එල්ලංගා වැව් පද්ධතිය (Cascade Tank System)", "ජලධාරා ද්‍රෝණියක ඉහළ සිට පහළට වැව් මාලාවක් සම්බන්ධ කර ජලය සංරක්ෂණය කිරීම", "අනුරාධපුර හා පොළොන්නරු යුගයේ සුවිශේෂී තිරසාර වාරි උරුමයකි."),
          Triple("රතු-දුඹුරු පස් (Reddish Brown Earth - RBE)", "වියළි කලාපයේ බහුලව දක්නට ලැබෙන කැල්සියම් හා මැග්නීසියම් පොහොසත් පස", "තෙත් වූ විට මෘදු වන අතර වියළුණු විට තද වේ."),
          Triple("රතු-කහ පොඩ්සොලික් පස් (Red-Yellow Podzolic)", "තෙත් කලාපයේ සහ කඳුකරයේ තේ හා රබර් වගාවට බහුලව හමුවන ආම්ලික පස", "අධික වර්ෂාවෙන් භෂ්ම සේදී යාමෙන් ආම්ලික වී ඇත."),
          Triple("ලැටොසෝල් පස (Latosol)", "උතුරු-වයඹ වෙරළබඩ කලාපයේ (මන්නාරම-පුත්තලම) දැකිය හැකි ගැඹුරු රතු වැලි ලෝම පස", "අඹ, කජු සහ එළවළු වගාවට ජලසම්පාදනය යටතේ සුදුසුය."),
          Triple("දියළු පස් (Alluvial Soils)", "ගංගා පිටාර තැනිතලාවල සහ නිම්නවල තැන්පත් වන ඉතා සාරවත් වී වගා පස", "මහවැලි, කැලණි, වලවේ ගංගා නිම්නවල බහුලයි."),
          Triple("රතු-ප්‍රභේදිත කඳුකර එළවළු කලාපය (WU2/WU3)", "නුවරඑළිය, වැලිමඩ ආශ්‍රිතව අර්තාපල්, කැරට්, ගෝවා සහ ලීක්ස් වවන සිසිල් කලාපය", "උන්නතාංශය මීටර් 900 ට වැඩි උඩරට තෙත් කලාපයයි."),
          Triple("හේන් ගොවිතැන (Chena Cultivation)", "වියළි කලාපයේ වර්ෂා ජලයෙන් කුරක්කන්, තල, මුං සහ බඩඉරිඟු වැවූ සාම්ප්‍රදායික ක්‍රමය", "දීර්ඝ විවේක කාලයක් (Fallow period) පසට විවේක දෙයි."),
          Triple("ස්ටීවන්සන් ආවරණය (Stevenson Screen)", "කෘෂි කාලගුණ මධ්‍යස්ථානයක උෂ්ණත්වමාන සහ ආර්ද්‍රතාමාන සුදු ලෑලි පෙට්ටියක තැබීම", "සෘජු හිරු එළියෙන් හා වැස්සෙන් උපකරණ ආරක්ෂා කරයි."),
          Triple("කැප්පෙටිපොළ-වැලිමඩ කෘෂි කලාපය", "අතරමැදි උඩරට කලාපයේ (IU) ප්‍රධාන වශයෙන් අර්තාපල්, තක්කාලි හා බෝංචි වවන ප්‍රදේශය", "මහ හා යල කන්න දෙකෙහිම වගා කෙරේ."),
          Triple("දෙකන්න මිශ්‍ර පලතුරු ගෙවතු (Kandyan Forest Gardens)", "මහනුවර අවට තට්ටු කිහිපයකින් යුත් කුළුබඩු, පලතුරු හා දැව ශාක මිශ්‍ර කෘෂි වන ක්‍රමය", "ජෛව විවිධත්වය අතින් ඉහළම පාරිසරික පද්ධතියකි."),
          Triple("අන්තර් බෝග වගාව (Intercropping)", "ප්‍රධාන වැවිලි බෝග පේළි අතර (උදා: පොල් ඉඩමේ ගම්මිරිස්/අන්නාසි) අතිරේක බෝග වැවීම", "ඉඩමේ ඒකකයකින් ලැබෙන ආදායම උපරිම කරයි."),
          Triple("සමෝච්ච හෙල්මළු වගාව (Terracing)", "බෑවුම් කඳුකර බිම් පඩිපෙළ ආකාරයට කපා පාංශු ඛාදනය වැළැක්වීම", "තේ සහ උඩරට එළවළු වගාවේදී බහුලව යොදයි.")
        ),
        "ශ්‍රී ලංකාවේ කෘෂි දේශගුණික කලාප හා පාරිසරික වගා පද්ධති ඒකකය."
      ),
      Triple(
        "පාංශු විද්‍යාව හා පාංශු සංරක්ෂණය",
        listOf(
          Triple("A හොරයිසනය (Top Soil)", "කාබනික ද්‍රව්‍ය (හියුමස්) හා ශාක මුල් බහුලවම අඩංගු ඉහළම වගා පාංශු ස්ථරය", "පාංශු පැතිකඩේ වඩාත් සාරවත්ම ස්ථරය වේ."),
          Triple("පාංශු pH අගය 5.5 - 6.8", "බොහෝ කෘෂිකාර්මික බෝග වගාවට වඩාත්ම සුදුසු පාංශු ප්‍රතික්‍රියා පරාසය", "මෙම පරාසයේදී බොහෝ ශාක පෝෂක උපරිමයෙන් ලභ්‍ය වේ."),
          Triple("ඩොලමයිට් (Dolomite - CaMg(CO₃)₂)", "ආම්ලික පසෙහි pH අගය ඉහළ නැංවීමට යොදන කැල්සියම් හා මැග්නීසියම් කාබනේට් පාෂාණ කුඩු", "pH අගය නිවැරදි කර මැග්නීසියම් පෝෂණය ද සපයයි."),
          Triple("ජිප්සම් (Gypsum - CaSO₄·2H₂O)", "සෝඩියම් අධික ලවණ/ක්ෂාරීය පස් ප්‍රතිකාර කිරීමට යොදන පාංශු සංශෝධකය", "විනිමය කළ හැකි සෝඩියම් (Na⁺) අයන කැල්සියම් මඟින් විස්ථාපනය කරයි."),
          Triple("ලෝම පස (Loam Soil)", "වැලි, රෝම සහ මැටි සමබරව ඇති ජලය හා වාතය මනාව රඳවන විශිෂ්ට වගා පස", "මූල වර්ධනයට හා පෝෂක රඳවා ගැනීමට ඉතා සුදුසුය."),
          Triple("කේෂාකර්ෂණ ජලය (Capillary Water)", "පසෙහි ක්ෂුද්‍ර සිදුරු තුළ රැඳී ඇති ශාක මුල්වලට සෘජුවම උරාගත හැකි ජලය", "ක්ෂේත්‍ර ධාරිතාව හා ස්ථිර මැලවීමේ ලක්ෂ්‍යය අතර පවතී."),
          Triple("ක්ෂේත්‍ර ධාරිතාව (Field Capacity)", "ගුරුත්වාකර්ෂණ ජලය බැස ගිය පසු පස තුළ රඳා පවතින උපරිම ජල ප්‍රමාණය", "බෝග වර්ධනයට ප්‍රශස්තම තෙතමන තත්ත්වයයි."),
          Triple("ස්ථිර මැලවීමේ ලක්ෂ්‍යය (PWP)", "ශාකයට පසෙන් ජලය උරාගත නොහැකිව ස්ථිරවම මැලවී යන පාංශු තෙතමන මට්ටම", "ජලය දැමුවද ශාකය නැවත ප්‍රකෘතිමත් නොවේ."),
          Triple("SALT තාක්ෂණය", "බෑවුම් ඉඩම්වල සමෝච්ච රේඛා ඔස්සේ ග්ලිරිසීඩියා හෝ ඉපිල්-ඉපිල් වැටි ද්විත්ව පේළි සිටුවීම", "ජෛව පාංශු සංරක්ෂණ ක්‍රමයක් ලෙස කඳුකරයේ භාවිත වේ."),
          Triple("ලොක් ඇන්ඩ් ස්පිල් කාණු (Lock & Spill Drains)", "වැසි ජලයේ ගලායාමේ වේගය පාලනය කර රොන්මඩ තැන්පත් කරවන සමෝච්ච කාණු ක්‍රමය", "තේ වතු හා බෑවුම් ගොවිපළවල බහුලව යොදයි."),
          Triple("වසුන් යෙදීම (Mulching)", "පස මතුපිට පිදුරු, වියළි තෘණ හෝ කළු පොලිතීන් ඇතිරීමෙන් තෙතමනය රැකීම", "වැහි බිංදු පහර (Splash erosion) හා වල් පැළ වැළැක්වේ."),
          Triple("තලීය, පීලි හා දෙණි ඛාදනය", "වැසි ජලයෙන් උඩුපස ස්ථර පිටින් සේදී ගොස් ක්‍රමයෙන් ගැඹුරු කාණු සෑදීමේ පියවර", "දෙණි ඛාදනය (Gully erosion) වඩාත්ම විනාශකාරී වේ."),
          Triple("පසෙහි පරිමා සංයුතිය (25% ජලය, 25% වාතය)", "ප්‍රශස්ත වගා පසක 45% ඛනිජ, 5% කාබනික ද්‍රව්‍ය, 25% ජලය හා 25% වාතය තිබීම", "මූල ශ්වසනයට 25% වායු අවකාශය අනිවාර්ය වේ."),
          Triple("කැටායන හුවමාරු ධාරිතාව (CEC)", "පසෙහි මැටි හා හියුමස් අංශු මත K⁺, Ca²⁺, NH₄⁺ වැනි පෝෂක අයන රඳවා ගැනීමේ ශක්තිය", "කාබනික පොහොර යෙදීමෙන් වැලි පසේ CEC ඉහළ නැංවිය හැකිය."),
          Triple("වැලි, රෝම හා මැටි අංශු ප්‍රමාණ", "වැලි (2.0-0.05 mm), රෝම (0.05-0.002 mm) සහ මැටි (0.002 mm ට අඩු) ලෙස වර්ග කිරීම", "පස් වියමන (Soil Texture) ත්‍රිකෝණයෙන් මේවා කියවයි."),
          Triple("ලවණීකරණය (Salinization)", "වියළි කලාපයේ දුර්වල ජලවහනය හා අධික වාෂ්පීකරණය නිසා මතුපිට ලවණ තැන්පත් වීම", "භෝගවලට ආස්‍රැති ආතතිය ඇති කර වර්ධනය බාල කරයි.")
        ),
        "පාංශු විද්‍යාව හා පාංශු සංරක්ෂණ ඒකකය."
      ),
      Triple(
        "ශාක පෝෂණය හා පොහොර විද්‍යාව",
        listOf(
          Triple("නයිට්‍රජන් (N) ඌනතා ලක්ෂණය", "ශාකයේ පහළ පැරණි පත්‍ර ඒකාකාරව කහ පැහැ ගැන්වීම (Chlorosis)", "නයිට්‍රජන් චංචල පෝෂකයක් නිසා පැරණි පත්‍රවලින් ළපටි පත්‍ර වෙත යයි."),
          Triple("පොස්පරස් (P) ඌනතා ලක්ෂණය", "පැරණි පත්‍ර යටි පැත්තේ දම් හෝ රතු-දුඹුරු පැහැයක් ගැනීම හා මූල වර්ධනය බාලවීම", "ATP ශක්ති හුවමාරුවට හා මුල් ඇදීමට P අත්‍යවශ්‍ය වේ."),
          Triple("පොටෑසියම් (K) ඌනතා ලක්ෂණය", "පැරණි පත්‍රවල දාර සහ අග්‍ර පිලිස්සුණු ආකාරයෙන් දුඹුරු පැහැ වී වියළී යාම", "පූටිකා පාලනයට හා රෝග ප්‍රතිරෝධයට K වැදගත් වේ."),
          Triple("මැග්නීසියම් (Mg) ඌනතා ලක්ෂණය", "පැරණි පත්‍රවල හරිත නාරටි අතර කොටස් කහ පැහැ වීම (Interveinal chlorosis)", "හරිතප්‍රද (Chlorophyll) අණුවේ මධ්‍ය පරමාණුව මැග්නීසියම් වේ."),
          Triple("කැල්සියම් (Ca) ඌනතා ලක්ෂණය", "ළපටි අග්‍රස්ථ කළල හා මූල අග්‍ර මැරී යාම සහ තක්කාලිවල Blossom End Rot ඇතිවීම", "කැල්සියම් අචංචල පෝෂකයක් බැවින් අලුත් වර්ධනයට මුලින් බලපායි."),
          Triple("බෝරෝන් (B) හා සින්ක් (Zn) ක්ෂුද්‍ර පෝෂක", "බෝරෝන් ඌනතාවෙන් පලතුරු පැළීම ද, සින්ක් ඌනතාවෙන් කුඩා පත්‍ර (Little leaf) රෝගය ද සෑදේ", "ශාකයට ඉතා සුළු ප්‍රමාණවලින් (ppm) අවශ්‍ය අත්‍යවශ්‍ය පෝෂක වේ."),
          Triple("යූරියා (CO(NH₂)₂ — 46% N)", "වැඩිම නයිට්‍රජන් සාන්ද්‍රණයක් සහිත ජලයේ ඉක්මනින් දියවන රසායනික පොහොර", "වී වගාවේ මතුපිට පොහොර (Top dressing) ලෙස බහුලව යොදයි."),
          Triple("ත්‍රිත්ව සුපර් පොස්පේට් (TSP — 46% P₂O₅)", "මූලික පොහොර (Basal dressing) ලෙස බීජ සිටුවීමට පෙර පසට යොදන පොස්පරස් ප්‍රභවය", "පසේ අචංචල නිසා මුල් කලාපය ආසන්නයේ තැබිය යුතුය."),
          Triple("මියුරියේට් ඔෆ් පොටෑෂ් (MOP — 60% K₂O)", "පොටෑසියම් ක්ලෝරයිඩ් ලෙස හඳුන්වන පලතුරු හා ධාන්‍ය ගුණාත්මක බව වැඩි කරන පොහොර", "බීජ පිරෙන හා මල් පිපෙන අවධිවල ඉහළ ප්‍රතිඵල දෙයි."),
          Triple("එප්පාවල රොක් පොස්පේට් (ERP — 28% P₂O₅)", "ශ්‍රී ලංකාවේ එප්පාවල නිධියෙන් නිපදවන සෙමින් නිදහස් වන ස්වභාවික පොස්පේට් පොහොර", "තේ, රබර්, පොල් වැනි බහුවාර්ෂික බෝගවලට ආර්ථිකව වාසිදායකය."),
          Triple("කොම්පෝස්ට් C:N අනුපාතය (30:1)", "කොම්පෝස්ට් ගොඩක් සැකසීමේදී දුඹුරු කාබන් ද්‍රව්‍ය හා කොළ නයිට්‍රජන් ද්‍රව්‍යවල ප්‍රශස්ත අනුපාතය", "උෂ්ණත්වය 60°C දක්වා ගොස් රෝග කාරක හා වල් බීජ විනාශ වේ."),
          Triple("වර්මිකොම්පෝස්ට් (Vermicompost)", "Eisenia fetida ගැඩවිලුන් ලවා කාබනික අපද්‍රව්‍ය ජීර්ණය කර සකසන පෝෂක හා හෝමෝන බහුල පොහොර", "කාබනික බෝග තවාන්වල ඉතා උසස් ප්‍රතිඵල ලබාදෙයි."),
          Triple("රයිසෝබියම් (Rhizobium) බැක්ටීරියාව", "රනිල කුලයේ (මුං, කව්පි, බෝංචි) මූල ගැටිති තුළ වායුගෝලීය නයිට්‍රජන් තිර කරන ජීවියා", "රසායනික නයිට්‍රජන් පොහොර අවශ්‍යතාව 40-60% කින් අඩු කරයි."),
          Triple("ඇසොල්ලා (Azolla) ජෛව පොහොර", "කුඹුරු ජලයේ වැඩෙන පර්ණාංග ශාකය (Anabaena සයනොබැක්ටීරියාව සමඟ N තිර කරයි)", "වී වගාවේ වල් මර්දනයට ද ස්වභාවිකව උපකාරී වේ."),
          Triple("හරිත පොහොර (Green Manure — සන්හෙම්ප් / ග්ලිරිසීඩියා)", "ඩේන්චා, සන්හෙම්ප් හෝ ග්ලිරිසීඩියා කොළ පසට යට කර කාබනික ද්‍රව්‍ය හා N සැපයීම", "පසේ ක්ෂුද්‍රජීවී ගහනය හා ජල ධාරිතාව වර්ධනය කරයි."),
          Triple("පොහොර යෙදීමේ 4R මූලධර්මය", "නිවැරදි ප්‍රභවය, නිවැරදි ප්‍රමාණය, නිවැරදි වේලාව සහ නිවැරදි ස්ථානයට පොහොර යෙදීම", "භූගත ජල දූෂණය හා පොහොර නාස්තිය අවම කරයි.")
        ),
        "ශාක පෝෂණය හා කාබනික/රසායනික පොහොර භාවිතය."
      ),
      Triple(
        "බීජ තාක්ෂණය හා තවාන් කළමනාකරණය",
        listOf(
          Triple("සහතික කළ බීජ (Certified Seeds)", "අභිජනක, පදනම් හා ලියාපදිංචි පරම්පරා හරහා පැමිණි ගොවීන්ට බෙදාහරින පිරිසිදු බීජ පන්තිය", "නිල් පැහැති සහතික ලේබලයකින් හඳුනාගනී."),
          Triple("බීජ සුප්තතාව (Seed Dormancy)", "ජලය, ඔක්සිජන් හා ප්‍රශස්ත උෂ්ණත්වය තිබියදීත් ජීවී බීජයක් ප්‍රරෝහණය නොවී පැවතීම", "තේක්ක හා ඇකේෂියා බීජවල ඝන ආවරණය සීරීමෙන් (Scarification) මෙය බිඳිය හැකිය."),
          Triple("ටෙට්‍රාසෝලියම් පරීක්ෂාව (Tetrazolium Test)", "2,3,5-triphenyl tetrazolium chloride යොදා ජීවී බීජ කලලය රතු පැහැ ගැන්වීමෙන් ජීව්‍යතාව බැලීම", "ප්‍රරෝහණයට දින ගණනක් නොසිට පැය කිහිපයකින් ප්‍රතිඵල ලබාගනී."),
          Triple("ප්ලග් තැටි හෙවත් ප්‍රෝ-ට්‍රේ (Pro-trays)", "කොකෝපීට් පුරවා එක් කුහරයක එක් එළවළු පැළයක් බැගින් හදන තවාන් තැටි", "මුල්වලට කිසිදු හානියක් නොවී ක්ෂේත්‍රයේ සිටුවිය හැකිය."),
          Triple("පැළ දැඩි කිරීම (Hardening Off)", "තවානෙන් ක්ෂේත්‍රයට ගෙනයාමට සතියකට පෙර සෙවණ හා ජලය ක්‍රමයෙන් අඩු කිරීම", "තද හිරු රශ්මියට හා සුළඟට පැළ ඔරොත්තු දීමට සූදානම් කරයි."),
          Triple("ඩැම්පිං ඕෆ් / දියමලන් කෑම (Damping-off)", "Pythium හෝ Rhizoctonia දිලීර නිසා තවාන් පැළ පාමුලින් කුණු වී වැටෙන රෝගය", "තවාන් පස් සූර්ය තාපනයෙන් (Solarization) ජීවාණුහරණය කිරීමෙන් වළක්වයි."),
          Triple("තවාන් පස් මිශ්‍රණය (1:1:1)", "මතුපිට පස්, දිරාපත් කොම්පෝස්ට් හා වැලි/කොහුබත් සම ප්‍රමාණවලින් මිශ්‍ර කිරීම", "හොඳ වාතනය හා ජලවහනය සහිත පෝෂ්‍යදායී මාධ්‍යයකි."),
          Triple("උස් පාත්ති තවාන් (Raised Beds)", "තෙත් කලාපයේ හා වැසි සමයේ අතිරික්ත ජලය බැස යාමට 15 cm උසින් සකසන තවාන් පාත්ති", "මුල් කුණුවීම හා දිලීර රෝග වළක්වයි."),
          Triple("ගිල්වුණු පාත්ති තවාන් (Sunken Beds)", "වියළි කලාපයේ ජලය හා තෙතමනය රඳවා ගැනීමට පොළොව මට්ටමට පහළින් සකසන තවාන්", "වාෂ්පීකරණ ජල හානිය අවම කරයි."),
          Triple("ගන්නෝරුව PGRC ජාන බැංකුව", "ශ්‍රී ලංකාවේ දේශීය බීජ හා ශාක ජාන සම්පත් -20°C හා -4°C යටතේ සංරක්ෂණය කරන ආයතනය", "සාම්ප්‍රදායික වී හා එළවළු ප්‍රභේද 15,000+ ආරක්ෂා කරයි."),
          Triple("බීජ ශුද්ධතාව හා ප්‍රරෝහණ සම්මතය", "සහතික කළ වී බීජයක භෞතික පිරිසිදුතාව අවම 98% හා ප්‍රරෝහණය අවම 85% වීම", "ක්ෂේත්‍රයේ ඒකාකාර පැළ ගහනයක් සහතික කරයි.")
        ),
        "බීජ තාක්ෂණය, සුප්තතාව හා තවාන් කළමනාකරණය."
      ),
      Triple(
        "ශාක ප්‍රචාරණය හා බද්ධ කිරීමේ ක්‍රම",
        listOf(
          Triple("අනුජය හා ග්‍රාහකය (Scion & Rootstock)", "බද්ධ කිරීමේදී උසස් ඵල ගෙන එන ඉහළ අංකුරය අනුජය ද, මුල් පද්ධතිය සපයන ශාකය ග්‍රාහකය ද වේ", "දෙකෙහිම කැම්බියම් පටක මනාව ගැළපිය යුතුය."),
          Triple("කැම්බියම් පටකය (Cambium Layer)", "බද්ධ කළ අනුජය හා ග්‍රාහකය සනාල පටකවලින් එකට පෑස්සීමට හේතු වන සක්‍රීය විභාජක ස්ථරය", "බද්ධ සාර්ථකත්වය සඳහා කැම්බියම් ස්පර්ශය අනිවාර්ය වේ."),
          Triple("කුඤ්ඤ බද්ධය (Cleft Grafting)", "ග්‍රාහක කඳ V හැඩයට පළා අනුජයේ පාදය කුඤ්ඤයක් සේ කපා ඇතුළු කර බැඳීම", "අඹ, අලිගැටපේර සහ දූරියන් ප්‍රචාරණයට බහුලව භාවිත කෙරේ."),
          Triple("T-අංකුර බද්ධය (T-Budding)", "ග්‍රාහකයේ පොත්ත T හැඩයට කපා ඒ තුළට පළිහ හැඩැති අංකුර පොත්තක් ඇතුළු කිරීම", "දොඩම්, දෙහි හා රෝස සඳහා ඉතා සාර්ථක ක්‍රමයකි."),
          Triple("පැච් බද්ධය (Patch Budding)", "සෘජුකෝණාස්‍රාකාර පොතු කැබැල්ලක් ඉවත් කර අනුජයේ අංකුර පැච් එකක් සවිකිරීම", "ඝන පොතු ඇති රබර් සහ රඹුටන් ශාක සඳහා නිර්දේශිතය."),
          Triple("වායව පතිතය / ගුටි බැඳීම (Air Layering)", "අත්තක පොතු වළල්ලක් ඉවත් කර තෙත කොහුබත් ඔතා මව් ශාකයේදීම මුල් අද්දවා ගැනීම", "පේර, දෙළුම්, ලෙමන් හා රඹුටන් සඳහා යොදයි."),
          Triple("පටක රෝපණය (Tissue Culture)", "ජීවාණුහරිත පෝෂක මාධ්‍යයක කුඩා ශාක කොටසකින් (Explant) වයිරස් රහිත පැළ දහස් ගණනක් සෑදීම", "කෙසෙල් (ආනමාලු/ඇඹුල්), අන්නාසි හා ඕකිඩ් සඳහා භාවිත වේ."),
          Triple("ඔක්සින් හෝමෝනය (IBA / NAA)", "දඬු කැබලිවල හා වායව පතිතයේ මුල් ඇදීම උත්තේජනය කිරීමට ගල්වන මුල් අද්දවන හෝමෝනය", "අර්ධ දැවමය හා දැවමය දඬු පැළවීමේ සීඝ්‍රතාව ඉහළ නංවයි."),
          Triple("මොරෙයියන් (Suckers) හා ධාවක (Runners)", "කෙසෙල් හා අන්නාසි මොරෙයියන් මඟින් ද, ස්ට්‍රෝබෙරි හා ගොටුකොළ ධාවක මඟින් ද බෝවීම", "ස්වාභාවික වර්ධක ප්‍රචාරණ ව්‍යුහ ලෙස හැඳින්වේ."),
          Triple("මව් ශාකයට 100% සමාන පරම්පරාව (Clones)", "අලිංගික/වර්ධක ප්‍රචාරණයෙන් ලැබෙන පැළවල රසය, අස්වැන්න හා ඵල හැඩය මව් ශාකයට සමාන වීම", "ඵල දැරීමට ගතවන කාලය බීජ පැළවලට වඩා ඉතා අඩුය.")
        ),
        "ශාක ප්‍රචාරණය හා බද්ධ කිරීමේ ක්‍රම ඒකකය."
      ),
      Triple(
        "කෘෂි යන්ත්‍රෝපකරණ හා ජලසම්පාදන ඉංජිනේරු විද්‍යාව",
        listOf(
          Triple("මෝල්ඩ්බෝඩ් නගුල (Moldboard Plow)", "පස ගැඹුරට කපා උඩ යට පෙරළා වල් පැළෑටි යටපත් කරන ප්‍රාථමික බිම් සැකසුම් නගුල", "Share, Moldboard, Landside සහ Beam ප්‍රධාන කොටස් වේ."),
          Triple("තැටි නගුල (Disc Plow)", "කැරකෙන උත්තල වානේ තැටි මඟින් ගල් හා මුල් බහුල තද පස් පෙරළීමට යොදන නගුල", "බාධක උඩින් පෙරළී යන නිසා නඩත්තුව පහසුය."),
          Triple("රොටවේටරය (Rotavator)", "ට්‍රැක්ටරයේ PTO පතුවළින් ක්‍රියාත්මක වී පස් කැට කුඩු කර මට්ටම් කරන ද්විතීයික යන්ත්‍රය", "තනි ධාවනයකින් බිම බීජ වැපිරීමට සුදුසු කරයි."),
          Triple("ඒකාබද්ධ අස්වනු නෙළනය (Combine Harvester)", "ගොයම් කැපීම, මැඩීම, පොළා පිරිසිදු කිරීම හා ගෝනි පිරවීම එකවර කරන යන්ත්‍රය", "කාලය හා පශ්චාත් අස්වනු හානිය විශාල ලෙස අඩු කරයි."),
          Triple("කේතු නොසලය vs විදුලිපංකා නොසලය", "කෘමිනාශක හා දිලීරනාශක ඉසීමට කේතු නොසලයත් (Hollow cone), වල්නාශක ඉසීමට විදුලිපංකා නොසලයත් (Flat fan) යොදයි", "නිවැරදි බිඳිති ප්‍රමාණය හා විසිරුම් පරාසය ලබාදෙයි."),
          Triple("බිංදු ජලසම්පාදනය (Drip Irrigation)", "එමිටර් මඟින් ශාක මූල කලාපයටම සෘජුව ජලය සපයන 90% කාර්යක්ෂම ක්‍රමය", "දියවන පොහොර (Fertigation) ද සමඟ එක්ව ලබාදිය හැකිය."),
          Triple("විසිරුම් ජලසම්පාදනය (Sprinkler Irrigation)", "පීඩන නල හා නොසල් හරහා කෘත්‍රිම වැස්සක් මෙන් ජලය විසිරුවන ක්‍රමය", "තේ තවාන්, එළවළු හා උස් බිම් වගාවලදී භාවිත වේ."),
          Triple("බිසෝකොටුව (Bisokotuwa)", "පැරණි ශ්‍රී ලාංකේය වැව්වල අධික ජල පීඩනය පාලනය කර සොරොව්ව ආරක්ෂා කළ වාරි ව්‍යුහය", "ලෝක වාරි ඉංජිනේරු විද්‍යාවේ සුවිශේෂී නිර්මාණයකි."),
          Triple("ඇළ මාර්ග ආවරණය (Canal Lining)", "වාරි ඇළවල් කොන්ක්‍රීට් හෝ මැටි යොදා පතුල හා ඉවුරු සැකසීමෙන් කාන්දු ජල හානිය වැළැක්වීම", "වගා බිමට ළඟා වන ජල ප්‍රමාණය වැඩි කරයි."),
          Triple("කෝනෝ වීඩරය (Cono-weeder)", "පේළි අතර කුඹුරු වල් මැඩ පසට වාතය එක් කිරීමට භාවිත කරන අත් වල් නෙළනය", "රසායනික වල්නාශකවලින් තොර පරිසර හිතකාමී උපකරණයකි.")
        ),
        "කෘෂි යන්ත්‍රෝපකරණ හා ජලසම්පාදන ඉංජිනේරු විද්‍යාව."
      ),
      Triple(
        "ඒකාබද්ධ පළිබෝධ හා වල් පැළෑටි කළමනාකරණය",
        listOf(
          Triple("ඒකාබද්ධ පළිබෝධ කළමනාකරණය (IPM)", "යාන්ත්‍රික, වගා, ජෛව හා අවම රසායනික ක්‍රම එක්ව පළිබෝධ ගහනය ආර්ථික හානි මට්ටමට පහළින් තැබීම", "පරිසර දූෂණය හා පළිබෝධ ප්‍රතිරෝධය වළක්වයි."),
          Triple("වී බෝගයේ දුඹුරු පැළ කීඩෑවා (BPH)", "වී පඳුරු පාමුලින් යුෂ උරා බී 'හොපර් පිලිස්සුම' (Hopper Burn) ඇති කරන කෘමියා", "Bg 300, Bg 352 වැනි ප්‍රතිරෝධී වී ප්‍රභේද වගාවෙන් මර්දනය කෙරේ."),
          Triple("සේනා දළඹුවා (Fall Armyworm)", "බඩඉරිඟු බෝගයේ ගොබය කා විනාශ කරන හිස මත උඩුකුරු 'Y' සලකුණක් ඇති දළඹුවා", "මුල් අවධියේදී ෆෙරෝමෝන් උගුල් හා ජෛව ක්‍රමවලින් පාලනය කෙරේ."),
          Triple("ඉල් මැස්සා (Fruit Fly) හා මෙතිල් ඉයුජිනෝල් උගුල", "අඹ, කෙසෙල් හා පේර ගෙඩි තුළ බිත්තර දමා කුණු කරවන මැස්සා පාලනයට යොදන පැරා-ෆෙරෝමෝන් උගුල", "පිරිමි මැස්සන් ආකර්ෂණය කර අල්ලා ගැනීමෙන් ප්‍රජනනය නවතාලයි."),
          Triple("සැල්වීනියා කුරුමිණියා (Cyrtobagous salviniae)", "ජලාශ අවහිර කරන සැල්වීනියා ආක්‍රමණශීලී ජලජ වල් පැළෑටිය මර්දනයට යෙදූ ජෛව පාලන කෘමියා", "රසායනික වල්නාශක නොමැතිව සාර්ථක ජෛව පාලනයට නිදසුනකි."),
          Triple("බෝඩෝ මිශ්‍රණය (Bordeaux Mixture)", "කොපර් සල්ෆේට් (CuSO₄), පිළිස්සූ හුණු හා ජලය මිශ්‍ර කර සාදන දිලීර හා බැක්ටීරියා නාශකය", "අර්තාපල් හා තක්කාලි පසු අංගමාරය පාලනයට යොදයි."),
          Triple("බැක්ටීරියා හිටුමැරීම (Bacterial Wilt / Ooze Test)", "මිරිස් හෝ තක්කාලි කඳක් පිරිසිදු ජල වීදුරුවක තැබූ විට කිරි වන් බැක්ටීරියා නූල් පිටවීම", "බෝග මාරුව හා ප්‍රතිරෝධී ප්‍රභේද වැවීමෙන් පාලනය කෙරේ."),
          Triple("පත්‍ර රැළි වැටීමේ රෝගය (Leaf Curl Virus)", "සුදුමැස්සන් (Whiteflies) හා කූඩිත්තන් මඟින් මිරිස් හා තක්කාලි වගාවල පතුරුවන වෛරස් රෝගය", "වාහක කෘමීන් පාලනය හා කහ ඇලෙන උගුල් භාවිතය ප්‍රධාන පිළියමයි."),
          Triple("කළාඳුරු (Cyperus rotundus)", "ත්‍රිකෝණාකාර කඳක් සහ භූගත අල සහිතව වේගයෙන් බෝවන පන් කුලයේ දැඩි වල් පැළෑටිය", "පද්ධතිගත වල්නාශක හෝ ගැඹුරු බිම් සැකසීම මඟින් පාලනය අවශ්‍ය වේ."),
          Triple("රතු, කහ, නිල්, කොළ විෂ වර්ණ තීරු", "පළිබෝධනාශක බෝතල් ලේබලයේ අඩංගු විෂ මට්ටම දැක්වෙන අධි විෂ සිට අඩු විෂ දක්වා වර්ණ පිළිවෙළ", "රතු තීරුව අතිශය විෂ සහිත පළිබෝධනාශක පෙන්නුම් කරයි."),
          Triple("පෙර අස්වනු කාලය (Pre-Harvest Interval - PHI)", "රසායනික ඉසීමෙන් පසු ආරක්ෂිතව අස්වනු නෙළීම සඳහා බලා සිටිය යුතු අවම දින ගණන", "ආහාරවල විෂ අවශේෂ රැඳීම සම්පූර්ණයෙන් වළක්වයි."),
          Triple("Trichoderma viride දිලීරය", "පසේ සිටින හානිකර මුල් කුණුවන දිලීර විනාශ කරන හිතකර ජෛව පාලන දිලීරය", "තවාන් පස් මිශ්‍රණ සමඟ මිශ්‍ර කර භාවිත කෙරේ.")
        ),
        "ඒකාබද්ධ පළිබෝධ, වල් පැළෑටි හා ශාක රෝග පාලන ඒකකය."
      ),
      Triple(
        "ආරක්ෂිත ගෘහ හා පස් රහිත වගා තාක්ෂණය",
        listOf(
          Triple("UV ස්ථායීකෘත පොලිතීන් (UV Film)", "පොලිටනල් වහලයට යොදන මයික්‍රෝන 150-200 ඝනකම ඇති පාරජම්බුල කිරණ ප්‍රතිරෝධී පොලිතීන්", "වර්ෂාවෙන් හා අහිතකර කිරණවලින් බෝගය රකියි."),
          Triple("40/50 මෙෂ් කෘමි දැල් (Insect-proof Nets)", "සුදුමැස්සන් හා කූඩිත්තන් පොලිටනල් තුළට ඇතුළුවීම වළක්වන සියුම් පැති ආවරණ දැල්", "වෛරස් රෝග පැතිරීම ශුන්‍ය කරයි."),
          Triple("NFT හයිඩ්‍රොපොනික්ස් (Nutrient Film Technique)", "පස් රහිතව PVC පීලි තුළ ගලායන තුනී පෝෂක ද්‍රාවණ පටලයක සලාද කොළ වගා කිරීම", "ජලය හා පෝෂක 90% දක්වා ඉතිරි කරයි."),
          Triple("ඇල්බට් ද්‍රාවණය (Albert's Solution)", "හයිඩ්‍රොපොනික්ස් වගාවේ ශාකයට අවශ්‍ය සියලු සාර්ව හා ක්ෂුද්‍ර පෝෂක සපයන ද්‍රාවණ මිශ්‍රණය", "pH 5.5-6.5 හා EC 1.5-2.5 mS/cm මට්ටමේ පවත්වා ගනී."),
          Triple("කොකෝපීට් වගා බෑග් (Cocopeat Grow Bags)", "ටැනින් හා ලවණ සෝදා පිරිසිදු කළ (Buffered) කොහුබත් බෑග් තුළ බෙල්පෙපර් හා තක්කාලි වැවීම", "පසෙන් බෝවන බැක්ටීරියා හිටුමැරීම සම්පූර්ණයෙන් වළක්වයි."),
          Triple("ඇක්වාපොනික්ස් (Aquaponics)", "මාළු ටැංකිවල ඇමෝනියා අපද්‍රව්‍ය නයිට්‍රේට් බවට හරවා හයිඩ්‍රොපොනික්ස් බෝගවලට පෝෂක ලෙස සැපයීම", "මසුන් හා එළවළු එකවර නිපදවන චක්‍රීය ක්‍රමයකි."),
          Triple("එරොපොනික්ස් (Aeroponics)", "වාතයේ එල්ලා ඇති මුල් මතට පෝෂක ද්‍රාවණය මීදුමක් (Mist) සේ ඉසින වගා ක්‍රමය", "මූල මණ්ඩලයට උපරිම ඔක්සිජන් වාතනය ලැබේ.")
        ),
        "ආරක්ෂිත ගෘහ හා පස් රහිත නවීන වගා තාක්ෂණය."
      ),
      Triple(
        "සත්ත්ව පාලනය, මීමැසි පාලනය හා මත්ස්‍ය වගාව",
        listOf(
          Triple("ෆ්‍රීසියන් හා ජර්සි ගව වර්ග", "උඩරට සිසිල් කලාපයට සුදුසු වැඩිම කිරි ප්‍රමාණයක් (ෆ්‍රීසියන්) හා වැඩිම මේද ප්‍රතිශතයක් (ජර්සි) දෙන වර්ග", "සාහිවාල් වැනි ඉන්දීය වර්ග සමඟ දෙමුහුන් කරනු ලැබේ."),
          Triple("සාහිවාල් හා රෙඩ් සින්දි ගව වර්ග", "වියළි කලාපයේ අධික උෂ්ණත්වයට, කිනිතුල්ලන්ට හා රෝගවලට ඔරොත්තු දෙන ඉන්දීය කිරි ගව වර්ග", "ලාංකේය පරිසරයට ඉහළ අනුකූලතාවයක් දක්වයි."),
          Triple("ලැක්ටෝමීටරය (Lactometer)", "කිරිවල සාපේක්ෂ ඝනත්වය (1.028 - 1.032) මැන ජලය මිශ්‍ර කර ඇත්දැයි පරීක්ෂා කරන උපකරණය", "කිරි එකතු කිරීමේ මධ්‍යස්ථානවල තත්ත්ව පාලනයට අනිවාර්ය වේ."),
          Triple("HTST පැස්චරීකරණය (72°C / තත්පර 15)", "කිරි 72°C උෂ්ණත්වයට තත්පර 15 ක් රත් කර ක්ෂණිකව 4°C ට සිසිල් කර රෝග කාරක නැසීම", "කිරිවල ස්වාභාවික රසය හා විටමින් ආරක්ෂා වේ."),
          Triple("බුරුළු ප්‍රදාහය (Mastitis)", "බුරුල්ලේ ඇතිවන බැක්ටීරියා ආසාදනය නිසා කිරි කැටි ගැසීම හා බුරුල්ල ඉදිමීම", "දෙවීමට පෙර හා පසු විෂබීජහරණ ද්‍රාවණ (Teat dip) යෙදීමෙන් වළක්වයි."),
          Triple("වයිට් ලෙග්හෝන් vs බ්‍රොයිලර් කුකුළන්", "බිත්තර සඳහා වයිට් ලෙග්හෝන් (Layer) ද, සති 5-6 කින් 2 kg මස් සඳහා කොබ්/රොස් (Broiler) ද ඇති කිරීම", "ලේයර් කුකුළන්ට දිනකට පැය 16 ක ආලෝක කාලයක් සපයයි."),
          Triple("කුකුළු බිත්තර රැකීමේ කාලය (දින 21)", "ඉන්කියුබේටරය තුළ 37.5°C උෂ්ණත්වයේ හා 60% ආර්ද්‍රතාවයේ බිත්තර පැටවුන් බිහිවන කාලය", "7 වන හා 14 වන දිනවල කැන්ඩ්ලින් (Candling) පරීක්ෂාව කෙරේ."),
          Triple("නිව්කාසල් (රැනිකෙට්) හා ගම්බෝරෝ", "කුකුළු ගහනයට මාරාන්තික හානි සිදු කරන නියමිත කාලසටහනට එන්නත් දිය යුතු වයිරස් රෝග", "ජෛව ආරක්ෂක පා සේදුම් තටාක ගොවිපළට ඇතුළුවීමේදී භාවිත කෙරේ."),
          Triple("සානන්, ජම්නපාරි හා බෝයර් එළු වර්ග", "සානන් (කිරි), ජම්නපාරි (කිරි හා මස්), සහ බෝයර් (මස්) යනු ප්‍රධාන විදේශීය එළු ප්‍රභේද වීම", "කොට්ටුකච්චිය දේශීය එළු වර්ගය වියළි කලාපයට උචිතය."),
          Triple("දේශීය මීමැස්සා (Apis cerana)", "පෙට්ටි තුළ ඇතිකළ හැකි පැණි නිපදවන හා බෝග පරාගණය 35% කින් ඉහළ නංවන සත්ත්ව විශේෂය", "රැජින, සේවිකාවන් හා පිරිමි මැස්සන් ලෙස ජනපදයේ සාමාජිකයන් 3 වර්ගයකි."),
          Triple("තිලාපියා (Tilapia) හා බහු මත්ස්‍ය වගාව", "ප්ලවාංග බහුල පොකුණුවල රෝහු, කට්ලා හා තිලාපියා වැනි මසුන් පෝෂණ ස්ථර අනුව වගා කිරීම", "පොකුණේ ද්‍රාවිත ඔක්සිජන් 5 mg/L ඉහළින් හා pH 6.5-8.5 තැබිය යුතුය."),
          Triple("සයිලේජ් (Silage) නිෂ්පාදනය", "CO-3 තෘණ වායු රහිතව පැසවා නියං කාලයේදී කිරි ගවයන්ට සැපයීමට කල්තබා ගැනීම", "පැසවීමෙන් ඇතිවන ලැක්ටික් අම්ලය තෘණ නරක් වීම වළක්වයි.")
        ),
        "සත්ත්ව පාලනය, මීමැසි පාලනය හා ජලජීවී වගා ඒකකය."
      ),
      Triple(
        "පශ්චාත් අස්වනු තාක්ෂණය, අගය එකතු කිරීම හා කෘෂි ආර්ථිකය",
        listOf(
          Triple("ප්ලාස්ටික් කූඩ (Plastic Crates)", "ගෝනි හා පොලිසැක් මලු වෙනුවට එළවළු හා පලතුරු ප්‍රවාහනයේදී තැලීම් වළක්වන ඇසුරුම", "ශ්‍රී ලංකාවේ 30-40% ක පශ්චාත් අස්වනු හානිය අඩු කිරීමට ප්‍රධාන පියවරකි."),
          Triple("පූර්ව සිසිලනය (Pre-cooling)", "අස්වනු නෙළූ වහාම ක්ෂේත්‍ර තාපය (Field heat) ඉවත් කර ශ්වසන වේගය පාලනය කිරීම", "විජලනය හා කුණුවීම අවම කර කල්තබා ගැනීමේ කාලය දිගු කරයි."),
          Triple("පාලිත වායුගෝල ගබඩා (CA Storage)", "ගබඩාව තුළ O₂ ප්‍රතිශතය අඩු කර CO₂ ඉහළ නැංවීමෙන් පලතුරු ශ්වසනය පාලනය කිරීම", "එතිලීන් ක්‍රියාකාරිත්වය ද අඩාල කර අපනයන ආයු කාලය වැඩි කරයි."),
          Triple("සීනි (65%) හා විනාකිරි කල්තබා ගැනීම", "ජෑම්වල ඉහළ සීනි ආස්‍රැති පීඩනයෙන් ද, අච්චාරුවල ආම්ලික pH මඟින් ද බැක්ටීරියා නැසීම", "පලතුරු හා එළවළු අතිරික්තයට ඉහළ අගය එකතු කිරීමක් සිදු කෙරේ."),
          Triple("GMP හා HACCP ප්‍රමිති", "ආහාර සැකසුම් කර්මාන්තයේ යහපත් නිෂ්පාදන පිළිවෙත් (GMP) හා අවදානම් පාලන පද්ධතිය (HACCP)", "දේශීය හා අපනයන ආහාර සුරක්ෂිතතාව තහවුරු කරයි."),
          Triple("SL-GAP සහතිකය", "විෂ රසායන අවශේෂ නොමැති පරිසර හිතකාමී ගොවිපළවල් සඳහා කෘෂිකර්ම දෙපාර්තමේන්තුව දෙන ප්‍රමිතිය", "වගා නිෂ්පාදන සඳහා ඉහළ වෙළඳපොළ විශ්වාසයක් ඇති කරයි."),
          Triple("කෘෂි අලෙවිකරණයේ 4Ps", "Product (නිෂ්පාදනය), Price (මිල), Place (බෙදාහැරීම), Promotion (ප්‍රවර්ධනය)", "ගොවි ව්‍යවසායකයෙකුගේ සාර්ථක අලෙවි සැලැස්මක පදනමයි."),
          Triple("සිලෝන් සිනමන් (Ceylon Cinnamon — GI)", "ශ්‍රී ලංකාවේ ආවේණික කුරුඳු (Cinnamomum verum) සඳහා ලැබුණු භූගෝලීය දර්ශක සහතිකය", "ලෝක වෙළඳපොළේ ඉහළම අපනයන ආදායමක් උපයන කුළුබඩුවකි."),
          Triple("තේ දලු කැඩීමේ සම්මතය (Two Leaves and a Bud)", "උසස් රසය හා සුවඳ ඇති කළු තේ නිපදවීමට අග්‍රස්ථ අංකුරය සහ ළපටි පත්‍ර දෙක පමණක් නෙළීම", "දින 7-10 කට වරක් නියමිත වටයේදී (Plucking round) කැඩිය යුතුය."),
          Triple("රබර් කිරි කැපීම (30° ආනතිය)", "හිමිදිරි උදෑසන කඳ වටා 30° ආනතියකින් කැම්බියමට හානි නොවන සේ වමේ සිට දකුණට කැපීම", "අමෝනියා යොදා රබර් කිරි මිදීම වළක්වා පිරිසැකසුම් කර්මාන්තශාලාවට යවයි.")
        ),
        "පශ්චාත් අස්වනු තාක්ෂණය, අගය එකතු කිරීම හා කෘෂි ව්‍යවසායකත්ව ඒකකය."
      )
    )

    // Flatten all facts so distractors stay cross-unit but strictly Agriculture-only
    val allFacts = topicFactBank.flatMap { (topicName, facts, _) ->
      facts.map { Triple(topicName, it.first, it.second to it.third) }
    }
    for (idx in allFacts.indices) {
      val (topicName, term, pair) = allFacts[idx]
      val (desc, note) = pair
      val d1 = allFacts[(idx + 7) % allFacts.size].second
      val d2 = allFacts[(idx + 17) % allFacts.size].second
      val d3 = allFacts[(idx + 31) % allFacts.size].second
      list.add(
        QSpec(
          topic = topicName,
          questionText = "කෘෂි විද්‍යාවේ '$topicName' ඒකකයෙහි \"$desc\" යන්නෙන් හඳුන්වනු ලබන සංකල්පය කුමක්ද?",
          correct = term,
          distractors = listOf(d1, d2, d3),
          explanation = "$term — $note"
        )
      )

      val desc1 = allFacts[(idx + 11) % allFacts.size].third.first
      val desc2 = allFacts[(idx + 23) % allFacts.size].third.first
      val desc3 = allFacts[(idx + 37) % allFacts.size].third.first
      list.add(
        QSpec(
          topic = topicName,
          questionText = "10 හා 11 ශ්‍රේණි කෘෂි විද්‍යා විෂය නිර්දේශයේ '$term' පිළිබඳ නිවැරදිම විග්‍රහය කුමක්ද?",
          correct = desc,
          distractors = listOf(desc1, desc2, desc3),
          explanation = "$term — $note"
        )
      )

      // Angle 3: Note -> Term
      val nd1 = allFacts[(idx + 13) % allFacts.size].second
      val nd2 = allFacts[(idx + 29) % allFacts.size].second
      val nd3 = allFacts[(idx + 41) % allFacts.size].second
      list.add(
        QSpec(
          topic = topicName,
          questionText = "\"${note.trimEnd('.')}\" යන ප්‍රධාන ලක්ෂණය වඩාත්ම ගැළපෙන්නේ පහත කුමන කෘෂි විද්‍යා සංකල්පයටද?",
          correct = term,
          distractors = listOf(nd1, nd2, nd3),
          explanation = "$term — $desc ($note)"
        )
      )
    }

    // I. Irrigation Volume / Depth Calculation (Area m² × Depth mm -> Liters) (40 items)
    for (areaM2 in listOf(100, 200, 250, 500, 1000)) {
      for (depthMm in listOf(5, 10, 15, 20, 25, 30, 40, 50)) {
        val liters = areaM2 * depthMm // 1 mm over 1 m² = 1 Liter!
        list.add(
          QSpec(
            topic = "වාරිමාර්ග හා ජල කළමනාකරණය",
            questionText = "වර්ගඵලය $areaM2 m² ක් වූ බෝග වගා බිමකට $depthMm mm ගැඹුරකට ජල සම්පාදනය කිරීම සඳහා අවශ්‍ය ජල පරිමාව ලීටර් කීයද? (1 mm/m² = 1 L)",
            correct = "$liters L",
            distractors = listOf(
              "${liters * 2} L",
              "${liters / 2} L",
              "${liters + 500} L"
            ),
            explanation = "ජල පරිමාව = $areaM2 m² × $depthMm mm = $liters L ($liters ÷ 1000 m³)."
          )
        )
      }
    }

    // J. Hatchability % & Livestock Breeding Timing calculations (36 items)
    for (setEggs in listOf(100, 200, 300, 400)) {
      for (rate in listOf(70, 75, 80, 82, 85, 88, 90, 92, 95)) {
        val chicks = setEggs * rate / 100
        list.add(
          QSpec(
            topic = "සත්ත්ව පාලනය හා පශු සම්පත්",
            questionText = "කෘතිම ඉන්කියුබේටරයක තැබූ බිත්තර $setEggs කින් දින 21 කට පසු පැටවුන් $chicks ක් බිහි වූයේ නම් පැටවුන් බිහිවීමේ ප්‍රතිශතය (Hatchability) කීයද?",
            correct = "$rate%",
            distractors = listOf("${rate - 10}%", "${(rate + 4).coerceAtMost(100)}%", "${rate / 2}%"),
            explanation = "Hatchability % = ($chicks / $setEggs) × 100 = $rate%."
          )
        )
      }
    }

    // K. Major Sri Lankan Crop Varieties recommended by Dept. of Agriculture (40 MCQs: Forward + Reverse)
    val cropVarieties = listOf(
      Triple("වී (මාස 3 / කෙටි කාලීන)", "Bg 300 / At 306 / Bw 367", "ඉහළ අස්වනු දෙන කෙටි කාලීන වී ප්‍රභේද"),
      Triple("වී (මාස 3 ½ / මධ්‍ය කාලීන)", "Bg 352 / Bg 358 / Ld 365", "දුඹුරු පැළ කීඩෑවාට ප්‍රතිරෝධී වී ප්‍රභේද"),
      Triple("බඩඉරිඟු (Maize)", "භද්‍රා / රුවන් / මුතු / සම්පත්", "වියළි කලාපීය අතිරේක ආහාර බෝග ප්‍රභේද"),
      Triple("මුං ඇට (Green Gram)", "MI 5 / MI 6 / හරි / අරිය", "කෙටි කාලීන රනිල බෝග ප්‍රභේද"),
      Triple("කව්පි (Cowpea)", "විජය / වරුණි / මිචෙල් / ධවල", "නියඟයට ඔරොත්තු දෙන රනිල බෝග ප්‍රභේද"),
      Triple("සෝයා බෝංචි (Soybean)", "PB-1 / PM-13 / MISB-1", "ප්‍රෝටීන් බහුල වියළි කලාපීය රනිල ප්‍රභේද"),
      Triple("තක්කාලි (Tomato)", "තළිණ / තරු / කේ.ඩබ්ලිව්.ආර් / පද්මා", "බැක්ටීරියා හිටුමැරීමට ප්‍රතිරෝධී ප්‍රභේද"),
      Triple("මිරිස් (Chilli)", "MI-2 / MI-හොට් / අරුණලු / ගල්කිරියාගම", "දේශීය හා වැඩිදියුණු කළ මිරිස් ප්‍රභේද"),
      Triple("රතු ලූනු (Red Onion)", "වෙදාලම් / ජැෆ්නා ලෝකල් / ත්‍රිකුණාමලය", "උතුරු හා වියළි කලාපයේ වගා කරන ප්‍රභේද"),
      Triple("ලොකු ලූනු (Big Onion)", "දඹුල්ල රතු / ගලේවෙල තෝරාගැනීම", "මාතලේ-දඹුල්ල කලාපයේ වවන ලූනු ප්‍රභේද"),
      Triple("රබර් (Rubber)", "RRISL 203 / RRIC 121 / RRIC 100", "ශ්‍රී ලංකා රබර් පර්යේෂණායතනය නිර්දේශිත ක්ලෝන"),
      Triple("පොල් (Coconut)", "CRIC 60 / CRIC 65 / කප්රුවන", "උස් හා දෙමුහුන් පොල් ප්‍රභේද"),
      Triple("තේ (Tea)", "TRI 2023 / TRI 2025 / TRI 3055", "වැඩිදියුණු කළ VP තේ ක්ලෝන"),
      Triple("අර්තාපල් (Potato)", "ග්‍රැනෝලා / ඩෙසිරී / හිල්ස්ටාර්", "නුවරඑළිය හා වැලිමඩ වගා කරන අර්තාපල් ප්‍රභේද")
    )
    for ((idx, item) in cropVarieties.withIndex()) {
      val (crop, vars, note) = item
      val d1 = cropVarieties[(idx + 1) % cropVarieties.size].second
      val d2 = cropVarieties[(idx + 4) % cropVarieties.size].second
      val d3 = cropVarieties[(idx + 8) % cropVarieties.size].second
      list.add(
        QSpec(
          topic = "නිර්දේශිත බෝග ප්‍රභේද",
          questionText = "ශ්‍රී ලංකාවේ කෘෂිකර්ම හෝ පර්යේෂණ ආයතන මගින් '$crop' සඳහා නිර්දේශ කර ඇති ප්‍රභේද කාණ්ඩය කුමක්ද?",
          correct = vars,
          distractors = listOf(d1, d2, d3),
          explanation = "$crop — $note ($vars)."
        )
      )
      val c1 = cropVarieties[(idx + 2) % cropVarieties.size].first
      val c2 = cropVarieties[(idx + 5) % cropVarieties.size].first
      val c3 = cropVarieties[(idx + 9) % cropVarieties.size].first
      list.add(
        QSpec(
          topic = "නිර්දේශිත බෝග ප්‍රභේද",
          questionText = "ශ්‍රී ලංකාවේ කෘෂිකර්මාන්තයේදී '$vars' යන නිර්දේශිත ප්‍රභේද අයත් වන්නේ කුමන බෝග කාණ්ඩයටද?",
          correct = crop,
          distractors = listOf(c1, c2, c3),
          explanation = "$vars යනු $crop සඳහා නිර්දේශිත ප්‍රභේදයන් වේ ($note)."
        )
      )
    }

    return list
  }
}
