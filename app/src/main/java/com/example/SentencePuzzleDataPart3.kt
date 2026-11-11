package com.example

object SentencePuzzleDataPart3 {
  fun getCategoriesPart3(): List<SentencePuzzleCategory> {
    return listOf(
      // ==========================================
      // Category 21: Famous Personalities & National Heroes (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 21,
        titleSinhala = "කාණ්ඩය 21: ශ්‍රේෂ්ඨ නායකයින් සහ ජාතික විරුවන්",
        titleEnglish = "Famous Leaders & Historical Personalities",
        icon = "🎖️",
        description = "ශ්‍රී ලංකාවේ සහ ලෝකයේ ශ්‍රේෂ්ඨ නායකයින්, නිදහස් සටන්කාමීන් සහ ආදර්ශවත් චරිත පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c21_p1",
            scrambledWords = listOf("Anagarika", "Dharmapala", "awakened", "national", "the", "Sinhala", "spirit"),
            correctSentence = "Anagarika Dharmapala awakened the Sinhala national spirit.",
            sinhalaMeaning = "අනගාරික ධර්මපාලතුමා සිංහල ජාතික හැඟීම අවදි කළේය.",
            hint = "Subject + awakened + object phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p2",
            scrambledWords = listOf("Mahatma", "Gandhi", "won", "freedom", "non-violent", "through", "protest"),
            correctSentence = "Mahatma Gandhi won freedom through non-violent protest.",
            sinhalaMeaning = "මහත්මා ගාන්ධිතුමා අහිංසාවාදී විරෝධතා තුළින් නිදහස දිනාගත්තේය.",
            hint = "Subject + won freedom + through phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p3",
            scrambledWords = listOf("Nelson", "Mandela", "fought", "against", "apartheid", "in", "South", "Africa"),
            correctSentence = "Nelson Mandela fought against apartheid in South Africa.",
            sinhalaMeaning = "නෙල්සන් මැන්ඩෙලා දකුණු අප්‍රිකාවේ වර්ණභේදවාදයට එරෙහිව සටන් කළේය.",
            hint = "Subject + fought against + noun + location."
          ),
          SentencePuzzleItem(
            id = "c21_p4",
            scrambledWords = listOf("C.W.W.", "Kannangara", "introduced", "free", "education", "Sri", "Lanka", "to"),
            correctSentence = "C.W.W. Kannangara introduced free education to Sri Lanka.",
            sinhalaMeaning = "සී.ඩබ්.ඩබ්. කන්නන්ගර මැතිතුමා ශ්‍රී ලංකාවට නිදහස් අධ්‍යාපනය හඳුන්වා දුන්නේය.",
            hint = "Father of free education: Subject + introduced + object + to country."
          ),
          SentencePuzzleItem(
            id = "c21_p5",
            scrambledWords = listOf("Albert", "Einstein", "proposed", "theory", "the", "relativity", "of"),
            correctSentence = "Albert Einstein proposed the theory of relativity.",
            sinhalaMeaning = "ඇල්බට් අයින්ස්ටයින් සාපේක්ෂතාවාදය පිළිබඳ න්‍යාය ඉදිරිපත් කළේය.",
            hint = "Subject + proposed + object phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p6",
            scrambledWords = listOf("Mother", "Teresa", "served", "the", "poorest", "of", "poor", "Kolkata", "in"),
            correctSentence = "Mother Teresa served the poorest of poor in Kolkata.",
            sinhalaMeaning = "තෙරේසා මව්තුමිය කොල්කටාහි අන්ත අසරණයින්ට සේවය කළාය.",
            hint = "Subject + served + object phrase + city."
          ),
          SentencePuzzleItem(
            id = "c21_p7",
            scrambledWords = listOf("King", "Dutugemunu", "united", "the", "island", "ancient", "in", "times"),
            correctSentence = "King Dutugemunu united the island in ancient times.",
            sinhalaMeaning = "දුටුගැමුණු රජතුමා පුරාණ කාලයේදී මුළු දිවයින එක්සේසත් කළේය.",
            hint = "Subject + united + object + time phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p8",
            scrambledWords = listOf("Martin", "Luther", "King", "had", "dream", "a", "racial", "equality", "for"),
            correctSentence = "Martin Luther King had a dream for racial equality.",
            sinhalaMeaning = "මාර්ටින් ලූතර් කිං ජාතිවාදී සමානාත්මතාවය වෙනුවෙන් සිහිනයක් දුටුවේය.",
            hint = "Subject + had a dream + purpose."
          ),
          SentencePuzzleItem(
            id = "c21_p9",
            scrambledWords = listOf("Sirimavo", "Bandaranaike", "became", "first", "woman", "prime", "minister", "world"),
            correctSentence = "Sirimavo Bandaranaike became world first woman prime minister.",
            sinhalaMeaning = "සිරිමාවෝ බණ්ඩාරනායක මැතිණිය ලොව ප්‍රථම අගමැතිනිය බවට පත්වූවාය.",
            hint = "Subject + became + title."
          ),
          SentencePuzzleItem(
            id = "c21_p10",
            scrambledWords = listOf("Marie", "Curie", "discovered", "radium", "won", "two", "Nobel", "Prizes", "and"),
            correctSentence = "Marie Curie discovered radium and won two Nobel Prizes.",
            sinhalaMeaning = "මාරි කියුරි රේඩියම් සොයා ගත් අතර නොබෙල් ත්‍යාග දෙකක් දිනා ගත්තාය.",
            hint = "Subject + compound predicate."
          ),
          SentencePuzzleItem(
            id = "c21_p11",
            scrambledWords = listOf("Great", "leaders", "inspire", "people", "achieve", "impossible", "goals", "to"),
            correctSentence = "Great leaders inspire people to achieve impossible goals.",
            sinhalaMeaning = "ශ්‍රේෂ්ඨ නායකයෝ කළ නොහැකි යැයි සිතන ඉලක්ක සපුරා ගැනීමට මිනිසුන් පෙළඹවෙති.",
            hint = "Subject + inspire + object + infinitive."
          ),
          SentencePuzzleItem(
            id = "c21_p12",
            scrambledWords = listOf("Kandula", "was", "the", "royal", "elephant", "King", "of", "Dutugemunu"),
            correctSentence = "Kandula was the royal elephant of King Dutugemunu.",
            sinhalaMeaning = "කණ්ඩුල යනු දුටුගැමුණු රජුගේ රාජකීය ඇතාය.",
            hint = "Subject + was + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p13",
            scrambledWords = listOf("Abraham", "Lincoln", "abolished", "slavery", "United", "States", "in"),
            correctSentence = "Abraham Lincoln abolished slavery in United States.",
            sinhalaMeaning = "ඒබ්‍රහම් ලින්කන් එක්සත් ජනපදයේ වහල්භාවය අහෝසි කළේය.",
            hint = "Subject + abolished + object + place."
          ),
          SentencePuzzleItem(
            id = "c21_p14",
            scrambledWords = listOf("Courage", "defines", "character", "a", "true", "hero", "of"),
            correctSentence = "Courage defines character of a true hero.",
            sinhalaMeaning = "ධෛර්යය සැබෑ වීරයෙකුගේ චරිතය නිර්වචනය කරයි.",
            hint = "Subject + defines + object phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p15",
            scrambledWords = listOf("Helen", "Keller", "overcame", "blindness", "and", "deafness", "with", "courage"),
            correctSentence = "Helen Keller overcame blindness and deafness with courage.",
            sinhalaMeaning = "හෙලන් කෙලර් අන්ධභාවය සහ බිහිරිභාවය ධෛර්යයෙන් යුතුව ජයගත්තාය.",
            hint = "Subject + overcame + compound nouns + manner."
          ),
          SentencePuzzleItem(
            id = "c21_p16",
            scrambledWords = listOf("Monaragala", "Keppetipola", "led", "freedom", "struggle", "1818", "in"),
            correctSentence = "Monaragala Keppetipola led freedom struggle in 1818.",
            sinhalaMeaning = "කැප්පෙටිපොළ නිලමේතුමා 1818 නිදහස් අරගලයට නායකත්වය දුන්නේය.",
            hint = "Subject + led + object + year."
          ),
          SentencePuzzleItem(
            id = "c21_p17",
            scrambledWords = listOf("Wright", "brothers", "built", "first", "powered", "airplane", "the"),
            correctSentence = "Wright brothers built the first powered airplane.",
            sinhalaMeaning = "රයිට් සහෝදරයෝ පළමු බලගැන්වූ ගුවන් යානය නිර්මාණය කළහ.",
            hint = "Subject + built + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p18",
            scrambledWords = listOf("Florence", "Nightingale", "founded", "modern", "nursing", "profession"),
            correctSentence = "Florence Nightingale founded modern nursing profession.",
            sinhalaMeaning = "ෆ්ලෝරන්ස් නයිටිංගේල් නවීන හෙද වෘත්තිය ආරම්භ කළාය.",
            hint = "Subject + founded + object phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p19",
            scrambledWords = listOf("History", "remembers", "sacrifices", "made", "for", "nation"),
            correctSentence = "History remembers sacrifices made for nation.",
            sinhalaMeaning = "ජාතිය වෙනුවෙන් කළ කැපකිරීම් ඉතිහාසය සිහිපත් කරයි.",
            hint = "Subject + remembers + object + participle phrase."
          ),
          SentencePuzzleItem(
            id = "c21_p20",
            scrambledWords = listOf("Role", "models", "guide", "youth", "towards", "righteousness"),
            correctSentence = "Role models guide youth towards righteousness.",
            sinhalaMeaning = "ආදර්ශමත් චරිත තරුණ පරපුර ධාර්මිෂ්ඨකම කරා යොමු කරයි.",
            hint = "Subject + guide + object + prepositional direction."
          )
        )
      ),

      // ==========================================
      // Category 22: Art, Music, Literature & Drama (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 22,
        titleSinhala = "කාණ්ඩය 22: කලාව, සාහිත්‍යය, සංගීතය සහ නාට්‍ය",
        titleEnglish = "Arts, Literature, Music & Culture",
        icon = "🎭",
        description = "චිත්‍ර කලාව, සාම්ප්‍රදායික නැටුම්, සංගීතය, කවි සහ නාට්‍ය පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c22_p1",
            scrambledWords = listOf("traditional", "Kandyan", "dancing", "is", "cultural", "heritage", "rich", "a"),
            correctSentence = "Kandyan dancing is a rich traditional cultural heritage.",
            sinhalaMeaning = "උඩරට නැටුම් යනු පොහොසත් සාම්ප්‍රදායික සංස්කෘතික උරුමයකි.",
            hint = "Subject + is + article + adjective string + noun."
          ),
          SentencePuzzleItem(
            id = "c22_p2",
            scrambledWords = listOf("Shakespeare", "wrote", "timeless", "plays", "Hamlet", "like"),
            correctSentence = "Shakespeare wrote timeless plays like Hamlet.",
            sinhalaMeaning = "ෂේක්ස්පියර් හැම්ලට් වැනි සදාකාලික නාට්‍ය රචනා කළේය.",
            hint = "Subject + wrote + object + prepositional example."
          ),
          SentencePuzzleItem(
            id = "c22_p3",
            scrambledWords = listOf("Music", "soothes", "troubled", "mind", "bring", "peace", "to"),
            correctSentence = "Music soothes troubled mind to bring peace.",
            sinhalaMeaning = "සංගීතය මනස සනසවා සාමය ගෙන දෙයි.",
            hint = "Subject + soothes + object + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c22_p4",
            scrambledWords = listOf("frescoes", "Sigiriya", "depict", "heavenly", "maidens", "graceful"),
            correctSentence = "Sigiriya frescoes depict graceful heavenly maidens.",
            sinhalaMeaning = "සීගිරි බිතුසිතුවම් මගින් මනරම් දිව්‍ය අප්සරාවන් නිරූපණය කරයි.",
            hint = "Subject + depict + adjective phrase + noun."
          ),
          SentencePuzzleItem(
            id = "c22_p5",
            scrambledWords = listOf("Poetry", "expresses", "deep", "human", "emotions", "words", "in", "few"),
            correctSentence = "Poetry expresses deep human emotions in few words.",
            sinhalaMeaning = "කාව්‍යය සුළු වචන කිහිපයකින් ගැඹුරු මිනිස් හැඟීම් ප්‍රකාශ කරයි.",
            hint = "Subject + expresses + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c22_p6",
            scrambledWords = listOf("Martin", "Wickramasinghe", "wrote", "famous", "novel", "Gamperaliya"),
            correctSentence = "Martin Wickramasinghe wrote famous novel Gamperaliya.",
            sinhalaMeaning = "මාර්ටින් වික්‍රමසිංහයන් සුප්‍රකට 'ගම්පෙරළිය' නවකතාව රචනා කළේය.",
            hint = "Subject + wrote + object apposition."
          ),
          SentencePuzzleItem(
            id = "c22_p7",
            scrambledWords = listOf("violins", "play", "Musicians", "sweet", "melodies", "in", "orchestra"),
            correctSentence = "Musicians play sweet melodies violins in orchestra.",
            sinhalaMeaning = "සංගීතඥයෝ වාද්‍ය වෘන්දයේ මිහිරි තනු වාදනය කරති.",
            hint = "Subject + play + object + context."
          ),
          SentencePuzzleItem(
            id = "c22_p8",
            scrambledWords = listOf("Dramatists", "stage", "meaningful", "plays", "society", "reflect", "to"),
            correctSentence = "Dramatists stage meaningful plays to reflect society.",
            sinhalaMeaning = "නාට්‍යකරුවෝ සමාජය පිළිබිඹු කිරීම සඳහා අර්ථවත් නාට්‍ය වේදිකාගත කරති.",
            hint = "Subject + stage + object + infinitive."
          ),
          SentencePuzzleItem(
            id = "c22_p9",
            scrambledWords = listOf("pottery", "Clay", "ancient", "craft", "an", "is", "traditional"),
            correctSentence = "Clay pottery is an ancient traditional craft.",
            sinhalaMeaning = "මැටි වළං කර්මාන්තය පැරණි සාම්ප්‍රදායික කර්මාන්තයකි.",
            hint = "Subject + is + article + adjectives + noun."
          ),
          SentencePuzzleItem(
            id = "c22_p10",
            scrambledWords = listOf("Drumming", "rhythm", "creates", "vibrant", "energy", "parade", "in"),
            correctSentence = "Drumming rhythm creates vibrant energy in parade.",
            sinhalaMeaning = "බෙර වැයීමේ රිද්මය පෙරහැරේදී සජීවී උද්‍යෝගයක් ඇති කරයි.",
            hint = "Subject phrase + creates + object + location."
          ),
          SentencePuzzleItem(
            id = "c22_p11",
            scrambledWords = listOf("Literature", "mirrors", "culture", "and", "human", "history"),
            correctSentence = "Literature mirrors culture and human history.",
            sinhalaMeaning = "සාහිත්‍යය සංස්කෘතිය සහ මිනිස් ඉතිහාසය පිළිබිඹු කරයි.",
            hint = "Subject + mirrors + compound objects."
          ),
          SentencePuzzleItem(
            id = "c22_p12",
            scrambledWords = listOf("actor", "The", "performed", "brilliantly", "on", "the", "stage"),
            correctSentence = "The actor performed brilliantly on the stage.",
            sinhalaMeaning = "නළුවා වේදිකාව මත විශිෂ්ට ලෙස රඟපෑවේය.",
            hint = "Subject + performed + adverb + location."
          ),
          SentencePuzzleItem(
            id = "c22_p13",
            scrambledWords = listOf("paintings", "Oil", "require", "delicate", "brush", "strokes"),
            correctSentence = "Oil paintings require delicate brush strokes.",
            sinhalaMeaning = "තෙල් සායම් චිත්‍ර සඳහා සියුම් බුරුසු පහරවල් අවශ්‍ය වේ.",
            hint = "Subject + require + adjective + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c22_p14",
            scrambledWords = listOf("folk", "Traditional", "songs", "tell", "tales", "ancestral", "of"),
            correctSentence = "Traditional folk songs tell tales of ancestral.",
            sinhalaMeaning = "පැරණි ජන ගී මුතුන් මිත්තන්ගේ කතාන්තර කියාපායි.",
            hint = "Subject phrase + tell + object phrase."
          ),
          SentencePuzzleItem(
            id = "c22_p15",
            scrambledWords = listOf("masks", "Wooden", "carved", "are", "Ambalangoda", "in", "skillfully"),
            correctSentence = "Wooden masks are skillfully carved in Ambalangoda.",
            sinhalaMeaning = "අම්බලන්ගොඩදී ලී වෙස්මුහුණු ඉතා දක්ෂ ලෙස කැටයම් කරනු ලැබේ.",
            hint = "Passive: Subject + are + adverb + V3 + location."
          ),
          SentencePuzzleItem(
            id = "c22_p16",
            scrambledWords = listOf("Reading", "fiction", "nurtures", "creative", "imagination", "children", "in"),
            correctSentence = "Reading fiction nurtures creative imagination in children.",
            sinhalaMeaning = "ප්‍රබන්ධ කියවීම දරුවන් තුළ නිර්මාණාත්මක පරිකල්පනය පෝෂණය කරයි.",
            hint = "Gerund subject + nurtures + object + recipient."
          ),
          SentencePuzzleItem(
            id = "c22_p17",
            scrambledWords = listOf("auditorium", "The", "echoed", "applause", "with", "thunderous"),
            correctSentence = "The auditorium echoed with thunderous applause.",
            sinhalaMeaning = "ශ්‍රවණාගාරය ගිගුරුම් සහිත අත්පොළසන් නාදයෙන් දෝංකාර දුන්නේය.",
            hint = "Subject + echoed + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c22_p18",
            scrambledWords = listOf("sculptor", "The", "shaped", "marble", "into", "statue", "lifelike", "a"),
            correctSentence = "The sculptor shaped marble into a lifelike statue.",
            sinhalaMeaning = "ভাস්කරයා කිරිගරුඬ සජීවී ප්‍රතිමාවක් බවට පත් කළේය.",
            hint = "Subject + shaped + object + into phrase."
          ),
          SentencePuzzleItem(
            id = "c22_p19",
            scrambledWords = listOf("Art", "unites", "people", "across", "linguistic", "boundaries"),
            correctSentence = "Art unites people across linguistic boundaries.",
            sinhalaMeaning = "කලාව භාෂා සීමා මායිම් ඉක්මවා මිනිසුන් එකමුතු කරයි.",
            hint = "Subject + unites + object + across phrase."
          ),
          SentencePuzzleItem(
            id = "c22_p20",
            scrambledWords = listOf("melody", "sweet", "A", "lingers", "mind", "in", "long", "after"),
            correctSentence = "A sweet melody lingers in mind long after.",
            sinhalaMeaning = "මිහිරි තනුවක් දිගු වේලාවක් මනසේ රැඳී පවතී.",
            hint = "Subject + lingers + location + time adverb."
          )
        )
      ),

      // ==========================================
      // Category 23: Ocean Life, Coral Reefs & Water Resources (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 23,
        titleSinhala = "කාණ්ඩය 23: සාගර ජීවීන්, කොරල්පර සහ ජල සම්පත",
        titleEnglish = "Oceans, Marine Life & Water Conservation",
        icon = "🌊",
        description = "මුහුදු ජීවීන්, කොරල්පර, තල්මසුන් සහ සාගර දූෂණය වැළැක්වීම පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c23_p1",
            scrambledWords = listOf("Oceans", "cover", "than", "more", "seventy", "percent", "earth", "surface", "of"),
            correctSentence = "Oceans cover more than seventy percent of earth surface.",
            sinhalaMeaning = "සාගර පෘථිවි පෘෂ්ඨයෙන් සියයට හැත්තෑවකට වඩා ආවරණය කරයි.",
            hint = "Subject + cover + quantity phrase + object."
          ),
          SentencePuzzleItem(
            id = "c23_p2",
            scrambledWords = listOf("Blue", "whales", "are", "largest", "the", "animals", "planet", "on"),
            correctSentence = "Blue whales are the largest animals on planet.",
            sinhalaMeaning = "නිල් තල්මසුන් පෘථිවියේ විශාලතම සතුන් වේ.",
            hint = "Subject + are + superlative adjective phrase."
          ),
          SentencePuzzleItem(
            id = "c23_p3",
            scrambledWords = listOf("Coral", "reefs", "are", "nurseries", "fish", "marine", "for"),
            correctSentence = "Coral reefs are nurseries for marine fish.",
            sinhalaMeaning = "කොරල්පර යනු සාගර මත්ස්‍යයන්ගේ තවාන් බඳුය.",
            hint = "Subject + are + predicate noun + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c23_p4",
            scrambledWords = listOf("Plastic", "waste", "kills", "thousands", "of", "turtles", "sea"),
            correctSentence = "Plastic waste kills thousands of sea turtles.",
            sinhalaMeaning = "ප්ලාස්ටික් අපද්‍රව්‍ය දහස් ගණනක් මුහුදු කැස්බෑවන් මරා දමයි.",
            hint = "Subject phrase + kills + quantifier + object."
          ),
          SentencePuzzleItem(
            id = "c23_p5",
            scrambledWords = listOf("Mangroves", "protect", "coastal", "areas", "tsunami", "from", "waves"),
            correctSentence = "Mangroves protect coastal areas from tsunami waves.",
            sinhalaMeaning = "කඩොලාන ශාක වෙරළබඩ ප්‍රදේශ සුනාමි රළින් ආරක්ෂා කරයි.",
            hint = "Subject + protect + object + from phrase."
          ),
          SentencePuzzleItem(
            id = "c23_p6",
            scrambledWords = listOf("Overfishing", "depletes", "valuable", "fish", "stocks", "rapidly"),
            correctSentence = "Overfishing depletes valuable fish stocks rapidly.",
            sinhalaMeaning = "අධික ලෙස මසුන් ඇල්ලීම වටිනා මත්ස්‍ය සම්පත ශීඝ්‍රයෙන් ක්ෂය කරයි.",
            hint = "Gerund subject + depletes + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c23_p7",
            scrambledWords = listOf("Clean", "water", "is", "fundamental", "right", "human", "a"),
            correctSentence = "Clean water is a fundamental human right.",
            sinhalaMeaning = "පිරිසිදු ජලය යනු මූලික මානව අයිතිවාසිකමකි.",
            hint = "Subject phrase + is + article + adjective + noun."
          ),
          SentencePuzzleItem(
            id = "c23_p8",
            scrambledWords = listOf("Do", "not", "throw", "garbage", "beaches", "onto", "golden"),
            correctSentence = "Do not throw garbage onto golden beaches.",
            sinhalaMeaning = "රන්වන් වෙරළ තීරයන් මතට කුණු කසළ නොදමන්න.",
            hint = "Negative imperative + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c23_p9",
            scrambledWords = listOf("Dolphins", "leap", "playfully", "above", "blue", "waves"),
            correctSentence = "Dolphins leap playfully above blue waves.",
            sinhalaMeaning = "ඩොල්ෆින් මසුන් නිල් රළ මතින් සෙල්ලක්කාර ලෙස උඩ පනිති.",
            hint = "Subject + verb + adverb + location."
          ),
          SentencePuzzleItem(
            id = "c23_p10",
            scrambledWords = listOf("Oil", "spills", "destroy", "fragile", "marine", "ecosystems"),
            correctSentence = "Oil spills destroy fragile marine ecosystems.",
            sinhalaMeaning = "තෙල් කාන්දුවීම් බිඳෙනසුලු සාගර පරිසර පද්ධති විනාශ කරයි.",
            hint = "Subject + destroy + adjective phrase + noun."
          ),
          SentencePuzzleItem(
            id = "c23_p11",
            scrambledWords = listOf("Never", "disturb", "nesting", "sea", "turtles", "night", "at"),
            correctSentence = "Never disturb nesting sea turtles at night.",
            sinhalaMeaning = "රාත්‍රී කාලයේ බිත්තර දමන මුහුදු කැස්බෑවන්ට කිසිවිටෙකත් බාධා නොකරන්න.",
            hint = "Adverb + Imperative + object + time."
          ),
          SentencePuzzleItem(
            id = "c23_p12",
            scrambledWords = listOf("Scuba", "divers", "explore", "underwater", "shipwrecks", "mysterious"),
            correctSentence = "Scuba divers explore mysterious underwater shipwrecks.",
            sinhalaMeaning = "කිමිදුම්කරුවෝ අද්භූත දිය යට නැව් සුන්බුන් ගවේෂණය කරති.",
            hint = "Subject + explore + adjective phrase + object."
          ),
          SentencePuzzleItem(
            id = "c23_p13",
            scrambledWords = listOf("Freshwater", "lakes", "sustain", "countless", "migratory", "birds"),
            correctSentence = "Freshwater lakes sustain countless migratory birds.",
            sinhalaMeaning = "මිරිදිය විල් අසංඛ්‍යාත සංක්‍රමණික පක්ෂීන් නඩත්තු කරයි.",
            hint = "Subject + sustain + quantifier + object."
          ),
          SentencePuzzleItem(
            id = "c23_p14",
            scrambledWords = listOf("Save", "drop", "every", "future", "water", "of", "generations", "for"),
            correctSentence = "Save every drop of water for future generations.",
            sinhalaMeaning = "අනාගත පරපුර වෙනුවෙන් සෑම ජල බිඳක්ම සුරකින්න.",
            hint = "Imperative + object phrase + for phrase."
          ),
          SentencePuzzleItem(
            id = "c23_p15",
            scrambledWords = listOf("Rising", "temperatures", "bleach", "vibrant", "coral", "reefs"),
            correctSentence = "Rising temperatures bleach vibrant coral reefs.",
            sinhalaMeaning = "ඉහළ යන උෂ්ණත්වය වර්ණවත් කොරල්පර සුදුමැලි වීමට (විනාශ වීමට) හේතු වේ.",
            hint = "Subject phrase + bleach + object phrase."
          ),
          SentencePuzzleItem(
            id = "c23_p16",
            scrambledWords = listOf("Seagrass", "beds", "absorb", "carbon", "rapidly"),
            correctSentence = "Seagrass beds absorb carbon rapidly.",
            sinhalaMeaning = "මුහුදු තෘණ පත්ල කාබන් ශීඝ්‍රයෙන් උරා ගනී.",
            hint = "Subject + absorb + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c23_p17",
            scrambledWords = listOf("Lighthouse", "guides", "ships", "safely", "to", "harbour"),
            correctSentence = "Lighthouse guides ships safely to harbour.",
            sinhalaMeaning = "ප්‍රදීපාගාරය නැව් වරාය වෙත ආරක්ෂිතව මෙහෙයවයි.",
            hint = "Subject + guides + object + adverb + destination."
          ),
          SentencePuzzleItem(
            id = "c23_p18",
            scrambledWords = listOf("Pigeon", "Island", "is", "marine", "national", "park", "a"),
            correctSentence = "Pigeon Island is a marine national park.",
            sinhalaMeaning = "පරෙවි දූපත (Pigeon Island) යනු සාගර ජාතික වනෝද්‍යානයකි.",
            hint = "Proper noun + is + article + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c23_p19",
            scrambledWords = listOf("Respect", "ocean", "the", "bountiful", "which", "feeds", "us"),
            correctSentence = "Respect the bountiful ocean which feeds us.",
            sinhalaMeaning = "අපව පෝෂණය කරන මහ සාගරයට ගරු කරන්න.",
            hint = "Imperative + object + relative clause."
          ),
          SentencePuzzleItem(
            id = "c23_p20",
            scrambledWords = listOf("Water", "is", "elixir", "all", "of", "earthly", "life"),
            correctSentence = "Water is elixir of all earthly life.",
            sinhalaMeaning = "ජලය යනු මිහිමත සියලු ජීවීන්ගේ ජීවාමෘතයයි.",
            hint = "Subject + is + noun phrase."
          )
        )
      ),

      // ==========================================
      // Category 24: Forests, Wildlife & Animal Welfare (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 24,
        titleSinhala = "කාණ්ඩය 24: වනාන්තර, වනජීවීන් සහ සත්ව සුබසාධනය",
        titleEnglish = "Forests, Wildlife & Animal Welfare",
        icon = "🐘",
        description = "අලි ඇතුන්, වන සතුන්, ජාතික වනෝද්‍යාන සහ සත්ව හිංසනය වැළැක්වීම පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c24_p1",
            scrambledWords = listOf("Asian", "elephant", "is", "a", "symbol", "majestic", "heritage", "of"),
            correctSentence = "Asian elephant is a majestic symbol of heritage.",
            sinhalaMeaning = "ආසියානු අලියා උරුමයේ තේජාන්විත සංකේතයකි.",
            hint = "Subject phrase + is + article + adjective + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p2",
            scrambledWords = listOf("Poachers", "kill", "elephants", "for", "valuable", "ivory", "tusks"),
            correctSentence = "Poachers kill elephants for valuable ivory tusks.",
            sinhalaMeaning = "දළ දඩයම්කරුවෝ වටිනා ඇත්දළ ලබාගැනීම සඳහා අලින් මරා දමති.",
            hint = "Subject + kill + object + purpose phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p3",
            scrambledWords = listOf("Deforestation", "destroys", "natural", "habitats", "wild", "animals", "of"),
            correctSentence = "Deforestation destroys natural habitats of wild animals.",
            sinhalaMeaning = "වන විනාශය වන සතුන්ගේ ස්වභාවික වාසස්ථාන විනාශ කරයි.",
            hint = "Subject + destroys + object phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p4",
            scrambledWords = listOf("Wildlife", "sanctuaries", "provide", "safe", "haven", "for", "beasts"),
            correctSentence = "Wildlife sanctuaries provide safe haven for beasts.",
            sinhalaMeaning = "වනජීවී අභයභූමි වන සතුන්ට ආරක්ෂිත ක්ෂේම භූමියක් සපයයි.",
            hint = "Subject + provide + object + for phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p5",
            scrambledWords = listOf("Pinnawala", "Elephant", "Orphanage", "cares", "abandoned", "for", "babies"),
            correctSentence = "Pinnawala Elephant Orphanage cares for abandoned babies.",
            sinhalaMeaning = "පින්නවල අලි අනාථාගාරය අතහැර දැමූ අලි පැටවුන් රැකබලා ගනී.",
            hint = "Proper noun + cares for + object."
          ),
          SentencePuzzleItem(
            id = "c24_p6",
            scrambledWords = listOf("Birds", "build", "nests", "high", "safe", "branches", "upon"),
            correctSentence = "Birds build nests safe upon high branches.",
            sinhalaMeaning = "කුරුල්ලන් උස් අතුවල ආරක්ෂිතව කූඩු සාදයි.",
            hint = "Subject + build + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p7",
            scrambledWords = listOf("Never", "feed", "monkeys", "national", "parks", "in"),
            correctSentence = "Never feed monkeys in national parks.",
            sinhalaMeaning = "ජාතික වනෝද්‍යානවලදී කිසිවිටෙකත් වඳුරන්ට කෑම නොදෙන්න.",
            hint = "Adverb + Imperative + object + location."
          ),
          SentencePuzzleItem(
            id = "c24_p8",
            scrambledWords = listOf("Leopards", "hunt", "prey", "stealthily", "under", "darkness", "cover"),
            correctSentence = "Leopards hunt prey stealthily under darkness cover.",
            sinhalaMeaning = "කොටියෝ අන්ධකාරයේ ආවරණය යටතේ හොර රහසේ ගොදුරු දඩයම් කරති.",
            hint = "Subject + hunt + object + adverb + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p9",
            scrambledWords = listOf("Be", "kind", "to", "all", "speechless", "living", "creatures"),
            correctSentence = "Be kind to all speechless living creatures.",
            sinhalaMeaning = "සියලුම කතා කළ නොහැකි සතුන්ට කරුණාවන්ත වන්න.",
            hint = "Imperative: Be kind to + adjective + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p10",
            scrambledWords = listOf("Forests", "act", "as", "green", "lungs", "planet", "the", "of"),
            correctSentence = "Forests act as green lungs of the planet.",
            sinhalaMeaning = "වනාන්තර පෘථිවියේ හරිත පෙණහලු ලෙස ක්‍රියා කරයි.",
            hint = "Subject + act as + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p11",
            scrambledWords = listOf("Human-elephant", "conflict", "causes", "loss", "precious", "lives", "of"),
            correctSentence = "Human-elephant conflict causes loss of precious lives.",
            sinhalaMeaning = "අලි-මිනිස් ගැටුම වටිනා ජීවිත අහිමි වීමට හේතු වේ.",
            hint = "Subject phrase + causes + object phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p12",
            scrambledWords = listOf("Peacocks", "display", "magnificent", "feathers", "monsoon", "before"),
            correctSentence = "Peacocks display magnificent feathers before monsoon.",
            sinhalaMeaning = "මෝරුන් වර්ෂාවට පෙර තම අලංකාර පිල් විහිදුවයි.",
            hint = "Subject + display + object + time."
          ),
          SentencePuzzleItem(
            id = "c24_p13",
            scrambledWords = listOf("Stop", "cruelty", "against", "innocent", "domestic", "animals"),
            correctSentence = "Stop cruelty against innocent domestic animals.",
            sinhalaMeaning = "අහිංසක ගෘහාශ්‍රිත සතුන්ට සිදුවන හිංසනය නවත්වන්න.",
            hint = "Imperative + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p14",
            scrambledWords = listOf("Wetlands", "filter", "water", "naturally", "shelter", "birds", "and"),
            correctSentence = "Wetlands filter water naturally and shelter birds.",
            sinhalaMeaning = "තෙත්බිම් ජලය ස්වභාවිකව පිරිසිදු කරන අතර පක්ෂීන්ට නවාතැන් දෙයි.",
            hint = "Subject + Compound predicate."
          ),
          SentencePuzzleItem(
            id = "c24_p15",
            scrambledWords = listOf("Rangers", "patrol", "jungles", "poaching", "prevent", "to"),
            correctSentence = "Rangers patrol jungles to prevent poaching.",
            sinhalaMeaning = "වන නිලධාරීන් දඩයම් කිරීම වැළැක්වීම සඳහා වනාන්තර මුර සංචාරයේ යෙදේ.",
            hint = "Subject + patrol + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c24_p16",
            scrambledWords = listOf("Sloth", "bears", "feed", "on", "termites", "forest", "in"),
            correctSentence = "Sloth bears feed on termites in forest.",
            sinhalaMeaning = "මන්ද වලසුන් වනාන්තරයේ වේයන් ආහාරයට ගනී.",
            hint = "Subject + feed on + object + location."
          ),
          SentencePuzzleItem(
            id = "c24_p17",
            scrambledWords = listOf("Plant", "trees", "wildlife", "corridors", "restore", "to"),
            correctSentence = "Plant trees to restore wildlife corridors.",
            sinhalaMeaning = "වනජීවී මංතීරු යථා තත්ත්වයට පත් කිරීම සඳහා ගස් සිටුවන්න.",
            hint = "Imperative + object + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c24_p18",
            scrambledWords = listOf("Sri", "Lankan", "junglefowl", "is", "national", "bird", "our"),
            correctSentence = "Sri Lankan junglefowl is our national bird.",
            sinhalaMeaning = "ශ්‍රී ලංකා වලි කුකුළා අපගේ ජාතික පක්ෂියා වේ.",
            hint = "Subject + is + possessive noun phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p19",
            scrambledWords = listOf("Animals", "have", "right", "coexist", "with", "humans", "to"),
            correctSentence = "Animals have right to coexist with humans.",
            sinhalaMeaning = "මිනිසුන් සමඟ සහජීවනයෙන් යුතුව ජීවත්වීමේ අයිතිය සතුන්ට ඇත.",
            hint = "Subject + have right to + verb phrase."
          ),
          SentencePuzzleItem(
            id = "c24_p20",
            scrambledWords = listOf("Protect", "nature", "and", "nature", "protect", "you", "will"),
            correctSentence = "Protect nature and nature will protect you.",
            sinhalaMeaning = "ඔබ සොබාදහම ආරක්ෂා කරන්න, එවිට සොබාදහම ඔබව ආරක්ෂා කරනු ඇත.",
            hint = "Imperative compound conditional."
          )
        )
      ),

      // ==========================================
      // Category 25: Money Management, Banking & Savings (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 25,
        titleSinhala = "කාණ්ඩය 25: මුදල් කළමනාකරණය, බැංකු සහ ඉතිරිකිරීම්",
        titleEnglish = "Economy, Money & Financial Literacy",
        icon = "💳",
        description = "ඉතිරිකිරීම, බැංකු ගිණුම්, අයවැය සහ මුදල් නිසි ලෙස කළමනාකරණය පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c25_p1",
            scrambledWords = listOf("Saving", "money", "secures", "peaceful", "future", "a"),
            correctSentence = "Saving money secures a peaceful future.",
            sinhalaMeaning = "මුදල් ඉතිරි කිරීම සාමකාමී අනාගතයක් සුරක්ෂිත කරයි.",
            hint = "Gerund subject + secures + article + adj + noun."
          ),
          SentencePuzzleItem(
            id = "c25_p2",
            scrambledWords = listOf("Open", "savings", "account", "bank", "at", "early", "an"),
            correctSentence = "Open a savings account early at bank.",
            sinhalaMeaning = "වේලාසනින්ම බැංකුවේ ඉතිරිකිරීමේ ගිණුමක් විවෘත කරන්න.",
            hint = "Imperative + object + adverb + location."
          ),
          SentencePuzzleItem(
            id = "c25_p3",
            scrambledWords = listOf("Penny", "saved", "is", "a", "penny", "earned", "A"),
            correctSentence = "A penny saved is a penny earned.",
            sinhalaMeaning = "ඉතිරි කළ සතය උපයාගත් සතයකි (ඉතිරි කිරීමද ඉපැයීමක් බඳුය).",
            hint = "Famous proverb: A penny saved is a penny earned."
          ),
          SentencePuzzleItem(
            id = "c25_p4",
            scrambledWords = listOf("Avoid", "unnecessary", "expenses", "daily", "routine", "in"),
            correctSentence = "Avoid unnecessary expenses in daily routine.",
            sinhalaMeaning = "දෛනික කටයුතුවලදී අනවශ්‍ය වියදම්වලින් වළකින්න.",
            hint = "Imperative + object phrase + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c25_p5",
            scrambledWords = listOf("Budgeting", "helps", "track", "monthly", "income", "expenses", "and"),
            correctSentence = "Budgeting helps track monthly income and expenses.",
            sinhalaMeaning = "අයවැයක් පිළියෙල කිරීම මාසික ආදායම් සහ වියදම් සොයා බැලීමට උපකාරී වේ.",
            hint = "Gerund subject + helps track + compound objects."
          ),
          SentencePuzzleItem(
            id = "c25_p6",
            scrambledWords = listOf("ATM", "cards", "enable", "easy", "cash", "withdrawals", "anytime"),
            correctSentence = "ATM cards enable easy cash withdrawals anytime.",
            sinhalaMeaning = "ATM කාඩ්පත් ඕනෑම වේලාවක පහසු මුදල් ආපසු ගැනීම් සක්‍රීය කරයි.",
            hint = "Subject + enable + object phrase + adverb."
          ),
          SentencePuzzleItem(
            id = "c25_p7",
            scrambledWords = listOf("Never", "share", "your", "secret", "bank", "PIN", "anyone", "with"),
            correctSentence = "Never share your secret bank PIN with anyone.",
            sinhalaMeaning = "ඔබගේ රහස්‍ය බැංකු PIN අංකය කිසිවෙකු සමඟ බෙදා නොගන්න.",
            hint = "Adverb + Imperative + object + with anyone."
          ),
          SentencePuzzleItem(
            id = "c25_p8",
            scrambledWords = listOf("Do", "not", "borrow", "money", "beyond", "repayment", "capacity"),
            correctSentence = "Do not borrow money beyond repayment capacity.",
            sinhalaMeaning = "නැවත ගෙවීමේ හැකියාව ඉක්මවා ණයට මුදල් නොගන්න.",
            hint = "Negative imperative + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c25_p9",
            scrambledWords = listOf("Invest", "in", "education", "highest", "returns", "for"),
            correctSentence = "Invest in education for highest returns.",
            sinhalaMeaning = "ඉහළම ප්‍රතිලාභ සඳහා අධ්‍යාපනයෙහි ආයෝජනය කරන්න.",
            hint = "Imperative + in education + purpose."
          ),
          SentencePuzzleItem(
            id = "c25_p10",
            scrambledWords = listOf("Banks", "offer", "interest", "on", "fixed", "deposits"),
            correctSentence = "Banks offer interest on fixed deposits.",
            sinhalaMeaning = "ස්ථාවර තැන්පතු සඳහා බැංකු පොලියක් ලබා දෙයි.",
            hint = "Subject + offer + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c25_p11",
            scrambledWords = listOf("Smart", "consumers", "compare", "prices", "buying", "before"),
            correctSentence = "Smart consumers compare prices before buying.",
            sinhalaMeaning = "බුද්ධිමත් පාරිභෝගිකයෝ මිලදී ගැනීමට පෙර මිල ගණන් සංසන්දනය කරති.",
            hint = "Subject phrase + compare + object + time."
          ),
          SentencePuzzleItem(
            id = "c25_p12",
            scrambledWords = listOf("Children", "learn", "thrift", "using", "piggy", "banks"),
            correctSentence = "Children learn thrift using piggy banks.",
            sinhalaMeaning = "කැට භාවිතයෙන් ළමයි අරපිරිමැස්ම ඉගෙන ගනිති.",
            hint = "Subject + learn + object + participle clause."
          ),
          SentencePuzzleItem(
            id = "c25_p13",
            scrambledWords = listOf("Do", "not", "fall", "into", "debt", "traps"),
            correctSentence = "Do not fall into debt traps.",
            sinhalaMeaning = "ණය උගුල්වලට හසු නොවන්න.",
            hint = "Negative imperative + into phrase."
          ),
          SentencePuzzleItem(
            id = "c25_p14",
            scrambledWords = listOf("Receipts", "provide", "proof", "legal", "purchase", "of"),
            correctSentence = "Receipts provide legal proof of purchase.",
            sinhalaMeaning = "රිසිට්පත් මිලදී ගැනීම පිළිබඳ නීත්‍යානුකූල සාක්ෂි සපයයි.",
            hint = "Subject + provide + object phrase."
          ),
          SentencePuzzleItem(
            id = "c25_p15",
            scrambledWords = listOf("Financial", "literacy", "should", "taught", "be", "schools", "in"),
            correctSentence = "Financial literacy should be taught in schools.",
            sinhalaMeaning = "මුදල් කළමනාකරණ සාක්ෂරතාවය පාසල්වල ඉගැන්විය යුතුය.",
            hint = "Modal passive: should be taught + location."
          ),
          SentencePuzzleItem(
            id = "c25_p16",
            scrambledWords = listOf("Hard", "earned", "money", "deserves", "careful", "management"),
            correctSentence = "Hard earned money deserves careful management.",
            sinhalaMeaning = "මහන්සියෙන් උපයාගත් මුදල් ප්‍රවේශමෙන් කළමනාකරණය කළ යුතුය.",
            hint = "Subject phrase + deserves + object phrase."
          ),
          SentencePuzzleItem(
            id = "c25_p17",
            scrambledWords = listOf("Check", "account", "balance", "regularly", "via", "app"),
            correctSentence = "Check account balance regularly via app.",
            sinhalaMeaning = "ඇප් එක මඟින් නිතිපතා ගිණුම් ශේෂය පරීක්ෂා කරන්න.",
            hint = "Imperative + object + adverb + through phrase."
          ),
          SentencePuzzleItem(
            id = "c25_p18",
            scrambledWords = listOf("Money", "cannot", "buy", "true", "happiness", "contentment", "and"),
            correctSentence = "Money cannot buy true happiness and contentment.",
            sinhalaMeaning = "මුදලට සැබෑ සතුට සහ තෘප්තිය මිලදී ගත නොහැක.",
            hint = "Subject + cannot buy + compound objects."
          ),
          SentencePuzzleItem(
            id = "c25_p19",
            scrambledWords = listOf("Inflation", "erodes", "purchasing", "power", "money", "of"),
            correctSentence = "Inflation erodes purchasing power of money.",
            sinhalaMeaning = "උද්ධමනය මුදලේ මිලදී ගැනීමේ හැකියාව ක්ෂය කරයි.",
            hint = "Subject + erodes + object phrase."
          ),
          SentencePuzzleItem(
            id = "c25_p20",
            scrambledWords = listOf("Live", "within", "your", "means", "peace", "for", "mind", "of"),
            correctSentence = "Live within your means for peace of mind.",
            sinhalaMeaning = "මනසේ සාමය සඳහා ඔබේ ආදායම් සීමාව තුළ ජීවත් වන්න.",
            hint = "Idiom: Live within your means."
          )
        )
      ),

      // ==========================================
      // Category 26: Renewable Energy & Climate Change (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 26,
        titleSinhala = "කාණ්ඩය 26: පුනර්ජනනීය බලශක්තිය සහ දේශගුණික විපර්යාස",
        titleEnglish = "Renewable Energy & Climate Action",
        icon = "☀️",
        description = "සූර්ය බලය, සුළං බලය, කාබන් විමෝචනය සහ පිරිසිදු බලශක්තිය පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c26_p1",
            scrambledWords = listOf("Solar", "panels", "convert", "sunlight", "clean", "into", "electricity"),
            correctSentence = "Solar panels convert sunlight into clean electricity.",
            sinhalaMeaning = "සූර්ය පැනල හිරු එළිය පිරිසිදු විදුලිය බවට පරිවර්තනය කරයි.",
            hint = "Subject + convert + object + into phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p2",
            scrambledWords = listOf("Wind", "turbines", "generate", "power", "coastal", "areas", "in"),
            correctSentence = "Wind turbines generate power in coastal areas.",
            sinhalaMeaning = "සුළං ටර්බයින වෙරළබඩ ප්‍රදේශවල බලශක්තිය උත්පාදනය කරයි.",
            hint = "Subject + generate + object + location."
          ),
          SentencePuzzleItem(
            id = "c26_p3",
            scrambledWords = listOf("Fossil", "fuels", "deplete", "release", "and", "toxic", "gases"),
            correctSentence = "Fossil fuels deplete and release toxic gases.",
            sinhalaMeaning = "ෆොසිල ඉන්ධන ක්ෂය වන අතර විෂ වායු මුදාහරියි.",
            hint = "Subject + Compound predicate."
          ),
          SentencePuzzleItem(
            id = "c26_p4",
            scrambledWords = listOf("Hydroelectric", "power", "major", "source", "is", "Sri", "Lanka", "in"),
            correctSentence = "Hydroelectric power is major source in Sri Lanka.",
            sinhalaMeaning = "ජල විදුලිය ශ්‍රී ලංකාවේ ප්‍රධාන බලශක්ති ප්‍රභවයකි.",
            hint = "Subject + is + adjective + noun + location."
          ),
          SentencePuzzleItem(
            id = "c26_p5",
            scrambledWords = listOf("Turn", "off", "lights", "leaving", "room", "before", "the"),
            correctSentence = "Turn off lights before leaving the room.",
            sinhalaMeaning = "කාමරයෙන් පිටවීමට පෙර විදුලි පහන් නිවා දමන්න.",
            hint = "Phrasal imperative (Turn off) + object + time clause."
          ),
          SentencePuzzleItem(
            id = "c26_p6",
            scrambledWords = listOf("Glaciers", "melt", "rapidly", "due", "global", "warming", "to"),
            correctSentence = "Glaciers melt rapidly due to global warming.",
            sinhalaMeaning = "ගෝලීය උණුසුම හේතුවෙන් ග්ලැසියර ශීඝ්‍රයෙන් දියවී යයි.",
            hint = "Subject + melt + adverb + due to phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p7",
            scrambledWords = listOf("Energy", "conservation", "reduces", "monthly", "electricity", "bills"),
            correctSentence = "Energy conservation reduces monthly electricity bills.",
            sinhalaMeaning = "බලශක්ති සංරක්ෂණය මාසික විදුලි බිල අඩු කරයි.",
            hint = "Subject phrase + reduces + object phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p8",
            scrambledWords = listOf("Greenhouse", "gases", "trap", "heat", "atmosphere", "in", "earth"),
            correctSentence = "Greenhouse gases trap heat in earth atmosphere.",
            sinhalaMeaning = "හරිතාගාර වායු පෘථිවි වායුගෝලයේ තාපය රඳවා ගනී.",
            hint = "Subject + trap + object + location."
          ),
          SentencePuzzleItem(
            id = "c26_p9",
            scrambledWords = listOf("Switch", "to", "LED", "bulbs", "save", "power", "to"),
            correctSentence = "Switch to LED bulbs to save power.",
            sinhalaMeaning = "විදුලිය ඉතිරි කර ගැනීමට LED බල්බ භාවිතයට මාරු වන්න.",
            hint = "Imperative (Switch to) + noun + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c26_p10",
            scrambledWords = listOf("Droughts", "become", "more", "frequent", "extreme", "weather", "with"),
            correctSentence = "Droughts become more frequent with extreme weather.",
            sinhalaMeaning = "අයහපත් කාලගුණයත් සමඟ නියඟය වඩාත් නිතර ඇතිවේ.",
            hint = "Subject + become + comparative adjective + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p11",
            scrambledWords = listOf("Biomass", "energy", "uses", "organic", "waste", "materials"),
            correctSentence = "Biomass energy uses organic waste materials.",
            sinhalaMeaning = "ජෛව ස්කන්ධ බලශක්තිය කාබනික අපද්‍රව්‍ය භාවිත කරයි.",
            hint = "Subject + uses + object phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p12",
            scrambledWords = listOf("Unplug", "chargers", "when", "devices", "fully", "charged", "are"),
            correctSentence = "Unplug chargers when devices are fully charged.",
            sinhalaMeaning = "උපාංග සම්පූර්ණයෙන් ආරෝපණය වූ පසු චාජර් විසන්ධි කරන්න.",
            hint = "Imperative + object + time clause."
          ),
          SentencePuzzleItem(
            id = "c26_p13",
            scrambledWords = listOf("Reforestation", "combats", "rising", "levels", "carbon", "dioxide", "of"),
            correctSentence = "Reforestation combats rising levels of carbon dioxide.",
            sinhalaMeaning = "නැවත වන වගාව ඉහළ යන කාබන් ඩයොක්සයිඩ් මට්ටමට එරෙහිව සටන් කරයි.",
            hint = "Subject + combats + object phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p14",
            scrambledWords = listOf("Extreme", "storms", "threaten", "coastal", "communities", "worldwide"),
            correctSentence = "Extreme storms threaten coastal communities worldwide.",
            sinhalaMeaning = "දරුණු කුණාටු ලොව පුරා වෙරළබඩ ප්‍රජාවන්ට තර්ජනයක් එල්ල කරයි.",
            hint = "Subject + threaten + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c26_p15",
            scrambledWords = listOf("Clean", "air", "is", "vital", "healthy", "lungs", "for"),
            correctSentence = "Clean air is vital for healthy lungs.",
            sinhalaMeaning = "නිරෝගී පෙනහළු සඳහා පිරිසිදු වාතය අත්‍යවශ්‍ය වේ.",
            hint = "Subject + is vital for + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p16",
            scrambledWords = listOf("Geothermal", "energy", "taps", "heat", "earth", "interior", "from"),
            correctSentence = "Geothermal energy taps heat from earth interior.",
            sinhalaMeaning = "භූතාපජ බලශක්තිය පෘථිවි අභ්‍යන්තරයෙන් තාපය ලබා ගනී.",
            hint = "Subject + taps + object + from phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p17",
            scrambledWords = listOf("Walk", "or", "cycle", "short", "distances", "for"),
            correctSentence = "Walk or cycle for short distances.",
            sinhalaMeaning = "කෙටි දුර ගමන් සඳහා පයින් යන්න හෝ පාපැදියක් පදින්න.",
            hint = "Compound imperative + for phrase."
          ),
          SentencePuzzleItem(
            id = "c26_p18",
            scrambledWords = listOf("Climate", "action", "requires", "global", "immediate", "cooperation"),
            correctSentence = "Climate action requires immediate global cooperation.",
            sinhalaMeaning = "දේශගුණික ක්‍රියාකාරකම් සඳහා ක්ෂණික ගෝලීය සහයෝගීතාව අවශ්‍ය වේ.",
            hint = "Subject + requires + adjective phrase + noun."
          ),
          SentencePuzzleItem(
            id = "c26_p19",
            scrambledWords = listOf("Earth", "Day", "inspires", "environmental", "worldwide", "stewardship"),
            correctSentence = "Earth Day inspires environmental stewardship worldwide.",
            sinhalaMeaning = "මිහි මව් දිනය ලොව පුරා පරිසර භාරකාරත්වය සඳහා පෙළඹවීමක් ඇති කරයි.",
            hint = "Proper noun + inspires + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c26_p20",
            scrambledWords = listOf("Future", "depends", "our", "green", "choices", "today", "on"),
            correctSentence = "Future depends on our green choices today.",
            sinhalaMeaning = "අපගේ අනාගතය රඳා පවතින්නේ අද අප ගන්නා හරිත තේරීම් මතය.",
            hint = "Subject + depends on + possessive noun phrase + time."
          )
        )
      ),

      // ==========================================
      // Category 27: Road Safety, Traffic Rules & Discipline (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 27,
        titleSinhala = "කාණ්ඩය 27: මාර්ග ආරක්ෂාව, රථවාහන නීති සහ විනය",
        titleEnglish = "Road Safety, Traffic Rules & Discipline",
        icon = "🚦",
        description = "මහාමාර්ග ආරක්ෂාව, පදික මාරු, රියදුරු නීති සහ හදිසි අනතුරු වැළැක්වීම පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c27_p1",
            scrambledWords = listOf("pedestrian", "Use", "crossing", "road", "cross", "busy", "to"),
            correctSentence = "Use pedestrian crossing to cross busy road.",
            sinhalaMeaning = "කාර්යබහුල මාර්ගය තරණය කිරීමට පදික මාරුව භාවිත කරන්න.",
            hint = "Imperative + object + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c27_p2",
            scrambledWords = listOf("Never", "use", "mobile", "phone", "while", "driving", "vehicle"),
            correctSentence = "Never use mobile phone while driving vehicle.",
            sinhalaMeaning = "වාහනයක් පදවන අතරතුර කිසිවිටෙකත් ජංගම දුරකථනය භාවිත නොකරන්න.",
            hint = "Adverb + Imperative + object + while clause."
          ),
          SentencePuzzleItem(
            id = "c27_p3",
            scrambledWords = listOf("Red", "traffic", "light", "signals", "drivers", "stop", "to"),
            correctSentence = "Red traffic light signals drivers to stop.",
            sinhalaMeaning = "රතු රථවාහන සංඥා එළිය රියදුරන්ට නවතින ලෙස සංඥා කරයි.",
            hint = "Subject + signals + object + to stop."
          ),
          SentencePuzzleItem(
            id = "c27_p4",
            scrambledWords = listOf("Always", "wear", "seatbelt", "travelling", "when", "in", "car"),
            correctSentence = "Always wear seatbelt when travelling in car.",
            sinhalaMeaning = "මෝටර් රථයක ගමන් කරන විට සැමවිටම ආසන පටිය පළඳින්න.",
            hint = "Adverb + Imperative + object + time clause."
          ),
          SentencePuzzleItem(
            id = "c27_p5",
            scrambledWords = listOf("Speeding", "causes", "fatal", "accidents", "on", "highways"),
            correctSentence = "Speeding causes fatal accidents on highways.",
            sinhalaMeaning = "අධික වේගය මහාමාර්ගවල මාරාන්තික අනතුරු ඇති කරයි.",
            hint = "Gerund subject + causes + adjective + noun + location."
          ),
          SentencePuzzleItem(
            id = "c27_p6",
            scrambledWords = listOf("Look", "both", "ways", "before", "stepping", "onto", "street"),
            correctSentence = "Look both ways before stepping onto street.",
            sinhalaMeaning = "පාරට බසින්නට පෙර දෙපැත්තම හොඳින් බලන්න.",
            hint = "Imperative + object phrase + prepositional participle phrase."
          ),
          SentencePuzzleItem(
            id = "c27_p7",
            scrambledWords = listOf("Keep", "safe", "distance", "from", "vehicle", "in", "front"),
            correctSentence = "Keep safe distance from vehicle in front.",
            sinhalaMeaning = "ඉදිරියෙන් ඇති වාහනයෙන් ආරක්ෂිත දුරක් තබා ගන්න.",
            hint = "Imperative + object + from phrase."
          ),
          SentencePuzzleItem(
            id = "c27_p8",
            scrambledWords = listOf("Drunk", "driving", "strictly", "is", "prohibited", "law", "by"),
            correctSentence = "Drunk driving is strictly prohibited by law.",
            sinhalaMeaning = "බීමත්ව රිය පැදවීම නීතියෙන් දැඩි ලෙස තහනම් කර ඇත.",
            hint = "Subject + is strictly prohibited + by law."
          ),
          SentencePuzzleItem(
            id = "c27_p9",
            scrambledWords = listOf("Pavements", "are", "meant", "for", "safe", "walking"),
            correctSentence = "Pavements are meant for safe walking.",
            sinhalaMeaning = "පදික වේදිකා වෙන් කර ඇත්තේ ආරක්ෂිතව ඇවිදීම සඳහාය.",
            hint = "Subject + are meant for + gerund phrase."
          ),
          SentencePuzzleItem(
            id = "c27_p10",
            scrambledWords = listOf("Obey", "police", "officer", "traffic", "instructions", "diligently"),
            correctSentence = "Obey traffic police officer instructions diligently.",
            sinhalaMeaning = "රථවාහන පොලිස් නිලධාරියාගේ උපදෙස් නිසි ලෙස පිළිපදින්න.",
            hint = "Imperative + noun phrase + adverb."
          ),
          SentencePuzzleItem(
            id = "c27_p11",
            scrambledWords = listOf("Yellow", "light", "indicates", "prepare", "to", "stop"),
            correctSentence = "Yellow light indicates prepare to stop.",
            sinhalaMeaning = "කහ එළියෙන් නැවතීමට සූදානම් වන ලෙස දක්වයි.",
            hint = "Subject + indicates + infinitive phrase."
          ),
          SentencePuzzleItem(
            id = "c27_p12",
            scrambledWords = listOf("Do", "not", "overtake", "blind", "corners", "at"),
            correctSentence = "Do not overtake at blind corners.",
            sinhalaMeaning = "නොපෙනෙන වංගුවලදී ඉස්සර නොකරන්න.",
            hint = "Negative imperative + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c27_p13",
            scrambledWords = listOf("Motorcyclists", "must", "strap", "helmets", "firmly"),
            correctSentence = "Motorcyclists must strap helmets firmly.",
            sinhalaMeaning = "යතුරුපැදිකරුවන් හිස්වැසුම් තදින් සවි කරගත යුතුය.",
            hint = "Subject + must + base verb + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c27_p14",
            scrambledWords = listOf("Check", "mirrors", "before", "turning", "corners"),
            correctSentence = "Check mirrors before turning corners.",
            sinhalaMeaning = "වංගු ගැනීමට පෙර කණ්ණාඩි පරීක්ෂා කරන්න.",
            hint = "Imperative + object + time phrase."
          ),
          SentencePuzzleItem(
            id = "c27_p15",
            scrambledWords = listOf("Yield", "to", "ambulances", "with", "flashing", "sirens"),
            correctSentence = "Yield to ambulances with flashing sirens.",
            sinhalaMeaning = "සයිරන් නාද කරන ගිලන් රථවලට මාර්ගය ලබා දෙන්න.",
            hint = "Imperative (Yield to) + noun + with phrase."
          ),
          SentencePuzzleItem(
            id = "c27_p16",
            scrambledWords = listOf("Children", "must", "hold", "hands", "while", "crossing"),
            correctSentence = "Children must hold hands while crossing.",
            sinhalaMeaning = "පාර මාරු වන විට ළමයින් අත් අල්ලාගත යුතුය.",
            hint = "Subject + must hold + object + time clause."
          ),
          SentencePuzzleItem(
            id = "c27_p17",
            scrambledWords = listOf("Drive", "slowly", "near", "schools", "and", "hospitals"),
            correctSentence = "Drive slowly near schools and hospitals.",
            sinhalaMeaning = "පාසල් සහ රෝහල් අසලදී සෙමින් රිය පදවන්න.",
            hint = "Imperative + adverb + location."
          ),
          SentencePuzzleItem(
            id = "c27_p18",
            scrambledWords = listOf("Defective", "brakes", "lead", "tragic", "to", "collisions"),
            correctSentence = "Defective brakes lead to tragic collisions.",
            sinhalaMeaning = "දෝෂ සහිත තිරිංග (Brakes) ඛේදනීය ගැටීම්වලට මඟ පාදයි.",
            hint = "Subject phrase + lead to + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c27_p19",
            scrambledWords = listOf("Courtesy", "on", "road", "prevents", "road", "rage"),
            correctSentence = "Courtesy on road prevents road rage.",
            sinhalaMeaning = "මාර්ගයේදී අනුගමනය කරන විනීතභාවය අනවශ්‍ය කලහකාරී තත්ත්වයන් වළක්වයි.",
            hint = "Subject phrase + prevents + object."
          ),
          SentencePuzzleItem(
            id = "c27_p20",
            scrambledWords = listOf("Safety", "first", "is", "golden", "rule", "everywhere"),
            correctSentence = "Safety first is golden rule everywhere.",
            sinhalaMeaning = "ආරක්ෂාව මුලින්ම සැලකීම සෑම තැනකදීම රන් රීතියකි.",
            hint = "Motto + is + noun phrase + adverb."
          )
        )
      ),

      // ==========================================
      // Category 28: Computer Science, Coding & AI (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 28,
        titleSinhala = "කාණ්ඩය 28: පරිගණක, කේතකරණය සහ කෘත්‍රිම බුද්ධිය",
        titleEnglish = "Computer Science, Coding & AI",
        icon = "💻",
        description = "පරිගණක වැඩසටහන්කරණය, අන්තර්ජාල ආරක්ෂාව සහ තාක්ෂණික කුසලතා පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c28_p1",
            scrambledWords = listOf("Coding", "develops", "problem-solving", "skills", "logical", "and", "thinking"),
            correctSentence = "Coding develops problem-solving skills and logical thinking.",
            sinhalaMeaning = "කේතකරණය (Coding) ගැටලු විසඳීමේ කුසලතා සහ තාර්කික චින්තනය වර්ධනය කරයි.",
            hint = "Gerund subject + develops + compound noun phrases."
          ),
          SentencePuzzleItem(
            id = "c28_p2",
            scrambledWords = listOf("Python", "is", "a", "popular", "programming", "language", "beginners", "for"),
            correctSentence = "Python is a popular programming language for beginners.",
            sinhalaMeaning = "පයිතන් (Python) යනු ආධුනිකයන් සඳහා ඉතා ජනප්‍රිය ක්‍රමලේඛන භාෂාවකි.",
            hint = "Proper noun + is + article + adjective phrase + for phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p3",
            scrambledWords = listOf("Cybersecurity", "protects", "systems", "from", "malicious", "attacks"),
            correctSentence = "Cybersecurity protects systems from malicious attacks.",
            sinhalaMeaning = "සයිබර් ආරක්ෂාව අනිෂ්ට ප්‍රහාරවලින් පද්ධති ආරක්ෂා කරයි.",
            hint = "Subject + protects + object + from phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p4",
            scrambledWords = listOf("Never", "share", "passwords", "with", "untrusted", "websites"),
            correctSentence = "Never share passwords with untrusted websites.",
            sinhalaMeaning = "විශ්වාස කළ නොහැකි වෙබ් අඩවි සමඟ කිසිවිටෙකත් මුරපද බෙදා නොගන්න.",
            hint = "Adverb + Imperative + object + with phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p5",
            scrambledWords = listOf("Algorithms", "are", "step-by-step", "instructions", "tasks", "solve", "to"),
            correctSentence = "Algorithms are step-by-step instructions to solve tasks.",
            sinhalaMeaning = "ඇල්ගොරිතම යනු කාර්යයන් විසඳීම සඳහා වන පියවරෙන් පියවර උපදෙස් මාලාවකි.",
            hint = "Subject + are + noun phrase + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c28_p6",
            scrambledWords = listOf("Machine", "learning", "enables", "computers", "learn", "data", "from", "to"),
            correctSentence = "Machine learning enables computers to learn from data.",
            sinhalaMeaning = "මැෂින් ලර්නින් පරිගණකවලට දත්තවලින් ඉගෙන ගැනීමට හැකියාව ලබා දෙයි.",
            hint = "Subject phrase + enables + object + to-infinitive."
          ),
          SentencePuzzleItem(
            id = "c28_p7",
            scrambledWords = listOf("Back", "up", "important", "files", "cloud", "storage", "to"),
            correctSentence = "Back up important files to cloud storage.",
            sinhalaMeaning = "වැදගත් ලිපිගොනු Cloud ගබඩාව වෙත උපස්ථ (Back up) කර තබා ගන්න.",
            hint = "Phrasal verb + object + to phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p8",
            scrambledWords = listOf("Software", "updates", "fix", "security", "bugs", "vulnerabilities", "and"),
            correctSentence = "Software updates fix security bugs and vulnerabilities.",
            sinhalaMeaning = "මෘදුකාංග යාවත්කාලීන කිරීම් මඟින් ආරක්ෂක දෝෂ සහ දුර්වලතා නිරාකරණය කරයි.",
            hint = "Subject phrase + fix + compound objects."
          ),
          SentencePuzzleItem(
            id = "c28_p9",
            scrambledWords = listOf("Debugging", "identifies", "and", "removes", "code", "errors"),
            correctSentence = "Debugging identifies and removes code errors.",
            sinhalaMeaning = "දෝෂ නිරාකරණය (Debugging) මඟින් කේතයේ ඇති වැරදි හඳුනාගෙන ඉවත් කරයි.",
            hint = "Gerund subject + compound verbs + object."
          ),
          SentencePuzzleItem(
            id = "c28_p10",
            scrambledWords = listOf("Cloud", "computing", "stores", "data", "remote", "servers", "on"),
            correctSentence = "Cloud computing stores data on remote servers.",
            sinhalaMeaning = "Cloud computing මඟින් දුරස්ථ සේවාදායකයන්හි දත්ත ගබඩා කරයි.",
            hint = "Subject + stores + object + location."
          ),
          SentencePuzzleItem(
            id = "c28_p11",
            scrambledWords = listOf("Phishing", "emails", "trick", "users", "into", "revealing", "secrets"),
            correctSentence = "Phishing emails trick users into revealing secrets.",
            sinhalaMeaning = "තතුබෑම් (Phishing) ඊමේල් මඟින් රහස්‍ය තොරතුරු හෙළිකර ගැනීමට පරිශීලකයින් නොමඟ යවයි.",
            hint = "Subject + trick + object + into gerund phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p12",
            scrambledWords = listOf("Keyboard", "shortcuts", "speed", "up", "daily", "work"),
            correctSentence = "Keyboard shortcuts speed up daily work.",
            sinhalaMeaning = "යතුරුපුවරු කෙටිමං දෛනික වැඩ වේගවත් කරයි.",
            hint = "Subject phrase + phrasal verb (speed up) + object."
          ),
          SentencePuzzleItem(
            id = "c28_p13",
            scrambledWords = listOf("Databases", "organize", "large", "volumes", "structured", "information", "of"),
            correctSentence = "Databases organize large volumes of structured information.",
            sinhalaMeaning = "දත්ත සමුදායන් විශාල ව්‍යුහගත තොරතුරු ප්‍රමාණයක් සංවිධානය කරයි.",
            hint = "Subject + organize + quantifier + of phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p14",
            scrambledWords = listOf("Install", "reliable", "antivirus", "protect", "PC", "to"),
            correctSentence = "Install reliable antivirus to protect PC.",
            sinhalaMeaning = "පරිගණකය ආරක්ෂා කර ගැනීමට විශ්වාසදායක ප්‍රතිවෛරස් මෘදුකාංගයක් ස්ථාපනය කරන්න.",
            hint = "Imperative + object + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c28_p15",
            scrambledWords = listOf("Hardware", "comprises", "physical", "parts", "computer", "system", "of"),
            correctSentence = "Hardware comprises physical parts of computer system.",
            sinhalaMeaning = "දෘඩාංග යනු පරිගණක පද්ධතියක භෞතික කොටස් වේ.",
            hint = "Subject + comprises + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p16",
            scrambledWords = listOf("Artificial", "neural", "networks", "mimic", "human", "brain", "functions"),
            correctSentence = "Artificial neural networks mimic human brain functions.",
            sinhalaMeaning = "කෘත්‍රිම ස්නායුක ජාල මිනිස් මොළයේ ක්‍රියාකාරිත්වය අනුකරණය කරයි.",
            hint = "Subject phrase + mimic + object phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p17",
            scrambledWords = listOf("Open", "source", "software", "encourages", "global", "collaboration"),
            correctSentence = "Open source software encourages global collaboration.",
            sinhalaMeaning = "විවෘත කේත මෘදුකාංග (Open source) ගෝලීය සහයෝගීතාව දිරිමත් කරයි.",
            hint = "Subject phrase + encourages + object phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p18",
            scrambledWords = listOf("Learn", "digital", "skills", "thrive", "in", "future", "to"),
            correctSentence = "Learn digital skills to thrive in future.",
            sinhalaMeaning = "අනාගතයේදී සාර්ථක වීම සඳහා ඩිජිටල් කුසලතා ඉගෙන ගන්න.",
            hint = "Imperative + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c28_p19",
            scrambledWords = listOf("Smartphones", "run", "on", "advanced", "operating", "systems"),
            correctSentence = "Smartphones run on advanced operating systems.",
            sinhalaMeaning = "ස්මාර්ට්ෆෝන් උසස් මෙහෙයුම් පද්ධති මත ක්‍රියාත්මක වේ.",
            hint = "Subject + run on + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c28_p20",
            scrambledWords = listOf("Technology", "serves", "humanity", "when", "guided", "wisdom", "by"),
            correctSentence = "Technology serves humanity when guided by wisdom.",
            sinhalaMeaning = "ප්‍රඥාවෙන් මෙහෙයවනු ලබන විට තාක්ෂණය මානව වර්ගයාට සේවය කරයි.",
            hint = "Main clause + conditional reduced clause."
          )
        )
      ),

      // ==========================================
      // Category 29: Emergency First Aid & Disaster Safety (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 29,
        titleSinhala = "කාණ්ඩය 29: හදිසි ආපදා, ප්‍රථමාධාර සහ ආරක්ෂාව",
        titleEnglish = "Emergency Response & First Aid Safety",
        icon = "🩹",
        description = "හදිසි අනතුරු, ප්‍රථමාධාර ලබාදීම, ගංවතුර සහ ආපදා කළමනාකරණය පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c29_p1",
            scrambledWords = listOf("First", "aid", "saves", "lives", "before", "doctors", "arrive"),
            correctSentence = "First aid saves lives before doctors arrive.",
            sinhalaMeaning = "වෛද්‍යවරුන් පැමිණීමට පෙර ප්‍රථමාධාර මගින් ජීවිත බේරා ගත හැකිය.",
            hint = "Subject phrase + saves lives + time clause."
          ),
          SentencePuzzleItem(
            id = "c29_p2",
            scrambledWords = listOf("Apply", "direct", "pressure", "stop", "severe", "bleeding", "to"),
            correctSentence = "Apply direct pressure to stop severe bleeding.",
            sinhalaMeaning = "දරුණු රුධිර වහනය නැවැත්වීම සඳහා ඍජුවම පීඩනය යොදන්න.",
            hint = "Imperative + object + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c29_p3",
            scrambledWords = listOf("Call", "1990", "free", "ambulance", "service", "for"),
            correctSentence = "Call 1990 for free ambulance service.",
            sinhalaMeaning = "නොමිලේ ගිලන්රථ සේවය සඳහා 1990 අමතන්න.",
            hint = "Imperative + number + for phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p4",
            scrambledWords = listOf("Cool", "burns", "with", "clean", "running", "water", "immediately"),
            correctSentence = "Cool burns with clean running water immediately.",
            sinhalaMeaning = "පිළිස්සුම් තුවාල ක්ෂණිකව පිරිසිදු ගලා යන ජලයෙන් සිසිල් කරන්න.",
            hint = "Imperative + object + with phrase + adverb."
          ),
          SentencePuzzleItem(
            id = "c29_p5",
            scrambledWords = listOf("Stay", "calm", "during", "unexpected", "natural", "disasters"),
            correctSentence = "Stay calm during unexpected natural disasters.",
            sinhalaMeaning = "නොසිතූ ස්වභාවික ආපදාවලදී සන්සුන්ව සිටින්න.",
            hint = "Imperative + adjective + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p6",
            scrambledWords = listOf("Move", "to", "higher", "ground", "during", "flash", "floods"),
            correctSentence = "Move to higher ground during flash floods.",
            sinhalaMeaning = "හදිසි ගංවතුර තත්ත්වයකදී උස් ස්ථානයකට යන්න.",
            hint = "Imperative + direction + time phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p7",
            scrambledWords = listOf("Keep", "first", "aid", "box", "handy", "home", "at"),
            correctSentence = "Keep first aid box handy at home.",
            sinhalaMeaning = "නිවසේදී ප්‍රථමාධාර පෙට්ටියක් ළඟ තබා ගන්න.",
            hint = "Imperative + object + adjective + location."
          ),
          SentencePuzzleItem(
            id = "c29_p8",
            scrambledWords = listOf("Do", "not", "touch", "fallen", "electric", "wires"),
            correctSentence = "Do not touch fallen electric wires.",
            sinhalaMeaning = "කඩා වැටුණු විදුලි රැහැන් ස්පර්ශ නොකරන්න.",
            hint = "Negative imperative + adjective + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p9",
            scrambledWords = listOf("CPR", "revives", "patients", "suffering", "heart", "failure", "from"),
            correctSentence = "CPR revives patients suffering from heart failure.",
            sinhalaMeaning = "CPR ක්‍රමය හෘදයාබාධයකින් පෙළෙන රෝගීන් නැවත පණ ගන්වයි.",
            hint = "Subject + revives + object + participle phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p10",
            scrambledWords = listOf("Disinfect", "open", "wounds", "prevent", "infections", "to"),
            correctSentence = "Disinfect open wounds to prevent infections.",
            sinhalaMeaning = "ආසාදන වැළැක්වීම සඳහා විවෘත තුවාල විෂබීජහරණය කරන්න.",
            hint = "Imperative + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c29_p11",
            scrambledWords = listOf("Evacuate", "promptly", "when", "tsunami", "warnings", "sound"),
            correctSentence = "Evacuate promptly when tsunami warnings sound.",
            sinhalaMeaning = "සුනාමි අනතුරු ඇඟවීම් නාද වන විට කඩිනමින් ඉවත් වන්න.",
            hint = "Imperative + adverb + time clause."
          ),
          SentencePuzzleItem(
            id = "c29_p12",
            scrambledWords = listOf("Check", "pulse", "and", "breathing", "unconscious", "victims", "of"),
            correctSentence = "Check pulse and breathing of unconscious victims.",
            sinhalaMeaning = "සිහිසුන් වූවන්ගේ නාඩි සහ ශ්වසනය පරීක්ෂා කරන්න.",
            hint = "Imperative + compound objects + of phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p13",
            scrambledWords = listOf("Store", "emergency", "rations", "and", "clean", "water"),
            correctSentence = "Store emergency rations and clean water.",
            sinhalaMeaning = "හදිසි ආහාර ද්‍රව්‍ය සහ පිරිසිදු ජලය ගබඩා කර තබා ගන්න.",
            hint = "Imperative + compound object."
          ),
          SentencePuzzleItem(
            id = "c29_p14",
            scrambledWords = listOf("Drop", "cover", "hold", "during", "earthquake", "and"),
            correctSentence = "Drop cover and hold during earthquake.",
            sinhalaMeaning = "භූමිකම්පාවකදී බිම වැතිරී, ආවරණය වී අල්ලා ගන්න (Drop, Cover and Hold).",
            hint = "Emergency action drill: Drop, cover and hold..."
          ),
          SentencePuzzleItem(
            id = "c29_p15",
            scrambledWords = listOf("Do", "not", "crowd", "around", "injured", "persons"),
            correctSentence = "Do not crowd around injured persons.",
            sinhalaMeaning = "තුවාල ලැබූවන් වටා පිරිස් එකතු නොවන්න.",
            hint = "Negative imperative + around phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p16",
            scrambledWords = listOf("Know", "emergency", "exit", "routes", "public", "buildings", "in"),
            correctSentence = "Know emergency exit routes in public buildings.",
            sinhalaMeaning = "පොදු ගොඩනැගිලිවල හදිසි පිටවීමේ මාර්ග දැනුවත්ව සිටින්න.",
            hint = "Imperative + object phrase + location."
          ),
          SentencePuzzleItem(
            id = "c29_p17",
            scrambledWords = listOf("Bandage", "fractured", "limbs", "movement", "prevent", "to"),
            correctSentence = "Bandage fractured limbs to prevent movement.",
            sinhalaMeaning = "සෙලවීම වැළැක්වීම සඳහා කැඩුණු අස්ථි වෙළුම් පටිවලින් බඳින්න.",
            hint = "Imperative + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c29_p18",
            scrambledWords = listOf("Listen", "to", "official", "weather", "radio", "bulletins"),
            correctSentence = "Listen to official weather radio bulletins.",
            sinhalaMeaning = "නිල කාලගුණ ගුවන්විදුලි නිවේදනවලට සවන් දෙන්න.",
            hint = "Imperative + to phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p19",
            scrambledWords = listOf("Volunteers", "help", "distribute", "relief", "supplies", "flood", "victims", "to"),
            correctSentence = "Volunteers help distribute relief supplies to flood victims.",
            sinhalaMeaning = "ස්වේච්ඡා සේවකයෝ ගංවතුරෙන් විපතට පත්වූවන්ට සහනාධාර බෙදාදීමට උදවු කරති.",
            hint = "Subject + help distribute + object + to phrase."
          ),
          SentencePuzzleItem(
            id = "c29_p20",
            scrambledWords = listOf("Preparedness", "mitigates", "impact", "unforeseen", "calamities", "of"),
            correctSentence = "Preparedness mitigates impact of unforeseen calamities.",
            sinhalaMeaning = "පූර්ව සූදානම අනපේක්ෂිත ආපදාවල බලපෑම අවම කරයි.",
            hint = "Subject + mitigates + object phrase."
          )
        )
      ),

      // ==========================================
      // Category 30: Career Goals, Ambitions & Life Skills (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 30,
        titleSinhala = "කාණ්ඩය 30: අනාගත අරමුණු, වෘත්තීන් සහ ජීවන කුසලතා",
        titleEnglish = "Career Goals, Ambitions & Life Skills",
        icon = "🎯",
        description = "අනාගත අපේක්ෂා, වෘත්තීය සාර්ථකත්වය, නොපසුබට උත්සාහය සහ ජීවිතය ජයගැනීමේ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c30_p1",
            scrambledWords = listOf("Set", "clear", "goals", "successful", "career", "a", "for"),
            correctSentence = "Set clear goals for a successful career.",
            sinhalaMeaning = "සාර්ථක වෘත්තීය ජීවිතයක් සඳහා පැහැදිලි ඉලක්ක තබා ගන්න.",
            hint = "Imperative + adjective + noun + purpose."
          ),
          SentencePuzzleItem(
            id = "c30_p2",
            scrambledWords = listOf("Hard", "work", "and", "dedication", "lead", "great", "success", "to"),
            correctSentence = "Hard work and dedication lead to great success.",
            sinhalaMeaning = "වෙහෙස මහන්සි වී වැඩ කිරීම සහ කැපවීම විශිෂ්ට සාර්ථකත්වයකට මඟ පාදයි.",
            hint = "Compound subject + lead to + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p3",
            scrambledWords = listOf("dream", "My", "is", "serve", "country", "as", "engineer", "my", "to", "an"),
            correctSentence = "My dream is to serve my country as an engineer.",
            sinhalaMeaning = "මගේ සිහිනය වන්නේ ඉංජිනේරුවෙකු ලෙස මගේ රටට සේවය කිරීමයි.",
            hint = "Subject + is + to-infinitive + object + as phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p4",
            scrambledWords = listOf("Continuous", "learning", "sharpens", "professional", "skills", "our"),
            correctSentence = "Continuous learning sharpens our professional skills.",
            sinhalaMeaning = "අඛණ්ඩ ඉගෙනීම අපගේ වෘත්තීය කුසලතා තියුණු කරයි.",
            hint = "Subject phrase + sharpens + possessive object phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p5",
            scrambledWords = listOf("Effective", "communication", "opens", "doors", "many", "opportunities", "to"),
            correctSentence = "Effective communication opens doors to many opportunities.",
            sinhalaMeaning = "ඵලදායී සන්නිවේදනය බොහෝ අවස්ථාවන් සඳහා දොරටු විවර කරයි.",
            hint = "Subject phrase + opens doors to + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p6",
            scrambledWords = listOf("Never", "give", "up", "when", "facing", "tough", "challenges"),
            correctSentence = "Never give up when facing tough challenges.",
            sinhalaMeaning = "දුෂ්කර අභියෝග හමුවේ කිසිවිටෙකත් උත්සාහය අත්නොහරින්න.",
            hint = "Adverb + Imperative + when participle clause."
          ),
          SentencePuzzleItem(
            id = "c30_p7",
            scrambledWords = listOf("Time", "management", "is", "crucial", "daily", "productivity", "for"),
            correctSentence = "Time management is crucial for daily productivity.",
            sinhalaMeaning = "කාල කළමනාකරණය දෛනික ඵලදායිතාව සඳහා තීරණාත්මක වේ.",
            hint = "Subject phrase + is crucial for + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p8",
            scrambledWords = listOf("Critical", "thinking", "helps", "make", "wise", "decisions"),
            correctSentence = "Critical thinking helps make wise decisions.",
            sinhalaMeaning = "විවේචනාත්මක චින්තනය ඥානවන්ත තීරණ ගැනීමට උපකාරී වේ.",
            hint = "Subject phrase + helps make + object phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p9",
            scrambledWords = listOf("Believe", "in", "abilities", "your", "even", "others", "doubt", "when"),
            correctSentence = "Believe in your abilities even when others doubt.",
            sinhalaMeaning = "අන් අය සැක කරන විට පවා ඔබේ හැකියාවන් කෙරෙහි විශ්වාසය තබන්න.",
            hint = "Imperative (Believe in) + noun + even when clause."
          ),
          SentencePuzzleItem(
            id = "c30_p10",
            scrambledWords = listOf("Leadership", "inspires", "others", "dream", "to", "more"),
            correctSentence = "Leadership inspires others to dream more.",
            sinhalaMeaning = "නායකත්වය වැඩි වැඩියෙන් සිහින දැකීමට අන්‍යයන් පෙළඹවෙයි.",
            hint = "Subject + inspires + object + to-infinitive."
          ),
          SentencePuzzleItem(
            id = "c30_p11",
            scrambledWords = listOf("Doctors", "heal", "patients", "compassion", "and", "care", "with"),
            correctSentence = "Doctors heal patients with compassion and care.",
            sinhalaMeaning = "වෛද්‍යවරු කරුණාව සහ සැලකිල්ලෙන් රෝගීන් සුවපත් කරති.",
            hint = "Subject + heal + object + with phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p12",
            scrambledWords = listOf("Teachers", "shape", "destiny", "future", "generations", "of"),
            correctSentence = "Teachers shape destiny of future generations.",
            sinhalaMeaning = "ගුරුවරුන් අනාගත පරපුරේ ඉරණම හැඩගස්වයි.",
            hint = "Subject + shape + object phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p13",
            scrambledWords = listOf("Build", "confidence", "public", "speaking", "by", "practicing"),
            correctSentence = "Build confidence by practicing public speaking.",
            sinhalaMeaning = "ප්‍රසිද්ධ කථිකත්වය පුහුණු වීමෙන් ආත්ම විශ්වාසය ගොඩනඟා ගන්න.",
            hint = "Imperative + object + by gerund phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p14",
            scrambledWords = listOf("Teamwork", "divides", "task", "multiplies", "success", "and"),
            correctSentence = "Teamwork divides task and multiplies success.",
            sinhalaMeaning = "කණ්ඩායම් හැඟීම කාර්යය බෙදාහදා ගන්නා අතර සාර්ථකත්වය වැඩි කරයි.",
            hint = "Subject + Compound predicate."
          ),
          SentencePuzzleItem(
            id = "c30_p15",
            scrambledWords = listOf("Passion", "fuels", "journey", "excellence", "towards"),
            correctSentence = "Passion fuels journey towards excellence.",
            sinhalaMeaning = "ඇල්ම (Passion) විශිෂ්ටත්වය කරා යන ගමනට පණ පොවයි.",
            hint = "Subject + fuels + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p16",
            scrambledWords = listOf("Adaptability", "helps", "survive", "changing", "workplace", "in"),
            correctSentence = "Adaptability helps survive in changing workplace.",
            sinhalaMeaning = "නම්‍යශීලී බව වෙනස් වන සේවා පරිසරය තුළ නොනැසී පැවතීමට උපකාරී වේ.",
            hint = "Subject + helps survive + location."
          ),
          SentencePuzzleItem(
            id = "c30_p17",
            scrambledWords = listOf("Learn", "from", "past", "mistakes", "improve", "to"),
            correctSentence = "Learn from past mistakes to improve.",
            sinhalaMeaning = "දියුණු වීම සඳහා අතීත වැරදිවලින් පාඩම් ඉගෙන ගන්න.",
            hint = "Imperative + from phrase + infinitive of purpose."
          ),
          SentencePuzzleItem(
            id = "c30_p18",
            scrambledWords = listOf("Entrepreneurs", "create", "innovative", "solutions", "societal", "problems", "for"),
            correctSentence = "Entrepreneurs create innovative solutions for societal problems.",
            sinhalaMeaning = "ව්‍යවසායකයෝ සමාජ ගැටලු සඳහා නව්‍ය විසඳුම් නිර්මාණය කරති.",
            hint = "Subject + create + object phrase + for phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p19",
            scrambledWords = listOf("Stay", "humble", "curious", "and", "throughout", "life"),
            correctSentence = "Stay humble and curious throughout life.",
            sinhalaMeaning = "ජීවිත කාලය පුරාම නිහතමානීව සහ විමසිලිමත්ව සිටින්න.",
            hint = "Imperative + compound adjectives + time phrase."
          ),
          SentencePuzzleItem(
            id = "c30_p20",
            scrambledWords = listOf("Future", "belongs", "those", "to", "who", "prepare", "today"),
            correctSentence = "Future belongs to those who prepare today.",
            sinhalaMeaning = "අනාගතය හිමිවන්නේ අද දවසේ සූදානම් වන්නන්ටය.",
            hint = "Famous quote: Future belongs to those who prepare today."
          )
        )
      )
    )
  }
}
