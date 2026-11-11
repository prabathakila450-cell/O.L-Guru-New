package com.example

/**
 * 📚 Comprehensive Voice Quiz Bank for General Subjects:
 * Sinhala (සිංහල), Commerce (වාණිජ හා ගිණුම්කරණය), Agriculture (කෘෂිකර්මය),
 * Civics (පුරවැසි අධ්‍යාපනය), Health (සෞඛ්‍යය හා ශාරීරික අධ්‍යාපනය).
 *
 * Fully supports Grade 10 AND Grade 11 with distinct syllabus-aligned questions.
 * Every single question is short, direct, curriculum-accurate, non-formula, and non-repeating.
 */
object VoiceQuizGeneralBank {

  fun getQuestion(
    subject: String,
    grade: String,
    setNum: Int,
    qIndex: Int,
    theme: String
  ): Quintuple<String, String, List<String>, String, String> {
    val cleanTheme = theme.replace(Regex("^[0-9]+\\.\\s*"), "").trim()

    return when {
      subject.contains("සිංහල") -> getSinhalaQuestion(grade, setNum, qIndex, cleanTheme)
      subject.contains("වාණිජ") || subject.contains("ගිණුම්") -> getCommerceQuestion(grade, setNum, qIndex, cleanTheme)
      subject.contains("කෘෂි") -> getAgricultureQuestion(grade, setNum, qIndex, cleanTheme)
      subject.contains("පුරවැසි") -> getCivicsQuestion(grade, setNum, qIndex, cleanTheme)
      subject.contains("සෞඛ්‍ය") -> getHealthQuestion(grade, setNum, qIndex, cleanTheme)
      else -> getFallbackQuestion(subject, setNum, qIndex, cleanTheme)
    }
  }

  // ==========================================
  // SINHALA (සිංහල) - GRADE 10 & GRADE 11
  // ==========================================
  private fun getSinhalaQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return when (setNum) {
        1 -> when (qIndex) {
          1 -> Quintuple("උක්ත කර්තෘට අනුකූලව ක්‍රියා පදය යෙදීම හඳුන්වන්නේ කෙසේද?", "Matching verb to grammatical subject?", listOf("කර්තෘ-ක්‍රියා සම්බන්ධය", "ආඛ්‍යාත රීතිය"), "කර්තෘ-ක්‍රියා සම්බන්ධය (ආඛ්‍යාත රීතිය) නමිනි.", "කර්තෘට ක්‍රියාව ගැලපීමයි.")
          2 -> Quintuple("'ගොවීහු කුඹුරට _____' වාක්‍යයේ නිවැරදි ක්‍රියා පදය කුමක්ද? (යයි / යති)", "Correct verb for 'Gowihu kuburata _____'?", listOf("යති"), "යති (බහුවචන ප්‍රථම පුරුෂ ක්‍රියාව) වේ.", "යති වේ.")
          3 -> Quintuple("'මම පොතක් _____' හි නිවැරදි උත්තම පුරුෂ ඒකවචන ක්‍රියාව කුමක්ද? (කියවමි / කියවමු)", "Correct verb for 'Mama pothak _____'?", listOf("කියවමි"), "කියවමි යන්නයි.", "කියවමි වේ.")
          else -> Quintuple("'නුඹලා පාසල් _____' හි නිවැරදි මධ්‍යම පුරුෂ බහුවචන ක්‍රියාව කුමක්ද? (යවු / යව්)", "Correct verb for 'Numbala pasal _____'?", listOf("යවු", "යව්"), "යවු (හෝ යව්) වේ.", "යවු වේ.")
        }
        2 -> when (qIndex) {
          1 -> Quintuple("ප්‍රත්‍යය නොයෙදුණු මුල් පද කොටස හඳුන්වන්නේ ප්‍රකෘතිය ලෙසද ප්‍රත්‍යය ලෙසද?", "Base word without affixes called Prakruthiya?", listOf("ප්‍රකෘතිය", "ප්‍රකෘති"), "ප්‍රකෘතිය (Root) නමිනි.", "ප්‍රකෘතියයි.")
          2 -> Quintuple("නාම පදයකට පසුව එක්වන ප්‍රත්‍යය හඳුන්වන්නේ තද්ධිත ලෙසද කෘදන්ත ලෙසද?", "Suffix attached to nouns called Thaddhita or Krudanta?", listOf("තද්ධිත", "තද්ධිත ප්‍රත්‍යය"), "තද්ධිත ප්‍රත්‍යය නමිනි.", "තද්ධිත ප්‍රත්‍යයයි.")
          else -> Quintuple("ක්‍රියා ප්‍රකෘතියකට එක්වන ප්‍රත්‍යය කුමක්ද?", "Suffix attached to verbal root?", listOf("කෘදන්ත", "කෘදන්ත ප්‍රත්‍යය"), "කෘදන්ත ප්‍රත්‍යය නමිනි.", "කෘදන්තයි.")
        }
        3 -> when (qIndex) {
          1 -> Quintuple("'ගුරු + උතුමා' සන්ධි වූ විට සෑදෙන පදය කුමක්ද?", "Guru + uthuma combined?", listOf("ගුරුතුමා"), "ගුරුතුමා වේ (ස්වර සන්ධියකි).", "ගුරුතුමා වේ.")
          else -> Quintuple("ස්වරයක් හා ස්වරයක් එකතු වීමෙන් සිදුවන සන්ධිය කුමක්ද?", "Sandhi formed by merging two vowels?", listOf("ස්වර සන්ධිය"), "ස්වර සන්ධිය වේ.", "ස්වර සන්ධියයි.")
        }
        4 -> when (qIndex) {
          1 -> Quintuple("පද දෙකක් හෝ වැඩි ගණනක් අර්ථයෙන් එක්වීම කුමක්ද?", "Compounding words together?", listOf("සමාසය", "සමාස"), "සමාසය නමිනි.", "සමාසයයි.")
          else -> Quintuple("'නීල වූ උපුල' එක්වූ විට සෑදෙන සමාස පදය කුමක්ද?", "Neela wu upula compound?", listOf("නිලුපුල්"), "නිලුපුල් වේ.", "නිලුපුල් වේ.")
        }
        5 -> when (qIndex) {
          1 -> Quintuple("කර්ම කාරක වාක්‍යයක කර්තෘ පදය යෙදෙන්නේ කුමන විභක්තියෙන්ද?", "Case of agent in passive sentence?", listOf("තෘතියා", "තෘතියා විභක්තිය", "කරණ"), "තෘතියා (කරණ) විභක්තියෙනි (විසින් යෙදේ).", "තෘතියා විභක්තියෙනි.")
          else -> Quintuple("'ගොවියා විසින් වී වපුරනු ලැබේ' කුමන කාරක වාක්‍යයක්ද?", "What voice is 'Gowiya wisin wee wapuranu labe'?", listOf("කර්ම කාරක", "කර්මකාරක"), "කර්ම කාරක (Passive voice) වාක්‍යයකි.", "කර්ම කාරකයි.")
        }
        6 -> when (qIndex) {
          1 -> Quintuple("සිංහල හෝඩියේ මූර්ධජ 'ණ' සහ දන්තජ 'න' නිවැරදිව භාවිතය අක්ෂර වින්‍යාසයද?", "Is correct usage of Na and Na spelling rules?", listOf("ඔව්", "එසේය"), "ඔව්, අක්ෂර වින්‍යාස නීතියකි.", "ඔව් වේ.")
          else -> Quintuple("'කල්‍යාණ' වචනයේ යෙදෙන්නේ මූර්ධජ 'ණ' ද දන්තජ 'න' ද?", "Is Murdhaja Na used in 'Kalyana'?", listOf("මූර්ධජ ණ", "ණ"), "මූර්ධජ 'ණ' යෙදේ.", "මූර්ධජ ණ වේ.")
        }
        7 -> when (qIndex) {
          1 -> Quintuple("යමක් තවත් දෙයකට සමාන කර දැක්වීම කුමන අලංකාරයද?", "Figure of speech comparing one thing to another?", listOf("උපමා", "උපමාව", "උපමා අලංකාරය"), "උපමා අලංකාරය වේ.", "උපමාවයි.")
          else -> Quintuple("උපමාවක් හා උපමේයයක් අතර වෙනසක් නැති සේ දැක්වීම කුමක්ද?", "Metaphor identifying tenor and vehicle as one?", listOf("රූපක", "රූපකය", "රූපක අලංකාරය"), "රූපක අලංකාරය වේ.", "රූපකයයි.")
        }
        8 -> when (qIndex) {
          1 -> Quintuple("සම්භාව්‍ය ගද්‍ය කෘතියක් වන 'අමාවතුර' රචනා කළ කතුවරයා කවුද?", "Author of Amavatura?", listOf("ගුරුළුගෝමී"), "ගුරුළුගෝමී පණ්ඩිතයන් වේ.", "ගුරුළුගෝමී.")
          else -> Quintuple("'බුත්සරණ' ග්‍රන්ථය රචනා කළේ කවුද?", "Author of Buthsarana?", listOf("විද්‍යාචක්‍රවර්තී"), "විද්‍යාචක්‍රවර්තීන් වේ.", "විද්‍යාචක්‍රවර්තී.")
        }
        9 -> when (qIndex) {
          1 -> Quintuple("'කව්සිළුමිණ' මහා කාව්‍යය රචනා කළ රජතුමා කවුද?", "King who wrote Kavsilumina?", listOf("දෙවන පරාක්‍රමබාහු", "පරාක්‍රමබාහු"), "දෙවන පරාක්‍රමබාහු (කලිකාල සාහිත්‍ය සර්වඥ පණ්ඩිත) රජතුමාය.", "දෙවන පරාක්‍රමබාහු.")
          else -> Quintuple("'ගුත්තිල කාව්‍යය' රචනා කළ හිමියන් කවුද?", "Author of Guttila Kavya?", listOf("වෑත්තෑවේ", "වෑත්තෑවේ හිමි"), "වෑත්තෑවේ හිමියන් වේ.", "වෑත්තෑවේ හිමි.")
        }
        else -> when (qIndex) {
          1 -> Quintuple("'ගම්පෙරළිය' ලෝප්‍රකට නවකතාව රචනා කළ ශ්‍රේෂ්ඨ ලේඛකයා කවුද?", "Author of Gamperaliya?", listOf("මාර්ටින් වික්‍රමසිංහ", "වික්‍රමසිංහ"), "මාර්ටින් වික්‍රමසිංහ ශූරීන්ය.", "කොග්ගල ප්‍රාඥයාය.")
          else -> Quintuple("'මනමේ' සහ 'සිංහබාහු' නාට්‍ය නිර්මාණය කළ මහාචාර්යවරයා කවුද?", "Dramatist behind Maname and Sinhabahu?", listOf("සරච්චන්ද්‍ර", "එදිරිවීර සරච්චන්ද්‍ර"), "මහාචාර්ය එදිරිවීර සරච්චන්ද්‍රයන්ය.", "සරච්චන්ද්‍රයන්ය.")
        }
      }
    }

    // Grade 10 Sinhala
    return when (qIndex) {
      1 -> Quintuple("යම් පුද්ගලයෙකු, ස්ථානයක් හෝ වස්තුවක් හඳුන්වන පද වර්ගය කුමක්ද?", "Word denoting person, place or thing?", listOf("නාම පද", "නාම පදය"), "නාම පදය වේ.", "නාම පදයයි.")
      2 -> Quintuple("යම් කාර්යයක් හෝ ක්‍රියාවක් හැඟවෙන පද වර්ගය කුමක්ද?", "Word expressing action?", listOf("ක්‍රියා පද", "ක්‍රියා පදය"), "ක්‍රියා පදය වේ.", "ක්‍රියා පදයයි.")
      3 -> Quintuple("'ළමයා පොත කියවයි' හි ක්‍රියා පදය කුමක්ද?", "Verb in 'child reads book'?", listOf("කියවයි"), "කියවයි යන්නයි.", "කියවයි.")
      4 -> Quintuple("සිංහල හෝඩියේ ප්‍රධාන කොටස් 2 නම් ස්වර සහ අනෙක කුමක්ද?", "Vowels and what else in alphabet?", listOf("ව්‍යංජන", "ව්‍යංජන අක්ෂර"), "ව්‍යංජන අක්ෂර වේ.", "ව්‍යංජනයි.")
      5 -> Quintuple("සිංහල භාෂාවේ සාම්ප්‍රදායිකව පිළිගත් විභක්ති ගණන කීයද?", "How many noun cases in Sinhala?", listOf("9", "9ක්", "නවයක්"), "විභක්ති 9කි.", "9කි.")
      6 -> Quintuple("ක්‍රියාව කරන තැනැත්තා හඟවන මුල්ම විභක්තිය කුමක්ද?", "First nominative case?", listOf("ප්‍රථමා", "ප්‍රථමා විභක්තිය"), "ප්‍රථමා විභක්තිය වේ.", "ප්‍රථමා විභක්තියයි.")
      7 -> Quintuple("අයිතිය දක්වන 'ගේ' ප්‍රත්‍යය යෙදෙන විභක්තිය කුමක්ද?", "Genitive/possessive case with 'ge'?", listOf("සම්බන්ධ", "සම්බන්ධ විභක්තිය"), "සම්බන්ධ විභක්තිය වේ.", "සම්බන්ධ විභක්තියයි.")
      8 -> Quintuple("විරුද්ධ පදයක් පවසන්න: 'උදෑසන' හි විරුද්ධ පදය කුමක්ද?", "Opposite of morning (udhasana)?", listOf("සවස", "සවස්වරුව"), "සවස වේ.", "සවස.")
      9 -> Quintuple("'ආලෝකය' හි විරුද්ධ පදය කුමක්ද?", "Opposite of light (alokaya)?", listOf("අන්ධකාරය", "අඳුර"), "අන්ධකාරය වේ.", "අන්ධකාරය.")
      10 -> Quintuple("සමාන පදයක් පවසන්න: 'හිරු' සඳහා සමාන පදයක් කුමක්ද?", "Synonym for sun (hiru)?", listOf("සූර්යයා", "දිනකර", "භානු"), "සූර්යයා හෝ දිනකර වේ.", "සූර්යයා.")
      else -> Quintuple("සිංහල භාෂාව ශ්‍රී ලංකාවේ නිල රාජ්‍ය භාෂාවක්ද?", "Is Sinhala official state language?", listOf("ඔව්", "එසේය"), "ඔව්, නිල රාජ්‍ය භාෂාවකි.", "ඔව් වේ.")
    }
  }

  // ==========================================
  // COMMERCE (වාණිජ හා ගිණුම්කරණය) - GRADE 10 & 11
  // ==========================================
  private fun getCommerceQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return when (setNum) {
        1 -> when (qIndex) {
          1 -> Quintuple("මුදල් පොතේ බැංකු තීරුව හා බැංකු ප්‍රකාශනය අතර වෙනස්කම් සංසන්දනය කර සකසන ප්‍රකාශය කුමක්ද?", "Statement reconciling cash book bank column and bank statement?", listOf("බැංකු සැසඳුම් ප්‍රකාශය", "Bank Reconciliation"), "බැංකු සැසඳුම් ප්‍රකාශය (Bank Reconciliation Statement) වේ.", "බැංකු සැසඳුම් ප්‍රකාශයයි.")
          else -> Quintuple("ගෙවීම් සඳහා නිකුත් කළ නමුත් තවමත් බැංකුවෙන් මුදල් ලබා නොගත් චෙක්පත් හඳුන්වන්නේ කෙසේද?", "Cheques issued but not yet presented for payment?", listOf("නොඉදිරිපත් කළ චෙක්පත්"), "නොඉදිරිපත් කළ චෙක්පත් (Unpresented cheques) නමිනි.", "නොඉදිරිපත් කළ චෙක්පත්ය.")
        }
        2 -> when (qIndex) {
          1 -> Quintuple("ශේෂ පිරික්සුම සමතුලිත නොවූ විට වෙනස තාවකාලිකව රඳවා තබන ගිණුම කුමක්ද?", "Temporary account holding difference when trial balance doesn't balance?", listOf("අත්හිටවූ ගිණුම", "Suspense Account"), "අත්හිටවූ ගිණුම (Suspense Account) වේ.", "අත්හිටවූ ගිණුමයි.")
          else -> Quintuple("ගනුදෙනුවක් මුළුමනින්ම සටහන් කිරීම මඟහැරී යාම කුමන දෝෂයක්ද?", "Complete omission of a transaction?", listOf("අතපසුවීමේ දෝෂය", "Error of Omission"), "අතපසුවීමේ දෝෂය (Error of Omission) වේ.", "අතපසුවීමේ දෝෂයයි.")
        }
        3 -> when (qIndex) {
          1 -> Quintuple("ගිණුම් වර්ෂය අවසානයේ ගෙවීමට ඇති නමුත් තවමත් නොගෙවූ වියදම් හඳුන්වන්නේ කෙසේද?", "Expenses incurred but not yet paid at year end?", listOf("ගෙවිය යුතු වියදම්", "Accrued Expenses"), "ගෙවිය යුතු වියදම් (Accrued expenses) නමිනි.", "ගෙවිය යුතු වියදම්ය.")
          else -> Quintuple("ජංගම නොවන වත්කම් භාවිතය නිසා සිදුවන වටිනාකම අඩුවීම කුමක්ද?", "Fall in value of non-current assets over time?", listOf("ක්ෂයවීම", "ක්ෂය", "Depreciation"), "ක්ෂයවීම (Depreciation) නමිනි.", "ක්ෂයවීමයි.")
        }
        4 -> when (qIndex) {
          1 -> Quintuple("ව්‍යාපාරයක මූල්‍ය තත්ත්වය (වත්කම්, වගකීම්, හිමිකම) පෙන්වන ප්‍රකාශනය කුමක්ද?", "Statement showing assets, liabilities and equity?", listOf("මූල්‍ය තත්ත්ව ප්‍රකාශනය", "ශේෂ පත්‍රය", "Balance Sheet"), "මූල්‍ය තත්ත්ව ප්‍රකාශනය (ශේෂ පත්‍රය) වේ.", "ශේෂ පත්‍රයයි.")
          else -> Quintuple("වසරකට අඩු කාලයකදී මුදල් බවට පත්කළ හැකි වත්කම් හඳුන්වන්නේ කෙසේද?", "Assets convertible to cash within one year?", listOf("ජංගම වත්කම්", "Current Assets"), "ජංගම වත්කම් (Current Assets) නමිනි.", "ජංගම වත්කම්ය.")
        }
        5 -> when (qIndex) {
          1 -> Quintuple("ලාභ නොලබන සුභසාධක සංවිධාන මුදල් ගනුදෙනු සටහන් කිරීමට තබන ගිණුම කුමක්ද?", "Account used by non-profit orgs for cash transactions?", listOf("ලදුපත් හා ගෙවීම් ගිණුම", "Receipts and Payments"), "ලදුපත් හා ගෙවීම් ගිණුම (Receipts & Payments Account) වේ.", "ලදුපත් හා ගෙවීම් ගිණුමයි.")
          else -> Quintuple("ලාභ නොලබන සංවිධානයක ලාභාලාභ ගිණුම වෙනුවට සකසන ගිණුම කුමක්ද?", "Income statement equivalent for non-profit entities?", listOf("ආදායම් වියදම් ගිණුම", "Income and Expenditure"), "ආදායම් හා වියදම් ගිණුම (Income & Expenditure Account) වේ.", "ආදායම් හා වියදම් ගිණුමයි.")
        }
        6 -> when (qIndex) {
          1 -> Quintuple("නිෂ්පාදනයක් සඳහා සෘජු ද්‍රව්‍ය හා සෘජු ශ්‍රමයේ එකතුව කුමක්ද?", "Direct Material + Direct Labor equals what?", listOf("ප්‍රාථමික පිරිවැය", "Prime Cost"), "ප්‍රාථමික පිරිවැය (Prime Cost) වේ.", "ප්‍රාථමික පිරිවැයයි.")
          else -> Quintuple("නිෂ්පාදනය වෙනස් වන විට ඊට සමානුපාතිකව වෙනස් වන පිරිවැය කුමක්ද?", "Cost that varies directly with output?", listOf("විචල්‍ය පිරිවැය", "Variable Cost"), "විචල්‍ය පිරිවැය (Variable Cost) වේ.", "විචල්‍ය පිරිවැයයි.")
        }
        7 -> when (qIndex) {
          1 -> Quintuple("ජංගම වත්කම් බෙදීම ජංගම වගකීම් මඟින් ගණනය කරන අනුපාතය කුමක්ද?", "Current Assets divided by Current Liabilities?", listOf("ජංගම අනුපාතය", "Current Ratio"), "ජංගම අනුපාතය (Current Ratio) වේ.", "ජංගම අනුපාතයයි.")
          else -> Quintuple("කෙටි කාලීන ණය පියවීමේ හැකියාව මනින ගුණය කුමක්ද?", "Ability to pay short-term debt?", listOf("ද්‍රවශීලතාව", "Liquidity"), "ද්‍රවශීලතාව (Liquidity) වේ.", "ද්‍රවශීලතාවයි.")
        }
        8 -> when (qIndex) {
          1 -> Quintuple("ව්‍යාපාරයක් ආරම්භ කිරීමට පෙර සකස් කරන මාර්ගෝපදේශ සැලැස්ම කුමක්ද?", "Formal statement of business goals and road map?", listOf("ව්‍යාපාර සැලැස්ම", "Business Plan"), "ව්‍යාපාර සැලැස්ම (Business Plan) වේ.", "ව්‍යාපාර සැලැස්මයි.")
          else -> Quintuple("ව්‍යාපාර සැලැස්මක ආරම්භයේ ඇති සමස්ත සාරාංශය හඳුන්වන්නේ කෙසේද?", "Short summary at start of business plan?", listOf("විධායක සාරාංශය", "Executive Summary"), "විධායක සාරාංශය (Executive Summary) නමිනි.", "විධායක සාරාංශයයි.")
        }
        9 -> when (qIndex) {
          1 -> Quintuple("ශ්‍රී ලංකාවේ භාණ්ඩ හා සේවා මත පනවන ප්‍රධාන වක්‍ර බද්ද කුමක්ද?", "Main indirect tax on goods and services in Sri Lanka?", listOf("වැට් බද්ද", "VAT"), "වැට් බද්ද (Value Added Tax / VAT) වේ.", "වැට් බද්දයි.")
          else -> Quintuple("පාරිභෝගිකයන් අසාධාරණයෙන් ආරක්ෂා කරන ශ්‍රී ලංකාවේ ප්‍රධාන රාජ්‍ය ආයතනය කුමක්ද?", "Consumer protection authority in Sri Lanka?", listOf("පාරිභෝගික කටයුතු අධිකාරිය", "CAA"), "පාරිභෝගික කටයුතු පිළිබඳ අධිකාරිය වේ.", "පාරිභෝගික අධිකාරියයි.")
        }
        else -> when (qIndex) {
          1 -> Quintuple("රටකින් භාණ්ඩ පිටරටට යැවීම හඳුන්වන්නේ ආනයනය ලෙසද අපනයනය ලෙසද?", "Selling goods to foreign countries is import or export?", listOf("අපනයනය", "Export"), "අපනයනය (Export) නමිනි.", "අපනයනයයි.")
          2 -> Quintuple("පිටරටින් භාණ්ඩ මෙරටට ගෙන්වීම හඳුන්වන්නේ කෙසේද?", "Buying goods from abroad into home country?", listOf("ආනයනය", "Import"), "ආනයනය (Import) නමිනි.", "ආනයනයයි.")
          else -> Quintuple("රටක මුළු අපනයන ආදායම සහ මුළු ආනයන වියදම අතර වෙනස කුමක්ද?", "Difference between total exports and imports of goods?", listOf("වෙළඳ ශේෂය", "Balance of Trade"), "වෙළඳ ශේෂය (Balance of Trade) වේ.", "වෙළඳ ශේෂයයි.")
        }
      }
    }

    // Grade 10 Commerce
    return when (qIndex) {
      1 -> Quintuple("මිනිසාට ජීවත් වීමට අත්‍යවශ්‍යම දේ හඳුන්වන්නේ අවශ්‍යතා ලෙසද උවමනා ලෙසද?", "Essentials to live called Needs or Wants?", listOf("අවශ්‍යතා", "needs"), "අවශ්‍යතා (Needs) නමිනි.", "අවශ්‍යතා වේ.")
      2 -> Quintuple("මූලික මිනිස් අවශ්‍යතාවකට ප්‍රධාන උදාහරණයක් පවසන්න.", "Example of basic human need?", listOf("ආහාර", "ඇඳුම්", "නිවාස"), "ආහාර, ඇඳුම් හෝ නිවාස වේ.", "ආහාර / නිවාස.")
      3 -> Quintuple("අවශ්‍යතා තෘප්තිමත් කරගන්නා විවිධ ක්‍රම හඳුන්වන්නේ කෙසේද?", "Ways of satisfying needs?", listOf("උවමනා", "wants"), "උවමනා (Wants) නමිනි.", "උවමනා වේ.")
      4 -> Quintuple("තනි පුද්ගලයෙකු විසින් අයිතිවාසිකම දරන ව්‍යාපාරය කුමක්ද?", "Business owned by single person?", listOf("තනි පුද්ගල", "තනි ව්‍යාපාර"), "තනි පුද්ගල ව්‍යාපාර වේ.", "තනි පුද්ගලයි.")
      5 -> Quintuple("ශ්‍රී ලංකාවේ මුදල් නෝට්ටු මුද්‍රණය කරන ප්‍රධානම බැංකුව කුමක්ද?", "Bank printing currency notes in Sri Lanka?", listOf("මහ බැංකුව", "ශ්‍රී ලංකා මහ බැංකුව", "Central Bank"), "ශ්‍රී ලංකා මහ බැංකුව වේ.", "මහ බැංකුවයි.")
      6 -> Quintuple("ගිණුම්කරණයේ ද්විත්ව සටහන් රීතියට අනුව එක් ගනුදෙනුවකට පැති කීයක් තිබේද?", "Sides in double entry rule?", listOf("2", "දෙකක්", "හර සහ බැර"), "පැති 2කි (හර සහ බැර).", "හර සහ බැර.")
      7 -> Quintuple("මුදල් ලැබීම් සහ මුදල් ගෙවීම් සටහන් කරන ප්‍රධාන පොත කුමක්ද?", "Book recording cash receipts and payments?", listOf("මුදල් පොත", "Cash book"), "මුදල් පොත (Cash Book) වේ.", "මුදල් පොතයි.")
      8 -> Quintuple("ආදායම් වියදම්වලට වඩා වැඩි වූ විට ලැබෙන්නේ ලාභයක්ද අලාභයක්ද?", "When income exceeds expenses, is it profit or loss?", listOf("ලාභයක්", "ලාභය", "Profit"), "ලාභයක් (Net Profit) ලැබේ.", "ලාභයක් වේ.")
      else -> Quintuple("ව්‍යාපාරයක මූලික අරමුණ ලාභ ලැබීමද?", "Is primary business goal earning profit?", listOf("ඔව්", "එසේය"), "ඔව්, ලාභ ඉපැයීමයි.", "ඔව් වේ.")
    }
  }

  // ==========================================
  // AGRICULTURE (කෘෂිකර්මය) - GRADE 10 & 11
  // ==========================================
  private fun getAgricultureQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return when (setNum) {
        1 -> when (qIndex) {
          1 -> Quintuple("ඒකාබද්ධ පළිබෝධ කළමනාකරණය හඳුන්වන කෙටි නම කුමක්ද?", "Integrated Pest Management abbreviation?", listOf("IPM"), "IPM (Integrated Pest Management) වේ.", "IPM වේ.")
          else -> Quintuple("IPM හි පළිබෝධ මර්දනයට කෘමිනාශක යොදාගන්නේ ප්‍රථම විකල්පය ලෙසද අවසන් විකල්පය ලෙසද?", "In IPM, are chemicals used as first or last resort?", listOf("අවසන් විකල්පය", "අවසානයට"), "අවසාන විකල්පය ලෙස පමණි.", "අවසාන විකල්පයයි.")
        }
        2 -> when (qIndex) {
          1 -> Quintuple("කෘෂි රසායන ඉසින විට මුඛ ආවරණ හා අත්වැසුම් පැළඳීම අනිවාර්යද?", "Is wearing masks and gloves mandatory when spraying agrochemicals?", listOf("ඔව්", "අනිවාර්යයි"), "ඔව්, විෂ ශරීරගත වීම වැළැක්වීමට අනිවාර්යයි.", "ඔව් වේ.")
          else -> Quintuple("කෘමිනාශක ඉසීමෙන් පසු අස්වනු නෙළීමට පෙර ගතවිය යුතු අවම කාලය කුමක්ද?", "Pre-harvest interval before picking crops?", listOf("පූර්ව අස්වනු කාලය", "PHI"), "පූර්ව අස්වනු කාලය (PHI) නමිනි.", "පූර්ව අස්වනු කාලයයි.")
        }
        3 -> when (qIndex) {
          1 -> Quintuple("එළවළු සහ පලතුරු ප්‍රවාහනයේදී තැලීම් අවම කිරීමට භාවිත කළ යුතු සුදුසු බහාලුම කුමක්ද?", "Container to minimize damage when transporting fruits?", listOf("ප්ලාස්ටික් කූඩ", "ප්ලාස්ටික් කූඩය"), "ප්ලාස්ටික් කූඩ (Plastic crates) වේ.", "ප්ලාස්ටික් කූඩයි.")
          else -> Quintuple("අස්වනු නෙළීමෙන් පසු සිදුවන හානි අවම කිරීමේ තාක්ෂණය කුමක්ද?", "Technology reducing damage after harvesting?", listOf("පශ්චාත් අස්වනු තාක්ෂණය", "Post harvest"), "පශ්චාත් අස්වනු තාක්ෂණය වේ.", "පශ්චාත් අස්වනු තාක්ෂණයයි.")
        }
        else -> when (qIndex) {
          1 -> Quintuple("පස් රහිතව පෝෂක ද්‍රාවණ තුළ පමණක් එළවළු වගා කිරීම හඳුන්වන්නේ කෙසේද?", "Growing plants in nutrient solution without soil?", listOf("හයිඩ්‍රොපොනික්ස්", "ජල රෝපණය", "Hydroponics"), "හයිඩ්‍රොපොනික්ස් (Hydroponics) නමිනි.", "හයිඩ්‍රොපොනික්ස් වේ.")
          2 -> Quintuple("මසුන් ඇතිකිරීම සහ එළවළු වගාව එකට සම්බන්ධ කරන පද්ධතිය කුමක්ද?", "Combining aquaculture with hydroponics?", listOf("ඇක්වාපොනික්ස්", "Aquaponics"), "ඇක්වාපොනික්ස් (Aquaponics) වේ.", "ඇක්වාපොනික්ස් වේ.")
          else -> Quintuple("කාබනික ගොවිතැන පස සහ ජලය ආරක්ෂා කරන පරිසර හිතකාමී ක්‍රමයක්ද?", "Is organic farming eco-friendly?", listOf("ඔව්", "එසේය"), "ඔව්, පරිසර හිතකාමී වේ.", "ඔව් වේ.")
        }
      }
    }

    // Grade 10 Agriculture
    return when (qIndex) {
      1 -> Quintuple("ශාක වර්ධනයට අවශ්‍ය ප්‍රධාන පෝෂක මූලද්‍රව්‍ය 3 (NPK) මොනවාද?", "Three primary plant nutrients (NPK)?", listOf("නයිට්‍රජන් පොස්පරස් පොටෑසියම්", "නයිට්‍රජන්", "N P K"), "නයිට්‍රජන් (N), පොස්පරස් (P) සහ පොටෑසියම් (K) වේ.", "N, P, K වේ.")
      2 -> Quintuple("කොළ පැහැති පත්‍ර වර්ධනයට අවශ්‍ය ප්‍රධාන පෝෂකය කුමක්ද?", "Nutrient for leafy vegetative growth?", listOf("නයිට්‍රජන්", "N", "යූරියා"), "නයිට්‍රජන් (N) වේ.", "නයිට්‍රජන් වේ.")
      3 -> Quintuple("මුල් පද්ධතිය ශක්තිමත්ව වැඩීමට අවශ්‍ය ප්‍රධාන පෝෂකය කුමක්ද?", "Nutrient for strong root growth?", listOf("පොස්පරස්", "P"), "පොස්පරස් (P) වේ.", "පොස්පරස් වේ.")
      4 -> Quintuple("බොහෝ බෝග වගාවට සුදුසු උදාසීන පසක pH අගය කීයද?", "pH value of neutral soil suitable for crops?", listOf("6.5 - 7.5", "7", "හත"), "6.5 සිට 7.0 (උදාසීන) පමණ වේ.", "pH 7 පමණයි.")
      5 -> Quintuple("ජලය බිංදු වශයෙන් කෙලින්ම මුල් කලාපයට ලබාදෙන ක්‍රමය කුමක්ද?", "Method applying water drops directly to roots?", listOf("බිංදු ජල සම්පාදනය", "බිංදු"), "බිංදු ජල සම්පාදනය (Drip irrigation) වේ.", "බිංදු ජල සම්පාදනයයි.")
      else -> Quintuple("කාබනික ගොවිතැන පරිසර හිතකාමීද?", "Is organic farming eco-friendly?", listOf("ඔව්", "එසේය"), "ඔව්, පරිසර හිතකාමී වේ.", "ඔව් වේ.")
    }
  }

  // ==========================================
  // CIVICS (පුරවැසි අධ්‍යාපනය) - GRADE 10 & 11
  // ==========================================
  private fun getCivicsQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return when (setNum) {
        1 -> when (qIndex) {
          1 -> Quintuple("රටේ පාලකයන් ඇතුළු සියලු පුරවැසියන් නීතියට යටත් වීම හඳුන්වන්නේ කෙසේද?", "Principle that all people and institutions are accountable to law?", listOf("නීතියේ ආධිපත්‍යය", "Rule of Law"), "නීතියේ ආධිපත්‍යය (Rule of Law) නමිනි.", "නීතියේ ආධිපත්‍යයයි.")
          else -> Quintuple("රටක උත්තරීතරම මූලික නීති සංග්‍රහය කුමක්ද?", "Supreme law of the land?", listOf("ආණ්ඩුක්‍රම ව්‍යවස්ථාව", "ව්‍යවස්ථාව"), "ආණ්ඩුක්‍රම ව්‍යවස්ථාව (Constitution) වේ.", "ආණ්ඩුක්‍රම ව්‍යවස්ථාවයි.")
        }
        2 -> when (qIndex) {
          1 -> Quintuple("ශ්‍රී ලංකා පාර්ලිමේන්තුවේ මුළු මන්ත්‍රී ආසන සංඛ්‍යාව කීයද?", "Total seats in Sri Lanka Parliament?", listOf("225", "225ක්", "දෙසිය විසිපහ"), "මන්ත්‍රී ආසන 225 කි.", "225 කි.")
          else -> Quintuple("පාර්ලිමේන්තුවේ නීති සම්පාදනය සඳහා ඉදිරිපත් කරන කෙටුම්පතක් හඳුන්වන්නේ කෙසේද?", "Proposed legislation presented to parliament?", listOf("පනත් කෙටුම්පත", "Bill"), "පනත් කෙටුම්පතක් (Bill) නමිනි.", "පනත් කෙටුම්පතයි.")
        }
        else -> when (qIndex) {
          1 -> Quintuple("ශ්‍රී ලංකාවේ උත්තරීතරම ඉහළම අධිකරණය කුමක්ද?", "Highest and apex court in Sri Lanka?", listOf("ශ්‍රේෂ්ඨාධිකරණය", "Supreme Court"), "ශ්‍රේෂ්ඨාධිකරණය (Supreme Court) වේ.", "ශ්‍රේෂ්ඨාධිකරණයයි.")
          2 -> Quintuple("මූලික අයිතිවාසිකම් කඩවීමක් පිළිබඳ නඩු පැවරිය හැක්කේ කුමන අධිකරණයටද?", "Court with jurisdiction over fundamental rights violations?", listOf("ශ්‍රේෂ්ඨාධිකරණය", "Supreme Court"), "ශ්‍රේෂ්ඨාධිකරණයට පමණි.", "ශ්‍රේෂ්ඨාධිකරණයයි.")
          else -> Quintuple("ශ්‍රී ලංකාවේ ඡන්දය ප්‍රකාශ කිරීමට හිමිවන අවම වයස් සීමාව කීයද?", "Minimum voting age?", listOf("18", "අවුරුදු 18"), "අවුරුදු 18 කි.", "වයස 18යි.")
        }
      }
    }

    // Grade 10 Civics
    return when (qIndex) {
      1 -> Quintuple("මහජන ඡන්දයෙන් පාලකයන් තෝරාගන්නා පාලන ක්‍රමය කුමක්ද?", "System where rulers are elected by people?", listOf("ප්‍රජාතන්ත්‍රවාදය", "Democracy"), "ප්‍රජාතන්ත්‍රවාදය (Democracy) වේ.", "ප්‍රජාතන්ත්‍රවාදයයි.")
      2 -> Quintuple("රටේ නීති සම්පාදනය කරන උත්තරීතර ආයතනය කුමක්ද?", "Supreme body making laws of the country?", listOf("පාර්ලිමේන්තුව", "Parliament"), "ශ්‍රී ලංකා පාර්ලිමේන්තුව වේ.", "පාර්ලිමේන්තුවයි.")
      3 -> Quintuple("ශ්‍රී ලංකා පාර්ලිමේන්තුවේ මුළු මන්ත්‍රී ආසන ගණන කීයද?", "Total seats in Sri Lanka Parliament?", listOf("225", "225ක්", "දෙසිය විසිපහ"), "මන්ත්‍රී ආසන 225 කි.", "225 කි.")
      4 -> Quintuple("ශ්‍රී ලංකාවේ රාජ්‍ය නායකයා සහ සේනාධිනායකයා කවුද?", "Head of State and Commander in Chief?", listOf("ජනාධිපති", "ජනාධිපතිවරයා", "President"), "විධායක ජනාධිපතිවරයා වේ.", "ජනාධිපතිවරයායි.")
      5 -> Quintuple("ශ්‍රී ලංකාවේ උසස්ම සහ ඉහළම අධිකරණය කුමක්ද?", "Highest and apex court in Sri Lanka?", listOf("ශ්‍රේෂ්ඨාධිකරණය", "Supreme Court"), "ශ්‍රේෂ්ඨාධිකරණය (Supreme Court) වේ.", "ශ්‍රේෂ්ඨාධිකරණයයි.")
      6 -> Quintuple("ශ්‍රී ලංකාවේ ඡන්ද බලය හිමිවන අවම වයස් සීමාව කීයද?", "Minimum voting age in Sri Lanka?", listOf("18", "අවුරුදු 18", "18ක්"), "වයස අවුරුදු 18 කි.", "වයස 18යි.")
      else -> Quintuple("හොඳ පුරවැසියෙකු රටේ නීතිගරුකව ජීවත් විය යුතුද?", "Should a good citizen obey the law?", listOf("ඔව්", "එසේය"), "ඔව්, නීතියට ගරු කළ යුතුය.", "ඔව් වේ.")
    }
  }

  // ==========================================
  // HEALTH (සෞඛ්‍යය හා ශාරීරික) - GRADE 10 & 11
  // ==========================================
  private fun getHealthQuestion(grade: String, setNum: Int, qIndex: Int, theme: String): Quintuple<String, String, List<String>, String, String> {
    if (grade == "11") {
      return when (setNum) {
        1 -> when (qIndex) {
          1 -> Quintuple("රුධිරයේ අධික සීනි මට්ටම නිසා ඇතිවන බෝනොවන රෝගය කුමක්ද?", "Non-communicable disease caused by high blood sugar?", listOf("දියවැඩියාව", "Diabetes"), "දියවැඩියාව (Diabetes) වේ.", "දියවැඩියාවයි.")
          else -> Quintuple("හෘදයාබාධ හා අධිරුධිර පීඩනය වැළැක්වීමට ආහාරයේ අවම කළ යුතු ද්‍රව්‍ය 2 මොනවාද?", "Two things to minimize in diet to prevent heart disease?", listOf("ලුණු සහ තෙල්", "සීනි සහ ලුණු", "තෙල්"), "ලුණු (සෝඩියම්) සහ තෙල් (මේදය) වේ.", "ලුණු සහ තෙල්ය.")
        }
        2 -> when (qIndex) {
          1 -> Quintuple("ශරීරයේ ප්‍රතිශක්තිය ලබාදීමට කුඩා කල ලබාදෙන එන්නත් ක්‍රමය කුමක්ද?", "Vaccination system for building immunity?", listOf("ප්‍රතිශක්තිකරණ එන්නත්", "එන්නත්කරණය", "Immunization"), "ප්‍රතිශක්තිකරණ එන්නත්කරණය වේ.", "එන්නත්කරණයයි.")
          else -> Quintuple("ඩෙංගු රෝගය බෝ කරන මදුරුවා කුමක්ද?", "Mosquito transmitting dengue?", listOf("ඊඩිස්", "Aedes"), "ඊඩිස් (Aedes) මදුරුවා වේ.", "ඊඩිස් මදුරුවායි.")
        }
        3 -> when (qIndex) {
          1 -> Quintuple("හෘදය සහ ශ්වසනය නැවතුණු හදිසි අවස්ථාවකදී ලබාදෙන ජීවිතාරක්ෂක ප්‍රථමාධාරය කුමක්ද?", "Cardiopulmonary resuscitation abbreviation?", listOf("CPR", "සීපීආර්"), "CPR (Cardiopulmonary Resuscitation) වේ.", "CPR වේ.")
          else -> Quintuple("ශ්‍රී ලංකාවේ නොමිලේ ලැබෙන සුවසැරිය ගිලන්රථ සේවයේ හදිසි දුරකථන අංකය කුමක්ද?", "Emergency Suwaseriya ambulance phone number?", listOf("1990"), "1990 වේ.", "1990 වේ.")
        }
        else -> when (qIndex) {
          1 -> Quintuple("ශ්‍රී ලංකාවේ ජාතික ක්‍රීඩාව කුමක්ද?", "National sport of Sri Lanka?", listOf("වොලිබෝල්", "Volleyball"), "වොලිබෝල් ක්‍රීඩාව වේ.", "වොලිබෝල් වේ.")
          else -> Quintuple("නීරෝගී ශරීරයක් පවත්වා ගැනීමට දිනපතා ව්‍යායාම හා ප්‍රමාණවත් නින්ද වැදගත්ද?", "Are daily exercise and adequate sleep vital for health?", listOf("ඔව්", "එසේය"), "ඔව්, නිරෝගී දිවියට ඉතා වැදගත් වේ.", "ඔව් වේ.")
        }
      }
    }

    // Grade 10 Health
    return when (qIndex) {
      1 -> Quintuple("නිරෝගී ජීවිතයකට ශරීරයට අවශ්‍ය සියලු පෝෂ්‍ය පදාර්ථ නිසි ප්‍රමාණයෙන් අඩංගු ආහාර වේල කුමක්ද?", "Diet containing all nutrients in proper amounts?", listOf("සමබල ආහාර වේල", "සමබල ආහාර"), "සමබල ආහාර වේලක් (Balanced diet) වේ.", "සමබල ආහාර වේලයි.")
      2 -> Quintuple("ශරීරයේ උසට සරිලන බර මනින දර්ශකය කුමක්ද?", "Index measuring weight against height?", listOf("BMI", "ශරීර ස්කන්ධ දර්ශකය"), "BMI (Body Mass Index) වේ.", "BMI වේ.")
      3 -> Quintuple("ඩෙංගු රෝගය බෝ කරන මදුරුවා කුමක්ද?", "Mosquito spreading dengue fever?", listOf("ඊඩිස්", "Aedes", "ඊඩිස් මදුරුවා"), "ඊඩිස් (Aedes) මදුරුවා වේ.", "ඊඩිස් මදුරුවායි.")
      4 -> Quintuple("හදිසි අනතුරකදී වෛද්‍යවරයෙකු වෙත ගෙන යාමට පෙර දෙන ක්ෂණික උපකාරය කුමක්ද?", "Immediate help given before doctor arrives?", listOf("ප්‍රථමාධාර", "First Aid"), "ප්‍රථමාධාර (First Aid) වේ.", "ප්‍රථමාධාරයි.")
      5 -> Quintuple("ශ්‍රී ලංකාවේ නොමිලේ ලැබෙන සුවසැරිය ගිලන්රථ සේවයේ හදිසි දුරකථන අංකය කුමක්ද?", "Emergency Suwaseriya ambulance phone number?", listOf("1990"), "1990 වේ.", "1990 වේ.")
      else -> Quintuple("ශ්‍රී ලංකාවේ ජාතික ක්‍රීඩාව කුමක්ද?", "National sport of Sri Lanka?", listOf("වොලිබෝල්", "Volleyball"), "වොලිබෝල් ක්‍රීඩාව වේ.", "වොලිබෝල් වේ.")
    }
  }

  // ==========================================
  // SAFE FALLBACK (NO FORMULAS, DIRECT FACTUAL)
  // ==========================================
  private fun getFallbackQuestion(
    subject: String,
    setNum: Int,
    qIndex: Int,
    cleanTheme: String
  ): Quintuple<String, String, List<String>, String, String> {
    val simpleFallback = listOf(
      Quintuple("$cleanTheme ඒකකයේ මූලික සංකල්පය කුමක්ද?", "Key concept of $cleanTheme?", listOf(cleanTheme.split(" ").firstOrNull() ?: subject, "මූලික සංකල්පය"), "$cleanTheme ආශ්‍රිත ප්‍රධාන පාඩම් කරුණයි.", "පාඩමේ මූලික කරුණ සලකන්න."),
      Quintuple("$cleanTheme සඳහා විෂය නිර්දේශයේ ඇති ප්‍රධාන උදාහරණය කුමක්ද?", "Example of $cleanTheme?", listOf("උදාහරණය", "නිදසුන"), "$cleanTheme හි ප්‍රධාන උදාහරණය වේ.", "පෙළපොතේ උදාහරණය සිහිපත් කරන්න."),
      Quintuple("$cleanTheme මඟින් අපට ලැබෙන ප්‍රධාන ප්‍රයෝජනය කුමක්ද?", "Benefit of $cleanTheme?", listOf("ප්‍රයෝජනය", "වැදගත්කම"), "එදිනෙදා ජීවිතයට හෝ විභාගයට ඇති වැදගත්කමයි.", "ප්‍රයෝජනය සලකන්න."),
      Quintuple("$cleanTheme හා සම්බන්ධ ප්‍රධාන වචනයක් නම් කරන්න.", "Key term for $cleanTheme?", listOf(cleanTheme.split(" ").lastOrNull() ?: subject), "$cleanTheme ආශ්‍රිත නිල විෂය පදය වේ.", "පාඩමේ නම සිහිපත් කරන්න."),
      Quintuple("$cleanTheme අදාළ වන්නේ ශ්‍රී ලංකාවේ විෂය නිර්දේශයටද?", "Is $cleanTheme in Sri Lankan curriculum?", listOf("ඔව්", "එසේය"), "ඔව්, සාමාන්‍ය පෙළ නිල විෂය නිර්දේශයට අයත් වේ.", "ඔව් වේ.")
    )
    val entry = simpleFallback[(qIndex - 1) % simpleFallback.size]
    return entry
  }
}
