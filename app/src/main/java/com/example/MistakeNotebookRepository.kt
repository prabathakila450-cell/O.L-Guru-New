package com.example

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

data class MistakeItem(
  val id: String,
  val subject: String,
  val topic: String,
  val grade: String,
  val questionText: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanation: String,
  val userWrongAnswerIndex: Int = -1,
  val addedTimestamp: Long = System.currentTimeMillis(),
  val isMastered: Boolean = false,
  val masteredTimestamp: Long? = null
)

data class MistakeSummary(
  val total: Int,
  val pending: Int,
  val mastered: Int,
  val masteryRate: Float,
  val bySubject: Map<String, Int>
)

object MistakeNotebookRepository {
  private const val PREFS_NAME = "ol_mistake_notebook_store"
  private const val KEY_MISTAKES = "saved_mistakes_json"
  private const val KEY_INITIALIZED = "mistakes_preloaded_v1"

  private val initialSeedMistakes = listOf(
    MistakeItem(
      id = "seed_sci_01",
      subject = "විද්‍යාව",
      topic = "ප්‍රකාශ විද්‍යාව (කෝණාන්තර හා කාච)",
      grade = "11",
      questionText = "උත්තල කාචයක නාභිය (F) සහ ප්‍රකාශ කේන්ද්‍රය (O) අතර තබා ඇති වස්තුවක් මඟින් සාදනු ලබන ප්‍රතිබිම්බයේ ස්වභාවය කුමක්ද?",
      options = listOf(
        "සත්‍ය, යටිකුරු සහ කුඩා වූ",
        "අසත්‍ය, උඩුකුරු සහ විශාලිත",
        "සත්‍ය, යටිකුරු සහ විශාලිත",
        "අසත්‍ය, යටිකුරු සහ සමාන විශාලත්වයෙන් යුත්"
      ),
      correctOptionIndex = 1,
      explanation = "💡 නීතිය: උත්තල කාචයක F සහ O අතර වස්තුවක් තැබූ විට පමණක් 'අසත්‍ය, උඩුකුරු සහ විශාලිත' ප්‍රතිබිම්බයක් වස්තුව ඇති පැත්තේම සාදයි. අත් කාචයක් (සරල අන්වීක්ෂයක්) ක්‍රියා කරන්නේ මෙම මූලධර්මයෙනි.",
      userWrongAnswerIndex = 2
    ),
    MistakeItem(
      id = "seed_sci_02",
      subject = "විද්‍යාව",
      topic = "රසායනික ප්‍රතික්‍රියා හා තාපය",
      grade = "10",
      questionText = "ජලයට සාන්ද්‍ර සල්ෆියුරික් අම්ලය (H2SO4) එක් කිරීමේදී සිදුවන්නේ කුමන ආකාරයේ ශක්ති විපර්යාසයක්ද?",
      options = listOf(
        "තාප අවශෝෂක ප්‍රතික්‍රියාවකි (උෂ්ණත්වය පහළ යයි)",
        "තාප දායක ප්‍රතික්‍රියාවකි (උෂ්ණත්වය සීඝ්‍රයෙන් ඉහළ යයි)",
        "තාප විපර්යාසයක් සිදු නොවේ",
        "ආලෝක ශක්තිය අවශෝෂණය වන ප්‍රතික්‍රියාවකි"
      ),
      correctOptionIndex = 1,
      explanation = "💡 නීතිය: ජලයට සාන්ද්‍ර අම්ල තනුක කිරීමේදී දැඩි ලෙස තාපය පිටවන (තාපදායක - Exothermic) ක්‍රියාවලියකි. එබැවින් අම්ලයට ජලය නොදමා, සෑමවිටම ජලයට අම්ලය බිංදුව බැගින් එක් කළ යුතුය.",
      userWrongAnswerIndex = 0
    ),
    MistakeItem(
      id = "seed_math_01",
      subject = "ගණිතය",
      topic = "ජ්‍යාමිතිය (වෘත්ත ප්‍රමේය)",
      grade = "11",
      questionText = "වෘත්තයක එකම චාපය මත කේන්ද්‍රයේ ආපාතනය කරන කෝණය, පරිධියේ ඉතිරි කොටස මත ආපාතනය කරන කෝණය මෙන් කොපමණද?",
      options = listOf(
        "සමාන වේ",
        "දෙගුණයක් වේ (2x)",
        "අඩක් වේ (1/2)",
        "හතර ගුණයක් වේ"
      ),
      correctOptionIndex = 1,
      explanation = "💡 ජ්‍යාමිතික ප්‍රමේයය: වෘත්තයක කිසියම් චාපයකින් කේන්ද්‍රයෙහි ආපාතනය කරන කෝණය, එම චාපයෙන්ම පරිධිය මත ආපාතනය කරන කෝණය මෙන් දෙගුණයකි. කේන්ද්‍ර කෝණය = 2 × පරිධි කෝණය.",
      userWrongAnswerIndex = 2
    ),
    MistakeItem(
      id = "seed_math_02",
      subject = "ගණිතය",
      topic = "වර්ගජ සමීකරණ හා සූත්‍රය",
      grade = "11",
      questionText = "ax² + bx + c = 0 වර්ගජ සමීකරණයේ මූල සෙවීමේ නිවැරදි සූත්‍රය කුමක්ද?",
      options = listOf(
        "x = (-b ± √(b² - 4ac)) / (2a)",
        "x = (b ± √(b² - 4ac)) / (2a)",
        "x = (-b ± √(b² + 4ac)) / a",
        "x = (-b ± √(4ac - b²)) / (2a)"
      ),
      correctOptionIndex = 0,
      explanation = "💡 සූත්‍ර නීතිය: ලකුණු වැරදීම් O/L විභාගයේදී බහුලයි! නිවැරදි සූත්‍රය x = [-b ± √(b² - 4ac)] / 2a වේ. මෙහි විවේචකය Δ = b² - 4ac වේ.",
      userWrongAnswerIndex = 1
    ),
    MistakeItem(
      id = "seed_hist_01",
      subject = "ඉතිහාසය",
      topic = "බ්‍රිතාන්‍ය පාලනය හා ව්‍යවස්ථා",
      grade = "11",
      questionText = "ලංකාවේ ප්‍රථම වරට විධායක සභාව සහ ව්‍යවස්ථාදායක සභාව පිහිටුවන ලද්දේ කුමන ප්‍රතිසංස්කරණය මඟින්ද?",
      options = listOf(
        "1910 ක්‍රෲව්-මැකලම් ප්‍රතිසංස්කරණය",
        "1833 කෝල්බෲක්-කැමරන් ප්‍රතිසංස්කරණය",
        "1931 ඩොනමෝර් ප්‍රතිසංස්කරණය",
        "1947 සෝල්බරි ප්‍රතිසංස්කරණය"
      ),
      correctOptionIndex = 1,
      explanation = "💡 විභාග සටහන: 1833 කෝල්බෲක්-කැමරන් කොමිෂන් වාර්තාව මඟින් ශ්‍රී ලංකාවේ ප්‍රථම වරට විධායක සභාව හා ව්‍යවස්ථාදායක සභාව පිහිටුවන ලද අතර රාජකාරි ක්‍රමයද අහෝසි කෙරිණි.",
      userWrongAnswerIndex = 2
    ),
    MistakeItem(
      id = "seed_eng_01",
      subject = "ඉංග්‍රීසි",
      topic = "Subject-Verb Agreement",
      grade = "11",
      questionText = "Neither the teacher nor the students __________ present at the meeting yesterday.",
      options = listOf(
        "was",
        "were",
        "is",
        "are"
      ),
      correctOptionIndex = 1,
      explanation = "💡 Grammar Rule: When subjects are joined by 'Neither... nor...', the verb agrees with the CLOSER subject. Since 'the students' is plural and the time is 'yesterday', we must use 'were'.",
      userWrongAnswerIndex = 0
    ),
    MistakeItem(
      id = "seed_ict_01",
      subject = "තොරතුරු තාක්ෂණය (ICT)",
      topic = "ද්වීමය හා ෂඩ්දශමය සංඛ්‍යා",
      grade = "11",
      questionText = "දශමය 25 සංඛ්‍යාව ද්වීමය (Binary) ක්‍රමයට හරවන විට ලැබෙන අගය කුමක්ද?",
      options = listOf(
        "11001₂",
        "10101₂",
        "11100₂",
        "10011₂"
      ),
      correctOptionIndex = 0,
      explanation = "💡 ගණනය කිරීම: 25 = 16 + 8 + 1 = 2⁴ + 2³ + 2⁰ = 11001₂ (16, 8, 4, 2, 1 තීරුවල පිළිවෙළින් 1, 1, 0, 0, 1 වේ).",
      userWrongAnswerIndex = 1
    )
  )

  fun getAllMistakes(context: Context): List<MistakeItem> {
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val isInitialized = prefs.getBoolean(KEY_INITIALIZED, false)
    if (!isInitialized) {
      saveList(context, initialSeedMistakes)
      prefs.edit().putBoolean(KEY_INITIALIZED, true).apply()
      return initialSeedMistakes
    }

    val jsonStr = prefs.getString(KEY_MISTAKES, null) ?: return emptyList()
    return try {
      val array = JSONArray(jsonStr)
      val list = mutableListOf<MistakeItem>()
      for (i in 0 until array.length()) {
        val obj = array.getJSONObject(i)
        val optionsArr = obj.getJSONArray("options")
        val options = mutableListOf<String>()
        for (j in 0 until optionsArr.length()) {
          options.add(optionsArr.getString(j))
        }
        list.add(
          MistakeItem(
            id = obj.getString("id"),
            subject = obj.getString("subject"),
            topic = obj.optString("topic", ""),
            grade = obj.optString("grade", "11"),
            questionText = obj.getString("questionText"),
            options = options,
            correctOptionIndex = obj.getInt("correctOptionIndex"),
            explanation = obj.getString("explanation"),
            userWrongAnswerIndex = obj.optInt("userWrongAnswerIndex", -1),
            addedTimestamp = obj.optLong("addedTimestamp", System.currentTimeMillis()),
            isMastered = obj.optBoolean("isMastered", false),
            masteredTimestamp = if (obj.has("masteredTimestamp")) obj.getLong("masteredTimestamp") else null
          )
        )
      }
      list
    } catch (e: Exception) {
      initialSeedMistakes
    }
  }

  fun addMistake(context: Context, item: MistakeItem) {
    // Only genuine mistakes allowed (වරදවාගන්නා ප්‍රශ්න පමණි)
    if (item.userWrongAnswerIndex == item.correctOptionIndex) return

    val current = getAllMistakes(context).toMutableList()
    val existingIndex = current.indexOfFirst { it.id == item.id || it.questionText == item.questionText }
    if (existingIndex >= 0) {
      // update with latest attempt
      current[existingIndex] = item.copy(isMastered = false, userWrongAnswerIndex = item.userWrongAnswerIndex)
    } else {
      current.add(0, item)
    }
    // Limit up to 200 mistake questions (උපරිම ප්‍රශ්න 200)
    val trimmed = if (current.size > 200) current.take(200) else current
    saveList(context, trimmed)
  }

  fun addMistakes(context: Context, items: List<MistakeItem>) {
    // Only genuine mistakes allowed (වරදවාගන්නා ප්‍රශ්න පමණි)
    val onlyWrong = items.filter { it.userWrongAnswerIndex != it.correctOptionIndex }
    if (onlyWrong.isEmpty()) return

    val current = getAllMistakes(context).toMutableList()
    for (item in onlyWrong) {
      val existingIndex = current.indexOfFirst { it.id == item.id || it.questionText == item.questionText }
      if (existingIndex >= 0) {
        current[existingIndex] = item.copy(isMastered = false, userWrongAnswerIndex = item.userWrongAnswerIndex)
      } else {
        current.add(0, item)
      }
    }
    // Limit up to 200 mistake questions (උපරිම ප්‍රශ්න 200)
    val trimmed = if (current.size > 200) current.take(200) else current
    saveList(context, trimmed)
  }

  fun markAsMastered(context: Context, id: String, mastered: Boolean) {
    val current = getAllMistakes(context).map {
      if (it.id == id) {
        it.copy(
          isMastered = mastered,
          masteredTimestamp = if (mastered) System.currentTimeMillis() else null
        )
      } else it
    }
    saveList(context, current)
  }

  fun deleteMistake(context: Context, id: String) {
    val current = getAllMistakes(context).filterNot { it.id == id }
    saveList(context, current)
  }

  fun clearAllMastered(context: Context) {
    val current = getAllMistakes(context).filterNot { it.isMastered }
    saveList(context, current)
  }

  fun getSummary(context: Context): MistakeSummary {
    val all = getAllMistakes(context)
    val total = all.size
    val mastered = all.count { it.isMastered }
    val pending = total - mastered
    val rate = if (total > 0) mastered.toFloat() / total else 0f

    val bySubject = mutableMapOf<String, Int>()
    all.filterNot { it.isMastered }.forEach { item ->
      bySubject[item.subject] = (bySubject[item.subject] ?: 0) + 1
    }

    return MistakeSummary(
      total = total,
      pending = pending,
      mastered = mastered,
      masteryRate = rate,
      bySubject = bySubject
    )
  }

  private fun saveList(context: Context, list: List<MistakeItem>) {
    val array = JSONArray()
    for (item in list) {
      val obj = JSONObject()
      obj.put("id", item.id)
      obj.put("subject", item.subject)
      obj.put("topic", item.topic)
      obj.put("grade", item.grade)
      obj.put("questionText", item.questionText)
      val optArr = JSONArray()
      item.options.forEach { optArr.put(it) }
      obj.put("options", optArr)
      obj.put("correctOptionIndex", item.correctOptionIndex)
      obj.put("explanation", item.explanation)
      obj.put("userWrongAnswerIndex", item.userWrongAnswerIndex)
      obj.put("addedTimestamp", item.addedTimestamp)
      obj.put("isMastered", item.isMastered)
      item.masteredTimestamp?.let { obj.put("masteredTimestamp", it) }
      array.put(obj)
    }
    context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
      .edit()
      .putString(KEY_MISTAKES, array.toString())
      .apply()
  }
}
