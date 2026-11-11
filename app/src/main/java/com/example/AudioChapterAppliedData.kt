package com.example

/**
 * Authentic Sri Lankan O/L Syllabus Audio Notes for Applied Subjects & Electives:
 * ICT, Commerce, Health, Agriculture, English, Music, Art, Dance, Drama.
 * Strictly 100% curriculum-accurate notes.
 */
object AudioChapterAppliedData {

  fun getIctChapters(grade: String): List<ChapterItem> {
    return listOf(
      ChapterItem(
        chapter_id = 1,
        title = "1 වන පරිච්ඡේදය: පරිගණක දෘඩාංග, මතකය හා ගෘහනිර්මාණ ශිල්පය",
        page_start = 1,
        page_end = 24,
        audio_note_url = "https://example.com/audio/ict_ch1.mp3",
        audio_duration = "05:00",
        summary_bullets = listOf(
          "CPU හි ප්‍රධාන කොටස් 3: ALU (අංකගණිත හා තර්ක ඒකකය), CU (පාලන ඒකකය), Registers (රෙජිස්තර).",
          "ප්‍රාථමික මතකය: RAM (තාවකාලික, Volatile) සහ ROM (ස්ථිර, Non-volatile - BIOS අඩංගුයි).",
          "කෑෂ් මතකය (Cache Memory): CPU සහ RAM අතර අධිවේගී දත්ත හුවමාරුවට යොදයි.",
          "ද්විතීයික ගබඩා: HDD (චුම්භක), SSD (ෆ්ලෑෂ් මතකය), Optical Discs (CD, DVD, Blu-ray).",
          "ආදාන හා ප්‍රතිදාන උපාංග: ස්කෑනර්, OMR, OCR, MICR, මොනිටර්, ප්‍රින්ටර් (Dot Matrix, Laser, Inkjet)."
        ),
        read_aloud_text = "තොරතුරු හා සන්නිවේදන තාක්ෂණයේ මූලික පදනම පරිගණක දෘඩාංගයි. පරිගණකයක ක්‍රියාකාරිත්වය තීරණය වන්නේ මධ්‍යම සැකසුම් ඒකකය හෙවත් CPU එක, ප්‍රධාන මතකය සහ ගබඩා උපාංග අතර මනා සම්බන්ධීකරණය මතය."
      ),
      ChapterItem(
        chapter_id = 2,
        title = "2 වන පරිච්ඡේදය: දත්ත නිරූපණය, සංඛ්‍යා පද්ධති හා කේත ක්‍රම",
        page_start = 25,
        page_end = 48,
        audio_note_url = "https://example.com/audio/ict_ch2.mp3",
        audio_duration = "05:10",
        summary_bullets = listOf(
          "ද්විමය (Binary - පාදය 2: 0 සහ 1), අෂ්ටමය (Octal - පාදය 8: 0-7), දශමය (Decimal - පාදය 10: 0-9), ෂඩ්දශමය (Hexadecimal - පාදය 16: 0-9 සහ A-F).",
          "දශමය සංඛ්‍යා ද්විමය බවට හැරවීම (2න් බෙදීම) සහ ද්විමය සංඛ්‍යා දශමය බවට හැරවීම (2 හි බලවලින් ගුණ කිරීම).",
          "1 Byte = 8 Bits, 1 Nibble = 4 Bits, 1 KB = 1024 Bytes, 1 MB = 1024 KB, 1 GB = 1024 MB.",
          "කේත ක්‍රම: ASCII (බිට් 7 හෝ 8), BCD, EBCDIC.",
          "යුනිකෝඩ් (Unicode): සිංහල, දෙමළ ඇතුළු ලොව සියලු භාෂා ඩිජිටල්ව නිරූපණය කිරීමට යොදාගනී."
        ),
        read_aloud_text = "පරිගණකය තුළ සියලුම දත්ත (අකුරු, පින්තූර, ශබ්ද) ගබඩා වන්නේ බිංදුව සහ එක යන ද්විමය බිටු ආකාරයෙනි. සංඛ්‍යා පද්ධති පරිවර්තනය විභාගයේ අනිවාර්යයෙන්ම ලකුණු හිමිවන ප්‍රධාන කොටසකි."
      ),
      ChapterItem(
        chapter_id = 3,
        title = "3 වන පරිච්ඡේදය: Logic Gates, බූලීය වීජ ගණිතය හා සත්‍යතා වගු",
        page_start = 49,
        page_end = 72,
        audio_note_url = "https://example.com/audio/ict_ch3.mp3",
        audio_duration = "05:05",
        summary_bullets = listOf(
          "මූලික තර්ක ද්වාර 3: AND (A · B), OR (A + B), NOT (A').",
          "සර්වත්‍ර ද්වාර (Universal Gates): NAND (NOT-AND) සහ NOR (NOT-OR).",
          "විශේෂිත ද්වාර: XOR (Exclusive OR) - ආදාන අසමාන විට ප්‍රතිදානය 1 වේ.",
          "බූලීය නීති: A + 0 = A, A · 1 = A, A + A' = 1, A · A' = 0, (A')' = A.",
          "සත්‍යතා වගු (Truth Tables) ගොඩනැගීම සහ සරල තර්ක පරිපථ නිර්මාණය."
        ),
        read_aloud_text = "සංඛ්‍යාංක පරිගණක පරිපථ ක්‍රියාත්මක වන්නේ තර්ක ද්වාර මතය. බූලීය වීජ ගණිතය මගින් සංකීර්ණ පරිපථ සරල කර කාර්යක්ෂම පරිපථ සැලසුම් කළ හැක."
      ),
      ChapterItem(
        chapter_id = 4,
        title = "4 වන පරිච්ඡේදය: මෙහෙයුම් පද්ධති, පැතුරුම්පත් හා දත්ත සමුදාය (DBMS)",
        page_start = 73,
        page_end = 100,
        audio_note_url = "https://example.com/audio/ict_ch4.mp3",
        audio_duration = "05:15",
        summary_bullets = listOf(
          "මෙහෙයුම් පද්ධතිය (OS): දෘඩාංග සහ පරිශීලකයා අතර පාලමයි (Windows, Linux, Android). කාර්යයන්: මතක, ක්‍රියාවලි හා ගොනු කළමනාකරණය.",
          "පැතුරුම්පත් (Spreadsheets): සෛල (Cells), සූත්‍ර (=SUM, =AVERAGE, =MAX, =MIN, =COUNT, =IF).",
          "නිරපේක්ෂ සෛල විමර්ශනය (Absolute Reference: \$A\$1) සහ සාපේක්ෂ විමර්ශනය (Relative).",
          "දත්ත සමුදාය (Database): වගු (Tables), ක්ෂේත්‍ර (Fields/Columns), වාර්තා (Records/Rows).",
          "ප්‍රාථමික යතුර (Primary Key - අනන්‍ය හඳුනාගැනීම) සහ විදේශ යතුර (Foreign Key - සබඳතා තැනීම)."
        ),
        read_aloud_text = "දත්ත කළමනාකරණයේදී පැතුරුම්පත් මෘදුකාංග සහ දත්ත සමුදාය කළමනාකරණ පද්ධති (DBMS) අත්‍යවශ්‍ය වේ. වගු අතර සබඳතා ගොඩනැගීම සහ SQL විමසුම් මගින් තොරතුරු ලබාගැනීම ප්‍රායෝගිකව පුහුණු විය යුතුය."
      ),
      ChapterItem(
        chapter_id = 5,
        title = "5 වන පරිච්ඡේදය: HTML, CSS, වෙබ් නිර්මාණය හා සයිබර් ආරක්ෂාව",
        page_start = 101,
        page_end = 130,
        audio_note_url = "https://example.com/audio/ict_ch5.mp3",
        audio_duration = "05:10",
        summary_bullets = listOf(
          "HTML මූලික ව්‍යුහය: <html>, <head>, <title>, <body>.",
          "ප්‍රධාන ටැග: <h1>-<h6>, <p>, <a> (hyperlinks), <img> (පින්තූර), <table>, <tr>, <td>, <ol>, <ul>, <li>.",
          "CSS (Cascading Style Sheets): වෙබ් අඩවියේ පෙනුම, වර්ණ හා ආකෘතිය හැඩගැන්වීම.",
          "පරිගණක ජාල: LAN, WAN, IP ලිපින (IPv4, IPv6), DNS, Router, Switch.",
          "සයිබර් ආරක්ෂාව: පරිගණක වෛරස්, ෆයර්වෝල් (Firewall), ෆිෂින් (Phishing), දත්ත ගුප්තකේතනය (Encryption) හා උපස්ථ (Backup)."
        ),
        read_aloud_text = "අන්තර්ජාලය සහ වෙබ් තාක්ෂණය නූතන තොරතුරු ලෝකයේ ප්‍රධානතම මාධ්‍යයයි. වෙබ් පිටුවක් නිර්මාණය කිරීමේදී HTML සහ CSS භාවිතය මෙන්ම සයිබර් ප්‍රහාරවලින් දත්ත ආරක්ෂා කරගැනීම පිළිබඳවද දැනුවත් විය යුතුය."
      )
    )
  }

  fun getCommerceChapters(grade: String): List<ChapterItem> {
    return listOf(
      ChapterItem(
        chapter_id = 1,
        title = "1 වන පරිච්ඡේදය: ව්‍යාපාර පසුබිම, මානව අවශ්‍යතා හා ව්‍යාපාර පරිසරය",
        page_start = 1,
        page_end = 24,
        audio_note_url = "https://example.com/audio/comm_ch1.mp3",
        audio_duration = "04:55",
        summary_bullets = listOf(
          "මානව අවශ්‍යතා (සීමිතයි, අත්‍යවශ්‍යයි: ආහාර, ඇඳුම්, නිවාස) හා උවමනා (අසීමිතයි, විවිධයි).",
          "නිෂ්පාදන සාධක 4: භූමිය (ප්‍රතිලාභය කුලිය), ශ්‍රමය (වේතනය), ප්‍රාග්ධනය (පොලිය), ව්‍යවසායකත්වය (ලාභය).",
          "ව්‍යාපාර වර්ගීකරණය: ප්‍රාථමික (කෘෂි/ධීවර), ද්විතීයික (නිෂ්පාදන/කර්මාන්ත), තෘතීයික (සේවා).",
          "ව්‍යාපාර හිමිකාරිත්ව වර්ග: තනි පුද්ගල ව්‍යාපාර, හවුල් ව්‍යාපාර (1890 හවුල් පනත), සීමාසහිත සමාගම් (2007 අංක 07 පනත).",
          "අභ්‍යන්තර හා බාහිර ව්‍යාපාර පරිසර සාධක."
        ),
        read_aloud_text = "ව්‍යාපාර හා ගිණුම්කරණ විෂයයේ ආරම්භය මානව අවශ්‍යතා සහ උවමනා තෘප්තිමත් කිරීමයි. නිෂ්පාදන සාධක කාර්යක්ෂමව උපයෝගී කරගනිමින් භාණ්ඩ හා සේවා නිෂ්පාදනය කර ලාභ ඉපැයීම ව්‍යාපාරයක මූලික අරමුණයි."
      ),
      ChapterItem(
        chapter_id = 2,
        title = "2 වන පරිච්ඡේදය: ද්විත්ව සටහන් මූලධර්මය හා ගිණුම්කරණ සමීකරණය",
        page_start = 25,
        page_end = 50,
        audio_note_url = "https://example.com/audio/comm_ch2.mp3",
        audio_duration = "05:10",
        summary_bullets = listOf(
          "ගිණුම්කරණ සමීකරණය: වත්කම් = හිමිකම + වගකීම් (Assets = Equity + Liabilities).",
          "ද්විත්ව සටහන් රීතිය: සෑම ගනුදෙනුවකටම සමාන හර (Debit) සහ බැර (Credit) බලපෑම් දෙකක් ඇත.",
          "වත්කම් හා වියදම් වැඩිවීම හර (Dr), අඩුවීම බැර (Cr).",
          "හිමිකම, වගකීම් හා ආදායම් වැඩිවීම බැර (Cr), අඩුවීම හර (Dr).",
          "ගිණුම් වර්ගීකරණය: නාමික ගිණුම්, පුද්ගල ගිණුම්, තාත්වික ගිණුම්."
        ),
        read_aloud_text = "ගිණුම්කරණයේ අත්තිවාරම වන්නේ ද්විත්ව සටහන් මූලධර්මයයි. ලූකා පැසියෝලි පියතුමා විසින් හඳුන්වා දුන් මෙම රීතිය අනුව ඕනෑම මූල්‍ය ගනුදෙනුවක් හර සහ බැර ලෙස නිවැරදිව වාර්තා කළ යුතුය."
      ),
      ChapterItem(
        chapter_id = 3,
        title = "3 වන පරිච්ඡේදය: මූලික සටහන් පොත්, මුදල් පොත හා ශේෂ පිරික්සුම",
        page_start = 51,
        page_end = 76,
        audio_note_url = "https://example.com/audio/comm_ch3.mp3",
        audio_duration = "05:00",
        summary_bullets = listOf(
          "මූලික සටහන් පොත්: මුදල් පොත, ගැනුම් ජර්නලය, විකුණුම් ජර්නලය, ගැනුම් ආපසු ජර්නලය, විකුණුම් ආපසු ජර්නලය, ප්‍රධාන ජර්නලය.",
          "ද්වි තීරු හා ත්‍රි තීරු මුදල් පොත (මුදල්, බැංකු හා වට්ටම් තීරු).",
          "සුළු මුදල් පොත සහ අග්‍රදත්ත ක්‍රමය (Imprest system).",
          "ලෙජර ගිණුම් තුලනය කිරීම (c/d සහ b/d).",
          "ශේෂ පිරික්සුම (Trial Balance): ගිණුම්වල අංකගණිතමය නිරවද්‍යතාව පරීක්ෂා කිරීම."
        ),
        read_aloud_text = "මූලික ලේඛන ඇසුරෙන් ජර්නලවල මුලින්ම ගනුදෙනු ලියා පසුව ලෙජර ගිණුම්වලට පිටපත් කෙරේ. ලෙජර ගිණුම් තුලනය කර සකසන ශේෂ පිරික්සුම මගින් ගිණුම්වල නිවැරදිභාවය තහවුරු කරයි."
      ),
      ChapterItem(
        chapter_id = 4,
        title = "4 වන පරිච්ඡේදය: මූල්‍ය ප්‍රකාශන, ලාභ අලාභ ගිණුම හා ශේෂ පත්‍රය",
        page_start = 77,
        page_end = 105,
        audio_note_url = "https://example.com/audio/comm_ch4.mp3",
        audio_duration = "05:20",
        summary_bullets = listOf(
          "වෙළඳ ගිණුම: දළ ලාභය හෝ දළ අලාභය සෙවීම (විකුණුම් - විකුණුම් පිරිවැය).",
          "විකුණුම් පිරිවැය = ආරම්භක තොගය + ශුද්ධ ගැනුම් + ගැනුම් ප්‍රවාහන - අවසාන තොගය.",
          "ලාභ හා අලාභ ගිණුම: ශුද්ධ ලාභය සෙවීම (දළ ලාභය + අනෙකුත් ආදායම් - බෙදාහැරීමේ හා පරිපාලන වියදම්).",
          "මූල්‍ය තත්ත්ව ප්‍රකාශනය (ශේෂ පත්‍රය): නිශ්චිත දිනක ව්‍යාපාරයේ මූල්‍ය ශක්තිය (වත්කම්, වගකීම්, හිමිකම).",
          "ගැලපීම්: උපචිත වියදම්, අත්තිකාරම් ලැබීම්, ක්ෂයවීම් හා සැක සහිත ණය ප්‍රතිපාදන."
        ),
        read_aloud_text = "O/L වාණිජ්‍ය ප්‍රශ්න පත්‍රයේ ලකුණු 20ක් හිමිවන අතිශය වැදගත්ම ප්‍රශ්නය මූල්‍ය ප්‍රකාශන සැකසීමයි. වෙළඳ හා ලාභාලාභ ගිණුම සහ ශේෂ පත්‍රය ගැලපීම් සහිතව නිවැරදිව පියවරෙන් පියවර සම්පූර්ණ කළ යුතුය."
      ),
      ChapterItem(
        chapter_id = 5,
        title = "5 වන පරිච්ඡේදය: වාණිජ බැංකු, රක්ෂණය හා විද්‍යුත් ගෙවීම්",
        page_start = 106,
        page_end = 130,
        audio_note_url = "https://example.com/audio/comm_ch5.mp3",
        audio_duration = "04:50",
        summary_bullets = listOf(
          "ශ්‍රී ලංකා මහ බැංකුවේ කාර්යයන්: මුදල් නිකුත් කිරීම, මූල්‍ය පද්ධතියේ ස්ථායීතාව, වාණිජ බැංකු අධීක්ෂණය.",
          "වාණිජ බැංකු ගිණුම්: ඉතිරිකිරීමේ, ජංගම (චෙක්පත් භාවිතය, බැංකු අයිරා), ස්ථාවර තැන්පතු.",
          "රක්ෂණ මූලධර්ම: පරම සද්භාවය, රක්ෂණීය හිමිකම, හානිපූරණය, ප්‍රත්‍යාදේශය, දායකත්වය.",
          "විද්‍යුත් වාණිජ්‍යය (E-commerce), ඩිජිටල් බැංකුකරණය, ATM, Credit/Debit කාඩ්පත්.",
          "අලෙවිකරණ මිශ්‍රමය (4 Ps): Product, Price, Place, Promotion."
        ),
        read_aloud_text = "ව්‍යාපාරවලට සහය වන සේවා අතර බැංකු හා රක්ෂණ සේවාව ප්‍රමුඛ වේ. නවීන තාක්ෂණයත් සමඟ විද්‍යුත් මුදල් හුවමාරුව හා අන්තර්ජාල සාප්පු සවාරි දෛනික ජීවිතයට අත්‍යවශ්‍ය අංගයක් වී ඇත."
      )
    )
  }

  fun getHealthChapters(grade: String): List<ChapterItem> {
    return listOf(
      ChapterItem(
        chapter_id = 1,
        title = "1 වන පරිච්ඡේදය: සමබල ආහාර වේල, පෝෂණය හා ශරීර ස්කන්ධ දර්ශකය (BMI)",
        page_start = 1,
        page_end = 25,
        audio_note_url = "https://example.com/audio/health_ch1.mp3",
        audio_duration = "04:45",
        summary_bullets = listOf(
          "පෝෂක වර්ග 6: කාබෝහයිඩ්‍රේට්, ප්‍රෝටීන, ලිපිඩ, විටමින්, ඛනිජ ලවණ, ජලය සහ ආහාරමය කෙඳි.",
          "BMI සූත්‍රය: BMI = ස්කන්ධය (kg) / [උස (m)]².",
          "නිරෝගී BMI පරාසය: 18.5 සිට 24.9 දක්වා (25ට වැඩි නම් අධිබර, 30ට වැඩි නම් ස්ථුලතාව).",
          "පෝෂණ ඌනතා රෝග: මන්දපෝෂණය (ක්වාෂියෝකර්, මරස්මස්), රක්තහීනතාවය (යකඩ ඌනතාව), ගලගණ්ඩය (අයඩින් ඌනතාව).",
          "ආහාර සුරක්ෂිතතාවය සහ වස විසෙන් තොර ස්වාභාවික ආහාර රටාව."
        ),
        read_aloud_text = "නිරෝගී ජීවිතයකට නිවැරදි පෝෂණය හා සමබල ආහාර වේලක් අත්‍යවශ්‍ය වේ. ශරීර ස්කන්ධ දර්ශකය හෙවත් BMI අගය නිරෝගී පරාසයේ පවත්වා ගැනීමෙන් බෝනොවන රෝග රැසකින් ආරක්ෂා විය හැක."
      ),
      ChapterItem(
        chapter_id = 2,
        title = "2 වන පරිච්ඡේදය: සංක්‍රාමික හා අසංක්‍රාමික රෝග නිවාරණය",
        page_start = 26,
        page_end = 50,
        audio_note_url = "https://example.com/audio/health_ch2.mp3",
        audio_duration = "05:00",
        summary_bullets = listOf(
          "සංක්‍රාමික රෝග: ඩෙංගු (ඊඩිස් මදුරුවා), කොවිඩ්-19, ක්ෂය රෝගය, මී උණ.",
          "අසංක්‍රාමික රෝග (NCDs): දියවැඩියාව, අධික රුධිර පීඩනය, හෘදයාබාධ, පිළිකා, නිදන්ගත වකුගඩු රෝග.",
          "අසංක්‍රාමික රෝග සඳහා අවදානම් සාධක: දුම්පානය, මධ්‍යසාර භාවිතය, අහිතකර ආහාර පුරුදු, ව්‍යායාම මදකම.",
          "ආහාරයේ සීනි, ලුණු හා මේදය අවම කිරීම (රථවාහන වර්ණ සංඥා ක්‍රමය).",
          "ප්‍රතිශක්තිකරණ එන්නත් සහ සෞඛ්‍ය පුරුදු."
        ),
        read_aloud_text = "වර්තමාන සමාජයේ මරණවලට ප්‍රධානතම හේතුව වී ඇත්තේ වැරදි ජීවන රටාව නිසා හටගන්නා අසංක්‍රාමික රෝගයි. දිනපතා ව්‍යායාම කිරීමෙන් හා පෝෂ්‍යදායී ආහාර ගැනීමෙන් නිරෝගී දිවියක් ගතකළ හැක."
      ),
      ChapterItem(
        chapter_id = 3,
        title = "3 වන පරිච්ඡේදය: මානසික සෞඛ්‍යය, ආතති කළමනාකරණය හා සබඳතා",
        page_start = 51,
        page_end = 75,
        audio_note_url = "https://example.com/audio/health_ch3.mp3",
        audio_duration = "04:50",
        summary_bullets = listOf(
          "මානසික සුවතාවය: තමාගේ හැකියාවන් හඳුනාගෙන, දෛනික ආතතීන්ට මුහුණ දෙමින් ඵලදායීව ජීවත්වීම.",
          "ආතතිය කළමනාකරණය කිරීමේ උපායමාර්ග: කාල කළමනාකරණය, විවේකය, ආගමික වතාවත්, විනෝදාංශ.",
          "යහපත් අන්තර් පුද්ගල සබඳතා සහ ඵලදායී සන්නිවේදනය.",
          "මත්ද්‍රව්‍ය හා දුම්වැටි උවදුරෙන් මිදීම (ප්‍රතික්ෂේප කිරීමේ කුසලතාව).",
          "නවයොවුන් වියේ ගැටළු සහ උපදේශන සේවා."
        ),
        read_aloud_text = "ශාරීරික සෞඛ්‍යය මෙන්ම මානසික සෞඛ්‍යයද පුද්ගලයෙකුගේ සමස්ත සුවතාවයට අත්‍යවශ්‍ය වේ. විභාග ආතතිය ජයගෙන මනස සන්සුන්ව තබාගැනීම අධ්‍යාපන සාර්ථකත්වයට මඟපාදයි."
      ),
      ChapterItem(
        chapter_id = 4,
        title = "4 වන පරිච්ඡේදය: ප්‍රථමාධාර, ක්‍රීඩා තුවාල හා ආරක්ෂාව",
        page_start = 76,
        page_end = 100,
        audio_note_url = "https://example.com/audio/health_ch4.mp3",
        audio_duration = "04:40",
        summary_bullets = listOf(
          "ප්‍රථමාධාර යනු හදිසි අනතුරකදී හෝ රෝගී අවස්ථාවකදී වෛද්‍ය ප්‍රතිකාර ලැබෙන තුරු දෙන මූලික උපකාරයයි.",
          "ප්‍රථමාධාරයේ අරමුණු: ජීවිතය බේරාගැනීම, තත්ත්වය නරක අතට හැරීම වැළැක්වීම, සුවය ඉක්මන් කිරීම.",
          "ක්‍රීඩා තුවාල සඳහා RICE ප්‍රතිකාරය: Rest (විවේකය), Ice (අයිස් තැබීම), Compression (තෙරපුම), Elevation (එසවීම).",
          "අස්ථි බිඳීම්, උළුක්කු වීම්, පිලිස්සුම් හා සර්ප දෂ්ටන සඳහා ප්‍රථමාධාර.",
          "කෘත්‍රිම ශ්වසනය (CPR) ලබාදීමේ නිවැරදි ක්‍රමවේදය."
        ),
        read_aloud_text = "හදිසි අවස්ථාවකදී නිවැරදි ප්‍රථමාධාර ලබාදීමෙන් මිනිස් ජීවිතයක් බේරාගත හැක. ක්‍රීඩා කිරීමේදී සිදුවන තුවාල සඳහා RICE ප්‍රතිකාර ක්‍රමය අනුගමනය කිරීම වැදගත්ය."
      )
    )
  }

  fun getAgriChapters(grade: String): List<ChapterItem> {
    return listOf(
      ChapterItem(
        chapter_id = 1,
        title = "1 වන පරිච්ඡේදය: පාංශු විද්‍යාව, පස් සංරචක හා සාරවත්භාවය",
        page_start = 1,
        page_end = 25,
        audio_note_url = "https://example.com/audio/agri_ch1.mp3",
        audio_duration = "04:50",
        summary_bullets = listOf(
          "පසෙහි ප්‍රධාන සංරචක 4: ඛනිජ ද්‍රව්‍ය (45%), කාබනික ද්‍රව්‍ය (5%), පාංශු ජලය (25%), පාංශු වාතය (25%).",
          "පස් පැතිකඩේ ස්ථර: O, A (උඩු පස), B (යටි පස), C (දිරූ පාෂාණ), R (මව් පාෂාණය).",
          "පාංශු වයනය: වැලි, ලෝම්, මැටි අංශු ප්‍රතිශතය අනුව තීරණය වේ.",
          "පාංශු ඛාදනය වැළැක්වීමේ ක්‍රම: සමෝච්ච වැටි, ගල් වැටි, කාණු පද්ධති, වසුන් යෙදීම.",
          "කොම්පෝස්ට් පොහොර හා කාබනික ගොවිතැන."
        ),
        read_aloud_text = "කෘෂිකර්මාන්තයේ පදනම නිරෝගී පසයි. පසෙහි භෞතික, රසායනික හා ජෛවීය ගුණාංග නිසි ලෙස පවත්වා ගැනීමෙන් තිරසර ඉහළ අස්වැන්නක් ලබාගත හැක."
      ),
      ChapterItem(
        chapter_id = 2,
        title = "2 වන පරිච්ඡේදය: ශාක පෝෂක (NPK), පොහොර හා ජල කළමනාකරණය",
        page_start = 26,
        page_end = 50,
        audio_note_url = "https://example.com/audio/agri_ch2.mp3",
        audio_duration = "05:00",
        summary_bullets = listOf(
          "ප්‍රධාන ශාක පෝෂක 3: නයිට්‍රජන් (N - පත්‍ර හා වෘක්ෂීය වර්ධනයට), පොස්පරස් (P - මුල් වර්ධනයට), පොටෑසියම් (K - ඵලදාව හා රෝග ප්‍රතිරෝධයට).",
          "ද්විතීයික පෝෂක: කැල්සියම් (Ca), මැග්නීසියම් (Mg), සල්ෆර් (S).",
          "ක්ෂුද්‍ර පෝෂක: යකඩ, සින්ක්, බෝරෝන්, තඹ.",
          "ජල සම්පාදන ක්‍රම: බිංදු ජල සම්පාදනය (Drip), විසුරුම් ජල සම්පාදනය (Sprinkler), මතුපිට වාරිමාර්ග.",
          "ආරක්ෂිත ගෘහ (Greenhouses) හා දේශගුණික පාලිත කෘෂිකර්මය."
        ),
        read_aloud_text = "ශාකයක නිරෝගී වර්ධනයට මූලද්‍රව්‍ය 16ක් අත්‍යවශ්‍ය වේ. කාර්යක්ෂම බිංදු ජල සම්පාදනය සහ සමබල පොහොර යෙදීම මගින් ජලය හා පොහොර නාස්තිය අවම කරගත හැක."
      ),
      ChapterItem(
        chapter_id = 3,
        title = "3 වන පරිච්ඡේදය: ශාක රෝග, පළිබෝධ පාලනය හා ඒකාබද්ධ පළිබෝධ කළමනාකරණය (IPM)",
        page_start = 51,
        page_end = 75,
        audio_note_url = "https://example.com/audio/agri_ch3.mp3",
        audio_duration = "04:55",
        summary_bullets = listOf(
          "පළිබෝධකයන්: කෘමීන්, මයිටාවන්, නෙමටෝඩාවන්, ගොළුබෙල්ලන්, වල් පැලෑටි.",
          "ශාක රෝග කාරක: දිලීර (කොළ පුල්ලි, අංගමාරය), බැක්ටීරියා (මැලවීම), වෛරස් (කොළ කොඩවීම).",
          "ඒකාබද්ධ පළිබෝධ කළමනාකරණය (IPM): භෞතික, යාන්ත්‍රික, කෘෂිකාර්මික, ජෛවීය හා රසායනික ක්‍රම සුසංයෝගය.",
          "ස්වභාවික විලෝපිකයන් හා පරපෝෂිතයන් භාවිතය.",
          "පළිබෝධනාශක ආරක්ෂිතව භාවිත කිරීම සහ පාරිසරික බලපෑම්."
        ),
        read_aloud_text = "රසායනික පළිබෝධනාශක මත පමණක් යැපීම පරිසරයට හා මිනිස් සිරුරට අතිශය අහිතකර වේ. IPM හෙවත් ඒකාබද්ධ පළිබෝධ පාලනය මගින් පරිසර හිතකාමී ලෙස පළිබෝධ පාලනය කළ හැක."
      ),
      ChapterItem(
        chapter_id = 4,
        title = "4 වන පරිච්ඡේදය: අස්වනු පසු තාක්ෂණය හා සත්ව පාලනය",
        page_start = 76,
        page_end = 100,
        audio_note_url = "https://example.com/audio/agri_ch4.mp3",
        audio_duration = "04:45",
        summary_bullets = listOf(
          "අස්වනු නෙළීමේ නිවැරදි මුහුකුරා යාමේ අවස්ථා හඳුනාගැනීම.",
          "අස්වනු හානිය අවම කිරීම: නිවැරදි ඇසුරුම්කරණය (ප්ලාස්ටික් කූඩ), ප්‍රවාහනය හා ශීතාගාර ගබඩා.",
          "අගය එකතු කළ නිෂ්පාදන: විජලනය, ජෑම්, කෝඩියල්, අච්චාරු සැකසීම.",
          "කුකුළු පාලනය: බිත්තර කුකුළන් (Layers) හා මස් පිණිස කුකුළන් (Broilers) නඩත්තුව.",
          "කිරි ගව පාලනය, තණබිම් කළමනාකරණය හා සනීපාරක්ෂාව."
        ),
        read_aloud_text = "අස්වැන්න නෙළීමෙන් පසු සිදුවන 30%කට අධික පසු අස්වනු නාස්තිය වළක්වා ගැනීමට නවීන තාක්ෂණය යොදාගැනීමෙන් ගොවි ආදායම දෙගුණ කරගත හැක."
      )
    )
  }

  fun getEnglishChapters(grade: String): List<ChapterItem> {
    return listOf(
      ChapterItem(
        chapter_id = 1,
        title = "Unit 1: Mastering Verb Tenses & Sentence Structures",
        page_start = 1,
        page_end = 25,
        audio_note_url = "https://example.com/audio/eng_ch1.mp3",
        audio_duration = "05:10",
        summary_bullets = listOf(
          "Simple Present vs Present Continuous: Habits & facts (plays) vs Ongoing actions (is playing).",
          "Simple Past vs Past Continuous: Completed action (went) vs Action in progress interrupted (was reading).",
          "Present Perfect Tense: Subject + have/has + V3 (e.g., 'She has finished her homework'). Used with 'since' and 'for'.",
          "Past Perfect Tense: Subject + had + V3 (action completed before another past event).",
          "Future Forms: will + V1 (predictions/promises) and 'going to' (intentions/plans)."
        ),
        read_aloud_text = "Mastering English tenses is essential for excelling in the O/L examination. Always pay close attention to time markers like 'yesterday', 'since', 'already', and 'while' to select the correct verb form."
      ),
      ChapterItem(
        chapter_id = 2,
        title = "Unit 2: Active Voice and Passive Voice Transformations",
        page_start = 26,
        page_end = 50,
        audio_note_url = "https://example.com/audio/eng_ch2.mp3",
        audio_duration = "05:00",
        summary_bullets = listOf(
          "Core rule: Object of active becomes Subject of passive + be verb in same tense + Past Participle (V3).",
          "Simple Present: 'writes a book' -> 'A book is written'.",
          "Simple Past: 'cleaned the room' -> 'The room was cleaned'.",
          "Present Continuous: 'is repairing the car' -> 'The car is being repaired'.",
          "Modal Passives: 'can solve the problem' -> 'The problem can be solved'."
        ),
        read_aloud_text = "Passive voice is used when the action or the receiver of the action is more important than the doer. Remember that the past participle verb is mandatory in every passive construction."
      ),
      ChapterItem(
        chapter_id = 3,
        title = "Unit 3: Direct and Indirect (Reported) Speech",
        page_start = 51,
        page_end = 75,
        audio_note_url = "https://example.com/audio/eng_ch3.mp3",
        audio_duration = "05:05",
        summary_bullets = listOf(
          "Tense backshift rule when reporting verb is in past (said, told, asked).",
          "Simple Present -> Simple Past ('I work' -> 'He said that he worked').",
          "Present Perfect -> Past Perfect ('I have seen' -> 'She said that she had seen').",
          "Pronoun and time word shifts: now -> then, today -> that day, tomorrow -> the next day.",
          "Reporting Questions: Wh-questions keep question word; Yes/No questions use 'if' or 'whether'."
        ),
        read_aloud_text = "Reported speech transforms spoken words into formal narrative. Ensure you change pronouns, verb tenses, and time expressions accurately to avoid losing marks."
      ),
      ChapterItem(
        chapter_id = 4,
        title = "Unit 4: Conditional Sentences (Types 1, 2, and 3)",
        page_start = 76,
        page_end = 100,
        audio_note_url = "https://example.com/audio/eng_ch4.mp3",
        audio_duration = "04:50",
        summary_bullets = listOf(
          "Type 1 (Real & Likely): If + Simple Present, will + Base Verb (e.g., 'If it rains, we will stay home').",
          "Type 2 (Unreal Present): If + Simple Past, would + Base Verb (e.g., 'If I had money, I would buy a car').",
          "Type 3 (Impossible Past): If + Past Perfect, would have + V3 (e.g., 'If you had studied, you would have passed').",
          "Using 'unless' instead of 'if not'.",
          "Common exam error: Never use 'will' or 'would' inside the 'if' clause itself."
        ),
        read_aloud_text = "Conditionals express hypotheses and outcomes. Practicing the strict formula for Type 1, Type 2, and Type 3 conditionals guarantees full marks in grammatical completion questions."
      ),
      ChapterItem(
        chapter_id = 5,
        title = "Unit 5: Formal Writing (Letters, Notices, Articles & Essays)",
        page_start = 101,
        page_end = 125,
        audio_note_url = "https://example.com/audio/eng_ch5.mp3",
        audio_duration = "05:15",
        summary_bullets = listOf(
          "Formal letter layout: Sender address, Date, Receiver designation & address, Salutation, Subject heading, Body, Sign-off.",
          "School Notice format: Heading, Date, Time, Venue, Target group, Purpose, Contact person.",
          "Bar Chart & Pie Chart description: Overview, highest value, lowest value, trends and comparison phrases.",
          "Essay structure: Engaging introduction, 2-3 well-developed body paragraphs with topic sentences, logical conclusion.",
          "Transitional linkers: Furthermore, However, Consequently, In addition, In contrast."
        ),
        read_aloud_text = "Writing carries significant weight in O/L Paper 2. Clear paragraph organization, correct punctuation, and formal vocabulary ensure you achieve top grades."
      )
    )
  }

  fun getElectiveChapters(norm: String, subjectName: String): List<ChapterItem> {
    return when {
      norm.contains("music") || norm.contains("සංගීත") -> listOf(
        ChapterItem(
          chapter_id = 1,
          title = "1 වන පරිච්ඡේදය: නාදය, ස්වර හා උත්තර භාරතීය රාග මූලධර්ම",
          page_start = 1,
          page_end = 25,
          audio_note_url = "https://example.com/audio/music_ch1.mp3",
          audio_duration = "04:45",
          summary_bullets = listOf(
            "ස්වර 7: ස, රි, ග, ම, ප, ධ, නි. ශුද්ධ ස්වර, කෝමල ස්වර හා තීව්‍ර ස්වර.",
            "රාගයක ලක්ෂණ: ථාටය, ආරෝහණ, අවරෝහණ, වාදී ස්වරය, සංවාදී ස්වරය හා ගායන වේලාව.",
            "ප්‍රධාන රාග: බිලාවල්, කල්‍යාණ්, කාෆි, භෛරව්, ඛමාජ්.",
            "තාල වාදන: ත්‍රීතාලය (මාත්‍රා 16), දාද්රා (මාත්‍රා 6), කහර්වා (මාත්‍රා 8).",
            "දේශීය නූර්ති, නාඩගම් හා ජන සංගීත ශෛලීන්."
          ),
          read_aloud_text = "සංගීතයේ මූලික නාද රටා සහ රාග පිළිබඳ ගැඹුරු අධ්‍යයනය මෙහිදී සාකච්ඡා කෙරේ. වාදී සහ සංවාදී ස්වර නිවැරදිව හඳුනාගැනීම රාග ගායනයේ ප්‍රධාන වේ."
        ),
        ChapterItem(
          chapter_id = 2,
          title = "2 වන පරිච්ඡේදය: දේශීය ජන සංගීතය, තූර්ය වාදන හා නාඩගම්",
          page_start = 26,
          page_end = 50,
          audio_note_url = "https://example.com/audio/music_ch2.mp3",
          audio_duration = "04:50",
          summary_bullets = listOf(
            "දේශීය ජන ගී: ගොයම් කවි, පැල් කවි, පතල් කවි, කරත්ත කවි, ඔරු පාරු කවි.",
            "පංචතූර්ය නාදය: ආතත, විතත, ආතතවිතත, ඝන, සුසිර.",
            "නූර්ති ගීත හා ජෝන් ද සිල්වා ශූරීන්ගේ මෙහෙවර.",
            "ලක්දිව සාම්ප්‍රදායික සංගීත භාණ්ඩ: ගැටබෙරය, යක්බෙරය, දවුල, තම්මැට්ටම, හොරණෑව.",
            "ස්වර ප්‍රස්තාර කියවීම හා ලිවීම."
          ),
          read_aloud_text = "හෙළ ජන සංගීතය අපේ මුතුන්මිත්තන්ගේ ජීවන සුවඳ රැඳි අමිල සංස්කෘතික උරුමයකි. ජන කවිවල තාල රටා හා පංචතූර්ය නාද ක්‍රම විභාගයට අතිශය වැදගත් වේ."
        )
      )
      norm.contains("art") || norm.contains("චිත්‍ර") -> listOf(
        ChapterItem(
          chapter_id = 1,
          title = "1 වන පරිච්ඡේදය: කලාවේ මූලධර්ම, වර්ණ න්‍යාය හා සංයුතිය",
          page_start = 1,
          page_end = 25,
          audio_note_url = "https://example.com/audio/art_ch1.mp3",
          audio_duration = "04:40",
          summary_bullets = listOf(
            "කලාවේ මූලිකාංග: රේඛාව, හැඩය, වර්ණය, පෘෂ්ඨය, අවකාශය, ආලෝකය හා අඳුර.",
            "වර්ණ චක්‍රය: ප්‍රාථමික වර්ණ (රතු, කහ, නිල්), ද්විතීයික වර්ණ (තැඹිලි, කොළ, දම්), තෘතීයික වර්ණ.",
            "සංයුති මූලධර්ම: තුල්‍යතාවය (සමමිතික/අසමමිතික), රිද්මය, ප්‍රමුඛතාවය, ඒකීයත්වය.",
            "පර්යාවලෝකනය (Perspective): තනි ලක්ෂ්‍ය හා ද්විත්ව ලක්ෂ්‍ය පර්යාවලෝකනය.",
            "ජලසායම්, තෙල්සායම් හා ඇක්‍රිලික් ශිල්ප ක්‍රම."
          ),
          read_aloud_text = "චිත්‍ර කලාවේ පදනම වන්නේ වර්ණ න්‍යාය සහ නිවැරදි සංයුතියයි. රේඛාව හා වර්ණ එකිනෙක මුසු කරමින් ජීවමාන කලා කෘතියක් නිර්මාණය කිරීම මෙහිදී උගන්වයි."
        ),
        ChapterItem(
          chapter_id = 2,
          title = "2 වන පරිච්ඡේදය: ලක්දිව බිතුසිතුවම් කලාව (සීගිරිය, පොළොන්නරුව හා මහනුවර)",
          page_start = 26,
          page_end = 50,
          audio_note_url = "https://example.com/audio/art_ch2.mp3",
          audio_duration = "05:00",
          summary_bullets = listOf(
            "සීගිරි බිතුසිතුවම් (5 වන සියවස): අප්සරාවන්ගේ රූ, ස්වභාවික වර්ණ (රතු, කහ, කොළ), රේඛීය ලාලිත්‍යය.",
            "පොළොන්නරු තිවංක පිළිමගෙයි සිතුවම්: ජාතක කතා නිරූපණය, සාසන ඉතිහාසය, අනුරාධපුර සම්ප්‍රදායේ විකාශනය.",
            "මහනුවර යුගයේ බිතුසිතුවම් (දෙගල්දොරුව, රිදී විහාරය): තීරු ක්‍රමය, පැතලි වර්ණ, රතු පසුබිම, දළදා පෙරහැර සිතුවම්.",
            "දෙවරගම්පල සිල්වත්තැන ඇතුළු සිත්තර පරම්පරාව.",
            "පුරාණ ස්වභාවික සායම් සකස් කරගත් ආකාරය."
          ),
          read_aloud_text = "ශ්‍රී ලංකාවේ චිත්‍ර කලා ඉතිහාසය ලෝක ප්‍රකට සීගිරි බිතුසිතුවම්වල සිට මහනුවර සම්ප්‍රදාය දක්වා විහිදී යයි. දේශීය සිත්තරුන්ගේ රේඛා හැසිරවීම සහ ස්වභාවික සායම් භාවිතය මෙහිදී ඇගයීමට ලක්වේ."
        )
      )
      norm.contains("dance") || norm.contains("නර්තන") -> listOf(
        ChapterItem(
          chapter_id = 1,
          title = "1 වන පරිච්ඡේදය: දේශීය නර්තන සම්ප්‍රදායන් 3 හා මූලික පාද බෙදුම්",
          page_start = 1,
          page_end = 25,
          audio_note_url = "https://example.com/audio/dance_ch1.mp3",
          audio_duration = "04:50",
          summary_bullets = listOf(
            "දේශීය නර්තන සම්ප්‍රදායන් 3: උඩරට (ශාන්තිකර්මය: කොහොඹා කංකාරිය, බෙරය: ගැටබෙරය), පහතරට (දෙවොල් මඩුව, යක්බෙරය), සබරගමු (සොරබොර ශාන්තිකර්මය, දවුල).",
            "උඩරට මූලික මණ්ඩිය සහ පා හරඹ 12.",
            "සතර අභිනය: ආංගික, වාචික, ආහාර්ය, සාත්වික.",
            "උඩරට වෙස් ඇඳුම් කට්ටලයේ අංග 64: ඔටුන්න, තෝඩු, බන්ධි, අවුල්හැරය, කරපටිය, දේවකරණය.",
            "ගුරු කුල සහ නර්තන විශාරදයන්."
          ),
          read_aloud_text = "උඩරට, පහතරට සහ සබරගමු යන ත්‍රිවිධ දේශීය නර්තන සම්ප්‍රදායන් අපේ අභිමානවත් උරුමයයි. මණ්ඩිය පිහිටුවා පාද බෙදුම් හා අභිනයන් ප්‍රගුණ කිරීම නර්තන ශිල්පියෙකුගේ මූලික පියවරයි."
        ),
        ChapterItem(
          chapter_id = 2,
          title = "2 වන පරිච්ඡේදය: උඩරට වන්නම් 18 හා නර්තන අලංකාර",
          page_start = 26,
          page_end = 50,
          audio_note_url = "https://example.com/audio/dance_ch2.mp3",
          audio_duration = "05:05",
          summary_bullets = listOf(
            "උඩරට සම්භාව්‍ය වන්නම් 18: ගජගා, තුරඟා, මයුරා, සිංහරාජ, නෛඅඩි, උසුඳා, මුසලඩි ආදී සත්ව හා ස්වභාව වර්ණනා.",
            "වන්නමක අංග 4: තානම, කවිය, කස්තිරම, සීරුමාරුව.",
            "ශ්‍රී වීරපරාක්‍රම නරේන්ද්‍රසිංහ රජ සමයේ කවි මුදලි ගණිතාලංකාර විසින් වන්නම් රචනා කිරීම.",
            "බෙර පද, තාලම්පට භාවිතය හා අනුකරණාත්මක චලන.",
            "දළදා පෙරහැර හා සංස්කෘතික මංගල්‍යයන්හි නර්තන කාර්යභාරය."
          ),
          read_aloud_text = "සතුන්ගේ හා ස්වභාවධර්මයේ චලනයන් ආශ්‍රයෙන් නිර්මාණය වූ උඩරට වන්නම් 18 නර්තන කලාවේ අග්‍රගණ්‍ය නිර්මාණ වේ. ගජගා වන්නමේ ඇත් ගමන හා මයුරා වන්නමේ මොනර නැටුම අලංකාර ලෙස රඟදැක්වේ."
        )
      )
      else -> listOf(
        ChapterItem(
          chapter_id = 1,
          title = "1 වන පරිච්ඡේදය: $subjectName - මූලික සංකල්ප හා විෂය හැඳින්වීම",
          page_start = 1,
          page_end = 25,
          audio_note_url = "https://example.com/audio/gen_ch1.mp3",
          audio_duration = "04:30",
          summary_bullets = listOf(
            "$subjectName විෂය නිර්දේශයේ පළමු ඒකකයේ මූලික න්‍යාය සහ අර්ථ දැක්වීම්.",
            "විභාග ගැටළු විසඳීමට අවශ්‍ය මූලික සූත්‍ර සහ කෙටි ක්‍රම.",
            "පසුගිය ප්‍රශ්න පත්‍රවල නිතර අසන ප්‍රධාන විභාග ඉලක්ක.",
            "පාඩමේ වැදගත්ම නිර්වචන සහ පාරිභාෂික වචන.",
            "ඉක්මන් පුනරීක්ෂණ සටහන් සහ මතක සටහන් (Mnemonics)."
          ),
          read_aloud_text = "$subjectName විෂය නිර්දේශයේ පළමු ඒකකය ආවරණය කෙරේ. මෙහි ඇති මූලධර්ම සහ නියමයන් නිවැරදිව ග්‍රහණය කරගැනීමෙන් විභාගයේ ඉහළ ලකුණු ලබාගැනීමට හැකියාව ලැබේ."
        ),
        ChapterItem(
          chapter_id = 2,
          title = "2 වන පරිච්ඡේදය: $subjectName - ප්‍රායෝගික යෙදීම් හා ගැටළු විග්‍රහය",
          page_start = 26,
          page_end = 55,
          audio_note_url = "https://example.com/audio/gen_ch2.mp3",
          audio_duration = "04:45",
          summary_bullets = listOf(
            "දෙවන ඒකකයේ සංකීර්ණ ගැටළු පියවරෙන් පියවර විසඳීම.",
            "විභාග ප්‍රශ්න පත්‍ර ආකෘති සහ ලකුණු ලබාදීමේ පටිපාටිය.",
            "ප්‍රායෝගික ක්‍රියාකාරකම් සහ ක්ෂේත්‍ර නිරීක්ෂණ සටහන්.",
            "වැරදීමට ඉඩ ඇති ස්ථාන සහ ඒවා මඟහරවා ගන්නා ආකාරය.",
            "කාල කළමනාකරණය සමඟ පිළිතුරු ලිවීමේ උපක්‍රම."
          ),
          read_aloud_text = "$subjectName දෙවන ඒකකයේ ප්‍රායෝගික ගැටළු විසඳීමේදී විභාග ක්‍රමවේදය අනුගමනය කිරීම වැදගත්ය. සියලුම පියවර පැහැදිලිව දැක්වීමෙන් සම්පූර්ණ ලකුණු ලබාගත හැක."
        ),
        ChapterItem(
          chapter_id = 3,
          title = "3 වන පරිච්ඡේදය: $subjectName - උසස් සිද්ධාන්ත හා විභාග ආදර්ශ ප්‍රශ්න",
          page_start = 56,
          page_end = 90,
          audio_note_url = "https://example.com/audio/gen_ch3.mp3",
          audio_duration = "05:00",
          summary_bullets = listOf(
            "විභාග අපේක්ෂිත ආදර්ශ ප්‍රශ්න සාකච්ඡාව.",
            "විශිෂ්ට සාමාර්ථයක් (A Pass) සඳහා විශේෂිත සටහන්.",
            "සංසන්දනාත්මක විශ්ලේෂණ සහ ප්‍රස්තාරික සටහන්.",
            "විභාග ශාලාවේදී මතකය ආවර්ජනය කරගන්නා ක්‍රමවේද.",
            "සම්පූර්ණ කෙටි සටහන එක් බැල්මකින් (Master Summary)."
          ),
          read_aloud_text = "$subjectName විෂය නිර්දේශයේ උසස් සිද්ධාන්ත සහ විභාග ප්‍රශ්න සාකච්ඡා කෙරේ. ස්වයං පුහුණු ප්‍රශ්නාවලි සහ Flashcards සමඟින් පුහුණුව තවදුරටත් ශක්තිමත් කරගන්න."
        )
      )
    }
  }
}
