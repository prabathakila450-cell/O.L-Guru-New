package com.example

// ==============================================================================
// GEOMETRY STRUCTURED QUESTIONS & RIDERS: GeometryDataPart2
// Categories 6 to 10: 100% Unique, authentic O/L Geometry Structured Questions
// Guarantees each theorem has a distinct, non-repeating comprehensive question.
// ==============================================================================

object GeometryDataPart2 {
  fun getCategories(): List<GeometryCategory> {
    return listOf(
      // Category 6
      GeometryCategory(
        categoryId = 6,
        titleSinhala = "6. ත්‍රිකෝණයක බාහිර කෝණ සහ අභ්‍යන්තර කෝණ ඓක්‍යය",
        shortTitle = "බාහිර කෝණ ප්‍රමේයය",
        theoremConcept = "ත්‍රිකෝණයක පාදයක් දික්කිරීමෙන් සෑදෙන බාහිර කෝණය එහි අභ්‍යන්තර සම්මුඛ කෝණ දෙකෙහි ඓක්‍යයට සමාන වේ. අභ්‍යන්තර කෝණ ඓක්‍යය 180° කි.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "ISOSCELES",
        generalSolvingStrategy = "බාහිර කෝණය = අභ්‍යන්තර සම්මුඛ කෝණ දෙකෙහි එකතුව සූත්‍රය ලියන්න. ත්‍රිකෝණය සමද්වීපාද වූ විට බාහිර කෝණය එක් අභ්‍යන්තර කෝණයක දෙගුණයක් වන ආකාරය රයිඩරයට යොදාගන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "බාහිර කෝණ ප්‍රමේයය - ත්‍රිකෝණ අභ්‍යන්තර සම්මුඛ කෝණ",
            structuredQuestionText = "ABC ත්‍රිකෝණයේ BC පාදය D දක්වා දික්කර ඇත. ACD̂ යනු බාහිර කෝණයයි.\n(i) ACD̂ = CAB̂ + ABĈ බව සාධනය කරන්න.\n(ii) ABC සමද්වීපාද ත්‍රිකෝණයක් (AB = AC) නම්, ACD̂ = 2 x ABĈ වන බව පෙන්වන්න.",
            givenData = "ABC △ හි BC පාදය D දක්වා දික්කර ඇත.",
            toProve = "(i) ACD̂ = CAB̂ + ABĈ, (ii) AB = AC නම් ACD̂ = 2 x ABĈ.",
            construction = "C හරහා AB ට සමාන්තරව CE රේඛාවක් ඇඳීම.",
            proofSteps = listOf(
              GeometryStep("C හරහා AB // CE රේඛාවක් අඳිමු.", "නිර්මාණය"),
              GeometryStep("ACÊ = CAB̂", "AB // CE බැවින් ඒකාන්තර කෝණ සමාන වේ"),
              GeometryStep("ECD̂ = ABĈ", "AB // CE බැවින් අනුරූප කෝණ සමාන වේ"),
              GeometryStep("ACD̂ = ACÊ + ECD̂", "කෝණ එකතුව"),
              GeometryStep("එම නිසා ACD̂ = CAB̂ + ABĈ වේ.", "ආදේශයෙන් සාධිතයි"),
              GeometryStep("AB = AC නම් CAB̂ = ACB̂ නොවේ, ABĈ = ACB̂ වේ.", "සමද්වීපාද ත්‍රිකෝණයක සම්මුඛ කෝණ"),
              GeometryStep("නමුත් A ශීර්ෂය නම් AB = AC බැවින් ABĈ = ACB̂", "කෝණ ආදේශයෙන් ACD̂ = 2 x ABĈ සාධිතයි")
            ),
            riderExplanation = "බාහිර කෝණය අභ්‍යන්තර සම්මුඛ කෝණ දෙකෙහි එකතුවට සමාන වන රීතියෙන් නොදන්නා කෝණය ගණනය කරන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 6.1",
              questionText = "ACD̂ = 105° සහ ABĈ = 52° නම් CAB̂ කෝණය සොයන්න.",
              solutionSteps = listOf("බාහිර කෝණ ප්‍රමේයය: ACD̂ = CAB̂ + ABĈ", "105° = CAB̂ + 52°", "CAB̂ = 105° - 52° = 53°"),
              finalAnswer = "CAB̂ = 53°"
            ),
            examTips = "බාහිර කෝණය සෑම විටම සරල රේඛාවක් දික්කිරීමෙන් සෑදෙන බව තහවුරු කරගන්න."
          )
        )
      ),

      // Category 7
      GeometryCategory(
        categoryId = 7,
        titleSinhala = "7. බහුඅස්‍රවල අභ්‍යන්තර හා බාහිර කෝණ",
        shortTitle = "බහුඅස්‍ර කෝණ ප්‍රමේය",
        theoremConcept = "පාද n ඇති ඕනෑම සංවෘත බහුඅස්‍රයක අභ්‍යන්තර කෝණ ඓක්‍යය = (2n - 4) සෘජුකෝණ හෙවත් (n - 2) x 180° වේ. ඕනෑම බහුඅස්‍රයක බාහිර කෝණ ඓක්‍යය 360° කි.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "PARALLELOGRAM",
        generalSolvingStrategy = "සුසම බහුඅස්‍රයක එක් බාහිර කෝණයක් = 360° / n වේ. එක් අභ්‍යන්තර කෝණයක් = 180° - බාහිර කෝණය වේ. පාද ගණන සෙවීමට 360° දී ඇති බාහිර කෝණයෙන් බෙදන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "බහුඅස්‍ර ප්‍රමේයය - සුසම බහුඅස්‍ර අභ්‍යන්තර හා බාහිර කෝණ",
            structuredQuestionText = "පාද 6ක් ඇති සුසම බහුඅස්‍රයක් සලකන්න.\n(i) එහි අභ්‍යන්තර කෝණවල ඓක්‍යය (2n - 4) x 90° සූත්‍රයෙන් ගණනය කරන්න.\n(ii) එක් බාහිර කෝණයක විශාලත්වය සොයන්න.\n(iii) එක් අභ්‍යන්තර කෝණයක විශාලත්වය ගණනය කරන්න.",
            givenData = "පාද 6ක් ඇති සුසම බහුඅස්‍රයකි.",
            toProve = "අභ්‍යන්තර කෝණ ඓක්‍යය, එක් බාහිර හා අභ්‍යන්තර කෝණය සෙවීම.",
            construction = "අවශ්‍ය නොවේ.",
            proofSteps = listOf(
              GeometryStep("ඕනෑම බහුඅස්‍රයක අභ්‍යන්තර කෝණ ඓක්‍යය = (n - 2) x 180°", "බහුඅස්‍ර ප්‍රමේයය"),
              GeometryStep("n = 6 ආදේශයෙන්: (6 - 2) x 180° = 4 x 180° = 720°", "ගණනය කිරීම"),
              GeometryStep("ඕනෑම බහුඅස්‍රයක බාහිර කෝණ ඓක්‍යය = 360° කි", "බාහිර කෝණ ප්‍රමේයය"),
              GeometryStep("සුසම බහුඅස්‍රයක එක් බාහිර කෝණයක් = 360° / 6 = 60.0°", "සුසම බහුඅස්‍ර අර්ථ දැක්වීම"),
              GeometryStep("එක් අභ්‍යන්තර කෝණයක් = 180° - 60.0° = 120.0°", "සරල රේඛාවක් මත බද්ධ කෝණ")
            ),
            riderExplanation = "සුසම බහුඅස්‍රයක පාද ගණන සෙවීමට 360° එක් බාහිර කෝණයෙන් බෙදීම පහසුම ක්‍රමයයි.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 7.1",
              questionText = "සුසම බහුඅස්‍රයක එක් අභ්‍යන්තර කෝණයක් 120.0° නම් එහි පාද ගණන සොයන්න.",
              solutionSteps = listOf("එක් බාහිර කෝණයක් = 180° - 120.0° = 60.0°", "පාද ගණන n = 360° / එක් බාහිර කෝණය", "n = 360° / 60.0° = 6"),
              finalAnswer = "පාද ගණන = 6"
            ),
            examTips = "අභ්‍යන්තර කෝණයෙන් පාද ගණන සෙවීමට වඩා බාහිර කෝණයෙන් සෙවීම ලකුණු ලබාගැනීමට පහසුම ක්‍රමයයි."
          )
        )
      ),

      // Category 8
      GeometryCategory(
        categoryId = 8,
        titleSinhala = "8. සමාන්තරාස්‍ර ප්‍රමේය 1 - සම්මුඛ පාද හා සම්මුඛ කෝණ",
        shortTitle = "සමාන්තරාස්‍ර සම්මුඛ අංග",
        theoremConcept = "සමාන්තරාස්‍රයක සම්මුඛ පාද සමාන වේ, සම්මුඛ කෝණ සමාන වේ. විලෝමය: චතුරස්‍රයක සම්මුඛ පාද යුගල සමාන නම් හෝ එක් සම්මුඛ පාද යුගලක් සමාන හා සමාන්තර නම් එය සමාන්තරාස්‍රයකි.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "PARALLELOGRAM",
        generalSolvingStrategy = "සමාන්තරාස්‍රයේ විකර්ණයක් ඇඳීමෙන් සෑදෙන ත්‍රිකෝණ දෙක අංගසාම්‍ය බව ඔප්පු කිරීමෙන් සම්මුඛ පාද හා සම්මුඛ කෝණ සමාන බව සාධනය කෙරේ. අනතුරුව පරිමිතිය හෝ කෝණ ගණනය කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "සමාන්තරාස්‍ර ප්‍රමේය 1 - සම්මුඛ පාද හා කෝණ සමානතාව",
            structuredQuestionText = "ABCD සමාන්තරාස්‍රයේ AC විකර්ණය ඇඳ ඇත.\n(i) ABC △ ≡ CDA △ බව සාධනය කරන්න.\n(ii) ඒ නයින් AB = CD බවත්, AD = BC බවත්, ABĈ = ADĈ බවත් පෙන්වන්න.",
            givenData = "ABCD සමාන්තරාස්‍රයකි (AB // CD සහ AD // BC).",
            toProve = "ABC △ ≡ CDA △ සහ AB = CD, AD = BC, ABĈ = ADĈ.",
            construction = "AC විකර්ණය ඇඳීම.",
            proofSteps = listOf(
              GeometryStep("ABC △ හා CDA △ සලකමු.", "සාධනය ආරම්භය"),
              GeometryStep("BAĈ = DCÂ", "AB // CD බැවින් ඒකාන්තර කෝණ"),
              GeometryStep("BCÂ = DAĈ", "AD // BC බැවින් ඒකාන්තර කෝණ"),
              GeometryStep("AC = AC", "පොදු පාදය"),
              GeometryStep("එම නිසා ABC △ ≡ CDA △", "කෝ.කෝ.පා (හෝ කෝ.පා.කෝ) අවස්ථාව"),
              GeometryStep("එනයින් AB = CD සහ AD = BC වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද සමාන වේ"),
              GeometryStep("ABĈ = ADĈ වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප කෝණ සමාන වේ")
            ),
            riderExplanation = "සමාන්තරාස්‍රයක සම්මුඛ පාද සමාන වන බැවින් පරිමිතිය = 2(දිග + පළල) සූත්‍රයෙන් ගණනය කළ හැක.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 8.1",
              questionText = "AB = 9 cm සහ BC = 6 cm නම් ABCD සමාන්තරාස්‍රයේ පරිමිතිය සොයන්න.",
              solutionSteps = listOf("CD = AB = 9 cm (සම්මුඛ පාද සමාන වේ)", "AD = BC = 6 cm (සම්මුඛ පාද සමාන වේ)", "පරිමිතිය = AB + BC + CD + DA = 2 x (9 + 6) = 30 cm"),
              finalAnswer = "පරිමිතිය = 30 cm"
            ),
            examTips = "සමාන්තරාස්‍රයක සම්මුඛ කෝණ සමාන බවත් බද්ධ කෝණවල ඓක්‍යය 180° බවත් මතක තබාගන්න."
          )
        )
      ),

      // Category 9
      GeometryCategory(
        categoryId = 9,
        titleSinhala = "9. සමාන්තරාස්‍ර ප්‍රමේය 2 - විකර්ණ එකිනෙක සමච්ඡේදනය",
        shortTitle = "සමාන්තරාස්‍ර විකර්ණ",
        theoremConcept = "සමාන්තරාස්‍රයක විකර්ණ එකිනෙක සමච්ඡේදනය වේ. විලෝමය: චතුරස්‍රයක විකර්ණ එකිනෙක සමච්ඡේදනය වේ නම් එය සමාන්තරාස්‍රයකි.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "PARALLELOGRAM",
        generalSolvingStrategy = "විකර්ණ ඡේදනය වන O ලක්ෂ්‍යය සලකා සම්මුඛ ත්‍රිකෝණ අංගසාම්‍ය බව පෙන්වන්න. OA = OC සහ OB = OD බව ඔප්පු කර නොදන්නා විකර්ණ දිගවල් ගණනය කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "සමාන්තරාස්‍ර විකර්ණ - විකර්ණ එකිනෙක සමච්ඡේදනය",
            structuredQuestionText = "ABCD සමාන්තරාස්‍රයේ AC සහ BD විකර්ණ O හිදී ඡේදනය වේ.\n(i) AOB △ ≡ COD △ බව සාධනය කරන්න.\n(ii) OA = OC සහ OB = OD බව පෙන්වන්න.\n(iii) AC = 14 cm සහ BD = 18 cm නම් OA සහ OB හි දිගවල් ගණනය කරන්න.",
            givenData = "ABCD සමාන්තරාස්‍රයකි. විකර්ණ O හිදී ඡේදනය වේ.",
            toProve = "AOB △ ≡ COD △ සහ OA = OC, OB = OD.",
            construction = "අවශ්‍ය නොවේ.",
            proofSteps = listOf(
              GeometryStep("AOB △ හා COD △ සලකමු.", "සාධනය ආරම්භය"),
              GeometryStep("AB = CD", "සමාන්තරාස්‍රයක සම්මුඛ පාද සමාන වේ"),
              GeometryStep("OAB̂ = OCD̂", "AB // CD බැවින් ඒකාන්තර කෝණ"),
              GeometryStep("OBÂ = ODĈ", "AB // CD බැවින් ඒකාන්තර කෝණ"),
              GeometryStep("එම නිසා AOB △ ≡ COD △", "කෝ.පා.කෝ අවස්ථාව (ASA)"),
              GeometryStep("එනයින් OA = OC වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද"),
              GeometryStep("OB = OD වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද")
            ),
            riderExplanation = "විකර්ණ එකිනෙක සමච්ඡේදනය වන බැවින් ඕනෑම විකර්ණ අර්ධයක් මුළු විකර්ණ දිගෙන් අඩකි.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 9.1",
              questionText = "AC = 14 cm සහ BD = 18 cm නම් OA සහ OB දිගවල් සොයන්න.",
              solutionSteps = listOf("OA = AC / 2 = 14 / 2 = 7 cm", "OB = BD / 2 = 18 / 2 = 9 cm"),
              finalAnswer = "OA = 7 cm, OB = 9 cm"
            ),
            examTips = "චතුරස්‍රයක විකර්ණ එකිනෙක සමච්ඡේදනය වේ නම් එය අනිවාර්යයෙන්ම සමාන්තරාස්‍රයකි."
          )
        )
      ),

      // Category 10
      GeometryCategory(
        categoryId = 10,
        titleSinhala = "10. සමාන්තරාස්‍ර විශේෂ අවස්ථා - රොම්බසය, සෘජුකෝණාස්‍රය, සමචතුරස්‍රය",
        shortTitle = "විශේෂ සමාන්තරාස්‍ර",
        theoremConcept = "රොම්බසයක විකර්ණ එකිනෙක ලම්බ සමච්ඡේදනය වේ, කෝණ සමච්ඡේදනය කරයි. සෘජුකෝණාස්‍රයක විකර්ණ සමාන වේ. සමචතුරස්‍රයක විකර්ණ සමාන වන අතර ලම්බ සමච්ඡේදනය වේ.",
        gradeLevel = "10 ශ්‍රේණිය",
        diagramType = "PARALLELOGRAM",
        generalSolvingStrategy = "රොම්බසයේ විකර්ණ 90° කින් කැපෙන බැවින් විකර්ණ අර්ධ මගින් සෘජුකෝණී ත්‍රිකෝණ 4ක් සෑදේ. පයිතගරස් ප්‍රමේයයෙන් රොම්බසයේ පාදය හා වර්ගඵලය ගණනය කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "රොම්බසය සහ විශේෂ සමාන්තරාස්‍ර - ලම්බ විකර්ණ",
            structuredQuestionText = "ABCD රොම්බසයේ විකර්ණ O හිදී ඡේදනය වේ.\n(i) AOB △ ≡ COB △ බව සාධනය කරන්න.\n(ii) AC ⊥ BD බව (විකර්ණ ලම්බක වන බව) ඔප්පු කරන්න.\n(iii) AC = 14 cm සහ BD = 18 cm නම් රොම්බසයේ පාදයක දිග සොයන්න.",
            givenData = "ABCD රොම්බසයකි (AB = BC = CD = DA).",
            toProve = "AOB △ ≡ COB △ සහ AC ⊥ BD (AOB̂ = 90°).",
            construction = "අවශ්‍ය නොවේ.",
            proofSteps = listOf(
              GeometryStep("AOB △ හා COB △ සලකමු.", "සාධනය ආරම්භය"),
              GeometryStep("AB = BC", "රොම්බසයක සියලු පාද සමාන වේ"),
              GeometryStep("OB = OB", "පොදු පාදය"),
              GeometryStep("OA = OC", "රොම්බසයක් සමාන්තරාස්‍රයක් බැවින් විකර්ණ එකිනෙක සමච්ඡේදනය වේ"),
              GeometryStep("එම නිසා AOB △ ≡ COB △", "පා.පා.පා අවස්ථාව (SSS)"),
              GeometryStep("එනයින් AOB̂ = COB̂ වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප කෝණ"),
              GeometryStep("නමුත් AOB̂ + COB̂ = 180°", "සරල රේඛාවක් මත බද්ධ කෝණ"),
              GeometryStep("එම නිසා AOB̂ = COB̂ = 90° වේ.", "කෝණ සමාන බැවින්"),
              GeometryStep("එනයින් AC ⊥ BD වේ.", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "රොම්බසයේ විකර්ණ ලම්බකව සමච්ඡේදනය වන බැවින් AOB සෘජුකෝණී ත්‍රිකෝණයට පයිතගරස් ප්‍රමේයය යොදා පාදය ගණනය කරන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 10.1",
              questionText = "AC = 14 cm සහ BD = 18 cm නම් රොම්බසයේ පාදයක දිග සොයන්න.",
              solutionSteps = listOf("OA = AC / 2 = 7 cm, OB = BD / 2 = 9 cm", "AOB සෘජුකෝණී ත්‍රිකෝණයට පයිතගරස්: AB² = OA² + OB²", "AB² = 7² + 9² = 49 + 81 = 130", "AB = √130 ≈ 11.4 cm"),
              finalAnswer = "පාදය AB = 11.4 cm"
            ),
            examTips = "රොම්බසයේ වර්ගඵලය = 1/2 x විකර්ණ දෙකෙහි ගුණිතය (1/2 x d1 x d2) සූත්‍රය මතක තබාගන්න."
          )
        )
      )
    )
  }
}
