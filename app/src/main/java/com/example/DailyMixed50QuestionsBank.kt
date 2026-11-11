package com.example

data class DailyMixedQuestion(
  val id: Int,
  val subject: String,
  val question: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: String
)

object DailyMixed50QuestionsBank {

  val pool50: List<DailyMixedQuestion> = listOf(
    // --- SCIENCE (1 - 5) ---
    DailyMixedQuestion(
      id = 1,
      subject = "විද්‍යාව (ජීව විද්‍යාව)",
      question = "ශාක සෛලයක සත්ත්ව සෛලවල දක්නට නොලැබෙන සෛලීය ඉන්ද්‍රයිකාව කුමක්ද?",
      options = listOf("මයිටොකොන්ඩ්‍රියා", "හරිතලව", "රයිබොසෝම", "න්‍යෂ්ටිය"),
      correctIndex = 1,
      explanation = "හරිතලව සහ සෙලියුලෝස් සෛල බිත්තිය ශාක සෛලවලට පමණක් ආවේණික වන අතර ප්‍රභාසංස්ලේෂණය සිදු කරයි."
    ),
    DailyMixedQuestion(
      id = 2,
      subject = "විද්‍යාව (රසායන විද්‍යාව)",
      question = "සෝඩියම් පරමාණුවේ (₁₁Na) ඉලෙක්ට්‍රෝන වින්‍යාසය නිවැරදිව දක්වා ඇත්තේ කුමක්ද?",
      options = listOf("2, 8, 1", "2, 8, 8, 1", "2, 9", "1, 8, 2"),
      correctIndex = 0,
      explanation = "පළමු කවචයේ උපරිමය 2 ද, දෙවන කවචයේ 8 ද වන බැවින් 11 වන ඉලෙක්ට්‍රෝනය තෙවන කවචයට යයි (2, 8, 1)."
    ),
    DailyMixedQuestion(
      id = 3,
      subject = "විද්‍යාව (භෞතික විද්‍යාව)",
      question = "5 kg ස්කන්ධයක් සහිත වස්තුවක් මත 20 N බලයක් යෙදූ විට ඇතිවන ත්වරණය කොපමණද?",
      options = listOf("100 ms⁻²", "4 ms⁻²", "15 ms⁻²", "0.25 ms⁻²"),
      correctIndex = 1,
      explanation = "F = ma සූත්‍රය අනුව: a = F / m = 20 N / 5 kg = 4 ms⁻² වේ."
    ),
    DailyMixedQuestion(
      id = 4,
      subject = "විද්‍යාව (විදුලිය)",
      question = "12 V විභව අන්තරයකට සම්බන්ධ කළ 4 Ω ප්‍රතිරෝධකයක් තුළින් ගලන ධාරාව කුමක්ද?",
      options = listOf("48 A", "3 A", "16 A", "0.33 A"),
      correctIndex = 1,
      explanation = "ඕම් නියමය V = IR අනුව: I = V / R = 12 V / 4 Ω = 3 A වේ."
    ),
    DailyMixedQuestion(
      id = 5,
      subject = "විද්‍යාව (ප්‍රවේණිය)",
      question = "මිනිස් දේහ සෛලයක අඩංගු මුළු වර්ණදේහ යුගල ගණන කීයද?",
      options = listOf("46", "23", "22", "44"),
      correctIndex = 1,
      explanation = "මිනිස් සෛලයක මුළු වර්ණදේහ 46ක් හෙවත් වර්ණදේහ යුගල 23ක් (ලිංගික වර්ණදේහ යුගල 1ක් සහ දේහ වර්ණදේහ යුගල 22ක්) ඇත."
    ),

    // --- MATHEMATICS (6 - 10) ---
    DailyMixedQuestion(
      id = 6,
      subject = "ගණිතය (වීජ ගණිතය)",
      question = "x² - 25 හි සාධක දෙක මොනවාද?",
      options = listOf("(x - 5)(x - 5)", "(x - 5)(x + 5)", "(x + 25)(x - 1)", "(x - 25)(x + 25)"),
      correctIndex = 1,
      explanation = "වර්ග දෙකක අන්තරය: a² - b² = (a - b)(a + b) අනුව x² - 5² = (x - 5)(x + 5) වේ."
    ),
    DailyMixedQuestion(
      id = 7,
      subject = "ගණිතය (ත්‍රිකෝණමිතිය)",
      question = "සෘජුකෝණී ත්‍රිකෝණයක tan θ අර්ථ දක්වන්නේ කුමන පාද අනුපාතයෙන්ද?",
      options = listOf("සම්මුඛ පාදය / කර්ණය", "බද්ධ පාදය / කර්ණය", "සම්මුඛ පාදය / බද්ධ පාදය", "කර්ණය / සම්මුඛ පාදය"),
      correctIndex = 2,
      explanation = "tan θ = සම්මුඛ පාදය / බද්ධ පාදය (Opposite / Adjacent) වේ."
    ),
    DailyMixedQuestion(
      id = 8,
      subject = "ගණිතය (ජ්‍යාමිතිය)",
      question = "වෘත්තයක කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලද ලම්භය මඟින් ජ්‍යාය කුමක් කරන්නේද?",
      options = listOf("සමච්ඡේද කරයි (දෙකට බෙදයි)", "වර්ග කරයි", "ත්‍රිකෝණයක් සාදයි", "ද්විගුණ කරයි"),
      correctIndex = 0,
      explanation = "වෘත්ත ජ්‍යා ප්‍රමේයය අනුව: කේන්ද්‍රයේ සිට ජ්‍යායකට ලම්භය මඟින් ජ්‍යාය සමච්ඡේද වේ."
    ),
    DailyMixedQuestion(
      id = 9,
      subject = "ගණිතය (සංඛ්‍යානය)",
      question = "3, 5, 7, 7, 8, 9, 12 යන දත්ත සමූහයේ මාතය (Mode) කුමක්ද?",
      options = listOf("7", "8", "3", "7.28"),
      correctIndex = 0,
      explanation = "වැඩිම වාර ගණනක් (2 වරක්) පුනරාවර්තනය වන අගය මාතය වේ, එනම් 7 යි."
    ),
    DailyMixedQuestion(
      id = 10,
      subject = "ගණිතය (ශ්‍රේඪි)",
      question = "3, 7, 11, 15... සමාන්තර ශ්‍රේඪියේ 10 වන පදය කුමක්ද?",
      options = listOf("39", "43", "40", "36"),
      correctIndex = 0,
      explanation = "T_n = a + (n - 1)d අනුව: a = 3, d = 4. T_10 = 3 + (9 × 4) = 3 + 36 = 39 වේ."
    ),

    // --- HISTORY (11 - 15) ---
    DailyMixedQuestion(
      id = 11,
      subject = "ඉතිහාසය (අනුරාධපුර යුගය)",
      question = "ශ්‍රී ලංකාව එක්සේසත් කර රුවන්වැලි මහා සෑය ඉදිකළ අසහාය නරපතියා කවුද?",
      options = listOf("ධාතුසේන රජු", "දුටුගැමුණු රජු", "මහාසේන රජු", "දේවානම්පියතිස්ස රජු"),
      correctIndex = 1,
      explanation = "දුටුගැමුණු රජතුමා (ක්‍රි.පූ. 161 - 137) ලක්දිව එක්සේසත් කර රුවන්වැලි සෑය හා ලෝවාමහාපාය ඉදිකළේය."
    ),
    DailyMixedQuestion(
      id = 12,
      subject = "ඉතිහාසය (වාරි ශිෂ්ටාචාරය)",
      question = "කලා වැව සහ සැතපුම් 54ක් දිග ජය ගඟ (යෝධ ඇළ) නිර්මාණය කළ රජු කවුද?",
      options = listOf("වසභ රජු", "ධාතුසේන රජු", "පරාක්‍රමබාහු රජු", "අග්බෝ II රජු"),
      correctIndex = 1,
      explanation = "ධාතුසේන රජතුමා (ක්‍රි.ව. 5 වන සියවස) කලා වැව කරවා තිසා වැව දක්වා ජලය ගෙන යාමට ජය ගඟ තැනීය."
    ),
    DailyMixedQuestion(
      id = 13,
      subject = "ඉතිහාසය (පොළොන්නරු යුගය)",
      question = "\"අහසින් වැටෙන එකදු දිය බිඳක්වත් මුහුදට නොයැවිය යුතුය\" යන උදාර සංකල්පය කාගේද?",
      options = listOf("මහා පරාක්‍රමබාහු රජු", "විජයබාහු I රජු", "නිශ්ශංකමල්ල රජු", "කීර්ති ශ්‍රී රාජසිංහ රජු"),
      correctIndex = 0,
      explanation = "මහා පරාක්‍රමබාහු රජතුමා පොළොන්නරුවේදී පරාක්‍රම සමුද්‍රය ඇතුළු මහා වාරි කර්මාන්ත රැසක් කරවමින් මෙම ප්‍රකාශය කළේය."
    ),
    DailyMixedQuestion(
      id = 14,
      subject = "ඉතිහාසය (යටත්විජිත යුගය)",
      question = "1818 ඌව වෙල්ලස්ස නිදහස් අරගලයට නායකත්වය දුන් ජාතික වීරවරයා කවුද?",
      options = listOf("වීර පුරන් අප්පු", "මොනරවිල කැප්පෙටිපොළ දිසාව", "ගොංගාලේගොඩ බණ්ඩා", "ඇහැලේපොළ නිලමේ"),
      correctIndex = 1,
      explanation = "මොනරවිල කැප්පෙටිපොළ මහා දිසාව 1818 වෙල්ලස්ස විමුක්ති අරගලයට නායකත්වය දුන්නේය."
    ),
    DailyMixedQuestion(
      id = 15,
      subject = "ඉතිහාසය (නූතන යුගය)",
      question = "ශ්‍රී ලංකාවට බ්‍රිතාන්‍යයෙන් පූර්ණ නිදහස හිමිවූ දිනය කුමක්ද?",
      options = listOf("1948 පෙබරවාරි 04", "1972 මැයි 22", "1978 සැප්තැම්බර් 07", "1931 ජූලි 07"),
      correctIndex = 0,
      explanation = "1948 පෙබරවාරි 04 දින සෝල්බරි ආණ්ඩුක්‍රමය යටතේ ලංකාවට ඩොමීනියන් නිදහස හිමිවිය. ප්‍රථම අගමැති ඩී.එස්. සේනානායක මහතාය."
    ),

    // --- BUDDHISM (16 - 20) ---
    DailyMixedQuestion(
      id = 16,
      subject = "බුද්ධ ධර්මය (සූත්‍ර ධර්ම)",
      question = "බුදුරජාණන් වහන්සේගේ ප්‍රථම ධර්ම දේශනාව කුමක්ද?",
      options = listOf("අනත්තලක්ඛණ සූත්‍රය", "ධම්මචක්කප්පවත්තන සූත්‍රය", "ආදිත්තපරියාය සූත්‍රය", "මහා මංගල සූත්‍රය"),
      correctIndex = 1,
      explanation = "ඇසළ පුන් පොහෝ දින බරණැස ඉසිපතන මිගදායේදී පස්වග තවුසන්ට ධම්මචක්කප්පවත්තන සූත්‍රය දේශනා කරන ලදී."
    ),
    DailyMixedQuestion(
      id = 17,
      subject = "බුද්ධ ධර්මය (චතුරාර්ය සත්‍යය)",
      question = "දුක්ඛ නිරෝධ ගාමිණී පටිපදා ආර්ය සත්‍යය ලෙස හඳුන්වන්නේ කුමක්ද?",
      options = listOf("දුක්ඛ ආර්ය සත්‍යය", "ආර්ය අෂ්ටාංගික මාර්ගය", "කර්ම න්‍යාය", "පටිච්චසමුප්පාදය"),
      correctIndex = 1,
      explanation = "දුක නැති කිරීමේ මාර්ගය ආර්ය අෂ්ටාංගික මාර්ගය (මධ්‍යම ප්‍රතිපදාව) වේ."
    ),
    DailyMixedQuestion(
      id = 18,
      subject = "බුද්ධ ධර්මය (ශාසන ඉතිහාසය)",
      question = "ප්‍රථම ධර්ම සංගායනාවේ මූලාසනය හෙබවූ මහරහතන් වහන්සේ කවුද?",
      options = listOf("ආනන්ද හිමි", "මහා කාශ්‍යප මහරහතන් වහන්සේ", "උපාලි හිමි", "සැරියුත් හිමි"),
      correctIndex = 1,
      explanation = "බුදුරදුන් පිරිනිවන් පා තෙමසකට පසු රජගහනුවර සප්තපර්ණී ලෙන් දොරකඩදී මහා කාශ්‍යප හිමියන්ගේ ප්‍රධානත්වයෙන් පැවැත්විණි."
    ),
    DailyMixedQuestion(
      id = 19,
      subject = "බුද්ධ ධර්මය (ත්‍රිපිටකය)",
      question = "ත්‍රිපිටකයේ විනය පිටකයට අයත් ග්‍රන්ථ සංඛ්‍යාව කීයද?",
      options = listOf("3", "5", "7", "15"),
      correctIndex = 1,
      explanation = "විනය පිටකයට ග්‍රන්ථ 5කි: පාරාජිකා, පාචිත්තිය, මහාවග්ග, චුල්ලවග්ග, පරිවාර."
    ),
    DailyMixedQuestion(
      id = 20,
      subject = "බුද්ධ ධර්මය (සමාජ දර්ශනය)",
      question = "සිඟාලෝවාද සූත්‍රයේ 'දකුණු දිශාව' මඟින් සංකේතවත් කරන්නේ කවුරුන්ද?",
      options = listOf("මවුපියන්", "ගුරුවරුන්", "අඹුසැමියන්", "මිත්‍රයන්"),
      correctIndex = 1,
      explanation = "නැගෙනහිර=මවුපියන්, දකුණ=ගුරුවරුන්, බටහිර=අඹුසැමියන්, උතුර=මිතුරන්, යට=සේවකයන්, උඩ=පැවිද්දන්."
    ),

    // --- SINHALA (21 - 25) ---
    DailyMixedQuestion(
      id = 21,
      subject = "සිංහල (ව්‍යාකරණ - සන්ධි)",
      question = "\"ගුරු + උපදේශ = ගුරුපදේශ\" මෙහි සිදුවී ඇති සන්ධිය කුමක්ද?",
      options = listOf("පූර්ව ස්වර ලෝප සන්ධිය", "පර ස්වර ලෝප සන්ධිය", "ස්වරාදේශ සන්ධිය", "ආගම සන්ධිය"),
      correctIndex = 0,
      explanation = "ගුරු (උ) + උපදේශ (උ) හි මුල් පදයේ අග ස්වරය (උ) ලොප් වී පර ස්වරය එක්වීමෙන් ගුරුපදේශ සෑදේ."
    ),
    DailyMixedQuestion(
      id = 22,
      subject = "සිංහල (විභක්ති)",
      question = "\"සිසුවා පාසලට යයි\" වාක්‍යයේ 'පාසලට' යන්නෙහි විභක්තිය කුමක්ද?",
      options = listOf("කර්තෘ විභක්තිය", "කර්ම විභක්තිය", "සම්ප්‍රදාන විභක්තිය", "අවධි විභක්තිය"),
      correctIndex = 2,
      explanation = "'ට' ප්‍රත්‍යය යෙදෙන්නේ සම්ප්‍රදාන විභක්තියටයි (යමක් දීම හෝ යාම සඳහා)."
    ),
    DailyMixedQuestion(
      id = 23,
      subject = "සිංහල (සාහිත්‍යය)",
      question = "කෝට්ටේ යුගයේ රචිත 'සැළලිහිණි සන්දේශයේ' කතුවරයා කවුද?",
      options = listOf("වෑත්තෑවේ හිමි", "තොටගමුවේ ශ්‍රී රාහුල හිමි", "විදුරගම මෛත්‍රෙය හිමි", "ගුරුළුගෝමී"),
      correctIndex = 1,
      explanation = "තොටගමුවේ ශ්‍රී රාහුල හිමියන් විසින් VI වන පරාක්‍රමබාහු රජ සමයේදී උලකුඩය දේවියට පුත් කුමරකු පතා සැළලිහිණි සන්දේශය ලියන ලදී."
    ),
    DailyMixedQuestion(
      id = 24,
      subject = "සිංහල (ප්‍රස්ථාව පිරුළු)",
      question = "\"ඉඟුරු දී මිරිස් ගත්තා වගේ\" යන ප්‍රස්ථාව පිරුළේ නිවැරදි අර්ථය කුමක්ද?",
      options = listOf("අඩුපාඩුවක් පිරිමසා ගැනීම", "එක් කරදරයකින් මිදී ඊටත් වඩා විශාල කරදරයකට පත්වීම", "ලාභයක් ලැබීම", "වෙළඳාමෙන් ජය ගැනීම"),
      correctIndex = 1,
      explanation = "පෘතුගීසීන් එළවා ලන්දේසීන් ගෙන්වා ගැනීම පිළිබඳවද ජන වහරේ මෙම කියමන යෙදිණි."
    ),
    DailyMixedQuestion(
      id = 25,
      subject = "සිංහල (අක්ෂර වින්‍යාසය)",
      question = "පහත සඳහන් වචන අතුරින් නිවැරදි අක්ෂර වින්‍යාසය සහිත වචනය තෝරන්න:",
      options = listOf("ප්‍රතිශක්තිය", "ප්‍රතිශක්ථිය", "ප්‍රතීශක්තිය", "ප්‍රතිශක්ති"),
      correctIndex = 0,
      explanation = "නිවැරදි සම්මත අක්ෂර වින්‍යාසය 'ප්‍රතිශක්තිය' වේ (කෙටි ඉ-කාර සහිතව)."
    ),

    // --- ENGLISH (26 - 30) ---
    DailyMixedQuestion(
      id = 26,
      subject = "English (Tenses)",
      question = "Identify the correct form: \"By the time the teacher arrived, the students ______ the test.\"",
      options = listOf("completed", "had completed", "have completed", "will complete"),
      correctIndex = 1,
      explanation = "We use the Past Perfect tense (had completed) for an action that happened before another past action."
    ),
    DailyMixedQuestion(
      id = 27,
      subject = "English (Passive Voice)",
      question = "Transform into passive: \"Shakespeare wrote Hamlet.\"",
      options = listOf("Hamlet is written by Shakespeare.", "Hamlet was written by Shakespeare.", "Hamlet has written by Shakespeare.", "Hamlet had written by Shakespeare."),
      correctIndex = 1,
      explanation = "Past Simple passive requires 'was/were + past participle' -> 'Hamlet was written by Shakespeare'."
    ),
    DailyMixedQuestion(
      id = 28,
      subject = "English (Prepositions)",
      question = "Fill in the blank: \"She is very interested ______ learning classical music.\"",
      options = listOf("at", "on", "in", "with"),
      correctIndex = 2,
      explanation = "The adjective 'interested' is always followed by the preposition 'in'."
    ),
    DailyMixedQuestion(
      id = 29,
      subject = "English (Conditionals)",
      question = "Complete the sentence: \"If you study consistently, you ______ good marks.\"",
      options = listOf("would get", "will get", "got", "would have got"),
      correctIndex = 1,
      explanation = "First Conditional: If + Present Simple (study) -> will + base verb (will get)."
    ),
    DailyMixedQuestion(
      id = 30,
      subject = "English (Vocabulary)",
      question = "What is the synonym of the word 'ABUNDANT'?",
      options = listOf("Scarce", "Plentiful", "Tiny", "Fragile"),
      correctIndex = 1,
      explanation = "'Abundant' means existing or available in large quantities; plentiful."
    ),

    // --- ICT (31 - 35) ---
    DailyMixedQuestion(
      id = 31,
      subject = "ICT (දත්ත නිරූපණය)",
      question = "දශමය 10 හි ද්විමය (Binary) නිරූපණය කුමක්ද?",
      options = listOf("1010₂", "1100₂", "1001₂", "1110₂"),
      correctIndex = 0,
      explanation = "10 = 8 + 2 = (1×2³) + (0×2²) + (1×2¹) + (0×2⁰) = 1010₂ වේ."
    ),
    DailyMixedQuestion(
      id = 32,
      subject = "ICT (තාර්කික ද්වාර)",
      question = "ආදාන දෙකම 1 වූ විට පමණක් ප්‍රතිදානය 1 වන ද්වාරය කුමක්ද?",
      options = listOf("OR Gate", "AND Gate", "NOT Gate", "NOR Gate"),
      correctIndex = 1,
      explanation = "AND ද්වාරයේ බූලියානු ප්‍රකාශනය Y = A · B වේ. ආදාන සියල්ල 1 වූ විට පමණක් ප්‍රතිදානය 1 වේ."
    ),
    DailyMixedQuestion(
      id = 33,
      subject = "ICT (පැතුරුම්පත්)",
      question = "පැතුරුම්පතක A1 සිට A10 දක්වා කොටුවල සාමාන්‍යය (මධ්‍යන්‍යය) සෙවීමට නිවැරදි ශ්‍රිතය කුමක්ද?",
      options = listOf("=TOTAL(A1:A10)", "=AVERAGE(A1:A10)", "=MEAN(A1:A10)", "=COUNT(A1:A10)"),
      correctIndex = 1,
      explanation = "Excel/Calc හි මධ්‍යන්‍යය ගණනය කිරීම සඳහා =AVERAGE(...) සම්මත ශ්‍රිතය යොදයි."
    ),
    DailyMixedQuestion(
      id = 34,
      subject = "ICT (දත්ත සමුදාය)",
      question = "වගුවක සෑම පේළියක්ම (Record) අනන්‍යව හඳුනාගැනීමට යොදාගන්නා යතුර කුමක්ද?",
      options = listOf("විදේශ යතුර (Foreign Key)", "ප්‍රාථමික යතුර (Primary Key)", "ද්විතීයික යතුර", "සංයුක්ත යතුර"),
      correctIndex = 1,
      explanation = "ප්‍රාථමික යතුරක් (Primary Key) අගය කිසිවිටෙක හිස් (Null) විය නොහැකි අතර අගයන් පුනරාවර්තනය නොවේ."
    ),
    DailyMixedQuestion(
      id = 35,
      subject = "ICT (පරිගණක ජාල)",
      question = "පරිගණකයකට හෝ ජාල උපාංගයකට අනන්‍යව පවරන භෞතික ලිපිනය කුමක්ද?",
      options = listOf("IP Address", "MAC Address", "URL", "DNS"),
      correctIndex = 1,
      explanation = "MAC (Media Access Control) ලිපිනය ජාල කාඩ්පත (NIC) නිෂ්පාදනයේදී ස්ථිරවම සටහන් කරන 48-bit භෞතික ලිපිනයයි."
    ),

    // --- COMMERCE (36 - 40) ---
    DailyMixedQuestion(
      id = 36,
      subject = "වාණිජ (ගිණුම්කරණය)",
      question = "මූලික ගිණුම්කරණ සමීකරණය කුමක්ද?",
      options = listOf("වත්කම් = වගකීම් - හිමිකම", "වත්කම් = වගකීම් + හිමිකම", "හිමිකම = වත්කම් + වගකීම්", "ලාභය = ආදායම් + වියදම්"),
      correctIndex = 1,
      explanation = "Assets = Liabilities + Equity (A = L + E). මෙය ද්විත්ව සටහන් පද්ධතියේ පදනමයි."
    ),
    DailyMixedQuestion(
      id = 37,
      subject = "වාණිජ (ද්විත්ව සටහන්)",
      question = "හිමිකරු ව්‍යාපාරයට රු. 50,000 ක මුදල් ප්‍රාග්ධනයක් යෙදවූ විට නිවැරදි ද්විත්ව සටහන කුමක්ද?",
      options = listOf("මුදල් ගිණුම හර, ප්‍රාග්ධන ගිණුම බැර", "ප්‍රාග්ධන ගිණුම හර, මුදල් ගිණුම බැර", "බැංකු ගිණුම හර, ලාභ ගිණුම බැර", "ණයහිමි ගිණුම හර, මුදල් බැර"),
      correctIndex = 0,
      explanation = "මුදල් වත්කම වැඩිවන බැවින් මුදල් ගිණුම හර (Dr) ද, හිමිකම වැඩිවන බැවින් ප්‍රාග්ධන ගිණුම බැර (Cr) ද වේ."
    ),
    DailyMixedQuestion(
      id = 38,
      subject = "වාණිජ (ව්‍යාපාර පරිසරය)",
      question = "ව්‍යාපාරයක අභ්‍යන්තර පරිසර සාධකයක් වන්නේ පහත කුමක්ද?",
      options = listOf("තරඟකරුවන්", "සේවකයින් හා කළමනාකාරිත්වය", "රජයේ නීති රීති", "ආර්ථික තත්ත්වය"),
      correctIndex = 1,
      explanation = "හිමිකරුවන්, කළමනාකාරිත්වය සහ සේවකයින් ව්‍යාපාරය තුළ පාලනය කළ හැකි අභ්‍යන්තර සාධක වේ."
    ),
    DailyMixedQuestion(
      id = 39,
      subject = "වාණිජ (බැංකු සේවා)",
      question = "චෙක්පත් පහසුකම ලබාගත හැකි එකම ගිණුම් වර්ගය කුමක්ද?",
      options = listOf("ඉතිරි කිරීමේ ගිණුම", "ජංගම ගිණුම (Current Account)", "ස්ථාවර තැන්පතු ගිණුම", "ළමා ඉතිරි කිරීමේ ගිණුම"),
      correctIndex = 1,
      explanation = "චෙක්පත් මඟින් මුදල් ගනුදෙනු කළ හැක්කේ වාණිජ බැංකුවල ඇති ජංගම ගිණුම් සඳහා පමණි."
    ),
    DailyMixedQuestion(
      id = 40,
      subject = "වාණිජ (අලෙවිකරණය)",
      question = "අලෙවිකරණ මිශ්‍රයේ 4Ps වලට අයත් නොවන කරුණ කුමක්ද?",
      options = listOf("භාණ්ඩය (Product)", "මිල (Price)", "ලාභය (Profit)", "ප්‍රවර්ධනය (Promotion)"),
      correctIndex = 2,
      explanation = "අලෙවිකරණ මිශ්‍රයේ 4Ps නම්: Product (භාණ්ඩය), Price (මිල), Place (ස්ථානය/බෙදාහැරීම), Promotion (ප්‍රවර්ධනය) වේ."
    ),

    // --- GEOGRAPHY (41 - 45) ---
    DailyMixedQuestion(
      id = 41,
      subject = "භූගෝල විද්‍යාව (භූ ලක්ෂණ)",
      question = "ශ්‍රී ලංකාවේ උසම කඳු මුදුන කුමක්ද?",
      options = listOf("ශ්‍රී පාදය (සමනල කන්ද)", "නමුණුකුල", "පිදුරුතලාගල", "කිරිගල්පොත්ත"),
      correctIndex = 2,
      explanation = "පිදුරුතලාගල කන්ද මීටර් 2524 ක උසකින් යුක්ත වන අතර නුවරඑළිය දිස්ත්‍රික්කයේ පිහිටා ඇත."
    ),
    DailyMixedQuestion(
      id = 42,
      subject = "භූගෝල විද්‍යාව (ගංගා පද්ධතිය)",
      question = "ශ්‍රී ලංකාවේ දිගම ගංගාව වන මහවැලි ගඟේ මුළු දිග කොපමණද?",
      options = listOf("145 km", "335 km", "280 km", "400 km"),
      correctIndex = 1,
      explanation = "මහවැලි ගඟ කිලෝමීටර් 335ක් දිගින් යුක්ත වන අතර ත්‍රිකුණාමලයේ කොඩ්ඩියාර් බොක්කෙන් මුහුදට ගලා බසී."
    ),
    DailyMixedQuestion(
      id = 43,
      subject = "භූගෝල විද්‍යාව (කාලගුණය)",
      question = "නිරිතදිග මෝසම් සුළං හමන කාලසීමාව කුමක්ද?",
      options = listOf("මැයි සිට සැප්තැම්බර් දක්වා", "දෙසැම්බර් සිට පෙබරවාරි දක්වා", "ඔක්තෝබර් සිට නොවැම්බර් දක්වා", "මාර්තු සිට අප්‍රේල් දක්වා"),
      correctIndex = 0,
      explanation = "නිරිතදිග මෝසම මැයි-සැප්තැම්බර් කාලයේදී නිරිතදිග දෙසින් හමා විත් තෙත් කලාපයට අධික වැසි ලබා දෙයි."
    ),
    DailyMixedQuestion(
      id = 44,
      subject = "භූගෝල විද්‍යාව (ඛනිජ)",
      question = "ලෝකයේ ඉහළම සංශුද්ධතාවයෙන් යුත් මිනිරන් (Graphite) හමුවන ප්‍රධාන පතල් 2 කුමක්ද?",
      options = listOf("කහටගහ සහ බෝගල", "පුල්මුඩේ සහ එප්පාවල", "මීටියාගොඩ සහ ඇලහැර", "රත්නපුර සහ පැල්මඩුල්ල"),
      correctIndex = 0,
      explanation = "කහටගහ සහ බෝගල ලංකාවේ ප්‍රධාන මිනිරන් පතල් වේ. එප්පාවලින් ඇපටයිට් ද, පුල්මුඩේ ඛනිජ වැලි ද හමුවේ."
    ),
    DailyMixedQuestion(
      id = 45,
      subject = "භූගෝල විද්‍යාව (ජනගහනය)",
      question = "ශ්‍රී ලංකාවේ ජන ඝනත්වය වැඩිම දිස්ත්‍රික්කය කුමක්ද?",
      options = listOf("ගම්පහ", "කොළඹ", "මහනුවර", "කළුතර"),
      correctIndex = 1,
      explanation = "කොළඹ දිස්ත්‍රික්කයේ වර්ග කිලෝමීටරයකට ජනගහනය 3400 ඉක්මවන අතර එය ලංකාවේ වැඩිම ජන ඝනත්වයයි."
    ),

    // --- CIVICS (46 - 50) ---
    DailyMixedQuestion(
      id = 46,
      subject = "පුරවැසි අධ්‍යාපනය (ව්‍යවස්ථාව)",
      question = "ශ්‍රී ලංකාවේ ව්‍යවස්ථාදායකය නියෝජනය කරන ආයතනය කුමක්ද?",
      options = listOf("ශ්‍රේෂ්ඨාධිකරණය", "පාර්ලිමේන්තුව", "අමාත්‍ය මණ්ඩලය", "මැතිවරණ කොමිසම"),
      correctIndex = 1,
      explanation = "ශ්‍රී ලංකාවේ නීති සම්පාදනය කිරීමේ ව්‍යවස්ථාදායක බලය හිමිවන්නේ පාර්ලිමේන්තුවටයි (මන්ත්‍රීවරුන් 225)."
    ),
    DailyMixedQuestion(
      id = 47,
      subject = "පුරවැසි අධ්‍යාපනය (ඡන්ද බලය)",
      question = "ශ්‍රී ලංකාවට සර්වජන ඡන්ද බලය ප්‍රථම වරට හිමිවූයේ කවර වර්ෂයේදීද?",
      options = listOf("1931 (ඩොනමෝර්)", "1948 (සෝල්බරි)", "1972 (ජනරජ)", "1910 (ක්‍රූව්-මැකලම්)"),
      correctIndex = 0,
      explanation = "1931 ඩොනමෝර් ආණ්ඩුක්‍රමය මඟින් ආසියාවේ ප්‍රථම වරට වයස 21 සම්පූර්ණ වූ කාන්තා පිරිමි සැමට ඡන්ද අයිතිය හිමිවිය."
    ),
    DailyMixedQuestion(
      id = 48,
      subject = "පුරවැසි අධ්‍යාපනය (මානව හිමිකම්)",
      question = "එක්සත් ජාතීන්ගේ විශ්ව මානව හිමිකම් ප්‍රකාශනය (UDHR) සම්මත කරගත් දිනය කුමක්ද?",
      options = listOf("1945 ඔක්තෝබර් 24", "1948 දෙසැම්බර් 10", "1956 අප්‍රේල් 12", "1978 සැප්තැම්බර් 07"),
      correctIndex = 1,
      explanation = "1948 දෙසැම්බර් 10 වන දින සම්මත විය. එබැවින් සෑම වසරකම දෙසැම්බර් 10 ජාත්‍යන්තර මානව හිමිකම් දිනයයි."
    ),
    DailyMixedQuestion(
      id = 49,
      subject = "පුරවැසි අධ්‍යාපනය (පළාත් පාලනය)",
      question = "ශ්‍රී ලංකාවේ පළාත් පාලන ආයතනයක් නොවන්නේ පහත කුමක්ද?",
      options = listOf("මහා නගර සභාව", "ප්‍රාදේශීය සභාව", "දිස්ත්‍රික් ලේකම් කාර්යාලය", "නගර සභාව"),
      correctIndex = 2,
      explanation = "දිස්ත්‍රික් ලේකම් කාර්යාලය මධ්‍යම රජයේ පරිපාලන ආයතනයකි. පළාත් පාලන ආයතන වන්නේ මහා නගර සභා, නගර සභා සහ ප්‍රාදේශීය සභා ය."
    ),
    DailyMixedQuestion(
      id = 50,
      subject = "පුරවැසි අධ්‍යාපනය (අධිකරණය)",
      question = "ශ්‍රී ලංකාවේ ආණ්ඩුක්‍රම ව්‍යවස්ථාව අර්ථ නිරූපණය කිරීමේ තනි බලය ඇත්තේ කාටද?",
      options = listOf("පාර්ලිමේන්තුවේ කථානායකට", "නීතිපතිවරයාට", "ශ්‍රේෂ්ඨාධිකරණයට", "අභියාචනාධිකරණයට"),
      correctIndex = 2,
      explanation = "1978 ව්‍යවස්ථාව අනුව ව්‍යවස්ථාමය අර්ථ නිරූපණය සහ මූලික අයිතිවාසිකම් විභාග කිරීමේ උත්තරීතර බලය ශ්‍රේෂ්ඨාධිකරණය සතුය."
    )
  )
}
