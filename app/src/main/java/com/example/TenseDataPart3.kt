package com.example

object TenseDataPart3 {
  fun getCategoriesPart3(): List<TenseComparisonCategory> {
    return listOf(
      // ==========================================
      // Category 11: මිත්‍රත්වය සහ සමාජ සබඳතා (Friendship & Social Relationships) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 11,
        titleSinhala = "කාණ්ඩය 11: මිත්‍රත්වය සහ සමාජ සබඳතා",
        titleEnglish = "Friendship & Social Relationships",
        icon = "🤝",
        description = "මිතුරන් හමුවීම, උපකාර කිරීම, සුබ පැතීම සහ මිත්‍රත්වය පවත්වාගෙන යාම පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t11_s1",
            baseActionSinhala = "හොඳම මිතුරා හමුවීම",
            pastEnglish = "I met my best friend at the city library yesterday.",
            pastSinhala = "මම ඊයේ නගර පුස්තකාලයේදී මගේ හොඳම මිතුරා හමුවුණෙමි.",
            presentEnglish = "I meet my best friend at the city library every weekend.",
            presentSinhala = "මම සෑම සති අන්තයකම නගර පුස්තකාලයේදී මගේ හොඳම මිතුරා හමුවෙමි.",
            futureEnglish = "I will meet my best friend at the city library tomorrow.",
            futureSinhala = "මම හෙට නගර පුස්තකාලයේදී මගේ හොඳම මිතුරා හමුවන්නෙමි.",
            verbTransformation = "met → meet → will meet"
          ),
          TenseSentenceItem(
            id = "t11_s2",
            baseActionSinhala = "මිතුරෙකුට උපකාර කිරීම",
            pastEnglish = "Kamal helped his classmate with homework.",
            pastSinhala = "කමල් ඔහුගේ පන්ති සහෝදරයාට ගෙදර වැඩ සඳහා උපකාර කළේය.",
            presentEnglish = "Kamal helps his classmate whenever needed.",
            presentSinhala = "කමල් අවශ්‍ය සෑම විටම ඔහුගේ පන්ති සහෝදරයාට උපකාර කරයි.",
            futureEnglish = "Kamal will help his classmate prepare for the exam.",
            futureSinhala = "කමල් විභාගයට සූදානම් වීමට ඔහුගේ පන්ති සහෝදරයාට උපකාර කරනු ඇත.",
            verbTransformation = "helped → helps → will help"
          ),
          TenseSentenceItem(
            id = "t11_s3",
            baseActionSinhala = "රහස් බෙදාගැනීම",
            pastEnglish = "She shared her secret with her trusted friend.",
            pastSinhala = "ඇය තම විශ්වාසවන්ත මිතුරිය සමඟ ඇගේ රහස බෙදාගත්තාය.",
            presentEnglish = "She shares her feelings openly with her friend.",
            presentSinhala = "ඇය තම හැඟීම් මිතුරිය සමඟ විවෘතව බෙදාගනියි.",
            futureEnglish = "She will share the good news with her friend soon.",
            futureSinhala = "ඇය ඉක්මනින්ම තම මිතුරිය සමඟ සුබ ආරංචිය බෙදාගනු ඇත.",
            verbTransformation = "shared → shares → will share"
          ),
          TenseSentenceItem(
            id = "t11_s4",
            baseActionSinhala = "සුබපැතුම් පතක් යැවීම",
            pastEnglish = "I sent a birthday card to Ruwan.",
            pastSinhala = "මම රුවන්ට උපන්දින සුබපැතුම් පතක් යැව්වෙමි.",
            presentEnglish = "I send birthday cards to all my close friends.",
            presentSinhala = "මම මගේ සියලුම කිට්ටු මිතුරන්ට උපන්දින සුබපැතුම් පත් යවමි.",
            futureEnglish = "I will send a warm greeting to Ruwan on his birthday.",
            futureSinhala = "මම රුවන්ගේ උපන්දිනයට ඔහුට උණුසුම් සුබපැතුමක් යවන්නෙමි.",
            verbTransformation = "sent → send → will send"
          ),
          TenseSentenceItem(
            id = "t11_s5",
            baseActionSinhala = "මිතුරන් සමඟ සිනාසීම",
            pastEnglish = "We laughed happily at his funny joke.",
            pastSinhala = "ඔහුගේ විහිළුවට අපි සතුටින් සිනාසුනෙමු.",
            presentEnglish = "We laugh together during school intervals.",
            presentSinhala = "අපි පාසල් විවේක කාලයේදී එකට සිනාසෙමු.",
            futureEnglish = "We will laugh and enjoy our time at the reunion.",
            futureSinhala = "අපි නැවත හමුවීමේදී සිනාසෙමින් ප්‍රීති වන්නෙමු.",
            verbTransformation = "laughed → laugh → will laugh"
          ),
          TenseSentenceItem(
            id = "t11_s6",
            baseActionSinhala = "මිතුරෙකුට සමාව දීම",
            pastEnglish = "Nimal forgave his friend for the small misunderstanding.",
            pastSinhala = "නිමල් කුඩා වැරදි වැටහීම සඳහා තම මිතුරාට සමාව දුන්නේය.",
            presentEnglish = "A true friend always forgives genuine mistakes.",
            presentSinhala = "සැබෑ මිතුරෙක් සැමවිටම අවංක වැරදි සඳහා සමාව දෙයි.",
            futureEnglish = "Nimal will forgive him once he apologizes.",
            futureSinhala = "ඔහු සමාව අයැද සිටි පසු නිමල් ඔහුට සමාව දෙනු ඇත.",
            verbTransformation = "forgave → forgives → will forgive"
          ),
          TenseSentenceItem(
            id = "t11_s7",
            baseActionSinhala = "උපන්දින සාදයකට ආරාධනා කිරීම",
            pastEnglish = "They invited thirty guests to the party.",
            pastSinhala = "ඔවුහු සාදයට අමුත්තන් තිස් දෙනෙකුට ආරාධනා කළහ.",
            presentEnglish = "They invite their neighbors to every family celebration.",
            presentSinhala = "ඔවුහු සෑම පවුලේ උත්සවයකටම අසල්වැසියන්ට ආරාධනා කරති.",
            futureEnglish = "They will invite all classmates to next week's party.",
            futureSinhala = "ඔවුහු ලබන සතියේ සාදයට සියලුම පන්ති මිතුරන්ට ආරාධනා කරනු ඇත.",
            verbTransformation = "invited → invite → will invite"
          ),
          TenseSentenceItem(
            id = "t11_s8",
            baseActionSinhala = "මිතුරෙකු අස්වැසීම",
            pastEnglish = "Saman comforted his sad friend with kind words.",
            pastSinhala = "සමන් තම දුක්බර මිතුරා කාරුණික වදන්වලින් අස්වැසුවේය.",
            presentEnglish = "He comforts anyone facing hardship.",
            presentSinhala = "ඔහු දුෂ්කරතාවලට මුහුණ දෙන ඕනෑම අයෙකු අස්වසයි.",
            futureEnglish = "He will comfort his friend during tough times.",
            futureSinhala = "ඔහු දුෂ්කර කාලවලදී තම මිතුරා අස්වසනු ඇත.",
            verbTransformation = "comforted → comforts → will comfort"
          ),
          TenseSentenceItem(
            id = "t11_s9",
            baseActionSinhala = "තෑග්ගක් දීම",
            pastEnglish = "I gave a storybook as a gift to Kasun.",
            pastSinhala = "මම කසුන්ට තෑග්ගක් ලෙස කතන්දර පොතක් දුනිමි.",
            presentEnglish = "I give thoughtful gifts to my friends on special days.",
            presentSinhala = "මම විශේෂ දිනවලදී මගේ මිතුරන්ට වටිනා තෑගි දෙමි.",
            futureEnglish = "I will give a beautiful souvenir to Kasun.",
            futureSinhala = "මම කසුන්ට ලස්සන සිහිවටනයක් දෙන්නෙමි.",
            verbTransformation = "gave → give → will give"
          ),
          TenseSentenceItem(
            id = "t11_s10",
            baseActionSinhala = "පොරොන්දුවක් ඉටු කිරීම",
            pastEnglish = "Sunil kept his promise to support us.",
            pastSinhala = "සුනිල් අපට සහාය දීමට දුන් පොරොන්දුව ඉටු කළේය.",
            presentEnglish = "A trustworthy friend keeps every promise.",
            presentSinhala = "විශ්වාසවන්ත මිතුරෙක් සෑම පොරොන්දුවක්ම ඉටු කරයි.",
            futureEnglish = "Sunil will keep his word without fail.",
            futureSinhala = "සුනිල් කිසිදු අතපසු වීමකින් තොරව තම වචනය රකිනු ඇත.",
            verbTransformation = "kept → keeps → will keep"
          ),
          TenseSentenceItem(
            id = "t11_s11",
            baseActionSinhala = "මිතුරන් අගය කිරීම",
            pastEnglish = "The teacher praised the boys for their unity.",
            pastSinhala = "ගුරුතුමිය ඔවුන්ගේ σύ ஒற்றுම අගය කළාය.",
            presentEnglish = "True friends praise each other's achievements.",
            presentSinhala = "සැබෑ මිතුරෝ එකිනෙකාගේ ජයග්‍රහණ අගය කරති.",
            futureEnglish = "The principal will praise their teamwork tomorrow.",
            futureSinhala = "විදුහල්පතිතුමා හෙට ඔවුන්ගේ කණ්ඩායම් හැඟීම අගය කරනු ඇත.",
            verbTransformation = "praised → praise → will praise"
          ),
          TenseSentenceItem(
            id = "t11_s12",
            baseActionSinhala = "එකට දිවා ආහාරය ගැනීම",
            pastEnglish = "We ate lunch together under the shade of the mango tree.",
            pastSinhala = "අපි අඹ ගස සෙවණේ එකට දිවා ආහාරය ගත්තෙමු.",
            presentEnglish = "We eat lunch together every afternoon.",
            presentSinhala = "අපි සෑම දහවලකම එකට දිවා ආහාරය ගනිමු.",
            futureEnglish = "We will eat lunch together after the science period.",
            futureSinhala = "අපි විද්‍යාව කාලච්ඡේදයෙන් පසු එකට දිවා ආහාරය ගන්නෙමු.",
            verbTransformation = "ate → eat → will eat"
          ),
          TenseSentenceItem(
            id = "t11_s13",
            baseActionSinhala = "පැරණි මිතුරෙකු මතක් වීම",
            pastEnglish = "I remembered my childhood friend Amal.",
            pastSinhala = "මට මගේ ළමා වියේ මිතුරා අමල් මතක් විය.",
            presentEnglish = "I often remember the joyful days we spent together.",
            presentSinhala = "අපි එකට ගත කළ ප්‍රීතිමත් දවස් මට නිතරම මතක් වෙයි.",
            futureEnglish = "I will remember your friendship wherever I go.",
            futureSinhala = "මම කොතැනක ගියත් ඔබගේ මිත්‍රත්වය මතකයේ තබා ගන්නෙමි.",
            verbTransformation = "remembered → remember → will remember"
          ),
          TenseSentenceItem(
            id = "t11_s14",
            baseActionSinhala = "නව මිතුරන් ඇති කර ගැනීම",
            pastEnglish = "She made new friends at the youth camp.",
            pastSinhala = "ඇය තරුණ කඳවුරේදී නව මිතුරන් ඇති කර ගත්තාය.",
            presentEnglish = "She makes friends easily because of her gentle smile.",
            presentSinhala = "ඇයගේ ප්‍රසන්න සිනහව නිසා ඇය පහසුවෙන් මිතුරන් ඇති කර ගනියි.",
            futureEnglish = "She will make many good friends at the university.",
            futureSinhala = "ඇය විශ්වවිද්‍යාලයේදී බොහෝ හොඳ මිතුරන් ඇති කර ගනු ඇත.",
            verbTransformation = "made → makes → will make"
          ),
          TenseSentenceItem(
            id = "t11_s15",
            baseActionSinhala = "දුරකථන අංක හුවමාරු කර ගැනීම",
            pastEnglish = "They exchanged phone numbers before saying goodbye.",
            pastSinhala = "සමුගැනීමට පෙර ඔවුහු දුරකථන අංක හුවමාරු කර ගත්හ.",
            presentEnglish = "Participants exchange contact details after the seminar.",
            presentSinhala = "සම්මන්ත්‍රණයෙන් පසු සහභාගිවන්නන් තොරතුරු හුවමාරු කර ගනිති.",
            futureEnglish = "We will exchange email addresses tomorrow.",
            futureSinhala = "අපි හෙට ඊමේල් ලිපින හුවමාරු කර ගන්නෙමු.",
            verbTransformation = "exchanged → exchange → will exchange"
          ),
          TenseSentenceItem(
            id = "t11_s16",
            baseActionSinhala = "මිතුරන් බැලීමට යාම",
            pastEnglish = "I visited my sick friend in hospital.",
            pastSinhala = "මම රෝහලේ සිටි මගේ අසනීප මිතුරා බැලීමට ගියෙමි.",
            presentEnglish = "I visit my village friends during school vacations.",
            presentSinhala = "මම පාසල් නිවාඩු කාලයේදී මගේ ගමේ මිතුරන් බැලීමට යමි.",
            futureEnglish = "I will visit him at his home next Sunday.",
            futureSinhala = "මම ලබන ඉරිදා ඔහුගේ නිවසට ගොස් ඔහුව බලන්නෙමි.",
            verbTransformation = "visited → visit → will visit"
          ),
          TenseSentenceItem(
            id = "t11_s17",
            baseActionSinhala = "අදහස් සාකච්ඡා කිරීම",
            pastEnglish = "The team discussed the project idea thoroughly.",
            pastSinhala = "කණ්ඩායම ව්‍යාපෘති අදහස හොඳින් සාකච්ඡා කළහ.",
            presentEnglish = "Good friends discuss problems calmly.",
            presentSinhala = "හොඳ මිතුරෝ ගැටලු සන්සුන්ව සාකච්ඡා කරති.",
            futureEnglish = "We will discuss the plans for the trip tonight.",
            futureSinhala = "අපි චාරිකාව පිළිබඳ සැලසුම් අද රෑ සාකච්ඡා කරන්නෙමු.",
            verbTransformation = "discussed → discuss → will discuss"
          ),
          TenseSentenceItem(
            id = "t11_s18",
            baseActionSinhala = "සමාව අයැදීම",
            pastEnglish = "Amila apologized for being late.",
            pastSinhala = "අමිල ප්‍රමාද වීම ගැන සමාව අයැද සිටියේය.",
            presentEnglish = "Polite people apologize when they make mistakes.",
            presentSinhala = "විශිෂ්ට ගතිගුණ ඇති අය වැරදීමක් වූ විට සමාව අයදිති.",
            futureEnglish = "Amila will apologize to the group this evening.",
            futureSinhala = "අමිල අද සවස කණ්ඩායමෙන් සමාව අයැද සිටිනු ඇත.",
            verbTransformation = "apologized → apologize → will apologize"
          ),
          TenseSentenceItem(
            id = "t11_s19",
            baseActionSinhala = "මිතුරා විශ්වාස කිරීම",
            pastEnglish = "I trusted his sincere advice.",
            pastSinhala = "මම ඔහුගේ අවංක උපදෙස විශ්වාස කළෙමි.",
            presentEnglish = "I trust my best friend completely.",
            presentSinhala = "මම මගේ හොඳම මිතුරා සම්පූර්ණයෙන්ම විශ්වාස කරමි.",
            futureEnglish = "I will trust him to lead our debate group.",
            futureSinhala = "අපේ විවාද කණ්ඩායම මෙහෙයවීමට මම ඔහුව විශ්වාස කරන්නෙමි.",
            verbTransformation = "trusted → trust → will trust"
          ),
          TenseSentenceItem(
            id = "t11_s20",
            baseActionSinhala = "මිතුරන් පිළිගැනීම",
            pastEnglish = "The family welcomed the guests warmly.",
            pastSinhala = "පවුලේ අය අමුත්තන් උණුසුම් ලෙස පිළිගත්හ.",
            presentEnglish = "They welcome every visitor with a glass of water.",
            presentSinhala = "ඔවුහු පැමිණෙන සෑම කෙනෙකුම වතුර වීදුරුවකින් පිළිගනිති.",
            futureEnglish = "We will welcome our foreign pen-friend at the airport.",
            futureSinhala = "අපි ගුවන් තොටුපළේදී අපේ විදේශීය මිතුරා පිළිගන්නෙමු.",
            verbTransformation = "welcomed → welcome → will welcome"
          ),
          TenseSentenceItem(
            id = "t11_s21",
            baseActionSinhala = "සමූහ ඡායාරූපයක් ගැනීම",
            pastEnglish = "We took a group photograph after the sports meet.",
            pastSinhala = "ක්‍රීඩා උළෙලෙන් පසු අපි සමූහ ඡායාරූපයක් ගත්තෙමු.",
            presentEnglish = "Students take group photos on special school occasions.",
            presentSinhala = "සිසුන් පාසලේ විශේෂ අවස්ථාවලදී සමූහ ඡායාරූප ගනිති.",
            futureEnglish = "We will take a group picture before the final bell rings.",
            futureSinhala = "අවසාන සීනුව නාද වීමට පෙර අපි සමූහ ඡායාරූපයක් ගන්නෙමු.",
            verbTransformation = "took → take → will take"
          ),
          TenseSentenceItem(
            id = "t11_s22",
            baseActionSinhala = "හොඳ උපදෙසක් ලබා දීම",
            pastEnglish = "The elder brother advised him to study hard.",
            pastSinhala = "වැඩිමහල් සොහොයුරා ඔහුට මහන්සි වී ඉගෙන ගන්නා ලෙස උපදෙස් දුන්නේය.",
            presentEnglish = "Experienced seniors advise junior students wisely.",
            presentSinhala = "ප්‍රවීණ ජ්‍යෙෂ්ඨයෝ කනිෂ්ඨ සිසුන්ට බුද්ධිමත්ව උපදෙස් දෙති.",
            futureEnglish = "The counselor will advise our batch on career choices.",
            futureSinhala = "උපදේශකවරයා වෘත්තීය තේරීම් පිළිබඳව අපේ කණ්ඩායමට උපදෙස් දෙනු ඇත.",
            verbTransformation = "advised → advise → will advise"
          ),
          TenseSentenceItem(
            id = "t11_s23",
            baseActionSinhala = "එකට අත්පුඩි ගැසීම",
            pastEnglish = "The audience clapped enthusiastically for the singers.",
            pastSinhala = "ප්‍රේක්ෂකාගාරය ගායකයන් වෙනුවෙන් උද්‍යෝගයෙන් අත්පුඩි ගැසූහ.",
            presentEnglish = "Spectators clap when a goal is scored.",
            presentSinhala = "ගෝලයක් වාර්තා වූ විට නරඹන්නෝ අත්පුඩි ගසති.",
            futureEnglish = "We will clap loudly when our friend receives the medal.",
            futureSinhala = "අපේ මිතුරා පදක්කම ලබන විට අපි මහ හඬින් අත්පුඩි ගසන්නෙමු.",
            verbTransformation = "clapped → clap → will clap"
          ),
          TenseSentenceItem(
            id = "t11_s24",
            baseActionSinhala = "ගෞරව දැක්වීම",
            pastEnglish = "Students showed deep respect to their retired teacher.",
            pastSinhala = "විශ්‍රාමික ගුරුවරයාට සිසුහු ගැඹුරු ගෞරවයක් දැක්වූහ.",
            presentEnglish = "Good citizens show respect to elders and community.",
            presentSinhala = "යහපත් පුරවැසියෝ වැඩිහිටියන්ට සහ සමාජයට ගෞරවය දක්වති.",
            futureEnglish = "We will show respect by listening quietly.",
            futureSinhala = "අපි නිහඬව සවන්දීමෙන් ගෞරවය දක්වන්නෙමු.",
            verbTransformation = "showed → show → will show"
          ),
          TenseSentenceItem(
            id = "t11_s25",
            baseActionSinhala = "මිත්‍රත්වය රැකගැනීම",
            pastEnglish = "They maintained their friendship for twenty years.",
            pastSinhala = "ඔවුහු විසි වසරක් පුරා තම මිත්‍රත්වය රැකගත්හ.",
            presentEnglish = "Loyal friends maintain close ties despite distances.",
            presentSinhala = "පක්ෂපාතී මිතුරෝ දුරස්ථභාවය නොසලකා සමීප සබඳතා පවත්වති.",
            futureEnglish = "We will maintain this bond throughout our lives.",
            futureSinhala = "අපගේ ජීවිත කාලය පුරාම අපි මෙම බැඳීම ආරක්ෂා කර ගන්නෙමු.",
            verbTransformation = "maintained → maintain → will maintain"
          ),
          TenseSentenceItem(
            id = "t11_s26",
            baseActionSinhala = "එකට පාඩම් කිරීම",
            pastEnglish = "We studied for the history paper together.",
            pastSinhala = "අපි ඉතිහාස ප්‍රශ්න පත්‍රය සඳහා එකට පාඩම් කළෙමු.",
            presentEnglish = "Study groups help students understand difficult topics.",
            presentSinhala = "පාඩම් කණ්ඩායම් අපහසු විෂය කරුණු තේරුම් ගැනීමට සිසුන්ට උපකාර කරයි.",
            futureEnglish = "We will study maths together on Saturday morning.",
            futureSinhala = "අපි සෙනසුරාදා උදෑසන එකට ගණිතය පාඩම් කරන්නෙමු.",
            verbTransformation = "studied → study / help → will study"
          ),
          TenseSentenceItem(
            id = "t11_s27",
            baseActionSinhala = "මිතුරෙකු ධෛර්යමත් කිරීම",
            pastEnglish = "I encouraged my friend before the speech competition.",
            pastSinhala = "කථික තරඟයට පෙර මම මගේ මිතුරා ධෛර්යමත් කළෙමි.",
            presentEnglish = "A good mentor encourages young talents continually.",
            presentSinhala = "යහපත් මඟපෙන්වන්නෙක් තරුණ දක්ෂතා නිරන්තරයෙන් ධෛර්යමත් කරයි.",
            futureEnglish = "I will encourage him to face the interview confidently.",
            futureSinhala = "සම්මුඛ පරීක්ෂණයට විශ්වාසයෙන් මුහුණ දීමට මම ඔහුව ධෛර්යමත් කරන්නෙමි.",
            verbTransformation = "encouraged → encourages → will encourage"
          ),
          TenseSentenceItem(
            id = "t11_s28",
            baseActionSinhala = "එකට ගීතයක් ගැයීම",
            pastEnglish = "We sang a melodious Sinhala song together.",
            pastSinhala = "අපි එකට මිහිරි සිංහල ගීතයක් ගැයුවෙමු.",
            presentEnglish = "Choir members sing in sweet harmony.",
            presentSinhala = "ගායනා කණ්ඩායමේ සාමාජිකයෝ මිහිරි සුසංයෝගයෙන් ගයති.",
            futureEnglish = "We will sing the national anthem at the opening.",
            futureSinhala = "ආරම්භක අවස්ථාවේදී අපි ජාතික ගීය ගයන්නෙමු.",
            verbTransformation = "sang → sing → will sing"
          ),
          TenseSentenceItem(
            id = "t11_s29",
            baseActionSinhala = "නැවත එකතු වීම සැමරීම",
            pastEnglish = "Old boys celebrated their school centenary.",
            pastSinhala = "ආදි ශිෂ්‍යයෝ තම පාසලේ ශත සංවත්සරය සැමරූහ.",
            presentEnglish = "Friends celebrate each other's birthdays with joy.",
            presentSinhala = "මිතුරෝ එකිනෙකාගේ උපන්දින මහත් සතුටින් සමරති.",
            futureEnglish = "We will celebrate our passing out with a dinner.",
            futureSinhala = "අපේ විභාග සමත් වීම අපි රාත්‍රී භෝජන සංග්‍රහයකින් සමරන්නෙමු.",
            verbTransformation = "celebrated → celebrate → will celebrate"
          ),
          TenseSentenceItem(
            id = "t11_s30",
            baseActionSinhala = "සමුගැනීම",
            pastEnglish = "They said goodbye with tears in their eyes.",
            pastSinhala = "ඔවුහු දෙනෙතේ කඳුළු පුරවාගෙන සමුගත්හ.",
            presentEnglish = "Good friends bid farewell wishing safety and joy.",
            presentSinhala = "යහපත් මිතුරෝ ආරක්ෂාව හා සතුට පතමින් සමුදෙති.",
            futureEnglish = "We will say goodbye after the final assembly.",
            futureSinhala = "අවසාන රැස්වීමෙන් පසු අපි සමුගන්නෙමු.",
            verbTransformation = "said goodbye → bid farewell → will say goodbye"
          )
        )
      ),

      // ==========================================
      // Category 12: තාක්ෂණය, පරිගණක සහ අන්තර්ජාලය (Technology, Computers & Internet) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 12,
        titleSinhala = "කාණ්ඩය 12: තාක්ෂණය, පරිගණක සහ අන්තර්ජාලය",
        titleEnglish = "Technology, Computers & Internet",
        icon = "💻",
        description = "පරිගණක ක්‍රියාත්මක කිරීම, අන්තර්ජාලය පරිශීලනය, ඊමේල්, කේතකරණය සහ තාක්ෂණික මෙවලම් පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t12_s1",
            baseActionSinhala = "පරිගණකය ක්‍රියාත්මක කිරීම",
            pastEnglish = "I turned on the desktop computer at 8:00 AM.",
            pastSinhala = "මම උදෑසන 8:00 ට මේස පරිගණකය ක්‍රියාත්මක කළෙමි.",
            presentEnglish = "I turn on my laptop whenever I begin study.",
            presentSinhala = "මම පාඩම් වැඩ ආරම්භ කරන විට මගේ ලැප්ටොප් පරිගණකය ක්‍රියාත්මක කරමි.",
            futureEnglish = "I will turn on the computer after lunch.",
            futureSinhala = "මම දිවා ආහාරයෙන් පසු පරිගණකය ක්‍රියාත්මක කරන්නෙමි.",
            verbTransformation = "turned on → turn on → will turn on"
          ),
          TenseSentenceItem(
            id = "t12_s2",
            baseActionSinhala = "ඊමේල් පණිවිඩයක් යැවීම",
            pastEnglish = "The clerk sent an important email to the director.",
            pastSinhala = "ලිපිකරු අධ්‍යක්ෂවරයා වෙත වැදගත් ඊමේල් පණිවිඩයක් යැව්වේය.",
            presentEnglish = "He sends work updates via email daily.",
            presentSinhala = "ඔහු දිනපතාම ඊමේල් මඟින් කාර්යාල වාර්තා යවයි.",
            futureEnglish = "He will send the project document by 5:00 PM.",
            futureSinhala = "ඔහු සවස 5:00 ට පෙර ව්‍යාපෘති ලේඛනය යවනු ඇත.",
            verbTransformation = "sent → sends → will send"
          ),
          TenseSentenceItem(
            id = "t12_s3",
            baseActionSinhala = "අධ්‍යාපනික ලිපියක් බාගත කිරීම",
            pastEnglish = "Sahan downloaded the past paper PDF from the website.",
            pastSinhala = "සහන් වෙබ් අඩවියෙන් පසුගිය විභාග ප්‍රශ්න පත්‍ර PDF ගොනුව බාගත කළේය.",
            presentEnglish = "Students download learning materials using school Wi-Fi.",
            presentSinhala = "සිසුහු පාසල් Wi-Fi භාවිතයෙන් අධ්‍යයන ද්‍රව්‍ය බාගත කරති.",
            futureEnglish = "Sahan will download the latest syllabus tonight.",
            futureSinhala = "සහන් අද රෑ අලුත්ම විෂය නිර්දේශය බාගත කරනු ඇත.",
            verbTransformation = "downloaded → download → will download"
          ),
          TenseSentenceItem(
            id = "t12_s4",
            baseActionSinhala = "මුරපදයක් වෙනස් කිරීම",
            pastEnglish = "I changed my social media password yesterday.",
            pastSinhala = "මම ඊයේ මගේ සමාජ මාධ්‍ය මුරපදය වෙනස් කළෙමි.",
            presentEnglish = "Security experts change passwords every three months.",
            presentSinhala = "ආරක්ෂක විශේෂඥයෝ සෑම මස තුනකට වරක් මුරපද වෙනස් කරති.",
            futureEnglish = "I will change my email password for better safety.",
            futureSinhala = "උසස් ආරක්ෂාව සඳහා මම මගේ ඊමේල් මුරපදය වෙනස් කරන්නෙමි.",
            verbTransformation = "changed → change → will change"
          ),
          TenseSentenceItem(
            id = "t12_s5",
            baseActionSinhala = "ලේඛනයක් මුද්‍රණය කිරීම",
            pastEnglish = "The secretary printed fifty copies of the agenda.",
            pastSinhala = "ලේකම්වරිය න්‍යාය පත්‍රයේ පිටපත් පනහක් මුද්‍රණය කළාය.",
            presentEnglish = "She prints urgent reports using the office printer.",
            presentSinhala = "ඇය කාර්යාල මුද්‍රණ යන්ත්‍රය භාවිතයෙන් හදිසි වාර්තා මුද්‍රණය කරයි.",
            futureEnglish = "She will print the certificates tomorrow morning.",
            futureSinhala = "ඇය හෙට උදෑසන සහතිකපත් මුද්‍රණය කරනු ඇත.",
            verbTransformation = "printed → prints → will print"
          ),
          TenseSentenceItem(
            id = "t12_s6",
            baseActionSinhala = "මෘදුකාංග යාවත්කාලීන කිරීම",
            pastEnglish = "The phone updated its operating system automatically.",
            pastSinhala = "දුරකථනය එහි මෙහෙයුම් පද්ධතිය ස්වයංක්‍රීයව යාවත්කාලීන කර ගත්තේය.",
            presentEnglish = "Regular updates protect devices against viruses.",
            presentSinhala = "නිතිපතා යාවත්කාලීන කිරීම් වෛරස් වලින් උපාංග ආරක්ෂා කරයි.",
            futureEnglish = "I will update the antivirus software tonight.",
            futureSinhala = "මම අද රෑ වෛරස් නාශක මෘදුකාංගය යාවත්කාලීන කරන්නෙමි.",
            verbTransformation = "updated → protect / update → will update"
          ),
          TenseSentenceItem(
            id = "t12_s7",
            baseActionSinhala = "අන්තර්ජාලයේ තොරතුරු සෙවීම",
            pastEnglish = "We searched Google for the atomic structure.",
            pastSinhala = "අපි පරමාණුක ව්‍යුහය පිළිබඳව ගූගල් හි සෙව්වෙමු.",
            presentEnglish = "Researchers search online databases for scientific facts.",
            presentSinhala = "පර්යේෂකයෝ විද්‍යාත්මක කරුණු සඳහා මාර්ගගත දත්ත ගබඩා සොයති.",
            futureEnglish = "We will search for cheap air tickets online.",
            futureSinhala = "අපි අන්තර්ජාලයෙන් අඩු මිල ගුවන් ටිකට්පත් සොයන්නෙමු.",
            verbTransformation = "searched → search → will search"
          ),
          TenseSentenceItem(
            id = "t12_s8",
            baseActionSinhala = "ගොනුවක් සුරැකීම",
            pastEnglish = "Amal saved his essay on a USB flash drive.",
            pastSinhala = "අමල් ඔහුගේ රචනාව USB පෙන් ඩ්‍රයිව් එකක සුරැකුවේය.",
            presentEnglish = "He saves his assignments to the cloud storage regularly.",
            presentSinhala = "ඔහු නිතරම තම පැවරුම් ක්ලවුඩ් ගබඩාවේ සුරකියි.",
            futureEnglish = "He will save a backup before restarting the computer.",
            futureSinhala = "පරිගණකය නැවත පණගැන්වීමට පෙර ඔහු අතිරේක පිටපතක් සුරැකෙනු ඇත.",
            verbTransformation = "saved → saves → will save"
          ),
          TenseSentenceItem(
            id = "t12_s9",
            baseActionSinhala = "දුරකථනය ආරෝපණය කිරීම",
            pastEnglish = "I charged the mobile phone overnight.",
            pastSinhala = "මම මුළු රැය පුරා ජංගම දුරකථනය ආරෝපණය කළෙමි.",
            presentEnglish = "I charge my smartphone when battery reaches 20 percent.",
            presentSinhala = "බැටරිය සියයට 20 දක්වා අඩු වූ විට මම ස්මාර්ට් ජංගම දුරකථනය ආරෝපණය කරමි.",
            futureEnglish = "I will charge the power bank before going on the trip.",
            futureSinhala = "චාරිකාව යාමට පෙර මම පවර් බෑන්ක් එක ආරෝපණය කරන්නෙමි.",
            verbTransformation = "charged → charge → will charge"
          ),
          TenseSentenceItem(
            id = "t12_s10",
            baseActionSinhala = "කේතකරණය ඉගෙනීම",
            pastEnglish = "Ravi learned basic Python programming last year.",
            pastSinhala = "රවී පසුගිය වසරේ මූලික පයිතන් ක්‍රමලේඛනය ඉගෙන ගත්තේය.",
            presentEnglish = "He learns Kotlin to build modern Android applications.",
            presentSinhala = "ඔහු නවීන ඇන්ඩ්‍රොයිඩ් යෙදුම් නිර්මාණය කිරීමට කොට්ලින් ඉගෙන ගනියි.",
            futureEnglish = "He will learn machine learning algorithms next semester.",
            futureSinhala = "ඔහු ලබන වාරයේදී යන්ත්‍ර ඉගෙනුම් ඇල්ගොරිතම ඉගෙන ගනු ඇත.",
            verbTransformation = "learned → learns → will learn"
          ),
          TenseSentenceItem(
            id = "t12_s11",
            baseActionSinhala = "පරිගණකය ක්‍රියාවිරහිත කිරීම",
            pastEnglish = "We shut down the computer lab at 5:00 PM.",
            pastSinhala = "අපි සවස 5:00 ට පරිගණක විද්‍යාගාරය ක්‍රියාවිරහිත කළෙමු.",
            presentEnglish = "Responsible users shut down machines after work.",
            presentSinhala = "වගකීම්සහගත පරිශීලකයෝ වැඩ අවසන් වූ පසු යන්ත්‍ර ක්‍රියාවිරහිත කරති.",
            futureEnglish = "I will shut down my PC before leaving the desk.",
            futureSinhala = "මේසයෙන් පිටත්ව යාමට පෙර මම මගේ පරිගණකය ක්‍රියාවිරහිත කරන්නෙමි.",
            verbTransformation = "shut down → shut down → will shut down"
          ),
          TenseSentenceItem(
            id = "t12_s12",
            baseActionSinhala = "වෙබ් අඩවියක් නිර්මාණය කිරීම",
            pastEnglish = "Kasun designed an e-commerce website for his uncle.",
            pastSinhala = "කසුන් තම මාමා වෙනුවෙන් ඊ-වාණිජ්‍ය වෙබ් අඩවියක් නිර්මාණය කළේය.",
            presentEnglish = "He designs modern user interfaces using Figma.",
            presentSinhala = "ඔහු ෆිග්මා භාවිතයෙන් නවීන අතුරුමුහුණත් නිර්මාණය කරයි.",
            futureEnglish = "He will design a portfolio site for our school club.",
            futureSinhala = "ඔහු අපේ පාසල් සමිතිය සඳහා තොරතුරු වෙබ් අඩවියක් නිර්මාණය කරනු ඇත.",
            verbTransformation = "designed → designs → will design"
          ),
          TenseSentenceItem(
            id = "t12_s13",
            baseActionSinhala = "මාර්ගගත පාඩමකට සම්බන්ධ වීම",
            pastEnglish = "Students joined the Zoom class at 4:00 PM.",
            pastSinhala = "සිසුහු සවස 4:00 ට සූම් පන්තියට සම්බන්ධ වූහ.",
            presentEnglish = "They join virtual sessions from home every evening.",
            presentSinhala = "ඔවුහු සෑම සවසකම නිවසේ සිට මාර්ගගත සැසිවාරවලට සම්බන්ධ වෙති.",
            futureEnglish = "We will join the international webinar on Saturday.",
            futureSinhala = "අපි සෙනසුරාදා ජාත්‍යන්තර වෙබිනාර් සම්මන්ත්‍රණයට සම්බන්ධ වන්නෙමු.",
            verbTransformation = "joined → join → will join"
          ),
          TenseSentenceItem(
            id = "t12_s14",
            baseActionSinhala = "වීඩියෝ පටයක් සංස්කරණය කිරීම",
            pastEnglish = "The team edited the educational video skillfully.",
            pastSinhala = "කණ්ඩායම අධ්‍යාපනික වීඩියෝව දක්ෂ ලෙස සංස්කරණය කළහ.",
            presentEnglish = "Video creators edit footage to convey clear messages.",
            presentSinhala = "වීඩියෝ නිර්මාණකරුවෝ පැහැදිලි පණිවිඩ දීමට දර්ශන පෙළ සංස්කරණය කරති.",
            futureEnglish = "I will edit the short film using professional software.",
            futureSinhala = "මම වෘත්තීය මෘදුකාංගයක් භාවිතයෙන් කෙටි චිත්‍රපටය සංස්කරණය කරන්නෙමි.",
            verbTransformation = "edited → edit → will edit"
          ),
          TenseSentenceItem(
            id = "t12_s15",
            baseActionSinhala = "පරිගණක මවුසය භාවිතය",
            pastEnglish = "The little boy clicked the red button on the screen.",
            pastSinhala = "කුඩා පිරිමි ළමයා තිරයේ රතු බොත්තම ක්ලික් කළේය.",
            presentEnglish = "Smooth trackpads make navigation effortless.",
            presentSinhala = "මෘදු ට්‍රැක්පෑඩ් පිරික්සුම පහසු කරයි.",
            futureEnglish = "He will click the submit button after reviewing answers.",
            futureSinhala = "පිළිතුරු පරීක්ෂා කිරීමෙන් පසු ඔහු ඉදිරිපත් කිරීමේ බොත්තම ක්ලික් කරනු ඇත.",
            verbTransformation = "clicked → make → will click"
          ),
          TenseSentenceItem(
            id = "t12_s16",
            baseActionSinhala = "මතකය හිස් කිරීම",
            pastEnglish = "She deleted unnecessary photos to free up storage.",
            pastSinhala = "ඇය ඉඩ නිදහස් කර ගැනීමට අනවශ්‍ය ඡායාරූප මකා දැමුවාය.",
            presentEnglish = "Cloud cleaner apps delete temporary cache files.",
            presentSinhala = "ක්ලවුඩ් ක්ලීනර් යෙදුම් තාවකාලික හැඹිලි ගොනු මකා දමයි.",
            futureEnglish = "I will delete spam emails from my inbox.",
            futureSinhala = "මම මගේ එන ලිපි පෙට්ටියෙන් අනවශ්‍ය ඊමේල් මකා දමන්නෙමි.",
            verbTransformation = "deleted → delete → will delete"
          ),
          TenseSentenceItem(
            id = "t12_s17",
            baseActionSinhala = "වයි-ෆයි ජාලයට සම්බන්ධ වීම",
            pastEnglish = "We connected our tablet to the school network.",
            pastSinhala = "අපි අපේ ටැබ්ලට් පරිගණකය පාසල් ජාලයට සම්බන්ධ කළෙමු.",
            presentEnglish = "Smartphones connect to known Wi-Fi automatically.",
            presentSinhala = "ස්මාර්ට්ෆෝන් හුරුපුරුදු Wi-Fi ජාලවලට ස්වයංක්‍රීයව සම්බන්ධ වෙයි.",
            futureEnglish = "The technician will connect the router to high-speed fiber.",
            futureSinhala = "කාර්මික ශිල්පියා රවුටරය අධිවේගී ෆයිබර් ජාලයට සම්බන්ධ කරනු ඇත.",
            verbTransformation = "connected → connect → will connect"
          ),
          TenseSentenceItem(
            id = "t12_s18",
            baseActionSinhala = "වීඩියෝවක් අන්තර්ජාලයට එක් කිරීම",
            pastEnglish = "The science club uploaded their demonstration video.",
            pastSinhala = "විද්‍යා සංගමය තම ආදර්ශන වීඩියෝව අන්තර්ජාලයට එක් කළහ.",
            presentEnglish = "Educators upload tutorials to YouTube for free learning.",
            presentSinhala = "ගුරුවරු නොමිලේ ඉගෙනුම සඳහා යූටියුබ් වෙත පාඩම් එක් කරති.",
            futureEnglish = "We will upload the tournament highlights tonight.",
            futureSinhala = "අපි තරඟාවලියේ විශේෂ අවස්ථා අද රෑ අන්තර්ජාලයට එක් කරන්නෙමු.",
            verbTransformation = "uploaded → upload → will upload"
          ),
          TenseSentenceItem(
            id = "t12_s19",
            baseActionSinhala = "යතුරුපුවරුවෙන් ටයිප් කිරීම",
            pastEnglish = "She typed a five-hundred-word essay in ten minutes.",
            pastSinhala = "ඇය මිනිත්තු දහයකින් වචන පන්සියයක රචනාවක් ටයිප් කළාය.",
            presentEnglish = "She types fast without looking at the keyboard.",
            presentSinhala = "ඇය යතුරුපුවරුව දෙස නොබලා වේගයෙන් ටයිප් කරයි.",
            futureEnglish = "She will type the meeting minutes accurately.",
            futureSinhala = "ඇය රැස්වීම් වාර්තාව නිවැරදිව ටයිප් කරනු ඇත.",
            verbTransformation = "typed → types → will type"
          ),
          TenseSentenceItem(
            id = "t12_s20",
            baseActionSinhala = "තිරයේ දීප්තිය සකස් කිරීම",
            pastEnglish = "I reduced the screen brightness to protect my eyes.",
            pastSinhala = "මම ඇස් ආරක්ෂා කර ගැනීමට තිරයේ දීප්තිය අඩු කළෙමි.",
            presentEnglish = "Night mode reduces eye strain during prolonged reading.",
            presentSinhala = "රාත්‍රී මාදිලිය දීර්ඝ කියවීම් වලදී ඇස් වෙහෙසීම අඩු කරයි.",
            futureEnglish = "I will adjust the monitor height for correct posture.",
            futureSinhala = "නිවැරදි ඉරියව්ව සඳහා මම මොනිටරයේ උස සකස් කරන්නෙමි.",
            verbTransformation = "reduced → reduces → will adjust"
          ),
          TenseSentenceItem(
            id = "t12_s21",
            baseActionSinhala = "කෘතිම බුද්ධිය භාවිතය",
            pastEnglish = "Scientists tested the AI diagnostic tool in clinics.",
            pastSinhala = "විද්‍යාඥයෝ සායනවලදී කෘතිම බුද්ධි රෝග විනිශ්චය මෙවලම පරීක්ෂා කළහ.",
            presentEnglish = "AI assists doctors in identifying complex medical patterns.",
            presentSinhala = "සංකීර්ණ වෛද්‍ය රටා හඳුනා ගැනීමට කෘතිම බුද්ධිය වෛද්‍යවරුන්ට උපකාර කරයි.",
            futureEnglish = "Modern technology will transform public transport systems.",
            futureSinhala = "නවීන තාක්ෂණය පොදු ප්‍රවාහන පද්ධති පරිවර්තනය කරනු ඇත.",
            verbTransformation = "tested → assists → will transform"
          ),
          TenseSentenceItem(
            id = "t12_s22",
            baseActionSinhala = "දෝෂ නිරාකරණය කිරීම",
            pastEnglish = "The programmer fixed the login bug quickly.",
            pastSinhala = "ක්‍රමලේඛකයා පිවිසුම් දෝෂය ඉක්මනින් නිවැරදි කළේය.",
            presentEnglish = "Software engineers fix code bugs through debugging tools.",
            presentSinhala = "මෘදුකාංග ඉංජිනේරුවෝ ඩීබග් කිරීමේ මෙවලම් මඟින් කේත දෝෂ නිවැරදි කරති.",
            futureEnglish = "We will fix the broken database connection soon.",
            futureSinhala = "අපි ඉක්මනින්ම බිඳවැටුණු දත්ත සමුදා සම්බන්ධතාව නිවැරදි කරන්නෙමු.",
            verbTransformation = "fixed → fix → will fix"
          ),
          TenseSentenceItem(
            id = "t12_s23",
            baseActionSinhala = "ඩිජිටල් ගෙවීම් කිරීම",
            pastEnglish = "Father paid the electricity bill using an online app.",
            pastSinhala = "තාත්තා ඔන්ලයින් ඇප් එකක් භාවිතයෙන් විදුලි බිල ගෙවූයේය.",
            presentEnglish = "Online banking saves valuable travel time and transport costs.",
            presentSinhala = "ඔන්ලයින් බැංකුකරණය වටිනා කාලය සහ ප්‍රවාහන වියදම් ඉතිරි කරයි.",
            futureEnglish = "He will pay the water bill via mobile banking.",
            futureSinhala = "ඔහු ජංගම බැංකුකරණය හරහා ජල බිල ගෙවනු ඇත.",
            verbTransformation = "paid → saves → will pay"
          ),
          TenseSentenceItem(
            id = "t12_s24",
            baseActionSinhala = "මාර්ගගත විභාගයකට පෙනී සිටීම",
            pastEnglish = "Naveen took the online chemistry quiz at 7:00 PM.",
            pastSinhala = "නවීන් සවස 7:00 ට මාර්ගගත රසායන විද්‍යා කෙටි විභාගයට පෙනී සිටියේය.",
            presentEnglish = "Students take practice quizzes to evaluate exam readiness.",
            presentSinhala = "විභාග සූදානම මැන බැලීමට සිසුහු පුහුණු ප්‍රශ්න පත්‍රවලට පෙනී සිටිති.",
            futureEnglish = "Naveen will take the final term test on the computer.",
            futureSinhala = "නවීන් පරිගණකය මඟින් අවසාන වාර විභාගයට පෙනී සිටිනු ඇත.",
            verbTransformation = "took → take → will take"
          ),
          TenseSentenceItem(
            id = "t12_s25",
            baseActionSinhala = "ඩිජිටල් කැමරාව භාවිතය",
            pastEnglish = "The photographer captured sharp macro pictures of insects.",
            pastSinhala = "ඡායාරූප ශිල්පියා කෘමීන්ගේ ඉතා පැහැදිලි ඡායාරූප ගත්තේය.",
            presentEnglish = "High-resolution lenses capture fine details with clarity.",
            presentSinhala = "උසස් විභේදන කාච සියුම් විස්තර පැහැදිලිව ග්‍රහණය කර ගනී.",
            futureEnglish = "He will capture the evening sunset over Galle Fort.",
            futureSinhala = "ඔහු ගාලු කොටුවට ඉහළින් බැසයන හිරුගේ දසුන ඡායාරූප ගත කරනු ඇත.",
            verbTransformation = "captured → capture → will capture"
          ),
          TenseSentenceItem(
            id = "t12_s26",
            baseActionSinhala = "හෙඩ්ෆෝන් පැළඳීම",
            pastEnglish = "I wore noise-cancelling headphones during the flight.",
            pastSinhala = "ගුවන් ගමනේදී මම ශබ්දය වළක්වන හෙඩ්ෆෝන් පැළඳ සිටියෙමි.",
            presentEnglish = "Sound engineers wear monitor headphones for precision.",
            presentSinhala = "ශබ්ද ඉංජිනේරුවෝ නිරවද්‍යතාව සඳහා මොනිටර් හෙඩ්ෆෝන් පළඳිති.",
            futureEnglish = "I will wear headphones while listening to the audio lesson.",
            futureSinhala = "ශ්‍රව්‍ය පාඩමට සවන් දෙන අතරතුර මම හෙඩ්ෆෝන් පළඳින්නෙමි.",
            verbTransformation = "wore → wear → will wear"
          ),
          TenseSentenceItem(
            id = "t12_s27",
            baseActionSinhala = "නව යෙදුමක් ස්ථාපනය කිරීම",
            pastEnglish = "She installed an English vocabulary app on her tablet.",
            pastSinhala = "ඇය තම ටැබ්ලටයේ ඉංග්‍රීසි වචන මාලා යෙදුමක් ස්ථාපනය කළාය.",
            presentEnglish = "Helpful apps facilitate self-paced distance learning.",
            presentSinhala = "ප්‍රයෝජනවත් යෙදුම් ස්වයං අධ්‍යයනය පහසු කරයි.",
            futureEnglish = "She will install the latest version from Play Store.",
            futureSinhala = "ඇය ප්ලේ ස්ටෝර් වෙතින් නවතම අනුවාදය ස්ථාපනය කරනු ඇත.",
            verbTransformation = "installed → facilitate → will install"
          ),
          TenseSentenceItem(
            id = "t12_s28",
            baseActionSinhala = "පරිගණක වෛරස් ඉවත් කිරීම",
            pastEnglish = "The technician cleaned malicious malware from the hard disk.",
            pastSinhala = "කාර්මිකයා දෘඪ තැටියෙන් අනිෂ්ට වෛරස් ඉවත් කළේය.",
            presentEnglish = "Firewalls block unauthorized traffic effectively.",
            presentSinhala = "ෆයර්වෝල් අනවසර දත්ත හුවමාරුව සාර්ථකව අවහිර කරයි.",
            futureEnglish = "The system will scan the flash drive before opening files.",
            futureSinhala = "ගොනු විවෘත කිරීමට පෙර පද්ධතිය පෙන් ඩ්‍රයිව් එක පරීක්ෂා කරනු ඇත.",
            verbTransformation = "cleaned → block → will scan"
          ),
          TenseSentenceItem(
            id = "t12_s29",
            baseActionSinhala = "මාර්ගගත පාඨමාලාවක් අවසන් කිරීම",
            pastEnglish = "Thilina completed a web development certificate course.",
            pastSinhala = "තිළිණ වෙබ් නිර්මාණ සහතිකපත්‍ර පාඨමාලාවක් සාර්ථකව අවසන් කළේය.",
            presentEnglish = "Online learning allows students to study at their own pace.",
            presentSinhala = "මාර්ගගත ඉගෙනුම සිසුන්ට තම රිද්මයට අනුව ඉගෙනීමට ඉඩ සලසයි.",
            futureEnglish = "Thilina will complete his cloud certification next month.",
            futureSinhala = "තිළිණ ලබන මාසයේදී ඔහුගේ ක්ලවුඩ් සහතිකය සම්පූර්ණ කරනු ඇත.",
            verbTransformation = "completed → allows → will complete"
          ),
          TenseSentenceItem(
            id = "t12_s30",
            baseActionSinhala = "නවීන තාක්ෂණය වැළඳ ගැනීම",
            pastEnglish = "Sri Lanka introduced smart identity cards nationwide.",
            pastSinhala = "ශ්‍රී ලංකාව රට පුරා ස්මාර්ට් හැඳුනුම්පත් හඳුන්වා දුන්නේය.",
            presentEnglish = "Digital governance improves public service efficiency.",
            presentSinhala = "ඩිජිටල් රාජ්‍ය පාලනය රාජ්‍ය සේවයේ කාර්යක්ෂමතාව වැඩි කරයි.",
            futureEnglish = "Our society will achieve full digital literacy soon.",
            futureSinhala = "අපේ සමාජය ඉක්මනින්ම පූර්ණ ඩිජිටල් සාක්ෂරතාවයක් අත්පත් කර ගනු ඇත.",
            verbTransformation = "introduced → improves → will achieve"
          )
        )
      ),

      // ==========================================
      // Category 13: සන්නිවේදනය සහ දුරකථන සංවාද (Communication & Phone Calls) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 13,
        titleSinhala = "කාණ්ඩය 13: සන්නිවේදනය සහ දුරකථන සංවාද",
        titleEnglish = "Communication & Phone Calls",
        icon = "📞",
        description = "ඇමතුම් ගැනීම, කෙටි පණිවිඩ යැවීම, පණිවිඩ තැබීම සහ සන්නිවේදන ක්‍රම පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t13_s1",
            baseActionSinhala = "දුරකථන ඇමතුමක් ගැනීම",
            pastEnglish = "I called my grandmother yesterday evening.",
            pastSinhala = "මම ඊයේ සවස මගේ මිත්තණියට දුරකථන ඇමතුමක් ගත්තෙමි.",
            presentEnglish = "I call my parents every Sunday without fail.",
            presentSinhala = "මම කිසිදු අතපසු වීමකින් තොරව සෑම ඉරිදාම දෙමව්පියන්ට කතා කරමි.",
            futureEnglish = "I will call the doctor to book an appointment.",
            futureSinhala = "වෛද්‍යවරයා හමුවීමට වේලාවක් වෙන් කරවා ගැනීමට මම කතා කරන්නෙමි.",
            verbTransformation = "called → call → will call"
          ),
          TenseSentenceItem(
            id = "t13_s2",
            baseActionSinhala = "කෙටි පණිවිඩයක් යැවීම",
            pastEnglish = "She sent an SMS to confirm her arrival.",
            pastSinhala = "ඇය පැමිණීම තහවුරු කිරීමට කෙටි පණිවිඩයක් යැව්වාය.",
            presentEnglish = "She sends text messages to coordinate group meetings.",
            presentSinhala = "කණ්ඩායම් රැස්වීම් සම්බන්ධීකරණය කිරීමට ඇය කෙටි පණිවිඩ යවයි.",
            futureEnglish = "She will send an SMS as soon as the bus departs.",
            futureSinhala = "බස් රථය පිටත් වූ වහාම ඇය කෙටි පණිවිඩයක් එවනු ඇත.",
            verbTransformation = "sent → sends → will send"
          ),
          TenseSentenceItem(
            id = "t13_s3",
            baseActionSinhala = "ඇමතුමකට පිළිතුරු දීම",
            pastEnglish = "Father answered the ringing phone promptly.",
            pastSinhala = "තාත්තා නාද වන දුරකථනයට වහාම පිළිතුරු දුන්නේය.",
            presentEnglish = "The receptionist answers client inquiries politely.",
            presentSinhala = "පිළිගැනීමේ නිලධාරිනිය සේවාදායක විමසීම්වලට ආචාරශීලීව පිළිතුරු දෙයි.",
            futureEnglish = "I will answer the phone when it rings.",
            futureSinhala = "දුරකථනය නාද වන විට මම ඊට පිළිතුරු දෙන්නෙමි.",
            verbTransformation = "answered → answers → will answer"
          ),
          TenseSentenceItem(
            id = "t13_s4",
            baseActionSinhala = "පණිවිඩයක් සටහන් කර ගැනීම",
            pastEnglish = "The clerk took down the message carefully.",
            pastSinhala = "ලිපිකරු පණිවිඩය ඉතා සැලකිල්ලෙන් සටහන් කර ගත්තේය.",
            presentEnglish = "Secretaries take notes during phone conferences.",
            presentSinhala = "දුරකථන සාකච්ඡා අතරතුර ලේකම්වරු සටහන් තබා ගනිති.",
            futureEnglish = "I will take a clear message if anyone calls.",
            futureSinhala = "යමෙකු කතා කළහොත් මම පැහැදිලි පණිවිඩයක් සටහන් කර ගන්නෙමි.",
            verbTransformation = "took down → take notes → will take"
          ),
          TenseSentenceItem(
            id = "t13_s5",
            baseActionSinhala = "නැවත අමතන ලෙස ඉල්ලීම",
            pastEnglish = "He asked me to ring back in fifteen minutes.",
            pastSinhala = "මිනිත්තු පහළොවකින් නැවත අමතන ලෙස ඔහු මගෙන් ඉල්ලා සිටියේය.",
            presentEnglish = "Busy executives request callers to phone back later.",
            presentSinhala = "කාර්යබහුල විධායකයෝ පසුව නැවත අමතන ලෙස ඉල්ලා සිටිති.",
            futureEnglish = "I will ring you back as soon as I finish the exam.",
            futureSinhala = "විභාගය අවසන් වූ වහාම මම ඔබට නැවත අමතන්නෙමි.",
            verbTransformation = "asked → request → will ring back"
          ),
          TenseSentenceItem(
            id = "t13_s6",
            baseActionSinhala = "වැරදි අංකයකට ඇමතීම",
            pastEnglish = "The stranger dialed the wrong number by mistake.",
            pastSinhala = "ආගන්තුකයා අත්වැරදීමකින් වැරදි අංකයකට ඇමතුවේය.",
            presentEnglish = "Careful people verify contact digits before pressing dial.",
            presentSinhala = "ප්‍රවේශම් සහගත පුද්ගලයෝ අංක එබීමට පෙර අංක පරීක්ෂා කරති.",
            futureEnglish = "I will double-check the number so I will not dial wrong.",
            futureSinhala = "වැරදි අංකයකට නොඇමතීමට මම අංකය දෙවරක් පරීක්ෂා කරන්නෙමි.",
            verbTransformation = "dialed → verify → will not dial"
          ),
          TenseSentenceItem(
            id = "t13_s7",
            baseActionSinhala = "ඇමතුම විසන්ධි වීම",
            pastEnglish = "The call disconnected due to weak network coverage.",
            pastSinhala = "දුර්වල ජාල ආවරණය හේතුවෙන් ඇමතුම විසන්ධි විය.",
            presentEnglish = "Underground tunnels often disconnect cellular signals.",
            presentSinhala = "භූගත උමං මාර්ග බොහෝ විට සෙලියුලර් සංඥා විසන්ධි කරයි.",
            futureEnglish = "The line will disconnect if the balance runs out.",
            futureSinhala = "ශේෂය අවසන් වුවහොත් ඇමතුම් මාර්ගය විසන්ධි වනු ඇත.",
            verbTransformation = "disconnected → disconnect → will disconnect"
          ),
          TenseSentenceItem(
            id = "t13_s8",
            baseActionSinhala = "හඬ පණිවිඩයක් තැබීම",
            pastEnglish = "I left a voicemail on his mobile phone.",
            pastSinhala = "මම ඔහුගේ ජංගම දුරකථනයට හඬ පණිවිඩයක් තැබුවෙමි.",
            presentEnglish = "Callers leave voicemails when lines are busy.",
            presentSinhala = "ඇමතුම් මාර්ග කාර්යබහුල වූ විට අමතන්නෝ හඬ පණිවිඩ තබති.",
            futureEnglish = "I will leave a voice message if he does not answer.",
            futureSinhala = "ඔහු පිළිතුරු නොදුනහොත් මම හඬ පණිවිඩයක් තබන්නෙමි.",
            verbTransformation = "left → leave → will leave"
          ),
          TenseSentenceItem(
            id = "t13_s9",
            baseActionSinhala = "දුරකථනය නිහඬ කිරීම",
            pastEnglish = "We put our phones on silent before entering the library.",
            pastSinhala = "පුස්තකාලයට ඇතුළු වීමට පෙර අපි අපේ දුරකථන නිහඬ කළෙමු.",
            presentEnglish = "Respectful people mute their phones during formal ceremonies.",
            presentSinhala = "ගෞරවනීය පුද්ගලයෝ උත්සව අවස්ථාවලදී තම දුරකථන නිහඬ කරති.",
            futureEnglish = "I will mute my phone before the presentation starts.",
            futureSinhala = "දේශනය ආරම්භ වීමට පෙර මම මගේ දුරකථනය නිහඬ කරන්නෙමි.",
            verbTransformation = "put on silent → mute → will mute"
          ),
          TenseSentenceItem(
            id = "t13_s10",
            baseActionSinhala = "වීඩියෝ ඇමතුමක් ගැනීම",
            pastEnglish = "Grandma made a video call to her grandson overseas.",
            pastSinhala = "ආච්චි විදේශගතව සිටින තම මුනුපුරාට වීඩියෝ ඇමතුමක් ගත්තාය.",
            presentEnglish = "Families make video calls to stay connected across continents.",
            presentSinhala = "මහාද්වීප හරහා සබඳතා පවත්වා ගැනීමට පවුල් වීඩියෝ ඇමතුම් ගනිති.",
            futureEnglish = "We will make a WhatsApp video call on New Year's Day.",
            futureSinhala = "අලුත් අවුරුදු දිනයේදී අපි වට්ස්ඇප් වීඩියෝ ඇමතුමක් ගන්නෙමු.",
            verbTransformation = "made → make → will make"
          ),
          TenseSentenceItem(
            id = "t13_s11",
            baseActionSinhala = "පැහැදිලිව කතා කිරීම",
            pastEnglish = "The announcer spoke clearly and distinctly.",
            pastSinhala = "නිවේදකයා ඉතා පැහැදිලිව හා ප්‍රකාශිතව කතා කළේය.",
            presentEnglish = "Good speakers pronounce every syllable clearly.",
            presentSinhala = "දක්ෂ කථිකයෝ සෑම අක්ෂරයක්ම පැහැදිලිව උච්චාරණය කරති.",
            futureEnglish = "I will speak slowly so everyone can understand me.",
            futureSinhala = "සියලු දෙනාටම තේරුම් ගත හැකි වන පරිදි මම සෙමින් කතා කරන්නෙමි.",
            verbTransformation = "spoke → pronounce → will speak"
          ),
          TenseSentenceItem(
            id = "t13_s12",
            baseActionSinhala = "ඇහුම්කන් දීම",
            pastEnglish = "The officer listened attentively to the complaint.",
            pastSinhala = "නිලධාරියා පැමිණිල්ලට ඉතා අවධානයෙන් ඇහුම්කන් දුන්නේය.",
            presentEnglish = "Active listeners understand situations with empathy.",
            presentSinhala = "සක්‍රීය ශ්‍රාවකයෝ සංවේදනයෙන් යුතුව තත්වයන් වටහා ගනිති.",
            futureEnglish = "We will listen patiently to the guest speaker.",
            futureSinhala = "අපි ආරාධිත කථිකයාට ඉවසීමෙන් යුතුව ඇහුම්කන් දෙන්නෙමු.",
            verbTransformation = "listened → understand → will listen"
          ),
          TenseSentenceItem(
            id = "t13_s13",
            baseActionSinhala = "ප්‍රවෘත්ති ප්‍රකාශය විකාශය කිරීම",
            pastEnglish = "The radio broadcast the urgent flood warning at noon.",
            pastSinhala = "ගුවන්විදුලිය දහවල් හදිසි ගංවතුර අනතුරු ඇඟවීම විකාශය කළේය.",
            presentEnglish = "National broadcasters transmit vital public alerts continuously.",
            presentSinhala = "ජාතික විකාශකයෝ වැදගත් මහජන අනතුරු ඇඟවීම් අඛණ්ඩව විකාශය කරති.",
            futureEnglish = "The station will broadcast live election results tonight.",
            futureSinhala = "ගුවන්විදුලි මධ්‍යස්ථානය අද රෑ සජීවී මැතිවරණ ප්‍රතිඵල විකාශය කරනු ඇත.",
            verbTransformation = "broadcast → transmit → will broadcast"
          ),
          TenseSentenceItem(
            id = "t13_s14",
            baseActionSinhala = "ලිපියක් තැපැල් කිරීම",
            pastEnglish = "I posted the handwritten letter at the sub-post office.",
            pastSinhala = "මම උප තැපැල් කාර්යාලයෙන් අතින් ලියූ ලිපිය තැපැල් කළෙමි.",
            presentEnglish = "Traditional postal mail carries personal emotions beautifully.",
            presentSinhala = "සාම්ප්‍රදායික තැපැල් ලිපි පුද්ගලික හැඟීම් මනාව රැගෙන යයි.",
            futureEnglish = "I will post the application by registered mail.",
            futureSinhala = "මම ලියාපදිංචි තැපෑලෙන් අයදුම්පත තැපැල් කරන්නෙමි.",
            verbTransformation = "posted → carries → will post"
          ),
          TenseSentenceItem(
            id = "t13_s15",
            baseActionSinhala = "මුද්දර ඇලවීම",
            pastEnglish = "She stuck a twenty-rupee postage stamp on the envelope.",
            pastSinhala = "ඇය ලියුම් කවරයේ රුපියල් විස්සක තැපැල් මුද්දරයක් ඇලවූවාය.",
            presentEnglish = "Philatelists collect rare historic stamps with passion.",
            presentSinhala = "මුද්දර එකතු කරන්නෝ දුර්ලභ ඓතිහාසික මුද්දර මහත් ආශාවෙන් එකතු කරති.",
            futureEnglish = "She will stick an airmail sticker on the parcel.",
            futureSinhala = "ඇය පාර්සලයේ ගුවන් තැපැල් ස්ටිකරයක් අලවනු ඇත.",
            verbTransformation = "stuck → collect → will stick"
          ),
          TenseSentenceItem(
            id = "t13_s16",
            baseActionSinhala = "කණ්ඩායම් සාකච්ඡාවක් පැවැත්වීම",
            pastEnglish = "The committee held a fruitful conference yesterday.",
            pastSinhala = "කමිටුව ඊයේ ඵලදායී සාකච්ඡාවක් පැවැත්වීය.",
            presentEnglish = "Effective communicators build understanding through dialogue.",
            presentSinhala = "දක්ෂ සන්නිවේදකයෝ සංවාද මඟින් අනොන්‍ය අවබෝධය ගොඩනඟති.",
            futureEnglish = "We will hold an open forum next Monday.",
            futureSinhala = "අපි ලබන සඳුදා විවෘත සංසදයක් පවත්වන්නෙමු.",
            verbTransformation = "held → build → will hold"
          ),
          TenseSentenceItem(
            id = "t13_s17",
            baseActionSinhala = "ප්‍රවෘත්ති නිවේදනයක් නිකුත් කිරීම",
            pastEnglish = "The ministry issued an official statement this morning.",
            pastSinhala = "අමාත්‍යාංශය අද උදෑසන නිල නිවේදනයක් නිකුත් කළේය.",
            presentEnglish = "Press officers release verified reports to the media.",
            presentSinhala = "මාධ්‍ය නිලධාරීහු තහවුරු කළ වාර්තා මාධ්‍ය වෙත නිකුත් කරති.",
            futureEnglish = "The department will issue new safety guidelines tomorrow.",
            futureSinhala = "දෙපාර්තමේන්තුව හෙට නව ආරක්ෂක මාර්ගෝපදේශ නිකුත් කරනු ඇත.",
            verbTransformation = "issued → release → will issue"
          ),
          TenseSentenceItem(
            id = "t13_s18",
            baseActionSinhala = "කෙටි පණිවිඩයක් කියවීම",
            pastEnglish = "I read the congratulatory message with delight.",
            pastSinhala = "මම සුබපැතුම් පණිවිඩය මහත් සතුටින් කියෙව්වෙමි.",
            presentEnglish = "Prompt responders read messages and reply without delay.",
            presentSinhala = "ක්‍රියාශීලී ප්‍රතිචාර දක්වන්නෝ පණිවිඩ කියවා ප්‍රමාදයකින් තොරව පිළිතුරු දෙති.",
            futureEnglish = "I will read the instruction manual before proceeding.",
            futureSinhala = "ඉදිරියට යාමට පෙර මම උපදෙස් අත්පොත කියවන්නෙමි.",
            verbTransformation = "read (past) → read (present) → will read"
          ),
          TenseSentenceItem(
            id = "t13_s19",
            baseActionSinhala = "ඇමතුම නැවැත්වීම",
            pastEnglish = "He hung up the phone after the cordial chat.",
            pastSinhala = "සුහද කතාබහෙන් පසු ඔහු දුරකථනය තැබුවේය.",
            presentEnglish = "Polite people say farewell before they hang up.",
            presentSinhala = "ආචාරශීලී මිනිස්සු දුරකථනය තැබීමට පෙර සමුගනිති.",
            futureEnglish = "I will hang up now because someone is knocking on the door.",
            futureSinhala = "යමෙකු දොරට තට්ටු කරන නිසා මම දැන් දුරකථනය තබන්නෙමි.",
            verbTransformation = "hung up → hang up → will hang up"
          ),
          TenseSentenceItem(
            id = "t13_s20",
            baseActionSinhala = "හඬ පාලනය කිරීම",
            pastEnglish = "She lowered her voice in the quiet exam hall.",
            pastSinhala = "නිහඬ විභාග ශාලාවේදී ඇය තම කටහඬ පහත් කළාය.",
            presentEnglish = "Disciplined students keep their voices down in libraries.",
            presentSinhala = "විනයගරුක සිසුහු පුස්තකාලවලදී තම කටහඬ පහත් මට්ටමක තබා ගනිති.",
            futureEnglish = "I will speak softly so I do not wake the baby.",
            futureSinhala = "ළදරුවා අවදි නොවන පරිදි මම සෙමින් කතා කරන්නෙමි.",
            verbTransformation = "lowered → keep down → will speak softly"
          ),
          TenseSentenceItem(
            id = "t13_s21",
            baseActionSinhala = "අංගචලනයන් භාවිතයෙන් සන්නිවේදනය",
            pastEnglish = "The deaf traveler communicated through sign language.",
            pastSinhala = "බිහිරි සංචාරකයා සංඥා භාෂාව මඟින් සන්නිවේදනය කළේය.",
            presentEnglish = "Sign language bridges barriers between diverse people.",
            presentSinhala = "සංඥා භාෂාව විවිධ මිනිසුන් අතර බාධක දුරු කරයි.",
            futureEnglish = "We will learn sign gestures to assist disabled friends.",
            futureSinhala = "බාධිත මිතුරන්ට උපකාර කිරීම සඳහා අපි සංඥා ඉගෙන ගන්නෙමු.",
            verbTransformation = "communicated → bridges → will learn"
          ),
          TenseSentenceItem(
            id = "t13_s22",
            baseActionSinhala = "අනතුරු ඇඟවීමේ සීනුව නාද කිරීම",
            pastEnglish = "The guard rang the emergency bell loudly.",
            pastSinhala = "මුරකරුවා හදිසි අනතුරු ඇඟවීමේ සීනුව මහ හඬින් නාද කළේය.",
            presentEnglish = "Fire sirens warn occupants in case of danger.",
            presentSinhala = "ගිනි අනතුරු සයිරන් අනතුරකදී නිවැසියන්ට අනතුරු අඟවයි.",
            futureEnglish = "The system will ring automatically if smoke is detected.",
            futureSinhala = "දුමාරය හඳුනාගතහොත් පද්ධතිය ස්වයංක්‍රීයව නාද වනු ඇත.",
            verbTransformation = "rang → warn → will ring"
          ),
          TenseSentenceItem(
            id = "t13_s23",
            baseActionSinhala = "මයික්‍රෆෝනයක් භාවිතය",
            pastEnglish = "The head prefect adjusted the microphone before speaking.",
            pastSinhala = "ප්‍රධාන ශිෂ්‍ය නායකයා කතා කිරීමට පෙර මයික්‍රෆෝනය සකස් කළේය.",
            presentEnglish = "Public speakers test microphones to verify sound clarity.",
            presentSinhala = "ප්‍රසිද්ධ කථිකයෝ ශබ්දයේ පැහැදිලිකම තහවුරු කිරීමට මයික්‍රෆෝන පරීක්ෂා කරති.",
            futureEnglish = "I will test the mic before the debate begins.",
            futureSinhala = "විවාදය ආරම්භ වීමට පෙර මම මයික්‍රෆෝනය පරීක්ෂා කරන්නෙමි.",
            verbTransformation = "adjusted → test → will test"
          ),
          TenseSentenceItem(
            id = "t13_s24",
            baseActionSinhala = "ස්තුති ලිපියක් යැවීම",
            pastEnglish = "We sent a thank-you note to our guest speaker.",
            pastSinhala = "අපි අපගේ ආරාධිත කථිකයාට ස්තුති ලිපියක් යැව්වෙමු.",
            presentEnglish = "Grateful organizations express appreciation in writing.",
            presentSinhala = "කෘතඥ ආයතන ලිඛිතව ඇගයීම ප්‍රකාශ කරති.",
            futureEnglish = "I will send a gratitude card to my mentor.",
            futureSinhala = "මම මගේ උපදේශකයාට කෘතඥතා පතක් යවන්නෙමි.",
            verbTransformation = "sent → express → will send"
          ),
          TenseSentenceItem(
            id = "t13_s25",
            baseActionSinhala = "හමුවීමක් තහවුරු කිරීම",
            pastEnglish = "The secretary confirmed the appointment yesterday afternoon.",
            pastSinhala = "ලේකම්වරිය ඊයේ දහවල් හමුවීම තහවුරු කළාය.",
            presentEnglish = "Clinics confirm appointments via automated reminders.",
            presentSinhala = "සායන ස්වයංක්‍රීය මතක් කිරීම් මඟින් වේලාවන් තහවුරු කරයි.",
            futureEnglish = "I will confirm the flight departure time tomorrow.",
            futureSinhala = "මම හෙට ගුවන් ගමන පිටත්වීමේ වේලාව තහවුරු කරන්නෙමි.",
            verbTransformation = "confirmed → confirm → will confirm"
          ),
          TenseSentenceItem(
            id = "t13_s26",
            baseActionSinhala = "ප්‍රවෘත්ති පත්‍රයක් කියවීම",
            pastEnglish = "Grandfather read the morning newspaper thoroughly.",
            pastSinhala = "සීයා උදෑසන පුවත්පත හොඳින් කියෙව්වේය.",
            presentEnglish = "Citizens read daily news to remain informed of world events.",
            presentSinhala = "පුරවැසියෝ ලෝක සිදුවීම් පිළිබඳව දැනුවත්ව සිටීමට දිනපතා පුවත්පත් කියවති.",
            futureEnglish = "I will read today's editorial during my break.",
            futureSinhala = "මගේ විවේකයේදී මම අද කතුවැකිය කියවන්නෙමි.",
            verbTransformation = "read (past) → read (present) → will read"
          ),
          TenseSentenceItem(
            id = "t13_s27",
            baseActionSinhala = "ප්‍රශ්නයක් ඇසීම",
            pastEnglish = "A brave student asked an insightful question.",
            pastSinhala = "නිර්භීත ශිෂ්‍යයෙක් ගැඹුරු ප්‍රශ්නයක් ඇසුවේය.",
            presentEnglish = "Curious minds ask questions to broaden knowledge.",
            presentSinhala = "කුතුහලය දනවන මනස් දැනුම පුළුල් කර ගැනීමට ප්‍රශ්න අසයි.",
            futureEnglish = "I will ask the instructor after the lecture concludes.",
            futureSinhala = "දේශනය අවසන් වූ පසු මම උපදේශකගෙන් අසන්නෙමි.",
            verbTransformation = "asked → ask → will ask"
          ),
          TenseSentenceItem(
            id = "t13_s28",
            baseActionSinhala = "කතාවක් පැවැත්වීම",
            pastEnglish = "The principal delivered an inspiring speech at assembly.",
            pastSinhala = "විදුහල්පතිතුමා රැස්වීමේදී ප්‍රබෝධමත් කතාවක් පැවැත්වීය.",
            presentEnglish = "Great leaders inspire nations through compelling speeches.",
            presentSinhala = "ශ්‍රේෂ්ඨ නායකයෝ ආකර්ෂණීය කතා මඟින් ජාතීන් ප්‍රබෝධමත් කරති.",
            futureEnglish = "The head girl will deliver the vote of thanks.",
            futureSinhala = "ප්‍රධාන ශිෂ්‍ය නායිකාව ස්තුති කතාව පවත්වනු ඇත.",
            verbTransformation = "delivered → inspire → will deliver"
          ),
          TenseSentenceItem(
            id = "t13_s29",
            baseActionSinhala = "අදහස් හුවමාරු කර ගැනීම",
            pastEnglish = "Scientists exchanged groundbreaking research ideas.",
            pastSinhala = "විද්‍යාඥයෝ පෙරළිකාර පර්යේෂණ අදහස් හුවමාරු කර ගත්හ.",
            presentEnglish = "Effective communication unites diverse global cultures.",
            presentSinhala = "ඵලදායී සන්නිවේදනය විවිධ ගෝලීය සංස්කෘතීන් එක්සත් කරයි.",
            futureEnglish = "We will share our study notes with absent classmates.",
            futureSinhala = "පැමිණීමට නොහැකි වූ පන්ති මිතුරන් සමඟ අපි පාඩම් සටහන් බෙදා ගන්නෙමු.",
            verbTransformation = "exchanged → unites → will share"
          ),
          TenseSentenceItem(
            id = "t13_s30",
            baseActionSinhala = "සන්නිවේදන කුසලතා වැඩිදියුණු කර ගැනීම",
            pastEnglish = "Kamal improved his spoken fluency remarkably.",
            pastSinhala = "කමල් තම කථන චතුරතාව කැපී පෙනෙන ලෙස වැඩිදියුණු කර ගත්තේය.",
            presentEnglish = "Consistent practice sharpens communication skills.",
            presentSinhala = "නිරන්තර පුහුණුව සන්නිවේදන කුසලතා ඔප්නංවයි.",
            futureEnglish = "You will speak with effortless confidence soon.",
            futureSinhala = "ඔබ ඉක්මනින්ම කිසිදු ආයාසයකින් තොරව ආත්ම විශ්වාසයෙන් යුතුව කතා කරනු ඇත.",
            verbTransformation = "improved → sharpens → will speak"
          )
        )
      ),

      // ==========================================
      // Category 14: රැකියා, වෘත්තීන් සහ කාර්යාලය (Jobs, Occupations & Office Work) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 14,
        titleSinhala = "කාණ්ඩය 14: රැකියා, වෘත්තීන් සහ කාර්යාලය",
        titleEnglish = "Jobs, Occupations & Office Work",
        icon = "💼",
        description = "කාර්යාලීය කටයුතු, රැකියා සම්මුඛ පරීක්ෂණ, වැටුප්, ව්‍යාපෘති සහ වෘත්තීය ජීවිතය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t14_s1",
            baseActionSinhala = "කාර්යාලයට පැමිණීම",
            pastEnglish = "The manager arrived at the office at 8:30 AM.",
            pastSinhala = "කළමනාකරු උදෑසන 8:30 ට කාර්යාලයට පැමිණියේය.",
            presentEnglish = "Employees arrive punctually on working days.",
            presentSinhala = "සේවකයෝ වැඩ කරන දිනවල වෙලාවට වැඩට පැමිණෙති.",
            futureEnglish = "The new accountant will arrive at nine o'clock tomorrow.",
            futureSinhala = "නව ගණකාධිකාරීවරයා හෙට උදෑසන නවයට පැමිණෙනු ඇත.",
            verbTransformation = "arrived → arrive → will arrive"
          ),
          TenseSentenceItem(
            id = "t14_s2",
            baseActionSinhala = "රැකියා අයදුම්පතක් යොමු කිරීම",
            pastEnglish = "Sunil applied for the marketing executive vacancy.",
            pastSinhala = "සුනිල් අලෙවි විධායක පුරප්පාඩුව සඳහා අයදුම් කළේය.",
            presentEnglish = "Graduates apply for reputable companies online.",
            presentSinhala = "උපාධිධාරීහු පිළිගත් සමාගම් සඳහා මාර්ගගතව අයදුම් කරති.",
            futureEnglish = "Sunil will apply for government administrative posts.",
            futureSinhala = "සුනිල් රජයේ පරිපාලන තනතුරු සඳහා අයදුම් කරනු ඇත.",
            verbTransformation = "applied → apply → will apply"
          ),
          TenseSentenceItem(
            id = "t14_s3",
            baseActionSinhala = "සම්මුඛ පරීක්ෂණයකට මුහුණ දීම",
            pastEnglish = "She faced the job interview with great confidence.",
            pastSinhala = "ඇය මහත් ආත්ම විශ්වාසයෙන් යුතුව රැකියා සම්මුඛ පරීක්ෂණයට මුහුණ දුන්නාය.",
            presentEnglish = "Well-prepared candidates face interviews successfully.",
            presentSinhala = "හොඳින් සූදානම් වූ අපේක්ෂකයෝ සම්මුඛ පරීක්ෂණ සාර්ථකව ජය ගනිති.",
            futureEnglish = "She will face the final interview panel next Thursday.",
            futureSinhala = "ඇය ලබන බ්‍රහස්පතින්දා අවසාන සම්මුඛ පරීක්ෂණ මණ්ඩලයට මුහුණ දෙනු ඇත.",
            verbTransformation = "faced → face → will face"
          ),
          TenseSentenceItem(
            id = "t14_s4",
            baseActionSinhala = "රැස්වීමක් මෙහෙයවීම",
            pastEnglish = "The director chaired the annual budget meeting.",
            pastSinhala = "අධ්‍යක්ෂවරයා වාර්ෂික අයවැය රැස්වීමේ මුලසුන හෙබවීය.",
            presentEnglish = "Project managers lead daily standup meetings smoothly.",
            presentSinhala = "ව්‍යාපෘති කළමනාකරුවෝ දෛනික කෙටි රැස්වීම් සුමටව මෙහෙයවති.",
            futureEnglish = "The chairperson will address all department heads.",
            futureSinhala = "සභාපතිවරයා සියලුම දෙපාර්තමේන්තු ප්‍රධානීන් අමතනු ඇත.",
            verbTransformation = "chaired → lead → will address"
          ),
          TenseSentenceItem(
            id = "t14_s5",
            baseActionSinhala = "වාර්තාවක් සකස් කිරීම",
            pastEnglish = "The analyst prepared the quarterly financial report.",
            pastSinhala = "විශ්ලේෂකයා ත්‍රෛමාසික මූල්‍ය වාර්තාව සකස් කළේය.",
            presentEnglish = "Accountants prepare audit balance sheets methodically.",
            presentSinhala = "ගණකාධිකාරීවරු විගණන ශේෂ පත්‍ර ක්‍රමානුකූලව සකස් කරති.",
            futureEnglish = "We will submit the comprehensive project report on Friday.",
            futureSinhala = "අපි සිකුරාදා සවිස්තරාත්මක ව්‍යාපෘති වාර්තාව ඉදිරිපත් කරන්නෙමු.",
            verbTransformation = "prepared → prepare → will submit"
          ),
          TenseSentenceItem(
            id = "t14_s6",
            baseActionSinhala = "ගිවිසුමකට අත්සන් තැබීම",
            pastEnglish = "Both companies signed a mutual partnership agreement.",
            pastSinhala = "සමාගම් දෙකම අන්‍යෝන්‍ය හවුල්කාරිත්ව ගිවිසුමකට අත්සන් තැබූහ.",
            presentEnglish = "Legal officers sign business contracts after verification.",
            presentSinhala = "නීති නිලධාරීහු තහවුරු කිරීමෙන් පසු ව්‍යාපාරික ගිවිසුම්වලට අත්සන් තබති.",
            futureEnglish = "The minister will sign the trade agreement tomorrow.",
            futureSinhala = "ඇමතිවරයා හෙට වෙළඳ ගිවිසුමට අත්සන් කරනු ඇත.",
            verbTransformation = "signed → sign → will sign"
          ),
          TenseSentenceItem(
            id = "t14_s7",
            baseActionSinhala = "වැටුප් ගෙවීම",
            pastEnglish = "The employer credited monthly salaries on the 25th.",
            pastSinhala = "සේවායෝජකයා 25 වන දින මාසික වැටුප් බැර කළේය.",
            presentEnglish = "Reliable firms pay employee salaries on time.",
            presentSinhala = "විශ්වාසවන්ත ආයතන සේවක වැටුප් නියමිත වේලාවට ගෙවයි.",
            futureEnglish = "The company will distribute festival bonuses next month.",
            futureSinhala = "සමාගම ලබන මාසයේ උත්සව දීමනා බෙදා හරිනු ඇත.",
            verbTransformation = "credited → pay → will distribute"
          ),
          TenseSentenceItem(
            id = "t14_s8",
            baseActionSinhala = "නිල ඇඳුමක් ඇඳීම",
            pastEnglish = "The bank officer wore a formal navy suit.",
            pastSinhala = "බැංකු නිලධාරියා විධිමත් නිල් පැහැති ඇඳුම් කට්ටලයක් පැළඳ සිටියේය.",
            presentEnglish = "Professionals wear formal attire to maintain dignity.",
            presentSinhala = "වෘත්තිකයෝ ගෞරවය රැකගැනීම සඳහා විධිමත් ඇඳුම් පළඳිති.",
            futureEnglish = "All staff members will wear company badges.",
            futureSinhala = "සියලුම කාර්ය මණ්ඩල සාමාජිකයෝ සමාගමේ ලාංඡන පළඳිනු ඇත.",
            verbTransformation = "wore → wear → will wear"
          ),
          TenseSentenceItem(
            id = "t14_s9",
            baseActionSinhala = "සේවාදායකයෙකුට උපදෙස් දීම",
            pastEnglish = "The lawyer advised the client regarding land deeds.",
            pastSinhala = "නීතිඥවරයා ඉඩම් ඔප්පු සම්බන්ධයෙන් සේවාදායකයාට උපදෙස් දුන්නේය.",
            presentEnglish = "Good consultants provide transparent advice.",
            presentSinhala = "යහපත් උපදේශකයෝ විනිවිදභාවයෙන් යුත් උපදෙස් ලබා දෙති.",
            futureEnglish = "The architect will advise us on foundation design.",
            futureSinhala = "වාස්තු විද්‍යාඥයා අත්තිවාරම් සැලසුම පිළිබඳ අපට උපදෙස් දෙනු ඇත.",
            verbTransformation = "advised → provide → will advise"
          ),
          TenseSentenceItem(
            id = "t14_s10",
            baseActionSinhala = "කාර්යාල ගොනු පිළිවෙළට තැබීම",
            pastEnglish = "The clerk organized client dossiers in alphabetical order.",
            pastSinhala = "ලිපිකරු සේවාදායක ලිපිගොනු අකාරාදී පිළිවෙළට සකස් කළේය.",
            presentEnglish = "Orderly record-keeping prevents loss of valuable records.",
            presentSinhala = "පිළිවෙළකට ලිපිගොනු තැබීම වටිනා වාර්තා නැතිවීම වළක්වයි.",
            futureEnglish = "We will digitize all archive papers into cloud storage.",
            futureSinhala = "අපි සියලුම ලේඛනාගාර ලිපි ක්ලවුඩ් ගබඩාවට ඩිජිටල්කරණය කරන්නෙමු.",
            verbTransformation = "organized → prevents → will digitize"
          ),
          TenseSentenceItem(
            id = "t14_s11",
            baseActionSinhala = "ප්‍රවර්ධනයක් ලැබීම",
            pastEnglish = "Anura received a promotion to senior supervisor.",
            pastSinhala = "අනුර ජ්‍යෙෂ්ඨ අධීක්ෂක ධූරයට උසස්වීමක් ලැබුවේය.",
            presentEnglish = "Hard work and integrity earn promotions.",
            presentSinhala = "කැපවීම සහ අවංකකම උසස්වීම් උපයා දෙයි.",
            futureEnglish = "She will earn a promotion after passing the qualifying exam.",
            futureSinhala = "සුදුසුකම් ලැබීමේ විභාගය සමත් වූ පසු ඇය උසස්වීමක් ලබනු ඇත.",
            verbTransformation = "received → earn → will earn"
          ),
          TenseSentenceItem(
            id = "t14_s12",
            baseActionSinhala = "කාර්යාලීය තේ විවේකය",
            pastEnglish = "Colleagues took a fifteen-minute tea break.",
            pastSinhala = "සගයෝ මිනිත්තු පහළොවක තේ විවේකයක් ගත්හ.",
            presentEnglish = "A short tea break rejuvenates tired office staff.",
            presentSinhala = "කෙටි තේ විවේකයක් වෙහෙසට පත් කාර්යාල කාර්ය මණ්ඩලය ප්‍රබෝධමත් කරයි.",
            futureEnglish = "We will take tea together after the client leaves.",
            futureSinhala = "සේවාදායකයා පිටව ගිය පසු අපි එකට තේ බොන්නෙමු.",
            verbTransformation = "took → rejuvenates → will take"
          ),
          TenseSentenceItem(
            id = "t14_s13",
            baseActionSinhala = "අතිකාල වැඩ කිරීම",
            pastEnglish = "The team worked overtime to meet the deadline.",
            pastSinhala = "නියමිත දිනයට වැඩ නිම කිරීමට කණ්ඩායම අතිකාල සේවයේ යෙදුණි.",
            presentEnglish = "Dedicated employees occasionally work overtime.",
            presentSinhala = "කැපවූ සේවකයෝ ඉඳහිට අතිකාල සේවයේ යෙදෙති.",
            futureEnglish = "We will work overtime on Saturday to complete the target.",
            futureSinhala = "ඉලක්කය සම්පූර්ණ කිරීම සඳහා අපි සෙනසුරාදා අතිකාල සේවයේ යෙදෙන්නෙමු.",
            verbTransformation = "worked overtime → work overtime → will work overtime"
          ),
          TenseSentenceItem(
            id = "t14_s14",
            baseActionSinhala = "අත්පත්‍රිකාවක් බෙදාහැරීම",
            pastEnglish = "Marketing interns distributed flyers at the exhibition.",
            pastSinhala = "අලෙවිකරණ පුහුණුවන්නෝ ප්‍රදර්ශනයේදී අත්පත්‍රිකා බෙදා හැරියහ.",
            presentEnglish = "Public relations teams circulate news leaflets actively.",
            presentSinhala = "මහජන සම්බන්ධතා කණ්ඩායම් ප්‍රවෘත්ති පත්‍රිකා ක්‍රියාශීලීව බෙදා හරිති.",
            futureEnglish = "We will distribute product brochures to all participants.",
            futureSinhala = "අපි සියලුම සහභාගිවන්නන්ට නිෂ්පාදන අත්පොත් බෙදා දෙන්නෙමු.",
            verbTransformation = "distributed → circulate → will distribute"
          ),
          TenseSentenceItem(
            id = "t14_s15",
            baseActionSinhala = "නිවාඩු අනුමත කර ගැනීම",
            pastEnglish = "The supervisor approved five days of medical leave.",
            pastSinhala = "අධීක්ෂකවරයා දින පහක වෛද්‍ය නිවාඩු අනුමත කළේය.",
            presentEnglish = "HR departments process leave requests fairly.",
            presentSinhala = "මානව සම්පත් දෙපාර්තමේන්තු නිවාඩු ඉල්ලීම් සාධාරණව ක්‍රියාත්මක කරයි.",
            futureEnglish = "The manager will approve your annual leave tomorrow.",
            futureSinhala = "කළමනාකරු හෙට ඔබේ වාර්ෂික නිවාඩුව අනුමත කරනු ඇත.",
            verbTransformation = "approved → process → will approve"
          ),
          TenseSentenceItem(
            id = "t14_s16",
            baseActionSinhala = "පුහුණු සැසියකට සහභාගී වීම",
            pastEnglish = "Staff attended a cyber-security training workshop.",
            pastSinhala = "කාර්ය මණ්ඩලය සයිබර් ආරක්ෂණ පුහුණු වැඩමුළුවකට සහභාගී වූහ.",
            presentEnglish = "Continuous training equips employees with cutting-edge skills.",
            presentSinhala = "අඛණ්ඩ පුහුණුව සේවකයන් නවීන කුසලතාවලින් සන්නද්ධ කරයි.",
            futureEnglish = "We will attend a leadership seminar next month.",
            futureSinhala = "අපි ලබන මාසයේ නායකත්ව සම්මන්ත්‍රණයකට සහභාගී වන්නෙමු.",
            verbTransformation = "attended → equips → will attend"
          ),
          TenseSentenceItem(
            id = "t14_s17",
            baseActionSinhala = "ඉලක්කයක් සපුරා ගැනීම",
            pastEnglish = "The sales department achieved the annual revenue target.",
            pastSinhala = "විකුණුම් දෙපාර්තමේන්තුව වාර්ෂික ආදායම් ඉලක්කය සපුරා ගත්තේය.",
            presentEnglish = "Motivated teams achieve outstanding commercial milestones.",
            presentSinhala = "දිරිමත් කණ්ඩායම් විශිෂ්ට වාණිජ සන්ධිස්ථාන අත්කර ගනී.",
            futureEnglish = "We will achieve our regional growth targets this quarter.",
            futureSinhala = "අපි මෙම කාර්තුවේදී අපගේ කලාපීය වර්ධන ඉලක්ක සපුරා ගන්නෙමු.",
            verbTransformation = "achieved → achieve → will achieve"
          ),
          TenseSentenceItem(
            id = "t14_s18",
            baseActionSinhala = "වෘත්තීය උපදෙස් ලබා ගැනීම",
            pastEnglish = "He consulted a career advisor before changing fields.",
            pastSinhala = "ක්ෂේත්‍රය මාරු කිරීමට පෙර ඔහු වෘත්තීය උපදේශකයෙකු හමුවිය.",
            presentEnglish = "Sensible workers seek guidance from industry mentors.",
            presentSinhala = "බුද්ධිමත් සේවකයෝ ක්ෂේත්‍රයේ ප්‍රවීණයන්ගෙන් මඟපෙන්වීම් ලබා ගනිති.",
            futureEnglish = "I will consult my senior professor about foreign scholarships.",
            futureSinhala = "විදේශ ශිෂ්‍යත්ව පිළිබඳව මම මගේ ජ්‍යෙෂ්ඨ මහාචාර්යවරයාගෙන් උපදෙස් ලබා ගන්නෙමි.",
            verbTransformation = "consulted → seek → will consult"
          ),
          TenseSentenceItem(
            id = "t14_s19",
            baseActionSinhala = "විශ්‍රාම යාම",
            pastEnglish = "Mr. Perera retired after thirty-five years of faithful service.",
            pastSinhala = "පෙරේරා මහතා තිස්පස් වසරක විශ්වාසවන්ත සේවයෙන් පසු විශ්‍රාම ගියේය.",
            presentEnglish = "Senior officers retire with pension and honors.",
            presentSinhala = "ජ්‍යෙෂ්ඨ නිලධාරීහු විශ්‍රාම වැටුප් සහ ගෞරව සහිතව විශ්‍රාම යති.",
            futureEnglish = "Our principal will retire at the end of this academic year.",
            futureSinhala = "අපේ විදුහල්පතිතුමා මේ අධ්‍යයන වර්ෂය අවසානයේ විශ්‍රාම යනු ඇත.",
            verbTransformation = "retired → retire → will retire"
          ),
          TenseSentenceItem(
            id = "t14_s20",
            baseActionSinhala = "නවතම ව්‍යාපෘතියක් ආරම්භ කිරීම",
            pastEnglish = "The company launched an eco-friendly packaging line.",
            pastSinhala = "සමාගම පරිසර හිතකාමී ඇසුරුම් පෙළක් ආරම්භ කළේය.",
            presentEnglish = "Innovative enterprises launch green initiatives regularly.",
            presentSinhala = "නවෝත්පාදන ව්‍යාපාර නිතරම පරිසර හිතකාමී වැඩසටහන් දියත් කරති.",
            futureEnglish = "We will launch our community healthcare initiative in April.",
            futureSinhala = "අපි අපේ ප්‍රජා සෞඛ්‍ය වැඩසටහන අප්‍රේල් මාසයේදී දියත් කරන්නෙමු.",
            verbTransformation = "launched → launch → will launch"
          ),
          TenseSentenceItem(
            id = "t14_s21",
            baseActionSinhala = "ගැටලුවක් නිරාකරණය කිරීම",
            pastEnglish = "The manager resolved the customer complaint amicably.",
            pastSinhala = "කළමනාකරු පාරිභෝගික පැමිණිල්ල සුහදව විසඳුවේය.",
            presentEnglish = "Diplomatic administrators resolve workplace disputes calmly.",
            presentSinhala = "සාමකාමී පරිපාලකයෝ සේවා ස්ථානයේ ආරවුල් සන්සුන්ව විසඳති.",
            futureEnglish = "We will resolve supply chain delays by next week.",
            futureSinhala = "අපි ලබන සතිය වන විට සැපයුම් දාම ප්‍රමාදයන් විසඳන්නෙමු.",
            verbTransformation = "resolved → resolve → will resolve"
          ),
          TenseSentenceItem(
            id = "t14_s22",
            baseActionSinhala = "ඉලෙක්ට්‍රොනික පැමිණීම සටහන් කිරීම",
            pastEnglish = "Employees clocked in using biometric fingerprint sensors.",
            pastSinhala = "සේවකයෝ ඇඟිලි සලකුණු සංවේදක භාවිතයෙන් පැමිණීම සටහන් කළහ.",
            presentEnglish = "Modern attendance devices track work hours precisely.",
            presentSinhala = "නවීන පැමිණීමේ උපාංග වැඩ කරන වේලාවන් නිවැරදිව සටහන් කරයි.",
            futureEnglish = "All staff will swipe digital smartcards from Monday.",
            futureSinhala = "සඳුදා සිට සියලුම කාර්ය මණ්ඩලය ඩිජිටල් ස්මාර්ට් කාඩ්පත් භාවිත කරනු ඇත.",
            verbTransformation = "clocked in → track → will swipe"
          ),
          TenseSentenceItem(
            id = "t14_s23",
            baseActionSinhala = "කාර්යාලය පිරිසිදුව තබා ගැනීම",
            pastEnglish = "The janitor sanitized desks and door handles thoroughly.",
            pastSinhala = "පිරිසිදු කරන්නා මේස සහ දොර අගුල් හොඳින් විෂබීජහරණය කළේය.",
            presentEnglish = "A clean working environment improves productivity.",
            presentSinhala = "පිරිසිදු සේවා පරිසරයක් කාර්යක්ෂමතාව වැඩි කරයි.",
            futureEnglish = "The cleaners will vacuum carpets over the weekend.",
            futureSinhala = "පිරිසිදු කරන්නන් සති අන්තයේ කාපට් වැකුම් කර පිරිසිදු කරනු ඇත.",
            verbTransformation = "sanitized → improves → will vacuum"
          ),
          TenseSentenceItem(
            id = "t14_s24",
            baseActionSinhala = "සමූපකාර සේවාව",
            pastEnglish = "Workers united to establish an employee welfare fund.",
            pastSinhala = "සේවකයෝ සේවක සුබසාධන අරමුදලක් පිහිටුවීමට එක්සත් වූහ.",
            presentEnglish = "Solidarity fosters harmonic industrial relations.",
            presentSinhala = "සමගිය සුහද කාර්මික සබඳතා ඇති කරයි.",
            futureEnglish = "The union will negotiate fair overtime benefits.",
            futureSinhala = "සංගමය සාධාරණ අතිකාල ප්‍රතිලාභ පිළිබඳව සාකච්ඡා කරනු ඇත.",
            verbTransformation = "united → fosters → will negotiate"
          ),
          TenseSentenceItem(
            id = "t14_s25",
            baseActionSinhala = "ව්‍යාපාරික කාඩ්පතක් දීම",
            pastEnglish = "The entrepreneur handed his business card to the investor.",
            pastSinhala = "ව්‍යවසායකයා ආයෝජකයාට තම ව්‍යාපාරික කාඩ්පත දුන්නේය.",
            presentEnglish = "Professionals exchange visiting cards during networking events.",
            presentSinhala = "වෘත්තිකයෝ ජාලකරණ උත්සවවලදී ව්‍යාපාරික කාඩ්පත් හුවමාරු කර ගනිති.",
            futureEnglish = "I will share my contact QR code with new partners.",
            futureSinhala = "මම නව හවුල්කරුවන් සමඟ මගේ සබඳතා QR කේතය බෙදා ගන්නෙමු.",
            verbTransformation = "handed → exchange → will share"
          ),
          TenseSentenceItem(
            id = "t14_s26",
            baseActionSinhala = "විගණනයක් පැවැත්වීම",
            pastEnglish = "External auditors inspected financial statements rigorously.",
            pastSinhala = "බාහිර විගණකවරු මූල්‍ය ප්‍රකාශන දැඩි ලෙස පරීක්ෂා කළහ.",
            presentEnglish = "Annual audits ensure transparency and regulatory compliance.",
            presentSinhala = "වාර්ෂික විගණන විනිවිදභාවය සහ නීතිමය අනුකූලතාව තහවුරු කරයි.",
            futureEnglish = "Inspectors will verify tax documentation next week.",
            futureSinhala = "පරීක්ෂකවරු ලබන සතියේ බදු ලේඛන තහවුරු කරනු ඇත.",
            verbTransformation = "inspected → ensure → will verify"
          ),
          TenseSentenceItem(
            id = "t14_s27",
            baseActionSinhala = "වැඩබිම ආරක්ෂාව තහවුරු කිරීම",
            pastEnglish = "Construction workers wore yellow hard hats on site.",
            pastSinhala = "ඉදිකිරීම් සේවකයෝ වැඩබිමේදී කහ පැහැති ආරක්ෂක හිස්වැසුම් පැළඳ සිටියහ.",
            presentEnglish = "Safety helmets and boots prevent fatal workplace accidents.",
            presentSinhala = "ආරක්ෂක හිස්වැසුම් සහ සපත්තු මාරාන්තික අනතුරු වළක්වයි.",
            futureEnglish = "The safety officer will conduct a mandatory drill tomorrow.",
            futureSinhala = "ආරක්ෂක නිලධාරියා හෙට අනිවාර්ය පෙරහුරුවක් පවත්වනු ඇත.",
            verbTransformation = "wore → prevent → will conduct"
          ),
          TenseSentenceItem(
            id = "t14_s28",
            baseActionSinhala = "සේවක ඇගයීම",
            pastEnglish = "The management awarded the employee of the month trophy.",
            pastSinhala = "කළමනාකාරීත්වය මාසයේ විශිෂ්ටතම සේවක කුසලානය පිරිනැමීය.",
            presentEnglish = "Appreciating dedication inspires teams to perform better.",
            presentSinhala = "කැපවීම අගය කිරීම කණ්ඩායම් වඩා හොඳින් ක්‍රියා කිරීමට පොළඹවයි.",
            futureEnglish = "The company will honor veteran staff at the annual dinner.",
            futureSinhala = "සමාගම වාර්ෂික රාත්‍රී භෝජන සංග්‍රහයේදී ප්‍රවීණ සේවකයන්ට උපහාර දක්වනු ඇත.",
            verbTransformation = "awarded → inspires → will honor"
          ),
          TenseSentenceItem(
            id = "t14_s29",
            baseActionSinhala = "කාර්යාලය වැසීම",
            pastEnglish = "The caretaker locked the front glass doors at 6:30 PM.",
            pastSinhala = "භාරකරු සවස 6:30 ට ඉදිරිපස වීදුරු දොරවල් අගුළු දැමුවේය.",
            presentEnglish = "Security guards patrol commercial premises throughout the night.",
            presentSinhala = "ආරක්ෂක නිලධාරීහු මුළු රාත්‍රිය පුරාම වාණිජ පරිශ්‍රයේ මුර සංචාරය කරති.",
            futureEnglish = "We will lock all confidential cabinets before leaving.",
            futureSinhala = "පිටත්ව යාමට පෙර අපි සියලුම රහස්‍ය අල්මාරි අගුළු දමන්නෙමු.",
            verbTransformation = "locked → patrol → will lock"
          ),
          TenseSentenceItem(
            id = "t14_s30",
            baseActionSinhala = "වෘත්තීය සාර්ථකත්වය අත්පත් කර ගැනීම",
            pastEnglish = "Priyani built a thriving accounting consultancy firm.",
            pastSinhala = "ප්‍රියානි සාර්ථක ගණකාධිකාරී උපදේශන ආයතනයක් ගොඩනැඟුවාය.",
            presentEnglish = "Patience and professional ethics yield long-term success.",
            presentSinhala = "ඉවසීම සහ වෘත්තීය ආචාරධර්ම දිගුකාලීන සාර්ථකත්වය ගෙන දෙයි.",
            futureEnglish = "You will become a respected professional in your chosen career.",
            futureSinhala = "ඔබ තෝරාගත් වෘත්තියෙන් ඔබ ගෞරවනීය වෘත්තිකයෙකු වනු ඇත.",
            verbTransformation = "built → yield → will become"
          )
        )
      ),

      // ==========================================
      // Category 15: සංගීතය, කලාව සහ සංස්කෘතික උත්සව (Music, Arts & Cultural Festivals) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 15,
        titleSinhala = "කාණ්ඩය 15: සංගීතය, කලාව සහ සංස්කෘතික උත්සව",
        titleEnglish = "Music, Arts & Cultural Festivals",
        icon = "🎨",
        description = "සංගීත භාණ්ඩ වාදනය, චිත්‍ර ඇඳීම, නැටුම්, නාට්‍ය සහ සංස්කෘතික පෙරහැරවල් පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t15_s1",
            baseActionSinhala = "වයලීනය වාදනය කිරීම",
            pastEnglish = "She played a classical tune on her violin beautifully.",
            pastSinhala = "ඇය තම වයලීනයෙන් සම්භාව්‍ය තනුවක් ඉතා අලංකාරව වාදනය කළාය.",
            presentEnglish = "She plays the violin for two hours every evening.",
            presentSinhala = "ඇය සෑම සවසකම පැය දෙකක් වයලීනය වාදනය කරයි.",
            futureEnglish = "She will play the violin at the school concert.",
            futureSinhala = "ඇය පාසල් ප්‍රසංගයේදී වයලීනය වාදනය කරනු ඇත.",
            verbTransformation = "played → plays → will play"
          ),
          TenseSentenceItem(
            id = "t15_s2",
            baseActionSinhala = "ලස්සන චිත්‍රයක් ඇඳීම",
            pastEnglish = "Sunil painted a colorful portrait of a dancing peacock.",
            pastSinhala = "සුනිල් නටන මොනරෙකුගේ වර්ණවත් චිත්‍රයක් ඇන්දේය.",
            presentEnglish = "Talented artists paint vivid expressions of nature.",
            presentSinhala = "දක්ෂ චිත්‍ර ශිල්පීහු සොබාදහමේ විචිත්‍රවත් දසුන් චිත්‍රයට නඟති.",
            futureEnglish = "Sunil will paint a landscape for the national art exhibition.",
            futureSinhala = "සුනිල් ජාතික චිත්‍ර ප්‍රදර්ශනය සඳහා ස්වභාව සෞන්දර්ය චිත්‍රයක් අඳිනු ඇත.",
            verbTransformation = "painted → paint → will paint"
          ),
          TenseSentenceItem(
            id = "t15_s3",
            baseActionSinhala = "ගැටබෙරය වාදනය කිරීම",
            pastEnglish = "The traditional drummer beat the Geta Bera with rhythmic mastery.",
            pastSinhala = "සාම්ප්‍රදායික බෙර වාදකයා රිද්මයානුකූල දක්ෂතාවයෙන් ගැටබෙරය වාදනය කළේය.",
            presentEnglish = "Sri Lankan drummers preserve ancient percussive rhythms.",
            presentSinhala = "ශ්‍රී ලාංකික බෙර වාදකයෝ පැරණි බෙර රිද්මයන් සුරක්ෂිතව පවත්වාගෙන යති.",
            futureEnglish = "The drummers will lead the temple procession tomorrow.",
            futureSinhala = "බෙර වාදකයෝ හෙට විහාරස්ථාන පෙරහැර මෙහෙයවනු ඇත.",
            verbTransformation = "beat → preserve → will lead"
          ),
          TenseSentenceItem(
            id = "t15_s4",
            baseActionSinhala = "උඩරට නැටුම් නැටීම",
            pastEnglish = "The troupe performed the Ves dance with elegance.",
            pastSinhala = "නර්තන කණ්ඩායම අභිමානයෙන් යුතුව වෙස් නැටුම ඉදිරිපත් කළහ.",
            presentEnglish = "Kandyan dancers perform graceful movements with precision.",
            presentSinhala = "උඩරට නර්තන ශිල්පීහු ඉතා විචිත්‍රවත් අංගචලන නිරවද්‍යව ඉදිරිපත් කරති.",
            futureEnglish = "They will dance at the Independence Day pageant.",
            futureSinhala = "ඔවුහු නිදහස් දින උළෙලේදී නර්තනයේ යෙදෙනු ඇත.",
            verbTransformation = "performed → perform → will dance"
          ),
          TenseSentenceItem(
            id = "t15_s5",
            baseActionSinhala = "පැරණි ගීතයක් ගැයීම",
            pastEnglish = "The choir sang a classic song composed by Sunil Santha.",
            pastSinhala = "ගායනා කණ්ඩායම සුනිල් ශාන්තයන් නිර්මාණය කළ සම්භාව්‍ය ගීතයක් ගැයූහ.",
            presentEnglish = "Classical songs evoke serene nostalgic feelings.",
            presentSinhala = "සම්භාව්‍ය ගීත සන්සුන් මනරම් හැඟීම් අවදි කරයි.",
            futureEnglish = "We will sing historic ballads at the folklore festival.",
            futureSinhala = "අපි ජනප්‍රවාද උළෙලේදී ඓතිහාසික ගීතිකා ගයන්නෙමු.",
            verbTransformation = "sang → evoke → will sing"
          ),
          TenseSentenceItem(
            id = "t15_s6",
            baseActionSinhala = "පෙරහැර නැරඹීම",
            pastEnglish = "Tourists watched the Kandy Esala Perahera in wonder.",
            pastSinhala = "සංචාරකයෝ මහත් විස්මයෙන් යුතුව මහනුවර ඇසළ පෙරහැර නැරඹූහ.",
            presentEnglish = "Thousands of devotees watch the illuminated pageant every year.",
            presentSinhala = "සෑම වසරකම දහස් ගණන් බැතිමත්හු ආලෝකමත් පෙරහැර නරඹති.",
            futureEnglish = "We will watch the sacred tusker carry the casket tonight.",
            futureSinhala = "සධාතුක කරඬුව වඩමවන මංගල හස්තිරාජයා අපි අද රෑ නරඹන්නෙමු.",
            verbTransformation = "watched → watch → will watch"
          ),
          TenseSentenceItem(
            id = "t15_s7",
            baseActionSinhala = "මැටි බඳුන් හැඩගැන්වීම",
            pastEnglish = "The artisan molded a clay pot on the potter's wheel.",
            pastSinhala = "ශිල්පියා සකපෝරුව මත මැටි බඳුනක් හැඩගැන්වීය.",
            presentEnglish = "Traditional potters shape elegant earthenware by hand.",
            presentSinhala = "සාම්ප්‍රදායික කුඹල්කරුවෝ අතින් අලංකාර මැටි භාණ්ඩ නිර්මාණය කරති.",
            futureEnglish = "He will bake the clay vessels in the wood kiln.",
            futureSinhala = "ඔහු දර පෝරණුවේ මැටි භාණ්ඩ පුළුස්සනු ඇත.",
            verbTransformation = "molded → shape → will bake"
          ),
          TenseSentenceItem(
            id = "t15_s8",
            baseActionSinhala = "වේදිකා නාට්‍යයක් රඟදැක්වීම",
            pastEnglish = "The drama society staged a historical play last Friday.",
            pastSinhala = "නාට්‍ය සංගමය පසුගිය සිකුරාදා ඓතිහාසික නාට්‍යයක් වේදිකාගත කළේය.",
            presentEnglish = "Theatrical performances convey deep philosophical themes.",
            presentSinhala = "නාට්‍ය සංදර්ශන ගැඹුරු දාර්ශනික තේමාවන් ඉදිරිපත් කරයි.",
            futureEnglish = "The youth troupe will stage a comedic drama next month.",
            futureSinhala = "තරුණ නාට්‍ය කණ්ඩායම ලබන මාසයේ හාස්‍ය නාට්‍යයක් වේදිකාගත කරනු ඇත.",
            verbTransformation = "staged → convey → will stage"
          ),
          TenseSentenceItem(
            id = "t15_s9",
            baseActionSinhala = "වෙසක් පහන් කූඩුවක් සෑදීම",
            pastEnglish = "We made an octagonal Vesak lantern with bamboo sticks.",
            pastSinhala = "අපි උණ ලී පතුරු වලින් අටපට්ටම් වෙසක් පහන් කූඩුවක් සෑදුවෙමු.",
            presentEnglish = "Families craft colorful lanterns during Vesak festival season.",
            presentSinhala = "වෙසක් උත්සව සමයේදී පවුල් වර්ණවත් පහන් කූඩු නිර්මාණය කරති.",
            futureEnglish = "We will light oil lamps along the garden wall.",
            futureSinhala = "අපි වත්ත වටා තාප්පය දිගේ මැටි පහන් දල්වන්නෙමු.",
            verbTransformation = "made → craft → will light"
          ),
          TenseSentenceItem(
            id = "t15_s10",
            baseActionSinhala = "පැරණි කැටයම් කැපීම",
            pastEnglish = "The woodcarver sculpted a delicate lotus on teak wood.",
            pastSinhala = "ලී කැටයම් ශිල්පියා තේක්ක ලීයේ සියුම් නෙළුම් මලක් කැටයම් කළේය.",
            presentEnglish = "Skilled artisans carve floral patterns into sandalwood.",
            presentSinhala = "දක්ෂ ශිල්පීහු සඳුන් ලීයේ මල් රටා කැටයම් කරති.",
            futureEnglish = "He will restore the antique carved temple doorway.",
            futureSinhala = "ඔහු පුරාණ කැටයම් සහිත විහාර දොරටුව ප්‍රතිසංස්කරණය කරනු ඇත.",
            verbTransformation = "sculpted → carve → will restore"
          ),
          TenseSentenceItem(
            id = "t15_s11",
            baseActionSinhala = "කවි පන්තියක් රචනා කිරීම",
            pastEnglish = "The poet wrote a touching poem about village beauty.",
            pastSinhala = "කවියා ගැමි සෞන්දර්යය පිළිබඳ සංවේදී කවි පන්තියක් ලිව්වේය.",
            presentEnglish = "Poets express profound human sentiments through verse.",
            presentSinhala = "කවීහු කාව්‍ය පද මඟින් ගැඹුරු මානව හැඟීම් ප්‍රකාශ කරති.",
            futureEnglish = "She will recite her new poem at the literature circle.",
            futureSinhala = "ඇය සාහිත්‍ය මණ්ඩලයේදී තම නව කවිය ගායනා කරනු ඇත.",
            verbTransformation = "wrote → express → will recite"
          ),
          TenseSentenceItem(
            id = "t15_s12",
            baseActionSinhala = "බතික් රෙදි මෝස්තර නිර්මාණය",
            pastEnglish = "The designer dyed intricate batik patterns on silk.",
            pastSinhala = "මෝස්තර නිර්මාණකරුවා සේද රෙදි මත සියුම් බතික් රටා සායම් කළේය.",
            presentEnglish = "Batik craftsmanship produces vibrant cultural garments.",
            presentSinhala = "බතික් ශිල්පය විචිත්‍රවත් සංස්කෘතික ඇඳුම් නිර්මාණය කරයි.",
            futureEnglish = "They will exhibit handloom batik tapestries at the fair.",
            futureSinhala = "ඔවුහු වෙළඳ ප්‍රදර්ශනයේදී අත්යන්ත්‍ර බතික් රෙදිපිළි ප්‍රදර්ශනය කරනු ඇත.",
            verbTransformation = "dyed → produces → will exhibit"
          ),
          TenseSentenceItem(
            id = "t15_s13",
            baseActionSinhala = "ගිටාරය වාදනය කිරීම",
            pastEnglish = "The youth played cheerful acoustic chords around the campfire.",
            pastSinhala = "තරුණයා කඳවුරු ගින්න වටා ප්‍රීතිමත් ගිටාර් තත් නාද කළේය.",
            presentEnglish = "Musicians strum melodic guitar rhythms for calm relaxation.",
            presentSinhala = "සංගීතඥයෝ සන්සුන් විවේකය සඳහා මියුරු ගිටාර් තත් නාද කරති.",
            futureEnglish = "He will perform a guitar solo at the acoustic night.",
            futureSinhala = "ඔහු ගීතමය රාත්‍රියේදී තනි ගිටාර් වාදනයක් ඉදිරිපත් කරනු ඇත.",
            verbTransformation = "played → strum → will perform"
          ),
          TenseSentenceItem(
            id = "t15_s14",
            baseActionSinhala = "කෞතුකාගාරයක් නැරඹීම",
            pastEnglish = "Students visited the Colombo National Museum on Wednesday.",
            pastSinhala = "සිසුහු බදාදා කොළඹ ජාතික කෞතුකාගාරය නැරඹූහ.",
            presentEnglish = "Museums safeguard royal regalia and antique weapons.",
            presentSinhala = "කෞතුකාගාර රාජකීය ආභරණ සහ පැරණි ආයුධ ආරක්ෂා කරයි.",
            futureEnglish = "We will explore the maritime museum in Galle next week.",
            futureSinhala = "අපි ලබන සතියේ ගාල්ලේ සමුද්‍ර කෞතුකාගාරය නරඹන්නෙමු.",
            verbTransformation = "visited → safeguard → will explore"
          ),
          TenseSentenceItem(
            id = "t15_s15",
            baseActionSinhala = "රූකඩ නැටුමක් නැරඹීම",
            pastEnglish = "Children enjoyed the traditional string puppet show.",
            pastSinhala = "ළමයි සාම්ප්‍රදායික නූල් රූකඩ සංදර්ශනය නැරඹූහ.",
            presentEnglish = "Ambalangoda puppeteers reenact historic folktales vividly.",
            presentSinhala = "අම්බලන්ගොඩ රූකඩ ශිල්පීහු ඓතිහාසික ජනකතා විචිත්‍රව ප්‍රතිනිර්මාණය කරති.",
            futureEnglish = "The troupe will present a puppet festival in the town hall.",
            futureSinhala = "කණ්ඩායම නගර ශාලාවේ රූකඩ උළෙලක් ඉදිරිපත් කරනු ඇත.",
            verbTransformation = "enjoyed → reenact → will present"
          ),
          TenseSentenceItem(
            id = "t15_s16",
            baseActionSinhala = "පොල්තෙල් පහන දැල්වීම",
            pastEnglish = "The chief guest lit the traditional brass oil lamp.",
            pastSinhala = "ප්‍රධාන ආරාධිත අමුත්තා සාම්ප්‍රදායික පිත්තල පහන දැල්වීය.",
            presentEnglish = "Lighting the oil lamp signifies wisdom and auspicious beginnings.",
            presentSinhala = "පොල්තෙල් පහන දැල්වීම ප්‍රඥාව සහ සුබ ආරම්භය සංකේතවත් කරයි.",
            futureEnglish = "Dignitaries will light the ceremonial lamp at the inauguration.",
            futureSinhala = "විශේෂ අමුත්තෝ සමාරම්භක අවස්ථාවේදී උත්සව පහන දල්වනු ඇත.",
            verbTransformation = "lit → signifies → will light"
          ),
          TenseSentenceItem(
            id = "t15_s17",
            baseActionSinhala = "පැරණි ගොඩනැගිලි ප්‍රතිසංස්කරණය",
            pastEnglish = "Archaeologists restored ancient rock frescoes carefully.",
            pastSinhala = "පුරාවිද්‍යාඥයෝ පැරණි බිතුසිතුවම් ඉතා සැලකිල්ලෙන් ප්‍රතිසංස්කරණය කළහ.",
            presentEnglish = "Conservation experts protect crumbling stone inscriptions.",
            presentSinhala = "සංරක්ෂණ විශේෂඥයෝ විනාශ වී යන සෙල්ලිපි ආරක්ෂා කරති.",
            futureEnglish = "The heritage board will preserve historic Dutch canal walls.",
            futureSinhala = "උරුමයන් පිළිබඳ මණ්ඩලය ඓතිහාසික ලන්දේසි ඇළ බැමි සංරක්ෂණය කරනු ඇත.",
            verbTransformation = "restored → protect → will preserve"
          ),
          TenseSentenceItem(
            id = "t15_s18",
            baseActionSinhala = "කලා ප්‍රදර්ශනයක් පැවැත්වීම",
            pastEnglish = "The art gallery exhibited fifty oil paintings.",
            pastSinhala = "කලාගාරය තෙල් සායම් චිත්‍ර පනහක් ප්‍රදර්ශනය කළේය.",
            presentEnglish = "Galleries showcase emerging artistic talent to the public.",
            presentSinhala = "කලාගාර නැගී එන කලා කුසලතා මහජනතාව වෙත ප්‍රදර්ශනය කරයි.",
            futureEnglish = "We will display watercolor landscapes this weekend.",
            futureSinhala = "අපි මේ සති අන්තයේ දිය සායම් චිත්‍ර ප්‍රදර්ශනය කරන්නෙමු.",
            verbTransformation = "exhibited → showcase → will display"
          ),
          TenseSentenceItem(
            id = "t15_s19",
            baseActionSinhala = "නළාව පිඹීම",
            pastEnglish = "The flutist blew a sweet bamboo melody in the evening.",
            pastSinhala = "වේණුවාදකයා සවස් කාලයේ මිහිරි උණ බම්බු නලා නාදයක් පිම්බේය.",
            presentEnglish = "Wind instruments create soothing meditative sounds.",
            presentSinhala = "සුළං වාද්‍ය භාණ්ඩ සන්සුන් භාවනාමය නාද රටා නිර්මාණය කරයි.",
            futureEnglish = "He will blow the conch shell at the start of pooja.",
            futureSinhala = "පූජාව ආරම්භයේදී ඔහු සක් හඬ නංවනු ඇත.",
            verbTransformation = "blew → create → will blow"
          ),
          TenseSentenceItem(
            id = "t15_s20",
            baseActionSinhala = "අවුරුදු ක්‍රීඩාවල යෙදීම",
            pastEnglish = "Villagers climbed the slippery greased pole at the festival.",
            pastSinhala = "ගම්වැසියෝ උත්සවයේදී ලිස්සන ගස නැග්ගාහ.",
            presentEnglish = "Traditional games unite communities during Sinhala New Year.",
            presentSinhala = "සිංහල අලුත් අවුරුදු සමයේදී සාම්ප්‍රදායික ක්‍රීඩා ගම්වැසියන් එක්සත් කරයි.",
            futureEnglish = "We will participate in pillow fights and tug-of-war tomorrow.",
            futureSinhala = "අපි හෙට කොට්ට පොර සහ කඹ ඇදීමේ තරඟවලට සහභාගී වන්නෙමු.",
            verbTransformation = "climbed → unite → will participate"
          ),
          TenseSentenceItem(
            id = "t15_s21",
            baseActionSinhala = "කිරි ඉතිරවීම",
            pastEnglish = "Mother boiled milk in a new clay pot for New Year.",
            pastSinhala = "අලුත් අවුරුද්ද වෙනුවෙන් අම්මා අලුත් මැටි මුට්ටියක කිරි ඉතිරවූවාය.",
            presentEnglish = "Spilling boiled milk symbolizes prosperity and boundless joy.",
            presentSinhala = "කිරි ඉතිරවීම සෞභාග්‍යය සහ අපරිමිත ප්‍රීතිය සංකේතවත් කරයි.",
            futureEnglish = "We will boil fresh cow's milk at the auspicious time.",
            futureSinhala = "අපි සුබ මොහොතින් නැවුම් එළකිරි උතුරවන්නෙමු.",
            verbTransformation = "boiled → symbolizes → will boil"
          ),
          TenseSentenceItem(
            id = "t15_s22",
            baseActionSinhala = "නාද රටා පටිගත කිරීම",
            pastEnglish = "The sound technician recorded orchestral instruments in the studio.",
            pastSinhala = "ශබ්ද කාර්මිකයා ශබ්දාගාරයේ වාද්‍ය වෘන්ද භාණ්ඩ පටිගත කළේය.",
            presentEnglish = "Studio microphones capture acoustic vibrations faithfully.",
            presentSinhala = "ස්ටුඩියෝ මයික්‍රෆෝන සංගීත කම්පන නිවැරදිව ග්‍රහණය කර ගනී.",
            futureEnglish = "We will record the school anthem with brass accompaniment.",
            futureSinhala = "අපි තූර්ය වාදක කණ්ඩායමේ සහාය ඇතිව පාසල් ගීය පටිගත කරන්නෙමු.",
            verbTransformation = "recorded → capture → will record"
          ),
          TenseSentenceItem(
            id = "t15_s23",
            baseActionSinhala = "ජනකතා කියා දීම",
            pastEnglish = "Grandmother narrated the legendary Mahadenamutta tale.",
            pastSinhala = "මිත්තණිය මහදැනමුත්තාගේ ප්‍රකට ජනකතාව කියා දුන්නාය.",
            presentEnglish = "Elders narrate moral fables to inculcate wisdom in youth.",
            presentSinhala = "වැඩිහිටියෝ තරුණ පරපුරට ගුණධර්ම කියාදීමට ආදර්ශමත් ජනකතා කියති.",
            futureEnglish = "She will narrate the Andare humor story tonight.",
            futureSinhala = "ඇය අද රෑ අන්දරේගේ හාස්‍යජනක කතාව කියා දෙනු ඇත.",
            verbTransformation = "narrated → narrate → will narrate"
          ),
          TenseSentenceItem(
            id = "t15_s24",
            baseActionSinhala = "මුහුණු ආවරණ කැටයම් කිරීම",
            pastEnglish = "The woodcraft master carved a fearsome Gurulu mask.",
            pastSinhala = "ලී කැටයම් ශිල්පියා බියකරු ගුරුළු වෙස් මුහුණක් කැටයම් කළේය.",
            presentEnglish = "Ambalangoda masks preserve ancient ritual healing traditions.",
            presentSinhala = "අම්බලන්ගොඩ වෙස් මුහුණු පැරණි ශාන්තිකර්ම සම්ප්‍රදායන් සුරකියි.",
            futureEnglish = "He will paint the demon mask with natural mineral dyes.",
            futureSinhala = "ඔහු ස්වභාවික ඛනිජ සායම් වලින් යක්ෂ වෙස්මුහුණ වර්ණ ගන්වනු ඇත.",
            verbTransformation = "carved → preserve → will paint"
          ),
          TenseSentenceItem(
            id = "t15_s25",
            baseActionSinhala = "මල් වඩම් සැකසීම",
            pastEnglish = "The florist arranged a floral wreath with white lilies.",
            pastSinhala = "මල් ශිල්පියා සුදු මානෙල් මල්වලින් මල් වඩමක් සැකසුවේය.",
            presentEnglish = "Floral tributes honor departed souls at memorial events.",
            presentSinhala = "මල් සැරසිලි සැමරුම් අවස්ථාවලදී වියෝ වූවන්ට ගෞරව දක්වයි.",
            futureEnglish = "We will place a fragrant garland around the statue.",
            futureSinhala = "අපි පිළිමය වටා සුවඳවත් මල් මාලයක් පළඳවන්නෙමු.",
            verbTransformation = "arranged → honor → will place"
          ),
          TenseSentenceItem(
            id = "t15_s26",
            baseActionSinhala = "සංගීත ප්‍රසංගයක් පැවැත්වීම",
            pastEnglish = "The philharmonic orchestra gave a breathtaking performance.",
            pastSinhala = "වාද්‍ය වෘන්දය මනස්කාන්ත සංගීත ප්‍රසංගයක් පැවැත්වීය.",
            presentEnglish = "Live symphony concerts touch the depths of human souls.",
            presentSinhala = "සජීවී වාද්‍ය ප්‍රසංග මිනිස් ආත්මයේ ගැඹුර ස්පර්ශ කරයි.",
            futureEnglish = "The musicians will perform under open stars tonight.",
            futureSinhala = "සංගීතඥයෝ අද රෑ විවෘත අහස යට සංගීතය ඉදිරිපත් කරනු ඇත.",
            verbTransformation = "gave → touch → will perform"
          ),
          TenseSentenceItem(
            id = "t15_s27",
            baseActionSinhala = "තොරණක් නැරඹීම",
            pastEnglish = "Pilgrims admired the towering Vesak pandal lights.",
            pastSinhala = "වන්දනාකරුවෝ උස් වෙසක් තොරණේ විදුලි ආලෝකය අගය කළහ.",
            presentEnglish = "Vesak pandals illustrate classic Jataka tales to pilgrims.",
            presentSinhala = "වෙසක් තොරණ බැතිමතුන්ට සම්භාව්‍ය ජාතක කතා නිරූපණය කරයි.",
            futureEnglish = "We will visit the Colombo grand pandal on Poya day.",
            futureSinhala = "අපි පෝය දිනයේදී කොළඹ මහා තොරණ නැරඹීමට යන්නෙමු.",
            verbTransformation = "admired → illustrate → will visit"
          ),
          TenseSentenceItem(
            id = "t15_s28",
            baseActionSinhala = "සංස්කෘතික නර්තන ඇඳුම ඇඳීම",
            pastEnglish = "The lead dancer donned the sacred headdress reverently.",
            pastSinhala = "ප්‍රධාන නර්තන ශිල්පියා පූජනීය ඔටුන්න භක්තියෙන් පැළඳ ගත්තේය.",
            presentEnglish = "Dancers respect ceremonial ornaments as sacred emblems.",
            presentSinhala = "නර්තන ශිල්පීහු උත්සව ආභරණ පූජනීය සංකේත ලෙස සලකති.",
            futureEnglish = "The graduate will receive the sacred Ves ornament tomorrow.",
            futureSinhala = "උපාධිධාරී නර්තන ශිල්පියා හෙට පූජනීය වෙස් තට්ටුව පළඳිනු ඇත.",
            verbTransformation = "donned → respect → will receive"
          ),
          TenseSentenceItem(
            id = "t15_s29",
            baseActionSinhala = "පැරණි කාසි අධ්‍යයනය කිරීම",
            pastEnglish = "The numismatist examined an Anuradhapura copper coin.",
            pastSinhala = "කාසි විද්‍යාඥයා අනුරාධපුර යුගයේ තඹ කාසියක් පරීක්ෂා කළේය.",
            presentEnglish = "Historic coins reveal trade routes and sovereign dynasties.",
            presentSinhala = "ඓතිහාසික කාසි වෙළඳ මාර්ග සහ රාජවංශ පිළිබඳ තොරතුරු හෙළි කරයි.",
            futureEnglish = "The professor will publish research on Polonnaruwa coinage.",
            futureSinhala = "මහාචාර්යවරයා පොළොන්නරු යුගයේ කාසි පිළිබඳ පර්යේෂණ ප්‍රකාශයට පත් කරනු ඇත.",
            verbTransformation = "examined → reveal → will publish"
          ),
          TenseSentenceItem(
            id = "t15_s30",
            baseActionSinhala = "සංස්කෘතික උරුමයන් අගය කිරීම",
            pastEnglish = "Our forefathers created magnificent artistic masterworks.",
            pastSinhala = "අපේ මුතුන්මිත්තෝ විශිෂ්ට කලාකෘති නිර්මාණය කළහ.",
            presentEnglish = "Living cultural arts enrich the collective human soul.",
            presentSinhala = "ජීවමාන සංස්කෘතික කලාවන් සමස්ත මානව ආත්මය පෝෂණය කරයි.",
            futureEnglish = "We will safeguard our priceless national heritage for posterity.",
            futureSinhala = "අපි අනාගත පරපුර උදෙසා අපේ අමිල ජාතික උරුමය සුරක්ෂිත කරන්නෙමු.",
            verbTransformation = "created → enrich → will safeguard"
          )
        )
      )
    )
  }
}
