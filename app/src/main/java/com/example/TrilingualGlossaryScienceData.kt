package com.example

// 100 Sri Lankan O/L Science Trilingual Glossary Terms
// Divided into 10 groups of 10 words (1-10 each)
val scienceGlossary100Terms = listOf(
  // GROUP 1 (1 - 10): ජීව විද්‍යාත්මක මූලධර්ම හා සෛලය
  GlossaryTermItem(
    id = "sci_01",
    englishTerm = "Osmosis",
    sinhalaTerm = "ආස්‍රැතිය",
    tamilTerm = "பிரசாரணம்",
    subject = "විද්‍යාව",
    definitionSinhala = "වරණීය පාරගම්‍ය පටලයක් හරහා ජල විභවය වැඩි කලාපයක සිට අඩු කලාපයකට ජල අණු ස්වයංසිද්ධව සංක්‍රමණය වීම.",
    examTip = "ශාකවල ජලය අවශෝෂණය සහ රුධිර සෛලවල විදාරණය සඳහා අදාළ වේ."
  ),
  GlossaryTermItem(
    id = "sci_02",
    englishTerm = "Diffusion",
    sinhalaTerm = "විසරණය",
    tamilTerm = "பரவல்",
    subject = "විද්‍යාව",
    definitionSinhala = "අණු හෝ අංශු වැඩි සාන්ද්‍රණයක් ඇති කලාපයක සිට අඩු සාන්ද්‍රණයක් ඇති කලාපයකට අහඹු චලිතය මඟින් ගමන් කිරීම.",
    examTip = "පෙනහළු වායුකෝෂවල O₂ හා CO₂ හුවමාරුව සිදුවන්නේ විසරණයෙනි."
  ),
  GlossaryTermItem(
    id = "sci_03",
    englishTerm = "Photosynthesis",
    sinhalaTerm = "ප්‍රභාසංස්ලේෂණය",
    tamilTerm = "ஒளித்தொகுப்பு",
    subject = "විද්‍යාව",
    definitionSinhala = "ශාක පත්‍රවල හරිතප්‍රද මඟින් සූර්ය ශක්තිය යොදා CO₂ හා ජලයෙන් ග්ලූකෝස් සහ ඔක්සිජන් නිපදවීම.",
    examTip = "සමතුලිත සමීකරණය: 6CO₂ + 6H₂O → C₆H₁₂O₆ + 6O₂ (ආලෝකය සහ හරිතප්‍රද හමුවේ)."
  ),
  GlossaryTermItem(
    id = "sci_04",
    englishTerm = "Cellular Respiration",
    sinhalaTerm = "සෛලීය ශ්වසනය",
    tamilTerm = "கலச்சுவாசம்",
    subject = "විද්‍යාව",
    definitionSinhala = "සෛල තුළ ග්ලූකෝස් වැනි කාබනික සංයෝග ඔක්සිකරණය කර ATP ආකාරයෙන් ශක්තිය නිදහස් කිරීම.",
    examTip = "මයිටොකොන්ඩ්‍රියා තුළ වායුගෝලීය ශ්වසනයේ වැඩිම ATP ප්‍රමාණයක් (38 ATP) ජනනය වේ."
  ),
  GlossaryTermItem(
    id = "sci_05",
    englishTerm = "Mitosis",
    sinhalaTerm = "අනුනන විභාජනය",
    tamilTerm = "இழையுருப்பிரிவு",
    subject = "විද්‍යාව",
    definitionSinhala = "එක් ද්විගුණ (2n) මාතෘ සෛලයකින් සමාන වර්ණදේහ සංඛ්‍යාවක් සහිත දුහිතෘ සෛල 2ක් නිපදවන න්‍යෂ්ටි විභාජනය.",
    examTip = "ශරීර වර්ධනයට හා අලුත්වැඩියාවට දායක වන අතර ප්‍රවේණික විචලනයන් ඇති නොකරයි."
  ),
  GlossaryTermItem(
    id = "sci_06",
    englishTerm = "Meiosis",
    sinhalaTerm = "ඌනන විභාජනය",
    tamilTerm = "ஒடுக்கற்பிரிவு",
    subject = "විද්‍යාව",
    definitionSinhala = "ද්විගුණ (2n) මාතෘ සෛලයකින් ඒකගුණ (n) වර්ණදේහ සහිත දුහිතෘ සෛල 4ක් සාදන සෛල විභාජනය.",
    examTip = "ජන්මාණු (ශුක්‍රාණු/ඩිම්බ) සෑදීමේදී සිදුවන අතර ප්‍රවේණික විචලනය ඇති කරයි."
  ),
  GlossaryTermItem(
    id = "sci_07",
    englishTerm = "Mitochondria",
    sinhalaTerm = "මයිටොකොන්ඩ්‍රියා",
    tamilTerm = "இழைமணி",
    subject = "විද්‍යාව",
    definitionSinhala = "සෛලීය ශ්වසනය පවත්වාගෙන යමින් සෛලයට අවශ්‍ය ATP ශක්තිය සපයන සෛල ඉන්ද්‍රයිකාව.",
    examTip = "'සෛලයේ බලාගාරය' (Powerhouse of the cell) ලෙස විභාගයේදී නිතර හඳුන්වයි."
  ),
  GlossaryTermItem(
    id = "sci_08",
    englishTerm = "Chloroplast",
    sinhalaTerm = "හරිතලවය",
    tamilTerm = "பசையவுருவகம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ශාක සෛලවල ප්‍රභාසංස්ලේෂණය සිදුකෙරෙන හරිතප්‍රද අඩංගු ද්විපටලමය ඉන්ද්‍රයිකාව.",
    examTip = "තිරස් තලවල පිහිටි තයිලකොයිඩ හා ග්‍රානා මඟින් ආලෝක ප්‍රතික්‍රියාව සිදු කරයි."
  ),
  GlossaryTermItem(
    id = "sci_09",
    englishTerm = "Enzyme",
    sinhalaTerm = "එන්සයිමය",
    tamilTerm = "நொதியம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ජීවී සිරුරු තුළ සිදුවන රසායනික ප්‍රතික්‍රියාවල සක්‍රියන ශක්තිය අඩුකර ප්‍රතික්‍රියා වේගවත් කරන ජෛව උත්ප්‍රේරක ප්‍රෝටීන.",
    examTip = "එන්සයිමවල ක්‍රියාකාරිත්වය ප්‍රශස්ථ උෂ්ණත්වයේදී (37°C) සහ ප්‍රශස්ථ pH අගයේදී උපරිම වේ."
  ),
  GlossaryTermItem(
    id = "sci_10",
    englishTerm = "Peristalsis",
    sinhalaTerm = "ක්‍රමානුකුंचනය",
    tamilTerm = "அலைவியக்கம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ආහාර මාර්ගයේ සිනිඳු පේශිවල රිද්මයානුකූල සංකෝචනය හා ලිහිල් වීම මඟින් ආහාර පෙරට තල්ලු කිරීම.",
    examTip = "ග්‍රසනිකාවේ සිට ගුදය දක්වා ආහාර ගමන් කරන්නේ ක්‍රමානුකුංචන චලනය මගිනි."
  ),

  // GROUP 2 (11 - 20): මානව පද්ධති හා කායික විද්‍යාව
  GlossaryTermItem(
    id = "sci_11",
    englishTerm = "Homeostasis",
    sinhalaTerm = "සමස්ථිතිය",
    tamilTerm = "ஓமியோஸ்டாசிஸ் (உடலகச்சமநிலை)",
    subject = "විද්‍යාව",
    definitionSinhala = "බාහිර පරිසරය වෙනස් වුවද සිරුරේ අභ්‍යන්තර පරිසරය නියතව පවත්වා ගැනීමේ ස්වයංක්‍රීය යාන්ත්‍රණය.",
    examTip = "දේහ උෂ්ණත්වය (37°C), රුධිර ග්ලූකෝස් මට්ටම සහ ජල තුල්‍යතාව මීට නිදසුන් වේ."
  ),
  GlossaryTermItem(
    id = "sci_12",
    englishTerm = "Hemoglobin",
    sinhalaTerm = "හිමොග්ලොබින්",
    tamilTerm = "ஹீமோகுளோபின்",
    subject = "විද්‍යාව",
    definitionSinhala = "රතු රුධිරාණු තුළ අඩංගු යකඩ සහිත, ඔක්සිජන් පරිවහනය කරන ශ්වසන වර්ණකය.",
    examTip = "හිමොග්ලොබින් ඔක්සිජන් සමඟ එක්වී ඔක්සිහිමොග්ලොබින් සාදයි (Hb + 4O₂ ⇌ Hb(O₂)₄)."
  ),
  GlossaryTermItem(
    id = "sci_13",
    englishTerm = "Nephron",
    sinhalaTerm = "වෘක්කාණුව",
    tamilTerm = "சிறுநீரகத்தி",
    subject = "විද්‍යාව",
    definitionSinhala = "වෘක්කයේ (වකුගඩුවේ) ව්‍යුහමය හා කෘත්‍යමය මූලික ඒකකය.",
    examTip = "රුධිරය පීඩන පෙරීම (Ultrafiltration) සිදුවන්නේ මල්පීගිය මාලිගාව තුළදීය."
  ),
  GlossaryTermItem(
    id = "sci_14",
    englishTerm = "Synapse",
    sinhalaTerm = "උපාගමය",
    tamilTerm = "நரம்பிணைப்பு",
    subject = "විද්‍යාව",
    definitionSinhala = "නියුරෝන දෙකක් හෝ නියුරෝනයක් හා කාර්ය සාධකයක් අතර ආවේග සම්ප්‍රේෂණය වන සන්ධිය.",
    examTip = "ස්නායු ආවේග උපාගමය හරහා ගමන් කරන්නේ ස්නායු සම්ප්‍රේෂක (Neurotransmitters) රසායන මඟිනි."
  ),
  GlossaryTermItem(
    id = "sci_15",
    englishTerm = "Reflex Arc",
    sinhalaTerm = "ප්‍රත්‍යාවර්ත චාපය",
    tamilTerm = "மறிவினை வில்",
    subject = "විද්‍යාව",
    definitionSinhala = "ප්‍රත්‍යාවර්ත ක්‍රියාවකදී ස්නායු ආවේගය ග්‍රාහකයේ සිට කාර්ය සාධකය දක්වා ගමන් කරන මාර්ගය.",
    examTip = "ග්‍රාහකය → අභිවාහී නියුරෝනය → සුෂුම්නාව → අපවාහී නියුරෝනය → කාර්යසාධකය."
  ),
  GlossaryTermItem(
    id = "sci_16",
    englishTerm = "Endocrine Gland",
    sinhalaTerm = "අන්තරාසර්ග ග්‍රන්ථිය",
    tamilTerm = "நாளமில்லாச் சுரப்பி",
    subject = "විද්‍යාව",
    definitionSinhala = "ප්‍රණාල රහිතව තම හෝමෝන සෘජුවම රුධිරයට ශ්‍රාවය කරන ග්‍රන්ථි.",
    examTip = "පිටියුටරිය, තයිරොයිඩය, අධිවෘක්කය සහ අග්න්‍යාශයේ ලැන්ගර්හැන් දිවයින මීට අයත්ය."
  ),
  GlossaryTermItem(
    id = "sci_17",
    englishTerm = "Insulin",
    sinhalaTerm = "ඉන්සියුලින්",
    tamilTerm = "இன்சுலின்",
    subject = "විද්‍යාව",
    definitionSinhala = "අග්න්‍යාශයේ බීටා සෛල මඟින් රුධිරයේ අතිරික්ත ග්ලූකෝස් ග්ලයිකොජන් බවට පත්කර ගබඩා කරවන හෝමෝනය.",
    examTip = "ඉන්සියුලින් ඌනතාවය නිසා දියවැඩියාව (Diabetes Mellitus) ඇති වේ."
  ),
  GlossaryTermItem(
    id = "sci_18",
    englishTerm = "Vaccine",
    sinhalaTerm = "එන්නත",
    tamilTerm = "தடுப்பூசி",
    subject = "විද්‍යාව",
    definitionSinhala = "නිශ්චිත රෝගයකට එරෙහිව ප්‍රතිශක්තිය උත්තේජනය කිරීම සඳහා ශරීරයට ඇතුළු කරන දුර්වල කළ හෝ මළ ක්ෂුද්‍ර ජීවී අංශු.",
    examTip = "සක්‍රීය කෘත්‍රිම ප්‍රතිශක්තියක් ලබාදීමට එන්නත් උපකාරී වේ."
  ),
  GlossaryTermItem(
    id = "sci_19",
    englishTerm = "Antibody",
    sinhalaTerm = "ප්‍රතිදේහය",
    tamilTerm = "பிறபொருளெதிரி",
    subject = "විද්‍යාව",
    definitionSinhala = "බාහිරින් සිරුරට ඇතුළු වන ප්‍රතිදේහජනක (Antigens) විනාශ කිරීම සඳහා B ලිම්ෆොසයිට මඟින් නිපදවන ප්‍රෝටීන.",
    examTip = "ප්‍රතිදේහ සහ ප්‍රතිදේහජනක අතර විශේෂිත අගුල සහ යතුර බඳු ගැළපීමක් පවතී."
  ),
  GlossaryTermItem(
    id = "sci_20",
    englishTerm = "Pathogen",
    sinhalaTerm = "රෝගකාරකය",
    tamilTerm = "நோய்க்காரணி",
    subject = "විද්‍යාව",
    definitionSinhala = "මිනිසා හෝ වෙනත් සතුන් තුළ බෝවන රෝග ඇති කිරීමට සමත් බැක්ටීරියා, වෛරස්, දිලීර හෝ ප්‍රෝටොසෝවා ක්ෂුද්‍රජීවීන්.",
    examTip = "ඩෙංගු රෝගකාරකය වෛරසයක් වන අතර වාහකයා ඊඩිස් මදුරුවා වේ."
  ),

  // GROUP 3 (21 - 30): ප්‍රවේණිය හා පරිණාමය
  GlossaryTermItem(
    id = "sci_21",
    englishTerm = "Gene",
    sinhalaTerm = "ජානය",
    tamilTerm = "பரம்பரையலகு",
    subject = "විද්‍යාව",
    definitionSinhala = "විශේෂිත ප්‍රෝටීනයක් සංස්ලේෂණය කිරීමට සංකේත සපයන, DNA අණුවක පිහිටි ප්‍රවේණික තොරතුරු දරන මූලික ඒකකය.",
    examTip = "වර්ණදේහ මත ජාන රේඛීයව පිහිටා ඇත. එක් එක් ජානය පිහිටි ස්ථානය ලෝකසය (Locus) යි."
  ),
  GlossaryTermItem(
    id = "sci_22",
    englishTerm = "Allele",
    sinhalaTerm = "යුගල ප්‍රතිරූපකය (ඇලීලය)",
    tamilTerm = "அல்லீல்",
    subject = "විද්‍යාව",
    definitionSinhala = "එකම ලක්ෂණයක් පාලනය කරන, සමජාතීය වර්ණදේහවල සමාන ලෝකසවල පිහිටන ජානයක විකල්ප ආකාර.",
    examTip = "උදාහරණය: මෙන්ඩල්ගේ මිටි (t) සහ උස (T) ඇලීල."
  ),
  GlossaryTermItem(
    id = "sci_23",
    englishTerm = "Genotype",
    sinhalaTerm = "ප්‍රවේණි දර්ශකය",
    tamilTerm = "மரபுவகை",
    subject = "විද්‍යාව",
    definitionSinhala = "ජීවියෙකු තුළ කිසියම් ලක්ෂණයක් සඳහා පවතින නිශ්චිත ජාන සංයුතිය (උදා: TT, Tt, tt).",
    examTip = "සමප්‍රවේණිදර්ශක (Homozygous: TT) සහ විෂමප්‍රවේණිදර්ශක (Heterozygous: Tt) ලෙස දැක්විය හැක."
  ),
  GlossaryTermItem(
    id = "sci_24",
    englishTerm = "Phenotype",
    sinhalaTerm = "රූපානුදර්ශකය",
    tamilTerm = "தோற்றவகை",
    subject = "විද්‍යාව",
    definitionSinhala = "ජාන සංයුතිය සහ පරිසරයේ බලපෑම නිසා බාහිරින් නිරීක්ෂණය කළ හැකි ජීවියාගේ භෞතික ලක්ෂණ (උදා: උස ශාක, රතු මල්).",
    examTip = "මෙන්ඩල්ගේ ඒක මුහුම් අනුපාතය: රූපානුදර්ශ අනුපාතය 3:1, ප්‍රවේණිදර්ශ අනුපාතය 1:2:1 වේ."
  ),
  GlossaryTermItem(
    id = "sci_25",
    englishTerm = "Dominant Allele",
    sinhalaTerm = "ප්‍රමුඛ ඇලීලය",
    tamilTerm = "ஆதிக்க அல்லீல்",
    subject = "විද්‍යාව",
    definitionSinhala = "විෂමප්‍රවේණි තත්ත්වයකදී වුවද (Tt) තම රූපානුදර්ශය ප්‍රකාශ කිරීමට සමත් වන ජාන ආකාරය.",
    examTip = "සෑම විටම ඉංග්‍රීසි කැපිටල් අකුරින් සංකේතවත් කරයි (උදා: T)."
  ),
  GlossaryTermItem(
    id = "sci_26",
    englishTerm = "Recessive Allele",
    sinhalaTerm = "නිලීන ඇලීලය",
    tamilTerm = "பின்னடைவான அல்லீல்",
    subject = "විද්‍යාව",
    definitionSinhala = "ප්‍රමුඛ ඇලීලයක් නොමැති සමයුග්මක තත්ත්වයේදී පමණක් (tt) ප්‍රකාශ වන ජාන ආකාරය.",
    examTip = "සරල කුඩා අකුරින් සංකේතවත් කරයි (උදා: t)."
  ),
  GlossaryTermItem(
    id = "sci_27",
    englishTerm = "Mutation",
    sinhalaTerm = "විකෘතිය",
    tamilTerm = "சடுதிமாற்றம்",
    subject = "විද්‍යාව",
    definitionSinhala = "DNA අණුවල නියුක්ලියෝටයිඩ අනුක්‍රමයේ හෝ වර්ණදේහවල ව්‍යුහයේ ක්ෂණිකව සිදුවන ස්ථිර වෙනස්වීම.",
    examTip = "විකෘති නිසා ජනගහනයක නව ප්‍රවේණික විචලන බිහි වේ."
  ),
  GlossaryTermItem(
    id = "sci_28",
    englishTerm = "Sex Chromosome",
    sinhalaTerm = "ලිංගික වර්ණදේහය",
    tamilTerm = "இலிங்க நிறமூர்த்தம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ජීවියෙකුගේ ලිංග නිර්ණය සඳහා සෘජුවම දායක වන 23 වන වර්ණදේහ යුගලය (X සහ Y).",
    examTip = "මිනිසාගේ ගැහැනු සෛල XX වන අතර පිරිමි සෛල XY වේ."
  ),
  GlossaryTermItem(
    id = "sci_29",
    englishTerm = "Natural Selection",
    sinhalaTerm = "ස්වභාවික වරණය",
    tamilTerm = "இயற்கைத் தேர்வு",
    subject = "විද්‍යාව",
    definitionSinhala = "පරිසරයට වඩාත් හොඳින් අනුවර්තනය වූ ජීවීන් නොනැසී පැවතී තම ජාන ඊළඟ පරම්පරාවට සම්ප්‍රේෂණය කිරීමේ ක්‍රියාවලිය.",
    examTip = "චාල්ස් ඩාවින් විසින් පරිණාමවාදී න්‍යාය ඉදිරිපත් කරන ලදී."
  ),
  GlossaryTermItem(
    id = "sci_30",
    englishTerm = "Biodiversity",
    sinhalaTerm = "ජෛව විවිධත්වය",
    tamilTerm = "உயிர்ப்பல்வகைமை",
    subject = "විද්‍යාව",
    definitionSinhala = "යම් පරිසර පද්ධතියක හෝ සමස්ත පෘථිවිය මත හමුවන ප්‍රවේණික, විශේෂ සහ පරිසර පද්ධති විවිධත්වයේ සමස්තය.",
    examTip = "ශ්‍රී ලංකාව ලෝකයේ ප්‍රමුඛ ජෛව විවිධත්ව උණුසුම් කලාපයක් (Biodiversity Hotspot) වේ."
  ),

  // GROUP 4 (31 - 40): පදාර්ථයේ ව්‍යුහය හා රසායනික බන්ධන
  GlossaryTermItem(
    id = "sci_31",
    englishTerm = "Atom",
    sinhalaTerm = "පරමාණුව",
    tamilTerm = "அணு",
    subject = "විද්‍යාව",
    definitionSinhala = "රසායනික ප්‍රතික්‍රියාවකට සහභාගී විය හැකි, මූලද්‍රව්‍යයක රසායනික ගුණ රඳවා ගන්නා කුඩාම ඒකකය.",
    examTip = "පරමාණුවක න්‍යෂ්ටියේ ප්‍රෝටෝන හා නියුට්‍රෝන ඇති අතර ඉලෙක්ට්‍රෝන ශක්ති මට්ටම්වල භ්‍රමණය වේ."
  ),
  GlossaryTermItem(
    id = "sci_32",
    englishTerm = "Atomic Number (Z)",
    sinhalaTerm = "පරමාණුක ක්‍රමාංකය",
    tamilTerm = "அணுவெண்",
    subject = "විද්‍යාව",
    definitionSinhala = "පරමාණුවක න්‍යෂ්ටිය තුළ අඩංගු ප්‍රෝටෝන සංඛ්‍යාව (නියුට්‍රල් පරමාණුවක ඉලෙක්ට්‍රෝන සංඛ්‍යාවට සමාන වේ).",
    examTip = "ආවර්තිතා වගුවේ මූලද්‍රව්‍ය පෙළගස්වා ඇත්තේ පරමාණුක ක්‍රමාංකය ආරෝහණ පිළිවෙළටය."
  ),
  GlossaryTermItem(
    id = "sci_33",
    englishTerm = "Mass Number (A)",
    sinhalaTerm = "ස්කන්ධ ක්‍රමාංකය",
    tamilTerm = "திணிவெண்",
    subject = "විද්‍යාව",
    definitionSinhala = "පරමාණුවක න්‍යෂ්ටිය තුළ ඇති ප්‍රෝටෝන සහ නියුට්‍රෝන සංඛ්‍යාවේ එකතුව (A = Z + N).",
    examTip = "නියුට්‍රෝන ගණන සෙවීමට: නියුට්‍රෝන = ස්කන්ධ ක්‍රමාංකය - පරමාණුක ක්‍රමාංකය."
  ),
  GlossaryTermItem(
    id = "sci_34",
    englishTerm = "Isotope",
    sinhalaTerm = "සමස්ථානිකය",
    tamilTerm = "சமதானி",
    subject = "විද්‍යාව",
    definitionSinhala = "එකම පරමාණුක ක්‍රමාංකය (ප්‍රෝටෝන ගණන) සහිත නමුත් වෙනස් ස්කන්ධ ක්‍රමාංක (නියුට්‍රෝන ගණන) ඇති එකම මූලද්‍රව්‍යයේ පරමාණු.",
    examTip = "හයිඩ්‍රජන්හි ප්‍රෝටියම් (¹H), ඩියුටීරියම් (²H), ට්‍රිටියම් (³H) ප්‍රධාන සමස්ථානික 3 වේ."
  ),
  GlossaryTermItem(
    id = "sci_35",
    englishTerm = "Electronegativity",
    sinhalaTerm = "විද්‍යුත් සෘණතාව",
    tamilTerm = "மின்னெதிர்த்தன்மை",
    subject = "විද්‍යාව",
    definitionSinhala = "සහසංයුජ බන්ධනයක හවුල් ඉලෙක්ට්‍රෝන යුගලය තමා දෙසට ආකර්ශනය කර ගැනීමට පරමාණුවකට ඇති සාපේක්ෂ හැකියාව.",
    examTip = "ආවර්තිතා වගුවේ වැඩිම විද්‍යුත් සෘණතාවක් ඇත්තේ ෆ්ලෝරීන් (F) මූලද්‍රව්‍යයටයි (අගය 4.0)."
  ),
  GlossaryTermItem(
    id = "sci_36",
    englishTerm = "Ionic Bond",
    sinhalaTerm = "අයනික බන්ධනය",
    tamilTerm = "அயன் பிணைப்பு",
    subject = "විද්‍යාව",
    definitionSinhala = "ලෝහ පරමාණුවක් අලෝහ පරමාණුවකට ඉලෙක්ට්‍රෝන පූර්ණ ලෙස පරිත්‍යාග කිරීමෙන් සෑදෙන ප්‍රතිවිරුද්ධ ආරෝපිත කැටායන හා ඇනායන අතර ඇතිවන ස්ථිති විද්‍යුත් ආකර්ෂණ බන්ධනය.",
    examTip = "උදා: NaCl (Na⁺ සහ Cl⁻ අතර බන්ධනය). අයනික සංයෝගවල ද්‍රවාංක ඉතා ඉහළය."
  ),
  GlossaryTermItem(
    id = "sci_37",
    englishTerm = "Covalent Bond",
    sinhalaTerm = "සහසංයුජ බන්ධනය",
    tamilTerm = "பங்கீட்டுவலுப் பிணைப்பு",
    subject = "විද්‍යාව",
    definitionSinhala = "අලෝහ පරමාණු අතර ස්ථායී ඉලෙක්ට්‍රෝන වින්‍යාසයක් ලබාගැනීම සඳහා ඉලෙක්ට්‍රෝන යුගල හවුලේ තබා ගැනීමෙන් ඇතිවන රසායනික බන්ධනය.",
    examTip = "උදා: H₂O, CH₄, CO₂. අණුක ආකාරයෙන් පවතින අතර පහළ ද්‍රවාංක පෙන්වයි."
  ),
  GlossaryTermItem(
    id = "sci_38",
    englishTerm = "Valency",
    sinhalaTerm = "සංයුජතාව",
    tamilTerm = "இணைதிறன்",
    subject = "විද්‍යාව",
    definitionSinhala = "පරමාණුවක් රසායනිකව බන්ධනය වීමේදී හවුල් කරගන්නා, ලබාගන්නා හෝ පිටකරන ඉලෙක්ට්‍රෝන සංඛ්‍යාව (සංයෝජන බලය).",
    examTip = "කාබන්හි සංයුජතාව 4 කි (චතුස්සංයුජ), ඔක්සිජන්හි 2 කි (ද්විසංයුජ)."
  ),
  GlossaryTermItem(
    id = "sci_39",
    englishTerm = "Mole",
    sinhalaTerm = "මවුලය",
    tamilTerm = "மோல்",
    subject = "විද්‍යාව",
    definitionSinhala = "කාබන්-12 සමස්ථානිකයේ හරියටම 12g ක අඩංගු පරමාණු සංඛ්‍යාවට (ඇවගාඩ්රෝ නියතය: 6.022 × 10²³) සමාන අංශු ප්‍රමාණයක් අඩංගු පදාර්ථ ප්‍රමාණය.",
    examTip = "මවුල ගණන (n) = ස්කන්ධය (m) / මවුලික ස්කන්ධය (M)."
  ),
  GlossaryTermItem(
    id = "sci_40",
    englishTerm = "Avogadro Constant",
    sinhalaTerm = "ඇවගාඩ්රෝ නියතය",
    tamilTerm = "அவகாதரோ மாறிலி",
    subject = "විද්‍යාව",
    definitionSinhala = "ඕනෑම පදාර්ථයක එක් මවුලයක අඩංගු අංශු සංඛ්‍යාව (6.022 × 10²³ mol⁻¹).",
    examTip = "L හෝ NA ලෙස සංකේතවත් කරන අතර ගණනය කිරීම් සඳහා O/L විභාගයේදී ලබාදේ."
  ),

  // GROUP 5 (41 - 50): රසායනික ප්‍රතික්‍රියා හා අම්ල භස්ම
  GlossaryTermItem(
    id = "sci_41",
    englishTerm = "Exothermic Reaction",
    sinhalaTerm = "තාපදායක ප්‍රතික්‍රියාව",
    tamilTerm = "வெப்பம் விடு தாக்கம்",
    subject = "විද්‍යාව",
    definitionSinhala = "පද්ධතියෙන් පරිසරයට තාප ශක්තිය මුදාහරින, ප්‍රතික්‍රියා මිශ්‍රණයේ උෂ්ණත්වය ඉහළ නංවන රසායනික ප්‍රතික්‍රියාවක්.",
    examTip = "දැවීම්, සාන්ද්‍ර අම්ල තනුක කිරීම සහ ශ්වසනය තාපදායක ක්‍රියාවලි වේ (ΔH සෘණ වේ)."
  ),
  GlossaryTermItem(
    id = "sci_42",
    englishTerm = "Endothermic Reaction",
    sinhalaTerm = "තාප අවශෝෂක ප්‍රතික්‍රියාව",
    tamilTerm = "வெப்பம் கொள் தாக்கம்",
    subject = "විද්‍යාව",
    definitionSinhala = "පරිසරයෙන් පද්ධතියට තාප ශක්තිය උරාගන්නා, අවට පරිසරයේ උෂ්ණත්වය පහත හෙළන රසායනික ප්‍රතික්‍රියාවක්.",
    examTip = "ප්‍රභාසංස්ලේෂණය හා NH₄Cl ජලයේ දියවීම තාප අවශෝෂක ප්‍රතික්‍රියා වේ."
  ),
  GlossaryTermItem(
    id = "sci_43",
    englishTerm = "Catalyst",
    sinhalaTerm = "උත්ප්‍රේරකය",
    tamilTerm = "ஊக்கி",
    subject = "විද්‍යාව",
    definitionSinhala = "රසායනික ප්‍රතික්‍රියාවක අවසානයේදී ස්කන්ධයෙන් හෝ රසායනික ස්වභාවයෙන් කිසිදු වෙනසක් නොවී ප්‍රතික්‍රියා වේගය වැඩි කරන ද්‍රව්‍යය.",
    examTip = "H₂O₂ විඝටනය සඳහා MnO₂ යොදාගනී. උත්ප්‍රේරක මඟින් සක්‍රියන ශක්තිය පහත හෙළයි."
  ),
  GlossaryTermItem(
    id = "sci_44",
    englishTerm = "pH Scale",
    sinhalaTerm = "pH පරිමාණය",
    tamilTerm = "pH அளவிடை",
    subject = "විද්‍යාව",
    definitionSinhala = "ද්‍රාවණයක හයිඩ්‍රජන් අයන් සාන්ද්‍රණය මනින 0 සිට 14 දක්වා වූ ලඝුගණක පරිමාණය.",
    examTip = "pH < 7 අම්ල, pH = 7 උදාසීන (පිරිසිදු ජලය), pH > 7 භස්ම වේ."
  ),
  GlossaryTermItem(
    id = "sci_45",
    englishTerm = "Neutralization",
    sinhalaTerm = "උදාසීනීකරණය",
    tamilTerm = "நடுநிலையாக்கல்",
    subject = "විද්‍යාව",
    definitionSinhala = "අම්ලයක් හා භස්මයක් ප්‍රතික්‍රියා කර ලවණයක් හා ජලය සෑදීමේ තාපදායක ප්‍රතික්‍රියාව.",
    examTip = "H⁺(aq) + OH⁻(aq) → H₂O(l) යනු උදාසීනීකරණයේ පොදු අයනික සමීකරණයයි."
  ),
  GlossaryTermItem(
    id = "sci_46",
    englishTerm = "Oxidation",
    sinhalaTerm = "ඔක්සිකරණය",
    tamilTerm = "ஒட்சியேற்றம்",
    subject = "විද්‍යාව",
    definitionSinhala = "පරමාණුවකින් හෝ අයකින් ඉලෙක්ට්‍රෝන ඉවත් වීම, හෝ ඔක්සිජන් එක්වීම, හෝ හයිඩ්‍රජන් ඉවත්වීම.",
    examTip = "OIL RIG මතක තබා ගන්න: Oxidation Is Loss (of electrons), Reduction Is Gain."
  ),
  GlossaryTermItem(
    id = "sci_47",
    englishTerm = "Reduction",
    sinhalaTerm = "ඔක්සිහරණය",
    tamilTerm = "தாழ்த்தல்",
    subject = "විද්‍යාව",
    definitionSinhala = "පරමාණුවක් හෝ අයක් ඉලෙක්ට්‍රෝන ලබාගැනීම, හෝ හයිඩ්‍රජන් එක්වීම, හෝ ඔක්සිජන් ඉවත්වීම.",
    examTip = "රෙඩොක්ස් ප්‍රතික්‍රියාවලදී ඔක්සිකරණය සහ ඔක්සිහරණය එකවර සිදුවේ."
  ),
  GlossaryTermItem(
    id = "sci_48",
    englishTerm = "Activity Series of Metals",
    sinhalaTerm = "ලෝහවල සක්‍රියතා ශ්‍රේණිය",
    tamilTerm = "உலோகங்களின் தாக்கத்தொடர்",
    subject = "විද්‍යාව",
    definitionSinhala = "ලෝහවල ජලීය මාධ්‍යයේදී ඉලෙක්ට්‍රෝන මුදාහැර ධන අයන සෑදීමේ නැඹුරුතාව (ක්‍රියාකාරීත්වය) අනුව අවරෝහණව සැකසූ ලැයිස්තුව.",
    examTip = "K > Na > Ca > Mg > Al > Zn > Fe > Pb > (H) > Cu > Ag > Au."
  ),
  GlossaryTermItem(
    id = "sci_49",
    englishTerm = "Electrolysis",
    sinhalaTerm = "විද්‍යුත් විච්ඡේදනය",
    tamilTerm = "மின்னற்பகுப்பு",
    subject = "විද්‍යාව",
    definitionSinhala = "විද්‍යුත් විච්ඡේද්‍ය ද්‍රාවණයක් හෝ විලයනයක් හරහා සෘජු ධාරාවක් යැවීමෙන් රසායනික විඝටනයක් සිදුකිරීමේ ක්‍රියාවලිය.",
    examTip = "ඇනෝඩයේදී ඔක්සිකරණයත්, කැතෝඩයේදී ඔක්සිහරණයත් සිදුවේ."
  ),
  GlossaryTermItem(
    id = "sci_50",
    englishTerm = "Corrosion",
    sinhalaTerm = "ලෝහ විඛාදනය (මලකෑම)",
    tamilTerm = "உலோக அரிமானம் (துருப்பிடித்தல்)",
    subject = "විද්‍යාව",
    definitionSinhala = "වායුගෝලයේ ඇති ඔක්සිජන් සහ තෙතමනය (ජලය) සමඟ ප්‍රතික්‍රියා කිරීමෙන් ලෝහ පෘෂ්ඨ ක්‍රමයෙන් දිරාපත්වීම.",
    examTip = "යකඩ මලබැඳීමේ සූත්‍රය: Fe₂O₃·xH₂O (ජලීය ෆෙරික් ඔක්සයිඩ්)."
  ),

  // GROUP 6 (51 - 60): යාන්ත්‍ර විද්‍යාව, බලය හා චලිතය
  GlossaryTermItem(
    id = "sci_51",
    englishTerm = "Velocity",
    sinhalaTerm = "ප්‍රවේගය",
    tamilTerm = "வேகம் / திசைவேகம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ඒකක කාලයකදී සිදුවන විස්ථාපනය (විස්ථාපනය වෙනස් වීමේ සීඝ්‍රතාව).",
    examTip = "ප්‍රවේගය දෛශික රාශියකි (දිශාවක් සහ විශාලත්වයක් ඇත). ඒකකය m s⁻¹ වේ."
  ),
  GlossaryTermItem(
    id = "sci_52",
    englishTerm = "Acceleration",
    sinhalaTerm = "ත්වරණය",
    tamilTerm = "ஆர்முடுகல்",
    subject = "විද්‍යාව",
    definitionSinhala = "ඒකක කාලයකදී ප්‍රවේගය වෙනස් වීමේ සීඝ්‍රතාව (a = (v - u) / t).",
    examTip = "ප්‍රවේග-කාල ප්‍රස්තාරයක අනුක්‍රමණයෙන් ත්වරණය ද, ප්‍රස්තාරය යටතේ වර්ගඵලයෙන් විස්ථාපනය ද ලැබේ."
  ),
  GlossaryTermItem(
    id = "sci_53",
    englishTerm = "Newton's First Law",
    sinhalaTerm = "නිව්ටන්ගේ පළමු නියමය",
    tamilTerm = "நியூட்டனின் முதலாம் விதி",
    subject = "විද්‍යාව",
    definitionSinhala = "අසමතුලිත බාහිර බලයක් නොයෙදෙන තාක් කල්, නිශ්චල වස්තුවක් නිශ්චලතාවයේද, ඒකාකාර ප්‍රවේගයෙන් චලනය වන වස්තුවක් සරල රේඛීයව එම ප්‍රවේගයෙන්ම චලනය වෙමින් පවතී.",
    examTip = "මෙය ආවස්ථිති නියමය (Law of Inertia) ලෙසද හැඳින්වේ."
  ),
  GlossaryTermItem(
    id = "sci_54",
    englishTerm = "Newton's Second Law",
    sinhalaTerm = "නිව්ටන්ගේ දෙවන නියමය",
    tamilTerm = "நியூட்டனின் இரண்டாம் விதி",
    subject = "විද්‍යාව",
    definitionSinhala = "වස්තුවක ගම්‍යතාව වෙනස් වීමේ සීඝ්‍රතාව, ඒ මත යෙදෙන අසමතුලිත බලයට සමානුපාතික වන අතර බලය යෙදෙන දිශාවට සිදුවේ.",
    examTip = "මූලික ගණනය කිරීම් සූත්‍රය: F = ma (බලය = ස්කන්ධය × ත්වරණය)."
  ),
  GlossaryTermItem(
    id = "sci_55",
    englishTerm = "Newton's Third Law",
    sinhalaTerm = "නිව්ටන්ගේ තෙවන නියමය",
    tamilTerm = "நியூட்டனின் மூன்றாம் விதி",
    subject = "විද්‍යාව",
    definitionSinhala = "සෑම ක්‍රියාවකටම විශාලත්වයෙන් සමාන වූත්, දිශාවෙන් ප්‍රතිවිරුද්ධ වූත් ප්‍රතික්‍රියාවක් පවතී.",
    examTip = "ක්‍රියා හා ප්‍රතික්‍රියා බල වෙනස් වස්තු දෙකක් මත ක්‍රියාකරන බැවින් එකිනෙක සමතුලිත නොවේ."
  ),
  GlossaryTermItem(
    id = "sci_56",
    englishTerm = "Moment of a Force",
    sinhalaTerm = "බලයක ඝූර්ණය",
    tamilTerm = "விசையின் திருப்புத்திறன்",
    subject = "විද්‍යාව",
    definitionSinhala = "භ්‍රමණ අක්ෂයක් වටා වස්තුවක් කරකැවීමට බලයකට ඇති හැකියාවේ මිණුම (ඝූර්ණය = බලය × ලම්බ දුර).",
    examTip = "ඒකකය නිව්ටන් මීටර් (N m) වේ. දක්ෂිණාවර්ත ඝූර්ණ = වාමාවර්ත ඝූර්ණ (සමතුලිතතාවයේදී)."
  ),
  GlossaryTermItem(
    id = "sci_57",
    englishTerm = "Pressure",
    sinhalaTerm = "පීඩනය",
    tamilTerm = "அமுக்கம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ඒකක වර්ගඵලයකට ලම්බකව යෙදෙන බලය (P = F / A).",
    examTip = "පීඩනයේ SI ඒකකය පැස්කල් (Pa) හෙවත් N m⁻² වේ. ගැඹුර සමග ද්‍රව පීඩනය වැඩිවේ (P = hρg)."
  ),
  GlossaryTermItem(
    id = "sci_58",
    englishTerm = "Archimedes' Principle",
    sinhalaTerm = "ආකිමිඩීස් මූලධර්මය",
    tamilTerm = "ஆர்க்கிமிடிஸின் தத்துவம்",
    subject = "විද්‍යාව",
    definitionSinhala = "වස්තුවක් තරලයක සම්පූර්ණයෙන් හෝ අර්ධ වශයෙන් ගිලී ඇති විට, ඒ මත ක්‍රියාකරන උඩුකුරු තෙරපුම එමගින් විස්ථාපනය කරන තරලයේ බරට සමාන වේ.",
    examTip = "පා පාවීමේ නියමය: පාවෙන වස්තුවක බර = විස්ථාපිත ද්‍රවයේ බර."
  ),
  GlossaryTermItem(
    id = "sci_59",
    englishTerm = "Work Done",
    sinhalaTerm = "කළ කාර්යය",
    tamilTerm = "செய்த வேலை",
    subject = "විද්‍යාව",
    definitionSinhala = "බලයක් යෙදීමෙන් එම බලය යෙදුණු දිශාවට වස්තුව විස්ථාපනය වූ විට සිදුවන ශක්ති හුවමාරුව (W = F × s).",
    examTip = "කාර්යයේ SI ඒකකය ජූල් (J) වේ (1 J = 1 N m)."
  ),
  GlossaryTermItem(
    id = "sci_60",
    englishTerm = "Power",
    sinhalaTerm = "ක්ෂමතාව",
    tamilTerm = "வலு",
    subject = "විද්‍යාව",
    definitionSinhala = "කාර්යය කිරීමේ සීඝ්‍රතාව හෙවත් ඒකක කාලයකදී පරිභෝජනය කළ ශක්තිය (P = W / t).",
    examTip = "ක්ෂමතාවයේ SI ඒකකය වොට් (W) වේ (1 W = 1 J s⁻¹)."
  ),

  // GROUP 7 (61 - 70): තරංග, ආලෝකය හා ධ්වනිය
  GlossaryTermItem(
    id = "sci_61",
    englishTerm = "Refraction",
    sinhalaTerm = "ආලෝක වර්තනය",
    tamilTerm = "ஒளி முறிவு",
    subject = "විද්‍යාව",
    definitionSinhala = "ආලෝක කිරණයක් එක් පාරදෘශ්‍ය මාධ්‍යයක සිට වෙනත් මාධ්‍යයකට ඇතුළු වීමේදී වේගය වෙනස් වීම නිසා ගමන් දිශාව වෙනස් වීම.",
    examTip = "ප්‍රකාශ ඝනත්වයෙන් අඩු මාධ්‍යයක සිට වැඩි මාධ්‍යයකට යාමේදී කිරණය අභිලම්භය දෙසට නැමේ."
  ),
  GlossaryTermItem(
    id = "sci_62",
    englishTerm = "Snell's Law",
    sinhalaTerm = "ස්නෙල් නියමය",
    tamilTerm = "ஸ்னெல்லின் விதி",
    subject = "විද්‍යාව",
    definitionSinhala = "දී ඇති මාධ්‍ය යුගලක් සහ ආලෝක වර්ණයක් සඳහා ආපාත කෝණයේ සයින් අගය සහ වර්තන කෝණයේ සයින් අගය අතර අනුපාතය නියතයකි (Sin i / Sin r = n).",
    examTip = "මෙම නියතය මාධ්‍යයේ වර්තනාංකය (Refractive Index) වේ."
  ),
  GlossaryTermItem(
    id = "sci_63",
    englishTerm = "Critical Angle",
    sinhalaTerm = "අවධි කෝණය",
    tamilTerm = "மாறுநிலைக் கோணம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ප්‍රකාශ ඝනත්වයෙන් වැඩි මාධ්‍යයක සිට අඩු මාධ්‍යයකට ආලෝකය ගමන් කිරීමේදී වර්තන කෝණය 90° ක් වන අවස්ථාවේ ආපාත කෝණය (c).",
    examTip = "වීදුරු සඳහා අවධි කෝණය දළ වශයෙන් 42° කි. දියමන්ති සඳහා 24° කි."
  ),
  GlossaryTermItem(
    id = "sci_64",
    englishTerm = "Total Internal Reflection",
    sinhalaTerm = "පූර්ණ අභ්‍යන්තර පරාවර්තනය",
    tamilTerm = "முழுவுட்கதிர்ப்பு",
    subject = "විද්‍යාව",
    definitionSinhala = "ආපාත කෝණය අවධි කෝණයට වඩා වැඩි වූ විට, ආලෝක කිරණය දෙවන මාධ්‍යයට නොගොස් මුල් ඝන මාධ්‍යයටම සම්පූර්ණයෙන් පරාවර්තනය වීම.",
    examTip = "දෘශ්‍ය ප්‍රකාශ තන්තු (Optical Fibers) සහ මිරිඟුව ඇතිවීම සඳහා පදනම් වේ."
  ),
  GlossaryTermItem(
    id = "sci_65",
    englishTerm = "Focal Length",
    sinhalaTerm = "නාභීය දුර",
    tamilTerm = "குவியத்தூரம்",
    subject = "විද්‍යාව",
    definitionSinhala = "කාචයක හෝ ගෝලීය දර්පණයක ප්‍රකාශ කේන්ද්‍රයේ සිට ප්‍රධාන නාභියට ඇති සෘජු දුර (f).",
    examTip = "උත්තල කාච සඳහා f ධන වන අතර අවතල කාච සඳහා f සෘණ වේ."
  ),
  GlossaryTermItem(
    id = "sci_66",
    englishTerm = "Frequency",
    sinhalaTerm = "සංඛ්‍යාතය",
    tamilTerm = "அதிர்வெண்",
    subject = "විද්‍යාව",
    definitionSinhala = "තත්පරයකදී සම්පූර්ණ වන තරංග හෝ කම්පන සංඛ්‍යාව (f = 1 / T).",
    examTip = "සංඛ්‍යාතයේ SI ඒකකය හර්ට්ස් (Hz) වේ. මිනිස් කනට ඇසෙන සංඛ්‍යාත පරාසය 20 Hz - 20,000 Hz."
  ),
  GlossaryTermItem(
    id = "sci_67",
    englishTerm = "Wavelength",
    sinhalaTerm = "තරංග ආයාමය",
    tamilTerm = "அலைநீளம்",
    subject = "විද්‍යාව",
    definitionSinhala = "තරංගයක එකම කලාපයේ පිහිටි යාබද ශීර්ෂ දෙකක් හෝ නිම්න දෙකක් අතර සෘජු දුර (λ).",
    examTip = "තරංග සමීකරණය: v = fλ (තරංග ප්‍රවේගය = සංඛ්‍යාතය × තරංග ආයාමය)."
  ),
  GlossaryTermItem(
    id = "sci_68",
    englishTerm = "Pitch of Sound",
    sinhalaTerm = "ධ්වනියේ තාරතාව",
    tamilTerm = "சுருதி",
    subject = "විද්‍යාව",
    definitionSinhala = "ධ්වනියක් සිහින්ද ගොරෝසුද යන්න තීරණය කරන, සංඛ්‍යාතය මත පමණක් රඳා පවතින ශ්‍රවණ සංවේදනය.",
    examTip = "සංඛ්‍යාතය වැඩි වන විට තාරතාව ඉහළ යයි (හඬ සිහින් වේ)."
  ),
  GlossaryTermItem(
    id = "sci_69",
    englishTerm = "Loudness",
    sinhalaTerm = "ධ්වනියේ හඬසැරය",
    tamilTerm = "ஒலி உரப்பு",
    subject = "විද්‍යාව",
    definitionSinhala = "ධ්වනි ප්‍රභවයේ විස්තාරය (Amplitude) මත රඳා පවතින ශබ්දයේ ප්‍රබලතාව පිළිබඳ මනෝමතික සංවේදනය.",
    examTip = "විස්තාරය වැඩිවන විට හඬසැරය වැඩිවේ. ඩෙසිබල් (dB) ඒකකයෙන් මනිනු ලැබේ."
  ),
  GlossaryTermItem(
    id = "sci_70",
    englishTerm = "Electromagnetic Spectrum",
    sinhalaTerm = "විද්‍යුත් චුම්භක වර්ණාවලිය",
    tamilTerm = "மின்காந்த நிறமாலை",
    subject = "විද්‍යාව",
    definitionSinhala = "ගැමා, එක්ස් කිරණ, පාරජම්බුල, දෘශ්‍ය ආලෝකය, අධෝරක්ත, ක්ෂුද්‍ර තරංග හා රේඩියෝ තරංග සංඛ්‍යාත අනුපිළිවෙළට දැක්වීම.",
    examTip = "සියලුම විද්‍යුත් චුම්භක තරංග රික්තයේදී 3 × 10⁸ m s⁻¹ ආලෝක වේගයෙන් ගමන් කරයි."
  ),

  // GROUP 8 (71 - 80): විද්‍යුතය හා චුම්භකත්වය
  GlossaryTermItem(
    id = "sci_71",
    englishTerm = "Electric Current",
    sinhalaTerm = "විද්‍යුත් ධාරාව",
    tamilTerm = "மின்னோட்டம்",
    subject = "විද්‍යාව",
    definitionSinhala = "සන්නායකයක හරස්කඩක් හරහා ආරෝපණ ගලායාමේ සීඝ්‍රතාව (I = Q / t).",
    examTip = "SI ඒකකය ඇම්පියර් (A) වේ. ඇමීටරයක් පරිපථයට ශ්‍රේණිගතව සම්බන්ධ කළ යුතුය."
  ),
  GlossaryTermItem(
    id = "sci_72",
    englishTerm = "Potential Difference",
    sinhalaTerm = "විභව අන්තරය",
    tamilTerm = "மின்னழுத்த வேறுபாடு",
    subject = "විද්‍යාව",
    definitionSinhala = "පරිපථයක ලක්ෂ්‍ය දෙකක් අතර ඒකක ධන ආරෝපණයක් ගෙනයාමේදී සිදුකරන කාර්ය ප්‍රමාණය (V = W / Q).",
    examTip = "SI ඒකකය වෝල්ට් (V) වේ. වෝල්ට්මීටරය පරිපථයට සමාන්තරගතව සම්බන්ධ කරයි."
  ),
  GlossaryTermItem(
    id = "sci_73",
    englishTerm = "Ohm's Law",
    sinhalaTerm = "ඕම්ගේ නියමය",
    tamilTerm = "ஓமின் விதி",
    subject = "විද්‍යාව",
    definitionSinhala = "උෂ්ණත්වය හා අනෙකුත් භෞතික තත්ත්ව නියතව පවතින විට, සන්නායකයක් හරහා ගලන ධාරාව එහි දෙකෙළවර විභව අන්තරයට සෘජුවම සමානුපාතික වේ.",
    examTip = "V = IR (විභව අන්තරය = ධාරාව × ප්‍රතිරෝධය)."
  ),
  GlossaryTermItem(
    id = "sci_74",
    englishTerm = "Resistance",
    sinhalaTerm = "ප්‍රතිරෝධය",
    tamilTerm = "மின்தடை",
    subject = "විද්‍යාව",
    definitionSinhala = "ද්‍රව්‍යයක් හරහා විද්‍යුත් ධාරාවක් ගලා යාමට එරෙහිව ඇති කරන බාධාව.",
    examTip = "SI ඒකකය ඕම් (Ω) වේ. සන්නායකයක දිග වැඩිවන විට ප්‍රතිරෝධය වැඩිවේ."
  ),
  GlossaryTermItem(
    id = "sci_75",
    englishTerm = "Electromagnetic Induction",
    sinhalaTerm = "විද්‍යුත් චුම්භක ප්‍රේරණය",
    tamilTerm = "மின்காந்தத் தூண்டல்",
    subject = "විද්‍යාව",
    definitionSinhala = "සන්නායකයක් හා චුම්භක ක්ෂේත්‍රයක් අතර සාපේක්ෂ චලිතයක් ඇති විට සන්නායකය තුළ ප්‍රේරිත විද්‍යුත් ගාමක බලයක් ජනනය වීම.",
    examTip = "විදුලි ජනක යන්ත්‍ර (ඩයිනමෝ) ක්‍රියාකරන්නේ මෙම මූලධර්මයෙනි (ෆැරඩේ නියමය)."
  ),
  GlossaryTermItem(
    id = "sci_76",
    englishTerm = "Transformer",
    sinhalaTerm = "පරිණාමකය",
    tamilTerm = "மின்மாற்றி",
    subject = "විද්‍යාව",
    definitionSinhala = "විද්‍යුත් චුම්භක ප්‍රේරණය මඟින් සංඛ්‍යාතයේ වෙනසක් නොකර ප්‍රත්‍යාවර්ත වෝල්ටීයතාවක් වැඩි හෝ අඩු කරන ස්ථිතික උපකරණය.",
    examTip = "අධිපරිණාමක (Step-up) සහ අවපරිණාමක (Step-down) ලෙස වර්ග දෙකකි (Vp/Vs = Np/Ns)."
  ),
  GlossaryTermItem(
    id = "sci_77",
    englishTerm = "Diode",
    sinhalaTerm = "ඩයෝඩය",
    tamilTerm = "இருமுனையம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ධාරාව ගලා යාමට ඉඩ දෙන්නේ එකම දිශාවකට පමණක් වන p-n සන්ධියක් සහිත අර්ධ සන්නායක ඉලෙක්ට්‍රොනික උපාංගය.",
    examTip = "පෙර නැඹුරු (Forward biased) විට ධාරාව ගලා යයි. පසු නැඹුරු (Reverse biased) විට ධාරාව අවහිර කරයි."
  ),
  GlossaryTermItem(
    id = "sci_78",
    englishTerm = "Rectification",
    sinhalaTerm = "සෘජුකරණය",
    tamilTerm = "நேராக்கல்",
    subject = "විද්‍යාව",
    definitionSinhala = "ඩයෝඩ භාවිතයෙන් ප්‍රත්‍යාවර්ත ධාරාවක් (AC) සරල ධාරාවක් (DC) බවට පරිවර්තනය කිරීමේ ක්‍රියාවලිය.",
    examTip = "ඩයෝඩ 4 ක් යොදා සකසන පූර්ණ තරංග පාලම් සෘජුකාරකය O/L විභාගයේදී නිතර අසනු ලැබේ."
  ),
  GlossaryTermItem(
    id = "sci_79",
    englishTerm = "Earth Wire",
    sinhalaTerm = "භූගත වයරය",
    tamilTerm = "புவித்தொடுப்பு கம்பி",
    subject = "විද්‍යාව",
    definitionSinhala = "විදුලි උපකරණවල ලෝහමය බඳෙහි විදුලි කාන්දුවක් ඇති වුවහොත් එම අතිරික්ත ධාරාව ආරක්ෂිතව පොළොවට යවන කොළ/කහ පැහැති පරිවරණය කළ වයරය.",
    examTip = "පරිශීලකයා විදුලි සැර වැදීමෙන් (Electric Shock) ආරක්ෂා කිරීම ප්‍රධාන අරමුණයි."
  ),
  GlossaryTermItem(
    id = "sci_80",
    englishTerm = "Electric Power Formula",
    sinhalaTerm = "විද්‍යුත් ක්ෂමතා සූත්‍රය",
    tamilTerm = "மின்வலுச் சமன்பாடு",
    subject = "විද්‍යාව",
    definitionSinhala = "විදුලි උපකරණයක ශක්තිය වැයවන සීඝ්‍රතාව ගණනය කිරීමේ මූලික සූත්‍රය (P = V × I).",
    examTip = "P = VI = I²R = V² / R. ගෘහස්ථ විදුලි බිල මනින්නේ කිලෝවොට්-පැය (kWh) ඒකක වලිනි."
  ),

  // GROUP 9 (81 - 90): තාපය හා තාපගති විද්‍යාව
  GlossaryTermItem(
    id = "sci_81",
    englishTerm = "Heat Capacity",
    sinhalaTerm = "තාප ධාරිතාව",
    tamilTerm = "வெப்பக்கொள்ளளவு",
    subject = "විද්‍යාව",
    definitionSinhala = "කිසියම් ද්‍රව්‍යයක උෂ්ණත්වය සෙල්සියස් අංශක එකකින් (1°C හෝ 1 K) ඉහළ නැංවීම සඳහා අවශ්‍ය වන තාප ශක්ති ප්‍රමාණය (C = Q / Δθ).",
    examTip = "ඒකකය ජූල් පර් කෙල්වින් (J K⁻¹) හෝ J °C⁻¹ වේ."
  ),
  GlossaryTermItem(
    id = "sci_82",
    englishTerm = "Specific Heat Capacity",
    sinhalaTerm = "විශිෂ්ට තාප ධාරිතාව",
    tamilTerm = "தன்வெப்பக் கொள்ளளவு",
    subject = "විද්‍යාව",
    definitionSinhala = "ද්‍රව්‍යයක ඒකක ස්කන්ධයක (1 kg) උෂ්ණත්වය 1°C කින් ඉහළ නැංවීමට සැපයිය යුතු තාප ප්‍රමාණය (c = Q / (mΔθ)).",
    examTip = "ජලයේ විශිෂ්ට තාප ධාරිතාව ඉතා ඉහළය (4200 J kg⁻¹ °C⁻¹). සිසිලනකාරකයක් ලෙස යොදාගන්නේ එබැවිනි."
  ),
  GlossaryTermItem(
    id = "sci_83",
    englishTerm = "Specific Latent Heat of Fusion",
    sinhalaTerm = "විලයනයේ විශිෂ්ට ගුප්ත තාපය",
    tamilTerm = "உருகலின் தன்மறைவெப்பம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ද්‍රවාංකයේ පවතින ඝන ද්‍රව්‍යයක ඒකක ස්කන්ධයක් (1 kg) උෂ්ණත්ව වෙනසකින් තොරව ද්‍රව බවට පත්කිරීමට අවශ්‍ය තාපය (Lf).",
    examTip = "අයිස් ජලය බවට පත්වීමේදී උෂ්ණත්වය 0°C හි නියතව පවතී."
  ),
  GlossaryTermItem(
    id = "sci_84",
    englishTerm = "Conduction",
    sinhalaTerm = "සන්නයනය",
    tamilTerm = "கடத்தல்",
    subject = "විද්‍යාව",
    definitionSinhala = "පදාර්ථයේ අංශුවල සැබෑ විස්ථාපනයක් නොවී, යාබද අංශුවල කම්පනය මඟින් ඝන ද්‍රව්‍ය තුළින් තාපය සම්ප්‍රේෂණය වීම.",
    examTip = "ලෝහ තුළ ඇති නිදහස් ඉලෙක්ට්‍රෝන නිසා ලෝහ විශිෂ්ට තාප සන්නායක වේ."
  ),
  GlossaryTermItem(
    id = "sci_85",
    englishTerm = "Convection",
    sinhalaTerm = "සංවහනය",
    tamilTerm = "சலனம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ද්‍රව හා වායු අංශු රත්වීමේදී ඝනත්වය අඩුවී ඉහළ නැගීම සහ සිසිල් අංශු පහළ බැසීමෙන් ඇතිවන සංවහන ධාරා මඟින් තාපය සම්ප්‍රේෂණය වීම.",
    examTip = "මුහුදු සුළං, ගොඩබිම් සුළං ඇතිවන්නේ සංවහන ක්‍රියාවලිය හේතුවෙනි."
  ),
  GlossaryTermItem(
    id = "sci_86",
    englishTerm = "Radiation",
    sinhalaTerm = "විකිරණය",
    tamilTerm = "கதிர்வீசல்",
    subject = "විද්‍යාව",
    definitionSinhala = "කිසිදු ද්‍රව්‍යමය මාධ්‍යයක ආධාරයකින් තොරව, විද්‍යුත් චුම්භක තරංග (අධෝරක්ත) ආකාරයෙන් රික්තය හරහා තාපය ගමන් කිරීම.",
    examTip = "සූර්යයාගේ සිට පෘථිවියට තාපය ලැබෙන්නේ විකිරණය මගිනි. අඳුරු රළු පෘෂ්ඨ හොඳින් තාපය අවශෝෂණය කරයි."
  ),
  GlossaryTermItem(
    id = "sci_87",
    englishTerm = "Thermal Expansion",
    sinhalaTerm = "තාප ප්‍රසාරණය",
    tamilTerm = "வெப்ப விரிவு",
    subject = "විද්‍යාව",
    definitionSinhala = "තාපය සැපයූ විට අංශුවල චාලක ශක්තිය වැඩිවීම නිසා ද්‍රව්‍යයක පරිමාව හෝ දිග වැඩිවීම.",
    examTip = "දුම්රිය පීලි අතර හිඩැස් තැබීම සහ ද්විලෝහ පටි තාප ප්‍රසාරණ මූලධර්මය මත පදනම් වේ."
  ),
  GlossaryTermItem(
    id = "sci_88",
    englishTerm = "Evaporation",
    sinhalaTerm = "වාෂ්පීභවනය",
    tamilTerm = "ஆவியாதல்",
    subject = "විද්‍යාව",
    definitionSinhala = "තාපාංකයට වඩා අඩු ඕනෑම උෂ්ණත්වයකදී ද්‍රවයක පෘෂ්ඨික අණු වායුමය අවස්ථාවට පත්වීම.",
    examTip = "වාෂ්පීභවනය සිසිලන ක්‍රියාවලියකි (දහඩිය වාෂ්පීභවනය වී සිරුර සිසිල් කරයි)."
  ),
  GlossaryTermItem(
    id = "sci_89",
    englishTerm = "Absolute Zero",
    sinhalaTerm = "නිරපේක්ෂ ශුන්‍යය",
    tamilTerm = "தனிப்பூச்சியம்",
    subject = "විද්‍යාව",
    definitionSinhala = "න්‍යායාත්මකව පදාර්ථයක සියලුම අංශුවල තාපජ චලිතය සම්පූර්ණයෙන්ම නැවතී ශුන්‍ය වන අවම උෂ්ණත්වය (0 K හෝ -273.15 °C).",
    examTip = "කෙල්වින් පරිමාණය ආරම්භ වන්නේ නිරපේක්ෂ ශුන්‍යයෙනි (K = °C + 273)."
  ),
  GlossaryTermItem(
    id = "sci_90",
    englishTerm = "Greenhouse Effect",
    sinhalaTerm = "හරිතාගාර ආචරණය",
    tamilTerm = "பச்சை வீட்டு விளைவு",
    subject = "විද්‍යාව",
    definitionSinhala = "පෘථිවි පෘෂ්ඨයෙන් පිටවන අධෝරක්ත විකිරණ වායුගෝලයේ CO₂, CH₄, ජල වාෂ්ප මඟින් අවශෝෂණය කර පෘථිවිය උණුසුම්ව තබා ගැනීමේ ස්වභාවික සංසිද්ධිය.",
    examTip = "මානව ක්‍රියාකාරකම් නිසා හරිතාගාර වායු වැඩිවීම ගෝලීය උණුසුම ඉහළ යාමට (Global Warming) හේතුවේ."
  ),

  // GROUP 10 (91 - 100): පරිසරය, පෘථිවිය හා තිරසාරභාවය
  GlossaryTermItem(
    id = "sci_91",
    englishTerm = "Ecosystem",
    sinhalaTerm = "පරිසර පද්ධතිය",
    tamilTerm = "சூழற்தொகுதி",
    subject = "විද්‍යාව",
    definitionSinhala = "කිසියම් භූමි ප්‍රදේශයක ජීවත්වන ජීවී ප්‍රජාව සහ ඔවුන් සමඟ අන්තර්ක්‍රියා කරන අජීවී සාධකවල සමස්ත පද්ධතිය.",
    examTip = "වනාන්තර, කොරල් පර, ගංගා සහ වැව් ස්වභාවික පරිසර පද්ධතිවලට නිදසුන් වේ."
  ),
  GlossaryTermItem(
    id = "sci_92",
    englishTerm = "Trophic Level",
    sinhalaTerm = "පෝෂී මට්ටම",
    tamilTerm = "போசணை மட்டம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ආහාර ජාලයක හෝ ආහාර දාමයක ජීවියෙකු ශක්තිය ලබාගන්නා ස්ථානය (ස්වයංපෝෂී නිෂ්පාදක → ප්‍රාථමික පාරිභෝගික → ද්විතීයික පාරිභෝගික).",
    examTip = "එක් පෝෂී මට්ටමක සිට ඊළඟ මට්ටමට සම්ප්‍රේෂණය වන්නේ ශක්තියෙන් 10% ක් පමණි (10% නීතිය)."
  ),
  GlossaryTermItem(
    id = "sci_93",
    englishTerm = "Eutrophication",
    sinhalaTerm = "යුට්‍රොෆිකේෂණය",
    tamilTerm = "யூட்ரோபிகேஷன்",
    subject = "විද්‍යාව",
    definitionSinhala = "කෘෂිකාර්මික පොහොර හේතුවෙන් ජලාශවලට නයිට්‍රේට් හා පොස්ෆේට් අධික ලෙස එක්වීමෙන් ඇල්ගී සීඝ්‍රයෙන් වර්ධනය වී ඔක්සිජන් ක්ෂයවීම.",
    examTip = "මෙහි අවසන් ප්‍රතිඵලය ලෙස ජලජ මසුන් මියයාම සහ ජලාශ දුර්ගන්ධවත් වීම සිදුවේ."
  ),
  GlossaryTermItem(
    id = "sci_94",
    englishTerm = "Acid Rain",
    sinhalaTerm = "අම්ල වැසි",
    tamilTerm = "அமில மழை",
    subject = "විද්‍යාව",
    definitionSinhala = "SO₂ සහ NO₂ වායු වැසි ජලයේ දියවී සල්ෆියුරික් (H₂SO₄) සහ නයිට්‍රික් (HNO₃) අම්ල සාදමින් pH අගය 5.6 ට වඩා අඩුවී ඇදහැලෙන වර්ෂාව.",
    examTip = "ඓතිහාසික ගොඩනැගිලි, පිළිම සහ ශාක පත්‍ර විනාශ වීමට ප්‍රධාන හේතුවකි."
  ),
  GlossaryTermItem(
    id = "sci_95",
    englishTerm = "Ozone Depletion",
    sinhalaTerm = "ඕසෝන් වියන ක්ෂයවීම",
    tamilTerm = "ஓசோன் படல தேய்வு",
    subject = "විද්‍යාව",
    definitionSinhala = "ක්ලෝරෝෆ්ලෝරෝකාබන් (CFC) වායු හේතුවෙන් අපවර්තී ගෝලයේ පිහිටි ආරක්ෂිත O₃ ස්ථරය විනාශ වීම.",
    examTip = "හානිකර UV කිරණ පෘථිවියට ඒම නිසා චර්ම පිළිකා හා ඇසේ සුද ඇතිවිය හැක."
  ),
  GlossaryTermItem(
    id = "sci_96",
    englishTerm = "Biomagnification",
    sinhalaTerm = "ජෛව විශාලනය",
    tamilTerm = "உயிர் பெருக்கம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ජෛව හායනයට ලක් නොවන බැර ලෝහ (DDT, රසදිය) ආහාර දාමයක් ඔස්සේ ඉහළ පෝෂී මට්ටම්වලට යනවිට සාන්ද්‍රණය වැඩිවීම.",
    examTip = "ආහාර දාමයේ මුදුනේ සිටින මාංශ භක්ෂකයන්ගේ සිරුරු තුළ ඉහළම විෂ සාන්ද්‍රණය තැන්පත් වේ."
  ),
  GlossaryTermItem(
    id = "sci_97",
    englishTerm = "Endemic Species",
    sinhalaTerm = "දේශීය / ආවේණික විශේෂ",
    tamilTerm = "குறிப்பிட்ட இடத்திற்குரிய இனம்",
    subject = "විද්‍යාව",
    definitionSinhala = "ලෝකයේ වෙනත් කිසිදු ස්වභාවික ප්‍රදේශයක හමුනොවන, නිශ්චිත භූගෝලීය කලාපයකට පමණක් සීමා වූ ජීවී විශේෂ.",
    examTip = "ශ්‍රී ලංකා වලි කුකුළා (Ceylon Junglefowl) සහ හෝර්ටන් තැන්න කටුස්සා මීට උදාහරණ වේ."
  ),
  GlossaryTermItem(
    id = "sci_98",
    englishTerm = "Plate Tectonics",
    sinhalaTerm = "භූ තල චලන",
    tamilTerm = "புவித்தட்டு அசைவுகள்",
    subject = "විද්‍යාව",
    definitionSinhala = "පෘථිවි ශිලාගෝලය සමන්විත වන දැවැන්ත භූ තැටි දුර්වල ගෝලය මත එකිනෙක ගැටෙමින් හෝ ඈත්වෙමින් සිදුවන සංචලනය.",
    examTip = "භූමිකම්පා, ගිනිකඳු පිපිරීම් සහ සුනාමි ඇතිවීමට භූ තල මායිම්වල චලනය හේතු වේ."
  ),
  GlossaryTermItem(
    id = "sci_99",
    englishTerm = "Renewable Energy",
    sinhalaTerm = "පුනර්ජනනීය බලශක්තිය",
    tamilTerm = "புதுப்பிக்கத்தக்க சக்தி",
    subject = "විද්‍යාව",
    definitionSinhala = "භාවිතය නිසා ස්වභාවිකව ක්ෂය නොවන, ස්වභාවධර්මයෙන් කෙටි කලකින් යළි ප්‍රතිපූර්ණය වන බලශක්ති ප්‍රභව.",
    examTip = "සූර්ය, සුළං, ජල විදුලි හා ජෛව ස්කන්ධ පුනර්ජනනීය වන අතර පොසිල ඉන්ධන පුනර්ජනනීය නොවේ."
  ),
  GlossaryTermItem(
    id = "sci_100",
    englishTerm = "Carbon Footprint",
    sinhalaTerm = "කාබන් පියසටහන",
    tamilTerm = "கார்பன் தடம்",
    subject = "විද්‍යාව",
    definitionSinhala = "පුද්ගලයෙකුගේ, සංවිධානයක හෝ ක්‍රියාවලියක සෘජු හා වක්‍ර ක්‍රියාකාරකම් නිසා වායුගෝලයට මුදාහැරෙන මුළු හරිතාගාර වායු ප්‍රමාණය.",
    examTip = "කාබන් පියසටහන අවම කිරීම ගෝලීය දේශගුණ විපර්යාස පාලනය කිරීමේ ප්‍රධාන පියවරකි."
  )
)
