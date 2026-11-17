package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.normalizeOption
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * Curated Civics Education (පුරවැසි අධ්‍යාපනය) Question Pool (Grades 10 & 11 O/L).
 * Combines CivicsMasterDataProvider (mcqs, timeline, humanRights, localGovt, goodGovernance,
 * globalRelations, caseStudies), QuizBankApplied civics (10), SubjectMasterCivics (1,580+ multi-angle),
 * ShortAnswer Civics (400 G10+G11), and curated Constitutional/Governance facts.
 */
object CivicsMockPoolHelper {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(2600)

    // 1. CivicsMasterDataProvider authentic O/L MCQs
    for (mcq in CivicsMasterDataProvider.mcqQuestions) {
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

    // 2. Derived QSpecs from CivicsMasterDataProvider rich structured modules
    raw.addAll(extractFromCivicsProvider())

    // 3. QuizBankApplied ("civic", qIdx 1..10)
    for (qIdx in 1..10) {
      val qq = QuizBankApplied.getElectiveQuestion("civic", "10", "පුරවැසි අධ්‍යාපනය", 1, qIdx, qIdx, "පුරවැසි අධ්‍යාපනය")
      raw.add(quizQuestionToSpec("පුරවැසි අධ්‍යාපනය", qq))
    }

    // 4. SubjectMasterRepository Civics multi-angle pool (~1,580 specs)
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterRepository.getCategoriesForSubject("පුරවැසි අධ්‍යාපනය"),
        subjectLabel = "පුරවැසි අධ්‍යාපනය",
        seedBase = 53
      )
    )

    // 5. ShortAnswerMasterRepository Grade 10 & Grade 11 Civics (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("පුරවැසි අධ්‍යාපනය"))

    return ExamQuestionHelper.distributeProportionallyAcrossTopics(dedupPool(raw))
  }

  private fun extractFromCivicsProvider(): List<QSpec> {
    val out = ArrayList<QSpec>(160)

    val tl = CivicsMasterDataProvider.constitutionalTimeline
    if (tl.size >= 4) {
      tl.forEachIndexed { idx, item ->
        out.add(
          QSpec(
            topic = "ව්‍යවස්ථා පරිණාමය",
            questionText = "ශ්‍රී ලංකා ආණ්ඩුක්‍රම ව්‍යවස්ථා ඉතිහාසයේ '${item.titleSinhala}' හඳුන්වා දෙන ලද වර්ෂය කුමක්ද?",
            correct = item.year,
            distractors = listOf(tl[(idx + 1) % tl.size].year, tl[(idx + 2) % tl.size].year, tl[(idx + 3) % tl.size].year),
            explanation = "${item.titleSinhala} (${item.year}) — ${item.significance}"
          )
        )
        out.add(
          QSpec(
            topic = "ව්‍යවස්ථා පරිණාමය",
            questionText = "${item.year} '${item.titleSinhala}' හි ප්‍රධාන ලක්ෂණය හෝ වැදගත්කම කුමක්ද?",
            correct = item.significance,
            distractors = listOf(tl[(idx + 1) % tl.size].significance, tl[(idx + 2) % tl.size].significance, tl[(idx + 3) % tl.size].significance),
            explanation = item.description
          )
        )
      }
    }

    val hr = CivicsMasterDataProvider.humanRightsItems
    if (hr.size >= 4) {
      hr.forEachIndexed { idx, item ->
        out.add(
          QSpec(
            topic = "මානව හිමිකම්",
            questionText = "මානව අයිතිවාසිකම් පද්ධතියේ එන '${item.title}' පිළිබඳ ශ්‍රී ලාංකේය පසුබිම කුමක්ද?",
            correct = item.sriLankanContext,
            distractors = listOf(hr[(idx + 1) % hr.size].sriLankanContext, hr[(idx + 2) % hr.size].sriLankanContext, hr[(idx + 3) % hr.size].sriLankanContext),
            explanation = "${item.description} (${item.examTip})"
          )
        )
      }
    }

    val lg = CivicsMasterDataProvider.localGovtItems
    if (lg.size >= 3) {
      lg.forEachIndexed { idx, item ->
        out.add(
          QSpec(
            topic = "පළාත් පාලන ආයතන",
            questionText = "ශ්‍රී ලංකාවේ '${item.councilType}' පළාත් පාලන ආයතනයේ නායකත්වය හා පරිපාලන ව්‍යුහය කුමක්ද?",
            correct = item.leadershipAndStructure,
            distractors = listOf(lg[(idx + 1) % lg.size].leadershipAndStructure, lg[(idx + 2) % lg.size].leadershipAndStructure, "පාර්ලිමේන්තු කථානායක හා ඇමති මණ්ඩලය"),
            explanation = item.examTip
          )
        )
      }
    }

    val gg = CivicsMasterDataProvider.goodGovernanceItems
    val gr = CivicsMasterDataProvider.globalRelationsItems
    gg.forEachIndexed { idx, item ->
      out.add(
        QSpec(
          topic = "යහපාලනය සහ නීතිය",
          questionText = "යහපාලන මූලධර්ම යටතේ '${item.conceptTitle}' ක්‍රියාත්මක කිරීමට පුරවැසියාගේ කාර්යභාරය කුමක්ද?",
          correct = item.citizenRole,
          distractors = listOf(
            gg[(idx + 1) % gg.size].citizenRole,
            "රාජ්‍ය පරිපාලනයෙන් සම්පූර්ණයෙන් බැහැරව සිටීම",
            "නීති විරෝධී ක්‍රියාවලට උදාසීන වීම"
          ),
          explanation = "${item.legalProvisions} — ${item.examTip}"
        )
      )
    }

    if (gr.size >= 3) {
      gr.forEachIndexed { idx, item ->
        out.add(
          QSpec(
            topic = "ජාත්‍යන්තර සබඳතා",
            questionText = "${item.organizationOrPolicy} ආරම්භ කළ වර්ෂය සහ ප්‍රධාන මූලස්ථානය කුමක්ද?",
            correct = item.foundedYearAndHQ,
            distractors = listOf(
              gr[(idx + 1) % gr.size].foundedYearAndHQ,
              gr[(idx + 2) % gr.size].foundedYearAndHQ,
              "1978 සැප්තැම්බර් 07 (ලන්ඩන්, එංගලන්තය)"
            ),
            explanation = "${item.sriLankaRoleAndBenefits} (${item.examTip})"
          )
        )
      }
    }

    val cs = CivicsMasterDataProvider.caseStudies
    if (cs.size >= 4) {
      cs.forEachIndexed { idx, item ->
        out.add(
          QSpec(
            topic = "පුරවැසි සිද්ධි අධ්‍යයන",
            questionText = "සිද්ධි අධ්‍යයනය — \"${item.situation}\" මෙවැනි ගැටලුවකදී පුරවැසියෙකු ගත යුතු නිවැරදි ක්‍රියාමාර්ගය කුමක්ද?",
            correct = item.correctCourseOfAction,
            distractors = listOf(
              cs[(idx + 1) % cs.size].correctCourseOfAction,
              cs[(idx + 2) % cs.size].correctCourseOfAction,
              cs[(idx + 3) % cs.size].correctCourseOfAction
            ),
            explanation = item.legalBasisOrRule
          )
        )
      }
    }

    return out
  }
}
