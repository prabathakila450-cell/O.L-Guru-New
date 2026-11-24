package com.example

/**
 * MockExamDataBank provides syllabus-aligned, 60-question examination papers
 * for Sri Lankan grades (Grade 6-11 / O/L), structured separately across all 3 terms:
 * - 1 වන වාරය (Term 1)
 * - 2 වන වාරය (Term 2)
 * - 3 වන වාරය (Term 3)
 *
 * Each term features 30 distinct, 60-question mock exam papers per subject,
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
    "සංගීතය",
    "නර්තනය",
    "චිත්‍ර කලාව"
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
        2 -> "ලෝකයේ හා ශ්‍රී ලංකාවේ ජනගහනය, ස්වාභාවික සම්පත් කළමනාකරණය, කෘෂිකර්මාන්තය හා ධීවර කර්මාන්තය"
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
      "චිත්‍ර කලාව" -> when (term) {
        1 -> "ප්‍රාග් ඓතිහාසික කලාව, අනුරාධපුර සිතුවම් හා සීගිරිය, අනුරාධපුර ශිලා මූර්ති හා කැටයම්, චිත්‍ර කලා මූලිකාංග හා වර්ණ න්‍යාය"
        2 -> "පොළොන්නරු හා මහනුවර යුගයේ චිත්‍ර-මූර්ති, දේශීය සාම්ප්‍රදායික මෝස්තර හා හස්ත කර්මාන්ත, පෙරදිග ආසියාතික හා බටහිර සම්භාව්‍ය කලාව"
        else -> "නූතන බටහිර කලාව හා ශ්‍රී ලංකාවේ '43 කණ්ඩායම, රේඛීය දෘෂ්ටිකෝණ, මානව ව්‍යුහය, ප්‍රායෝගික මාධ්‍ය හා කලා විචාරය"
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
}
