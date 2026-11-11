package com.example

object TenseDataPart6 {
  fun getCategoriesPart6(): List<TenseComparisonCategory> {
    return listOf(
      // ==========================================
      // Category 24: නිවාඩු දින, විනෝද චාරිකා සහ වෙරළ ගමන් (Holidays, Picnics & Beach Trips) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 24,
        titleSinhala = "කාණ්ඩය 24: නිවාඩු දින, විනෝද චාරිකා සහ වෙරළ ගමන්",
        titleEnglish = "Holidays, Picnics & Beach Trips",
        icon = "🏖️",
        description = "වෙරළේ සෙල්ලම් කිරීම, විනෝද චාරිකා, කඳවුරු බැඳීම සහ නිවාඩු විනෝදාස්වාදය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t24_s1",
            baseActionSinhala = "වෙරළේ ඇවිදීම",
            pastEnglish = "We walked along the golden sandy beach at Bentota yesterday.",
            pastSinhala = "අපි ඊයේ බෙන්තොට රන්වන් වැලි වෙරළ දිගේ ඇවිද්දෙමු.",
            presentEnglish = "Tourists walk along the coastline during gentle sunset.",
            presentSinhala = "සංචාරකයෝ මනරම් ඉර බසින වේලාවේදී වෙරළ තීරය දිගේ ඇවිදිති.",
            futureEnglish = "We will walk barefoot by the ocean waves tomorrow morning.",
            futureSinhala = "අපි හෙට උදෑසන සාගර රළ අසලින් පාවහන් නොමැතිව ඇවිදින්නෙමු.",
            verbTransformation = "walked → walk → will walk"
          ),
          TenseSentenceItem(
            id = "t24_s2",
            baseActionSinhala = "වැලි මාලිගාවක් සෑදීම",
            pastEnglish = "Children built a big sandcastle with shells on top.",
            pastSinhala = "ළමයි උඩින් බෙල්ලන් සවි කර විශාල වැලි මාලිගාවක් හැදූහ.",
            presentEnglish = "Kids build sandcastles eagerly using buckets and spades.",
            presentSinhala = "කුඩා දරුවෝ බාල්දි සහ සවලවල් භාවිතයෙන් උනන්දුවෙන් වැලි මාලිගා හදති.",
            futureEnglish = "We will build a high sand fortress before the tide comes in.",
            futureSinhala = "දියරැල්ල පැමිණීමට පෙර අපි උස වැලි බලකොටුවක් හදන්නෙමු.",
            verbTransformation = "built → build → will build"
          ),
          TenseSentenceItem(
            id = "t24_s3",
            baseActionSinhala = "බෙල්ලන් එකතු කිරීම",
            pastEnglish = "Sister collected colorful seashells along the shore.",
            pastSinhala = "නංගී වෙරළ දිගේ වර්ණවත් සිප්පිකටු එකතු කළාය.",
            presentEnglish = "Beachcombers collect unique spiral shells washed ashore.",
            presentSinhala = "වෙරළේ ඇවිදින්නෝ වෙරළට ගසාගෙන එන සුවිශේෂී සිප්පිකටු එකතු කරති.",
            futureEnglish = "She will collect smooth sea glass pebbles this afternoon.",
            futureSinhala = "ඇය අද දහවල් සිනිඳු මුහුදු වීදුරු කැට එකතු කරනු ඇත.",
            verbTransformation = "collected → collect → will collect"
          ),
          TenseSentenceItem(
            id = "t24_s4",
            baseActionSinhala = "කූඩාරමක් ගැසීම",
            pastEnglish = "Campers pitched a sturdy canvas tent near the riverbank.",
            pastSinhala = "කඳවුරුකරුවෝ ගං ඉවුර අසල ශක්තිමත් කැන්වස් කූඩාරමක් ගැසූහ.",
            presentEnglish = "Scouts pitch tents systematically using pegs and ropes.",
            presentSinhala = "බාලදක්ෂයෝ කූඤ්ඤ සහ ලණු භාවිතයෙන් ක්‍රමානුකූලව කූඩාරම් ගසති.",
            futureEnglish = "We will pitch our tent before darkness falls.",
            futureSinhala = "අඳුර වැටීමට පෙර අපි අපගේ කූඩාරම ගසන්නෙමු.",
            verbTransformation = "pitched → pitch → will pitch"
          ),
          TenseSentenceItem(
            id = "t24_s5",
            baseActionSinhala = "විනෝද චාරිකා ආහාර ගැනීම",
            pastEnglish = "We had a picnic lunch under the shady pine trees.",
            pastSinhala = "අපි සෙවණැලි පිරි පයින් ගස් යට විනෝද චාරිකා දිවා ආහාරය ගත්තෙමු.",
            presentEnglish = "Families enjoy outdoor meals in public botanical gardens.",
            presentSinhala = "පවුල් උද්භිද උද්‍යානවල එළිමහන් ආහාර වේල් භුක්ති විඳිති.",
            futureEnglish = "We will eat sandwiches and fruit by the waterfall.",
            futureSinhala = "අපි දිය ඇල්ල අසලදී සැන්ඩ්විච් සහ පළතුරු කන්නෙමු.",
            verbTransformation = "had → enjoy → will eat"
          ),
          TenseSentenceItem(
            id = "t24_s6",
            baseActionSinhala = "මුහුදු රළ පැදීම (සර්ෆින්)",
            pastEnglish = "The surfer rode a massive wave at Arugam Bay.",
            pastSinhala = "සර්ෆින් ක්‍රීඩකයා ආරුගම්බේදී දැවැන්ත රළ පහරක් පැද්දේය.",
            presentEnglish = "Surfers ride ocean breakers with exceptional balance.",
            presentSinhala = "සර්ෆින් ක්‍රීඩකයෝ සුවිශේෂී සමබරතාවයකින් මුහුදු රළ මත ලිස්සා යති.",
            futureEnglish = "He will ride the morning barrels at first light.",
            futureSinhala = "ඔහු අලුයම මුල් ආලෝකයත් සමඟ උදෑසන රළ පදිනු ඇත.",
            verbTransformation = "rode → ride → will ride"
          ),
          TenseSentenceItem(
            id = "t24_s7",
            baseActionSinhala = "දිය ඇල්ලක ස්නානය කිරීම",
            pastEnglish = "We bathed in the cool freshwater pool below Dunhinda falls.",
            pastSinhala = "අපි දුන්හිඳ දිය ඇල්ල පහළ සිසිල් මිරිදිය තටාකයේ ස්නානය කළෙමු.",
            presentEnglish = "Visitors bathe in natural rock pools to escape tropical heat.",
            presentSinhala = "සංචාරකයෝ නිවර්තන උණුසුමෙන් මිදීමට ස්වභාවික ගල් තටාකවල දිය නාති.",
            futureEnglish = "We will bathe in the cascade after a long jungle hike.",
            futureSinhala = "දිගු වනාන්තර පාගමනකින් පසු අපි දිය ඇල්ලේ ස්නානය කරන්නෙමු.",
            verbTransformation = "bathed → bathe → will bathe"
          ),
          TenseSentenceItem(
            id = "t24_s8",
            baseActionSinhala = "කඳවුරු ගින්නක් දැල්වීම",
            pastEnglish = "Youths lit a warm campfire using dry logs.",
            pastSinhala = "තරුණයෝ වියළි දර කොට යොදාගෙන උණුසුම් කඳවුරු ගින්නක් දැල්වූහ.",
            presentEnglish = "Campfires provide warmth and camaraderie on chilly hill nights.",
            presentSinhala = "කඳවුරු ගිනි සිසිල් කඳුකර රාත්‍රීන්හි උණුසුම සහ සුහදත්වය ලබා දෙයි.",
            futureEnglish = "We will roast sweet corn over glowing embers.",
            futureSinhala = "අපි දිලිසෙන අඟුරු මත බඩඉරිඟු පුළුස්සන්නෙමු.",
            verbTransformation = "lit → provide → will roast"
          ),
          TenseSentenceItem(
            id = "t24_s9",
            baseActionSinhala = "හිරු නැගීම නැරඹීම",
            pastEnglish = "Pilgrims watched the glorious sunrise from Adam's Peak summit.",
            pastSinhala = "වන්දනාකරුවෝ ශ්‍රී පාද මුදුනේ සිට අසිරිමත් ඉර සේවය නැරඹූහ.",
            presentEnglish = "The 'Ira Sevaya' displays spectacular colors across morning clouds.",
            presentSinhala = "ඉර සේවය උදෑසන වලාකුළු මත විචිත්‍රවත් වර්ණ ප්‍රදර්ශනය කරයි.",
            futureEnglish = "We will watch dawn break over Horton Plains tomorrow.",
            futureSinhala = "අපි හෙට හෝර්ටන් තැන්නට උදෑසන උදාවන අයුරු නරඹන්නෙමු.",
            verbTransformation = "watched → displays → will watch"
          ),
          TenseSentenceItem(
            id = "t24_s10",
            baseActionSinhala = "ස්නෝකල් කර මසුන් බැලීම",
            pastEnglish = "We snorkeled among vibrant coral reefs at Pigeon Island.",
            pastSinhala = "අපි පරෙවි දූපතේ වර්ණවත් කොරල්පර අතර ස්නෝකල් කර මසුන් බැලුවෙමු.",
            presentEnglish = "Snorkelers admire colorful clownfish and sea turtles.",
            presentSinhala = "ස්නෝකල් කරන්නෝ වර්ණවත් මසුන් සහ මුහුදු කැස්බෑවන් අගය කරති.",
            futureEnglish = "We will snorkel in Hikkaduwa marine sanctuary next week.",
            futureSinhala = "අපි ලබන සතියේ හික්කඩුව සාගර අභයභූමියේ ස්නෝකල් කරන්නෙමු.",
            verbTransformation = "snorkeled → admire → will snorkel"
          ),
          TenseSentenceItem(
            id = "t24_s11",
            baseActionSinhala = "හිරු ආවරණ ක්‍රීම් ආලේප කිරීම",
            pastEnglish = "She applied sunscreen to prevent sunburn at midday.",
            pastSinhala = "දහවල් අව්වෙන් පිළිස්සීම වැළැක්වීමට ඇය හිරු ආවරණ ක්‍රීම් ආලේප කළාය.",
            presentEnglish = "Sun protection factor lotions shield skin from harmful UV rays.",
            presentSinhala = "හිරු ආවරණ ආලේපන හානිකර පාරජම්බුල කිරණවලින් සම ආරක්ෂා කරයි.",
            futureEnglish = "I will apply waterproof cream before diving into the sea.",
            futureSinhala = "මුහුදට බැසීමට පෙර මම ජලයට ඔරොත්තු දෙන ක්‍රීම් ආලේප කරන්නෙමි.",
            verbTransformation = "applied → shield → will apply"
          ),
          TenseSentenceItem(
            id = "t24_s12",
            baseActionSinhala = "කඳු නැගීම (හයිකින්)",
            pastEnglish = "The adventure group trekked up Ella Rock at sunrise.",
            pastSinhala = "ත්‍රාසජනක කණ්ඩායම හිරු උදාවේදී ඇල්ල රොක් කන්ද තරණය කළහ.",
            presentEnglish = "Mountain hikers conquer steep trails for panoramic vistas.",
            presentSinhala = "කඳු නගින්නෝ සුන්දර දර්ශන නැරඹීම සඳහා බෑවුම් සහිත මංපෙත් තරණය කරති.",
            futureEnglish = "We will hike to Little Adam's Peak tomorrow afternoon.",
            futureSinhala = "අපි හෙට සවස පුංචි සිරිපාදය තරණය කරන්නෙමු.",
            verbTransformation = "trekked → conquer → will hike"
          ),
          TenseSentenceItem(
            id = "t24_s13",
            baseActionSinhala = "බෝට්ටු සවාරියක් යාම",
            pastEnglish = "We took a motorboat safari across Madu Ganga lagoon.",
            pastSinhala = "අපි මාදු ගඟ කලපුව හරහා මෝටර් බෝට්ටු සවාරියක් ගියෙමු.",
            presentEnglish = "Boat tours explore dense mangrove ecosystems.",
            presentSinhala = "බෝට්ටු චාරිකා ඝන කඩොලාන පරිසර පද්ධති ගවේෂණය කරයි.",
            futureEnglish = "We will cruise to cinnamon island on the lake.",
            futureSinhala = "අපි වැවේ කුරුඳු දූපත වෙත බෝට්ටුවෙන් ගමන් කරන්නෙමු.",
            verbTransformation = "took → explore → will cruise"
          ),
          TenseSentenceItem(
            id = "t24_s14",
            baseActionSinhala = "ඡායාරූප ඇල්බමයක් සෑදීම",
            pastEnglish = "Mother created a scrapbook of our family holiday memories.",
            pastSinhala = "අම්මා අපගේ පවුලේ නිවාඩු මතකයන් සහිත ඡායාරූප ඇල්බමයක් හැදුවාය.",
            presentEnglish = "Holiday photographs preserve joyous moments with relatives.",
            presentSinhala = "නිවාඩු ඡායාරූප ඥාතීන් සමඟ ගත කළ ප්‍රීතිමත් අවස්ථා සදා මතකයේ රඳවයි.",
            futureEnglish = "We will print and frame our scenic summit pictures.",
            futureSinhala = "අපි කඳු මුදුනේ සුන්දර ඡායාරූප මුද්‍රණය කර රාමු කරන්නෙමු.",
            verbTransformation = "created → preserve → will print"
          ),
          TenseSentenceItem(
            id = "t24_s15",
            baseActionSinhala = "සමරු සිහිවටන මිලදී ගැනීම",
            pastEnglish = "I bought carved wooden elephants from the artisan shop.",
            pastSinhala = "මම කලා ශිල්ප වෙළඳසැලෙන් ලීයෙන් කැටයම් කළ අලි ඇතුන් මිලදී ගත්තෙමි.",
            presentEnglish = "Travelers buy indigenous crafts as souvenirs for friends.",
            presentSinhala = "සංචාරකයෝ මිතුරන්ට සිහිවටන ලෙස දේශීය අත්කම් භාණ්ඩ මිලදී ගනිති.",
            futureEnglish = "I will buy pure Ceylon tea packets for my colleagues.",
            futureSinhala = "මගේ සගයන් සඳහා මම පිරිසිදු සිලෝන් තේ පැකට් මිලදී ගන්නෙමි.",
            verbTransformation = "bought → buy → will buy"
          ),
          TenseSentenceItem(
            id = "t24_s16",
            baseActionSinhala = "තල්මසුන් නැරඹීම",
            pastEnglish = "Tourists spotted blue whales off the coast of Mirissa.",
            pastSinhala = "මිහිරිස්ස වෙරළට ඔබ්බෙන් සංචාරකයෝ නිල් තල්මසුන් දුටුවාහ.",
            presentEnglish = "Mirissa waters host migrating marine mammals annually.",
            presentSinhala = "මිරිස්ස මුහුදු තීරය වාර්ෂිකව සංක්‍රමණික සාගර ක්ෂීරපායින්ට රැකවරණය දෙයි.",
            futureEnglish = "We will take a whale-watching boat at 6:30 AM.",
            futureSinhala = "අපි උදෑසන 6:30 ට තල්මසුන් බලන බෝට්ටුවක නගින්නෙමු.",
            verbTransformation = "spotted → host → will take"
          ),
          TenseSentenceItem(
            id = "t24_s17",
            baseActionSinhala = "සරුංගල් යැවීම",
            pastEnglish = "Children flew colorful butterfly kites at Galle Face Green.",
            pastSinhala = "ළමයි ගාලු මුවදොර පිටියේ වර්ණවත් සමනල සරුංගල් යැව්වාහ.",
            presentEnglish = "Strong ocean breezes lift paper kites high into the blue sky.",
            presentSinhala = "ප්‍රබල මුහුදු සුළඟ නිල් අහසට කඩදාසි සරුංගල් ඉහළට ඔසවා තබයි.",
            futureEnglish = "We will fly a giant tail kite on Sunday evening.",
            futureSinhala = "අපි ඉරිදා සවස විශාල වලිගයක් සහිත සරුංගලයක් යවන්නෙමු.",
            verbTransformation = "flew → lift → will fly"
          ),
          TenseSentenceItem(
            id = "t24_s18",
            baseActionSinhala = "ගමන් මලු ඇසිරීම",
            pastEnglish = "We packed our backpacks with warm sweaters and jackets.",
            pastSinhala = "අපි උණුසුම් ස්වීටර් සහ ජැකට්වලින් අපේ පසුම්බි ඇසුරුවෙමු.",
            presentEnglish = "Experienced travelers pack light and carry essential toiletries.",
            presentSinhala = "පළපුරුදු සංචාරකයෝ අඩු බරින් සහ අත්‍යවශ්‍ය දෑ පමණක් අසුරති.",
            futureEnglish = "I will pack raincoats in case of sudden showers.",
            futureSinhala = "හදිසි වැසි ඇති වුවහොත් භාවිතයට මම වැහි කබා අසුරන්නෙමි.",
            verbTransformation = "packed → pack → will pack"
          ),
          TenseSentenceItem(
            id = "t24_s19",
            baseActionSinhala = "උණුසුම් උල්පත් නැරඹීම",
            pastEnglish = "Visitors bathed their feet in the thermal hot springs at Kanniya.",
            pastSinhala = "සංචාරකයෝ කන්නියා උණුදිය උල්පත්වල තම පාද තවා ගත්හ.",
            presentEnglish = "Mineral-rich thermal waters soothe muscular aches naturally.",
            presentSinhala = "ඛනිජ බහුල උණුදිය ස්වභාවිකව මාංශ පේශි වේදනාවන් සමනය කරයි.",
            futureEnglish = "We will visit the Madunagala hot springs next month.",
            futureSinhala = "අපි ලබන මාසයේ මදුනාගල උණුදිය උල්පත් නරඹන්නෙමු.",
            verbTransformation = "bathed → soothe → will visit"
          ),
          TenseSentenceItem(
            id = "t24_s20",
            baseActionSinhala = "දුම්රියෙන් කඳුකරයට ගමන් කිරීම",
            pastEnglish = "We rode the scenic blue train over the Nine Arch Bridge.",
            pastSinhala = "අපි ආරුක්කු නමයේ පාලම මතින් සුන්දර නිල් පැහැති කඳුකර දුම්රියේ ගමන් කළෙමු.",
            presentEnglish = "The Colombo-Badulla railway provides one of the world's prettiest journeys.",
            presentSinhala = "කොළඹ-බදුල්ල දුම්රිය මාර්ගය ලොව සුන්දරතම දුම්රිය චාරිකාවලින් එකකි.",
            futureEnglish = "We will lean out of the observation carriage window.",
            futureSinhala = "අපි නැරඹුම් මැදිරියේ කවුළුවෙන් පිටතට හිස යොමු කර බලන්නෙමු.",
            verbTransformation = "rode → provides → will lean"
          ),
          TenseSentenceItem(
            id = "t24_s21",
            baseActionSinhala = "වෙරළ පිරිසිදු කිරීම",
            pastEnglish = "Volunteers cleaned plastic trash and bottles from the shoreline.",
            pastSinhala = "ස්වේච්ඡා සේවකයෝ වෙරළ තීරයෙන් ප්ලාස්ටික් කසළ සහ බෝතල් පිරිසිදු කළහ.",
            presentEnglish = "Eco-conscious vacationers leave only footprints on the sand.",
            presentSinhala = "පරිසර හිතකාමී සංචාරකයෝ වැලි මත පා සටහන් පමණක් ඉතිරි කරති.",
            futureEnglish = "We will collect litter into designated recycling bags.",
            futureSinhala = "අපි නම් කළ ප්‍රතිචක්‍රීකරණ බෑග්වලට කසළ එකතු කරන්නෙමු.",
            verbTransformation = "cleaned → leave → will collect"
          ),
          TenseSentenceItem(
            id = "t24_s22",
            baseActionSinhala = "පැරණි නටබුන් නැරඹීම",
            pastEnglish = "Students explored ancient Sigiriya fortress rock.",
            pastSinhala = "සිසුහු පැරණි සීගිරිය බලකොටු පර්වතය ගවේෂණය කළහ.",
            presentEnglish = "Sri Lanka's Cultural Triangle showcases centuries of architectural genius.",
            presentSinhala = "ශ්‍රී ලංකාවේ සංස්කෘතික ත්‍රිකෝණය ශතවර්ෂ ගණනාවක වාස්තු විද්‍යාත්මක ප්‍රතිභාව ප්‍රදර්ශනය කරයි.",
            futureEnglish = "We will climb to the summit palace ruins tomorrow morning.",
            futureSinhala = "අපි හෙට උදෑසන කඳු මුදුනේ රජමාලිගා නටබුන් වෙත නගින්නෙමු.",
            verbTransformation = "explored → showcases → will climb"
          ),
          TenseSentenceItem(
            id = "t24_s23",
            baseActionSinhala = "සෆාරි ජිප් රථයක යාම",
            pastEnglish = "The tracker drove the jeep deep into the scrub jungle.",
            pastSinhala = "මඟපෙන්වන්නා ලඳු කැලය ගැඹුරට ජිප් රථය පදවාගෙන ගියේය.",
            presentEnglish = "Safari jeeps provide rugged transit across wild terrains.",
            presentSinhala = "සෆාරි ජිප් රථ රළු වනගත භූමි හරහා ගමන් කිරීමට පහසුකම් සලසයි.",
            futureEnglish = "We will spot wild leopards resting upon massive granite boulders.",
            futureSinhala = "විශාල කළුගල් පර්වත මත විවේක ගන්නා වනගත කොටියන් අපි දකින්නෙමු.",
            verbTransformation = "drove → provide → will spot"
          ),
          TenseSentenceItem(
            id = "t24_s24",
            baseActionSinhala = "හිරු බැසීම නැරඹීම",
            pastEnglish = "We admired the crimson sunset from the ramparts of Galle Fort.",
            pastSinhala = "අපි ගාලු කොටු පවුරේ සිට රත්පැහැ හිරු බැසීම අගය කළෙමු.",
            presentEnglish = "Evening sunsets over the Indian Ocean inspire tranquil reflection.",
            presentSinhala = "ඉන්දියන් සාගරය මත සන්ධ්‍යා හිරු බැසීම සන්සුන් මෙනෙහි කිරීමකට මඟ පාදයි.",
            futureEnglish = "We will photograph the lighthouse as evening shadows lengthen.",
            futureSinhala = "සන්ධ්‍යා සෙවණැලි දිගු වන විට අපි ප්‍රදීපාගාරය ඡායාරූප ගත කරන්නෙමු.",
            verbTransformation = "admired → inspire → will photograph"
          ),
          TenseSentenceItem(
            id = "t24_s25",
            baseActionSinhala = "ප්‍රදීපාගාරයක් නැරඹීම",
            pastEnglish = "We climbed the winding spiral staircase of Dondra Head lighthouse.",
            pastSinhala = "අපි දෙවුන්දර තුඩුව ප්‍රදීපාගාරයේ කරකැවෙන සර්පිලාකාර පඩිපෙළ නැග්ගෙමු.",
            presentEnglish = "Lighthouses guide maritime vessels safely around rocky capes.",
            presentSinhala = "ප්‍රදීපාගාර ගල්පර සහිත තුඩු වටා මුහුදු යාත්‍රා ආරක්ෂිතව මෙහෙයවයි.",
            futureEnglish = "The light beam will flash across the dark southern ocean.",
            futureSinhala = "ආලෝක කදම්භය අඳුරු දක්ෂිණ සාගරය හරහා දිදුලනු ඇත.",
            verbTransformation = "climbed → guide → will flash"
          ),
          TenseSentenceItem(
            id = "t24_s26",
            baseActionSinhala = "අන්නාසි කෑම",
            pastEnglish = "We ate sweet, juicy pineapple slices sprinkled with chili powder.",
            pastSinhala = "අපි මිරිස් කුඩු ඉසින ලද පැණිරස ඉස්ම පිරි අන්නාසි පෙති කෑවෙමු.",
            presentEnglish = "Roadside tropical fruit stalls refresh tired road trip travelers.",
            presentSinhala = "මහාමාර්ග අයිනේ නිවර්තන පලතුරු කඩ වෙහෙසට පත් සංචාරකයන් ප්‍රබෝධමත් කරයි.",
            futureEnglish = "We will buy freshly picked strawberries in Nuwara Eliya.",
            futureSinhala = "අපි නුවරඑළියෙන් අලුතින් නෙළූ නැවුම් ස්ට්‍රෝබෙරි මිලදී ගන්නෙමු.",
            verbTransformation = "ate → refresh → will buy"
          ),
          TenseSentenceItem(
            id = "t24_s27",
            baseActionSinhala = "වෙරළ වොලිබෝල් ක්‍රීඩා කිරීම",
            pastEnglish = "The cousins played beach volleyball on the soft sand.",
            pastSinhala = "ඥාති සහෝදරයෝ මෘදු වැලි මත වෙරළ වොලිබෝල් ක්‍රීඩා කළහ.",
            presentEnglish = "Beach sports invigorate holidaymakers of all age groups.",
            presentSinhala = "වෙරළ ක්‍රීඩා සියලුම වයස් කාණ්ඩවල නිවාඩු ගත කරන්නන් ප්‍රබෝධමත් කරයි.",
            futureEnglish = "We will hold a friendly volleyball match this evening.",
            futureSinhala = "අද සවස අපි සුහද වොලිබෝල් තරඟයක් පවත්වන්නෙමු.",
            verbTransformation = "played → invigorate → will hold"
          ),
          TenseSentenceItem(
            id = "t24_s28",
            baseActionSinhala = "වෙරළේ නිදාගැනීම / විවේක ගැනීම",
            pastEnglish = "Father relaxed under the shade of a coconut palm.",
            pastSinhala = "තාත්තා පොල් ගසක සෙවණ යට විවේක ගත්තේය.",
            presentEnglish = "Listening to gentle ocean surf relieves accumulated stress.",
            presentSinhala = "සාගර රළ හඬට සවන් දීම රැස් වූ ආතතිය දුරු කරයි.",
            futureEnglish = "I will lie in a hammock and read my adventure book.",
            futureSinhala = "මම දැල් ඇඳක වැතිර මගේ වික්‍රමාන්විත පොත කියවන්නෙමි.",
            verbTransformation = "relaxed → relieves → will lie"
          ),
          TenseSentenceItem(
            id = "t24_s29",
            baseActionSinhala = "නිවාඩු අවසානයේ ආපසු නිවසට පැමිණීම",
            pastEnglish = "We returned home refreshed and invigorated on Sunday night.",
            pastSinhala = "අපි ඉරිදා රාත්‍රියේ ප්‍රබෝධමත්ව සහ නව පණක් ලබා ආපසු නිවසට පැමිණියෙමු.",
            presentEnglish = "Memorable holiday journeys strengthen family bonds deeply.",
            presentSinhala = "මතකයේ රැඳෙන නිවාඩු චාරිකා පවුලේ බැඳීම් ගැඹුරින් ශක්තිමත් කරයි.",
            futureEnglish = "We will plan our next coastal holiday for August.",
            futureSinhala = "අපි අපගේ ඊළඟ වෙරළබඩ නිවාඩුව අගෝස්තු මාසයට සැලසුම් කරන්නෙමු.",
            verbTransformation = "returned → strengthen → will plan"
          ),
          TenseSentenceItem(
            id = "t24_s30",
            baseActionSinhala = "ලස්සන ලෝකය අගය කිරීම",
            pastEnglish = "We experienced the wonders of our enchanting island home.",
            pastSinhala = "අපගේ මනස්කාන්ත දිවයිනේ අසිරිය අපි අත්වින්දෙමු.",
            presentEnglish = "Traveling broadens horizons and teaches timeless worldly wisdom.",
            presentSinhala = "සංචාරය කිරීම ක්ෂිතිජයන් පුළුල් කර සදාකාලික ලෝක ඥානය උගන්වයි.",
            futureEnglish = "You will cherish these joyful memories for a lifetime.",
            futureSinhala = "ඔබ මෙම ප්‍රීතිමත් මතකයන් ජීවිත කාලය පුරාම ආදරයෙන් සුරක්ෂිත කරනු ඇත.",
            verbTransformation = "experienced → broadens → will cherish"
          )
        )
      ),

      // ==========================================
      // Category 25: සමාජ සත්කාර සහ ස්වේච්ඡා සේවය (Community Service & Volunteering) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 25,
        titleSinhala = "කාණ්ඩය 25: සමාජ සත්කාර සහ ස්වේච්ඡා සේවය",
        titleEnglish = "Community Service & Volunteering",
        icon = "🤝",
        description = "ශ්‍රමදාන, රෝහල් උපකාර, වැඩිහිටි නිවාස සත්කාර සහ ප්‍රජා සේවාව පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t25_s1",
            baseActionSinhala = "ශ්‍රමදානයකට සහභාගී වීම",
            pastEnglish = "Villagers joined a Shramadana campaign to clean the village canal.",
            pastSinhala = "ගමේ ඇළ මාර්ගය පිරිසිදු කිරීමට ගම්වැසියෝ ශ්‍රමදානයකට එක්වූහ.",
            presentEnglish = "Voluntary Shramadana work builds strong communal harmony.",
            presentSinhala = "ස්වේච්ඡා ශ්‍රමදාන කටයුතු ප්‍රබල සමාජ සහජීවනයක් ගොඩනඟයි.",
            futureEnglish = "We will clear the overgrown village cemetery tomorrow.",
            futureSinhala = "අපි හෙට කැලෑවෙන් වැසුණු ගමේ සුසාන භූමිය ශුද්ධ පවිත්‍ර කරන්නෙමු.",
            verbTransformation = "joined → builds → will clear"
          ),
          TenseSentenceItem(
            id = "t25_s2",
            baseActionSinhala = "වැඩිහිටි නිවාසයකට දානයක් දීම",
            pastEnglish = "Our family offered a healthy lunch to the elders' home.",
            pastSinhala = "අපේ පවුල වැඩිහිටි නිවාසයට ගුණදායක දිවා ආහාරයක් පූජා කළහ.",
            presentEnglish = "Compassionate citizens care for senior citizens with love.",
            presentSinhala = "කාරුණික පුරවැසියෝ ජ්‍යෙෂ්ඨ පුරවැසියන් ආදරයෙන් රැකබලා ගනිති.",
            futureEnglish = "We will distribute warm blankets and medicines next month.",
            futureSinhala = "අපි ලබන මාසයේ උණුසුම් බ්ලැන්කට් සහ ඖෂධ බෙදා දෙන්නෙමු.",
            verbTransformation = "offered → care → will distribute"
          ),
          TenseSentenceItem(
            id = "t25_s3",
            baseActionSinhala = "රුක් රෝපණ වැඩසටහනක් පැවැත්වීම",
            pastEnglish = "The youth club planted five hundred Mee and Kumbuk saplings.",
            pastSinhala = "තරුණ සමාජය මී සහ කුඹුක් පැළ පන්සියයක් සිටුවූහ.",
            presentEnglish = "Tree planting restores riverbanks and combats soil erosion.",
            presentSinhala = "ගස් සිටුවීම ගං ඉවුරු ප්‍රතිසංස්කරණය කර පස් ඛාදනය වළක්වයි.",
            futureEnglish = "We will plant shade trees along the main highway.",
            futureSinhala = "අපි ප්‍රධාන මහාමාර්ගය දිගේ සෙවණ දෙන ගස් සිටුවන්නෙමු.",
            verbTransformation = "planted → restores → will plant"
          ),
          TenseSentenceItem(
            id = "t25_s4",
            baseActionSinhala = "පාසල් උපකරණ බෙදා දීම",
            pastEnglish = "The charity distributed schoolbags and stationery to needy students.",
            pastSinhala = "පුණ්‍යායතනය අඩු ආදායම්ලාභී සිසුන්ට පාසල් බෑග් සහ ලිපිද්‍රව්‍ය බෙදා දුන්නේය.",
            presentEnglish = "Educational sponsorships brighten the future of underprivileged kids.",
            presentSinhala = "අධ්‍යාපනික අනුග්‍රහයන් දුෂ්කර දරුවන්ගේ අනාගතය ආලෝකමත් කරයි.",
            futureEnglish = "We will donate exercise books before the new school term begins.",
            futureSinhala = "නව පාසල් වාරය ආරම්භ වීමට පෙර අපි අභ්‍යාස පොත් පරිත්‍යාග කරන්නෙමු.",
            verbTransformation = "distributed → brighten → will donate"
          ),
          TenseSentenceItem(
            id = "t25_s5",
            baseActionSinhala = "රෝහල් පරිශ්‍රය පිරිසිදු කිරීම",
            pastEnglish = "Volunteers painted hospital ward walls and cleared surroundings.",
            pastSinhala = "ස්වේච්ඡා සේවකයෝ රෝහල් වාට්ටු බිත්ති තීන්ත ආලේප කර වටපිටාව ශුද්ධ කළහ.",
            presentEnglish = "Clean therapeutic surroundings aid speedy recovery of patients.",
            presentSinhala = "පිරිසිදු ප්‍රතිකාරක පරිසරයක් රෝගීන් ඉක්මනින් සුවය ලැබීමට උපකාරී වේ.",
            futureEnglish = "We will construct a shaded waiting pavilion for visitors.",
            futureSinhala = "අපි රෝගීන් බැලීමට එන්නන් වෙනුවෙන් සෙවණැලි සහිත රැඳවුම් මඩුවක් හදන්නෙමු.",
            verbTransformation = "painted → aid → will construct"
          ),
          TenseSentenceItem(
            id = "t25_s6",
            baseActionSinhala = "නොමිලේ වෛද්‍ය සායනයක් පැවැත්වීම",
            pastEnglish = "Doctors conducted a free mobile eye examination clinic.",
            pastSinhala = "වෛද්‍යවරු නොමිලේ ජංගම අක්ෂි පරීක්ෂණ සායනයක් පැවැත්වූහ.",
            presentEnglish = "Mobile clinics provide healthcare to remote rural settlements.",
            presentSinhala = "ජංගම සායන දුරස්ථ ග්‍රාමීය ජනාවාස වෙත සෞඛ්‍ය සේවා ලබා දෙයි.",
            futureEnglish = "Specialists will distribute free reading spectacles next Sunday.",
            futureSinhala = "විශේෂඥ වෛද්‍යවරු ලබන ඉරිදා නොමිලේ කියවීමේ උපැස් යුවළ බෙදා දෙනු ඇත.",
            verbTransformation = "conducted → provide → will distribute"
          ),
          TenseSentenceItem(
            id = "t25_s7",
            baseActionSinhala = "අනාථ දරුවන්ට සතුට ගෙන දීම",
            pastEnglish = "University students organized a musical evening for the children's home.",
            pastSinhala = "විශ්වවිද්‍යාල සිසුහු ළමා නිවාසය වෙනුවෙන් සංගීතමය සන්ධ්‍යාවක් සංවිධානය කළහ.",
            presentEnglish = "Genuine affection brings smiles to vulnerable orphans.",
            presentSinhala = "අවංක ආදරය අහිංසක අනාථ දරුවන්ගේ මුවඟට සිනහව ගෙන එයි.",
            futureEnglish = "We will take the children on a guided zoo excursion.",
            futureSinhala = "අපි ළමයින්ව සත්වෝද්‍යානය නැරඹීමේ චාරිකාවකට කැඳවාගෙන යන්නෙමු.",
            verbTransformation = "organized → brings → will take"
          ),
          TenseSentenceItem(
            id = "t25_s8",
            baseActionSinhala = "ඩෙංගු මර්දන ව්‍යාපාරයක යෙදීම",
            pastEnglish = "Public health inspectors inspected home gardens for mosquito breeding.",
            pastSinhala = "මහජන සෞඛ්‍ය පරීක්ෂකවරු මදුරුවන් බෝවන ස්ථාන සඳහා ගෙවතු පරීක්ෂා කළහ.",
            presentEnglish = "Eradicating stagnant water pools arrests dengue transmission.",
            presentSinhala = "රැඳී ඇති ජල බඳුන් විනාශ කිරීම ඩෙංගු පැතිරීම වළක්වයි.",
            futureEnglish = "We will clear clogged drains and discarded coconut shells.",
            futureSinhala = "අපි අවහිර වූ කානු සහ ඉවතලන පොල්කටු ඉවත් කරන්නෙමු.",
            verbTransformation = "inspected → arrests → will clear"
          ),
          TenseSentenceItem(
            id = "t25_s9",
            baseActionSinhala = "දන්සලක් දීම",
            pastEnglish = "The youth society served free rice packets to thousands of pilgrims.",
            pastSinhala = "තරුණ සමිතිය දහස් ගණන් වන්දනාකරුවන්ට නොමිලේ බත් පාර්සල් පිරිනැමීය.",
            presentEnglish = "Dansalas exemplify legendary Sri Lankan hospitality during Poson.",
            presentSinhala = "දන්සල් පොසොන් සමයේ පුරාවෘත්ත ශ්‍රී ලාංකේය ත්‍යාගශීලී බව විදහා දක්වයි.",
            futureEnglish = "We will organize an ice cream and herbal drink dansala.",
            futureSinhala = "අපි අයිස්ක්‍රීම් සහ ඖෂධීය පාන දන්සලක් සංවිධානය කරන්නෙමු.",
            verbTransformation = "served → exemplify → will organize"
          ),
          TenseSentenceItem(
            id = "t25_s10",
            baseActionSinhala = "විශේෂ අවශ්‍යතා සහිත අයට උපකාර කිරීම",
            pastEnglish = "Scouts helped wheelchair users access the main temple shrine.",
            pastSinhala = "රෝද පුටු භාවිත කරන්නන්ට ප්‍රධාන විහාර මන්දිරයට පිවිසීමට බාලදක්ෂයෝ උපකාර කළහ.",
            presentEnglish = "Accessible ramps empower differently abled people with dignity.",
            presentSinhala = "ප්‍රවේශ බෑවුම් විශේෂ අවශ්‍යතා සහිත අයට ගෞරවයෙන් සැරිසැරීමට ශක්තියක් වේ.",
            futureEnglish = "We will construct tactile paving along public footpaths.",
            futureSinhala = "අපි පොදු පදික වේදිකා දිගේ ස්පර්ශ සංවේදී ගල් අතුරන්නෙමු.",
            verbTransformation = "helped → empower → will construct"
          ),
          TenseSentenceItem(
            id = "t25_s11",
            baseActionSinhala = "අවශ්‍යතා සහිත අයට ඇඳුම් දීම",
            pastEnglish = "Families donated clean clothes to the rural welfare center.",
            pastSinhala = "පවුල් ග්‍රාමීය සුබසාධන මධ්‍යස්ථානයට පිරිසිදු ඇඳුම් පරිත්‍යාග කළහ.",
            presentEnglish = "Sharing unused apparel brings immense comfort to those in need.",
            presentSinhala = "භාවිත නොකරන ඇඳුම් බෙදාහදා ගැනීම අවශ්‍යතා සහිත අයට මහත් සහනයක් ගෙන දෙයි.",
            futureEnglish = "We will organize a winter jacket collection drive for hill country workers.",
            futureSinhala = "කඳුකර වතු සේවකයන් සඳහා අපි ශීත ජැකට් එකතු කිරීමේ ව්‍යාපාරයක් සංවිධානය කරන්නෙමු.",
            verbTransformation = "donated → brings → will organize"
          ),
          TenseSentenceItem(
            id = "t25_s12",
            baseActionSinhala = "නොමිලේ ඉංග්‍රීසි ඉගැන්වීම",
            pastEnglish = "The volunteer teacher taught spoken English to village children.",
            pastSinhala = "ස්වේච්ඡා ගුරුතුමිය ගමේ දරුවන්ට කථන ඉංග්‍රීසි ඉගැන්වූවාය.",
            presentEnglish = "Language fluency unlocks doors to higher education and careers.",
            presentSinhala = "භාෂා චතුරතාව උසස් අධ්‍යාපනයට සහ වෘත්තීන්ට දොරගුළු විවර කරයි.",
            futureEnglish = "I will conduct free conversational English classes on weekends.",
            futureSinhala = "මම සති අන්තවල නොමිලේ කථන ඉංග්‍රීසි පන්ති පවත්වන්නෙමු.",
            verbTransformation = "taught → unlocks → will conduct"
          ),
          TenseSentenceItem(
            id = "t25_s13",
            baseActionSinhala = "අසරණ සතුන් බේරා ගැනීම",
            pastEnglish = "The welfare group rescued abandoned puppies from the streets.",
            pastSinhala = "සුබසාධන කණ්ඩායම මහාමාර්ගයේ අතහැර දමා තිබූ බලු පැටවුන් බේරා ගත්හ.",
            presentEnglish = "Animal rescue shelters rehome stray pets with loving owners.",
            presentSinhala = "සත්ව ගලවා ගැනීමේ මධ්‍යස්ථාන අතරමං වූ සුරතලුන්ට ආදරණීය හිමිකරුවන් සොයා දෙයි.",
            futureEnglish = "We will sponsor sterilization drives for stray cats.",
            futureSinhala = "අපි අතරමං වූ පූසන් සඳහා වන්ධ්‍යාකරණ වැඩසටහන් සඳහා අනුග්‍රහය දක්වන්නෙමු.",
            verbTransformation = "rescued → rehome → will sponsor"
          ),
          TenseSentenceItem(
            id = "t25_s14",
            baseActionSinhala = "ප්‍රජා ජල පෙරහන් සවි කිරීම",
            pastEnglish = "The charity installed a reverse-osmosis water filter in the village.",
            pastSinhala = "පුණ්‍යායතනය ගමේ ප්‍රති-ආස්‍රැති ජල පෙරහන් පද්ධතියක් සවි කළේය.",
            presentEnglish = "Purified water prevents chronic kidney disease in farming belts.",
            presentSinhala = "පිරිසිදු කළ ජලය ගොවි ජනපදවල නිදන්ගත වකුගඩු රෝගය වළක්වයි.",
            futureEnglish = "We will install water purifiers in five more primary schools.",
            futureSinhala = "අපි තවත් ප්‍රාථමික පාසල් පහක ජල පිරිපහදු යන්ත්‍ර සවි කරන්නෙමු.",
            verbTransformation = "installed → prevents → will install"
          ),
          TenseSentenceItem(
            id = "t25_s15",
            baseActionSinhala = "ස්වේච්ඡා ලේඛකයෙකු ලෙස කටයුතු කිරීම",
            pastEnglish = "She recorded audiobook versions for visually impaired students.",
            pastSinhala = "ඇය පෙනීම දුර්වල සිසුන් සඳහා ශ්‍රව්‍ය පොත් පටිගත කළාය.",
            presentEnglish = "Audio literature empowers blind learners to excel academically.",
            presentSinhala = "ශ්‍රව්‍ය සාහිත්‍යය දෘශ්‍යාබාධිත සිසුන්ට අධ්‍යාපනයෙන් දස්කම් දැක්වීමට ශක්තියක් වේ.",
            futureEnglish = "I will transcribe science texts into accessible Braille.",
            futureSinhala = "මම විද්‍යා පාඩම් බ්‍රේල් ක්‍රමයට පිටපත් කරන්නෙමු.",
            verbTransformation = "recorded → empowers → will transcribe"
          ),
          TenseSentenceItem(
            id = "t25_s16",
            baseActionSinhala = "ප්‍රජා පුස්තකාලයක් පිහිටුවීම",
            pastEnglish = "The youth club established a reading room with donated books.",
            pastSinhala = "තරුණ සමිතිය පරිත්‍යාග කළ පොත්වලින් කියවීම් ශාලාවක් පිහිටුවීය.",
            presentEnglish = "Village libraries cultivate vibrant intellectual curiosities.",
            presentSinhala = "ගමේ පුස්තකාල ප්‍රබල බුද්ධිමය කුතුහලයක් පෝෂණය කරයි.",
            futureEnglish = "We will add internet access terminals for students.",
            futureSinhala = "අපි සිසුන් සඳහා අන්තර්ජාල ප්‍රවේශ පරිගණක එකතු කරන්නෙමු.",
            verbTransformation = "established → cultivate → will add"
          ),
          TenseSentenceItem(
            id = "t25_s17",
            baseActionSinhala = "ගංවතුර සහනාධාර ඇසිරීම",
            pastEnglish = "Volunteers packed emergency dry rations into relief bags.",
            pastSinhala = "ස්වේච්ඡා සේවකයෝ හදිසි වියළි සලාක සහන බෑග්වලට ඇසුරූහ.",
            presentEnglish = "Swift coordination delivers relief goods to affected disaster victims.",
            presentSinhala = "ක්ෂණික සම්බන්ධීකරණය විපතට පත් ආපදා වින්දිතයන්ට සහන ද්‍රව්‍ය සපයයි.",
            futureEnglish = "We will load relief trucks bound for flood-hit towns.",
            futureSinhala = "ගංවතුරෙන් පීඩිත නගර බලා යන සහන ලොරි රථවලට අපි බඩු පටවන්නෙමු.",
            verbTransformation = "packed → delivers → will load"
          ),
          TenseSentenceItem(
            id = "t25_s18",
            baseActionSinhala = "අසල්වැසියන්ට උදව් කිරීම",
            pastEnglish = "Kamal helped the elderly neighbor paint her wooden fence.",
            pastSinhala = "කමල් වැඩිහිටි අසල්වැසි කාන්තාවට ඇගේ ලී වැට තීන්ත ආලේප කිරීමට උදව් කළේය.",
            presentEnglish = "Good neighbors share burdens and cultivate peace.",
            presentSinhala = "යහපත් අසල්වැසියෝ දුක් කරදර බෙදාහදා ගෙන සාමය වර්ධනය කරති.",
            futureEnglish = "I will fetch her groceries from the weekly market.",
            futureSinhala = "සතිපොළෙන් මම ඇයට අවශ්‍ය බඩු මුට්ටු ගෙනැවිත් දෙන්නෙමි.",
            verbTransformation = "helped → share → will fetch"
          ),
          TenseSentenceItem(
            id = "t25_s19",
            baseActionSinhala = "පොදු ස්ථාන පිරිසිදුව තබා ගැනීම",
            pastEnglish = "Children collected discarded polythene bags from the public playground.",
            pastSinhala = "ළමයි පොදු ක්‍රීඩාංගනයෙන් ඉවතලන පොලිතින් බෑග් එකතු කළහ.",
            presentEnglish = "Civic responsibility keeps community recreation grounds spotless.",
            presentSinhala = "පුරවැසි වගකීම ප්‍රජා විනෝදාස්වාද ස්ථාන පිරිසිදුව තබයි.",
            futureEnglish = "We will install color-coded waste segregation bins.",
            futureSinhala = "අපි වර්ණ කේත සහිත කසළ වෙන් කිරීමේ බඳුන් සවි කරන්නෙමු.",
            verbTransformation = "collected → keeps → will install"
          ),
          TenseSentenceItem(
            id = "t25_s20",
            baseActionSinhala = "මහජන විදුලි ලාම්පු සවි කිරීම",
            pastEnglish = "The village development society installed solar streetlights along dark paths.",
            pastSinhala = "ග්‍රාම සංවර්ධන සමිතිය අඳුරු මාර්ග දිගේ සූර්ය වීදි ලාම්පු සවි කළේය.",
            presentEnglish = "Streetlights enhance night security for women and children.",
            presentSinhala = "වීදි ලාම්පු රාත්‍රී කාලයේ කාන්තාවන්ගේ සහ දරුවන්ගේ ආරක්ෂාව වැඩි කරයි.",
            futureEnglish = "We will illuminate the dark temple junction.",
            futureSinhala = "අපි අඳුරු පන්සල් හන්දිය ආලෝකමත් කරන්නෙමු.",
            verbTransformation = "installed → enhance → will illuminate"
          ),
          TenseSentenceItem(
            id = "t25_s21",
            baseActionSinhala = "ළමුන් සඳහා ක්‍රීඩා පුහුණුව",
            pastEnglish = "The retired coach trained village youths in athletic track events.",
            pastSinhala = "විශ්‍රාමික පුහුණුකරු ගමේ තරුණයන්ට මලල ක්‍රීඩා ධාවන ඉසව් පුහුණු කළේය.",
            presentEnglish = "Grassroots sports coaching nurtures national sporting champions.",
            presentSinhala = "ග්‍රාමීය ක්‍රීඩා පුහුණුව ජාතික ක්‍රීඩා ශූරයන් බිහි කරයි.",
            futureEnglish = "He will organize an inter-village volleyball tournament.",
            futureSinhala = "ඔහු ගම්මාන අතර වොලිබෝල් තරඟාවලියක් සංවිධානය කරනු ඇත.",
            verbTransformation = "trained → nurtures → will organize"
          ),
          TenseSentenceItem(
            id = "t25_s22",
            baseActionSinhala = "කාන්තා සවිබල ගැන්වීම",
            pastEnglish = "The NGO conducted sewing and handloom training for rural mothers.",
            pastSinhala = "රාජ්‍ය නොවන සංවිධානය ගැමි මව්වරුන් සඳහා මැහුම් සහ අත්යන්ත්‍ර පුහුණුවක් පැවැත්වීය.",
            presentEnglish = "Vocational skills create independent sustainable livelihoods.",
            presentSinhala = "වෘත්තීය කුසලතා ස්වාධීන තිරසාර ජීවනෝපායන් නිර්මාණය කරයි.",
            futureEnglish = "We will help them market handloom products online.",
            futureSinhala = "ඔවුන්ගේ අත්යන්ත්‍ර නිෂ්පාදන මාර්ගගතව අලෙවි කිරීමට අපි උපකාර කරන්නෙමු.",
            verbTransformation = "conducted → create → will help"
          ),
          TenseSentenceItem(
            id = "t25_s23",
            baseActionSinhala = "පාසල් ගොඩනැගිල්ලක් අලුත්වැඩියා කිරීම",
            pastEnglish = "Parents repaired the leaking school roof before heavy monsoons.",
            pastSinhala = "තද මෝසම් වැස්සට පෙර දෙමව්පියෝ කාන්දු වන පාසල් වහලය අලුත්වැඩියා කළහ.",
            presentEnglish = "Parent-teacher associations maintain wholesome learning spaces.",
            presentSinhala = "ගුරු-දෙගුරු සමිති යහපත් ඉගෙනුම් පරිසරයන් පවත්වා ගනී.",
            futureEnglish = "We will paint classroom desks and repair windows.",
            futureSinhala = "අපි පන්ති කාමර මේස තීන්ත ආලේප කර ජනෙල් අලුත්වැඩියා කරන්නෙමු.",
            verbTransformation = "repaired → maintain → will paint"
          ),
          TenseSentenceItem(
            id = "t25_s24",
            baseActionSinhala = "වෘත්තීය මාර්ගෝපදේශන සැසියක් පැවැත්වීම",
            pastEnglish = "Professionals guided high school leavers regarding job choices.",
            pastSinhala = "වෘත්තිකයෝ පාසල් හැර යන සිසුන්ට රැකියා තේරීම් ගැන මඟ පෙන්වූහ.",
            presentEnglish = "Career mentoring prevents youth unemployment and aimlessness.",
            presentSinhala = "වෘත්තීය උපදේශනය තරුණ විරැකියාව සහ අරමුණක් නොමැතිකම වළක්වයි.",
            futureEnglish = "We will conduct mock interviews for job applicants next week.",
            futureSinhala = "රැකියා අපේක්ෂකයන් වෙනුවෙන් අපි ලබන සතියේ ආදර්ශ සම්මුඛ පරීක්ෂණ පවත්වන්නෙමු.",
            verbTransformation = "guided → prevents → will conduct"
          ),
          TenseSentenceItem(
            id = "t25_s25",
            baseActionSinhala = "පරිසර හිතකාමී බෑග් බෙදා දීම",
            pastEnglish = "The eco-club distributed reusable cloth shopping bags.",
            pastSinhala = "පරිසර සමාජය නැවත භාවිත කළ හැකි රෙදි සාප්පු බෑග් බෙදා දුන්නේය.",
            presentEnglish = "Replacing single-use polythene safeguards the environment.",
            presentSinhala = "තනි භාවිත පොලිතින් ඉවත් කිරීම පරිසරය සුරකියි.",
            futureEnglish = "We will advocate plastic-free fairs across our district.",
            futureSinhala = "අපේ දිස්ත්‍රික්කය පුරා ප්ලාස්ටික් රහිත පොළවල් ප්‍රවර්ධනය කිරීමට අපි කටයුතු කරන්නෙමු.",
            verbTransformation = "distributed → safeguards → will advocate"
          ),
          TenseSentenceItem(
            id = "t25_s26",
            baseActionSinhala = "සුවතා කඳවුරක් පැවැත්වීම",
            pastEnglish = "Volunteers organized an indigenous Ayurveda wellness clinic.",
            pastSinhala = "ස්වේච්ඡා සේවකයෝ දේශීය ආයුර්වේද සුවතා සායනයක් සංවිධානය කළහ.",
            presentEnglish = "Traditional herbal therapies relieve chronic joint ailments naturally.",
            presentSinhala = "සාම්ප්‍රදායික ඖෂධීය ප්‍රතිකාර ස්වභාවිකව සන්ධි රෝග සමනය කරයි.",
            futureEnglish = "We will distribute herbal medicinal oils free of charge.",
            futureSinhala = "අපි ඖෂධීය තෙල් නොමිලේ බෙදා දෙන්නෙමු.",
            verbTransformation = "organized → relieve → will distribute"
          ),
          TenseSentenceItem(
            id = "t25_s27",
            baseActionSinhala = "මානසික සුවතාවය වෙනුවෙන් උපකාර කිරීම",
            pastEnglish = "Counselors provided supportive guidance to troubled youth.",
            pastSinhala = "උපදේශකවරු පීඩාවට පත් තරුණයන්ට සහයෝගී මඟපෙන්වීම් ලබා දුන්හ.",
            presentEnglish = "Empathetic listening restores emotional equilibrium and hope.",
            presentSinhala = "සංවේදීව ඇහුම්කන් දීම මානසික සමබරතාවය සහ බලාපොරොත්තුව යථා තත්ත්වයට පත් කරයි.",
            futureEnglish = "We will establish a confidential youth helpline.",
            futureSinhala = "අපි රහස්‍ය තරුණ උපකාරක දුරකථන සේවාවක් ස්ථාපිත කරන්නෙමු.",
            verbTransformation = "provided → restores → will establish"
          ),
          TenseSentenceItem(
            id = "t25_s28",
            baseActionSinhala = "දුප්පත් පවුලකට නිවසක් තැනීම",
            pastEnglish = "Villagers built a brick house for a homeless family.",
            pastSinhala = "ගම්වැසියෝ නිවාස අහිමි පවුලකට ගඩොල් නිවසක් ඉදිකර දුන්හ.",
            presentEnglish = "Collective community solidarity builds shelters of hope.",
            presentSinhala = "සාමූහික ප්‍රජා සහජීවනය බලාපොරොත්තුවේ නිවහන් ගොඩනඟයි.",
            futureEnglish = "We will hand over the keys on New Year's Day.",
            futureSinhala = "අලුත් අවුරුදු දිනයේදී අපි යතුරු භාර දෙන්නෙමු.",
            verbTransformation = "built → builds → will hand over"
          ),
          TenseSentenceItem(
            id = "t25_s29",
            baseActionSinhala = "ප්‍රජා එකමුතුකම සැමරීම",
            pastEnglish = "The village celebrated their collective community achievements.",
            pastSinhala = "ගම්වැසියෝ තම සාමූහික ප්‍රජා ජයග්‍රහණ සැමරූහ.",
            presentEnglish = "United efforts uplift the living standards of all citizens.",
            presentSinhala = "එක්සත් උත්සාහයන් සියලුම පුරවැසියන්ගේ ජීවන තත්ත්වය උසස් කරයි.",
            futureEnglish = "We will pledge to serve our community with enduring love.",
            futureSinhala = "අපේ ප්‍රජාවට නිබඳ ආදරයෙන් සේවය කිරීමට අපි ප්‍රතිඥා දෙන්නෙමු.",
            verbTransformation = "celebrated → uplift → will pledge"
          ),
          TenseSentenceItem(
            id = "t25_s30",
            baseActionSinhala = "පරාර්ථකාමී සේවාව",
            pastEnglish = "Great leaders dedicated their lives to selfless service.",
            pastSinhala = "ශ්‍රේෂ්ඨ නායකයෝ තම ජීවිත පරාර්ථකාමී සේවය උදෙසා කැප කළහ.",
            presentEnglish = "The best way to find yourself is to lose yourself in the service of others.",
            presentSinhala = "තමා කවුදැයි සොයා ගැනීමට හොඳම මග අන්‍යයන්ගේ සේවය උදෙසා කැපවීමයි.",
            futureEnglish = "Your service will illuminate hearts and transform countless lives.",
            futureSinhala = "ඔබගේ සේවය හදවත් ආලෝකමත් කර අසංඛ්‍යාත ජීවිත පරිවර්තනය කරනු ඇත.",
            verbTransformation = "dedicated → is → will illuminate"
          )
        )
      ),

      // ==========================================
      // Category 26: අභිප්‍රේරණය, ඉලක්ක සහ සාර්ථකත්වය (Motivation, Goals & Success) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 26,
        titleSinhala = "කාණ්ඩය 26: අභිප්‍රේරණය, ඉලක්ක සහ සාර්ථකත්වය",
        titleEnglish = "Motivation, Goals & Success",
        icon = "🏆",
        description = "ඉලක්ක සපුරා ගැනීම, ධෛර්යය, අධිෂ්ඨානය, පරාජයන් ජය ගැනීම සහ සාර්ථකත්වය පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t26_s1",
            baseActionSinhala = "ඉලක්කයක් සකස් කර ගැනීම",
            pastEnglish = "I set a clear goal to obtain an 'A' grade in English.",
            pastSinhala = "ඉංග්‍රීසි විෂයට 'A' සාමාර්ථයක් ලබා ගැනීමට මම පැහැදිලි ඉලක්කයක් තබා ගත්තෙමි.",
            presentEnglish = "Ambitious students set measurable academic goals.",
            presentSinhala = "අභිලාෂකාමී සිසුහු මැනිය හැකි අධ්‍යාපනික ඉලක්ක සකස් කර ගනිති.",
            futureEnglish = "I will write my dream goals in my personal journal.",
            futureSinhala = "මගේ පුද්ගලික දිනපොතේ මගේ සිහින ඉලක්ක මම ලියන්නෙමි.",
            verbTransformation = "set → set → will write"
          ),
          TenseSentenceItem(
            id = "t26_s2",
            baseActionSinhala = "බාධක ජය ගැනීම",
            pastEnglish = "Sunil overcame financial hardships through perseverance.",
            pastSinhala = "සුනිල් නොපසුබට උත්සාහය තුළින් මූල්‍ය දුෂ්කරතා ජය ගත්තේය.",
            presentEnglish = "Resilient individuals overcome obstacles with grit.",
            presentSinhala = "නොසැලෙන පුද්ගලයෝ ධෛර්යයෙන් යුතුව බාධක ජය ගනිති.",
            futureEnglish = "You will overcome every trial on your path to victory.",
            futureSinhala = "ජයග්‍රහණයේ මාවතේ ඇති සෑම අභියෝගයක්ම ඔබ ජය ගනු ඇත.",
            verbTransformation = "overcame → overcome → will overcome"
          ),
          TenseSentenceItem(
            id = "t26_s3",
            baseActionSinhala = "වෙහෙස මහන්සි වී වැඩ කිරීම",
            pastEnglish = "She worked hard day and night to complete her thesis.",
            pastSinhala = "ඇය තම පර්යේෂණ නිබන්ධනය අවසන් කිරීමට දිවා රෑ නොබලා වෙහෙස මහන්සි වී වැඩ කළාය.",
            presentEnglish = "Hard work paves the royal road to excellence.",
            presentSinhala = "වෙහෙස මහන්සි වී වැඩ කිරීම විශිෂ්ටත්වයට මහා මාවත විවර කරයි.",
            futureEnglish = "I will work diligently to master spoken English fluency.",
            futureSinhala = "කථන ඉංග්‍රීසි චතුරතාව ප්‍රගුණ කිරීමට මම උනන්දුවෙන් වැඩ කරන්නෙමි.",
            verbTransformation = "worked → paves → will work"
          ),
          TenseSentenceItem(
            id = "t26_s4",
            baseActionSinhala = "කාලය කළමනාකරණය කිරීම",
            pastEnglish = "He planned his daily study timetable effectively.",
            pastSinhala = "ඔහු තම දෛනික පාඩම් කාලසටහන ඵලදායීව සැලසුම් කළේය.",
            presentEnglish = "Successful leaders manage their hours with sharp discipline.",
            presentSinhala = "සාර්ථක නායකයෝ තම පැය දැඩි විනයකින් කළමනාකරණය කරති.",
            futureEnglish = "I will allocate two focused hours daily for exam revision.",
            futureSinhala = "විභාග පුනරීක්ෂණ සඳහා මම දිනපතා අවධානය යොමු කළ පැය දෙකක් වෙන් කරන්නෙමි.",
            verbTransformation = "planned → manage → will allocate"
          ),
          TenseSentenceItem(
            id = "t26_s5",
            baseActionSinhala = "ආත්ම විශ්වාසය ගොඩනැගීම",
            pastEnglish = "She delivered the presentation with striking self-confidence.",
            pastSinhala = "ඇය කැපී පෙනෙන ආත්ම විශ්වාසයකින් යුතුව දේශනය ඉදිරිපත් කළාය.",
            presentEnglish = "Self-belief turns impossible challenges into triumphant victories.",
            presentSinhala = "ආත්ම විශ්වාසය කළ නොහැකි අභියෝග විශිෂ්ට ජයග්‍රහණ බවට පත් කරයි.",
            futureEnglish = "You will step on stage with total poise and confidence.",
            futureSinhala = "ඔබ පූර්ණ සන්සුන් බවින් සහ ආත්ම විශ්වාසයෙන් වේදිකාවට පිවිසෙනු ඇත.",
            verbTransformation = "delivered → turns → will step"
          ),
          TenseSentenceItem(
            id = "t26_s6",
            baseActionSinhala = "වැරදි වලින් පාඩම් ඉගෙනීම",
            pastEnglish = "We learned valuable lessons from our initial defeat.",
            pastSinhala = "අපගේ ආරම්භක පරාජයෙන් අපි වටිනා පාඩම් ඉගෙන ගත්තෙමු.",
            presentEnglish = "Wise thinkers regard failures as stepping stones to wisdom.",
            presentSinhala = "ඥානවන්ත චින්තකයෝ පරාජයන් ප්‍රඥාවේ හිණිපෙළ ලෙස සලකති.",
            futureEnglish = "I will correct my errors and excel in the next attempt.",
            futureSinhala = "මගේ වැරදි නිවැරදි කරගෙන මම මීළඟ උත්සාහයේදී දස්කම් දක්වන්නෙමි.",
            verbTransformation = "learned → regard → will correct"
          ),
          TenseSentenceItem(
            id = "t26_s7",
            baseActionSinhala = "පළමු ස්ථානය දිනා ගැනීම",
            pastEnglish = "Anura won first place in the all-island mathematics contest.",
            pastSinhala = "අනුර සමස්ත ලංකා ගණිත තරඟයෙන් ප්‍රථම ස්ථානය දිනා ගත්තේය.",
            presentEnglish = "Relentless practice yields champions in every discipline.",
            presentSinhala = "නොපසුබට පුහුණුව සෑම ක්ෂේත්‍රයකම ශූරයන් බිහි කරයි.",
            futureEnglish = "Our team will win the national debate trophy.",
            futureSinhala = "අපගේ කණ්ඩායම ජාතික විවාද කුසලානය දිනා ගනු ඇත.",
            verbTransformation = "won → yields → will win"
          ),
          TenseSentenceItem(
            id = "t26_s8",
            baseActionSinhala = "පසුබට නොවී උත්සාහ කිරීම",
            pastEnglish = "The athlete persisted despite intense muscle fatigue.",
            pastSinhala = "දැඩි මාංශ පේශි තෙහෙට්ටුව නොතකා ක්‍රීඩකයා දිගටම උත්සාහ කළේය.",
            presentEnglish = "Persistence wears down the steepest mountains.",
            presentSinhala = "නොපසුබට උත්සාහය උසම කඳු පවා බිම හෙළයි.",
            futureEnglish = "I will never give up until my dream becomes reality.",
            futureSinhala = "මගේ සිහිනය සැබෑ වන තෙක් මම කිසි විටෙකත් අත්නොහරින්නෙමි.",
            verbTransformation = "persisted → wears down → will never give up"
          ),
          TenseSentenceItem(
            id = "t26_s9",
            baseActionSinhala = "අලුත් කුසලතාවක් ප්‍රගුණ කිරීම",
            pastEnglish = "He mastered touch-typing in three short weeks.",
            pastSinhala = "ඔහු කෙටි සති තුනකින් යතුරුපුවරුව නොබලා ටයිප් කිරීම ප්‍රගුණ කළේය.",
            presentEnglish = "Learning modern skills sharpens professional competitiveness.",
            presentSinhala = "නව කුසලතා ඉගෙනීම වෘත්තීය තරඟකාරිත්වය ඔප්නංවයි.",
            futureEnglish = "I will master fluent public speaking skills this term.",
            futureSinhala = "මම මේ වාරයේදී චතුර ප්‍රසිද්ධ කථන කුසලතා ප්‍රගුණ කරන්නෙමි.",
            verbTransformation = "mastered → sharpens → will master"
          ),
          TenseSentenceItem(
            id = "t26_s10",
            baseActionSinhala = "සුබවාදීව සිතීම",
            pastEnglish = "She kept a positive mindset throughout the medical crisis.",
            pastSinhala = "වෛද්‍ය අර්බුදය පුරාම ඇය සුබවාදී මානසිකත්වයක් පවත්වා ගත්තාය.",
            presentEnglish = "Optimism illuminates dark tunnels with radiant hope.",
            presentSinhala = "සුබවාදී බව අඳුරු උමං බැබළෙන බලාපොරොත්තුවෙන් ආලෝකමත් කරයි.",
            futureEnglish = "You will radiate optimism and inspire all your teammates.",
            futureSinhala = "ඔබ සුබවාදී බව විහිදුවමින් ඔබගේ සියලුම කණ්ඩායම් සගයන් දිරිමත් කරනු ඇත.",
            verbTransformation = "kept → illuminates → will radiate"
          ),
          TenseSentenceItem(
            id = "t26_s11",
            baseActionSinhala = "අධිෂ්ඨාන කර ගැනීම",
            pastEnglish = "He resolved to complete his degree with first-class honors.",
            pastSinhala = "ප්‍රථම පන්තියේ සාමාර්ථයක් සහිතව උපාධිය නිම කිරීමට ඔහු අධිෂ්ඨාන කර ගත්තේය.",
            presentEnglish = "Firm determination anchors the wandering mind to accomplishment.",
            presentSinhala = "දැඩි අධිෂ්ඨානය චංචල මනස ජයග්‍රහණය වෙත යොමු කරයි.",
            futureEnglish = "I will resolve to wake up at 5:00 AM every single day.",
            futureSinhala = "සෑම දිනකම උදෑසන 5:00 ට අවදි වීමට මම අධිෂ්ඨාන කර ගන්නෙමි.",
            verbTransformation = "resolved → anchors → will resolve"
          ),
          TenseSentenceItem(
            id = "t26_s12",
            baseActionSinhala = "ආදර්ශවත් නායකයෙකු වීම",
            pastEnglish = "The head prefect led by exemplary personal conduct.",
            pastSinhala = "ප්‍රධාන ශිෂ්‍ය නායකයා ආදර්ශමත් පෞද්ගලික හැසිරීමෙන් නායකත්වය දුන්නේය.",
            presentEnglish = "True leaders inspire followers through virtue, not intimidation.",
            presentSinhala = "සැබෑ නායකයෝ බිය ගැන්වීමෙන් නොව ගුණධර්ම තුළින් අනුගාමිකයන් දිරිමත් කරති.",
            futureEnglish = "You will lead your organization with empathy and wisdom.",
            futureSinhala = "ඔබ සංවේදී බවින් සහ ප්‍රඥාවෙන් ඔබගේ ආයතනය මෙහෙයවනු ඇත.",
            verbTransformation = "led → inspire → will lead"
          ),
          TenseSentenceItem(
            id = "t26_s13",
            baseActionSinhala = "විභාගය විශිෂ්ට ලෙස සමත් වීම",
            pastEnglish = "Kasun passed the Advanced Level exam with three A grades.",
            pastSinhala = "කසුන් උසස් පෙළ විභාගය A සාමාර්ථ තුනක් සමඟින් සමත් විය.",
            presentEnglish = "Focused preparation produces splendid exam distinctions.",
            presentSinhala = "අවධානයෙන් යුත් සූදානම විශිෂ්ට විභාග සාමාර්ථ බිහි කරයි.",
            futureEnglish = "He will secure admission to the faculty of engineering.",
            futureSinhala = "ඔහු ඉංජිනේරු පීඨයට ඇතුළත් වීමේ අවස්ථාව ලබා ගනු ඇත.",
            verbTransformation = "passed → produces → will secure"
          ),
          TenseSentenceItem(
            id = "t26_s14",
            baseActionSinhala = "තීරණයක් ගැනීම",
            pastEnglish = "She made a courageous decision to pursue her true passion.",
            pastSinhala = "තම සැබෑ දක්ෂතාවය පසුපස හඹා යාමට ඇය නිර්භීත තීරණයක් ගත්තාය.",
            presentEnglish = "Decisiveness transforms hesitations into fruitful action.",
            presentSinhala = "තීරණාත්මක බව දෙගිඩියාව ඵලදායී ක්‍රියාවක් බවට පත් කරයි.",
            futureEnglish = "I will decide my career path with confidence.",
            futureSinhala = "මම මගේ වෘත්තීය මාවත විශ්වාසයෙන් යුතුව තීරණය කරන්නෙමි.",
            verbTransformation = "made → transforms → will decide"
          ),
          TenseSentenceItem(
            id = "t26_s15",
            baseActionSinhala = "අන් අයව දිරිමත් කිරීම",
            pastEnglish = "The mentor motivated the young inventor to keep experimenting.",
            pastSinhala = "පර්යේෂණ දිගටම කරගෙන යාමට උපදේශකයා තරුණ නව නිපැයුම්කරු දිරිමත් කළේය.",
            presentEnglish = "Encouragement ignites creative flames in youthful minds.",
            presentSinhala = "දිරිගැන්වීම තරුණ මනස් තුළ නිර්මාණාත්මක දැල්ල දල්වයි.",
            futureEnglish = "I will encourage my peers whenever they feel discouraged.",
            futureSinhala = "මගේ සගයන් අධෛර්යමත් වූ විට මම ඔවුන්ව දිරිමත් කරන්නෙමි.",
            verbTransformation = "motivated → ignites → will encourage"
          ),
          TenseSentenceItem(
            id = "t26_s16",
            baseActionSinhala = "කම්මැලිකම දුරු කිරීම",
            pastEnglish = "I overcame morning laziness and went for a run.",
            pastSinhala = "මම උදෑසන කම්මැලිකම දුරු කර දිවීම සඳහා ගියෙමි.",
            presentEnglish = "Discipline is choosing between what you want now and what you want most.",
            presentSinhala = "විනය යනු ක්ෂණික ආශාව සහ ඔබේ උතුම්ම ඉලක්කය අතර නිවැරදි තේරීමයි.",
            futureEnglish = "I will eliminate procrastination from my daily routine.",
            futureSinhala = "මම මගේ දෛනික චර්යාවෙන් වැඩ කල් දැමීම මුළුමනින්ම ඉවත් කරන්නෙමි.",
            verbTransformation = "overcame → is → will eliminate"
          ),
          TenseSentenceItem(
            id = "t26_s17",
            baseActionSinhala = "අභියෝගයකට මුහුණ දීම",
            pastEnglish = "The mountaineer faced the freezing blizzard bravely.",
            pastSinhala = "කඳු නගින්නා අධික හිම කුණාටුවට නිර්භීතව මුහුණ දුන්නේය.",
            presentEnglish = "Challenges polish character like friction polishes rough diamonds.",
            presentSinhala = "අභියෝග රළු දියමන්ති ඔප දමන්නාක් මෙන් මිනිස් චරිතය ඔපවත් කරයි.",
            futureEnglish = "We will face whatever comes with an indomitable spirit.",
            futureSinhala = "පැමිණෙන ඕනෑම දෙයකට අපි නොබියව නොසැලෙන ආත්මයෙන් මුහුණ දෙන්නෙමු.",
            verbTransformation = "faced → polish → will face"
          ),
          TenseSentenceItem(
            id = "t26_s18",
            baseActionSinhala = "ප්‍රශංසාවක් ලැබීම",
            pastEnglish = "The principal commended her stellar community service.",
            pastSinhala = "විදුහල්පතිතුමා ඇගේ විශිෂ්ට ප්‍රජා සේවය අගය කළේය.",
            presentEnglish = "Genuine praise fuels personal growth and enthusiasm.",
            presentSinhala = "අවංක ප්‍රශංසාව පෞද්ගලික වර්ධනය සහ උද්‍යෝගය පෝෂණය කරයි.",
            futureEnglish = "Your tireless dedication will receive national recognition.",
            futureSinhala = "ඔබගේ නොපසුබට කැපවීම ජාතික ඇගයීමට ලක්වනු ඇත.",
            verbTransformation = "commended → fuels → will receive"
          ),
          TenseSentenceItem(
            id = "t26_s19",
            baseActionSinhala = "ආත්ම දමනය පුරුදු කිරීම",
            pastEnglish = "He controlled his temper during the heated disagreement.",
            pastSinhala = "උණුසුම් මතභේදයේදී ඔහු තම කෝපය පාලනය කර ගත්තේය.",
            presentEnglish = "Self-mastery is the highest of all human victories.",
            presentSinhala = "තමා දමනය කර ගැනීම සියලුම මානව ජයග්‍රහණ අතරින් උසස්ම ජයග්‍රහණයයි.",
            futureEnglish = "I will practice calm mindfulness in stressful moments.",
            futureSinhala = "ආතති සහගත අවස්ථාවලදී මම සන්සුන් සිහිය පුරුදු කරන්නෙමි.",
            verbTransformation = "controlled → is → will practice"
          ),
          TenseSentenceItem(
            id = "t26_s20",
            baseActionSinhala = "නවතම ව්‍යාපාරයක් ආරම්භ කිරීම",
            pastEnglish = "The entrepreneur launched a green packaging startup.",
            pastSinhala = "ව්‍යවසායකයා පරිසර හිතකාමී ඇසුරුම් ආරම්භක ව්‍යාපාරයක් ආරම්භ කළේය.",
            presentEnglish = "Innovation and boldness spark successful enterprises.",
            presentSinhala = "නවෝත්පාදනය සහ නිර්භීතකම සාර්ථක ව්‍යාපාර බිහි කරයි.",
            futureEnglish = "He will expand his export operations to global markets.",
            futureSinhala = "ඔහු තම අපනයන මෙහෙයුම් ගෝලීය වෙළඳපොළට ව්‍යාප්ත කරනු ඇත.",
            verbTransformation = "launched → spark → will expand"
          ),
          TenseSentenceItem(
            id = "t26_s21",
            baseActionSinhala = "පොතපතින් ආභාසය ලැබීම",
            pastEnglish = "She drew deep inspiration from great scientists' memoirs.",
            pastSinhala = "ශ්‍රේෂ්ඨ විද්‍යාඥයන්ගේ මතක සටහන් වලින් ඇය ගැඹුරු ආභාසයක් ලැබුවාය.",
            presentEnglish = "Great literature elevates ambitions and kindles vision.",
            presentSinhala = "ශ්‍රේෂ්ඨ සාහිත්‍යය අභිලාෂයන් උසස් කර දර්ශනයක් දල්වයි.",
            futureEnglish = "I will seek inspiration from everyday heroic deeds.",
            futureSinhala = "එදිනෙදා වීර ක්‍රියාවන්ගෙන් මම ආභාසය ලබා ගන්නෙමි.",
            verbTransformation = "drew → elevates → will seek"
          ),
          TenseSentenceItem(
            id = "t26_s22",
            baseActionSinhala = "සමාජයට වටිනාකමක් එකතු කිරීම",
            pastEnglish = "The doctor served remote villages with passionate zeal.",
            pastSinhala = "වෛද්‍යවරයා උනන්දුවෙන් හා කැපවීමෙන් දුරස්ථ ගම්මානවලට සේවය කළේය.",
            presentEnglish = "A life lived for others is a life worthwhile.",
            presentSinhala = "අන්‍යයන් වෙනුවෙන් ගත කරන ජීවිතය සැබවින්ම අර්ථවත් ජීවිතයකි.",
            futureEnglish = "We will leave our village better than we found it.",
            futureSinhala = "අපට හමුවූවාට වඩා යහපත් ගමක් අපි අනාගතයට ඉතිරි කරන්නෙමු.",
            verbTransformation = "served → is → will leave"
          ),
          TenseSentenceItem(
            id = "t26_s23",
            baseActionSinhala = "නිරන්තරයෙන් ඉගෙනීම",
            pastEnglish = "He read a non-fiction book every week for five years.",
            pastSinhala = "ඔහු වසර පහක් පුරා සෑම සතියකම ප්‍රබන්ධ නොවන පොතක් කියෙව්වේය.",
            presentEnglish = "Lifelong learners adapt seamlessly to changing worlds.",
            presentSinhala = "ජීවිත කාලය පුරාම ඉගෙන ගන්නෝ වෙනස් වන ලෝකයට සුමටව අනුවර්තනය වෙති.",
            futureEnglish = "I will constantly update my professional qualifications.",
            futureSinhala = "මම මගේ වෘත්තීය සුදුසුකම් නිරන්තරයෙන් යාවත්කාලීන කරන්නෙමි.",
            verbTransformation = "read (past) → adapt → will update"
          ),
          TenseSentenceItem(
            id = "t26_s24",
            baseActionSinhala = "ක්‍රීඩා වාර්තාවක් බිඳ හෙළීම",
            pastEnglish = "The sprinter broke the school hundred-meter record.",
            pastSinhala = "කෙටි දුර ධාවකයා පාසලේ මීටර් සියය වාර්තාව බිඳ හෙළුවේය.",
            presentEnglish = "Dedication turns records into benchmarks waiting to be surpassed.",
            presentSinhala = "කැපවීම වාර්තා අභිබවා යා යුතු ඉලක්ක බවට පත් කරයි.",
            futureEnglish = "She will aim for an Olympic qualifying time next year.",
            futureSinhala = "ඇය ලබන වසරේ ඔලිම්පික් සුදුසුකම් ලැබීමේ කාලය ඉලක්ක කරනු ඇත.",
            verbTransformation = "broke → turns → will aim"
          ),
          TenseSentenceItem(
            id = "t26_s25",
            baseActionSinhala = "ස්තුතිවන්ත වීම",
            pastEnglish = "She thanked her teachers and parents with profound reverence.",
            pastSinhala = "ඇය තම ගුරුවරුන්ට සහ දෙමාපියන්ට ගැඹුරු ගෞරවයෙන් ස්තුති කළාය.",
            presentEnglish = "A thankful heart attracts joy and enduring peace.",
            presentSinhala = "කෘතඥ හදවතක් සතුට සහ සදාකාලික සාමය ආකර්ෂණය කරයි.",
            futureEnglish = "I will express gratitude every morning for the gift of life.",
            futureSinhala = "ජීවිතයේ වටිනාකම වෙනුවෙන් මම සෑම උදෑසනකම කෘතඥතාව පළ කරන්නෙමු.",
            verbTransformation = "thanked → attracts → will express"
          ),
          TenseSentenceItem(
            id = "t26_s26",
            baseActionSinhala = "දැක්මක් ඇතුව ජීවත් වීම",
            pastEnglish = "Leaders articulated a visionary fifty-year master plan.",
            pastSinhala = "නායකයෝ පනස් වසරක ඉදිරි දැක්මක් සහිත මහා සැලැස්මක් ප්‍රකාශ කළහ.",
            presentEnglish = "Where there is no vision, people perish.",
            presentSinhala = "දැක්මක් නොමැති තැන මිනිස්සු විනාශ වෙති.",
            futureEnglish = "We will pursue our vision with unwavering loyalty.",
            futureSinhala = "අපි නොසැලෙන පක්ෂපාතීත්වයෙන් අපගේ දැක්ම හඹා යන්නෙමු.",
            verbTransformation = "articulated → perish → will pursue"
          ),
          TenseSentenceItem(
            id = "t26_s27",
            baseActionSinhala = "පරාජය හමුවේ නැවත නැගී සිටීම",
            pastEnglish = "The boxer rose from the canvas and won the fight.",
            pastSinhala = "බොක්සිං ක්‍රීඩකයා වැටුණු තැනින් නැවත නැගිට සටන ජය ගත්තේය.",
            presentEnglish = "It matters not how often you fall, but how often you rise.",
            presentSinhala = "වැදගත් වන්නේ ඔබ කී වතාවක් වැටුණාද යන්න නොව, ඔබ කී වතාවක් නැගිට්ටාද යන්නයි.",
            futureEnglish = "You will rise stronger every time adversity strikes.",
            futureSinhala = "බාධක පැමිණෙන සෑම විටම ඔබ වඩාත් ශක්තිමත්ව නැගී සිටිනු ඇත.",
            verbTransformation = "rose → matters → will rise"
          ),
          TenseSentenceItem(
            id = "t26_s28",
            baseActionSinhala = "විවේචනවලට සන්සුන්ව මුහුණ දීම",
            pastEnglish = "The author accepted constructive feedback with maturity.",
            pastSinhala = "ලේඛකයා පරිණතභාවයෙන් යුතුව ඵලදායී විවේචන පිළිගත්තේය.",
            presentEnglish = "Wise people welcome critique to refine their craft.",
            presentSinhala = "බුද්ධිමත් මිනිස්සු තම නිර්මාණ ඔප්නංවා ගැනීමට විවේචන සාදරයෙන් පිළිගනිති.",
            futureEnglish = "I will use honest criticism to fuel personal improvement.",
            futureSinhala = "පෞද්ගලික දියුණුව සඳහා මම අවංක විවේචන උපයෝගී කර ගන්නෙමි.",
            verbTransformation = "accepted → welcome → will use"
          ),
          TenseSentenceItem(
            id = "t26_s29",
            baseActionSinhala = "මනස සන්සුන්ව තබා ගැනීම",
            pastEnglish = "The surgeon performed the delicate operation with calm stillness.",
            pastSinhala = "ශල්‍ය වෛද්‍යවරයා සන්සුන් නිශ්චලතාවයෙන් සියුම් සැත්කම සිදු කළේය.",
            presentEnglish = "Inner peace is the supreme bedrock of enduring brilliance.",
            presentSinhala = "අභ්‍යන්තර සාමය යනු සදාකාලික විශිෂ්ටත්වයේ උත්තරීතර පදනමයි.",
            futureEnglish = "You will remain centered in tranquility amidst storm clouds.",
            futureSinhala = "කුණාටු වලාකුළු මධ්‍යයේ වුවද ඔබ සන්සුන්ව නොසැලී සිටිනු ඇත.",
            verbTransformation = "performed → is → will remain"
          ),
          TenseSentenceItem(
            id = "t26_s30",
            baseActionSinhala = "ජයග්‍රාහී මිනිසෙකු වීම",
            pastEnglish = "Through steadfast willpower, he conquered every seemingly impossible peak.",
            pastSinhala = "නොසැලෙන අධිෂ්ඨානය තුළින් ඔහු කළ නොහැකි යැයි පෙනුණු සෑම මුදුනක්ම ජය ගත්තේය.",
            presentEnglish = "Victory belongs to the most persevering and righteous minds.",
            presentSinhala = "ජයග්‍රහණය හිමි වන්නේ වඩාත්ම නොපසුබට හා ධාර්මික මනස් ඇත්තන්ටය.",
            futureEnglish = "You will achieve greatness and crown your life with honor.",
            futureSinhala = "ඔබ උදාරත්වයට පත්වී ඔබගේ ජීවිතය ගෞරවයෙන් ඔටුනු පළඳවනු ඇත.",
            verbTransformation = "conquered → belongs → will achieve"
          )
        )
      ),

      // ==========================================
      // Category 27: ආගමික වතාවත් සහ අධ්‍යාත්මික ජීවිතය (Religious Observances & Spiritual Life) - 30 items
      // ==========================================
      TenseComparisonCategory(
        id = 27,
        titleSinhala = "කාණ්ඩය 27: ආගමික වතාවත් සහ අධ්‍යාත්මික ජීවිතය",
        titleEnglish = "Religious Observances & Spiritual Life",
        icon = "🪷",
        description = "සිල් සමාදන් වීම, බුද්ධ වන්දනාව, භාවනාව, පූජා සහ ආධ්‍යාත්මික සැනසීම පිළිබඳ වාක්‍ය 30ක් කාල තුනෙන්ම.",
        sentences = listOf(
          TenseSentenceItem(
            id = "t27_s1",
            baseActionSinhala = "සිල් සමාදන් වීම",
            pastEnglish = "Devotees observed the Eight Precepts on the full moon Poya day.",
            pastSinhala = "පසළොස්වක පෝය දින බැතිමත්හු අටසිල් සමාදන් වූහ.",
            presentEnglish = "Observing precepts purifies bodily conduct and calms the mind.",
            presentSinhala = "සිල් රැකීම කායික හැසිරීම පිරිසිදු කර මනස සන්සුන් කරයි.",
            futureEnglish = "I will observe Sil at the village temple on Vesak day.",
            futureSinhala = "වෙසක් දිනයේදී මම ගමේ පන්සලේ සිල් සමාදන් වන්නෙමි.",
            verbTransformation = "observed → purifies → will observe"
          ),
          TenseSentenceItem(
            id = "t27_s2",
            baseActionSinhala = "මල් පූජා කිරීම",
            pastEnglish = "Mother offered fragrant white jasmine flowers at the shrine.",
            pastSinhala = "අම්මා බුදු මැදුරේ සුවඳැති සුදු පිච්ච මල් පූජා කළාය.",
            presentEnglish = "Offering blossoms reminds devotees of life's impermanence.",
            presentSinhala = "මල් පූජා කිරීම ජීවිතයේ අනිත්‍ය බව බැතිමතුන්ට සිහිපත් කරයි.",
            futureEnglish = "We will place fresh blue water lilies before the Buddha statue.",
            futureSinhala = "අපි බුදු පිළිමය ඉදිරියේ නැවුම් නිල් මානෙල් මල් තබන්නෙමු.",
            verbTransformation = "offered → reminds → will place"
          ),
          TenseSentenceItem(
            id = "t27_s3",
            baseActionSinhala = "පොල්තෙල් පහන් දැල්වීම",
            pastEnglish = "Pilgrims lit clay oil lamps around the sacred Bo tree.",
            pastSinhala = "වන්දනාකරුවෝ පූජනීය බෝධීන් වහන්සේ වටා මැටි පහන් දැල්වූහ.",
            presentEnglish = "Flickering lamp flames dispel physical darkness and mental gloom.",
            presentSinhala = "දැල්වෙන පහන් සිළු භෞතික අන්ධකාරය සහ මානසික අඳුර දුරු කරයි.",
            futureEnglish = "We will light eighty-four thousand lamps for the festival.",
            futureSinhala = "උත්සවය සඳහා අපි අසූහාරදහසක් පහන් දල්වන්නෙමු.",
            verbTransformation = "lit → dispel → will light"
          ),
          TenseSentenceItem(
            id = "t27_s4",
            baseActionSinhala = "හඳුන්කූරු දැල්වීම",
            pastEnglish = "The upasaka lit fragrant sandalwood incense sticks.",
            pastSinhala = "උපාසක මහතා සුවඳැති සඳුන් හඳුන්කූරු දැල්වීය.",
            presentEnglish = "Sweet incense creates an aura of sacred serenity.",
            presentSinhala = "මිහිරි සුවඳ ධූප පූජනීය සන්සුන් වාතාවරණයක් නිර්මාණය කරයි.",
            futureEnglish = "I will offer aromatic incense at the altar tonight.",
            futureSinhala = "මම අද රෑ පූජාසනය ඉදිරියේ සුවඳ දුම් පූජා කරන්නෙමි.",
            verbTransformation = "lit → creates → will offer"
          ),
          TenseSentenceItem(
            id = "t27_s5",
            baseActionSinhala = "භාවනා කිරීම",
            pastEnglish = "The monk practiced breathing meditation in the cave monastery.",
            pastSinhala = "හිමිනම ආරණ්‍ය සේනාසනයේ ගල් ගුහාවේ ආනාපානසති භාවනාව පුරුදු කළ සේක.",
            presentEnglish = "Mindfulness meditation stills distracting thoughts and develops insight.",
            presentSinhala = "සතිමත් භාවනාව නොසන්සුන් සිතිවිලි සන්සිඳුවා ප්‍රඥාව වර්ධනය කරයි.",
            futureEnglish = "I will meditate for thirty quiet minutes before dawn.",
            futureSinhala = "පාන්දරට පෙර මම මිනිත්තු තිහක් නිහඬව භාවනා කරන්නෙමු.",
            verbTransformation = "practiced → stills → will meditate"
          ),
          TenseSentenceItem(
            id = "t27_s6",
            baseActionSinhala = "බණ ඇසීම",
            pastEnglish = "The congregation listened to a Dhamma sermon by the venerable thero.",
            pastSinhala = "පිරිස ගෞරවනීය හිමිනමගේ ධර්ම දේශනාවකට සවන් දුන්හ.",
            presentEnglish = "Listening to Dhamma enlightens minds with moral guidance.",
            presentSinhala = "ධර්මය ශ්‍රවණය කිරීම සදාචාරාත්මක මඟපෙන්වීමෙන් මනස ආලෝකවත් කරයි.",
            futureEnglish = "We will listen to the live radio sermon on Sunday morning.",
            futureSinhala = "අපි ඉරිදා උදෑසන සජීවී ගුවන්විදුලි ධර්ම දේශනාවට සවන් දෙන්නෙමු.",
            verbTransformation = "listened → enlightens → will listen"
          ),
          TenseSentenceItem(
            id = "t27_s7",
            baseActionSinhala = "පිරිත් සජ්ඣායනා කිරීම",
            pastEnglish = "Bhikkhus chanted Seth Pirith throughout the protective ceremony.",
            pastSinhala = "භික්ෂූන් වහන්සේලා ආරක්ෂක පිරිත් දේශනාවේදී සෙත් පිරිත් සජ්ඣායනා කළ සේක.",
            presentEnglish = "Paritta chanting radiates peaceful vibrational blessings.",
            presentSinhala = "පිරිත් සජ්ඣායනය සාමකාමී ආශීර්වාදාත්මක තරංග විහිදුවයි.",
            futureEnglish = "The monks will chant Maha Mangala Sutta for good fortune.",
            futureSinhala = "යහපත උදෙසා හිමිවරු මහා මංගල සූත්‍රය සජ්ඣායනා කරනු ඇත.",
            verbTransformation = "chanted → radiates → will chant"
          ),
          TenseSentenceItem(
            id = "t27_s8",
            baseActionSinhala = "පිරිත් නූල් බැඳීම",
            pastEnglish = "The senior monk tied blessed Pirith cotton thread on my wrist.",
            pastSinhala = "නායක හාමුදුරුවෝ මගේ අතේ ආශීර්වාදාත්මක පිරිත් නූලක් බැඳි සේක.",
            presentEnglish = "Consecrated threads symbolize spiritual protection from harm.",
            presentSinhala = "ආශීර්වාද ලත් නූල් විපත්ති වලින් ආධ්‍යාත්මික ආරක්ෂාව සංකේතවත් කරයි.",
            futureEnglish = "We will tie Pirith cord for the newborn infant.",
            futureSinhala = "අපි අලුත උපන් බිළිඳා වෙනුවෙන් පිරිත් නූල් බඳින්නෙමු.",
            verbTransformation = "tied → symbolize → will tie"
          ),
          TenseSentenceItem(
            id = "t27_s9",
            baseActionSinhala = "බෝධි පූජාවක් පැවැත්වීම",
            pastEnglish = "The family organized a Bodhi Pooja for their sick grandmother.",
            pastSinhala = "පවුලේ අය අසනීප වූ මිත්තණිය වෙනුවෙන් බෝධි පූජාවක් පැවැත්වූහ.",
            presentEnglish = "Bodhi Poojas offer solace and invoke blessings for recovery.",
            presentSinhala = "බෝධි පූජා සැනසීම ලබා දෙන අතර සුවය සඳහා ආශීර්වාද පතයි.",
            futureEnglish = "We will chant gathas around the sacred tree at dusk.",
            futureSinhala = "අපි සවස් වරුවේ පූජනීය බෝධිය වටා ගාථා සජ්ඣායනා කරන්නෙමු.",
            verbTransformation = "organized → offer → will chant"
          ),
          TenseSentenceItem(
            id = "t27_s10",
            baseActionSinhala = "බෝධියට පැන් වත් කිරීම",
            pastEnglish = "Devotees watered the Bo sapling with golden urns of purified water.",
            pastSinhala = "බැතිමත්හු රන් බඳුන්වල පිරිසිදු ජලයෙන් බෝ පැළයට පැන් වත් කළහ.",
            presentEnglish = "Pouring water symbolizes reverence towards enlightenment.",
            presentSinhala = "පැන් වත් කිරීම බුද්ධත්වයට දක්වන ගෞරවය සංකේතවත් කරයි.",
            futureEnglish = "I will pour fragrant milk water to the roots of the tree.",
            futureSinhala = "මම බෝධියේ මුල් වෙත සුවඳැති කිරි පැන් වත් කරන්නෙමි.",
            verbTransformation = "watered → symbolizes → will pour"
          ),
          TenseSentenceItem(
            id = "t27_s11",
            baseActionSinhala = "දන් පිළිගැන්වීම",
            pastEnglish = "The family offered morning alms (Heel Dana) to five monks.",
            pastSinhala = "පවුලේ අය හිමිවරු පස්නමකට උදෑසන හීල් දානය පූජා කළහ.",
            presentEnglish = "Offering alms cultivates unattached non-greed generosity.",
            presentSinhala = "දානය පූජා කිරීම නොඇලෙන අලෝභ ත්‍යාගශීලී බව වර්ධනය කරයි.",
            futureEnglish = "We will offer midday Sanghika Dana on grandfather's memorial day.",
            futureSinhala = "සීයාගේ ගුණානුස්මරණ දිනයේදී අපි දහවල් සාංඝික දානය පූජා කරන්නෙමු.",
            verbTransformation = "offered → cultivates → will offer"
          ),
          TenseSentenceItem(
            id = "t27_s12",
            baseActionSinhala = "පැවිදි වීම",
            pastEnglish = "The youth renounced worldly life and entered the holy order.",
            pastSinhala = "තරුණයා ලෞකික ජීවිතය අත්හැර ශාසනයට ඇතුළත් විය.",
            presentEnglish = "Monastic life demands rigorous discipline and detachment.",
            presentSinhala = "පැවිදි ජීවිතය දැඩි විනයක් සහ නොඇලීමක් ඉල්ලා සිටියි.",
            futureEnglish = "The novice samanera will receive higher upasampada ordination.",
            futureSinhala = "සාමණේර හිමිනම උපසම්පදාව ලබනු ඇත.",
            verbTransformation = "renounced → demands → will receive"
          ),
          TenseSentenceItem(
            id = "t27_s13",
            baseActionSinhala = "දළදා සමිඳුන් වැඳපුදා ගැනීම",
            pastEnglish = "Pilgrims paid homage to the Sacred Tooth Relic in Kandy.",
            pastSinhala = "වන්දනාකරුවෝ මහනුවර ශ්‍රී දන්ත ධාතූන් වහන්සේ වැඳපුදා ගත්හ.",
            presentEnglish = "The Temple of the Tooth is Sri Lanka's supreme spiritual sanctuary.",
            presentSinhala = "දළදා මාළිගාව ශ්‍රී ලංකාවේ උත්තරීතර ආධ්‍යාත්මික අභයභූමියයි.",
            futureEnglish = "We will visit the inner chamber during the afternoon Thevava.",
            futureSinhala = "දහවල් තේවාව අතරතුර අපි ඇතුළු කුටිය වැඳපුදා ගන්නෙමු.",
            verbTransformation = "paid homage → is → will visit"
          ),
          TenseSentenceItem(
            id = "t27_s14",
            baseActionSinhala = "සීවලී දේව පූජාවක් තැබීම",
            pastEnglish = "The devotee invoked blessings of Arahant Sivali for prosperity.",
            pastSinhala = "බැතිමතා සෞභාග්‍යය පතා සීවලී මහරහතන් වහන්සේගේ ආශීර්වාදය පැතීය.",
            presentEnglish = "Venerating enlightened saints fosters joy and abundance.",
            presentSinhala = "මහරහතුන් වහන්සේලාට ගෞරව කිරීම සතුට හා සමෘද්ධිය ඇති කරයි.",
            futureEnglish = "We will recite the Sivali Yanthra chant at dawn.",
            futureSinhala = "අපි අලුයම සීවලී යන්ත්‍ර ගාථාව සජ්ඣායනා කරන්නෙමු.",
            verbTransformation = "invoked → fosters → will recite"
          ),
          TenseSentenceItem(
            id = "t27_s15",
            baseActionSinhala = "මෛත්‍රී භාවනාව වැඩීම",
            pastEnglish = "She radiated loving-kindness towards all living creatures.",
            pastSinhala = "ඇය සියලු ජීවීන් කෙරෙහි මෙත් සිත පැතිරුවාය.",
            presentEnglish = "Loving-kindness softens hardness and disarms ill-will.",
            presentSinhala = "මෛත්‍රී භාවනාව දැඩි බව මෘදු කර වෛරය දුරු කරයි.",
            futureEnglish = "I will send thoughts of peace to friends and adversaries alike.",
            futureSinhala = "මිතුරන්ට මෙන්ම සතුරන්ට ද මම සාමයේ සිතිවිලි යවන්නෙමි.",
            verbTransformation = "radiated → softens → will send"
          ),
          TenseSentenceItem(
            id = "t27_s16",
            baseActionSinhala = "සුදු ඇඳුම් ඇඳීම",
            pastEnglish = "Pilgrims wore pure white clothes to the sacred city.",
            pastSinhala = "වන්දනාකරුවෝ පූජනීය නගරයට පිරිසිදු සුදු ඇඳුම් ඇඳ පැමිණියහ.",
            presentEnglish = "White garments signify purity of mind, body, and speech.",
            presentSinhala = "සුදු ඇඳුම් සිත, කය, වචනය යන තුන්දොරෙහි පාරිශුද්ධත්වය සංකේතවත් කරයි.",
            futureEnglish = "We will wear pristine white attire to the temple tomorrow.",
            futureSinhala = "අපි හෙට පන්සලට පිරිසිදු සුදු වස්ත්‍ර අඳින්නෙමු.",
            verbTransformation = "wore → signify → will wear"
          ),
          TenseSentenceItem(
            id = "t27_s17",
            baseActionSinhala = "වන්දනාවේ යාම",
            pastEnglish = "Villagers went on a pilgrimage to Anuradhapura sacred sites.",
            pastSinhala = "ගම්වැසියෝ අනුරාධපුර පූජනීය ස්ථාන වෙත වන්දනාවේ ගියහ.",
            presentEnglish = "Pilgrimages deepen spiritual faith and historical connectedness.",
            presentSinhala = "වන්දනා ගමන් ආධ්‍යාත්මික ශ්‍රද්ධාව සහ ඓතිහාසික බැඳීම ගැඹුරු කරයි.",
            futureEnglish = "We will climb Mihintale rock on Poson full moon day.",
            futureSinhala = "පොසොන් පෝය දින අපි මිහින්තලා පර්වතය නගින්නෙමු.",
            verbTransformation = "went → deepen → will climb"
          ),
          TenseSentenceItem(
            id = "t27_s18",
            baseActionSinhala = "චෛත්‍යයක් ප්‍රදක්ෂිණා කිරීම",
            pastEnglish = "The crowd walked around Ruwanwelisaya stupa in clockwise reverence.",
            pastSinhala = "පිරිස රුවන්වැලිසෑය වටා දක්ෂිණාවර්තව ප්‍රදක්ෂිණා කරමින් ගමන් කළහ.",
            presentEnglish = "Circumambulating shrines expresses profound veneration.",
            presentSinhala = "චෛත්‍ය ප්‍රදක්ෂිණා කිරීම ගැඹුරු ගෞරවය ප්‍රකාශ කරයි.",
            futureEnglish = "We will circumambulate the stupa carrying a lotus garland.",
            futureSinhala = "අපි නෙළුම් මල් මාලාවක් රැගෙන චෛත්‍යය ප්‍රදක්ෂිණා කරන්නෙමු.",
            verbTransformation = "walked → expresses → will circumambulate"
          ),
          TenseSentenceItem(
            id = "t27_s19",
            baseActionSinhala = "පින් අනුමෝදන් කිරීම",
            pastEnglish = "They transferred merit to departed ancestors with water pouring.",
            pastSinhala = "පැන් වඩා ඔවුහු මියගිය ඥාතීන්ට පින් අනුමෝදන් කළහ.",
            presentEnglish = "Transferring merits expresses timeless filial gratitude.",
            presentSinhala = "පින් අනුමෝදන් කිරීම සදාකාලික කෘතවේදීත්වය ප්‍රකාශ කරයි.",
            futureEnglish = "We will share our good deeds with guardian deities.",
            futureSinhala = "අපගේ කුසල් අපි ආරක්ෂක දෙවිවරුන් සමඟ බෙදා ගන්නෙමු.",
            verbTransformation = "transferred → expresses → will share"
          ),
          TenseSentenceItem(
            id = "t27_s20",
            baseActionSinhala = "දන්වැට පිරිනැමීම",
            pastEnglish = "The village took turns providing meals to the temple hermitage.",
            pastSinhala = "ගම්වැසියෝ වාරය අනුව පන්සලේ ආරණ්‍යයට දානය පිරිනැමූහ.",
            presentEnglish = "Lay communities sustain the Sangha through devotional alms.",
            presentSinhala = "දායක සභාව භක්තිමත් දානය මඟින් මහා සංඝරත්නය නඩත්තු කරයි.",
            futureEnglish = "Our family will provide breakfast porridge next Monday.",
            futureSinhala = "අපේ පවුල ලබන සඳුදා උදෑසන කැඳ දානය පිරිනමනු ඇත.",
            verbTransformation = "took turns → sustain → will provide"
          ),
          TenseSentenceItem(
            id = "t27_s21",
            baseActionSinhala = "පන්සිල් සමාදන් වීම",
            pastEnglish = "Students observed the Five Precepts at morning assembly.",
            pastSinhala = "සිසුහු උදෑසන රැස්වීමේදී පන්සිල් සමාදන් වූහ.",
            presentEnglish = "The Five Precepts establish peaceful ethical coexistence.",
            presentSinhala = "පංචශීලය සාමකාමී සදාචාර සම්පන්න සහජීවනයක් ස්ථාපිත කරයි.",
            futureEnglish = "We will renew our vows of harmlessness and truth.",
            futureSinhala = "අහිංසාව සහ සත්‍යවාදී බව පිළිබඳ අපගේ ප්‍රතිඥාව අපි අලුත් කරන්නෙමු.",
            verbTransformation = "observed → establish → will renew"
          ),
          TenseSentenceItem(
            id = "t27_s22",
            baseActionSinhala = "කඨින චීවර පූජාව",
            pastEnglish = "Devotees offered the sacred Katina robe at the end of the rains retreat.",
            pastSinhala = "වස්සාන කාලය අවසානයේ බැතිමත්හු පූජනීය කඨින චීවරය පූජා කළහ.",
            presentEnglish = "The Katina offering is considered the highest merit-making ceremony.",
            presentSinhala = "කඨින පූජාව උතුම්ම කුසල් උපදවන පින්කම ලෙස සැලකේ.",
            futureEnglish = "We will participate in the dawn Katina procession.",
            futureSinhala = "අපි අලුයම කඨින පෙරහැරට සහභාගී වන්නෙමු.",
            verbTransformation = "offered → is considered → will participate"
          ),
          TenseSentenceItem(
            id = "t27_s23",
            baseActionSinhala = "ඝණ්ඨාරය නාද කිරීම",
            pastEnglish = "The temple caretaker struck the heavy bronze bell.",
            pastSinhala = "පන්සලේ භාරකරු බරැති ලෝකඩ ඝණ්ඨාරය නාද කළේය.",
            presentEnglish = "Resonating temple bells summon the village to prayer.",
            presentSinhala = "දෝංකාර දෙන පන්සල් ඝණ්ඨාර නාදය ගම්මානය වන්දනාවට කැඳවයි.",
            futureEnglish = "The bell will chime at six o'clock this evening.",
            futureSinhala = "අද සවස හයට ඝණ්ඨාරය නාද වනු ඇත.",
            verbTransformation = "struck → summon → will chime"
          ),
          TenseSentenceItem(
            id = "t27_s24",
            baseActionSinhala = "බෞද්ධ කොඩිය එසවීම",
            pastEnglish = "The youth hoisted the six-colored Buddhist flag reverently.",
            pastSinhala = "තරුණයා ෂඩ්වර්ණ බෞද්ධ ධජය භක්තියෙන් එසවීය.",
            presentEnglish = "The six rays symbolize the transcendent virtues of the Buddha.",
            presentSinhala = "ෂඩ්වර්ණ බුදුරජාණන් වහන්සේගේ උත්තරීතර ගුණධර්ම සංකේතවත් කරයි.",
            futureEnglish = "We will decorate our house gate with miniature flags.",
            futureSinhala = "අපි අපේ නිවසේ ගේට්ටුව කුඩා කොඩිවලින් සරසන්නෙමු.",
            verbTransformation = "hoisted → symbolize → will decorate"
          ),
          TenseSentenceItem(
            id = "t27_s25",
            baseActionSinhala = "චෛත්‍යයට කොත් පැළඳවීම",
            pastEnglish = "Artisans placed the gemstone crest atop the restored stupa.",
            pastSinhala = "ශිල්පීහු ප්‍රතිසංස්කරණය කළ චෛත්‍යය මුදුනේ චූඩාමාණික්‍යය පැළඳවූහ.",
            presentEnglish = "Gleaming stupa pinnacles shine as beacons of spiritual refuge.",
            presentSinhala = "දිලිසෙන චෛත්‍ය කොත් ආධ්‍යාත්මික සැනසිල්ලේ සංකේත ලෙස බබළයි.",
            futureEnglish = "Thousands will witness the enshrinement ceremony next month.",
            futureSinhala = "දහස් ගණනක් ලබන මාසයේ නිධන් වස්තු තැන්පත් කිරීමේ උළෙල නරඹනු ඇත.",
            verbTransformation = "placed → shine → will witness"
          ),
          TenseSentenceItem(
            id = "t27_s26",
            baseActionSinhala = "ආගමික සංහිඳියාව පැවැත්වීම",
            pastEnglish = "Leaders of diverse faiths prayed together for national peace.",
            pastSinhala = "විවිධ ආගමික නායකයෝ ජාතික සාමය උදෙසා එකට යාඥා කළහ.",
            presentEnglish = "Interfaith dialogue bridges communal divides and builds unity.",
            presentSinhala = "අන්තර් ආගමික සංවාදය ප්‍රජා භේද දුරු කර එකමුතුකම ගොඩනඟයි.",
            futureEnglish = "We will celebrate our cultural diversity in friendship.",
            futureSinhala = "අපි මිත්‍රත්වයෙන් අපගේ සංස්කෘතික විවිධත්වය සමරන්නෙමු.",
            verbTransformation = "prayed → bridges → will celebrate"
          ),
          TenseSentenceItem(
            id = "t27_s27",
            baseActionSinhala = "පොහෝ දින නිවස ආලෝකමත් කිරීම",
            pastEnglish = "Children lit clay oil lamps on the front parapet wall.",
            pastSinhala = "ළමයි ඉදිරිපස තාප්පය මත මැටි පහන් දැල්වූහ.",
            presentEnglish = "Illuminated homes honor sacred full moon festivals.",
            presentSinhala = "ආලෝකමත් නිවාස පූජනීය පසළොස්වක පෝය උත්සවයන්ට ගෞරව දක්වයි.",
            futureEnglish = "We will light colorful hanging paper lanterns tonight.",
            futureSinhala = "අපි අද රෑ වර්ණවත් එල්ලෙන කඩදාසි පහන් කූඩු දල්වන්නෙමු.",
            verbTransformation = "lit → honor → will light"
          ),
          TenseSentenceItem(
            id = "t27_s28",
            baseActionSinhala = "කර්මය විශ්වාස කිරීම",
            pastEnglish = "Our ancestors lived righteously believing in moral cause and effect.",
            pastSinhala = "අපේ මුතුන්මිත්තෝ හේතුඵල දහම විශ්වාස කරමින් ධාර්මිකව ජීවත් වූහ.",
            presentEnglish = "Wholesome actions yield blissful fruits in due time.",
            presentSinhala = "යහපත් ක්‍රියාවන් නියමිත කාලයේදී ප්‍රීතිමත් ඵල ලබා දෙයි.",
            futureEnglish = "You will reap the sweet rewards of your kind deeds.",
            futureSinhala = "ඔබ කළ යහපත් ක්‍රියාවල මිහිරි ප්‍රතිඵල ඔබ නෙළා ගනු ඇත.",
            verbTransformation = "lived → yield → will reap"
          ),
          TenseSentenceItem(
            id = "t27_s29",
            baseActionSinhala = "ආධ්‍යාත්මික සැනසීම ලැබීම",
            pastEnglish = "She found serene peace of mind inside the ancient temple cave.",
            pastSinhala = "ඇය පැරණි විහාර ලෙන් කුටිය තුළ සන්සුන් මනසේ සාමය ලැබුවාය.",
            presentEnglish = "Spiritual reflection heals hearts weary of mundane troubles.",
            presentSinhala = "ආධ්‍යාත්මික මෙනෙහි කිරීම ලෞකික කරදරවලින් වෙහෙසට පත් හදවත් සුවපත් කරයි.",
            futureEnglish = "You will dwell in tranquil equanimity and deep inner calm.",
            futureSinhala = "ඔබ සන්සුන් උපේක්ෂාවෙන් සහ ගැඹුරු අභ්‍යන්තර සාමයෙන් වාසය කරනු ඇත.",
            verbTransformation = "found → heals → will dwell"
          ),
          TenseSentenceItem(
            id = "t27_s30",
            baseActionSinhala = "නිවන් මඟ ප්‍රාර්ථනා කිරීම",
            pastEnglish = "Devotees aspired to attain the supreme bliss of Nibbana.",
            pastSinhala = "බැතිමත්හු උත්තරීතර නිවන් සුව ප්‍රාර්ථනා කළහ.",
            presentEnglish = "The Noble Eightfold Path leads to the cessation of all suffering.",
            presentSinhala = "ආර්ය අෂ්ටාංගික මාර්ගය සියලු දුක් කෙළවර කිරීමට මඟ පෙන්වයි.",
            futureEnglish = "May you attain the eternal supreme peace of Nibbana.",
            futureSinhala = "ඔබට සදාකාලික උත්තරීතර නිවන් සුව අත්වේවා.",
            verbTransformation = "aspired → leads → may you attain"
          )
        )
      )
    )
  }
}
