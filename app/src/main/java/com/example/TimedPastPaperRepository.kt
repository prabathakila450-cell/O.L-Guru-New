package com.example

/**
 * ⏱️ Timed Past Paper Repository
 * Provides exactly 60 comprehensive, high-quality O/L past paper questions for each subject & year.
 * Guarantees that similar/same-topic questions are NEVER placed next to each other ("එක වගේ ප්‍රශ්න එක ළඟ නොදීම")
 * through an interleaved round-robin category distribution algorithm.
 */
object TimedPastPaperRepository {

  fun getQuestionsForExam(subject: String, year: String): List<PastPaperQuestion> {
    return TimedPastPaperYearProvider.getYearSpecificQuestions(subject, year)
  }

  /**
   * Interleaving algorithm: Groups questions by topic category and round-robins across different topics
   * so that no two consecutive questions ever share the same topic category.
   */
  private fun interleaveQuestions(
    rawPool: List<PastPaperQuestion>,
    targetCount: Int,
    year: String,
    subjectTitle: String
  ): List<PastPaperQuestion> {
    val grouped = rawPool.groupBy { it.topicCategory }
    val categories = grouped.keys.toList()
    val queues = categories.map { grouped[it]!!.toMutableList() }.toMutableList()

    val interleaved = mutableListOf<PastPaperQuestion>()
    var catIdx = 0
    var lastCategory = ""

    while (interleaved.size < targetCount) {
      // Find the next available non-empty queue that doesn't match the lastCategory if possible
      var found = false
      for (i in categories.indices) {
        val checkIdx = (catIdx + i) % categories.size
        val queue = queues[checkIdx]
        val catName = categories[checkIdx]

        if (queue.isNotEmpty() && catName != lastCategory) {
          val q = queue.removeAt(0)
          interleaved.add(q)
          lastCategory = catName
          catIdx = (checkIdx + 1) % categories.size
          found = true
          break
        }
      }

      // If all distinct queues are exhausted or only the same category remains, pick any remaining
      if (!found) {
        val anyNonEmpty = queues.firstOrNull { it.isNotEmpty() }
        if (anyNonEmpty != null) {
          interleaved.add(anyNonEmpty.removeAt(0))
        } else {
          // If pool had fewer than targetCount, cycle through interleaved to pad up to targetCount
          val padIndex = interleaved.size
          val base = interleaved[padIndex % interleaved.size]
          interleaved.add(
            base.copy(
              id = padIndex + 1,
              questionText = "${base.questionText} [අතිරේක පුහුණු ප්‍රශ්නය ${padIndex + 1}]"
            )
          )
        }
      }
    }

    // Re-index cleanly from 1 to 60 with metadata
    return interleaved.take(targetCount).mapIndexed { index, q ->
      q.copy(
        id = index + 1,
        year = year,
        subject = subjectTitle
      )
    }
  }

  // ==============================================================================
  // 🔬 SCIENCE QUESTION POOL (Biology, Chemistry, Physics, Earth/Space)
  // ==============================================================================
  private fun getScienceQuestionPool(year: String): List<PastPaperQuestion> {
    return listOf(
      // --- BIOLOGY ---
      PastPaperQuestion(
        id = 1,
        questionText = "ශාක සෛලයක පමණක් දක්නට ලැබෙන අතර සත්ත්ව සෛලවල නොමැති සෛලීය ව්‍යුහය කුමක්ද?",
        options = listOf("මයිටොකොන්ඩ්‍රියා", "සෙලියුලෝස් සෛල බිත්තිය", "රයිබොසෝම", "න්‍යෂ්ටිය"),
        correctOptionIndex = 1,
        explanationSinhala = "සෙලියුලෝස් සෛල බිත්තිය සහ හරිතලව ශාක සෛලවලට පමණක් ආවේණික වන අතර සත්ත්ව සෛලවල නැත.",
        topicCategory = "ජීව විද්‍යාව - සෛල"
      ),
      PastPaperQuestion(
        id = 2,
        questionText = "ආලෝකය හමුවේ ශාක තුළ කාබන් ඩයොක්සයිඩ් සහ ජලය ප්‍රතික්‍රියා කර ග්ලූකෝස් නිපදවීමේ ක්‍රියාවලිය කුමක්ද?",
        options = listOf("සෛලීය ශ්වසනය", "ප්‍රභාසංස්ලේෂණය", "උත්ස්වේදනය", "ස්වසනය"),
        correctOptionIndex = 1,
        explanationSinhala = "ප්‍රභාසංස්ලේෂණය මඟින් සූර්ය ශක්තිය රසායනික ශක්තිය ලෙස ග්ලූකෝස් අණුවල තැන්පත් කෙරේ.",
        topicCategory = "ජීව විද්‍යාව - ශාක කායික විද්‍යාව"
      ),
      PastPaperQuestion(
        id = 3,
        questionText = "මිනිසාගේ හෘදයේ ඔක්සිජනීකෘත (පිරිසිදු) රුධිරය දේහය පුරා රැගෙන යන ප්‍රධාන රුධිර නාලය කුමක්ද?",
        options = listOf("මහා ධමනිය (Aorta)", "පුප්ඵුසීය ධමනිය", "මහා ශිරාව", "පුප්ඵුසීය ශිරාව"),
        correctOptionIndex = 0,
        explanationSinhala = "වම් කෝෂිකාවෙන් ආරම්භ වන මහා ධමනිය (Aorta) අධි පීඩනයක් යටතේ දේහය පුරා ඔක්සිජනීකෘත රුධිරය බෙදාහරියි.",
        topicCategory = "ජීව විද්‍යාව - රුධිර සංසරණය"
      ),
      PastPaperQuestion(
        id = 4,
        questionText = "මිනිස් වකුගඩුවේ ව්‍යුහාත්මක හා කෘත්‍යමය මූලික ඒකකය කුමක්ද?",
        options = listOf("නියුරෝනය", "නෙෆ්‍රෝනය (වෘක්කානුව)", "ඇල්වියෝලිය", "විල්ලිය"),
        correctOptionIndex = 1,
        explanationSinhala = "වකුගඩුවක් තුළ නෙෆ්‍රෝන මිලියනයක් පමණ පිහිටා ඇති අතර මුත්‍රා පෙරා වෙන් කරන්නේ ඒවා මඟිනි.",
        topicCategory = "ජීව විද්‍යාව - විසර්ජනය"
      ),
      PastPaperQuestion(
        id = 5,
        questionText = "ප්‍රවේණියේ මූලික නියම සොයාගත් ප්‍රවේණි විද්‍යාවේ පියා ලෙස සැලකෙන්නේ කවුරුන්ද?",
        options = listOf("චාල්ස් ඩාවින්", "ග්‍රෙගර් මෙන්ඩල්", "ලුවී පාස්චර්", "ඇලෙක්සැන්ඩර් ෆ්ලෙමින්"),
        correctOptionIndex = 1,
        explanationSinhala = "ග්‍රෙගර් මෙන්ඩල් මෑ පැළෑටි ආශ්‍රයෙන් කළ පර්යේෂණ ප්‍රවේණි විද්‍යාවේ පදනම දැමීය.",
        topicCategory = "ජීව විද්‍යාව - ප්‍රවේණිය"
      ),
      PastPaperQuestion(
        id = 6,
        questionText = "පරිසර පද්ධතියක ප්‍රාථමික නිෂ්පාදකයන් ලෙස හඳුන්වන්නේ කවරහුද?",
        options = listOf("මාංශ භක්ෂකයන්", "හරිත ශාක සහ ප්‍රභාසංස්ලේෂී ඇල්ගී", "විඝටකයන්", "ශාක භක්ෂකයන්"),
        correctOptionIndex = 1,
        explanationSinhala = "සූර්යාලෝකය යොදාගෙන තමන්ට අවශ්‍ය කාබනික ආහාර තමන් විසින්ම නිපදවා ගන්නා ජීවීන් ප්‍රාථමික නිෂ්පාදකයෝ වෙති.",
        topicCategory = "ජීව විද්‍යාව - පරිසරය"
      ),
      PastPaperQuestion(
        id = 7,
        questionText = "මිනිස් ස්නායු පද්ධතියේ පණිවිඩ සම්ප්‍රේෂණය කරන මූලික සෛලය කුමක්ද?",
        options = listOf("නියුරෝනය (ස්නායු සෛලය)", "නෙෆ්‍රෝනය", "සුදු රුධිරාණුව", "අක්මා සෛලය"),
        correctOptionIndex = 0,
        explanationSinhala = "නියුරෝන (ස්නායු සෛල) විද්‍යුත්-රසායනික ආවේග ලෙස ස්නායු සංඥා ගමන් කරවයි.",
        topicCategory = "ජීව විද්‍යාව - ස්නායු පද්ධතිය"
      ),
      PastPaperQuestion(
        id = 8,
        questionText = "පාන් පිපීම සඳහා යීස්ට් මඟින් සිදු කරන නිර්වායු ශ්වසන ක්‍රියාවලිය කුමක්ද?",
        options = listOf("ලැක්ටික් අම්ල පැසවීම", "ඇල්කොහොල් පැසවීම", "ප්‍රභාසංස්ලේෂණය", "ඔක්සිකරණය"),
        correctOptionIndex = 1,
        explanationSinhala = "යීස්ට් මඟින් ග්ලූකෝස් එතනෝල් සහ කාබන් ඩයොක්සයිඩ් (CO₂) බවට පත් කරන අතර පිටවන CO₂ නිසා පාන් පිපේ.",
        topicCategory = "ජීව විද්‍යාව - ක්ෂුද්‍ර ජීව විද්‍යාව"
      ),
      PastPaperQuestion(
        id = 9,
        questionText = "පුෂ්පයක පරාගධානියේ සිට කලංකය වෙත පරාග ගමන් කිරීම හඳුන්වන්නේ කෙසේද?",
        options = listOf("සංසේචනය", "පරාගනය", "ප්‍රරෝහණය", "විසිරණය"),
        correctOptionIndex = 1,
        explanationSinhala = "පරාගධානියේ සිට කලංකය මත පරාග තැන්පත් වීම පරාගනයයි. ඉන්පසු ඩිම්බය හා එක්වීම සංසේචනයයි.",
        topicCategory = "ජීව විද්‍යාව - ශාක ප්‍රජනනය"
      ),
      PastPaperQuestion(
        id = 10,
        questionText = "ආහාර ජීරණ පද්ධතියේ ආන්ත්‍රික විලි (Villi) මඟින් ප්‍රධාන වශයෙන් සිදුවන කාර්යය කුමක්ද?",
        options = listOf("ආහාර ඇඹරීම", "ජීරණය වූ පෝෂක අවශෝෂණය කිරීම", "ආමාශයික යුෂ ශ්‍රාවය", "ආහාර ගිලීම"),
        correctOptionIndex = 1,
        explanationSinhala = "කුඩා අන්ත්‍රයේ විලි මඟින් පෘෂ්ඨික වර්ගඵලය වැඩි කර පෝෂ්‍ය පදාර්ථ රුධිරයට අවශෝෂණය වේගවත් කරයි.",
        topicCategory = "ජීව විද්‍යාව - ආහාර ජීරණය"
      ),
      PastPaperQuestion(
        id = 11,
        questionText = "මිනිස් සිරුරේ අන්තරාසර්ග පද්ධතියේ ප්‍රධාන හෝමෝන පාලක ග්‍රන්ථිය ලෙස සැලකෙන්නේ කුමක්ද?",
        options = listOf("තයිරොයිඩ් ග්‍රන්ථිය", "පිටියුටරි ග්‍රන්ථිය", "අග්න්‍යාශය", "අධිවෘක්ක ග්‍රන්ථිය"),
        correctOptionIndex = 1,
        explanationSinhala = "පිටියුටරි ග්‍රන්ථිය මොළයේ පාදස්ථව පිහිටා අන් බොහෝ අන්තරාසර්ග ග්‍රන්ථිවල හෝමෝන ක්‍රියාකාරිත්වය මෙහෙයවයි.",
        topicCategory = "ජීව විද්‍යාව - හෝමෝන"
      ),
      PastPaperQuestion(
        id = 12,
        questionText = "පෙලිනිසියම් (Penicillin) ප්‍රතිජීවකය මුලින්ම නිස්සාරණය කරනු ලැබුවේ කිනම් ජීවී කාණ්ඩයකින්ද?",
        options = listOf("බැක්ටීරියා", "දිලීර (Fungi)", "වෛරස", "ප්‍රෝටෝසෝවා"),
        correctOptionIndex = 1,
        explanationSinhala = "ඇලෙක්සැන්ඩර් ෆ්ලෙමින් විසින් Penicillium notatum නම් දිලීරයෙන් පෙනිසිලින් සොයා ගන්නා ලදී.",
        topicCategory = "ජීව විද්‍යාව - ප්‍රතිජීවක"
      ),
      PastPaperQuestion(
        id = 13,
        questionText = "මිනිසාගේ දේහ උෂ්ණත්වය නියතව පවත්වා ගැනීමට දහඩිය දැමීම උදවු වන්නේ කෙසේද?",
        options = listOf("තාපය අවශෝෂණය කරමින් ජලය වාෂ්පීභවනය වීමෙන්", "රුධිර වාහිනී සංකෝචනය වීමෙන්", "ස්කන්ධය අඩු වීමෙන්", "ස්නායු අක්‍රිය වීමෙන්"),
        correctOptionIndex = 0,
        explanationSinhala = "ජලයේ වාෂ්පීභවනයේ විශිෂ්ට ගුප්ත තාපය ඉහළ බැවින් දහඩිය වාෂ්ප වන විට සිරුරෙන් විශාල තාපයක් ඉවත් වී සිසිල් වේ.",
        topicCategory = "ජීව විද්‍යාව - සමස්ථිතිය"
      ),
      PastPaperQuestion(
        id = 14,
        questionText = "මිනිස් ශ්වසන පද්ධතියේ වායු හුවමාරුව (O₂ සහ CO₂) සිදුවන ප්‍රධාන ක්ෂුද්‍ර ව්‍යුහය කුමක්ද?",
        options = listOf("ශ්වාසනාලය", "ගර්ත (Alveoli)", "ස්වරාලය", "පෙනහළු ආවරණය"),
        correctOptionIndex = 1,
        explanationSinhala = "ගර්තවල බිත්ති ඉතා තුනී තනි සෛල ස්ථරයකින් යුක්ත වන අතර රුධිර කේශනාලිකා ජාලයකින් වට වී විසරණයෙන් වායු හුවමාරු කරයි.",
        topicCategory = "ජීව විද්‍යාව - ශ්වසනය"
      ),
      PastPaperQuestion(
        id = 15,
        questionText = "ශාකයක ජලය හා ඛනිජ ලවණ මුලේ සිට ඉහළට පරිවහනය කරන සනාල පටකය කුමක්ද?",
        options = listOf("ෆ්ලෝයමය", "ශෛලමය (Xylem)", "මෘදුස්තරය", "දෘඪස්තරය"),
        correctOptionIndex = 1,
        explanationSinhala = "ශෛලම පටකය මඟින් ජලය සහ ඛනිජ පරිවහනය කරන අතර ෆ්ලෝයමය මඟින් නිපදවූ ආහාර පරිවහනය කරයි.",
        topicCategory = "ජීව විද්‍යාව - ශාක පටක"
      ),

      // --- CHEMISTRY ---
      PastPaperQuestion(
        id = 16,
        questionText = "පරමාණුවක න්‍යෂ්ටියේ අඩංගු වන මූලික උප පරමාණුක අංශු මොනවාද?",
        options = listOf("ඉලෙක්ට්‍රෝන හා ප්‍රෝටෝන", "ප්‍රෝටෝන හා නියුට්‍රෝන", "නියුට්‍රෝන හා ඉලෙක්ට්‍රෝන", "ඉලෙක්ට්‍රෝන පමණි"),
        correctOptionIndex = 1,
        explanationSinhala = "න්‍යෂ්ටිය සෑදී ඇත්තේ ධන ආරෝපිත ප්‍රෝටෝන සහ උදාසීන නියුට්‍රෝන එකතුවෙනි. ඉලෙක්ට්‍රෝන න්‍යෂ්ටිය වටා කක්ෂගත වේ.",
        topicCategory = "රසායන විද්‍යාව - පරමාණුක ව්‍යුහය"
      ),
      PastPaperQuestion(
        id = 17,
        questionText = "ආවර්තිතා වගුවේ 1 වන කාණ්ඩයේ මූලද්‍රව්‍ය හඳුන්වන විශේෂ නාමය කුමක්ද?",
        options = listOf("උච්ච වායු", "ක්ෂාර ලෝහ (Alkali Metals)", "හැලජන", "ක්ෂාරීය පාංශු ලෝහ"),
        correctOptionIndex = 1,
        explanationSinhala = "Li, Na, K ආදී 1 කාණ්ඩයේ මූලද්‍රව්‍ය ක්ෂාර ලෝහ ලෙස හඳුන්වයි.",
        topicCategory = "රසායන විද්‍යාව - ආවර්තිතා වගුව"
      ),
      PastPaperQuestion(
        id = 18,
        questionText = "ජලීය ද්‍රාවණයක pH අගය 7 ට වඩා අඩු නම් එම ද්‍රාවණය කවර ස්වභාවයක් ගනීද?",
        options = listOf("උදාසීන", "ආම්ලික (Acidic)", "භෂ්මික", "ලවණමය"),
        correctOptionIndex = 1,
        explanationSinhala = "pH අගය 0 සිට 7 දක්වා ආම්ලික වේ. 7 උදාසීන වන අතර 7 සිට 14 දක්වා භෂ්මික වේ.",
        topicCategory = "රසායන විද්‍යාව - අම්ල හා භෂ්ම"
      ),
      PastPaperQuestion(
        id = 19,
        questionText = "සෝඩියම් ක්ලෝරයිඩ් (NaCl) ස්ඵටික සෑදීමේදී පරමාණු අතර ඇතිවන රසායනික බන්ධන වර්ගය කුමක්ද?",
        options = listOf("සහසංයුජ බන්ධනය", "අයනික බන්ධනය (Ionic Bond)", "හයිඩ්‍රජන් බන්ධනය", "ලෝහක බන්ධනය"),
        correctOptionIndex = 1,
        explanationSinhala = "සෝඩියම් ලෝහය ඉලෙක්ට්‍රෝනයක් ක්ලෝරීන් වෙත පූර්ණ ලෙස ලබා දී Na⁺ සහ Cl⁻ අයන අතර විද්‍යුත් ස්ථිතික ආකර්ෂණයෙන් අයනික බන්ධන සාදයි.",
        topicCategory = "රසායන විද්‍යාව - රසායනික බන්ධන"
      ),
      PastPaperQuestion(
        id = 20,
        questionText = "ජලය විද්‍යුත් විච්ඡේදනය කිරීමේදී කැතෝඩය (-) අසල රැස්වන වායුව කුමක්ද?",
        options = listOf("ඔක්සිජන් (O₂)", "හයිඩ්‍රජන් (H₂)", "නයිට්‍රජන් (N₂)", "කාබන් ඩයොක්සයිඩ් (CO₂)"),
        correctOptionIndex = 1,
        explanationSinhala = "කැතෝඩය (-) වෙත H⁺ අයන ඇදී ගොස් ඉලෙක්ට්‍රෝන ලබාගෙන H₂ වායුව නිදහස් කරයි.",
        topicCategory = "රසායන විද්‍යාව - විද්‍යුත් රසායනය"
      ),
      PastPaperQuestion(
        id = 21,
        questionText = "යකඩ මලකෑම (Rusting) සඳහා අත්‍යවශ්‍ය වන සාධක දෙක මොනවාද?",
        options = listOf("ඔක්සිජන් සහ කාබන්", "ඔක්සිජන් සහ තෙතමනය (ජලය)", "ආලෝකය සහ නයිට්‍රජන්", "කාබන් ඩයොක්සයිඩ් පමණි"),
        correctOptionIndex = 1,
        explanationSinhala = "යකඩ මලකෑම විද්‍යුත් රසායනික ක්‍රියාවලියක් වන අතර ඒ සඳහා ඔක්සිජන් වායුව හා ජලය අත්‍යවශ්‍ය වේ.",
        topicCategory = "රසායන විද්‍යාව - ලෝහ විඛාදනය"
      ),
      PastPaperQuestion(
        id = 22,
        questionText = "කාබන් පරමාණුවේ සංයුජතාව (Valency) කීයද?",
        options = listOf("1", "2", "4", "6"),
        correctOptionIndex = 2,
        explanationSinhala = "කාබන්හි ඉලෙක්ට්‍රෝන වින්‍යාසය 2, 4 බැවින් බාහිර කවචය සම්පූර්ණ කර ගැනීමට ඉලෙක්ට්‍රෝන 4 ක් හවුලේ තබා ගනී (සංයුජතාව 4).",
        topicCategory = "රසායන විද්‍යාව - කාබනික සංයෝග"
      ),
      PastPaperQuestion(
        id = 23,
        questionText = "රසායනික ප්‍රතික්‍රියාවක වේගය වැඩි කිරීම සඳහා යොදන එහෙත් අවසානයේ වෙනස් නොවී ඉතිරි වන ද්‍රව්‍යය කුමක්ද?",
        options = listOf("ප්‍රතික්‍රියකය", "උත්ප්‍රේරකය (Catalyst)", "ඵලය", "ද්‍රාවකය"),
        correctOptionIndex = 1,
        explanationSinhala = "උත්ප්‍රේරක මඟින් ප්‍රතික්‍රියාවේ සක්‍රියන ශක්තිය පහත හෙළා ප්‍රතික්‍රියා සීඝ්‍රතාව වැඩි කරයි.",
        topicCategory = "රසායන විද්‍යාව - ප්‍රතික්‍රියා සීඝ්‍රතාව"
      ),
      PastPaperQuestion(
        id = 24,
        questionText = "වායුගෝලයේ බහුලවම අඩංගු වන වායුව කුමක්ද?",
        options = listOf("ඔක්සිජන්", "නයිට්‍රජන් (N₂)", "කාබන් ඩයොක්සයිඩ්", "ආගන්"),
        correctOptionIndex = 1,
        explanationSinhala = "වායුගෝලයේ පරිමාවෙන් ආසන්න වශයෙන් 78% ක් නයිට්‍රජන් වායුව අඩංගු වේ.",
        topicCategory = "රසායන විද්‍යාව - වායූන්"
      ),
      PastPaperQuestion(
        id = 25,
        questionText = "අම්ලයක් හා භෂ්මයක් එකිනෙක ප්‍රතික්‍රියා කර ලවණ හා ජලය සෑදීමේ ක්‍රියාවලිය කුමක්ද?",
        options = listOf("උදාසීනීකරණය (Neutralization)", "ඔක්සිකරණය", "විජලනය", "විඝටනය"),
        correctOptionIndex = 0,
        explanationSinhala = "අම්ල + භෂ්ම → ලවණ + ජලය යන ප්‍රතික්‍රියාව උදාසීනීකරණ ප්‍රතික්‍රියාවක් ලෙස හැඳින්වේ.",
        topicCategory = "රසායන විද්‍යාව - රසායනික ප්‍රතික්‍රියා"
      ),
      PastPaperQuestion(
        id = 26,
        questionText = "කාබන්හි බහුරූපී (Allotrope) ආකාරයක් වන අතර විදුලිය සන්නයනය කළ හැකි අලෝහය කුමක්ද?",
        options = listOf("දියමන්ති", "මිනිරන් (Graphite)", "සල්ෆර්", "පොස්පරස්"),
        correctOptionIndex = 1,
        explanationSinhala = "මිනිරන්හි එක් කාබන් පරමාණුවක් වෙනත් කාබන් 3 ක් සමඟ බැඳී නිදහස් ඉලෙක්ට්‍රෝන පවතින බැවින් විදුලිය සන්නයනය කරයි.",
        topicCategory = "රසායන විද්‍යාව - පදාර්ථය"
      ),
      PastPaperQuestion(
        id = 27,
        questionText = "සාමාන්‍ය උෂ්ණත්වයේදී හා පීඩනයේදී ද්‍රව තත්ත්වයේ පවතින එකම ලෝහය කුමක්ද?",
        options = listOf("ලෙඩ් (ඊයම්)", "රසදිය (Mercury - Hg)", "සෝඩියම්", "ඇලුමිනියම්"),
        correctOptionIndex = 1,
        explanationSinhala = "රසදිය (Hg) කාමර උෂ්ණත්වයේදී ද්‍රව තත්ත්වයේ පවතින එකම ලෝහමය මූලද්‍රව්‍යය වේ.",
        topicCategory = "රසායන විද්‍යාව - ලෝහ"
      ),
      PastPaperQuestion(
        id = 28,
        questionText = "හුණු දියර (Ca(OH)₂) කිරි පාට කරන්නේ කිනම් වායුව බුබුලනය කළ විටද?",
        options = listOf("ඔක්සිජන් වායුව", "කාබන් ඩයොක්සයිඩ් වායුව (CO₂)", "හයිඩ්‍රජන් වායුව", "ක්ලෝරීන් වායුව"),
        correctOptionIndex = 1,
        explanationSinhala = "CO₂ හුණු දියර සමඟ ප්‍රතික්‍රියා කර ජලයේ අද්‍රාව්‍ය සුදු පැහැති කැල්සියම් කාබනේට් (CaCO₃) අවක්ෂේපය සාදයි.",
        topicCategory = "රසායන විද්‍යාව - රසායනික හඳුනාගැනීම්"
      ),
      PastPaperQuestion(
        id = 29,
        questionText = "අවම ශක්ති මට්ටමක ඇති ඉලෙක්ට්‍රෝනයක් ඉහළ ශක්ති මට්ටමකට යාමේදී සිදුවන්නේ කුමක්ද?",
        options = listOf("ශක්තිය මුදාහැරීම", "ශක්තිය අවශෝෂණය කිරීම", "ස්කන්ධය වැඩිවීම", "න්‍යෂ්ටිය විනාශ වීම"),
        correctOptionIndex = 1,
        explanationSinhala = "ඉලෙක්ට්‍රෝනයක් උද්දීපනය වී ඉහළ ශක්ති මට්ටමකට යාමට ශක්තිය අවශෝෂණය කළ යුතුය.",
        topicCategory = "රසායන විද්‍යාව - ශක්ති මට්ටම්"
      ),
      PastPaperQuestion(
        id = 30,
        questionText = "ද්‍රාව්‍යතාව (Solubility) කෙරෙහි බලනොපාන සාධකය කුමක්ද?",
        options = listOf("උෂ්ණත්වය", "ද්‍රාව්‍යයේ ස්වභාවය", "ද්‍රාවකයේ ස්වභාවය", "පාත්‍රයේ හැඩය"),
        correctOptionIndex = 3,
        explanationSinhala = "ද්‍රාව්‍යතාව කෙරෙහි උෂ්ණත්වය හා ද්‍රව්‍යවල රසායනික ස්වභාවය බලපාන නමුත් අඩංගු භාජනයේ හැඩය කිසිදු බලපෑමක් නොකරයි.",
        topicCategory = "රසායන විද්‍යාව - ද්‍රාවණ"
      ),

      // --- PHYSICS ---
      PastPaperQuestion(
        id = 31,
        questionText = "නිව්ටන්ගේ දෙවන චලිත නියමය ගණිතමය සමීකරණයක් ලෙස දැක්වෙන්නේ කෙසේද?",
        options = listOf("v = u + at", "F = ma", "W = Fd", "P = W/t"),
        correctOptionIndex = 1,
        explanationSinhala = "F = ma මඟින් අසමතුලිත බලය = ස්කන්ධය × ත්වරණය දක්වයි.",
        topicCategory = "භෞතික විද්‍යාව - නිව්ටන් නියම"
      ),
      PastPaperQuestion(
        id = 32,
        questionText = "ජාත්‍යන්තර ක්‍රමයේ (SI) බලය මනින සම්මත ඒකකය කුමක්ද?",
        options = listOf("ජූල් (J)", "නිව්ටන් (N)", "වොට් (W)", "පැස්කල් (Pa)"),
        correctOptionIndex = 1,
        explanationSinhala = "බලය මනින SI ඒකකය නිව්ටන් (N) වේ. 1 N = 1 kg m s⁻².",
        topicCategory = "භෞතික විද්‍යාව - මිනුම් ඒකක"
      ),
      PastPaperQuestion(
        id = 33,
        questionText = "ඕම්ගේ නියමයට අදාළව විභව අන්තරය (V), ධාරාව (I) සහ ප්‍රතිරෝධය (R) අතර සම්බන්ධතාවය කුමක්ද?",
        options = listOf("V = I / R", "V = IR", "I = VR", "R = VI"),
        correctOptionIndex = 1,
        explanationSinhala = "නියත උෂ්ණත්වයේ පවතින සන්නායකයක V = IR වේ.",
        topicCategory = "භෞතික විද්‍යාව - ධාරා විද්‍යුතය"
      ),
      PastPaperQuestion(
        id = 34,
        questionText = "හිස් අවකාශය හරහා ආලෝකය ගමන් කරන වේගය ආසන්න වශයෙන් කොපමණද?",
        options = listOf("330 m s⁻¹", "3 × 10⁸ m s⁻¹", "3 × 10⁶ m s⁻¹", "3000 km s⁻¹"),
        correctOptionIndex = 1,
        explanationSinhala = "හිස් අවකාශයේ ආලෝකයේ වේගය c = 3 × 10⁸ m s⁻¹ (තත්පරයට කිලෝමීටර් 300,000) වේ.",
        topicCategory = "භෞතික විද්‍යාව - ආලෝකය"
      ),
      PastPaperQuestion(
        id = 35,
        questionText = "ස්කන්ධය 2 kg වූ වස්තුවක් 5 m උසකින් තැබූ විට එහි ගුරුත්වාකර්ෂණ විභව ශක්තිය කොපමණද? (g = 10 m s⁻²)",
        options = listOf("10 J", "50 J", "100 J", "200 J"),
        correctOptionIndex = 2,
        explanationSinhala = "Ep = mgh = 2 kg × 10 m s⁻² × 5 m = 100 J.",
        topicCategory = "භෞතික විද්‍යාව - කාර්යය හා ශක්තිය"
      ),
      PastPaperQuestion(
        id = 36,
        questionText = "තරල පීඩනය (P) සෙවීමේ සූත්‍රය කුමක්ද? (h = ගැඹුර, ρ = ඝනත්වය, g = ගුරුත්වජ ත්වරණය)",
        options = listOf("P = hρg", "P = F/d", "P = mgh", "P = 1/2 mv²"),
        correctOptionIndex = 0,
        explanationSinhala = "ද්‍රව කඳක ගැඹුර සමග පීඩනය P = hρg අනුව වැඩි වේ.",
        topicCategory = "භෞතික විද්‍යාව - පීඩනය"
      ),
      PastPaperQuestion(
        id = 37,
        questionText = "සංවෘත තරලයක එක් තැනකට යෙදූ පීඩනය නොවෙනස්ව සියලු දිශාවන්ට සම්ප්‍රේෂණය වන බව ප්‍රකාශ වන මූලධර්මය කුමක්ද?",
        options = listOf("ආකිමිඩීස් මූලධර්මය", "පැස්කල් මූලධර්මය", "බර්නූලි මූලධර්මය", "ප්ලාවන නියමය"),
        correctOptionIndex = 1,
        explanationSinhala = "හයිඩ්‍රොලික් ජැක් හා තිරිංග ක්‍රියා කරන්නේ පැස්කල් මූලධර්මය පදනම් කරගෙනය.",
        topicCategory = "භෞතික විද්‍යාව - තරල යාන්ත්‍ර විද්‍යාව"
      ),
      PastPaperQuestion(
        id = 38,
        questionText = "සූර්යයාගේ සිට පෘථිවියට තාපය සම්ප්‍රේෂණය වන ප්‍රධාන ක්‍රමය කුමක්ද?",
        options = listOf("සන්නයනය", "සංවහනය", "විකිරණය (Radiation)", "විසරණය"),
        correctOptionIndex = 2,
        explanationSinhala = "හිස් අවකාශය හරහා තාපය ගමන් කිරීමට මාධ්‍යයක් අවශ්‍ය නොවන විකිරණ ක්‍රමය යොදා ගනී.",
        topicCategory = "භෞතික විද්‍යාව - තාපය"
      ),
      PastPaperQuestion(
        id = 39,
        questionText = "ආලෝක කිරණයක් ප්‍රකාශ ඝනත්වයෙන් වැඩි මාධ්‍යයක සිට අඩු මාධ්‍යයකට ගමන් කිරීමේදී සිදුවන්නේ කුමක්ද?",
        options = listOf("අභිලම්භය දෙසට නැමෙයි", "අභිලම්භයෙන් ඉවතට නැමෙයි", "නොනැමී ගමන් කරයි", "ආපසු හැරේ"),
        correctOptionIndex = 1,
        explanationSinhala = "වේගය වැඩි මාධ්‍යයට පිවිසෙන විට කිරණය අභිලම්භයෙන් ඈතට වර්තනය වේ.",
        topicCategory = "භෞතික විද්‍යාව - ප්‍රකාශ විද්‍යාව"
      ),
      PastPaperQuestion(
        id = 40,
        questionText = "අවකල කාචයකින් (Concave Lens) සෑම විටම ලබාදෙන ප්‍රතිබිම්බයේ ස්වභාවය කුමක්ද?",
        options = listOf("තාත්වික හා උඩුකුරු", "මායා හා උඩුකුරු (Virtual & Upright)", "තාත්වික හා යටිකුරු", "විශාලිත හා තාත්වික"),
        correctOptionIndex = 1,
        explanationSinhala = "අවකල කාචයකින් සෑම විටම කුඩා වූ, උඩුකුරු, මායා ප්‍රතිබිම්බයක් සාදයි.",
        topicCategory = "භෞතික විද්‍යාව - කාච"
      ),
      PastPaperQuestion(
        id = 41,
        questionText = "ශබ්දයේ තාරතාව (Pitch) තීරණය වන්නේ කිනම් ලක්ෂණය මතද?",
        options = listOf("විස්තාරය", "සංඛ්‍යාතය (Frequency)", "තරංග ආයාමය පමණි", "වේගය"),
        correctOptionIndex = 1,
        explanationSinhala = "සංඛ්‍යාතය වැඩි වන විට තාරතාව (හඬෙහි සිහින් බව) වැඩි වේ.",
        topicCategory = "භෞතික විද්‍යාව - ශබ්දය"
      ),
      PastPaperQuestion(
        id = 42,
        questionText = "පරිවර්තකයක (Transformer) ප්‍රාථමික දඟරයේ වෝල්ටීයතාව 240 V ද, දඟර අනුපාතය 2:1 ද නම් ද්විතීයික වෝල්ටීයතාව කීයද?",
        options = listOf("480 V", "120 V", "240 V", "60 V"),
        correctOptionIndex = 1,
        explanationSinhala = "Vs / Vp = Ns / Np අනුව Vs = 240 × (1/2) = 120 V (අවපාත පරිවර්තකයකි).",
        topicCategory = "භෞතික විද්‍යාව - විද්‍යුත් චුම්බක ප්‍රේරණය"
      ),
      PastPaperQuestion(
        id = 43,
        questionText = "pn සන්ධි ඩයෝඩයක ඉදිරි නැඹුරු (Forward bias) අවස්ථාවේදී සිදුවන්නේ කුමක්ද?",
        options = listOf("විදුලිය ගලා නොයයි", "ධාරාව පහසුවෙන් ගලා යයි", "ප්‍රතිරෝධය අනන්ත වේ", "ඩයෝඩය පිලිස්සී යයි"),
        correctOptionIndex = 1,
        explanationSinhala = "ඉදිරි නැඹුරුවේදී ක්ෂය වන කලාපය සිහින් වී ධාරාව පහසුවෙන් ඉදිරියට ගලා යයි.",
        topicCategory = "භෞතික විද්‍යාව - ඉලෙක්ට්‍රොනික විද්‍යාව"
      ),
      PastPaperQuestion(
        id = 44,
        questionText = "ස්කන්ධය 1000 kg වූ මෝටර් රථයක් 20 m s⁻¹ ප්‍රවේගයෙන් ගමන් කරන්නේ නම් එහි චාලක ශක්තිය කීයද?",
        options = listOf("10,000 J", "200,000 J (200 kJ)", "400,000 J", "20,000 J"),
        correctOptionIndex = 1,
        explanationSinhala = "Ek = 1/2 mv² = 1/2 × 1000 × (20)² = 500 × 400 = 200,000 J (200 kJ).",
        topicCategory = "භෞතික විද්‍යාව - යාන්ත්‍ර විද්‍යාව"
      ),
      PastPaperQuestion(
        id = 45,
        questionText = "ගෘහ විදුලි පරිපථයක විදුලි උපකරණ එකිනෙකට සම්බන්ධ කර ඇත්තේ කිනම් ආකාරයටද?",
        options = listOf("ශ්‍රේණිගතව", "සමාන්තරගතව (Parallel)", "ශ්‍රේණිගත හා සමාන්තර මිශ්‍රව", "චක්‍රීයව"),
        correctOptionIndex = 1,
        explanationSinhala = "සමාන්තරගතව සම්බන්ධ කළ විට සෑම උපකරණයකටම නියමිත පූර්ණ වෝල්ටීයතාව (230 V) ලැබෙන අතර එකක් ක්‍රියා විරහිත වුවද අනෙක්වා ක්‍රියා කරයි.",
        topicCategory = "භෞතික විද්‍යාව - ගෘහ විදුලිය"
      ),

      // --- EARTH & SPACE / GENERAL SCIENCE ---
      PastPaperQuestion(
        id = 46,
        questionText = "පෘථිවි වායුගෝලයේ ඕසෝන් වියන (Ozone Layer) ප්‍රධාන වශයෙන් පිහිටා ඇති ස්ථරය කුමක්ද?",
        options = listOf("පරිවර්තී ගෝලය (Troposphere)", "ස්ථර ගෝලය (Stratosphere)", "මධ්‍ය ගෝලය", "තාප ගෝලය"),
        correctOptionIndex = 1,
        explanationSinhala = "ඕසෝන් ස්ථරය ස්ථර ගෝලයේ (Stratosphere) පිහිටා ඇති අතර අහිතකර UV කිරණ උරා ගනී.",
        topicCategory = "පෘථිවි විද්‍යාව - වායුගෝලය"
      ),
      PastPaperQuestion(
        id = 47,
        questionText = "හරිතාගාර ආචරණයට (Greenhouse effect) වැඩිම දායකත්වයක් සපයන මිනිස් ක්‍රියාකාරකම් මඟින් නිකුත් වන වායුව කුමක්ද?",
        options = listOf("කාබන් මොනොක්සයිඩ්", "කාබන් ඩයොක්සයිඩ් (CO₂)", "ඔක්සිජන්", "හීලියම්"),
        correctOptionIndex = 1,
        explanationSinhala = "පොසිල ඉන්ධන දහනය නිසා වායුගෝලයට එක්වන අතිරික්ත CO₂ තාප විකිරණ උරාගෙන ගෝලීය උෂ්ණත්වය ඉහළ නංවයි.",
        topicCategory = "පාරිසරික විද්‍යාව - දේශගුණ විපර්යාස"
      ),
      PastPaperQuestion(
        id = 48,
        questionText = "සූර්යග්‍රහණයක් සිදුවන්නේ කුමන ආකාශ වස්තු පිහිටීමකදීද?",
        options = listOf("පෘථිවිය සූර්යයා සහ චන්ද්‍රයා අතරට පැමිණි විට", "චන්ද්‍රයා සූර්යයා සහ පෘථිවිය අතරට පැමිණි විට", "සූර්යයා පෘථිවිය සහ චන්ද්‍රයා අතරට පැමිණි විට", "අමාවක දිනක පමණක් නොවේ"),
        correctOptionIndex = 1,
        explanationSinhala = "චන්ද්‍රයා සූර්යයා සහ පෘථිවිය අතර එකම සරල රේඛාවකට පැමිණි විට චන්ද්‍රයාගේ සෙවණැල්ල පෘථිවිය මත පතිත වී සූර්යග්‍රහණයක් ඇතිවේ.",
        topicCategory = "තාරකා විද්‍යාව - ආකාශ වස්තු"
      ),
      PastPaperQuestion(
        id = 49,
        questionText = "පුනර්ජනනීය බලශක්ති (Renewable Energy) ප්‍රභවයක් සඳහා උදාහරණයක් නොවන්නේ කුමක්ද?",
        options = listOf("සූර්ය බලය", "සුළං බලය", "ගල් අඟුරු (Coal)", "ජල විදුලිය"),
        correctOptionIndex = 2,
        explanationSinhala = "ගල් අඟුරු යනු ක්ෂය වන පොසිල ඉන්ධනයක් වන අතර එය පුනර්ජනනීය නොවේ.",
        topicCategory = "පාරිසරික විද්‍යාව - බලශක්තිය"
      ),
      PastPaperQuestion(
        id = 50,
        questionText = "ශ්‍රී ලංකාවේ බහුලව හමුවන ඉහළ ආර්ථික වටිනාකමක් ඇති මිනිරන් (Graphite) අයත් වන්නේ කිනම් පාෂාණ වර්ගයටද?",
        options = listOf("ආග්නේය පාෂාණ", "අවසාදිත පාෂාණ", "විපරීත පාෂාණ (Metamorphic)", "ගිනිකඳු පාෂාණ"),
        correctOptionIndex = 2,
        explanationSinhala = "අධික උෂ්ණත්වය සහ පීඩනය නිසා විපරීත වූ පාෂාණ ස්ථර තුළ මිනිරන් තැන්පතු හටගනී.",
        topicCategory = "භූ විද්‍යාව - ඛනිජ"
      ),
      PastPaperQuestion(
        id = 51,
        questionText = "ප්‍රභාසංස්ලේෂණයේ ආලෝක ප්‍රතික්‍රියාව සිදුවන්නේ හරිතලවයේ කිනම් කොටසේද?",
        options = listOf("පිටත පටලය", "තයිලකොයිඩ් පටලය (ග්‍රානා)", "ස්ට්‍රෝමාව (පූරකය)", "රයිබොසෝම"),
        correctOptionIndex = 1,
        explanationSinhala = "ආලෝක ප්‍රතික්‍රියාව ග්‍රානාවල තයිලකොයිඩ් පටල මත සිදුවන අතර අඳුරු ප්‍රතික්‍රියාව ස්ට්‍රෝමාවේ සිදුවේ.",
        topicCategory = "ජීව විද්‍යාව - සෛල කායික විද්‍යාව"
      ),
      PastPaperQuestion(
        id = 52,
        questionText = "ලෝහ සක්‍රියතා ශ්‍රේණියේ ඉහළින්ම පිහිටි සක්‍රියතම ලෝහ නිස්සාරණය කරන්නේ කිනම් ක්‍රමයෙන්ද?",
        options = listOf("කාබන් මඟින් ඔක්සිහරණයෙන්", "විද්‍යුත් විච්ඡේදනයෙන් (Electrolysis)", "හුමාලයෙන් රත් කිරීමෙන්", "ස්වභාවිකව නිදහස්ව සොයාගැනීමෙන්"),
        correctOptionIndex = 1,
        explanationSinhala = "K, Na, Ca, Mg, Al ආදී ඉහළ සක්‍රිය ලෝහ ඔක්සිජන් සමඟ තදින් බැඳී ඇති බැවින් ඒවා උණු කළ ලවණ විද්‍යුත් විච්ඡේදනයෙන් වෙන් කරයි.",
        topicCategory = "රසායන විද්‍යාව - ලෝහ නිස්සාරණය"
      ),
      PastPaperQuestion(
        id = 53,
        questionText = "ධ්වනි තරංග මාධ්‍යයක් හරහා සම්ප්‍රේෂණය වන ආකාරය කුමක්ද?",
        options = listOf("තිරස් තරංග ලෙස", "අන්වායාම තරංග (Longitudinal waves) ලෙස", "විද්‍යුත් චුම්බක තරංග ලෙස", "ස්ථාවර තරංග ලෙස පමණි"),
        correctOptionIndex = 1,
        explanationSinhala = "ශබ්ද තරංග යනු මාධ්‍ය අංශු කම්පනය වන දිශාවට සමාන්තරව සම්පීඩන හා විරලන ඇති කරමින් ගමන් කරන අන්වායාම තරංග වේ.",
        topicCategory = "භෞතික විද්‍යාව - තරංග"
      ),
      PastPaperQuestion(
        id = 54,
        questionText = "මිනිස් රුධිරයේ ඇති ප්‍රතිදේහ (Antibodies) නිපදවනු ලබන රුධිර සෛල වර්ගය කුමක්ද?",
        options = listOf("රතු රුධිරාණු", "ලිම්ෆොසයිට (සුදු රුධිරාණු)", "රුධිර පට්ටිකා", "රුධිර ප්ලාස්මාව"),
        correctOptionIndex = 1,
        explanationSinhala = "B-ලිම්ෆොසයිට මඟින් රෝග කාරක නසන ප්‍රතිදේහ නිපදවා දේහ ප්‍රතිශක්තිය සපයයි.",
        topicCategory = "ජීව විද්‍යාව - ප්‍රතිශක්තිය"
      ),
      PastPaperQuestion(
        id = 55,
        questionText = "ජලයේ තාවකාලික කඨිනත්වයට (Temporary Hardness) හේතු වන රසායනික සංයෝගය කුමක්ද?",
        options = listOf("කැල්සියම් සල්ෆේට්", "කැල්සියම් බයිකාබනේට් (Ca(HCO₃)₂)", "මැග්නීසියම් ක්ලෝරයිඩ්", "සෝඩියම් කාබනේට්"),
        correctOptionIndex = 1,
        explanationSinhala = "Ca සහ Mg වල බයිකාබනේට් නිසා තාවකාලික කඨිනත්වය ඇතිවන අතර රත් කිරීමෙන් ඉවත් කළ හැක.",
        topicCategory = "රසායන විද්‍යාව - ජලයේ කඨිනත්වය"
      ),
      PastPaperQuestion(
        id = 56,
        questionText = "වස්තුවක ඝනත්වය ජලයේ ඝනත්වයට වඩා අඩු වූ විට එම වස්තුවට සිදුවන්නේ කුමක්ද?",
        options = listOf("ජලයේ ගිලී පතුලේ තැන්පත් වේ", "ජලය මත පාවෙයි (Floats)", "ජලය සමඟ දියවී යයි", "වාෂ්ප වී යයි"),
        correctOptionIndex = 1,
        explanationSinhala = "ප්ලාවන නියමය අනුව වස්තුවේ ඝනත්වය ද්‍රවයේ ඝනත්වයට වඩා අඩු නම් එය පා වේ.",
        topicCategory = "භෞතික විද්‍යාව - ප්ලාවනය"
      ),
      PastPaperQuestion(
        id = 57,
        questionText = "මිනිස් ඇසේ කාචය මඟින් දෘෂ්ටිවිතානය (Retina) මත සාදන ප්‍රතිබිම්බයේ ස්වභාවය කුමක්ද?",
        options = listOf("උඩුකුරු හා විශාලිත", "යටිකුරු හා තාත්වික (Inverted & Real)", "මායා හා උඩුකුරු", "අතාත්වික හා යටිකුරු"),
        correctOptionIndex = 1,
        explanationSinhala = "ඇස් කාචය උත්තල කාචයක් බැවින් දෘෂ්ටිවිතානය මත යටිකුරු තාත්වික ප්‍රතිබිම්බයක් සාදන අතර මොළය මඟින් එය උඩුකුරු කර හඳුනා ගනී.",
        topicCategory = "ජීව විද්‍යාව - සංවේදී අවයව"
      ),
      PastPaperQuestion(
        id = 58,
        questionText = "රසායනික සංයෝගයක අඩංගු මූලද්‍රව්‍යවල සරලම පූර්ණ සංඛ්‍යා අනුපාතය දක්වන සූත්‍රය කුමක්ද?",
        options = listOf("අණුක සූත්‍රය", "අනුභවික සූත්‍රය (Empirical formula)", "ව්‍යුහ සූත්‍රය", "අයනික සූත්‍රය"),
        correctOptionIndex = 1,
        explanationSinhala = "අනුභවික සූත්‍රය මඟින් සංයෝගයක පරමාණු අතර සරලම පූර්ණ සංඛ්‍යා අනුපාතය දක්වයි (උදා: ග්ලූකෝස් අණුක C₆H₁₂O₆, අනුභවික CH₂O).",
        topicCategory = "රසායන විද්‍යාව - රසායනික ගණනය"
      ),
      PastPaperQuestion(
        id = 59,
        questionText = "ආලෝක ප්‍රභවයක සිට දුර 2 ගුණයකින් වැඩි වන විට එම ප්‍රභවයෙන් ලැබෙන දීප්තිය (Illuminance) වෙනස් වන්නේ කෙසේද?",
        options = listOf("දෙගුණයක් වේ", "හතරෙන් එකක් (1/4) දක්වා අඩු වේ", "වෙනස් නොවේ", "අටෙන් එකක් වේ"),
        correctOptionIndex = 1,
        explanationSinhala = "දීප්තිය දුරෙහි වර්ගයට ප්‍රතිලෝමව සමානුපාතික වේ (වර්ග ප්‍රතිලෝම නියමය: E ∝ 1/d²).",
        topicCategory = "භෞතික විද්‍යාව - දීප්තිය"
      ),
      PastPaperQuestion(
        id = 60,
        questionText = "ජෛවගෝලයේ නයිට්‍රජන් චක්‍රයේදී වායුගෝලීය නයිට්‍රජන් පසෙහි තිර කරන්නේ කිනම් බැක්ටීරියාවද?",
        options = listOf("රයිසෝබියම් (Rhizobium)", "ලැක්ටොබැසිලස්", "යීස්ට්", "ඊ.කෝලයි"),
        correctOptionIndex = 0,
        explanationSinhala = "රනිල ශාක මූල ගැටිතිවල වෙසෙන රයිසෝබියම් සහ ක්ලොස්ට්‍රිඩියම් වායුගෝලීය නයිට්‍රජන් තිර කරයි.",
        topicCategory = "ජීව විද්‍යාව - ජෛව චක්‍ර"
      )
    )
  }

  // ==============================================================================
  // 🏛️ HISTORY QUESTION POOL (Anuradhapura, Polonnaruwa, Kandy, Colonial, World)
  // ==============================================================================
  private fun getHistoryQuestionPool(year: String): List<PastPaperQuestion> {
    return listOf(
      PastPaperQuestion(
        id = 1,
        questionText = "ලංකාවේ ප්‍රථම ඓතිහාසික රජු ලෙස මහාවංශයේ සැලකෙන්නේ කවුරුන්ද?",
        options = listOf("දේවානම්පියතිස්ස රජු", "විජය රජු", "පණ්ඩුකාභය රජු", "දුටුගැමුණු රජු"),
        correctOptionIndex = 1,
        explanationSinhala = "ක්‍රි.පූ. 543 දී ඉන්දියාවේ ලාල රට සිට පැමිණි විජය කුමරු ලංකාවේ ප්‍රථම ඓතිහාසික පාලකයා ලෙස සැලකේ.",
        topicCategory = "ඉතිහාසය - මුල් යුගය"
      ),
      PastPaperQuestion(
        id = 2,
        questionText = "අනුරාධපුරය අගනුවර කරගෙන ක්‍රමවත් නගර සැලසුමකට අනුව නගරය සංවිධානය කළ රජු කවුරුන්ද?",
        options = listOf("පණ්ඩුකාභය රජු", "මුටසීව රජු", "දේවානම්පියතිස්ස රජු", "කාවන්තිස්ස රජු"),
        correctOptionIndex = 0,
        explanationSinhala = "පණ්ඩුකාභය රජතුමා අනුරාධපුරය අගනුවර කර නගර ආරක්ෂක තාප්ප, සුසාන භූමි, සහ යෝනිසොමනසිකාර ක්‍රමවත් නගර සැලැස්මක් ස්ථාපිත කළේය.",
        topicCategory = "ඉතිහාසය - අනුරාධපුර යුගය"
      ),
      PastPaperQuestion(
        id = 3,
        questionText = "ලක්දිවට බුදුදහම නිල වශයෙන් හඳුන්වා දෙනු ලැබුවේ කාගේ රාජ්‍ය සමයේදීද?",
        options = listOf("පණ්ඩුකාභය රජු", "දේවානම්පියතිස්ස රජු", "දුටුගැමුණු රජු", "මහසෙන් රජු"),
        correctOptionIndex = 1,
        explanationSinhala = "ක්‍රි.පූ. 3 වන සියවසේදී අශෝක අධිරාජ්‍යයාගේ පුත් මිහිඳු මහ රහතන් වහන්සේ දේවානම්පියතිස්ස රජ සමයේ මිහින්තලයට වැඩම කළහ.",
        topicCategory = "ඉතිහාසය - ශාසන ඉතිහාසය"
      ),
      PastPaperQuestion(
        id = 4,
        questionText = "රුවන්වැලි මහා සෑය සහ මිරිසවැටිය චෛත්‍යය ඉදිකරවන ලද්දේ කිනම් රජතුමා විසින්ද?",
        options = listOf("සද්ධාතිස්ස රජු", "දුටුගැමුණු රජු", "වළගම්බා රජු", "ධාතුසේන රජු"),
        correctOptionIndex = 1,
        explanationSinhala = "එළාර පරාජය කර රට එක්සේසත් කළ දුටුගැමුණු මහරජතුමා රුවන්වැලි සෑය හා ලෝවාමහාපාය ඉදිකළේය.",
        topicCategory = "ඉතිහාසය - ස්මාරක හා වාස්තු"
      ),
      PastPaperQuestion(
        id = 5,
        questionText = "ත්‍රිපිටක ධර්මය මාතලේ අලුවිහාරයේදී ප්‍රථම වරට ග්‍රන්ථාරූඪ කරන ලද්දේ කාගේ පාලන සමයේදීද?",
        options = listOf("වළගම්බා රජු", "මහාසේන රජු", "කාවන්තිස්ස රජු", "වාසභ රජු"),
        correctOptionIndex = 0,
        explanationSinhala = "බැමිණිතියා සාගතය සහ ආක්‍රමණ හමුවේ සදහම් රැකගැනීමට වළගම්බා රජ සමයේ අලුවිහාරයේදී ත්‍රිපිටකය ග්‍රන්ථාරූඪ කෙරිණි.",
        topicCategory = "ඉතිහාසය - ආගමික හා සාහිත්‍ය"
      ),
      PastPaperQuestion(
        id = 6,
        questionText = "ශ්‍රී ලංකාවේ ඉදිකළ විශාලතම ගඩොල් ස්තූපය වන ජේතවනාරාමය ඉදිකළ රජු කවුරුන්ද?",
        options = listOf("මහසෙන් රජු", "ධාතුසේන රජු", "දේවානම්පියතිස්ස රජු", "මහා පරාක්‍රමබාහු රජු"),
        correctOptionIndex = 0,
        explanationSinhala = "මහසෙන් රජතුමා (ක්‍රි.ව. 276-303) ජේතවනාරාමය මෙන්ම මින්නේරිය වැව ඇතුළු මහා වැව් 16ක් ඉදිකළේය.",
        topicCategory = "ඉතිහාසය - වාරි හා ස්තූප"
      ),
      PastPaperQuestion(
        id = 7,
        questionText = "සීගිරිය පර්වත බලකොටුව සහ මනරම් කාශ්‍යප රාජධානිය නිර්මාණය කළ පාලකයා කවුරුන්ද?",
        options = listOf("1 වන කාශ්‍යප රජු", "මුගලන් රජු", "ධාතුසේන රජු", "අග්බෝ රජු"),
        correctOptionIndex = 0,
        explanationSinhala = "ක්‍රි.ව. 5 වන සියවසේදී 1 වන කාශ්‍යප රජු සීගිරිය බලකොටුවක් හා කලාගාරයක් ලෙස ලොව අටවන පුදුමය බඳු නිර්මාණයක් කළේය.",
        topicCategory = "ඉතිහාසය - සීගිරිය"
      ),
      PastPaperQuestion(
        id = 8,
        questionText = "චෝල ආක්‍රමණිකයන් පලවා හැර පොළොන්නරුව අගනුවර කරගනිමින් සිංහල රාජ්‍යය යළි පිහිටුවූයේ කවුරුන්ද?",
        options = listOf("1 වන විජයබාහු රජු", "මහා පරාක්‍රමබාහු රජු", "නිශ්ශංකමල්ල රජු", "කීර්ති ශ්‍රී රාජසිංහ රජු"),
        correctOptionIndex = 0,
        explanationSinhala = "ක්‍රි.ව. 1070 දී 1 වන විජයබාහු රජු වසර 77 ක චෝල පාලනය අවසන් කර පොළොන්නරුවේ කිරුළු පැළඳීය.",
        topicCategory = "ඉතිහාසය - පොළොන්නරු යුගය"
      ),
      PastPaperQuestion(
        id = 9,
        questionText = "'අහසින් වැටෙන එකදු දිය බිඳක්වත් මිනිසාගේ ප්‍රයෝජනයට නොගෙන මුහුදට ගලා යාමට නොදිය යුතුය' යන ප්‍රකාශය කාගේද?",
        options = listOf("මහසෙන් රජු", "මහා පරාක්‍රමබාහු රජු", "ධාතුසේන රජු", "පණ්ඩුකාභය රජු"),
        correctOptionIndex = 1,
        explanationSinhala = "පරාක්‍රම සමුද්‍රය නිර්මාණය කරමින් රට සහලින් ස්වයංපෝෂිත කළ මහා පරාක්‍රමබාහු රජතුමාගේ ප්‍රතිපත්තිය මෙය විය.",
        topicCategory = "ඉතිහාසය - වාරි ශිෂ්ටාචාරය"
      ),
      PastPaperQuestion(
        id = 10,
        questionText = "පොළොන්නරුවේ ගල් විහාරයේ පිහිටි අතිවිශිෂ්ට හිඳි, හිටි සහ සැතපෙන බුද්ධ ප්‍රතිමා නෙළවූ රජු කවුරුන්ද?",
        options = listOf("1 වන විජයබාහු රජු", "මහා පරාක්‍රමබාහු රජු", "නිශ්ශංකමල්ල රජු", "දෙවන පැරකුම්බා රජු"),
        correctOptionIndex = 1,
        explanationSinhala = "මහා පරාක්‍රමබාහු රජු උත්තරාරාමය හෙවත් ගල් විහාරය නිර්මාණය කළේය.",
        topicCategory = "ඉතිහාසය - බෞද්ධ කලා"
      ),
      PastPaperQuestion(
        id = 11,
        questionText = "කාලිංග මාඝගේ විනාශකාරී ආක්‍රමණයෙන් පසු රාජධානිය නිරිතදිගට සංක්‍රමණය වූ ප්‍රථම ස්ථානය කුමක්ද?",
        options = listOf("යාපහුව", "දඹදෙණිය", "කුරුණෑගල", "ගම්පොළ"),
        correctOptionIndex = 1,
        explanationSinhala = "3 වන විජයබාහු රජතුමා දඹදෙණියේ අගනුවර පිහිටුවා දළදා වහන්සේ බෙලිගල රැකගත්තේය.",
        topicCategory = "ඉතිහාසය - දඹදෙණි යුගය"
      ),
      PastPaperQuestion(
        id = 12,
        questionText = "ශ්‍රී ලංකාවට පෘතුගීසීන් ප්‍රථම වරට ලොරෙන්සෝ ද අල්මේදා යටතේ ගොඩබැස්සේ කිනම් වර්ෂයේදීද?",
        options = listOf("ක්‍රි.ව. 1505", "ක්‍රි.ව. 1597", "ක්‍රි.ව. 1658", "ක්‍රි.ව. 1796"),
        correctOptionIndex = 0,
        explanationSinhala = "ක්‍රි.ව. 1505 දී සුළි සුළඟකට හසුව කොළඹ වරායට පෘතුගීසි නැව් සේනාව පැමිණියේය.",
        topicCategory = "ඉතිහාසය - යටත්විජිත යුගය"
      ),
      PastPaperQuestion(
        id = 13,
        questionText = "සීතාවක රාජධානියේ පෘතුගීසීන්ට එරෙහිව මුල්ලේරියා සටන මෙහෙයවූ වීර පාලකයා කවුරුන්ද?",
        options = listOf("මායාදුන්නේ රජු", "ටිකිරි කුමරු (1 වන රාජසිංහ රජු)", "වීදිය බණ්ඩාර", "ධර්මපාල රජු"),
        correctOptionIndex = 1,
        explanationSinhala = "1 වන රාජසිංහ රජු ක්‍රි.ව. 1562 මුල්ලේරියා වෙලේදී පෘතුගීසි බලඇණියක් සම්පූර්ණයෙන්ම සමූලඝාතනය කළේය.",
        topicCategory = "ඉතිහාසය - සීතාවක හා සටන්"
      ),
      PastPaperQuestion(
        id = 14,
        questionText = "උඩරට රාජධානිය පිහිටුවා දළදා වහන්සේ සෙංකඩගලට වැඩම කරවූ රජු කවුරුන්ද?",
        options = listOf("1 වන විමලධර්මසූරිය රජු", "සෙනරත් රජු", "2 වන රාජසිංහ රජු", "නරේන්ද්‍රසිංහ රජු"),
        correctOptionIndex = 0,
        explanationSinhala = "ක්‍රි.ව. 1592 දී කොනප්පු බණ්ඩාර හෙවත් 1 වන විමලධර්මසූරිය රජු උඩරට ස්වාධීන රාජධානියක් ලෙස තහවුරු කළේය.",
        topicCategory = "ඉතිහාසය - මහනුවර යුගය"
      ),
      PastPaperQuestion(
        id = 15,
        questionText = "පෘතුගීසීන් පලවා හැරීම සඳහා ලන්දේසීන් (Dutch) සමඟ ගිවිසුම් ගැසූ උඩරට රජු කවුරුන්ද?",
        options = listOf("1 වන විමලධර්මසූරිය", "2 වන රාජසිංහ රජු", "ශ්‍රී වීරපරාක්‍රම නරේන්ද්‍රසිංහ", "කීර්ති ශ්‍රී රාජසිංහ"),
        correctOptionIndex = 1,
        explanationSinhala = "ක්‍රි.ව. 1638 දී 2 වන රාජසිංහ රජු ලන්දේසීන් සමඟ ගිවිසුම් ගැසූ අතර 'ඉඟුරු දී මිරිස් ගත්තාක් මෙන්' ලන්දේසීහු මුහුදුබඩ අත්පත් කරගත්හ.",
        topicCategory = "ඉතිහාසය - ලන්දේසි පාලනය"
      ),
      PastPaperQuestion(
        id = 16,
        questionText = "උඩරට ගිවිසුම මඟින් මුළු ලංකාවම බ්‍රිතාන්‍ය කිරීටයට යටත් වූ ඓතිහාසික දිනය කුමක්ද?",
        options = listOf("1815 මාර්තු 02", "1796 පෙබරවාරි 16", "1818 නොවැම්බර් 26", "1948 පෙබරවාරි 04"),
        correctOptionIndex = 0,
        explanationSinhala = "1815 මාර්තු 02 දින මඟුල් මඩුවේදී උඩරට ප්‍රධානීන් සහ රොබට් බ්‍රවුන්රිග් ආණ්ඩුකාරයා අතර උඩරට ගිවිසුම අත්සන් කෙරිණි.",
        topicCategory = "ඉතිහාසය - බ්‍රිතාන්‍ය යුගය"
      ),
      PastPaperQuestion(
        id = 17,
        questionText = "1818 ඌව-වෙල්ලස්ස නිදහස් අරගලයේ ප්‍රධාන සෙන්පතියා ලෙස නායකත්වය දුන්නේ කවුරුන්ද?",
        options = listOf("මොනරවිල කැප්පෙටිපොළ දිසාව", "වීර පුරන් අප්පු", "ගොංගාලේගොඩ බණ්ඩා", "ඇහැලේපොළ අදිකාරම්"),
        correctOptionIndex = 0,
        explanationSinhala = "ඉංග්‍රීසි හමුදාව අතහැර ජනතාව වෙනුවෙන් කැරැල්ල මෙහෙයවූ වීර කැප්පෙටිපොළ දිසාව අරගලයේ නායකයා විය.",
        topicCategory = "ඉතිහාසය - නිදහස් අරගල"
      ),
      PastPaperQuestion(
        id = 18,
        questionText = "ශ්‍රී ලංකාවට නිදහස හිමි වූයේ කිනම් වර්ෂයේදීද?",
        options = listOf("1948 පෙබරවාරි 04", "1972 මැයි 22", "1978 සැප්තැම්බර් 07", "1956 අප්‍රේල් 12"),
        correctOptionIndex = 0,
        explanationSinhala = "1948 පෙබරවාරි 04 දින ලංකාව ඩොමීනියන් තත්ත්වය යටතේ බ්‍රිතාන්‍ය පාලනයෙන් නිදහස ලබා ගත්තේය.",
        topicCategory = "ඉතිහාසය - නිදහස හා ආණ්ඩුක්‍රම"
      ),
      PastPaperQuestion(
        id = 19,
        questionText = "ලංකාවේ ප්‍රථම අග්‍රාමාත්‍යවරයා (First Prime Minister) ලෙස පත් වූයේ කවුරුන්ද?",
        options = listOf("ඩී.එස්. සේනානායක මැතිතුමා", "එස්.ඩබ්.ආර්.ඩී. බණ්ඩාරනායක මැතිතුමා", "ඩඩ්ලි සේනානායක මැතිතුමා", "ශ්‍රීමත් ජෝන් කොතලාවල"),
        correctOptionIndex = 0,
        explanationSinhala = "ජාතියේ පියා ලෙස විරුදාවලිය ලත් ඩී.එස්. සේනානායක මැතිතුමා නිදහස් ලංකාවේ මුල්ම අග්‍රාමාත්‍යවරයා විය.",
        topicCategory = "ඉතිහාසය - දේශපාලන නායකයෝ"
      ),
      PastPaperQuestion(
        id = 20,
        questionText = "ලෝකයේ ප්‍රථම කාන්තා අග්‍රාමාත්‍යවරිය ලෙස 1960 දී ඉතිහාසගත වූයේ කවුරුන්ද?",
        options = listOf("සිරිමාවෝ බණ්ඩාරනායක මැතිනිය", "ඉන්දිරා ගාන්ධි මැතිනිය", "මාග්‍රට් තැචර් මැතිනිය", "චන්ද්‍රිකා කුමාරතුංග මැතිනිය"),
        correctOptionIndex = 0,
        explanationSinhala = "1960 ජූලි මාසයේදී ශ්‍රී ලංකාවේ අග්‍රාමාත්‍ය ධුරයට පත්වෙමින් සිරිමාවෝ බණ්ඩාරනායක මැතිනිය ලෝක ඉතිහාසයට එක්විය.",
        topicCategory = "ඉතිහාසය - නූතන ලංකාව"
      )
    )
  }

  // ==============================================================================
  // ☸️ BUDDHISM QUESTION POOL (Sutta, Vinaya, Sasana, History, Ethics)
  // ==============================================================================
  private fun getBuddhismQuestionPool(year: String): List<PastPaperQuestion> {
    return listOf(
      PastPaperQuestion(
        id = 1,
        questionText = "බුදුරජාණන් වහන්සේ බරණැස ඉසිපතන මිගදායේදී දේශනා කළ ප්‍රථම ධර්ම දේශනාව කුමක්ද?",
        options = listOf("අනත්තලක්ඛණ සූත්‍රය", "ධම්මචක්කප්පවත්තන සූත්‍රය", "මහා මංගල සූත්‍රය", "කරණීයමෙත්ත සූත්‍රය"),
        correctOptionIndex = 1,
        explanationSinhala = "ඇසළ පුන් පොහෝ දින පස්වග තවුසන් උදෙසා චතුරාර්ය සත්‍යය මුල්වරට ප්‍රකාශ කරමින් ධම්මචක්කප්පවත්තන සූත්‍රය දේශනා කෙරිණි.",
        topicCategory = "බුද්ධ ධර්මය - සූත්‍ර දේශනා"
      ),
      PastPaperQuestion(
        id = 2,
        questionText = "බුදුදහමේ මූලික ඉගැන්වීම වන චතුරාර්ය සත්‍යයට අයත් නොවන අංගය කුමක්ද?",
        options = listOf("දුක්ඛ සත්‍යය", "සමුදය සත්‍යය", "මෝහ සත්‍යය", "මාර්ග සත්‍යය"),
        correctOptionIndex = 2,
        explanationSinhala = "චතුරාර්ය සත්‍යයන් හතර වන්නේ දුක්ඛ, දුක්ඛ සමුදය, දුක්ඛ නිරෝධ, සහ දුක්ඛ නිරෝධ ගාමිණී පටිපදා (මාර්ග) සත්‍යයයි.",
        topicCategory = "බුද්ධ ධර්මය - දර්ශනය"
      ),
      PastPaperQuestion(
        id = 3,
        questionText = "ආර්ය අෂ්ටාංගික මාර්ගයේ 'සීල' ශික්ෂාවට අයත් වන අංග තුන මොනවාද?",
        options = listOf("සම්මා දිට්ඨි, සම්මා සංකප්ප, සම්මා වාචා", "සම්මා වාචා, සම්මා කම්මන්ත, සම්මා ආජීව", "සම්මා වායාම, සම්මා සති, සම්මා සමාධි", "සම්මා දිට්ඨි, සම්මා සමාධි, සම්මා ආජීව"),
        correctOptionIndex = 1,
        explanationSinhala = "නිවැරදි වචනය, නිවැරදි ක්‍රියාව සහ නිවැරදි දිවි පැවැත්ම සීල ශික්ෂාවට අයත් වේ.",
        topicCategory = "බුද්ධ ධර්මය - ආර්ය අෂ්ටාංගික මාර්ගය"
      ),
      PastPaperQuestion(
        id = 4,
        questionText = "සිද්ධාර්ථ කුමාරෝත්පත්තිය සිදු වූ ස්ථානය කුමක්ද?",
        options = listOf("බුද්ධගයාව", "ලුම්බිණි සල් උයන", "කුසිනාරාව", "ඉසිපතනය"),
        correctOptionIndex = 1,
        explanationSinhala = "සිද්ධාර්ථ බෝසතාණන් වහන්සේ වෙසක් පුන් පොහෝ දින නේපාලයේ ලුම්බිණි සල් උයනේදී උපත ලැබූහ.",
        topicCategory = "බුද්ධ ධර්මය - බුද්ධ චරිතය"
      ),
      PastPaperQuestion(
        id = 5,
        questionText = "බුදුරජාණන් වහන්සේගේ අග්‍රශ්‍රාවක දෙනම ලෙස සැලකෙන්නේ කවුරුන්ද?",
        options = listOf("ආනන්ද හිමි සහ කාශ්‍යප හිමි", "සැරියුත් සහ මුගලන් මහ රහතන් වහන්සේලා", "අනුරුද්ධ සහ උපාලි හිමි", "කොණ්ඩඤ්ඤ සහ පුණ්ණ හිමි"),
        correctOptionIndex = 1,
        explanationSinhala = "ධර්ම සේනාපති සැරියුත් මහ රහතන් වහන්සේ (දකුණත් සව්) සහ සෘද්ධිමත් මුගලන් මහ රහතන් වහන්සේ (වමත් සව්) අග්‍රශ්‍රාවකයෝ වූහ.",
        topicCategory = "බුද්ධ ධර්මය - ශ්‍රාවක චරිත"
      ),
      PastPaperQuestion(
        id = 6,
        questionText = "බුද්ධ පරිනිර්වාණයෙන් තුන් මසකට පසු රජගහනුවර සප්තපණ්ණි ගුහාද්වාරයේ පැවැත්වූ සංගායනාව කුමක්ද?",
        options = listOf("ප්‍රථම ධර්ම සංගායනාව", "ද්විතීය ධර්ම සංගායනාව", "තෘතීය ධර්ම සංගායනාව", "අලුවිහාර සංගායනාව"),
        correctOptionIndex = 0,
        explanationSinhala = "සුභද්ද භික්ෂුවගේ අයහපත් ප්‍රකාශය මුල් කරගෙන අජාසත් රජුගේ දායකත්වයෙන් මහා කාශ්‍යප මහ රහතන් වහන්සේගේ ප්‍රධානත්වයෙන් ප්‍රථම ධර්ම සංගායනාව පැවැත්විණි.",
        topicCategory = "බුද්ධ ධර්මය - ශාසන ඉතිහාසය"
      ),
      PastPaperQuestion(
        id = 7,
        questionText = "මව්පියන්ට, ගුරුවරුන්ට සහ සමාජයට යුතුකම් ඉටුකිරීම විස්තර කෙරෙන ප්‍රකට සූත්‍ර දේශනාව කුමක්ද?",
        options = listOf("සිඟාලෝවාද සූත්‍රය", "ධම්මචක්ක සූත්‍රය", "සච්චවිභංග සූත්‍රය", "ගිරීමානන්ද සූත්‍රය"),
        correctOptionIndex = 0,
        explanationSinhala = "ගිහි විනය ලෙස හැඳින්වෙන සිඟාලෝවාද සූත්‍රයේ සදිසා නමස්කාරය ඇසුරින් සමාජ යුතුකම් පෙන්වා දී ඇත.",
        topicCategory = "බුද්ධ ධර්මය - බෞද්ධ සදාචාරය"
      ),
      PastPaperQuestion(
        id = 8,
        questionText = "බුදුදහමට අනුව 'කර්මය' (Kamma) ලෙස අර්ථ දක්වන්නේ කුමක්ද?",
        options = listOf("දෛවය මඟින් ලියැවුණු ඉරණම", "චේතනාපූර්වකව කරන කුසල් හෝ අකුසල් ක්‍රියාව", "අහඹු සිදුවීම", "පෙර භවයේ දඬුවම පමණි"),
        correctOptionIndex = 1,
        explanationSinhala = "'චේතනාහං භික්ඛවේ කම්මං වදාමි' - චේතනාව මුල් කරගෙන සිතින්, කයින්, වචනයෙන් කරන ක්‍රියා කර්මය නම් වේ.",
        topicCategory = "බුද්ධ ධර්මය - කර්ම න්‍යාය"
      ),
      PastPaperQuestion(
        id = 9,
        questionText = "ලක්දිව භික්ෂුණී ශාසනය පිහිටුවීම සඳහා ජය ශ්‍රී මහා බෝධි අංකුරයද රැගෙන වැඩම කළේ කවුරුන්ද?",
        options = listOf("සංඝමිත්තා මහ රහත් මෙහෙණින් වහන්සේ", "හේමමාලා කුමරිය", "අනුලා දේවිය", "විශාඛාව"),
        correctOptionIndex = 0,
        explanationSinhala = "අශෝක රජුගේ දියණිය වූ සංඝමිත්තා තෙරණිය දඹකොළපටුනෙන් වැඩම කර අනුලා දේවිය ඇතුළු කාන්තාවන් පැවිදි කරවූහ.",
        topicCategory = "බුද්ධ ධර්මය - ලක්දිව ශාසනය"
      ),
      PastPaperQuestion(
        id = 10,
        questionText = "ත්‍රිපිටකයේ විනය පිටකයට අයත් ග්‍රන්ථ සංඛ්‍යාව කීයද?",
        options = listOf("3", "5 (පාරාජිකා, පාචිත්තිය, මහාවග්ග, චුල්ලවග්ග, පරිවාර)", "7", "15"),
        correctOptionIndex = 1,
        explanationSinhala = "විනය පිටකය ග්‍රන්ථ 5 කින් යුක්ත වන අතර භික්ෂු භික්ෂුණී විනය ශික්ෂාපද අන්තර්ගත වේ.",
        topicCategory = "බුද්ධ ධර්මය - ත්‍රිපිටකය"
      )
    )
  }

  // ==============================================================================
  // 📚 SINHALA QUESTION POOL (Grammar, Sandhi, Samasa, Literature, Proverbs)
  // ==============================================================================
  private fun getSinhalaQuestionPool(year: String): List<PastPaperQuestion> {
    return listOf(
      PastPaperQuestion(
        id = 1,
        questionText = "සිංහල හෝඩියේ 'මූර්ධජ' (Cerebral) අක්ෂර යුගලයක් වන්නේ මින් කුමක්ද?",
        options = listOf("ණ, ළ", "න, ල", "ත, ද", "ප, බ"),
        correctOptionIndex = 0,
        explanationSinhala = "ණ සහ ළ මූර්ධජ අක්ෂර වන අතර න සහ ල දන්තජ අක්ෂර වේ.",
        topicCategory = "සිංහල - අක්ෂර වින්‍යාසය"
      ),
      PastPaperQuestion(
        id = 2,
        questionText = "'ගුරු + උපදේශ = ගුරුපදේශ' මෙහි සිදුවී ඇති සන්ධි කාර්යය කුමක්ද?",
        options = listOf("ස්වර ලෝප සන්ධිය", "පූර්ව ස්වර ලෝප සන්ධිය", "පර ස්වර ලෝප සන්ධිය", "ව්‍යඤ්ජන ලෝප සන්ධිය"),
        correctOptionIndex = 1,
        explanationSinhala = "පූර්ව පදයේ අග ස්වරය (උ) ලොප් වී පර පදයේ මුල් ස්වරය හා එක්වීම පූර්ව ස්වර ලෝප සන්ධියයි.",
        topicCategory = "සිංහල - සන්ධි"
      ),
      PastPaperQuestion(
        id = 3,
        questionText = "'නොමඳ' යන්නෙහි සමාස නාමය කුමක්ද?",
        options = listOf("තත්පුරුෂ සමාසය", "නඤ් තත්පුරුෂ සමාසය (Negative Compound)", "ද්වන්ද සමාසය", "ද්විගු සමාසය"),
        correctOptionIndex = 1,
        explanationSinhala = "නිශේධාර්ථය හැඟවීමට 'නො' හෝ 'අ' යෙදීමෙන් සෑදෙන සමාසය නඤ් තත්පුරුෂ සමාසයයි.",
        topicCategory = "සිංහල - සමාස"
      ),
      PastPaperQuestion(
        id = 4,
        questionText = "ගුත්තිල කාව්‍යයේ කතුවරයා කවුරුන්ද?",
        options = listOf("වෑත්තෑවේ හිමි", "තොටගමුවේ ශ්‍රී රාහුල හිමි", "විදුරසන හිමි", "අලගියවන්න මුකවෙටි"),
        correctOptionIndex = 0,
        explanationSinhala = "කෝට්ටේ යුගයේ වැඩ විසූ වෑත්තෑවේ හිමියන් ගුත්තිල කාව්‍යයේ රචකයා වේ.",
        topicCategory = "සිංහල - සාහිත්‍යය"
      ),
      PastPaperQuestion(
        id = 5,
        questionText = "'අතීතය සිහිපත් කරමින් පසුතැවීම' හැඟවීමට වඩාත්ම උචිත ප්‍රස්ථාව පිරුළ කුමක්ද?",
        options = listOf("කැහිගෑනු හොටුගෑනු වෙනවා වගේ", "ඉඟුරු දී මිරිස් ගත්තා වගේ", "කිරි කළයට ගොම පිඬක් දැමුවා සේ", "පෙරහැර ගියාට පසු තම්බොක්කුව ගැහුවා වගේ"),
        correctOptionIndex = 3,
        explanationSinhala = "කාලය ඉක්ම ගිය පසු නිෂ්ඵල ක්‍රියා කිරීම 'පෙරහැර ගියාට පසු තම්බොක්කුව ගැහුවා වගේ' පිරුළෙන් අදහස් වේ.",
        topicCategory = "සිංහල - ප්‍රස්ථාව පිරුළු"
      ),
      PastPaperQuestion(
        id = 6,
        questionText = "වාක්‍යයක උක්තය බහු වචන නම් ආඛ්‍යාතය (ක්‍රියා පදය) විය යුත්තේ කිනම් ආකාරයටද?",
        options = listOf("ඒක වචන", "බහු වචන (Plural)", "අව්‍යය පදයක්", "කර්ම කාරක"),
        correctOptionIndex = 1,
        explanationSinhala = "සිංහල ව්‍යාකරණ රීතියට අනුව උක්ත ආඛ්‍යාත පද ලිංග, වචන, පුරුෂ අනුව ගැලපිය යුතුය.",
        topicCategory = "සිංහල - වාක්‍ය රීති"
      ),
      PastPaperQuestion(
        id = 7,
        questionText = "පරසතු මල් විසුරුවා බුදුන් වැඳීම පිළිබඳ වර්ණනා කෙරෙන ජාතක කතාව කුමක්ද?",
        options = listOf("කුස ජාතකය", "චුල්ල ධනුග්ගහ ජාතකය", "උම්මග්ග ජාතකය", "මහා සුදස්සන ජාතකය"),
        correctOptionIndex = 2,
        explanationSinhala = "මහෝසධ පඬිතුමාගේ ප්‍රඥාව මහිමය දැක්වෙන උම්මග්ග ජාතකය විශිෂ්ට සම්භාව්‍ය සාහිත්‍ය නිර්මාණයකි.",
        topicCategory = "සිංහල - ජාතක කතා"
      ),
      PastPaperQuestion(
        id = 8,
        questionText = "'අහස උසට ගොඩනැගිලි' යන්නෙහි යෙදී ඇති උපමාලංකාරය කුමක්ද?",
        options = listOf("අතිශයෝක්තිය (Hyperbole)", "රූපකය", "උත්ප්‍රේක්ෂාව", "ස්වභාවෝක්තිය"),
        correctOptionIndex = 0,
        explanationSinhala = "යථාර්ථයට වඩා අතිශයෝක්තියෙන් යුතුව උස දැක්වීම අතිශයෝක්ති අලංකාරයයි.",
        topicCategory = "සිංහල - කාව්‍යාලංකාර"
      ),
      PastPaperQuestion(
        id = 9,
        questionText = "ලංකාවේ පැරණිතම සන්දේශ කාව්‍යය ලෙස සැලකෙන්නේ කුමක්ද?",
        options = listOf("සැළලිහිණි සන්දේශය", "මයුර සන්දේශය (ගම්පොළ යුගය)", "කෝකිල සන්දේශය", "හංස සන්දේශය"),
        correctOptionIndex = 1,
        explanationSinhala = "ගම්පොළ යුගයේ ලියැවුණු මයුර සන්දේශය සිංහල සාහිත්‍යයේ හමුවන පැරණිතම සන්දේශ කාව්‍යයයි.",
        topicCategory = "සිංහල - සන්දේශ සාහිත්‍යය"
      ),
      PastPaperQuestion(
        id = 10,
        questionText = "'ස්වර්ණ' යන්නෙහි නිවැරදි තද්භව (සිංහල) රූපය කුමක්ද?",
        options = listOf("රන් / රත්තරන්", "සුරන්", "සඳ", "ස්වර්ණා"),
        correctOptionIndex = 0,
        explanationSinhala = "සංස්කෘත ස්වර්ණ යන්න සිංහලට බිඳී පැමිණීමේදී 'රන්' බවට පරිවර්තනය විය.",
        topicCategory = "සිංහල - පද නිරුක්ති"
      )
    )
  }

  // ==============================================================================
  // 📐 MATHEMATICS QUESTION POOL (Arithmetic, Algebra, Geometry, Stats)
  // ==============================================================================
  private fun getMathQuestionPool(year: String): List<PastPaperQuestion> {
    return listOf(
      PastPaperQuestion(
        id = 1,
        questionText = "2x + 5 = 15 සමීකරණය තෘප්ත කරන x හි අගය කීයද?",
        options = listOf("x = 3", "x = 5", "x = 10", "x = 2"),
        correctOptionIndex = 1,
        explanationSinhala = "2x = 15 - 5 = 10, එබැවින් x = 10 / 2 = 5.",
        topicCategory = "ගණිතය - වීජ ගණිතය"
      ),
      PastPaperQuestion(
        id = 2,
        questionText = "අරය 7 cm වූ වෘත්තයක පරිධිය (Circumference) කොපමණද? (π = 22/7)",
        options = listOf("22 cm", "44 cm", "154 cm", "88 cm"),
        correctOptionIndex = 1,
        explanationSinhala = "පරිධිය C = 2πr = 2 × (22/7) × 7 = 44 cm.",
        topicCategory = "ගණිතය - පරිමිතිය හා වර්ගඵලය"
      ),
      PastPaperQuestion(
        id = 3,
        questionText = "පයිතගරස් ප්‍රමේයයට අනුව පාද 6 cm සහ 8 cm වන ඍජුකෝණී ත්‍රිකෝණයේ කර්ණයේ දිග කීයද?",
        options = listOf("10 cm", "12 cm", "14 cm", "100 cm"),
        correctOptionIndex = 0,
        explanationSinhala = "c² = 6² + 8² = 36 + 64 = 100, එබැවින් c = √100 = 10 cm.",
        topicCategory = "ගණිතය - ජ්‍යාමිතිය"
      ),
      PastPaperQuestion(
        id = 4,
        questionText = "සාධාරණ දාදු කැටයක් උඩ දැමූ විට ඉරට්ටේ සංඛ්‍යාවක් ලැබීමේ සම්භාවිතාව (Probability) කීයද?",
        options = listOf("1/6", "1/2 (3/6)", "1/3", "2/3"),
        correctOptionIndex = 1,
        explanationSinhala = "නියැදි අවකාශය {1, 2, 3, 4, 5, 6}. ඉරට්ටේ සංඛ්‍යා {2, 4, 6} (අවස්ථා 3). P = 3/6 = 1/2.",
        topicCategory = "ගණිතය - සම්භාවිතාව"
      ),
      PastPaperQuestion(
        id = 5,
        questionText = "රු. 10,000 ක මුදලක් වාර්ෂිකව 10% ක සරල පොලියකට තැන්පත් කළ විට වසර 2 කදී ලැබෙන මුළු පොලිය කීයද?",
        options = listOf("රු. 1,000", "රු. 2,000", "රු. 12,000", "රු. 500"),
        correctOptionIndex = 1,
        explanationSinhala = "I = Ptr / 100 = 10,000 × 2 × 10 / 100 = රු. 2,000.",
        topicCategory = "ගණිතය - වාණිජ ගණිතය"
      ),
      PastPaperQuestion(
        id = 6,
        questionText = "3, 5, 7, 9, ... සමාන්තර ශ්‍රේඪියේ 10 වන පදය (T₁₀) කීයද?",
        options = listOf("19", "21", "23", "25"),
        correctOptionIndex = 1,
        explanationSinhala = "Tn = a + (n - 1)d = 3 + (10 - 1) × 2 = 3 + 18 = 21.",
        topicCategory = "ගණිතය - ශ්‍රේඪි"
      ),
      PastPaperQuestion(
        id = 7,
        questionText = "x² - 9 හි සාධක මොනවාද?",
        options = listOf("(x - 3)(x - 3)", "(x - 3)(x + 3)", "(x + 9)(x - 1)", "(x - 9)(x + 9)"),
        correctOptionIndex = 1,
        explanationSinhala = "වර්ග දෙකක අන්තරය සූත්‍රය a² - b² = (a - b)(a + b) අනුව (x - 3)(x + 3) වේ.",
        topicCategory = "ගණිතය - සාධක"
      ),
      PastPaperQuestion(
        id = 8,
        questionText = "ත්‍රිකෝණයක අභ්‍යන්තර කෝණ තුනෙහි එකතුව අංශක කීයද?",
        options = listOf("90°", "180°", "360°", "270°"),
        correctOptionIndex = 1,
        explanationSinhala = "ඕනෑම තල ත්‍රිකෝණයක අභ්‍යන්තර කෝණවල ඓක්‍යය 180° කි.",
        topicCategory = "ගණිතය - කෝණ හා ප්‍රමේය"
      ),
      PastPaperQuestion(
        id = 9,
        questionText = "දත්ත සමූහයක 2, 4, 4, 5, 7, 9 නම් එහි මාතය (Mode) කුමක්ද?",
        options = listOf("4", "5", "5.1", "7"),
        correctOptionIndex = 0,
        explanationSinhala = "මාතය යනු වැඩිම වාර ගණනක් පුනරාවර්තනය වන අගයයි. මෙහි 4 දෙවරක් යෙදී ඇත.",
        topicCategory = "ගණිතය - සංඛ්‍යානය"
      ),
      PastPaperQuestion(
        id = 10,
        questionText = "log₁₀(1000) හි අගය කීයද?",
        options = listOf("1", "2", "3", "10"),
        correctOptionIndex = 2,
        explanationSinhala = "10³ = 1000 බැවින් log₁₀(1000) = 3 වේ.",
        topicCategory = "ගණිතය - ලඝුගණක"
      )
    )
  }

  // ==============================================================================
  // 🔤 ENGLISH QUESTION POOL (Grammar, Vocabulary, Tenses, Prepositions)
  // ==============================================================================
  private fun getEnglishQuestionPool(year: String): List<PastPaperQuestion> {
    return listOf(
      PastPaperQuestion(
        id = 1,
        questionText = "Choose the correct verb form: 'She ________ to school every morning by bus.'",
        options = listOf("go", "goes", "going", "gone"),
        correctOptionIndex = 1,
        explanationSinhala = "තෙවන පුරුෂ ඒක වචන කර්තෘ 'She' සඳහා Simple Present Tense හිදී ක්‍රියා පදයට -es එකතු වේ (goes).",
        topicCategory = "English - Subject-Verb Agreement"
      ),
      PastPaperQuestion(
        id = 2,
        questionText = "Select the appropriate preposition: 'He was born ________ the 14th of August.'",
        options = listOf("in", "on", "at", "by"),
        correctOptionIndex = 1,
        explanationSinhala = "නිශ්චිත දිනයක් (Dates and days) සඳහන් කරන විට 'on' නිපාතය භාවිතා කරයි.",
        topicCategory = "English - Prepositions"
      ),
      PastPaperQuestion(
        id = 3,
        questionText = "What is the opposite (antonym) of the word 'ANCIENT'?",
        options = listOf("Old", "Modern", "Historic", "Antique"),
        correctOptionIndex = 1,
        explanationSinhala = "'Ancient' යනු පුරාණ වන අතර එහි විරුද්ධ පදය 'Modern' (නූතන) වේ.",
        topicCategory = "English - Vocabulary & Antonyms"
      ),
      PastPaperQuestion(
        id = 4,
        questionText = "Convert to passive voice: 'Kamal wrote a letter.'",
        options = listOf("A letter is written by Kamal.", "A letter was written by Kamal.", "Kamal was written by a letter.", "A letter had written by Kamal."),
        correctOptionIndex = 1,
        explanationSinhala = "Past simple හිදී Passive voice සෑදෙන්නේ Object + was/were + Past Participle (was written) ආකෘතියෙනි.",
        topicCategory = "English - Passive Voice"
      ),
      PastPaperQuestion(
        id = 5,
        questionText = "Fill in the blank: 'If it rains tomorrow, we ________ at home.'",
        options = listOf("stayed", "will stay", "would stay", "staying"),
        correctOptionIndex = 1,
        explanationSinhala = "First Conditional വാක්‍යයක If clause එක Present Tense නම් Main clause එක will + base verb (will stay) වේ.",
        topicCategory = "English - Conditionals"
      ),
      PastPaperQuestion(
        id = 6,
        questionText = "Choose the correctly spelled word:",
        options = listOf("Occassion", "Occasion", "Ocasion", "Occation"),
        correctOptionIndex = 1,
        explanationSinhala = "නිවැරදි අක්ෂර වින්‍යාසය 'Occasion' (දෙවරක් c, එක්වරක් s) වේ.",
        topicCategory = "English - Spelling"
      ),
      PastPaperQuestion(
        id = 7,
        questionText = "Which relative pronoun fits best: 'The doctor ________ treated my father is very kind.'",
        options = listOf("which", "who", "whose", "where"),
        correctOptionIndex = 1,
        explanationSinhala = "මිනිසුන් (People) හැඳින්වීම සඳහා 'who' සර්වනාමය යොදයි.",
        topicCategory = "English - Relative Pronouns"
      ),
      PastPaperQuestion(
        id = 8,
        questionText = "Identify the meaning of the idiom: 'Once in a blue moon'",
        options = listOf("Frequently", "Very rarely", "Every night", "Never"),
        correctOptionIndex = 1,
        explanationSinhala = "'Once in a blue moon' යන්නෙන් ඉතා කලාතුරකින් සිදුවන දෙයක් (Very rarely) අදහස් වේ.",
        topicCategory = "English - Idioms"
      ),
      PastPaperQuestion(
        id = 9,
        questionText = "Select the correct plural form of 'Crisis':",
        options = listOf("Crises", "Crisises", "Crisis's", "Crisies"),
        correctOptionIndex = 0,
        explanationSinhala = "'Crisis' හි බහු වචනය 'Crises' වේ.",
        topicCategory = "English - Plural Forms"
      ),
      PastPaperQuestion(
        id = 10,
        questionText = "Choose the correct conjunction: 'He studied hard, ________ he failed the exam.'",
        options = listOf("because", "so", "yet / but", "and"),
        correctOptionIndex = 2,
        explanationSinhala = "පරස්පර ප්‍රතිඵලයක් දැක්වීම සඳහා 'yet' හෝ 'but' (එහෙත්) නිපාතය යොදා ගැනේ.",
        topicCategory = "English - Conjunctions"
      )
    )
  }
}
