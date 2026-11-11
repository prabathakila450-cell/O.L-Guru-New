package com.example

/**
 * 100 Spoken Idioms & Conversational Phrasal Verbs
 * Essential conversational English expressions used by fluent speakers with Sinhala explanations and examples.
 */
data class SpokenIdiomItem(
  val id: String,
  val phrase: String,
  val category: String, // "Idiom" or "Phrasal Verb"
  val sinhalaMeaning: String,
  val englishExplanation: String,
  val exampleDialogue: String,
  val exampleSinhala: String
)

object SpokenIdioms100DataBank {

  val items: List<SpokenIdiomItem> = listOf(
    // 1 - 25: Common Conversational Idioms
    SpokenIdiomItem(
      "idm_1",
      "A piece of cake",
      "Idiom",
      "ඉතා පහසු දෙයක් (ලෙහෙසි වැඩක්)",
      "Something that is very easy to accomplish.",
      "Don't worry about the English dictation test; it's a piece of cake!",
      "ඉංග්‍රීසි ඩික්ටේෂන් පරීක්ෂණය ගැන බයවෙන්න එපා; ඒක හරිම ලෙහෙසි වැඩක්!"
    ),
    SpokenIdiomItem(
      "idm_2",
      "Break a leg",
      "Idiom",
      "සුබ පැතුම්! / හොඳින් කරන්න! (නාට්‍ය හෝ ඉදිරිපත් කිරීමකට පෙර)",
      "Good luck (especially before a stage performance).",
      "You are going on stage now to deliver your speech. Break a leg!",
      "ඔබ දැන් කතාව පැවැත්වීමට වේදිකාවට යනවා. ඔබට ජය වේවා!"
    ),
    SpokenIdiomItem(
      "idm_3",
      "Call it a day",
      "Idiom",
      "අදට වැඩ අවසන් කරනවා / නවත්වනවා",
      "To stop working on something for the rest of the day.",
      "We have completed ten model papers; let's call it a day.",
      "අපි ආදර්ශ ප්‍රශ්න පත්‍ර දහයක් අවසන් කළා; අදට වැඩ අවසන් කරමු."
    ),
    SpokenIdiomItem(
      "idm_4",
      "Hit the books",
      "Idiom",
      "උනන්දුවෙන් පාඩම් කිරීමට පටන් ගන්නවා",
      "To begin studying hard.",
      "The term test begins next week, so I really need to hit the books tonight.",
      "වාර විභාගය ලබන සතියේ ආරම්භ වෙනවා, එබැවින් මම අද රෑ හොඳින් පාඩම් කළ යුතුයි."
    ),
    SpokenIdiomItem(
      "idm_5",
      "Once in a blue moon",
      "Idiom",
      "ඉතාමත් කලාතුරකින් සිදුවන දෙයක්",
      "Something that happens very rarely.",
      "My busy uncle visits our village only once in a blue moon.",
      "මගේ කාර්යබහුල මාමා අපේ ගමට පැමිණෙන්නේ ඉතාමත් කලාතුරකිනි."
    ),
    SpokenIdiomItem(
      "idm_6",
      "Under the weather",
      "Idiom",
      "මඳ අසනීප ගතියක් දැනෙනවා",
      "Feeling slightly sick or unwell.",
      "I am feeling a bit under the weather today, so I will stay home.",
      "අද මට මඳ අසනීප ගතියක් දැනෙන නිසා මම ගෙදර නවතිනවා."
    ),
    SpokenIdiomItem(
      "idm_7",
      "Spill the beans",
      "Idiom",
      "රහසක් හෙළි කරනවා",
      "To disclose a secret, often prematurely.",
      "Don't spill the beans about the surprise birthday celebration!",
      "හදිසි උපන්දින සාදය පිළිබඳ රහස කලින් හෙළි කරන්න එපා!"
    ),
    SpokenIdiomItem(
      "idm_8",
      "Cost an arm and a leg",
      "Idiom",
      "ඉතා අධික මිලක් වෙනවා",
      "To be extremely expensive.",
      "Imported brand new laptop computers cost an arm and a leg nowadays.",
      "ආනයනික අලුත්ම ලැප්ටොප් පරිගණක මේ දිනවල ඉතා අධික මිලක් වේ."
    ),
    SpokenIdiomItem(
      "idm_9",
      "Bite the bullet",
      "Idiom",
      "අකමැත්තෙන් වුවත් අභියෝගයකට මුහුණ දෙනවා",
      "To face a difficult or unpleasant situation with courage.",
      "I was afraid of the dentist, but I had to bite the bullet and go.",
      "මම දන්ත වෛද්‍යවරයාට බිය වූවත්, අභියෝගයට මුහුණ දී යාමට සිදුවිය."
    ),
    SpokenIdiomItem(
      "idm_10",
      "Burn the midnight oil",
      "Idiom",
      "රෑ බෝවන තුරු වෙහෙස වී පාඩම් කරනවා හෝ වැඩ කරනවා",
      "To study or work late into the night.",
      "Many hardworking students burn the midnight oil before the O/L exams.",
      "බොහෝ වෙහෙස මහන්සි වී වැඩ කරන සිසුන් සාමාන්‍ය පෙළට පෙර රෑ බෝවන තුරු පාඩම් කරති."
    ),
    SpokenIdiomItem(
      "idm_11",
      "See eye to eye",
      "Idiom",
      "සම්පූර්ණයෙන්ම එකඟ වෙනවා",
      "To agree fully with someone on a matter.",
      "My study partner and I see eye to eye on how to structure our presentation.",
      "ඉදිරිපත් කිරීම සැකසිය යුතු ආකාරය ගැන මගේ අධ්‍යයන සහකරු සහ මම සම්පූර්ණයෙන්ම එකඟ වෙමු."
    ),
    SpokenIdiomItem(
      "idm_12",
      "Let the cat out of the bag",
      "Idiom",
      "නොදැනුවත්ව රහසක් එළිදරව් කරනවා",
      "To reveal a secret by mistake or carelessness.",
      "Kamal let the cat out of the bag about our prize winner.",
      "අපගේ ත්‍යාගලාභියා ගැන කමල් නොදැනුවත්ව රහස එළි කළේය."
    ),
    SpokenIdiomItem(
      "idm_13",
      "Through thick and thin",
      "Idiom",
      "සැපේදී මෙන්ම දුකේදීත් (ඕනෑම තත්ත්වයකදී)",
      "Under all conditions, no matter how challenging.",
      "True friends stand by each other through thick and thin.",
      "සැබෑ මිතුරන් ඕනෑම දුෂ්කර තත්ත්වයකදීත් එකිනෙකා ළඟ රැඳී සිටිති."
    ),
    SpokenIdiomItem(
      "idm_14",
      "Blessing in disguise",
      "Idiom",
      "මුලින් නරක ලෙස පෙනුණද පසුව යහපතක් වූ දෙයක්",
      "An apparent misfortune that eventually has good results.",
      "Missing that bus was a blessing in disguise; I met my former teacher.",
      "එම බස් රථය මගහැරීම යහපතක් විය; මට මගේ හිටපු ගුරුතුමා හමුවිය."
    ),
    SpokenIdiomItem(
      "idm_15",
      "Take it with a grain of salt",
      "Idiom",
      "යමක් සම්පූර්ණයෙන්ම විශ්වාස නොකර සැකයෙන් යුතුව බාරගන්නවා",
      "To not completely believe something that you are told.",
      "Online rumors should always be taken with a grain of salt.",
      "අන්තර්ජාල කටකතා සෑම විටම සම්පූර්ණයෙන්ම විශ්වාස නොකළ යුතුය."
    ),
    SpokenIdiomItem(
      "idm_16",
      "The ball is in your court",
      "Idiom",
      "තීරණය ගැනීම දැන් ඔබේ අතේ",
      "It is now your responsibility to make the next move or decision.",
      "I have explained both options; now the ball is in your court.",
      "මම විකල්ප දෙකම පැහැදිලි කළා; දැන් තීරණය ඔබ සතුයි."
    ),
    SpokenIdiomItem(
      "idm_17",
      "Over the moon",
      "Idiom",
      "ඉමහත් ප්‍රීතියට පත්වෙනවා",
      "Extremely happy and overjoyed.",
      "Kasun was over the moon when he heard he won the national essay competition.",
      "ජාතික රචනා තරගය ජයගත් බව ඇසූ විට කසුන් ඉමහත් ප්‍රීතියට පත් විය."
    ),
    SpokenIdiomItem(
      "idm_18",
      "Pull someone's leg",
      "Idiom",
      "විහිළු කරනවා / රැවටීමට තැත් කරනවා (සැහැල්ලුවෙන්)",
      "To tease someone playfully or joke with them.",
      "Don't be alarmed, I was just pulling your leg about having a pop quiz!",
      "බයවෙන්න එපා, හදිසි පරීක්ෂණයක් තියෙනවා කියලා මම නිකම් විහිළුවක් කළේ!"
    ),
    SpokenIdiomItem(
      "idm_19",
      "Rain cats and dogs",
      "Idiom",
      "ධාරානිපාත ලෙස වැසි ඇදහැලෙනවා",
      "To rain very heavily.",
      "We couldn't play badminton outside because it was raining cats and dogs.",
      "ධාරානිපාත වැසි ඇදහැළුණු නිසා අපට එළිමහනේ බැඩ්මින්ටන් ක්‍රීඩා කිරීමට නොහැකි විය."
    ),
    SpokenIdiomItem(
      "idm_20",
      "Barking up the wrong tree",
      "Idiom",
      "වැරදි තැනක පිළිතුරක් සොයනවා / වැරදි නිගමනයකට එළඹෙනවා",
      "Pursuing a mistaken line of thought or accusing the wrong person.",
      "If you think I took your eraser, you are barking up the wrong tree.",
      "මම ඔබේ මකනය ගත්තා යැයි ඔබ සිතන්නේ නම්, ඔබ සිතන්නේ වැරදි දිශාවකි."
    ),
    SpokenIdiomItem(
      "idm_21",
      "Straight from the horse's mouth",
      "Idiom",
      "සෘජුවම විශ්වාසදායක මුල් ප්‍රභවයෙන්ම දැනගන්නවා",
      "Directly from the person who has personal knowledge of the fact.",
      "I know the holiday was announced because I heard it straight from the principal's mouth.",
      "නිවාඩුව ප්‍රකාශයට පත් කළ බව මම දන්නේ විදුහල්පතිතුමාගෙන්ම සෘජුවම ඇසූ නිසාය."
    ),
    SpokenIdiomItem(
      "idm_22",
      "Kill two birds with one stone",
      "Idiom",
      "එකම ක්‍රියාවකින් ප්‍රයෝජන දෙකක් ලබාගන්නවා",
      "To accomplish two different things with a single action.",
      "Cycling to school keeps me fit and saves bus fare; killing two birds with one stone.",
      "පාසලට බයිසිකල් පැදීමෙන් සිරුර නිරෝගී වන අතර බස් ගාස්තුද ඉතිරි වේ; එක ගලෙන් කුරුල්ලන් දෙදෙනෙකි."
    ),
    SpokenIdiomItem(
      "idm_23",
      "Cross that bridge when we come to it",
      "Idiom",
      "ගැටලුවක් මතු වූ විට ඒ ගැන සිතනවා (කලින් කරදර නොවී)",
      "To deal with a problem only when it actually arises.",
      "Let us finish this term's syllabus first and cross that bridge when we come to it.",
      "අපි මුලින්ම මෙම වාරයේ විෂය නිර්දේශය අවසන් කරමු, එම ගැටලුව ආ විට ඒ ගැන සිතමු."
    ),
    SpokenIdiomItem(
      "idm_24",
      "Keep an eye on",
      "Idiom",
      "ඇස ගසාගෙන සිටිනවා / විමසිල්ලෙන් බලාගන්නවා",
      "To watch or monitor someone or something carefully.",
      "Could you please keep an eye on my backpack while I grab a bottle of water?",
      "මම වතුර බෝතලයක් ගන්නා තුරු මගේ බෑගය ගැන මඳක් විමසිල්ලෙන් සිටිය හැකිද?"
    ),
    SpokenIdiomItem(
      "idm_25",
      "Beat around the bush",
      "Idiom",
      "කෙළින්ම කාරණයට නොපැමිණ වටින් ගොඩින් කතා කරනවා",
      "To avoid talking directly about what is important.",
      "Please stop beating around the bush and tell me frankly what happened.",
      "වටින් ගොඩින් කතා නොකර කරුණාකර සිදුවූ දේ කෙළින්ම මට කියන්න."
    ),

    // 26 - 50: Essential Conversational Phrasal Verbs
    SpokenIdiomItem(
      "idm_26",
      "Give up",
      "Phrasal Verb",
      "උත්සාහය අත්හරිනවා / පරාජය භාරගන්නවා",
      "To cease making an effort; to quit.",
      "No matter how difficult the mathematics equation seems, never give up!",
      "ගණිත සමීකරණය කෙතරම් අපහසු බව පෙනුනද, කිසිවිටෙකත් උත්සාහය අත්හරින්න එපා!"
    ),
    SpokenIdiomItem(
      "idm_27",
      "Figure out",
      "Phrasal Verb",
      "තේරුම් ගන්නවා / විසඳුමක් සොයාගන්නවා",
      "To understand or solve something through reasoning.",
      "We finally figured out how to balance the chemical equation correctly.",
      "රසායනික සමීකරණය නිවැරදිව තුලනය කරන්නේ කෙසේදැයි අවසානයේ අපි තේරුම් ගත්තෙමු."
    ),
    SpokenIdiomItem(
      "idm_28",
      "Call off",
      "Phrasal Verb",
      "අවලංගු කරනවා (නැවැත්වීම)",
      "To cancel an event or activity.",
      "Due to torrential thunder showers, the inter-house cricket match was called off.",
      "ධාරානිපාත ගිගුරුම් සහිත වැසි නිසා නිවාස අතර ක්‍රිකට් තරගය අවලංගු කෙරිණි."
    ),
    SpokenIdiomItem(
      "idm_29",
      "Put off",
      "Phrasal Verb",
      "පසුකාලයකට කල් දමනවා",
      "To postpone an event or task to a later date.",
      "Never put off until tomorrow what you can accomplish today.",
      "අද කළ හැකි දෙය කිසිවිටෙකත් හෙටට කල් දමන්න එපා."
    ),
    SpokenIdiomItem(
      "idm_30",
      "Look up to",
      "Phrasal Verb",
      "ගෞරවයෙන් සලකනවා / ආදර්ශයට ගන්නවා",
      "To admire and deeply respect someone as a role model.",
      "I have always looked up to my science teacher for his dedication.",
      "මගේ විද්‍යා ගුරුතුමාගේ කැපවීම නිසා මම සැමවිටම ඔහුට මහත් සේ ගරු කරමි."
    ),
    SpokenIdiomItem(
      "idm_31",
      "Run out of",
      "Phrasal Verb",
      "ඉවර වෙනවා / හිස් වෙනවා",
      "To have no more of a supply left.",
      "We ran out of printer paper just before printing the model test.",
      "ආදර්ශ පරීක්ෂණය මුද්‍රණය කිරීමට මොහොතකට පෙර අපේ මුද්‍රණ කඩදාසි ඉවර විය."
    ),
    SpokenIdiomItem(
      "idm_32",
      "Turn down",
      "Phrasal Verb",
      "ප්‍රතික්ෂේප කරනවා හෝ ශබ්දය අඩු කරනවා",
      "To refuse an offer or reduce the volume of a device.",
      "Could you please turn down the television volume while I am studying?",
      "මම පාඩම් කරන අතරතුර කරුණාකර රූපවාහිනියේ ශබ්දය අඩු කළ හැකිද?"
    ),
    SpokenIdiomItem(
      "idm_33",
      "Carry out",
      "Phrasal Verb",
      "ක්‍රියාත්මක කරනවා / ඉටු කරනවා",
      "To perform or conduct a task, experiment, or order.",
      "The students carried out the botany experiment with utmost care.",
      "සිසුන් උද්භිද විද්‍යා පරීක්ෂණය ඉතාමත්ම සැලකිල්ලෙන් යුතුව ක්‍රියාත්මක කළහ."
    ),
    SpokenIdiomItem(
      "idm_34",
      "Bring up",
      "Phrasal Verb",
      "මාතෘකාවක් මතු කරනවා හෝ දරුවෙකු හදා වඩා ගන්නවා",
      "To mention a topic in conversation or raise a child.",
      "She brought up an interesting point during the debate on climate change.",
      "දේශගුණික විපර්යාස පිළිබඳ විවාදයේදී ඇය රසවත් කරුණක් මතු කළාය."
    ),
    SpokenIdiomItem(
      "idm_35",
      "Catch up with",
      "Phrasal Verb",
      "පසුපසින් සිට ළඟා වෙනවා හෝ මිතුරෙකු සමඟ තොරතුරු බෙදාගන්නවා",
      "To reach the same level as someone or meet to share news.",
      "Let's meet at the canteen after school to catch up with each other.",
      "පාසලෙන් පසු එකිනෙකාගේ තොරතුරු කතාබස් කිරීමට කැන්ටින් එකේදී හමුවෙමු."
    ),
    SpokenIdiomItem(
      "idm_36",
      "Look forward to",
      "Phrasal Verb",
      "ඉමහත් උනන්දුවෙන් බලාපොරොත්තු වෙනවා",
      "To anticipate something with excitement and pleasure.",
      "I am really looking forward to our annual school educational excursion.",
      "අපගේ වාර්ෂික පාසල් අධ්‍යාපනික චාරිකාව මම ඉමහත් උනන්දුවෙන් බලාපොරොත්තු වෙමි."
    ),
    SpokenIdiomItem(
      "idm_37",
      "Get along with",
      "Phrasal Verb",
      "හොඳ සුහද සම්බන්ධතාවයකින් කටයුතු කරනවා",
      "To have a harmonious and friendly relationship with someone.",
      "Amal gets along well with everyone in our classroom.",
      "අපේ පන්තියේ සෑම දෙනා සමඟම අමල් ඉතා හොඳ සුහදතාවයකින් කටයුතු කරයි."
    ),
    SpokenIdiomItem(
      "idm_38",
      "Hold on",
      "Phrasal Verb",
      "මොහොතක් රැඳී සිටිනවා (විශේෂයෙන් දුරකථනයේදී)",
      "To wait for a short time.",
      "Hold on a second, let me grab a pen to write down your phone number.",
      "තත්පරයක් ඉන්න, ඔබේ දුරකථන අංකය ලියාගැනීමට මම පෑනක් ගන්නම්."
    ),
    SpokenIdiomItem(
      "idm_39",
      "Drop out",
      "Phrasal Verb",
      "පාසලෙන් හෝ තරගයකින් අතරමඟ ඉවත් වෙනවා",
      "To leave school or a competition before completion.",
      "Free education in Sri Lanka ensures that children do not drop out early.",
      "ශ්‍රී ලංකාවේ නිදහස් අධ්‍යාපනය මඟින් දරුවන් අතරමඟ පාසල් හැරයාම වළක්වයි."
    ),
    SpokenIdiomItem(
      "idm_40",
      "Show up",
      "Phrasal Verb",
      "පැමිණෙනවා / පෙනී සිටිනවා",
      "To arrive or appear at an event or meeting.",
      "All forty students showed up on time for the Saturday revision session.",
      "සෙනසුරාදා පුනරීක්ෂණ සැසියට සිසුන් හතළිස් දෙනාම නියමිත වේලාවට පැමිණියහ."
    ),
    SpokenIdiomItem(
      "idm_41",
      "Look into",
      "Phrasal Verb",
      "විමර්ශනය කරනවා / කරුණු සොයා බලනවා",
      "To investigate or examine the facts of a situation.",
      "The principal promised to look into the drinking water shortage promptly.",
      "බීමට ගන්නා ජල හිඟය පිළිබඳව වහාම සොයා බැලීමට විදුහල්පතිතුමා පොරොන්දු විය."
    ),
    SpokenIdiomItem(
      "idm_42",
      "Break down",
      "Phrasal Verb",
      "කාර්මික දෝෂයකට ලක්වෙනවා හෝ කඩා වැටෙනවා",
      "To stop functioning due to a mechanical fault or emotional collapse.",
      "The school bus broke down near the junction, causing a twenty-minute delay.",
      "හන්දිය අසලදී පාසල් බස් රථය කාර්මික දෝෂයකට ලක්වූ නිසා විනාඩි විස්සක ප්‍රමාදයක් සිදුවිය."
    ),
    SpokenIdiomItem(
      "idm_43",
      "Take off",
      "Phrasal Verb",
      "ගුවන් යානයක් ගුවන්ගත වෙනවා හෝ ඇඳුමක් ගලවනවා",
      "To leave the ground and begin flight, or remove clothing.",
      "Please take off your muddy shoes before entering the computer laboratory.",
      "පරිගණක විද්‍යාගාරයට ඇතුළු වීමට පෙර කරුණාකර මඩ තැවරුණු සපත්තු ගලවන්න."
    ),
    SpokenIdiomItem(
      "idm_44",
      "Come across",
      "Phrasal Verb",
      "අනපේක්ෂිත ලෙස හමුවෙනවා",
      "To find or meet someone or something unexpectedly.",
      "While reading the historical document, I came across an unfamiliar ancient term.",
      "ඓතිහාසික ලේඛනය කියවන අතරතුර මට නුහුරු පැරණි වචනයක් හමුවිය."
    ),
    SpokenIdiomItem(
      "idm_45",
      "Work out",
      "Phrasal Verb",
      "ව්‍යායාම කරනවා හෝ සාර්ථක ලෙස විසඳෙනවා",
      "To exercise physically or find a successful resolution.",
      "Don't panic; everything will work out fine if we stick to the plan.",
      "බිය නොවන්න; අපි සැලැස්මට අනුව වැඩ කළහොත් සියල්ල හොඳින් විසඳෙනු ඇත."
    ),
    SpokenIdiomItem(
      "idm_46",
      "Hang out",
      "Phrasal Verb",
      "මිතුරන් සමඟ විනෝදයෙන් කාලය ගත කරනවා",
      "To spend time relaxing with friends informally.",
      "We usually hang out at the school playground after class on Fridays.",
      "සිකුරාදා දිනවල පන්තියෙන් පසු අපි සාමාන්‍යයෙන් පාසල් ක්‍රීඩා පිටියේ කාලය ගත කරමු."
    ),
    SpokenIdiomItem(
      "idm_47",
      "Pass away",
      "Phrasal Verb",
      "අභාවප්‍රාප්ත වෙනවා / මිය යනවා (ආචාරශීලී වචනය)",
      "To die (used politely to soften the tone).",
      "The village was saddened when the respected retired teacher passed away.",
      "ගෞරවනීය විශ්‍රාමික ගුරුතුමා අභාවප්‍රාප්ත වූ විට මුළු ගමම දැඩි ශෝකයට පත් විය."
    ),
    SpokenIdiomItem(
      "idm_48",
      "Look after",
      "Phrasal Verb",
      "බලා කියාගන්නවා / රැකබලා ගන්නවා",
      "To take care of someone or something.",
      "I promised my parents that I would look after my little brother today.",
      "අද මගේ කුඩා මල්ලීව හොඳින් රැකබලා ගන්නා බවට මම දෙමාපියන්ට පොරොන්දු වීමි."
    ),
    SpokenIdiomItem(
      "idm_49",
      "Turn up",
      "Phrasal Verb",
      "නොසිතූ ලෙස මතුවෙනවා හෝ ශබ්දය වැඩි කරනවා",
      "To appear unexpectedly or increase sound volume.",
      "My lost student identity card turned up inside the library book pocket.",
      "නැතිවී තිබූ මගේ ශිෂ්‍ය හැඳුනුම්පත පුස්තකාල පොත් සාක්කුව තුළ තිබී හමුවිය."
    ),
    SpokenIdiomItem(
      "idm_50",
      "Back out",
      "Phrasal Verb",
      "පොරොන්දුවකින් හෝ ගිවිසුමකින් පසුබසිනවා",
      "To withdraw from a commitment or agreement.",
      "Once you volunteer for the school prefect board, you cannot back out.",
      "පාසල් ශිෂ්‍ය නායක මණ්ඩලයට ස්වේච්ඡාවෙන් ඉදිරිපත් වූ පසු ඔබට එයින් පසුබැසිය නොහැක."
    ),

    // 51 - 75: Advanced Spoken Idioms
    SpokenIdiomItem(
      "idm_51",
      "At the eleventh hour",
      "Idiom",
      "අවසන්ම මොහොතේදී",
      "At the latest possible time before a deadline.",
      "He submitted his O/L registration form at the eleventh hour.",
      "ඔහු තම සාමාන්‍ය පෙළ ලියාපදිංචි පෝරමය භාර දුන්නේ අවසන්ම මොහොතේදීය."
    ),
    SpokenIdiomItem(
      "idm_52",
      "A blessing in disguise",
      "Idiom",
      "යහපතක් ගෙන දුන් අනපේක්ෂිත සිදුවීමක්",
      "An unexpected occurrence that brings positive outcomes later.",
      "Getting rejected from that team was a blessing in disguise; I focused on academics.",
      "එම කණ්ඩායමට නොතේරීම යහපතක් විය; මම අධ්‍යාපනයට සම්පූර්ණ අවධානය යොමු කළෙමි."
    ),
    SpokenIdiomItem(
      "idm_53",
      "Cry over spilled milk",
      "Idiom",
      "වූ දේ ගැන පසුතැවෙමින් කාලය නාස්ති කරනවා",
      "To waste time feeling regret about something that cannot be changed.",
      "The mistake is done; there is no use crying over spilled milk now.",
      "වරද සිදුවී හමාරයි; දැන් වූ දේ ගැන පසුතැවීමෙන් ඵලක් නැත."
    ),
    SpokenIdiomItem(
      "idm_54",
      "Every cloud has a silver lining",
      "Idiom",
      "සෑම නරක තත්ත්වයකම යම් යහපත් බලාපොරොත්තුවක් ඇත",
      "Every bad situation contains a positive aspect or hope.",
      "Keep practicing; every cloud has a silver lining, and your time will come.",
      "දිගටම පුහුණු වන්න; සෑම අඳුරු වළාවකම රිදී රේඛාවක් ඇති අතර ඔබේ ජයග්‍රහණය උදාවනු ඇත."
    ),
    SpokenIdiomItem(
      "idm_55",
      "Give someone the benefit of the doubt",
      "Idiom",
      "සැකය වෙනුවට සාධාරණ විශ්වාසය ලබා දෙනවා",
      "To believe someone despite having some doubts about them.",
      "He said his alarm failed; let us give him the benefit of the doubt this once.",
      "ඔහුගේ එලාම් එක නාද නොවූ බව ඔහු පැවසුවා; මෙවරට ඔහු ගැන විශ්වාසය තබමු."
    ),
    SpokenIdiomItem(
      "idm_56",
      "In the heat of the moment",
      "Idiom",
      "කෝපයේ හෝ කලබලයේ උච්චතම අවස්ථාවේදී",
      "Overwhelmed by intense emotion, saying things one later regrets.",
      "He apologized for raising his voice in the heat of the moment.",
      "කලබලකාරී අවස්ථාවේදී කටහඬ උස් කිරීම පිළිබඳව ඔහු සමාව අයැද සිටියේය."
    ),
    SpokenIdiomItem(
      "idm_57",
      "Keep your chin up",
      "Idiom",
      "හිත නොදමා ධෛර්යයෙන් ඉන්න",
      "Stay optimistic and strong in a difficult time.",
      "Keep your chin up, Kasun; one poor mark doesn't define your true brilliance.",
      "හිත ශක්තිමත්ව තබාගන්න කසුන්; එක් අඩු ලකුණකින් ඔබේ සැබෑ දක්ෂතාවය මැනිය නොහැක."
    ),
    SpokenIdiomItem(
      "idm_58",
      "Leave no stone unturned",
      "Idiom",
      "කළ හැකි සෑම උත්සාහයක්ම දරනවා",
      "To do everything possible in order to achieve something.",
      "The police left no stone unturned to locate the lost child.",
      "නැතිවූ දරුවා සෙවීම සඳහා පොලිසිය කළ හැකි සෑම උත්සාහයක්ම දැරීය."
    ),
    SpokenIdiomItem(
      "idm_59",
      "Make ends meet",
      "Idiom",
      "ආදායමෙන් යන්තම් වියදම පියවා ගන්නවා",
      "To earn just enough money to live on.",
      "His parents work tirelessly from dawn to dusk just to make ends meet.",
      "ඔහුගේ දෙමාපියන් උදෑසන සිට සවස වන තුරු වෙහෙසෙන්නේ වියදම පියවා ගැනීමටයි."
    ),
    SpokenIdiomItem(
      "idm_60",
      "On cloud nine",
      "Idiom",
      "ඉමහත් සතුටින් පිනා යනවා",
      "In a state of pure euphoria or immense happiness.",
      "She has been on cloud nine since hearing of her scholarship approval.",
      "ශිෂ්‍යත්වය අනුමත වූ බව ඇසූ තැන් පටන් ඇය ඉමහත් සතුටින් පසුවන්නීය."
    ),
    SpokenIdiomItem(
      "idm_61",
      "Play it by ear",
      "Idiom",
      "කලින් සැලසුම් නොකර තත්ත්වයට අනුව තීරණය කරනවා",
      "To proceed without fixed rules or plans, reacting as events develop.",
      "We haven't booked our afternoon tickets yet, so let us play it by ear.",
      "අපි තවම ටිකට් වෙන් කර නැත, එබැවින් අවස්ථාවට අනුව තීරණය කරමු."
    ),
    SpokenIdiomItem(
      "idm_62",
      "Raining cats and dogs",
      "Idiom",
      "අධික වැසි ඇදහැලෙනවා",
      "Pouring rain with immense force.",
      "Take your umbrella, it is raining cats and dogs outside right now.",
      "කුඩය අරන් යන්න, දැන් පිටත අධික වැසි ඇදහැලෙනවා."
    ),
    SpokenIdiomItem(
      "idm_63",
      "Spill the tea",
      "Idiom",
      "නවතම තොරතුරු හෝ ඕපාදූප හෙළි කරනවා (නූතන කථන)",
      "To share the latest gossip or hidden details.",
      "Come on, sit down and spill the tea about what happened at the meet!",
      "එන්න, වාඩිවෙලා තරගයේදී මොකද වුණේ කියලා විස්තරේ කියන්න!"
    ),
    SpokenIdiomItem(
      "idm_64",
      "The best of both worlds",
      "Idiom",
      "දෙපැත්තෙන්ම ලැබෙන උපරිම වාසිය",
      "A situation where you can enjoy the advantages of two distinct things.",
      "Studying online while living with family gives you the best of both worlds.",
      "පවුලේ අය සමඟ නිවසේ සිටිමින් අන්තර්ජාලයෙන් ඉගෙනීමෙන් දෙපැත්තෙන්ම උපරිම වාසි ලැබේ."
    ),
    SpokenIdiomItem(
      "idm_65",
      "Touch wood",
      "Idiom",
      "වාසනාව දිගටම පවතීවායි පතමින් කියන වදනක්",
      "Said in order to prevent bad luck after talking about good fortune.",
      "I haven't fallen sick once this term, touch wood!",
      "මේ වාරයේ එක දවසක්වත් මම ලෙඩ වුණේ නැහැ, වාසනාව දිගටම පවතීවා!"
    ),
    SpokenIdiomItem(
      "idm_66",
      "Walk on eggshells",
      "Idiom",
      "යමෙකු කෝප නොගැන්වීමට ඉතා පරෙස්සමින් කටයුතු කරනවා",
      "To be extremely cautious about one's words and actions to avoid upset.",
      "Whenever the strict coach is in a bad mood, everyone walks on eggshells.",
      "දැඩි පුහුණුකරු අසතුටින් සිටින විට සෑම දෙනාම ඉතා පරෙස්සමෙන් හැසිරෙති."
    ),
    SpokenIdiomItem(
      "idm_67",
      "A penny for your thoughts",
      "Idiom",
      "ඔබ සිතන්නේ කුමක් ගැනදැයි අසන ආචාරශීලී පැනයක්",
      "A friendly inquiry asking someone what they are thinking about.",
      "You look deeply reflective, Ruwan. A penny for your thoughts?",
      "ඔබ ගැඹුරු කල්පනාවක ඉන්නවා වගෙයි රුවන්. ඔබ සිතන්නේ කුමක් ගැනද?"
    ),
    SpokenIdiomItem(
      "idm_68",
      "Barking up the wrong tree",
      "Idiom",
      "වැරදි නිගමනයකට එළඹීම",
      "Making an incorrect assumption or pursuing a false lead.",
      "If you accuse me of leaking the paper, you are barking up the wrong tree.",
      "ප්‍රශ්න පත්‍රය පිටකළා යැයි මට චෝදනා කරන්නේ නම්, ඔබ වැරදි කෙනෙකුටයි චෝදනා කරන්නේ."
    ),
    SpokenIdiomItem(
      "idm_69",
      "By the skin of one's teeth",
      "Idiom",
      "යන්තමින් හෝ අනූනවයෙන් බේරෙනවා",
      "Barely succeeding or escaping disaster by the narrowest margin.",
      "He caught the departure train by the skin of his teeth.",
      "ඔහු පිටත්ව යන දුම්රියට ගොඩවුණේ අනූනවයෙනි."
    ),
    SpokenIdiomItem(
      "idm_70",
      "Elephant in the room",
      "Idiom",
      "සැවොම දන්නා නමුත් කතා කිරීමට මඟහරින ප්‍රධාන ගැටලුව",
      "An obvious major problem that people avoid discussing because it is uncomfortable.",
      "Everyone ignored our lack of funds, but it was clearly the elephant in the room.",
      "අපේ අරමුදල් හිඟය සියල්ලන් නොසලකා හැරියද, එය සැමට පෙනෙන ප්‍රධාන ගැටලුවක් විය."
    ),
    SpokenIdiomItem(
      "idm_71",
      "Face the music",
      "Idiom",
      "තමන් කළ වැරැද්දේ ප්‍රතිවිපාකවලට නිර්භීතව මුහුණ දෙනවා",
      "To accept the unpleasant consequences of one's actions.",
      "I broke the laboratory beaker, so I must face the music and inform the teacher.",
      "මගේ අතින් බීකරය කැඩුණා, එබැවින් මම ගුරුතුමියට පවසා ප්‍රතිවිපාකවලට මුහුණ දිය යුතුය."
    ),
    SpokenIdiomItem(
      "idm_72",
      "Get a taste of one's own medicine",
      "Idiom",
      "අනුන්ට කළ නරක දේ තමන්ටම පෙරළා විඳීමට සිදුවීම",
      "To experience the same unpleasant treatment that one gave to others.",
      "The bully got a taste of his own medicine when the referee penalized him.",
      "විනිසුරුවරයා ඔහුට දඬුවම් කළ විට අනුන්ට කළ දේ ඔහුටම විඳීමට සිදුවිය."
    ),
    SpokenIdiomItem(
      "idm_73",
      "Hit the nail on the head",
      "Idiom",
      "හරියටම නිවැරදි කාරණය පවසනවා",
      "To describe exactly what is causing a situation or answer precisely.",
      "Your analysis of the economic crisis hit the nail on the head.",
      "ආර්ථික අර්බුදය පිළිබඳ ඔබේ විශ්ලේෂණය හරියටම නිවැරදි කරුණ ස්පර්ශ කළේය."
    ),
    SpokenIdiomItem(
      "idm_74",
      "Keep something at bay",
      "Idiom",
      "නරක දෙයක් ළඟාවීම වළක්වා දුරින් තබා ගන්නවා",
      "To prevent something harmful from coming near or affecting you.",
      "Eating healthy fresh fruit helps keep illnesses at bay.",
      "නැවුම් පලතුරු ආහාරයට ගැනීමෙන් රෝග බෝවීම වළක්වා ඈත් කර තබාගත හැකිය."
    ),
    SpokenIdiomItem(
      "idm_75",
      "Let sleeping dogs lie",
      "Idiom",
      "පැරණි ආරවුල් නැවත අවුස්සන්නේ නැතිව ඉන්නවා",
      "To avoid restarting a conflict that has settled down.",
      "The argument was resolved yesterday, so let sleeping dogs lie.",
      "ඊයේ වාදය බේරුණා, එබැවින් පැරණි ආරවුල් නැවත අවුස්සන්න එපා."
    ),

    // 76 - 100: Practical Phrasal Verbs for Everyday Fluent Speech
    SpokenIdiomItem(
      "idm_76",
      "Cheer up",
      "Phrasal Verb",
      "සතුටු වෙනවා / සිත සැහැල්ලු කරගන්නවා",
      "To become happier or help someone feel happier.",
      "Cheer up! You still have plenty of time to revise for the final paper.",
      "සතුටු වන්න! අවසන් ප්‍රශ්න පත්‍රයට පාඩම් කිරීමට ඔබට තව බොහෝ වේලාවක් ඇත."
    ),
    SpokenIdiomItem(
      "idm_77",
      "Count on",
      "Phrasal Verb",
      "විශ්වාසය තබනවා / යැපෙනවා",
      "To rely or depend on someone with certainty.",
      "You can always count on me whenever you need help with English essays.",
      "ඉංග්‍රීසි රචනා සඳහා උදව් අවශ්‍ය ඕනෑම විටක ඔබට මා කෙරෙහි විශ්වාසය තැබිය හැකිය."
    ),
    SpokenIdiomItem(
      "idm_78",
      "Do over",
      "Phrasal Verb",
      "නැවත මුල සිට කරනවා (වරදක් නිවැරදි කරමින්)",
      "To repeat an action from the beginning to correct errors.",
      "The teacher asked me to do the math worksheet over because of messy handwriting.",
      "අත්අකුරු පැහැදිලි නැති නිසා ගණිත අභ්‍යාස පත්‍රිකාව නැවත කරන ලෙස ගුරුතුමිය මට පැවසුවාය."
    ),
    SpokenIdiomItem(
      "idm_79",
      "Dress up",
      "Phrasal Verb",
      "විශේෂ අවස්ථාවකට අලංකාරව ඇඳුම් අඳිනවා",
      "To wear formal or elegant clothes for a special occasion.",
      "All students dressed up smartly for the school prize giving ceremony.",
      "පාසල් ත්‍යාග ප්‍රදානෝත්සවය සඳහා සියලුම සිසුන් ඉතා අලංකාර ලෙස ඇඳුම් ඇඳ සිටියහ."
    ),
    SpokenIdiomItem(
      "idm_80",
      "Drop by",
      "Phrasal Verb",
      "කෙටි වේලාවකට නිකමට මෙන් ගොඩවෙනවා",
      "To visit someone casually without an appointment.",
      "Feel free to drop by my house this afternoon to pick up the past papers.",
      "පසුගිය ප්‍රශ්න පත්‍ර ලබා ගැනීමට අද සවස මගේ නිවසට නිකමට ගොඩවන්න."
    ),
    SpokenIdiomItem(
      "idm_81",
      "Fall behind",
      "Phrasal Verb",
      "අනෙක් අයට වඩා පස්සෙන් වැටෙනවා",
      "To fail to keep up with the expected pace or schedule.",
      "If you miss too many classes, you will fall behind in chemistry.",
      "ඔබ වැඩිපුර පන්ති මඟහැරියහොත් රසායන විද්‍යාවෙන් පස්සෙන් වැටෙනු ඇත."
    ),
    SpokenIdiomItem(
      "idm_82",
      "Get over",
      "Phrasal Verb",
      "දුකක් හෝ අසනීපයකින් සුවය ලබනවා",
      "To recover from an illness or emotional disappointment.",
      "It took her a week to get over the bad bout of flu.",
      "දැඩි උණ සෙම්ප්‍රතිශ්‍යාවෙන් සුවය ලැබීමට ඇයට සතියක කාලයක් ගත විය."
    ),
    SpokenIdiomItem(
      "idm_83",
      "Hand in",
      "Phrasal Verb",
      "පැවරුමක් හෝ ලිපියක් භාර දෙනවා",
      "To submit work to a person in authority.",
      "Please hand in your answer scripts as soon as the bell rings.",
      "සීනුව නාද වූ වහාම කරුණාකර ඔබගේ පිළිතුරු පත්‍ර භාර දෙන්න."
    ),
    SpokenIdiomItem(
      "idm_84",
      "Keep up with",
      "Phrasal Verb",
      "එක සමාන වේගයකින් අනුගමනය කරමින් ඉදිරියට යනවා",
      "To stay at the same pace or level as others.",
      "He runs fast, making it difficult for the rest of the runners to keep up with him.",
      "ඔහු වේගයෙන් දුවන බැවින් අනෙක් ධාවකයන්ට ඔහු සමඟ එක සමානව දිවීම අපහසු විය."
    ),
    SpokenIdiomItem(
      "idm_85",
      "Look forward to",
      "Phrasal Verb",
      "ඉමහත් බලාපොරොත්තුවෙන් පසුවෙනවා",
      "To eagerly await an upcoming event.",
      "We look forward to welcoming the foreign delegates to our academy.",
      "විදේශීය නියෝජිතයින් අපගේ ආයතනයට සාදරයෙන් පිළිගැනීමට අපි බලාපොරොත්තු වෙමු."
    ),
    SpokenIdiomItem(
      "idm_86",
      "Make up for",
      "Phrasal Verb",
      "අඩුවක් හෝ වරදක් පිරිමසනවා",
      "To compensate for a loss, mistake, or absence.",
      "I will study double hours this weekend to make up for lost time.",
      "මගහැරුණු කාලය පිරිමසා ගැනීමට මම මේ සති අන්තයේ දෙගුණයක් පාඩම් කරමි."
    ),
    SpokenIdiomItem(
      "idm_87",
      "Pay attention to",
      "Phrasal Verb",
      "සාවධානව අවධානය යොමු කරනවා",
      "To focus carefully on what someone is doing or saying.",
      "Pay attention to the teacher's instructions regarding lab safety.",
      "විද්‍යාගාර ආරක්ෂාව පිළිබඳ ගුරුතුමාගේ උපදෙස් වලට සාවධානව අවධානය යොමු කරන්න."
    ),
    SpokenIdiomItem(
      "idm_88",
      "Point out",
      "Phrasal Verb",
      "පෙන්වා දෙනවා / අවධානයට ලක් කරනවා",
      "To direct attention towards a specific fact or detail.",
      "The examiner pointed out that handwriting clarity counts towards marks.",
      "අත්අකුරුවල පැහැදිලිභාවය ලකුණු සඳහා බලපාන බව පරීක්ෂකවරයා පෙන්වා දුන්නේය."
    ),
    SpokenIdiomItem(
      "idm_89",
      "Put up with",
      "Phrasal Verb",
      "ඉවසා දරාගන්නවා",
      "To tolerate or endure an unpleasant situation patiently.",
      "I cannot put up with this loud noise while trying to study.",
      "පාඩම් කිරීමට උත්සාහ කරන අතරතුර මෙම ඝෝෂාකාරී ශබ්දය ඉවසා සිටිය නොහැක."
    ),
    SpokenIdiomItem(
      "idm_90",
      "Set up",
      "Phrasal Verb",
      "පිහිටුවනවා හෝ සූදානම් කරනවා",
      "To establish or arrange equipment and facilities.",
      "The IT club members set up the multimedia projector in the hall.",
      "තොරතුරු තාක්ෂණ සමාජයේ සාමාජිකයින් ශාලාවේ ප්‍රොජෙක්ටරය සූදානම් කළහ."
    ),
    SpokenIdiomItem(
      "idm_91",
      "Take part in",
      "Phrasal Verb",
      "සහභාගී වෙනවා",
      "To participate in an event, activity, or competition.",
      "Every student is encouraged to take part in at least one sport.",
      "අවම වශයෙන් එක් ක්‍රීඩාවකට හෝ සහභාගී වීමට සෑම සිසුවෙකුම දිරිමත් කරනු ලැබේ."
    ),
    SpokenIdiomItem(
      "idm_92",
      "Warm up",
      "Phrasal Verb",
      "ඇඟ උණුසුම් කරගන්නවා (ක්‍රීඩාවකට පෙර)",
      "To prepare for athletic activity with gentle exercises.",
      "Warm up properly before sprinting to avoid hamstring injuries.",
      "මාංශ පේශි ආබාධ වළක්වා ගැනීමට කෙටි දුර දිවීමට පෙර හොඳින් ඇඟ උණුසුම් කරගන්න."
    ),
    SpokenIdiomItem(
      "idm_93",
      "Bring about",
      "Phrasal Verb",
      "යම් වෙනසක් හෝ ප්‍රතිඵලයක් ඇති කරනවා",
      "To cause something to happen.",
      "Dedicated education brings about positive social transformation.",
      "කැපවීමෙන් ලබන අධ්‍යාපනය ධනාත්මක සමාජ පරිවර්තනයක් ඇති කරයි."
    ),
    SpokenIdiomItem(
      "idm_94",
      "Call upon",
      "Phrasal Verb",
      "ඉල්ලීමක් කරනවා හෝ ආරාධනා කරනවා",
      "To formally invite someone to speak or perform.",
      "I now call upon the chief guest to deliver the keynote address.",
      "ප්‍රධාන දේශනය පැවැත්වීම සඳහා ප්‍රධාන ආරාධිත අමුත්තාට මම දැන් ගෞරවයෙන් ආරාධනා කරමි."
    ),
    SpokenIdiomItem(
      "idm_95",
      "Check in",
      "Phrasal Verb",
      "පැමිණීම සටහන් කරනවා (හෝටලයක හෝ ගුවන් තොටුපලේදී)",
      "To register one's arrival at an airport or hotel.",
      "Passengers must check in at the airport counter two hours prior to flight.",
      "මගීන් ගුවන් ගමනට පැය දෙකකට පෙර ගුවන් තොටුපළ කවුන්ටරයෙන් පැමිණීම සටහන් කළ යුතුය."
    ),
    SpokenIdiomItem(
      "idm_96",
      "Cut down on",
      "Phrasal Verb",
      "පරිභෝජනය අඩු කරනවා",
      "To reduce the amount or consumption of something.",
      "The doctor advised him to cut down on oily deep-fried snacks.",
      "තෙල් සහිත බැදපු කෑම වර්ග ගැනීම අඩු කරන ලෙස වෛද්‍යවරයා ඔහුට උපදෙස් දුන්නේය."
    ),
    SpokenIdiomItem(
      "idm_97",
      "Fill out",
      "Phrasal Verb",
      "පෝරමයක් සම්පූර්ණ කරනවා",
      "To complete a form or document with required details.",
      "Please fill out your examination admission form accurately.",
      "කරුණාකර ඔබගේ විභාග ප්‍රවේශ පෝරමය නිවැරදිව සම්පූර්ණ කරන්න."
    ),
    SpokenIdiomItem(
      "idm_98",
      "Hold back",
      "Phrasal Verb",
      "වළක්වා ගන්නවා / පාලනය කරගන්නවා",
      "To restrain oneself from speaking, acting, or expressing feelings.",
      "Never hold back your creative ideas during brainstorming sessions.",
      "මනෝ සාකච්ඡා සැසිවලදී ඔබේ නිර්මාණශීලී අදහස් පාලනය කර සඟවා නොසිටින්න."
    ),
    SpokenIdiomItem(
      "idm_99",
      "Rule out",
      "Phrasal Verb",
      "හැකියාවක් හෝ විකල්පයක් බැහැර කරනවා",
      "To exclude a possibility or consider something unfeasible.",
      "We cannot rule out rain, so let us arrange an indoor venue.",
      "වැස්ස ඇතිවීමේ හැකියාව බැහැර කළ නොහැකි බැවින්, ගෘහස්ථ ස්ථානයක් සූදානම් කරමු."
    ),
    SpokenIdiomItem(
      "idm_100",
      "Stand for",
      "Phrasal Verb",
      "නියෝජනය කරනවා හෝ අර්ථවත් කරනවා",
      "To represent an idea, acronym, or value.",
      "What does the abbreviation UNESCO stand for?",
      "UNESCO යන කෙටි නාමය නියෝජනය කරන්නේ කුමක්ද?"
    )
  )
}
