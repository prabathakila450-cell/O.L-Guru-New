package com.example

object ShortAnswerGrade10Sets1To10 {

  val sets = listOf(
    QuestionSetInfo(1, "10", "කාණ්ඩය 1: විද්‍යාව - රසායනික බන්ධන සහ මවුලය", "විද්‍යාව", "⚗️"),
    QuestionSetInfo(2, "10", "කාණ්ඩය 2: විද්‍යාව - පටක, ආහාර ජීර්ණය සහ ශ්වසනය", "විද්‍යාව", "🫀"),
    QuestionSetInfo(3, "10", "කාණ්ඩය 3: විද්‍යාව - චලිත සමීකරණ සහ නිව්ටන් නියම", "විද්‍යාව", "🚀"),
    QuestionSetInfo(4, "10", "කාණ්ඩය 4: ගණිතය - වර්ගජ ප්‍රකාශන සහ සාධක", "ගණිතය", "🔢"),
    QuestionSetInfo(5, "10", "කාණ්ඩය 5: ගණිතය - ත්‍රිකෝණමිතිය සහ පරිමාව", "ගණිතය", "📐"),
    QuestionSetInfo(6, "10", "කාණ්ඩය 6: ඉතිහාසය - පොළොන්නරු යුගය සහ රජවරු", "ඉතිහාසය", "👑"),
    QuestionSetInfo(7, "10", "කාණ්ඩය 7: ඉතිහාසය - මධ්‍යකාලීන රාජධානි සහ කෝට්ටේ", "ඉතිහාසය", "🏰"),
    QuestionSetInfo(8, "10", "කාණ්ඩය 8: බුද්ධ ධර්මය - චතුරාර්ය සත්‍යය සහ කර්මය", "බුද්ධ ධර්මය", "🪷"),
    QuestionSetInfo(9, "10", "කාණ්ඩය 9: සිංහල - වියත් වහර, නිවැරදි ව්‍යාකරණ", "සිංහල", "📜"),
    QuestionSetInfo(10, "10", "කාණ්ඩය 10: ICT - තර්ක ද්වාර සහ දත්ත සන්නිවේදනය", "ICT", "🔌")
  )

  val questions = listOf(
    // -------------------------------------------------------------------------
    // SET 1: විද්‍යාව - රසායනික බන්ධන සහ මවුලය (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 201,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "අයනික බන්ධන",
      question = "අයනික බන්ධනයක් සෑදෙන ආකාරය සහ NaCl අණුවේ ඇති බන්ධන වර්ගය නම් කරන්න.",
      keyPoints = listOf("ඉලෙක්ට්‍රෝන හුවමාරුව", "අයනික බන්ධනය"),
      synonyms = listOf(
        listOf("ඉලෙක්ට්‍රෝන හුවමාරුව", "ඉලෙක්ට්‍රෝන ලබාදීම හා ලබාගැනීම", "ලෝහ හා අලෝහ අතර"),
        listOf("අයනික බන්ධනය", "අයනික", "ionic bond")
      ),
      officialMarkingScheme = "• සෑදෙන අයුරු: ලෝහ පරමාණුවකින් අලෝහ පරමාණුවකට ඉලෙක්ට්‍රෝන හුවමාරුව මඟින් (ලකුණු 1)\n• NaCl බන්ධනය: අයනික බන්ධනය (ලකුණු 1)",
      sampleIdealAnswer = "ඉලෙක්ට්‍රෝන හුවමාරු වීමෙන් සෑදේ. NaCl හි ඇත්තේ අයනික බන්ධනයකි."
    ),
    ShortAnswerQuestion(
      id = 202,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "සහසංයුජ බන්ධන",
      question = "සහසංයුජ බන්ධනයක් සෑදෙන්නේ කෙසේද? ජල (H₂O) අණුවේ ඇති බන්ධන වර්ගය කුමක්ද?",
      keyPoints = listOf("ඉලෙක්ට්‍රෝන හවුලේ තබාගැනීම", "සහසංයුජ"),
      synonyms = listOf(
        listOf("ඉලෙක්ට්‍රෝන හවුලේ තබාගැනීම", "ඉලෙක්ට්‍රෝන හවුල් කරගැනීම", "sharing of electrons"),
        listOf("සහසංයුජ", "සහසංයුජ බන්ධන", "covalent bond")
      ),
      officialMarkingScheme = "• සෑදෙන අයුරු: පරමාණු දෙකක් අතර ඉලෙක්ට්‍රෝන යුගල හවුලේ තබාගැනීමෙන් (ලකුණු 1)\n• ජල අණුවේ බන්ධනය: සහසංයුජ බන්ධනය (ලකුණු 1)",
      sampleIdealAnswer = "ඉලෙක්ට්‍රෝන යුගල හවුලේ තබාගැනීමෙන් සෑදේ. ජල අණුවේ ඇත්තේ සහසංයුජ බන්ධන වේ."
    ),
    ShortAnswerQuestion(
      id = 203,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "මවුලය සහ ඇවගාඩ්රෝ නියතය",
      question = "ඇවගාඩ්රෝ නියතයේ (L) සංඛ්‍යාත්මක අගය කුමක්ද? ඕනෑම ද්‍රව්‍යයක මවුල 1 ක අඩංගු අංශු සංඛ්‍යාව කීයද?",
      keyPoints = listOf("6.022 × 10²³", "ඇවගාඩ්රෝ සංඛ්‍යාව"),
      synonyms = listOf(
        listOf("6.022 × 10²³", "6.022 x 10^23", "6.023 x 10^23", "6.02 x 10^23"),
        listOf("ඇවගාඩ්රෝ සංඛ්‍යාව", "6.022 × 10²³ අංශු", "මවුලයක අංශු")
      ),
      officialMarkingScheme = "• ඇවගාඩ්රෝ නියතය = 6.022 × 10²³ mol⁻¹ (ලකුණු 1)\n• මවුල 1 ක අංශු: 6.022 × 10²³ (ලකුණු 1)",
      sampleIdealAnswer = "6.022 × 10²³ mol⁻¹ වේ. මවුල එකක අඩංගු අංශු සංඛ්‍යාව 6.022 × 10²³ කි."
    ),
    ShortAnswerQuestion(
      id = 204,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "මවුලික ස්කන්ධය",
      question = "ජලයේ (H₂O) මවුලික ස්කන්ධය ගණනය කරන්න (H = 1, O = 16). ඒකකය සඳහන් කරන්න.",
      keyPoints = listOf("18", "g mol-1"),
      synonyms = listOf(
        listOf("18", "18g", "දහඅට"),
        listOf("g mol-1", "g/mol", "g mol⁻¹", "ග්‍රෑම් මවුලයට")
      ),
      officialMarkingScheme = "• ගණනය: (2 × 1) + 16 = 18 සඳහා ලකුණු 1\n• ඒකකය: g mol⁻¹ (හෝ g/mol) සඳහා ලකුණු 1",
      sampleIdealAnswer = "H₂O = (2 × 1) + 16 = 18 g mol⁻¹ වේ."
    ),
    ShortAnswerQuestion(
      id = 205,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "රසායනික තුලිත සමීකරණ",
      question = "2H₂ + O₂ → 2H₂O සමීකරණයට අනුව, ජලය මවුල 4 ක් නිපදවීමට අවශ්‍ය ඔක්සිජන් මවුල සංඛ්‍යාව කීයද?",
      keyPoints = listOf("මවුල 2", "2 mol"),
      synonyms = listOf(
        listOf("මවුල 2", "2", "දෙකක්", "2 mol")
      ),
      officialMarkingScheme = "• මවුල අනුපාතය O₂ : H₂O = 1 : 2 (ලකුණු 1)\n• අවශ්‍ය O₂ මවුල සංඛ්‍යාව = 4 / 2 = 2 mol (ලකුණු 1)",
      sampleIdealAnswer = "ඔක්සිජන් මවුල 2 ක් අවශ්‍ය වේ (අනුපාතය 1 : 2 බැවින්)."
    ),
    ShortAnswerQuestion(
      id = 206,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "ද්‍රාව්‍යතාව සහ සාන්ද්‍රණය",
      question = "ද්‍රාවණයක සාන්ද්‍රණය මනින සම්මත ඒකකය කුමක්ද? ජලය 500 cm³ ක NaOH මවුල 0.5 ක් දිය කළ විට සාන්ද්‍රණය කීයද?",
      keyPoints = listOf("mol dm-3", "1 mol dm-3"),
      synonyms = listOf(
        listOf("mol dm-3", "mol/dm3", "mol dm⁻³", "මවුල ඩෙසිමීටර ඝනයට"),
        listOf("1 mol dm-3", "1.0", "1 mol/dm3", "1")
      ),
      officialMarkingScheme = "• ඒකකය: mol dm⁻³ (හෝ mol/dm³) සඳහා ලකුණු 1\n• ගණනය: C = n / V = 0.5 / 0.5 = 1 mol dm⁻³ සඳහා ලකුණු 1",
      sampleIdealAnswer = "සම්මත ඒකකය mol dm⁻³ වේ. සාන්ද්‍රණය = 0.5 / 0.5 = 1 mol dm⁻³ වේ."
    ),
    ShortAnswerQuestion(
      id = 207,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "විද්‍යුත් සෘණතාව",
      question = "විද්‍යුත් සෘණතාව යනු කුමක්ද? ආවර්තිතා වගුවේ වැඩිම විද්‍යුත් සෘණතාවක් ඇති මූලද්‍රව්‍යය කුමක්ද?",
      keyPoints = listOf("බන්ධන ඉලෙක්ට්‍රෝන ආකර්ෂණය", "ෆ්ලෝරීන්"),
      synonyms = listOf(
        listOf("බන්ධන ඉලෙක්ට්‍රෝන ආකර්ෂණය", "ඉලෙක්ට්‍රෝන තමා දෙසට ඇදගැනීමේ හැකියාව"),
        listOf("ෆ්ලෝරීන්", "ෆ්ලෝරින්", "fluorine", "f")
      ),
      officialMarkingScheme = "• නිර්වචනය: සහසංයුජ බන්ධනයක ඇති ඉලෙක්ට්‍රෝන යුගලය තමා දෙසට ආකර්ෂණය කරගැනීමේ හැකියාව (ලකුණු 1)\n• මූලද්‍රව්‍යය: ෆ්ලෝරීන් (Fluorine - F) සඳහා ලකුණු 1",
      sampleIdealAnswer = "සහසංයුජ බන්ධනයක ඉලෙක්ට්‍රෝන තමා වෙත ඇද ගැනීමේ සාපේක්ෂ හැකියාවයි. වැඩිම විද්‍යුත් සෘණ මූලද්‍රව්‍යය ෆ්ලෝරීන් (F) වේ."
    ),
    ShortAnswerQuestion(
      id = 208,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "ලෝහක බන්ධනය",
      question = "ලෝහවල ආහන්‍යතාව සහ තන්‍යතාව පැහැදිලි කිරීමට ඉවහල් වන බන්ධන වර්ගය කුමක්ද? එහි ව්‍යුහය කෙටියෙන් හඳුන්වන්න.",
      keyPoints = listOf("ලෝහක බන්ධනය", "ඉලෙක්ට්‍රෝන මුහුද"),
      synonyms = listOf(
        listOf("ලෝහක බන්ධනය", "metallic bond"),
        listOf("ඉලෙක්ට්‍රෝන මුහුද", "විස්ථානගත ඉලෙක්ට්‍රෝන", "ධන කැටායන සහ ඉලෙක්ට්‍රෝන")
      ),
      officialMarkingScheme = "• බන්ධනය: ලෝහක බන්ධනය (Metallic bond) සඳහා ලකුණු 1\n• ව්‍යුහය: විස්ථානගත ඉලෙක්ට්‍රෝන මුහුදක ගිලී පවතින ධන ලෝහ කැටායන (ලකුණු 1)",
      sampleIdealAnswer = "ලෝහක බන්ධනයයි. විස්ථානගත ඉලෙක්ට්‍රෝන මුහුදක් මැද ධන ලෝහ අයන පිහිටා තිබීම මෙහි ව්‍යුහයයි."
    ),
    ShortAnswerQuestion(
      id = 209,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "අන්තර් අණුක ආකර්ෂණ බල",
      question = "ජල අණු එකිනෙක බැඳ තබන ප්‍රබල අන්තර් අණුක බන්ධන වර්ගය කුමක්ද? ජලයේ තාපාංකය ඉහළ යාමට එය බලපාන්නේ කෙසේද?",
      keyPoints = listOf("හයිඩ්‍රජන් බන්ධන", "බිඳීමට වැඩි ශක්තියක්"),
      synonyms = listOf(
        listOf("හයිඩ්‍රජන් බන්ධන", "හයිඩ්‍රජන් බන්ධනය", "hydrogen bonds"),
        listOf("බිඳීමට වැඩි ශක්තියක්", "තාප ශක්තිය වැඩිපුර අවශ්‍ය වීම", "ඉහළ තාපාංකය")
      ),
      officialMarkingScheme = "• බන්ධනය: හයිඩ්‍රජන් බන්ධන (Hydrogen bonding) සඳහා ලකුණු 1\n• බලපෑම: එම බන්ධන බිඳ දැමීමට වැඩි තාප ශක්තියක් අවශ්‍ය වීම නිසා තාපාංකය ඉහළ යයි (ලකුණු 1)",
      sampleIdealAnswer = "හයිඩ්‍රජන් බන්ධන වේ. මෙම බන්ධන බිඳහෙළීම සඳහා විශාල තාප ශක්තියක් අවශ්‍ය වන බැවින් ජලයේ තාපාංකය ඉහළ යයි."
    ),
    ShortAnswerQuestion(
      id = 210,
      grade = "10",
      setNumber = 1,
      subject = "විද්‍යාව (Science)",
      topic = "ඇලෝට්‍රෝප (බහුරූපී ප්‍රභේද)",
      question = "කාබන් මූලද්‍රව්‍යයේ ස්ඵටිකරූපී බහුරූපී ප්‍රභේද 2ක් නම් කරන්න.",
      keyPoints = listOf("දියමන්ති", "මිනිරන්"),
      synonyms = listOf(
        listOf("දියමන්ති", "diamond"),
        listOf("මිනිරන්", "ග්‍රැෆයිට්", "ෆුලරීන්", "graphite")
      ),
      officialMarkingScheme = "• දියමන්ති (Diamond) සඳහා ලකුණු 1\n• මිනිරන් / ග්‍රැෆයිට් (Graphite) සඳහා ලකුණු 1",
      sampleIdealAnswer = "දියමන්ති (Diamond) සහ මිනිරන් (ග්‍රැෆයිට් - Graphite) වේ."
    ),

    // -------------------------------------------------------------------------
    // SET 2: විද්‍යාව - පටක, ආහාර ජීර්ණය සහ ශ්වසනය (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 211,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "එන්සයිම ක්‍රියාකාරිත්වය",
      question = "මුඛ කුහරයේදී කාබෝහයිඩ්‍රේට ජීර්ණය ආරම්භ කරන කෙළවල අඩංගු එන්සයිමය කුමක්ද? එයින් පිෂ්ඨය බිඳවැටෙන ඵලය කුමක්ද?",
      keyPoints = listOf("ඛේට ඇමයිලේස්", "මෝල්ටෝස්"),
      synonyms = listOf(
        listOf("ඛේට ඇමයිලේස්", "ඇමයිලේස්", "ටයිලින්", "salivary amylase"),
        listOf("මෝල්ටෝස්", "මෝල්ටෝස් සීනි", "maltose")
      ),
      officialMarkingScheme = "• එන්සයිමය: ඛේට ඇමයිලේස් (ටයිලින්) සඳහා ලකුණු 1\n• ඵලය: මෝල්ටෝස් සඳහා ලකුණු 1",
      sampleIdealAnswer = "ඛේට ඇමයිලේස් (ටයිලින්) වේ. එය පිෂ්ඨය මෝල්ටෝස් බවට පත් කරයි."
    ),
    ShortAnswerQuestion(
      id = 212,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "ආමාශයික යුෂය",
      question = "ආමාශය තුළ ප්‍රෝටීන ජීර්ණයට උපකාරී වන ප්‍රධාන එන්සයිමය සහ ආමාශයික යුෂයේ අඩංගු අම්ලය නම් කරන්න.",
      keyPoints = listOf("පෙප්සින්", "හයිඩ්‍රොක්ලෝරික් අම්ලය"),
      synonyms = listOf(
        listOf("පෙප්සින්", "pepsin"),
        listOf("හයිඩ්‍රොක්ලෝරික් අම්ලය", "තනුක hcl", "hcl", "hydrochloric acid")
      ),
      officialMarkingScheme = "• එන්සයිමය: පෙප්සින් (Pepsin) සඳහා ලකුණු 1\n• අම්ලය: හයිඩ්‍රොක්ලෝරික් අම්ලය (HCl) සඳහා ලකුණු 1",
      sampleIdealAnswer = "එන්සයිමය පෙප්සින් වන අතර අම්ලය හයිඩ්‍රොක්ලෝරික් අම්ලය (HCl) වේ."
    ),
    ShortAnswerQuestion(
      id = 213,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "පිත්ත යුෂය",
      question = "පිත්ත යුෂය නිපදවන ඉන්ද්‍රිය සහ එය ගබඩා වන ස්ථානය නම් කරන්න. එහි ප්‍රධාන කාර්යය කුමක්ද?",
      keyPoints = listOf("අක්මාව සහ පිත්තාශය", "මේද තෛලෝදකරණය"),
      synonyms = listOf(
        listOf("අක්මාව සහ පිත්තාශය", "අක්මාව", "පිත්තාශය"),
        listOf("මේද තෛලෝදකරණය", "මේදය ජීර්ණයට පහසු කිරීම", "මේද බිඳීම")
      ),
      officialMarkingScheme = "• ඉන්ද්‍රිය/ස්ථානය: අක්මාවේ නිපදවී පිත්තාශයේ ගබඩා වේ (ලකුණු 1)\n• කාර්යය: මේද තෛලෝදකරණය කිරීම (ලකුණු 1)",
      sampleIdealAnswer = "අක්මාවේ නිපදවී පිත්තාශයේ තැන්පත් වේ. මේදය තෛලෝදකරණය කර ජීර්ණය පහසු කිරීම එහි කෘත්‍යයයි."
    ),
    ShortAnswerQuestion(
      id = 214,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "ක්ෂුද්‍රාන්ත්‍රය සහ අවශෝෂණය",
      question = "ජීරණය වූ ආහාර අවශෝෂණය කාර්යක්ෂම කිරීමට ක්ෂුද්‍රාන්ත්‍රයේ ඇතුළත බිත්තියේ ඇති ඇඟිලි වැනි නෙරීම් හඳුන්වන්නේ කුමන නමකින්ද?",
      keyPoints = listOf("අංගුලිකා", "වර්ගඵලය වැඩි කිරීම"),
      synonyms = listOf(
        listOf("අංගුලිකා", "විලයි", "villi", "අංගුලිකා ව්‍යුහ"),
        listOf("වර්ගඵලය වැඩි කිරීම", "අවශෝෂක වර්ගඵලය වැඩිකිරීම")
      ),
      officialMarkingScheme = "• නෙරීම්: අංගුලිකා (Villi) සඳහා ලකුණු 1\n• වාසිය: ආහාර අවශෝෂණය සඳහා පෘෂ්ඨික වර්ගඵලය විශාල ලෙස වැඩි කිරීම (ලකුණු 1)",
      sampleIdealAnswer = "අංගුලිකා (Villi) වේ. එමඟින් ආහාර අවශෝෂණ පෘෂ්ඨික වර්ගඵලය ඉහළ නංවයි."
    ),
    ShortAnswerQuestion(
      id = 215,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "ශ්වසන පද්ධතිය",
      question = "පෙනහළු තුළ වායු හුවමාරුව සිදුවන ක්ෂුද්‍ර වායු කෝෂ හඳුන්වන නම සහ ඒවායේ සිදුවන ක්‍රියාවලිය දක්වන්න.",
      keyPoints = listOf("කුහරිකා", "විසරණයෙන් වායු හුවමාරුව"),
      synonyms = listOf(
        listOf("කුහරිකා", "ඇල්වයෝලයි", "alveoli", "වායු කෝෂ"),
        listOf("විසරණයෙන් වායු හුවමාරුව", "ඔක්සිජන් සහ කාබන්ඩයොක්සයිඩ් හුවමාරුව")
      ),
      officialMarkingScheme = "• ව්‍යුහය: කුහරිකා (Alveoli) සඳහා ලකුණු 1\n• ක්‍රියාවලිය: සරල විසරණය මඟින් රුධිරය හා කුහරිකා අතර O₂ සහ CO₂ හුවමාරු වීම (ලකුණු 1)",
      sampleIdealAnswer = "කුහරිකා (Alveoli) වේ. විසරණය මඟින් රුධිරය හා වාතය අතර වායු හුවමාරුව සිදු කරයි."
    ),
    ShortAnswerQuestion(
      id = 216,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "ශ්වසන යාන්ත්‍රණය (ආශ්වාසය)",
      question = "සාමාන්‍ය ආශ්වාසයේදී මහාප්‍රාචීරය සහ අන්තර්-පර්ශුක පේශිවලට සිදුවන වෙනස්කම් ලියන්න.",
      keyPoints = listOf("මහාප්‍රාචීරය පහත් වේ", "පර්ශු ඉහළට"),
      synonyms = listOf(
        listOf("මහාප්‍රාචීරය පහත් වේ", "මහාප්‍රාචීරය පැතලි වේ", "පහළට ගමන් කරයි"),
        listOf("පර්ශු ඉහළට", "උරස් කුහරය විශාල වේ", "පිටතට හා ඉහළට")
      ),
      officialMarkingScheme = "• මහාප්‍රාචීරය සංකෝචනය වී පහත්/පැතලි වේ සඳහා ලකුණු 1\n• බාහිර අන්තර්-පර්ශුක පේශි සංකෝචනය වී පර්ශු ඉහළට හා පිටතට එසවේ (ලකුණු 1)",
      sampleIdealAnswer = "මහාප්‍රාචීරය පහත් වී පැතලි වේ. පර්ශු ඉහළට සහ පිටතට එසවී උරස් කුහරයේ පරිමාව වැඩි වේ."
    ),
    ShortAnswerQuestion(
      id = 217,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "සෛලීය ශ්වසනය",
      question = "වායුගෝලීය ඔක්සිජන් භාවිතයෙන් ග්ලූකෝස් සම්පූර්ණයෙන් බිඳවැටෙන ස්වායු ශ්වසනයේ සමස්ත තුලිත රසායනික සමීකරණය ලියන්න.",
      keyPoints = listOf("C6H12O6 + 6O2", "6CO2 + 6H2O + ශක්තිය"),
      synonyms = listOf(
        listOf("c6h12o6 + 6o2", "ග්ලූකෝස් + ඔක්සිජන්"),
        listOf("6co2 + 6h2o + ශක්තිය", "කාබන්ඩයොක්සයිඩ් + ජලය + ශක්තිය", "atp")
      ),
      officialMarkingScheme = "• ප්‍රතික්‍රියක: C₆H₁₂O₆ + 6O₂ සඳහා ලකුණු 1\n• ඵල: 6CO₂ + 6H₂O + ශක්තිය (38 ATP) සඳහා ලකුණු 1",
      sampleIdealAnswer = "C₆H₁₂O₆ + 6O₂ → 6CO₂ + 6H₂O + ශක්තිය (ATP)."
    ),
    ShortAnswerQuestion(
      id = 218,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "නිර්වායු ශ්වසනය සහ පැසවීම",
      question = "යීස්ට් සෛල තුළ නිර්වායු ශ්වසනයේදී නිපදවෙන ප්‍රධාන ඵල 2 නම් කරන්න.",
      keyPoints = listOf("එතනෝල්", "කාබන් ඩයොක්සයිඩ්"),
      synonyms = listOf(
        listOf("එතනෝල්", "එතිල් මධ්‍යසාරය", "alcohol", "ethanol"),
        listOf("කාබන් ඩයොක්සයිඩ්", "co2", "කාබන්ඩයොක්සයිඩ්")
      ),
      officialMarkingScheme = "• එතනෝල් (එතිල් මධ්‍යසාරය) සඳහා ලකුණු 1\n• කාබන් ඩයොක්සයිඩ් වායුව සඳහා ලකුණු 1",
      sampleIdealAnswer = "එතනෝල් (එතිල් මධ්‍යසාරය) සහ කාබන් ඩයොක්සයිඩ් (CO₂) වායුව වේ."
    ),
    ShortAnswerQuestion(
      id = 219,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "මානව හෘදයේ ව්‍යුහය",
      question = "මිනිස් හෘදයේ කුටීර කීයක් තිබේද? ඔක්සිජනීකෘත රුධිරය මුළු ශරීරයටම පොම්ප කරන කුටීරය කුමක්ද?",
      keyPoints = listOf("කුටීර 4", "වම් කෝෂිකාව"),
      synonyms = listOf(
        listOf("කුටීර 4", "කුටීර හතරක්", "4"),
        listOf("වම් කෝෂිකාව", "වම් කශිකාව", "left ventricle")
      ),
      officialMarkingScheme = "• කුටීර ගණන: 4 කි සඳහා ලකුණු 1\n• කුටීරය: වම් කෝෂිකාව (Left ventricle) සඳහා ලකුණු 1",
      sampleIdealAnswer = "කුටීර 4 ක් ඇත. ඔක්සිජනීකෘත රුධිරය මහා ධමනිය හරහා මුළු සිරුරටම පොම්ප කරන්නේ වම් කෝෂිකාව මඟිනි."
    ),
    ShortAnswerQuestion(
      id = 220,
      grade = "10",
      setNumber = 2,
      subject = "විද්‍යාව (Science)",
      topic = "රුධිර වාහිනී",
      question = "ධමනි සහ ශිරා අතර ඇති ව්‍යුහාත්මක වෙනස්කම් 2ක් ලියන්න.",
      keyPoints = listOf("කපාට පැවතීම", "බිත්තියේ ඝනකම"),
      synonyms = listOf(
        listOf("කපාට පැවතීම", "ශිරාවල කපාට ඇත ධමනිවල නැත"),
        listOf("බිත්තියේ ඝනකම", "ධමනි බිත්තිය ඝනයි ශිරා බිත්තිය තුනීයි")
      ),
      officialMarkingScheme = "• ධමනිවල බිත්තිය ඝන සහ ප්‍රත්‍යාස්ථ වන අතර ශිරාවල තුනී වේ (ලකුණු 1)\n• ශිරාවල රුධිරය ආපසු ගැලීම වළක්වන කපාට ඇති අතර ධමනිවල (මූලාරම්භය හැර) කපාට නැත (ලකුණු 1)",
      sampleIdealAnswer = "1. ධමනි බිත්තිය ඝනකම්ය, ශිරා බිත්තිය තුනීයි. 2. ශිරා තුළ කපාට පිහිටා ඇති නමුත් ධමනි තුළ කපාට නැත."
    ),

    // -------------------------------------------------------------------------
    // SET 3: විද්‍යාව - චලිත සමීකරණ සහ නිව්ටන් නියම (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 221,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "නිව්ටන්ගේ පළමු නියමය",
      question = "නිව්ටන්ගේ පළමුවන චලිත නියමය (අවස්ථිති නියමය) ප්‍රකාශ කරන්න.",
      keyPoints = listOf("අසමතුලිත බාහිර බලයක්", "නිශ්චලතාවයේ හෝ ඒකාකාර ප්‍රවේගයෙන්"),
      synonyms = listOf(
        listOf("අසමතුලිත බාහිර බලයක්", "බාහිර බලයක් නොයෙදෙන තාක්"),
        listOf("නිශ්චලතාවයේ හෝ ඒකාකාර ප්‍රවේගයෙන්", "සරල රේඛීය ඒකාකාර ප්‍රවේගයෙන්", "එම තත්ත්වයේම පවතී")
      ),
      officialMarkingScheme = "• අසමතුලිත බාහිර බලයක් නොයෙදෙන තාක් (ලකුණු 1)\n• නිශ්චල වස්තුවක් නිශ්චලතාවයේද, චලනය වන වස්තුවක් සරල රේඛාවක ඒකාකාර ප්‍රවේගයෙන්ද පවතී (ලකුණු 1)",
      sampleIdealAnswer = "බාහිර අසමතුලිත බලයක් නොයෙදෙන තාක් කල්, නිශ්චල වස්තුවක් නිශ්චලතාවයේ ද චලනය වන වස්තුවක් ඒකාකාර ප්‍රවේගයෙන් සරල රේඛීයව ද පවතී."
    ),
    ShortAnswerQuestion(
      id = 222,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "නිව්ටන්ගේ දෙවන නියමය",
      question = "නිව්ටන්ගේ දෙවන නියමයට අදාළ මූලික ගණිතමය සමීකරණය ලියන්න. එහි සංකේත නම් කරන්න.",
      keyPoints = listOf("F = ma", "F = බලය m = ස්කන්ධය a = ත්වරණය"),
      synonyms = listOf(
        listOf("f = ma", "f=ma"),
        listOf("f = බලය m = ස්කන්ධය a = ත්වරණය", "බලය = ස්කන්ධය x ත්වරණය")
      ),
      officialMarkingScheme = "• සමීකරණය: F = ma (ලකුණු 1)\n• සංකේත: F = බලය, m = ස්කන්ධය, a = ත්වරණය (ලකුණු 1)",
      sampleIdealAnswer = "F = ma වේ. මෙහි F = අසමතුලිත බලය, m = ස්කන්ධය, a = ත්වරණය වේ."
    ),
    ShortAnswerQuestion(
      id = 223,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "නිව්ටන්ගේ තෙවන නියමය",
      question = "නිව්ටන්ගේ තෙවන චලිත නියමය ප්‍රකාශ කරන්න. රොකට්ටුවක් ඉහළට ගමන් කිරීමේදී ක්‍රියාව සහ ප්‍රතික්‍රියාව හඳුනාගන්න.",
      keyPoints = listOf("සෑම ක්‍රියාවකටම සමාන හා ප්‍රතිවිරුද්ධ ප්‍රතික්‍රියාවක් ඇත", "වායු පිටවීම හා රොකට්ටුව ඉදිරියට තල්ලු වීම"),
      synonyms = listOf(
        listOf("සෑම ක්‍රියාවකටම සමාන හා ප්‍රතිවිරුද්ධ ප්‍රතික්‍රියාවක් ඇත", "ක්‍රියාව සමානයි ප්‍රතික්‍රියාවට"),
        listOf("වායු පිටවීම හා රොකට්ටුව ඉදිරියට තල්ලු වීම", "වායුව පහළට දැවීම හා රොකට්ටුව එසවීම")
      ),
      officialMarkingScheme = "• නියමය: සෑම ක්‍රියාවකටම විශාලත්වයෙන් සමාන දිශාවෙන් ප්‍රතිවිරුද්ධ ප්‍රතික්‍රියාවක් ඇත (ලකුණු 1)\n• රොකට්ටුව: පිටවන වායුව පහළට යෙදෙන බලය ක්‍රියාව වන අතර, රොකට්ටුව මත ඉහළට යෙදෙන බලය ප්‍රතික්‍රියාවයි (ලකුණු 1)",
      sampleIdealAnswer = "සෑම ක්‍රියාවකටම විශාලත්වයෙන් සමාන, දිශාවෙන් ප්‍රතිවිරුද්ධ ප්‍රතික්‍රියාවක් පවතී. රොකට්ටුවෙන් පිටවන වායුවේ බලය ක්‍රියාව වන අතර රොකට්ටුව ඉදිරියට තල්ලුවීම ප්‍රතික්‍රියාවයි."
    ),
    ShortAnswerQuestion(
      id = 224,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "චලිත සමීකරණ",
      question = "ඒකාකාර ත්වරණයෙන් චලනය වන වස්තුවක් සඳහා වන චලිත සමීකරණ 3 ලියන්න.",
      keyPoints = listOf("v = u + at", "s = ut + ½at² සහ v² = u² + 2as"),
      synonyms = listOf(
        listOf("v = u + at", "v=u+at"),
        listOf("s = ut + ½at² සහ v² = u² + 2as", "v2 = u2 + 2as", "s=ut+1/2at2")
      ),
      officialMarkingScheme = "1. v = u + at\n2. s = ut + ½at²\n3. v² = u² + 2as (ලකුණු 2)",
      sampleIdealAnswer = "1. v = u + at \n2. s = ut + ½at² \n3. v² = u² + 2as."
    ),
    ShortAnswerQuestion(
      id = 225,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "ප්‍රවේග-කාල ප්‍රස්තාර",
      question = "ප්‍රවේග-කාල ප්‍රස්තාරයක අනුක්‍රමණයෙන් නිරූපණය වන රාශිය සහ ප්‍රස්තාරය යටතේ වර්ගඵලයෙන් නිරූපණය වන රාශිය ලියන්න.",
      keyPoints = listOf("ත්වරණය", "විස්ථාපනය"),
      synonyms = listOf(
        listOf("ත්වරණය", "මන්දනය", "acceleration"),
        listOf("විස්ථාපනය", "ගමන් කළ දුර", "displacement")
      ),
      officialMarkingScheme = "• අනුක්‍රමණය: ත්වරණය නිරූපණය වේ (ලකුණු 1)\n• වර්ගඵලය: විස්ථාපනය (ගමන් කළ දුර) නිරූපණය වේ (ලකුණු 1)",
      sampleIdealAnswer = "අනුක්‍රමණයෙන් ත්වරණය ද, ප්‍රස්තාරය යටතේ වර්ගඵලයෙන් විස්ථාපනය ද ලැබේ."
    ),
    ShortAnswerQuestion(
      id = 226,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "ගම්‍යතාව",
      question = "ගම්‍යතාව යනු කුමක්ද? එහි SI ඒකකය ලියන්න.",
      keyPoints = listOf("ස්කන්ධය සහ ප්‍රවේගයේ ගුණිතය", "kg ms-1"),
      synonyms = listOf(
        listOf("ස්කන්ධය සහ ප්‍රවේගයේ ගුණිතය", "p = mv", "ස්කන්ධය x ප්‍රවේගය"),
        listOf("kg ms-1", "kg ms⁻¹", "kg m/s", "ns")
      ),
      officialMarkingScheme = "• නිර්වචනය: වස්තුවක ස්කන්ධය සහ ප්‍රවේගයේ ගුණිතය (p = mv) සඳහා ලකුණු 1\n• ඒකකය: kg ms⁻¹ (හෝ N s) සඳහා ලකුණු 1",
      sampleIdealAnswer = "වස්තුවේ ස්කන්ධය හා ප්‍රවේගයේ ගුණිතයයි (p = mv). ඒකකය kg ms⁻¹ (හෝ N s) වේ."
    ),
    ShortAnswerQuestion(
      id = 227,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "සීමාකාරී ඝර්ෂණය",
      question = "සීමාකාරී ඝර්ෂණ බලය රඳා පවතින ප්‍රධාන සාධක 2ක් ලියන්න.",
      keyPoints = listOf("ස්පර්ශ පෘෂ්ඨවල ස්වභාවය", "අභිලම්භ ප්‍රතික්‍රියාව"),
      synonyms = listOf(
        listOf("ස්පර්ශ පෘෂ්ඨවල ස්වභාවය", "පෘෂ්ඨයේ රළු/සිනිඳු බව", "ස්වභාවය"),
        listOf("අභිලම්භ ප්‍රතික්‍රියාව", "වස්තුවේ බර", "ලම්බක බලය", "r")
      ),
      officialMarkingScheme = "• ස්පර්ශ පෘෂ්ඨවල ස්වභාවය (රළු බව) සඳහා ලකුණු 1\n• අභිලම්භ ප්‍රතික්‍රියා බලය (R) සඳහා ලකුණු 1",
      sampleIdealAnswer = "1. ස්පර්ශ වන පෘෂ්ඨවල ස්වභාවය (රළු බව). 2. අභිලම්භ ප්‍රතික්‍රියා බලය (R)."
    ),
    ShortAnswerQuestion(
      id = 228,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "දියර පීඩනය",
      question = "නිශ්චල ද්‍රවයක h ගැඹුරකදී පීඩනය ගණනය කරන සූත්‍රය P = hρg වේ. මෙහි ρ සහ g මඟින් නිරූපණය වන්නේ මොනවාද?",
      keyPoints = listOf("ද්‍රවයේ ඝනත්වය", "ගුරුත්වජ ත්වරණය"),
      synonyms = listOf(
        listOf("ද්‍රවයේ ඝනත්වය", "ඝනත්වය", "density"),
        listOf("ගුරුත්වජ ත්වරණය", "ගුරුත්වය", "g")
      ),
      officialMarkingScheme = "• ρ = ද්‍රවයේ ඝනත්වය සඳහා ලකුණු 1\n• g = ගුරුත්වජ ත්වරණය සඳහා ලකුණු 1",
      sampleIdealAnswer = "ρ මඟින් ද්‍රවයේ ඝනත්වය ද, g මඟින් ගුරුත්වජ ත්වරණය ද නිරූපණය වේ."
    ),
    ShortAnswerQuestion(
      id = 229,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "ආකිමිඩීස් මූලධර්මය",
      question = "ආකිමිඩීස් මූලධර්මය ප්‍රකාශ කරන්න.",
      keyPoints = listOf("උඩුකුරු තෙරපුම", "විස්ථාපිත ද්‍රවයේ බරට සමාන වේ"),
      synonyms = listOf(
        listOf("උඩුකුරු තෙරපුම", "තෙරපුම් බලය", "upthrust"),
        listOf("විස්ථාපිත ද්‍රවයේ බරට සමාන වේ", "ඉවත් කළ ද්‍රවයේ බර", "විස්ථාපිත බර")
      ),
      officialMarkingScheme = "• වස්තුවක් ද්‍රවයක සම්පූර්ණයෙන් හෝ අර්ධ වශයෙන් ගිලී පවතින විට (ලකුණු 1)\n• ඒ මත ක්‍රියාකරන උඩුකුරු තෙරපුම වස්තුව මඟින් විස්ථාපනය කරන ද්‍රවයේ බරට සමාන වේ (ලකුණු 1)",
      sampleIdealAnswer = "ද්‍රවයක ගිලී ඇති වස්තුවක් මත ඇතිවන උඩුකුරු තෙරපුම, එමඟින් විස්ථාපනය කෙරෙන ද්‍රවයේ බරට සමාන වේ."
    ),
    ShortAnswerQuestion(
      id = 230,
      grade = "10",
      setNumber = 3,
      subject = "විද්‍යාව (Science)",
      topic = "පාස්කල් නියමය",
      question = "පාස්කල් නියමය භාවිත කර ක්‍රියාකරන හයිඩ්‍රොලික් උපකරණ 2ක් නම් කරන්න.",
      keyPoints = listOf("හයිඩ්‍රොලික් ජැක්කුව", "හයිඩ්‍රොලික් තිරිංග"),
      synonyms = listOf(
        listOf("හයිඩ්‍රොලික් ජැක්කුව", "වාහන ඔසවන ජැක්කුව", "hydraulic jack"),
        listOf("හයිඩ්‍රොලික් තිරිංග", "හයිඩ්‍රොලික් බ්‍රේක්", "තිරිංග පද්ධතිය", "hydraulic brakes")
      ),
      officialMarkingScheme = "• හයිඩ්‍රොලික් ජැක්කුව / එසවුම සඳහා ලකුණු 1\n• හයිඩ්‍රොලික් තිරිංග පද්ධතිය (Brakes) සඳහා ලකුණු 1",
      sampleIdealAnswer = "1. හයිඩ්‍රොලික් ජැක්කුව (හෝ එසවුම). 2. වාහනවල හයිඩ්‍රොලික් තිරිංග පද්ධතිය (Hydraulic Brakes)."
    ),

    // -------------------------------------------------------------------------
    // SET 4: ගණිතය - වර්ගජ ප්‍රකාශන සහ සාධක (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 231,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "ත්‍රෛපද වර්ගජ සාධක",
      question = "x² + 7x + 12 ප්‍රකාශනය සාධක දෙකක ගුණිතයක් ලෙස ලියන්න.",
      keyPoints = listOf("x + 3", "x + 4"),
      synonyms = listOf(
        listOf("x + 3", "(x+3)", "x+3"),
        listOf("x + 4", "(x+4)", "x+4")
      ),
      officialMarkingScheme = "• ගුණිතය 12 හා ඓක්‍යය 7 වන සංඛ්‍යා 3 හා 4 (ලකුණු 1)\n• (x + 3)(x + 4) සඳහා ලකුණු 1",
      sampleIdealAnswer = "(x + 3)(x + 4) වේ."
    ),
    ShortAnswerQuestion(
      id = 232,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "සෘණ ලකුණු සහිත සාධක",
      question = "x² - 5x - 14 ප්‍රකාශනයේ සාධක වෙන් කරන්න.",
      keyPoints = listOf("x - 7", "x + 2"),
      synonyms = listOf(
        listOf("x - 7", "(x-7)", "x-7"),
        listOf("x + 2", "(x+2)", "x+2")
      ),
      officialMarkingScheme = "• ගුණිතය -14 හා ඓක්‍යය -5 වන සංඛ්‍යා -7 හා +2 (ලකුණු 1)\n• (x - 7)(x + 2) සඳහා ලකුණු 1",
      sampleIdealAnswer = "(x - 7)(x + 2) වේ."
    ),
    ShortAnswerQuestion(
      id = 233,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "a ≠ 1 වන වර්ගජ සාධක",
      question = "2x² + 5x + 3 ප්‍රකාශනයේ සාධක සොයන්න.",
      keyPoints = listOf("2x + 3", "x + 1"),
      synonyms = listOf(
        listOf("2x + 3", "(2x+3)", "2x+3"),
        listOf("x + 1", "(x+1)", "x+1")
      ),
      officialMarkingScheme = "• මැද පදය වෙන් කිරීම: 2x² + 2x + 3x + 3 (ලකුණු 1)\n• (2x + 3)(x + 1) සඳහා ලකුණු 1",
      sampleIdealAnswer = "2x(x + 1) + 3(x + 1) = (2x + 3)(x + 1)."
    ),
    ShortAnswerQuestion(
      id = 234,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "වර්ගජ සමීකරණ විසඳීම",
      question = "x² - 9 = 0 වර්ගජ සමීකරණය විසඳා x හි අගයන් දෙක ලියන්න.",
      keyPoints = listOf("x = 3", "x = -3"),
      synonyms = listOf(
        listOf("x = 3", "3", "+3", "x=3"),
        listOf("x = -3", "-3", "ඍණ 3", "x=-3")
      ),
      officialMarkingScheme = "• (x - 3)(x + 3) = 0 සඳහා ලකුණු 1\n• x = 3 හෝ x = -3 සඳහා ලකුණු 1",
      sampleIdealAnswer = "x² = 9 => x = ±3 (එනම් x = 3 හෝ x = -3 වේ)."
    ),
    ShortAnswerQuestion(
      id = 235,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "සාධක මගින් වර්ගජ සමීකරණ",
      question = "x² - 4x = 0 සමීකරණය විසඳන්න.",
      keyPoints = listOf("x = 0", "x = 4"),
      synonyms = listOf(
        listOf("x = 0", "0", "බිංදුව"),
        listOf("x = 4", "4", "හතර")
      ),
      officialMarkingScheme = "• x(x - 4) = 0 සඳහා ලකුණු 1\n• x = 0 හෝ x = 4 සඳහා ලකුණු 1",
      sampleIdealAnswer = "x(x - 4) = 0 => x = 0 හෝ x = 4 වේ."
    ),
    ShortAnswerQuestion(
      id = 236,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "පූර්ණ වර්ග ත්‍රෛපද",
      question = "x² + 6x + c පූර්ණ වර්ගයක් වීමට c හි අගය කීයද? එම පූර්ණ වර්ග ප්‍රකාශනය ලියන්න.",
      keyPoints = listOf("c = 9", "(x + 3)²"),
      synonyms = listOf(
        listOf("c = 9", "9", "c=9"),
        listOf("(x + 3)²", "(x+3)^2", "(x + 3)^2")
      ),
      officialMarkingScheme = "• c = (6/2)² = 3² = 9 සඳහා ලකුණු 1\n• පූර්ණ වර්ගය: (x + 3)² සඳහා ලකුණු 1",
      sampleIdealAnswer = "c = (6/2)² = 9 වේ. පූර්ණ වර්ග ප්‍රකාශනය (x + 3)² වේ."
    ),
    ShortAnswerQuestion(
      id = 237,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "වීජීය භාග එකතු කිරීම",
      question = "2/x + 3/(2x) සුළු කර තනි භාගයක් ලෙස දක්වන්න.",
      keyPoints = listOf("7/(2x)", "පොදු හරය 2x"),
      synonyms = listOf(
        listOf("7/(2x)", "7/2x", "7 / 2x"),
        listOf("පොදු හරය 2x", "2x")
      ),
      officialMarkingScheme = "• පොදු හරය 2x ගැනීම: 4/(2x) + 3/(2x) සඳහා ලකුණු 1\n• අවසාන පිළිතුර: 7/(2x) සඳහා ලකුණු 1",
      sampleIdealAnswer = "පොදු හරය 2x වේ. (4 + 3) / 2x = 7/(2x)."
    ),
    ShortAnswerQuestion(
      id = 238,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "වීජීය භාග ගුණ කිරීම",
      question = "(x - 2)/5 × 15/(x - 2) සුළු කරන්න.",
      keyPoints = listOf("3", "කැපී යාම"),
      synonyms = listOf(
        listOf("3", "තුන", "three"),
        listOf("කැපී යාම", "(x-2) කැපී යයි")
      ),
      officialMarkingScheme = "• (x - 2) පද කැපී යාම (ලකුණු 1)\n• 15 / 5 = 3 සඳහා ලකුණු 1",
      sampleIdealAnswer = "(x - 2) පද දෙක කැපී යන අතර 15 / 5 = 3 වේ."
    ),
    ShortAnswerQuestion(
      id = 239,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "ද්විපද ප්‍රකාශන ප්‍රසාරණය",
      question = "(2x - 3)² ප්‍රසාරණය කර ලියන්න.",
      keyPoints = listOf("4x² - 12x + 9", "4x²"),
      synonyms = listOf(
        listOf("4x² - 12x + 9", "4x^2 - 12x + 9", "4x2 - 12x + 9"),
        listOf("4x²", "4x^2")
      ),
      officialMarkingScheme = "• (2x)² - 2(2x)(3) + (3)² (ලකුණු 1)\n• 4x² - 12x + 9 (ලකුණු 1)",
      sampleIdealAnswer = "(2x)² - 2(2x)(3) + 3² = 4x² - 12x + 9 වේ."
    ),
    ShortAnswerQuestion(
      id = 240,
      grade = "10",
      setNumber = 4,
      subject = "ගණිතය (Mathematics)",
      topic = "කෝෂ න්‍යාය (කුලක)",
      question = "n(A) = 15, n(B) = 20 සහ n(A ∩ B) = 5 නම් n(A ∪ B) ගණනය කරන්න.",
      keyPoints = listOf("30", "15 + 20 - 5"),
      synonyms = listOf(
        listOf("30", "තිහ", "thirty"),
        listOf("15 + 20 - 5", "35 - 5 = 30")
      ),
      officialMarkingScheme = "• සූත්‍රය: n(A ∪ B) = n(A) + n(B) - n(A ∩ B) සඳහා ලකුණු 1\n• 15 + 20 - 5 = 30 සඳහා ලකුණු 1",
      sampleIdealAnswer = "n(A ∪ B) = 15 + 20 - 5 = 30 වේ."
    ),

    // -------------------------------------------------------------------------
    // SET 5: ගණිතය - ත්‍රිකෝණමිතිය සහ පරිමාව (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 241,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "ත්‍රිකෝණමිතික අනුපාත",
      question = "සෘජුකෝණී ත්‍රිකෝණයක sin θ අනුපාතය පාද ඇසුරෙන් ලියන්න. කර්ණය 10 cm ද සම්මුඛ පාදය 6 cm ද නම් sin θ අගය කීයද?",
      keyPoints = listOf("සම්මුඛ පාදය / කර්ණය", "0.6"),
      synonyms = listOf(
        listOf("සම්මුඛ පාදය / කර්ණය", "සම්මුඛ / කර්ණය", "opposite / hypotenuse"),
        listOf("0.6", "6/10", "3/5")
      ),
      officialMarkingScheme = "• සූත්‍රය: sin θ = සම්මුඛ පාදය / කර්ණය සඳහා ලකුණු 1\n• අගය = 6 / 10 = 3/5 (හෝ 0.6) සඳහා ලකුණු 1",
      sampleIdealAnswer = "sin θ = සම්මුඛ පාදය / කර්ණය වේ. sin θ = 6 / 10 = 0.6 (හෝ 3/5) වේ."
    ),
    ShortAnswerQuestion(
      id = 242,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "tan θ අනුපාතය",
      question = "tan θ අනුපාතය අර්ථ දක්වන්න. tan 45° හි අගය කීයද?",
      keyPoints = listOf("සම්මුඛ පාදය / බද්ධ පාදය", "1"),
      synonyms = listOf(
        listOf("සම්මුඛ පාදය / බද්ධ පාදය", "සම්මුඛ / බද්ධ", "opposite / adjacent"),
        listOf("1", "එක", "one")
      ),
      officialMarkingScheme = "• අර්ථ දැක්වීම: සම්මුඛ පාදය / බද්ධ පාදය සඳහා ලකුණු 1\n• tan 45° = 1 සඳහා ලකුණු 1",
      sampleIdealAnswer = "tan θ = සම්මුඛ පාදය / බද්ධ පාදය. tan 45° = 1 කි."
    ),
    ShortAnswerQuestion(
      id = 243,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "සිලින්ඩරයක පරිමාව",
      question = "අරය r සහ උස h වන ඝන සිලින්ඩරයක පරිමාව සෙවීමේ සූත්‍රය ලියන්න. r = 7 cm සහ h = 10 cm නම් පරිමාව සොයන්න (π = 22/7).",
      keyPoints = listOf("πr²h", "1540 cm³"),
      synonyms = listOf(
        listOf("πr²h", "pi * r^2 * h", "pir2h"),
        listOf("1540 cm³", "1540cm3", "1540")
      ),
      officialMarkingScheme = "• සූත්‍රය: V = πr²h සඳහා ලකුණු 1\n• පරිමාව: (22/7) × 7 × 7 × 10 = 1540 cm³ සඳහා ලකුණු 1",
      sampleIdealAnswer = "V = πr²h වේ. පරිමාව = (22/7) × 49 × 10 = 1540 cm³ වේ."
    ),
    ShortAnswerQuestion(
      id = 244,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "සිලින්ඩරයක වක්‍ර පෘෂ්ඨ වර්ගඵලය",
      question = "සිලින්ඩරයක වක්‍ර පෘෂ්ඨ වර්ගඵලය සෙවීමේ සූත්‍රය ලියන්න. r = 7 cm, h = 5 cm නම් වක්‍ර පෘෂ්ඨ වර්ගඵලය කීයද?",
      keyPoints = listOf("2πrh", "220 cm²"),
      synonyms = listOf(
        listOf("2πrh", "2 * pi * r * h", "2pirh"),
        listOf("220 cm²", "220cm2", "220")
      ),
      officialMarkingScheme = "• සූත්‍රය: 2πrh සඳහා ලකුණු 1\n• වර්ගඵලය: 2 × (22/7) × 7 × 5 = 220 cm² සඳහා ලකුණු 1",
      sampleIdealAnswer = "වක්‍ර පෘෂ්ඨ වර්ගඵලය = 2πrh. පිළිතුර = 2 × 22/7 × 7 × 5 = 220 cm² වේ."
    ),
    ShortAnswerQuestion(
      id = 245,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "කේතුවක පරිමාව",
      question = "කේතුවක පරිමාව සෙවීමේ සූත්‍රය ලියන්න. එය සමාන පාද අරයක් හා උසක් ඇති සිලින්ඩරයක පරිමාවෙන් කවර භාගයක්ද?",
      keyPoints = listOf("⅓πr²h", "තුනෙන් එකක්"),
      synonyms = listOf(
        listOf("⅓πr²h", "1/3 * pi * r^2 * h", "1/3 pir2h"),
        listOf("තුනෙන් එකක්", "1/3", "තුනෙන් පංගුවක්")
      ),
      officialMarkingScheme = "• සූත්‍රය: V = ⅓πr²h සඳහා ලකුණු 1\n• භාගය: සිලින්ඩර පරිමාවෙන් 1/3 කි (තුනෙන් එකකි) සඳහා ලකුණු 1",
      sampleIdealAnswer = "V = ⅓πr²h වේ. එය සිලින්ඩරයක පරිමාවෙන් තුනෙන් එකකි (1/3)."
    ),
    ShortAnswerQuestion(
      id = 246,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "ගෝලයක පරිමාව සහ වර්ගඵලය",
      question = "අරය r වන ගෝලයක පෘෂ්ඨ වර්ගඵලය සෙවීමේ සූත්‍රය ලියන්න.",
      keyPoints = listOf("4πr²", "හතරයි පයි ආර් වර්ගය"),
      synonyms = listOf(
        listOf("4πr²", "4 * pi * r^2", "4pir2", "4pi r^2"),
        listOf("හතරයි පයි ආර් වර්ගය", "4 pi r2")
      ),
      officialMarkingScheme = "• පෘෂ්ඨ වර්ගඵලය = 4πr² (ලකුණු 2)",
      sampleIdealAnswer = "ගෝලයක පෘෂ්ඨ වර්ගඵලය = 4πr² වේ."
    ),
    ShortAnswerQuestion(
      id = 247,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "සිරස් සහ අවනති කෝණ",
      question = "ආරෝහණ කෝණය (Angle of elevation) සහ අවනති කෝණය (Angle of depression) මනිනු ලබන්නේ කුමන රේඛාවට සාපේක්ෂවද?",
      keyPoints = listOf("තිරස් රේඛාවට", "තිරසට"),
      synonyms = listOf(
        listOf("තිරස් රේඛාවට", "තිරස් තලයට", "horizontal line"),
        listOf("තිරසට", "තිරස් බැල්මට")
      ),
      officialMarkingScheme = "• නිරීක්ෂකයාගේ ඇස මට්ටමේ ඇති තිරස් රේඛාවට (තිරසට) සාපේක්ෂව (ලකුණු 2)",
      sampleIdealAnswer = "ඇසේ මට්ටමෙන් අඳින ලද තිරස් රේඛාවට සාපේක්ෂව ඉහළට (ආරෝහණ) සහ පහළට (අවනති) මනිනු ලැබේ."
    ),
    ShortAnswerQuestion(
      id = 248,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "චක්‍රීය චතුරස්‍ර",
      question = "චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණවල ඇති විශේෂ සම්බන්ධතාව කුමක්ද?",
      keyPoints = listOf("සම්මුඛ කෝණ අතිපූරක වේ", "ඓක්‍යය 180° කි"),
      synonyms = listOf(
        listOf("සම්මුඛ කෝණ අතිපූරක වේ", "අතිපූරක වේ", "එකතුව 180"),
        listOf("ඓක්‍යය 180° කි", "180°", "180")
      ),
      officialMarkingScheme = "• සම්මුඛ කෝණ යුගලයක ඓක්‍යය 180° කි (අතිපූරක වේ) (ලකුණු 2)",
      sampleIdealAnswer = "සම්මුඛ කෝණවල එකතුව 180° කි (එනම් සම්මුඛ කෝණ අතිපූරක වේ)."
    ),
    ShortAnswerQuestion(
      id = 249,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "වෘත්ත කණ්ඩයක කෝණ",
      question = "එකම වෘත්ත ඛණ්ඩයේ පිහිටි කෝණ අතර ඇති සම්බන්ධය කුමක්ද?",
      keyPoints = listOf("එකිනෙකට සමාන වේ", "සමානයි"),
      synonyms = listOf(
        listOf("එකිනෙකට සමාන වේ", "සමාන වේ", "equal"),
        listOf("සමානයි", "විශාලත්වයෙන් සමානයි")
      ),
      officialMarkingScheme = "• එකම වෘත්ත ඛණ්ඩයේ පිහිටි කෝණ විශාලත්වයෙන් එකිනෙකට සමාන වේ (ලකුණු 2)",
      sampleIdealAnswer = "එකම වෘත්ත ඛණ්ඩයේ කෝණ විශාලත්වයෙන් එකිනෙකට සමාන වේ."
    ),
    ShortAnswerQuestion(
      id = 250,
      grade = "10",
      setNumber = 5,
      subject = "ගණිතය (Mathematics)",
      topic = "අර්ධ වෘත්තයක කෝණය",
      question = "අර්ධ වෘත්තයක කෝණයේ විශාලත්වය අංශක කීයද?",
      keyPoints = listOf("90°", "සෘජුකෝණයක්"),
      synonyms = listOf(
        listOf("90°", "90", "අංශක 90"),
        listOf("සෘජුකෝණයක්", "සෘජුකෝණයකි", "right angle")
      ),
      officialMarkingScheme = "• අර්ධ වෘත්තයේ කෝණය = 90° (සෘජුකෝණයකි) (ලකුණු 2)",
      sampleIdealAnswer = "අංශක 90° කි (සෘජුකෝණයකි)."
    ),

    // -------------------------------------------------------------------------
    // SET 6: ඉතිහාසය - පොළොන්නරු යුගය සහ රජවරු (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 251,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "පළමුවන විජයබාහු රජු",
      question = "වසර 77 ක චෝල පාලනයෙන් රට නිදහස් කර පොළොන්නරුවේ අගරජු බවට පත් වූ රජු කවුද? එතුමා රුහුණේදී හැඳින්වූ මුල් නම කුමක්ද?",
      keyPoints = listOf("පළමුවන විජයබාහු", "කීර්ති කුමාරයා"),
      synonyms = listOf(
        listOf("පළමුවන විජයබාහු", "1 වන විජයබාහු", "විජයබාහු රජු", "vijayabahu"),
        listOf("කීර්ති කුමාරයා", "කීර්ති කුමරු", "කීර්ති")
      ),
      officialMarkingScheme = "• රජු: පළමුවන විජයබාහු රජු සඳහා ලකුණු 1\n• මුල් නම: කීර්ති කුමාරයා සඳහා ලකුණු 1",
      sampleIdealAnswer = "පළමුවන විජයබාහු රජතුමාය. එතුමාගේ ළමා වියේ නම කීර්ති කුමාරයා විය."
    ),
    ShortAnswerQuestion(
      id = 252,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "දළදා වහන්සේ සහ වේළයික්කාර හමුදාව",
      question = "පළමුවන විජයබාහු රජු දළදා වහන්සේගේ ආරක්ෂාව භාරකළ ප්‍රබල විදේශීය ආරක්ෂක හමුදාව කුමක්ද? ඒ බව සඳහන් සෙල්ලිපිය කුමක්ද?",
      keyPoints = listOf("වේළයික්කාර හමුදාව", "පොළොන්නරුව වේළයික්කාර සෙල්ලිපිය"),
      synonyms = listOf(
        listOf("වේළයික්කාර හමුදාව", "වේලයික්කාර", "velaikaara"),
        listOf("පොළොන්නරුව වේළයික්කාර සෙල්ලිපිය", "වේළයික්කාර සෙල්ලිපිය", "පොළොන්නරු දෙමළ සෙල්ලිපිය")
      ),
      officialMarkingScheme = "• හමුදාව: වේළයික්කාර හමුදාව සඳහා ලකුණු 1\n• සෙල්ලිපිය: පොළොන්නරුවේ වේළයික්කාර සෙල්ලිපිය සඳහා ලකුණු 1",
      sampleIdealAnswer = "වේළයික්කාර හමුදාවටය. පොළොන්නරුව වේළයික්කාර සෙල්ලිපියේ ඒ බව සඳහන් වේ."
    ),
    ShortAnswerQuestion(
      id = 253,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "මහා පරාක්‍රමබාහු රජු",
      question = "'අහසින් වැටෙන එකදු දිය බිඳක්වත් මිනිසාගේ ප්‍රයෝජනයට නොගෙන මුහුදට ගලා යාමට ඉඩ නොදිය යුතුය' යන උදාර ප්‍රකාශය කළ රජු කවුද?",
      keyPoints = listOf("මහා පරාක්‍රමබාහු රජු", "පරාක්‍රම සමුද්‍රය"),
      synonyms = listOf(
        listOf("මහා පරාක්‍රමබාහු රජු", "පළමුවන පරාක්‍රමබාහු", "පරාක්‍රමබාහු රජු", "parakramabahu"),
        listOf("පරාක්‍රම සමුද්‍රය", "පරාක්‍රමබාහු")
      ),
      officialMarkingScheme = "• රජු: පළමුවන මහා පරාක්‍රමබාහු රජතුමා (ලකුණු 2)",
      sampleIdealAnswer = "පළමුවන මහා පරාක්‍රමබාහු රජතුමාය."
    ),
    ShortAnswerQuestion(
      id = 254,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "පරාක්‍රම සමුද්‍රය",
      question = "පරාක්‍රම සමුද්‍රය නිර්මාණය කිරීම සඳහා ඒකාබද්ධ කරන ලද ප්‍රධාන වැව් 3න් 2ක් නම් කරන්න.",
      keyPoints = listOf("තෝපා වැව", "දුඹුටුළු වැව"),
      synonyms = listOf(
        listOf("තෝපා වැව", "තෝපාවැව"),
        listOf("දුඹුටුළු වැව", "එරබදු වැව", "දුඹුටුළුවැව")
      ),
      officialMarkingScheme = "• තෝපා වැව, දුඹුටුළු වැව, එරබදු වැව අතුරින් 2ක් නම් කිරීම (ලකුණු 2)",
      sampleIdealAnswer = "තෝපා වැව සහ දුඹුටුළු වැව (හෝ එරබදු වැව) ඒකාබද්ධ කර තනන ලදී."
    ),
    ShortAnswerQuestion(
      id = 255,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "පරාක්‍රමබාහු විදේශ ආක්‍රමණ",
      question = "මහා පරාක්‍රමබාහු රජු විසින් යුද හමුදා යවන ලද විදේශීය රාජ්‍යයන් 2 නම් කරන්න.",
      keyPoints = listOf("පාණ්ඩ්‍ය දේශය", "බුරුමය"),
      synonyms = listOf(
        listOf("පාණ්ඩ්‍ය දේශය", "දකුණු ඉන්දියාව", "පාණ්ඩ්‍ය", "chola"),
        listOf("බුරුමය", "රාමඤ්ඤ දේශය", "මියන්මාරය", "burma")
      ),
      officialMarkingScheme = "• පාණ්ඩ්‍ය දේශය (දකුණු ඉන්දියාව) සඳහා ලකුණු 1\n• රාමඤ්ඤ දේශය (බුරුමය / මියන්මාරය) සඳහා ලකුණු 1",
      sampleIdealAnswer = "දකුණු ඉන්දියාවේ පාණ්ඩ්‍ය දේශය සහ බුරුමය (රාමඤ්ඤ දේශය) වේ."
    ),
    ShortAnswerQuestion(
      id = 256,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "නිශ්ශංකමල්ල රජු",
      question = "පොළොන්නරුවේ වැඩිම සෙල්ලිපි සංඛ්‍යාවක් පිහිටුවූ රජු කවුද? එතුමාගේ ප්‍රසිද්ධ ගල්පොත සෙල්ලිපිය සහ නිශ්ශංක ලතා මණ්ඩපය පිහිටියේ කොහේද?",
      keyPoints = listOf("නිශ්ශංකමල්ල රජු", "පොළොන්නරුව ඇතුළු නුවර"),
      synonyms = listOf(
        listOf("නිශ්ශංකමල්ල රජු", "කීර්ති නිශ්ශංකමල්ල", "nissankamalla"),
        listOf("පොළොන්නරුව ඇතුළු නුවර", "පොළොන්නරුව", "දළදා මළුව")
      ),
      officialMarkingScheme = "• රජු: නිශ්ශංකමල්ල රජු සඳහා ලකුණු 1\n• ස්ථානය: පොළොන්නරුව (දළදා මළුව) සඳහා ලකුණු 1",
      sampleIdealAnswer = "නිශ්ශංකමල්ල රජතුමාය. ඒවා පිහිටියේ පොළොන්නරුවේ දළදා මළුවේය."
    ),
    ShortAnswerQuestion(
      id = 257,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "පොළොන්නරු ගෘහ නිර්මාණ",
      question = "පොළොන්නරුවේ ගල් විහාරයේ ඇති බුද්ධ ප්‍රතිමා 4 මොනවාද?",
      keyPoints = listOf("හිඳි පිළිමය සහ හිටි පිළිමය", "සැතපෙන පිළිමය සහ විද්‍යාධර ගුහාව"),
      synonyms = listOf(
        listOf("හිඳි පිළිමය සහ හිටි පිළිමය", "හිඳි පිළිම", "හිටි පිළිමය"),
        listOf("සැතපෙන පිළිමය සහ විද්‍යාධර ගුහාව", "සැතපෙන පිළිමය", "ගල් විහාරය")
      ),
      officialMarkingScheme = "• හිඳි පිළිමය, විද්‍යාධර ගුහාවේ හිඳි පිළිමය, හිටි පිළිමය, සැතපෙන පිළිමය (ලකුණු 2)",
      sampleIdealAnswer = "1. හිඳි පිළිමය 2. විද්‍යාධර ගුහාව තුළ හිඳි පිළිමය 3. හිටි පිළිමය 4. සැතපෙන පිළිමය."
    ),
    ShortAnswerQuestion(
      id = 258,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "ගෙඩිගේ සම්ප්‍රදාය",
      question = "සම්පූර්ණයෙන්ම ගඩොලින් වහලය පවා නිමවන ලද පොළොන්නරුවේ ඇති ගෙඩිගේ සම්ප්‍රදායේ විහාර 2ක් නම් කරන්න.",
      keyPoints = listOf("තිවංක පිළිමගෙය", "ලංකාතිලකය"),
      synonyms = listOf(
        listOf("තිවංක පිළිමගෙය", "තිවංක ගෙඩිගේ"),
        listOf("ලංකාතිලකය", "ලංකාතිලක පිළිමගෙය", "ථූපාරාමය")
      ),
      officialMarkingScheme = "• තිවංක පිළිමගෙය සඳහා ලකුණු 1\n• ලංකාතිලකය (හෝ ථූපාරාම ගෙඩිගේ) සඳහා ලකුණු 1",
      sampleIdealAnswer = "තිවංක පිළිමගෙය සහ ලංකාතිලක පිළිමගෙය (හෝ ථූපාරාම ගෙඩිගේ) වේ."
    ),
    ShortAnswerQuestion(
      id = 259,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "කාලිංග මාඝ ආක්‍රමණය",
      question = "ක්‍රි.ව. 1215 දී පොළොන්නරුව විනාශ කළ කුරිරු ආක්‍රමණිකයා කවුද? එහි ප්‍රතිඵලයක් ලෙස සිංහල රාජධානියට සිදු වූයේ කුමක්ද?",
      keyPoints = listOf("කාලිංග මාඝ", "රාජධානිය නිරිතදිගට සංක්‍රමණය වීම"),
      synonyms = listOf(
        listOf("කාලිංග මාඝ", "මාඝ", "kalinga magha"),
        listOf("රාජධානිය නිරිතදිගට සංක්‍රමණය වීම", "දඹදෙණියට මාරුවීම", "රාජධානිය බිඳවැටීම")
      ),
      officialMarkingScheme = "• ආක්‍රමණිකයා: කාලිංග මාඝ සඳහා ලකුණු 1\n• ප්‍රතිඵලය: රජරට ශිෂ්ටාචාරය බිඳවැටී රාජධානිය දඹදෙණිය ආදී නිරිතදිග ප්‍රදේශවලට සංක්‍රමණය වීම (ලකුණු 1)",
      sampleIdealAnswer = "කාලිංග මාඝ වේ. රජරට ශිෂ්ටාචාරය බිඳවැටී රාජධානිය නිරිතදිගට (දඹදෙණියට) සංක්‍රමණය විය."
    ),
    ShortAnswerQuestion(
      id = 260,
      grade = "10",
      setNumber = 6,
      subject = "ඉතිහාසය (History)",
      topic = "පොළොන්නරු යුගයේ සාහිත්‍යය",
      question = "පොළොන්නරු යුගයේ ලියැවුණු 'අමාවතුර' සහ 'බුත්සරණ' ග්‍රන්ථ රචනා කළ කතුවරුන් පිළිවෙළින් ලියන්න.",
      keyPoints = listOf("ගුරුළුගෝමී", "විද්‍යාචක්‍රවර්තී"),
      synonyms = listOf(
        listOf("ගුරුළුගෝමී", "ගුරුළුගෝමි"),
        listOf("විද්‍යාචක්‍රවර්තී", "විද්‍යා චක්‍රවර්තී")
      ),
      officialMarkingScheme = "• අමාවතුර: ගුරුළුගෝමී පඬිතුමා සඳහා ලකුණු 1\n• බුත්සරණ: විද්‍යාචක්‍රවර්තී සඳහා ලකුණු 1",
      sampleIdealAnswer = "අමාවතුර රචනා කළේ ගුරුළුගෝමී පඬිතුමාය. බුත්සරණ රචනා කළේ විද්‍යාචක්‍රවර්තීන්ය."
    ),

    // -------------------------------------------------------------------------
    // SET 7: ඉතිහාසය - මධ්‍යකාලීන රාජධානි සහ කෝට්ටේ (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 261,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "දඹදෙණි රාජධානිය",
      question = "දඹදෙණිය අගනුවර කරගත් මුල්ම රජු කවුද? 'කලිකාල සාහිත්‍ය සර්වඥ පණ්ඩිත' නමින් හැඳින්වූ රජු කවුද?",
      keyPoints = listOf("තුන්වන විජයබාහු", "දෙවන පරාක්‍රමබාහු"),
      synonyms = listOf(
        listOf("තුන්වන විජයබාහු", "3 වන විජයබාහු"),
        listOf("දෙවන පරාක්‍රමබාහු", "2 වන පරාක්‍රමබාහු", "පණ්ඩිත පරාක්‍රමබාහු")
      ),
      officialMarkingScheme = "• මුල් රජු: තුන්වන විජයබාහු රජු සඳහා ලකුණු 1\n• පණ්ඩිත රජු: දෙවන පරාක්‍රමබාහු රජු සඳහා ලකුණු 1",
      sampleIdealAnswer = "මුල් රජු තුන්වන විජයබාහුය. පණ්ඩිත පරාක්‍රමබාහු ලෙස හැඳින්වූයේ දෙවන පරාක්‍රමබාහු රජතුමාය."
    ),
    ShortAnswerQuestion(
      id = 262,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "යාපහුව රාජධානිය",
      question = "යාපහුව අගනුවර කරගත් රජු කවුද? යාපහුවේ අදටත් සුරක්ෂිතව පවතින සුවිශේෂී ගෘහ නිර්මාණ අංගය කුමක්ද?",
      keyPoints = listOf("පළමුවන බුවනෙකබාහු", "විශිෂ්ට ගල් පඩිපෙළ"),
      synonyms = listOf(
        listOf("පළමුවන බුවනෙකබාහු", "1 වන බුවනෙකබාහු", "බුවනෙකබාහු"),
        listOf("විශිෂ්ට ගල් පඩිපෙළ", "ගල් තරප්පු පෙළ", "පියගැටපෙළ", "සිංහ රූප")
      ),
      officialMarkingScheme = "• රජු: පළමුවන බුවනෙකබාහු රජු සඳහා ලකුණු 1\n• නිර්මාණය: විචිත්‍රවත් අලංකාර ශෛලමය පියගැටපෙළ (ගල් පඩිපෙළ) සඳහා ලකුණු 1",
      sampleIdealAnswer = "පළමුවන බුවනෙකබාහු රජතුමාය. එහි ඇති විශිෂ්ටතම නිර්මාණය කැටයම් සහිත දැවැන්ත ගල් පඩිපෙළයි."
    ),
    ShortAnswerQuestion(
      id = 263,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "කුරුණෑගල රාජධානිය",
      question = "කුරුණෑගල රාජධානියේ පාලනය කළ ප්‍රධාන රජවරුන් 2ක් නම් කරන්න.",
      keyPoints = listOf("දෙවන බුවනෙකබාහු", "හතරවන පරාක්‍රමබාහු"),
      synonyms = listOf(
        listOf("දෙවන බුවනෙකබාහු", "2 වන බුවනෙකබාහු"),
        listOf("හතරවන පරාක්‍රමබාහු", "4 වන පරාක්‍රමබාහු")
      ),
      officialMarkingScheme = "• දෙවන බුවනෙකබාහු රජු සඳහා ලකුණු 1\n• හතරවන පරාක්‍රමබාහු රජු සඳහා ලකුණු 1",
      sampleIdealAnswer = "දෙවන බුවනෙකබාහු රජු සහ හතරවන පරාක්‍රමබාහු රජු වේ."
    ),
    ShortAnswerQuestion(
      id = 264,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "ජාතක පොත සිංහලට නැගීම",
      question = "පන්සිය පනස් ජාතක පොත පාලියෙන් සිංහලට පරිවර්තනය කළේ කුමන රාජධානි සමයේද? ඒ සඳහා අනුග්‍රහය දැක්වූ රජු කවුද?",
      keyPoints = listOf("කුරුණෑගල යුගය", "හතරවන පරාක්‍රමබාහු"),
      synonyms = listOf(
        listOf("කුරුණෑගල යුගය", "කුරුණෑගල", "kurunegala"),
        listOf("හතරවන පරාක්‍රමබාහු", "4 වන පරාක්‍රමබාහු")
      ),
      officialMarkingScheme = "• රාජධානිය: කුරුණෑගල යුගය සඳහා ලකුණු 1\n• රජු: හතරවන පරාක්‍රමබාහු රජු සඳහා ලකුණු 1",
      sampleIdealAnswer = "කුරුණෑගල රාජධානි සමයේදී හතරවන පරාක්‍රමබාහු රජතුමාගේ රාජ්‍ය අනුග්‍රහයෙනි."
    ),
    ShortAnswerQuestion(
      id = 265,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "ගම්පොළ යුගය",
      question = "ගම්පොළ යුගයට අයත් විශිෂ්ටතම ලී කැටයම් සහිත විහාරය සහ ගඩොල් නිර්මාණයක් වන විහාරය නම් කරන්න.",
      keyPoints = listOf("ඇම්බැක්කේ දේවාලය", "ගඩලාදෙණිය"),
      synonyms = listOf(
        listOf("ඇම්බැක්කේ දේවාලය", "ඇම්බැක්ක", "ambekke"),
        listOf("ගඩලාදෙණිය", "ලංකාතිලකය", "ගඩලාදෙණිය විහාරය")
      ),
      officialMarkingScheme = "• ලී කැටයම්: ඇම්බැක්කේ දේවාලය සඳහා ලකුණු 1\n• ගෘහ නිර්මාණ: ගඩලාදෙණිය (හෝ ලංකාතිලක) විහාරය සඳහා ලකුණු 1",
      sampleIdealAnswer = "ලී කැටයම් සඳහා ඇම්බැක්කේ දේවාලය ද, අනෙක් විහාරය ගඩලාදෙණිය (හෝ ලංකාතිලක) විහාරය ද වේ."
    ),
    ShortAnswerQuestion(
      id = 266,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "කෝට්ටේ රාජධානිය",
      question = "කෝට්ටේ අගනුවර කරගෙන මුළු ලංකාවම අවසන් වරට එක්සේසත් කළ රජු කවුද? එතුමාගේ දක්ෂ සෙන්පතියා කවුද?",
      keyPoints = listOf("හයවන පරාක්‍රමබාහු", "සපුමල් කුමාරයා"),
      synonyms = listOf(
        listOf("හයවන පරාක්‍රමබාහු", "6 වන පරාක්‍රමබාහු", "parakramabahu vi"),
        listOf("සපුමල් කුමාරයා", "සපුමල් කුමරු", "සපුමල්")
      ),
      officialMarkingScheme = "• රජු: හයවන පරාක්‍රමබාහු රජු සඳහා ලකුණු 1\n• සෙන්පතියා: සපුමල් කුමාරයා සඳහා ලකුණු 1",
      sampleIdealAnswer = "හයවන පරාක්‍රමබාහු රජතුමාය. එතුමාගේ දක්ෂ සෙන්පතියා සපුමල් කුමාරයා (චෙම්පක පෙරුමාල්) විය."
    ),
    ShortAnswerQuestion(
      id = 267,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "සන්දේශ කාව්‍ය සාහිත්‍යය",
      question = "කෝට්ටේ යුගයේ රචනා වූ ප්‍රකට සන්දේශ කාව්‍ය 2ක් නම් කරන්න.",
      keyPoints = listOf("සැළලිහිණි සන්දේශය", "පරවි සන්දේශය"),
      synonyms = listOf(
        listOf("සැළලිහිණි සන්දේශය", "සැළලිහිණිය", "selalihini"),
        listOf("පරවි සන්දේශය", "කෝකිල සන්දේශය", "ගිරා සන්දේශය", "හංස සන්දේශය")
      ),
      officialMarkingScheme = "• සැළලිහිණි සන්දේශය, පරවි, ගිරා, හංස, කෝකිල අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. සැළලිහිණි සන්දේශය (තොටගමුවේ ශ්‍රී රාහුල හිමි). 2. හංස සන්දේශය (හෝ ගිරා සන්දේශය)."
    ),
    ShortAnswerQuestion(
      id = 268,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "තොටගමුවේ ශ්‍රී රාහුල හිමි",
      question = "කෝට්ටේ යුගයේ වැඩසිටි මහා පඬිරුවනක් වූ තොටගමුවේ ශ්‍රී රාහුල හිමියන් වැඩසිටි පිරිවෙන සහ උන්වහන්සේ කළ ප්‍රධාන ග්‍රන්ථයක් ලියන්න.",
      keyPoints = listOf("විජයබා පිරිවෙන", "කාව්‍යශേഖරය"),
      synonyms = listOf(
        listOf("විජයබා පිරිවෙන", "තොටගමුවේ විජයබා පිරිවෙන"),
        listOf("කාව්‍යශേഖරය", "සැළලිහිණි සන්දේශය", "පරවි සන්දේශය", "පංචිකාප්‍රදීපය")
      ),
      officialMarkingScheme = "• පිරිවෙන: තොටගමුවේ විජයබා පිරිවෙන සඳහා ලකුණු 1\n• ග්‍රන්ථය: කාව්‍යශേഖරය / සැළලිහිණි සන්දේශය සඳහා ලකුණු 1",
      sampleIdealAnswer = "තොටගමුවේ විජයබා පිරිවෙනේ වැඩ විසූහ. කාව්‍යශേഖරය (හෝ සැළලිහිණි සන්දේශය) රචනා කළහ."
    ),
    ShortAnswerQuestion(
      id = 269,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "පෘතුගීසීන්ගේ පැමිණීම",
      question = "පෘතුගීසීන් ප්‍රථම වරට ලංකාවට පැමිණි වර්ෂය කුමක්ද? ඔවුන්ගේ නායකයා ලෙස පැමිණි කපිතාන්වරයා කවුද?",
      keyPoints = listOf("1505", "ලොරෙන්සෝ ද අල්මේදා"),
      synonyms = listOf(
        listOf("1505", "1505 දී", "වර්ෂ 1505"),
        listOf("ලොරෙන්සෝ ද අල්මේදා", "ද අල්මේදා", "lourenco de almeida")
      ),
      officialMarkingScheme = "• වර්ෂය: ක්‍රි.ව. 1505 සඳහා ලකුණු 1\n• නායකයා: ලොරෙන්සෝ ද අල්මේදා සඳහා ලකුණු 1",
      sampleIdealAnswer = "ක්‍රි.ව. 1505 දීය. එම නාවික හමුදාවේ ප්‍රධානියා ලොරෙන්සෝ ද අල්මේදා විය."
    ),
    ShortAnswerQuestion(
      id = 270,
      grade = "10",
      setNumber = 7,
      subject = "ඉතිහාසය (History)",
      topic = "විජයබා කොල්ලය",
      question = "ක්‍රි.ව. 1521 දී සිදුවූ 'විජයබා කොල්ලය' යනු කුමක්ද? එහි ප්‍රතිඵලයක් ලෙස කෝට්ටේ රාජධානිය බෙදී ගිය කොටස් 3 නම් කරන්න.",
      keyPoints = listOf("කුමාරවරුන් පිය රජු ඝාතනය කිරීම", "කෝට්ටේ සීතාවක රයිගම"),
      synonyms = listOf(
        listOf("කුමාරවරුන් පිය රජු ඝාතනය කිරීම", "විජයබාහු රජු මැරීම", "රාජ්‍ය බෙදා ගැනීම"),
        listOf("කෝට්ටේ සීතාවක රයිගම", "කෝට්ටේ", "සීතාවක", "රයිගම")
      ),
      officialMarkingScheme = "• සිදුවීම: විජයබාහු රජුගේ පුතුන් තිදෙනා එක්ව පිය රජු මරා රාජ්‍යය බෙදාගැනීම (ලකුණු 1)\n• රාජධානි 3: කෝට්ටේ, සීතාවක, රයිගම (ලකුණු 1)",
      sampleIdealAnswer = "කුමාරවරුන් තිදෙනා විසින් විජයබාහු පිය රජු මරා රාජ්‍යය බෙදා ගැනීමයි. කෝට්ටේ, සීතාවක, සහ රයිගම ලෙස බෙදී ගියේය."
    ),

    // -------------------------------------------------------------------------
    // SET 8: බුද්ධ ධර්මය - චතුරාර්ය සත්‍යය සහ කර්මය (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 271,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "චතුරාර්ය සත්‍යය",
      question = "බුදුදහමේ මූලික හරය වන චතුරාර්ය සත්‍ය 4 පිළිවෙළින් නම් කරන්න.",
      keyPoints = listOf("දුක්ඛ සමුදය", "නිරෝධ මාර්ග"),
      synonyms = listOf(
        listOf("දුක්ඛ සමුදය", "දුක්ඛ සත්‍යය", "සමුදය සත්‍යය"),
        listOf("නිරෝධ මාර්ග", "නිරෝධ සත්‍යය", "මාර්ග සත්‍යය")
      ),
      officialMarkingScheme = "1. දුක්ඛ ආර්ය සත්‍යය 2. දුක්ඛ සමුදය ආර්ය සත්‍යය 3. දුක්ඛ නිරෝධ ආර්ය සත්‍යය 4. දුක්ඛ නිරෝධ ගාමිණී පටිපදා (මාර්ග) ආර්ය සත්‍යය (ලකුණු 2)",
      sampleIdealAnswer = "1. දුක්ඛ සත්‍යය 2. සමුදය සත්‍යය 3. නිරෝධ සත්‍යය 4. මාර්ග සත්‍යය වේ."
    ),
    ShortAnswerQuestion(
      id = 272,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "දුකට හේතුව (සමුදය සත්‍යය)",
      question = "දුකට මූලික හේතුව ලෙස බුදුරදුන් වදාළේ කුමක්ද? එහි ප්‍රභේද 3 ලියන්න.",
      keyPoints = listOf("තණ්හාව", "කාම භව විභව"),
      synonyms = listOf(
        listOf("තණ්හාව", "තෘෂ්ණාව", "tanha"),
        listOf("කාම භව විභව", "කාම තණ්හා", "භව තණ්හා", "විභව තණ්හා")
      ),
      officialMarkingScheme = "• හේතුව: තණ්හාව (තෘෂ්ණාව) සඳහා ලකුණු 1\n• ප්‍රභේද: කාම තණ්හා, භව තණ්හා, විභව තණ්හා සඳහා ලකුණු 1",
      sampleIdealAnswer = "දුකට හේතුව තණ්හාවයි. එහි ප්‍රභේද: කාම තණ්හා, භව තණ්හා, සහ විභව තණ්හා වේ."
    ),
    ShortAnswerQuestion(
      id = 273,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "ආර්ය අෂ්ටාංගික මාර්ගය සහ ත්‍රිශික්ෂාව",
      question = "ආර්ය අෂ්ටාංගික මාර්ගය ශීල, සමාධි, ප්‍රඥා යන ත්‍රිශික්ෂාවට බෙදෙන ආකාරය දක්වන්න.",
      keyPoints = listOf("ශීල සමාධි ප්‍රඥා", "සම්මා දිට්ඨි සම්මා සංකප්ප"),
      synonyms = listOf(
        listOf("ශීල සමාධි ප්‍රඥා", "ත්‍රිශික්ෂාව"),
        listOf("සම්මා දිට්ඨි සම්මා සංකප්ප", "ප්‍රඥා ශික්ෂාව")
      ),
      officialMarkingScheme = "• ප්‍රඥා: සම්මා දිට්ඨි, සම්මා සංකප්ප\n• ශීල: සම්මා වාචා, සම්මා කම්මන්ත, සම්මා ආජීව\n• සමාධි: සම්මා වායාම, සම්මා සති, සම්මා සමාධි (ලකුණු 2)",
      sampleIdealAnswer = "ප්‍රඥා: සම්මා දිට්ඨි, සම්මා සංකප්ප. ශීල: සම්මා වාචා, සම්මා කම්මන්ත, සම්මා ආජීව. සමාධි: සම්මා වායාම, සම්මා සති, සම්මා සමාධි."
    ),
    ShortAnswerQuestion(
      id = 274,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "කර්මය සහ චේතනාව",
      question = "'චේතනාහං භික්ඛවෙ කම්මං වදාමි' බුදු වදනෙහි තේරුම කුමක්ද? කර්මයක් සකස් වීමට අත්‍යවශ්‍ය සාධකය කුමක්ද?",
      keyPoints = listOf("චේතනාව කර්මයයි", "චේතනාව"),
      synonyms = listOf(
        listOf("චේතනාව කර්මයයි", "මහණෙනි මම චේතනාව කර්මය යයි කියමි"),
        listOf("චේතනාව", "සිතුවිල්ල", "චේතනා")
      ),
      officialMarkingScheme = "• තේරුම: මහණෙනි මම චේතනාව කර්මය යැයි කියමි (ලකුණු 1)\n• සාධකය: චේතනාව (හිතාමතා කිරීම) සඳහා ලකුණු 1",
      sampleIdealAnswer = "'මහණෙනි, මම චේතනාව කර්මය යැයි කියමි'. කර්මයක් වීමට චේතනාව (හිතාමතා කිරීම) අත්‍යවශ්‍ය වේ."
    ),
    ShortAnswerQuestion(
      id = 275,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "විපාක දෙන කාලය අනුව කර්ම",
      question = "විපාක දෙන කාලය අනුව කර්ම වර්ග 4න් 2ක් නම් කර අර්ථ දක්වන්න.",
      keyPoints = listOf("දිට්ඨධම්මවේදනීය", "උපපජ්ජවේදනීය"),
      synonyms = listOf(
        listOf("දිට්ඨධම්මවේදනීය", "මේ ආත්මයේදීම විපාක දෙන"),
        listOf("උපපජ්ජවේදනීය", "දෙවන ආත්මයේ විපාක දෙන", "අපරාපරියවේදනීය", "අහෝසි කර්ම")
      ),
      officialMarkingScheme = "• දිට්ඨධම්මවේදනීය: මේ භවයේදීම විපාක දෙන කර්ම (ලකුණු 1)\n• උපපජ්ජවේදනීය: ඊළඟ භවයේදී විපාක දෙන කර්ම (ලකුණු 1)",
      sampleIdealAnswer = "1. දිට්ඨධම්මවේදනීය කර්ම (මේ ආත්මයේදීම විපාක දෙන). 2. උපපජ්ජවේදනීය කර්ම (ඊළඟ ආත්මයේදී විපාක දෙන)."
    ),
    ShortAnswerQuestion(
      id = 276,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "දස අකුසල්",
      question = "කාය කර්ම මගින් සිදුවන අකුසල් 3 මොනවාද?",
      keyPoints = listOf("ප්‍රාණඝාතය", "අදත්තාදානය සහ කාමේසුමිච්ඡාචාරය"),
      synonyms = listOf(
        listOf("ප්‍රාණඝාතය", "පණ ඇති සතුන් මැරීම"),
        listOf("අදත්තාදානය සහ කාමේසුමිච්ඡාචාරය", "සොරකම් කිරීම", "කාමමිච්ඡාචාරය")
      ),
      officialMarkingScheme = "• ප්‍රාණඝාතය, අදත්තාදානය, කාමේසුමිච්ඡාචාරය (ලකුණු 2)",
      sampleIdealAnswer = "1. ප්‍රාණඝාතය (සතුන් මැරීම) 2. අදත්තාදානය (සොරකම් කිරීම) 3. කාමේසුමිච්ඡාචාරය (වැරදි කාම සේවනය)."
    ),
    ShortAnswerQuestion(
      id = 277,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "පටිච්චසමුප්පාදය",
      question = "පටිච්චසමුප්පාද ධර්මයේ මූලික න්‍යාය කෙටියෙන් ප්‍රකාශ කරන්න. සංසාර චක්‍රයේ මුල්ම හේතු ධර්මය කුමක්ද?",
      keyPoints = listOf("හේතු ඵල දහම", "අවිද්‍යාව"),
      synonyms = listOf(
        listOf("හේතු ඵල දහම", "හේතුවක් නිසා ඵලයක් හටගැනීම", "ඉමස්මිං සති ඉදං හෝති"),
        listOf("අවිද්‍යාව", "අවිජ්ජා", "avidya")
      ),
      officialMarkingScheme = "• න්‍යාය: යමක් ඇති කල්හි යමක් වේ; හේතු නිරෝධයෙන් ඵල නිරෝධ වේ (ලකුණු 1)\n• මුල් හේතුව: අවිද්‍යාව (අවිජ්ජා) සඳහා ලකුණු 1",
      sampleIdealAnswer = "හේතූන් නිසා ඵල හටගන්නා අතර හේතු නැතිවීමෙන් ඵල නැතිවේ. සංසාර චක්‍රයේ මූලික හේතුව අවිද්‍යාවයි."
    ),
    ShortAnswerQuestion(
      id = 278,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "දෙවන ධර්ම සංගායනාව",
      question = "දෙවන ධර්ම සංගායනාව පැවැත්වීමට හේතුව කුමක්ද? එය පැවැත්වූ ස්ථානය සහ දායක රජු කවුද?",
      keyPoints = listOf("දස වස්තුව", "වෛශාලිය සහ කාලාශෝක"),
      synonyms = listOf(
        listOf("දස වස්තුව", "වජ්ජිපුත්තක භික්ෂූන්ගේ දස අකැප වස්තුව"),
        listOf("වෛශාලිය සහ කාලාශෝක", "කාලාශෝක රජු", "වාලුකාරාමය")
      ),
      officialMarkingScheme = "• හේතුව: වජ්ජිපුත්තක භික්ෂූන්ගේ දස අකැප වස්තුව විනය විරෝධී වීම (ලකුණු 1)\n• ස්ථානය/රජු: විශාලා මහනුවර වාලුකාරාමයේදී කාලාශෝක රජුගේ අනුග්‍රහයෙන් (ලකුණු 1)",
      sampleIdealAnswer = "වජ්ජිපුත්තක භික්ෂූන්ගේ දස අකැප වස්තුව හේතුවෙනි. විශාලා මහනුවර වාලුකාරාමයේදී කාලාශෝක රජුගේ දායකත්වයෙන් පැවැත්විණි."
    ),
    ShortAnswerQuestion(
      id = 279,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "තෙවන ධර්ම සංගායනාව",
      question = "තෙවන ධර්ම සංගායනාවේ මූලිකත්වය දැරූ මහ රහතන් වහන්සේ සහ දායක වූ සුප්‍රකට අධිරාජ්‍යයා කවුද?",
      keyPoints = listOf("මොග්ගලීපුත්තතිස්ස හිමි", "ධර්මාශෝක අධිරාජ්‍යයා"),
      synonyms = listOf(
        listOf("මොග්ගලීපුත්තතිස්ස හිමි", "මොග්ගලීපුත්ත තිස්ස මහරහතන් වහන්සේ"),
        listOf("ධර්මාශෝක අධිරාජ්‍යයා", "අශෝක රජු", "ධර්මාශෝක", "ashoka")
      ),
      officialMarkingScheme = "• මූලිකත්වය: මොග්ගලීපුත්තතිස්ස මහරහතන් වහන්සේ සඳහා ලකුණු 1\n• අධිරාජ්‍යයා: ධර්මාශෝක අධිරාජ්‍යයා සඳහා ලකුණු 1",
      sampleIdealAnswer = "මොග්ගලීපුත්තතිස්ස මහරහතන් වහන්සේගේ මූලිකත්වයෙන් හා ධර්මාශෝක අධිරාජ්‍යයාගේ දායකත්වයෙන් පැවැත්විණි."
    ),
    ShortAnswerQuestion(
      id = 280,
      grade = "10",
      setNumber = 8,
      subject = "බුද්ධ ධර්මය (Buddhism)",
      topic = "කඨින පින්කම",
      question = "වසරකට එක් වරක් පමණක් එක් විහාරයක සිදුකළ හැකි උතුම් බෞද්ධ පුණ්‍ය කර්මය කුමක්ද? ඒ සඳහා පූර්විකාව වන විනය කර්මය කුමක්ද?",
      keyPoints = listOf("කඨින චීවර පූජාව", "වස විසීම"),
      synonyms = listOf(
        listOf("කඨින චීවර පූජාව", "කඨින පින්කම", "කඨිනය", "kathina"),
        listOf("වස විසීම", "වස් විසීම", "වස් සමාදන් වීම", "වස් ආරාධනය")
      ),
      officialMarkingScheme = "• පින්කම: කඨින චීවර පූජාව සඳහා ලකුණු 1\n• විනය කර්මය: වස් විසීම (වස් සමාදන් වීම) සඳහා ලකුණු 1",
      sampleIdealAnswer = "කඨින චීවර පූජාවයි. ඒ සඳහා භික්ෂූන් වහන්සේලා පෙරවස් සමාදන් වී වස් විසීම සම්පූර්ණ කළ යුතුය."
    ),

    // -------------------------------------------------------------------------
    // SET 9: සිංහල - වියත් වහර, නිවැරදි ව්‍යාකරණ (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 281,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "කර්ම කාරක වාක්‍ය රීතිය",
      question = "කර්ම කාරක වාක්‍යයක උක්ත වන්නේ කර්මයද කර්තෘද? එහි කර්තෘ පදය තැබිය යුත්තේ කුමන විභක්තියෙන්ද?",
      keyPoints = listOf("කර්මය උක්ත වේ", "තෘතීයා විභක්තියෙන්"),
      synonyms = listOf(
        listOf("කර්මය උක්ත වේ", "කර්මය", "object"),
        listOf("තෘතීයා විභක්තියෙන්", "කරණ විභක්තියෙන්", "විසින් යෙදීම", "තෘතීයා")
      ),
      officialMarkingScheme = "• උක්තය: කර්මය උක්ත වේ සඳහා ලකුණු 1\n• කර්තෘ විභක්තිය: තෘතීයා (කරණ) විභක්තියෙන් ('විසින්' පදය සමග) සඳහා ලකුණු 1",
      sampleIdealAnswer = "කර්ම කාරක වාක්‍යයක කර්මය උක්ත වේ. කර්තෘ පදය තෘතීයා විභක්තියෙන් (විසින් යොදා) තැබිය යුතුය."
    ),
    ShortAnswerQuestion(
      id = 282,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "කාරක පරිවර්තනය",
      question = "'ගොවියෝ කෙත සීසාති' යන කර්තෘ කාරක වාක්‍යය කර්ම කාරකයට පෙරළා ලියන්න.",
      keyPoints = listOf("ගොවීන් විසින්", "කෙත සීසෑරෙයි"),
      synonyms = listOf(
        listOf("ගොවීන් විසින්", "ගොවියන් විසින්"),
        listOf("කෙත සීසෑරෙයි", "කෙත සීසෑම කරනු ලබයි", "සීසෑරේ")
      ),
      officialMarkingScheme = "• ගොවීන් විසින් කෙත සීසෑරෙයි (ලකුණු 2)",
      sampleIdealAnswer = "ගොවීන් විසින් කෙත සීසෑරෙයි."
    ),
    ShortAnswerQuestion(
      id = 283,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "ප්‍රකෘති සහ ප්‍රත්‍ය",
      question = "'නැණවත්' සහ 'කියවීම' යන පදවල ප්‍රකෘතිය සහ ප්‍රත්‍යය වෙන් කර ලියන්න.",
      keyPoints = listOf("නැණ + වත්", "කියව + වීම"),
      synonyms = listOf(
        listOf("නැණ + වත්", "නැණ+වත්"),
        listOf("කියව + වීම", "කියව+වීම", "කියවූ + ම")
      ),
      officialMarkingScheme = "• නැණ (නාම ප්‍රකෘති) + වත් (තද්ධිත ප්‍රත්‍ය) සඳහා ලකුණු 1\n• කියව (ක්‍රියා ප්‍රකෘති) + වීම (කෘදන්ත ප්‍රත්‍ය) සඳහා ලකුණු 1",
      sampleIdealAnswer = "නැණවත් = නැණ + වත් (තද්ධිත). කියවීම = කියව + වීම (කෘදන්ත)."
    ),
    ShortAnswerQuestion(
      id = 284,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "ව්‍යංජන සන්ධි",
      question = "'සත් + දහම් = සදහම්' මෙහි සිදුවී ඇති සන්ධි කාර්යය කුමක්ද? 'අත් + පත් = අත්පත්' හි සන්ධිය කුමක්ද?",
      keyPoints = listOf("පූර්ව ව්‍යංජන ලෝපය", "ප්‍රකෘති සන්ධිය"),
      synonyms = listOf(
        listOf("පූර්ව ව්‍යංජන ලෝපය", "ව්‍යංජන ලෝප", "ලෝප සන්ධිය"),
        listOf("ප්‍රකෘති සන්ධිය", "ප්‍රකෘති", "වෙනස් නොවී පැවතීම")
      ),
      officialMarkingScheme = "• සදහම්: පූර්ව ව්‍යංජන ලෝප සන්ධිය සඳහා ලකුණු 1\n• අත්පත්: ප්‍රකෘති සන්ධිය සඳහා ලකුණු 1",
      sampleIdealAnswer = "'සදහම්' හි පූර්ව ව්‍යංජන ලෝප සන්ධිය ද, 'අත්පත්' හි ප්‍රකෘති සන්ධිය ද සිදුව ඇත."
    ),
    ShortAnswerQuestion(
      id = 285,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "විභක්ති ප්‍රත්‍ය",
      question = "සිංහල භාෂාවේ ප්‍රධාන නාම විභක්ති සංඛ්‍යාව කීයද? 'දරුවාට' යන පදය අයත් විභක්තිය කුමක්ද?",
      keyPoints = listOf("විභක්ති 9", "සම්ප්‍රදාන විභක්තිය"),
      synonyms = listOf(
        listOf("විභක්ති 9", "9 ක්", "නවයකි", "9"),
        listOf("සම්ප්‍රදාන විභක්තිය", "සම්ප්‍රදාන", "චතුර්ථී")
      ),
      officialMarkingScheme = "• විභක්ති ගණන: 9 කි සඳහා ලකුණු 1\n• විභක්තිය: සම්ප්‍රදාන විභක්තිය ('ට' ප්‍රත්‍යය) සඳහා ලකුණු 1",
      sampleIdealAnswer = "විභක්ති 9 ක් ඇත. 'දරුවාට' යනු සම්ප්‍රදාන විභක්තියයි."
    ),
    ShortAnswerQuestion(
      id = 286,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "යූගල පද සහ නිපාත",
      question = "'කඩාවැටෙයි' යනු කුමන පද වර්ගයක්ද? 'ඉදින්', 'නමුත්', 'සහ' යන පද අයත් ව්‍යාකරණ ගණය කුමක්ද?",
      keyPoints = listOf("මිශ්‍ර ක්‍රියා", "නිපාත පද"),
      synonyms = listOf(
        listOf("මිශ්‍ර ක්‍රියා", "යුගල පද", "සංයුක්ත ක්‍රියාව"),
        listOf("නිපාත පද", "නිපාත", "අව්‍යය පද")
      ),
      officialMarkingScheme = "• කඩාවැටෙයි: සංයුක්ත/මිශ්‍ර ක්‍රියාවක් සඳහා ලකුණු 1\n• පද ගණය: නිපාත පද සඳහා ලකුණු 1",
      sampleIdealAnswer = "'කඩාවැටෙයි' යනු මිශ්‍ර/සංයුක්ත ක්‍රියාවකි. අනෙක්වා නිපාත පද ගණයට අයත් වේ."
    ),
    ShortAnswerQuestion(
      id = 287,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "රූඪි සහ ප්‍රස්ථාව පිරුළු",
      question = "'ඉබ්බාගෙන් පිහාටු ඉල්ලනවා වගේ' යන ප්‍රස්ථාව පිරුළේ අර්ථය කුමක්ද? 'අත පිසදා ගැනීම' යන රූඪියේ අර්ථය ලියන්න.",
      keyPoints = listOf("නැති දෙයක් බලාපොරොත්තු වීම", "වගකීමෙන් නිදහස් වීම"),
      synonyms = listOf(
        listOf("නැති දෙයක් බලාපොරොත්තු වීම", "කවදාවත් නොලැබෙන දෙයක් සෙවීම"),
        listOf("වගකීමෙන් නිදහස් වීම", "සම්බන්ධය අත්හැරීම", "පැහැර හැරීම")
      ),
      officialMarkingScheme = "• පිරුළේ අර්ථය: කිසිසේත් සිදුවිය නොහැකි/නැති දෙයක් බලාපොරොත්තු වීම (ලකුණු 1)\n• රූඪියේ අර්ථය: සියලු වගකීම්වලින් සම්පූර්ණයෙන්ම නිදහස් වීම (ලකුණු 1)",
      sampleIdealAnswer = "පිරුළ: නොලැබෙන හෝ නොහැකි දෙයක් බලාපොරොත්තු වීම. රූඪිය: කිසිදු වගකීමක් නැති සේ ඉවත් වීම (වගකීමෙන් නිදහස් වීම)."
    ),
    ShortAnswerQuestion(
      id = 288,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "අලංකාර ශාස්ත්‍රය",
      question = "කාව්‍යයක අර්ථාලංකාරයක් සහ ශබ්දාලංකාරයක් අතර වෙනස දක්වන්න. ශබ්දාලංකාරයකට උදාහරණයක් ලියන්න.",
      keyPoints = listOf("අර්ථයෙන් සහ ශබ්දයෙන් රසය", "එළිසමය"),
      synonyms = listOf(
        listOf("අර්ථයෙන් සහ ශබ්දයෙන් රසය", "අර්ථයේ චමත්කාරය සහ ශබ්ද මාධුර්යය"),
        listOf("එළිසමය", "අනුප්‍රාසය", "යමකය")
      ),
      officialMarkingScheme = "• වෙනස: ශබ්දාලංකාර ශබ්දයේ රිද්මයෙන් රසය මවන අතර අර්ථාලංකාර අරුතේ ගැඹුරින් රසය මවයි (ලකුණු 1)\n• උදාහරණය: අනුප්‍රාසය / එළිසමය සඳහා ලකුණු 1",
      sampleIdealAnswer = "ශබ්දාලංකාර ශබ්දයේ මිහිරියාවෙන්ද, අර්ථාලංකාර අරුතේ චමත්කාරයෙන්ද රසය මවයි. උදා: අනුප්‍රාසය (හෝ එළිසමය)."
    ),
    ShortAnswerQuestion(
      id = 289,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "අක්ෂර වින්‍යාස නීති (ශ, ෂ, ස)",
      question = "පහත වචන දෙක නිවැරදි තාලව්‍ය 'ශ' හෝ මුර්ධජ 'ෂ' යොදා නිවැරදි කරන්න: 1. භාශාව  2. විශේශ",
      keyPoints = listOf("භාෂාව", "විශේෂ"),
      synonyms = listOf(
        listOf("භාෂාව", "භාෂා"),
        listOf("විශේෂ", "විශේෂය")
      ),
      officialMarkingScheme = "• භාෂාව (මූර්ධජ ෂ) සඳහා ලකුණු 1\n• විශේෂ (තාලව්‍ය ශ සහ මූර්ධජ ෂ) සඳහා ලකුණු 1",
      sampleIdealAnswer = "1. භාෂාව (මූර්ධජ ෂ). 2. විශේෂ (තාලව්‍ය ශ සහ මූර්ධජ ෂ)."
    ),
    ShortAnswerQuestion(
      id = 290,
      grade = "10",
      setNumber = 9,
      subject = "සිංහල (Sinhala)",
      topic = "වාක්‍ය වර්ග",
      question = "කේවල වාක්‍යයක්, මිශ්‍ර වාක්‍යයක්, සහ සංයුක්ත වාක්‍යයක් හඳුනාගන්නා ප්‍රධාන නිර්ණායකය කුමක්ද?",
      keyPoints = listOf("සමාප්ත ක්‍රියා සංඛ්‍යාව", "උප වාක්‍ය"),
      synonyms = listOf(
        listOf("සමාප්ත ක්‍රියා සංඛ්‍යාව", "ප්‍රධාන ආඛ්‍යාතය", "අවසන් ක්‍රියාව"),
        listOf("උප වාක්‍ය", "ස්වාධීන වාක්‍ය එකතුවීම", "අසමාප්ත ක්‍රියා")
      ),
      officialMarkingScheme = "• කේවල: එක් ප්‍රධාන ආඛ්‍යාතයක් පමණක් තිබීම (ලකුණු 1)\n• සංයුක්ත/මිශ්‍ර: ස්වාධීන වාක්‍ය කිහිපයක් හෝ උප වාක්‍ය සම්බන්ධ වී තිබීම (ලකුණු 1)",
      sampleIdealAnswer = "කේවල වාක්‍යයක ඇත්තේ එක් සමාප්ත ක්‍රියාවක් පමණි. සංයුක්ත හා මිශ්‍ර වාක්‍යවල ප්‍රධාන සහ උප වාක්‍ය කිහිපයක් සම්බන්ධ වේ."
    ),

    // -------------------------------------------------------------------------
    // SET 10: ICT - තර්ක ද්වාර සහ දත්ත සන්නිවේදනය (Grade 10)
    // -------------------------------------------------------------------------
    ShortAnswerQuestion(
      id = 291,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "මූලික තර්ක ද්වාර (Logic Gates)",
      question = "මූලික තර්ක ද්වාර 3 නම් කරන්න. සියලු ආදාන 1 වන විට පමණක් ප්‍රතිදානය 1 වන ද්වාරය කුමක්ද?",
      keyPoints = listOf("AND OR NOT", "AND ද්වාරය"),
      synonyms = listOf(
        listOf("and or not", "and, or, not"),
        listOf("and ද්වාරය", "and gate", "ඇන්ඩ් ද්වාරය")
      ),
      officialMarkingScheme = "• මූලික ද්වාර 3: AND, OR, NOT (ලකුණු 1)\n• ද්වාරය: AND ද්වාරය (ලකුණු 1)",
      sampleIdealAnswer = "AND, OR, NOT මූලික ද්වාර වේ. සියලු ආදාන 1 වන විට පමණක් ප්‍රතිදානය 1 වන්නේ AND ද්වාරයේය."
    ),
    ShortAnswerQuestion(
      id = 292,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "OR සහ NOT ද්වාර",
      question = "OR ද්වාරයක ප්‍රතිදානය 0 වන්නේ කුමන අවස්ථාවේදීද? NOT ද්වාරයක ආදානය 0 වූ විට ප්‍රතිදානය කුමක්ද?",
      keyPoints = listOf("සියලු ආදාන 0 වන විට", "1"),
      synonyms = listOf(
        listOf("සියලු ආදාන 0 වන විට", "ආදාන දෙකම 0 වූ විට", "0 සහ 0 වූ විට"),
        listOf("1", "එක", "one", "true")
      ),
      officialMarkingScheme = "• OR ද්වාරය: සියලු ආදාන 0 වන විට පමණක් ප්‍රතිදානය 0 වේ (ලකුණු 1)\n• NOT ද්වාරය: ප්‍රතිදානය 1 වේ (ලකුණු 1)",
      sampleIdealAnswer = "සියලු ආදාන 0 වන විට OR ද්වාරයේ ප්‍රතිදානය 0 වේ. NOT ද්වාරයේ ආදානය 0 වූ විට ප්‍රතිදානය 1 වේ."
    ),
    ShortAnswerQuestion(
      id = 293,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "සංයුක්ත ද්වාර (NAND සහ NOR)",
      question = "NAND ද්වාරයක් නිර්මාණය කරන්නේ කුමන ද්වාර 2ක් එකතු කිරීමෙන්ද? සර්වත්‍ර ද්වාර (Universal gates) ලෙස හඳුන්වන්නේ මොනවාද?",
      keyPoints = listOf("AND සහ NOT", "NAND සහ NOR"),
      synonyms = listOf(
        listOf("and සහ not", "and + not", "ඇන්ඩ් සහ නොට්"),
        listOf("nand සහ nor", "nand, nor", "නෑන්ඩ් සහ නෝර්")
      ),
      officialMarkingScheme = "• NAND සෑදීම: AND ද්වාරයක ප්‍රතිදානයට NOT ද්වාරයක් සම්බන්ධ කිරීමෙන් (ලකුණු 1)\n• සර්වත්‍ර ද්වාර: NAND සහ NOR ද්වාර (ලකුණු 1)",
      sampleIdealAnswer = "AND සහ NOT ද්වාර එකතු කිරීමෙනි. සර්වත්‍ර ද්වාර වන්නේ NAND සහ NOR ද්වාරයි."
    ),
    ShortAnswerQuestion(
      id = 294,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "ජාල වර්ග (LAN, WAN)",
      question = "LAN සහ WAN යන්නෙහි සම්පූර්ණ ඉංග්‍රීසි නාම ලියන්න.",
      keyPoints = listOf("Local Area Network", "Wide Area Network"),
      synonyms = listOf(
        listOf("local area network", "local area network"),
        listOf("wide area network", "wide area network")
      ),
      officialMarkingScheme = "• LAN: Local Area Network සඳහා ලකුණු 1\n• WAN: Wide Area Network සඳහා ලකුණු 1",
      sampleIdealAnswer = "LAN = Local Area Network. WAN = Wide Area Network."
    ),
    ShortAnswerQuestion(
      id = 295,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "ජාල ස්ථලක (Network Topologies)",
      question = "මධ්‍යගත උපාංගයක් (Switch/Hub) භාවිත කර පරිගණක සම්බන්ධ කරන ජාල ස්ථලකය කුමක්ද? බස් (Bus) ස්ථලකයේ ප්‍රධාන දුර්වලතාවක් ලියන්න.",
      keyPoints = listOf("තාරකා ස්ථලකය", "ප්‍රධාන රැහැන බිඳවැටුණහොත් මුළු ජාලයම අක්‍රිය වීම"),
      synonyms = listOf(
        listOf("තාරකා ස්ථලකය", "star topology", "ස්ටාර් ස්ථලකය"),
        listOf("ප්‍රධාන රැහැන බිඳවැටුණහොත් මුළු ජාලයම අක්‍රිය වීම", "බැක්බෝන් කේබල් කැඩීම", "තනි රැහැන මත යැපීම")
      ),
      officialMarkingScheme = "• ස්ථලකය: තාරකා ස්ථලකය (Star topology) සඳහා ලකුණු 1\n• දුර්වලතාව: ප්‍රධාන කොඳුනාරටි රැහැන (Backbone cable) බිඳවැටුණහොත් මුළු ජාලයම අක්‍රිය වීම (ලකුණු 1)",
      sampleIdealAnswer = "තාරකා (Star) ස්ථලකයයි. Bus ස්ථලකයේ ප්‍රධාන රැහැනට හානි වුවහොත් මුළු ජාලයම සම්පූර්ණයෙන් ඇනහිටී."
    ),
    ShortAnswerQuestion(
      id = 296,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "සන්නිවේදන මාධ්‍ය",
      question = "අධිවේගී ආලෝක සංඥා මඟින් දත්ත සම්ප්‍රේෂණය කරන කේබල් වර්ගය කුමක්ද? මඟපෙන්වන ලද නොවන (නිරාවරිත) මාධ්‍යයකට උදාහරණයක් ලියන්න.",
      keyPoints = listOf("ප්‍රකාශ තන්තු", "Wi-Fi"),
      synonyms = listOf(
        listOf("ප්‍රකාශ තන්තු", "ඔප්ටිකල් ෆයිබර්", "optical fiber", "fiber optic"),
        listOf("wi-fi", "බ්ලූටූත්", "රේඩියෝ තරංග", "ක්ෂුද්‍ර තරංග", "wifi", "bluetooth")
      ),
      officialMarkingScheme = "• කේබල් වර්ගය: ප්‍රකාශ තන්තු (Fiber Optic Cable) සඳහා ලකුණු 1\n• නිරාවරිත මාධ්‍යය: Wi-Fi / බ්ලූටූත් / රේඩියෝ තරංග සඳහා ලකුණු 1",
      sampleIdealAnswer = "ප්‍රකාශ තන්තු (Optical Fiber) වේ. නිරාවරිත මාධ්‍යයකට උදාහරණයක් ලෙස Wi-Fi (හෝ රේඩියෝ තරංග) දැක්විය හැක."
    ),
    ShortAnswerQuestion(
      id = 297,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "IP ලිපිනය",
      question = "IPv4 ලිපිනයක අඩංගු බිටු සංඛ්‍යාව කීයද? IPv4 ලිපිනයකට උදාහරණයක් ලියන්න.",
      keyPoints = listOf("32 බිටු", "192.168.1.1"),
      synonyms = listOf(
        listOf("32 බිටු", "32 bits", "32"),
        listOf("192.168.1.1", "192.168", "10.0.0.1", "172.16.0.1")
      ),
      officialMarkingScheme = "• බිටු ගණන: 32 බිටු (බයිට් 4) සඳහා ලකුණු 1\n• උදාහරණය: 192.168.1.1 (හෝ ඕනෑම වලංගු IPv4 ලිපිනයක්) සඳහා ලකුණු 1",
      sampleIdealAnswer = "බිටු 32 කි. උදාහරණයක්: 192.168.1.1."
    ),
    ShortAnswerQuestion(
      id = 298,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "දත්ත සමුදාය (Database)",
      question = "සම්බන්ධතා දත්ත සමුදායක (RDBMS) ප්‍රාථමික යතුරක් (Primary Key) යොදාගන්නේ කුමන අරමුණක් සඳහාද?",
      keyPoints = listOf("වාර්තාවක් අනන්‍යව හඳුනාගැනීම", "අනන්‍යතාව"),
      synonyms = listOf(
        listOf("වාර්තාවක් අනන්‍යව හඳුනාගැනීම", "අනන්‍යව හඳුනාගැනීමට", "unique identification"),
        listOf("අනන්‍යතාව", "නැවත සිදු නොවීම")
      ),
      officialMarkingScheme = "• දත්ත සමුදා වගුවක සෑම වාර්තාවක්ම (Record/Row) අනන්‍යව හඳුනාගැනීම සඳහා (ලකුණු 2)",
      sampleIdealAnswer = "වගුවක ඇති සෑම ලේඛනයක්ම (Record එකක්ම) අනන්‍යව හඳුනාගැනීම සඳහා ප්‍රාථමික යතුර (Primary Key) යොදාගනී."
    ),
    ShortAnswerQuestion(
      id = 299,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "දත්ත සමුදා ක්ෂේත්‍ර සහ වාර්තා",
      question = "වගුවක ඇති තිරස් පේළි (Rows) සහ සිරස් තීරු (Columns) දත්ත සමුදා විද්‍යාවේදී හඳුන්වන නම් ලියන්න.",
      keyPoints = listOf("වාර්තා", "ක්ෂේත්‍ර"),
      synonyms = listOf(
        listOf("වාර්තා", "records", "tuples"),
        listOf("ක්ෂේත්‍ර", "fields", "attributes")
      ),
      officialMarkingScheme = "• තිරස් පේළි: වාර්තා (Records / Tuples) සඳහා ලකුණු 1\n• සිරස් තීරු: ක්ෂේත්‍ර (Fields / Attributes) සඳහා ලකුණු 1",
      sampleIdealAnswer = "තිරස් පේළි වාර්තා (Records) ලෙසද, සිරස් තීරු ක්ෂේත්‍ර (Fields) ලෙසද හැඳින්වේ."
    ),
    ShortAnswerQuestion(
      id = 300,
      grade = "10",
      setNumber = 10,
      subject = "ICT",
      topic = "තොරතුරු ආරක්ෂාව",
      question = "අනවසරයෙන් පරිගණක පද්ධතියකට ඇතුළු වීම වැළැක්වීමට දෘඩාංග හෝ මෘදුකාංග මට්ටමින් යොදන ආරක්ෂක පවුර කුමක්ද? මුරපදයක් (Password) ශක්තිමත් කිරීමට අනුගමනය කළ හැකි ක්‍රමයක් ලියන්න.",
      keyPoints = listOf("ෆයර්වෝල්", "විශේෂ අක්ෂර සහ අංක"),
      synonyms = listOf(
        listOf("ෆයර්වෝල්", "firewall", "ගිනි පවුර"),
        listOf("විශේෂ අක්ෂර සහ අංක", "දිගු මුරපදයක්", "අකුරු හා සංකේත මිශ්‍ර කිරීම")
      ),
      officialMarkingScheme = "• ආරක්ෂක පවුර: ෆයර්වෝල් (Firewall) සඳහා ලකුණු 1\n• ශක්තිමත් මුරපදයක්: කැපිටල්/සිම්පල් අකුරු, අංක සහ විශේෂ සංකේත මිශ්‍ර කර අක්ෂර 8 කට වඩා යෙදීම (ලකුණු 1)",
      sampleIdealAnswer = "Firewall (ෆයර්වෝල්) වේ. අකුරු, අංක සහ විශේෂ සංකේත (@#$) මිශ්‍ර කර දිගු මුරපදයක් සැකසීමෙන් එය ශක්තිමත් කළ හැක."
    )
  )

  fun getQuestionsForSet(setNum: Int): List<ShortAnswerQuestion> {
    return questions.filter { it.setNumber == setNum }
  }
}
