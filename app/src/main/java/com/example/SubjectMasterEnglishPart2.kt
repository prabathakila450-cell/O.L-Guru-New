package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterEnglishPart2 {
  fun getCategories(): List<SubjectMasterCategory> {
    return listOf(
      // Category 11: Articles & Determiners
      SubjectMasterCategory(
        id = "eng_cat_11",
        categoryNumber = 11,
        titleSinhala = "Articles & Determiners",
        icon = "🔤",
        color = Color(0xFF0284C7),
        summary = "Definite article 'the', indefinite 'a/an', zero article, some, any, much, many, each, every.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Indefinite Article 'A' with Consonant Sounds",
            detail = "'A' is used before singular, countable nouns beginning with a consonant sound (e.g., a book, a European country where 'Eu' sounds like /j/).",
            examHighlight = "Remember: Sound determines 'a' vs 'an', not just the written vowel letter."
          ),
          SubjectFactPoint(
            number = 2,
            title = "Indefinite Article 'An' with Vowel Sounds",
            detail = "'An' precedes singular countable nouns beginning with a vowel sound (e.g., an apple, an hour where 'h' is silent, an honest person, an MP).",
            examHighlight = "Abbreviations starting with vowel sounds (an O/L candidate, an FBI agent) require 'an'."
          ),
          SubjectFactPoint(
            number = 3,
            title = "Definite Article 'The' for Unique Entities",
            detail = "'The' is used when referring to unique entities in nature or geography: the sun, the moon, the earth, the sky, the equator.",
            examHighlight = "Never say 'sun rises in east'; always say 'The sun rises in the east.'"
          ),
          SubjectFactPoint(
            number = 4,
            title = "The Definite Article with Specific Reference",
            detail = "Use 'the' when both speaker and listener know which specific item is meant (e.g., 'Please shut the door', 'The boy in the red shirt is my brother').",
            examHighlight = "Second mention rule: 'I saw a dog. The dog was barking fiercely.'"
          ),
          SubjectFactPoint(
            number = 5,
            title = "Geographical Proper Nouns Requiring 'The'",
            detail = "'The' is required with oceans (the Indian Ocean), seas (the Mediterranean), rivers (the Mahaweli River), mountain ranges (the Himalayas), and island groups (the Maldives).",
            examHighlight = "Individual peaks (Mount Everest) and single islands (Sri Lanka) do NOT take 'the'."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Countries with Plural Names or Words like 'Kingdom/Republic'",
            detail = "Countries like 'the United States', 'the United Kingdom', 'the Netherlands', and 'the Philippines' require 'the', while single entity countries do not.",
            examHighlight = "Do not write 'the Sri Lanka'; write simply 'Sri Lanka'."
          ),
          SubjectFactPoint(
            number = 7,
            title = "Zero Article with Uncountable General Nouns",
            detail = "No article is used before plural or uncountable nouns used in a general sense: 'Water is essential for life', 'Honesty is the best policy'.",
            examHighlight = "Contrasted with specific: 'The water in this bottle is cold.'"
          ),
          SubjectFactPoint(
            number = 8,
            title = "Zero Article with Meals and School Subjects",
            detail = "Meals in general do not take articles ('have breakfast', 'invited for dinner'). Academic subjects do not take articles ('She excels in Mathematics and Science').",
            examHighlight = "If qualified by an adjective, an article is used: 'We had a delicious dinner.'"
          ),
          SubjectFactPoint(
            number = 9,
            title = "Zero Article with Institutions (Primary Purpose)",
            detail = "Places like school, hospital, prison, church take no article when visited for their primary purpose ('He goes to school', 'He is in hospital').",
            examHighlight = "If visiting as an outsider: 'His father went to the school to meet the principal.'"
          ),
          SubjectFactPoint(
            number = 10,
            title = "Superlatives and Ordinal Numbers with 'The'",
            detail = "Superlative adjectives and ordinal numbers always demand 'the': 'the tallest building', 'the most important lesson', 'the first chapter', 'the third prize'.",
            examHighlight = "Essential for O/L essay writing and error correction cloze passages."
          ),
          SubjectFactPoint(
            number = 11,
            title = "Musical Instruments with 'Play The'",
            detail = "When speaking about playing an instrument, use 'the': 'She plays the piano', 'He is learning the violin'. Contrast with sports: 'play cricket' (no article).",
            examHighlight = "Never say 'play the cricket' or 'play piano'."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Determiners: 'Some' in Positive Statements & Polite Requests",
            detail = "'Some' is used in affirmative sentences with plurals and uncountables ('I have some books', 'There is some milk') and in polite offers ('Would you like some tea?').",
            examHighlight = "Do not use 'any' when offering something politely expectantly."
          ),
          SubjectFactPoint(
            number = 13,
            title = "Determiners: 'Any' in Negatives and General Questions",
            detail = "'Any' is used in negative sentences and open questions: 'I don't have any money', 'Do you have any questions?', 'Hardly any people came'.",
            examHighlight = "Pairing: 'hardly any', 'scarcely any', 'without any'."
          ),
          SubjectFactPoint(
            number = 14,
            title = "'Much' vs 'Many'",
            detail = "'Much' is used with uncountable nouns ('much time', 'much water', typically in negative and questions), while 'Many' is used with countable plurals ('many students', 'many reasons').",
            examHighlight = "In affirmative sentences, 'a lot of' is commonly preferred over 'much'."
          ),
          SubjectFactPoint(
            number = 15,
            title = "'Little' vs 'A Little'",
            detail = "'Little' has a negative meaning (almost none, insufficient: 'We have little hope'). 'A little' has a positive meaning (some, enough: 'I have a little money left').",
            examHighlight = "Frequent cloze test trap in Paper I Question 4."
          ),
          SubjectFactPoint(
            number = 16,
            title = "'Few' vs 'A Few'",
            detail = "'Few' means almost none with plural countables ('Few students passed the tough test' - negative). 'A few' means a small positive number ('A few friends visited me').",
            examHighlight = "'The few' refers to all of the small number available."
          ),
          SubjectFactPoint(
            number = 17,
            title = "'Each' vs 'Every'",
            detail = "'Each' refers to individual members considered one by one (two or more). 'Every' refers to all members together (three or more). Both take singular verbs.",
            examHighlight = "'Each student has a book' (singular verb 'has', not 'have')."
          ),
          SubjectFactPoint(
            number = 18,
            title = "Demonstratives: This, That, These, Those",
            detail = "'This/These' indicate proximity in time or space (singular/plural). 'That/Those' indicate distance in time or space.",
            examHighlight = "Ensure agreement: 'This type of problem' NOT 'These type of problem'."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Quantifiers: All, Both, Neither, Either",
            detail = "'Both' applies to two items affirmatively. 'Neither' excludes both (singular verb). 'Either' refers to one of two choices.",
            examHighlight = "'Neither of the candidates was qualified' (formal grammar requires singular)."
          ),
          SubjectFactPoint(
            number = 20,
            title = "O/L Exam Strategy for Articles in Cloze Tests",
            detail = "Read the entire sentence before inserting an article. Check if the subsequent noun is countable/uncountable, singular/plural, general or specific.",
            examHighlight = "Common O/L test: Put 'a', 'an', 'the' or leave blank 'X' in blanks."
          )
        )
      ),

      // Category 12: Subject-Verb Agreement Rules
      SubjectMasterCategory(
        id = "eng_cat_12",
        categoryNumber = 12,
        titleSinhala = "Subject-Verb Agreement Rules",
        icon = "⚖️",
        color = Color(0xFF0284C7),
        summary = "Singular/plural harmony, either/or, neither/nor, collective nouns, each/every, prepositional phrase traps.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Core Principle: Singular Subject, Singular Verb",
            detail = "A singular subject takes a singular verb ending in '-s' or '-es' in present tense: 'The teacher explains the lesson clearly.'",
            examHighlight = "Plural subjects take base verbs without '-s': 'The teachers explain...'"
          ),
          SubjectFactPoint(
            number = 2,
            title = "Intervening Prepositional Phrase Trap",
            detail = "Words between subject and verb do not change the subject's number: 'The bouquet of red roses smells (singular) fragrant.' The subject is 'bouquet', not 'roses'.",
            examHighlight = "'The quality of these mangoes is (not are) excellent.' Highly tested in O/L!"
          ),
          SubjectFactPoint(
            number = 3,
            title = "Subjects Joined by 'And'",
            detail = "Two or more nouns joined by 'and' usually take a plural verb: 'Sunil and Kamal are good athletes.'",
            examHighlight = "Exception: When two nouns express a single unit/dish: 'Rice and curry is our staple diet.'"
          ),
          SubjectFactPoint(
            number = 4,
            title = "Phrases like 'As well as', 'Together with', 'Along with'",
            detail = "Parenthetical expressions like 'as well as', 'along with', 'in addition to' do not affect the subject: 'The principal, along with the teachers, is attending the ceremony.'",
            examHighlight = "The verb agrees solely with the initial subject before the comma."
          ),
          SubjectFactPoint(
            number = 5,
            title = "Either... Or / Neither... Nor Proximity Rule",
            detail = "When two subjects are connected by 'either... or' or 'neither... nor', the verb agrees with the subject closer to it: 'Neither the teacher nor the students were present.'",
            examHighlight = "'Neither the students nor the teacher was present.' Proximity decides."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Indefinite Pronouns Always Singular",
            detail = "Pronouns like 'everyone, everybody, someone, nobody, no one, anyone, anything, each' always take singular verbs: 'Everyone has submitted their assignment.'",
            examHighlight = "Never write 'Everyone have...'; write 'Everyone has...'."
          ),
          SubjectFactPoint(
            number = 7,
            title = "Collective Nouns as a Single Unit",
            detail = "In standard O/L English, collective nouns operating as a single unit take singular verbs: 'The committee has made its decision', 'The team is practicing on the ground.'",
            examHighlight = "If individual members act separately, plural can be used, but singular is standard."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Nouns Plural in Form but Singular in Meaning",
            detail = "Subjects like News, Mathematics, Physics, Economics, Measles end in 's' but are singular concepts: 'Physics is an intriguing science.'",
            examHighlight = "'The news was shocking' (never 'the news were')."
          ),
          SubjectFactPoint(
            number = 9,
            title = "Measurements of Money, Time, and Distance",
            detail = "Amounts of money, periods of time, and measurements of distance take a singular verb when considered as a single total lump sum: 'Ten thousand rupees is a fair price.'",
            examHighlight = "'Five kilometers is a long distance to walk daily.'"
          ),
          SubjectFactPoint(
            number = 10,
            title = "'A Number of' vs 'The Number of'",
            detail = "'A number of students are absent' (plural meaning several). In contrast, 'The number of students in the class is 45' (singular referring to the specific figure).",
            examHighlight = "Memorize: 'A number of' = plural verb; 'The number of' = singular verb."
          ),
          SubjectFactPoint(
            number = 11,
            title = "Sentences Inverted with 'Here' and 'There'",
            detail = "In sentences beginning with 'here' or 'there', the real subject follows the verb: 'There are forty desks in the classroom.' 'There is an apple on the plate.'",
            examHighlight = "Look past 'there' to the noun to decide 'is' vs 'are'."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Fractions and Percentages: Object of Preposition Decides",
            detail = "With fractions and percentages, the noun that follows 'of' determines agreement: 'Half of the cake was eaten.' 'Half of the apples were rotten.'",
            examHighlight = "Uncountable noun = singular verb; Plural countable noun = plural verb."
          ),
          SubjectFactPoint(
            number = 13,
            title = "'One of the...' Relative Clause Pattern",
            detail = "'Nimal is one of the boys who love cricket' (plural verb 'love' because 'who' refers to 'boys'). But 'Nimal is the only one of the boys who loves cricket' (singular).",
            examHighlight = "Distinguish 'one of those who [plural]' vs 'the only one who [singular]'."
          ),
          SubjectFactPoint(
            number = 14,
            title = "Nouns Always Plural: Scissors, Trousers, Glasses",
            detail = "Tools and garments consisting of two parts are always plural: 'My scissors are blunt', 'His spectacles were broken.'",
            examHighlight = "If preceded by 'a pair of', it becomes singular: 'A pair of scissors was bought.'"
          ),
          SubjectFactPoint(
            number = 15,
            title = "Compound Subjects Expressing One Idea",
            detail = "Bread and butter, slow and steady, time and tide: 'Slow and steady wins the race.' The combined subject expresses a singular philosophical concept.",
            examHighlight = "Verb takes singular 'wins', not 'win'."
          ),
          SubjectFactPoint(
            number = 16,
            title = "'Every' or 'Each' Preceding Multiple Subjects",
            detail = "When 'every' or 'each' comes before compound subjects joined by 'and', the verb remains singular: 'Every boy and every girl was given a certificate.'",
            examHighlight = "Do not be misled by 'and'; 'every' enforces singular agreement."
          ),
          SubjectFactPoint(
            number = 17,
            title = "Gerunds and Infinitives as Subjects",
            detail = "When a gerund (-ing form) or infinitive (to + verb) functions as the sentence subject, it takes a singular verb: 'Swimming regularly maintains physical health.'",
            examHighlight = "'Reading books expands our vocabulary and thinking power.'"
          ),
          SubjectFactPoint(
            number = 18,
            title = "'None' - Usage Rules",
            detail = "'None' can take singular or plural depending on context. In formal writing: 'None of the food was wasted' (uncountable). 'None of the students was/were injured.'",
            examHighlight = "Singular is strictly accepted in formal Cambridge/O-Level marking."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Adjectives Functioning as Plural Nouns with 'The'",
            detail = "When an adjective is preceded by 'the' to denote a whole class of people, it takes a plural verb: 'The poor need our compassion.' 'The rich are not always happy.'",
            examHighlight = "The young, the elderly, the homeless all take plural verbs."
          ),
          SubjectFactPoint(
            number = 20,
            title = "Self-Correction Strategy in O/L Essays",
            detail = "Always underline the head noun in your sentences during review. Check whether the tense is present and verify that third-person singular has '-s'.",
            examHighlight = "Subject-verb errors are the most heavily penalized grammatical mistakes in Paper II."
          )
        )
      ),

      // Category 13: Formal & Informal Letter Writing
      SubjectMasterCategory(
        id = "eng_cat_13",
        categoryNumber = 13,
        titleSinhala = "Formal & Informal Letter Writing",
        icon = "✉️",
        color = Color(0xFF0284C7),
        summary = "Sender's address, date format, recipient designation, salutations, body structure, formal vs friendly sign-offs.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Layout Structure of a Formal Letter",
            detail = "Top left aligned: Sender's address, Date, Recipient's official designation & address, Subject line ('Request for...'), Salutation ('Dear Sir/Madam'), Body, Complimentary close.",
            examHighlight = "Use full block format with consistent left alignment without indentation."
          ),
          SubjectFactPoint(
            number = 2,
            title = "Standard Date Formatting",
            detail = "Always write the date in full words: '12th October 2026' or 'October 12, 2026'. Never write shorthand like '12/10/26' in formal examinations.",
            examHighlight = "Writing full date formats earns marks for formal layout presentation."
          ),
          SubjectFactPoint(
            number = 3,
            title = "Recipient Official Address Formulation",
            detail = "Address the office/position first, followed by organization and city: 'The Principal, Ananda College, Colombo 10.' or 'The Divisional Secretary, Matara.'",
            examHighlight = "Do not write the person's private name in a formal administrative letter."
          ),
          SubjectFactPoint(
            number = 4,
            title = "The Concise Subject Heading (Underlined)",
            detail = "Include an underlined, capitalized subject line: 'Subject: Permission to Organize an English Day Seminar'. Keep it under 10 words, immediately indicating purpose.",
            examHighlight = "Helps the examiner recognize your task completion immediately."
          ),
          SubjectFactPoint(
            number = 5,
            title = "Formal Opening Sentences",
            detail = "'I am writing this letter to request permission...', 'I wish to bring to your kind attention that...', 'I am writing in response to your advertisement dated...'",
            examHighlight = "Avoid informal greetings like 'How are you?' in formal letters."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Body Paragraph 1: Purpose of the Letter",
            detail = "Clearly state who you are (e.g., 'As the President of the English Literary Association') and why you are writing this letter in the very first paragraph.",
            examHighlight = "Directness and clarity are required by O/L scoring criteria."
          ),
          SubjectFactPoint(
            number = 7,
            title = "Body Paragraph 2: Details, Dates, and Justifications",
            detail = "Provide practical details: event date, duration, expected attendees, chief guest, proposed venue, and how the event benefits students or community.",
            examHighlight = "Ensure all bullet points given in the exam question prompt are fully addressed."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Body Paragraph 3: Specific Request and Call to Action",
            detail = "Conclude the message politely: 'I would be grateful if you could kindly grant approval at your earliest convenience.' 'Thank you in advance for your assistance.'",
            examHighlight = "Polite request phrasing demonstrates proficiency in modal registers."
          ),
          SubjectFactPoint(
            number = 9,
            title = "Formal Complimentary Close & Signature",
            detail = "Use 'Yours faithfully,' if you addressed 'Dear Sir/Madam'. Use 'Yours sincerely,' if you addressed the recipient by name ('Dear Mr. Perera'). Follow with signature and name.",
            examHighlight = "Capital 'Y' in 'Yours', small 'f' in 'faithfully', followed by a comma."
          ),
          SubjectFactPoint(
            number = 10,
            title = "Informal Letter Structure (To a Friend or Relative)",
            detail = "Top right or left: Sender's address and date only. Salutation: 'Dear Tharindu,' or 'Dearest Mother,'. No subject line. Relaxed, conversational tone.",
            examHighlight = "Do NOT write recipient's address or a subject line in an informal letter!"
          ),
          SubjectFactPoint(
            number = 11,
            title = "Informal Opening Expressions",
            detail = "'How are you doing? I hope you and your family are in good health.' 'It has been quite a while since we last spoke, so I decided to drop you a line.'",
            examHighlight = "Warm personal tone creates genuine rapport required for high band marks."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Informal Contractions and Conversational Flow",
            detail = "Unlike formal writing, informal letters permit contractions: 'I've', 'don't', 'it's wonderful', along with exclamation marks and personal anecdotes.",
            examHighlight = "Still maintain proper grammatical spelling and punctuation throughout."
          ),
          SubjectFactPoint(
            number = 13,
            title = "Covering All Stimulus Notes in Question 14",
            detail = "O/L Paper II Question 14 awards 10 marks. Up to 4 marks are awarded strictly for content — missing a single bullet point deducts content marks automatically!",
            examHighlight = "Tick off each bullet point in the question as you write it."
          ),
          SubjectFactPoint(
            number = 14,
            title = "Informal Letter Concluding Paragraph",
            detail = "'Please convey my warmest regards to your parents and younger sister. Hope to see you during the upcoming school holidays. Write back soon!'",
            examHighlight = "A warm closing paragraph seals the social purpose of the communication."
          ),
          SubjectFactPoint(
            number = 15,
            title = "Informal Complimentary Close",
            detail = "'Your loving friend,' 'Yours affectionately,' 'Best regards,' 'Warm wishes,' followed by your first name only: 'Sunil'.",
            examHighlight = "Never write 'Yours faithfully' to a friend or cousin."
          ),
          SubjectFactPoint(
            number = 16,
            title = "Letter of Complaint Vocabulary",
            detail = "'I am writing to express my dissatisfaction regarding...', 'regret to inform you that the product was damaged upon delivery...', 'trust this matter will be resolved promptly.'",
            examHighlight = "Remain firm, professional and objective without using abusive emotional words."
          ),
          SubjectFactPoint(
            number = 17,
            title = "Letter of Apology Phrases",
            detail = "'Please accept my sincere apologies for the unexpected delay in submitting...', 'I deeply regret any inconvenience caused to your department...'",
            examHighlight = "State clear corrective steps you are taking to resolve the mistake."
          ),
          SubjectFactPoint(
            number = 18,
            title = "Letter of Invitation Formal Register",
            detail = "'We cordially invite you to grace the annual prize-giving ceremony as our Distinguished Chief Guest on Friday, 28th November at 9:00 a.m. in the College Auditorium.'",
            examHighlight = "State date, exact time, venue, and request RSVP contact details."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Word Count Management (100–125 Words)",
            detail = "Aim for exactly 100 to 125 words. Writing under 80 words loses content marks; writing over 160 words wastes examination time and increases error chances.",
            examHighlight = "Count lines (usually 10-12 words per line) to judge length quickly."
          ),
          SubjectFactPoint(
            number = 20,
            title = "Marking Scheme Criteria: Content & Language",
            detail = "Content (3 marks), Organization (2 marks), Language (4 marks), Mechanics of writing/Format (1 mark). Perfect formatting secures early base marks.",
            examHighlight = "Ensure flawless capitalization, punctuation, and clear paragraph transitions."
          )
        )
      ),

      // Category 14: Essay & Article Writing Architecture
      SubjectMasterCategory(
        id = "eng_cat_14",
        categoryNumber = 14,
        titleSinhala = "Essay & Article Writing Architecture",
        icon = "📝",
        color = Color(0xFF0284C7),
        summary = "Catchy title, introductory hook, cohesive paragraphs, topic sentences, transitional linkers, strong conclusion.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Essay Four-Part Structure: Introduction, 2 Body Paragraphs, Conclusion",
            detail = "Standard 150-word O/L essay format: Paragraph 1 = Introduction + thesis. Paragraph 2 = Primary arguments/benefits. Paragraph 3 = Secondary points/solutions. Paragraph 4 = Conclusion.",
            examHighlight = "Clear visual indentation or line spacing between paragraphs is mandatory."
          ),
          SubjectFactPoint(
            number = 2,
            title = "Introductory Hook: Engaging the Reader",
            detail = "Start with a thought-provoking statement, universal truth, or rhetorical observation: 'In an era dominated by digital communication, the habit of reading remains irreplaceable.'",
            examHighlight = "Do not start clumsily with: 'I am going to write an essay about...'"
          ),
          SubjectFactPoint(
            number = 3,
            title = "Formulating a Clear Thesis Statement",
            detail = "The final sentence of the introductory paragraph should declare the central theme of the essay: 'This essay examines the principal causes of plastic pollution and outlines practical remedies.'",
            examHighlight = "Guides the reader and keeps your writing strictly focused."
          ),
          SubjectFactPoint(
            number = 4,
            title = "The Topic Sentence in Body Paragraphs",
            detail = "Every body paragraph must begin with a strong topic sentence asserting the main idea: 'Firstly, engaging in daily sports contributes immensely to physical and mental wellness.'",
            examHighlight = "All supporting sentences in that paragraph must elaborate on that topic."
          ),
          SubjectFactPoint(
            number = 5,
            title = "PEEL Paragraph Model: Point, Explain, Example, Link",
            detail = "P: Make your point. E: Explain the logic behind it. E: Provide a concrete real-life example (e.g., in Sri Lanka). L: Link back to the broader essay question.",
            examHighlight = "Guarantees depth of thought and logical flow rewarded in Language marks."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Transitional Linking Words for Sequence",
            detail = "Use signpost words to structure sequential points: 'Firstly, Secondly, Furthermore, In addition to this, Moreover, Lastly, To begin with.'",
            examHighlight = "Linkers enhance the 'Organization' score on the marking grid."
          ),
          SubjectFactPoint(
            number = 7,
            title = "Transitional Linkers for Contrast and Opposition",
            detail = "Present alternative viewpoints smoothly: 'On the other hand, However, Nevertheless, In contrast, Despite these advantages, Although...'",
            examHighlight = "Shows balanced critical thinking, highly valued in argumentative essays."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Transitional Linkers for Cause and Effect",
            detail = "Demonstrate causation clearly: 'Consequently, As a result of this, Therefore, Owing to, Thus, This leads directly to...'",
            examHighlight = "Avoid repetitive 'Because' at the beginning of every sentence."
          ),
          SubjectFactPoint(
            number = 9,
            title = "Using Concrete Examples Instead of Vague Generalizations",
            detail = "Back up general statements with specifics: 'For instance, planting indigenous trees like Mee and Kumbuk along riverbanks prevents soil erosion.'",
            examHighlight = "Examiners reward rich, specific vocabulary and localized relevance."
          ),
          SubjectFactPoint(
            number = 10,
            title = "Article Writing Features: Catchy Headline & Byline",
            detail = "When writing an article for a school magazine or newsletter, provide an engaging title (e.g., 'Guardians of the Green: School Recycling Crusade') and a byline: 'By: Nimal Perera, Grade 11'.",
            examHighlight = "Differentiates an article from a standard academic essay."
          ),
          SubjectFactPoint(
            number = 11,
            title = "Descriptive Essay Sensory Language",
            detail = "In descriptive essays ('A Memorable Trip to Sigiriya'), engage the five senses: sight (towering granite fortress), sound (rustling monsoon leaves), smell (crisp morning mist).",
            examHighlight = "Use vivid adjectives and active verbs instead of plain words."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Cause and Solution Essay Structure",
            detail = "Paragraph 1: Background of problem. Paragraph 2: Core underlying root causes. Paragraph 3: Practical actionable solutions by individuals and state. Paragraph 4: Visionary summary.",
            examHighlight = "Perfect template for environmental, traffic, or health topics."
          ),
          SubjectFactPoint(
            number = 13,
            title = "Synthesizing Counter-Arguments",
            detail = "'While critics argue that smartphones distract youth, it cannot be denied that when utilized constructively, they are indispensable tools for self-directed learning.'",
            examHighlight = "Sophisticated sentence structure showcasing advanced linguistic ability."
          ),
          SubjectFactPoint(
            number = 14,
            title = "Avoiding Redundancy and Clichés",
            detail = "Avoid filler phrases like 'At this moment of time' (use 'now'), 'Due to the fact that' (use 'because'), 'Needless to say' (omit). Eliminate empty repetition.",
            examHighlight = "Keeps word count compact and writing energetic and crisp."
          ),
          SubjectFactPoint(
            number = 15,
            title = "Effective Concluding Paragraph Formulas",
            detail = "Begin your conclusion with: 'In conclusion,' 'To summarize,' or 'Taking everything into account,'. Summarize primary arguments and end with a forward-looking recommendation.",
            examHighlight = "Never introduce brand new points in the conclusion."
          ),
          SubjectFactPoint(
            number = 16,
            title = "The Concluding Call to Action or Prediction",
            detail = "'Only through collective civic responsibility and strict enforcement of environmental laws can we preserve our island’s pristine biodiversity for future generations.'",
            examHighlight = "Leaves a memorable positive impression on the marking examiner."
          ),
          SubjectFactPoint(
            number = 17,
            title = "Target Word Count: 150–200 Words for Question 16",
            detail = "Paper II Question 16 offers essay/article options worth 15 marks. 150 to 200 words is the sweet spot: about 15-20 lines of well-developed content.",
            examHighlight = "Allocate at least 25 minutes of your exam time to this high-scoring section."
          ),
          SubjectFactPoint(
            number = 18,
            title = "Advanced Vocabulary Insertion (O/L Level)",
            detail = "Elevate common words: 'vital/crucial' for 'important', 'detrimental' for 'harmful', 'foster/cultivate' for 'grow/help', 'paramount' for 'number one'.",
            examHighlight = "Using 5-6 well-placed academic vocabulary items lifts language band scores."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Sentence Variety: Mixing Simple, Compound, and Complex",
            detail = "Do not write short, monotonous simple sentences throughout. Combine ideas using relative clauses, participle clauses ('Realizing the danger, the villagers evacuated...'), and adverbial clauses.",
            examHighlight = "Sentence structure diversity is explicitly audited in O/L marking."
          ),
          SubjectFactPoint(
            number = 20,
            title = "Final Proofreading Checklist (3 Minutes)",
            detail = "Check: 1. Subject-verb agreement (singular 's'). 2. Consistent past or present tense. 3. Correct spelling of key words. 4. Capital letters at start of sentences.",
            examHighlight = "Catching 3-4 careless errors can elevate your grade from B to A."
          )
        )
      ),

      // Category 15: Notice, Note & Invitation Writing
      SubjectMasterCategory(
        id = "eng_cat_15",
        categoryNumber = 15,
        titleSinhala = "Notice, Note & Invitation Writing",
        icon = "📌",
        color = Color(0xFF0284C7),
        summary = "Event, date, time, venue, target audience, contact details, concise structured format for Paper I short writing.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Standard 5-Point Boxed Notice Framework",
            detail = "Every notice must contain: 1. Catchy centered heading ('NOTICE: ANNUAL BOOK FAIR'). 2. Target audience ('All students of Grade 10 & 11'). 3. Date, Time, Venue. 4. Purpose/Activities. 5. Issuing Authority.",
            examHighlight = "Drawing a neat pencil border box around the notice is good practice."
          ),
          SubjectFactPoint(
            number = 2,
            title = "Precise Date, Time, and Venue Listing",
            detail = "Format cleanly in distinct bulleted lines: Date: Monday, 15th November 2026 | Time: From 8:30 a.m. to 1:30 p.m. | Venue: College Main Hall.",
            examHighlight = "Examiners scan specifically for the 'Date, Time, Venue' triad for content marks."
          ),
          SubjectFactPoint(
            number = 3,
            title = "Issuing Authority Designation",
            detail = "Always conclude at the bottom right: 'Secretary, Nature Club' or 'Head Prefect, Student Guild'. Date of notice issuance at bottom left.",
            examHighlight = "An anonymous notice without issuing authority loses organization points."
          ),
          SubjectFactPoint(
            number = 4,
            title = "Imperative Language and Passive Phrasing in Notices",
            detail = "'All are cordially invited to attend', 'Interested participants are requested to register their names with the teacher-in-charge before 10th November.'",
            examHighlight = "Concise and authoritative tone without unnecessary wordiness."
          ),
          SubjectFactPoint(
            number = 5,
            title = "Notice Word Count (40–50 Words in Paper I)",
            detail = "Paper I Question 6 gives 5 marks for notice/note writing. Keep it strictly between 40 and 50 words. Be direct, clear, and complete.",
            examHighlight = "Do not write lengthy introductory paragraphs in a notice."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Short Notes to Friends: Absence Explanation",
            detail = "'Dear Nuwan, I will not be able to attend English class today as I am down with a severe cold. Please take down the class notes for me. Thanks, Kasun.'",
            examHighlight = "Date at top, recipient, reason for absence, request, sign-off."
          ),
          SubjectFactPoint(
            number = 7,
            title = "Short Note Requesting a Book or Favor",
            detail = "'Dear Amal, Could you please lend me your Science past paper book for two days? I need to revise for the term test. I will return it on Friday. Ruwan.'",
            examHighlight = "Specify item, reason, borrowing duration, promise of return."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Note of Apology and Rescheduling",
            detail = "'Dear Sandun, I am very sorry that I could not meet you at the library yesterday due to an urgent family errand. Can we meet this Saturday instead? Saman.'",
            examHighlight = "Polite apology, concise explanation, feasible alternative proposed."
          ),
          SubjectFactPoint(
            number = 9,
            title = "Formal Card Invitation Format",
            detail = "Centered typography: 'The Principal, Staff and Students of [School] cordially invite [Name] to the Annual Sports Meet on [Date] at [Time] at [Venue]. RSVP: Secretary.'",
            examHighlight = "Third person perspective is strictly maintained in formal invitation cards."
          ),
          SubjectFactPoint(
            number = 10,
            title = "RSVP Significance and Proper Placement",
            detail = "'RSVP' stands for 'Répondez s'il vous plaît' (Please reply). Place at the bottom left with phone number and email for confirmation.",
            examHighlight = "Must include contact telephone number and designated RSVP contact person."
          ),
          SubjectFactPoint(
            number = 11,
            title = "Chief Guest Announcement in Invitations",
            detail = "'Mr. K. Perera, Director of Zonal Education, will grace the occasion as Chief Guest.' Clearly designate guest honorifics.",
            examHighlight = "Mention arrival time and seating instructions if requested in the exam prompt."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Notice for a Lost or Found Item",
            detail = "'LOST: Black leather pencil case containing Parker fountain pen in the Science Laboratory on Tuesday morning. Finder please return to Prefects' Room. Reward offered.'",
            examHighlight = "Accurate description of item, location lost, return point."
          ),
          SubjectFactPoint(
            number = 13,
            title = "Notice for an Audition, Trial, or Selection",
            detail = "'Auditions for the Sinhala/English Drama Society will be held on Thursday, 20th October at 2.00 p.m. in the Music Room. Prepare a 2-minute dialogue.'",
            examHighlight = "State eligibility criteria, preparation requirements, and judges."
          ),
          SubjectFactPoint(
            number = 14,
            title = "Note Leaving a Message (Telephone Memo)",
            detail = "'To: Kamal | Date: 12th Oct, 4.00 p.m. | Uncle Sunil called while you were out. He asked you to bring the cricket bat tomorrow morning. Ruwan.'",
            examHighlight = "Name of caller, time of call, exact message content, recorder's name."
          ),
          SubjectFactPoint(
            number = 15,
            title = "Formal Note to Class Teacher / Principal",
            detail = "'To: The Class Teacher, Grade 11-A | Respectful Sir, Please grant me permission to leave school early at 12:30 p.m. today due to a medical appointment. Yours obediently, Dasun.'",
            examHighlight = "Respectful formal register even in short notes to authorities."
          ),
          SubjectFactPoint(
            number = 16,
            title = "Notice of Meeting for Club Members",
            detail = "'An urgent meeting of the Environment Society committee will take place on Friday during the lunch interval in Room 14 to finalize Shramadana duties.'",
            examHighlight = "Specify target group, urgency, exact venue, and agenda topics."
          ),
          SubjectFactPoint(
            number = 17,
            title = "Posters vs Notices: Visual Layout Guidelines",
            detail = "While posters focus on slogans and graphic impact, an O/L examination notice prioritizes informational accuracy, textual clarity, and structured layout.",
            examHighlight = "Do not spend time drawing cartoons; write clear, structured text."
          ),
          SubjectFactPoint(
            number = 18,
            title = "Punctuation Consistency in Bulleted Notice Data",
            detail = "When listing details like 'Date:', 'Time:', 'Venue:', maintain uniform capitalization and colon alignments for high visual score.",
            examHighlight = "Clean presentation creates immediate positive examiner bias."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Direct Scoring Criteria for Question 6 (5 Marks)",
            detail = "Content: 2 marks (all instructions covered). Language: 3 marks (spelling, grammar, punctuation, vocabulary precision).",
            examHighlight = "A 5/5 score is easily achievable in 6 minutes if all points are included."
          ),
          SubjectFactPoint(
            number = 20,
            title = "Exam Time Allocation Rule",
            detail = "Spend no more than 7 to 8 minutes on Question 6 in Paper I. Quickly read the stimulus, underline the 3 required elements, draft neatly, and check.",
            examHighlight = "Leaves ample time for the longer reading comprehension questions."
          )
        )
      ),

      // Category 16: Bar Chart & Pie Chart Descriptions
      SubjectMasterCategory(
        id = "eng_cat_16",
        categoryNumber = 16,
        titleSinhala = "Bar Chart & Pie Chart Descriptions",
        icon = "📊",
        color = Color(0xFF0284C7),
        summary = "Trends, highest/lowest percentages, comparative phrases, data synthesis, summary overview for Paper II Question 14.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Standard 3-Paragraph Report Architecture",
            detail = "Paragraph 1: Introductory overview defining what the chart shows. Paragraph 2: Detailed analysis comparing highest, lowest, and key categories. Paragraph 3: Concluding summary.",
            examHighlight = "Never present chart data as a single continuous unstructured block."
          ),
          SubjectFactPoint(
            number = 2,
            title = "Introductory Paraphrasing Formula",
            detail = "Paraphrase the title of the chart: 'The given bar chart illustrates the preferred leisure activities of Grade 11 students in a secondary school in Galle in the year 2025.'",
            examHighlight = "Do NOT copy the question rubric word-for-word; substitute synonyms."
          ),
          SubjectFactPoint(
            number = 3,
            title = "Identifying the Overall Trend / General Feature",
            detail = "Include an overall statement: 'Overall, it is evident that reading books emerged as the most favored hobby, whereas stamp collecting was the least popular activity.'",
            examHighlight = "An overall general statement is mandatory for top band criteria."
          ),
          SubjectFactPoint(
            number = 4,
            title = "Expressing the Highest Quantity or Percentage",
            detail = "'The highest percentage of students (45%) chose reading...', 'Securing the lion's share, football was preferred by a vast majority of boys.'",
            examHighlight = "Always cite the exact numerical value or percentage from the chart in brackets."
          ),
          SubjectFactPoint(
            number = 5,
            title = "Expressing the Lowest Quantity or Minorities",
            detail = "'Conversely, the lowest proportion of respondents (barely 5%) selected gardening...', 'Swimming recorded the smallest percentage among all categories.'",
            examHighlight = "Use contrasting adverbs: 'In stark contrast, On the other hand, Conversely'."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Comparative Structures: More Than / Less Than",
            detail = "'A significantly higher percentage of students preferred cricket (30%) compared to badminton (15%).' 'Almost twice as many girls chose drama as music.'",
            examHighlight = "Never merely list numbers; synthesize and compare the categories."
          ),
          SubjectFactPoint(
            number = 7,
            title = "Equal and Identical Proportions",
            detail = "'Interestingly, cycling and drawing accounted for an equal proportion of students, standing at 12% each.' 'Both categories shared identical numbers.'",
            examHighlight = "Phrases: 'equal proportion', 'tied at', 'accounted for identical percentages'."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Approximation Vocabulary for Fluctuating Numbers",
            detail = "Use hedging words when values fall between grid lines: 'approximately', 'roughly', 'nearly', 'just under', 'slightly over', 'around 25%'.",
            examHighlight = "Demonstrates nuanced mathematical interpretation in English."
          ),
          SubjectFactPoint(
            number = 9,
            title = "Fractions Equivalents for Percentages",
            detail = "Convert percentages into natural English fractions: 50% = 'half of the students', 25% = 'a quarter', 75% = 'three quarters', 33% = 'one-third', 10% = 'one in ten'.",
            examHighlight = "Varying between numbers and fraction words elevates vocabulary scores."
          ),
          SubjectFactPoint(
            number = 10,
            title = "Pie Chart Sector Vocabulary",
            detail = "'The pie chart is divided into five distinct sectors.', 'The largest slice of the pie represents...', 'The remaining segments comprise minor preferences.'",
            examHighlight = "Reflects familiarity with graphical chart nomenclature."
          ),
          SubjectFactPoint(
            number = 11,
            title = "Verbs for Explaining Trends Over Time (Line Graphs)",
            detail = "Upward: increased, rose, surged, climbed steadily. Downward: declined, dropped, decreased, plummeted. Stable: remained steady, plateaued.",
            examHighlight = "Use with suitable adverbs: 'sharply', 'gradually', 'consistently'."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Describing Multiple Bars (Gender / Age Comparisons)",
            detail = "'While 40% of male students opted for science, only 25% of female students made that choice. Conversely, literature attracted more female respondents.'",
            examHighlight = "Group related bars together rather than writing separate random descriptions."
          ),
          SubjectFactPoint(
            number = 13,
            title = "Useful Prepositions in Data Descriptions",
            detail = "'increased FROM 10% TO 30%', 'rose BY 20%', 'peaked AT 85%', 'stood AT 15%', 'remained constant THROUGHOUT the period.'",
            examHighlight = "Preposition precision is essential in interpreting statistics accurately."
          ),
          SubjectFactPoint(
            number = 14,
            title = "Avoiding Personal Opinions in Graphic Reports",
            detail = "Do NOT write: 'I think students like cricket because it is exciting.' A chart description must be strictly objective, relying 100% on the data shown.",
            examHighlight = "Never insert personal biases or unsubstantiated external causes."
          ),
          SubjectFactPoint(
            number = 15,
            title = "Conjunctions for Seamless Data Synthesis",
            detail = "'Whereas 35% of youth spend time online, while only 10% engage in outdoor sports.' Use 'while', 'whereas', 'whilst' to contrast figures in a single sentence.",
            examHighlight = "Produces compound-complex sentences that impress examiners."
          ),
          SubjectFactPoint(
            number = 16,
            title = "Synthesizing Middle Categories",
            detail = "'The remaining categories, namely chess, table tennis, and carrom, showed modest figures ranging between 8% and 14% respectively.'",
            examHighlight = "Using 'respectively' links names to numbers in matching order."
          ),
          SubjectFactPoint(
            number = 17,
            title = "The Concluding Summary Sentence",
            detail = "'In conclusion, the data demonstrates that modern youth show a pronounced inclination toward electronic entertainment over traditional outdoor hobbies.'",
            examHighlight = "Provides a cohesive synthesis summarizing the overarching pattern."
          ),
          SubjectFactPoint(
            number = 18,
            title = "Word Count and Timing: 100 Words in 12 Minutes",
            detail = "Question 14 in Paper II awards 10 marks. A 100-word report can be written cleanly in 12 minutes if you follow the three-paragraph template.",
            examHighlight = "Many high-scoring students choose the chart description over the informal letter for speed."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Marking Criteria for Chart Descriptions",
            detail = "Content (3 marks for covering all sectors accurately), Organization (2 marks for paragraphs & flow), Language (4 marks for syntax/vocabulary), Mechanics (1 mark).",
            examHighlight = "Zero tolerance for wrong data reporting (e.g., calling 40% as 14%)."
          ),
          SubjectFactPoint(
            number = 20,
            title = "Final Review Verification Checklist",
            detail = "1. Did I cite the actual numbers/percentages correctly? 2. Did I identify the highest and lowest? 3. Did I avoid personal opinions? 4. Is the spelling correct?",
            examHighlight = "Double check each number against the printed chart before submission."
          )
        )
      ),

      // Category 17: Reading Comprehension Strategies
      SubjectMasterCategory(
        id = "eng_cat_17",
        categoryNumber = 17,
        titleSinhala = "Reading Comprehension Strategies",
        icon = "📖",
        color = Color(0xFF0284C7),
        summary = "Skimming, scanning, context clues, inferencing, pronoun references, identifying main ideas in unseen passages.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Skimming for Gist and Global Understanding",
            detail = "Skimming means reading rapidly through a passage in 60 seconds to understand the general topic, theme, and overall tone before looking at specific questions.",
            examHighlight = "Read the first sentence of each paragraph during skimming to grasp structure."
          ),
          SubjectFactPoint(
            number = 2,
            title = "Scanning for Specific Keywords and Numerical Data",
            detail = "Scanning involves searching the text for specific target words, names, dates, places, or numbers mentioned in the exam question without reading every word.",
            examHighlight = "Move your eyes in a zigzag pattern across the paragraph looking for capitals or digits."
          ),
          SubjectFactPoint(
            number = 3,
            title = "Underlining Keywords in the Question Prompt First",
            detail = "Always read the questions before reading the comprehension text thoroughly. Underline question words (Who, When, Where, Why, How many) and key subject nouns.",
            examHighlight = "Gives you a mental radar to spot answers while reading the passage."
          ),
          SubjectFactPoint(
            number = 4,
            title = "Deducing Unknown Word Meanings from Context Clues",
            detail = "Look at surrounding words, antonyms, or synonyms in the same sentence to infer unknown words. E.g., 'The landscape was arid; not a single drop of water or blade of grass could be seen.'",
            examHighlight = "Arid clearly means extremely dry/desert-like based on context."
          ),
          SubjectFactPoint(
            number = 5,
            title = "Pronoun Referent Questions: Tracing Backward",
            detail = "When asked: 'What does the word 'they' in line 14 refer to?', look at the preceding sentence. Identify the plural noun that logically fits the action.",
            examHighlight = "Verify agreement in number (singular 'it' vs plural 'they') and gender ('he'/'she')."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Locating Direct Factual Answers vs Inferential Answers",
            detail = "Direct answers are stated explicitly in the text. Inferential answers require reading between the lines based on clues, characters' feelings, or underlying implications.",
            examHighlight = "Never guess inferential questions without finding textual proof."
          ),
          SubjectFactPoint(
            number = 7,
            title = "True / False / Not Given Questions Protocol",
            detail = "True = Directly agreed with in the text. False = Directly contradicted in the text. Not Given = Text mentions nothing about it, even if you know it from real life!",
            examHighlight = "Base your response strictly on the printed passage, not external knowledge."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Writing Direct, Concise Answers (Avoiding Over-Copying)",
            detail = "Answer with the exact requested fact. Do not copy an entire 4-line paragraph from the passage; examiners penalize inability to isolate the specific answer.",
            examHighlight = "If asked 'Why was Nimal late?', write: 'Because the bus broke down', not the whole paragraph."
          ),
          SubjectFactPoint(
            number = 9,
            title = "Synonym and Antonym Matching Tactics",
            detail = "Match word classes: If the requested word is an adjective, its matching synonym from the passage must also be an adjective (e.g., 'frightened' = 'terrified', not 'terror').",
            examHighlight = "Check that verb tenses match (past tense matches past tense)."
          ),
          SubjectFactPoint(
            number = 10,
            title = "Summary Writing: Extracting Core Main Ideas",
            detail = "Paper II Question 15 asks for a summary of a passage segment. Identify the 4-5 central factual points, discard adjectives and illustrative examples, and rephrase.",
            examHighlight = "Stay within the strict word limit (usually 50 words) to avoid penalties."
          ),
          SubjectFactPoint(
            number = 11,
            title = "Avoiding Own Words Traps When Direct Quoting is Required",
            detail = "If the question explicitly says: 'Find the phrase which shows that...', copy the exact words inside inverted commas. Do not paraphrase when asked to 'find the word/phrase'.",
            examHighlight = "Precision quotation earns full marks in vocabulary identification."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Handling Multiple-Choice Questions (Elimination Technique)",
            detail = "Eliminate obvious distractors: 1. Statements that contradict the passage. 2. Statements true in real life but unmentioned. 3. Extreme words ('always', 'never').",
            examHighlight = "Eliminating two incorrect choices leaves a 50/50 probability on hard questions."
          ),
          SubjectFactPoint(
            number = 13,
            title = "Identifying the Author's Purpose and Tone",
            detail = "Is the text informative (news report), persuasive (opinion piece), narrative (story), or critical? Look at emotive adjectives and evaluative adverbs.",
            examHighlight = "Questions like 'What is the main purpose of the writer?' test tone recognition."
          ),
          SubjectFactPoint(
            number = 14,
            title = "Cause and Consequence Question Precision",
            detail = "If asked 'What caused the accident?', isolate the trigger event. If asked 'What was the consequence?', find what happened after the crash.",
            examHighlight = "Do not mix cause with result; check chronologies carefully."
          ),
          SubjectFactPoint(
            number = 15,
            title = "Cloze Passage Techniques: Grammar-Based Gap Filling",
            detail = "Examine words immediately before and after the gap. Determine if the missing word is a verb, noun, preposition, or article based on grammatical syntax.",
            examHighlight = "Test each candidate word by reading the sentence aloud in your head."
          ),
          SubjectFactPoint(
            number = 16,
            title = "Identifying Cause-Effect Discourse Markers in Passages",
            detail = "Look for signal words: 'due to', 'owing to', 'because of', 'thereby', 'consequently'. These markers highlight the exact answers to 'Why' questions.",
            examHighlight = "Saves searching time by directing your attention immediately to causal clauses."
          ),
          SubjectFactPoint(
            number = 17,
            title = "Paragraph Topic Sentences as Map Pins",
            detail = "The first or last sentence of each paragraph in non-fiction texts almost always summarizes that paragraph's theme. Use them as quick navigation pins.",
            examHighlight = "Quickly locate where a specific topic is discussed in lengthy texts."
          ),
          SubjectFactPoint(
            number = 18,
            title = "Time Management for Question 15 (Reading Passage)",
            detail = "Question 15 carries 8 marks. Allocate 15-18 minutes: 3 minutes reading/skimming, 10 minutes answering questions, 2 minutes reviewing accuracy.",
            examHighlight = "Do not get stuck on one difficult 1-mark question; star it and return later."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Spelling and Grammar in Short-Answer Responses",
            detail = "Answers with severe spelling mistakes that alter word meaning may be penalized. Copy names, dates, and technical terminology directly from the text accurately.",
            examHighlight = "Double check your spelling against the printed passage."
          ),
          SubjectFactPoint(
            number = 20,
            title = "Synthesizing Information Across Two Paragraphs",
            detail = "Some challenging questions ask for two reasons that are separated across different paragraphs. Always read past the first found reason to check for 'In addition...'.",
            examHighlight = "Ensures you capture all points when a question awards 2 full marks."
          )
        )
      ),

      // Category 18: Idioms, Phrasal Verbs & Collocations
      SubjectMasterCategory(
        id = "eng_cat_18",
        categoryNumber = 18,
        titleSinhala = "Idioms, Phrasal Verbs & Collocations",
        icon = "💡",
        color = Color(0xFF0284C7),
        summary = "High-frequency exam idioms, separable/inseparable phrasal verbs, natural word partnerships for fluent writing.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Phrasal Verb: 'Look after' vs 'Look for'",
            detail = "'Look after' means to take care of someone or something ('She looks after her elderly grandmother'). 'Look for' means to search for something lost ('I am looking for my keys').",
            examHighlight = "Distinguish particle meanings to avoid comical errors in essays."
          ),
          SubjectFactPoint(
            number = 2,
            title = "Phrasal Verb: 'Look forward to' (+ Gerund -ing)",
            detail = "'Look forward to' means anticipating something with pleasure. It MUST be followed by a noun or gerund: 'I look forward to meeting (not meet) you.'",
            examHighlight = "A famous O/L grammar trap! Always use '-ing' after 'look forward to'."
          ),
          SubjectFactPoint(
            number = 3,
            title = "Phrasal Verbs with 'Give': Give up, Give in, Give away",
            detail = "'Give up' = quit/stop ('give up smoking'). 'Give in' = surrender/yield ('refused to give in to pressure'). 'Give away' = distribute free or reveal a secret.",
            examHighlight = "Frequently tested in vocabulary cloze exercises in Paper I."
          ),
          SubjectFactPoint(
            number = 4,
            title = "Phrasal Verbs with 'Put': Put off, Put on, Put out, Put up with",
            detail = "'Put off' = postpone. 'Put on' = wear clothes. 'Put out' = extinguish a fire ('Firefighters put out the blaze'). 'Put up with' = tolerate patiently.",
            examHighlight = "Never say 'close the fire'; always say 'put out the fire'."
          ),
          SubjectFactPoint(
            number = 5,
            title = "Phrasal Verbs with 'Break': Break down, Break out, Break into",
            detail = "'Break down' = mechanical failure or emotional collapse. 'Break out' = sudden start of war, disease, or fire. 'Break into' = enter a building illegally by force.",
            examHighlight = "'Dengue broke out in the village' (not broke down)."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Phrasal Verbs with 'Carry': Carry on, Carry out",
            detail = "'Carry on' = continue an action ('Carry on with your work'). 'Carry out' = execute, perform or conduct ('The scientists carried out an experiment').",
            examHighlight = "Essential for scientific and descriptive essay writing."
          ),
          SubjectFactPoint(
            number = 7,
            title = "Phrasal Verbs with 'Call': Call off, Call on, Call for",
            detail = "'Call off' = cancel an event ('The cricket match was called off due to heavy rain'). 'Call on' = visit someone briefly. 'Call for' = demand or require.",
            examHighlight = "'Call off' = cancel, while 'put off' = postpone. Do not confuse them."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Idiom: 'A blessing in disguise'",
            detail = "Meaning: Something that appears bad or unfortunate at first, but ultimately results in a beneficial outcome.",
            examHighlight = "Great idiom for reflective essays and story endings."
          ),
          SubjectFactPoint(
            number = 9,
            title = "Idiom: 'Burn the midnight oil'",
            detail = "Meaning: To stay up late into the night working or studying diligently.",
            examHighlight = "'O/L students often burn the midnight oil before national examinations.'"
          ),
          SubjectFactPoint(
            number = 10,
            title = "Idiom: 'Once in a blue moon'",
            detail = "Meaning: Occurring very rarely or almost never.",
            examHighlight = "'He visits his hometown once in a blue moon due to his busy overseas schedule.'"
          ),
          SubjectFactPoint(
            number = 11,
            title = "Idiom: 'Leave no stone unturned'",
            detail = "Meaning: To do everything possible and explore every avenue to achieve a goal or resolve an issue.",
            examHighlight = "'The police left no stone unturned in their quest to find the missing child.'"
          ),
          SubjectFactPoint(
            number = 12,
            title = "Idiom: 'Practice makes perfect'",
            detail = "Meaning: Repeated practice is the indispensable key to mastering any skill or language.",
            examHighlight = "Ideal proverb for closing essays on education, music, or sports."
          ),
          SubjectFactPoint(
            number = 13,
            title = "Collocation: 'Do' vs 'Make'",
            detail = "Use 'DO' with chores and obligations: do homework, do business, do someone a favor, do exercise. Use 'MAKE' with creation and sounds: make a mistake, make a decision, make noise.",
            examHighlight = "Say 'make a mistake' (NEVER 'do a mistake'). Highly penalized error!"
          ),
          SubjectFactPoint(
            number = 14,
            title = "Collocation: 'Take' vs 'Have'",
            detail = "Take an exam, take a photo, take medicine, take care. Have breakfast, have fun, have a conversation, have an argument.",
            examHighlight = "In Sri Lanka students often say 'give an exam' incorrectly; the student TAKES the exam."
          ),
          SubjectFactPoint(
            number = 15,
            title = "Strong Adjective-Noun Collocations",
            detail = "'Heavy rain' (not strong rain), 'Strong wind' (not heavy wind), 'Deep sleep' (not high sleep), 'High temperature', 'Fast food', 'Quick meal'.",
            examHighlight = "Using natural collocations proves native-like fluency in writing."
          ),
          SubjectFactPoint(
            number = 16,
            title = "Verb-Noun Collocations for Formal Writing",
            detail = "'Pay attention', 'Express gratitude', 'Raise awareness', 'Achieve goals', 'Solve problems', 'Overcome challenges', 'Grant permission'.",
            examHighlight = "Upgrades basic phrasing into formal academic English."
          ),
          SubjectFactPoint(
            number = 17,
            title = "Idiom: 'Actions speak louder than words'",
            detail = "Meaning: What people actually do is far more significant and truthful than what they claim they will do.",
            examHighlight = "Useful moral conclusion in character narrative essays."
          ),
          SubjectFactPoint(
            number = 18,
            title = "Idiom: 'Bite the bullet'",
            detail = "Meaning: To endure a painful or difficult situation with bravery and fortitude.",
            examHighlight = "'Facing the final exams, he decided to bite the bullet and revise steadily.'"
          ),
          SubjectFactPoint(
            number = 19,
            title = "Collocations with Prepositions",
            detail = "'Interested IN', 'Good AT' (not good in), 'Fond OF', 'Proud OF', 'Afraid OF', 'Famous FOR', 'Different FROM' (or to).",
            examHighlight = "Say 'She is good at English' (NEVER 'good in English'). Tested every year!"
          ),
          SubjectFactPoint(
            number = 20,
            title = "Exam Prudence: Moderation in Idiom Usage",
            detail = "Do not stuff your essays with too many forced idioms. 1 or 2 well-placed, natural idioms enhance an essay, whereas excessive idioms sound artificial.",
            examHighlight = "Natural accuracy always scores higher than forced ornamentation."
          )
        )
      ),

      // Category 19: Prefixes, Suffixes & Word Formation
      SubjectMasterCategory(
        id = "eng_cat_19",
        categoryNumber = 19,
        titleSinhala = "Prefixes, Suffixes & Word Formation",
        icon = "🧩",
        color = Color(0xFF0284C7),
        summary = "Negative prefixes, noun-forming suffixes, verb transformations, adjective derivations in word family grids.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Negative Prefixes: 'Un-', 'In-', 'Im-', 'Il-', 'Ir-'",
            detail = "'Un-' (happy -> unhappy), 'In-' (correct -> incorrect), 'Im-' before 'm' or 'p' (possible -> impossible, mature -> immature), 'Il-' before 'l' (legal -> illegal), 'Ir-' before 'r' (regular -> irregular).",
            examHighlight = "Phonetic harmony determines which negative prefix to attach."
          ),
          SubjectFactPoint(
            number = 2,
            title = "Negative Prefixes: 'Dis-' and 'Mis-'",
            detail = "'Dis-' expresses opposite or removal (agree -> disagree, appear -> disappear). 'Mis-' expresses wrongly or badly (understand -> misunderstand, place -> misplace).",
            examHighlight = "'Misjudged' means judged wrongly; 'distrusted' means lack of trust."
          ),
          SubjectFactPoint(
            number = 3,
            title = "Noun Suffixes: '-tion', '-sion', '-ment'",
            detail = "Form abstract nouns from verbs: educate -> education, decide -> decision, improve -> improvement, develop -> development, govern -> government.",
            examHighlight = "Check spelling: omit silent 'e' before '-tion' (populate -> population)."
          ),
          SubjectFactPoint(
            number = 4,
            title = "Noun Suffixes for People: '-er', '-or', '-ist', '-ian'",
            detail = "Designate professions and roles: teach -> teacher, act -> actor, piano -> pianist, music -> musician, electric -> electrician.",
            examHighlight = "Notice spelling transformations: 'magic' -> 'magician'."
          ),
          SubjectFactPoint(
            number = 5,
            title = "Noun Suffixes from Adjectives: '-ness', '-ity'",
            detail = "Kind -> kindness, happy -> happiness (y becomes i), dark -> darkness, curious -> curiosity, active -> activity, pure -> purity.",
            examHighlight = "Watch y to i shift: 'lonely' -> 'loneliness'."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Adjective Suffixes: '-ful' and '-less'",
            detail = "'-ful' means full of (care -> careful, beauty -> beautiful - note single 'l'!). '-less' means without (care -> careless, home -> homeless, hope -> hopeless).",
            examHighlight = "NEVER write 'carefull' or 'usefull'; '-ful' has only ONE 'l'!"
          ),
          SubjectFactPoint(
            number = 7,
            title = "Adjective Suffixes: '-able' and '-ible'",
            detail = "Indicate ability to undergo action: read -> readable, accept -> acceptable, rely -> reliable. '-ible': visible, audible, sensible, eligible.",
            examHighlight = "Drop final 'e' before '-able': 'value' -> 'valuable'."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Adjective Suffix: '-ous'",
            detail = "Danger -> dangerous, fame -> famous (drop e), courage -> courageous (retain e to keep 'g' soft), disaster -> disastrous.",
            examHighlight = "'Disastrous' drops the 'e' from disaster. A common spelling error."
          ),
          SubjectFactPoint(
            number = 9,
            title = "Verb-Forming Suffixes: '-en', '-ify', '-ize / -ise'",
            detail = "Wide -> widen, short -> shorten, pure -> purify, simple -> simplify, modern -> modernize, apology -> apologize.",
            examHighlight = "Turn nouns and adjectives into dynamic action verbs."
          ),
          SubjectFactPoint(
            number = 10,
            title = "Verb-Forming Prefix: 'En- / Em-'",
            detail = "Attaches to nouns/adjectives to mean cause to be: courage -> encourage, large -> enlarge, danger -> endanger, power -> empower.",
            examHighlight = "'Enrich', 'enable', 'ensure' are powerful verbs in formal compositions."
          ),
          SubjectFactPoint(
            number = 11,
            title = "Adverb Formation with '-ly'",
            detail = "Most adverbs are formed by adding '-ly' to adjectives: slow -> slowly, quick -> quickly. If ending in '-y': easy -> easily, heavy -> heavily.",
            examHighlight = "Exceptions: 'fast' (adverb is 'fast', NOT fastly!), 'hard', 'late'."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Adjectives Ending in '-ic' -> '-ically'",
            detail = "Adjectives ending in '-ic' form adverbs with '-ically': dramatic -> dramatically, tragic -> tragically, specific -> specifically. Exception: public -> publicly.",
            examHighlight = "Tested frequently in vocabulary transformation questions."
          ),
          SubjectFactPoint(
            number = 13,
            title = "Compound Nouns Formation",
            detail = "Formed by joining two words: noun + noun (sunlight, classroom), adjective + noun (blackboard, greenhouse), verb + noun (swimming pool, washing machine).",
            examHighlight = "Recognize single-word compounds vs hyphenated compounds."
          ),
          SubjectFactPoint(
            number = 14,
            title = "Prefix 'Re-' (Again) and 'Pre-' (Before)",
            detail = "'Re-' denotes repetition: rewrite, revisit, rebuild, rehydrate. 'Pre-' denotes occurring prior: prehistoric, preview, prepare, premature.",
            examHighlight = "Helps deduce unfamiliar vocabulary during reading comprehension."
          ),
          SubjectFactPoint(
            number = 15,
            title = "Prefix 'Inter-' (Between) and 'Intra-' (Within)",
            detail = "'Inter-' = between different groups (international, intermediate, interact). 'Intra-' = inside a single organization (intraschool sports meet).",
            examHighlight = "Crucial distinction when writing school event reports."
          ),
          SubjectFactPoint(
            number = 16,
            title = "Prefix 'Over-' and 'Under-'",
            detail = "'Over-' = too much (overcrowded, overestimate, oversleep). 'Under-' = insufficient or beneath (underpaid, underestimate, underground).",
            examHighlight = "'The classroom was overcrowded due to combined sections.'"
          ),
          SubjectFactPoint(
            number = 17,
            title = "Word Family Chart Mastery",
            detail = "Memorize full 4-column tables: Noun (Success), Verb (Succeed), Adjective (Successful), Adverb (Successfully).",
            examHighlight = "Paper I Question 5 frequently requires completing word family matrices."
          ),
          SubjectFactPoint(
            number = 18,
            title = "Suffix '-ship' and '-hood'",
            detail = "Denote status, relationship or condition: friend -> friendship, citizen -> citizenship, leader -> leadership, child -> childhood, neighbor -> neighborhood.",
            examHighlight = "Abstract nouns frequently featured in theme-based compositions."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Doubling Final Consonant Rule",
            detail = "When adding a suffix beginning with a vowel to a single-syllable word ending in single vowel + single consonant: run -> runner, big -> bigger, swim -> swimming.",
            examHighlight = "Does not double if there are two vowels: 'read' -> 'reading'."
          ),
          SubjectFactPoint(
            number = 20,
            title = "Exam Application: Context-Driven Word Class Selection",
            detail = "Read the test sentence: 'His sudden [depart] shocked everyone.' The preceding possessive 'his' and adjective 'sudden' require a NOUN: 'departure'.",
            examHighlight = "Identify the required part of speech before inserting the transformed word."
          )
        )
      ),

      // Category 20: Common Spelling & Punctuation Traps
      SubjectMasterCategory(
        id = "eng_cat_20",
        categoryNumber = 20,
        titleSinhala = "Common Spelling & Punctuation Traps",
        icon = "🎯",
        color = Color(0xFF0284C7),
        summary = "Apostrophes, commas, capital letters, homophones, silent letters, high-frequency misspelled words in national exams.",
        points = listOf(
          SubjectFactPoint(
            number = 1,
            title = "Apostrophe for Contraction vs Possession",
            detail = "Contraction: replaces omitted letters ('it's' = it is, 'don't' = do not). Possession: indicates ownership ('Kamal's book', 'the students' bags').",
            examHighlight = "Never use an apostrophe for ordinary plurals! 'Apples' (NOT apple's)."
          ),
          SubjectFactPoint(
            number = 2,
            title = "'Its' vs 'It's' Trap",
            detail = "'It's' (with apostrophe) ALWAYS means 'it is' or 'it has'. 'Its' (without apostrophe) is the possessive pronoun: 'The cat licked its paws.'",
            examHighlight = "Replace with 'it is' to test: 'The cat licked it is paws' is wrong, so use 'its'!"
          ),
          SubjectFactPoint(
            number = 3,
            title = "Plural Nouns Possessive Apostrophe Placement",
            detail = "Singular noun: 'the boy's dog' (one boy). Plural noun ending in 's': 'the boys' hostel' (apostrophe after the 's'). Irregular plural: 'children's park'.",
            examHighlight = "Common O/L error correction test item."
          ),
          SubjectFactPoint(
            number = 4,
            title = "Homophones: 'Their', 'There', 'They're'",
            detail = "'Their' = possessive ('their house'). 'There' = location or existence ('over there', 'there is a problem'). 'They're' = they are ('they're playing').",
            examHighlight = "Writing 'there house' is an immediate red mark for basic competence."
          ),
          SubjectFactPoint(
            number = 5,
            title = "Homophones: 'Whose' vs 'Who's'",
            detail = "'Who's' = contraction of 'who is' or 'who has' ('Who's coming to the party?'). 'Whose' = possessive pronoun ('Whose pen is this?').",
            examHighlight = "Test with 'who is' substitution."
          ),
          SubjectFactPoint(
            number = 6,
            title = "Homophones: 'Accept' vs 'Except'",
            detail = "'Accept' (verb) = to receive or agree to ('I accept your invitation'). 'Except' (preposition) = excluding ('Everyone came except Sunil').",
            examHighlight = "Note the different pronunciation and grammatical function."
          ),
          SubjectFactPoint(
            number = 7,
            title = "Homophones: 'Affect' vs 'Effect'",
            detail = "'Affect' is usually a VERB meaning to influence ('Pollution affects our health'). 'Effect' is usually a NOUN meaning result ('The greenhouse effect').",
            examHighlight = "Memory trick: A for Action (Affect is a verb); E for End result (Effect is a noun)."
          ),
          SubjectFactPoint(
            number = 8,
            title = "Silent Letters: 'K', 'W', 'B', 'L', 'G'",
            detail = "Silent 'k': knife, know, knee, knight. Silent 'w': write, wrong, answer, sword. Silent 'b': doubt, debt, comb, thumb. Silent 'l': half, calm, talk, walk.",
            examHighlight = "Memorize accurate spellings despite the unpronounced consonants."
          ),
          SubjectFactPoint(
            number = 9,
            title = "'I before E except after C' Rule",
            detail = "Generally write 'ie': believe, relieve, chief, field, friend. Except after 'c', where it becomes 'ei': receive, ceiling, deceive, receipt.",
            examHighlight = "Exceptions: weird, foreign, height, neighbor."
          ),
          SubjectFactPoint(
            number = 10,
            title = "Top Misspelled Words: 'Necessary', 'Accommodate', 'Receive'",
            detail = "'Necessary' = 1 'c' and 2 's's (One Collar, Two Sleeves). 'Accommodate' = 2 'c's and 2 'm's. 'Environment' = don't forget the 'n' before 'ment'!",
            examHighlight = "Write 'environment', 'government', 'grammar' (not grammer!)."
          ),
          SubjectFactPoint(
            number = 11,
            title = "Capital Letter Mandates: Proper Nouns & Days",
            detail = "Capitalize: Names of people, countries, cities, days of the week, months, holidays, languages, titles, and the pronoun 'I' (always capital!).",
            examHighlight = "Never write 'english', 'sunday', or a lowercase 'i' by itself."
          ),
          SubjectFactPoint(
            number = 12,
            title = "Comma Splice Error and How to Fix It",
            detail = "Do NOT join two independent sentences with only a comma: 'I arrived late, the gate was closed' (INCORRECT). Use a period, semicolon, or coordinating conjunction.",
            examHighlight = "Correct: 'I arrived late, so the gate was closed.' or 'I arrived late. The gate was closed.'"
          ),
          SubjectFactPoint(
            number = 13,
            title = "Oxford Comma in Lists",
            detail = "Use commas to separate items in a series: 'We bought apples, oranges, mangoes, and bananas.' Prevents ambiguity in complex lists.",
            examHighlight = "Place a comma between distinct adjectives modifying the same noun."
          ),
          SubjectFactPoint(
            number = 14,
            title = "Direct Speech Quotation Marks (Inverted Commas)",
            detail = "'Look at the board,' the teacher said. Note that the comma goes INSIDE the quotation marks. Capitalize the first letter of quoted speech: She asked, 'Are you ready?'",
            examHighlight = "Essential for narrative writing in Paper II Question 16."
          ),
          SubjectFactPoint(
            number = 15,
            title = "Hyphens in Compound Adjectives Before Nouns",
            detail = "Use a hyphen when a compound adjective precedes a noun: 'a three-hour examination', 'a well-known author', 'an up-to-date report'.",
            examHighlight = "No hyphen if it comes after the verb: 'The author is well known.'"
          ),
          SubjectFactPoint(
            number = 16,
            title = "Question Mark and Exclamation Mark Rules",
            detail = "Only use a question mark for direct questions ('Where are you going?'). Do NOT use a question mark for indirect questions ('He asked where I was going.').",
            examHighlight = "Indirect questions end with a standard period, not a question mark."
          ),
          SubjectFactPoint(
            number = 17,
            title = "Spelling: 'Lose' vs 'Loose'",
            detail = "'Lose' (rhymes with choose) is a verb meaning to misplace or be defeated. 'Loose' (rhymes with goose) is an adjective meaning not tight.",
            examHighlight = "'Do not lose your hall ticket.' 'Wear loose, comfortable clothes.'"
          ),
          SubjectFactPoint(
            number = 18,
            title = "Spelling: 'Principal' vs 'Principle'",
            detail = "'Principal' = head of a school or chief matter ('The school principal addressed the assembly'). 'Principle' = fundamental truth, moral rule or law.",
            examHighlight = "Memory tip: The princi-PAL is your PAL (person); a princi-PLE is a ru-LE."
          ),
          SubjectFactPoint(
            number = 19,
            title = "Spelling: 'Past' vs 'Passed'",
            detail = "'Passed' is the past tense verb of pass ('He passed the examination'). 'Past' refers to time gone by, distance, or a preposition ('walked past the library').",
            examHighlight = "Do not write 'time has passed by' with 'past'."
          ),
          SubjectFactPoint(
            number = 20,
            title = "Proofreading Technique: Read Backward for Spelling",
            detail = "To spot spelling errors without being distracted by sentence meaning, read sentences word-by-word from right to left. Isolates individual word forms.",
            examHighlight = "Uncovers hidden misspellings before submitting your answer script."
          )
        )
      )
    )
  }
}
