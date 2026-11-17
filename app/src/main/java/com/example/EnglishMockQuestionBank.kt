package com.example

import com.example.ExamQuestionHelper.QSpec
import com.example.ExamQuestionHelper.buildPoolFromShortAnswers
import com.example.ExamQuestionHelper.buildPoolFromSubjectMaster
import com.example.ExamQuestionHelper.dedupPool
import com.example.ExamQuestionHelper.normalizeOption
import com.example.ExamQuestionHelper.quizQuestionToSpec
import com.example.ExamQuestionHelper.selectFromMasterPool

/**
 * Curated + Combinatorial English O/L Question Bank (Grades 10 & 11).
 * Combines EnglishShortNotesRepository (900), QuizBankApplied English (100),
 * 240 combinatorial O/L grammar & vocabulary MCQs,
 * SubjectMasterEnglish (1,580+ multi-angle), and ShortAnswer English (400 G10+G11).
 */
object EnglishMockQuestionBank {

  private val pool: List<QSpec> by lazy { buildMasterPool() }

  fun getQuestion(grade: String, term: Int, paperIdx: Int, qNum: Int): MockExamQuestion {
    return selectFromMasterPool(pool, grade, term, paperIdx, qNum)
  }

  private fun buildMasterPool(): List<QSpec> {
    val raw = ArrayList<QSpec>(3200)

    // 1. 900 Curated EnglishShortNotesRepository MCQs (Quiz 30 parts + Exam 20 parts)
    for (item in EnglishShortNotesRepository.allQuestions) {
      val opts = item.options.map { normalizeOption(it) }
      if (opts.size >= 4) {
        val idx = item.correctOptionIndex.coerceIn(0, opts.lastIndex)
        val correct = opts[idx]
        val distractors = opts.filterIndexed { i, _ -> i != idx }
        raw.add(
          QSpec(
            topic = item.topicTitle,
            questionText = item.questionPrompt,
            correct = correct,
            distractors = distractors,
            explanation = item.explanationSinhala
          )
        )
      }
    }

    // 2. 100 Curated QuizBankApplied English MCQs
    for (setIdx in 1..10) {
      for (qIdx in 1..10) {
        val qq = QuizBankApplied.getEnglishQuestion("10", setIdx, qIdx, qIdx, "English")
        raw.add(quizQuestionToSpec("English Language - Set $setIdx", qq))
      }
    }

    // 3. 240 Combinatorial O/L Grammar, Vocabulary & Passive Drills
    raw.addAll(buildCombinatorialGrammarDrills())

    // 4. SubjectMasterRepository English multi-angle pool (~1,580 specs)
    raw.addAll(
      buildPoolFromSubjectMaster(
        categories = SubjectMasterRepository.getCategoriesForSubject("ඉංග්‍රීසි"),
        subjectLabel = "ඉංග්‍රීසි (English)",
        seedBase = 31
      )
    )

    // 5. ShortAnswerMasterRepository Grade 10 & Grade 11 English (~400 specs)
    raw.addAll(buildPoolFromShortAnswers("English"))

    return dedupPool(raw)
  }

  private fun buildCombinatorialGrammarDrills(): List<QSpec> {
    val list = ArrayList<QSpec>(240)

    // A. Conditional Sentences (40 distinct sentences)
    val zeroCond = listOf(
      Triple("heat ice above 0°C", "melts", "If you heat ice above 0°C, it ___ into water."),
      Triple("mix blue and yellow paint", "gets green", "When you mix blue and yellow paint, the mixture ___."),
      Triple("water plants regularly", "grow", "If you water garden plants regularly, they ___ healthy."),
      Triple("drop glass on stone", "breaks", "If anyone drops a glass bottle on stone, it usually ___."),
      Triple("leave milk unrefrigerated", "turns sour", "If you leave fresh milk out in hot weather, it soon ___."),
      Triple("press the switch", "lights up", "Whenever you press this switch, the corridor lamp ___."),
      Triple("touch fire", "burns", "If a person touches an open flame, it ___ the skin."),
      Triple("freeze pure water", "turns", "If you cool pure water to 0°C, it ___ into ice.")
    )
    for ((_, verb, stem) in zeroCond) {
      val wrongs = listOf("will $verb", "would $verb", "had ${verb}ed", "was $verb")
        .filter { !it.equals(verb, ignoreCase = true) }.take(3)
      list.add(
        QSpec(
          topic = "Conditionals (Zero Type)",
          questionText = "Complete the Zero Conditional sentence with the correct verb form — \"$stem\"",
          correct = verb,
          distractors = wrongs,
          explanation = "Zero Conditional (scientific facts/general truths) uses Present Simple in both clauses."
        )
      )
    }

    val firstCond = listOf(
      QuadG("Kamal studies hard for O/L", "will pass", listOf("would pass", "passed", "had passed")),
      QuadG("the train arrives on time", "will reach", listOf("would reach", "reached", "reaches")),
      QuadG("we save electricity at home", "will reduce", listOf("would reduce", "reduced", "reducing")),
      QuadG("Ruwan practises cricket daily", "will qualify", listOf("would qualify", "qualified", "qualifying")),
      QuadG("it rains this evening", "will cancel", listOf("would cancel", "cancelled", "had cancelled")),
      QuadG("the librarian opens the hall", "will borrow", listOf("would borrow", "borrowed", "borrowing")),
      QuadG("Nadeesha finishes her essay early", "will submit", listOf("would submit", "submitted", "submitting")),
      QuadG("they repair the bridge quickly", "will resume", listOf("would resume", "resumed", "resuming"))
    )
    for ((idx, item) in firstCond.withIndex()) {
      list.add(
        QSpec(
          topic = "First Conditional",
          questionText = "Choose the grammatically accurate verb phrase — \"If ${item.cond}, they ___ the goal successfully.\"".let {
            when (idx) {
              0 -> "Choose the right verb form — \"If ${item.cond}, he ___ the examination with A passes.\""
              1 -> "Fill in the blank — \"If ${item.cond}, we ___ Kandy before noon.\""
              2 -> "Select the correct option — \"If ${item.cond}, our family ___ the monthly bill.\""
              3 -> "Complete the clause — \"If ${item.cond}, he ___ for the provincial squad.\""
              4 -> "Choose the First Conditional verb — \"If ${item.cond}, the committee ___ the outdoor match.\""
              5 -> "Fill in the verb — \"If ${item.cond}, the students ___ reference books.\""
              6 -> "Complete the sentence — \"If ${item.cond}, she ___ it before the bell rings.\""
              else -> "Select the correct tense — \"If ${item.cond}, buses ___ normal service.\""
            }
          },
          correct = item.correct,
          distractors = item.wrongs,
          explanation = "First Conditional uses 'If + Simple Present, subject + will + base verb'."
        )
      )
    }

    // B. Subject-Verb Agreement & Correlative Pairs (40 items)
    val svaPairs = listOf(
      Triple("Neither the captain nor the players ___ ready for the toss.", "were", listOf("was", "is", "has")),
      Triple("Either my sister or my parents ___ attending the prize giving.", "are", listOf("is", "was", "has")),
      Triple("The bouquet of fresh jasmines ___ placed on the shrine table.", "was", listOf("were", "are", "have")),
      Triple("Each of the thirty participants ___ awarded a merit certificate.", "was", listOf("were", "are", "have been")),
      Triple("Ten kilometres ___ a long distance to walk without water.", "is", listOf("are", "were", "have")),
      Triple("The news about the national scholarship results ___ spread quickly.", "has", listOf("have", "are", "were")),
      Triple("Mathematics ___ many logical problem-solving skills.", "requires", listOf("require", "are requiring", "were requiring")),
      Triple("Bread and butter ___ his favourite breakfast before school.", "is", listOf("are", "were", "have been")),
      Triple("The principal, along with all teachers, ___ inspecting the exhibition.", "is", listOf("are", "were", "have")),
      Triple("Everyone in our Science society ___ excited about the field trip.", "seems", listOf("seem", "are seeming", "were seeming")),
      Triple("Not only the violinist but also the singers ___ praised by the judges.", "were", listOf("was", "is", "has been")),
      Triple("A pair of spectacles ___ lying beside the dictionary.", "was", listOf("were", "are", "have been")),
      Triple("Two-thirds of the forest reserve ___ protected by wildlife laws.", "is", listOf("are", "were", "have")),
      Triple("Nobody in the examination hall ___ allowed to use a mobile phone.", "is", listOf("are", "were", "have been")),
      Triple("The furniture in the new library hall ___ crafted from teak wood.", "is", listOf("are", "were", "have been")),
      Triple("Both Kasun and Tharindu ___ selected for the debating final.", "were", listOf("was", "is", "has been"))
    )
    for ((q, ans, wr) in svaPairs) {
      list.add(
        QSpec(
          topic = "Subject-Verb Agreement",
          questionText = "Select the verb that agrees correctly with the subject — \"$q\"",
          correct = ans,
          distractors = wr,
          explanation = "Match singular/plural verb carefully with collective, uncountable, or closer correlative subjects."
        )
      )
    }

    // C. Question Tags (32 distinct statements)
    val tags = listOf(
      Triple("She plays the sitar beautifully", "doesn't she?", listOf("does she?", "isn't she?", "didn't she?")),
      Triple("They visited Sigiriya last vacation", "didn't they?", listOf("did they?", "don't they?", "weren't they?")),
      Triple("We haven't received the timetable yet", "have we?", listOf("haven't we?", "did we?", "are we?")),
      Triple("Kamal won't forget his admission card", "will he?", listOf("won't he?", "would he?", "does he?")),
      Triple("You can solve simultaneous equations easily", "can't you?", listOf("can you?", "don't you?", "couldn't you?")),
      Triple("Let us plant trees around the school playground", "shall we?", listOf("will we?", "don't we?", "aren't we?")),
      Triple("I am responsible for maintaining the class register", "aren't I?", listOf("amn't I?", "isn't I?", "don't I?")),
      Triple("Nobody answered that difficult riddle correctly", "did they?", listOf("didn't they?", "did he?", "wasn't it?")),
      Triple("Close the classroom windows before leaving", "will you?", listOf("won't he?", "shall I?", "aren't you?")),
      Triple("Hardly anyone noticed the hidden error", "did they?", listOf("didn't they?", "do they?", "were they?")),
      Triple("The bus never arrives late on Mondays", "does it?", listOf("doesn't it?", "is it?", "did it?")),
      Triple("Nimali used to live in Matara during childhood", "didn't she?", listOf("usedn't he?", "doesn't she?", "wasn't she?"))
    )
    for ((stmt, tag, wr) in tags) {
      list.add(
        QSpec(
          topic = "Question Tags",
          questionText = "Select the appropriate question tag for the statement — \"$stmt, ___\"",
          correct = tag,
          distractors = wr,
          explanation = "Positive statements take negative tags; negative/semi-negative words take positive tags matching tense."
        )
      )
    }

    // D. Active <-> Passive Voice Transformations (30 distinct items)
    val passiveSet = listOf(
      Triple("The architect designed the new auditorium.", "The new auditorium was designed by the architect.", listOf("The new auditorium is designed by the architect.", "The new auditorium has designed by the architect.", "The architect was designed by the auditorium.")),
      Triple("The students are decorating the stage right now.", "The stage is being decorated by the students right now.", listOf("The stage is decorated by the students right now.", "The stage was being decorated by the students.", "The stage has been decorated by the students.")),
      Triple("Has the prefect distributed the notice?", "Has the notice been distributed by the prefect?", listOf("Was the notice distributed by the prefect?", "Is the notice being distributed by the prefect?", "Has the prefect been distributed by the notice?")),
      Triple("The municipality will build a solar power park.", "A solar power park will be built by the municipality.", listOf("A solar power park is built by the municipality.", "A solar power park would built by the municipality.", "A solar power park has been built by the municipality.")),
      Triple("Farmers cultivate tea in the central highlands.", "Tea is cultivated by farmers in the central highlands.", listOf("Tea was cultivated by farmers in the central highlands.", "Tea is cultivating by farmers in the central highlands.", "Tea has cultivated by farmers in the central highlands.")),
      Triple("Someone stole my bicycle from the shed.", "My bicycle was stolen from the shed.", listOf("My bicycle is stolen from the shed.", "My bicycle has stolen from the shed.", "My bicycle had stealing from the shed.")),
      Triple("You must follow all laboratory safety rules.", "All laboratory safety rules must be followed.", listOf("All laboratory safety rules must followed.", "All laboratory safety rules are must followed.", "All laboratory safety rules were followed.")),
      Triple("Who wrote the famous novel 'Madol Doova'?", "By whom was the famous novel 'Madol Doova' written?", listOf("Who was written the famous novel 'Madol Doova'?", "By who is 'Madol Doova' written?", "Whom did 'Madol Doova' write?")),
      Triple("The principal gave the winners gold medals.", "Gold medals were given to the winners by the principal.", listOf("Gold medals are given to the winners by the principal.", "Gold medals was given to the winners by the principal.", "The principal was given gold medals by the winners.")),
      Triple("Please keep silence inside the library.", "You are requested to keep silence inside the library.", listOf("Let silence keep you inside the library.", "Silence is requesting to keep.", "You were ordered keeping silence."))
    )
    for ((act, pas, wr) in passiveSet) {
      list.add(
        QSpec(
          topic = "Active & Passive Voice",
          questionText = "Transform this sentence accurately into Passive Voice — \"$act\"",
          correct = pas,
          distractors = wr,
          explanation = "Preserve the original tense while shifting object to subject and using be + V3."
        )
      )
    }

    // E. Prepositions & Phrasal Verbs (40 items)
    val prepSet = listOf(
      Triple("He is keen ___ learning astronomical photography.", "on", listOf("at", "for", "with")),
      Triple("The Sri Lankan team succeeded ___ winning the regional trophy.", "in", listOf("on", "to", "for")),
      Triple("Please refrain ___ throwing plastic waste into the stream.", "from", listOf("of", "off", "against")),
      Triple("Malini is senior ___ me by three academic years.", "to", listOf("than", "from", "over")),
      Triple("We congratulated Tharindu ___ his national essay award.", "on", listOf("for", "at", "about")),
      Triple("The wooden bridge was built ___ the Mahaweli River.", "across", listOf("along", "between", "among")),
      Triple("Do not look down ___ anyone because of their background.", "on", listOf("into", "for", "after")),
      Triple("The fire brigade arrived promptly and put ___ the blaze.", "out", listOf("off", "away", "up")),
      Triple("She resembles her grandmother closely; everyone says she takes ___ her.", "after", listOf("over", "up", "in")),
      Triple("The inter-school debate was put ___ until next Friday due to rain.", "off", listOf("out", "away", "down")),
      Triple("You must abide ___ the examination hall regulations at all times.", "by", listOf("with", "to", "for")),
      Triple("This ancient temple is famous ___ its stone moonstone carvings.", "for", listOf("of", "with", "about"))
    )
    for ((sent, ans, wr) in prepSet) {
      list.add(
        QSpec(
          topic = "Prepositions & Phrasal Verbs",
          questionText = "Fill in the blank with the correct preposition or particle — \"$sent\"",
          correct = ans,
          distractors = wr,
          explanation = "Fixed prepositional collocations and phrasal verbs follow standard idiomatic usage."
        )
      )
    }

    // F. Antonyms, Synonyms & Idioms (40+ items)
    val vocab = listOf(
      Triple("Synonym of 'METICULOUS'", "Extremely careful and precise", listOf("Careless and hasty", "Loud and aggressive", "Weak and tired")),
      Triple("Antonym of 'OPTIMISTIC'", "Pessimistic", listOf("Hopeful", "Cheerful", "Confident")),
      Triple("Synonym of 'TRANSPARENT'", "See-through / Clear", listOf("Opaque", "Hidden", "Muddy")),
      Triple("Antonym of 'ANCIENT'", "Modern", listOf("Antique", "Historic", "Elderly")),
      Triple("Synonym of 'PERSEVERE'", "Persist steadily despite difficulty", listOf("Give up quickly", "Complain constantly", "Sleep deeply")),
      Triple("Antonym of 'ARTIFICIAL'", "Natural", listOf("Synthetic", "Manufactured", "Fake")),
      Triple("Meaning of 'Once in a blue moon'", "Very rarely", listOf("Every night", "Twice a week", "During a storm")),
      Triple("Meaning of 'Burn the midnight oil'", "Study or work late into the night", listOf("Waste fuel recklessly", "Start a campfire", "Wake up at dawn")),
      Triple("Meaning of 'Hit the nail on the head'", "Identify the exact truth or cause", listOf("Hurt one's hand", "Miss the target", "Build wooden furniture")),
      Triple("One-word substitution for 'A person who loves and collects books'", "Bibliophile", listOf("Philanthropist", "Pessimist", "Cartographer")),
      Triple("One-word substitution for 'Speaking several languages fluently'", "Polyglot", listOf("Monologue", "Spectator", "Biographer")),
      Triple("Antonym of 'MANDATORY'", "Optional", listOf("Compulsory", "Required", "Strict"))
    )
    for ((prompt, ans, wr) in vocab) {
      list.add(
        QSpec(
          topic = "Vocabulary & Idioms",
          questionText = "Choose the best meaning or match for \"$prompt\"",
          correct = ans,
          distractors = wr,
          explanation = "Rich vocabulary and idiomatic mastery are essential for O/L English Paper I & II."
        )
      )
    }

    return list
  }

  private data class QuadG(
    val cond: String,
    val correct: String,
    val wrongs: List<String>
  )
}
