package com.example

/**
 * Sandu Theory - O/L Commerce & Accounting (ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය)
 * Pages 51 to 76 (Part 3): බැංකු හා රක්ෂණ සේවා, සන්නිවේදනය, ප්‍රවාහනය, අලෙවිකරණය, මූල්‍ය ප්‍රකාශන, පිරිවැය හා ආයෝජන
 */
object SanduCommerceTheoryPagesPart3 {

  val pages: List<SanduCommercePageItem> by lazy {
    listOf(
      // PAGE 51
      SanduCommercePageItem(
        pageNumber = 51,
        chapterNumber = 18,
        chapterTitleSinhala = "බැංකු ක්‍රමය සහ වාණිජ බැංකු",
        gradeLevel = "11",
        rootConcept = "බැංකුව",
        pageSections = listOf(
          SanduCommerceSection(
            title = "බැංකුව සහ වාණිජ බැංකු",
            definition = "බැංකුව: මතු ප්‍රයෝජනය සඳහා කිසියම් භාණ්ඩයක් හෝ ද්‍රව්‍යයක් රැස් කර තබා ගනු ලබන ස්ථානය නැතහොත් එවැනි සංවිධානයකි.\n\nවාණිජ බැංකු: පොලී රහිත ජංගම ගිණුම් හා පොලිස් සහිත කාලීන හා ඉතුරුම් ගිණුම් මත මහජනයා වෙත ඇති අතිරික්ත මුදල් තැන්පතු ලෙස භාර ගැනීමත්, ඒවා මුදල් අවශ්‍යතා තිබෙන අංශ වෙත ණය වශයෙන් සැපයීමත් මූලික කාර්යය ලෙස සිදුකරන ආයතනයකි. (ජංගම ගිණුම් පවත්වාගෙන යන ඕනෑම බැංකුවක් වාණිජ බැංකුවකි).",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "වාණිජ බැංකුවල ප්‍රධාන අරමුණු 2",
            bullets = listOf(
              "1. ද්‍රවශීලතාවය පවත්වාගෙන යාම (Liquidity)",
              "2. ලාභදායීත්වය (Profitability)"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ඉතුරුම් ගිණුමක් පවත්වාගෙන යාමේ ප්‍රයෝජන 6",
            bullets = listOf(
              "මුදල්වලට ආරක්ෂිත බවක් ලැබීම",
              "පොලී ආදායමක් ලැබීම",
              "ඕනෑම අවස්ථාවක මුදල් තැන්පත් කළ හැකි වීම හා ආපසු ගැනීමට හැකි වීම",
              "හදිසි අවස්ථාවලදී පහසුවෙන් මුදල් ආපසු ලබා ගත හැකි වීම",
              "ස්වයංක්‍රීය ටෙලර් යන්ත්‍ර (ATM) මඟින් ගනුදෙනු කළ හැකි වීම",
              "හරපත් (Debit cards) මඟින් ගෙවීම් කටයුතු කළ හැකි වීම"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ස්ථාවර තැන්පතු (Fixed Deposits)",
            definition = "නිශ්චිත කාල සීමාවක් සඳහා ස්ථාවර පොලී ප්‍රතිශතයක් යටතේ ආරම්භ කළ හැකි තැන්පතු ස්ථාවර තැන්පතු ලෙස හැඳින්වේ. අතිරික්ත මුදල් තැන්පත් කළ හැකි අවදානම අඩු ආයෝජන මාර්ගයකි.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 52
      SanduCommercePageItem(
        pageNumber = 52,
        chapterNumber = 18,
        chapterTitleSinhala = "ස්ථාවර තැන්පතු සහ ජංගම ගිණුම්",
        gradeLevel = "11",
        rootConcept = "ස්ථාවර තැන්පතු සහ ජංගම ගිණුම්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ස්ථාවර තැන්පතුවල ලක්ෂණ 6",
            bullets = listOf(
              "යම් නිශ්චිත කාල සීමාවක් සඳහා තැන්පතු පවත්වාගෙන යාම.",
              "තැන්පතු කාලය සහ මුදල අනුව පොලී ප්‍රතිශතය වෙනස් වීම.",
              "සාමාන්‍ය ඉතිරි කිරීමේ ගිණුම්වලට වඩා වැඩි ප්‍රතිශතයක් යටතේ පොලී හිමි වීම.",
              "ස්ථාවර තැන්පතුව ඇපයට තබා තැන්පතුවෙන් යම් ප්‍රතිශතයක් ණය මුදලක් ලෙස ලබාගත හැකි වීම.",
              "පොලිය මාසිකව හෝ කල්පිරුණු පසුව හෝ ගිවිසගත් පරිදි ලබාගත හැකි වීම.",
              "තැන්පත් කළ දිනය, මුදල, පොලිය සහ කල්පිරෙන දිනය ඇතුළත් සහතිකයක් බැංකුව විසින් ලබාදීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ජංගම ගිණුම් (Current Accounts)",
            definition = "වාණිජ බැංකු විසින් පවත්වාගෙන යනු ලබන විවිධ ගිණුම් වර්ග අතරින් ව්‍යාපාරිකයන්ට බොහෝ සෙයින් වැදගත් වන්නේ ජංගම ගිණුම් ය. ජංගම ගිණුමක් යනු චෙක්පත් මඟින් ගනුදෙනු කළ හැකි ගිණුමකි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ජංගම ගිණුමක් පවත්වාගෙන යාමේ වාසි 5",
            bullets = listOf(
              "චෙක්පත් මඟින් ආරක්ෂිතව ගෙවීම් කළ හැකි වීම.",
              "බැංකු අයිරා පහසුකම් (Bank Overdraft) ලබාගත හැකි වීම.",
              "සෘජු ප්‍රේෂණ රැස් කිරීම.",
              "ස්ථාවර නියෝග (Standing Orders) ක්‍රියාත්මක කිරීම.",
              "බැංකු ප්‍රකාශනයක් (Bank Statement) ලැබීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 53
      SanduCommercePageItem(
        pageNumber = 53,
        chapterNumber = 18,
        chapterTitleSinhala = "චෙක්පත සහ එහි ප්‍රධාන පාර්ශව",
        gradeLevel = "11",
        rootConcept = "චෙක්පත (Cheque)",
        pageSections = listOf(
          SanduCommerceSection(
            title = "චෙක්පත යනු කුමක්ද?",
            definition = "ජංගම ගිණුම් හිමියෙකු විසින් නිශ්චිත මුදලක් එහි නම් සඳහන් පුද්ගලයාට හෝ රැගෙන එන අයෙකුට ගෙවන ලෙස බැංකුවට කරනු ලබන ලිඛිත නියෝගය චෙක්පත ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "චෙක්පත හා සම්බන්ධ ප්‍රධාන පාර්ශව 3",
            bullets = listOf(
              "1. අණකරු (Drawer): චෙක්පත ලියා අත්සන් කර නිකුත් කරන ජංගම ගිණුම් හිමියා.",
              "2. අණලදු (Drawee): චෙක්පතේ මුදල ගෙවීමට නියෝග ලබන වාණිජ බැංකුව.",
              "3. ආදායකයා (Payee): චෙක්පතේ මුදල ලබාගැනීමට හිමිකම් ඇති තැනැත්තා."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "චෙක්පතක් ලිවීමේදී සැලකිය යුතු වැදගත් කරුණු 8",
            bullets = listOf(
              "නිවැරදිව දිනය යෙදීම.",
              "ආදායකයාගේ නම පැහැදිලි අකුරින් නිවැරදිව ලිවීම.",
              "ඉලක්කමෙන් හා අකුරෙන් ලියන වටිනාකම් එක සමාන හා නිවැරදි වීම.",
              "අණකරුගේ අත්සන බැංකුවේ ඇති ආදර්ශ අත්සනට සමානව නිවැරදිව යෙදීම.",
              "චෙක්පතෙහි සංශෝධන ඇත්නම් ඒවා පැහැදිලිව නිවැරදි කර කෙටි අත්සනින් සනාථ කිරීම.",
              "පිළිපතෙහි අදාළ තොරතුරු සටහන් කිරීම.",
              "චෙක්පතෙහි ඇති චුම්භක තීන්ත අක්ෂර හැඳුනුම් තීරුවෙහි (MICR) කිසිවක් නොලිවීම.",
              "සුදුසු පරිදි රේඛනය කිරීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "පිළිපත / චෙක් උප පත්‍රිකාව (Counterfoil)",
            definition = "චෙක්පත නිකුත් කළ පසු චෙක්පොතෙහි ඉතිරිවන කොටස පිළිපත නමින් හැඳින්වේ. සිදු වූ ගනුදෙනුව පිළිබඳව සාරාංශයක් එහි ඇතුළත් කළ යුතුය.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 54
      SanduCommercePageItem(
        pageNumber = 54,
        chapterNumber = 18,
        chapterTitleSinhala = "චෙක්පත් රේඛණය සහ පිටසන් කිරීම",
        gradeLevel = "11",
        rootConcept = "චෙක්පත් රේඛණය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "චෙක්පත් රේඛණය කිරීම (Crossing of Cheques)",
            definition = "චෙක්පතක මුහුණත හරහා සමාන්තර රේඛා දෙකක් ඇඳීම චෙක්පතක් රේඛනය කිරීමයි. සමාන්තර රේඛා දෙක තුළ හෝ සමාන්තර රේඛා නොමැතිව බැංකුවක නම සඳහන් කිරීම ද රේඛනයක් ලෙස සලකනු ලැබේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "චෙක්පත් රේඛනයේ අරමුණු",
            bullets = listOf(
              "චෙක්පතට වැඩි ආරක්ෂාවක් ලබා ගැනීම සඳහා.",
              "රේඛනය කළ චෙක්පතකට මුදල් බැංකු කවුන්ටරයෙන් ලබාගත නොහැකිය.",
              "මුදල් ලබාගැනීමට රේඛිත චෙක්පත බැංකු ජංගම ගිණුමක තැන්පත් කළ යුතුය.",
              "චෙක්පත් රේඛනය කිරීම මඟින් චෙක්පතේ සඳහන් මුදල නියමිත පුද්ගලයාටම ලැබෙන බව තහවුරු කර ගත හැකිය."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "චෙක්පත් පිටසන් කිරීම (Endorsement)",
            definition = "චෙක්පතේ මුහුණත සඳහන් ආදායකයාගේ නම ඒ ආකාරයෙන් ම ඔහුගේම අත් අකුරින් චෙක්පත් පිටුපස ලිවීම චෙක්පතක් පිටසන් කිරීමයි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "චෙක්පත් රේඛන වර්ග 2",
            bullets = listOf(
              "සාමාන්‍ය රේඛනය (General Crossing): චෙක්පතක මුහුණත හරහා සමාන්තර රේඛා දෙකක් ඇඳ ඒ තුළ යම් කොන්දේසියක් (& Co, Not Negotiable, A/C Payee Only) ඇතුළත් කර හෝ නොකර සිදුකරන රේඛනයයි.",
              "විශේෂ රේඛනය (Special Crossing): චෙක්පතක මුහුණත හරහා ඇඳ ඇති සමාන්තර රේඛා දෙකක් අතර හෝ සමාන්තර රේඛා නොමැතිව වාණිජ බැංකුවක නමක් සඳහන් කරමින් කරනු ලබන රේඛනය යි. මුදල් ලබාගත හැක්කේ එම නම් කළ බැංකුව හරහා පමණි."
            ),
            type = SanduCommerceSectionType.COMPARISON
          )
        )
      ),

      // PAGE 55
      SanduCommercePageItem(
        pageNumber = 55,
        chapterNumber = 18,
        chapterTitleSinhala = "ණයපත් සහ හරපත් (Credit & Debit Cards)",
        gradeLevel = "11",
        rootConcept = "ණයපත් සහ හරපත්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ණයපත (Credit Card)",
            definition = "වාණිජ බැංකු හෝ මූල්‍යායතන විසින් ණය පදනම මත ගනුදෙනු කිරීම සඳහා උපරිම ණය සීමාවක් යටතේ නිකුත් කරනු ලබන කාඩ්පත් විශේෂයකි.",
            bullets = listOf(
              "ණයපතක් ලබාගැනීම සඳහා ගනුදෙනුකරුට බැංකු ගිණුමක් තිබීම අවශ්‍ය නොවේ.",
              "අනුමත වෙළඳ ආයතනයකට ණයපත ඉදිරිපත් කර නිශ්චිත වටිනාකමක් දක්වා භාණ්ඩ හා සේවා ණයට ලබාගත හැකිය.",
              "ණයපත භාවිත කර ස්වයංක්‍රීය ටෙලර් යන්ත්‍ර (ATM) වලින් යම් සීමාවක් දක්වා මුදල් ද ලබාගත හැකිය.",
              "ණයපත් භාවිත කොට ලබාගන්නා ණය වටිනාකම් පිළිබඳව බැංකුව විසින් ණයපත් හිමියාට නියමිත කාලසීමාවක් තුළ දී ප්‍රකාශනයක් මඟින් දැනුම් දේ."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "හරපත (Debit Card)",
            definition = "බැංකු ගිණුමේ ඇති මුදල් වලින් සෘජුවම ගෙවීම් කිරීමට හැකිවන පරිදි වාණිජ බැංකු විසින් තම ගනුදෙනුකරුවන්ට නිකුත් කරන කාඩ්පත් හරපත් ලෙස හඳුන්වනු ලැබේ.",
            bullets = listOf(
              "හරපත් ලබාගැනීම සඳහා බැංකු ගිණුමක් පැවතිය යුතුය.",
              "හරපත් මඟින් ගිණුමේ ඇති මුදල් ශේෂය දක්වා යම් සීමාවකට යටත්ව භාණ්ඩ හා සේවා මිලදී ගත හැකි වේ.",
              "භාණ්ඩ හෝ සේවා ලබාගත් විට අදාළ වටිනාකම සෘජුවම තම බැංකු ගිණුමට හර වේ.",
              "හරපත්වල විශේෂත්වය වන්නේ ගනුදෙනුවක අදාළ නියමිත වටිනාකම ගැනුම්කරුගේ ගිණුමෙන් අඩු වී බැංකුව හරහා විකුණුම්කරුගේ ගිණුමට මාරු වීමයි.",
              "හරපත් භාවිතා කරමින් ස්වයංක්‍රීය ටෙලර් යන්ත්‍ර මඟින් මුදල් ආපසු ලබා ගැනීමට ද හැකි වේ."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 56
      SanduCommercePageItem(
        pageNumber = 56,
        chapterNumber = 18,
        chapterTitleSinhala = "විද්‍යුත් මුදල් සහ රක්ෂණය හැඳින්වීම",
        gradeLevel = "11",
        rootConcept = "විද්‍යුත් මුදල් & රක්ෂණය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "විද්‍යුත් මුදල් ආශ්‍රිත සේවාව (Electronic Money)",
            bullets = listOf(
              "වැදගත්කම:\n   • ක්ෂණික බව (Instant transactions)\n   • මුදල් අතැතිව රැගෙන යාමේ අවදානම් අඩු වීම\n   • සියලු තොරතුරු ස්වයංක්‍රීයව වාර්තා වීම\n   • දවසේ ඕනෑම වෙලාවක ගනුදෙනු කළ හැකි වීම (24/7)",
              "සීමාවන්:\n   • දත්ත විනාශ වීමේ හෝ තාක්ෂණික දෝෂ ඇතිවීමේ අවදානමක් පැවතීම\n   • නව ආකාරයේ විද්‍යුත් වංචාවලට (Cyber frauds/Phishing) භාජනය වීමේ අවදානම\n   • අමතර සේවා ගාස්තු හෝ පිරිවැයක් දැරීමට සිදුවීම\n   • ඇතැම් වෙළඳසැල්වලදී සන්නිවේදන ගැටලු නිසා භාවිත කළ නොහැකි වීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "රක්ෂණය (Insurance) සහ අවදානම් ඒකරාශී කිරීම",
            definition = "විවිධ අවදානම් වලට මුහුණ දීමට සිදුවෙතැයි අපේක්ෂා කරන අය විසින් ගෙවනු ලබන වාරික වලින් සමන්විත පොදු අරමුදලකින් එම අවදානම්වලට නිශ්චිත වශයෙන්ම මුහුණ දුන් අයට වන්දි ගෙවීම රක්ෂණයෙන් සිදුකරනු ලබයි. සියලු දෙනාගේ අවදානම් එකම රක්ෂණ අරමුදලක් වෙතට ඒකරාශී වන නිසා රක්ෂණය අවදානම් ඒකරාශී කිරීමක් ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "රක්ෂණයට සම්බන්ධ වන පාර්ශව 3",
            bullets = listOf(
              "1. පළමු පක්ෂය: රක්ෂණ ආවරණය ලබන පාර්ශවය හෙවත් රක්ෂිතයා (Insured).",
              "2. දෙවන පක්ෂය: රක්ෂණ ආවරණය ලබාදෙන පාර්ශවය හෙවත් රක්ෂකයා (Insurer - රක්ෂණ සමාගම).",
              "3. තෙවන පක්ෂය: රක්ෂණ ගිවිසුමෙන් බලපෑමක් වන අනෙකුත් සියලුම පාර්ශව වේ (Third Party)."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 57
      SanduCommercePageItem(
        pageNumber = 57,
        chapterNumber = 19,
        chapterTitleSinhala = "රක්ෂණ මූලධර්ම සහ රක්ෂණ වර්ග",
        gradeLevel = "11",
        rootConcept = "රක්ෂණ මූලධර්ම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "රක්ෂණ මූලධර්ම 3 (Principles of Insurance)",
            bullets = listOf(
              "1. රක්ෂණ හිමිකම (Insurable Interest): ජීවිතයක් හෝ දේපලක් රක්ෂණය කිරීමට යම් පාර්ශවයකට ඇති නීත්‍යානුකූල අයිතිය රක්ෂ්‍ය හිමිකමයි (එය විනාශ වීමෙන් තමාට මූල්‍ය පාඩුවක් සිදුවිය යුතුය).",
              "2. උපරිම විශ්වාසය (Utmost Good Faith): රක්ෂණ ගිවිසුමට එළඹෙන දෙපාර්ශවය ම එම ගිවිසුමට අදාල සියලුම තොරතුරු නිවැරදිව ඔවුනොවුනට හෙළිදරවු කළ යුතු බව මෙම මූලධර්මයෙන් කියැවේ.",
              "3. හානිපූරණය (Indemnity): රක්ෂිත දේපලකට යම් හානියක් සිදු වුවහොත් එම හානිය යථා තත්වයට පත් කර ගැනීමට සරිලන වන්දියක් පමණක් ගෙවිය යුතු බව මෙයින් අදහස් වේ (ලාභ ලැබිය නොහැක). මෙම මූලධර්මය ජීවිත රක්ෂණය සඳහා අදාළ නොවේ!"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ජීවිත රක්ෂණයේ වැදගත්කම 5",
            bullets = listOf(
              "ඉතිරි කිරීමේ ක්‍රමයක් ලෙස හෝ ආයෝජන මාර්ගයක් ලෙස යොදාගත හැකි වීම.",
              "ඔප්පුව කල් පිරෙන තෙක් ජීවත් වුවහොත් රක්ෂිත මුදල හා ප්‍රසාද දීමනා රක්ෂිතයාට ලබාගත හැකි වීම.",
              "රක්ෂිතයා අකල් මරණයකට පත්වුවහොත් නම් කරන ලද අයට වන්දි ලබාගත හැකි වීම.",
              "දූ දරුවන්ගේ විවාහ, අධ්‍යාපන කටයුතු වලදී මූල්‍ය සහන ලබාගත හැකි වීම.",
              "මූල්‍ය ආයතන වලින් ණය ලබාගැනීමේදී ඇපයක් ලෙස භාවිතා කළ හැකි වීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "දේපල රක්ෂණයේ වැදගත්කම 4",
            bullets = listOf(
              "ව්‍යාපාරවලට සිදුවිය හැකි විවිධ අවදානම් තුළින් පැන නගින මූල්‍ය අලාභ ආවරණය කරගත හැකි වීම.",
              "ව්‍යාපාර කටයුතු අඛණ්ඩව කරගෙන යාමට උපකාරී වීම.",
              "දේශීය මෙන්ම විදේශීය වෙළඳාම් කටයුතුවලදී උපකාරී වීම.",
              "සේවකයින් හා පාරිභෝගිකයන්ගේ සුරක්ෂිතතාව තහවුරු කිරීම සඳහා ඉවහල් වීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 58
      SanduCommercePageItem(
        pageNumber = 58,
        chapterNumber = 20,
        chapterTitleSinhala = "සන්නිවේදනය සහ සන්නිවේදන ක්‍රියාවලිය",
        gradeLevel = "11",
        rootConcept = "සන්නිවේදනය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සන්නිවේදනය යනු කුමක්ද?",
            definition = "පණිවුඩ, තොරතුරු සහ අදහස් පාර්ශවයන් අතර යම් මාධ්‍යයක් මඟින් හුවමාරු කරගැනීම සන්නිවේදනයයි.",
            bullets = listOf(
              "අභ්‍යන්තර සන්නිවේදනය: ආයතනය තුළ විවිධ පාර්ශව අතර විවිධ මාධ්‍ය හරහා පණිවුඩ, තොරතුරු හා අදහස් හුවමාරු කර ගැනීම.",
              "බාහිර සන්නිවේදනය: ව්‍යාපාර ආයතනයක් බාහිර පුද්ගලයන් හා බාහිර ආයතන සමඟ සිදුකරනු ලබන සන්නිවේදනයයි."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සන්නිවේදන ක්‍රියාවලිය (Communication Process)",
            definition = "යවන්නා (Sender) ➔ පණිවුඩය (Message) ➔ මාධ්‍යය (Medium) ➔ ලබන්නා (Receiver) ➔ ප්‍රතිචාරය (Response) ➔ ප්‍රතිපෝෂණය (Feedback)",
            type = SanduCommerceSectionType.PROCESS_STEPS
          ),
          SanduCommerceSection(
            title = "සන්නිවේදන මාධ්‍යයක් තෝරා ගැනීමේදී සලකා බැලිය යුතු සාධක 5",
            bullets = listOf(
              "සුදුසු බව (Appropriateness)",
              "වේගවත් බව (Speed)",
              "පිරිවැය (Cost)",
              "පැහැදිලි බව (Clarity)",
              "භාවිතා කිරීමේ පහසුව (Ease of use)"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 59
      SanduCommercePageItem(
        pageNumber = 59,
        chapterNumber = 20,
        chapterTitleSinhala = "සන්නිවේදන මූලිකාංග සහ මාධ්‍යයන්ගේ ස්වරූප",
        gradeLevel = "11",
        rootConcept = "සන්නිවේදන මූලිකාංග",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සන්නිවේදන මූලිකාංග 6",
            bullets = listOf(
              "යවන්නා: පණිවුඩය ලබාදෙන පුද්ගලයා හෝ ආයතනය.",
              "පණිවුඩය: යවන්නා විසින් සපයන තොරතුරු හෝ අදහස්.",
              "මාධ්‍යය: පණිවුඩය යැවීම සඳහා යොදාගන්නා සන්නිවේදන මාධ්‍යය.",
              "ලබන්නා: පණිවුඩය ලබන තැනැත්තා.",
              "ප්‍රතිචාරය: පණිවුඩය ලබන්නා පණිවුඩය සම්බන්ධයෙන් ක්‍රියාකරන ආකාරය.",
              "ප්‍රතිපෝෂණය: ලැබුණු පණිවුඩය ලැබුණු බවට හෝ තේරුම් ගත් බවට ලබන්නාගෙන් යවන්නා වෙත වාචිකව හෝ වාචික නොවන මාර්ගයකින් ලැබෙන ප්‍රතිචාරය."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        ),
        comparisonTable = SanduCommerceTable(
          title = "සන්නිවේදන මාධ්‍යයන් හා ඒවායේ ස්වරූපය",
          col1Header = "සන්නිවේදනයේ ස්වරූපය",
          col2Header = "සන්නිවේදන මාධ්‍ය සඳහා නිදසුන්",
          rows = listOf(
            Pair("වාචික (Oral)", "රැස්වීම්, සාකච්ඡා, සම්මන්ත්‍රණ, දුරකතන සංවාද"),
            Pair("ලිඛිත (Written)", "ලිපි, දැන්වීම්, වාර්තා, අත්පත්‍රිකා, පුවත්පත්, සඟරා, බැනර්, පෝස්ටර්"),
            Pair("විද්‍යුත් (Electronic)", "ශබ්දවාහිනී යන්ත්‍ර, ඩිජිටල් පුවරු, විද්‍යුත් තැපෑල (E-mail), ෆැක්ස්, අන්තර්ජාලය, ගුවන්විදුලි, රූපවාහිනී, වෙබ් අඩවි, Social Media (WhatsApp, FB, Viber)"),
            Pair("සංකේත හා සංඥා මාර්ග", "සංඥා, පිළිගත් සංකේත, සීනුව, මාර්ග සංඥා")
          )
        )
      ),

      // PAGE 60
      SanduCommercePageItem(
        pageNumber = 60,
        chapterNumber = 21,
        chapterTitleSinhala = "ප්‍රවාහනය සහ මහා මාර්ග ප්‍රවාහනය",
        gradeLevel = "11",
        rootConcept = "ප්‍රවාහනය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ප්‍රවාහනයේ මූලිකාංග 4 සහ තෝරාගැනීමේ සාධක 6",
            bullets = listOf(
              "මූලිකාංග 4: 1. මාර්ගය  2. මාධ්‍යය  3. බලය  4. පර්යන්තය",
              "තෝරාගැනීමේ සාධක 6: 1. භාණ්ඩයේ ස්වභාවය  2. ප්‍රවාහන පිරිවැය  3. ධාරිතාව  4. ආරක්ෂාව  5. වේගය  6. සුලභතාව",
              "ව්‍යාපාරයට ප්‍රවාහනය දායක වන ආකාරය: නිෂ්පාදන කටයුතු සඳහා අවශ්‍ය සම්පත් ලබා ගැනීමට, භාණ්ඩ වෙළඳපොළට බෙදාහැරීමට, සේවකයන් ප්‍රවාහනයට, භාණ්ඩ පාරිභෝගිකයා වෙත ප්‍රවාහනයට."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "මහා මාර්ග ප්‍රවාහනයේ වාසි 6",
            bullets = listOf(
              "අවශ්‍ය ඕනෑම විටෙක භාවිතා කළ හැකි වීම.",
              "ගමනාන්තය දක්වාම (Door to Door) ගමන් කළ හැකි වීම.",
              "භාණ්ඩ හෝ සේවාවල ස්වභාවයට ගැලපෙන පරිදි යොදාගත හැකි වීම.",
              "මුළු රට පුරාම මාර්ග ජාලය ව්‍යාප්තව පැවතීම.",
              "කඩින්කඩ ප්‍රවාහනයට සුදුසු වීම.",
              "තමාට පෞද්ගලිකව ද / පොදුවේ ද භාවිතා කළ හැකි වීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "මහා මාර්ග ප්‍රවාහනයේ අවාසි 5",
            bullets = listOf(
              "අනතුරු අධික වීම.",
              "මාර්ග අබලන් වීම හා පටු වීම / මාර්ග තදබදය.",
              "නඩත්තු ආදී වියදම් අධික වීම.",
              "පුහුණු රියදුරන්ගේ හිඟය.",
              "ද්විත්ව පරිවහනය නිසා ගාස්තු වැඩිවීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 61
      SanduCommercePageItem(
        pageNumber = 61,
        chapterNumber = 21,
        chapterTitleSinhala = "දුම්රිය සහ ගුවන් ප්‍රවාහනය",
        gradeLevel = "11",
        rootConcept = "දුම්රිය & ගුවන් ප්‍රවාහනය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "දුම්රිය ප්‍රවාහනයේ වාසි සහ අවාසි",
            bullets = listOf(
              "වාසි:\n   • විශාල භාණ්ඩ තොග හා මගීන් විශාල සංඛ්‍යාවක් එකවර ප්‍රවාහනය කළ හැකි වීම\n   • මහාමාර්ග ප්‍රවාහනයට වඩා ආරක්ෂාකාරී වීම\n   • භාණ්ඩවල ස්වභාවය අනුව විශේෂ මැදිරි යොදාගත හැකි වීම\n   • සෙසු ප්‍රවාහන මාධ්‍ය හා සසඳන කල ගාස්තු අඩු වීම\n   • ආපනශාලා, නිදන මැදිරි ආදී පහසුකම් පැවතීම",
              "අවාසි:\n   • අනවශ්‍ය ප්‍රමාද වීම් සිදුවීම හා පහසුකම් අවම වීම\n   • දුම්රිය මාර්ග රටපුරා ව්‍යාප්ත නොවීම\n   • ගමනාන්තය තෙක්ම ගමන් කළ නොහැකි වීම\n   • අවශ්‍ය ඕනෑම විටෙක භාවිතා කළ නොහැකි වීම\n   • විදුලි සංඥා ඇනහිටීම්වලදී ප්‍රවාහනයට බාධා පැමිණීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ගුවන් ප්‍රවාහනයේ වාසි සහ අවාසි",
            bullets = listOf(
              "වාසි:\n   • වේගවත් බව / ඉක්මන් ප්‍රවාහනය\n   • නඩත්තු පිරිවැය අවම වීම\n   • මගීන්ට උපරිම සුවපහසුව\n   • නෂ්‍ය වන (ඉක්මනින් නරක්වන) භාණ්ඩ හා වටිනා භාණ්ඩ ප්‍රවාහනයට සුදුසු වීම",
              "අවාසි:\n   • ගාස්තු ඉතා ඉහළ වීම\n   • අවශ්‍ය සෑම අවස්ථාවලම යොදාගත නොහැකි වීම (ගුවන් තොටුපළවල් සීමිත වීම)\n   • අනතුරක් සිදුවුවහොත් සිදුවන අලාභය හෝ ජීවිත හානිය අති විශාල වීම\n   • බරින් ඉතා අධික භාණ්ඩ ප්‍රවාහනය කළ නොහැකි වීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 62
      SanduCommercePageItem(
        pageNumber = 62,
        chapterNumber = 22,
        chapterTitleSinhala = "කළමනාකරණය සහ කළමනාකරණ කාර්යයන්",
        gradeLevel = "11",
        rootConcept = "කළමනාකරණය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "කළමනාකරණය යනු කුමක්ද?",
            definition = "ව්‍යාපාර අරමුණු සඵලදායී ව ඉටුකර ගැනීම සඳහා පවතින සම්පත් කාර්යක්ෂමව යොදාගනිමින් එම ව්‍යාපාරය සැලසුම් කිරීමේ, සංවිධානය කිරීමේ, මෙහෙයවීමේ සහ පාලනය කිරීමට අදාල වූ ක්‍රියාවලියකි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ප්‍රධාන කළමනාකරණ කාර්යයන් 4",
            bullets = listOf(
              "1. සැලසුම්කරණය (Planning): ව්‍යාපාර ආයතනයක් නිශ්චිත අනාගත කාලපරිච්ඡේදයක් වෙනුවෙන් යෝග්‍ය අරමුණු තීරණය කිරීමට සහ එකී අරමුණු ළඟා කර ගැනීමේ ක්‍රියාවලියයි.",
              "2. සංවිධානකරණය (Organizing): ආයතනයක අරමුණු, පරමාර්ථ කාර්යක්ෂමවත්, සඵලදායීවත් ඉටුකර ගැනීම සඳහා කාර්යයන්, කටයුතු, තනතුරු, සම්පත් සහ වගකීම් සාමාජිකයන් අතර බෙදාහැරීමේ ක්‍රියාවලියයි.",
              "3. මෙහෙයවීම (Leading / Directing): සැලසුම් කරන ලද ක්‍රියාවලිය ක්‍රියාත්මක කිරීමේදී ව්‍යාපාරයේ මානව සම්පත් නිසි ලෙස හැසිරවීමේ ක්‍රියාවලියයි. අවශ්‍ය තොරතුරු, උපදෙස් හා නායකත්වය ලබාදෙමින් පෙළඹවීම සිදු කරයි.",
              "4. පාලනය (Controlling): ව්‍යාපාරයේ කටයුතු සැලසුම් කළ ආකාරයෙන් ම සිදුවේ දැයි සොයා බැලීම හා එසේ නොවන්නේ නම් අඩුපාඩු හඳුනාගෙන ඒවා නිවැරදි කිරීම සම්බන්ධ ක්‍රියාවලියයි."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාරයකට පාලනයේ අවශ්‍යතාවය 4",
            bullets = listOf(
              "ව්‍යාපාර පරිසරයේ සිදුවන වෙනස්කම් නිසා",
              "පුද්ගලයින් අතින් වැරදි සිදුවන නිසා",
              "ආයතනවල හා ඒවායේ කටයුතුවල සංකීර්ණ තත්ත්වය නිසා",
              "අධිකාරිය හා වගකීම බෙදාහැරීම අවශ්‍ය නිසා"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 63
      SanduCommercePageItem(
        pageNumber = 63,
        chapterNumber = 23,
        chapterTitleSinhala = "අලෙවිකරණය සහ අලෙවි මිශ්‍රය (4Ps)",
        gradeLevel = "11",
        rootConcept = "අලෙවිකරණය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "අලෙවිකරණය සහ ඉලක්ක වෙළඳපොළ",
            definition = "අලෙවිකරණය (Marketing): මිනිස් අවශ්‍යතා හා වුවමනා තෘප්තිමත් කිරීම සඳහා වටිනාකමින් යුත් නිෂ්පාදිතයක් නිර්මාණය කිරීමේ හා පිළිගැන්වීමේ ක්‍රියාවලිය අලෙවිකරණයයි.\n\nඉලක්ක වෙළඳපොළ (Target Market): ව්‍යාපාරයකට වඩාත් ආකර්ෂණීය ලෙස මෙන්ම පාරිභෝගිකයන්ගෙන් සමන්විත වෙළඳපොළ කොටස හෙවත් පාරිභෝගික කොටස ඉලක්ක වෙළඳපොල ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "අලෙවි මිශ්‍රය (Marketing Mix - 4Ps)",
            definition = "ඉලක්ක වෙළඳපොළේ ඉලක්ක ඉටුවන ආකාරයෙන් ද යහපත් ප්‍රතිචාර ඇති කර ගැනීම සඳහා ද ආයතනයකට පාලනය කළ හැකි විචල්‍යයන් සමූහයක සංකලනය අලෙවි මිශ්‍රයයි.",
            bullets = listOf(
              "නිෂ්පාදිතය (Product): මිනිස් අවශ්‍යතා හා වුවමනා ඉටුකිරීම සඳහා වෙළඳපොළට ඉදිරිපත් කරන ඕනෑම දෙයක් නිෂ්පාදිතයක් ලෙස හඳුන්වයි.",
              "මිල (Price): භාණ්ඩයක් හෝ සේවාවක් වෙනුවෙන් පාරිභෝගිකයාගෙන් අය කිරීමට අපේක්ෂිත වටිනාකම මිල ලෙස හඳුන්වයි.",
              "ස්ථානය (Place): නිෂ්පාදිත පාරිභෝගිකයන් වෙත ලබාදීම හා සම්බන්ධ වූ කටයුතු කරන ස්ථානය හා බෙදාහැරීමේ මාර්ග වේ.",
              "ප්‍රවර්ධනය (Promotion): ව්‍යාපාරයක් තම අලෙවිය වැඩි කර ගැනීම සඳහා යොදාගන්නා විවිධ උපක්‍රම ප්‍රවර්ධනය ලෙස හඳුන්වයි."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 64
      SanduCommercePageItem(
        pageNumber = 64,
        chapterNumber = 23,
        chapterTitleSinhala = "ප්‍රවර්ධන මිශ්‍රය සහ අලෙවි මිශ්‍ර අයිතම",
        gradeLevel = "11",
        rootConcept = "ප්‍රවර්ධන මිශ්‍රය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ප්‍රවර්ධන මිශ්‍රයට අයත් උප විචල්‍යයන් 5",
            bullets = listOf(
              "1. ප්‍රචාරණය (Advertising): මුදල් ගෙවා සිදුකරන පුද්ගලික නොවන සන්නිවේදනය.",
              "2. පෞද්ගලික අලෙවිය (Personal Selling): අලෙවි නියෝජිතයන් මඟින් සෘජුවම පාරිභෝගිකයා හමුවී භාණ්ඩ අලෙවි කිරීම.",
              "3. විකුණුම් ප්‍රවර්ධනය (Sales Promotion): කෙටිකාලීන දිරිගැන්වීම් (මිල අඩුකිරීම්, නොමිලේ සාම්පල, කූපන්).",
              "4. මහජන සබඳතා (Public Relations): ආයතනය කෙරෙහි මහජනතාව තුළ යහපත් ප්‍රතිරූපයක් ගොඩනැගීම.",
              "5. සෘජු අලෙවිකරණය (Direct Marketing): අතරමැදියන් නොමැතිව සෘජුවම පාරිභෝගිකයා අමතා අලෙවි කිරීම (Tele-marketing, Mail orders)."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        ),
        comparisonTable = SanduCommerceTable(
          title = "අලෙවිකරණ මිශ්‍රයේ විචල්‍යයන් වලට ඇතුළත් වන අයිතම",
          col1Header = "අලෙවි මිශ්‍ර විචල්‍යය",
          col2Header = "ඇතුළත් වන ප්‍රධාන අයිතම",
          rows = listOf(
            Pair("නිෂ්පාදිතය (Product)", "විවිධ නිපැයුම්, ගුණත්වය, නිමාව, අංගෝපාංග, සන්නම, ඇසුරුම, ප්‍රමාණ, වගකීම්, සේවා"),
            Pair("මිල (Price)", "ලැයිස්තුගත මිල, වට්ටම්, දීමනා, ගෙවීම් කාලය, ණය කොන්දේසි"),
            Pair("ස්ථානය (Place)", "බෙදාහැරීමේ මාර්ග, ආවරණය, මාර්ග මිශ්‍රය, තොගයන්, ප්‍රවාහනය, ප්‍රදේශයන්"),
            Pair("ප්‍රවර්ධනය (Promotion)", "ප්‍රචාරණය, විකුණුම් ප්‍රවර්ධනය, මහජන සබඳතා, පෞද්ගලික අලෙවිය, සෘජු අලෙවිකරණය")
          )
        )
      ),

      // PAGE 65
      SanduCommercePageItem(
        pageNumber = 65,
        chapterNumber = 24,
        chapterTitleSinhala = "මූල්‍ය ප්‍රකාශන (Financial Statements)",
        gradeLevel = "11",
        rootConcept = "මූල්‍ය ප්‍රකාශන",
        pageSections = listOf(
          SanduCommerceSection(
            title = "මූල්‍ය ප්‍රකාශන යනු මොනවාද?",
            definition = "ගිණුම් කාලපරිච්ඡේදය තුළ ව්‍යාපාරය විසින් අත් කරගෙන ඇති මෙහෙයුම් ප්‍රතිඵලය අනාවරණය කර ගැනීමටත්, මූල්‍ය තත්ත්වය අවබෝධ කර ගැනීමටත් හැකි වන සේ පිළියෙල කරන වාර්තා මූල්‍ය ප්‍රකාශන නම් වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ලාභ හෝ අලාභ ප්‍රකාශනය (Income Statement)",
            definition = "ව්‍යාපාරයක් විසින් යම් ගිණුම් කාලපරිච්ඡේදයක් තුළ ඉපැයූ ලාභය හෝ අලාභය ගණනය කර ඉදිරිපත් කිරීම සඳහා පිළියෙල කරනු ලබන වාර්තාව ලාභ හෝ අලාභ ප්‍රකාශනය ලෙස හැඳින්වේ.",
            bullets = listOf(
              "ලාභ හෝ අලාභ ප්‍රකාශනය සකස් කිරීමේදී යොදාගන්නා වියදම් වර්ගීකරණය 4:\n   • බෙදාහැරීමේ වියදම් (Distribution expenses)\n   • පරිපාලන වියදම් (Administrative expenses)\n   • වෙනත් වියදම් (Other expenses)\n   • මූල්‍ය වියදම් (Finance costs)"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "මූල්‍ය තත්ත්ව ප්‍රකාශනය සහ ගැලපුම් සටහන්",
            bullets = listOf(
              "මූල්‍ය තත්ත්ව ප්‍රකාශනය (Statement of Financial Position): ව්‍යාපාරයක වත්කම්, හිමිකම් හා වගකීම් ගිණුම්වල ශේෂ ඇතුළත් කර මූල්‍ය තත්ත්වය පෙන්නුම් කිරීමට යම් නිශ්චිත දිනකට පිළියෙල කරන වාර්තාවයි.",
              "ගැලපුම් සටහන් (Adjustments): මූල්‍ය ප්‍රකාශනවලට යොදාගත යුතු නිවැරදි අගයන් ලැබෙන සේ සිදුකළ යුතු වෙනස්කම් සඳහා ගිණුම්වල ගලපනු ලබන සටහන් ගැලපුම් සටහන් වේ."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 66
      SanduCommercePageItem(
        pageNumber = 66,
        chapterNumber = 24,
        chapterTitleSinhala = "උපචිත සංකල්පය, බොල් ණය සහ ක්ෂයවීම්",
        gradeLevel = "11",
        rootConcept = "ගිණුම්කරණ ගැලපුම්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "උපචිත සංකල්පය (Accrual Concept)",
            definition = "ආදායම්වලට අදාළව මුදලින් ලැබුණු ප්‍රමාණය කුමක් වුවත්, වියදම් වලට අදාළව මුදලින් ගෙවූ ප්‍රමාණය කුමක් වුවත් මූල්‍ය ප්‍රකාශනවල ඇතුළත් කළ යුතු වන්නේ කාලච්ඡේදයට අදාළ ප්‍රමාණය බව උපචිත සංකල්පයයි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "උපචිත වියදම් සහ උපචිත ආදායම්",
            bullets = listOf(
              "උපචිත වියදම් (ගෙවිය යුතු වියදම් - Accrued Expenses): ගිණුම් කාලච්ඡේදය තුළදී ව්‍යාපාරය විසින් ලබාගෙන ඇති සේවා වෙනුවෙන් ගිණුම් කාලච්ඡේදය අවසන් දින වන විටත් නොගෙවා ඇති වියදම් ය. (ජංගම වගකීමකි).",
              "උපචිත ආදායම් (ලැබිය යුතු ආදායම් - Accrued Income): ගිණුම් කාලච්ඡේදයට අදාළව ලැබිය යුතු නමුත් ගිණුම් කාලච්ඡේදය අවසාන වන විටත් ව්‍යාපාරයට ලැබී නැති ආදායම් වේ. (ජංගම වත්කමකි)."
            ),
            type = SanduCommerceSectionType.COMPARISON
          ),
          SanduCommerceSection(
            title = "බොල් ණය සහ ක්ෂය වීම (Bad Debts & Depreciation)",
            bullets = listOf(
              "බොල් ණය (Bad Debts): කුමන හේතුවක් මත හෝ ණයගැතියෙකුගෙන් අයවිය යුතු මුදලක් නිශ්චිතවම අයකර ගත නොහැකි තත්ත්වයකට පත්වුවහොත් එසේ නොලැබේ යැයි තීරණය කරන ණය බොල් ණය ලෙස හැඳින්වේ. (වියදමකි).",
              "ක්ෂය වීම (Depreciation): වත්කමේ ඵලදායී ජීවකාලය තුළ භාවිතය හෝ යල්පැනීම නිසා අගය අඩු වූ ප්‍රමාණය ක්ෂය ලෙස හැඳින්වේ. දිරාපත් වීම, වැහැරීම, භෞතික සාධක නිසා යල්පැනීම වැනි ආර්ථික සාධක වත්කම් ක්ෂය වීමට හේතු වේ."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 67
      SanduCommercePageItem(
        pageNumber = 67,
        chapterNumber = 24,
        chapterTitleSinhala = "ක්ෂය ගණනය සහ වත්කම් අගයන්",
        gradeLevel = "11",
        rootConcept = "ක්ෂය ගණනය කිරීම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සුන්බුන් අගය සහ වත්කමක පිරිවැය",
            bullets = listOf(
              "සුන්බුන් අගය (Scrap / Residual Value): වත්කමක ප්‍රයෝජනවත් ජීව කාලය අවසාන වූවා සේ සැලකුවහොත් එම වත්කම විකුණා යම් මුදලක් ආපසු ලබා ගැනීමට ඇතැම් විට හැකියාවක් පවතී. එසේ ලබාගත හැකි වටිනාකම සුන්බුන් අගය ලෙස හැඳින්වේ.",
              "වත්කමක පිරිවැය (Cost of Asset): කිසියම් වත්කමක් අත්පත් කරගත් වටිනාකම සහ එම වත්කම් භාවිතයට ගත හැකි තත්ත්වයට හා ස්ථානයට පත් කිරීම සඳහා දරන ලද සියලු වියදම්වල එකතුවයි."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ජීව කාලය, සරල මාර්ග ක්ෂය සහ ධාරණ අගය",
            bullets = listOf(
              "වත්කමක ජීව කාලය (Useful Life): වත්කම තුළින් අපේක්ෂිත පරිදි සේවාවක් ලබාගත හැකි කාලය හෝ නිෂ්පාදනය කළ හැකි යැයි අපේක්ෂිත ඒකක ප්‍රමාණය වේ.",
              "සරල මාර්ග ක්ෂය ක්‍රමය (Straight-line Method): වත්කමක ක්ෂය කළ හැකි අගය එහි ඵලදායී ජීව කාලය පුරා වාර්ෂිකව සමාන වටිනාකමකින් කපාහැරීම සරල මාර්ග ක්ෂය ක්‍රමයයි.\n   සූත්‍රය: වාර්ෂික ක්ෂය = (පිරිවැය - සුන්බුන් අගය) / ජීව කාලය",
              "ධාරණ අගය (Carrying Amount / Net Book Value): වත්කමක පිරිවැයෙන් සමුච්චිත ක්ෂය ප්‍රමාණය අඩු කළ පසු ඉතිරි වටිනාකම වත්කමේ ධාරණ අගය ලෙස හැඳින්වේ.\n   සූත්‍රය: ධාරණ අගය = පිරිවැය - සමුච්චිත ක්ෂය"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 68
      SanduCommercePageItem(
        pageNumber = 68,
        chapterNumber = 25,
        chapterTitleSinhala = "ලාභ අරමුණු කර නොගත් සංවිධාන",
        gradeLevel = "11",
        rootConcept = "ලාභ නොවන සංවිධාන",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ප්‍රධාන පරමාර්ථ සහ ආර්ථික කටයුතු",
            bullets = listOf(
              "ප්‍රධාන පරමාර්ථ:\n   • සාමාජිකයන්ගේ අභිවෘද්ධිය සහ සුභසාධනය\n   • සමාජ සම්බන්ධතා වර්ධනය",
              "නිරත වන ආර්ථික කටයුතු 7:\n   • සාමාජික ගාස්තු එකතු කිරීම\n   • කොඩි විකිණීම\n   • සංදර්ශන හා උත්සව පැවැත්වීම\n   • ආපනශාලා පවත්වාගෙන යාම\n   • විවිධ තරඟ සංවිධානය\n   • ප්‍රදර්ශන සංවිධානය කිරීම\n   • පරිත්‍යාග ලැබීම"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ගිණුම් තැබීමෙන් අපේක්ෂා කරන දෑ",
            bullets = listOf(
              "සංවිධානය පිළිබඳව සාමාජිකයන් හා වෙනත් ඇල්මැති පාර්ශව දැනුවත් කිරීම.",
              "සාමාජිකයන්ගේ විශ්වාසය පවත්වා ගැනීම.",
              "සංවිධානයේ ඉදිරි කටයුතු සැලසුම් කිරීම.",
              "සංවිධානයේ කටයුතු ක්‍රමවත්ව පවත්වාගෙන යාම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ආදායම් ප්‍රකාශනය සහ සමුච්චිත අරමුදල",
            bullets = listOf(
              "ආදායම් ප්‍රකාශනය: යම් නිශ්චිත කාලච්ඡේදයක් තුළ සිදුකළ ආර්ථික ක්‍රියාකාරකම්වල ප්‍රතිඵල (අතිරික්තය හෝ ඌනතාවය) ගණනය කිරීම සඳහා පිළියෙල කරන ප්‍රකාශයයි.",
              "සමුච්චිත අරමුදල (Accumulated Fund): ලාභ අරමුණු කර නොගත් සංවිධානවල ලද ආදායම් වලින් වියදම් දැරීමෙන් අනතුරුව ඉතිරිවන ශේෂයන් (අතිරික්තයන්) එක් රැස්වීමෙන් ගොඩනැගෙන අරමුදල සමුච්චිත අරමුදලයි."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 69
      SanduCommercePageItem(
        pageNumber = 69,
        chapterNumber = 25,
        chapterTitleSinhala = "ලැබීම් හා ගෙවීම් ගිණුම සහ වෙනස්කම්",
        gradeLevel = "11",
        rootConcept = "ලැබීම් හා ගෙවීම් ගිණුම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ලැබීම් හා ගෙවීම් ගිණුම (Receipts and Payments A/C)",
            definition = "ලාභ අරමුණු කර නොගත් සංවිධානවල කිසියම් ගිණුම් කාලපරිච්ඡේදයක් තුළ සියලුම මුදල් ලැබීම්වලත් සියලුම මුදල් ගෙවීම්වලත් සාරාංශය ඉදිරිපත් කරන ගිණුමකි. මෙය වත්කම් ගිණුමකි. මුදල් ලැබීම් හරටත් මුදල් ගෙවීම් බැරටත් සඳහන් කරයි (මුදල් පොතට සමාන වේ).",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ලැබීම් හා ගෙවීම් ගිණුම පිළියෙළ කිරීමේ අරමුණු 5",
            bullets = listOf(
              "කාලච්ඡේදය අවසානයේ මුදල් ශේෂය දැනගත හැකි වීම.",
              "මුදල් කළමනාකරණය ක්‍රමවත් වීම.",
              "මුදල් සම්බන්ධ වංචා හා අයථා ගනුදෙනු අවම කළ හැකි වීම.",
              "අරමුණු ළඟා කර ගැනීමට සංවිධානයේ මූල්‍ය සම්පත් මැනවින් යොදාගත හැකි වීම.",
              "මුදල් ලැබීම් හා ගෙවීම් මාර්ග පිළිබඳ තොරතුරු දැනගත හැකි වීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "අතිරික්තය vs ඌනතාවය",
            bullets = listOf(
              "අතිරික්තය (Surplus): ආදායම් වියදම් ගිණුමේ වියදමට වඩා වැඩි ආදායම අතිරික්තය ලෙස හඳුන්වයි.",
              "ඌනතාවය (Deficit): ආදායම් වියදම් ගිණුමේ ආදායමට වඩා වැඩි වියදම ඌනතාවයයි."
            ),
            type = SanduCommerceSectionType.COMPARISON
          )
        ),
        comparisonTable = SanduCommerceTable(
          title = "ආදායම් ප්‍රකාශය සහ ලැබීම් හා ගෙවීම් ගිණුම අතර වෙනස්කම්",
          col1Header = "ආදායම් ප්‍රකාශය",
          col2Header = "ලැබීම් හා ගෙවීම් ගිණුම",
          rows = listOf(
            Pair("ලාභ හෝ අලාභ ප්‍රකාශයට බොහෝ දුරට සමාන වේ.", "මුදල් පොතට බොහෝදුරට සමාන වේ."),
            Pair("ආදායම් හා වියදම් පමණක් සටහන් කරයි.", "මුදල් ලැබීම් හා ගෙවීම් සටහන් කරයි."),
            Pair("කාලච්ඡේදයට අදාල ආදායම් හා වියදම් පමණක් සටහන් කරයි.", "කාලච්ඡේදයට අදාල සියලුම මුදල් ලැබීම් හා ගෙවීම් සටහන් කරයි."),
            Pair("අවසාන ශේෂයෙන් අතිරික්තය හෝ ඌනතාව පෙන්වයි.", "කාල පරිච්ඡේදයේ අවසානයේ අත ඉතිරි මුදල් ශේෂය පෙන්වයි."),
            Pair("උපචිත පදනමට පිළියෙල කරයි.", "මුදල් පදනමට පිළියෙල කරයි.")
          )
        )
      ),

      // PAGE 70
      SanduCommercePageItem(
        pageNumber = 70,
        chapterNumber = 26,
        chapterTitleSinhala = "නිෂ්පාදන පිරිවැය සහ ප්‍රාථමික පිරිවැය",
        gradeLevel = "11",
        rootConcept = "නිෂ්පාදන පිරිවැය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සෘජු නිෂ්පාදන පිරිවැය",
            definition = "යම් නිෂ්පාදිත ඒකකයක් සමග සෘජුවම හඳුනාගත හැකි පිරිවැයයි. මෙම පිරිවැය කිසියම් භාණ්ඩයක් නිෂ්පාදනය කිරීම සඳහා සෘජුවම අදාල වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සෘජු පිරිවැයේ මූලිකාංග 3",
            bullets = listOf(
              "1. සෘජු ද්‍රව්‍ය පිරිවැය (Direct Materials): නිෂ්පාදනය කරන ලද භාණ්ඩය තුළට අන්තර්ගත වන භාණ්ඩ ඒකකයක් සමඟ පැහැදිලිව හඳුනාගත හැකි භෞතික සම්පත්වල වටිනාකම සෘජු ද්‍රව්‍ය පිරිවැය වේ.",
              "2. සෘජු ශ්‍රම පිරිවැය (Direct Labour): යම් භාණ්ඩයක් නිපදවීම සඳහා සෘජුවම සහභාගි වන ශ්‍රමිකයන්ට ගෙවන වැටුප් සඳහා දරන වියදමයි. යෙදවුම් නිමැවුම් බවට පරිවර්තනය කිරීමේ කාර්යයට සෘජුවම දායක වන සේවකයන්ට කරන ගෙවීම් සියල්ල මීට අයත්ය.",
              "3. වෙනත් සෘජු පිරිවැය (Direct Expenses): භාණ්ඩ ඒකකයක් නිපදවීමේදී ඍජුව හඳුනාගත හැකි ද්‍රව්‍ය පිරිවැයට හා ශ්‍රම පිරිවැයට අමතරව ඍජුවම යොදාගන්නා වෙනත් දේ සඳහා දරනු ලබන වියදම් වේ (උදා: විශේෂිත අච්චු කුලිය, පේටන්ට් බලපත්‍ර ගාස්තු)."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ප්‍රාථමික පිරිවැය (Prime Cost)",
            definition = "භාණ්ඩයක් නිෂ්පාදනය කිරීම සඳහා දරන සෘජු ද්‍රව්‍ය, සෘජු ශ්‍රමය සහ සෘජු වෙනත් පිරිවැය සියල්ලෙහි එකතුව මුළු සෘජු පිරිවැය හෙවත් ප්‍රාථමික පිරිවැය නම් වේ.\n\nසූත්‍රය: ප්‍රාථමික පිරිවැය = සෘජු ද්‍රව්‍ය + සෘජු ශ්‍රමය + සෘජු වෙනත් වියදම්",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 71
      SanduCommercePageItem(
        pageNumber = 71,
        chapterNumber = 26,
        chapterTitleSinhala = "නිෂ්පාදන පොදුකාර්ය පිරිවැය සහ මිල නියම කිරීම",
        gradeLevel = "11",
        rootConcept = "පොදුකාර්ය පිරිවැය & මිල",
        pageSections = listOf(
          SanduCommerceSection(
            title = "නිෂ්පාදන පොදුකාර්ය පිරිවැය (Overheads)",
            definition = "නිෂ්පාදන ඒකකයට අදාලව පැහැදිලිව හඳුනාගත නොහැකි සමස්ත නිෂ්පාදනය වෙනුවෙන් දරන වියදම් නිෂ්පාදන පොදුකාර්ය පිරිවැයයි.",
            bullets = listOf(
              "1. වක්‍ර ද්‍රව්‍ය පිරිවැය (Indirect Materials): නිෂ්පාදන ඒකකයට අදාල සෘජුවම හඳුනාගත නොහැකි ද්‍රව්‍ය සඳහා දරන වියදම් (නූල්, ඇණ, ගම්, ලිහිසි තෙල්).",
              "2. වක්‍ර ශ්‍රම පිරිවැය (Indirect Labour): නිෂ්පාදන කටයුත්තකට සෘජුවම සම්බන්ධ කළ නොහැකි ශ්‍රමය සඳහා දරන වියදම් (කර්මාන්තශාලා සුපරීක්ෂක වැටුප්, පිරිසිදු කරන්නන්ගේ වැටුප්).",
              "3. වෙනත් වක්‍ර වියදම් (Indirect Expenses): නිෂ්පාදන ඒකකයට ඍජුවම සම්බන්ධ කළ නොහැකි අනෙකුත් වියදම් (කර්මාන්තශාලා විදුලිය, කුලී, යන්ත්‍ර ක්ෂයවීම්, කර්මාන්තශාලා රක්ෂණය)."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "නිෂ්පාදිතයක මිල නියම කිරීමේදී සලකා බලන ප්‍රධාන සාධක 4",
            bullets = listOf(
              "භාණ්ඩය සඳහා පවතින ඉල්ලුම (Demand)",
              "වෙළඳපොළ තුළ පවතින සමාන හා ආදේශන භාණ්ඩවල මිල ගණන් (Competitors' pricing)",
              "ආයතනයේ මිල කිරීමේ අරමුණු හා පරමාර්ථ (Profit margin, Market penetration)",
              "නීතිමය සාධක හා වෙනත් සාධක (රජයේ උපරිම සිල්ලර මිල, බදු)"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 72
      SanduCommercePageItem(
        pageNumber = 72,
        chapterNumber = 26,
        chapterTitleSinhala = "පැතුරුම්පත් (Excel) සහ ආයෝජනය හැඳින්වීම",
        gradeLevel = "11",
        rootConcept = "Excel පිරිවැය & ආයෝජනය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "පරිගණක පැතුරුම්පත් (Excel) භාවිතයෙන් පිරිවැය ලේඛන සකස් කිරීමේ පියවර",
            bullets = listOf(
              "1. පරිගණක Excel Worksheet එකක් විවෘත කර ගැනීම.",
              "2. එහි පිරිවැය ලේඛනයක් සකස් කර ගැනීම.",
              "3. ප්‍රාථමික පිරිවැය හා නිෂ්පාදන පොදු කාර්ය පිරිවැයේ මුළු එකතුව ලබාගැනීමට (∑) හෝ (=SUM) විධානයක් භාවිතා කිරීම.",
              "4. ඒකක පිරිවැය ගණනය කිරීම සඳහා මුළු පිරිවැය හා නිෂ්පාදිත ඒකක ගණන ඇතුළත් කර එය බෙදීමට අදාළ විධානය (උදා: =C10/C11) ලබා දීම."
            ),
            type = SanduCommerceSectionType.PROCESS_STEPS
          ),
          SanduCommerceSection(
            title = "ආයෝජනය (Investment) යනු කුමක්ද?",
            definition = "පුද්ගලයෙකු තමා උපයන ආදායමෙන් ඉතිරි කරගත් මුදල් ප්‍රමාණයක් යම් ආර්ථික ප්‍රතිලාභයක් අපේක්ෂාවෙන් ඵලදායී මාර්ගයකට යෙදවීම ආයෝජනයයි.",
            bullets = listOf(
              "ආයෝජන මාර්ගයක් තෝරා ගැනීමේදී සලකා බලන සාධක 3:\n   • ආයෝජනයෙහි අරමුණ\n   • ආයෝජනයෙහි අවදානම (Risk)\n   • ආයෝජනයෙන් ලැබෙන ප්‍රතිලාභ (Return)",
              "පුද්ගලයන්ට ආයෝජන සිදුකළ හැකි විවිධ මාර්ග 6:\n   • ඉතිරි කිරීමේ ගිණුමක මුදල් තැන්පත් කිරීම\n   • ස්ථාවර තැන්පතුවක් ආරම්භ කිරීම\n   • දේපල මිලදී ගැනීම\n   • කොටස්වල ආයෝජනය කිරීම\n   • භාණ්ඩාගාර බිල්පත්වල ආයෝජනය කිරීම\n   • තමාගේම (කුඩා) ව්‍යාපාරයක් ආරම්භ කර පවත්වාගෙන යාම"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 73
      SanduCommercePageItem(
        pageNumber = 73,
        chapterNumber = 27,
        chapterTitleSinhala = "ඉතුරුම්, ස්ථාවර තැන්පතු සහ දේපල ප්‍රතිලාභ",
        gradeLevel = "11",
        rootConcept = "ආයෝජන ප්‍රතිලාභ",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ඉතිරිකිරීමේ ගිණුමක මුදල් තැන්පත් කිරීමෙන් ලැබෙන ප්‍රතිලාභ",
            bullets = listOf(
              "තැන්පතු සඳහා පොලී ආදායමක් හිමි වීම",
              "මුදලට ඇති සුරක්ෂිත බව",
              "ඕනෑම මොහොතක මුදල් ආපසු ලබාගත හැකි ඉහළ ද්‍රවශීලතාව"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ස්ථාවර තැන්පතුවක මුදල් තැන්පත් කිරීමෙන් ලැබෙන ප්‍රතිලාභ",
            bullets = listOf(
              "ඉතුරුම් ගිණුමකට සාපේක්ෂව ඉහළ අනුපාතයක් යටතේ පොලී හිමි වීම.",
              "කල්පිරුණු පසු හෝ ඊට පෙර හෝ අවශ්‍ය නම් මුදල් ආපසු ලබාගත හැකි වීම.",
              "ස්ථාවර තැන්පතු සහතිකය ඇපයට තබා ණය මුදලක් ලබාගත හැකි වීම.",
              "සුරක්ෂිත ආයෝජන මාර්ගයක් වීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "දේපල මිලදී ගැනීම නිසා පුද්ගලයෙකුට ලැබෙන ප්‍රතිලාභ 5",
            bullets = listOf(
              "ස්ථාවර වත්කම් හිමිකරුවකු වීම නිසා දේපල පරිහරණය කිරීමේ හැකියාව ලැබීම.",
              "දේපල කුලියට හෝ බද්දට දීමෙන් හෝ උකස් කිරීමෙන් ආදායම් ඉපයිය හැකි වීම.",
              "මුදල් අවශ්‍යතාවයක් ඇති වුවහොත් දේපල විකුණා මුදල් ලබාගත හැකිවීම.",
              "මිලදී ගත් මුදලට වඩා වැඩි මුදලකට විකිණීමෙන් ප්‍රාග්ධන ලාභ (Capital Gain) ඉපයීමේ හැකියාව.",
              "ණය මුදලක් ලබා ගැනීමේදී ඇප සුරැකුම් ලෙස ඉදිරිපත් කළ හැකි වීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 74
      SanduCommercePageItem(
        pageNumber = 74,
        chapterNumber = 27,
        chapterTitleSinhala = "කොටස් වෙළඳපොළ සහ කොටස් හිමි ප්‍රතිලාභ",
        gradeLevel = "11",
        rootConcept = "කොටස් වෙළඳපොළ",
        pageSections = listOf(
          SanduCommerceSection(
            title = "කොටස් වෙළඳපොළ සහ කොටස",
            definition = "කොටස් වෙළඳපොළ: මිලකට පොදු සමාගම්වල කොටස් හෝ ණයකර මිලදී ගැනීම සහ විකිණීම සිදුකරන ස්ථානයකි (කොළඹ කොටස් හුවමාරුව - CSE).\n\nකොටස (Share): සමාගමක ආරම්භක ප්‍රාග්ධනය, ඒකකයක් ලෙස සලකා එය සමාන කොටස්වලට හෙවත් පංගුවලට බෙදූ විට ඉන් එක් පංගුවක් එක් කොටසක් ලෙස හැඳින්වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සාමාන්‍ය කොටස් හි ආයෝජනයෙන් ලැබෙන ප්‍රතිලාභ 6",
            bullets = listOf(
              "1. ඡන්ද බලය ලැබීම (සමාගමේ වාර්ෂික මහා සභා රැස්වීමේදී).",
              "2. ලාභාංශ ලැබීම (Dividends).",
              "3. ප්‍රාග්ධන ලාභ ලැබීම (කොටස් මිල ඉහළ ගිය විට විකිණීමෙන්).",
              "4. කොටස් අලෙවිකර මුදල් බවට පත්කර ගැනීමේ හැකියාව.",
              "5. ඇප සුරැකුම් ලෙස ඉදිරිපත් කිරීමේ හැකියාව.",
              "6. වෙනත් ප්‍රතිලාභ:\n   • අධ්‍යක්ෂක මණ්ඩලයට පත්වීමේ හැකියාව ලැබීම\n   • සමාගමට සම්බන්ධ තීරණ ගැනීමේ හැකියාව ලැබීම"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 75
      SanduCommercePageItem(
        pageNumber = 75,
        chapterNumber = 27,
        chapterTitleSinhala = "ලාභාංශ, ණයකර සහ භාණ්ඩාගාර බිල්පත්",
        gradeLevel = "11",
        rootConcept = "සුරැකුම්පත් ආයෝජනය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ලාභාංශ සහ ලාභාංශ බලපත්‍රය",
            bullets = listOf(
              "ලාභාංශ (Dividends): ලාභාංශයක් යනු සමාගමේ යම් කාලපරිච්ඡේදයක් තුළ උපයන ලද ශුද්ධ ලාභයෙන් කොටස් හිමියන්ට බෙදාහරින ලද ප්‍රමාණය වේ.",
              "ලාභාංශ බලපත්‍රය (Dividend Warrant): කිසියම් කාල සීමාවක් සඳහා කොටස් හිමියකුට ගෙවීමට නියමිතව තිබෙන ලාභාංශ ප්‍රමාණය දක්වමින් සීමාසහිත සමාගමක් විසින් නිල මුද්‍රාව සහිතව නිකුත් කරන හිමිකම් පත්‍රයකි."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ණයකර (Debentures)",
            definition = "ණයකර යනු ණය ප්‍රාග්ධනය ලබාගැනීම සඳහා සමාගමක් විසින් නිශ්චිත කාලයක් සඳහා නිශ්චිත පොලී අනුපාතිකයක් යටතේ නිකුත් කරනු ලබන සුරැකුම්පත් විශේෂයකි. (කොටස් හිමියන් මෙන් නොව ණයකර හිමියන් සමාගමේ ණයහිමියන් වේ).",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "භාණ්ඩාගාර බිල්පත් (Treasury Bills)",
            definition = "රජයට අවශ්‍ය වන කෙටිකාලීන මූල්‍ය අවශ්‍යතාවන් සපුරාගැනීම සඳහා මහා භාණ්ඩාගාරය වෙනුවෙන් ශ්‍රී ලංකා මහ බැංකුව විසින් නිකුත් කරනු ලබන සුරැකුම්පත් විශේෂයකි (දින 91, දින 182, දින 364 කල්පිරීම් සහිත).",
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 76
      SanduCommercePageItem(
        pageNumber = 76,
        chapterNumber = 27,
        chapterTitleSinhala = "භාණ්ඩාගාර බැඳුම්කර සහ SEC කොමිෂන් සභාව",
        gradeLevel = "11",
        rootConcept = "බැඳුම්කර & SEC කොමිෂන් සභාව",
        pageSections = listOf(
          SanduCommerceSection(
            title = "භාණ්ඩාගාර බිල්පත් හොඳ ආයෝජන මාර්ගයක් ලෙස සැලකීමට හේතු / ප්‍රතිලාභ 5",
            bullets = listOf(
              "වැඩි ඉපයීමක් (පොලියක් / වට්ටමක්) ලබා ගත හැකිවීම.",
              "සුරක්ෂිත (අවදානම් රහිත - Risk Free) ආයෝජනයක් වීම (රජයේ සහතිකය).",
              "කෙටිකාලීන ආයෝජන මාර්ගයක් වීම.",
              "ඉහළ ද්‍රවශීලතාව (ද්විතීයික වෙළඳපොළක් පැවතීම නිසා ඕනෑම විටෙක වට්ටම් කරගත හැකි වීම).",
              "බහුlayout කල්පිරීම් සහිත බිල්පත් ඇති නිසා කාලය අනුව ආයෝජනය කළ හැකි වීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "භාණ්ඩාගාර බැඳුම්කර (Treasury Bonds)",
            definition = "රජයට අවශ්‍ය මැදි හා දිගුකාලීන ණය ලබාගැනීම සඳහා රජය වෙනුවෙන් ශ්‍රී ලංකා මහා බැංකුව විසින් නිකුත් කරන නිර්ලේඛනගත සුරැකුම්පත් විශේෂයකි. මෙම බැඳුම්කර වර්ෂයකට අධික කාලයක් (අවුරුදු 2 සිට 30 දක්වා) සඳහා නිකුත් කරයි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ශ්‍රී ලංකා විනිමය හා සුරැකුම්පත් කොමිෂන් සභාවේ (SEC) අරමුණු 4",
            bullets = listOf(
              "1. සුරැකුම්පත් විධිමත් හා සාධාරණ ආකාරයකට නිකුත් කළ හැකි වූත් වෙළඳාම් කළ හැකි වූත් වෙළඳපොලක් බිහි කිරීම සහ පවත්වාගෙන යාම.",
              "2. සුරැකුම්පත් වෙළඳපොළ විධිමත් කිරීම සහ එහි වෘත්තීය ප්‍රමිතීන් පවත්වාගෙන යාම.",
              "3. ආයෝජකයින් ආරක්ෂා කිරීම.",
              "4. තැරැව්කරුවෙකු තම ගිවිසුම්ගත වගකීම් ඉටු කිරීමට අපොහොසත් වීම හේතු කොටගෙන ඇතිවන මුදල් අලාභ සම්බන්ධයෙන් ආයෝජකයින් ආරක්ෂා කිරීම පිණිස වූ වන්දි අරමුදලක් ක්‍රියාත්මක කිරීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      )
    )
  }
}
