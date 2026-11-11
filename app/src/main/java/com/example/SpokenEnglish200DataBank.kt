package com.example

/**
 * 200 Spoken English Practice Sentences
 * High-frequency real-world conversational sentences with phonetics, Sinhala translations,
 * categories, and difficulty levels for Sri Lankan O/L and secondary school students.
 */
object SpokenEnglish200DataBank {

  val categories = listOf(
    "සියල්ල (All 200)",
    "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)",
    "පාසල & විභාග (School & O/L Studies)",
    "ආචාරශීලී ඉල්ලීම් (Polite Requests)",
    "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)",
    "සාප්පු සවාරි & මුදල් (Shopping & Prices)",
    "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)",
    "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)",
    "හැඟීම් & ස්තූතිය (Feelings & Gratitude)",
    "ආහාර & ආපනශාලා (Dining & Food)",
    "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
  )

  val sentences: List<SpokenSentencePractice> = listOf(
    // -------------------------------------------------------------
    // CATEGORY 1: තමා හඳුන්වා දීම & දින චර්යාව (1 - 20)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_1",
      "Good morning, my name is Kasun and I study in Grade 11.",
      "/ɡʊd ˈmɔːnɪŋ maɪ neɪm ɪz kəˈsuːn ænd aɪ ˈstʌdi ɪn ɡreɪd ɪˈlɛvən/",
      "සුබ උදෑසනක්, මගේ නම කසුන් සහ මම 11 ශ්‍රේණියේ ඉගෙනුම ලබමි.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_2",
      "I live with my family in Kandy, which is a historic city.",
      "/aɪ lɪv wɪð maɪ ˈfæmɪli ɪn ˈkændi wɪtʃ ɪz ə hɪˈstɒrɪk ˈsɪti/",
      "මම මගේ පවුලේ අය සමඟ ඓතිහාසික නගරයක් වන මහනුවර ජීවත් වෙමි.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_3",
      "I usually wake up at five in the morning to revise my notes.",
      "/aɪ ˈjuːʒuəli weɪk ʌp æt faɪv ɪn ðə ˈmɔːnɪŋ tuː rɪˈvaɪz maɪ noʊts/",
      "මගේ සටහන් නැවත බැලීමට මම සාමාන්‍යයෙන් උදෑසන පහට අවදි වෙමි.",
      "Intermediate",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_4",
      "It is a pleasure to meet you after such a long time.",
      "/ɪt ɪz ə ˈplɛʒər tuː miːt juː ˈɑːftər sʌtʃ ə lɒŋ taɪm/",
      "මෙතරම් දිගු කලකට පසු ඔබව හමුවීම මහත් සතුටකි.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_5",
      "In my free time, I enjoy reading English storybooks and playing cricket.",
      "/ɪn maɪ friː taɪm aɪ ɪnˈdʒɔɪ ˈriːdɪŋ ˈɪŋɡlɪʃ ˈstɔːribʊks ænd ˈpleɪɪŋ ˈkrɪkɪt/",
      "මගේ විවේක කාලයේදී මම ඉංග්‍රීසි කතන්දර පොත් කියවීමට සහ ක්‍රිකට් ක්‍රීඩා කිරීමට කැමැත්තෙමි.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_6",
      "I help my mother with the household chores every evening.",
      "/aɪ hɛlp maɪ ˈmʌðər wɪð ðə ˈhaʊshoʊld tʃɔːrz ˈɛvri ˈiːvnɪŋ/",
      "මම හැමදාම සවස ගෙදර දොරේ වැඩකටයුතු සඳහා මගේ මවට උදව් කරමි.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_7",
      "My younger sister is preparing for her scholarship examination.",
      "/maɪ ˈjʌŋɡər ˈsɪstər ɪz prɪˈpeərɪŋ fɔːr hɜːr ˈskɒlərʃɪp ɪɡˌzæmɪˈneɪʃn/",
      "මගේ බාල සොහොයුරිය ඇගේ ශිෂ්‍යත්ව විභාගය සඳහා සූදානම් වෙමින් සිටියි.",
      "Intermediate",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_8",
      "I walk to school every day because our house is quite close.",
      "/aɪ wɔːk tuː skuːl ˈɛvri deɪ bɪˈkəz ˈaʊər haʊs ɪz kwaɪt kloʊs/",
      "අපේ නිවස තරමක් කිට්ටුව පිහිටා ඇති නිසා මම සෑම දිනකම පාසලට පයින් යමි.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_9",
      "Listening to news broadcasts improves both my vocabulary and pronunciation.",
      "/ˈlɪsnɪŋ tuː njuːz ˈbrɔːdkɑːsts ɪmˈpruːvz boʊθ maɪ vəˈkæbjʊləri ænd prəˌnʌnsiˈeɪʃn/",
      "ප්‍රවෘත්ති විකාශනවලට සවන්දීම මගේ වචන මාලාව සහ උච්චාරණය යන දෙකම දියුණු කරයි.",
      "Advanced",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_10",
      "I try my best to lead a balanced and healthy lifestyle.",
      "/aɪ traɪ maɪ bɛst tuː liːd ə ˈbælənst ænd ˈhɛlθi ˈlaɪfstaɪl/",
      "සමබර හා සෞඛ්‍ය සම්පන්න ජීවන රටාවක් ගත කිරීමට මම මගේ උපරිම උත්සාහය දරමි.",
      "Intermediate",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_11",
      "Have you lived in this neighborhood for a long time?",
      "/hæv juː lɪvd ɪn ðɪs ˈneɪbəhʊd fɔːr ə lɒŋ taɪm/",
      "ඔබ මෙම ප්‍රදේශයේ බොහෝ කලක සිට ජීවත් වෙනවාද?",
      "Intermediate",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_12",
      "Let me introduce you to my best friend, Amal.",
      "/lɛt miː ˌɪntrəˈdjuːs juː tuː maɪ bɛst frɛnd əˈmɑːl/",
      "මගේ හොඳම මිතුරා වන අමල්ව ඔබට හඳුන්වා දීමට මට ඉඩ දෙන්න.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_13",
      "I take the public bus to town whenever I need extra stationery.",
      "/aɪ teɪk ðə ˈpʌblɪk bʌs tuː taʊn wɛnˈɛvər aɪ niːd ˈɛkstrə ˈsteɪʃənəri/",
      "මට අමතර ලිපිද්‍රව්‍ය අවශ්‍ය වූ විට මම නගරයට යන්නේ පොදු බස් රථයෙනි.",
      "Intermediate",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_14",
      "Punctuality is a virtue that helps us gain respect from others.",
      "/ˌpʌŋktʃuˈæləti ɪz ə ˈvɜːtʃuː ðæt hɛlps ʌs ɡeɪn rɪˈspɛkt frɒm ˈʌðərz/",
      "වේලාවට වැඩ කිරීම අන්‍යයන්ගේ ගෞරවය දිනා ගැනීමට අපට උපකාරී වන උතුම් ගුණයකි.",
      "Advanced",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_15",
      "My father works as an agricultural officer in our village.",
      "/maɪ ˈfɑːðər wɜːks æz æn ˌæɡrɪˈkʌltʃərəl ˈɒfɪsər ɪn ˈaʊər ˈvɪlɪdʒ/",
      "මගේ පියා අපේ ගමේ කෘෂිකාර්මික නිලධාරියෙකු ලෙස සේවය කරයි.",
      "Intermediate",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_16",
      "I always pack my school bag the night before.",
      "/aɪ ˈɔːlweɪz pæk maɪ skuːl bæɡ ðə naɪt bɪˈfɔːr/",
      "මම සෑම විටම පාසල් බෑගය ලෑස්ති කරගන්නේ පෙර දින රාත්‍රියේදීය.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_17",
      "What do you usually do on Sunday afternoons?",
      "/wɒt duː juː ˈjuːʒuəli duː ɒn ˈsʌndeɪ ˌɑːftəˈnuːnz/",
      "ඉරිදා දහවල් කාලයේදී ඔබ සාමාන්‍යයෙන් කරන්නේ මොනවාද?",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_18",
      "I find gardening very relaxing after a busy study schedule.",
      "/aɪ faɪnd ˈɡɑːdnɪŋ ˈvɛri rɪˈlæksɪŋ ˈɑːftər ə ˈbɪzi ˈstʌdi ˈskɛdʒuːl/",
      "කාර්යබහුල අධ්‍යයන කාලසටහනකින් පසු ගෙවතු වගාව ඉතා සිත සනසන ක්‍රියාවක් බව මට හැඟේ.",
      "Intermediate",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_19",
      "I have two pet rabbits and I love feeding them fresh grass.",
      "/aɪ hæv tuː pɛt ˈræbɪts ænd aɪ lʌv ˈfiːdɪŋ ðɛm frɛʃ ɡrɑːs/",
      "මට සුරතල් හාවුන් දෙදෙනෙක් සිටින අතර උන්ට නැවුම් තණකොළ කෑමට දීමට මම කැමතියි.",
      "Beginner",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),
    SpokenSentencePractice(
      "sp_20",
      "Time management is essential for every student striving for excellence.",
      "/taɪm ˈmænɪdʒmənt ɪz ɪˈsɛnʃl fɔːr ˈɛvri ˈstjuːdənt ˈstraɪvɪŋ fɔːr ˈɛksələns/",
      "විශිෂ්ටත්වය කරා යන සෑම ශිෂ්‍යයෙකුටම කාල කළමනාකරණය අත්‍යවශ්‍ය වේ.",
      "Advanced",
      "තමා හඳුන්වා දීම & දින චර්යාව (Introductions & Daily Life)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 2: පාසල & විභාග (21 - 40)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_21",
      "Science and mathematics are my favorite subjects for the O/L examination.",
      "/ˈsaɪəns ænd ˌmæθəˈmætɪks ɑːr maɪ ˈfeɪvərɪt ˈsʌbdʒɪkts fɔːr ðiː oʊ ɛl ɪɡˌzæmɪˈneɪʃn/",
      "විද්‍යාව හා ගණිතය සාමාන්‍ය පෙළ විභාගය සඳහා මගේ ප්‍රියතම විෂයන් වේ.",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_22",
      "Could you please lend me your English past paper book?",
      "/kʊd juː pliːz lɛnd miː jɔːr ˈɪŋɡlɪʃ pɑːst ˈpeɪpər bʊk/",
      "කරුණාකර ඔබේ ඉංග්‍රීසි පසුගිය විභාග ප්‍රශ්න පත්‍ර පොත මට ලබා දිය හැකිද?",
      "Beginner",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_23",
      "Our teacher explained the active and passive voice rules clearly.",
      "/ˈaʊər ˈtiːtʃər ɪkˈspleɪnd ðiː ˈæktɪv ænd ˈpæsɪv vɔɪs ruːlz ˈklɪəli/",
      "අපගේ ගුරුතුමිය Active සහ Passive voice රීති ඉතා පැහැදිලිව විස්තර කළාය.",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_24",
      "I am confident that I will score an A grade in English this year.",
      "/aɪ æm ˈkɒnfɪdənt ðæt aɪ wɪl skɔːr æn eɪ ɡreɪd ɪn ˈɪŋɡlɪʃ ðɪs jɪər/",
      "මෙම වසරේ ඉංග්‍රීසි විෂයට A සාමාර්ථයක් ලබා ගැනීමට මට විශ්වාසයක් ඇත.",
      "Beginner",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_25",
      "Group discussions help us understand difficult scientific concepts easily.",
      "/ɡruːp dɪˈskʌʃnz hɛlp ʌs ˌʌndərˈstænd ˈdɪfɪkəlt ˌsaɪənˈtɪfɪk ˈkɒnsɛpts ˈiːzɪli/",
      "කණ්ඩායම් සාකච්ඡා මඟින් අපහසු විද්‍යාත්මක සංකල්ප පහසුවෙන් තේරුම් ගැනීමට අපට උපකාරී වේ.",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_26",
      "We must submit our history assignment before next Monday.",
      "/wiː mʌst səbˈmɪt ˈaʊər ˈhɪstəri əˈsaɪnmənt bɪˈfɔːr nɛkst ˈmʌndeɪ/",
      "අප ලබන සඳුදාට පෙර අපගේ ඉතිහාස පැවරුම භාර දිය යුතුය.",
      "Beginner",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_27",
      "The school library provides a quiet environment for concentrated studying.",
      "/ðə skuːl ˈlaɪbrəri prəˈvaɪdz ə ˈkwaɪət ɪnˈvaɪrənmənt fɔːr ˈkɒnsntreɪtɪd ˈstʌdiɪŋ/",
      "පාසල් පුස්තකාලය මනා එකඟතාවයකින් පාඩම් කිරීමට නිහඬ පරිසරයක් සපයයි.",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_28",
      "Practicing timed model papers improves exam speed and accuracy.",
      "/ˈpræktɪsɪŋ taɪmd ˈmɒdl ˈpeɪpərz ɪmˈpruːvz ɪɡˈzæm spiːd ænd ˈækjərəsi/",
      "නියමිත වේලාවට ආදර්ශ ප්‍රශ්න පත්‍ර පුහුණු වීම විභාගයේ වේගය සහ නිරවද්‍යතාවය වැඩි කරයි.",
      "Advanced",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_29",
      "Our principal emphasized the significance of discipline and mutual respect.",
      "/ˈaʊər ˈprɪnsəpl ˈɛmfəsaɪzd ðə sɪɡˈnɪfɪkəns ɒv ˈdɪsəplɪn ænd ˈmjuːtʃuəl rɪˈspɛkt/",
      "විනය සහ අන්‍යෝන්‍ය ගෞරවයේ වැදගත්කම අපගේ විදුහල්පතිතුමා අවධාරණය කළේය.",
      "Advanced",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_30",
      "May I ask a question regarding question number five on the blackboard?",
      "/meɪ aɪ ɑːsk ə ˈkwɛstʃən rɪˈɡɑːdɪŋ ˈkwɛstʃən ˈnʌmbər faɪv ɒn ðə ˈblækbɔːd/",
      "කළු ලෑල්ලේ ඇති පස්වන ප්‍රශ්නය පිළිබඳව මට ප්‍රශ්නයක් ඇසිය හැකිද?",
      "Beginner",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_31",
      "I usually underline new words in my textbook and find their meanings in a dictionary.",
      "/aɪ ˈjuːʒuəli ˌʌndərˈlaɪn njuː wɜːdz ɪn maɪ ˈtɛkstbʊk ænd faɪnd ðeər ˈmiːnɪŋz ɪn ə ˈdɪkʃənəri/",
      "මම සාමාන්‍යයෙන් පෙළපොතේ අලුත් වචන යටින් ඉරි ඇඳ ශබ්දකෝෂයකින් ඒවායේ තේරුම සොයා ගනිමි.",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_32",
      "Who is representing our school in the inter-school debate tournament?",
      "/huː ɪz ˌrɛprɪˈzɛntɪŋ ˈaʊər skuːl ɪn ðiː ˌɪntər skuːl dɪˈbeɪt ˈtʊənəmənt/",
      "අන්තර් පාසල් විවාද තරගාවලියේදී අපගේ පාසල නියෝජනය කරන්නේ කවුද?",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_33",
      "We conducted a chemistry experiment in the science laboratory today.",
      "/wiː kənˈdʌktɪd ə ˈkɛmɪstri ɪkˈspɛrɪmənt ɪn ðə ˈsaɪəns ləˈbɒrətəri təˈdeɪ/",
      "අද අපි විද්‍යාගාරයේදී රසායන විද්‍යා පරීක්ෂණයක් සිදු කළෙමු.",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_34",
      "Always verify your answers carefully before handing over the answer sheet.",
      "/ˈɔːlweɪz ˈvɛrɪfaɪ jɔːr ˈɑːnsərz ˈkeəfəli bɪˈfɔːr ˈhændɪŋ ˈoʊvər ðiː ˈɑːnsər ʃiːt/",
      "පිළිතුරු පත්‍රය භාර දීමට පෙර සෑම විටම ඔබේ පිළිතුරු හොඳින් පරීක්ෂා කර බලන්න.",
      "Advanced",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_35",
      "My teacher guided me on how to write formal letters and essays accurately.",
      "/maɪ ˈtiːtʃər ˈɡaɪdɪd miː ɒn haʊ tuː raɪt ˈfɔːməl ˈlɛtərz ænd ˈɛseɪz ˈækjərətli/",
      "නිල ලිපි සහ රචනා නිවැරදිව ලියන ආකාරය පිළිබඳව මගේ ගුරුතුමා මට මඟ පෙන්වීය.",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_36",
      "Do we have any physical training classes scheduled for this Thursday?",
      "/duː wiː hæv ˈɛni ˈfɪzɪkl ˈtreɪnɪŋ ˈklɑːsɪz ˈskɛdʒuːld fɔːr ðɪs ˈθɜːzdeɪ/",
      "මේ බ්‍රහස්පතින්දා අපට ශාරීරික අභ්‍යාස පන්තියක් යොදා තිබේද?",
      "Beginner",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_37",
      "A thorough revision of past papers guarantees higher confidence in the exam hall.",
      "/ə ˈθʌrə rɪˈvɪʒn ɒv pɑːst ˈpeɪpərz ˌɡærənˈtiːz ˈhaɪər ˈkɒnfɪdəns ɪn ðiː ɪɡˈzæm hɔːl/",
      "පසුගිය විභාග ප්‍රශ්න පත්‍ර මනාව පුනරීක්ෂණය කිරීම විභාග ශාලාවේදී වැඩි ආත්ම විශ්වාසයක් තහවුරු කරයි.",
      "Advanced",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_38",
      "I was appointed as the prefect in charge of maintaining morning assembly order.",
      "/aɪ wɒz əˈpɔɪntɪd æz ðə ˈpriːfɛkt ɪn tʃɑːdʒ ɒv meɪnˈteɪnɪŋ ˈmɔːnɪŋ əˈsɛmbli ˈɔːdər/",
      "උදෑසන රැස්වීමේ පිළිවෙළ පවත්වාගෙන යාමේ වගකීම දරන ශිෂ්‍ය නායකයා ලෙස මාව පත් කරන ලදී.",
      "Advanced",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_39",
      "Never hesitate to ask for clarification whenever you encounter a doubt.",
      "/ˈnɛvər ˈhɛzɪteɪt tuː ɑːsk fɔːr ˌklærɪfɪˈkeɪʃn wɛnˈɛvər juː ɪnˈkaʊntər ə daʊt/",
      "ඔබට කිසියම් සැකයක් ඇති වූ විට පැහැදිලි කර ගැනීමට කිසිවිටෙකත් පසුබට නොවන්න.",
      "Advanced",
      "පාසල & විභාග (School & O/L Studies)"
    ),
    SpokenSentencePractice(
      "sp_40",
      "Our school anniversary will be celebrated with a grand exhibition next term.",
      "/ˈaʊər skuːl ˌænɪˈvɜːsəri wɪl biː ˈsɛlɪbreɪtɪd wɪð ə ɡrænd ˌɛksɪˈbɪʃn nɛkst tɜːm/",
      "අප පාසලේ සංවත්සරය ලබන වාරයේදී දැවැන්ත ප්‍රදර්ශනයක් සමඟ සමරනු ඇත.",
      "Intermediate",
      "පාසල & විභාග (School & O/L Studies)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 3: ආචාරශීලී ඉල්ලීම් (41 - 60)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_41",
      "Could you please repeat what you just said?",
      "/kʊd juː pliːz rɪˈpiːt wɒt juː dʒʌst sɛd/",
      "කරුණාකර ඔබ දැන් පැවසූ දෙය නැවත පැවසිය හැකිද?",
      "Beginner",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_42",
      "Would you mind closing the door behind you, please?",
      "/wʊd juː maɪnd ˈkloʊzɪŋ ðə dɔːr bɪˈhaɪnd juː pliːz/",
      "කරුණාකර ඔබ පිටුපසින් ඇති දොර වැසුවාට කමක් නැද්ද?",
      "Intermediate",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_43",
      "May I have permission to leave the room for a few minutes?",
      "/meɪ aɪ hæv pərˈmɪʃn tuː liːv ðə ruːm fɔːr ə fjuː ˈmɪnɪts/",
      "මිනිත්තු කිහිපයකට කාමරයෙන් පිටතට යාමට මට අවසර ලබාගත හැකිද?",
      "Intermediate",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_44",
      "I would appreciate it if you could give me some guidance.",
      "/aɪ wʊd əˈpriːʃieɪt ɪt ɪf juː kʊd ɡɪv miː sʌm ˈɡaɪdəns/",
      "මට යම් මඟපෙන්වීමක් ලබා දිය හැකි නම් මම එය ඉතා අගය කරමි.",
      "Advanced",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_45",
      "Excuse me, is this seat occupied or may I sit here?",
      "/ɪkˈskjuːz miː ɪz ðɪs siːt ˈɒkjʊpaɪd ɔːr meɪ aɪ sɪt hɪər/",
      "සමාවෙන්න, මෙම ආසනය වෙන් කර ඇත්ද නැතහොත් මට මෙහි වාඩි විය හැකිද?",
      "Beginner",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_46",
      "Could you kindly lower your voice as people are studying?",
      "/kʊd juː ˈkaɪndli ˈloʊər jɔːr vɔɪs æz ˈpiːpl ɑːr ˈstʌdiɪŋ/",
      "අය පාඩම් කරන බැවින් කරුණාකර ඔබේ කටහඬ මඳක් අඩු කළ හැකිද?",
      "Intermediate",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_47",
      "Pardon me, I did not catch your name properly.",
      "/ˈpɑːdn miː aɪ dɪd nɒt kætʃ jɔːr neɪm ˈprɒpəli/",
      "මට සමාවෙන්න, ඔබගේ නම මට පැහැදිලිව ඇසුණේ නැත.",
      "Beginner",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_48",
      "Would it be possible to reschedule our appointment for tomorrow afternoon?",
      "/wʊd ɪt biː ˈpɒsəbl tuː ˌriːˈskɛdʒuːl ˈaʊər əˈpɔɪntmənt fɔːr təˈmɒroʊ ˌɑːftəˈnuːn/",
      "අපගේ හමුව හෙට දහවල් කාලයට කල් දැමීමට හැකි වේවිද?",
      "Advanced",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_49",
      "Could you please pass the salt across the table?",
      "/kʊd juː pliːz pɑːs ðə sɔːlt əˈkrɒs ðə ˈteɪbl/",
      "කරුණාකර මේසය හරහා ලුණු කුප්පිය මට ලබා දිය හැකිද?",
      "Beginner",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_50",
      "Thank you very much for your kind cooperation and understanding.",
      "/θæŋk juː ˈvɛri mʌtʃ fɔːr jɔːr kaɪnd koʊˌɒpəˈreɪʃn ænd ˌʌndərˈstændɪŋ/",
      "ඔබගේ කාරුණික සහයෝගය සහ අවබෝධය වෙනුවෙන් ඔබට බෙහෙවින්ම ස්තූතියි.",
      "Intermediate",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_51",
      "I am deeply sorry for any inconvenience this misunderstanding may have caused.",
      "/aɪ æm ˈdiːpli ˈsɒri fɔːr ˈɛni ˌɪnkənˈviːniəns ðɪs ˌmɪsʌndərˈstændɪŋ meɪ hæv kɔːzd/",
      "මෙම වැරදි වැටහීම නිසා සිදු වූ යම් අපහසුතාවයක් වේ නම් මම ඒ ගැන බලවත් කනගාටුව පළ කරමි.",
      "Advanced",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_52",
      "Could you spare a moment to review this paragraph?",
      "/kʊd juː speər ə ˈmoʊmənt tuː rɪˈvjuː ðɪs ˈpærəɡrɑːf/",
      "මෙම ඡේදය බැලීමට ඔබට මොහොතක් වෙන් කළ හැකිද?",
      "Intermediate",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_53",
      "Please feel free to make yourself at home.",
      "/pliːz fiːl friː tuː meɪk jɔːˈsɛlf æt hoʊm/",
      "කරුණාකර මෙය ඔබේම නිවසක් ලෙස සිතා නිදහසේ සිටින්න.",
      "Beginner",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_54",
      "Would you like me to carry that heavy bag for you?",
      "/wʊd juː laɪk miː tuː ˈkæri ðæt ˈhɛvi bæɡ fɔːr juː/",
      "ඔබ වෙනුවෙන් එම බර බෑගය රැගෙන යාමට මම ඔබට උදව් කරන්නද?",
      "Beginner",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_55",
      "I am truly grateful for your continued support and mentorship.",
      "/aɪ æm ˈtruːli ˈɡreɪtfl fɔːr jɔːr kənˈtɪnjuːd səˈpɔːt ænd ˈmɛntɔːʃɪp/",
      "ඔබගේ අඛණ්ඩ සහයෝගය සහ මඟපෙන්වීම පිළිබඳව මම සැබවින්ම කෘතඥ වෙමි.",
      "Advanced",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_56",
      "Could you please tell me what time the meeting commences?",
      "/kʊd juː pliːz tɛl miː wɒt taɪm ðə ˈmiːtɪŋ kəˈmɛnsɪz/",
      "රැස්වීම ආරම්භ වන්නේ කුමන වේලාවටදැයි කරුණාකර මට පැවසිය හැකිද?",
      "Intermediate",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_57",
      "If you don't mind, I would prefer to finish this today.",
      "/ɪf juː doʊnt maɪnd aɪ wʊd prɪˈfɜːr tuː ˈfɪnɪʃ ðɪs təˈdeɪ/",
      "ඔබ අකමැති නැත්නම්, මම මෙය අදම අවසන් කිරීමට කැමැත්තෙමි.",
      "Intermediate",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_58",
      "May I borrow an eraser for a moment, please?",
      "/meɪ aɪ ˈbɒroʊ æn ɪˈreɪzər fɔːr ə ˈmoʊmənt pliːz/",
      "මොහොතකට මකනයක් ණයට ගැනීමට මට අවසරද?",
      "Beginner",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_59",
      "It is exceptionally kind of you to lend a helping hand.",
      "/ɪt ɪz ɪkˈsɛpʃənəli kaɪnd ɒv juː tuː lɛnd ə ˈhɛlpɪŋ hænd/",
      "උදව් උපකාර කිරීමට ඉදිරිපත් වීම ඔබගේ ඉතාමත් කරුණාවන්ත ගුණයකි.",
      "Advanced",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),
    SpokenSentencePractice(
      "sp_60",
      "Please let me know if there is anything else I can do for you.",
      "/pliːz lɛt miː noʊ ɪf ðeər ɪz ˈɛnɪθɪŋ ɛls aɪ kæn duː fɔːr juː/",
      "ඔබ වෙනුවෙන් මට කළ හැකි වෙනත් යමක් ඇත්නම් කරුණාකර මට දන්වන්න.",
      "Intermediate",
      "ආචාරශීලී ඉල්ලීම් (Polite Requests)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 4: මඟ විමසීම & ගමන් බිමන් (61 - 80)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_61",
      "Excuse me, could you kindly direct me to the nearest railway station?",
      "/ɪkˈskjuːz miː kʊd juː ˈkaɪndli dɪˈrɛkt miː tuː ðə ˈnɪərɪst ˈreɪlweɪ ˈsteɪʃn/",
      "සමාවෙන්න, ළඟම ඇති දුම්රිය ස්ථානයට යන මාර්ගය කරුණාකර මට පෙන්විය හැකිද?",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_62",
      "Go straight along this street and take the second turning to the right.",
      "/ɡoʊ streɪt əˈlɒŋ ðɪs striːt ænd teɪk ðə ˈsɛkənd ˈtɜːnɪŋ tuː ðə raɪt/",
      "මෙම පාර දිගේ කෙළින්ම ගොස් දකුණට ඇති දෙවන හැරවුමෙන් හැරෙන්න.",
      "Beginner",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_63",
      "How long does it take to reach Colombo Fort by express bus?",
      "/haʊ lɒŋ dʌz ɪt teɪk tuː riːtʃ kəˈlʌmboʊ fɔːt baɪ ɪkˈsprɛs bʌs/",
      "අධිවේගී බස් රථයෙන් කොළඹ කොටුවට ළඟාවීමට කොපමණ වේලාවක් ගතවේද?",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_64",
      "Is the National Museum open to visitors on public holidays?",
      "/ɪz ðə ˈnæʃnəl mjuːˈziːəm ˈoʊpən tuː ˈvɪzɪtərz ɒn ˈpʌblɪk ˈhɒlədeɪz/",
      "පොදු නිවාඩු දිනවලදී ජාතික කෞතුකාගාරය නරඹන්නන් සඳහා විවෘතව තිබේද?",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_65",
      "Be careful when crossing the pedestrian crossing during rush hour.",
      "/biː ˈkeəfl wɛn ˈkrɒsɪŋ ðə pəˈdɛstriən ˈkrɒsɪŋ ˈdjʊərɪŋ rʌʃ ˈaʊər/",
      "කාර්යබහුල වේලාවන්හිදී මංමාවත් මාරු වන විට (සුදු ඉරි මතින්) ප්‍රවේශම් වන්න.",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_66",
      "Where can I purchase a ticket for the night mail train to Badulla?",
      "/weər kæn aɪ ˈpɜːtʃəs ə ˈtɪkɪt fɔːr ðə naɪt meɪl treɪn tuː bəˈdʌlə/",
      "බදුල්ල බලා ධාවනය වන රාත්‍රී තැපැල් දුම්රිය සඳහා ප්‍රවේශ පත්‍රයක් මිලදී ගත හැක්කේ කොහෙන්ද?",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_67",
      "The scenic train ride to Ella attracts thousands of foreign tourists every month.",
      "/ðə ˈsiːnɪk treɪn raɪd tuː ˈɛlə əˈtrækts ˈθaʊzndz ɒv ˈfɒrən ˈtʊərɪsts ˈɛvri mʌnθ/",
      "ඇල්ල දක්වා ඇති මනරම් දුම්රිය ගමන සෑම මසකම දහස් ගණනක් විදේශීය සංචාරකයින් ආකර්ෂණය කර ගනී.",
      "Advanced",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_68",
      "You have to get off at the clock tower junction and walk two hundred meters.",
      "/juː hæv tuː ɡɛt ɒf æt ðə klɒk ˈtaʊər ˈdʒʌŋkʃn ænd wɔːk tuː ˈhʌndrəd ˈmiːtərz/",
      "ඔබ ඔරලෝසු කණුව හන්දියෙන් බැස මීටර් දෙසීයක් පයින් යා යුතුය.",
      "Beginner",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_69",
      "Could you let me know when the next bus to Galle departs?",
      "/kʊd juː lɛt miː noʊ wɛn ðə nɛkst bʌs tuː ɡɔːl dɪˈpɑːts/",
      "ගාල්ල බලා යන මීළඟ බස් රථය පිටත් වන්නේ කවදාදැයි මට දන්වන්න පුළුවන්ද?",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_70",
      "Is it within walking distance or should I hire a three-wheeler?",
      "/ɪz ɪt wɪðˈɪn ˈwɔːkɪŋ ˈdɪstəns ɔːr ʃʊd aɪ ˈhaɪər ə θriː ˈwiːlər/",
      "එය පයින් යා හැකි දුරකින් පිහිටා තිබේද නැතහොත් ත්‍රිරෝද රථයක් කුලියට ගත යුතුද?",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_71",
      "Keep to the left side of the road to avoid incoming traffic.",
      "/kiːp tuː ðə lɛft saɪd ɒv ðə roʊd tuː əˈvɔɪd ˈɪnˌkʌmɪŋ ˈtræfɪk/",
      "ඉදිරියෙන් එන වාහන මඟහැරීම සඳහා පාරේ වම් පැත්තෙන් ගමන් කරන්න.",
      "Beginner",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_72",
      "We experienced a slight delay due to ongoing highway construction work.",
      "/wiː ɪkˈspɪəriənst ə slaɪt dɪˈleɪ djuː tuː ˈɒnˌɡoʊɪŋ ˈhaɪweɪ kənˈstrʌkʃn wɜːk/",
      "මහාමාර්ගයේ සිදුවන ඉදිකිරීම් කටයුතු නිසා අපට සුළු ප්‍රමාදයකට මුහුණ දීමට සිදු විය.",
      "Advanced",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_73",
      "Does this local train stop at every intermediate station?",
      "/dʌz ðɪs ˈloʊkl treɪn stɒp æt ˈɛvri ˌɪntərˈmiːdiət ˈsteɪʃn/",
      "මෙම මන්දගාමී දුම්රිය අතරමඟ ඇති සෑම දුම්රිය ස්ථානයකම නවත්වනවාද?",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_74",
      "I forgot my umbrella on the bus seat this morning.",
      "/aɪ fərˈɡɒt maɪ ʌmˈbrɛlə ɒn ðə bʌs siːt ðɪs ˈmɔːnɪŋ/",
      "අද උදෑසන බස් රථයේ ආසනය මත මගේ කුඩය අමතක වී දමා ආවෙමි.",
      "Beginner",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_75",
      "The highway police patrol ensures that drivers strictly obey the speed limits.",
      "/ðə ˈhaɪweɪ pəˈliːs pəˈtroʊl ɪnˈʃʊərz ðæt ˈdraɪvərz ˈstrɪktli əˈbeɪ ðə spiːd ˈlɪmɪts/",
      "රියදුරන් වේග සීමාවන්ට දැඩි ලෙස අවනත වන බව අධිවේගී මාර්ග පොලිස් මුර සංචාරය මඟින් තහවුරු කරයි.",
      "Advanced",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_76",
      "Turn left right after passing the ancient Buddhist temple.",
      "/tɜːn lɛft raɪt ˈɑːftər ˈpɑːsɪŋ ðiː ˈeɪnʃənt ˈbʊdɪst ˈtɛmpl/",
      "පැරණි බෞද්ධ විහාරස්ථානය පසු කළ වහාම වමට හැරෙන්න.",
      "Beginner",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_77",
      "Could you tell me which platform the train to Jaffna arrives at?",
      "/kʊd juː tɛl miː wɪtʃ ˈplætfɔːm ðə treɪn tuː ˈdʒæfnə əˈraɪvz æt/",
      "යාපනය බලා යන දුම්රිය පැමිණෙන්නේ කුමන වේදිකාවටදැයි මට පැවසිය හැකිද?",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_78",
      "Always ensure your seatbelt is securely fastened before driving.",
      "/ˈɔːlweɪz ɪnˈʃʊər jɔːr ˈsiːtbɛlt ɪz sɪˈkjʊəli ˈfɑːsnd bɪˈfɔːr ˈdraɪvɪŋ/",
      "රිය පැදවීමට පෙර සෑම විටම ඔබගේ ආරක්ෂිත ආසන පටිය නිසි ලෙස සවි කර ඇති බව තහවුරු කරගන්න.",
      "Intermediate",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_79",
      "Sigiriya is an architectural wonder that showcases ancient hydraulic engineering.",
      "/sɪɡɪˈriːjə ɪz æn ˌɑːkɪˈtɛktʃərəl ˈwʌndər ðæt ˈʃoʊkeɪsɪz ˈeɪnʃənt haɪˈdrɔːlɪk ˌɛndʒɪˈnɪərɪŋ/",
      "සීගිරිය යනු පුරාණ ජල තාක්ෂණික ඉංජිනේරු විද්‍යාව විදහා දක්වන වාස්තු විද්‍යාත්මක ආශ්චර්යයකි.",
      "Advanced",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),
    SpokenSentencePractice(
      "sp_80",
      "Have a safe and enjoyable journey back home!",
      "/hæv ə seɪf ænd ɪnˈdʒɔɪəbl ˈdʒɜːni bæk hoʊm/",
      "නිරුපද්‍රිත සහ ප්‍රීතිමත් ආපසු ගමනක් වේවා!",
      "Beginner",
      "මඟ විමසීම & ගමන් බිමන් (Directions & Travel)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 5: සාප්පු සවාරි & මුදල් (81 - 100)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_81",
      "How much does this pair of school shoes cost?",
      "/haʊ mʌtʃ dʌz ðɪs peər ɒv skuːl ʃuːz kɒst/",
      "මෙම පාසල් සපත්තු යුගලයේ මිල කීයද?",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_82",
      "Do you accept credit cards or is cash required?",
      "/duː juː əkˈsɛpt ˈkrɛdɪt kɑːdz ɔːr ɪz kæʃ rɪˈkwaɪəd/",
      "ඔබ ක්‍රෙඩිට් කාඩ්පත් පිළිගන්නවාද නැතහොත් මුදල්ම අවශ්‍යද?",
      "Intermediate",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_83",
      "Could you give me a discount if I purchase three notebooks?",
      "/kʊd juː ɡɪv miː ə ˈdɪskaʊnt ɪf aɪ ˈpɜːtʃəs θriː ˈnoʊtbʊks/",
      "මම අභ්‍යාස පොත් තුනක් මිලදී ගතහොත් මට වට්ටමක් ලබා දිය හැකිද?",
      "Intermediate",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_84",
      "Can I try this shirt on to see if it fits?",
      "/kæn aɪ traɪ ðɪs ʃɜːt ɒn tuː siː ɪf ɪt fɪts/",
      "මෙම කමිසය මට හරියටම ගැලපේදැයි බැලීමට එය ඇඳ බැලිය හැකිද?",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_85",
      "Where is the fitting room located in this department store?",
      "/weər ɪz ðə ˈfɪtɪŋ ruːm loʊˈkeɪtɪd ɪn ðɪs dɪˈpɑːtmənt stɔːr/",
      "මෙම වෙළඳසැලේ ඇඳුම් ඇඳ බලන කාමරය පිහිටා ඇත්තේ කොතැනද?",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_86",
      "Please keep the printed bill in case you need to exchange this item.",
      "/pliːz kiːp ðə ˈprɪntɪd bɪl ɪn keɪs juː niːd tuː ɪksˈtʃeɪndʒ ðɪs ˈaɪtəm/",
      "ඔබට මෙම භාණ්ඩය මාරු කර ගැනීමට අවශ්‍ය වුවහොත් කරුණාකර මුද්‍රිත බිල්පත ළඟ තබා ගන්න.",
      "Intermediate",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_87",
      "Is there a warranty provided for this electronic calculator?",
      "/ɪz ðeər ə ˈwɒrənti prəˈvaɪdɪd fɔːr ðɪs ˌɪlɛkˈtrɒnɪk ˈkælkjʊleɪtər/",
      "මෙම ඉලෙක්ට්‍රොනික කැල්කියුලේටරය සඳහා වගකීම් සහතිකයක් (Warranty) ලබා දෙනවාද?",
      "Intermediate",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_88",
      "Do you have this specific geometry box in stock right now?",
      "/duː juː hæv ðɪs spəˈsɪfɪk dʒiˈɒmətri bɒks ɪn stɒk raɪt naʊ/",
      "මෙම ජ්‍යාමිතික පෙට්ටිය දැනට ඔබ සතුව තොග වශයෙන් තිබේද?",
      "Intermediate",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_89",
      "Here is your balance and receipt, sir.",
      "/hɪər ɪz jɔːr ˈbæləns ænd rɪˈsiːt sɜːr/",
      "ඔබගේ ඉතිරි මුදල් සහ රිසිට්පත මෙන්න, මහත්මයා.",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_90",
      "I am looking for a blue ballpoint pen with smooth ink flow.",
      "/aɪ æm ˈlʊkɪŋ fɔːr ə bluː ˈbɔːlpɔɪnt pɛn wɪð smuːð ɪŋk floʊ/",
      "මම සොයන්නේ සුමටව තීන්ත ගලා යන නිල් පැහැති බෝල්පොයින්ට් පෑනකි.",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_91",
      "These organic vegetables are cultivated without harmful chemical pesticides.",
      "/ðiːz ɔːˈɡænɪk ˈvɛdʒtəblz ɑːr ˈkʌltɪveɪtɪd wɪðˈaʊt ˈhɑːmfl ˈkɛmɪkl ˈpɛstɪsaɪdz/",
      "මෙම කාබනික එළවළු වගා කර ඇත්තේ හානිකර රසායනික කෘමිනාශකවලින් තොරවය.",
      "Advanced",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_92",
      "Can I get a paper bag instead of a polythene bag, please?",
      "/kæn aɪ ɡɛt ə ˈpeɪpər bæɡ ɪnˈstɛd ɒv ə ˈpɒlɪθiːn bæɡ pliːz/",
      "පොලිතින් බෑගයක් වෙනුවට කඩදාසි බෑගයක් ලබාගත හැකිද?",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_93",
      "The special promotional discount expires at the end of this month.",
      "/ðə ˈspɛʃl prəˈmoʊʃənl ˈdɪskaʊnt ɪkˈspaɪərz æt ðiː ɛnd ɒv ðɪs mʌnθ/",
      "විශේෂ ප්‍රවර්ධන වට්ටම මෙම මස අවසානයේදී කල් ඉකුත් වේ.",
      "Advanced",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_94",
      "Could you please check the price of this dictionary using the barcode scanner?",
      "/kʊd juː pliːz tʃɛk ðə praɪs ɒv ðɪs ˈdɪkʃənəri ˈjuːzɪŋ ðə ˈbɑːkoʊd ˈskænər/",
      "බාර්කෝඩ් ස්කෑනරය භාවිතා කර මෙම ශබ්දකෝෂයේ මිල පරීක්ෂා කර බැලිය හැකිද?",
      "Intermediate",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_95",
      "I would like to return this defective flashlight for a full refund.",
      "/aɪ wʊd laɪk tuː rɪˈtɜːn ðɪs dɪˈfɛktɪv ˈflæʃlaɪt fɔːr ə fʊl ˈriːfʌnd/",
      "මෙම දෝෂ සහිත විදුලි පන්දම ආපසු භාර දී සම්පූර්ණ මුදල් ආපසු ලබා ගැනීමට මම කැමැත්තෙමි.",
      "Advanced",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_96",
      "Wise spending and regular savings help secure a stable financial future.",
      "/waɪz ˈspɛndɪŋ ænd ˈrɛɡjələr ˈseɪvɪŋz hɛlp sɪˈkjʊər ə ˈsteɪbl faɪˈnænʃl ˈfjuːtʃər/",
      "ඥානාන්විත වියදම් කිරීම සහ ක්‍රමවත් ඉතිරිකිරීම ස්ථාවර මූල්‍ය අනාගතයක් සුරක්ෂිත කිරීමට උපකාරී වේ.",
      "Advanced",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_97",
      "Do you offer free home delivery for bulk grocery orders?",
      "/duː juː ˈɒfər friː hoʊm dɪˈlɪvəri fɔːr bʌlk ˈɡroʊsəri ˈɔːdərz/",
      "තොග වශයෙන් ලබා ගන්නා සිල්ලර බඩු සඳහා නොමිලේ නිවසටම ගෙනැවිත් දීමේ සේවාව සපයනවාද?",
      "Intermediate",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_98",
      "Excuse me, where can I find pure Ceylon cinnamon powder?",
      "/ɪkˈskjuːz miː weər kæn aɪ faɪnd pjʊər sɪˈlɒn ˈsɪnəmən ˈpaʊdər/",
      "සමාවෙන්න, පිරිසිදු ලංකා කුරුඳු කුඩු සොයාගත හැක්කේ කොතැනින්ද?",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_99",
      "I only have a five-thousand-rupee note; do you have change?",
      "/aɪ ˈoʊnli hæv ə faɪv ˈθaʊznd ˈruːpiː noʊt duː juː hæv tʃeɪndʒ/",
      "මා ළඟ ඇත්තේ රුපියල් පන්දහසේ නෝට්ටුවක් පමණි; ඔබට මාරු කාසි තිබේද?",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),
    SpokenSentencePractice(
      "sp_100",
      "Thank you for shopping with us, please visit again soon.",
      "/θæŋk juː fɔːr ˈʃɒpɪŋ wɪð ʌs pliːz ˈvɪzɪt əˈɡɛn suːn/",
      "අප සමඟ ගනුදෙනු කළාට ස්තූතියි, නැවතත් පැමිණෙන්න.",
      "Beginner",
      "සාප්පු සවාරි & මුදල් (Shopping & Prices)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 6: සෞඛ්‍යය & වෛද්‍ය හමුව (101 - 120)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_101",
      "I have been suffering from a mild fever and a sore throat since yesterday.",
      "/aɪ hæv biːn ˈsʌfərɪŋ frɒm ə maɪld ˈfiːvər ænd ə sɔːr θroʊt sɪns ˈjɛstədeɪ/",
      "ඊයේ සිට මට මඳ උණ සහ උගුරේ අමාරුවක් පවතී.",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_102",
      "You should drink plenty of boiled warm water and take sufficient rest.",
      "/juː ʃʊd drɪŋk ˈplɛnti ɒv bɔɪld wɔːm ˈwɔːtər ænd teɪk səˈfɪʃnt rɛst/",
      "ඔබ උණුකර නිවාගත් උණුසුම් ජලය වැඩිපුර පානය කර ප්‍රමාණවත් විවේකයක් ගත යුතුය.",
      "Beginner",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_103",
      "Take these prescribed tablets twice daily after meals.",
      "/teɪk ðiːz prɪˈskraɪbd ˈtæblɪts twaɪs ˈdeɪli ˈɑːftər miːlz/",
      "නියම කරන ලද මෙම පෙති ආහාර ගැනීමෙන් පසු දිනකට දෙවරක් ගන්න.",
      "Beginner",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_104",
      "Are you allergic to any particular medications or food items?",
      "/ɑːr juː əˈlɜːdʒɪk tuː ˈɛni pəˈtɪkjələr ˌmɛdɪˈkeɪʃnz ɔːr fuːd ˈaɪtəmz/",
      "ඔබට කිසියම් ඖෂධයකට හෝ ආහාර වර්ගයකට අසාත්මිකතාවයක් (Allergy) තිබේද?",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_105",
      "Regular physical exercise keeps both the body and mind vigorous.",
      "/ˈrɛɡjələr ˈfɪzɪkl ˈɛksəsaɪz kiːps boʊθ ðə ˈbɒdi ænd maɪnd ˈvɪɡərəs/",
      "නිතිපතා ශාරීරික ව්‍යායාම මඟින් ශරීරය සහ මනස දෙකම ප්‍රබෝධමත්ව තබා ගනී.",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_106",
      "I have an appointment with the dentist at four o'clock today.",
      "/aɪ hæv æn əˈpɔɪntmənt wɪð ðə ˈdɛntɪst æt fɔːr əˈklɒk təˈdeɪ/",
      "අද සවස හතරට මට දන්ත වෛද්‍යවරයා හමුවීමට වේලාවක් වෙන් කර ඇත.",
      "Beginner",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_107",
      "Mental well-being is just as vital as physical fitness during exam periods.",
      "/ˈmɛntl wɛl ˈbiːɪŋ ɪz dʒʌst æz ˈvaɪtl æz ˈfɪzɪkl ˈfɪtnəs ˈdjʊərɪŋ ɪɡˈzæm ˈpɪəriədz/",
      "විභාග කාල සීමාව තුළ මානසික සුවතාවය ශාරීරික සුවතාවය තරම්ම අත්‍යවශ්‍ය වේ.",
      "Advanced",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_108",
      "Wash your hands thoroughly with soap before having every meal.",
      "/wɒʃ jɔːr hændz ˈθʌrəli wɪð soʊp bɪˈfɔːr ˈhævɪŋ ˈɛvri miːl/",
      "සෑම ආහාර වේලකටම පෙර සබන් යොදා දෑත් හොඳින් සෝදා පිරිසිදු කරගන්න.",
      "Beginner",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_109",
      "I felt a sudden sharp pain in my left ankle while sprinting.",
      "/aɪ fɛlt ə ˈsʌdn ʃɑːp peɪn ɪn maɪ lɛft ˈæŋkl waɪl ˈsprɪntɪŋ/",
      "වේගයෙන් දුවන විට මගේ වම් වළලුකරෙහි ක්ෂණික තියුණු වේදනාවක් දැනුණි.",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_110",
      "The doctor advised me to reduce refined sugar intake and consume more green leafy vegetables.",
      "/ðə ˈdɒktər ədˈvaɪzd miː tuː rɪˈdjuːs rɪˈfaɪnd ˈʃʊɡər ˈɪnteɪk ænd kənˈsjuːm mɔːr ɡriːn ˈliːfi ˈvɛdʒtəblz/",
      "පිරිපහදු කළ සීනි භාවිතය අඩු කර වැඩිපුර කොළ පැහැති පලා වර්ග ආහාරයට ගන්නා ලෙස වෛද්‍යවරයා මට උපදෙස් දුන්නේය.",
      "Advanced",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_111",
      "Ensure you get at least seven hours of uninterrupted sleep each night.",
      "/ɪnˈʃʊər juː ɡɛt æt liːst ˈsɛvn ˈaʊərz ɒv ˌʌnˌɪntəˈrʌptɪd sliːp iːtʃ naɪt/",
      "සෑම රාත්‍රියකම අවම වශයෙන් පැය හතක නොකඩවා නින්දක් ලැබෙන බවට වග බලා ගන්න.",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_112",
      "A first aid kit should always be accessible in every school and home.",
      "/ə fɜːst eɪd kɪt ʃʊd ˈɔːlweɪz biː əkˈsɛsəbl ɪn ˈɛvri skuːl ænd hoʊm/",
      "ප්‍රථමාධාර පෙට්ටියක් සෑම පාසලකම සහ නිවසකම පහසුවෙන් ලබාගත හැකි ස්ථානයක තිබිය යුතුය.",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_113",
      "Do you feel dizzy when you suddenly stand up from your chair?",
      "/duː juː fiːl ˈdɪzi wɛn juː ˈsʌdnli stænd ʌp frɒm jɔːr tʃeər/",
      "පුටුවෙන් එකවර නැගී සිටින විට ඔබට කරකැවිල්ලක් දැනෙනවාද?",
      "Beginner",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_114",
      "Protect your eyes by taking brief breaks from computer screens every twenty minutes.",
      "/prəˈtɛkt jɔːr aɪz baɪ ˈteɪkɪŋ briːf breɪks frɒm kəmˈpjuːtər skriːnz ˈɛvri ˈtwɛnti ˈmɪnɪts/",
      "සෑම මිනිත්තු විස්සකට වරක් පරිගණක තිරයෙන් මඳ විවේකයක් ලබාගෙන ඔබේ ඇස් ආරක්ෂා කරගන්න.",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_115",
      "Vaccination protects children against dangerous infectious diseases.",
      "/ˌvæksɪˈneɪʃn prəˈtɛkts ˈtʃɪldrən əˈɡɛnst ˈdeɪndʒərəs ɪnˈfɛkʃəs dɪˈziːzɪz/",
      "එන්නත්කරණය මඟින් භයානක බෝවන රෝගවලින් දරුවන් ආරක්ෂා කරයි.",
      "Advanced",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_116",
      "I need to buy some soothing cough syrup from the pharmacy.",
      "/aɪ niːd tuː baɪ sʌm ˈsuːðɪŋ kɒf ˈsɪrəp frɒm ðə ˈfɑːməsi/",
      "මට ඔසුසලෙන් සෙම සමනය කරන කැස්ස පැණියක් මිලදී ගැනීමට අවශ්‍යයි.",
      "Beginner",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_117",
      "Deep breathing exercises assist in alleviating examination anxiety.",
      "/diːp ˈbriːðɪŋ ˈɛksəsaɪzɪz əˈsɪst ɪn əˈliːvieɪtɪŋ ɪɡˌzæmɪˈneɪʃn æŋˈzaɪəti/",
      "ගැඹුරු ආශ්වාස ප්‍රශ්වාස අභ්‍යාස විභාග බිය සහ මානසික ආතතිය දුරු කිරීමට උපකාරී වේ.",
      "Advanced",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_118",
      "Always apply clean sterile bandages over minor open wounds.",
      "/ˈɔːlweɪz əˈplaɪ kliːn ˈstɛraɪl ˈbændɪdʒɪz ˈoʊvər ˈmaɪnər ˈoʊpən wuːndz/",
      "කුඩා විවෘත තුවාල මත සෑම විටම පිරිසිදු විෂබීජහරණය කළ වෙළුම් පටි යොදන්න.",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_119",
      "I am feeling much stronger and energetic after a good night's rest.",
      "/aɪ æm ˈfiːlɪŋ mʌtʃ ˈstrɒŋɡər ænd ˌɛnərˈdʒɛtɪk ˈɑːftər ə ɡʊd naɪts rɛst/",
      "හොඳ රාත්‍රී නින්දකින් පසු මට දැන් ඉතා ශක්තිමත් සහ ප්‍රබෝධමත් බවක් දැනේ.",
      "Beginner",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),
    SpokenSentencePractice(
      "sp_120",
      "Good health is our greatest wealth, so never neglect personal care.",
      "/ɡʊd hɛlθ ɪz ˈaʊər ˈɡreɪtɪst wɛlθ soʊ ˈnɛvər nɪˈɡlɛkt ˈpɜːsənl keər/",
      "නිරෝගී සුවය අප සතු උතුම්ම ධනයයි, එබැවින් පෞද්ගලික රැකවරණය කිසිවිටෙකත් නොසලකා හරින්න එපා.",
      "Intermediate",
      "සෞඛ්‍යය & වෛද්‍ය හමුව (Health & Wellness)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 7: දුරකථන & මාර්ගගත සන්නිවේදනය (121 - 140)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_121",
      "Hello, could I speak to Mr. Perera, please?",
      "/həˈloʊ kʊd aɪ spiːk tuː ˈmɪstər pəˈreərə pliːz/",
      "හෙලෝ, කරුණාකර පෙරේරා මහතා සමඟ කතා කළ හැකිද?",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_122",
      "I am afraid he is away from his desk at the moment; may I take a message?",
      "/aɪ æm əˈfreɪd hiː ɪz əˈweɪ frɒm hɪz dɛsk æt ðə ˈmoʊmənt meɪ aɪ teɪk ə ˈmɛsɪdʒ/",
      "මේ මොහොතේ ඔහු තම අසුනේ නැත; මට පණිවිඩයක් ලබා ගත හැකිද?",
      "Intermediate",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_123",
      "Your voice is breaking up slightly; could you move to an area with better coverage?",
      "/jɔːr vɔɪs ɪz ˈbreɪkɪŋ ʌp ˈslaɪtli kʊd juː muːv tuː æn ˈeəriə wɪð ˈbɛtər ˈkʌvərɪdʒ/",
      "ඔබේ කටහඬ මඳක් කැඩී කැඩී ඇසේ; ආවරණය වඩා හොඳ ප්‍රදේශයකට යා හැකිද?",
      "Intermediate",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_124",
      "I will send you the Zoom meeting link and passcode via WhatsApp.",
      "/aɪ wɪl sɛnd juː ðə zuːm ˈmiːtɪŋ lɪŋk ænd ˈpæskoʊd ˈvaɪə ˈwɒtsæp/",
      "මම WhatsApp හරහා Zoom රැස්වීමේ සබැඳිය සහ මුරපදය ඔබට එවන්නම්.",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_125",
      "Could you please mute your microphone when other participants are speaking?",
      "/kʊd juː pliːz mjuːt jɔːr ˈmaɪkrəfoʊn wɛn ˈʌðər pɑːˈtɪsɪpənts ɑːr ˈspiːkɪŋ/",
      "අනෙක් සහභාගිවන්නන් කතා කරන විට කරුණාකර ඔබගේ මයික්‍රෆෝනය නිහඬ (Mute) කරන්න.",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_126",
      "I am calling to confirm whether my registration form was received.",
      "/aɪ æm ˈkɔːlɪŋ tuː kənˈfɜːm ˈwɛðər maɪ ˌrɛdʒɪˈstreɪʃn fɔːm wɒz rɪˈsiːvd/",
      "මා ඇමතුම ගත්තේ මගේ ලියාපදිංචි පෝරමය ලැබුණේදැයි තහවුරු කර ගැනීමටයි.",
      "Intermediate",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_127",
      "Please hold the line while I transfer your call to the admissions department.",
      "/pliːz hoʊld ðə laɪn waɪl aɪ trænsˈfɜːr jɔːr kɔːl tuː ðiː ədˈmɪʃnz dɪˈpɑːtmənt/",
      "ඔබගේ ඇමතුම ඇතුළත් කිරීම් අංශයට යොමු කරන තෙක් කරුණාකර රැඳී සිටින්න.",
      "Advanced",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_128",
      "Thank you for calling our helpline; how may I assist you today?",
      "/θæŋk juː fɔːr ˈkɔːlɪŋ ˈaʊər ˈhɛlplaɪn haʊ meɪ aɪ əˈsɪst juː təˈdeɪ/",
      "අපගේ උපකාරක සේවාව ඇමතීම ගැන ස්තූතියි; අද මම ඔබට කෙසේ උපකාර කළ හැකිද?",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_129",
      "Kindly check your spam folder if the verification email does not arrive in your inbox.",
      "/ˈkaɪndli tʃɛk jɔːr spæm ˈfoʊldər ɪf ðə ˌvɛrɪfɪˈkeɪʃn ˈiːmeɪl dʌz nɒt əˈraɪv ɪn jɔːr ˈɪnbɒks/",
      "තහවුරු කිරීමේ විද්‍යුත් තැපෑල ඔබගේ Inbox වෙත නොපැමිණියේ නම් කරුණාකර Spam folder පරීක්ෂා කරන්න.",
      "Intermediate",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_130",
      "I will call you back as soon as I finish my examination paper.",
      "/aɪ wɪl kɔːl juː bæk æz suːn æz aɪ ˈfɪnɪʃ maɪ ɪɡˌzæmɪˈneɪʃn ˈpeɪpər/",
      "විභාග ප්‍රශ්න පත්‍රය අවසන් වූ වහාම මම ඔබට නැවත ඇමතුමක් ගන්නම්.",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_131",
      "Could you please share your screen so everyone can view the presentation slides?",
      "/kʊd juː pliːz ʃeər jɔːr skriːn soʊ ˈɛvriwʌn kæn vjuː ðə ˌprɛznˈteɪʃn slaɪdz/",
      "සැමට ඉදිරිපත් කිරීමේ ස්ලයිඩ බැලිය හැකි වන පරිදි කරුණාකර ඔබේ තිරය Share කළ හැකිද?",
      "Intermediate",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_132",
      "Never disclose your private passwords or OTP numbers to anyone over the phone.",
      "/ˈnɛvər dɪsˈkloʊz jɔːr ˈpraɪvət ˈpɑːswɜːdz ɔːr oʊ tiː piː ˈnʌmbərz tuː ˈɛniwʌn ˈoʊvər ðə foʊn/",
      "දුරකථනය හරහා කිසිවෙකුට ඔබගේ පුද්ගලික මුරපද හෝ OTP අංක හෙළි නොකරන්න.",
      "Advanced",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_133",
      "Sorry, you have dialed the wrong number; there is no one here by that name.",
      "/ˈsɒri juː hæv ˈdaɪəld ðə rɒŋ ˈnʌmbər ðeər ɪz noʊ wʌn hɪər baɪ ðæt neɪm/",
      "සමාවෙන්න, ඔබ වැරදි අංකයක් අමතා ඇත; ඒ නමින් කිසිවෙකු මෙහි නැත.",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_134",
      "I have attached the revised project syllabus to this email for your reference.",
      "/aɪ hæv əˈtætʃt ðə rɪˈvaɪzd ˈprɒdʒɛkt ˈsɪləbəs tuː ðɪs ˈiːmeɪl fɔːr jɔːr ˈrɛfrəns/",
      "ඔබගේ පරිශීලනය සඳහා සංශෝධිත ව්‍යාපෘති විෂය නිර්දේශය මෙම ඊමේල් පණිවිඩයට අමුණා ඇත.",
      "Advanced",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_135",
      "Can everyone hear my audio clearly or is there an echo in the background?",
      "/kæn ˈɛvriwʌn hɪər maɪ ˈɔːdioʊ ˈklɪəli ɔːr ɪz ðeər æn ˈɛkoʊ ɪn ðə ˈbækɡraʊnd/",
      "සැමට මගේ හඬ පැහැදිලිව ඇසෙනවාද නැතහොත් පසුබිමෙන් ප්‍රතිරාවයක් (Echo) ඇසෙනවාද?",
      "Intermediate",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_136",
      "I will follow up on this inquiry with a formal written confirmation tomorrow.",
      "/aɪ wɪl ˈfɒloʊ ʌp ɒn ðɪs ɪnˈkwaɪəri wɪð ə ˈfɔːməl ˈrɪtn ˌkɒnfərˈmeɪʃn təˈmɒroʊ/",
      "මෙම විමසීම පිළිබඳව හෙට දින ලිඛිත තහවුරු කිරීමක් සමඟ මම පසු විපරම් කරන්නම්.",
      "Advanced",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_137",
      "My battery is running critically low, so I might get disconnected shortly.",
      "/maɪ ˈbætəri ɪz ˈrʌnɪŋ ˈkrɪtɪkli loʊ soʊ aɪ maɪt ɡɛt ˌdɪskəˈnɛktɪd ˈʃɔːtli/",
      "මගේ බැටරිය ඉතා අඩුවෙමින් පවතින බැවින් මඳ වේලාවකින් විසන්ධි වීමට ඉඩ ඇත.",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_138",
      "Please feel free to text me if you need any additional clarification.",
      "/pliːz fiːl friː tuː tɛkst miː ɪf juː niːd ˈɛni əˈdɪʃənl ˌklærɪfɪˈkeɪʃn/",
      "ඔබට අමතර පැහැදිලි කිරීමක් අවශ්‍ය නම් මට කෙටි පණිවිඩයක් එවීමට පසුබට නොවන්න.",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_139",
      "Digital connectivity has transformed the way modern students collaborate globally.",
      "/ˈdɪdʒɪtl kəˌnɛkˈtɪvəti hæz trænsˈfɔːmd ðə weɪ ˈmɒdən ˈstjuːdənts kəˈlæbəreɪt ˈɡloʊbəli/",
      "ඩිජිටල් සබඳතාව නූතන සිසුන් ගෝලීයව එක්ව කටයුතු කරන ආකාරය පරිවර්තනය කර ඇත.",
      "Advanced",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),
    SpokenSentencePractice(
      "sp_140",
      "Thank you for your valuable time; speak to you soon!",
      "/θæŋk juː fɔːr jɔːr ˈvæljuəbl taɪm spiːk tuː juː suːn/",
      "ඔබගේ වටිනා කාලය වෙනුවෙන් ස්තූතියි; ළඟදීම නැවත කතා කරමු!",
      "Beginner",
      "දුරකථන & මාර්ගගත සන්නිවේදනය (Phone & Online)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 8: හැඟීම් & ස්තූතිය (141 - 160)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_141",
      "I am thrilled and proud to announce that our class achieved first place.",
      "/aɪ æm θrɪld ænd praʊd tuː əˈnaʊns ðæt ˈaʊər klɑːs əˈtʃiːvd fɜːst pleɪs/",
      "අපගේ පන්තිය ප්‍රථම ස්ථානය දිනාගත් බව ප්‍රකාශ කිරීමට ලැබීම ගැන මම අතිශයින් සතුටු වෙමි.",
      "Intermediate",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_142",
      "Words cannot adequately express how grateful I am for your heartfelt assistance.",
      "/wɜːdz ˈkænɒt ˈædɪkwətli ɪkˈsprɛs haʊ ˈɡreɪtfl aɪ æm fɔːr jɔːr ˈhɑːtfɛlt əˈsɪstəns/",
      "ඔබගේ හෘදයාංගම උපකාරය වෙනුවෙන් මා කොතරම් කෘතඥ වෙනවාදැයි වචනවලින් ප්‍රකාශ කළ නොහැක.",
      "Advanced",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_143",
      "Don't worry too much; everything will turn out fine in the end.",
      "/doʊnt ˈwʌri tuː mʌtʃ ˈɛvrɪθɪŋ wɪl tɜːn aʊt faɪn ɪn ðiː ɛnd/",
      "වැඩිපුර කරදර වෙන්න එපා; අවසානයේ සෑම දෙයක්ම යහපත් අතට හැරෙනු ඇත.",
      "Beginner",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_144",
      "I felt nervous before giving the speech, but I managed to speak with composure.",
      "/aɪ fɛlt ˈnɜːvəs bɪˈfɔːr ˈɡɪvɪŋ ðə spiːtʃ bʌt aɪ ˈmænɪdʒd tuː spiːk wɪð kəmˈpoʊʒər/",
      "කතාව පැවැත්වීමට පෙර මට නොසන්සුන් බවක් දැනුණද, මනාව සංසුන්ව කතා කිරීමට මට හැකි විය.",
      "Intermediate",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_145",
      "Congratulations on winning the gold medal in the hundred-meter sprint!",
      "/kənˌɡrætʃuˈleɪʃnz ɒn ˈwɪnɪŋ ðə ɡoʊld ˈmɛdl ɪn ðə ˈhʌndrəd ˈmiːtər sprɪnt/",
      "මීටර් සියය කෙටි දුර දිවීමේ ඉසව්වෙන් රන් පදක්කම දිනා ගැනීම පිළිබඳව සුබ පැතුම්!",
      "Beginner",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_146",
      "I am deeply saddened by the unfortunate news I heard this morning.",
      "/aɪ æm ˈdiːpli ˈsædnd baɪ ðiː ʌnˈfɔːtʃənət njuːz aɪ hɜːd ðɪs ˈmɔːnɪŋ/",
      "අද උදෑසන මට අසන්නට ලැබුණු අවාසනාවන්ත පුවත ගැන මම බලවත් ශෝකයට පත් වෙමි.",
      "Intermediate",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_147",
      "Stay calm, take a slow deep breath, and believe firmly in your strengths.",
      "/steɪ kɑːm teɪk ə sloʊ diːp brɛθ ænd bɪˈliːv ˈfɜːmli ɪn jɔːr strɛŋkθs/",
      "සන්සුන්ව සිටින්න, හෙමින් ගැඹුරු හුස්මක් ගන්න, සහ ඔබේ හැකියාවන් කෙරෙහි දැඩිව විශ්වාස කරන්න.",
      "Beginner",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_148",
      "In my humble opinion, honest feedback is the cornerstone of genuine improvement.",
      "/ɪn maɪ ˈhʌmbl əˈpɪnjən ˈɒnɪst ˈfiːdbæk ɪz ðə ˈkɔːnəstoʊn ɒv ˈdʒɛnjuɪn ɪmˈpruːvmənt/",
      "මගේ නිහතමානී මතය අනුව, අවංක ප්‍රතිචාර යනු සැබෑ දියුණුවේ මූලික පදනමයි.",
      "Advanced",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_149",
      "I really appreciate the warm hospitality shown by your family.",
      "/aɪ ˈrɪəli əˈpriːʃieɪt ðə wɔːm ˌhɒspɪˈtæləti ʃoʊn baɪ jɔːr ˈfæmɪli/",
      "ඔබගේ පවුලේ අය දැක්වූ උණුසුම් ආගන්තුක සත්කාරය මම ඉතා අගය කරමි.",
      "Intermediate",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_150",
      "It is normal to feel disappointed, but every setback carries an opportunity to learn.",
      "/ɪt ɪz ˈnɔːml tuː fiːl ˌdɪsəˈpɔɪntɪd bʌt ˈɛvri ˈsɛtbæk ˈkæriz æn ˌɒpəˈtjuːnəti tuː lɜːn/",
      "කලකිරීමක් දැනීම සාමාන්‍ය දෙයකි, නමුත් සෑම පසුබෑමක්ම ඉගෙනීමට නව අවස්ථාවක් ගෙන එයි.",
      "Advanced",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_151",
      "I am over the moon because I obtained an A for science!",
      "/aɪ æm ˈoʊvər ðə muːn bɪˈkəz aɪ əbˈteɪnd æn eɪ fɔːr ˈsaɪəns/",
      "විද්‍යාව විෂයට A සාමාර්ථයක් ලැබුණු නිසා මම ඉමහත් සතුටින් පසුවෙමි!",
      "Beginner",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_152",
      "Please accept my sincere apologies for the unexpected delay in my response.",
      "/pliːz əkˈsɛpt maɪ sɪnˈsɪər əˈpɒlədʒiz fɔːr ðiː ˌʌnɪkˈspɛktɪd dɪˈleɪ ɪn maɪ rɪˈspɒns/",
      "මගේ ප්‍රතිචාරයේ ඇති වූ අනපේක්ෂිත ප්‍රමාදය පිළිබඳව කරුණාකර මගේ අවංක සමාව පිළිගන්න.",
      "Advanced",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_153",
      "I am truly grateful to my dedicated teachers who tirelessly guided me.",
      "/aɪ æm ˈtruːli ˈɡreɪtfl tuː maɪ ˈdɛdɪkeɪtɪd ˈtiːtʃərz huː ˈtaɪələsli ˈɡaɪdɪd miː/",
      "වෙහෙස නොබලා මට මඟ පෙන්වූ මගේ කැපවූ ගුරුවරුන්ට මම සැබවින්ම කෘතඥ වෙමි.",
      "Intermediate",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_154",
      "Keep your spirits high, for tough times never last, but tough people do.",
      "/kiːp jɔːr ˈspɪrɪts haɪ fɔːr tʌf taɪmz ˈnɛvər lɑːst bʌt tʌf ˈpiːpl duː/",
      "ඔබේ උද්‍යෝගය ඉහළින් තබා ගන්න, මන්ද දුෂ්කර කාල සදහටම නොපවතී, නමුත් ශක්තිමත් මිනිසුන් ජය ගනී.",
      "Advanced",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_155",
      "I agree with your suggestion completely; it is practical and well-thought-out.",
      "/aɪ əˈɡriː wɪð jɔːr səˈdʒɛstʃən kəmˈpliːtli ɪt ɪz ˈpræktɪkl ænd wɛl θɔːt aʊt/",
      "මම ඔබගේ යෝජනාවට සම්පූර්ණයෙන්ම එකඟ වෙමි; එය ඉතා ප්‍රායෝගික හා හොඳින් සැලසුම් කළ එකකි.",
      "Intermediate",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_156",
      "I felt relieved when the final examination bell rang yesterday.",
      "/aɪ fɛlt rɪˈliːvd wɛn ðə ˈfaɪnl ɪɡˌzæmɪˈneɪʃn bɛl ræŋ ˈjɛstədeɪ/",
      "ඊයේ අවසන් විභාග සීනුව නාද වූ විට මට විශාල සැහැල්ලුවක් දැනුණි.",
      "Beginner",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_157",
      "Your genuine encouragement gave me the courage to participate in the English drama.",
      "/jɔːr ˈdʒɛnjuɪn ɪnˈkʌrɪdʒmənt ɡeɪv miː ðə ˈkʌrɪdʒ tuː pɑːˈtɪsɪpeɪt ɪn ðiː ˈɪŋɡlɪʃ ˈdrɑːmə/",
      "ඔබගේ අවංක ධෛර්යමත් කිරීම ඉංග්‍රීසි නාට්‍යයට සහභාගී වීමට මට මහත් ශක්තියක් ලබා දුන්නේය.",
      "Intermediate",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_158",
      "Let us celebrate our collective triumph with modesty and mutual respect.",
      "/lɛt ʌs ˈsɛlɪbreɪt ˈaʊər kəˈlɛktɪv ˈtraɪəmf wɪð ˈmɒdəsti ænd ˈmjuːtʃuəl rɪˈspɛkt/",
      "අපගේ සාමූහික ජයග්‍රහණය නිහතමානිකමෙන් හා අන්‍යෝන්‍ය ගෞරවයෙන් යුතුව සමරමු.",
      "Advanced",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_159",
      "I am astonished by the rapid technological advancements in modern Sri Lanka.",
      "/aɪ æm əˈstɒnɪʃt baɪ ðə ˈræpɪd ˌtɛknəˈlɒdʒɪkl ədˈvɑːnsmənts ɪn ˈmɒdən sriː ˈlæŋkə/",
      "නූතන ශ්‍රී ලංකාවේ වේගවත් තාක්ෂණික දියුණුව දැක මම විස්මයට පත් වෙමි.",
      "Advanced",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),
    SpokenSentencePractice(
      "sp_160",
      "Wishing you good health, prosperity, and triumphant success in all your endeavors!",
      "/ˈwɪʃɪŋ juː ɡʊd hɛlθ prɒˈspɛrəti ænd traɪˈʌmfənt səkˈsɛs ɪn ɔːl jɔːr ɪnˈdɛvərz/",
      "ඔබගේ සියලු උත්සාහයන්ට නිරෝගී සුවය, සෞභාග්‍යය සහ විශිෂ්ට ජයග්‍රහණ ප්‍රාර්ථනා කරමි!",
      "Advanced",
      "හැඟීම් & ස්තූතිය (Feelings & Gratitude)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 9: ආහාර & ආපනශාලා (161 - 180)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_161",
      "Could we please see the dinner menu and beverage list?",
      "/kʊd wiː pliːz siː ðə ˈdɪnər ˈmɛnjuː ænd ˈbɛvərɪdʒ lɪst/",
      "කරුණාකර අපට රාත්‍රී ආහාර සහ බීම වර්ග ලැයිස්තුව (Menu) ලබා දිය හැකිද?",
      "Beginner",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_162",
      "What is the special dish recommended by the chef today?",
      "/wɒt ɪz ðə ˈspɛʃl dɪʃ ˌrɛkəˈmɛndɪd baɪ ðə ʃɛf təˈdeɪ/",
      "අද ප්‍රධාන සූපවේදියා විසින් නිර්දේශ කරන විශේෂ ආහාරය කුමක්ද?",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_163",
      "I would like to order a cup of warm Ceylon black tea with ginger.",
      "/aɪ wʊd laɪk tuː ˈɔːdər ə kʌp ɒv wɔːm sɪˈlɒn blæk tiː wɪð ˈdʒɪndʒər/",
      "ඉඟුරු දැමූ උණුසුම් සිලෝන් කළු තේ කෝප්පයක් ඇනවුම් කිරීමට මම කැමැත්තෙමි.",
      "Beginner",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_164",
      "Is this vegetable curry prepared with mild or spicy seasoning?",
      "/ɪz ðɪs ˈvɛdʒtəbl ˈkʌri prɪˈpeəd wɪð maɪld ɔːr ˈspaɪsi ˈsiːznɪŋ/",
      "මෙම එළවළු ව්‍යංජනය සකස් කර ඇත්තේ සැර අඩුවෙන්ද නැතහොත් වැඩි සැරෙන්ද?",
      "Beginner",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_165",
      "Could you please ensure that no peanuts are included due to my dietary allergy?",
      "/kʊd juː pliːz ɪnˈʃʊər ðæt noʊ ˈpiːnʌts ɑːr ɪnˈkluːdɪd djuː tuː maɪ ˈdaɪətəri ˈælədʒi/",
      "මගේ ආහාර අසාත්මිකතාව නිසා රටකජු ඇතුළත් නොවන බවට කරුණාකර වග බලා ගත හැකිද?",
      "Advanced",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_166",
      "The meal was absolutely delicious and satisfying; compliments to the cook!",
      "/ðə miːl wɒz ˈæbsəluːtli dɪˈlɪʃəs ænd ˈsætɪsfaɪɪŋ ˈkɒmplɪmənts tuː ðə kʊk/",
      "ආහාර වේල ඉතා රසවත් හා තෘප්තිමත් විය; සූපවේදියාට අපගේ ප්‍රශංසාව හිමිවේ!",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_167",
      "Could we have the bill now, please?",
      "/kʊd wiː hæv ðə bɪl naʊ pliːz/",
      "කරුණාකර දැන් අපට බිල්පත ගෙනැවිත් දිය හැකිද?",
      "Beginner",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_168",
      "Do you offer vegetarian or vegan options on your lunch menu?",
      "/duː juː ˈɒfər ˌvɛdʒɪˈteəriən ɔːr ˈviːɡən ˈɒpʃnz ɒn jɔːr lʌntʃ ˈmɛnjuː/",
      "ඔබගේ දහවල් ආහාර මෙනුවේ නිර්මාංශ (Vegetarian) විකල්ප තිබේද?",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_169",
      "I prefer fresh tropical fruit juice over carbonated fizzy drinks.",
      "/aɪ prɪˈfɜːr frɛʃ ˈtrɒpɪkl fruːt dʒuːs ˈoʊvər ˈkɑːbəneɪtɪd ˈfɪzi drɪŋks/",
      "කාබනීකෘත බීම වර්ග වලට වඩා නැවුම් නිවර්තන පලතුරු යුෂ පානය කිරීමට මම වඩාත් කැමැත්තෙමි.",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_170",
      "Could you please bring us an extra glass of water and two paper napkins?",
      "/kʊd juː pliːz brɪŋ ʌs æn ˈɛkstrə ɡlɑːs ɒv ˈwɔːtər ænd tuː ˈpeɪpər ˈnæpkɪnz/",
      "කරුණාකර අපට අමතර වතුර වීදුරුවක් සහ කඩදාසි තුවා (Napkins) දෙකක් ගෙනැවිත් දිය හැකිද?",
      "Beginner",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_171",
      "Traditional Sri Lankan rice and curry is renowned for its aromatic spices.",
      "/trəˈdɪʃənl sriː ˈlæŋkən raɪs ænd ˈkʌri ɪz rɪˈnaʊnd fɔːr ɪts ˌærəˈmætɪk ˈspaɪsɪz/",
      "සාම්ප්‍රදායික ශ්‍රී ලාංකික බත් සහ ව්‍යංජන එහි සුවඳැති කුළුබඩු සඳහා ප්‍රසිද්ධය.",
      "Advanced",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_172",
      "Would you like to reserve a table for four persons this Friday evening?",
      "/wʊd juː laɪk tuː rɪˈzɜːv ə ˈteɪbl fɔːr fɔːr ˈpɜːsnz ðɪs ˈfraɪdeɪ ˈiːvnɪŋ/",
      "මේ සිකුරාදා සවස පුද්ගලයින් හතර දෙනෙකු සඳහා මේසයක් වෙන් කරවා ගැනීමට ඔබ කැමතිද?",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_173",
      "Please ensure that the soup is served piping hot.",
      "/pliːz ɪnˈʃʊər ðæt ðə suːp ɪz sɜːvd ˈpaɪpɪŋ hɒt/",
      "සුප් එක හොඳින් උණුවෙන්ම පිළිගන්වන බවට කරුණාකර වග බලා ගන්න.",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_174",
      "Can we pack the remaining food to take away?",
      "/kæn wiː pæk ðə rɪˈmeɪnɪŋ fuːd tuː teɪk əˈweɪ/",
      "ඉතිරි වූ ආහාර රැගෙන යාම සඳහා (Take away) පාර්සල් කර දිය හැකිද?",
      "Beginner",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_175",
      "Eating together as a loving family strengthens our bonds and mutual affection.",
      "/ˈiːtɪŋ təˈɡɛðər æz ə ˈlʌvɪŋ ˈfæmɪli ˈstrɛŋkθənz ˈaʊər bɒndz ænd ˈmjuːtʃuəl əˈfɛkʃn/",
      "ආදරණීය පවුලක් ලෙස එකට ආහාර ගැනීම අපගේ බැඳීම් සහ අන්‍යෝන්‍ය ආදරය ශක්තිමත් කරයි.",
      "Advanced",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_176",
      "Do you provide breakfast buffet service during the early morning hours?",
      "/duː juː prəˈvaɪd ˈbrɛkfəst ˈbʊfeɪ ˈsɜːvɪs ˈdjʊərɪŋ ðiː ˈɜːli ˈmɔːnɪŋ ˈaʊərz/",
      "උදෑසන කාලය තුළ ඔබ බුෆේ උදෑසන ආහාර සේවාවක් සපයනවාද?",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_177",
      "How would you like your eggs prepared: scrambled, boiled, or sunny side up?",
      "/haʊ wʊd juː laɪk jɔːr ɛɡz prɪˈpeəd ˈskræmbld bɔɪld ɔːr ˈsʌni saɪd ʌp/",
      "ඔබ කැමති බිත්තර කෙසේ සකස් කර ගැනීමටද: Scrambled, තම්බා, නැතහොත් බුල්සායි (Sunny side up) ලෙසද?",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_178",
      "A balanced breakfast provides essential fuel for active learning throughout the day.",
      "/ə ˈbælənst ˈbrɛkfəst prəˈvaɪdz ɪˈsɛnʃl fjuːəl fɔːr ˈæktɪv ˈlɜːnɪŋ θruːˈaʊt ðə deɪ/",
      "සමබර උදෑසන ආහාරයක් දවස පුරා ක්‍රියාශීලී ඉගෙනීම සඳහා අත්‍යවශ්‍ය ශක්තිය සපයයි.",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_179",
      "Thank you for the warm hospitality and this delightful meal!",
      "/θæŋk juː fɔːr ðə wɔːm ˌhɒspɪˈtæləti ænd ðɪs dɪˈlaɪtfl miːl/",
      "උණුසුම් ආගන්තුක සත්කාරය සහ මෙම ප්‍රණීත ආහාර වේල වෙනුවෙන් බොහොම ස්තූතියි!",
      "Beginner",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),
    SpokenSentencePractice(
      "sp_180",
      "Keep the change as a tip for your courteous and swift service.",
      "/kiːp ðə tʃeɪndʒ æz ə tɪp fɔːr jɔːr ˈkɜːtiəs ænd swɪft ˈsɜːvɪs/",
      "ඔබගේ කාරුණික සහ කඩිනම් සේවය අගයමින් ඉතිරි මුදල සතුටු පඬුරක් (Tip) ලෙස තබා ගන්න.",
      "Intermediate",
      "ආහාර & ආපනශාලා (Dining & Food)"
    ),

    // -------------------------------------------------------------
    // CATEGORY 10: අනාගත ඉලක්ක & ධෛර්යය (181 - 200)
    // -------------------------------------------------------------
    SpokenSentencePractice(
      "sp_181",
      "My ultimate aspiration is to become a software engineer and develop educational applications.",
      "/maɪ ˈʌltɪmət ˌæspəˈreɪʃn ɪz tuː bɪˈkʌm ə ˈsɒftweər ˌɛndʒɪˈnɪər ænd dɪˈvɛləp ˌɛdʒuˈkeɪʃənl ˌæplɪˈkeɪʃnz/",
      "මගේ උසස්ම බලාපොරොත්තුව වන්නේ මෘදුකාංග ඉංජිනේරුවරයෙකු වී අධ්‍යාපනික යෙදුම් නිර්මාණය කිරීමයි.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_182",
      "Consistent daily effort creates astonishing long-term results.",
      "/kənˈsɪstənt ˈdeɪli ˈɛfət kriˈeɪts əˈstɒnɪʃɪŋ ˈlɒŋ tɜːm rɪˈzʌlts/",
      "දිනපතා නොකඩවා දරන වෙහෙස දිගුකාලීනව විශ්මයජනක ප්‍රතිඵල උදා කරයි.",
      "Intermediate",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_183",
      "English proficiency unlocks limitless opportunities for higher education worldwide.",
      "/ˈɪŋɡlɪʃ prəˈfɪʃnsi ʌnˈlɒks ˈlɪmɪtlɪs ˌɒpəˈtjuːnətiz fɔːr ˈhaɪər ˌɛdʒuˈkeɪʃn ˈwɜːldwaɪd/",
      "ඉංග්‍රීසි භාෂා ප්‍රවීණතාව ලොව පුරා උසස් අධ්‍යාපනය සඳහා අප්‍රමාණ අවස්ථා විවර කරයි.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_184",
      "Never let failure deter you, because failure is the stepping stone to mastery.",
      "/ˈnɛvər lɛt ˈfeɪljər dɪˈtɜːr juː bɪˈkəz ˈfeɪljər ɪz ðə ˈstɛpɪŋ stoʊn tuː ˈmɑːstəri/",
      "අසාර්ථකත්වය ඔබව අධෛර්යමත් කිරීමට ඉඩ නොදෙන්න, මන්ද අසාර්ථකත්වය ප්‍රවීණත්වයට පියගැට පෙළයි.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_185",
      "I intend to master public speaking so I can address large audiences with poise.",
      "/aɪ ɪnˈtɛnd tuː ˈmɑːstər ˈpʌblɪk ˈspiːkɪŋ soʊ aɪ kæn əˈdrɛs lɑːdʒ ˈɔːdiənsɪz wɪð pɔɪz/",
      "මහජන කථිකත්වය ප්‍රගුණ කිරීමට මා අදහස් කරන්නේ විශාල ප්‍රේක්ෂකාගාරයක් ඉදිරියේ විශ්වාසයෙන් කතා කිරීමටයි.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_186",
      "I will dedicate three hours every evening to master mathematics and science.",
      "/aɪ wɪl ˈdɛdɪkeɪt θriː ˈaʊərz ˈɛvri ˈiːvnɪŋ tuː ˈmɑːstər ˌmæθəˈmætɪks ænd ˈsaɪəns/",
      "ගණිතය සහ විද්‍යාව විෂයන් ප්‍රගුණ කිරීමට මම සෑම සවසකම පැය තුනක් කැප කරමි.",
      "Intermediate",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_187",
      "Every champion was once a beginner who refused to quit.",
      "/ˈɛvri ˈtʃæmpiən wɒz wʌns ə bɪˈɡɪnər huː rɪˈfjuːzd tuː kwɪt/",
      "සෑම ජයග්‍රාහකයෙකුම යම් දිනක උත්සාහය අත් නොහැරි ආරම්භකයෙකු විය.",
      "Beginner",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_188",
      "Critical thinking and creativity will be the most sought-after workplace skills.",
      "/ˈkrɪtɪkl ˈθɪŋkɪŋ ænd ˌkriːeɪˈtɪvəti wɪl biː ðə moʊst sɔːt ˈɑːftər ˈwɜːkpleɪs skɪlz/",
      "විවේචනාත්මක චින්තනය සහ නිර්මාණශීලීත්වය අනාගත රැකියා ක්ෂේත්‍රයේ වඩාත්ම ඉල්ලුමක් ඇති කුසලතා වනු ඇත.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_189",
      "I dream of serving my motherland by entering the medical profession.",
      "/aɪ driːm ɒv ˈsɜːvɪŋ maɪ ˈmʌðəlænd baɪ ˈɛntərɪŋ ðə ˈmɛdɪkl prəˈfɛʃn/",
      "වෛද්‍ය ක්ෂේත්‍රයට පිවිස මගේ මව්බිමට සේවය කිරීම මගේ සිහිනයයි.",
      "Intermediate",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_190",
      "Discipline is the bridge connecting your goals to your achievements.",
      "/ˈdɪsəplɪn ɪz ðə brɪdʒ kəˈnɛktɪŋ jɔːr ɡoʊlz tuː jɔːr əˈtʃiːvmənts/",
      "විනය යනු ඔබේ ඉලක්ක සහ ඔබේ ජයග්‍රහණ යා කරන පාලමයි.",
      "Intermediate",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_191",
      "Never be intimidated by challenges; treat them as golden stepping stones.",
      "/ˈnɛvər biː ɪnˈtɪmɪdeɪtɪd baɪ ˈtʃælɪndʒɪz triːt ðɛm æz ˈɡoʊldən ˈstɛpɪŋ stoʊnz/",
      "අභියෝග හමුවේ කිසිවිටෙකත් බිය නොවන්න; ඒවා ස්වර්ණමය පියගැට පෙළවල් ලෙස සලකන්න.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_192",
      "Learning a new language opens up an entirely new window to the world.",
      "/ˈlɜːnɪŋ ə njuː ˈlæŋɡwɪdʒ ˈoʊpənz ʌp æn ɪnˈtaɪəli njuː ˈwɪndoʊ tuː ðə wɜːld/",
      "නව භාෂාවක් ඉගෙනීම ලෝකය දෙස බැලීමට සම්පූර්ණයෙන්ම නව කවුළුවක් විවර කරයි.",
      "Intermediate",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_193",
      "I am determined to pass the GCE O/L examination with outstanding distinction passes.",
      "/aɪ æm dɪˈtɜːmɪnd tuː pɑːs ðə dʒiː siː iː oʊ ɛl ɪɡˌzæmɪˈneɪʃn wɪð aʊtˈstændɪŋ dɪˈstɪŋkʃn ˈpɑːsɪz/",
      "අ.පො.ස. සාමාන්‍ය පෙළ විභාගය විශිෂ්ට සාමාර්ථ (A) සහිතව සමත් වීමට මම අධිෂ්ඨාන කරගෙන සිටිමි.",
      "Intermediate",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_194",
      "Success does not come to you; you have to step forward and achieve it.",
      "/səkˈsɛs dʌz nɒt kʌm tuː juː juː hæv tuː stɛp ˈfɔːwəd ænd əˈtʃiːv ɪt/",
      "සාර්ථකත්වය ඔබ සොයා පැමිණෙන්නේ නැත; ඔබ ඉදිරියට ගොස් එය ළඟා කරගත යුතුය.",
      "Beginner",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_195",
      "Empathy and honesty will make you a beloved and respected leader.",
      "/ˈɛmpəθi ænd ˈɒnɪsti wɪl meɪk juː ə bɪˈlʌvɪd ænd rɪˈspɛktɪd ˈliːdər/",
      "සංවේදීබව සහ අවංකභාවය ඔබව සැමගේ ආදරය හා ගෞරවය දිනූ නායකයෙකු බවට පත් කරනු ඇත.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_196",
      "Self-belief is the secret ignition key to extraordinary human accomplishments.",
      "/sɛlf bɪˈliːf ɪz ðə ˈsiːkrət ɪɡˈnɪʃn kiː tuː ɪkˈstrɔːdnri ˈhjuːmən əˈkɒmplɪʃmənts/",
      "ආත්ම විශ්වාසය යනු අසාමාන්‍ය මානව ජයග්‍රහණ සඳහා රහස් ආරම්භක යතුරයි.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_197",
      "I make it a daily habit to read motivational biographies of great scientists and thinkers.",
      "/aɪ meɪk ɪt ə ˈdeɪli ˈhæbɪt tuː riːd ˌmoʊtɪˈveɪʃənl baɪˈɒɡrəfiz ɒv ɡreɪt ˈsaɪəntɪsts ænd ˈθɪŋkərz/",
      "ශ්‍රේෂ්ඨ විද්‍යාඥයින්ගේ සහ චින්තකයින්ගේ චරිතාපදාන කියවීම මම දිනපතා පුරුද්දක් කරගෙන සිටිමි.",
      "Intermediate",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_198",
      "Believe in your infinite potential, work relentlessly, and never surrender.",
      "/bɪˈliːv ɪn jɔːr ˈɪnfɪnət pəˈtɛnʃl wɜːk rɪˈlɛntlɪsli ænd ˈnɛvər səˈrɛndər/",
      "ඔබේ අපරිමිත හැකියාව විශ්වාස කරන්න, නොනවත්වා වැඩ කරන්න, සහ කිසිවිටෙකත් පරාජය භාර නොගන්න.",
      "Advanced",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_199",
      "Small daily improvements over time lead to stunning results.",
      "/smɔːl ˈdeɪli ɪmˈpruːvmənts ˈoʊvər taɪm liːd tuː ˈstʌnɪŋ rɪˈzʌlts/",
      "කාලයත් සමඟ දිනපතා සිදුකරන කුඩා දියුණු කිරීම් විස්මිත ප්‍රතිඵල අත්කර දෙයි.",
      "Beginner",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    ),
    SpokenSentencePractice(
      "sp_200",
      "Today's diligent preparation is tomorrow's guaranteed victory!",
      "/təˈdeɪz ˈdɪlɪdʒənt ˌprɛpəˈreɪʃn ɪz təˈmɒroʊz ˌɡærənˈtiːd ˈvɪktəri/",
      "අද දින දරන කැපවීමෙන් යුත් සූදානම හෙට දවසේ සහතික කළ විජයග්‍රහණයයි!",
      "Intermediate",
      "අනාගත ඉලක්ක & ධෛර්යය (Ambition & Motivation)"
    )
  )
}
