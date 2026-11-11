package com.example

/**
 * 50 Comprehensive English Grammar Short Notes for G.C.E. O/L & Middle School (10 & 11)
 * Explanations primarily in Sinhala with English & Sinhala parallel sentences.
 * 100% Accurate, aligned with National NIE Syllabus.
 */
object EnglishGrammar50DataBank {

  val rulesList50: List<EnglishGrammarRuleSummary> = listOf(
    // 1. Simple Present Tense
    EnglishGrammarRuleSummary(
      title = "1. Simple Present Tense (සාමාන්‍ය වර්තමාන කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + V1 (s/es/ies for He/She/It) + Object",
      explanationSinhala = "දෛනික පුරුදු, නිතිපතා කරන ක්‍රියා, සාමාන්‍ය සත්‍යයන් සහ ස්වභාවික ධර්මතාවයන් ප්‍රකාශ කිරීමට සාමාන්‍ය වර්තමාන කාලය යොදා ගැනේ. කර්තෘ ඒකවචන (He, She, It, හෝ තනි නාමයක්) නම් ක්‍රියා පදයට 's', 'es' හෝ 'ies' එක් වේ.",
      examples = listOf(
        "He drinks a glass of milk every morning. - ඔහු සෑම උදෑසනකම කිරි වීදුරුවක් පානය කරයි.",
        "The sun rises in the east. - සූර්යයා නැගෙනහිරින් උදා වේ.",
        "They play football on Sundays. - ඔවුන් ඉරිදා දිනවල පාපන්දු ක්‍රීඩා කරති."
      ),
      commonMistake = "❌ He go to school -> ✅ He goes to school (He/She/It සඳහා ක්‍රියා පදයට 'es' එක් විය යුතුය)."
    ),

    // 2. Present Continuous Tense
    EnglishGrammarRuleSummary(
      title = "2. Present Continuous Tense (වර්තමාන අඛණ්ඩ කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + is / am / are + (Verb + ing) + Object",
      explanationSinhala = "කතා කරන මොහොතේ මේ දැන් සිදුවෙමින් පවතින ක්‍රියා දැක්වීමට මෙය යෙදේ. I සමඟ 'am', ඒකවචන සමඟ 'is', සහ බහුවචන (We, You, They) සමඟ 'are' යෙදේ.",
      examples = listOf(
        "The students are writing their English assignment. - සිසුන් මේ මොහොතේ ඔවුන්ගේ ඉංග්‍රීසි පැවරුම ලියමින් සිටිති.",
        "She is reading a novel in the library. - ඇය පුස්තකාලයේ නවකතාවක් කියවමින් සිටියි.",
        "I am preparing for the O/L examination. - මම සාමාන්‍ය පෙළ විභාගය සඳහා සූදානම් වෙමින් සිටිමි."
      ),
      commonMistake = "❌ They is playing -> ✅ They are playing (බහුවචන කර්තෘ සඳහා 'are' යෙදිය යුතුය)."
    ),

    // 3. Present Perfect Tense
    EnglishGrammarRuleSummary(
      title = "3. Present Perfect Tense (පූර්ණ වර්තමාන කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + have / has + Past Participle (V3) + Object",
      explanationSinhala = "අතීතයේ නිමවූ නමුත් එහි බලපෑම වර්තමානයට පවතින ක්‍රියා හෝ මේ දැන් අවසන් කළ (just, already, yet) ක්‍රියා දැක්වීමට යෙදේ. He/She/It සඳහා 'has' ද, I/We/You/They සඳහා 'have' ද යෙදේ.",
      examples = listOf(
        "She has already completed her science project. - ඇය දැනටමත් සිය විද්‍යා ව්‍යාපෘතිය සම්පූර්ණ කර ඇත.",
        "We have lived in Colombo for five years. - අපි වසර පහක් පුරා කොළඹ ජීවත්ව ඇත්තෙමු.",
        "I have just received the exam timetable. - මට මේ දැන් විභාග කාලසටහන ලැබුණි."
      ),
      commonMistake = "❌ She has finish the work -> ✅ She has finished the work (have/has පසුපස 3 වන ක්‍රියා පද රූපය - V3 අනිවාර්ය වේ)."
    ),

    // 4. Present Perfect Continuous Tense
    EnglishGrammarRuleSummary(
      title = "4. Present Perfect Continuous Tense (පූර්ණ අඛණ්ඩ වර්තමාන කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + have/has + been + (Verb + ing) + since / for",
      explanationSinhala = "අතීතයේ නිශ්චිත වේලාවක ආරම්භ වී මේ දක්වාම අඛණ්ඩව සිදුවෙමින් පවතින ක්‍රියා සඳහා යොදා ගනී. ආරම්භක ලක්ෂ්‍යය දැක්වීමට 'since' ද, කාල සීමාව දැක්වීමට 'for' ද යෙදේ.",
      examples = listOf(
        "It has been raining since morning. - උදෑසන සිට අඛණ්ඩව වැසි ඇදහැලෙමින් පවතී.",
        "Kasun has been studying for three hours. - කසුන් පැය තුනක් තිස්සේ පාඩම් කරමින් සිටියි.",
        "They have been working here since 2020. - ඔවුන් 2020 වසරේ සිට මෙහි සේවය කරමින් සිටිති."
      ),
      commonMistake = "❌ It is raining since morning -> ✅ It has been raining since morning (since/for සමඟ 'has been + ing' යෙදිය යුතුය)."
    ),

    // 5. Simple Past Tense
    EnglishGrammarRuleSummary(
      title = "5. Simple Past Tense (සාමාන්‍ය අතීත කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + Past Form of Verb (V2) + Object",
      explanationSinhala = "අතීතයේදී සිදුවී මුළුමනින්ම අවසන් වූ ක්‍රියාවන් ප්‍රකාශ කිරීමට භාවිත කෙරේ. බොහෝවිට yesterday, last year, in 2015, ago වැනි අතීත කාල නිර්දේශක සමඟ යෙදේ.",
      examples = listOf(
        "They visited the Sigiriya fortress yesterday. - ඔවුන් ඊයේ සීගිරි බලකොටුව නැරඹූහ.",
        "My mother cooked delicious milk rice. - මගේ මව රසවත් කිරිබත් පිසුවාය.",
        "We passed the term test with flying colors. - අපි වාර විභාගය ඉතා ඉහළින් සමත් වීමු."
      ),
      commonMistake = "❌ Did you went to school? -> ✅ Did you go to school? ('did' සමඟ ප්‍රශ්න ඇසීමේදී මූලික ක්‍රියා පදය - V1 යෙදේ)."
    ),

    // 6. Past Continuous Tense
    EnglishGrammarRuleSummary(
      title = "6. Past Continuous Tense (අතීත අඛණ්ඩ කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + was / were + (Verb + ing) + Object",
      explanationSinhala = "අතීතයේ යම් නිශ්චිත මොහොතක සිදුවෙමින් පැවති ක්‍රියා හෝ අතීතයේ එක් ක්‍රියාවක් සිදුවෙමින් පවතිද්දී තවත් ක්‍රියාවක් සිදුවූ අවස්ථා (when/while) දැක්වීමට යොදා ගැනේ.",
      examples = listOf(
        "I was reading when the lights went out. - විදුලිය විසන්ධි වන විට මම පොතක් කියවමින් සිටියෙමි.",
        "The children were playing cricket in the rain. - ළමයි වැස්සේ ක්‍රිකට් ක්‍රීඩා කරමින් සිටියහ.",
        "While she was cooking, the phone rang. - ඇය උයමින් සිටියදී දුරකථනය නාද විය."
      ),
      commonMistake = "❌ We was watching TV -> ✅ We were watching TV (බහුවචන We/They සඳහා 'were' යෙදිය යුතුය)."
    ),

    // 7. Past Perfect Tense
    EnglishGrammarRuleSummary(
      title = "7. Past Perfect Tense (පූර්ණ අතීත කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + had + Past Participle (V3) + Object",
      explanationSinhala = "අතීතයේ සිදුවීම් දෙකක් අතරින් පළමුවෙන් සිදු වූ අතීත සිදුවීම දැක්වීමට 'had + V3' (Past Perfect) යොදන අතර, දෙවනුව සිදුවූ ක්‍රියාවට Simple Past (V2) යොදයි.",
      examples = listOf(
        "The train had already left when we reached the station. - අප දුම්රිය ස්ථානයට ළඟා වන විටත් දුම්රිය පිටත්ව ගොස් තිබුණි.",
        "She had finished the essay before the teacher entered. - ගුරුතුමිය ඇතුළු වීමට පෙර ඇය රචනය ලියා අවසන් කර තිබුණි."
      ),
      commonMistake = "❌ When we arrived, the train already left -> ✅ The train had already left (පළමු සිදුවීමට 'had + V3' අනිවාර්යයි)."
    ),

    // 8. Past Perfect Continuous Tense
    EnglishGrammarRuleSummary(
      title = "8. Past Perfect Continuous Tense (පූර්ණ අඛණ්ඩ අතීත කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + had + been + (Verb + ing)",
      explanationSinhala = "අතීතයේ තවත් සිදුවීමකට පෙර යම් කාලයක් තිස්සේ අඛණ්ඩව සිදුවෙමින් පැවති ක්‍රියාවක් විස්තර කිරීමට භාවිත කරයි.",
      examples = listOf(
        "He was exhausted because he had been running for two hours. - ඔහු පැය දෙකක් තිස්සේ දුවමින් සිටි බැවින් දැඩි ලෙස විඩාපත් වී සිටියේය.",
        "They had been waiting for the bus before a taxi arrived. - කුලී රථය පැමිණීමට පෙර ඔවුන් බස් රථය එනතුරු රැඳී සිටියහ."
      ),
      commonMistake = "❌ He had running -> ✅ He had been running ('had' හා '-ing' අතරට 'been' යෙදිය යුතුය)."
    ),

    // 9. Simple Future Tense (Will / Shall)
    EnglishGrammarRuleSummary(
      title = "9. Simple Future Tense (සාමාන්‍ය අනාගත කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + will / shall + Base Verb (V1) + Object",
      explanationSinhala = "අනාගතයේ සිදුවන ක්‍රියා, ක්ෂණික තීරණ හෝ අනාවැකි දැක්වීමට 'will + V1' භාවිත වේ. I සහ We සමඟ 'shall' යෙදිය හැකිය.",
      examples = listOf(
        "We will face the O/L examination with great confidence. - අපි දැඩි විශ්වාසයෙන් යුතුව සාමාන්‍ය පෙළ විභාගයට මුහුණ දෙන්නෙමු.",
        "The principal will announce the sports meet results tomorrow. - විදුහල්පතිතුමා හෙට ක්‍රීඩා උළෙලේ ප්‍රතිඵල ප්‍රකාශ කරනු ඇත."
      ),
      commonMistake = "❌ He will goes tomorrow -> ✅ He will go tomorrow ('will' පසුපස සෑම විටම මූලික ක්‍රියා පදය - V1 පමණක් යෙදේ)."
    ),

    // 10. Future with 'Be Going To'
    EnglishGrammarRuleSummary(
      title = "10. Future Plans with 'Be Going To' (සැලසුම් කළ අනාගතය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + is / am / are + going to + Base Verb (V1)",
      explanationSinhala = "කලින් සැලසුම් කළ අනාගත ක්‍රියා සහ වර්තමාන සාක්ෂි අනුව සිදුවීමට නියමිත දේ ප්‍රකාශ කිරීමට 'be going to' යොදයි.",
      examples = listOf(
        "Look at those black clouds; it is going to rain. - අර කළු වළාකුළු දෙස බලන්න; වැසි ඇදහැලෙන්නට යයි.",
        "I am going to study medicine after my A/Levels. - මම උසස් පෙළින් පසු වෛද්‍ය විද්‍යාව හැදෑරීමට සැලසුම් කර සිටිමි."
      ),
      commonMistake = "❌ It is going to raining -> ✅ It is going to rain ('going to' පසුපස V1 පමණක් එයි)."
    ),

    // 11. Future Continuous Tense
    EnglishGrammarRuleSummary(
      title = "11. Future Continuous Tense (අනාගත අඛණ්ඩ කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + will be + (Verb + ing) + Object",
      explanationSinhala = "අනාගතයේ නිශ්චිත වේලාවක සිදුවෙමින් පවතිනු ඇති ක්‍රියාවක් විස්තර කිරීමට යොදයි.",
      examples = listOf(
        "This time tomorrow, we will be writing our English paper. - හෙට මේ වේලාවට අපි අපගේ ඉංග්‍රීසි ප්‍රශ්න පත්‍රය ලියමින් සිටිනු ඇත.",
        "She will be traveling to Anuradhapura this weekend. - ඇය මෙම සති අන්තයේ අනුරාධපුරය බලා ගමන් කරමින් සිටිනු ඇත."
      ),
      commonMistake = "❌ We will writing -> ✅ We will be writing ('will' සහ '-ing' අතරට 'be' යෙදිය යුතුය)."
    ),

    // 12. Future Perfect Tense
    EnglishGrammarRuleSummary(
      title = "12. Future Perfect Tense (පූර්ණ අනාගත කාලය)",
      category = EnglishSkillCategory.TENSES,
      formula = "Subject + will have + Past Participle (V3) + by (time)",
      explanationSinhala = "අනාගතයේ යම් නිශ්චිත වේලාවකට පෙර සම්පූර්ණ වී අවසන්ව පවතින ක්‍රියා දැක්වීමට යොදයි. බහුලව 'by next year', 'by December' වැනි යෙදුම් සමඟ එයි.",
      examples = listOf(
        "By the end of this year, I will have completed my syllabus. - මෙම වසර අවසන් වන විට මම මගේ විෂය නිර්දේශය සම්පූර්ණ කර අවසන් කරනු ඇත.",
        "They will have built the school auditorium by December. - දෙසැම්බර් වන විට ඔවුන් පාසල් ශ්‍රවණාගාරය ඉදිකර අවසන් කරනු ඇත."
      ),
      commonMistake = "❌ She will have finish -> ✅ She will have finished ('will have' පසුපස V3 යෙදිය යුතුය)."
    ),

    // 13. Active to Passive Voice (Simple Present)
    EnglishGrammarRuleSummary(
      title = "13. Passive Voice: Simple Present (වර්තමාන කර්මකාරක)",
      category = EnglishSkillCategory.PASSIVE_VOICE,
      formula = "Object + is / am / are + Past Participle (V3) + (by + Agent)",
      explanationSinhala = "කර්තෘට වඩා කර්මයට (ක්‍රියාවට ලක්වූ දේට) ප්‍රමුඛත්වය ලබාදීමේදී Passive Voice යෙදේ. සාමාන්‍ය වර්තමාන කාලයේදී 'is/am/are + V3' ආකෘතිය භාවිත වේ.",
      examples = listOf(
        "The farmer cultivates paddy. -> Paddy is cultivated by the farmer. - ගොවියා වී වගා කරයි. -> වී ගොවියා විසින් වගා කරනු ලැබේ.",
        "English teachers conduct mock exams. -> Mock exams are conducted by English teachers. - ආදර්ශ විභාග ගුරුවරුන් විසින් පවත්වනු ලැබේ."
      ),
      commonMistake = "❌ Paddy is cultivate -> ✅ Paddy is cultivated (Passive හි සෑම විටම V3 තිබිය යුතුය)."
    ),

    // 14. Active to Passive Voice (Simple Past)
    EnglishGrammarRuleSummary(
      title = "14. Passive Voice: Simple Past (අතීත කර්මකාරක)",
      category = EnglishSkillCategory.PASSIVE_VOICE,
      formula = "Object + was / were + Past Participle (V3) + (by + Agent)",
      explanationSinhala = "අතීතයේ සිදු වූ ක්‍රියාවක කර්මය මුලට ගෙන Passive කිරීමේදී ඒකවචන සඳහා 'was' ද බහුවචන සඳහා 'were' ද සමඟ V3 යොදයි.",
      examples = listOf(
        "King Dutugemunu built the Ruwanwelisaya. -> Ruwanwelisaya was built by King Dutugemunu. - රුවන්වැලිසෑය දුටුගැමුණු රජතුමා විසින් ඉදිකරන ලදී.",
        "The police arrested the thieves. -> The thieves were arrested by the police. - සොරුන් පොලිසිය විසින් අත්අඩංගුවට ගන්නා ලදී."
      ),
      commonMistake = "❌ The car was stole -> ✅ The car was stolen (V3 නිවැරදි අක්‍ෂර වින්‍යාසයෙන් තිබිය යුතුය)."
    ),

    // 15. Active to Passive Voice (Continuous Tenses)
    EnglishGrammarRuleSummary(
      title = "15. Passive Voice: Continuous Tenses (අඛණ්ඩ කර්මකාරක)",
      category = EnglishSkillCategory.PASSIVE_VOICE,
      formula = "Object + is/are/was/were + being + Past Participle (V3)",
      explanationSinhala = "Continuous ක්‍රියාවක් කර්මකාරකයට පෙරළීමේදී අනිවාර්යයෙන්ම 'being' යන වචනය be-verb එක සහ V3 අතරට එකතු කළ යුතුය.",
      examples = listOf(
        "The workers are repairing the road. -> The road is being repaired by the workers. - මාර්ගය සේවකයන් විසින් ප්‍රතිසංස්කරණය කරමින් පවතී.",
        "She was preparing dinner. -> Dinner was being prepared by her. - රාත්‍රී ආහාරය ඇය විසින් සූදානම් කරමින් පැවතුණි."
      ),
      commonMistake = "❌ The road is repairing -> ✅ The road is being repaired ('being' නොයෙදුවහොත් අර්ථය වැරදි වේ)."
    ),

    // 16. Active to Passive Voice (Perfect Tenses)
    EnglishGrammarRuleSummary(
      title = "16. Passive Voice: Perfect Tenses (පූර්ණ කර්මකාරක)",
      category = EnglishSkillCategory.PASSIVE_VOICE,
      formula = "Object + have / has / had + been + Past Participle (V3)",
      explanationSinhala = "Perfect කාලයක ඇති වාක්‍යයක් Passive කිරීමේදී have/has/had පසුපස 'been' එකතු කර V3 යෙදිය යුතුය.",
      examples = listOf(
        "The government has launched a new project. -> A new project has been launched by the government. - රජය විසින් නව ව්‍යාපෘතියක් ආරම්භ කර ඇත.",
        "They had painted the house. -> The house had been painted by them. - නිවස ඔවුන් විසින් තීන්ත ආලේප කර තිබුණි."
      ),
      commonMistake = "❌ The project has launched -> ✅ The project has been launched ('been' අනිවාර්ය වේ)."
    ),

    // 17. Active to Passive with Modals
    EnglishGrammarRuleSummary(
      title = "17. Passive Voice: Modal Verbs (Can, Must, Should)",
      category = EnglishSkillCategory.PASSIVE_VOICE,
      formula = "Object + Modal (can/must/should) + be + Past Participle (V3)",
      explanationSinhala = "Can, must, should, may, could වැනි Modal verbs සමඟ Passive වාක්‍යයක් ගොඩනැගීමේදී 'modal + be + V3' ආකෘතිය භාවිත වේ.",
      examples = listOf(
        "We must protect the forest. -> The forest must be protected. - වනාන්තරය ආරක්ෂා කළ යුතුය.",
        "You can solve this math problem easily. -> This math problem can be solved easily. - මෙම ගණිත ගැටලුව පහසුවෙන් විසඳිය හැක."
      ),
      commonMistake = "❌ It must protected -> ✅ It must be protected ('be' එකතු කිරීම අත්‍යවශ්‍යයි)."
    ),

    // 18. Direct to Indirect Speech: Statements
    EnglishGrammarRuleSummary(
      title = "18. Reported Speech: Statements (ප්‍රකාශ වාර්තා කිරීම)",
      category = EnglishSkillCategory.REPORTED_SPEECH,
      formula = "Reporting Verb (said that) + Tense Backshift + Pronoun Change",
      explanationSinhala = "කෙනෙකු කියූ ප්‍රකාශයක් වාර්තා කිරීමේදී Reporting verb එක Past (said/told) නම්, Present Simple -> Past Simple ද, Present Continuous -> Past Continuous ද ආදී වශයෙන් පසුපසට කාල මාරු (backshift) වේ.",
      examples = listOf(
        "Kamal said, 'I am learning French.' -> Kamal said that he was learning French. - කමල් තමා ප්‍රංශ භාෂාව ඉගෙන ගනිමින් සිටින බව පැවසීය.",
        "Nimal said, 'I have finished.' -> Nimal said that he had finished. - නිමාල් තමා එය නිමකළ බව පැවසීය."
      ),
      commonMistake = "❌ Kamal said that he is learning -> ✅ Kamal said that he was learning (කාලය අතීතයට හැරවිය යුතුය)."
    ),

    // 19. Direct to Indirect Speech: Questions
    EnglishGrammarRuleSummary(
      title = "19. Reported Speech: Questions (ප්‍රශ්න වාර්තා කිරීම)",
      category = EnglishSkillCategory.REPORTED_SPEECH,
      formula = "Asked + Wh-word / if / whether + Subject + Verb",
      explanationSinhala = "ප්‍රශ්න වාර්තා කිරීමේදී 'said' වෙනුවට 'asked/inquired' යෙදේ. Wh- ප්‍රශ්න සඳහා එම Wh- වචනයද, Yes/No ප්‍රශ්න සඳහා 'if' හෝ 'whether' ද යොදන අතර ප්‍රශ්න ආකෘතිය සාමාන්‍ය ප්‍රකාශන ආකෘතියක් බවට පත්වේ.",
      examples = listOf(
        "She asked me, 'Where do you live?' -> She asked me where I lived. - මම ජීවත් වන්නේ කොහේදැයි ඇය මගෙන් විමසුවාය.",
        "He asked, 'Do you like cricket?' -> He asked if I liked cricket. - මම ක්‍රිකට් ක්‍රීඩාවට කැමතිදැයි ඔහු ඇසුවේය."
      ),
      commonMistake = "❌ She asked where did I live -> ✅ She asked where I lived (වාර්තා කිරීමේදී ප්‍රශ්න වචන පිළිවෙල ඉවත් වේ)."
    ),

    // 20. Direct to Indirect Speech: Imperatives (Orders & Requests)
    EnglishGrammarRuleSummary(
      title = "20. Reported Speech: Orders & Requests (විධාන හා ඉල්ලීම්)",
      category = EnglishSkillCategory.REPORTED_SPEECH,
      formula = "Subject + told / ordered / requested + Person + to + Base Verb (V1)",
      explanationSinhala = "විධානයක් හෝ ඉල්ලීමක් වාර්තා කිරීමේදී 'to + V1' (ධන විධාන) හෝ 'not to + V1' (සෘණ විධාන) භාවිත කරයි.",
      examples = listOf(
        "The teacher said, 'Open your books.' -> The teacher told the students to open their books. - පොත් විවෘත කරන ලෙස ගුරුතුමිය සිසුන්ට පැවසුවාය.",
        "Mother said, 'Do not play in the rain.' -> Mother advised me not to play in the rain. - වැස්සේ සෙල්ලම් නොකරන ලෙස අම්මා මට උපදෙස් දුන්නාය."
      ),
      commonMistake = "❌ He told me to not go -> ✅ He told me not to go ('not to' නිවැරදි පිළිවෙලයි)."
    ),

    // 21. Zero Conditional
    EnglishGrammarRuleSummary(
      title = "21. Zero Conditional: Universal Facts (නෛසර්ගික සත්‍යයන්)",
      category = EnglishSkillCategory.CONDITIONALS,
      formula = "If + Simple Present , Simple Present",
      explanationSinhala = "විද්‍යාත්මක නියමයන්, ස්වභාවික සත්‍යයන් සහ ස්ථිර පුරුදු ප්‍රකාශ කිරීම සඳහා If දෙපසම Simple Present කාලයෙන් තබයි.",
      examples = listOf(
        "If you heat ice, it melts into water. - ඔබ අයිස් රත් කළහොත්, එය ජලය බවට දිය වේ.",
        "If plants do not get sunlight, they die. - ශාකවලට හිරු එළිය නොලැබුණහොත්, ඒවා මිය යයි."
      ),
      commonMistake = "❌ If you heat ice, it will melt -> ✅ If you heat ice, it melts (විද්‍යාත්මක නෛසර්ගික සත්‍යයකට Zero Conditional වඩාත් සුදුසුය)."
    ),

    // 22. First Conditional
    EnglishGrammarRuleSummary(
      title = "22. First Conditional: Real Possibility (විය හැකි සත්‍ය අවස්ථා)",
      category = EnglishSkillCategory.CONDITIONALS,
      formula = "If + Simple Present (V1) , Subject + will + Base Verb (V1)",
      explanationSinhala = "වර්තමානයේ හෝ අනාගතයේදී සිදුවීමට බොහෝ ඉඩකඩ ඇති සැබෑ කොන්දේසි දැක්වීමට මෙය යෙදේ. If කොටස Simple Present ද, Main කොටස 'will + V1' ද වේ.",
      examples = listOf(
        "If you study hard, you will pass the exam with an 'A' grade. - ඔබ උනන්දුවෙන් පාඩම් කළහොත්, ඔබ විභාගය 'A' සාමාර්ථයක් සහිතව සමත් වනු ඇත.",
        "If it rains tomorrow, we will cancel the trip. - හෙට වැසි වැටුණහොත්, අපි චාරිකාව අවලංගු කරන්නෙමු."
      ),
      commonMistake = "❌ If you will study, you will pass -> ✅ If you study, you will pass (If වගන්තිය තුළ 'will' කිසිවිටෙක නොයෙදේ)."
    ),

    // 23. Second Conditional
    EnglishGrammarRuleSummary(
      title = "23. Second Conditional: Unreal / Imaginary (මනඃකල්පිත අවස්ථා)",
      category = EnglishSkillCategory.CONDITIONALS,
      formula = "If + Simple Past (V2) , Subject + would + Base Verb (V1)",
      explanationSinhala = "වර්තමානයේ සැබෑ නොවන, මනඃකල්පිත සිහින හෝ විය නොහැකි අවස්ථා දැක්වීමට භාවිත කරයි. If කොටසට Past Simple (were/V2) ද, Main කොටසට 'would + V1' ද යෙදේ.",
      examples = listOf(
        "If I were a bird, I would fly across the world. - මම කුරුල්ලෙකු වූවා නම්, මම මුළු ලොව වටා පියාසර කරන්නෙමි.",
        "If he had enough money, he would buy a computer. - ඔහු සතුව ප්‍රමාණවත් මුදල් තිබුණා නම්, ඔහු පරිගණකයක් මිලදී ගනු ඇත."
      ),
      commonMistake = "❌ If I was a bird -> ✅ If I were a bird (මනඃකල්පිත අවස්ථාවලදී සියලු කර්තෘන් සඳහා 'were' යෙදීම සම්මත නීතියයි)."
    ),

    // 24. Third Conditional
    EnglishGrammarRuleSummary(
      title = "24. Third Conditional: Past Regret (අතීත පසුතැවීම්)",
      category = EnglishSkillCategory.CONDITIONALS,
      formula = "If + Past Perfect (had + V3) , Subject + would have + Past Participle (V3)",
      explanationSinhala = "අතීතයේදී සිදු නොවූ දෙයක් ගැන පසුතැවීම හෝ වෙනස් විය හැකිව තිබූ ප්‍රතිඵල විස්තර කිරීමට යොදා ගනී. O/L විභාග ප්‍රශ්න පත්‍රයේ නිතර අසන ප්‍රශ්නයකි.",
      examples = listOf(
        "If you had informed me earlier, I would have helped you. - ඔබ මට කලින් දැනුම් දුන්නේ නම්, මම ඔබට උදව් කරන්නට තිබුණි.",
        "If the driver had applied the brakes in time, the accident would have been avoided. - රියදුරු නියම වේලාවට තිරිංග තද කළා නම් අනතුර වළක්වා ගැනීමට තිබුණි."
      ),
      commonMistake = "❌ If you had study, you would passed -> ✅ If you had studied, you would have passed ('had + V3' සහ 'would have + V3' අනිවාර්යයි)."
    ),

    // 25. Relative Pronoun: Who vs Whom
    EnglishGrammarRuleSummary(
      title = "25. Relative Pronouns: Who vs Whom (කර්තෘ හා කර්ම)",
      category = EnglishSkillCategory.RELATIVE_CLAUSES,
      formula = "Who + Verb (Subject role) | Whom + Subject + Verb (Object role)",
      explanationSinhala = "ක්‍රියාව කරන පුද්ගලයා (Subject) විස්තර කිරීමට 'Who' ද, ක්‍රියාවට ලක්වන පුද්ගලයා (Object) විස්තර කිරීමට 'Whom' ද යෙදේ.",
      examples = listOf(
        "The teacher who teaches us English is very kind. - අපට ඉංග්‍රීසි උගන්වන ගුරුතුමා ඉතා කරුණාවන්තය.",
        "The girl whom you met yesterday is my sister. - ඔබට ඊයේ හමුවූ දැරිය මගේ සහෝදරියයි."
      ),
      commonMistake = "❌ The boy which won the race -> ✅ The boy who won the race (මිනිසුන් සඳහා which නොයෙදේ)."
    ),

    // 26. Relative Pronoun: Which vs That
    EnglishGrammarRuleSummary(
      title = "26. Relative Pronouns: Which vs That (ද්‍රව්‍ය හා සතුන්)",
      category = EnglishSkillCategory.RELATIVE_CLAUSES,
      formula = "Which (for things/animals in non-essential clauses) | That (for essential clauses)",
      explanationSinhala = "අජීවී ද්‍රව්‍ය සහ සතුන් සම්බන්ධ කිරීමට 'which' හෝ 'that' භාවිත වේ. කමාවලින් වෙන්වන අතිරේක තොරතුරුවලට 'which' පමණක් යොදයි.",
      examples = listOf(
        "The laptop which my father bought has 16GB RAM. - මගේ පියා මිලදී ගත් ලැප්ටොප් පරිගණකයේ 16GB RAM ඇත.",
        "This is the novel that won the state literary award. - රාජ්‍ය සාහිත්‍ය සම්මානය දිනාගත් නවකතාව මෙයයි."
      ),
      commonMistake = "❌ The car who is parked outside -> ✅ The car which is parked outside (අජීවී දේට who නොයෙදේ)."
    ),

    // 27. Relative Pronoun: Whose
    EnglishGrammarRuleSummary(
      title = "27. Relative Pronoun: Whose (අයිතිය දැක්වීම)",
      category = EnglishSkillCategory.RELATIVE_CLAUSES,
      formula = "Noun + whose + Noun (Possession - 'කාගේද')",
      explanationSinhala = "යම් දෙයක හෝ පුද්ගලයෙකුගේ අයිතිය සම්බන්ධ කර දැක්වීමට 'whose' (ඔහුගේ/ඇයගේ/කාගේද) යොදයි.",
      examples = listOf(
        "The student whose essay won first place received a gold medal. - රචනය ප්‍රථම ස්ථානය දිනූ ශිෂ්‍යයාට රන් පදක්කමක් හිමිවිය.",
        "I met a friend whose father is a famous doctor. - පියා ප්‍රසිද්ධ වෛද්‍යවරයකු වන මිතුරෙකු මට හමුවිය."
      ),
      commonMistake = "❌ The man who's car -> ✅ The man whose car ('who's' යනු who is වේ; අයිතියට 'whose' යෙදිය යුතුය)."
    ),

    // 28. Relative Pronoun: Where & When
    EnglishGrammarRuleSummary(
      title = "28. Relative Adverbs: Where & When (ස්ථාන හා වේලාව)",
      category = EnglishSkillCategory.RELATIVE_CLAUSES,
      formula = "Place + where + clause | Time + when + clause",
      explanationSinhala = "ස්ථානයක් විස්තර කිරීමට 'where' ද, වේලාවක් හෝ කාල පරිච්ඡේදයක් විස්තර කිරීමට 'when' ද යෙදේ.",
      examples = listOf(
        "This is the school where I studied in my childhood. - මෙය මගේ කුඩා කාලයේ මා ඉගෙනුම ලැබූ පාසලයි.",
        "I still remember the day when we won the championship. - අපි ශූරතාව දිනාගත් දිනය මට තවමත් මතකය."
      ),
      commonMistake = "❌ The town which I was born -> ✅ The town where I was born (ස්ථානයක් තුළ සිදුවීමකට where යොදන්න)."
    ),

    // 29. Question Tags: Positive Statement -> Negative Tag
    EnglishGrammarRuleSummary(
      title = "29. Question Tags: Positive to Negative (ධන ප්‍රකාශ)",
      category = EnglishSkillCategory.QUESTION_TAGS,
      formula = "Positive Statement , Auxiliary Verb + n't + Pronoun ?",
      explanationSinhala = "වාක්‍යය ධන (positive) නම්, අවසානයේ එන Question Tag එක සෘණ (negative) විය යුතුය. ආධාරක ක්‍රියා පදය ගෙන එයට n't එකතු කරයි.",
      examples = listOf(
        "She is an intelligent student, isn't she? - ඇය බුද්ධිමත් ශිෂ්‍යාවකි, එසේ නොවේද?",
        "They have completed their syllabus, haven't they? - ඔවුන් තම විෂය නිර්දේශය සම්පූර්ණ කර ඇත, එසේ නොවේද?",
        "He speaks fluent English, doesn't he? - ඔහු චතුර ලෙස ඉංග්‍රීසි කතා කරයි, එසේ නොවේද?"
      ),
      commonMistake = "❌ He lives in Galle, isn't he? -> ✅ He lives in Galle, doesn't he? (සාමාන්‍ය ක්‍රියා පද සඳහා does/do/did යෙදේ)."
    ),

    // 30. Question Tags: Negative Statement -> Positive Tag
    EnglishGrammarRuleSummary(
      title = "30. Question Tags: Negative to Positive (සෘණ ප්‍රකාශ)",
      category = EnglishSkillCategory.QUESTION_TAGS,
      formula = "Negative Statement , Auxiliary Verb + Pronoun ?",
      explanationSinhala = "වාක්‍යය සෘණ (not, never, hardly, scarcely) නම්, Question Tag එක ධන (positive) විය යුතුය.",
      examples = listOf(
        "They do not eat meat, do they? - ඔවුන් මස් අනුභව නොකරති, එසේ නේද?",
        "Kasun cannot swim, can he? - කසුන්ට පිහිනීමට නොහැක, එසේ නේද?",
        "She never tells lies, does she? - ඇය කිසිවිටෙකත් බොරු නොකියයි, එසේ නේද?"
      ),
      commonMistake = "❌ She never comes, doesn't she? -> ✅ She never comes, does she? ('never' ඇති බැවින් ටැගය ධන විය යුතුය)."
    ),

    // 31. Question Tags: Special Cases (I am, Let's, Imperatives)
    EnglishGrammarRuleSummary(
      title = "31. Question Tags: Special Exceptions (විශේෂ අවස්ථා)",
      category = EnglishSkillCategory.QUESTION_TAGS,
      formula = "I am -> aren't I? | Let's -> shall we? | Imperative -> will you?",
      explanationSinhala = "I am සමඟ 'amn't I' වෙනුවට 'aren't I?' යෙදේ. 'Let's' යෙදුණු විට 'shall we?' ද, විධාන වාක්‍යවලට 'will you?' ද යෙදේ.",
      examples = listOf(
        "I am late for the assembly, aren't I? - මම රැස්වීමට ප්‍රමාදයි, එසේ නොවේද?",
        "Let's plant some trees in the school garden, shall we? - අපි පාසල් වත්තේ පැල කිහිපයක් සිටුවමු, එසේ නේද?",
        "Close the door quietly, will you? - නිහඬව දොර වසන්න, එසේ කරනවා නේද?"
      ),
      commonMistake = "❌ I am right, amn't I? -> ✅ I am right, aren't I? (ඉංග්‍රීසි ව්‍යාකරණයේ 'amn't I' නොයෙදේ)."
    ),

    // 32. Prepositions of Time: At, On, In
    EnglishGrammarRuleSummary(
      title = "32. Prepositions of Time: At, On, In (කාල නිපාත)",
      category = EnglishSkillCategory.PREPOSITIONS,
      formula = "At (exact time) | On (days/dates) | In (months/years/seasons)",
      explanationSinhala = "නිශ්චිත වේලාවකට 'at' (at 7:00 AM, at night), දින සහ දින වකවානුවලට 'on' (on Monday, on 5th May), මාස, අවුරුදු හා දීර්ඝ කාලවලට 'in' (in July, in 2026, in summer) යෙදේ.",
      examples = listOf(
        "The class starts at 8:00 AM sharp. - පන්තිය හරියටම උදෑසන 8:00 ට ආරම්භ වේ.",
        "We have an English test on Friday. - අපට සිකුරාදා දින ඉංග්‍රීසි පරීක්ෂණයක් ඇත.",
        "The O/L examination will be held in December. - සාමාන්‍ය පෙළ විභාගය දෙසැම්බර් මාසයේ පැවැත්වේ."
      ),
      commonMistake = "❌ In Monday -> ✅ On Monday | ❌ On 2026 -> ✅ In 2026."
    ),

    // 33. Prepositions of Place: At, On, In
    EnglishGrammarRuleSummary(
      title = "33. Prepositions of Place: At, On, In (ස්ථාන නිපාත)",
      category = EnglishSkillCategory.PREPOSITIONS,
      formula = "At (specific point) | On (surface) | In (enclosed space/city/country)",
      explanationSinhala = "නිශ්චිත ලක්ෂ්‍යයකට 'at' (at the bus stop), මතුපිටකට 'on' (on the table), ආවරණය වූ ස්ථානයකට, නගරයකට හෝ රටකට 'in' (in the room, in Kandy, in Sri Lanka) යෙදේ.",
      examples = listOf(
        "He is waiting at the school gate. - ඔහු පාසල් ගේට්ටුව අසල රැඳී සිටියි.",
        "The books are arranged on the desk. - පොත් මේසය මත පිළිවෙලට තබා ඇත.",
        "We live in a beautiful village in Nuwara Eliya. - අපි නුවරඑළියේ සුන්දර ගමක ජීවත් වෙමු."
      ),
      commonMistake = "❌ She lives at Colombo -> ✅ She lives in Colombo (විශාල නගර සඳහා 'in' යෙදිය යුතුය)."
    ),

    // 34. Between vs Among
    EnglishGrammarRuleSummary(
      title = "34. Prepositions: Between vs Among (දෙදෙනෙකු හා රැසක්)",
      category = EnglishSkillCategory.PREPOSITIONS,
      formula = "Between (strictly two persons/things) | Among (more than two)",
      explanationSinhala = "පුද්ගලයන් හෝ ද්‍රව්‍ය දෙකක් අතර නම් 'between' ද, දෙදෙනෙකුට වඩා වැඩි පිරිසක් අතර නම් 'among' ද භාවිත වේ.",
      examples = listOf(
        "The prize money was divided equally between Kasun and Amal. - ත්‍යාග මුදල කසුන් සහ අමල් අතර සමව බෙදා දෙන ලදී.",
        "The teacher distributed the sweets among all the students. - ගුරුතුමිය සියලුම සිසුන් අතර රසකැවිලි බෙදා දුන්නාය."
      ),
      commonMistake = "❌ Divided among the two brothers -> ✅ Divided between the two brothers (දෙදෙනෙකුට 'between' පමණි)."
    ),

    // 35. Prepositions: Since vs For
    EnglishGrammarRuleSummary(
      title = "35. Prepositions: Since vs For (කාල ආරම්භය හා කාල සීමාව)",
      category = EnglishSkillCategory.PREPOSITIONS,
      formula = "Since + Starting Point of Time | For + Duration / Period of Time",
      explanationSinhala = "ක්‍රියාව ආරම්භ වූ නිශ්චිත දිනය හෝ වේලාව දැක්වීමට 'since' (since 2018, since morning) ද, ගතවූ මුළු කාල ප්‍රමාණය දැක්වීමට 'for' (for 3 days, for 5 years) ද යොදයි.",
      examples = listOf(
        "I have been learning English since 2015. - මම 2015 වසරේ සිට ඉංග්‍රීසි ඉගෙන ගනිමින් සිටිමි.",
        "She has lived in this town for ten years. - ඇය වසර දහයක් පුරා මෙම නගරයේ ජීවත් වී ඇත."
      ),
      commonMistake = "❌ For 2015 -> ✅ Since 2015 | ❌ Since three years -> ✅ For three years."
    ),

    // 36. Phrasal Verbs: Essential Exam Verbs
    EnglishGrammarRuleSummary(
      title = "36. Phrasal Verbs: Essential O/L Verbs (ක්‍රියා පද ඛණ්ඩ)",
      category = EnglishSkillCategory.PREPOSITIONS,
      formula = "Verb + Preposition / Adverb -> Creates a brand new meaning",
      explanationSinhala = "ක්‍රියා පදයකට නිපාතයක් එක්වීමෙන් සෑදෙන විශේෂ අර්ථ සහිත පදයි. උදා: look after (බලාගන්නවා), give up (අත්හරිනවා), put off (කල්දමනවා).",
      examples = listOf(
        "You should never give up your dreams. - ඔබ කිසිවිටෙකත් ඔබේ සිහින අත් නොහැරිය යුතුය.",
        "Elder siblings must look after their younger ones. - වැඩිමහල් සහෝදර සහෝදරියන් බාලයන්ව රැකබලා ගත යුතුය.",
        "Due to bad weather, the sports meet was put off. - අයහපත් කාලගුණය හේතුවෙන් ක්‍රීඩා උළෙල කල් දමන ලදී."
      ),
      commonMistake = "❌ Put out the meeting -> ✅ Put off the meeting ('put out' යනු ගින්නක් නිවීමයි; කල් දැමීමට 'put off' යෙදේ)."
    ),

    // 37. Conjunctions of Contrast: Although / Even Though / Though
    EnglishGrammarRuleSummary(
      title = "37. Conjunctions: Although & Even though (විරුද්ධ අදහස්)",
      category = EnglishSkillCategory.CONJUNCTIONS,
      formula = "Although / Even though + Subject + Verb , Main Clause",
      explanationSinhala = "පරස්පර හෝ නොසිතූ අදහස් දැක්වීමට 'Although' හෝ 'Even though' යොදයි. මේවාට පසුපසින් අනිවාර්යයෙන්ම සම්පූර්ණ වාක්‍යාංශයක් (Subject + Verb) තිබිය යුතුය.",
      examples = listOf(
        "Although he was poor, he was completely honest. - ඔහු දුප්පත් වුවද, ඔහු අතිශයින් අවංක විය.",
        "Even though it rained heavily, we attended school. - තද වැසි පැවතියද, අපි පාසල් ගියෙමු."
      ),
      commonMistake = "❌ Although he was poor, but he was honest -> ✅ Although he was poor, he was honest ('Although' ඇති විට 'but' නොයෙදේ)."
    ),

    // 38. Conjunctions: Despite and In Spite Of
    EnglishGrammarRuleSummary(
      title = "38. Conjunctions: Despite & In spite of (නාම පද සමඟ)",
      category = EnglishSkillCategory.CONJUNCTIONS,
      formula = "Despite / In spite of + Noun / Pronoun / (Verb + ing)",
      explanationSinhala = "මේවායින්ද පරස්පරතාව දැක්වෙන නමුත්, මේවා පසුපස Subject + Verb වෙනුවට නාම පදයක් හෝ V-ing රූපයක් පමණක් යෙදේ.",
      examples = listOf(
        "Despite the heavy traffic, we reached the exam hall on time. - අධික රථවාහන තදබදය පැවතියද, අපි නියම වේලාවට විභාග ශාලාවට ළඟා වීමු.",
        "In spite of being ill, she scored top marks. - අසනීපයෙන් සිටියද ඇය ඉහළම ලකුණු ලබා ගත්තාය."
      ),
      commonMistake = "❌ Despite of the rain -> ✅ Despite the rain ('Despite' සමඟ 'of' කිසිසේත්ම නොයෙදේ)."
    ),

    // 39. Correlative Conjunctions: Either...or / Neither...nor
    EnglishGrammarRuleSummary(
      title = "39. Correlative Conjunctions: Either...or & Neither...nor",
      category = EnglishSkillCategory.CONJUNCTIONS,
      formula = "Either A or B (එකක් හෝ අනෙක) | Neither A nor B (දෙකම නැත)",
      explanationSinhala = "විකල්ප දෙකකින් එකක් තෝරා ගැනීමට 'Either...or' ද, විකල්ප දෙකම නැති බව දැක්වීමට 'Neither...nor' ද යෙදේ. ක්‍රියා පදය ළඟම ඇති කර්තෘට අනුව තීරණය වේ.",
      examples = listOf(
        "You can either write an essay or deliver a speech. - ඔබට රචනයක් ලිවීමට හෝ කතාවක් පැවැත්වීමට හැකිය.",
        "Neither Kasun nor his friends were present yesterday. - කසුන්වත් ඔහුගේ මිතුරන්වත් ඊයේ පැමිණ සිටියේ නැත."
      ),
      commonMistake = "❌ Neither Kasun or Amal -> ✅ Neither Kasun nor Amal ('Neither' සමඟ 'nor' පමණක් යෙදිය යුතුය)."
    ),

    // 40. Conjunctions: Not only... but also
    EnglishGrammarRuleSummary(
      title = "40. Conjunctions: Not only... but also (එපමණක් නොව... ද)",
      category = EnglishSkillCategory.CONJUNCTIONS,
      formula = "Not only + Quality A + but also + Quality B",
      explanationSinhala = "යම් දෙයකට හෝ පුද්ගලයෙකුට ගුණාංග දෙකක්ම හෝ ක්‍රියාවන් දෙකක්ම අදාළ වන විට මෙය යොදයි.",
      examples = listOf(
        "She is not only intelligent but also very hardworking. - ඇය බුද්ධිමත් පමණක් නොව ඉතා මහන්සි වී වැඩ කරන්නියක්ද වේ.",
        "The project not only saves money but also protects nature. - මෙම ව්‍යාපෘතිය මුදල් ඉතිරි කරනවා පමණක් නොව පරිසරයද ආරක්ෂා කරයි."
      ),
      commonMistake = "❌ Not only smart but hardworking -> ✅ Not only smart but also hardworking ('also' අමතක නොකරන්න)."
    ),

    // 41. Modal Verbs: Can, Could, Be able to
    EnglishGrammarRuleSummary(
      title = "41. Modals of Ability: Can, Could & Be able to (හැකියාව)",
      category = EnglishSkillCategory.MODALS,
      formula = "Can + V1 (Present ability) | Could + V1 (Past ability) | Will be able to (Future)",
      explanationSinhala = "වර්තමාන හැකියාවට 'can' ද, අතීත හැකියාවට 'could' ද, අනාගත හැකියාවට 'will be able to' ද යොදයි. මූලික ක්‍රියා පදය (V1) පමණක් මේවා පසුපස එයි.",
      examples = listOf(
        "She can speak three international languages fluently. - ඇයට ජාත්‍යන්තර භාෂා තුනක් චතුර ලෙස කතා කළ හැක.",
        "When I was five, I could swim across the river. - මට වයස පහේදී ගඟ හරහා පිහිනීමට හැකියාව තිබුණි."
      ),
      commonMistake = "❌ He can speaks English -> ✅ He can speak English ('can' පසුපස ක්‍රියා පදයට 's' නොයෙදේ)."
    ),

    // 42. Modal Verbs: Must vs Have to vs Should
    EnglishGrammarRuleSummary(
      title = "42. Modals of Obligation: Must, Have to & Should (වගකීම් හා උපදෙස්)",
      category = EnglishSkillCategory.MODALS,
      formula = "Must (strong inner obligation) | Have to (external rule) | Should (advice)",
      explanationSinhala = "අනිවාර්ය නීති සඳහා 'must' හෝ 'have to' ද, මිත්‍රශීලී උපදෙස් සඳහා 'should' (කළ යුතුයි) ද යොදයි.",
      examples = listOf(
        "Students must wear their school uniforms during school hours. - පාසල් වේලාව තුළ සිසුන් තම නිල ඇඳුම ඇඳිය යුතුය.",
        "You should read English storybooks every day. - ඔබ දිනපතා ඉංග්‍රීසි කතන්දර පොත් කියවිය යුතුය."
      ),
      commonMistake = "❌ You should to study -> ✅ You should study ('should' පසුපස 'to' නොයෙදේ)."
    ),

    // 43. Subject-Verb Agreement: Basic Rules
    EnglishGrammarRuleSummary(
      title = "43. Subject-Verb Agreement: Singular & Plural (කර්තෘ-ක්‍රියා එකඟතාව)",
      category = EnglishSkillCategory.ERROR_CORRECTION,
      formula = "Singular Subject -> Singular Verb (is/was/has/V-s) | Plural Subject -> Plural Verb (are/were/have/V1)",
      explanationSinhala = "කර්තෘ ඒකවචන නම් ක්‍රියා පදයද ඒකවචන විය යුතුය (verb + s). කර්තෘ බහුවචන නම් ක්‍රියා පදයද බහුවචන විය යුතුය.",
      examples = listOf(
        "The quality of these mangoes is excellent. - මෙම අඹවල ගුණාත්මකභාවය විශිෂ්ටයි. (Subject is 'quality', not 'mangoes')",
        "The boys in our class play cricket very well. - අපේ පන්තියේ පිරිමි ළමයි ඉතා හොඳින් ක්‍රිකට් ක්‍රීඩා කරති."
      ),
      commonMistake = "❌ The list of books are ready -> ✅ The list of books is ready ('list' යනු ඒකවචනයකි)."
    ),

    // 44. Subject-Verb Agreement: Each, Every, Everyone
    EnglishGrammarRuleSummary(
      title = "44. Agreement: Each, Every & Everyone (සෑම කෙනෙක්ම)",
      category = EnglishSkillCategory.ERROR_CORRECTION,
      formula = "Each / Every / Everyone / Nobody + Singular Verb (is / has / V-s)",
      explanationSinhala = "Each, every, everyone, everybody, nobody, someone වැනි වචන ඉංග්‍රීසි භාෂාවේදී ඒකවචන ලෙස සැලකෙන බැවින් සෑම විටම ඒකවචන ක්‍රියා පදයක් ගනී.",
      examples = listOf(
        "Each of the students was given a certificate. - සෑම සිසුවෙකුටම සහතික පත්‍රයක් ලබා දෙන ලදී.",
        "Everyone wants to achieve good exam results. - සෑම කෙනෙකුටම හොඳ විභාග ප්‍රතිඵල ලබා ගැනීමට අවශ්‍යයි."
      ),
      commonMistake = "❌ Everyone are happy -> ✅ Everyone is happy ('everyone' සඳහා 'is' යෙදිය යුතුය)."
    ),

    // 45. Gerunds vs Infinitives
    EnglishGrammarRuleSummary(
      title = "45. Gerunds (Verb-ing) vs Infinitives (To + Verb)",
      category = EnglishSkillCategory.VOCABULARY,
      formula = "Gerund: V-ing as Noun | Infinitive: to + Base Verb (V1)",
      explanationSinhala = "නාම පදයක් ලෙස යෙදෙන ක්‍රියා පදයේ -ing රූපය Gerund නම් වේ (Swimming is good). සමහර ක්‍රියා පද පසුපස Gerund එන අතර (enjoy, avoid, mind) සමහර ඒවාට Infinitive (want, hope, promise to go) එයි.",
      examples = listOf(
        "Reading English newspapers improves vocabulary. - ඉංග්‍රීසි පුවත්පත් කියවීම වචන මාලාව වැඩිදියුණු කරයි.",
        "I want to improve my spoken English skills. - මට මගේ කථන ඉංග්‍රීසි කුසලතා දියුණු කර ගැනීමට අවශ්‍යයි.",
        "She enjoys listening to classical music. - ඇය ශාස්ත්‍රීය සංගීතයට සවන් දීමට ප්‍රිය කරයි."
      ),
      commonMistake = "❌ I enjoy to swim -> ✅ I enjoy swimming ('enjoy' පසුපස gerund -ing එයි)."
    ),

    // 46. Articles: A vs An vs The
    EnglishGrammarRuleSummary(
      title = "46. Articles: Indefinite (A, An) & Definite (The)",
      category = EnglishSkillCategory.VOCABULARY,
      formula = "A (consonant sound) | An (vowel sound) | The (specific/unique things)",
      explanationSinhala = "ස්වර ශබ්ද (a, e, i, o, u ශබ්ද) ඉදිරියට 'an' (an apple, an honest man) ද, ව්‍යංජන ශබ්ද ඉදිරියට 'a' ද, ලෝකයේ එකක් පමණක් ඇති හෝ කලින් සඳහන් කළ නිශ්චිත දේට 'the' ද යෙදේ.",
      examples = listOf(
        "He is an honest police officer. - ඔහු අවංක පොලිස් නිලධාරියෙකි. ('h' නිහඬ බැවින් ස්වර ශබ්දයකි)",
        "The moon shines brightly at night. - සඳ රාත්‍රියේ දීප්තිමත්ව බබළයි.",
        "She studies at a university in Sri Lanka. - ඇය ශ්‍රී ලංකාවේ විශ්වවිද්‍යාලයක ඉගෙනුම ලබයි."
      ),
      commonMistake = "❌ An university -> ✅ A university ('yu' ව්‍යංජන ශබ්දය බැවින් 'a' යෙදේ)."
    ),

    // 47. Order of Adjectives (OSASCOMP)
    EnglishGrammarRuleSummary(
      title = "47. Order of Adjectives: OSASCOMP (විශේෂණ අනුපිළිවෙල)",
      category = EnglishSkillCategory.VOCABULARY,
      formula = "Opinion -> Size -> Age -> Shape -> Color -> Origin -> Material -> Purpose",
      explanationSinhala = "නාම පදයකට පෙර විශේෂණ පද කිහිපයක් යෙදීමේදී සම්මත පිළිවෙල: අදහස (Opinion) -> ප්‍රමාණය (Size) -> වයස (Age) -> හැඩය (Shape) -> වර්ණය (Color) -> සම්භවය (Origin) -> ද්‍රව්‍යය (Material) -> කාර්යය (Purpose).",
      examples = listOf(
        "She bought a beautiful small wooden box. - ඇය ලස්සන කුඩා ලී පෙට්ටියක් මිලදී ගත්තාය. (Opinion -> Size -> Material)",
        "He wore an expensive new black leather jacket. - ඔහු මිල අධික අලුත් කළු සම් ජැකට්ටුවක් පැළඳ සිටියේය."
      ),
      commonMistake = "❌ A wooden beautiful box -> ✅ A beautiful wooden box."
    ),

    // 48. Comparison of Adjectives: Positive, Comparative, Superlative
    EnglishGrammarRuleSummary(
      title = "48. Comparison of Adjectives: -er / -est / more / most",
      category = EnglishSkillCategory.VOCABULARY,
      formula = "Comparative: -er / more ... than | Superlative: the ... -est / the most ...",
      explanationSinhala = "දෙදෙනෙකු සංසන්දනයට Comparative (taller than / more expensive than) ද, සියල්ලන් අතරින් ඉහළම දැක්වීමට Superlative (the tallest / the most expensive) ද යොදයි.",
      examples = listOf(
        "Piduruthalagala is the highest mountain in Sri Lanka. - පිදුරුතලාගල ශ්‍රී ලංකාවේ උසම කන්දයි.",
        "Gold is more valuable than silver. - රත්තරන් රිදීවලට වඩා වටිනාකමින් වැඩිය."
      ),
      commonMistake = "❌ More taller -> ✅ Taller (more සහ -er එකවර නොයොදන්න)."
    ),

    // 49. Inversion with Negative Adverbs
    EnglishGrammarRuleSummary(
      title = "49. Inversion for Emphasis (අවධාරණය සඳහා පෙරළීම)",
      category = EnglishSkillCategory.ERROR_CORRECTION,
      formula = "Negative Adverb (Seldom / Never / Hardly) + Auxiliary + Subject + Verb",
      explanationSinhala = "Seldom, Never, Rarely, Hardly, Barely වැනි වචන වාක්‍යය ආරම්භයේ යොදා ප්‍රකාශය අවධාරණය කිරීමේදී ප්‍රශ්න වාක්‍යයක මෙන් ආධාරක ක්‍රියා පදය මුලට පැමිණේ.",
      examples = listOf(
        "Never have I seen such a breathtaking waterfall. - මා එවැනි මනරම් දියඇල්ලක් මින් පෙර කිසිදිනෙක දැක නැත.",
        "Hardly had we arrived when the show began. - අප පැමිණි වහාම සංදර්ශනය ආරම්භ විය."
      ),
      commonMistake = "❌ Never I have seen -> ✅ Never have I seen (ක්‍රියා පදය කර්තෘට පෙරට පැමිණිය යුතුය)."
    ),

    // 50. Used to vs Be Used to
    EnglishGrammarRuleSummary(
      title = "50. Used to (Past habit) vs Be used to (Accustomed to)",
      category = EnglishSkillCategory.MODALS,
      formula = "Used to + V1 (Past habit no longer true) | Be used to + (V-ing / Noun) (පුරුදු වී සිටිනවා)",
      explanationSinhala = "'Used to + V1' යනු අතීතයේ තිබී දැන් නැති පුරුදුය. 'Be used to + V-ing' යනු වර්තමානයේ යම් දෙයකට හුරු පුරුදු වී සිටින බවයි.",
      examples = listOf(
        "I used to walk to school when I was young. - මම කුඩා කාලයේ පාසලට පයින් යාමට පුරුදුව සිටියෙමි (දැන් එසේ නොවේ).",
        "He is used to waking up early in the morning. - ඔහු උදෑසනින්ම අවදි වීමට හුරු පුරුදු වී සිටියි."
      ),
      commonMistake = "❌ I am used to wake up -> ✅ I am used to waking up ('am used to' පසුපස V-ing යෙදිය යුතුය)."
    )
  )
}
