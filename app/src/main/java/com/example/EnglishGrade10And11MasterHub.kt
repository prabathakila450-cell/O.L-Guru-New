package com.example

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

// ==============================================================================
// 1. DATA MODELS & ENUMS
// ==============================================================================

enum class EnglishSectionCategory(
  val id: String,
  val titleSinhala: String,
  val subtitle: String,
  val emoji: String,
  val themeColor: Color
) {
  TEXTBOOK_UNITS("units", "පාසල් පෙළපොත් ඒකක (Grade 10 & 11)", "නිල විෂය නිර්දේශයේ ඒකක 14ම", "📖", Color(0xFF0284C7)),
  GRAMMAR_FORMULAS("grammar", "ප්‍රධාන ව්‍යාකරණ සූත්‍ර & රීති", "Tenses, Passive, Conditionals, Reported", "📐", Color(0xFF7C3AED)),
  VOCABULARY("vocab", "අධ්‍යාපනික වාග්කෝෂය (Vocabulary)", "විභාගයට අත්‍යවශ්‍ය පාරිභාෂික වචන", "🔤", Color(0xFF059669)),
  WRITING_FORMATS("writing", "රචනා, ලිපි & නිවේදන ආකෘති", "Official Letter, Notice, Note, Essay", "📝", Color(0xFFD97706)),
  RAPID_MCQS("mcq", "ඉලක්කගත MCQs & විවරණ", "ප්‍රශ්න පත්‍ර I & II කෙටි ප්‍රශ්න", "🎯", Color(0xFFE11D48))
}

data class EnglishTextbookUnit(
  val id: String,
  val grade: String,
  val unitNumber: Int,
  val unitTitle: String,
  val titleSinhala: String,
  val mainTheme: String,
  val grammarFocus: String,
  val activityOutline: String,
  val readingPassageSummary: String,
  val keyVocabularyWithSinhala: List<Pair<String, String>>,
  val sampleExamQuestions: List<String>
)

data class EnglishGrammarFormulaItem(
  val id: String,
  val titleSinhala: String,
  val topic: String,
  val formula: String,
  val rules: List<String>,
  val examTip: String,
  val explanationSinhala: String,
  val correctExamples: List<String>,
  val commonErrorsWithCorrection: List<Pair<String, String>>
)

data class EnglishRapidMcqItem(
  val topic: String,
  val question: String,
  val options: List<String>,
  val correctIndex: Int,
  val explanation: String
)

// ==============================================================================
// 2. MASTER DATA PROVIDER
// ==============================================================================

object EnglishMasterDataProvider {

  val textbookUnits = listOf(
    // GRADE 10 UNITS
    EnglishTextbookUnit(
      id = "g10_u1",
      grade = "10",
      unitNumber = 1,
      unitTitle = "A New Beginning",
      titleSinhala = "නව ඇරඹුමක්",
      mainTheme = "School orientation, meeting new friends, and personal aspirations.",
      grammarFocus = "Simple Present & Present Continuous Tenses",
      activityOutline = "Describing school routines, writing introductory notes.",
      readingPassageSummary = "A reflection on embarking on the secondary education journey with discipline and ambition.",
      keyVocabularyWithSinhala = listOf("Orientation" to "නැඹුරු කිරීම", "Aspiration" to "අභිලාෂය", "Diligence" to "උත්සාහය"),
      sampleExamQuestions = listOf("Describe your daily routine at school.", "Fill in blanks with appropriate present tense verbs.")
    ),
    EnglishTextbookUnit(
      id = "g10_u2",
      grade = "10",
      unitNumber = 2,
      unitTitle = "Healthy Living",
      titleSinhala = "නීරෝගී දිවිපැවැත්ම",
      mainTheme = "Nutrition, physical exercise, personal hygiene, and mental health.",
      grammarFocus = "Modals of Advice (Should, Must, Ought to)",
      activityOutline = "Writing healthy diet charts, preparing health notices.",
      readingPassageSummary = "Emphasizes the vital balance of balanced diet, adequate hydration, and physical workouts.",
      keyVocabularyWithSinhala = listOf("Nutritious" to "පෝෂ්‍යදායී", "Hygiene" to "පිරිසිදුකම", "Metabolism" to "පරිවෘත්තිය"),
      sampleExamQuestions = listOf("Write a notice advising students on dengue prevention.", "Draft a note to a friend about eating habits.")
    ),
    EnglishTextbookUnit(
      id = "g10_u3",
      grade = "10",
      unitNumber = 3,
      unitTitle = "Protecting Our Environment",
      titleSinhala = "අපේ පරිසරය සුරකිමු",
      mainTheme = "Biodiversity, forest conservation, wildlife protection, and pollution control.",
      grammarFocus = "First Conditional (If + Present, Future)",
      activityOutline = "Designing environmental posters, writing speech on deforestation.",
      readingPassageSummary = "Examines human impact on fragile ecosystems and promotes zero-plastic initiatives.",
      keyVocabularyWithSinhala = listOf("Biodiversity" to "ජෛව විවිධත්වය", "Ecosystem" to "පරිසර පද්ධතිය", "Conservation" to "සංරක්ෂණය"),
      sampleExamQuestions = listOf("Write a short speech on protecting natural resources.", "Complete the conditional sentences.")
    ),
    EnglishTextbookUnit(
      id = "g10_u4",
      grade = "10",
      unitNumber = 4,
      unitTitle = "The World of Technology",
      titleSinhala = "තාක්ෂණයේ ලෝකය",
      mainTheme = "Computers, internet safety, artificial intelligence, and digital communication.",
      grammarFocus = "Passive Voice (Present & Past Simple)",
      activityOutline = "Describing technological processes, explaining gadget functions.",
      readingPassageSummary = "Explores how modern computational technologies transform classrooms and everyday life.",
      keyVocabularyWithSinhala = listOf("Innovation" to "නවෝත්පාදනය", "Cybersecurity" to "සයිබර් ආරක්ෂාව", "Automated" to "ස්වයංක්‍රීය"),
      sampleExamQuestions = listOf("Turn sentences into Passive Voice.", "Write a paragraph on the advantages of digital learning.")
    ),
    EnglishTextbookUnit(
      id = "g10_u5",
      grade = "10",
      unitNumber = 5,
      unitTitle = "Cultural Heritage",
      titleSinhala = "සංස්කෘතික උරුමය",
      mainTheme = "Sri Lankan ancient monuments, traditions, religious festivals, and folklore.",
      grammarFocus = "Past Continuous & Past Simple with When/While",
      activityOutline = "Writing descriptive essays about historical sites, describing cultural dances.",
      readingPassageSummary = "A guided exploration through Sigiriya, Anuradhapura, and traditional handicraft villages.",
      keyVocabularyWithSinhala = listOf("Heritage" to "උරුමය", "Archaeology" to "පුරාවිද්‍යාව", "Monuments" to "ස්මාරක"),
      sampleExamQuestions = listOf("Describe a historical place you visited.", "Use 'while' and 'when' in past contexts.")
    ),

    // GRADE 11 UNITS
    EnglishTextbookUnit(
      id = "g11_u1",
      grade = "11",
      unitNumber = 1,
      unitTitle = "Nature's Wonders",
      titleSinhala = "ස්වභාවධර්මයේ අසිරිය",
      mainTheme = "Geographical phenomena, ecotourism, rare wildlife, and marine reserves.",
      grammarFocus = "Relative Clauses (Who, Which, That, Whose)",
      activityOutline = "Writing descriptive articles, analyzing eco-tourist brochures.",
      readingPassageSummary = "Highlights the majestic coral reefs of Pigeon Island and the cloud forests of Horton Plains.",
      keyVocabularyWithSinhala = listOf("Phenomenon" to "සිද්ධිය/ප්‍රපංචය", "Sanctuary" to "අභයභූමිය", "Pristine" to "නොකැළැල්"),
      sampleExamQuestions = listOf("Join sentences using relative pronouns.", "Write an essay about eco-tourism in Sri Lanka.")
    ),
    EnglishTextbookUnit(
      id = "g11_u2",
      grade = "11",
      unitNumber = 2,
      unitTitle = "Career Horizons",
      titleSinhala = "වෘත්තීය ක්ෂේත්‍ර",
      mainTheme = "Vocational skills, career pathways, writing CVs, and professional interviews.",
      grammarFocus = "Present Perfect Continuous & Future Perfect",
      activityOutline = "Drafting formal letters of job application, role-playing interviews.",
      readingPassageSummary = "Guides school leavers through technical and tertiary opportunities in modern industries.",
      keyVocabularyWithSinhala = listOf("Profession" to "වෘත්තිය", "Qualifications" to "සුදුසුකම්", "Competence" to "ප්‍රවීණතාවය"),
      sampleExamQuestions = listOf("Write a formal letter applying for a post.", "Use present perfect continuous in sentences.")
    ),
    EnglishTextbookUnit(
      id = "g11_u3",
      grade = "11",
      unitNumber = 3,
      unitTitle = "Global Citizenship",
      titleSinhala = "ගෝලීය පුරවැසිභාවය",
      mainTheme = "Human rights, peaceful coexistence, intercultural exchange, and disaster relief.",
      grammarFocus = "Reported Speech (Statements & Questions)",
      activityOutline = "Reporting dialogues, writing summaries of international relief campaigns.",
      readingPassageSummary = "Examines how global youth collaborate to resolve cross-border humanitarian challenges.",
      keyVocabularyWithSinhala = listOf("Coexistence" to "සහජීවනය", "Diplomacy" to "රාජ්‍යතාන්ත්‍රිකත්වය", "Solidarity" to "සහයෝගීතාවය"),
      sampleExamQuestions = listOf("Convert direct quotes into reported speech.", "Write a speech on youth unity.")
    ),
    EnglishTextbookUnit(
      id = "g11_u4",
      grade = "11",
      unitNumber = 4,
      unitTitle = "Arts and Literature",
      titleSinhala = "කලාව හා සාහිත්‍යය",
      mainTheme = "Poetry appreciation, drama critique, classical music, and creative expression.",
      grammarFocus = "Conditionals Type 2 & Type 3 (Unreal past & hypothetical)",
      activityOutline = "Writing book reviews, interpreting metaphors in poems.",
      readingPassageSummary = "Explores the psychological depth of renowned Sri Lankan and international literary classics.",
      keyVocabularyWithSinhala = listOf("Metaphor" to "රූපකය", "Imagery" to "ප්‍රතිරූපණ", "Critique" to "විවේචනය"),
      sampleExamQuestions = listOf("Write a short review of a book you enjoyed.", "Complete conditional type 3 clauses.")
    ),
    EnglishTextbookUnit(
      id = "g11_u5",
      grade = "11",
      unitNumber = 5,
      unitTitle = "Science and Future",
      titleSinhala = "විද්‍යාව හා අනාගතය",
      mainTheme = "Space exploration, renewable energy revolutions, robotics, and bioengineering.",
      grammarFocus = "Complex Prepositions & Conjunctions (Although, Despite, Furthermore)",
      activityOutline = "Synthesizing bar charts, contrasting trends across decades.",
      readingPassageSummary = "Envisions sustainable futuristic cities powered by clean zero-emission hydrogen grids.",
      keyVocabularyWithSinhala = listOf("Robotics" to "රොබෝ තාක්ෂණය", "Renewable" to "පුනර්ජනනීය", "Breakthrough" to "විශිෂ්ට ජයග්‍රහණය"),
      sampleExamQuestions = listOf("Interpret a given bar graph describing energy usage.", "Use 'Despite' and 'Although' correctly.")
    )
  )

  val grammarFormulas = listOf(
    EnglishGrammarFormulaItem(
      id = "gf_1",
      titleSinhala = "සරල වර්තමාන කාලය (Simple Present Tense)",
      topic = "Simple Present Tense",
      formula = "Subject + V1 (base form) (+ s/es for He/She/It)",
      rules = listOf(
        "Use for universal truths, daily habits, schedules, and permanent facts.",
        "Add -es if verb ends in -ch, -sh, -s, -x, -z, -o (e.g. watches, goes).",
        "Negative: Subject + do/does not + V1 base form."
      ),
      examTip = "In O/L Paper 1 fill-in-the-blanks, always check if the subject is singular (He/She/It) or plural.",
      explanationSinhala = "දෛනික පුරුදු, සනාතන සත්‍ය සහ කාලසටහන් ප්‍රකාශ කිරීමට යොදා ගනී.",
      correctExamples = listOf("The sun rises in the east.", "She attends English class every Sunday.", "They do not play football in the rain."),
      commonErrorsWithCorrection = listOf(
        "He go to school daily." to "He goes to school daily.",
        "She does not likes tea." to "She does not like tea."
      )
    ),
    EnglishGrammarFormulaItem(
      id = "gf_2",
      titleSinhala = "කර්ම කාරකය (Passive Voice - Simple Present & Past)",
      topic = "Passive Voice",
      formula = "Object + is/am/are (or was/were) + Past Participle (V3) (+ by agent)",
      rules = listOf(
        "Focus shifts from the doer of the action to the recipient/object.",
        "Present: is/are + V3 (e.g. Tea is grown in Nuwara Eliya).",
        "Past: was/were + V3 (e.g. Sigiriya was built by King Kashyapa)."
      ),
      examTip = "Passive voice is heavily tested in process descriptions and reporting news.",
      explanationSinhala = "ක්‍රියාව කරන පුද්ගලයාට වඩා ක්‍රියාවට හෝ ප්‍රතිඵලයට ප්‍රමුඛත්වය දෙන විට කර්මකාරකය යොදා ගැනේ.",
      correctExamples = listOf("English is spoken worldwide.", "The award was presented by the principal."),
      commonErrorsWithCorrection = listOf(
        "The letter was wrote by him." to "The letter was written by him.",
        "Rubber is grow in Kalutara." to "Rubber is grown in Kalutara."
      )
    ),
    EnglishGrammarFormulaItem(
      id = "gf_3",
      titleSinhala = "ප්‍රථම හා දෙවන කොන්දේසි (Conditionals Type 1 & 2)",
      topic = "Conditional Clauses",
      formula = "Type 1: If + Simple Present, will + V1 | Type 2: If + Simple Past, would + V1",
      rules = listOf(
        "Type 1: Real and probable future possibility (e.g. If it rains, we will stay).",
        "Type 2: Unreal, imaginary or hypothetical situation (e.g. If I were you, I would study)."
      ),
      examTip = "Never use 'will' or 'would' inside the 'if' clause itself.",
      explanationSinhala = "යම් කොන්දේසියක් ඉටුවුවහොත් සිදුවන ප්‍රතිඵල ප්‍රකාශ කිරීමට Conditionals යොදා ගනී.",
      correctExamples = listOf("If you practice daily, you will pass the exam.", "If I had wings, I would fly across mountains."),
      commonErrorsWithCorrection = listOf(
        "If he will come, I will meet him." to "If he comes, I will meet him.",
        "If I was rich, I will travel." to "If I were rich, I would travel."
      )
    ),
    EnglishGrammarFormulaItem(
      id = "gf_4",
      titleSinhala = "වක්‍ර කථනය (Reported Speech - Statements)",
      topic = "Reported Speech",
      formula = "Subject + said that + Subject + Backshifted Verb + Adjusted Pronouns/Time",
      rules = listOf(
        "Simple Present shifts to Simple Past (am/is -> was, have -> had).",
        "Pronouns change based on the speaker and listener.",
        "Time words shift: today -> that day, tomorrow -> the next day, now -> then."
      ),
      examTip = "In O/L Paper 2, check that inverted commas are removed in indirect speech.",
      explanationSinhala = "අනෙකෙකු පැවසූ ප්‍රකාශයක් අපගේ වචනයෙන් නැවත ප්‍රකාශ කිරීමයි.",
      correctExamples = listOf("Direct: 'I am tired,' he said. -> Reported: He said that he was tired.", "Direct: 'We will come tomorrow,' they said. -> Reported: They said that they would come the next day."),
      commonErrorsWithCorrection = listOf(
        "He said that he is tired now." to "He said that he was tired then.",
        "She told me that she will help." to "She told me that she would help."
      )
    )
  )

  val rapidMcqs = listOf(
    EnglishRapidMcqItem(
      topic = "Subject-Verb Agreement",
      question = "Neither the teacher nor the students ______ present in the auditorium.",
      options = listOf("was", "were", "is", "has"),
      correctIndex = 1,
      explanation = "With 'neither... nor...', the verb agrees with the closer subject ('the students' is plural, so 'were')."
    ),
    EnglishRapidMcqItem(
      topic = "Prepositions",
      question = "She has been residing in Kandy ______ 2018.",
      options = listOf("for", "since", "from", "during"),
      correctIndex = 1,
      explanation = "'Since' is used with a specific point in time in the past for perfect continuous tenses."
    ),
    EnglishRapidMcqItem(
      topic = "Conditionals",
      question = "If he ______ harder, he would have won the first place in the tournament.",
      options = listOf("trained", "trains", "had trained", "would train"),
      correctIndex = 2,
      explanation = "Third conditional structure: 'If + had + past participle, would have + past participle'."
    ),
    EnglishRapidMcqItem(
      topic = "Passive Voice",
      question = "The ancient fortress of Sigiriya ______ by King Kashyapa in the 5th century.",
      options = listOf("constructed", "was constructed", "is constructing", "has constructed"),
      correctIndex = 1,
      explanation = "Past passive requires 'was + past participle' (was constructed)."
    ),
    EnglishRapidMcqItem(
      topic = "Relative Clauses",
      question = "The scientist ______ discovered the vaccine was awarded the international prize.",
      options = listOf("whom", "which", "whose", "who"),
      correctIndex = 3,
      explanation = "'Who' is the relative pronoun used as a subject referring to people."
    ),
    EnglishRapidMcqItem(
      topic = "Tenses",
      question = "By the time the bell rang, the students ______ their examination papers.",
      options = listOf("completed", "had completed", "have completed", "were completing"),
      correctIndex = 1,
      explanation = "The past perfect tense ('had completed') represents an action completed before another past event."
    ),
    EnglishRapidMcqItem(
      topic = "Vocabulary in Context",
      question = "The principal emphasized the importance of ______ habits to achieve success.",
      options = listOf("negligent", "diligent", "hostile", "fragile"),
      correctIndex = 1,
      explanation = "'Diligent' means hardworking and conscientious, fitting the positive context of achieving success."
    ),
    EnglishRapidMcqItem(
      topic = "Modals",
      question = "You ______ wear a helmet when riding a motorcycle according to Sri Lankan traffic laws.",
      options = listOf("might", "must", "could", "may"),
      correctIndex = 1,
      explanation = "'Must' expresses strict legal obligation and necessity."
    )
  )
}

// ==============================================================================
// 3. UI COMPONENTS: BANNER & DIALOG
// ==============================================================================

@Composable
fun EnglishGrade10And11MasterHubBanner(
  currentGrade: String,
  onOpenHub: (EnglishSectionCategory) -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
    border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.6f))
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Surface(
            shape = CircleShape,
            color = Color(0xFF0284C7).copy(alpha = 0.2f),
            modifier = Modifier.size(38.dp)
          ) {
            Box(contentAlignment = Alignment.Center) {
              Text("🇬🇧", fontSize = 20.sp)
            }
          }
          Spacer(modifier = Modifier.width(10.dp))
          Column {
            Text(
              "English Master Hub (O/L)",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              "Grades 10 & 11 • Textbooks, Grammar & Vocab",
              fontSize = 11.sp,
              color = Color(0xFF38BDF8)
            )
          }
        }

        Surface(
          shape = RoundedCornerShape(8.dp),
          color = Color(0xFF10B981)
        ) {
          Text(
            text = "A Grade",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      Row(
        modifier = Modifier
          .fillMaxWidth()
          .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        EnglishSectionCategory.entries.forEach { cat ->
          Surface(
            shape = RoundedCornerShape(10.dp),
            color = cat.themeColor.copy(alpha = 0.15f),
            border = BorderStroke(1.dp, cat.themeColor.copy(alpha = 0.4f)),
            modifier = Modifier.clickable { onOpenHub(cat) }
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(cat.emoji, fontSize = 13.sp)
              Spacer(modifier = Modifier.width(5.dp))
              Text(
                cat.titleSinhala.take(18) + if (cat.titleSinhala.length > 18) "..." else "",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
              )
            }
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnglishGrade10And11MasterHubDialog(
  initialGrade: String,
  initialCategory: EnglishSectionCategory? = null,
  onDismiss: () -> Unit
) {
  var selectedGrade by remember { mutableStateOf(if (initialGrade in listOf("10", "11")) initialGrade else "11") }
  var selectedCategory by remember { mutableStateOf(initialCategory ?: EnglishSectionCategory.TEXTBOOK_UNITS) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Scaffold(
      topBar = {
        TopAppBar(
          title = {
            Column {
              Text("🇬🇧 English Master Hub (Grades 10 & 11)", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
              Text("O/L Syllabus • Textbooks, Grammar & Vocab", fontSize = 11.sp, color = Color(0xFF38BDF8))
            }
          },
          navigationIcon = {
            IconButton(onClick = onDismiss) {
              Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Close", tint = Color.White)
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
        )
      },
      containerColor = Color(0xFF0B1120)
    ) { padding ->
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(padding)
          .padding(horizontal = 14.dp, vertical = 8.dp)
      ) {
        // Grade Segmented Row
        Surface(
          shape = RoundedCornerShape(10.dp),
          color = Color(0xFF1E293B),
          border = BorderStroke(1.dp, Color(0xFF334155)),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(3.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
          ) {
            listOf("10", "11").forEach { gr ->
              val isSel = selectedGrade == gr
              Surface(
                onClick = { selectedGrade = gr },
                shape = RoundedCornerShape(8.dp),
                color = if (isSel) Color(0xFF0284C7) else Color.Transparent,
                modifier = Modifier.weight(1f)
              ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 7.dp)) {
                  Text(
                    text = "$gr ශ්‍රේණිය (Grade $gr)",
                    fontSize = 12.sp,
                    fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                    color = Color.White
                  )
                }
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Categories Row
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          EnglishSectionCategory.entries.forEach { cat ->
            FilterChip(
              selected = selectedCategory == cat,
              onClick = { selectedCategory = cat },
              label = { Text("${cat.emoji} ${cat.titleSinhala}", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = cat.themeColor,
                selectedLabelColor = Color.White
              )
            )
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Content Area
        when (selectedCategory) {
          EnglishSectionCategory.TEXTBOOK_UNITS -> {
            val units = remember(selectedGrade) {
              EnglishMasterDataProvider.textbookUnits.filter { it.grade == selectedGrade }
            }
            LazyColumn(
              verticalArrangement = Arrangement.spacedBy(10.dp),
              modifier = Modifier.fillMaxSize()
            ) {
              items(units) { u ->
                Card(
                  shape = RoundedCornerShape(12.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                  border = BorderStroke(1.dp, Color(0xFF334155))
                ) {
                  Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(
                        text = "Unit ${u.unitNumber}: ${u.unitTitle}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                      )
                      Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF0284C7).copy(alpha = 0.2f)
                      ) {
                        Text(
                          text = u.titleSinhala,
                          fontSize = 10.sp,
                          color = Color(0xFF7DD3FC),
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "🎯 Theme: ${u.mainTheme}", fontSize = 11.sp, color = Color.White)
                    Text(text = "📐 Grammar: ${u.grammarFocus}", fontSize = 11.sp, color = Color(0xFFFDE68A))

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      text = u.readingPassageSummary,
                      fontSize = 11.sp,
                      color = Color(0xFF94A3B8),
                      lineHeight = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                      modifier = Modifier.horizontalScroll(rememberScrollState()),
                      horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                      u.keyVocabularyWithSinhala.forEach { (word, sinhala) ->
                        Surface(
                          shape = RoundedCornerShape(6.dp),
                          color = Color(0xFF059669).copy(alpha = 0.15f),
                          border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.3f))
                        ) {
                          Text(
                            text = "$word : $sinhala",
                            fontSize = 9.5.sp,
                            color = Color(0xFF86EFAC),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                          )
                        }
                      }
                    }
                  }
                }
              }
            }
          }

          EnglishSectionCategory.GRAMMAR_FORMULAS -> {
            LazyColumn(
              verticalArrangement = Arrangement.spacedBy(10.dp),
              modifier = Modifier.fillMaxSize()
            ) {
              items(EnglishMasterDataProvider.grammarFormulas) { gf ->
                Card(
                  shape = RoundedCornerShape(12.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                  border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.4f))
                ) {
                  Column(modifier = Modifier.padding(14.dp)) {
                    Text(gf.topic, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA78BFA))
                    Text(gf.titleSinhala, fontSize = 11.sp, color = Color(0xFF94A3B8))

                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                      shape = RoundedCornerShape(8.dp),
                      color = Color(0xFF0F172A),
                      border = BorderStroke(1.dp, Color(0xFF334155)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Text(
                        text = "Formula: ${gf.formula}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFDE68A),
                        modifier = Modifier.padding(8.dp)
                      )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    gf.rules.forEach { r ->
                      Text("• $r", fontSize = 10.5.sp, color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text("💡 Exam Tip: ${gf.examTip}", fontSize = 10.5.sp, color = Color(0xFF34D399))
                  }
                }
              }
            }
          }

          EnglishSectionCategory.VOCABULARY -> {
            val vocabList = remember { EnglishMassiveVocabularyData.getAllMassiveVocab().take(50) }
            LazyColumn(
              verticalArrangement = Arrangement.spacedBy(8.dp),
              modifier = Modifier.fillMaxSize()
            ) {
              items(vocabList) { item ->
                Card(
                  shape = RoundedCornerShape(10.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                  border = BorderStroke(1.dp, Color(0xFF334155))
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                      Text(item.word, fontSize = 13.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                      Text(item.partOfSpeech, fontSize = 10.sp, color = Color(0xFF38BDF8))
                    }
                    Text(item.sinhalaMeaning, fontSize = 11.5.sp, color = Color(0xFF86EFAC))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(item.exampleSentence, fontSize = 10.sp, color = Color(0xFF94A3B8))
                  }
                }
              }
            }
          }

          EnglishSectionCategory.WRITING_FORMATS -> {
            LazyColumn(
              verticalArrangement = Arrangement.spacedBy(10.dp),
              modifier = Modifier.fillMaxSize()
            ) {
              item {
                Card(
                  shape = RoundedCornerShape(12.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                  border = BorderStroke(1.dp, Color(0xFFD97706).copy(alpha = 0.5f))
                ) {
                  Column(modifier = Modifier.padding(14.dp)) {
                    Text("Formal Letter Format (ලකුණු 10ක ප්‍රශ්නය)", fontSize = 13.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      "1. Sender's Address & Date\n2. Receiver's Designation & Address\n3. Salutation (Dear Sir/Madam)\n4. Heading (Underlined)\n5. Body Paragraphs (Purpose, Details, Action required)\n6. Formal Close (Yours faithfully)\n7. Signature & Full Name",
                      fontSize = 11.sp,
                      color = Color.White,
                      lineHeight = 18.sp
                    )
                  }
                }
              }

              item {
                Card(
                  shape = RoundedCornerShape(12.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                  border = BorderStroke(1.dp, Color(0xFFD97706).copy(alpha = 0.5f))
                ) {
                  Column(modifier = Modifier.padding(14.dp)) {
                    Text("School Notice Template (ලකුණු 5ක ප්‍රශ්නය)", fontSize = 13.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      "[Heading: NOTICE in capital letters]\n[Event Title]\nThis is to inform that the English Literary Association has organized...\n• Date: ...\n• Time: ...\n• Venue: ...\nAll students are cordially invited.\n[Secretary / Teacher-in-Charge]",
                      fontSize = 11.sp,
                      color = Color.White,
                      lineHeight = 18.sp
                    )
                  }
                }
              }
            }
          }

          EnglishSectionCategory.RAPID_MCQS -> {
            LazyColumn(
              verticalArrangement = Arrangement.spacedBy(10.dp),
              modifier = Modifier.fillMaxSize()
            ) {
              itemsIndexed(EnglishMasterDataProvider.rapidMcqs) { idx, mcq ->
                var selectedOpt by remember { mutableStateOf<Int?>(null) }
                Card(
                  shape = RoundedCornerShape(12.dp),
                  colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                  border = BorderStroke(1.dp, Color(0xFF334155))
                ) {
                  Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                      Text("Q${idx + 1}. ${mcq.topic}", fontSize = 11.sp, color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(mcq.question, fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.SemiBold)

                    Spacer(modifier = Modifier.height(8.dp))
                    mcq.options.forEachIndexed { optIdx, opt ->
                      val isCorrect = optIdx == mcq.correctIndex
                      val isSelected = selectedOpt == optIdx
                      val optColor = when {
                        isSelected && isCorrect -> Color(0xFF10B981)
                        isSelected && !isCorrect -> Color(0xFFEF4444)
                        selectedOpt != null && isCorrect -> Color(0xFF10B981)
                        else -> Color(0xFF0F172A)
                      }
                      Surface(
                        onClick = { selectedOpt = optIdx },
                        shape = RoundedCornerShape(8.dp),
                        color = optColor,
                        border = BorderStroke(1.dp, Color(0xFF334155)),
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(vertical = 3.dp)
                      ) {
                        Text(
                          text = "${('A' + optIdx)}. $opt",
                          fontSize = 11.sp,
                          color = Color.White,
                          modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                      }
                    }

                    if (selectedOpt != null) {
                      Spacer(modifier = Modifier.height(6.dp))
                      Text(
                        text = "💡 Explanation: ${mcq.explanation}",
                        fontSize = 10.5.sp,
                        color = Color(0xFFFDE68A)
                      )
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
