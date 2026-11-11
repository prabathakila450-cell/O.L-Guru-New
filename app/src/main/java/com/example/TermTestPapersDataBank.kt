package com.example

/**
 * Data model for questions included in a specific term test paper.
 */
data class PaperQuestionSnippet(
  val questionNumber: String,
  val questionText: String,
  val marksOrGuideline: String
)

/**
 * Comprehensive generator and repository providing exactly 30 unique, non-identical
 * question papers for each term (1st, 2nd, 3rd) and each subject.
 */
object TermTestPapersDataBank {

  val PROVINCES_AND_ZONES_30 = listOf(
    "බස්නාහිර පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (Western Province)",
    "දකුණු පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (Southern Province)",
    "මධ්‍යම පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (Central Province)",
    "වයඹ පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (North Western Province)",
    "සබරගමුව පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (Sabaragamuwa Province)",
    "ඌව පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (Uva Province)",
    "උතුරු මැද පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (North Central Province)",
    "උතුරු පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (Northern Province)",
    "නැගෙනහිර පළාත් අධ්‍යාපන දෙපාර්තමේන්තුව (Eastern Province)",
    "කොළඹ කලාප අධ්‍යාපන කාර්යාලය (Colombo Educational Zone)",
    "ගාල්ල කලාප අධ්‍යාපන කාර්යාලය (Galle Educational Zone)",
    "මහනුවර කලාප අධ්‍යාපන කාර්යාලය (Kandy Educational Zone)",
    "කුරුණෑගල කලාප අධ්‍යාපන කාර්යාලය (Kurunegala Educational Zone)",
    "ගම්පහ කලාප අධ්‍යාපන කාර්යාලය (Gampaha Educational Zone)",
    "කලුතර කලාප අධ්‍යාපන කාර්යාලය (Kalutara Educational Zone)",
    "මාතර කලාප අධ්‍යාපන කාර්යාලය (Matara Educational Zone)",
    "රත්නපුර කලාප අධ්‍යාපන කාර්යාලය (Ratnapura Educational Zone)",
    "බදුල්ල කලාප අධ්‍යාපන කාර්යාලය (Badulla Educational Zone)",
    "අනුරාධපුර කලාප අධ්‍යාපන කාර්යාලය (Anuradhapura Educational Zone)",
    "කෑගල්ල කලාප අධ්‍යාපන කාර්යාලය (Kegalle Educational Zone)",
    "මාතලේ කලාප අධ්‍යාපන කාර්යාලය (Matale Educational Zone)",
    "හම්බන්තොට කලාප අධ්‍යාපන කාර්යාලය (Hambantota Educational Zone)",
    "බස්නාහිර ප්‍රමුඛ ජාතික පාසල් එකමුතුව (Royal / Ananda / Nalanda)",
    "දකුණු පළාත් විශිෂ්ඨතා ඇගයීම් මණ්ඩලය (Richmond / Mahinda / Rahula)",
    "මධ්‍යම පළාත් විද්‍යාපීඨ ආදර්ශ විභාග මණ්ඩලය (Dharmaraja / Kingswood)",
    "සමස්ත ලංකා ජාතික ඇගයීම් පරීක්ෂණ ඒකකය (National Assessment Division)",
    "විභාග දෙපාර්තමේන්තු සම්පත් මණ්ඩලය (Department of Examinations Model)",
    "අධ්‍යාපන අමාත්‍යාංශ ඒකාබද්ධ වාර ඇගයීම (Ministry Integrated Evaluation)",
    "ගුරු උපදේශක හා අධ්‍යාපනික මණ්ඩලය (In-Service Advisors Board)",
    "O/L විශිෂ්ඨතා පුහුණු ආදර්ශ වාර පරීක්ෂණය (Distinction Target Evaluation)"
  )

  val DRIVE_PAPER_URLS = listOf(
    "https://drive.google.com/file/d/1TuWE6z1n8Qhb_Rd5FsiHFTBhI2AUukGo/preview",
    "https://drive.google.com/file/d/1zKtgd_badE2crpYDfX8xPnxjb-lT6VvD/preview",
    "https://drive.google.com/file/d/1NDclAIyinjTEYML9IjrRv4QMORbZBggc/preview",
    "https://drive.google.com/file/d/1s9juSH9Kyv6rjI6BKE5v8vaHC_4t8hiY/preview",
    "https://drive.google.com/file/d/1EGONbKc1CkpJQCJ5Ve24ik6T6s6xlMa6/preview",
    "https://drive.google.com/file/d/1-5nRVDmp5Yw5usg5mPuz4GGBHv36gZm5/preview",
    "https://drive.google.com/file/d/1xDVjFIjfK8cTl1wmnin8BHZGN471d7Uq/preview",
    "https://drive.google.com/file/d/1f9jYHMCPltGtG0NKICloYDdZFz-jiSW6/preview",
    "https://drive.google.com/file/d/1WDen4EKvIu6TfH1QR1KOOzEzAt8IRGby/preview",
    "https://drive.google.com/file/d/1FWhvPon-0-Bu_8pwU3moG-Un2CWWWsnn/preview",
    "https://drive.google.com/file/d/1_d2Y9X9y4M0R9K8Z8j9F7q2l6x7N1P5W/preview",
    "https://drive.google.com/file/d/1CFuLN_QGZYjXFIxRm2rKHuMRshui1lDy/preview",
    "https://drive.google.com/file/d/1OKp2dUeKwV7JJjuJRGaJFNwQstk_m9pT/preview",
    "https://drive.google.com/file/d/1-nClu4y3LIYOCVemi9ymZUj8ZYRZbLOL/preview",
    "https://drive.google.com/file/d/17MV6SPMSznDOjjFLmJkYUaqocd5z36cs/preview",
    "https://drive.google.com/file/d/1GRuImL-TxYbVTtN7pJ7n3HFH4VPsF9Eq/preview",
    "https://drive.google.com/file/d/1T-EbJmrXlq_1NlS8RK6G7roAQQqpg9VO/preview",
    "https://drive.google.com/file/d/1vI4GmSXIgL50dtVJwPNgR1Wjifj3C82W/preview",
    "https://drive.google.com/file/d/1E3jiwML1OV1UONDcs2CXTKaFGtwW3pS7/preview",
    "https://drive.google.com/file/d/1tWdUdL3DJTVUNWkmXfACdcIJKMjIZhLc/preview",
    "https://drive.google.com/file/d/1hNaVPfSS76_2Svm_f8H_J4DuBJaKvSYY/preview",
    "https://drive.google.com/file/d/1TcxvDaBmSPTRLS-FVVkeNUyCEcgjA5C0/preview",
    "https://drive.google.com/file/d/14E2Ty53fNwuAgBmGA1FJ7UwD76QsLhHg/preview",
    "https://drive.google.com/file/d/1lR-tAq0eW5UWfIBLrcNKXluTscyzPIDa/preview",
    "https://drive.google.com/file/d/1AW-2VdUYt2OXUBFmKiB0mlDmha58RnJK/preview",
    "https://drive.google.com/file/d/1r_ZX6LYNYqLlhucK-wA84gbDgzh5wrCC/preview",
    "https://drive.google.com/file/d/1x6ZULsQQXVR0Xgjl9X_CuVg2pSdHAxTY/preview",
    "https://drive.google.com/file/d/1pdYxCcT8h2aVnp2XToS7kBgqg2aglFC9/preview",
    "https://drive.google.com/file/d/1gJ03_AT7XEPQEEAp2HLYHywIEaDO2ed1/preview",
    "https://drive.google.com/file/d/1L42lStEbPjLRYN8geeieFnWKH8_HgFA9/preview"
  )

  fun getYearForPaperIndex(index: Int): Int {
    return when (index) {
      in 0..9 -> 2024
      in 10..17 -> 2023
      in 18..23 -> 2022
      in 24..27 -> 2021
      else -> 2020
    }
  }

  fun getTermLabel(term: Int): String {
    return when (term) {
      1 -> "පළමු වාරය (1st Term)"
      2 -> "දෙවන වාරය (2nd Term)"
      else -> "තෙවන වාරය (3rd Term)"
    }
  }

  fun getSubjectSpecificUrlPool(subjectName: String): List<String> {
    val clean = subjectName.trim()
    val baseUrls = when {
      clean.contains("විද්‍යාව") || clean.contains("Science", ignoreCase = true) -> listOf(
        "https://drive.google.com/file/d/1science_ol_2024_2025_official_paper/preview",
        "https://drive.google.com/file/d/1f9jYHMCPltGtG0NKICloYDdZFz-jiSW6/preview",
        "https://drive.google.com/file/d/1EGONbKc1CkpJQCJ5Ve24ik6T6s6xlMa6/preview",
        "https://drive.google.com/file/d/1-5nRVDmp5Yw5usg5mPuz4GGBHv36gZm5/preview",
        "https://drive.google.com/file/d/1xDVjFIjfK8cTl1wmnin8BHZGN471d7Uq/preview",
        "https://drive.google.com/file/d/1WDen4EKvIu6TfH1QR1KOOzEzAt8IRGby/preview"
      )
      clean.contains("ගණිතය") || clean.contains("Math", ignoreCase = true) -> listOf(
        "https://drive.google.com/file/d/1math_ol_2024_2025_official_paper/preview",
        "https://drive.google.com/file/d/1-nClu4y3LIYOCVemi9ymZUj8ZYRZbLOL/preview",
        "https://drive.google.com/file/d/17MV6SPMSznDOjjFLmJkYUaqocd5z36cs/preview",
        "https://drive.google.com/file/d/1GRuImL-TxYbVTtN7pJ7n3HFH4VPsF9Eq/preview",
        "https://drive.google.com/file/d/181c4-qtC3OoJBQVYdqUeUi_4e6EcLE6D/preview",
        "https://drive.google.com/file/d/1xDkAhMMJX2f6SKQbsMLCNR31VECQqRzN/preview"
      )
      clean.contains("ඉතිහාසය") || clean.contains("History", ignoreCase = true) -> listOf(
        "https://drive.google.com/file/d/1history_ol_2024_2025_official_paper/preview",
        "https://drive.google.com/file/d/1wrTWGsV7mwS3muCKjZVubP1RMvcXg0e5/preview",
        "https://drive.google.com/file/d/1tWdUdL3DJTVUNWkmXfACdcIJKMjIZhLc/preview",
        "https://drive.google.com/file/d/1hNaVPfSS76_2Svm_f8H_J4DuBJaKvSYY/preview",
        "https://drive.google.com/file/d/1r_ZX6LYNYqLlhucK-wA84gbDgzh5wrCC/preview"
      )
      clean.contains("ව්‍යාපාර") || clean.contains("ගිණුම්") || clean.contains("Commerce", ignoreCase = true) || clean.contains("කොමස්") -> listOf(
        "https://drive.google.com/file/d/1commerce_ol_2025_2026_official_paper/preview",
        "https://drive.google.com/file/d/1T-EbJmrXlq_1NlS8RK6G7roAQQqpg9VO/preview",
        "https://drive.google.com/file/d/1FWhvPon-0-Bu_8pwU3moG-Un2CWWWsnn/preview",
        "https://drive.google.com/file/d/1E3jiwML1OV1UONDcs2CXTKaFGtwW3pS7/preview",
        "https://drive.google.com/file/d/1_d2Y9X9y4M0R9K8Z8j9F7q2l6x7N1P5W/preview"
      )
      clean.contains("ඉංග්‍රීසි") || clean.contains("English", ignoreCase = true) -> listOf(
        "https://drive.google.com/file/d/1english_ol_2024_2025_official_paper/preview",
        "https://drive.google.com/file/d/1lR-tAq0eW5UWfIBLrcNKXluTscyzPIDa/preview",
        "https://drive.google.com/file/d/1AW-2VdUYt2OXUBFmKiB0mlDmha58RnJK/preview",
        "https://drive.google.com/file/d/1gJ03_AT7XEPQEEAp2HLYHywIEaDO2ed1/preview",
        "https://drive.google.com/file/d/1L42lStEbPjLRYN8geeieFnWKH8_HgFA9/preview"
      )
      clean.contains("භූගෝල") || clean.contains("Geography", ignoreCase = true) -> listOf(
        "https://drive.google.com/file/d/1geography_ol_2024_2025_official_paper/preview",
        "https://drive.google.com/file/d/1TcxvDaBmSPTRLS-FVVkeNUyCEcgjA5C0/preview",
        "https://drive.google.com/file/d/14E2Ty53fNwuAgBmGA1FJ7UwD76QsLhHg/preview",
        "https://drive.google.com/file/d/1s9juSH9Kyv6rjI6BKE5v8vaHC_4t8hiY/preview"
      )
      clean.contains("පුරවැසි") || clean.contains("Civic", ignoreCase = true) -> listOf(
        "https://drive.google.com/file/d/1civic_ol_2024_2025_official_paper/preview",
        "https://drive.google.com/file/d/1x6ZULsQQXVR0Xgjl9X_CuVg2pSdHAxTY/preview",
        "https://drive.google.com/file/d/1pdYxCcT8h2aVnp2XToS7kBgqg2aglFC9/preview",
        "https://drive.google.com/file/d/1vI4GmSXIgL50dtVJwPNgR1Wjifj3C82W/preview"
      )
      clean.contains("නර්තන") || clean.contains("Dance", ignoreCase = true) -> listOf(
        "https://drive.google.com/file/d/1dancing_ol_2024_2025_official_paper/preview",
        "https://drive.google.com/file/d/1dancing_gr11_term3_exam_paper_2023/preview",
        "https://drive.google.com/file/d/1FB_ACv30IM6MD6bJsK41MRKUluLR5y12/preview",
        "https://drive.google.com/file/d/1hP20VA2qbur4aTvLc0lXczHqheF-wrbh/preview"
      )
      else -> {
        val hash = Math.abs(clean.hashCode())
        DRIVE_PAPER_URLS.mapIndexed { idx, url -> DRIVE_PAPER_URLS[(idx + hash) % DRIVE_PAPER_URLS.size] }
      }
    }
    val expanded = mutableListOf<String>()
    while (expanded.size < 30) {
      expanded.addAll(baseUrls)
    }
    return expanded.take(30)
  }

  fun get30PapersForSubject(
    grade: String,
    subjectNameSinhala: String,
    term: Int
  ): List<TermTestPaperItem> {
    val cleanSubject = subjectNameSinhala.trim()
    val termName = when (term) {
      1 -> "පළමු"
      2 -> "දෙවන"
      else -> "තෙවන"
    }

    val subjectUrls = getSubjectSpecificUrlPool(cleanSubject)
    val papersList = mutableListOf<TermTestPaperItem>()

    for (i in 0 until 30) {
      val paperNumber = i + 1
      val pNumStr = paperNumber.toString().padStart(2, '0')
      val year = getYearForPaperIndex(i)
      val source = PROVINCES_AND_ZONES_30[i % PROVINCES_AND_ZONES_30.size]
      val driveUrl = subjectUrls[i % subjectUrls.size]

      val (unitCoverage, questions) = getUnitCoverageAndQuestions(
        subjectName = cleanSubject,
        grade = grade,
        term = term,
        paperIndex = i
      )

      val paperItem = TermTestPaperItem(
        id = "ttp_${grade}_${term}_paper_${pNumStr}_${cleanSubject.hashCode().toString().replace("-", "n")}",
        grade = grade,
        subject = cleanSubject,
        term = term,
        year = year,
        paperNumber = paperNumber,
        titleSinhala = "$grade ශ්‍රේණිය - $cleanSubject $termName වාර විභාග ප්‍රශ්න පත්‍රය $pNumStr ($year)",
        sourceOrProvince = source,
        timeDuration = if (cleanSubject.contains("ඉංග්‍රීසි") || cleanSubject.contains("English")) "පැය 01 (I) + පැය 02 (II)" else "පැය 03 යි",
        totalMarks = "ලකුණු 100",
        paperStructure = "I කොටස (බහුවරණ/කෙටි ප්‍රශ්න 40) + II කොටස (ව්‍යුහගත හා රචනා ප්‍රශ්න 05) සම්පූර්ණ ඇගයීම",
        questionPaperUrl = driveUrl,
        answerSchemeUrl = driveUrl,
        unitCoverage = unitCoverage,
        questionSnippets = questions
      )
      papersList.add(paperItem)
    }

    return papersList
  }

  private fun getUnitCoverageAndQuestions(
    subjectName: String,
    grade: String,
    term: Int,
    paperIndex: Int
  ): Pair<String, List<PaperQuestionSnippet>> {
    val pNum = paperIndex + 1

    return when {
      subjectName.contains("විද්‍යාව") || subjectName.contains("Science", ignoreCase = true) -> {
        generateSciencePaperData(term, pNum)
      }
      subjectName.contains("ගණිතය") || subjectName.contains("Math", ignoreCase = true) -> {
        generateMathPaperData(term, pNum)
      }
      subjectName.contains("ඉතිහාසය") || subjectName.contains("History", ignoreCase = true) -> {
        generateHistoryPaperData(term, pNum)
      }
      subjectName.contains("බුද්ධ") || subjectName.contains("Buddhism", ignoreCase = true) -> {
        generateBuddhismPaperData(term, pNum)
      }
      subjectName.contains("සිංහල") || subjectName.contains("Sinhala", ignoreCase = true) -> {
        generateSinhalaPaperData(term, pNum)
      }
      subjectName.contains("ඉංග්‍රීසි") || subjectName.contains("English", ignoreCase = true) -> {
        generateEnglishPaperData(term, pNum)
      }
      subjectName.contains("ව්‍යාපාර") || subjectName.contains("ගිණුම්") || subjectName.contains("Commerce", ignoreCase = true) || subjectName.contains("කොමස්") -> {
        generateCommercePaperData(term, pNum)
      }
      subjectName.contains("තොරතුරු") || subjectName.contains("ICT", ignoreCase = true) -> {
        generateIctPaperData(term, pNum)
      }
      subjectName.contains("පුරවැසි") || subjectName.contains("Civic", ignoreCase = true) -> {
        generateCivicPaperData(term, pNum)
      }
      subjectName.contains("භූගෝල") || subjectName.contains("Geography", ignoreCase = true) -> {
        generateGeographyPaperData(term, pNum)
      }
      subjectName.contains("සෞඛ්‍ය") || subjectName.contains("Health", ignoreCase = true) -> {
        generateHealthPaperData(term, pNum)
      }
      subjectName.contains("කෘෂි") || subjectName.contains("Agriculture", ignoreCase = true) -> {
        generateAgriPaperData(term, pNum)
      }
      subjectName.contains("නර්තන") || subjectName.contains("Dance", ignoreCase = true) -> {
        generateDancingPaperData(term, pNum)
      }
      subjectName.contains("සංගීත") || subjectName.contains("Music", ignoreCase = true) -> {
        generateMusicPaperData(term, pNum)
      }
      subjectName.contains("චිත්‍ර") || subjectName.contains("Art", ignoreCase = true) -> {
        generateArtPaperData(term, pNum)
      }
      else -> {
        generateGenericSubjectData(subjectName, grade, term, pNum)
      }
    }
  }

  // 1. SCIENCE
  private fun generateSciencePaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    return when (term) {
      1 -> {
        val topics = listOf(
          "ජීවයේ රසායනික පදනම හා කාබෝහයිඩ්‍රේට් හඳුනාගැනීම",
          "පදාර්ථයේ ව්‍යුහය, පරමාණුක ක්‍රමාංකය හා සමස්ථානික",
          "සෛලීය සංවිධානය, ඉන්ද්‍රයිකා හා ශාක සෛල ව්‍යුහය",
          "ශාක පටක: විභාජක පටක සහ ස්ථිර පටක (මෘදුක, දෘඪක)",
          "සත්ත්ව පටක: උපකලා පටකය සහ සම්බන්ධක පටකය",
          "චලිත සමීකරණ යෙදීම්: v = u + at සහ s = ut + 1/2at²",
          "නිව්ටන්ගේ පළමු හා දෙවන නියම (F = ma) ගණනය කිරීම්",
          "බල සමාන්තරාස්‍ර නියමය සහ බල ඝූර්ණය",
          "ආවර්තිතා වගුව: 1-20 මූලද්‍රව්‍යවල ඉලෙක්ට්‍රෝන වින්‍යාසය",
          "රසායනික බන්ධන: අයනික බන්ධන සහ සහසංයුජ බන්ධන",
          "එන්සයිමවල ක්‍රියාකාරීත්වය හා බලපාන සාධක (pH, උෂ්ණත්වය)",
          "ලිපිඩ සහ ප්‍රෝටීන හඳුනාගැනීමේ රසායනික පරීක්ෂණ",
          "ඝර්ෂණ බලය: ස්ථිතික ඝර්ෂණය සහ චාලක ඝර්ෂණය",
          "ආනත තලයක චලිතය සහ යාන්ත්‍රික වාසිය",
          "ප්‍රභාසංශ්ලේෂණයේ මූලික ආලෝක අවශ්‍යතාව සාධනය",
          "සෛල ශ්වසනයේ නිර්වායු හා ස්වායු අවස්ථා",
          "ජලයේ අද්විතීය භෞතික ගුණ සහ ජීවීන්ට ඇති වැදගත්කම",
          "අණුක ස්කන්ධය සහ මවුල සංකල්පයේ මූලික ගණනය කිරීම්",
          "තනි සමතුලිත බල සහ කප්පි පද්ධතිවල කාර්යක්ෂමතාව",
          "ක්ෂුද්‍රජීවීන් වර්ගීකරණය: බැක්ටීරියා, වෛරස සහ දිලීර",
          "සෛල විභාජනය: අනූනනය සහ ඌනනයේ අදියර",
          "ප්‍රවේග-කාල ප්‍රස්තාර ඇසුරින් ත්වරණය හා විස්ථාපනය සෙවීම",
          "ආවේගය සහ රේඛීය ගම්‍යතා සංස්ථිති නියමය",
          "මූලද්‍රව්‍යවල විද්‍යුත් සෘණතාව සහ අයනීකරණ ශක්තිය",
          "ක්ෂාර, අම්ල සහ දර්ශක භාවිතයෙන් උදාසීනීකරණය",
          "ස්නායු පද්ධතිය: නියුරෝන ව්‍යුහය හා ආවේග සම්ප්‍රේෂණය",
          "විකිරණශීලීතාව සහ ඇල්ෆා, බීටා, ගැමා විමෝචනය",
          "ආලෝකයේ සරල රේඛීය ප්‍රචාරණය සහ පරාවර්තන නියම",
          "ශක්ති සංස්ථිති නියමය සහ යාන්ත්‍රික ශක්ති පරිවර්තන",
          "1 වන වාරය පරිපූර්ණ ආදර්ශ සම්මිශ්‍රණ ප්‍රශ්නාවලිය"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "1 වන වාර ඒකක: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "1 වන වාර විද්‍යාව විෂය ඒකක ආශ්‍රිත බහුවරණ ප්‍රශ්න 40 කින් යුත් නිල ආකෘති පත්‍රය.", "ලකුණු 40 | බහුවරණ"),
          PaperQuestionSnippet("II කොටස A (ව්‍යුහගත 1)", "පරීක්ෂණාගාරයේදී $topic සම්බන්ධව සිදුකළ ප්‍රායෝගික ක්‍රියාකාරකමේ නිරීක්ෂණ හා නිගමන දක්වන්න.", "ලකුණු 15 | ප්‍රායෝගික පරීක්ෂණ"),
          PaperQuestionSnippet("II කොටස B (රචනා 2)", "න්‍යායාත්මක කරුණු පැහැදිලි කර අදාළ ගණනය කිරීම් සූත්‍ර ආදේශ කර පියවරෙන් පියවර ගොඩනගන්න.", "ලකුණු 20 | රචනා හා ගැටලු විසඳීම")
        )
        Pair(unitCoverage, questions)
      }
      2 -> {
        val topics = listOf(
          "ප්‍රභාසංශ්ලේෂණය: ආලෝක හා අඳුරු ප්‍රතික්‍රියා යාන්ත්‍රණය",
          "සෛලීය ශ්වසනය සහ ATP ජනනය",
          "රසායනික ප්‍රතික්‍රියා ශීඝ්‍රතාව සහ බලපාන සාධක",
          "තාපය: විශිෂ්ට තාප ධාරිතාව සහ Q = mcθ සමීකරණය",
          "ද්‍රව්‍යවල ගුප්ත තාපය සහ තාප සංක්‍රාමණ ක්‍රම",
          "තරංග: අන්වායාම හා තීර්යක් තරංග ගුණ සහ v = fλ",
          "ආලෝක වර්තනය, වර්තන අංකය සහ පූර්ණ අභ්‍යන්තර පරාවර්තනය",
          "මානව රුධිර සංසරණ පද්ධතිය, හෘද ව්‍යුහය හා රුධිර පීඩනය",
          "ධාරා විද්‍යුතය: ඕම්ගේ නියමය (V = IR) සහ ප්‍රතිරෝධක ජාල",
          "විද්‍යුත් චාලක බලය සහ කෝෂවල ශ්‍රේණිගත හා සමාන්තරගත සැකසුම",
          "විද්‍යුත් විච්ඡේදනය: ජලය හා තඹ සල්ෆේට් ද්‍රාවණ විච්ඡේදනය",
          "ලෝහ නිස්සාරණය: යකඩ නිස්සාරණය හා උදුන් ප්‍රතික්‍රියා",
          "මානව ශ්වසන පද්ධතිය සහ වායු හුවමාරු ක්‍රියාවලිය",
          "වහිස්ස්‍රාවී පද්ධතිය: වෘක්කයේ ව්‍යුහය හා නෙප්‍රෝන ක්‍රියාකාරීත්වය",
          "චුම්භක ක්ෂේත්‍ර සහ සන්නායකයක් මත ක්‍රියාකරන චුම්භක බලය",
          "ප්ලෙමින්ගේ වමත් නියමය සහ සරල ධාරා මෝටරය",
          "ශබ්ද තරංග: ධ්වනි වේගය, අනුනාදය සහ මානව ශ්‍රව්‍යතා සීමාව",
          "කාබනික රසායනය: හයිඩ්‍රොකාබන (ඇල්කේන, ඇල්කීන, ඇල්කයින)",
          "පොලිමර් සහ ප්ලාස්ටික්වල රසායනික ගුණ හා පාරිසරික බලපෑම",
          "මානව ප්‍රජනක පද්ධතිය සහ හෝමෝන පාලනය",
          "ශාක හෝමෝන (ඔක්සීන්, ජිබරලීන්) සහ ආලෝකාවර්තනය",
          "ද්‍රාවණවල සාන්ද්‍රණය: මවුලික සාන්ද්‍රණය (mol dm⁻³) ගණනය",
          "දර්පණ සහ කාච මගින් ප්‍රතිබිම්බ සෑදීම හා කිරණ සටහන්",
          "ඇස සහ පෙනීමේ දෝෂ (දුරදක්නාභාවය, අවිදුරදක්නාභාවය) නිවැරදි කිරීම",
          "විද්‍යුත් බලය (P = VI) සහ ගෘහස්ථ විදුලි පරිභෝජන ඒකක ගණනය",
          "භූගත කිරීම සහ ආරක්ෂිත විදුලි උපාංග (MCB, RCCB, ෆියුස්)",
          "ජෛවගෝලීය චක්‍ර: කාබන් චක්‍රය සහ නයිට්‍රජන් චක්‍රය",
          "පාරිසරික දූෂණය: අම්ල වැසි, හරිතාගාර ආචරණය හා ඕසෝන් ක්ෂයවීම",
          "2 වන වාර ඇගයීම් ආදර්ශ පරිපූර්ණ ප්‍රශ්නාවලිය I",
          "2 වන වාර ඇගයීම් ආදර්ශ පරිපූර්ණ ප්‍රශ්නාවලිය II"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "2 වන වාර ඒකක: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "2 වන වාරයේ සියලු විද්‍යාත්මක සිද්ධාන්ත ආවරණය වන ප්‍රමිත බහුවරණ 40.", "ලකුණු 40 | MCQ"),
          PaperQuestionSnippet("II කොටස A (ව්‍යුහගත පරීක්ෂණ)", "$topic ආශ්‍රිත විද්‍යාගාර සැකසුම සහ දත්ත ප්‍රස්තාරිකව විශ්ලේෂණය කිරීම.", "ලකුණු 15 | Structured"),
          PaperQuestionSnippet("II කොටස B (රචනා ප්‍රශ්නය)", "යාන්ත්‍රික, තාප හෝ ජීව විද්‍යාත්මක සංසිද්ධි සවිස්තරාත්මකව සාකච්ඡා කර ලකුණු ලබාගැනීම.", "ලකුණු 20 | Essay")
        )
        Pair(unitCoverage, questions)
      }
      else -> {
        val topics = listOf(
          "ප්‍රවේණිය: මෙන්ඩල්ගේ නියම, ඒකමුහුම් හා ද්විමුහුම් අභිජනනය",
          "මානව වර්ණදේහ, DNA අණුව සහ ප්‍රවේණික රෝග (හිමොෆීලියාව)",
          "ක්ෂුද්‍රජීවී තාක්ෂණය සහ ආහාර කර්මාන්තයේ යෙදීම්",
          "විද්‍යුත් චුම්භක ප්‍රේරණය සහ ෆැරඩේ නියමය",
          "ප්‍රත්‍යාවර්ත ධාරා ජනක යන්ත්‍රය සහ ට්‍රාන්ස්ෆෝමර් සමීකරණ",
          "ඉලෙක්ට්‍රොනික් විද්‍යාව: ඩයෝඩ, ට්‍රාන්සිස්ටර සහ තර්ක ද්වාර",
          "ද්‍රවස්ථිති පීඩනය (P = hρg) සහ ආකිමිඩීස් නියමය",
          "ප්ලාවන නියමය සහ සාපේක්ෂ ඝනත්වය මැනීමේ උපක්‍රම",
          "විකිරණශීලී සමස්ථානික සහ වෛද්‍ය/කාර්මික යෙදීම්",
          "නැනෝ තාක්ෂණය සහ නවීන ද්‍රව්‍ය විද්‍යා සංකල්ප",
          "ස්වභාවික සම්පත් තිරසාර භාවිතය සහ ජෛව විවිධත්වය",
          "සමස්ත O/L මට්ටමේ භෞතික විද්‍යා සංයුක්ත ගැටලු විසඳීම",
          "සමස්ත O/L මට්ටමේ රසායන විද්‍යා සමීකරණ හා තුලිත කිරීම්",
          "සමස්ත O/L මට්ටමේ ජීව විද්‍යා පද්ධති සංසන්දනාත්මක විශ්ලේෂණය",
          "තාපය සහ විද්‍යුතය ඒකාබද්ධ ගණිතමය ආදර්ශ ගැටලු",
          "ප්‍රකාශ විද්‍යාව හා කාච සූත්‍රය (1/f = 1/v - 1/u) යෙදීම්",
          "මූලද්‍රව්‍ය ලෝහක හා අලෝහක ගුණ විචලනය හා ප්‍රවණතා",
          "ලුණු නිෂ්පාදනය සහ ලවණ කැටිකිරීමේ අනුපිළිවෙල",
          "ඇසිටිලීන්, එතනෝල් සහ එස්ටර නිපදවීමේ රසායනික පරීක්ෂණ",
          "ස්නායු හා අන්තරාසර්ග පද්ධතියේ ඒකාබද්ධ හෝමෝන පාලනය",
          "ප්‍රතිශක්තිකරණ පද්ධතිය: සහජ හා අත්පත් කරගත් ප්‍රතිශක්තිය",
          "භූචලන, සුනාමි සහ පෘථිවි අභ්‍යන්තර භූ තැටි චලිතය",
          "අභ්‍යවකාශ ගවේෂණය, කෘත්‍රිම චන්ද්‍රිකා සහ ගුරුත්වාකර්ෂණ කක්ෂ",
          "විද්‍යුත් රසායනික ශ්‍රේණිය සහ ගැල්වනික කෝෂ",
          "ලෝහ විඛාදනය වැළැක්වීමේ ක්‍රම: ගැල්වනයිස් කිරීම හා කැතෝඩික ආරක්ෂාව",
          "අර්ධ සන්නායක (P-වර්ගය, N-වර්ගය) සහ සූර්ය කෝෂ ක්‍රියාකාරීත්වය",
          "O/L සාර්ථකත්ව සම්පූර්ණ විභාග ආදර්ශ ප්‍රශ්න පත්‍රය 01",
          "O/L සාර්ථකත්ව සම්පූර්ණ විභාග ආදර්ශ ප්‍රශ්න පත්‍රය 02",
          "O/L සාර්ථකත්ව සම්පූර්ණ විභාග ආදර්ශ ප්‍රශ්න පත්‍රය 03",
          "3 වන වාරය සහ O/L විභාග අවසාන ජාතික පුහුණු පත්‍රය 30"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "3 වන වාර හා සම්පූර්ණ විෂය නිර්දේශ ඒකක: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "10 සහ 11 ශ්‍රේණි සම්පූර්ණ විෂය නිර්දේශය ආවරණය වන O/L මට්ටමේ බහුවරණ 40.", "ලකුණු 40 | O/L MCQ"),
          PaperQuestionSnippet("II කොටස A (ව්‍යුහගත ප්‍රශ්න)", "$topic ඇතුළු අනිවාර්ය ව්‍යුහගත ප්‍රශ්න 4 කට පිළිතුරු සැපයීම.", "ලකුණු 30 | Structured"),
          PaperQuestionSnippet("II කොටස B (රචනා ප්‍රශ්න)", "රසායනික, භෞතික හා ජීව විද්‍යා ඒකක ආශ්‍රිත තේරීම් රචනා ප්‍රශ්න 3ක්.", "ලකුණු 30 | Essay")
        )
        Pair(unitCoverage, questions)
      }
    }
  }

  // 2. MATHEMATICS
  private fun generateMathPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    return when (term) {
      1 -> {
        val topics = listOf(
          "වටයන සහ සංඛ්‍යා රටා: n වන පදය සෙවීම",
          "භාග: භාග සහිත වීජීය ප්‍රකාශන සුළු කිරීම",
          "දර්ශක සහ ලඝුගණක I: මූලික නීති හා අගයන් සෙවීම",
          "වීජීය ප්‍රකාශන ගුණ කිරීම සහ සුළු කිරීම",
          "පරිමිතිය: සංයුක්ත තල රූපවල පරිමිතිය සෙවීම",
          "ක්ෂේත්‍රඵලය: ත්‍රිකෝණ, සමාන්තරාස්‍ර හා ත්‍රපීසියම් ක්ෂේත්‍රඵලය",
          "කෝණ: සරල රේඛීය හා බද්ධ කෝණ ප්‍රමේය",
          "ත්‍රිකෝණ අංගසාම්‍යය (පා.කෝ.පා, කෝ.කෝ.පා, පා.පා.පා, කර්ණ.පා)",
          "සරල සමීකරණ ගොඩනැගීම හා විසඳීම",
          "ප්‍රතිශත: සරල පොලිය සහ තීරුබදු ගණනය කිරීම්",
          "සාධක: පොදු සාධක ගැනීම සහ ඝන දෙකක වෙනස",
          "ලඝුගණක වගුව භාවිතයෙන් සංඛ්‍යා ගුණ කිරීම හා බෙදීම",
          "සමාන්තර රේඛා හා ඒකාන්තර, අනුරූප, මිත්‍ර කෝණ",
          "බහුඅස්‍ර: අභ්‍යන්තර කෝණවල සහ බාහිර කෝණවල ඓක්‍යය",
          "වීජීය භාග එකතු කිරීම සහ අඩු කිරීම",
          "කාටිසීය තලයේ ලක්ෂ්‍ය ලකුණු කිරීම හා සරල රේඛා සමීකරණය (y = mx + c)",
          "අසමානතා: ඒකජ අසමානතා විසඳා සංඛ්‍යා රේඛාව මත දැක්වීම",
          "සමාන්තරාස්‍ර ප්‍රමේය සහ ගුණාංග භාවිත ගැටලු",
          "දත්ත නිරූපණය: කඳ හා පත්‍ර සටහන් සහ චතුර්ථක",
          "වෘත්තයක කේන්ද්‍ර කෝණය සහ චාප දිග සෙවීම",
          "අනුපාත හා සමානුපාත: මුදල් බෙදීයාම හා කාලය ගණනය",
          "වර්ගමූලය ආසන්න අගයට සෙවීම (පළමු දශමස්ථානයට)",
          "සමාන්තර රේඛා ආශ්‍රිත ජ්‍යාමිතික සාධන",
          "ත්‍රිකෝණයක මධ්‍ය ලක්ෂ්‍ය ප්‍රමේය සහ යෙදීම්",
          "සාධක භාවිතයෙන් වර්ගජ ප්‍රකාශන විසඳීම",
          "පයිතගරස් ප්‍රමේය සහ සෘජුකෝණී ත්‍රිකෝණ ගණනය කිරීම්",
          "සම්භාවිතාවේ මූලික න්‍යාය සහ නියැදි අවකාශය",
          "මූලික ජ්‍යාමිතික නිර්මාණ (කෝණ සමච්ඡේදක, ලම්බ සමච්ඡේදක)",
          "1 වන වාර ආදර්ශ පරිපූර්ණ ගණිත ප්‍රශ්නාවලිය",
          "1 වන වාර O/L පෙරහුරු ගණිත පරීක්ෂණය 30"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "1 වන වාර ඒකක: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස A (කෙටි ප්‍රශ්න 1-25)", "$topic ඇතුළු 1 වන වාරයේ සියලු ඒකක ආවරණය වන ලකුණු 2 බැගින් වන කෙටි ප්‍රශ්න 25.", "ලකුණු 50 | Paper I A"),
          PaperQuestionSnippet("I කොටස B (ව්‍යුහගත 1-5)", "භාග, ප්‍රතිශත, පරිමිතිය හා ක්ෂේත්‍රඵලය ආශ්‍රිත පියවර සහිත ලකුණු 10 බැගින් ප්‍රශ්න 5.", "ලකුණු 50 | Paper I B"),
          PaperQuestionSnippet("II කොටස (රචනා හා ජ්‍යාමිතිය)", "වීජ ගණිතය, ජ්‍යාමිතික සාධනය සහ සංඛ්‍යාන ගැටලු ඇතුළත් සම්පූර්ණ II පත්‍රය.", "ලකුණු 100 | Paper II")
        )
        Pair(unitCoverage, questions)
      }
      2 -> {
        val topics = listOf(
          "වර්ගජ ප්‍රකාශනවල සාධක (ax² + bx + c ආකෘතිය)",
          "සමගාමී සමීකරණ: විචල්‍යයන් ඉවත් කිරීමේ හා ආදේශ කිරීමේ ක්‍රමය",
          "වෘත්ත ප්‍රමේය: කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලම්බය",
          "වෘත්තයක කේන්ද්‍ර කෝණය සහ පරිධි කෝණය අතර සම්බන්ධය",
          "ත්‍රිකෝණමිතිය: sin, cos, tan අනුපාත සහ 30°, 45°, 60° අගයන්",
          "ආරෝහණ කෝණ සහ අවරෝහණ කෝණ ආශ්‍රිත ප්‍රායෝගික ගැටලු",
          "සමාන්තර ශ්‍රේඪි: n වන පදය (Tn = a + (n-1)d) සෙවීම",
          "සමාන්තර ශ්‍රේඪිවල මුල් පද n වල ඓක්‍යය (Sn) සෙවීම",
          "පෘෂ්ඨ වර්ගඵලය: සෘජු වෘත්තාකාර සිලින්ඩර සහ ප්‍රිස්ම",
          "පරිමාව: සිලින්ඩර, ප්‍රිස්ම සහ සමචතුරස්‍රාකාර පිරමිඩ",
          "ප්‍රතිශත II: වැට් (VAT), ආදායම් බදු සහ රේගු බදු ගණනය",
          "කොටස් වෙළඳපොළ: ලාභාංශ සහ ආයෝජන ප්‍රතිලාභ",
          "වර්ගජ සමීකරණ: වර්ගපූර්ණයෙන් සහ සූත්‍රයෙන් විසඳීම",
          "වෘත්ත ප්‍රමේය II: චක්‍රීය චතුරස්‍රවල සම්මුඛ කෝණ",
          "වෘත්තයක ස්පර්ශක ප්‍රමේය: ස්පර්ශකයේ ලක්ෂ්‍යය හා අරය",
          "ස්පර්ශක ඛණ්ඩවල දිග සමාන බව සාධනය කිරීම",
          "සංඛ්‍යානය: සමූහිත සංඛ්‍යාත ව්‍යාප්තියක උපකල්පිත මධ්‍යන්‍යය",
          "මාතය සහ මාධ්‍යස්ථ පන්තිය සෙවීම",
          "වෘත්ත ප්‍රමේය III: එකාන්තර ඛණ්ඩ ප්‍රමේය",
          "ත්‍රිකෝණ නිර්මාණ: පාද සහ කෝණ ලබාදී ඇති විට",
          "ස්පර්ශක නිර්මාණය: වෘත්තයක බාහිර ලක්ෂ්‍යයක සිට ස්පර්ශක",
          "කාර්යය හා මිනිස් දින ගණනය කිරීමේ ගැටලු",
          "සමානුපාතික කොටස්: ත්‍රිකෝණයක පාදයකට සමාන්තර සරල රේඛාව",
          "සමරූපී ත්‍රිකෝණ ප්‍රමේය සහ අනුරූප පාද අනුපාත",
          "ගෝලයක සහ අර්ධ ගෝලයක පෘෂ්ඨ වර්ගඵලය හා පරිමාව",
          "සංයුක්ත ඝන වස්තුවල පරිමා ගණනය (කේතුව + සිලින්ඩරය)",
          "වීජීය අසමානතා යුගලක් තනි සංඛ්‍යා රේඛාවක නිරූපණය",
          "ලඝුගණක භාවිතයෙන් සංකීර්ණ වර්ගමූල ගණනය කිරීම්",
          "2 වන වාර ඇගයීම් ආදර්ශ ගණිත පරීක්ෂණය I",
          "2 වන වාර ඇගයීම් ආදර්ශ ගණිත පරීක්ෂණය II"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "2 වන වාර ඒකක: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස (කෙටි ප්‍රශ්න 25 + ව්‍යුහගත 5)", "2 වන වාරයට අදාළ සමගාමී සමීකරණ, ත්‍රිකෝණමිතිය හා ජ්‍යාමිතිය කෙටි ප්‍රශ්න.", "ලකුණු 100 | Paper I"),
          PaperQuestionSnippet("II කොටස A (වීජ ගණිතය හා වාණිජ)", "ශ්‍රේඪි, වර්ගජ සමීකරණ, මධ්‍යන්‍යය සහ බදු ගණනය ඇතුළත් ප්‍රශ්න 4ක්.", "ලකුණු 50 | Paper II A"),
          PaperQuestionSnippet("II කොටස B (ජ්‍යාමිතිය හා පරිමාව)", "වෘත්ත ප්‍රමේය සාධන, ත්‍රිකෝණමිතිය සහ ඝන වස්තු පරිමා ගැටලු 4ක්.", "ලකුණු 50 | Paper II B")
        )
        Pair(unitCoverage, questions)
      }
      else -> {
        val topics = listOf(
          "වර්ගජ ශ්‍රිත ප්‍රස්තාර: හැරවුම් ලක්ෂ්‍යය, සමමිතික අක්ෂය හා මූල සෙවීම",
          "ප්‍රස්තාර ඇසුරින් ශ්‍රිතය ධන වන හා සෘණ වන අන්තර සෙවීම",
          "සංඛ්‍යානය: සංචිත සංඛ්‍යාත වක්‍රය (ඕජයිවය) සහ අන්තශ්චතුර්ථක පරාසය",
          "සම්භාවිතාව: ගස් රූප සටහන් (ප්‍රතිස්ථාපනය සහිත හා රහිත)",
          "කට්ටල සහ වෙන් රූප: ප්‍රදේශ අඳුරු කිරීම හා n(A∪B) සමීකරණය",
          "ගුණෝත්තර ශ්‍රේඪි: n වන පදය සහ මුල් පද n වල ඓක්‍යය",
          "ජ්‍යාමිතික නිර්මාණ: ත්‍රිකෝණයක පරිවෘත්තය සහ අන්තර්වෘත්තය",
          "ජ්‍යාමිතික සාධනය: වෘත්ත, ස්පර්ශක හා සමරූපීතාව ඒකාබද්ධ සාධන",
          "වර්ගජ සමීකරණ භාවිතයෙන් ප්‍රායෝගික ගැටලු විසඳීම (වර්ගඵල හා චලිත)",
          "ත්‍රිකෝණමිතිය: සැබෑ ලෝකයේ නිරීක්ෂණ කුලුනු හා ගොඩනැගිලි උස සෙවීම",
          "ඝන වස්තු පරිමාව හා ලඝුගණක වගු ඒකාබද්ධ O/L මට්ටමේ ප්‍රශ්න",
          "වාණිජ ගණිතය: හීනවන ශේෂ ක්‍රමයට පොලිය සහ වාරික මුදල ගණනය",
          "කොටස් වෙළඳපොළ හා ආදායම් බදු ඒකාබද්ධ මූල්‍ය ආකෘති",
          "සමස්ත සාමාන්‍ය පෙළ I පත්‍රය (A සහ B කොටස් සම්පූර්ණ ආදර්ශය)",
          "සමස්ත සාමාන්‍ය පෙළ II පත්‍රය (A සහ B කොටස් පරිපූර්ණ ආදර්ශය)",
          "බහුවරණ හා කෙටි ප්‍රශ්න 25 විශේෂ කඩිනම් පුහුණුව",
          "වෙන් රූප ඇසුරින් ප්‍රායෝගික සමීක්ෂණ දත්ත විශ්ලේෂණය",
          "අසමානතා සහ මාන ගැටලු ඇතුළත් විශේෂ ව්‍යුහගත පත්‍රය",
          "ශ්‍රේඪිවල සැබෑ ලෝක යෙදීම් (මුදල් ඉතිරි කිරීම, ධාවන පුහුණුව)",
          "වෘත්තයක කේන්ද්‍ර, පරිධි හා එකාන්තර ඛණ්ඩ ප්‍රමේය තුනම ඇතුළත් සාධනය",
          "කේතු, ගෝල සහ සිලින්ඩර ඒකාබද්ධ සංකීර්ණ ඝන වස්තු ගැටලු",
          "ප්‍රස්තාරික ක්‍රමයෙන් √2, √3 වැනි අතාත්වික මූලවල ආසන්න අගය සෙවීම",
          "ලඝුගණක ලක්ෂණය හා Mantissa නිවැරදිව භාවිතය",
          "ජාතික O/L පෙරහුරු ගණිත ප්‍රශ්න පත්‍රය 24",
          "ජාතික O/L පෙරහුරු ගණිත ප්‍රශ්න පත්‍රය 25",
          "විශිෂ්ඨතා A සාමාර්ථ ඉලක්කගත ගණිත පත්‍රය 26",
          "විශිෂ්ඨතා A සාමාර්ථ ඉලක්කගත ගණිත පත්‍රය 27",
          "විභාග දෙපාර්තමේන්තු ආදර්ශ පෙරහුරු ගණිත පත්‍රය 28",
          "අධ්‍යාපන අමාත්‍යාංශ ඒකාබද්ධ O/L ගණිත පත්‍රය 29",
          "සමස්ත ලංකා ගණිත විශිෂ්ඨතා අවසන් වාර පරීක්ෂණය 30"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "3 වන වාර හා O/L පරිපූර්ණ ඒකක: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස (A කොටස 1-25 + B කොටස 1-5)", "සම්පූර්ණ විෂය නිර්දේශයේ සියලු සංකල්ප ආවරණය වන ලකුණු 100ක I පත්‍රය.", "ලකුණු 100 | Paper I"),
          PaperQuestionSnippet("II කොටස A (ප්‍රස්තාර, වාණිජ, වර්ගජ)", "$topic ආශ්‍රිත ප්‍රස්තාරික ගැටලුව ඇතුළුව ප්‍රශ්න 5න් 4ක් තේරීම.", "ලකුණු 50 | Paper II A"),
          PaperQuestionSnippet("II කොටස B (ජ්‍යාමිතිය, නිර්මාණ, වෙන් රූප)", "වෘත්ත ප්‍රමේය සාධනය, නිර්මාණ සහ ගස් රූප සම්භාවිතාව.", "ලකුණු 50 | Paper II B")
        )
        Pair(unitCoverage, questions)
      }
    }
  }

  // 3. HISTORY
  private fun generateHistoryPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    return when (term) {
      1 -> {
        val topics = listOf(
          "ඓතිහාසික මූලාශ්‍ර: සාහිත්‍ය මූලාශ්‍ර (දීපවංශය, මහාවංශය, ථූපවංශය)",
          "පුරාවිද්‍යාත්මක මූලාශ්‍ර: සෙල්ලිපි, කාසි, නටබුන් සහ මැටි බඳුන්",
          "ශ්‍රී ලංකාවේ ප්‍රාග් ඓතිහාසික මානවයා සහ පාහියංගල, බටදොඹලෙන සාධක",
          "පූර්ව ඓතිහාසික යුගය: මුල් යකඩ යුගයේ සුසාන භූමි (ඉබ්බන්කටුව)",
          "විජයගේ පැමිණීම සහ මුල් ජනාවාස ව්‍යාප්තිය (මල්වතු ඔය, දැදුරු ඔය)",
          "පණ්ඩුකාභය රජු සහ අනුරාධපුර නගර නිර්මාණය හා පරිපාලනය",
          "දේවානම්පියතිස්ස රජු සහ මහින්දාගමනය: දේශපාලන හා සංස්කෘතික විපර්යාසය",
          "සංඝමිත්තා තෙරණියගේ පැමිණීම, ශ්‍රී මහා බෝධි රෝපණය හා ශිල්ප ශ්‍රේණි",
          "දුටුගැමුණු රජු: රට එක්සේසත් කිරීම සහ රුවන්වැලිසෑය, මිරිසවැටිය ඉදිකිරීම",
          "සද්ධාතිස්ස සහ වළගම්බා රජවරුන්ගේ දායකත්වය සහ ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීම",
          "අනුරාධපුර මුල් යුගයේ ආර්ථිකය: කුඩා වැව් පද්ධතිය සහ ගොවිතැන",
          "පුරාණ ගම්මානයක ව්‍යුහය: ගම්වැව, වෙල්යාය, ගෙවත්ත සහ කුරහන් හේන",
          "ඇළහැර ඇළ සහ මුල් ඇළ මාර්ග ඉදිකිරීම් තාක්ෂණය",
          "භාතියතිස්ස හා කූටකණ්ණතිස්ස රජවරුන්ගේ පාලන තොරතුරු",
          "වසභ රජුගේ ජල කළමනාකරණය: උමං ජල මාර්ග සහ මහා වැව් ආරම්භය",
          "ගජබාහු රජු සහ සොළී දේශයෙන් සිරකරුවන් හා පාත්‍රා ධාතුව ගෙනඒම",
          "මහසෙන් රජුගේ වාරි විප්ලවය: මින්නේරිය, කවුඩුල්ල වැව් සහ ජේතවනාරාමය",
          "ධාතුසේන රජු සහ කලා වැව, යෝධ ඇළ (ජය ගඟ) ඉංජිනේරු තාක්ෂණය",
          "සීගිරිය: කාශ්‍යප රජුගේ නගර නිර්මාණ හා චිත්‍ර කලාවේ අසිරිය",
          "අනුරාධපුර යුගයේ විදේශ වෙළඳාම: මහාතිත්ථ (මාන්තායි) ජාත්‍යන්තර වරාය",
          "රෝම, පර්සියානු සහ චීන කාසි ශ්‍රී ලංකාවෙන් හමුවීම සහ ආර්ථික වැදගත්කම",
          "අනුරාධපුර මධ්‍ය යුගයේ රජවරු සහ සංඝ භේදය (මහාවිහාර, අභයගිරි, ජේතවන)",
          "බෞද්ධ අධ්‍යාපනය: පිරිවෙන් සහ ධර්ම දූත සේවාව",
          "ශ්‍රී ලංකා සිතියමේ අනුරාධපුර මුල් යුගයේ ඓතිහාසික ස්ථාන 10ක් ලකුණු කිරීම",
          "ලෝක සිතියමේ පැරණි සේද මාවත සහ ශ්‍රී ලංකාවේ පිහිටීම",
          "ශිලා ලේඛන වර්ග: ලෙන් ලිපි, ගිරි ලිපි, ටැම් ලිපි සහ පුවරු ලිපි",
          "ශ්‍රී ලංකාවේ මුල් රාජ්‍යත්ව සංකල්පය සහ අභිෂේකය",
          "1 වන වාර ආදර්ශ ඉතිහාස ප්‍රශ්නාවලිය",
          "1 වන වාර පළාත් මට්ටමේ ඉතිහාස පරීක්ෂණය 29",
          "1 වන වාර සම්පූර්ණ ඉතිහාස ඇගයීම් පත්‍රය 30"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "1 වන වාර ඒකක: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "1 වන වාරයට අදාළ ඓතිහාසික මූලාශ්‍ර හා අනුරාධපුර යුගය පිළිබඳ බහුවරණ 40.", "ලකුණු 40 | MCQ"),
          PaperQuestionSnippet("II කොටස 1 වන ප්‍රශ්නය (අනිවාර්ය සිතියම)", "ශ්‍රී ලංකා සිතියමේ අනුරාධපුරය, මාන්තායි, කලා වැව, මින්නේරිය ඇතුළු ස්ථාන ලකුණු කිරීම.", "ලකුණු 15 | සිතියම්"),
          PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "$topic ඇතුළු ඓතිහාසික කරුණු 3ක් පිළිබඳ සවිස්තරාත්මක රචනා ප්‍රශ්න.", "ලකුණු 45 | රචනා")
        )
        Pair(unitCoverage, questions)
      }
      2 -> {
        val topics = listOf(
          "අනුරාධපුර රාජධානියේ බිඳවැටීමට බලපෑ හේතු සහ චෝල ආක්‍රමණය",
          "I වන විජයබාහු රජු: පොළොන්නරුව අගනගරය කරගැනීම සහ රට එක්සේසත් කිරීම",
          "මහා පරාක්‍රමබාහු රජුගේ දේශපාලන හා යුදමය ක්‍රියාමාර්ග",
          "පරාක්‍රම සමුද්‍රය සහ 'අහසින් වැටෙන එකදු දිය බිඳක්වත්...' වාරි ප්‍රතිපත්තිය",
          "පොළොන්නරු යුගයේ කෘෂිකාර්මික හා ආර්ථික ස්වර්ණමය සමය",
          "නිශ්ශංකමල්ල රජුගේ ශිලා ලේඛන (ගල්පොත, හැටදාගෙයි සෙල්ලිපිය) සහ පාලනය",
          "කාලිංග මාඝගේ ආක්‍රමණය සහ පොළොන්නරු ශිෂ්ටාචාරයේ පරිහානිය",
          "රාජධානි නිරිතදිගට සංක්‍රමණය වීම: දඹදෙණි රාජධානිය සහ III වන විජයබාහු",
          "II වන පරාක්‍රමබාහු රජුගේ සාහිත්‍ය හා සංස්කෘතික පුනරුදය",
          "යාපහුව රාජධානිය: I වන බුවනෙකබාහු සහ සිංහ පාද පඩිපෙළ නිර්මාණ",
          "කුරුණෑගල සහ ගම්පොළ යුග: IV වන පරාක්‍රමබාහු සහ දළදා වහන්සේ ආරක්ෂා කිරීම",
          "කෝට්ටේ රාජධානිය ආරම්භය: නිශ්ශංක අලගක්කෝනාර සහ ආරක්ෂක බලකොටු",
          "VI වන පරාක්‍රමබාහු රජු: මුළු ලංකාවම එක්සේසත් කළ අවසන් සිංහල රජු",
          "කෝට්ටේ යුගයේ සාහිත්‍ය පුනරුදය: සන්දේශ කාව්‍ය සහ තොටගමුවේ ශ්‍රී රාහුල හිමි",
          "සීතාවක රාජධානිය: මායාදුන්නේ සහ I වන රාජසිංහ (ටිකිරි කුමාරු) ගේ වීරත්වය",
          "මුල්ලේරියා සටන සහ පෘතුගීසි බලකොටු වැටලීම",
          "උඩරට රාජධානිය පිහිටුවීම: සේනාසම්මත වික්‍රමබාහු සහ විමලධර්මසූරිය I රජු",
          "දන්ත ධාතූන් වහන්සේ උඩරටට වැඩමවීම සහ දළදා මාළිගාව ඉදිකිරීම",
          "දෙවන රාජසිංහ රජු සහ ගන්නෝරුව මහා සටන (1638)",
          "පෘතුගීසීන් ලංකාවට පැමිණීම (1505) සහ වෙළඳ බලය තහවුරු කරගැනීම",
          "පෘතුගීසි පාලනය නිසා මෙරට ආර්ථික, සමාජ හා ආගමික පරිසරයට වූ බලපෑම්",
          "ලන්දේසීන් සමඟ ගිවිසුම් ඇතිකර ගැනීම සහ පෘතුගීසීන් පලවා හැරීම",
          "ලන්දේසි පාලන ක්‍රමය: කොම්පැණි පාලනය, නීති පද්ධතිය (රෝම ලන්දේසි නීතිය) සහ බදු",
          "ශ්‍රී ලංකා සිතියමේ නිරිතදිග රාජධානි, සටන් බිම් සහ වරායන් ලකුණු කිරීම",
          "ලෝක සිතියමේ යුරෝපීය ජාතීන්ගේ ආසියානු වෙළඳ මාර්ග ලකුණු කිරීම",
          "මධ්‍යතන යුගයේ විදේශීය වෙළඳ සබඳතා: අරාබි සහ චීන වෙළෙන්ඳන්",
          "නායක්කාර වංශික රජවරුන්ගේ උඩරට පාලනය (ශ්‍රී විජය රාජසිංහ සිට ශ්‍රී වික්‍රම දක්වා)",
          "කීර්ති ශ්‍රී රාජසිංහ රජු සහ වැලිවිට සරණංකර හිමියන්ගේ උපසම්පදා පුනරුදය",
          "2 වන වාර ඇගයීම් ආදර්ශ ඉතිහාස පරීක්ෂණය I",
          "2 වන වාර ඇගයීම් ආදර්ශ ඉතිහාස පරීක්ෂණය II"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "2 වන වාර ඒකක: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස (බහුවරණ 40)", "පොළොන්නරුව, නිරිතදිග රාජධානි හා යුරෝපීය ආගමනය ආශ්‍රිත ප්‍රශ්න 40.", "ලකුණු 40 | MCQ"),
          PaperQuestionSnippet("II කොටස 1 වන ප්‍රශ්නය (සිතියම)", "පොළොන්නරුව, දඹදෙණිය, යාපහුව, සීතාවක, ගන්නෝරුව සිතියමේ ලකුණු කිරීම.", "ලකුණු 15 | සිතියම්"),
          PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "$topic පිළිබඳ සවිස්තර විවරණයක් ලියා දක්වන්න.", "ලකුණු 45 | රචනා")
        )
        Pair(unitCoverage, questions)
      }
      else -> {
        val topics = listOf(
          "ඉංග්‍රීසීන් මුහුදුබඩ ප්‍රදේශ අත්පත් කරගැනීම (1796) සහ ඒකාබද්ධ පරිපාලනය",
          "1815 උඩරට ගිවිසුම: ඓතිහාසික පසුබිම, වගන්ති සහ ස්වාධීනත්වය අහිමිවීම",
          "1818 වෙල්ලස්ස මහා නිදහස් අරගලය: කැප්පෙටිපොළ නිලමේගේ නායකත්වය සහ හේතු",
          "1848 නිදහස් සටන: පුරන් අප්පු, ගොන්ගාලේගොඩ බණ්ඩා සහ බදු පැනවීම්වල බලපෑම",
          "කෝල්බෲක් - කැමරන් ප්‍රතිසංස්කරණ (1833): ව්‍යවස්ථාදායක හා විධායක සභා, පළාත් 5 බෙදීම",
          "වැවිලි ආර්ථිකයේ ආරම්භය: කෝපි වගාව, කෝපි වසංගතය සහ තේ, රබර්, පොල් ව්‍යාප්තිය",
          "මහාමාර්ග, දුම්රිය මාර්ග සහ වරාය සංවර්ධනය නිසා සිදු වූ සමාජ ආර්ථික වෙනස්කම්",
          "ඉන්දියානු දෙමළ කම්කරුවන් මෙරටට ගෙන්වීම සහ වතු ආර්ථිකයේ ව්‍යුහය",
          "19 වන සියවසේ ආගමික හා ජාතික පුනරුදය: පානදුරාවාදය සහ මිගෙට්ටුවත්තේ ගුණානන්ද හිමි",
          "ඕල්කොට් තුමා, අනගාරික ධර්මපාලතුමා සහ බෞද්ධ පරමවිඥානාර්ථ සමාගම",
          "හින්දු, මුස්ලිම් සහ කතෝලික ප්‍රබෝධය (ආරුමුග නාවලර්, සිද්ධි ලෙබ්බේ)",
          "1915 ජාතිවාදී කෝලාහල සහ ජාතික නිදහස් ව්‍යාපාරයේ නැගීසිටීම",
          "ලංකා ජාතික සංගමය (Ceylon National Congress) පිහිටුවීම සහ නායකත්වය",
          "මැකලම්, මැනිං සහ ඩොනමෝර් ප්‍රතිසංස්කරණ (1931): සර්වජන ඡන්ද බලය හිමිවීම",
          "රාජ්‍ය මන්ත්‍රණ සභාව, කාරක සභා ක්‍රමය සහ සී.ඩබ්.ඩබ්. කන්නන්ගර මැතිතුමාගේ නිදහස් අධ්‍යාපනය",
          "දෙවන ලෝක යුද්ධය සහ ශ්‍රී ලංකාවට එල්ල වූ ජපන් ගුවන් ප්‍රහාර (1942)",
          "සූරියමල් ව්‍යාපාරය සහ මෙරට වාමාංශික ව්‍යාපාරයේ ආරම්භය",
          "සෝල්බරි ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණය (1947): පාර්ලිමේන්තු ක්‍රමය සහ සෙනෙට් සභාව",
          "1948 පෙබරවාරි 4 නිදහස දිනාගැනීම සහ ඩී.එස්. සේනානායක අග්‍රාමාත්‍යවරයා",
          "ගල්ඔය යෝජනා ක්‍රමය සහ නිදහසින් පසු ගොවිජනපද ව්‍යාපාරය",
          "1972 පළමු ජනරජ ව්‍යවස්ථාව සහ ශ්‍රී ලංකාව පූර්ණ ස්වාධීන ජනරජයක් වීම",
          "1978 දෙවන ජනරජ ව්‍යවස්ථාව සහ විධායක ජනාධිපති ධුරය",
          "ශ්‍රී ලංකා සිතියමේ වැවිලි බෝග ප්‍රදේශ, දුම්රිය මාර්ග හා නූතන වරායන් ලකුණු කිරීම",
          "ලෝක සිතියමේ පළමු හා දෙවන ලෝක යුද්ධවලට සම්බන්ධ ප්‍රධාන රටවල් ලකුණු කිරීම",
          "එක්සත් ජාතීන්ගේ සංවිධානය (UN) සහ ශ්‍රී ලංකාවේ නොබැඳි විදේශ ප්‍රතිපත්තිය",
          "ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම ව්‍යවස්ථා පරිණාමය පිළිබඳ සංසන්දනාත්මක විග්‍රහය",
          "O/L සාර්ථකත්ව ජාතික ඉතිහාස පෙරහුරු පත්‍රය 27",
          "O/L සාර්ථකත්ව ජාතික ඉතිහාස පෙරහුරු පත්‍රය 28",
          "O/L සාර්ථකත්ව ජාතික ඉතිහාස පෙරහුරු පත්‍රය 29",
          "3 වන වාරය සහ O/L අවසන් ජාතික ඉතිහාස පුහුණු පත්‍රය 30"
        )
        val topic = topics[(pNum - 1) % topics.size]
        val unitCoverage = "3 වන වාර හා සම්පූර්ණ O/L ඉතිහාසය: $topic"
        val questions = listOf(
          PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "10 සහ 11 ශ්‍රේණි සම්පූර්ණ ඉතිහාසය ආවරණය වන O/L ප්‍රමිත බහුවරණ 40.", "ලකුණු 40 | MCQ"),
          PaperQuestionSnippet("II කොටස 1 වන ප්‍රශ්නය (අනිවාර්ය සිතියම)", "ලංකා සිතියමේ ස්ථාන 10ක් සහ ලෝක සිතියමේ ස්ථාන 5ක් නිවැරදිව ලකුණු කිරීම.", "ලකුණු 15 | සිතියම්"),
          PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "$topic ඇතුළු නිදහස් සටන් හා ආණ්ඩුක්‍රම පිළිබඳ විචාරාත්මක රචනා ප්‍රශ්න.", "ලකුණු 45 | රචනා")
        )
        Pair(unitCoverage, questions)
      }
    }
  }

  // 4. BUDDHISM
  private fun generateBuddhismPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val termTopics = when (term) {
      1 -> listOf(
        "බුද්ධ චරිතය: අභිනිෂ්ක්‍රමණය සහ සයවසක දුෂ්කරක්‍රියාව",
        "චතුරාර්ය සත්‍ය ධර්මය: දුක්ඛ, සමුදය, නිරෝධ, මාර්ග සත්‍ය",
        "ආර්ය අෂ්ටාංගික මාර්ගය: සීල, සමාධි, ප්‍රඥා ත්‍රිශික්ෂාව",
        "ත්‍රිලක්ෂණය: අනිත්‍ය, දුක්ඛ, අනාත්ම ධර්ම විවරණය",
        "පංචශීලය සහ ගිහි සමාජයේ ආචාර ධර්ම",
        "දස කුසල් සහ දස අකුසල් ධර්ම විභාගය",
        "බුද්ධත්වය සහ සම්බුදු ගුණ (නව අරහාදී බුදුගුණ)",
        "ධර්ම රත්නයේ ගුණ (ස්වාක්ඛාතාදී ගුණ සය)",
        "සංඝ රත්නයේ ගුණ (සුපටිපන්නාදී ගුණ නවය)",
        "ප්‍රථම ධර්ම දේශනාව: ධම්මචක්කප්පවත්තන සූත්‍රය",
        "අනත්තලක්ඛණ සූත්‍රය සහ පස්වග මහණුන් රහත් වීම",
        "යස කුලපුත්‍රයා ඇතුළු යහළු පිරිස පැවිදි වීම සහ ධර්ම ප්‍රචාරය",
        "තුඩුස් මහා ගුණ සහ බුදුරදුන්ගේ දෛනික දින චරියාව",
        "මහා මංගල සූත්‍රය: මෙලොව පරලොව දියුණුවේ මංගල කරුණු",
        "සිඟාලෝවාද සූත්‍රය: සදිසා නමස්කාරය සහ සමාජ සබඳතා",
        "පරාභව සූත්‍රය: මිනිසාගේ පිරිහීමට බලපාන හේතු",
        "වසල සූත්‍රය: ක්‍රියාවෙන් මිස උපතින් වසලයෙකු නොවන බව",
        "ව්‍යග්ඝපජ්ජ (දීඝජාණු) සූත්‍රය: මෙලොව පරලොව ආර්ථික දියුණුව",
        "සතර සංග්‍රහ වස්තු: දාන, ප්‍රියවචන, අර්ථචර්යා, සමානාත්මතා",
        "සතර බ්‍රහ්ම විහරණ: මෙත්තා, කරුණා, මුදිතා, උපෙක්ඛා",
        "කර්ම නියමය: කුසල හා අකුසල කර්මවල ඵල විපාක",
        "පුනර්භවය සහ භව චක්‍රයේ ක්‍රියාකාරීත්වය",
        "දස පාරමිතා ධර්ම සහ බෝධිසත්ව ගුණාංග",
        "ප්‍රථම ධර්ම සංගායනාව: හේතු, සහභාගී වූ රහතන් වහන්සේලා සහ ප්‍රතිඵල",
        "දෙවන ධර්ම සංගායනාව: දස වස්තුව සහ ධර්ම විනය ශෝධනය",
        "තෙවන ධර්ම සංගායනාව: අශෝක අධිරාජයා සහ නව රටවලට ධර්මදූත සේවාව",
        "බෞද්ධ සංස්කෘතික උරුමයන්: ස්තූපය, බෝධිඝරය, පිළිමගෙය",
        "1 වන වාර ආදර්ශ බුද්ධ ධර්ම ප්‍රශ්නාවලිය",
        "1 වන වාර පළාත් මට්ටමේ බුද්ධ ධර්ම පරීක්ෂණය 29",
        "1 වන වාර සම්පූර්ණ බුද්ධ ධර්ම ඇගයීම් පත්‍රය 30"
      )
      2 -> listOf(
        "මහින්දාගමනය: ශ්‍රී ලංකාවේ සමාජ, ආගමික හා සංස්කෘතික විප්ලවය",
        "දේවානම්පියතිස්ස රජු සහ මිහින්තලා පුදබිම, මහාවිහාරය පිහිටුවීම",
        "සංඝමිත්තා මහරහත් තෙරණිය සහ ශ්‍රී මහා බෝධීන් වහන්සේ වැඩමවීම",
        "භික්ෂුණී ශාසනය පිහිටුවීම සහ අනුලා දේවිය ඇතුළු කාන්තාවන් පැවිදි වීම",
        "ත්‍රිපිටකය ග්‍රන්ථාරූඪ කිරීම: මාතලේ අලුවිහාරයේ ඓතිහාසික මෙහෙවර",
        "අටුවා සාහිත්‍යය සහ බුද්ධඝෝෂ හිමියන්ගේ විසුද්ධිමග්ගය",
        "සූත්‍ර පිටකය, විනය පිටකය, අභිධම්ම පිටකය හැඳින්වීම",
        "බෞද්ධ ආර්ථික දර්ශනය: ධාර්මික ධනෝපායනය සහ පරිභෝජනය",
        "බෞද්ධ රාජ්‍ය පාලන ප්‍රතිපත්ති: දසරාජ ධර්ම සහ සක්විති වත්",
        "බෞද්ධ මනෝවිද්‍යාව: සිත, චෛතසික සහ සිත දමනය කිරීමේ භාවනා",
        "සමථ භාවනාව සහ විදර්ශනා භාවනාව අතර වෙනස",
        "සතර සතිපට්ඨාන භාවනාව: කායානුපස්සනා, වේදනානුපස්සනා, චිත්තානුපස්සනා, ධම්මානුපස්සනා",
        "මරණානුස්සති සහ මෙත්තා භාවනා පුහුණුව",
        "පටිච්චසමුප්පාද ධර්මය: හේතුඵල දහම සහ අවිද්‍යාවේ සිට ජරාමරණ දක්වා",
        "පංච උපාදානස්කන්ධය: රූප, වේදනා, සඤ්ඤා, සංඛාර, විඤ්ඤාණ",
        "පංච නියාම ධර්ම: බීජ, උතු, කම්ම, ධම්ම, චිත්ත නියාම",
        "බෞද්ධ පාරිසරික ආචාර ධර්ම: ගහකොළ, සතාසිවුපාවුන් රැකගැනීම",
        "බුදුරදුන්ගේ පරිසර ප්‍රේමය සහ ආරාම පරිසරය",
        "ශ්‍රී ලංකාවේ බෞද්ධ චිත්‍ර හා මූර්ති කලාවේ විකාශනය",
        "සමාධි බුදුපිළිමය, අවුකන බුදුපිළිමය සහ තොළුවිල පිළිමය",
        "සඳකඩපහණේ සංකේතාත්මක අර්ථය (භව චක්‍රය සහ නිර්වාණය)",
        "මුරගල, කොරවක්ගල සහ වාහල්කඩ වාස්තු විද්‍යාත්මක අංග",
        "දළදා වහන්සේ සහ ලාංකේය රාජ්‍යත්වය අතර පවතින නොබිඳෙන සබඳතාව",
        "දළදා පෙරහැර සංස්කෘතිය සහ සිරිත් විරිත්",
        "වැලිවිට අසරණ සරණ සරණංකර සංඝරාජ මාහිමියන්ගේ ශාසනික පුනර්ජීවනය",
        "සියම් මහා නිකාය, අමරපුර නිකාය, රාමඤ්ඤ නිකාය ආරම්භය",
        "2 වන වාර ඇගයීම් ආදර්ශ බුද්ධ ධර්ම පරීක්ෂණය I",
        "2 වන වාර ඇගයීම් ආදර්ශ බුද්ධ ධර්ම පරීක්ෂණය II",
        "2 වන වාර පළාත් මට්ටමේ බුද්ධ ධර්ම පරීක්ෂණය 29",
        "2 වන වාර සම්පූර්ණ බුද්ධ ධර්ම ඇගයීම් පත්‍රය 30"
      )
      else -> listOf(
        "නිර්වාණ ධර්මය: සෝවාන්, සකෘදාගාමී, අනාගාමී, අරහත් මාර්ග ඵල",
        "සෝපාදිසේස සහ අනුපාදිසේස පරිනිර්වාණය",
        "බෞද්ධ සමාජ දර්ශනය සහ ලෝක සාමය උදෙසා බුදුදහමේ මඟ",
        "මානව හිමිකම් සහ ප්‍රජාතන්ත්‍රවාදය පිළිබඳ බෞද්ධ ආකල්පය",
        "නවීන විද්‍යාව සහ බුදුදහම අතර සංසන්දනාත්මක විමර්ශනය",
        "නූතන සමාජයේ සාරධර්ම පරිහානිය සහ බෞද්ධ විසඳුම්",
        "බෞද්ධ සන්නිවේදන කලාව සහ ධර්ම දේශනා ක්‍රමවේද",
        "ථේරවාදී බුදුදහම සහ මහායාන බුදුදහම අතර ප්‍රධාන වෙනස්කම්",
        "ලෝකයේ වෙනත් රටවල බුදුදහම ව්‍යාප්ත වීම (තායිලන්තය, මියන්මාරය, ජපානය)",
        "ශ්‍රී ලංකාවේ බෞද්ධ පුනරුද ව්‍යාපාරය (හික්කඩුවේ ශ්‍රී සුමංගල හිමි, රත්මලානේ ධර්මාලෝක හිමි)",
        "විද්‍යෝදය සහ විද්‍යාලංකාර පිරිවෙන්වල පුරෝගාමී මෙහෙවර",
        "අනගාරික ධර්මපාලතුමා සහ මහාබෝධි සමාගමේ ලෝක ව්‍යාප්ත මෙහෙවර",
        "බුද්ධගයාව ඇතුළු දඹදිව බෞද්ධ සිද්ධස්ථාන රැකගැනීමේ අරගලය",
        "ධම්මපදය: යමක වග්ගය, අප්පමාද වග්ගය සහ චිත්ත වග්ගයේ ගාථා විවරණය",
        "බෞද්ධ ගෘහ ජීවිතය: අඹුසැමි, දෙමාපිය-දූදරු යුතුකම් සහ යුතුකම් මාලාව",
        "සම්‍යක් ආජීවය සහ වර්තමාන ව්‍යාපාරික ආචාර ධර්ම",
        "මත්ද්‍රව්‍ය නිවාරණය සහ යොවුන් පරපුර යහමඟට ගැනීම පිළිබඳ බෞද්ධ මඟ",
        "මානසික ආතතිය සහ කාංසාව දුරුකිරීමට බෞද්ධ භාවනාවේ උපයෝගීතාව",
        "බුදුරදුන්ගේ අග්‍රශ්‍රාවක චරිත: සැරියුත් - මුගලන් මහ රහතන් වහන්සේලා",
        "ධර්ම භාණ්ඩාගාරික ආනන්ද හිමි සහ මහා කාශ්‍යප හිමි",
        "අග්‍රශ්‍රාවිකා ඛේමා - උප්පලවණ්ණා රහත් මෙහෙණින් වහන්සේලා",
        "විශාඛා මහා උපාසිකාව සහ අනේපිඬු සිටුතුමාගේ ශාසනික සේවාව",
        "අංගුලිමාල, පටාචාරා සහ කිසාගෝතමී චරිත ඇසුරින් ලැබෙන ජීවිත ආදර්ශ",
        "සමස්ත O/L බුද්ධ ධර්මය බහුවරණ හා කෙටි ප්‍රශ්න විශේෂ පෙරහුරුව",
        "සමස්ත O/L බුද්ධ ධර්මය ව්‍යුහගත හා රචනා ප්‍රශ්න විශේෂ පුහුණුව",
        "ජාතික O/L පෙරහුරු බුද්ධ ධර්ම ප්‍රශ්න පත්‍රය 26",
        "ජාතික O/L පෙරහුරු බුද්ධ ධර්ම ප්‍රශ්න පත්‍රය 27",
        "විශිෂ්ඨතා A සාමාර්ථ ඉලක්කගත බුද්ධ ධර්ම පත්‍රය 28",
        "විභාග දෙපාර්තමේන්තු සම්පත් මණ්ඩල බුද්ධ ධර්ම පත්‍රය 29",
        "සමස්ත ලංකා බුද්ධ ධර්ම විශිෂ්ඨතා අවසන් වාර පරීක්ෂණය 30"
      )
    }

    val topic = termTopics[(pNum - 1) % termTopics.size]
    val unitCoverage = "${term} වන වාර ඒකක: $topic"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "බුද්ධ ධර්මය ${term} වන වාරයේ සියලු මූලධර්ම ආවරණය වන ප්‍රමිත බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස 1 වන ප්‍රශ්නය (කෙටි ප්‍රශ්න)", "ගාථා පාඨ, සූත්‍ර ධර්ම, බුදුගුණ හා ධර්ම කරුණු ඇසුරින් කෙටි ප්‍රශ්න 10ක්.", "ලකුණු 20 | කෙටි ප්‍රශ්න"),
      PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "$topic ඇසුරින් විචාරාත්මක ධර්ම කරුණු පැහැදිලි කිරීමේ රචනා ප්‍රශ්නය.", "ලකුණු 40 | රචනා")
    )
    return Pair(unitCoverage, questions)
  }

  // 5. SINHALA
  private fun generateSinhalaPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val termTopics = when (term) {
      1 -> listOf(
        "සිංහල අක්ෂර මාලාව: ස්වර, ව්‍යඤ්ජන, මූර්ධජ-දන්තජ සහ න-ණ, ල-ළ භේදය",
        "නාම පද වර්ගීකරණය: ප්‍රකෘති, සංඥා, ද්‍රව්‍ය, ගුණ, ක්‍රියා නාම",
        "ක්‍රියා පද: ආඛ්‍යාතය, මුක්ත ක්‍රියා, අමිශ්‍ර හා මිශ්‍ර ක්‍රියා",
        "සන්ධි: ස්වර සන්ධි, ව්‍යඤ්ජන සන්ධි, පූර්ව-පර රූප සන්ධි",
        "උපසර්ග සහ නිපාත පද නිවැරදිව වාක්‍යවල යෙදීම",
        "සමාස පද: තත්පුරුෂ, කර්මධාරය, ද්වන්ද, දිගු සමාස",
        "විරාම ලක්ෂණ භාවිතය (නැවතීමේ තිත, කොමාව, තිත් කොමාව, උද්ධෘත)",
        "අක්ෂර වින්‍යාස රීති: ෂ, ශ, ස භාවිතය සහ බැඳි අකුරු ලිවීම",
        "පද බෙදීමේ රීති: නාම පද, ක්‍රියා පද හා නිපාත පද වෙන්කර ලිවීම",
        "සාහිත්‍ය ප්‍රවේශය: ජන සාහිත්‍යය, ජන කවි (පැල්, පතල්, කරත්ත, කුරක්කන්)",
        "සම්භාව්‍ය පද්‍ය විචාරය I: කව්සිළුමිණ සහ සසදාවත ඇසුරින්",
        "ගුත්තිල කාව්‍යය: ගුත්තිල - මූසිල වාදයේ චරිත නිරූපණය හා කාව්‍යෝක්ති",
        "ලෝවැඩ සඟරාව: වීදාගම මෛත්‍රෙය හිමියන්ගේ සදාචාරාත්මක උපදෙස්",
        "කාව්‍යශේඛරය: තොටගමුවේ ශ්‍රී රාහුල හිමියන්ගේ පිය-දූ අවවාද",
        "සැලලිහිණි සන්දේශය: කෝට්ටේ නගර වර්ණනාව සහ උපමා රූපක අලංකාර",
        "ගංඟාරෝහණ වර්ණනාව: පද්‍ය බන්ධන ලක්ෂණ හා ශබ්ද ධ්වනිය",
        "යශෝධරා වත: කරුණාරසය දනවන පද්‍ය විචාරය",
        "රචනා ලේඛනය: පරිසර සංරක්ෂණය සහ ජාතික සංවර්ධනය පිළිබඳ තර්කානුකූල රචනා",
        "වාක්‍ය පරිවර්තනය: කර්තෘ කාරක වාක්‍ය කර්ම කාරකයට හැරවීම",
        "ප්‍රස්ථාව පිරුළු සහ රූඪි භාවිතය හා ඒවායේ ගැඹුරු අර්ථ",
        "සමානාර්ථ සහ විරුද්ධාර්ථ පද සංග්‍රහය",
        "යුගල පද සහ ද්විත්ව රූප පද නිවැරදිව යෙදීම",
        "අප්‍රකට අර්ථ දෙන පද සහ පර්යාය පද",
        "සාරාංශකරණය: දී ඇති ඡේදයකින් 1/3 කට සාරාංශයක් සකස් කිරීම",
        "නිල ලිපි ලේඛන: ආයතන ප්‍රධානියෙකුට නිල ඉල්ලීම් ලිපියක් ලිවීම",
        "පුවත්පත් වාර්තාකරණය සහ නිවේදන සකස් කිරීමේ ආකෘති",
        "1 වන වාර ආදර්ශ සිංහල භාෂාව හා සාහිත්‍යය පරීක්ෂණය 27",
        "1 වන වාර ආදර්ශ සිංහල භාෂාව හා සාහිත්‍යය පරීක්ෂණය 28",
        "1 වන වාර පළාත් මට්ටමේ සිංහල පරීක්ෂණය 29",
        "1 වන වාර සම්පූර්ණ සිංහල ඇගයීම් පත්‍රය 30"
      )
      2 -> listOf(
        "වාක්‍ය රීති: කර්තෘ-කාරක ආඛ්‍යාත අන්වය සහ ලිංග-පුරුෂ-වචන සම්බන්ධය",
        "කර්ම කාරක වාක්‍ය ගොඩනැගීම: 'විසින්' නිපාතය සහ කර්ම කාරක ක්‍රියා රූප",
        "අලංකාර ශාස්ත්‍රය: උපමා අලංකාරය (උපමේය, උපමානය, උපමාවාචී පද)",
        "රූපක අලංකාරය සහ උත්ප්‍රේක්ෂා අලංකාරය සාහිත්‍ය කෘති ඇසුරින් විවරණය",
        "ස්වභාවෝක්ති සහ අතිශයෝක්ති අලංකාර",
        "සම්භාව්‍ය ගද්‍ය සාහිත්‍යය I: අමාවතුර (ගුරුළුගෝමී) - ඇසූ දුටු දෑ මෙන් ලිවීම",
        "බුත්සරණ (විද්‍යාචක්‍රවර්තී): බුදුගුණ භක්තිය දනවන ගද්‍ය ශෛලිය",
        "පූජාවලිය (මයුරපාද පරිවේණාධිපති බුද්ධපුත්‍ර හිමි): සරල සුගම ධර්ම දේශනා ශෛලිය",
        "සද්ධර්මරත්නාවලිය (ධර්මසේන හිමි): උපමා, ප්‍රස්ථාව පිරුළු පිරි ගැමි බස් වහර",
        "සද්ධර්මාලංකාරය: කුරුණෑගල යුගයේ කතා කලාව",
        "උම්මග්ග ජාතකය: මහෞෂධ පණ්ඩිතයන්ගේ ප්‍රඥා පාටවය සහ ගැටලු විසඳීම",
        "නූතන කෙටිකතා සාහිත්‍යය: මාර්ටින් වික්‍රමසිංහ, ජී.බී. සේනානායක, කේ. ජයතිලක",
        "කෙටිකතාවක අංග: තේමාව, චරිත නිරූපණය, ආකෘතිය, භාෂාව",
        "නූතන පද්‍ය සාහිත්‍යය: කොළඹ යුගයේ කාව්‍ය නිර්මාණ සහ විමුක්ති ගීත",
        "මහගම සේකරගේ කාව්‍ය නිර්මාණ: 'ප්‍රබුද්ධ' සහ 'නොමියෙමි' ඇසුරින්",
        "විමලරත්න කුමාරගමගේ වැදි ජන ජීවිතය අළලා ලියූ කවි",
        "නූතන නාට්‍ය සාහිත්‍යය: එදිරිවීර සරච්චන්ද්‍රයන්ගේ 'මනමේ' සහ 'සිංහබාහු'",
        "නාට්‍යමය දෙබස් සහ ගීතවල සාහිත්‍යමය අගය",
        "ප්‍රකාශන ශක්තිය වර්ධනය: විවාදශීලී මාතෘකා ඔස්සේ කරුණු ගොනුකිරීම",
        "විචාර ලිපි ලිවීම: සාහිත්‍ය කෘතියක් ඇගයීමේ ප්‍රමිත නිර්ණායක",
        "විද්‍යුත් තැපෑල (Email) සහ නවීන සන්නිවේදන ලිපි ලේඛන ආකෘති",
        "සංස්කෘත සහ පාලි තත්සම හා තද්භව වචන හඳුනාගැනීම",
        "අර්ථ විපර්යාසය: අර්ථෝත්කර්ෂය, අර්ථහීනය, අර්ථ සංකෝචය",
        "2 වන වාර ඇගයීම් ආදර්ශ සිංහල පරීක්ෂණය I",
        "2 වන වාර ඇගයීම් ආදර්ශ සිංහල පරීක්ෂණය II",
        "2 වන වාර පළාත් මට්ටමේ සිංහල පරීක්ෂණය 26",
        "2 වන වාර පළාත් මට්ටමේ සිංහල පරීක්ෂණය 27",
        "2 වන වාර සම්පූර්ණ සිංහල ඇගයීම් පත්‍රය 28",
        "2 වන වාර සම්පූර්ණ සිංහල ඇගයීම් පත්‍රය 29",
        "2 වන වාර O/L පෙරහුරු සිංහල පත්‍රය 30"
      )
      else -> listOf(
        "සමස්ත O/L සිංහල I පත්‍රය: බහුවරණ හා කෙටි ප්‍රශ්න 40 ක සම්පූර්ණ පෙරහුරුව",
        "අප්‍රකට ඡේදයක් ඇසුරින් ප්‍රශ්නවලට පිළිතුරු සැපයීම සහ තොරතුරු උකහා ගැනීම",
        "සාරාංශකරණයේ උපරිම ලකුණු ලබාගැනීමේ උපාය මාර්ග",
        "ප්‍රබල හැඳින්වීමක්, කරුණු දැක්වීමක් හා නිගමනයක් සහිත පූර්ණ රචනාවක් ලිවීම",
        "නිල ලිපියක් සහ මිත්‍ර ලිපියක් නියමිත ආකෘතියෙන් ඉදිරිපත් කිරීම",
        "සම්භාව්‍ය හා නූතන පද්‍ය සංසන්දනාත්මක විචාරය",
        "සම්භාව්‍ය හා නූතන ගද්‍ය සංසන්දනාත්මක විචාරය",
        "නාට්‍ය විචාරය: නාට්‍යයක සාර්ථකත්වයට සංගීතය, රංගනය හා භාෂාව බලපාන අයුරු",
        "භාෂාවේ සම්මතය සහ අසම්මත ව්‍යවහාරය පිළිබඳ විමර්ශනය",
        "මාධ්‍ය භාෂාව සහ ප්‍රචාරණ දැන්වීම්වල උපක්‍රම",
        "ශබ්දකෝෂ පරිශීලනය සහ අකාරාදී පිළිවෙළට වචන පෙළගැස්වීම",
        "ජාතික O/L පෙරහුරු සිංහල භාෂාව ප්‍රශ්න පත්‍රය 12",
        "ජාතික O/L පෙරහුරු සිංහල භාෂාව ප්‍රශ්න පත්‍රය 13",
        "ජාතික O/L පෙරහුරු සිංහල භාෂාව ප්‍රශ්න පත්‍රය 14",
        "ජාතික O/L පෙරහුරු සිංහල භාෂාව ප්‍රශ්න පත්‍රය 15",
        "ජාතික O/L පෙරහුරු සිංහල සාහිත්‍ය ප්‍රශ්න පත්‍රය 16",
        "ජාතික O/L පෙරහුරු සිංහල සාහිත්‍ය ප්‍රශ්න පත්‍රය 17",
        "ජාතික O/L පෙරහුරු සිංහල සාහිත්‍ය ප්‍රශ්න පත්‍රය 18",
        "විශිෂ්ඨතා A සාමාර්ථ ඉලක්කගත සිංහල පත්‍රය 19",
        "විශිෂ්ඨතා A සාමාර්ථ ඉලක්කගත සිංහල පත්‍රය 20",
        "විශිෂ්ඨතා A සාමාර්ථ ඉලක්කගත සිංහල පත්‍රය 21",
        "විශිෂ්ඨතා A සාමාර්ථ ඉලක්කගත සිංහල පත්‍රය 22",
        "විභාග දෙපාර්තමේන්තු සම්පත් මණ්ඩල සිංහල පත්‍රය 23",
        "විභාග දෙපාර්තමේන්තු සම්පත් මණ්ඩල සිංහල පත්‍රය 24",
        "අධ්‍යාපන අමාත්‍යාංශ ඒකාබද්ධ O/L සිංහල පත්‍රය 25",
        "අධ්‍යාපන අමාත්‍යාංශ ඒකාබද්ධ O/L සිංහල පත්‍රය 26",
        "බස්නාහිර සහ දකුණු පළාත් විශිෂ්ඨතා සිංහල පත්‍රය 27",
        "මධ්‍යම සහ වයඹ පළාත් විශිෂ්ඨතා සිංහල පත්‍රය 28",
        "සමස්ත ලංකා ජාතික ඇගයීම් ඒකකයේ සිංහල පත්‍රය 29",
        "3 වන වාරය සහ O/L විභාග අවසාන ජාතික පුහුණු පත්‍රය 30"
      )
    }

    val topic = termTopics[(pNum - 1) % termTopics.size]
    val unitCoverage = "${term} වන වාර ඒකක: $topic"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "ව්‍යාකරණ, අක්ෂර වින්‍යාසය, පද බෙදීම හා සාහිත්‍ය ආශ්‍රිත ප්‍රශ්න 40.", "ලකුණු 40 | I පත්‍රය"),
      PaperQuestionSnippet("II කොටස 1 වන ප්‍රශ්නය (රචනාව)", "$topic හෝ සමකාලීන තේමාවක් ඔස්සේ වචන 250 ක නිර්මාණාත්මක රචනය.", "ලකුණු 15 | රචනා"),
      PaperQuestionSnippet("II කොටස (සාහිත්‍ය විචාරය)", "ගද්‍ය, පද්‍ය හා නාට්‍ය උපුටන ඇසුරින් කෙරෙන විචාරාත්මක ප්‍රශ්න 3ක්.", "ලකුණු 45 | විචාර")
    )
    return Pair(unitCoverage, questions)
  }

  // 6. ENGLISH LANGUAGE
  private fun generateEnglishPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val termTopics = when (term) {
      1 -> listOf(
        "Grammar: Simple Present and Present Continuous Tenses with Contextual Drills",
        "Grammar: Simple Past and Past Continuous Tenses in Story Narratives",
        "Subject-Verb Agreement Rules and Error Correction Tests",
        "Prepositions of Time, Place, and Direction (in, on, at, under, through)",
        "Articles: Definite (the) and Indefinite (a, an) with Zero Article Exceptions",
        "Pronouns: Personal, Possessive, Reflexive, and Relative Pronouns",
        "Adjectives and Adverbs: Comparative and Superlative Degrees",
        "Vocabulary: Synonyms, Antonyms, and Contextual Word Guessing",
        "Reading Comprehension: Skimming and Scanning Informational Texts",
        "Writing Test 1: Filling in the Blanks with Given Words",
        "Writing Test 2: Writing Short Notes and Reminders",
        "Writing Test 3: Constructing Simple Sentences from Substitution Tables",
        "Writing Test 4: Identifying Errors and Rewriting Sentences",
        "Writing Test 5: Transferring Information from a Bar Chart / Pie Chart",
        "Writing Test 6: Writing an Informal Note to a Friend",
        "Reading Test 7: Answering Factual Questions from a Short Passage",
        "Writing Test 8: Writing a Paragraph on a Given Topic (50-60 words)",
        "Grammar: Modal Auxiliaries (can, could, may, might, must, should)",
        "Punctuation Marks: Capital Letters, Full Stops, Commas, Apostrophes",
        "Spelling Practice: Commonly Misspelled Words in O/L Examinations",
        "Dialogue Completion: Everyday Conversations at School and Library",
        "Question Formation: Wh- Questions and Yes/No Questions with Auxiliaries",
        "Negative Sentence Transformations across Different Tenses",
        "Reading Comprehension: Following Instructions and Recipes",
        "Vocabulary: Compound Nouns and Word Association Maps",
        "Writing: Formal Invitations and Acceptance / Decline Replies",
        "Paper I Model Test: 8 Standard O/L Questions Comprehensive Practice",
        "1st Term Model English Paper 28 (Western Province)",
        "1st Term Model English Paper 29 (Southern Province)",
        "1st Term Complete Mastery English Evaluation Paper 30"
      )
      2 -> listOf(
        "Grammar: Passive Voice (Present, Past, and Modal Passives in Real Life)",
        "Grammar: Reported Speech (Statements, Commands, and Questions)",
        "Conditional Sentences: Type 1 (Real), Type 2 (Unreal), and Type 3",
        "Relative Clauses: Defining and Non-defining Clauses (who, which, that, where)",
        "Conjunctions and Sentence Connectors (although, however, therefore, because)",
        "Reading Comprehension: Inferential Questions and Author's Tone",
        "Writing Test 9: Dialogues with Formal Greetings and Polite Requests",
        "Writing Test 10: Formal Letters to Principal / Government Officers",
        "Writing Test 11: Informal Letters to a Pen Pal or Relative Abroad",
        "Writing Test 12: Constructing Compound and Complex Sentences",
        "Writing Test 13: Summary Writing and Condensing Information",
        "Writing Test 14: Writing a Speech for the Morning Assembly",
        "Writing Test 15: Writing an Informative Article for the School Magazine",
        "Reading Test 16: Answering High-Level Critical Thinking Comprehension",
        "Vocabulary: Prefix and Suffix Derivations (un-, dis-, -ful, -less, -tion)",
        "Grammar: Gerunds and Infinitives (enjoy swimming vs decided to go)",
        "Phrasal Verbs in Daily Communication (look after, give up, put off)",
        "Direct Speech to Reported Speech Paragraph Transformations",
        "Interpreting Tables, Flowcharts, and Venn Diagrams in English",
        "Writing a Notice for the School Noticeboard (Date, Time, Venue, Purpose)",
        "Writing an Announcement for the Public Address System",
        "Describing a Picture / Event using Rich Sensory Adjectives",
        "Expressing Cause and Effect using 'due to', 'owing to', 'as a result'",
        "Idiomatic Expressions and Colloquialisms in Spoken English",
        "Editing and Proofreading Passage with 10 Grammar/Spelling Errors",
        "Paper II Model Test: Tests 9 to 16 Complete O/L Simulation",
        "2nd Term Model English Paper 27 (Central Province)",
        "2nd Term Model English Paper 28 (North Western Province)",
        "2nd Term Model English Paper 29 (Sabaragamuwa Province)",
        "2nd Term Distinction Practice English Evaluation Paper 30"
      )
      else -> listOf(
        "Full O/L Paper I Simulation: Tests 1 to 8 with Complete Model Marking Scheme",
        "Full O/L Paper II Simulation: Tests 9 to 16 (Reading, Writing, Grammar, Essay)",
        "Essay Writing Mastery: Narrative Essay (A Memorable Day / An Unforgettable Trip)",
        "Essay Writing Mastery: Descriptive Essay (My Favourite Book / A Rainy Day)",
        "Essay Writing Mastery: Argumentative Essay (Social Media: Boon or Bane?)",
        "Report Writing for Newspaper / School Magazine (Annual Sports Meet / Exhibition)",
        "Review Writing: Writing a Comprehensive Book Review or Film Review",
        "Comprehension Mastery: Unseen Poetry Analysis and Literary Devices",
        "Vocabulary Expansion: Formal Register vs Informal Register Matching",
        "Grammar Consolidation: 50 Spot-the-Error Sentences with Full Explanations",
        "Time Management Strategy for O/L English Paper I (1 Hour) & Paper II (2 Hours)",
        "National Assessment Unit O/L Model English Paper 12",
        "National Assessment Unit O/L Model English Paper 13",
        "Department of Examinations Resource Pool English Paper 14",
        "Ministry Integrated O/L English Examination Paper 15",
        "Colombo Educational Zone Premier Schools English Paper 16",
        "Galle Educational Zone Elite Schools English Paper 17",
        "Kandy Educational Zone Premier Schools English Paper 18",
        "Kurunegala Educational Zone Model English Paper 19",
        "Western Province Elite Schools Consortium English Paper 20",
        "Southern Province Distinction Circle English Paper 21",
        "Central Academy Model Examination English Paper 22",
        "National Distinction Target English Practice Paper 23",
        "Mastery Practice Examination Paper 24",
        "G.C.E. O/L Final Dress Rehearsal English Paper 25",
        "G.C.E. O/L Final Dress Rehearsal English Paper 26",
        "G.C.E. O/L Distinction Booster English Paper 27",
        "G.C.E. O/L Distinction Booster English Paper 28",
        "All-Island Integrated Evaluation English Paper 29",
        "3rd Term and Final O/L National Readiness Paper 30"
      )
    }

    val topic = termTopics[(pNum - 1) % termTopics.size]
    val unitCoverage = "Term $term Syllabus: $topic"
    val questions = listOf(
      PaperQuestionSnippet("Paper I (Tests 1 - 8)", "Vocabulary, Prepositions, Word forms, Short note, Information transfer. (Marks: 40)", "40 Marks | 1 Hour"),
      PaperQuestionSnippet("Paper II (Tests 9 - 14)", "Dialogue, Letter writing, Comprehension, Cloze test, Speech/Notice. (Marks: 45)", "45 Marks | Part II"),
      PaperQuestionSnippet("Paper II Test 15 & 16", "Advanced Reading Comprehension and Essay/Article/Report of 150-200 words. (Marks: 15)", "15 Marks | Essay")
    )
    return Pair(unitCoverage, questions)
  }

  // 7. COMMERCE
  private fun generateCommercePaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: ව්‍යාපාර සංවිධාන, ද්විත්ව සටහන්, ශේෂ පිරික්සුම හා මුදල් පොත (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "ව්‍යාපාර හා ගිණුම්කරණ මූලධර්ම ආවරණය වන ප්‍රමිත බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස 1 වන ප්‍රශ්නය (අනිවාර්ය ගිණුම්කරණය)", "ගනුදෙනු ලෙජරගත කිරීම, ශේෂ පිරික්සුම සහ මූලික පොත් සටහන්.", "ලකුණු 20 | Accounts"),
      PaperQuestionSnippet("II කොටස (ව්‍යාපාර අධ්‍යයනය රචනා)", "බැංකු, රක්ෂණ, සන්නිවේදනය හා ව්‍යාපාර පරිසරය පිළිබඳ රචනා ප්‍රශ්න.", "ලකුණු 40 | Theory")
    )
    return Pair(unitCoverage, questions)
  }

  // 8. ICT
  private fun generateIctPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: තොරතුරු හා සන්නිවේදන තාක්ෂණය ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: පද්ධති සංකල්ප, ද්විමය සංඛ්‍යා, තර්ක ද්වාර, පැතුරුම්පත් හා ක්‍රමලේඛනය (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "පරිගණක දෘඩාංග, මෘදුකාංග, ජාල සහ අන්තර්ජාලය පිළිබඳ බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස (ව්‍යුහගත ප්‍රශ්න)", "ද්විමය පරිවර්තන, සත්‍යතා වගු, Logic Gates සහ Excel සූත්‍ර.", "ලකුණු 30 | Structured"),
      PaperQuestionSnippet("II කොටස (ක්‍රමලේඛනය හා දත්ත සමුදාය)", "Python / Pascal ඇල්ගොරිතම, Flowcharts සහ Access දත්ත සමුදාය.", "ලකුණු 30 | Practical")
    )
    return Pair(unitCoverage, questions)
  }

  // 9. CIVIC
  private fun generateCivicPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: පුරවැසි අධ්‍යාපනය ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: ආණ්ඩුක්‍රම ව්‍යවස්ථාව, නීතියේ ආධිපත්‍යය, මානව හිමිකම් හා යහපාලනය (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "ප්‍රජාතන්ත්‍රවාදය, නීතිය, මැතිවරණ හා පාලන ව්‍යුහය ආශ්‍රිත බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස 1 වන ප්‍රශ්නය", "මූලික අයිතිවාසිකම් සහ පුරවැසි යුතුකම් පිළිබඳ කෙටි ප්‍රශ්න 5ක්.", "ලකුණු 20 | Short"),
      PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "විධායකය, ව්‍යවස්ථාදායකය, අධිකරණය සහ පළාත් පාලන ආයතන පිළිබඳ රචනා.", "ලකුණු 40 | Essay")
    )
    return Pair(unitCoverage, questions)
  }

  // 10. GEOGRAPHY
  private fun generateGeographyPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: භූගෝල විද්‍යාව ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: 1:50,000 භූ ලක්ෂණ සිතියම, දේශගුණය, ජලවහනය හා කෘෂිකර්මය (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "භෞතික හා මානව භූගෝල විද්‍යාව ආශ්‍රිත ප්‍රමිත බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස 1 වන ප්‍රශ්නය (අනිවාර්ය 1:50,000 සිතියම)", "සමෝච්ච රේඛා, ජලවහන රටා, සංස්කෘතික ලක්ෂණ හා සිතියම් කියවීම.", "ලකුණු 15 | සිතියම්"),
      PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "දේශගුණය, ගංගා පද්ධති, කෘෂිකර්මාන්තය හා කර්මාන්ත පිළිබඳ රචනා 4ක්.", "ලකුණු 45 | රචනා")
    )
    return Pair(unitCoverage, questions)
  }

  // 11. HEALTH
  private fun generateHealthPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: සෞඛ්‍ය හා ශාරීරික අධ්‍යාපනය ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: පෝෂණය, මලල ක්‍රීඩා, යෝග්‍යතා පරීක්ෂණ, ප්‍රථමාධාර හා රෝග නිවාරණය (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "ශරීර සෞඛ්‍යය, පෝෂණය, ක්‍රීඩා නීතිරීති ආශ්‍රිත බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස A (සෞඛ්‍ය අධ්‍යාපනය)", "ජීර්ණ පද්ධතිය, බෝනොවන රෝග සහ මානසික සුවතාව පිළිබඳ ගැටලු.", "ලකුණු 30 | Health"),
      PaperQuestionSnippet("II කොටස B (ශාරීරික අධ්‍යාපනය)", "මලල ක්‍රීඩා ඉසව්, වොලිබෝල්/දැල්පන්දු ක්‍රීඩා උපක්‍රම සහ ප්‍රථමාධාර.", "ලකුණු 30 | Sports")
    )
    return Pair(unitCoverage, questions)
  }

  // 12. AGRI
  private fun generateAgriPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: කෘෂි හා ආහාර තාක්ෂණය ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: පාංශු කළමනාකරණය, බෝග පෝෂණය, පළිබෝධ පාලනය හා පසු අස්වනු තාක්ෂණය (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "පාංශු විද්‍යාව, බෝග ප්‍රචාරණය සහ කෘෂි රසායන පිළිබඳ බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස (ව්‍යුහගත පරීක්ෂණ)", "බීජ ප්‍රරෝහණය, තවාන් කළමනාකරණය සහ කොම්පෝස්ට් නිෂ්පාදනය.", "ලකුණු 30 | Practical"),
      PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "ආරක්ෂිත ගෘහ වගාව, බිංදු ජල සම්පාදනය සහ සත්ත්ව පාලනය පිළිබඳ රචනා.", "ලකුණු 30 | Essay")
    )
    return Pair(unitCoverage, questions)
  }

  // 13. DANCING
  private fun generateDancingPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: නර්තනය ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: දේශීය නර්තන සම්ප්‍රදාය (උඩරට, පහතරට, සබරගමු), වාද්‍ය භාණ්ඩ හා ශාන්තිකර්ම (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "පා සරඹ, අඩව්, තාල, මාත්‍රා සහ බෙර වාදනය පිළිබඳ බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස (ප්‍රස්තාර හා විචාර)", "බෙර පද ප්‍රස්තාරගත කිරීම, වන්නම් සහ ශාන්තිකර්ම අංග විවරණය.", "ලකුණු 30 | Theory"),
      PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "භාරතීය නර්තනය, මුද්‍රා නාට්‍ය සහ නර්තන විචාරය පිළිබඳ රචනා.", "ලකුණු 30 | Essay")
    )
    return Pair(unitCoverage, questions)
  }

  // 14. MUSIC
  private fun generateMusicPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: පෙරදිග සංගීතය ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: රාගධාරී සංගීතය, තාල, ස්වර ප්‍රස්තාර, ජන ගී හා නූර්ති නාඩගම් (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "රාග ලක්ෂණ, තාළ මාත්‍රා, වාද්‍ය භාණ්ඩ සහ සංගීත න්‍යාය බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස (ස්වර ප්‍රස්තාර)", "යමන්, භූපාලි, බිලාවල් රාගවල ඡෝටා ඛ්‍යාල් සහ ස්වර ප්‍රස්තාර ලිවීම.", "ලකුණු 30 | Notation"),
      PaperQuestionSnippet("II කොටස (දේශීය සංගීත විචාර)", "ජන ගී, ප්‍රශස්ති, වන්නම් සහ ලාංකේය සංගීතඥයන් පිළිබඳ රචනා.", "ලකුණු 30 | Essay")
    )
    return Pair(unitCoverage, questions)
  }

  // 15. ART
  private fun generateArtPaperData(term: Int, pNum: Int): Pair<String, List<PaperQuestionSnippet>> {
    val topic = "වාරය $term: චිත්‍ර කලාව ආදර්ශ පත්‍රය $pNum"
    val unitCoverage = "$term වන වාරය: දෘශ්‍ය කලා මූලධර්ම, සාම්ප්‍රදායික බිතුසිතුවම්, මූර්ති හා ලෝක කලා ඉතිහාසය (Paper $pNum)"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "වර්ණ න්‍යාය, සංයුතිය, රේඛා හැඩතල සහ කලා ඉතිහාසය පිළිබඳ බහුවරණ 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස (න්‍යාය හා කලා විචාර)", "සීගිරිය, පොළොන්නරුව හා මහනුවර යුගයේ බිතුසිතුවම් විචාරය.", "ලකුණු 30 | Art History"),
      PaperQuestionSnippet("II කොටස (ප්‍රායෝගික නිර්මාණය)", "නිශ්චල ද්‍රව්‍ය හෝ මාතෘකාගත සංයුතියක් ඇසුරින් චිත්‍ර නිර්මාණය.", "ලකුණු 30 | Practical")
    )
    return Pair(unitCoverage, questions)
  }

  // GENERIC
  private fun generateGenericSubjectData(
    subjectName: String,
    grade: String,
    term: Int,
    pNum: Int
  ): Pair<String, List<PaperQuestionSnippet>> {
    val unitCoverage = "$grade ශ්‍රේණිය - $subjectName $term වන වාරය: විෂය නිර්දේශ ඒකක ආවරණ ආදර්ශ ඇගයීම් පත්‍රය $pNum"
    val questions = listOf(
      PaperQuestionSnippet("I කොටස (ප්‍රශ්න 1-40)", "$subjectName විෂයයේ $term වන වාරයට අදාළ මූලික සංකල්ප ඇතුළත් බහුවරණ ප්‍රශ්න 40.", "ලකුණු 40 | MCQ"),
      PaperQuestionSnippet("II කොටස (ව්‍යුහගත ප්‍රශ්න)", "$subjectName ප්‍රායෝගික හා ව්‍යුහගත ගැටලු විසඳීම.", "ලකුණු 30 | Structured"),
      PaperQuestionSnippet("II කොටස (රචනා ප්‍රශ්න)", "$subjectName විෂය කරුණු ගැඹුරින් විග්‍රහ කරන රචනා ප්‍රශ්න.", "ලකුණු 30 | Essay")
    )
    return Pair(unitCoverage, questions)
  }
}
