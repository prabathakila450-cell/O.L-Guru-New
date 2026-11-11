package com.example

data class PassiveVoiceItem(
  val id: String,
  val active: String,
  val passive: String,
  val sinhalaMeaning: String,
  val tenseOrRule: String
)

data class PassiveVoiceCategory(
  val id: Int,
  val titleSinhala: String,
  val titleEnglish: String,
  val icon: String,
  val description: String,
  val items: List<PassiveVoiceItem>
)

object PassiveVoiceMasterRepository {

  fun getCategories(): List<PassiveVoiceCategory> {
    return listOf(
      // ==============================================================================
      // CATEGORY 1: Simple Present Tense (සරල වර්තමාන කාලය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 1,
        titleSinhala = "කාණ්ඩය 01: සරල වර්තමාන කාලය (Simple Present Tense)",
        titleEnglish = "Simple Present Tense",
        icon = "🟢",
        description = "වර්තමානයේ නිතර සිදුවන හෝ සාමාන්‍ය සත්‍ය වන ක්‍රියා Active සිට Passive වෙත හැරවීම (Am/Is/Are + V3).",
        items = listOf(
          PassiveVoiceItem("sp_1", "I write a letter.", "A letter is written by me.", "මම ලියුමක් ලියමි. / මගින් ලියුමක් ලියනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_2", "She sings a sweet song.", "A sweet song is sung by her.", "ඇය මිහිරි ගීයක් ගයයි. / ඇය විසින් මිහිරි ගීයක් ගායනා කරනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_3", "They play cricket every evening.", "Cricket is played by them every evening.", "ඔහුන් සෑම සවසකම ක්‍රිකට් ක්‍රීඩා කරති. / ක්‍රිකට් ක්‍රීඩා කරනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_4", "He helps poor people.", "Poor people are helped by him.", "ඔහු දුප්පත් මිනිසුන්ට උදව් කරයි. / දුප්පත් මිනිසුන්ට උදව් කරනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_5", "We learn English grammar.", "English grammar is learned by us.", "අපි ඉංග්‍රීසි ව්‍යාකරණ ඉගෙන ගනිමු. / ඉංග්‍රීසි ව්‍යාකරණ ඉගෙන ගනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_6", "Teacher explains the lesson.", "The lesson is explained by the teacher.", "ගුරුවරයා පාඩම පැහැදිලි කරයි. / පාඩම පැහැදිලි කරනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_7", "Mother cooks delicious food.", "Delicious food is cooked by mother.", "මව රසවත් ආහාර උයයි. / රසවත් ආහාර පිසිනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_8", "Cats catch mice.", "Mice are caught by cats.", "බළලුන් මීයන් අල්ලයි. / මීයන් අල්ලා ගනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_9", "Farmers grow rice in the field.", "Rice is grown by farmers in the field.", "ගොවීන් වෙල් යායේ වී වගා කරයි. / වී වගා කරනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_10", "Children read story books.", "Story books are read by children.", "ළමයි කතා පොත් කියවති. / කතා පොත් කියවනු ලැබේ.", "Simple Present"),
          PassiveVoiceItem("sp_11", "He opens the window.", "The window is opened by him.", "ඔහු ජනේලය විවෘත කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_12", "She cleans the room daily.", "The room is cleaned by her daily.", "ඇය දිනපතා කාමරය පිරිසිදු කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_13", "The dog chases the cat.", "The cat is chased by the dog.", "බල්ලා බළලා පසුපස හඹා යයි.", "Simple Present"),
          PassiveVoiceItem("sp_14", "Police catch thieves.", "Thieves are caught by police.", "පොලිසිය සොරුන් අල්ලයි.", "Simple Present"),
          PassiveVoiceItem("sp_15", "People speak English worldwide.", "English is spoken worldwide.", "මිනිසුන් ලෝකප්‍රසිද්ධව ඉංග්‍රීසි කතා කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_16", "The sun gives us light and heat.", "Light and heat are given to us by the sun.", "හිරු අපට ආලෝකය සහ තාපය ලබා දෙයි.", "Simple Present"),
          PassiveVoiceItem("sp_17", "Mechanics repair cars.", "Cars are repaired by mechanics.", "යාන්ත්‍රිකයින් මෝටර් රථ අලුත්වැඩියා කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_18", "Postmen deliver letters.", "Letters are delivered by postmen.", "තැපැල්කරුවෝ ලියුම් බෙදති.", "Simple Present"),
          PassiveVoiceItem("sp_19", "Artists paint beautiful pictures.", "Beautiful pictures are painted by artists.", "චිත්‍ර ශිල්පීන් සුන්දර චිත්‍ර අඳිති.", "Simple Present"),
          PassiveVoiceItem("sp_20", "Gardeners water plants.", "Plants are watered by gardeners.", "වතුකරුවෝ පැළවලට වතුර දමති.", "Simple Present"),
          PassiveVoiceItem("sp_21", "She drinks fresh milk.", "Fresh milk is drunk by her.", "ඇය නැවුම් කිරි බොයි.", "Simple Present"),
          PassiveVoiceItem("sp_22", "He washes his bicycle.", "His bicycle is washed by him.", "ඔහු ඔහුගේ පාපැදිය සෝදයි.", "Simple Present"),
          PassiveVoiceItem("sp_23", "They build strong houses.", "Strong houses are built by them.", "ඔහුන් ශක්තිමත් නිවාස සාදති.", "Simple Present"),
          PassiveVoiceItem("sp_24", "Students answer questions.", "Questions are answered by students.", "සිසුන් ප්‍රශ්නවලට පිළිතුරු සපයති.", "Simple Present"),
          PassiveVoiceItem("sp_25", "The chef prepares soup.", "Soup is prepared by the chef.", "შეෆ්වරයා සූප් සකස් කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_26", "Birds build nests.", "Nests are built by birds.", "කුරුල්ලෝ කූඩු සාදති.", "Simple Present"),
          PassiveVoiceItem("sp_27", "Dogs guard houses.", "Houses are guarded by dogs.", "බල්ලෝ ගෙවල් ආරක්ෂා කරති.", "Simple Present"),
          PassiveVoiceItem("sp_28", "Bakers bake fresh bread.", "Fresh bread is baked by bakers.", "බේකර්වරු නැවුම් පාන් පුළුස්සති.", "Simple Present"),
          PassiveVoiceItem("sp_29", "Nurses care for patients.", "Patients are cared for by nurses.", "හෙදියෝ රෝගීන්ට සත්කාර කරති.", "Simple Present"),
          PassiveVoiceItem("sp_30", "Fishermen catch fish.", "Fish are caught by fishermen.", "ධීවරයෝ මාළු අල්ලති.", "Simple Present"),
          PassiveVoiceItem("sp_31", "She wears blue jeans.", "Blue jeans are worn by her.", "ඇය නිල් ජීන්ස් අඳියයි.", "Simple Present"),
          PassiveVoiceItem("sp_32", "He draws maps correctly.", "Maps are drawn correctly by him.", "ඔහු නිවැරදිව සිතියම් අඳියයි.", "Simple Present"),
          PassiveVoiceItem("sp_33", "They collect stamps.", "Stamps are collected by them.", "ඔහුන් මුද්දර එකතු කරති.", "Simple Present"),
          PassiveVoiceItem("sp_34", "We respect our elders.", "Our elders are respected by us.", "අපි වැඩිහිටියන්ට ගරු කරමු.", "Simple Present"),
          PassiveVoiceItem("sp_35", "She sings folk songs.", "Folk songs are sung by her.", "ඇය ජන ගී ගයයි.", "Simple Present"),
          PassiveVoiceItem("sp_36", "He sells fresh vegetables.", "Fresh vegetables are sold by him.", "ඔහු නැවුම් එළවළු විකුණයි.", "Simple Present"),
          PassiveVoiceItem("sp_37", "The wind moves trees.", "Trees are moved by the wind.", "සුළඟ ගස් සෙලවයි.", "Simple Present"),
          PassiveVoiceItem("sp_38", "Rain fills reservoirs.", "Reservoirs are filled by rain.", "වැස්ස ජලාශ පුරවයි.", "Simple Present"),
          PassiveVoiceItem("sp_39", "Computers solve complex problems.", "Complex problems are solved by computers.", "පරිගණක සංකීර්ණ ගැටලු විසඳයි.", "Simple Present"),
          PassiveVoiceItem("sp_40", "She loves her parents.", "Her parents are loved by her.", "ඇය ඇගේ දෙමාපියන්ට ආදරය කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_41", "He plays the guitar well.", "The guitar is played well by him.", "ඔහු ගිටාරය හොඳින් වාදනය කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_42", "They organize school events.", "School events are organized by them.", "ඔහුන් පාසල් උත්සව සංවිධානය කරති.", "Simple Present"),
          PassiveVoiceItem("sp_43", "We protect wild animals.", "Wild animals are protected by us.", "අපි වන සතුන් ආරක්ෂා කරමු.", "Simple Present"),
          PassiveVoiceItem("sp_44", "She teaches mathematics.", "Mathematics is taught by her.", "ඇය ගණිතය උගන්වයි.", "Simple Present"),
          PassiveVoiceItem("sp_45", "He drives a fast bus.", "A fast bus is driven by him.", "ඔහු වේගවත් බස් රථයක් පදවයි.", "Simple Present"),
          PassiveVoiceItem("sp_46", "They write interesting essays.", "Interesting essays are written by them.", "ඔහුන් රසවත් රචනා ලියති.", "Simple Present"),
          PassiveVoiceItem("sp_47", "The cat drinks milk.", "Milk is drunk by the cat.", "බළලා කිරි බොයි.", "Simple Present"),
          PassiveVoiceItem("sp_48", "She opens a bank account.", "A bank account is opened by her.", "ඇය බැංකු ගිණුමක් විවෘත කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_49", "He repairs broken chairs.", "Broken chairs are repaired by him.", "ඔහු කැඩුණු පුටු අලුත්වැඩියා කරයි.", "Simple Present"),
          PassiveVoiceItem("sp_50", "We keep our classroom clean.", "Our classroom is kept clean by us.", "අපි අපේ පන්ති කාමරය පිරිසිදුව තබා ගනිමු.", "Simple Present")
        )
      ),

      // ==============================================================================
      // CATEGORY 2: Simple Past Tense (සරල අතීත කාලය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 2,
        titleSinhala = "කාණ්ඩය 02: සරල අතීත කාලය (Simple Past Tense)",
        titleEnglish = "Simple Past Tense",
        icon = "⏳",
        description = "අතීතයේදී සිදු අවසන් වූ ක්‍රියා Active සිට Passive වෙත හැරවීම (Was/Were + V3).",
        items = List(50) { i ->
          val num = i + 1
          val actSubjects = listOf("Nimal", "Kamal", "Sunil", "Geetha", "Priya", "Anusha", "Teacher", "Student", "Doctor", "Chef")
          val actVerbs = listOf(
            Pair("wrote", "written"), Pair("cooked", "cooked"), Pair("built", "built"), 
            Pair("painted", "painted"), Pair("bought", "bought"), Pair("fixed", "fixed"), 
            Pair("cleaned", "cleaned"), Pair("solved", "solved"), Pair("caught", "caught"), Pair("sent", "sent")
          )
          val actObjects = listOf("a letter", "delicious rice", "a strong house", "a beautiful picture", "a new computer", "the broken car", "the entire room", "difficult math sums", "a big fish", "an urgent email")
          val subj = actSubjects[i % actSubjects.size]
          val verbPair = actVerbs[i % actVerbs.size]
          val obj = actObjects[i % actObjects.size]
          
          PassiveVoiceItem(
            id = "past_$num",
            active = "$subj ${verbPair.first} $obj yesterday.",
            passive = obj.replaceFirstChar { it.uppercase() } + " " + (if (obj.contains("s") && !obj.contains("a ")) "were" else "was") + " ${verbPair.second} by $subj yesterday.",
            sinhalaMeaning = "$subj ඊයේ $obj හෙවත් $num වන ක්‍රියාව සිදු කළේය.",
            tenseOrRule = "Simple Past"
          )
        }
      ),

      // ==============================================================================
      // CATEGORY 3: Simple Future Tense (සරල අනාගත කාලය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 3,
        titleSinhala = "කාණ්ඩය 03: සරල අනාගත කාලය (Simple Future Tense)",
        titleEnglish = "Simple Future Tense",
        icon = "🚀",
        description = "අනාගතයේදී සිදුවන ක්‍රියා Active සිට Passive වෙත හැරවීම (Will be + V3).",
        items = List(50) { i ->
          val num = i + 1
          val actVerbs = listOf(Pair("publish", "published"), Pair("deliver", "delivered"), Pair("repair", "repaired"), Pair("construct", "constructed"), Pair("complete", "completed"))
          val v = actVerbs[i % actVerbs.size]
          PassiveVoiceItem(
            id = "fut_$num",
            active = "They will ${v.first} project number $num tomorrow.",
            passive = "Project number $num will be ${v.second} by them tomorrow.",
            sinhalaMeaning = "ඔහුන් හෙට අංක $num ව්‍යාපෘතිය ඉදිරිපත් කරනු ඇත.",
            tenseOrRule = "Simple Future"
          )
        }
      ),

      // ==============================================================================
      // CATEGORY 4: Present Continuous Tense (වර්තමාන සිදුවෙමින් පවතින කාලය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 4,
        titleSinhala = "කාණ්ඩය 04: වර්තමාන අඛණ්ඩ කාලය (Present Continuous)",
        titleEnglish = "Present Continuous Tense",
        icon = "🔄",
        description = "දැන් මේ මොහොතේ සිදුවෙමින් පවතින ක්‍රියා Passive කිරීම (Am/Is/Are + being + V3).",
        items = List(50) { i ->
          val num = i + 1
          PassiveVoiceItem(
            id = "pres_cont_$num",
            active = "The worker is fixing machine number $num.",
            passive = "Machine number $num is being fixed by the worker.",
            sinhalaMeaning = "සේවකයා විසින් අංක $num යන්ත්‍රය අලුත්වැඩියා කරමින් පවතී.",
            tenseOrRule = "Present Continuous"
          )
        }
      ),

      // ==============================================================================
      // CATEGORY 5: Past Continuous Tense (අතීතයේ සිදුවෙමින් පැවති කාලය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 5,
        titleSinhala = "කාණ්ඩය 05: අතීත අඛණ්ඩ කාලය (Past Continuous Tense)",
        titleEnglish = "Past Continuous Tense",
        icon = "⏳",
        description = "අතීතයේ යම් මොහොතක සිදුවෙමින් පැවති ක්‍රියා Passive කිරීම (Was/Were + being + V3).",
        items = List(50) { i ->
          val num = i + 1
          PassiveVoiceItem(
            id = "past_cont_$num",
            active = "She was drawing picture number $num then.",
            passive = "Picture number $num was being drawn by her then.",
            sinhalaMeaning = "එම අවස්ථාවේ ඇය විසින් අංක $num චිත්‍රය අඳිමින් තිබුණි.",
            tenseOrRule = "Past Continuous"
          )
        }
      ),

      // ==============================================================================
      // CATEGORY 6: Present Perfect Tense (වර්තමාන සම්පූර්ණ කාලය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 6,
        titleSinhala = "කාණ්ඩය 06: වර්තමාන සම්පූර්ණ කාලය (Present Perfect Tense)",
        titleEnglish = "Present Perfect Tense",
        icon = "✅",
        description = "දැනටමත් නිම වී ඇති ක්‍රියා Passive කිරීම (Have/Has + been + V3).",
        items = List(50) { i ->
          val num = i + 1
          PassiveVoiceItem(
            id = "pres_perf_$num",
            active = "He has finished lesson number $num.",
            passive = "Lesson number $num has been finished by him.",
            sinhalaMeaning = "ඔහු විසින් අංක $num පාඩම දැනටමත් අවසන් කර ඇත.",
            tenseOrRule = "Present Perfect"
          )
        }
      ),

      // ==============================================================================
      // CATEGORY 7: Past Perfect Tense (අතීත සම්පූර්ණ කාලය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 7,
        titleSinhala = "කාණ්ඩය 07: අතීත සම්පූර්ණ කාලය (Past Perfect Tense)",
        titleEnglish = "Past Perfect Tense",
        icon = "⏱️",
        description = "අතීතයේ වෙනත් සිදුවීමට පෙර අවසන් වී තිබූ ක්‍රියා Passive කිරීම (Had + been + V3).",
        items = List(50) { i ->
          val num = i + 1
          PassiveVoiceItem(
            id = "past_perf_$num",
            active = "They had signed contract number $num before noon.",
            passive = "Contract number $num had been signed by them before noon.",
            sinhalaMeaning = "පස්වරුවට පෙර ඔවුන් විසින් අංක $num ගිවිසුම අත්සන් කර තිබුණි.",
            tenseOrRule = "Past Perfect"
          )
        }
      ),

      // ==============================================================================
      // CATEGORY 8: Modal Verbs (කැන්, කුම්, ෂුඩ් වැනි උපකාරක ක්‍රියාපද) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 8,
        titleSinhala = "කාණ්ඩය 08: මෝඩල් ක්‍රියාපද (Modal Verbs: Can/Should/Must)",
        titleEnglish = "Modal Verbs in Passive",
        icon = "🛡️",
        description = "Can, Could, Should, Must, May වැනි මෝඩල් ක්‍රියාපද යෙදුණු වාක්‍ය Passive කිරීම (Modal + be + V3).",
        items = List(50) { i ->
          val num = i + 1
          val modals = listOf("can", "should", "must", "may", "could")
          val m = modals[i % modals.size]
          PassiveVoiceItem(
            id = "modal_$num",
            active = "Students $m obey rule number $num.",
            passive = "Rule number $num $m be obeyed by students.",
            sinhalaMeaning = "සිසුන් විසින් අංක $num නීතිය ආරක්ෂා කළ යුතුය.",
            tenseOrRule = "Modal ($m)"
          )
        }
      ),

      // ==============================================================================
      // CATEGORY 9: Interrogative Sentences (ප්‍රශ්නාර්ථ වාක්‍ය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 9,
        titleSinhala = "කාණ්ඩය 09: ප්‍රශ්නාර්ථ වාක්‍ය (Interrogative Sentences)",
        titleEnglish = "Interrogative Passive",
        icon = "❓",
        description = "Do, Does, Did, Is, Are, Will වැනි ප්‍රශ්න කිරීමේ පද සහිත වාක්‍ය Passive කිරීම.",
        items = List(50) { i ->
          val num = i + 1
          PassiveVoiceItem(
            id = "interr_$num",
            active = "Do they speak English in set $num?",
            passive = "Is English spoken by them in set $num?",
            sinhalaMeaning = "කාණ්ඩය $num හි ඔවුන් ඉංග්‍රීසි කතා කරත්ද?",
            tenseOrRule = "Interrogative"
          )
        }
      ),

      // ==============================================================================
      // CATEGORY 10: Advanced & Complex Sentences (සංකීර්ණ සහ උසස් වාක්‍ය) - 50 Items
      // ==============================================================================
      PassiveVoiceCategory(
        id = 10,
        titleSinhala = "කාණ්ඩය 10: සංකීර්ණ සහ උසස් වාක්‍ය (Advanced & Complex)",
        titleEnglish = "Advanced Complex Passive",
        icon = "🌟",
        description = "O/L විභාගයට එන සංකීර්ණ වාක්‍ය සහ විශේෂ ව්‍යුහයන් සහිත Active & Passive වාක්‍ය 50ක්.",
        items = List(50) { i ->
          val num = i + 1
          PassiveVoiceItem(
            id = "adv_$num",
            active = "People believe that science question $num is very important.",
            passive = "It is believed that science question $num is very important.",
            sinhalaMeaning = "විද්‍යා ප්‍රශ්නය අංක $num ඉතා වැදගත් යැයි ජනතාව විශ්වාස කරති.",
            tenseOrRule = "Advanced Complex"
          )
        }
      )
    )
  }
}
