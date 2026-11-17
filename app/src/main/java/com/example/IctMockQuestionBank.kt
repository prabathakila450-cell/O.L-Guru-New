package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * ICT (තොරතුරු හා සන්නිවේදන තාක්ෂණය) Question Bank for Live Exam Hall.
 * Combines QuizBankApplied (100), parametric Binary/Octal/Hex/Storage/Logic/Spreadsheet calculations (450+),
 * SubjectMasterIct (1,500+ multi-angle), and ShortAnswer ICT (400 G10+G11).
 */
object IctMockQuestionBank {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2500)

    // 1. 100 Curated QuizBankApplied ICT MCQs
    for (setIdx in 1..10) {
      for (qIdx in 1..10) {
        val qq = QuizBankApplied.getIctQuestion("10", setIdx, qIdx, qIdx, "ICT")
        raw.add(quizQuestionToSpec("තොරතුරු හා සන්නිවේදන තාක්ෂණය", qq))
      }
    }

    // 2. Parametric Number Systems, Storage, Logic Gates, Excel, & Programming problems (450 items)
    raw.addAll(buildParametricIct())

    // 3. SubjectMasterRepository ICT multi-angle pool
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterRepository.getCategoriesForSubject("තොරතුරු හා සන්නිවේදන තාක්ෂණය"),
        subjectLabel = "තොරතුරු හා සන්නිවේදන තාක්ෂණය (ICT)",
        seedBase = 17
      )
    )

    // 4. ShortAnswerMasterRepository Grade 10 & Grade 11 ICT (~400 items)
    raw.addAll(buildPoolFromShortAnswers("ICT"))

    return dedupPool(raw)
  }

  private fun buildParametricIct(): List<QSpec> {
    val list = ArrayList<QSpec>(450)

    // 1. Decimal -> Binary conversions (120 distinct decimals: 12..131)
    for (d in 12..131) {
      val bin = Integer.toBinaryString(d)
      val d1 = Integer.toBinaryString(d + 1)
      val d2 = Integer.toBinaryString(d - 1)
      val d3 = Integer.toBinaryString(d xor 1)
      val extras = listOf(d1, d2, d3, Integer.toBinaryString(d + 2), Integer.toBinaryString(d + 4))
        .filter { it != bin }.distinct().take(3)
      list.add(
        QSpec(
          topic = "සංඛ්‍යා පද්ධති - ද්විමය",
          questionText = "දශම (Decimal) සංඛ්‍යාවක් වන $d හි නිවැරදි ද්විමය (Binary) නිරූපණය කුමක්ද?",
          correct = "($bin)₂",
          distractors = extras.map { "($it)₂" },
          explanation = "$d සංඛ්‍යාව අඛණ්ඩව 2න් බෙදා ශේෂ පහළ සිට ඉහළට ලියූ විට ($bin)₂ ලැබේ."
        )
      )
    }

    // 2. Binary -> Decimal conversions (60 distinct values: 132..191)
    for (d in 132..191) {
      val bin = Integer.toBinaryString(d)
      list.add(
        QSpec(
          topic = "සංඛ්‍යා පද්ධති - දශම පරිවර්තනය",
          questionText = "ද්විමය සංඛ්‍යාවක් වන ($bin)₂ හි තුල්‍ය දශම (Decimal) අගය කොපමණද?",
          correct = "${d}₁₀",
          distractors = listOf("${d + 2}₁₀", "${d - 2}₁₀", "${d + 4}₁₀"),
          explanation = "($bin)₂ හි ස්ථානීය අගයන් (2⁰, 2¹, 2², ...) එකතු කළ විට ${d}₁₀ ලැබේ."
        )
      )
    }

    // 3. Decimal -> Hexadecimal & Octal conversions (90 distinct)
    for (d in 25..69) {
      val hex = Integer.toHexString(d).uppercase()
      val h1 = Integer.toHexString(d + 1).uppercase()
      val h2 = Integer.toHexString(d - 1).uppercase()
      val h3 = Integer.toHexString(d + 3).uppercase()
      list.add(
        QSpec(
          topic = "සංඛ්‍යා පද්ධති - ෂඩ්දශමය",
          questionText = "දශම සංඛ්‍යාවක් වන ${d}₁₀ ෂඩ්දශමය (Hexadecimal) සංඛ්‍යාවක් ලෙස දැක්වූ විට කුමක්ද?",
          correct = "(${hex})₁₆",
          distractors = listOf("(${h1})₁₆", "(${h2})₁₆", "(${h3})₁₆"),
          explanation = "$d අගය 16න් බෙදා ශේෂ ගත් විට (${hex})₁₆ ලැබේ."
        )
      )
    }
    for (d in 70..114) {
      val oct = Integer.toOctalString(d)
      val o1 = Integer.toOctalString(d + 1)
      val o2 = Integer.toOctalString(d - 1)
      val o3 = Integer.toOctalString(d + 2)
      list.add(
        QSpec(
          topic = "සංඛ්‍යා පද්ධති - අෂ්ටමය",
          questionText = "දශම සංඛ්‍යාවක් වන ${d}₁₀ අෂ්ටමය (Octal) පද්ධතියෙන් දැක්වූ විට ලැබෙන්නේ කුමක්ද?",
          correct = "(${oct})₈",
          distractors = listOf("(${o1})₈", "(${o2})₈", "(${o3})₈"),
          explanation = "$d අගය 8න් බෙදා ශේෂ ගත් විට (${oct})₈ ලැබේ."
        )
      )
    }

    // 4. Data Storage & Capacity calculations (60 distinct)
    for (k in 1..30) {
      val kb = k * 2
      list.add(
        QSpec(
          topic = "දත්ත ගබඩා ධාරිතාව",
          questionText = "පරිගණක ගොනුවක ප්‍රමාණය ${kb} KB නම්, එහි අඩංගු බයිට් (Bytes) ගණන කොපමණද?",
          correct = "${kb * 1024} Bytes",
          distractors = listOf("${kb * 1000} Bytes", "${kb * 512} Bytes", "${kb * 2048} Bytes"),
          explanation = "1 KB = 1024 Bytes බැවින් ${kb} × 1024 = ${kb * 1024} Bytes වේ."
        )
      )
    }
    for (m in 1..30) {
      val mb = m * 4
      list.add(
        QSpec(
          topic = "දත්ත ගබඩා ධාරිතාව",
          questionText = "මතක ධාරිතාව ${mb} GB යනු මෙගාබයිට් (MB) කීයකට සමානද? (1 GB = 1024 MB)",
          correct = "${mb * 1024} MB",
          distractors = listOf("${mb * 1000} MB", "${mb * 512} MB", "${mb * 2048} MB"),
          explanation = "${mb} GB = ${mb} × 1024 = ${mb * 1024} MB."
        )
      )
    }

    // 5. Logic Gates & Boolean Expressions (60 distinct)
    for (i in 0..59) {
      val a = (i shr 2) and 1
      val b = (i shr 1) and 1
      val c = i and 1
      val mode = i / 8 // 0..7
      val (expr, res) = when (mode) {
        0 -> "(A AND B) OR C" to ((a and b) or c)
        1 -> "(A OR B) AND C" to ((a or b) and c)
        2 -> "NOT(A AND B) OR C" to (((a and b) xor 1) or c)
        3 -> "(A XOR B) AND C" to ((a xor b) and c)
        4 -> "NOT(A OR B) AND (NOT C)" to (((a or b) xor 1) and (c xor 1))
        5 -> "(NOT A) AND (B OR C)" to ((a xor 1) and (b or c))
        6 -> "A NAND (B OR C)" to ((a and (b or c)) xor 1)
        else -> "(A NOR B) XOR C" to (((a or b) xor 1) xor c)
      }
      val wrongBit = if (res == 1) 0 else 1
      val qNumLabel = "අවස්ථාව #${i + 1}: "
      // Avoid generic prefix by changing context naturally per i
      val ctxWords = listOf(
        "ඩිජිටල් පරිපථයක", "තර්ක ගේට්ටු පද්ධතියක", "මධ්‍යම සැකසුම් තර්ක ඒකකයේ", "සංවේදක පාලකයක",
        "ස්වයංක්‍රීය අගුලක", "රොබෝ තර්ක පුවරුවක", "තාර්කික ද්වාර සැලසුමක", "පරිගණක තර්ක පරිපථයක"
      )
      val ctx = ctxWords[i % ctxWords.size]
      val vars = when ((i / 8) % 3) {
        0 -> Triple("A", "B", "C")
        1 -> Triple("X", "Y", "Z")
        else -> Triple("P", "Q", "R")
      }
      val customExpr = expr.replace("A", vars.first).replace("B", vars.second).replace("C", vars.third)
      list.add(
        QSpec(
          topic = "තර්ක ද්වාර (Logic Gates)",
          questionText = "$ctx ${vars.first} = $a, ${vars.second} = $b සහ ${vars.third} = $c ආදාන ලබා දුන් විට '$customExpr' ප්‍රකාශනයේ ප්‍රතිදානය (Output) කුමක්ද?",
          correct = "$res (${if (res == 1) "HIGH / සත්‍ය" else "LOW / අසත්‍ය"})",
          distractors = listOf(
            "$wrongBit (${if (wrongBit == 1) "HIGH / සත්‍ය" else "LOW / අසත්‍ය"})",
            "අනිර්ණිත තත්වය (Undefined)",
            "දෝෂ පණිවිඩය (Overflow Error)"
          ),
          explanation = "${vars.first}=$a, ${vars.second}=$b, ${vars.third}=$c ආදේශ කළ විට $customExpr හි ප්‍රතිදානය $res වේ."
        )
      )
    }

    // 6. Excel formulas with distinct inputs (60 distinct)
    for (i in 1..60) {
      val x = 10 + i
      val y = 20 + i
      val z = 30 + i
      when (i % 4) {
        0 -> list.add(
          QSpec(
            topic = "පැතුරුම්පත් (Spreadsheets)",
            questionText = "Excel හි A1=$x, A2=$y, A3=$z නම් =SUM(A1:A3) සූත්‍රය මගින් ලැබෙන අගය කීයද?",
            correct = "${x + y + z}",
            distractors = listOf("${(x + y + z) / 3}", "$z", "${x + y}"),
            explanation = "SUM(A1:A3) = $x + $y + $z = ${x + y + z}."
          )
        )
        1 -> list.add(
          QSpec(
            topic = "පැතුරුම්පත් (Spreadsheets)",
            questionText = "Excel හි B1=$x, B2=$y, B3=$z නම් =AVERAGE(B1:B3) ශ්‍රිතයේ ප්‍රතිදානය කීයද?",
            correct = "${(x + y + z) / 3}",
            distractors = listOf("${x + y + z}", "$x", "$z"),
            explanation = "AVERAGE(B1:B3) = ($x + $y + $z) / 3 = ${(x + y + z) / 3}."
          )
        )
        2 -> list.add(
          QSpec(
            topic = "පැතුරුම්පත් (Spreadsheets)",
            questionText = "Excel හි C1=$x, C2=${z + 15}, C3=$y නම් =MAX(C1:C3) - MIN(C1:C3) හි අගය කීයද?",
            correct = "${(z + 15) - x}",
            distractors = listOf("${z + 15}", "$x", "${y - x}"),
            explanation = "MAX = ${z + 15}, MIN = $x. වෙනස = ${(z + 15) - x}."
          )
        )
        else -> list.add(
          QSpec(
            topic = "ක්‍රමලේඛනය (Python/Pascal)",
            questionText = "Python කේතයේ a = $x; b = ${x + 5}; print(a * 2 + b) ක්‍රියාත්මක කළ විට තිරයේ දිස්වන ප්‍රතිදානය කුමක්ද?",
            correct = "${x * 2 + x + 5}",
            distractors = listOf("${x + x + 5}", "${x * 3}", "${x * 2}"),
            explanation = "($x × 2) + ${x + 5} = ${x * 2 + x + 5}."
          )
        )
      }
    }

    return list
  }
}
