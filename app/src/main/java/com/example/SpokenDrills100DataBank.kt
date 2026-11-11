package com.example

/**
 * 100 Spoken Quick Response Drills
 * Real-world conversational cues with 3 spoken response options, instant verification,
 * and clear Sinhala explanations for developing fluent reflex communication.
 */
data class SpokenQuickResponseItem(
  val id: String,
  val situation: String,
  val prompt: String,
  val sinhalaPrompt: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val sinhalaExplanation: String
)

object SpokenDrills100DataBank {

  val drills: List<SpokenQuickResponseItem> = listOf(
    // 1 - 25: Everyday Greetings & Social Etiquette
    SpokenQuickResponseItem(
      "qdr_1",
      "Formal Greeting",
      "\"How do you do, Mr. Silva?\"",
      "\"සිල්වා මහත්මයා, ඔබට කොහොමද?\" (ඉතා විධිමත් හමුවීමකදී)",
      listOf(
        "How do you do? Pleased to meet you.",
        "I am doing writing my homework.",
        "Yes, I do it very well."
      ),
      0,
      "විධිමත් ඉංග්‍රීසියේ 'How do you do?' යන්නට පිළිතුර වන්නේ නැවතත් 'How do you do?' හෝ 'Pleased to meet you' යන්නයි."
    ),
    SpokenQuickResponseItem(
      "qdr_2",
      "Casual Greeting",
      "\"Hey Kasun! What's up?\"",
      "\"ඒයි කසුන්! මොකද වෙන්නේ / අලුත් තොරතුරු මොනවාද?\"",
      listOf(
        "The sky is up.",
        "Not much, just heading to English class!",
        "Yes, it is up high."
      ),
      1,
      "'What's up?' යනු මිතුරන් අතර අසන සුහද විමසීමකි. ඒ සඳහා වඩාත් ස්වභාවික පිළිතුර 'Not much...' යන්නයි."
    ),
    SpokenQuickResponseItem(
      "qdr_3",
      "Responding to Thanks",
      "\"Thank you so much for helping me carry these books!\"",
      "\"මෙම පොත් රැගෙන යාමට උදව් කිරීම ගැන ඔබට බෙහෙවින් ස්තූතියි!\"",
      listOf(
        "You are welcome! Always happy to help.",
        "No, don't mention your name.",
        "Why did you thank me?"
      ),
      0,
      "ස්තූතියකට ප්‍රතිචාර දැක්වීමට 'You are welcome!' හෝ 'Glad to help!' භාවිත වේ."
    ),
    SpokenQuickResponseItem(
      "qdr_4",
      "Responding to an Apology",
      "\"I'm terribly sorry for stepping on your foot!\"",
      "\"ඔබේ පය පෑගීම ගැන මම ඉතාමත් කනගාටු වෙනවා!\"",
      listOf(
        "Never step again!",
        "That's quite alright, don't worry about it.",
        "I have two feet."
      ),
      1,
      "අනපේක්ෂිත සුළු වරදකදී සමාව අයැදින විට 'That's quite alright / No worries' යන්න ආචාරශීලී ප්‍රතිචාරයයි."
    ),
    SpokenQuickResponseItem(
      "qdr_5",
      "Offering Assistance",
      "\"Excuse me, could you give me a hand with this heavy carton?\"",
      "\"සමාවෙන්න, මෙම බර පෙට්ටිය ඔසවා ගැනීමට මට උදව්වක් කළ හැකිද?\"",
      listOf(
        "Certainly! Where would you like to place it?",
        "I have two hands.",
        "No hands today."
      ),
      0,
      "'Give me a hand' යනු 'උදව් කරන්න' යන්නයි. 'Certainly!' යනු සතුටින් උදව් කිරීමට දෙන පිළිතුරයි."
    ),
    SpokenQuickResponseItem(
      "qdr_6",
      "Inviting Someone to Tea",
      "\"Would you care to join us for a cup of Ceylon tea?\"",
      "\"අප සමඟ තේ කෝප්පයකට එකතු වීමට ඔබ කැමතිද?\"",
      listOf(
        "I would love to, thank you very much!",
        "Tea is grown in Sri Lanka.",
        "No tea cups exist."
      ),
      0,
      "ආරාධනාවක් ආචාරශීලීව පිළිගැනීමට 'I would love to, thank you!' වඩාත් සුදුසුය."
    ),
    SpokenQuickResponseItem(
      "qdr_7",
      "Declining an Invitation Politely",
      "\"Can you come to the cinema with us this evening?\"",
      "\"අද සවස අප සමඟ චිත්‍රපටයක් නැරඹීමට යාමට ඔබට පුළුවන්ද?\"",
      listOf(
        "I hate movies.",
        "I'd love to, but I have a science class to attend tonight.",
        "No, go away."
      ),
      1,
      "ආරාධනයක් කාරුණිකව ප්‍රතික්ෂේප කිරීමේදී 'I'd love to, but...' කියා හේතුව පැහැදිලි කරයි."
    ),
    SpokenQuickResponseItem(
      "qdr_8",
      "Responding to Congratulations",
      "\"Congratulations on scoring nine A grades in your exam!\"",
      "\"විභාගයෙන් A නවයක් ලබා ගැනීම පිළිබඳව සුබ පැතුම්!\"",
      listOf(
        "I know I am the best.",
        "Thank you very much! I couldn't have done it without everyone's support.",
        "Don't congratulate."
      ),
      1,
      "සුබ පැතුමකට නිහතමානීව 'Thank you very much!...' කියා ස්තූති කරයි."
    ),
    SpokenQuickResponseItem(
      "qdr_9",
      "Expressing Sympathy",
      "\"My grandfather passed away peacefully yesterday.\"",
      "\"මගේ සීයා ඊයේ නිහඬව අභාවප්‍රාප්ත විය.\"",
      listOf(
        "I am so sorry for your loss; please accept my deepest condolences.",
        "Congratulations to you.",
        "Where did he go?"
      ),
      0,
      "වියෝවකදී ශෝකය පළ කිරීමට 'I am so sorry for your loss' යොදනු ලැබේ."
    ),
    SpokenQuickResponseItem(
      "qdr_10",
      "Polite Request for Repetition",
      "\"(The speaker spoke too softly in a noisy room)\"",
      "\"කථිකයා ඝෝෂාකාරී කාමරයක ඉතා සෙමින් කතා කළ විට\"",
      listOf(
        "Speak loud now!",
        "Pardon me, could you please repeat that a little louder?",
        "I did not listen."
      ),
      1,
      "නැවත කියන ලෙස ආචාරශීලීව ඉල්ලීමට 'Pardon me, could you repeat that...?' භාවිත වේ."
    ),
    SpokenQuickResponseItem(
      "qdr_11",
      "Giving Directions",
      "\"Excuse me, is this the way to the railway station?\"",
      "\"සමාවෙන්න, දුම්රිය ස්ථානයට යන පාර මෙයද?\"",
      listOf(
        "Trains have wheels.",
        "Yes, walk straight for two hundred meters, it's on your left.",
        "Why do you want a train?"
      ),
      1,
      "මඟ පෙන්වීමේදී කෙටි පැහැදිලි උපදෙස් ලබා දිය යුතුය."
    ),
    SpokenQuickResponseItem(
      "qdr_12",
      "At a Restaurant",
      "\"Are you ready to order your dinner, sir?\"",
      "\"රාත්‍රී ආහාරය ඇනවුම් කිරීමට ඔබ සූදානම්ද, මහත්මයා?\"",
      listOf(
        "Yes, I will have the vegetable fried rice, please.",
        "I eat food at night.",
        "Food is ready."
      ),
      0,
      "ඇනවුම් කිරීමේදී 'I will have..., please' භාවිත කෙරේ."
    ),
    SpokenQuickResponseItem(
      "qdr_13",
      "Inquiring About Health",
      "\"You look tired today. Are you feeling alright?\"",
      "\"අද ඔබ වෙහෙසට පත්ව ඇති බවක් පෙනේ. ඔබට හොඳින්ද?\"",
      listOf(
        "Just a slight headache, but I'll be fine after a little rest.",
        "My eyes are open.",
        "Tiredness is a noun."
      ),
      0,
      "සෞඛ්‍යය ගැන අසන විට ස්වභාවික පිළිතුරක් ලබා දෙයි."
    ),
    SpokenQuickResponseItem(
      "qdr_14",
      "Telephone Call - Wrong Number",
      "\"Hello, is Dr. Perera available to take this call?\"",
      "\"හෙලෝ, මෙම ඇමතුම ලබා ගැනීමට වෛද්‍ය පෙරේරා සිටීද?\"",
      listOf(
        "I am not a doctor.",
        "I'm afraid you have dialed the wrong number; there is no doctor here.",
        "Hang up immediately!"
      ),
      1,
      "දුරකථන වැරදි අංකයකදී 'I'm afraid you have dialed the wrong number' ආචාරශීලී ක්‍රමයයි."
    ),
    SpokenQuickResponseItem(
      "qdr_15",
      "Responding to a Compliment",
      "\"That was a brilliant speech you delivered at the assembly!\"",
      "\"උදෑසන රැස්වීමේදී ඔබ පැවැත්වූයේ අතිවිශිෂ්ට කතාවක්!\"",
      listOf(
        "Thank you, that is very kind of you to say!",
        "Yes, I know I speak better than anyone.",
        "Speeches are boring."
      ),
      0,
      "ප්‍රශංසාවකට කාරුණිකව 'Thank you, that is very kind of you to say!' ලෙස පිළිතුරු දෙයි."
    ),
    SpokenQuickResponseItem(
      "qdr_16",
      "Asked for an Opinion",
      "\"What do you think about our new school science lab?\"",
      "\"අපගේ නව පාසල් විද්‍යාගාරය ගැන ඔබ සිතන්නේ කුමක්ද?\"",
      listOf(
        "In my opinion, it is extremely well-equipped and modern.",
        "Science is a school subject.",
        "I don't think."
      ),
      0,
      "මතයක් විමසූ විට 'In my opinion,...' හෝ 'I think...' සමඟ පිළිතුරු සපයයි."
    ),
    SpokenQuickResponseItem(
      "qdr_17",
      "Offering Something",
      "\"Would you like another slice of home-baked cake?\"",
      "\"නිවසේ සෑදූ කේක් තවත් කැබැල්ලක් ඔබ කැමතිද?\"",
      listOf(
        "No, thank you, I am quite full, but it was delicious!",
        "Throw it away.",
        "Cake has sugar."
      ),
      0,
      "ආහාර ප්‍රතික්ෂේප කිරීමේදීද රසවත් බව අගය කරමින් 'No, thank you, I am full, but it was delicious' පැවසීම සිරිතයි."
    ),
    SpokenQuickResponseItem(
      "qdr_18",
      "Borrowing an Item",
      "\"Could I borrow your ruler for a quick second?\"",
      "\"තත්පරයකට ඔබේ අඩිකෝදුව ණයට ගත හැකිද?\"",
      listOf(
        "Sure, go right ahead! Here it is.",
        "No, rulers are wooden.",
        "Measure the table."
      ),
      0,
      "අවසර දීමේදී 'Sure, go right ahead!' යොදයි."
    ),
    SpokenQuickResponseItem(
      "qdr_19",
      "Wishing Good Luck",
      "\"I have my driving license practical exam tomorrow morning.\"",
      "\"හෙට උදෑසන මගේ රියදුරු බලපත්‍ර ප්‍රායෝගික පරීක්ෂණය තිබෙනවා.\"",
      listOf(
        "Best of luck! Drive calmly and you will pass easily.",
        "Cars are fast.",
        "Licenses are plastic."
      ),
      0,
      "විභාගයකට පෙර දිරිගැන්වීමට 'Best of luck!' සුදුසුය."
    ),
    SpokenQuickResponseItem(
      "qdr_20",
      "Handling Disagreement",
      "\"I believe cricket is the only sport worth watching in Sri Lanka.\"",
      "\"ශ්‍රී ලංකාවේ නැරඹීමට වටින එකම ක්‍රීඩාව ක්‍රිකට් බව මම විශ්වාස කරමි.\"",
      listOf(
        "You are foolish.",
        "I respect your view, but volleyball and athletics are also thrilling!",
        "Stop talking."
      ),
      1,
      "ආචාරශීලීව මතභේදයක් පළ කිරීමට 'I respect your view, but...' භාවිත කරයි."
    ),
    SpokenQuickResponseItem(
      "qdr_21",
      "Meeting Someone after a Long Time",
      "\"Goodness me, Kamal! I haven't seen you in years!\"",
      "\"අනේ කමල්! මම ඔයාව වසර ගණනාවකින් දැක්කේ නැහැ!\"",
      listOf(
        "What a pleasant surprise! How have you been?",
        "Years have twelve months.",
        "Who told you that?"
      ),
      0,
      "දිගු කලකට පසු හමුවන විට 'What a pleasant surprise! How have you been?' සුදුසුය."
    ),
    SpokenQuickResponseItem(
      "qdr_22",
      "Asking Permission",
      "\"Do you mind if I open the window for some fresh air?\"",
      "\"නැවුම් වාතය සඳහා මම ජනේලය ඇරියොත් ඔබට කමක් නැද්ද?\"",
      listOf(
        "Not at all, please go ahead; it's quite warm in here.",
        "Yes, I mind because windows are glass.",
        "The wind blows."
      ),
      0,
      "'Do you mind...?' යන්නට එකඟ වීමේදී 'Not at all, go ahead' (කමක් නැත, අරින්න) යොදයි."
    ),
    SpokenQuickResponseItem(
      "qdr_23",
      "Accepting an Apology",
      "\"I apologize for being fifteen minutes late to the group study.\"",
      "\"කණ්ඩායම් පාඩමට විනාඩි පහළොවක් ප්‍රමාද වීම ගැන මම සමාව අයැදිමි.\"",
      listOf(
        "Don't worry about it; we just got started on unit three.",
        "Late people should leave.",
        "Time is money."
      ),
      0,
      "ප්‍රමාදයකදී 'Don't worry about it, we just got started' ලෙස මිත්‍රශීලීව පිළිතුරු දෙයි."
    ),
    SpokenQuickResponseItem(
      "qdr_24",
      "Offering to Pay",
      "\"Let me pay for the tea and snacks today.\"",
      "\"අද තේ සහ කෙටි කෑම වලට මට මුදල් ගෙවන්න දෙන්න.\"",
      listOf(
        "That is very generous of you, thank you so much!",
        "Money is paper.",
        "No, don't pay."
      ),
      0,
      "යමෙකු ගෙවීම භාරගන්නා විට 'That is very generous of you, thank you!' ආචාරශීලී පිළිතුරයි."
    ),
    SpokenQuickResponseItem(
      "qdr_25",
      "Parting / Saying Goodbye",
      "\"It was wonderful talking to you, but I must catch the five o'clock bus.\"",
      "\"ඔබ සමඟ කතාබස් කිරීම ඉතා ප්‍රියජනක විය, නමුත් මම පහේ බස් රථයට නැගිය යුතුය.\"",
      listOf(
        "Take care and have a safe journey back home!",
        "Buses have diesel.",
        "Goodbye forever."
      ),
      0,
      "සමුගැනීමේදී 'Take care and have a safe journey!' පවසයි."
    ),

    // 26 - 50: School, Exams & Academic Communication
    SpokenQuickResponseItem(
      "qdr_26",
      "Clarifying Class Schedule",
      "\"Do we have the English literature period before or after interval?\"",
      "\"අපට ඉංග්‍රීසි සාහිත්‍ය කාලච්ඡේදය තිබෙන්නේ විවේකයට පෙරද නැතහොත් පසුවද?\"",
      listOf(
        "It is scheduled for the period right after interval.",
        "Interval is for eating.",
        "Literature is books."
      ),
      0,
      "කාලසටහන පිළිබඳ පැහැදිලි සෘජු තොරතුරු සපයයි."
    ),
    SpokenQuickResponseItem(
      "qdr_27",
      "Teacher Inquiring About Homework",
      "\"Has everyone submitted their English grammar essays?\"",
      "\"සියලු දෙනාම තම ඉංග්‍රීසි ව්‍යාකරණ රචනා භාර දුන්නාද?\"",
      listOf(
        "Yes madam, all the exercise books are on your table.",
        "Essays have words.",
        "I wrote with a pen."
      ),
      0,
      "ගුරුතුමියට විධිමත් ලෙස 'Yes madam, all books are on your table' යයි පවසයි."
    ),
    SpokenQuickResponseItem(
      "qdr_28",
      "Encouraging a Discouraged Student",
      "\"I only scored sixty marks on the mathematics revision paper.\"",
      "\"ගණිත පුනරීක්ෂණ පත්‍රයට මට ලැබුණේ ලකුණු හැටක් පමණි.\"",
      listOf(
        "That's a solid foundation; analyze your mistakes and you will hit eighty next time!",
        "You are very weak.",
        "Sixty is a number."
      ),
      0,
      "ලකුණු අඩු වූ විට දිරිගන්වමින් ධනාත්මක උපදෙස් ලබා දිය යුතුය."
    ),
    SpokenQuickResponseItem(
      "qdr_29",
      "Inquiring About Past Papers",
      "\"Where did you find the ten-year past paper booklet?\"",
      "\"වසර දහයක පසුගිය විභාග ප්‍රශ්න පත්‍ර පොත ඔබට හමුවූයේ කොහෙන්ද?\"",
      listOf(
        "I bought it from the Sarasavi Bookshop near the town clock tower.",
        "Past papers are printed on paper.",
        "I did not buy it."
      ),
      0,
      "මිලදී ගත් ස්ථානය පිළිබඳ නිශ්චිත තොරතුරු සපයයි."
    ),
    SpokenQuickResponseItem(
      "qdr_30",
      "Asking Teacher for Permission to Leave",
      "\"Excuse me sir, may I step out to wash my hands?\"",
      "\"සමාවෙන්න සර්, අත සෝදා ගැනීමට මට මඳක් පිටතට යාමට අවසරද?\"",
      listOf(
        "Yes, be quick and return immediately.",
        "Hands have fingers.",
        "Water is in the tap."
      ),
      0,
      "ගුරුවරයෙකු අවසර දීමේදී 'Yes, be quick and return immediately' සාමාන්‍ය භාවිතයයි."
    ),
    SpokenQuickResponseItem(
      "qdr_31",
      "Inviting to Join Study Circle",
      "\"We are forming an English discussion group on WhatsApp; would you like to join?\"",
      "\"අපි WhatsApp හි ඉංග්‍රීසි සාකච්ඡා කණ්ඩායමක් හදනවා; ඔබත් එකතු වීමට කැමතිද?\"",
      listOf(
        "Yes please, here is my mobile number!",
        "WhatsApp needs an internet connection.",
        "No groups."
      ),
      0,
      "කණ්ඩායමට එකතු වීමට කැමැත්ත පළ කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_32",
      "Asking About Exam Rules",
      "\"Are digital smart watches permitted inside the examination hall?\"",
      "\"විභාග ශාලාව තුළට ඩිජිටල් ස්මාර්ට් ඔරලෝසු රැගෙන යාමට අවසර තිබේද?\"",
      listOf(
        "No, only standard analog wristwatches are strictly allowed.",
        "Watches show the time.",
        "Halls have desks."
      ),
      0,
      "විභාග නීති පිළිබඳ නිවැරදි තොරතුරු ලබා දීම."
    ),
    SpokenQuickResponseItem(
      "qdr_33",
      "Complimenting Handwriting",
      "\"Your cursive English handwriting looks remarkably neat and tidy!\"",
      "\"ඔබගේ ඉංග්‍රීසි අත්අකුරු ඉතාමත් පිළිවෙලට හා ලස්සනට තිබේ!\"",
      listOf(
        "Thank you! I practice handwriting worksheets every weekend.",
        "Handwriting is written with ink.",
        "I wrote with fingers."
      ),
      0,
      "අත්අකුරු අගය කිරීමට ස්තූති කරමින් පුහුණුව ගැන සඳහන් කරයි."
    ),
    SpokenQuickResponseItem(
      "qdr_34",
      "Sharing Classroom Stationery",
      "\"Does anyone have a spare sharpener I could borrow?\"",
      "\"ණයට ගැනීමට අමතර පැන්සල් උල්කරනයක් කා ළඟ හෝ තිබේද?\"",
      listOf(
        "Yes, here you go, you can keep it until the end of class.",
        "Sharpeners sharpen pencils.",
        "I have a pencil."
      ),
      0,
      "උපකාර කිරීමට ඉදිරිපත් වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_35",
      "Confirming Assignment Deadline",
      "\"Is the social studies assignment due this Friday or next Monday?\"",
      "\"සමාජ අධ්‍යයන පැවරුම භාරදිය යුත්තේ මේ සිකුරාදාද නැතහොත් ලබන සඳුදාද?\"",
      listOf(
        "The teacher extended the deadline until next Monday.",
        "Friday comes before Monday.",
        "Assignments are graded."
      ),
      0,
      "කල් දිගුව පිළිබඳ නිවැරදි තොරතුරු පැවසීම."
    ),
    SpokenQuickResponseItem(
      "qdr_36",
      "Discussing a Novel",
      "\"Have you read 'Oliver Twist' by Charles Dickens yet?\"",
      "\"චාල්ස් ඩිකන්ස්ගේ 'ඔලිවර් ට්විස්ට්' නවකතාව ඔබ කියවා තිබේද?\"",
      listOf(
        "Yes, it is a fascinating classic depicting Victorian society.",
        "Oliver is a boy's name.",
        "Books have pages."
      ),
      0,
      "පොතක් පිළිබඳ අදහස් බෙදාගැනීම."
    ),
    SpokenQuickResponseItem(
      "qdr_37",
      "Congratulating on Sports Victory",
      "\"Our school badminton team won the championship trophy!\"",
      "\"අප පාසල් බැඩ්මින්ටන් කණ්ඩායම ශූරතා කුසලානය දිනාගත්තා!\"",
      listOf(
        "What fantastic news! All that morning practice truly paid off!",
        "Badminton uses shuttles.",
        "Trophies are metal."
      ),
      0,
      "විශිෂ්ට ක්‍රීඩා ජයග්‍රහණයක් උද්‍යෝගයෙන් සැමරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_38",
      "Explaining a Math Step",
      "\"Why did you divide both sides of the equation by two?\"",
      "\"ඔබ සමීකරණයේ දෙපැත්තම දෙකෙන් බෙදුවේ ඇයි?\"",
      listOf(
        "To isolate the variable 'x' on the left-hand side.",
        "Two is an even number.",
        "Division is math."
      ),
      0,
      "ගණිත ක්‍රියාපටිපාටිය තර්කානුකූලව පැහැදිලි කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_39",
      "Reminding About School Uniform",
      "\"Remember that everyone must wear full white uniform tomorrow for the assembly.\"",
      "\"හෙට උදෑසන රැස්වීම සඳහා සැවොම සම්පූර්ණ සුදු නිල ඇඳුම ඇඳිය යුතු බව මතක තබා ගන්න.\"",
      listOf(
        "Thank you for the reminder; I have already ironed mine.",
        "Uniforms are white.",
        "Tomorrow is another day."
      ),
      0,
      "මතක් කිරීමට ස්තූති කරමින් සූදානම තහවුරු කරයි."
    ),
    SpokenQuickResponseItem(
      "qdr_40",
      "Prefect Giving an Instruction",
      "\"Please maintain a single file when walking to the auditorium.\"",
      "\"ශ්‍රවණාගාරයට යන විට කරුණාකර එක් පේළියකට ගමන් කරන්න.\"",
      listOf(
        "Understood, we will line up immediately.",
        "Auditoriums are large.",
        "Files are kept in cabinets."
      ),
      0,
      "විනය උපදෙසකට ගෞරවයෙන් එකඟ වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_41",
      "Asking for Teacher's Signature",
      "\"Sir, could you please sign my school progress report?\"",
      "\"සර්, කරුණාකර මගේ පාසල් ප්‍රගති වාර්තාවට අත්සන් තැබිය හැකිද?\"",
      listOf(
        "Certainly, let me see your term marks first.",
        "Signatures use blue ink.",
        "Reports show results."
      ),
      0,
      "ගුරුවරයෙකු ලේඛනයක් පරීක්ෂා කර අත්සන් කිරීමට එකඟ වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_42",
      "Discussing Science Exhibition Project",
      "\"Our working model on solar irrigation is ready for the exhibition.\"",
      "\"සූර්ය බලශක්ති වාරිමාර්ග ක්‍රමය පිළිබඳ අපගේ ක්‍රියාකාරී ආකෘතිය ප්‍රදර්ශනයට සූදානම්.\"",
      listOf(
        "Brilliant! The judges will be thoroughly impressed by this eco-friendly initiative.",
        "The sun shines brightly.",
        "Exhibitions have visitors."
      ),
      0,
      "විද්‍යා ප්‍රදර්ශන ආකෘතියක් අගය කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_43",
      "Helping a Confused Junior Student",
      "\"Excuse me brother, where is the Grade 6 block located?\"",
      "\"සමාවෙන්න අයියේ, 6 ශ්‍රේණියේ ගොඩනැගිල්ල පිහිටා ඇත්තේ කොහේද?\"",
      listOf(
        "Walk past the main shrine room, it is the two-story building on your right.",
        "Grade 6 is for children.",
        "Buildings have walls."
      ),
      0,
      "කනිෂ්ඨ සිසුවෙකුට සුහදව මඟ පෙන්වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_44",
      "Declining to Share Cheating Material",
      "\"Can you pass me your answer sheet during the quiz?\"",
      "\"පරීක්ෂණය අතරතුර ඔබේ පිළිතුරු පත්‍රය මට දිය හැකිද?\"",
      listOf(
        "I'm sorry, I cannot do that; cheating will get us both disqualified.",
        "Cheating is fun.",
        "Sheets are white."
      ),
      0,
      "විභාග වංචාව ප්‍රතික්ෂේප කිරීමේ නිවැරදි සදාචාරාත්මක පිළිතුර."
    ),
    SpokenQuickResponseItem(
      "qdr_45",
      "Organizing School Drama Rehearsal",
      "\"What time does the English drama rehearsal begin today?\"",
      "\"අද ඉංග්‍රීසි නාට්‍ය පුහුණුව ආරම්භ වන්නේ කුමන වේලාවටද?\"",
      listOf(
        "At three o'clock in the main auditorium stage.",
        "Dramas have actors.",
        "Clocks tick."
      ),
      0,
      "වේලාව සහ ස්ථානය නිශ්චිතව පැවසීම."
    ),
    SpokenQuickResponseItem(
      "qdr_46",
      "Praising a Classmate's Essay",
      "\"Your descriptive essay about the village harvest festival was captivating!\"",
      "\"ගමේ අස්වනු මංගල්‍යය පිළිබඳ ඔබේ විස්තරාත්මක රචනය අතිශයින් ආකර්ෂණීය විය!\"",
      listOf(
        "Thank you so much! I tried to describe the sights and scents vividly.",
        "Festivals have food.",
        "Essays are long."
      ),
      0,
      "රචනයක් පිළිබඳ ප්‍රශංසාවක් කාරුණිකව භාරගැනීම."
    ),
    SpokenQuickResponseItem(
      "qdr_47",
      "Confirming Lab Safety Rules",
      "\"Should we turn off the gas valve after heating the test tube?\"",
      "\"පරීක්ෂණ නළය රත් කිරීමෙන් පසු ගෑස් කරාමය වසා දැමිය යුතුද?\"",
      listOf(
        "Yes, immediately! Safety is our first priority in the chemistry lab.",
        "Gas has a smell.",
        "Tubes are glass."
      ),
      0,
      "විද්‍යාගාර ආරක්ෂක පියවර තහවුරු කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_48",
      "Lending a School Tie",
      "\"I forgot my school tie at home; does anyone have an extra one?\"",
      "\"මගේ පාසල් ටයි පටිය ගෙදර අමතක වුණා; අමතර එකක් කා ළඟ හෝ තිබේද?\"",
      listOf(
        "I have a clean spare one in my locker; let me fetch it for you.",
        "Ties are worn around the neck.",
        "I wear a tie."
      ),
      0,
      "හදිසි අවශ්‍යතාවයකදී උදව් කිරීමට ඉදිරිපත් වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_49",
      "Congratulating a New Prefect",
      "\"I heard you were badged as a senior school prefect today!\"",
      "\"අද ඔබව ජ්‍යෙෂ්ඨ පාසල් ශිෂ්‍ය නායකයෙකු ලෙස පදක්කම් පැළඳවූ බව මට ආරංචි විය!\"",
      listOf(
        "Thank you! It is a great honor and a heavy responsibility.",
        "Badges are pinned.",
        "Prefects have badges."
      ),
      0,
      "තනතුරක් ලැබූ විට ගෞරවය සහ වගකීම පිළිගැනීම."
    ),
    SpokenQuickResponseItem(
      "qdr_50",
      "Encouraging Daily Reading Habit",
      "\"How did you expand your English vocabulary so rapidly?\"",
      "\"ඔබේ ඉංග්‍රීසි වචන මාලාව මෙතරම් වේගයෙන් දියුණු කරගත්තේ කෙසේද?\"",
      listOf(
        "By reading English newspapers and noting down ten new words every single day.",
        "Words are in dictionaries.",
        "English is a language."
      ),
      0,
      "භාෂා ප්‍රවීණතාවය ලබාගත් සැබෑ ක්‍රමය පැහැදිලි කිරීම."
    ),

    // 51 - 75: Travel, Public Places & Transactions
    SpokenQuickResponseItem(
      "qdr_51",
      "At the Train Ticket Counter",
      "\"Second class or third class to Anuradhapura, sir?\"",
      "\"අනුරාධපුරයට දෙවන පන්තියද නැතහොත් තුන්වන පන්තියද, මහත්මයා?\"",
      listOf(
        "Two second-class tickets, please.",
        "Anuradhapura is an ancient city.",
        "Trains run on rails."
      ),
      0,
      "ප්‍රවේශ පත්‍ර මිලදී ගැනීමේ සෘජු ප්‍රකාශනය."
    ),
    SpokenQuickResponseItem(
      "qdr_52",
      "Airport Check-in",
      "\"Do you have any liquids or sharp items in your hand luggage?\"",
      "\"ඔබගේ අත් බෑගයේ දියර වර්ග හෝ තියුණු උපකරණ තිබේද?\"",
      listOf(
        "No, none at all; only books and my laptop.",
        "Liquids are wet.",
        "Luggage is heavy."
      ),
      0,
      "ගුවන් තොටුපළ පරීක්ෂාවේදී පැහැදිලි සත්‍ය තොරතුරු ලබා දීම."
    ),
    SpokenQuickResponseItem(
      "qdr_53",
      "Hiring a Taxi",
      "\"Where would you like to be dropped off?\"",
      "\"ඔබව බස්සවන්න ඕනේ කොතැනටද?\"",
      listOf(
        "Please drop me off opposite the General Post Office.",
        "Taxis drive on roads.",
        "I have bags."
      ),
      0,
      "ගමනාන්තය නිශ්චිතව පැවසීම."
    ),
    SpokenQuickResponseItem(
      "qdr_54",
      "Asking Bus Conductor for Change",
      "\"I gave you a thousand rupee note for a two-hundred rupee fare.\"",
      "\"රුපියල් දෙසීයක ගාස්තුවට මම ඔබට රුපියල් දහසේ නෝට්ටුවක් දුන්නා.\"",
      listOf(
        "Yes, here is your ticket and eight hundred rupees balance.",
        "Money is money.",
        "Buses have doors."
      ),
      0,
      "ඉතිරි මුදල් නිවැරදිව ලබා දීම."
    ),
    SpokenQuickResponseItem(
      "qdr_55",
      "Hotel Room Service",
      "\"Good evening, room service. How may I be of service?\"",
      "\"සුබ සන්ධ්‍යාවක්, රූම් සර්විස්. මම ඔබට කෙසේ උපකාර කරන්නද?\"",
      listOf(
        "Could we have two bottles of drinking water brought to room 302, please?",
        "Rooms have beds.",
        "I am staying here."
      ),
      0,
      "කාමර සේවාවෙන් කාරුණිකව ඉල්ලීමක් කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_56",
      "Bank Cashier Inquiry",
      "\"Are you depositing cash or drawing a cheque today?\"",
      "\"අද ඔබ මුදල් තැන්පත් කරනවාද නැතහොත් චෙක්පතක් මාරු කරනවාද?\"",
      listOf(
        "I would like to deposit twenty thousand rupees into my savings account.",
        "Banks have vaults.",
        "Money is deposited."
      ),
      0,
      "බැංකු ගනුදෙනුව පැහැදිලි කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_57",
      "Lost in an unfamiliar street",
      "\"Excuse me, does this road lead towards the Colombo harbor?\"",
      "\"සමාවෙන්න, මෙම මාර්ගය කොළඹ වරාය දෙසට යනවාද?\"",
      listOf(
        "Yes, continue straight ahead for two traffic lights.",
        "Harbors have ships.",
        "Roads are paved."
      ),
      0,
      "මඟ පෙන්වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_58",
      "Buying Fruit from a Stall",
      "\"These ripe mangoes are very sweet today! Would you like a kilo?\"",
      "\"මෙම ඉදුණු අඹ අද ඉතා පැණි රසයි! කිලෝවක් ගන්න කැමතිද?\"",
      listOf(
        "Yes, please weigh out one kilo of the best ones.",
        "Mangoes grow on trees.",
        "Fruit has vitamins."
      ),
      0,
      "පලතුරු මිලදී ගැනීම තහවුරු කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_59",
      "Returning a Defective Item",
      "\"The headphones I bought yesterday have no audio on the left side.\"",
      "\"මම ඊයේ මිලදී ගත් හෙඩ්ෆෝන් එකේ වම් පැත්තේ ශබ්දය ඇසෙන්නේ නැත.\"",
      listOf(
        "I am so sorry about that; let me test it and replace it with a brand new unit.",
        "Headphones have cords.",
        "Sound travels in waves."
      ),
      0,
      "වෙළඳසැල් සේවකයෙකු දෝෂ සහිත භාණ්ඩයක් මාරු කිරීමට එකඟ වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_60",
      "Asking About Shop Opening Hours",
      "\"What time does your bookstore close this evening?\"",
      "\"අද සවස ඔබේ පොත්හල වසන්නේ කුමන වේලාවටද?\"",
      listOf(
        "We are open until eight o'clock tonight.",
        "Bookstores sell books.",
        "Clocks tell time."
      ),
      0,
      "වෙළඳසැල වසන වේලාව පැවසීම."
    ),
    SpokenQuickResponseItem(
      "qdr_61",
      "Supermarket Checkout",
      "\"Would you like a fabric reusable shopping bag for twenty rupees?\"",
      "\"රුපියල් විස්සකට නැවත භාවිත කළ හැකි රෙදි බෑගයක් ගැනීමට ඔබ කැමතිද?\"",
      listOf(
        "Yes please, I want to avoid using single-use polythene.",
        "Bags carry items.",
        "Money buys bags."
      ),
      0,
      "පරිසර හිතකාමී බෑගයක් පිළිගැනීම."
    ),
    SpokenQuickResponseItem(
      "qdr_62",
      "Asking for WiFi Password",
      "\"Excuse me, what is the WiFi password for customers here?\"",
      "\"සමාවෙන්න, මෙහි පාරිභෝගිකයින් සඳහා WiFi මුරපදය කුමක්ද?\"",
      listOf(
        "It is printed at the bottom of your receipt, all in lowercase.",
        "WiFi is wireless.",
        "Passwords have letters."
      ),
      0,
      "WiFi මුරපදය සොයාගන්නා ආකාරය පැවසීම."
    ),
    SpokenQuickResponseItem(
      "qdr_63",
      "Waiting for Food at a Cafe",
      "\"We apologize for the slight delay with your soup; it will arrive in two minutes.\"",
      "\"ඔබගේ සුප් එක ප්‍රමාද වීම ගැන සමාවෙන්න; තව මිනිත්තු දෙකකින් එය ගෙන එනු ඇත.\"",
      listOf(
        "No problem at all, take your time.",
        "Soup is hot liquid.",
        "Clocks have minutes."
      ),
      0,
      "ඉවසීමෙන් සුහදව පිළිතුරු දීම."
    ),
    SpokenQuickResponseItem(
      "qdr_64",
      "Asking for Bill Breakdown",
      "\"Could you please explain this additional charge on the invoice?\"",
      "\"ඉන්වොයිසියේ ඇති මෙම අමතර ගාස්තුව පැහැදිලි කළ හැකිද?\"",
      listOf(
        "Certainly, that is the standard government value-added tax of ten percent.",
        "Bills have numbers.",
        "Invoices are papers."
      ),
      0,
      "බිල්පතේ විස්තර ආචාරශීලීව පැහැදිලි කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_65",
      "Pedestrian Traffic Safety",
      "\"Sir, please use the overhead footbridge to cross this expressway.\"",
      "\"මහත්මයා, මෙම අධිවේගී මාවත මාරුවීමට කරුණාකර ගුවන් පාලම භාවිත කරන්න.\"",
      listOf(
        "Thank you officer, I will cross safely using the footbridge.",
        "Footbridges are concrete.",
        "Expressways have cars."
      ),
      0,
      "මාර්ග ආරක්ෂණ උපදෙස පිළිගැනීම."
    ),
    SpokenQuickResponseItem(
      "qdr_66",
      "Confirming Pharmacy Prescription",
      "\"Do you have the original doctor's prescription for these antibiotics?\"",
      "\"මෙම ප්‍රතිජීවක ඖෂධ සඳහා මුල් වෛද්‍ය නිර්දේශ පත්‍රිකාව ඔබ සතුව තිබේද?\"",
      listOf(
        "Yes, here is the doctor's prescription signed yesterday.",
        "Antibiotics fight bacteria.",
        "Doctors write prescriptions."
      ),
      0,
      "බෙහෙත් වට්ටෝරුව ඉදිරිපත් කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_67",
      "Asking for Low Sugar Drink",
      "\"Could you make my avocado smoothie with less sugar, please?\"",
      "\"මගේ අලිගැටපේර ස්මූති එක සීනි අඩුවෙන් සාදා දිය හැකිද?\"",
      listOf(
        "Sure thing, I will add only a dash of pure bee honey instead.",
        "Sugar is sweet.",
        "Smoothies are blended."
      ),
      0,
      "පාරිභෝගික රුචිකත්වය ඉටු කිරීමට එකඟ වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_68",
      "Gas Station Attendant",
      "\"How much petrol should I pump into your motorcycle?\"",
      "\"ඔබේ යතුරුපැදියට කොපමණ මුදලක පෙට්‍රල් ගහන්නද?\"",
      listOf(
        "Two thousand rupees of Octane 92, please.",
        "Petrol fuels engines.",
        "Tanks hold liquids."
      ),
      0,
      "ඉන්ධන ප්‍රමාණය නිශ්චිතව පැවසීම."
    ),
    SpokenQuickResponseItem(
      "qdr_69",
      "Post Office Parcel Postage",
      "\"I would like to send this parcel by registered post to Jaffna.\"",
      "\"ලියාපදිංචි තැපෑලෙන් මෙම පාර්සලය යාපනයට යැවීමට කැමැත්තෙමි.\"",
      listOf(
        "Please place it on the digital scale to check its weight.",
        "Parcels are wrapped.",
        "Post offices have stamps."
      ),
      0,
      "තැපැල් කාර්යාලයේදී පාර්සලය කිරා බැලීමට උපදෙස් දීම."
    ),
    SpokenQuickResponseItem(
      "qdr_70",
      "Expressing Delight with Customer Service",
      "\"Here is your repaired laptop, fully cleaned and working perfectly.\"",
      "\"මෙන්න ඔබගේ අලුත්වැඩියා කළ ලැප්ටොප් පරිගණකය, සම්පූර්ණයෙන්ම පිරිසිදු කර හොඳින් ක්‍රියාත්මක වේ.\"",
      listOf(
        "Thank you so much! Your technical service is truly outstanding.",
        "Laptops have screens.",
        "Keyboards have keys."
      ),
      0,
      "විශිෂ්ට සේවය අගය කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_71",
      "Confirming Reservation Time",
      "\"We have a dinner table reserved under the name Perera for seven-thirty.\"",
      "\"හතයි තිහට පෙරේරා නමින් වෙන්කළ රාත්‍රී ආහාර මේසයක් අප සතුව ඇත.\"",
      listOf(
        "Welcome Mr. Perera, please follow me right to your reserved table.",
        "Seven-thirty is time.",
        "Tables have chairs."
      ),
      0,
      "ආපනශාලාවේදී අමුත්තන් පිළිගැනීම."
    ),
    SpokenQuickResponseItem(
      "qdr_72",
      "Lost Child in a Fair",
      "\"Don't cry, little one. Tell me your name and we will find your mother.\"",
      "\"අඬන්න එපා පැටියෝ. ඔයාගේ නම කියන්න, අපි අම්මාව හොයාගමු.\"",
      listOf(
        "My name is Sandun and my mother was near the flower stall.",
        "Fairgrounds have rides.",
        "Crying makes tears."
      ),
      0,
      "නම සහ මව සිටි ස්ථානය පැවසීම."
    ),
    SpokenQuickResponseItem(
      "qdr_73",
      "Cinema Seat Finding",
      "\"Pardon me, I think you might be sitting in my assigned seat, row D number 8.\"",
      "\"සමාවෙන්න, මට වෙන්කළ D පේළියේ අංක 8 ආසනයේ ඔබ වාඩිවී සිටිනවා වගෙයි.\"",
      listOf(
        "Oh, let me check my ticket. You are quite right, my apologies!",
        "Cinemas show movies.",
        "Seats are numbered."
      ),
      0,
      "වරද පිළිගෙන ආසනය නිවැරදි කරගැනීම."
    ),
    SpokenQuickResponseItem(
      "qdr_74",
      "Tourist Asking About Local Tea",
      "\"Which tea grade is best for a strong morning milk tea?\"",
      "\"උදෑසන උකු කිරි තේ එකක් සඳහා වඩාත්ම සුදුසු තේ වර්ගය කුමක්ද?\"",
      listOf(
        "BOPF (Broken Orange Pekoe Fannings) produces a rich, brisk brew.",
        "Tea has leaves.",
        "Milk is white."
      ),
      0,
      "දේශීය තේ පිළිබඳ වටිනා තොරතුරු සැපයීම."
    ),
    SpokenQuickResponseItem(
      "qdr_75",
      "Asking for Feedback on Food",
      "\"How did you enjoy your traditional rice and curry meal today?\"",
      "\"අද ඔබගේ සාම්ප්‍රදායික බත් සහ ව්‍යංජන ආහාර වේල රසවත්ද?\"",
      listOf(
        "It was genuinely authentic and flavorful, particularly the dhal curry!",
        "Curry has spices.",
        "Rice is grain."
      ),
      0,
      "ආහාර වේල පිළිබඳ සවිස්තරාත්මක ප්‍රශංසාවක් ලබා දීම."
    ),

    // 76 - 100: Professional, Digital & Future Careers
    SpokenQuickResponseItem(
      "qdr_76",
      "Job Interview Opener",
      "\"Why should our company hire you for this software developer role?\"",
      "\"මෙම මෘදුකාංග සංවර්ධක තනතුර සඳහා අපේ සමාගම ඔබව බඳවා ගත යුත්තේ ඇයි?\"",
      listOf(
        "Because I combine strong technical skills in Kotlin with a dedication to problem solving.",
        "Because I need a job.",
        "Software is code."
      ),
      0,
      "සම්මුඛ පරීක්ෂණයකදී තම කුසලතා සහ කැපවීම විශ්වාසයෙන් ප්‍රකාශ කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_77",
      "Zoom Meeting Sound Check",
      "\"Can everyone in the meeting hear my microphone clearly?\"",
      "\"රැස්වීමේ සිටින සැමට මගේ මයික්‍රෆෝනය පැහැදිලිව ඇසෙනවාද?\"",
      listOf(
        "Yes, we can hear you loud and clear!",
        "Microphones pick up sound.",
        "Zoom is an app."
      ),
      0,
      "මාර්ගගත හඬ පරීක්ෂාවට ස්වභාවික ක්ෂණික පිළිතුර 'Loud and clear!' යන්නයි."
    ),
    SpokenQuickResponseItem(
      "qdr_78",
      "Handling a Technical Glitch",
      "\"My slides seem to have frozen; please give me one moment to reload.\"",
      "\"මගේ ස්ලයිඩ සිරවී ඇති බව පෙනේ; නැවත විවෘත කිරීමට මට මොහොතක් දෙන්න.\"",
      listOf(
        "Take your time, we will wait patiently.",
        "Computers freeze in winter.",
        "Slides are PowerPoint."
      ),
      0,
      "තාක්ෂණික දෝෂයකදී ඉවසීමෙන් සහයෝගය දැක්වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_79",
      "Clarifying Work Duties",
      "\"Are you clear about the deliverables expected for the first milestone?\"",
      "\"පළමු අදියර සඳහා බලාපොරොත්තු වන ප්‍රතිඵල පිළිබඳව ඔබට පැහැදිලිද?\"",
      listOf(
        "Yes, I will submit the wireframes and user flow diagram by Thursday.",
        "Milestones are stones.",
        "Duties are work."
      ),
      0,
      "වගකීම් පැහැදිලි බව නිශ්චිතව තහවුරු කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_80",
      "Expressing Interest in Tech",
      "\"Have you started learning artificial intelligence and prompt engineering?\"",
      "\"ඔබ කෘත්‍රිම බුද්ධිය සහ Prompt Engineering හැදෑරීම ආරම්භ කළාද?\"",
      listOf(
        "Yes, I practice building AI apps using Kotlin and Gemini API every week.",
        "AI stands for artificial intelligence.",
        "Prompt means quick."
      ),
      0,
      "තාක්ෂණික ඉගෙනුම් ප්‍රගතිය බෙදාගැනීම."
    ),
    SpokenQuickResponseItem(
      "qdr_81",
      "Discussing Deadline Flexibility",
      "\"Would you be able to deliver the completed report a day ahead of schedule?\"",
      "\"නියමිත කාලයට දිනකට පෙර සම්පූර්ණ කළ වාර්තාව භාරදීමට ඔබට හැකිද?\"",
      listOf(
        "Yes, if I prioritize it today, I can have it ready for you by tomorrow noon.",
        "Schedules have dates.",
        "Reports are typed."
      ),
      0,
      "කඩිසරභාවය සහ විශ්වසනීයත්වය විදහා දැක්වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_82",
      "Responding to Client Feedback",
      "\"We love the modern color palette, but could the font size be increased?\"",
      "\"අපි මෙම නවීන වර්ණවලට කැමතියි, නමුත් අකුරු ප්‍රමාණය මඳක් විශාල කළ හැකිද?\"",
      listOf(
        "Certainly! I will adjust the typography scale right away to ensure readability.",
        "Fonts have names.",
        "Colors have shades."
      ),
      0,
      "සේවාදායක ප්‍රතිචාර වහාම ක්‍රියාත්මක කිරීමට එකඟ වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_83",
      "Team Brainstorming Meeting",
      "\"Does anyone have an innovative idea to boost user retention on our app?\"",
      "\"අපගේ යෙදුමේ පරිශීලකයින් රඳවා තබා ගැනීම ඉහළ නැංවීමට නව අදහසක් කා ළඟ හෝ තිබේද?\"",
      listOf(
        "We could introduce daily streak rewards and interactive mini-quizzes.",
        "Users use apps.",
        "Retention is keeping."
      ),
      0,
      "නිර්මාණශීලී විසඳුමක් ඉදිරිපත් කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_84",
      "Asking for Project Sign-off",
      "\"Has the final security audit passed all the required compliance tests?\"",
      "\"අවසන් ආරක්ෂණ විගණනය අවශ්‍ය සියලුම අනුකූලතා පරීක්ෂණ සමත් වී තිබේද?\"",
      listOf(
        "Yes, all vulnerability scans returned zero critical issues.",
        "Audits are checks.",
        "Security is safety."
      ),
      0,
      "තාක්ෂණික ආරක්ෂාව තහවුරු කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_85",
      "Professional Greeting on LinkedIn",
      "\"Thank you for connecting with me on LinkedIn!\"",
      "\"LinkedIn හි මා සමඟ සම්බන්ධ වීම ගැන ඔබට ස්තූතියි!\"",
      listOf(
        "It's a pleasure to connect! I look forward to following your insightful industry updates.",
        "LinkedIn is a website.",
        "Connections are links."
      ),
      0,
      "වෘත්තීය ජාලකරණයේ ආචාරශීලී ප්‍රතිචාරය."
    ),
    SpokenQuickResponseItem(
      "qdr_86",
      "Networking at a Tech Conference",
      "\"What brings you to the National Youth Technology Summit this year?\"",
      "\"මේ වසරේ ජාතික යොවුන් තාක්ෂණ සමුළුවට ඔබව රැගෙන ආවේ කුමක්ද?\"",
      listOf(
        "I am keen to discover new developments in mobile AI and connect with fellow developers.",
        "Summits are on mountains.",
        "Youth means young people."
      ),
      0,
      "සමුළුවට සහභාගී වීමේ අරමුණ පැහැදිලි කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_87",
      "Encouraging a Colleague Under Pressure",
      "\"I have two major client deadlines clashing on the same day!\"",
      "\"එකම දිනක ප්‍රධාන සේවාදායක අවසන් දින දෙකක් ගැටෙනවා!\"",
      listOf(
        "Take a deep breath; let me take care of the documentation while you finish the code.",
        "Deadlines are strict.",
        "Clients pay bills."
      ),
      0,
      "සගයෙකුට සැබෑ උපකාරයක් පිරිනැමීම."
    ),
    SpokenQuickResponseItem(
      "qdr_88",
      "Discussing Work from Home",
      "\"Do you find remote working more productive than commuting to an office?\"",
      "\"කාර්යාලයට ගමන් කිරීමට වඩා දුරස්ථව සේවය කිරීම ඵලදායී බව ඔබට හැඟෙනවාද?\"",
      listOf(
        "Yes, it saves two hours of travel each day and lets me focus deeply.",
        "Remotes have batteries.",
        "Offices have desks."
      ),
      0,
      "දුරස්ථ සේවයේ වාසි පැහැදිලි කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_89",
      "Inquiring About Code Review",
      "\"Have you had a chance to review my pull request on GitHub?\"",
      "\"GitHub හි මගේ Pull Request එක බැලීමට ඔබට අවස්ථාවක් ලැබුණාද?\"",
      listOf(
        "Yes, I reviewed it and left a few minor comments; overall it looks fantastic!",
        "Git is version control.",
        "Requests are asks."
      ),
      0,
      "කේත සමාලෝචනය පිළිබඳ ධනාත්මක ප්‍රතිචාරය."
    ),
    SpokenQuickResponseItem(
      "qdr_90",
      "Confirming Interview Time",
      "\"We would like to invite you for a virtual interview this Friday at 10:00 AM.\"",
      "\"මේ සිකුරාදා උදෑසන 10:00 ට මාර්ගගත සම්මුඛ පරීක්ෂණයකට ඔබට ආරාධනා කිරීමට අපි කැමැත්තෙමු.\"",
      listOf(
        "Thank you! I confirm that time and look forward to speaking with the team.",
        "Fridays end the week.",
        "Interviews ask questions."
      ),
      0,
      "සම්මුඛ පරීක්ෂණ වේලාව ස්තුතිපූර්වකව තහවුරු කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_91",
      "Discussing Cyber Safety",
      "\"Why is two-factor authentication so important for our accounts?\"",
      "\"අපගේ ගිණුම් සඳහා ද්වි-සාධක සත්‍යාපනය (2FA) මෙතරම් වැදගත් වන්නේ ඇයි?\"",
      listOf(
        "Because it prevents unauthorized access even if your password gets compromised.",
        "Two is greater than one.",
        "Accounts have usernames."
      ),
      0,
      "සයිබර් ආරක්ෂාව පිළිබඳ තර්කානුකූල පැහැදිලි කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_92",
      "Asking for Recommendation Letter",
      "\"Sir, could you kindly write a recommendation letter for my university application?\"",
      "\"සර්, මගේ විශ්වවිද්‍යාල අයදුම්පත සඳහා නිර්දේශ ලිපියක් කරුණාකර ලියා දිය හැකිද?\"",
      listOf(
        "I would be delighted to do so; please email me your updated CV and course details.",
        "Letters are delivered.",
        "Universities grant degrees."
      ),
      0,
      "නිර්දේශ ලිපියක් ලබාදීමට සතුටින් එකඟ වීම."
    ),
    SpokenQuickResponseItem(
      "qdr_93",
      "Appreciating Public Speaker",
      "\"Thank you for attending today's workshop on effective communication.\"",
      "\"ඵලදායී සන්නිවේදනය පිළිබඳ අද වැඩමුළුවට සහභාගී වීම ගැන ඔබට ස්තූතියි.\"",
      listOf(
        "Thank you! Your practical examples made the concepts easy to grasp and apply.",
        "Workshops have tools.",
        "Communication is talking."
      ),
      0,
      "දේශකයාගේ උත්සාහය අගය කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_94",
      "Congratulating on Promotion",
      "\"I just saw the company newsletter announcing your promotion to Senior Lead!\"",
      "\"ඔබව ජ්‍යෙෂ්ඨ ප්‍රධානී තනතුරට උසස් කළ බව සමාගමේ ප්‍රවෘත්ති සංග්‍රහයෙන් මම දුටුවෙමි!\"",
      listOf(
        "Thank you sincerely! I am excited to take on these new leadership responsibilities.",
        "Newsletters are printed.",
        "Promotions go up."
      ),
      0,
      "උසස්වීමක් පිළිබඳ සුබ පැතුමකට ස්තූති කරමින් ඉදිරි බලාපොරොත්තු පැවසීම."
    ),
    SpokenQuickResponseItem(
      "qdr_95",
      "Discussing Renewable Energy",
      "\"Do you think rooftop solar panels are viable for middle-income households?\"",
      "\"මධ්‍යම ආදායම්ලාභී නිවාස සඳහා වහල මත සූර්ය පැනල ප්‍රායෝගික යැයි ඔබ සිතනවාද?\"",
      listOf(
        "Yes, with net-metering schemes, the initial investment pays for itself within four years.",
        "Sunlight is bright.",
        "Panels are flat."
      ),
      0,
      "පුනර්ජනනීය බලශක්තිය පිළිබඳ ආර්ථික දෘෂ්ටියක් ඉදිරිපත් කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_96",
      "Inquiring About Internship",
      "\"Does your engineering firm offer summer internships for high school graduates?\"",
      "\"උසස් පෙළ නිමකළ සිසුන් සඳහා ඔබේ ඉංජිනේරු ආයතනය පුහුණු අවස්ථා (Internships) සපයනවාද?\"",
      listOf(
        "Yes, our annual technical mentorship program opens applications every January.",
        "Summer is warm.",
        "Interns are learners."
      ),
      0,
      "පුහුණු අවස්ථා පිළිබඳ තොරතුරු සැපයීම."
    ),
    SpokenQuickResponseItem(
      "qdr_97",
      "Pitching a Startup Concept",
      "\"In one sentence, how does your educational platform help Sri Lankan children?\"",
      "\"එක් වාක්‍යයකින්, ඔබේ අධ්‍යාපනික වේදිකාව ශ්‍රී ලාංකික දරුවන්ට උදව් කරන්නේ කෙසේද?\"",
      listOf(
        "It provides equal, high-quality bilingual study tools to every student in Sri Lanka free of charge.",
        "Startups make money.",
        "Sentences have full stops."
      ),
      0,
      "ආයතනික දැක්ම පැහැදිලිව හා ආකර්ෂණීය ලෙස ප්‍රකාශ කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_98",
      "Handling Criticism on Project Bug",
      "\"There seems to be an issue where the voice recognition button freezes occasionally.\"",
      "\"කටහඬ හඳුනාගැනීමේ බොත්තම විටින් විට සිරවීමේ ගැටලුවක් පවතින බව පෙනේ.\"",
      listOf(
        "Thank you for catching that; our team will optimize the threading and release an update today.",
        "Bugs are insects.",
        "Buttons are clicked."
      ),
      0,
      "තාක්ෂණික දෝෂයක් හඳුනාගැනීම ගැන ස්තූති කර ක්ෂණික විසඳුම ලබාදීම."
    ),
    SpokenQuickResponseItem(
      "qdr_99",
      "Wishing Success in Future Career",
      "\"I wish you the very greatest success as you embark on your medical career!\"",
      "\"ඔබ ඔබේ වෛද්‍ය වෘත්තිය ආරම්භ කරන විට මම ඔබට ඉමහත් සාර්ථකත්වයක් ප්‍රාර්ථනා කරමි!\"",
      listOf(
        "Thank you deeply! I promise to serve my patients with utmost devotion and empathy.",
        "Doctors cure diseases.",
        "Success is good."
      ),
      0,
      "අනාගත වෘත්තීය ප්‍රාර්ථනාවට හදවතින්ම ස්තූති කිරීම."
    ),
    SpokenQuickResponseItem(
      "qdr_100",
      "Final Inspirational Pledge",
      "\"Let us work together to make our island nation prosperous, educated, and proud!\"",
      "\"අපගේ දිවයින සෞභාග්‍යමත්, උගත් සහ අභිමානවත් දේශයක් බවට පත්කිරීමට අපි සැවොම එක්ව වැඩ කරමු!\"",
      listOf(
        "Together we definitely can, through knowledge, discipline, and unity!",
        "Islands are surrounded by water.",
        "Pledges are promises."
      ),
      0,
      "දැනුම, විනය සහ සමගියෙන් එක්ව රට නගාසිටුවීමට අධිෂ්ඨාන සහගතව ප්‍රතිචාර දැක්වීම."
    )
  )
}
