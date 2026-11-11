package com.example

// 100 Sri Lankan O/L Mathematics Trilingual Glossary Terms
// Divided into 10 groups of 10 words (1-10 each)
val mathsGlossary100Terms = listOf(
  // GROUP 1 (1 - 10): සංඛ්‍යා හා මූලික සංකල්ප
  GlossaryTermItem(
    id = "mat_01",
    englishTerm = "Prime Number",
    sinhalaTerm = "ප්‍රථමක සංඛ්‍යාව",
    tamilTerm = "முதன்மை எண்",
    subject = "ගණිතය",
    definitionSinhala = "1 සහ එම සංඛ්‍යාව පමණක් සාධක ලෙස ඇති 1ට වඩා විශාල පූර්ණ සංඛ්‍යාව.",
    examTip = "2 යනු ඇති එකම ඉරට්ටේ ප්‍රථමක සංඛ්‍යාවයි. 1 ප්‍රථමක හෝ සංයුක්ත සංඛ්‍යාවක් නොවේ."
  ),
  GlossaryTermItem(
    id = "mat_02",
    englishTerm = "Composite Number",
    sinhalaTerm = "සංයුක්ත සංඛ්‍යාව",
    tamilTerm = "பகு எண்",
    subject = "ගණිතය",
    definitionSinhala = "1 සහ එම සංඛ්‍යාවට අමතරව තවත් අවම වශයෙන් එක් සාධකයක් හෝ සහිත 1ට වැඩි පූර්ණ සංඛ්‍යා.",
    examTip = "කුඩාම සංයුක්ත සංඛ්‍යාව 4 වේ."
  ),
  GlossaryTermItem(
    id = "mat_03",
    englishTerm = "Rational Number",
    sinhalaTerm = "පරිමේය සංඛ්‍යාව",
    tamilTerm = "விகிதமுறு எண்",
    subject = "ගණිතය",
    definitionSinhala = "p සහ q නිඛිල වන අතර q ≠ 0 වන විට p/q ආකාරයෙන් ලිවිය හැකි ඕනෑම සංඛ්‍යාවක්.",
    examTip = "සීමිත දශම සහ ආවර්තී දශම සියල්ලම පරිමේය සංඛ්‍යා ගණයට අයත්ය."
  ),
  GlossaryTermItem(
    id = "mat_04",
    englishTerm = "Irrational Number",
    sinhalaTerm = "අපරිමේය සංඛ්‍යාව",
    tamilTerm = "விகிதமுறா எண்",
    subject = "ගණිතය",
    definitionSinhala = "p/q ආකාරයෙන් ලිවිය නොහැකි, අනන්ත වූ සහ ආවර්තී නොවන දශම සහිත සංඛ්‍යා.",
    examTip = "√2, √3, √5 සහ π (පයි) ප්‍රධාන අපරිමේය සංඛ්‍යා වේ."
  ),
  GlossaryTermItem(
    id = "mat_05",
    englishTerm = "Highest Common Factor (HCF)",
    sinhalaTerm = "මහා පොදු සාධකය (ම.පො.සා.)",
    tamilTerm = "மீப்பெரு பொதுக் காரணி",
    subject = "ගණිතය",
    definitionSinhala = "දී ඇති සංඛ්‍යා හෝ වීජීය පද දෙකක් හෝ කිහිපයක් ඉතිරි නැතිව බෙදිය හැකි විශාලතම සාධකය.",
    examTip = "වීජීය ප්‍රකාශනවල පොදු සාධකවල අවම බලයන්හි ගුණිතය මඟින් ම.පො.සා. ලැබේ."
  ),
  GlossaryTermItem(
    id = "mat_06",
    englishTerm = "Lowest Common Multiple (LCM)",
    sinhalaTerm = "කුඩා පොදු ගුණාකාරය (කු.පො.ගු.)",
    tamilTerm = "மீச்சிறு பொது மடங்கு",
    subject = "ගණිතය",
    definitionSinhala = "දී ඇති සංඛ්‍යා හෝ වීජීය ප්‍රකාශන සියල්ලෙන්ම ඉතිරි නැතිව බෙදෙන කුඩාම පොදු සංඛ්‍යාව හෝ ප්‍රකාශනය.",
    examTip = "භාග එකතු කිරීමේදී සහ අඩු කිරීමේදී හරයන් සමාන කිරීමට කු.පො.ගු. යොදා ගනී."
  ),
  GlossaryTermItem(
    id = "mat_07",
    englishTerm = "Percentage",
    sinhalaTerm = "ප්‍රතිශතය",
    tamilTerm = "சதவீதம்",
    subject = "ගණිතය",
    definitionSinhala = "හරය 100 වන භාගයක් ලෙස දක්වන අගය (සංකේතය: %).",
    examTip = "ලාභ ප්‍රතිශතය = (ලාභය / ගැනුම් මිල) × 100%."
  ),
  GlossaryTermItem(
    id = "mat_08",
    englishTerm = "Simple Interest",
    sinhalaTerm = "සරල පොලිය",
    tamilTerm = "தனிவட்டி",
    subject = "ගණිතය",
    definitionSinhala = "මුල් මුදලට (මූලධනයට) පමණක් නිශ්චිත කාලයක් සඳහා අයකරන හෝ ගෙවන ස්ථාවර පොලිය.",
    examTip = "I = (P × R × T) / 100 (I: පොලිය, P: මූලධනය, R: වාර්ෂික අනුපාතිකය, T: කාලය)."
  ),
  GlossaryTermItem(
    id = "mat_09",
    englishTerm = "Compound Interest",
    sinhalaTerm = "වැල් පොලිය",
    tamilTerm = "கூட்டு வட்டி",
    subject = "ගණිතය",
    definitionSinhala = "නියමිත කාල සීමාවක් අවසානයේ උපයන ලද පොලිය මූලධනයට එකතු කර, ඊළඟ වාරයේදී එම මුළු මුදලටම පොලී ගණනය කිරීම.",
    examTip = "A = P(1 + r/100)ⁿ (A: මුළු මුදල, n: කාලච්ඡේද සංඛ්‍යාව)."
  ),
  GlossaryTermItem(
    id = "mat_10",
    englishTerm = "Indices",
    sinhalaTerm = "දර්ශක",
    tamilTerm = "சுட்டிகள்",
    subject = "ගණිතය",
    definitionSinhala = "කිසියම් සංඛ්‍යාවක් තමාගෙන්ම නැවත නැවත ගුණවන වාර ගණන දක්වන බලය (aⁿ හි n යනු දර්ශකයයි).",
    examTip = "දර්ශක නීති: aᵐ × aⁿ = aᵐ⁺ⁿ, aᵐ ÷ aⁿ = aᵐ⁻ⁿ, a⁰ = 1, a⁻ⁿ = 1/aⁿ."
  ),

  // GROUP 2 (11 - 20): වීජ ගණිතය හා සාධක
  GlossaryTermItem(
    id = "mat_11",
    englishTerm = "Algebraic Expression",
    sinhalaTerm = "වීජීය ප්‍රකාශනය",
    tamilTerm = "இயற்கணிதக் கோவை",
    subject = "ගණිතය",
    definitionSinhala = "විචල්‍යයන් (අක්ෂර), නියතයන් සහ මූලික ගණිත කර්ම (+, -, ×, ÷) එකතු වී සෑදෙන ප්‍රකාශනයක්.",
    examTip = "සජාතීය පද පමණක් එකතු කිරීමට හෝ අඩු කිරීමට හැකිය (උදා: 3x + 2x = 5x)."
  ),
  GlossaryTermItem(
    id = "mat_12",
    englishTerm = "Coefficient",
    sinhalaTerm = "සංගුණකය",
    tamilTerm = "குணகம்",
    subject = "ගණිතය",
    definitionSinhala = "වීජීය පදයක විචල්‍යය සමඟ ගුණිතයක් ලෙස ඇති සංඛ්‍යාත්මක අගය.",
    examTip = "7x²y පදයේ x²y හි සංගුණකය 7 වේ. -x හි සංගුණකය -1 වේ."
  ),
  GlossaryTermItem(
    id = "mat_13",
    englishTerm = "Difference of Two Squares",
    sinhalaTerm = "වර්ග දෙකක අන්තරය",
    tamilTerm = "இரு வர்க்கங்களின் வித்தியாசம்",
    subject = "ගණිතය",
    definitionSinhala = "පද දෙකක වර්ගවල වෙනසක් සාධක බවට පත්කිරීමේ විශේෂ වීජීය අනන්‍යතාවය (a² - b² = (a - b)(a + b)).",
    examTip = "උදා: x² - 16 = (x - 4)(x + 4)."
  ),
  GlossaryTermItem(
    id = "mat_14",
    englishTerm = "Expansion",
    sinhalaTerm = "ප්‍රසාරණය",
    tamilTerm = "விரித்தல்",
    subject = "ගණිතය",
    definitionSinhala = "වරහන් සහිත වීජීය ගුණිතයන් වරහන් ඉවත් කර තනි ප්‍රකාශනයක් ලෙස ලිවීම.",
    examTip = "(a + b)² = a² + 2ab + b², (a - b)² = a² - 2ab + b²."
  ),
  GlossaryTermItem(
    id = "mat_15",
    englishTerm = "Factorization",
    sinhalaTerm = "සාධක වෙන්කිරීම",
    tamilTerm = "காரணிப்படுத்தல்",
    subject = "ගණිතය",
    definitionSinhala = "වීජීය ප්‍රකාශනයක් කුඩා සරල ප්‍රකාශන දෙකක හෝ කිහිපයක ගුණිතයක් ලෙස ලිවීම.",
    examTip = "ත්‍රිපද ප්‍රකාශන සාධක: x² + 5x + 6 = (x + 2)(x + 3)."
  ),
  GlossaryTermItem(
    id = "mat_16",
    englishTerm = "Logarithm",
    sinhalaTerm = "ලඝුගණකය",
    tamilTerm = "மடக்கை",
    subject = "ගණිතය",
    definitionSinhala = "කිසියම් පාදයකට (base) අදාළව සංඛ්‍යාවක් ලබාගැනීම සඳහා එම පාදය නැංවිය යුතු දර්ශකය.",
    examTip = "bʸ = x නම් log_b(x) = y වේ. log(ab) = log a + log b."
  ),
  GlossaryTermItem(
    id = "mat_17",
    englishTerm = "Arithmetic Progression (AP)",
    sinhalaTerm = "සමාන්තර ශ්‍රේඪිය",
    tamilTerm = "கூட்டுத் தொடர்",
    subject = "ගණිතය",
    definitionSinhala = "පසු පදයෙන් පෙර පදය අඩුකළ විට ලැබෙන පොදු අන්තරය (d) නියතයක් වන සංඛ්‍යා රටාව.",
    examTip = "n වන පදය: Tₙ = a + (n - 1)d; මුල් පද n හි එකතුව: Sₙ = n/2 [2a + (n - 1)d]."
  ),
  GlossaryTermItem(
    id = "mat_18",
    englishTerm = "Geometric Progression (GP)",
    sinhalaTerm = "ගුණෝත්තර ශ්‍රේඪිය",
    tamilTerm = "பெருக்குத் தொடர்",
    subject = "ගණිතය",
    definitionSinhala = "ඕනෑම පදයක් එහි පෙර පදයෙන් බෙදූ විට ලැබෙන පොදු අනුපාතය (r) නියතයක් වන සංඛ්‍යා රටාව.",
    examTip = "n වන පදය: Tₙ = arⁿ⁻¹; n පදවල එකතුව: Sₙ = a(rⁿ - 1)/(r - 1) (r > 1)."
  ),
  GlossaryTermItem(
    id = "mat_19",
    englishTerm = "Scientific Notation",
    sinhalaTerm = "විද්‍යාත්මක අංකනය",
    tamilTerm = "விஞ்ஞானக் குறியீடு",
    subject = "ගණිතය",
    definitionSinhala = "ඕනෑම සංඛ්‍යාවක් 1 ≤ a < 10 සහ n නිඛිලයක් වන පරිදි a × 10ⁿ ආකාරයෙන් ලිවීම.",
    examTip = "උදා: 450,000 = 4.5 × 10⁵; 0.0032 = 3.2 × 10⁻³."
  ),
  GlossaryTermItem(
    id = "mat_20",
    englishTerm = "Matrix",
    sinhalaTerm = "න්‍යාසය",
    tamilTerm = "தாயங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "පේළි (rows) සහ තීරු (columns) සහිත සෘජුකෝණාස්‍රාකාර අනුපිළිවෙලකට සංඛ්‍යා පෙළගැස්වීම.",
    examTip = "2 × 2 න්‍යාසයක ගුණ කිරීමේදී පළමු න්‍යාසයේ පේළිය දෙවන න්‍යාසයේ තීරුවෙන් ගුණ කරයි."
  ),

  // GROUP 3 (21 - 30): සමීකරණ හා අසමානතා
  GlossaryTermItem(
    id = "mat_21",
    englishTerm = "Linear Equation",
    sinhalaTerm = "සරල රේඛීය සමීකරණය",
    tamilTerm = "நேரியல் சமன்பாடு",
    subject = "ගණිතය",
    definitionSinhala = "විචල්‍යයේ උපරිම බලය 1 වන, විසඳූ විට තනි අගයක් ලැබෙන සමීකරණය (ax + b = 0).",
    examTip = "ප්‍රස්තාරයක් මත ඇඳි විට සරල රේඛාවක් ලැබේ."
  ),
  GlossaryTermItem(
    id = "mat_22",
    englishTerm = "Simultaneous Equations",
    sinhalaTerm = "සමගාමී සමීකරණ",
    tamilTerm = "ஒருங்கமை சமன்பாடுகள்",
    subject = "ගණිතය",
    definitionSinhala = "විචල්‍යයන් දෙකක් සහිත සමීකරණ දෙකක් එකවර තෘප්ත කරන විසඳුම් සොයන ක්‍රමය.",
    examTip = "විචල්‍යයක් ඉවත් කිරීමේ ක්‍රමය (Elimination) හෝ ආදේශ කිරීමේ ක්‍රමය (Substitution) මඟින් විසඳිය හැක."
  ),
  GlossaryTermItem(
    id = "mat_23",
    englishTerm = "Quadratic Equation",
    sinhalaTerm = "වර්ගජ සමීකරණය",
    tamilTerm = "இருபடிச் சமன்பாடு",
    subject = "ගණිතය",
    definitionSinhala = "විචල්‍යයේ උපරිම බලය 2 වන ax² + bx + c = 0 (a ≠ 0) ආකාරයේ සමීකරණය.",
    examTip = "වර්ගජ සූත්‍රය: x = [-b ± √(b² - 4ac)] / (2a)."
  ),
  GlossaryTermItem(
    id = "mat_24",
    englishTerm = "Discriminant (Δ)",
    sinhalaTerm = "විවේචකය",
    tamilTerm = "தன்மைகாட்டி",
    subject = "ගණිතය",
    definitionSinhala = "වර්ගජ සමීකරණයක මූලයන්ගේ ස්වභාවය තීරණය කරන Δ = b² - 4ac අගය.",
    examTip = "Δ > 0 නම් තාත්වික වෙනස් මූල 2ක්, Δ = 0 නම් සමාන මූල, Δ < 0 නම් තාත්වික මූල නැත."
  ),
  GlossaryTermItem(
    id = "mat_25",
    englishTerm = "Inequality",
    sinhalaTerm = "අසමානතාවය",
    tamilTerm = "சமனின்மை",
    subject = "ගණිතය",
    definitionSinhala = "රාශි දෙකක් අතර විශාල, කුඩා හෝ සමාන නොවන බව දක්වන ගණිත ප්‍රකාශනය (<, >, ≤, ≥).",
    examTip = "සෘණ සංඛ්‍යාවකින් ගුණ කළ විට හෝ බෙදූ විට අසමානතා ලකුණ අනෙක් අතට හැරේ (උදා: -2x > 6 නම් x < -3)."
  ),
  GlossaryTermItem(
    id = "mat_26",
    englishTerm = "Subject of Formula",
    sinhalaTerm = "සූත්‍රයක උක්තය",
    tamilTerm = "சூத்திரத்தின் எழுவாய்",
    subject = "ගණිතය",
    definitionSinhala = "සමීකරණයක එක් පසෙක සංගුණකය ධන 1 වන සේ තනිව පිහිටුවා ඇති විචල්‍යය.",
    examTip = "v = u + at හි t උක්ත කිරීමට: t = (v - u) / a."
  ),
  GlossaryTermItem(
    id = "mat_27",
    englishTerm = "Root / Solution",
    sinhalaTerm = "මූලය / විසඳුම",
    tamilTerm = "மூலம் / தீர்வு",
    subject = "ගණිතය",
    definitionSinhala = "සමීකරණයේ විචල්‍යය වෙනුවට ආදේශ කළ විට සමීකරණය සත්‍ය වන නිශ්චිත අගය.",
    examTip = "වර්ගජ සමීකරණයකට සාමාන්‍යයෙන් මූල 2ක් පවතී."
  ),
  GlossaryTermItem(
    id = "mat_28",
    englishTerm = "Completing the Square",
    sinhalaTerm = "වර්ගපූර්ණය",
    tamilTerm = "வர்க்கப் பூர்த்தியாக்கல்",
    subject = "ගණිතය",
    definitionSinhala = "වර්ගජ ප්‍රකාශනයක් පූර්ණ වර්ගයක් බවට පත් කිරීම සඳහා x හි සංගුණකයෙන් අඩක වර්ගය එකතු කිරීමේ ක්‍රමය.",
    examTip = "x² + 6x සඳහා එකතු කළ යුතු අගය (6/2)² = 9 වේ."
  ),
  GlossaryTermItem(
    id = "mat_29",
    englishTerm = "Direct Proportion",
    sinhalaTerm = "නේර සමානුපාතය",
    tamilTerm = "நேர்விகித சமன்",
    subject = "ගණිතය",
    definitionSinhala = "එක් විචල්‍යයක් වැඩි වන විට අනෙක් විචල්‍යයද එකම අනුපාතයකින් වැඩිවන සම්බන්ධතාවය (y = kx).",
    examTip = "y/x අනුපාතය සෑම විටම නියතයකි (k)."
  ),
  GlossaryTermItem(
    id = "mat_30",
    englishTerm = "Inverse Proportion",
    sinhalaTerm = "ප්‍රතිලෝම සමානුපාතය",
    tamilTerm = "நேர்மாறு விகித சமன்",
    subject = "ගණිතය",
    definitionSinhala = "එක් විචල්‍යයක් වැඩි වන විට අනෙක් විචල්‍යය අනුරූපව අඩුවන සම්බන්ධතාවය (y = k / x).",
    examTip = "විචල්‍ය දෙකෙහි ගුණිතය (xy = k) නියතයක් වේ (උදා: සේවක සංඛ්‍යාව හා ගතවන දින ගණන)."
  ),

  // GROUP 4 (31 - 40): ජ්‍යාමිතිය - කෝණ, ත්‍රිකෝණ හා බහුඅස්‍ර
  GlossaryTermItem(
    id = "mat_31",
    englishTerm = "Complementary Angles",
    sinhalaTerm = "පූරක කෝණ",
    tamilTerm = "நிரப்புக் கோணங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "කෝණ දෙකක එකතුව හරියටම 90° ක් වන කෝණ යුගල.",
    examTip = "40° හි පූරක කෝණය 50° වේ (90° - 40°)."
  ),
  GlossaryTermItem(
    id = "mat_32",
    englishTerm = "Supplementary Angles",
    sinhalaTerm = "පරිපූරක කෝණ",
    tamilTerm = "மிகைநிரப்புக் கோணங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "කෝණ දෙකක එකතුව හරියටම 180° ක් වන කෝණ යුගල.",
    examTip = "සරල රේඛාවක් මත යාබද කෝණ යුගල පරිපූරක වේ."
  ),
  GlossaryTermItem(
    id = "mat_33",
    englishTerm = "Vertically Opposite Angles",
    sinhalaTerm = "ප්‍රතිමුඛ කෝණ",
    tamilTerm = "குத்தெதிர்க் கோணங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "සරල රේඛා දෙකක් එකිනෙක ඡේදනය වීමේදී මුහුණට මුහුණ පිහිටන කෝණ.",
    examTip = "ප්‍රතිමුඛ කෝණ සෑමවිටම එකිනෙකට විශාලත්වයෙන් සමාන වේ."
  ),
  GlossaryTermItem(
    id = "mat_34",
    englishTerm = "Alternate Angles",
    sinhalaTerm = "ඒකාන්තර කෝණ",
    tamilTerm = "ஒன்றுவிட்ட கோணங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "සමාන්තර රේඛා දෙකක් තිරස් ඡේදකයකින් කැපූ විට Z හැඩයට පිහිටන සමාන කෝණ යුගල.",
    examTip = "සමාන්තර රේඛා ජ්‍යාමිතික සාධනවලදී 'Z හැඩය' සොයන්න."
  ),
  GlossaryTermItem(
    id = "mat_35",
    englishTerm = "Corresponding Angles",
    sinhalaTerm = "අනුරූප කෝණ",
    tamilTerm = "ஒத்த கோணங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "සමාන්තර රේඛා දෙකක් තිරික් රේඛාවකින් ඡේදනය වූ විට F හැඩයට එකම දිශාවට පිහිටන සමාන කෝණ.",
    examTip = "සමාන්තර රේඛා සඳහා අනුරූප කෝණ එකිනෙකට සමාන වේ."
  ),
  GlossaryTermItem(
    id = "mat_36",
    englishTerm = "Allied / Interior Angles",
    sinhalaTerm = "මිත්‍ර කෝණ (අභ්‍යන්තර කෝණ)",
    tamilTerm = "நேயக் கோணங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "සමාන්තර රේඛා දෙකක් අතර තිරික් රේඛාවේ එකම පැත්තේ පිහිටන කෝණ යුගල (C හෝ U හැඩය).",
    examTip = "මිත්‍ර කෝණවල එකතුව 180° කි (පරිපූරක වේ)."
  ),
  GlossaryTermItem(
    id = "mat_37",
    englishTerm = "Congruence of Triangles",
    sinhalaTerm = "ත්‍රිකෝණ අනුසමතාව",
    tamilTerm = "முக்கோணங்களின் ஒருங்கிசைவு",
    subject = "ගණිතය",
    definitionSinhala = "හැඩයෙන් මෙන්ම විශාලත්වයෙන්ද එකිනෙකට මුළුමනින්ම සමාන වන ත්‍රිකෝණ දෙකක්.",
    examTip = "අනුසමතා අවස්ථා 4: පා.පා.පා., පා.කෝ.පා., කෝ.කෝ.පා., සහ කර්ණ.පා."
  ),
  GlossaryTermItem(
    id = "mat_38",
    englishTerm = "Equilateral Triangle",
    sinhalaTerm = "සමපාද ත්‍රිකෝණය",
    tamilTerm = "சமபக்க முக்கோணம்",
    subject = "ගණිතය",
    definitionSinhala = "පාද තුනම දිගින් සමාන වන සහ සියලුම අභ්‍යන්තර කෝණ 60° බැගින් වන ත්‍රිකෝණය.",
    examTip = "සමපාද ත්‍රිකෝණයක සමමිතික අක්ෂ 3ක් පවතී."
  ),
  GlossaryTermItem(
    id = "mat_39",
    englishTerm = "Isosceles Triangle",
    sinhalaTerm = "සමද්විපාද ත්‍රිකෝණය",
    tamilTerm = "இருசமபக்க முக்கோணம்",
    subject = "ගණිතය",
    definitionSinhala = "පාද දෙකක් දිගින් සමාන වන සහ එම පාදවලට සම්මුඛ කෝණ දෙක සමාන වන ත්‍රිකෝණය.",
    examTip = "සමපාද අතර ශීර්ෂයේ කෝණ සමච්ඡේදකය පාදය ලම්බකව සමච්ඡේදනය කරයි."
  ),
  GlossaryTermItem(
    id = "mat_40",
    englishTerm = "Midpoint Theorem",
    sinhalaTerm = "මධ්‍ය ලක්ෂ්‍ය ප්‍රමේයය",
    tamilTerm = "நடுப்புள்ளித் தேற்றம்",
    subject = "ගණිතය",
    definitionSinhala = "ත්‍රිකෝණයක පාද දෙකක මධ්‍ය ලක්ෂ්‍ය යාකරන සරල රේඛාව තෙවන පාදයට සමාන්තර වන අතර එහි දිගින් අඩක් වේ.",
    examTip = "O/L ජ්‍යාමිතික සාධන ප්‍රශ්නවල නිතරම භාවිතා වන ප්‍රධාන ප්‍රමේයයකි."
  ),

  // GROUP 5 (41 - 50): ජ්‍යාමිතිය - වෘත්ත හා ප්‍රමේය
  GlossaryTermItem(
    id = "mat_41",
    englishTerm = "Chord",
    sinhalaTerm = "ජ්‍යාය",
    tamilTerm = "நாண்",
    subject = "ගණිතය",
    definitionSinhala = "වෘත්තයක පරිධිය මත පිහිටි ඕනෑම ලක්ෂ්‍ය දෙකක් යා කරන සරල රේඛා ඛණ්ඩය.",
    examTip = "වෘත්තයක කේන්ද්‍රය හරහා යන දිගම ජ්‍යාය 'විෂ්කම්භය' (Diameter) වේ."
  ),
  GlossaryTermItem(
    id = "mat_42",
    englishTerm = "Angle Subtended by an Arc",
    sinhalaTerm = "චාපයකින් ආපාතනය කරන කෝණය",
    tamilTerm = "வில்லினால் எதிரமைக்கப்படும் கோணம்",
    subject = "ගණිතය",
    definitionSinhala = "වෘත්තයක කිසියම් චාපයක කෙළවර ලක්ෂ්‍ය දෙක කේන්ද්‍රයට හෝ පරිධියට යාකිරීමෙන් සෑදෙන කෝණය.",
    examTip = "කේන්ද්‍ර කෝණය = 2 × පරිධියේ ඉතිරි කොටසේ කෝණය."
  ),
  GlossaryTermItem(
    id = "mat_43",
    englishTerm = "Angle in a Semicircle",
    sinhalaTerm = "අර්ධ වෘත්තයක කෝණය",
    tamilTerm = "அரைவட்டக் கோணம்",
    subject = "ගණිතය",
    definitionSinhala = "විෂ්කම්භයක් මත පරිධියට ආපාතනය කරන කෝණය.",
    examTip = "අර්ධ වෘත්තයක කෝණය සෑමවිටම ඍජුකෝණයකි (90°)."
  ),
  GlossaryTermItem(
    id = "mat_44",
    englishTerm = "Angles in the Same Segment",
    sinhalaTerm = "එකම ඛණ්ඩයේ කෝණ",
    tamilTerm = "ஒரே துண்டக் கோணங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "වෘත්තයක එකම චාපය මඟින් එකම වෘත්ත ඛණ්ඩය තුළ පරිධිය මත ආපාතනය කරන කෝණ.",
    examTip = "එකම වෘත්ත ඛණ්ඩයේ කෝණ එකිනෙකට විශාලත්වයෙන් සමාන වේ."
  ),
  GlossaryTermItem(
    id = "mat_45",
    englishTerm = "Cyclic Quadrilateral",
    sinhalaTerm = "චක්‍රීය චතුරස්‍රය",
    tamilTerm = "வட்ட நாற்பக்கல்",
    subject = "ගණිතය",
    definitionSinhala = "ශීර්ෂ හතරම එකම වෘත්තයක පරිධිය මත පිහිටා ඇති චතුරස්‍රය.",
    examTip = "චක්‍රීය චතුරස්‍රයක සම්මුඛ කෝණ පරිපූරක වේ (එකතුව 180° කි)."
  ),
  GlossaryTermItem(
    id = "mat_46",
    englishTerm = "Exterior Angle of Cyclic Quadrilateral",
    sinhalaTerm = "චක්‍රීය චතුරස්‍රයක බාහිර කෝණය",
    tamilTerm = "வட்ட நாற்பக்கலின் வெளிக்கோணம்",
    subject = "ගණිතය",
    definitionSinhala = "චක්‍රීය චතුරස්‍රයක පාදයක් දික්කිරීමෙන් සෑදෙන පිටත කෝණය.",
    examTip = "බාහිර කෝණය එහි අභ්‍යන්තර සම්මුඛ කෝණයට විශාලත්වයෙන් සමාන වේ."
  ),
  GlossaryTermItem(
    id = "mat_47",
    englishTerm = "Tangent to a Circle",
    sinhalaTerm = "වෘත්තයක ස්පර්ශකය",
    tamilTerm = "வட்டத்தின் தொடலி",
    subject = "ගණිතය",
    definitionSinhala = "වෘත්තයක පරිධිය එකම එක් ලක්ෂ්‍යයකදී පමණක් ස්පර්ශ කරමින් ගමන් කරන සරල රේඛාව.",
    examTip = "ස්පර්ශ ලක්ෂ්‍යයේදී අඳින අරය සහ ස්පර්ශකය අතර කෝණය 90° කි."
  ),
  GlossaryTermItem(
    id = "mat_48",
    englishTerm = "Alternate Segment Theorem",
    sinhalaTerm = "ඒකාන්තර ඛණ්ඩ ප්‍රමේයය",
    tamilTerm = "ஒன்றுவிட்ட துண்டத் தேற்றம்",
    subject = "ගණිතය",
    definitionSinhala = "ස්පර්ශකයක් සහ ස්පර්ශ ලක්ෂ්‍යයෙන් අඳින ජ්‍යායක් අතර කෝණය, එම ජ්‍යායෙන් ඒකාන්තර වෘත්ත ඛණ්ඩයේ ආපාතනය කරන කෝණයට සමාන වේ.",
    examTip = "O/L ජ්‍යාමිතික සාධනය අංක 2 හි නිතර යොදාගැනේ."
  ),
  GlossaryTermItem(
    id = "mat_49",
    englishTerm = "Tangents from an External Point",
    sinhalaTerm = "බාහිර ලක්ෂ්‍යයකින් අඳින ස්පර්ශක",
    tamilTerm = "வெளிப்புள்ளியிலிருந்து தொடலிகள்",
    subject = "ගණිතය",
    definitionSinhala = "වෘත්තයෙන් පිටත ලක්ෂ්‍යයක සිට එම වෘත්තයට ඇඳිය හැකි ස්පර්ශක දෙකක්.",
    examTip = "බාහිර ලක්ෂ්‍යයේ සිට ස්පර්ශ ලක්ෂ්‍යවලට ඇති දිගවල් සමාන වේ."
  ),
  GlossaryTermItem(
    id = "mat_50",
    englishTerm = "Perpendicular Bisector of a Chord",
    sinhalaTerm = "ජ්‍යායක ලම්බ සමච්ඡේදකය",
    tamilTerm = "நாணின் செங்குத்து இருசமகூறிடல்",
    subject = "ගණිතය",
    definitionSinhala = "වෘත්තයක කේන්ද්‍රයේ සිට ජ්‍යායකට අඳින ලම්බකය මඟින් එම ජ්‍යාය සමච්ඡේදනය වේ.",
    examTip = "ජ්‍යායේ දිගෙන් අඩ, කේන්ද්‍රයේ සිට ලම්බ දුර සහ අරය යොදා පයිතගරස් ප්‍රමේයය යෙදිය හැක (r² = d² + (L/2)²)."
  ),

  // GROUP 6 (51 - 60): ත්‍රිකෝණමිතිය
  GlossaryTermItem(
    id = "mat_51",
    englishTerm = "Hypotenuse",
    sinhalaTerm = "කර්ණය",
    tamilTerm = "செம்பக்கம்",
    subject = "ගණිතය",
    definitionSinhala = "ඍජුකෝණී ත්‍රිකෝණයක 90° ඍජුකෝණයට සම්මුඛව පිහිටි දිගම පාදය.",
    examTip = "ත්‍රිකෝණමිතික අනුපාත ගණනය කිරීමේදී මූලික යොමුව ලෙස යොදා ගැනේ."
  ),
  GlossaryTermItem(
    id = "mat_52",
    englishTerm = "Opposite Side",
    sinhalaTerm = "සම්මුඛ පාදය",
    tamilTerm = "எதிர்ப்பக்கம்",
    subject = "ගණිතය",
    definitionSinhala = "ඍජුකෝණී ත්‍රිකෝණයක සලකනු ලබන θ කෝණයට කෙළින්ම ඉදිරියෙන් පිහිටි පාදය.",
    examTip = "කෝණය මාරු වන විට සම්මුඛ සහ බද්ධ පාද මාරු වේ."
  ),
  GlossaryTermItem(
    id = "mat_53",
    englishTerm = "Adjacent Side",
    sinhalaTerm = "බද්ධ පාදය",
    tamilTerm = "அயற்பக்கம்",
    subject = "ගණිතය",
    definitionSinhala = "සලකනු ලබන θ කෝණයට සහ 90° කෝණයට අතරමැදිව පිහිටි පාදය.",
    examTip = "කර්ණය හැර කෝණයට සම්බන්ධ අනෙක් පාදයයි."
  ),
  GlossaryTermItem(
    id = "mat_54",
    englishTerm = "Sine Ratio (sin)",
    sinhalaTerm = "සයින් අනුපාතය",
    tamilTerm = "சைன் விகிதம்",
    subject = "ගණිතය",
    definitionSinhala = "ඍජුකෝණී ත්‍රිකෝණයක සලකන කෝණයට සම්මුඛ පාදයේ දිග කර්ණයේ දිගට දරන අනුපාතය (sin θ = සම්මුඛ / කර්ණය).",
    examTip = "sin 30° = 1/2, sin 90° = 1 වේ."
  ),
  GlossaryTermItem(
    id = "mat_55",
    englishTerm = "Cosine Ratio (cos)",
    sinhalaTerm = "කොසයින් අනුපාතය",
    tamilTerm = "கோசைன் விகிதம்",
    subject = "ගණිතය",
    definitionSinhala = "සලකන කෝණයේ බද්ධ පාදයේ දිග කර්ණයේ දිගට දරන අනුපාතය (cos θ = බද්ධ / කර්ණය).",
    examTip = "cos 60° = 1/2, cos 0° = 1 වේ."
  ),
  GlossaryTermItem(
    id = "mat_56",
    englishTerm = "Tangent Ratio (tan)",
    sinhalaTerm = "ටැන්ජන්ට් අනුපාතය",
    tamilTerm = "தான்ஜன்ட் விகிதம்",
    subject = "ගණිතය",
    definitionSinhala = "සලකන කෝණයේ සම්මුඛ පාදයේ දිග බද්ධ පාදයේ දිගට දරන අනුපාතය (tan θ = සම්මුඛ / බද්ධ = sin θ / cos θ).",
    examTip = "tan 45° = 1 වේ. ගොඩනැගිලි උස සෙවීමට නිතර භාවිතා වේ."
  ),
  GlossaryTermItem(
    id = "mat_57",
    englishTerm = "Pythagoras' Theorem",
    sinhalaTerm = "පයිතගරස් ප්‍රමේයය",
    tamilTerm = "பைதாகரசின் தேற்றம்",
    subject = "ගණිතය",
    definitionSinhala = "ඕනෑම ඍජුකෝණී ත්‍රිකෝණයක කර්ණයේ වර්ගය අනෙක් පාද දෙකේ වර්ගවල එකතුවට සමාන වේ (c² = a² + b²).",
    examTip = "ප්‍රධාන පයිතගරස් ත්‍රිත්ව: (3, 4, 5), (5, 12, 13), (7, 24, 25), (8, 15, 17)."
  ),
  GlossaryTermItem(
    id = "mat_58",
    englishTerm = "Angle of Elevation",
    sinhalaTerm = "ආරෝහණ කෝණය",
    tamilTerm = "ஏற்றக் கோணம்",
    subject = "ගණිතය",
    definitionSinhala = "නිරීක්ෂකයාගේ තිරස් දෘෂ්ටි රේඛාවට ඉහළින් පිහිටි වස්තුවක් දෙස බැලීමේදී තිරස සමඟ සෑදෙන කෝණය.",
    examTip = "තිරස් රේඛාවේ සිට ඉහළට මනිනු ලැබේ."
  ),
  GlossaryTermItem(
    id = "mat_59",
    englishTerm = "Angle of Depression",
    sinhalaTerm = "අවරෝහණ කෝණය",
    tamilTerm = "இறக்கக் கோணம்",
    subject = "ගණිතය",
    definitionSinhala = "නිරීක්ෂකයාගේ තිරස් දෘෂ්ටි රේඛාවට පහළින් පිහිටි වස්තුවක් දෙස බැලීමේදී තිරස සමඟ සෑදෙන කෝණය.",
    examTip = "ඒකාන්තර කෝණ නීතිය අනුව ආරෝහණ කෝණය = අවරෝහණ කෝණය වේ."
  ),
  GlossaryTermItem(
    id = "mat_60",
    englishTerm = "Three-Figure Bearing",
    sinhalaTerm = "දිගංශය (තුන් ඉලක්කම් දරනය)",
    tamilTerm = "திசைகோள் (மூவிலக்க அமைவு)",
    subject = "ගණිතය",
    definitionSinhala = "උතුරු දිශාවේ (000°) සිට දක්ෂිණාවර්තව අංශකවලින් මනිනු ලබන ත්‍රි-අංක දිශානතිය (උදා: 045°, 120°, 270°).",
    examTip = "නැගෙනහිර = 090°, දකුණ = 180°, බස්නාහිර = 270°."
  ),

  // GROUP 7 (61 - 70): මිනුම්, වර්ගඵලය හා පරිමාව
  GlossaryTermItem(
    id = "mat_61",
    englishTerm = "Perimeter",
    sinhalaTerm = "පරිමිතිය",
    tamilTerm = "சுற்றளவு",
    subject = "ගණිතය",
    definitionSinhala = "ද්විමාන සංවෘත තල රූපයක වට මායිම දිගේ ඇති මුළු දිග ප්‍රමාණය.",
    examTip = "සෘජුකෝණාස්‍රයේ පරිමිතිය = 2(දිග + පළල); වෘත්තයේ පරිධිය = 2πr."
  ),
  GlossaryTermItem(
    id = "mat_62",
    englishTerm = "Circumference of Circle",
    sinhalaTerm = "වෘත්තයක පරිධිය",
    tamilTerm = "வட்டத்தின் சுற்றளவு",
    subject = "ගණිතය",
    definitionSinhala = "වෘත්තයක වක්‍ර මායිමේ මුළු දිග (C = 2πr හෝ C = πd).",
    examTip = "π සඳහා සාමාන්‍යයෙන් 22/7 හෝ 3.14 යොදාගනී."
  ),
  GlossaryTermItem(
    id = "mat_63",
    englishTerm = "Area of Sector",
    sinhalaTerm = "කේන්ද්‍රික ඛණ්ඩයක වර්ගඵලය",
    tamilTerm = "ஆரைச்சிறை பரப்பளவு",
    subject = "ගණිතය",
    definitionSinhala = "කේන්ද්‍රයේ කෝණය θ වන කේන්ද්‍රික ඛණ්ඩයක වර්ගඵලය = (θ / 360°) × πr².",
    examTip = "කේන්ද්‍රික ඛණ්ඩයක චාප දිග = (θ / 360°) × 2πr."
  ),
  GlossaryTermItem(
    id = "mat_64",
    englishTerm = "Area of Trapezium",
    sinhalaTerm = "ත්‍රපීසියමක වර්ගඵලය",
    tamilTerm = "சரிவகத்தின் பரப்பளவு",
    subject = "ගණිතය",
    definitionSinhala = "සමාන්තර පාද දෙකේ එකතුවෙන් අඩක් සහ ඒවා අතර ලම්බ දුරෙහි ගුණිතය (A = 1/2 (a + b)h).",
    examTip = "ප්‍රවේග-කාල ප්‍රස්තාර යටතේ විස්ථාපනය සෙවීමට බහුලව යොදා ගැනේ."
  ),
  GlossaryTermItem(
    id = "mat_65",
    englishTerm = "Volume of Cylinder",
    sinhalaTerm = "සිලින්ඩරයක පරිමාව",
    tamilTerm = "உருளையின் கனவளவு",
    subject = "ගණිතය",
    definitionSinhala = "පාදමේ වර්ගඵලය සහ උසෙහි ගුණිතය (V = πr²h).",
    examTip = "සිලින්ඩරයක වක්‍ර පෘෂ්ඨ වර්ගඵලය = 2πrh; මුළු පෘෂ්ඨ වර්ගඵලය = 2πrh + 2πr²."
  ),
  GlossaryTermItem(
    id = "mat_66",
    englishTerm = "Volume of Cone",
    sinhalaTerm = "කේතුවක පරිමාව",
    tamilTerm = "கூம்பின் கனவளவு",
    subject = "ගණිතය",
    definitionSinhala = "සමාන පාදම හා උස ඇති සිලින්ඩරයක පරිමාවෙන් තුනෙන් එකකි (V = 1/3 πr²h).",
    examTip = "කේතුවේ ඇල උස (l) සෙවීමට: l² = r² + h²; වක්‍ර පෘෂ්ඨ වර්ගඵලය = πrl."
  ),
  GlossaryTermItem(
    id = "mat_67",
    englishTerm = "Volume of Sphere",
    sinhalaTerm = "ගෝලයක පරිමාව",
    tamilTerm = "கோளத்தின் கனவளவு",
    subject = "ගණිතය",
    definitionSinhala = "අරය r වන ගෝලයක පරිමාව (V = 4/3 πr³).",
    examTip = "ගෝලයක පෘෂ්ඨ වර්ගඵලය = 4πr²; අර්ධ ගෝලයක පරිමාව = 2/3 πr³."
  ),
  GlossaryTermItem(
    id = "mat_68",
    englishTerm = "Prism",
    sinhalaTerm = "ප්‍රිස්මය",
    tamilTerm = "அரியம்",
    subject = "ගණිතය",
    definitionSinhala = "දෙකෙළවර එකම හැඩයෙන් හා විශාලත්වයෙන් යුත් ඒකාකාර හරස්කඩක් සහිත ත්‍රිමාන ඝන වස්තුව.",
    examTip = "ප්‍රිස්මයක පරිමාව = හරස්කඩ වර්ගඵලය × දිග (V = A × l)."
  ),
  GlossaryTermItem(
    id = "mat_69",
    englishTerm = "Pyramid",
    sinhalaTerm = "පිරමිඩය",
    tamilTerm = "கூம்பகம்",
    subject = "ගණිතය",
    definitionSinhala = "බහුඅස්‍රාකාර පාදමක් සහ තනි ශීර්ෂයකට හමුවන ත්‍රිකෝණාකාර මුහුණත් සහිත ඝන වස්තුව.",
    examTip = "පිරමිඩයක පරිමාව = 1/3 × පාදමේ වර්ගඵලය × ලම්බ උස."
  ),
  GlossaryTermItem(
    id = "mat_70",
    englishTerm = "Surface Area",
    sinhalaTerm = "පෘෂ්ඨ වර්ගඵලය",
    tamilTerm = "மேற்பரப்பளவு",
    subject = "ගණිතය",
    definitionSinhala = "ත්‍රිමාන වස්තුවක සියලුම බාහිර මුහුණත්වල වර්ගඵලයන්හි එකතුව.",
    examTip = "ඝනකයක පෘෂ්ඨ වර්ගඵලය = 6a²; ඝනකාභයක = 2(lb + bh + hl)."
  ),

  // GROUP 8 (71 - 80): ඛණ්ඩාංක ජ්‍යාමිතිය හා ප්‍රස්තාර
  GlossaryTermItem(
    id = "mat_71",
    englishTerm = "Cartesian Plane",
    sinhalaTerm = "කාටීසීය තලය",
    tamilTerm = "கார்ட்டீசியன் தளம்",
    subject = "ගණිතය",
    definitionSinhala = "මූල ලක්ෂ්‍යයේදී (0, 0) ලම්බකව ඡේදනය වන තිරස් x අක්ෂය සහ සිරස් y අක්ෂය මඟින් තැනෙන තලය.",
    examTip = "ලක්ෂ්‍යයක් ලියන්නේ (x, y) ලෙසය. පළමුව x ඛණ්ඩාංකයද දෙවනුව y ඛණ්ඩාංකයද ලියයි."
  ),
  GlossaryTermItem(
    id = "mat_72",
    englishTerm = "Gradient / Slope (m)",
    sinhalaTerm = "අනුක්‍රමණය",
    tamilTerm = "படிவு / சாய்வு",
    subject = "ගණිතය",
    definitionSinhala = "සරල රේඛාවක සිරස් වෙනස තිරස් වෙනසට දරන අනුපාතය (m = (y₂ - y₁) / (x₂ - x₁)).",
    examTip = "වමෙන් දකුණට ඉහළ යන රේඛාවල අනුක්‍රමණය ධන වේ; පහළ බසින ඒවායේ සෘණ වේ."
  ),
  GlossaryTermItem(
    id = "mat_73",
    englishTerm = "Intercept (c)",
    sinhalaTerm = "අන්තඃඛණ්ඩය",
    tamilTerm = "வெட்டுத்துண்டு",
    subject = "ගණිතය",
    definitionSinhala = "සරල රේඛාවක් මඟින් y අක්ෂය කපන ලක්ෂ්‍යයේ y අගය.",
    examTip = "සරල රේඛීය සමීකරණය: y = mx + c (m = අනුක්‍රමණය, c = y අන්තඃඛණ්ඩය)."
  ),
  GlossaryTermItem(
    id = "mat_74",
    englishTerm = "Parallel Lines Gradient",
    sinhalaTerm = "සමාන්තර රේඛාවල අනුක්‍රමණය",
    tamilTerm = "சமாந்தரக் கோடுகளின் சாய்வு",
    subject = "ගණිතය",
    definitionSinhala = "එකිනෙකට සමාන්තර සරල රේඛා දෙකක අනුක්‍රමණයන් එකිනෙකට සමාන වේ (m₁ = m₂).",
    examTip = "y = 3x + 2 ට සමාන්තර රේඛාවක සමීකරණය y = 3x + k ආකාර වේ."
  ),
  GlossaryTermItem(
    id = "mat_75",
    englishTerm = "Turning Point",
    sinhalaTerm = "හැරවුම් ලක්ෂ්‍යය (ශීර්ෂය)",
    tamilTerm = "திரும்பற்புள்ளி",
    subject = "ගණිතය",
    definitionSinhala = "පැරබෝලාවක (වර්ගජ ප්‍රස්තාරයක) උපරිම හෝ අවම අගය ලැබෙන ලක්ෂ්‍යය.",
    examTip = "y = (x - h)² + k ප්‍රස්තාරයේ හැරවුම් ලක්ෂ්‍යය (h, k) වේ."
  ),
  GlossaryTermItem(
    id = "mat_76",
    englishTerm = "Axis of Symmetry",
    sinhalaTerm = "සමමිතික අක්ෂය",
    tamilTerm = "சமச்சீர் அச்சு",
    subject = "ගණිතය",
    definitionSinhala = "වර්ගජ ශ්‍රිතයක ප්‍රස්තාරය හරියටම දෙකට බෙදන සිරස් රේඛාව (x = -b / (2a)).",
    examTip = "හැරවුම් ලක්ෂ්‍යය සෑමවිටම සමමිතික අක්ෂය මත පිහිටයි."
  ),
  GlossaryTermItem(
    id = "mat_77",
    englishTerm = "Distance Formula",
    sinhalaTerm = "දුර සූත්‍රය",
    tamilTerm = "தூரச் சமன்பாடு",
    subject = "ගණිතය",
    definitionSinhala = "(x₁, y₁) සහ (x₂, y₂) ලක්ෂ්‍ය දෙකක් අතර සෘජු දුර = √[(x₂ - x₁)² + (y₂ - y₁)²].",
    examTip = "කාටීසීය තලයේ පයිතගරස් ප්‍රමේයය යෙදීමෙන් මෙම සූත්‍රය ව්‍යුත්පන්න කර ඇත."
  ),
  GlossaryTermItem(
    id = "mat_78",
    englishTerm = "Midpoint Formula",
    sinhalaTerm = "මධ්‍ය ලක්ෂ්‍ය සූත්‍රය",
    tamilTerm = "நடுப்புள்ளி சமன்பாடு",
    subject = "ගණිතය",
    definitionSinhala = "ලක්ෂ්‍ය දෙකක් යාකරන රේඛා ඛණ්ඩයේ මැද ලක්ෂ්‍යය = ((x₁ + x₂)/2 , (y₁ + y₂)/2).",
    examTip = "ඛණ්ඩාංකවල මධ්‍යන්‍යය ගැනීමෙන් මධ්‍ය ලක්ෂ්‍යය ලැබේ."
  ),
  GlossaryTermItem(
    id = "mat_79",
    englishTerm = "Quadratic Graph Roots",
    sinhalaTerm = "වර්ගජ ප්‍රස්තාරයක මූල",
    tamilTerm = "இருபடி வரைபின் மூலங்கள்",
    subject = "ගණිතය",
    definitionSinhala = "ප්‍රස්තාරය x අක්ෂය ඡේදනය කරන ලක්ෂ්‍යවල x ඛණ්ඩාංක (y = 0 වන අගයන්).",
    examTip = "ප්‍රස්තාරය x අක්ෂය ස්පර්ශ කරන්නේ නම් සමාන මූල පවතී."
  ),
  GlossaryTermItem(
    id = "mat_80",
    englishTerm = "Distance-Time Graph",
    sinhalaTerm = "දුර-කාල ප්‍රස්තාරය",
    tamilTerm = "தூர-நேர வரைபு",
    subject = "ගණිතය",
    definitionSinhala = "තිරස් අක්ෂයේ කාලයත් සිරස් අක්ෂයේ ගමන් කළ දුරත් දක්වන ප්‍රස්තාරය.",
    examTip = "දුර-කාල ප්‍රස්තාරයක අනුක්‍රමණයෙන් 'කථික වේගය' (Speed) ලැබේ."
  ),

  // GROUP 9 (81 - 90): සංඛ්‍යානය හා දත්ත නිරූපණය
  GlossaryTermItem(
    id = "mat_81",
    englishTerm = "Mean",
    sinhalaTerm = "මධ්‍යන්‍යය",
    tamilTerm = "இடை",
    subject = "ගණිතය",
    definitionSinhala = "දත්ත සියල්ලෙහි එකතුව එම දත්ත සංඛ්‍යාවෙන් බෙදූ විට ලැබෙන සාමාන්‍ය අගය (x̄ = Σfx / Σf).",
    examTip = "උපකල්පිත මධ්‍යන්‍ය ක්‍රමය: x̄ = A + (Σfd / Σf)."
  ),
  GlossaryTermItem(
    id = "mat_82",
    englishTerm = "Median",
    sinhalaTerm = "මධ්‍යස්ථය",
    tamilTerm = "இடையம்",
    subject = "ගණිතය",
    definitionSinhala = "ආරෝහණ හෝ අවරෝහණ පිළිවෙළට සකසන ලද දත්ත මාලාවක හරියටම මැද පිහිටි අගය.",
    examTip = "n ඔත්තේ නම් (n + 1)/2 වන පදය; n ඉරට්ටේ නම් මැද පද දෙකේ සාමාන්‍යය."
  ),
  GlossaryTermItem(
    id = "mat_83",
    englishTerm = "Mode",
    sinhalaTerm = "මාතය",
    tamilTerm = "ஆகாரம்",
    subject = "ගණිතය",
    definitionSinhala = "දත්ත සමූහයක වැඩිම වාර ගණනක් නැවත නැවත හමුවන (උපරිම සංඛ්‍යාතයක් ඇති) අගය.",
    examTip = "පන්ති ප්‍රාන්තර සහිත වගුවක වැඩිම සංඛ්‍යාතය ඇති පන්තිය 'මාත පන්තිය' වේ."
  ),
  GlossaryTermItem(
    id = "mat_84",
    englishTerm = "Range",
    sinhalaTerm = "පරාසය",
    tamilTerm = "வீச்சு",
    subject = "ගණිතය",
    definitionSinhala = "දත්ත සමූහයක විශාලතම අගය සහ කුඩාම අගය අතර වෙනස (පරාසය = උපරිම අගය - අවම අගය).",
    examTip = "දත්තවල විචලනය මනින සරලම මිණුමයි."
  ),
  GlossaryTermItem(
    id = "mat_85",
    englishTerm = "Cumulative Frequency",
    sinhalaTerm = "සමුච්චිත සංඛ්‍යාතය",
    tamilTerm = "திரள் மீடிறன்",
    subject = "ගණිතය",
    definitionSinhala = "යම් පන්ති ප්‍රාන්තරයක ඉහළ සීමාව දක්වා ඇති සියලුම සංඛ්‍යාතවල ක්‍රමික එකතුව.",
    examTip = "සමුච්චිත සංඛ්‍යාත වක්‍රය (Ogive) මඟින් මධ්‍යස්ථය සහ චතුර්ථක සෙවිය හැක."
  ),
  GlossaryTermItem(
    id = "mat_86",
    englishTerm = "Histogram",
    sinhalaTerm = "හිස්ටෝග්‍රෑමය (සංඛ්‍යාත ප්‍රස්තාරය)",
    tamilTerm = "மீடிறன் செவ்வகப்படம்",
    subject = "ගණිතය",
    definitionSinhala = "අඛණ්ඩ දත්තවල පන්ති ප්‍රාන්තර තිරස් අක්ෂයේද, සංඛ්‍යාතය සිරස් අක්ෂයේද දක්වන යාබද සෘජුකෝණාස්‍ර රූපය.",
    examTip = "තීරු ප්‍රස්ථාර මෙන් නොව, හිස්ටෝග්‍රෑමයේ තීරු අතර හිඩැස් නැත."
  ),
  GlossaryTermItem(
    id = "mat_87",
    englishTerm = "Frequency Polygon",
    sinhalaTerm = "සංඛ්‍යාත බහුඅස්‍රය",
    tamilTerm = "மீடிறன் பல்கோணி",
    subject = "ගණිතය",
    definitionSinhala = "හිස්ටෝග්‍රෑමයක එක් එක් තීරුවේ ඉහළ මැද ලක්ෂ්‍යයන් සරල රේඛාවලින් යාකිරීමෙන් ලැබෙන සංවෘත බහුඅස්‍රය.",
    examTip = "ආරම්භයේ සහ අවසානයේ ශුන්‍ය සංඛ්‍යාතයක් සහිත මනඃකල්පිත පන්ති දෙකක් එක්කර තිරසට යා කරයි."
  ),
  GlossaryTermItem(
    id = "mat_88",
    englishTerm = "Pie Chart",
    sinhalaTerm = "වට ප්‍රස්තාරය",
    tamilTerm = "வட்ட வரைபு",
    subject = "ගණිතය",
    definitionSinhala = "මුළු දත්ත 360° ක කේන්ද්‍රික ඛණ්ඩවල කෝණ ලෙස අනුපාතිකව නිරූපණය කරන වෘත්තාකාර ප්‍රස්ථාරය.",
    examTip = "කේන්ද්‍ර කෝණය = (අදාළ ප්‍රමාණය / මුළු ප්‍රමාණය) × 360°."
  ),
  GlossaryTermItem(
    id = "mat_89",
    englishTerm = "Interquartile Range (IQR)",
    sinhalaTerm = "අන්තශ්චතුර්ථක පරාසය",
    tamilTerm = "இடைக்கால்வீச்சு",
    subject = "ගණිතය",
    definitionSinhala = "ඉහළ චතුර්ථකය (Q₃) සහ පහළ චතුර්ථකය (Q₁) අතර වෙනස (IQR = Q₃ - Q₁).",
    examTip = "දත්තවල මැද 50% විසිරී ඇති ආකාරය මැනීමට යොදා ගනී."
  ),
  GlossaryTermItem(
    id = "mat_90",
    englishTerm = "Assumed Mean",
    sinhalaTerm = "උපකල්පිත මධ්‍යන්‍යය",
    tamilTerm = "ஊகித்த இடை",
    subject = "ගණිතය",
    definitionSinhala = "ගණනය කිරීම් පහසු කිරීම සඳහා දත්තවල මැද අගයකට ආසන්නව තෝරාගනු ලබන උපකල්පිත අගය (A).",
    examTip = "අපගමනය d = x - A මඟින් ගණනය කෙරේ."
  ),

  // GROUP 10 (91 - 100): සම්භාවිතාව හා කුලක
  GlossaryTermItem(
    id = "mat_91",
    englishTerm = "Sample Space (S)",
    sinhalaTerm = "නියැදි අවකාශය",
    tamilTerm = "மாதிரி வெளி",
    subject = "ගණිතය",
    definitionSinhala = "අහඹු පරීක්ෂණයකදී සිදුවිය හැකි සියලුම ප්‍රථිඵලවල කුලකය.",
    examTip = "සාධාරණ දාදු කැටයක් පෙරළීමේදී S = {1, 2, 3, 4, 5, 6}, n(S) = 6."
  ),
  GlossaryTermItem(
    id = "mat_92",
    englishTerm = "Probability of an Event",
    sinhalaTerm = "සිද්ධියක සම්භාවිතාව",
    tamilTerm = "நிகழ்ச்சியின் நிகழ்தகவு",
    subject = "ගණිතය",
    definitionSinhala = "P(A) = වාසිදායක ප්‍රතිඵල ගණන n(A) / මුළු ප්‍රතිඵල ගණන n(S).",
    examTip = "සම්භාවිතාව සෑමවිටම 0 සහ 1 අතර පවතී (0 ≤ P(A) ≤ 1)."
  ),
  GlossaryTermItem(
    id = "mat_93",
    englishTerm = "Mutually Exclusive Events",
    sinhalaTerm = "පරස්පර විරෝධී සිද්ධි",
    tamilTerm = "ஒன்றையொன்று விலக்கும் நிகழ்ச்சிகள்",
    subject = "ගණිතය",
    definitionSinhala = "එකවර සිදුවිය නොහැකි, පොදු ප්‍රතිඵල රහිත සිද්ධි දෙකක් (A ∩ B = ∅).",
    examTip = "P(A ∪ B) = P(A) + P(B)."
  ),
  GlossaryTermItem(
    id = "mat_94",
    englishTerm = "Independent Events",
    sinhalaTerm = "ස්වාධීන සිද්ධි",
    tamilTerm = "சாரா நிகழ்ச்சிகள்",
    subject = "ගණිතය",
    definitionSinhala = "එක් සිද්ධියක් සිදුවීම අනෙක් සිද්ධිය සිදුවීමේ සම්භාවිතාවට කිසිදු බලපෑමක් නොකරන සිද්ධි.",
    examTip = "P(A ∩ B) = P(A) × P(B)."
  ),
  GlossaryTermItem(
    id = "mat_95",
    englishTerm = "Tree Diagram",
    sinhalaTerm = "රුක් සටහන",
    tamilTerm = "மர வரைபடம்",
    subject = "ගණිතය",
    definitionSinhala = "අනුක්‍රමික සිද්ධිවල සියලුම ප්‍රතිඵල සහ අදාළ සම්භාවිතාවන් අතු බෙදී යන අයුරින් දැක්වෙන රූප සටහන.",
    examTip = "එක් අතු පේළියක සම්භාවිතාවන්හි එකතුව සෑමවිටම 1 ක් වේ."
  ),
  GlossaryTermItem(
    id = "mat_96",
    englishTerm = "Universal Set (ε)",
    sinhalaTerm = "සර්වත්‍ර කුලකය",
    tamilTerm = "அகில தொடை",
    subject = "ගණිතය",
    definitionSinhala = "කිසියම් සාකච්ඡාවකට හෝ ගැටලුවකට අදාළ විය හැකි සියලුම මූලද්‍රව්‍ය අඩංගු මූලික කුලකය.",
    examTip = "වෙන් රූප සටහනක සෘජුකෝණාස්‍රයෙන් නිරූපණය කරන්නේ සර්වත්‍ර කුලකයයි."
  ),
  GlossaryTermItem(
    id = "mat_97",
    englishTerm = "Intersection of Sets (∩)",
    sinhalaTerm = "කුලක ඡේදනය",
    tamilTerm = "தொடை இடைவெட்டு",
    subject = "ගණිතය",
    definitionSinhala = "කුලක දෙකටම පොදු වූ මූලද්‍රව්‍ය පමණක් අඩංගු කුලකය (A ∩ B).",
    examTip = "වෙන් රූපයේ රවුම් දෙක එකිනෙක අතිච්ඡාදනය වන මැද ප්‍රදේශයයි."
  ),
  GlossaryTermItem(
    id = "mat_98",
    englishTerm = "Union of Sets (∪)",
    sinhalaTerm = "කුලක මේලය",
    tamilTerm = "தொடை ஒன்றிப்பு",
    subject = "ගණිතය",
    definitionSinhala = "කුලක දෙකෙහි ඇති සියලුම මූලද්‍රව්‍ය එක්වරක් පමණක් ලියා සාදනු ලබන ඒකාබද්ධ කුලකය (A ∪ B).",
    examTip = "n(A ∪ B) = n(A) + n(B) - n(A ∩ B)."
  ),
  GlossaryTermItem(
    id = "mat_99",
    englishTerm = "Complement of a Set (A')",
    sinhalaTerm = "කුලකයක අනුපූරකය",
    tamilTerm = "நிரப்புத் தொடை",
    subject = "ගණිතය",
    definitionSinhala = "සර්වත්‍ර කුලකයට අයත් නමුත් A කුලකයට අයත් නොවන සියලුම මූලද්‍රව්‍යවල කුලකය.",
    examTip = "n(A) + n(A') = n(ε) සහ P(A) + P(A') = 1."
  ),
  GlossaryTermItem(
    id = "mat_100",
    englishTerm = "Venn Diagram",
    sinhalaTerm = "වෙන් රූප සටහන",
    tamilTerm = "வென் வரைபடம்",
    subject = "ගණිතය",
    definitionSinhala = "කුලක අතර සම්බන්ධතා සහ ඒවායේ මූලද්‍රව්‍ය දෘශ්‍යමානව පෙන්වීම සඳහා ජෝන් වෙන් විසින් හඳුන්වා දුන් ජ්‍යාමිතික සටහන් ක්‍රමය.",
    examTip = "O/L විභාගයේ දෙවන පත්‍රයේ අනිවාර්ය පළමු ප්‍රශ්න කොටස සඳහා නිතර පැමිණේ."
  )
)
