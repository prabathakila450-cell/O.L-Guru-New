package com.example

object ShortAnswerGrade11Sets11To20 {

  val sets = listOf(
    QuestionSetInfo(11, "11", "කාණ්ඩය 11: English - Grammar, Conditionals & Speech", "English", "🇬🇧"),
    QuestionSetInfo(12, "12", "කාණ්ඩය 12: ව්‍යාපාර අධ්‍යයනය - කළමනාකරණය හා අලෙවිකරණය", "ව්‍යාපාර", "📊"),
    QuestionSetInfo(13, "13", "කාණ්ඩය 13: ගිණුම්කරණය - මූල්‍ය ප්‍රකාශන හා ගැලපීම්", "ව්‍යාපාර", "💰"),
    QuestionSetInfo(14, "14", "කාණ්ඩය 14: භූගෝල විද්‍යාව - භූ තැටි චලන හා ලෝක දේශගුණය", "භූගෝල විද්‍යාව", "🌍"),
    QuestionSetInfo(15, "15", "කාණ්ඩය 15: පුරවැසි අධ්‍යාපනය - ආණ්ඩුක්‍රම ව්‍යවස්ථාව හා යහපාලනය", "පුරවැසි", "⚖️"),
    QuestionSetInfo(16, "16", "කාණ්ඩය 16: සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය - ක්‍රීඩා හා මානසික සුවය", "සෞඛ්‍යය", "🏃"),
    QuestionSetInfo(17, "17", "කාණ්ඩය 17: කෘෂි හා ආහාර තාක්ෂණය - පසු අස්වනු තාක්ෂණය හා සත්ත්ව පාලනය", "කෘෂි තාක්ෂණය", "🌱"),
    QuestionSetInfo(18, "18", "කාණ්ඩය 18: චිත්‍ර කලාව - පුනරුද කලාව හා ශ්‍රී ලංකා මූර්ති ශිල්පය", "චිත්‍ර කලාව", "🎨"),
    QuestionSetInfo(19, "19", "කාණ්ඩය 19: නර්තනය හා සංගීතය - රාග, තාල හා ශාන්තිකර්ම", "නර්තනය/සංගීතය", "🥁"),
    QuestionSetInfo(20, "20", "කාණ්ඩය 20: ICT - දත්ත සමුදාය, SQL හා පරිගණක ජාල", "ICT", "💻")
  )

  val questions = listOf(
    ShortAnswerQuestion(
      id = 2201,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Conditionals Type 2",
      question = "Complete the second conditional sentence: \"If I had a million dollars, I ______ (travel) around the world.\"",
      keyPoints = listOf("would travel"),
      synonyms = listOf(
        listOf("would travel", "could travel")
      ),
      officialMarkingScheme = "• Correct conditional modal \"would\" + base verb \"travel\" (2 marks)",
      sampleIdealAnswer = "would travel"
    ),
    ShortAnswerQuestion(
      id = 2202,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Conditionals Type 3",
      question = "Complete the third conditional sentence: \"If she had studied harder, she ______ (pass) the examination.\"",
      keyPoints = listOf("would have passed"),
      synonyms = listOf(
        listOf("would have passed", "could have passed")
      ),
      officialMarkingScheme = "• Correct structure \"would have passed\" (2 marks)",
      sampleIdealAnswer = "would have passed"
    ),
    ShortAnswerQuestion(
      id = 2203,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Reported Speech",
      question = "Change into indirect speech: The teacher said, \"Water boils at 100 degrees Celsius.\"",
      keyPoints = listOf("water boils at 100 degrees Celsius"),
      synonyms = listOf(
        listOf("The teacher said that water boils at 100 degrees Celsius", "water boils at 100 degrees Celsius", "that water boils at 100 degrees Celsius")
      ),
      officialMarkingScheme = "• Universal truth remains in present tense: \"that water boils at 100 degrees Celsius\" (2 marks)",
      sampleIdealAnswer = "The teacher said that water boils at 100 degrees Celsius."
    ),
    ShortAnswerQuestion(
      id = 2204,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Passive Voice with Modals",
      question = "Change into passive voice: \"You must submit the assignment on Friday.\"",
      keyPoints = listOf("The assignment must be submitted on Friday"),
      synonyms = listOf(
        listOf("The assignment must be submitted on Friday", "must be submitted on Friday", "assignment must be submitted")
      ),
      officialMarkingScheme = "• Modal passive: \"must be submitted\" (2 marks)",
      sampleIdealAnswer = "The assignment must be submitted on Friday."
    ),
    ShortAnswerQuestion(
      id = 2205,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Prepositions of Place and Direction",
      question = "Fill in the blanks: \"The cat jumped ______ the fence and ran ______ the forest.\"",
      keyPoints = listOf("over", "into"),
      synonyms = listOf(
        listOf("over, into", "over and into", "over / into", "over into")
      ),
      officialMarkingScheme = "• \"over\" for jumping fence (1 mark), \"into\" or \"towards\" for entering the forest (1 mark)",
      sampleIdealAnswer = "over, into"
    ),
    ShortAnswerQuestion(
      id = 2206,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Relative Clauses",
      question = "Combine the sentences using \"whose\": \"The author wrote a bestselling novel. His book won an international prize.\"",
      keyPoints = listOf("The author whose book won an international prize wrote a bestselling novel"),
      synonyms = listOf(
        listOf("The author whose book won an international prize wrote a bestselling novel", "The author whose book won an award wrote a bestseller", "The author, whose book won an international prize, wrote a bestselling novel")
      ),
      officialMarkingScheme = "• Correct relative clause with \"whose book\" (2 marks)",
      sampleIdealAnswer = "The author whose book won an international prize wrote a bestselling novel."
    ),
    ShortAnswerQuestion(
      id = 2207,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Neither ... Nor",
      question = "Combine the two negative statements using \"Neither ... nor\": \"Kamal does not drink tea. Nimal does not drink tea.\"",
      keyPoints = listOf("Neither Kamal nor Nimal drinks tea"),
      synonyms = listOf(
        listOf("Neither Kamal nor Nimal drinks tea", "Neither Kamal nor Nimal drink tea")
      ),
      officialMarkingScheme = "• \"Neither Kamal nor Nimal drinks tea\" (subject-verb agreement singular \"drinks\") (2 marks)",
      sampleIdealAnswer = "Neither Kamal nor Nimal drinks tea."
    ),
    ShortAnswerQuestion(
      id = 2208,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Formal Letter Conventions",
      question = "What is the standard salutation and complimentary close used when writing a formal letter to an unknown recipient?",
      keyPoints = listOf("Dear Sir / Madam", "Yours faithfully"),
      synonyms = listOf(
        listOf("Dear Sir / Madam", "Dear Sir/Madam", "Dear Sir or Madam"),
        listOf("Yours faithfully", "Yours Faithfully")
      ),
      officialMarkingScheme = "• Salutation: Dear Sir/Madam (1 mark)\n• Complimentary close: Yours faithfully (1 mark)",
      sampleIdealAnswer = "Salutation: Dear Sir/Madam. Complimentary close: Yours faithfully."
    ),
    ShortAnswerQuestion(
      id = 2209,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Phrasal Verbs",
      question = "What are the meanings of the phrasal verbs \"give up\" and \"look after\"?",
      keyPoints = listOf("surrender / stop trying", "take care of"),
      synonyms = listOf(
        listOf("surrender / stop trying", "stop trying", "quit", "abandon"),
        listOf("take care of", "care for", "protect")
      ),
      officialMarkingScheme = "• give up = stop doing / quit (1 mark)\n• look after = take care of (1 mark)",
      sampleIdealAnswer = "\"give up\" means to stop doing or surrender. \"look after\" means to take care of someone or something."
    ),
    ShortAnswerQuestion(
      id = 2210,
      grade = "11",
      setNumber = 11,
      subject = "English Language",
      topic = "Subject-Verb Agreement",
      question = "Choose the correct verb: \"Every student in the classroom ______ (is / are) required to wear a badge.\"",
      keyPoints = listOf("is"),
      synonyms = listOf(
        listOf("is", "is required")
      ),
      officialMarkingScheme = "• \"Every\" takes singular verb \"is\" (2 marks)",
      sampleIdealAnswer = "is"
    ),
    ShortAnswerQuestion(
      id = 2211,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "අලෙවිකරණ මිශ්‍රමය (4Ps)",
      question = "භාණ්ඩ අලෙවිකරණයේ එන 4Ps (අලෙවිකරණ මිශ්‍රමයේ අංග 4) සිංහලෙන් සහ ඉංග්‍රීසියෙන් නම් කරන්න.",
      keyPoints = listOf("නිෂ්පාදිතය (Product)", "මිල (Price)", "ස්ථානය (Place)", "ප්‍රවර්ධනය (Promotion)"),
      synonyms = listOf(
        listOf("නිෂ්පාදිතය (Product)", "Product"),
        listOf("මිල (Price)", "Price"),
        listOf("ස්ථානය (Place)", "Place"),
        listOf("ප්‍රවර්ධනය (Promotion)", "Promotion")
      ),
      officialMarkingScheme = "• Product (නිෂ්පාදිතය), Price (මිල), Place (ස්ථානය/බෙදාහැරීම), Promotion (ප්‍රවර්ධනය) (ලකුණු 2)",
      sampleIdealAnswer = "1. නිෂ්පාදිතය (Product). 2. මිල (Price). 3. ස්ථානය / බෙදාහැරීම (Place). 4. ප්‍රවර්ධනය (Promotion)."
    ),
    ShortAnswerQuestion(
      id = 2212,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "කළමනාකරණ කාර්යයන්",
      question = "කළමනාකරණයේ එන ප්‍රධාන කාර්යයන් 4ක් (POLC) නම් කරන්න.",
      keyPoints = listOf("සැලසුම්කරණය", "සංවිධානය කිරීම", "මෙහෙයවීම", "පාලනය"),
      synonyms = listOf(
        listOf("සැලසුම්කරණය", "Planning"),
        listOf("සංවිධානය කිරීම", "Organizing"),
        listOf("මෙහෙයවීම", "Leading", "Directing"),
        listOf("පාලනය", "Controlling")
      ),
      officialMarkingScheme = "• සැලසුම්කරණය, සංවිධානය කිරීම, මෙහෙයවීම සහ පාලනය (ලකුණු 2)",
      sampleIdealAnswer = "1. සැලසුම්කරණය (Planning). 2. සංවිධානය (Organizing). 3. මෙහෙයවීම (Leading). 4. පාලනය (Controlling)."
    ),
    ShortAnswerQuestion(
      id = 2213,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "වෙළඳපොළ පර්යේෂණ",
      question = "ප්‍රාථමික දත්ත (Primary Data) සහ ද්විතීයික දත්ත (Secondary Data) අතර වෙනස කුමක්ද?",
      keyPoints = listOf("පළමු වරට අලුතින් රැස්කිරීම", "දැනටමත් ප්‍රකාශිත මූලාශ්‍රවලින් ලබාගැනීම"),
      synonyms = listOf(
        listOf("පළමු වරට අලුතින් රැස්කිරීම", "මූලිකව රැස් කිරීම"),
        listOf("දැනටමත් ප්‍රකාශිත මූලාශ්‍රවලින් ලබාගැනීම", "පෙර රැස්කළ දත්ත")
      ),
      officialMarkingScheme = "• ප්‍රාථමික දත්ත: නිශ්චිත අරමුණක් සඳහා පළමුවරට ක්ෂේත්‍රයෙන් රැස්කරන දත්ත (ලකුණු 1)\n• ද්විතීයික දත්ත: දැනටමත් වෙනත් අයෙකු විසින් රැස්කර ප්‍රකාශයට පත් කළ දත්ත (ලකුණු 1)",
      sampleIdealAnswer = "ප්‍රාථමික දත්ත යනු අලුතින්ම පළමු වරට රැස් කරන දත්තයි. ද්විතීයික දත්ත යනු පෙර ප්‍රකාශිත වාර්තා/පොත්පත් වලින් ලබාගන්නා දත්තයි."
    ),
    ShortAnswerQuestion(
      id = 2214,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "රක්ෂණ මූලධර්ම",
      question = "රක්ෂණයේ එන \"උපරිම යහපත් විශ්වාසය\" (Utmost Good Faith) සහ \"ක්ෂතිපූර්ණය\" (Indemnity) යනු කුමක්ද?",
      keyPoints = listOf("සියලු වැදගත් තොරතුරු හෙළිදරව් කිරීම", "අලාභයට පමණක් වන්දි ගෙවීම"),
      synonyms = listOf(
        listOf("සියලු වැදගත් තොරතුරු හෙළිදරව් කිරීම", "සත්‍ය තොරතුරු හෙළි කිරීම"),
        listOf("අලාභයට පමණක් වන්දි ගෙවීම", "නැවත මුල් තත්ත්වයට පත් කිරීම", "ලාභ ලැබීමට ඉඩ නොදීම")
      ),
      officialMarkingScheme = "• උපරිම යහපත් විශ්වාසය: සියලු කරුණු වසන් නොකර අනාවරණය කිරීම (ලකුණු 1)\n• ක්ෂතිපූර්ණය: සිදුවූ සැබෑ අලාභයට පමණක් වන්දි ගෙවා මුල් මූල්‍ය තත්ත්වයට පත් කිරීම (ලකුණු 1)",
      sampleIdealAnswer = "උපරිම යහපත් විශ්වාසය යනු සියලු සත්‍ය තොරතුරු වසන් නොකර හෙළි කිරීමයි. ක්ෂතිපූර්ණය යනු සැබෑ අලාභය පමණක් පියවා මුල් තත්ත්වයට පත් කිරීමයි."
    ),
    ShortAnswerQuestion(
      id = 2215,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "ප්‍රවර්ධන මිශ්‍රමය",
      question = "ව්‍යාපාරික ප්‍රවර්ධන මිශ්‍රමයේ (Promotion Mix) ප්‍රධාන මෙවලම් 2ක් නම් කරන්න.",
      keyPoints = listOf("දැන්වීම්කරණය", "පුද්ගලික විකිණීම"),
      synonyms = listOf(
        listOf("දැන්වීම්කරණය", "දැන්වීම්", "Advertising"),
        listOf("පුද්ගලික විකිණීම", "විකුණුම් ප්‍රවර්ධනය", "Sales promotion", "ප්‍රචාරණය")
      ),
      officialMarkingScheme = "• දැන්වීම්කරණය, පුද්ගලික විකිණීම, විකුණුම් ප්‍රවර්ධනය හෝ මහජන සම්බන්ධතා අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. දැන්වීම්කරණය (Advertising). 2. විකුණුම් ප්‍රවර්ධනය (Sales Promotion) හෝ පුද්ගලික විකිණීම."
    ),
    ShortAnswerQuestion(
      id = 2216,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "සන්නාමය (Brand)",
      question = "භාණ්ඩයකට \"සන්නාමයක්\" (Brand) හෝ වෙළඳ ලකුණක් යෙදීමෙන් ව්‍යාපාරයට ලැබෙන වාසි 2ක් ලියන්න.",
      keyPoints = listOf("තරඟකාරී භාණ්ඩවලින් වෙන්කර හඳුනාගත හැකි වීම", "පාරිභෝගික විශ්වාසය ගොඩනැගීම"),
      synonyms = listOf(
        listOf("තරඟකාරී භාණ්ඩවලින් වෙන්කර හඳුනාගත හැකි වීම", "පහසුවෙන් හඳුනාගැනීම"),
        listOf("පාරිභෝගික විශ්වාසය ගොඩනැගීම", "පක්ෂපාතිත්වය වැඩිවීම", "හොඳ නමක් ඇතිවීම")
      ),
      officialMarkingScheme = "• තරඟකාරී නිෂ්පාදනවලින් පහසුවෙන් වෙන්කර හඳුනාගැනීම සහ වෙළඳපොළ පක්ෂපාතීත්වය/විශ්වාසය වැඩිවීම (ලකුණු 2)",
      sampleIdealAnswer = "1. තරඟකාරී වෙනත් භාණ්ඩවලින් තම භාණ්ඩය පහසුවෙන් වෙන්කර හඳුනාගැනීමට හැකිවීම. 2. පාරිභෝගික විශ්වාසය හා පක්ෂපාතීත්වය වර්ධනය වීම."
    ),
    ShortAnswerQuestion(
      id = 2217,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "නායකත්ව ශෛලීන්",
      question = "ප්‍රධාන නායකත්ව ශෛලීන් 3 මොනවාද?",
      keyPoints = listOf("ඒකාධිපති නායකත්වය", "ප්‍රජාතන්ත්‍රවාදී නායකත්වය", "නිදහස් (නිදහස්කාමී) නායකත්වය"),
      synonyms = listOf(
        listOf("ඒකාධිපති නායකත්වය", "Autocratic"),
        listOf("ප්‍රජාතන්ත්‍රවාදී නායකත්වය", "Democratic"),
        listOf("නිදහස් (නිදහස්කාමී) නායකත්වය", "Laissez-faire")
      ),
      officialMarkingScheme = "• ඒකාධිපති, ප්‍රජාතන්ත්‍රවාදී සහ නිදහස්වාදී (Laissez-faire) නායකත්වය (ලකුණු 2)",
      sampleIdealAnswer = "1. ඒකාධිපති නායකත්වය (Autocratic). 2. ප්‍රජාතන්ත්‍රවාදී නායකත්වය (Democratic). 3. නිදහස්කාමී නායකත්වය (Laissez-faire)."
    ),
    ShortAnswerQuestion(
      id = 2218,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "සන්නිවේදන ක්‍රියාවලිය",
      question = "සන්නිවේදන ක්‍රියාවලියේ මූලික පියවර 4 පිළිවෙළින් ලියන්න.",
      keyPoints = listOf("පණිවිඩකරු", "කේතනය", "මාධ්‍යය", "ලබන්නා"),
      synonyms = listOf(
        listOf("පණිවිඩකරු", "Sender"),
        listOf("කේතනය", "Encoding"),
        listOf("මාධ්‍යය", "Medium", "Channel"),
        listOf("ලබන්නා", "Receiver")
      ),
      officialMarkingScheme = "• පණිවිඩකරු (Sender) -> පණිවිඩය/කේතනය -> මාධ්‍යය -> ලබන්නා (Receiver) -> ප්‍රතිපෝෂණය (ලකුණු 2)",
      sampleIdealAnswer = "පණිවිඩකරු (Sender), පණිවිඩය කේතනය, සන්නිවේදන මාධ්‍යය, ලබන්නා (Receiver) සහ ප්‍රතිපෝෂණය."
    ),
    ShortAnswerQuestion(
      id = 2219,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "පාරිභෝගික ආරක්ෂණය",
      question = "ශ්‍රී ලංකාවේ පාරිභෝගික අයිතිවාසිකම් සුරැකීම සඳහා පිහිටුවා ඇති ප්‍රධාන රාජ්‍ය ආයතනය කුමක්ද?",
      keyPoints = listOf("පාරිභෝගික කටයුතු පිළිබඳ අධිකාරිය"),
      synonyms = listOf(
        listOf("පාරිභෝගික කටයුතු පිළිබඳ අධිකාරිය", "CAA", "Consumer Affairs Authority")
      ),
      officialMarkingScheme = "• පාරිභෝගික කටයුතු පිළිබඳ අධිකාරිය (Consumer Affairs Authority) (ලකුණු 2)",
      sampleIdealAnswer = "පාරිභෝගික කටයුතු පිළිබඳ අධිකාරිය (Consumer Affairs Authority - CAA)."
    ),
    ShortAnswerQuestion(
      id = 2220,
      grade = "11",
      setNumber = 12,
      subject = "ව්‍යාපාර අධ්‍යයනය",
      topic = "ඊ-වාණිජ්‍යය (E-Commerce)",
      question = "ඊ-වාණිජ්‍යය (E-Commerce) යනු කුමක්ද? B2C යන්නෙහි තේරුම ලියන්න.",
      keyPoints = listOf("අන්තර්ජාලය හරහා ගනුදෙනු කිරීම", "ව්‍යාපාරයෙන් පාරිභෝගිකයාට"),
      synonyms = listOf(
        listOf("අන්තර්ජාලය හරහා ගනුදෙනු කිරීම", "ඉලෙක්ට්‍රොනික වාණිජ්‍යය"),
        listOf("ව්‍යාපාරයෙන් පාරිභෝගිකයාට", "Business to Consumer", "B2C")
      ),
      officialMarkingScheme = "• ඊ-වාණිජ්‍යය: අන්තර්ජාලය හා ඉලෙක්ට්‍රොනික මාධ්‍ය ඔස්සේ භාණ්ඩ හා සේවා මිලදී ගැනීම හා විකිණීම (ලකුණු 1)\n• B2C: ව්‍යාපාරිකයාගෙන් පාරිභෝගිකයා වෙත (Business to Consumer) (ලකුණු 1)",
      sampleIdealAnswer = "අන්තර්ජාලය සහ ඉලෙක්ට්‍රොනික මාධ්‍ය භාවිතයෙන් භාණ්ඩ හා සේවා වෙළඳාම් කිරීමයි. B2C යනු Business to Consumer (ව්‍යාපාරිකයාගෙන් පාරිභෝගිකයාට) යන්නයි."
    ),
    ShortAnswerQuestion(
      id = 2221,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "දළ ලාභය ගණනය",
      question = "දළ ලාභය ගණනය කිරීමේ සූත්‍රය කුමක්ද? විකුණුම් රු. 100,000 ක් සහ විකුණු භාණ්ඩවල පිරිවැය රු. 60,000 ක් නම් දළ ලාභය කීයද?",
      keyPoints = listOf("දළ ලාභය = විකුණුම් - විකුණු භාණ්ඩවල පිරිවැය", "රු. 40,000"),
      synonyms = listOf(
        listOf("දළ ලාභය = විකුණුම් - විකුණු භාණ්ඩවල පිරිවැය", "විකුණුම් - පිරිවැය"),
        listOf("රු. 40,000", "40,000", "රුපියල් 40000")
      ),
      officialMarkingScheme = "• සූත්‍රය: විකුණුම් - විකුණු භාණ්ඩවල පිරිවැය (ලකුණු 1)\n• අගය: රු. 40,000 (ලකුණු 1)",
      sampleIdealAnswer = "දළ ලාභය = ශුද්ධ විකුණුම් - විකුණු භාණ්ඩවල පිරිවැය. දළ ලාභය = 100,000 - 60,000 = රු. 40,000 කි."
    ),
    ShortAnswerQuestion(
      id = 2222,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "ශුද්ධ ලාභය",
      question = "ශුද්ධ ලාභය (Net Profit) ගණනය කරනු ලබන්නේ කුමන මූල්‍ය ප්‍රකාශනයේද? එහි සූත්‍රය ලියන්න.",
      keyPoints = listOf("ලාභ හෝ අලාභ ප්‍රකාශනය", "ශුද්ධ ලාභය = දළ ලාභය + වෙනත් ආදායම් - වියදම්"),
      synonyms = listOf(
        listOf("ලාභ හෝ අලාභ ප්‍රකාශනය", "ආදායම් ප්‍රකාශනය", "Profit and Loss Account"),
        listOf("ශුද්ධ ලාභය = දළ ලාභය + වෙනත් ආදායම් - වියදම්", "ආදායම් - වියදම්")
      ),
      officialMarkingScheme = "• ප්‍රකාශනය: ආදායම් ප්‍රකාශනය / ලාභ අලාභ ගිණුම (ලකුණු 1)\n• සූත්‍රය: දළ ලාභය + වෙනත් ආදායම් - බෙදාහැරීමේ හා පරිපාලන වියදම් (ලකුණු 1)",
      sampleIdealAnswer = "ලාභ හෝ අලාභ ප්‍රකාශනය (ආදායම් ප්‍රකාශනය). සූත්‍රය: ශුද්ධ ලාභය = දළ ලාභය + වෙනත් ආදායම් - සියලු මෙහෙයුම් වියදම්."
    ),
    ShortAnswerQuestion(
      id = 2223,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "ගෙවිය යුතු වියදම් ගැලපීම",
      question = "වර්ෂය සඳහා ගෙවිය යුතු නමුත් තවම නොගෙවූ වැටුප් රු. 5,000 ක් සඳහා ගැලපුම් ද්විත්ව සටහන කුමක්ද?",
      keyPoints = listOf("වැටුප් ගිණුම හර", "ගෙවිය යුතු වැටුප් ගිණුම බැර"),
      synonyms = listOf(
        listOf("වැටුප් ගිණුම හර", "වැටුප් වියදම් හර"),
        listOf("ගෙවිය යුතු වැටුප් ගිණුම බැර", "ගෙවිය යුතු වැටුප් බැර", "වැටුප් වගකීම බැර")
      ),
      officialMarkingScheme = "• වැටුප් ගිණුම හර රු. 5,000 (ලකුණු 1)\n• ගෙවිය යුතු වැටුප් ගිණුම බැර රු. 5,000 (ලකුණු 1)",
      sampleIdealAnswer = "වැටුප් ගිණුම හර රු. 5,000 / ගෙවිය යුතු වැටුප් ගිණුම (ජංගම වගකීමක් ලෙස) බැර රු. 5,000."
    ),
    ShortAnswerQuestion(
      id = 2224,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "කලින් ගෙවූ වියදම්",
      question = "කලින් ගෙවූ රක්ෂණ ගාස්තු යනු වත්කමක්ද වගකීමක්ද? එය මූල්‍ය තත්ව ප්‍රකාශනයේ දක්වන්නේ කෙසේද?",
      keyPoints = listOf("ජංගම වත්කමක්", "ජංගම වත්කම් යටතේ"),
      synonyms = listOf(
        listOf("ජංගම වත්කමක්", "වත්කමකි", "වත්කමක්"),
        listOf("ජංගම වත්කම් යටතේ", "Current Assets")
      ),
      officialMarkingScheme = "• ජංගම වත්කමක් (ලකුණු 1)\n• මූල්‍ය තත්ව ප්‍රකාශනයේ (ශේෂ පත්‍රයේ) ජංගම වත්කම් යටතේ සටහන් වේ (ලකුණු 1)",
      sampleIdealAnswer = "ජංගම වත්කමකි (Current Asset). එය මූල්‍ය තත්ව ප්‍රකාශනයේ ජංගම වත්කම් යටතේ දැක්වේ."
    ),
    ShortAnswerQuestion(
      id = 2225,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "ක්ෂයවීම් (Depreciation)",
      question = "ස්ථාවර වත්කමක \"ක්ෂයවීම\" (Depreciation) යනු කුමක්ද? ඒ සඳහා පොදු ක්‍රමයක් නම් කරන්න.",
      keyPoints = listOf("භාවිතය හා කාලය ගතවීම නිසා අගය අඩුවීම", "සරල රේඛීය ක්‍රමය"),
      synonyms = listOf(
        listOf("භාවිතය හා කාලය ගතවීම නිසා අගය අඩුවීම", "වත්කමේ පිරිවැය වෙන් කිරීම", "අගය ක්ෂය වීම"),
        listOf("සරල රේඛීය ක්‍රමය", "හීනවන ශේෂ ක්‍රමය", "Straight line method")
      ),
      officialMarkingScheme = "• අර්ථය: භාවිතය, කාලය ඉකුත්වීම හෝ කල් ඉකුත්වීම නිසා ස්ථාවර වත්කමක සිදුවන ධාරිතාව/අගය අඩුවීම (ලකුණු 1)\n• ක්‍රමය: සරල රේඛීය ක්‍රමය හෝ හීනවන ශේෂ ක්‍රමය (ලකුණු 1)",
      sampleIdealAnswer = "භාවිතය සහ කාලය ගතවීම හේතුවෙන් ස්ථාවර වත්කමක වටිනාකම ක්‍රමයෙන් අඩුවීමයි. ක්‍රම: සරල රේඛීය ක්‍රමය හෝ හීනවන ශේෂ ක්‍රමය."
    ),
    ShortAnswerQuestion(
      id = 2226,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "සැක සහිත ණය වෙන්කිරීම",
      question = "වෙළඳ ලැබිය යුතු දෑ (ණයගැතියන්) මත සැක සහිත ණය වෙන්කිරීමක් සිදුකිරීමේ ද්විත්ව සටහන කුමක්ද?",
      keyPoints = listOf("සැක සහිත ණය වියදම් ගිණුම හර", "සැක සහිත ණය සඳහා වෙන්කිරීම් ගිණුම බැර"),
      synonyms = listOf(
        listOf("සැක සහිත ණය වියදම් ගිණුම හර", "ලාභ අලාභ හර"),
        listOf("සැක සහිත ණය සඳහා වෙන්කිරීම් ගිණුම බැර", "සැක සහිත ණය වෙන්කිරීම් බැර")
      ),
      officialMarkingScheme = "• සැක සහිත ණය වියදම් (ලාභ අලාභ) ගිණුම හර (ලකුණු 1)\n• සැක සහිත ණය සඳහා වෙන්කිරීමේ ගිණුම බැර (ලකුණු 1)",
      sampleIdealAnswer = "සැක සහිත ණය වියදම් ගිණුම හර / සැක සහිත ණය සඳහා වෙන්කිරීමේ ගිණුම බැර."
    ),
    ShortAnswerQuestion(
      id = 2227,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "මූල්‍ය තත්ව ප්‍රකාශනය",
      question = "මූල්‍ය තත්ව ප්‍රකාශනයේ (ශේෂ පත්‍රයේ) ප්‍රධාන කොටස් 3 මොනවාද?",
      keyPoints = listOf("වත්කම්", "හිමිකම", "වගකීම්"),
      synonyms = listOf(
        listOf("වත්කම්", "Assets"),
        listOf("හිමිකම", "Equity", "Capital"),
        listOf("වගකීම්", "Liabilities")
      ),
      officialMarkingScheme = "• වත්කම් (ජංගම හා ජංගම නොවන), හිමිකම, වගකීම් (ජංගම හා ජංගම නොවන) (ලකුණු 2)",
      sampleIdealAnswer = "1. වත්කම් (ජංගම නොවන සහ ජංගම). 2. හිමිකම. 3. වගකීම් (ජංගම නොවන සහ ජංගම)."
    ),
    ShortAnswerQuestion(
      id = 2228,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "වැදගත්කමේ සංකල්පය",
      question = "ගිණුම්කරණයේ එන \"ප්‍රවීණතාවය / අනුගාමීත්වය\" (Prudence / Conservatism) සංකල්පය යනු කුමක්ද?",
      keyPoints = listOf("අනාගත පාඩු සඳහා වෙන්කිරීම් කිරීම", "අපේක්ෂිත ලාභ කලින් සටහන් නොකිරීම"),
      synonyms = listOf(
        listOf("අනාගත පාඩු සඳහා වෙන්කිරීම් කිරීම", "පාඩු හඳුනාගැනීම"),
        listOf("අපේක්ෂිත ලාභ කලින් සටහන් නොකිරීම", "ලාභය අතිශයෝක්තියෙන් නොපෙන්වීම")
      ),
      officialMarkingScheme = "• සිදුවිය හැකි සියලු අලාභ සඳහා ප්‍රතිපාදන සැපයිය යුතු අතර, ලැබීමට නියමිත අපේක්ෂිත ලාභ කලින් ආදායම් ලෙස නොසැලකීම (ලකුණු 2)",
      sampleIdealAnswer = "සිදුවිය හැකි පාඩු සඳහා කල්තියා ප්‍රතිපාදන සැලසිය යුතු අතර, ලැබුණු බවට තහවුරු වන තෙක් අපේක්ෂිත අනාගත ලාභ ආදායම් ලෙස නොපෙන්වීමයි."
    ),
    ShortAnswerQuestion(
      id = 2229,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "බැංකු සැසඳුම් ප්‍රකාශනය",
      question = "බැංකු සැසඳුම් ප්‍රකාශනයක් පිළියෙල කිරීමේ ප්‍රධාන අරමුණ කුමක්ද?",
      keyPoints = listOf("මුදල් පොතේ බැංකු ශේෂය සහ බැංකු ප්‍රකාශනයේ ශේෂය අතර වෙනස හඳුනාගෙන සමථයකට පත්කිරීම"),
      synonyms = listOf(
        listOf("මුදල් පොතේ බැංකු ශේෂය සහ බැංකු ප්‍රකාශනයේ ශේෂය අතර වෙනස හඳුනාගෙන සමථයකට පත්කිරීම", "බැංකු ශේෂයන් සැසඳීම", "වෙනස්කම් සෙවීම")
      ),
      officialMarkingScheme = "• මුදල් පොතේ බැංකු තීරුවේ ශේෂය සහ බැංකුවෙන් එවන බැංකු ප්‍රකාශනයේ ශේෂය අතර පවතින වෙනස්කම් හඳුනාගෙන සැසඳීම (ලකුණු 2)",
      sampleIdealAnswer = "මුදල් පොතේ බැංකු තීරුවේ ශේෂය සහ බැංකු ප්‍රකාශනයේ ශේෂය අතර වෙනස්කම් ඇතිවීමට හේතු සොයා ඒවා සංසන්දනය කර සැසඳීමයි."
    ),
    ShortAnswerQuestion(
      id = 2230,
      grade = "11",
      setNumber = 13,
      subject = "ගිණුම්කරණය",
      topic = "ඉදිරිපත් නොකළ චෙක්පත්",
      question = "ඉදිරිපත් නොකළ චෙක්පත් (Unpresented Cheques) යනු මොනවාද?",
      keyPoints = listOf("ව්‍යාපාරය විසින් නිකුත් කළ නමුත් ගෙවීම සඳහා බැංකුවට තවම ඉදිරිපත් නොකළ චෙක්පත්"),
      synonyms = listOf(
        listOf("ව්‍යාපාරය විසින් නිකුත් කළ නමුත් ගෙවීම සඳහා බැංකුවට තවම ඉදිරිපත් නොකළ චෙක්පත්", "නිකුත් කළ මුත් මාරු නොකළ චෙක්පත්")
      ),
      officialMarkingScheme = "• ව්‍යාපාරය විසින් ගෙවීම් සඳහා චෙක්පත් නිකුත් කර මුදල් පොතේ බැර කර ඇතත්, අදාළ පාර්ශ්වය විසින් මුදල් ලබාගැනීමට බැංකුවට ඉදිරිපත් නොකළ චෙක්පත් (ලකුණු 2)",
      sampleIdealAnswer = "ව්‍යාපාරය මඟින් නිකුත් කර මුදල් පොතේ සටහන් කළද, අදාළ පාර්ශ්වය විසින් මුදල් ලබාගැනීමට තවමත් බැංකුවට ඉදිරිපත් කර නොමැති චෙක්පත්ය."
    ),
    ShortAnswerQuestion(
      id = 2231,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "මහාද්වීපික ප්ලාවිත න්‍යාය",
      question = "මහාද්වීපික ප්ලාවිත න්‍යාය (Continental Drift Theory) ඉදිරිපත් කළ විද්‍යාඥයා කවුද? අතීතයේ තිබූ තනි මහා මහාද්වීපය හැඳින්වූ නම කුමක්ද?",
      keyPoints = listOf("ඇල්ෆ්‍රඩ් වෙග්නර්", "පැන්ජියාව"),
      synonyms = listOf(
        listOf("ඇල්ෆ්‍රඩ් වෙග්නර්", "ඇල්ෆ්‍රඩ් වෙජිනර්", "Alfred Wegener"),
        listOf("පැන්ජියාව", "Pangea", "පැන්ජියා")
      ),
      officialMarkingScheme = "• විද්‍යාඥයා: ඇල්ෆ්‍රඩ් වෙග්නර් (Alfred Wegener) (ලකුණු 1)\n• නම: පැන්ජියාව (Pangaea) (ලකුණු 1)",
      sampleIdealAnswer = "ඇල්ෆ්‍රඩ් වෙග්නර් (Alfred Wegener). අතීත මහාද්වීපය \"පැන්ජියාව\" (Pangaea) නම් විය."
    ),
    ShortAnswerQuestion(
      id = 2232,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "තැටි සීමා වර්ග",
      question = "භූ තැටි චලනය වන ආකාර 3 (තැටි සීමා වර්ග 3) නම් කරන්න.",
      keyPoints = listOf("අභිසාරී සීමා (එකිනෙක දෙසට)", "අපසාරී සීමා (එකිනෙකින් ඈතට)", "පරිවර්තන සීමා (එකිනෙක පිරිමදිමින්)"),
      synonyms = listOf(
        listOf("අභිසාරී සීමා (එකිනෙක දෙසට)", "Convergent boundaries"),
        listOf("අපසාරී සීමා (එකිනෙකින් ඈතට)", "Divergent boundaries"),
        listOf("පරිවර්තන සීමා (එකිනෙක පිරිමදිමින්)", "Transform boundaries")
      ),
      officialMarkingScheme = "• අභිසාරී සීමා, අපසාරී සීමා, සහ පරිවර්තන සීමා (ලකුණු 2)",
      sampleIdealAnswer = "1. අභිසාරී තැටි සීමා (එකිනෙක දෙසට චලනය). 2. අපසාරී තැටි සීමා (ඈතට චලනය). 3. පරිවර්තන තැටි සීමා (පැත්තෙන් ලිස්සා යාම)."
    ),
    ShortAnswerQuestion(
      id = 2233,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "ගිනි කඳු සහ භූමිකම්පා",
      question = "ලෝකයේ වැඩිම භූමිකම්පා සහ ගිනිකඳු ක්‍රියාකාරිත්වයක් වාර්තා වන පැසිෆික් සාගරය වටා පිහිටි කලාපය හඳුන්වන නම කුමක්ද?",
      keyPoints = listOf("පැසිෆික් ගිනි වළල්ල"),
      synonyms = listOf(
        listOf("පැසිෆික් ගිනි වළල්ල", "Ring of Fire", "ගිනි වළල්ල", "Pacific Ring of Fire")
      ),
      officialMarkingScheme = "• පැසිෆික් ගිනි වළල්ල (Pacific Ring of Fire) (ලකුණු 2)",
      sampleIdealAnswer = "පැසිෆික් ගිනි වළල්ල (Pacific Ring of Fire)."
    ),
    ShortAnswerQuestion(
      id = 2234,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "සුනාමි ඇතිවීම",
      question = "සුනාමි රළ ඇතිවීමට ප්‍රධාන වශයෙන් බලපාන භූ විද්‍යාත්මක හේතුව කුමක්ද?",
      keyPoints = listOf("මුහුදු පතුලේ සිදුවන ප්‍රබල භූමිකම්පා"),
      synonyms = listOf(
        listOf("මුහුදු පතුලේ සිදුවන ප්‍රබල භූමිකම්පා", "මුහුදු පතුල සිරස්ව විස්ථාපනය වීම", "සාගර පතුලේ භූමිකම්පා")
      ),
      officialMarkingScheme = "• සාගර පතුල ආශ්‍රිතව සිදුවන භූමිකම්පාවක් නිසා සාගර ජල කඳ සිරස් ලෙස හදිසියේ විස්ථාපනය වීම (ලකුණු 2)",
      sampleIdealAnswer = "සාගර පතුලේ ඇතිවන ප්‍රබල භූමිකම්පාවක් (හෝ ගිනිකඳු පිපිරීමක්) මඟින් සාගර ජලය සිරස්ව විස්ථාපනය වීමයි."
    ),
    ShortAnswerQuestion(
      id = 2235,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "ලෝක ප්‍රධාන කඳු පන්ති",
      question = "හිමාලය කඳු පන්තිය සහ ඇන්ඩීස් කඳු පන්තිය පිහිටා ඇති මහාද්වීප පිළිවෙළින් ලියන්න.",
      keyPoints = listOf("ආසියා මහාද්වීපය", "දකුණු ඇමරිකා මහාද්වීපය"),
      synonyms = listOf(
        listOf("ආසියා මහාද්වීපය", "ආසියාව", "Asia"),
        listOf("දකුණු ඇමරිකා මහාද්වීපය", "දකුණු ඇමරිකාව", "South America")
      ),
      officialMarkingScheme = "• හිමාලය: ආසියාව (ලකුණු 1)\n• ඇන්ඩීස්: දකුණු ඇමරිකාව (ලකුණු 1)",
      sampleIdealAnswer = "හිමාලය කඳු පන්තිය ආසියා මහාද්වීපයේ පිහිටා ඇති අතර, ඇන්ඩීස් කඳු පන්තිය දකුණු ඇමරිකා මහාද්වීපයේ පිහිටා ඇත."
    ),
    ShortAnswerQuestion(
      id = 2236,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "ලෝක දේශගුණ කලාප",
      question = "සමකබඩ දේශගුණ කලාපයේ දැකිය හැකි ප්‍රධාන දේශගුණික ලක්ෂණ 2ක් ලියන්න.",
      keyPoints = listOf("වසර පුරා අධික උෂ්ණත්වය", "වසර පුරා දහවල් පසුව ඇදහැලෙන අධික වැසි"),
      synonyms = listOf(
        listOf("වසර පුරා අධික උෂ්ණත්වය", "ඉහළ උෂ්ණත්වය"),
        listOf("වසර පුරා දහවල් පසුව ඇදහැලෙන අධික වැසි", "අධික වර්ෂාපතනය", "සංවහන වැසි")
      ),
      officialMarkingScheme = "• වසර මුළුල්ලේ ඉහළ උෂ්ණත්වයක් (27°C පමණ) පැවතීම සහ දිනපතා පාහේ සවස් කාලයේ සංවහන වැසි ඇදහැලීම (ලකුණු 2)",
      sampleIdealAnswer = "1. වසර පුරා පවතින ඒකාකාරී ඉහළ උෂ්ණත්වය. 2. දහවල් කාලයෙන් පසු දිනපතා පාහේ ලැබෙන අධික සංවහන වර්ෂාව."
    ),
    ShortAnswerQuestion(
      id = 2237,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "ලෝකයේ විශාලතම කාන්තාරය",
      question = "ලෝකයේ විශාලතම උණුසුම් කාන්තාරය කුමක්ද? එය පිහිටා ඇති මහාද්වීපය කුමක්ද?",
      keyPoints = listOf("සහරා කාන්තාරය", "අප්‍රිකා මහාද්වීපය"),
      synonyms = listOf(
        listOf("සහරා කාන්තාරය", "සහරා", "Sahara Desert"),
        listOf("අප්‍රිකා මහාද්වීපය", "අප්‍රිකාව", "Africa")
      ),
      officialMarkingScheme = "• කාන්තාරය: සහරා කාන්තාරය (ලකුණු 1)\n• මහාද්වීපය: අප්‍රිකාව (ලකුණු 1)",
      sampleIdealAnswer = "සහරා කාන්තාරය (Sahara Desert). එය අප්‍රිකා මහාද්වීපයේ පිහිටා ඇත."
    ),
    ShortAnswerQuestion(
      id = 2238,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "ගෝලීය උණුසුම ඉහළ යාම",
      question = "හරිතාගාර ආචරණයට ප්‍රධාන වශයෙන් දායක වන වායු 2ක් නම් කරන්න.",
      keyPoints = listOf("කාබන් ඩයොක්සයිඩ්", "මීතේන්"),
      synonyms = listOf(
        listOf("කාබන් ඩයොක්සයිඩ්", "CO2"),
        listOf("මීතේන්", "CH4", "ජල වාෂ්ප", "නයිට්‍රස් ඔක්සයිඩ්")
      ),
      officialMarkingScheme = "• කාබන් ඩයොක්සයිඩ් (CO2), මීතේන් (CH4), නයිට්‍රස් ඔක්සයිඩ් හෝ ක්ලෝරෝෆ්ලෝරෝකාබන් (CFC) අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. කාබන් ඩයොක්සයිඩ් (CO₂). 2. මීතේන් (CH₄)."
    ),
    ShortAnswerQuestion(
      id = 2239,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "ලෝක ජනගහන ව්‍යාප්තිය",
      question = "ලෝකයේ වැඩිම ජනගහනයක් වෙසෙන රටවල් 2 නම් කරන්න.",
      keyPoints = listOf("ඉන්දියාව", "චීනය"),
      synonyms = listOf(
        listOf("ඉන්දියාව", "India"),
        listOf("චීනය", "China")
      ),
      officialMarkingScheme = "• ඉන්දියාව සහ චීනය (ලකුණු 2)",
      sampleIdealAnswer = "1. ඉන්දියාව. 2. චීනය."
    ),
    ShortAnswerQuestion(
      id = 2240,
      grade = "11",
      setNumber = 14,
      subject = "භූගෝල විද්‍යාව",
      topic = "ගෝලීයකරණය",
      question = "ගෝලීයකරණය (Globalization) යන්නෙන් අදහස් වන්නේ කුමක්ද?",
      keyPoints = listOf("ලෝකයේ රටවල් ආර්ථික, සමාජීය හා සංස්කෘතික වශයෙන් එකිනෙකට තදින් සම්බන්ධ වීම"),
      synonyms = listOf(
        listOf("ලෝකයේ රටවල් ආර්ථික, සමාජීය හා සංස්කෘතික වශයෙන් එකිනෙකට තදින් සම්බන්ධ වීම", "ලෝකය එකම ගම්මානයක් වීම", "Global village")
      ),
      officialMarkingScheme = "• සන්නිවේදනය, වෙළඳාම හා තාක්ෂණය හරහා ලෝකයේ සියලු ජාතීන් සහ රටවල් එකිනෙක අන්තර් සම්බන්ධිත ගෝලීය ගම්මානයක් බවට පත්වීම (ලකුණු 2)",
      sampleIdealAnswer = "තොරතුරු තාක්ෂණය, වෙළඳාම සහ සන්නිවේදනය මඟින් ලෝකයේ රටවල් ආර්ථික, දේශපාලනික හා සංස්කෘතික වශයෙන් අන්තර් රඳා පවතින තනි ඒකකයක් බවට පත්වීමයි."
    ),
    ShortAnswerQuestion(
      id = 2241,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "ශ්‍රී ලංකා ව්‍යවස්ථා ඉතිහාසය",
      question = "ශ්‍රී ලංකාවේ ප්‍රථම වරට සර්වජන ඡන්ද බලය හිමිවූයේ කුමන ආණ්ඩුක්‍රම ප්‍රතිසංස්කරණය යටතේද? ඒ කුමන වර්ෂයේදීද?",
      keyPoints = listOf("ඩොනමෝර් ආණ්ඩුක්‍රමය", "1931"),
      synonyms = listOf(
        listOf("ඩොනමෝර් ආණ්ඩුක්‍රමය", "ඩොනමෝර් කොමිසම", "Donoughmore"),
        listOf("1931", "1931 දී")
      ),
      officialMarkingScheme = "• ආණ්ඩුක්‍රමය: ඩොනමෝර් ආණ්ඩුක්‍රමය (ලකුණු 1)\n• වර්ෂය: 1931 (ලකුණු 1)",
      sampleIdealAnswer = "ඩොනමෝර් ආණ්ඩුක්‍රමය යටතේ 1931 වර්ෂයේදීය."
    ),
    ShortAnswerQuestion(
      id = 2242,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "ජනරජ ව්‍යවස්ථා",
      question = "ශ්‍රී ලංකාවේ පළමුවන ජනරජ ආණ්ඩුක්‍රම ව්‍යවස්ථාව සහ දෙවන ජනරජ ව්‍යවස්ථාව සම්මත වූ වර්ෂ පිළිවෙළින් ලියන්න.",
      keyPoints = listOf("1972", "1978"),
      synonyms = listOf(
        listOf("1972", "1972 ජනරජ ව්‍යවස්ථාව"),
        listOf("1978", "1978 ව්‍යවස්ථාව")
      ),
      officialMarkingScheme = "• පළමුවන ජනරජ ව්‍යවස්ථාව: 1972 (ලකුණු 1)\n• දෙවන ජනරජ ව්‍යවස්ථාව: 1978 (ලකුණු 1)",
      sampleIdealAnswer = "පළමුවන ජනරජ ව්‍යවස්ථාව 1972 දී සහ දෙවන ජනරජ ව්‍යවස්ථාව 1978 දීය."
    ),
    ShortAnswerQuestion(
      id = 2243,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "මූලික අයිතිවාසිකම් උල්ලංඝනය",
      question = "මූලික අයිතිවාසිකමක් උල්ලංඝනය වූ විට පුරවැසියෙකුට නඩු පැවරිය හැක්කේ කුමන අධිකරණයටද? ඒ සඳහා ලබාදී ඇති කාලසීමාව කුමක්ද?",
      keyPoints = listOf("ශ්‍රේෂ්ඨාධිකරණය", "මාසයක් (දින 30ක්) ඇතුළත"),
      synonyms = listOf(
        listOf("ශ්‍රේෂ්ඨාධිකරණය", "Supreme Court"),
        listOf("මාසයක් (දින 30ක්) ඇතුළත", "දින 30", "එක් මසක්")
      ),
      officialMarkingScheme = "• අධිකරණය: ශ්‍රේෂ්ඨාධිකරණය (ලකුණු 1)\n• කාලය: අයිතිවාසිකම කඩවූ දින සිට මාසයක් (දින 30ක්) ඇතුළත (ලකුණු 1)",
      sampleIdealAnswer = "ශ්‍රී ලංකා ශ්‍රේෂ්ඨාධිකරණයටය. අයිතිවාසිකම් කඩවීම සිදුවූ දින සිට මාසයක් (දින 30ක්) ඇතුළත පෙත්සමක් ගොනු කළ යුතුය."
    ),
    ShortAnswerQuestion(
      id = 2244,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "යහපාලන ලක්ෂණ",
      question = "යහපාලනයක (Good Governance) දැකිය හැකි මූලික ලක්ෂණ 2ක් නම් කරන්න.",
      keyPoints = listOf("වගවීම", "පාරදෘශ්‍යභාවය"),
      synonyms = listOf(
        listOf("වගවීම", "Accountability"),
        listOf("පාරදෘශ්‍යභාවය", "Transparency", "නීතියේ ආධිපත්‍යය", "ජන සහභාගීත්වය")
      ),
      officialMarkingScheme = "• වගවීම (Accountability), විනිවිදභාවය/පාරදෘශ්‍යභාවය (Transparency), නීතියේ ආධිපත්‍යය හෝ කාර්යක්ෂමතාව (ලකුණු 2)",
      sampleIdealAnswer = "1. විනිවිදභාවය හෙවත් පාරදෘශ්‍යභාවය (Transparency). 2. ජනතාවට වගවීම (Accountability)."
    ),
    ShortAnswerQuestion(
      id = 2245,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "තොරතුරු දැනගැනීමේ අයිතිය",
      question = "තොරතුරු දැනගැනීමේ අයිතිවාසිකම (RTI) මඟින් පුරවැසියෙකුට ලැබෙන බලය කුමක්ද?",
      keyPoints = listOf("රාජ්‍ය ආයතන සතු පොදු තොරතුරු ලබාගැනීමට ඇති අයිතිය"),
      synonyms = listOf(
        listOf("රාජ්‍ය ආයතන සතු පොදු තොරතුරු ලබාගැනීමට ඇති අයිතිය", "තොරතුරු ලබාගැනීම", "RTI Act")
      ),
      officialMarkingScheme = "• රාජ්‍ය ආයතනවල තීරණ, වියදම් සහ ලේඛන පිළිබඳ තොරතුරු ඉල්ලා ලබාගැනීමට පුරවැසියාට ඇති නීතිමය අයිතිය (ලකුණු 2)",
      sampleIdealAnswer = "රාජ්‍ය ආයතන සතු මහජන වැදගත්කමකින් යුත් තොරතුරු සහ ලිපිගොනු පරීක්ෂා කර ලබාගැනීමට පුරවැසියාට නීත්‍යානුකූලව බලය ලැබේ."
    ),
    ShortAnswerQuestion(
      id = 2246,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "ස්වාධීන කොමිෂන් සභා",
      question = "ආණ්ඩුක්‍රම ව්‍යවස්ථාව යටතේ ස්ථාපිත ස්වාධීන කොමිෂන් සභා 2ක් නම් කරන්න.",
      keyPoints = listOf("ස්වාධීන මැතිවරණ කොමිසම", "ජාතික පොලිස් කොමිසම"),
      synonyms = listOf(
        listOf("ස්වාධීන මැතිවරණ කොමිසම", "මැතිවරණ කොමිෂන් සභාව"),
        listOf("ජාතික පොලිස් කොමිසම", "මානව හිමිකම් කොමිසම", "අල්ලස් කොමිසම", "රාජ්‍ය සේවා කොමිසම")
      ),
      officialMarkingScheme = "• මැතිවරණ කොමිසම, පොලිස් කොමිසම, රාජ්‍ය සේවා කොමිසම, හෝ අල්ලස් හා දූෂණ කොමිසම අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. ස්වාධීන මැතිවරණ කොමිෂන් සභාව. 2. ශ්‍රී ලංකා මානව හිමිකම් කොමිෂන් සභාව (හෝ ජාතික පොලිස් කොමිසම)."
    ),
    ShortAnswerQuestion(
      id = 2247,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "ශ්‍රී ලංකාවේ විදේශ ප්‍රතිපත්තිය",
      question = "ශ්‍රී ලංකාවේ විදේශ ප්‍රතිපත්තියේ ප්‍රධාන පදනම කුමක්ද?",
      keyPoints = listOf("නොබැඳි විදේශ ප්‍රතිපත්තිය"),
      synonyms = listOf(
        listOf("නොබැඳි විදේශ ප්‍රතිපත්තිය", "නොබැඳි පිළිවෙත", "Non-aligned policy", "මිත්‍රශීලී ප්‍රතිපත්තිය")
      ),
      officialMarkingScheme = "• නොබැඳි විදේශ ප්‍රතිපත්තිය (Non-Aligned Policy) සහ සියලු රටවල් සමඟ මිත්‍රශීලීව කටයුතු කිරීම (ලකුණු 2)",
      sampleIdealAnswer = "නොබැඳි විදේශ ප්‍රතිපත්තිය (Non-aligned foreign policy) සහ සියලු ජාතීන් සමඟ සාමකාමී සහජීවනය."
    ),
    ShortAnswerQuestion(
      id = 2248,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "සාර්ක් (SAARC) සංවිධානය",
      question = "දකුණු ආසියානු කලාපීය සහයෝගිතා සංවිධානය (SAARC) පිහිටුවූ වර්ෂය සහ එහි සාමාජික රටවල් ගණන ලියන්න.",
      keyPoints = listOf("1985", "රටවල් 8"),
      synonyms = listOf(
        listOf("1985", "1985 දෙසැම්බර් 8"),
        listOf("රටවල් 8", "සාමාජිකයින් 8", "8")
      ),
      officialMarkingScheme = "• වර්ෂය: 1985 (ලකුණු 1)\n• රටවල් සංඛ්‍යාව: 8 (ලකුණු 1)",
      sampleIdealAnswer = "1985 දී ඩකා නුවරදී ආරම්භ විය. වර්තමාන සාමාජික රටවල් සංඛ්‍යාව 8 කි."
    ),
    ShortAnswerQuestion(
      id = 2249,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "එක්සත් ජාතීන්ගේ සංවිධානය (UN)",
      question = "එක්සත් ජාතීන්ගේ සංවිධානයේ (UN) ප්‍රධාන අරමුණ කුමක්ද? එහි ආරක්ෂක මණ්ඩලයේ ස්ථාවර සාමාජික රටවල් ගණන කීයද?",
      keyPoints = listOf("ජාත්‍යන්තර සාමය සහ ආරක්ෂාව සුරැකීම", "ස්ථාවර සාමාජිකයන් 5"),
      synonyms = listOf(
        listOf("ජාත්‍යන්තර සාමය සහ ආරක්ෂාව සුරැකීම", "ලෝක සාමය රැකීම"),
        listOf("ස්ථාවර සාමාජිකයන් 5", "5", "පහක්")
      ),
      officialMarkingScheme = "• අරමුණ: ජාත්‍යන්තර සාමය හා ආරක්ෂාව තහවුරු කිරීම (ලකුණු 1)\n• ආරක්ෂක මණ්ඩලයේ නිත්‍ය සාමාජිකයින්: 5 (ලකුණු 1)",
      sampleIdealAnswer = "ජාත්‍යන්තර සාමය සහ ආරක්ෂාව පවත්වා ගැනීමයි. ආරක්ෂක මණ්ඩලයේ නිත්‍ය සාමාජික රටවල් 5 කි (ඇමරිකාව, රුසියාව, චීනය, බ්‍රිතාන්‍යය, ප්‍රංශය)."
    ),
    ShortAnswerQuestion(
      id = 2250,
      grade = "11",
      setNumber = 15,
      subject = "පුරවැසි අධ්‍යාපනය",
      topic = "තිරසාර සංවර්ධනය (SDGs)",
      question = "එක්සත් ජාතීන්ගේ සංවිධානය හඳුන්වා දුන් තිරසාර සංවර්ධන ඉලක්ක (SDGs) සංඛ්‍යාව කීයද? ඒවා සපුරාගත යුතු ඉලක්කගත වර්ෂය කුමක්ද?",
      keyPoints = listOf("ඉලක්ක 17", "2030"),
      synonyms = listOf(
        listOf("ඉලක්ක 17", "17ක්", "17"),
        listOf("2030", "2030 වසර")
      ),
      officialMarkingScheme = "• ඉලක්ක සංඛ්‍යාව: 17 (ලකුණු 1)\n• ඉලක්කගත වර්ෂය: 2030 (ලකුණු 1)",
      sampleIdealAnswer = "තිරසාර සංවර්ධන ඉලක්ක 17 කි. ඒවා සපුරාගැනීමට නියමිත වර්ෂය 2030 යි."
    ),
    ShortAnswerQuestion(
      id = 2251,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "මානසික ආතතිය",
      question = "මානසික ආතතිය (Stress) කළමනාකරණය කරගැනීමට භාවිත කළ හැකි ඵලදායී ක්‍රම 2ක් ලියන්න.",
      keyPoints = listOf("භාවනාව හෝ විවේකය ලබාගැනීම", "ව්‍යායාම සහ ක්‍රීඩාවල නිරත වීම"),
      synonyms = listOf(
        listOf("භාවනාව හෝ විවේකය ලබාගැනීම", "ආනාපානසති භාවනාව", "සිත සැහැල්ලු කරගැනීම"),
        listOf("ව්‍යායාම සහ ක්‍රීඩාවල නිරත වීම", "සංගීතයට සවන් දීම", "මිතුරන් සමඟ කතාබස් කිරීම")
      ),
      officialMarkingScheme = "• භාවනාව/හුස්ම ගැනීමේ අභ්‍යාස, නිතිපතා ව්‍යායාම, විනෝදාංශවල යෙදීම හෝ ගැටලු විශ්වාසවන්ත අයෙකුට පැවසීම (ලකුණු 2)",
      sampleIdealAnswer = "1. භාවනාව හෝ හුස්ම ගැනීමේ සැහැල්ලු අභ්‍යාසවල යෙදීම. 2. ක්‍රීඩා හා ශාරීරික ව්‍යායාමවල නිරත වීම හෝ විශ්වාසවන්ත අයෙකුට ගැටලුව ප්‍රකාශ කිරීම."
    ),
    ShortAnswerQuestion(
      id = 2252,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "මත්ද්‍රව්‍ය හා දුම්කොළ හානිය",
      question = "දුම්පානය නිසා ශ්වසන පද්ධතියට සහ හෘදයට සිදුවන හානි 2ක් ලියන්න.",
      keyPoints = listOf("පෙණහලු පිළිකා ඇතිවීම", "ධමනි අවහිර වීම සහ හෘදයාබාධ"),
      synonyms = listOf(
        listOf("පෙණහලු පිළිකා ඇතිවීම", "ශ්වසන ආබාධ", "ඇදුම"),
        listOf("ධමනි අවහිර වීම සහ හෘදයාබාධ", "හෘද රෝග", "අධික රුධිර පීඩනය")
      ),
      officialMarkingScheme = "• පෙණහලු පිළිකා/එම්ෆයිසීමාව (ලකුණු 1)\n• හෘදයාබාධ/රුධිර නාල අවහිර වීම (ලකුණු 1)",
      sampleIdealAnswer = "1. පෙණහලු පිළිකා සහ ශ්වසන මාර්ග ආසාදන. 2. රුධිර නාල සිහින් වී හෘදයාබාධ ඇතිවීමේ අවදානම ඉහළ යාම."
    ),
    ShortAnswerQuestion(
      id = 2253,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "RICE ප්‍රතිකාරය",
      question = "ක්‍රීඩා අනතුරකදී උළුක්කුවක් සඳහා භාවිත කරන \"R.I.C.E\" ප්‍රතිකාරයේ අකුරු 4න් නිරූපණය වන පියවර ලියන්න.",
      keyPoints = listOf("Rest (විවේකය)", "Ice (අයිස් තැබීම)", "Compression (තෙරපීම)", "Elevation (ඔසවා තැබීම)"),
      synonyms = listOf(
        listOf("Rest (විවේකය)", "Rest"),
        listOf("Ice (අයිස් තැබීම)", "Ice"),
        listOf("Compression (තෙරපීම)", "Compression"),
        listOf("Elevation (ඔසවා තැබීම)", "Elevation")
      ),
      officialMarkingScheme = "• Rest (විවේකය), Ice (අයිස් තැබීම), Compression (තද කර බැඳීම), Elevation (උස් කර තැබීම) (ලකුණු 2)",
      sampleIdealAnswer = "R - Rest (විවේකය ලබාදීම), I - Ice (අයිස් තැබීම), C - Compression (මෘදුව තදකර බැඳීම), E - Elevation (හෘද මට්ටමට වඩා ඉහළට ඔසවා තැබීම)."
    ),
    ShortAnswerQuestion(
      id = 2254,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "ශ්‍රී ලංකාවේ ජාතික ක්‍රීඩාව",
      question = "ශ්‍රී ලංකාවේ නිල ජාතික ක්‍රීඩාව කුමක්ද? වොලිබෝල් ක්‍රීඩා පිටියක දිග සහ පළල කොපමණද?",
      keyPoints = listOf("වොලිබෝල්", "මීටර් 18 x 9"),
      synonyms = listOf(
        listOf("වොලිබෝල්", "Volleyball", "වොලිබෝල් ක්‍රීඩාව"),
        listOf("මීටර් 18 x 9", "18m x 9m", "18 x 9")
      ),
      officialMarkingScheme = "• ජාතික ක්‍රීඩාව: වොලිබෝල් (ලකුණු 1)\n• පිටියේ ප්‍රමාණය: දිග මීටර් 18 x පළල මීටර් 9 (ලකුණු 1)",
      sampleIdealAnswer = "ශ්‍රී ලංකාවේ ජාතික ක්‍රීඩාව වොලිබෝල්ය. පිටියේ ප්‍රමාණය දිග මීටර් 18 ක් සහ පළල මීටර් 9 කි."
    ),
    ShortAnswerQuestion(
      id = 2255,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "නෙට්බෝල් ක්‍රීඩාව",
      question = "නෙට්බෝල් කණ්ඩායමක එකවර පිටියේ ක්‍රීඩා කරන ක්‍රීඩිකාවන් සංඛ්‍යාව කීයද? GS සහ GK යන තනතුරු මොනවාද?",
      keyPoints = listOf("ක්‍රීඩිකාවන් 7", "Goal Shooter සහ Goal Keeper"),
      synonyms = listOf(
        listOf("ක්‍රීඩිකාවන් 7", "7 දෙනෙක්", "7"),
        listOf("Goal Shooter සහ Goal Keeper", "ඉලක්ක විදින්නිය සහ ගෝල රකින්නිය")
      ),
      officialMarkingScheme = "• ක්‍රීඩිකාවන්: 7 (ලකුණු 1)\n• තනතුරු: GS = Goal Shooter (ගෝල විදින්නිය), GK = Goal Keeper (ගෝල රකින්නිය) (ලකුණු 1)",
      sampleIdealAnswer = "ක්‍රීඩිකාවන් 7 දෙනෙකි. GS යනු Goal Shooter (ඉලක්ක විදින්නිය) වන අතර GK යනු Goal Keeper (ගෝල රකින්නිය) වේ."
    ),
    ShortAnswerQuestion(
      id = 2256,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "ක්‍රීඩා පුහුණු මූලධර්ම",
      question = "ක්‍රීඩා පුහුණුවේ එන \"අධිභාර මූලධර්මය\" (Overload Principle) යනු කුමක්ද?",
      keyPoints = listOf("සාමාන්‍යයෙන් ඔරොත්තු දෙන මට්ටමට වඩා වැඩි කාර්ය භාරයක් යොදා පුහුණු කිරීම"),
      synonyms = listOf(
        listOf("සාමාන්‍යයෙන් ඔරොත්තු දෙන මට්ටමට වඩා වැඩි කාර්ය භාරයක් යොදා පුහුණු කිරීම", "ශාරීරික ධාරිතාව වැඩි කිරීමට බර වැඩි කිරීම")
      ),
      officialMarkingScheme = "• ශරීරයේ යෝග්‍යතාව වර්ධනය කිරීම සඳහා සාමාන්‍ය මට්ටමට වඩා වැඩි බරක්, වේගයක් හෝ කාලයක් ක්‍රමානුකූලව යොදවා පුහුණු කිරීම (ලකුණු 2)",
      sampleIdealAnswer = "ශරීරය පුරුදු වී ඇති මට්ටමට වඩා වැඩි ශාරීරික කාර්යභාරයක් ක්‍රමානුකූලව යොදවා ශාරීරික යෝග්‍යතාව දියුණු කරගැනීමේ මූලධර්මයයි."
    ),
    ShortAnswerQuestion(
      id = 2257,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "ක්‍රීඩාවේ උණුසුම් වීම (Warm-up)",
      question = "ක්‍රීඩාවකට පෙර \"උණුසුම් වීමේ\" (Warm-up) අභ්‍යාස සිදුකිරීමේ වාසි 2ක් ලියන්න.",
      keyPoints = listOf("මාංශ පේශි අනතුරු අවම වීම", "රුධිර සංසරණය වේගවත් වී ක්‍රියාකාරීත්වය වැඩිවීම"),
      synonyms = listOf(
        listOf("මාංශ පේශි අනතුරු අවම වීම", "ආබාධ වළක්වා ගැනීම", "උළුක්කු වීම වැළකීම"),
        listOf("රුධිර සංසරණය වේගවත් වී ක්‍රියාකාරීත්වය වැඩිවීම", "ශරීර උෂ්ණත්වය වැඩිවීම", "මානසික සූදානම")
      ),
      officialMarkingScheme = "• මාංශ පේශි තුවාල හා උළුක්කු වීම් අවම කිරීම සහ රුධිර සංසරණය/හෘද ස්පන්දනය ක්‍රමානුකූලව වැඩි කිරීම (ලකුණු 2)",
      sampleIdealAnswer = "1. මාංශ පේශි ඇදීම් හා උළුක්කු වීම් වැනි ආබාධ අවම වීම. 2. රුධිර සංසරණය වැඩිවී සිරුර උපරිම ක්‍රියාකාරීත්වයට සූදානම් වීම."
    ),
    ShortAnswerQuestion(
      id = 2258,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "සමාජ රෝග (STDs)",
      question = "ලිංගිකව සම්ප්‍රේෂණය වන ප්‍රධාන ආසාදනයක් (STD) සහ එය වළක්වා ගැනීමට ගත හැකි පියවරක් ලියන්න.",
      keyPoints = listOf("HIV / ඒඩ්ස්", "සුරක්ෂිත චර්යා රටාවන් අනුගමනය කිරීම"),
      synonyms = listOf(
        listOf("HIV / ඒඩ්ස්", "සිෆිලිස්", "ගොනෝරියා"),
        listOf("සුරක්ෂිත චර්යා රටාවන් අනුගමනය කිරීම", "ආරක්ෂිත වීම", "සදාචාරාත්මක හැසිරීම")
      ),
      officialMarkingScheme = "• රෝගය: HIV/AIDS, සිෆිලිස් හෝ ගොනෝරියා (ලකුණු 1)\n• වැළැක්වීම: ආරක්ෂිත ලිංගික සබඳතා, සදාචාර සම්පන්න චර්යාවන් (ලකුණු 1)",
      sampleIdealAnswer = "රෝගය: HIV / ඒඩ්ස් (හෝ සිෆිලිස්). වැළැක්වීම: සදාචාරාත්මක ලිංගික චර්යාවන් සහ රුධිර පාරවිලයනයේදී නිසි පරීක්ෂාව."
    ),
    ShortAnswerQuestion(
      id = 2259,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "ක්‍රීඩා තහනම් උත්තේජක (Doping)",
      question = "ක්‍රීඩාවේදී තහනම් උත්තේජක (Doping) භාවිතය සදාචාර විරෝධී වන්නේ ඇයි?",
      keyPoints = listOf("අසාධාරණ වාසියක් ලබාගැනීම", "ක්‍රීඩකයාගේ සෞඛ්‍යයට දැඩි හානි සිදුවීම"),
      synonyms = listOf(
        listOf("අසාධාරණ වාසියක් ලබාගැනීම", "සාධාරණ තරඟකාරිත්වය නැතිවීම"),
        listOf("ක්‍රීඩකයාගේ සෞඛ්‍යයට දැඩි හානි සිදුවීම", "සිරුරට හානි වීම", "ක්‍රීඩාශීලිත්වයට පටහැනි වීම")
      ),
      officialMarkingScheme = "• ප්‍රතිවාදීන්ට අසාධාරණයක් සිදුවීම සහ ක්‍රීඩකයාගේ සිරුරට හා ජීවිතයට මාරාන්තික හානි සිදුවිය හැකි වීම (ලකුණු 2)",
      sampleIdealAnswer = "එය අනෙක් තරඟකරුවන්ට කරන අසාධාරණයක් වන අතරම, ක්‍රීඩකයාගේ ශරීරයේ අභ්‍යන්තර අවයවවලට දීර්ඝකාලීන මාරාන්තික හානි සිදුකරයි."
    ),
    ShortAnswerQuestion(
      id = 2260,
      grade = "11",
      setNumber = 16,
      subject = "සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය",
      topic = "ජලභීතිකා රෝගය",
      question = "ජලභීතිකා (Rabies) රෝගය බෝවන ආකාරය සහ සුනඛයෙකු සපා කෑ විට කළ යුතු මූලික ප්‍රථමාධාරය කුමක්ද?",
      keyPoints = listOf("ආසාදිත සතෙකු සපා කෑමෙන්", "තුවාලය සබන් යොදා ගලායන ජලයෙන් විනාඩි 10-15ක් සේදීම"),
      synonyms = listOf(
        listOf("ආසාදිත සතෙකු සපා කෑමෙන්", "සපාකෑමෙන්"),
        listOf("තුවාලය සබන් යොදා ගලායන ජලයෙන් විනාඩි 10-15ක් සේදීම", "සබන් දමා ගලායන වතුරෙන් සේදීම")
      ),
      officialMarkingScheme = "• බෝවීම: වෛරසය ආසාදිත සතෙකුගේ ඛේටය තුවාලයක් හරහා ඇතුල් වීමෙන් (ලකුණු 1)\n• ප්‍රථමාධාරය: සබන් යොදා ගලායන වතුරෙන් තුවාලය විනාඩි 10-15 ක් සෝදා රෝහල් ගතවීම (ලකුණු 1)",
      sampleIdealAnswer = "ආසාදිත සතෙකු සපාකෑමෙන් ඛේටය හරහා බෝවේ. ප්‍රථමාධාර: සබන් යොදා ගලායන වතුරෙන් තුවාලය විනාඩි 15ක් පමණ හොඳින් සෝදා වහාම රෝහල් ගතකිරීම."
    ),
    ShortAnswerQuestion(
      id = 2261,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "පසු අස්වනු හානිය",
      question = "ශ්‍රී ලංකාවේ එළවළු සහ පලතුරුවල පසු අස්වනු හානිය සිදුවීමට බලපාන ප්‍රධාන හේතු 2ක් ලියන්න.",
      keyPoints = listOf("නුසුදුසු ඇසුරුම් භාවිතය (පොලිතීන් උර)", "ප්‍රවාහනයේදී සිදුවන තෙරපීම් හා සීරීම්"),
      synonyms = listOf(
        listOf("නුසුදුසු ඇසුරුම් භාවිතය (පොලිතීන් උර)", "වැරදි ඇසුරුම්"),
        listOf("ප්‍රවාහනයේදී සිදුවන තෙරපීම් හා සීරීම්", "ප්‍රවාහන දුර්වලතා", "නුසුදුසු ගබඩා කිරීම")
      ),
      officialMarkingScheme = "• නුසුදුසු ඇසුරුම් (පොලිතීන්/ගෝනි භාවිතය) සහ ප්‍රවාහනයේදී නුසුදුසු ලෙස ගොඩගසා තෙරපීම (ලකුණු 2)",
      sampleIdealAnswer = "1. නුසුදුසු ඇසුරුම් (ගෝනි හා පොලිතීන් උර) භාවිතය. 2. ප්‍රවාහනයේදී අධික ලෙස තෙරපීම හා යාන්ත්‍රික හානි සිදුවීම."
    ),
    ShortAnswerQuestion(
      id = 2262,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "ආහාර කල්තබා ගැනීමේ ක්‍රම",
      question = "ආහාර නරක්වීම වළක්වා කල්තබා ගැනීමට යොදාගන්නා සම්ප්‍රදායික ක්‍රම 2ක් සහ නවීන ක්‍රමයක් ලියන්න.",
      keyPoints = listOf("වියළීම සහ ලුණු දැමීම", "ශීතකරණය හෝ ටින් කිරීම"),
      synonyms = listOf(
        listOf("වියළීම සහ ලුණු දැමීම", "අව්වේ වේළීම", "දුම් ගැසීම"),
        listOf("ශීතකරණය හෝ ටින් කිරීම", "අධිශීතකරණය", "Canning")
      ),
      officialMarkingScheme = "• සම්ප්‍රදායික: වියළීම, ලුණු දැමීම හෝ දුම් ගැසීම (ලකුණු 1)\n• නවීන: අධිශීතකරණය (Freezing) හෝ ටින් කිරීම (Canning) (ලකුණු 1)",
      sampleIdealAnswer = "සම්ප්‍රදායික: අව්වේ වියළීම සහ ලුණු දැමීම. නවීන: අධිශීතකරණය (Freezing) හෝ වායුරෝධීව ටින් කිරීම."
    ),
    ShortAnswerQuestion(
      id = 2263,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "ආරක්ෂිත ගෘහ (Greenhouses)",
      question = "ආරක්ෂිත ගෘහ (හරිතාගාර) තුළ බෝග වගා කිරීමෙන් ලැබෙන ප්‍රධාන වාසි 2ක් ලියන්න.",
      keyPoints = listOf("කාලගුණික බලපෑම්වලින් තොරව වසර පුරා වගා කළ හැකි වීම", "පළිබෝධ හා රෝග හානි අවම වීම"),
      synonyms = listOf(
        listOf("කාලගුණික බලපෑම්වලින් තොරව වසර පුරා වගා කළ හැකි වීම", "කාලගුණයෙන් ආරක්ෂා වීම"),
        listOf("පළිබෝධ හා රෝග හානි අවම වීම", "ඉහළ අස්වැන්නක් ලැබීම")
      ),
      officialMarkingScheme = "• කාලගුණයෙන් තොරව පාලිත පරිසරයක වසර පුරා වගා කිරීම සහ පළිබෝධ හානි අවම වී ගුණාත්මක අස්වැන්නක් ලැබීම (ලකුණු 2)",
      sampleIdealAnswer = "1. අයහපත් වැසි සුළංවලින් තොරව පාලිත තත්ත්ව යටතේ වසර පුරා වගා කළ හැකි වීම. 2. කෘමි පළිබෝධ හානි බෙහෙවින් අවම වීම."
    ),
    ShortAnswerQuestion(
      id = 2264,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "ජල රෝපණය (Hydroponics)",
      question = "ජල රෝපණය (Hydroponics) යනු කුමක්ද? එහිදී ශාකයට පෝෂණය සපයන්නේ කෙසේද?",
      keyPoints = listOf("පස රහිතව ජලයේ හෝ නිෂ්ක්‍රීය මාධ්‍යයක වගා කිරීම", "පෝෂක ද්‍රාවණ ජලයට එක්කිරීමෙන්"),
      synonyms = listOf(
        listOf("පස රහිතව ජලයේ හෝ නිෂ්ක්‍රීය මාධ්‍යයක වගා කිරීම", "පස නැතිව වගා කිරීම"),
        listOf("පෝෂක ද්‍රාවණ ජලයට එක්කිරීමෙන්", "දියර පොහොර මඟින්")
      ),
      officialMarkingScheme = "• අර්ථය: පස නොමැතිව ජලීය මාධ්‍යයක වගා කිරීම (ලකුණු 1)\n• පෝෂණය: ශාකයට අවශ්‍ය ඛනිජ පෝෂක ද්‍රාවණය කර ජලයට මුසු කිරීමෙන් (ලකුණු 1)",
      sampleIdealAnswer = "පස භාවිත නොකර ජලීය ද්‍රාවණයක් තුළ බෝග වගා කිරීමයි. ශාකයට අවශ්‍ය සියලු පෝෂක ජලයේ දියකළ පෝෂක මිශ්‍රණයක් ලෙස සපයයි."
    ),
    ShortAnswerQuestion(
      id = 2265,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "කිරි ගව පාලනය",
      question = "ශ්‍රී ලංකාවේ උඩරට තෙත් කලාපයට සුදුසු යුරෝපීය කිරි ගව වර්ග 2ක් නම් කරන්න.",
      keyPoints = listOf("ෆ්‍රීසියන් (Friesian)", "ජර්සි (Jersey)"),
      synonyms = listOf(
        listOf("ෆ්‍රීසියන් (Friesian)", "Friesian"),
        listOf("ජර්සි (Jersey)", "Jersey", "අයර්ෂයර්")
      ),
      officialMarkingScheme = "• ෆ්‍රීසියන් (Friesian), ජර්සි (Jersey) හෝ අයර්ෂයර් (ලකුණු 2)",
      sampleIdealAnswer = "1. ෆ්‍රීසියන් (Friesian). 2. ජර්සි (Jersey)."
    ),
    ShortAnswerQuestion(
      id = 2266,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "කුකුළු පාලනය",
      question = "බිත්තර නිෂ්පාදනය සඳහා ඇතිකරන කුකුළු වර්ග සහ මස් නිෂ්පාදනය සඳහා ඇතිකරන කුකුළු වර්ග හඳුන්වන නම් ලියන්න.",
      keyPoints = listOf("ලේයර්ස් (Layers)", "බ්‍රොයිලර්ස් (Broilers)"),
      synonyms = listOf(
        listOf("ලේයර්ස් (Layers)", "බිත්තර කුකුළන්"),
        listOf("බ්‍රොයිලර්ස් (Broilers)", "මස් කුකුළන්")
      ),
      officialMarkingScheme = "• බිත්තර සඳහා: ලේයර්ස් (Layers) (ලකුණු 1)\n• මස් සඳහා: බ්‍රොයිලර්ස් (Broilers) (ලකුණු 1)",
      sampleIdealAnswer = "බිත්තර සඳහා \"ලේයර්ස්\" (Layers) කුකුළන් ඇතිකරන අතර, මස් සඳහා \"බ්‍රොයිලර්ස්\" (Broilers) කුකුළන් ඇතිකරයි."
    ),
    ShortAnswerQuestion(
      id = 2267,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "මී මැසි පාලනය",
      question = "මී මැසි ජනපදයක සිටින මැස්සන් වර්ග 3 මොනවාද?",
      keyPoints = listOf("රැජින", "පිරිමි මැස්සන් (ඩ්‍රෝන)", "වැඩකාර මැස්සියන්"),
      synonyms = listOf(
        listOf("රැජින", "මී රැජින", "Queen"),
        listOf("පිරිමි මැස්සන් (ඩ්‍රෝන)", "පිරිමි මැස්සා", "Drone"),
        listOf("වැඩකාර මැස්සියන්", "වැඩකාරියන්", "Worker")
      ),
      officialMarkingScheme = "• රැජින, පිරිමි මැස්සන් සහ වැඩකාර මැස්සියන් (ලකුණු 2)",
      sampleIdealAnswer = "1. මී රැජින (Queen). 2. පිරිමි මැස්සන් (Drones). 3. වැඩකාර මැස්සියන් (Workers)."
    ),
    ShortAnswerQuestion(
      id = 2268,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "පැසවීම තාක්ෂණය (Fermentation)",
      question = "ආහාර සැකසීමේදී පැසවීම (Fermentation) මඟින් නිපදවන ආහාර නිෂ්පාදන 2ක් ලියන්න.",
      keyPoints = listOf("යෝගට් / මීකිරි", "පාන් / විනාකිරි"),
      synonyms = listOf(
        listOf("යෝගට් / මීකිරි", "යෝගට්", "කිරි"),
        listOf("පාන් / විනාකිරි", "විනාකිරි", "චීස්")
      ),
      officialMarkingScheme = "• යෝගට්, මීකිරි, චීස්, පාන්, හෝ විනාකිරි අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. යෝගට් හෝ මීකිරි. 2. පාන් (හෝ විනාකිරි)."
    ),
    ShortAnswerQuestion(
      id = 2269,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "ක්ෂුද්‍රජීවී නරක්වීම්",
      question = "ආහාර නරක්වීමට බලපාන ප්‍රධාන ක්ෂුද්‍රජීවී කාණ්ඩ 2ක් නම් කරන්න.",
      keyPoints = listOf("බැක්ටීරියා", "දිලීර (පුස්)"),
      synonyms = listOf(
        listOf("බැක්ටීරියා", "Bacteria"),
        listOf("දිලීර (පුස්)", "දිලීර", "Fungi", "යීස්ට්")
      ),
      officialMarkingScheme = "• බැක්ටීරියා, දිලීර (පුස්), හෝ යීස්ට් අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. බැක්ටීරියා (Bacteria). 2. දිලීර හෙවත් පුස් (Fungi / Moulds)."
    ),
    ShortAnswerQuestion(
      id = 2270,
      grade = "11",
      setNumber = 17,
      subject = "කෘෂි හා ආහාර තාක්ෂණය",
      topic = "සත්ත්ව ආහාර සංරක්ෂණය",
      question = "තණකොළ හිඟ කාලවලදී ගවයින්ට ලබාදීමට තණකොළ පැසවා සකස් කරන \"සයිලේජ්\" (Silage) යනු කුමක්ද?",
      keyPoints = listOf("වාතය රහිතව අහුරා පැසවීමට ලක්කළ තණකොළ"),
      synonyms = listOf(
        listOf("වාතය රහිතව අහුරා පැසවීමට ලක්කළ තණකොළ", "පැසවූ තණකොළ", "තෘණ සංරක්ෂණය")
      ),
      officialMarkingScheme = "• අමු තණකොළ වාතය නොවැදෙන සේ සයිලෝ තුළ තදකර නිර්වායු පැසවීමකට ලක්කර සකස් කරගන්නා සත්ත්ව ආහාරය (ලකුණු 2)",
      sampleIdealAnswer = "අමු තණකොළ වාතය රහිත කුටි (සයිලෝ) තුළ තදකර අසුරා නිර්වායු පැසවීමට ලක්කිරීමෙන් කල්තබා ගන්නා සත්ත්ව ආහාරයකි."
    ),
    ShortAnswerQuestion(
      id = 2271,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "ලියනාඩෝ ඩා වින්සි",
      question = "ඉතාලි පුනරුද යුගයේ විශිෂ්ට කලාකරුවෙකු වන ලියනාඩෝ ඩා වින්සිගේ ලෝක ප්‍රකට සිතුවම් 2ක් නම් කරන්න.",
      keyPoints = listOf("මොනාලිසා", "අවසාන භෝජන සංග්‍රහය"),
      synonyms = listOf(
        listOf("මොනාලිසා", "Mona Lisa"),
        listOf("අවසාන භෝජන සංග්‍රහය", "The Last Supper", "ලාස්ට් සපර්")
      ),
      officialMarkingScheme = "• මොනාලිසා (Mona Lisa) සහ අවසාන භෝජන සංග්‍රහය (The Last Supper) (ලකුණු 2)",
      sampleIdealAnswer = "1. මොනාලිසා (Mona Lisa). 2. අවසාන භෝජන සංග්‍රහය (The Last Supper)."
    ),
    ShortAnswerQuestion(
      id = 2272,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "මයිකල් ආන්ජලෝ",
      question = "මයිකල් ආන්ජලෝ විසින් රෝමයේ සිස්ටීන් දේවස්ථානයේ සිවිලිමේ අඳින ලද ප්‍රකට සිතුවම සහ ඔහුගේ විශිෂ්ට කිරිගරුඬ මූර්තිය කුමක්ද?",
      keyPoints = listOf("ආදම්ගේ මැවීම (Creation of Adam)", "ඩේවිඩ් ප්‍රතිමාව / පියෙටා ප්‍රතිමාව"),
      synonyms = listOf(
        listOf("ආදම්ගේ මැවීම (Creation of Adam)", "ආදම් මැවීම", "Creation of Adam"),
        listOf("ඩේවිඩ් ප්‍රතිමාව / පියෙටා ප්‍රතිමාව", "ඩේවිඩ්", "David", "Pieta")
      ),
      officialMarkingScheme = "• සිතුවම: ආදම්ගේ මැවීම (Creation of Adam) (ලකුණු 1)\n• මූර්තිය: ඩේවිඩ් (David) හෝ පියෙටා (Pieta) (ලකුණු 1)",
      sampleIdealAnswer = "සිතුවම: ආදම්ගේ මැවීම (The Creation of Adam). මූර්තිය: ඩේවිඩ් ප්‍රතිමාව (David) හෝ පියෙටා (Pieta)."
    ),
    ShortAnswerQuestion(
      id = 2273,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "සමාධි බුදු පිළිමය",
      question = "අනුරාධපුර මහමෙවුනා උයනේ පිහිටි සමාධි බුදු පිළිමයේ නිරූපිත මුද්‍රාව සහ ආසනය කුමක්ද?",
      keyPoints = listOf("ධ්‍යාන මුද්‍රාව", "වීරාසනය"),
      synonyms = listOf(
        listOf("ධ්‍යාන මුද්‍රාව", "සමාධි මුද්‍රාව"),
        listOf("වීරාසනය", "වීරාසන ක්‍රමය")
      ),
      officialMarkingScheme = "• මුද්‍රාව: ධ්‍යාන මුද්‍රාව (ලකුණු 1)\n• ආසනය: වීරාසනය (ලකුණු 1)",
      sampleIdealAnswer = "මුද්‍රාව: ධ්‍යාන මුද්‍රාව (සමාධි මුද්‍රාව). ආසනය: වීරාසනය."
    ),
    ShortAnswerQuestion(
      id = 2274,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "අවුකන බුදු පිළිමය",
      question = "අවුකන බුදු පිළිමයේ නිරූපිත අභය මුද්‍රාවේ විශේෂ ප්‍රභේදය සහ පිළිමයේ උස ආසන්න වශයෙන් දක්වන්න.",
      keyPoints = listOf("අසීස අභය මුද්‍රාව", "අඩි 38-42 පමණ"),
      synonyms = listOf(
        listOf("අසීස අභය මුද්‍රාව", "අභය මුද්‍රාව"),
        listOf("අඩි 38-42 පමණ", "අඩි 38", "අඩි 42", "මීටර් 12")
      ),
      officialMarkingScheme = "• මුද්‍රාව: අසීස අභය මුද්‍රාව (ලකුණු 1)\n• උස: අඩි 38-42 පමණ (ලකුණු 1)",
      sampleIdealAnswer = "අසීස අභය මුද්‍රාවයි. උස ආසන්න වශයෙන් අඩි 38ක් (පද්මාසනය සමඟ අඩි 42ක්) පමණ වේ."
    ),
    ShortAnswerQuestion(
      id = 2275,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "පොළොන්නරුව ගල් විහාරය",
      question = "පොළොන්නරුව උත්තරාරාමය (ගල් විහාරය) කරවූ රජතුමා කවුද? එහි ඇති ප්‍රතිමා 4 මොනවාද?",
      keyPoints = listOf("මහා පරාක්‍රමබාහු රජතුමා", "හිඳි පිළිමය, ගුහාව තුළ හිඳි පිළිමය, හිටි පිළිමය, සැතපෙන පිළිමය"),
      synonyms = listOf(
        listOf("මහා පරාක්‍රමබාහු රජතුමා", "පළමුවන පරාක්‍රමබාහු"),
        listOf("හිඳි පිළිමය, ගුහාව තුළ හිඳි පිළිමය, හිටි පිළිමය, සැතපෙන පිළිමය", "හිඳි, හිටි, සැතපෙන පිළිම")
      ),
      officialMarkingScheme = "• රජු: මහා පරාක්‍රමබාහු රජතුමා (ලකුණු 1)\n• ප්‍රතිමා: හිඳි පිළිමය, විද්‍යාධර ගුහාව තුළ හිඳි පිළිමය, හිටි පිළිමය, පිරිනිවන් මංචකය (සැතපෙන පිළිමය) (ලකුණු 1)",
      sampleIdealAnswer = "මහා පරාක්‍රමබාහු රජතුමා. ප්‍රතිමා: විශාල හිඳි පිළිමය, විද්‍යාධර ගුහාවේ හිඳි පිළිමය, හිටි පිළිමය සහ පිරිනිවන් සැතපෙන පිළිමය."
    ),
    ShortAnswerQuestion(
      id = 2276,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "සඳකඩපහණ පරිණාමය",
      question = "අනුරාධපුර සඳකඩපහණේ සත්ව පේළියේ සිටින සතුන් 4 දෙනා කවුද? පොළොන්නරු යුගයේදී ඉන් ඉවත් කළ සත්වයා කවුද?",
      keyPoints = listOf("ඇතා, අශ්වයා, සිංහයා, ගවයා", "ගවයා"),
      synonyms = listOf(
        listOf("ඇතා, අශ්වයා, සිංහයා, ගවයා", "ඇතා අශ්වයා ගවයා සිංහයා"),
        listOf("ගවයා", "වෘෂභයා", "ගව රූපය")
      ),
      officialMarkingScheme = "• සතුන් 4: ඇතා, අශ්වයා, සිංහයා, ගවයා (ලකුණු 1)\n• ඉවත් කළ සත්වයා: ගවයා (හින්දු ආගමික බලපෑම නිසා) (ලකුණු 1)",
      sampleIdealAnswer = "සතුන් 4 දෙනා: ඇතා, අශ්වයා, සිංහයා සහ ගවයා. පොළොන්නරු යුගයේදී හින්දු බලපෑම මත ගවයාගේ රූපය ඉවත් කරන ලදී."
    ),
    ShortAnswerQuestion(
      id = 2277,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "ඉසුරුමුණි කැටයම්",
      question = "අනුරාධපුර ඉසුරුමුණි විහාර පරිශ්‍රයේ දක්නට ලැබෙන සුප්‍රකට කැටයම් 2ක් නම් කරන්න.",
      keyPoints = listOf("ඉසුරුමුණි පෙම්යුවළ", "මිනිසා සහ අශ්ව හිස"),
      synonyms = listOf(
        listOf("ඉසුරුමුණි පෙම්යුවළ", "පෙම් යුවල"),
        listOf("මිනිසා සහ අශ්ව හිස", "රජ පවුල", "දියකෙළින ඇතුන්")
      ),
      officialMarkingScheme = "• ඉසුරුමුණි පෙම්යුවළ, මිනිසා සහ අශ්ව හිස, රජ පවුල හෝ දියකෙළින ඇතුන් අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. ඉසුරුමුණි පෙම්යුවළ කැටයම. 2. මිනිසා සහ අශ්ව හිස කැටයම (හෝ දියකෙළින ඇත් රූප)."
    ),
    ShortAnswerQuestion(
      id = 2278,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "නවීන ශ්‍රී ලාංකේය චිත්‍ර ශිල්පීන්",
      question = "ශ්‍රී ලංකාවේ නූතන චිත්‍ර කලාවේ පුරෝගාමීන් වන \"43 කණ්ඩායම\" (43 Group) ට අයත් ප්‍රකට චිත්‍ර ශිල්පීන් 2ක් නම් කරන්න.",
      keyPoints = listOf("ජෝර්ජ් කීට්", "ජස්ටින් දැරණියගල"),
      synonyms = listOf(
        listOf("ජෝර්ජ් කීට්", "George Keyt"),
        listOf("ජස්ටින් දැරණියගල", "රිචඩ් ගේබ්‍රියෙල්", "හැරී පීරිස්")
      ),
      officialMarkingScheme = "• ජෝර්ජ් කීට්, ජස්ටින් දැරණියගල, රිචඩ් ගේබ්‍රියෙල් හෝ හැරී පීරිස් අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. ජෝර්ජ් කීට් (George Keyt). 2. ජස්ටින් දැරණියගල (හෝ රිචඩ් ගේබ්‍රියෙල්)."
    ),
    ShortAnswerQuestion(
      id = 2279,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "වර්ණ සංහිඳියාව",
      question = "චිත්‍ර නිර්මාණයක \"සමීප වර්ණ සංහිඳියාව\" (Harmonious colors) යනු කුමක්ද?",
      keyPoints = listOf("වර්ණ චක්‍රයේ එක ළඟ පිහිටි වර්ණ භාවිතය"),
      synonyms = listOf(
        listOf("වර්ණ චක්‍රයේ එක ළඟ පිහිටි වර්ණ භාවිතය", "යාබද වර්ණ", "Analogous colors")
      ),
      officialMarkingScheme = "• වර්ණ චක්‍රයෙහි එක ළඟ පිහිටි වර්ණ (උදා: කහ, කහ-කොළ, කොළ) එකිනෙක මනාව ගැළපෙන සේ භාවිත කිරීම (ලකුණු 2)",
      sampleIdealAnswer = "වර්ණ චක්‍රයේ එකිනෙකට යාබදව (ළඟින්) පිහිටා ඇති වර්ණ එකිනෙක සංයෝජනය කරමින් නිර්මාණයට සාමකාමී බවක් එක්කිරීමයි."
    ),
    ShortAnswerQuestion(
      id = 2280,
      grade = "11",
      setNumber = 18,
      subject = "චිත්‍ර කලාව",
      topic = "මුද්‍රණ ශිල්පය (Graphic Art)",
      question = "මුද්‍රණ ශිල්පයේ එන \"සහන මුද්‍රණ\" (Relief Printing) ක්‍රමයට නිදසුනක් දක්වන්න.",
      keyPoints = listOf("ලී කැටයම් මුද්‍රණය (Woodcut) හෝ අල මුද්‍රණය"),
      synonyms = listOf(
        listOf("ලී කැටයම් මුද්‍රණය (Woodcut) හෝ අල මුද්‍රණය", "Woodcut", "ලිනෝ කැපුම්", "Linocut")
      ),
      officialMarkingScheme = "• ලී කැපුම් මුද්‍රණය (Woodcut), ලිනෝ කැපුම් (Linocut) හෝ බ්ලොක් මුද්‍රණය (ලකුණු 2)",
      sampleIdealAnswer = "ලී කැටයම් මුද්‍රණය (Woodcut) හෝ ලිනෝ මුද්‍රණය (Linocut)."
    ),
    ShortAnswerQuestion(
      id = 2281,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "රාග ලක්ෂණ",
      question = "රාගයක \"වාදී ස්වරය\" සහ \"සංවාදී ස්වරය\" යනු කුමක්ද?",
      keyPoints = listOf("වැදගත්ම ප්‍රධාන ස්වරය (රජු වැනි)", "දෙවනුවට වැදගත් ස්වරය (ඇමති වැනි)"),
      synonyms = listOf(
        listOf("වැදගත්ම ප්‍රධාන ස්වරය (රජු වැනි)", "ප්‍රධාන ස්වරය"),
        listOf("දෙවනුවට වැදගත් ස්වරය (ඇමති වැනි)", "දෙවන ප්‍රධාන ස්වරය")
      ),
      officialMarkingScheme = "• වාදී ස්වරය: රාගයේ බහුලව භාවිත වන ප්‍රධානතම ස්වරය (රජු) (ලකුණු 1)\n• සංවාදී ස්වරය: දෙවනුවට වැදගත් ස්වරය (ඇමති) (ලකුණු 1)",
      sampleIdealAnswer = "වාදී ස්වරය යනු රාගයක ප්‍රධානතම (රජු බඳු) ස්වරයයි. සංවාදී ස්වරය යනු දෙවනුවට වැදගත්ම (ඇමති බඳු) ස්වරයයි."
    ),
    ShortAnswerQuestion(
      id = 2282,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "බිලාවල් ථාටය",
      question = "බිලාවල් ථාටයේ අඩංගු ස්වරවල විශේෂත්වය කුමක්ද?",
      keyPoints = listOf("සියලු ස්වර ශුද්ධ ස්වර වීම"),
      synonyms = listOf(
        listOf("සියලු ස්වර ශුද්ධ ස්වර වීම", "ශුද්ධ ස්වර 7ම අඩංගු වීම", "ස්වර 7ම ශුද්ධයි")
      ),
      officialMarkingScheme = "• එහි අන්තර්ගත ස්වර 7ම ශුද්ධ ස්වර (තීව්‍ර හෝ කෝමල නැති) වේ (ලකුණු 2)",
      sampleIdealAnswer = "බිලාවල් ථාටයේ ඇති සියලුම ස්වර 7 ශුද්ධ ස්වර වේ (ස්වර විකෘති නොවේ)."
    ),
    ShortAnswerQuestion(
      id = 2283,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "තීන්තාලය",
      question = "තීන්තාලයේ මුළු මාත්‍රා සංඛ්‍යාව, අංග (විභාග) ගණන සහ තාලි/ඛාලි පිහිටීම ලියන්න.",
      keyPoints = listOf("මාත්‍රා 16", "අංග 4 (4 බැගින්)", "තාලි 1, 5, 13 සහ ඛාලි 9"),
      synonyms = listOf(
        listOf("මාත්‍රා 16", "16"),
        listOf("අංග 4 (4 බැගින්)", "විභාග 4"),
        listOf("තාලි 1, 5, 13 සහ ඛාලි 9", "ඛාලි 9")
      ),
      officialMarkingScheme = "• මාත්‍රා 16, මාත්‍රා 4 බැගින් වූ විභාග 4ක් (ලකුණු 1)\n• 1, 5, 13 මාත්‍රාවල තාලි සහ 9 වන මාත්‍රාවේ ඛාලිය (ලකුණු 1)",
      sampleIdealAnswer = "මුළු මාත්‍රා 16 කි. මාත්‍රා 4 බැගින් වූ විභාග 4 කි. 1, 5, 13 මාත්‍රාවල තාලියත්, 9 වන මාත්‍රාවේ ඛාලියත් යෙදේ."
    ),
    ShortAnswerQuestion(
      id = 2284,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "කොහොඹා කංකාරියේ උපත",
      question = "උඩරට කොහොඹා කංකාරිය ශාන්තිකර්මය ප්‍රථමයෙන් පවත්වන ලද්දේ කුමන රජුට වැළඳුණු කුමන රෝගය සුව කිරීමටද?",
      keyPoints = listOf("පණ්ඩුවාසදේව රජතුමා", "දිවි දෝෂය (දිවි දෝසය)"),
      synonyms = listOf(
        listOf("පණ්ඩුවාසදේව රජතුමා", "පණ්ඩුවාස්දේව"),
        listOf("දිවි දෝෂය (දිවි දෝසය)", "දිවිදෝෂය")
      ),
      officialMarkingScheme = "• රජු: පණ්ඩුවාසදේව රජු (ලකුණු 1)\n• රෝගය: කුවේණියගේ ශාපය නිසා ඇතිවූ දිවි දෝෂය (ලකුණු 1)",
      sampleIdealAnswer = "පණ්ඩුවාසදේව රජතුමාටය. කුවේණියගේ ශාපය නිසා වැළඳුණු \"දිවි දෝෂය\" සුව කිරීම සඳහා මල රජු ලවා පවත්වන ලදී."
    ),
    ShortAnswerQuestion(
      id = 2285,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "සබරගමු නර්තනය",
      question = "සබරගමු නර්තන සම්ප්‍රදායේ ප්‍රධාන ශාන්තිකර්මය කුමක්ද? එහි භාවිත වන ප්‍රධාන ගායනා ශෛලිය කුමක්ද?",
      keyPoints = listOf("මහ සමන් දේව කංකාරිය", "සින්දු මාත්‍රය"),
      synonyms = listOf(
        listOf("මහ සමන් දේව කංකාරිය", "සමන් දේව කංකාරිය", "පහන් මඩුව"),
        listOf("සින්දු මාත්‍රය", "මාත්‍ර ගායනා")
      ),
      officialMarkingScheme = "• ශාන්තිකර්මය: මහ සමන් දේව කංකාරිය / පහන් මඩුව (ලකුණු 1)\n• ශෛලිය: සින්දු මාත්‍රය (ලකුණු 1)",
      sampleIdealAnswer = "මහ සමන් දේව කංකාරිය (හෝ පහන් මඩුව). ප්‍රධාන ගායනා ශෛලිය සින්දු මාත්‍රයයි."
    ),
    ShortAnswerQuestion(
      id = 2286,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "පහතරට දහඅට සන්නිය",
      question = "පහතරට ශාන්තිකර්මවල එන දහඅට සන්නියෙන් සන්නි 2ක් නම් කර ඒවා මඟින් නිරූපණය වන රෝග දක්වන්න.",
      keyPoints = listOf("භූත සන්නිය (පිස්සුව/උමතුව)", "කණ සන්නිය (අන්ධභාවය)"),
      synonyms = listOf(
        listOf("භූත සන්නිය (පිස්සුව/උමතුව)", "භූත සන්නිය"),
        listOf("කණ සන්නිය (අන්ධභාවය)", "කණ සන්නිය", "බිහිරි සන්නිය", "කොළ සන්නිය")
      ),
      officialMarkingScheme = "• භූත සන්නිය (උමතුව), කණ සන්නිය (අන්ධ බව), බිහිරි සන්නිය (බිහිරි බව), හෝ අභූත සන්නිය අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. භූත සන්නිය - උමතු රෝග හා වියරුව. 2. කණ සන්නිය - අන්ධභාවය (ඇස් නොපෙනීම)."
    ),
    ShortAnswerQuestion(
      id = 2287,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "භාරතීය සම්භාව්‍ය නර්තන",
      question = "ඉන්දියාවේ ප්‍රධාන සම්භාව්‍ය නර්තන ශෛලීන් 2ක් සහ ඒවාට අයත් ප්‍රාන්ත නම් කරන්න.",
      keyPoints = listOf("භරතනාට්‍යම් (තමිල්නාඩුව)", "කථක් (උතුරු ඉන්දියාව)"),
      synonyms = listOf(
        listOf("භරතනාට්‍යම් (තමිල්නාඩුව)", "භරත නාට්‍යම්"),
        listOf("කථක් (උතුරු ඉන්දියාව)", "කථකලි (කේරළය)", "මනිපුරි")
      ),
      officialMarkingScheme = "• භරතනාට්‍යම් (තමිල්නාඩුව), කථක් (උත්තර ප්‍රදේශ්/උතුරු ඉන්දියාව), හෝ කථකලි (කේරළය) (ලකුණු 2)",
      sampleIdealAnswer = "1. භරතනාට්‍යම් - තමිල්නාඩු ප්‍රාන්තය. 2. කථකලි - කේරළ ප්‍රාන්තය (හෝ කථක් - උතුරු ඉන්දියාව)."
    ),
    ShortAnswerQuestion(
      id = 2288,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "සංගීත භාණ්ඩ කොටස්",
      question = "ගැටබෙරයේ වම් ඇස සහ දකුණු ඇස සාදා ඇත්තේ කුමන සතුන්ගේ හම්වලින්ද?",
      keyPoints = listOf("වම් ඇස: ගව හම", "දකුණු ඇස: වඳුරු හම"),
      synonyms = listOf(
        listOf("වම් ඇස: ගව හම", "වම හරක් හම"),
        listOf("දකුණු ඇස: වඳුරු හම", "දකුණ වඳුරු හම", "රැහැණි හම")
      ),
      officialMarkingScheme = "• වම් ඇස (මන්දම): ගව හම (ලකුණු 1)\n• දකුණු ඇස (තානම): වඳුරු හම (ලකුණු 1)",
      sampleIdealAnswer = "වම් ඇස (මන්දම) ගව හමෙන්ද, දකුණු ඇස (තානම) වඳුරු හමෙන්ද (හෝ තලගොයි හමෙන්) සාදා ඇත."
    ),
    ShortAnswerQuestion(
      id = 2289,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "නූතන නාට්‍ය කලාව",
      question = "මහාචාර්ය එදිරිවීර සරච්චන්ද්‍රයන්ගේ \"මනමේ\" නාට්‍යයේ එන ප්‍රධාන චරිත 2ක් නම් කරන්න.",
      keyPoints = listOf("මනමේ කුමරු", "වැදි රජු"),
      synonyms = listOf(
        listOf("මනමේ කුමරු", "කුමරු"),
        listOf("වැදි රජු", "මනමේ බිසව", "කුමරිය")
      ),
      officialMarkingScheme = "• මනමේ කුමරු, මනමේ බිසව, වැදි රජු අතුරින් 2ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. මනමේ කුමරු. 2. වැදි රජු (සහ මනමේ කුමරිය)."
    ),
    ShortAnswerQuestion(
      id = 2290,
      grade = "11",
      setNumber = 19,
      subject = "නර්තනය හා සංගීතය",
      topic = "නූර්ති සහ නාඩගම්",
      question = "ශ්‍රී ලංකාවේ පැරණිතම නාට්‍ය විශේෂයක් වන \"නාඩගම්\" සහ පසුව බිහිවූ \"නූර්ති\" අතර ඇති ප්‍රධාන සංගීතමය වෙනස කුමක්ද?",
      keyPoints = listOf("නාඩගම්වල දකුණු ඉන්දීය කර්ණාටක සංගීතයද, නූර්තිවල උතුරු ඉන්දීය හින්දුස්ථානී සංගීතයද යොදාගැනීම"),
      synonyms = listOf(
        listOf("නාඩගම්වල දකුණු ඉන්දීය කර්ණාටක සංගීතයද, නූර්තිවල උතුරු ඉන්දීය හින්දුස්ථානී සංගීතයද යොදාගැනීම", "කර්ණාටක සහ හින්දුස්ථානී සංගීතය")
      ),
      officialMarkingScheme = "• නාඩගම් සංගීතය දකුණු ඉන්දීය (දෙමළ/කර්ණාටක) ආභාසය ලැබූවක් වන අතර නූර්ති සංගීතය උතුරු ඉන්දීය (හින්දුස්ථානී/රාගධාරී) ආභාසය ලැබුවකි (ලකුණු 2)",
      sampleIdealAnswer = "නාඩගම් සඳහා දකුණු ඉන්දීය (කර්ණාටක) සංගීත ආභාසය ලැබුණු අතර, නූර්ති සඳහා උතුරු ඉන්දීය හින්දුස්ථානී (රාගධාරී) සංගීතය යොදාගන්නා ලදී."
    ),
    ShortAnswerQuestion(
      id = 2291,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "දත්ත සමුදාය (Database Keys)",
      question = "දත්ත සමුදායක (DBMS) ප්‍රාථමික යතුර (Primary Key) සහ විදේශ යතුර (Foreign Key) යනු මොනවාද?",
      keyPoints = listOf("වාර්තාවක් අනන්‍යව හඳුනාගන්නා යතුර", "වගු දෙකක් අතර සම්බන්ධතාව ගොඩනගන යතුර"),
      synonyms = listOf(
        listOf("වාර්තාවක් අනන්‍යව හඳුනාගන්නා යතුර", "අනන්‍ය හඳුනාගැනීම"),
        listOf("වගු දෙකක් අතර සම්බන්ධතාව ගොඩනගන යතුර", "සම්බන්ධතා යතුර")
      ),
      officialMarkingScheme = "• ප්‍රාථමික යතුර: වගුවක සෑම පේළියක්ම (වාර්තාවක්ම) අනන්‍ය ලෙස හඳුනාගැනීමට යොදාගන්නා ක්ෂේත්‍රය (ලකුණු 1)\n• විදේශ යතුර: වගු දෙකක් අතර සබඳතාව තහවුරු කිරීම සඳහා වෙනත් වගුවක ප්‍රාථමික යතුරක් මෙහි ඇතුළත් කිරීම (ලකුණු 1)",
      sampleIdealAnswer = "ප්‍රාථමික යතුර මඟින් වගුවක වාර්තාවක් අනන්‍යව හඳුනාගනී. විදේශ යතුර මඟින් වෙනත් වගුවක ප්‍රාථමික යතුරක් හා සම්බන්ධ වෙමින් වගු දෙක අතර සබඳතාව තහවුරු කරයි."
    ),
    ShortAnswerQuestion(
      id = 2292,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "SQL විමසුම් (SQL Queries)",
      question = "\"Students\" නමැති වගුවෙන් ලකුණු (Marks) 75 ට වැඩි සියලුම සිසුන්ගේ නම් (Name) ලබාගැනීමට ලියන SQL විධානය ලියන්න.",
      keyPoints = listOf("SELECT Name FROM Students WHERE Marks > 75;"),
      synonyms = listOf(
        listOf("SELECT Name FROM Students WHERE Marks > 75;", "SELECT Name FROM Students WHERE Marks > 75", "select name from students where marks > 75")
      ),
      officialMarkingScheme = "• SELECT Name FROM Students WHERE Marks > 75; (ලකුණු 2)",
      sampleIdealAnswer = "SELECT Name FROM Students WHERE Marks > 75;"
    ),
    ShortAnswerQuestion(
      id = 2293,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "Python Loops",
      question = "පහත Python කේත ඛණ්ඩයේ ප්‍රතිදානය (Output) කුමක්ද?\\nfor i in range(1, 6, 2):\\n    print(i, end=\\\" \\\")",
      keyPoints = listOf("1 3 5"),
      synonyms = listOf(
        listOf("1 3 5", "1, 3, 5", "1 3 5 ")
      ),
      officialMarkingScheme = "• 1 3 5 (ලකුණු 2)",
      sampleIdealAnswer = "1 3 5"
    ),
    ShortAnswerQuestion(
      id = 2294,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "Python Functions",
      question = "Python භාෂාවේ පරිශීලක ශ්‍රිතයක් (User defined function) අර්ථ දැක්වීමට භාවිත කරන මූල පදය (Keyword) කුමක්ද?",
      keyPoints = listOf("def"),
      synonyms = listOf(
        listOf("def", "def keyword", "def ()")
      ),
      officialMarkingScheme = "• \"def\" මූල පදය (ලකුණු 2)",
      sampleIdealAnswer = "def"
    ),
    ShortAnswerQuestion(
      id = 2295,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "පරිගණක ජාල ස්ථලක (Topologies)",
      question = "ප්‍රධාන පරිගණක ජාල ස්ථලක (Network Topologies) 3ක් නම් කරන්න.",
      keyPoints = listOf("තාරකා ස්ථලකය (Star)", "බස් ස්ථලකය (Bus)", "මුදු ස්ථලකය (Ring)"),
      synonyms = listOf(
        listOf("තාරකා ස්ථලකය (Star)", "Star"),
        listOf("බස් ස්ථලකය (Bus)", "Bus"),
        listOf("මුදු ස්ථලකය (Ring)", "Ring", "Mesh")
      ),
      officialMarkingScheme = "• Star (තාරකා), Bus (බස්), Ring (මුදු), හෝ Mesh ස්ථලක අතුරින් 3ක් (ලකුණු 2)",
      sampleIdealAnswer = "1. තාරකා ස්ථලකය (Star Topology). 2. බස් ස්ථලකය (Bus Topology). 3. මුදු ස්ථලකය (Ring Topology)."
    ),
    ShortAnswerQuestion(
      id = 2296,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "IP ලිපින (IP Address)",
      question = "IPv4 ලිපිනයක ඇති බිටු (bits) ගණන සහ IPv6 ලිපිනයක ඇති බිටු ගණන පිළිවෙළින් ලියන්න.",
      keyPoints = listOf("32 bits", "128 bits"),
      synonyms = listOf(
        listOf("32 bits", "32", "බිටු 32"),
        listOf("128 bits", "128", "බිටු 128")
      ),
      officialMarkingScheme = "• IPv4: බිටු 32 (ලකුණු 1)\n• IPv6: බිටු 128 (ලකුණු 1)",
      sampleIdealAnswer = "IPv4 ලිපිනයක බිටු 32ක් ද, IPv6 ලිපිනයක බිටු 128ක් ද අඩංගු වේ."
    ),
    ShortAnswerQuestion(
      id = 2297,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "වලාව පරිගණනය (Cloud Computing)",
      question = "වලාව පරිගණනයේ (Cloud Computing) ඇති ප්‍රධාන සේවා ආකෘති 3 නම් කරන්න.",
      keyPoints = listOf("IaaS (Infrastructure as a Service)", "PaaS (Platform as a Service)", "SaaS (Software as a Service)"),
      synonyms = listOf(
        listOf("IaaS (Infrastructure as a Service)", "IaaS"),
        listOf("PaaS (Platform as a Service)", "PaaS"),
        listOf("SaaS (Software as a Service)", "SaaS")
      ),
      officialMarkingScheme = "• IaaS, PaaS, SaaS (ලකුණු 2)",
      sampleIdealAnswer = "1. IaaS (Infrastructure as a Service). 2. PaaS (Platform as a Service). 3. SaaS (Software as a Service)."
    ),
    ShortAnswerQuestion(
      id = 2298,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "සයිබර් ආරක්ෂාව සහ Malwares",
      question = "පරිගණක වෛරසයක් (Virus) සහ රැන්සම්වෙයාර් (Ransomware) අතර වෙනස කුමක්ද?",
      keyPoints = listOf("ගොනු විනාශ කිරීම හෝ දූෂණය කිරීම", "දත්ත සංකේතනය කර කප්පම් මුදල් ඉල්ලා සිටීම"),
      synonyms = listOf(
        listOf("ගොනු විනාශ කිරීම හෝ දූෂණය කිරීම", "පද්ධතිය අඩපණ කිරීම"),
        listOf("දත්ත සංකේතනය කර කප්පම් මුදල් ඉල්ලා සිටීම", "කප්පම් මෘදුකාංග", "encryption ransom")
      ),
      officialMarkingScheme = "• වෛරස: පරිගණක ගොනුවලට හානි කිරීම, පද්ධතිය මන්දගාමී කිරීම (ලකුණු 1)\n• Ransomware: පරිශීලකයාගේ ලිපිගොනු අගුළුලා (encrypt කර) මුදාහැරීමට මුදල් (කප්පම්) ඉල්ලා සිටීම (ලකුණු 1)",
      sampleIdealAnswer = "වෛරස මඟින් ගොනු විනාශ කිරීම හෝ වෙනස් කිරීම සිදුකරයි. Ransomware මඟින් ගොනු encrypt කර අගුළුලා ඒවා මුදාහැරීමට කප්පම් ඉල්ලයි."
    ),
    ShortAnswerQuestion(
      id = 2299,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "වෙබ් නිර්මාණය - CSS",
      question = "වෙබ් පිටුවක CSS (Cascading Style Sheets) ඇතුළත් කළ හැකි ප්‍රධාන ආකාර 3 මොනවාද?",
      keyPoints = listOf("Inline CSS", "Internal CSS", "External CSS"),
      synonyms = listOf(
        listOf("Inline CSS", "පේළිගත"),
        listOf("Internal CSS", "අභ්‍යන්තර"),
        listOf("External CSS", "බාහිර")
      ),
      officialMarkingScheme = "• Inline CSS, Internal CSS, External CSS (ලකුණු 2)",
      sampleIdealAnswer = "1. Inline CSS (ටැගය තුළම). 2. Internal CSS (<style> ටැගය තුළ). 3. External CSS (වෙනම .css ගොනුවක් ලෙස)."
    ),
    ShortAnswerQuestion(
      id = 2300,
      grade = "11",
      setNumber = 20,
      subject = "ICT",
      topic = "පද්ධති සංවර්ධන ජීවන චක්‍රය (SDLC)",
      question = "පද්ධති සංවර්ධන ජීවන චක්‍රයේ (SDLC) ප්‍රධාන පියවර 4ක් පිළිවෙළින් ලියන්න.",
      keyPoints = listOf("අවශ්‍යතා හඳුනාගැනීම", "පද්ධති සැලසුම්කරණය", "ක්‍රමලේඛනය (සංවර්ධනය)", "පරීක්ෂා කිරීම"),
      synonyms = listOf(
        listOf("අවශ්‍යතා හඳුනාගැනීම", "Requirement Analysis"),
        listOf("පද්ධති සැලසුම්කරණය", "System Design"),
        listOf("ක්‍රමලේඛනය (සංවර්ධනය)", "Coding", "Implementation"),
        listOf("පරීක්ෂා කිරීම", "Testing", "නඩත්තුව")
      ),
      officialMarkingScheme = "• අවශ්‍යතා විශ්ලේෂණය -> සැලසුම්කරණය -> ක්‍රියාත්මක කිරීම/ක්‍රමලේඛනය -> පරීක්ෂා කිරීම -> නඩත්තුව (ලකුණු 2)",
      sampleIdealAnswer = "1. අවශ්‍යතා විශ්ලේෂණය (Requirement Analysis). 2. පද්ධති සැලසුම්කරණය (Design). 3. ක්‍රමලේඛනය (Development). 4. පරීක්ෂා කිරීම (Testing)."
    )
  )
}
