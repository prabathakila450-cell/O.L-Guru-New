package com.example

// ==============================================================================
// GEOMETRY STRUCTURED QUESTIONS & RIDERS: GeometryDataPart1
// Categories 1 to 5: 100% Unique, authentic O/L Geometry Structured Questions
// Guarantees each theorem has a distinct, non-repeating comprehensive question.
// ==============================================================================

object GeometryDataPart1 {
  fun getCategories(): List<GeometryCategory> {
    return listOf(
      // Category 1
      GeometryCategory(
        categoryId = 1,
        titleSinhala = "1. ත්‍රිකෝණ අංගසාම්‍යය - පා.කෝ.පා (SAS)",
        shortTitle = "පා.කෝ.පා (SAS)",
        theoremConcept = "ත්‍රිකෝණ දෙකක පාද දෙකක් හා අන්තර්ගත කෝණය පිළිවෙළින් සමාන නම් එම ත්‍රිකෝණ අංගසාම්‍ය වේ.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "TRIANGLE_CONGRUENCE",
        generalSolvingStrategy = "පළමුව රූප සටහනේ සමාන පාද යුගල දෙක ලකුණු කරන්න. අනතුරුව එම පාද අතර පිහිටි අන්තර්ගත කෝණය සමාන බව (දත්තයෙන්, ප්‍රතිමුඛ කෝණ හෝ කෝණ සමච්ඡේදකයෙන්) සාධනය කරන්න. අංගසාම්‍යයෙන් පසු අනුරූප පාද සමාන බවින් රයිඩරය ගණනය කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "පා.කෝ.පා අවස්ථාව - ත්‍රිකෝණ අංගසාම්‍යය සහ අනුබද්ධ සාධනය",
            structuredQuestionText = "ABC ත්‍රිකෝණයේ AB = AC වේ. A හි අභ්‍යන්තර කෝණ සමච්ඡේදකය BC පාදය D හිදී හමුවේ.\n(i) ABD △ ≡ ACD △ බව සාධනය කරන්න.\n(ii) AD ⊥ BC බවත්, BD = DC වන බවත් ඔප්පු කරන්න.\n(iii) BC = 12 cm සහ AB = 10 cm නම් AD හි දිග ගණනය කරන්න.",
            givenData = "AB = AC වන අතර BAD̂ = CAD̂ වේ.",
            toProve = "(i) ABD △ ≡ ACD △, (ii) AD ⊥ BC සහ BD = DC.",
            construction = "අවශ්‍ය නොවේ.",
            proofSteps = listOf(
              GeometryStep("ABD △ හා ACD △ සලකමු.", "සාධනය ආරම්භය"),
              GeometryStep("AB = AC", "දත්තය"),
              GeometryStep("BAD̂ = CAD̂", "දත්තය (AD යනු කෝණ සමච්ඡේදකයයි)"),
              GeometryStep("AD = AD", "පොදු පාදය"),
              GeometryStep("එම නිසා ABD △ ≡ ACD △", "පා.කෝ.පා අවස්ථාව (SAS)"),
              GeometryStep("එනයින් BD = DC", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද සමාන වේ"),
              GeometryStep("ADB̂ = ADĈ", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප කෝණ සමාන වේ"),
              GeometryStep("ADB̂ + ADĈ = 180°", "සරල රේඛාවක් මත බද්ධ කෝණ ඓක්‍යය 180° කි"),
              GeometryStep("එම නිසා ADB̂ = ADĈ = 90° (AD ⊥ BC)", "කෝණ දෙක සමාන බැවින්")
            ),
            riderExplanation = "අංගසාම්‍යයෙන් BD = DC බව ලැබුණු පසු සෘජුකෝණී ත්‍රිකෝණයට පයිතගරස් ප්‍රමේයය ආදේශ කර AD හි උස නිවැරදිව සොයාගත හැක.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 1.1",
              questionText = "BC = 12 cm සහ AB = 10 cm නම් AD හි දිග සොයන්න.",
              solutionSteps = listOf("BD = DC = BC / 2 = 12 / 2 = 6 cm", "ADB සෘජුකෝණී ත්‍රිකෝණයට පයිතගරස්: AB² = AD² + BD²", "10² = AD² + 6² ⇒ 100 = AD² + 36", "AD² = 100 - 36 = 64 ⇒ AD = 8.0 cm"),
              finalAnswer = "AD = 8.0 cm"
            ),
            examTips = "පා.කෝ.පා අවස්ථාවේදී අන්තර්ගත කෝණයම තෝරාගැනීමට වගබලා ගන්න."
          )
        )
      ),

      // Category 2
      GeometryCategory(
        categoryId = 2,
        titleSinhala = "2. ත්‍රිකෝණ අංගසාම්‍යය - කෝ.කෝ.පා / කෝ.පා.කෝ (AAS/ASA)",
        shortTitle = "කෝ.කෝ.පා (AAS)",
        theoremConcept = "ත්‍රිකෝණ දෙකක කෝණ දෙකක් හා එක් පාදයක් අනුරූපව සමාන නම් එම ත්‍රිකෝණ අංගසාම්‍ය වේ.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "TRIANGLE_CONGRUENCE",
        generalSolvingStrategy = "කෝණ දෙකක් (ඒකාන්තර, අනුරූප, ප්‍රතිමුඛ හෝ දත්ත) සමාන බවත්, එක් පාදයක් (පොදු පාදය හෝ දත්තය) සමාන බවත් දක්වා අංගසාම්‍ය බව ඔප්පු කරන්න. අනුරූප පාද සමාන බව ගෙන රයිඩරය විසඳන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "කෝ.කෝ.පා / කෝ.පා.කෝ - සමාන්තර රේඛා හා අනුරූප පාද",
            structuredQuestionText = "රූපයේ AB // CD වන අතර AD සහ BC රේඛා O හිදී එකිනෙක ඡේදනය වේ. O යනු AD හි මධ්‍ය ලක්ෂ්‍යයයි (AO = OD).\n(i) AOB △ ≡ DOC △ බව සාධනය කරන්න.\n(ii) O යනු BC හිද මධ්‍ය ලක්ෂ්‍යය බව පෙන්වන්න.\n(iii) AB = CD බව නිගමනය කරන්න.",
            givenData = "AB // CD සහ AO = OD වේ.",
            toProve = "AOB △ ≡ DOC △ සහ BO = OC, AB = CD.",
            construction = "අවශ්‍ය නොවේ.",
            proofSteps = listOf(
              GeometryStep("AOB △ හා DOC △ සලකමු.", "සාධනය ආරම්භය"),
              GeometryStep("OAB̂ = ODĈ", "AB // CD බැවින් ඒකාන්තර කෝණ සමාන වේ"),
              GeometryStep("AO = OD", "දත්තය (O යනු AD හි මධ්‍ය ලක්ෂ්‍යයයි)"),
              GeometryStep("AOB̂ = DOĈ", "ප්‍රතිමුඛ කෝණ සමාන වේ"),
              GeometryStep("එම නිසා AOB △ ≡ DOC △", "කෝ.පා.කෝ අවස්ථාව (ASA)"),
              GeometryStep("එනයින් BO = OC වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද"),
              GeometryStep("එසේම AB = CD වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද")
            ),
            riderExplanation = "අංගසාම්‍යයෙන් ලැබෙන අනුරූප පාද සමානතාවයෙන් BO = OC බව පෙන්වා O යනු BC හි මධ්‍ය ලක්ෂ්‍යය බව තහවුරු කළ හැක.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 2.1",
              questionText = "CD = 7 cm සහ BC = 11 cm නම් AB සහ BO හි දිගවල් සොයන්න.",
              solutionSteps = listOf("AOB △ ≡ DOC △ බැවින් AB = CD = 7 cm", "BO = OC = BC / 2 = 11 / 2 = 5.5 cm"),
              finalAnswer = "AB = 7 cm, BO = 5.5 cm"
            ),
            examTips = "ඒකාන්තර කෝණ ලියන විට සමාන්තර රේඛා යුගලය (AB // CD) වරහන් තුළ සඳහන් කිරීම අනිවාර්ය වේ."
          )
        )
      ),

      // Category 3
      GeometryCategory(
        categoryId = 3,
        titleSinhala = "3. ත්‍රිකෝණ අංගසාම්‍යය - පා.පා.පා සහ කර්ණ.පා (SSS & RHS)",
        shortTitle = "පා.පා.පා / කර්ණ.පා",
        theoremConcept = "සෘජුකෝණී ත්‍රිකෝණ දෙකක කර්ණය හා එක් පාදයක් සමාන නම් (කර්ණ.පා) හෝ ත්‍රිකෝණ දෙකක පාද තුනම සමාන නම් (පා.පා.පා) අංගසාම්‍ය වේ.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "TRIANGLE_CONGRUENCE",
        generalSolvingStrategy = "කර්ණ.පා අවස්ථාවේදී සෘජුකෝණය (90°), පොදු කර්ණය හා අනෙක් පාදය හඳුනාගන්න. සාධනයෙන් පසු පයිතගරස් ප්‍රමේයය ආදේශයෙන් රයිඩරයේ දිගවල් ගණනය කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "කර්ණ.පා / පා.පා.පා - සෘජුකෝණී ත්‍රිකෝණ අංගසාම්‍යය",
            structuredQuestionText = "PQR සමද්වීපාද ත්‍රිකෝණයේ PQ = PR වේ. Q සහ R හි සිට සම්මුඛ පාදවලට QM ⊥ PR සහ RN ⊥ PQ ලම්බක ඇඳ ඇත.\n(i) QNR △ ≡ RMQ △ බව සාධනය කරන්න.\n(ii) QM = RN (ශීර්ෂ ලම්බ සමාන) බව පෙන්වන්න.",
            givenData = "PQ = PR, QNR̂ = RMQ̂ = 90° වේ.",
            toProve = "QNR △ ≡ RMQ △ සහ QM = RN.",
            construction = "අවශ්‍ය නොවේ.",
            proofSteps = listOf(
              GeometryStep("QNR △ හා RMQ △ සෘජුකෝණී ත්‍රිකෝණ සලකමු.", "සාධනය ආරම්භය"),
              GeometryStep("QNR̂ = RMQ̂ = 90°", "දත්තය (ලම්බක බැවින්)"),
              GeometryStep("QR = QR", "පොදු කර්ණය"),
              GeometryStep("NQR̂ = MRQ̂", "PQ = PR බැවින් සමද්වීපාද ත්‍රිකෝණයක සමාන පාදවලට සම්මුඛ කෝණ"),
              GeometryStep("එම නිසා QNR △ ≡ RMQ △", "කෝ.කෝ.පා (කර්ණය හා කෝණය) අවස්ථාව"),
              GeometryStep("එනයින් QM = RN වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද සමාන වේ")
            ),
            riderExplanation = "අංගසාම්‍යයෙන් ශීර්ෂ ලම්බ සමාන බව ඔප්පු කළ පසු පයිතගරස් ප්‍රමේයයෙන් පාද ඛණ්ඩයේ දිග සෘජුවම ලැබේ.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 3.1",
              questionText = "QR = 12 cm සහ QM = 7 cm නම් MR හි දිග ගණනය කරන්න.",
              solutionSteps = listOf("QMR සෘජුකෝණී ත්‍රිකෝණයට පයිතගරස්: QR² = QM² + MR²", "12² = 7² + MR² ⇒ 144 = 49 + MR²", "MR² = 95 ⇒ MR = 9.7 cm"),
              finalAnswer = "MR = 9.7 cm"
            ),
            examTips = "සෘජුකෝණී ත්‍රිකෝණයක කර්ණය හඳුනාගැනීමට 90° කෝණයට සම්මුඛ පාදය බලන්න."
          )
        )
      ),

      // Category 4
      GeometryCategory(
        categoryId = 4,
        titleSinhala = "4. සමද්වීපාද හා සමපාද ත්‍රිකෝණ ප්‍රමේය",
        shortTitle = "සමද්වීපාද ත්‍රිකෝණ",
        theoremConcept = "ත්‍රිකෝණයක පාද දෙකක් සමාන නම් ඒවාට සම්මුඛ කෝණ සමාන වේ. විලෝමය: කෝණ දෙකක් සමාන නම් සම්මුඛ පාද සමාන වේ.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "ISOSCELES",
        generalSolvingStrategy = "සමද්වීපාද ත්‍රිකෝණවල සමාන පාදවලට සම්මුඛ කෝණ සමාන බව ලියන්න. ශීර්ෂයේ සිට අඳින ලම්බකය ආධාරකය සමච්ඡේදනය කරන බවත්, ශීර්ෂ කෝණය සමච්ඡේදනය කරන බවත් රයිඩර් ගැටලුවලදී භාවිත කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "සමද්වීපාද ප්‍රමේයය - සම්මුඛ කෝණ සහ පාද",
            structuredQuestionText = "ABC ත්‍රිකෝණයේ AB = AC වේ. BC පාදය දෙපසට D සහ E දක්වා දික්කර ඇත්තේ BD = CE වන පරිදිය.\n(i) ABD △ ≡ ACE △ බව සාධනය කරන්න.\n(ii) ADE △ සමද්වීපාද ත්‍රිකෝණයක් බව පෙන්වන්න.",
            givenData = "AB = AC සහ BD = CE වේ.",
            toProve = "ABD △ ≡ ACE △ සහ AD = AE (ADE △ සමද්වීපාද වේ).",
            construction = "A හා D ද, A හා E ද යා කිරීම.",
            proofSteps = listOf(
              GeometryStep("AB = AC බැවින් ABĈ = ACB̂ වේ.", "සමද්වීපාද ත්‍රිකෝණයේ සමාන පාදවලට සම්මුඛ කෝණ"),
              GeometryStep("ABD̂ = 180° - ABĈ සහ ACÊ = 180° - ACB̂", "සරල රේඛාවක් මත බද්ධ කෝණ"),
              GeometryStep("එම නිසා ABD̂ = ACÊ වේ.", "පරිපූරක කෝණ සමාන බැවින්"),
              GeometryStep("දැන් ABD △ හා ACE △ සලකමු.", "ත්‍රිකෝණ යුගලය"),
              GeometryStep("AB = AC", "දත්තය"),
              GeometryStep("ABD̂ = ACÊ", "ඉහත සාධිතයි"),
              GeometryStep("BD = CE", "දත්තය"),
              GeometryStep("එම නිසා ABD △ ≡ ACE △", "පා.කෝ.පා අවස්ථාව (SAS)"),
              GeometryStep("එනයින් AD = AE වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද සමාන වේ"),
              GeometryStep("පාද දෙකක් සමාන බැවින් ADE △ සමද්වීපාද ත්‍රිකෝණයකි.", "සමද්වීපාද ත්‍රිකෝණ අර්ථ දැක්වීම")
            ),
            riderExplanation = "අනුබද්ධ කෝණ ගණනය කිරීමේදී සමද්වීපාද ත්‍රිකෝණයේ අභ්‍යන්තර කෝණ ඓක්‍යය 180° ක් බව යොදාගන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 4.1",
              questionText = "BAĈ = 45° නම් ABĈ කෝණය සොයන්න.",
              solutionSteps = listOf("ABC △ හි කෝණ ඓක්‍යය = 180°", "ABĈ + ACB̂ = 180° - 45° = 135°", "AB = AC බැවින් ABĈ = ACB̂", "ABĈ = 135° / 2 = 67.5°"),
              finalAnswer = "ABĈ = 67.5°"
            ),
            examTips = "සමද්වීපාද ත්‍රිකෝණයක සමාන පාදවලට සම්මුඛ කෝණ සමාන බවට ලකුණු හිමිවේ."
          )
        )
      ),

      // Category 5
      GeometryCategory(
        categoryId = 5,
        titleSinhala = "5. සමාන්තර රේඛා සහ කෝණ ප්‍රමේය",
        shortTitle = "සමාන්තර රේඛා & කෝණ",
        theoremConcept = "සමාන්තර රේඛා තීර්යක් රේඛාවකින් ඡේදනය වූ විට: ඒකාන්තර කෝණ සමාන වේ, අනුරූප කෝණ සමාන වේ, අභ්‍යන්තර මිත්‍ර කෝණ ඓක්‍යය 180° කි.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "PARALLEL",
        generalSolvingStrategy = "සමාන්තර රේඛා අතර Z හැඩයේ ඒකාන්තර කෝණ, F හැඩයේ අනුරූප කෝණ සහ C හැඩයේ අභ්‍යන්තර මිත්‍ර කෝණ (180°) සලකුණු කර සමීකරණ ගොඩනගා නොදන්නා කෝණ අගයන් සොයන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "සමාන්තර රේඛා - ඒකාන්තර, අනුරූප හා මිත්‍ර කෝණ",
            structuredQuestionText = "රූපයේ AB // CD වේ. EF තීර්යක් රේඛාව AB රේඛාව P හිදී ද CD රේඛාව Q හිදී ද ඡේදනය කරයි. P සහ Q හි අභ්‍යන්තර කෝණ සමච්ඡේදක R හිදී හමුවේ.\n(i) PRQ̂ = 90° බව සාධනය කරන්න.\n(ii) BPQ̂ = 76° නම් RPQ̂ සහ RQP̂ කෝණ සොයන්න.",
            givenData = "AB // CD වන අතර PR සහ QR යනු අභ්‍යන්තර කෝණ සමච්ඡේදක වේ.",
            toProve = "PRQ̂ = 90° බව.",
            construction = "අවශ්‍ය නොවේ.",
            proofSteps = listOf(
              GeometryStep("AB // CD බැවින් BPQ̂ + DQP̂ = 180° වේ.", "අභ්‍යන්තර මිත්‍ර කෝණ ඓක්‍යය 180° කි"),
              GeometryStep("RPQ̂ = BPQ̂ / 2 සහ RQP̂ = DQP̂ / 2", "PR හා QR කෝණ සමච්ඡේදක බැවින්"),
              GeometryStep("RPQ̂ + RQP̂ = (BPQ̂ + DQP̂) / 2 = 180° / 2 = 90°", "දෙපසම 2න් බෙදීමෙන්"),
              GeometryStep("PQR ත්‍රිකෝණයේ අභ්‍යන්තර කෝණ ඓක්‍යය = 180°", "ත්‍රිකෝණයක කෝණ ඓක්‍යය"),
              GeometryStep("PRQ̂ + RPQ̂ + RQP̂ = 180°", "කෝණ ආදේශය"),
              GeometryStep("PRQ̂ + 90° = 180° ⇒ PRQ̂ = 90°", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "මිත්‍ර කෝණ සමච්ඡේදක එකිනෙකට ලම්බක වන බව භාවිතයෙන් රයිඩර් ගැටලුවේ කෝණ අගයන් සෘජුවම ලැබේ.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 5.1",
              questionText = "BPQ̂ = 76° නම් RPQ̂ සහ RQP̂ කෝණවල අගයන් ගණනය කරන්න.",
              solutionSteps = listOf("RPQ̂ = 76° / 2 = 38°", "DQP̂ = 180° - 76° = 104° (මිත්‍ර කෝණ)", "RQP̂ = 104° / 2 = 52°"),
              finalAnswer = "RPQ̂ = 38°, RQP̂ = 52°"
            ),
            examTips = "මිත්‍ර කෝණ එකතු කළ විට 180° ක් වන අතර ඒකාන්තර කෝණ එකිනෙකට සමාන වේ."
          )
        )
      )
    )
  }
}
