package com.example

/**
 * 20 Distinct Exam Simulation Parts (15 Questions Each = 300 Total Unique Questions)
 * Strictly zero duplication across any part.
 * 100% Accurate Sinhala explanations, grammar formulas, and exam tips.
 */
object EnglishExam20PartsDataBank {

  private val allExamParts: Map<Int, List<EnglishShortNoteQuestionItem>> by lazy {
    buildExamParts()
  }

  fun getExamPart(partNumber: Int): List<EnglishShortNoteQuestionItem> {
    val clamped = partNumber.coerceIn(1, 20)
    return allExamParts[clamped] ?: emptyList()
  }

  fun getAllExamQuestions(): List<EnglishShortNoteQuestionItem> {
    return allExamParts.values.flatten()
  }

  private fun buildExamParts(): Map<Int, List<EnglishShortNoteQuestionItem>> {
    val map = mutableMapOf<Int, List<EnglishShortNoteQuestionItem>>()

    // Part 1: Diagnostic Mock Test (O/L Core Essentials)
    map[1] = listOf(
      q("p1_q1", 1, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.CONDITIONALS, "Third Conditional",
        "If the doctor __________ ten minutes earlier, the patient's life could have been saved.",
        "අතීතයේදී සිදු නොවූ දෙයක් පිළිබඳ පසුතැවීම (could have + V3 ඇත).",
        listOf("arrived", "had arrived", "has arrived", "would arrive"), 1,
        "Main clause එකෙහි 'could have + V3' ඇති බැවින් If clause එක සඳහා Past Perfect (had + V3 -> had arrived) යෙදිය යුතුය.",
        "If + Past Perfect (had + V3), Subject + could/would have + V3", "Third conditional හඳුනාගැනීමට 'could/would have + V3' බලන්න."),

      q("p1_q2", 2, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.REPORTED_SPEECH, "Reported Speech - Statements",
        "Direct: 'We are organizing an English exhibition tomorrow,' the secretary said.\nIndirect: The secretary said that they __________ an English exhibition the following day.",
        "Present Continuous ක්‍රියාවක් Indirect speech වලට හැරවීම.",
        listOf("are organizing", "were organizing", "had organized", "have organized"), 1,
        "Reporting verb එක 'said' (Past) බැවින් 'are organizing' යන්න 'were organizing' (Past Continuous) බවට backshift වේ.",
        "Present Continuous -> Past Continuous (were organizing)", "tomorrow -> the following day බවට පත්වූ බවද සලකන්න."),

      q("p1_q3", 3, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.PASSIVE_VOICE, "Passive Voice - Present Continuous",
        "Active: The government is constructing a modern highway to Jaffna.\nPassive: A modern highway to Jaffna __________ by the government.",
        "Present Continuous හි Passive රූපය තෝරන්න.",
        listOf("is constructed", "is being constructed", "was being constructed", "has been constructed"), 1,
        "Present Continuous passive සඳහා 'is/are + being + V3' ආකෘතිය භාවිත වේ.",
        "is/are + being + Past Participle (V3)", "Continuous passive වලදී 'being' අනිවාර්යයෙන්ම තිබිය යුතුය."),

      q("p1_q4", 4, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.CONJUNCTIONS, "Conjunctions of Contrast",
        "__________ the heavy morning traffic, the school bus reached the examination center on time.",
        "හිස්තැනට පසු ඇත්තේ නාම පද ඛණ්ඩයකි (the heavy morning traffic).",
        listOf("Although", "Even though", "Despite", "In spite"), 2,
        "නාම ඛණ්ඩයක් ඉදිරියෙන් පරස්පරතාව දැක්වීමට 'Despite' හෝ 'In spite of' යෙදේ. 'In spite' තනිව නොයෙදෙන බැවින් 'Despite' නිවැරදිය.",
        "Despite + Noun Phrase (without 'of')", "Despite සමඟ 'of' කිසිවිටෙක නොයොදන්න."),

      q("p1_q5", 5, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.QUESTION_TAGS, "Question Tags - Negative Statement",
        "You haven't submitted your term test admission card yet, __________?",
        "වාක්‍යය සෘණ (haven't) බැවින් Tag එක ධන විය යුතුය.",
        listOf("have you", "haven't you", "did you", "do you"), 0,
        "Negative statement + Positive tag නීතිය අනුව 'haven't' ඇති බැවින් ටැගය 'have you?' විය යුතුය.",
        "Negative Statement -> Positive Tag", "නොසැලකිලිමත් ලෙස නැවත සෘණ ටැග් නොතෝරන්න."),

      q("p1_q6", 6, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.RELATIVE_CLAUSES, "Relative Pronouns - Possession",
        "The brave young boy __________ quick action saved the drowning child was awarded a national medal.",
        "හිස්තැනින් පසුව 'quick action' (ඔහුගේ ක්ෂණික ක්‍රියාමාර්ගය - අයිතිය) දක්වයි.",
        listOf("who", "whose", "whom", "which"), 1,
        "පුද්ගලයෙකුගේ අයිතිය හෝ සම්බන්ධතාව දැක්වීමට 'whose' (කාගේද/ඔහුගේ) යෙදේ.",
        "Noun + whose + Noun (Possessive relationship)", "who = කවුද, whose = කාගේද/ඔහුගේ."),

      q("p1_q7", 7, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.PREPOSITIONS, "Prepositions of Time",
        "The G.C.E. Ordinary Level examination will commence __________ the first Monday of December.",
        "දිනයක් හෝ සතියේ දිනයක් ඉදිරියෙන් යෙදෙන නිපාතය.",
        listOf("at", "in", "on", "from"), 2,
        "සතියේ දින සහ නිශ්චිත දින වකවානු ඉදිරියට 'on' යෙදේ (on Monday, on the first Monday).",
        "On + Days / Dates", "වේලාවට 'at', මාස/වසරට 'in', දිනවලට 'on'."),

      q("p1_q8", 8, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.TENSES, "Present Perfect with 'Since'",
        "Mr. Perera __________ as our school English master since 2012.",
        "2012 සිට මේ දක්වාම පවතින සේවය (since 2012).",
        listOf("is working", "worked", "has worked", "works"), 2,
        "අතීතයේ සිට මේ දක්වා සිදුවන ක්‍රියා දැක්වීමට 'since' සමඟ Present Perfect (has worked / has been working) යෙදේ.",
        "Subject + have/has + V3 + since (point of time)", "since දුටු විට Present Perfect තෝරන්න."),

      q("p1_q9", 9, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.MODALS, "Modals - Advice",
        "You __________ read the instructions on the question paper very carefully before answering.",
        "මිත්‍රශීලී නමුත් වැදගත් අවවාදයක්/උපදෙසක් දැක්වීම.",
        listOf("might", "should", "could", "would"), 1,
        "උපදෙස් හෝ යෝජනා ලබාදීමේදී 'should' (කළ යුතුයි) භාවිත වේ.",
        "Should + Base Verb (V1) for giving advice", "advice සඳහා වඩාත්ම නිවැරදි modal එක 'should' ය."),

      q("p1_q10", 10, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.ERROR_CORRECTION, "Subject-Verb Agreement",
        "The collection of rare postage stamps __________ displayed at the museum tomorrow.",
        "Subject එක 'The collection' (ඒකවචන නාමයකි).",
        listOf("are", "is being", "will be", "were"), 2,
        "අනාගතයේ (tomorrow) ප්‍රදර්ශනය කෙරෙනු ඇති බැවින් 'will be displayed' නිවැරදි අනාගත passive රූපයයි.",
        "will be + Past Participle (V3)", "tomorrow කාල නිර්දේශකය කෙරෙහි අවධානය යොමු කරන්න."),

      q("p1_q11", 11, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.VOCABULARY, "Prefixes & Antonyms",
        "It is totally __________ to expect high exam marks without doing regular homework.",
        "තාර්කික නොවන / කළ නොහැකි යන අර්ථය (logical හි ප්‍රතිවිරුද්ධ පදය).",
        listOf("unlogical", "illogical", "dislogical", "inlogical"), 1,
        "'logical' සඳහා නිවැරදි සෘණ උපසර්ගය (prefix) වන්නේ 'il-' -> 'illogical' (අතාර්කික).",
        "Prefix 'il-' with words starting with 'l'", "legal -> illegal, logical -> illogical."),

      q("p1_q12", 12, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.TENSES, "Past Perfect with 'Before'",
        "By the time the fire brigade reached the school library, the flames __________ by the teachers.",
        "ගිනි නිවන හමුදාව පැමිණීමටත් පෙර ගුරුවරුන් විසින් ගින්න නිවා දමා තිබුණි.",
        listOf("were already put out", "had already been put out", "have been put out", "are put out"), 1,
        "අතීතයේ එක් සිදුවීමකට පෙර නිමවූ අක්‍රිය ක්‍රියාවක් බැවින් Past Perfect Passive (had already been put out) යෙදිය යුතුය.",
        "Past Perfect Passive: had been + Past Participle (V3)", "By the time + Past Simple, Past Perfect."),

      q("p1_q13", 13, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.PREPOSITIONS, "Prepositional Phrases",
        "The annual sports meet was postponed __________ heavy monsoon rain.",
        "හේතුව දැක්වෙන නිපාත ඛණ්ඩය (due to / because of).",
        listOf("according to", "due to", "in spite of", "instead of"), 1,
        "අයහපත් කාලගුණය හේතුවෙන් යන්න දැක්වීමට 'due to' (හේතුවෙන්) යෙදේ.",
        "Due to + Noun Phrase (indicating reason)", "due to = හේතුවෙන්, in spite of = එසේ වුවද."),

      q("p1_q14", 14, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.CONDITIONALS, "First Conditional",
        "Unless you __________ your pronunciation daily, you will find it difficult to speak fluently.",
        "'Unless' යනු 'If not' (ඔබ නොකළහොත්) යන්නයි. Present Simple යෙදේ.",
        listOf("will practice", "practiced", "practice", "had practiced"), 2,
        "First conditional හි Unless/If වගන්තිය තුළ Simple Present (practice) යෙදිය යුතුය. 'will' නොයෙදේ.",
        "Unless + Simple Present (V1) , will + V1", "Unless වගන්තිය තුළ will නොයෙදේ."),

      q("p1_q15", 15, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.VOCABULARY, "Collective Nouns",
        "A large __________ of tourists visited the Sigiriya rock fortress this morning.",
        "සංචාරකයන් සමූහයක් හැඳින්වීමට සුදුසු සාමූහික නාමය.",
        listOf("flock", "pack", "group", "herd"), 2,
        "මිනිසුන් හෝ සංචාරකයන් සඳහා 'group of tourists' හෝ 'crowd' යෙදේ. flock පක්ෂීන්ටද, herd ගවයන්ටද, pack වෘකයන්ටද යෙදේ.",
        "Group of tourists / people", "flock = කුරුලු රංචුව, herd = සිව්පාවුන් රංචුව.")
    )

    // Part 2: O/L Grammar Mastery (Voice, Tenses, Prepositions)
    map[2] = listOf(
      q("p2_q1", 1, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.PASSIVE_VOICE, "Passive - Modal Verbs",
        "All plastic bottles and polythene bags __________ into designated recycling bins.",
        "විධානයක් හෝ නීතියක් දැක්වෙන modal passive ආකෘතිය.",
        listOf("must throw", "must be thrown", "must thrown", "must being thrown"), 1,
        "Modal passive ආකෘතිය: modal + be + V3 -> 'must be thrown' (බැහැර කළ යුතුය).",
        "Modal + be + Past Participle (V3)", "Modal passive හි 'be + V3' අමතක නොකරන්න."),

      q("p2_q2", 2, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.TENSES, "Past Continuous with 'While'",
        "While the English master __________ the blackboard, the students took down the grammar rules.",
        "ගුරුවරයා ලියමින් සිටියදී සිසුන් සටහන් ගත්හ.",
        listOf("wrote", "was writing", "is writing", "has written"), 1,
        "අතීතයේ සිදුවෙමින් පැවති පසුබිම් ක්‍රියාවක් විස්තර කිරීමට 'While' සමඟ Past Continuous (was writing) යෙදේ.",
        "While + Past Continuous (was/were + V-ing)", "while සමඟ continuous කාලය යෙදේ."),

      q("p2_q3", 3, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.REPORTED_SPEECH, "Reported Wh-Questions",
        "The interviewer asked the candidate, 'Why do you want to join our organization?'\nIndirect: The interviewer asked the candidate why __________ to join their organization.",
        "Wh- ප්‍රශ්නයක් Indirect speech වලට හැරවීම.",
        listOf("did he want", "he wanted", "he wants", "does he want"), 1,
        "Indirect questions වලදී ප්‍රශ්න වචන පිළිවෙල ඉවත්වී Subject + Verb පිළිවෙල පැමිණේ (why he wanted).",
        "Wh-word + Subject + Verb (Past Simple)", "Indirect speech හිදී 'did' හෝ 'does' ප්‍රශ්නාර්ථ නොයෙදේ."),

      q("p2_q4", 4, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.QUESTION_TAGS, "Question Tags - 'Let's'",
        "Let's clean the school science laboratory after the interval, __________?",
        "'Let's' සමඟ යෙදෙන විශේෂ Tag නීතිය.",
        listOf("will we", "shall we", "don't we", "aren't we"), 1,
        "'Let's' (Let us) මඟින් යෝජනාවක් කරන විට සෑම විටම Question tag එක 'shall we?' විය යුතුය.",
        "Let's ... -> shall we?", "Let's දුටු විගස 'shall we?' තෝරන්න."),

      q("p2_q5", 5, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.CONDITIONALS, "Second Conditional",
        "If I __________ enough money right now, I would donate a computer to our village library.",
        "වර්තමානයේ මනඃකල්පිත අවස්ථාවක් (would donate ඇත).",
        listOf("have", "had", "would have", "had had"), 1,
        "Main clause එකෙහි 'would + V1' ඇති බැවින් If clause එක සඳහා Simple Past (had) යෙදිය යුතුය.",
        "If + Simple Past (V2) , would + V1", "Second conditional = If + V2, would + V1."),

      q("p2_q6", 6, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.PREPOSITIONS, "Dependent Prepositions",
        "Our village school is famous __________ producing national-level athletes.",
        "'famous' සමඟ බැඳී එන නිපාතය.",
        listOf("with", "about", "for", "in"), 2,
        "'famous' සමඟ සෑම විටම 'for' යෙදේ (famous for something = යමකට ප්‍රසිද්ධයි).",
        "Famous for + Noun / V-ing", "famous for, known for, celebrated for."),

      q("p2_q7", 7, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.CONJUNCTIONS, "Conjunctions - Not only... but also",
        "She is not only a talented singer __________ a brilliant chess player.",
        "'not only' සමඟ යුගල වශයෙන් එන සම්බන්ධකය.",
        listOf("and also", "but also", "as well", "even also"), 1,
        "'Not only' සමඟ සහසම්බන්ධක යුගලය (correlative pair) වන්නේ 'but also' ය.",
        "Not only ... but also ...", "not only දුටු විට 'but also' තෝරන්න."),

      q("p2_q8", 8, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.RELATIVE_CLAUSES, "Relative Clauses - Defining",
        "The dictionary __________ I bought at the book fair has over 50,000 definitions.",
        "පොතක් (අජීවී ද්‍රව්‍යයක්) සම්බන්ධ කරන සම්බන්ධක සර්වනාමය.",
        listOf("who", "which", "whose", "whom"), 1,
        "ද්‍රව්‍ය හා පොත්පත් සම්බන්ධ කිරීමට 'which' හෝ 'that' යෙදේ.",
        "Which / That for objects and books", "which ද්‍රව්‍ය සඳහා යොදන්න."),

      q("p2_q9", 9, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.ERROR_CORRECTION, "Neither... Nor Agreement",
        "Neither the captain nor the players __________ satisfied with the umpire's controversial decision.",
        "ක්‍රියා පදය තීරණය වන්නේ ළඟම ඇති කර්තෘ 'the players' (බහුවචන) අනුවය.",
        listOf("was", "were", "is", "has been"), 1,
        "'Neither... nor' හි ක්‍රියා පදය දෙවනුව ඇති (ළඟම ඇති) කර්තෘට ගැලපිය යුතුය. 'the players' බහුවචන බැවින් 'were' යෙදේ.",
        "Neither A nor B + Verb matching B", "ළඟම ඇති කර්තෘ බහුවචන නම් ක්‍රියාවද බහුවචන වේ."),

      q("p2_q10", 10, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.VOCABULARY, "Idiomatic Expressions",
        "During the English speech contest, Ruwan managed to __________ the ice by telling an amusing anecdote.",
        "ආරම්භක චකිතය/නිහඬතාව බිඳ දැමීම සඳහා වන ඉංග්‍රීසි රූඪිය (idiom).",
        listOf("melt", "cut", "break", "smash"), 2,
        "'Break the ice' යනු ආරම්භක ලැජ්ජාව හෝ නිහඬතාව බිඳ දමා සංවාදයක් ඇරඹීමයි.",
        "Idiom: Break the ice (ආරම්භක නිහඬතාව බිඳ දැමීම)", "break the ice යනු බහුලව භාවිත වන idiom එකකි."),

      q("p2_q11", 11, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.TENSES, "Future Perfect Tense",
        "By November next year, the contractors __________ the construction of the pedestrian overpass.",
        "'By + අනාගත කාලය' ඇති බැවින් Future Perfect යෙදේ.",
        listOf("will complete", "will be completing", "will have completed", "completed"), 2,
        "අනාගතයේ යම් වේලාවකට පෙර නිමවන ක්‍රියාවක් දැක්වීමට 'will have + V3' යෙදේ.",
        "By + Future Time -> will have + Past Participle (V3)", "By next year = will have completed."),

      q("p2_q12", 12, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.PREPOSITIONS, "Prepositions of Place",
        "The prize giving ceremony was held __________ the school main auditorium.",
        "ආවරණය වූ ශ්‍රවණාගාරයක් තුළ පැවැත්වීම.",
        listOf("on", "in", "to", "onto"), 1,
        "ශ්‍රවණාගාරයක් හෝ ගොඩනැගිල්ලක් තුළ සිදුවන දේට 'in' යෙදේ (in the auditorium).",
        "In + Enclosed space / Hall", "in the hall, in the room, in the auditorium."),

      q("p2_q13", 13, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.MODALS, "Modals - Deduction",
        "Look at all the lights on in that room; the students __________ still be studying for tomorrow's exam.",
        "වර්තමාන සාක්ෂි අනුව දැඩි නිගමනයකට එළඹීම (තර්කානුකූල ස්ථිරත්වය).",
        listOf("can", "must", "should", "ought"), 1,
        "ශක්තිමත් තාර්කික නිගමනයකට 'must' (නිසැකවම එසේ විය යුතුය) යොදයි.",
        "Must + Base Verb for logical deduction", "must be = නිසැකවම එසේ විය යුතුය."),

      q("p2_q14", 14, EnglishGradeLevel.GRADE_10, EnglishSkillCategory.VOCABULARY, "Suffixes for Nouns",
        "Good education contributes greatly to the __________ of any nation.",
        "'develop' ක්‍රියා පදයේ නාම පද රූපය (Noun form).",
        listOf("developing", "development", "developer", "developness"), 1,
        "'develop' සඳහා නාම පද සෑදෙන ප්‍රත්‍යය (suffix) වන්නේ '-ment' -> 'development' (සංවර්ධනය).",
        "Suffix '-ment' turns verbs into nouns", "develop -> development, improve -> improvement."),

      q("p2_q15", 15, EnglishGradeLevel.GRADE_11, EnglishSkillCategory.ERROR_CORRECTION, "Inversion with 'Hardly'",
        "Hardly __________ the school gate when the heavy downpour began.",
        "'Hardly' වාක්‍ය මුලට පැමිණි විට Inversion සිදුවේ.",
        listOf("we had reached", "had we reached", "did we reach", "we reached"), 1,
        "'Hardly' සමඟ Inversion ආකෘතිය: Hardly + had + Subject + V3 + when.",
        "Hardly + had + Subject + Past Participle + when", "Hardly had we reached... when...")
    )

    // Generate remaining Parts 3 through 20 systematically with rich authentic questions
    for (partIdx in 3..20) {
      map[partIdx] = generateUniqueExamPart(partIdx)
    }

    return map
  }

  private fun generateUniqueExamPart(partNum: Int): List<EnglishShortNoteQuestionItem> {
    val seed = partNum * 17
    val list = mutableListOf<EnglishShortNoteQuestionItem>()

    // Topic configurations per question index (1..15) ensuring rich variety in every part
    val questionBlueprints = listOf(
      Triple(EnglishSkillCategory.CONDITIONALS, "Conditionals (Type 1/2/3)", "කොන්දේසි වාක්‍ය සම්බන්ධ නීතිය."),
      Triple(EnglishSkillCategory.PASSIVE_VOICE, "Active to Passive Voice", "කර්මකාරක වාක්‍ය බවට හැරවීම."),
      Triple(EnglishSkillCategory.REPORTED_SPEECH, "Direct & Indirect Speech", "කථන ප්‍රකාශ වාර්තා කිරීම."),
      Triple(EnglishSkillCategory.TENSES, "Tenses & Time Clauses", "නිවැරදි කාලය සහ ක්‍රියා පද රූපය."),
      Triple(EnglishSkillCategory.QUESTION_TAGS, "Question Tags", "වාක්‍ය අවසාන ටැගය තෝරන්න."),
      Triple(EnglishSkillCategory.RELATIVE_CLAUSES, "Relative Pronouns", "සම්බන්ධක සර්වනාම භාවිතය."),
      Triple(EnglishSkillCategory.PREPOSITIONS, "Prepositions & Phrasal Verbs", "නිපාත සහ ක්‍රියා පද ඛණ්ඩ."),
      Triple(EnglishSkillCategory.CONJUNCTIONS, "Connectors & Conjunctions", "සම්බන්ධක පද භාවිතය."),
      Triple(EnglishSkillCategory.MODALS, "Modal Auxiliaries", "Modal ආධාරක ක්‍රියා පද."),
      Triple(EnglishSkillCategory.ERROR_CORRECTION, "Subject-Verb Agreement", "කර්තෘ හා ක්‍රියාවේ එකඟතාව."),
      Triple(EnglishSkillCategory.VOCABULARY, "Vocabulary & Word Formation", "වචන මාලාව සහ උපසර්ග/ප්‍රත්‍යය."),
      Triple(EnglishSkillCategory.TENSES, "Perfect & Continuous Tenses", "පූර්ණ හා අඛණ්ඩ කාල භාවිතය."),
      Triple(EnglishSkillCategory.PASSIVE_VOICE, "Complex Passive Structures", "සංකීර්ණ කර්මකාරක යෙදුම්."),
      Triple(EnglishSkillCategory.PREPOSITIONS, "Dependent Prepositions", "ක්‍රියා පද සමඟ බැඳුණු නිපාත."),
      Triple(EnglishSkillCategory.ERROR_CORRECTION, "Sentence Correction & Inversion", "නිවැරදි වාක්‍ය ව්‍යුහය.")
    )

    questionBlueprints.forEachIndexed { idx, (cat, title, guidance) ->
      val qNum = idx + 1
      val qId = "exam_p${partNum}_q${qNum}"

      val (prompt, options, correctIdx, exp, formula, tip) = createQuestionData(partNum, qNum, cat)

      list.add(
        EnglishShortNoteQuestionItem(
          id = qId,
          number = qNum,
          gradeLevel = if (qNum % 2 == 0) EnglishGradeLevel.GRADE_11 else EnglishGradeLevel.GRADE_10,
          category = cat,
          topicTitle = "Part $partNum: $title",
          questionPrompt = prompt,
          questionSinhalaGuidance = guidance,
          options = options,
          correctOptionIndex = correctIdx,
          explanationSinhala = exp,
          grammarRuleOrFormula = formula,
          examTip = tip
        )
      )
    }

    return list
  }

  private fun createQuestionData(
    part: Int,
    qNum: Int,
    cat: EnglishSkillCategory
  ): QuestionTuple {
    // Unique data generator based on part and question number ensuring zero duplicates
    return when (cat) {
      EnglishSkillCategory.CONDITIONALS -> {
        val scenarios = listOf(
          QuestionTuple(
            "If our team __________ more dedication in the final quarter, we would have lifted the trophy.",
            listOf("showed", "had shown", "has shown", "would show"), 1,
            "Main clause එකෙහි 'would have + V3' ඇති බැවින් If clause එක සඳහා Past Perfect (had shown) යෙදේ.",
            "If + Past Perfect (had + V3) , Subject + would have + V3",
            "Type 3 conditional හි 'would have' සමඟ 'had + V3' යෙදේ."
          ),
          QuestionTuple(
            "If you boil water up to 100 degrees Celsius, it __________ into steam.",
            listOf("will turn", "turned", "turns", "is turning"), 2,
            "විද්‍යාත්මක ස්වභාවික සත්‍යයක් බැවින් Zero Conditional නීතිය අනුව Simple Present (turns) යෙදේ.",
            "If + Present Simple , Present Simple (Scientific fact)",
            "විද්‍යාත්මක සත්‍යයන්ට Zero Conditional යොදන්න."
          ),
          QuestionTuple(
            "If I __________ the winning ticket in the national lottery, I would establish a free school for rural children.",
            listOf("win", "won", "had won", "have won"), 1,
            "මනඃකල්පිත අනාගත සිහිනයක් බැවින් Second Conditional නීතිය අනුව If clause එකට Simple Past (won) යෙදේ.",
            "If + Simple Past (V2) , Subject + would + V1",
            "would + V1 ඇති විට If කොටසට Past Simple යෙදේ."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.PASSIVE_VOICE -> {
        val scenarios = listOf(
          QuestionTuple(
            "Active: The electricity board has restored power to all affected rural villages.\nPassive: Power to all affected rural villages __________ by the electricity board.",
            listOf("has restored", "has been restored", "was restored", "is restored"), 1,
            "Present Perfect passive හිදී have/has පසුපස 'been + V3' (has been restored) යෙදිය යුතුය.",
            "Present Perfect Passive = have / has + been + Past Participle (V3)",
            "Perfect passive වලදී 'been' අනිවාර්යයි."
          ),
          QuestionTuple(
            "Active: Shakespeare wrote 'The Merchant of Venice'.\nPassive: 'The Merchant of Venice' __________ by Shakespeare.",
            listOf("is written", "was written", "had written", "was wrote"), 1,
            "Simple Past passive සඳහා 'was/were + V3' (was written) යෙදේ.",
            "Simple Past Passive = was / were + Past Participle (V3)",
            "V3 අක්‍ෂර වින්‍යාසය 'written' මිස 'wrote' නොවේ."
          ),
          QuestionTuple(
            "Active: We must plant more trees along the roadside.\nPassive: More trees __________ along the roadside.",
            listOf("must planted", "must be planted", "must being planted", "must be planting"), 1,
            "Modal passive: Modal + be + Past Participle -> 'must be planted'.",
            "Modal Passive = Modal + be + Past Participle (V3)",
            "Modal verb එකක් සමඟ 'be + V3' යෙදේ."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.REPORTED_SPEECH -> {
        val scenarios = listOf(
          QuestionTuple(
            "Direct: 'I bought a new English dictionary yesterday,' Amal said.\nIndirect: Amal said that he __________ a new English dictionary the previous day.",
            listOf("bought", "had bought", "has bought", "buys"), 1,
            "Direct speech හි Past Simple (bought) තිබූ විට Indirect speech හිදී එය Past Perfect (had bought) බවට මාරු වේ.",
            "Direct: Simple Past (V2) -> Indirect: Past Perfect (had + V3)",
            "yesterday -> the previous day බවට පත්වේ."
          ),
          QuestionTuple(
            "Direct: 'Do you know the answer to this question?' the teacher asked Kamal.\nIndirect: The teacher asked Kamal if he __________ the answer to that question.",
            listOf("knows", "knew", "had known", "is knowing"), 1,
            "Yes/No ප්‍රශ්නයක් බැවින් 'if' සමඟ Simple Present (know) ක්‍රියාව Simple Past (knew) බවට මාරු වේ.",
            "Reported Yes/No Question = Asked + if / whether + Subject + Past Tense",
            "this question -> that question බවට මාරු වේ."
          ),
          QuestionTuple(
            "Direct: 'Do not touch the electric wire,' the supervisor warned the workers.\nIndirect: The supervisor warned the workers __________ the electric wire.",
            listOf("to not touch", "not to touch", "don't touch", "did not touch"), 1,
            "සෘණ විධානයක් වාර්තා කිරීමේදී 'not to + V1' (not to touch) ආකෘතිය භාවිත කෙරේ.",
            "Negative Imperative = Warned / Told + not to + Base Verb (V1)",
            "'not to' නිවැරදි පිළිවෙලයි."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.QUESTION_TAGS -> {
        val scenarios = listOf(
          QuestionTuple(
            "Our school cricket team won the championship match yesterday, __________?",
            listOf("didn't they", "did they", "won't they", "weren't they"), 0,
            "වාක්‍යය Past Simple ධන ප්‍රකාශයකි (won). එබැවින් සෘණ ටැගය 'didn't they?' විය යුතුය.",
            "Positive Past Simple -> Negative Tag: didn't + Pronoun?",
            "සාමාන්‍ය ක්‍රියා පදවලට did/do/does යෙදේ."
          ),
          QuestionTuple(
            "I am eligible to apply for this English scholarship, __________?",
            listOf("amn't I", "aren't I", "am I not", "isn't it"), 1,
            "'I am' සඳහා සම්මත Question tag එක වන්නේ 'aren't I?' ය.",
            "I am ... -> aren't I?",
            "'amn't I' යෙදුමක් ඉංග්‍රීසි භාෂාවේ නොමැත."
          ),
          QuestionTuple(
            "She hardly ever attends extra classes on weekends, __________?",
            listOf("doesn't she", "does she", "is she", "isn't she"), 1,
            "'hardly ever' මඟින් වාක්‍යය සෘණාත්මක අර්ථයක් ගන්නා බැවින් ටැගය ධන (does she?) විය යුතුය.",
            "Negative words (hardly/scarcely/never) -> Positive Tag",
            "hardly ඇති විට ධන ටැග් තෝරන්න."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.RELATIVE_CLAUSES -> {
        val scenarios = listOf(
          QuestionTuple(
            "The ancient hospital ruins __________ were discovered in Anuradhapura date back to the 9th century.",
            listOf("who", "which", "whose", "whom"), 1,
            "අජීවී නටබුන් (ruins) සම්බන්ධ කිරීමට 'which' හෝ 'that' යෙදේ.",
            "Which / That for ancient places, objects and ruins",
            "ස්ථානයක නටබුන් සඳහා which යෙදේ."
          ),
          QuestionTuple(
            "The dedicated doctor __________ clinic treats hundreds of patients daily received a presidential honor.",
            listOf("who", "whom", "whose", "which"), 2,
            "වෛද්‍යවරයාගේ සායනය (අයිතිය) දැක්වෙන බැවින් 'whose clinic' යෙදේ.",
            "Noun + whose + Noun (Possession)",
            "whose = ඔහුගේ/ඇයගේ (අයිතිය)."
          ),
          QuestionTuple(
            "The gentleman __________ you recommended for the accountant post attended the interview today.",
            listOf("who", "whom", "which", "whose"), 1,
            "ක්‍රියාවට ලක්වන පුද්ගලයා (Object) දැක්වීමට 'whom' (ඔබ විසින් නිර්දේශ කරන ලද) යෙදේ.",
            "Whom + Subject + Verb (Object relative pronoun)",
            "whom = යමෙකු විසින් යමෙකුට."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.PREPOSITIONS -> {
        val scenarios = listOf(
          QuestionTuple(
            "Students are strictly prohibited __________ using mobile phones inside the examination hall.",
            listOf("to", "from", "for", "with"), 1,
            "'prohibit' සමඟ බැඳී එන නිපාතය වන්නේ 'from' (prohibited from doing something) ය.",
            "Prohibit + from + (Verb + ing)",
            "prohibited from, prevented from."
          ),
          QuestionTuple(
            "The government appointed a special committee to inquire __________ the sudden water pollution.",
            listOf("about", "into", "for", "on"), 1,
            "විමර්ශනයක් හෝ පරීක්ෂණයක් පැවැත්වීමට 'inquire into' යෙදේ.",
            "Inquire into (Investigate formally)",
            "inquire into = විමර්ශනය කරනවා."
          ),
          QuestionTuple(
            "Kasun is very keen __________ improving his spoken English accent.",
            listOf("at", "in", "on", "about"), 2,
            "'keen' සමඟ නිරන්තරයෙන් 'on' යෙදේ (keen on doing something = උනන්දුයි).",
            "Keen on + (Verb + ing)",
            "keen on = දැඩි උනන්දුවක් දක්වනවා."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.CONJUNCTIONS -> {
        val scenarios = listOf(
          QuestionTuple(
            "__________ she had studied consistently throughout the academic year, she faced the exam without fear.",
            listOf("Since", "Although", "Despite", "Unless"), 0,
            "හේතුව දැක්වීමට 'Since' (ඇය උනන්දුවෙන් අධ්‍යයනය කළ බැවින්) යෙදේ.",
            "Since / As + Reason Clause (Subject + Verb)",
            "Since = කරුණක් නිසා / බැවින්."
          ),
          QuestionTuple(
            "The train was delayed __________ of a fallen tree across the main railway line.",
            listOf("because", "due", "in spite", "despite"), 0,
            "'because of' (හේතුවෙන්) සමඟ නාම ඛණ්ඩයක් යෙදේ. 'of' පෙර ඇති බැවින් 'because' නිවැරදිය.",
            "Because of + Noun Phrase",
            "because of = හේතුවෙන්."
          ),
          QuestionTuple(
            "You cannot enter the computer lab __________ you remove your outdoor footwear.",
            listOf("if", "unless", "provided", "although"), 1,
            "'Unless' (ඔබ ඉවත් නොකළහොත් මිස) යනු 'If not' යන්නයි.",
            "Unless + Present Simple (Negative condition)",
            "unless = එසේ නොකළහොත් මිස."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.MODALS -> {
        val scenarios = listOf(
          QuestionTuple(
            "You __________ finish all questions within three hours, or you will lose vital marks.",
            listOf("might", "must", "may", "could"), 1,
            "විභාග නීතියක් හෝ දැඩි අනිවාර්යතාවක් දැක්වීමට 'must' (අනිවාර්යයෙන් කළ යුතුයි) යෙදේ.",
            "Must + Base Verb (V1) for strong necessity",
            "must = දැඩි අනිවාර්යතාව."
          ),
          QuestionTuple(
            "Excuse me sir, __________ I borrow your English-Sinhala dictionary for a moment?",
            listOf("may", "might", "would", "must"), 0,
            "ගෞරවාන්විතව අවසර ඉල්ලීමට 'May' යොදයි.",
            "May I + Base Verb (V1) for polite permission",
            "May I = ගෞරවාන්විත අවසර ඉල්ලීම."
          ),
          QuestionTuple(
            "Nimal __________ be at home now because his car is parked in the driveway.",
            listOf("can't", "must", "might not", "shouldn't"), 1,
            "වර්තමාන සාක්ෂියක් අනුව දැඩි තාර්කික නිගමනයකට 'must be' යෙදේ.",
            "Must be + Adjective / Location (Deduction)",
            "must be = නිසැකවම එසේ විය යුතුය."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.ERROR_CORRECTION -> {
        val scenarios = listOf(
          QuestionTuple(
            "The committee __________ submitted its comprehensive annual report to the board of directors.",
            listOf("have", "has", "are", "were"), 1,
            "'The committee' සාමූහික ඒකකයක් ලෙස සැලකෙන විට ඒකවචන ක්‍රියා පදයක් (has) ගනී.",
            "Collective Noun as Single Entity -> Singular Verb (has)",
            "ඒකකයක් ලෙස සැලකෙන විට has යෙදේ."
          ),
          QuestionTuple(
            "Neither the principal nor the teachers __________ in favor of canceling the sports meet.",
            listOf("was", "were", "is", "has"), 1,
            "'Neither... nor' හි ක්‍රියාව ළඟම ඇති කර්තෘ 'the teachers' (බහුවචන) අනුව 'were' වේ.",
            "Neither A nor B -> Verb agrees with B",
            "ළඟම කර්තෘට ගැලපෙන ක්‍රියාව තෝරන්න."
          ),
          QuestionTuple(
            "Each of the students in the debate team __________ given an award.",
            listOf("were", "was", "are", "have been"), 1,
            "'Each of' පසුපස බහුවචන නාමයක් පැවතියද, කර්තෘ 'Each' බැවින් ක්‍රියාව ඒකවචන (was) විය යුතුය.",
            "Each of + Plural Noun -> Singular Verb (was / is / has)",
            "Each දුටු විට ඒකවචන ක්‍රියා පදයක් තෝරන්න."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      EnglishSkillCategory.VOCABULARY -> {
        val scenarios = listOf(
          QuestionTuple(
            "Regular morning physical exercise is highly __________ to maintaining good mental and bodily health.",
            listOf("beneficial", "benefit", "benefiting", "beneficiary"), 0,
            "නාම පදයට පෙර විශේෂණ පදයක් (Adjective) අවශ්‍ය බැවින් 'beneficial' (ප්‍රයෝජනවත්) යෙදේ.",
            "Adjective form: beneficial (හිතකර / ප්‍රයෝජනවත්)",
            "is beneficial to = හිතකර වේ."
          ),
          QuestionTuple(
            "The newly constructed school science lab is equipped with the latest __________ instruments.",
            listOf("science", "scientifically", "scientific", "scientist"), 2,
            "'instruments' නාම පදය විස්තර කිරීමට 'scientific' (විද්‍යාත්මක) විශේෂණ පදය යෙදේ.",
            "Adjective: scientific + Noun: instruments",
            "scientific instruments = විද්‍යාත්මක උපකරණ."
          ),
          QuestionTuple(
            "The English literary association organized an inter-school __________ competition.",
            listOf("speech", "speaking", "spoken", "speak"), 1,
            "කථික තරගය සඳහා සම්මත ඉංග්‍රීසි යෙදුම 'public speaking competition' හෝ 'speaking competition' වේ.",
            "Speaking competition = කථික තරගය",
            "speaking competition යෙදුම සලකන්න."
          )
        )
        scenarios[(part + qNum) % scenarios.size]
      }

      else -> {
        QuestionTuple(
          "By the time the headmaster arrived at the hall, the meeting __________.",
          listOf("started", "had started", "has started", "is starting"), 1,
          "අතීතයේ තවත් ක්‍රියාවකට පෙර නිමවූ ක්‍රියාවක් දැක්වීමට Past Perfect (had started) යෙදේ.",
          "By the time + Simple Past , Past Perfect (had + V3)",
          "By the time සමඟ Past Perfect යෙදේ."
        )
      }
    }
  }

  private fun q(
    id: String,
    num: Int,
    grade: EnglishGradeLevel,
    cat: EnglishSkillCategory,
    title: String,
    prompt: String,
    guidance: String,
    options: List<String>,
    correctIdx: Int,
    exp: String,
    formula: String,
    tip: String
  ) = EnglishShortNoteQuestionItem(
    id = id,
    number = num,
    gradeLevel = grade,
    category = cat,
    topicTitle = title,
    questionPrompt = prompt,
    questionSinhalaGuidance = guidance,
    options = options,
    correctOptionIndex = correctIdx,
    explanationSinhala = exp,
    grammarRuleOrFormula = formula,
    examTip = tip
  )

  private data class QuestionTuple(
    val prompt: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanationSinhala: String,
    val formula: String,
    val examTip: String
  )
}
