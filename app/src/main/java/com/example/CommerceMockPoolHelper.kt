package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * Curated + Parametric Commerce & Accounting Question Pool (Grades 10 & 11 O/L).
 * Combines QuizBankApplied (100), CommerceDoubleEntryRepository (1,500+ unique double-entry transactions),
 * 180 parametric Accounting Equation / Profit / Discount / Depreciation problems,
 * SubjectMasterCommerce (1,580+ multi-angle), and ShortAnswer Commerce (400 G10+G11).
 */
object CommerceMockPoolHelper {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(3200)

    // 1. 100 Curated QuizBankApplied Commerce MCQs
    for (setIdx in 1..10) {
      for (qIdx in 1..10) {
        val qq = QuizBankApplied.getCommerceQuestion("10", setIdx, qIdx, qIdx, "ව්‍යාපාර හා ගිණුම්කරණය")
        raw.add(quizQuestionToSpec("ව්‍යාපාර හා ගිණුම්කරණය", qq))
      }
    }

    // 2. Parametric Accounting & Business Math (180 items)
    raw.addAll(buildParametricAccounting())

    // 3. CommerceDoubleEntryRepository (up to 2,000 unique transactions)
    raw.addAll(buildDoubleEntryPool())

    // 4. SubjectMasterRepository Commerce multi-angle pool (~1,580 items)
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterRepository.getCategoriesForSubject("ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය"),
        subjectLabel = "ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය",
        seedBase = 23
      )
    )

    // 5. ShortAnswerMasterRepository Commerce G10 + G11 (~400 items)
    raw.addAll(buildPoolFromShortAnswers("ව්‍යාපාර හා ගිණුම්කරණය"))

    return ExamQuestionHelper.distributeProportionallyAcrossTopics(dedupPool(raw))
  }

  private fun buildDoubleEntryPool(): List<QSpec> {
    val allChallenges = ArrayList<DoubleEntryChallenge>(2000)
    for (batchNum in 1..CommerceDoubleEntryRepository.TOTAL_BATCHES) {
      allChallenges.addAll(CommerceDoubleEntryRepository.getBatch(batchNum).challenges)
    }

    // Collect distinct account pairs so distractors are authentic Sri Lankan accounting entries
    val distinctPairs = allChallenges.map {
      "${it.debitAccount} / ${it.creditAccount}"
    }.distinct()

    val result = ArrayList<QSpec>(allChallenges.size)
    for ((idx, item) in allChallenges.withIndex()) {
      val cleanTx = item.transaction.replace(Regex("^\\d+\\.\\s*"), "").trim()
      if (cleanTx.length < 15) continue
      val correctPair = "${item.debitAccount} / ${item.creditAccount}"
      val reversedPair = "${item.creditAccount.replace(" - බැර", " - හර")} / ${item.debitAccount.replace(" - හර", " - බැර")}"
      val distractors = ArrayList<String>(3)
      if (reversedPair != correctPair) distractors.add(reversedPair)
      var step = 11
      while (distractors.size < 3 && step < distinctPairs.size) {
        val cand = distinctPairs[(idx + step) % distinctPairs.size]
        if (cand != correctPair && !distractors.contains(cand)) {
          distractors.add(cand)
        }
        step += 17
      }
      result.add(
        QSpec(
          topic = "ද්විත්ව සටහන් මූලධර්මය",
          questionText = "ව්‍යාපාර ගනුදෙනුවක් වන \"$cleanTx\" යන්න සඳහා නිවැරදි හර සහ බැර ද්විත්ව සටහන කුමක්ද?",
          correct = correctPair,
          distractors = distractors,
          explanation = item.explanation
        )
      )
    }
    return result
  }

  private fun buildParametricAccounting(): List<QSpec> {
    val list = ArrayList<QSpec>(180)

    // 1. Accounting Equation: Assets = Equity + Liabilities (45 items)
    for (i in 1..45) {
      val cap = 200000 + i * 25000
      val liab = 50000 + i * 10000
      val assets = cap + liab
      list.add(
        QSpec(
          topic = "ගිණුම්කරණ සමීකරණය",
          questionText = "ව්‍යාපාරයක හිමිකම (Equity) රු. $cap ක් සහ මුළු වගකීම් රු. $liab ක් නම්, එහි මුළු වත්කම් වටිනාකම කොපමණද?",
          correct = "රු. $assets",
          distractors = listOf("රු. ${cap - liab}", "රු. $cap", "රු. ${assets + 50000}"),
          explanation = "වත්කම් = හිමිකම + වගකීම් = $cap + $liab = රු. $assets."
        )
      )
    }

    // 2. Gross Profit = Sales - Cost of Sales (45 items)
    for (i in 1..45) {
      val sales = 300000 + i * 15000
      val cos = 180000 + i * 8000
      val gp = sales - cos
      list.add(
        QSpec(
          topic = "අවසාන ගිණුම් - දළ ලාභය",
          questionText = "ව්‍යාපාරයක ශුද්ධ විකුණුම් රු. $sales ක් සහ විකුණුම් පිරිවැය රු. $cos ක් නම්, දළ ලාභය කීයද?",
          correct = "රු. $gp",
          distractors = listOf("රු. ${sales + cos}", "රු. $cos", "රු. ${gp + 25000}"),
          explanation = "දළ ලාභය = විකුණුම් - විකුණුම් පිරිවැය = $sales - $cos = රු. $gp."
        )
      )
    }

    // 3. Trade Discount & Net Invoice Price (45 items)
    for (i in 1..45) {
      val listPrice = 20000 + i * 4000
      val disc = (listPrice * 10) / 100
      val net = listPrice - disc
      list.add(
        QSpec(
          topic = "මූලික පොත් හා වට්ටම්",
          questionText = "ලැයිස්තු මිල රු. $listPrice ක් වන භාණ්ඩ තොගයක් සඳහා 10% ක වෙළඳ වට්ටමක් ලබා දුන් විට ගැනුම් ජර්නලයේ සටහන් කළ යුතු ශුද්ධ මුදල කීයද?",
          correct = "රු. $net",
          distractors = listOf("රු. $listPrice", "රු. $disc", "රු. ${listPrice + disc}"),
          explanation = "වෙළඳ වට්ටම අඩු කළ පසු ශුද්ධ මුදල ($listPrice - $disc = රු. $net) මුල් පොතේ සටහන් කෙරේ."
        )
      )
    }

    // 4. Net Profit Calculation (45 items)
    for (i in 1..45) {
      val gp = 120000 + i * 5000
      val exp = 40000 + i * 2000
      val inc = 10000 + i * 1000
      val np = gp + inc - exp
      list.add(
        QSpec(
          topic = "ලාභ හා අලාභ ගිණුම",
          questionText = "දළ ලාභය රු. $gp ක්, වෙනත් ආදායම් රු. $inc ක් සහ මෙහෙයුම් වියදම් රු. $exp ක් වූ ව්‍යාපාරයක ශුද්ධ ලාභය කීයද?",
          correct = "රු. $np",
          distractors = listOf("රු. ${gp - exp}", "රු. ${gp + inc}", "රු. ${gp + exp}"),
          explanation = "ශුද්ධ ලාභය = දළ ලාභය + වෙනත් ආදායම් - මෙහෙයුම් වියදම් = රු. $np."
        )
      )
    }

    return list
  }
}
