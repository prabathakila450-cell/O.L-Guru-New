package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.normalizeOption
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * Curated + Parametric Science Question Pool (Grades 10 & 11 O/L Syllabus).
 * Combines QuizBankScience (100), Science500Repository, SubjectMasterScience (1,580+ multi-angle),
 * ShortAnswerMasterRepository (400 G10+G11), and 360 parametric Physics/Chemistry calculation problems.
 * Deduplicated size exceeds 2,300 unique Science MCQs -> guarantees 1,800/1,800 unique per term.
 */
object ScienceMockPoolHelper {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2600)

    // 1. 100 Curated QuizBankScience MCQs
    for (setIdx in 1..10) {
      for (qIdx in 1..10) {
        val qq = QuizBankScience.getQuestion("10", setIdx, qIdx, qIdx, "විද්‍යාව")
        raw.add(quizQuestionToSpec("විද්‍යාව - ඒකකය $setIdx", qq))
      }
    }

    // 2. Science500Repository curated items (clean leading numbers in options)
    for (item in Science500Repository.allQuestions) {
      val opts = item.options.map { normalizeOption(it) }
      if (opts.size >= 4) {
        val idx = item.correctOptionIndex.coerceIn(0, opts.lastIndex)
        val correct = opts[idx]
        val distractors = opts.filterIndexed { i, _ -> i != idx }
        raw.add(
          QSpec(
            topic = item.unitTitle,
            questionText = item.question,
            correct = correct,
            distractors = distractors,
            explanation = item.explanationSinhala
          )
        )
      }
    }

    // 3. Parametric Physics & Chemistry calculations (360 unique numeric problems)
    raw.addAll(buildParametricCalculations())

    // 4. SubjectMasterRepository Science multi-angle pool (~1,580 specs)
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterRepository.getCategoriesForSubject("විද්‍යාව"),
        subjectLabel = "විද්‍යාව",
        seedBase = 11
      )
    )

    // 5. ShortAnswerMasterRepository Grade 10 & Grade 11 (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("විද්‍යාව"))

    return dedupPool(raw)
  }

  private fun buildParametricCalculations(): List<QSpec> {
    val list = ArrayList<QSpec>(360)

    // F = m * a (30 items)
    for (i in 1..30) {
      val m = 2 + i
      val a = 2 + (i % 5)
      val f = m * a
      list.add(
        QSpec(
          topic = "නිව්ටන් නියම හා බලය",
          questionText = "ස්කන්ධය $m kg වූ වස්තුවකට ${a} m s⁻² ක ත්වරණයක් ලබාදීමට යෙදිය යුතු සම්ප්‍රයුක්ත බලය කොපමණද?",
          correct = "$f N",
          distractors = listOf("${m + a} N", "${f * 2} N", "${f + 5} N"),
          explanation = "F = ma = $m kg × $a m s⁻² = $f N."
        )
      )
    }

    // W = F * d (30 items)
    for (i in 1..30) {
      val f = 15 + 5 * i
      val d = 4 + (i % 6)
      val w = f * d
      list.add(
        QSpec(
          topic = "කාර්යය හා ශක්තිය",
          questionText = "$f N ක බලයක් යොදා වස්තුවක් බලයේ දිශාවට $d m දුරක් විස්ථාපනය කළ විට සිදුවන කාර්යය කීයද?",
          correct = "$w J",
          distractors = listOf("${f + d} J", "${w / 2} J", "${w + 40} J"),
          explanation = "කාර්යය W = F × d = $f × $d = $w J."
        )
      )
    }

    // Ep = m * g * h (30 items)
    for (i in 1..30) {
      val m = 2 + i
      val h = 5 + (i % 8)
      val ep = m * 10 * h
      list.add(
        QSpec(
          topic = "විභව ශක්තිය",
          questionText = "ස්කන්ධය $m kg වූ වස්තුවක් පොළොවේ සිට $h m ක් ඉහළට එසවූ විට එහි ගබඩා වන ගුරුත්වාකර්ෂණ විභව ශක්තිය කීයද? (g = 10 m s⁻²)",
          correct = "$ep J",
          distractors = listOf("${m * h} J", "${ep / 2} J", "${ep + 100} J"),
          explanation = "Eₚ = mgh = $m × 10 × $h = $ep J."
        )
      )
    }

    // Ek = 1/2 * m * v^2 (30 items)
    for (i in 1..30) {
      val m = 2 * i
      val v = 4 + (i % 5) * 2
      val ek = (m * v * v) / 2
      list.add(
        QSpec(
          topic = "චාලක ශක්තිය",
          questionText = "$m kg ස්කන්ධයක් ඇති වස්තුවක් $v m s⁻¹ ක වේගයෙන් චලනය වන විට එහි චාලක ශක්තිය කීයද?",
          correct = "$ek J",
          distractors = listOf("${m * v} J", "${ek * 2} J", "${ek + 20} J"),
          explanation = "Eₖ = (1/2)mv² = (1/2) × $m × $v² = $ek J."
        )
      )
    }

    // V = I * R (30 items)
    for (i in 1..30) {
      val iCurr = 1 + (i % 6)
      val r = 4 + i
      val v = iCurr * r
      list.add(
        QSpec(
          topic = "ධාරා විද්‍යුතය හා ඕම් නියමය",
          questionText = "$r Ω ප්‍රතිරෝධකයක් තුළින් $iCurr A විද්‍යුත් ධාරාවක් ගලන විට එහි අග්‍ර දෙක අතර විභව අන්තරය කොපමණද?",
          correct = "$v V",
          distractors = listOf("${r + iCurr} V", "${v * 2} V", "${r * 10} V"),
          explanation = "V = IR = $iCurr A × $r Ω = $v V."
        )
      )
    }

    // P = V * I (30 items)
    for (i in 1..30) {
      val v = 10 + 10 * i
      val iCurr = 2 + (i % 4)
      val p = v * iCurr
      list.add(
        QSpec(
          topic = "විද්‍යුත් ක්ෂමතාව",
          questionText = "$v V සැපයුමකට සම්බන්ධ උපකරණයක් තුළින් $iCurr A ධාරාවක් ගලයි නම්, එහි විද්‍යුත් ක්ෂමතාව කීයද?",
          correct = "$p W",
          distractors = listOf("${v / iCurr} W", "${p + 50} W", "${p * 2} W"),
          explanation = "P = VI = $v × $iCurr = $p W."
        )
      )
    }

    // Density rho = m / V (30 items)
    for (i in 1..30) {
      val vVol = 10 + 5 * i
      val rho = 2 + (i % 4)
      val mass = rho * vVol
      list.add(
        QSpec(
          topic = "ඝනත්වය",
          questionText = "පරිමාව $vVol cm³ සහ ස්කන්ධය $mass g වූ ද්‍රව්‍යයක ඝනත්වය කොපමණද?",
          correct = "$rho g cm⁻³",
          distractors = listOf("${rho + 1} g cm⁻³", "${rho * 2} g cm⁻³", "${mass + vVol} g cm⁻³"),
          explanation = "ඝනත්වය = ස්කන්ධය / පරිමාව = $mass / $vVol = $rho g cm⁻³."
        )
      )
    }

    // Wave speed v = f * lambda (30 items)
    for (i in 1..30) {
      val f = 50 + 10 * i
      val lam = 2 + (i % 5)
      val vel = f * lam
      list.add(
        QSpec(
          topic = "තරංග හා චලිතය",
          questionText = "සංඛ්‍යාතය $f Hz සහ තරංග ආයාමය $lam m වූ තරංගයක ප්‍රචාරණ වේගය කීයද?",
          correct = "$vel m s⁻¹",
          distractors = listOf("${f / lam} m s⁻¹", "${vel * 2} m s⁻¹", "${f + lam} m s⁻¹"),
          explanation = "v = fλ = $f × $lam = $vel m s⁻¹."
        )
      )
    }

    // Moles n = m / M (30 items - CaCO3 M=100, NaOH M=40, H2O M=18)
    for (i in 1..30) {
      val moles = i
      val comp = when (i % 3) {
        0 -> Triple("CaCO₃ (M = 100 g mol⁻¹)", 100, moles * 100)
        1 -> Triple("NaOH (M = 40 g mol⁻¹)", 40, moles * 40)
        else -> Triple("H₂O (M = 18 g mol⁻¹)", 18, moles * 18)
      }
      list.add(
        QSpec(
          topic = "මවුලය හා රසායනික ගණනය",
          questionText = "${comp.first} සංයෝගයෙන් ග්‍රෑම් ${comp.third} g ක් තුළ අඩංගු මවුල (mol) ගණන කීයද?",
          correct = "$moles mol",
          distractors = listOf("${moles + 2} mol", "${moles * 2} mol", "${comp.second} mol"),
          explanation = "n = m / M = ${comp.third} / ${comp.second} = $moles mol."
        )
      )
    }

    // Heat Q = m c dT (30 items - water c = 4200 J/kg C)
    for (i in 1..30) {
      val m = 1 + (i % 4)
      val dT = 5 + 2 * i
      val q = m * 4200 * dT
      list.add(
        QSpec(
          topic = "තාපය හා තාප ධාරිතාව",
          questionText = "ජලය $m kg ක උෂ්ණත්වය ${dT}°C කින් ඉහළ නැංවීමට අවශ්‍ය තාප ප්‍රමාණය කීයද? (ජලයේ විශිෂ්ට තාප ධාරිතාව = 4200 J kg⁻¹ °C⁻¹)",
          correct = "$q J",
          distractors = listOf("${4200 * dT / 2} J", "${q + 4200} J", "${q * 2} J"),
          explanation = "Q = mcΔθ = $m × 4200 × $dT = $q J."
        )
      )
    }

    // Momentum p = m * v (30 items)
    for (i in 1..30) {
      val m = 3 + i
      val v = 4 + (i % 7)
      val p = m * v
      list.add(
        QSpec(
          topic = "ගම්‍යතාව",
          questionText = "ස්කන්ධය $m kg වූ වස්තුවක් $v m s⁻¹ ප්‍රවේගයෙන් චලනය වන විට එහි රේඛීය ගම්‍යතාව කොපමණද?",
          correct = "$p kg m s⁻¹",
          distractors = listOf("${m + v} kg m s⁻¹", "${p * 2} kg m s⁻¹", "${p + 6} kg m s⁻¹"),
          explanation = "ගම්‍යතාව P = mv = $m × $v = $p kg m s⁻¹."
        )
      )
    }

    // Pressure P = F / A (30 items)
    for (i in 1..30) {
      val area = 2 + (i % 5)
      val press = 50 + 10 * i
      val force = area * press
      list.add(
        QSpec(
          topic = "පීඩනය",
          questionText = "වර්ගඵලය $area m² වූ පෘෂ්ඨයක් මත ලම්භකව ක්‍රියා කරන බලය $force N නම් ඇතිවන පීඩනය කීයද?",
          correct = "$press Pa",
          distractors = listOf("${force * area} Pa", "${press * 2} Pa", "${press + 25} Pa"),
          explanation = "පීඩනය P = F / A = $force / $area = $press Pa."
        )
      )
    }

    return list
  }
}
