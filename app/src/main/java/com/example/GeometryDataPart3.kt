package com.example

// ==============================================================================
// GEOMETRY STRUCTURED QUESTIONS & RIDERS: GeometryDataPart3
// Categories 11 to 15: 100% Unique, authentic O/L Geometry Structured Questions
// Guarantees each theorem has a distinct, non-repeating comprehensive question.
// ==============================================================================

object GeometryDataPart3 {
  fun getCategories(): List<GeometryCategory> {
    return listOf(
      // Category 11
      GeometryCategory(
        categoryId = 11,
        titleSinhala = "11. ත්‍රිකෝණයක මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයය",
        shortTitle = "මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයය",
        theoremConcept = "ත්‍රිකෝණයක පාද දෙකක මධ්‍ය ලක්ෂ්‍ය යා කරන සරල රේඛාව තෙවන පාදයට සමාන්තර වේ, දිගින් ඉන් අඩක් වේ (DE // BC සහ DE = 1/2 BC).",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "MIDPOINT",
        generalSolvingStrategy = "D සහ E මධ්‍ය ලක්ෂ්‍ය නම් DE // BC සහ DE = BC/2 කෙළින්ම ලියන්න. චතුරස්‍රයක පාදවල මධ්‍ය ලක්ෂ්‍ය යා කළ විට සෑදෙන්නේ සමාන්තරාස්‍රයක් බව (Varignon's Parallelogram) රයිඩර්වලදී නිතර භාවිත වේ.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයය - සමාන්තර බව සහ අඩක් වීම",
            structuredQuestionText = "ABC ත්‍රිකෝණයේ AB සහ AC පාදවල මධ්‍ය ලක්ෂ්‍ය පිළිවෙළින් D සහ E වේ.\n(i) DE // BC බවත් DE = 1/2 BC බවත් ප්‍රමේයය ඇසුරින් දක්වන්න.\n(ii) BC = 16 cm නම් DE හි දිග සොයන්න.\n(iii) ADE ත්‍රිකෝණයේ සහ ABC ත්‍රිකෝණයේ පරිමිතීන් අතර අනුපාතය සොයන්න.",
            givenData = "ABC △ හි D යනු AB හි මධ්‍ය ලක්ෂ්‍යය ද, E යනු AC හි මධ්‍ය ලක්ෂ්‍යය ද වේ.",
            toProve = "DE // BC සහ DE = 1/2 BC.",
            construction = "DE රේඛාව F දක්වා දික්කර CF // AB වන සේ C හා F යා කිරීම.",
            proofSteps = listOf(
              GeometryStep("DE රේඛාව EF = DE වන සේ F දක්වා දික්කර CF // BA අඳිමු.", "නිර්මාණය"),
              GeometryStep("ADE △ හා CFE △ සලකමු.", "ත්‍රිකෝණ යුගලය"),
              GeometryStep("AE = EC", "E යනු AC හි මධ්‍ය ලක්ෂ්‍යය බැවින්"),
              GeometryStep("AED̂ = CEF̂", "ප්‍රතිමුඛ කෝණ සමාන වේ"),
              GeometryStep("DAÊ = FCÊ", "BA // CF බැවින් ඒකාන්තර කෝණ"),
              GeometryStep("එම නිසා ADE △ ≡ CFE △", "කෝ.පා.කෝ අවස්ථාව"),
              GeometryStep("එනයින් AD = CF සහ DE = EF වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද"),
              GeometryStep("නමුත් AD = DB බැවින් DB = CF වේ.", "D මධ්‍ය ලක්ෂ්‍යය බැවින්"),
              GeometryStep("DB // CF සහ DB = CF බැවින් DBCF සමාන්තරාස්‍රයකි.", "සම්මුඛ පාද යුගලක් සමාන හා සමාන්තර වීම"),
              GeometryStep("එම නිසා DF // BC සහ DF = BC වේ.", "සමාන්තරාස්‍රයක සම්මුඛ පාද"),
              GeometryStep("නමුත් DE = 1/2 DF බැවින් DE = 1/2 BC වේ.", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "මධ්‍ය ලක්ෂ්‍ය ත්‍රිකෝණයේ එක් එක් පාදය මුල් ත්‍රිකෝණයේ පාදවලින් අඩක් බැවින් ADE පරිමිතිය = 1/2 ABC පරිමිතිය වේ.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 11.1",
              questionText = "BC = 16 cm නම් DE හි දිග සහ ABC හි පරිමිතිය 48 cm නම් ADE හි පරිමිතිය සොයන්න.",
              solutionSteps = listOf("මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයය අනුව DE = BC / 2 = 16 / 2 = 8 cm", "ADE පරිමිතිය = ABC පරිමිතිය / 2 = 48 / 2 = 24 cm"),
              finalAnswer = "DE = 8 cm, පරිමිතිය = 24 cm"
            ),
            examTips = "මධ්‍ය ලක්ෂ්‍ය දෙකක් දුටු සැනින් 'මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයය අනුව' යන්න ලියා DE = 1/2 BC යොදන්න."
          )
        )
      ),

      // Category 12
      GeometryCategory(
        categoryId = 12,
        titleSinhala = "12. මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයයේ විලෝමය හා සමාන්තර ඡේදක",
        shortTitle = "විලෝම මධ්‍ය ලක්ෂ්‍යය & ඡේදක",
        theoremConcept = "ත්‍රිකෝණයක එක් පාදයක මධ්‍ය ලක්ෂ්‍යය හරහා තවත් පාදයකට සමාන්තරව අඳින රේඛාව තෙවන පාදය සමච්ඡේදනය කරයි. සමාන්තර රේඛා මගින් තීර්යක් රේඛාවක සමාන අන්තරාඛණ්ඩ කපයි නම් වෙනත් ඕනෑම තීර්යක් රේඛාවකද සමාන අන්තරාඛණ්ඩ කපයි.",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "MIDPOINT",
        generalSolvingStrategy = "එක් පාදයක මධ්‍ය ලක්ෂ්‍යය සහ සමාන්තර බව දත්තයේ ඇත්නම් විලෝම මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයයෙන් අනෙක් පාදය සමච්ඡේදනය වන බව දක්වන්න. සමාන්තර ඡේදක ප්‍රමේයයෙන් දිගවල් අනුපාත සොයන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "විලෝම මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයය - සමාන්තර ඡේදක",
            structuredQuestionText = "ABC ත්‍රිකෝණයේ AB හි මධ්‍ය ලක්ෂ්‍යය D වේ. D හරහා BC ට සමාන්තරව අඳින ලද රේඛාව AC පාදය E හිදී හමුවේ.\n(i) E යනු AC හි මධ්‍ය ලක්ෂ්‍යය (AE = EC) බව සාධනය කරන්න.\n(ii) සමාන්තර ඡේදක ප්‍රමේයය මගින් රේඛා ඛණ්ඩ බෙදීම විස්තර කරන්න.",
            givenData = "AD = DB සහ DE // BC වේ.",
            toProve = "AE = EC (E යනු AC හි මධ්‍ය ලක්ෂ්‍යයයි).",
            construction = "E හරහා AB ට සමාන්තරව EF රේඛාව BC මත F ට ඇඳීම.",
            proofSteps = listOf(
              GeometryStep("E හරහා EF // AB වන සේ BC මත F ලකුණු කරමු.", "නිර්මාණය"),
              GeometryStep("DE // BF සහ EF // DB බැවින් BDEF සමාන්තරාස්‍රයකි.", "සම්මුඛ පාද සමාන්තර බැවින්"),
              GeometryStep("එම නිසා EF = DB වේ.", "සමාන්තරාස්‍රයක සම්මුඛ පාද සමාන වේ"),
              GeometryStep("නමුත් DB = AD බැවින් EF = AD වේ.", "දත්තය (D මධ්‍ය ලක්ෂ්‍යයයි)"),
              GeometryStep("ADE △ හා EFC △ සලකමු.", "ත්‍රිකෝණ යුගලය"),
              GeometryStep("DAÊ = FEĈ", "AB // EF බැවින් අනුරූප කෝණ"),
              GeometryStep("ADÊ = EFĈ", "DE // BC බැවින් අනුරූප කෝණ"),
              GeometryStep("AD = EF", "ඉහත සාධිතයි"),
              GeometryStep("එම නිසා ADE △ ≡ EFC △", "කෝ.කෝ.පා අවස්ථාව"),
              GeometryStep("එනයින් AE = EC වේ.", "අංගසාම්‍ය ත්‍රිකෝණවල අනුරූප පාද සමාන වේ")
            ),
            riderExplanation = "විලෝම මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයයෙන් තෙවන පාදය සමච්ඡේදනය වන බව ගෙන අගයන් සොයන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 12.1",
              questionText = "AC = 10 cm සහ DE = 7 cm නම් AE සහ BC හි දිගවල් සොයන්න.",
              solutionSteps = listOf("E මධ්‍ය ලක්ෂ්‍යය බැවින් AE = AC / 2 = 10 / 2 = 5 cm", "මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයයෙන් BC = 2 x DE = 2 x 7 = 14 cm"),
              finalAnswer = "AE = 5 cm, BC = 14 cm"
            ),
            examTips = "මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයයේ විලෝමයේදී දත්තය වන්නේ එක් මධ්‍ය ලක්ෂ්‍යයක් සහ සමාන්තර රේඛාවක් පමණි."
          )
        )
      ),

      // Category 13
      GeometryCategory(
        categoryId = 13,
        titleSinhala = "13. වර්ගඵල ප්‍රමේය 1 - එකම ආධාරකය හා සමාන්තර රේඛා අතර රූප",
        shortTitle = "එකම ආධාරක වර්ගඵල",
        theoremConcept = "එකම ආධාරකය මතද එකම සමාන්තර රේඛා යුගලය අතරද පිහිටි සමාන්තරාස්‍ර වර්ගඵලයෙන් සමාන වේ. ත්‍රිකෝණ වර්ගඵලයෙන් සමාන වේ. ත්‍රිකෝණයක වර්ගඵලය සමාන්තරාස්‍රයේ වර්ගඵලයෙන් අඩකි.",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "PARALLELOGRAM",
        generalSolvingStrategy = "රූප දෙකෙහි පොදු ආධාරකය හා සමාන්තර රේඛා යුගලය පැහැදිලිව සඳහන් කර වර්ගඵල සමාන බව ලියන්න. පොදු කොටස් අඩු කිරීමෙන් හෝ එකතු කිරීමෙන් රයිඩරයේ ඉතිරි ත්‍රිකෝණවල වර්ගඵල සමාන බව පෙන්වන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "වර්ගඵල ප්‍රමේය 1 - එකම ආධාරකය හා සමාන්තර රේඛා",
            structuredQuestionText = "ABCD සමාන්තරාස්‍රයකි. BC ආධාරකය මත E ලක්ෂ්‍යය පිහිටා ඇති අතර ABE සහ ABCD රූප සලකන්න.\n(i) එකම ආධාරකය මතද එකම සමාන්තර රේඛා යුගලය අතරද පිහිටි ත්‍රිකෝණයක වර්ගඵලය සමාන්තරාස්‍රයේ වර්ගඵලයෙන් අඩක් බව සාධනය කරන්න.\n(ii) ABCD වර්ගඵලය = 48 cm² නම් EBC ත්‍රිකෝණයේ වර්ගඵලය සොයන්න.",
            givenData = "ABCD සමාන්තරාස්‍රයක් වන අතර E යනු AD මත ලක්ෂ්‍යයකි.",
            toProve = "EBC △ වර්ගඵලය = 1/2 x ABCD සමාන්තරාස්‍රයේ වර්ගඵලය.",
            construction = "E හරහා AB ට සමාන්තරව EF රේඛාව BC මත F ට ඇඳීම.",
            proofSteps = listOf(
              GeometryStep("E හරහා EF // AB වන සේ BC මත F ලකුණු කරමු.", "නිර්මාණය"),
              GeometryStep("ABFE සමාන්තරාස්‍රයකි.", "සම්මුඛ පාද සමාන්තර බැවින්"),
              GeometryStep("එමෙන්ම EFCD සමාන්තරාස්‍රයකි.", "සම්මුඛ පාද සමාන්තර බැවින්"),
              GeometryStep("EBC ත්‍රිකෝණයේ වර්ගඵලය = 1/2 x BC x h", "ත්‍රිකෝණ වර්ගඵල සූත්‍රය"),
              GeometryStep("ABCD සමාන්තරාස්‍රයේ වර්ගඵලය = BC x h", "සමාන්තරාස්‍ර වර්ගඵල සූත්‍රය"),
              GeometryStep("ලම්බ උස h දෙකටම පොදු බැවින්:", "එකම සමාන්තර රේඛා අතර පිහිටි බැවින්"),
              GeometryStep("EBC △ වර්ගඵලය = 1/2 x ABCD සමාන්තරාස්‍ර වර්ගඵලය වේ.", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "එකම ආධාරකය හා සමාන්තර රේඛා අතර ඇති ත්‍රිකෝණ දෙකක වර්ගඵල සමාන වන අතර පොදු කොටස් ඉවත් කිරීමෙන් ඉතිරි කොටස් සමාන වේ.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 13.1",
              questionText = "ABCD සමාන්තරාස්‍රයේ වර්ගඵලය 48 cm² නම් EBC ත්‍රිකෝණයේ වර්ගඵලය සොයන්න.",
              solutionSteps = listOf("EBC △ වර්ගඵලය = 1/2 x ABCD වර්ගඵලය", "EBC △ වර්ගඵලය = 1/2 x 48 = 24 cm²"),
              finalAnswer = "වර්ගඵලය = 24 cm²"
            ),
            examTips = "වර්ගඵල ප්‍රමේයය ලියන විට 'එකම ආධාරකය BC සහ එකම සමාන්තර රේඛා AD // BC අතර' යන හේතුව අනිවාර්යයෙන්ම ලිවිය යුතුය."
          )
        )
      ),

      // Category 14
      GeometryCategory(
        categoryId = 14,
        titleSinhala = "14. වර්ගඵල ප්‍රමේය 2 - ත්‍රිකෝණයක මධ්‍යස්ථය මගින් වර්ගඵලය සමච්ඡේදනය",
        shortTitle = "මධ්‍යස්ථය & වර්ගඵලය",
        theoremConcept = "ත්‍රිකෝණයක මධ්‍යස්ථය මගින් එහි වර්ගඵලය සමච්ඡේදනය කරයි (සමාන වර්ගඵල සහිත ත්‍රිකෝණ දෙකකට බෙදයි). ගුරුත්ව කේන්ද්‍රය මධ්‍යස්ථ 2:1 අනුපාතයට බෙදයි.",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "TRIANGLE_CONGRUENCE",
        generalSolvingStrategy = "මධ්‍යස්ථයක පාද දෙපස ත්‍රිකෝණවල ආධාරක සමාන වන අතර ලම්බ උස පොදු බැවින් වර්ගඵල සමාන වේ. ගුරුත්ව කේන්ද්‍රය මගින් මුළු ත්‍රිකෝණය සමාන වර්ගඵල සහිත ත්‍රිකෝණ 3කට හෝ 6කට බෙදෙන අයුරු රයිඩරයට යොදන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "මධ්‍යස්ථ ප්‍රමේයය - ත්‍රිකෝණයක වර්ගඵලය සමච්ඡේදනය",
            structuredQuestionText = "ABC ත්‍රිකෝණයේ AD යනු BC පාදයට ඇඳි මධ්‍යස්ථයයි.\n(i) ABD △ වර්ගඵලය = ADC △ වර්ගඵලය බව සාධනය කරන්න.\n(ii) G යනු ABC හි ගුරුත්ව කේන්ද්‍රය නම්, GBC △ වර්ගඵලය = 1/3 x ABC △ වර්ගඵලය බව පෙන්වන්න.",
            givenData = "ABC △ හි D යනු BC හි මධ්‍ය ලක්ෂ්‍යයයි (BD = DC).",
            toProve = "ABD △ වර්ගඵලය = ADC △ වර්ගඵලය.",
            construction = "A සිට BC පාදයට AN ලම්බකය ඇඳීම.",
            proofSteps = listOf(
              GeometryStep("A ශීර්ෂයේ සිට BC පාදයට AN ලම්බකය අඳිමු.", "නිර්මාණය (පොදු උස h)"),
              GeometryStep("ABD △ වර්ගඵලය = 1/2 x BD x AN", "ත්‍රිකෝණ වර්ගඵල සූත්‍රය"),
              GeometryStep("ADC △ වර්ගඵලය = 1/2 x DC x AN", "ත්‍රිකෝණ වර්ගඵල සූත්‍රය"),
              GeometryStep("නමුත් BD = DC වේ.", "AD මධ්‍යස්ථය බැවින් (D මධ්‍ය ලක්ෂ්‍යයයි)"),
              GeometryStep("AN යනු ත්‍රිකෝණ දෙකටම පොදු ලම්බ උසයි.", "එකම ශීර්ෂයෙන් ඇඳි බැවින්"),
              GeometryStep("එම නිසා ABD △ වර්ගඵලය = ADC △ වර්ගඵලය වේ.", "සාධනය සම්පූර්ණයි")
            ),
            riderExplanation = "ගුරුත්ව කේන්ද්‍රය මගින් මධ්‍යස්ථය 2:1 අනුපාතයට බෙදන බැවින් මුළු වර්ගඵලය සමාන කොටස් 3කට හෝ 6කට බෙදේ.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 14.1",
              questionText = "ABC ත්‍රිකෝණයේ මුළු වර්ගඵලය 30 cm² නම් ABD ත්‍රිකෝණයේ සහ GBD ත්‍රිකෝණයේ වර්ගඵල සොයන්න.",
              solutionSteps = listOf("ABD △ වර්ගඵලය = 30 / 2 = 15 cm²", "GBD △ යනු මුළු වර්ගඵලයෙන් 1/6 කි: 30 / 6 = 5 cm²"),
              finalAnswer = "ABD = 15 cm², GBD = 5 cm²"
            ),
            examTips = "මධ්‍යස්ථය මගින් ත්‍රිකෝණය අංගසාම්‍ය නොකලද වර්ගඵලයෙන් සමාන කොටස් දෙකකට බෙදයි."
          )
        )
      ),

      // Category 15
      GeometryCategory(
        categoryId = 15,
        titleSinhala = "15. සමානුපාතිකතා ප්‍රමේයය (තේල්ස් ප්‍රමේයය)",
        shortTitle = "සමානුපාතිකතා ප්‍රමේයය",
        theoremConcept = "ත්‍රිකෝණයක පාදයකට සමාන්තරව අඳින ලද සරල රේඛාවකින් අනෙක් පාද දෙක සමානුපාතිකව බෙදේ (AD / DB = AE / EC). විලෝමය: පාද සමානුපාතිකව බෙදේ නම් රේඛාව සමාන්තර වේ.",
        gradeLevel = "11 ශ්‍රේණිය (O/L)",
        diagramType = "PROPORTION",
        generalSolvingStrategy = "සමාන්තර රේඛාව හඳුනාගෙන AD/DB = AE/EC හෝ AD/AB = AE/AC අනුපාතය ලියන්න. වීජීය සමීකරණයක් ගොඩනගා හරස් ගුණිතයෙන් නොදන්නා x හි අගය හෝ දිගවල් ගණනය කරන්න.",
        questions = listOf(
          GeometryStructuredQuestion(
            questionNumber = 1,
            questionTitle = "සමානුපාතිකතා ප්‍රමේයය - තේල්ස් ප්‍රමේයය සහ අනුපාත",
            structuredQuestionText = "ABC ත්‍රිකෝණයේ AB සහ AC පාද පිළිවෙළින් D සහ E හිදී ඡේදනය වන පරිදි DE // BC රේඛාව ඇඳ ඇත.\n(i) AD / DB = AE / EC බව සාධනය කරන්න.\n(ii) AD = 3 cm, DB = 4 cm සහ AE = 6 cm නම් EC හි දිග ගණනය කරන්න.",
            givenData = "ABC △ හි DE // BC වේ.",
            toProve = "AD / DB = AE / EC.",
            construction = "B හා E ද, C හා D ද යා කිරීම.",
            proofSteps = listOf(
              GeometryStep("B හා E ද C හා D ද යා කරමු.", "නිර්මාණය"),
              GeometryStep("ADE △ වර්ගඵලය / BDE △ වර්ගඵලය = AD / DB", "E පොදු ශීර්ෂය සහිත ත්‍රිකෝණවල වර්ගඵල අනුපාතය ආධාරක අනුපාතයට සමාන වේ"),
              GeometryStep("ADE △ වර්ගඵලය / CDE △ වර්ගඵලය = AE / EC", "D පොදු ශීර්ෂය සහිත ත්‍රිකෝණවල වර්ගඵල අනුපාතය ආධාරක අනුපාතයට සමාන වේ"),
              GeometryStep("නමුත් BDE △ වර්ගඵලය = CDE △ වර්ගඵලය වේ.", "එකම ආධාරකය DE හා එකම සමාන්තර රේඛා DE // BC අතර පිහිටි බැවින්"),
              GeometryStep("එම නිසා ADE / BDE = ADE / CDE වේ.", "හරයන් සමාන බැවින්"),
              GeometryStep("එනයින් AD / DB = AE / EC වේ.", "සාධනය සම්පූර්ණයි (සමානුපාතිකතා ප්‍රමේයය)")
            ),
            riderExplanation = "DE // BC දුටු සැනින් සමානුපාතිකතා ප්‍රමේයය ලියා අගයන් ආදේශ කර හරස් ගුණිතයෙන් නොදන්නා පාදයේ දිග සොයන්න.",
            riderQuestion = GeometryRiderQuestion(
              subNumber = "අනුබද්ධ 15.1",
              questionText = "AD = 3 cm, DB = 4 cm සහ AE = 6 cm නම් EC හි දිග සොයන්න.",
              solutionSteps = listOf("සමානුපාතිකතා ප්‍රමේයය අනුව: AD / DB = AE / EC", "3 / 4 = 6 / EC", "EC = (6 x 4) / 3 = 8 cm"),
              finalAnswer = "EC = 8 cm"
            ),
            examTips = "සමානුපාතිකතා ප්‍රමේයයේදී AD/AB = AE/AC ලෙස සම්පූර්ණ පාදයටද අනුපාතය ලිවිය හැක."
          )
        )
      )
    )
  }
}
