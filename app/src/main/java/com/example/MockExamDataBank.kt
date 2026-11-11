package com.example

/**
 * MockExamDataBank provides syllabus-aligned, 60-question examination papers
 * for Sri Lankan grades (Grade 6-11 / O/L), structured separately across all 3 terms:
 * - 1 වන වාරය (Term 1)
 * - 2 වන වාරය (Term 2)
 * - 3 වන වාරය (Term 3)
 *
 * Each term features at least 10 distinct, 60-question mock exam papers per subject,
 * complete with OMR digital bubble sheet mappings, syllabus topic distributions,
 * and comprehensive marking scheme explanations.
 */
object MockExamDataBank {

  val AVAILABLE_SUBJECTS = listOf(
    "විද්‍යාව",
    "ගණිතය",
    "ඉතිහාසය",
    "සිංහල",
    "ඉංග්‍රීසි",
    "බුද්ධ ධර්මය",
    "භූගෝල විද්‍යාව",
    "පුරවැසි අධ්‍යාපනය",
    "තොරතුරු හා සන්නිවේදන තාක්ෂණය",
    "ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය",
    "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය",
    "කෘෂි විද්‍යාව",
    "චිත්‍ර කලාව",
    "සංගීතය",
    "නර්තනය"
  )

  val PAPER_FOCUS_TITLES = listOf(
    "පළාත්/කලාප අධ්‍යාපන පෙරහුරු ප්‍රශ්න පත්‍රය (Provincial Benchmark Paper 01)",
    "විෂය නිර්දේශ මූලධර්ම හා ප්‍රධාන සංකල්ප ආවරණ පත්‍රය (Core Concepts Paper 02)",
    "රූපසටහන්, ප්‍රස්ථාර හා විද්‍යාත්මක නිරීක්ෂණ පත්‍රය (Diagrams & Graphs Paper 03)",
    "පසුගිය විභාග ප්‍රශ්න රටා ආදර්ශ පත්‍රය (Past Exam Trend Matching Paper 04)",
    "සංකීර්ණ ගැටලු, සූත්‍ර හා ගණනය කිරීම් පත්‍රය (Calculations & Problem Solving 05)",
    "ප්‍රායෝගික ක්‍රියාකාරකම් හා නිරීක්ෂණ පත්‍රය (Practicals & Experiments Paper 06)",
    "තාර්කික නිගමන හා ගැඹුරු විවරණ පත්‍රය (Critical Thinking & Deductions 07)",
    "විෂය නිර්දේශ පූර්ණ සංශෝධන පෙරහුරුව (Full Syllabus Revision Drill 08)",
    "වේගවත් පිළිතුරු හා කාල කළමනාකරණ පත්‍රය (Speed & Time Drill Paper 09)",
    "සමස්ත ලංකා ශ්‍රේණිගත කිරීමේ පෙරහුරු පත්‍රය (All-Island Championship Paper 10)",
    "කොළඹ ප්‍රධාන පාසල් සංගමයේ පෙරහුරු පත්‍රය (Colombo Leading Schools Mock 11)",
    "මධ්‍යම පළාත් අධ්‍යාපන දෙපාර්තමේන්තු ආදර්ශ පත්‍රය (Central Province Standard 12)",
    "දකුණු පළාත් විශිෂ්ටතා ඇගයීම් පත්‍රය (Southern Province Excellence 13)",
    "බස්නාහිර පළාත් වාර විභාග ප්‍රමිතිය (Western Province Benchmark 14)",
    "වයඹ පළාත් පෙරහුරු ප්‍රශ්න පත්‍රය (Wayamba Province Standard 15)",
    "උතුරු-මැද පළාත් ආදර්ශ ඇගයීම් පත්‍රය (North Central Province Model 16)",
    "සබරගමුව පළාත් පෙරහුරු පත්‍රය (Sabaragamuwa Province Benchmark 17)",
    "ඌව පළාත් විශිෂ්ටතා ආදර්ශ පත්‍රය (Uva Province Excellence 18)",
    "විභාග ඉලක්කගත තේමාගත සංශෝධන පත්‍රය (Targeted Thematic Revision 19)",
    "විභාග අනුමාන ප්‍රශ්න සංග්‍රහය (High-Yield Exam Prediction Paper 20)",
    "A සාමාර්ථ ඉලක්කගත විශේෂ ඇගයීම (Target Distinction Drill 21)",
    "සංකල්පීය අවබෝධය හා යෙදවුම් පරීක්ෂාව (Conceptual Application Test 22)",
    "රූපසටහන් හා ව්‍යුහගත බහුවරණ පත්‍රය (Structured MCQ & Diagrams 23)",
    "සූත්‍ර, නියම හා ප්‍රමේය පූර්ණ පෙරහුරුව (Formulas & Laws Intensive Drill 24)",
    "විභාග ශාලා පූර්ණ ආදර්ශ පරීක්ෂණය (Full Hall Mock Simulation 25)",
    "දැඩි විභාග පීඩන කළමනාකරණ පෙරහුරුව (High-Speed Timing Challenge 26)",
    "විභාග දෙපාර්තමේන්තු ප්‍රශ්න රටා සමපාත පත්‍රය (Department Model Aligned 27)",
    "සමස්ත නිර්දේශයේ ගැඹුරු ප්‍රශ්න පත්‍රය (Comprehensive Deep-Dive Paper 28)",
    "විභාගයට පෙර අවසන් මුහුණුවර (Pre-Exam Final Readiness Paper 29)",
    "සමස්ත ලංකා ජාතික ශ්‍රේණිගත කිරීමේ අවසන් මහා පෙරහුරුව (National Grand Mock Final 30)"
  )

  /**
   * Returns exactly 30 distinct mock exam papers for the requested grade, term (1..3), and subject.
   * Each paper contains exactly 60 questions covering that specific term's syllabus.
   */
  fun getPapersForTermAndSubject(
    grade: String,
    term: Int,
    subject: String
  ): List<MockExamPaper> {
    val cleanGrade = if (grade.contains("11")) "11"
    else if (grade.contains("10")) "10"
    else if (grade.contains("9") || grade.contains("09")) "09"
    else if (grade.contains("8") || grade.contains("08")) "08"
    else if (grade.contains("7") || grade.contains("07")) "07"
    else if (grade.contains("6") || grade.contains("06")) "06"
    else "11"

    val termNumber = if (term in 1..3) term else 1
    val papers = mutableListOf<MockExamPaper>()

    for (paperIdx in 1..30) {
      val paperTitle = "$cleanGrade ශ්‍රේණිය • $subject • $termNumber වන වාරය - ආදර්ශ පත්‍රය ${String.format("%02d", paperIdx)}"
      val questions = generate60Questions(cleanGrade, subject, termNumber, paperIdx)
      val syllabusSummary = getSyllabusSummary(subject, termNumber)

      papers.add(
        MockExamPaper(
          id = "mock_${subject}_g${cleanGrade}_t${termNumber}_p${paperIdx}",
          titleSinhala = paperTitle,
          subject = subject,
          grade = cleanGrade,
          term = termNumber,
          paperNumber = paperIdx,
          durationMinutes = 60,
          totalQuestions = 60,
          syllabusCoverageSummary = syllabusSummary,
          questions = questions,
          pdfUri = "https://drive.google.com/file/d/1IQntv3Yh1Oaxh42-btqYaFNNA9uijfx_/preview"
        )
      )
    }

    return papers
  }

  fun getSyllabusSummary(subject: String, term: Int): String {
    return when (subject) {
      "විද්‍යාව" -> when (term) {
        1 -> "ජීවයේ රසායනික පදනම, පදාර්ථයේ ව්‍යුහය, රේඛීය චලිතය, මවුලය හා රසායනික ගණනය, නිව්ටන් නියම සහ බලය, සෛල විභාජනය, ප්‍රභාසංශ්ලේෂණය, ආහාර ජීර්ණය, රසායනික බන්ධන, මූලද්‍රව්‍ය ආවර්තිතාව"
        2 -> "ශ්වසනය සහ වායු හුවමාරුව, මානව රුධිර සංසරණය, ද්‍රාවණ හා ද්‍රාව්‍යතාව, අම්ල, භෂ්ම හා ලවණ, කාර්යය, ශක්තිය හා ක්ෂමතාව, තරංග හා යෙදීම්, තාපය හා උෂ්ණත්වය, පීඩනය සහ ආකිමිඩීස් නියමය, ශාක පරිවහනය, බහිස්ස්‍රාවය"
        else -> "ධාරා විද්‍යුතය හා ඕම් නියමය, විද්‍යුත් බලය හා ශක්තිය, විද්‍යුත් චුම්භකත්වය, ඉලෙක්ට්‍රොනික විද්‍යාව, ආලෝකය හා දෘෂ්ටි විද්‍යාව, ප්‍රවේණිය හා ජාන, කාබනික රසායනය, ලෝහ නිස්සාරණය, පරිසරය, විකිරණශීලීතාවය"
      }
      "ගණිතය" -> when (term) {
        1 -> "වර්ගජ ප්‍රකාශන සහ සාධක, භාග හා වීජීය භාග, ලඝුගණක I හා II, කෝණ හා ත්‍රිකෝණ, සරල රේඛා ප්‍රස්ථාර, සංඛ්‍යාත ව්‍යාප්ති හා මාතය, ප්‍රතිශත හා බදු ගණනය, කුලක සහ වෙන් රූප, වර්ගජ සමීකරණ, සමාන්තර ශ්‍රේඪි"
        2 -> "සමගාමී සමීකරණ, වෘත්ත ජ්‍යාමිතිය, පරිමිතිය සහ වර්ගඵලය, අනුපාත හා සමානුපාත, න්‍යාස, අසමානතා, සුළු පොලිය හා වැල් පොලිය, කොටස් වෙළඳපොල හා ලාභාංශ, පයිතගරස් ප්‍රමේයය, චක්‍රීය චතුරස්‍ර ප්‍රමේය"
        else -> "ත්‍රිකෝණමිතිය, ඝන වස්තු වර්ගඵලය හා පරිමාව, සම්භාවිතාව, සංඛ්‍යානය හා සමුච්චිත සංඛ්‍යාත, ගුණෝත්තර ශ්‍රේඪි, ජ්‍යාමිතික නිර්මාණ, ලක්ෂ්‍ය පථ, සමමිතිකතාව, ව්‍යාපාර ගණිතය, වීජීය අසමානතා ප්‍රස්ථාර"
      }
      "ඉතිහාසය" -> when (term) {
        1 -> "මූලාශ්‍ර සහ ප්‍රාග් ඓතිහාසික යුගය, අනුරාධපුර මුල් යුගය, මහින්දාගමනය, දුටුගැමුණු රජතුමා, වළගම්බා රජු, වසභ හා මහසෙන් යුගය, ධාතුසේන රජු හා සීගිරිය, වාරි ශිෂ්ටාචාරය, පැරණි කලා හා සාහිත්‍යය, පැරණි විදේශ සබඳතා"
        2 -> "පොළොන්නරු රාජධානිය, විජයබාහු I, මහා පරාක්‍රමබාහු, නිශ්ශංකමල්ල, දඹදෙණිය හා යාපහුව, කෝට්ටේ රාජධානිය, සීතාවක රාජධානිය, පෘතුගීසි ආගමනය, ලන්දේසි පාලනය, උඩරට රාජධානිය හා 1815 ගිවිසුම"
        else -> "1818 වෙල්ලස්ස නිදහස් අරගලය, 1848 මාතලේ කැරැල්ල, කෝල්බෲක්-කැමරන් ප්‍රතිසංස්කරණ, වැවිලි ආර්ථිකය, ජාතික හා ආගමික පුනර්ජීවනය, 20 වන සියවසේ ආණ්ඩුක්‍රම, 1948 නිදහස, නිදහසින් පසු ශ්‍රී ලංකාව, ජනරජ ව්‍යවස්ථා, විදේශ ප්‍රතිපත්තිය"
      }
      "සිංහල" -> when (term) {
        1 -> "අක්ෂර මාලාව, නාම පද හා ක්‍රියා පද විභක්ති, සංධි හා සමාස, කාව්‍ය රසවින්දනය, ගද්‍ය විචාර, කෙටි සටහන් හා වාක්‍ය රීති"
        2 -> "උපසර්ග හා ප්‍රත්‍යය, කර්ම කාරක හා කර්තෘ කාරක වාක්‍ය, ප්‍රස්ථා පිරුළු හා රූඪි, සම්භාව්‍ය සාහිත්‍ය උපුටන, විරාම ලක්ෂණ භාවිතය"
        else -> "ඡන්දස් හා අලංකාර, නවකතා හා කෙටිකතා විචාර, නිබන්ධන රචනා ආකෘති, සන්නිවේදන ශිල්පක්‍රම, පූර්ණ විභාග සාහිත්‍ය සංග්‍රහය"
      }
      "ඉංග්‍රීසි" -> when (term) {
        1 -> "Tenses (Present, Past, Future), Subject-Verb Agreement, Pronouns & Articles, Reading Comprehension, Prepositions & Conjunctions"
        2 -> "Active & Passive Voice, Direct & Indirect Speech, Vocabulary in Context, Conditional Sentences (If clauses), Formal Letter Writing"
        else -> "Relative Clauses, Adjectives & Adverbs degrees of comparison, Error Correction, Idioms & Phrasal Verbs, O/L Final Exam Practice"
      }
      "භූගෝල විද්‍යාව" -> when (term) {
        1 -> "පෘථිවියේ ස්වභාවය හා පිහිටීම, ශ්‍රී ලංකාවේ භූගෝලීය පිහිටීම, කාලගුණය හා දේශගුණය, සිතියම් කියවීම හා අර්ථකථනය"
        2 -> "ලෝකයේ හා ශ්‍රී ලංකාවේ ජනගහනය, ස්වභාවික සම්පත් කළමනාකරණය, කෘෂිකර්මාන්තය හා ධීවර කර්මාන්තය"
        else -> "පරිසර දූෂණය හා සංරක්ෂණය, ප්‍රවාහනය හා සන්නිවේදනය, සංචාරක ව්‍යාපාරය, ලෝකයේ ප්‍රධාන භූ දේශපාලනික කලාප"
      }
      "පුරවැසි අධ්‍යාපනය" -> when (term) {
        1 -> "ප්‍රජාතන්ත්‍රවාදී සමාජයක ලක්ෂණ, ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම විකාශනය, මානව හිමිකම් හා වගකීම්, නීතිය හා යුක්තිය"
        2 -> "රාජ්‍ය මූල්‍ය පද්ධතිය, පළාත් පාලන ආයතන, මධ්‍යම රජයේ ක්‍රියාකාරිත්වය, ජාත්‍යන්තර සබඳතා හා සහයෝගිතාව"
        else -> "තිරසාර සංවර්ධනය, ගැටලු නිරාකරණය හා සාමය, බහුවිධ සමාජයක ජීවත්වීම, සක්‍රිය පුරවැසිභාවය හා නායකත්වය"
      }
      "තොරතුරු හා සන්නිවේදන තාක්ෂණය" -> when (term) {
        1 -> "දත්ත හා තොරතුරු, පරිගණකයේ පරිණාමය හා වර්ගීකරණය, පරිගණක පද්ධතියේ කොටස්, ද්විමය සංඛ්‍යා පද්ධතිය"
        2 -> "මෙහෙයුම් පද්ධති, ව්‍යවහාරික මෘදුකාංග (Word, Excel, PowerPoint), දත්ත සමුදාය කළමනාකරණය (DBMS), අන්තර්ජාලය හා විද්‍යුත් තැපෑල"
        else -> "ක්‍රමලේඛන මූලධර්ම (Programming), ඇල්ගොරිතම හා ගැලීම් සටහන්, වෙබ් අඩවි නිර්මාණය (HTML), තාක්ෂණයේ ආචාර ධර්ම හා ආරක්ෂාව"
      }
      "ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය" -> when (term) {
        1 -> "ව්‍යාපාර පසුබිම, ව්‍යාපාර වර්ගීකරණය, ව්‍යාපාරික ආයතන, ගිණුම්කරණ සමීකරණය, ද්විත්ව සටහන් මූලධර්මය"
        2 -> "මුල් පොත්, ලෙජරය, ශේෂ පත්‍රය, බැංකු සැසඳුම් ප්‍රකාශය, සුළු මුදල් පොත, නිෂ්පාදන ගිණුම්"
        else -> "අවසාන ගිණුම් (වෙළඳ, ලාභ අලාභ හා ශේෂ පත්‍රය), මූල්‍ය විශ්ලේෂණය, කළමනාකරණ තීරණ ගැනීම, ව්‍යාපාර සැලසුම්කරණය"
      }
      "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය" -> when (term) {
        1 -> "සෞඛ්‍ය සම්පන්න ජීවිතයක්, පෝෂණය හා ආහාර සුරක්ෂිතතාව, වර්ධනය හා සංවර්ධනය, බෝ නොවන රෝග වැළැක්වීම"
        2 -> "ප්‍රථමාධාර හා ආරක්ෂාව, ප්‍රජනක සෞඛ්‍යය, මත්ද්‍රව්‍ය හා දුම්වැටි විරෝධය, මානසික සුවතාවය හා පීඩනය කළමනාකරණය"
        else -> "ක්‍රීඩා හා ශාරීරික යෝග්‍යතාවය, මලල ක්‍රීඩා, කණ්ඩායම් ක්‍රීඩා (වොලිබෝල්, නෙට්බෝල්), ඔලිම්පික් ඉතිහාසය හා ක්‍රීඩා ආචාර ධර්ම"
      }
      "බුද්ධ ධර්මය" -> when (term) {
        1 -> "බුද්ධ චරිතය හා බුද්ධ ඥාන, මූලික ධර්ම කරුණු (චතුරාර්ය සත්‍යය, ආර්ය අෂ්ටාංගික මාර්ගය), ශාසන ඉතිහාසය, පන්සිල් හා බෞද්ධ ආචාර ධර්ම"
        2 -> "බෝධිසත්ව ගුණ හා ජාතක කතා, ත්‍රිපිටකය හා ධර්ම සංගායනා, බෞද්ධ සංස්කෘතිය හා සිද්ධස්ථාන, සූත්‍ර ධර්ම විවරණය"
        else -> "කර්මය හා පුනර්භවය, බුදුදහම හා නූතන සමාජය, ලක්දිව බුදුසසුන ව්‍යාප්තිය, බෞද්ධ කලාව හා චිත්‍ර-මූර්ති, විභාග පූර්ණ පුහුණුව"
      }
      else -> when (term) {
        1 -> "විෂය නිර්දේශ මූලික කරුණු, හඳුන්වාදීමේ ඒකක, පදනම් සංකල්ප හා ප්‍රධාන මූලධර්ම"
        2 -> "ගැඹුරු විග්‍රහය, ප්‍රායෝගික යෙදවුම්, සිද්ධාන්ත හා නියමයන් පිළිබඳ සවිස්තරාත්මක අධ්‍යයනය"
        else -> "සංශෝධන ඒකක, පුනරීක්ෂණ අභ්‍යාස, විභාග ඉලක්කගත අවසාන මහා පෙරහුරු පරීක්ෂණය"
      }
    }
  }

  /**
   * Generates exactly 60 distinct syllabus-accurate questions.
   * Completely avoids question repetition within the paper or across papers.
   */
  private fun generate60Questions(
    grade: String,
    subject: String,
    term: Int,
    paperIdx: Int
  ): List<MockExamQuestion> {
    return TermPaperUnique60Provider.get60DistinctQuestions(
      grade = grade,
      subject = subject,
      term = term,
      paperIdx = paperIdx
    )
  }

  private fun getQuestionTemplatesForTerm(subject: String, term: Int): List<ExamQuestionTemplate> {
    return when (subject) {
      "විද්‍යාව" -> when (term) {
        1 -> ScienceTerm1Templates
        2 -> ScienceTerm2Templates
        else -> ScienceTerm3Templates
      }
      "ගණිතය" -> when (term) {
        1 -> MathTerm1Templates
        2 -> MathTerm2Templates
        else -> MathTerm3Templates
      }
      "ඉතිහාසය" -> when (term) {
        1 -> HistoryTerm1Templates
        2 -> HistoryTerm2Templates
        else -> HistoryTerm3Templates
      }
      "සිංහල" -> SinhalaTemplates
      "ඉංග්‍රීසි" -> EnglishTemplates
      "භූගෝල විද්‍යාව" -> GeographyTemplates
      "පුරවැසි අධ්‍යාපනය" -> CivicsTemplates
      "තොරතුරු හා සන්නිවේදන තාක්ෂණය" -> IctTemplates
      "ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය" -> BusinessTemplates
      "සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය" -> HealthTemplates
      else -> BuddhismTemplates
    }
  }

  // --------------------------------------------------------------------------
  // TEMPLATE INTERFACE & IMPLEMENTATIONS
  // --------------------------------------------------------------------------

  interface ExamQuestionTemplate {
    fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion
  }

  // SCIENCE TERM 1 (10 Topics -> 60 Questions)
  private val ScienceTerm1Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val nutrients = listOf("ග්ලූකෝස් (කාබෝහයිඩ්‍රේට)", "ප්‍රෝටීන", "ලිපිඩ", "න්‍යෂ්ටික අම්ල")
        val tests = listOf("බෙනඩික්ට් පරීක්ෂාවෙන් රතු අවක්ෂේපය", "බයියුරෙට් පරීක්ෂාවෙන් දම් පැහැය", "සුඩාන් III පරීක්ෂාවෙන් රතු තට්ටුව", "අයඩින් පරීක්ෂාවෙන් තද නිල් පැහැය")
        val correct = ((id + paperIdx) % 4) + 1
        val chosenNutrient = nutrients[(correct - 1) % nutrients.size]
        val chosenTest = tests[(correct - 1) % tests.size]
        return MockExamQuestion(
          id = id,
          questionText = "ආහාර සාම්පලයක් පරීක්ෂා කිරීමේදී $chosenTest ලබා දුන්නේ නම්, එහි අඩංගු ප්‍රධාන ජෛව අණුව වන්නේ,",
          options = nutrients,
          correctOption = correct,
          explanation = "$chosenNutrient හඳුනාගැනීම සඳහා භාවිත කරන්නේ $chosenTest යි. මෙය ජීවයේ රසායනික පදනම විෂය ඒකකයේ සම්මත පරීක්ෂාවකි.",
          topicName = "ජීවයේ රසායනික පදනම"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val elements = listOf("සෝඩියම් (Na - 11)", "මැග්නීසියම් (Mg - 12)", "ඇලුමිනියම් (Al - 13)", "ක්ලෝරීන් (Cl - 17)")
        val configs = listOf("2, 8, 1", "2, 8, 2", "2, 8, 3", "2, 8, 7")
        val correct = ((id * 2 + paperIdx) % 4) + 1
        val elem = elements[correct - 1]
        val conf = configs[correct - 1]
        return MockExamQuestion(
          id = id,
          questionText = "පරමාණුක ක්‍රමාංකය දැක්වෙන $elem පරමාණුවේ නිවැරදි ඉලෙක්ට්‍රෝන වින්‍යාසය කුමක්ද?",
          options = configs,
          correctOption = correct,
          explanation = "$elem හි ඉලෙක්ට්‍රෝන මට්ටම්වල ව්‍යාප්තිය $conf වේ. පිටත කවචයේ ඇති ඉලෙක්ට්‍රෝන සංඛ්‍යාව සංයුජතාව තීරණය කරයි.",
          topicName = "පදාර්ථයේ ව්‍යුහය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val u = (id + paperIdx) % 5 * 2
        val a = 2 + (paperIdx % 3)
        val t = 5
        val v = u + a * t
        val correct = ((id + 1) % 4) + 1
        val optList = mutableListOf("$v m/s", "${v - 4} m/s", "${v + 6} m/s", "${v * 2} m/s")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "නිශ්චලතාවයෙන් ආරම්භ වන වස්තුවක් $a m s⁻² ඒකාකාර ත්වරණයකින් තත්පර $t ක් චලනය වූ පසු ලබාගන්නා ප්‍රවේගය කොපමණද?",
          options = optList,
          correctOption = correct,
          explanation = "v = u + at සමීකරණය භාවිතයෙන්: u = 0, a = $a m s⁻², t = $t s => v = 0 + ($a × $t) = $v m s⁻¹.",
          topicName = "රේඛීය චලිතය සහ චලිත සමීකරණ"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val compounds = listOf("NaCl (අයනික බන්ධන)", "H₂O (ධ්‍රැවීය සහසංයුජ)", "CH₄ (අධ්‍රැවීය සහසංයුජ)", "NH₃ (සහසංයුජ බන්ධන)")
        val correct = ((id + 3) % 4) + 1
        return MockExamQuestion(
          id = id,
          questionText = "ඉලෙක්ට්‍රෝන හුවමාරුව මගින් කැටායන හා ඇනායන සෑදෙමින් නිර්මාණය වන සංයෝගය කුමක්ද?",
          options = compounds,
          correctOption = 1,
          explanation = "සෝඩියම් ලෝහය ඉලෙක්ට්‍රෝනයක් පිටකර Na⁺ සාදන අතර ක්ලෝරීන් අලෝහය එය ලබාගෙන Cl⁻ සාදමින් අයනික බන්ධනයක් තනයි.",
          topicName = "රසායනික බන්ධන"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val mass = 18 + (id % 5) * 18
        val molarMass = 18 // H2O
        val moles = mass / molarMass
        val correct = ((id + paperIdx) % 4) + 1
        val optList = mutableListOf("$moles mol", "${moles + 1} mol", "${moles * 2} mol", "0.5 mol")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "ජලය (H₂O, මවුලික ස්කන්ධය = 18 g mol⁻¹) $mass g ක අඩංගු ජල අණු මවුල ප්‍රමාණය කොපමණද?",
          options = optList,
          correctOption = correct,
          explanation = "මවුල ගණන (n) = ස්කන්ධය (m) / මවුලික ස්කන්ධය (M) = $mass g / 18 g mol⁻¹ = $moles mol වේ.",
          topicName = "මවුලය හා රසායනික ගණනය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val m = 5 + (id % 4)
        val a = 3 + (paperIdx % 3)
        val force = m * a
        val correct = (id % 4) + 1
        val optList = mutableListOf("$force N", "${force + 5} N", "${force - 4} N", "${force * 2} N")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "ස්කන්ධය $m kg වූ වස්තුවකට $a m s⁻² ක ත්වරණයක් ලබාදීමට යෙදිය යුතු අසමතුලිත බලය කොපමණද?",
          options = optList,
          correctOption = correct,
          explanation = "නිව්ටන්ගේ දෙවන චලිත නියමයට අනුව F = ma = $m kg × $a m s⁻² = $force N වේ.",
          topicName = "නිව්ටන් නියම සහ බලය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val organelles = listOf("හරිතලවය (ක්ලෝරෝප්ලාස්ටය)", "මයිටොකොන්ඩ්‍රියම", "රයිබොසෝමය", "ගොල්ගි දේහය")
        val correct = ((id + 2) % 4) + 1
        val q = when (correct) {
          1 -> "ශාක සෛලවල ප්‍රභාසංශ්ලේෂණය සඳහා ආලෝක ශක්තිය අවශෝෂණය කරන ඉන්ද්‍රයිකාව කුමක්ද?"
          2 -> "සෛලීය ශ්වසනය මගින් ATP ලෙස ශක්තිය නිපදවන සෛලයේ බලාගාරය ලෙස හඳුන්වන්නේ කුමක්ද?"
          3 -> "සෛලය තුළ ප්‍රෝටීන සංශ්ලේෂණය සිදුවන ප්‍රධාන අංශුමය ඉන්ද්‍රයිකාව කුමක්ද?"
          else -> "සෛලීය ස්‍රාව නිපදවීම හා ඇසුරුම් කිරීම සිදුකරන ඉන්ද්‍රයිකාව කුමක්ද?"
        }
        return MockExamQuestion(
          id = id,
          questionText = q,
          options = organelles,
          correctOption = correct,
          explanation = "සෛලීය ඉන්ද්‍රයිකා සහ ඒවායේ නිශ්චිත කාර්යයන් ශ්‍රී ලංකා විෂය නිර්දේශයේ මූලික ජීව විද්‍යා සංකල්පයකි.",
          topicName = "ශාක හා සත්ත්ව සෛල"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val factors = listOf("ආලෝක තීව්‍රතාව හා කාබන් ඩයොක්සයිඩ් සාන්ද්‍රණය", "නයිට්‍රජන් වායුව පමණි", "ඔක්සිජන් වායු සාන්ද්‍රණය පමණි", "පාංශු pH අගය පමණි")
        return MockExamQuestion(
          id = id,
          questionText = "ප්‍රභාසංශ්ලේෂණ අනුපාතය කෙරෙහි සෘජුවම සීමාකාරී සාධක ලෙස බලපාන්නේ පහත කුමන යුගලයද?",
          options = factors,
          correctOption = 1,
          explanation = "ප්‍රභාසංශ්ලේෂණය සඳහා ආලෝකය, CO₂ සාන්ද්‍රණය, උෂ්ණත්වය සහ ජලය ප්‍රධාන සීමාකාරී සාධක ලෙස ක්‍රියා කරයි.",
          topicName = "ජීවී දේහ ක්‍රියාවලි - ප්‍රභාසංශ්ලේෂණය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val enzymes = listOf("ඇමයිලේස් (පිෂ්ඨය සඳහා)", "පෙප්සින් (ප්‍රෝටීන සඳහා)", "ලිපේස් (ලිපිඩ සඳහා)", "ට්‍රිප්සින් (ප්‍රෝටීන සඳහා)")
        val correct = ((id + paperIdx) % 4) + 1
        return MockExamQuestion(
          id = id,
          questionText = "ආමාශය තුළදී ආම්ලික මාධ්‍යයක ප්‍රෝටීන ජීර්ණය ආරම්භ කරන්නේ කුමන එන්සයිමය මගින්ද?",
          options = enzymes,
          correctOption = 2,
          explanation = "ආමාශයික යුෂයේ ඇති පෙප්සින් එන්සයිමය HCl අම්ලයේ ආම්ලික මාධ්‍යය යටතේ ප්‍රෝටීන පොලිපෙප්ටයිඩ බවට පත් කරයි.",
          topicName = "සත්ත්ව පෝෂණය හා ආහාර ජීර්ණය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val trends = listOf("පරමාණුක අරය ක්‍රමයෙන් අඩුවේ", "අයනීකරණ ශක්තිය අඩුවේ", "ලෝහක ගුණය වැඩිවේ", "විද්‍යුත් සෘණතාව අඩුවේ")
        return MockExamQuestion(
          id = id,
          questionText = "ආවර්තිතා වගුවේ ආවර්තයක් ඔස්සේ වමේ සිට දකුණට ගමන් කිරීමේදී පෙන්වන නිවැරදි විචලනය කුමක්ද?",
          options = trends,
          correctOption = 1,
          explanation = "න්‍යෂ්ටික ආරෝපණය වැඩිවීම නිසා ඉලෙක්ට්‍රෝන න්‍යෂ්ටිය දෙසට ඇදී යාමෙන් ආවර්තයක් ඔස්සේ දකුණට යනවිට පරමාණුක අරය අඩුවේ.",
          topicName = "මූලද්‍රව්‍ය ආවර්තිතාව"
        )
      }
    }
  )

  // SCIENCE TERM 2 (10 Topics -> 60 Questions)
  private val ScienceTerm2Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val options = listOf("ග්ලූකෝස් + O₂ → CO₂ + H₂O + 38 ATP", "ග්ලූකෝස් → එතනෝල් + CO₂ + 2 ATP", "ග්ලූකෝස් → ලැක්ටික් අම්ලය + 2 ATP", "කාබන් ඩයොක්සයිඩ් + ජලය → ග්ලූකෝස්")
        val correct = ((id + paperIdx) % 3) + 1
        return MockExamQuestion(
          id = id,
          questionText = "මානව මාංශපේශී ක්ලාන්තයේදී නිර්වායු ශ්වසනය නිසා සෑදෙන ඵලය හා ශක්ති සමීකරණය කුමක්ද?",
          options = options,
          correctOption = 3,
          explanation = "ඔක්සිජන් ඌනතාවයේදී මිනිස් මාංශපේශි සෛල තුළ නිර්වායු ශ්වසනය සිදුවී ලැක්ටික් අම්ලය තැන්පත්වීමෙන් පේශි විඩාව/ක්ලාන්තය හටගනී.",
          topicName = "ශ්වසනය සහ වායු හුවමාරුව"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val vessels = listOf("මහා ධමනිය (Aorta)", "පුප්ඵුසීය ධමනිය (Pulmonary Artery)", "පුප්ඵුසීය ශිරාව (Pulmonary Vein)", "මහා ශිරාව (Vena Cava)")
        val correct = ((id + 1) % 4) + 1
        val q = when (correct) {
          1 -> "වම් කෝෂිකාවේ සිට මුළු ශරීරයටම ඔක්සිජනීකෘත රුධිරය ගෙන යන ප්‍රධාන රුධිර නාලය කුමක්ද?"
          2 -> "දකුණු කෝෂිකාවේ සිට පෙනහළු වෙත ඔක්සිජන්-හීන රුධිරය ගෙනයන ධමනිය කුමක්ද?"
          3 -> "පෙනහළුවල සිට වම් කර්ණිකාවට ඔක්සිජනීකෘත පිරිසිදු රුධිරය ගෙන එන ශිරාව කුමක්ද?"
          else -> "ශරීරයේ ඉහළ හා පහළ කොටස්වලින් අපිරිසිදු රුධිරය දකුණු කර්ණිකාවට ගෙන එන නාලය කුමක්ද?"
        }
        return MockExamQuestion(
          id = id,
          questionText = q,
          options = vessels,
          correctOption = correct,
          explanation = "මානව රුධිර සංසරණ පද්ධතියේ ද්විත්ව සංසරණ යාන්ත්‍රණය විභාගයේ නිරන්තරයෙන් පරීක්ෂා කෙරෙන ප්‍රධාන සංකල්පයකි.",
          topicName = "මානව රුධිර සංසරණ පද්ධතිය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val soluteMass = 20 + (id % 4) * 10
        val solutionVol = 500 // cm3 = 0.5 dm3
        val conc = (soluteMass / 40.0) / 0.5 // for NaOH molar mass 40
        val correct = (id % 4) + 1
        val optList = mutableListOf("$conc mol dm⁻³", "${conc + 0.5} mol dm⁻³", "${conc * 2} mol dm⁻³", "0.1 mol dm⁻³")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "ජලය 500 cm³ ක NaOH (මවුලික ස්කන්ධය = 40 g mol⁻¹) $soluteMass g දියකර සාදන ලද ද්‍රාවණයේ සාන්ද්‍රණය කොපමණද?",
          options = optList,
          correctOption = correct,
          explanation = "මවුල = $soluteMass / 40 = ${soluteMass / 40.0} mol. පරිමාව = 500/1000 = 0.5 dm³. සාන්ද්‍රණය C = n/V = $conc mol dm⁻³ වේ.",
          topicName = "ද්‍රාවණ හා ද්‍රාව්‍යතාව"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val indicators = listOf("pH අගය 7ට වඩා අඩුය (රතු පැහැ ලිට්මස් නිල් නොවේ)", "pH අගය 7ට වඩා වැඩිය (රතු ලිට්මස් නිල් කරයි)", "pH අගය හරියටම 7 වේ", "පීනොෆ්තලීන් සමග රෝස පැහැයක් දෙයි")
        return MockExamQuestion(
          id = id,
          questionText = "ප්‍රබල අම්ලයක (උදා: තනුක HCl) ජලීය ද්‍රාවණයක් සම්බන්ධයෙන් සත්‍ය ප්‍රකාශය කුමක්ද?",
          options = indicators,
          correctOption = 1,
          explanation = "අම්ලවල pH අගය 7ට වඩා අඩු අතර නිල් ලිට්මස් රතු කරයි. භෂ්මවල pH අගය 7ට වඩා වැඩි වේ.",
          topicName = "අම්ල, භෂ්ම හා ලවණ"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val f = 20 + (id % 5) * 10
        val s = 5 + (paperIdx % 4)
        val work = f * s
        val correct = ((id + 2) % 4) + 1
        val optList = mutableListOf("$work J", "${work + 50} J", "${work / 2} J", "${work * 2} J")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "වස්තුවක් මත $f N බලයක් යොදා බලය යෙදූ දිශාව ඔස්සේ $s m දුරක් විස්ථාපනය කළ විට කළ කාර්යය ප්‍රමාණය කුමක්ද?",
          options = optList,
          correctOption = correct,
          explanation = "කාර්යය (W) = බලය (F) × විස්ථාපනය (s) = $f N × $s m = $work J (ජූල්) වේ.",
          topicName = "කාර්යය, ශක්තිය හා ක්ෂමතාව"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val waves = listOf("ශබ්ද තරංග (Sound Waves)", "ආලෝක තරංග (Light Waves)", "එක්ස් කිරණ (X-rays)", "ගුවන්විදුලි තරංග (Radio Waves)")
        return MockExamQuestion(
          id = id,
          questionText = "පහත දැක්වෙන තරංග අතුරින් යාන්ත්‍රික සහ අන්වායාම තරංගයක් වන්නේ කුමක්ද?",
          options = waves,
          correctOption = 1,
          explanation = "ශබ්ද තරංග මාධ්‍ය කම්පන ඔස්සේ ගමන් කරන යාන්ත්‍රික අන්වායාම තරංග වේ. ආලෝකය හා විද්‍යුත් චුම්භක තරංග තීර්යක් තරංග වේ.",
          topicName = "තරංග සහ ඒවායේ යෙදීම්"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val heatUnits = listOf("J kg⁻¹ °C⁻¹ (හෝ J kg⁻¹ K⁻¹)", "J kg⁻¹", "W m⁻¹ K⁻¹", "Calorie පමණි")
        return MockExamQuestion(
          id = id,
          questionText = "ද්‍රව්‍යයක විශිෂ්ට තාප ධාරිතාව (c) මනින සම්මත SI ජාත්‍යන්තර ඒකකය කුමක්ද?",
          options = heatUnits,
          correctOption = 1,
          explanation = "Q = mcΔθ සමීකරණයෙන් c = Q / (mΔθ) බැවින් ඒකකය J / (kg K) හෙවත් J kg⁻¹ °C⁻¹ වේ.",
          topicName = "තාපය හා උෂ්ණත්වය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val pressureEqs = listOf("P = h ρ g", "P = F / A", "P = m g h", "P = 1/2 ρ v²")
        return MockExamQuestion(
          id = id,
          questionText = "ඝනත්වය ρ වූ නිශ්චල ද්‍රවයක h ගැඹුරකදී ඇතිවන ද්‍රව පීඩනය ගණනය කිරීමේ නිවැරදි සූත්‍රය කුමක්ද?",
          options = pressureEqs,
          correctOption = 1,
          explanation = "නිශ්චල ද්‍රව කඳක ගැඹුර සමග පීඩනය P = hρg සූත්‍රයෙන් ලැබේ (h = ගැඹුර, ρ = ඝනත්වය, g = ගුරුත්වජ ත්වරණය).",
          topicName = "පීඩනය සහ එහි යෙදීම්"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val plantTissues = listOf("ශෛලම පටකය (Xylem)", "ෆ්ලෝයම පටකය (Phloem)", "මෘදුස්තරය", "දෘඪස්තරය")
        return MockExamQuestion(
          id = id,
          questionText = "ශාකවල පසෙන් උරාගන්නා ජලය සහ ඛනිජ ලවණ ඉහළට පරිවහනය කරන සනාල පටකය කුමක්ද?",
          options = plantTissues,
          correctOption = 1,
          explanation = "ජලය හා ඛනිජ ලවණ ශෛලම වාහිනී මගින්ද, ප්‍රභාසංශ්ලේෂණ ආහාර (සුක්රෝස්) ෆ්ලෝයම පටකය මගින්ද ශාකය පුරා පරිවහනය කරයි.",
          topicName = "ශාකවල ජල හා ඛනිජ පරිවහනය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val nephronParts = listOf("ග්ලොමරුලස (Glomerulus)", "බෝමන් ප්‍රවාරය", "සමීපස්ථ සංවලිත නාලිකාව", "හෙන්ලේ පුඩුව")
        return MockExamQuestion(
          id = id,
          questionText = "වෘක්කාණුවක් තුළ අතිපෙරීම (Ultrafiltration) සිදුවන ප්‍රධාන රුධිර කේෂනාලිකා ජාලය කුමක්ද?",
          options = nephronParts,
          correctOption = 1,
          explanation = "අභිවාහී ධමනිකාවෙන් පැමිණෙන රුධිරය අධික පීඩනයක් යටතේ ග්ලොමරුලස තුළදී පෙරී ප්‍රාථමික මුත්‍ර පෙරනය සාදයි.",
          topicName = "ශාක හා සත්ත්ව බහිස්ස්‍රාවය"
        )
      }
    }
  )

  // SCIENCE TERM 3 (10 Topics -> 60 Questions)
  private val ScienceTerm3Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val r1 = 6
        val r2 = 3
        val eqR = (r1 * r2) / (r1 + r2) // 2 ohm
        val v = 12
        val i = v / eqR // 6 A
        val correct = ((id + paperIdx) % 4) + 1
        val optList = mutableListOf("$eqR Ω", "${r1 + r2} Ω", "9 Ω", "0.5 Ω")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "$r1 Ω සහ $r2 Ω ප්‍රතිරෝධක දෙකක් සමාන්තරගතව සම්බන්ධ කර ඇති විට පරිපථයේ සමක ප්‍රතිරෝධය කුමක්ද?",
          options = optList,
          correctOption = correct,
          explanation = "සමාන්තරගත ප්‍රතිරෝධ සඳහා: 1/R = 1/R₁ + 1/R₂ => 1/R = 1/6 + 1/3 = 3/6 = 1/2 => R = $eqR Ω.",
          topicName = "ධාරා විද්‍යුතය සහ ඕම් නියමය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val p = 1000 // Watts = 1 kW
        val hours = 5
        val units = (p * hours) / 1000 // kWh
        val correct = (id % 4) + 1
        val optList = mutableListOf("$units kWh (යුනිට්)", "${units * 2} kWh", "0.5 kWh", "${units + 2} kWh")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "1000 W විදුලි හීටරයක් පැය $hours ක් අඛණ්ඩව ක්‍රියාත්මක කළ විට වැයවන විදුලි ඒකක (kWh) සංඛ්‍යාව කොපමණද?",
          options = optList,
          correctOption = correct,
          explanation = "විද්‍යුත් ශක්තිය E = P (kW) × t (h) = 1 kW × $hours h = $units kWh (යුනිට් $units) වේ.",
          topicName = "විද්‍යුත් බලය සහ ශක්තිය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val rules = listOf("ෆ්ලෙමින්ගේ වමත් නියමය (Fleming's Left Hand Rule)", "ෆ්ලෙමින්ගේ දකුණත් නියමය", "දකුණත් ඇඟිලි නියමය", "ලෙන්ස් නියමය")
        return MockExamQuestion(
          id = id,
          questionText = "චුම්භක ක්ෂේත්‍රයක තබා ඇති ධාරාවක් ගෙන යන සන්නායකයක් මත ක්‍රියා කරන චලිත බලයේ දිශාව සෙවීමට භාවිත කරන්නේ කුමක්ද?",
          options = rules,
          correctOption = 1,
          explanation = "විද්‍යුත් මෝටර මූලධර්මය: ෆ්ලෙමින්ගේ වමත් නියමය (මහපටැඟිල්ල = චලිතය/බලය, දබරැඟිල්ල = ක්ෂේත්‍රය, මැදැඟිල්ල = ධාරාව).",
          topicName = "විද්‍යුත් චුම්භකත්වය හා මෝටර"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val gates = listOf("AND ද්වාරය", "OR ද්වාරය", "NOT ද්වාරය", "NAND ද්වාරය")
        return MockExamQuestion(
          id = id,
          questionText = "ආදාන දෙකම 1 (High) වූ විට පමණක් ප්‍රතිදානය 1 වන මූලික තාර්කික ද්වාරය කුමක්ද?",
          options = gates,
          correctOption = 1,
          explanation = "AND ද්වාරයේ සත්‍යතා වගුව අනුව ආදාන A=1 සහ B=1 වනවිට ප්‍රතිදානය Y = A.B = 1 වේ.",
          topicName = "ඉලෙක්ට්‍රොනික විද්‍යාව"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val defectFix = listOf("උත්තල කාච (Convex Lenses) සහිත උපැස්", "අවතල කාච (Concave Lenses) සහිත උපැස්", "සිලින්ඩරාකාර කාච", "ද්විත්ව නාභි කාච")
        return MockExamQuestion(
          id = id,
          questionText = "දුරදෘෂ්ටිකතාව (Hypermetropia) සහිත පුද්ගලයෙකුගේ දෘෂ්ටි දෝෂය නිවැරදි කිරීමට භාවිත කරන කාච වර්ගය කුමක්ද?",
          options = defectFix,
          correctOption = 1,
          explanation = "දුරදෘෂ්ටිකත්වයේදී ප්‍රතිබිම්බය දෘෂ්ටිවිතානයට පිටුපසින් සෑදෙන බැවින් කිරණ අභිසාරී කරන උත්තල කාච යොදා නිවැරදි කරයි.",
          topicName = "ආලෝකය සහ දෘෂ්ටි විද්‍යාව"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val ratios = listOf("3 : 1", "1 : 2 : 1", "9 : 3 : 3 : 1", "1 : 1")
        return MockExamQuestion(
          id = id,
          questionText = "මෙන්ඩල්ගේ ඒක මුහුම් පරීක්ෂණයේ F₂ පරම්පරාවේ ලැබෙන දෘශ්‍යරූපී අනුපාතය (Phenotypic Ratio) කුමක්ද?",
          options = ratios,
          correctOption = 1,
          explanation = "උස (Tt) සහ උස (Tt) මුහුම් කළ විට F₂ හි උස : මිටි දෘශ්‍යරූපී අනුපාතය 3 : 1 ද, ජානදර්ශ අනුපාතය 1 : 2 : 1 ද වේ.",
          topicName = "ප්‍රවේණිය සහ ජාන"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val formulas = listOf("CₙH₂ₙ₊₂ (ඇල්කේන)", "CₙH₂ₙ (ඇල්කීන)", "CₙH₂ₙ₋₂ (ඇල්කයින)", "CₙH₂ₙ₊₁OH (ඇල්කොහොල)")
        return MockExamQuestion(
          id = id,
          questionText = "තනි බන්ධන පමණක් අඩංගු සංතෘප්ත හයිඩ්‍රොකාබන හෙවත් ඇල්කේනවල පොදු අණුක සූත්‍රය කුමක්ද?",
          options = formulas,
          correctOption = 1,
          explanation = "ඇල්කේන (මීතේන්, ඊතේන් ආදී) සංතෘප්ත හයිඩ්‍රොකාබන වන අතර පොදු සූත්‍රය CₙH₂ₙ₊₂ වේ.",
          topicName = "කාබනික රසායනය හා හයිඩ්‍රොකාබන"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val methods = listOf("සින්ක් (Zn) තහඩු ගැල්වනයිස් කිරීම මගින් කැතෝඩික ආරක්ෂාව සැපයීම", "තෙතමනයට නිරාවරණය කිරීම", "තඹ සමග සෘජුව සම්බන්ධ කිරීම", "අම්ලයක් තැවරීම")
        return MockExamQuestion(
          id = id,
          questionText = "යකඩ මලබැඳීම (විඛාදනය) වැළැක්වීම සඳහා භාවිත කරන වඩාත්ම සාර්ථක ක්‍රමවේදය කුමක්ද?",
          options = methods,
          correctOption = 1,
          explanation = "යකඩවලට වඩා ප්‍රතික්‍රියාශීලී සින්ක් ලෝහයෙන් ආලේප කිරීම (ගැල්වනයිස් කිරීම) මගින් පරිත්‍යාගී ඇනෝඩයක් ලෙස ක්‍රියාකර විඛාදනය වළකයි.",
          topicName = "ලෝහ නිස්සාරණය හා විඛාදනය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val cycles = listOf("කාබන් ඩයොක්සයිඩ් (CO₂)", "නයිට්‍රජන් වායුව", "ඔක්සිජන් වායුව", "ආගන් වායුව")
        return MockExamQuestion(
          id = id,
          questionText = "වායුගෝලයේ හරිතාගාර ආචරණය හා ගෝලීය උෂ්ණත්වය ඉහළයාමට ප්‍රධාන වශයෙන් වගකිවයුතු වායුව කුමක්ද?",
          options = cycles,
          correctOption = 1,
          explanation = "ෆොසිල ඉන්ධන දහනය නිසා වායුගෝලයට එකතුවන CO₂ වායුව අධෝරක්ත කිරණ උගුලට හසුකර ගනිමින් ගෝලීය උෂ්ණත්වය වැඩි කරයි.",
          topicName = "පරිසරය හා ජෛව විවිධත්වය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val rays = listOf("ගැමා (γ) කිරණ", "ඇල්ෆා (α) අංශු", "බීටා (β) අංශු", "ප්‍රෝටෝන කදම්භ")
        return MockExamQuestion(
          id = id,
          questionText = "විකිරණශීලී ක්ෂයවීම්වලදී විද්‍යුත් හා චුම්භක ක්ෂේත්‍ර මගින් අපගමනය නොවන අධි විනිවිදීමේ හැකියාව ඇති විකිරණය කුමක්ද?",
          options = rays,
          correctOption = 1,
          explanation = "ගැමා (γ) යනු ආරෝපණ රහිත විද්‍යුත් චුම්භක තරංග බැවින් ක්ෂේත්‍රවලදී අපගමනය නොවන අතර ඊයම් ඝන තහඩුවකින් පමණක් අවහිර කළ හැක.",
          topicName = "විකිරණශීලීතාවය සහ න්‍යෂ්ටික ශක්තිය"
        )
      }
    }
  )

  // MATHEMATICS TERM 1, 2, 3
  private val MathTerm1Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val a = 2 + (id % 3)
        val b = 3 + (paperIdx % 3)
        val sum = a + b
        val prod = a * b
        val correct = ((id + paperIdx) % 4) + 1
        val optList = mutableListOf("(x + $a)(x + $b)", "(x - $a)(x - $b)", "(x + $a)(x - $b)", "(x + ${a + 1})(x + ${b - 1})")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "x² + ${sum}x + $prod වීජීය ප්‍රකාශනයේ සාධක වෙන් කළ විට ලැබෙන පිළිතුර කුමක්ද?",
          options = optList,
          correctOption = correct,
          explanation = "ගුණිතය $prod සහ එකතුව $sum වන සංඛ්‍යා යුගලය $a සහ $b වේ. එබැවින් (x + $a)(x + $b) සාධක වේ.",
          topicName = "වර්ගජ ප්‍රකාශන සහ සාධක"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val pow = 3 + (id % 4)
        val ans = Math.pow(2.0, pow.toDouble()).toInt()
        val correct = (id % 4) + 1
        val optList = mutableListOf("$pow", "${pow + 1}", "${pow - 1}", "${ans / 2}")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "ලඝුගණක ප්‍රකාශනය log₂ $ans හි අගය කුමක්ද?",
          options = optList,
          correctOption = correct,
          explanation = "2 හි $pow වන බලය 2^$pow = $ans බැවින් log₂ $ans = $pow වේ.",
          topicName = "ලඝුගණක I සහ II"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val angle1 = 50 + (id % 4) * 10
        val angle2 = 60
        val angle3 = 180 - (angle1 + angle2)
        val correct = ((id + 2) % 4) + 1
        val optList = mutableListOf("$angle3°", "${angle3 + 10}°", "${angle3 - 15}°", "90°")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "ත්‍රිකෝණයක කෝණ දෙකක් $angle1° සහ $angle2° වේ නම්, එහි තුන්වන කෝණයේ අගය කුමක්ද?",
          options = optList,
          correctOption = correct,
          explanation = "ඕනෑම ත්‍රිකෝණයක අභ්‍යන්තර කෝණ තුනෙහි එකතුව 180° කි. එබැවින් 180° - ($angle1° + $angle2°) = $angle3°.",
          topicName = "කෝණ, සමාන්තර රේඛා හා ත්‍රිකෝණ"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val m = 2 + (id % 3)
        val c = 5
        val correct = ((id + 1) % 4) + 1
        val optList = mutableListOf("අනුක්‍රමණය = $m, අන්තඃඛණ්ඩය = $c", "අනුක්‍රමණය = $c, අන්තඃඛණ්ඩය = $m", "අනුක්‍රමණය = -${m}, අන්තඃඛණ්ඩය = $c", "අනුක්‍රමණය = 1, අන්තඃඛණ්ඩය = 0")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "y = ${m}x + $c සරල රේඛාවේ අනුක්‍රමණය (Gradient) සහ y-අන්තඃඛණ්ඩය (Intercept) පිළිවෙළින් කුමක්ද?",
          options = optList,
          correctOption = correct,
          explanation = "y = mx + c සම්මත සමීකරණය සමග සැසඳූ විට අනුක්‍රමණය m = $m වන අතර අන්තඃඛණ්ඩය c = $c වේ.",
          topicName = "සරල රේඛා ප්‍රස්ථාර"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val d = 3 + (id % 3)
        val a = 2
        val n = 10
        val tn = a + (n - 1) * d
        val correct = (id % 4) + 1
        val optList = mutableListOf("$tn", "${tn + d}", "${tn - d}", "${tn * 2}")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "$a, ${a + d}, ${a + 2 * d}, ... සමාන්තර ශ්‍රේඪියේ $n වන පදය කුමක්ද?",
          options = optList,
          correctOption = correct,
          explanation = "Tn = a + (n-1)d සූත්‍රයෙන්: T$n = $a + ($n - 1) × $d = $a + ${ (n - 1) * d } = $tn වේ.",
          topicName = "සමාන්තර ශ්‍රේඪි"
        )
      }
    }
  )

  private val MathTerm2Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val x = 3 + (id % 3)
        val y = 2 + (paperIdx % 2)
        val sum = x + y
        val diff = x - y
        val correct = ((id + 1) % 4) + 1
        val optList = mutableListOf("x = $x, y = $y", "x = $y, y = $x", "x = ${x + 1}, y = ${y - 1}", "x = 5, y = 1")
        if (correct != 1) {
          val tmp = optList[0]
          optList[0] = optList[correct - 1]
          optList[correct - 1] = tmp
        }
        return MockExamQuestion(
          id = id,
          questionText = "x + y = $sum සහ x - y = $diff සමගාමී සමීකරණ යුගලයේ විසඳුම් කුමක්ද?",
          options = optList,
          correctOption = correct,
          explanation = "සමීකරණ දෙක එකතු කිරීමෙන් 2x = ${sum + diff} => x = $x. x හි අගය ආදේශයෙන් y = $y වේ.",
          topicName = "සමගාමී සමීකරණ"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val theorems = listOf("කේන්ද්‍ර කෝණය පරිධි කෝණය මෙන් දෙගුණයකි", "කේන්ද්‍ර කෝණය හා පරිධි කෝණය සමානය", "පරිධි කෝණය කේන්ද්‍ර කෝණය මෙන් දෙගුණයකි", "එකතුව 180° කි")
        return MockExamQuestion(
          id = id,
          questionText = "වෘත්තයක එකම චාපය මත කේන්ද්‍රයේ ආපාතනය කරන කෝණය හා පරිධිය මත කෝණය අතර සම්බන්ධය කුමක්ද?",
          options = theorems,
          correctOption = 1,
          explanation = "වෘත්ත ජ්‍යාමිතික ප්‍රමේයය: වෘත්තයක චාපයකින් කේන්ද්‍රයෙහි ආපාතනය කරන කෝණය එම චාපයෙන්ම පරිධියේ ඉතිරි කොටස මත කෝණය මෙන් දෙගුණයකි.",
          topicName = "වෘත්ත ජ්‍යාමිතිය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val a = 3
        val b = 4
        val c = 5
        return MockExamQuestion(
          id = id,
          questionText = "සෘජුකෝණී ත්‍රිකෝණයක ලම්භ පාදවල දිග $a cm සහ $b cm නම්, එහි කර්ණයේ (Hypotenuse) දිග කොපමණද?",
          options = listOf("$c cm", "7 cm", "12 cm", "25 cm"),
          correctOption = 1,
          explanation = "පයිතගරස් ප්‍රමේයයට අනුව c² = a² + b² = 3² + 4² = 9 + 16 = 25 => c = 5 cm.",
          topicName = "පයිතගරස් ප්‍රමේයය"
        )
      }
    }
  )

  private val MathTerm3Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val angles = listOf("sin 30° = 1/2", "cos 60° = 1/2", "tan 45° = 1", "sin 90° = 0")
        return MockExamQuestion(
          id = id,
          questionText = "පහත දැක්වෙන ත්‍රිකෝණමිතික අනුපාත අතුරින් අසත්‍ය ප්‍රකාශය කුමක්ද?",
          options = angles,
          correctOption = 4,
          explanation = "sin 90° හි නිවැරදි අගය 1 වන අතර 0 නොවේ. sin 0° = 0 වේ.",
          topicName = "ත්‍රිකෝණමිතිය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val outcomes = listOf("1/2", "1/6", "1/3", "2/3")
        return MockExamQuestion(
          id = id,
          questionText = "සාධාරණ දාදු කැටයක් එක්වරක් උඩ දැමූ විට ඉරට්ටේ සංඛ්‍යාවක් ලැබීමේ සම්භාවිතාව කුමක්ද?",
          options = outcomes,
          correctOption = 1,
          explanation = "සාම්පල අවකාශය S = {1, 2, 3, 4, 5, 6} (6යි). ඉරට්ටේ සංඛ්‍යා = {2, 4, 6} (3යි). සම්භාවිතාව = 3/6 = 1/2.",
          topicName = "සම්භාවිතාව"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val formulas = listOf("V = π r² h", "V = 2 π r h", "V = 4/3 π r³", "V = 1/3 π r² h")
        return MockExamQuestion(
          id = id,
          questionText = "අරය r සහ උස h වූ සෘජු වෘත්තාකාර සිලින්ඩරයක පරිමාව සෙවීමේ නිවැරදි සූත්‍රය කුමක්ද?",
          options = formulas,
          correctOption = 1,
          explanation = "සිලින්ඩරයක පරිමාව = හරස්කඩ වර්ගඵලය × උස = πr²h වේ.",
          topicName = "ඝන වස්තු වර්ගඵලය සහ පරිමාව"
        )
      }
    }
  )

  // HISTORY TERM 1, 2, 3
  private val HistoryTerm1Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val kings = listOf("පණ්ඩුකාභය රජු", "විජය රජු", "දේවානම්පියතිස්ස රජු", "මුටසීව රජු")
        return MockExamQuestion(
          id = id,
          questionText = "අනුරාධපුර නගරය සැලසුම්සහගතව මුලින්ම ගොඩනංවා අගනුවර කරගත් ශ්‍රී ලංකාවේ ප්‍රථම ඓතිහාසික රජු කවුරුන්ද?",
          options = kings,
          correctOption = 1,
          explanation = "මහාවංශයට අනුව දස වසරක සටනකින් පසු අනුරාධපුරය නිසි නගර සැලැස්මකට අනුව ගොඩනැගුවේ පණ්ඩුකාභය රජුය.",
          topicName = "අනුරාධපුර මුල් යුගය හා නාගරීකරණය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val events = listOf("දේවානම්පියතිස්ස රජ සමයේදී මිහිඳු මහ රහතන් වහන්සේ වැඩමවීම", "දුටුගැමුණු රජ සමයේදී", "වළගම්බා රජ සමයේදී", "මහසෙන් රජ සමයේදී")
        return MockExamQuestion(
          id = id,
          questionText = "ශ්‍රී ලංකාවට බුදුදහම හඳුන්වා දෙනු ලැබුවේ කුමන ඓතිහාසික සිදුවීමේදීද?",
          options = events,
          correctOption = 1,
          explanation = "ක්‍රි.පූ. 3 වන සියවසේ පොසොන් පුන් පොහෝ දින අශෝක අධිරාජ්‍යයාගේ අනුග්‍රහයෙන් මිහිඳු හිමියන් මිහින්තලයට වැඩම කළහ.",
          topicName = "මහින්දාගමනය හා සමාජ සංස්කෘතික පරිවර්තනය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val stupas = listOf("රුවන්වැලි මහා සෑය සහ මිරිසවැටිය", "අභයගිරිය", "ජේතවනාරාමය", "ථූපාරාමය")
        return MockExamQuestion(
          id = id,
          questionText = "දුටුගැමුණු රජතුමා විසින් අනුරාධපුරයේ ඉදිකරවන ලද අසමසම මහා සෑය කුමක්ද?",
          options = stupas,
          correctOption = 1,
          explanation = "දුටුගැමුණු රජතුමා රට එක්සේසත් කිරීමෙන් අනතුරුව මහා සෑය (රුවන්වැලි සෑය) සහ මිරිසවැටිය දාගැබ ඉදිකළේය.",
          topicName = "දුටුගැමුණු රජතුමා සහ දේශපාලන එක්සේසත් කිරීම"
        )
      }
    }
  )

  private val HistoryTerm2Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val kings = listOf("මහා පරාක්‍රමබාහු රජු", "විජයබාහු I රජු", "නිශ්ශංකමල්ල රජු", "මහාසෙන් රජු")
        return MockExamQuestion(
          id = id,
          questionText = "අහසින් වැටෙන එකදු දිය බිඳකුදු මිනිසාගේ ප්‍රයෝජනයට නොගෙන මුහුදට ගලා යාමට නොදිය යුතුය යන උදාර ප්‍රකාශය කළේ කවුරුන්ද?",
          options = kings,
          correctOption = 1,
          explanation = "පොළොන්නරු යුගයේ මහා පරාක්‍රමබාහු රජතුමා පරාක්‍රම සමුද්‍රය ඇතුළු දැවැන්ත වාරි කර්මාන්ත කරවමින් මෙම ප්‍රකාශය කළේය.",
          topicName = "මහා පරාක්‍රමබාහු රජු"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val years = listOf("1505 වසරේදී ලොරෙන්සෝ ද අල්මේදා", "1658 වසරේදී ජෙරාඩ් හුෆ්ට්", "1796 වසරේදී", "1815 වසරේදී")
        return MockExamQuestion(
          id = id,
          questionText = "ශ්‍රී ලංකාවට මුලින්ම පැමිණි යුරෝපීය ජාතිය වූ පෘතුගීසීන් ගාලු වරායට ගොඩබැස්සේ කුමන වසරේද?",
          options = years,
          correctOption = 1,
          explanation = "1505 දී කුණාටුවකට හසුවූ ලොරෙන්සෝ ද අල්මේදා ප්‍රමුඛ පෘතුගීසි නැව ගාලු වරායට සේන්දු විය.",
          topicName = "පෘතුගීසි ආගමනය හා ලංකාව"
        )
      }
    }
  )

  private val HistoryTerm3Templates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val heroes = listOf("මොණරවිල කැප්පෙටිපොළ දිසාව", "පුරන් අප්පු", "ගොන්ගාලේගොඩ බණ්ඩා", "ඇහැලේපොළ නිලමේ")
        return MockExamQuestion(
          id = id,
          questionText = "1818 වෙල්ලස්ස නිදහස් අරගලයේදී බ්‍රිතාන්‍යයන්ට එරෙහිව කැරැල්ලට නායකත්වය දුන් ශ්‍රේෂ්ඨ ජාතික වීරවරයා කවුරුන්ද?",
          options = heroes,
          correctOption = 1,
          explanation = "බ්‍රිතාන්‍යයන් විසින් කැරැල්ල මැඩපැවැත්වීමට යැවූ මොණරවිල කැප්පෙටිපොළ දිසාව ස්වදේශිකයන් හා එක්ව සටනට නායකත්වය දුන්නේය.",
          topicName = "1818 වෙල්ලස්ස නිදහස් අරගලය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val leaders = listOf("ඩී.එස්. සේනානායක මැතිතුමා", "එස්.ඩබ්.ආර්.ඩී. බණ්ඩාරනායක මැතිතුමා", "ඩඩ්ලි සේනානායක මැතිතුමා", "සර් ජෝන් කොතලාවල මැතිතුමා")
        return MockExamQuestion(
          id = id,
          questionText = "1948 පෙබරවාරි 04 වන දින නිදහස් ශ්‍රී ලංකාවේ ප්‍රථම අග්‍රාමාත්‍යවරයා ලෙස පත්වූයේ කවුරුන්ද?",
          options = leaders,
          correctOption = 1,
          explanation = "ජාතියේ පියා ලෙස සැලකෙන මාන්‍ය ඩී.එස්. සේනානායක මහතා නිදහස් ලංකාවේ පළමු අගමැතිවරයා විය.",
          topicName = "සෝල්බරි ආණ්ඩුක්‍රමය සහ 1948 නිදහස"
        )
      }
    }
  )

  // GENERAL TEMPLATES (Sinhala, English, Buddhism)
  private val SinhalaTemplates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val words = listOf("ස්වර 18ක් සහ ව්‍යංජන 42ක් (මිශ්‍ර සිංහල හෝඩිය)", "ස්වර 12ක් පමණි", "ව්‍යංජන 30ක් පමණි", "අක්ෂර 32ක් පමණි")
        return MockExamQuestion(
          id = id,
          questionText = "නූතන සම්මත සිංහල හෝඩියේ අක්ෂර වින්‍යාසය පිළිබඳ නිවැරදි ප්‍රකාශය කුමක්ද?",
          options = words,
          correctOption = 1,
          explanation = "ජාතික අධ්‍යාපන ආයතන සම්මත මිශ්‍ර සිංහල හෝඩියේ ස්වර 18ක් හා ව්‍යංජන 42ක් ලෙස අක්ෂර 60ක් අන්තර්ගත වේ.",
          topicName = "අක්ෂර මාලාව හා වියරණ"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val figures = listOf("උපමා අලංකාරය", "රූපක අලංකාරය", "ශ්ලේෂ අලංකාරය", "ස්වභාවෝක්ති අලංකාරය")
        return MockExamQuestion(
          id = id,
          questionText = "යම් වස්තුවක් තවත් වස්තුවකට සමාන කරමින් 'මෙන්, සේ, බඳු' වැනි නිපාත යොදා දක්වන කාව්‍යාලංකාරය කුමක්ද?",
          options = figures,
          correctOption = 1,
          explanation = "උපමේය හා උපමානය අතර සමානතාව දැක්වීමට උපමා වාචී නිපාත පද යොදා ගැනීම උපමා අලංකාරයයි.",
          topicName = "කාව්‍ය රසවින්දනය හා අලංකාර"
        )
      }
    }
  )

  private val EnglishTemplates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val opts = listOf("has been studying", "studied", "was studying", "studies")
        return MockExamQuestion(
          id = id,
          questionText = "Select the correct verb form: 'She ______ English since morning and hasn't finished yet.'",
          options = opts,
          correctOption = 1,
          explanation = "Actions that started in the past and continue into the present require the Present Perfect Continuous tense ('has been studying').",
          topicName = "Tenses & Grammar"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val opts = listOf("would pass", "will pass", "passed", "passes")
        return MockExamQuestion(
          id = id,
          questionText = "Complete the conditional sentence: 'If you studied harder, you ______ the examination.'",
          options = opts,
          correctOption = 1,
          explanation = "Second conditional structure: If + Past Simple (studied), ... would + base verb (would pass).",
          topicName = "Conditional Sentences"
        )
      }
    }
  )

  private val BuddhismTemplates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val truths = listOf("දුක්ඛ, සමුදය, නිරෝධ, මාර්ග සත්‍යය", "සීල, සමාධි, ප්‍රඥා", "අනිත්‍ය, දුක්ඛ, අනත්ත", "ලෝභ, දෝස, මෝහ")
        return MockExamQuestion(
          id = id,
          questionText = "බුදුරජාණන් වහන්සේ ප්‍රථම ධර්ම දේශනාව වන දම්සක් පැවතුම් සූත්‍රයේදී දේශනා කළ මූලික ධර්ම සත්‍ය සතර කුමක්ද?",
          options = truths,
          correctOption = 1,
          explanation = "චතුරාර්ය සත්‍යය යනු බුදුදහමේ හරය වන දුක්ඛ සත්‍යය, සමුදය සත්‍යය, නිරෝධ සත්‍යය හා මාර්ග සත්‍යයයි.",
          topicName = "මූලික ධර්ම කරුණු"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val Councils = listOf("පළමුවන ධර්ම සංගායනාව (රජගහනුවර සප්තපර්ණී ගුහාව)", "දෙවන සංගායනාව", "තුන්වන සංගායනාව", "හතරවන සංගායනාව (මාතලේ අලුවිහාරය)")
        return MockExamQuestion(
          id = id,
          questionText = "බුදුරජාණන් වහන්සේ පිරිනිවන් පෑමෙන් තෙමසකට පසු මහා කාශ්‍යප මහ රහතන් වහන්සේගේ ප්‍රධානත්වයෙන් පැවැත්වූ ධර්ම සංගායනාව කුමක්ද?",
          options = Councils,
          correctOption = 1,
          explanation = "අජාසත් රජුගේ දායකත්වයෙන් රජගහනුවර සප්තපර්ණී ලෙන් ද්වාරයේදී ප්‍රථම ධර්ම සංගායනාව පවත්වන ලදී.",
          topicName = "ශාසන ඉතිහාසය හා සංගායනා"
        )
      }
    }
  )
  private val GeographyTemplates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val locations = listOf("දෙවුන්දර තුඩුව", "පේදුරු තුඩුව", "සංගමන්කන්ද තුඩුව", "තලෙයිමන්නාරම")
        val correct = (id % 4) + 1
        return MockExamQuestion(
          id = id,
          questionText = "ශ්‍රී ලංකාවේ පිහිටීම අනුව ${if(correct==1) "දකුණු" else if(correct==2) "උතුරු" else if(correct==3) "නැගෙනහිර" else "බටහිර"} අන්තයටම වන්නට පිහිටි ස්ථානය කුමක්ද?",
          options = locations,
          correctOption = correct,
          explanation = "ශ්‍රී ලංකාවේ උතුරින් පේදුරු තුඩුවද, දකුණින් දෙවුන්දර තුඩුවද, නැගෙනහිරින් සංගමන්කන්දද, බටහිරින් තලෙයිමන්නාරමද පිහිටා ඇත.",
          topicName = "ශ්‍රී ලංකාවේ පිහිටීම"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val types = listOf("නිරිතදිග මෝසම් සුළං", "ඊසානදිග මෝසම් සුළං", "සංවහන වැසි", "සුළි සුළං")
        val correct = (paperIdx % 2) + 1
        return MockExamQuestion(
          id = id,
          questionText = "ශ්‍රී ලංකාවේ මැයි සිට සැප්තැම්බර් දක්වා කාලය තුළ වැසි ඇති කිරීමට බලපාන ප්‍රධාන වායු ධාරාව කුමක්ද?",
          options = types,
          correctOption = 1,
          explanation = "මැයි සිට සැප්තැම්බර් දක්වා නිරිතදිග මෝසම් සුළං මගින් ලංකාවේ නිරිතදිග ප්‍රදේශවලට තද වැසි ලැබෙයි.",
          topicName = "කාලගුණය හා දේශගුණය"
        )
      }
    }
  )

  private val CivicsTemplates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val principles = listOf("ව්‍යවස්ථාදායකය, විධායකය, අධිකරණය", "මහජන පරමාධිපත්‍යය", "බහුවිධ පාලන ක්‍රමය", "ඒකීය රජයක්")
        return MockExamQuestion(
          id = id,
          questionText = "ප්‍රජාතන්ත්‍රවාදී පාලන ක්‍රමයක පවතින ප්‍රධාන ආයතනික ව්‍යුහයන් තුන වන්නේ,",
          options = principles,
          correctOption = 1,
          explanation = "ඕනෑම ප්‍රජාතන්ත්‍රවාදී රජයක බලය ව්‍යවස්ථාදායකය (නීති සෑදීම), විධායකය (නීති ක්‍රියාත්මක කිරීම) හා අධිකරණය (නීතිය අර්ථකථනය) ලෙස බෙදී පවතී.",
          topicName = "ප්‍රජාතන්ත්‍රවාදය හා පාලන ව්‍යුහය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val rights = listOf("මානව හිමිකම් පිළිබඳ විශ්ව ප්‍රකාශනය (UDHR)", "ළමා හිමිකම් ප්‍රකාශනය", "සිවිල් අයිතිවාසිකම් පනත", "ජාත්‍යන්තර කම්කරු නීතිය")
        return MockExamQuestion(
          id = id,
          questionText = "1948 දෙසැම්බර් 10 වන දින එක්සත් ජාතීන්ගේ සංවිධානය මගින් පිළිගත් වැදගත් ලේඛනය කුමක්ද?",
          options = rights,
          correctOption = 1,
          explanation = "1948 දී පිළිගත් මානව හිමිකම් පිළිබඳ විශ්ව ප්‍රකාශනය මගින් ලොව වෙසෙන සියලු මනුෂ්‍යයන්ගේ මූලික අයිතිවාසිකම් සහතික කර ඇත.",
          topicName = "මානව හිමිකම්"
        )
      }
    }
  )

  private val IctTemplates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val base2 = listOf("0, 1", "0, 1, 2", "1, 2", "0, 1, 2, 3, 4, 5, 6, 7")
        return MockExamQuestion(
          id = id,
          questionText = "පරිගණක පද්ධති තුළ දත්ත නිරූපණය සඳහා භාවිත කරන ද්විමය (Binary) සංඛ්‍යා පද්ධතියේ පදනම හා සංකේත වන්නේ,",
          options = base2,
          correctOption = 1,
          explanation = "ද්විමය සංඛ්‍යා පද්ධතියේ පදනම 2 වන අතර එහි අගයන් නිරූපණයට 0 සහ 1 යන සංකේත දෙක පමණක් භාවිතා වේ.",
          topicName = "සංඛ්‍යා පද්ධති"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val os = listOf("Operating System (මෙහෙයුම් පද්ධතිය)", "Application Software", "Utilities", "Language Translators")
        return MockExamQuestion(
          id = id,
          questionText = "පරිගණකයේ දෘඩාංග හා පරිශීලකයා අතර අතුරුමුහුණතක් ලෙස ක්‍රියා කරමින් පරිගණක සම්පත් කළමනාකරණය කරනු ලබන මෘදුකාංගය කුමක්ද?",
          options = os,
          correctOption = 1,
          explanation = "පරිගණකයේ සියලුම දෘඩාංග පාලනය කරමින් වෙනත් මෘදුකාංග සඳහා වේදිකාවක් සපයනු ලබන්නේ මෙහෙයුම් පද්ධතිය (OS) මගිනි.",
          topicName = "මෙහෙයුම් පද්ධති"
        )
      }
    }
  )

  private val BusinessTemplates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val equation = listOf("වත්කම් = හිමිකම + වගකීම් (A = O + L)", "වත්කම් = හිමිකම - වගකීම්", "වගකීම් = වත්කම් + හිමිකම", "හිමිකම = වත්කම් + වගකීම්")
        return MockExamQuestion(
          id = id,
          questionText = "ගිණුම්කරණයේ මූලික ගිණුම්කරණ සමීකරණය නිවැරදිව දැක්වෙනුයේ,",
          options = equation,
          correctOption = 1,
          explanation = "ව්‍යාපාරයක පවතින මුළු වත්කම් (Assets), සැමවිටම එහි හිමිකම (Owner's Equity) සහ බාහිර වගකීම් (Liabilities) වල එකතුවට සමාන වේ.",
          topicName = "ගිණුම්කරණ සමීකරණය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val types = listOf("ඒක පුද්ගල ව්‍යාපාර", "හවුල් ව්‍යාපාර", "සංයුක්ත මණ්ඩල", "සීමිත පොදු සමාගම්")
        return MockExamQuestion(
          id = id,
          questionText = "ව්‍යාපාර ලියාපදිංචි කිරීමේදී හිමිකරු සහ ව්‍යාපාරය නීතිය ඉදිරියේ එකම පුද්ගලයෙකු ලෙස සලකනු ලබන සරලම ව්‍යාපාර සංවිධාන ක්‍රමය කුමක්ද?",
          options = types,
          correctOption = 1,
          explanation = "ඒක පුද්ගල ව්‍යාපාර වල හිමිකරු සහ ව්‍යාපාරය අතර වෙනම නෛතික පුද්ගලභාවයක් නොමැති අතර වගකීම අසීමිත වේ.",
          topicName = "ව්‍යාපාර සංවිධාන"
        )
      }
    }
  )

  private val HealthTemplates = listOf(
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val nutrients = listOf("කාබෝහයිඩ්‍රේට හා මේදය", "ප්‍රෝටීන", "විටමින්", "ඛනිජ ලවණ")
        return MockExamQuestion(
          id = id,
          questionText = "ශරීරයට ශක්තිය ලබා දෙන ප්‍රධාන පෝෂක කාණ්ඩය වන්නේ,",
          options = nutrients,
          correctOption = 1,
          explanation = "කාබෝහයිඩ්‍රේට ප්‍රධාන ශක්ති ප්‍රභවය වන අතර ලිපිඩ (මේදය) සංචිත ශක්තිය ලෙස ක්‍රියා කරයි.",
          topicName = "පෝෂණය"
        )
      }
    },
    object : ExamQuestionTemplate {
      override fun buildQuestion(id: Int, grade: String, paperIdx: Int, questionOrder: Int): MockExamQuestion {
        val bmi = listOf("ශරීර ස්කන්ධ දර්ශකය (BMI)", "වර්ධන වේගය", "රුධිර පීඩනය", "හෘද ස්පන්දන වේගය")
        return MockExamQuestion(
          id = id,
          questionText = "පුද්ගලයෙකුගේ උසට සාපේක්ෂව බර පරීක්ෂා කර පෝෂණ මට්ටම තීරණය කිරීමට භාවිතා කරන මිනුම කුමක්ද?",
          options = bmi,
          correctOption = 1,
          explanation = "BMI (Body Mass Index) ගණනය කරනුයේ ස්කන්ධය (kg) උසෙහි (m) වර්ගයෙන් බෙදීමෙනි.",
          topicName = "වර්ධනය හා සංවර්ධනය"
        )
      }
    }
  )
}
