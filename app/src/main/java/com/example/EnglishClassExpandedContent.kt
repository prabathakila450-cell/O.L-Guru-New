package com.example

/**
 * 200+ Word Rich Content Datasets for English Master Class
 * Providing comprehensive essays, letters, speeches, dialogues, cloze passages, and listening scripts.
 */
object EnglishExpandedContentData {

  fun getExpandedWritingTemplates(): List<WritingTemplateItem> {
    return listOf(
      WritingTemplateItem(
        id = "tpl_notice",
        title = "School Notice Writing Format (දැන්වීම් ආකෘතිය - 200+ Words)",
        type = "NOTICE",
        description = "O/L විභාගයේ Test 3 & 4 සඳහා සම්පූර්ණ ලකුණු ලබාගැනීමේ 200+ වචන ආදර්ශ දැන්වීම.",
        structureSteps = listOf(
          "1. Official Header: NOTICE (Capital letters centered)",
          "2. Name of Issuing Authority & Organization",
          "3. Clear Title of Event / Championship / Campaign",
          "4. Specific Dates, Timings, and Exact Venues",
          "5. Target Audience, Grade Levels, and Eligibility Requirements",
          "6. Rules, Entry Deadlines, Submission Counters, and Guidelines",
          "7. Official Sign-off: Designation, Club Name, School Name & Date"
        ),
        modelFormat = """
NOTICE
ANNUAL INTER-HOUSE ENGLISH LITERARY FESTIVAL AND DEBATING CHAMPIONSHIP 2026

This is to officially notify all students of Grades 9, 10, and 11 that the Annual Inter-House English Literary Festival and Debating Championship, organized by the English Literary Association in collaboration with the Department of Languages, will be staged next month on a grand academic scale. The principal aim of this prestigious festival is to develop high communicative fluency, persuasive speech delivery, analytical reasoning, and creative writing talents among our young scholars.

Event Schedule & Program:
• Date: Friday, 28th October 2026
• Commencing Time: 8:30 AM to 3:30 PM (Full Day Event)
• Venue: College Main Assembly Hall and Senior Lecture Theatre
• Chief Guest: Prof. Gamini Samaranayake (Department of English, University of Peradeniya)

Competitions and Categories:
1. Senior Impromptu and Prepared Public Speaking
2. Inter-House Parliamentary Debate Championship
3. Creative Prose and Short Story Writing Contest
4. Comprehensive English Grammar and Spelling Bee Contest

Participation Guidelines & Registration:
All bonafide students studying in Grades 9, 10, and 11 are eligible and warmly encouraged to represent their respective houses. Each participant may enroll in up to two competitive events. Official entry forms are available with your class English language teachers from tomorrow onwards. Duly completed registration slips endorsed by your House Master must be handed over to the undersigned at the English Activity Room on or before Tuesday, 18th October 2026 at 1:30 PM. No late applications will be entertained under any circumstances.

Come, showcase your linguistic talents and bring glory to your house!

Kavindu Wickramasinghe,
Honorary Secretary,
English Literary and Debating Association,
Dharmaraja College, Kandy.
14th September 2026.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_letter",
        title = "Formal Letter to Authority (නිල ලිපි ආකෘතිය - 200+ Words)",
        type = "FORMAL_LETTER",
        description = "විදුහල්පතිතුමාට හෝ රජයේ නිලධාරියෙකුට කරුණු දක්වන 200+ වචන පූර්ණ නිල ලිපිය.",
        structureSteps = listOf(
          "1. Sender's Address & Date (Top Left)",
          "2. Recipient's Designation & Official Address",
          "3. Formal Salutation: 'Dear Sir / Madam,'",
          "4. Explicit Subject Heading",
          "5. Paragraph 1: Direct Statement of Purpose and Authorization Request",
          "6. Paragraph 2: Comprehensive Details (Participants, dates, schedule, resources)",
          "7. Paragraph 3: Expected Benefits to Pupils, Safety Protocols, and Teacher In-Charge Supervision",
          "8. Courteous Concluding Request & Professional Sign-off"
        ),
        modelFormat = """
Nature and Wildlife Conservation Society,
Mahanama College,
R. A. De Mel Mawatha,
Colombo 03.
15th October 2026.

The Principal,
Mahanama College,
Colombo 03.

Dear Sir,

Request for Permission to Organize an Environmental Conservation Seminar and Campus Tree Planting Campaign

I am writing this letter in my capacity as the President of the School Nature and Wildlife Conservation Society, on behalf of our committee members, to respectfully seek your kind approval to organize an educational seminar and tree planting campaign within the school premises in commemoration of World Environment Day.

We propose to conduct this meaningful program on Friday, 5th November 2026, commencing from 8:30 AM to 1:30 PM at the College Gymnasium and the surrounding school garden grounds. The Central Environmental Authority and the Urban Forestry Division have graciously consented to sponsor this initiative by donating two hundred indigenous saplings, including Kumbuk, Mee, and Karanda varieties. Furthermore, Dr. Jagath Gunawardena, renowned environmental legal advisor, has accepted our invitation to deliver the keynote address on "Combating Plastic Pollution and Safeguarding Urban Biodiversity."

Approximately one hundred and fifty senior students from Grades 10 and 11 will participate in the planting session under the close personal supervision of our Master-in-Charge, Mr. K. B. Senanayake, and senior science faculty teachers. We have devised a structured schedule to guarantee that regular classroom proceedings for other grades will not experience any disturbance. A dedicated student safety team has been mobilized to oversee the handling of garden equipment and ensure high discipline throughout the day.

This valuable endeavor will instill lasting environmental stewardship, practical conservation habits, and social responsibility among our youth. Therefore, we would be exceedingly grateful if you could kindly grant us formal authorization to organize this event and permit the use of the College Gymnasium for the seminar.

Thanking you.

Yours faithfully,
Sachintha Bandara,
President,
Nature and Wildlife Conservation Society.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_informal_letter",
        title = "Informal Letter to a Friend (මිතුරෙකුට සුහද ලිපිය - 200+ Words)",
        type = "INFORMAL_LETTER",
        description = "නිවාඩු චාරිකාවක් හෝ විශේෂ අත්දැකීමක් මිතුරෙකු සමඟ බෙදාගන්නා 200+ වචන පූර්ණ සුහද ලිපිය.",
        structureSteps = listOf(
          "1. Sender's Address & Date",
          "2. Affectionate Greeting: 'Dear Kasun,'",
          "3. Warm Opening: Inquiring after health, family wellbeing, and exam studies",
          "4. Body Paragraph 1: Detailed description of the journey, destination, climate, and scenic surroundings",
          "5. Body Paragraph 2: Memorable activities, historical sites, boat rides, local dishes, and cultural highlights",
          "6. Body Paragraph 3: Reflections, photographs taken, souvenirs bought, and inquiry into the friend's vacation",
          "7. Affectionate Sign-off & Regards to Family"
        ),
        modelFormat = """
No. 45, Temple Road,
Peradeniya,
Kandy.
18th October 2026.

Dear Kasun,

How are you doing these days? I hope you and your family are enjoying excellent health and happiness. As we both recently finished our hectic term test evaluations, I decided to take some quiet time this evening to write to you and share the wonderful memories of my recent weekend trip to the misty hills of Ella and Nuwara Eliya with my parents and sister.

Last Saturday morning, we boarded the early morning express train from Peradeniya railway station. The scenic train ride through cascading waterfalls, lush green tea carpeted hills, and dark railway tunnels was an absolute visual feast. We stayed at a quaint hillside chalet overlooking Ella Rock. Early the following morning, we hiked up Little Adam’s Peak just in time to watch the sunrise. The golden morning rays breaking through the swirling white mountain mist felt like stepping into an enchanted dream world. I took dozens of breathtaking photographs with my camera, capturing the dramatic mountain ridges.

Later in the afternoon, we visited the architectural marvel known as the Nine Arches Bridge in Demodara and were thrilled to watch the blue locomotive glide gracefully across the historic stone viaduct. We also toured an ancient Ceylon black tea processing factory, where an experienced tea planter guided us through the entire production cycle from fresh green leaf plucking to rolling and drying. The fragrant aroma of freshly brewed broken orange pekoe tea was simply irresistible, and I bought a special presentation box of mountain tea as a gift for your parents.

How have you been spending your school vacation in Galle? Have you started your final revision timetable for the upcoming G.C.E. Ordinary Level examination? Please write back soon whenever you find a free moment, as I am eager to catch up on your news. Give my warmest regards to your kind parents and loving younger brother.

Your loving friend,
Nuwan
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_essay_structure",
        title = "O/L Essay 5-Paragraph Framework (රචනා ආකෘතිය - 250+ Words)",
        type = "ESSAY_TEMPLATE",
        description = "ඕනෑම විෂය මාතෘකාවකට ලකුණු 15න් 14+ ලබාගත හැකි පූර්ණ 5-ඡේද රචනා ආකෘතිය.",
        structureSteps = listOf(
          "Paragraph 1 (Introduction): Hook statement + Background + Clear thesis statement.",
          "Paragraph 2 (Pillar 1 - Academic & Scientific Advancement): In-depth discussion + Concrete evidence.",
          "Paragraph 3 (Pillar 2 - Global Employment & Economic Mobility): Career prospects + Corporate value.",
          "Paragraph 4 (Pillar 3 - Cross-Cultural Understanding & Diplomacy): International peace + Harmony.",
          "Paragraph 5 (Conclusion): Comprehensive synthesis + Inspiring future call-to-action."
        ),
        modelFormat = """
THE INDISPENSABLE VALUE OF MASTERING ENGLISH AS A GLOBAL LANGUAGE IN THE MODERN ERA

In this hyper-connected twenty-first century, the English language has firmly established itself as the undisputed international lingua franca linking civilizations, economies, and intellectual cultures worldwide. Rather than being treated merely as a conventional examination subject within secondary school curricula, English serves as an empowering global life skill that dismantles geographical frontiers and unlocks a universe of intellectual and professional possibilities for ambitious youth.

First and foremost, English functions as the foundational currency of international higher education, scientific inquiry, and technological innovation. Over eighty percent of the world’s peer-reviewed scientific journals, computer programming languages, and advanced research databases are published in English. A Sri Lankan student equipped with strong English reading comprehension can effortlessly access digital libraries belonging to prestigious global universities such as Oxford, Cambridge, or Harvard. By following free open courseware online, our youth can master modern computer coding, renewable energy technologies, and artificial intelligence without financial constraints. Consequently, English language proficiency directly bridges the knowledge disparity between developing nations and advanced industrial societies.

Furthermore, command over articulate English communication substantially multiplies vocational prospects in today’s fiercely competitive job market. Leading multinational conglomerates, information technology firms, international banking institutions, and aviation and hospitality corporations consistently prioritize job applicants who demonstrate fluent spoken and written English. Professional success often hinges upon one's capacity to draft lucid business proposals, present boardroom pitches to international clients, and collaborate harmoniously with multinational colleagues. Hence, linguistic fluency serves as a golden passport to upward economic mobility and international career opportunities.

In addition to academic and economic advantages, learning English promotes cross-cultural empathy and global harmony. Through the appreciation of global literature, world cinema, and digital cultural exchanges, students develop open-mindedness and respect for diverse cultural traditions. It empowers Sri Lankan youngsters to eloquently project our nation's rich Buddhist heritage, natural biodiversity, and historic wonders to foreign travelers and international audiences.

In conclusion, becoming proficient in English is an indispensable requirement for every modern student. While cherishing and preserving our native mother tongues, every student must commit to daily English reading, active listening, and fearless speaking practice. By doing so, our youth can step into tomorrow's interconnected world with pride, competence, and international stature.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_graph_desc",
        title = "Bar Chart & Data Description (ප්‍රස්ථාර විස්තර කිරීම - 200+ Words)",
        type = "GRAPH_DESCRIPTION",
        description = "O/L Test 14 සඳහා සම්පූර්ණ ලකුණු ලබාගැනීමේ 200+ වචන පූර්ණ ප්‍රස්ථාර විග්‍රහය.",
        structureSteps = listOf(
          "Sentence 1 (Introduction): 'This informative bar chart illustrates the statistical distribution of...'",
          "Sentence 2 (Axis Breakdown): Explain what is represented on the horizontal (X) and vertical (Y) axes.",
          "Sentence 3 (Dominant Highest Category): State the peak figure with exact percentages and societal context.",
          "Sentence 4 (Lowest Proportion): State the lowest category using sharp contrasting transitional connectors.",
          "Sentence 5 (Comparative Analysis): Compare intermediate figures, highlighting ratios and differences.",
          "Sentence 6 (Analytical Synthesis): Interpret the practical implications of these consumer/student patterns.",
          "Sentence 7 (Conclusion): 'In conclusion / Overall, it is vividly apparent that...'"
        ),
        modelFormat = """
ANALYTICAL INTERPRETATION OF A BAR CHART ON PREFERRED LEISURE PASTIMES AMONG GRADE 11 STUDENTS

This informative bar chart illustrates the statistical distribution of preferred leisure time activities among a representative cohort of two hundred Grade 11 students surveyed at a leading national school in Sri Lanka. The horizontal X-axis categorizes five prominent recreational pursuits—namely Playing Outdoor Sports, Browsing the Internet, Reading Books, Watching Television, and Gardening—while the vertical Y-axis denotes the corresponding percentage proportion of student preferences.

According to the provided empirical data, playing outdoor sports clearly emerges as the single most popular leisure activity, commanding an impressive forty percent (40%) of the total student vote. This pronounced preference demonstrates a commendable consciousness among young scholars regarding physical wellness, athletic vigor, and team camaraderie. In stark contrast, home gardening ranks as the least preferred recreational pastime, attracting a modest eight percent (8%) of the votes, which indicates that urban housing limitations and busy study routines may restrict youth involvement in agricultural hobbies.

A deeper comparative examination reveals that browsing the internet occupies the second highest position with twenty-six percent (26%), highlighting the pervasive influence of smartphones, interactive educational apps, and social networks in adolescent daily life. Meanwhile, reading literature books and watching television recorded moderate participation rates of sixteen percent (16%) and ten percent (10%) respectively. Significantly, the percentage of students engaged in digital online browsing is more than triple the number of students committed to traditional home gardening.

Overall, it is distinctly evident from the chart that active physical recreation and digital web activities dominate the leisure habits of contemporary schoolchildren, whereas traditional domestic pastimes have witnessed a marked decline.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_speech",
        title = "School Assembly Speech (පාසල් රැස්වීම් කථාව - 230+ Words)",
        type = "SPEECH",
        description = "පාසල් රැස්වීමකදී හෝ උත්සවයකදී පවත්වන කථාවක් ලිවීමේ 230+ වචන පූර්ණ ආකෘතිය.",
        structureSteps = listOf(
          "1. Honorable Formal Address to Dignitaries, Teachers, and Peers",
          "2. Pleasant Greeting & Formal Announcement of the Theme",
          "3. Deep Discussion on Discipline as the Foundation of Academic Triumphs",
          "4. Powerful Insights on Emotional Resilience in Overcoming Exam Pressures",
          "5. Inspiring Historical Parallels and Real-World Motivation",
          "6. Urgent Call to Collective Action & Heartfelt Concluding Gratitude"
        ),
        modelFormat = """
SPEECH ON "THE CRITICAL VALUE OF DISCIPLINE AND RESILIENCE FOR ACADEMIC TRIUMPH"

Respected Principal, beloved teachers, invited guests, and my dear fellow schoolmates,

A very pleasant, refreshing, and inspiring good morning to you all!

Today, I stand before this distinguished assembly with profound honor to share a few heartfelt reflections on a theme that fundamentally shapes our destiny as students: "The Critical Value of Discipline and Resilience for Academic Triumph."

We live in a world that often glorifies natural talent and sudden fortune. Yet, history consistently proves that raw intellect without self-discipline is like an expensive sports vehicle without an engine—it may look dazzling, but it is utterly incapable of moving forward. Discipline is the quiet power of character. It is the conscious decision to wake up at dawn to revise complex mathematical theorems, to resist the addictive lure of social media notifications, to maintain punctuality at morning school assemblies, and to complete our academic assignments with pride and meticulous care.

Equally indispensable on our educational journey is the golden virtue of resilience. Academic life is not a smooth, triumphant parade; it is a marathon filled with steep hills, unexpected setbacks, and rigorous examinations. There will inevitably be tests where our scores fall below expectations or concepts that take weeks to comprehend. In those testing moments, a resilient mind refuses to succumb to disappointment. Instead, resilient students treat every error as valuable feedback. Remember that Thomas Alva Edison conducted over ten thousand experiments before successfully creating the electric bulb.

Dear friends, the upcoming G.C.E. Ordinary Level examination is not an obstacle meant to defeat us; it is a sacred platform where our sweat, perseverance, and dedication will be rewarded. Let us support our peers, honor the selfless guidance of our teachers, and resolve to build unwavering daily discipline. If we sow the seeds of diligence today, we will undoubtedly reap the golden harvest of academic success tomorrow.

Thank you very much for your patient and kind attention. Have a victorious day ahead!
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_article",
        title = "School Magazine Feature Article (සඟරා ලිපියක් - 250+ Words)",
        type = "ARTICLE",
        description = "පාසල් සඟරාවට හෝ පුවත්පතට සම්පාදනය කරන 250+ වචන පූර්ණ ආකර්ෂණීය ලිපිය.",
        structureSteps = listOf(
          "1. Catchy, Thought-Provoking Title",
          "2. Byline Indicating Author’s Name and Grade",
          "3. Captivating Introductory Hook Exploring the Dual Nature of Modern Technology",
          "4. Comprehensive Body Paragraph 1: Educational Innovations, Virtual Labs, and Equal Access to Knowledge",
          "5. Critical Body Paragraph 2: Shadowy Pitfalls (Digital Addiction, Mental Fatigue, Superficial Thinking)",
          "6. Pragmatic Recommendations for Healthy Digital Discipline and School Guidelines",
          "7. Visionary Concluding Synthesis"
        ),
        modelFormat = """
THE DIGITAL REVOLUTION IN CONTEMPORARY CLASSROOMS: A BLESSING OR A SILENT DISTRACTION?
By Malsha Jayasuriya (Senior Prefect, Grade 11-A)

In this dynamic dawn of the twenty-first century, digital technology has fundamentally transformed every dimension of human life, with the educational landscape positioned squarely at the center of this technological revolution. The classic chalkboards and heavy paper textbooks that defined our parents’ generations are rapidly yielding ground to interactive smartboards, tablet computers, and AI-driven personalized learning applications. However, as modern classrooms embrace this digital wave, a crucial question emerges for educators, parents, and students alike: does the digital revolution truly enrich learning, or is it subtly eroding the focused discipline of our youth?

Undeniably, digital integration has democratized access to quality learning. Today, an ambitious student residing in a rural farming village in Polonnaruwa can explore three-dimensional biological animations of the human circulatory system, watch live physics lectures from world-class laboratories, and download complete past examination archives within seconds. Complex scientific theorems that were once dry and abstract now come alive through colorful interactive simulations. Language learning software provides instant pronunciation correction, enabling shy learners to practice spoken English in private without fear of embarrassment.

Nevertheless, this digital coin carries a shadowy side that cannot be overlooked. The very handheld devices created to enlighten students frequently become channels for chronic distraction. Constant alerts from social media networks, addictive algorithmic short video feeds, and immersive online video games lure pupils away from rigorous revision schedules. Extended screen exposure has triggered alarming spikes in adolescent physical health problems, including severe digital eye fatigue, headaches, poor spinal posture, and disrupted sleep cycles. Furthermore, the easy availability of automated internet search tools often encourages superficial copying rather than deep intellectual inquiry and independent critical reflection.

In the final analysis, digital technology is neither an inherent miracle nor an inevitable curse; it is a potent instrument whose true value depends entirely on human self-control. To harness its immense educational potential, schools and homes must collaborate to promote sensible digital hygiene. Gadgets must be respected as educational tools rather than casual toys of amusement. By cultivating purposeful focus and digital balance, Sri Lanka’s young generation can turn technology into a luminous beacon lighting the path to national prosperity.
        """.trimIndent()
      ),

      WritingTemplateItem(
        id = "tpl_linking_words",
        title = "Mastering Cohesive Devices & Transition Words (200+ Words Guide)",
        type = "LINKING_WORDS",
        description = "රචනාවට සහ ලිපිවලට ඉහළ ලකුණු ගෙන දෙන පද ලැයිස්තුව සහ ප්‍රායෝගික ඡේද භාවිතය.",
        structureSteps = listOf(
          "• Adding Supportive Points: Furthermore, Moreover, Additionally, In addition to this, Besides",
          "• Expressing Contrast & Duality: However, Nevertheless, On the contrary, Conversely, In spite of this",
          "• Providing Concrete Illustrations: For instance, For example, To demonstrate, Specifically, Namely",
          "• Demonstrating Logical Results: Consequently, Therefore, As an inevitable result, Thus, Hence",
          "• Concluding & Synthesizing: In conclusion, To synthesize, All things considered, Ultimately, In summary"
        ),
        modelFormat = """
COHESIVE LINKING WORDS: THE STRUCTURAL FOUNDATION OF O/L ESSAYS

In professional examination marking criteria, paragraph cohesion and sentence flow account for crucial marks under organizational competence. Choppy, disconnected sentences signal amateur writing, whereas smooth transitional connectors guide the examiner effortlessly through your logical arguments.

Study the following model analytical paragraph demonstrating how cohesive devices function seamlessly together:

"Regular book reading is universally acknowledged as one of the most rewarding intellectual habits a young student can cultivate. Furthermore, immersing oneself in diverse literary genres significantly expands one’s vocabulary and sharpens analytical thinking. For instance, students who read historical biographies regularly encounter sophisticated words such as 'perseverance', 'resilience', and 'statesmanship' within natural context, eliminating the tedious need for rote memorization. However, contemporary adolescents frequently complain that their demanding school timetables leave them with virtually no leisure time for extracurricular reading. Nevertheless, educational psychologists emphasize that dedicating even fifteen minutes before bedtime produces profound cognitive gains. Consequently, progressive schools have introduced compulsory weekly library reading hours into their standard curriculum. In addition to fostering academic brilliance, quality literature nurtures empathetic imagination by exposing readers to diverse cultural dilemmas and humanitarian values. Therefore, parents must actively champion home reading habits rather than allowing unregulated video gaming to consume valuable evening hours. In conclusion, cultivating a lifelong passion for books is a priceless investment that guarantees both scholarly triumph and enlightened citizenship."
        """.trimIndent()
      )
    )
  }

  fun getExpandedListeningAudios(): List<ListeningQuizAudio> {
    return listOf(
      ListeningQuizAudio(
        id = "ls_1",
        title = "🎧 Listening Test 1: School Science & Innovation Exhibition (220+ Words Audio Script)",
        audioScript = """
Attention, all students and academic staff members of Dharmaraja College! This is an important official announcement from the Science and Innovation Society regarding our upcoming Annual Science and Technology Exhibition. The exhibition will be held on Friday, the 28th of November, in the main college auditorium, commencing punctually at 8:30 AM and concluding at 4:00 PM. We are deeply privileged to announce that Dr. Senaka Perera, Senior Research Fellow at the National Science Foundation, will grace the inauguration ceremony as our distinguished Chief Guest.

All participating student groups from Grades 9, 10, and 11 must arrive at the venue by 7:15 AM to complete their project displays, electrical wiring checks, and safety inspections. Projects must be positioned within their allotted numerical zones: Section A for Robotic and Automation Systems, Section B for Renewable Energy Models, and Section C for Environmental and Agricultural Innovations. For safety precautions, no naked flames or uninsulated high-voltage batteries are permitted inside the hall.

Admission is entirely free for all students, teachers, and visiting parents. A panel of three university lecturers will judge the exhibits between 10:00 AM and 1:00 PM based on originality, scientific methodology, and verbal presentation. The grand award presentation ceremony will take place at 3:30 PM, where trophies, cash prizes, and certificates will be distributed. Light refreshments will be served at the teachers' pavilion from 11:30 AM. Please maintain strict discipline and help keep our college premises clean and orderly throughout the day.
        """.trimIndent(),
        sinhalaSummary = "පාසල් වාර්ෂික විද්‍යා ප්‍රදර්ශනය නොවැම්බර් 28 සිකුරාදා පෙරවරු 8:30ට ප්‍රධාන ශ්‍රවණාගාරයේදී පැවැත්වේ. ආචාර්ය සේනක පෙරේරා මහතා ප්‍රධාන ආරාධිතයා වේ. සහභාගිවන සිසුන් පෙරවරු 7:15ට පැමිණිය යුතුය.",
        questions = listOf(
          ListeningQuestion(
            questionText = "When will the Annual Science Exhibition commence?",
            options = listOf("At 8:30 AM on Friday, 28th November", "At 7:15 AM on Saturday", "At 10:00 AM on Sunday", "At 4:00 PM on Friday"),
            correctIndex = 0,
            explanation = "ශ්‍රව්‍ය පටයේ 'commencing punctually at 8:30 AM on Friday, the 28th of November' ලෙස පැහැදිලිව සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "By what time should participating students arrive to set up their projects?",
            options = listOf("8:30 AM", "7:15 AM", "9:00 AM", "10:00 AM"),
            correctIndex = 1,
            explanation = "'All participating student groups must arrive at the venue by 7:15 AM' ලෙස සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "What items are strictly prohibited inside the exhibition hall for safety?",
            options = listOf("Cardboard models and posters", "Naked flames and uninsulated high-voltage batteries", "Digital cameras and tablets", "Water bottles and lab coats"),
            correctIndex = 1,
            explanation = "'no naked flames or uninsulated high-voltage batteries are permitted' ලෙස සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "When will the official award presentation ceremony take place?",
            options = listOf("At 8:30 AM", "Between 10:00 AM and 1:00 PM", "At 3:30 PM", "At 11:30 AM"),
            correctIndex = 2,
            explanation = "'The grand award presentation ceremony will take place at 3:30 PM' ලෙස නිවේදනයේ කියවේ."
          )
        )
      ),

      ListeningQuizAudio(
        id = "ls_2",
        title = "🎧 Listening Test 2: Sinharaja Rainforest Ecological Expedition (230+ Words Script)",
        audioScript = """
Good morning, young naturalists and Grade 11 explorers! Welcome to the Kudawa Conservation Center, the primary gateway to the UNESCO World Heritage Sinharaja Rainforest. Before we step onto the forest trail under the ancient canopy, please listen carefully to these vital safety regulations and ecological guidelines delivered by the Department of Wildlife and Forest Conservation.

Sinharaja represents the last viable expanse of primary tropical lowland rainforest in Sri Lanka. It harbors an astonishing seventy-five percent of our country's endemic mammals and ninety-five percent of our endemic bird species. As we proceed along the designated research pathway toward the Research Station, you must walk in single file behind your licensed wildlife tracker and biology teachers. Absolute silence is essential to observe the famous mixed-species bird feeding flocks, where the rare Sri Lanka Blue Magpie, Red-faced Malkoha, and Orange-billed Babbler forage together harmoniously.

Do not attempt to touch or feed any wild reptiles or insects. Due to heavy morning humidity and moist forest soil, land leeches are extremely active; ensure your anti-leech socks are pulled tight above your knee joints and apply herbal citronella spray liberally. All plastic water containers, wrappers, and lunch foils must remain safely sealed inside your backpacks. The forest operates under a strict zero-litter policy, and disposing of any non-biodegradable waste is a punishable legal offense. If anyone feels faint or separates from the squad, blow your emergency whistle three times and remain where you are. Enjoy this rare journey into nature's pristine sanctuary!
        """.trimIndent(),
        sinhalaSummary = "සිංහරාජ වැසි වනාන්තර පර්යේෂණ චාරිකාව පිළිබඳ කුඩව මධ්‍යස්ථානයේදී දෙනු ලබන ආරක්ෂිත හා පාරිසරික උපදෙස් මාලාව.",
        questions = listOf(
          ListeningQuestion(
            questionText = "What proportion of Sri Lanka's endemic bird species are found in Sinharaja?",
            options = listOf("50 percent", "75 percent", "95 percent", "100 percent"),
            correctIndex = 2,
            explanation = "'ninety-five percent of our endemic bird species' ලෙස ශ්‍රව්‍ය පටයේ සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "Why is maintaining absolute silence required during the forest walk?",
            options = listOf("To avoid waking sleeping leopards", "To observe mixed-species bird feeding flocks", "Because speaking is forbidden by law", "To hear the river water flowing"),
            correctIndex = 1,
            explanation = "'Absolute silence is essential to observe the famous mixed-species bird feeding flocks' ලෙස සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "What safety precaution is recommended to prevent land leech bites?",
            options = listOf("Wearing anti-leech socks and applying citronella spray", "Running quickly along the pathway", "Spraying chemical pesticides", "Walking without shoes"),
            correctIndex = 0,
            explanation = "'anti-leech socks are pulled tight above your knee joints and apply herbal citronella spray' සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "What emergency action should a student take if separated from the team?",
            options = listOf("Climb the nearest tall tree", "Run toward the Kudawa center", "Blow the emergency whistle three times and stay put", "Shout loudly until someone responds"),
            correctIndex = 2,
            explanation = "'blow your emergency whistle three times and remain where you are' ලෙස උපදෙස් දී ඇත."
          )
        )
      ),

      ListeningQuizAudio(
        id = "ls_3",
        title = "🎧 Listening Test 3: National Meteorological Advisory & Flood Alert (220+ Words Script)",
        audioScript = """
This is an urgent public weather advisory broadcast by the Department of Meteorology at 6:00 AM on Monday, the 14th of October. The atmospheric disturbance over the south-east Bay of Bengal has intensified into a deep depression and is situated approximately 350 kilometers east of Batticaloa. Consequently, strong gusty winds up to 60 kilometers per hour accompanied by very heavy showers will prevail across the Northern, Eastern, North-Central, and Uva provinces over the next forty-eight hours.

Rainfall amounts exceeding 150 millimeters are heavily anticipated in several catchment areas surrounding the Mahaweli, Kelani, and Kalu river basins. The Irrigation Department warns that water levels in major irrigation reservoirs, including Kantale, Parakrama Samudraya, and Senanayake Samudraya, are rapidly approaching spill levels. Sluice gates may be opened at short notice to release excess water volumes. Residents living along low-lying riverbanks and flood plains are urgently advised to relocate valuable domestic possessions and farm livestock to elevated community shelters.

Furthermore, the National Building Research Organisation has issued a Level 2 Amber Landslide Watch for mountainous divisional secretariats in Badulla, Nuwara Eliya, and Kandy districts. Those residing on steep hill slopes should watch for telltale warning signs, such as slanting utility poles, sudden soil cracks, and muddy water bubbling from hill cuts. For immediate emergency rescue assistance, citizens should contact the Disaster Management Centre through national emergency hotline 117.
        """.trimIndent(),
        sinhalaSummary = "බෙංගාල බොක්කේ ඇතිවූ පීඩන අවපාතය හේතුවෙන් මිලිමීටර් 150 ඉක්මවූ තද වැසි සහ ගංවතුර, නායයෑම් පිළිබඳ කාලගුණ විද්‍යා දෙපාර්තමේන්තුවේ හදිසි නිවේදනය.",
        questions = listOf(
          ListeningQuestion(
            questionText = "What atmospheric phenomenon is causing the heavy weather over Sri Lanka?",
            options = listOf("A tropical drought", "A deep depression over the south-east Bay of Bengal", "A sudden heat wave", "A Pacific tsunami wave"),
            correctIndex = 1,
            explanation = "'deep depression over the south-east Bay of Bengal' ලෙස නිවේදනයේ කියවේ."
          ),
          ListeningQuestion(
            questionText = "What rainfall volume is expected in major river catchment areas?",
            options = listOf("Exceeding 50 mm", "Exceeding 150 millimeters", "Exactly 75 mm", "Below 30 mm"),
            correctIndex = 1,
            explanation = "'Rainfall amounts exceeding 150 millimeters are heavily anticipated' ලෙස සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "What is the national emergency hotline number provided by the Disaster Management Centre?",
            options = listOf("119", "117", "110", "1990"),
            correctIndex = 1,
            explanation = "'Disaster Management Centre through national emergency hotline 117' සඳහන් වේ."
          ),
          ListeningQuestion(
            questionText = "What warning signs should mountainous residents monitor for impending landslides?",
            options = listOf("Heavy sunshine and dryness", "Slanting utility poles, soil cracks, and muddy water bubbling", "Sudden loud thunderstorm noise", "Strong sea waves"),
            correctIndex = 1,
            explanation = "'slanting utility poles, sudden soil cracks, and muddy water bubbling' සඳහන් වේ."
          )
        )
      )
    )
  }

  fun getExpandedDialogues(): List<DialogueConversation> {
    return listOf(
      DialogueConversation(
        id = "dia_medical",
        title = "🩺 At the Medical Clinic (වෛද්‍යවරයා හමුවීම - 220+ Words Dialogue)",
        situation = "A Grade 11 student consults an English-speaking physician regarding persistent fatigue, headaches, and upcoming exam stress.",
        dialogueLines = listOf(
          DialogueLine("Doctor", "Good morning, young man. Please take a seat. What seems to be troubling you today?", "සුබ උදෑසනක් තරුණයා. කරුණාකර වාඩිවෙන්න. අද ඔබට ඇති අපහසුතාවය කුමක්ද?"),
          DialogueLine("Student", "Good morning, doctor. For the past two weeks, I have been experiencing severe throbbing headaches and constant physical exhaustion, especially during the afternoons.", "සුබ උදෑසනක් දොස්තර මහත්මයා. පසුගිය සති දෙක පුරා මට විශේෂයෙන් දහවල් කාලයේදී දැඩි හිසරදයක් සහ නිරන්තර කායික තෙහෙට්ටුවක් දැනෙනවා."),
          DialogueLine("Doctor", "I see. Are you preparing for any competitive examinations currently, such as the G.C.E. Ordinary Level exams?", "මට තේරෙනවා. ඔබ මේ දිනවල සාමාන්‍ය පෙළ වැනි යම් තරඟකාරී විභාගයකට සූදානම් වෙනවාද?"),
          DialogueLine("Student", "Yes, doctor. Our national exams start in eight weeks, so I have been studying late into midnight, often sleeping only four hours per night and drinking multiple cups of strong coffee.", "ඔව් දොස්තර මහත්මයා. තව සති අටකින් විභාගය පටන් ගන්නා නිසා මම රෑ බෝවන තෙක් පාඩම් කරනවා, බොහෝ විට දිනකට නිදාගන්නේ පැය හතරක් පමණයි."),
          DialogueLine("Doctor", "That explains a great deal. Severe sleep deprivation combined with excessive caffeine leads to dehydration and nervous system strain. Let me check your pulse and blood pressure.", "එයින් බොහෝ දේ පැහැදිලි වෙනවා. නින්ද මදිකම සහ අධික කැෆේන් විජලනයට හා ස්නායු ආතතියට මඟ පාදනවා. මම ඔබේ නාඩි වැටීම හා රුධිර පීඩනය පරීක්ෂා කරන්නම්."),
          DialogueLine("Student", "Is there anything serious, doctor? I am very worried about falling behind in my school syllabus.", "දොස්තර මහත්මයා යම් බරපතල තත්ත්වයක්ද? මගේ විෂය නිර්දේශයේ වැඩ අතපසු වීම ගැන මම ගොඩක් බය වෙලා ඉන්නේ."),
          DialogueLine("Doctor", "Your vital signs are stable, but your eye muscles show evident digital fatigue. I am prescribing a mild analgesic for headache relief and multivitamin supplements to restore energy.", "ඔබේ සෞඛ්‍ය තත්ත්වය ස්ථාවරයි, නමුත් ඇස්වල දැඩි විඩාවක් පෙනෙනවා. හිසරදය සමනයට වේදනා නාශකයක් හා ශක්තිය වර්ධනයට මල්ටිවිටමින් මම නියම කරනවා."),
          DialogueLine("Doctor", "More importantly, you must follow strict lifestyle modifications: drink at least two liters of water daily, limit uninterrupted screen study to forty minutes, and guarantee seven hours of restorative sleep.", "වඩා වැදගත්ම දෙය නම්: දිනපතා අවම වශයෙන් ජලය ලීටර් 2ක් බොන්න, තිරය දෙස බලා පාඩම් කිරීම විනාඩි 40කට සීමා කරන්න, පැය 7ක සුව නින්දක් ලබාගන්න."),
          DialogueLine("Student", "I understand completely, doctor. I will restructure my daily revision timetable immediately. Thank you for your kind advice!", "මට හොඳින්ම වැටහුණා දොස්තර මහත්මයා. මම අදම මගේ පාඩම් කාලසටහන වෙනස් කරගන්නවා. ඔබේ කරුණාවන්ත උපදෙස් වලට ස්තූතියි!"),
          DialogueLine("Doctor", "You are most welcome. Take care, study smartly with regular rest breaks, and I wish you triumphant success in your examinations!", "කරුණාවෙන් පිළිගන්නවා. හොඳින් විවේක ගනිමින් බුද්ධිමත්ව පාඩම් කරන්න, ඔබට විභාගයෙන් විශිෂ්ට ජය ප්‍රාර්ථනා කරමි!")
        )
      ),

      DialogueConversation(
        id = "dia_interview",
        title = "💼 Youth Career & Scholarship Interview (ශිෂ්‍යත්ව සම්මුඛ සාකච්ඡාව - 240+ Words)",
        situation = "An ambitious student faces a panel interview for an International Youth English Leadership Scholarship.",
        dialogueLines = listOf(
          DialogueLine("Interviewer", "Welcome to the final round, Kasun. Could you please introduce yourself and highlight your academic passions?", "අවසාන වටයට සාදරයෙන් පිළිගන්නවා කසුන්. කරුණාකර ඔබ ගැන හඳුන්වා දී ඔබේ අධ්‍යාපනික රුචිකත්වයන් සඳහන් කරන්න පුළුවන්ද?"),
          DialogueLine("Kasun", "Thank you, sir. My name is Kasun Jayasundara from Ananda College. I am deeply passionate about English literature, environmental science, and sustainable renewable technologies.", "ස්තූතියි සර්. මගේ නම කසුන් ජයසුන්දර. මම ඉංග්‍රීසි සාහිත්‍යය, පාරිසරික විද්‍යාව සහ පුනර්ජනනීය තාක්ෂණයන් කෙරෙහි දැඩි උනන්දුවක් දක්වනවා."),
          DialogueLine("Interviewer", "That is impressive. Why do you believe mastering the English language is essential for young Sri Lankan leaders today?", "ඉතා අගෙයි. අද තරුණ ශ්‍රී ලාංකික නායකයින්ට ඉංග්‍රීසි භාෂාව ප්‍රගුණ කිරීම අත්‍යවශ්‍ය යැයි ඔබ සිතන්නේ ඇයි?"),
          DialogueLine("Kasun", "In my view, English is the premier global bridge of knowledge. It enables us to absorb cutting-edge scientific research from international universities and articulate our country’s unique cultural heritage to the global community.", "මගේ අදහස අනුව ඉංග්‍රීසි යනු ගෝලීය දැනුමේ ප්‍රධාන පාලමයි. ජාත්‍යන්තර විද්‍යාත්මක පර්යේෂණ උකහා ගැනීමටත් අපේ සංස්කෘතික උරුමය ලෝකයට ගෙනහැර දැක්වීමටත් එය අපව සවිබල ගන්වනවා."),
          DialogueLine("Interviewer", "How do you handle unexpected failure or immense academic pressure during crucial examination periods?", "තීරණාත්මක විභාග සමයන්හිදී අනපේක්ෂිත පසුබෑමක් හෝ දැඩි අධ්‍යාපනික ආතතියක් ඇති වූ විට ඔබ එය හසුරුවන්නේ කෙසේද?"),
          DialogueLine("Kasun", "I embrace resilience as my foundational principle. Whenever I score lower than anticipated, I conduct a meticulous error analysis rather than feeling discouraged. Every mistake is a priceless lesson that sharpens future accuracy.", "මම නොසැලෙන ධෛර්යය මගේ මූලධර්මය ලෙස සලකනවා. අඩු ලකුණක් ලැබුණු විට අධෛර්යමත් නොවී මගේ වැරදි විශ්ලේෂණය කරනවා. සෑම වැරැද්දක්ම අනාගත සාර්ථකත්වයට මඟ පාදන පාඩමක්."),
          DialogueLine("Interviewer", "If awarded this leadership scholarship, what community initiative do you plan to spearhead in your local area?", "ඔබට මෙම නායකත්ව ශිෂ්‍යත්වය පිරිනැමුවහොත් ඔබේ ප්‍රදේශයේ කුමන ප්‍රජා ව්‍යාපෘතියක් දියත් කිරීමට ඔබ බලාපොරොත්තු වෙනවාද?"),
          DialogueLine("Kasun", "I intend to establish a free English Speaking and Digital Literacy Club for underprivileged rural primary students, helping them unlock confidence in spoken communication.", "ග්‍රාමීය ප්‍රාථමික සිසුන් සඳහා නොමිලේ ඉංග්‍රීසි කථන සහ ඩිජිටල් සාක්ෂරතා සමාජයක් ආරම්භ කර ඔවුන්ගේ කථන විශ්වාසය ගොඩනැගීමට මම සැලසුම් කරනවා."),
          DialogueLine("Interviewer", "Your clarity of vision and articulateness are commendable, Kasun. We wish you every success, and our committee will notify you of results shortly.", "ඔබේ පැහැදිලි දැක්ම සහ කථිකත්වය ඉතා ප්‍රශංසනීයයි කසුන්. ඔබට ජය ප්‍රාර්ථනා කරන අතර අපේ කමිටුව ප්‍රතිඵල ඉක්මනින් දන්වනු ඇත."),
          DialogueLine("Kasun", "Thank you very much, honorable members of the panel, for this invaluable opportunity. Have a wonderful day!", "මෙම මිල කළ නොහැකි අවස්ථාව ලබාදීම පිළිබඳ කමිටු සාමාජිකයින්ට මගේ හෘදයාංගම ස්තූතිය! සුබ දවසක්!")
        )
      ),

      DialogueConversation(
        id = "dia_library",
        title = "📚 At the University Research Library (පර්යේෂණ පුස්තකාලයේදී - 230+ Words)",
        situation = "Inquiring about advanced reference encyclopedias, digital borrowing cards, and inter-library book loans.",
        dialogueLines = listOf(
          DialogueLine("Student", "Excuse me, madam. Could you kindly assist me in locating the advanced reference section for G.C.E. Ordinary Level English and Sri Lankan History?", "සමාවෙන්න ගුරුතුමිය. සාමාන්‍ය පෙළ ඉංග්‍රීසි හා ශ්‍රී ලංකා ඉතිහාසය සඳහා උසස් විමර්ශන අංශය සොයා ගැනීමට මට උදව් කළ හැකිද?"),
          DialogueLine("Librarian", "Certainly! Head down the central aisle to Floor 2. Sri Lankan Heritage is under Dewey Decimal Code 954.93, while English Grammar and Literature archives are in Wing C.", "අනිවාර්යයෙන්ම! මැද මාවත ඔස්සේ දෙවන මහලට යන්න. ශ්‍රී ලංකා ඉතිහාසය 954.93 යටතේද, ඉංග්‍රීසි ව්‍යාකරණ හා සාහිත්‍ය ලේඛනාගාරය C අංශයේද ඇත."),
          DialogueLine("Student", "Thank you. Am I permitted to borrow this three-volume Illustrated Encyclopedia of World Civilizations for home study over the weekend?", "ස්තූතියි. මෙම වෙළුම් 3කින් යුත් ලෝක ශිෂ්ටාචාර විශ්වකෝෂය සති අන්තයේ නිවසේ පරිශීලනය සඳහා රැගෙන යාමට මට අවසර තිබේද?"),
          DialogueLine("Librarian", "I am afraid red-tagged reference volumes are restricted to in-library reading only. However, you can make digital photocopies of the relevant chapters at our digital kiosk.", "කණගාටුයි, රතු ලේබල් සහිත විමර්ශන පොත් රැගෙන යා හැක්කේ පුස්තකාලය තුළ කියවීම සඳහා පමණයි. නමුත් අපගේ ඩිජිටල් මධ්‍යස්ථානයෙන් ඔබට අවශ්‍ය පරිච්ඡේද පිටපත් කරගත හැක."),
          DialogueLine("Student", "That sounds very convenient. How can I gain access to the online academic research database through my school identity card?", "එය ඉතා පහසුයි. මගේ පාසල් හැඳුනුම්පත මඟින් අන්තර්ජාල අධ්‍යාපනික පර්යේෂණ දත්ත ගබඩාවට ප්‍රවේශ වන්නේ කෙසේද?"),
          DialogueLine("Librarian", "Simply visit our library web portal, register using your 10-digit student admission index, and you will receive instant unlimited access to thousands of e-books and past paper marking schemes.", "අපගේ වෙබ් අඩවියට පිවිස ඔබේ ශිෂ්‍ය අංකය යොදා ලියාපදිංචි වන්න, එවිට විද්‍යුත් පොත් දහස් ගණනක් හා ලකුණු දීමේ පටිපාටි නොමිලේ පරිශීලනය කළ හැක."),
          DialogueLine("Student", "That is truly fantastic news for my exam revision! Thank you so much for your patient guidance.", "එය මගේ විභාග පුනරීක්ෂණයට මහඟු උපකාරයක්! ඔබේ ඉවසිලිවන්ත මඟපෙන්වීමට බොහොම ස්තූතියි."),
          DialogueLine("Librarian", "You are most welcome. Remember that quiet discipline must be maintained at all study carrels. Best of luck with your research!", "සතුටින් පිළිගන්නවා. නිහඬතාවය ආරක්ෂා කරමින් පාඩම් කරන්න. ඔබේ පර්යේෂණ කටයුතුවලට සුබ පැතුම්!")
        )
      )
    )
  }

  fun getExpandedClozeTests(): List<ClozeTestItem> {
    return listOf(
      ClozeTestItem(
        id = "cloze_1",
        title = "O/L Test 16 Mastery: The Ancient Hydraulic Civilization of Sri Lanka (220+ Words)",
        instructions = "Fill in each blank with the most appropriate word selected from the given word bank. Each word should be used only once.",
        passageWithBlanks = """
The ancient hydraulic civilization of Sri Lanka is universally celebrated as a magnificent marvel of ecological engineering and agricultural sustainability. Built predominantly across the arid Dry Zone plains of the island, these colossal artificial reservoirs—locally known as 'wewas'—were constructed by visionary monarchs such as King Parakramabahu the Great and King Dhatusena. The foundational philosophy was that not a single drop of rain water falling from the heavens should be allowed to flow into the ocean without first serving the (1)_____ of mankind.

To manage the enormous water pressure within these deep earthen dams, ancient Sinhala engineers invented the ingenious 'Bisokotuwa', which is an advanced stone valve-pit that regulates water flow before it enters the irrigation (2)_____. This pioneering invention, conceived centuries before Western industrialization, effectively prevented reservoir embankments from (3)_____ under violent monsoon surges.

Furthermore, these ancient tanks were never built in isolation; rather, they formed an intricate cascade system where excess water from upstream catchment forests gently trickled into interconnected village tanks down the slope. This network maintained a high water table, enriched regional (4)_____, and provided perennial drinking water to thriving settlements. Modern hydrologists continue to study these ancient systems to extract sustainable solutions for contemporary global (5)_____ challenges. Protecting this sacred irrigation heritage is our collective national duty.
        """.trimIndent(),
        wordBank = listOf("welfare", "canals", "collapsing", "biodiversity", "climate"),
        correctAnswers = listOf("welfare", "canals", "collapsing", "biodiversity", "climate"),
        explanation = "1. serving the welfare (මනුෂ්‍ය සුබසාධනය සඳහා). 2. irrigation canals (වාරිමාර්ග ඇළ මාර්ග). 3. collapsing under surges (කඩා වැටීම වැළැක්වීම). 4. regional biodiversity (කලාපීය ජෛව විවිධත්වය). 5. climate challenges (දේශගුණික අභියෝග)."
      ),

      ClozeTestItem(
        id = "cloze_2",
        title = "O/L Test 16 Mastery: Environmental Preservation and Renewable Energy (230+ Words)",
        instructions = "Read the passage carefully and fill in the blanks using the appropriate technical terms from the word bank.",
        passageWithBlanks = """
In this contemporary era of rapid industrialization and urban expansion, the urgent necessity to transition from harmful fossil fuels to clean renewable energy sources has become paramount. For over a century, human societies have burned immense volumes of coal, petroleum, and natural gas to power factories and transportation networks. The consequence of this unchecked combustion has been an alarming accumulation of greenhouse gases in the atmosphere, accelerating dangerous global (1)_____ and erratic weather disruptions.

To reverse this catastrophic trajectory, forward-thinking nations are aggressively investing in solar, wind, and hydroelectric infrastructure. Solar photovoltaic panels harness abundant sunlight and directly transform radiant energy into clean electricity without emitting toxic fumes. Similarly, wind turbines erected along breezy coastal shorelines generate substantial electrical power with minimal environmental (2)_____.

However, realizing a completely green future requires more than just technological innovations; it demands a radical transformation in human habits and civic (3)_____. Individuals must eliminate energy waste by switching off idle electrical appliances, adopting public transportation, and rejecting non-biodegradable single-use plastics. In schools, educators must actively empower students to spearhead tree planting campaigns that restore native forest covers and replenish subterranean water (4)_____.

Ultimately, the preservation of our fragile biosphere is an intergenerational moral trust. We have not inherited this planet from our ancestors; we have merely borrowed it from our future generations. By embracing sustainable practices today, we guarantee a green and (5)_____ tomorrow for all living beings.
        """.trimIndent(),
        wordBank = listOf("warming", "footprint", "responsibility", "reserves", "prosperous"),
        correctAnswers = listOf("warming", "footprint", "responsibility", "reserves", "prosperous"),
        explanation = "1. global warming (ගෝලීය උණුසුම). 2. environmental footprint (පාරිසරික බලපෑම). 3. civic responsibility (සිවිල් වගකීම). 4. subterranean water reserves (භූගත ජල සංචිත). 5. prosperous tomorrow (සෞභාග්‍යමත් හෙට දවසක්)."
      )
    )
  }

  fun getExpandedGrammarLessons(): List<GrammarLessonItem> {
    return listOf(
      GrammarLessonItem(
        id = "gram_passive_mastery",
        title = "Passive Voice Complete Mastery (කර්මකාරක වාක්‍ය සම්පූර්ණ විග්‍රහය)",
        category = "PASSIVE_VOICE",
        sinhalaSummary = """
කර්මකාරක වාක්‍ය (Passive Voice) යනු ක්‍රියාව කළ පුද්ගලයාට වඩා (Doer/Subject) ක්‍රියාවට ලක්වූ දෙයට (Object/Action) ප්‍රමුඛත්වය ලබාදෙන වාක්‍ය රටාවයි. O/L විභාගයේ Test 7, 8, 11 සහ 15 ප්‍රශ්නවලදී සහ රචනාවල විද්‍යාත්මක හෝ නිල කරුණු ලිවීමේදී (Scientific & Formal Writing) Passive Voice භාවිතය අත්‍යවශ්‍ය වේ.
කර්තෘ කාරක වාක්‍යයක (Active Voice) ඇති කර්මය (Object) Passive Voice වලදී ප්‍රධාන Subject එක බවට පත්වේ. ඉන්පසු අදාළ කාලයට ගැළපෙන 'be' ක්‍රියා පදය (is/am/are/was/were/being/been) සහ ප්‍රධාන ක්‍රියා පදයේ තුන්වන ස්වරූපය (Past Participle - V3) අනිවාර්යයෙන්ම එකතු කළ යුතුය.
        """.trimIndent(),
        formula = "Object (නව කර්තෘ) + BE ක්‍රියා පදය (කාලය අනුව) + Past Participle (V3) + [by + කර්තෘ]",
        examples = listOf(
          "Active: King Parakramabahu built the Parakrama Samudraya." to "Passive: The Parakrama Samudraya was built by King Parakramabahu. (මහා පරාක්‍රමබාහු රජු විසින් පරාක්‍රම සමුද්‍රය ඉදිකරන ලදී - Simple Past)",
          "Active: Farmers grow organic vegetables in Nuwara Eliya." to "Passive: Organic vegetables are grown in Nuwara Eliya. (නුවරඑළියේ කාබනික එළවළු වගා කරනු ලැබේ - Simple Present)",
          "Active: Engineers are repairing the railway bridge today." to "Passive: The railway bridge is being repaired today. (දුම්රිය පාලම අද අලුත්වැඩියා කරමින් පවතී - Present Continuous)",
          "Active: The government has renovated ten ancient reservoirs." to "Passive: Ten ancient reservoirs have been renovated by the government. (රජය විසින් පුරාණ ජලාශ දහයක් ප්‍රතිසංස්කරණය කර ඇත - Present Perfect)",
          "Active: Students will clean the school garden tomorrow." to "Passive: The school garden will be cleaned tomorrow. (හෙට පාසල් වත්ත පිරිසිදු කරනු ඇත - Simple Future)",
          "Active: We must protect endemic bird species in Sri Lanka." to "Passive: Endemic bird species in Sri Lanka must be protected. (ශ්‍රී ලංකාවේ ආවේණික පක්ෂි විශේෂ ආරක්ෂා කළ යුතුය - Modal Verb)"
        ),
        proTip = "විභාග උපදෙස: කාලය කිසිවිටෙකත් වෙනස් නොවේ! Simple Past නම් was/were + V3 ද, Continuous නම් being + V3 ද, Perfect නම් been + V3 ද, Modals (can/must/should) නම් be + V3 ද යොදන්න."
      ),

      GrammarLessonItem(
        id = "gram_reported_speech",
        title = "Direct & Indirect Reported Speech Mastery (කථන පරිවර්තන නීති)",
        category = "REPORTED_SPEECH",
        sinhalaSummary = """
කෙනෙකු ප්‍රකාශ කළ දෙයක් තවත් කෙනෙකුට වාර්තා කිරීම Reported Speech ලෙස හැඳින්වේ. O/L විභාගයේදී වාක්‍ය පරිවර්තනය (Sentence Transformation) සඳහා මෙය බහුලව පරීක්ෂා කෙරේ.
වාර්තා කිරීමේදී මූලික නීති 3ක් මතක තබාගත යුතුය:
1. Tense Shift (කාලය එක් පියවරක් අතීතයට ගමන් කිරීම): Simple Present -> Simple Past, Present Continuous -> Past Continuous, Present Perfect -> Past Perfect, Simple Past -> Past Perfect, will -> would, can -> could, may -> might, must -> had to.
2. Pronoun Shift (සර්වනාම වෙනස් වීම): I -> he/she, we -> they, my -> his/her, our -> their.
3. Time & Place Words (ස්ථාන හා කාල පද වෙනස් වීම): today -> that day, tomorrow -> the next day / the following day, yesterday -> the previous day, now -> then, here -> there, this -> that, ago -> before.
        """.trimIndent(),
        formula = "Subject + said (that) / told + Object + Subject + Past Tense Verb + Rest",
        examples = listOf(
          "Direct: Kasun said, 'I am reading an interesting novel now.'" to "Indirect: Kasun said that he was reading an interesting novel then. (කසුන් කීවේ තමා එවිට රසවත් නවකතාවක් කියවමින් සිටි බවයි)",
          "Direct: The teacher said, 'You must submit your projects tomorrow.'" to "Indirect: The teacher told the students that they had to submit their projects the following day.",
          "Direct: 'Have you visited the Sigiriya fortress?' asked father." to "Indirect: Father asked if I had visited the Sigiriya fortress. (ප්‍රශ්නයකදී 'if / whether' භාවිත වේ)",
          "Direct: 'Where are you going for the vacation?' asked Nimal." to "Indirect: Nimal asked where I was going for the vacation. (Wh-ප්‍රශ්නවලදී Wh-පදය එලෙසම තබා වාක්‍ය සාමාන්‍ය ප්‍රකාශනයක් බවට පත් කෙරේ)"
        ),
        proTip = "සදාකාලික සත්‍යයක් (Universal Truth) හෝ විද්‍යාත්මක සත්‍යයක් වාර්තා කිරීමේදී කාලය (Tense) වෙනස් නොවේ! උදා: Teacher said, 'The Earth revolves around the Sun.' -> Teacher said that the Earth revolves around the Sun."
      ),

      GrammarLessonItem(
        id = "gram_conditionals_all",
        title = "Conditional Clauses Types 0, 1, 2, 3 (කොන්දේසි සහිත වාක්‍ය සම්පූර්ණ නීති)",
        category = "CONDITIONALS",
        sinhalaSummary = """
ඉංග්‍රීසි භාෂාවේ 'If' (නම් / හැකිනම්) යොදා ගොඩනඟන කොන්දේසි සහිත වාක්‍ය ප්‍රධාන ආකාර 4කින් සමන්විත වේ. O/L විභාගයේ Test 11 සහ 15 හි නිතරම ලකුණු ලබාදෙන මාතෘකාවකි.
• Type 0 (Universal/Scientific Fact): If + Present Simple, Present Simple. උදා: If you heat ice, it melts. (අයිස් රත් කළහොත් දියවේ)
• Type 1 (Real/Possible Future): If + Present Simple, will + Verb 1. උදා: If you study hard, you will pass with flying colors. (මහන්සි වී පාඩම් කළහොත් විභාගය විශිෂ්ට ලෙස සමත් විය හැක)
• Type 2 (Unreal/Imaginary Present): If + Past Simple, would + Verb 1. උදා: If I had wings, I would fly across the oceans. (මට පියාපත් තිබුණා නම් මම සාගර තරණය කරමි - අතාත්වික සිහිනයක්)
• Type 3 (Impossible Past Regret): If + Past Perfect (had + V3), would have + V3. උදා: If he had driven carefully, he would have avoided the accident. (ඔහු පරෙස්සමින් රිය පැදවූයේ නම් අනතුර වළක්වා ගැනීමට තිබුණි - අතීතයේ මඟහැරුණු දෙයක්)
        """.trimIndent(),
        formula = "Type 1: If + V1, will + V1 | Type 2: If + V2, would + V1 | Type 3: If + had + V3, would have + V3",
        examples = listOf(
          "Type 1: If it rains heavily tomorrow, we will postpone the outdoor sports meet." to "හෙට තදින් වැස්සොත් අපි එළිමහන් ක්‍රීඩා උළෙල කල් දමන්නෙමු.",
          "Type 1: Unless you practice speaking in English daily, you will not gain verbal confidence." to "'Unless' යනු 'If not' වේ. ඔබ දිනපතා කතා කිරීමට පුරුදු නොවන්නේ නම් ඔබට කථන විශ්වාසය නොලැබේ.",
          "Type 2: If I were the Minister of Education, I would provide digital tablets to every rural school." to "'If I were...' (මම වූයේ නම්) මනඃකල්පිත අවස්ථාවලදී 'was' වෙනුවට 'were' යෙදීම සම්මත සම්ප්‍රදායයි.",
          "Type 3: If the farmer had built strong fences, wild elephants would not have entered the paddy fields." to "ගොවියා ශක්තිමත් වැටවල් ඉදිකළේ නම් වන අලි කුඹුරුවලට ඇතුළු නොවන්නට තිබුණි."
        ),
        proTip = "'If' clause එක ඇතුළත කිසිම විටක 'will' හෝ 'would' නොයොදන්න! උදා: If it will rain (වැරදියි) -> If it rains (නිවැරදියි)."
      ),

      GrammarLessonItem(
        id = "gram_relative_clauses",
        title = "Relative Clauses & Pronouns (who, whom, whose, which, that, where)",
        category = "RELATIVE_CLAUSES",
        sinhalaSummary = """
වාක්‍ය දෙකක් එකිනෙකට සම්බන්ධ කරමින් නාම පදයක් (Noun) පිළිබඳ වැඩිදුර තොරතුරු සැපයීමට Relative Pronouns භාවිත වේ. O/L විභාගයේ වාක්‍ය සම්බන්ධ කිරීමේ (Combining Sentences) ප්‍රශ්න සඳහා මෙය අත්‍යවශ්‍ය වේ.
1. Who: පුද්ගල කර්තෘන් සඳහා (The student who won the medal is Kasun)
2. Whom: පුද්ගල කර්මයන් සඳහා (The doctor whom we consulted was very kind)
3. Whose: අයිතිය දැක්වීමට (The girl whose bicycle was stolen lodged a complaint)
4. Which / That: සතුන් සහ අජීවී ද්‍රව්‍ය සඳහා (The book which / that you lent me is fascinating)
5. Where: ස්ථාන විස්තර කිරීමට (This is the ancient temple where sacred relics are enshrined)
6. When: කාලය විස්තර කිරීමට (Sunday is the day when our family visits the temple)
        """.trimIndent(),
        formula = "Noun + Relative Pronoun (who/which/whose/where) + Defining Clause",
        examples = listOf(
          "Sentence 1: Ananda is a brilliant scientist. Sentence 2: He discovered a new herbal cure." to "Combined: Ananda is a brilliant scientist who discovered a new herbal cure.",
          "Sentence 1: The Sinharaja forest is a UNESCO World Heritage site. Sentence 2: It harbors many endemic birds." to "Combined: The Sinharaja forest, which harbors many endemic birds, is a UNESCO World Heritage site.",
          "Sentence 1: The boy is my best friend. Sentence 2: His father is an airline pilot." to "Combined: The boy whose father is an airline pilot is my best friend.",
          "Sentence 1: Kandy is a historic hill capital. Sentence 2: The sacred Temple of the Tooth is located there." to "Combined: Kandy is a historic hill capital where the sacred Temple of the Tooth is located."
        ),
        proTip = "පුද්ගලයෙකුගේ අයිතියක් ගැන කියන විට 'who' වෙනුවට 'whose' යොදන්න (whose car, whose parents). අජීවී දෙයකට 'which' හෝ 'that' යොදන්න, කිසිවිටෙකත් 'who' නොයොදන්න."
      )
    )
  }
}

