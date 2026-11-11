package com.example

/**
 * Sandu Theory - O/L Commerce & Accounting (ව්‍යාපාර හා ගිණුම්කරණ අධ්‍යයනය)
 * Pages 1 to 28 (Part 1): ව්‍යාපාර සංකල්ප, පරිසරය සහ ව්‍යාපාර සංවිධාන
 */
object SanduCommerceTheoryPagesPart1 {

  val pages: List<SanduCommercePageItem> by lazy {
    listOf(
      // PAGE 1
      SanduCommercePageItem(
        pageNumber = 1,
        chapterNumber = 1,
        chapterTitleSinhala = "ව්‍යාපාරය සහ එහි සංවර්ධනය",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාරය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ව්‍යාපාරය යනු කුමක්ද?",
            definition = "මිනිස් අවශ්‍යතා හා වුවමනා ඉටුකරලන ඕනෑම කටයුත්තකි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාර සංස්කෘතිය",
            definition = "ව්‍යාපාරයක දැනට සිටින අයිතිකරුවන්, කළමනාකරුවන්, සේවකයින් නැතහොත් සාමාජිකයින් කටයුතු කිරීමේ හොඳම ක්‍රමය සමස්තයක් වශයෙන් පිළිගැනීම.",
            examples = listOf("ආකල්ප", "විශ්වාස", "චාරිත්‍ර වාරිත්‍ර", "සම්ප්‍රදායන්"),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාරවල ඓතිහාසික සංවර්ධනයේ ප්‍රධාන අදියර 04",
            bullets = listOf(
              "භාණ්ඩ හුවමාරුව (Barter System)",
              "මුදල් භාවිතය (Use of Money)",
              "කාර්මික විප්ලවය / මහා පරිමාණ නිෂ්පාදනය (Industrial Revolution)",
              "තොරතුරු තාක්ෂණය / විද්‍යුත් වාණිජ්‍යය (E-Commerce & IT)"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "වාණිජ්‍යය යනු කුමක්ද?",
            definition = "භාණ්ඩ හා සේවා නිෂ්පාදනයේ සිට පාරිභෝගිකයා අතට පත්වන තෙක් මුළු මහත් ක්‍රියාවලිය වාණිජ්‍යය යි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාර අරමුණ",
            definition = "ආයතනයක් දිගු කාලයේදී ළඟා කර ගැනීමට අපේක්ෂා කරන තත්ත්වයකි / ප්‍රතිඵලයකි. එය බොහෝවිට පුළුල් ආකාරයට ප්‍රකාශ කරයි.",
            examples = listOf("පාරිභෝගික තෘප්තිය", "වෙළඳපොළ නායකත්වය", "දිගුකාලීන පැවැත්ම"),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        ),
        examKeyPoints = listOf("ව්‍යාපාරයක මූලික පදනම වන්නේ මිනිස් අවශ්‍යතා හා වුවමනා තෘප්තිමත් කිරීමයි.")
      ),

      // PAGE 2
      SanduCommercePageItem(
        pageNumber = 2,
        chapterNumber = 1,
        chapterTitleSinhala = "අවශ්‍යතා සහ වුවමනා",
        gradeLevel = "10",
        rootConcept = "අවශ්‍යතා සහ වුවමනා",
        pageSections = listOf(
          SanduCommerceSection(
            title = "මිනිස් අවශ්‍යතා (Needs)",
            definition = "ජීවත්වීම සඳහා මිනිසා විසින් අනිවාර්යයෙන් ම සපුරා ගත යුතු දෑ මිනිස් අවශ්‍යතා ය.",
            examples = listOf("ආහාර", "ඇඳුම් හා නිවාස", "අධ්‍යාපනය", "සෞඛ්‍යය", "ආරක්ෂාව", "ප්‍රවාහනය", "සන්නිවේදනය"),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "අවශ්‍යතාවල ලක්ෂණ",
            bullets = listOf(
              "අත්‍යවශ්‍ය වීම (Essential)",
              "පොදු වීම (Common to all)",
              "නිර්මාණය කළ නොහැකි වීම (Cannot be created)",
              "සීමිත වීම (Limited in number)"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "මිනිස් වුවමනා (Wants)",
            definition = "මිනිස් අවශ්‍යතා සපුරා ගන්නා විවිධ ආකාර වුවමනා ලෙස හැඳින්වේ.",
            bullets = listOf(
              "අත්‍යවශ්‍ය නොවීම (Not essential for survival)",
              "විවිධ වීම (Diverse)",
              "නිර්මාණය කළ හැකි වීම (Can be created by marketers)",
              "සංකීර්ණ වීම (Complex)",
              "අසීමිත වීම (Unlimited)"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "මිනිස් අවශ්‍යතා හා වුවමනා අතර සැසඳීම",
            bullets = listOf(
              "අවශ්‍යතා සීමිත වන අතර වුවමනා අසීමිත වේ.",
              "අවශ්‍යතා පදනම් කොටගෙන වුවමනා බිහි වේ.",
              "අවශ්‍යතා සියල්ල අත්‍යවශ්‍ය වන අතර වුවමනා සියල්ල අත්‍යවශ්‍ය නොවේ.",
              "අවශ්‍යතා පොදුය, නමුත් වුවමනා සංකීර්ණය.",
              "අලෙවිකරුවන්ට අවශ්‍යතා නිර්මාණය කළ නොහැකිය. නමුත් ඔවුන් වුවමනා නිර්මාණය කරති."
            ),
            type = SanduCommerceSectionType.COMPARISON
          )
        )
      ),

      // PAGE 3
      SanduCommercePageItem(
        pageNumber = 3,
        chapterNumber = 1,
        chapterTitleSinhala = "භාණ්ඩ නිෂ්පාදන ව්‍යාපාර සහ නිෂ්පාදන සාධක",
        gradeLevel = "10",
        rootConcept = "භාණ්ඩ නිෂ්පාදන ව්‍යාපාර",
        pageSections = listOf(
          SanduCommerceSection(
            title = "භාණ්ඩ සහ භාණ්ඩ නිෂ්පාදන ව්‍යාපාර",
            definition = "මිනිස් අවශ්‍යතා හා වුවමනා සපුරාලීම සඳහා ස්පර්ශ කළ හැකි භෞතික පැවැත්මක් ඇති දෑ භාණ්ඩ ලෙස හඳුන්වන අතර භාණ්ඩ නිෂ්පාදන ආයතන, භාණ්ඩ නිෂ්පාදන ව්‍යාපාර වේ.",
            examples = listOf("මෝටර් රථ", "විදුලි උපකරණ", "ජංගම දුරකතන"),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "නිෂ්පාදන සාධක 4 (Factors of Production)",
            definition = "භාණ්ඩ හා සේවා නිෂ්පාදනය කිරීම සඳහා ව්‍යාපාර වලට අවශ්‍ය වන විවිධ සම්පත් නිෂ්පාදන සාධක ලෙස හැඳින්වේ.",
            bullets = listOf(
              "1. භූමිය (Land): ස්වභාවධර්මයෙන් ලැබී ඇති සියලු සම්පත්.",
              "2. ශ්‍රමය (Labour): ව්‍යාපාර සඳහා යොදන කායික හා මානසික දායකත්වය.",
              "3. ප්‍රාග්ධනය (Capital): නිෂ්පාදනයේ දී ආධාර කරගන්නා මිනිසා විසින් සකස් කරන ලද දෑ (යන්ත්‍ර සූත්‍ර, ගොඩනැගිලි).",
              "4. ව්‍යවසාය (Enterprise): නිෂ්පාදනයට අවශ්‍ය භූමිය, ශ්‍රමය, ප්‍රාග්ධනය යන සාධක සංවිධාන කරමින් යම් නිෂ්පාදන ක්‍රියාවලියක් ආරම්භ කර පවත්වා ගෙන යාමේ කාර්යය යි."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "නිෂ්පාදනය සඳහා යොදාගැනෙන සම්පත් කොටස් 2",
            bullets = listOf(
              "1. මානව සම්පත් (Human Resources): ශ්‍රමය සහ ව්‍යවසාය",
              "2. භෞතික සම්පත් (Physical Resources): භූමිය සහ ප්‍රාග්ධනය"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 4
      SanduCommercePageItem(
        pageNumber = 4,
        chapterNumber = 2,
        chapterTitleSinhala = "සේවා සැපයීමේ ව්‍යාපාර සහ ඇල්මැති පාර්ශව",
        gradeLevel = "10",
        rootConcept = "සේවා සැපයීමේ ව්‍යාපාර",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සේවා සැපයීමේ ව්‍යාපාර",
            definition = "ව්‍යාපාරයක් විසින් පාරිභෝගික අවශ්‍යතා හා වුවමනා සපුරාලීම සඳහා පාරිභෝගිකයන් වෙත ලබාදෙන ක්‍රියාවක් හෝ ක්‍රියාවලියක් සේවා ලෙස හඳුන්වයි. එසේ සේවා සපයන ආයතන, සේවා නිෂ්පාදන ව්‍යාපාර නම් වේ.",
            examples = listOf("රක්ෂණ ආයතන", "බැංකු ආයතන", "රූපලාවන්‍ය ආයතන"),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ඔබේ පාසලට අවශ්‍ය සේවාවන්",
            bullets = listOf(
              "ගුරු සේවය",
              "විදුලිය",
              "ප්‍රවාහනය",
              "නඩත්තුව හා ආරක්ෂාව",
              "සනීපාරක්ෂක සේවා",
              "බිම් සැකසුම් හා ජලය",
              "දුරකතන / සන්නිවේදන / තැපැල් පහසුකම්"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ඇල්මැති පාර්ශවයන් හා ඇල්ම දැක්වීමට හේතු (Stakeholders)",
            bullets = listOf(
              "අයිතිකරුවෝ: ආයෝජනයේ සුරක්ෂිතතාවය, ප්‍රමාණවත් ලාභයක් ලැබීම, ව්‍යාපාරයේ අනාගත වර්ධනය.",
              "කළමනාකරුවෝ: ව්‍යාපාර අරමුණු ඉටුකර ගැනීමට අවශ්‍ය කළමනාකරණ තීරණ ගැනීම හා ක්‍රියාත්මක කිරීම, රැකියා වර්ධනය හා රැකියා තෘප්තිය.",
              "සේවකයෝ: සාධාරණ වැටුප් ලබාගැනීම, රැකියා සුරක්ෂිත බව.",
              "ගනුදෙනුකරුවෝ: නිෂ්පාදිත සාධාරණ මිලට ලබාගැනීම, ගුණාත්මක නිෂ්පාදිත ලබාගැනීම.",
              "සැපයුම්කරුවෝ: අඛණ්ඩ ව ඇණවුම් ලබාගැනීම, නිසි පරිදි මුදල් ලබාගැනීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 5
      SanduCommercePageItem(
        pageNumber = 5,
        chapterNumber = 2,
        chapterTitleSinhala = "ඇල්මැති පාර්ශවයන්ගේ අපේක්ෂිත දායකත්වය",
        gradeLevel = "10",
        rootConcept = "ඇල්මැති පාර්ශවයන්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "බාහිර ඇල්මැති පාර්ශව හා ඇල්ම දැක්වීමට හේතු",
            bullets = listOf(
              "මූල්‍ය ආයතන: දෙන ලද ණය අයකර ගැනීම, තවදුරටත් ණය සැපයීම.",
              "රජය: ලැබිය යුතු බදු ආදායම් නිසි ලෙස ලබාගැනීම, රැකියා අවස්ථා උත්පාදනය, ජාතික නිෂ්පාදිතය වර්ධනය කරගැනීම.",
              "තරගකරුවෝ: තම නිෂ්පාදිතවල මිල තීරණය කිරීම, තරඟයට මුහුණ දීම.",
              "ප්‍රජාව: පරිසරයට හිතකර ලෙස ව්‍යාපාර කටයුතු පවත්වාගෙන යන්නේ දැයි විමසා බැලීම, සමාජ සුභසාධනයට දායක වන්නේ දැයි විමසා බැලීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ඇල්මැති පාර්ශව මඟින් ව්‍යාපාර අපේක්ෂිත දායකත්වය",
            bullets = listOf(
              "අයිතිකරුවෝ: ප්‍රමාණවත් ප්‍රාග්ධන දායකත්වයක් ලබාදීම, උනන්දුව හා කැපවීම, ව්‍යාපාර කටයුතු සුපරීක්ෂණය.",
              "කළමනාකරුවෝ: ව්‍යාපාර සැලසුම් නිසි ලෙස ක්‍රියාත්මක කිරීම, නිවැරදි තීරණ ගැනීම.",
              "සේවකයෝ: පවරන ලද කාර්යය නිසි ලෙස ඉටු කිරීම, ශ්‍රම ඵලදායීතාව වැඩි කිරීම.",
              "සැපයුම්කරුවෝ: අඛණ්ඩ ව ඇණවුම් ලබා ගැනීම, නිසි පරිදි මුදල් ලබා ගැනීම, ගුණාත්මක අමුද්‍රව්‍ය දිගින් දිගටම සැපයීම, කලට වේලාවට අමුද්‍රව්‍ය සැපයීම.",
              "රජය: ව්‍යාපාර සඳහා හිතකර විවිධ දිරිගැන්වීම් ලබාදීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 6
      SanduCommercePageItem(
        pageNumber = 6,
        chapterNumber = 3,
        chapterTitleSinhala = "ව්‍යාපාර පරිසරය සහ අභ්‍යන්තර පරිසරය",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාර පරිසරය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ව්‍යාපාර පරිසරය යනු කුමක්ද?",
            definition = "ව්‍යාපාරයක් තම ව්‍යාපාර කටයුතු කරගෙන යාමේදී ඔවුන් ක්‍රියාත්මක වන බල ප්‍රදේශය, ව්‍යාපාර පරිසරය යි. පරිසරය යනු මිනිසුන්ගේ හා සමාජයේ ජීවන රටාවන් හා තත්ත්වයන් තීරණය වීම කෙරෙහි සංකීර්ණ ලෙස අන්තර් සබඳතා (Inter relationship) දක්වන මූලිකාංගවල එකතුවකි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාර අභ්‍යන්තර පරිසරය",
            definition = "ව්‍යාපාරයේ අයිතිකරුවන්ට හෝ කළමනාකරුවන්ට පාලනය කළ හැකි බාහිර පරිසරයේ සිදුවන වෙනස්කම් වලට අනුව වෙනස් කර ගත යුතු ව්‍යාපාරය හා සම්බන්ධිත සමීප පරිසරය, ව්‍යාපාර අභ්‍යන්තර පරිසරය යි. ව්‍යාපාරයේ ක්‍රියාකාරිත්වයට බලපාන, ව්‍යාපාරය තුළ ක්‍රියාත්මක වන විවිධ පාර්ශව සහ ව්‍යාපාරය තුළ පවතින අනෙකුත් සාධක අභ්‍යන්තර පරිසරය යි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාර අභ්‍යන්තර පරිසරය හා සම්බන්ධිත පාර්ශව 3",
            bullets = listOf(
              "අයිතිකරුවෝ (Owners): ව්‍යාපාරයට අවශ්‍ය ප්‍රාග්ධනය යොදවන පුද්ගලයෝ අයිතිකරුවෝ වෙති. ඔවුන්ගේ මූල්‍ය ශක්තිය, ව්‍යාපාර දැනුම හා පළපුරුද්ද ආදිය ව්‍යාපාරයක සාර්ථකත්වයට හේතු වේ.",
              "කළමනාකරුවෝ (Managers): ව්‍යාපාරයක අයිතිකරුවන්ගේ අරමුණු ඉටු කර ගැනීම සඳහා ව්‍යාපාරය සතු සම්පත් මෙහෙයවීමට අවශ්‍ය තීරණ ගන්නා පුද්ගලයින් කළමනාකරුවන් ය.",
              "සේවකයෝ (Employees): තම දක්ෂතාව හා හැකියාව ප්‍රයෝජනයට ගනිමින් පවරන ලද කාර්යය නිසි ආකාරයෙන් ඉටුකරන පුද්ගලයෝ සේවකයින් ය."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 7
      SanduCommercePageItem(
        pageNumber = 7,
        chapterNumber = 3,
        chapterTitleSinhala = "ව්‍යාපාරයක ශක්තීන් හා දුර්වලතා (SWOT)",
        gradeLevel = "10",
        rootConcept = "ශක්තීන් හා දුර්වලතා",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ව්‍යාපාරයකට ඇති ශක්තීන් (Strengths)",
            bullets = listOf(
              "ව්‍යාපාරයේ තරම / ප්‍රමාණය (උදා: විශාල ව්‍යාපාරයක්)",
              "භාණ්ඩ හා සේවාවල ගුණත්වය (උදා: ප්‍රමිති සහතික ලබා ගැනීම)",
              "දක්ෂ කළමනාකරණය",
              "පුහුණු සේවකයින්",
              "මූල්‍ය ස්ථාවරත්වය / මූල්‍ය ශක්තිය",
              "ව්‍යාපාරික ස්ථානයේ පිහිටීම",
              "භාවිතා කරන උසස් තාක්ෂණය",
              "උසස් පාරිභෝගික සේවය / පාරිභෝගික තෘප්තිය",
              "සන්නම් නාමය / ප්‍රසිද්ධිය / කීර්තිනාමය හා ප්‍රතිරූපය",
              "සාධාරණ මිල ගණන්",
              "විශාල වෙළඳපොළ කොටස",
              "ලාභදායිත්වය",
              "සේව්‍ය සේවක සම්බන්ධතා",
              "නිවැරදි සන්නිවේදනය"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාරයක දැකිය හැකි දුර්වලතා (Weaknesses)",
            bullets = listOf(
              "දුර්වල / අදක්ෂ කළමනාකරණය",
              "නුපුහුණු සේවකයින්",
              "මූල්‍ය අස්ථාවරත්වය",
              "පාරිභෝගික අතෘප්තිය / විරෝධය",
              "පැරණි / අකාර්යක්ෂම තාක්ෂණය",
              "ව්‍යාපාරයේ තරම කුඩා වීම",
              "අලාභ ලැබීම හා අපකීර්තිය",
              "දුර්වල පාරිභෝගික සේවය හා කුඩා වෙළඳපොළ කොටස",
              "දුර්වල සන්නිවේදනය හා පරිපාලන දුර්වලතා",
              "අසාධාරණ මිල ගණන්",
              "ව්‍යාපාරික ස්ථානයේ දුර්වල පිහිටීම",
              "යල්පැනගිය භාණ්ඩ / ගුණත්වයෙන් අඩු භාණ්ඩ",
              "සේවක ගැටලු / වෘත්තීය සමිති ආරවුල්"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 8
      SanduCommercePageItem(
        pageNumber = 8,
        chapterNumber = 3,
        chapterTitleSinhala = "ව්‍යාපාරයක බාහිර පරිසරය",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාරයක බාහිර පරිසරය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "බාහිර පරිසරය යනු කුමක්ද?",
            definition = "ආයතනයකට, ආයතනයේ අයිතිකරුවන්ට හෝ කළමනාකරුවන්ට කිසිසේත් පාලනය කළ නොහැකි පරිසරය, ව්‍යාපාරයක බාහිර පරිසරය යි. පාරිසරික අවස්ථා (Opportunities) හා තර්ජන (Threats) මෙම පරිසරය අධ්‍යයනය කිරීමෙන් හඳුනාගත හැකිය.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "බාහිර පරිසරය හා සම්බන්ධිත ප්‍රධාන පාර්ශව",
            bullets = listOf(
              "ගනුදෙනුකරුවෝ (Customers): ව්‍යාපාරයක භාණ්ඩ හා සේවා මිලදී ගන්නන් ගනුදෙනුකරුවන් ය. ව්‍යාපාරයක පැවැත්ම රඳා පවතින්නේ ගනුදෙනුකරුවන් මත ය. ඒ නිසා ඔවුන්ගේ විවිධ අවශ්‍යතා සහ වුවමනා හඳුනා ගනිමින් ඒවා නිසි පරිදි ඉටු කිරීමට ව්‍යාපාරිකයින් ක්‍රියා කළ යුතුය.",
              "තරගකරුවෝ (Competitors): ව්‍යාපාරයක භාණ්ඩ හෝ සේවාවලට සමාන භාණ්ඩ හෝ සේවා නිෂ්පාදනය කරන ආයතන තරගකරුවන් ලෙස සැලකේ. තරගකරුවන් තම ව්‍යාපාර කටයුතු මෙහෙයවන ආකාරය, තරගකරුවන්ගේ මිල, ගුණාත්මක බව හා අලෙවි උපක්‍රම ව්‍යාපාරවලට ආසන්නතම බලපෑම් ඇති කරයි.",
              "සැපයුම්කරුවෝ (Suppliers): ව්‍යාපාරයක් පවත්වාගෙන යාමේදී අවශ්‍ය වන අමුද්‍රව්‍ය හා ප්‍රවාහන පහසුකම් ආදී සේවා සපයන පාර්ශවයන් සැපයුම්කරුවන් ය. ඔවුන් විසින් සපයන අමුද්‍රව්‍ය අඛණ්ඩව කලට වේලාවට ලබා ගැනීම හා ගුණාත්මක බව ව්‍යාපාරයට අතිශය වැදගත් වේ."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 9
      SanduCommercePageItem(
        pageNumber = 9,
        chapterNumber = 4,
        chapterTitleSinhala = "දේශපාලන, නෛතික සහ තාක්ෂණික පරිසරය",
        gradeLevel = "10",
        rootConcept = "බාහිර පරිසර සාධක",
        pageSections = listOf(
          SanduCommerceSection(
            title = "දේශපාලන පරිසරය (Political Environment)",
            definition = "රටක රජය විසින් ආර්ථික කටයුතු මෙහෙයවීමේ දී අනුගමනය කරන ප්‍රතිපත්ති ව්‍යාපාර සඳහා බලපෑම් ඇති කරයි. මෙම ප්‍රතිපත්ති පිළිබඳ සැලකිලිමත් වෙමින් ව්‍යාපාරිකයන් තම ව්‍යාපාර කටයුතු මෙහෙයවිය යුතුය.",
            examples = listOf("යටිතල පහසුකම් සැපයීම", "සංවර්ධන ප්‍රතිපත්ති", "බදු සහන සහ ආනයන අපනයන නීති"),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "නෛතික පරිසරය (Legal Environment)",
            definition = "පාරිභෝගිකයා, දේශීය නිෂ්පාදකයා, ව්‍යාපාරික ප්‍රජාව මෙන්ම පරිසරය ආරක්ෂා කිරීම වෙනුවෙන් සම්මත කරගෙන ඇති අණපනත් හා නීතිරීති නෛතික පරිසරයට අයිති වේ.",
            bullets = listOf(
              "2007 අංක 07 දරණ සමාගම් පනත (Companies Act No. 07 of 2007)",
              "2003 අංක 09 දරණ පාරිභෝගික කටයුතු පිළිබඳ අධිකාරී පනත (Consumer Affairs Authority Act)"
            ),
            type = SanduCommerceSectionType.LEGAL_ACTS
          ),
          SanduCommerceSection(
            title = "තාක්ෂණික පරිසරය (Technological Environment)",
            definition = "නව සොයාගැනීම් හා නව නිර්මාණ, පරිගණක තාක්ෂණයේ දියුණුව, අන්තර්ජාලය සහ සන්නිවේදන තාක්ෂණයේ දියුණුව, නැනෝ තාක්ෂණය හා ඩිජිටල් තාක්ෂණය සොයාගැනීමෙන් සිදු වූ නිෂ්පාදන ක්‍රමවල දියුණුව මෙන්ම ප්‍රවාහන තාක්ෂණයේ දියුණුව නිසා ව්‍යාපාර පරිසරයේ විශාල වෙනස්කම් සිදුවෙමින් පවතී.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 10
      SanduCommercePageItem(
        pageNumber = 10,
        chapterNumber = 4,
        chapterTitleSinhala = "තාක්ෂණික වෙනස්වීම් සහ ආර්ථික පරිසරය",
        gradeLevel = "10",
        rootConcept = "තාක්ෂණික වෙනස්වීම්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "තාක්ෂණික වෙනස්වීම් නිසා ව්‍යාපාරවල සිදු වූ වෙනස්කම් 5",
            bullets = listOf(
              "1. නිෂ්පාදනය: අතීතයේ සරල අත් යන්ත්‍ර වෙනුවට වර්තමානයේ අති නවීන පරිගණකගත යන්ත්‍රසූත්‍ර යොදාගනිමින් කෙටි කලකින්, උසස් ගුණත්වයෙන්, අඩු පිරිවැයකින් නිෂ්පාදනය කිරීම.",
              "2. ලිපි ගනුදෙනු: අතීතයේ සාමාන්‍ය තැපෑල වෙනුවට වර්තමානයේ විද්‍යුත් තැපෑල (E-mail) භාවිතය.",
              "3. වෙළඳ දැන්වීම්: අතීතයේ තැපැල් ලිපිනය වෙනුවට වර්තමානයේ දුරකතන අංක, ඊමේල් හා වෙබ් අඩවි ලිපින ඉදිරිපත් කිරීම.",
              "4. ගිණුම්කරණය: අතීතයේ පොත්පත්වල තැබූ ගිණුම් වෙනුවට වර්තමානයේ පරිගණක හා තොරතුරු පද්ධති භාවිත කිරීම.",
              "5. ශ්‍රමය: අතීතයේ මිනිස් ශ්‍රමය පමණක් භාවිත කළ නිෂ්පාදන වෙනුවට ස්වයංක්‍රීය පරිගණකගත යන්ත්‍ර සූත්‍ර මඟින් කටයුතු සිදුකිරීම."
            ),
            type = SanduCommerceSectionType.COMPARISON
          ),
          SanduCommerceSection(
            title = "ආර්ථික පරිසරය (Economic Environment)",
            definition = "ආර්ථික පරිසරය යනු ව්‍යාපාර කෙරෙහි බලපාන ආර්ථික සාධක ඇතුළත් පරිසරය යි. රටක ආර්ථික ප්‍රතිපත්ති තීරණය කිරීමේදී ප්‍රධාන වශයෙන් රජය මැදිහත් වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 11
      SanduCommercePageItem(
        pageNumber = 11,
        chapterNumber = 4,
        chapterTitleSinhala = "ප්‍රධාන ආර්ථික සාධක 7",
        gradeLevel = "10",
        rootConcept = "ආර්ථික සාධක",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ආර්ථික සාධක (Economic Factors)",
            bullets = listOf(
              "පොලී අනුපාතය: බැංකු විසින් තැන්පතු සඳහා ලබාදෙන හා ණය සඳහා අය කරන පොලී අනුපාතයයි.",
              "උද්ධමනය (Inflation): භාණ්ඩ හා සේවා අලෙවියේ දී තීරණය වන පොදු මිල ගණන් අඛණ්ඩව ඉහළ යාම උද්ධමනය යි.",
              "ආදායම් ව්‍යාප්තිය: රටක ජාතික ආදායම එරට ජනතාව අතර බෙදීගොස් ඇති ආකාරය යි.",
              "රැකියා නියුක්තිය: රටක රැකියා අපේක්ෂා කරන සියලු දෙනාටම ගැලපෙන රැකියාවක් ලැබේ නම් එය පූර්ණ රැකියා නියුක්තියක් ලෙස හඳුන්වයි.",
              "ජාත්‍යන්තර සබඳතා: රටක් තවත් රටක් සමග පවත්වන සබඳතා ජාත්‍යන්තර සබඳතා ලෙස හැඳින්වෙයි. වෙළඳ කලාප, වෙළඳ ගිවිසුම් ආදිය මඟින් ඇති වේ.",
              "විදේශ විනිමය අනුපාතය: යම් රටක මුදල් ඒකකයක් තවත් රටක මුදල් ඒකක සමඟ හුවමාරු වන අනුපාතය යි.",
              "ඉතුරුම්: පුද්ගලයන් තම ආදායමෙන් පරිභෝජනය සඳහා වැය නොකොට තබාගන්නා කොටසයි. රටක ඉතුරුම් වර්ධනය වන විට ආයෝජනයට මුදල් ඉහළ යයි."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 12
      SanduCommercePageItem(
        pageNumber = 12,
        chapterNumber = 4,
        chapterTitleSinhala = "ව්‍යාපාරවලට බලපාන සාධක සහ තර්ජන (බාධක)",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාරික බලපෑම්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "බාහිර පරිසරයේ ඇති ව්‍යාපාරයට බලපෑම් කරන සාධක 10",
            bullets = listOf(
              "සමාජ හා සංස්කෘතික පරිසරය",
              "තාක්ෂණික පරිසරය",
              "ආර්ථික පරිසරය",
              "අධ්‍යාපනික පරිසරය",
              "දේශපාලන පරිසරය",
              "නෛතික පරිසරය",
              "ස්වාභාවික පරිසරය",
              "ගෝලීය පරිසරය",
              "ව්‍යාපාර ආචාර ධර්ම පරිසරය",
              "තරගකාරීත්ව පරිසරය"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාරවලට බලපාන තර්ජන (බාධක)",
            bullets = listOf(
              "තාක්ෂණික වෙනස්කම්",
              "දේශපාලන අස්ථාවරත්වය",
              "යුදමය හෝ ගැටුම්කාරී වාතාවරණය",
              "දැඩි තරගකාරීත්වය",
              "වෙළඳපොළ හා පාරිභෝගික වෙනස්කම්",
              "දැඩි නීතිරීති හා අන්තර්ජාතික බලපෑම්",
              "අයහපත් ආර්ථිකය",
              "ගෝලීයකරණ වෙනස්කම්",
              "ස්වාභාවික ආපදා",
              "වෘත්තීය සමිති ගැටලු / සේවක අරගල",
              "සමාජ සංස්කෘතික සහ ප්‍රජා විද්‍යාත්මක වෙනස්කම්"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 13
      SanduCommercePageItem(
        pageNumber = 13,
        chapterNumber = 4,
        chapterTitleSinhala = "වෙළඳපොළ අවස්ථා සහ පරිසර අධ්‍යයනයේ වැදගත්කම",
        gradeLevel = "10",
        rootConcept = "වෙළඳපොළ අවස්ථා",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ව්‍යාපාරයකට වෙළඳපොළ තුළින් මතුවන ව්‍යාපාරික අවස්ථාවන්",
            bullets = listOf(
              "තාක්ෂණික වෙනස්කම්වල වාසි ලබාගැනීම",
              "ගෝලීයකරණය මඟින් විදේශ වෙළඳපොළ විවෘත වීම",
              "දැඩි තරගකාරීත්වයට නවෝත්පාදන මඟින් මුහුණ දීම",
              "සන්නිවේදනයේ දියුණුව",
              "සමාජ සංස්කෘතික වෙනස්කම්",
              "කාන්තාවන්ගේ ජනගහනය හා කාන්තාවන් රැකියාවල නිරත වීම ඉහළ යාම",
              "ළමා හා වයස්ගත ජනගහනය ඉහළ යාම නිසා නව භාණ්ඩ සඳහා ඉල්ලුම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාරයකට එහි පරිසරය අධ්‍යයනය කිරීමේ වැදගත්කම",
            bullets = listOf(
              "සෑම ව්‍යාපාරයකටම එහි අභ්‍යන්තර හා බාහිර පරිසර සාධක යහපත් හෝ අයහපත් ලෙස බලපෑම් ඇති කරයි. එම තත්ත්වයන් හඳුනා ගැනීම සඳහා පරිසර විශ්ලේෂණයක නිරත විය යුතුය.",
              "අභ්‍යන්තර පරිසරය අධ්‍යයනය කිරීම තුළින් ව්‍යාපාරයේ ශක්තීන් (Strengths) හා දුර්වලතා (Weaknesses) හඳුනාගෙන, ශක්තීන් වර්ධනයට යොදාගෙන දුර්වලතා අවම කළ හැක.",
              "බාහිර පරිසරය අධ්‍යයනය කිරීම තුළින් ව්‍යාපාරික අවස්ථා (Opportunities) හා තර්ජන (Threats) හඳුනාගෙන අවස්ථා උපරිම කර තර්ජනවලට සාර්ථකව මුහුණ දිය හැක."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 14
      SanduCommercePageItem(
        pageNumber = 14,
        chapterNumber = 5,
        chapterTitleSinhala = "ගෝලීයකරණය සහ ව්‍යාපාරික බලපෑම්",
        gradeLevel = "10",
        rootConcept = "ගෝලීය පරිසරය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ගෝලීයකරණය (Globalization)",
            definition = "ගෝලීයකරණය යනු ව්‍යාපාර අතර ඇති බාධක ඉවත් කර ලෝකය තනි වෙළඳපොළක් බවට පත්වීමේ ප්‍රවණතාවය යි. නැතහොත් විදේශ වෙළඳාම, ආයෝජන, තාක්ෂණය, සන්නිවේදනය, මූල්‍ය වෙළඳපොළ යනාදී කරුණු මඟින් රටවල් ලෝක ආර්ථිකයට ඒකාබද්ධ වීම, ආර්ථිකයන් වඩාත් විවෘත වීම සහ ආර්ථිකයන් අතර අන්තර් රැඳියාව වැඩිවීමයි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "දේශීය ව්‍යාපාර සඳහා සිදුවන හිතකර බලපෑම් (වාසි)",
            bullets = listOf(
              "නවීන තාක්ෂණය ලබාගත හැකි වීම",
              "ගුණාත්මක විදේශීය අමුද්‍රව්‍ය ලබාගත හැකි වීම",
              "කාර්යක්ෂම යන්ත්‍ර සූත්‍ර ලබාගත හැකි වීම",
              "විදේශීය ප්‍රාග්ධනය රට තුළට ගලා ඒම",
              "දේශීය භාණ්ඩ හා සේවා සඳහා විදේශ වෙළඳපොළ ලබාගත හැකි වීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "දේශීය ව්‍යාපාර සඳහා සිදුවන අහිතකර බලපෑම් (අවාසි)",
            bullets = listOf(
              "දැඩි ජාත්‍යන්තර තරගකාරීත්වයට මුහුණ දීමට සිදුවීම",
              "දේශීය පුහුණු ශ්‍රමය විදේශීය රටවලට ඇදී යාම (Brain Drain)",
              "කුඩා දේශීය ව්‍යාපාරවල පැවැත්ම අස්ථාවර වීම",
              "දේශීය සංස්කෘතියේ අයහපත් වෙනස්කම් ඇතිවීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 15
      SanduCommercePageItem(
        pageNumber = 15,
        chapterNumber = 6,
        chapterTitleSinhala = "ව්‍යාපාර සංවිධාන සහ බිහිවීමට හේතු",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාර සංවිධානය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සංවිධානය සහ ව්‍යාපාර සංවිධානය",
            definition = "සංවිධානය: යම් කටයුත්තක් අපේක්ෂා කරන ආකාරයට ඉටුකර ගැනීම සඳහා පුද්ගලයින් ඒකරාශී වී පිහිටුවා ගන්නා ඒකකයකි.\n\nව්‍යාපාර සංවිධානය: මිනිස් අවශ්‍යතා හා වුවමනා ඉටුකිරීම සඳහා භාණ්ඩ හා සේවා සැපයීමට පුද්ගලයෙකු හෝ පුද්ගල කණ්ඩායමක් විසින් ඒකරාශී වී පිහිටුවා ගන්නා ව්‍යාපාර ඒකකයකි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "විවිධ ව්‍යාපාර සංවිධාන බිහිවීමට හේතු 5",
            bullets = listOf(
              "පුද්ගල අභිමතය නිසා",
              "සමාජයීය පොදු අවශ්‍යතා නිසා",
              "ව්‍යාපාරික ප්‍රතිලාභ ලැබීමට",
              "දක්ෂතා ඇති පුද්ගලයින් සහභාගි කර ගැනීමට",
              "අන්‍යෝන්‍ය වශයෙන් උපකාර කොට වාසි ලබා ගැනීමට"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාරයක සංවිධාන ක්‍රමය තීරණය කරන සාධක 6",
            bullets = listOf(
              "ව්‍යාපාරයේ ප්‍රමාණය",
              "ව්‍යාපාරයේ ස්වභාවය",
              "ප්‍රාග්ධන අවශ්‍යතාවය",
              "නීතිරීතිවල තත්ත්වය",
              "රජයේ ප්‍රතිපත්ති හා රෙගුලාසි",
              "ඒකරාශී වන පුද්ගලයින් හෝ කණ්ඩායම්"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 16
      SanduCommercePageItem(
        pageNumber = 16,
        chapterNumber = 6,
        chapterTitleSinhala = "හිමිකාරිත්වය මත ව්‍යාපාර සංවිධාන වර්ගීකරණය",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාර සංවිධාන ක්‍රම",
        pageSections = listOf(
          SanduCommerceSection(
            title = "1. පෞද්ගලික අංශයේ ව්‍යාපාර සංවිධාන",
            definition = "ව්‍යාපාරයක හිමිකාරිත්වය පුද්ගලයෙකු හෝ පුද්ගල කණ්ඩායමක් සතුවන ව්‍යාපාර පෞද්ගලික අංශයේ ව්‍යාපාර වේ.",
            examples = listOf("ඒක පුද්ගල ව්‍යාපාර", "හවුල් ව්‍යාපාර", "සංස්ථාපිත සමාගම්", "සමුපකාර සමිති හා සමිති සංවිධාන"),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "2. රාජ්‍ය අංශයේ ව්‍යාපාර සංවිධාන",
            definition = "රජය විසින් ප්‍රාග්ධනය සපයා ඇති, හිමිකාරිත්වය රජය සතු වූ ව්‍යාපාර රාජ්‍ය අංශයේ ව්‍යාපාර සංවිධාන වේ.",
            examples = listOf("රජයේ දෙපාර්තමේන්තු", "රාජ්‍ය සංස්ථා", "රාජ්‍ය සමාගම්", "පළාත් සභා හා පළාත් පාලන ආයතන සතු ආයතන"),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        ),
        comparisonTable = SanduCommerceTable(
          title = "පෞද්ගලික අංශයේ සහ පොදු (රාජ්‍ය) අංශයේ ව්‍යාපාර අතර වෙනස්කම්",
          col1Header = "පෞද්ගලික අංශය",
          col2Header = "පොදු (රාජ්‍ය) අංශය",
          rows = listOf(
            Pair("අයිතිය එක් පුද්ගලයෙකු හෝ කණ්ඩායමක් සතුය.", "අයිතිය රජය සතුය (ජනතාව සතුය)."),
            Pair("ප්‍රධාන අරමුණ ලාභ ඉපැයීමයි.", "ප්‍රධාන අරමුණ මහජන සුභසාධනයයි."),
            Pair("ප්‍රාග්ධනය පෞද්ගලික පුද්ගලයින් විසින් සපයයි.", "ප්‍රාග්ධනය රජය විසින් සපයයි."),
            Pair("කේවල ස්වාමි, හවුල්, සමාගම් අයත් වේ.", "රාජ්‍ය සංස්ථා, දෙපාර්තමේන්තු, රාජ්‍ය සමාගම් අයත් වේ.")
          )
        )
      ),

      // PAGE 17
      SanduCommercePageItem(
        pageNumber = 17,
        chapterNumber = 6,
        chapterTitleSinhala = "අරමුණු හා පරිමාණය අනුව ව්‍යාපාර වර්ගීකරණය",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාර සංවිධාන වර්ග",
        pageSections = listOf(
          SanduCommerceSection(
            title = "අරමුණු අනුව වර්ගීකරණය",
            bullets = listOf(
              "ලාභ අරමුණු කරගත් ව්‍යාපාර: ලාභ ඉපැයීම ප්‍රධාන අරමුණ කරගත් ව්‍යාපාර වේ (ඒක පුද්ගල, හවුල්, සමාගම්).",
              "ලාභ අරමුණු කර නොගත් ව්‍යාපාර: ප්‍රධාන අරමුණ සාමාජිකයන්ගේ හා සමාජයීය සුභ සාධනය වේ (සමුපකාර, සමිති, සුබසාධක සංවිධාන)."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "පරිමාණය අනුව වර්ගීකරණය",
            bullets = listOf(
              "සුළු හා මධ්‍ය පරිමාණ ව්‍යාපාර (SMEs): මහා පරිමාණ ව්‍යාපාරවලට සාපේක්ෂව කුඩා ප්‍රාග්ධනයක් ඇති, අඩු සේවක සංඛ්‍යාවක් (ජන හා සංඛ්‍යාලේඛන දෙපාර්තමේන්තුවට අනුව සේවක සංඛ්‍යාව 25ට අඩු), කුඩා වෙළඳපොළ කොටසක් හිමි ව්‍යාපාර වේ.",
              "මහා පරිමාණ ව්‍යාපාර: වැඩි ප්‍රාග්ධනයක් ආයෝජනය කළ, විශාල සේවක සංඛ්‍යාවක් සේවය කරන, විශාල වෙළඳපොළ කොටසක් හිමි, අදාළ කර්මාන්තය තුළ විශාල බලපෑමක් කළ හැකි ව්‍යාපාර යි."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 18
      SanduCommercePageItem(
        pageNumber = 18,
        chapterNumber = 6,
        chapterTitleSinhala = "කේවල ස්වාමි (ඒක පුද්ගල) ව්‍යාපාර",
        gradeLevel = "10",
        rootConcept = "ඒක පුද්ගල ව්‍යාපාර",
        pageSections = listOf(
          SanduCommerceSection(
            title = "අර්ථ දැක්වීම",
            definition = "තනි පුද්ගලයෙකු විසින් ප්‍රාග්ධනය යොදා ඔහු විසින් ම ව්‍යාපාරික කටයුතු මෙහෙයවමින් ලාභ පාඩු භුක්ති විඳිමින් පවත්වාගෙන යන ව්‍යාපාර යි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ඒක පුද්ගල ව්‍යාපාර සංවිධාන ක්‍රමයේ ලක්ෂණ 9",
            bullets = listOf(
              "ලාභය හෝ අලාභය තනිව භුක්ති විඳීම",
              "ප්‍රාග්ධනය අයිතිකරු තනිව යෙදවීම",
              "අයිතිකරුගේ වගකීම අසීමිත වීම (Unlimited Liability)",
              "ලියාපදිංචිය අනිවාර්ය නොවීම",
              "අඛණ්ඩ පැවැත්මක් නොමැති වීම",
              "නීතිමය පුද්ගලභාවයක් නොමැති වීම (No Legal Personality)",
              "තනිව තීරණ ගත හැකි වීම",
              "පාලනය අයිතිකරු විසින්ම තනිව සිදු කිරීම",
              "අයිතිකරුගේ අභිමතය පරිදි ව්‍යාපාරය අවසන් කළ හැකි වීම"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "ඒක පුද්ගල ව්‍යාපාරයේ වාසි 4",
            bullets = listOf(
              "පහසුවෙන් ආරම්භ කළ හැකි වීම",
              "සියලුම ලාභ අයිතිකරු සතු වීම",
              "තම දක්ෂතාව උපරිම ව යෙදිය හැකි වීම",
              "තීරණ ගැනීමේ ස්වාධීන බව හා ඉක්මන් බව"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "ඒක පුද්ගල ව්‍යාපාරයේ අවාසි 5",
            bullets = listOf(
              "අයිතිකරුගේ වගකීම අසීමිත වීම",
              "අඛණ්ඩ පැවැත්මක් නොමැති වීම (අයිතිකරු මියගියහොත්/අසනීප වුවහොත්)",
              "ප්‍රාග්ධනය රැස්කර ගැනීමේ දුෂ්කරතා පැවතීම",
              "නෛතික පුද්ගලභාවයක් හිමි නොවීම",
              "අයිතිකරු තනිව ගන්නා තීරණයක් ඇතැම් විට අසාර්ථක විය හැකි වීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 19
      SanduCommercePageItem(
        pageNumber = 19,
        chapterNumber = 6,
        chapterTitleSinhala = "ඒක පුද්ගල ව්‍යාපාර ලියාපදිංචි කිරීමේ ක්‍රියා පටිපාටිය",
        gradeLevel = "10",
        rootConcept = "ව්‍යාපාර නාමය ලියාපදිංචිය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "ලියාපදිංචි කිරීමේ පියවර 3",
            bullets = listOf(
              "පියවර 01: ප්‍රාදේශීය ලේකම් කාර්යාලයෙන් අදාළ ඉල්ලුම් පත්‍ර 2 ලබා ගැනීම:\n   • ව්‍යාපාර නාමය ලියාපදිංචි කිරීම සඳහා වූ ඉල්ලුම් පත්‍රය\n   • ග්‍රාම නිලධාරී වාර්තාව ලබාගැනීම සඳහා වූ ඉල්ලුම් පත්‍රය",
              "පියවර 02: ග්‍රාම නිලධාරී සහතික කළ වාර්තාව සහ නිවැරදි ව සම්පූර්ණ කරන ලද ඉල්ලුම් පත්‍රය ලියාපදිංචියට අවශ්‍ය ගාස්තුව ද සමඟ ප්‍රාදේශීය ලේකම් වෙත භාර දීම.",
              "පියවර 03: ප්‍රාදේශීය ලේකම් විසින් ඉහත ලේඛන සලකා බැලීමෙන් අනතුරුව 'ව්‍යාපාර නාමය ලියාපදිංචි කිරීමේ සහතිකය' නිකුත් කිරීම."
            ),
            type = SanduCommerceSectionType.PROCESS_STEPS
          ),
          SanduCommerceSection(
            title = "ව්‍යාපාර නාමය ලියාපදිංචි කිරීමෙන් ලබාගත හැකි ප්‍රයෝජන 4",
            bullets = listOf(
              "අනන්‍යතාවයක් ලැබීම",
              "ව්‍යාපාර නාමයේ අයිතිය තහවුරු වීම",
              "රජයෙන් ලබාදෙන දිරිගැන්වීම් ලබා ගැනීමට සුදුසුකමක් වීම",
              "ණය ලබාගැනීමේ දී පහසුවක් ලැබීම (බැංකු ගිණුම් විවෘත කිරීම)"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 20
      SanduCommercePageItem(
        pageNumber = 20,
        chapterNumber = 6,
        chapterTitleSinhala = "හවුල් ව්‍යාපාර සහ හවුල් ගිවිසුම",
        gradeLevel = "10",
        rootConcept = "හවුල් ව්‍යාපාර",
        pageSections = listOf(
          SanduCommerceSection(
            title = "හවුල් ව්‍යාපාරයක් යනු කුමක්ද?",
            definition = "ලාභ ලැබීමේ අරමුණින් පොදුවේ පවත්වාගෙන යන පුද්ගලයන් අතර පවත්නා සම්බන්ධතාව, හවුල් ව්‍යාපාරයකි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "හවුල් ව්‍යාපාරයක් වීම සඳහා අත්‍යවශ්‍ය සාධක 4",
            bullets = listOf(
              "පුද්ගලයින් සිටීම (2 සිට 20 දක්වා)",
              "ව්‍යාපාරයක් තිබීම",
              "ලාභ ලැබීමේ චේතනාව පැවතීම",
              "පොදුවේ කටයුතු කිරීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "හවුල් ව්‍යාපාරවල මූලික ලක්ෂණ",
            bullets = listOf(
              "සාමාජික සංඛ්‍යාව අවමය 2, උපරිමය 20 කි.",
              "හවුල්කරුවන්ගේ වගකීම අසීමිත වීම.",
              "හවුල් ව්‍යාපාර ලියාපදිංචිය අනිවාර්ය නොවීම (නමුත් වෙනත් නමකින් පවත්වාගෙන යන්නේ නම් ලියාපදිංචි කළ යුතුය).",
              "නෛතික පුද්ගලභාවයක් නොමැති වීම.",
              "අඛණ්ඩ පැවැත්මක් නොමැති වීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "හවුල් ගිවිසුම සහ ආරම්භ කළ හැකි ප්‍රධාන ආකාර 3",
            definition = "හවුල් ව්‍යාපාරයක් ඇති වීමට හවුල්කරුවන් අතර ඇති කරගන්නා එකඟතාව, හවුල් ගිවිසුම වේ.",
            bullets = listOf(
              "හවුල්කරුවන්ගේ ඇඟවීමෙන් / හැසිරීමෙන් (By conduct)",
              "හවුල්කරුවන්ගේ වාචික එකඟත්වයෙන් (Verbally)",
              "ලිඛිත එකඟත්වයෙන් / ගිවිසුමකින් (Written agreement)"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 21
      SanduCommercePageItem(
        pageNumber = 21,
        chapterNumber = 6,
        chapterTitleSinhala = "හවුල් ගිවිසුමක කරුණු සහ නීතිරීති",
        gradeLevel = "10",
        rootConcept = "හවුල් ගිවිසුම & නීති",
        pageSections = listOf(
          SanduCommerceSection(
            title = "හවුල් ගිවිසුමක ඇතුළත් ප්‍රධාන කරුණු",
            bullets = listOf(
              "හවුල් ව්‍යාපාරයේ නම හා ලිපිනය",
              "හවුල් ව්‍යාපාරයේ ස්වභාවය හා අරමුණු",
              "හවුල්කරුවන් යොදවන ප්‍රාග්ධනය",
              "ලාභාලාභ බෙදාගන්නා ආකාරය",
              "කළමනාකරණය හා කාර්යභාරයන්",
              "හවුල්කරුවන්ගේ වැටුප් හා ගැනිලි පිළිබඳ කොන්දේසි",
              "නව හවුල්කරුවන් බඳවා ගැනීම හා ඉවත්වීම",
              "ආරවුල් විසඳා ගැනීමේ ක්‍රම",
              "ව්‍යාපාරය විසුරුවා හැරීම පිළිබඳ කොන්දේසි"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "හවුල් ව්‍යාපාර කෙරෙහි බලපාන ප්‍රධාන නීතිරීති",
            bullets = listOf(
              "1890 හවුල් ව්‍යාපාර ආඥා පනත (Partnership Act of 1890)",
              "1840 අංක 7 දරණ වංචා වැළැක්වීමේ ආඥා පනත (Prevention of Frauds Ordinance)",
              "1907 සීමාසහිත හවුල් ව්‍යාපාර ආඥා පනත",
              "1918 අංක 6 දරණ ව්‍යාපාර නාම ආඥා පනත",
              "2007 අංක 7 දරණ සමාගම් පනත (සාමාජික සංඛ්‍යාව 20 සීමාව පිළිබඳ)",
              "අදාළ පළාත් සභාවල ලියාපදිංචි කිරීමේ නීතිරීති හා පොදු නීති"
            ),
            type = SanduCommerceSectionType.LEGAL_ACTS
          ),
          SanduCommerceSection(
            title = "හවුල් ව්‍යාපාර සඳහා ඇති සීමාවන් 4",
            bullets = listOf(
              "වාණිජ බැංකුවක් පවත්වාගෙන යා නොහැකි ය.",
              "මූල්‍ය සමාගමක් පවත්වාගෙන යා නොහැකි ය.",
              "රක්ෂණ නීතිය යටතේ රක්ෂණ සමාගමක් පවත්වාගෙන යා නොහැක.",
              "කොටස් අලෙවි බිම් හෝ තැරැව්කාර සමාගම් පවත්වාගෙන යා නොහැකි ය."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 22
      SanduCommercePageItem(
        pageNumber = 22,
        chapterNumber = 6,
        chapterTitleSinhala = "හවුල් ව්‍යාපාර වාසි, අවාසි සහ සමානකම්",
        gradeLevel = "10",
        rootConcept = "හවුල් ව්‍යාපාර වාසි අවාසි",
        pageSections = listOf(
          SanduCommerceSection(
            title = "හවුල් ව්‍යාපාර සංවිධාන ක්‍රමයේ වාසි 5",
            bullets = listOf(
              "පහසුවෙන් ආරම්භ කළ හැකි වීම",
              "වැඩි ප්‍රාග්ධනයක් රැස්කර ගත හැකි වීම (තනි ව්‍යාපාරයකට වඩා)",
              "හවුල්කරුවන් සතු විවිධ දක්ෂතා ප්‍රයෝජනයට ගත හැකි වීම",
              "වගකීම හා පාඩු හවුල්කරුවන් අතර බෙදීයාම",
              "සාමූහික තීරණ ගත හැකි වීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "හවුල් ව්‍යාපාර සංවිධාන ක්‍රමයේ අවාසි 5",
            bullets = listOf(
              "අසීමිත වගකීම (Unlimited Liability)",
              "ලාභය හවුල්කරුවන් අතර බෙදීයාම",
              "හවුල්කරුවන් අතර මතභේද ඇතිවිය හැකි වීම",
              "අඛණ්ඩ පැවැත්මක් නොමැති වීම (හවුල්කරුවෙකු මියගියහොත් හෝ බංකොලොත් වුවහොත්)",
              "නෛතික පුද්ගලභාවයක් නොමැති වීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "හවුල් ව්‍යාපාර හා කේවල ස්වාමි ව්‍යාපාර අතර ඇති සමානකම් 6",
            bullets = listOf(
              "වගකීම් අසීමිත වීම.",
              "ලියාපදිංචිය අනිවාර්ය නොවීම.",
              "නීතිමය පුද්ගලභාවයක් නොමැති වීම.",
              "අඛණ්ඩ පැවැත්මක් නොමැති වීම.",
              "ගිණුම් තැබීම හා විගණනය අනිවාර්ය නොවීම.",
              "වෙනත් නමකින් පවත්වාගෙන යන්නේ නම් ලියාපදිංචි කළ යුතු වීම."
            ),
            type = SanduCommerceSectionType.COMPARISON
          )
        )
      ),

      // PAGE 23
      SanduCommercePageItem(
        pageNumber = 23,
        chapterNumber = 6,
        chapterTitleSinhala = "සංස්ථාපිත සමාගම් සහ රාජ්‍ය සමාගම්",
        gradeLevel = "10",
        rootConcept = "සංස්ථාපිත සමාගම්",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සංස්ථාපිත සමාගම් අර්ථදැක්වීම",
            definition = "2007 අංක 07 දරණ සමාගම් පනත යටතේ ලියාපදිංචි කළ යුතු, නෛතික පුද්ගලභාවයක් සහිත, කොටස් නිකුත් කරමින් ප්‍රාග්ධනය සපයා ගත හැකි සහ කොටස් හිමියන්ගේ වගකීම් සීමිත වන සමාගම් ය.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සංස්ථාපිත සමාගම්වල ලක්ෂණ",
            bullets = listOf(
              "සමාගම් පනත යටතේ සංස්ථාපනය කිරීම (Incorporation)",
              "අඛණ්ඩ පැවැත්මක් තිබීම (Perpetual Succession)",
              "සීමිත වගකීම සහිතව ලියාපදිංචි කළ හැකි වීම (Limited Liability)",
              "කොටස් නිකුතුවෙන් ප්‍රාග්ධනය රැස්කර ගත හැකි වීම"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "සංස්ථාපිත සමාගම්වල වාසි හා අවාසි",
            bullets = listOf(
              "වාසි: වැඩි ප්‍රාග්ධනයක් රැස්කර ගත හැකි වීම, නෛතික පුද්ගලභාවයක් හිමි වීම, අඛණ්ඩ පැවැත්මක් තිබීම, වගකීම් සීමාසහිත වීම, අධ්‍යක්ෂ මණ්ඩලයක් මඟින් කළමනාකරණය කිරීම.",
              "අවාසි: නීතිමය විධිවිධාන අධික වීම, ලාභය සහ අයිතිය බෙදීයාම, තීරණ ගැනීම ප්‍රමාද විය හැකි වීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "රාජ්‍ය සමාගම්",
            definition = "2007 අංක 07 සමාගම් පනත යටතේ සංස්ථාපනය කර ඇති සීමිත පොදු සමාගමක් වීම හා සමාගමේ මුළු ප්‍රාග්ධනයෙන් 51% ට වඩා වැඩි ප්‍රමාණයක් රජය හෝ රජයේ ආයතන සතු ව්‍යාපාර සංවිධාන යි.",
            examples = listOf("ශ්‍රී ලංකා රක්ෂණ සමාගම", "ශ්‍රී ලංකා ටෙලිකොම් සමාගම", "සී/ස ලිට්‍රෝ ගෑස් සමාගම"),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 24
      SanduCommercePageItem(
        pageNumber = 24,
        chapterNumber = 6,
        chapterTitleSinhala = "සමුපකාර සංවිධානය සහ මූලික ලක්ෂණ",
        gradeLevel = "10",
        rootConcept = "සමුපකාර සංවිධානය",
        pageSections = listOf(
          SanduCommerceSection(
            title = "අර්ථ දැක්වීම සහ පනත",
            definition = "සාමාජිකයන්ගේ සුබසිද්ධිය සඳහා ඔවුන් තම මුදල් යොදවා ස්වේච්ඡාවෙන් ඇතිකර ගන්නා ව්‍යාපාර සංවිධාන වර්ගයකි. සමුපකාර ව්‍යාපාරය 1972 අංක 05 දරණ සමුපකාර සමිති පනත යටතේ සමුපකාර සමිතියක් ලියාපදිංචිය සඳහා නීතිරීති පදනම් වේ.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සමුපකාර ව්‍යාපාරයේ විශේෂ ලක්ෂණ 6",
            bullets = listOf(
              "ප්‍රජාතන්ත්‍රවාදී පාලනයක් තිබීම (එක් සාමාජිකයෙකුට එක් ඡන්දය බැගින්)",
              "මූලික වශයෙන් ලාභ පරමාර්ථයෙන් කටයුතු නොකිරීම",
              "ප්‍රතිලාභ (අතිරික්තය / ලාභය) සාමාජිකයන් අතරේ බෙදීයාම",
              "සාමාජිකයන්ගේ අභිවෘද්ධිය වෙනුවෙන් කටයුතු කිරීම",
              "සෑම සාමාජිකයෙකුට ම ඡන්ද බලය හිමි වීම",
              "ස්වේච්ඡා හා විවෘත සාමාජිකත්වය"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        ),
        comparisonTable = SanduCommerceTable(
          title = "සමුපකාර සමිතිවල මූලික ලක්ෂණ වගුව",
          col1Header = "විෂය කරුණ",
          col2Header = "සමුපකාර සමිතියේ තත්ත්වය",
          rows = listOf(
            Pair("ලියාපදිංචිය", "සමුපකාර සංවර්ධන දෙපාර්තමේන්තුවේ ලියාපදිංචි කරයි."),
            Pair("අයිතිය", "සාමාජිකයන් සතුය. අවම සාමාජිකයින් 10කි, උපරිම සීමාවක් නැත."),
            Pair("ප්‍රාග්ධනය", "සාමාජිකයන් විසින් කොටස් අලෙවියෙන් හෝ බාහිර ප්‍රදානයන්ගෙන් සපයයි."),
            Pair("ගිණුම් තැබීම", "අනිවාර්ය වේ."),
            Pair("ලාභ / අතිරික්තය බෙදීම", "සාමාජිකයින් සමිතිය සමඟ ගනුදෙනු කළ වටිනාකම මත ලබා දෙයි."),
            Pair("කළමනාකරණය / පරිපාලනය", "අධ්‍යක්ෂක මණ්ඩලයක් මඟින් සිදු වේ."),
            Pair("වගකීම", "සීමාසහිතයි."),
            Pair("නීතිමය පුද්ගලභාවය", "ඇත."),
            Pair("පැවැත්ම", "අඛණ්ඩ පැවැත්මක් ඇත."),
            Pair("බදු ගෙවීම", "සමුපකාර සමිතිය නමින් කළ යුතුය.")
          )
        )
      ),

      // PAGE 25
      SanduCommercePageItem(
        pageNumber = 25,
        chapterNumber = 6,
        chapterTitleSinhala = "සමුපකාර ප්‍රතිපත්ති සහ විසුරුවා හැරීම",
        gradeLevel = "10",
        rootConcept = "සමුපකාර ප්‍රතිපත්ති",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සමුපකාර ක්‍රමයේ හිතකර ලක්ෂණ (වාසි)",
            bullets = listOf(
              "සාමාජිකයන්ගේ වගකීම සීමාසහිත වීම",
              "අඛණ්ඩ පැවැත්ම",
              "නෛතික පුද්ගලභාවය",
              "ඇරඹීම පහසු වීම",
              "සමානාත්මතාවය (එක් අයෙකුට එක් ඡන්දය)",
              "විශාල ප්‍රාග්ධනයක් රැස්කර ගත හැකි වීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "සමුපකාර ප්‍රතිපත්ති 7 (Cooperative Principles)",
            bullets = listOf(
              "1. විවෘත හා ස්වේච්ඡා සාමාජිකත්වය",
              "2. ප්‍රජාතන්ත්‍රවාදී සාමාජික පාලනය",
              "3. සාමාජික ආර්ථික සහභාගිත්වය",
              "4. ස්වයංපාලනය හා ස්වාධීනත්වය (ස්වෛරීභාවය හා නිදහස)",
              "5. අධ්‍යාපන, පුහුණුව හා ප්‍රවෘත්ති",
              "6. සමුපකාර සමිති අතර සහයෝගීතාවය",
              "7. සමාජය (ප්‍රජාව) පිළිබඳව සැලකිලිමත් වීම"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "සමුපකාර සමිතියක් විසුරුවා හැරීමට හේතු 4",
            bullets = listOf(
              "අවම සාමාජික සංඛ්‍යාව නොසිටීම නිසා (10ට අඩු වීම)",
              "සාමාජිකයන් 3/4 කගේ ඉල්ලීම නිසා",
              "ලියාපදිංචි කොට වසරක් යනතුරු ව්‍යාපාර කටයුතු ආරම්භ නොකිරීම",
              "විසුරුවා හැරීම යුක්ති සහගත යැයි සමුපකාර සංවර්ධන කොමසාරිස්වරයා තීරණය කරන ඕනෑම අවස්ථාවක"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 26
      SanduCommercePageItem(
        pageNumber = 26,
        chapterNumber = 6,
        chapterTitleSinhala = "සමිති සංවිධාන සහ පොදු අංශයේ ව්‍යාපාර",
        gradeLevel = "10",
        rootConcept = "සමිති සංවිධාන සහ පොදු ව්‍යාපාර",
        pageSections = listOf(
          SanduCommerceSection(
            title = "සමිති සංවිධාන (Societies)",
            definition = "සාමාජික සුභසාධනය, පොදු සුභසාධනය, ප්‍රජා සේවාවන් හෝ පුණ්‍ය කටයුත්තක් පදනම් කොටගෙන පවත්වාගෙන යනු ලබන සමාජ සුභසාධනය මූලික අරමුණ කරගත් ව්‍යාපාර සංවිධාන වර්ග, සමිති සංවිධාන ලෙස හඳුන්වයි.",
            bullets = listOf(
              "අයිතිය: සාමාජිකයන් සතුය.",
              "ප්‍රාග්ධනය: සාමාජිකයන් විසින් සපයයි.",
              "ලියාපදිංචිය: අනිවාර්ය නොවේ.",
              "වගකීම: සමාගම් පනත යටතේ ලියාපදිංචි කළ සමිතිවල වගකීම සීමිත වේ.",
              "ලාභාලාභ: ලාභයක් ඇත්නම් එය සමිතියේ අභිවෘද්ධිය වෙනුවෙන් යොදවයි.",
              "කළමනාකරණය: සාමාජිකයන්ගේ මහා සභා රැස්වීමක දී තීරණ අනුව සිදුකරයි."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "පොදු අංශයේ ව්‍යාපාර (පොදු ව්‍යාපාර)",
            definition = "අයිතිය රජය හෝ පළාත් පාලන ආයතන සතු වන (ජනතාව සතු වන) ජනතාවට ප්‍රතිලාභ ලබාදීමේ අරමුණින් පවත්වාගෙන යනු ලබන ව්‍යාපාර පොදු අංශයේ ව්‍යාපාර යි.",
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "පොදු හිමිකාරිත්වය යටතේ ව්‍යාපාර පවත්වාගෙන යාමට හේතු 6",
            bullets = listOf(
              "සමාජ සුභසාධන සේවා පවත්වාගෙන යාමට",
              "ආර්ථිකයට ඉතා වැදගත් ව්‍යාපාර පවත්වාගෙන යාමට",
              "උපයන ලාභ ජනතාවට භුක්ති විඳීමට අවස්ථාව ලබාදීමට",
              "ජාතික ආරක්ෂාවට සිදුවිය හැකි තර්ජන වැළැක්වීමට",
              "ජනතාවට ඉතාම වැදගත් එමෙන්ම අලාභ ලබන ව්‍යාපාර පවත්වාගෙන යාමට",
              "විශාල ප්‍රාග්ධනයක් අවශ්‍ය එහෙත් ලාභදායී නොවන පොදු පහසුකම් පවත්වාගෙන යාමට"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          )
        )
      ),

      // PAGE 27
      SanduCommercePageItem(
        pageNumber = 27,
        chapterNumber = 6,
        chapterTitleSinhala = "රාජ්‍ය දෙපාර්තමේන්තු (Government Departments)",
        gradeLevel = "10",
        rootConcept = "රාජ්‍ය දෙපාර්තමේන්තු",
        pageSections = listOf(
          SanduCommerceSection(
            title = "අර්ථ දැක්වීම සහ උදාහරණ",
            definition = "අමාත්‍යාංශයක් යටතේ ක්‍රියාත්මක වන මුළුමනින් ම රජයේ සෘජු පාලනයට අයත් වන ආයතන දෙපාර්තමේන්තු ලෙස හඳුන්වයි. බොහෝ විට මහජනතාව සඳහා විවිධ සේවා සැපයීමට දෙපාර්තමේන්තු ක්‍රියාත්මක වේ.",
            examples = listOf("ශ්‍රී ලංකා දුම්රිය දෙපාර්තමේන්තුව", "ශ්‍රී ලංකා තැපැල් දෙපාර්තමේන්තුව"),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "රාජ්‍ය දෙපාර්තමේන්තුවල ලක්ෂණ 4",
            bullets = listOf(
              "අයිතිය හා පාලනය රජය සතු වීම",
              "අඛණ්ඩ පැවැත්ම",
              "අරමුදල් රජය මඟින් (වාර්ෂික අයවැයෙන්) සැපයීම",
              "නීතිමය කටයුතුවල දී දෙපාර්තමේන්තු ප්‍රධානියා සිය නිල නාමයෙන් පෙනී සිටිය යුතු වීම"
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "දෙපාර්තමේන්තුවල වාසි සහ අවාසි",
            bullets = listOf(
              "වාසි:\n   • බොහෝවිට ජනතාවට අත්‍යවශ්‍ය වන සේවා සැපයීම\n   • විශාල ප්‍රාග්ධනයක් අවශ්‍ය දිගුකාලීන සංවර්ධන කටයුතුවලට මැදිහත් වීම\n   • විශාල පිරිසකට රැකියා අවස්ථා සැලසීම\n   • ජනතාවගේ සුභසිද්ධිය සඳහා ලාභ අපේක්ෂාවෙන් තොරව සේවා සැපයීම",
              "අවාසි:\n   • රජයේ මූල්‍ය රෙගුලාසි, ආයතන සංග්‍රහය හා චක්‍රලේඛ අනුව ක්‍රියා කළ යුතු වීම\n   • තීරණ ගැනීමේ ස්වාධීනත්වය නැති වීම\n   • අතිරික්ත සේවකයන් නිසා ශ්‍රම පිරිවැය වැඩි වීම"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      ),

      // PAGE 28
      SanduCommercePageItem(
        pageNumber = 28,
        chapterNumber = 6,
        chapterTitleSinhala = "රාජ්‍ය සංස්ථා (Public Corporations)",
        gradeLevel = "10",
        rootConcept = "රාජ්‍ය සංස්ථා",
        pageSections = listOf(
          SanduCommerceSection(
            title = "අර්ථ දැක්වීම සහ උදාහරණ",
            definition = "සමාගම් පනත යටතේ හැර වෙනත් නීතියක් යටතේ සංස්ථාපනය කළ පූර්ණ අයිතිය රජය සතුවන හෝ අයිතියෙන් වැඩි ප්‍රමාණයක් රජය සතුවන ව්‍යාපාර රාජ්‍ය සංස්ථා ලෙස හැඳින්වේ. මෙම ව්‍යාපාර විශේෂ හෝ පොදු පාර්ලිමේන්තු පනත් මඟින් ආරම්භ කෙරෙයි. රාජ්‍ය නීතිගත සංස්ථාව, කොමිසම, අධිකාරිය, මණ්ඩලය, කාර්යාංශය යන නම් වලින් ද හඳුන්වයි.",
            examples = listOf(
              "ශ්‍රී ලංකා ගමනාගමන මණ්ඩලය (ශ්‍රී ලංගම)",
              "ශ්‍රී ලංකා මහවැලි අධිකාරිය",
              "ශ්‍රී ලංකා රූපවාහිනී සංස්ථාව",
              "ශ්‍රී ලංකා ඛනිජ තෙල් නීතිගත සංස්ථාව (CPC)"
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          ),
          SanduCommerceSection(
            title = "රාජ්‍ය සංස්ථාවල ලක්ෂණ 4",
            bullets = listOf(
              "අයිතිය හා පාලනය රජය සතු වීම.",
              "නෛතික පුද්ගලභාවයක් තිබීම.",
              "අඛණ්ඩ පැවැත්මක් තිබීම.",
              "විශේෂ හෝ පොදු පනතක් යටතේ ආරම්භ කළ හැකි වීම."
            ),
            type = SanduCommerceSectionType.MINDMAP_BRANCH
          ),
          SanduCommerceSection(
            title = "රාජ්‍ය සංස්ථාවල වාසි සහ අවාසි",
            bullets = listOf(
              "වාසි:\n   • අත්‍යවශ්‍ය සේවා සම්පාදනය සඳහා උචිත වීම.\n   • පෞද්ගලික අංශයේ ඒකාධිකාරී බලපෑම අවම කිරීමට දායක වීම.\n   • ලාභය මහජනතාව සතු වීම.",
              "අවාසි:\n   • තීරණ ගැනීමේ ස්වාධීනත්වය නැති වීම.\n   • රජයේ මූල්‍ය රෙගුලාසිවලට යටත් වීම."
            ),
            type = SanduCommerceSectionType.THEORY_CARD
          )
        )
      )
    )
  }
}
