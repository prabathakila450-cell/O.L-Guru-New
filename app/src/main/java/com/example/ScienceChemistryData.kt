package com.example

/**
 * 100% Complete Grade 10 & 11 Science Syllabus - Chemistry Equations & Formulas
 * Covers every unit: Chemical reactions, balancing, types of reactions,
 * acids, bases, salts, electrochemistry, hydrocarbons, blast furnace, industrial chemistry.
 */
object ScienceChemistryData {
  val items = listOf(
    // ==========================================
    // GRADE 10 CHEMISTRY
    // ==========================================
    ScienceChemItem(
      id = "chem_10_01",
      grade = "10",
      title = "මැග්නීසියම් වාතයේ දහනය",
      category = "තුලනය කිරීම",
      reactantsSinhala = "මැග්නීසියම් පීත්තක් වාතයේ (ඔක්සිජන්) දැල්වී මැග්නීසියම් ඔක්සයිඩ් සෑදීම",
      unbalancedEquation = "Mg + O₂ ➔ MgO",
      balancedEquation = "2Mg + O₂ ➔ 2MgO",
      explanation = "වම් පස O පරමාණු 2ක් ඇති බැවින් දකුණු පස MgO ඉදිරියට 2 යොදයි. එවිට Mg පරමාණු 2ක් වන බැවින් වම්පස Mg ඉදිරියට 2 යොදයි.",
      keyPoints = listOf("දීප්තිමත් සුදු දැල්ලකින් දැවේ", "සුදු පැහැති භස්මීය අළු (MgO) සාදයි", "සංයෝජන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_02",
      grade = "10",
      title = "හුණුගල් අම්ල සමඟ ප්‍රතික්‍රියාව",
      category = "තුලනය කිරීම",
      reactantsSinhala = "කැල්සියම් කාබනේට් (CaCO₃) තනුක HCl සමඟ ප්‍රතික්‍රියා කර ලවණය, ජලය සහ CO₂ නිපදවීම",
      unbalancedEquation = "CaCO₃ + HCl ➔ CaCl₂ + CO₂ + H₂O",
      balancedEquation = "CaCO₃ + 2HCl ➔ CaCl₂ + CO₂ + H₂O",
      explanation = "දකුණු පස Cl පරමාණු 2ක් ඇති බැවින් වම්පස HCl ඉදිරියට 2 යොදයි. දෙපසම Ca=1, C=1, O=3, H=2, Cl=2 ලෙස තුලිත වේ.",
      keyPoints = listOf("CO₂ වායුව පිටවේ (හුණුදියර කිරි පැහැ කරයි)", "වේගවත් බුබුළු දැමීමක් නිරීක්ෂණය වේ", "ලවණයක්, වායුවක් සහ ජලය ලැබේ")
    ),
    ScienceChemItem(
      id = "chem_10_03",
      grade = "10",
      title = "සෝඩියම් ජලය සමඟ ප්‍රතික්‍රියාව",
      category = "ප්‍රතික්‍රියා වර්ගය",
      reactantsSinhala = "සෝඩියම් ලෝහය සීතල ජලය සමඟ ක්ෂණිකව ප්‍රතික්‍රියා කර NaOH සහ H₂ වායුව නිපදවීම",
      unbalancedEquation = "Na + H₂O ➔ NaOH + H₂",
      balancedEquation = "2Na + 2H₂O ➔ 2NaOH + H₂",
      explanation = "H පරමාණු තුලනය කිරීමට H₂O ඉදිරියට 2 සහ NaOH ඉදිරියට 2 යොදයි. ඉන්පසු Na ඉදිරියට 2 යොදයි.",
      keyPoints = listOf("තීව්‍ර තාපදායක ප්‍රතික්‍රියාවකි; Na ජලය මත පා වී ගිනිබෝලයක් සේ චලනය වේ", "හයිඩ්‍රජන් වායුව පිටවේ ('පොප්' හඬින් දැල්වේ)", "ද්‍රාවණය භස්මීය වේ (රතු ලිට්මස් නිල් වේ)")
    ),
    ScienceChemItem(
      id = "chem_10_04",
      grade = "10",
      title = "යකඩ සහ සල්ෆර් සංයෝජනය",
      category = "සූත්‍ර ලිවීම",
      reactantsSinhala = "යකඩ කුඩු සහ සල්ෆර් කුඩු මිශ්‍රණය රත් කිරීමෙන් අයන්(II) සල්ෆයිඩ් සෑදීම",
      unbalancedEquation = "Fe + S ➔ FeS",
      balancedEquation = "Fe + S ➔ FeS",
      explanation = "යකඩ සංයුජතාව 2 සහ සල්ෆර් සංයුජතාව 2 වේ. සංයුජතා හුවමාරු කළ විට FeS සෑදේ. සමීකරණය ස්වයංක්‍රීයව තුලිතය.",
      keyPoints = listOf("කළු පැහැති ඝන FeS සෑදේ", "චුම්භකයකට ආකර්ෂණය නොවේ (සංයෝගයක් සෑදී ඇති බැවින්)", "තාපදායක සංයෝජන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_05",
      grade = "10",
      title = "කාබන් පූර්ණ දහනය",
      category = "දහනය",
      reactantsSinhala = "කාබන් වාතයේ ඇති ඔක්සිජන් සමඟ පූර්ණව දහනය වී CO₂ සෑදීම",
      unbalancedEquation = "C + O₂ ➔ CO₂",
      balancedEquation = "C + O₂ ➔ CO₂",
      explanation = "දෙපසම කාබන් 1 බැගින් සහ ඔක්සිජන් 2 බැගින් ඇති බැවින් සමීකරණය තුලිතය.",
      keyPoints = listOf("තාපදායක ප්‍රතික්‍රියාවකි", "කාබන් ඩයොක්සයිඩ් වායුව නිපදවේ", "වායුව හුණුදියර කිරි පැහැ කරයි")
    ),
    ScienceChemItem(
      id = "chem_10_06",
      grade = "10",
      title = "H₂ වායුව විද්‍යාගාරයේ පිළියෙල කිරීම",
      category = "තුලනය කිරීම",
      reactantsSinhala = "සින්ක් ලෝහ කැබලි තනුක සල්ෆියුරික් අම්ලය (H₂SO₄) සමඟ ප්‍රතික්‍රියාව",
      unbalancedEquation = "Zn + H₂SO₄ ➔ ZnSO₄ + H₂",
      balancedEquation = "Zn + H₂SO₄ ➔ ZnSO₄ + H₂",
      explanation = "ක්‍රියාකාරීත්ව ශ්‍රේණියේ H ට ඉහළින් ඇති සින්ක් මඟින් අම්ලයේ H විස්ථාපනය කරයි.",
      keyPoints = listOf("හයිඩ්‍රජන් වායුව ජලයේ යටි විස්ථාපනයෙන් එකතු කරයි", "වායුව ගිනිදැල්ලකට ඇල්ලූ විට 'පොප්' හඬින් දැවේ", "ඒකීය විස්ථාපන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_07",
      grade = "10",
      title = "පොටෑසියම් පර්මැන්ගනේට් තාප වියෝජනය",
      category = "තාප වියෝජනය",
      reactantsSinhala = "ඝන KMnO₄ පරීක්ෂා නළයක දමා රත් කිරීමෙන් O₂ වායුව පිළියෙල කිරීම",
      unbalancedEquation = "KMnO₄ ➔ K₂MnO₄ + MnO₂ + O₂",
      balancedEquation = "2KMnO₄ ➔ K₂MnO₄ + MnO₂ + O₂",
      explanation = "වම්පස KMnO₄ ඉදිරියට 2 යෙදූ විට K=2, Mn=2, O=8 දෙපසම තුලනය වේ.",
      keyPoints = listOf("ඔක්සිජන් වායුව නිපදවේ (දිලිසෙන පුලිඟුවක් දැල්වීමට සමත් වේ)", "දම් පැහැති කුඩු කළු පැහැයට හැරේ", "වියෝජන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_08",
      grade = "10",
      title = "තඹ කාබනේට් තාප වියෝජනය",
      category = "තාප වියෝජනය",
      reactantsSinhala = "කොළ පැහැති CuCO₃ රත් කිරීමෙන් කළු CuO සහ CO₂ සෑදීම",
      unbalancedEquation = "CuCO₃ ➔ CuO + CO₂",
      balancedEquation = "CuCO₃ ➔ CuO + CO₂",
      explanation = "දෙපසම Cu=1, C=1, O=3 බැගින් ඇති බැවින් ස්වයංක්‍රීයව තුලිතය.",
      keyPoints = listOf("කොළ පැහැති කුඩු කළු පැහැයට හැරේ", "පිටවන වායුව හුණුදියර කිරි පැහැ කරයි", "තාප වියෝජන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_09",
      grade = "10",
      title = "ඊයම් නයිට්‍රේට් තාප වියෝජනය",
      category = "තාප වියෝජනය",
      reactantsSinhala = "Pb(NO₃)₂ ස්ඵටික රත් කිරීමෙන් PbO, NO₂ සහ O₂ සෑදීම",
      unbalancedEquation = "Pb(NO₃)₂ ➔ PbO + NO₂ + O₂",
      balancedEquation = "2Pb(NO₃)₂ ➔ 2PbO + 4NO₂ + O₂",
      explanation = "O පරමාණු සහ N පරමාණු තුලනය කිරීමට Pb(NO₃)₂ ඉදිරියට 2, PbO ඉදිරියට 2, NO₂ ඉදිරියට 4 යොදයි.",
      keyPoints = listOf("දුඹුරු පැහැති විෂ සහිත NO₂ වායුවක් පිටවේ", "රත්වීමේදී කහ පැහැති PbO අවශේෂයක් ඉතිරි වේ", "පුලිඟුවක් දල්වන ඔක්සිජන් වායුවද නිපදවේ")
    ),
    ScienceChemItem(
      id = "chem_10_10",
      grade = "10",
      title = "සෝඩියම් බයිකාබනේට් තාප වියෝජනය",
      category = "තාප වියෝජනය",
      reactantsSinhala = "බේකිං සෝඩා (NaHCO₃) රත් කිරීමෙන් Na₂CO₃, H₂O සහ CO₂ සෑදීම",
      unbalancedEquation = "NaHCO₃ ➔ Na₂CO₃ + H₂O + CO₂",
      balancedEquation = "2NaHCO₃ ➔ Na₂CO₃ + H₂O + CO₂",
      explanation = "වම්පස NaHCO₃ ඉදිරියට 2 යෙදූ විට සියලු පරමාණු (Na=2, H=2, C=2, O=6) තුලනය වේ.",
      keyPoints = listOf("කේක් හා බේකරි නිෂ්පාදන පිපිරවීමට යොදාගනී", "පිටවන CO₂ බුබුළු මඟින් කුහර සාදයි", "වියෝජන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_11",
      grade = "10",
      title = "මැග්නීසියම් අම්ල සමඟ ප්‍රතික්‍රියාව",
      category = "තුලනය කිරීම",
      reactantsSinhala = "මැග්නීසියම් ලෝහය තනුක HCl සමඟ ප්‍රතික්‍රියා කර MgCl₂ සහ H₂ සාදයි",
      unbalancedEquation = "Mg + HCl ➔ MgCl₂ + H₂",
      balancedEquation = "Mg + 2HCl ➔ MgCl₂ + H₂",
      explanation = "දකුණු පස Cl=2 සහ H=2 බැවින් වම් පස HCl ඉදිරියට 2 යොදයි.",
      keyPoints = listOf("ඉතා වේගයෙන් හයිඩ්‍රජන් බුබුළු පිටවේ", "පරීක්ෂා නළය දැඩි ලෙස රත්වේ (තාපදායක)", "ලෝහය සම්පූර්ණයෙන්ම දියවී යයි")
    ),
    ScienceChemItem(
      id = "chem_10_12",
      grade = "10",
      title = "හුණුදියර කිරි පැහැ වීම සහ අවර්ණ වීම",
      category = "අවක්ෂේපනය",
      reactantsSinhala = "කැල්සියම් හයිඩ්‍රොක්සයිඩ් ද්‍රාවණයට CO₂ යැවීමෙන් නොදියෙන CaCO₃ අවක්ෂේප වීම",
      unbalancedEquation = "Ca(OH)₂ + CO₂ ➔ CaCO₃ + H₂O",
      balancedEquation = "Ca(OH)₂ + CO₂ ➔ CaCO₃↓ + H₂O",
      explanation = "දෙපසම Ca=1, C=1, O=4, H=2 බැවින් තුලිතය. වැඩිදුරටත් CO₂ යැවූ විට දියවන Ca(HCO₃)₂ සෑදී අවර්ණ වේ.",
      keyPoints = listOf("සුදු පැහැති කිරි පාටක් ලැබේ (CaCO₃ සුදු අවක්ෂේපය)", "CO₂ වායුව හඳුනාගැනීමේ සම්මත පරීක්ෂාවයි", "වැඩිදුරටත් යැවූ විට නැවත අවර්ණ වේ")
    ),
    ScienceChemItem(
      id = "chem_10_13",
      grade = "10",
      title = "ඇලුමිනියම් ඔක්සිකරණය",
      category = "තුලනය කිරීම",
      reactantsSinhala = "ඇලුමිනියම් ලෝහය වාතයේ ඔක්සිජන් සමඟ සංයෝජනය වී ආරක්ෂිත Al₂O₃ ස්ථරය සෑදීම",
      unbalancedEquation = "Al + O₂ ➔ Al₂O₃",
      balancedEquation = "4Al + 3O₂ ➔ 2Al₂O₃",
      explanation = "O පරමාණු තුලනය කිරීමට 3O₂ සහ 2Al₂O₃ යොදයි. ඉන්පසු වම්පස Al ඉදිරියට 4 යොදයි.",
      keyPoints = listOf("තුනී ආරක්ෂිත ඇලුමිනා ආවරණයක් සාදයි", "ඇලුමිනියම් තවදුරටත් විඛාදනය වීම වළක්වයි", "සංයෝජන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_14",
      grade = "10",
      title = "ජලය විද්‍යුත් විච්ඡේදනය",
      category = "විද්‍යුත් රසායනය",
      reactantsSinhala = "අම්ලිකෘත ජලය හරහා විදුලිය යැවීමෙන් H₂ සහ O₂ වායු නිදහස් වීම",
      unbalancedEquation = "H₂O ➔ H₂ + O₂",
      balancedEquation = "2H₂O ➔ 2H₂ + O₂",
      explanation = "වම්පස H₂O ඉදිරියට 2 සහ H₂ ඉදිරියට 2 යෙදූ විට O පරමාණු 2ක් හා H පරමාණු 4ක් දෙපසම තුලනය වේ.",
      keyPoints = listOf("කැතෝඩයේදී H₂ වායුවත්, ඇනෝඩයේදී O₂ වායුවත් ලැබේ", "පරිමා අනුපාතය H₂ : O₂ = 2 : 1 වේ", "විද්‍යුත් වියෝජන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_10_15",
      grade = "10",
      title = "බේරියම් ක්ලෝරයිඩ් සහ සෝඩියම් සල්ෆේට් අවක්ෂේපනය",
      category = "ද්විත්ව විස්ථාපනය",
      reactantsSinhala = "BaCl₂ ද්‍රාවණය Na₂SO₄ ද්‍රාවණය සමඟ මුසු කිරීමෙන් සුදු BaSO₄ අවක්ෂේපය සෑදීම",
      unbalancedEquation = "BaCl₂ + Na₂SO₄ ➔ BaSO₄ + NaCl",
      balancedEquation = "BaCl₂ + Na₂SO₄ ➔ BaSO₄↓ + 2NaCl",
      explanation = "දකුණු පස NaCl ඉදිරියට 2 යෙදූ විට සියලු පරමාණු තුලනය වේ.",
      keyPoints = listOf("ක්ෂණික ඝන සුදු අවක්ෂේපයක් ලැබේ", "සල්ෆේට් අයන (SO₄²⁻) හඳුනාගැනීමට යොදාගනී", "අම්ලවල දිය නොවේ")
    ),
    ScienceChemItem(
      id = "chem_10_16",
      grade = "10",
      title = "හයිඩ්‍රජන් පෙරොක්සයිඩ් වියෝජනය",
      category = "උත්ප්‍රේරණය",
      reactantsSinhala = "H₂O₂ ද්‍රාවණය මැන්ගනීස් ඩයොක්සයිඩ් (MnO₂) උත්ප්‍රේරකය හමුවේ වියෝජනය",
      unbalancedEquation = "H₂O₂ ➔ H₂O + O₂",
      balancedEquation = "2H₂O₂ ➔ 2H₂O + O₂  [උත්ප්‍රේරක MnO₂]",
      explanation = "වම්පස H₂O₂ ඉදිරියට 2 සහ H₂O ඉදිරියට 2 දැමූ විට O=4 සහ H=4 දෙපසම තුලනය වේ.",
      keyPoints = listOf("විද්‍යාගාරයේ ඔක්සිජන් පිළියෙල කිරීමට තාපය නොමැතිව යොදාගත හැක", "MnO₂ කළු කුඩු උත්ප්‍රේරකයකි (වෙනස් නොවී පවතී)", "වේගවත් බුබුළු දැමීමක් සිදුවේ")
    ),

    // ==========================================
    // GRADE 11 CHEMISTRY
    // ==========================================
    ScienceChemItem(
      id = "chem_11_01",
      grade = "11",
      title = "යකඩ මලකෑම (Rusting of Iron)",
      category = "විද්‍යුත් රසායනය",
      reactantsSinhala = "යකඩ ජලය සහ ඔක්සිජන් හමුවේ මල බැඳීම (ජලීය අයන්(III) ඔක්සයිඩ් සෑදීම)",
      unbalancedEquation = "Fe + O₂ + xH₂O ➔ Fe₂O₃·xH₂O",
      balancedEquation = "4Fe + 3O₂ + 2xH₂O ➔ 2(Fe₂O₃·xH₂O)",
      explanation = "යකඩ ඔක්සිකරණය වී Fe³⁺ සාදන අතර ඔක්සිජන් ඔක්සිහරණය වේ. මලකෑම සඳහා O₂ සහ ජලය අනිවාර්ය වේ.",
      keyPoints = listOf("රතු-දුඹුරු පැහැ කුඩු සහිත මලකඩ සෑදේ", "විද්‍යුත් රසායනික ක්‍රියාවලියකි", "ගැල්වනයිස් කිරීමෙන් (සින්ක් ආලේපනය) වළක්වයි")
    ),
    ScienceChemItem(
      id = "chem_11_02",
      grade = "11",
      title = "ලෝහ විස්ථාපනය (CuSO₄ + Zn)",
      category = "තුලනය කිරීම",
      reactantsSinhala = "තඹ(II) සල්ෆේට් ද්‍රාවණයකට සින්ක් ලෝහ කැබැල්ලක් දැමීම",
      unbalancedEquation = "Zn + CuSO₄ ➔ ZnSO₄ + Cu",
      balancedEquation = "Zn + CuSO₄ ➔ ZnSO₄ + Cu",
      explanation = "ක්‍රියාකාරීත්ව ශ්‍රේණියේ තඹට වඩා සින්ක් ඉහළින් පිහිටන බැවින් Cu²⁺ විස්ථාපනය කරයි.",
      keyPoints = listOf("නිල් පැහැ CuSO₄ ද්‍රාවණය අවර්ණ වේ", "සින්ක් මත රතු දුඹුරු තඹ තැන්පත් වේ", "ඒකීය විස්ථාපන ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_11_03",
      grade = "11",
      title = "අම්ල-භස්ම උදාසීනීකරණය (HCl + NaOH)",
      category = "උදාසීනීකරණය",
      reactantsSinhala = "හයිඩ්‍රොක්ලෝරික් අම්ලය සහ සෝඩියම් හයිඩ්‍රොක්සයිඩ් උදාසීන වීම",
      unbalancedEquation = "HCl + NaOH ➔ NaCl + H₂O",
      balancedEquation = "HCl + NaOH ➔ NaCl + H₂O",
      explanation = "H⁺(aq) + OH⁻(aq) ➔ H₂O(l) යනු ශුද්ධ අයනික සමීකරණයයි. උදාසීන ලවණයක් හා ජලය සාදයි.",
      keyPoints = listOf("තාපදායක ප්‍රතික්‍රියාවකි", "pH අගය 7 දක්වා ළඟාවේ", "ද්විත්ව විස්ථාපනයකි")
    ),
    ScienceChemItem(
      id = "chem_11_04",
      grade = "11",
      title = "සෛලීය ශ්වසනය (පූර්ණ ඔක්සිකරණය)",
      category = "ජෛව රසායනය",
      reactantsSinhala = "ග්ලූකෝස් සෛල තුළ ඔක්සිජන් සමඟ බිඳවැටී ශක්තිය මුදාහැරීම",
      unbalancedEquation = "C₆H₁₂O₆ + O₂ ➔ CO₂ + H₂O + ශක්තිය",
      balancedEquation = "C₆H₁₂O₆ + 6O₂ ➔ 6CO₂ + 6H₂O + 38 ATP",
      explanation = "C පරමාණු 6ක් ඇති බැවින් 6CO₂, H පරමාණු 12ක් බැවින් 6H₂O, O පරමාණු තුලනයට 6O₂ යොදයි.",
      keyPoints = listOf("සෛලයේ මයිටොකොන්ඩ්‍රියා තුළ සිදුවේ", "වායුගෝලීය ඔක්සිජන් උපයෝගී කරගනී", "ජීවීන්ට අවශ්‍ය ATP ශක්තිය සපයයි")
    ),
    ScienceChemItem(
      id = "chem_11_05",
      grade = "11",
      title = "ප්‍රභාසංස්ලේෂණය (Photosynthesis)",
      category = "ජෛව රසායනය",
      reactantsSinhala = "කාබන් ඩයොක්සයිඩ් සහ ජලය සූර්යාලෝකය හමුවේ ග්ලූකෝස් සහ ඔක්සිජන් බවට පත්වීම",
      unbalancedEquation = "CO₂ + H₂O ➔ C₆H₁₂O₆ + O₂",
      balancedEquation = "6CO₂ + 6H₂O ➔ C₆H₁₂O₆ + 6O₂",
      explanation = "ශාක පත්‍රවල ක්ලෝරෆිල් මඟින් සූර්ය ශක්තිය රසායනික ශක්තිය බවට පරිවර්තනය කරයි.",
      keyPoints = listOf("පෘථිවියේ ප්‍රධාන ආහාර නිෂ්පාදන ක්‍රියාවලියයි", "ඔක්සිජන් වායුව අතුරු ඵලයක් ලෙස නිදහස් කරයි", "තාප අවශෝෂක ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_11_06",
      grade = "11",
      title = "ධමන ඌෂ්මකයේ යකඩ ඔක්සිහරණය",
      category = "ලෝහ නිස්සාරණය",
      reactantsSinhala = "හෙමටයිට් (Fe₂O₃) කාබන් මොනොක්සයිඩ් මඟින් යකඩ බවට ඔක්සිහරණය වීම",
      unbalancedEquation = "Fe₂O₃ + CO ➔ Fe + CO₂",
      balancedEquation = "Fe₂O₃ + 3CO ➔ 2Fe + 3CO₂",
      explanation = "CO වායුව ප්‍රබල ඔක්සිහාරකයක් ලෙස ක්‍රියා කර Fe₂O₃ වෙතින් ඔක්සිජන් ඉවත් කරයි.",
      keyPoints = listOf("ධමන ඌෂ්මකයේ මැද කලාපයේ සිදුවේ", "දියවූ යකඩ ඌෂ්මක පතුලේ එකතු වේ", "ප්‍රධාන ලෝපස හෙමටයිට් වේ")
    ),
    ScienceChemItem(
      id = "chem_11_07",
      grade = "11",
      title = "ධමන ඌෂ්මකයේ ලෝහ බොර සෑදීම",
      category = "ලෝහ නිස්සාරණය",
      reactantsSinhala = "හුණුගල් වියෝජනයෙන් ලැබෙන CaO සිලිකා (SiO₂) අපද්‍රව්‍ය ඉවත් කිරීම",
      unbalancedEquation = "CaO + SiO₂ ➔ CaSiO₃",
      balancedEquation = "CaO + SiO₂ ➔ CaSiO₃",
      explanation = "භස්මීය CaO, ආම්ලික SiO₂ අපද්‍රව්‍ය සමඟ ප්‍රතික්‍රියා කර අඩු ඝනත්වයකින් යුත් CaSiO₃ (ලෝහ බොර) සාදයි.",
      keyPoints = listOf("ලෝහ බොර දියවූ යකඩ මත පා වේ", "යකඩ ඔක්සිකරණය වීම වළක්වයි", "පහසුවෙන් ඉවත් කරගත හැක")
    ),
    ScienceChemItem(
      id = "chem_11_08",
      grade = "11",
      title = "මීතේන් වායුව දහනය",
      category = "හයිඩ්‍රොකාබන",
      reactantsSinhala = "ස්වාභාවික වායුවේ ප්‍රධාන සංඝටකය වන මීතේන් පූර්ණ දහනය",
      unbalancedEquation = "CH₄ + O₂ ➔ CO₂ + H₂O",
      balancedEquation = "CH₄ + 2O₂ ➔ CO₂ + 2H₂O",
      explanation = "C පරමාණු 1, H පරමාණු 4 බැවින් 2H₂O, දෙපස O පරමාණු 4ක් තුලනය කිරීමට 2O₂ යොදයි.",
      keyPoints = listOf("නිල් පැහැති දුම් රහිත දැල්ලකින් දැවේ", "ඉහළ තාප ශක්තියක් නිපදවයි", "ජෛව වායුවේ (Biogas) ප්‍රධාන වායුවයි")
    ),
    ScienceChemItem(
      id = "chem_11_09",
      grade = "11",
      title = "එතනෝල් පූර්ණ දහනය",
      category = "කාබනික රසායනය",
      reactantsSinhala = "එතිල් ඇල්කොහොල් වාතයේ දහනය වී CO₂ සහ ජල වාෂ්ප සෑදීම",
      unbalancedEquation = "C₂H₅OH + O₂ ➔ CO₂ + H₂O",
      balancedEquation = "C₂H₅OH + 3O₂ ➔ 2CO₂ + 3H₂O",
      explanation = "C පරමාණු 2ක් බැවින් 2CO₂, H පරමාණු 6ක් බැවින් 3H₂O, O පරමාණු 7ක් තුලනය කිරීමට 3O₂ යොදයි.",
      keyPoints = listOf("ස්ප්‍රීතු ලාම්පුවල ඉන්ධනයක් ලෙස භාවිතා කරයි", "පිරිසිදු දැල්ලක් ලබාදේ", "තාපදායක ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_11_10",
      grade = "11",
      title = "හැලජන විස්ථාපනය (Cl₂ + KBr)",
      category = "විස්ථාපනය",
      reactantsSinhala = "පොටෑසියම් බ්‍රෝමයිඩ් ද්‍රාවණයකට ක්ලෝරීන් වායුව යැවීමෙන් බ්‍රෝමීන් විස්ථාපනය",
      unbalancedEquation = "Cl₂ + KBr ➔ KCl + Br₂",
      balancedEquation = "Cl₂ + 2KBr ➔ 2KCl + Br₂",
      explanation = "ක්ලෝරීන් වඩා ක්‍රියාකාරී හැලජනයක් බැවින් KBr ද්‍රාවණයෙන් බ්‍රෝමීන් විස්ථාපනය කර රතු-දුඹුරු බ්‍රෝමීන් නිදහස් කරයි.",
      keyPoints = listOf("අවර්ණ ද්‍රාවණය රතු-දුඹුරු පැහැයට හැරේ", "හැලජන කාණ්ඩයේ ක්‍රියාකාරීත්වය පෙන්වයි", "ඔක්සිකරණ-ඔක්සිහරණ ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_11_11",
      grade = "11",
      title = "එස්ටරීකරණ ප්‍රතික්‍රියාව",
      category = "කාබනික රසායනය",
      reactantsSinhala = "එතනොයික් අම්ලය සහ එතනෝල් සාන්ද්‍ර H₂SO₄ හමුවේ ප්‍රතික්‍රියා කර එතිල් එතනොයෙට් සෑදීම",
      unbalancedEquation = "CH₃COOH + C₂H₅OH ➔ CH₃COOC₂H₅ + H₂O",
      balancedEquation = "CH₃COOH + C₂H₅OH ⇌ CH₃COOC₂H₅ + H₂O  [සාන්ද්‍ර H₂SO₄]",
      explanation = "කාබොක්සිලික් අම්ලයක සහ ඇල්කොහොලයක ප්‍රතික්‍රියාවෙන් එස්ටරයක් හා ජලය සෑදේ. සාන්ද්‍ර H₂SO₄ නිර්ජලකාරකයක් ලෙස ක්‍රියා කරයි.",
      keyPoints = listOf("මිහිරි පලතුරු සුවඳක් හමයි", "කෘත්‍රිම රසකාරක හා සුවඳ විලවුන් සඳහා යොදාගනී", "ප්‍රතිවර්ත්‍ය ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_11_12",
      grade = "11",
      title = "එතීන් (එතිලීන්) දහනය",
      category = "හයිඩ්‍රොකාබන",
      reactantsSinhala = "අසංතෘප්ත ඇල්කීනයක් වන එතීන් (C₂H₄) ඔක්සිජන් සමඟ දහනය වීම",
      unbalancedEquation = "C₂H₄ + O₂ ➔ CO₂ + H₂O",
      balancedEquation = "C₂H₄ + 3O₂ ➔ 2CO₂ + 2H₂O",
      explanation = "C=2 බැවින් 2CO₂, H=4 බැවින් 2H₂O. එවිට දකුණු පස ඔක්සිජන් 4+2=6 වේ. එබැවින් 3O₂ යොදයි.",
      keyPoints = listOf("දීප්තිමත් දැල්ලකින් දැවේ", "ද්විත්ව බන්ධනයක් සහිත අසංතෘප්ත හයිඩ්‍රොකාබනයකි", "පොලිතීන් බහුඅවයවිකය තැනීමේ ඒකඅවයවිකයයි")
    ),
    ScienceChemItem(
      id = "chem_11_13",
      grade = "11",
      title = "සබන් සැපොනීකරණය",
      category = "කාර්මික රසායනය",
      reactantsSinhala = "මේද හෝ තෙල් (ට්‍රයිග්ලිසරයිඩ්) NaOH ක්ෂාරය සමඟ රත් කර සබන් සහ ග්ලිසරෝල් සෑදීම",
      unbalancedEquation = "මේදය + 3NaOH ➔ ග්ලිසරෝල් + 3RCOONa (සබන්)",
      balancedEquation = "ට්‍රයිග්ලිසරයිඩ් + 3NaOH ➔ ග්ලිසරෝල් + 3RCOONa",
      explanation = "මේද අම්ලවල සෝඩියම් හෝ පොටෑසියම් ලවණ සබන් ලෙස හඳුන්වයි. ලුණු (NaCl) යොදා සබන් අවක්ෂේප කරගනී.",
      keyPoints = listOf("සබන් අණුවකට ජලකාමී හිසක් සහ ජලභීතික වලිගයක් ඇත", "තෙල් සහ කුණු ඉවත් කිරීමට මයිසෙල සාදයි", "කාර්මිකව වැදගත් ප්‍රතික්‍රියාවකි")
    ),
    ScienceChemItem(
      id = "chem_11_14",
      grade = "11",
      title = "ඩැනියෙල් කෝෂයේ අර්ධ ප්‍රතික්‍රියා",
      category = "විද්‍යුත් රසායනය",
      reactantsSinhala = "Zn ඇනෝඩයේ ඔක්සිකරණය සහ Cu කැතෝඩයේ ඔක්සිහරණය සිදුවීම",
      unbalancedEquation = "Zn + Cu²⁺ ➔ Zn²⁺ + Cu",
      balancedEquation = "Zn(s) + Cu²⁺(aq) ➔ Zn²⁺(aq) + Cu(s)  [EMF = 1.10 V]",
      explanation = "Zn ➔ Zn²⁺ + 2e⁻ (ඇනෝඩය - ඔක්සිකරණය), Cu²⁺ + 2e⁻ ➔ Cu (කැතෝඩය - ඔක්සිහරණය).",
      keyPoints = listOf("රසායනික ශක්තිය විද්‍යුත් ශක්තිය බවට පත්කරයි", "Zn දණ්ඩ ක්ෂය වන අතර Cu දණ්ඩ ඝනකම් වේ", "කෝෂයේ විද්‍යුත් ගාමක බලය 1.1 V කි")
    ),
    ScienceChemItem(
      id = "chem_11_15",
      grade = "11",
      title = "ස්පර්ශ ක්‍රමයෙන් H₂SO₄ නිෂ්පාදනය",
      category = "කාර්මික රසායනය",
      reactantsSinhala = "SO₂ වායුව V₂O₅ උත්ප්‍රේරකය හමුවේ SO₃ බවට පත්වී සල්ෆියුරික් අම්ලය නිපදවීම",
      unbalancedEquation = "SO₂ + O₂ ⇌ SO₃",
      balancedEquation = "2SO₂ + O₂ ⇌ 2SO₃  [උත්ප්‍රේරක V₂O₅, 450 °C]",
      explanation = "සල්ෆර් ඩයොක්සයිඩ් ඔක්සිකරණය කර SO₃ සාදා, එය H₂SO₄ හි දියකර ඔලියම් (H₂S₂O₇) සාදා ජලය මුසු කරයි.",
      keyPoints = listOf("ලෝකයේ රසායනික ද්‍රව්‍යවල රජු ලෙස සල්ෆියුරික් අම්ලය හඳුන්වයි", "පොහොර, ඩිටර්ජන්ට් සහ බැටරි සඳහා යොදාගනී", "උත්ප්‍රේරකය වැනේඩියම් පෙන්ටොක්සයිඩ් වේ")
    ),
    ScienceChemItem(
      id = "chem_11_16",
      grade = "11",
      title = "හේබර් ක්‍රමයෙන් ඇමෝනියා නිපදවීම",
      category = "කාර්මික රසායනය",
      reactantsSinhala = "නයිට්‍රජන් සහ හයිඩ්‍රජන් Fe උත්ප්‍රේරකය හමුවේ NH₃ වායුව සෑදීම",
      unbalancedEquation = "N₂ + H₂ ⇌ NH₃",
      balancedEquation = "N₂(g) + 3H₂(g) ⇌ 2NH₃(g)  [Fe, 450-500 °C, 200 atm]",
      explanation = "නයිට්‍රජන් 1 පංගුවකට හයිඩ්‍රජන් 3 පංගුවක් මුසු කර 200 atm පීඩනයක් යටතේ රත්කර ඇමෝනියා ලබාගනී.",
      keyPoints = listOf("නයිට්‍රජනීය පොහොර (යූරියා) නිපදවීමට ප්‍රධාන අමුද්‍රව්‍යයයි", "ප්‍රතිවර්ත්‍ය තාපදායක ප්‍රතික්‍රියාවකි", "යකඩ (Fe) උත්ප්‍රේරකය ලෙස ක්‍රියා කරයි")
    ),
    ScienceChemItem(
      id = "chem_11_17",
      grade = "11",
      title = "ක්ලෝරැල්කලි ක්‍රියාවලිය",
      category = "විද්‍යුත් විච්ඡේදනය",
      reactantsSinhala = "සාන්ද්‍ර NaCl (බ්‍රයින්) ද්‍රාවණය විද්‍යුත් විච්ඡේදනයෙන් NaOH, Cl₂ සහ H₂ ලැබීම",
      unbalancedEquation = "NaCl + H₂O ➔ NaOH + Cl₂ + H₂",
      balancedEquation = "2NaCl + 2H₂O ➔ 2NaOH + Cl₂ + H₂",
      explanation = "ඇනෝඩයේදී Cl⁻ ඔක්සිකරණය වී Cl₂ ද, කැතෝඩයේදී H⁺ ඔක්සිහරණය වී H₂ ද නිපදවේ. ද්‍රාවණයේ NaOH ඉතිරි වේ.",
      keyPoints = listOf("කාර්මිකව අතිශය වැදගත් ඵල 3ක් ලැබේ", "ක්ලෝරීන් විෂබීජ නාශකයක් ලෙස යොදාගනී", "NaOH සබන් කර්මාන්තයට යොදාගනී")
    ),
    ScienceChemItem(
      id = "chem_11_18",
      grade = "11",
      title = "සෝඩියම් තයෝසල්ෆේට් හා අම්ල ප්‍රතික්‍රියා ශීඝ්‍රතාව",
      category = "ප්‍රතික්‍රියා ශීඝ්‍රතාව",
      reactantsSinhala = "Na₂S₂O₃ ද්‍රාවණය තනුක HCl සමඟ ප්‍රතික්‍රියා කර සල්ෆර් අවක්ෂේපය සෑදීම",
      unbalancedEquation = "Na₂S₂O₃ + HCl ➔ NaCl + S + SO₂ + H₂O",
      balancedEquation = "Na₂S₂O₃ + 2HCl ➔ 2NaCl + S↓ + SO₂ + H₂O",
      explanation = "කහ පැහැති සල්ෆර් අවක්ෂේප වන වේගය මැනීමෙන් ප්‍රතික්‍රියා ශීඝ්‍රතාව කෙරෙහි උෂ්ණත්වයේ සහ සාන්ද්‍රණයේ බලපෑම පරීක්ෂා කරයි.",
      keyPoints = listOf("කහ පැහැති සල්ෆර් (S) අවක්ෂේප වීම නිසා ද්‍රාවණය බොඳ වේ", "කඩදාසියක ඇඳි කතිරය නොපෙනී යාමට ගතවන කාලය මනියි", "ප්‍රතික්‍රියා ශීඝ්‍රතාව අධ්‍යයනයට විභාගයේ නිතර අසන ප්‍රායෝගිකයකි")
    )
  )
}
