package com.example

object LanguagesTrueFalseBank {
  fun getSinhalaQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "සිංහල හෝඩිය හා අක්ෂර මාලාව",
        statement = if (batchIndex % 2 == 0) "මිශ්‍ර සිංහල හෝඩියේ මුළු අක්ෂර සංඛ්‍යාව 60 කි."
                    else "ශුද්ධ සිංහල හෝඩියේ (එළු හෝඩිය) අක්ෂර 40 ක් අඩංගු වේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "මිශ්‍ර සිංහල හෝඩිය ස්වර 18 කින් සහ ව්‍යංජන 42 කින් සමන්විත වේ (මුළු අකුරු 60)."
                        else "ශුද්ධ සිංහල හෝඩියේ ඇත්තේ අක්ෂර 32 කි (ස්වර 12, ව්‍යංජන 20).",
        examTrap = "මූර්ධජ 'ණ, ළ' සහ මහාප්‍රාණ අක්ෂර මිශ්‍ර හෝඩියට අයත් වේ."
      ),
      TrueFalseTopicContent(
        unitName = "සන්ධි හා සන්ධි නීති",
        statement = if (batchIndex % 2 == 0) "'නර + ඉඳු = නරින්දු' යනු පෙරසර ලොප් සන්ධියට නිදසුනකි."
                    else "'ගුරු + උපදේශ = ගුරුපදේශ' යනු පරසර ලොප් සන්ධියකි.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "නර (අ) + ඉඳු (ඉ) හි මුල් පදයේ අග ස්වරය (අ) ලොප් වී 'නරින්දු' වේ (පෙරසර ලොප්)."
                        else "ගුරු (උ) + උපදේශ (උ) හිද පෙරසර 'උ' ලොප් වී ගුරුපදේශ වේ.",
        examTrap = "පූර්ව පදයේ අග ස්වරය ලොප් වීම පෙරසර ලොප් වන අතර, පර පදයේ මුල් ස්වරය ලොප් වීම පරසර ලොප් වේ."
      ),
      TrueFalseTopicContent(
        unitName = "සමාස පද හා ප්‍රභේද",
        statement = if (batchIndex % 2 == 0) "'රන් + තැටිය = රන්තැටිය' යනු විශේෂණ විශේෂ්‍ය සමාසයට උදාහරණයකි."
                    else "'අතපය' යනු ද්වන්ද සමාසයට අයත් පදයකි.",
        isTrue = true,
        justification = "රන් (විශේෂණ) + තැටිය (විශේෂ්‍ය) = රන්තැටිය. අත ද පය ද = අතපය (ද්වන්ද සමාසය).",
        examTrap = "ද්වන්ද සමාසයේ පද දෙකම එක හා සමාන වැදගත්කමක් උසුලයි."
      ),
      TrueFalseTopicContent(
        unitName = "ක්‍රියා පද හා විභක්ති",
        statement = if (batchIndex % 2 == 0) "උක්ත කර්තෘ කාරක වාක්‍යයක උක්ත නාම පදය ප්‍රථමා විභක්තියෙන් යෙදේ."
                    else "කර්ම කාරක වාක්‍යයක කර්තෘ පදය ප්‍රථමා විභක්තියෙන් යෙදේ.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "කර්තෘ කාරක වාක්‍යයේ කර්තෘ ප්‍රථමා විභක්තියෙන් (උක්තව) යෙදී ක්‍රියාව හා ලිංග-පුරුෂ ගැලපේ."
                        else "කර්ම කාරක වාක්‍යයේ කර්තෘ තෘතීයා (විසින්) විභක්තියෙන් ද, කර්මය ප්‍රථමා විභක්තියෙන් ද යෙදේ.",
        examTrap = "'ළමයා විසින් පොත කියවනු ලැබේ' යන්නෙහි 'ළමයා විසින්' තෘතීයා විභක්තියයි."
      ),
      TrueFalseTopicContent(
        unitName = "න-ණ, ල-ළ ලේඛන රීති",
        statement = if (batchIndex % 2 == 0) "වර්ගාක්ෂර නීතිය අනුව 'ට, ඨ, ඩ, ඪ' අකුරකට පෙර නාසික්‍යයක් යෙදෙන විට එය මූර්ධජ 'ණ' විය යුතුය (උදා: ඝණ්ටාව, මණ්ඩපය)."
                    else "කෘදන්ත නාම පදවල සෑම විටම දන්තජ 'න' යෙදිය යුතුය.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "ට-වර්ගයේ අක්ෂරයකට පෙර සෑම විටම මූර්ධජ ණ යෙදේ (වර්ගාක්ෂර රීතිය)."
                        else "කෘදන්ත නාම සාදන 'න' ප්‍රත්‍යය බොහෝ විට මූර්ධජ 'ණ' වේ (උදා: ගමන, දැක්ම, කරණ).",
        examTrap = "ත-වර්ගයේ (ත, ථ, ද, ධ) අකුරකට පෙර දන්තජ 'න' යෙදේ (උදා: චන්දනය)."
      )
    )
    val sGradeOffset = when (grade) {
      9 -> 0
      10 -> 2
      11 -> 3
      else -> 0
    }
    val safeIndex = (number - 1 + sGradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "ප්‍රශ්න අංක ${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }

  fun getEnglishQuestion(grade: Int, number: Int, batchIndex: Int, topicIndex: Int): TrueFalseTopicContent {
    val items = listOf(
      TrueFalseTopicContent(
        unitName = "Subject-Verb Agreement",
        statement = if (batchIndex % 2 == 0) "In the sentence 'Every one of the students has arrived', the singular verb 'has' is grammatically correct."
                    else "We say 'Neither of the boys were present yesterday'.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "'Every one' is an indefinite pronoun that takes a singular verb."
                        else "'Neither of' takes a singular verb ('was', not 'were').",
        examTrap = "Phrases like 'one of the...', 'either of...', 'neither of...' always take singular verbs."
      ),
      TrueFalseTopicContent(
        unitName = "Tenses and Aspect",
        statement = if (batchIndex % 2 == 0) "The Present Perfect tense is used for an action completed in the past with a result connected to the present (e.g., 'I have lost my key')."
                    else "The past participle form of the verb 'sing' is 'sang'.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "Present Perfect connects past actions with present consequences."
                        else "The past simple is 'sang', but the past participle is 'sung' (sing - sang - sung).",
        examTrap = "Irregular verbs: do - did - done, write - wrote - written, fly - flew - flown."
      ),
      TrueFalseTopicContent(
        unitName = "Active and Passive Voice",
        statement = if (batchIndex % 2 == 0) "The passive voice of 'She wrote a letter' is 'A letter was written by her'."
                    else "Intransitive verbs like 'sleep', 'arrive', and 'die' can easily be turned into passive voice sentences.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "Object ('a letter') + was/were + past participle ('written') + by + agent."
                        else "Intransitive verbs have no direct object and therefore cannot be converted into the passive voice.",
        examTrap = "Only transitive verbs (verbs taking an object) can have a passive form."
      ),
      TrueFalseTopicContent(
        unitName = "Conditional Sentences",
        statement = if (batchIndex % 2 == 0) "In First Conditional sentences, we use 'If + present simple, will + base verb' (e.g., 'If it rains, we will stay home')."
                    else "The Third Conditional is used to describe real and probable future situations.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "First conditional refers to real and possible future conditions."
                        else "Third conditional (If + had + V3, would have + V3) talks about hypothetical past events that never happened.",
        examTrap = "Zero conditional expresses universal truths (If you heat ice, it melts)."
      ),
      TrueFalseTopicContent(
        unitName = "Prepositions & Collocations",
        statement = if (batchIndex % 2 == 0) "We say 'interested in', 'fond of', and 'good at' in English."
                    else "The correct preposition to use with time is 'She was born on 1998'.",
        isTrue = batchIndex % 2 == 0,
        justification = if (batchIndex % 2 == 0) "These are standard adjective + preposition combinations in English."
                        else "For years and months we use 'in' ('born in 1998'). 'On' is used for specific days and dates ('on Monday', 'on 5th May').",
        examTrap = "'at night', 'in the morning', 'at 5 o'clock'."
      )
    )
    val eGradeOffset = when (grade) {
      9 -> 0
      10 -> 2
      11 -> 4
      else -> 0
    }
    val safeIndex = (number - 1 + eGradeOffset) % items.size
    val base = items[safeIndex]
    val isAlt = ((number - 1) / items.size) % 2 == 1
    if (!isAlt) return base
    return TrueFalseTopicContent(
      unitName = base.unitName,
      statement = "Question #${number}: ${base.unitName} - ${base.statement}",
      isTrue = base.isTrue,
      justification = base.justification,
      examTrap = base.examTrap
    )
  }
}
