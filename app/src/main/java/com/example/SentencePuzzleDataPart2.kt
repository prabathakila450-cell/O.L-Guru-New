package com.example

object SentencePuzzleDataPart2 {
  fun getCategoriesPart2(): List<SentencePuzzleCategory> {
    return listOf(
      // ==========================================
      // Category 11: Sports, Games & Team Spirit (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 11,
        titleSinhala = "කාණ්ඩය 11: ක්‍රීඩා සහ කණ්ඩායම් හැඟීම",
        titleEnglish = "Sports, Games & Team Spirit",
        icon = "⚽",
        description = "ක්‍රීඩාශීලී බව, විනය, ජය පරාජය සහ කණ්ඩායම් හැඟීම විදහා දක්වන වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c11_p1",
            scrambledWords = listOf("teaches", "Sports", "discipline", "teamwork", "and", "students"),
            correctSentence = "Sports teaches discipline and teamwork students.",
            sinhalaMeaning = "ක්‍රීඩාව සිසුන්ට විනය සහ කණ්ඩායම් හැඟීම උගන්වයි.",
            hint = "Subject + verb + compound objects + recipient."
          ),
          SentencePuzzleItem(
            id = "c11_p2",
            scrambledWords = listOf("captain", "The", "encouraged", "his", "play", "to", "hard", "team"),
            correctSentence = "The captain encouraged his team to play hard.",
            sinhalaMeaning = "නායකයා තම කණ්ඩායම දැඩි උත්සාහයකින් ක්‍රීඩා කිරීමට දිරිමත් කළේය.",
            hint = "Subject + encouraged + object + infinitive phrase."
          ),
          SentencePuzzleItem(
            id = "c11_p3",
            scrambledWords = listOf("Sri", "won", "Lanka", "Cricket", "World", "Cup", "1996", "in"),
            correctSentence = "Sri Lanka won Cricket World Cup in 1996.",
            sinhalaMeaning = "ශ්‍රී ලංකාව 1996 දී ලෝක කුසලාන ක්‍රිකට් තරගාවලිය ජයග්‍රහණය කළේය.",
            hint = "Subject + past verb (won) + object + year."
          ),
          SentencePuzzleItem(
            id = "c11_p4",
            scrambledWords = listOf("referee", "The", "blew", "whistle", "the", "end", "match", "the", "to"),
            correctSentence = "The referee blew the whistle to end the match.",
            sinhalaMeaning = "තරගය අවසන් කිරීමට විනිසුරුවරයා විසිල් හඬ නිකුත් කළේය.",
            hint = "Subject + blew the whistle + purpose."
          ),
          SentencePuzzleItem(
            id = "c11_p5",
            scrambledWords = listOf("Swimming", "is", "an", "full", "body", "excellent", "workout"),
            correctSentence = "Swimming is an excellent full body workout.",
            sinhalaMeaning = "පිහිනීම විශිෂ්ට මුළු සිරුරේම ව්‍යායාමයකි.",
            hint = "Gerund subject + is + article + adjective phrase + noun."
          ),
          SentencePuzzleItem(
            id = "c11_p6",
            scrambledWords = listOf("Practice", "makes", "player", "perfect", "any", "sports"),
            correctSentence = "Practice makes any sports player perfect.",
            sinhalaMeaning = "පුහුණුවීම ඕනෑම ක්‍රීඩකයෙකු පරිපූර්ණත්වයට පත් කරයි.",
            hint = "Proverb: Practice makes ... perfect."
          ),
          SentencePuzzleItem(
            id = "c11_p7",
            scrambledWords = listOf("cheered", "spectators", "The", "loudly", "winning", "for", "team"),
            correctSentence = "The spectators cheered loudly for winning team.",
            sinhalaMeaning = "ප්‍රේක්ෂකයෝ ජයග්‍රාහී කණ්ඩායම වෙනුවෙන් හයියෙන් ඔල්වරසන් දුන්හ.",
            hint = "Subject + verb + adverb + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c11_p8",
            scrambledWords = listOf("volleyball", "national", "Is", "Sri", "game", "Lanka", "of", "?"),
            correctSentence = "Is volleyball national game of Sri Lanka?",
            sinhalaMeaning = "වොලිබෝල් ශ්‍රී ලංකාවේ ජාතික ක්‍රීඩාවද?",
            hint = "Yes/No question: Is + noun + predicate phrase + ?"
          ),
          SentencePuzzleItem(
            id = "c11_p9",
            scrambledWords = listOf("must", "Athletes", "warm", "before", "up", "race", "every"),
            correctSentence = "Athletes must warm up before every race.",
            sinhalaMeaning = "මලල ක්‍රීඩකයින් සෑම ධාවන තරගයකටම පෙර උණුසුම් වීමේ අභ්‍යාස කළ යුතුය.",
            hint = "Subject + must + phrasal verb (warm up) + time."
          ),
          SentencePuzzleItem(
            id = "c11_p10",
            scrambledWords = listOf("accept", "defeat", "Learn", "gracefully", "to"),
            correctSentence = "Learn to accept defeat gracefully.",
            sinhalaMeaning = "පරාජය උපේක්ෂාවෙන් යුතුව පිළිගැනීමට ඉගෙන ගන්න.",
            hint = "Imperative: Learn to accept + noun + adverb."
          ),
          SentencePuzzleItem(
            id = "c11_p11",
            scrambledWords = listOf("scored", "striker", "The", "brilliant", "goal", "a"),
            correctSentence = "The striker scored a brilliant goal.",
            sinhalaMeaning = "ප්‍රහාරක ක්‍රීඩකයා විශිෂ්ට ගෝලයක් ලබා ගත්තේය.",
            hint = "Subject + scored + article + adj + noun."
          ),
          SentencePuzzleItem(
            id = "c11_p12",
            scrambledWords = listOf("Badminton", "requires", "quick", "reflexes", "sharp", "and", "eyes"),
            correctSentence = "Badminton requires quick reflexes and sharp eyes.",
            sinhalaMeaning = "බැඩ්මින්ටන් ක්‍රීඩාවට ඉක්මන් ප්‍රතිචාර සහ තියුණු ඇස් අවශ්‍ය වේ.",
            hint = "Subject + requires + compound noun phrases."
          ),
          SentencePuzzleItem(
            id = "c11_p13",
            scrambledWords = listOf("never", "True", "give", "champions", "up", "difficulty", "under"),
            correctSentence = "True champions never give up under difficulty.",
            sinhalaMeaning = "සැබෑ ශූරයන් දුෂ්කරතා හමුවේ කිසිදා අත් නොහරියි.",
            hint = "Subject + never + phrasal verb (give up) + context."
          ),
          SentencePuzzleItem(
            id = "c11_p14",
            scrambledWords = listOf("held", "Sports", "meet", "was", "ground", "school", "at", "the"),
            correctSentence = "Sports meet was held at the school ground.",
            sinhalaMeaning = "ක්‍රීඩා උළෙල පාසල් පිටියේදී පැවැත්විණි.",
            hint = "Passive: Subject + was held + location."
          ),
          SentencePuzzleItem(
            id = "c11_p15",
            scrambledWords = listOf("relay", "Our", "team", "gold", "the", "medal", "won"),
            correctSentence = "Our relay team won the gold medal.",
            sinhalaMeaning = "අපගේ සහය දිවීමේ කණ්ඩායම රන් පදක්කම දිනාගත්තේය.",
            hint = "Subject + won + the gold medal."
          ),
          SentencePuzzleItem(
            id = "c11_p16",
            scrambledWords = listOf("rules", "game", "Follow", "fair", "play", "for"),
            correctSentence = "Follow game rules for fair play.",
            sinhalaMeaning = "සාධාරණ ක්‍රීඩාවක් සඳහා ක්‍රීඩා නීති පිළිපදින්න.",
            hint = "Imperative + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c11_p17",
            scrambledWords = listOf("Cricket", "brings", "people", "together", "joy", "with"),
            correctSentence = "Cricket brings people together with joy.",
            sinhalaMeaning = "ක්‍රිකට් ක්‍රීඩාව ප්‍රීතියෙන් යුතුව මිනිසුන් එකට එකතු කරයි.",
            hint = "Subject + brings + object + together + adverbial."
          ),
          SentencePuzzleItem(
            id = "c11_p18",
            scrambledWords = listOf("coach", "The", "trained", "players", "tirelessly", "everyday"),
            correctSentence = "The coach trained players tirelessly everyday.",
            sinhalaMeaning = "පුහුණුකරු දිනපතාම නොනවත්වා ක්‍රීඩකයන් පුහුණු කළේය.",
            hint = "Subject + trained + object + adverbs."
          ),
          SentencePuzzleItem(
            id = "c11_p19",
            scrambledWords = listOf("chess", "Playing", "sharpens", "strategic", "our", "thinking"),
            correctSentence = "Playing chess sharpens our strategic thinking.",
            sinhalaMeaning = "චෙස් ක්‍රීඩා කිරීම අපගේ උපායමාර්ගික චින්තනය තියුණු කරයි.",
            hint = "Gerund subject + sharpens + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c11_p20",
            scrambledWords = listOf("Victory", "belongs", "those", "to", "who", "persist"),
            correctSentence = "Victory belongs to those who persist.",
            sinhalaMeaning = "ජයග්‍රහණය හිමිවන්නේ නොසැලී උත්සාහ කරන්නන්ටය.",
            hint = "Subject + belongs to + relative clause."
          )
        )
      ),

      // ==========================================
      // Category 12: Travel, Transport & Tourism in Sri Lanka (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 12,
        titleSinhala = "කාණ්ඩය 12: සංචාරය, ප්‍රවාහනය සහ සංචාරක ව්‍යාපාරය",
        titleEnglish = "Travel, Transport & Tourism in Sri Lanka",
        icon = "🚂",
        description = "දුම්රිය ගමන්, සංචාරක ස්ථාන සහ ශ්‍රී ලංකාවේ සුන්දරත්වය විදහාපාන වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c12_p1",
            scrambledWords = listOf("train", "ride", "The", "to", "Ella", "scenic", "is", "breathtakingly"),
            correctSentence = "The train ride to Ella is breathtakingly scenic.",
            sinhalaMeaning = "ඇල්ල බලා යන දුම්රිය ගමන හුස්ම හිරවන තරම් මනරම්ය.",
            hint = "Subject phrase + is + adverb + adjective."
          ),
          SentencePuzzleItem(
            id = "c12_p2",
            scrambledWords = listOf("Tourists", "love", "golden", "beaches", "southern", "coast", "along", "the"),
            correctSentence = "Tourists love golden beaches along the southern coast.",
            sinhalaMeaning = "දකුණු වෙරළ තීරයේ පිහිටි රන්වන් වෙරළ තීරයන්ට සංචාරකයින් බෙහෙවින් ප්‍රිය කරති.",
            hint = "Subject + love + object phrase + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c12_p3",
            scrambledWords = listOf("Galle", "Fort", "is", "historic", "Dutch", "a", "monument"),
            correctSentence = "Galle Fort is a historic Dutch monument.",
            sinhalaMeaning = "ගාල්ල කොටුව ඓතිහාසික ලන්දේසි ස්මාරකයකි.",
            hint = "Subject + is + article + adjective + noun."
          ),
          SentencePuzzleItem(
            id = "c12_p4",
            scrambledWords = listOf("ticket", "Always", "buy", "a", "boarding", "before", "train"),
            correctSentence = "Always buy a ticket before boarding train.",
            sinhalaMeaning = "සැමවිටම දුම්රියට නැගීමට පෙර ප්‍රවේශපත්‍රයක් මිලදී ගන්න.",
            hint = "Adverb + Imperative + object + time phrase."
          ),
          SentencePuzzleItem(
            id = "c12_p5",
            scrambledWords = listOf("Yala", "National", "Park", "famous", "for", "is", "leopards"),
            correctSentence = "Yala National Park is famous for leopards.",
            sinhalaMeaning = "යාල ජාතික වනෝද්‍යානය කොටින් සඳහා ප්‍රසිද්ධය.",
            hint = "Proper noun + is famous for + noun."
          ),
          SentencePuzzleItem(
            id = "c12_p6",
            scrambledWords = listOf("expressway", "The", "reduces", "travel", "significantly", "time"),
            correctSentence = "The expressway reduces travel time significantly.",
            sinhalaMeaning = "අධිවේගී මාර්ගය ගමන් කාලය සැලකිය යුතු ලෙස අඩු කරයි.",
            hint = "Subject + reduces + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c12_p7",
            scrambledWords = listOf("carry", "valid", "passengers", "Must", "identity", "cards"),
            correctSentence = "Passengers must carry valid identity cards.",
            sinhalaMeaning = "මගීන් වලංගු හැඳුනුම්පත් ළඟ තබාගත යුතුය.",
            hint = "Subject + must carry + object phrase."
          ),
          SentencePuzzleItem(
            id = "c12_p8",
            scrambledWords = listOf("Pearl", "Sri", "Lanka", "is", "the", "Ocean", "Indian", "of"),
            correctSentence = "Sri Lanka is the Pearl of Indian Ocean.",
            sinhalaMeaning = "ශ්‍රී ලංකාව ඉන්දියන් සාගරයේ මුතු ඇටයයි.",
            hint = "Subject + is + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c12_p9",
            scrambledWords = listOf("tea", "gardens", "Lush", "cover", "hills", "central", "the"),
            correctSentence = "Lush tea gardens cover the central hills.",
            sinhalaMeaning = "මනරම් තේ වතු මධ්‍යම කඳුකරය වසා පැතිරී ඇත.",
            hint = "Subject phrase + cover + object."
          ),
          SentencePuzzleItem(
            id = "c12_p10",
            scrambledWords = listOf("Public", "transport", "saves", "fuel", "reduces", "and", "traffic"),
            correctSentence = "Public transport saves fuel and reduces traffic.",
            sinhalaMeaning = "පොදු ප්‍රවාහනය ඉන්ධන ඉතිරි කරන අතර මාර්ග තදබදය අඩු කරයි.",
            hint = "Subject + Compound predicate."
          ),
          SentencePuzzleItem(
            id = "c12_p11",
            scrambledWords = listOf("pack", "lightly", "Always", "long", "journeys", "for"),
            correctSentence = "Always pack lightly for long journeys.",
            sinhalaMeaning = "දිගු ගමන් සඳහා සැමවිටම සැහැල්ලුවෙන් බඩු අසුරන්න.",
            hint = "Imperative + adverb + for phrase."
          ),
          SentencePuzzleItem(
            id = "c12_p12",
            scrambledWords = listOf("waterfalls", "Many", "cascade", "down", "misty", "mountains"),
            correctSentence = "Many waterfalls cascade down misty mountains.",
            sinhalaMeaning = "මීදුම් සහිත කඳුවලින් දියඇලි රැසක් කඩා හැලෙයි.",
            hint = "Subject + cascade down + object."
          ),
          SentencePuzzleItem(
            id = "c12_p13",
            scrambledWords = listOf("Temple", "Tooth", "The", "of", "in", "is", "Kandy", "located"),
            correctSentence = "The Temple of Tooth is located in Kandy.",
            sinhalaMeaning = "ශ්‍රී දළදා මාළිගාව මහනුවර පිහිටා ඇත.",
            hint = "Proper noun phrase + is located in + city."
          ),
          SentencePuzzleItem(
            id = "c12_p14",
            scrambledWords = listOf("fasten", "Please", "seatbelt", "your", "takeoff", "during"),
            correctSentence = "Please fasten your seatbelt during takeoff.",
            sinhalaMeaning = "ගුවන් යානය ගුවන්ගත වන විට කරුණාකර ඔබේ ආසන පටිය පළඳින්න.",
            hint = "Polite request + object + prepositional time phrase."
          ),
          SentencePuzzleItem(
            id = "c12_p15",
            scrambledWords = listOf("respect", "Tourists", "should", "local", "customs", "traditions", "and"),
            correctSentence = "Tourists should respect local customs and traditions.",
            sinhalaMeaning = "සංචාරකයන් ප්‍රාදේශීය චාරිත්‍ර වාරිත්‍රවලට ගරු කළ යුතුය.",
            hint = "Subject + should respect + compound objects."
          ),
          SentencePuzzleItem(
            id = "c12_p16",
            scrambledWords = listOf("Nine", "Arch", "Bridge", "masterpiece", "architectural", "an", "is"),
            correctSentence = "Nine Arch Bridge is an architectural masterpiece.",
            sinhalaMeaning = "දෙමෝදර ආරුක්කු නවයේ පාලම වාස්තු විද්‍යාත්මක විශිෂ්ට නිර්මාණයකි.",
            hint = "Proper noun + is + article + adj + noun."
          ),
          SentencePuzzleItem(
            id = "c12_p17",
            scrambledWords = listOf("Bicycles", "are", "eco-friendly", "modes", "travel", "of"),
            correctSentence = "Bicycles are eco-friendly modes of travel.",
            sinhalaMeaning = "පාපැදි යනු පරිසර හිතකාමී ගමන් ප්‍රවාහන ක්‍රමයකි.",
            hint = "Plural subject + are + adjective + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c12_p18",
            scrambledWords = listOf("hospitality", "Sri", "Lankan", "renowned", "world", "over", "is"),
            correctSentence = "Sri Lankan hospitality is renowned world over.",
            sinhalaMeaning = "ශ්‍රී ලාංකේය ආගන්තුක සත්කාරය ලොව පුරා ප්‍රසිද්ධය.",
            hint = "Subject phrase + is renowned + world over."
          ),
          SentencePuzzleItem(
            id = "c12_p19",
            scrambledWords = listOf("Whale", "watching", "Mirissa", "in", "thrilling", "experience", "is"),
            correctSentence = "Whale watching in Mirissa is thrilling experience.",
            sinhalaMeaning = "මිරිස්සේදී තල්මසුන් නැරඹීම ත්‍රාසජනක අත්දැකීමකි.",
            hint = "Gerund subject + in Mirissa + is + predicate."
          ),
          SentencePuzzleItem(
            id = "c12_p20",
            scrambledWords = listOf("traveling", "Broaden", "your", "by", "mind", "widely"),
            correctSentence = "Broaden your mind by traveling widely.",
            sinhalaMeaning = "විවිධ ප්‍රදේශවල සංචාරය කිරීමෙන් ඔබේ මනස පුළුල් කරගන්න.",
            hint = "Imperative + object + by + gerund."
          )
        )
      ),

      // ==========================================
      // Category 13: Passive Voice Constructions (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 13,
        titleSinhala = "කාණ්ඩය 13: කර්මකාරක වාක්‍ය (Passive Voice)",
        titleEnglish = "Passive Voice Constructions",
        icon = "🔄",
        description = "විභාග සඳහා අත්‍යවශ්‍ය වන කර්මකාරක (is/was/were/been + V3) වාක්‍ය රටා 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c13_p1",
            scrambledWords = listOf("is", "English", "spoken", "over", "all", "the", "world"),
            correctSentence = "English is spoken all over the world.",
            sinhalaMeaning = "ඉංග්‍රීසි භාෂාව ලොව පුරා කතා කරනු ලැබේ.",
            hint = "Subject (English) + is + V3 (spoken) + place phrase."
          ),
          SentencePuzzleItem(
            id = "c13_p2",
            scrambledWords = listOf("was", "Sigiriya", "built", "ancient", "by", "builders", "talented"),
            correctSentence = "Sigiriya was built by talented ancient builders.",
            sinhalaMeaning = "සීගිරිය දක්ෂ පුරාණ නිර්මාණකරුවන් විසින් ගොඩනඟන ලදී.",
            hint = "Subject + was + V3 + by agent."
          ),
          SentencePuzzleItem(
            id = "c13_p3",
            scrambledWords = listOf("are", "Tea", "leaves", "picked", "by", "female", "workers", "carefully"),
            correctSentence = "Tea leaves are carefully picked by female workers.",
            sinhalaMeaning = "තේ දළු කාන්තා කම්කරුවන් විසින් ප්‍රවේශමෙන් නෙලනු ලැබේ.",
            hint = "Subject + are + adverb + V3 + by phrase."
          ),
          SentencePuzzleItem(
            id = "c13_p4",
            scrambledWords = listOf("was", "letter", "The", "delivered", "postman", "the", "by", "morning", "in"),
            correctSentence = "The letter was delivered by the postman in morning.",
            sinhalaMeaning = "ලිපිය උදෑසන තැපැල්කරු විසින් බෙදා හරින ලදී.",
            hint = "The letter was delivered + by postman + time."
          ),
          SentencePuzzleItem(
            id = "c13_p5",
            scrambledWords = listOf("will", "be", "results", "The", "published", "next", "week"),
            correctSentence = "The results will be published next week.",
            sinhalaMeaning = "ප්‍රතිඵල ලබන සතියේ ප්‍රකාශයට පත් කෙරෙනු ඇත.",
            hint = "Future passive: will be + V3 (published) + time."
          ),
          SentencePuzzleItem(
            id = "c13_p6",
            scrambledWords = listOf("are", "planted", "Trees", "protect", "soil", "to", "erosion"),
            correctSentence = "Trees are planted to protect soil erosion.",
            sinhalaMeaning = "පාංශු ඛාදනය වැළැක්වීම සඳහා ගස් සිටුවනු ලැබේ.",
            hint = "Subject + are + V3 + to-infinitive."
          ),
          SentencePuzzleItem(
            id = "c13_p7",
            scrambledWords = listOf("been", "has", "homework", "The", "completed", "student", "the", "by"),
            correctSentence = "The homework has been completed by the student.",
            sinhalaMeaning = "ගෙදර වැඩ ශිෂ්‍යයා විසින් සම්පූර්ණ කර අවසන් කර ඇත.",
            hint = "Perfect passive: has been + V3 + by agent."
          ),
          SentencePuzzleItem(
            id = "c13_p8",
            scrambledWords = listOf("was", "stolen", "bicycle", "The", "night", "last", "house", "from"),
            correctSentence = "The bicycle was stolen from house last night.",
            sinhalaMeaning = "පසුගිය රාත්‍රියේ නිවසින් පාපැදිය සොරකම් කරන ලදී.",
            hint = "Subject + was stolen + place + time."
          ),
          SentencePuzzleItem(
            id = "c13_p9",
            scrambledWords = listOf("is", "Rice", "eaten", "as", "food", "staple", "Lanka", "Sri", "in"),
            correctSentence = "Rice is eaten as staple food in Sri Lanka.",
            sinhalaMeaning = "ශ්‍රී ලංකාවේ ප්‍රධාන ආහාරය ලෙස බත් ආහාරයට ගනු ලැබේ.",
            hint = "Subject + is eaten + as phrase + location."
          ),
          SentencePuzzleItem(
            id = "c13_p10",
            scrambledWords = listOf("cleaned", "is", "classroom", "The", "every", "evening"),
            correctSentence = "The classroom is cleaned every evening.",
            sinhalaMeaning = "සෑම සවසකම පන්ති කාමරය පිරිසිදු කරනු ලැබේ.",
            hint = "Subject + is cleaned + time expression."
          ),
          SentencePuzzleItem(
            id = "c13_p11",
            scrambledWords = listOf("were", "rescued", "animals", "The", "floodwaters", "from", "brave", "volunteers", "by"),
            correctSentence = "The animals were rescued from floodwaters by brave volunteers.",
            sinhalaMeaning = "නිර්භීත ස්වේච්ඡා සේවකයන් විසින් සතුන් ගංවතුරෙන් බේරා ගන්නා ලදී.",
            hint = "Subject + were rescued + source + by agent."
          ),
          SentencePuzzleItem(
            id = "c13_p12",
            scrambledWords = listOf("can", "be", "Plastic", "recycled", "new", "products", "into"),
            correctSentence = "Plastic can be recycled into new products.",
            sinhalaMeaning = "ප්ලාස්ටික් නව නිෂ්පාදන බවට ප්‍රතිචක්‍රීකරණය කළ හැකිය.",
            hint = "Modal passive: can be + V3 + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c13_p13",
            scrambledWords = listOf("invented", "was", "telephone", "The", "century", "nineteenth", "in"),
            correctSentence = "The telephone was invented in nineteenth century.",
            sinhalaMeaning = "දුරකථනය දහනව වන සියවසේදී සොයා ගන්නා ලදී.",
            hint = "Subject + was invented + time phrase."
          ),
          SentencePuzzleItem(
            id = "c13_p14",
            scrambledWords = listOf("must", "be", "Rules", "strictly", "followed", "all", "by"),
            correctSentence = "Rules must be strictly followed by all.",
            sinhalaMeaning = "නීති රීති සැමදෙනා විසින්ම දැඩිව පිළිපැදිය යුතුය.",
            hint = "Rules + must be + adverb + V3 + by all."
          ),
          SentencePuzzleItem(
            id = "c13_p15",
            scrambledWords = listOf("repaired", "being", "is", "road", "The", "workers", "by"),
            correctSentence = "The road is being repaired by workers.",
            sinhalaMeaning = "කම්කරුවන් විසින් මාර්ගය අලුත්වැඩියා කරමින් පවතී.",
            hint = "Present continuous passive: is being + V3 + by agent."
          ),
          SentencePuzzleItem(
            id = "c13_p16",
            scrambledWords = listOf("awarded", "were", "Prizes", "winners", "to", "principal", "by"),
            correctSentence = "Prizes were awarded to winners by principal.",
            sinhalaMeaning = "විදුහල්පතිතුමා විසින් ජයග්‍රාහකයින්ට ත්‍යාග පිරිනමන ලදී.",
            hint = "Prizes were awarded + to recipient + by agent."
          ),
          SentencePuzzleItem(
            id = "c13_p17",
            scrambledWords = listOf("kept", "Medicine", "should", "be", "out", "reach", "children", "of"),
            correctSentence = "Medicine should be kept out of reach children.",
            sinhalaMeaning = "ඖෂධ දරුවන්ට ළඟාවිය නොහැකි පරිදි තැබිය යුතුය.",
            hint = "Medicine should be kept + out of reach..."
          ),
          SentencePuzzleItem(
            id = "c13_p18",
            scrambledWords = listOf("discovered", "Penicillin", "was", "Fleming", "Alexander", "by"),
            correctSentence = "Penicillin was discovered by Alexander Fleming.",
            sinhalaMeaning = "පෙනිසිලින් ඇලෙක්සැන්ඩර් ෆ්ලෙමින් විසින් සොයා ගන්නා ලදී.",
            hint = "Subject + was discovered + by person."
          ),
          SentencePuzzleItem(
            id = "c13_p19",
            scrambledWords = listOf("harvested", "Paddy", "is", "using", "modern", "machines"),
            correctSentence = "Paddy is harvested using modern machines.",
            sinhalaMeaning = "නවීන යන්ත්‍ර සූත්‍ර භාවිතයෙන් වී අස්වනු නෙලනු ලැබේ.",
            hint = "Paddy is harvested + participle instrument."
          ),
          SentencePuzzleItem(
            id = "c13_p20",
            scrambledWords = listOf("punished", "be", "Lawbreakers", "will", "court", "the", "by"),
            correctSentence = "Lawbreakers will be punished by the court.",
            sinhalaMeaning = "නීති කඩ කරන්නන්ට අධිකරණය මගින් දඬුවම් කරනු ඇත.",
            hint = "Future passive: will be + V3 + by the court."
          )
        )
      ),

      // ==========================================
      // Category 14: Conditional Sentences - Type 1 & 2 (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 14,
        titleSinhala = "කාණ්ඩය 14: කොන්දේසි සහිත වාක්‍ය (Conditional If Clauses)",
        titleEnglish = "Conditional Sentences - Type 1 & Type 2",
        icon = "⚖️",
        description = "විභාග සඳහා නිතර අසන 'If' කොන්දේසි සහිත වාක්‍ය රටා 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c14_p1",
            scrambledWords = listOf("rains", "it", "If", "stay", "we", "will", "home", "at"),
            correctSentence = "If it rains we will stay at home.",
            sinhalaMeaning = "වැස්සොත් අපි නිවසේ රැඳී සිටිමු.",
            hint = "If + Present Simple + Future Simple (will + verb)."
          ),
          SentencePuzzleItem(
            id = "c14_p2",
            scrambledWords = listOf("hard", "study", "you", "If", "pass", "will", "exam", "the", "you"),
            correctSentence = "If you study hard you will pass the exam.",
            sinhalaMeaning = "ඔබ මහන්සි වී පාඩම් කළහොත් විභාගය සමත් වනු ඇත.",
            hint = "If + Subject + Verb + Main clause."
          ),
          SentencePuzzleItem(
            id = "c14_p3",
            scrambledWords = listOf("were", "bird", "I", "a", "If", "fly", "would", "I", "sky", "in"),
            correctSentence = "If I were a bird I would fly in sky.",
            sinhalaMeaning = "මම කුරුල්ලෙකු වූවා නම් මම අහසේ පියාසර කරන්නෙමි.",
            hint = "Type 2 hypothetical: If I were + I would + base verb."
          ),
          SentencePuzzleItem(
            id = "c14_p4",
            scrambledWords = listOf("miss", "hurry", "Unless", "you", "will", "you", "bus", "the"),
            correctSentence = "Unless you hurry you will miss the bus.",
            sinhalaMeaning = "ඔබ ඉක්මන් නොවුණහොත් ඔබට බස් රථය මගහැරෙනු ඇත.",
            hint = "Unless (= If not) + present simple + future."
          ),
          SentencePuzzleItem(
            id = "c14_p5",
            scrambledWords = listOf("had", "money", "enough", "If", "I", "buy", "would", "car", "a"),
            correctSentence = "If I had enough money I would buy a car.",
            sinhalaMeaning = "මා සතුව ප්‍රමාණවත් මුදල් තිබුණා නම් මම කාර් එකක් ගන්නවා.",
            hint = "If + past simple + would + base verb."
          ),
          SentencePuzzleItem(
            id = "c14_p6",
            scrambledWords = listOf("ask", "politely", "you", "If", "help", "he", "will", "you"),
            correctSentence = "If you ask politely he will help you.",
            sinhalaMeaning = "ඔබ කාරුණිකව ඇසුවහොත් ඔහු ඔබට උදව් කරනු ඇත.",
            hint = "Type 1 condition."
          ),
          SentencePuzzleItem(
            id = "c14_p7",
            scrambledWords = listOf("water", "plants", "you", "If", "grow", "they", "will", "healthy"),
            correctSentence = "If you water plants they will grow healthy.",
            sinhalaMeaning = "ඔබ පැලවලට වතුර දැමුවහොත් ඒවා නිරෝගීව වැඩෙනු ඇත.",
            hint = "If + water plants + they will grow..."
          ),
          SentencePuzzleItem(
            id = "c14_p8",
            scrambledWords = listOf("knew", "answer", "the", "If", "I", "tell", "would", "you", "I"),
            correctSentence = "If I knew the answer I would tell you.",
            sinhalaMeaning = "මම පිළිතුර දැන සිටියා නම් මම ඔබට කියන්නෙමි.",
            hint = "Type 2 condition: If I knew... I would tell you."
          ),
          SentencePuzzleItem(
            id = "c14_p9",
            scrambledWords = listOf("eat", "too", "much", "If", "you", "will", "become", "sick", "you"),
            correctSentence = "If you eat too much you will become sick.",
            sinhalaMeaning = "ඔබ අධික ලෙස ආහාර ගත්තොත් ඔබ අසනීප වනු ඇත.",
            hint = "If you eat too much + result clause."
          ),
          SentencePuzzleItem(
            id = "c14_p10",
            scrambledWords = listOf("save", "money", "you", "If", "buy", "can", "bicycle", "a", "you"),
            correctSentence = "If you save money you can buy a bicycle.",
            sinhalaMeaning = "ඔබ මුදල් ඉතිරි කළහොත් ඔබට පාපැදියක් මිලදී ගත හැක.",
            hint = "If + present simple + modal (can) + base verb."
          ),
          SentencePuzzleItem(
            id = "c14_p11",
            scrambledWords = listOf("had", "wings", "If", "trees", "fly", "away", "could", "they"),
            correctSentence = "If trees had wings they could fly away.",
            sinhalaMeaning = "ගස්වලට පියාපත් තිබුණා නම් ඒවාට පියාසර කළ හැකිව තිබුණි.",
            hint = "Hypothetical condition: If + past + could + verb."
          ),
          SentencePuzzleItem(
            id = "c14_p12",
            scrambledWords = listOf("wake", "early", "up", "If", "you", "catch", "train", "will", "the"),
            correctSentence = "If you wake up early you will catch the train.",
            sinhalaMeaning = "ඔබ වේලාසනින් අවදි වුවහොත් ඔබට දුම්රිය අල්ලාගත හැකිය.",
            hint = "If clause + future result."
          ),
          SentencePuzzleItem(
            id = "c14_p13",
            scrambledWords = listOf("were", "president", "the", "If", "he", "help", "would", "poor", "the"),
            correctSentence = "If he were the president he would help the poor.",
            sinhalaMeaning = "ඔහු ජනාධිපති වූවා නම් ඔහු දුප්පතුන්ට උදව් කරනු ඇත.",
            hint = "Subjunctive 'were' for all persons in Type 2."
          ),
          SentencePuzzleItem(
            id = "c14_p14",
            scrambledWords = listOf("invite", "they", "me", "If", "go", "will", "party", "to", "I"),
            correctSentence = "If they invite me I will go to party.",
            sinhalaMeaning = "ඔවුන් මට ආරාධනා කළහොත් මම සාදයට යන්නෙමි.",
            hint = "If they invite me + I will go..."
          ),
          SentencePuzzleItem(
            id = "c14_p15",
            scrambledWords = listOf("exercise", "daily", "you", "If", "stay", "fit", "will", "you"),
            correctSentence = "If you exercise daily you will stay fit.",
            sinhalaMeaning = "ඔබ දිනපතා ව්‍යායාම කළහොත් ඔබට නිරෝගීව සිටිය හැක.",
            hint = "If you exercise daily + result."
          ),
          SentencePuzzleItem(
            id = "c14_p16",
            scrambledWords = listOf("lost", "map", "the", "If", "we", "ask", "would", "directions", "for"),
            correctSentence = "If we lost the map we would ask for directions.",
            sinhalaMeaning = "අපට සිතියම නැති වුණා නම් අපි මඟ විමසනු ඇත.",
            hint = "Type 2: If we lost... we would ask."
          ),
          SentencePuzzleItem(
            id = "c14_p17",
            scrambledWords = listOf("practice", "regularly", "If", "speak", "fluently", "will", "you", "English"),
            correctSentence = "If you practice regularly you will speak English fluently.",
            sinhalaMeaning = "ඔබ නිතිපතා පුහුණු වුවහොත් ඔබට චතුර ලෙස ඉංග්‍රීසි කතා කළ හැක.",
            hint = "Condition + Result with adverb (fluently)."
          ),
          SentencePuzzleItem(
            id = "c14_p18",
            scrambledWords = listOf("stop", "pollution", "Unless", "we", "suffer", "wildlife", "will"),
            correctSentence = "Unless we stop pollution wildlife will suffer.",
            sinhalaMeaning = "අපි පරිසර දූෂණය නොනැවැත්තුවහොත් වනජීවීන් පීඩාවට පත් වනු ඇත.",
            hint = "Unless clause + future main clause."
          ),
          SentencePuzzleItem(
            id = "c14_p19",
            scrambledWords = listOf("had", "time", "free", "If", "she", "join", "would", "club", "the"),
            correctSentence = "If she had free time she would join the club.",
            sinhalaMeaning = "ඇයට නිදහස් වේලාවක් තිබුණා නම් ඇය සමාජයට එකතු වනු ඇත.",
            hint = "If she had + would join."
          ),
          SentencePuzzleItem(
            id = "c14_p20",
            scrambledWords = listOf("shine", "sun", "does", "If", "go", "beach", "will", "we", "to"),
            correctSentence = "If sun does shine we will go to beach.",
            sinhalaMeaning = "හිරු පෑවුවහොත් අපි වෙරළට යන්නෙමු.",
            hint = "If clause + future result."
          )
        )
      ),

      // ==========================================
      // Category 15: Modal Verbs (Can, Could, Must, Should, May, Might) (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 15,
        titleSinhala = "කාණ්ඩය 15: අනුකාරක ක්‍රියාපද (Modal Verbs - Must, Should, Can...)",
        titleEnglish = "Modal Verbs & Obligations",
        icon = "🛡️",
        description = "හැකියාව, අවසරය, අනිවාර්යභාවය සහ යුතුකම දක්වන Modal verbs වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c15_p1",
            scrambledWords = listOf("must", "Citizens", "traffic", "obey", "all", "rules"),
            correctSentence = "Citizens must obey all traffic rules.",
            sinhalaMeaning = "පුරවැසියන් සියලුම රථවාහන නීතිවලට අනිවාර්යයෙන්ම කීකරු විය යුතුය.",
            hint = "Obligation: Subject + must + base verb + object."
          ),
          SentencePuzzleItem(
            id = "c15_p2",
            scrambledWords = listOf("should", "You", "elders", "respect", "always", "your"),
            correctSentence = "You should always respect your elders.",
            sinhalaMeaning = "ඔබ සැමවිටම ඔබේ වැඩිහිටියන්ට ගරු කළ යුතුය.",
            hint = "Moral duty: Subject + should + adverb + verb + object."
          ),
          SentencePuzzleItem(
            id = "c15_p3",
            scrambledWords = listOf("can", "speak", "She", "four", "languages", "different"),
            correctSentence = "She can speak four different languages.",
            sinhalaMeaning = "ඇයට විවිධ භාෂා හතරක් කතා කළ හැකිය.",
            hint = "Ability: Subject + can + base verb + object."
          ),
          SentencePuzzleItem(
            id = "c15_p4",
            scrambledWords = listOf("May", "come", "I", "sir", "in", "please", "?"),
            correctSentence = "May I come in sir please?",
            sinhalaMeaning = "මහත්මයා, මට ඇතුළට පැමිණිය හැකිද කරුණාකර?",
            hint = "Polite permission: May I come in...?"
          ),
          SentencePuzzleItem(
            id = "c15_p5",
            scrambledWords = listOf("might", "rain", "It", "afternoon", "this", "later"),
            correctSentence = "It might rain later this afternoon.",
            sinhalaMeaning = "අද සවස් වරුවේ වැසි ඇතිවීමට ඉඩ තිබේ.",
            hint = "Possibility: Subject + might + base verb + time."
          ),
          SentencePuzzleItem(
            id = "c15_p6",
            scrambledWords = listOf("could", "When", "was", "I", "run", "fast", "young", "I"),
            correctSentence = "When I was young I could run fast.",
            sinhalaMeaning = "මා තරුණ කාලයේ මට වේගයෙන් දුවන්නට හැකි විය.",
            hint = "Past ability: could run fast."
          ),
          SentencePuzzleItem(
            id = "c15_p7",
            scrambledWords = listOf("must", "not", "You", "waste", "clean", "water"),
            correctSentence = "You must not waste clean water.",
            sinhalaMeaning = "ඔබ පිරිසිදු ජලය නාස්ති නොකළ යුතුය.",
            hint = "Prohibition: must not + base verb."
          ),
          SentencePuzzleItem(
            id = "c15_p8",
            scrambledWords = listOf("ought", "We", "to", "help", "needy", "people", "the"),
            correctSentence = "We ought to help the needy people.",
            sinhalaMeaning = "අපි අසරණ මිනිසුන්ට උපකාර කළ යුතුව ඇත.",
            hint = "Duty: ought to + base verb + object."
          ),
          SentencePuzzleItem(
            id = "c15_p9",
            scrambledWords = listOf("Could", "pass", "you", "salt", "the", "please", "?"),
            correctSentence = "Could you pass the salt please?",
            sinhalaMeaning = "කරුණාකර ඔබට ලුණු බඳුන ලබා දිය හැකිද?",
            hint = "Polite request: Could you + base verb + object + please?"
          ),
          SentencePuzzleItem(
            id = "c15_p10",
            scrambledWords = listOf("Students", "have", "to", "wear", "uniform", "school", "daily"),
            correctSentence = "Students have to wear school uniform daily.",
            sinhalaMeaning = "සිසුන්ට දිනපතා පාසල් නිල ඇඳුම ඇඳීමට සිදුවේ.",
            hint = "External rule: have to + wear + object."
          ),
          SentencePuzzleItem(
            id = "c15_p11",
            scrambledWords = listOf("can", "solve", "Nuwan", "puzzle", "this", "easily"),
            correctSentence = "Nuwan can solve this puzzle easily.",
            sinhalaMeaning = "නුවන්ට මෙම ප්‍රහේලිකාව පහසුවෙන් විසඳිය හැකිය.",
            hint = "Subject + can + verb + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c15_p12",
            scrambledWords = listOf("should", "not", "We", "animals", "tease", "zoo", "in"),
            correctSentence = "We should not tease animals in zoo.",
            sinhalaMeaning = "අපි සත්වෝද්‍යානයේ සතුන්ට කරදර නොකළ යුතුය.",
            hint = "Negative advice: should not + base verb."
          ),
          SentencePuzzleItem(
            id = "c15_p13",
            scrambledWords = listOf("may", "borrow", "You", "book", "this", "days", "for", "two"),
            correctSentence = "You may borrow this book for two days.",
            sinhalaMeaning = "ඔබට දින දෙකක් සඳහා මෙම පොත ණයට ගත හැකිය.",
            hint = "Permission: You may + borrow + object + duration."
          ),
          SentencePuzzleItem(
            id = "c15_p14",
            scrambledWords = listOf("must", "wear", "helmets", "Motorcyclists", "safety", "for"),
            correctSentence = "Motorcyclists must wear helmets for safety.",
            sinhalaMeaning = "යතුරුපැදිකරුවන් ආරක්ෂාව සඳහා හිස්වැසුම් පැළඳිය යුතුය.",
            hint = "Subject + must wear + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c15_p15",
            scrambledWords = listOf("cannot", "fish", "A", "live", "water", "without"),
            correctSentence = "A fish cannot live without water.",
            sinhalaMeaning = "මත්ස්‍යයෙකුට ජලය නොමැතිව ජීවත් විය නොහැක.",
            hint = "Negative ability/truth: cannot + live + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c15_p16",
            scrambledWords = listOf("Would", "mind", "closing", "door", "the", "you", "?"),
            correctSentence = "Would you mind closing the door?",
            sinhalaMeaning = "කරුණාකර දොර වසා දැමීමට කාරුණික විය හැකිද?",
            hint = "Polite request: Would you mind + gerund (closing) + object?"
          ),
          SentencePuzzleItem(
            id = "c15_p17",
            scrambledWords = listOf("might", "arrive", "guest", "The", "chief", "late", "slightly"),
            correctSentence = "The chief guest might arrive slightly late.",
            sinhalaMeaning = "ප්‍රධාන ආරාධිත අමුත්තා මඳක් ප්‍රමාද වී පැමිණීමට ඉඩ ඇත.",
            hint = "Subject + might arrive + adverb phrase."
          ),
          SentencePuzzleItem(
            id = "c15_p18",
            scrambledWords = listOf("shall", "We", "overcome", "difficulties", "all", "together"),
            correctSentence = "We shall overcome all difficulties together.",
            sinhalaMeaning = "අපි සියලු දුෂ්කරතා එක්ව ජය ගන්නෙමු.",
            hint = "Determination: We shall + base verb + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c15_p19",
            scrambledWords = listOf("need", "not", "You", "worry", "small", "about", "matters"),
            correctSentence = "You need not worry about small matters.",
            sinhalaMeaning = "සුළු කරුණු ගැන ඔබ කලබල විය යුතු නැත.",
            hint = "Absence of obligation: need not + verb + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c15_p20",
            scrambledWords = listOf("Can", "lend", "me", "pen", "your", "minute", "a", "for", "?"),
            correctSentence = "Can you lend me your pen for a minute?",
            sinhalaMeaning = "මොහොතකට ඔබේ පෑන මට ලබා දිය හැකිද?",
            hint = "Informal request: Can you lend me...?"
          )
        )
      ),

      // ==========================================
      // Category 16: Relative Clauses (Who, Which, That, Whose, Where) (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 16,
        titleSinhala = "කාණ්ඩය 16: සම්බන්ධක වාක්‍යාංශ (Relative Clauses - Who, Which, That)",
        titleEnglish = "Relative Clauses & Complex Sentences",
        icon = "🔗",
        description = "වාක්‍ය දෙකක් සම්බන්ධ කරන Who, Which, That, Where, Whose යෙදෙන වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c16_p1",
            scrambledWords = listOf("girl", "who", "The", "won", "race", "the", "my", "is", "sister"),
            correctSentence = "The girl who won the race is my sister.",
            sinhalaMeaning = "තරගය ජයග්‍රහණය කළ දැරිය මගේ සහෝදරියයි.",
            hint = "Relative pronoun 'who' for people: The girl who won the race + is my sister."
          ),
          SentencePuzzleItem(
            id = "c16_p2",
            scrambledWords = listOf("book", "which", "The", "I", "bought", "interesting", "very", "is"),
            correctSentence = "The book which I bought is very interesting.",
            sinhalaMeaning = "මා මිලදී ගත් පොත ඉතා රසවත්ය.",
            hint = "Relative pronoun 'which' for objects: The book which I bought + is..."
          ),
          SentencePuzzleItem(
            id = "c16_p3",
            scrambledWords = listOf("doctor", "whose", "The", "clinic", "is", "nearby", "very", "kind", "is"),
            correctSentence = "The doctor whose clinic is nearby is very kind.",
            sinhalaMeaning = "සායනය අසල පිහිටි වෛද්‍යවරයා ඉතා කාරුණිකය.",
            hint = "Possessive relative 'whose': The doctor whose clinic..."
          ),
          SentencePuzzleItem(
            id = "c16_p4",
            scrambledWords = listOf("place", "This", "is", "where", "we", "first", "met", "the"),
            correctSentence = "This is the place where we first met.",
            sinhalaMeaning = "අප මුලින්ම හමු වූ ස්ථානය මෙයයි.",
            hint = "Relative adverb 'where' for place."
          ),
          SentencePuzzleItem(
            id = "c16_p5",
            scrambledWords = listOf("car", "that", "makes", "noise", "The", "loud", "belongs", "uncle", "to"),
            correctSentence = "The car that makes loud noise belongs to uncle.",
            sinhalaMeaning = "විශාල ශබ්දයක් නිකුත් කරන මෝටර් රථය මාමාගේය.",
            hint = "Relative pronoun 'that': The car that makes loud noise..."
          ),
          SentencePuzzleItem(
            id = "c16_p6",
            scrambledWords = listOf("man", "who", "helped", "us", "honest", "an", "is", "officer"),
            correctSentence = "The man who helped us is an honest officer.",
            sinhalaMeaning = "අපට උදව් කළ පුද්ගලයා අවංක නිලධාරියෙකි.",
            hint = "The man who helped us + is an honest officer."
          ),
          SentencePuzzleItem(
            id = "c16_p7",
            scrambledWords = listOf("trees", "which", "grow", "here", "tall", "are", "very"),
            correctSentence = "The trees which grow here are very tall.",
            sinhalaMeaning = "මෙහි වැඩෙන ගස් ඉතා උසය.",
            hint = "Subject + which clause + predicate."
          ),
          SentencePuzzleItem(
            id = "c16_p8",
            scrambledWords = listOf("student", "whose", "marks", "highest", "were", "got", "trophy", "the"),
            correctSentence = "The student whose marks were highest got the trophy.",
            sinhalaMeaning = "වැඩිම ලකුණු ලබාගත් ශිෂ්‍යයාට කුසලානය හිමිවිය.",
            hint = "The student whose marks were highest + verb phrase."
          ),
          SentencePuzzleItem(
            id = "c16_p9",
            scrambledWords = listOf("house", "where", "I", "was", "born", "near", "river", "is", "the"),
            correctSentence = "The house where I was born is near the river.",
            sinhalaMeaning = "මා උපන් නිවස ගඟ අසල පිහිටා ඇත.",
            hint = "The house where I was born + is near the river."
          ),
          SentencePuzzleItem(
            id = "c16_p10",
            scrambledWords = listOf("pen", "which", "lost", "was", "found", "desk", "under"),
            correctSentence = "The pen which was lost was found under desk.",
            sinhalaMeaning = "නැතිවී තිබූ පෑන ඩෙස්ක් එක යට තිබී හමුවිය.",
            hint = "Subject + which clause + main predicate."
          ),
          SentencePuzzleItem(
            id = "c16_p11",
            scrambledWords = listOf("author", "who", "wrote", "novel", "this", "famous", "is"),
            correctSentence = "The author who wrote this novel is famous.",
            sinhalaMeaning = "මෙම නවකතාව ලියූ කතුවරයා ප්‍රසිද්ධය.",
            hint = "The author who wrote this novel + is famous."
          ),
          SentencePuzzleItem(
            id = "c16_p12",
            scrambledWords = listOf("camera", "that", "bought", "he", "expensive", "is", "quite"),
            correctSentence = "The camera that he bought is quite expensive.",
            sinhalaMeaning = "ඔහු මිලදී ගත් කැමරාව තරමක් මිල අධිකය.",
            hint = "The camera that he bought + is quite expensive."
          ),
          SentencePuzzleItem(
            id = "c16_p13",
            scrambledWords = listOf("day", "when", "we", "arrived", "rainy", "was", "The"),
            correctSentence = "The day when we arrived was rainy.",
            sinhalaMeaning = "අප පැමිණි දිනය වැසි සහිත දිනයක් විය.",
            hint = "Relative time word 'when'."
          ),
          SentencePuzzleItem(
            id = "c16_p14",
            scrambledWords = listOf("boy", "who", "speaks", "fluent", "French", "won", "scholarship"),
            correctSentence = "The boy who speaks fluent French won scholarship.",
            sinhalaMeaning = "චතුර ලෙස ප්‍රංශ භාෂාව කතා කරන පිරිමි ළමයා ශිෂ්‍යත්වය දිනා ගත්තේය.",
            hint = "The boy who speaks... + main verb phrase."
          ),
          SentencePuzzleItem(
            id = "c16_p15",
            scrambledWords = listOf("hospital", "where", "she", "works", "modern", "very", "is"),
            correctSentence = "The hospital where she works is very modern.",
            sinhalaMeaning = "ඇය සේවය කරන රෝහල ඉතා නවීනයි.",
            hint = "The hospital where she works + is very modern."
          ),
          SentencePuzzleItem(
            id = "c16_p16",
            scrambledWords = listOf("dog", "that", "barks", "never", "bites", "loudly"),
            correctSentence = "The dog that barks loudly never bites.",
            sinhalaMeaning = "හයියෙන් බුරන බල්ලා කිසිදා සපා නොකයි.",
            hint = "Proverbial relative clause."
          ),
          SentencePuzzleItem(
            id = "c16_p17",
            scrambledWords = listOf("musician", "whose", "songs", "we", "love", "visited", "school"),
            correctSentence = "The musician whose songs we love visited school.",
            sinhalaMeaning = "අප ප්‍රිය කරන ගීත නිර්මාණය කළ සංගීතඥයා පාසලට පැමිණියේය.",
            hint = "The musician whose songs we love + verb."
          ),
          SentencePuzzleItem(
            id = "c16_p18",
            scrambledWords = listOf("food", "which", "is", "fresh", "healthy", "always", "is"),
            correctSentence = "The food which is fresh is always healthy.",
            sinhalaMeaning = "නැවුම් ආහාර සැමවිටම සෞඛ්‍ය සම්පන්න වේ.",
            hint = "The food which is fresh + predicate."
          ),
          SentencePuzzleItem(
            id = "c16_p19",
            scrambledWords = listOf("farmer", "who", "works", "tirelessly", "feeds", "nation", "the"),
            correctSentence = "The farmer who works tirelessly feeds the nation.",
            sinhalaMeaning = "වෙහෙස නොබලා වැඩ කරන ගොවියා ජාතිය පෝෂණය කරයි.",
            hint = "Subject + relative clause + verb + object."
          ),
          SentencePuzzleItem(
            id = "c16_p20",
            scrambledWords = listOf("reason", "why", "he", "came", "clear", "is", "now"),
            correctSentence = "The reason why he came is clear now.",
            sinhalaMeaning = "ඔහු පැමිණි හේතුව දැන් පැහැදිලිය.",
            hint = "Relative reason 'why'."
          )
        )
      ),

      // ==========================================
      // Category 17: Reported / Indirect Speech Statements (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 17,
        titleSinhala = "කාණ්ඩය 17: වක්‍ර ප්‍රකාශන වාක්‍ය (Reported / Indirect Speech)",
        titleEnglish = "Reported Speech & Statements",
        icon = "💬",
        description = "කෙනෙකු පැවසූ දේ වෙනත් කෙනෙකුට ප්‍රකාශ කිරීමේ විභාග වාක්‍ය රටා 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c17_p1",
            scrambledWords = listOf("said", "he", "He", "that", "was", "tired", "very"),
            correctSentence = "He said that he was very tired.",
            sinhalaMeaning = "තමාට ඉතා මහන්සි බව ඔහු පැවසුවේය.",
            hint = "Reporting verb (said) + that + past tense shift."
          ),
          SentencePuzzleItem(
            id = "c17_p2",
            scrambledWords = listOf("told", "teacher", "The", "us", "study", "to", "hard"),
            correctSentence = "The teacher told us to study hard.",
            sinhalaMeaning = "මහන්සි වී පාඩම් කරන ලෙස ගුරුතුමා අපට කීවේය.",
            hint = "Reported order/advice: told us + to-infinitive."
          ),
          SentencePuzzleItem(
            id = "c17_p3",
            scrambledWords = listOf("asked", "She", "me", "where", "lived", "I"),
            correctSentence = "She asked me where I lived.",
            sinhalaMeaning = "මා පදිංචිව සිටින්නේ කොහේදැයි ඇය මගෙන් ඇසුවාය.",
            hint = "Reported Wh-question: asked me + where + subject + verb (no question mark)."
          ),
          SentencePuzzleItem(
            id = "c17_p4",
            scrambledWords = listOf("said", "Mother", "that", "dinner", "ready", "was"),
            correctSentence = "Mother said that dinner was ready.",
            sinhalaMeaning = "රාත්‍රී ආහාරය සූදානම් බව මව පැවසුවාය.",
            hint = "Mother said that + past clause."
          ),
          SentencePuzzleItem(
            id = "c17_p5",
            scrambledWords = listOf("asked", "Nimal", "if", "I", "could", "him", "help"),
            correctSentence = "Nimal asked if I could help him.",
            sinhalaMeaning = "මට ඔහුට උදව් කළ හැකිදැයි නිමාල් ඇසුවේය.",
            hint = "Reported Yes/No question: asked if + subject + modal shift (could)."
          ),
          SentencePuzzleItem(
            id = "c17_p6",
            scrambledWords = listOf("promised", "He", "that", "would", "return", "soon", "he"),
            correctSentence = "He promised that he would return soon.",
            sinhalaMeaning = "තමා ළඟදීම ආපසු එන බවට ඔහු පොරොන්දු විය.",
            hint = "promised that + would (future in past)."
          ),
          SentencePuzzleItem(
            id = "c17_p7",
            scrambledWords = listOf("advised", "doctor", "The", "patient", "to", "rest", "the"),
            correctSentence = "The doctor advised the patient to rest.",
            sinhalaMeaning = "විවේක ගන්නා ලෙස වෛද්‍යවරයා රෝගියාට උපදෙස් දුන්නේය.",
            hint = "Subject + advised + object + to rest."
          ),
          SentencePuzzleItem(
            id = "c17_p8",
            scrambledWords = listOf("explained", "teacher", "The", "earth", "round", "is", "that"),
            correctSentence = "The teacher explained that earth is round.",
            sinhalaMeaning = "පෘථිවිය වටකුරු බව ගුරුතුමා පැහැදිලි කළේය.",
            hint = "Universal truth remains in present tense."
          ),
          SentencePuzzleItem(
            id = "c17_p9",
            scrambledWords = listOf("said", "They", "had", "they", "match", "won", "the", "that"),
            correctSentence = "They said that they had won the match.",
            sinhalaMeaning = "තමන් තරගය ජයග්‍රහණය කළ බව ඔවුහු පැවසූහ.",
            hint = "said that + past perfect (had won)."
          ),
          SentencePuzzleItem(
            id = "c17_p10",
            scrambledWords = listOf("asked", "policeman", "The", "license", "my", "for", "me"),
            correctSentence = "The policeman asked me for my license.",
            sinhalaMeaning = "පොලිස් නිලධාරියා මගෙන් මගේ රියදුරු බලපත්‍රය ඉල්ලා සිටියේය.",
            hint = "Subject + asked me for + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c17_p11",
            scrambledWords = listOf("warned", "Father", "not", "to", "swim", "deep", "us"),
            correctSentence = "Father warned us not to swim deep.",
            sinhalaMeaning = "ගැඹුරු දියේ නොපීනන ලෙස පියා අපට අනතුරු ඇඟවීය.",
            hint = "warned us + not to + verb + adverb."
          ),
          SentencePuzzleItem(
            id = "c17_p12",
            scrambledWords = listOf("replied", "She", "that", "knew", "nobody", "there", "she"),
            correctSentence = "She replied that she knew nobody there.",
            sinhalaMeaning = "එහි කිසිවකු තමන් නොහඳුනන බව ඇය පිළිතුරු දුන්නාය.",
            hint = "She replied that she knew..."
          ),
          SentencePuzzleItem(
            id = "c17_p13",
            scrambledWords = listOf("inquired", "stranger", "The", "way", "station", "the", "to"),
            correctSentence = "The stranger inquired the way to station.",
            sinhalaMeaning = "ආගන්තුකයා දුම්රිය ස්ථානයට යන මාර්ගය විමසුවේය.",
            hint = "Subject + inquired + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c17_p14",
            scrambledWords = listOf("agreed", "Kasun", "meet", "to", "library", "at", "the"),
            correctSentence = "Kasun agreed to meet at the library.",
            sinhalaMeaning = "පුස්තකාලයේදී හමුවීමට කසුන් එකඟ විය.",
            hint = "agreed + to-infinitive + place."
          ),
          SentencePuzzleItem(
            id = "c17_p15",
            scrambledWords = listOf("stated", "officer", "The", "truth", "would", "prevail", "that"),
            correctSentence = "The officer stated that truth would prevail.",
            sinhalaMeaning = "සත්‍යය ජයගන්නා බව නිලධාරියා ප්‍රකාශ කළේය.",
            hint = "stated that + subject + modal would."
          ),
          SentencePuzzleItem(
            id = "c17_p16",
            scrambledWords = listOf("requested", "Student", "extra", "an", "sheet", "paper", "of"),
            correctSentence = "Student requested an extra sheet of paper.",
            sinhalaMeaning = "ශිෂ්‍යයා අමතර කඩදාසි කොළයක් ඉල්ලා සිටියේය.",
            hint = "Subject + requested + object."
          ),
          SentencePuzzleItem(
            id = "c17_p17",
            scrambledWords = listOf("wondered", "she", "where", "brother", "her", "gone", "had"),
            correctSentence = "She wondered where her brother had gone.",
            sinhalaMeaning = "තම සහෝදරයා කොහේ ගියේදැයි ඇය මවිත වූවාය.",
            hint = "wondered where + subject + past perfect."
          ),
          SentencePuzzleItem(
            id = "c17_p18",
            scrambledWords = listOf("admitted", "boy", "The", "that", "made", "mistake", "he", "a"),
            correctSentence = "The boy admitted that he made a mistake.",
            sinhalaMeaning = "තමා අත්වැරැද්දක් කළ බව පිරිමි ළමයා පිළිගත්තේය.",
            hint = "admitted that + he made a mistake."
          ),
          SentencePuzzleItem(
            id = "c17_p19",
            scrambledWords = listOf("ordered", "captain", "The", "soldiers", "march", "to", "forward"),
            correctSentence = "The captain ordered soldiers to march forward.",
            sinhalaMeaning = "ඉදිරියට ගමන් කරන ලෙස කපිතාන්වරයා සොල්දාදුවන්ට අණ කළේය.",
            hint = "ordered + object + to-infinitive."
          ),
          SentencePuzzleItem(
            id = "c17_p20",
            scrambledWords = listOf("suggested", "We", "taking", "break", "a", "short"),
            correctSentence = "We suggested taking a short break.",
            sinhalaMeaning = "කෙටි විවේකයක් ගැනීමට අපි යෝජනා කළෙමු.",
            hint = "suggested + gerund phrase."
          )
        )
      ),

      // ==========================================
      // Category 18: Question Formation (Wh- Questions & Inversions) (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 18,
        titleSinhala = "කාණ්ඩය 18: ප්‍රශ්න ගොඩනැගීම (Question Formation & Wh- Questions)",
        titleEnglish = "Question Formation & Inversions",
        icon = "❓",
        description = "ඉංග්‍රීසි භාෂාවේ ප්‍රශ්නාර්ථ වාක්‍ය නිවැරදි ව්‍යාකරණ පිළිවෙළට සැකසීම සඳහා වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c18_p1",
            scrambledWords = listOf("do", "Where", "live", "you", "city", "in", "this", "?"),
            correctSentence = "Where do you live in this city?",
            sinhalaMeaning = "ඔබ මෙම නගරයේ පදිංචිව සිටින්නේ කොහේද?",
            hint = "Wh-word (Where) + auxiliary (do) + subject (you) + main verb (live) + phrase + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p2",
            scrambledWords = listOf("What", "time", "train", "does", "the", "arrive", "?"),
            correctSentence = "What time does the train arrive?",
            sinhalaMeaning = "දුම්රිය පැමිණෙන්නේ කීයටද?",
            hint = "Question phrase (What time) + does + subject + base verb + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p3",
            scrambledWords = listOf("Why", "you", "late", "are", "school", "to", "today", "?"),
            correctSentence = "Why are you late to school today?",
            sinhalaMeaning = "අද ඔබ පාසලට ප්‍රමාද වූයේ මන්ද?",
            hint = "Why + are + subject (you) + adjective (late) + location + time + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p4",
            scrambledWords = listOf("How", "many", "books", "borrow", "did", "you", "yesterday", "?"),
            correctSentence = "How many books did you borrow yesterday?",
            sinhalaMeaning = "ඊයේ ඔබ පොත් කීයක් ණයට ගත්තාද?",
            hint = "How many + plural noun + did + subject + verb + time + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p5",
            scrambledWords = listOf("Who", "wrote", "national", "our", "anthem", "song", "?"),
            correctSentence = "Who wrote our national anthem song?",
            sinhalaMeaning = "අපේ ජාතික ගීය රචනා කළේ කවුද?",
            hint = "Subject question: Who + past verb (wrote) + object + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p6",
            scrambledWords = listOf("Which", "colour", "prefer", "do", "you", "most", "?"),
            correctSentence = "Which colour do you prefer most?",
            sinhalaMeaning = "ඔබ වඩාත්ම කැමති කුමන වර්ණයටද?",
            hint = "Which + noun + do + you + verb + adverb + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p7",
            scrambledWords = listOf("Whose", "bag", "is", "lying", "floor", "on", "the", "?"),
            correctSentence = "Whose bag is lying on the floor?",
            sinhalaMeaning = "බිම වැටී ඇත්තේ කාගේ බෑගයද?",
            hint = "Whose + noun + is lying + location + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p8",
            scrambledWords = listOf("When", "will", "examination", "the", "final", "begin", "?"),
            correctSentence = "When will the final examination begin?",
            sinhalaMeaning = "අවසන් විභාගය ආරම්භ වන්නේ කවදාද?",
            hint = "When + will + subject + base verb + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p9",
            scrambledWords = listOf("Can", "you", "swim", "across", "river", "this", "?"),
            correctSentence = "Can you swim across this river?",
            sinhalaMeaning = "ඔබට මෙම ගඟ හරහා පීනන්න පුළුවන්ද?",
            hint = "Modal question: Can + subject + base verb + prepositional phrase + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p10",
            scrambledWords = listOf("Did", "finish", "she", "science", "her", "project", "yesterday", "?"),
            correctSentence = "Did she finish her science project yesterday?",
            sinhalaMeaning = "ඇය ඊයේ ඇගේ විද්‍යා ව්‍යාපෘතිය අවසන් කළාද?",
            hint = "Did + subject + base verb (finish) + object + time + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p11",
            scrambledWords = listOf("How", "long", "does", "take", "it", "to", "Kandy", "reach", "?"),
            correctSentence = "How long does it take to reach Kandy?",
            sinhalaMeaning = "මහනුවරට ළඟාවීමට කොපමණ වේලාවක් ගතවේද?",
            hint = "How long does it take + infinitive phrase + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p12",
            scrambledWords = listOf("Is", "there", "hospital", "a", "near", "place", "this", "?"),
            correctSentence = "Is there a hospital near this place?",
            sinhalaMeaning = "මේ ස්ථානය අසල රෝහලක් තිබේද?",
            hint = "Is there + singular noun + location + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p13",
            scrambledWords = listOf("Are", "ready", "you", "for", "adventure", "the", "?"),
            correctSentence = "Are you ready for the adventure?",
            sinhalaMeaning = "ඔබ වික්‍රමාන්විත ගමන සඳහා සූදානම්ද?",
            hint = "Are + you + ready for + noun + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p14",
            scrambledWords = listOf("How", "much", "milk", "need", "do", "we", "cake", "for", "?"),
            correctSentence = "How much milk do we need for cake?",
            sinhalaMeaning = "කේක් එක සඳහා අපට කිරි කොපමණ ප්‍රමාණයක් අවශ්‍යද?",
            hint = "How much + uncountable noun + do + we + need + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p15",
            scrambledWords = listOf("Have", "seen", "you", "keys", "my", "anywhere", "?"),
            correctSentence = "Have you seen my keys anywhere?",
            sinhalaMeaning = "ඔබ මගේ යතුරු කොහේ හෝ දුටුවාද?",
            hint = "Have you + V3 (seen) + object + adverb + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p16",
            scrambledWords = listOf("Where", "did", "put", "you", "dictionary", "the", "?"),
            correctSentence = "Where did you put the dictionary?",
            sinhalaMeaning = "ඔබ ශබ්දකෝෂය තැබුවේ කොහේද?",
            hint = "Where did you + put + object + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p17",
            scrambledWords = listOf("What", "happened", "morning", "this", "meeting", "at", "the", "?"),
            correctSentence = "What happened at the meeting this morning?",
            sinhalaMeaning = "අද උදෑසන රැස්වීමේදී කුමක් සිදුවූයේද?",
            hint = "Subject question: What happened + place + time + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p18",
            scrambledWords = listOf("Should", "inform", "we", "class", "teacher", "our", "?"),
            correctSentence = "Should we inform our class teacher?",
            sinhalaMeaning = "අපි අපේ පන්තිභාර ගුරුතුමියට දැනුම් දිය යුතුද?",
            hint = "Modal question: Should + we + base verb + object + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p19",
            scrambledWords = listOf("Whom", "did", "see", "you", "yesterday", "gate", "at", "?"),
            correctSentence = "Whom did you see at gate yesterday?",
            sinhalaMeaning = "ඊයේ ගේට්ටුව අසලදී ඔබ දුටුවේ කාටද?",
            hint = "Object pronoun: Whom did you see + place + time + ?"
          ),
          SentencePuzzleItem(
            id = "c18_p20",
            scrambledWords = listOf("Why", "is", "water", "essential", "all", "life", "for", "?"),
            correctSentence = "Why is water essential for all life?",
            sinhalaMeaning = "සියලු ජීවය සඳහා ජලය අත්‍යවශ්‍ය වන්නේ ඇයි?",
            hint = "Why is + subject + adjective + prepositional phrase + ?"
          )
        )
      ),

      // ==========================================
      // Category 19: Friendship, Moral Values & Kindness (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 19,
        titleSinhala = "කාණ්ඩය 19: මිත්‍රත්වය, සදාචාරාත්මක අගයන් සහ කරුණාව",
        titleEnglish = "Friendship, Morals & Family Values",
        icon = "🤝",
        description = "සැබෑ මිත්‍රත්වය, කරුණාව, ගුණධර්ම සහ වැඩිහිටියන්ට සැලකීම පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c19_p1",
            scrambledWords = listOf("friend", "in", "A", "need", "friend", "is", "indeed", "a"),
            correctSentence = "A friend in need is a friend indeed.",
            sinhalaMeaning = "විපතකදී පිහිටවන මිතුරා සැබෑ මිතුරා වේ.",
            hint = "Famous proverb: A friend in need is a friend indeed."
          ),
          SentencePuzzleItem(
            id = "c19_p2",
            scrambledWords = listOf("Kindness", "language", "is", "a", "deaf", "can", "hear", "the", "which"),
            correctSentence = "Kindness is a language which the deaf can hear.",
            sinhalaMeaning = "කරුණාව යනු බිහිරන්ට පවා ඇසෙන භාෂාවකි.",
            hint = "Subject + is a language + which clause."
          ),
          SentencePuzzleItem(
            id = "c19_p3",
            scrambledWords = listOf("Honesty", "the", "is", "best", "policy", "life", "in"),
            correctSentence = "Honesty is the best policy in life.",
            sinhalaMeaning = "අවංකකම ජීවිතයේ හොඳම ප්‍රතිපත්තියයි.",
            hint = "Proverb: Honesty is the best policy."
          ),
          SentencePuzzleItem(
            id = "c19_p4",
            scrambledWords = listOf("Always", "speak", "truth", "the", "fear", "without"),
            correctSentence = "Always speak the truth without fear.",
            sinhalaMeaning = "සැමවිටම බියෙන් තොරව සත්‍යය කතා කරන්න.",
            hint = "Adverb + Imperative + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c19_p5",
            scrambledWords = listOf("Respect", "parents", "your", "who", "sacrificed", "you", "for"),
            correctSentence = "Respect your parents who sacrificed for you.",
            sinhalaMeaning = "ඔබ වෙනුවෙන් කැපකිරීම් කළ ඔබේ දෙමාපියන්ට ගරු කරන්න.",
            hint = "Imperative + object + relative clause."
          ),
          SentencePuzzleItem(
            id = "c19_p6",
            scrambledWords = listOf("share", "True", "friends", "sorrows", "joys", "and", "their"),
            correctSentence = "True friends share their joys and sorrows.",
            sinhalaMeaning = "සැබෑ මිතුරන් ඔවුන්ගේ සතුට මෙන්ම දුකද බෙදා ගනී.",
            hint = "Subject + verb + compound objects."
          ),
          SentencePuzzleItem(
            id = "c19_p7",
            scrambledWords = listOf("smile", "warm", "A", "melts", "anger", "strangers", "between"),
            correctSentence = "A warm smile melts anger between strangers.",
            sinhalaMeaning = "උණුසුම් සිනහවක් ආගන්තුකයන් අතර ඇති කෝපය දියකර හරියි.",
            hint = "Subject + verb + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c19_p8",
            scrambledWords = listOf("Help", "elderly", "cross", "people", "street", "busy", "the"),
            correctSentence = "Help elderly people cross the busy street.",
            sinhalaMeaning = "කාර්යබහුල පාර මාරුවීමට වැඩිහිටියන්ට උදව් කරන්න.",
            hint = "Help + object + bare infinitive (cross) + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c19_p9",
            scrambledWords = listOf("Forgiveness", "heals", "deepest", "wounds", "of", "heart"),
            correctSentence = "Forgiveness heals deepest wounds of heart.",
            sinhalaMeaning = "සමාව දීම හදවතේ ගැඹුරුම තුවාල සුවපත් කරයි.",
            hint = "Subject + heals + superlative object phrase."
          ),
          SentencePuzzleItem(
            id = "c19_p10",
            scrambledWords = listOf("Never", "mock", "anyone", "for", "weakness", "their"),
            correctSentence = "Never mock anyone for their weakness.",
            sinhalaMeaning = "කිසිවෙකුගේ දුර්වලතාවයකට කිසිවිටෙකත් සමච්චල් නොකරන්න.",
            hint = "Adverb + Imperative + object + reason."
          ),
          SentencePuzzleItem(
            id = "c19_p11",
            scrambledWords = listOf("Patience", "bitter", "is", "fruit", "sweet", "its", "but"),
            correctSentence = "Patience is bitter but its fruit sweet.",
            sinhalaMeaning = "ඉවසීම කටුක වුවත් එහි ඵලය ඉතා මිහිරි වේ.",
            hint = "Compound proverb: Patience is bitter but..."
          ),
          SentencePuzzleItem(
            id = "c19_p12",
            scrambledWords = listOf("Gratitude", "turns", "what", "have", "we", "enough", "into"),
            correctSentence = "Gratitude turns what we have into enough.",
            sinhalaMeaning = "කෘතඥතාව අප සතුව ඇති දේ ප්‍රමාණවත් තත්ත්වයට පත් කරයි.",
            hint = "Subject + turns + noun clause + into enough."
          ),
          SentencePuzzleItem(
            id = "c19_p13",
            scrambledWords = listOf("Treat", "others", "as", "want", "you", "be", "treated", "to"),
            correctSentence = "Treat others as you want to be treated.",
            sinhalaMeaning = "ඔබ තමන්ට අන් අය සලකනවාට කැමති අයුරින් අන් අයටත් සලකන්න (The Golden Rule).",
            hint = "The Golden Rule: Treat others as..."
          ),
          SentencePuzzleItem(
            id = "c19_p14",
            scrambledWords = listOf("Love", "binds", "family", "members", "strong", "harmony", "in"),
            correctSentence = "Love binds family members in strong harmony.",
            sinhalaMeaning = "ආදරය පවුලේ සාමාජිකයන් දැඩි සමගියකින් බැඳ තබයි.",
            hint = "Subject + binds + object + prepositional phrase."
          ),
          SentencePuzzleItem(
            id = "c19_p15",
            scrambledWords = listOf("generous", "heart", "A", "attracts", "blessings", "many"),
            correctSentence = "A generous heart attracts many blessings.",
            sinhalaMeaning = "ත්‍යාගශීලී හදවතක් බොහෝ ආශිර්වාද ආකර්ෂණය කර ගනී.",
            hint = "Subject + attracts + object."
          ),
          SentencePuzzleItem(
            id = "c19_p16",
            scrambledWords = listOf("Be", "humble", "in", "success", "courageous", "and", "failure", "in"),
            correctSentence = "Be humble in success and courageous in failure.",
            sinhalaMeaning = "ජයග්‍රහණයේදී නිහතමානී වන්න; පරාජයේදී ධෛර්යවන්ත වන්න.",
            hint = "Imperative with parallel adjectives: Be humble... and courageous..."
          ),
          SentencePuzzleItem(
            id = "c19_p17",
            scrambledWords = listOf("Good", "manners", "cost", "nothing", "win", "everything", "but"),
            correctSentence = "Good manners cost nothing but win everything.",
            sinhalaMeaning = "යහපත් ගතිපැවතුම්වලට කිසිදු වියදමක් නොයයි, නමුත් සියල්ල ජයග්‍රහණය කරයි.",
            hint = "Subject + cost nothing + but win everything."
          ),
          SentencePuzzleItem(
            id = "c19_p18",
            scrambledWords = listOf("deeds", "Noble", "leave", "footprints", "golden", "history", "in"),
            correctSentence = "Noble deeds leave golden footprints in history.",
            sinhalaMeaning = "උදාර ක්‍රියාවන් ඉතිහාසයේ රන් සලකුණු තබයි.",
            hint = "Subject + leave + object + in history."
          ),
          SentencePuzzleItem(
            id = "c19_p19",
            scrambledWords = listOf("Compassion", "makes", "human", "being", "truly", "noble", "a"),
            correctSentence = "Compassion makes a human being truly noble.",
            sinhalaMeaning = "කරුණාව මිනිසෙකු සැබවින්ම ශ්‍රේෂ්ඨ කරයි.",
            hint = "Subject + makes + object + complement."
          ),
          SentencePuzzleItem(
            id = "c19_p20",
            scrambledWords = listOf("Trust", "takes", "years", "build", "to", "seconds", "shatter", "to"),
            correctSentence = "Trust takes years to build seconds to shatter.",
            sinhalaMeaning = "විශ්වාසය ගොඩනැගීමට වසර ගණනාවක් ගතවන නමුත් බිඳවැටීමට ගතවන්නේ තත්පර කිහිපයකි.",
            hint = "Trust takes years to build... to shatter."
          )
        )
      ),

      // ==========================================
      // Category 20: Agriculture, Farming & Food Production (20 items)
      // ==========================================
      SentencePuzzleCategory(
        id = 20,
        titleSinhala = "කාණ්ඩය 20: කෘෂිකර්මාන්තය, ගොවිතැන සහ ආහාර නිෂ්පාදනය",
        titleEnglish = "Agriculture, Farming & Food Production",
        icon = "🌾",
        description = "වී ගොවිතැන, ගොවීන්ගේ මහන්සිය, වාරිමාර්ග සහ ආහාර සුරක්ෂිතතාව පිළිබඳ වාක්‍ය 20ක්.",
        puzzles = listOf(
          SentencePuzzleItem(
            id = "c20_p1",
            scrambledWords = listOf("backbone", "Agriculture", "is", "economy", "Sri", "Lankan", "of", "the"),
            correctSentence = "Agriculture is the backbone of Sri Lankan economy.",
            sinhalaMeaning = "කෘෂිකර්මාන්තය ශ්‍රී ලංකා ආර්ථිකයේ කොඳු නාරටියයි.",
            hint = "Subject + is the backbone of + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c20_p2",
            scrambledWords = listOf("work", "Farmers", "hard", "fields", "muddy", "in", "feed", "nation", "to"),
            correctSentence = "Farmers work hard in muddy fields to feed nation.",
            sinhalaMeaning = "ජාතිය පෝෂණය කිරීම සඳහා ගොවියෝ මඩ කුඹුරුවල වෙහෙස මහන්සි වී වැඩ කරති.",
            hint = "Subject + work hard + in fields + to feed nation."
          ),
          SentencePuzzleItem(
            id = "c20_p3",
            scrambledWords = listOf("irrigation", "Ancient", "tanks", "store", "rainwater", "cultivation", "for"),
            correctSentence = "Ancient irrigation tanks store rainwater for cultivation.",
            sinhalaMeaning = "පැරණි වාරි වැව් වගාව සඳහා වැසි ජලය ගබඩා කරයි.",
            hint = "Subject phrase + store + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c20_p4",
            scrambledWords = listOf("staple", "Rice", "food", "is", "our", "island", "in"),
            correctSentence = "Rice is our staple food in island.",
            sinhalaMeaning = "අපගේ දූපතේ ප්‍රධාන ආහාරය වන්නේ බත් ය.",
            hint = "Subject + is + possessive phrase + location."
          ),
          SentencePuzzleItem(
            id = "c20_p5",
            scrambledWords = listOf("fertilizers", "Organic", "soil", "improve", "fertility", "naturally"),
            correctSentence = "Organic fertilizers improve soil fertility naturally.",
            sinhalaMeaning = "කාබනික පොහොර පසේ සාරවත් බව ස්වභාවිකව වැඩිදියුණු කරයි.",
            hint = "Subject + improve + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c20_p6",
            scrambledWords = listOf("harvest", "bring", "Farmers", "paddy", "during", "season", "joyful"),
            correctSentence = "Farmers harvest paddy during joyful season.",
            sinhalaMeaning = "ගොවීන් ප්‍රීතිමත් අස්වනු කාලයේදී වී අස්වනු නෙළති.",
            hint = "Subject + verb + object + time phrase."
          ),
          SentencePuzzleItem(
            id = "c20_p7",
            scrambledWords = listOf("Chena", "cultivation", "traditional", "farming", "method", "a", "is"),
            correctSentence = "Chena cultivation is a traditional farming method.",
            sinhalaMeaning = "හේන් ගොවිතැන සාම්ප්‍රදායික ගොවිතැන් ක්‍රමයකි.",
            hint = "Subject + is + article + adjective + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c20_p8",
            scrambledWords = listOf("Spices", "Cinnamon", "like", "foreign", "bring", "exchange", "valuable"),
            correctSentence = "Spices like Cinnamon bring valuable foreign exchange.",
            sinhalaMeaning = "කුරුඳු වැනි කුළුබඩු වටිනා විදේශ විනිමය ගෙන එයි.",
            hint = "Subject phrase + bring + adjective + noun."
          ),
          SentencePuzzleItem(
            id = "c20_p9",
            scrambledWords = listOf("king", "Parakramabahu", "built", "Parakrama", "Samudra", "great", "the"),
            correctSentence = "King Parakramabahu built the great Parakrama Samudra.",
            sinhalaMeaning = "මහා පරාක්‍රමබාහු රජතුමා මහා පරාක්‍රම සමුද්‍රය ගොඩනැගුවේය.",
            hint = "Proper subject + built + object."
          ),
          SentencePuzzleItem(
            id = "c20_p10",
            scrambledWords = listOf("drip", "Modern", "irrigation", "conserves", "water", "scarcity", "in"),
            correctSentence = "Modern drip irrigation conserves water in scarcity.",
            sinhalaMeaning = "නවීන බිංදු ජල සම්පාදන ක්‍රමය හිඟ කාලවලදී ජලය සුරකියි.",
            hint = "Subject + conserves + object + context."
          ),
          SentencePuzzleItem(
            id = "c20_p11",
            scrambledWords = listOf("Coconut", "tree", "known", "as", "is", "tree", "life", "of"),
            correctSentence = "Coconut tree is known as tree of life.",
            sinhalaMeaning = "පොල් ගස කප්රුක / ජීවන වෘක්ෂය ලෙස හැඳින්වේ.",
            hint = "Passive: Subject + is known as + noun phrase."
          ),
          SentencePuzzleItem(
            id = "c20_p12",
            scrambledWords = listOf("Tea", "plantations", "cover", "green", "hill", "slopes", "lush"),
            correctSentence = "Tea plantations cover lush green hill slopes.",
            sinhalaMeaning = "තේ වතු සශ්‍රීක හරිත කඳු බෑවුම් වසා පැතිර පවතී.",
            hint = "Subject + cover + adjective phrase + noun."
          ),
          SentencePuzzleItem(
            id = "c20_p13",
            scrambledWords = listOf("climate", "Change", "affects", "crop", "yields", "severely"),
            correctSentence = "Climate change affects crop yields severely.",
            sinhalaMeaning = "දේශගුණික විපර්යාස බෝග අස්වැන්නට දැඩි ලෙස බලපායි.",
            hint = "Subject + affects + object + adverb."
          ),
          SentencePuzzleItem(
            id = "c20_p14",
            scrambledWords = listOf("Protect", "crops", "pests", "harmful", "from", "naturally"),
            correctSentence = "Protect crops from harmful pests naturally.",
            sinhalaMeaning = "හානිකර පළිබෝධකයන්ගෙන් බෝග ස්වභාවිකව ආරක්ෂා කරගන්න.",
            hint = "Imperative + object + from pests + adverb."
          ),
          SentencePuzzleItem(
            id = "c20_p15",
            scrambledWords = listOf("Vegetables", "fresh", "are", "transported", "economic", "centres", "to"),
            correctSentence = "Fresh vegetables are transported to economic centres.",
            sinhalaMeaning = "නැවුම් එළවළු ආර්ථික මධ්‍යස්ථාන වෙත ප්‍රවාහනය කරනු ලැබේ.",
            hint = "Passive: Subject + are transported to + destination."
          ),
          SentencePuzzleItem(
            id = "c20_p16",
            scrambledWords = listOf("grow", "We", "food", "must", "own", "our", "home", "at"),
            correctSentence = "We must grow our own food at home.",
            sinhalaMeaning = "අපි නිවසේදීම අපේම ආහාර වගා කරගත යුතුය.",
            hint = "We must grow + object + location."
          ),
          SentencePuzzleItem(
            id = "c20_p17",
            scrambledWords = listOf("Bees", "pollinate", "flowers", "produce", "fruits", "to", "healthy"),
            correctSentence = "Bees pollinate flowers to produce healthy fruits.",
            sinhalaMeaning = "නිරෝගී පලතුරු නිපදවීම සඳහා මීමැස්සන් මල් පරාගනය කරයි.",
            hint = "Subject + pollinate + object + purpose."
          ),
          SentencePuzzleItem(
            id = "c20_p18",
            scrambledWords = listOf("water", "Drop", "every", "of", "is", "precious", "farming", "for"),
            correctSentence = "Every drop of water is precious for farming.",
            sinhalaMeaning = "ගොවිතැන සඳහා සෑම ජල බිඳක්ම අතිශයින් වටිනාය.",
            hint = "Subject phrase + is precious for + noun."
          ),
          SentencePuzzleItem(
            id = "c20_p19",
            scrambledWords = listOf("Youth", "should", "join", "modern", "agriculture", "enterprises"),
            correctSentence = "Youth should join modern agriculture enterprises.",
            sinhalaMeaning = "තරුණ පරපුර නවීන කෘෂිකාර්මික ව්‍යවසායන් සමඟ එක්විය යුතුය.",
            hint = "Subject + should join + object phrase."
          ),
          SentencePuzzleItem(
            id = "c20_p20",
            scrambledWords = listOf("food", "Zero", "waste", "ensures", "hunger", "free", "world"),
            correctSentence = "Zero food waste ensures hunger free world.",
            sinhalaMeaning = "ආහාර නාස්තිය ශුන්‍ය කිරීම කුසගින්නෙන් තොර ලෝකයක් තහවුරු කරයි.",
            hint = "Subject phrase + ensures + object phrase."
          )
        )
      )
    )
  }
}
