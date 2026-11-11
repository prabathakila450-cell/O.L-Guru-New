package com.example

// ==============================================================================
// GEOMETRY STRUCTURED QUESTIONS & RIDERS: GeometryDataPart4
// Categories 16 to 20: 100% Unique, authentic O/L Geometry Structured Questions
// Guarantees each theorem has a distinct, non-repeating comprehensive question.
// ==============================================================================

object GeometryDataPart4 {
  fun getCategories(): List<GeometryCategory> {
    return listOf(
      // Category 16
      GeometryCategory(
        categoryId = 16,
        titleSinhala = "16. ත්‍රිකෝණවල සමරූපීතාවය - කෝ.කෝ.කෝ සහ පා.පා.පා",
        shortTitle = "සමරූපී ත්‍රිකෝණ",
        theoremConcept = "සමකෝණික ත්‍රිකෝණ දෙකක් සමරූපී වේ (කෝ.කෝ.කෝ). සමරූපී ත්‍රිකෝණවල අනුරූප පාද සමානුපාතික වේ (AB/PQ = BC/QR = AC/PR).",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "SIMILAR",
        generalSolvingStrategy = "ත්‍රිකෝණ දෙකෙහි කෝණ 2ක් සමාන බව පෙන්වා සමකෝණික බැවින් සමරූපී බව ලියන්න. සමාන කෝණවලට සම්මුඛ පාද පිළිවෙළින් ලියා අනුපාත සමාන කර හරස් ගුණිතයෙන් සාධනය හෝ අගය සොයන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "සමරූපී ත්‍රිකෝණ - කෝ.කෝ.කෝ සහ අනුරූප පාද අනුපාත",
            structuredQuestionText = "ABC සහ PQR ත්‍රිකෝණවල Â = P̂, B̂ = Q̂, Ĉ = R̂ වේ.\n(i) ABC △ සහ PQR △ සමරූපී බව පෙන්වන්න.\n(ii) AB / PQ = BC / QR = AC / PR බව සාධනය කරන්න.\n(iii) AB = 5 cm, PQ = 15 cm සහ BC = 6 cm නම් QR හි දිග ගණනය කරන්න.",
            givenData = "ABC △ සහ PQR △ සමකෝණික වේ.",
            toProve = "ABC △ සහ PQR △ සමරූපී වන අතර අනුරූප පාද සමානුපාතික වේ.",
            construction = "PQ මත PM = AB සහ PR මත PN = AC ලකුණු කර MN යා කිරීම.",
            proofSteps = listOf(
              GeometryStep("PQ මත PM = AB ද PR මත PN = AC ද ලකුණු කර MN යා කරමු.", "නිර්මාණය"),
              GeometryStep("PMN △ හා ABC △ සලකමු.", "ත්‍රිකෝණ යුගලය"),
              GeometryStep("PM = AB", "නිර්මාණය"),
              GeometryStep("P̂ = Â", "දත්තය"),
              GeometryStep("PN = AC", "නිර්මාණය"),
              GeometryStep("එම නිසා PMN △ ≡ ABC △", "පා.කෝ.පා අවස්ථාව"),
              GeometryStep("එනයින් PMN̂ = B̂ = Q̂ වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප කෝණ"),
              GeometryStep("නමුත් මොවුන් අනුරූප කෝණ බැවින් MN // QR වේ.", "අනුරූප කෝණ සමාන බැවින්"),
              GeometryStep("සමානුපාතිකතා ප්‍රමේයයෙන්: PM / PQ = PN / PR", "MN // QR බැවින්"),
              GeometryStep("PM = AB සහ PN = AC ආදේශයෙන්: AB / PQ = AC / PR වේ.", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "සමකෝණික ත්‍රිකෝණවල සමාන කෝණවලට සම්මුඛ අනුරූප පාද අනුපාත කර හරස් ගුණිතයෙන් නොදන්නා දිග සොයන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 16.1",
              questionText = "AB = 5 cm, PQ = 15 cm සහ BC = 6 cm නම් QR හි දිග සොයන්න.",
              solutionSteps = listOf("සමරූපී ත්‍රිකෝණවල අනුරූප පාද අනුපාතය: AB / PQ = BC / QR", "5 / 15 = 6 / QR", "1 / 3 = 6 / QR ⇒ QR = 6 x 3 = 18 cm"),
              finalAnswer = "QR = 18 cm"
            ),
            examTips = "සමරූපීතාවයේදී කෝණ සමාන අනුපිළිවෙළටම ත්‍රිකෝණ නම් කිරීමෙන් අනුරූප පාද වරදින්නේ නැත."
          )
        )
      ),

      // Category 17
      GeometryCategory(
        categoryId = 17,
        titleSinhala = "17. වෘත්තයක කේන්ද්‍රය හා ජ්‍යාය ප්‍රමේය",
        shortTitle = "කේන්ද්‍රය & ජ්‍යාය",
        theoremConcept = "වෘත්තයක කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලද ලම්බකය මගින් ජ්‍යාය සමච්ඡේදනය වේ. විලෝමය: කේන්ද්‍රය හා ජ්‍යායක මධ්‍ය ලක්ෂ්‍යය යා කරන රේඛාව ජ්‍යායට ලම්බක වේ.",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "CHORD",
        generalSolvingStrategy = "කේන්ද්‍රයේ සිට අඳින ලම්බකය මගින් සෘජුකෝණී ත්‍රිකෝණයක් සෑදේ. කර්ණය = අරය (r), පාද = ජ්‍යාය/2 (d/2) සහ කේන්ද්‍රයේ සිට දුර (p) වේ. පයිතගරස්: r² = p² + (d/2)² ආදේශයෙන් ඕනෑම අගයක් සොයන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "කේන්ද්‍රය හා ජ්‍යාය ප්‍රමේයය - ලම්බකය මගින් ජ්‍යාය සමච්ඡේදනය",
            structuredQuestionText = "කේන්ද්‍රය O වූ වෘත්තයක AB ජ්‍යායට කේන්ද්‍රයේ සිට ON ලම්බකය ඇඳ ඇත.\n(i) AN = NB බව (ON මගින් AB ජ්‍යාය සමච්ඡේදනය වන බව) සාධනය කරන්න.\n(ii) අරය OA = 11 cm සහ ON = 7 cm නම් AB ජ්‍යායේ දිග ගණනය කරන්න.",
            givenData = "කේන්ද්‍රය O වූ වෘත්තයේ ON ⊥ AB වේ.",
            toProve = "AN = NB බව.",
            construction = "OA සහ OB අරයන් යා කිරීම.",
            proofSteps = listOf(
              GeometryStep("OA සහ OB අරයන් යා කරමු.", "නිර්මාණය"),
              GeometryStep("ONA △ හා ONB △ සෘජුකෝණී ත්‍රිකෝණ සලකමු.", "සාධනය ආරම්භය"),
              GeometryStep("ONÂ = ONB̂ = 90°", "දත්තය (ON ⊥ AB)"),
              GeometryStep("OA = OB", "එකම වෘත්තයේ අරයන්"),
              GeometryStep("ON = ON", "පොදු පාදය"),
              GeometryStep("එම නිසා ONA △ ≡ ONB △", "කර්ණ.පා අවස්ථාව (RHS)"),
              GeometryStep("එනයින් AN = NB වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද සමාන වේ"),
              GeometryStep("එනම් කේන්ද්‍රයේ සිට ජ්‍යායට ඇඳි ලම්බකයෙන් ජ්‍යාය සමච්ඡේදනය වේ.", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "කේන්ද්‍රයේ සිට ජ්‍යායට ඇඳි ලම්බකය, ජ්‍යායෙන් අඩ සහ අරය මගින් සෘජුකෝණී ත්‍රිකෝණයක් සෑදෙන බැවින් පයිතගරස් ප්‍රමේයය යොදන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 17.1",
              questionText = "අරය OA = 10 cm සහ කේන්ද්‍රයේ සිට ලම්බ දුර ON = 6 cm නම් AB ජ්‍යායේ දිග සොයන්න.",
              solutionSteps = listOf("ONA සෘජුකෝණී ත්‍රිකෝණයට පයිතගරස්: OA² = ON² + AN²", "10² = 6² + AN² ⇒ 100 = 36 + AN²", "AN² = 100 - 36 = 64 ⇒ AN = 8.0 cm", "AB = 2 x AN = 2 x 8.0 = 16.0 cm"),
              finalAnswer = "AB = 16.0 cm"
            ),
            examTips = "ජ්‍යායක දිග ඇසූ විට AN අගය සොයා අනිවාර්යයෙන්ම දෙගුණ කළ යුතුය."
          )
        )
      ),

      // Category 18
      GeometryCategory(
        categoryId = 18,
        titleSinhala = "18. වෘත්තයක කේන්ද්‍රයේ කෝණය හා පරිධියේ කෝණය / අර්ධ වෘත්තයේ කෝණ",
        shortTitle = "කේන්ද්‍රික & පරිධි කෝණ",
        theoremConcept = "වෘත්තයක චාපයකින් කේන්ද්‍රයේ ආපාතිත කෝණය පරිධියේ ආපාතිත කෝණය මෙන් දෙගුණයකි. එකම ඛණ්ඩයේ කෝණ සමාන වේ. අර්ධ වෘත්තයක කෝණය සෘජුකෝණයකි (90°).",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "ANGLE_CENTER",
        generalSolvingStrategy = "කේන්ද්‍රික කෝණය = 2 x පරිධියේ කෝණය සම්බන්ධය සලකුණු කරන්න. විෂ්කම්භයක් දුටු සැනින් පරිධියේ කෝණය 90° බව ලකුණු කරන්න. එකම චාපය මත පිහිටි කෝණ සමාන බවින් රයිඩරය විසඳන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "කේන්ද්‍රික සහ පරිධි කෝණ - චාපයක ආපාතිත කෝණ",
            structuredQuestionText = "කේන්ද්‍රය O වූ වෘත්තයක AB චාපයෙන් කේන්ද්‍රයේ AOB̂ කෝණය ද පරිධියේ ලක්ෂ්‍යයක් මත APB̂ කෝණය ද ආපාතනය කර ඇත.\n(i) AOB̂ = 2 x APB̂ බව සාධනය කරන්න.\n(ii) AB විෂ්කම්භයක් වන විට අර්ධ වෘත්තයේ කෝණය 90° වන බව පෙන්වන්න.\n(iii) APB̂ = 37° නම් AOB̂ කෝණයේ විශාලත්වය සොයන්න.",
            givenData = "කේන්ද්‍රය O වූ වෘත්තයේ AB චාපයෙන් සෑදූ කේන්ද්‍රික කෝණය AOB̂ ද පරිධි කෝණය APB̂ ද වේ.",
            toProve = "AOB̂ = 2 x APB̂.",
            construction = "P සහ O යා කර Q දක්වා දික් කිරීම.",
            proofSteps = listOf(
              GeometryStep("PO රේඛාව යා කර Q දක්වා දික් කරමු.", "නිර්මාණය"),
              GeometryStep("OPA ත්‍රිකෝණයේ OP = OA (අරයන්) බැවින් OPÂ = OAP̂ වේ.", "සමද්වීපාද ත්‍රිකෝණ ප්‍රමේයය"),
              GeometryStep("AOQ̂ යනු OPA △ හි බාහිර කෝණයකි.", "බාහිර කෝණ නිර්මාණය"),
              GeometryStep("AOQ̂ = OPÂ + OAP̂ = 2 x OPÂ", "බාහිර කෝණය අභ්‍යන්තර සම්මුඛ කෝණ ඓක්‍යයට සමාන වේ"),
              GeometryStep("එසේම BOQ̂ = 2 x OPB̂ වේ.", "OPB △ සලකා ඉහත පරිදිම"),
              GeometryStep("AOB̂ = AOQ̂ + BOQ̂ = 2 x (OPÂ + OPB̂) = 2 x APB̂", "කෝණ එකතුවෙන් සාධිතයි"),
              GeometryStep("AB විෂ්කම්භයක් වූ විට AOB̂ සරල රේඛාවකි (180°).", "විෂ්කම්භයේ කේන්ද්‍රික කෝණය"),
              GeometryStep("එවිට APB̂ = 180° / 2 = 90° වේ (අර්ධ වෘත්තයේ කෝණය).", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "කේන්ද්‍රික කෝණය පරිධි කෝණය මෙන් දෙගුණයක් වන බවත්, එකම ඛණ්ඩයේ කෝණ සමාන බවත් රයිඩරයට යොදාගන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 18.1",
              questionText = "APB̂ = 37° නම් කේන්ද්‍රික කෝණය AOB̂ සහ AB විෂ්කම්භයක් නම් APB̂ කෝණය ලියන්න.",
              solutionSteps = listOf("කේන්ද්‍රික කෝණය AOB̂ = 2 x APB̂ = 2 x 37° = 74°", "AB විෂ්කම්භයක් නම් අර්ධ වෘත්තයේ කෝණය = 90°"),
              finalAnswer = "AOB̂ = 74°, අර්ධ වෘත්ත කෝණය = 90°"
            ),
            examTips = "විෂ්කම්භයක් දුටු වහාම පරිධිය මත සෑදෙන කෝණය 90° ලෙස ලකුණු කරන්න."
          )
        )
      ),

      // Category 19
      GeometryCategory(
        categoryId = 19,
        titleSinhala = "19. චක්‍රීය චතුරස්‍ර ප්‍රමේය - සම්මුඛ කෝණ පරිපූරක වීම & බාහිර කෝණය",
        shortTitle = "චක්‍රීය චතුරස්‍ර",
        theoremConcept = "චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණ පරිපූරක වේ (ඓක්‍යය 180° කි). පාදයක් දික්කිරීමෙන් සෑදෙන බාහිර කෝණය අභ්‍යන්තර සම්මුඛ කෝණයට සමාන වේ.",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "CYCLIC_QUAD",
        generalSolvingStrategy = "ශීර්ෂ 4 වෘත්තය මත ඇති චතුරස්‍රයේ සම්මුඛ කෝණ එකතුව 180° බව ලියන්න. බාහිර කෝණය = අභ්‍යන්තර සම්මුඛ කෝණය රීතිය යොදා කෝණ අගයන් හෝ සමාන්තර රේඛා සාධනය කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "චක්‍රීය චතුරස්‍ර ප්‍රමේයය - සම්මුඛ කෝණ පරිපූරක වීම",
            structuredQuestionText = "ABCD යනු කේන්ද්‍රය O වූ වෘත්තයක පිහිටි චක්‍රීය චතුරස්‍රයකි.\n(i) DAB̂ + DCB̂ = 180° බව සාධනය කරන්න.\n(ii) AB පාදය E දක්වා දික්කළ විට සෑදෙන CBÊ බාහිර කෝණය ADĈ අභ්‍යන්තර සම්මුඛ කෝණයට සමාන බව පෙන්වන්න.\n(iii) DAB̂ = 80° නම් DCB̂ සහ බාහිර කෝණය සොයන්න.",
            givenData = "ABCD යනු චක්‍රීය චතුරස්‍රයකි.",
            toProve = "DAB̂ + DCB̂ = 180° සහ CBÊ = ADĈ.",
            construction = "කේන්ද්‍රය O වෙත OB සහ OD අරයන් යා කිරීම.",
            proofSteps = listOf(
              GeometryStep("OB සහ OD අරයන් යා කරමු.", "නිර්මාණය"),
              GeometryStep("සුළු චාපයෙන් කේන්ද්‍රයේ කෝණය BOD̂ (සුළු) = 2 x BCD̂", "කේන්ද්‍රික කෝණය පරිධියේ කෝණය මෙන් දෙගුණයකි"),
              GeometryStep("මහා චාපයෙන් කේන්ද්‍රයේ කෝණය BOD̂ (ප්‍රතිවර්ත) = 2 x BAD̂", "කේන්ද්‍රික කෝණය පරිධියේ කෝණය මෙන් දෙගුණයකි"),
              GeometryStep("නමුත් ලක්ෂ්‍යයක් වටා කෝණ ඓක්‍යය = 360°", "කේන්ද්‍රය වටා සම්පූර්ණ කෝණය"),
              GeometryStep("BOD̂ (සුළු) + BOD̂ (ප්‍රතිවර්ත) = 360°", "කෝණ ඓක්‍යය"),
              GeometryStep("2 x BCD̂ + 2 x BAD̂ = 360°", "ආදේශය"),
              GeometryStep("දෙපසම 2න් බෙදීමෙන්: BAD̂ + BCD̂ = 180° වේ.", "චක්‍රීය චතුරස්‍රයේ සම්මුඛ කෝණ පරිපූරක වේ"),
              GeometryStep("ABĈ + CBÊ = 180° සහ ABĈ + ADĈ = 180°", "සරල රේඛා බද්ධ කෝණ සහ සම්මුඛ කෝණ"),
              GeometryStep("එම නිසා CBÊ = ADĈ (බාහිර කෝණය = අභ්‍යන්තර සම්මුඛ කෝණය)", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "චක්‍රීය චතුරස්‍රයේ සම්මුඛ කෝණ එකතුව 180° බැවින් එක් කෝණයක් දුන් විට අනෙක 180න් අඩුකර ලබාගත හැක.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 19.1",
              questionText = "DAB̂ = 80° නම් සම්මුඛ කෝණය DCB̂ සහ බාහිර කෝණයේ අගය සොයන්න.",
              solutionSteps = listOf("චක්‍රීය චතුරස්‍රයේ සම්මුඛ කෝණ ඓක්‍යය: DAB̂ + DCB̂ = 180°", "DCB̂ = 180° - 80° = 100°", "බාහිර කෝණය = අභ්‍යන්තර සම්මුඛ කෝණය = 80°"),
              finalAnswer = "DCB̂ = 100°, බාහිර කෝණය = 80°"
            ),
            examTips = "ශීර්ෂ 4ම වෘත්තයේ පරිධිය මත ඇත්නම් පමණක් චක්‍රීය චතුරස්‍ර ප්‍රමේයය යෙදිය හැක."
          )
        )
      ),

      // Category 20
      GeometryCategory(
        categoryId = 20,
        titleSinhala = "20. වෘත්තයක ස්පර්ශක ප්‍රමේය සහ ඒකාන්තර ඛණ්ඩ ප්‍රමේයය",
        shortTitle = "ස්පර්ශක & ඒකාන්තර ඛණ්ඩය",
        theoremConcept = "ස්පර්ශ ලක්ෂ්‍යයේදී අරය ස්පර්ශකයට ලම්බක වේ. බාහිර ලක්ෂ්‍යයක සිට අඳින ස්පර්ශක දෙක දිගින් සමාන වේ. ස්පර්ශකය හා ජ්‍යාය අතර කෝණය ඒකාන්තර ඛණ්ඩයේ කෝණයට සමාන වේ.",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "TANGENT",
        generalSolvingStrategy = "ස්පර්ශකය හා ජ්‍යාය හමුවන තැන කෝණය ඒකාන්තර ඛණ්ඩයේ කෝණයට සමාන බව (TAB̂ = BCÂ) සලකුණු කරන්න. O/L B කොටසේ ලකුණු 10 ප්‍රශ්නය සඳහා මෙය සහ චක්‍රීය චතුරස්‍ර ප්‍රමේය එකට යොදා සාධනය කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "ස්පර්ශක සහ ඒකාන්තර ඛණ්ඩ ප්‍රමේයය - O/L සම්මත ආකෘතිය",
            structuredQuestionText = "කේන්ද්‍රය O වූ වෘත්තයක A ලක්ෂ්‍යයේදී TAT' ස්පර්ශකය ඇඳ ඇත. AB යනු ජ්‍යායක් වන අතර C යනු ඒකාන්තර වෘත්ත ඛණ්ඩයේ ලක්ෂ්‍යයකි.\n(i) TAB̂ = BCÂ (ඒකාන්තර ඛණ්ඩ ප්‍රමේයය) බව සාධනය කරන්න.\n(ii) බාහිර ලක්ෂ්‍යයක සිට අඳින ස්පර්ශක දෙක දිගින් සමාන බව පෙන්වන්න.\n(iii) TAB̂ = 52° සහ ABĈ = 60° නම් CAB̂ කෝණයේ විශාලත්වය ගණනය කරන්න.",
            givenData = "TAT' යනු A හිදී ස්පර්ශකයකි. AB ජ්‍යායක් සහ C ඒකාන්තර ඛණ්ඩයේ ලක්ෂ්‍යයකි.",
            toProve = "TAB̂ = BCÂ (ඒකාන්තර ඛණ්ඩ ප්‍රමේයය).",
            construction = "A හරහා AD විෂ්කම්භය ඇඳ DB යා කිරීම.",
            proofSteps = listOf(
              GeometryStep("A හරහා AD විෂ්කම්භය ඇඳ DB යා කරමු.", "නිර්මාණය"),
              GeometryStep("TAD̂ = 90°", "ස්පර්ශ ලක්ෂ්‍යයේදී අරය ස්පර්ශකයට ලම්බක වේ"),
              GeometryStep("TAB̂ + BAD̂ = 90° ⇒ TAB̂ = 90° - BAD̂", "කෝණ සම්බන්ධය"),
              GeometryStep("ABD̂ = 90°", "අර්ධ වෘත්තයක කෝණය සෘජුකෝණයකි (AD විෂ්කම්භයයි)"),
              GeometryStep("ABD ත්‍රිකෝණයේ: ADB̂ = 180° - (90° + BAD̂) = 90° - BAD̂", "ත්‍රිකෝණයේ කෝණ ඓක්‍යය"),
              GeometryStep("එම නිසා TAB̂ = ADB̂ වේ.", "දෙකම (90° - BAD̂) ට සමාන බැවින්"),
              GeometryStep("නමුත් ADB̂ = BCÂ වේ.", "එකම ඛණ්ඩයේ කෝණ සමාන වේ (AB චාපයෙන් සෑදුණු)"),
              GeometryStep("එනයින් TAB̂ = BCÂ වේ.", "සාධනය සම්පූර්ණයි (ඒකාන්තර ඛණ්ඩ ප්‍රමේයය)")
            ),
            riderExplanation = "ස්පර්ශකය හා ජ්‍යාය අතර කෝණය දුටු සැනින් ඒකාන්තර ඛණ්ඩයේ කෝණයට සමාන බව ලකුණු කර ත්‍රිකෝණයේ කෝණ ඓක්‍යය 180° යොදන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 20.1",
              questionText = "TAB̂ = 52° සහ ABĈ = 60° නම් BCÂ සහ CAB̂ කෝණ සොයන්න.",
              solutionSteps = listOf("ඒකාන්තර ඛණ්ඩ ප්‍රමේයය අනුව: BCÂ = TAB̂ = 52°", "ABC ත්‍රිකෝණයේ කෝණ ඓක්‍යය = 180°", "CAB̂ = 180° - (52° + 60°) = 180° - 112° = 68°"),
              finalAnswer = "BCÂ = 52°, CAB̂ = 68°"
            ),
            examTips = "O/L B කොටසේ ලකුණු 10 ප්‍රශ්නය බොහෝ විට මෙම ප්‍රමේයය හා චක්‍රීය චතුරස්‍ර සම්බන්ධ කර සැකසේ."
          )
        )
      )
    )
  }
}
