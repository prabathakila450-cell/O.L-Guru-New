package com.example

/**
 * Sandu Theory - O/L Commerce & Accounting (ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය)
 * Pages 29 to 50 (Part 2): කළමනාකරණය, ගිණුම්කරණය, මූලික පොත්, දෝෂ හා වෙළඳාම
 */
object SanduCommerceTheoryPagesPart2 {

  val pages: List<SanduCommercePageItem> by lazy {
    listOf(
      // PAGE 29
      SanduCommercePageItem(
        pageNumber = 29,
        chapterNumber = 7,
        chapterTitleSinhala = "ව්‍යාපාර සංවිධාන ක්‍රමයක් තෝරාගැනීම",
        gradeLevel = "10",
        rootConcept = "සංවිධාන ක්‍රමයක් තෝරාගැනීම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සැලකිල්ලට ගන්නා ප්‍රධාන සාධක 3",
            bullets = listOf(
              "1. අරමුණ අනුව ව්‍යාපාර සංවිධාන වර්ගයක් තෝරා ගැනීම.",
              "2. පරිමාණය අනුව ව්‍යාපාර සංවිධාන වර්ගයක් තෝරා ගැනීම.",
              "3. කළමනාකරණය අනුව ව්‍යාපාර සංවිධාන වර්ගයක් තෝරා ගැනීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "අරමුණ අනුව තෝරාගැනීම",
            bullets = listOf(
              "ලාභ ලැබීමේ අරමුණ: ව්‍යාපාරිකයෝ ලාභ ලැබීමේ අපේක්ෂාවෙන් ව්‍යාපාර කටයුතු කරගෙන යති. ලාභය උපරිම කිරීම මෙවැනි ව්‍යාපාරිකයන්ගේ අරමුණයි.",
              "සමාජ සුබසාධන අරමුණ: සාමාජිකයන්ගේ සුභ සිද්ධිය සඳහා කටයුතු කිරීම, විපත් හා අසහනයට පත් වූ ජනතාවට සහන සැලසීම වැනි අරමුණු පාදක කරගනී. පෞද්ගලික හා රාජ්‍ය අංශයේ ද මෙවැනි ව්‍යාපාර ක්‍රියාත්මක වේ."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 30
      SanduCommercePageItem(
        pageNumber = 30,
        chapterNumber = 7,
        chapterTitleSinhala = "පරිමාණය අනුව සංවිධාන තෝරාගැනීම",
        gradeLevel = "10",
        rootConcept = "පරිමාණය අනුව තෝරාගැනීම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ව්‍යාපාරයක පරිමාණය තීරණය කරන සාධක 6",
            bullets = listOf(
              "අයිතිකරුගේ මූල්‍ය ශක්තිය",
              "අයිතිකරුගේ කුසලතා හා පළපුරුද්ද",
              "අයිතිකරුගේ විවිධ සම්බන්ධතා",
              "ව්‍යාපාරය විසින් නිපදවන භාණ්ඩ හා සේවා",
              "නිෂ්පාදන ප්‍රමාණය",
              "නිෂ්පාදනයට අදාළ වන වෙළඳපොළ කොටස"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "සුළු පරිමාණ ව්‍යාපාර තෝරාගැනීමට හේතු",
            bullets = listOf(
              "බොහෝවිට ව්‍යාපාරයක් මුලින්ම ආරම්භ කරනුයේ සුළු පරිමාණ වශයෙනි.",
              "සුළු ප්‍රාග්ධනයකින් ආරම්භ කළ හැකි වීම.",
              "අවම නීතිමය බලපෑම් යටතේ පැවතීම.",
              "තමාගේ දක්ෂතා උපරිම කිරීමට හැකිවීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "මහා පරිමාණ ව්‍යාපාරයක් ආරම්භ කිරීමට හේතු",
            bullets = listOf(
              "ව්‍යාපාරිකයා සතුව විශාල සම්පත් ප්‍රමාණයක් පැවතීම.",
              "ව්‍යාපාරිකයා සතු පළපුරුද්ද සහ ඉහළ අධ්‍යාපනය.",
              "ව්‍යාපාර සඳහාම ලබාදෙන දිරිගැන්වීම් (උදා: බදු සහන).",
              "ජාල සබඳතා පැවතීම.",
              "රජයෙන් සැපයෙන යටිතල පහසුකම් ප්‍රයෝජනයට ගැනීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 31
      SanduCommercePageItem(
        pageNumber = 31,
        chapterNumber = 7,
        chapterTitleSinhala = "කළමනාකරණය අනුව සංවිධාන තෝරාගැනීම",
        gradeLevel = "10",
        rootConcept = "කළමනාකරණය අනුව තෝරාගැනීම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "කළමනාකරණය යනු කුමක්ද?",
            definition = "ව්‍යාපාරයක් සතු සම්පත් සැලසුම් කිරීම, සංවිධානය කිරීම, මෙහෙයවීම (මඟපෙන්වීම) හා පාලනය කිරීම තුළින් ව්‍යාපාරයේ අරමුණු ඉටු කර ගැනීම සඳහා කටයුතු කිරීමේ ක්‍රියාවලිය යි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ඒක පුද්ගල ව්‍යාපාර කළමනාකරණය",
            bullets = listOf(
              "අයිතිකරුට ව්‍යාපාර කටයුතු සම්බන්ධ නිදහසේ තීරණ ගැනීමේ හැකියාව ඇත.",
              "ව්‍යාපාරයේ අයිතිකරු, නායකයා සහ කළමනාකරු ද වේ.",
              "අරමුදල් සම්පාදනය හා ආයෝජනය පිළිබඳ තීරණ ගැනීමේ සම්පූර්ණ නිදහස පවතී.",
              "සම්පත් මෙහෙයවීම පිළිබඳ ස්වාධීන තීරණ ගත හැකි වේ."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "හවුල් හෝ සංස්ථාපිත සමාගම් කළමනාකරණය",
            definition = "ව්‍යාපාරයක කළමනාකරණ කටයුතු පුද්ගලයන් කිහිප දෙනෙකු මඟින් සිදුකර ගැනීමට අපේක්ෂා කරන්නේ නම් හවුල් ව්‍යාපාර හෝ සංස්ථාපිත සමාගමක් තෝරාගැනීම උචිත වේ. එහිදී හවුල්කරුවන් හෝ අධ්‍යක්ෂ මණ්ඩලයේ කැමැත්ත මත සාමූහික තීරණ ගැනීමට හැකියාව ලැබේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 32
      SanduCommercePageItem(
        pageNumber = 32,
        chapterNumber = 8,
        chapterTitleSinhala = "ගිණුම්කරණය සහ ගිණුම්කරණ සමීකරණය",
        gradeLevel = "10",
        rootConcept = "ගිණුම්කරණය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ගිණුම්කරණය සහ මූල්‍ය ගිණුම්කරණය",
            definition = "ව්‍යාපාරයක සිදුවන මුදලින් මැනිය හැකි ගනුදෙනු ගිණුම් පොත්වල සටහන් කර නිසි පරිදි වර්ග කර, මූල්‍ය වාර්තා පිළියෙළ කර අවශ්‍ය පාර්ශවවලට තොරතුරු ලබාදීමේ ක්‍රියාවලිය, ගිණුම්කරණය වේ. එම මූල්‍යමය තොරතුරු සැපයීමට පවතින ගිණුම්කරණය මූල්‍ය ගිණුම්කරණය ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ගිණුම්කරණයේ අරමුණ",
            definition = "ව්‍යාපාරය පිළිබඳ ඇල්මක් දක්වන පාර්ශවයන්ට නිවැරදි තීරණ ගැනීම සඳහා ප්‍රයෝජනවත් මූල්‍ය තොරතුරු සැපයීම ගිණුම්කරණයේ මූලික අරමුණ වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ගිණුම්කරණයේ අවශ්‍යතාවය / වැදගත්කම 5",
            bullets = listOf(
              "ව්‍යාපාරයක් සතු සීමිත සම්පත් පාලනයකින් යුතුව පවත්වා ගැනීම.",
              "ව්‍යාපාරික ගනුදෙනු සටහන් කිරීම තුළින් අමතකවීම් හෝ අතපසුවීම් අවම කරගත හැකිවීම.",
              "ව්‍යාපාරයේ ලාභය / අලාභය තත්ත්වය හා මූල්‍ය තත්ත්වය මැන බැලීම.",
              "ආදායම් බදු ගෙවීම් වැනි නීතිමය අවශ්‍යතාවන් සපුරාලීම.",
              "ඉදිරි ව්‍යාපාරික කටයුතු නිසි ලෙස සැලසුම් කර පවත්වා ගැනීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ගිණුම්කරණ සමීකරණය (Accounting Equation)",
            definition = "ව්‍යාපාරයක වත්කම් සහ එම වත්කම්වල හිමිකාරිත්වය ගිණුම් වාර්තාවල පෙන්නුම් කරනු ලැබේ. සියලු වත්කම් කවර හෝ පාර්ශවයකට හිමිවිය යුතු ය. එමනිසා වත්කම් ලෙස පෙන්නුම් කරන අගය සහ සමස්ත හිමිකාරිත්වය (හිමිකම + වගකීම්) එකිනෙකට සමාන වේ.\n\nසූත්‍රය: වත්කම් = හිමිකම + වගකීම්  (Assets = Equity + Liabilities)",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 33
      SanduCommercePageItem(
        pageNumber = 33,
        chapterNumber = 9,
        chapterTitleSinhala = "ව්‍යාපාරික ගනුදෙනු, හිමිකම් සහ ගැනිලි",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාරික ගනුදෙනු",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ව්‍යාපාරික ගනුදෙනු (Transactions)",
            definition = "ව්‍යාපාරයක් සහ වෙනත් පාර්ශව අතර සිදුවන සම්පත් හුවමාරු වීම, ගනුදෙනුවක් ලෙස හඳුන්වයි. ගිණුම්කරණයේ දී සලකා බලන්නේ මුදලින් මැනිය හැකි ගනුදෙනු පමණි (උදා: රු. 250,000 කට භාණ්ඩ තොගයක් විකිණීම).",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "අත්පිට ගනුදෙනු vs ණයට සිදුවන ගනුදෙනු",
            bullets = listOf(
              "අත්පිට ගනුදෙනු (Cash Transactions): ගනුදෙනුවේ වටිනාකම ගනුදෙනුව සිදුවන අවස්ථාවේ දී ම මුදලින් බේරුම් කෙරෙන්නේ නම් එය අත්පිට සිදුවන ගනුදෙනුවකි.",
              "ණයට සිදුවන ගනුදෙනු (Credit Transactions): ගනුදෙනුවේ වටිනාකම පසුව බේරුම් කිරීමට එකඟ වන්නේ නම් එය ණයට සිදුවන ගනුදෙනුවකි."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "හිමිකම (Equity)",
            definition = "ව්‍යාපාරයක හිමිකරුවන් වෙනුවෙන් පවතින වත්කම් ප්‍රමාණය හිමිකම ලෙස හැඳින්වේ (ප්‍රාග්ධනය + ආදායම් - වියදම් - ගැනිලි).",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ගැනිලි (Drawings)",
            definition = "ව්‍යාපාරයේ ඇති මුදල් හෝ භාණ්ඩ අයිතිකරුවන් විසින් පෞද්ගලික ප්‍රයෝජනය සඳහා ලබාගැනීම නිසා හිමිකම අඩු වේ. මෙය ගැනිලි ලෙස හඳුන්වයි.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 34
      SanduCommercePageItem(
        pageNumber = 34,
        chapterNumber = 9,
        chapterTitleSinhala = "වත්කම් සහ වගකීම්",
        gradeLevel = "10",
        rootConcept = "වත්කම් සහ වගකීම්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "වත්කම් (Assets)",
            definition = "අතීත ගනුදෙනුවක ප්‍රතිඵලයක් ලෙස ඇතිවන, අනාගතයේ දී ව්‍යාපාරයට ආර්ථික ප්‍රතිලාභ ගලා එන්නා වූ ව්‍යාපාරය විසින් පාලනය කෙරෙන සම්පත් වත්කම් වේ.",
            bullets = listOf(
              "වත්කමක ලක්ෂණ:\n   • අතීත ගනුදෙනුවක ප්‍රතිඵලයක් ලෙස ඇතිවීම.\n   • ව්‍යාපාරයේ පාලනයට යටත් වීම.\n   • අනාගතයේ දී ව්‍යාපාරයට ආර්ථික ප්‍රතිලාභ ගලා ඒම.",
              "ජංගම වත්කම් (Current Assets): සාමාන්‍ය ව්‍යාපාර කටයුතුවලදී මාස 12 ක් වැනි කෙටි කාලයක් තුළ පාවිච්චි කිරීම, විකිණීම හෝ මුදල් බවට පත්වීම සිදුවන්නේ යැයි අපේක්ෂා කෙරෙන වත්කම් (මුදල්, බැංකු ශේෂය, වෙළඳ තොගය, ණයගැතියෝ).",
              "ජංගම නොවන වත්කම් (Non-Current Assets): මාස 12කට වැඩි කාලයක් ව්‍යාපාරයේ රඳවා තබා ගන්නා දිගුකාලීන වත්කම් (ඉඩම්, ගොඩනැගිලි, යන්ත්‍රසූත්‍ර, මෝටර් රථ, උපකරණ)."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "වගකීම් (Liabilities)",
            definition = "අතීත ගනුදෙනුවක හෝ සිදුවීමක ප්‍රතිඵලයක් ලෙස ඇතිවන ව්‍යාපාරය විසින් ගෙවිය යුතු අගය, වගකීම් ලෙස හඳුන්වයි.",
            bullets = listOf(
              "වගකීමක ලක්ෂණ:\n   • අතීත ගනුදෙනුවක ප්‍රතිඵලයක් වීම.\n   • බේරුම් කිරීමේ දී ව්‍යාපාරයේ සම්පත් වලින් කොටසක් පිටතට ගලා යාම.\n   • වර්තමාන බැඳීමක් තිබීම.",
              "ජංගම වගකීම් (Current Liabilities): මාස 12 ක් වැනි කෙටි කාලයක් තුළ බේරුම් කළ යුතු කෙටිකාලීන වගකීම් (ණයහිමියෝ, බැංකු අයිරාව, ගෙවිය යුතු වියදම්).",
              "ජංගම නොවන වගකීම් (Non-Current Liabilities): මාස 12කට වඩා දිගු කාලයක් තුළ බේරුම් කළ යුතු දිගුකාලීන වගකීම් (බැංකු ණය, උකස් ණය, ණයකර)."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 35
      SanduCommercePageItem(
        pageNumber = 35,
        chapterNumber = 10,
        chapterTitleSinhala = "ගිණුම, ද්විත්ව සටහන් න්‍යාය සහ ලෙජරය",
        gradeLevel = "10",
        rootConcept = "ගිණුම (Account)",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ගිණුම (Account)",
            definition = "ව්‍යාපාරයක ගනුදෙනුවලට අදාල ද්විත්ව බලපෑමේ ස්වරූපය නිවැරදිව හර (Debit) සහ බැර (Credit) වශයෙන් සටහන් කිරීමට යොදාගන්නා ආකෘතිය ගිණුම ලෙස හැඳින්වේ. සම්ප්‍රදායික ගිණුමක ආකෘතියට ඉංග්‍රීසි T හැඩය ගනී.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාර ගනුදෙනු නිසා බිහිවන ගිණුම් වර්ග 5",
            bullets = listOf(
              "1. වත්කම් ගිණුම් (Asset A/C)",
              "2. හිමිකම් ගිණුම් (Equity A/C)",
              "3. වගකීම් ගිණුම් (Liability A/C)",
              "4. ආදායම් ගිණුම් (Income A/C)",
              "5. වියදම් ගිණුම් (Expense A/C)"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ද්විත්ව සටහන් න්‍යාය (Double Entry System)",
            definition = "හර වටිනාකමට සමාන බැර වටිනාකමක් ඇති කෙරෙන පරිදි සෑම ගනුදෙනුවක ම ගිණුම් දෙකක එකවර සටහන් කෙරෙන පරිදි ගිණුම් තැබීමේ ක්‍රමය, ද්විත්ව සටහන් න්‍යාය ලෙස හැඳින්වේ. මේ පිළිබඳ මුලින්ම අදහස් ඉදිරිපත් කළේ ක්‍රි.ව. 1494 දී ලුකා පැසියෝලි (Luca Pacioli) නම් ඉතාලි ජාතික ගණිතඥයෙකු (පියතුමෙකු) විසිනි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ලෙජරය (Ledger)",
            definition = "ගිණුම් ඇතුළත් කිරීම සඳහා ව්‍යාපාරයක භාවිතා කරන ප්‍රධාන පොත, ලෙජරය යි. ලෙජරය යනු ගිණුම් රාශියක් ඒකරාශී වූ ස්ථානයක් ලෙස ද මූල්‍ය තොරතුරු රැස්කොට ඇති ස්ථානයක් ලෙස ද හැඳින්වේ. පරිගණක ආශ්‍රයෙන් ගිණුම් තබන විටක මූලික ගිණුම් පවත්වාගෙන යනු ලබන ලිපි ගොනුව ප්‍රධාන ලෙජරය (General Ledger) ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 36
      SanduCommercePageItem(
        pageNumber = 36,
        chapterNumber = 10,
        chapterTitleSinhala = "ගිණුම් තුලනය කිරීම සහ මූලාශ්‍ර ලේඛන",
        gradeLevel = "10",
        rootConcept = "ගිණුම් තුලනය සහ මූලාශ්‍ර",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ගිණුම්වල ගනුදෙනු සටහන් කිරීම හා තුලනය කිරීම",
            definition = "ගිණුමක ශේෂය ලබා ගැනීමට කටයුතු කිරීම ගිණුම් තුලනය කිරීම යි. යම් නිශ්චිත කාලසීමාවක් අවසානයේ දී ගිණුමක හර සහ බැර සටහන් වී ඇති වටිනාකම්වල වෙනස හෙවත් ශුද්ධ අගය ගිණුමක ශේෂය (Balance) යි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "මූලාශ්‍ර ලේඛන (Source Documents) සහ මූලික පොත්",
            definition = "ව්‍යාපාරයක එදිනෙදා ගනුදෙනු සිදුවීමේදී ඒ හා සම්බන්ධ විවිධ මූලාශ්‍ර ලේඛන බිහි වේ. එකී මූලාශ්‍ර ලේඛන පදනම් කොටගෙන ප්‍රථම වරට ගනුදෙනු සටහන් කරන පොත් මූලික සටහන් පොත් ය. ලෙජර් ගිණුම්වල සටහන් කිරීමට ප්‍රථමයෙන් ගනුදෙනු සිදු වූ අනුපිළිවෙල අනුව පළමුවෙන්ම සටහන් කරනු ලැබේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ලදුපත (Receipt) සහ ගෙවීම් වවුචරය (Payment Voucher)",
            bullets = listOf(
              "ලදුපත: ව්‍යාපාරයකට යම් මුදලක් ලැබුණු විට එම ලැබීම සනාථ කරමින් ව්‍යාපාර විසින් මුදල් ගෙවූ පාර්ශවය වෙත නිකුත් කෙරෙන කුවිතාන්සිය ලදුපත යි.",
              "ගෙවීම් වවුචරය: ව්‍යාපාර විසින් සෑම මුදල් ගෙවීමකදී ම ඊට අදාළ තොරතුරු ඇතුළත් කර වගකිව යුතු පුද්ගලයකු විසින් අත්සන් කර, ගෙවීම සනාථ කිරීම සඳහා පිළියෙල කරන ලියවිල්ල ගෙවීම් වවුචරය වේ."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 37
      SanduCommercePageItem(
        pageNumber = 37,
        chapterNumber = 11,
        chapterTitleSinhala = "මූලික සටහන් පොත් (Books of Prime Entry)",
        gradeLevel = "10",
        rootConcept = "මූලික සටහන් පොත්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "මූලික සටහන් පොත් පවත්වා ගැනීමේ ප්‍රයෝජන 5",
            bullets = listOf(
              "ගනුදෙනු එකවරම ලෙජරයේ ගිණුම්වල ලිවීමේදී සිදුවන වැරදි මඟහරවා ගත හැකි වීම.",
              "ගනුදෙනු සාරාංශ ගත කර වැදගත් කරුණු පමණක් ගිණුම්වලට ගෙනයාමට හැකි වීම.",
              "ගිණුම්කරණ ක්‍රියාවලියට ගත වන කාලය අඩු කර ගත හැකි වීම.",
              "ගිණුමක ඇති තොරතුරු වැරදි අවස්ථාවකදී ඒ පිළිබඳ විස්තරාත්මකව නිවැරදි තොරතුරු ජර්නල්වලින් ලබාගත හැකි වීම.",
              "ජර්නල් කිහිපයක් තිබීම නිසා ගිණුම් තැබීමට අදාළ කාර්යයන් පුද්ගලයින් කිහිප දෙනෙකු අතර බෙදාහැරීමට හැකි වීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        ),
        comparisonTable = SanduCommerceTable(
          title = "මූලික සටහන් පොත් හා එහි භාවිතා වන ගනුදෙනු වර්ග",
          col1Header = "මූලික සටහන් පොත",
          col2Header = "සටහන් කරන ගනුදෙනු වර්ගය",
          rows = listOf(
            Pair("මුදල් පොත", "මුදල් ලැබීම් හා ගෙවීම් සම්බන්ධ ගනුදෙනු සටහන් කිරීම"),
            Pair("සුළු මුදල් පොත", "දෛනික සුළු වියදම් සටහන් කිරීම"),
            Pair("ගැනුම් ජර්නලය / පොත", "නැවත විකිණීමට ණයට ගන්නා භාණ්ඩ සටහන් කිරීම"),
            Pair("විකුණුම් ජර්නලය / පොත", "ණයට විකුණූ වෙළඳ භාණ්ඩ සටහන් කිරීම"),
            Pair("බැංකු ගිණුම", "බැංකු ජංගම ගිණුම් මඟින් කරන ගනුදෙනු සටහන් කිරීම"),
            Pair("පොදු ජර්නලය", "අනෙකුත් විශේෂිත නොවන සියලුම ගනුදෙනු සටහන් කිරීම")
          )
        )
      ),

      // PAGE 38
      SanduCommercePageItem(
        pageNumber = 38,
        chapterNumber = 11,
        chapterTitleSinhala = "මූලාශ්‍ර ලේඛන (ප්‍රභව ලිපි / උපයෝගී ලිපි)",
        gradeLevel = "10",
        rootConcept = "මූලාශ්‍ර ලේඛන",
        pageSections = listOf(
          SanduCommerceSection(
            title = "මූලාශ්‍ර ලේඛන යනු මොනවාද?",
            definition = "ගනුදෙනු හා සිද්ධීන් උපයෝගී පොත්වල සටහන් කිරීම සඳහා තොරතුරු ලබාගන්නා ලියවිලි හා ප්‍රකාශන මූලාශ්‍ර ලේඛන (Source Documents) ලෙස හැඳින්වේ. වගකිව යුතු නිලධාරියෙකු විසින් අත්සන් කර සකස් කරයි (උදා: ලදුපත, ගෙවීම් වවුචරය, ඉන්වොයිස්).",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "මූලාශ්‍ර ලේඛනයක තිබිය යුතු මූලික තොරතුරු",
            bullets = listOf(
              "ව්‍යාපාරයේ නම හා ලිපිනය",
              "අනුක්‍රමික අංකය (Serial number)",
              "ගනුදෙනුව සිදු වූ දිනය",
              "ගනුදෙනුවට සම්බන්ධ පාර්ශවයන්ගේ නම් හා ලිපිනයන්",
              "ගනුදෙනුවේ විස්තර",
              "මුළු වටිනාකම",
              "නිල මුද්‍රාව හා අත්සන්"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "මූලාශ්‍ර ලේඛන පවත්වාගෙන යාමේ ප්‍රයෝජන",
            bullets = listOf(
              "ගනුදෙනුවට අදාළ ආරම්භක ලියවිල්ල ලෙස යොදාගත හැකි වීම.",
              "ගනුදෙනුව සනාථ කිරීම සඳහා ලිඛිත සාක්ෂියක් ලෙස භාවිත කළ හැකි වීම.",
              "ගනුදෙනුව පිළිබඳ අතිරේක විස්තර ලබාගත හැකි වීම.",
              "මූලික සටහන් පොත්වල ලිවීමේදී යොදා ගත හැකි වීම.",
              "වගකීම් නිශ්චිතව පැවරිය හැකි වීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        ),
        comparisonTable = SanduCommerceTable(
          title = "මූලික සටහන් පොත්වලට අදාළ මූලාශ්‍ර ලේඛන",
          col1Header = "මූලික සටහන් පොත",
          col2Header = "යොදාගන්නා මූලාශ්‍ර ලේඛනය",
          rows = listOf(
            Pair("මුදල් පොත", "ලදුපත්, ගෙවීම් වවුචර"),
            Pair("සුළු මුදල් පොත", "සුළු මුදල් ගෙවීම් වවුචර"),
            Pair("බැංකු ගිණුම", "පිළිපත, බැංකු බැර පත, බැංකු ප්‍රකාශන"),
            Pair("ගැනුම් ජර්නලය", "ගැනුම් ඉන්වොයිසිය"),
            Pair("විකුණුම් ජර්නලය", "විකුණුම් ඉන්වොයිසිය"),
            Pair("පොදු ජර්නලය", "ජර්නල් වවුචර")
          )
        )
      ),

      // PAGE 39
      SanduCommercePageItem(
        pageNumber = 39,
        chapterNumber = 12,
        chapterTitleSinhala = "මුදල් පොත (Cash Book)",
        gradeLevel = "10",
        rootConcept = "මුදල් පොත",
        pageSections = listOf(
          SanduCommerceSection(
            title = "මුදල් පොත හැඳින්වීම සහ කාර්යයන්",
            definition = "ව්‍යාපාරයක නිශ්චිත කාලච්ඡේදයක් තුළ සිදු වූ සියලු මුදල් ලැබීම් හා මුදල් ගෙවීම්වලට අදාළ ගනුදෙනු සටහන් කරන මූලික පොත, මුදල් පොත වේ.",
            bullets = listOf(
              "මුදල් පොතකින් සිදුවන කාර්යයන් 2:\n   • ලෙජරයේ ගිණුමක් ලෙස ක්‍රියා කිරීම (මුදල් ගිණුම වෙනුවට)\n   • මූලික සටහන් පොතක් ලෙස ක්‍රියා කිරීම",
              "මුදල් ශේෂය: විවිධ මාර්ග වලින් ලැබෙන මුදල් හා විවිධ කටයුතු සඳහා මුදල් වැය කිරීමෙන් අනතුරුව ඉතිරි වන මුදල් ප්‍රමාණයයි."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "මුදල් ලැබීම් ලෙස සටහන් කරන ගනුදෙනු (හර පැත්ත)",
            bullets = listOf(
              "ප්‍රාග්ධනය ලෙස මුදල් යෙදවීම",
              "අත්පිට විකුණුම් වශයෙන් ලැබෙන මුදල්",
              "බැංකු ණය ලබා ගැනීම",
              "ණයගැතියන්ගෙන් මුදල් ලැබීම්",
              "ගෙවල් කුලී / පොලී / කොමිස් ආදී ලැබීම්",
              "ස්ථාවර වත්කම් විකිණීමෙන් ලද මුදල්"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "මුදල් ගෙවීම් ලෙස සටහන් කරන ගනුදෙනු (බැර පැත්ත)",
            bullets = listOf(
              "අත්පිට ගැනුම්",
              "ණයහිමියන්ට ගෙවීම්",
              "ණය ආපසු ගෙවීම් සහ බැංකු ණය වාරික ගෙවීම්",
              "ගෙවල් කුලී / විදුලිය බිල් / සේවක වැටුප් ගෙවීම්",
              "ලී බඩු ආදී ස්ථාවර වත්කම් මිලට ගැනීම්",
              "අයිතිකරුගේ මුදල් ගැනිලි"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 40
      SanduCommercePageItem(
        pageNumber = 40,
        chapterNumber = 12,
        chapterTitleSinhala = "මුදල් පොතේ සටහන් නොවන ගනුදෙනු සහ වට්ටම්",
        gradeLevel = "10",
        rootConcept = "මුදල් පොත සහ වට්ටම්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "මුදල් පොතේ සටහන් නොකරන ගනුදෙනු",
            bullets = listOf(
              "වෙළඳ භාණ්ඩ ණයට ගැනීම",
              "වත්කම් ණයට ගැනීම",
              "භාණ්ඩ ආපසු හරවා යැවීම (පිටතට ආපසු)",
              "භාණ්ඩ ආපසු හරවා එවීම (ඇතුළතට ආපසු)",
              "තක්සේරුව තුළින් වත්කම්වල අගය වැඩිවීම හෝ අඩුවීම",
              "වත්කම්වල හෝ වගකීම්වල අගය කපා හැරීම (බොල් ණය)"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "වට්ටම් (Discounts)",
            definition = "වෙළඳ ගනුදෙනුවක දී කිසියම් වටිනාකමකින් අඩු කරනු ලබන අගය වට්ටම යි. විකුණුම්කරුවන් තම අලෙවිය වැඩි කර ගැනීමටත්, ණය හිමියන් තම ණය මුදල් ඉක්මනින් ලබා ගැනීමටත් වට්ටම් ලබා දේ.",
            bullets = listOf(
              "වෙළඳ වට්ටම (Trade Discount): භාණ්ඩයක් විකුණන අවස්ථාවේ දී එම භාණ්ඩයේ ලකුණු කළ මිලෙන් ගැනුම්කරුට කෙරෙන අඩු කිරීම යි. ඉන්වොයිසියේ අඩු කර ශුද්ධ අගය පමණක් ලියන බැවින් ගිණුම් පොත්වල සටහන් නොවේ!",
              "මුදල් වට්ටම (Cash Discount): ණය කාලසීමාවට පෙර මුදල් ගෙවීමේදී දෙනු ලබන වට්ටමයි. ගිණුම්කරණයේ දී සටහන් කරනු ලබන්නේ මුදල් වට්ටම පමණි."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "මුදල් වට්ටමේ ප්‍රභේද 2",
            bullets = listOf(
              "දුන් වට්ටම් (Discounts Allowed / Given): ණයගැතියන් විසින් ණය කාල සීමාවට පෙර මුදල් ගෙවීමේ දී ඔවුන්ට ලබා දෙන වට්ටමයි. මෙය ව්‍යාපාරයේ වියදමකි (හර වේ).",
              "ලද වට්ටම් (Discounts Received): ණය හිමියන්ට ණය කාල සීමාවට පෙර මුදල් ගෙවීමේ දී ඔවුන් ලබා දෙන වට්ටමයි. මෙය ව්‍යාපාරයේ ආදායමකි (බැර වේ)."
            ),
            type = SanduCommerceSectionType.COMPARISON
          )
        )
      ),

      // PAGE 41
      SanduCommercePageItem(
        pageNumber = 41,
        chapterNumber = 13,
        chapterTitleSinhala = "සුළු මුදල් පොත, අග්‍රිමය සහ ප්‍රතිපූරණය",
        gradeLevel = "10",
        rootConcept = "සුළු මුදල් පොත",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සුළු මුදල් පොත (Petty Cash Book)",
            definition = "ව්‍යාපාරයක නිතර නිතර සිදුවන සුළු වටිනාකම් සහිත වියදම් ගෙවීම පිළිබඳව සටහන් කරනු ලබන මූලික පොත සුළු මුදල් පොත යි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සුළු මුදල් පොතෙන් ව්‍යාපාරිකයෙකුට ලැබෙන ප්‍රයෝජන 4",
            bullets = listOf(
              "එදිනෙදා සිදුවන සුළු වියදම් සටහන් කිරීමට වෙනමම මුදල් භාරකරුවෙකු පත්කර ගැනීම නිසා ප්‍රධාන මුදල් භාරකරුගේ කාර්යය ලිහිල් වීම.",
              "මුදල් කටයුතු පිළිබඳ වගකීම දෙදෙනෙකු වෙත පැවරීම නිසා එම වියදම් පිළිබඳව පාලනයක් ඇති වීම.",
              "දිනපතා සිදුවන ගනුදෙනු දෛනිකව ලෙජරයේ පිටපත් කිරීමෙන් ගිණුම්වල ඇතිවන අනවශ්‍ය දීර්ඝ වීම් වළක්වා වියදම් එකතු කර එක් සටහනක් ලෙස ලෙජරයට ගෙන යාමේ පහසුව.",
              "විශ්ලේෂණ තීරු සහිත සුළු මුදල් පොතක් සමඟ එක් එක් වියදම්වල එකතුව පහසුවෙන් බලා ගත හැකිවීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "සුළු මුදල් අග්‍රිමය සහ ප්‍රතිපූරණය (Imprest & Reimbursement)",
            bullets = listOf(
              "සුළු මුදල් අග්‍රිමය (Petty Cash Imprest): කිසියම් කාලපරිච්ඡේදයක් තුළ ආයතනයේ සුළු වියදම් වෙනුවෙන් ගෙවීම් කිරීම සඳහා ප්‍රධාන මුදල් භාරකරු සුළු මුදල් භාරකරුට ලබාදෙන නිශ්චිත මුදල් ප්‍රමාණය සුළු මුදල් අග්‍රිමය ලෙස හඳුන්වයි.",
              "සුළු මුදල් ප්‍රතිපූරණය (Reimbursement): අදාළ කාලපරිච්ඡේදය අවසානයේ දී ගෙවීම් සඳහා තමා යොදාගත් මුදල් ප්‍රමාණයට සමාන මුදලක් සුළු මුදල් භාරකරුට ප්‍රධාන මුදල් භාරකරුගෙන් ලබා ගනී. මෙසේ සුළු වියදම් සඳහා ගෙවීම් කළ මුළු මුදල් ප්‍රමාණයට සමාන මුදලක් මෙසේ ආපසු ලබා ගැනීම ප්‍රතිපූරණය ලෙස හැඳින්වේ."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 42
      SanduCommercePageItem(
        pageNumber = 42,
        chapterNumber = 14,
        chapterTitleSinhala = "සුළු මුදල් අග්‍රිම ක්‍රමය සහ බැංකු ප්‍රකාශනය",
        gradeLevel = "10",
        rootConcept = "අග්‍රිම ක්‍රමය සහ බැංකු ප්‍රකාශනය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සුළු මුදල් අග්‍රිම ක්‍රමය",
            definition = "සුළු මුදල් භාරකරුට සුළු මුදල් අග්‍රිමයක් ලබාදීමත් ඔහුට ලබාදුන් ඒ අග්‍රිමයෙන් ඔහු වියදම් කළ මුදලට සමාන මුදලක් ප්‍රතිපූරණය කිරීමේ ක්‍රමය සුළු මුදල් අග්‍රිම ක්‍රමය ලෙස හැඳින්වේ.",
            bullets = listOf(
              "අග්‍රිමයේ වටිනාකම තීරණය කිරීමේදී සලකා බලන කරුණු:\n   • දිනපතා දැරීමට සිදුවන සුළු වියදම් සංඛ්‍යාව සහ ප්‍රමාණය\n   • ව්‍යාපාරයේ මුළු මුදල් ගනුදෙනු සංඛ්‍යාව හා ඒවායේ වටිනාකම\n   • ප්‍රධාන මුදල් භාරකරුගේ කාර්ය බහුලතාවය\n   • සුළු මුදල් අග්‍රිමය යොදා ගැනෙන කාලපරිච්ඡේදය"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "බැංකු ප්‍රකාශනය (Bank Statement)",
            definition = "වාණිජ බැංකුවල ජංගම ගිණුම් හිමියන්ට අදාළ වාණිජ බැංකු ගිණුමේ සිදු වූ ගනුදෙනු පිළිබඳ තොරතුරු ඇතුළත් කරමින් බැංකුව විසින් නිශ්චිත කාලයකට වරක් (සාමාන්‍යයෙන් මාසයකට) එවනු ලබන ප්‍රකාශය යි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "බැංකු ප්‍රකාශනයේ ඇති වැදගත්කම 4",
            bullets = listOf(
              "මාසයේ ආරම්භයේ සහ අවසානයේ ඇති බැංකු ජංගම ගිණුම් ශේෂය දැනගත හැකිය.",
              "මාසය තුළ දී තැන්පත් කළ හා නිකුත් කළ චෙක්පත්වල වටිනාකම දැනගත හැකිය.",
              "සෘජු ප්‍රේෂණ ලැබීම් හා ස්ථාවර නියෝග මත කරන ලද ගෙවීම් දැනගත හැකි වීම.",
              "නිකුත් කළ මුත් හර නොවූ චෙක්පත් හා තැන්පත් කළ මුත් නිෂ්කාශණය නොවූ චෙක්පත් පිළිබඳව දැනගත හැකිය."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 43
      SanduCommercePageItem(
        pageNumber = 43,
        chapterNumber = 14,
        chapterTitleSinhala = "බැංකු සැසඳුම් ප්‍රකාශනය පිළියෙළ කිරීම",
        gradeLevel = "10",
        rootConcept = "බැංකු සැසඳුම් ප්‍රකාශනය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "බැංකු සැසඳුම් ප්‍රකාශනය පිළියෙළ කිරීමේ පියවර 4",
            bullets = listOf(
              "පියවර 01: බැංකු ගිණුමේ අවසාන බැංකු තීරුවේ ශේෂය හා බැංකු ප්‍රකාශනයේ සඳහන්ව ඇති අවසාන ශේෂය සමානව පවතී ද යන්න සොයා බැලීම.",
              "පියවර 02: එම ශේෂයන් අසමාන නම් බැංකු ගිණුමේ හර තීරුව සමඟ බැංකු ප්‍රකාශනයේ බැර තීරුව ද, බැංකු ගිණුමේ බැර තීරුව සමඟ බැංකු ප්‍රකාශනයේ හර තීරුව ද සසඳා වෙනසට හේතු අනාවරණය කර ගැනීම.",
              "පියවර 03: වෙනසට බලපෑ හේතුවලින් බැංකු ගිණුමේ සටහන් නොවී ඇති ගනුදෙනු තෝරාගෙන බැංකු ගිණුමේ බැංකු ශේෂය සංශෝධනය කිරීම (සංශෝධිත බැංකු ගිණුම).",
              "පියවර 04: බැංකු ගිණුමේ සංශෝධිත බැංකු ශේෂය යොදා ගනිමින් බැංකු සැසඳුම් ප්‍රකාශනය පිළියෙළ කිරීම."
            ),
            type = SanduCommerceSectionType.PROCESS_STEPS
          ),
          SanduCommerceSection(
            title = "බැංකු ගිණුමේ ශේෂය හා බැංකු ප්‍රකාශනයේ ශේෂය අසමාන වීමට හේතු",
            bullets = listOf(
              "තැන්පත් කළ නමුත් නිෂ්කාශනය නොවූ (උපලබ්ධි නොවූ) චෙක්පත්",
              "නිකුත් කර ඇති හර නොවූ (ඉදිරිපත් නොවූ) චෙක්පත්",
              "ස්ථාවර නියෝග අනුව බැංකුව කර ඇති ගෙවීම්",
              "සෘජු ප්‍රේෂණ (ගනුදෙනුකරුවන් සෘජුවම බැංකුවට තැන්පත් කළ මුදල්)",
              "බැංකු ගාස්තු හා පොලී අය කිරීම්",
              "මුදල් පොතේ සටහන් නොවූ අගරු වූ චෙක්පත්"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "බැංකු ගිණුමේ පමණක් සටහන් වී ඇති ගනුදෙනු 2",
            bullets = listOf(
              "නිකුත් කළ නමුත් ඉදිරිපත් නොවූ චෙක්පත්",
              "තැන්පත් කළ නමුත් නිෂ්කාශනය නොවූ චෙක්පත්"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 44
      SanduCommercePageItem(
        pageNumber = 44,
        chapterNumber = 14,
        chapterTitleSinhala = "බැංකු ප්‍රකාශන කරුණු, ජර්නල සහ සංලක්ෂ්‍යය",
        gradeLevel = "10",
        rootConcept = "බැංකු ප්‍රකාශනය සහ ජර්නල",
        pageSections = listOf(
          SanduCommerceSection(
            title = "බැංකු ප්‍රකාශනයේ පමණක් සටහන් වී ඇති කරුණු 5",
            bullets = listOf(
              "ණයගැතියන්ගේ සෘජු තැන්පතු (Direct Deposits)",
              "බැංකුව විසින් රැස්කර ඇති විවිධ පොලී ආදායම් සහ ලාභාංශ",
              "ස්ථාවර නියෝග මත බැංකුව කළ ගෙවීම් (Standing Orders)",
              "බැංකුව විසින් අයකරගෙන ඇති පොලී සහ බැංකු ගාස්තු (Bank Charges)",
              "අගරු වී ඇති චෙක්පත් (Dishonoured Cheques)"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ගැනුම්, විකුණුම් සහ පොදු ජර්නලය",
            bullets = listOf(
              "ගැනුම් ජර්නලය: ව්‍යාපාරයක් නැවත විකිණීමේ පරමාර්ථයෙන් ණයට ගත් භාණ්ඩ සම්බන්ධයෙන් තොරතුරු සටහන් කරන මූලික පොතයි (මූලාශ්‍රය: ගැනුම් ඉන්වොයිසිය).",
              "විකුණුම් ජර්නලය: නැවත විකිණීමේ අරමුණින් මිලට ගත් භාණ්ඩ ණයට විකිණීමේ දී ඊට අදාල ගනුදෙනු සටහන් කරන මූලික පොතයි (මූලාශ්‍රය: විකුණුම් ඉන්වොයිසිය).",
              "පොදු ජර්නලය: ව්‍යාපාරයක සිදුවන ගනුදෙනු සුවිශේෂී වූ මූලික පොත්වල සටහන් කරන අතර, එවැනි සුවිශේෂී මූලික පොත් නොමැති ගනුදෙනු සටහන් කිරීමට පොදු ජර්නලය යොදාගනී."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ගිණුම්කරණයේ දී සංලක්ෂ්‍යය (Narration)",
            definition = "පොදු ජර්නලයේ දී සටහන් කරනු ලබන සෑම ගනුදෙනුවකට ම අදාළ කෙටි විස්තරයක් (ද්විත්ව සටහන් සමග) ලියනු ලබන අතර එය සංලක්ෂ්‍යය ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 45
      SanduCommercePageItem(
        pageNumber = 45,
        chapterNumber = 15,
        chapterTitleSinhala = "පොදු ජර්නලය සහ පරිගණක ආශ්‍රිත ගිණුම්කරණය",
        gradeLevel = "10",
        rootConcept = "පොදු ජර්නලය සහ IT",
        pageSections = listOf(
          SanduCommerceSection(
            title = "පොදු ජර්නලයේ සටහන් කරන ගනුදෙනු",
            bullets = listOf(
              "ගැලපුම් සටහන් (Adjusting Entries): කාලච්ඡේදයට අදාළ ගනුදෙනු ලෙජර් ගිණුම්වල සටහන් වී නොමැති විට එම ගනුදෙනු සටහන් කිරීම මෙන්ම ගිණුම් කාලච්ඡේදයට අදාලව ගැලපීමට අදාල සටහන් ය.",
              "වැරදි නිවැරදි කිරීමේ සටහන් (Correction of Errors): මූලික පොත්වලත්, ලෙජර් ගිණුම්වලත් ගනුදෙනු දැක්වීමේ දී වැරදි සිදුවිය හැකිය. ඊට අදාල නිවැරදි කිරීමේ සටහන් තබන්නේ පොදු ජර්නලයේ ය."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "පරිගණක ආශ්‍රිත ගිණුම්කරණයේ වාසි 5",
            bullets = listOf(
              "ඉක්මණින් ගනුදෙනු ගිණුම්ගත කිරීමට හා අවශ්‍ය ගිණුම් වාර්තා පිළියෙල කරගැනීමට හැකි වීම නිසා කාලය ඉතිරි වීම.",
              "අවශ්‍ය ශ්‍රමය අවම වීම තුළින් මුදල් ඉතිරි වීම.",
              "ස්වයංක්‍රීයව නිමවන ගිණුම් වාර්තාවල නිරවද්‍යතාව ඉහළ වීම.",
              "කාලීන දත්ත පහසුවෙන් ලබාගත හැකි වීම.",
              "දත්ත යාවත්කාලීන කිරීම පහසුවෙන් කළ හැකි වීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "පරිගණක ආශ්‍රිත ගිණුම්කරණයේ අවාසි 4",
            bullets = listOf(
              "විදුලිය ඇණහිටීම, පරිගණක හා අනෙකුත් තාක්ෂණික දෝෂ නිසා දත්ත නැතිවී විනාශ වීමේ අවදානම.",
              "පරිගණක දත්ත සොරකම් කිරීමේ හා අනවසරයෙන් වෙනස් කිරීමේ අවදානමක් තිබීම (Hacking / Virus).",
              "අවශ්‍ය පරිගණක මෘදුකාංගය මිලදී ගැනීම සඳහා විශාල මුදලක් ගෙවිය යුතු වීම.",
              "පරිගණක මෘදුකාංග ඉක්මනින් වෙනස් වීම හා ඒවා නිතර යාවත්කාලීන කිරීමට සිදුවීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 46
      SanduCommercePageItem(
        pageNumber = 46,
        chapterNumber = 16,
        chapterTitleSinhala = "ශේෂ පිරික්සුම සහ ගිණුම්කරණ වැරදි",
        gradeLevel = "10",
        rootConcept = "ශේෂ පිරික්සුම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ශේෂ පිරික්සුම (Trial Balance)",
            definition = "තෝරාගත් කිසියම් කාලපරිච්ඡේදයක් තුළ කරන ලද හර සටහන්වල එකතුව ඒ කාලය තුළ කරන ලද බැර සටහන්වල එකතුවට සමාන බව දැනගැනීම සඳහා එම කාලපරිච්ඡේදය අවසානයේ දී පැවති ගිණුම්වල ශේෂ උපයෝගී කරගනිමින් සකස් කරන ලේඛනය ශේෂ පිරික්සුම ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ගිණුම්කරණ වැරදි සිදුවිය හැකි අවස්ථා 4",
            bullets = listOf(
              "මූලික සටහන් පොත්වල ගනුදෙනු සටහන් කිරීමේදී",
              "මූලික සටහන් පොත්වලින් ගනුදෙනු ලෙජරයට පිටපත් කිරීමේදී",
              "ලෙජර් ගිණුම් තුලනය කිරීමේදී",
              "ශේෂ පිරික්සුම සකස් කිරීමේදී"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ගිණුම්කරණ වැරදි සිදුවීමට බලපාන හේතු සහ පාලනය",
            bullets = listOf(
              "හේතු:\n   • ගනුදෙනු සටහන් කරන්නාට ගිණුම්කරණ ක්‍රියාවලිය පිළිබඳ නිසි අවබෝධයක් නොමැතිකම\n   • සේවකයින්ගේ නොසැලකිලිමත් බව, අමතක වීම් සහ මගහැරීම්\n   • සිතාමතාම වංචනික කටයුතු සිදුකිරීමේ අරමුණින් ගිණුම් සටහන් වෙනස් කිරීම",
              "පාලනයට පියවර:\n   • පොත් තැබීමේ කාර්යය සඳහා සුදුසුකම් හා පළපුරුද්ද ඇති සේවකයින් යෙදවීම\n   • ගිණුම් කටයුතු මනා ලෙස අභ්‍යන්තර පාලනයකට යටත් කිරීම\n   • වරින්වර ගිණුම් පරීක්ෂා කිරීම හා විගණනය කිරීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 47
      SanduCommercePageItem(
        pageNumber = 47,
        chapterNumber = 16,
        chapterTitleSinhala = "අවිනිශ්චිත ගිණුම සහ වැරදි වර්ගීකරණය",
        gradeLevel = "10",
        rootConcept = "අවිනිශ්චිත ගිණුම & දෝෂ",
        pageSections = listOf(
          SanduCommerceSection(
            title = "අවිනිශ්චිත ගිණුම (Suspense Account)",
            definition = "ශේෂ පිරික්සුමේ හර ශේෂ එකතුව සහ බැර ශේෂ එකතුව අතර වෙනසක් ඇති විටෙක, ඊට හේතු වූ ගිණුම්කරණ වැරදි සොයා ඒවා නිවැරදි කරන තෙක් ශේෂ පිරික්සුමේ වෙනස තාවකාලිකව සටහන් කරන ගිණුම අවිනිශ්චිත ගිණුම වශයෙන් හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ශේෂ පිරික්සුමේ සමානත්වයට බලනොපාන වැරදි 4 (ගැටලුවකින් තොරව තුලනය වන)",
            bullets = listOf(
              "ගනුදෙනුවක් සම්පූර්ණයෙන්ම පොත්වලින් මගහැරීම (Error of Omission)",
              "ගනුදෙනුවක වටිනාකම මූලික පොත්වල වැරදියට සටහන් වීම (Error of Original Entry)",
              "එකම ගනුදෙනුව ගිණුම් පොත්වල දෙවරක් සටහන් වීම (Error of Duplication)",
              "ගනුදෙනුවක වටිනාකම නියමිත ගිණුමේ සටහන් නොකර වෙනත් ගිණුමක සටහන් වීම (Error of Commission / Principle)"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ශේෂ පිරික්සුමේ සමානත්වයට බලපෑම් ඇතිකරන වැරදි 5 (අසමාන වන)",
            bullets = listOf(
              "ගනුදෙනුවක ද්විත්ව සටහනෙන් එක් සටහනක් පමණක් ඇතුළත් වීම.",
              "ගනුදෙනුවක ද්විත්ව සටහනෙන් එක් සටහනක් නිවැරදිව සටහන් කර අනෙක් සටහන සඳහා වැරදි සංඛ්‍යාවක් සටහන් කිරීම.",
              "ගනුදෙනුවේ ද්විත්ව සටහන් අදාල ගිණුම්වල එකම පැත්තේ සටහන් කිරීම (හර දෙකක් හෝ බැර දෙකක්).",
              "ලෙජර් ගිණුම් තුලනය කිරීමේදී සිදුවන වැරදි (එකතු කිරීමේ හෝ ශේෂය ඉදිරියට ගෙන යාමේ).",
              "ශේෂ පිරික්සුම පිළියෙල කිරීමේදී සිදුවන වැරදි (ශේෂයක් අත්හැරීම හෝ වැරදි තීරුවක දැක්වීම)."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 48
      SanduCommercePageItem(
        pageNumber = 48,
        chapterNumber = 17,
        chapterTitleSinhala = "වෙළඳාම (දේශීය සහ විදේශීය වෙළඳාම)",
        gradeLevel = "11",
        rootConcept = "වෙළඳාම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "වෙළඳාම යනු කුමක්ද?",
            definition = "භාණ්ඩ හා සේවා මිලට ගැනීම හා විකිණීම වෙළඳාම යි. වෙළඳාමේ දී භාණ්ඩයක හිමිකම එක් පාර්ශවයකින් තවත් පාර්ශවයකට කිසියම් මූල්‍යමය වටිනාකමක් මත මාරුවීමක් සිදුවේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "දේශීය සහ විදේශීය වෙළඳාම",
            bullets = listOf(
              "දේශීය වෙළඳාම (Home Trade): රටක් ඇතුළත විවිධ පාර්ශව අතර සිදුවන වෙළඳාම, දේශීය වෙළඳාම යි. මෙය තොග වෙළඳාම සහ සිල්ලර වෙළඳාම ලෙස ආකාර දෙකකි.",
              "විදේශීය වෙළඳාම (Foreign Trade): රටවල් දෙකක් හෝ කීපයක් අතර සිදුවන වෙළඳාම විදේශීය වෙළඳාම වේ. සෑම රටක්ම සියලු භාණ්ඩවලින් ස්වයංපෝෂිත නොවීම නිසා විදේශ වෙළඳාම අත්‍යවශ්‍ය වේ."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "විදේශීය වෙළඳාමේ ප්‍රභේද 2",
            bullets = listOf(
              "1. ආනයන වෙළඳාම (Import Trade): රටක් විදේශීය රටකින් හෝ රටවලින් භාණ්ඩ තම රටට ගෙන්වීම ආනයන වෙළඳාමයි (උදා: මැද පෙරදිග රටවලින් ඛනිජ තෙල් මිලදී ගැනීම).",
              "2. අපනයන වෙළඳාම (Export Trade): රටක් විදේශ රටකට හෝ රටවලට දේශීය නිෂ්පාදිත විකිණීම අපනයන වෙළඳාම වේ (උදා: ශ්‍රී ලාංකික තේ නිෂ්පාදිත යුරෝපීය රටවලට විකිණීම)."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සිල්ලර වෙළඳාම (Retail Trade)",
            definition = "අවසාන පරිභෝජනය සඳහා භාණ්ඩ හා සේවා විකිණීම, සිල්ලර වෙළඳාමයි. සිල්ලර වෙළඳ කටයුතුවල යෙදෙන්නා සිල්ලර වෙළෙන්දා ය.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 49
      SanduCommercePageItem(
        pageNumber = 49,
        chapterNumber = 17,
        chapterTitleSinhala = "සිල්ලර වෙළඳාම සහ වර්ගීකරණය",
        gradeLevel = "11",
        rootConcept = "සිල්ලර වෙළඳාම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සිල්ලර වෙළඳාමේ ලක්ෂණ සහ වැදගත්කම",
            bullets = listOf(
              "ලක්ෂණ: අවසාන පරිභෝජනය සඳහා භාණ්ඩ විකිණීම, පාරිභෝගිකයාට අවශ්‍ය ප්‍රමාණයෙන් අවශ්‍ය වේලාවට සැපයීම, පාරිභෝගිකයාට සමීප වීම, භාණ්ඩ වර්ග රාශියක් ඉදිරිපත් කිරීම.",
              "වැදගත්කම: පාරිභෝගිකයාට දෛනික අවශ්‍යතා සපුරාගැනීමට භාණ්ඩ සැපයීම, නව භාණ්ඩ හඳුන්වා දීම, ණයට භාණ්ඩ සැපයීම, පාරිභෝගික ප්‍රතිචාර නිෂ්පාදකයාට දැන්වීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සිල්ලර වෙළඳ ව්‍යාපාර වර්ග 3",
            bullets = listOf(
              "1. ස්ථාවර මහා පරිමාණ සිල්ලර වෙළඳසැල්: උදා: සුපිරි වෙළඳසැල් (Supermarkets), දෙපාර්තමේන්තු වෙළඳසැල්.",
              "2. ස්ථාවර සුළු පරිමාණ සිල්ලර වෙළඳසැල්: උදා: සිල්ලර කඩ (ග්‍රොසරි), රූපලාවන්‍ය ආයතන, සාමාන්‍ය කඩසාප්පු.",
              "3. සංචාරක සුළු පරිමාණ සිල්ලර වෙළඳසැල්: උදා: ගෙයින් ගෙට ගොස් අලෙවි කරන්නන්, පොළෙන් පොළට ගොස් අලෙවි කරන්නන්, ජංගම රථ මඟින් අලෙවි කරන්නන්."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "තොග වෙළඳාම (Wholesale Trade)",
            definition = "නැවත විකිණීමේ අරමුණින් නිෂ්පාදිත මිලට ගැනීම තොග වෙළඳාමයි. තොග වෙළඳ කටයුතුවල යෙදෙන්නා තොග වෙළෙන්දා ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 50
      SanduCommercePageItem(
        pageNumber = 50,
        chapterNumber = 17,
        chapterTitleSinhala = "තොග වෙළඳාම සහ උපකාරක සේවා",
        gradeLevel = "11",
        rootConcept = "තොග වෙළඳාම & උපකාරක සේවා",
        pageSections = listOf(
          SanduCommerceSection(
            title = "තොග වෙළඳාමේ ලක්ෂණ 5",
            bullets = listOf(
              "නැවත විකිණීමේ අරමුණින් භාණ්ඩ මිලදී ගැනීම.",
              "බොහෝවිට භාණ්ඩ විශාල ප්‍රමාණයක් එකවර විකිණීම.",
              "භාණ්ඩ වර්ග කීපයක් පමණක් අලෙවි කිරීම.",
              "සාපේක්ෂ ඒකකයක විකුණුම් මිල අඩු කිරීම.",
              "බහුලව වෙළඳ වට්ටම් ලබා දීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "උපකාරක සේවා (Support Services)",
            definition = "වෙළඳාම පහසු කිරීම සහ කාර්යක්ෂම කිරීම සඳහා සහාය වන සේවා උපකාරක සේවා ලෙස හැඳින්වේ (බැංකු, රක්ෂණය, ප්‍රවාහනය, සන්නිවේදනය, ගබඩාකරණය).",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        ),
        comparisonTable = SanduCommerceTable(
          title = "සිල්ලර හා තොග වෙළඳාමේ වෙනස්කම්",
          col1Header = "සිල්ලර වෙළඳාම",
          col2Header = "තොග වෙළඳාම",
          rows = listOf(
            Pair("අරමුණ අවසාන පරිභෝජනය සඳහා පාරිභෝගිකයන්ට විකිණීමයි.", "අරමුණ නැවත විකිණීම සඳහා වෙළඳුන්ට භාණ්ඩ විකිණීමයි."),
            Pair("විවිධ වර්ගවල භාණ්ඩ විකුණනු ලැබේ.", "භාණ්ඩ වර්ග එකක් හෝ සීමිත සංඛ්‍යාවක් අලෙවි කරයි."),
            Pair("සිල්ලර මිල සාපේක්ෂව වැඩි වේ.", "තොග මිල සිල්ලර මිලට සාපේක්ෂව අඩු වේ."),
            Pair("ලකුණු කළ මිලටම විකිණීම සිදු වේ.", "ලකුණු කළ මිලට වඩා අඩු මිලට (වෙළඳ වට්ටම් සහිතව) විකිණීම සිදු වේ."),
            Pair("බොහෝවිට සෘජුවම පාරිභෝගිකයන් සමඟ ගනුදෙනු කරයි.", "සිල්ලර වෙළඳුන් සමඟ පමණක් ගනුදෙනු කරයි.")
          )
        )
      )
    )
  }
}
