package com.example

// 100 Sri Lankan O/L Information & Communication Technology (ICT) Trilingual Glossary Terms
// Divided into 10 groups of 10 words (1-10 each)
val ictGlossary100Terms = listOf(
  // GROUP 1 (1 - 10): පරිගණක දෘඩාංග හා ගෘහ නිර්මාණ ශිල්පය
  GlossaryTermItem(
    id = "ict_01",
    englishTerm = "Central Processing Unit (CPU)",
    sinhalaTerm = "මධ්‍ය සැකසුම් ඒකකය",
    tamilTerm = "மையச் செயலகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණකයට ලැබෙන උපදෙස් අර්ථකථනය කරමින් පරිගණකයේ සමස්ත ක්‍රියාකාරීත්වය පාලනය කරන ප්‍රධාන මොළය.",
    examTip = "CPU සමන්විත වන්නේ ALU (ගණිත හා තර්ක ඒකකය), CU (පාලන ඒකකය) සහ රෙජිස්ටර් මතක වලිනි."
  ),
  GlossaryTermItem(
    id = "ict_02",
    englishTerm = "Random Access Memory (RAM)",
    sinhalaTerm = "සසම්භාවී ප්‍රවේශ මතකය",
    tamilTerm = "எழுமாற்று அணுகல் நினைவகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණකය ක්‍රියාත්මකව පවතින විට පමණක් දත්ත තාවකාලිකව රඳවා ගන්නා ප්‍රධාන වාෂ්පශීලී (Volatile) මතකය.",
    examTip = "විදුලිය විසන්ධි වූ වහාම RAM හි ඇති දත්ත සම්පූර්ණයෙන්ම මැකී යයි."
  ),
  GlossaryTermItem(
    id = "ict_03",
    englishTerm = "Read Only Memory (ROM)",
    sinhalaTerm = "කියවීම පමණක් ඇති මතකය",
    tamilTerm = "வாசிப்பு மட்டும் நினைவகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණකය පණගැන්වීමේ මූලික උපදෙස් (BIOS/Firmware) ස්ථිරව ගබඩා කර ඇති අවාෂ්පශීලී (Non-volatile) මතකය.",
    examTip = "විදුලිය විසන්ධි වුවද ROM හි අඩංගු දත්ත මැකී නොයයි."
  ),
  GlossaryTermItem(
    id = "ict_04",
    englishTerm = "Cache Memory",
    sinhalaTerm = "කැෂේ මතකය",
    tamilTerm = "இடைமாற்று நினைவகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "CPU සහ ප්‍රධාන මතකය (RAM) අතර පිහිටි, නිතර භාවිතා වන උපදෙස් ක්ෂණිකව ලබාදෙන අතිවේගී කුඩා මතකය.",
    examTip = "L1, L2, L3 ලෙස මට්ටම් පවතින අතර CPU හි වේගය උපරිම කිරීමට උපකාරී වේ."
  ),
  GlossaryTermItem(
    id = "ict_05",
    englishTerm = "Motherboard",
    sinhalaTerm = "මව්පුවරුව",
    tamilTerm = "தாய்ப்பலகை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "CPU, RAM, සහ සියලුම ආදාන/ප්‍රතිදාන උපාංග එකිනෙක විද්‍යුත් ලෙස සම්බන්ධ කරන පරිගණකයේ ප්‍රධාන පරිපථ පුවරුව.",
    examTip = "පද්ධති බස් (System Buses) මඟින් මව්පුවරුව හරහා සංඥා හුවමාරු වේ."
  ),
  GlossaryTermItem(
    id = "ict_06",
    englishTerm = "Solid State Drive (SSD)",
    sinhalaTerm = "ඝන-තත්ව ධාවකය",
    tamilTerm = "திண்மநிலை இயக்கி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "යාන්ත්‍රික චලනය වන කොටස් රහිත, ෆ්ලෑෂ් මතක තාක්ෂණයෙන් ක්‍රියාකරන වේගවත් ද්විතියික ගබඩා උපාංගයකි.",
    examTip = "HDD වලට වඩා SSD අධික වේගවත්, අඩු ශක්තියක් ගන්නා සහ කම්පනවලට ඔරොත්තු දෙන සුළුය."
  ),
  GlossaryTermItem(
    id = "ict_07",
    englishTerm = "Hard Disk Drive (HDD)",
    sinhalaTerm = "දෘඪ තැටි ධාවකය",
    tamilTerm = "வன்வட்டு இயக்கி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "චුම්භක තැටි (platters) මත දත්ත ස්ථිරව ගබඩා කරන සාම්ප්‍රදායික ඉහළ ධාරිතාවකින් යුත් ද්විතීයික ආචයනය.",
    examTip = "භ්‍රමණය වන තැටි සහ චුම්භක කියවීම්/ලිවීම් හිස් (Read/Write heads) අඩංගු වේ."
  ),
  GlossaryTermItem(
    id = "ict_08",
    englishTerm = "Arithmetic Logic Unit (ALU)",
    sinhalaTerm = "ගණිතමය හා තාර්කික ඒකකය",
    tamilTerm = "கணித ஏரண அகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "මූලික ගණිත කර්ම (+, -, ×, ÷) සහ තාර්කික සංසන්දන (AND, OR, NOT) සිදුකරන CPU හි කොටස.",
    examTip = "සංසන්දනාත්මක තීරණ ගැනීමේදී කොන්දේසි පරීක්ෂා කරන්නේ ALU මඟිනි."
  ),
  GlossaryTermItem(
    id = "ict_09",
    englishTerm = "Control Unit (CU)",
    sinhalaTerm = "පාලන ඒකකය",
    tamilTerm = "கட்டுப்பாட்டு அகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණක පද්ධතිය තුළ දත්ත හා උපදෙස් ගලායාම සහ සියලුම උපාංගවල ක්‍රියාකාරිත්වය සංවිධානය කරන ඒකකය.",
    examTip = "උපදෙස් චක්‍රය (Fetch - Decode - Execute) මෙහෙයවන්නේ පාලන ඒකකයයි."
  ),
  GlossaryTermItem(
    id = "ict_10",
    englishTerm = "Register",
    sinhalaTerm = "රෙජිස්ටරය",
    tamilTerm = "பதிவகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "CPU අභ්‍යන්තරයේම පිහිටි, සැකසුම් කාර්යයන් සඳහා අවශ්‍ය ඉතා සුළු දත්ත ප්‍රමාණයක් අකුණු වේගයෙන් රඳවාගන්නා මතක ස්ථානය.",
    examTip = "PC (Program Counter), MAR, MBR සහ Accumulator ප්‍රධාන රෙජිස්ටර් වර්ග වේ."
  ),

  // GROUP 2 (11 - 20): මෘදුකාංග හා මෙහෙයුම් පද්ධති
  GlossaryTermItem(
    id = "ict_11",
    englishTerm = "Operating System (OS)",
    sinhalaTerm = "මෙහෙයුම් පද්ධතිය",
    tamilTerm = "இயங்குதளம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිශීලකයා සහ පරිගණක දෘඩාංග අතර අතරමැදියෙකු ලෙස ක්‍රියාකරමින් සම්පත් කළමනාකරණය කරන පද්ධති මෘදුකාංගය.",
    examTip = "Windows, Linux, macOS, Android සහ iOS ප්‍රධාන මෙහෙයුම් පද්ධති වේ."
  ),
  GlossaryTermItem(
    id = "ict_12",
    englishTerm = "Open Source Software",
    sinhalaTerm = "විවෘත මූලාශ්‍ර මෘදුකාංග",
    tamilTerm = "திறந்த மூல மென்பொருள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "මූල කේතය (Source code) ඕනෑම අයෙකුට නොමිලේ බැලීමට, සංශෝධනය කිරීමට සහ බෙදාහැරීමට නීත්‍යානුකූලව අවසර දී ඇති මෘදුකාංග.",
    examTip = "Linux, LibreOffice, GIMP, Python විවෘත මූලාශ්‍ර මෘදුකාංග සඳහා නිදසුන් වේ."
  ),
  GlossaryTermItem(
    id = "ict_13",
    englishTerm = "Proprietary Software",
    sinhalaTerm = "හිමිකාරිත්ව / වාණිජ මෘදුකාංග",
    tamilTerm = "உரிம மென்பொருள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "මූල කේතය රහසිගතව තබාගන්නා, භාවිතය සඳහා බලපත්‍රයක් (License) මිලදී ගත යුතු මෘදුකාංග.",
    examTip = "Microsoft Windows, Adobe Photoshop, Microsoft Office හිමිකාරිත්ව මෘදුකාංග වේ."
  ),
  GlossaryTermItem(
    id = "ict_14",
    englishTerm = "Device Driver",
    sinhalaTerm = "උපාංග ධාවකය",
    tamilTerm = "சாதன இயக்கி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ප්‍රින්ටරය හෝ ස්කෑනරය වැනි දෘඩාංග උපාංගයක් මෙහෙයුම් පද්ධතිය සමඟ සන්නිවේදනය කරවීමට අවශ්‍ය විශේෂිත මෘදුකාංගය.",
    examTip = "උපාංගයක් පරිගණකයට සම්බන්ධ කළ විට එය හඳුනාගෙන ක්‍රියාත්මක කරන්නේ ධාවකය මඟිනි."
  ),
  GlossaryTermItem(
    id = "ict_15",
    englishTerm = "Utility Software",
    sinhalaTerm = "උපයෝගීතා මෘදුකාංග",
    tamilTerm = "பயன்பாட்டு மென்பொருள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණක පද්ධතියේ නඩත්තුව, ආරක්ෂාව සහ සුමට ක්‍රියාකාරිත්වය පවත්වාගෙන යාමට සහාය වන මෘදුකාංග.",
    examTip = "Antivirus, Disk Defragmenter, Backup software උපයෝගීතා මෘදුකාංග වේ."
  ),
  GlossaryTermItem(
    id = "ict_16",
    englishTerm = "Virtual Memory",
    sinhalaTerm = "සථ්‍ය / අතථ්‍ය මතකය",
    tamilTerm = "மெய்நிகர் நினைவகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "RAM මතකය ප්‍රමාණවත් නොවන අවස්ථාවලදී දෘඪ තැටියෙන් කොටසක් තාවකාලික මතකයක් ලෙස භාවිතයට ගැනීමේ ක්‍රමය.",
    examTip = "පේජිං (Paging) තාක්ෂණය මඟින් පිටු හුවමාරු කිරීම සිදු කරයි."
  ),
  GlossaryTermItem(
    id = "ict_17",
    englishTerm = "Graphical User Interface (GUI)",
    sinhalaTerm = "චිත්‍රක පරිශීලක අතුරුමුහුණත",
    tamilTerm = "வரைகலை பயனர் இடைமுகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වින්ඩෝස්, අයිකන, මෙනු සහ පොයින්ටර් (WIMP) භාවිතයෙන් පරිශීලකයාට දෘශ්‍යමානව පරිගණකය හැසිරවීමට ඉඩ සලසන අතුරුමුහුණත.",
    examTip = "CLI (විධාන පේළි අතුරුමුහුණත) ට වඩා GUI භාවිතය පහසු සහ පරිශීලක-හිතකාමී වේ."
  ),
  GlossaryTermItem(
    id = "ict_18",
    englishTerm = "Multitasking",
    sinhalaTerm = "බහුකාර්යතාව",
    tamilTerm = "பலவேலை இயக்கம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "එක් CPU එකක් මඟින් එකවර යෙදුම් වැඩසටහන් කිහිපයක් එකිනෙකට වේගයෙන් මාරු වෙමින් ක්‍රියාත්මක කිරීමේ හැකියාව.",
    examTip = "ගීතයක් අසන අතරතුර ලියවිල්ලක් ටයිප් කිරීමට පරිශීලකයාට ඉඩ දෙන්නේ බහුකාර්යතාවයෙනි."
  ),
  GlossaryTermItem(
    id = "ict_19",
    englishTerm = "Compiler",
    sinhalaTerm = "සම්පාදකය",
    tamilTerm = "தொகுப்பி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ඉහළ මට්ටමේ ක්‍රමලේඛන කේතය (High-level code) සම්පූර්ණයෙන්ම එකවර යන්ත්‍ර භාෂාවට (Machine code) පරිවර්තනය කරන පරිවර්තක මෘදුකාංගය.",
    examTip = "C, C++ වැනි භාෂා සම්පාදක භාවිත කරන අතර සම්පාදනයෙන් පසු .exe ගොනුවක් සෑදේ."
  ),
  GlossaryTermItem(
    id = "ict_20",
    englishTerm = "Interpreter",
    sinhalaTerm = "අර්ථවින්‍යාසකය",
    tamilTerm = "மொழிபெயர்ப்பி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "මූල කේතය එක් පේළිය බැගින් කියවමින් ක්‍රියාත්මක කරන අතර දෝෂයක් හමු වූ වහාම නැවතෙන පරිවර්තකය.",
    examTip = "Python භාෂාව මූලිකව අර්ථවින්‍යාසකයක් මඟින් ක්‍රියාත්මක වේ."
  ),

  // GROUP 3 (21 - 30): දත්ත නිරූපණය හා සංඛ්‍යා පද්ධති
  GlossaryTermItem(
    id = "ict_21",
    englishTerm = "Bit (Binary Digit)",
    sinhalaTerm = "බිටුව",
    tamilTerm = "பிட் (இருமை இலக்கம்)",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණකයක ගබඩා කළ හැකි කුඩාම දත්ත ඒකකය (0 හෝ 1 අගය ගනී).",
    examTip = "බිටු 8ක් එකතු වූ විට බයිටයක් (Byte) සෑදේ."
  ),
  GlossaryTermItem(
    id = "ict_22",
    englishTerm = "Byte",
    sinhalaTerm = "බයිටය",
    tamilTerm = "பைட்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "තනි අක්ෂරයක් හෝ සංකේතයක් නිරූපණය කිරීමට ප්‍රමාණවත් වන බිටු 8 කින් සමන්විත සමූහය.",
    examTip = "1 KB = 1024 Bytes, 1 MB = 1024 KB, 1 GB = 1024 MB, 1 TB = 1024 GB."
  ),
  GlossaryTermItem(
    id = "ict_23",
    englishTerm = "Binary System",
    sinhalaTerm = "ද්විමය පද්ධතිය",
    tamilTerm = "இருமை எண் முறைமை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පාදය 2 වන, 0 සහ 1 යන සංකේත දෙක පමණක් භාවිතා කරන සංඛ්‍යා පද්ධතිය.",
    examTip = "ඩිජිටල් පරිගණක අභ්‍යන්තරයේ සියලුම දත්ත නිරූපණය කරන්නේ ද්විමය ආකාරයෙනි."
  ),
  GlossaryTermItem(
    id = "ict_24",
    englishTerm = "Hexadecimal System",
    sinhalaTerm = "ෂඩ්දශම පද්ධතිය",
    tamilTerm = "பதின்அறுமை எண் முறைமை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පාදය 16 වන, 0-9 දක්වා ඉලක්කම් සහ A-F දක්වා අකුරු (A=10 සිට F=15) භාවිතා කරන සංඛ්‍යා පද්ධතිය.",
    examTip = "මතක ලිපින (Memory addresses), MAC ලිපින සහ HTML වර්ණ කේත දැක්වීමට යොදා ගනී."
  ),
  GlossaryTermItem(
    id = "ict_25",
    englishTerm = "Octal System",
    sinhalaTerm = "අෂ්ටක පද්ධතිය",
    tamilTerm = "எண்ம எண் முறைமை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පාදය 8 වන, 0 සිට 7 දක්වා සංඛ්‍යාංක 8ක් පමණක් භාවිතා කරන සංඛ්‍යා පද්ධතිය.",
    examTip = "එක් අෂ්ටක සංඛ්‍යාංකයක් ද්විමය බිටු 3ක් මඟින් නිරූපණය කළ හැක."
  ),
  GlossaryTermItem(
    id = "ict_26",
    englishTerm = "ASCII Code",
    sinhalaTerm = "ASCII කේතය",
    tamilTerm = "ASCII குறியீடு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "අක්ෂර සහ සංකේත නිරූපණය සඳහා බිටු 7 ක් (හෝ 8 ක්) යොදා ගන්නා ප්‍රමිතිගත ඇමරිකානු කේත ක්‍රමය.",
    examTip = "'A' හි ASCII අගය 65 වන අතර 'a' හි අගය 97 වේ."
  ),
  GlossaryTermItem(
    id = "ict_27",
    englishTerm = "Unicode",
    sinhalaTerm = "යුනිකෝඩ්",
    tamilTerm = "யூனிகோட் (ஒருங்குறி)",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ලෝකයේ සියලුම භාෂාවල (සිංහල, දෙමළ, ඉංග්‍රීසි ආදී) අක්ෂර පරිගණකයේ නිරූපණය කිරීමට බිටු 16 හෝ 32 භාවිත කරන ගෝලීය කේතන ක්‍රමය.",
    examTip = "සිංහල හා දෙමළ අක්ෂර අන්තර්ජාලයේ නිවැරදිව පෙන්වීමට යුනිකෝඩ් භාවිතා වේ."
  ),
  GlossaryTermItem(
    id = "ict_28",
    englishTerm = "Two's Complement",
    sinhalaTerm = "දෙකේ අනුපූරකය",
    tamilTerm = "இரண்டின் நிரப்பி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ද්විමය සෘණ සංඛ්‍යා පරිගණකයේ නිරූපණය කිරීම සඳහා බිටු ප්‍රතිලෝම කර (එකේ අනුපූරකය ගෙන) 1ක් එකතු කිරීමේ ක්‍රමය.",
    examTip = "පළමු බිටුව 1 නම් එය සෘණ සංඛ්‍යාවකි (Sign bit)."
  ),
  GlossaryTermItem(
    id = "ict_29",
    englishTerm = "Pixel",
    sinhalaTerm = "පික්සලය (රූප අංශුව)",
    tamilTerm = "படத்துணுக்கு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ඩිජිටල් තිරයක හෝ ඩිජිටල් ඡායාරූපයක ඇති කුඩාම තනි වර්ණ තිත.",
    examTip = "විභේදනය (Resolution) = තිරයේ තිරස් පික්සල × සිරස් පික්සල."
  ),
  GlossaryTermItem(
    id = "ict_30",
    englishTerm = "Lossless Compression",
    sinhalaTerm = "හානි රහිත සම්පීඩනය",
    tamilTerm = "இழப்பற்ற சுருக்கம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ගොනුවේ මුල් දත්තවල කිසිදු අඩුවක් නොවී ගොනු ප්‍රමාණය අඩුකරන ක්‍රමය (උදා: ZIP, PNG).",
    examTip = "නැවත විහිදවූ (Decompressed) පසු මුල් ගොනුව ඒ ආකාරයෙන්ම නැවත ලැබේ."
  ),

  // GROUP 4 (31 - 40): පරිගණක ජාල හා අන්තර්ජාලය
  GlossaryTermItem(
    id = "ict_31",
    englishTerm = "Local Area Network (LAN)",
    sinhalaTerm = "ප්‍රාදේශීය ජාලය",
    tamilTerm = "குறும்பரப்பு வலையமைப்பு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "එක් ගොඩනැගිල්ලක් හෝ පාසල් පරිගණක විද්‍යාගාරයක් වැනි සීමිත භූගෝලීය ප්‍රදේශයක පරිගණක එකිනෙක සම්බන්ධ කළ ජාලය.",
    examTip = "LAN ජාල සඳහා අධිවේගී Ethernet රැහැන් සහ Wi-Fi භාවිතා වේ."
  ),
  GlossaryTermItem(
    id = "ict_32",
    englishTerm = "Wide Area Network (WAN)",
    sinhalaTerm = "පුළුල් ප්‍රදේශ ජාලය",
    tamilTerm = "பரந்த பரப்பு வலையமைப்பு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "රටවල් හෝ මහාද්වීප පුරා පැතිරුණු දැවැන්ත භූගෝලීය කලාපයක් ආවරණය කරන පරිගණක ජාලය.",
    examTip = "ලොව විශාලතම WAN ජාලය වන්නේ 'අන්තර්ජාලය' (Internet) යි."
  ),
  GlossaryTermItem(
    id = "ict_33",
    englishTerm = "IP Address",
    sinhalaTerm = "IP ලිපිනය",
    tamilTerm = "IP முகவரி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "TCP/IP ජාලයකට සම්බන්ධ ඕනෑම උපාංගයක් අනන්‍යව හඳුනාගැනීම සඳහා ලබාදෙන තාර්කික සංඛ්‍යාත්මක ලිපිනය.",
    examTip = "IPv4 ලිපිනයක් බිටු 32 කි (තිත් 3 කින් වෙන්වූ සංඛ්‍යා 4ක්: 192.168.1.1)."
  ),
  GlossaryTermItem(
    id = "ict_34",
    englishTerm = "MAC Address",
    sinhalaTerm = "MAC ලිපිනය (මාධ්‍ය ප්‍රවේශ පාලන ලිපිනය)",
    tamilTerm = "MAC முகவரி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ජාල කාඩ්පත (NIC) නිෂ්පාදනය කිරීමේදී ඊට ලබාදෙන ස්ථිර භෞතික දෘඩාංග ලිපිනය.",
    examTip = "බිටු 48 කින් සමන්විත වන අතර ෂඩ්දශම අංකන ක්‍රමයෙන් ලියනු ලැබේ."
  ),
  GlossaryTermItem(
    id = "ict_35",
    englishTerm = "Router",
    sinhalaTerm = "රවුටරය",
    tamilTerm = "திசைவி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "විවිධ ජාල එකිනෙක සම්බන්ධ කරමින් දත්ත පැකට් වඩාත් සුදුසු මාර්ගය ඔස්සේ ගමනාන්තය වෙත යොමුකරන ජාල උපාංගය.",
    examTip = "නිවසේ LAN ජාලය අන්තර්ජාලයට (WAN) සම්බන්ධ කරන්නේ රවුටරයෙනි."
  ),
  GlossaryTermItem(
    id = "ict_36",
    englishTerm = "Switch",
    sinhalaTerm = "ස්විචය",
    tamilTerm = "இணைப்பி (சுவிட்ச்)",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ජාලයක උපාංග අතර දත්ත හුවමාරු කිරීමේදී අදාළ උපාංගයේ MAC ලිපිනය බලා එම උපාංගයට පමණක් දත්ත යවන බුද්ධිමත් මධ්‍ය උපාංගය.",
    examTip = "හුබ් (Hub) මෙන් සියලු දෙනාට විකාශනය (broadcast) නොකර නිශ්චිත ඉලක්කයට දත්ත යවයි."
  ),
  GlossaryTermItem(
    id = "ict_37",
    englishTerm = "Domain Name System (DNS)",
    sinhalaTerm = "වසම් නාම පද්ධතිය",
    tamilTerm = "டொமைன் பெயர் முறைமை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "මිනිසුන්ට මතක තබාගත හැකි වෙබ් අඩවි නාම (උදා: google.com) පරිගණක තේරුම් ගන්නා IP ලිපින බවට පරිවර්තනය කරන පද්ධතිය.",
    examTip = "අන්තර්ජාලයේ දුරකථන නාමාවලිය (Phonebook) ලෙස DNS ක්‍රියා කරයි."
  ),
  GlossaryTermItem(
    id = "ict_38",
    englishTerm = "HTTP / HTTPS",
    sinhalaTerm = "අධිපෙළ සම්ප්‍රේෂණ කෙටුම්පත",
    tamilTerm = "மீவுரை பரிமாற்ற நெறிமுறை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වෙබ් සේවාදායකයක් සහ වෙබ් බ්‍රව්සරයක් අතර වෙබ් පිටු හුවමාරු කිරීමේ නීති මාලාව (HTTPS හි S යනු ආරක්ෂිත/ගුප්තකේතනය කළ SSL වේ).",
    examTip = "බැංකු හා මුදල් ගනුදෙනු සඳහා සෑම විටම සුරක්ෂිත HTTPS භාවිතා කළ යුතුය."
  ),
  GlossaryTermItem(
    id = "ict_39",
    englishTerm = "Topology",
    sinhalaTerm = "ජාල ස්ථාලිතිය",
    tamilTerm = "வலையமைப்பு இடவியல்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණක ජාලයක උපාංග භෞතිකව හෝ තාර්කිකව එකිනෙක සම්බන්ධ කර ඇති ජ්‍යාමිතික ආකාරය.",
    examTip = "Star (තරු), Bus (බස්), Ring (මුදු), සහ Mesh (දැල්) ප්‍රධාන ස්ථාලිතීන් වේ."
  ),
  GlossaryTermItem(
    id = "ict_40",
    englishTerm = "Bandwidth",
    sinhalaTerm = "කලාප පළල",
    tamilTerm = "அலைவரிசை அகலம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "සන්නිවේදන මාධ්‍යයක් හරහා තත්පරයකදී සම්ප්‍රේෂණය කළ හැකි උපරිම දත්ත ප්‍රමාණය (bps වලින් මනිනු ලැබේ).",
    examTip = "කලාප පළල වැඩි වන තරමට අන්තර්ජාල සම්බන්ධතාවයේ දත්ත හුවමාරු වේගය වැඩි වේ."
  ),

  // GROUP 5 (41 - 50): ඇල්ගොරිතම හා ගැලීම් සටහන්
  GlossaryTermItem(
    id = "ict_41",
    englishTerm = "Algorithm",
    sinhalaTerm = "ඇල්ගොරිතමය",
    tamilTerm = "படிமுறை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "යම් නිශ්චිත ගැටලුවක් විසඳීම සඳහා පිළිපැදිය යුතු, සීමිත පියවර සංඛ්‍යාවකින් සමන්විත, නිරවුල් උපදෙස් මාලාව.",
    examTip = "ඇල්ගොරිතම නිරූපණය කිරීමට ගැලීම් සටහන් සහ ව්‍යාජ කේත යොදා ගනී."
  ),
  GlossaryTermItem(
    id = "ict_42",
    englishTerm = "Flowchart",
    sinhalaTerm = "ගැලීම් සටහන",
    tamilTerm = "பாய்வுப்படம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ඇල්ගොරිතමයක පියවර සහ ඒවා ක්‍රියාත්මක වන අනුපිළිවෙල ප්‍රමිතිගත ජ්‍යාමිතික රූප මඟින් දෘශ්‍යමානව නිරූපණය කිරීම.",
    examTip = "ගැලීම් ඊතල මඟින් පාලනය ගලා යන දිශාව පෙන්වයි."
  ),
  GlossaryTermItem(
    id = "ict_43",
    englishTerm = "Pseudocode",
    sinhalaTerm = "ව්‍යාජ කේත",
    tamilTerm = "போலிக் குறிமுறை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ක්‍රමලේඛන භාෂාවක නිශ්චිත වාක්‍ය ඛණ්ඩ නීතිවලින් තොරව, සාමාන්‍ය ඉංග්‍රීසි භාෂාවට සමාන ව්‍යුහගත පදවලින් ඇල්ගොරිතමය ලිවීම.",
    examTip = "START, INPUT, IF-THEN-ELSE, WHILE, OUTPUT, STOP වැනි වචන භාවිත කරයි."
  ),
  GlossaryTermItem(
    id = "ict_44",
    englishTerm = "Terminal Symbol",
    sinhalaTerm = "පර්යන්ත සංකේතය",
    tamilTerm = "முடிவுக்குறியீடு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ගැලීම් සටහනක ආරම්භය (Start) සහ අවසානය (Stop) දැක්වීම සඳහා භාවිතා කරන ඉලිප්සාකාර හෝ වටකුරු සෘජුකෝණාස්‍ර සංකේතය.",
    examTip = "සෑම ගැලීම් සටහනකටම එක් ආරම්භයක් සහ අවම වශයෙන් එක් අවසානයක් තිබිය යුතුය."
  ),
  GlossaryTermItem(
    id = "ict_45",
    englishTerm = "Input / Output Symbol",
    sinhalaTerm = "ආදාන / ප්‍රතිදාන සංකේතය",
    tamilTerm = "உள்ளீடு / வெளியீட்டுக் குறியீடு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ගැලීම් සටහනක දත්ත ලබාගැනීම (Read/Input) හෝ ප්‍රතිඵල පෙන්වීම (Display/Print) දැක්වීමට යොදාගන්නා සමාන්තරාස්‍ර සංකේතය.",
    examTip = "උදා: 'Enter Marks' හෝ 'Print Total'."
  ),
  GlossaryTermItem(
    id = "ict_46",
    englishTerm = "Process Symbol",
    sinhalaTerm = "සැකසුම් සංකේතය",
    tamilTerm = "செயன்முறைக் குறியீடு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ගණිතමය ගණනය කිරීම් හෝ අගයක් ආරෝපණය කිරීම දැක්වීමට භාවිතා කරන සෘජුකෝණාස්‍ර සංකේතය.",
    examTip = "උදා: Total = Mark1 + Mark2 හෝ count = 0."
  ),
  GlossaryTermItem(
    id = "ict_47",
    englishTerm = "Decision Symbol",
    sinhalaTerm = "තීරණ සංකේතය",
    tamilTerm = "தீர்மானக் குறியீடு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "කොන්දේසියක් පරීක්ෂා කර සත්‍ය (Yes) හෝ අසත්‍ය (No) ප්‍රතිඵලය මත මාර්ග දෙකකට බෙදීම දක්වන රොම්බස (දියමන්ති) හැඩැති සංකේතය.",
    examTip = "රොම්බසයෙන් සෑමවිටම පිටවන ගැලීම් මාර්ග අවම වශයෙන් 2ක් (Yes/No) තිබිය යුතුය."
  ),
  GlossaryTermItem(
    id = "ict_48",
    englishTerm = "Sequence Control Structure",
    sinhalaTerm = "අනුක්‍රමික පාලන ව්‍යුහය",
    tamilTerm = "தொடர் கட்டுப்பாட்டுக் கட்டமைப்பு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "උපදෙස් එකින් එක ඉහළ සිට පහළට ලියන ලද අනුපිළිවෙලටම එකවර ක්‍රියාත්මක වන සරල ව්‍යුහය.",
    examTip = "කිසිදු පැනීමක් හෝ කොන්දේසි පරීක්ෂාවක් මෙහි නැත."
  ),
  GlossaryTermItem(
    id = "ict_49",
    englishTerm = "Selection / Decision Structure",
    sinhalaTerm = "වරණ / තේරීම් පාලන ව්‍යුහය",
    tamilTerm = "தெரிவுக் கட்டுப்பாட்டுக் கட்டமைப்பு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "දී ඇති කොන්දේසියක් සත්‍යද අසත්‍යද යන්න මත විකල්ප ක්‍රියාමාර්ග අතරින් එකක් තෝරාගෙන ක්‍රියාත්මක කිරීම (IF-THEN-ELSE).",
    examTip = "ශිෂ්‍යයා සමත්ද අසමත්ද යන්න තීරණය කිරීමට තේරීම් ව්‍යුහය භාවිත වේ."
  ),
  GlossaryTermItem(
    id = "ict_50",
    englishTerm = "Iteration / Repetition Structure",
    sinhalaTerm = "පුනරාවර්තන / ලූප පාලන ව්‍යුහය",
    tamilTerm = "மீளல் / மடக்குக் கட்டமைப்பு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "කොන්දේසියක් තෘප්ත වන තුරු කිසියම් ක්‍රියාවලි සමූහයක් නැවත නැවත සිදු කිරීම (FOR, WHILE ලූප).",
    examTip = "ශිෂ්‍යයන් 50 දෙනෙකුගේ සාමාන්‍ය ලකුණු සෙවීමට ලූපයක් භාවිතා කළ හැක."
  ),

  // GROUP 6 (51 - 60): ක්‍රමලේඛන මූලධර්ම (Python ආශ්‍රිත)
  GlossaryTermItem(
    id = "ict_51",
    englishTerm = "Variable",
    sinhalaTerm = "විචල්‍යය",
    tamilTerm = "மாறி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වැඩසටහනක් ක්‍රියාත්මක වන අතරතුර අගයන් වෙනස් විය හැකි, පරිගණක මතකයේ අගයක් රඳවා ගන්නා නම් කළ ස්ථානයක්.",
    examTip = "Python හි විචල්‍ය නාම ඉලක්කමකින් ආරම්භ නොවිය යුතුය."
  ),
  GlossaryTermItem(
    id = "ict_52",
    englishTerm = "Constant",
    sinhalaTerm = "නියතය",
    tamilTerm = "மாறிலி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වැඩසටහන ක්‍රියාත්මක වන කාලය පුරාවට එහි ආරම්භක අගය කිසිසේත්ම වෙනස් නොවන දත්ත අගයක් (උදා: PI = 3.14).",
    examTip = "සාමාන්‍යයෙන් නියත නම් කරන්නේ CAPITAL අකුරුවලිනි."
  ),
  GlossaryTermItem(
    id = "ict_53",
    englishTerm = "Data Types",
    sinhalaTerm = "දත්ත වර්ග",
    tamilTerm = "தரவு வகைகள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "විචල්‍යයක ගබඩා කළ හැකි දත්තවල ස්වභාවය (Integer, Float, String, Boolean ආදී).",
    examTip = "int: පූර්ණ සංඛ්‍යා, float: දශම සංඛ්‍යා, str: පාඨ/අක්ෂර, bool: True/False."
  ),
  GlossaryTermItem(
    id = "ict_54",
    englishTerm = "Syntax Error",
    sinhalaTerm = "වාක්‍ය ඛණ්ඩ දෝෂය",
    tamilTerm = "தொடரியல் பிழை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ක්‍රමලේඛන භාෂාවේ ව්‍යාකරණ හෝ නීති කඩකිරීම නිසා කේතය සම්පාදනය හෝ අර්ථකථනය කිරීමට නොහැකි වීම.",
    examTip = "වරහන් හෝ කෝමා අමතක වීම, අක්ෂර වින්‍යාස වැරදි මීට අයත් වේ."
  ),
  GlossaryTermItem(
    id = "ict_55",
    englishTerm = "Logical Error",
    sinhalaTerm = "තාර්කික දෝෂය",
    tamilTerm = "ஏரணப் பிழை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ක්‍රමලේඛය සාර්ථකව ක්‍රියාත්මක වුවද ක්‍රමලේඛකයාගේ සිතීමේ වරදක් නිසා බලාපොරොත්තු නොවන වැරදි ප්‍රතිඵලයක් ලැබීම.",
    examTip = "සාමාන්‍ය සෙවීමට එකතුව 2න් බෙදීම වෙනුවට 3න් බෙදීම තාර්කික දෝෂයකි."
  ),
  GlossaryTermItem(
    id = "ict_56",
    englishTerm = "Runtime Error",
    sinhalaTerm = "ධාවන කාල දෝෂය",
    tamilTerm = "இயக்கநேரப் பிழை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ක්‍රමලේඛය ධාවනය වන අතරතුර හදිසියේ සිදුවන අනපේක්ෂිත දෝෂයක් නිසා ක්‍රමලේඛය බිඳවැටීම.",
    examTip = "සංඛ්‍යාවක් ශුන්‍යයෙන් බෙදීමට උත්සාහ කිරීම (ZeroDivisionError) මීට නිදසුනකි."
  ),
  GlossaryTermItem(
    id = "ict_57",
    englishTerm = "Concatenation",
    sinhalaTerm = "පාඨ / ස්ට්‍රිං එක්කිරීම",
    tamilTerm = "சரங்களை இணைத்தல்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ස්ට්‍රිං (strings) දෙකක් හෝ කිහිපයක් එකිනෙකට යාකර තනි ස්ට්‍රිං එකක් සෑදීම (+ ලකුණින්).",
    examTip = "'O/L' + ' ' + 'ICT' = 'O/L ICT'."
  ),
  GlossaryTermItem(
    id = "ict_58",
    englishTerm = "Array / List",
    sinhalaTerm = "අරාව / ලැයිස්තුව",
    tamilTerm = "அணி / பட்டியல்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "තනි විචල්‍ය නාමයක් යටතේ දර්ශක (Index) අංක මඟින් ප්‍රවේශ විය හැකි දත්ත සමූහයක් එකට ගබඩා කරන ව්‍යුහය.",
    examTip = "පළමු අයිතමයේ දර්ශකය සාමාන්‍යයෙන් 0 වේ (Zero-indexed)."
  ),
  GlossaryTermItem(
    id = "ict_59",
    englishTerm = "Relational Operators",
    sinhalaTerm = "සම්බන්ධක / සංසන්දන කාරක",
    tamilTerm = "தொடர்புடை செயற்குறிகள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "අගයන් දෙකක් සංසන්දනය කිරීමට යොදා ගන්නා කාරක: ==, !=, >, <, >=, <=.",
    examTip = "සමානතාව පරීක්ෂා කිරීමට '==' භාවිත කරයි. තනි '=' භාවිත වන්නේ අගයක් ආරෝපණයටයි."
  ),
  GlossaryTermItem(
    id = "ict_60",
    englishTerm = "Logical Operators",
    sinhalaTerm = "තාර්කික කාරක",
    tamilTerm = "ஏரணச் செயற்குறிகள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "කොන්දේසි කිහිපයක් එකට සම්බන්ධ කිරීමට යොදා ගන්නා AND, OR, NOT කාරක.",
    examTip = "AND කාරකයේදී සියලු කොන්දේසි සත්‍ය විය යුතුය; OR කාරකයේදී එක් කොන්දේසියක් හෝ සත්‍ය නම් සත්‍ය වේ."
  ),

  // GROUP 7 (61 - 70): දත්ත සමුදාය කළමනාකරණය (DBMS)
  GlossaryTermItem(
    id = "ict_61",
    englishTerm = "Database Management System (DBMS)",
    sinhalaTerm = "දත්ත සමුදාය කළමනාකරණ පද්ධතිය",
    tamilTerm = "தரவுத்தள முகாமைத்துவ முறைமை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "දත්ත සමුදායක් නිර්මාණය කිරීමට, පවත්වාගෙන යාමට සහ කාර්යක්ෂමව හැසිරවීමට පරිශීලකයාට ඉඩ සලසන මෘදුකාංග පද්ධතිය.",
    examTip = "MySQL, Microsoft Access, SQLite සහ Oracle ප්‍රධාන DBMS වේ."
  ),
  GlossaryTermItem(
    id = "ict_62",
    englishTerm = "Table / Entity",
    sinhalaTerm = "වගුව / වස්තුව",
    tamilTerm = "அட்டவணை / உருப்பொருள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "සම්බන්ධිත දත්ත පේළි (වාර්තා) සහ තීරු (ක්ෂේත්‍ර) ලෙස සංවිධානය කර ඇති ප්‍රධාන දත්ත සමුදාය සංරචකය.",
    examTip = "උදා: 'ශිෂ්‍ය' වගුව, 'විභාග' වගුව."
  ),
  GlossaryTermItem(
    id = "ict_63",
    englishTerm = "Field / Attribute",
    sinhalaTerm = "ක්ෂේත්‍රය / ගුණාංගය",
    tamilTerm = "புலம் / பண்புக்கூறு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වගුවක තීරුවක් (Column) නියෝජනය කරන, කිසියම් තනි තොරතුරු වර්ගයක් දරන ඒකකය.",
    examTip = "StudentID, StudentName, DateOfBirth ක්ෂේත්‍ර සඳහා උදාහරණ වේ."
  ),
  GlossaryTermItem(
    id = "ict_64",
    englishTerm = "Record / Tuple",
    sinhalaTerm = "වාර්තාව / ටපලයක්",
    tamilTerm = "பதிவு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වගුවක තනි පේළියක් (Row) නියෝජනය කරන, එක් පුද්ගලයෙකු හෝ වස්තුවක් පිළිබඳ සියලුම තොරතුරු එකතුව.",
    examTip = "එක් ශිෂ්‍යයෙකුගේ සම්පූර්ණ තොරතුරු පේළියක් එක් වාර්තාවකි."
  ),
  GlossaryTermItem(
    id = "ict_65",
    englishTerm = "Primary Key",
    sinhalaTerm = "ප්‍රාථමික යතුර",
    tamilTerm = "முதன்மைத் திறவுகோல்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වගුවක එක් එක් වාර්තාව අනන්‍යව (සුවිශේෂීව) හඳුනාගැනීමට යොදාගන්නා, හිස් විය නොහැකි (Not Null) ක්ෂේත්‍රය.",
    examTip = "ජාතික හැඳුනුම්පත් අංකය (NIC), ශිෂ්‍ය අංකය (Admission Number) ප්‍රාථමික යතුරු වේ."
  ),
  GlossaryTermItem(
    id = "ict_66",
    englishTerm = "Foreign Key",
    sinhalaTerm = "විදේශ යතුර",
    tamilTerm = "வெளிநாட்டுத் திறவுகோல்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වෙනත් වගුවක ප්‍රාථමික යතුරක් වන, වගු දෙකක් අතර සම්බන්ධතාවයක් (Relationship) ගොඩනැගීමට යොදාගන්නා ක්ෂේත්‍රය.",
    examTip = "දත්ත සමුදායක සම්බන්ධතා අඛණ්ඩතාව (Referential Integrity) ආරක්ෂා කරයි."
  ),
  GlossaryTermItem(
    id = "ict_67",
    englishTerm = "Data Redundancy",
    sinhalaTerm = "දත්ත අතිරික්තතාවය",
    tamilTerm = "தரவு மிகைமை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "එකම දත්තය පද්ධතියේ විවිධ ස්ථානවල නැවත නැවත අනවශ්‍ය ලෙස ගබඩා වීම.",
    examTip = "දත්ත සමුදාය සාමාන්‍යකරණය (Normalization) මඟින් දත්ත අතිරික්තතාව අවම කරයි."
  ),
  GlossaryTermItem(
    id = "ict_68",
    englishTerm = "Structured Query Language (SQL)",
    sinhalaTerm = "ව්‍යුහගත විමසුම් භාෂාව",
    tamilTerm = "கட்டமைக்கப்பட்ட வினவல் மொழி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "සම්බන්ධක දත්ත සමුදායකින් දත්ත සෙවීමට, ඇතුළත් කිරීමට, යාවත්කාලීන කිරීමට සහ මැකීමට යොදාගන්නා ප්‍රමිතිගත පරිගණක භාෂාව.",
    examTip = "මූලික විධාන: SELECT, INSERT INTO, UPDATE, DELETE."
  ),
  GlossaryTermItem(
    id = "ict_69",
    englishTerm = "Query",
    sinhalaTerm = "විමසුම",
    tamilTerm = "வினவல்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "දත්ත සමුදායකින් නිශ්චිත නිර්ණායක හෝ කොන්දේසි සපුරාලන තොරතුරු සොයා ලබාගැනීම සඳහා ඉදිරිපත් කරන ප්‍රශ්නය.",
    examTip = "SELECT * FROM Students WHERE Marks > 75."
  ),
  GlossaryTermItem(
    id = "ict_70",
    englishTerm = "Form and Report",
    sinhalaTerm = "පෝරමය සහ වාර්තාව",
    tamilTerm = "படிவம் மற்றும் அறிக்கை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පෝරමයක් (Form) යනු දත්ත පහසුවෙන් ඇතුළත් කිරීමට ඇති අතුරුමුහුණතකි; වාර්තාවක් (Report) යනු මුද්‍රණය සඳහා තොරතුරු හැඩගස්වා ඉදිරිපත් කිරීමයි.",
    examTip = "පෝරමය ආදානයටත් වාර්තාව ප්‍රතිදානයටත් බහුලව යොදා ගැනේ."
  ),

  // GROUP 8 (71 - 80): වෙබ් නිර්මාණය හා බහුමාධ්‍ය
  GlossaryTermItem(
    id = "ict_71",
    englishTerm = "Hypertext Markup Language (HTML)",
    sinhalaTerm = "අධිපෙළ සලකුණු භාෂාව",
    tamilTerm = "மீவுரை குறிப்பீட்டு மொழி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වෙබ් පිටුවල මූලික ව්‍යුහය සහ අන්තර්ගතය ගොඩනැගීම සඳහා භාවිතා කරන සම්මත සලකුණු භාෂාව.",
    examTip = "ටැග් (Tags) යුගල මඟින් අන්තර්ගතය ආවරණය කරයි: <html>, <body>, <p>, <h1>."
  ),
  GlossaryTermItem(
    id = "ict_72",
    englishTerm = "Cascading Style Sheets (CSS)",
    sinhalaTerm = "කැස්කේඩින් මෝස්තර පත්‍ර",
    tamilTerm = "அடுக்கமைவு பாணித் தாள்கள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "HTML මඟින් සැකසූ වෙබ් පිටුවල වර්ණ, අකුරු හැඩතල, පිරිසැලසුම සහ දෘශ්‍ය පෙනුම හැඩගැන්වීමට යොදාගන්නා භාෂාව.",
    examTip = "Inline, Internal, සහ External ලෙස CSS භාවිත කළ හැක."
  ),
  GlossaryTermItem(
    id = "ict_73",
    englishTerm = "Hyperlink",
    sinhalaTerm = "අධිසබැඳිය",
    tamilTerm = "மீத்தொடுப்பு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ක්ලික් කළ විට වෙනත් වෙබ් පිටුවකට හෝ එම පිටුවේම වෙනත් ස්ථානයකට පරිශීලකයා යොමු කරන පෙළ හෝ රූපය.",
    examTip = "HTML හි අධිසබැඳියක් සාදන්නේ <a href='url'>Link</a> ටැගයෙනි."
  ),
  GlossaryTermItem(
    id = "ict_74",
    englishTerm = "Uniform Resource Locator (URL)",
    sinhalaTerm = "ඒකාකාර සම්පත් ස්ථානගතකය",
    tamilTerm = "சீரான வள இருப்பிடம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "අන්තර්ජාලය තුළ කිසියම් වෙබ් පිටුවක් හෝ ගොනුවක් පිහිටි නිශ්චිත ගෝලීය වෙබ් ලිපිනය.",
    examTip = "සංරචක: Protocol (https) + Domain name (moe.gov.lk) + Path (/index.html)."
  ),
  GlossaryTermItem(
    id = "ict_75",
    englishTerm = "Vector Graphics",
    sinhalaTerm = "දෛශික චිත්‍රක",
    tamilTerm = "காவி வரைகலை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පික්සල වෙනුවට ගණිතමය සූත්‍ර සහ රේඛා මඟින් නිර්මාණය කළ, කොතරම් විශාල කළද ගුණාත්මකභාවය නොබිඳෙන චිත්‍රක.",
    examTip = "SVG, EPS ගොනු ආකෘති දෛශික වන අතර ලාංඡන (logos) නිර්මාණයට සුදුසුය."
  ),
  GlossaryTermItem(
    id = "ict_76",
    englishTerm = "Raster / Bitmap Graphics",
    sinhalaTerm = "රාස්ටර් / බිට්මැප් චිත්‍රක",
    tamilTerm = "பிட்மேப் வரைகலை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පික්සල ජාලයකින් නිර්මාණය වන, විශාල කිරීමේදී රූපය බොඳ වී පික්සල් කැඩෙන (Pixelated වන) රූප.",
    examTip = "JPEG, PNG, GIF, BMP බිට්මැප් රූප ආකෘති වේ."
  ),
  GlossaryTermItem(
    id = "ict_77",
    englishTerm = "Web Browser",
    sinhalaTerm = "වෙබ් බ්‍රවුසරය",
    tamilTerm = "வலை உலாவி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "HTML සහ CSS කේත පරිවර්තනය කර පරිශීලකයාට වෙබ් පිටු දෘශ්‍යමානව පෙන්වන යෙදුම් මෘදුකාංගය.",
    examTip = "Google Chrome, Mozilla Firefox, Microsoft Edge, Safari ප්‍රධාන බ්‍රවුසර වේ."
  ),
  GlossaryTermItem(
    id = "ict_78",
    englishTerm = "Web Server",
    sinhalaTerm = "වෙබ් සේවාදායකය",
    tamilTerm = "வலை வழங்கி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වෙබ් අඩවිවල ගොනු ස්ථිරව ගබඩා කරගෙන සිටිමින් සේවාලාභී පරිගණක ඉල්ලන විට ඒවා ලබාදෙන ප්‍රබල සත්කාරක පරිගණකය.",
    examTip = "Apache, Nginx, Microsoft IIS වෙබ් සේවාදායක මෘදුකාංග වේ."
  ),
  GlossaryTermItem(
    id = "ict_79",
    englishTerm = "Multimedia",
    sinhalaTerm = "බහුමාධ්‍ය",
    tamilTerm = "பல்லூடகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පෙළ (Text), ශ්‍රව්‍ය (Audio), දෘශ්‍ය (Video), චිත්‍රක (Graphics) සහ සජීවීකරණ (Animation) යන මාධ්‍ය සංයෝජනය.",
    examTip = "අධ්‍යාපනික මෘදුකාංග වඩාත් ඵලදායී කිරීමට බහුමාධ්‍ය උපකාරී වේ."
  ),
  GlossaryTermItem(
    id = "ict_80",
    englishTerm = "Frames Per Second (FPS)",
    sinhalaTerm = "තත්පරයට රාමු ගණන",
    tamilTerm = "வினாடிக்கு சட்டங்கள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වීඩියෝවක හෝ සජීවිකරණයක සුමට චලනය පෙන්වීම සඳහා තත්පරයක් තුළ තිරය මත ප්‍රදර්ශනය වන නිශ්චල පින්තූර (රාමු) ගණන.",
    examTip = "සම්මත වීඩියෝ සඳහා 24-30 FPS ද, උසස් වීඩියෝ ක්‍රීඩා සඳහා 60+ FPS ද යොදාගනී."
  ),

  // GROUP 9 (81 - 90): සයිබර් ආරක්ෂාව හා ආචාර ධර්ම
  GlossaryTermItem(
    id = "ict_81",
    englishTerm = "Malware",
    sinhalaTerm = "අනිෂ්ට මෘදුකාංග",
    tamilTerm = "தீம்பொருள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණක පද්ධතියකට හානි කිරීමට, දත්ත සොරකම් කිරීමට හෝ අනවසරයෙන් ඇතුළුවීමට විශේෂයෙන් නිර්මාණය කරන ලද ඕනෑම හානිකර මෘදුකාංගයක්.",
    examTip = "වෛරස්, වෝම් (Worms), ට්‍රෝජන් (Trojans) සහ ස්පයිවෙයාර් (Spyware) මීට අයත්ය."
  ),
  GlossaryTermItem(
    id = "ict_82",
    englishTerm = "Computer Virus",
    sinhalaTerm = "පරිගණක වෛරසය",
    tamilTerm = "கணினி நச்சுநிரல்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "වෙනත් ක්‍රියාත්මක වන වැඩසටහන් හෝ ගොනුවලට බද්ධ වී ස්වයංව ප්‍රතිපත්ති සාදමින් පැතිරෙන අනිෂ්ට කේතයක්.",
    examTip = "වෛරසයක් පැතිරීමට මිනිස් මැදිහත්වීමක් (ගොනුව විවෘත කිරීම) අවශ්‍ය වේ."
  ),
  GlossaryTermItem(
    id = "ict_83",
    englishTerm = "Computer Worm",
    sinhalaTerm = "පරිගණක පණුවා",
    tamilTerm = "கணினிப் புழு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "කිසිදු මිනිස් මැදිහත්වීමකින් තොරව ජාල හරහා තනිවම ස්වයංක්‍රීයව ගුණනය වෙමින් පරිගණක ජාල අවහිර කරන හානිකර මෘදුකාංගය.",
    examTip = "වෛරස් මෙන් සත්කාරක ගොනු (Host files) අවශ්‍ය නොවේ."
  ),
  GlossaryTermItem(
    id = "ict_84",
    englishTerm = "Trojan Horse",
    sinhalaTerm = "ට්‍රෝජන් අශ්වයා",
    tamilTerm = "ட்ரோஜன் குதிரை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "ප්‍රයෝජනවත් හෝ හානිකර නොවන මෘදුකාංගයක් ලෙස වෙස්වලාගෙන පරිගණකයට රහසිගතව ඇතුළු වී පසුදොරවල් (Backdoors) සාදන වැඩසටහන.",
    examTip = "නොමිලේ ලබාදෙන ව්‍යාජ ක්‍රීඩා හෝ ක්‍රැක් කළ මෘදුකාංග සමඟ පැමිණේ."
  ),
  GlossaryTermItem(
    id = "ict_85",
    englishTerm = "Phishing",
    sinhalaTerm = "තතුබෑම",
    tamilTerm = "தூண்டிலிடல்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "විශ්වාසවන්ත බැංකුවක් හෝ ආයතනයක් ලෙස පෙනී සිටිමින් වංචනික ඊමේල් හෝ ව්‍යාජ වෙබ් අඩවි මඟින් මුරපද හා ක්‍රෙඩිට් කාඩ් විස්තර සොරකම් කිරීම.",
    examTip = "URL ලිපිනය නිවැරදිද සහ HTTPS පවතීදැයි පරීක්ෂා කිරීමෙන් ආරක්ෂා විය හැක."
  ),
  GlossaryTermItem(
    id = "ict_86",
    englishTerm = "Ransomware",
    sinhalaTerm = "කප්පම් මෘදුකාංග",
    tamilTerm = "மீட்புப்பொருள்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිශීලකයාගේ වැදගත් ලිපිගොනු ගුප්තකේතනය (Encrypt) කර අවහිර කර, ඒවා මුදාහැරීමට මුදල් (කප්පම්) ඉල්ලා සිටින අනිෂ්ට මෘදුකාංග.",
    examTip = "නිරන්තරයෙන් නොබැඳි උපස්ථ (Offline Backups) තබා ගැනීමෙන් මෙයින් ආරක්ෂා විය හැක."
  ),
  GlossaryTermItem(
    id = "ict_87",
    englishTerm = "Firewall",
    sinhalaTerm = "ගිනිපවුර",
    tamilTerm = "தீச்சுவர்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පෙර සැකසූ ආරක්ෂක නීති මාලාවකට අනුව පරිගණකයකට එන සහ පිටවන සියලුම ජාල තදබදය නිරීක්ෂණය කර අවහිර කරන පද්ධතිය.",
    examTip = "දෘඩාංගමය (Hardware) හෝ මෘදුකාංගමය (Software) ආකාරයෙන් පැවතිය හැක."
  ),
  GlossaryTermItem(
    id = "ict_88",
    englishTerm = "Encryption",
    sinhalaTerm = "ගුප්තකේතනය",
    tamilTerm = "குறியாக்கம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "අනවසර පුද්ගලයන්ට කියවිය නොහැකි වන සේ සාමාන්‍ය පෙළ (Plain text) රහස්‍ය කේතාක්ෂර (Cipher text) බවට පත්කිරීම.",
    examTip = "නැවත මුල් තත්ත්වයට පත්කිරීම 'විසංකේතනය' (Decryption) වේ."
  ),
  GlossaryTermItem(
    id = "ict_89",
    englishTerm = "Intellectual Property (IP)",
    sinhalaTerm = "බුද්ධිමය දේපළ",
    tamilTerm = "அறிவுசார் சொத்து",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "මිනිස් මනසෙහි නිර්මාණශීලී චින්තනයෙන් බිහිවන නව නිපැයුම්, මෘදුකාංග, කලා කෘති හා වෙළඳ ලකුණු සඳහා හිමිවන නීත්‍යානුකූල අයිතිය.",
    examTip = "ප්‍රකාශන හිමිකම (Copyright) මඟින් මෘදුකාංග අනවසරයෙන් පිටපත් කිරීම වළක්වයි."
  ),
  GlossaryTermItem(
    id = "ict_90",
    englishTerm = "Digital Divide",
    sinhalaTerm = "ඩිජිටල් බෙදීම",
    tamilTerm = "டிஜிட்டல் இடைவெளி",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "තොරතුරු හා සන්නිවේදන තාක්ෂණයට ප්‍රවේශය ඇති සහ ප්‍රවේශය නොමැති ජන කොටස් අතර පවතින සමාජ-ආර්ථික පරතරය.",
    examTip = "නාගරික සහ ග්‍රාමීය ප්‍රදේශ අතර අන්තර්ජාල හා පරිගණක පහසුකම්වල විෂමතාවය මීට නිදසුනකි."
  ),

  // GROUP 10 (91 - 100): තොරතුරු පද්ධති හා නැගී එන තාක්ෂණය
  GlossaryTermItem(
    id = "ict_91",
    englishTerm = "Cloud Computing",
    sinhalaTerm = "වලාකුළු පරිගණකකරණය",
    tamilTerm = "மேகக் கணிமை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "දේශීය දෘඪ තැටියක් වෙනුවට අන්තර්ජාලය හරහා සේවාදායක මත දත්ත ගබඩා කිරීම, කළමනාකරණය කිරීම සහ සකස් කිරීම.",
    examTip = "Google Drive, Microsoft OneDrive, AWS වලාකුළු සේවාවලට නිදසුන් වේ."
  ),
  GlossaryTermItem(
    id = "ict_92",
    englishTerm = "Artificial Intelligence (AI)",
    sinhalaTerm = "කෘත්‍රිම බුද්ධිය",
    tamilTerm = "செயற்கை நுண்ணறிவு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "මිනිස් බුද්ධිය මෙන් ඉගෙනීම, තීරණ ගැනීම, ගැටලු විසඳීම සහ භාෂාව තේරුම් ගැනීම සඳහා පරිගණක පද්ධති සවිබල ගැන්වීම.",
    examTip = "ස්වයංක්‍රීය වාහන, හඬ සහායකයන් (Siri/Google Assistant) AI තාක්ෂණය භාවිත කරයි."
  ),
  GlossaryTermItem(
    id = "ict_93",
    englishTerm = "Internet of Things (IoT)",
    sinhalaTerm = "භාණ්ඩ අන්තර්ජාලය",
    tamilTerm = "பொருட்களின் இணையம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "සංවේදක සහ අන්තර්ජාල සම්බන්ධතා සහිත දෛනික භෞතික උපාංග මිනිස් මැදිහත්වීමකින් තොරව එකිනෙක දත්ත හුවමාරු කරගැනීමේ ජාලය.",
    examTip = "ස්මාර්ට් නිවාස පද්ධති (Smart Home), ස්මාර්ට් ඔරලෝසු IoT උදාහරණ වේ."
  ),
  GlossaryTermItem(
    id = "ict_94",
    englishTerm = "System Development Life Cycle (SDLC)",
    sinhalaTerm = "පද්ධති සංවර්ධන ජීවන චක්‍රය",
    tamilTerm = "அமைப்பு விருத்தி வாழ்க்கை வட்டம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "උසස් තත්ත්වයේ තොරතුරු පද්ධතියක් සැලසුම් කර, ගොඩනගා, පරීක්ෂා කර නඩත්තු කිරීම සඳහා අනුගමනය කරන ප්‍රමිතිගත පියවර මාලාව.",
    examTip = "පියවර: හඳුනාගැනීම → විශ්ලේෂණය → සැලසුම් කිරීම → කේතනය → පරීක්ෂා කිරීම → ස්ථාපනය → නඩත්තුව."
  ),
  GlossaryTermItem(
    id = "ict_95",
    englishTerm = "E-Commerce",
    sinhalaTerm = "විද්‍යුත් වාණිජ්‍යය",
    tamilTerm = "மின்-வணிகம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "අන්තර්ජාලය සහ ඩිජිටල් වේදිකා හරහා භාණ්ඩ හා සේවා මිලදී ගැනීම සහ විකිණීම සිදුකිරීමේ ක්‍රියාවලිය.",
    examTip = "B2C (ව්‍යාපාරයෙන් පාරිභෝගිකයාට), C2C (පාරිභෝගිකයන් අතර) ප්‍රධාන ආකෘති වේ."
  ),
  GlossaryTermItem(
    id = "ict_96",
    englishTerm = "E-Government",
    sinhalaTerm = "විද්‍යුත් රාජ්‍යකරණය",
    tamilTerm = "மின்-அரசாங்கம்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "රාජ්‍ය ආයතන මඟින් පුරවැසියන්ට සහ ව්‍යාපාරවලට කාර්යක්ෂමව සේවා සැපයීම සඳහා තොරතුරු තාක්ෂණය යොදා ගැනීම.",
    examTip = "මාර්ගගත විභාග ප්‍රතිඵල බැලීම, ජාතික හැඳුනුම්පත් මාර්ගගත සේවා මීට නිදසුන්ය."
  ),
  GlossaryTermItem(
    id = "ict_97",
    englishTerm = "Big Data",
    sinhalaTerm = "මහා දත්ත",
    tamilTerm = "பெருந்தரவு",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "සාම්ප්‍රදායික දත්ත සමුදාය මෘදුකාංගවලින් හැසිරවිය නොහැකි තරම් දැවැන්ත පරිමාවක්, අධික වේගයක් සහ විවිධත්වයක් සහිත දත්ත.",
    examTip = "ප්‍රධාන ලක්ෂණ 3 (3Vs): Volume (පරිමාව), Velocity (වේගය), Variety (විවිධත්වය)."
  ),
  GlossaryTermItem(
    id = "ict_98",
    englishTerm = "Virtual Reality (VR)",
    sinhalaTerm = "අතථ්‍ය යථාර්ථය",
    tamilTerm = "மெய்நிகர் உண்மை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "පරිගණක තාක්ෂණය මඟින් මවාපාන ලද, විශේෂිත හෙඩ්සෙට් (Headset) ආධාරයෙන් පරිශීලකයාට සම්පූර්ණයෙන්ම සැබෑ ලෝකයක් ලෙස අත්විඳිය හැකි ත්‍රිමාන අනුකරණ පරිසරය.",
    examTip = "නියමු පුහුණුව (Flight simulation) සහ වෛද්‍ය සැත්කම් පුහුණුව සඳහා යොදා ගනී."
  ),
  GlossaryTermItem(
    id = "ict_99",
    englishTerm = "Augmented Reality (AR)",
    sinhalaTerm = "වැඩිදියුණු කළ යථාර්ථය",
    tamilTerm = "மிகை உண்மை",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "කැමරාවක් හරහා පෙනෙන සැබෑ භෞතික ලෝකය මතට පරිගණකයෙන් උත්පාදනය කළ ඩිජිටල් රූප හෝ තොරතුරු උඩින් අතුරා පෙන්වීම.",
    examTip = "Pokemon GO ක්‍රීඩාව සහ Google Maps Live View AR සඳහා උදාහරණ වේ."
  ),
  GlossaryTermItem(
    id = "ict_100",
    englishTerm = "Blockchain",
    sinhalaTerm = "බ්ලොක්චේන් (දැලිස)",
    tamilTerm = "பிளாக்செயின்",
    subject = "තොරතුරු තාක්ෂණය (ICT)",
    definitionSinhala = "මධ්‍යම පාලන ආයතනයකින් තොරව, විමධ්‍යගත ජාලයක් හරහා දත්ත ආරක්ෂිතව සහ වෙනස් කළ නොහැකි ලෙස බ්ලොක් ආකාරයෙන් සබැඳිව ගබඩා කිරීමේ තාක්ෂණය.",
    examTip = "ක්‍රිප්ටෝ මුදල් (Cryptocurrency) සහ ස්මාර්ට් ගිවිසුම් (Smart Contracts) සඳහා පදනම වේ."
  )
)
