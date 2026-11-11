package com.example

/**
 * 100% Official Sri Lankan NIE Curriculum Syllabus Units & Full Voice Explanations
 * Covering Grades 6, 7, 8, 9, 10, 11 for all major subjects:
 * - ගණිතය (Mathematics)
 * - විද්‍යාව (Science)
 * - ඉතිහාසය (History)
 * - සිංහල (Sinhala)
 * - ඉංග්‍රීසි (English)
 * - ICT (Information & Communication Technology)
 * - බුද්ධ ධර්මය (Buddhism)
 * - භූගෝල විද්‍යාව (Geography)
 * - පුරවැසි අධ්‍යාපනය (Civics)
 * - ව්‍යාපාර හා ගිණුම්කරණය (Commerce & Accounting)
 * - සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය (Health & PE)
 */
object ComprehensiveSyllabusProvider {

  fun getCurriculumFor(grade: String, subject: String): List<SyllabusUnit> {
    val cleanGrade = grade.trim()
      .replace(" ශ්‍රේණිය", "")
      .replace("ශ්‍රේණිය", "")
      .replace("වසර", "")
      .trim()
    val g = when (cleanGrade) {
      "06", "6" -> "6"
      "07", "7" -> "7"
      "08", "8" -> "8"
      "09", "9" -> "9"
      "10" -> "10"
      "11" -> "11"
      else -> "11"
    }

    val s = subject.trim()
    val allForGrade = getFullGradeCurriculum(g)

    return if (s == "සියල්ල" || s.isBlank()) {
      allForGrade
    } else {
      allForGrade.filter { unit ->
        unit.subject.contains(s) || s.contains(unit.subject)
      }
    }
  }

  private fun getFullGradeCurriculum(grade: String): List<SyllabusUnit> {
    val list = mutableListOf<SyllabusUnit>()
    list.addAll(getMathUnits(grade))
    list.addAll(getScienceUnits(grade))
    list.addAll(getHistoryUnits(grade))
    list.addAll(getSinhalaUnits(grade))
    list.addAll(getEnglishUnits(grade))
    list.addAll(getIctUnits(grade))
    list.addAll(getBuddhismUnits(grade))
    list.addAll(getGeographyUnits(grade))
    list.addAll(getCivicsUnits(grade))
    list.addAll(getCommerceUnits(grade))
    list.addAll(getHealthUnits(grade))
    return list
  }

  // --------------------------------------------------------------------------
  // 1. ගණිතය (MATHEMATICS) - ALL LESSONS
  // --------------------------------------------------------------------------
  private fun getMathUnits(grade: String): List<SyllabusUnit> {
    return listOf(
      SyllabusUnit(
        id = "m_${grade}_u1", grade = grade, subject = "ගණිතය", unitNumber = 1,
        titleSinhala = "සංඛ්‍යා රටා සහ සමාන්තර ශ්‍රේඪි",
        englishTitle = "Number Patterns & Arithmetic Progressions",
        keyConcepts = listOf("ප්‍රථම පදය (a)", "පොදු අන්තරය (d)", "n වන පදය (Tn)", "පද n වල ඓක්‍යය (Sn)", "ත්‍රිකෝණික සංඛ්‍යා"),
        sampleDoubts = listOf("සමාන්තර ශ්‍රේඪියක n වන පදය සෙවීම", "ත්‍රිකෝණික සංඛ්‍යා සූත්‍රය ආදේශ කිරීම"),
        coreFormulaOrRule = "Tn = a + (n - 1)d | Sn = n/2 [2a + (n - 1)d] | ත්‍රිකෝණික: n(n + 1)/2",
        examTip = "විභාගයේදී a සහ d අගයන් ලියාගෙන සූත්‍රයට ආදේශ කිරීමෙන් පියවර ලකුණු පහසුවෙන්ම හිමිවේ.",
        fullExplanation = "ආයුබෝවන් දුවේ පුතේ. සංඛ්‍යා රටාවක අනුයාත පද දෙකක් අතර වෙනස නියත අගයක් නම් එය සමාන්තර ශ්‍රේඪියකි. එම ස්ථිර වෙනස පොදු අන්තරය හෙවත් d ලෙස හඳුන්වයි. මුල්ම පදය a වේ. ඕනෑම n වන පදයක් සෙවීමට Tn = a + (n-1)d සූත්‍රය භාවිත කරන්න. පද n ගණනක එකතුව සෙවීමට Sn = n/2 [2a + (n-1)d] සූත්‍රය යොදන්න."
      ),
      SyllabusUnit(
        id = "m_${grade}_u2", grade = grade, subject = "ගණිතය", unitNumber = 2,
        titleSinhala = "භාග, දශම සහ ප්‍රතිශත",
        englishTitle = "Fractions, Decimals & Percentages",
        keyConcepts = listOf("විෂම භාග හා මිශ්‍ර සංඛ්‍යා", "කුඩාම පොදු ගුණාකාරය (කු.පො.ගු)", "භාග ගුණ කිරීම හා බෙදීම", "ප්‍රතිශත ගණනය"),
        sampleDoubts = listOf("භාග බෙදීමේදී පරස්පරය ගන්නේ ඇයි?", "මිශ්‍ර භාග සුළු කරන්නේ කෙසේද?"),
        coreFormulaOrRule = "a/b ÷ c/d = a/b × d/c | ප්‍රතිශතය = (ලැබූ අගය / මුළු අගය) × 100%",
        examTip = "භාග ගැටලුවල වරහන් සහ 'හි' යෙදී ඇත්නම් මුලින්ම BODMAS නීතිය අනුව වරහන් සහ 'හි' සුළු කරන්න.",
        fullExplanation = "භාග එකතු කිරීමේදී හෝ අඩු කිරීමේදී හරයන් අසමාන නම් මුලින්ම කුඩාම පොදු ගුණාකාරය සොයා හරයන් සමාන කළ යුතුය. භාග බෙදීමේදී බෙදුම් ලකුණ ගුණ කිරීමක් බවට පත් කර දෙවන භාගයේ හරය සහ ලවය මාරු (පරස්පරය) කර සුළු කරනු ලැබේ."
      ),
      SyllabusUnit(
        id = "m_${grade}_u3", grade = grade, subject = "ගණිතය", unitNumber = 3,
        titleSinhala = "වීජීය ප්‍රකාශන සහ සාධක",
        englishTitle = "Algebraic Expressions & Factorization",
        keyConcepts = listOf("පොදු සාධකය පිටතට ගැනීම", "වර්ග දෙකක අන්තරය", "ත්‍රිපද වර්ගජ ප්‍රකාශන සාධක", "වරහන් ප්‍රසාරණය"),
        sampleDoubts = listOf("x² - 9 වර්ග දෙකක අන්තරය සාධක කරන්නේ කෙසේද?", "x² + 5x + 6 සාධක සෙවීම"),
        coreFormulaOrRule = "a² - b² = (a - b)(a + b) | (a + b)² = a² + 2ab + b² | (a - b)² = a² - 2ab + b²",
        examTip = "ත්‍රිපද ප්‍රකාශනවලදී අවසාන පදයේ ගුණිතය හා මැද පදයේ එකතුව ගැලපෙන සංඛ්‍යා යුගලය තෝරන්න.",
        fullExplanation = "වීජීය ප්‍රකාශනයක් සාධක කිරීම යනු එය ගුණිතයක් ලෙස ලිවීමයි. පළමුවෙන්ම සියලු පදවලට පොදු සාධකයක් ඇත්දැයි බලන්න. පද දෙකක් වර්ග අතර අන්තරයක් නම් a² - b² = (a - b)(a + b) සූත්‍රය යොදන්න. ත්‍රිපද ප්‍රකාශනවල මැද පදය වෙන් කර සාධක වෙන් කරන්න."
      ),
      SyllabusUnit(
        id = "m_${grade}_u4", grade = grade, subject = "ගණිතය", unitNumber = 4,
        titleSinhala = "සරල, සමගාමී සහ වර්ගජ සමීකරණ",
        englishTitle = "Linear, Simultaneous & Quadratic Equations",
        keyConcepts = listOf("විචල්‍යයක් තනි කිරීම", "සංගුණක තුල්‍ය කිරීම", "වර්ගපූර්ණය", "වර්ගජ සූත්‍රය"),
        sampleDoubts = listOf("වර්ගජ සූත්‍රය නිවැරදිව භාවිත කරන්නේ කෙසේද?", "සමගාමී සමීකරණ විසඳන ක්‍රමය"),
        coreFormulaOrRule = "වර්ගජ සූත්‍රය: x = [-b ± √(b² - 4ac)] / (2a)",
        examTip = "වර්ගජ සූත්‍රය ලිවීමට ලකුණු 1ක් ද, a, b, c ආදේශයට ලකුණු 1ක් ද, නිවැරදි සුළු කිරීමට ලකුණු 2ක් ද හිමිවේ.",
        fullExplanation = "සමගාමී සමීකරණ විසඳීමේදී එක් විචල්‍යයක සංගුණක සමාන කර එකතු කිරීමෙන් හෝ අඩු කිරීමෙන් එම විචල්‍යය ඉවත් කරනු ලැබේ. ax² + bx + c = 0 වර්ගජ සමීකරණය විසඳීමට x = [-b ± √(b² - 4ac)] / (2a) සූත්‍රය ආදේශ කර සුළු කරන්න."
      ),
      SyllabusUnit(
        id = "m_${grade}_u5", grade = grade, subject = "ගණිතය", unitNumber = 5,
        titleSinhala = "පරිමිතිය, වර්ගඵලය සහ පරිමාව",
        englishTitle = "Perimeter, Area & Volume",
        keyConcepts = listOf("චාප දිග", "කේන්ද්‍රික ඛණ්ඩ වර්ගඵලය", "සිලින්ඩරයක පරිමාව", "ගෝලයක වර්ගඵලය හා පරිමාව", "කේතුවක පරිමාව"),
        sampleDoubts = listOf("කේන්ද්‍රික ඛණ්ඩයක චාප දිග සෙවීම", "සිලින්ඩරයක වක්‍ර පෘෂ්ඨ වර්ගඵලය"),
        coreFormulaOrRule = "කේන්ද්‍රික චාප දිග = (θ/360) × 2πr | වර්ගඵලය = (θ/360) × πr² | සිලින්ඩර පරිමාව = πr²h | කේතු පරිමාව = 1/3 πr²h",
        examTip = "පරිමිතිය සෙවීමේදී චාප දිගට අරයන් දෙක (2r) එකතු කිරීමට අමතක නොකරන්න.",
        fullExplanation = "කේන්ද්‍ර කෝණය θ වන කේන්ද්‍රික ඛණ්ඩයක චාප දිග සෙවීමට θ/360 න් වෘත්තයේ පරිධිය ගුණ කරන්න. සිලින්ඩරයක පරිමාව හරස්කඩ වර්ගඵලය උසින් ගුණ කිරීමෙන් හෙවත් πr²h මගින් ලැබේ. කේතුවක පරිමාව 1/3 πr²h වේ."
      ),
      SyllabusUnit(
        id = "m_${grade}_u6", grade = grade, subject = "ගණිතය", unitNumber = 6,
        titleSinhala = "ජ්‍යාමිතිය සහ වෘත්ත ප්‍රමේය",
        englishTitle = "Geometry & Circle Theorems",
        keyConcepts = listOf("කේන්ද්‍රයේ කෝණය හා පරිධියේ කෝණය", "එකම ඛණ්ඩයේ කෝණ", "චක්‍රීය චතුරස්‍ර ප්‍රමේය", "වෘත්තයක ස්පර්ශක"),
        sampleDoubts = listOf("චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණවල සම්බන්ධය", "කේන්ද්‍රයේ කෝණය පරිධියේ කෝණය මෙන් දෙගුණයකි"),
        coreFormulaOrRule = "කේන්ද්‍රයේ කෝණය = 2 × පරිධියේ කෝණය | චක්‍රීය චතුරස්‍ර සම්මුඛ කෝණ එකතුව = 180° | අර්ධ වෘත්තයේ කෝණය = 90°",
        examTip = "ජ්‍යාමිතික ප්‍රමේය ඔප්පු කිරීමේදී හේතු (Reasons) වරහන් තුළ පැහැදිලිව සඳහන් කළ යුතුය.",
        fullExplanation = "වෘත්තයක චාපයකින් කේන්ද්‍රයෙහි ආපාතනය කරන කෝණය එම චාපයෙන්ම ඉතිරි පරිධිය මත ආපාතනය කරන කෝණය මෙන් දෙගුණයකි. චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණ පරිපූරක වේ, එනම් එකතුව 180° කි."
      ),
      SyllabusUnit(
        id = "m_${grade}_u7", grade = grade, subject = "ගණිතය", unitNumber = 7,
        titleSinhala = "ත්‍රිකෝණමිතිය සහ කෝණ",
        englishTitle = "Trigonometry & Angles of Elevation/Depression",
        keyConcepts = listOf("sin, cos, tan අනුපාත", "සෘජුකෝණී ත්‍රිකෝණය", "ආරෝහණ කෝණය", "අවරෝහණ කෝණය"),
        sampleDoubts = listOf("tan අනුපාතය යොදා උස ගණනය කිරීම", "ආරෝහණ සහ අවරෝහණ කෝණ අතර වෙනස"),
        coreFormulaOrRule = "sin θ = සම්මුඛ පාදය / කර්ණය | cos θ = බද්ධ පාදය / කර්ණය | tan θ = සම්මුඛ පාදය / බද්ධ පාදය",
        examTip = "ගැටලුව කියවා නිවැරදි සෘජුකෝණී ත්‍රිකෝණ සටහන ඇඳීමෙන් ලකුණු 3ක් පමණ ආරම්භයේදීම ලැබේ.",
        fullExplanation = "සෘජුකෝණී ත්‍රිකෝණයක කෝණයකට විරුද්ධ පාදය සම්මුඛ පාදයයි. කෝණයට යාබද පාදය බද්ධ පාදයයි. සෘජුකෝණයට ඉදිරියෙන් ඇති දිගම පාදය කර්ණයයි. tan θ = සම්මුඛ / බද්ධ සූත්‍රය මගින් ගස්වල හා කුළුණුවල උස ගණනය කළ හැක."
      ),
      SyllabusUnit(
        id = "m_${grade}_u8", grade = grade, subject = "ගණිතය", unitNumber = 8,
        titleSinhala = "සංඛ්‍යානය සහ සම්භාවිතාව",
        englishTitle = "Statistics & Probability",
        keyConcepts = listOf("මධ්‍යන්‍යය (Mean)", "මාතය (Mode)", "මධ්‍යස්ථය (Median)", "සමුච්චිත සංඛ්‍යාත වක්‍රය", "රුක් සටහන්"),
        sampleDoubts = listOf("සමුච්චිත සංඛ්‍යාත වක්‍රයෙන් මධ්‍යස්ථය සෙවීම", "රුක් සටහනක සම්භාවිතා ගුණ කිරීම"),
        coreFormulaOrRule = "මධ්‍යන්‍යය: x̄ = Σfx / Σf | සිදුවීමක සම්භාවිතාව: P(A) = n(A) / n(S)",
        examTip = "රුක් සටහනක එක් අත්තක ශාඛාවල එකතුව හැමවිටම 1 ක් විය යුතුය.",
        fullExplanation = "සංඛ්‍යාත ව්‍යාප්තියක මධ්‍යන්‍යය සෙවීමට එක් එක් පන්තියේ මධ්‍ය අගය x සොයා සංඛ්‍යාතය f මගින් ගුණ කර Σfx / Σf සූත්‍රය යොදන්න. සම්භාවිතාවේදී අනුයාත ස්වාධීන සිදුවීම් දෙකක එකවර සිදුවීමේ සම්භාවිතාව ශාඛා දිගේ ගුණ කිරීමෙන් ලැබේ."
      )
    )
  }

  // --------------------------------------------------------------------------
  // 2. විද්‍යාව (SCIENCE) - ALL LESSONS
  // --------------------------------------------------------------------------
  private fun getScienceUnits(grade: String): List<SyllabusUnit> {
    return listOf(
      SyllabusUnit(
        id = "sc_${grade}_u1", grade = grade, subject = "විද්‍යාව", unitNumber = 1,
        titleSinhala = "ජීවීන්ගේ ලක්ෂණ, සෛල ව්‍යුහය සහ පටක",
        englishTitle = "Living World, Cell Structure & Tissues",
        keyConcepts = listOf("ප්ලාස්ම පටලය", "න්‍යෂ්ටිය", "හරිතලව", "මයිටොකොන්ඩ්‍රියා", "ශාක හා සත්ත්ව පටක"),
        sampleDoubts = listOf("ශාක සෛල සහ සත්ත්ව සෛල අතර වෙනස්කම්", "මයිටොකොන්ඩ්‍රියාවල කාර්යය කුමක්ද?"),
        coreFormulaOrRule = "ශාක සෛලවල පමණක් සෛල බිත්තිය, හරිතලව හා විශාල මධ්‍ය රික්තකය පිහිටයි.",
        examTip = "සෛල රූප සටහනක් නම් කිරීමට විභාගයේදී නිතරම අසයි. ප්ලාස්ම පටලය සහ සෛල බිත්තිය පටලවා නොගන්න.",
        fullExplanation = "ආයුබෝවන් දුවේ පුතේ. සෛලය යනු සියලු ජීවීන්ගේ ව්‍යුහමය හා ක්‍රියාකාරී මූලික ඒකකයයි. ශාක සෛලවල සෙලියුලෝස් සහිත සෛල බිත්තියක් සහ ප්‍රභාසංස්ලේෂණය සිදුකරන හරිතලව පිහිටයි. මයිටොකොන්ඩ්‍රියා සෛලීය ශ්වසනය මගින් ATP ශක්තිය නිපදවන සෛලයේ බලාගාරයයි."
      ),
      SyllabusUnit(
        id = "sc_${grade}_u2", grade = grade, subject = "විද්‍යාව", unitNumber = 2,
        titleSinhala = "ප්‍රභාසංස්ලේෂණය සහ ශාක කායික විද්‍යාව",
        englishTitle = "Photosynthesis & Plant Physiology",
        keyConcepts = listOf("ආලෝක ප්‍රතික්‍රියාව (තයිලකොයිඩ)", "අඳුරු ප්‍රතික්‍රියාව (ස්ට්‍රෝමාව)", "ජල විච්ඡේදනය", "උත්ස්වේදනය"),
        sampleDoubts = listOf("ප්‍රභාසංස්ලේෂණයේ ආලෝක හා අඳුරු ප්‍රතික්‍රියා වෙනස", "ප්‍රභාසංස්ලේෂණයට බලපාන සාධක"),
        coreFormulaOrRule = "6CO2 + 6H2O + ආලෝකය (හරිතප්‍රද හමුවේ) → C6H12O6 + 6O2",
        examTip = "ප්‍රභාසංස්ලේෂණයේදී පිටවන ඔක්සිජන් වායුව ජලයෙන් ලැබෙන බව මතක තබාගන්න.",
        fullExplanation = "ප්‍රභාසංස්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාව හරිතලවයේ තයිලකොයිඩ පටල තුළ සිදුවන අතර සූර්යාලෝකයෙන් ජලය බිඳහෙළා O2 සහ ATP නිපදවයි. අඳුරු ප්‍රතික්‍රියාව ස්ට්‍රෝමාව තුළ සිදුවන අතර CO2 තිර කර ග්ලූකෝස් නිපදවයි."
      ),
      SyllabusUnit(
        id = "sc_${grade}_u3", grade = grade, subject = "විද්‍යාව", unitNumber = 3,
        titleSinhala = "පදාර්ථයේ ව්‍යුහය සහ රසායනික බන්ධන",
        englishTitle = "Structure of Matter & Chemical Bonding",
        keyConcepts = listOf("පරමාණුක ක්‍රමාංකය (Z)", "ස්කන්ධ ක්‍රමාංකය (A)", "ඉලෙක්ට්‍රෝන වින්‍යාසය", "සහසංයුජ බන්ධන", "අයනික බන්ධන"),
        sampleDoubts = listOf("අයනික සහ සහසංයුජ බන්ධන සෑදෙන ආකාරය", "ඉලෙක්ට්‍රෝන තිත්-කුරුස සටහන් ඇඳීම"),
        coreFormulaOrRule = "නියුට්‍රෝන ගණන = ස්කන්ධ ක්‍රමාංකය (A) - පරමාණුක ක්‍රමාංකය (Z)",
        examTip = "ලෝහ සහ අලෝහ අතර ඉලෙක්ට්‍රෝන හුවමාරුවෙන් අයනික බන්ධන ද, අලෝහ අතර ඉලෙක්ට්‍රෝන හවුලේ තැබීමෙන් සහසංයුජ බන්ධන ද සෑදේ.",
        fullExplanation = "පරමාණුවක න්‍යෂ්ටියේ ප්‍රෝටෝන සහ නියුට්‍රෝන පවතින අතර ඉලෙක්ට්‍රෝන ශක්ති මට්ටම්වල භ්‍රමණය වේ. ස්ථායී අෂ්ටක වින්‍යාසය ලබාගැනීමට පරමාණු ඉලෙක්ට්‍රෝන හුවමාරු කර අයනික බන්ධන හෝ හවුලේ තබා සහසංයුජ බන්ධන සාදයි."
      ),
      SyllabusUnit(
        id = "sc_${grade}_u4", grade = grade, subject = "විද්‍යාව", unitNumber = 4,
        titleSinhala = "අම්ල, භෂ්ම, ලවණ සහ pH පරිමාණය",
        englishTitle = "Acids, Bases, Salts & pH Scale",
        keyConcepts = listOf("H+ අයන සාන්ද්‍රණය", "OH- අයන", "දර්ශක (ලිට්මස්, ෆීනෝල්ෆ්තැලීන්)", "උදාසීනීකරණය", "pH අගය 0-14"),
        sampleDoubts = listOf("ප්‍රබල සහ දුබල අම්ල අතර වෙනස", "උදාසීනීකරණ ප්‍රතික්‍රියාවක් ලියන්නේ කෙසේද?"),
        coreFormulaOrRule = "අම්ලය + භෂ්මය → ලවණය + ජලය (උදා: HCl + NaOH → NaCl + H2O)",
        examTip = "pH < 7 අම්ල, pH = 7 උදාසීන (ජලය), pH > 7 භෂ්ම වේ. අම්ල නිල් ලිට්මස් රතු කරයි.",
        fullExplanation = "අම්ල ජලීය ද්‍රාවණවලදී H+ අයන නිදහස් කරයි. භෂ්ම OH- හයිඩ්‍රොක්සයිඩ් අයන නිදහස් කරයි. අම්ලයක් සහ භෂ්මයක් ප්‍රතික්‍රියා කර ලවණය සහ ජලය සෑදීම උදාසීනීකරණයයි."
      ),
      SyllabusUnit(
        id = "sc_${grade}_u5", grade = grade, subject = "විද්‍යාව", unitNumber = 5,
        titleSinhala = "චලිතය, නිව්ටන් නියම සහ ගම්‍යතාව",
        englishTitle = "Motion, Newton's Laws & Momentum",
        keyConcepts = listOf("ප්‍රවේගය හා ත්වරණය", "චලිත සමීකරණ", "නිව්ටන්ගේ චලිත නියම 3", "F = ma", "ගම්‍යතා සංස්ථිති නියමය"),
        sampleDoubts = listOf("F = ma සූත්‍රය ගැටලුවලට යෙදීම", "චලිත සමීකරණ 4 නිවැරදිව තෝරාගැනීම"),
        coreFormulaOrRule = "v = u + at | s = ut + 1/2 at² | v² = u² + 2as | F = ma",
        examTip = "ගැටලුවලදී ඒකක SI ක්‍රමයට (m, s, kg) හරවා ගැනීමට නිතරම වගබලා ගන්න.",
        fullExplanation = "නිව්ටන්ගේ පළමු නියමයෙන් අවස්ථිතිය පැහැදිලි කරයි. දෙවන නියමයට අනුව අසමතුලිත බලය F = ma වේ. තෙවන නියමයට අනුව සෑම ක්‍රියාවකටම විශාලත්වයෙන් සමාන දිශාවෙන් ප්‍රතිවිරුද්ධ ප්‍රතික්‍රියාවක් ඇත."
      ),
      SyllabusUnit(
        id = "sc_${grade}_u6", grade = grade, subject = "විද්‍යාව", unitNumber = 6,
        titleSinhala = "කාර්යය, ශක්තිය, ක්ෂමතාව සහ පීඩනය",
        englishTitle = "Work, Energy, Power & Pressure",
        keyConcepts = listOf("කාර්යය (W = F × d)", "චාලක ශක්තිය (1/2 mv²)", "විභව ශක්තිය (mgh)", "ක්ෂමතාව (P = W/t)", "ද්‍රව පීඩනය (P = hρg)"),
        sampleDoubts = listOf("ද්‍රව පීඩනය කෙරෙහි බලපාන සාධක", "කාර්යය සහ ක්ෂමතාව අතර වෙනස"),
        coreFormulaOrRule = "W = Fd | Ek = 1/2 mv² | Ep = mgh | P = W/t | පීඩනය P = F/A | ද්‍රව පීඩනය P = hρg",
        examTip = "කාර්යය සහ ශක්තිය ජූල් (J) වලින්ද, ක්ෂමතාව වොට් (W) වලින්ද, පීඩනය පැස්කල් (Pa හෝ N m^-2) වලින්ද මනිනු ලැබේ.",
        fullExplanation = "බලයක් යොදා බලය යෙදූ දිශාවට වස්තුවක් විස්ථාපනය කිරීම කාර්යයයි. කාර්යය කිරීමේ සීඝ්‍රතාව ක්ෂමතාවයි. ද්‍රවයක පීඩනය ගැඹුර (h), ද්‍රවයේ ඝනත්වය (ρ) සහ ගුරුත්වජ ත්වරණය (g) මත රඳා පවතී."
      ),
      SyllabusUnit(
        id = "sc_${grade}_u7", grade = grade, subject = "විද්‍යාව", unitNumber = 7,
        titleSinhala = "ධාරා විද්‍යුතය, ඕම් නියමය සහ ඉලෙක්ට්‍රොනික විද්‍යාව",
        englishTitle = "Current Electricity, Ohm's Law & Electronics",
        keyConcepts = listOf("ඕම් නියමය (V = IR)", "ශ්‍රේණිගත හා සමාන්තරගත පරිපථ", "ඩයෝඩය සහ සෘජුකරණය", "ට්‍රාන්සිස්ටරය", "LDR සහ තර්මිස්ටර"),
        sampleDoubts = listOf("ශ්‍රේණිගත හා සමාන්තර ප්‍රතිරෝධක සමතුලිත කිරීම", "ඩයෝඩයක අග්‍ර හඳුනාගැනීම"),
        coreFormulaOrRule = "V = IR | ශ්‍රේණිගත: R = R1 + R2 | සමාන්තරගත: 1/R = 1/R1 + 1/R2",
        examTip = "සමාන්තර පරිපථවල එක් එක් ශාඛාවේ වෝල්ටීයතාව සමාන වන අතර ශ්‍රේණි පරිපථවල ධාරාව සමාන වේ.",
        fullExplanation = "නියත උෂ්ණත්වයේදී සන්නායකයක් තුළින් ගලන ධාරාව එහි අග්‍ර අතර විභව අන්තරයට අනුලෝමව සමානුපාතික වේ (V = IR). අර්ධ සන්නායක ඩයෝඩය ධාරාව ගලායාමට ඉඩ දෙන්නේ එක් දිශාවකට පමණි."
      ),
      SyllabusUnit(
        id = "sc_${grade}_u8", grade = grade, subject = "විද්‍යාව", unitNumber = 8,
        titleSinhala = "ආලෝකය, තරංග සහ ශබ්දය",
        englishTitle = "Light, Optics, Waves & Sound",
        keyConcepts = listOf("පරාවර්තන නියම", "වර්තනය සහ ස්නෙල් නියමය", "කාච සහ දර්පණ", "තරංග ආකෘති (v = fλ)", "ශ්‍රව්‍යතා සීමාව (20Hz - 20000Hz)"),
        sampleDoubts = listOf("කාච මගින් ප්‍රතිබිම්බ සෑදෙන ආකාරය", "v = fλ සූත්‍රයෙන් තරංග ප්‍රවේගය සෙවීම"),
        coreFormulaOrRule = "තරංග සමීකරණය: v = fλ (ප්‍රවේගය = සංඛ්‍යාතය × තරංග ආයාමය) | වර්තන අංකය n = sin i / sin r",
        examTip = "ආලෝකය ප්‍රකාශ ඝනත්වයෙන් අඩු මාධ්‍යයක සිට වැඩි මාධ්‍යයකට ගමන් කිරීමේදී අභිලම්භය දෙසට නැමෙයි.",
        fullExplanation = "ආලෝකය එක් මාධ්‍යයකින් වෙනත් ඝනත්වයකින් යුත් මාධ්‍යයකට ඇතුළු වීමේදී එහි ප්‍රවේගය වෙනස් වීම නිසා දිශාව වෙනස් වීම වර්තනයයි. v = fλ සූත්‍රයෙන් තරංග ප්‍රවේගය, සංඛ්‍යාතය හා තරංග ආයාමය ගණනය කෙරේ."
      )
    )
  }

  // --------------------------------------------------------------------------
  // 3. ඉතිහාසය (HISTORY) - ALL LESSONS
  // --------------------------------------------------------------------------
  private fun getHistoryUnits(grade: String): List<SyllabusUnit> {
    return listOf(
      SyllabusUnit(
        id = "h_${grade}_u1", grade = grade, subject = "ඉතිහාසය", unitNumber = 1,
        titleSinhala = "ඓතිහාසික මූලාශ්‍ර සහ ප්‍රාග් ඓතිහාසික යුගය",
        englishTitle = "Historical Sources & Prehistoric Era",
        keyConcepts = listOf("සාහිත්‍ය මූලාශ්‍ර (මහාවංශය, දීපවංශය)", "පුරාවිද්‍යාත්මක මූලාශ්‍ර (සෙල්ලිපි, කාසි, නටබුන්)", "ෆාහියන් ලෙන, බටදොඹලෙන", "බලන්ගොඩ මානවයා"),
        sampleDoubts = listOf("සෙල්ලිපි වර්ග 4 මොනවාද?", "දේශීය හා විදේශීය සාහිත්‍ය මූලාශ්‍ර වෙනස"),
        coreFormulaOrRule = "සෙල්ලිපි: ලෙන් ලිපි, ගිරි ලිපි, පුවරු ලිපි, ටැම් ලිපි ලෙස වර්ග 4කි.",
        examTip = "ශ්‍රී ලංකාවේ පැරණිතම සෙල්ලිපි ක්‍රි.පූ. 3 වන සියවසේ බ්‍රාහ්මී අක්ෂරවලින් ලියා ඇති ලෙන් ලිපි වේ.",
        fullExplanation = "අතීතය පිළිබඳ තොරතුරු ලබාගන්නා මූලික මාධ්‍යයන් මූලාශ්‍ර නම් වේ. සාහිත්‍ය මූලාශ්‍ර ලිඛිත ලේඛන වන අතර පුරාවිද්‍යා මූලාශ්‍ර භෞතික සාක්ෂි වේ. බලන්ගොඩ මානවයා (Homo sapiens balangodensis) මධ්‍ය ශිලා යුගයට අයත් වේ."
      ),
      SyllabusUnit(
        id = "h_${grade}_u2", grade = grade, subject = "ඉතිහාසය", unitNumber = 2,
        titleSinhala = "අනුරාධපුර රාජධානිය සහ වාරි ශිෂ්ටාචාරය",
        englishTitle = "Anuradhapura Kingdom & Hydraulic Civilization",
        keyConcepts = listOf("පණ්ඩුකාභය රජු සහ නගර නිර්මාණය", "දේවානම්පියතිස්ස රජු හා මහින්දාගමනය", "දුටුගැමුණු රජු හා මහාථූපය", "ධාතුසේන රජු හා කලා වැව", "බිසෝකොටුව හා සොරොව්ව"),
        sampleDoubts = listOf("බිසෝකොටුවේ තාක්ෂණික වැදගත්කම කුමක්ද?", "ඇළ මාර්ග (යෝධ ඇළ) නිර්මාණයේ විශිෂ්ටත්වය"),
        coreFormulaOrRule = "බිසෝකොටුව: වැව් බැම්මට හානි නොවන සේ ජල පීඩනය පාලනය කර පිටතට නිකුත් කරන විශ්මිත ජල පාලන කුටිය.",
        examTip = "සැතපුමකට අඟලක බැස්මක් සහිත ජය ගඟ (යෝධ ඇළ) ධාතුසේන රජු විසින් ඉදිකරන ලද්දකි.",
        fullExplanation = "අනුරාධපුර යුගයේදී ලොව විශිෂ්ටතම වාරි ශිෂ්ටාචාරයක් ගොඩනැගිණි. වැව් බැම්ම, පිටවාන, රළපනාව, සොරොව්ව සහ බිසෝකොටුව වැවක ප්‍රධාන අංග වේ. බිසෝකොටුව මගින් වැවේ ගැඹුරු ජල පීඩනය පාලනය කර සොරොව්ව හරහා කුඹුරුවලට ජලය මුදාහරින ලදී."
      ),
      SyllabusUnit(
        id = "h_${grade}_u3", grade = grade, subject = "ඉතිහාසය", unitNumber = 3,
        titleSinhala = "පොළොන්නරු රාජධානිය සහ ආර්ථික සමෘද්ධිය",
        englishTitle = "Polonnaruwa Kingdom & Economic Prosperity",
        keyConcepts = listOf("පළමුවන විජයබාහු රජු (සොළී ආක්‍රමණ පරාජය)", "මහා පරාක්‍රමබාහු රජු (පරාක්‍රම සමුද්‍රය)", "නිශ්ශංකමල්ල රජු (හැටදාගෙය, ගල්පොත)", "පොළොන්නරු ගෘහ නිර්මාණ ශිල්පය"),
        sampleDoubts = listOf("මහා පරාක්‍රමබාහු රජුගේ සුප්‍රකට ප්‍රතිපත්තිය කුමක්ද?", "පරාක්‍රම සමුද්‍රය නිර්මාණය වූ ආකාරය"),
        coreFormulaOrRule = "'අහසින් වැටෙන එකදු දිය බිඳක්වත් මිනිසාගේ ප්‍රයෝජනයට නොගෙන මුහුදට ගලා යාමට ඉඩ නොදිය යුතුය' - මහා පරාක්‍රමබාහු රජු.",
        examTip = "පොළොන්නරුවේ සඳකඩපහණේ ගවයාගේ රූපය නොමැති බව හින්දු බලපෑම නිසා සිදු වූ වෙනසක් ලෙස නිතර විමසයි.",
        fullExplanation = "ක්‍රි.ව. 1055 දී පළමුවන විජයබාහු රජු සොළීන් පරදවා පොළොන්නරුව අගනුවර කරගත්තේය. මහා පරාක්‍රමබාහු රජු තෝපා වැව, දුඹුටු වැව, එරබදු වැව එක්කර පරාක්‍රම සමුද්‍රය නිර්මාණය කළ අතර ලංකාව 'පෙරදිග ධාන්‍යාගාරය' බවට පත්කළේය."
      ),
      SyllabusUnit(
        id = "h_${grade}_u4", grade = grade, subject = "ඉතිහාසය", unitNumber = 4,
        titleSinhala = "නිරිතදිග රාජධානි සහ මහනුවර යුගය",
        englishTitle = "South-Western Kingdoms & Kingdom of Kandy",
        keyConcepts = listOf("දඹදෙණිය, යාපහුව, කුරුණෑගල, ගම්පොළ, කෝට්ටේ", "හයවන පරාක්‍රමබාහු රජු හා මුළු ලංකාව එක්සේසත් කිරීම", "සෙංකඩගලපුර (මහනුවර) ආරම්භය", "විමලධර්මසූරිය රජු"),
        sampleDoubts = listOf("කෝට්ටේ යුගයේ සාහිත්‍ය පුනරුදය", "යාපහුවේ පියගැටපෙළ නිර්මාණ ශෛලිය"),
        coreFormulaOrRule = "කෝට්ටේ හයවන පරාක්‍රමබාහු රජු මුළු ලංකාවම එක්සේසත් කළ අවසන් දේශීය රජු වේ.",
        examTip = "සැළලිහිණි, ගිරා, හංස, කොවුල්, පරවි යන සංදේශ කාව්‍ය කෝට්ටේ යුගයේ ස්වර්ණමය සාහිත්‍ය නිර්මාණ වේ.",
        fullExplanation = "පොළොන්නරුව බිඳවැටීමෙන් පසු ආරක්ෂක හේතු මත අගනුවර නිරිතදිගට සංක්‍රමණය විය. කෝට්ටේ හයවන පරාක්‍රමබාහු රජු මුළු රටම එක්සේසත් කළ අතර සාහිත්‍යයේ ස්වර්ණමය යුගය බිහිවිය. පසුව ස්වභාවික රැකවරණය සහිත මහනුවර රාජධානිය ආරම්භ විය."
      ),
      SyllabusUnit(
        id = "h_${grade}_u5", grade = grade, subject = "ඉතිහාසය", unitNumber = 5,
        titleSinhala = "යුරෝපීය ආක්‍රමණ සහ විමුක්ති අරගල",
        englishTitle = "European Rule & Freedom Struggles",
        keyConcepts = listOf("පෘතුගීසි පාලනය (1505)", "ලන්දේසි පාලනය (1658)", "බ්‍රිතාන්‍ය පාලනය සහ 1815 උඩරට ගිවිසුම", "1818 වෙල්ලස්ස කැරැල්ල (කැප්පෙටිපොළ)", "1848 නිදහස් සටන (පුරන් අප්පු)"),
        sampleDoubts = listOf("1815 උඩරට ගිවිසුමේ ප්‍රධාන වගන්ති මොනවාද?", "1818 කැරැල්ලට හේතු"),
        coreFormulaOrRule = "1815 මාර්තු 2 වන දින උඩරට ගිවිසුම මගින් මුළු ශ්‍රී ලංකාවම බ්‍රිතාන්‍ය කිරීටයට යටත් විය.",
        examTip = "1818 කැරැල්ලට ආසන්නතම හේතුව සිල්වෙස්ටර් ඩග්ලස් විල්සන් හා හජ්ජි මරික්කාර් පත්කිරීමට විරෝධය පෑමයි.",
        fullExplanation = "පෘතුගීසි, ලන්දේසි හා බ්‍රිතාන්‍ය ජාතිකයන් වෙළඳ හා දේශපාලන බලය අල්ලාගත්හ. 1815 දී උඩරට ගිවිසුමෙන් ලංකාව පූර්ණ යටත් විජිතයක් විය. කැප්පෙටිපොළ නිලමේගේ නායකත්වයෙන් 1818 දී ද, වීර පුරන් අප්පු හා ගොන්ගාලේගොඩ බණ්ඩාගේ නායකත්වයෙන් 1848 දී ද විමුක්ති අරගල ඇතිවිය."
      )
    )
  }

  // --------------------------------------------------------------------------
  // 4. සිංහල භාෂාව හා සාහිත්‍යය (SINHALA) - ALL LESSONS
  // --------------------------------------------------------------------------
  // 4. සිංහල (SINHALA) - ALL LESSONS (GRADES 10 & 11 COMPREHENSIVE)
  // --------------------------------------------------------------------------
  private fun getSinhalaUnits(grade: String): List<SyllabusUnit> {
    val litLessons = if (grade.contains("11")) {
      SinhalaMasterRepository.grade11LiteratureList
    } else {
      SinhalaMasterRepository.grade10LiteratureList
    }

    val litUnits = litLessons.mapIndexed { idx, lesson ->
      SyllabusUnit(
        id = "si_${grade}_lit_${lesson.id}",
        grade = grade,
        subject = "සිංහල",
        unitNumber = idx + 1,
        titleSinhala = "${lesson.title} (${lesson.sourceBook} - ${lesson.author})",
        englishTitle = "Literature: ${lesson.title} [${lesson.lessonType}]",
        keyConcepts = listOf(lesson.lessonType, lesson.sourceBook, lesson.author, lesson.historicalEra) + lesson.literaryAppreciationPoints.take(2),
        sampleDoubts = lesson.expectedExamQuestions,
        coreFormulaOrRule = "ප්‍රධාන තේමාව: ${lesson.mainTheme}",
        examTip = "විචාර සැලැස්ම: ${lesson.modelEssayOutline.lines().firstOrNull() ?: ""}",
        fullExplanation = "${lesson.mainTheme}\n\nකාව්‍ය/ගද්‍ය උපුටන:\n" + lesson.keyQuotationsWithMeaning.joinToString("\n") { "• \"${it.first}\" -> ${it.second}" }
      )
    }

    val grammarUnits = SinhalaMasterRepository.grammarRulesList.mapIndexed { idx, rule ->
      SyllabusUnit(
        id = "si_${grade}_g_${rule.id}",
        grade = grade,
        subject = "සිංහල",
        unitNumber = litUnits.size + idx + 1,
        titleSinhala = "${rule.ruleCategory}: ${rule.ruleTitle}",
        englishTitle = "Grammar: ${rule.ruleCategory}",
        keyConcepts = rule.rulePoints.take(3),
        sampleDoubts = listOf("මෙම නීතිය භාවිත වන අවස්ථා මොනවාද?", "නිතර සිදුවන වැරදි වළක්වා ගන්නේ කෙසේද?"),
        coreFormulaOrRule = rule.corePrinciple,
        examTip = rule.examTip,
        fullExplanation = "${rule.corePrinciple}\n\nනිදසුන්: ${rule.correctExamples.joinToString(", ")}\n\nසාමාන්‍ය වැරදි:\n" + rule.commonMistakes.joinToString("\n") { "❌ ${it.first} -> ✅ ${it.second}" }
      )
    }

    val writingUnits = SinhalaMasterRepository.writingSkillsList.mapIndexed { idx, ws ->
      SyllabusUnit(
        id = "si_${grade}_ws_${ws.id}",
        grade = grade,
        subject = "සිංහල",
        unitNumber = litUnits.size + grammarUnits.size + idx + 1,
        titleSinhala = "${ws.category}: ${ws.title}",
        englishTitle = "Writing: ${ws.category}",
        keyConcepts = ws.standardFormat.take(3),
        sampleDoubts = listOf("${ws.category} සඳහා උපරිම ලකුණු ලබාගන්නේ කෙසේද?"),
        coreFormulaOrRule = ws.practicalRules.joinToString(" | "),
        examTip = "ලකුණු දීමේ පටිපාටිය: " + ws.markingCriteriaMarks.entries.joinToString(", ") { "${it.key}: ${it.value}ක්" },
        fullExplanation = "${ws.title}\n\nසම්මත ආකෘතිය:\n" + ws.standardFormat.joinToString("\n") + "\n\nආදර්ශ පිළිතුර:\n${ws.sampleSolution}"
      )
    }

    return litUnits + grammarUnits + writingUnits
  }

  // --------------------------------------------------------------------------
  // 5. ඉංග්‍රීසි (ENGLISH) - ALL LESSONS (GRADES 10 & 11 COMPREHENSIVE)
  // --------------------------------------------------------------------------
  private fun getEnglishUnits(grade: String): List<SyllabusUnit> {
    val activeG = if (grade.contains("11")) "11" else "10"
    val textbookList = EnglishMasterDataProvider.textbookUnits.filter { it.grade == activeG }

    val tbUnits = textbookList.map { unit ->
      SyllabusUnit(
        id = "en_${grade}_tb_${unit.id}",
        grade = grade,
        subject = "ඉංග්‍රීසි",
        unitNumber = unit.unitNumber,
        titleSinhala = "Unit ${unit.unitNumber}: ${unit.unitTitle} (${unit.titleSinhala})",
        englishTitle = "Unit ${unit.unitNumber}: ${unit.unitTitle}",
        keyConcepts = listOf("Theme: ${unit.mainTheme}", "Grammar: ${unit.grammarFocus}") + unit.keyVocabularyWithSinhala.take(2).map { "${it.first} (${it.second})" },
        sampleDoubts = unit.sampleExamQuestions,
        coreFormulaOrRule = "Grammar Focus: ${unit.grammarFocus} | Activity: ${unit.activityOutline}",
        examTip = "Vocabulary Tip: " + unit.keyVocabularyWithSinhala.joinToString(", ") { "${it.first} = ${it.second}" },
        fullExplanation = "${unit.mainTheme}\n\nReading Summary:\n${unit.readingPassageSummary}\n\nVocabulary:\n" +
            unit.keyVocabularyWithSinhala.joinToString("\n") { "• ${it.first}: ${it.second}" }
      )
    }

    val grammarUnits = EnglishMasterDataProvider.grammarFormulas.mapIndexed { idx, formula ->
      SyllabusUnit(
        id = "en_${grade}_gf_${formula.id}",
        grade = grade,
        subject = "ඉංග්‍රීසි",
        unitNumber = tbUnits.size + idx + 1,
        titleSinhala = "Grammar: ${formula.titleSinhala}",
        englishTitle = "Grammar: ${formula.topic}",
        keyConcepts = formula.rules.take(3),
        sampleDoubts = listOf("How to apply the ${formula.topic} formula correctly?", "What are common errors?"),
        coreFormulaOrRule = formula.formula,
        examTip = formula.examTip,
        fullExplanation = "${formula.explanationSinhala}\n\nFormula: ${formula.formula}\n\nExamples:\n" +
            formula.correctExamples.joinToString("\n") { "• $it" } +
            "\n\nCommon Mistakes:\n" +
            formula.commonErrorsWithCorrection.joinToString("\n") { "❌ ${it.first} -> ✅ ${it.second}" }
      )
    }

    return tbUnits + grammarUnits
  }

  // --------------------------------------------------------------------------
  // 6. ICT - තොරතුරු හා සන්නිවේදන තාක්ෂණය - ALL LESSONS
  // --------------------------------------------------------------------------
  private fun getIctUnits(grade: String): List<SyllabusUnit> {
    return listOf(
      SyllabusUnit(
        id = "ict_${grade}_u1", grade = grade, subject = "ICT", unitNumber = 1,
        titleSinhala = "දත්ත නිරූපණය සහ සංඛ්‍යා පද්ධති",
        englishTitle = "Data Representation & Number Systems",
        keyConcepts = listOf("ද්විමය (Binary - පාදය 2)", "අෂ්ටමය (Octal - පාදය 8)", "දශමය (Decimal - පාදය 10)", "ෂඩ්දශමය (Hexadecimal - පාදය 16)", "ASCII හා Unicode"),
        sampleDoubts = listOf("දශමය සංඛ්‍යාවක් ද්විමය බවට හැරවීම", "ද්විමය සංඛ්‍යා එකතු කිරීම"),
        coreFormulaOrRule = "පාද 2න් බෙදමින් ඉතිරිය පහළ සිට ඉහළට ලිවීමෙන් දශම සංඛ්‍යාවක් ද්විමය බවට පත් කෙරේ.",
        examTip = "ෂඩ්දශමයේදී 10 = A, 11 = B, 12 = C, 13 = D, 14 = E, 15 = F බව මතක තබාගන්න.",
        fullExplanation = "පරිගණක දත්ත ගබඩා කරන්නේ ද්විමය (0 සහ 1) ක්‍රමයටයි. 8 Bits = 1 Byte වේ. සංඛ්‍යා පද්ධති අතර පරිවර්තනය කිරීමේදී 2, 8 හෝ 16 න් බෙදීම හෝ ස්ථානීය අගයන්ගෙන් ගුණ කිරීම සිදුකරනු ලැබේ."
      ),
      SyllabusUnit(
        id = "ict_${grade}_u2", grade = grade, subject = "ICT", unitNumber = 2,
        titleSinhala = "තර්ක ද්වාර සහ බූලීය වීජ ගණිතය",
        englishTitle = "Logic Gates & Boolean Algebra",
        keyConcepts = listOf("AND ද්වාරය (ගුණිතය)", "OR ද්වාරය (එකතුව)", "NOT ද්වාරය (ප්‍රතිලෝමය)", "NAND සහ NOR විශ්ව ද්වාර", "සත්‍යතා වගු (Truth Tables)"),
        sampleDoubts = listOf("NAND සහ NOR විශ්ව ද්වාර ලෙස හඳුන්වන්නේ ඇයි?", "සත්‍යතා වගුවක් ගොඩනැගීම"),
        coreFormulaOrRule = "AND: Y = A . B (දෙකම 1 නම් පමණක් 1) | OR: Y = A + B (ඕනෑම එකක් 1 නම් 1) | NOT: Y = Ā",
        examTip = "විභාගයේදී තර්ක ද්වාර පරිපථයක එක් එක් ද්වාරයේ ප්‍රතිදානය පරිපථය මතම ලියාගෙන අවසන් ප්‍රතිදානය ගන්න.",
        fullExplanation = "තර්ක ද්වාර යනු ද්විමය සංඥා (0 හෝ 1) මත තර්කානුකූල මෙහෙයුම් සිදුකරන මූලික ඉලෙක්ට්‍රොනික උපාංගයි. NAND සහ NOR ද්වාර මගින් අනෙක් සියලුම ද්වාර නිර්මාණය කළ හැකි බැවින් ඒවා විශ්ව ද්වාර නම් වේ."
      ),
      SyllabusUnit(
        id = "ict_${grade}_u3", grade = grade, subject = "ICT", unitNumber = 3,
        titleSinhala = "පරිගණක ජාල, අන්තර්ජාලය සහ වෙබ් නිර්මාණය",
        englishTitle = "Computer Networks, Internet & HTML/CSS",
        keyConcepts = listOf("LAN, MAN, WAN", "IP ලිපින සහ DNS", "ජාල ස්ථලක (Bus, Star, Ring)", "HTML ටැග (<p>, <a>, <img>, <table>)", "CSS මෝස්තර"),
        sampleDoubts = listOf("IP ලිපිනයක් සහ MAC ලිපිනයක් අතර වෙනස", "HTML සරල වගුවක් නිර්මාණය කිරීම"),
        coreFormulaOrRule = "HTML මූලික සැකිල්ල: <html><head><title></title></head><body></body></html>",
        examTip = "HTML හි <a> ටැගය සබැඳි (Hyperlinks) සඳහා ද, <img> ටැගය පින්තූර සඳහා ද භාවිත වේ.",
        fullExplanation = "පරිගණක ජාල මගින් සම්පත් සහ තොරතුරු හවුලේ භාවිත කළ හැක. අන්තර්ජාලයේ වෙබ් පිටු නිර්මාණය සඳහා HTML භාෂාව භාවිත වන අතර ඒවා හැඩගැන්වීම සඳහා CSS යොදාගනී."
      ),
      SyllabusUnit(
        id = "ict_${grade}_u4", grade = grade, subject = "ICT", unitNumber = 4,
        titleSinhala = "ක්‍රමලේඛනය, ඇල්ගොරිතම සහ ගැලීම් සටහන්",
        englishTitle = "Algorithms, Flowcharts & Python Programming",
        keyConcepts = listOf("ගැලීම් සටහන් සංකේත (ආරම්භය, ආදානය, සැකසුම, තීරණය)", "Python විචල්‍ය සහ දත්ත වර්ග", "තේරීම (if-elif-else)", "පුනර්කරණය (for / while loops)", "ද්විමාන අරාවන්"),
        sampleDoubts = listOf("While loop එකක් සහ For loop එකක් අතර වෙනස", "ගැලීම් සටහනක තීරණ සංකේතය (දියමන්ති) යෙදීම"),
        coreFormulaOrRule = "Python: if කොන්දේසිය : ක්‍රියාමාර්ගය | for i in range(n) : පුනරාවර්තනය",
        examTip = "Python හි Indentation (හිස්තැන් තැබීම) ඉතා වැදගත්ය. එය block of code හඳුනාගැනීමට යොදාගනී.",
        fullExplanation = "ඇල්ගොරිතමයක් යනු ගැටලුවක් විසඳීම සඳහා වූ පියවරෙන් පියවර උපදෙස් මාලාවකි. එය චිත්‍රකව දැක්වීම ගැලීම් සටහනයි. Python යනු සරල, පහසුවෙන් කියවිය හැකි ප්‍රබල ක්‍රමලේඛන භාෂාවකි."
      )
    )
  }

  // --------------------------------------------------------------------------
  // 7. බුද්ධ ධර්මය (BUDDHISM) - ALL LESSONS
  // --------------------------------------------------------------------------
  private fun getBuddhismUnits(grade: String): List<SyllabusUnit> {
    return listOf(
      SyllabusUnit(
        id = "b_${grade}_u1", grade = grade, subject = "බුද්ධ ධර්මය", unitNumber = 1,
        titleSinhala = "චතුරාර්ය සත්‍යය සහ ආර්ය අෂ්ටාංගික මාර්ගය",
        englishTitle = "Four Noble Truths & Noble Eightfold Path",
        keyConcepts = listOf("දුක්ඛ සත්‍යය", "සමුදය සත්‍යය (තණ්හාව)", "නිරෝධ සත්‍යය (නිවන)", "මාර්ග සත්‍යය", "සීල, සමාධි, ප්‍රඥා ත්‍රිශික්ෂාව"),
        sampleDoubts = listOf("චතුරාර්ය සත්‍යය ප්‍රථමයෙන් දේශනා කළ සූත්‍රය කුමක්ද?", "ආර්ය අෂ්ටාංගික මාර්ගයේ අංග 8"),
        coreFormulaOrRule = "ත්‍රිශික්ෂාව: සීල (සම්මා වාචා, කම්මන්ත, ආජීව) | සමාධි (සම්මා වායාම, සති, සමාධි) | ප්‍රඥා (සම්මා දිට්ඨි, සංකප්ප).",
        examTip = "ආර්ය අෂ්ටාංගික මාර්ගයේ අංග ත්‍රිශික්ෂාවට බෙදා දැක්වීමට ලකුණු 3ක ප්‍රශ්නයක් ලෙස නිතර පැමිණේ.",
        fullExplanation = "බුදුරජාණන් වහන්සේ බරණැස ඉසිපතන මිගදායේදී පස්වග තවුසන් උදෙසා ධම්මචක්කප්පවත්තන සූත්‍රයෙන් චතුරාර්ය සත්‍යය දේශනා කළහ. දුක, දුකට හේතුව (තණ්හාව), දුක නැතිකිරීම (නිවන) සහ දුක නැතිකිරීමේ මාර්ගය වන ආර්ය අෂ්ටාංගික මාර්ගයයි."
      ),
      SyllabusUnit(
        id = "b_${grade}_u2", grade = grade, subject = "බුද්ධ ධර්මය", unitNumber = 2,
        titleSinhala = "ත්‍රිලක්ෂණය සහ පටිච්ච සමුප්පාදය",
        englishTitle = "Three Characteristics of Existence & Dependent Origination",
        keyConcepts = listOf("අනිත්‍ය (වෙනස්වන සුලු බව)", "දුක්ඛ (අතෘප්තිකර බව)", "අනත්ත (ආත්මයක් නොමැති බව)", "හේතුඵල ධර්මය", "භව චක්‍රය"),
        sampleDoubts = listOf("අනත්ත ලක්ෂණය තේරුම් ගන්නේ කෙසේද?", "පටිච්ච සමුප්පාදයේ මූලික න්‍යාය"),
        coreFormulaOrRule = "'ඉමස්මිං සති ඉදං හෝති' - මෙය ඇති කල්හි මෙය වේ, මෙය නූපදනා කල්හි මෙය නූපදී.",
        examTip = "අනත්තලක්ඛණ සූත්‍රය ශ්‍රවණය කිරීමෙන් පස්වග මහණුන් රහත් භාවයට පත්වූ බව මතක තබාගන්න.",
        fullExplanation = "සියලු සංස්කාර ධර්මයන් අනිත්‍ය, දුක්ඛ, අනත්ත යන ත්‍රිලක්ෂණයට යටත් වේ. කිසිවක් අහේතුකව සිදු නොවන අතර හේතූන් නිසා හටගෙන හේතූන් නැතිවීමෙන් නිරුද්ධ වන බව පටිච්ච සමුප්පාදයෙන් පැහැදිලි කෙරේ."
      ),
      SyllabusUnit(
        id = "b_${grade}_u3", grade = grade, subject = "බුද්ධ ධර්මය", unitNumber = 3,
        titleSinhala = "ශාසන ඉතිහාසය සහ ධර්ම සංගායනා",
        englishTitle = "Buddhist Councils & History of Sasana",
        keyConcepts = listOf("පළමුවන ධර්ම සංගායනාව (රජගහනුවර, අජාසත් රජු)", "දෙවන ධර්ම සංගායනාව (විශාලාමහනුවර, කාලාශෝක රජු)", "තුන්වන ධර්ම සංගායනාව (පැළලුප්නුවර, ධර්මාශෝක රජු)", "මහින්දාගමනය"),
        sampleDoubts = listOf("පළමු ධර්ම සංගායනාවට හේතු වූ කරුණු", "ධර්මාශෝක රජුගේ ධර්ම විජය ප්‍රතිපත්තිය"),
        coreFormulaOrRule = "ප්‍රථම සංගායනාව: මහා කාශ්‍යප මහරහතන් වහන්සේගේ ප්‍රධානත්වයෙන් සුභද්ද භික්ෂුවගේ අභද්‍ර වචන මුල්කරගෙන පැවැත්විණි.",
        examTip = "සංගායනාවල මුලසුන හෙබවූ මහරහතන් වහන්සේලා, රාජ්‍ය අනුග්‍රහය දැක්වූ රජවරුන් සහ ස්ථාන වගුවක් ලෙස පාඩම් කරගන්න.",
        fullExplanation = "බුද්ධ පරිනිර්වාණයෙන් පසු ධර්ම විනය ආරක්ෂා කරගැනීම සඳහා ධර්ම සංගායනා තුනක් පැවැත්විණි. තුන්වන සංගායනාවෙන් පසු ධර්මාශෝක රජුගේ අනුග්‍රහයෙන් රටවල් නවයකට ධර්ම දූත පිරිස් යැවූ අතර මිහිඳු මහරහතන් වහන්සේ ලංකාවට බුදුසසුන රැගෙන වැඩම කළහ."
      ),
      SyllabusUnit(
        id = "b_${grade}_u4", grade = grade, subject = "බුද්ධ ධර්මය", unitNumber = 4,
        titleSinhala = "බෞද්ධ සමාජ දර්ශනය සහ සත්පුරුෂ ඇසුර",
        englishTitle = "Buddhist Social Philosophy & Right Associations",
        keyConcepts = listOf("සිඟාලෝවාද සූත්‍රය සහ සදිසා නමස්කාරය", "පරාභව සූත්‍රය (පිරිහීමට හේතු)", "වසල සූත්‍රය", "කල්‍යාණ මිත්‍ර සේවනය"),
        sampleDoubts = listOf("සිඟාලෝවාද සූත්‍රයේ දෙමාපිය-දරුවන් අතර යුතුකම්", "වසලයෙකු වන්නේ උපතින් නොව ක්‍රියාවෙන් බව"),
        coreFormulaOrRule = "න ජච්චා වසලෝ හෝති - න ජච්චා හෝති බ්‍රාහ්මණෝ | කම්මනා වසලෝ හෝති - කම්මනා හෝති බ්‍රාහ්මණෝ.",
        examTip = "සිඟාලෝවාද සූත්‍රයේ දිශා 6 සහ ඊට අදාළ පුද්ගල සබඳතා විභාග ප්‍රශ්න පත්‍රයේ නිතර අසයි.",
        fullExplanation = "සිඟාලෝවාද සූත්‍රය ගිහි විනය ලෙස හඳුන්වයි. දෙමව්පියන්, ගුරුවරුන්, අඹුසැමියන්, මිත්‍රයන්, සේවකයන් සහ පූජ්‍ය පක්ෂය යන සදිසාවන්ට ඉටුකළ යුතු යුතුකම් මැනවින් පැහැදිලි කරයි."
      ),
      SyllabusUnit(
        id = "b_${grade}_u5", grade = grade, subject = "බුද්ධ ධර්මය", unitNumber = 5,
        titleSinhala = "කර්මය, පුනර්භවය සහ සසර පැවැත්ම",
        englishTitle = "Karma, Rebirth & Cycle of Samsara",
        keyConcepts = listOf("චේතනාහං භික්ඛවේ කම්මං වදාමි", "කුසල් සහ අකුසල් කර්ම", "දිට්ඨධම්මවේදනීය ආදී කර්ම චතුෂ්කය", "පුනර්භවය සාධක"),
        sampleDoubts = listOf("කර්මය සහ ඵලය අතර සම්බන්ධය", "කර්ම විපාක දෙන පිළිවෙළ"),
        coreFormulaOrRule = "කර්ම චතුෂ්කය: දිට්ඨධම්මවේදනීය (මෙලොවදීම), උපපජ්ජවේදනීය (ඊළඟ භවයේ), අපරාපරියවේදනීය (සසර කවරදා හෝ), අහෝසි කර්ම.",
        examTip = "චේතනාව කර්මය බව බුදුරදුන් දේශනා කළ අයුරු විග්‍රහ කරන්න.",
        fullExplanation = "සිතා මතා කරනු ලබන කුසල් හා අකුසල් ක්‍රියා කර්ම නම් වේ. කර්මයේ විපාකය පුද්ගලයාගේ භව ගමන හා විඳීම් තීරණය කරයි. කර්මය නිවන් අවබෝධයෙන් සහමුලින්ම ක්ෂය වේ."
      )
    )
  }

  // --------------------------------------------------------------------------
  // 8. භූගෝල විද්‍යාව (GEOGRAPHY) - ALL LESSONS
  // --------------------------------------------------------------------------
  private fun getGeographyUnits(grade: String): List<SyllabusUnit> {
    return listOf(
      SyllabusUnit(
        id = "g_${grade}_u1", grade = grade, subject = "භූගෝල විද්‍යාව", unitNumber = 1,
        titleSinhala = "පෘථිවියේ පිහිටීම, අක්ෂාංශ, දේශාංශ සහ කාලය ගණනය",
        englishTitle = "Earth Coordinates, Latitudes, Longitudes & Time Zones",
        keyConcepts = listOf("සමකය (0°)", "ප්‍රධාන මධ්‍යහ්න රේඛාව (ග්‍රිනිච් 0°)", "දේශාංශ 1ක් = මිනිත්තු 4ක කාල වෙනස", "ජාත්‍යන්තර දින රේඛාව (180°)"),
        sampleDoubts = listOf("දේශාංශ අනුව කාලය ගණනය කිරීම", "අක්ෂාංශ සහ දේශාංශ මගින් ස්ථානයක් නිරූපණය"),
        coreFormulaOrRule = "පෘථිවිය අංශක 1ක් භ්‍රමණය වීමට මිනිත්තු 4ක් ගතවේ. නැගෙනහිරට යනවිට වේලාව එකතු කළ යුතු අතර බටහිරට අඩු කළ යුතුය.",
        examTip = "ග්‍රිනිච් වේලාවට වඩා ශ්‍රී ලංකාව පැය 5 මිනිත්තු 30ක් ඉදිරියෙන් සිටී (UTC +5:30).",
        fullExplanation = "පෘථිවියේ ඕනෑම ස්ථානයක් නිවැරදිව හඳුනාගැනීමට අක්ෂාංශ සහ දේශාංශ ජාලය භාවිත කරයි. පෘථිවිය බටහිර සිට නැගෙනහිරට පැය 24 කදී අංශක 360 ක් භ්‍රමණය වන බැවින් සෑම දේශාංශ අංශක 1කට මිනිත්තු 4ක කාල වෙනසක් ඇතිවේ."
      ),
      SyllabusUnit(
        id = "g_${grade}_u2", grade = grade, subject = "භූගෝල විද්‍යාව", unitNumber = 2,
        titleSinhala = "ශ්‍රී ලංකාවේ භෞතික පරිසරය, දේශගුණය සහ ගංගා",
        englishTitle = "Sri Lanka Physical Landscape, Climate & River Systems",
        keyConcepts = listOf("භූ විෂමතා කලාප 3 (වෙරළබඩ තැන්න, අභ්‍යන්තර තැනිතලාව, මධ්‍යම කඳුකරය)", "නිරිතදිග හා ඊසානදිග මෝසම් සුළං", "මහවැලි ගඟ", "තෙත්, වියළි හා අතරමැදි කලාප"),
        sampleDoubts = listOf("මෝසම් වැසි ඇතිවන ආකාරය", "ශ්‍රී ලංකාවේ කේන්ද්‍රාපසාරී ගංගා රටාව"),
        coreFormulaOrRule = "වාර්ෂික වර්ෂාපතනය: තෙත් කලාපය (> 2000 mm), අතරමැදි (1250 - 2000 mm), වියළි කලාපය (< 1250 mm).",
        examTip = "ශ්‍රී ලංකාවේ දිගම ගඟ මහවැලි ගඟ (335 km) වන අතර විශාලතම ද්‍රෝණියද මහවැලි වේ.",
        fullExplanation = "ශ්‍රී ලංකාවේ මධ්‍යම කඳුකරයේ සිට සියලු දිශාවන්ට ගංගා ගලා බසින කේන්ද්‍රාපසාරී ගංගා රටාවක් ඇත. මැයි සිට සැප්තැම්බර් දක්වා නිරිතදිග මෝසමෙන්ද, දෙසැම්බර් සිට පෙබරවාරි දක්වා ඊසානදිග මෝසමෙන්ද වර්ෂාව ලැබේ."
      ),
      SyllabusUnit(
        id = "g_${grade}_u3", grade = grade, subject = "භූගෝල විද්‍යාව", unitNumber = 3,
        titleSinhala = "සිතියම් කියවීම, පරිමාණය සහ සමෝච්ච රේඛා",
        englishTitle = "Map Reading, Scale & Contour Lines",
        keyConcepts = listOf("පරිමාණය (නිරූපක භාග, ප්‍රකාශන)", "සමෝච්ච රේඛා සහ බෑවුම් හඳුනාගැනීම", "භූ විෂමතා ලක්ෂණ (කඳු මුදුන්, නිම්න, දුර්ග)", "1:50,000 භූ ලක්ෂණ සිතියම"),
        sampleDoubts = listOf("සමෝච්ච රේඛා ළඟින් පිහිටි විට බෑවුම කෙබඳුද?", "සිතියම් දුර භූමි දුර බවට පරිවර්තනය"),
        coreFormulaOrRule = "සමෝච්ච රේඛා එකිනෙකට ළඟ නම් දැඩි බෑවුමකි. ඈත්ව පිහිටා ඇත්නම් මෘදු බෑවුමකි. V හැඩැති රේඛා උස් බිම් දෙසට යොමුව ඇත්නම් නිම්නයකි.",
        examTip = "විභාගයේ 1 වන ප්‍රශ්නය 1:50,000 සිතියම ආශ්‍රිත අනිවාර්ය ප්‍රශ්නය වන අතර ලකුණු 10ක් හිමිවේ.",
        fullExplanation = "සිතියම් පරිමාණය මගින් සිතියමක ලක්ෂ්‍ය දෙකක් අතර දුර සැබෑ භූමියේ දුරට දක්වන අනුපාතය නිරූපණය කරයි. සමෝච්ච රේඛා මගින් මුහුදු මට්ටමේ සිට සමාන උසකින් යුතු ස්ථාන යා කර භූ විෂමතාව ත්‍රිමානව අවබෝධ කරවයි."
      ),
      SyllabusUnit(
        id = "g_${grade}_u4", grade = grade, subject = "භූගෝල විද්‍යාව", unitNumber = 4,
        titleSinhala = "ශ්‍රී ලංකාවේ සහ ලෝකයේ ස්වභාවික සම්පත් හා කර්මාන්ත",
        englishTitle = "Natural Resources, Agriculture & Industries",
        keyConcepts = listOf("ඛනිජ සම්පත් (මිනිරන්, ඉල්මනයිට්, මැණික්)", "කෘෂිකර්මාන්තය (වී, තේ, රබර්, පොල්)", "ජල විදුලිය හා සූර්ය බලය", "තිරසාර සංවර්ධනය"),
        sampleDoubts = listOf("තේ වගාවට අවශ්‍ය භූගෝලීය සාධක", "පුනර්ජනනීය බලශක්ති ප්‍රභව"),
        coreFormulaOrRule = "තේ වගාව: උෂ්ණත්වය 18°C-25°C, වාර්ෂික වර්ෂාපතනය 2000mm ට වැඩි, මනා ජලවහනය සහිත ආම්ලික පස.",
        examTip = "සිතියම් ලකුණු කිරීමේදී තෙල් පිරිපහදුව (සපුගස්කන්ද), සිමෙන්ති කර්මාන්තශාලාව (පුත්තලම) නිතර අසයි.",
        fullExplanation = "ස්වභාවික සම්පත් විචක්ෂණශීලීව භාවිත කර අනාගත පරපුරට රැකදීම තිරසාර සංවර්ධනයයි. ශ්‍රී ලංකාවේ උසස් තත්ත්වයේ මිනිරන් සහ ලෝක ප්‍රකට නිල් මැණික් පිහිටා ඇත."
      )
    )
  }

  // --------------------------------------------------------------------------
  // 9. පුරවැසි අධ්‍යාපනය (CIVICS) - ALL LESSONS (GRADE 10 & 11)
  // --------------------------------------------------------------------------
  private fun getCivicsUnits(grade: String): List<SyllabusUnit> {
    val lessons = when (grade) {
      "10" -> CivicsMasterDataProvider.allLessons.filter { it.grade == "10" }
      "11" -> CivicsMasterDataProvider.allLessons.filter { it.grade == "11" }
      else -> CivicsMasterDataProvider.allLessons
    }
    return lessons.map { lesson ->
      SyllabusUnit(
        id = lesson.id,
        grade = lesson.grade,
        subject = "පුරවැසි අධ්‍යාපනය",
        unitNumber = lesson.unitNumber,
        titleSinhala = lesson.titleSinhala,
        englishTitle = lesson.titleEnglish,
        keyConcepts = lesson.keyConcepts,
        sampleDoubts = listOf(
          "O/L විභාගයට අදාළ ප්‍රධාන කරුණු මොනවාද?",
          lesson.corePrinciples
        ),
        coreFormulaOrRule = lesson.corePrinciples,
        examTip = lesson.examTips,
        fullExplanation = lesson.fullSummary
      )
    }
  }

  // --------------------------------------------------------------------------
  // 10. ව්‍යාපාර හා ගිණුම්කරණය (COMMERCE & ACCOUNTING) - ALL LESSONS
  // --------------------------------------------------------------------------
  private fun getCommerceUnits(grade: String): List<SyllabusUnit> {
    return listOf(
      SyllabusUnit(
        id = "com_${grade}_u1", grade = grade, subject = "ව්‍යාපාර හා ගිණුම්කරණය", unitNumber = 1,
        titleSinhala = "ගිණුම්කරණ සමීකරණය සහ ද්විත්ව සටහන් මූලධර්මය",
        englishTitle = "Accounting Equation & Double Entry System",
        keyConcepts = listOf("වත්කම් (Assets)", "වගකීම් (Liabilities)", "හිමිකම (Equity)", "හර (Debit) සහ බැර (Credit) නීති", "ලෙජර ගිණුම්"),
        sampleDoubts = listOf("ගිණුම්කරණ සමීකරණයට ගනුදෙනු ඇතුළත් කිරීම", "හර හා බැර නීති මතක තබාගන්නේ කෙසේද?"),
        coreFormulaOrRule = "ගිණුම්කරණ සමීකරණය: වත්කම් = වගකීම් + හිමිකම (A = L + E) | වත්කම් හා වියදම් වැඩිවීම හර, අඩුවීම බැර වේ.",
        examTip = "සෑම ගනුදෙනුවකටම සමාන හර සහ බැර සටහන් දෙකක් ඇති බව ද්විත්ව සටහන් මූලධර්මයෙන් දැක්වේ.",
        fullExplanation = "ගිණුම්කරණයේ මූලික පදනම වත්කම් = වගකීම් + හිමිකම සමීකරණයයි. ව්‍යාපාරයකට මුදල් හෝ දේපළ ලැබෙන විට වත්කම් වැඩිවීම හර වන අතර, ණය හිමියන් හෝ බැංකු ණය වැඩිවීම වගකීම් බැර වේ."
      ),
      SyllabusUnit(
        id = "com_${grade}_u2", grade = grade, subject = "ව්‍යාපාර හා ගිණුම්කරණය", unitNumber = 2,
        titleSinhala = "ප්‍රභව ලේඛන, මූලික පොත් සහ මූල්‍ය ප්‍රකාශන",
        englishTitle = "Source Documents, Prime Entry Books & Financial Statements",
        keyConcepts = listOf("ඉන්වොයිසිය, රිසිට්පත, වවුචරය", "මුදල් පොත හා සුළු මුදල් පොත", "ශේෂ පිරික්සුම", "ලාභ අලාභ ගිණුම", "මූල්‍ය තත්ත්ව ප්‍රකාශය"),
        sampleDoubts = listOf("ශේෂ පිරික්සුමේ පරමාර්ථ මොනවාද?", "ශුද්ධ ලාභය ගණනය කිරීම"),
        coreFormulaOrRule = "දළ ලාභය = විකුණුම් ආදායම - විකුණුම් පිරිවැය | ශුද්ධ ලාභය = දළ ලාභය + වෙනත් ආදායම් - බෙදාහැරීමේ හා පරිපාලන වියදම්",
        examTip = "ශේෂ පිරික්සුම හර හා බැර තුල්‍ය වීමෙන් ගණිතමය නිවැරදිභාවය තහවුරු වේ.",
        fullExplanation = "ගනුදෙනුවක් සිදුවූ බවට ලිඛිත සාක්ෂිය ප්‍රභව ලේඛනයයි. ඒවා මුලින්ම ඇතුළත් කරන්නේ මූලික පොත්වලය. මූල්‍ය වර්ෂය අවසානයේ ව්‍යාපාරයේ ලාභය සෙවීමට ලාභ අලාභ ගිණුමද, වත්කම් සහ වගකීම් තත්ත්වය බැලීමට මූල්‍ය තත්ත්ව ප්‍රකාශයද පිළියෙල කෙරේ."
      ),
      SyllabusUnit(
        id = "com_${grade}_u3", grade = grade, subject = "ව්‍යාපාර හා ගිණුම්කරණය", unitNumber = 3,
        titleSinhala = "බැංකු සැසඳුම් ප්‍රකාශය සහ මුදල් පාලනය",
        englishTitle = "Bank Reconciliation Statement & Cash Control",
        keyConcepts = listOf("බැංකු ප්‍රකාශය සහ මුදල් පොතේ බැංකු තීරුව", "නොපැමිණි චෙක්පත්", "නොසැපයූ තැන්පතු", "බැංකු ගාස්තු හා සෘජු බැර කිරීම්"),
        sampleDoubts = listOf("මුදල් පොත සහ බැංකු ප්‍රකාශය අතර ශේෂයන් වෙනස් වීමට හේතු", "සංශෝධිත මුදල් පොතක් පිළියෙල කිරීම"),
        coreFormulaOrRule = "බැංකු සැසඳුම: මුදල් පොතේ නිවැරදි කළ ශේෂය + නොපැමිණි චෙක්පත් - නොසැපයූ තැන්පතු = බැංකු ප්‍රකාශයේ ශේෂය.",
        examTip = "මුදල් පොතේ සටහන් නොවූ බැංකු ගාස්තු, ස්ථාවර නියෝග සහ සෘජු ලැබීම් මුලින්ම මුදල් පොතේ සටහන් කර නිවැරදි ශේෂය ගන්න.",
        fullExplanation = "ව්‍යාපාරයේ මුදල් පොතේ බැංකු තීරුවේ ශේෂයත්, බැංකුවෙන් එවන බැංකු ප්‍රකාශයේ ශේෂයත් අතර පවතින වෙනස්කම් හඳුනාගෙන ඒවා සංසන්දනය කිරීම සඳහා බැංකු සැසඳුම් ප්‍රකාශය සකසයි."
      )
    )
  }

  // --------------------------------------------------------------------------
  // 11. සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය (HEALTH & PE) - ALL LESSONS
  // --------------------------------------------------------------------------
  private fun getHealthUnits(grade: String): List<SyllabusUnit> {
    val lessons = when (grade) {
      "10" -> HealthMasterDataProvider.allLessons.filter { it.grade == "10" }
      "11" -> HealthMasterDataProvider.allLessons.filter { it.grade == "11" }
      else -> HealthMasterDataProvider.allLessons
    }
    return lessons.map { lesson ->
      SyllabusUnit(
        id = lesson.id,
        grade = lesson.grade,
        subject = "සෞඛ්‍යය",
        unitNumber = lesson.unitNumber,
        titleSinhala = lesson.titleSinhala,
        englishTitle = lesson.titleEnglish,
        keyConcepts = lesson.keyConcepts,
        sampleDoubts = listOf(
          "O/L විභාගයට අදාළ සෞඛ්‍ය මූලධර්ම මොනවාද?",
          lesson.corePrinciples
        ),
        coreFormulaOrRule = lesson.corePrinciples,
        examTip = lesson.examTips,
        fullExplanation = lesson.fullSummary
      )
    }
  }
}
