package com.example

data class PassiveQuizItem(
  val id: String,
  val type: String, // "ACTIVE" or "PASSIVE"
  val sentenceWithBlank: String,
  val sinhalaPrompt: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanation: String
)

object PassiveVoiceQuizRepository {

  fun getQuizItems(): List<PassiveQuizItem> {
    val list = ArrayList<PassiveQuizItem>(500)

    // 1. ACTIVE VOICE QUIZ ITEMS (250 items)
    val activeVerbs = listOf("write", "sing", "play", "help", "learn", "teach", "cook", "clean", "drive", "read")
    val activeTenses = listOf("Simple Present", "Simple Past", "Simple Future", "Present Continuous", "Present Perfect")
    
    for (i in 1..250) {
      val verb = activeVerbs[(i - 1) % activeVerbs.size]
      val tense = activeTenses[(i - 1) % activeTenses.size]
      val subj = if (i % 2 == 0) "He" else "She"
      val obj = "lesson number $i"
      
      val (blankSentence, correctOpt, wrongOpts, sinhala) = when (tense) {
        "Simple Present" -> Quad(
          "$subj ___ $obj every day.",
          if (subj == "He" || subj == "She") {
            when(verb) {
              "write" -> "writes"; "sing" -> "sings"; "play" -> "plays"; "help" -> "helps"; "learn" -> "learns"
              "teach" -> "teaches"; "cook" -> "cooks"; "clean" -> "cleans"; "drive" -> "drives"; else -> "reads"
            }
          } else verb,
          listOf(verb, verb + "s", "is " + verb + "ing", "wrote"),
          "$subj විසින් සෑම දිනකම $obj ලිවීම/කිරීම සිදු කරයි."
        )
        "Simple Past" -> Quad(
          "$subj ___ $obj yesterday.",
          when(verb) {
            "write" -> "wrote"; "sing" -> "sang"; "play" -> "played"; "help" -> "helped"; "learn" -> "learned"
            "teach" -> "taught"; "cook" -> "cooked"; "clean" -> "cleaned"; "drive" -> "drove"; else -> "read"
          },
          listOf(verb, "writes", "has " + verb + "ed", "was " + verb),
          "$subj විසින් ඊයේ $obj සිදු කරන ලදී."
        )
        "Simple Future" -> Quad(
          "$subj will ___ $obj tomorrow.",
          verb,
          listOf("will " + verb, "wrote", "writes", "is " + verb),
          "$subj විසින් හෙට $obj සිදු කරනු ඇත."
        )
        "Present Continuous" -> Quad(
          "$subj is ___ $obj now.",
          verb + "ing",
          listOf(verb, "ed", "will " + verb, "has " + verb),
          "$subj දැන් $obj කරමින් සිටී."
        )
        else -> Quad(
          "$subj has ___ $obj already.",
          when(verb) {
            "write" -> "written"; "sing" -> "sung"; "play" -> "played"; "help" -> "helped"; "learn" -> "learned"
            "teach" -> "taught"; "cook" -> "cooked"; "clean" -> "cleaned"; "drive" -> "driven"; else -> "read"
          },
          listOf(verb, "wrote", "is " + verb, "will " + verb),
          "$subj විසින් දැනටමත් $obj කර අවසන්ය."
        )
      }

      // Ensure 4 unique options including correct
      val ops = mutableSetOf(correctOpt)
      ops.addAll(wrongOpts)
      while (ops.size < 4) {
        ops.add(verb + "ed" + ops.size)
      }
      val shuffledOps = ops.shuffled()
      val correctIdx = shuffledOps.indexOf(correctOpt)

      list.add(
        PassiveQuizItem(
          id = "active_$i",
          type = "ACTIVE",
          sentenceWithBlank = blankSentence,
          sinhalaPrompt = "Active Voice ($tense) - $sinhala",
          options = shuffledOps,
          correctOptionIndex = correctIdx,
          explanation = "නිවැරදි පිළිතුර '$correctOpt' වේ. මෙහි ක්‍රියා පදය $tense කාලයට අනුකූල වේ."
        )
      )
    }

    // 2. PASSIVE VOICE QUIZ ITEMS (250 items)
    val passiveAux = listOf("is", "was", "will be", "is being", "has been")
    val passiveV3 = listOf("written", "sung", "played", "helped", "learned", "taught", "cooked", "cleaned", "driven", "read")

    for (i in 1..250) {
      val aux = passiveAux[(i - 1) % passiveAux.size]
      val v3 = passiveV3[(i - 1) % passiveV3.size]
      val obj = "Task number $i"

      val blankSentence = "$obj ___ $aux $v3 by them."
      val correctOpt = aux
      val wrongOpts = listOf("did", "have", "were", "are").filter { it != aux }

      val ops = mutableSetOf(correctOpt)
      ops.addAll(wrongOpts)
      while (ops.size < 4) {
        ops.add("aux" + ops.size)
      }
      val shuffledOps = ops.shuffled()
      val correctIdx = shuffledOps.indexOf(correctOpt)

      list.add(
        PassiveQuizItem(
          id = "passive_$i",
          type = "PASSIVE",
          sentenceWithBlank = "$obj ___ $v3 by them.",
          sinhalaPrompt = "Passive Voice - ඔවුන් විසින් $obj සිදු කරනු ලබයි/ලදී.",
          options = shuffledOps,
          correctOptionIndex = correctIdx,
          explanation = "නිවැරදි Passive සහායක ක්‍රියාපදය '$correctOpt' වේ."
        )
      )
    }

    return list
  }
}

data class Quad<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
