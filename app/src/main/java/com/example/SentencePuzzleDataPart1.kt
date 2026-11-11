package com.example

object SentencePuzzleDataPart1 {
  fun getCategoriesPart1(): List<SentencePuzzleCategory> {
    return listOf(
      // ==========================================
      // Category 1: Simple Present Tense & Daily Routines (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 1,
        titleSinhala = "කාණ්ඩය 01: සරල වර්තමාන කාලය සහ දෛනික පුරුදු",
        titleEnglish = "Simple Present Tense & Daily Routines",
        icon = "🌅",
        description = "දෛනික ජීවිතයේ පුරුදු, නිරන්තරයෙන් සිදුවන ක්‍රියා සහ සත්‍ය කරුණු සඳහා වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c1_p1",
            scrambledWords = listOf("every", "wakes", "at", "She", "up", "morning", "6.00"),
            correctSentence = "She wakes up at 6.00 every morning.",
            sinhalaMeaning = "ඇය සෑම උදෑසනකම 6.00 ට අවදි වෙයි.",
            hint = "Subject (She) + Singular Verb (wakes up) + Time phrase."
          ),
          SentencePuzzleItem(
            id = "c1_p2",
            scrambledWords = listOf("water", "drink", "warm", "I", "a", "morning", "of", "glass", "every"),
            correctSentence = "I drink a glass of warm water every morning.",
            sinhalaMeaning = "මම සෑම උදෑසනකම උණුසුම් වතුර වීදුරුවක් බොනවා.",
            hint = "Subject + Verb + Object phrase + Adverbial of time."
          ),
          SentencePuzzleItem(
            id = "c1_p3",
            scrambledWords = listOf("his", "Kasun", "carefully", "teeth", "brushes", "meals", "after"),
            correctSentence = "Kasun brushes his teeth carefully after meals.",
            sinhalaMeaning = "කසුන් ආහාර ගැනීමෙන් පසු සැලකිලිමත්ව දත් මදියි.",
            hint = "Subject (Kasun) + Verb (brushes) + Object + Adverb."
          ),
          SentencePuzzleItem(
            id = "c1_p4",
            scrambledWords = listOf("rises", "in", "sun", "The", "east", "the", "always"),
            correctSentence = "The sun always rises in the east.",
            sinhalaMeaning = "සූර්යයා සැමවිටම නැගෙනහිරින් උදා වෙයි.",
            hint = "Universal truth: Subject + Frequency adverb + Verb + Prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c1_p5",
            scrambledWords = listOf("to", "school", "by", "bus", "travel", "Students", "daily"),
            correctSentence = "Students travel to school by bus daily.",
            sinhalaMeaning = "සිසුන් දිනපතා බස් රථයෙන් පාසල් යයි.",
            hint = "Plural subject (Students) + Base verb (travel) + Direction + Mode of travel."
          ),
          SentencePuzzleItem(
            id = "c1_p6",
            scrambledWords = listOf("prepares", "delicious", "Mother", "breakfast", "our", "kitchen", "in", "the"),
            correctSentence = "Mother prepares delicious breakfast in our kitchen.",
            sinhalaMeaning = "අම්මා අපේ කුස්සියේ රසවත් උදෑසන ආහාර පිළියෙල කරයි.",
            hint = "Singular subject + prepares + adjective + noun + location."
          ),
          SentencePuzzleItem(
            id = "c1_p7",
            scrambledWords = listOf("newspaper", "My", "reads", "father", "tea", "having", "while"),
            correctSentence = "My father reads newspaper while having tea.",
            sinhalaMeaning = "මගේ පියා තේ බොන අතරතුර පුවත්පත කියවයි.",
            hint = "Clause 1 + connector (while) + participle clause."
          ),
          SentencePuzzleItem(
            id = "c1_p8",
            scrambledWords = listOf("dogs", "loudly", "The", "bark", "strangers", "at", "night", "at"),
            correctSentence = "The dogs bark loudly at strangers at night.",
            sinhalaMeaning = "රාත්‍රියේදී සුනඛයන් ආගන්තුකයන්ට හයියෙන් බුරයි.",
            hint = "Subject (The dogs) + Verb (bark) + Adverb (loudly) + Objects."
          ),
          SentencePuzzleItem(
            id = "c1_p9",
            scrambledWords = listOf("her", "exercises", "regularly", "keep", "fit", "She", "to"),
            correctSentence = "She exercises regularly to keep her fit.",
            sinhalaMeaning = "නිරෝගීව සිටීම සඳහා ඇය නිතිපතා ව්‍යායාම කරයි.",
            hint = "Subject + Verb + Adverb + Infinitive of purpose (to keep...)."
          ),
          SentencePuzzleItem(
            id = "c1_p10",
            scrambledWords = listOf("leaves", "train", "The", "platform", "the", "from", "at", "7.30"),
            correctSentence = "The train leaves from the platform at 7.30.",
            sinhalaMeaning = "දුම්රිය උදෑසන 7.30 ට වේදිකාවෙන් පිටත් වේ.",
            hint = "Scheduled future/routine event using Present Simple."
          ),
          SentencePuzzleItem(
            id = "c1_p11",
            scrambledWords = listOf("library", "visit", "We", "the", "Friday", "every", "books", "borrow", "to"),
            correctSentence = "We visit the library every Friday to borrow books.",
            sinhalaMeaning = "පොත් ලබාගැනීම සඳහා අපි සෑම සිකුරාදාවකම පුස්තකාලයට යන්නෙමු.",
            hint = "Subject + Verb + Object + Time adverbial + Purpose phrase."
          ),
          SentencePuzzleItem(
            id = "c1_p12",
            scrambledWords = listOf("plays", "guitar", "brother", "My", "in", "evening", "the"),
            correctSentence = "My brother plays guitar in the evening.",
            sinhalaMeaning = "මගේ සහෝදරයා සවස් කාලයේ ගිටාරය වාදනය කරයි.",
            hint = "Third person singular takes 'plays'."
          ),
          SentencePuzzleItem(
            id = "c1_p13",
            scrambledWords = listOf("help", "always", "Good", "their", "friends", "trouble", "in", "classmates"),
            correctSentence = "Good classmates always help their friends in trouble.",
            sinhalaMeaning = "හොඳ පන්ති සගයන් කරදරයක වැටුණු තම මිතුරන්ට සැමවිටම උදව් කරයි.",
            hint = "Plural subject + Adverb of frequency (always) + Base verb (help)."
          ),
          SentencePuzzleItem(
            id = "c1_p14",
            scrambledWords = listOf("honey", "Bees", "produce", "flowers", "nectar", "from", "sweet"),
            correctSentence = "Bees produce sweet honey from flowers nectar.",
            sinhalaMeaning = "මීමැස්සන් මල් පැණිවලින් මිහිරි මීපැණි නිෂ්පාදනය කරයි.",
            hint = "General fact: Subject + Verb + Adjective + Object + Source."
          ),
          SentencePuzzleItem(
            id = "c1_p15",
            scrambledWords = listOf("eats", "Kamal", "rarely", "junk", "food", "outside"),
            correctSentence = "Kamal rarely eats junk food outside.",
            sinhalaMeaning = "කමල් පිටතින් කඩචෝරු/අහිතකර ආහාර කන්නේ කලාතුරකිනි.",
            hint = "Negative adverb of frequency (rarely) placed before main verb."
          ),
          SentencePuzzleItem(
            id = "c1_p16",
            scrambledWords = listOf("teaches", "grammar", "teacher", "Our", "clearly", "English", "very"),
            correctSentence = "Our English teacher teaches grammar very clearly.",
            sinhalaMeaning = "අපගේ ඉංග්‍රීසි ගුරුතුමා ව්‍යාකරණ ඉතා පැහැදිලිව උගන්වයි.",
            hint = "Subject + Verb (teaches) + Object (grammar) + Adverb phrase."
          ),
          SentencePuzzleItem(
            id = "c1_p17",
            scrambledWords = listOf("sleeps", "cat", "The", "peacefully", "under", "warm", "the", "chair"),
            correctSentence = "The cat sleeps peacefully under the warm chair.",
            sinhalaMeaning = "පූසා උණුසුම් පුටුව යට සාමකාමීව නිදාගනියි.",
            hint = "Subject + Verb + Adverb of manner + Prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c1_p18",
            scrambledWords = listOf("oxygen", "Trees", "provide", "all", "living", "beings", "for"),
            correctSentence = "Trees provide oxygen for all living beings.",
            sinhalaMeaning = "ගස්වැල් සියලුම ජීවීන් සඳහා ඔක්සිජන් සපයයි.",
            hint = "General statement: Plural noun + provide + noun + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c1_p19",
            scrambledWords = listOf("practices", "speech", "Nimal", "his", "mirror", "the", "front", "in", "of"),
            correctSentence = "Nimal practices his speech in front of the mirror.",
            sinhalaMeaning = "නිමාල් කණ්ණාඩිය ඉදිරිපිට තම කතාව පුහුණු වෙයි.",
            hint = "Subject + Verb + Object + Complex preposition (in front of)."
          ),
          SentencePuzzleItem(
            id = "c1_p20",
            scrambledWords = listOf("set", "Stars", "glow", "night", "at", "when", "sun", "the", "does"),
            correctSentence = "Stars glow at night when the sun does set.",
            sinhalaMeaning = "හිරු බැස ගිය පසු රාත්‍රියේ තරු බබළයි.",
            hint = "Main clause (Stars glow at night) + Time clause."
          )
        )
      ),

      // ==========================================
      // Category 2: Present Continuous Tense (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 2,
        titleSinhala = "කාණ්ඩය 02: වර්තමාන අඛණ්ඩ කාලය (Present Continuous)",
        titleEnglish = "Present Continuous Tense",
        icon = "⏳",
        description = "මේ මොහොතේ සිදුවෙමින් පවතින ක්‍රියා විස්තර කරන අත්‍යවශ්‍ය වාක්‍ය රටා 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c2_p1",
            scrambledWords = listOf("exam", "preparing", "students", "are", "The", "for", "the", "now"),
            correctSentence = "The students are preparing for the exam now.",
            sinhalaMeaning = "සිසුන් දැන් විභාගය සඳහා සූදානම් වෙමින් සිටිති.",
            hint = "Subject (The students) + are + V-ing (preparing) + time."
          ),
          SentencePuzzleItem(
            id = "c2_p2",
            scrambledWords = listOf("is", "raining", "It", "heavily", "outside", "moment", "the", "at"),
            correctSentence = "It is raining heavily outside at the moment.",
            sinhalaMeaning = "මේ මොහොතේ පිටත තද වැසි ඇදහැලෙමින් පවතී.",
            hint = "Impersonal subject 'It' + is + raining + heavily."
          ),
          SentencePuzzleItem(
            id = "c2_p3",
            scrambledWords = listOf("reading", "She", "story", "an", "is", "interesting", "book"),
            correctSentence = "She is reading an interesting story book.",
            sinhalaMeaning = "ඇය රසවත් කතන්දර පොතක් කියවමින් සිටියි.",
            hint = "Subject (She) + is + reading + adjective + noun."
          ),
          SentencePuzzleItem(
            id = "c2_p4",
            scrambledWords = listOf("cricket", "boys", "playground", "The", "playing", "are", "in", "the"),
            correctSentence = "The boys are playing cricket in the playground.",
            sinhalaMeaning = "පිරිමි ළමයි ක්‍රීඩා පිටියේ ක්‍රිකට් ක්‍රීඩා කරමින් සිටිති.",
            hint = "Plural subject + are + playing + object + place."
          ),
          SentencePuzzleItem(
            id = "c2_p5",
            scrambledWords = listOf("am", "I", "letter", "writing", "a", "principal", "to", "the"),
            correctSentence = "I am writing a letter to the principal.",
            sinhalaMeaning = "මම විදුහල්පතිතුමාට ලිපියක් ලියමින් සිටිමි.",
            hint = "I + am + writing + object + recipient."
          ),
          SentencePuzzleItem(
            id = "c2_p6",
            scrambledWords = listOf("cooking", "dinner", "Mother", "is", "family", "the", "for"),
            correctSentence = "Mother is cooking dinner for the family.",
            sinhalaMeaning = "අම්මා පවුලේ අය වෙනුවෙන් රාත්‍රී ආහාරය පිසිමින් සිටියි.",
            hint = "Subject + is cooking + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c2_p7",
            scrambledWords = listOf("listening", "carefully", "They", "are", "announcement", "to", "the"),
            correctSentence = "They are listening carefully to the announcement.",
            sinhalaMeaning = "ඔවුන් නිවේදනයට ඉතා අවධානයෙන් සවන් දෙමින් සිටිති.",
            hint = "They + are listening + adverb + to + noun."
          ),
          SentencePuzzleItem(
            id = "c2_p8",
            scrambledWords = listOf("fixing", "father", "is", "broken", "My", "bicycle", "the"),
            correctSentence = "My father is fixing the broken bicycle.",
            sinhalaMeaning = "මගේ පියා කැඩුණු පාපැදිය අලුත්වැඩියා කරමින් සිටියි.",
            hint = "Subject + is fixing + adjective (broken) + object."
          ),
          SentencePuzzleItem(
            id = "c2_p9",
            scrambledWords = listOf("learning", "We", "new", "words", "are", "English", "today"),
            correctSentence = "We are learning new English words today.",
            sinhalaMeaning = "අපි අද අලුත් ඉංග්‍රීසි වචන ඉගෙන ගනිමින් සිටිමු.",
            hint = "We + are learning + adjective phrase + time."
          ),
          SentencePuzzleItem(
            id = "c2_p10",
            scrambledWords = listOf("chirping", "Birds", "sweetly", "are", "morning", "in", "trees", "the"),
            correctSentence = "Birds are chirping sweetly in the morning trees.",
            sinhalaMeaning = "උදෑසන ගස්වල කුරුල්ලන් මිහිරි හඬින් නාද කරමින් සිටිති.",
            hint = "Subject (Birds) + are chirping + adverb + location."
          ),
          SentencePuzzleItem(
            id = "c2_p11",
            scrambledWords = listOf("painting", "artist", "The", "landscape", "is", "beautiful", "a"),
            correctSentence = "The artist is painting a beautiful landscape.",
            sinhalaMeaning = "චිත්‍ර ශිල්පියා අලංකාර භූමි දර්ශනයක් පින්තාරු කරමින් සිටියි.",
            hint = "The artist + is painting + article + adj + noun."
          ),
          SentencePuzzleItem(
            id = "c2_p12",
            scrambledWords = listOf("decorating", "classroom", "children", "The", "are", "their", "festival", "for"),
            correctSentence = "The children are decorating their classroom for festival.",
            sinhalaMeaning = "ළමයින් උත්සවය සඳහා ඔවුන්ගේ පන්ති කාමරය සරසමින් සිටිති.",
            hint = "Plural subject + are decorating + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c2_p13",
            scrambledWords = listOf("explaining", "teacher", "is", "sum", "The", "maths", "difficult", "a"),
            correctSentence = "The teacher is explaining a difficult maths sum.",
            sinhalaMeaning = "ගුරුතුමා අමාරු ගණිත ගැටලුවක් පැහැදිලි කරමින් සිටියි.",
            hint = "The teacher + is explaining + object."
          ),
          SentencePuzzleItem(
            id = "c2_p14",
            scrambledWords = listOf("driving", "carefully", "He", "is", "road", "foggy", "on", "the"),
            correctSentence = "He is driving carefully on the foggy road.",
            sinhalaMeaning = "ඔහු මීදුම පිරි මාර්ගයේ ප්‍රවේශමෙන් රිය පදවමින් සිටියි.",
            hint = "He + is driving + manner adverb + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c2_p15",
            scrambledWords = listOf("watering", "plants", "gardener", "The", "is", "flower", "fresh", "the"),
            correctSentence = "The gardener is watering the fresh flower plants.",
            sinhalaMeaning = "වතු පාලකයා නැවුම් මල් පැලවලට වතුර දමමින් සිටියි.",
            hint = "The gardener + is watering + compound noun."
          ),
          SentencePuzzleItem(
            id = "c2_p16",
            scrambledWords = listOf("discussing", "topic", "project", "are", "They", "group", "their"),
            correctSentence = "They are discussing their group project topic.",
            sinhalaMeaning = "ඔවුන් තම කණ්ඩායම් ව්‍යාපෘතියේ මාතෘකාව සාකච්ඡා කරමින් සිටිති.",
            hint = "They + are discussing + possessive object phrase."
          ),
          SentencePuzzleItem(
            id = "c2_p17",
            scrambledWords = listOf("shining", "brightly", "sun", "is", "The", "sky", "in", "the"),
            correctSentence = "The sun is shining brightly in the sky.",
            sinhalaMeaning = "අහසේ හිරු දීප්තිමත්ව බබළමින් පවතී.",
            hint = "The sun + is shining + adverb + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c2_p18",
            scrambledWords = listOf("waiting", "bus", "passengers", "for", "are", "The", "station", "at", "the"),
            correctSentence = "The passengers are waiting for the bus at station.",
            sinhalaMeaning = "මගීන් නැවතුමේ බස් රථය එනතුරු බලා සිටිති.",
            hint = "Subject + are waiting + for + object + at station."
          ),
          SentencePuzzleItem(
            id = "c2_p19",
            scrambledWords = listOf("working", "hard", "computer", "on", "is", "his", "Nuwan"),
            correctSentence = "Nuwan is working hard on his computer.",
            sinhalaMeaning = "නුවන් තම පරිගණකයේ මහන්සි වී වැඩ කරමින් සිටියි.",
            hint = "Nuwan + is working + adverb (hard) + on his computer."
          ),
          SentencePuzzleItem(
            id = "c2_p20",
            scrambledWords = listOf("practicing", "choir", "song", "school", "The", "is", "anthem", "national"),
            correctSentence = "The school choir is practicing national anthem song.",
            sinhalaMeaning = "පාසල් ගායන කණ්ඩායම ජාතික ගීය පුහුණු වෙමින් සිටියි.",
            hint = "Collective singular noun + is practicing + object."
          )
        )
      ),

      // ==========================================
      // Category 3: Simple Past Tense & Historical Events (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 3,
        titleSinhala = "කාණ්ඩය 03: සරල අතීත කාලය සහ ඓතිහාසික සිදුවීම්",
        titleEnglish = "Simple Past Tense & Historical Memories",
        icon = "📜",
        description = "අතීතයේ අවසන් වූ සිදුවීම් සහ අතීත ක්‍රියාපද (V2) භාවිතය සඳහා ප්‍රශ්න 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c3_p1",
            scrambledWords = listOf("visited", "ancient", "city", "We", "Anuradhapura", "of", "the", "vacation", "last"),
            correctSentence = "We visited the ancient city of Anuradhapura last vacation.",
            sinhalaMeaning = "අපි පසුගිය නිවාඩුවේදී අනුරාධපුර ඓතිහාසික නගරයට ගියෙමු.",
            hint = "Subject + Past verb (visited) + Object + Past time expression."
          ),
          SentencePuzzleItem(
            id = "c3_p2",
            scrambledWords = listOf("Sigiriya", "King", "built", "magnificent", "Kashyapa", "rock", "fortress", "the"),
            correctSentence = "King Kashyapa built the magnificent Sigiriya rock fortress.",
            sinhalaMeaning = "කාශ්‍යප රජතුමා අලංකාර සීගිරි පර්වත බලකොටුව ගොඩනැගුවේය.",
            hint = "Subject (King Kashyapa) + Past verb (built) + Object."
          ),
          SentencePuzzleItem(
            id = "c3_p3",
            scrambledWords = listOf("won", "match", "our", "Yesterday", "cricket", "school", "team", "the"),
            correctSentence = "Yesterday our school cricket team won the match.",
            sinhalaMeaning = "ඊයේ අපගේ පාසල් ක්‍රිකට් කණ්ඩායම තරගය ජයග්‍රහණය කළේය.",
            hint = "Time phrase + Subject + Past verb (won) + Object."
          ),
          SentencePuzzleItem(
            id = "c3_p4",
            scrambledWords = listOf("invented", "Alexander", "telephone", "Graham", "first", "Bell", "the"),
            correctSentence = "Alexander Graham Bell invented the first telephone.",
            sinhalaMeaning = "ඇලෙක්සැන්ඩර් ග්‍රැහැම් බෙල් පළමු දුරකථනය සොයා ගත්තේය.",
            hint = "Person + Past verb (invented) + Object."
          ),
          SentencePuzzleItem(
            id = "c3_p5",
            scrambledWords = listOf("wrote", "poet", "famous", "The", "inspiring", "an", "poem"),
            correctSentence = "The famous poet wrote an inspiring poem.",
            sinhalaMeaning = "ප්‍රකට කවියා උද්යෝගිමත් කවියක් ලිව්වේය.",
            hint = "Subject + Past verb (wrote) + Object."
          ),
          SentencePuzzleItem(
            id = "c3_p6",
            scrambledWords = listOf("planted", "students", "hundred", "The", "trees", "yesterday"),
            correctSentence = "The students planted hundred trees yesterday.",
            sinhalaMeaning = "සිසුන් ඊයේ ගස් සියයක් පැළ කළහ.",
            hint = "Subject + planted + quantity + noun + time."
          ),
          SentencePuzzleItem(
            id = "c3_p7",
            scrambledWords = listOf("left", "for", "Colombo", "morning", "uncle", "My", "early"),
            correctSentence = "My uncle left for Colombo early morning.",
            sinhalaMeaning = "මගේ මාමා පාන්දරින්ම කොළඹ බලා පිටත්ව ගියේය.",
            hint = "Subject + left for (destination) + time phrase."
          ),
          SentencePuzzleItem(
            id = "c3_p8",
            scrambledWords = listOf("gave", "grandma", "me", "birthday", "gift", "My", "special", "a"),
            correctSentence = "My grandma gave me a special birthday gift.",
            sinhalaMeaning = "මගේ ආච්චි මට විශේෂ උපන්දින තෑග්ගක් දුන්නාය.",
            hint = "Subject + Ditransitive verb (gave) + Indirect object (me) + Direct object."
          ),
          SentencePuzzleItem(
            id = "c3_p9",
            scrambledWords = listOf("completed", "she", "assignments", "all", "her", "deadline", "before", "the"),
            correctSentence = "She completed all her assignments before the deadline.",
            sinhalaMeaning = "ඇය නියමිත කාලසීමාවට පෙර සියලුම පැවරුම් සම්පූර්ණ කළාය.",
            hint = "Subject + completed + object + prepositional time phrase."
          ),
          SentencePuzzleItem(
            id = "c3_p10",
            scrambledWords = listOf("broke", "wind", "strong", "The", "old", "mango", "branch", "tree"),
            correctSentence = "The strong wind broke old mango tree branch.",
            sinhalaMeaning = "තද සුළඟින් පැරණි අඹ ගසේ අත්තක් කැඩී ගියේය.",
            hint = "Subject + broke + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c3_p11",
            scrambledWords = listOf("bought", "father", "new", "computer", "my", "me", "for"),
            correctSentence = "My father bought a new computer for me.",
            sinhalaMeaning = "මගේ පියා මට අලුත් පරිගණකයක් මිලදී ගෙන දුන්නේය.",
            hint = "Subject + bought + object + for me."
          ),
          SentencePuzzleItem(
            id = "c3_p12",
            scrambledWords = listOf("saw", "wild", "in", "elephants", "park", "We", "national", "the"),
            correctSentence = "We saw wild elephants in the national park.",
            sinhalaMeaning = "අපි ජාතික වනෝද්‍යානයේදී වන අලින් දුටුවෙමු.",
            hint = "Subject + saw + object + place."
          ),
          SentencePuzzleItem(
            id = "c3_p13",
            scrambledWords = listOf("passed", "with", "Kasuni", "exam", "flying", "her", "colours"),
            correctSentence = "Kasuni passed her exam with flying colours.",
            sinhalaMeaning = "කසුනි විශිෂ්ට ලෙස ඇගේ විභාගය සමත් වූවාය.",
            hint = "Idiom: passed ... with flying colours."
          ),
          SentencePuzzleItem(
            id = "c3_p14",
            scrambledWords = listOf("celebrated", "Sri", "Independence", "Lanka", "Day", "February", "in"),
            correctSentence = "Sri Lanka celebrated Independence Day in February.",
            sinhalaMeaning = "ශ්‍රී ලංකාව පෙබරවාරි මාසයේදී නිදහස් දිනය සැමරුවේය.",
            hint = "Country name + celebrated + holiday + month."
          ),
          SentencePuzzleItem(
            id = "c3_p15",
            scrambledWords = listOf("caught", "police", "thief", "brave", "The", "the", "quickly"),
            correctSentence = "The brave police caught the thief quickly.",
            sinhalaMeaning = "නිර්භීත පොලිසිය හොරා කඩිනමින් අල්ලා ගත්තේය.",
            hint = "Subject + irregular past verb (caught) + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c3_p16",
            scrambledWords = listOf("arrived", "late", "because", "due", "train", "The", "rain", "heavy", "to"),
            correctSentence = "The train arrived late due to heavy rain.",
            sinhalaMeaning = "තද වැස්ස හේතුවෙන් දුම්රිය ප්‍රමාද වී පැමිණියේය.",
            hint = "Subject + arrived late + cause phrase (due to...)."
          ),
          SentencePuzzleItem(
            id = "c3_p17",
            scrambledWords = listOf("cleaned", "room", "his", "Sunday", "on", "thoroughly", "Kamal"),
            correctSentence = "Kamal cleaned his room thoroughly on Sunday.",
            sinhalaMeaning = "කමල් ඉරිදා දින තම කාමරය හොඳින් පිරිසිදු කළේය.",
            hint = "Subject + cleaned + object + adverb + day."
          ),
          SentencePuzzleItem(
            id = "c3_p18",
            scrambledWords = listOf("taught", "us", "kind", "lesson", "valuable", "teacher", "Our", "a"),
            correctSentence = "Our kind teacher taught us a valuable lesson.",
            sinhalaMeaning = "අපගේ කාරුණික ගුරුතුමා අපට වටිනා පාඩමක් කියා දුන්නේය.",
            hint = "Subject + taught (past of teach) + us + direct object."
          ),
          SentencePuzzleItem(
            id = "c3_p19",
            scrambledWords = listOf("lost", "way", "the", "forest", "dark", "in", "They", "their"),
            correctSentence = "They lost their way in the dark forest.",
            sinhalaMeaning = "ඔවුන් අඳුරු වනාන්තරයේදී මඟ අහිමි කර ගත්හ.",
            hint = "They + lost their way + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c3_p20",
            scrambledWords = listOf("sang", "sweetly", "girl", "little", "The", "stage", "on", "the"),
            correctSentence = "The little girl sang sweetly on the stage.",
            sinhalaMeaning = "පුංචි දැරිය වේදිකාව මත මිහිරි ලෙස ගීතයක් ගැයුවාය.",
            hint = "Subject + past verb (sang) + adverb + location."
          )
        )
      ),

      // ==========================================
      // Category 4: Past Continuous Tense (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 4,
        titleSinhala = "කාණ්ඩය 04: අතීත අඛණ්ඩ කාලය (Past Continuous)",
        titleEnglish = "Past Continuous Tense",
        icon = "⌛",
        description = "අතීතයේ යම් වේලාවක සිදුවෙමින් පැවති ක්‍රියා (was/were + verb-ing) සඳහා වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c4_p1",
            scrambledWords = listOf("studying", "was", "lights", "went", "Kamal", "when", "the", "out"),
            correctSentence = "Kamal was studying when the lights went out.",
            sinhalaMeaning = "විදුලිය විසන්ධි වන විට කමල් පාඩම් කරමින් සිටියේය.",
            hint = "Continuous background action (was studying) + interrupted by past simple."
          ),
          SentencePuzzleItem(
            id = "c4_p2",
            scrambledWords = listOf("were", "playing", "rain", "started", "They", "football", "when", "the"),
            correctSentence = "They were playing football when the rain started.",
            sinhalaMeaning = "වැස්ස පටන් ගන්නා විට ඔවුන් පාපන්දු ක්‍රීඩා කරමින් සිටියහ.",
            hint = "Plural subject + were playing + when clause."
          ),
          SentencePuzzleItem(
            id = "c4_p3",
            scrambledWords = listOf("was", "walking", "found", "purse", "She", "home", "when", "she", "the"),
            correctSentence = "She was walking home when she found the purse.",
            sinhalaMeaning = "ඇය නිවස බලා ඇවිද යන විට ඇයට පසුම්බිය හමුවිය.",
            hint = "was walking + home + when she found..."
          ),
          SentencePuzzleItem(
            id = "c4_p4",
            scrambledWords = listOf("cooking", "Mother", "was", "rang", "phone", "while", "the"),
            correctSentence = "Mother was cooking while the phone rang.",
            sinhalaMeaning = "දුරකථනය නාද වන විට මව ආහාර පිසිමින් සිටියාය.",
            hint = "Mother was cooking + time clause."
          ),
          SentencePuzzleItem(
            id = "c4_p5",
            scrambledWords = listOf("were", "watching", "at", "television", "We", "yesterday", "8.00", "p.m."),
            correctSentence = "We were watching television at 8.00 p.m. yesterday.",
            sinhalaMeaning = "ඊයේ රාත්‍රී 8.00 ට අපි රූපවාහිනිය නරඹමින් සිටියෙමු.",
            hint = "Specific past time point: We were watching..."
          ),
          SentencePuzzleItem(
            id = "c4_p6",
            scrambledWords = listOf("sleeping", "dog", "The", "was", "doorstep", "on", "the"),
            correctSentence = "The dog was sleeping on the doorstep.",
            sinhalaMeaning = "බල්ලා දොරකඩ නිදාගනිමින් සිටියේය.",
            hint = "Subject + was sleeping + place."
          ),
          SentencePuzzleItem(
            id = "c4_p7",
            scrambledWords = listOf("working", "were", "farmers", "hot", "field", "in", "The", "sun", "the"),
            correctSentence = "The farmers were working in the hot sun field.",
            sinhalaMeaning = "ගොවීන් උණුසුම් අව්වේ කෙතේ වැඩ කරමින් සිටියහ.",
            hint = "Plural noun + were working + place."
          ),
          SentencePuzzleItem(
            id = "c4_p8",
            scrambledWords = listOf("writing", "was", "teacher", "board", "on", "the", "The", "notes"),
            correctSentence = "The teacher was writing notes on the board.",
            sinhalaMeaning = "ගුරුතුමා කළු ලෑල්ලේ සටහන් ලියමින් සිටියේය.",
            hint = "Subject + was writing + object + location."
          ),
          SentencePuzzleItem(
            id = "c4_p9",
            scrambledWords = listOf("shining", "brightly", "stars", "were", "The", "midnight", "at"),
            correctSentence = "The stars were shining brightly at midnight.",
            sinhalaMeaning = "මධ්‍යම රාත්‍රියේදී තරු දීප්තිමත්ව බබළමින් පැවතුණි.",
            hint = "Subject + were shining + adverb + time."
          ),
          SentencePuzzleItem(
            id = "c4_p10",
            scrambledWords = listOf("reading", "I", "novel", "was", "a", "afternoon", "all"),
            correctSentence = "I was reading a novel all afternoon.",
            sinhalaMeaning = "මම සවස් වරුව පුරාම නවකතාවක් කියවමින් සිටියෙමි.",
            hint = "I was reading + object + duration (all afternoon)."
          ),
          SentencePuzzleItem(
            id = "c4_p11",
            scrambledWords = listOf("waiting", "They", "for", "were", "station", "train", "at", "the"),
            correctSentence = "They were waiting for the train at station.",
            sinhalaMeaning = "ඔවුන් දුම්රිය ස්ථානයේ දුම්රිය එනතුරු බලා සිටියහ.",
            hint = "They were waiting + for train + at station."
          ),
          SentencePuzzleItem(
            id = "c4_p12",
            scrambledWords = listOf("driving", "father", "carefully", "My", "was", "narrow", "road", "on"),
            correctSentence = "My father was driving carefully on narrow road.",
            sinhalaMeaning = "මගේ පියා පටු පාරේ ප්‍රවේශමෙන් රිය පදවමින් සිටියේය.",
            hint = "Subject + was driving + adverb + location."
          ),
          SentencePuzzleItem(
            id = "c4_p13",
            scrambledWords = listOf("blowing", "wind", "was", "cold", "The", "fiercely"),
            correctSentence = "The cold wind was blowing fiercely.",
            sinhalaMeaning = "සීතල සුළඟ වේගයෙන් හමමින් පැවතුණි.",
            hint = "Subject noun phrase + was blowing + manner adverb."
          ),
          SentencePuzzleItem(
            id = "c4_p14",
            scrambledWords = listOf("repairing", "mechanic", "was", "The", "engine", "car", "the"),
            correctSentence = "The mechanic was repairing the car engine.",
            sinhalaMeaning = "කාර්මිකයා මෝටර් රථ එන්ජිම අලුත්වැඩියා කරමින් සිටියේය.",
            hint = "Subject + was repairing + object."
          ),
          SentencePuzzleItem(
            id = "c4_p15",
            scrambledWords = listOf("flying", "were", "high", "Birds", "sky", "in", "the"),
            correctSentence = "Birds were flying high in the sky.",
            sinhalaMeaning = "කුරුල්ලන් අහසේ උසින් පියාසර කරමින් සිටියහ.",
            hint = "Plural subject + were flying + direction + place."
          ),
          SentencePuzzleItem(
            id = "c4_p16",
            scrambledWords = listOf("discussing", "students", "were", "project", "The", "their"),
            correctSentence = "The students were discussing their project.",
            sinhalaMeaning = "සිසුන් තම ව්‍යාපෘතිය ගැන සාකච්ඡා කරමින් සිටියහ.",
            hint = "Subject + were discussing + object."
          ),
          SentencePuzzleItem(
            id = "c4_p17",
            scrambledWords = listOf("taking", "doctor", "was", "patient", "pulse", "the", "of", "The"),
            correctSentence = "The doctor was taking the pulse of patient.",
            sinhalaMeaning = "වෛද්‍යවරයා රෝගියාගේ නාඩි වැටීම පරීක්ෂා කරමින් සිටියේය.",
            hint = "Subject + was taking + object phrase."
          ),
          SentencePuzzleItem(
            id = "c4_p18",
            scrambledWords = listOf("practicing", "choir", "was", "song", "The", "new", "a"),
            correctSentence = "The choir was practicing a new song.",
            sinhalaMeaning = "ගායන කණ්ඩායම අලුත් ගීතයක් පුහුණු වෙමින් සිටියහ.",
            hint = "Singular collective + was practicing + article + adj + noun."
          ),
          SentencePuzzleItem(
            id = "c4_p19",
            scrambledWords = listOf("drawing", "child", "was", "A", "wall", "picture", "on", "the"),
            correctSentence = "A child was drawing picture on the wall.",
            sinhalaMeaning = "දරුවෙකු බිත්තිය මත චිත්‍රයක් අඳිමින් සිටියේය.",
            hint = "Subject + was drawing + object + location."
          ),
          SentencePuzzleItem(
            id = "c4_p20",
            scrambledWords = listOf("flowing", "river", "The", "swiftly", "after", "flood", "was"),
            correctSentence = "The river was flowing swiftly after flood.",
            sinhalaMeaning = "ගංවතුරෙන් පසු ගඟ වේගයෙන් ගලා බසිමින් පැවතුණි.",
            hint = "Subject + was flowing + adverb + time phrase."
          )
        )
      ),

      // ==========================================
      // Category 5: Present Perfect Tense (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 5,
        titleSinhala = "කාණ්ඩය 05: වර්තමාන පූර්ණ කාලය (Present Perfect Tense)",
        titleEnglish = "Present Perfect Tense & Experience",
        icon = "🏆",
        description = "අතීතයේ සිදුවූ නමුත් වර්තමානයට බලපෑමක් ඇති ක්‍රියා (has/have + V3) සඳහා වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c5_p1",
            scrambledWords = listOf("finished", "have", "homework", "I", "my", "already"),
            correctSentence = "I have already finished my homework.",
            sinhalaMeaning = "මම මගේ ගෙදර වැඩ දැනටමත් අවසන් කර ඇත්තෙමි.",
            hint = "I + have + adverb (already) + past participle (finished) + object."
          ),
          SentencePuzzleItem(
            id = "c5_p2",
            scrambledWords = listOf("visited", "has", "Kandy", "She", "times", "three"),
            correctSentence = "She has visited Kandy three times.",
            sinhalaMeaning = "ඇය මහනුවර තුන් වතාවක් නරඹා ඇත.",
            hint = "She + has + V3 (visited) + Place + Frequency."
          ),
          SentencePuzzleItem(
            id = "c5_p3",
            scrambledWords = listOf("have", "won", "championship", "They", "the", "football"),
            correctSentence = "They have won the football championship.",
            sinhalaMeaning = "ඔවුන් පාපන්දු ශූරතාව දිනාගෙන ඇත.",
            hint = "They + have + won (V3) + object."
          ),
          SentencePuzzleItem(
            id = "c5_p4",
            scrambledWords = listOf("not", "has", "He", "lunch", "his", "eaten", "yet"),
            correctSentence = "He has not eaten his lunch yet.",
            sinhalaMeaning = "ඔහු තවමත් ඔහුගේ දිවා ආහාරය ගෙන නැත.",
            hint = "Negative perfect: has not + eaten + object + yet (at end)."
          ),
          SentencePuzzleItem(
            id = "c5_p5",
            scrambledWords = listOf("lost", "key", "has", "Nimal", "bicycle", "his"),
            correctSentence = "Nimal has lost his bicycle key.",
            sinhalaMeaning = "නිමාල්ට ඔහුගේ පාපැදියේ යතුර නැති වී ඇත.",
            hint = "Singular subject + has + lost + object."
          ),
          SentencePuzzleItem(
            id = "c5_p6",
            scrambledWords = listOf("seen", "never", "have", "I", "blue", "whale", "a"),
            correctSentence = "I have never seen a blue whale.",
            sinhalaMeaning = "මම කවදාවත් නිල් තල්මසෙකු දැක නැත.",
            hint = "I have + never + V3 (seen) + object."
          ),
          SentencePuzzleItem(
            id = "c5_p7",
            scrambledWords = listOf("lived", "here", "have", "years", "ten", "We", "for"),
            correctSentence = "We have lived here for ten years.",
            sinhalaMeaning = "අපි වසර දහයක් මෙහි ජීවත් වී ඇත්තෙමු.",
            hint = "We have + lived + place + for (duration)."
          ),
          SentencePuzzleItem(
            id = "c5_p8",
            scrambledWords = listOf("written", "author", "has", "The", "new", "a", "book"),
            correctSentence = "The author has written a new book.",
            sinhalaMeaning = "කතුවරයා නව පොතක් ලියා ඇත.",
            hint = "Subject + has written + object."
          ),
          SentencePuzzleItem(
            id = "c5_p9",
            scrambledWords = listOf("broken", "Someone", "has", "window", "glass", "the"),
            correctSentence = "Someone has broken the window glass.",
            sinhalaMeaning = "යමෙක් ජනෙල් වීදුරුව කඩා ඇත.",
            hint = "Indefinite pronoun (Someone) + has broken + object."
          ),
          SentencePuzzleItem(
            id = "c5_p10",
            scrambledWords = listOf("planted", "father", "trees", "My", "many", "fruit", "has"),
            correctSentence = "My father has planted many fruit trees.",
            sinhalaMeaning = "මගේ පියා පලතුරු ගස් රාශියක් රෝපණය කර ඇත.",
            hint = "Subject + has planted + quantifier + noun."
          ),
          SentencePuzzleItem(
            id = "c5_p11",
            scrambledWords = listOf("read", "this", "Have", "story", "ever", "you", "?"),
            correctSentence = "Have you ever read this story?",
            sinhalaMeaning = "ඔබ කවදා හෝ මෙම කතාව කියවා තිබේද?",
            hint = "Question: Have + Subject + ever + V3 + object + ?"
          ),
          SentencePuzzleItem(
            id = "c5_p12",
            scrambledWords = listOf("cleaned", "room", "She", "her", "just", "has"),
            correctSentence = "She has just cleaned her room.",
            sinhalaMeaning = "ඇය දැන් සුළු වේලාවකට පෙර කාමරය පිරිසිදු කළාය.",
            hint = "She has + just (recent past) + cleaned + object."
          ),
          SentencePuzzleItem(
            id = "c5_p13",
            scrambledWords = listOf("passed", "all", "students", "The", "have", "examination", "the"),
            correctSentence = "The students have passed the examination all.",
            sinhalaMeaning = "සිසුන් සියලු දෙනාම විභාගය සමත් වී ඇත.",
            hint = "Subject + have passed + object."
          ),
          SentencePuzzleItem(
            id = "c5_p14",
            scrambledWords = listOf("known", "each", "other", "have", "childhood", "We", "since"),
            correctSentence = "We have known each other since childhood.",
            sinhalaMeaning = "කුඩා කාලයේ සිටම අපි එකිනෙකා හඳුනන්නෙමු.",
            hint = "We have known + each other + since (starting point)."
          ),
          SentencePuzzleItem(
            id = "c5_p15",
            scrambledWords = listOf("bought", "tickets", "train", "already", "He", "has", "the"),
            correctSentence = "He has already bought the train tickets.",
            sinhalaMeaning = "ඔහු දැනටමත් දුම්රිය ප්‍රවේශපත්‍ර මිලදී ගෙන ඇත.",
            hint = "He has + already + bought + object."
          ),
          SentencePuzzleItem(
            id = "c5_p16",
            scrambledWords = listOf("taught", "English", "years", "She", "for", "five", "has"),
            correctSentence = "She has taught English for five years.",
            sinhalaMeaning = "ඇය වසර පහක් පුරා ඉංග්‍රීසි උගන්වා ඇත.",
            hint = "She has taught + subject + for + time period."
          ),
          SentencePuzzleItem(
            id = "c5_p17",
            scrambledWords = listOf("completed", "scientists", "have", "The", "research", "their"),
            correctSentence = "The scientists have completed their research.",
            sinhalaMeaning = "විද්‍යාඥයන් තම පර්යේෂණ සම්පූර්ණ කර ඇත.",
            hint = "Plural subject + have completed + object."
          ),
          SentencePuzzleItem(
            id = "c5_p18",
            scrambledWords = listOf("eaten", "Never", "such", "delicious", "fruit", "have", "I", "a"),
            correctSentence = "I have never eaten such a delicious fruit.",
            sinhalaMeaning = "මම මෙවැනි රසවත් පලතුරක් කවදාවත් කා නැත.",
            hint = "I have never + eaten + such a + adj + noun."
          ),
          SentencePuzzleItem(
            id = "c5_p19",
            scrambledWords = listOf("arrived", "safely", "destination", "at", "guests", "The", "have"),
            correctSentence = "The guests have arrived safely at destination.",
            sinhalaMeaning = "ආරාධිත අමුත්තන් ගමනාන්තයට ආරක්ෂිතව ළඟා වී ඇත.",
            hint = "Subject + have arrived + adverb + at destination."
          ),
          SentencePuzzleItem(
            id = "c5_p20",
            scrambledWords = listOf("changed", "city", "lot", "a", "has", "The", "recently"),
            correctSentence = "The city has changed a lot recently.",
            sinhalaMeaning = "නගරය මෑතකදී බොහෝ වෙනස් වී ඇත.",
            hint = "Subject + has changed + a lot + recently."
          )
        )
      ),

      // ==========================================
      // Category 6: Future Tense & Planned Actions (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 6,
        titleSinhala = "කාණ්ඩය 06: අනාගත කාලය සහ සැලසුම් (Future Tense)",
        titleEnglish = "Future Tense & Planned Actions",
        icon = "🚀",
        description = "අනාගත අපේක්ෂා, සැලසුම් සහ 'will' / 'going to' භාවිත වන වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c6_p1",
            scrambledWords = listOf("will", "We", "tomorrow", "exhibition", "science", "visit", "the"),
            correctSentence = "We will visit the science exhibition tomorrow.",
            sinhalaMeaning = "අපි හෙට විද්‍යා ප්‍රදර්ශනය නරඹන්නෙමු.",
            hint = "Subject (We) + modal (will) + base verb (visit) + object + time."
          ),
          SentencePuzzleItem(
            id = "c6_p2",
            scrambledWords = listOf("going", "is", "She", "to", "hard", "study", "exam", "for"),
            correctSentence = "She is going to study hard for exam.",
            sinhalaMeaning = "ඇය විභාගය වෙනුවෙන් මහන්සි වී පාඩම් කිරීමට යන්නීය.",
            hint = "Intention: is going to + verb + adverb + purpose."
          ),
          SentencePuzzleItem(
            id = "c6_p3",
            scrambledWords = listOf("help", "will", "you", "I", "difficult", "homework", "with", "this"),
            correctSentence = "I will help you with this difficult homework.",
            sinhalaMeaning = "මම ඔබට මෙම අපහසු ගෙදර වැඩ සඳහා උදවු කරන්නෙමි.",
            hint = "Offer/promise: I will help + you + with..."
          ),
          SentencePuzzleItem(
            id = "c6_p4",
            scrambledWords = listOf("rain", "soon", "will", "It", "clouds", "dark", "because", "are"),
            correctSentence = "It will rain soon because clouds are dark.",
            sinhalaMeaning = "වලාකුළු අඳුරු වී ඇති නිසා ළඟදීම වැසි වසිනු ඇත.",
            hint = "Prediction: It will rain soon + because clause."
          ),
          SentencePuzzleItem(
            id = "c6_p5",
            scrambledWords = listOf("buy", "new", "car", "a", "will", "father", "My", "year", "next"),
            correctSentence = "My father will buy a new car next year.",
            sinhalaMeaning = "මගේ පියා ලබන වසරේ අලුත් මෝටර් රථයක් මිලදී ගනු ඇත.",
            hint = "Subject + will buy + object + future time."
          ),
          SentencePuzzleItem(
            id = "c6_p6",
            scrambledWords = listOf("are", "going", "plant", "trees", "They", "school", "to", "in"),
            correctSentence = "They are going to plant trees in school.",
            sinhalaMeaning = "ඔවුන් පාසලේ ගස් සිටුවීමට සැලසුම් කර ඇත.",
            hint = "They are going to + plant + objects + place."
          ),
          SentencePuzzleItem(
            id = "c6_p7",
            scrambledWords = listOf("arrive", "at", "train", "The", "will", "station", "noon", "at"),
            correctSentence = "The train will arrive at station at noon.",
            sinhalaMeaning = "දුම්රිය මධ්‍යහ්නයේදී දුම්රිය ස්ථානයට ළඟා වනු ඇත.",
            hint = "The train will arrive + place + time."
          ),
          SentencePuzzleItem(
            id = "c6_p8",
            scrambledWords = listOf("pass", "will", "surely", "He", "competition", "speech", "the"),
            correctSentence = "He will surely pass the speech competition.",
            sinhalaMeaning = "ඔහු නිසැකවම කථික තරගයෙන් ජය ලබනු ඇත.",
            hint = "He + will + adverb (surely) + pass + object."
          ),
          SentencePuzzleItem(
            id = "c6_p9",
            scrambledWords = listOf("will", "never", "I", "forget", "kindness", "your"),
            correctSentence = "I will never forget your kindness.",
            sinhalaMeaning = "මම ඔබගේ කාරුණික බව කිසිදා අමතක නොකරමි.",
            hint = "Subject + will + negative adverb (never) + forget + object."
          ),
          SentencePuzzleItem(
            id = "c6_p10",
            scrambledWords = listOf("build", "will", "bridge", "new", "government", "The", "a"),
            correctSentence = "The government will build a new bridge.",
            sinhalaMeaning = "රජය නව පාලමක් ඉදිකරනු ඇත.",
            hint = "Subject + will build + article + adj + noun."
          ),
          SentencePuzzleItem(
            id = "c6_p11",
            scrambledWords = listOf("become", "wants", "She", "doctor", "to", "a", "future", "in"),
            correctSentence = "She wants to become a doctor in future.",
            sinhalaMeaning = "ඇයට අනාගතයේදී වෛද්‍යවරියක් වීමට අවශ්‍යයි.",
            hint = "She wants to become + profession + time."
          ),
          SentencePuzzleItem(
            id = "c6_p12",
            scrambledWords = listOf("clean", "we", "Will", "classroom", "together", "the", "?"),
            correctSentence = "Will we clean the classroom together?",
            sinhalaMeaning = "අපි එක්ව පන්ති කාමරය පිරිසිදු කරමුද?",
            hint = "Question: Will + Subject + Verb + Object + adverb + ?"
          ),
          SentencePuzzleItem(
            id = "c6_p13",
            scrambledWords = listOf("start", "match", "The", "p.m.", "will", "at", "3.00"),
            correctSentence = "The match will start at 3.00 p.m.",
            sinhalaMeaning = "තරගය පස්වරු 3.00 ට ආරම්භ වනු ඇත.",
            hint = "Subject + will start + time."
          ),
          SentencePuzzleItem(
            id = "c6_p14",
            scrambledWords = listOf("going", "am", "I", "read", "book", "this", "tonight", "to"),
            correctSentence = "I am going to read this book tonight.",
            sinhalaMeaning = "මම අද රාත්‍රියේ මෙම පොත කියවීමට අදහස් කරමි.",
            hint = "I am going to + read + object + tonight."
          ),
          SentencePuzzleItem(
            id = "c6_p15",
            scrambledWords = listOf("protect", "future", "will", "Green", "energy", "our"),
            correctSentence = "Green energy will protect our future.",
            sinhalaMeaning = "හරිත බලශක්තිය අපගේ අනාගතය සුරක්ෂිත කරනු ඇත.",
            hint = "Subject phrase + will protect + possessive noun."
          ),
          SentencePuzzleItem(
            id = "c6_p16",
            scrambledWords = listOf("travel", "around", "world", "will", "They", "the", "someday"),
            correctSentence = "They will travel around the world someday.",
            sinhalaMeaning = "ඔවුන් කවදා හෝ ලොව වටා සංචාරය කරනු ඇත.",
            hint = "Subject + will travel + around the world + time adverb."
          ),
          SentencePuzzleItem(
            id = "c6_p17",
            scrambledWords = listOf("bring", "tomorrow", "umbrella", "an", "will", "I"),
            correctSentence = "I will bring an umbrella tomorrow.",
            sinhalaMeaning = "මම හෙට කුඩයක් රැගෙන එන්නෙමි.",
            hint = "Subject + will bring + article + noun + tomorrow."
          ),
          SentencePuzzleItem(
            id = "c6_p18",
            scrambledWords = listOf("celebrate", "birthday", "his", "He", "will", "grandly"),
            correctSentence = "He will celebrate his birthday grandly.",
            sinhalaMeaning = "ඔහු තම උපන්දිනය උත්කර්ෂවත් ලෙස සමරනු ඇත.",
            hint = "Subject + will celebrate + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c6_p19",
            scrambledWords = listOf("announce", "results", "principal", "The", "will", "soon"),
            correctSentence = "The principal will announce results soon.",
            sinhalaMeaning = "විදුහල්පතිතුමා ළඟදීම ප්‍රතිඵල ප්‍රකාශ කරනු ඇත.",
            hint = "Subject + will announce + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c6_p20",
            scrambledWords = listOf("succeed", "if", "You", "work", "will", "diligently", "you"),
            correctSentence = "You will succeed if you work diligently.",
            sinhalaMeaning = "ඔබ උනන්දුවෙන් වැඩ කළහොත් ඔබ සාර්ථක වනු ඇත.",
            hint = "Main future clause (You will succeed) + If clause."
          )
        )
      ),

      // ==========================================
      // Category 7: School Life, Subjects & Exams (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 7,
        titleSinhala = "කාණ්ඩය 07: පාසල් ජීවිතය, විෂයයන් සහ විභාග",
        titleEnglish = "School Life, Subjects & Exams",
        icon = "📚",
        description = "පාසල, ගුරුවරුන්, පුස්තකාලය, විද්‍යාගාරය සහ විභාග සූදානම සම්බන්ධ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c7_p1",
            scrambledWords = listOf("must", "attend", "Students", "assembly", "morning", "school", "the"),
            correctSentence = "Students must attend the school morning assembly.",
            sinhalaMeaning = "සිසුන් පාසලේ උදෑසන රැස්වීමට අනිවාර්යයෙන්ම සහභාගි විය යුතුය.",
            hint = "Students + modal (must) + attend + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c7_p2",
            scrambledWords = listOf("library", "school", "Our", "has", "thousand", "books", "ten"),
            correctSentence = "Our school library has ten thousand books.",
            sinhalaMeaning = "අපේ පාසල් පුස්තකාලයේ පොත් දස දහසක් තිබේ.",
            hint = "Subject (Our school library) + has + quantity + books."
          ),
          SentencePuzzleItem(
            id = "c7_p3",
            scrambledWords = listOf("science", "conducted", "an", "We", "experiment", "laboratory", "in"),
            correctSentence = "We conducted an experiment in science laboratory.",
            sinhalaMeaning = "අපි විද්‍යාගාරයේදී පරීක්ෂණයක් සිදු කළෙමු.",
            hint = "Subject + verb (conducted) + object + location."
          ),
          SentencePuzzleItem(
            id = "c7_p4",
            scrambledWords = listOf("favorite", "Mathematics", "my", "is", "subject", "school", "at"),
            correctSentence = "Mathematics is my favorite subject at school.",
            sinhalaMeaning = "පාසලේදී මගේ ප්‍රියතම විෂය වන්නේ ගණිතයයි.",
            hint = "Subject (Mathematics) + is + possessive phrase + location."
          ),
          SentencePuzzleItem(
            id = "c7_p5",
            scrambledWords = listOf("should", "timetable", "create", "Every", "a", "study", "student"),
            correctSentence = "Every student should create a study timetable.",
            sinhalaMeaning = "සෑම සිසුවෙකුම පාඩම් කාලසටහනක් සකස් කරගත යුතුය.",
            hint = "Every student + should + create + object."
          ),
          SentencePuzzleItem(
            id = "c7_p6",
            scrambledWords = listOf("wearing", "clean", "uniform", "is", "rule", "school", "important", "an"),
            correctSentence = "Wearing clean uniform is an important school rule.",
            sinhalaMeaning = "පිරිසිදු නිල ඇඳුමක් ඇඳීම වැදගත් පාසල් නීතියකි.",
            hint = "Gerund subject (Wearing clean uniform) + is + predicate."
          ),
          SentencePuzzleItem(
            id = "c7_p7",
            scrambledWords = listOf("punctual", "Be", "always", "morning", "bell", "for", "the"),
            correctSentence = "Be always punctual for the morning bell.",
            sinhalaMeaning = "සැමවිටම උදෑසන සීනුවට වේලාවට පැමිණෙන්න.",
            hint = "Imperative: Be + adverb + adjective + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c7_p8",
            scrambledWords = listOf("helps", "Reading", "vocabulary", "to", "books", "improve", "English"),
            correctSentence = "Reading books helps to improve English vocabulary.",
            sinhalaMeaning = "පොත් කියවීම ඉංග්‍රීසි වචන මාලාව වැඩිදියුණු කිරීමට උපකාරී වේ.",
            hint = "Gerund subject + singular verb (helps) + to-infinitive."
          ),
          SentencePuzzleItem(
            id = "c7_p9",
            scrambledWords = listOf("respected", "Teachers", "are", "highly", "society", "in", "our"),
            correctSentence = "Teachers are highly respected in our society.",
            sinhalaMeaning = "අපගේ සමාජය තුළ ගුරුවරුන් ඉහළින්ම ගෞරවයට පාත්‍ර වේ.",
            hint = "Passive: Teachers + are + adverb + past participle + place."
          ),
          SentencePuzzleItem(
            id = "c7_p10",
            scrambledWords = listOf("silence", "Please", "keep", "in", "reading", "hall", "the"),
            correctSentence = "Please keep silence in the reading hall.",
            sinhalaMeaning = "කරුණාකර කියවීම් ශාලාවේ නිශ්ශබ්දතාව රකින්න.",
            hint = "Polite imperative: Please + base verb + object + location."
          ),
          SentencePuzzleItem(
            id = "c7_p11",
            scrambledWords = listOf("solved", "problem", "difficult", "together", "They", "the", "maths"),
            correctSentence = "They solved the difficult maths problem together.",
            sinhalaMeaning = "ඔවුන් අමාරු ගණිත ගැටලුව එක්ව විසඳා ගත්හ.",
            hint = "Subject + verb + adjective phrase + noun + adverb."
          ),
          SentencePuzzleItem(
            id = "c7_p12",
            scrambledWords = listOf("gives", "Homework", "opportunity", "practice", "an", "concepts", "to"),
            correctSentence = "Homework gives an opportunity to practice concepts.",
            sinhalaMeaning = "ගෙදර වැඩ සංකල්ප පුහුණු වීමට අවස්ථාවක් ලබා දෙයි.",
            hint = "Subject + verb + object + infinitive."
          ),
          SentencePuzzleItem(
            id = "c7_p13",
            scrambledWords = listOf("prize", "won", "Malini", "first", "competition", "essay", "in"),
            correctSentence = "Malini won first prize in essay competition.",
            sinhalaMeaning = "මාලිනී රචනා තරගයේ ප්‍රථම ස්ථානය දිනාගත්තාය.",
            hint = "Subject + won + ordinal + prize + context."
          ),
          SentencePuzzleItem(
            id = "c7_p14",
            scrambledWords = listOf("teach", "moral", "values", "Schools", "responsible", "citizens", "shape", "to"),
            correctSentence = "Schools teach moral values to shape responsible citizens.",
            sinhalaMeaning = "වගකිවයුතු පුරවැසියන් බිහිකිරීම සඳහා පාසල් සදාචාරාත්මක වටිනාකම් උගන්වයි.",
            hint = "Subject + teach + object + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c7_p15",
            scrambledWords = listOf("prefects", "The", "maintain", "order", "school", "intervals", "during"),
            correctSentence = "The prefects maintain school order during intervals.",
            sinhalaMeaning = "විවේක කාලයේදී පාසලේ විනය පවත්වා ගන්නේ ශිෂ්‍ය නායකයින් විසිනි.",
            hint = "Subject + verb + object + time phrase."
          ),
          SentencePuzzleItem(
            id = "c7_p16",
            scrambledWords = listOf("participated", "sports", "meet", "students", "Many", "annual", "in"),
            correctSentence = "Many students participated in annual sports meet.",
            sinhalaMeaning = "වාර්ෂික ක්‍රීඩා උළෙලට බොහෝ සිසුන් සහභාගි වූහ.",
            hint = "Subject phrase + participated in + event."
          ),
          SentencePuzzleItem(
            id = "c7_p17",
            scrambledWords = listOf("listen", "attentively", "Always", "teacher", "your", "instructions", "to"),
            correctSentence = "Always listen attentively to your teacher instructions.",
            sinhalaMeaning = "සැමවිටම ඔබේ ගුරු උපදෙස්වලට අවධානයෙන් සවන් දෙන්න.",
            hint = "Adverb + Imperative + Adverb + to phrase."
          ),
          SentencePuzzleItem(
            id = "c7_p18",
            scrambledWords = listOf("grades", "Good", "result", "regular", "are", "study", "of"),
            correctSentence = "Good grades are result of regular study.",
            sinhalaMeaning = "හොඳ ලකුණු ලැබෙන්නේ නිතිපතා අධ්‍යයනයේ ප්‍රතිඵලයක් වශයෙනි.",
            hint = "Subject + are + complement phrase."
          ),
          SentencePuzzleItem(
            id = "c7_p19",
            scrambledWords = listOf("club", "English", "meets", "every", "Wednesday", "afternoon"),
            correctSentence = "English club meets every Wednesday afternoon.",
            sinhalaMeaning = "ඉංග්‍රීසි සමාජය සෑම බදාදා දිනකම පස්වරුවේ රැස්වේ.",
            hint = "Subject + meets + time phrase."
          ),
          SentencePuzzleItem(
            id = "c7_p20",
            scrambledWords = listOf("key", "Education", "the", "successful", "is", "future", "a", "to"),
            correctSentence = "Education is the key to a successful future.",
            sinhalaMeaning = "සාර්ථක අනාගතයකට මඟ පාදන යතුර වන්නේ අධ්‍යාපනයයි.",
            hint = "Subject + is + the key to + noun phrase."
          )
        )
      ),

      // ==========================================
      // Category 8: Environment, Trees & Nature Protection (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 8,
        titleSinhala = "කාණ්ඩය 08: පරිසරය, ගස්වැල් සහ ස්වභාවධර්ම ආරක්ෂාව",
        titleEnglish = "Environment, Trees & Nature Protection",
        icon = "🌿",
        description = "පරිසර දූෂණය වැළැක්වීම, ගස් සිටුවීම සහ පරිසර සංරක්ෂණ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c8_p1",
            scrambledWords = listOf("must", "We", "protect", "endangered", "wild", "animals", "extinction", "from"),
            correctSentence = "We must protect endangered wild animals from extinction.",
            sinhalaMeaning = "වඳවීමේ තර්ජනයට ලක්ව ඇති වන සතුන් වඳවී යාමෙන් අපි ආරක්ෂා කළ යුතුය.",
            hint = "Modal must + protect + object + from extinction."
          ),
          SentencePuzzleItem(
            id = "c8_p2",
            scrambledWords = listOf("cutting", "trees", "down", "causes", "soil", "severe", "erosion"),
            correctSentence = "Cutting down trees causes severe soil erosion.",
            sinhalaMeaning = "ගස් කැපීම දැඩි පාංශු ඛාදනයට හේතු වේ.",
            hint = "Gerund subject (Cutting down trees) + singular verb (causes) + object."
          ),
          SentencePuzzleItem(
            id = "c8_p3",
            scrambledWords = listOf("plastic", "never", "Should", "we", "throw", "rivers", "into"),
            correctSentence = "We should never throw plastic into rivers.",
            sinhalaMeaning = "අපි කිසිවිටෙකත් ප්ලාස්ටික් ගංගාවලට නොදැමිය යුතුය.",
            hint = "Subject + should + never + throw + object + destination."
          ),
          SentencePuzzleItem(
            id = "c8_p4",
            scrambledWords = listOf("absorb", "dioxide", "carbon", "Trees", "release", "and", "oxygen"),
            correctSentence = "Trees absorb carbon dioxide and release oxygen.",
            sinhalaMeaning = "ගස් කාබන් ඩයොක්සයිඩ් උරාගෙන ඔක්සිජන් මුදාහරියි.",
            hint = "Compound predicate: Subject + Verb1 + Object1 + and + Verb2 + Object2."
          ),
          SentencePuzzleItem(
            id = "c8_p5",
            scrambledWords = listOf("recycle", "paper", "can", "We", "save", "forests", "to"),
            correctSentence = "We can recycle paper to save forests.",
            sinhalaMeaning = "වනාන්තර සුරැකීම සඳහා අපට කඩදාසි ප්‍රතිචක්‍රීකරණය කළ හැකිය.",
            hint = "Subject + can recycle + object + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c8_p6",
            scrambledWords = listOf("warming", "Global", "threat", "is", "a", "serious", "mankind", "to"),
            correctSentence = "Global warming is a serious threat to mankind.",
            sinhalaMeaning = "ගෝලීය උණුසුම ඉහළ යාම මිනිස් වර්ගයාට බරපතල තර්ජනයකි.",
            hint = "Subject + is + article + adjective + noun + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c8_p7",
            scrambledWords = listOf("keep", "surroundings", "our", "Always", "clean", "and", "green"),
            correctSentence = "Always keep our surroundings clean and green.",
            sinhalaMeaning = "සැමවිටම අපගේ අවට පරිසරය පිරිසිදුව සහ හරිතව තබාගන්න.",
            hint = "Imperative: Adverb + keep + object + adjectives."
          ),
          SentencePuzzleItem(
            id = "c8_p8",
            scrambledWords = listOf("rainwater", "Harvesting", "saves", "scarcity", "water", "during"),
            correctSentence = "Harvesting rainwater saves water during scarcity.",
            sinhalaMeaning = "වැසි ජලය රැස්කිරීම හිඟ කාලවලදී ජලය ඉතිරි කරයි.",
            hint = "Gerund subject + verb + object + time phrase."
          ),
          SentencePuzzleItem(
            id = "c8_p9",
            scrambledWords = listOf("smoke", "Vehicles", "emit", "toxic", "pollutes", "that", "air"),
            correctSentence = "Vehicles emit toxic smoke that pollutes air.",
            sinhalaMeaning = "වාහන වාතය දූෂණය කරන විෂ දුම් පිටකරයි.",
            hint = "Subject + verb + object + relative clause (that pollutes air)."
          ),
          SentencePuzzleItem(
            id = "c8_p10",
            scrambledWords = listOf("rainforest", "Sinharaja", "is", "World", "Heritage", "a", "site"),
            correctSentence = "Sinharaja rainforest is a World Heritage site.",
            sinhalaMeaning = "සිංහරාජ වැසි වනාන්තරය ලෝක උරුම අඩවියකි.",
            hint = "Proper noun phrase + is + article + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c8_p11",
            scrambledWords = listOf("use", "cloth", "Instead", "bags", "of", "polythene"),
            correctSentence = "Use cloth bags instead of polythene.",
            sinhalaMeaning = "පොලිතින් වෙනුවට රෙදි බෑග් භාවිත කරන්න.",
            hint = "Imperative + object + instead of + alternative."
          ),
          SentencePuzzleItem(
            id = "c8_p12",
            scrambledWords = listOf("gives", "shade", "A", "travellers", "tired", "to", "tree"),
            correctSentence = "A tree gives shade to tired travellers.",
            sinhalaMeaning = "ගසක් වෙහෙසට පත් මගීන්ට සෙවණ ලබා දෙයි.",
            hint = "Subject + gives + object + to + recipient."
          ),
          SentencePuzzleItem(
            id = "c8_p13",
            scrambledWords = listOf("duty", "Preserving", "nature", "is", "sacred", "a", "human"),
            correctSentence = "Preserving nature is a sacred human duty.",
            sinhalaMeaning = "ස්වභාවධර්මය රැකගැනීම පූජනීය මානුෂීය යුතුකමකි.",
            hint = "Gerund phrase + is + article + adj + noun."
          ),
          SentencePuzzleItem(
            id = "c8_p14",
            scrambledWords = listOf("oceans", "Marine", "creatures", "die", "polluted", "in"),
            correctSentence = "Marine creatures die in polluted oceans.",
            sinhalaMeaning = "දූෂිත සාගරවල සාගර ජීවීන් මිය යයි.",
            hint = "Subject phrase + verb + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c8_p15",
            scrambledWords = listOf("stop", "illegal", "logging", "must", "Authorities", "forests", "in"),
            correctSentence = "Authorities must stop illegal logging in forests.",
            sinhalaMeaning = "බලධාරීන් වනාන්තරවල නීතිවිරෝධී දැව කැපීම නැවැත්විය යුතුය.",
            hint = "Subject + must stop + object + place."
          ),
          SentencePuzzleItem(
            id = "c8_p16",
            scrambledWords = listOf("plant", "Let", "us", "seedling", "birthday", "every", "a", "on"),
            correctSentence = "Let us plant a seedling on every birthday.",
            sinhalaMeaning = "සෑම උපන්දිනයකදීම පැළයක් සිටුවීමට අපි පෙළඹෙමු.",
            hint = "Let us + verb + object + time phrase."
          ),
          SentencePuzzleItem(
            id = "c8_p17",
            scrambledWords = listOf("energy", "Solar", "clean", "and", "renewable", "is"),
            correctSentence = "Solar energy is clean and renewable.",
            sinhalaMeaning = "සූර්ය බලශක්තිය පිරිසිදු මෙන්ම පුනර්ජනනීය වේ.",
            hint = "Subject + is + coordinate adjectives."
          ),
          SentencePuzzleItem(
            id = "c8_p18",
            scrambledWords = listOf("wasting", "Stop", "tap", "drinking", "water", "home", "at"),
            correctSentence = "Stop wasting drinking tap water at home.",
            sinhalaMeaning = "නිවසේදී පිරිසිදු පානීය ජලය නාස්ති කිරීම නවත්වන්න.",
            hint = "Imperative + gerund + object."
          ),
          SentencePuzzleItem(
            id = "c8_p19",
            scrambledWords = listOf("rich", "Sri", "Lanka", "has", "biodiversity", "a"),
            correctSentence = "Sri Lanka has a rich biodiversity.",
            sinhalaMeaning = "ශ්‍රී ලංකාව සතුව පොහොසත් ජෛව විවිධත්වයක් ඇත.",
            hint = "Subject + has + article + adjective + noun."
          ),
          SentencePuzzleItem(
            id = "c8_p20",
            scrambledWords = listOf("future", "generations", "inherit", "will", "our", "planet"),
            correctSentence = "Future generations will inherit our planet.",
            sinhalaMeaning = "අනාගත පරපුර අපගේ පෘථිවිය උරුම කර ගනු ඇත.",
            hint = "Subject + will inherit + object."
          )
        )
      ),

      // ==========================================
      // Category 9: Science, Inventions & Technology (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 9,
        titleSinhala = "කාණ්ඩය 09: විද්‍යාව, නව නිපැයුම් සහ තාක්ෂණය",
        titleEnglish = "Science, Inventions & Technology",
        icon = "💡",
        description = "නවීන සොයාගැනීම්, පරිගණක, අන්තර්ජාලය සහ විද්‍යාත්මක කරුණු පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c9_p1",
            scrambledWords = listOf("revolutionized", "has", "Internet", "global", "the", "communication"),
            correctSentence = "The Internet has revolutionized global communication.",
            sinhalaMeaning = "අන්තර්ජාලය ගෝලීය සන්නිවේදනයේ විප්ලවීය වෙනසක් සිදු කර ඇත.",
            hint = "Subject + has + V3 (revolutionized) + object."
          ),
          SentencePuzzleItem(
            id = "c9_p2",
            scrambledWords = listOf("discovered", "gravity", "Sir", "Isaac", "falling", "Newton", "apple", "from", "an"),
            correctSentence = "Sir Isaac Newton discovered gravity from an falling apple.",
            sinhalaMeaning = "ශ්‍රීමත් අයිසැක් නිව්ටන් ඇපල් ගෙඩියක් වැටීමෙන් ගුරුත්වාකර්ෂණය සොයා ගත්තේය.",
            hint = "Subject + discovered + object + prepositional source phrase."
          ),
          SentencePuzzleItem(
            id = "c9_p3",
            scrambledWords = listOf("Artificial", "intelligence", "transforming", "is", "modern", "industries"),
            correctSentence = "Artificial intelligence is transforming modern industries.",
            sinhalaMeaning = "කෘත්‍රිම බුද්ධිය නවීන කර්මාන්ත පරිවර්තනය කරමින් සිටී.",
            hint = "Subject phrase + is transforming + object phrase."
          ),
          SentencePuzzleItem(
            id = "c9_p4",
            scrambledWords = listOf("computers", "help", "solve", "complex", "calculations", "quickly"),
            correctSentence = "Computers help solve complex calculations quickly.",
            sinhalaMeaning = "පරිගණක සංකීර්ණ ගණනය කිරීම් ඉක්මනින් විසඳීමට උපකාරී වේ.",
            hint = "Subject + help + bare infinitive + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c9_p5",
            scrambledWords = listOf("electric", "cars", "reduce", "harmful", "carbon", "emissions"),
            correctSentence = "Electric cars reduce harmful carbon emissions.",
            sinhalaMeaning = "විදුලි මෝටර් රථ අහිතකර කාබන් විමෝචනය අඩු කරයි.",
            hint = "Subject + base verb + adjective phrase + noun."
          ),
          SentencePuzzleItem(
            id = "c9_p6",
            scrambledWords = listOf("telescopes", "allow", "astronomers", "distant", "galaxies", "observe", "to"),
            correctSentence = "Telescopes allow astronomers to observe distant galaxies.",
            sinhalaMeaning = "දුරේක්ෂ මගින් තාරකා විද්‍යාඥයින්ට ඈත මන්දාකිණි නිරීක්ෂණය කිරීමට ඉඩ සැලසේ.",
            hint = "Subject + allow + object + to-infinitive + target."
          ),
          SentencePuzzleItem(
            id = "c9_p7",
            scrambledWords = listOf("Microscopes", "reveal", "tiny", "invisible", "organisms", "eye", "naked", "to"),
            correctSentence = "Microscopes reveal tiny organisms invisible to naked eye.",
            sinhalaMeaning = "අන්වීක්ෂ මගින් පියවි ඇසට නොපෙනෙන කුඩා ක්ෂුද්‍ර ජීවීන් හෙළිදරව් කරයි.",
            hint = "Subject + verb + object + adjective modifier."
          ),
          SentencePuzzleItem(
            id = "c9_p8",
            scrambledWords = listOf("smartphones", "make", "daily", "tasks", "easier", "faster", "and"),
            correctSentence = "Smartphones make daily tasks easier and faster.",
            sinhalaMeaning = "ස්මාර්ට්ෆෝන් දෛනික කටයුතු පහසු සහ වේගවත් කරයි.",
            hint = "Subject + make + object + coordinate adjectives."
          ),
          SentencePuzzleItem(
            id = "c9_p9",
            scrambledWords = listOf("vaccines", "protect", "people", "dangerous", "diseases", "from"),
            correctSentence = "Vaccines protect people from dangerous diseases.",
            sinhalaMeaning = "එන්නත් මගින් භයානක රෝගවලින් මිනිසුන් ආරක්ෂා කරයි.",
            hint = "Subject + protect + object + from + noun."
          ),
          SentencePuzzleItem(
            id = "c9_p10",
            scrambledWords = listOf("robots", "perform", "hazardous", "tasks", "in", "factories"),
            correctSentence = "Robots perform hazardous tasks in factories.",
            sinhalaMeaning = "රොබෝවරු කර්මාන්තශාලාවල අනතුරුදායක කාර්යයන් සිදු කරති.",
            hint = "Subject + verb + adjective + object + location."
          ),
          SentencePuzzleItem(
            id = "c9_p11",
            scrambledWords = listOf("electricity", "powers", "millions", "homes", "of", "worldwide"),
            correctSentence = "Electricity powers millions of homes worldwide.",
            sinhalaMeaning = "විදුලි බලය ලොව පුරා නිවාස මිලියන ගණනක් බලගන්වයි.",
            hint = "Subject + verb + quantifier + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c9_p12",
            scrambledWords = listOf("satellites", "orbit", "earth", "weather", "forecast", "to"),
            correctSentence = "Satellites orbit earth to forecast weather.",
            sinhalaMeaning = "කාලගුණය පුරෝකථනය කිරීම සඳහා චන්ද්‍රිකා පෘථිවිය වටා කක්ෂගත වේ.",
            hint = "Subject + verb + object + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c9_p13",
            scrambledWords = listOf("Science", "is", "systematic", "knowledge", "observation", "based", "on"),
            correctSentence = "Science is systematic knowledge based on observation.",
            sinhalaMeaning = "විද්‍යාව යනු නිරීක්ෂණය මත පදනම් වූ ක්‍රමානුකූල දැනුමකි.",
            hint = "Subject + is + adjective + noun + participial phrase."
          ),
          SentencePuzzleItem(
            id = "c9_p14",
            scrambledWords = listOf("Thomas", "Edison", "invented", "commercial", "electric", "light", "bulb"),
            correctSentence = "Thomas Edison invented commercial electric light bulb.",
            sinhalaMeaning = "තෝමස් එඩිසන් වාණිජ විදුලි බුබුල නිපදවීය.",
            hint = "Proper subject + invented + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c9_p15",
            scrambledWords = listOf("passwords", "Strong", "protect", "personal", "data", "hackers", "from"),
            correctSentence = "Strong passwords protect personal data from hackers.",
            sinhalaMeaning = "ශක්තිමත් මුරපද මගින් පුද්ගලික දත්ත හැකර්වරුන්ගෙන් ආරක්ෂා කරයි.",
            hint = "Subject + protect + object + from hackers."
          ),
          SentencePuzzleItem(
            id = "c9_p16",
            scrambledWords = listOf("online", "education", "allows", "students", "learn", "home", "from", "to"),
            correctSentence = "Online education allows students to learn from home.",
            sinhalaMeaning = "මාර්ගගත අධ්‍යාපනය සිසුන්ට නිවසේ සිට ඉගෙන ගැනීමට ඉඩ සලසයි.",
            hint = "Subject + allows + object + to learn + from home."
          ),
          SentencePuzzleItem(
            id = "c9_p17",
            scrambledWords = listOf("Drones", "capture", "aerial", "photographs", "stunning", "angles", "from"),
            correctSentence = "Drones capture aerial photographs from stunning angles.",
            sinhalaMeaning = "ඩ්‍රෝන යානා විශ්මයජනක කෝණවලින් ගුවන් ඡායාරූප ලබා ගනී.",
            hint = "Subject + capture + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c9_p18",
            scrambledWords = listOf("engineers", "design", "safer", "bridges", "modern", "tools", "using"),
            correctSentence = "Engineers design safer bridges using modern tools.",
            sinhalaMeaning = "ඉංජිනේරුවන් නවීන මෙවලම් භාවිතයෙන් වඩාත් ආරක්ෂිත පාලම් සැලසුම් කරයි.",
            hint = "Subject + verb + comparative object + participial clause."
          ),
          SentencePuzzleItem(
            id = "c9_p19",
            scrambledWords = listOf("antibiotics", "cure", "many", "bacterial", "infections"),
            correctSentence = "Antibiotics cure many bacterial infections.",
            sinhalaMeaning = "ප්‍රතිජීවක ඖෂධ බොහෝ බැක්ටීරියා ආසාදන සුවපත් කරයි.",
            hint = "Subject + cure + quantifier + adjective + noun."
          ),
          SentencePuzzleItem(
            id = "c9_p20",
            scrambledWords = listOf("Technology", "should", "used", "be", "peaceful", "purposes", "for"),
            correctSentence = "Technology should be used for peaceful purposes.",
            sinhalaMeaning = "තාක්ෂණය සාමකාමී අරමුණු සඳහා භාවිත කළ යුතුය.",
            hint = "Passive modal: should be used + for purpose."
          )
        )
      ),

      // ==========================================
      // Category 10: Health, Balanced Diet & Good Habits (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 10,
        titleSinhala = "කාණ්ඩය 10: සෞඛ්‍යය, සමබල ආහාර සහ යහපත් පුරුදු",
        titleEnglish = "Health, Balanced Diet & Good Habits",
        icon = "🍎",
        description = "නිරෝගී දිවිපෙවෙත, සමබල ආහාර වේලක් ගැනීම සහ ව්‍යායාම පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c10_p1",
            scrambledWords = listOf("balanced", "diet", "A", "contains", "nutrients", "all", "essential"),
            correctSentence = "A balanced diet contains all essential nutrients.",
            sinhalaMeaning = "සමබල ආහාර වේලක සියලුම අත්‍යවශ්‍ය පෝෂ්‍ය පදාර්ථ අඩංගු වේ.",
            hint = "Subject (A balanced diet) + Verb (contains) + Object."
          ),
          SentencePuzzleItem(
            id = "c10_p2",
            scrambledWords = listOf("Drinking", "plenty", "water", "keeps", "body", "of", "hydrated", "our"),
            correctSentence = "Drinking plenty of water keeps our body hydrated.",
            sinhalaMeaning = "ප්‍රමාණවත් තරම් ජලය පානය කිරීම අපගේ සිරුර සජලීව තබයි.",
            hint = "Gerund subject + keeps + object + adjective."
          ),
          SentencePuzzleItem(
            id = "c10_p3",
            scrambledWords = listOf("exercise", "Regular", "strengthens", "muscles", "heart", "and"),
            correctSentence = "Regular exercise strengthens heart and muscles.",
            sinhalaMeaning = "නිතිපතා ව්‍යායාම කිරීම හදවත සහ මාංශ පේශි ශක්තිමත් කරයි.",
            hint = "Subject phrase + strengthens + compound object."
          ),
          SentencePuzzleItem(
            id = "c10_p4",
            scrambledWords = listOf("Wash", "hands", "with", "soap", "eating", "before", "food"),
            correctSentence = "Wash hands with soap before eating food.",
            sinhalaMeaning = "ආහාර ගැනීමට පෙර සබන් යොදා දෑත් සෝදන්න.",
            hint = "Imperative verb + hands + with soap + time phrase."
          ),
          SentencePuzzleItem(
            id = "c10_p5",
            scrambledWords = listOf("sleep", "Eight", "hours", "nightly", "is", "vital", "good", "for", "health"),
            correctSentence = "Eight hours sleep nightly is vital for good health.",
            sinhalaMeaning = "රාත්‍රියට පැය අටක නින්දක් ලැබීම යහපත් සෞඛ්‍යයට අත්‍යවශ්‍ය වේ.",
            hint = "Subject phrase + is vital for + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c10_p6",
            scrambledWords = listOf("green", "leafy", "Eat", "vegetables", "vitamins", "for"),
            correctSentence = "Eat green leafy vegetables for vitamins.",
            sinhalaMeaning = "විටමින් ලබාගැනීම සඳහා තද කොළ පැහැති පලා වර්ග ආහාරයට ගන්න.",
            hint = "Imperative: Eat + adjective phrase + noun + purpose."
          ),
          SentencePuzzleItem(
            id = "c10_p7",
            scrambledWords = listOf("Avoid", "excessive", "sugar", "and", "oily", "food"),
            correctSentence = "Avoid excessive sugar and oily food.",
            sinhalaMeaning = "අධික සීනි සහ තෙල් සහිත ආහාර ගැනීමෙන් වළකින්න.",
            hint = "Imperative: Avoid + compound object."
          ),
          SentencePuzzleItem(
            id = "c10_p8",
            scrambledWords = listOf("health", "is", "Good", "wealth", "greatest", "man", "of"),
            correctSentence = "Good health is greatest wealth of man.",
            sinhalaMeaning = "යහපත් සෞඛ්‍යය මිනිසාගේ උතුම්ම ධනයයි (ආරෝග්‍යා පරමා ලාභා).",
            hint = "Proverb: Good health is greatest wealth of man."
          ),
          SentencePuzzleItem(
            id = "c10_p9",
            scrambledWords = listOf("Yoga", "helps", "calm", "both", "mind", "body", "and"),
            correctSentence = "Yoga helps calm both mind and body.",
            sinhalaMeaning = "යෝග අභ්‍යාස මනස සහ ශරීරය යන දෙකම සන්සුන් කිරීමට උපකාරී වේ.",
            hint = "Subject + helps calm + correlative phrase (both X and Y)."
          ),
          SentencePuzzleItem(
            id = "c10_p10",
            scrambledWords = listOf("Smoking", "causes", "deadly", "diseases", "lung", "cancer", "like"),
            correctSentence = "Smoking causes deadly diseases like lung cancer.",
            sinhalaMeaning = "දුම්පානය පෙනහළු පිළිකා වැනි මාරාන්තික රෝග ඇති කරයි.",
            hint = "Gerund subject + causes + object + example preposition."
          ),
          SentencePuzzleItem(
            id = "c10_p11",
            scrambledWords = listOf("Fresh", "fruits", "boost", "immune", "system", "our"),
            correctSentence = "Fresh fruits boost our immune system.",
            sinhalaMeaning = "නැවුම් පලතුරු අපගේ ප්‍රතිශක්තිකරණ පද්ධතිය ශක්තිමත් කරයි.",
            hint = "Subject phrase + boost + possessive object phrase."
          ),
          SentencePuzzleItem(
            id = "c10_p12",
            scrambledWords = listOf("brush", "teeth", "Twice", "day", "a", "cavities", "prevent", "to"),
            correctSentence = "Brush teeth twice a day to prevent cavities.",
            sinhalaMeaning = "දත් දිරායාම වැළැක්වීම සඳහා දිනකට දෙවරක් දත් මදින්න.",
            hint = "Imperative + frequency + purpose."
          ),
          SentencePuzzleItem(
            id = "c10_p13",
            scrambledWords = listOf("Sedentary", "lifestyle", "leads", "obesity", "to", "early"),
            correctSentence = "Sedentary lifestyle leads to early obesity.",
            sinhalaMeaning = "අලස/සුව පහසු ජීවන රටාව නොමේරූ තරබාරුකමට මඟ පාදයි.",
            hint = "Subject phrase + leads to + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c10_p14",
            scrambledWords = listOf("Walking", "briskly", "burns", "excess", "body", "fat"),
            correctSentence = "Walking briskly burns excess body fat.",
            sinhalaMeaning = "වේගයෙන් ඇවිදීම ශරීරයේ අතිරික්ත මේදය දහනය කරයි.",
            hint = "Gerund + adverb + verb + adjective + object."
          ),
          SentencePuzzleItem(
            id = "c10_p15",
            scrambledWords = listOf("dairy", "products", "Provide", "calcium", "strong", "bones", "for"),
            correctSentence = "Dairy products provide calcium for strong bones.",
            sinhalaMeaning = "කිරි නිෂ්පාදන ශක්තිමත් අස්ථි සඳහා කැල්සියම් සපයයි.",
            hint = "Subject + provide + object + for phrase."
          ),
          SentencePuzzleItem(
            id = "c10_p16",
            scrambledWords = listOf("Mental", "health", "equally", "is", "physical", "health", "with", "important"),
            correctSentence = "Mental health is equally important with physical health.",
            sinhalaMeaning = "මානසික සෞඛ්‍යය ශාරීරික සෞඛ්‍යය තරම්ම වැදගත් වේ.",
            hint = "Subject + is + adverb + adjective + comparison."
          ),
          SentencePuzzleItem(
            id = "c10_p17",
            scrambledWords = listOf("clean", "Keep", "drinking", "water", "covered", "vessel", "in"),
            correctSentence = "Keep clean drinking water covered in vessel.",
            sinhalaMeaning = "පිරිසිදු පානීය ජලය භාජනයක වසා තබන්න.",
            hint = "Imperative + object + participle + location."
          ),
          SentencePuzzleItem(
            id = "c10_p18",
            scrambledWords = listOf("outdoor", "Playing", "games", "keeps", "active", "children"),
            correctSentence = "Playing outdoor games keeps children active.",
            sinhalaMeaning = "එළිමහන් ක්‍රීඩා කිරීම දරුවන් ක්‍රියාශීලීව තබයි.",
            hint = "Gerund subject + keeps + object + adjective."
          ),
          SentencePuzzleItem(
            id = "c10_p19",
            scrambledWords = listOf("doctor", "Consult", "a", "symptoms", "when", "persist"),
            correctSentence = "Consult a doctor when symptoms persist.",
            sinhalaMeaning = "රෝග ලක්ෂණ දිගටම පවතී නම් වෛද්‍යවරයකු හමුවන්න.",
            hint = "Imperative + object + time clause."
          ),
          SentencePuzzleItem(
            id = "c10_p20",
            scrambledWords = listOf("apple", "An", "day", "a", "keeps", "doctor", "away", "the"),
            correctSentence = "An apple a day keeps the doctor away.",
            sinhalaMeaning = "දිනකට ඇපල් ගෙඩියක් කෑමෙන් වෛද්‍යවරයාගෙන් ඈත් වී සිටිය හැක.",
            hint = "Famous English proverb."
          )
        )
      )
    )
  }
}
