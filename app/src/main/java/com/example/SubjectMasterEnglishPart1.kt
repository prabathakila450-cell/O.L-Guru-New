package com.example

import androidx.compose.ui.graphics.Color

object SubjectMasterEnglishPart1 {
  fun getCategories(): List<SubjectMasterCategory> {
    return listOf(
      // Category 1: Parts of Speech & Word Classes
      SubjectMasterCategory(
        id = "eng_cat_1",
        categoryNumber = 1,
        titleSinhala = "Parts of Speech & Word Classes",
        icon = "🔤",
        color = Color(0xFF0284C7),
        summary = "Nouns, Verbs, Adjectives, Adverbs, Pronouns, Prepositions and Conjunctions in English.",
        points = listOf(
          SubjectFactPoint(1, "Nouns (Naming Words)", "Words that name a person, place, animal, thing, concept or quality (e.g., student, Colombo, elephant, table, honesty).", "Every English sentence requires a subject which is typically a noun or pronoun."),
          SubjectFactPoint(2, "Proper Nouns vs Common Nouns", "Proper nouns name specific unique entities and always begin with capital letters (e.g., Sri Lanka, William, Monday). Common nouns name general items (e.g., country, boy, day).", "Check capitalization in Paper I and Paper II writing."),
          SubjectFactPoint(3, "Countable and Uncountable Nouns", "Countable nouns have singular and plural forms (e.g., book/books, apple/apples). Uncountable nouns cannot be counted individually and take singular verbs (e.g., water, milk, rice, information).", "Never write 'informations' or 'furnitures'."),
          SubjectFactPoint(4, "Collective Nouns", "Words referring to a group of individuals or items treated as a single unit (e.g., a flock of birds, a herd of cattle, a team of players).", "Usually takes a singular verb in British English."),
          SubjectFactPoint(5, "Abstract Nouns", "Names of ideas, qualities, emotions or states that cannot be touched (e.g., bravery, freedom, happiness, knowledge).", "Formed from adjectives (kind -> kindness) or verbs (act -> action)."),
          SubjectFactPoint(6, "Pronouns (Substitutes for Nouns)", "Words used in place of nouns to prevent tedious repetition (e.g., he, she, it, they, we, you, I).", "Must agree in gender and number with the antecedent."),
          SubjectFactPoint(7, "Personal Pronouns: Subject vs Object", "Subject pronouns perform the action (I, you, he, she, it, we, they); object pronouns receive the action (me, you, him, her, it, us, them).", "Example: 'She invited him to the seminar.'"),
          SubjectFactPoint(8, "Possessive Pronouns and Adjectives", "Possessive adjectives modify nouns (my, your, his, her, its, our, their); possessive pronouns stand alone (mine, yours, his, hers, ours, theirs).", "Example: 'This is my bag' vs 'This bag is mine.'"),
          SubjectFactPoint(9, "Reflexive Pronouns", "Used when the subject and object are the same person (myself, yourself, himself, herself, itself, ourselves, yourselves, themselves).", "Example: 'He hurt himself while playing.'"),
          SubjectFactPoint(10, "Verbs (Action and State Words)", "Express physical actions (run, write), mental processes (think, believe), or states of being (is, are, seem, belong).", "The essential core of every English clause."),
          SubjectFactPoint(11, "Transitive and Intransitive Verbs", "Transitive verbs require a direct object to complete their meaning (e.g., 'He read a book'); intransitive verbs do not take an object (e.g., 'The baby slept').", "Only transitive verbs can be transformed into passive voice."),
          SubjectFactPoint(12, "Adjectives (Describing Words)", "Words that describe, quantify, or qualify nouns and pronouns (e.g., brilliant, seven, blue, wooden).", "Usually precede the noun: 'an ancient temple'."),
          SubjectFactPoint(13, "Degrees of Comparison for Adjectives", "Positive (tall), Comparative (taller - comparing two), Superlative (tallest - comparing three or more; requires 'the').", "Use 'more/most' for words with 2 or more syllables (e.g., more beautiful)."),
          SubjectFactPoint(14, "Adverbs of Manner (-ly)", "Describe how an action is performed, usually formed by adding -ly to adjectives (e.g., quick -> quickly, careful -> carefully).", "Answers the question 'How?': 'He spoke politely.'"),
          SubjectFactPoint(15, "Adverbs of Frequency, Time and Place", "Frequency (always, often, never), Time (yesterday, now, soon), Place (here, there, outside).", "Frequency adverbs usually precede main verbs: 'She always arrives early.'"),
          SubjectFactPoint(16, "Prepositions", "Words placed before nouns/pronouns showing relationship of time, place, direction or possession (e.g., at, in, on, under, through, between).", "Tested extensively in O/L cloze tests (fill in the blanks)."),
          SubjectFactPoint(17, "Coordinating Conjunctions (FANBOYS)", "Connect words, phrases, or independent clauses of equal grammatical rank: For, And, Nor, But, Or, Yet, So.", "Essential for constructing compound sentences."),
          SubjectFactPoint(18, "Subordinating Conjunctions", "Introduce dependent clauses expressing reason, condition, time, or contrast (e.g., because, although, since, while, unless, if).", "Forms complex sentences: 'Although it rained, we enjoyed the trip.'"),
          SubjectFactPoint(19, "Interjections", "Exclamatory words expressing sudden emotion or feeling (e.g., Wow!, Alas!, Ouch!, Hurrah!).", "Followed by an exclamation mark in informal dialogues."),
          SubjectFactPoint(20, "O/L Exam Tip: Word Class Identification", "In O/L Paper I and Paper II, vocabulary questions often ask you to identify word class or change word forms (e.g., success [noun] -> succeed [verb] -> successful [adjective] -> successfully [adverb]).", "Mastering word families guarantees high marks.")
        )
      ),

      // Category 2: Present Tenses & Usage Rules
      SubjectMasterCategory(
        id = "eng_cat_2",
        categoryNumber = 2,
        titleSinhala = "Present Tenses & Usage Rules",
        icon = "⏳",
        color = Color(0xFF0284C7),
        summary = "Simple Present, Present Continuous, Present Perfect and Present Perfect Continuous.",
        points = listOf(
          SubjectFactPoint(1, "Simple Present Tense Structure", "Subject + Base Verb (V1) / Base Verb + s/es for third-person singular (He/She/It). Negative: do not / does not + V1.", "Example: 'She works in Kandy.' 'They study hard.'"),
          SubjectFactPoint(2, "Simple Present: Universal Truths & Facts", "Used for scientific facts, eternal laws of nature, and permanent states.", "Example: 'The sun rises in the east.' 'Water boils at 100°C.'"),
          SubjectFactPoint(3, "Simple Present: Habitual Actions & Routines", "Accompanied by adverbs of frequency: daily, every morning, usually, always, often, seldom.", "Example: 'My father reads the newspaper every day.'"),
          SubjectFactPoint(4, "Simple Present: Fixed Schedules & Timetables", "Refers to future scheduled events governed by a fixed calendar or official timetable.", "Example: 'The train to Badulla departs at 5:55 a.m.'"),
          SubjectFactPoint(5, "Third-Person Singular 's/es' Rules", "Add -es to verbs ending in -ch, -sh, -s, -x, -z, -o (watch -> watches, go -> goes). Consonant + y becomes -ies (study -> studies).", "Frequent point of error in O/L essays."),
          SubjectFactPoint(6, "Present Continuous Tense Structure", "Subject + am/is/are + Verb-ing. Negative: am/is/are + not + Verb-ing.", "Example: 'The children are playing cricket right now.'"),
          SubjectFactPoint(7, "Present Continuous: Actions at the Moment of Speaking", "Indicates activities taking place right now, at this exact moment.", "Trigger words: look!, listen!, at present, currently, right now."),
          SubjectFactPoint(8, "Present Continuous: Temporary Situations", "Events happening around now but not necessarily at this exact second.", "Example: 'I am reading a novel by Martin Wickramasinghe this week.'"),
          SubjectFactPoint(9, "Present Continuous: Definite Future Arrangements", "Expresses planned personal arrangements already fixed for the near future.", "Example: 'We are visiting the museum tomorrow morning.'"),
          SubjectFactPoint(10, "Non-Continuous / Stative Verbs", "Verbs of perception, emotion, and possession that are never used in continuous forms (e.g., love, like, hate, understand, believe, know, belong, hear).", "Say 'I know the answer', NOT 'I am knowing the answer'."),
          SubjectFactPoint(11, "Present Perfect Tense Structure", "Subject + have/has + Past Participle (V3). Has for singular (he/she/it); have for plural (I/you/we/they).", "Example: 'She has completed her project.'"),
          SubjectFactPoint(12, "Present Perfect: Past Action with Present Relevance", "The action occurred in the past, but its result or effect is directly visible and important right now.", "Example: 'I have lost my key (so I cannot open the door now).'"),
          SubjectFactPoint(13, "Present Perfect: Life Experiences", "Expressing whether something has occurred in a person's life up to the present moment.", "Trigger words: ever, never. 'Have you ever climbed Sigiriya?'"),
          SubjectFactPoint(14, "Trigger Words: Just, Already, Yet", "'Just' (a very short time ago), 'Already' (sooner than expected in positive sentences), 'Yet' (in negative sentences and questions).", "Example: 'The bell has just rung.' 'Have you finished yet?'"),
          SubjectFactPoint(15, "'Since' vs 'For' in Present Perfect", "'Since' specifies the exact starting point in time (since 2015, since Monday). 'For' specifies the duration/period of time (for 3 hours, for 5 years).", "Example: 'We have lived here since 2018.' 'We have lived here for 6 years.'"),
          SubjectFactPoint(16, "Present Perfect Continuous Tense Structure", "Subject + have/has + been + Verb-ing.", "Example: 'It has been raining continuously for two hours.'"),
          SubjectFactPoint(17, "Present Perfect Continuous: Ongoing Action", "Focuses on the duration of an activity that started in the past and is still actively continuing right now.", "Emphasizes the duration rather than the completed result."),
          SubjectFactPoint(18, "'Have been to' vs 'Have gone to'", "'Have been to' indicates a visit has completed and the person has returned. 'Have gone to' means the person is still away and has not yet returned.", "Example: 'Kamal has gone to Jaffna (he is there now).'"),
          SubjectFactPoint(19, "Common Tense Confusion: Simple Past vs Present Perfect", "Use Simple Past when an exact past time is mentioned (yesterday, in 2020, 2 days ago). Use Present Perfect when no specific past time is given.", "Say 'I saw him yesterday' (NOT 'I have seen him yesterday')."),
          SubjectFactPoint(20, "O/L Exam Tip: Verb Form Cloze Tests", "In O/L Paper I Test 6 and Paper II cloze tests, verbs in brackets must be conjugated correctly according to subject-verb agreement and context clues.", "Always check the subject number and time signal before writing.")
        )
      ),

      // Category 3: Past Tenses & Historical Narratives
      SubjectMasterCategory(
        id = "eng_cat_3",
        categoryNumber = 3,
        titleSinhala = "Past Tenses & Historical Narratives",
        icon = "📜",
        color = Color(0xFF0284C7),
        summary = "Simple Past, Past Continuous, Past Perfect and Irregular Verb conjugation.",
        points = listOf(
          SubjectFactPoint(1, "Simple Past Tense Structure", "Subject + Past Form of Verb (V2). Negative: Subject + did not (didn't) + Base Verb (V1).", "Question: Did + Subject + Base Verb? 'Did you watch the match?'"),
          SubjectFactPoint(2, "Regular Verbs: Adding -ed", "Add -ed to regular verbs (play -> played, walk -> walked). If verb ends in -e, add only -d (live -> lived). If consonant + y, change to -ied (carry -> carried).", "Double final consonant if single vowel precedes: stop -> stopped."),
          SubjectFactPoint(3, "High-Frequency Irregular Verbs", "Go-went-gone, write-wrote-written, see-saw-seen, buy-bought-bought, teach-taught-taught, speak-spoke-spoken, eat-ate-eaten, break-broke-broken.", "Irregular past forms must be memorized thoroughly."),
          SubjectFactPoint(4, "Simple Past: Definite Finished Past Time", "Used for actions that began and completely finished in the past at a specified time.", "Trigger words: yesterday, last night, in 1948, two weeks ago, when I was young."),
          SubjectFactPoint(5, "Past Continuous Tense Structure", "Subject + was/were + Verb-ing. Was for singular (I, he, she, it); were for plural (we, you, they).", "Example: 'I was studying when the power went out.'"),
          SubjectFactPoint(6, "Past Continuous: Interrupted Actions (While / When)", "A longer ongoing action in the past continuous was interrupted by a shorter action in the simple past.", "Example: 'While we were having dinner, the telephone rang.'"),
          SubjectFactPoint(7, "Past Continuous: Two Parallel Simultaneous Actions", "Two past activities taking place at the exact same time without interfering.", "Example: 'While Mother was cooking, Father was reading in the garden.'"),
          SubjectFactPoint(8, "Past Continuous: Setting the Scene in Story Writing", "Used in the introductory paragraphs of narrative essays to describe atmospheric conditions and background.", "Example: 'The rain was pouring and thunder was rumbling across the valley.'"),
          SubjectFactPoint(9, "Past Perfect Tense Structure", "Subject + had + Past Participle (V3). Same auxiliary 'had' for all singular and plural subjects.", "Example: 'The train had left before we reached the railway station.'"),
          SubjectFactPoint(10, "Past Perfect: The Earlier of Two Past Actions", "When two events occurred in the past, the earlier event is in the Past Perfect, while the later event is in the Simple Past.", "Chronological sequence: Past Perfect -> Simple Past -> Present."),
          SubjectFactPoint(11, "Connectors: Before, After, By the time", "'By the time the fire brigade arrived, the villagers had extinguished the blaze.' 'After she had completed her homework, she went to bed.'", "Essential for high-scoring structured story writing."),
          SubjectFactPoint(12, "Past Perfect Continuous Tense Structure", "Subject + had + been + Verb-ing.", "Example: 'He had been waiting for two hours before the bus finally arrived.'"),
          SubjectFactPoint(13, "'Used to' for Past Habits and States", "Used to + Base Verb indicates a past regular habit or state that was true in the past but is no longer true today.", "Example: 'He used to play football, but now he prefers badminton.'"),
          SubjectFactPoint(14, "Negative and Question Form of 'Used to'", "Negative: didn't use to (NOT 'didn't used to'). Question: Did you use to walk to school?", "Followed by base verb without -d."),
          SubjectFactPoint(15, "'Would' for Repeated Past Actions", "Can describe repeated habitual past actions in storytelling (e.g., 'Every holiday, my grandfather would take us fishing').", "Cannot be used for past states (only actions)."),
          SubjectFactPoint(16, "Historical Narratives Architecture", "Chronological sequencing: First / Initially -> Then / Next -> Meanwhile -> Suddenly -> Finally / Eventually.", "Maintains cohesive narrative flow."),
          SubjectFactPoint(17, "Pronunciation of Regular Past '-ed'", "/t/ sound after voiceless consonants (jumped, stopped, laughed). /d/ sound after voiced sounds (played, lived, cleaned). /ɪd/ sound after 't' and 'd' (wanted, needed).", "Helps in oral examinations and English listening tests."),
          SubjectFactPoint(18, "Did + Base Verb Rule (Crucial Trap)", "After the auxiliary 'did' or 'didn't', the main verb must ALWAYS revert to its base form (V1).", "Write 'He didn't go' (NEVER 'He didn't went')."),
          SubjectFactPoint(19, "Inversion with Negative Adverbs", "'Hardly had we arrived when the rain started.' 'No sooner had the bell rung than the students rushed out.'", "Advanced sentence structure tested in scholarship and O/L distinction levels."),
          SubjectFactPoint(20, "O/L Exam Tip: Narrative Essay Construction", "In O/L Paper II Question 16 (Story Writing), use past tenses consistently throughout the composition; shifting suddenly into present tense loses marks.", "Keep past narrative tenses unified.")
        )
      ),

      // Category 4: Future Tenses & Predictions
      SubjectMasterCategory(
        id = "eng_cat_4",
        categoryNumber = 4,
        titleSinhala = "Future Tenses & Predictions",
        icon = "🔮",
        color = Color(0xFF0284C7),
        summary = "Will/Shall, Going to, Future Continuous, and Scheduled future expressions.",
        points = listOf(
          SubjectFactPoint(1, "Simple Future Tense: Will + Base Verb", "Subject + will + Base Verb (V1). Negative: will not (won't) + V1.", "Example: 'Technology will transform future classrooms.'"),
          SubjectFactPoint(2, "'Will' for Instant Decisions & Spontaneous Offers", "Made at the exact moment of speaking without prior planning.", "Example: 'The phone is ringing. I will answer it.' 'I will carry that heavy bag for you.'"),
          SubjectFactPoint(3, "'Will' for General Predictions & Opinions", "Predictions based on personal belief, thoughts, or opinions without immediate tangible evidence.", "Commonly used with: I think, I hope, probably, definitely, I doubt."),
          SubjectFactPoint(4, "'Shall' Usage in Modern English", "Used with first person (I / We) in formal questions to make offers or suggestions.", "Example: 'Shall we begin the meeting?' 'Shall I open the window?'"),
          SubjectFactPoint(5, "'Be going to' Structure", "Subject + am/is/are + going to + Base Verb (V1).", "Example: 'She is going to study medicine after her A/Ls.'"),
          SubjectFactPoint(6, "'Be going to' for Prior Intentions & Plans", "Indicates an action that was decided and planned before the moment of speaking.", "Example: 'We are going to paint our house next weekend.'"),
          SubjectFactPoint(7, "'Be going to' for Predictions with Present Physical Evidence", "When present visual clues or physical evidence make an impending event obvious.", "Example: 'Look at those dark black clouds! It is going to rain.'"),
          SubjectFactPoint(8, "Contrast: 'Will' vs 'Going to'", "'Will' is decided now; 'Going to' was decided earlier. 'Will' is a belief prediction; 'Going to' is an evidence-backed prediction.", "Crucial distinction tested in O/L multiple choice tests."),
          SubjectFactPoint(9, "Future Continuous Tense Structure", "Subject + will + be + Verb-ing.", "Example: 'This time tomorrow, we will be flying over the Indian Ocean.'"),
          SubjectFactPoint(10, "Future Continuous: Action in Progress at a Future Moment", "Describes an activity that will be actively happening at a specific given time in the future.", "Example: 'Don't call him at 8 p.m.; he will be having dinner.'"),
          SubjectFactPoint(11, "Future Continuous: Polite Inquiries about Plans", "Used to ask politely about someone's future arrangements without pressuring them.", "Example: 'Will you be using your computer this afternoon?'"),
          SubjectFactPoint(12, "Future Perfect Tense Structure", "Subject + will + have + Past Participle (V3).", "Example: 'By December, we will have completed the entire O/L syllabus.'"),
          SubjectFactPoint(13, "Future Perfect: Action Completed Before a Future Deadline", "Indicates an action that will be completed prior to a designated point in the future.", "Trigger phrase: By + future time (by next year, by 5 o'clock, by next Friday)."),
          SubjectFactPoint(14, "Future Perfect Continuous Tense Structure", "Subject + will + have + been + Verb-ing.", "Example: 'By 2027, Mr. Perera will have been teaching for twenty-five years.'"),
          SubjectFactPoint(15, "Present Simple for Official Scheduled Future", "Used for transportation timetables, examination schedules, cinema shows, and official programmes.", "Example: 'The G.C.E. O/L examination begins next Monday.'"),
          SubjectFactPoint(16, "Present Continuous for Definite Personal Arrangements", "Used when an event is already organized, invitations sent, or tickets booked.", "Example: 'I am meeting the school principal tomorrow morning at 9 a.m.'"),
          SubjectFactPoint(17, "Future Time Clauses: No 'will' after Time Conjunctions", "In clauses introduced by when, after, before, until, as soon as, use Simple Present (NOT will).", "Write 'When I arrive home, I will call you' (NEVER 'When I will arrive')."),
          SubjectFactPoint(18, "'Be about to' for Immediate Future", "Be about to + Base Verb indicates something is on the verge of happening within seconds.", "Example: 'Hurry up! The bus is about to leave.'"),
          SubjectFactPoint(19, "'Be likely to' / 'Be bound to'", "'Likely to' expresses strong probability; 'Bound to' expresses certainty.", "Example: 'Prices are likely to decrease.' 'Hard work is bound to bring success.'"),
          SubjectFactPoint(20, "O/L Exam Tip: Future Forms in Letter Writing", "In O/L Paper II Question 14 (Letter/Email Writing), use 'be going to' for planned school trips and 'will' for spontaneous promises and expectations.", "Demonstrates grammatical variety.")
        )
      ),

      // Category 5: Active Voice & Passive Voice Rules
      SubjectMasterCategory(
        id = "eng_cat_5",
        categoryNumber = 5,
        titleSinhala = "Active Voice & Passive Voice Rules",
        icon = "🔄",
        color = Color(0xFF0284C7),
        summary = "Subject-object inversion, 'be' verb forms, agent 'by' and formal report writing.",
        points = listOf(
          SubjectFactPoint(1, "Active Voice vs Passive Voice", "Active Voice: The subject performs the action (e.g., 'The chef cooked the meal'). Passive Voice: The subject receives the action (e.g., 'The meal was cooked by the chef').", "Focuses on the action and result rather than the doer."),
          SubjectFactPoint(2, "The 3 Golden Rules of Passive Transformation", "1. Move the active object to the subject position. 2. Insert the appropriate form of 'be' + Past Participle (V3). 3. Add 'by' + active agent (if necessary).", "Only sentences with transitive verbs can be transformed."),
          SubjectFactPoint(3, "Simple Present Passive", "Active: writes/write -> Passive: am / is / are + V3.", "Example: 'Farmers grow rice in Anuradhapura' -> 'Rice is grown in Anuradhapura.'"),
          SubjectFactPoint(4, "Simple Past Passive", "Active: wrote -> Passive: was / were + V3.", "Example: 'Alexander Graham Bell invented the telephone' -> 'The telephone was invented by Alexander Graham Bell.'"),
          SubjectFactPoint(5, "Simple Future Passive", "Active: will write -> Passive: will be + V3.", "Example: 'The committee will announce the results' -> 'The results will be announced by the committee.'"),
          SubjectFactPoint(6, "Present Continuous Passive", "Active: is/are writing -> Passive: is / are / am + being + V3.", "Example: 'They are constructing a new highway' -> 'A new highway is being constructed.'"),
          SubjectFactPoint(7, "Past Continuous Passive", "Active: was/were writing -> Passive: was / were + being + V3.", "Example: 'The mechanic was repairing the car' -> 'The car was being repaired by the mechanic.'"),
          SubjectFactPoint(8, "Present Perfect Passive", "Active: has/have written -> Passive: has / have + been + V3.", "Example: 'The doctor has examined the patient' -> 'The patient has been examined by the doctor.'"),
          SubjectFactPoint(9, "Past Perfect Passive", "Active: had written -> Passive: had + been + V3.", "Example: 'They had renovated the library' -> 'The library had been renovated.'"),
          SubjectFactPoint(10, "Modal Auxiliary Verbs in Passive", "Modal (can, could, must, should, may) + be + Past Participle (V3).", "Example: 'Students must wear uniforms' -> 'Uniforms must be worn by students.'"),
          SubjectFactPoint(11, "Omission of the Agent (When to drop 'by...')", "Omit the agent when the doer is unknown, obvious, or unimportant (e.g., someone, people, they, police, somebody).", "Example: 'Someone stole my bicycle' -> 'My bicycle was stolen' (NOT by someone)."),
          SubjectFactPoint(12, "Verbs with Two Objects (Direct and Indirect)", "Sentences with two objects produce two passive versions. Giving precedence to the person is more natural.", "Active: 'He gave me a gift' -> Passive 1: 'I was given a gift.' Passive 2: 'A gift was given to me.'"),
          SubjectFactPoint(13, "Passive of Imperative Sentences (Orders/Requests)", "Structure: Let + Object + be + Past Participle (V3).", "Active: 'Open the gate' -> Passive: 'Let the gate be opened.' 'Shut the door' -> 'Let the door be shut.'"),
          SubjectFactPoint(14, "Prepositional Verbs in Passive", "The preposition attached to the phrasal verb must remain immediately following the verb.", "Active: 'They laughed at the clown' -> Passive: 'The clown was laughed at.'"),
          SubjectFactPoint(15, "Passive in Scientific Reports & Processes", "Passive voice provides objective, impersonal tone in scientific experiments and manufacturing processes.", "Example: 'Water is added to the beaker and heated to 80°C.'"),
          SubjectFactPoint(16, "Passive in News Headlines & Formal Reports", "Headline brevity: 'Five suspects arrested in Colombo.' 'Two new bridges opened by minister.'", "Emphasizes events of public significance."),
          SubjectFactPoint(17, "Impersonal Passive: 'It is said / believed that...'", "Used for general beliefs and hearsay without citing sources.", "Example: 'People believe he is wealthy' -> 'It is believed that he is wealthy' / 'He is believed to be wealthy.'"),
          SubjectFactPoint(18, "Tenses that have No Passive Form", "Future Continuous, Present Perfect Continuous, Past Perfect Continuous, and Future Perfect Continuous are not used in passive voice.", "Avoid unnatural, awkward phrasing."),
          SubjectFactPoint(19, "Intransitive Verbs Cannot Be Passive", "Verbs like arrive, die, sleep, happen, occur, rain have no objects and cannot be transformed into passive.", "Never write 'The accident was happened' -> write 'The accident happened.'"),
          SubjectFactPoint(20, "O/L Exam Tip: Active-Passive Transformation Questions", "In O/L Paper II Question 11/12, sentence transformation tests often award 2 marks per sentence for correct passive construction.", "Check singular/plural agreement with the new subject!")
        )
      ),

      // Category 6: Direct & Indirect (Reported) Speech
      SubjectMasterCategory(
        id = "eng_cat_6",
        categoryNumber = 6,
        titleSinhala = "Direct & Indirect (Reported) Speech",
        icon = "💬",
        color = Color(0xFF0284C7),
        summary = "Backshift of tenses, pronoun shifts, time/place word conversions, statements and questions.",
        points = listOf(
          SubjectFactPoint(1, "Direct Speech vs Indirect Speech", "Direct Speech quotes the speaker's exact words inside quotation marks (e.g., Kamal said, \"I am tired\"). Indirect Speech reports the substance without quotes (e.g., Kamal said that he was tired).", "Used extensively in news reporting and narrative writing."),
          SubjectFactPoint(2, "The Golden Rule of Tense Backshift", "When the reporting verb is in the past (said, told), present tenses shift one step back into their corresponding past forms.", "Simple Present -> Simple Past; Present Continuous -> Past Continuous."),
          SubjectFactPoint(3, "Tense Shift Reference Table", "V1 (write) -> V2 (wrote); is/are writing -> was/were writing; has/have written -> had written; wrote -> had written; will -> would; can -> could; may -> might.", "Must -> had to."),
          SubjectFactPoint(4, "Exceptions to Tense Backshift", "No tense backshift occurs if the direct statement expresses a universal truth or permanent scientific law.", "Direct: \"The earth revolves around the sun\" -> Indirect: The teacher said that the earth revolves around the sun."),
          SubjectFactPoint(5, "No Backshift if Reporting Verb is Present", "If reporting verb is says, tells, or has said, do NOT change the tense of the reported clause.", "Direct: He says, \"I love music\" -> Indirect: He says that he loves music."),
          SubjectFactPoint(6, "Pronoun and Possessive Adjustments", "I -> he/she; we -> they; you -> I/he/she/they; my -> his/her; our -> their; your -> my/his/her/their.", "Adjust pronouns according to the speaker and listener context."),
          SubjectFactPoint(7, "Time and Place Words Shift Table", "Now -> then; today -> that day; tonight -> that night; yesterday -> the day before / the previous day; tomorrow -> the next day / the following day.", "Crucial for reporting exact chronological timing."),
          SubjectFactPoint(8, "Distance and Demonstrative Shifts", "Here -> there; this -> that; these -> those; ago -> before; come -> go.", "Example: \"I bought this watch here yesterday\" -> He said that he had bought that watch there the previous day."),
          SubjectFactPoint(9, "Reporting Statements: Use of 'that'", "Join reporting verb and reported clause using the conjunction 'that' (optional in informal speech but required in O/L exams).", "Say/said vs tell/told: 'Tell' must have a personal object (e.g., 'He told me that...')."),
          SubjectFactPoint(10, "Reporting 'Wh-' Questions", "Reporting verb becomes asked / inquired. Keep the question word (who, where, when, why, what, how) as connector. Change question order into statement order (Subject before Verb).", "Direct: \"Where do you live?\" -> Indirect: She asked me where I lived."),
          SubjectFactPoint(11, "Reporting 'Yes/No' Questions", "Use 'if' or 'whether' as connector. Transform inverted question word order into normal statement order (Subject + Verb).", "Direct: \"Are you hungry?\" -> Indirect: Mother asked me if I was hungry (NOT 'if was I hungry')."),
          SubjectFactPoint(12, "Reporting Commands and Orders", "Reporting verbs: ordered, commanded, told. Use infinitive: to + Base Verb.", "Direct: The teacher said, \"Stand up!\" -> Indirect: The teacher ordered the students to stand up."),
          SubjectFactPoint(13, "Reporting Negative Commands (Prohibitions)", "Structure: not to + Base Verb (or 'forbade ... to').", "Direct: Doctor said, \"Do not smoke\" -> Indirect: The doctor advised him not to smoke."),
          SubjectFactPoint(14, "Reporting Requests and Pleas", "Reporting verbs: asked, requested, begged. Drop the word 'please'.", "Direct: \"Please lend me your pen\" -> Indirect: Nimal requested me to lend him my pen."),
          SubjectFactPoint(15, "Reporting Suggestions: Let's / Shall we", "Use: suggested + Verb-ing OR suggested that we should + Base Verb.", "Direct: \"Let's play tennis\" -> Indirect: Sunimal suggested playing tennis / suggested that they should play tennis."),
          SubjectFactPoint(16, "Reporting Exclamations", "Reporting verbs: exclaimed with joy / sorrow / wonder. Drop exclamatory interjections like Wow, Alas.", "Direct: \"Alas! We lost the trophy\" -> Indirect: They exclaimed with sorrow that they had lost the trophy."),
          SubjectFactPoint(17, "Modals that Do Not Change", "Would, could, should, might, and ought to remain unchanged in reported speech.", "Example: \"You should consult a doctor\" -> She told me that I should consult a doctor."),
          SubjectFactPoint(18, "Punctuation in Reported Speech", "Remove all inverted commas (\", \"), question marks (?), and exclamation marks (!). End the indirect sentence with a full stop (.).", "A reported question is a statement and never ends with '? '."),
          SubjectFactPoint(19, "Reporting Dialogue Passages", "In O/L Paper II Question 12, dialogue snippets between two characters must be converted into a continuous indirect speech paragraph.", "Maintain correct sequence of tenses throughout."),
          SubjectFactPoint(20, "O/L Exam Tip: Subject-Verb Word Order in Questions", "The most common student error is keeping the auxiliary verb before the subject in reported questions (e.g., writing 'She asked where was I going' instead of 'where I was going').", "Always invert to subject + verb in indirect questions!")
        )
      ),

      // Category 7: Conditional Sentences (If Clauses)
      SubjectMasterCategory(
        id = "eng_cat_7",
        categoryNumber = 7,
        titleSinhala = "Conditional Sentences (If Clauses)",
        icon = "🌿",
        color = Color(0xFF0284C7),
        summary = "Zero, First (likely), Second (unreal/hypothetical) and Third (past regret) conditionals.",
        points = listOf(
          SubjectFactPoint(1, "The Anatomy of a Conditional Sentence", "Composed of two parts: the 'If clause' (condition) and the 'Main clause' (result). The clauses can appear in either order.", "If the 'If clause' comes first, separate with a comma. No comma if the main clause is first."),
          SubjectFactPoint(2, "Zero Conditional: Scientific Laws and General Truths", "Structure: If + Simple Present, Simple Present.", "Example: 'If you heat ice, it melts.' 'If water reaches 100°C, it boils.' Both clauses are in the simple present."),
          SubjectFactPoint(3, "First Conditional: Real and Probable Future Situations", "Structure: If + Simple Present (V1), will / can / may + Base Verb (V1).", "Example: 'If you study hard, you will pass the examination.' Expresses real possibility."),
          SubjectFactPoint(4, "First Conditional Variations", "Can use modal auxiliaries (can, must, should) or imperatives in the main clause instead of 'will'.", "Example: 'If you feel unwell, see a doctor.' 'If it rains, you can stay here.'"),
          SubjectFactPoint(5, "Second Conditional: Hypothetical or Unreal Situations in Present", "Structure: If + Simple Past (V2), would / could / might + Base Verb (V1).", "Example: 'If I had a million rupees, I would build a hospital.' Situation is imaginary/untrue now."),
          SubjectFactPoint(6, "Second Conditional: 'Were' for All Subjects", "In formal English, use 'were' instead of 'was' for all singular and plural subjects in the If-clause.", "Example: 'If I were you, I would accept the job offer.' 'If she were here, she would help us.'"),
          SubjectFactPoint(7, "Giving Advice: 'If I were you, I would...'", "The standard formal idiom for offering polite constructive advice to another person.", "Tested regularly in functional English and dialogues."),
          SubjectFactPoint(8, "Third Conditional: Impossible Past Regrets", "Structure: If + Past Perfect (had + V3), would have + Past Participle (V3).", "Example: 'If you had warned me, I would have avoided the mistake.' Action did not happen in the past."),
          SubjectFactPoint(9, "Third Conditional: Expressing Historical Outcomes & Regrets", "Used to reflect on past events that cannot be changed and imagine their alternative outcome.", "Example: 'If the captain had played, Sri Lanka would have won the match.'"),
          SubjectFactPoint(10, "'Unless' = 'If ... not'", "'Unless' introduces a negative condition and is followed by an affirmative verb (avoid double negatives).", "Example: 'Unless you work hard, you will fail' = 'If you do not work hard, you will fail.'"),
          SubjectFactPoint(11, "Mixed Conditionals", "Combines past condition with present result (Third + Second conditional).", "Example: 'If I had won the scholarship last year, I would be studying in London today.'"),
          SubjectFactPoint(12, "'Provided that' / 'As long as' / 'On condition that'", "Alternatives to 'if' meaning 'only on the condition that'.", "Example: 'You can borrow my laptop provided that you return it by Friday.'"),
          SubjectFactPoint(13, "'In case' vs 'If'", "'In case' means doing something beforehand as a precaution against a possible future need.", "Example: 'Take an umbrella in case it rains' (take it now; not only if it starts raining)."),
          SubjectFactPoint(14, "Inversion in Conditionals (Formal Literary Style)", "Omit 'if' and invert the subject and auxiliary: Had I known -> If I had known; Were I in your place -> If I were; Should you need assistance -> If you should need.", "Prestigious distinction-level grammar structure."),
          SubjectFactPoint(15, "'Wish' + Past Simple for Present Discontent", "Use 'wish' + Simple Past to express desire for a present situation to be different.", "Example: 'I wish I had a car (I don't have one now).' 'I wish it weren't raining.'"),
          SubjectFactPoint(16, "'Wish' + Past Perfect for Past Regret", "Use 'wish' + Past Perfect to express regret over a past mistake or occurrence.", "Example: 'I wish I had studied harder for the term test.'"),
          SubjectFactPoint(17, "'If only' for Stronger Emotion", "Functions like 'wish' but conveys greater emotional intensity or dramatic regret.", "Example: 'If only I had listened to my mother's advice!'"),
          SubjectFactPoint(18, "Modal Variations in Third Conditional", "Can use 'could have' (ability) or 'might have' (possibility) instead of 'would have'.", "Example: 'If we had left earlier, we could have caught the 6:00 a.m. express.'"),
          SubjectFactPoint(19, "Common Mistake: 'Will' in the If-Clause", "Never use 'will' or 'would' inside the conditional 'If clause'.", "Say 'If it rains, we will cancel' (NOT 'If it will rain, we will cancel')."),
          SubjectFactPoint(20, "O/L Exam Tip: Sentence Completion Questions", "In O/L Paper II Question 11, completing conditional sentence stems (e.g., 'If she invites me, ...') is a recurring question type.", "Match the tense of the main clause strictly to the condition clause!")
        )
      ),

      // Category 8: Modal Auxiliary Verbs & Functions
      SubjectMasterCategory(
        id = "eng_cat_8",
        categoryNumber = 8,
        titleSinhala = "Modal Auxiliary Verbs & Functions",
        icon = "🛠️",
        color = Color(0xFF0284C7),
        summary = "Can, could, may, might, must, should, ought to, would, need, and dare.",
        points = listOf(
          SubjectFactPoint(1, "Characteristics of Modal Auxiliary Verbs", "Modals do not take -s in third-person singular (no 'cans'), do not have infinitive or -ing forms, and are followed directly by Base Verb (V1).", "Negative formed by adding 'not' directly to the modal."),
          SubjectFactPoint(2, "Can: Present Ability and Informal Permission", "Ability: 'She can speak four languages fluently.' Informal permission: 'Can I borrow your ruler?'", "Negative: cannot (single word) or can't."),
          SubjectFactPoint(3, "Could: Past Ability and Polite Requests", "Past ability: 'When I was seven, I could swim across the river.' Polite request: 'Could you please open the door?' (more polite than can).", "Could is used for hypothetical ability in conditionals."),
          SubjectFactPoint(4, "May: Formal Permission and Possibility", "Formal permission: 'May I come in, Sir?' (standard classroom English). Possibility: 'It may rain this evening' (50% likelihood).", "Cannot be contracted to mayn't in modern English."),
          SubjectFactPoint(5, "Might: Remote / Weak Possibility", "Expresses a lower degree of probability than 'may' (approx. 20-30% chance).", "Example: 'Take your jacket; it might get cold later tonight.'"),
          SubjectFactPoint(6, "Must: Strong Obligation and Personal Compulsion", "Expresses an urgent necessity or internal duty felt by the speaker.", "Example: 'I must work harder this term.' 'Candidates must answer all questions.'"),
          SubjectFactPoint(7, "Must: Logical Deduction (Certainty)", "Making an inevitable deduction based on strong visible evidence.", "Example: 'The lights are off and the gate is locked; they must be out.'"),
          SubjectFactPoint(8, "Must not / Mustn't: Prohibition", "Indicates that an action is strictly forbidden by rules or laws.", "Example: 'Students must not use mobile phones inside examination halls.'"),
          SubjectFactPoint(9, "'Have to' vs 'Must'", "'Must' comes from speaker's personal conviction; 'Have to' comes from external rules, laws or authority.", "Example: 'In Sri Lanka, motorcyclists have to wear helmets' (law)."),
          SubjectFactPoint(10, "'Don't have to' / 'Needn't': Lack of Obligation", "Indicates that an action is not necessary, but the person is free to do it if they wish (absence of compulsion).", "Example: 'Tomorrow is Sunday; we don't have to wake up early.'"),
          SubjectFactPoint(11, "Should: Advice, Recommendation and Duty", "Used to give constructive advice or suggest the right and sensible course of action.", "Example: 'You look exhausted; you should consult a doctor.'"),
          SubjectFactPoint(12, "Ought to: Moral Duty and Ethical Expectation", "Similar to 'should' but carries a stronger moral obligation or social duty.", "Example: 'We ought to respect our parents and teachers.'"),
          SubjectFactPoint(13, "'Should have' + V3: Past Unfulfilled Duty", "Expresses criticism or regret that a desirable action was not performed in the past.", "Example: 'You should have apologized to him yesterday (but you didn't).'"),
          SubjectFactPoint(14, "Would: Polite Offers, Habits and Conditionals", "Polite invitation: 'Would you like some tea?' Hypothetical: 'I would travel the world if I were free.' Past habit: 'Grandma would bake cakes every Saturday.'", "Most versatile modal auxiliary."),
          SubjectFactPoint(15, "'Would rather' for Preference", "Expresses subjective preference: Would rather + Base Verb + than.", "Example: 'I would rather read a book than watch television tonight.'"),
          SubjectFactPoint(16, "'Had better' for Urgent Warning / Advice", "Had better + Base Verb (V1) warns that negative consequences will follow if advice is ignored.", "Example: 'You had better leave now or you will miss the last bus.' (Negative: had better not)."),
          SubjectFactPoint(17, "Modals of Deduction in the Past", "Must have + V3 (almost certain): 'He must have left early.' Can't have + V3 (impossible): 'She can't have stolen it; she was with me.' Might have + V3 (possibility).", "Essential for deduction and comprehension inference."),
          SubjectFactPoint(18, "Semi-modal: 'Used to'", "Refers exclusively to past habits or discontinued states. Does not have a present tense form.", "Example: 'There used to be a large banyan tree here.'"),
          SubjectFactPoint(19, "Semi-modals: 'Need' and 'Dare'", "Can behave as modal verbs without 'to' in negatives and questions: 'You need not worry.' 'How dare you speak like that!'", "In positive sentences, usually takes full infinitive: 'He needs to study.'"),
          SubjectFactPoint(20, "O/L Exam Tip: Functional Modal Identification", "In O/L Paper I and Paper II dialogues, choosing the appropriate modal for permission (May), obligation (Must), or advice (Should) is tested.", "Identify the speaker's exact communicative function.")
        )
      ),

      // Category 9: Relative Clauses & Pronouns
      SubjectMasterCategory(
        id = "eng_cat_9",
        categoryNumber = 9,
        titleSinhala = "Relative Clauses & Pronouns",
        icon = "🔗",
        color = Color(0xFF0284C7),
        summary = "Who, which, that, whom, whose, defining vs non-defining relative clauses.",
        points = listOf(
          SubjectFactPoint(1, "Relative Clause Definition", "A subordinate clause that modifies or gives additional information about a noun or pronoun in the main clause.", "Introduced by relative pronouns: who, whom, whose, which, that."),
          SubjectFactPoint(2, "'Who' for Persons (Subject)", "Used when referring to people as the subject of the relative clause.", "Example: 'The doctor who treated my grandmother was very gentle.'"),
          SubjectFactPoint(3, "'Which' for Animals and Things", "Used when referring to non-human objects, animals, and abstract concepts.", "Example: 'The novel which won the award was written by a local author.'"),
          SubjectFactPoint(4, "'That' for People, Animals and Things", "Commonly used in defining relative clauses for both people and things.", "Example: 'The laptop that I bought last week has a long battery life.'"),
          SubjectFactPoint(5, "'Whom' for Persons (Object)", "Formal relative pronoun used when the person is the object of the relative clause or follows a preposition.", "Example: 'The boy whom we met yesterday is a talented pianist.' 'The officer to whom I spoke.'"),
          SubjectFactPoint(6, "'Whose' for Possession", "Indicates ownership or belonging for both people and inanimate objects.", "Example: 'I met a student whose father is an astronomer.' 'A triangle whose sides are equal.'"),
          SubjectFactPoint(7, "Defining (Restrictive) Relative Clauses", "Provides essential identifying information about the noun. Without it, the sentence is incomplete or ambiguous. No commas are used.", "Example: 'Students who score over 75 marks receive a distinction.'"),
          SubjectFactPoint(8, "Non-Defining (Non-Restrictive) Relative Clauses", "Gives extra, non-essential information about an already identified noun. Separated by commas on both sides.", "Example: 'Mr. Silva, who lives next door, is an engineer.' Sentence still makes sense without it."),
          SubjectFactPoint(9, "'That' is Never Used in Non-Defining Clauses", "In non-defining relative clauses with commas, use 'who' for people and 'which' for things (never 'that').", "Say: 'Kandy, which is surrounded by hills, is a sacred city' (NOT 'that is surrounded')."),
          SubjectFactPoint(10, "Omitting the Relative Pronoun", "In defining clauses, the relative pronoun (who/which/that) can be omitted if it is the object of the relative clause.", "Example: 'The film (which) we watched was hilarious.' Cannot omit if it is the subject."),
          SubjectFactPoint(11, "Relative Adverbs: 'Where' for Places", "Refers to a geographical location or place.", "Example: 'This is the hospital where I was born.' (= in which)."),
          SubjectFactPoint(12, "Relative Adverbs: 'When' for Time", "Refers to a specific point or period of time.", "Example: 'I remember the day when we first arrived in Kandy.' (= on which)."),
          SubjectFactPoint(13, "Relative Adverbs: 'Why' for Reasons", "Follows the noun 'reason'.", "Example: 'That is the reason why she was absent from the meeting.'"),
          SubjectFactPoint(14, "Prepositions in Relative Clauses: Formal vs Informal", "Formal: Preposition precedes relative pronoun ('The house in which he lived'). Informal: Preposition at the end ('The house which he lived in').", "O/L essays accept both, but prepositions at the end are more natural."),
          SubjectFactPoint(15, "'Whoever', 'Whatever', 'Wherever'", "Compound relative pronouns meaning 'any person who', 'anything that', 'any place where'.", "Example: 'Whoever finishes the test first may leave quietly.'"),
          SubjectFactPoint(16, "Reduced Relative Clauses (Participle Clauses)", "Shortening relative clauses using present (-ing) or past (-ed) participles.", "'The boy who is sitting near the window' -> 'The boy sitting near the window.' 'Books which were published in 2020' -> 'Books published in 2020.'"),
          SubjectFactPoint(17, "Combining Sentences Using Relative Pronouns", "Exam skill: Join two short sentences into one complex sentence using who/which/whose.", "'A girl won the race. She is my cousin' -> 'The girl who won the race is my cousin.'"),
          SubjectFactPoint(18, "'All of which' / 'Some of whom'", "Quantifier + of + which / whom used in formal descriptive writing.", "Example: 'The school has 50 teachers, all of whom are university graduates.'"),
          SubjectFactPoint(19, "'What' as a Nominal Relative Pronoun", "'What' means 'the thing that' and does not need an antecedent noun.", "Example: 'I couldn't hear what he said' (= the thing that he said)."),
          SubjectFactPoint(20, "O/L Exam Tip: Relative Clause Synthesis", "In O/L Paper II Question 11/12, combining two sentences with appropriate relative pronouns is a guaranteed question.", "Eliminate repeated pronouns (he, she, it) when joining!")
        )
      ),

      // Category 10: Prepositions of Time, Place & Direction
      SubjectMasterCategory(
        id = "eng_cat_10",
        categoryNumber = 10,
        titleSinhala = "Prepositions of Time, Place & Direction",
        icon = "📍",
        color = Color(0xFF0284C7),
        summary = "At, in, on, under, between, among, through, across, into, onto and dependent prepositions.",
        points = listOf(
          SubjectFactPoint(1, "Prepositions of Time: 'At' for Specific Clock Times", "Used for precise points of time: at 7:30 a.m., at midnight, at noon, at dawn, at bedtime.", "Special exceptions: at the weekend, at Christmas, at night."),
          SubjectFactPoint(2, "Prepositions of Time: 'On' for Days and Dates", "Used for days of the week, calendar dates, and specific named days: on Monday, on 4th February, on my birthday, on New Year's Day.", "Whenever a specific day is named, use 'on'."),
          SubjectFactPoint(3, "Prepositions of Time: 'In' for Longer Periods", "Used for months, years, centuries, seasons, and parts of the day: in May, in 2026, in the 21st century, in summer, in the morning, in the afternoon.", "Rule of thumb: At (precise) -> On (days/dates) -> In (longer)."),
          SubjectFactPoint(4, "Prepositions of Place: 'At' for Exact Points", "Used for specific addresses, points on a map, and public locations: at the bus stop, at the door, at 45 Main Street, at school, at university.", "Represents a point in space."),
          SubjectFactPoint(5, "Prepositions of Place: 'In' for Enclosed Spaces", "Used for three-dimensional enclosed containers, buildings, cities, countries: in a box, in the room, in Colombo, in Sri Lanka, in the sky.", "Within boundaries or volume."),
          SubjectFactPoint(6, "Prepositions of Place: 'On' for Surfaces", "Used for flat horizontal or vertical surfaces: on the table, on the wall, on the floor, on the ceiling, on page 25.", "Also for public transport: on a bus, on a train, on a plane (but 'in a car')."),
          SubjectFactPoint(7, "'Between' vs 'Among'", "'Between' is used when distinguishing two distinct persons or things (e.g., between Nimal and Sunil). 'Among' is used for three or more in an indefinite group (e.g., among the crowd, among the trees).", "Frequent error in cloze passage tests."),
          SubjectFactPoint(8, "Prepositions of Movement: 'Into' vs 'In'", "'In' indicates static resting position inside. 'Into' indicates dynamic movement from outside to inside.", "Example: 'He jumped into the swimming pool' vs 'He is swimming in the pool.'"),
          SubjectFactPoint(9, "Prepositions of Movement: 'Onto' vs 'On'", "'On' indicates static resting surface. 'Onto' indicates movement towards and finishing on top of a surface.", "Example: 'The cat jumped onto the kitchen counter.'"),
          SubjectFactPoint(10, "'Across' vs 'Through'", "'Across' means from one side to the other over a flat surface (across the road, across the river). 'Through' means movement inside a three-dimensional volume (through the forest, through the tunnel).", "Spatial orientation distinction."),
          SubjectFactPoint(11, "'Above' vs 'Over'", "'Over' indicates directly vertically above, often with movement or covering. 'Above' indicates higher level or position without direct contact.", "Example: 'A plane flew over the city.' 'His marks are above average.'"),
          SubjectFactPoint(12, "'Under' vs 'Below'", "'Under' indicates directly vertically underneath. 'Below' indicates lower elevation, grade, or level.", "Example: 'The cat slept under the table.' 'Temperatures fell below freezing point.'"),
          SubjectFactPoint(13, "'By' for Deadlines and Agency", "Deadline: 'You must submit the assignment by Friday' (meaning on or before Friday). Agency: 'The song was sung by a famous artist.' Transport: 'by bus', 'by train'.", "Preposition of multiple critical functions."),
          SubjectFactPoint(14, "'During' vs 'For' vs 'While'", "'During' + Noun (during the holiday). 'For' + Duration of time (for two weeks). 'While' + Clause with Subject and Verb (while we were waiting).", "Never write 'during two hours'."),
          SubjectFactPoint(15, "Dependent Prepositions: Verbs + Prepositions", "Depend on, listen to, belong to, look forward to, agree with (person), agree to (proposal), apologize for, succeed in.", "Must be memorized as fixed collocations."),
          SubjectFactPoint(16, "Dependent Prepositions: Adjectives + Prepositions", "Afraid of, good at, bad at, interested in, proud of, famous for, different from, satisfied with, accustomed to.", "Say 'good at English' (NOT 'good in English')."),
          SubjectFactPoint(17, "No Preposition Before 'Home', 'Next', 'Last'", "Do NOT use prepositions before home (e.g., 'go home', NOT 'go to home'), or before time expressions with next, last, every, this (e.g., 'last Monday', NOT 'on last Monday').", "Crucial grammar accuracy rule."),
          SubjectFactPoint(18, "'In time' vs 'On time'", "'On time' means exactly punctually at the scheduled time (e.g., 'The train arrived on time at 9:00'). 'In time' means early enough before it's too late (e.g., 'We reached the station in time to buy tickets').", "Distinction tested in comprehension passages."),
          SubjectFactPoint(19, "'At the end' vs 'In the end'", "'At the end of' + Noun refers to the physical or temporal finish (e.g., 'at the end of the street/movie'). 'In the end' is an idiom meaning 'finally / eventually' after difficulties.", "Example: 'We debated for hours, but in the end we agreed.'"),
          SubjectFactPoint(20, "O/L Exam Tip: Cloze Test Mastery (Test 3 & Test 9)", "Prepositions constitute nearly 40% of all missing words in O/L cloze test blanks.", "Inspect the preceding verb/adjective and the following noun to select the exact preposition.")
        )
      )
    )
  }
}
