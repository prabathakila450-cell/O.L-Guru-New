package com.example

object TenseDataPart1 {
  fun getCategoriesPart1(): List<TenseComparisonCategory> {
    return listOf(
      // ==========================================
      // Category 1: උදෑසන දෛනික චර්යාවන් (Morning Daily Routines) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 1,
        titleSinhala = "කාණ්ඩය 01: උදෑසන දෛනික චර්යාවන්",
        titleEnglish = "Morning Daily Routines",
        icon = "🌅",
        description = "උදෑසන අවදිවීම, මුහුණ සේදීම, ව්‍යායාම සහ දෛනික ආරම්භය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම (අතීත, වර්තමාන, අනාගත).",
        sentences = listOf(
          TenseSentenceItem(
            id = "t1_s1",
            baseActionSinhala = "උදෑසන 6ට අවදි වීම",
            pastEnglish = "I woke up at 6:00 AM yesterday.",
            pastSinhala = "මම ඊයේ උදෑසන 6:00 ට අවදි වුණෙමි.",
            presentEnglish = "I wake up at 6:00 AM every day.",
            presentSinhala = "මම සෑම දිනකම උදෑසන 6:00 ට අවදි වෙමි.",
            futureEnglish = "I will wake up at 6:00 AM tomorrow.",
            futureSinhala = "මම හෙට උදෑසන 6:00 ට අවදි වන්නෙමි.",
            verbTransformation = "woke up → wake up → will wake up"
          ),
          TenseSentenceItem(
            id = "t1_s2",
            baseActionSinhala = "දත් මැදීම",
            pastEnglish = "He brushed his teeth after getting up.",
            pastSinhala = "ඔහු අවදි වූ පසු දත් මැද්දේය.",
            presentEnglish = "He brushes his teeth every morning.",
            presentSinhala = "ඔහු සෑම උදෑසනකම දත් මදියි.",
            futureEnglish = "He will brush his teeth soon.",
            futureSinhala = "ඔහු ඉක්මනින්ම දත් මදිනු ඇත.",
            verbTransformation = "brushed → brushes → will brush"
          ),
          TenseSentenceItem(
            id = "t1_s3",
            baseActionSinhala = "මුහුණ සේදීම",
            pastEnglish = "She washed her face with cold water.",
            pastSinhala = "ඇය සිසිල් ජලයෙන් මුහුණ සේදුවාය.",
            presentEnglish = "She washes her face with cold water.",
            presentSinhala = "ඇය සිසිල් ජලයෙන් මුහුණ සෝදයි.",
            futureEnglish = "She will wash her face in a moment.",
            futureSinhala = "ඇය මද වේලාවකින් මුහුණ සෝදනු ඇත.",
            verbTransformation = "washed → washes → will wash"
          ),
          TenseSentenceItem(
            id = "t1_s4",
            baseActionSinhala = "ඇඳ පිළිවෙළට සකස් කිරීම",
            pastEnglish = "Nimal made his bed neatly.",
            pastSinhala = "නිමල් ඔහුගේ ඇඳ පිළිවෙළට සකස් කළේය.",
            presentEnglish = "Nimal makes his bed neatly every day.",
            presentSinhala = "නිමල් සෑම දිනකම ඔහුගේ ඇඳ පිළිවෙළට සකස් කරයි.",
            futureEnglish = "Nimal will make his bed before leaving.",
            futureSinhala = "නිමල් පිටත්ව යාමට පෙර ඔහුගේ ඇඳ පිළිවෙළට සකස් කරනු ඇත.",
            verbTransformation = "made → makes → will make"
          ),
          TenseSentenceItem(
            id = "t1_s5",
            baseActionSinhala = "උදෑසන වතුර වීදුරුවක් බීම",
            pastEnglish = "We drank a glass of warm water.",
            pastSinhala = "අපි උණුසුම් වතුර වීදුරුවක් බීවෙමු.",
            presentEnglish = "We drink a glass of warm water.",
            presentSinhala = "අපි උණුසුම් වතුර වීදුරුවක් බොමු.",
            futureEnglish = "We will drink a glass of warm water.",
            futureSinhala = "අපි උණුසුම් වතුර වීදුරුවක් බොන්නෙමු.",
            verbTransformation = "drank → drink → will drink"
          ),
          TenseSentenceItem(
            id = "t1_s6",
            baseActionSinhala = "යෝග හෝ ව්‍යායාම කිරීම",
            pastEnglish = "Father did morning exercises yesterday.",
            pastSinhala = "තාත්තා ඊයේ උදෑසන ව්‍යායාම කළේය.",
            presentEnglish = "Father does morning exercises regularly.",
            presentSinhala = "තාත්තා නිතිපතා උදෑසන ව්‍යායාම කරයි.",
            futureEnglish = "Father will do morning exercises tomorrow.",
            futureSinhala = "තාත්තා හෙට උදෑසන ව්‍යායාම කරනු ඇත.",
            verbTransformation = "did → does → will do"
          ),
          TenseSentenceItem(
            id = "t1_s7",
            baseActionSinhala = "ස්නානය කිරීම",
            pastEnglish = "I took a refreshing morning bath.",
            pastSinhala = "මම ප්‍රබෝධමත් උදෑසන ස්නානයක් කළෙමි.",
            presentEnglish = "I take a refreshing morning bath.",
            presentSinhala = "මම ප්‍රබෝධමත් උදෑසන ස්නානයක් කරමි.",
            futureEnglish = "I will take a refreshing bath soon.",
            futureSinhala = "මම ඉක්මනින් ප්‍රබෝධමත් ස්නානයක් කරන්නෙමි.",
            verbTransformation = "took → take → will take"
          ),
          TenseSentenceItem(
            id = "t1_s8",
            baseActionSinhala = "පිරිසිදු ඇඳුම් ඇඳීම",
            pastEnglish = "Kamal wore his school uniform.",
            pastSinhala = "කමල් ඔහුගේ පාසල් නිල ඇඳුම ඇන්දේය.",
            presentEnglish = "Kamal wears his school uniform on weekdays.",
            presentSinhala = "කමල් සතියේ දිනවල පාසල් නිල ඇඳුම අඳියි.",
            futureEnglish = "Kamal will wear his school uniform tomorrow.",
            futureSinhala = "කමල් හෙට ඔහුගේ පාසල් නිල ඇඳුම අඳිනු ඇත.",
            verbTransformation = "wore → wears → will wear"
          ),
          TenseSentenceItem(
            id = "t1_s9",
            baseActionSinhala = "කොණ්ඩය පීරීම",
            pastEnglish = "Amali combed her long hair.",
            pastSinhala = "අමාලි ඇගේ දිගු කෙස් කළඹ පීරුවාය.",
            presentEnglish = "Amali combs her long hair.",
            presentSinhala = "අමාලි ඇගේ දිගු කෙස් කළඹ පීරයි.",
            futureEnglish = "Amali will comb her hair nicely.",
            futureSinhala = "අමාලි ඇගේ හිසකෙස් ලස්සනට පීරනු ඇත.",
            verbTransformation = "combed → combs → will comb"
          ),
          TenseSentenceItem(
            id = "t1_s10",
            baseActionSinhala = "ආගමික වතාවත් ඉටු කිරීම",
            pastEnglish = "They offered flowers at the altar.",
            pastSinhala = "ඔවුහු බුදු පහන තබා මල් පූජා කළහ.",
            presentEnglish = "They offer flowers at the altar daily.",
            presentSinhala = "ඔවුහු දිනපතා බුදු පහන තබා මල් පූජා කරති.",
            futureEnglish = "They will offer flowers at the altar.",
            futureSinhala = "ඔවුහු බුදු පහන තබා මල් පූජා කරනු ඇත.",
            verbTransformation = "offered → offer → will offer"
          ),
          TenseSentenceItem(
            id = "t1_s11",
            baseActionSinhala = "උදෑසන තේ කෝප්පයක් පානය",
            pastEnglish = "Mother drank a hot cup of tea.",
            pastSinhala = "අම්මා උණුසුම් තේ කෝප්පයක් බීවාය.",
            presentEnglish = "Mother drinks a hot cup of tea.",
            presentSinhala = "අම්මා උණුසුම් තේ කෝප්පයක් බොයි.",
            futureEnglish = "Mother will drink tea in a few minutes.",
            futureSinhala = "අම්මා තව මිනිත්තු කිහිපයකින් තේ බොනු ඇත.",
            verbTransformation = "drank → drinks → will drink"
          ),
          TenseSentenceItem(
            id = "t1_s12",
            baseActionSinhala = "පුවත්පත කියවීම",
            pastEnglish = "Grandfather read the morning paper.",
            pastSinhala = "සීයා උදෑසන පුවත්පත කියෙව්වේය.",
            presentEnglish = "Grandfather reads the morning paper.",
            presentSinhala = "සීයා උදෑසන පුවත්පත කියවයි.",
            futureEnglish = "Grandfather will read the newspaper.",
            futureSinhala = "සීයා පුවත්පත කියවනු ඇත.",
            verbTransformation = "read (red) → reads → will read"
          ),
          TenseSentenceItem(
            id = "t1_s13",
            baseActionSinhala = "උදෑසන ආහාරය ගැනීම",
            pastEnglish = "We ate breakfast together.",
            pastSinhala = "අපි එකට උදෑසන ආහාරය ගත්තෙමු.",
            presentEnglish = "We eat breakfast together.",
            presentSinhala = "අපි එකට උදෑසන ආහාරය ගනිමු.",
            futureEnglish = "We will eat breakfast together.",
            futureSinhala = "අපි එකට උදෑසන ආහාරය ගන්නෙමු.",
            verbTransformation = "ate → eat → will eat"
          ),
          TenseSentenceItem(
            id = "t1_s14",
            baseActionSinhala = "පාසල් බෑගය සූදානම් කිරීම",
            pastEnglish = "The boy packed his school bag.",
            pastSinhala = "පිරිමි ළමයා ඔහුගේ පාසල් බෑගය සූදානම් කළේය.",
            presentEnglish = "The boy packs his school bag carefully.",
            presentSinhala = "පිරිමි ළමයා ඔහුගේ පාසල් බෑගය ප්‍රවේශමෙන් සූදානම් කරයි.",
            futureEnglish = "The boy will pack his school bag tonight.",
            futureSinhala = "පිරිමි ළමයා අද රෑ ඔහුගේ පාසල් බෑගය සූදානම් කරනු ඇත.",
            verbTransformation = "packed → packs → will pack"
          ),
          TenseSentenceItem(
            id = "t1_s15",
            baseActionSinhala = "සපත්තු පැළඳීම",
            pastEnglish = "I polished and put on my shoes.",
            pastSinhala = "මම සපත්තු පොලිෂ් කර පැළඳගත්තෙමි.",
            presentEnglish = "I put on my clean shoes.",
            presentSinhala = "මම මගේ පිරිසිදු සපත්තු පැළඳගනිමි.",
            futureEnglish = "I will put on my shoes shortly.",
            futureSinhala = "මම මද වේලාවකින් සපත්තු පැළඳගන්නෙමි.",
            verbTransformation = "put on → put on → will put on"
          ),
          TenseSentenceItem(
            id = "t1_s16",
            baseActionSinhala = "දෙමාපියන්ට වැඳ ආශිර්වාද ගැනීම",
            pastEnglish = "She worshipped her parents respectfully.",
            pastSinhala = "ඇය දෙමාපියන්ට ගෞරවයෙන් වැන්දාය.",
            presentEnglish = "She worships her parents every morning.",
            presentSinhala = "ඇය සෑම උදෑසනකම දෙමාපියන්ට වඳියි.",
            futureEnglish = "She will worship her parents before leaving.",
            futureSinhala = "ඇය පිටත්ව යාමට පෙර දෙමාපියන්ට වඳිනු ඇත.",
            verbTransformation = "worshipped → worships → will worship"
          ),
          TenseSentenceItem(
            id = "t1_s17",
            baseActionSinhala = "ජනේල හැර නැවුම් සුළඟ ගැනීම",
            pastEnglish = "He opened the bedroom windows.",
            pastSinhala = "ඔහු නිදන කාමරයේ ජනේල ඇරියේය.",
            presentEnglish = "He opens the windows for fresh air.",
            presentSinhala = "ඔහු නැවුම් වාතය සඳහා ජනේල අරියි.",
            futureEnglish = "He will open the windows early.",
            futureSinhala = "ඔහු වේලාසනින් ජනේල අරිනු ඇත.",
            verbTransformation = "opened → opens → will open"
          ),
          TenseSentenceItem(
            id = "t1_s18",
            baseActionSinhala = "සුරතල් සතුන්ට කෑම දීම",
            pastEnglish = "Sister fed our pet dog in the yard.",
            pastSinhala = "නංගී මිදුලේ සිටි සුරතල් බල්ලාට කෑම දුන්නාය.",
            presentEnglish = "Sister feeds our pet dog in the yard.",
            presentSinhala = "නංගී මිදුලේ සිටින සුරතල් බල්ලාට කෑම දෙයි.",
            futureEnglish = "Sister will feed the puppy soon.",
            futureSinhala = "නංගී සුරතල් බලු පැටියාට ඉක්මනින් කෑම දෙනු ඇත.",
            verbTransformation = "fed → feeds → will feed"
          ),
          TenseSentenceItem(
            id = "t1_s19",
            baseActionSinhala = "වත්තේ මල් පැළවලට වතුර දැමීම",
            pastEnglish = "Mother watered the flower plants.",
            pastSinhala = "අම්මා මල් පැළවලට වතුර දැමුවාය.",
            presentEnglish = "Mother waters the flower plants daily.",
            presentSinhala = "අම්මා දිනපතා මල් පැළවලට වතුර දමයි.",
            futureEnglish = "Mother will water the plants in the evening.",
            futureSinhala = "අම්මා සවසට මල් පැළවලට වතුර දමනු ඇත.",
            verbTransformation = "watered → waters → will water"
          ),
          TenseSentenceItem(
            id = "t1_s20",
            baseActionSinhala = "කාලගුණ වාර්තාවට සවන් දීම",
            pastEnglish = "We listened to the morning weather report.",
            pastSinhala = "අපි උදෑසන කාලගුණ වාර්තාවට සවන් දුන්නෙමු.",
            presentEnglish = "We listen to the morning weather report.",
            presentSinhala = "අපි උදෑසන කාලගුණ වාර්තාවට සවන් දෙමු.",
            futureEnglish = "We will listen to the weather update.",
            futureSinhala = "අපි කාලගුණ තොරතුරු වෙත සවන් දෙන්නෙමු.",
            verbTransformation = "listened → listen → will listen"
          ),
          TenseSentenceItem(
            id = "t1_s21",
            baseActionSinhala = "දෛනික කාලසටහන පරීක්ෂා කිරීම",
            pastEnglish = "I checked my study timetable.",
            pastSinhala = "මම මගේ පාඩම් කාලසටහන පරීක්ෂා කළෙමි.",
            presentEnglish = "I check my study timetable every day.",
            presentSinhala = "මම සෑම දිනකම මගේ කාලසටහන පරීක්ෂා කරමි.",
            futureEnglish = "I will check my schedule tomorrow morning.",
            futureSinhala = "මම හෙට උදෑසන මගේ කාලසටහන පරීක්ෂා කරන්නෙමි.",
            verbTransformation = "checked → checks → will check"
          ),
          TenseSentenceItem(
            id = "t1_s22",
            baseActionSinhala = "කුරුල්ලන්ගේ නාදය ඇසීම",
            pastEnglish = "We heard sweet chirping of birds.",
            pastSinhala = "අපට කුරුල්ලන්ගේ මිහිරි නාදය ඇසුණි.",
            presentEnglish = "We hear sweet chirping of birds.",
            presentSinhala = "අපට කුරුල්ලන්ගේ මිහිරි නාදය ඇසේ.",
            futureEnglish = "We will hear birds singing tomorrow.",
            futureSinhala = "හෙට අපට කුරුල්ලන් ගයන හඬ ඇසෙනු ඇත.",
            verbTransformation = "heard → hear → will hear"
          ),
          TenseSentenceItem(
            id = "t1_s23",
            baseActionSinhala = "දිවා ආහාර පෙට්ටිය සූදානම් කිරීම",
            pastEnglish = "Mother packed my lunch box with rice.",
            pastSinhala = "අම්මා බත් සමඟ මගේ කෑම පෙට්ටිය සූදානම් කළාය.",
            presentEnglish = "Mother packs my lunch box with nutritious food.",
            presentSinhala = "අම්මා පෝෂ්‍යදායී ආහාර සමඟ මගේ කෑම පෙට්ටිය සූදානම් කරයි.",
            futureEnglish = "Mother will pack my lunch box soon.",
            futureSinhala = "අම්මා මගේ කෑම පෙට්ටිය ඉක්මනින් සූදානම් කරනු ඇත.",
            verbTransformation = "packed → packs → will pack"
          ),
          TenseSentenceItem(
            id = "t1_s24",
            baseActionSinhala = "වතුර බෝතලය පුරවා ගැනීම",
            pastEnglish = "I filled my water bottle with boiled water.",
            pastSinhala = "මම නටවා නිවාගත් ජලයෙන් වතුර බෝතලය පුරවා ගත්තෙමි.",
            presentEnglish = "I fill my water bottle every morning.",
            presentSinhala = "මම සෑම උදෑසනකම මගේ වතුර බෝතලය පුරවා ගනිමි.",
            futureEnglish = "I will fill my water bottle before going.",
            futureSinhala = "මම යාමට පෙර වතුර බෝතලය පුරවා ගන්නෙමි.",
            verbTransformation = "filled → fill → will fill"
          ),
          TenseSentenceItem(
            id = "t1_s25",
            baseActionSinhala = "නිවසින් පිටත්වීම",
            pastEnglish = "They left home at 7:00 AM.",
            pastSinhala = "ඔවුහු උදෑසන 7:00 ට නිවසින් පිටත්ව ගියහ.",
            presentEnglish = "They leave home at 7:00 AM.",
            presentSinhala = "ඔවුහු උදෑසන 7:00 ට නිවසින් පිටත්ව යති.",
            futureEnglish = "They will leave home on time.",
            futureSinhala = "ඔවුහු නියමිත වේලාවට නිවසින් පිටත්ව යනු ඇත.",
            verbTransformation = "left → leave → will leave"
          ),
          TenseSentenceItem(
            id = "t1_s26",
            baseActionSinhala = "බස් නැවතුම වෙත ඇවිදීම",
            pastEnglish = "We walked quickly to the bus stop.",
            pastSinhala = "අපි බස් නැවතුම වෙත ඉක්මනින් ඇවිද ගියෙමු.",
            presentEnglish = "We walk to the bus stop together.",
            presentSinhala = "අපි එකට බස් නැවතුම වෙත ඇවිද යමු.",
            futureEnglish = "We will walk to the stop soon.",
            futureSinhala = "අපි ඉක්මනින්ම බස් නැවතුම වෙත ඇවිද යන්නෙමු.",
            verbTransformation = "walked → walk → will walk"
          ),
          TenseSentenceItem(
            id = "t1_s27",
            baseActionSinhala = "අසල්වැසියන්ට සුබ පැතීම",
            pastEnglish = "Father wished good morning to neighbors.",
            pastSinhala = "තාත්තා අසල්වාසීන්ට සුබ උදෑසනක් ප්‍රාර්ථනා කළේය.",
            presentEnglish = "Father wishes good morning with a smile.",
            presentSinhala = "තාත්තා සිනහවකින් යුතුව අසල්වාසීන්ට සුබ පතයි.",
            futureEnglish = "Father will wish them when he meets them.",
            futureSinhala = "තාත්තා ඔවුන් මුණගැසුණු විට සුබ පතනු ඇත.",
            verbTransformation = "wished → wishes → will wish"
          ),
          TenseSentenceItem(
            id = "t1_s28",
            baseActionSinhala = "පාසල් වෑන් රථය පැමිණීම",
            pastEnglish = "The school van arrived on time.",
            pastSinhala = "පාසල් වෑන් රථය නියමිත වේලාවට පැමිණියේය.",
            presentEnglish = "The school van arrives at 7:15 AM.",
            presentSinhala = "පාසල් වෑන් රථය උදෑසන 7:15 ට පැමිණෙයි.",
            futureEnglish = "The school van will arrive in five minutes.",
            futureSinhala = "පාසල් වෑන් රථය තව මිනිත්තු පහකින් පැමිණෙනු ඇත.",
            verbTransformation = "arrived → arrives → will arrive"
          ),
          TenseSentenceItem(
            id = "t1_s29",
            baseActionSinhala = "දොර අගුළු දැමීම",
            pastEnglish = "He locked the front door securely.",
            pastSinhala = "ඔහු ඉදිරිපස දොර සුරක්ෂිතව අගුළු දැමුවේය.",
            presentEnglish = "He locks the front door before leaving.",
            presentSinhala = "ඔහු පිටවීමට පෙර ඉදිරිපස දොර අගුළු දමයි.",
            futureEnglish = "He will lock the door carefully.",
            futureSinhala = "ඔහු දොර ප්‍රවේශමෙන් අගුළු දමනු ඇත.",
            verbTransformation = "locked → locks → will lock"
          ),
          TenseSentenceItem(
            id = "t1_s30",
            baseActionSinhala = "නව දවසක් උද්යෝගයෙන් ඇරඹීම",
            pastEnglish = "We started the new day with high enthusiasm.",
            pastSinhala = "අපි මහත් උද්යෝගයකින් නව දිනය ආරම්භ කළෙමු.",
            presentEnglish = "We start each day with a positive mindset.",
            presentSinhala = "අපි සෑම දිනක්ම ධනාත්මක ආකල්පයකින් ආරම්භ කරමු.",
            futureEnglish = "We will start tomorrow with great confidence.",
            futureSinhala = "අපි හෙට දිනය මහත් විශ්වාසයකින් ආරම්භ කරන්නෙමු.",
            verbTransformation = "started → start → will start"
          )
        )
      ),

      // ==========================================
      // Category 2: ආහාර ගැනීම සහ පිසීම (Eating, Cooking & Meals) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 2,
        titleSinhala = "කාණ්ඩය 02: ආහාර ගැනීම, බීම සහ පිසීම",
        titleEnglish = "Eating, Cooking & Dining",
        icon = "🍲",
        description = "ආහාර පිසීම, එළවළු කැපීම, දිවා ආහාරය සහ රස බැලීම පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t2_s1",
            baseActionSinhala = "බත් පිසීම",
            pastEnglish = "Mother cooked delicious rice in the clay pot.",
            pastSinhala = "අම්මා මැටි වළඳේ රසවත් බත් පිසුවාය.",
            presentEnglish = "Mother cooks rice in the rice cooker.",
            presentSinhala = "අම්මා රයිස් කුකරයේ බත් පිසින්නීය.",
            futureEnglish = "Mother will cook yellow rice for lunch.",
            futureSinhala = "අම්මා දවල්ට කහ බත් පිසිනු ඇත.",
            verbTransformation = "cooked → cooks → will cook"
          ),
          TenseSentenceItem(
            id = "t2_s2",
            baseActionSinhala = "එළවළු කැපීම",
            pastEnglish = "She chopped fresh vegetables for soup.",
            pastSinhala = "ඇය සුප් සඳහා නැවුම් එළවළු කැපුවාය.",
            presentEnglish = "She chops vegetables into small pieces.",
            presentSinhala = "ඇය එළවළු කුඩා කැබලිවලට කපයි.",
            futureEnglish = "She will chop carrots and beans soon.",
            futureSinhala = "ඇය කැරට් සහ බෝංචි ඉක්මනින් කපනු ඇත.",
            verbTransformation = "chopped → chops → will chop"
          ),
          TenseSentenceItem(
            id = "t2_s3",
            baseActionSinhala = "පොල් ගෑම",
            pastEnglish = "Sister scraped the coconut yesterday.",
            pastSinhala = "නංගී ඊයේ පොල් ගෑවාය.",
            presentEnglish = "Sister scrapes coconut for the sambol.",
            presentSinhala = "නංගී සම්බෝලය සඳහා පොල් ගායි.",
            futureEnglish = "Sister will scrape coconut for dinner.",
            futureSinhala = "නංගී රාත්‍රී කෑම සඳහා පොල් ගානු ඇත.",
            verbTransformation = "scraped → scrapes → will scrape"
          ),
          TenseSentenceItem(
            id = "t2_s4",
            baseActionSinhala = "පොල් කිරි මිරිකීම",
            pastEnglish = "Grandmother squeezed thick coconut milk.",
            pastSinhala = "මිත්තණිය උකු පොල් කිරි මිරිකුවාය.",
            presentEnglish = "Grandmother squeezes fresh coconut milk.",
            presentSinhala = "මිත්තණිය නැවුම් පොල් කිරි මිරිකයි.",
            futureEnglish = "Grandmother will squeeze milk for curry.",
            futureSinhala = "මිත්තණිය ව්‍යංජනය සඳහා කිරි මිරිකනු ඇත.",
            verbTransformation = "squeezed → squeezes → will squeeze"
          ),
          TenseSentenceItem(
            id = "t2_s5",
            baseActionSinhala = "වතුර උණු කිරීම",
            pastEnglish = "He boiled water in the electric kettle.",
            pastSinhala = "ඔහු විදුලි කේතලයේ වතුර උණු කළේය.",
            presentEnglish = "He boils drinking water every morning.",
            presentSinhala = "ඔහු සෑම උදෑසනකම බීමට ජලය උණු කරයි.",
            futureEnglish = "He will boil water for making tea.",
            futureSinhala = "ඔහු තේ සෑදීමට වතුර උණු කරනු ඇත.",
            verbTransformation = "boiled → boils → will boil"
          ),
          TenseSentenceItem(
            id = "t2_s6",
            baseActionSinhala = "මාළු බැදීම",
            pastEnglish = "Father fried fish with spices.",
            pastSinhala = "තාත්තා තුනපහ දමා මාළු බැද්දේය.",
            presentEnglish = "Father fries fish until it turns golden.",
            presentSinhala = "තාත්තා රන්වන් පැහැ වන තුරු මාළු බදිනු ලබයි.",
            futureEnglish = "Father will fry fresh fish for dinner.",
            futureSinhala = "තාත්තා රාත්‍රී ආහාරයට නැවුම් මාළු බදිනු ඇත.",
            verbTransformation = "fried → fries → will fry"
          ),
          TenseSentenceItem(
            id = "t2_s7",
            baseActionSinhala = "කෑම මේසය සැකසීම",
            pastEnglish = "We set the dining table neatly.",
            pastSinhala = "අපි කෑම මේසය පිළිවෙළට සකස් කළෙමු.",
            presentEnglish = "We set the table before meals.",
            presentSinhala = "අපි කෑමට පෙර මේසය පිළියෙල කරමු.",
            futureEnglish = "We will set the table for our guests.",
            futureSinhala = "අපි අමුත්තන් සඳහා මේසය පිළියෙල කරන්නෙමු.",
            verbTransformation = "set → set → will set"
          ),
          TenseSentenceItem(
            id = "t2_s8",
            baseActionSinhala = "අත් සේදීම",
            pastEnglish = "The children washed their hands before eating.",
            pastSinhala = "ළමයි කෑමට පෙර අත් සේදුවෝය.",
            presentEnglish = "The children wash their hands with soap.",
            presentSinhala = "ළමයි සබන් යොදා අත් සෝදති.",
            futureEnglish = "The children will wash their hands properly.",
            futureSinhala = "ළමයි නිසි ලෙස අත් සෝදනු ඇත.",
            verbTransformation = "washed → wash → will wash"
          ),
          TenseSentenceItem(
            id = "t2_s9",
            baseActionSinhala = "දිවා ආහාරය ගැනීම",
            pastEnglish = "I ate rice and curry at 1:00 PM.",
            pastSinhala = "මම දවල් 1:00 ට බත් සහ ව්‍යංජන කෑවෙමි.",
            presentEnglish = "I eat a balanced meal every day.",
            presentSinhala = "මම සෑම දිනකම සමබර ආහාරයක් ගනිමි.",
            futureEnglish = "I will eat lunch with my friends.",
            futureSinhala = "මම මිතුරන් සමඟ දිවා ආහාරය ගන්නෙමි.",
            verbTransformation = "ate → eat → will eat"
          ),
          TenseSentenceItem(
            id = "t2_s10",
            baseActionSinhala = "සුප් රස බැලීම",
            pastEnglish = "The chef tasted the hot vegetable soup.",
            pastSinhala = "ප්‍රධාන සූපවේදියා උණුසුම් එළවළු සුප් රස බැලුවේය.",
            presentEnglish = "The chef tastes the curry before serving.",
            presentSinhala = "සූපවේදියා පිළිගැන්වීමට පෙර ව්‍යංජනය රස බලයි.",
            futureEnglish = "The chef will taste the new dessert.",
            futureSinhala = "සූපවේදියා නව අතුරුපස රස බලනු ඇත.",
            verbTransformation = "tasted → tastes → will taste"
          ),
          TenseSentenceItem(
            id = "t2_s11",
            baseActionSinhala = "ලුණු එකතු කිරීම",
            pastEnglish = "She added a pinch of salt.",
            pastSinhala = "ඇය ලුණු ස්වල්පයක් එකතු කළාය.",
            presentEnglish = "She adds moderate salt to dishes.",
            presentSinhala = "ඇය කෑමවලට මධ්‍යස්ථව ලුණු එකතු කරයි.",
            futureEnglish = "She will add salt if necessary.",
            futureSinhala = "ඇය අවශ්‍ය නම් ලුණු එකතු කරනු ඇත.",
            verbTransformation = "added → adds → will add"
          ),
          TenseSentenceItem(
            id = "t2_s12",
            baseActionSinhala = "කිරි වීදුරුවක් බීම",
            pastEnglish = "Baby drank a cup of warm milk.",
            pastSinhala = "බබා උණුසුම් කිරි කෝප්පයක් බීවේය.",
            presentEnglish = "Baby drinks milk every bedtime.",
            presentSinhala = "බබා සෑම රාත්‍රියකම නිදාගැනීමට පෙර කිරි බොයි.",
            futureEnglish = "Baby will drink milk after dinner.",
            futureSinhala = "බබා රෑ කෑමෙන් පසු කිරි බොනු ඇත.",
            verbTransformation = "drank → drinks → will drink"
          ),
          TenseSentenceItem(
            id = "t2_s13",
            baseActionSinhala = "පලතුරු කැපීම",
            pastEnglish = "We sliced ripe mangoes and papayas.",
            pastSinhala = "අපි ඉදුණු අඹ සහ ගස්ලබු පෙති කැපුවෙමු.",
            presentEnglish = "We slice fresh fruits for fruit salad.",
            presentSinhala = "අපි පලතුරු සලාදය සඳහා නැවුම් පලතුරු කපමු.",
            futureEnglish = "We will slice an apple for snack.",
            futureSinhala = "අපි කෙටි කෑමක් සඳහා ඇපල් ගෙඩියක් කපන්නෙමු.",
            verbTransformation = "sliced → slice → will slice"
          ),
          TenseSentenceItem(
            id = "t2_s14",
            baseActionSinhala = "කේක් එකක් පිළිස්සීම",
            pastEnglish = "Aunt baked a chocolate cake yesterday.",
            pastSinhala = "නැන්දා ඊයේ චොකලට් කේක් එකක් පිළිස්සුවාය.",
            presentEnglish = "Aunt bakes butter cakes for birthdays.",
            presentSinhala = "නැන්දා උපන්දින සඳහා බටර් කේක් පුළුස්සයි.",
            futureEnglish = "Aunt will bake cookies tomorrow.",
            futureSinhala = "නැන්දා හෙට බිස්කට් පුළුස්සනු ඇත.",
            verbTransformation = "baked → bakes → will bake"
          ),
          TenseSentenceItem(
            id = "t2_s15",
            baseActionSinhala = "පිඟන් කෝප්ප සේදීම",
            pastEnglish = "Brother washed all dirty dishes.",
            pastSinhala = "අයියා සියලු අපිරිසිදු පිඟන් කෝප්ප සේදුවේය.",
            presentEnglish = "Brother washes dishes after every meal.",
            presentSinhala = "අයියා සෑම කෑම වේලකටම පසු පිඟන් සෝදයි.",
            futureEnglish = "Brother will wash the pans tonight.",
            futureSinhala = "අයියා අද රෑ භාජන සෝදනු ඇත.",
            verbTransformation = "washed → washes → will wash"
          ),
          TenseSentenceItem(
            id = "t2_s16",
            baseActionSinhala = "තේ පෙරීම",
            pastEnglish = "She brewed strong Ceylon tea.",
            pastSinhala = "ඇය උසස් සිලෝන් තේ පෙරා ගත්තාය.",
            presentEnglish = "She brews tea for evening tea time.",
            presentSinhala = "ඇය සවස තේ වේලාවට තේ පෙරයි.",
            futureEnglish = "She will brew fresh tea when guests arrive.",
            futureSinhala = "අමුත්තන් පැමිණි විට ඇය නැවුම් තේ පෙරනු ඇත.",
            verbTransformation = "brewed → brews → will brew"
          ),
          TenseSentenceItem(
            id = "t2_s17",
            baseActionSinhala = "ආප්ප සෑදීම",
            pastEnglish = "Mother made crispy hoppers for breakfast.",
            pastSinhala = "අම්මා උදෑසන කෑමට හැපෙනසුළු ආප්ප සෑදුවාය.",
            presentEnglish = "Mother makes egg hoppers on weekends.",
            presentSinhala = "අම්මා සති අන්තයේ බිත්තර ආප්ප සාදයි.",
            futureEnglish = "Mother will make hoppers this evening.",
            futureSinhala = "අම්මා අද සවස ආප්ප සාදනු ඇත.",
            verbTransformation = "made → makes → will make"
          ),
          TenseSentenceItem(
            id = "t2_s18",
            baseActionSinhala = "පලතුරු යුෂ සෑදීම",
            pastEnglish = "I blended fresh orange juice.",
            pastSinhala = "මම නැවුම් දොඩම් යුෂ බ්ලෙන්ඩර් කළෙමි.",
            presentEnglish = "I blend fruit smoothies without sugar.",
            presentSinhala = "මම සීනි රහිතව පලතුරු බීම සාදමි.",
            futureEnglish = "I will blend watermelon juice later.",
            futureSinhala = "මම පසුව කොමඩු යුෂ සාදන්නෙමි.",
            verbTransformation = "blended → blends → will blend"
          ),
          TenseSentenceItem(
            id = "t2_s19",
            baseActionSinhala = "ආහාර බෙදා ගැනීම",
            pastEnglish = "They shared their snacks happily.",
            pastSinhala = "ඔවුහු තම කෙටි ආහාර සතුටින් බෙදාගත්හ.",
            presentEnglish = "They share food with needy people.",
            presentSinhala = "ඔවුහු අවශ්‍යතා ඇති අයට ආහාර බෙදා දෙති.",
            futureEnglish = "They will share lunch at the picnic.",
            futureSinhala = "ඔවුහු විනෝද චාරිකාවේදී දිවා ආහාරය බෙදාගනු ඇත.",
            verbTransformation = "shared → share → will share"
          ),
          TenseSentenceItem(
            id = "t2_s20",
            baseActionSinhala = "රොටී පිළිස්සීම",
            pastEnglish = "Grandma baked coconut roti on pan.",
            pastSinhala = "මිත්තණිය තැටියේ පොල් රොටී පිළිස්සුවාය.",
            presentEnglish = "Grandma bakes hot roti with lunu miris.",
            presentSinhala = "මිත්තණිය ලුණු මිරිස් සමඟ උණුසුම් රොටී පුළුස්සයි.",
            futureEnglish = "Grandma will bake roti for us tonight.",
            futureSinhala = "මිත්තණිය අද රෑ අපට රොටී පුළුස්සා දෙනු ඇත.",
            verbTransformation = "baked → bakes → will bake"
          ),
          TenseSentenceItem(
            id = "t2_s21",
            baseActionSinhala = "ධාන්‍ය තැම්බීම",
            pastEnglish = "We boiled green gram for morning meal.",
            pastSinhala = "අපි උදෑසන ආහාරය සඳහා මුං ඇට තැම්බුවෙමු.",
            presentEnglish = "We boil chickpeas with grated coconut.",
            presentSinhala = "අපි ගාගත් පොල් සමඟ කඩල තම්බමු.",
            futureEnglish = "We will boil cowpea tomorrow.",
            futureSinhala = "අපි හෙට කවුපි තම්බන්නෙමු.",
            verbTransformation = "boiled → boil → will boil"
          ),
          TenseSentenceItem(
            id = "t2_s22",
            baseActionSinhala = "මස් හෝ පනීර් කරිය සෑදීම",
            pastEnglish = "He cooked rich dhal curry.",
            pastSinhala = "ඔහු රසවත් පරිප්පු ව්‍යංජනයක් පිසුවේය.",
            presentEnglish = "He cooks spicy curries expertly.",
            presentSinhala = "ඔහු ඉතා දක්ෂ ලෙස කුළුබඩු සහිත කරි පිසිනු ලබයි.",
            futureEnglish = "He will cook special curry for dinner.",
            futureSinhala = "ඔහු රාත්‍රී ආහාරයට විශේෂ ව්‍යංජනයක් පිසිනු ඇත.",
            verbTransformation = "cooked → cooks → will cook"
          ),
          TenseSentenceItem(
            id = "t2_s23",
            baseActionSinhala = "කෑම පිඟාන පිරිසිදු කර තැබීම",
            pastEnglish = "I cleared my plate after eating.",
            pastSinhala = "මම කෑමෙන් පසු මගේ පිඟාන පිරිසිදු කර තැබුවෙමි.",
            presentEnglish = "I clear my plate every time.",
            presentSinhala = "මම සෑම අවස්ථාවකම මගේ පිඟාන පිරිසිදු කර තබමි.",
            futureEnglish = "I will clear the table right away.",
            futureSinhala = "මම දැන්ම මේසය පිරිසිදු කරන්නෙමි.",
            verbTransformation = "cleared → clear → will clear"
          ),
          TenseSentenceItem(
            id = "t2_s24",
            baseActionSinhala = "වතුර උගුරක් බීම",
            pastEnglish = "The runner sipped water slowly.",
            pastSinhala = "ධාවකයා සෙමින් වතුර උගුරක් බීවේය.",
            presentEnglish = "The runner sips water between laps.",
            presentSinhala = "ධාවකයා වට අතරතුර වතුර උගුර බැගින් බොයි.",
            futureEnglish = "The runner will sip water at the station.",
            futureSinhala = "ධාවකයා නැවතුමේදී වතුර උගුරක් බොනු ඇත.",
            verbTransformation = "sipped → sips → will sip"
          ),
          TenseSentenceItem(
            id = "t2_s25",
            baseActionSinhala = "ආහාර අපතේ නොයැවීම",
            pastEnglish = "We did not waste any food.",
            pastSinhala = "අපි කිසිදු ආහාරයක් අපතේ නොයැව්වෙමු.",
            presentEnglish = "We do not waste precious food.",
            presentSinhala = "අපි වටිනා ආහාර අපතේ නොයවමු.",
            futureEnglish = "We will not waste food at the party.",
            futureSinhala = "අපි උත්සවයේදී ආහාර අපතේ නොයවන්නෙමු.",
            verbTransformation = "did not waste → do not waste → will not waste"
          ),
          TenseSentenceItem(
            id = "t2_s26",
            baseActionSinhala = "එළවළු සේදීම",
            pastEnglish = "Mother washed the gotukola thoroughly.",
            pastSinhala = "අම්මා ගොටුකොළ හොඳින් සේදුවාය.",
            presentEnglish = "Mother washes greens in clean water.",
            presentSinhala = "අම්මා පිරිසිදු ජලයෙන් පලා වර්ග සෝදයි.",
            futureEnglish = "Mother will wash spinach before cutting.",
            futureSinhala = "අම්මා නිවිති කැපීමට පෙර සෝදනු ඇත.",
            verbTransformation = "washed → washes → will wash"
          ),
          TenseSentenceItem(
            id = "t2_s27",
            baseActionSinhala = "ලූණු කැපීම",
            pastEnglish = "Tears came when I peeled onions.",
            pastSinhala = "මම ලූණු සුද්ද කරන විට කඳුළු ආවේය.",
            presentEnglish = "He peels red onions for the sambol.",
            presentSinhala = "ඔහු සම්බෝලයට රතු ලූණු සුද්ද කරයි.",
            futureEnglish = "He will peel garlic and ginger soon.",
            futureSinhala = "ඔහු සුදුලූණු සහ ඉඟුරු ඉක්මනින් සුද්ද කරනු ඇත.",
            verbTransformation = "peeled → peels → will peel"
          ),
          TenseSentenceItem(
            id = "t2_s28",
            baseActionSinhala = "ආහාර ආවරණය කර තැබීම",
            pastEnglish = "She covered the dishes with lids.",
            pastSinhala = "ඇය පියන්වලින් කෑම පිඟන් ආවරණය කළාය.",
            presentEnglish = "She covers all food from flies.",
            presentSinhala = "ඇය මැස්සන්ගෙන් ආරක්ෂා වීමට සියලු කෑම ආවරණය කරයි.",
            futureEnglish = "She will cover the leftover food.",
            futureSinhala = "ඇය ඉතිරි වූ ආහාර ආවරණය කර තබනු ඇත.",
            verbTransformation = "covered → covers → will cover"
          ),
          TenseSentenceItem(
            id = "t2_s29",
            baseActionSinhala = "කුළුබඩු ඇඹරීම",
            pastEnglish = "Grandma ground spices on the grinding stone.",
            pastSinhala = "මිත්තණිය මිරිස්ගලේ කුළුබඩු ඇඹරුවාය.",
            presentEnglish = "Grandma grinds fresh chili paste.",
            presentSinhala = "මිත්තණිය නැවුම් මිරිස් පේස්ට් අඹරයි.",
            futureEnglish = "Grandma will grind pepper for the stew.",
            futureSinhala = "මිත්තණිය ස්ටූ එක සඳහා ගම්මිරිස් අඹරනු ඇත.",
            verbTransformation = "ground → grinds → will grind"
          ),
          TenseSentenceItem(
            id = "t2_s30",
            baseActionSinhala = "රසවත් කෑම වේලකට ස්තූති කිරීම",
            pastEnglish = "Guests praised the delicious feast.",
            pastSinhala = "අමුත්තෝ රසවත් භෝජන සංග්‍රහය අගය කළහ.",
            presentEnglish = "Everyone praises mother's cooking.",
            presentSinhala = "හැමෝම අම්මාගේ කෑම පිසීමේ රසය අගය කරති.",
            futureEnglish = "Everyone will enjoy the banquet tomorrow.",
            futureSinhala = "හෙට සියලු දෙනාම සාදයේ කෑම සතුටින් භුක්ති විඳිනු ඇත.",
            verbTransformation = "praised → praises → will enjoy"
          )
        )
      ),

      // ==========================================
      // Category 3: පාසල සහ පන්තිකාමර ක්‍රියාකාරකම් (School & Classroom) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 3,
        titleSinhala = "කාණ්ඩය 03: පාසල සහ පන්තිකාමරය",
        titleEnglish = "School & Classroom Activities",
        icon = "🏫",
        description = "පාසලට පැමිණීම, ගුරුවරුන්ට ආචාර කිරීම, සටහන් ගැනීම සහ විභාග පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t3_s1",
            baseActionSinhala = "පාසලට ළඟාවීම",
            pastEnglish = "Students reached school before the bell rang.",
            pastSinhala = "ඝණ්ටාරය නාද වීමට පෙර සිසුහු පාසලට ළඟා වූහ.",
            presentEnglish = "Students reach school before 7:30 AM.",
            presentSinhala = "සිසුහු උදෑසන 7:30 ට පෙර පාසලට ළඟා වෙති.",
            futureEnglish = "Students will reach school early tomorrow.",
            futureSinhala = "සිසුහු හෙට වේලාසනින් පාසලට ළඟා වනු ඇත.",
            verbTransformation = "reached → reach → will reach"
          ),
          TenseSentenceItem(
            id = "t3_s2",
            baseActionSinhala = "ජාතික ගීය ගායනා කිරීම",
            pastEnglish = "We sang the national anthem proudly.",
            pastSinhala = "අපි මහත් අභිමානයෙන් ජාතික ගීය ගායනා කළෙමු.",
            presentEnglish = "We sing the national anthem at the assembly.",
            presentSinhala = "අපි උදෑසන රැස්වීමේදී ජාතික ගීය ගායනා කරමු.",
            futureEnglish = "We will sing the anthem together tomorrow.",
            futureSinhala = "අපි හෙට එකට ජාතික ගීය ගායනා කරන්නෙමු.",
            verbTransformation = "sang → sing → will sing"
          ),
          TenseSentenceItem(
            id = "t3_s3",
            baseActionSinhala = "ගුරුතුමාට ආචාර කිරීම",
            pastEnglish = "Children stood up and greeted the teacher.",
            pastSinhala = "දරුවෝ නැගිට ගුරුතුමාට ආචාර කළෝය.",
            presentEnglish = "Children stand up and greet the teacher politely.",
            presentSinhala = "දරුවෝ නැගිට ගුරුතුමාට විනීතව ආචාර කරති.",
            futureEnglish = "Children will greet the principal respectfully.",
            futureSinhala = "දරුවෝ විදුහල්පතිතුමාට ගෞරවයෙන් ආචාර කරනු ඇත.",
            verbTransformation = "greeted → greet → will greet"
          ),
          TenseSentenceItem(
            id = "t3_s4",
            baseActionSinhala = "පැමිණීම සටහන් කිරීම",
            pastEnglish = "The monitor marked attendance yesterday.",
            pastSinhala = "පන්ති නායකයා ඊයේ පැමිණීම සටහන් කළේය.",
            presentEnglish = "The teacher marks attendance in the register.",
            presentSinhala = "ගුරුතුමා ලේඛනයේ පැමිණීම සටහන් කරයි.",
            futureEnglish = "The teacher will mark attendance at 8:00 AM.",
            futureSinhala = "ගුරුතුමා උදෑසන 8:00 ට පැමිණීම සටහන් කරනු ඇත.",
            verbTransformation = "marked → marks → will mark"
          ),
          TenseSentenceItem(
            id = "t3_s5",
            baseActionSinhala = "කළු ලෑල්ල පිසදැමීම",
            pastEnglish = "Kasun cleaned the blackboard with a duster.",
            pastSinhala = "කසුන් ඩස්ටරයෙන් කළු ලෑල්ල පිසදැමුවේය.",
            presentEnglish = "Kasun cleans the board after each period.",
            presentSinhala = "කසුන් සෑම කාලච්ඡේදයකටම පසු ලෑල්ල පිසදමයි.",
            futureEnglish = "Kasun will clean the whiteboard for the next lesson.",
            futureSinhala = "කසුන් ඊළඟ පාඩම සඳහා සුදු ලෑල්ල පිසදමනු ඇත.",
            verbTransformation = "cleaned → cleans → will clean"
          ),
          TenseSentenceItem(
            id = "t3_s6",
            baseActionSinhala = "ගණිත ගැටලු විසඳීම",
            pastEnglish = "She solved difficult algebraic problems.",
            pastSinhala = "ඇය අමාරු වීජ ගණිත ගැටලු විසඳුවාය.",
            presentEnglish = "She solves geometry sums accurately.",
            presentSinhala = "ඇය ජ්‍යාමිතික ගැටලු නිවැරදිව විසඳයි.",
            futureEnglish = "She will solve tomorrow's test questions.",
            futureSinhala = "ඇය හෙට පරීක්ෂණයේ ප්‍රශ්න විසඳනු ඇත.",
            verbTransformation = "solved → solves → will solve"
          ),
          TenseSentenceItem(
            id = "t3_s7",
            baseActionSinhala = "ප්‍රශ්න ඇසීම",
            pastEnglish = "The student raised his hand and asked a question.",
            pastSinhala = "ශිෂ්‍යයා අත ඔසවා ප්‍රශ්නයක් ඇසුවේය.",
            presentEnglish = "Curious students ask insightful questions.",
            presentSinhala = "උනන්දු සහගත සිසුහු වැදගත් ප්‍රශ්න අසති.",
            futureEnglish = "The student will ask doubts after the lecture.",
            futureSinhala = "දේශනයෙන් පසු ශිෂ්‍යයා තම ගැටලු අසනු ඇත.",
            verbTransformation = "asked → ask → will ask"
          ),
          TenseSentenceItem(
            id = "t3_s8",
            baseActionSinhala = "සටහන් පොතේ ලිවීම",
            pastEnglish = "We took down notes from the whiteboard.",
            pastSinhala = "අපි සුදු ලෑල්ලෙන් සටහන් ලියා ගත්තෙමු.",
            presentEnglish = "We take notes neatly in science class.",
            presentSinhala = "අපි විද්‍යා පන්තියේදී පිළිවෙළට සටහන් ලියමු.",
            futureEnglish = "We will copy the summary into our books.",
            futureSinhala = "අපි අපේ පොත්වලට සාරාංශය පිටපත් කරගන්නෙමු.",
            verbTransformation = "took → take → will copy"
          ),
          TenseSentenceItem(
            id = "t3_s9",
            baseActionSinhala = "පොත් පිටු පෙරළීම",
            pastEnglish = "He opened his English textbook to page 45.",
            pastSinhala = "ඔහු ඔහුගේ ඉංග්‍රීසි පෙළපොතේ 45 වන පිටුව පෙරළුවේය.",
            presentEnglish = "He opens his history book during the lesson.",
            presentSinhala = "ඔහු පාඩම අතරතුර ඉතිහාස පොත පෙරළයි.",
            futureEnglish = "He will open the atlas for geography.",
            futureSinhala = "ඔහු භූගෝල විද්‍යාව සඳහා සිතියම් පොත පෙරළනු ඇත.",
            verbTransformation = "opened → opens → will open"
          ),
          TenseSentenceItem(
            id = "t3_s10",
            baseActionSinhala = "ඝණ්ටාරය නාදවීම",
            pastEnglish = "The interval bell rang at 10:30 AM.",
            pastSinhala = "විවේක ඝණ්ටාරය උදෑසන 10:30 ට නාද විය.",
            presentEnglish = "The bell rings precisely on time.",
            presentSinhala = "ඝණ්ටාරය නියමිත වේලාවට නාද වේ.",
            futureEnglish = "The final bell will ring in ten minutes.",
            futureSinhala = "අවසාන ඝණ්ටාරය තව මිනිත්තු දහයකින් නාද වනු ඇත.",
            verbTransformation = "rang → rings → will ring"
          ),
          TenseSentenceItem(
            id = "t3_s11",
            baseActionSinhala = "විද්‍යාගාරයේ අත්හදා බැලීම්",
            pastEnglish = "We conducted an experiment in the chemistry lab.",
            pastSinhala = "අපි රසායන විද්‍යාගාරයේ පරීක්ෂණයක් කළෙමු.",
            presentEnglish = "We conduct practicals under teacher's supervision.",
            presentSinhala = "අපි ගුරු උපදෙස් යටතේ ප්‍රායෝගික පරීක්ෂණ සිදු කරමු.",
            futureEnglish = "We will test the acid-base reactions tomorrow.",
            futureSinhala = "අපි හෙට අම්ල-භෂ්ම ප්‍රතික්‍රියා පරීක්ෂා කරන්නෙමු.",
            verbTransformation = "conducted → conduct → will test"
          ),
          TenseSentenceItem(
            id = "t3_s12",
            baseActionSinhala = "පන්ති කාමරය අතුගෑම",
            pastEnglish = "Students swept the classroom before leaving.",
            pastSinhala = "සිසුහු පිටත්ව යාමට පෙර පන්ති කාමරය අතුගෑහ.",
            presentEnglish = "Duty group sweeps the floor every afternoon.",
            presentSinhala = "රාජකාරි කණ්ඩායම සෑම සවසකම පන්ති කාමරය අතුගායි.",
            futureEnglish = "They will sweep and arrange desks properly.",
            futureSinhala = "ඔවුහු අතුගා ඩෙස්ක් පුටු පිළිවෙළට සකස් කරනු ඇත.",
            verbTransformation = "swept → sweeps → will sweep"
          ),
          TenseSentenceItem(
            id = "t3_s13",
            baseActionSinhala = "ගෙදර වැඩ පරීක්ෂා කිරීම",
            pastEnglish = "The teacher corrected our homework yesterday.",
            pastSinhala = "ගුරුතුමිය ඊයේ අපේ ගෙදර වැඩ පරීක්ෂා කළාය.",
            presentEnglish = "The teacher corrects assignments diligently.",
            presentSinhala = "ගුරුතුමිය පැවරුම් ඉතා උනන්දුවෙන් පරීක්ෂා කරයි.",
            futureEnglish = "The teacher will check our essays next Monday.",
            futureSinhala = "ගුරුතුමිය ලබන සඳුදා අපේ රචනා පරීක්ෂා කරනු ඇත.",
            verbTransformation = "corrected → corrects → will check"
          ),
          TenseSentenceItem(
            id = "t3_s14",
            baseActionSinhala = "වාර විභාගයට පෙනී සිටීම",
            pastEnglish = "I sat for the term exam last month.",
            pastSinhala = "මම ගිය මස වාර විභාගයට පෙනී සිටියෙමි.",
            presentEnglish = "I sit for periodic class tests.",
            presentSinhala = "මම වරින් වර පන්ති පරීක්ෂණවලට පෙනී සිටිමි.",
            futureEnglish = "I will sit for the final examination in December.",
            futureSinhala = "මම දෙසැම්බර් මස අවසාන විභාගයට පෙනී සිටින්නෙමි.",
            verbTransformation = "sat → sit → will sit"
          ),
          TenseSentenceItem(
            id = "t3_s15",
            baseActionSinhala = "විභාගයෙන් ඉහළ ලකුණු ලබාගැනීම",
            pastEnglish = "Kamal scored 95 marks in English.",
            pastSinhala = "කමල් ඉංග්‍රීසි විෂයට ලකුණු 95 ක් ලබාගත්තේය.",
            presentEnglish = "Kamal scores excellent grades consistently.",
            presentSinhala = "කමල් නිරතුරුවම විශිෂ්ට සාමාර්ථ ලබා ගනී.",
            futureEnglish = "Kamal will score top marks this time too.",
            futureSinhala = "කමල් මෙවරත් ඉහළම ලකුණු ලබාගනු ඇත.",
            verbTransformation = "scored → scores → will score"
          ),
          TenseSentenceItem(
            id = "t3_s16",
            baseActionSinhala = "ප්‍රශ්න පත්‍රයට පිළිතුරු ලිවීම",
            pastEnglish = "She answered all twenty questions.",
            pastSinhala = "ඇය ප්‍රශ්න විස්සටම පිළිතුරු ලිව්වාය.",
            presentEnglish = "She answers each question thoughtfully.",
            presentSinhala = "ඇය කල්පනාකාරීව සෑම ප්‍රශ්නයකටම පිළිතුරු ලියයි.",
            futureEnglish = "She will answer the essay question first.",
            futureSinhala = "ඇය මුලින්ම රචනා ප්‍රශ්නයට පිළිතුරු ලියනු ඇත.",
            verbTransformation = "answered → answers → will answer"
          ),
          TenseSentenceItem(
            id = "t3_s17",
            baseActionSinhala = "පැන්සල උල් කිරීම",
            pastEnglish = "The boy sharpened his pencil with a sharpener.",
            pastSinhala = "පිරිමි ළමයා උල් කටුවකින් ඔහුගේ පැන්සල උල් කළේය.",
            presentEnglish = "The boy sharpens his pencils before drawing.",
            presentSinhala = "පිරිමි ළමයා චිත්‍ර ඇඳීමට පෙර පැන්සල් උල් කරයි.",
            futureEnglish = "The boy will sharpen color pencils for art class.",
            futureSinhala = "පිරිමි ළමයා චිත්‍ර පන්තිය සඳහා පාට පැන්සල් උල් කරනු ඇත.",
            verbTransformation = "sharpened → sharpens → will sharpen"
          ),
          TenseSentenceItem(
            id = "t3_s18",
            baseActionSinhala = "කණ්ඩායම් වැඩවල නිරතවීම",
            pastEnglish = "We worked in groups on the history project.",
            pastSinhala = "අපි ඉතිහාස ව්‍යාපෘතිය සඳහා කණ්ඩායම් වශයෙන් වැඩ කළෙමු.",
            presentEnglish = "We work cooperatively in team assignments.",
            presentSinhala = "අපි කණ්ඩායම් පැවරුම්වලදී සහයෝගයෙන් වැඩ කරමු.",
            futureEnglish = "We will present our group findings tomorrow.",
            futureSinhala = "අපි අපේ කණ්ඩායමේ සොයාගැනීම් හෙට ඉදිරිපත් කරන්නෙමු.",
            verbTransformation = "worked → work → will present"
          ),
          TenseSentenceItem(
            id = "t3_s19",
            baseActionSinhala = "පන්ති කාමරයේ නිශ්ශබ්දව සිටීම",
            pastEnglish = "Students kept quiet when principal entered.",
            pastSinhala = "විදුහල්පතිතුමා ඇතුළු වූ විට සිසුහු නිශ්ශබ්ද වූහ.",
            presentEnglish = "Students keep quiet during study hours.",
            presentSinhala = "පාඩම් වේලාවන්හිදී සිසුහු නිශ්ශබ්දව සිටිති.",
            futureEnglish = "Students will keep silence in the examination hall.",
            futureSinhala = "විභාග ශාලාවේදී සිසුහු නිශ්ශබ්දතාව රකිනු ඇත.",
            verbTransformation = "kept → keep → will keep"
          ),
          TenseSentenceItem(
            id = "t3_s20",
            baseActionSinhala = "පාසල් පුස්තකාලය වෙත යාම",
            pastEnglish = "I borrowed a science fiction book yesterday.",
            pastSinhala = "මම ඊයේ විද්‍යා ප්‍රබන්ධ පොතක් ණයට ගත්තෙමි.",
            presentEnglish = "I borrow storybooks from the library.",
            presentSinhala = "මම පුස්තකාලයෙන් කතන්දර පොත් ණයට ගනිමි.",
            futureEnglish = "I will return the encyclopedia on Friday.",
            futureSinhala = "මම සිකුරාදා විශ්වකෝෂය ආපසු භාර දෙන්නෙමි.",
            verbTransformation = "borrowed → borrow → will return"
          ),
          TenseSentenceItem(
            id = "t3_s21",
            baseActionSinhala = "පාසල් ප්‍රජාතන්ත්‍රවාදී නායකත්වය",
            pastEnglish = "They elected Nimal as the head prefect.",
            pastSinhala = "ඔවුහු නිමල්ව ප්‍රධාන ශිෂ්‍ය නායකයා ලෙස තෝරා ගත්හ.",
            presentEnglish = "Prefects maintain school discipline.",
            presentSinhala = "ශිෂ්‍ය නායකයෝ පාසල් විනය පවත්වා ගනිති.",
            futureEnglish = "The school will appoint new prefects next month.",
            futureSinhala = "ලබන මස පාසල නව ශිෂ්‍ය නායකයින් පත් කරනු ඇත.",
            verbTransformation = "elected → maintain → will appoint"
          ),
          TenseSentenceItem(
            id = "t3_s22",
            baseActionSinhala = "ශබ්ද නඟා කියවීම",
            pastEnglish = "Ruwani read the passage loudly and clearly.",
            pastSinhala = "රුවන්ති එම ඡේදය ශබ්ද නඟා පැහැදිලිව කියෙව්වාය.",
            presentEnglish = "Ruwani reads English dialogues with good pronunciation.",
            presentSinhala = "රුවන්ති හොඳ උච්චාරණයෙන් ඉංග්‍රීසි දෙබස් කියවයි.",
            futureEnglish = "Ruwani will read the welcome speech.",
            futureSinhala = "රුවන්ති පිළිගැනීමේ කතාව කියවනු ඇත.",
            verbTransformation = "read (past) → reads → will read"
          ),
          TenseSentenceItem(
            id = "t3_s23",
            baseActionSinhala = "අකුරු ලස්සනට ලිවීම",
            pastEnglish = "He wrote his essay with neat handwriting.",
            pastSinhala = "ඔහු ඔහුගේ රචනය ලස්සන අත්අකුරින් ලිව්වේය.",
            presentEnglish = "He writes cursive letters gracefully.",
            presentSinhala = "ඔහු අලංකාර ලෙස අකුරු ලියයි.",
            futureEnglish = "He will practice handwriting daily.",
            futureSinhala = "ඔහු දිනපතා අත්අකුරු ලිවීම පුහුණු වනු ඇත.",
            verbTransformation = "wrote → writes → will practice"
          ),
          TenseSentenceItem(
            id = "t3_s24",
            baseActionSinhala = "පරිගණක විද්‍යාගාරයේ වැඩ",
            pastEnglish = "We typed our coding program in the lab.",
            pastSinhala = "අපි පරිගණක විද්‍යාගාරයේ අපේ කේත වැඩසටහන ටයිප් කළෙමු.",
            presentEnglish = "We learn scratch programming on Thursdays.",
            presentSinhala = "අපි බ්‍රහස්පතින්දා දිනවල Scratch ක්‍රමලේඛනය ඉගෙන ගනිමු.",
            futureEnglish = "We will build a simple school website next term.",
            futureSinhala = "අපි ලබන වාරයේ සරල පාසල් වෙබ් අඩවියක් නිර්මාණය කරන්නෙමු.",
            verbTransformation = "typed → learn → will build"
          ),
          TenseSentenceItem(
            id = "t3_s25",
            baseActionSinhala = "පාසල් ක්‍රීඩා උළෙල",
            pastEnglish = "Gamunu house won the championship trophy.",
            pastSinhala = "ගැමුණු නිවාසය ශූරතා කුසලානය දිනාගත්තේය.",
            presentEnglish = "Athletes train vigorously for sports meet.",
            presentSinhala = "ක්‍රීඩකයෝ ක්‍රීඩා උළෙල වෙනුවෙන් උනන්දුවෙන් පුහුණු වෙති.",
            futureEnglish = "Our school will celebrate annual sports meet in March.",
            futureSinhala = "අපේ පාසල මාර්තු මාසයේ වාර්ෂික ක්‍රීඩා උළෙල පවත්වනු ඇත.",
            verbTransformation = "won → train → will celebrate"
          ),
          TenseSentenceItem(
            id = "t3_s26",
            baseActionSinhala = "පැසසුම් සහ ත්‍යාග ලබාගැනීම",
            pastEnglish = "Amali received the first prize in English speech.",
            pastSinhala = "අමාලි ඉංග්‍රීසි කථිකත්වයෙන් පළමු ත්‍යාගය ලබා ගත්තාය.",
            presentEnglish = "She receives awards for high academic merit.",
            presentSinhala = "ඇය ඉහළ අධ්‍යාපනික කුසලතා සඳහා සම්මාන ලබයි.",
            futureEnglish = "She will receive the gold medal at prize day.",
            futureSinhala = "ත්‍යාග ප්‍රදානෝත්සවයේදී ඇය රන් පදක්කම ලබාගනු ඇත.",
            verbTransformation = "received → receives → will receive"
          ),
          TenseSentenceItem(
            id = "t3_s27",
            baseActionSinhala = "පාසල් ගීතය ගායනා කිරීම",
            pastEnglish = "The choir sang the school song melodiously.",
            pastSinhala = "ගායක කණ්ඩායම පාසල් ගීතය මිහිරි ලෙස ගැයූහ.",
            presentEnglish = "Every student knows the school anthem by heart.",
            presentSinhala = "සෑම සිසුවෙක්ම පාසල් ගීතය කටපාඩමින් දනිති.",
            futureEnglish = "The choir will perform at the golden jubilee.",
            futureSinhala = "සුවර්ණ ජයන්තියේදී ගායක කණ්ඩායම ගීත ගායනා කරනු ඇත.",
            verbTransformation = "sang → knows → will perform"
          ),
          TenseSentenceItem(
            id = "t3_s28",
            baseActionSinhala = "ඩෙස්ක් පුටු පිළිවෙළට තැබීම",
            pastEnglish = "We arranged the desks in straight rows.",
            pastSinhala = "අපි ඩෙස්ක් පුටු කෙළින් පේළිවලට පිළියෙල කළෙමු.",
            presentEnglish = "We keep our classroom organized and tidy.",
            presentSinhala = "අපි අපේ පන්ති කාමරය පිළිවෙළට හා පිරිසිදුව තබා ගනිමු.",
            futureEnglish = "We will decorate the classroom for celebration.",
            futureSinhala = "අපි උත්සවය සඳහා පන්ති කාමරය අලංකාර කරන්නෙමු.",
            verbTransformation = "arranged → keep → will decorate"
          ),
          TenseSentenceItem(
            id = "t3_s29",
            baseActionSinhala = "අධ්‍යාපනික චාරිකා",
            pastEnglish = "Our class visited the National Museum in Colombo.",
            pastSinhala = "අපේ පන්තිය කොළඹ ජාතික කෞතුකාගාරය නැරඹුවේය.",
            presentEnglish = "Field trips broaden students' practical knowledge.",
            presentSinhala = "ක්ෂේත්‍ර චාරිකා මගින් සිසුන්ගේ ප්‍රායෝගික දැනුම පුළුල් කරයි.",
            futureEnglish = "We will explore the planetarium next Friday.",
            futureSinhala = "අපි ලබන සිකුරාදා ග්‍රහලෝකාගාරය ගවේෂණය කරන්නෙමු.",
            verbTransformation = "visited → broaden → will explore"
          ),
          TenseSentenceItem(
            id = "t3_s30",
            baseActionSinhala = "පාසල නිමවී නිවස බලා යාම",
            pastEnglish = "School dispersed at 1:30 PM yesterday.",
            pastSinhala = "ඊයේ පාසල දවල් 1:30 ට නිම විය.",
            presentEnglish = "Students go home safely in the afternoon.",
            presentSinhala = "සිසුහු සවස් කාලයේ ආරක්ෂිතව නිවෙස් බලා යති.",
            futureEnglish = "The gates will open when classes finish.",
            futureSinhala = "පන්ති අවසන් වූ විට පාසල් දොරටු විවෘත වනු ඇත.",
            verbTransformation = "dispersed → go → will open"
          )
        )
      ),

      // ==========================================
      // Category 4: පොත් කියවීම, ලිවීම සහ අධ්‍යයනය (Reading & Writing) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 4,
        titleSinhala = "කාණ්ඩය 04: කියවීම, ලිවීම සහ පාඩම් කිරීම",
        titleEnglish = "Reading, Writing & Self-Study",
        icon = "📖",
        description = "පොත් කියවීම, රචනා ලිවීම, ව්‍යාකරණ හැදෑරීම සහ විභාග පුනරීක්ෂණය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t4_s1",
            baseActionSinhala = "නවකතාවක් කියවීම",
            pastEnglish = "I read an exciting adventure novel last weekend.",
            pastSinhala = "මම පසුගිය සති අන්තයේ උද්යෝගිමත් වික්‍රමාන්විත නවකතාවක් කියෙව්වෙමි.",
            presentEnglish = "I read interesting books in my free time.",
            presentSinhala = "මම මගේ විවේක කාලයේදී රසවත් පොත් කියවමි.",
            futureEnglish = "I will read historical fiction next month.",
            futureSinhala = "මම ලබන මස ඓතිහාසික ප්‍රබන්ධයක් කියවන්නෙමි.",
            verbTransformation = "read (past) → read → will read"
          ),
          TenseSentenceItem(
            id = "t4_s2",
            baseActionSinhala = "කවියක් රචනා කිරීම",
            pastEnglish = "She wrote a beautiful poem about mother nature.",
            pastSinhala = "ඇය ස්වභාවධර්ම මෑණියන් ගැන ලස්සන කවියක් ලිව්වාය.",
            presentEnglish = "She writes poems for the school magazine.",
            presentSinhala = "ඇය පාසල් සඟරාව සඳහා කවි ලියයි.",
            futureEnglish = "She will compose a new song for the festival.",
            futureSinhala = "ඇය උත්සවය සඳහා නව ගීතයක් නිර්මාණය කරනු ඇත.",
            verbTransformation = "wrote → writes → will compose"
          ),
          TenseSentenceItem(
            id = "t4_s3",
            baseActionSinhala = "ශබ්දකෝෂය පරීක්ෂා කිරීම",
            pastEnglish = "He looked up the difficult word in the dictionary.",
            pastSinhala = "ඔහු ශබ්දකෝෂයෙන් එම අසීරු වචනය බැලුවේය.",
            presentEnglish = "He checks word meanings and pronunciation.",
            presentSinhala = "ඔහු වචනවල අර්ථය සහ උච්චාරණය පරීක්ෂා කරයි.",
            futureEnglish = "He will consult the digital dictionary whenever stuck.",
            futureSinhala = "ගැටලුවක් මතු වූ විට ඔහු ඩිජිටල් ශබ්දකෝෂය පරීක්ෂා කරනු ඇත.",
            verbTransformation = "looked up → checks → will consult"
          ),
          TenseSentenceItem(
            id = "t4_s4",
            baseActionSinhala = "විභාග පාඩම් නැවත මතක් කිරීම",
            pastEnglish = "We revised three history chapters yesterday.",
            pastSinhala = "අපි ඊයේ ඉතිහාස පරිච්ඡේද තුනක් පුනරීක්ෂණය කළෙමු.",
            presentEnglish = "We revise short notes before sleep.",
            presentSinhala = "අපි නිදාගැනීමට පෙර කෙටි සටහන් නැවත මතක් කරමු.",
            futureEnglish = "We will revise science past papers on Saturday.",
            futureSinhala = "අපි සෙනසුරාදා විද්‍යා පසුගිය විභාග ප්‍රශ්න පත්‍ර පුනරීක්ෂණය කරන්නෙමු.",
            verbTransformation = "revised → revise → will revise"
          ),
          TenseSentenceItem(
            id = "t4_s5",
            baseActionSinhala = "ලිපියක් ලිවීම",
            pastEnglish = "I sent a formal letter to the director.",
            pastSinhala = "මම අධ්‍යක්ෂකතුමාට නිල ලිපියක් යැව්වෙමි.",
            presentEnglish = "I write friendly letters to my pen pal.",
            presentSinhala = "මම මගේ පෑන මිතුරාට සුහද ලිපි ලියමි.",
            futureEnglish = "I will write an official email tomorrow.",
            futureSinhala = "මම හෙට නිල ඊමේල් පණිවිඩයක් ලියන්නෙමි.",
            verbTransformation = "sent → write → will write"
          ),
          TenseSentenceItem(
            id = "t4_s6",
            baseActionSinhala = "වචන මාලාව වැඩි කරගැනීම",
            pastEnglish = "Students memorized ten new English vocabulary words.",
            pastSinhala = "සිසුහු නව ඉංග්‍රීසි වචන දහයක් මතක තබා ගත්හ.",
            presentEnglish = "Students learn idioms and phrases daily.",
            presentSinhala = "සිසුහු දිනපතා රූඪි සහ වාක්‍යාංශ ඉගෙන ගනිති.",
            futureEnglish = "Students will master 500 words by end of this year.",
            futureSinhala = "මෙම වසර අවසන් වන විට සිසුහු වචන 500ක් ප්‍රගුණ කරනු ඇත.",
            verbTransformation = "memorized → learn → will master"
          ),
          TenseSentenceItem(
            id = "t4_s7",
            baseActionSinhala = "වැදගත් කරුණු යටින් ඉරි ඇඳීම",
            pastEnglish = "She highlighted key definitions with a marker.",
            pastSinhala = "ඇය මාකර් පෑනකින් ප්‍රධාන නිර්වචන යටින් ඉරි ඇන්දාය.",
            presentEnglish = "She underlines important dates in history.",
            presentSinhala = "ඇය ඉතිහාසයේ වැදගත් දිනයන් යටින් ඉරි අඳියි.",
            futureEnglish = "She will highlight formula formulas in physics.",
            futureSinhala = "ඇය භෞතික විද්‍යාවේ සූත්‍ර ඉස්මතු කර දක්වනු ඇත.",
            verbTransformation = "highlighted → underlines → will highlight"
          ),
          TenseSentenceItem(
            id = "t4_s8",
            baseActionSinhala = "පසුගිය ප්‍රශ්න පත්‍ර කිරීම",
            pastEnglish = "I completed the 2022 O/L English paper.",
            pastSinhala = "මම 2022 සා/පෙළ ඉංග්‍රීසි ප්‍රශ්න පත්‍රය සම්පූර්ණ කළෙමි.",
            presentEnglish = "I practice past exam questions every evening.",
            presentSinhala = "මම සෑම සවසකම පසුගිය විභාග ප්‍රශ්න පුහුණු වෙමි.",
            futureEnglish = "I will solve model papers under timed conditions.",
            futureSinhala = "මම වේලාවට අනුකූලව ආදර්ශ ප්‍රශ්න පත්‍ර විසඳන්නෙමි.",
            verbTransformation = "completed → practice → will solve"
          ),
          TenseSentenceItem(
            id = "t4_s9",
            baseActionSinhala = "කථිකත්වය පුහුණු වීම",
            pastEnglish = "He practiced speech delivery in front of mirror.",
            pastSinhala = "ඔහු කණ්ණාඩිය ඉදිරිපිට කථනය බෙදාහැරීම පුහුණු විය.",
            presentEnglish = "He speaks English fluently with his peers.",
            presentSinhala = "ඔහු මිතුරන් සමඟ චතුර ලෙස ඉංග්‍රීසි කතා කරයි.",
            futureEnglish = "He will address the school assembly with confidence.",
            futureSinhala = "ඔහු විශ්වාසයෙන් යුතුව පාසල් රැස්වීම අමතනු ඇත.",
            verbTransformation = "practiced → speaks → will address"
          ),
          TenseSentenceItem(
            id = "t4_s10",
            baseActionSinhala = "කෙටි සටහන් හැදීම",
            pastEnglish = "We made mind maps for the biology syllabus.",
            pastSinhala = "අපි ජීව විද්‍යා විෂය නිර්දේශය සඳහා මනෝ සිතියම් හැදුවෙමු.",
            presentEnglish = "We make concise flashcards for quick revision.",
            presentSinhala = "අපි ඉක්මන් පුනරීක්ෂණය සඳහා කෙටි කාඩ්පත් සාදමු.",
            futureEnglish = "We will summarize long chapters into one page.",
            futureSinhala = "අපි දිගු පරිච්ඡේද එක් පිටුවකට සාරාංශ කරන්නෙමු.",
            verbTransformation = "made → make → will summarize"
          ),
          TenseSentenceItem(
            id = "t4_s11",
            baseActionSinhala = "අවධානයෙන් පාඩම් කිරීම",
            pastEnglish = "I focused on my studies for three hours.",
            pastSinhala = "මම පැය තුනක් මගේ අධ්‍යයන කටයුතු කෙරෙහි අවධානය යොමු කළෙමි.",
            presentEnglish = "I study without phone distractions in my room.",
            presentSinhala = "මම මගේ කාමරයේ දුරකථන බාධාවලින් තොරව පාඩම් කරමි.",
            futureEnglish = "I will dedicate four hours daily for revision.",
            futureSinhala = "මම පුනරීක්ෂණ කටයුතු සඳහා දිනකට පැය හතරක් කැප කරන්නෙමි.",
            verbTransformation = "focused → study → will dedicate"
          ),
          TenseSentenceItem(
            id = "t4_s12",
            baseActionSinhala = "ව්‍යාකරණ වැරදි නිවැරදි කරගැනීම",
            pastEnglish = "The teacher corrected my tense errors in the essay.",
            pastSinhala = "ගුරුතුමිය රචනයේ තිබූ මගේ කාල රීති වැරදි නිවැරදි කළාය.",
            presentEnglish = "I double check subject-verb agreement in sentences.",
            presentSinhala = "මම වාක්‍යවල උක්ත-ආඛ්‍යාත ගැළපීම නැවත පරීක්ෂා කරමි.",
            futureEnglish = "I will avoid silly spelling mistakes in final exam.",
            futureSinhala = "අවසාන විභාගයේදී මම සුළු අක්ෂර වින්‍යාස වැරදි මඟහරවා ගන්නෙමි.",
            verbTransformation = "corrected → check → will avoid"
          ),
          TenseSentenceItem(
            id = "t4_s13",
            baseActionSinhala = "කතන්දරයක් ලිවීම",
            pastEnglish = "Nimal wrote a mystery story about a lost treasure.",
            pastSinhala = "නිමල් නැතිවූ නිධානයක් ගැන අද්භූත කතාවක් ලිව්වේය.",
            presentEnglish = "Nimal creates imaginative fiction characters.",
            presentSinhala = "නිමල් මනඃකල්පිත ප්‍රබන්ධ චරිත නිර්මාණය කරයි.",
            futureEnglish = "Nimal will publish his first short story collection.",
            futureSinhala = "නිමල් ඔහුගේ පළමු කෙටිකතා සංග්‍රහය ප්‍රකාශයට පත් කරනු ඇත.",
            verbTransformation = "wrote → creates → will publish"
          ),
          TenseSentenceItem(
            id = "t4_s14",
            baseActionSinhala = "සිතියම් ඇඳීම",
            pastEnglish = "We drew Sri Lankan river basins accurately.",
            pastSinhala = "අපි ශ්‍රී ලංකාවේ ගංගා ද්‍රෝණි නිවැරදිව ඇන්දෙමු.",
            presentEnglish = "We mark historic kingdoms on ancient maps.",
            presentSinhala = "අපි පුරාණ සිතියම්වල ඓතිහාසික රාජධානි සලකුණු කරමු.",
            futureEnglish = "We will sketch world climate zones next week.",
            futureSinhala = "අපි ලබන සතියේ ලෝක දේශගුණික කලාප සටහන් කරන්නෙමු.",
            verbTransformation = "drew → mark → will sketch"
          ),
          TenseSentenceItem(
            id = "t4_s15",
            baseActionSinhala = "පොත් රාක්කය පිළිවෙළට තැබීම",
            pastEnglish = "She arranged all books by subject on the shelf.",
            pastSinhala = "ඇය පොත් රාක්කයේ සියලුම පොත් විෂය අනුව සකස් කළාය.",
            presentEnglish = "She keeps her study table clean and organized.",
            presentSinhala = "ඇය ඇගේ පාඩම් මේසය පිරිසිදුව හා පිළිවෙළට තබා ගනියි.",
            futureEnglish = "She will reorganize reference encyclopedias.",
            futureSinhala = "ඇය විමර්ශන විශ්වකෝෂ නැවත පිළිවෙළට සකස් කරනු ඇත.",
            verbTransformation = "arranged → keeps → will reorganize"
          ),
          TenseSentenceItem(
            id = "t4_s16",
            baseActionSinhala = "ප්‍රශ්න විචාරාත්මකව විමසීම",
            pastEnglish = "Students analyzed the cause of water pollution.",
            pastSinhala = "සිසුහු ජල දූෂණයට හේතුව විචාරාත්මකව විශ්ලේෂණය කළහ.",
            presentEnglish = "Students evaluate ethical solutions for environmental crisis.",
            presentSinhala = "සිසුහු පාරිසරික අර්බුද සඳහා සදාචාරාත්මක විසඳුම් ඇගයීමට ලක් කරති.",
            futureEnglish = "Students will propose green energy alternatives.",
            futureSinhala = "සිසුහු හරිත බලශක්ති විකල්ප යෝජනා කරනු ඇත.",
            verbTransformation = "analyzed → evaluate → will propose"
          ),
          TenseSentenceItem(
            id = "t4_s17",
            baseActionSinhala = "විභාග ප්‍රතිඵල ලැබීම",
            pastEnglish = "I received nine A grades in G.C.E. O/L.",
            pastSinhala = "මම අ.පො.ස. සා/පෙළ විභාගයෙන් 'ඒ' සාමාර්ථ නවයක් ලබාගත්තෙමි.",
            presentEnglish = "Hardworking students gain exceptional qualifications.",
            presentSinhala = "වෙහෙස මහන්සි වී වැඩ කරන සිසුහු සුවිශේෂී සුදුසුකම් ලබා ගනිති.",
            futureEnglish = "Diligent preparation will yield outstanding academic success.",
            futureSinhala = "නොපසුබට සූදානම විශිෂ්ට අධ්‍යාපනික සාර්ථකත්වයක් අත්කර දෙනු ඇත.",
            verbTransformation = "received → gain → will yield"
          ),
          TenseSentenceItem(
            id = "t4_s18",
            baseActionSinhala = "පාඩම් කණ්ඩායම් සාකච්ඡා",
            pastEnglish = "We debated grammar rules in our study circle.",
            pastSinhala = "අපි අපේ පාඩම් කවයේදී ව්‍යාකරණ රීති ගැන වාද කළෙමු.",
            presentEnglish = "We share helpful exam tips with each other.",
            presentSinhala = "අපි එකිනෙකා සමඟ ප්‍රයෝජනවත් විභාග උපදෙස් බෙදා ගනිමු.",
            futureEnglish = "We will meet online to solve physics problems.",
            futureSinhala = "භෞතික විද්‍යා ගැටලු විසඳීම සඳහා අපි අන්තර්ජාලය ඔස්සේ හමුවන්නෙමු.",
            verbTransformation = "debated → share → will meet"
          ),
          TenseSentenceItem(
            id = "t4_s19",
            baseActionSinhala = "දිනපොතේ සටහන් තැබීම",
            pastEnglish = "I recorded my daily achievements in personal diary.",
            pastSinhala = "මම මගේ දෛනික ජයග්‍රහණ පෞද්ගලික දිනපොතේ සටහන් කළෙමි.",
            presentEnglish = "I write reflective thoughts before sleeping.",
            presentSinhala = "මම නිදා ගැනීමට පෙර මගේ සිතුවිලි සටහන් කරමි.",
            futureEnglish = "I will maintain this journaling habit lifelong.",
            futureSinhala = "මම ජීවිත කාලය පුරාම මෙම දිනපොත් ලිවීමේ පුරුද්ද පවත්වා ගන්නෙමි.",
            verbTransformation = "recorded → write → will maintain"
          ),
          TenseSentenceItem(
            id = "t4_s20",
            baseActionSinhala = "කථන හැකියාව වැඩිදියුණු කිරීම",
            pastEnglish = "The shy student overcame stage fear through practice.",
            pastSinhala = "ලැජ්ජාශීලී ශිෂ්‍යයා පුහුණුව තුළින් වේදිකා බිය ජය ගත්තේය.",
            presentEnglish = "He presents seminar topics with conviction.",
            presentSinhala = "ඔහු සම්මන්ත්‍රණ මාතෘකා දැඩි විශ්වාසයකින් ඉදිරිපත් කරයි.",
            futureEnglish = "He will become an inspiring public speaker.",
            futureSinhala = "ඔහු ආදර්ශවත් ප්‍රසිද්ධ කථිකයෙකු බවට පත්වනු ඇත.",
            verbTransformation = "overcame → presents → will become"
          ),
          TenseSentenceItem(
            id = "t4_s21",
            baseActionSinhala = "ගැටලු විමසා දැනගැනීම",
            pastEnglish = "I consulted the tutor regarding complex algebra.",
            pastSinhala = "සංකීර්ණ වීජ ගණිතය සම්බන්ධයෙන් මම ගුරුතුමාගෙන් උපදෙස් ලබාගත්තෙමි.",
            presentEnglish = "I clarify confusing topics promptly.",
            presentSinhala = "මම අපැහැදිලි මාතෘකා වහාම පැහැදිලි කර ගනිමි.",
            futureEnglish = "I will seek guidance whenever in doubt.",
            futureSinhala = "සැකයක් ඇති වූ ඕනෑම අවස්ථාවක මම මගපෙන්වීම පතන්නෙමි.",
            verbTransformation = "consulted → clarify → will seek"
          ),
          TenseSentenceItem(
            id = "t4_s22",
            baseActionSinhala = "විද්‍යාත්මක රචනා ලිවීම",
            pastEnglish = "She authored an article on solar energy benefits.",
            pastSinhala = "ඇය සූර්ය බලශක්ති ප්‍රතිලාභ පිළිබඳ ලිපියක් ලිව්වාය.",
            presentEnglish = "She writes informative essays on environmental conservation.",
            presentSinhala = "ඇය පරිසර සංරක්ෂණය පිළිබඳ තොරතුරු සපිරි රචනා ලියයි.",
            futureEnglish = "She will submit her paper to youth science symposium.",
            futureSinhala = "ඇය තරුණ විද්‍යා සම්මන්ත්‍රණයට තම පර්යේෂණ පත්‍රිකාව ඉදිරිපත් කරනු ඇත.",
            verbTransformation = "authored → writes → will submit"
          ),
          TenseSentenceItem(
            id = "t4_s23",
            baseActionSinhala = "කාලය කාර්යක්ෂමව පාලනය",
            pastEnglish = "I managed study breaks using the Pomodoro technique.",
            pastSinhala = "මම Pomodoro ක්‍රමය භාවිතයෙන් පාඩම් විවේක කාලය පාලනය කළෙමි.",
            presentEnglish = "I allocate fifty minutes for intensive study blocks.",
            presentSinhala = "මම දැඩි අධ්‍යයන කාලච්ඡේද සඳහා මිනිත්තු පනහක් වෙන් කරමි.",
            futureEnglish = "I will optimize daily timetable for better productivity.",
            futureSinhala = "වඩා හොඳ ඵලදායිතාවයක් සඳහා මම දෛනික කාලසටහන ප්‍රශස්ත කරන්නෙමි.",
            verbTransformation = "managed → allocate → will optimize"
          ),
          TenseSentenceItem(
            id = "t4_s24",
            baseActionSinhala = "ප්‍රහේලිකා විසඳීම",
            pastEnglish = "We solved challenging crossword puzzles in English.",
            pastSinhala = "අපි ඉංග්‍රීසි අභියෝගාත්මක හරස්පද ප්‍රහේලිකා විසඳුවෙමු.",
            presentEnglish = "Puzzles sharpen analytical cognitive thinking.",
            presentSinhala = "ප්‍රහේලිකා මගින් විශ්ලේෂණාත්මක ඥානාන්විත චින්තනය තියුණු කරයි.",
            futureEnglish = "We will participate in the national Scrabble championship.",
            futureSinhala = "අපි ජාතික Scrabble ශූරතාවලියට සහභාගී වන්නෙමු.",
            verbTransformation = "solved → sharpen → will participate"
          ),
          TenseSentenceItem(
            id = "t4_s25",
            baseActionSinhala = "කියවීම ජීවිතයට පුරුදු කරගැනීම",
            pastEnglish = "Books shaped my moral perspective on society.",
            pastSinhala = "පොත්පත් සමාජය පිළිබඳ මගේ සදාචාරාත්මක ආකල්පය හැඩගැස්වීය.",
            presentEnglish = "Reading opens limitless windows of human wisdom.",
            presentSinhala = "කියවීම මිනිස් ප්‍රඥාවේ අපරිමිත කවුළු විවර කරයි.",
            futureEnglish = "Books will empower our next generation with knowledge.",
            futureSinhala = "පොත්පත් අපගේ මීළඟ පරම්පරාව දැනුමෙන් සවිබල ගන්වනු ඇත.",
            verbTransformation = "shaped → opens → will empower"
          ),
          TenseSentenceItem(
            id = "t4_s26",
            baseActionSinhala = "අලුත් භාෂාවක් ඉගෙනීම",
            pastEnglish = "He learned French basics during holidays.",
            pastSinhala = "ඔහු නිවාඩු කාලයේදී මූලික ප්‍රංශ භාෂාව ඉගෙන ගත්තේය.",
            presentEnglish = "He practices speaking English and Tamil.",
            presentSinhala = "ඔහු ඉංග්‍රීසි සහ දෙමළ කතා කිරීම පුහුණු වෙයි.",
            futureEnglish = "He will master Japanese next year.",
            futureSinhala = "ඔහු ලබන වසරේ ජපන් භාෂාව ප්‍රගුණ කරනු ඇත.",
            verbTransformation = "learned → practices → will master"
          ),
          TenseSentenceItem(
            id = "t4_s27",
            baseActionSinhala = "විභාගයට පෙර සන්සුන්ව සිටීම",
            pastEnglish = "I took deep breaths and stayed calm before exam.",
            pastSinhala = "මම විභාගයට පෙර ගැඹුරු හුස්මක් ගෙන සන්සුන්ව සිටියෙමි.",
            presentEnglish = "I remain composed under intense academic pressure.",
            presentSinhala = "මම දැඩි අධ්‍යාපනික පීඩනය හමුවේ සන්සුන්ව සිටිමි.",
            futureEnglish = "I will write with clarity and full peace of mind.",
            futureSinhala = "මම පැහැදිලි බවින් හා පූර්ණ මනසේ සාමයෙන් විභාගය ලියන්නෙමි.",
            verbTransformation = "stayed → remain → will write"
          ),
          TenseSentenceItem(
            id = "t4_s28",
            baseActionSinhala = "අධ්‍යාපනික සම්මන්ත්‍රණවලට සහභාගීවීම",
            pastEnglish = "We attended the English seminar at town hall.",
            pastSinhala = "අපි නගර ශාලාවේ පැවති ඉංග්‍රීසි සම්මන්ත්‍රණයට සහභාගී වුණෙමු.",
            presentEnglish = "We listen attentively to expert educational instructors.",
            presentSinhala = "අපි ප්‍රවීණ අධ්‍යාපනික උපදේශකයින්ට ඉතා ඕනෑකමින් සවන් දෙමු.",
            futureEnglish = "We will attend the national student leadership forum.",
            futureSinhala = "අපි ජාතික ශිෂ්‍ය නායකත්ව සංසදයට සහභාගී වන්නෙමු.",
            verbTransformation = "attended → listen → will attend"
          ),
          TenseSentenceItem(
            id = "t4_s29",
            baseActionSinhala = "අමාරු කොටස් සරල කර ගැනීම",
            pastEnglish = "The teacher simplified tough grammar rules with examples.",
            pastSinhala = "ගුරුතුමා උදාහරණ මගින් අසීරු ව්‍යාකරණ නීති සරල කළේය.",
            presentEnglish = "Good teachers make learning enjoyable and engaging.",
            presentSinhala = "දක්ෂ ගුරුවරු ඉගෙනීම විනෝදජනක සහ ප්‍රියජනක කරති.",
            futureEnglish = "Innovative tools will transform student learning forever.",
            futureSinhala = "නව්‍ය මෙවලම් ශිෂ්‍ය ඉගෙනුම් ක්‍රියාවලිය සදහටම පරිවර්තනය කරනු ඇත.",
            verbTransformation = "simplified → make → will transform"
          ),
          TenseSentenceItem(
            id = "t4_s30",
            baseActionSinhala = "අධ්‍යාපනික අරමුණු සාක්ෂාත් කරගැනීම",
            pastEnglish = "I achieved all my term study targets.",
            pastSinhala = "මම මගේ සියලුම වාර පාඩම් ඉලක්ක සපුරා ගත්තෙමි.",
            presentEnglish = "I strive towards academic excellence every single day.",
            presentSinhala = "මම සෑම දිනකම අධ්‍යාපනික විශිෂ්ටත්වය කරා ඇපකැප වෙමි.",
            futureEnglish = "I will enter university with flying colors.",
            futureSinhala = "මම විශිෂ්ට සාමාර්ථ සමඟින් විශ්වවිද්‍යාලයට ඇතුළත් වන්නෙමි.",
            verbTransformation = "achieved → strive → will enter"
          )
        )
      ),

      // ==========================================
      // Category 5: ගමන් බිමන් සහ ප්‍රවාහනය (Travel & Commuting) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 5,
        titleSinhala = "කාණ්ඩය 05: ගමන් බිමන්, දුම්රිය සහ ප්‍රවාහනය",
        titleEnglish = "Travel, Transit & Commuting",
        icon = "🚆",
        description = "බස් රථ, දුම්රිය, පයින් යාම, ප්‍රවේශපත්‍ර සහ සංචාර පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t5_s1",
            baseActionSinhala = "දුම්රියට ගොඩවීම",
            pastEnglish = "We boarded the express train to Kandy yesterday.",
            pastSinhala = "අපි ඊයේ මහනුවර බලා යන සීඝ්‍රගාමී දුම්රියට ගොඩ වුණෙමු.",
            presentEnglish = "Commuters board the train during rush hours.",
            presentSinhala = "කාර්යබහුල වේලාවන්හිදී මගීහු දුම්රියට ගොඩ වෙති.",
            futureEnglish = "We will board the coastal train at 8:00 AM.",
            futureSinhala = "අපි උදෑසන 8:00 ට මුහුදුබඩ දුම්රියට ගොඩ වන්නෙමු.",
            verbTransformation = "boarded → board → will board"
          ),
          TenseSentenceItem(
            id = "t5_s2",
            baseActionSinhala = "දුම්රිය ප්‍රවේශපත්‍ර මිලදී ගැනීම",
            pastEnglish = "Father bought second class train tickets.",
            pastSinhala = "තාත්තා දෙවන පන්තියේ දුම්රිය ප්‍රවේශපත්‍ර මිලදී ගත්තේය.",
            presentEnglish = "Passengers buy tickets at the railway counter.",
            presentSinhala = "මගීහු දුම්රිය කවුළුවෙන් ප්‍රවේශපත්‍ර මිලදී ගනිති.",
            futureEnglish = "I will reserve online tickets for Badulla.",
            futureSinhala = "මම බදුල්ල බලා යාමට අන්තර්ජාලයෙන් ප්‍රවේශපත්‍ර වෙන්කර ගන්නෙමි.",
            verbTransformation = "bought → buy → will reserve"
          ),
          TenseSentenceItem(
            id = "t5_s3",
            baseActionSinhala = "බස් රථය එනතුරු රැඳී සිටීම",
            pastEnglish = "They waited twenty minutes at the bus stop.",
            pastSinhala = "ඔවුහු බස් නැවතුමේ මිනිත්තු විස්සක් රැඳී සිටියහ.",
            presentEnglish = "People wait patiently in the bus queue.",
            presentSinhala = "මිනිස්සු බස් පෝලිමේ ඉවසීමෙන් රැඳී සිටිති.",
            futureEnglish = "We will wait here until the next bus arrives.",
            futureSinhala = "ඊළඟ බස් රථය එනතුරු අපි මෙහි රැඳී සිටින්නෙමු.",
            verbTransformation = "waited → wait → will wait"
          ),
          TenseSentenceItem(
            id = "t5_s4",
            baseActionSinhala = "පාපැදිය පැදීම",
            pastEnglish = "Kamal rode his bicycle to school yesterday.",
            pastSinhala = "කමල් ඊයේ පාසලට පාපැදිය පැද්දේය.",
            presentEnglish = "Kamal rides his bicycle along the village lane.",
            presentSinhala = "කමල් ගමේ පාර දිගේ පාපැදිය පදියි.",
            futureEnglish = "Kamal will ride to the library this evening.",
            futureSinhala = "කමල් අද සවස පුස්තකාලයට පාපැදියෙන් යනු ඇත.",
            verbTransformation = "rode → rides → will ride"
          ),
          TenseSentenceItem(
            id = "t5_s5",
            baseActionSinhala = "මෝටර් රථය ධාවනය",
            pastEnglish = "Uncle drove carefully through heavy rain.",
            pastSinhala = "මාමා තද වැස්ස මැදින් ප්‍රවේශමෙන් මෝටර් රථය පැදවීය.",
            presentEnglish = "Uncle drives responsibly obeying all traffic lights.",
            presentSinhala = "මාමා සියලු රථවාහන සංඥා පිළිපදිමින් වගකීමෙන් රිය පදවයි.",
            futureEnglish = "Uncle will drive us to the airport tonight.",
            futureSinhala = "මාමා අද රෑ අපව ගුවන් තොටුපළට රථයෙන් රැගෙන යනු ඇත.",
            verbTransformation = "drove → drives → will drive"
          ),
          TenseSentenceItem(
            id = "t5_s6",
            baseActionSinhala = "පදික මාරුවෙන් පාර මාරුවීම",
            pastEnglish = "Schoolchildren crossed the road at the pedestrian crossing.",
            pastSinhala = "පාසල් දරුවෝ පදික මාරුවෙන් පාර මාරු වූහ.",
            presentEnglish = "Pedestrians cross the street when green signal shows.",
            presentSinhala = "කොළ සංඥාව පෙන්වන විට පදිකයෝ පාර මාරු වෙති.",
            futureEnglish = "We will cross carefully looking both ways.",
            futureSinhala = "අපි දෙපැත්තම බලා ප්‍රවේශමෙන් පාර මාරු වන්නෙමු.",
            verbTransformation = "crossed → cross → will cross"
          ),
          TenseSentenceItem(
            id = "t5_s7",
            baseActionSinhala = "දුම්රිය මැදිරියේ ජනේලය අසල වාඩිවීම",
            pastEnglish = "I sat by the window and watched scenic tea hills.",
            pastSinhala = "මම ජනේලය අසල වාඩි වී මනරම් තේ කඳු දෙස බැලුවෙමි.",
            presentEnglish = "Travelers enjoy picturesque landscapes from train windows.",
            presentSinhala = "සංචාරකයෝ දුම්රිය ජනේලයෙන් සුන්දර දර්ශන නරඹති.",
            futureEnglish = "I will sit near the door to feel fresh mountain breeze.",
            futureSinhala = "නැවුම් කඳුකර සුළඟ විඳීමට මම දොර අසල වාඩි වන්නෙමි.",
            verbTransformation = "sat → enjoy → will sit"
          ),
          TenseSentenceItem(
            id = "t5_s8",
            baseActionSinhala = "ප්‍රවේශපත්‍ර පරීක්ෂකවරයාට ප්‍රවේශපත්‍රය පෙන්වීම",
            pastEnglish = "He showed his ticket to the conductor.",
            pastSinhala = "ඔහු කොන්දොස්තර මහතාට තම ප්‍රවේශපත්‍රය පෙන්නුවේය.",
            presentEnglish = "Passengers keep their valid tickets ready for inspection.",
            presentSinhala = "මගීහු පරීක්ෂා කිරීම සඳහා තම වලංගු ප්‍රවේශපත්‍ර සූදානම්ව තබා ගනිති.",
            futureEnglish = "We will present our season passes at the exit gate.",
            futureSinhala = "පිටවීමේ දොරටුවේදී අපි අපගේ වාර ප්‍රවේශපත්‍ර ඉදිරිපත් කරන්නෙමු.",
            verbTransformation = "showed → keep → will present"
          ),
          TenseSentenceItem(
            id = "t5_s9",
            baseActionSinhala = "ගමනාන්තයට ළඟාවීම",
            pastEnglish = "The bus reached Galle Fort at noon.",
            pastSinhala = "බස් රථය මද්දහනේදී ගාල්ල කොටුවට ළඟා විය.",
            presentEnglish = "Intercity buses reach destinations punctually.",
            presentSinhala = "නගරාන්තර බස් රථ නියමිත වේලාවට ගමනාන්ත වෙත ළඟා වේ.",
            futureEnglish = "We will reach Matara by 3:00 PM.",
            futureSinhala = "අපි සවස 3:00 වන විට මාතරට ළඟා වන්නෙමු.",
            verbTransformation = "reached → reach → will reach"
          ),
          TenseSentenceItem(
            id = "t5_s10",
            baseActionSinhala = "ගමන් මලු ඇසිරීම",
            pastEnglish = "Mother packed all travel bags neatly.",
            pastSinhala = "අම්මා සියලුම ගමන් මලු පිළිවෙළට ඇසුවාය.",
            presentEnglish = "Smart travelers pack light clothing for trips.",
            presentSinhala = "බුද්ධිමත් සංචාරකයෝ චාරිකා සඳහා සැහැල්ලු ඇඳුම් අසුරති.",
            futureEnglish = "We will pack our camping gear tonight.",
            futureSinhala = "අපි අද රෑ කඳවුරු බැඳීමේ ආම්පන්න අසුරන්නෙමු.",
            verbTransformation = "packed → pack → will pack"
          ),
          TenseSentenceItem(
            id = "t5_s11",
            baseActionSinhala = "ගුවන් යානය ගුවන්ගත වීම",
            pastEnglish = "The aircraft took off smoothly from Katunayake.",
            pastSinhala = "ගුවන් යානය කටුනායකින් සුමටව ගුවන්ගත විය.",
            presentEnglish = "International flights depart around the clock.",
            presentSinhala = "ජාත්‍යන්තර ගුවන් ගමන් දිවා රෑ පුරා පිටත්ව යයි.",
            futureEnglish = "The plane will land in London in ten hours.",
            futureSinhala = "ගුවන් යානය තව පැය දහයකින් ලන්ඩනයට ගොඩබසිනු ඇත.",
            verbTransformation = "took off → depart → will land"
          ),
          TenseSentenceItem(
            id = "t5_s12",
            baseActionSinhala = "මහාමාර්ගයේ වාහන තදබදය",
            pastEnglish = "Traffic moved slowly due to heavy rain.",
            pastSinhala = "තද වැස්ස නිසා රථවාහන සෙමින් ගමන් කළේය.",
            presentEnglish = "Vehicles crawl during peak office hours.",
            presentSinhala = "කාර්යාල වේලාවන්හිදී වාහන ඉතා සෙමින් ඇදෙයි.",
            futureEnglish = "The flyover will ease highway congestion soon.",
            futureSinhala = "ගුවන් පාලම මඟින් මහාමාර්ග තදබදය ඉක්මනින් ලිහිල් කරනු ඇත.",
            verbTransformation = "moved → crawl → will ease"
          ),
          TenseSentenceItem(
            id = "t5_s13",
            baseActionSinhala = "බස් රථයෙන් බැසීම",
            pastEnglish = "We got off the bus at Clock Tower junction.",
            pastSinhala = "අපි ඔරලෝසු කණුව හන්දියෙන් බස් රථයෙන් බැස්සෙමු.",
            presentEnglish = "Passengers alight when the bus halts completely.",
            presentSinhala = "බස් රථය සම්පූර්ණයෙන්ම නැවතුණු පසු මගීහු බසිති.",
            futureEnglish = "I will get off at the university main gate.",
            futureSinhala = "මම විශ්වවිද්‍යාලයේ ප්‍රධාන දොරටුවෙන් බසින්නෙමි.",
            verbTransformation = "got off → alight → will get off"
          ),
          TenseSentenceItem(
            id = "t5_s14",
            baseActionSinhala = "ත්‍රිරෝද රථයක් කුලියට ගැනීම",
            pastEnglish = "Father hired a tuk-tuk to reach hospital quickly.",
            pastSinhala = "රෝහලට ඉක්මනින් යාමට තාත්තා ත්‍රිරෝද රථයක් කුලියට ගත්තේය.",
            presentEnglish = "Commuters use metered taxis in city center.",
            presentSinhala = "මගීහු නගර මධ්‍යයේ මීටර් කුලී රථ භාවිත කරති.",
            futureEnglish = "We will hire a van for our family tour.",
            futureSinhala = "අපේ පවුලේ චාරිකාව සඳහා අපි වෑන් රථයක් කුලියට ගන්නෙමු.",
            verbTransformation = "hired → use → will hire"
          ),
          TenseSentenceItem(
            id = "t5_s15",
            baseActionSinhala = "ආසන පටිය පැළඳීම",
            pastEnglish = "All passengers fastened seat belts before journey.",
            pastSinhala = "ගමනට පෙර සියලුම මගීහු ආසන පටි පැළඳගත්හ.",
            presentEnglish = "Wearing seat belts ensures road safety.",
            presentSinhala = "ආසන පටි පැළඳීම මඟින් මාර්ග ආරක්ෂාව තහවුරු කරයි.",
            futureEnglish = "The driver will remind everyone to buckle up.",
            futureSinhala = "රියදුරු සැමට ආසන පටි පළඳින ලෙස මතක් කරනු ඇත.",
            verbTransformation = "fastened → ensures → will remind"
          ),
          TenseSentenceItem(
            id = "t5_s16",
            baseActionSinhala = "ප්‍රදීපාගාරය නැරඹීම",
            pastEnglish = "Tourists visited Dondra Head lighthouse.",
            pastSinhala = "සංචාරකයෝ දෙවුන්දර තුඩුව ප්‍රදීපාගාරය නැරඹූහ.",
            presentEnglish = "The historic lighthouse guides offshore vessels.",
            presentSinhala = "ඓතිහාසික ප්‍රදීපාගාරය ගැඹුරු මුහුදේ යාත්‍රාවලට මඟ පෙන්වයි.",
            futureEnglish = "We will take memorable photographs at the beacon.",
            futureSinhala = "අපි ප්‍රදීපාගාරය අසලදී මතක සටහන් ඡායාරූප ගන්නෙමු.",
            verbTransformation = "visited → guides → will take"
          ),
          TenseSentenceItem(
            id = "t5_s17",
            baseActionSinhala = "කඳු නැගීම",
            pastEnglish = "Pilgrims climbed Sri Pada overnight.",
            pastSinhala = "බැතිමත්තු රාත්‍රිය පුරා ශ්‍රී පාදය තරණය කළහ.",
            presentEnglish = "Hikers climb Ella Rock for mountain panoramas.",
            presentSinhala = "කඳු නගින්නෝ සුන්දර දර්ශන සඳහා ඇල්ල රොක් තරණය කරති.",
            futureEnglish = "We will summit Sigiriya rock fortress at sunrise.",
            futureSinhala = "අපි හිරු උදාවේදී සීගිරිය පර්වත මාලිගාව තරණය කරන්නෙමු.",
            verbTransformation = "climbed → climb → will summit"
          ),
          TenseSentenceItem(
            id = "t5_s18",
            baseActionSinhala = "බෝට්ටු සවාරියක් යාම",
            pastEnglish = "We sailed across Madu River mangrove tunnels.",
            pastSinhala = "අපි මාදු ගඟේ කඩොලාන උමං මැදින් බෝට්ටුවෙන් යාත්‍රා කළෙමු.",
            presentEnglish = "Fishermen steer wooden catamarans out to sea.",
            presentSinhala = "ධීවරයෝ ලී ඔරු මුහුදට පදවති.",
            futureEnglish = "We will take a glass-bottom boat tour at Hikkaduwa.",
            futureSinhala = "අපි හික්කඩුවේදී විදුරු පතුලක් සහිත බෝට්ටු සවාරියක් යන්නෙමු.",
            verbTransformation = "sailed → steer → will take"
          ),
          TenseSentenceItem(
            id = "t5_s19",
            baseActionSinhala = "සිතියම පරීක්ෂා කිරීම",
            pastEnglish = "The driver consulted GPS map to find short route.",
            pastSinhala = "කෙටි මාර්ගය සොයා ගැනීමට රියදුරු GPS සිතියම පරීක්ෂා කළේය.",
            presentEnglish = "Digital navigation apps calculate estimated arrival time.",
            presentSinhala = "ඩිජිටල් සිතියම් මගින් ළඟා වීමට ගතවන ඇස්තමේන්තුගත කාලය ගණනය කරයි.",
            futureEnglish = "We will follow Google Maps instructions accurately.",
            futureSinhala = "අපි Google Maps උපදෙස් නිවැරදිව අනුගමනය කරන්නෙමු.",
            verbTransformation = "consulted → calculate → will follow"
          ),
          TenseSentenceItem(
            id = "t5_s20",
            baseActionSinhala = "ඉන්ධන පිරවුම්හලට යාම",
            pastEnglish = "Father refueled petrol tank at the filling station.",
            pastSinhala = "තාත්තා ඉන්ධන පිරවුම්හලෙන් පෙට්‍රල් ටැංකිය පුරවා ගත්තේය.",
            presentEnglish = "Vehicles check tire pressure during pit stops.",
            presentSinhala = "නැවතුම්වලදී වාහනවල ටයර් පීඩනය පරීක්ෂා කරනු ලැබේ.",
            futureEnglish = "We will recharge our electric car at expressway station.",
            futureSinhala = "අධිවේගී මාර්ග නැවතුමේදී අපි අපගේ විදුලි මෝටර් රථය ආරෝපණය කරන්නෙමු.",
            verbTransformation = "refueled → check → will recharge"
          ),
          TenseSentenceItem(
            id = "t5_s21",
            baseActionSinhala = "අධිවේගී මාර්ගයේ ගමන් කිරීම",
            pastEnglish = "We drove on Southern Expressway smoothly.",
            pastSinhala = "අපි දක්ෂිණ අධිවේගී මාර්ගයේ ඉතා සුමටව ගමන් කළෙමු.",
            presentEnglish = "Expressways cut travel duration significantly.",
            presentSinhala = "අධිවේගී මාර්ග ගමන් කාලය සැලකිය යුතු ලෙස අඩු කරයි.",
            futureEnglish = "The new highway will connect Central Province directly.",
            futureSinhala = "නව මහාමාර්ගය මධ්‍යම පළාත සෘජුවම සම්බන්ධ කරනු ඇත.",
            verbTransformation = "drove → cut → will connect"
          ),
          TenseSentenceItem(
            id = "t5_s22",
            baseActionSinhala = "අත්වැසුම් සහ හිස්වැසුම් පැළඳීම",
            pastEnglish = "The motorcyclist wore approved safety helmet.",
            pastSinhala = "යතුරුපැදිකරු අනුමත ආරක්ෂිත හිස්වැසුම පැළඳ සිටියේය.",
            presentEnglish = "Riders obey helmet laws without exception.",
            presentSinhala = "යතුරුපැදිකරුවෝ ව්‍යතිරේකයකින් තොරව හිස්වැසුම් නීති පිළිපදිති.",
            futureEnglish = "He will strap his helmet firmly before accelerating.",
            futureSinhala = "ඔහු වේගය වැඩි කිරීමට පෙර හිස්වැසුම තදින් සවි කරගනු ඇත.",
            verbTransformation = "wore → obey → will strap"
          ),
          TenseSentenceItem(
            id = "t5_s23",
            baseActionSinhala = "ප්‍රමාදයන් වළක්වා ගැනීම",
            pastEnglish = "The passenger reached terminal early to avoid rush.",
            pastSinhala = "තදබදය මඟහරවා ගැනීමට මගියා කලින්ම පර්යන්තයට පැමිණියේය.",
            presentEnglish = "Early planning guarantees stress-free journeys.",
            presentSinhala = "වේලාසන සැලසුම් කිරීම මඟින් කරදරවලින් තොර ගමන් සහතික කරයි.",
            futureEnglish = "We will depart at dawn to bypass traffic bottlenecks.",
            futureSinhala = "මාර්ග තදබදය මඟහැරීම සඳහා අපි අලුයම පිටත්ව යන්නෙමු.",
            verbTransformation = "reached → guarantees → will depart"
          ),
          TenseSentenceItem(
            id = "t5_s24",
            baseActionSinhala = "හෝටල් කාමරයක් වෙන්කිරීම",
            pastEnglish = "They booked a cozy guest house in Nuwara Eliya.",
            pastSinhala = "ඔවුහු නුවරඑළියේ සුවපහසු තානායමක කාමරයක් වෙන්කර ගත්හ.",
            presentEnglish = "Tourists reserve accommodations well in advance.",
            presentSinhala = "සංචාරකයෝ බොහෝ වේලාවකට පෙර නවාතැන් වෙන්කර ගනිති.",
            futureEnglish = "We will confirm our resort booking tomorrow morning.",
            futureSinhala = "අපි හෙට උදෑසන නිවාඩු නිකේතන වෙන්කිරීම තහවුරු කරන්නෙමු.",
            verbTransformation = "booked → reserve → will confirm"
          ),
          TenseSentenceItem(
            id = "t5_s25",
            baseActionSinhala = "ස්වභාවික සෞන්දර්යය විඳීම",
            pastEnglish = "We admired roaring Ramboda water falls.",
            pastSinhala = "අපි රම්බොඩ දියඇල්ලේ මනරම් සුන්දරත්වය අගය කළෙමු.",
            presentEnglish = "Nature lovers cherish untouched pristine forests.",
            presentSinhala = "පරිසර ලෝලීහු නොඉඳුල් සුන්දර වනාන්තර අගය කරති.",
            futureEnglish = "We will marvel at Horton Plains World's End precipice.",
            futureSinhala = "හෝර්ටන් තැන්නේ ලෝකාන්තයේදී අපි මවිතයට පත්වන්නෙමු.",
            verbTransformation = "admired → cherish → will marvel"
          ),
          TenseSentenceItem(
            id = "t5_s26",
            baseActionSinhala = "සුවපහසු සපත්තු පැළඳීම",
            pastEnglish = "I wore running sneakers for long walking tour.",
            pastSinhala = "දිගු ඇවිදීමේ චාරිකාව සඳහා මම සුවපහසු සපත්තු පැළඳගත්තෙමි.",
            presentEnglish = "Good walking shoes prevent blisters on trails.",
            presentSinhala = "හොඳ ඇවිදීමේ සපත්තු මඟින් පාදවල බිබිලි ඇතිවීම වළක්වයි.",
            futureEnglish = "I will purchase durable hiking boots.",
            futureSinhala = "මම කල්පවතින කඳු නැගීමේ සපත්තු යුගලක් මිලදී ගන්නෙමි.",
            verbTransformation = "wore → prevent → will purchase"
          ),
          TenseSentenceItem(
            id = "t5_s27",
            baseActionSinhala = "දුම්රිය නලා හඬ",
            pastEnglish = "The train sounded its horn as it approached the bend.",
            pastSinhala = "වංගුවට ළඟා වන විට දුම්රිය නලාව නාද කළේය.",
            presentEnglish = "Engine drivers blow horn near railway crossings.",
            presentSinhala = "දුම්රිය රියදුරෝ හරස් මාර්ග අසලදී නලා හඬවති.",
            futureEnglish = "The train will sound loud horn before bridge.",
            futureSinhala = "පාලමට පෙර දුම්රිය මහ හඬින් නලාව නාද කරනු ඇත.",
            verbTransformation = "sounded → blow → will sound"
          ),
          TenseSentenceItem(
            id = "t5_s28",
            baseActionSinhala = "ගමනේ මතක සටහන් ගැනීම",
            pastEnglish = "Sister kept a travel journal of our Jaffna trip.",
            pastSinhala = "අපේ යාපනය චාරිකාවේ සංචාරක සටහන් පොතක් නංගී තබා ගත්තාය.",
            presentEnglish = "Travel blogs inspire people to explore heritage sites.",
            presentSinhala = "සංචාරක බ්ලොග් අඩවි ඓතිහාසික ස්ථාන ගවේෂණය කිරීමට මිනිසුන් පෙළඹවයි.",
            futureEnglish = "We will document all sacred temples we visit.",
            futureSinhala = "අප නරඹන සියලුම පූජනීය සිද්ධස්ථාන අපි ලේඛනගත කරන්නෙමු.",
            verbTransformation = "kept → inspire → will document"
          ),
          TenseSentenceItem(
            id = "t5_s29",
            baseActionSinhala = "ආපසු ගෙදර පැමිණීම",
            pastEnglish = "We returned home exhausted but joyous.",
            pastSinhala = "වෙහෙසට පත් වුවද මහත් සතුටින් අපි ආපසු නිවසට පැමිණියෙමු.",
            presentEnglish = "Traveling refreshes tired human minds.",
            presentSinhala = "සංචාරය කිරීම වෙහෙසට පත් මිනිස් මනස ප්‍රබෝධමත් කරයි.",
            futureEnglish = "We will unpack souvenirs and tell stories tonight.",
            futureSinhala = "අපි අද රෑ සිහිවටන දිගහැර කතා කියන්නෙමු.",
            verbTransformation = "returned → refreshes → will unpack"
          ),
          TenseSentenceItem(
            id = "t5_s30",
            baseActionSinhala = "සුරක්ෂිතව ගමන නිමා කිරීම",
            pastEnglish = "Everyone completed the round island tour safely.",
            pastSinhala = "සියලු දෙනාම දිවයින වටා සංචාරය ආරක්ෂිතව නිම කළහ.",
            presentEnglish = "Safe driving saves countless valuable lives.",
            presentSinhala = "ආරක්ෂිත රිය පැදවීම ගණන් කළ නොහැකි වටිනා ජීවිත බේරා ගනී.",
            futureEnglish = "We will remember this wondrous journey forever.",
            futureSinhala = "අපි මෙම විස්මිත චාරිකාව සදාකාලයටම මතකයේ තබා ගන්නෙමු.",
            verbTransformation = "completed → saves → will remember"
          )
        )
      )
    )
  }
}
