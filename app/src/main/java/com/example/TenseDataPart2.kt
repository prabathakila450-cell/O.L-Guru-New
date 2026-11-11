package com.example

object TenseDataPart2 {
  fun getCategoriesPart2(): List<TenseComparisonCategory> {
    return listOf(
      // ==========================================
      // Category 6: නිවසේ වැඩ සහ පිරිසිදු කිරීම් (Household Chores) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 6,
        titleSinhala = "කාණ්ඩය 06: නිවසේ වැඩ සහ පිරිසිදු කිරීම්",
        titleEnglish = "Household Chores & Home Care",
        icon = "🧹",
        description = "ගෙබිම අතුගෑම, රෙදි සේදීම, මකුළු දැල් කැඩීම සහ ගෙවත්ත පිරිසිදු කිරීම පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t6_s1",
            baseActionSinhala = "ගෙබිම අතුගෑම",
            pastEnglish = "Mother swept the living room floor this morning.",
            pastSinhala = "අම්මා අද උදෑසන සාලයේ ගෙබිම අතුගෑවාය.",
            presentEnglish = "Mother sweeps the house twice a day.",
            presentSinhala = "අම්මා දිනකට දෙවරක් නිවස අතුගායි.",
            futureEnglish = "Mother will sweep the verandah this evening.",
            futureSinhala = "අම්මා අද සවස ඉස්තෝප්පුව අතුගානු ඇත.",
            verbTransformation = "swept → sweeps → will sweep"
          ),
          TenseSentenceItem(
            id = "t6_s2",
            baseActionSinhala = "රෙදි සේදීම",
            pastEnglish = "She washed school uniforms yesterday.",
            pastSinhala = "ඇය ඊයේ පාසල් නිල ඇඳුම් සේදුවාය.",
            presentEnglish = "She washes dirty clothes using the washing machine.",
            presentSinhala = "ඇය රෙදි සෝදන යන්ත්‍රය භාවිතයෙන් අපිරිසිදු රෙදි සෝදයි.",
            futureEnglish = "She will wash the bedsheets on Saturday.",
            futureSinhala = "ඇය සෙනසුරාදා ඇඳ ඇතිරිලි සෝදනු ඇත.",
            verbTransformation = "washed → washes → will wash"
          ),
          TenseSentenceItem(
            id = "t6_s3",
            baseActionSinhala = "රෙදි වේලීමට දැමීම",
            pastEnglish = "I hung the wet clothes on the clothesline.",
            pastSinhala = "මම තෙත රෙදි වැලේ වේලෙන්නට දැමුවෙමි.",
            presentEnglish = "I hang laundry under bright sunshine.",
            presentSinhala = "මම තද අව්වේ රෙදි වේලෙන්නට දමමි.",
            futureEnglish = "I will hang the towels out to dry.",
            futureSinhala = "මම තුවා වේලෙන්නට දමන්නෙමි.",
            verbTransformation = "hung → hang → will hang"
          ),
          TenseSentenceItem(
            id = "t6_s4",
            baseActionSinhala = "රෙදි මැදීම",
            pastEnglish = "Sister ironed my white shirt neatly.",
            pastSinhala = "නංගී මගේ සුදු කමිසය පිළිවෙළට මැද්දාය.",
            presentEnglish = "Sister irons all clothes on Sunday evening.",
            presentSinhala = "නංගී ඉරිදා සවස සියලු රෙදි මදියි.",
            futureEnglish = "Sister will iron trousers after dinner.",
            futureSinhala = "නංගී රෑ කෑමෙන් පසු කලිසම් මදිනු ඇත.",
            verbTransformation = "ironed → irons → will iron"
          ),
          TenseSentenceItem(
            id = "t6_s5",
            baseActionSinhala = "දූවිලි පිසදැමීම",
            pastEnglish = "He dusted the wooden furniture yesterday.",
            pastSinhala = "ඔහු ඊයේ ලී බඩු වල දූවිලි පිසදැමුවේය.",
            presentEnglish = "He dusts bookshelves with a soft cloth.",
            presentSinhala = "ඔහු මෘදු රෙදි කඩකින් පොත් රාක්කවල දූවිලි පිසදමයි.",
            futureEnglish = "He will dust ceiling fans tomorrow morning.",
            futureSinhala = "ඔහු හෙට උදෑසන සිවිලිමේ විදුලි පංකා පිසදමනු ඇත.",
            verbTransformation = "dusted → dusts → will dust"
          ),
          TenseSentenceItem(
            id = "t6_s6",
            baseActionSinhala = "ගෙබිම මොප් කිරීම",
            pastEnglish = "We mopped the tiled floor with disinfectant.",
            pastSinhala = "අපි විෂබීජ නාශක දමා ටයිල් කළ ගෙබිම මොප් කළෙමු.",
            presentEnglish = "We mop kitchen tiles every evening.",
            presentSinhala = "අපි සෑම සවසකම කුස්සියේ ටයිල් මොප් කරමු.",
            futureEnglish = "We will mop all rooms before the new year.",
            futureSinhala = "අවුරුද්දට පෙර අපි සියලු කාමර මොප් කරන්නෙමු.",
            verbTransformation = "mopped → mop → will mop"
          ),
          TenseSentenceItem(
            id = "t6_s7",
            baseActionSinhala = "කුණු කසළ බැහැර කිරීම",
            pastEnglish = "Father took out the sorted garbage bags.",
            pastSinhala = "තාත්තා වෙන් කළ කුණු බෑග් පිටතට ගෙන ගියේය.",
            presentEnglish = "Father separates organic and plastic waste.",
            presentSinhala = "තාත්තා කාබනික සහ ප්ලාස්ටික් අපද්‍රව්‍ය වෙන් කරයි.",
            futureEnglish = "Father will hand over recyclable plastic to municipal truck.",
            futureSinhala = "තාත්තා නගර සභා ලොරියට ප්‍රතිචක්‍රීකරණය කළ හැකි ප්ලාස්ටික් භාර දෙනු ඇත.",
            verbTransformation = "took out → separates → will hand over"
          ),
          TenseSentenceItem(
            id = "t6_s8",
            baseActionSinhala = "මකුළු දැල් කැඩීම",
            pastEnglish = "Brother removed cobwebs from the corners.",
            pastSinhala = "අයියා මුළුතැන්ගෙයි මුළු වලින් මකුළු දැල් කැඩුවේය.",
            presentEnglish = "Brother cleans cobwebs using a long broom.",
            presentSinhala = "අයියා දිග ඉදලක් භාවිතයෙන් මකුළු දැල් කඩයි.",
            futureEnglish = "Brother will clean high ceiling corners.",
            futureSinhala = "අයියා උස් සිවිලිමේ මුළු පිරිසිදු කරනු ඇත.",
            verbTransformation = "removed → cleans → will clean"
          ),
          TenseSentenceItem(
            id = "t6_s9",
            baseActionSinhala = "වත්ත අතුගෑම",
            pastEnglish = "Grandfather swept dry leaves in the garden.",
            pastSinhala = "සීයා වත්තේ වියළි කොළ අතුගෑවේය.",
            presentEnglish = "Grandfather sweeps fallen leaves into a compost pit.",
            presentSinhala = "සීයා වැටුණු කොළ කොම්පෝස්ට් වලකට අතුගා දමයි.",
            futureEnglish = "Grandfather will rake the front lawn tomorrow.",
            futureSinhala = "සීයා හෙට ඉදිරිපස තණකොළ රාක්කයෙන් අතුගානු ඇත.",
            verbTransformation = "swept → sweeps → will rake"
          ),
          TenseSentenceItem(
            id = "t6_s10",
            baseActionSinhala = "නාන කාමරය සේදීම",
            pastEnglish = "I scrubbed bathroom tiles thoroughly.",
            pastSinhala = "මම නාන කාමරයේ ටයිල් හොඳින් මැද සේදුවෙමි.",
            presentEnglish = "I wash the washbasin every week.",
            presentSinhala = "මම සෑම සතියකම මුහුණ සෝදන බේසම සෝදමි.",
            futureEnglish = "I will clean the shower area on Sunday.",
            futureSinhala = "මම ඉරිදාට ෂවර් ප්‍රදේශය පිරිසිදු කරන්නෙමි.",
            verbTransformation = "scrubbed → wash → will clean"
          ),
          TenseSentenceItem(
            id = "t6_s11",
            baseActionSinhala = "ජනෙල් වීදුරු පිසදැමීම",
            pastEnglish = "She wiped glass windows with a clean sponge.",
            pastSinhala = "ඇය පිරිසිදු ස්පොන්ජියකින් ජනෙල් වීදුරු පිසදැමුවාය.",
            presentEnglish = "She cleans glass surfaces to let in bright light.",
            presentSinhala = "ඇය ආලෝකය ලැබෙන සේ වීදුරු පෘෂ්ඨ පිරිසිදු කරයි.",
            futureEnglish = "She will polish the mirrors until they sparkle.",
            futureSinhala = "ඇය දිලිසෙන තුරු කණ්ණාඩි ඔප දමනු ඇත.",
            verbTransformation = "wiped → cleans → will polish"
          ),
          TenseSentenceItem(
            id = "t6_s12",
            baseActionSinhala = "ශීතකරණය පිරිසිදු කිරීම",
            pastEnglish = "Mother defrosted and cleaned the refrigerator.",
            pastSinhala = "අම්මා ශීතකරණය අයිස් ඉවත් කර පිරිසිදු කළාය.",
            presentEnglish = "Mother keeps food items neatly stored.",
            presentSinhala = "අම්මා ආහාර ද්‍රව්‍ය පිළිවෙළට ගබඩා කර තබයි.",
            futureEnglish = "Mother will throw away expired bottles.",
            futureSinhala = "අම්මා කල් ඉකුත් වූ බෝතල් ඉවත් කරනු ඇත.",
            verbTransformation = "defrosted → keeps → will throw away"
          ),
          TenseSentenceItem(
            id = "t6_s13",
            baseActionSinhala = "ඇඳුම් අල්මාරිය පිළිවෙළට තැබීම",
            pastEnglish = "I folded my shirts and arranged the wardrobe.",
            pastSinhala = "මම මගේ කමිස නමා අල්මාරිය පිළිවෙළට සකස් කළෙමි.",
            presentEnglish = "I keep clothes categorized in drawers.",
            presentSinhala = "මම ලාච්චුවල ඇඳුම් වර්ග කර තබා ගනිමි.",
            futureEnglish = "I will donate old clothes to charity.",
            futureSinhala = "මම පැරණි ඇඳුම් පුණ්‍යායතනයකට පරිත්‍යාග කරන්නෙමි.",
            verbTransformation = "folded → keep → will donate"
          ),
          TenseSentenceItem(
            id = "t6_s14",
            baseActionSinhala = "තණකොළ කැපීම",
            pastEnglish = "Father cut the garden grass with a lawnmower.",
            pastSinhala = "තාත්තා තණකොළ කපන යන්ත්‍රයෙන් වත්තේ තණකොළ කැපුවේය.",
            presentEnglish = "Father trims lawn edges every fortnight.",
            presentSinhala = "තාත්තා සති දෙකකට වරක් තණකොළ දාර කපයි.",
            futureEnglish = "Father will trim hedges around the fence.",
            futureSinhala = "තාත්තා වැට වටා ඇති පඳුරු කප්පාදු කරනු ඇත.",
            verbTransformation = "cut → trims → will trim"
          ),
          TenseSentenceItem(
            id = "t6_s15",
            baseActionSinhala = "කුස්සියේ ලිප පිරිසිදු කිරීම",
            pastEnglish = "She cleaned oil stains off the gas stove.",
            pastSinhala = "ඇය ගෑස් ලිපේ තෙල් පැල්ලම් පිරිසිදු කළාය.",
            presentEnglish = "She wipes the cooking counter after frying.",
            presentSinhala = "ඇය බැදීමෙන් පසු කුස්සියේ මේසය පිසදමයි.",
            futureEnglish = "She will scrub the oven thoroughly.",
            futureSinhala = "ඇය උඳුන හොඳින් මැද පිරිසිදු කරනු ඇත.",
            verbTransformation = "cleaned → wipes → will scrub"
          ),
          TenseSentenceItem(
            id = "t6_s16",
            baseActionSinhala = "තිර රෙදි සේදීම",
            pastEnglish = "We washed dusty curtains last weekend.",
            pastSinhala = "අපි පසුගිය සති අන්තයේ දූවිලි පිරුණු තිර රෙදි සේදුවෙමු.",
            presentEnglish = "We change window curtains periodically.",
            presentSinhala = "අපි වරින් වර ජනෙල් තිර රෙදි මාරු කරමු.",
            futureEnglish = "We will hang colorful new drapes for festive season.",
            futureSinhala = "අපි උත්සව සමය සඳහා වර්ණවත් නව තිර රෙදි එල්ලන්නෙමු.",
            verbTransformation = "washed → change → will hang"
          ),
          TenseSentenceItem(
            id = "t6_s17",
            baseActionSinhala = "පාපිසි පිසදැමීම",
            pastEnglish = "He shook the dust off doormats outside.",
            pastSinhala = "ඔහු එළිමහනේදී පාපිසි ගසා දූවිලි ඉවත් කළේය.",
            presentEnglish = "He cleans foot mats before visitors arrive.",
            presentSinhala = "අමුත්තන් පැමිණීමට පෙර ඔහු පාපිසි පිරිසිදු කරයි.",
            futureEnglish = "He will replace worn mats with rubber ones.",
            futureSinhala = "ඔහු පරණ පාපිසි වෙනුවට රබර් පාපිසි දමනු ඇත.",
            verbTransformation = "shook → cleans → will replace"
          ),
          TenseSentenceItem(
            id = "t6_s18",
            baseActionSinhala = "බල්බ මාරු කිරීම",
            pastEnglish = "Father replaced the fused bulb in the garage.",
            pastSinhala = "තාත්තා ගරාජයේ පිච්චුණු බල්බය මාරු කළේය.",
            presentEnglish = "Father fixes minor electrical household repairs.",
            presentSinhala = "තාත්තා නිවසේ සුළු විදුලි අලුත්වැඩියාවන් සිදු කරයි.",
            futureEnglish = "Father will install energy-saving LED lamps.",
            futureSinhala = "තාත්තා බලශක්තිය ඉතිරි කරන LED ලාම්පු සවි කරනු ඇත.",
            verbTransformation = "replaced → fixes → will install"
          ),
          TenseSentenceItem(
            id = "t6_s19",
            baseActionSinhala = "බෙහෙත් පෙට්ටිය පරීක්ෂා කිරීම",
            pastEnglish = "Mother checked the family first aid kit.",
            pastSinhala = "අම්මා පවුලේ ප්‍රථමාධාර පෙට්ටිය පරීක්ෂා කළාය.",
            presentEnglish = "Mother stores medicines safely out of reach of children.",
            presentSinhala = "අම්මා ළමයින්ට ළඟා විය නොහැකි ලෙස ඖෂධ සුරක්ෂිතව තබයි.",
            futureEnglish = "Mother will buy fresh bandages and antiseptic.",
            futureSinhala = "අම්මා නැවුම් වෙළුම් පටි සහ විෂබීජ නාශක මිලදී ගනු ඇත.",
            verbTransformation = "checked → stores → will buy"
          ),
          TenseSentenceItem(
            id = "t6_s20",
            baseActionSinhala = "කාණු පිරිසිදු කිරීම",
            pastEnglish = "We unclogged water drainage gutters before rainy season.",
            pastSinhala = "අපි වැසි සමයට පෙර වතුර බැස යන කාණු සුද්ද කළෙමු.",
            presentEnglish = "Clean gutters prevent mosquito breeding.",
            presentSinhala = "පිරිසිදු කාණු මදුරුවන් බෝවීම වළක්වයි.",
            futureEnglish = "We will inspect roof gutters this Saturday.",
            futureSinhala = "අපි මේ සෙනසුරාදා වහලයේ කාණු පරීක්ෂා කරන්නෙමු.",
            verbTransformation = "unclogged → prevent → will inspect"
          ),
          TenseSentenceItem(
            id = "t6_s21",
            baseActionSinhala = "මල් පෝච්චි පිළිවෙළට තැබීම",
            pastEnglish = "Sister arranged flower pots along the pathway.",
            pastSinhala = "නංගී පාර දෙපස මල් පෝච්චි පිළිවෙළට තැබුවාය.",
            presentEnglish = "Sister weeds around delicate flowering plants.",
            presentSinhala = "නංගී මල් පැළ වටා වල් පැළෑටි උදුරා දමයි.",
            futureEnglish = "Sister will repot small orchids into bigger pots.",
            futureSinhala = "නංගී කුඩා ඕකිඩ් පැළ විශාල බඳුන්වලට මාරු කරනු ඇත.",
            verbTransformation = "arranged → weeds → will repot"
          ),
          TenseSentenceItem(
            id = "t6_s22",
            baseActionSinhala = "කුරුලු කූඩුව පිරිසිදු කිරීම",
            pastEnglish = "I placed fresh water for visiting garden birds.",
            pastSinhala = "මම වත්තට එන කුරුල්ලන් සඳහා නැවුම් ජලය තැබුවෙමි.",
            presentEnglish = "I refill the bird bath every sunny morning.",
            presentSinhala = "මම සෑම හිරු පායන උදෑසනකම කුරුලු නාන බඳුන පුරවමි.",
            futureEnglish = "I will hang a wooden bird feeder on mango tree.",
            futureSinhala = "මම අඹ ගසේ ලී කුරුලු කූඩුවක් එල්ලන්නෙමි.",
            verbTransformation = "placed → refill → will hang"
          ),
          TenseSentenceItem(
            id = "t6_s23",
            baseActionSinhala = "සපත්තු රැක් එක සකස් කිරීම",
            pastEnglish = "We placed all shoes neatly on the shoe rack.",
            pastSinhala = "අපි සපත්තු රාක්කයේ සියලු සපත්තු පිළිවෙළට තැබුවෙමු.",
            presentEnglish = "We take off footwear before entering the house.",
            presentSinhala = "අපි නිවසට ඇතුළු වීමට පෙර පාවහන් ගලවමු.",
            futureEnglish = "We will clean muddy boots outside.",
            futureSinhala = "අපි මඩ තැවරුණු බූට් සපත්තු පිටතදී පිරිසිදු කරන්නෙමු.",
            verbTransformation = "placed → take off → will clean"
          ),
          TenseSentenceItem(
            id = "t6_s24",
            baseActionSinhala = "කාමර වාතාශ්‍රය තැබීම",
            pastEnglish = "Mother aired the bed mattresses in the hot sun.",
            pastSinhala = "අම්මා තද අව්වේ මෙට්ට දමා වේලුවාය.",
            presentEnglish = "Sunlight disinfects pillows and beddings naturally.",
            presentSinhala = "හිරු එළිය ස්වභාවිකවම කොට්ට සහ ඇඳ ඇතිරිලි විෂබීජහරණය කරයි.",
            futureEnglish = "Mother will bring them inside before dusk.",
            futureSinhala = "ඉර බැසීමට පෙර අම්මා ඒවා ගෙට ගනු ඇත.",
            verbTransformation = "aired → disinfects → will bring"
          ),
          TenseSentenceItem(
            id = "t6_s25",
            baseActionSinhala = "දොර අගුල් තෙල් දැමීම",
            pastEnglish = "Father oiled creaking door hinges.",
            pastSinhala = "තාත්තා සද්ද දෙන දොර අසව්වලට තෙල් දැමුවේය.",
            presentEnglish = "Proper maintenance keeps home hardware durable.",
            presentSinhala = "නිසි නඩත්තුව මඟින් නිවසේ උපකරණ කල්පවත්නා ලෙස තබා ගනී.",
            futureEnglish = "Father will polish brass door handles.",
            futureSinhala = "තාත්තා පිත්තල දොර අත්පිටපත් ඔප දමනු ඇත.",
            verbTransformation = "oiled → keeps → will polish"
          ),
          TenseSentenceItem(
            id = "t6_s26",
            baseActionSinhala = "පැරණි පුවත්පත් එකතු කිරීම",
            pastEnglish = "We tied old newspapers into bundles.",
            pastSinhala = "අපි පරණ පත්තර මිටි බැන්දෙමු.",
            presentEnglish = "We recycle waste paper regularly.",
            presentSinhala = "අපි නිතර අපතේ යන කඩදාසි ප්‍රතිචක්‍රීකරණය කරමු.",
            futureEnglish = "We will give cardboard boxes to paper collectors.",
            futureSinhala = "අපි කාඩ්බෝඩ් පෙට්ටි කඩදාසි එකතු කරන්නන්ට ලබා දෙන්නෙමු.",
            verbTransformation = "tied → recycle → will give"
          ),
          TenseSentenceItem(
            id = "t6_s27",
            baseActionSinhala = "වීදුරු බඩු ප්‍රවේශමෙන් හැසිරවීම",
            pastEnglish = "She washed delicate glassware without breaking any.",
            pastSinhala = "ඇය කිසිවක් නොබිඳ සියුම් වීදුරු බඩු සේදුවාය.",
            presentEnglish = "She handles fragile crockery with utmost care.",
            presentSinhala = "ඇය බිඳෙනසුලු පිඟන් භාණ්ඩ ඉතා ප්‍රවේශමෙන් හසුරුවයි.",
            futureEnglish = "She will pack glass ornaments securely for storage.",
            futureSinhala = "ඇය ගබඩා කිරීම සඳහා වීදුරු සැරසිලි සුරක්ෂිතව අසුරනු ඇත.",
            verbTransformation = "washed → handles → will pack"
          ),
          TenseSentenceItem(
            id = "t6_s28",
            baseActionSinhala = "සාලය පිළිවෙළට තැබීම",
            pastEnglish = "Children gathered their toys after playing.",
            pastSinhala = "සෙල්ලම් කිරීමෙන් පසු ළමයි තම සෙල්ලම් බඩු එකතු කළෝය.",
            presentEnglish = "A clean living room welcomes guests warmly.",
            presentSinhala = "පිරිසිදු සාලය අමුත්තන් උණුසුම් ලෙස පිළිගනී.",
            futureEnglish = "We will decorate sofa with bright cushion covers.",
            futureSinhala = "අපි සෝෆාව දීප්තිමත් කුෂන් කවරවලින් අලංකාර කරන්නෙමු.",
            verbTransformation = "gathered → welcomes → will decorate"
          ),
          TenseSentenceItem(
            id = "t6_s29",
            baseActionSinhala = "ජල ටැංකිය පිරිසිදු කිරීම",
            pastEnglish = "Father cleaned the overhead water tank last month.",
            pastSinhala = "තාත්තා පසුගිය මාසයේ උඩ වතුර ටැංකිය පිරිසිදු කළේය.",
            presentEnglish = "Pure water ensures family health.",
            presentSinhala = "පිරිසිදු ජලය පවුලේ සෞඛ්‍යය සහතික කරයි.",
            futureEnglish = "We will install a new water filter next week.",
            futureSinhala = "අපි ලබන සතියේ නව ජල පෙරණයක් සවි කරන්නෙමු.",
            verbTransformation = "cleaned → ensures → will install"
          ),
          TenseSentenceItem(
            id = "t6_s30",
            baseActionSinhala = "පවුලක් ලෙස එකමුතුව වැඩ කිරීම",
            pastEnglish = "The whole family cleaned the house together.",
            pastSinhala = "මුළු පවුලම එකතු වී නිවස පිරිසිදු කළහ.",
            presentEnglish = "Teamwork makes difficult chores light and fun.",
            presentSinhala = "කණ්ඩායම් හැඟීමෙන් වැඩ කිරීම දුෂ්කර වැඩ පහසු හා විනෝදජනක කරයි.",
            futureEnglish = "We will keep our sweet home spotlessly clean forever.",
            futureSinhala = "අපි අපේ සුන්දර නිවස සදහටම ඉතා පිරිසිදුව තබා ගන්නෙමු.",
            verbTransformation = "cleaned → makes → will keep"
          )
        )
      ),

      // ==========================================
      // Category 7: ක්‍රීඩා සහ ව්‍යායාම (Sports & Exercises) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 7,
        titleSinhala = "කාණ්ඩය 07: ක්‍රීඩා, ශාරීරික යෝග්‍යතාව සහ ව්‍යායාම",
        titleEnglish = "Sports, Athletics & Fitness",
        icon = "⚽",
        description = "ක්‍රිකට්, පාපන්දු, දිවීම, පිහිනීම සහ ව්‍යායාම පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t7_s1",
            baseActionSinhala = "ක්‍රිකට් ක්‍රීඩා කිරීම",
            pastEnglish = "Our village team played cricket yesterday afternoon.",
            pastSinhala = "අපේ ගමේ කණ්ඩායම ඊයේ සවස ක්‍රිකට් ක්‍රීඩා කළහ.",
            presentEnglish = "Boys play cricket on the school grounds.",
            presentSinhala = "පිරිමි ළමයි පාසල් පිටියේ ක්‍රිකට් ක්‍රීඩා කරති.",
            futureEnglish = "They will play the championship match on Sunday.",
            futureSinhala = "ඔවුහු ඉරිදා ශූරතා තරගය ක්‍රීඩා කරනු ඇත.",
            verbTransformation = "played → play → will play"
          ),
          TenseSentenceItem(
            id = "t7_s2",
            baseActionSinhala = "ශතකයක් ලබාගැනීම",
            pastEnglish = "The batsman scored a magnificent century.",
            pastSinhala = "පිතිකරු විශිෂ්ට ශතකයක් ලබාගත්තේය.",
            presentEnglish = "Talented batsmen score runs easily.",
            presentSinhala = "දක්ෂ පිතිකරුවෝ පහසුවෙන්ම ලකුණු රැස් කරති.",
            futureEnglish = "He will score his fifty before lunch.",
            futureSinhala = "ඔහු දිවා ආහාරයට පෙර ඔහුගේ අර්ධ ශතකය ලබාගනු ඇත.",
            verbTransformation = "scored → score → will score"
          ),
          TenseSentenceItem(
            id = "t7_s3",
            baseActionSinhala = "කඩුල්ලක් දවාගැනීම",
            pastEnglish = "The spin bowler took three crucial wickets.",
            pastSinhala = "දඟ පන්දු යවන්නා තීරණාත්මක කඩුලු තුනක් දවාගත්තේය.",
            presentEnglish = "Fast bowlers bowl fiery yorkers.",
            presentSinhala = "වේග පන්දු යවන්නෝ තියුණු යෝකර් පන්දු යවති.",
            futureEnglish = "He will take the final wicket soon.",
            futureSinhala = "ඔහු ඉක්මනින්ම අවසාන කඩුල්ල දවාගනු ඇත.",
            verbTransformation = "took → bowl → will take"
          ),
          TenseSentenceItem(
            id = "t7_s4",
            baseActionSinhala = "පාපන්දු ගෝලයක් ලබාගැනීම",
            pastEnglish = "He kicked the ball and scored a goal.",
            pastSinhala = "ඔහු පන්දුවට පයින් ගසා ගෝලයක් ලබාගත්තේය.",
            presentEnglish = "The striker kicks with immense precision.",
            presentSinhala = "ප්‍රහාරක ක්‍රීඩකයා ඉතා නිරවද්‍ය ලෙස පන්දුවට පහර දෙයි.",
            futureEnglish = "He will kick the decisive penalty shot.",
            futureSinhala = "ඔහු තීරණාත්මක දඬුවම් පහර එල්ල කරනු ඇත.",
            verbTransformation = "kicked → kicks → will kick"
          ),
          TenseSentenceItem(
            id = "t7_s5",
            baseActionSinhala = "උදෑසන ජොගින් යාම",
            pastEnglish = "I jogged three kilometers around the lake.",
            pastSinhala = "මම වැව වටා කිලෝමීටර් තුනක් ජොගින් දිව්වෙමි.",
            presentEnglish = "I jog every morning to stay fit.",
            presentSinhala = "නිරෝගීව සිටීමට මම සෑම උදෑසනකම ජොගින් දුවමි.",
            futureEnglish = "I will jog with my brother tomorrow.",
            futureSinhala = "මම හෙට මගේ සහෝදරයා සමඟ ජොගින් යන්නෙමි.",
            verbTransformation = "jogged → jog → will jog"
          ),
          TenseSentenceItem(
            id = "t7_s6",
            baseActionSinhala = "පිහිනීම",
            pastEnglish = "She swam across the Olympic swimming pool.",
            pastSinhala = "ඇය ඔලිම්පික් පිහිනුම් තටාකය හරහා පිහිනුවාය.",
            presentEnglish = "She swims freestyle effortlessly.",
            presentSinhala = "ඇය නිදහස් ආරයෙන් ඉතා පහසුවෙන් පිහිනයි.",
            futureEnglish = "She will compete in the national swimming meet.",
            futureSinhala = "ඇය ජාතික පිහිනුම් තරගාවලියට තරග කරනු ඇත.",
            verbTransformation = "swam → swims → will compete"
          ),
          TenseSentenceItem(
            id = "t7_s7",
            baseActionSinhala = "බැඩ්මින්ටන් ගැසීම",
            pastEnglish = "We played badminton under the floodlights.",
            pastSinhala = "අපි විදුලි ආලෝකය මැද බැඩ්මින්ටන් ගැසුවෙමු.",
            presentEnglish = "We smash the shuttlecock with sharp power.",
            presentSinhala = "අපි තියුණු වේගයකින් ෂටල්කොක් එකට පහර දෙමු.",
            futureEnglish = "We will challenge the champion doubles pair.",
            futureSinhala = "අපි ශූර යුගල කණ්ඩායමට අභියෝග කරන්නෙමු.",
            verbTransformation = "played → smash → will challenge"
          ),
          TenseSentenceItem(
            id = "t7_s8",
            baseActionSinhala = "දැල්පන්දු ක්‍රීඩාව",
            pastEnglish = "The school netball team won the provincial trophy.",
            pastSinhala = "පාසල් දැල්පන්දු කණ්ඩායම පළාත් කුසලානය දිනා ගත්තේය.",
            presentEnglish = "Players pass the ball rapidly across court.",
            presentSinhala = "ක්‍රීඩිකාවෝ පිටිය පුරා පන්දුව වේගයෙන් පාස් කරති.",
            futureEnglish = "They will defend their national title next week.",
            futureSinhala = "ඔවුහු ලබන සතියේ තම ජාතික කිරුළ රැකගනු ඇත.",
            verbTransformation = "won → pass → will defend"
          ),
          TenseSentenceItem(
            id = "t7_s9",
            baseActionSinhala = "මීටර් 100 ධාවන තරගය",
            pastEnglish = "Kasun sprinted and broke the school record.",
            pastSinhala = "කසුන් වේගයෙන් දිවගොස් පාසල් වාර්තාව බිඳ දැමුවේය.",
            presentEnglish = "Kasun runs 100 meters in under eleven seconds.",
            presentSinhala = "කසුන් තත්පර එකොළහකට අඩු කාලයකින් මීටර් 100 දුවයි.",
            futureEnglish = "Kasun will represent the district in Colombo.",
            futureSinhala = "කසුන් කොළඹදී දිස්ත්‍රික්කය නියෝජනය කරනු ඇත.",
            verbTransformation = "sprinted → runs → will represent"
          ),
          TenseSentenceItem(
            id = "t7_s10",
            baseActionSinhala = "උස පැනීම",
            pastEnglish = "The athlete jumped over the high bar cleanly.",
            pastSinhala = "ක්‍රීඩකයා උස පැනීමේ දණ්ඩට ඉහළින් පිරිසිදුව පැන්නේය.",
            presentEnglish = "Athletes practice landing safely on the foam mat.",
            presentSinhala = "ක්‍රීඩකයෝ ෆෝම් මෙට්ටය මත ආරක්ෂිතව ගොඩබැසීම පුහුණු වෙති.",
            futureEnglish = "He will attempt the two-meter jump tomorrow.",
            futureSinhala = "ඔහු හෙට මීටර් දෙකක උස පැනීමට උත්සාහ කරනු ඇත.",
            verbTransformation = "jumped → practice → will attempt"
          ),
          TenseSentenceItem(
            id = "t7_s11",
            baseActionSinhala = "දුර පැනීම",
            pastEnglish = "She leaped into the sandpit with great momentum.",
            pastSinhala = "ඇය මහත් වේගයකින් වැලි වළට පැන්නාය.",
            presentEnglish = "Long jumpers measure their run-up accurately.",
            presentSinhala = "දුර පනින්නෝ තම දිවීමේ පියවර නිවැරදිව මනිති.",
            futureEnglish = "She will jump farther than her previous mark.",
            futureSinhala = "ඇය පෙර සලකුණට වඩා දුර පනිනු ඇත.",
            verbTransformation = "leaped → measure → will jump"
          ),
          TenseSentenceItem(
            id = "t7_s12",
            baseActionSinhala = "වොලිබෝල් ක්‍රීඩාව",
            pastEnglish = "Our national sport team smashed the volleyball over net.",
            pastSinhala = "අපේ ජාතික ක්‍රීඩා කණ්ඩායම දැලට ඉහළින් වොලිබෝල් පන්දුවට ගැසූහ.",
            presentEnglish = "Volleyball requires swift teamwork and stamina.",
            presentSinhala = "වොලිබෝල් ක්‍රීඩාවට කඩිනම් කණ්ඩායම් හැඟීම සහ කායශක්තිය අවශ්‍ය වේ.",
            futureEnglish = "They will host the inter-provincial tournament.",
            futureSinhala = "ඔවුහු අන්තර් පළාත් තරගාවලියට සත්කාරකත්වය දක්වනු ඇත.",
            verbTransformation = "smashed → requires → will host"
          ),
          TenseSentenceItem(
            id = "t7_s13",
            baseActionSinhala = "ශරීරය උණුසුම් කරගැනීම (Warm-up)",
            pastEnglish = "We stretched our muscles before the race.",
            pastSinhala = "තරගයට පෙර අපි අපේ මාංශ පේශි ඇද උණුසුම් කර ගත්තෙමු.",
            presentEnglish = "Warming up prevents sports injuries.",
            presentSinhala = "ශරීරය උණුසුම් කරගැනීම ක්‍රීඩා ආබාධ වළක්වයි.",
            futureEnglish = "The coach will demonstrate warmup routines.",
            futureSinhala = "පුහුණුකරු උණුසුම් කිරීමේ ව්‍යායාම පෙන්වා දෙනු ඇත.",
            verbTransformation = "stretched → prevents → will demonstrate"
          ),
          TenseSentenceItem(
            id = "t7_s14",
            baseActionSinhala = "දඬුවම් පහර නැවැත්වීම (Goalkeeping)",
            pastEnglish = "The goalie caught the fast-moving ball.",
            pastSinhala = "ගෝල් රකින්නා වේගයෙන් ආ පන්දුව අල්ලා ගත්තේය.",
            presentEnglish = "Goalkeepers dive courageously to save goals.",
            presentSinhala = "ගෝල රකින්නෝ ගෝල බේරා ගැනීමට නිර්භීතව පනිති.",
            futureEnglish = "He will block the penalty kick successfully.",
            futureSinhala = "ඔහු සාර්ථකව දඬුවම් පහර වළක්වනු ඇත.",
            verbTransformation = "caught → dive → will block"
          ),
          TenseSentenceItem(
            id = "t7_s15",
            baseActionSinhala = "කඹ ඇදීම",
            pastEnglish = "Our house pulled the rope with full strength.",
            pastSinhala = "අපේ නිවාසය පූර්ණ ශක්තියෙන් කඹය ඇද්දේය.",
            presentEnglish = "Tug-of-war demands collective physical grit.",
            presentSinhala = "කඹ ඇදීමට සාමූහික ශාරීරික ධෛර්යය අවශ්‍ය වේ.",
            futureEnglish = "We will win the final round decisively.",
            futureSinhala = "අපි අවසන් වටය තීරණාත්මක ලෙස ජයගන්නෙමු.",
            verbTransformation = "pulled → demands → will win"
          ),
          TenseSentenceItem(
            id = "t7_s16",
            baseActionSinhala = "කැරම් ගැසීම",
            pastEnglish = "Grandfather pocketed the red queen coin.",
            pastSinhala = "සීයා රතු රැජින ඉත්තා සාර්ථකව පොකට් කළේය.",
            presentEnglish = "Carrom players calculate carrom rebounds smartly.",
            presentSinhala = "කැරම් ක්‍රීඩකයෝ ඉත්තන් ආපසු එන කෝණ බුද්ධිමත්ව ගණනය කරති.",
            futureEnglish = "I will play carrom with cousins tonight.",
            futureSinhala = "මම අද රෑ නෑදෑ සහෝදරයන් සමඟ කැරම් ගසන්නෙමි.",
            verbTransformation = "pocketed → calculate → will play"
          ),
          TenseSentenceItem(
            id = "t7_s17",
            baseActionSinhala = "චෙස් (දෙබස) ක්‍රීඩා කිරීම",
            pastEnglish = "She defeated the opponent with checkmate.",
            pastSinhala = "ඇය ප්‍රතිවාදියා 'චෙක්මේට්' කර පරාජය කළාය.",
            presentEnglish = "Chess sharpens strategic foresight and patience.",
            presentSinhala = "චෙස් ක්‍රීඩාව උපායමාර්ගික දැක්ම සහ ඉවසීම තියුණු කරයි.",
            futureEnglish = "She will play in the school chess team.",
            futureSinhala = "ඇය පාසල් චෙස් කණ්ඩායමේ ක්‍රීඩා කරනු ඇත.",
            verbTransformation = "defeated → sharpens → will play"
          ),
          TenseSentenceItem(
            id = "t7_s18",
            baseActionSinhala = "මේස පන්දු (Table Tennis)",
            pastEnglish = "He served a fast spinning ping-pong ball.",
            pastSinhala = "ඔහු වේගවත් කැරකැවෙන පිං-පොං පන්දුවක් සර්ව් කළේය.",
            presentEnglish = "Table tennis builds lightning-fast reflexes.",
            presentSinhala = "මේස පන්දු ක්‍රීඩාව විදුලි වේග ප්‍රතික්‍රියා ගොඩනඟයි.",
            futureEnglish = "He will rally against the defending champion.",
            futureSinhala = "ඔහු වත්මන් ශූරයාට එරෙහිව තරග කරනු ඇත.",
            verbTransformation = "served → builds → will rally"
          ),
          TenseSentenceItem(
            id = "t7_s19",
            baseActionSinhala = "පුහුණුකරුගේ උපදෙස් පිළිපැදීම",
            pastEnglish = "The team followed the coach's master plan.",
            pastSinhala = "කණ්ඩායම පුහුණුකරුගේ ප්‍රධාන සැලසුම පිළිපැද්දේය.",
            presentEnglish = "Athletes respect disciplinary guidelines strictly.",
            presentSinhala = "ක්‍රීඩකයෝ විනය මාර්ගෝපදේශ දැඩි ලෙස පිළිපදිති.",
            futureEnglish = "The coach will praise their tremendous effort.",
            futureSinhala = "පුහුණුකරු ඔවුන්ගේ දැවැන්ත උත්සාහය අගය කරනු ඇත.",
            verbTransformation = "followed → respect → will praise"
          ),
          TenseSentenceItem(
            id = "t7_s20",
            baseActionSinhala = "සමබර ආහාර වේලක් ගැනීම",
            pastEnglish = "The athlete drank plenty of hydration fluids.",
            pastSinhala = "ක්‍රීඩකයා ප්‍රමාණවත් තරම් ජලීය තරල බීවේය.",
            presentEnglish = "Nutritious protein meals rebuild muscle fibers.",
            presentSinhala = "පෝෂ්‍යදායී ප්‍රෝටීන් ආහාර මාංශ පේශි නැවත ගොඩනඟයි.",
            futureEnglish = "He will maintain peak fitness throughout season.",
            futureSinhala = "ඔහු තරග වාරය පුරාම ඉහළම ශාරීරික යෝග්‍යතාවය පවත්වා ගනු ඇත.",
            verbTransformation = "drank → rebuild → will maintain"
          ),
          TenseSentenceItem(
            id = "t7_s21",
            baseActionSinhala = "විසිල් හඬ නැගීම (විනිසුරු)",
            pastEnglish = "The referee blew his whistle to end match.",
            pastSinhala = "තරගය අවසන් කිරීමට විනිසුරු විසිල් පිඹියේය.",
            presentEnglish = "Referees enforce rules fairly on the field.",
            presentSinhala = "විනිසුරුවෝ පිටියේදී සාධාරණව නීති බලාත්මක කරති.",
            futureEnglish = "The referee will inspect the pitch before kickoff.",
            futureSinhala = "තරගය ඇරඹීමට පෙර විනිසුරු ක්‍රීඩා පිටිය පරීක්ෂා කරනු ඇත.",
            verbTransformation = "blew → enforce → will inspect"
          ),
          TenseSentenceItem(
            id = "t7_s22",
            baseActionSinhala = "ප්‍රේක්ෂකයින් ඔල්වරසන් දීම",
            pastEnglish = "The crowd cheered wildly for the winning goal.",
            pastSinhala = "ජයග්‍රාහී ගෝලයට ප්‍රේක්ෂකාගාරය මහත් හඬින් ඔල්වරසන් දුන්නේය.",
            presentEnglish = "Fans wave colorful flags in stadiums.",
            presentSinhala = "ප්‍රේක්ෂකයෝ ක්‍රීඩාංගණවල වර්ණවත් ධජ වනති.",
            futureEnglish = "Spectators will applaud every outstanding performance.",
            futureSinhala = "ප්‍රේක්ෂකයෝ සෑම විශිෂ්ට දක්ෂතාවයකටම අත්පොළසන් දෙනු ඇත.",
            verbTransformation = "cheered → wave → will applaud"
          ),
          TenseSentenceItem(
            id = "t7_s23",
            baseActionSinhala = "ප්‍රතිවාදීන්ට අතට අත දීම",
            pastEnglish = "Players shook hands after intense contest.",
            pastSinhala = "දැඩි තරගයෙන් පසු ක්‍රීඩකයෝ එකිනෙකාට අතට අත දුන්හ.",
            presentEnglish = "True sportsmanship values mutual respect over victory.",
            presentSinhala = "සැබෑ ක්‍රීඩාශීලීත්වය ජයග්‍රහණයට වඩා අන්‍යෝන්‍ය ගෞරවය අගය කරයි.",
            futureEnglish = "Both teams will exchange jerseys peacefully.",
            futureSinhala = "කණ්ඩායම් දෙකම සුහදව ජර්සි හුවමාරු කරගනු ඇත.",
            verbTransformation = "shook → values → will exchange"
          ),
          TenseSentenceItem(
            id = "t7_s24",
            baseActionSinhala = "පදක්කම් දිනාගැනීම",
            pastEnglish = "She clinched the gold medal in marathon.",
            pastSinhala = "ඇය මැරතන් තරගයෙන් රන් පදක්කම දිනාගත්තාය.",
            presentEnglish = "Dedicated champions train relentlessly for glory.",
            presentSinhala = "කැපවූ ශූරයෝ කීර්තිය වෙනුවෙන් නොනවත්වා පුහුණු වෙති.",
            futureEnglish = "She will step onto the victory podium proudly.",
            futureSinhala = "ඇය අභිමානයෙන් ජයග්‍රාහී පීඨිකාව මතට පා තබනු ඇත.",
            verbTransformation = "clinched → train → will step"
          ),
          TenseSentenceItem(
            id = "t7_s25",
            baseActionSinhala = "යෝග අභ්‍යාස කිරීම",
            pastEnglish = "We did deep breathing yoga poses.",
            pastSinhala = "අපි ගැඹුරු හුස්ම ගැනීමේ යෝග ඉරියව් කළෙමු.",
            presentEnglish = "Yoga enhances mental balance and bodily flexibility.",
            presentSinhala = "යෝග මගින් මානසික සමබරතාවය සහ ශරීරයේ නම්‍යශීලීභාවය වැඩි කරයි.",
            futureEnglish = "We will practice meditation at sunrise.",
            futureSinhala = "අපි හිරු උදාවේදී භාවනා පුහුණු වන්නෙමු.",
            verbTransformation = "did → enhances → will practice"
          ),
          TenseSentenceItem(
            id = "t7_s26",
            baseActionSinhala = "බැස්කට්බෝල් ක්‍රීඩාව",
            pastEnglish = "He bounced the basketball and dunked.",
            pastSinhala = "ඔහු පැසිපන්දුව බිම ගසා කූඩයට දැමුවේය.",
            presentEnglish = "Basketball players dribble across the wooden court.",
            presentSinhala = "පැසිපන්දු ක්‍රීඩකයෝ ලී තට්ටුව මත පන්දුව ඩ්‍රිබ්ල් කරති.",
            futureEnglish = "He will shoot a three-pointer in the buzzer round.",
            futureSinhala = "ඔහු අවසන් තත්පරයේදී ලකුණු තුනේ පහරක් එල්ල කරනු ඇත.",
            verbTransformation = "bounced → dribble → will shoot"
          ),
          TenseSentenceItem(
            id = "t7_s27",
            baseActionSinhala = "තුවාලයකින් සුවය ලැබීම",
            pastEnglish = "The bowler rested his sprained ankle for two weeks.",
            pastSinhala = "පන්දු යවන්නා උළුක්කු වූ වළලුකර සති දෙකක් විවේක ගැන්වීය.",
            presentEnglish = "Physiotherapy heals muscular sprains safely.",
            presentSinhala = "භෞතචිකිත්සාව මඟින් මාංශ පේශි ආබාධ ආරක්ෂිතව සුව කරයි.",
            futureEnglish = "He will return to active bowling next month.",
            futureSinhala = "ඔහු ලබන මස නැවත පන්දු යැවීමට පැමිණෙනු ඇත.",
            verbTransformation = "rested → heals → will return"
          ),
          TenseSentenceItem(
            id = "t7_s28",
            baseActionSinhala = "ක්‍රීඩා ඇඳුම් පැළඳීම",
            pastEnglish = "I laced my spikes tightly before the track event.",
            pastSinhala = "ධාවන තරගයට පෙර මම ස්පයික් සපත්තු තදින් ගැට ගැසුවෙමි.",
            presentEnglish = "Breathable sportswear keeps athletes cool and dry.",
            presentSinhala = "සුවපහසු ක්‍රීඩා ඇඳුම් ක්‍රීඩකයින් සිසිල්ව සහ වියළිව තබයි.",
            futureEnglish = "I will wear school sports kit tomorrow.",
            futureSinhala = "මම හෙට පාසල් ක්‍රීඩා කට්ටලය පළඳින්නෙමි.",
            verbTransformation = "laced → keeps → will wear"
          ),
          TenseSentenceItem(
            id = "t7_s29",
            baseActionSinhala = "ශූරතා කුසලානය එසවීම",
            pastEnglish = "The captain lifted the championship cup in joy.",
            pastSinhala = "නායකයා ප්‍රීතියෙන් ශූරතා කුසලානය එසවීය.",
            presentEnglish = "Trophies symbolize hard work and discipline.",
            presentSinhala = "කුසලාන මඟින් වෙහෙස මහන්සි වී වැඩ කිරීම සහ විනය සංකේතවත් කරයි.",
            futureEnglish = "The team will parade the trophy around town.",
            futureSinhala = "කණ්ඩායම නගරය පුරා කුසලානය රැගෙන පෙළපාලි යනු ඇත.",
            verbTransformation = "lifted → symbolize → will parade"
          ),
          TenseSentenceItem(
            id = "t7_s30",
            baseActionSinhala = "නිරෝගී දිවිපෙවෙතක් ගතකිරීම",
            pastEnglish = "Daily exercises transformed my overall health.",
            pastSinhala = "දෛනික ව්‍යායාම මගේ සමස්ත සෞඛ්‍යය පරිවර්තනය කළේය.",
            presentEnglish = "Physical fitness brings longevity and inner happiness.",
            presentSinhala = "ශාරීරික යෝග්‍යතාවය දීර්ඝායුෂ සහ අභ්‍යන්තර සතුට ගෙන දෙයි.",
            futureEnglish = "We will maintain healthy sporting habits for life.",
            futureSinhala = "අපි ජීවිත කාලය පුරාම නිරෝගී ක්‍රීඩා පුරුදු පවත්වා ගන්නෙමු.",
            verbTransformation = "transformed → brings → will maintain"
          )
        )
      ),

      // ==========================================
      // Category 8: සංගීතය, චිත්‍ර සහ විනෝදාංශ (Music, Arts & Hobbies) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 8,
        titleSinhala = "කාණ්ඩය 08: සංගීතය, චිත්‍ර සහ විනෝදාංශ",
        titleEnglish = "Music, Visual Arts & Creative Hobbies",
        icon = "🎨",
        description = "ගිටාර් වාදනය, චිත්‍ර ඇඳීම, ගෙවතු වගාව, ඡායාරූපකරණය සහ ගායනය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t8_s1",
            baseActionSinhala = "ගිටාරය වාදනය කිරීම",
            pastEnglish = "Nimal played a soothing acoustic guitar melody.",
            pastSinhala = "නිමල් සන්සුන් ගිටාර් තනුවක් වාදනය කළේය.",
            presentEnglish = "Nimal plays chords on his Spanish guitar.",
            presentSinhala = "නිමල් ඔහුගේ ස්පාඤ්ඤ ගිටාරයේ කෝඩ්ස් වාදනය කරයි.",
            futureEnglish = "Nimal will play at the school talent concert.",
            futureSinhala = "නිමල් පාසල් කුසලතා ප්‍රසංගයේදී වාදනය කරනු ඇත.",
            verbTransformation = "played → plays → will play"
          ),
          TenseSentenceItem(
            id = "t8_s2",
            baseActionSinhala = "දිය සායම් චිත්‍ර ඇඳීම",
            pastEnglish = "She painted a scenic sunset using watercolors.",
            pastSinhala = "ඇය දියසායම් භාවිතයෙන් සුන්දර හිරු බැසයාමක චිත්‍රයක් ඇන්දාය.",
            presentEnglish = "She paints vibrant landscape portraits with ease.",
            presentSinhala = "ඇය ඉතා පහසුවෙන් සජීවී භූ දර්ශන චිත්‍ර අඳියි.",
            futureEnglish = "She will paint the ancient Dalada Maligawa.",
            futureSinhala = "ඇය ඓතිහාසික දළදා මාළිගාව චිත්‍රයට නගනු ඇත.",
            verbTransformation = "painted → paints → will paint"
          ),
          TenseSentenceItem(
            id = "t8_s3",
            baseActionSinhala = "මිහිරි ගීතයක් ගායනා කිරීම",
            pastEnglish = "Amali sang a traditional Sinhala folk song.",
            pastSinhala = "අමාලි සාම්ප්‍රදායික සිංහල ජන ගීයක් ගැයුවාය.",
            presentEnglish = "Amali sings classical ragas with pitch accuracy.",
            presentSinhala = "අමාලි ශාස්ත්‍රීය රාග ඉතා නිවැරදි ස්වරයෙන් ගයයි.",
            futureEnglish = "Amali will sing the opening devotional song.",
            futureSinhala = "අමාලි සමාරම්භක භක්ති ගීතය ගායනා කරනු ඇත.",
            verbTransformation = "sang → sings → will sing"
          ),
          TenseSentenceItem(
            id = "t8_s4",
            baseActionSinhala = "තබ්ලාව හෝ බෙර වාදනය",
            pastEnglish = "The drummer beat the Kandyan geta beraya rhythmically.",
            pastSinhala = "බෙර වාදකයා ගැටබෙරය රිද්මයානුකූලව වාදනය කළේය.",
            presentEnglish = "Master drummers create intricate tempo rhythms.",
            presentSinhala = "ප්‍රවීණ බෙර වාදකයෝ සියුම් ලය රිද්ම නිර්මාණය කරති.",
            futureEnglish = "He will accompany the dancers during the pageant.",
            futureSinhala = "පෙරහැරේදී ඔහු නර්තන ශිල්පීන්ට බෙර වාදනයෙන් සහය වනු ඇත.",
            verbTransformation = "beat → create → will accompany"
          ),
          TenseSentenceItem(
            id = "t8_s5",
            baseActionSinhala = "ඡායාරූප ගැනීම",
            pastEnglish = "I took stunning photographs of rare wild birds.",
            pastSinhala = "මම දුර්ලභ වනගත පක්ෂීන්ගේ විශ්මයජනක ඡායාරූප ගත්තෙමි.",
            presentEnglish = "I capture scenic nature moments with my camera.",
            presentSinhala = "මම මගේ කැමරාවෙන් සුන්දර සොබාදහමේ අවස්ථා ඡායාරූපගත කරමි.",
            futureEnglish = "I will photograph the annual historic Esala Perahera.",
            futureSinhala = "මම වාර්ෂික ඓතිහාසික ඇසළ පෙරහැර ඡායාරූපගත කරන්නෙමි.",
            verbTransformation = "took → capture → will photograph"
          ),
          TenseSentenceItem(
            id = "t8_s6",
            baseActionSinhala = "මුද්දර එකතු කිරීම",
            pastEnglish = "Uncle gifted me twenty vintage postage stamps.",
            pastSinhala = "මාමා මට පැරණි තැපැල් මුද්දර විස්සක් තෑගි කළේය.",
            presentEnglish = "Philatelists collect rare international stamps systematically.",
            presentSinhala = "මුද්දර ලෝලීහු දුර්ලභ ජාත්‍යන්තර මුද්දර ක්‍රමානුකූලව එකතු කරති.",
            futureEnglish = "I will paste them into my commemorative stamp album.",
            futureSinhala = "මම ඒවා මගේ මුද්දර ඇල්බමයේ අලවන්නෙමි.",
            verbTransformation = "gifted → collect → will paste"
          ),
          TenseSentenceItem(
            id = "t8_s7",
            baseActionSinhala = "ගෙවතු වගාව",
            pastEnglish = "Grandmother planted organic tomato and chili seeds.",
            pastSinhala = "මිත්තණිය කාබනික තක්කාලි සහ මිරිස් ඇට සිටුවාය.",
            presentEnglish = "She tends to lush kitchen vegetables lovingly.",
            presentSinhala = "ඇය ආදරයෙන් සරුසාර ගෙවතු එළවළු රැකබලා ගනියි.",
            futureEnglish = "She will harvest sweet papayas next week.",
            futureSinhala = "ඇය ලබන සතියේ මිහිරි ගස්ලබු අස්වැන්න නෙළා ගනු ඇත.",
            verbTransformation = "planted → tends → will harvest"
          ),
          TenseSentenceItem(
            id = "t8_s8",
            baseActionSinhala = "ලී කැටයම් කැපීම",
            pastEnglish = "The artisan carved an elephant figurine out of teak.",
            pastSinhala = "ශිල්පියා තේක්ක ලීයෙන් අලි පිළිමයක් කැටයම් කළේය.",
            presentEnglish = "Traditional artisans carve intricate wooden masks.",
            presentSinhala = "සාම්ප්‍රදායික ශිල්පීහු සියුම් ලී වෙස්මුහුණු කැටයම් කරති.",
            futureEnglish = "He will display his sculptures at the art expo.",
            futureSinhala = "ඔහු තම ප්‍රතිමා කලා ප්‍රදර්ශනයේ ප්‍රදර්ශනය කරනු ඇත.",
            verbTransformation = "carved → carve → will display"
          ),
          TenseSentenceItem(
            id = "t8_s9",
            baseActionSinhala = "මැටි බඳුන් සෑදීම",
            pastEnglish = "The potter molded a symmetrical clay vessel.",
            pastSinhala = "කුඹල්කරුවා සමමිතික මැටි බඳුනක් හැඩගැස්වීය.",
            presentEnglish = "Potters spin the wheel to craft clay pots.",
            presentSinhala = "කුඹල්කරුවෝ මැටි වළං සෑදීමට රෝදය කරකවති.",
            futureEnglish = "He will bake decorative terra-cotta vases in the kiln.",
            futureSinhala = "ඔහු පෝරණුව තුළ අලංකාර මැටි බඳුන් පුළුස්සනු ඇත.",
            verbTransformation = "molded → spin → will bake"
          ),
          TenseSentenceItem(
            id = "t8_s10",
            baseActionSinhala = "නැටුම් පුහුණුවීම",
            pastEnglish = "The dancers practiced Kandyan steps for three hours.",
            pastSinhala = "නර්තන ශිල්පීහු පැය තුනක් උඩරට නැටුම් පියවර පුහුණු වූහ.",
            presentEnglish = "Traditional dancers perform with grace and balance.",
            presentSinhala = "සාම්ප්‍රදායික නැට්ටුවෝ ලාලිත්‍යයෙන් සහ සමබරතාවයෙන් නටති.",
            futureEnglish = "They will showcase Ves dance in the temple pageant.",
            futureSinhala = "ඔවුහු විහාරස්ථාන පෙරහැරේ වෙස් නැටුම් ප්‍රදර්ශනය කරනු ඇත.",
            verbTransformation = "practiced → perform → will showcase"
          ),
          TenseSentenceItem(
            id = "t8_s11",
            baseActionSinhala = "වයලීනය වාදනය",
            pastEnglish = "The maestro played an emotional violin solo.",
            pastSinhala = "ප්‍රවීණ වාදකයා හැඟීම්බර වයලීන වාදනයක් ඉදිරිපත් කළේය.",
            presentEnglish = "Violin strings produce rich expressive musical tones.",
            presentSinhala = "වයලීන තත් මගින් ගැඹුරු ප්‍රකාශනාත්මක සංගීත ස්වර නිපදවයි.",
            futureEnglish = "He will lead the school symphony orchestra.",
            futureSinhala = "ඔහු පාසල් වාද්‍ය වෘන්දයට නායකත්වය දෙනු ඇත.",
            verbTransformation = "played → produce → will lead"
          ),
          TenseSentenceItem(
            id = "t8_s12",
            baseActionSinhala = "ගෙතුම් වැඩ (Knitting)",
            pastEnglish = "Mother knitted a warm woolen sweater for baby.",
            pastSinhala = "අම්මා බබා වෙනුවෙන් උණුසුම් ලොම් ස්වීටරයක් ගෙතුවාය.",
            presentEnglish = "She knits decorative patterns using knitting needles.",
            presentSinhala = "ඇය ගෙතුම් කටු භාවිතයෙන් අලංකාර රටා ගොතයි.",
            futureEnglish = "She will knit cozy gloves before winter.",
            futureSinhala = "ඇය සීතල සමයට පෙර උණුසුම් අත්වැසුම් ගොතනු ඇත.",
            verbTransformation = "knitted → knits → will knit"
          ),
          TenseSentenceItem(
            id = "t8_s13",
            baseActionSinhala = "පැන්සල් සිතුවම් ඇඳීම",
            pastEnglish = "He sketched a realistic portrait of his father.",
            pastSinhala = "ඔහු ඔහුගේ පියාගේ සජීවී පැන්සල් සිතුවමක් ඇන්දේය.",
            presentEnglish = "Pencil sketches highlight shadows and lighting contrast.",
            presentSinhala = "පැන්සල් සිතුවම් සෙවනැලි සහ ආලෝක වෙනස්කම් ඉස්මතු කරයි.",
            futureEnglish = "He will draw historical monuments of Polonnaruwa.",
            futureSinhala = "ඔහු පොළොන්නරුවේ ඓතිහාසික ස්මාරක සිතුවම් කරනු ඇත.",
            verbTransformation = "sketched → highlight → will draw"
          ),
          TenseSentenceItem(
            id = "t8_s14",
            baseActionSinhala = "නාට්‍යයක රඟපෑම",
            pastEnglish = "Kasun acted the king's role brilliantly on stage.",
            pastSinhala = "කසුන් වේදිකාවේ රජුගේ චරිතය විශිෂ්ට ලෙස රඟපෑවේය.",
            presentEnglish = "Actors rehearse expressive lines before the show.",
            presentSinhala = "නළුවෝ සංදර්ශනයට පෙර හැඟීම්බර දෙබස් පෙරහුරු කරති.",
            futureEnglish = "Our drama troupe will compete in the state drama fest.",
            futureSinhala = "අපගේ නාට්‍ය කණ්ඩායම රාජ්‍ය නාට්‍ය උළෙලේ තරග කරනු ඇත.",
            verbTransformation = "acted → rehearse → will compete"
          ),
          TenseSentenceItem(
            id = "t8_s15",
            baseActionSinhala = "ඔරිගාමි (කඩදාසි නිර්මාණ)",
            pastEnglish = "The children folded paper into colorful origami cranes.",
            pastSinhala = "ළමයි කඩදාසි නමා වර්ණවත් කොකුන් නිර්මාණය කළෝය.",
            presentEnglish = "Origami develops delicate finger coordination.",
            presentSinhala = "ඔරිගාමි මගින් සියුම් ඇඟිලි සම්බන්ධීකරණය වර්ධනය කරයි.",
            futureEnglish = "They will make paper flowers for teacher's day.",
            futureSinhala = "ගුරු දිනය සඳහා ඔවුහු කඩදාසි මල් සාදනු ඇත.",
            verbTransformation = "folded → develops → will make"
          ),
          TenseSentenceItem(
            id = "t8_s16",
            baseActionSinhala = "කාසි එකතු කිරීම",
            pastEnglish = "Grandpa preserved ancient Dutch and British coins.",
            pastSinhala = "සීයා පැරණි ලන්දේසි සහ බ්‍රිතාන්‍ය කාසි ආරක්ෂා කර තැබුවේය.",
            presentEnglish = "Numismatists study historical coinage.",
            presentSinhala = "කාසි එකතු කරන්නෝ ඓතිහාසික කාසි පිළිබඳ අධ්‍යයනය කරති.",
            futureEnglish = "I will showcase my coin collection at school fair.",
            futureSinhala = "පාසල් ප්‍රදර්ශනයේදී මම මගේ කාසි එකතුව ප්‍රදර්ශනය කරන්නෙමි.",
            verbTransformation = "preserved → study → will showcase"
          ),
          TenseSentenceItem(
            id = "t8_s17",
            baseActionSinhala = "පැරණි ගීත ඇසීම",
            pastEnglish = "We listened to classic radio songs of Amaradeva.",
            pastSinhala = "අපි අමරදේවයන්ගේ සම්භාව්‍ය ගුවන්විදුලි ගීතවලට සවන් දුන්නෙමු.",
            presentEnglish = "Melodious songs bring tranquility to soul.",
            presentSinhala = "මිහිරි ගීත මනසට හා ආත්මයට සන්සුන් බව ගෙන දෙයි.",
            futureEnglish = "We will attend the acoustic live unplugged concert.",
            futureSinhala = "අපි සජීවී සංගීත ප්‍රසංගයට සහභාගී වන්නෙමු.",
            verbTransformation = "listened → bring → will attend"
          ),
          TenseSentenceItem(
            id = "t8_s18",
            baseActionSinhala = "වීඩියෝ සංස්කරණය",
            pastEnglish = "He edited a short travel documentary on Sigiriya.",
            pastSinhala = "ඔහු සීගිරිය පිළිබඳ කෙටි සංචාරක වාර්තා චිත්‍රපටයක් සංස්කරණය කළේය.",
            presentEnglish = "Digital creators produce educational tutorials online.",
            presentSinhala = "ඩිජිටල් නිර්මාණකරුවෝ අන්තර්ජාලය හරහා අධ්‍යාපනික වීඩියෝ නිෂ්පාදනය කරති.",
            futureEnglish = "He will upload his film to the international youth festival.",
            futureSinhala = "ඔහු ජාත්‍යන්තර තරුණ උළෙලට තම නිර්මාණය උඩුගත කරනු ඇත.",
            verbTransformation = "edited → produce → will upload"
          ),
          TenseSentenceItem(
            id = "t8_s19",
            baseActionSinhala = "පොත් බැඳීම (Bookbinding)",
            pastEnglish = "The craftsman bound the damaged manuscript with leather.",
            pastSinhala = "ශිල්පියා හානි වූ පැරණි අත්පිටපත සම් කවරයකින් බැන්දේය.",
            presentEnglish = "Careful bookbinding preserves rare heritage literature.",
            presentSinhala = "ප්‍රවේශමෙන් පොත් බැඳීම මඟින් දුර්ලභ උරුම සාහිත්‍යය සුරකියි.",
            futureEnglish = "He will restore the century-old temple chronicle.",
            futureSinhala = "ඔහු සියවසක් පැරණි විහාර වංශකතාව ප්‍රතිසංස්කරණය කරනු ඇත.",
            verbTransformation = "bound → preserves → will restore"
          ),
          TenseSentenceItem(
            id = "t8_s20",
            baseActionSinhala = "පියානෝ වාදනය",
            pastEnglish = "She played Beethoven's Fur Elise on grand piano.",
            pastSinhala = "ඇය ප්‍රධාන පියානෝවේ බීතෝවන්ගේ 'Fur Elise' වාදනය කළාය.",
            presentEnglish = "Pianists coordinate both hands with precision.",
            presentSinhala = "පියානෝ වාදකයෝ දෑත් දෙකම ඉතා නිවැරදිව හසුරුවති.",
            futureEnglish = "She will perform at the national music academy.",
            futureSinhala = "ඇය ජාතික සංගීත ඇකඩමියේදී වාදනය ඉදිරිපත් කරනු ඇත.",
            verbTransformation = "played → coordinate → will perform"
          ),
          TenseSentenceItem(
            id = "t8_s21",
            baseActionSinhala = "මල් මාලා ගෙතීම",
            pastEnglish = "Women wove fragrant jasmine garlands for the puja.",
            pastSinhala = "කාන්තාවෝ පූජාව සඳහා සුවඳැති පිච්ච මල් මාලා ගෙතුවෝය.",
            presentEnglish = "Floral garlands adorn holy statues gracefully.",
            presentSinhala = "මල් මාලා ශුද්ධ ප්‍රතිමා අලංකාරවත් ලෙස සරසයි.",
            futureEnglish = "They will make lotus garlands for Vesak celebration.",
            futureSinhala = "ඔවුහු වෙසක් උත්සවය සඳහා නෙළුම් මල් මාලා සාදනු ඇත.",
            verbTransformation = "wove → adorn → will make"
          ),
          TenseSentenceItem(
            id = "t8_s22",
            baseActionSinhala = "අත්කම් නිර්මාණ",
            pastEnglish = "Students crafted miniature reed baskets.",
            pastSinhala = "සිසුහු බට පතුරු වලින් කුඩා කූඩ නිර්මාණය කළහ.",
            presentEnglish = "Eco-friendly handicrafts promote sustainable living.",
            presentSinhala = "පරිසර හිතකාමී අත්කම් නිර්මාණ තිරසාර ජීවන රටාව ප්‍රවර්ධනය කරයි.",
            futureEnglish = "They will sell handmade crafts at charity bazaar.",
            futureSinhala = "ඔවුහු පුණ්‍යාධාර පොළේදී අතින් සාදන ලද භාණ්ඩ අලෙවි කරනු ඇත.",
            verbTransformation = "crafted → promote → will sell"
          ),
          TenseSentenceItem(
            id = "t8_s23",
            baseActionSinhala = "සුනඛයින් පුහුණු කිරීම",
            pastEnglish = "He trained our pet dog to fetch the tennis ball.",
            pastSinhala = "ඔහු ටෙනිස් පන්දුව රැගෙන ඒමට සුරතල් බල්ලා පුහුණු කළේය.",
            presentEnglish = "Patient training reinforces positive pet behavior.",
            presentSinhala = "ඉවසිලිවන්ත පුහුණුව සුරතලුන්ගේ යහපත් හැසිරීම් වර්ධනය කරයි.",
            futureEnglish = "The dog will follow all basic obedience commands.",
            futureSinhala = "බල්ලා සියලුම මූලික කීකරුකමේ විධානයන් අනුගමනය කරනු ඇත.",
            verbTransformation = "trained → reinforces → will follow"
          ),
          TenseSentenceItem(
            id = "t8_s24",
            baseActionSinhala = "කුරුලු නිරීක්ෂණය (Bird Watching)",
            pastEnglish = "We observed the rare blue magpie through binoculars.",
            pastSinhala = "අපි දුරදක්නයෙන් දුර්ලභ කැහිබෙල්ලා නිරීක්ෂණය කළෙමු.",
            presentEnglish = "Birdwatchers record bird migrations at Bundala.",
            presentSinhala = "පක්ෂි නිරීක්ෂකයෝ බූන්දලදී පක්ෂි සංක්‍රමණ සටහන් කර ගනිති.",
            futureEnglish = "We will explore Sinharaja rainforest sanctuary.",
            futureSinhala = "අපි සිංහරාජ වැසි වනාන්තර අභයභූමිය ගවේෂණය කරන්නෙමු.",
            verbTransformation = "observed → record → will explore"
          ),
          TenseSentenceItem(
            id = "t8_s25",
            baseActionSinhala = "සුළං රෝද හෝ සරුංගල් යැවීම",
            pastEnglish = "Children flew huge colorful kites on Galle Face Green.",
            pastSinhala = "ගාලු මුවදොර පිටියේදී ළමයි විශාල වර්ණවත් සරුංගල් යැවූහ.",
            presentEnglish = "Sea breeze lifts kites high into blue skies.",
            presentSinhala = "මුහුදු සුළඟ සරුංගල් නිල් අහස උසට ඔසවයි.",
            futureEnglish = "We will participate in the kite festival this August.",
            futureSinhala = "අපි මේ අගෝස්තු මාසයේ සරුංගල් උළෙලට සහභාගී වන්නෙමු.",
            verbTransformation = "flew → lifts → will participate"
          ),
          TenseSentenceItem(
            id = "t8_s26",
            baseActionSinhala = "රූකඩ නැටුම් (Puppetry)",
            pastEnglish = "Puppeteers staged an ancient folk folktale in Ambalangoda.",
            pastSinhala = "රූකඩ ශිල්පීහු අම්බලන්ගොඩදී පැරණි ජනකතාවක් වේදිකාගත කළහ.",
            presentEnglish = "Traditional string puppets preserve Sri Lankan folklore.",
            presentSinhala = "සාම්ප්‍රදායික නූල් රූකඩ ශ්‍රී ලාංකික ජනප්‍රවාද සුරකියි.",
            futureEnglish = "They will perform overseas in cultural exchange tour.",
            futureSinhala = "සංස්කෘතික හුවමාරු චාරිකාවකදී ඔවුහු විදේශයන්හි රඟදක්වනු ඇත.",
            verbTransformation = "staged → preserve → will perform"
          ),
          TenseSentenceItem(
            id = "t8_s27",
            baseActionSinhala = "කැලිග්‍රැෆි (අලංකාර අකුරු කලාව)",
            pastEnglish = "She practiced Gothic calligraphy with ink pen.",
            pastSinhala = "ඇය තීන්ත පෑනකින් ගොතික් කැලිග්‍රැෆි අකුරු ලිවීම පුහුණු වූවාය.",
            presentEnglish = "Calligraphy transforms handwriting into visual art.",
            presentSinhala = "කැලිග්‍රැෆි අත්අකුරු දෘශ්‍ය කලාවක් බවට පරිවර්තනය කරයි.",
            futureEnglish = "She will design wedding invitation scrolls.",
            futureSinhala = "ඇය මංගල ආරාධනා පත්‍ර සැලසුම් කරනු ඇත.",
            verbTransformation = "practiced → transforms → will design"
          ),
          TenseSentenceItem(
            id = "t8_s28",
            baseActionSinhala = "චිත්‍ර ප්‍රදර්ශනයක් නැරඹීම",
            pastEnglish = "We visited Lionel Wendt art gallery yesterday.",
            pastSinhala = "අපි ඊයේ ලයනල් වෙන්ඩ්ට් කලාගාරය නැරඹුවෙමු.",
            presentEnglish = "Art exhibitions ignite creative thinking in youth.",
            presentSinhala = "කලා ප්‍රදර්ශන තරුණ මනස්වල නිර්මාණාත්මක චින්තනය අවුලුවයි.",
            futureEnglish = "We will attend the national sculpture award gala.",
            futureSinhala = "අපි ජාතික ප්‍රතිමා සම්මාන උළෙලට සහභාගී වන්නෙමු.",
            verbTransformation = "visited → ignite → will attend"
          ),
          TenseSentenceItem(
            id = "t8_s29",
            baseActionSinhala = "තනුවක් නිර්මාණය කිරීම",
            pastEnglish = "The composer created a patriotic tune for the choir.",
            pastSinhala = "සංගීතඥයා ගායක කණ්ඩායම සඳහා දේශාභිමානී තනුවක් නිර්මාණය කළේය.",
            presentEnglish = "Original music touches listeners' deepest emotions.",
            presentSinhala = "මූලික ස්වයං නිර්මාණ සංගීතය ශ්‍රාවකයන්ගේ ගැඹුරුම හැඟීම් ස්පර්ශ කරයි.",
            futureEnglish = "He will record his symphony in the studio.",
            futureSinhala = "ඔහු තම වාද්‍ය වෘන්ද සංගීතය ශබ්දාගාරයේ පටිගත කරනු ඇත.",
            verbTransformation = "created → touches → will record"
          ),
          TenseSentenceItem(
            id = "t8_s30",
            baseActionSinhala = "කලාව තුළින් ජීවිතය විඳීම",
            pastEnglish = "Art brought solace during stressful moments.",
            pastSinhala = "කලාව පීඩාකාරී අවස්ථාවලදී සැනසීම ගෙන දුන්නේය.",
            presentEnglish = "Creative hobbies enrich human daily lives.",
            presentSinhala = "නිර්මාණාත්මක විනෝදාංශ මිනිස් දෛනික ජීවිතය පෝෂණය කරයි.",
            futureEnglish = "Art will inspire generations toward beauty and peace.",
            futureSinhala = "කලාව සුන්දරත්වය සහ සාමය කරා පරම්පරාවන් පෙළඹවනු ඇත.",
            verbTransformation = "brought → enrich → will inspire"
          )
        )
      ),

      // ==========================================
      // Category 9: මිතුරන් සහ පවුලේ සබඳතා (Friends & Family) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 9,
        titleSinhala = "කාණ්ඩය 09: මිතුරන්, දෙමාපියන් සහ පවුල",
        titleEnglish = "Family Bonds & True Friendship",
        icon = "👨‍👩‍👧‍👦",
        description = "දෙමාපියන් රැකබලා ගැනීම, මිතුරන්ට උදවු කිරීම, ගෞරවය සහ සහජීවනය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t9_s1",
            baseActionSinhala = "දෙමාපියන්ට ගෞරව කිරීම",
            pastEnglish = "The son cared for his elderly parents devotedly.",
            pastSinhala = "පුතා තම වයෝවෘද්ධ දෙමාපියන් ඉතා භක්තියෙන් රැකබලා ගත්තේය.",
            presentEnglish = "Good children respect their parents wholeheartedly.",
            presentSinhala = "යහපත් දරුවෝ මුළු හදවතින්ම තම දෙමාපියන්ට ගරු කරති.",
            futureEnglish = "He will support his parents in their golden years.",
            futureSinhala = "ඔහු තම දෙමාපියන්ගේ මහලු වියේදී ඔවුන්ට උපකාර කරනු ඇත.",
            verbTransformation = "cared → respect → will support"
          ),
          TenseSentenceItem(
            id = "t9_s2",
            baseActionSinhala = "මිතුරෙකුට උදවු කිරීම",
            pastEnglish = "I helped my best friend when he was sick.",
            pastSinhala = "මගේ හොඳම මිතුරා අසනීප වූ විට මම ඔහුට උදවු කළෙමි.",
            presentEnglish = "A friend in need is a friend indeed.",
            presentSinhala = "විපතේදී පිහිට වන මිතුරා සැබෑ මිතුරාය.",
            futureEnglish = "I will stand by my companion through thick and thin.",
            futureSinhala = "ඕනෑම දුක සැපකදී මම මගේ මිතුරා ළඟින් සිටින්නෙමි.",
            verbTransformation = "helped → is → will stand by"
          ),
          TenseSentenceItem(
            id = "t9_s3",
            baseActionSinhala = "පවුලේ රාත්‍රී ආහාරය එකට ගැනීම",
            pastEnglish = "The entire family dined together yesterday night.",
            pastSinhala = "ඊයේ රාත්‍රියේ මුළු පවුලම එකට රාත්‍රී ආහාරය ගත්හ.",
            presentEnglish = "Family meals foster unity, conversation and warmth.",
            presentSinhala = "පවුලේ ආහාර වේල් එකමුතුකම, කතාබහ සහ උණුසුම ඇති කරයි.",
            futureEnglish = "We will gather for Sunday family feast.",
            futureSinhala = "අපි ඉරිදා පවුලේ භෝජන සංග්‍රහය සඳහා එකතු වන්නෙමු.",
            verbTransformation = "dined → foster → will gather"
          ),
          TenseSentenceItem(
            id = "t9_s4",
            baseActionSinhala = "සහෝදර සහෝදරියන් සමඟ බෙදාහදා ගැනීම",
            pastEnglish = "Brother shared his storybook with sister.",
            pastSinhala = "අයියා ඔහුගේ කතන්දර පොත නංගී සමඟ බෙදා ගත්තේය.",
            presentEnglish = "Siblings support each other through life challenges.",
            presentSinhala = "සහෝදර සහෝදරියෝ ජීවිතයේ අභියෝගවලදී එකිනෙකාට උදවු කරති.",
            futureEnglish = "They will celebrate achievements together.",
            futureSinhala = "ඔවුහු තම ජයග්‍රහණ එකට සමරනු ඇත.",
            verbTransformation = "shared → support → will celebrate"
          ),
          TenseSentenceItem(
            id = "t9_s5",
            baseActionSinhala = "සීයලා ආච්චිලා බැහැදැකීම",
            pastEnglish = "We visited grandparents in Matale last vacation.",
            pastSinhala = "පසුගිය නිවාඩුවේ අපි මාතලේ සීයා සහ ආච්චි බැලීමට ගියෙමු.",
            presentEnglish = "Grandparents share timeless wisdom and folklore.",
            presentSinhala = "සීයා සහ ආච්චි අගනා ප්‍රඥාව සහ ජනකතා බෙදා දෙති.",
            futureEnglish = "We will spend our holiday season at ancestral home.",
            futureSinhala = "අපි අපේ නිවාඩු කාලය මහගෙදර ගත කරන්නෙමු.",
            verbTransformation = "visited → share → will spend"
          ),
          TenseSentenceItem(
            id = "t9_s6",
            baseActionSinhala = "සමාව අයැදීම සහ සමාදාන වීම",
            pastEnglish = "They resolved their misunderstanding and shook hands.",
            pastSinhala = "ඔවුහු තම වැරදි වැටහීම සමථයකට පත්කර ගෙන අතට අත දුන්හ.",
            presentEnglish = "True friends forgive mistakes promptly.",
            presentSinhala = "සැබෑ මිතුරෝ එකිනෙකාගේ වැරදිවලට වහාම සමාව දෙති.",
            futureEnglish = "Kindness will heal broken friendships.",
            futureSinhala = "කාරුණිකභාවය බිඳුණු මිත්‍රත්වයන් සුවපත් කරනු ඇත.",
            verbTransformation = "resolved → forgive → will heal"
          ),
          TenseSentenceItem(
            id = "t9_s7",
            baseActionSinhala = "උපන්දින සාදයක් පැවැත්වීම",
            pastEnglish = "We organized a surprise birthday party for mother.",
            pastSinhala = "අපි අම්මා වෙනුවෙන් පුදුම සහගත උපන්දින සාදයක් සංවිධානය කළෙමු.",
            presentEnglish = "Birthdays celebrate the precious gift of life.",
            presentSinhala = "උපන්දින මඟින් ජීවිතය නම් වටිනා තෑග්ග සමරනු ලබයි.",
            futureEnglish = "We will sing birthday songs and cut the cake.",
            futureSinhala = "අපි උපන්දින ගීත ගයා කේක් කපන්නෙමු.",
            verbTransformation = "organized → celebrate → will sing"
          ),
          TenseSentenceItem(
            id = "t9_s8",
            baseActionSinhala = "රහස් ආරක්ෂා කිරීම",
            pastEnglish = "Nimal kept his friend's secret faithfully.",
            pastSinhala = "නිමල් තම මිතුරාගේ රහස ඉතා විශ්වාසවන්තව රැක්කේය.",
            presentEnglish = "Trust forms the unbreakable foundation of true friendship.",
            presentSinhala = "විශ්වාසය සැබෑ මිත්‍රත්වයේ බිඳිය නොහැකි පදනම සකසයි.",
            futureEnglish = "I will never betray my companion's confidence.",
            futureSinhala = "මම කිසිවිටෙකත් මගේ මිතුරාගේ විශ්වාසය කඩ නොකරන්නෙමි.",
            verbTransformation = "kept → forms → will never betray"
          ),
          TenseSentenceItem(
            id = "t9_s9",
            baseActionSinhala = "දුරකථනයෙන් සුවදුක් විමසීම",
            pastEnglish = "I called my childhood friend last evening.",
            pastSinhala = "මම ඊයේ සවස මගේ කුඩා කල මිතුරාට දුරකථන ඇමතුමක් දුන්නෙමි.",
            presentEnglish = "A caring phone call brightens lonely days.",
            presentSinhala = "සැලකිලිමත් දුරකථන ඇමතුමක් තනිකම දුරු කර දිනය ප්‍රබෝධමත් කරයි.",
            futureEnglish = "I will check on my distant cousins tomorrow.",
            futureSinhala = "මම හෙට දුර බැහැර සිටින ඥාතීන්ගේ සුවදුක් විමසන්නෙමි.",
            verbTransformation = "called → brightens → will check"
          ),
          TenseSentenceItem(
            id = "t9_s10",
            baseActionSinhala = "සතුට සහ දුක බෙදාගැනීම",
            pastEnglish = "We celebrated his victory with cheerful applause.",
            pastSinhala = "අපි ප්‍රීතිමත් අත්පොළසන් නාදයෙන් ඔහුගේ ජයග්‍රහණය සැමරුවෙමු.",
            presentEnglish = "True companions weep in sorrow and rejoice in triumph.",
            presentSinhala = "සැබෑ මිතුරෝ දුකේදී හඬා වැටෙති, ජයග්‍රහණයේදී ප්‍රීති වෙති.",
            futureEnglish = "We will always stand united through every trial.",
            futureSinhala = "සෑම අභියෝගයකදීම අපි සැමවිටම එකමුතුව සිටින්නෙමු.",
            verbTransformation = "celebrated → weep → will stand"
          ),
          TenseSentenceItem(
            id = "t9_s11",
            baseActionSinhala = "අසල්වැසියන්ට සැලකීම",
            pastEnglish = "Mother shared sweetmeats with neighboring families.",
            pastSinhala = "අම්මා අසල්වැසි පවුල් සමඟ කැවිලි පෙවිලි බෙදා ගත්තාය.",
            presentEnglish = "Good neighbors live in harmony and mutual respect.",
            presentSinhala = "යහපත් අසල්වාසීහු සහජීවනයෙන් හා අන්‍යෝන්‍ය ගෞරවයෙන් ජීවත් වෙති.",
            futureEnglish = "We will help them rebuild their storm-damaged fence.",
            futureSinhala = "කුණාටුවෙන් හානි වූ වැට නැවත සැකසීමට අපි ඔවුන්ට උදවු කරන්නෙමු.",
            verbTransformation = "shared → live → will help"
          ),
          TenseSentenceItem(
            id = "t9_s12",
            baseActionSinhala = "අලුත් මිතුරන් ඇතිකර ගැනීම",
            pastEnglish = "The new student made trustworthy friends quickly.",
            pastSinhala = "නව ශිෂ්‍යයා ඉක්මනින්ම විශ්වාසවන්ත මිතුරන් ඇතිකර ගත්තේය.",
            presentEnglish = "A warm welcoming smile attracts true companions.",
            presentSinhala = "උණුසුම් පිළිගැනීමේ සිනහවක් සැබෑ මිතුරන් ආකර්ෂණය කරයි.",
            futureEnglish = "He will feel at home in our new classroom.",
            futureSinhala = "අපගේ නව පන්ති කාමරයේදී ඔහුට තමන්ගේම නිවස මෙන් දැනෙනු ඇත.",
            verbTransformation = "made → attracts → will feel"
          ),
          TenseSentenceItem(
            id = "t9_s13",
            baseActionSinhala = "දෙමාපියන්ගේ අවවාද පිළිපැදීම",
            pastEnglish = "The daughter listened carefully to father's advice.",
            pastSinhala = "දියණිය පියාගේ අවවාදවලට ඉතා අවධානයෙන් සවන් දුන්නාය.",
            presentEnglish = "Parental guidance steers youth away from pitfalls.",
            presentSinhala = "දෙමාපිය මඟපෙන්වීම තරුණ පරපුර වැරදි මාවත්වලින් මුදවා ගනී.",
            futureEnglish = "She will follow moral teachings throughout life.",
            futureSinhala = "ඇය ජීවිත කාලය පුරාම සදාචාරාත්මක ඉගැන්වීම් අනුගමනය කරනු ඇත.",
            verbTransformation = "listened → steers → will follow"
          ),
          TenseSentenceItem(
            id = "t9_s14",
            baseActionSinhala = "පවුලේ විනෝද චාරිකාව",
            pastEnglish = "We went on a picnic to Peradeniya botanical gardens.",
            pastSinhala = "අපි පේරාදෙණිය උද්භිද උද්‍යානයට විනෝද චාරිකාවක් ගියෙමු.",
            presentEnglish = "Family outings create unforgettable childhood memories.",
            presentSinhala = "පවුලේ විනෝද චාරිකා අමතක නොවන ළමා මතකයන් නිර්මාණය කරයි.",
            futureEnglish = "We will travel to coastal beaches in August.",
            futureSinhala = "අපි අගෝස්තු මාසයේදී මුහුදු වෙරළට සංචාරය කරන්නෙමු.",
            verbTransformation = "went → create → will travel"
          ),
          TenseSentenceItem(
            id = "t9_s15",
            baseActionSinhala = "ස්තූති කිරීම",
            pastEnglish = "I thanked my uncle for his generous scholarship gift.",
            pastSinhala = "මාමා ලබාදුන් ත්‍යාගශීලී ශිෂ්‍යත්ව තෑග්ගට මම ඔහුට ස්තූති කළෙමි.",
            presentEnglish = "Gratitude strengthens heartfelt human connections.",
            presentSinhala = "කෘතඥතාව හෘදයාංගම මිනිස් සබඳතා ශක්තිමත් කරයි.",
            futureEnglish = "I will write a thank-you appreciation card.",
            futureSinhala = "මම ස්තුති කාඩ්පතක් ලියන්නෙමි.",
            verbTransformation = "thanked → strengthens → will write"
          ),
          TenseSentenceItem(
            id = "t9_s16",
            baseActionSinhala = "අසනීප වූ මිතුරෙකු බැලීමට යාම",
            pastEnglish = "We visited our classmate in the hospital ward.",
            pastSinhala = "අපි රෝහල් වාට්ටුවේ සිටි අපේ පන්තියේ මිතුරා බැලීමට ගියෙමු.",
            presentEnglish = "Compassion comforts suffering hearts.",
            presentSinhala = "දයාව සහ කරුණාව පීඩාවට පත් හදවත් සනසයි.",
            futureEnglish = "We will share class notes until he recovers fully.",
            futureSinhala = "ඔහු සම්පූර්ණයෙන්ම සුවය ලබන තුරු අපි පන්ති සටහන් ලබා දෙන්නෙමු.",
            verbTransformation = "visited → comforts → will share"
          ),
          TenseSentenceItem(
            id = "t9_s17",
            baseActionSinhala = "පවුලේ අයවැයට සහය වීම",
            pastEnglish = "Elder brother contributed his first salary to mother.",
            pastSinhala = "වැඩිමහල් සොහොයුරා ඔහුගේ පළමු වැටුප අම්මාට පූජා කළේය.",
            presentEnglish = "Responsible children ease their parents' burdens.",
            presentSinhala = "වගකිවයුතු දරුවෝ දෙමාපියන්ගේ බර ලිහිල් කරති.",
            futureEnglish = "He will build a comfortable home for his parents.",
            futureSinhala = "ඔහු තම දෙමාපියන් වෙනුවෙන් සුවපහසු නිවසක් ඉදිකරනු ඇත.",
            verbTransformation = "contributed → ease → will build"
          ),
          TenseSentenceItem(
            id = "t9_s18",
            baseActionSinhala = "කතාබස් කිරීම සහ සවන් දීම",
            pastEnglish = "Father patiently heard his son's school stories.",
            pastSinhala = "තාත්තා ඉවසිලිවන්තව තම පුතාගේ පාසල් කතාන්දරවලට සවන් දුන්නේය.",
            presentEnglish = "Attentive listening bridges generational gaps.",
            presentSinhala = "සාවධානව සවන් දීම පරම්පරා පරතරය දුරු කරයි.",
            futureEnglish = "They will discuss future university career choices.",
            futureSinhala = "ඔවුහු අනාගත විශ්වවිද්‍යාල වෘත්තීය තේරීම් සාකච්ඡා කරනු ඇත.",
            verbTransformation = "heard → bridges → will discuss"
          ),
          TenseSentenceItem(
            id = "t9_s19",
            baseActionSinhala = "ආගන්තුක සත්කාරය",
            pastEnglish = "Mother welcomed our guests with traditional sweetmeats.",
            pastSinhala = "අම්මා සාම්ප්‍රදායික කැවිලි පෙවිලිවලින් අපගේ අමුත්තන් පිළිගත්තාය.",
            presentEnglish = "Hospitality reflects rich Sri Lankan cultural warmth.",
            presentSinhala = "ආගන්තුක සත්කාරය ශ්‍රී ලාංකික සංස්කෘතික උණුසුම පිළිබිඹු කරයි.",
            futureEnglish = "We will serve refreshing tea to all who visit.",
            futureSinhala = "පැමිණෙන සියලු දෙනාට අපි ප්‍රබෝධමත් තේ පිළිගන්වන්නෙමු.",
            verbTransformation = "welcomed → reflects → will serve"
          ),
          TenseSentenceItem(
            id = "t9_s20",
            baseActionSinhala = "අන්‍යෝන්‍ය අවබෝධය",
            pastEnglish = "The two brothers settled their disagreement amicably.",
            pastSinhala = "සහෝදරයන් දෙදෙනා තම නොමනාපකම මිත්‍රශීලීව සමථයකට පත් කරගත්හ.",
            presentEnglish = "Patience prevents petty disputes among loved ones.",
            presentSinhala = "ඉවසීම ආදරණීයයන් අතර සුළු ආරවුල් වළක්වයි.",
            futureEnglish = "Harmony will prevail in our household.",
            futureSinhala = "අපේ නිවසේ සාමය සහ සමගිය රජයනු ඇත.",
            verbTransformation = "settled → prevents → will prevail"
          ),
          TenseSentenceItem(
            id = "t9_s21",
            baseActionSinhala = "දරුවන් රැකබලා ගැනීම",
            pastEnglish = "Aunt rocked the crying baby to sweet sleep.",
            pastSinhala = "නැන්දා හඬන බබා නළවා සුවබර නින්දකට පත් කළාය.",
            presentEnglish = "Motherly love surrounds children like a protective shield.",
            presentSinhala = "මාතෘ සෙනෙහස දරුවන්ව ආරක්ෂිත පලිහක් සේ වටකර ගනී.",
            futureEnglish = "The baby will grow under loving family care.",
            futureSinhala = "ආදරණීය පවුල් සෙවන යටතේ බබා වැඩෙනු ඇත.",
            verbTransformation = "rocked → surrounds → will grow"
          ),
          TenseSentenceItem(
            id = "t9_s22",
            baseActionSinhala = "පරණ මිතුරන් මුණගැසීම",
            pastEnglish = "School alumni met at the annual reunion.",
            pastSinhala = "වාර්ෂික ආදි ශිෂ්‍ය හමුවේදී පාසල් මිතුරෝ මුණගැසුණහ.",
            presentEnglish = "Old friendships never fade with time.",
            presentSinhala = "කාලයත් සමඟ පැරණි මිත්‍රත්වයන් කිසිදා වියැකී නොයයි.",
            futureEnglish = "We will relive golden school memories together.",
            futureSinhala = "අපි ස්වර්ණමය පාසල් මතකයන් නැවත ආවර්ජනය කරන්නෙමු.",
            verbTransformation = "met → fade → will relive"
          ),
          TenseSentenceItem(
            id = "t9_s23",
            baseActionSinhala = "ආදර්ශවත් චරිතයක් වීම",
            pastEnglish = "Elder sister set a fine academic example for younger ones.",
            pastSinhala = "අක්කා බාල සහෝදරයින්ට කදිම අධ්‍යාපනික ආදර්ශයක් සැපයුවාය.",
            presentEnglish = "Virtuous parents inspire their offspring through good deeds.",
            presentSinhala = "ගුණවත් දෙමාපියෝ යහපත් ක්‍රියා මඟින් දරුවන්ට ආදර්ශ සපයති.",
            futureEnglish = "Children will walk along righteous paths.",
            futureSinhala = "දරුවෝ ධාර්මිෂ්ඨ මාර්ග ඔස්සේ ගමන් කරනු ඇත.",
            verbTransformation = "set → inspire → will walk"
          ),
          TenseSentenceItem(
            id = "t9_s24",
            baseActionSinhala = "සමරු ඡායාරූප ගැනීම",
            pastEnglish = "We framed our three-generation family photograph.",
            pastSinhala = "අපි අපේ පරම්පරා තුනක පවුලේ ඡායාරූපය රාමු කළෙමු.",
            presentEnglish = "Portraits remind us of ancestral roots and heritage.",
            presentSinhala = "පින්තූර අපට මුතුන් මිත්තන්ගේ මූලාරම්භය සහ උරුමය සිහිපත් කරයි.",
            futureEnglish = "We will treasure this family heirloom forever.",
            futureSinhala = "අපි මෙම පවුලේ උරුමය සදාකාලයටම සුරකින්නෙමු.",
            verbTransformation = "framed → remind → will treasure"
          ),
          TenseSentenceItem(
            id = "t9_s25",
            baseActionSinhala = "අවංකව කටයුතු කිරීම",
            pastEnglish = "He told the truth even when it was difficult.",
            pastSinhala = "දුෂ්කර වූ අවස්ථාවේදී පවා ඔහු සත්‍යයම පැවසුවේය.",
            presentEnglish = "Honesty preserves dignity and builds lifelong trust.",
            presentSinhala = "අවංකකම ගෞරවය සුරකින අතර ජීවිත කාලය පුරාම විශ්වාසය ගොඩනඟයි.",
            futureEnglish = "Integrity will guide every decision he makes.",
            futureSinhala = "යුක්තිගරුකභාවය ඔහු ගන්නා සෑම තීරණයකටම මඟ පෙන්වනු ඇත.",
            verbTransformation = "told → preserves → will guide"
          ),
          TenseSentenceItem(
            id = "t9_s26",
            baseActionSinhala = "ආච්චිට අතහිත දීම",
            pastEnglish = "Kamal helped grandmother walk up the stairs.",
            pastSinhala = "කමල් ආච්චිට පඩිපෙළ නැගීමට අතහිත දුන්නේය.",
            presentEnglish = "Youthful strength protects vulnerable elderly citizens.",
            presentSinhala = "තරුණ ශක්තිය වයෝවෘද්ධ පුරවැසියන් ආරක්ෂා කරයි.",
            futureEnglish = "He will always assist elderly folks with reverence.",
            futureSinhala = "ඔහු සැමවිටම මහලු අයට ගෞරවයෙන් උපකාර කරනු ඇත.",
            verbTransformation = "helped → protects → will assist"
          ),
          TenseSentenceItem(
            id = "t9_s27",
            baseActionSinhala = "නිවාඩු කාලය එකට ගතකිරීම",
            pastEnglish = "Cousins played board games on rainy days.",
            pastSinhala = "වැසි සහිත දිනවල නෑදෑ සහෝදරයෝ බෝඩ් ලෑලි ක්‍රීඩා කළහ.",
            presentEnglish = "Laughter unites family members across all ages.",
            presentSinhala = "සිනහව සියලු වයස්වල පවුලේ සාමාජිකයින් එක්සත් කරයි.",
            futureEnglish = "We will roast marshmallows by the garden campfire.",
            futureSinhala = "අපි වත්තේ කඳවුරු ගින්න අසල මාෂ්මෙලෝ පුළුස්සන්නෙමු.",
            verbTransformation = "played → unites → will roast"
          ),
          TenseSentenceItem(
            id = "t9_s28",
            baseActionSinhala = "දිරිගැන්වීම",
            pastEnglish = "Mother comforted me when I was disappointed.",
            pastSinhala = "මම කලකිරී සිටි අවස්ථාවේදී අම්මා මාව සැනසුවාය.",
            presentEnglish = "Words of encouragement restore broken spirits.",
            presentSinhala = "දිරිගැන්වීමේ වදන් බිඳුණු සිත් සනසවා යළි නංවයි.",
            futureEnglish = "Her faith in me will fuel my determination.",
            futureSinhala = "මා කෙරෙහි ඇය තැබූ විශ්වාසය මගේ අධිෂ්ඨානයට පණ පොවනු ඇත.",
            verbTransformation = "comforted → restore → will fuel"
          ),
          TenseSentenceItem(
            id = "t9_s29",
            baseActionSinhala = "ආපසු ගෙදර පැමිණීම (Welcome Home)",
            pastEnglish = "Father returned from overseas after two long years.",
            pastSinhala = "වසර දෙකකට පසු තාත්තා විදේශගතව සිට ආපසු පැමිණියේය.",
            presentEnglish = "Home is where genuine love and peace dwell.",
            presentSinhala = "සැබෑ ආදරය සහ සාමය රැඳෙන තැන නිවසයි.",
            futureEnglish = "We will welcome him with tears of joy.",
            futureSinhala = "අපි ප්‍රීති කඳුළු මැද ඔහුව පිළිගන්නෙමු.",
            verbTransformation = "returned → is → will welcome"
          ),
          TenseSentenceItem(
            id = "t9_s30",
            baseActionSinhala = "පවුලේ සදාකාලික බැඳීම",
            pastEnglish = "They stood together through poverty and hardship.",
            pastSinhala = "දුප්පත්කම සහ දුෂ්කරතා මැද ඔවුහු එකට නැගී සිටියහ.",
            presentEnglish = "Family remains life's greatest anchor in stormy waters.",
            presentSinhala = "ජීවිතයේ කුණාටු හමුවේ පවුල විශාලතම නැංගුරම සේ පවතී.",
            futureEnglish = "Our family love will shine brighter through every storm.",
            futureSinhala = "සෑම කුණාටුවක් මැදින්ම අපේ පවුලේ සෙනෙහස වඩාත් බැබළෙනු ඇත.",
            verbTransformation = "stood → remains → will shine"
          )
        )
      ),

      // ==========================================
      // Category 10: මිලදී ගැනීම් සහ වෙළඳපොළ (Shopping & Market) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 10,
        titleSinhala = "කාණ්ඩය 10: වෙළඳපොළ සහ මිලදී ගැනීම්",
        titleEnglish = "Shopping, Markets & Commerce",
        icon = "🛒",
        description = "සුපිරි වෙළඳසැල්, එළවළු පොළ, මිල ගණන් කේවල් කිරීම සහ බිල්පත් ගෙවීම පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t10_s1",
            baseActionSinhala = "සුපිරි වෙළඳසැලට යාම",
            pastEnglish = "Mother went to the supermarket yesterday afternoon.",
            pastSinhala = "අම්මා ඊයේ සවස සුපිරි වෙළඳසැලට ගියාය.",
            presentEnglish = "Mother buys weekly groceries every Sunday.",
            presentSinhala = "අම්මා සෑම ඉරිදාම සතියේ සිල්ලර බඩු මිලදී ගනී.",
            futureEnglish = "Mother will buy washing powder and soap tomorrow.",
            futureSinhala = "අම්මා හෙට රෙදි සෝදන කුඩු සහ සබන් මිලදී ගනු ඇත.",
            verbTransformation = "went → buys → will buy"
          ),
          TenseSentenceItem(
            id = "t10_s2",
            baseActionSinhala = "මිලදී ගැනීමේ ලැයිස්තුවක් සෑදීම",
            pastEnglish = "I wrote down a shopping list of required spices.",
            pastSinhala = "අවශ්‍ය කුළුබඩු පිළිබඳව මම සාප්පු ලැයිස්තුවක් ලියා ගත්තෙමි.",
            presentEnglish = "A grocery list prevents impulsive overspending.",
            presentSinhala = "බඩු ලැයිස්තුවක් තිබීම හිතුවක්කාරී අධික වියදම් වළක්වයි.",
            futureEnglish = "I will check kitchen stocks before making list.",
            futureSinhala = "ලැයිස්තුව සෑදීමට පෙර මම කුස්සියේ තොග පරීක්ෂා කරන්නෙමි.",
            verbTransformation = "wrote → prevents → will check"
          ),
          TenseSentenceItem(
            id = "t10_s3",
            baseActionSinhala = "නැවුම් එළවළු තේරීම",
            pastEnglish = "Father picked fresh carrots and green beans at the fair.",
            pastSinhala = "තාත්තා පොළෙන් නැවුම් කැරට් සහ බෝංචි තෝරාගත්තේය.",
            presentEnglish = "Village polas offer garden-fresh organic produce.",
            presentSinhala = "ගමේ පොළවල් නැවුම් කාබනික අස්වැන්න ලබා දෙයි.",
            futureEnglish = "Father will select ripe tomatoes for cooking.",
            futureSinhala = "තාත්තා ඉවුම් පිහුම් සඳහා ඉදුණු තක්කාලි තෝරාගනු ඇත.",
            verbTransformation = "picked → offer → will select"
          ),
          TenseSentenceItem(
            id = "t10_s4",
            baseActionSinhala = "මිල ගණන් ඇසීම",
            pastEnglish = "She asked the price of red onions per kilogram.",
            pastSinhala = "ඇය රතු ලූණු කිලෝවක මිල ඇසුවාය.",
            presentEnglish = "Shoppers check market price tags before purchase.",
            presentSinhala = "පාරිභෝගිකයෝ මිලදී ගැනීමට පෙර මිල ටැග පරීක්ෂා කරති.",
            futureEnglish = "She will inquire about discounts on fresh fruits.",
            futureSinhala = "ඇය නැවුම් පලතුරු සඳහා වට්ටම් පිළිබඳව විමසනු ඇත.",
            verbTransformation = "asked → check → will inquire"
          ),
          TenseSentenceItem(
            id = "t10_s5",
            baseActionSinhala = "කේවල් කිරීම (Bargaining)",
            pastEnglish = "The customer bargained politely for a fair price.",
            pastSinhala = "පාරිභෝගිකයා සාධාරණ මිලක් සඳහා කාරුණිකව කේවල් කළේය.",
            presentEnglish = "Vendors negotiate prices at open-air flea markets.",
            presentSinhala = "විවෘත පොළවල්හි වෙළෙන්දෝ මිල ගණන් සාකච්ඡා කරති.",
            futureEnglish = "The seller will reduce price for bulk purchase.",
            futureSinhala = "තොග වශයෙන් මිලදී ගැනීමේදී විකුණුම්කරු මිල අඩු කරනු ඇත.",
            verbTransformation = "bargained → negotiate → will reduce"
          ),
          TenseSentenceItem(
            id = "t10_s6",
            baseActionSinhala = "එළවළු කිරා බැලීම",
            pastEnglish = "The vendor weighed the potatoes on electronic scale.",
            pastSinhala = "වෙළෙන්දා විද්‍යුත් තරාදියේ අල කිරා බැලුවේය.",
            presentEnglish = "Scales measure produce kilograms accurately.",
            presentSinhala = "තරාදි මඟින් එළවළු කිලෝග්‍රෑම් නිවැරදිව මනිනු ලබයි.",
            futureEnglish = "He will weigh two kilos of dhal for us.",
            futureSinhala = "ඔහු අප වෙනුවෙන් පරිප්පු කිලෝ දෙකක් කිරා දෙනු ඇත.",
            verbTransformation = "weighed → measure → will weigh"
          ),
          TenseSentenceItem(
            id = "t10_s7",
            baseActionSinhala = "රෙදිපිළි මිලදී ගැනීම",
            pastEnglish = "She bought colorful cotton fabric for dress.",
            pastSinhala = "ඇය ගවුමක් සඳහා වර්ණවත් කපු රෙදි මිලදී ගත්තාය.",
            presentEnglish = "Textile shops showcase seasonal fashion arrivals.",
            presentSinhala = "රෙදිපිළි සාප්පු කාලීන විලාසිතා ප්‍රදර්ශනය කරයි.",
            futureEnglish = "She will purchase new festival clothes for family.",
            futureSinhala = "ඇය පවුලේ අයට නව උත්සව ඇඳුම් මිලදී ගනු ඇත.",
            verbTransformation = "bought → showcase → will purchase"
          ),
          TenseSentenceItem(
            id = "t10_s8",
            baseActionSinhala = "ක්‍රෙඩිට් හෝ ඩෙබිට් කාඩ්පතින් ගෙවීම",
            pastEnglish = "Father paid the supermarket bill using his debit card.",
            pastSinhala = "තාත්තා ඔහුගේ ඩෙබිට් කාඩ්පත භාවිතයෙන් බිල ගෙව්වේය.",
            presentEnglish = "Cashless digital payments speed up checkout queues.",
            presentSinhala = "කාඩ්පත් මඟින් මුදල් රහිත ගෙවීම් පෝලිම්වල කාලය ඉතිරි කරයි.",
            futureEnglish = "I will scan QR code to pay my grocery total.",
            futureSinhala = "මගේ බිල ගෙවීමට මම QR කේතය ස්කෑන් කරන්නෙමි.",
            verbTransformation = "paid → speed up → will scan"
          ),
          TenseSentenceItem(
            id = "t10_s9",
            baseActionSinhala = "රිසිට්පත පරීක්ෂා කිරීම",
            pastEnglish = "He verified the printed receipt carefully.",
            pastSinhala = "ඔහු මුද්‍රිත රිසිට්පත ප්‍රවේශමෙන් පරීක්ෂා කළේය.",
            presentEnglish = "Receipts provide legal proof of commercial transactions.",
            presentSinhala = "රිසිට්පත් මඟින් වාණිජ ගනුදෙනු පිළිබඳ නීත්‍යානුකූල සාක්ෂි සපයයි.",
            futureEnglish = "The cashier will hand over your bill with warranty card.",
            futureSinhala = "මුදල් අයකැමි ඔබේ බිල්පත සහතික පත්‍රය සමඟ භාර දෙනු ඇත.",
            verbTransformation = "verified → provide → will hand over"
          ),
          TenseSentenceItem(
            id = "t10_s10",
            baseActionSinhala = "ඉතිරි මුදල් ගණන් කිරීම",
            pastEnglish = "I counted my balance change at the counter.",
            pastSinhala = "මම කවුන්ටරය අසලදී මගේ ඉතිරි මුදල් ගණන් කළෙමි.",
            presentEnglish = "Careful buyers count balance change before stepping out.",
            presentSinhala = "ප්‍රවේශම් සහගත ගැනුම්කරුවෝ පිටවීමට පෙර ඉතිරි මුදල් ගණන් කරති.",
            futureEnglish = "The teller will return fifty rupees change.",
            futureSinhala = "මුදල් අයකැමි ඉතිරි රුපියල් පනහ ආපසු ලබා දෙනු ඇත.",
            verbTransformation = "counted → count → will return"
          ),
          TenseSentenceItem(
            id = "t10_s11",
            baseActionSinhala = "නැවත භාවිත කළ හැකි බෑගයක් රැගෙන යාම",
            pastEnglish = "Mother brought reusable cloth bags for shopping.",
            pastSinhala = "අම්මා බඩු ගැනීමට නැවත භාවිත කළ හැකි රෙදි බෑග් රැගෙන ගියාය.",
            presentEnglish = "Eco-conscious buyers refuse single-use polythene bags.",
            presentSinhala = "පරිසර හිතකාමී ගැනුම්කරුවෝ තනි භාවිත පොලිතින් බෑග් ප්‍රතික්ෂේප කරති.",
            futureEnglish = "We will carry durable jute tote bags to fair.",
            futureSinhala = "අපි පොළට කල්පවතින ගෝනි බෑග් රැගෙන යන්නෙමු.",
            verbTransformation = "brought → refuse → will carry"
          ),
          TenseSentenceItem(
            id = "t10_s12",
            baseActionSinhala = "කල් ඉකුත්වීමේ දිනය බැලීම",
            pastEnglish = "I checked the expiration date on the milk packet.",
            pastSinhala = "මම කිරි පැකට්ටුවේ කල් ඉකුත්වීමේ දිනය පරීක්ෂා කළෙමි.",
            presentEnglish = "Smart consumers inspect manufacture and expiry labels.",
            presentSinhala = "බුද්ධිමත් පාරිභෝගිකයෝ නිෂ්පාදිත සහ කල් ඉකුත්වීමේ ලේබල පරීක්ෂා කරති.",
            futureEnglish = "I will discard any canned food past shelf life.",
            futureSinhala = "කල් ඉකුත් වූ ඕනෑම ටින් කළ ආහාරයක් මම ඉවත් කරන්නෙමි.",
            verbTransformation = "checked → inspect → will discard"
          ),
          TenseSentenceItem(
            id = "t10_s13",
            baseActionSinhala = "පොත් සාප්පුවෙන් පොත් ගැනීම",
            pastEnglish = "We purchased school stationery from the local bookshop.",
            pastSinhala = "අපි ප්‍රාදේශීය පොත් සාප්පුවෙන් පාසල් ලිපිද්‍රව්‍ය මිලදී ගත්තෙමු.",
            presentEnglish = "Students buy pens, rulers and drawing books before term starts.",
            presentSinhala = "වාරය ඇරඹීමට පෙර සිසුහු පෑන්, කටු සහ චිත්‍ර පොත් මිලදී ගනිති.",
            futureEnglish = "We will purchase geometry mathematical instruments.",
            futureSinhala = "අපි ජ්‍යාමිතික පෙට්ටි මිලදී ගන්නෙමු.",
            verbTransformation = "purchased → buy → will purchase"
          ),
          TenseSentenceItem(
            id = "t10_s14",
            baseActionSinhala = "ඉදුණු පලතුරු තේරීම",
            pastEnglish = "He bought sweet yellow bananas at the roadside stall.",
            pastSinhala = "ඔහු පාර අයිනේ කඩෙන් මිහිරි කහ කෙසෙල් මිලදී ගත්තේය.",
            presentEnglish = "Fresh local fruits provide essential natural vitamins.",
            presentSinhala = "නැවුම් දේශීය පලතුරු අත්‍යවශ්‍ය ස්වභාවික විටමින් ලබා දෙයි.",
            futureEnglish = "He will pick delicious sweet pineapples from Giriulla.",
            futureSinhala = "ඔහු ගිරිඋල්ලෙන් රසවත් මිහිරි අන්නාසි තෝරා ගනු ඇත.",
            verbTransformation = "bought → provide → will pick"
          ),
          TenseSentenceItem(
            id = "t10_s15",
            baseActionSinhala = "ට්‍රොලිය තල්ලු කිරීම",
            pastEnglish = "The boy pushed the shopping trolley down the aisle.",
            pastSinhala = "පිරිමි ළමයා සාප්පු තීරුව දිගේ ට්‍රොලිය තල්ලු කළේය.",
            presentEnglish = "Shoppers glide shopping carts in organized hypermarkets.",
            presentSinhala = "පාරිභෝගිකයෝ පිළිවෙළට ඇති වෙළඳසැල්වල ට්‍රොලි තල්ලු කරති.",
            futureEnglish = "He will wheel the loaded cart to the car trunk.",
            futureSinhala = "ඔහු බඩු පිරවූ ට්‍රොලිය මෝටර් රථයේ ඩිකිය වෙත තල්ලු කරනු ඇත.",
            verbTransformation = "pushed → glide → will wheel"
          ),
          TenseSentenceItem(
            id = "t10_s16",
            baseActionSinhala = "වට්ටම් සහ ප්‍රවර්ධන",
            pastEnglish = "The boutique offered fifty percent discount on shoes.",
            pastSinhala = "සාප්පුව සපත්තු සඳහා සියයට පනහක වට්ටමක් ලබා දුන්නේය.",
            presentEnglish = "Seasonal sales attract crowds of enthusiastic shoppers.",
            presentSinhala = "උත්සව සමයේ වට්ටම් උද්යෝගිමත් පාරිභෝගිකයින් ආකර්ෂණය කරයි.",
            futureEnglish = "They will launch festive promotional offers next week.",
            futureSinhala = "ඔවුහු ලබන සතියේ උත්සව ප්‍රවර්ධන දීමනා දියත් කරනු ඇත.",
            verbTransformation = "offered → attract → will launch"
          ),
          TenseSentenceItem(
            id = "t10_s17",
            baseActionSinhala = "මාළු වෙළඳපොළට යාම",
            pastEnglish = "Father bought fresh seer fish from Negombo harbor.",
            pastSinhala = "තාත්තා මීගමු වරායෙන් නැවුම් තෝරා මාළු මිලදී ගත්තේය.",
            presentEnglish = "Fishmongers display ocean catch on clean ice beds.",
            presentSinhala = "මාළු වෙළෙන්දෝ අයිස් මත නැවුම් සාගර මත්ස්‍යයන් ප්‍රදර්ශනය කරති.",
            futureEnglish = "Father will select prawns for Sunday curry.",
            futureSinhala = "තාත්තා ඉරිදා කරිය සඳහා ඉස්සන් තෝරාගනු ඇත.",
            verbTransformation = "bought → display → will select"
          ),
          TenseSentenceItem(
            id = "t10_s18",
            baseActionSinhala = "ඖෂධ මිලදී ගැනීම (Pharmacy)",
            pastEnglish = "I bought prescribed antibiotics from the chemist.",
            pastSinhala = "මම ඖෂධසැලෙන් වෛද්‍ය නිර්දේශිත ප්‍රතිජීවක මිලදී ගත්තෙමි.",
            presentEnglish = "Licensed pharmacists dispense medications according to prescriptions.",
            presentSinhala = "බලපත්‍රලාභී ඖෂධවේදීහු වෛද්‍ය බෙහෙත් වට්ටෝරුව අනුව ඖෂධ නිකුත් කරති.",
            futureEnglish = "I will purchase multivitamin syrup for grandma.",
            futureSinhala = "මම ආච්චි වෙනුවෙන් විටමින් සිරප් මිලදී ගන්නෙමි.",
            verbTransformation = "bought → dispense → will purchase"
          ),
          TenseSentenceItem(
            id = "t10_s19",
            baseActionSinhala = "කැඩිච්ච බඩු මාරු කර ගැනීම (Exchange)",
            pastEnglish = "She exchanged the oversized dress for a smaller size.",
            pastSinhala = "ඇය ප්‍රමාණයෙන් විශාල වූ ඇඳුම කුඩා ප්‍රමාණයේ ඇඳුමකට මාරු කරගත්තාය.",
            presentEnglish = "Shops allow item exchanges within seven business days.",
            presentSinhala = "වැඩකරන දින හතක් ඇතුළත භාණ්ඩ මාරු කිරීමට සාප්පු අවසර දෙයි.",
            futureEnglish = "The store manager will replace the defective headphones.",
            futureSinhala = "දෝෂ සහිත හෙඩ්ෆෝනය වෙනුවට කළමනාකරු අලුත් එකක් ලබා දෙනු ඇත.",
            verbTransformation = "exchanged → allow → will replace"
          ),
          TenseSentenceItem(
            id = "t10_s20",
            baseActionSinhala = "මිල සංසන්දනය කිරීම",
            pastEnglish = "He compared appliance prices across three different stores.",
            pastSinhala = "ඔහු විවිධ සාප්පු තුනකින් විදුලි උපකරණවල මිල ගණන් සංසන්දනය කළේය.",
            presentEnglish = "Smart shoppers compare quality, warranty and price.",
            presentSinhala = "බුද්ධිමත් පාරිභෝගිකයෝ ගුණාත්මකභාවය, වගකීම් කාලය සහ මිල සංසන්දනය කරති.",
            futureEnglish = "He will buy the blender with five-year motor warranty.",
            futureSinhala = "ඔහු පස් වසරක මෝටර් වගකීමක් සහිත බ්ලෙන්ඩරය මිලදී ගනු ඇත.",
            verbTransformation = "compared → compare → will buy"
          ),
          TenseSentenceItem(
            id = "t10_s21",
            baseActionSinhala = "අන්තර්ජාලයෙන් මිලදී ගැනීම (Online Shopping)",
            pastEnglish = "I ordered an English grammar guide from online bookstore.",
            pastSinhala = "මම අන්තර්ජාල පොත් සාප්පුවෙන් ඉංග්‍රීසි ව්‍යාකරණ පොතක් ඇණවුම් කළෙමි.",
            presentEnglish = "E-commerce platforms deliver packages straight to doorsteps.",
            presentSinhala = "ඊ-වාණිජ්‍ය වෙබ් අඩවි නිවසටම පාර්සල් ගෙනැවිත් භාර දෙයි.",
            futureEnglish = "The delivery courier will bring my parcel by noon.",
            futureSinhala = "කුරියර් සේවකයා දවල් වන විට මගේ පාර්සලය ගෙනෙනු ඇත.",
            verbTransformation = "ordered → deliver → will bring"
          ),
          TenseSentenceItem(
            id = "t10_s22",
            baseActionSinhala = "සපත්තු යුගලක් තෝරාගැනීම",
            pastEnglish = "Kamal tried on black leather school shoes.",
            pastSinhala = "කමල් කළු සම් පාසල් සපත්තු දමා බැලුවේය.",
            presentEnglish = "Comfortable arch support prevents foot fatigue.",
            presentSinhala = "සුවපහසු සපත්තු පාදවල විඩාව වළක්වයි.",
            futureEnglish = "He will buy durable polished shoes for prize day.",
            futureSinhala = "ත්‍යාග ප්‍රදානෝත්සවය සඳහා ඔහු කල්පවතින සපත්තු මිලදී ගනු ඇත.",
            verbTransformation = "tried on → prevents → will buy"
          ),
          TenseSentenceItem(
            id = "t10_s23",
            baseActionSinhala = "මුදල් ඉතිරි කර ගැනීම",
            pastEnglish = "Mother saved five hundred rupees using member loyalty card.",
            pastSinhala = "සාමාජික කාඩ්පත භාවිතයෙන් අම්මා රුපියල් පන්සියයක් ඉතිරි කර ගත්තාය.",
            presentEnglish = "Reward points earn valuable discounts on future shopping.",
            presentSinhala = "ප්‍රසාද ලකුණු මඟින් අනාගත මිලදී ගැනීම් සඳහා වට්ටම් උපයා දෙයි.",
            futureEnglish = "She will redeem reward points for free groceries.",
            futureSinhala = "ඇය නොමිලේ බඩු ලබා ගැනීමට ප්‍රසාද ලකුණු භාවිත කරනු ඇත.",
            verbTransformation = "saved → earn → will redeem"
          ),
          TenseSentenceItem(
            id = "t10_s24",
            baseActionSinhala = "ස්වර්ණාභරණ මිලදී ගැනීම",
            pastEnglish = "Aunt inspected gold jewelry hallmark certifications.",
            pastSinhala = "නැන්දා රන් ආභරණවල ප්‍රමිතිය සහතික කරන ලාංඡන පරීක්ෂා කළාය.",
            presentEnglish = "Reputable jewelers guarantee genuine 22-karat gold purity.",
            presentSinhala = "විශ්වාසදායක ස්වර්ණාභරණ වෙළෙන්දෝ කැරට් 22 රන්වල නියම පිරිසිදුකම සහතික කරති.",
            futureEnglish = "She will purchase an engraved bangle for the bride.",
            futureSinhala = "ඇය මනාලිය වෙනුවෙන් කැටයම් කළ වළල්ලක් මිලදී ගනු ඇත.",
            verbTransformation = "inspected → guarantee → will purchase"
          ),
          TenseSentenceItem(
            id = "t10_s25",
            baseActionSinhala = "දේශීය නිෂ්පාදන අගය කිරීම",
            pastEnglish = "We bought Ceylon spice gift packs for overseas cousins.",
            pastSinhala = "විදේශගත ඥාතීන් සඳහා අපි ලංකාවේ කුළුබඩු තෑගි පැකට් මිලදී ගත්තෙමු.",
            presentEnglish = "Buying homegrown products boosts the national rural economy.",
            presentSinhala = "දේශීය නිෂ්පාදන මිලදී ගැනීමෙන් ජාතික ග්‍රාමීය ආර්ථිකය නංවාලයි.",
            futureEnglish = "We will always prioritize Sri Lankan cottage industries.",
            futureSinhala = "අපි සැමවිටම ශ්‍රී ලාංකික ගෘහ කර්මාන්ත සඳහා ප්‍රමුඛත්වය දෙන්නෙමු.",
            verbTransformation = "bought → boosts → will prioritize"
          ),
          TenseSentenceItem(
            id = "t10_s26",
            baseActionSinhala = "විදුලි උපකරණ පරීක්ෂා කිරීම",
            pastEnglish = "The technician demonstrated how the microwave works.",
            pastSinhala = "ක්ෂුද්‍ර තරංග උඳුන ක්‍රියාකරන ආකාරය කාර්මික ශිල්පියා පෙන්වා දුන්නේය.",
            presentEnglish = "Customers test appliances before paying the bill.",
            presentSinhala = "පාරිභෝගිකයෝ බිල ගෙවීමට පෙර විදුලි උපකරණ ක්‍රියාකරවා බලති.",
            futureEnglish = "The store will deliver and install the washing machine.",
            futureSinhala = "සාප්පුව රෙදි සෝදන යන්ත්‍රය ගෙදරටම ගෙනැවිත් සවිකර දෙනු ඇත.",
            verbTransformation = "demonstrated → test → will deliver"
          ),
          TenseSentenceItem(
            id = "t10_s27",
            baseActionSinhala = "පෝලිමේ රැඳී සිටීම",
            pastEnglish = "Customers waited patiently in the billing queue.",
            pastSinhala = "පාරිභෝගිකයෝ බිල්පත් ගෙවීමේ පෝලිමේ ඉවසීමෙන් රැඳී සිටියහ.",
            presentEnglish = "Polite queue discipline ensures smooth commercial service.",
            presentSinhala = "විනයගරුක පෝලිම් පැවතීම සුමට වෙළඳ සේවාවක් සහතික කරයි.",
            futureEnglish = "The new self-checkout kiosk will reduce waiting queues.",
            futureSinhala = "ස්වයංක්‍රීය බිල්පත් කවුළුව පෝලිම්වල රැඳී සිටීමේ කාලය අඩු කරනු ඇත.",
            verbTransformation = "waited → ensures → will reduce"
          ),
          TenseSentenceItem(
            id = "t10_s28",
            baseActionSinhala = "කුළුබඩු සහ සුවඳැති ධාන්‍ය",
            pastEnglish = "Mother selected aromatic cinnamon quills from coastal market.",
            pastSinhala = "අම්මා වෙරළබඩ වෙළඳපොළෙන් සුවඳැති කුරුඳු පොතු තෝරා ගත්තාය.",
            presentEnglish = "Ceylon cinnamon is celebrated globally for superior aroma.",
            presentSinhala = "ලංකාවේ කුරුඳු එහි උසස් සුවඳ නිසා ලොව පුරා ප්‍රසිද්ධය.",
            futureEnglish = "She will brew cinnamon spiced tea tonight.",
            futureSinhala = "ඇය අද රෑ කුරුඳු මිශ්‍ර තේ පෙරනු ඇත.",
            verbTransformation = "selected → is celebrated → will brew"
          ),
          TenseSentenceItem(
            id = "t10_s29",
            baseActionSinhala = "සාප්පු සවාරියෙන් පසු බඩු නිවසේ තැන්පත් කිරීම",
            pastEnglish = "We unpacked groceries and stored cold milk in fridge.",
            pastSinhala = "අපි බඩු බෑග් දිගහැර සිසිල් කිරි ශීතකරණයේ තැන්පත් කළෙමු.",
            presentEnglish = "Proper food storage prevents spoilage and waste.",
            presentSinhala = "නිසි ලෙස ආහාර ගබඩා කිරීම නරක්වීම සහ අපතේ යාම වළක්වයි.",
            futureEnglish = "We will wash leafy greens and keep them chilled.",
            futureSinhala = "අපි පලා වර්ග සෝදා ශීතකරණයේ තබන්නෙමු.",
            verbTransformation = "unpacked → prevents → will wash"
          ),
          TenseSentenceItem(
            id = "t10_s30",
            baseActionSinhala = "ඥානවන්තව මුදල් වියදම් කිරීම",
            pastEnglish = "We stayed strictly within our monthly household budget.",
            pastSinhala = "අපි දැඩි ලෙස අපගේ මාසික ගෘහස්ථ අයවැය සීමාව තුළ සිටියෙමු.",
            presentEnglish = "Sensible money management secures peaceful financial future.",
            presentSinhala = "ඥානවන්ත මුදල් කළමනාකරණය සාමකාමී මූල්‍ය අනාගතයක් සුරක්ෂිත කරයි.",
            futureEnglish = "We will invest our surplus savings wisely.",
            futureSinhala = "අපි අපේ ඉතිරි මුදල් බුද්ධිමත්ව ආයෝජනය කරන්නෙමු.",
            verbTransformation = "stayed → secures → will invest"
          )
        )
      )
    )
  }
}
