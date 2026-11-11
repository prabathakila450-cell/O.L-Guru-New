package com.example

object SocialCommerceTrueFalseBank {
  fun getIctQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "දත්ත හා තොරතුරු පද්ධති",
        statement = if (batchIndex % 2 == 0) "අමු දත්ත (Raw Data) සැකසුම් ක්‍රියාවලියකට ලක්කළ පසු ලැබෙන්නේ අර්ථවත් තොරතුරු (Information) ය."
                    else "තොරතුරු යනු සැකසීමට පෙර ලැබෙන කරුණු සහ සංඛ්‍යා වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "දත්ත + සැකසීම = තොරතුරු (Data + Processing = Information)."
                        else "සැකසීමට පෙර ලැබෙන්නේ අමු දත්තයි (Data). තොරතුරු යනු සැකසූ ප්‍රතිඵලයයි.",
        examTrap = "දත්ත ආදානය වන අතර තොරතුරු ප්‍රතිදානය වේ."
      ),
      TrueFalseTopicContent(
        unitName = "පරිගණක මතකය (RAM & ROM)",
        statement = if (batchIndex % 2 == 0) "RAM යනු පරිගණකයේ විදුලිය විසන්ධි වූ විට දත්ත මැකී යන නශ්වර (Volatile) මතකයකි."
                    else "ROM මතකය යනු පරිගණකය ක්‍රියාත්මක වන විට වැඩසටහන් තාවකාලිකව රඳවා තබා ගන්නා මතකයකි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "RAM (Random Access Memory) නශ්වර වන අතර සකසනයට ඉක්මනින් දත්ත සැපයීමට යොදා ගනී."
                        else "වැඩසටහන් තාවකාලිකව රඳවන්නේ RAM හි ය. ROM (Read Only Memory) අනශ්වර වන අතර BIOS උපදෙස් ස්ථිරව අඩංගු වේ.",
        examTrap = "RAM සහ ROM වල වෙනස O/L ICT ප්‍රශ්න පත්‍රවල නිතරම විමසයි."
      ),
      TrueFalseTopicContent(
        unitName = "ද්විමය සංඛ්‍යා හා දත්ත නිරූපණය",
        statement = if (batchIndex % 2 == 0) "දශම සංඛ්‍යා 10 ද්විමය ක්‍රමයෙන් නිරූපණය කරන්නේ 1010₂ ලෙසය."
                    else "බයිටයක් (1 Byte) යනු බිටු 16 ක එකතුවකි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "8 + 2 = 10, ද්විමය ස්ථානීය අගයන් (8, 4, 2, 1) අනුව 1010₂ වේ."
                        else "බයිටයක් (1 Byte) යනු බිටු 8 ක (8 bits) එකතුවකි. බිටු 4 ක් නිබලයකි (Nibble).",
        examTrap = "1 KB = 1024 Bytes, 1 MB = 1024 KB."
      ),
      TrueFalseTopicContent(
        unitName = "තාර්කික ද්වාර (Logic Gates)",
        statement = if (batchIndex % 2 == 0) "AND ද්වාරයක ප්‍රතිදානය 1 වන්නේ සියලු ආදාන 1 වන විට පමණි."
                    else "NOT ද්වාරයකට ආදාන (Inputs) කිහිපයක් ලබාදිය හැක.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "AND ද්වාරය ගුණිතයක් බඳුය (Q = A · B)."
                        else "NOT ද්වාරයකට ඇත්තේ එක් ආදානයක් සහ එක් ප්‍රතිදානයක් පමණි (Inverter).",
        examTrap = "OR ද්වාරයක ඕනෑම ආදානයක් 1 වූ විට ප්‍රතිදානය 1 වේ."
      ),
      TrueFalseTopicContent(
        unitName = "පරිගණක ජාල හා අන්තර්ජාලය",
        statement = if (batchIndex % 2 == 0) "IP ලිපිනයක් යනු අන්තර්ජාලයට සම්බන්ධ පරිගණකයක් හෝ උපාංගයක් අනන්‍යව හඳුනාගැනීමට දෙන සංඛ්‍යාත්මක ලිපිනයකි."
                    else "LAN (Local Area Network) යනු ලෝකය පුරා විසිරුණු පරිගණක එකිනෙක සම්බන්ධ කරන පුළුල් ප්‍රදේශ ජාලයකි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "IPv4 ලිපිනයක් බිටු 32 කින් (උදා: 192.168.1.1) සමන්විත වේ."
                        else "LAN යනු ගොඩනැගිල්ලක් හෝ පාසලක් වැනි සීමිත භූමි ප්‍රදේශයක ඇති ජාලයකි. ලෝකය පුරා ඇත්තේ WAN (Wide Area Network) ය.",
        examTrap = "අන්තර්ජාලය (Internet) යනු ලොව විශාලතම WAN ජාලයයි."
      )
    )
    val ictGradeOffset = when (grade) {
      9 -> 0
      10 -> 2
      11 -> 4
      else -> 0
    }
    val safeIndex = (number - 1 + ictGradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "ප්‍රශ්න අංක ${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }

  fun getGeographyQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "ශ්‍රී ලංකාවේ භූ විෂමතාව",
        statement = if (batchIndex % 2 == 0) "ශ්‍රී ලංකාවේ උසම කඳු මුදුන මධ්‍යම කඳුකරයේ පිහිටි පිදුරුතලගල (මීටර් 2524) වේ."
                    else "ශ්‍රී ලංකාවේ දිගම ගංගාව වන්නේ කළු ගඟයි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "පිදුරුතලගල මීටර් 2524 ක් උස වන අතර දෙවන උසම කන්ද කිරිගල්පොත්ත වේ."
                        else "ශ්‍රී ලංකාවේ දිගම ගංගාව මහවැලි ගඟයි (කි.මී. 335). වැඩිම ජල කඳක් මුහුදට ගෙන යන්නේ කළු ගඟයි.",
        examTrap = "කළු ගඟ වැඩිම ජල ධාරිතාවක් රැගෙන ගියද දිගින් වැඩිම ගඟ මහවැලි ගඟයි."
      ),
      TrueFalseTopicContent(
        unitName = "සිතියම් කියවීම හා සමෝච්ච රේඛා",
        statement = if (batchIndex % 2 == 0) "සමෝච්ච රේඛා එකිනෙකට ඉතා ළඟින් පිහිටන විට එම භූමියේ බෑවුම දැඩි (කඳුකර) බෑවුමක් බව පෙන්නුම් කරයි."
                    else "1:50,000 භූ ලක්ෂණ සිතියමක සෙන්ටිමීටර 2 ක් පොළොවේ කිලෝමීටර 5 ක් නිරූපණය කරයි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "සමෝච්ච රේඛා ළඟින් පිහිටීම දැඩි බෑවුමද, ඈතින් පිහිටීම මෘදු බෑවුමද දක්වයි."
                        else "1:50,000 පරිමාණයේ 2 cm = 100,000 cm = 1 km (කිලෝමීටර 1 ක්) නිරූපණය කරයි.",
        examTrap = "සමෝච්ච රේඛා එකිනෙක කිසිවිටෙක ඡේදනය නොවේ."
      ),
      TrueFalseTopicContent(
        unitName = "මෝසම් සුළං හා වර්ෂාපතනය",
        statement = if (batchIndex % 2 == 0) "නිරිතදිග මෝසම් සුළං මඟින් මැයි සිට සැප්තැම්බර් දක්වා කාලය තුළ දිවයිනේ නිරිතදිග කලාපයට අධික වර්ෂාවක් ලැබේ."
                    else "ශ්‍රී ලංකාවේ මුළු දිවයිනටම පොදුවේ වැසි ලැබෙන්නේ නිරිතදිග මෝසම් කාලයේදී පමණි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ඉන්දියන් සාගරය හරහා හමා එන තෙතමනය සහිත නිරිතදිග මෝසම් සුළඟ මධ්‍යම කඳුකරයේ ගැටී වැසි ඇතිකරයි."
                        else "මුළු දිවයිනටම පොදුවේ වැසි ලැබෙන්නේ සංවහන වැසි ඇතිවන අන්තර් මෝසම් කාලවලදීය (මාර්තු-අප්‍රේල්, ඔක්තෝබර්-නොවැම්බර්).",
        examTrap = "ඊසානදිග මෝසමෙන් වියළි කලාපයට හා උතුරු නැගෙනහිරට වැසි ලැබේ."
      )
    )
    val geoGradeOffset = when (grade) {
      9 -> 0
      10 -> 1
      11 -> 2
      else -> 0
    }
    val safeIndex = (number - 1 + geoGradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "ප්‍රශ්න අංක ${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }

  fun getCivicsQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "ප්‍රජාතන්ත්‍රවාදය හා ආණ්ඩුක්‍රම",
        statement = if (batchIndex % 2 == 0) "ශ්‍රී ලංකාවේ නීති සම්පාදනය කිරීමේ ව්‍යවස්ථාදායක බලය හිමි වන්නේ පාර්ලිමේන්තුවටයි."
                    else "ශ්‍රී ලංකා පාර්ලිමේන්තුව මන්ත්‍රීවරුන් 300 දෙනෙකුගෙන් සමන්විත වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ව්‍යවස්ථාදායක බලය පාර්ලිමේන්තුව මඟින්ද, විධායක බලය ජනාධිපතිවරයා මඟින්ද ක්‍රියාත්මක වේ."
                        else "ශ්‍රී ලංකා පාර්ලිමේන්තුවේ මන්ත්‍රී ආසන සංඛ්‍යාව 225 කි (මැතිවරණ කොට්ඨාස 196, ජාතික ලැයිස්තුව 29).",
        examTrap = "මන්ත්‍රීවරුන් 225 දෙනාගෙන් 29 දෙනෙකු ජාතික ලැයිස්තුවෙන් පත්වේ."
      ),
      TrueFalseTopicContent(
        unitName = "මූලික මිනිස් අයිතිවාසිකම්",
        statement = if (batchIndex % 2 == 0) "ශ්‍රී ලංකාවේ මූලික මිනිස් අයිතිවාසිකම් උල්ලංඝනය වීමක් පිළිබඳ සෘජුව විමර්ශනය කර තීන්දු දීමේ තනි අධිකරණ බලය ඇත්තේ ශ්‍රේෂ්ඨාධිකරණයටයි."
                    else "පුරවැසියෙකුගේ මූලික අයිතිවාසිකම් පිළිබඳ නඩු විභාග කරන්නේ ප්‍රාදේශීය සභා මඟිනි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ආණ්ඩුක්‍රම ව්‍යවස්ථාවේ 126 වගන්තිය යටතේ මූලික අයිතිවාසිකම් නඩු විභාග වන්නේ ශ්‍රේෂ්ඨාධිකරණයේදීය."
                        else "ප්‍රාදේශීය සභා යනු පළාත් පාලන ආයතන වේ. අධිකරණ බලය ක්‍රියාත්මක කරන්නේ අධිකරණ පද්ධතියෙනි.",
        examTrap = "මූලික අයිතිවාසිකම් උල්ලංඝනය වී මාසයක් ඇතුළත ශ්‍රේෂ්ඨාධිකරණයට පෙත්සමක් ඉදිරිපත් කළ යුතුය."
      ),
      TrueFalseTopicContent(
        unitName = "නීතියේ ආධිපත්‍යය හා පුරවැසි වගකීම්",
        statement = if (batchIndex % 2 == 0) "නීතිය ඉදිරියේ සියලු දෙනා සමාන බව සහ කිසිවෙකුත් නීතියට ඉහළින් නොසිටීම නීතියේ ආධිපත්‍යය මූලධර්මයයි."
                    else "ඡන්දය ප්‍රකාශ කිරීමේ අයිතිය හිමි වන්නේ වයස අවුරුදු 21 සම්පූර්ණ වූ පුරවැසියන්ට පමණි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "නීතියේ ආධිපත්‍යය යටතේ ජනාධිපතිගේ සිට සාමාන්‍ය පුරවැසියා දක්වා සියලු දෙනා නීතියට යටත් වේ."
                        else "ශ්‍රී ලංකාවේ සර්වජන ඡන්ද බලය හිමි වන්නේ වයස අවුරුදු 18 සම්පූර්ණ වූ පුරවැසියන්ටය (1931 ඩොනමෝර් ආණ්ඩුක්‍රමයෙන් ලැබිණි).",
        examTrap = "ශ්‍රී ලංකාවට සර්වජන ඡන්ද බලය ලැබුණේ 1931 ඩොනමෝර් ප්‍රතිසංස්කරණ මඟිනි."
      )
    )
    val civGradeOffset = when (grade) {
      9 -> 0
      10 -> 1
      11 -> 2
      else -> 0
    }
    val safeIndex = (number - 1 + civGradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "ප්‍රශ්න අංක ${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }

  fun getCommerceQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "ගිණුම්කරණ සමීකරණය",
        statement = if (batchIndex % 2 == 0) "මූලික ගිණුම්කරණ සමීකරණය: වත්කම් = හිමිකම + වගකීම් (Assets = Equity + Liabilities) වේ."
                    else "ගිණුම්කරණ සමීකරණයට අනුව හිමිකම = වත්කම් + වගකීම් වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ව්‍යාපාරයක ඇති සියලු සම්පත් (වත්කම්) හිමිකරුගේ මුදල්වලින් හෝ බාහිර ණයවලින් සපයා ඇත."
                        else "හිමිකම = වත්කම් - වගකීම් විය යුතුය. වත්කම් + වගකීම් නොවේ.",
        examTrap = "වත්කම් = හිමිකම + වගකීම් යන්න කිසිවිටෙක අමතක නොකරන්න."
      ),
      TrueFalseTopicContent(
        unitName = "ද්විත්ව සටහන් රීති",
        statement = if (batchIndex % 2 == 0) "වත්කමක් හෝ වියදමක් වැඩි වන විට හර (Debit) වන අතර, ආදායමක් හෝ වගකීමක් වැඩි වන විට බැර (Credit) වේ."
                    else "ණයගැතියන් (Debtors) යනු ව්‍යාපාරයක පවතින දිගුකාලීන වගකීමකි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "සම්මත ද්විත්ව සටහන් රීතිය: වත්කම්/වියදම් වැඩිවීම -> හර, වගකීම්/ආදායම්/හිමිකම වැඩිවීම -> බැර."
                        else "ණයගැතියන් යනු ව්‍යාපාරයට මුදල් ලැබිය යුතු ජංගම වත්කමකි. ගෙවිය යුතු වන්නේ ණයහිමියන්ටය (වගකීම්).",
        examTrap = "ණයගැතියන් = වත්කම් (ලැබිය යුතු), ණයහිමියන් = වගකීම් (ගෙවිය යුතු)."
      ),
      TrueFalseTopicContent(
        unitName = "මහ බැංකුව හා මුදල් පද්ධතිය",
        statement = if (batchIndex % 2 == 0) "ශ්‍රී ලංකාවේ මුදල් නෝට්ටු සහ කාසි නිකුත් කිරීමේ තනි නීත්‍යානුකූල බලය ඇත්තේ ශ්‍රී ලංකා මහ බැංකුවටයි."
                    else "ශ්‍රී ලංකා මහ බැංකුව සාමාන්‍ය මහජනතාව සඳහා ඉතිරිකිරීමේ ගිණුම් පවත්වාගෙන යයි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "මහ බැංකුව මෙරට මුදල් නිකුත් කිරීමේ ඒකාධිකාරය දරන අතර රජයේ බැංකුකරුවා වේ."
                        else "මහ බැංකුව මහජනතාව සමඟ සෘජු ගනුදෙනු නොකරයි. එය 'බැංකුකරුවන්ගේ බැංකුවයි'. මහජන ගිණුම් පවත්වන්නේ වාණිජ බැංකුය.",
        examTrap = "මහ බැංකුවේ ප්‍රධාන අරමුණු: මිල ස්ථායිතාව සහ මූල්‍ය පද්ධති ස්ථායිතාවයි."
      )
    )
    val commGradeOffset = when (grade) {
      9 -> 0
      10 -> 1
      11 -> 2
      else -> 0
    }
    val safeIndex = (number - 1 + commGradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "ප්‍රශ්න අංක ${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }
}
