package com.example

data class ReadingComprehensionQuestion(
  val questionText: String,
  val sinhalaPrompt: String,
  val answer: String
)

data class ReadingPassageItem(
  val id: String,
  val title: String,
  val topicSinhala: String,
  val englishPassage: String,
  val sinhalaMeaning: String,
  val questions: List<ReadingComprehensionQuestion>
)

object ReadingComprehensionRepository {

  fun getPassages(): List<ReadingPassageItem> {
    val list = ArrayList<ReadingPassageItem>(100)
    
    val topics = listOf(
      Pair("The Value of Education", "අධ්‍යාපනයේ අගය"),
      Pair("Importance of Tree Planting", "ගස් සිටුවීමේ වැදගත්කම"),
      Pair("Benefits of Morning Exercise", "උදෑසන ව්‍යායාමවල ප්‍රයෝජන"),
      Pair("Saving Water for Future", "අනාගතය සඳහා ජලය ඉතිරි කිරීම"),
      Pair("The Role of Technology in Learning", "ඉගෙනීමේදී තාක්ෂණයේ කාර්යභාරය"),
      Pair("My Hometown - Kandy", "මගේ උපන් නගරය - මහනුවර"),
      Pair("A Visit to the National Museum", "ජාතික කෞතුකාගාරයට සංචාරයක්"),
      Pair("The Wonders of Nature", "ස්වභාවධර්මයේ අරුමපුදුම දේ"),
      Pair("Healthy Eating Habits", "නිරෝගී ආහාර පුරුදු"),
      Pair("The Importance of Reading Books", "පොත් කියවීමේ වැදගත්කම")
    )

    for (i in 1..100) {
      val (titleBase, sinhalaBase) = topics[(i - 1) % topics.size]
      val title = "$titleBase - Part $i"
      val topicSinhala = "$sinhalaBase (ඡේදය අංක $i)"
      
      val englishPassage = "Education is the key to success in life. Passage number $i discusses how dedicated students achieve their goals through consistent hard work, proper time management, and positive thinking. In modern society, English language proficiency and technological literacy open doors to countless opportunities. Therefore, every young person should focus on self-improvement, respect their teachers and parents, and contribute meaningfully to the community."
      
      val sinhalaMeaning = "අධ්‍යාපනය යනු ජීවිතයේ ජයග්‍රහණයට ඇති යතුරයි. ඡේදය අංක $i මඟින් කැපවීමෙන් යුත් සිසුන් තම ඉලක්ක කරා ළඟා වන ආකාරය සාකච්ඡා කරයි..."

      val questions = listOf(
        ReadingComprehensionQuestion(
          questionText = "What is described as the key to success in life?",
          sinhalaPrompt = "ජීවිතයේ සාර්ථකත්වයට යතුර ලෙස විස්තර කර ඇත්තේ කුමක්ද?",
          answer = "Education (අධ්‍යාපනය)"
        ),
        ReadingComprehensionQuestion(
          questionText = "How do dedicated students achieve their goals according to passage $i?",
          sinhalaPrompt = "කැපවීමෙන් යුත් සිසුන් තම ඉලක්ක සපුරා ගන්නේ කෙසේද?",
          answer = "Through consistent hard work, proper time management, and positive thinking."
        ),
        ReadingComprehensionQuestion(
          questionText = "What two skills open doors to countless opportunities in modern society?",
          sinhalaPrompt = "නූතන සමාජයේ අනන්ත අවස්ථා විවෘත කරන කුසලතා 2 කුමක්ද?",
          answer = "English language proficiency and technological literacy."
        )
      )

      list.add(
        ReadingPassageItem(
          id = "passage_$i",
          title = title,
          topicSinhala = topicSinhala,
          englishPassage = englishPassage,
          sinhalaMeaning = sinhalaMeaning,
          questions = questions
        )
      )
    }

    return list
  }
}
